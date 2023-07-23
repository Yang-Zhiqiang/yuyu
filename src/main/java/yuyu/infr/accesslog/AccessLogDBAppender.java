package yuyu.infr.accesslog;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;

import jp.co.slcs.swak.core.accesslog.AccessLog;
import jp.co.slcs.swak.core.accesslog.AccessLogProp;
import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.core.logger.LoggerFactory;
import jp.co.slcs.swak.core.resource.ConfigFile;
import jp.co.slcs.swak.db.exception.SwakDbException;
import jp.co.slcs.swak.db.util.EntityPreparedStatement;
import jp.co.slcs.swak.uniquekey.UniqueKeyGenerator;

import org.slf4j.Logger;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.xml.sax.SAXException;

import yuyu.def.classification.C_AccessLogSyubetuKbn;
import yuyu.def.db.entity.AT_AccessLog;
import yuyu.def.db.entity.AT_AccessLogSyousai;
import ch.qos.logback.classic.spi.ILoggingEvent;
import ch.qos.logback.core.UnsynchronizedAppenderBase;
import ch.qos.logback.core.db.ConnectionSource;

import com.google.common.base.Function;
import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;

/**
 * アクセスログの DBAppender です。<br />
 * {@link AccessLog} で出力したロギングデータを DB の
 * 「アクセスログテーブル」「アクセス詳細ログテーブル」に書き出します。
 */
public class AccessLogDBAppender extends UnsynchronizedAppenderBase<ILoggingEvent> {

    private static Logger logger = LoggerFactory.getLogger(AccessLogDBAppender.class);

    private static int retryTimes = -1;

    private static long intervalMilliTime = -1L;

    private static final String kousinsyaId     = "accessLog";
    private static final String kousinKinou     = "accessLog";
    private static final int    detailMaxLength = 666;

    private ConnectionSource connectionSource;

    @Deprecated
    public void setConnectionSource(ConnectionSource pConnectionSource) {
        connectionSource = pConnectionSource;
    }

    private UniqueKeyGenerator keyGenerator = null;

    @Override
    public void start() {
        if (connectionSource == null) {
            throw new IllegalStateException("DBAppender cannot function without a connection source");
        }
        super.start();
    }

    @SuppressWarnings("deprecation")
    @Override
    protected void append(ILoggingEvent pEventObject) {
        try (Connection connection = this.getConnection()) {
            connection.setAutoCommit(false);

            String logId;
            AccessLog.pause();
            try {
                if (keyGenerator == null) {
                    keyGenerator = SWAKInjector.getInstance(UniqueKeyGenerator.class);
                }
                logId = keyGenerator.generateUniqueKey();
            } finally {
                AccessLog.resume();
            }

            DateFormat formatter    = new SimpleDateFormat("yyyyMMddHHmmssSSS");
            String     now          = formatter.format(new Date());
            Map<String, String> mdc = pEventObject.getMDCPropertyMap();
            Object[]   details      = pEventObject.getArgumentArray();

            AT_AccessLog accessLog = new AT_AccessLog();
            accessLog.setLogId        (logId);
            accessLog.setTimeStamp    (Long.valueOf(pEventObject.getTimeStamp()));
            accessLog.setSyoriUserId  (mdc.get(AccessLogProp.SyoriUserId  .getValue()));
            accessLog.setIpAddress    (mdc.get(AccessLogProp.IpAddress    .getValue()));
            accessLog.setSessionId    (mdc.get(AccessLogProp.SessionId    .getValue()));
            accessLog.setTransactionId(mdc.get(AccessLogProp.TransactionId.getValue()));
            accessLog.setLogKindCd    (C_AccessLogSyubetuKbn.valueOf(pEventObject.getMessage()));
            accessLog.setSubSystemId  (mdc.get(YuyuAccessLogProp.SubsystemId.getValue()));
            accessLog.setCategoryId   (mdc.get(YuyuAccessLogProp.CategoryId .getValue()));
            accessLog.setKinouId      (mdc.get(YuyuAccessLogProp.KinouId    .getValue()));
            accessLog.setLogData      (
                (details == null || details.length == 0) ? ""                    :
                    (details[0].toString().length() <= 666)  ? details[0].toString() :
                        details[0].toString().substring(0, detailMaxLength)
                );
            accessLog.setSyousaiKensuu(Long.valueOf((details == null || details.length == 0) ? 0 : details.length - 1));
            accessLog.setKousinsyaId  (kousinsyaId);
            accessLog.setKousinTime   (now);
            accessLog.setKousinKinou  (kousinKinou);
            accessLog.setVersion      (0);
            this.setExtensions(accessLog, mdc);

            try (EntityPreparedStatement<AT_AccessLog> statement = EntityPreparedStatement.createBatchInsert(connection, accessLog)) {
                statement.addBatch(accessLog);
                statement.executeBatch();
            }

            if (details != null && details.length > 1) {
                AT_AccessLogSyousai syousai = new AT_AccessLogSyousai();

                try (EntityPreparedStatement<AT_AccessLogSyousai> statement = EntityPreparedStatement.createBatchInsert(connection, syousai)) {

                    int edaNo = 0;
                    for (Iterable<String> splitDetail :
                        Iterables.transform(
                            Arrays.asList(details),
                            new Function<Object, Iterable<String>>() {
                                @Override
                                public Iterable<String> apply(Object detailObject) {
                                    String detail = detailObject.toString();
                                    List<String> list = Lists.newLinkedList();
                                    while (detail.length() > 0) {
                                        String s;
                                        if (detail.length() <= detailMaxLength) {
                                            s      = detail;
                                            detail = "";
                                        } else {
                                            s      = detail.substring(0, detailMaxLength);
                                            detail = detail.substring(detailMaxLength);
                                        }
                                        if (list.size() == 0) {
                                            list.add(s);
                                        } else {
                                            list.add("\t" + s);
                                        }
                                    }
                                    return list;
                                }
                            }
                            )
                        ) {
                        for (String partOfDetail : splitDetail) {
                            edaNo++;
                            syousai.setLogId         (logId);
                            syousai.setLogSyousaiData(partOfDetail);
                            syousai.setKousinsyaId   (kousinsyaId);
                            syousai.setKousinTime    (now);
                            syousai.setKousinKinou   (kousinKinou);
                            syousai.setVersion       (0);
                            syousai.setSyousaiEdaNo  (Long.valueOf(edaNo));
                            statement.addBatch(syousai);
                        }
                    }
                    statement.executeBatch();
                }
            }

            connection.commit();
        } catch (Throwable t) {
            t.printStackTrace();
            addError("problem appending event", t);
        }
    }

    protected void setExtensions(AT_AccessLog accessLog, Map<String, String> mdc) {
        return;
    }

    private Connection getConnection() throws SwakDbException {

        Exception ex = null;
        Connection con = null;

        try{
            con = connectionSource.getConnection();
            if (con != null && !con.isClosed()) {
                return con;
            }

        } catch (SQLException e) {
            ex = e;
        }

        logger.debug("◇ コネクション接続 : 失敗");

        this.load();

        logger.debug("◇ コネクション再接続 : リトライ回数={}, リトライ間隔(ミリ秒)={}", retryTimes, intervalMilliTime);

        for (int i = 0; i < retryTimes; i++) {
            try{
                Thread.sleep(intervalMilliTime);

                con = connectionSource.getConnection();
                if (con != null && !con.isClosed()) {
                    logger.debug("◇ コネクション再接続 : 成功");
                    return con;
                }

            } catch (SQLException | InterruptedException e) {
                if (ex == null) {
                    ex = e;
                }
            }

            logger.debug("◇ コネクション再接続 : 失敗 ({}回目)", i + 1);
        }

        throw new SwakDbException("", ex);
    }

    @SuppressWarnings("resource")
    private void load() {

        if (retryTimes >= 0 && intervalMilliTime >= 0) {
            return;
        }

        InputStream in = ConfigFile.getConfigFileStream("swak-accesslog-config.xml");

        try {
            XPath xpath = XPathFactory.newInstance().newXPath();
            Document doc = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(in);
            Node node = (Node)xpath.evaluate("/configuration/connection/retry", doc, XPathConstants.NODE);

            if (node != null) {
                retryTimes = Integer.parseInt((String)xpath.evaluate("@retrytimes", node, XPathConstants.STRING));
                intervalMilliTime = Long.parseLong((String)xpath.evaluate("@intervalmillitime", node, XPathConstants.STRING));

                logger.debug("◇ swak-accesslog-config.xml <configuration><connection><retry>");
                logger.debug("｜  retrytimes = {}", retryTimes);
                logger.debug("｜  intervalmillitime = {}", intervalMilliTime);
                logger.debug("◇ swak-accesslog-config.xml </configuration></connection></retry>");
            }
        } catch (ParserConfigurationException e) {
            throw new RuntimeException(e);

        } catch (SAXException e) {
            throw new RuntimeException(e);

        } catch (IOException e) {
            throw new RuntimeException(e);

        } catch (XPathExpressionException e) {
            throw new RuntimeException(e);

        } finally {
            try {
                in.close();
            } catch (IOException e) {
            }
        }
    }
}
