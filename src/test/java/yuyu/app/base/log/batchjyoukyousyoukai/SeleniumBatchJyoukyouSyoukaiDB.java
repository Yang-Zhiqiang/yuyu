package yuyu.app.base.log.batchjyoukyousyoukai;

import static yuyu.app.base.log.batchjyoukyousyoukai.SeleniumBatchJyoukyouSyoukaiConstants.*;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.slcs.swak.date.BizDate;
import yuyu.def.base.manager.BaseDomManager;
import yuyu.def.db.entity.AT_BatchJob;
import yuyu.def.db.entity.AT_BatchLog;
import yuyu.def.db.entity.AT_BatchLogReport;
import yuyu.def.db.entity.AT_TyouhyouHozon;

public class SeleniumBatchJyoukyouSyoukaiDB {

    @Inject
    private BaseDomManager baseDomManager;

    @Transactional
    public void createTestB0005_01(){

        AT_BatchJob batchJob = baseDomManager.getBatchJob(ALREADYBATCHJOBID);
        if ( null == batchJob ) {
            batchJob = new AT_BatchJob();
            batchJob.setBatchJobId(ALREADYBATCHJOBID);
            batchJob.setBatchId(ALREADYBATCHID);
            batchJob.setBatchKidouKbn(ALREADYBATCHKIDOUKBN);
            batchJob.setBatchJyoutaiKbn(ALREADYBATCHJYOUTAIKBN);
            batchJob.setBatchSyoriYmd(ALREADYBATCHSYORIYMD);
            batchJob.setBatchStartTime(String.valueOf(getSyoriTime(ALREADYBATCHSYORIYMD)));

            baseDomManager.insert(batchJob);
        }
    }

    @Transactional
    public void createTestB0005_02(){

        AT_BatchJob batchJob = baseDomManager.getBatchJob(ALREADYBATCHJOBID);
        if ( null != batchJob ) {

            AT_BatchLog batchLog = batchJob.getBatchLog(ALREADYBATCHLOGEDANO);
            if ( null == batchLog ) {
                batchLog = batchJob.createBatchLog();
                batchLog.setBatchLogEdaNo(ALREADYBATCHLOGEDANO);
                batchLog.setLogOutputTime(String.valueOf(getSyoriTime(BizDate.getSysDate())));
                batchLog.setLogLevelKbn(ALREADYBATCHLOGLEVELKBN);
                batchLog.setLogNaiyou(ALREADYBATCHLOGNAIYOU);
            }

            baseDomManager.update(batchJob);
        }
    }

    @Transactional
    public void deleteTestB0005_01(){

        AT_BatchJob batchJob = baseDomManager.getBatchJob(ALREADYBATCHJOBID);
        if ( null != batchJob ) {
            batchJob.getBatchLogs().removeAll(batchJob.getBatchLogs());

            baseDomManager.update(batchJob);
            baseDomManager.delete(batchJob);
        }
    }

    @Transactional
    public void deleteTestB0006_01(){

        AT_BatchJob batchJob = baseDomManager.getBatchJob(ALREADYBATCHJOBID);
        if ( null != batchJob ) {
            batchJob.getBatchLogs().removeAll(batchJob.getBatchLogs());

            baseDomManager.update(batchJob);
            baseDomManager.delete(batchJob);
        }
    }

    @Transactional
    public void createTestB0007_01(){

        AT_BatchJob batchJob = baseDomManager.getBatchJob(ALREADYBATCHJOBID);
        if ( null == batchJob ) {
            batchJob = new AT_BatchJob();
            batchJob.setBatchJobId(ALREADYBATCHJOBID);
            batchJob.setBatchId(ALREADYBATCHID);
            batchJob.setBatchKidouKbn(ALREADYBATCHKIDOUKBN);
            batchJob.setBatchJyoutaiKbn(ALREADYBATCHJYOUTAIKBN);
            batchJob.setBatchSyoriYmd(ALREADYBATCHSYORIYMD);
            batchJob.setBatchStartTime(String.valueOf(getSyoriTime(ALREADYBATCHSYORIYMD)));

            baseDomManager.insert(batchJob);
        }
    }

    @Transactional
    public void createTestB0007_02(){

        AT_BatchJob batchJob = baseDomManager.getBatchJob(ALREADYBATCHJOBID);
        if ( null != batchJob ) {

            AT_BatchLog batchLog = batchJob.getBatchLog(ALREADYBATCHLOGEDANO);
            if ( null == batchLog ) {
                batchLog = batchJob.createBatchLog();
                batchLog.setBatchLogEdaNo(ALREADYBATCHLOGEDANO);
                batchLog.setLogOutputTime(String.valueOf(getSyoriTime(BizDate.getSysDate())));
                batchLog.setLogLevelKbn(ALREADYBATCHLOGLEVELKBN);
                batchLog.setLogNaiyou(ALREADYBATCHLOGNAIYOU);
            }

            baseDomManager.update(batchJob);
        }
    }

    @Transactional
    public void deleteTestB0007_01(){

        AT_BatchJob batchJob = baseDomManager.getBatchJob(ALREADYBATCHJOBID);
        if ( null != batchJob ) {
            batchJob.getBatchLogs().removeAll(batchJob.getBatchLogs());

            baseDomManager.update(batchJob);
            baseDomManager.delete(batchJob);
        }
    }

    @Transactional
    public void createTestB0008_01(){

        AT_BatchJob batchJob = baseDomManager.getBatchJob(ALREADYBATCHJOBID);
        if ( null == batchJob ) {
            batchJob = new AT_BatchJob();
            batchJob.setBatchJobId(ALREADYBATCHJOBID);
            batchJob.setBatchId(ALREADYBATCHID);
            batchJob.setBatchKidouKbn(ALREADYBATCHKIDOUKBN);
            batchJob.setBatchJyoutaiKbn(ALREADYBATCHJYOUTAIKBN);
            batchJob.setBatchSyoriYmd(ALREADYBATCHSYORIYMD);
            batchJob.setBatchStartTime(String.valueOf(getSyoriTime(ALREADYBATCHSYORIYMD)));

            baseDomManager.insert(batchJob);
        }
    }

    @Transactional
    public void createTestB0008_02(){

        AT_BatchJob batchJob = baseDomManager.getBatchJob(ALREADYBATCHJOBID);
        if ( null != batchJob ) {

            AT_BatchLog batchLog = batchJob.getBatchLog(ALREADYBATCHLOGEDANO);
            if ( null == batchLog ) {
                batchLog = batchJob.createBatchLog();
                batchLog.setBatchLogEdaNo(ALREADYBATCHLOGEDANO);
                batchLog.setLogOutputTime(String.valueOf(getSyoriTime(BizDate.getSysDate())));
                batchLog.setLogLevelKbn(ALREADYBATCHLOGLEVELKBN);
                batchLog.setLogNaiyou(ALREADYBATCHLOGNAIYOU);

                baseDomManager.update(batchJob);
            }
        }
    }

    @Transactional
    public void createTestB0008_03(){

        AT_TyouhyouHozon tyouhyouHozon = baseDomManager.getTyouhyouHozon(ALREADYTYOUHYOUKEY);
        if ( null == tyouhyouHozon ) {
            tyouhyouHozon = new AT_TyouhyouHozon();
            tyouhyouHozon.setReportKey(ALREADYTYOUHYOUKEY);

            baseDomManager.insert(tyouhyouHozon);
        }
    }

    @Transactional
    public void createTestB0008_04(){

        AT_BatchJob batchJob = baseDomManager.getBatchJob(ALREADYBATCHJOBID);
        if ( null != batchJob ) {

            AT_BatchLogReport batchLogReport = batchJob.getBatchLogReport(ALREADYTYOUHYOUKEY);
            if ( null == batchLogReport ) {
                batchLogReport = batchJob.createBatchLogReport();
                batchLogReport.setReportKey(ALREADYTYOUHYOUKEY);

                baseDomManager.update(batchJob);
            }
        }
    }

    @Transactional
    public void deleteTestB0008_01(){

        AT_BatchJob batchJob = baseDomManager.getBatchJob(ALREADYBATCHJOBID);
        if ( null != batchJob ) {
            batchJob.getBatchLogs().removeAll(batchJob.getBatchLogs());
            batchJob.getBatchLogReports().removeAll(batchJob.getBatchLogReports());

            baseDomManager.update(batchJob);
            baseDomManager.delete(batchJob);
        }
    }

    @Transactional
    public void deleteTestB0008_02(){

        AT_TyouhyouHozon tyouhyouHozon = baseDomManager.getTyouhyouHozon(ALREADYTYOUHYOUKEY);
        if ( null != tyouhyouHozon ) {

            baseDomManager.delete(tyouhyouHozon);
        }
    }

    @Transactional
    public void createTestB0009_01(){

        AT_BatchJob batchJob = baseDomManager.getBatchJob(ALREADYBATCHJOBID);
        if ( null == batchJob ) {
            batchJob = new AT_BatchJob();
            batchJob.setBatchJobId(ALREADYBATCHJOBID);
            batchJob.setBatchId(ALREADYBATCHID);
            batchJob.setBatchKidouKbn(ALREADYBATCHKIDOUKBN);
            batchJob.setBatchJyoutaiKbn(ALREADYBATCHJYOUTAIKBN);
            batchJob.setBatchSyoriYmd(ALREADYBATCHSYORIYMD);
            batchJob.setBatchStartTime(String.valueOf(getSyoriTime(ALREADYBATCHSYORIYMD)));

            baseDomManager.insert(batchJob);
        }
    }

    @Transactional
    public void createTestB0009_02(){

        AT_BatchJob batchJob = baseDomManager.getBatchJob(ALREADYBATCHJOBID);
        if ( null != batchJob ) {

            AT_BatchLog batchLog = batchJob.getBatchLog(ALREADYBATCHLOGEDANO);
            if ( null == batchLog ) {
                batchLog = batchJob.createBatchLog();
                batchLog.setBatchLogEdaNo(ALREADYBATCHLOGEDANO);
                batchLog.setLogOutputTime(String.valueOf(getSyoriTime(BizDate.getSysDate())));
                batchLog.setLogLevelKbn(ALREADYBATCHLOGLEVELKBN);
                batchLog.setLogNaiyou(ALREADYBATCHLOGNAIYOU);

                baseDomManager.update(batchJob);
            }
        }
    }

    @Transactional
    public void deleteTestB0009_01(){

        AT_BatchJob batchJob = baseDomManager.getBatchJob(ALREADYBATCHJOBID);
        if ( null != batchJob ) {
            batchJob.getBatchLogs().removeAll(batchJob.getBatchLogs());

            baseDomManager.update(batchJob);
            baseDomManager.delete(batchJob);
        }
    }

    @Transactional
    public void createTestB0010_01(){

        for( int idx = 0; idx < 350; idx++ ) {
            String sBatchJobId = ALREADYBATCHJOBID + idx;
            AT_BatchJob batchJob = baseDomManager.getBatchJob(sBatchJobId);
            if ( null == batchJob ) {
                batchJob = new AT_BatchJob();
                batchJob.setBatchJobId(sBatchJobId);
                batchJob.setBatchId(ALREADYBATCHID);
                batchJob.setBatchKidouKbn(ALREADYBATCHKIDOUKBN);
                batchJob.setBatchJyoutaiKbn(ALREADYBATCHJYOUTAIKBN);
                batchJob.setBatchSyoriYmd(ALREADYBATCHSYORIYMD);
                batchJob.setBatchStartTime(String.valueOf(getSyoriTime(ALREADYBATCHSYORIYMD)));

                baseDomManager.insert(batchJob);
            }
        }
    }

    @Transactional
    public void createTestB0010_02(){

        for( int idx = 0; idx < 350; idx++ ) {
            String sBatchJobId = ALREADYBATCHJOBID + idx;
            AT_BatchJob batchJob = baseDomManager.getBatchJob(sBatchJobId);
            if ( null != batchJob ) {

                AT_BatchLog batchLog = batchJob.getBatchLog(ALREADYBATCHLOGEDANO);
                if ( null == batchLog ) {
                    batchLog = batchJob.createBatchLog();
                    batchLog.setBatchLogEdaNo(ALREADYBATCHLOGEDANO + idx);
                    batchLog.setLogOutputTime(String.valueOf(getSyoriTime(BizDate.getSysDate())));
                    batchLog.setLogLevelKbn(ALREADYBATCHLOGLEVELKBN);
                    batchLog.setLogNaiyou(ALREADYBATCHLOGNAIYOU + idx);

                    baseDomManager.update(batchJob);
                }
            }
        }
    }

    @Transactional
    public void deleteTestB0010_01(){

        for( int idx = 0; idx < 350; idx++ ) {
            String sBatchJobId = ALREADYBATCHJOBID + idx;
            AT_BatchJob batchJob = baseDomManager.getBatchJob(sBatchJobId);
            if ( null != batchJob ) {
                batchJob.getBatchLogs().removeAll(batchJob.getBatchLogs());

                baseDomManager.update(batchJob);
                baseDomManager.delete(batchJob);
            }
        }
    }

    @Transactional
    public void createTestB0011_01(){

        for( int idx = 0; idx < 350; idx++ ) {
            String sBatchJobId = ALREADYBATCHJOBID + idx;
            AT_BatchJob batchJob = baseDomManager.getBatchJob(sBatchJobId);
            if ( null == batchJob ) {
                batchJob = new AT_BatchJob();
                batchJob.setBatchJobId(sBatchJobId);
                batchJob.setBatchId(ALREADYBATCHID);
                batchJob.setBatchKidouKbn(ALREADYBATCHKIDOUKBN);
                batchJob.setBatchJyoutaiKbn(ALREADYBATCHJYOUTAIKBN);
                batchJob.setBatchSyoriYmd(ALREADYBATCHSYORIYMD);
                batchJob.setBatchStartTime(String.valueOf(getSyoriTime(ALREADYBATCHSYORIYMD)));

                baseDomManager.insert(batchJob);
            }
        }
    }

    @Transactional
    public void createTestB0011_02(){

        for( int idx = 0; idx < 350; idx++ ) {
            String sBatchJobId = ALREADYBATCHJOBID + idx;
            AT_BatchJob batchJob = baseDomManager.getBatchJob(sBatchJobId);
            if ( null != batchJob ) {

                AT_BatchLog batchLog = batchJob.getBatchLog(ALREADYBATCHLOGEDANO);
                if ( null == batchLog ) {
                    batchLog = batchJob.createBatchLog();
                    batchLog.setBatchLogEdaNo(ALREADYBATCHLOGEDANO + idx);
                    batchLog.setLogOutputTime(String.valueOf(getSyoriTime(BizDate.getSysDate())));
                    batchLog.setLogLevelKbn(ALREADYBATCHLOGLEVELKBN);
                    batchLog.setLogNaiyou(ALREADYBATCHLOGNAIYOU + idx);

                    baseDomManager.update(batchJob);
                }
            }
        }
    }

    @Transactional
    public void deleteTestB0011_01(){

        for( int idx = 0; idx < 350; idx++ ) {
            String sBatchJobId = ALREADYBATCHJOBID + idx;
            AT_BatchJob batchJob = baseDomManager.getBatchJob(sBatchJobId);
            if ( null != batchJob ) {
                batchJob.getBatchLogs().removeAll(batchJob.getBatchLogs());

                baseDomManager.update(batchJob);
                baseDomManager.delete(batchJob);
            }
        }
    }

    @Transactional
    public void createTestB0012_01(){

        for( int idx = 0; idx < 350; idx++ ) {
            String sBatchJobId = ALREADYBATCHJOBID + idx;
            AT_BatchJob batchJob = baseDomManager.getBatchJob(sBatchJobId);
            if ( null == batchJob ) {
                batchJob = new AT_BatchJob();
                batchJob.setBatchJobId(sBatchJobId);
                batchJob.setBatchId(ALREADYBATCHID);
                batchJob.setBatchKidouKbn(ALREADYBATCHKIDOUKBN);
                batchJob.setBatchJyoutaiKbn(ALREADYBATCHJYOUTAIKBN);
                batchJob.setBatchSyoriYmd(ALREADYBATCHSYORIYMD);
                batchJob.setBatchStartTime(String.valueOf(getSyoriTime(ALREADYBATCHSYORIYMD)));

                baseDomManager.insert(batchJob);
            }
        }
    }

    @Transactional
    public void createTestB0012_02(){

        for( int idx = 0; idx < 350; idx++ ) {
            String sBatchJobId = ALREADYBATCHJOBID + idx;
            AT_BatchJob batchJob = baseDomManager.getBatchJob(sBatchJobId);
            if ( null != batchJob ) {

                AT_BatchLog batchLog = batchJob.getBatchLog(ALREADYBATCHLOGEDANO);
                if ( null == batchLog ) {
                    batchLog = batchJob.createBatchLog();
                    batchLog.setBatchLogEdaNo(ALREADYBATCHLOGEDANO + idx);
                    batchLog.setLogOutputTime(String.valueOf(getSyoriTime(BizDate.getSysDate())));
                    batchLog.setLogLevelKbn(ALREADYBATCHLOGLEVELKBN);
                    batchLog.setLogNaiyou(ALREADYBATCHLOGNAIYOU + idx);

                    baseDomManager.update(batchJob);
                }
            }
        }
    }

    @Transactional
    public void deleteTestB0012_01(){

        for( int idx = 0; idx < 350; idx++ ) {
            String sBatchJobId = ALREADYBATCHJOBID + idx;
            AT_BatchJob batchJob = baseDomManager.getBatchJob(sBatchJobId);
            if ( null != batchJob ) {
                batchJob.getBatchLogs().removeAll(batchJob.getBatchLogs());

                baseDomManager.update(batchJob);
                baseDomManager.delete(batchJob);
            }
        }
    }

    @Transactional
    public void createTestB0013_01(){

        for( int idx = 0; idx < 350; idx++ ) {
            String sBatchJobId = ALREADYBATCHJOBID + idx;
            AT_BatchJob batchJob = baseDomManager.getBatchJob(sBatchJobId);
            if ( null == batchJob ) {
                batchJob = new AT_BatchJob();
                batchJob.setBatchJobId(sBatchJobId);
                batchJob.setBatchId(ALREADYBATCHID);
                batchJob.setBatchKidouKbn(ALREADYBATCHKIDOUKBN);
                batchJob.setBatchJyoutaiKbn(ALREADYBATCHJYOUTAIKBN);
                batchJob.setBatchSyoriYmd(ALREADYBATCHSYORIYMD);
                batchJob.setBatchStartTime(String.valueOf(getSyoriTime(ALREADYBATCHSYORIYMD)));

                baseDomManager.insert(batchJob);
            }
        }
    }

    @Transactional
    public void createTestB0013_02(){

        for( int idx = 0; idx < 350; idx++ ) {
            String sBatchJobId = ALREADYBATCHJOBID + idx;
            AT_BatchJob batchJob = baseDomManager.getBatchJob(sBatchJobId);
            if ( null != batchJob ) {

                AT_BatchLog batchLog = batchJob.getBatchLog(ALREADYBATCHLOGEDANO);
                if ( null == batchLog ) {
                    batchLog = batchJob.createBatchLog();
                    batchLog.setBatchLogEdaNo(ALREADYBATCHLOGEDANO + idx);
                    batchLog.setLogOutputTime(String.valueOf(getSyoriTime(BizDate.getSysDate())));
                    batchLog.setLogLevelKbn(ALREADYBATCHLOGLEVELKBN);
                    batchLog.setLogNaiyou(ALREADYBATCHLOGNAIYOU + idx);

                    baseDomManager.update(batchJob);
                }
            }
        }
    }

    @Transactional
    public void deleteTestB0013_01(){

        for( int idx = 0; idx < 350; idx++ ) {
            String sBatchJobId = ALREADYBATCHJOBID + idx;
            AT_BatchJob batchJob = baseDomManager.getBatchJob(sBatchJobId);
            if ( null != batchJob ) {
                batchJob.getBatchLogs().removeAll(batchJob.getBatchLogs());

                baseDomManager.update(batchJob);
                baseDomManager.delete(batchJob);
            }
        }
    }

    @Transactional
    public void createTestB0014_01(){

        for( int idx = 0; idx < 350; idx++ ) {
            String sBatchJobId = ALREADYBATCHJOBID + idx;
            AT_BatchJob batchJob = baseDomManager.getBatchJob(sBatchJobId);
            if ( null == batchJob ) {
                batchJob = new AT_BatchJob();
                batchJob.setBatchJobId(sBatchJobId);
                batchJob.setBatchId(ALREADYBATCHID);
                batchJob.setBatchKidouKbn(ALREADYBATCHKIDOUKBN);
                batchJob.setBatchJyoutaiKbn(ALREADYBATCHJYOUTAIKBN);
                batchJob.setBatchSyoriYmd(ALREADYBATCHSYORIYMD);
                batchJob.setBatchStartTime(String.valueOf(getSyoriTime(ALREADYBATCHSYORIYMD)));

                baseDomManager.insert(batchJob);
            }
        }
    }

    @Transactional
    public void createTestB0014_02(){

        for( int idx = 0; idx < 350; idx++ ) {
            String sBatchJobId = ALREADYBATCHJOBID + idx;
            AT_BatchJob batchJob = baseDomManager.getBatchJob(sBatchJobId);
            if ( null != batchJob ) {

                AT_BatchLog batchLog = batchJob.getBatchLog(ALREADYBATCHLOGEDANO);
                if ( null == batchLog ) {
                    batchLog = batchJob.createBatchLog();
                    batchLog.setBatchLogEdaNo(ALREADYBATCHLOGEDANO + idx);
                    batchLog.setLogOutputTime(String.valueOf(getSyoriTime(BizDate.getSysDate())));
                    batchLog.setLogLevelKbn(ALREADYBATCHLOGLEVELKBN);
                    batchLog.setLogNaiyou(ALREADYBATCHLOGNAIYOU + idx);

                    baseDomManager.update(batchJob);
                }
            }
        }
    }

    @Transactional
    public void deleteTestB0014_01(){

        for( int idx = 0; idx < 350; idx++ ) {
            String sBatchJobId = ALREADYBATCHJOBID + idx;
            AT_BatchJob batchJob = baseDomManager.getBatchJob(sBatchJobId);
            if ( null != batchJob ) {
                batchJob.getBatchLogs().removeAll(batchJob.getBatchLogs());

                baseDomManager.update(batchJob);
                baseDomManager.delete(batchJob);
            }
        }
    }

    @Transactional
    public void createTestB0016_01(){

        AT_BatchJob batchJob = baseDomManager.getBatchJob(ALREADYBATCHJOBID);
        if ( null == batchJob ) {
            batchJob = new AT_BatchJob();
            batchJob.setBatchJobId(ALREADYBATCHJOBID);
            batchJob.setBatchId(ALREADYBATCHID);
            batchJob.setBatchKidouKbn(ALREADYBATCHKIDOUKBN);
            batchJob.setBatchJyoutaiKbn(ALREADYBATCHJYOUTAIKBN);
            batchJob.setBatchSyoriYmd(ALREADYBATCHSYORIYMD);
            batchJob.setBatchStartTime(String.valueOf(getSyoriTime(ALREADYBATCHSYORIYMD)));

            baseDomManager.insert(batchJob);
        }
    }

    @Transactional
    public void createTestB0016_02(){

        AT_BatchJob batchJob = baseDomManager.getBatchJob(ALREADYBATCHJOBID);
        if ( null != batchJob ) {

            AT_BatchLog batchLog = batchJob.getBatchLog(ALREADYBATCHLOGEDANO);
            if ( null == batchLog ) {
                batchLog = batchJob.createBatchLog();
                batchLog.setBatchLogEdaNo(ALREADYBATCHLOGEDANO);
                batchLog.setLogOutputTime(String.valueOf(getSyoriTime(BizDate.getSysDate())));
                batchLog.setLogLevelKbn(ALREADYBATCHLOGLEVELKBN);
                batchLog.setLogNaiyou(ALREADYBATCHLOGNAIYOU);

                baseDomManager.update(batchJob);
            }
        }
    }

    @Transactional
    public void deleteTestB0016_01(){

        AT_BatchJob batchJob = baseDomManager.getBatchJob(ALREADYBATCHJOBID);
        if ( null != batchJob ) {
            batchJob.getBatchLogs().removeAll(batchJob.getBatchLogs());
            batchJob.getBatchLogReports().removeAll(batchJob.getBatchLogReports());

            baseDomManager.update(batchJob);
            baseDomManager.delete(batchJob);
        }
    }

    @Transactional
    public void createTestB0017_01(){

        AT_BatchJob batchJob = baseDomManager.getBatchJob(ALREADYBATCHJOBID);
        if ( null == batchJob ) {
            batchJob = new AT_BatchJob();
            batchJob.setBatchJobId(ALREADYBATCHJOBID);
            batchJob.setBatchId(ALREADYBATCHID);
            batchJob.setBatchKidouKbn(ALREADYBATCHKIDOUKBN);
            batchJob.setBatchJyoutaiKbn(ALREADYBATCHJYOUTAIKBN);
            batchJob.setBatchSyoriYmd(ALREADYBATCHSYORIYMD);
            batchJob.setBatchStartTime(String.valueOf(getSyoriTime(ALREADYBATCHSYORIYMD)));

            baseDomManager.insert(batchJob);
        }
    }

    @Transactional
    public void createTestB0017_02(){

        AT_BatchJob batchJob = baseDomManager.getBatchJob(ALREADYBATCHJOBID);
        if ( null != batchJob ) {

            AT_BatchLog batchLog = batchJob.getBatchLog(ALREADYBATCHLOGEDANO);
            if ( null == batchLog ) {
                batchLog = batchJob.createBatchLog();
                batchLog.setBatchLogEdaNo(ALREADYBATCHLOGEDANO);
                batchLog.setLogOutputTime(String.valueOf(getSyoriTime(BizDate.getSysDate())));
                batchLog.setLogLevelKbn(ALREADYBATCHLOGLEVELKBN);
                batchLog.setLogNaiyou(ALREADYBATCHLOGNAIYOU);

                baseDomManager.update(batchJob);
            }
        }
    }

    @Transactional
    public void deleteTestB0017_01(){

        AT_BatchJob batchJob = baseDomManager.getBatchJob(ALREADYBATCHJOBID);
        if ( null != batchJob ) {
            batchJob.getBatchLogs().removeAll(batchJob.getBatchLogs());
            batchJob.getBatchLogReports().removeAll(batchJob.getBatchLogReports());

            baseDomManager.update(batchJob);
            baseDomManager.delete(batchJob);
        }
    }

    @Transactional
    public void createTestB0018_01(){

        AT_BatchJob batchJob = baseDomManager.getBatchJob(ALREADYBATCHJOBID);
        if ( null == batchJob ) {
            batchJob = new AT_BatchJob();
            batchJob.setBatchJobId(ALREADYBATCHJOBID);
            batchJob.setBatchId(ALREADYBATCHID);
            batchJob.setBatchKidouKbn(ALREADYBATCHKIDOUKBN);
            batchJob.setBatchJyoutaiKbn(ALREADYBATCHJYOUTAIKBN);
            batchJob.setBatchSyoriYmd(ALREADYBATCHSYORIYMD);
            batchJob.setBatchStartTime(String.valueOf(getSyoriTime(ALREADYBATCHSYORIYMD)));

            baseDomManager.insert(batchJob);
        }
    }

    @Transactional
    public void createTestB0018_02(){

        AT_BatchJob batchJob = baseDomManager.getBatchJob(ALREADYBATCHJOBID);
        if ( null != batchJob ) {

            AT_BatchLog batchLog = batchJob.getBatchLog(ALREADYBATCHLOGEDANO);
            if ( null == batchLog ) {
                batchLog = batchJob.createBatchLog();
                batchLog.setBatchLogEdaNo(ALREADYBATCHLOGEDANO);
                batchLog.setLogOutputTime(String.valueOf(getSyoriTime(BizDate.getSysDate())));
                batchLog.setLogLevelKbn(ALREADYBATCHLOGLEVELKBN);
                batchLog.setLogNaiyou(ALREADYBATCHLOGNAIYOU);

                baseDomManager.update(batchJob);
            }
        }
    }

    @Transactional
    public void deleteTestB0018_01(){

        AT_BatchJob batchJob = baseDomManager.getBatchJob(ALREADYBATCHJOBID);
        if ( null != batchJob ) {
            batchJob.getBatchLogs().removeAll(batchJob.getBatchLogs());
            batchJob.getBatchLogReports().removeAll(batchJob.getBatchLogReports());

            baseDomManager.update(batchJob);
            baseDomManager.delete(batchJob);
        }
    }

    @Transactional
    public void createTestB0019_01(){

        AT_BatchJob batchJob = baseDomManager.getBatchJob(ALREADYBATCHJOBID);
        if ( null == batchJob ) {
            batchJob = new AT_BatchJob();
            batchJob.setBatchJobId(ALREADYBATCHJOBID);
            batchJob.setBatchId(ALREADYBATCHID);
            batchJob.setBatchKidouKbn(ALREADYBATCHKIDOUKBN);
            batchJob.setBatchJyoutaiKbn(ALREADYBATCHJYOUTAIKBN);
            batchJob.setBatchSyoriYmd(ALREADYBATCHSYORIYMD);
            batchJob.setBatchStartTime(String.valueOf(getSyoriTime(ALREADYBATCHSYORIYMD)));

            baseDomManager.insert(batchJob);
        }
    }

    @Transactional
    public void createTestB0019_02(){

        AT_BatchJob batchJob = baseDomManager.getBatchJob(ALREADYBATCHJOBID);
        if ( null != batchJob ) {

            AT_BatchLog batchLog = batchJob.getBatchLog(ALREADYBATCHLOGEDANO);
            if ( null == batchLog ) {
                batchLog = batchJob.createBatchLog();
                batchLog.setBatchLogEdaNo(ALREADYBATCHLOGEDANO);
                batchLog.setLogOutputTime(String.valueOf(getSyoriTime(BizDate.getSysDate())));
                batchLog.setLogLevelKbn(ALREADYBATCHLOGLEVELKBN);
                batchLog.setLogNaiyou(ALREADYBATCHLOGNAIYOU);

                baseDomManager.update(batchJob);
            }
        }
    }

    @Transactional
    public void deleteTestB0019_01(){

        AT_BatchJob batchJob = baseDomManager.getBatchJob(ALREADYBATCHJOBID);
        if ( null != batchJob ) {
            batchJob.getBatchLogs().removeAll(batchJob.getBatchLogs());
            batchJob.getBatchLogReports().removeAll(batchJob.getBatchLogReports());

            baseDomManager.update(batchJob);
            baseDomManager.delete(batchJob);
        }
    }

    @Transactional
    public void createTestB0020_01(){

        AT_BatchJob batchJob = baseDomManager.getBatchJob(ALREADYBATCHJOBID);
        if ( null == batchJob ) {
            batchJob = new AT_BatchJob();
            batchJob.setBatchJobId(ALREADYBATCHJOBID);
            batchJob.setBatchId(ALREADYBATCHID);
            batchJob.setBatchKidouKbn(ALREADYBATCHKIDOUKBN);
            batchJob.setBatchJyoutaiKbn(ALREADYBATCHJYOUTAIKBN);
            batchJob.setBatchSyoriYmd(ALREADYBATCHSYORIYMD);
            batchJob.setBatchStartTime(String.valueOf(getSyoriTime(ALREADYBATCHSYORIYMD)));

            baseDomManager.insert(batchJob);
        }
    }

    @Transactional
    public void createTestB0020_02(){

        AT_BatchJob batchJob = baseDomManager.getBatchJob(ALREADYBATCHJOBID);
        if ( null != batchJob ) {

            for( int idx = 0; idx < 350; idx++ ) {

                AT_BatchLog batchLog = batchJob.getBatchLog(ALREADYBATCHLOGEDANO + idx);
                if ( null == batchLog ) {
                    batchLog = batchJob.createBatchLog();
                    batchLog.setBatchLogEdaNo(ALREADYBATCHLOGEDANO + idx);
                    batchLog.setLogOutputTime(String.valueOf(getSyoriTime(BizDate.getSysDate())));
                    batchLog.setLogLevelKbn(ALREADYBATCHLOGLEVELKBN);
                    batchLog.setLogNaiyou(ALREADYBATCHLOGNAIYOU + idx);

                    baseDomManager.update(batchJob);
                }
            }
        }
    }

    @Transactional
    public void deleteTestB0020_01(){

        AT_BatchJob batchJob = baseDomManager.getBatchJob(ALREADYBATCHJOBID);
        if ( null != batchJob ) {
            batchJob.getBatchLogs().removeAll(batchJob.getBatchLogs());

            baseDomManager.update(batchJob);
            baseDomManager.delete(batchJob);
        }
    }

    @Transactional
    public void createTestB0021_01(){

        AT_BatchJob batchJob = baseDomManager.getBatchJob(ALREADYBATCHJOBID);
        if ( null == batchJob ) {
            batchJob = new AT_BatchJob();
            batchJob.setBatchJobId(ALREADYBATCHJOBID);
            batchJob.setBatchId(ALREADYBATCHID);
            batchJob.setBatchKidouKbn(ALREADYBATCHKIDOUKBN);
            batchJob.setBatchJyoutaiKbn(ALREADYBATCHJYOUTAIKBN);
            batchJob.setBatchSyoriYmd(ALREADYBATCHSYORIYMD);
            batchJob.setBatchStartTime(String.valueOf(getSyoriTime(ALREADYBATCHSYORIYMD)));

            baseDomManager.insert(batchJob);
        }
    }

    @Transactional
    public void createTestB0021_02(){

        AT_BatchJob batchJob = baseDomManager.getBatchJob(ALREADYBATCHJOBID);
        if ( null != batchJob ) {

            for( int idx = 0; idx < 350; idx++ ) {

                AT_BatchLog batchLog = batchJob.getBatchLog(ALREADYBATCHLOGEDANO + idx);
                if ( null == batchLog ) {
                    batchLog = batchJob.createBatchLog();
                    batchLog.setBatchLogEdaNo(ALREADYBATCHLOGEDANO + idx);
                    batchLog.setLogOutputTime(String.valueOf(getSyoriTime(BizDate.getSysDate())));
                    batchLog.setLogLevelKbn(ALREADYBATCHLOGLEVELKBN);
                    batchLog.setLogNaiyou(ALREADYBATCHLOGNAIYOU + idx);

                    baseDomManager.update(batchJob);
                }
            }
        }
    }

    @Transactional
    public void deleteTestB0021_01(){

        AT_BatchJob batchJob = baseDomManager.getBatchJob(ALREADYBATCHJOBID);
        if ( null != batchJob ) {
            batchJob.getBatchLogs().removeAll(batchJob.getBatchLogs());

            baseDomManager.update(batchJob);
            baseDomManager.delete(batchJob);
        }
    }

    @Transactional
    public void createTestB0022_01(){

        AT_BatchJob batchJob = baseDomManager.getBatchJob(ALREADYBATCHJOBID);
        if ( null == batchJob ) {
            batchJob = new AT_BatchJob();
            batchJob.setBatchJobId(ALREADYBATCHJOBID);
            batchJob.setBatchId(ALREADYBATCHID);
            batchJob.setBatchKidouKbn(ALREADYBATCHKIDOUKBN);
            batchJob.setBatchJyoutaiKbn(ALREADYBATCHJYOUTAIKBN);
            batchJob.setBatchSyoriYmd(ALREADYBATCHSYORIYMD);
            batchJob.setBatchStartTime(String.valueOf(getSyoriTime(ALREADYBATCHSYORIYMD)));

            baseDomManager.insert(batchJob);
        }
    }

    @Transactional
    public void createTestB0022_02(){

        AT_BatchJob batchJob = baseDomManager.getBatchJob(ALREADYBATCHJOBID);
        if ( null != batchJob ) {

            for( int idx = 0; idx < 350; idx++ ) {

                AT_BatchLog batchLog = batchJob.getBatchLog(ALREADYBATCHLOGEDANO + idx);
                if ( null == batchLog ) {
                    batchLog = batchJob.createBatchLog();
                    batchLog.setBatchLogEdaNo(ALREADYBATCHLOGEDANO + idx);
                    batchLog.setLogOutputTime(String.valueOf(getSyoriTime(BizDate.getSysDate())));
                    batchLog.setLogLevelKbn(ALREADYBATCHLOGLEVELKBN);
                    batchLog.setLogNaiyou(ALREADYBATCHLOGNAIYOU + idx);

                    baseDomManager.update(batchJob);
                }
            }
        }
    }

    @Transactional
    public void deleteTestB0022_01(){

        AT_BatchJob batchJob = baseDomManager.getBatchJob(ALREADYBATCHJOBID);
        if ( null != batchJob ) {
            batchJob.getBatchLogs().removeAll(batchJob.getBatchLogs());

            baseDomManager.update(batchJob);
            baseDomManager.delete(batchJob);
        }
    }

    @Transactional
    public void createTestB0023_01(){

        AT_BatchJob batchJob = baseDomManager.getBatchJob(ALREADYBATCHJOBID);
        if ( null == batchJob ) {
            batchJob = new AT_BatchJob();
            batchJob.setBatchJobId(ALREADYBATCHJOBID);
            batchJob.setBatchId(ALREADYBATCHID);
            batchJob.setBatchKidouKbn(ALREADYBATCHKIDOUKBN);
            batchJob.setBatchJyoutaiKbn(ALREADYBATCHJYOUTAIKBN);
            batchJob.setBatchSyoriYmd(ALREADYBATCHSYORIYMD);
            batchJob.setBatchStartTime(String.valueOf(getSyoriTime(ALREADYBATCHSYORIYMD)));

            baseDomManager.insert(batchJob);
        }
    }

    @Transactional
    public void createTestB0023_02(){

        AT_BatchJob batchJob = baseDomManager.getBatchJob(ALREADYBATCHJOBID);
        if ( null != batchJob ) {

            for( int idx = 0; idx < 350; idx++ ) {

                AT_BatchLog batchLog = batchJob.getBatchLog(ALREADYBATCHLOGEDANO + idx);
                if ( null == batchLog ) {
                    batchLog = batchJob.createBatchLog();
                    batchLog.setBatchLogEdaNo(ALREADYBATCHLOGEDANO + idx);
                    batchLog.setLogOutputTime(String.valueOf(getSyoriTime(BizDate.getSysDate())));
                    batchLog.setLogLevelKbn(ALREADYBATCHLOGLEVELKBN);
                    batchLog.setLogNaiyou(ALREADYBATCHLOGNAIYOU + idx);

                    baseDomManager.update(batchJob);
                }
            }
        }
    }

    @Transactional
    public void deleteTestB0023_01(){

        AT_BatchJob batchJob = baseDomManager.getBatchJob(ALREADYBATCHJOBID);
        if ( null != batchJob ) {
            batchJob.getBatchLogs().removeAll(batchJob.getBatchLogs());

            baseDomManager.update(batchJob);
            baseDomManager.delete(batchJob);
        }
    }

    @Transactional
    public void createTestB0024_01(){

        AT_BatchJob batchJob = baseDomManager.getBatchJob(ALREADYBATCHJOBID);
        if ( null == batchJob ) {
            batchJob = new AT_BatchJob();
            batchJob.setBatchJobId(ALREADYBATCHJOBID);
            batchJob.setBatchId(ALREADYBATCHID);
            batchJob.setBatchKidouKbn(ALREADYBATCHKIDOUKBN);
            batchJob.setBatchJyoutaiKbn(ALREADYBATCHJYOUTAIKBN);
            batchJob.setBatchSyoriYmd(ALREADYBATCHSYORIYMD);
            batchJob.setBatchStartTime(String.valueOf(getSyoriTime(ALREADYBATCHSYORIYMD)));

            baseDomManager.insert(batchJob);
        }
    }

    @Transactional
    public void createTestB0024_02(){

        AT_BatchJob batchJob = baseDomManager.getBatchJob(ALREADYBATCHJOBID);
        if ( null != batchJob ) {

            for( int idx = 0; idx < 350; idx++ ) {

                AT_BatchLog batchLog = batchJob.getBatchLog(ALREADYBATCHLOGEDANO + idx);
                if ( null == batchLog ) {
                    batchLog = batchJob.createBatchLog();
                    batchLog.setBatchLogEdaNo(ALREADYBATCHLOGEDANO + idx);
                    batchLog.setLogOutputTime(String.valueOf(getSyoriTime(BizDate.getSysDate())));
                    batchLog.setLogLevelKbn(ALREADYBATCHLOGLEVELKBN);
                    batchLog.setLogNaiyou(ALREADYBATCHLOGNAIYOU + idx);

                    baseDomManager.update(batchJob);
                }
            }
        }
    }

    @Transactional
    public void deleteTestB0024_01(){

        AT_BatchJob batchJob = baseDomManager.getBatchJob(ALREADYBATCHJOBID);
        if ( null != batchJob ) {
            batchJob.getBatchLogs().removeAll(batchJob.getBatchLogs());

            baseDomManager.update(batchJob);
            baseDomManager.delete(batchJob);
        }
    }

    @Transactional
    public void createTestB0025_01(){

        AT_BatchJob batchJob = baseDomManager.getBatchJob(ALREADYBATCHJOBID);
        if ( null == batchJob ) {
            batchJob = new AT_BatchJob();
            batchJob.setBatchJobId(ALREADYBATCHJOBID);
            batchJob.setBatchId(ALREADYBATCHID);
            batchJob.setBatchKidouKbn(ALREADYBATCHKIDOUKBN);
            batchJob.setBatchJyoutaiKbn(ALREADYBATCHJYOUTAIKBN);
            batchJob.setBatchSyoriYmd(ALREADYBATCHSYORIYMD);
            batchJob.setBatchStartTime(String.valueOf(getSyoriTime(ALREADYBATCHSYORIYMD)));

            baseDomManager.insert(batchJob);
        }
    }

    @Transactional
    public void createTestB0025_02(){

        AT_BatchJob batchJob = baseDomManager.getBatchJob(ALREADYBATCHJOBID);
        if ( null != batchJob ) {

            AT_BatchLog batchLog = batchJob.getBatchLog(ALREADYBATCHLOGEDANO);
            if ( null == batchLog ) {
                batchLog = batchJob.createBatchLog();
                batchLog.setBatchLogEdaNo(ALREADYBATCHLOGEDANO);
                batchLog.setLogOutputTime(String.valueOf(getSyoriTime(BizDate.getSysDate())));
                batchLog.setLogLevelKbn(ALREADYBATCHLOGLEVELKBN);
                batchLog.setLogNaiyou(ALREADYBATCHLOGNAIYOU);

                baseDomManager.update(batchJob);
            }
        }
    }

    @Transactional
    public void deleteTestB0025_01(){

        AT_BatchJob batchJob = baseDomManager.getBatchJob(ALREADYBATCHJOBID);
        if ( null != batchJob ) {
            batchJob.getBatchLogs().removeAll(batchJob.getBatchLogs());
            batchJob.getBatchLogReports().removeAll(batchJob.getBatchLogReports());

            baseDomManager.update(batchJob);
            baseDomManager.delete(batchJob);
        }
    }

    @Transactional
    public void createTestB0026_01(){

        AT_BatchJob batchJob = baseDomManager.getBatchJob(ALREADYBATCHJOBID);
        if ( null == batchJob ) {
            batchJob = new AT_BatchJob();
            batchJob.setBatchJobId(ALREADYBATCHJOBID);
            batchJob.setBatchId(ALREADYBATCHID);
            batchJob.setBatchKidouKbn(ALREADYBATCHKIDOUKBN);
            batchJob.setBatchJyoutaiKbn(ALREADYBATCHJYOUTAIKBN);
            batchJob.setBatchSyoriYmd(ALREADYBATCHSYORIYMD);
            batchJob.setBatchStartTime(String.valueOf(getSyoriTime(ALREADYBATCHSYORIYMD)));

            baseDomManager.insert(batchJob);
        }
    }

    @Transactional
    public void createTestB0026_02(){

        AT_BatchJob batchJob = baseDomManager.getBatchJob(ALREADYBATCHJOBID);
        if ( null != batchJob ) {

            AT_BatchLog batchLog = batchJob.getBatchLog(ALREADYBATCHLOGEDANO);
            if ( null == batchLog ) {
                batchLog = batchJob.createBatchLog();
                batchLog.setBatchLogEdaNo(ALREADYBATCHLOGEDANO);
                batchLog.setLogOutputTime(String.valueOf(getSyoriTime(BizDate.getSysDate())));
                batchLog.setLogLevelKbn(ALREADYBATCHLOGLEVELKBN);
                batchLog.setLogNaiyou(ALREADYBATCHLOGNAIYOU);

                baseDomManager.update(batchJob);
            }
        }
    }

    @Transactional
    public void deleteTestB0026_01(){

        AT_BatchJob batchJob = baseDomManager.getBatchJob(ALREADYBATCHJOBID);
        if ( null != batchJob ) {
            batchJob.getBatchLogs().removeAll(batchJob.getBatchLogs());
            batchJob.getBatchLogReports().removeAll(batchJob.getBatchLogReports());

            baseDomManager.update(batchJob);
            baseDomManager.delete(batchJob);
        }
    }

    @Transactional
    public void createTestB0027_01(){

        AT_BatchJob batchJob = baseDomManager.getBatchJob(ALREADYBATCHJOBID);
        if ( null == batchJob ) {
            batchJob = new AT_BatchJob();
            batchJob.setBatchJobId(ALREADYBATCHJOBID);
            batchJob.setBatchId(ALREADYBATCHID);
            batchJob.setBatchKidouKbn(ALREADYBATCHKIDOUKBN);
            batchJob.setBatchJyoutaiKbn(ALREADYBATCHJYOUTAIKBN);
            batchJob.setBatchSyoriYmd(ALREADYBATCHSYORIYMD);
            batchJob.setBatchStartTime(String.valueOf(getSyoriTime(ALREADYBATCHSYORIYMD)));

            baseDomManager.insert(batchJob);
        }
    }

    @Transactional
    public void createTestB0027_02(){

        AT_BatchJob batchJob = baseDomManager.getBatchJob(ALREADYBATCHJOBID);
        if ( null != batchJob ) {

            AT_BatchLog batchLog = batchJob.getBatchLog(ALREADYBATCHLOGEDANO);
            if ( null == batchLog ) {
                batchLog = batchJob.createBatchLog();
                batchLog.setBatchLogEdaNo(ALREADYBATCHLOGEDANO);
                batchLog.setLogOutputTime(String.valueOf(getSyoriTime(BizDate.getSysDate())));
                batchLog.setLogLevelKbn(ALREADYBATCHLOGLEVELKBN);
                batchLog.setLogNaiyou(ALREADYBATCHLOGNAIYOU);

                baseDomManager.update(batchJob);
            }
        }
    }

    @Transactional
    public void deleteTestB0027_01(){

        AT_BatchJob batchJob = baseDomManager.getBatchJob(ALREADYBATCHJOBID);
        if ( null != batchJob ) {
            batchJob.getBatchLogs().removeAll(batchJob.getBatchLogs());
            batchJob.getBatchLogReports().removeAll(batchJob.getBatchLogReports());

            baseDomManager.update(batchJob);
            baseDomManager.delete(batchJob);
        }
    }
    @Transactional
    public void createTestB0028_01(){

        AT_BatchJob batchJob = baseDomManager.getBatchJob(ALREADYBATCHJOBID);
        if ( null == batchJob ) {
            batchJob = new AT_BatchJob();
            batchJob.setBatchJobId(ALREADYBATCHJOBID);
            batchJob.setBatchId(ALREADYBATCHID);
            batchJob.setBatchKidouKbn(ALREADYBATCHKIDOUKBN);
            batchJob.setBatchJyoutaiKbn(ALREADYBATCHJYOUTAIKBN);
            batchJob.setBatchSyoriYmd(ALREADYBATCHSYORIYMD);
            batchJob.setBatchStartTime(String.valueOf(getSyoriTime(ALREADYBATCHSYORIYMD)));

            baseDomManager.insert(batchJob);
        }
    }

    @Transactional
    public void createTestB0028_02(){

        AT_BatchJob batchJob = baseDomManager.getBatchJob(ALREADYBATCHJOBID);
        if ( null != batchJob ) {

            AT_BatchLog batchLog = batchJob.getBatchLog(ALREADYBATCHLOGEDANO);
            if ( null == batchLog ) {
                batchLog = batchJob.createBatchLog();
                batchLog.setBatchLogEdaNo(ALREADYBATCHLOGEDANO);
                batchLog.setLogOutputTime(String.valueOf(getSyoriTime(BizDate.getSysDate())));
                batchLog.setLogLevelKbn(ALREADYBATCHLOGLEVELKBN);
                batchLog.setLogNaiyou(ALREADYBATCHLOGNAIYOU);

                baseDomManager.update(batchJob);
            }
        }
    }

    @Transactional
    public void deleteTestB0028_01(){

        AT_BatchJob batchJob = baseDomManager.getBatchJob(ALREADYBATCHJOBID);
        if ( null != batchJob ) {
            batchJob.getBatchLogs().removeAll(batchJob.getBatchLogs());
            batchJob.getBatchLogReports().removeAll(batchJob.getBatchLogReports());

            baseDomManager.update(batchJob);
            baseDomManager.delete(batchJob);
        }
    }

    private long getSyoriTime(BizDate pSyoriYmd){

        Date syoriTime = pSyoriYmd.toDate();
        Calendar calendar = GregorianCalendar.getInstance();
        calendar.setTime(syoriTime);

        return Long.valueOf(calendar.getTimeInMillis());
    }
}
