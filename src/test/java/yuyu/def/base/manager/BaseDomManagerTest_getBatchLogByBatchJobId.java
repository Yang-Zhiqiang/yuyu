package yuyu.def.base.manager;

import static org.junit.Assert.*;

import java.util.List;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.core.test.SWAKTestRunner;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.def.classification.C_BatchJyoutaiKbn;
import yuyu.def.classification.C_BatchKidouKbn;
import yuyu.def.classification.C_BatchModeKbn;
import yuyu.def.classification.C_BatchResultKbn;
import yuyu.def.classification.C_KahiKbn;
import yuyu.def.classification.C_LogLevelKbn;
import yuyu.def.db.entity.AM_Batch;
import yuyu.def.db.entity.AS_Kinou;
import yuyu.def.db.entity.AT_BatchJob;
import yuyu.def.db.entity.AT_BatchLog;
import yuyu.testinfr.AbstractTest;

/**
 * BaseDomManagerクラスの、<br />
 * getBatchLogByBatchJobId() メソッドのテストクラスです。
 */
@RunWith(SWAKTestRunner.class)
public class BaseDomManagerTest_getBatchLogByBatchJobId extends AbstractTest {

    @Inject
    BaseDomManager baseDomManager;

    @BeforeClass
    @Transactional
    public static void insertTestData() {
        BaseDomManager baseDomManager = SWAKInjector.getInstance(BaseDomManager.class);

        String pKinouId = "KI00000001";

        AS_Kinou aS_Kinou = baseDomManager.getKinou(pKinouId);
        if ( null == aS_Kinou ){

            aS_Kinou = new AS_Kinou();
            aS_Kinou.setKinouId(pKinouId);

            baseDomManager.insert(aS_Kinou);
        }

        String pBatchClass = "BC00000001";
        C_KahiKbn pTajuukidouKahiKbn1 = C_KahiKbn.KA;
        C_BatchModeKbn pBatchMode1 = C_BatchModeKbn .HIDOUKI;
        C_KahiKbn pTyuudanKahi1 = C_KahiKbn.HUKA;

        AM_Batch aM_Batch1 = baseDomManager.getBatch(pKinouId);
        if ( null == aM_Batch1 ) {

            aM_Batch1 = new AM_Batch();
            aM_Batch1.setKinouId(pKinouId);
            aM_Batch1.setBatchClass(pBatchClass);
            aM_Batch1.setTajuukidouKahiKbn(pTajuukidouKahiKbn1);
            aM_Batch1.setBatchMode(pBatchMode1);
            aM_Batch1.setTyuudanKahi(pTyuudanKahi1);

            baseDomManager.insert(aM_Batch1);
        }

        String pBatchJobId1 = "BJI0000005";
        String pBatchJobId2 = "BJI0000004";
        C_BatchKidouKbn pBatchKidouKbn1 = C_BatchKidouKbn.GAMEN;
        C_BatchKidouKbn pBatchKidouKbn2 = C_BatchKidouKbn.GAMEN;
        C_BatchJyoutaiKbn pBatchJyoutaiKbn1 = C_BatchJyoutaiKbn.TAIKI;
        C_BatchJyoutaiKbn pBatchJyoutaiKbn2 = C_BatchJyoutaiKbn.SYUURYOU;
        C_BatchResultKbn pBatchResultKbn1 = C_BatchResultKbn.NORMAL;
        C_BatchResultKbn pBatchResultKbn2 = C_BatchResultKbn.INTERRUPT;

        AT_BatchJob aT_BatchJob1 = baseDomManager.getBatchJob(pBatchJobId1);
        if ( null == aT_BatchJob1 ) {

            aT_BatchJob1 = new AT_BatchJob();
            aT_BatchJob1.setBatchId(pKinouId);
            aT_BatchJob1.setBatchKidouKbn(pBatchKidouKbn1);
            aT_BatchJob1.setBatchJobId(pBatchJobId1);
            aT_BatchJob1.setBatchJyoutaiKbn(pBatchJyoutaiKbn1);
            aT_BatchJob1.setBatchResultKbn(pBatchResultKbn1);

            baseDomManager.insert(aT_BatchJob1);
        }

        AT_BatchJob aT_BatchJob2 = baseDomManager.getBatchJob(pBatchJobId2);
        if ( null == aT_BatchJob2 ) {

            aT_BatchJob2 = new AT_BatchJob();
            aT_BatchJob2.setBatchId(pKinouId);
            aT_BatchJob2.setBatchKidouKbn(pBatchKidouKbn2);
            aT_BatchJob2.setBatchJobId(pBatchJobId2);
            aT_BatchJob2.setBatchJyoutaiKbn(pBatchJyoutaiKbn2);
            aT_BatchJob2.setBatchResultKbn(pBatchResultKbn2);

            baseDomManager.insert(aT_BatchJob2);
        }

        int pBatchLogEdaNo1 = 4;
        int pBatchLogEdaNo2 = 2;
        int pBatchLogEdaNo3 = 1;
        int pBatchLogEdaNo4 = 3;
        String pLogOutputTime1 = "20150706114412999";
        String pLogOutputTime2 = "20150706114412999";
        String pLogOutputTime3 = "20150706114412999";
        String pLogOutputTime4 = "20150706114412999";
        C_LogLevelKbn pLogLevelKbn1 = C_LogLevelKbn.INFO;
        C_LogLevelKbn pLogLevelKbn2 = C_LogLevelKbn.WARN;
        C_LogLevelKbn pLogLevelKbn3 = C_LogLevelKbn.ERROR;
        C_LogLevelKbn pLogLevelKbn4 = C_LogLevelKbn.ERROR;

        AT_BatchLog aT_BatchLog1 = aT_BatchJob1.getBatchLog(pBatchLogEdaNo1);
        if ( null == aT_BatchLog1 ) {

            aT_BatchLog1 = aT_BatchJob1.createBatchLog();
            aT_BatchLog1.setBatchLogEdaNo(pBatchLogEdaNo1);
            aT_BatchLog1.setLogOutputTime(pLogOutputTime1);
            aT_BatchLog1.setLogLevelKbn(pLogLevelKbn1);

        }

        AT_BatchLog aT_BatchLog2 = aT_BatchJob1.getBatchLog(pBatchLogEdaNo2);
        if ( null == aT_BatchLog2 ) {

            aT_BatchLog2 = aT_BatchJob1.createBatchLog();
            aT_BatchLog2.setBatchLogEdaNo(pBatchLogEdaNo2);
            aT_BatchLog2.setLogOutputTime(pLogOutputTime2);
            aT_BatchLog2.setLogLevelKbn(pLogLevelKbn2);

        }

        AT_BatchLog aT_BatchLog3 = aT_BatchJob1.getBatchLog(pBatchLogEdaNo3);
        if ( null == aT_BatchLog3 ) {

            aT_BatchLog3 = aT_BatchJob1.createBatchLog();
            aT_BatchLog3.setBatchLogEdaNo(pBatchLogEdaNo3);
            aT_BatchLog3.setLogOutputTime(pLogOutputTime3);
            aT_BatchLog3.setLogLevelKbn(pLogLevelKbn3);

        }

        baseDomManager.update(aT_BatchJob1);

        AT_BatchLog aT_BatchLog4 = aT_BatchJob2.getBatchLog(pBatchLogEdaNo4);
        if ( null == aT_BatchLog4 ) {

            aT_BatchLog4 = aT_BatchJob2.createBatchLog();
            aT_BatchLog4.setBatchLogEdaNo(pBatchLogEdaNo4);
            aT_BatchLog4.setLogOutputTime(pLogOutputTime4);
            aT_BatchLog4.setLogLevelKbn(pLogLevelKbn4);

        }

        baseDomManager.update(aT_BatchJob2);

    }

    @AfterClass
    @Transactional
    public static void deleteTestData() {
        BaseDomManager baseDomManager = SWAKInjector.getInstance(BaseDomManager.class);

        String pBatchJobId1 = "BJI0000005";
        String pBatchJobId2 = "BJI0000004";

        AT_BatchJob aT_BatchJob1 = baseDomManager.getBatchJob(pBatchJobId1);
        if ( null != aT_BatchJob1 ) {

            aT_BatchJob1.getBatchLogs().removeAll(aT_BatchJob1.getBatchLogs());

            baseDomManager.update(aT_BatchJob1);
            baseDomManager.delete(aT_BatchJob1);
        }

        AT_BatchJob aT_BatchJob2 = baseDomManager.getBatchJob(pBatchJobId2);
        if ( null != aT_BatchJob2 ) {

            aT_BatchJob2.getBatchLogs().removeAll(aT_BatchJob2.getBatchLogs());

            baseDomManager.update(aT_BatchJob2);
            baseDomManager.delete(aT_BatchJob2);
        }

        String pKinouId = "KI00000001";
        AM_Batch aM_Batch = baseDomManager.getBatch(pKinouId);
        if ( null != aM_Batch ) {

            baseDomManager.delete(aM_Batch);
        }

        AS_Kinou aS_Kinou = baseDomManager.getKinou(pKinouId);
        if ( null != aS_Kinou ) {

            baseDomManager.delete(aS_Kinou);
        }
    }

    @Test
    public void test001(){
        String pBatchJobId = "BJI0000099";
        List<AT_BatchLog> aT_BatchLogList = baseDomManager.getBatchLogByBatchJobId(pBatchJobId);

        assertEquals(0, aT_BatchLogList.size());

    }

    @Test
    public void test002(){
        String pBatchJobId = "BJI0000004";
        List<AT_BatchLog> aT_BatchLogList = baseDomManager.getBatchLogByBatchJobId(pBatchJobId);

        assertEquals(1, aT_BatchLogList.size());

    }

    @Test
    public void test003(){
        String pBatchJobId = "BJI0000005";
        List<AT_BatchLog> aT_BatchLogList = baseDomManager.getBatchLogByBatchJobId(pBatchJobId);

        assertEquals(3, aT_BatchLogList.size());

    }

    @Test
    public void test004(){
        String pBatchJobId = "";
        List<AT_BatchLog> aT_BatchLogList = baseDomManager.getBatchLogByBatchJobId(pBatchJobId);

        assertEquals(0, aT_BatchLogList.size());

    }

    @Test
    public void test005(){
        String pBatchJobId = null;
        List<AT_BatchLog> aT_BatchLogList = baseDomManager.getBatchLogByBatchJobId(pBatchJobId);

        assertEquals(0, aT_BatchLogList.size());

    }

    @Test
    public void test006(){
        String pBatchJobId = "BJI0000005";
        List<AT_BatchLog> aT_BatchLogList = baseDomManager.getBatchLogByBatchJobId(pBatchJobId);

        Integer pBatchLogEdaNo1 = 4;
        Integer pBatchLogEdaNo2 = 2;
        Integer pBatchLogEdaNo3 = 1;

        assertEquals(pBatchLogEdaNo3, aT_BatchLogList.get(0).getBatchLogEdaNo());
        assertEquals(pBatchLogEdaNo2, aT_BatchLogList.get(1).getBatchLogEdaNo());
        assertEquals(pBatchLogEdaNo1, aT_BatchLogList.get(2).getBatchLogEdaNo());
    }
}
