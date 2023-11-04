package yuyu.def.base.manager;

import static org.junit.Assert.*;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.core.test.SWAKTestRunner;
import jp.co.slcs.swak.date.BizDate;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.def.classification.C_BatchJyoutaiKbn;
import yuyu.def.classification.C_BatchKidouKbn;
import yuyu.def.classification.C_BatchModeKbn;
import yuyu.def.classification.C_BatchResultKbn;
import yuyu.def.classification.C_KahiKbn;
import yuyu.def.db.entity.AM_Batch;
import yuyu.def.db.entity.AS_Kinou;
import yuyu.def.db.entity.AT_BatchJob;
import yuyu.testinfr.AbstractTest;

/**
 * BaseDomManagerクラスの、<br />
 * getBatchJobCountByIdSyoriYmdJyoutaiKbnResultKbn() メソッドのテストクラスです。
 */
@RunWith(SWAKTestRunner.class)
public class BaseDomManagerTest_getBatchJobCountByIdSyoriYmdJyoutaiKbnResultKbn
extends AbstractTest {

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

        String pBatchJobId1 = "BJI0000001";
        String pBatchJobId2 = "BJI0000002";
        String pBatchJobId3 = "BJI0000003";
        String pBatchJobId4 = "BJI0000004";
        String pBatchJobId5 = "BJI0000005";
        String pBatchJobId6 = "BJI0000006";
        String pBatchJobId7 = "BJI0000007";
        C_BatchKidouKbn pBatchKidouKbn1 = C_BatchKidouKbn.BATCH;
        C_BatchKidouKbn pBatchKidouKbn2 = C_BatchKidouKbn.BATCH;
        C_BatchKidouKbn pBatchKidouKbn3 = C_BatchKidouKbn.GAMEN;
        C_BatchKidouKbn pBatchKidouKbn4 = C_BatchKidouKbn.GAMEN;
        C_BatchKidouKbn pBatchKidouKbn5 = C_BatchKidouKbn.GAMEN;
        C_BatchJyoutaiKbn pBatchJyoutaiKbn1 = C_BatchJyoutaiKbn.TAIKI;
        C_BatchJyoutaiKbn pBatchJyoutaiKbn2 = C_BatchJyoutaiKbn.SYORI;
        C_BatchJyoutaiKbn pBatchJyoutaiKbn3 = C_BatchJyoutaiKbn.SYUURYOU_TYU;
        C_BatchJyoutaiKbn pBatchJyoutaiKbn4 = C_BatchJyoutaiKbn.SYUURYOU;
        C_BatchJyoutaiKbn pBatchJyoutaiKbn5 = C_BatchJyoutaiKbn.TAIKI;
        C_BatchResultKbn pBatchResultKbn1 = C_BatchResultKbn.NORMAL;
        C_BatchResultKbn pBatchResultKbn2 = C_BatchResultKbn.WARN;
        C_BatchResultKbn pBatchResultKbn3 = C_BatchResultKbn.ERROR;
        C_BatchResultKbn pBatchResultKbn4 = C_BatchResultKbn.INTERRUPT;
        C_BatchResultKbn pBatchResultKbn5 = C_BatchResultKbn.NORMAL;
        BizDate pBatchSyoriYmd1 = BizDate.valueOf("20150309");
        BizDate pBatchSyoriYmd2 = BizDate.valueOf("20150409");
        BizDate pBatchSyoriYmd3 = BizDate.valueOf("20150509");
        BizDate pBatchSyoriYmd4 = BizDate.valueOf("20150609");
        BizDate pBatchSyoriYmd5 = BizDate.valueOf("20150709");
        BizDate pBatchSyoriYmd6 = BizDate.valueOf("20150809");
        BizDate pBatchSyoriYmd7 = BizDate.valueOf("20150909");

        AT_BatchJob aT_BatchJob1 = baseDomManager.getBatchJob(pBatchJobId1);
        if ( null == aT_BatchJob1 ) {

            aT_BatchJob1 = new AT_BatchJob();
            aT_BatchJob1.setBatchId(pKinouId);
            aT_BatchJob1.setBatchKidouKbn(pBatchKidouKbn1);
            aT_BatchJob1.setBatchJobId(pBatchJobId1);
            aT_BatchJob1.setBatchJyoutaiKbn(pBatchJyoutaiKbn1);
            aT_BatchJob1.setBatchResultKbn(pBatchResultKbn1);
            aT_BatchJob1.setBatchSyoriYmd(pBatchSyoriYmd1);

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
            aT_BatchJob2.setBatchSyoriYmd(pBatchSyoriYmd2);

            baseDomManager.insert(aT_BatchJob2);
        }

        AT_BatchJob aT_BatchJob3 = baseDomManager.getBatchJob(pBatchJobId3);
        if ( null == aT_BatchJob3 ) {

            aT_BatchJob3 = new AT_BatchJob();
            aT_BatchJob3.setBatchId(pKinouId);
            aT_BatchJob3.setBatchKidouKbn(pBatchKidouKbn3);
            aT_BatchJob3.setBatchJobId(pBatchJobId3);
            aT_BatchJob3.setBatchJyoutaiKbn(pBatchJyoutaiKbn3);
            aT_BatchJob3.setBatchResultKbn(pBatchResultKbn3);
            aT_BatchJob3.setBatchSyoriYmd(pBatchSyoriYmd3);

            baseDomManager.insert(aT_BatchJob3);
        }

        AT_BatchJob aT_BatchJob4 = baseDomManager.getBatchJob(pBatchJobId4);
        if ( null == aT_BatchJob4 ) {

            aT_BatchJob4 = new AT_BatchJob();
            aT_BatchJob4.setBatchId(pKinouId);
            aT_BatchJob4.setBatchKidouKbn(pBatchKidouKbn4);
            aT_BatchJob4.setBatchJobId(pBatchJobId4);
            aT_BatchJob4.setBatchJyoutaiKbn(pBatchJyoutaiKbn4);
            aT_BatchJob4.setBatchResultKbn(pBatchResultKbn4);
            aT_BatchJob4.setBatchSyoriYmd(pBatchSyoriYmd4);

            baseDomManager.insert(aT_BatchJob4);
        }

        AT_BatchJob aT_BatchJob5 = baseDomManager.getBatchJob(pBatchJobId5);
        if ( null == aT_BatchJob5 ) {

            aT_BatchJob5 = new AT_BatchJob();
            aT_BatchJob5.setBatchId(pKinouId);
            aT_BatchJob5.setBatchKidouKbn(pBatchKidouKbn5);
            aT_BatchJob5.setBatchJobId(pBatchJobId5);
            aT_BatchJob5.setBatchJyoutaiKbn(pBatchJyoutaiKbn5);
            aT_BatchJob5.setBatchResultKbn(pBatchResultKbn5);
            aT_BatchJob5.setBatchSyoriYmd(pBatchSyoriYmd5);

            baseDomManager.insert(aT_BatchJob5);
        }

        AT_BatchJob aT_BatchJob6 = baseDomManager.getBatchJob(pBatchJobId6);
        if ( null == aT_BatchJob6 ) {

            aT_BatchJob6 = new AT_BatchJob();
            aT_BatchJob6.setBatchId(pKinouId);
            aT_BatchJob6.setBatchKidouKbn(pBatchKidouKbn5);
            aT_BatchJob6.setBatchJobId(pBatchJobId6);
            aT_BatchJob6.setBatchJyoutaiKbn(pBatchJyoutaiKbn5);
            aT_BatchJob6.setBatchResultKbn(pBatchResultKbn5);
            aT_BatchJob6.setBatchSyoriYmd(pBatchSyoriYmd6);

            baseDomManager.insert(aT_BatchJob6);
        }

        AT_BatchJob aT_BatchJob7 = baseDomManager.getBatchJob(pBatchJobId7);
        if ( null == aT_BatchJob7 ) {

            aT_BatchJob7 = new AT_BatchJob();
            aT_BatchJob7.setBatchId(pKinouId);
            aT_BatchJob7.setBatchKidouKbn(pBatchKidouKbn5);
            aT_BatchJob7.setBatchJobId(pBatchJobId7);
            aT_BatchJob7.setBatchJyoutaiKbn(pBatchJyoutaiKbn5);
            aT_BatchJob7.setBatchResultKbn(pBatchResultKbn5);
            aT_BatchJob7.setBatchSyoriYmd(pBatchSyoriYmd7);

            baseDomManager.insert(aT_BatchJob7);
        }

    }

    @AfterClass
    @Transactional
    public static void deleteTestData() {
        BaseDomManager baseDomManager = SWAKInjector.getInstance(BaseDomManager.class);

        String pBatchJobId1 = "BJI0000001";
        String pBatchJobId2 = "BJI0000002";
        String pBatchJobId3 = "BJI0000003";
        String pBatchJobId4 = "BJI0000004";
        String pBatchJobId5 = "BJI0000005";
        String pBatchJobId6 = "BJI0000006";
        String pBatchJobId7 = "BJI0000007";

        AT_BatchJob aT_BatchJob1 = baseDomManager.getBatchJob(pBatchJobId1);
        if ( null != aT_BatchJob1 ) {

            baseDomManager.delete(aT_BatchJob1);
        }

        AT_BatchJob aT_BatchJob2 = baseDomManager.getBatchJob(pBatchJobId2);
        if ( null != aT_BatchJob2 ) {

            baseDomManager.delete(aT_BatchJob2);
        }

        AT_BatchJob aT_BatchJob3 = baseDomManager.getBatchJob(pBatchJobId3);
        if ( null != aT_BatchJob3 ) {

            baseDomManager.delete(aT_BatchJob3);
        }

        AT_BatchJob aT_BatchJob4 = baseDomManager.getBatchJob(pBatchJobId4);
        if ( null != aT_BatchJob4 ) {

            baseDomManager.delete(aT_BatchJob4);
        }

        AT_BatchJob aT_BatchJob5 = baseDomManager.getBatchJob(pBatchJobId5);
        if ( null != aT_BatchJob5 ) {

            baseDomManager.delete(aT_BatchJob5);
        }

        AT_BatchJob aT_BatchJob6 = baseDomManager.getBatchJob(pBatchJobId6);
        if ( null != aT_BatchJob6 ) {

            baseDomManager.delete(aT_BatchJob6);
        }

        AT_BatchJob aT_BatchJob7 = baseDomManager.getBatchJob(pBatchJobId7);
        if ( null != aT_BatchJob7 ) {

            baseDomManager.delete(aT_BatchJob7);
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
        String[] pBatchIds = {"KI00000097","KI00000098","KI00000099"};
        BizDate pBatchSyoriYmdFrom = BizDate.valueOf("20200101");
        BizDate pBatchSyoriYmdTo = BizDate.valueOf("20201231");
        C_BatchJyoutaiKbn[] pBatchJyoutaiKbns = {C_BatchJyoutaiKbn.SYORI, C_BatchJyoutaiKbn.SYUURYOU_TYU};
        C_BatchResultKbn[] pBatchResultKbns = {C_BatchResultKbn.ERROR, C_BatchResultKbn.NORMAL};
        long count = baseDomManager.getBatchJobCountByIdSyoriYmdJyoutaiKbnResultKbn(pBatchIds, pBatchSyoriYmdFrom, pBatchSyoriYmdTo, pBatchJyoutaiKbns, pBatchResultKbns);

        assertEquals(0, count);
    }

    @Test
    public void test002(){
        String[] pBatchIds = {"KI00000001","KI00000098","KI00000099"};
        BizDate pBatchSyoriYmdFrom = BizDate.valueOf("20000101");
        BizDate pBatchSyoriYmdTo = BizDate.valueOf("20150331");
        C_BatchJyoutaiKbn[] pBatchJyoutaiKbns = {C_BatchJyoutaiKbn.SYORI, C_BatchJyoutaiKbn.TAIKI, C_BatchJyoutaiKbn.SYUURYOU_TYU};
        C_BatchResultKbn[] pBatchResultKbns = {C_BatchResultKbn.ERROR, C_BatchResultKbn.NORMAL};
        long count = baseDomManager.getBatchJobCountByIdSyoriYmdJyoutaiKbnResultKbn(pBatchIds, pBatchSyoriYmdFrom, pBatchSyoriYmdTo, pBatchJyoutaiKbns, pBatchResultKbns);

        assertEquals(1, count);
    }

    @Test
    public void test003(){
        String[] pBatchIds = {"KI00000001","KI00000098","KI00000099"};
        BizDate pBatchSyoriYmdFrom = BizDate.valueOf("20000101");
        BizDate pBatchSyoriYmdTo = BizDate.valueOf("20150710");
        C_BatchJyoutaiKbn[] pBatchJyoutaiKbns = {C_BatchJyoutaiKbn.SYORI, C_BatchJyoutaiKbn.TAIKI, C_BatchJyoutaiKbn.SYUURYOU_TYU};
        C_BatchResultKbn[] pBatchResultKbns = {C_BatchResultKbn.WARN, C_BatchResultKbn.NORMAL};
        long count = baseDomManager.getBatchJobCountByIdSyoriYmdJyoutaiKbnResultKbn(pBatchIds, pBatchSyoriYmdFrom, pBatchSyoriYmdTo, pBatchJyoutaiKbns, pBatchResultKbns);

        assertEquals(3, count);
    }

    @Test
    public void test004(){
        String[] pBatchIds = {null};
        BizDate pBatchSyoriYmdFrom = null;
        BizDate pBatchSyoriYmdTo = null;
        C_BatchJyoutaiKbn[] pBatchJyoutaiKbns = {null, null};
        C_BatchResultKbn[] pBatchResultKbns = {null, null};
        long count = baseDomManager.getBatchJobCountByIdSyoriYmdJyoutaiKbnResultKbn(pBatchIds, pBatchSyoriYmdFrom, pBatchSyoriYmdTo, pBatchJyoutaiKbns, pBatchResultKbns);

        assertEquals(0, count);
    }

    @Test
    public void test005(){
        String[] pBatchIds = {"KI00000001"};
        BizDate pBatchSyoriYmdFrom = BizDate.valueOf("20150409");
        BizDate pBatchSyoriYmdTo = BizDate.valueOf("20150809");
        C_BatchJyoutaiKbn[] pBatchJyoutaiKbns = {C_BatchJyoutaiKbn.TAIKI, C_BatchJyoutaiKbn.SYORI, C_BatchJyoutaiKbn.SYUURYOU_TYU, C_BatchJyoutaiKbn.SYUURYOU};
        C_BatchResultKbn[] pBatchResultKbns = {C_BatchResultKbn.NORMAL, C_BatchResultKbn.WARN, C_BatchResultKbn.ERROR, C_BatchResultKbn.INTERRUPT};
        long count = baseDomManager.getBatchJobCountByIdSyoriYmdJyoutaiKbnResultKbn(pBatchIds, pBatchSyoriYmdFrom, pBatchSyoriYmdTo, pBatchJyoutaiKbns, pBatchResultKbns);

        assertEquals(5, count);
    }

}
