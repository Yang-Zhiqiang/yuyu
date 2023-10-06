package yuyu.batch.biz.bzaccesslog.bzaccesslogsksdaily;

import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.slcs.swak.batch.annotation.Execute;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.db.ExDBResults;
import jp.co.slcs.swak.file.FileEntityManager;
import jp.co.slcs.swak.file.FileEntityManagerFactory;
import jp.co.slcs.swak.file.FileEntityWriter;
import jp.co.slcs.swak.file.FileType;
import jp.co.slcs.swak.util.message.MessageUtil;
import yuyu.common.biz.bzcommon.BzBatchParam;
import yuyu.def.MessageId;
import yuyu.def.base.configuration.YuyuBaseConfig;
import yuyu.def.biz.file.csv.BzAccessLogDailyDataRecordLayoutFile;
import yuyu.def.biz.manager.BizDomManager;
import yuyu.def.db.entity.AT_AccessLog;
import yuyu.def.db.entity.AT_AccessLogSyousai;
import yuyu.infr.batch.Batch;
import yuyu.infr.batch.BatchParam;
import yuyu.infr.batch.logger.BatchLogger;

/**
 * 業務共通 アクセスログ アクセスログ作成（日次）
 */
public class BzAccessLogSksDailyBatch implements Batch {

    @Inject
    private BzBatchParam batchParam;

    @Inject
    private BizDomManager bizDomManager;

    @Inject
    private BatchLogger batchLogger;

    @Override
    public BatchParam getParam() {
        return batchParam;
    }

    @Execute
    @Transactional
    public void execute(){

        long syorikensu = 0;
        BizDate syoriYMD = batchParam.getSyoriYmd();

        DateFormat dateFMT = new SimpleDateFormat("yyyyMMddHHmmssSSS");
        long syoriYMDFrom = 0;
        long syoriYMDTo = 0;

        try {
            Timestamp timestamp = new Timestamp(dateFMT.parse(syoriYMD.toString().concat("000000000")).getTime());
            syoriYMDFrom = timestamp.getTime();
        }
        catch (ParseException e) {
        }

        try {
            Timestamp timestamp = new Timestamp(dateFMT.parse(syoriYMD.toString().concat("235959999")).getTime());
            syoriYMDTo = timestamp.getTime();
        }
        catch (ParseException e) {
        }

        ExDBResults<AT_AccessLog> accessLogLst = bizDomManager.getAccessLogsBySyoriYmdFromSyoriYmdTo(syoriYMDFrom, syoriYMDTo);

        String batchOutputDir = YuyuBaseConfig.getInstance().getBatchOutputDir();
        String filePath = batchOutputDir.concat("/").concat("AccessLogFileDaily_").concat(syoriYMD.toString()).concat(".csv");

        try {
            @SuppressWarnings("resource")
            FileOutputStream fileOutputStream = null;
            @SuppressWarnings("resource")
            FileEntityWriter<BzAccessLogDailyDataRecordLayoutFile> fileEntityWriter = null;

            try {
                fileOutputStream = new FileOutputStream(filePath);
                FileEntityManager fileEntityManager =
                    FileEntityManagerFactory.getDefaultFactory().createFileEntityManager(FileType.CSV);
                fileEntityWriter = fileEntityManager.getFileEntityWriter(BzAccessLogDailyDataRecordLayoutFile.class, fileOutputStream);

                for (AT_AccessLog accessLog : accessLogLst) {
                    List<AT_AccessLogSyousai> accessLogSyousaiLst = accessLog.getAccessLogSyousais();

                    if (accessLogSyousaiLst.isEmpty()) {
                        BzAccessLogDailyDataRecordLayoutFile dataRecord = new BzAccessLogDailyDataRecordLayoutFile();
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
                        dataRecord.setIfcSyousaiedano("");
                        dataRecord.setIfcLogsyousaidata("");

                        fileEntityWriter.write(dataRecord);

                        syorikensu = syorikensu + 1;
                    }
                    else {

                        for (AT_AccessLogSyousai accessLogSyousai : accessLogSyousaiLst) {
                            BzAccessLogDailyDataRecordLayoutFile dataRecord = new BzAccessLogDailyDataRecordLayoutFile();
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
                            dataRecord.setIfcSyousaiedano(String.valueOf(accessLogSyousai.getSyousaiEdaNo()));
                            dataRecord.setIfcLogsyousaidata(String.valueOf(accessLogSyousai.getLogSyousaiData()));

                            fileEntityWriter.write(dataRecord);

                            syorikensu = syorikensu + 1;
                        }
                    }
                }

                if(syorikensu == 0) {
                    BzAccessLogDailyDataRecordLayoutFile dataRecord = new BzAccessLogDailyDataRecordLayoutFile();

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
            if (accessLogLst != null) {
                accessLogLst.close();
            }
        }

        batchLogger.info(MessageUtil.getMessage(MessageId.IBF0001, String.valueOf(syorikensu)));
    }
}
