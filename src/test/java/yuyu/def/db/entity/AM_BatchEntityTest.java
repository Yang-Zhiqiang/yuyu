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
import yuyu.def.classification.C_BatchModeKbn;
import yuyu.def.classification.C_KahiKbn;

/**
 * バッチマスタ エンティティのテストクラス<br />
 */
@RunWith(SWAKTestRunner.class)
public class AM_BatchEntityTest implements EntityTestInterface {

    @Inject
    private BaseDomManager baseDomManager;

    @BeforeClass
    @Transactional
    public static void insertTestData() {
        BaseDomManager baseDomManager = SWAKInjector.getInstance(BaseDomManager.class);

        String pKinouId1 = "KI00000001";
        String pKinouId2 = "KI00000002";
        String pKinouId3 = "KI00000003";
        String pKinouId4 = "KI00000004";
        String pKinouId5 = "KI00000005";

        AS_Kinou aS_Kinou1 = baseDomManager.getKinou(pKinouId1);
        if ( null == aS_Kinou1 ){

            aS_Kinou1 = new AS_Kinou();
            aS_Kinou1.setKinouId(pKinouId1);

            baseDomManager.insert(aS_Kinou1);
        }

        AS_Kinou aS_Kinou2 = baseDomManager.getKinou(pKinouId2);
        if ( null == aS_Kinou2 ){

            aS_Kinou2 = new AS_Kinou();
            aS_Kinou2.setKinouId(pKinouId2);

            baseDomManager.insert(aS_Kinou2);
        }

        AS_Kinou aS_Kinou3 = baseDomManager.getKinou(pKinouId3);
        if ( null == aS_Kinou3 ){

            aS_Kinou3 = new AS_Kinou();
            aS_Kinou3.setKinouId(pKinouId3);

            baseDomManager.insert(aS_Kinou3);
        }

        AS_Kinou aS_Kinou4 = baseDomManager.getKinou(pKinouId4);
        if ( null == aS_Kinou4 ){

            aS_Kinou4 = new AS_Kinou();
            aS_Kinou4.setKinouId(pKinouId4);

            baseDomManager.insert(aS_Kinou4);
        }

        AS_Kinou aS_Kinou5 = baseDomManager.getKinou(pKinouId5);
        if ( null == aS_Kinou5 ){

            aS_Kinou5 = new AS_Kinou();
            aS_Kinou5.setKinouId(pKinouId5);

            baseDomManager.insert(aS_Kinou5);
        }

        String pBatchClass1 = "BC00000001";
        String pBatchClass2 = "BC00000002";
        String pBatchClass3 = "BC00000003";
        String pBatchClass4 = "BC00000004";
        String pBatchClass5 = "BC00000005";
        C_KahiKbn pTajuukidouKahiKbn1 = C_KahiKbn.KA;
        C_KahiKbn pTajuukidouKahiKbn2 = C_KahiKbn.KA;
        C_KahiKbn pTajuukidouKahiKbn3 = C_KahiKbn.KA;
        C_KahiKbn pTajuukidouKahiKbn4 = C_KahiKbn.KA;
        C_KahiKbn pTajuukidouKahiKbn5 = C_KahiKbn.KA;
        C_BatchModeKbn pBatchMode1 = C_BatchModeKbn .HIDOUKI;
        C_BatchModeKbn pBatchMode2 = C_BatchModeKbn .HIDOUKI;
        C_BatchModeKbn pBatchMode3 = C_BatchModeKbn .HIDOUKI;
        C_BatchModeKbn pBatchMode4 = C_BatchModeKbn .HIDOUKI;
        C_BatchModeKbn pBatchMode5 = C_BatchModeKbn .HIDOUKI;
        C_KahiKbn pTyuudanKahi1 = C_KahiKbn.HUKA;
        C_KahiKbn pTyuudanKahi2 = C_KahiKbn.HUKA;
        C_KahiKbn pTyuudanKahi3 = C_KahiKbn.KA;
        C_KahiKbn pTyuudanKahi4 = C_KahiKbn.KA;
        C_KahiKbn pTyuudanKahi5 = C_KahiKbn.HUKA;

        AM_Batch aM_Batch1 = baseDomManager.getBatch(pKinouId1);
        if (null == aM_Batch1) {

            aM_Batch1 = new AM_Batch();
            aM_Batch1.setKinouId(pKinouId1);
            aM_Batch1.setBatchClass(pBatchClass1);
            aM_Batch1.setTajuukidouKahiKbn(pTajuukidouKahiKbn1);
            aM_Batch1.setBatchMode(pBatchMode1);
            aM_Batch1.setTyuudanKahi(pTyuudanKahi1);

            baseDomManager.insert(aM_Batch1);
        }

        AM_Batch aM_Batch2 = baseDomManager.getBatch(pKinouId2);
        if (null == aM_Batch2) {

            aM_Batch2 = new AM_Batch();
            aM_Batch2.setKinouId(pKinouId2);
            aM_Batch2.setBatchClass(pBatchClass2);
            aM_Batch2.setTajuukidouKahiKbn(pTajuukidouKahiKbn2);
            aM_Batch2.setBatchMode(pBatchMode2);
            aM_Batch2.setTyuudanKahi(pTyuudanKahi2);

            baseDomManager.insert(aM_Batch2);
        }

        AM_Batch aM_Batch3 = baseDomManager.getBatch(pKinouId3);
        if (null == aM_Batch3) {

            aM_Batch3 = new AM_Batch();
            aM_Batch3.setKinouId(pKinouId3);
            aM_Batch3.setBatchClass(pBatchClass3);
            aM_Batch3.setTajuukidouKahiKbn(pTajuukidouKahiKbn3);
            aM_Batch3.setBatchMode(pBatchMode3);
            aM_Batch3.setTyuudanKahi(pTyuudanKahi3);

            baseDomManager.insert(aM_Batch3);
        }

        AM_Batch aM_Batch4 = baseDomManager.getBatch(pKinouId4);
        if (null == aM_Batch4) {

            aM_Batch4 = new AM_Batch();
            aM_Batch4.setKinouId(pKinouId4);
            aM_Batch4.setBatchClass(pBatchClass4);
            aM_Batch4.setTajuukidouKahiKbn(pTajuukidouKahiKbn4);
            aM_Batch4.setBatchMode(pBatchMode4);
            aM_Batch4.setTyuudanKahi(pTyuudanKahi4);

            baseDomManager.insert(aM_Batch4);
        }

        AM_Batch aM_Batch5 = baseDomManager.getBatch(pKinouId5);
        if (null == aM_Batch5) {

            aM_Batch5 = new AM_Batch();
            aM_Batch5.setKinouId(pKinouId5);
            aM_Batch5.setBatchClass(pBatchClass5);
            aM_Batch5.setTajuukidouKahiKbn(pTajuukidouKahiKbn5);
            aM_Batch5.setBatchMode(pBatchMode5);
            aM_Batch5.setTyuudanKahi(pTyuudanKahi5);

            baseDomManager.insert(aM_Batch5);
        }
    }

    @AfterClass
    @Transactional
    public static void deleteTestData() {
        BaseDomManager baseDomManager = SWAKInjector.getInstance(BaseDomManager.class);

        String pKinouId1 = "KI00000001";
        String pKinouId2 = "KI00000002";
        String pKinouId3 = "KI00000003";
        String pKinouId4 = "KI00000004";
        String pKinouId5 = "KI00000005";

        AM_Batch aM_Batch1 = baseDomManager.getBatch(pKinouId1);
        if (null != aM_Batch1) {

            baseDomManager.delete(aM_Batch1);
        }

        AM_Batch aM_Batch2 = baseDomManager.getBatch(pKinouId2);
        if (null != aM_Batch2) {

            baseDomManager.delete(aM_Batch2);
        }

        AM_Batch aM_Batch3 = baseDomManager.getBatch(pKinouId3);
        if (null != aM_Batch3) {

            baseDomManager.delete(aM_Batch3);
        }

        AM_Batch aM_Batch4 = baseDomManager.getBatch(pKinouId4);
        if (null != aM_Batch4) {

            baseDomManager.delete(aM_Batch4);
        }

        AM_Batch aM_Batch5 = baseDomManager.getBatch(pKinouId5);
        if (null != aM_Batch5) {

            baseDomManager.delete(aM_Batch5);
        }

        AS_Kinou aS_Kinou1 = baseDomManager.getKinou(pKinouId1);
        if ( null != aS_Kinou1 ) {

            baseDomManager.delete(aS_Kinou1);
        }

        AS_Kinou aS_Kinou2 = baseDomManager.getKinou(pKinouId2);
        if ( null != aS_Kinou2 ) {

            baseDomManager.delete(aS_Kinou2);
        }

        AS_Kinou aS_Kinou3 = baseDomManager.getKinou(pKinouId3);
        if ( null != aS_Kinou3 ) {

            baseDomManager.delete(aS_Kinou3);
        }

        AS_Kinou aS_Kinou4 = baseDomManager.getKinou(pKinouId4);
        if ( null != aS_Kinou4 ) {

            baseDomManager.delete(aS_Kinou4);
        }

        AS_Kinou aS_Kinou5 = baseDomManager.getKinou(pKinouId5);
        if ( null != aS_Kinou5 ) {

            baseDomManager.delete(aS_Kinou5);
        }
    }

    @Override
    @Test
    public void getAll() {
    }

    @Override
    @Test
    public void getUniqueEntity() {
        String pKinouId = "KI00000001";
        AM_Batch aM_Batch = baseDomManager.getBatch(pKinouId);
        assertEquals(pKinouId, aM_Batch.getBatchId());
    }

    @Override
    @Test
    public void noUniqueEntity() {
        String pKinouId = "KI00000099";
        AM_Batch aM_Batch = baseDomManager.getBatch(pKinouId);
        assertNull(aM_Batch);
    }

    @Override
    @Test
    public void blankCondition() {
        String pKinouId = "";
        AM_Batch aM_Batch = baseDomManager.getBatch(pKinouId);
        assertNull(aM_Batch);
    }

    @Override
    @Test
    public void nullCondition() {
        String pKinouId = null;
        try {
            baseDomManager.getBatch(pKinouId);
        } catch (Exception e) {
            assertThat(e, instanceOf(NonUniqueResultException.class));
        }
    }
}
