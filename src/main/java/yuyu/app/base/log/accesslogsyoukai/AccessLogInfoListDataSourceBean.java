package yuyu.app.base.log.accesslogsyoukai;

import java.text.SimpleDateFormat;
import java.util.Date;

import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.util.message.MessageUtil;
import yuyu.common.base.format.ReportBizDateFormatUtil;
import yuyu.def.MessageId;
import yuyu.def.classification.C_AccessLogSyubetuKbn;
import yuyu.def.db.entity.AM_User;
import yuyu.def.db.entity.AS_Category;
import yuyu.def.db.entity.AS_Kinou;
import yuyu.def.db.entity.AS_SubSystem;
import yuyu.def.db.entity.AT_AccessLog;

import com.google.common.base.Strings;

/**
 * アクセスログ照会 - ●アクセスログ情報リスト の 行データBean クラスです。<br />
 * このクラスは手書きのコード変更が行われる可能性があります。
 * ツールの自動生成ファイルを無条件で上書きしないよう注意して下さい。
 */
public class AccessLogInfoListDataSourceBean extends GenAccessLogInfoListDataSourceBean {

    private static final long serialVersionUID = 1L;

    private final AT_AccessLog accessLog;
    private AM_User user;
    private AS_Kinou kinou;

    public AccessLogInfoListDataSourceBean(
        AT_AccessLog   pAccessLog,
        AS_Kinou       pKinou,
        AM_User        pUser
        ) {
        accessLog = pAccessLog;
        setLogKindCd(accessLog.getLogKindCd());
        String pYMD = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss.SSS").format(
            new Date(accessLog.getTimeStamp().longValue())
            );
        setSyoriTime(
            ReportBizDateFormatUtil.toFormatedYmd(
                BizDate.valueOf(pYMD.split(" ")[0])) + " " + pYMD.split(" ")[1]
            );

        if (pKinou == null) {
            AS_SubSystem subSys;
            AS_Category category;
            kinou = new AS_Kinou(accessLog.getKinouId());
            if (Strings.isNullOrEmpty(accessLog.getKinouId())) {
                subSys = new AS_SubSystem("unknown");
                subSys.setSubSystemNm(
                    MessageUtil.getMessage(MessageId.IAW0062)
                    );
                category = new AS_Category("unknown");
                category.setCategoryNm(
                    MessageUtil.getMessage(MessageId.IAW0063)
                    );
                kinou.setKinouNm(
                    MessageUtil.getMessage(MessageId.IAW0064)
                    );
            } else {
                subSys = new AS_SubSystem("undefined");
                subSys.setSubSystemNm(MessageUtil.getMessage(MessageId.IAW0058, accessLog.getKinouId()));
                category = new AS_Category("undefined");
                category.setCategoryNm(MessageUtil.getMessage(MessageId.IAW0059, accessLog.getKinouId()));
                kinou.setKinouNm(MessageUtil.getMessage(MessageId.IAW0060, accessLog.getKinouId()));
            }
            kinou.setSubSystemId(subSys.getSubSystemId());
            kinou.setCategory(category);
        } else {
            kinou = pKinou;
        }

        if (pUser == null) {
            user = new AM_User();
            user.setUserId(
                (getAccessLog().getSyoriUserId() == null) ?
                    "(null)" :
                        getAccessLog().getSyoriUserId()
                );
            user.setUserNm(MessageUtil.getMessage(MessageId.IAW0057));
        } else {
            user = pUser;
        }

        if (accessLog.getSyousaiKensuu().intValue() > 0) {
            setSyousaiLink(
                MessageUtil.getMessage(MessageId.IAW0061)
                );
        }
    }

    public AT_AccessLog getAccessLog() {
        return accessLog;
    }

    public AM_User getUser() {
        return user;
    }

    public AS_Kinou getKinou() {
        return kinou;
    }

    @Override
    public String getSyoriUserId() {
        return getUser().getUserId();
    }

    @Override
    public String getUserNm() {
        return getUser().getUserNm();
    }

    @Override
    public C_AccessLogSyubetuKbn getLogKindCd() {
        return getAccessLog().getLogKindCd();
    }

    @Override
    public String getIpAddress() {
        return getAccessLog().getIpAddress();
    }

    @Override
    public String getSessionId() {
        return getAccessLog().getSessionId();
    }

    @Override
    public String getTransactionId() {
        return getAccessLog().getTransactionId();
    }

    @Override
    public String getSubSystemNm() {
        return getKinou().getSubSystem().getSubSystemNm();
    }

    @Override
    public String getKinouNm() {
        return getKinou().getKinouNm();
    }

    @Override
    public String getLogData() {
        return getAccessLog().getLogData();
    }
}
