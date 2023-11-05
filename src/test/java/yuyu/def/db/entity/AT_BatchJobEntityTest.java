package yuyu.def.db.entity;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import javax.inject.Inject;
import javax.persistence.NonUniqueResultException;
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

/**
 * バッチジョブテーブル エンティティのテストクラス<br />
 */
@RunWith(SWAKTestRunner.class)
public class AT_BatchJobEntityTest implements EntityTestInterface {

    @Inject
    private BaseDomManager baseDomManager;

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
        C_KahiKbn pTajuukidouKahiKbn = C_KahiKbn.KA;
        C_BatchModeKbn pBatchMode = C_BatchModeKbn .HIDOUKI;
        C_KahiKbn pTyuudanKahi = C_KahiKbn.HUKA;

        AM_Batch aM_Batch = baseDomManager.getBatch(pKinouId);
        if (null == aM_Batch) {

            aM_Batch = new AM_Batch();
            aM_Batch.setKinouId(pKinouId);
            aM_Batch.setBatchClass(pBatchClass);
            aM_Batch.setTajuukidouKahiKbn(pTajuukidouKahiKbn);
            aM_Batch.setBatchMode(pBatchMode);
            aM_Batch.setTyuudanKahi(pTyuudanKahi);

            baseDomManager.insert(aM_Batch);
        }

        String pBatchJobId1 = "BJI0000001";
        String pBatchJobId2 = "BJI0000002";
        String pBatchJobId3 = "BJI0000003";
        String pBatchJobId4 = "BJI0000004";
        String pBatchJobId5 = "BJI0000005";
        C_BatchKidouKbn pBatchKidouKbn1 = C_BatchKidouKbn.BATCH;
        C_BatchKidouKbn pBatchKidouKbn2 = C_BatchKidouKbn.BATCH;
        C_BatchKidouKbn pBatchKidouKbn3 = C_BatchKidouKbn.BATCH;
        C_BatchKidouKbn pBatchKidouKbn4 = C_BatchKidouKbn.GAMEN;
        C_BatchKidouKbn pBatchKidouKbn5 = C_BatchKidouKbn.BATCH;
        C_BatchJyoutaiKbn pBatchJyoutaiKbn1 =  C_BatchJyoutaiKbn.SYUURYOU;
        C_BatchJyoutaiKbn pBatchJyoutaiKbn2 =  C_BatchJyoutaiKbn.SYUURYOU;
        C_BatchJyoutaiKbn pBatchJyoutaiKbn3 =  C_BatchJyoutaiKbn.SYUURYOU;
        C_BatchJyoutaiKbn pBatchJyoutaiKbn4 =  C_BatchJyoutaiKbn.SYUURYOU;
        C_BatchJyoutaiKbn pBatchJyoutaiKbn5 =  C_BatchJyoutaiKbn.SYUURYOU;

        AT_BatchJob aT_BatchJob1 = baseDomManager.getBatchJob(pBatchJobId1);
        if ( null == aT_BatchJob1 ) {

            aT_BatchJob1 = new AT_BatchJob();
            aT_BatchJob1.setBatchJobId(pBatchJobId1);
            aT_BatchJob1.setBatchId(pKinouId);
            aT_BatchJob1.setBatchKidouKbn(pBatchKidouKbn1);
            aT_BatchJob1.setBatchJyoutaiKbn(pBatchJyoutaiKbn1);

            baseDomManager.insert(aT_BatchJob1);
        }

        AT_BatchJob aT_BatchJob2 = baseDomManager.getBatchJob(pBatchJobId2);
        if ( null == aT_BatchJob2 ) {

            aT_BatchJob2 = new AT_BatchJob();
            aT_BatchJob2.setBatchJobId(pBatchJobId2);
            aT_BatchJob2.setBatchId(pKinouId);
            aT_BatchJob2.setBatchKidouKbn(pBatchKidouKbn2);
            aT_BatchJob2.setBatchJyoutaiKbn(pBatchJyoutaiKbn2);

            baseDomManager.insert(aT_BatchJob2);
        }

        AT_BatchJob aT_BatchJob3 = baseDomManager.getBatchJob(pBatchJobId3);
        if ( null == aT_BatchJob3 ) {

            aT_BatchJob3 = new AT_BatchJob();
            aT_BatchJob3.setBatchJobId(pBatchJobId3);
            aT_BatchJob3.setBatchId(pKinouId);
            aT_BatchJob3.setBatchKidouKbn(pBatchKidouKbn3);
            aT_BatchJob3.setBatchJyoutaiKbn(pBatchJyoutaiKbn3);

            baseDomManager.insert(aT_BatchJob3);
        }

        AT_BatchJob aT_BatchJob4 = baseDomManager.getBatchJob(pBatchJobId4);
        if ( null == aT_BatchJob4 ) {

            aT_BatchJob4 = new AT_BatchJob();
            aT_BatchJob4.setBatchJobId(pBatchJobId4);
            aT_BatchJob4.setBatchId(pKinouId);
            aT_BatchJob4.setBatchKidouKbn(pBatchKidouKbn4);
            aT_BatchJob4.setBatchJyoutaiKbn(pBatchJyoutaiKbn4);

            baseDomManager.insert(aT_BatchJob4);
        }

        AT_BatchJob aT_BatchJob5 = baseDomManager.getBatchJob(pBatchJobId5);
        if ( null == aT_BatchJob5 ) {

            aT_BatchJob5 = new AT_BatchJob();
            aT_BatchJob5.setBatchJobId(pBatchJobId5);
            aT_BatchJob5.setBatchId(pKinouId);
            aT_BatchJob5.setBatchKidouKbn(pBatchKidouKbn5);
            aT_BatchJob5.setBatchJyoutaiKbn(pBatchJyoutaiKbn5);

            baseDomManager.insert(aT_BatchJob5);
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

    @Override
    @Test
    public void getAll() {

    }

    @Override
    @Test
    public void getUniqueEntity() {
        String pBatchJobId = "BJI0000001";
        AT_BatchJob aT_BatchJob = baseDomManager.getBatchJob(pBatchJobId);

        assertEquals(pBatchJobId, aT_BatchJob.getBatchJobId());
    }

    @Override
    @Test
    public void noUniqueEntity() {
        String pBatchJobId = "BJI0000099";
        AT_BatchJob aT_BatchJob = baseDomManager.getBatchJob(pBatchJobId);

        assertNull(aT_BatchJob);

    }

    @Override
    @Test
    public void blankCondition() {
        String pBatchJobId = "";
        AT_BatchJob aT_BatchJob = baseDomManager.getBatchJob(pBatchJobId);

        assertNull(aT_BatchJob);
    }

    @Override
    @Test
    public void nullCondition() {
        String pBatchJobId = null;
        try {
            baseDomManager.getBatchJob(pBatchJobId);
        } catch (Exception e) {
            assertThat(e, instanceOf(NonUniqueResultException.class));
        }
    }
}
