package yuyu.def.db.entity;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.core.test.SWAKTestRunner;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.def.base.manager.BaseDomManager;
import yuyu.def.classification.C_BatchJyoutaiKbn;
import yuyu.def.classification.C_BatchKidouKbn;
import yuyu.def.classification.C_BatchModeKbn;
import yuyu.def.classification.C_KahiKbn;
import yuyu.def.classification.C_LogLevelKbn;

import com.google.common.base.Predicate;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Iterables;

/**
 * バッチログテーブル エンティティのテストクラス<br />
 */
@RunWith(SWAKTestRunner.class)
public class AT_BatchLogEntityTest implements EntityTestInterface {

    @Inject
    private BaseDomManager baseDomManager;

    @BeforeClass
    @Transactional
    public static void insertTestData() {
        BaseDomManager baseDomManager = SWAKInjector.getInstance(BaseDomManager.class);

        String pKinouId = "KI00000001";
        String pBatchClass = "BC00000001";
        C_KahiKbn pTajuukidouKahiKbn = C_KahiKbn.KA;
        C_BatchModeKbn pBatchMode = C_BatchModeKbn .HIDOUKI;
        C_KahiKbn pTyuudanKahi = C_KahiKbn.HUKA;

        AM_Batch aM_Batch = baseDomManager.getBatch(pKinouId);
        if ( null == aM_Batch ) {

            aM_Batch = new AM_Batch();
            aM_Batch.setKinouId(pKinouId);
            aM_Batch.setBatchClass(pBatchClass);
            aM_Batch.setTajuukidouKahiKbn(pTajuukidouKahiKbn);
            aM_Batch.setBatchMode(pBatchMode);
            aM_Batch.setTyuudanKahi(pTyuudanKahi);

            baseDomManager.insert(aM_Batch);
        }

        AS_Kinou aS_Kinou = baseDomManager.getKinou(pKinouId);
        if ( null == aS_Kinou ){

            aS_Kinou = new AS_Kinou();
            aS_Kinou.setKinouId(pKinouId);

            baseDomManager.insert(aS_Kinou);
        }


        String pBatchJobId = "BJI0000001";
        C_BatchKidouKbn pBatchKidouKbn = C_BatchKidouKbn.BATCH;
        C_BatchJyoutaiKbn pBatchJyoutaiKbn =  C_BatchJyoutaiKbn.SYUURYOU;

        AT_BatchJob aT_BatchJob = baseDomManager.getBatchJob(pBatchJobId);
        if ( null == aT_BatchJob ) {

            aT_BatchJob = new AT_BatchJob();
            aT_BatchJob.setBatchJobId(pBatchJobId);
            aT_BatchJob.setBatchId(pKinouId);
            aT_BatchJob.setBatchKidouKbn(pBatchKidouKbn);
            aT_BatchJob.setBatchJyoutaiKbn(pBatchJyoutaiKbn);

            baseDomManager.insert(aT_BatchJob);

        }

        int pBatchLogEdaNo1 = 1;
        int pBatchLogEdaNo2 = 2;
        int pBatchLogEdaNo3 = 3;
        int pBatchLogEdaNo4 = 4;
        int pBatchLogEdaNo5 = 5;
        String pLogOutputTime1 = "20150706114412999";
        String pLogOutputTime2 = "20150706114412999";
        String pLogOutputTime3 = "20150706114412999";
        String pLogOutputTime4 = "20150706114412999";
        String pLogOutputTime5 = "20150706114412999";
        C_LogLevelKbn pLogLevelKbn1 = C_LogLevelKbn.INFO;
        C_LogLevelKbn pLogLevelKbn2 = C_LogLevelKbn.WARN;
        C_LogLevelKbn pLogLevelKbn3 = C_LogLevelKbn.ERROR;
        C_LogLevelKbn pLogLevelKbn4 = C_LogLevelKbn.ERROR;
        C_LogLevelKbn pLogLevelKbn5 = C_LogLevelKbn.INFO;

        AT_BatchLog aT_BatchLog1 = baseDomManager.getBatchJob(pBatchJobId).getBatchLog(pBatchLogEdaNo1);
        if ( null == aT_BatchLog1 ) {

            aT_BatchLog1 = aT_BatchJob.createBatchLog();
            aT_BatchLog1.setBatchLogEdaNo(pBatchLogEdaNo1);
            aT_BatchLog1.setLogOutputTime(pLogOutputTime1);
            aT_BatchLog1.setLogLevelKbn(pLogLevelKbn1);

        }

        AT_BatchLog aT_BatchLog2 = baseDomManager.getBatchJob(pBatchJobId).getBatchLog(pBatchLogEdaNo2);
        if ( null == aT_BatchLog2 ) {

            aT_BatchLog2 = aT_BatchJob.createBatchLog();
            aT_BatchLog2.setBatchLogEdaNo(pBatchLogEdaNo2);
            aT_BatchLog2.setLogOutputTime(pLogOutputTime2);
            aT_BatchLog2.setLogLevelKbn(pLogLevelKbn2);

        }

        AT_BatchLog aT_BatchLog3 = baseDomManager.getBatchJob(pBatchJobId).getBatchLog(pBatchLogEdaNo3);
        if ( null == aT_BatchLog3 ) {

            aT_BatchLog3 = aT_BatchJob.createBatchLog();
            aT_BatchLog3.setBatchLogEdaNo(pBatchLogEdaNo3);
            aT_BatchLog3.setLogOutputTime(pLogOutputTime3);
            aT_BatchLog3.setLogLevelKbn(pLogLevelKbn3);

        }

        AT_BatchLog aT_BatchLog4 = baseDomManager.getBatchJob(pBatchJobId).getBatchLog(pBatchLogEdaNo4);
        if ( null == aT_BatchLog4 ) {

            aT_BatchLog4 = aT_BatchJob.createBatchLog();
            aT_BatchLog4.setBatchLogEdaNo(pBatchLogEdaNo4);
            aT_BatchLog4.setLogOutputTime(pLogOutputTime4);
            aT_BatchLog4.setLogLevelKbn(pLogLevelKbn4);

        }

        AT_BatchLog aT_BatchLog5 = baseDomManager.getBatchJob(pBatchJobId).getBatchLog(pBatchLogEdaNo5);
        if ( null == aT_BatchLog5 ) {

            aT_BatchLog5 = aT_BatchJob.createBatchLog();
            aT_BatchLog5.setBatchLogEdaNo(pBatchLogEdaNo5);
            aT_BatchLog5.setLogOutputTime(pLogOutputTime5);
            aT_BatchLog5.setLogLevelKbn(pLogLevelKbn5);

        }
        baseDomManager.update(aT_BatchJob);

    }

    @AfterClass
    @Transactional
    public static void deleteTestData() {
        BaseDomManager baseDomManager = SWAKInjector.getInstance(BaseDomManager.class);

        String pBatchJobId = "BJI0000001";
        AT_BatchJob aT_BatchJob = baseDomManager.getBatchJob(pBatchJobId);

        if ( null != aT_BatchJob ) {

            aT_BatchJob.getBatchLogs().removeAll(aT_BatchJob.getBatchLogs());

            baseDomManager.update(aT_BatchJob);
            baseDomManager.delete(aT_BatchJob);
        }

        String pKinouId = "KI00000001";

        AM_Batch aM_Batch = baseDomManager.getBatch(pKinouId);
        if ( null != aM_Batch ) {

            baseDomManager.delete(aM_Batch);
        }
    }

    @Override
    @Test
    public void getAll() {

        String pBatchJobId = "BJI0000001";
        List<AT_BatchLog> batchLogList = baseDomManager.getBatchJob(pBatchJobId).getBatchLogs();

        List<AT_BatchLog> resultBatchLogList = ImmutableList.copyOf(Iterables.filter(batchLogList, new Predicate<AT_BatchLog>() {

            @Override
            public boolean apply(AT_BatchLog pBatchLogEntity) {

                List<Integer> batchLogEdaNoList = new ArrayList<Integer>();
                batchLogEdaNoList.add(1);
                batchLogEdaNoList.add(2);
                batchLogEdaNoList.add(3);
                batchLogEdaNoList.add(4);
                batchLogEdaNoList.add(5);

                for (Integer categoryId : batchLogEdaNoList) {
                    if (categoryId.equals(pBatchLogEntity.getBatchLogEdaNo())) {
                        return true;
                    }
                }

                return false;
            }

        }));

        long count = resultBatchLogList.size();
        assertEquals(5, count);
    }

    @Override
    @Test
    public void getUniqueEntity() {
        String pBatchJobId = "BJI0000001";
        int pBatchLogEdaNo = 1;
        AT_BatchLog aT_BatchLog = baseDomManager.getBatchJob(pBatchJobId).getBatchLog(pBatchLogEdaNo);

        assertEquals(pBatchJobId, aT_BatchLog.getBatchJobId());

    }

    @Override
    @Test
    public void noUniqueEntity() {
        String pBatchJobId = "BJI0000001";
        int pBatchLogEdaNo = 99;
        AT_BatchLog aT_BatchLog = baseDomManager.getBatchJob(pBatchJobId).getBatchLog(pBatchLogEdaNo);

        assertNull(aT_BatchLog);
    }

    @Override
    @Test
    public void blankCondition() {

    }

    @Override
    @Test
    public void nullCondition() {
    }
}
