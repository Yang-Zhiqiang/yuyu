package yuyu.batch.biz.bzaccesslog.bzaccesslogsksmonthly;

import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.slcs.swak.batch.annotation.Execute;
import jp.co.slcs.swak.date.BizDateYM;
import jp.co.slcs.swak.db.ExDBResults;
import jp.co.slcs.swak.file.FileEntityManager;
import jp.co.slcs.swak.file.FileEntityManagerFactory;
import jp.co.slcs.swak.file.FileEntityWriter;
import jp.co.slcs.swak.file.FileType;
import jp.co.slcs.swak.util.message.MessageUtil;
import yuyu.common.biz.bzcommon.BzBatchParam;
import yuyu.def.MessageId;
import yuyu.def.base.configuration.YuyuBaseConfig;
import yuyu.def.biz.file.csv.BzToukeiAccessLogDataRecordLayoutFile;
import yuyu.def.biz.manager.BizDomManager;
import yuyu.def.db.entity.AT_AccessLog;
import yuyu.infr.batch.Batch;
import yuyu.infr.batch.BatchParam;
import yuyu.infr.batch.logger.BatchLogger;

/**
 * 業務共通 アクセスログ アクセスログ作成（月次）
 */
public class BzAccessLogSksMonthlyBatch implements Batch {

    private final String GETUSYONITI = "01";

    @Inject
    private BatchLogger batchLogger;

    @Inject
    private BzBatchParam bzBatchParam;

    @Inject
    private BizDomManager bizDomManager;

    @Override
    public BatchParam getParam() {
        return bzBatchParam;
    }

    @Execute
    @Transactional
    public void execute() {

        long syorikensu = 0;

        BizDateYM syoriYM = bzBatchParam.getSyoriYmd().addMonths(-1).getBizDateYM();

        DateFormat dateFMT = new SimpleDateFormat("yyyyMMddHHmmssSSS");
        long syoriYMDFrom = 0;
        long syoriYMDTo = 0;

        try {
            Timestamp timestamp =
                new Timestamp(dateFMT.parse(syoriYM.toString().concat(GETUSYONITI).concat("000000000")).getTime());
            syoriYMDFrom = timestamp.getTime();
        }
        catch (ParseException e) {
        }

        Calendar calendar = Calendar.getInstance();
        calendar.clear();
        calendar.set(Calendar.YEAR, syoriYM.getYear());
        calendar.set(Calendar.MONTH, syoriYM.getMonth() - 1);
        String lastDay = String.valueOf(calendar.getActualMaximum(Calendar.DATE));

        try {
            Timestamp timestamp =
                new Timestamp(dateFMT.parse(syoriYM.toString().concat(lastDay).concat("235959999")).getTime());
            syoriYMDTo = timestamp.getTime();
        }
        catch (ParseException e) {
        }

        ExDBResults<AT_AccessLog> accessLogLst = bizDomManager.getAccessLogsByTimeStamp(syoriYMDFrom, syoriYMDTo);

        String batchOutputDir = YuyuBaseConfig.getInstance().getBatchOutputDir();
        String filePath =
            batchOutputDir.concat("/").concat("ToukeiAccessLogFile_").concat(syoriYM.toString()).concat(".csv");

        try {
            @SuppressWarnings("resource")
            FileOutputStream fileOutputStream = null;
            @SuppressWarnings("resource")
            FileEntityWriter<BzToukeiAccessLogDataRecordLayoutFile> fileEntityWriter = null;

            try {
                fileOutputStream = new FileOutputStream(filePath);
                FileEntityManager fileEntityManager =
                    FileEntityManagerFactory.getDefaultFactory().createFileEntityManager(FileType.CSV);
                fileEntityWriter =
                    fileEntityManager.getFileEntityWriter(BzToukeiAccessLogDataRecordLayoutFile.class, fileOutputStream);

                for (AT_AccessLog accessLog : accessLogLst) {
                    BzToukeiAccessLogDataRecordLayoutFile dataRecord = new BzToukeiAccessLogDataRecordLayoutFile();
                    dataRecord.setIfcLogid(accessLog.getLogId());
                    dataRecord.setIfcTimestamp(
                        new SimpleDateFormat("yyyy/MM/dd HH:mm:ss.SSS").format(accessLog.getTimeStamp()));
                    dataRecord.setIfcSyoriuserid(accessLog.getSyoriUserId());
                    dataRecord.setIfcIpaddress(accessLog.getIpAddress());
                    dataRecord.setIfcSessionid(accessLog.getSessionId());
                    dataRecord.setIfcTransactionid(accessLog.getTransactionId());
                    dataRecord.setIfcLogkindcd(accessLog.getLogKindCd().getValue());
                    dataRecord.setIfcSubsystemid(accessLog.getSubSystemId());
                    dataRecord.setIfcCategoryid(accessLog.getCategoryId());
                    dataRecord.setIfcKinouid(accessLog.getKinouId());
                    dataRecord.setIfcTanmatutype(accessLog.getTanmatuType());
                    dataRecord.setIfcButsurisosikicd(accessLog.getButsuriSosikiCd());
                    dataRecord.setIfcRonrisosikicd(accessLog.getRonriSosikiCd());
                    dataRecord.setIfcTanmatujyoutaihyouji(accessLog.getTanmatuJyoutaiHyouji());
                    dataRecord.setIfcLogdata(accessLog.getLogData());
                    dataRecord.setIfcSyousaikensuu(String.valueOf(accessLog.getSyousaiKensuu()));

                    fileEntityWriter.write(dataRecord);

                    syorikensu = syorikensu + 1;
                }

                if(syorikensu == 0) {
                    BzToukeiAccessLogDataRecordLayoutFile dataRecord = new BzToukeiAccessLogDataRecordLayoutFile();

                    fileEntityWriter.write(dataRecord);
                }
            }
            finally {
                if (fileEntityWriter != null) {
                    fileEntityWriter.close();
                }
                if (fileOutputStream != null) {
                    fileOutputStream.close();
                }
            }
        }
        catch (IOException e) {
        }
        finally {
            if(accessLogLst != null) {
                accessLogLst.close();
            }
        }

        batchLogger.info(MessageUtil.getMessage(MessageId.IBF0001, String.valueOf(syorikensu)));
    }
}
