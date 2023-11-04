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

import yuyu.def.classification.C_BatchModeKbn;
import yuyu.def.classification.C_KahiKbn;
import yuyu.def.db.entity.AM_Batch;
import yuyu.def.db.entity.AS_BatchOrder;
import yuyu.def.db.entity.AS_Kinou;
import yuyu.testinfr.AbstractTest;

/**
 * BaseDomManagerクラスの、<br />
 * getBatchOrderByKinouId() メソッドのテストクラスです。
 */
@RunWith(SWAKTestRunner.class)
public class BaseDomManagerTest_getBatchOrderByKinouId extends AbstractTest {

    @Inject
    BaseDomManager baseDomManager;

    @BeforeClass
    @Transactional
    public static void insertTestData() {
        BaseDomManager baseDomManager = SWAKInjector.getInstance(BaseDomManager.class);

        String pKinouId1 = "KI00000001";
        String pKinouId2 = "KI00000002";

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

        String pBatchClass1 = "BC00000001";
        String pBatchClass2 = "BC00000002";
        C_KahiKbn pTajuukidouKahiKbn1 = C_KahiKbn.KA;
        C_KahiKbn pTajuukidouKahiKbn2 = C_KahiKbn.KA;
        C_BatchModeKbn pBatchMode1 = C_BatchModeKbn .HIDOUKI;
        C_BatchModeKbn pBatchMode2 = C_BatchModeKbn .HIDOUKI;
        C_KahiKbn pTyuudanKahi1 = C_KahiKbn.HUKA;
        C_KahiKbn pTyuudanKahi2 = C_KahiKbn.HUKA;

        AM_Batch aM_Batch1 = baseDomManager.getBatch(pKinouId1);
        if ( null == aM_Batch1 ) {

            aM_Batch1 = new AM_Batch();
            aM_Batch1.setKinouId(pKinouId1);
            aM_Batch1.setBatchClass(pBatchClass1);
            aM_Batch1.setTajuukidouKahiKbn(pTajuukidouKahiKbn1);
            aM_Batch1.setBatchMode(pBatchMode1);
            aM_Batch1.setTyuudanKahi(pTyuudanKahi1);

            baseDomManager.insert(aM_Batch1);
        }

        AM_Batch aM_Batch2 = baseDomManager.getBatch(pKinouId2);
        if ( null == aM_Batch2 ) {

            aM_Batch2 = new AM_Batch();
            aM_Batch2.setKinouId(pKinouId2);
            aM_Batch2.setBatchClass(pBatchClass2);
            aM_Batch2.setTajuukidouKahiKbn(pTajuukidouKahiKbn2);
            aM_Batch2.setBatchMode(pBatchMode2);
            aM_Batch2.setTyuudanKahi(pTyuudanKahi2);

            baseDomManager.insert(aM_Batch2);
        }

        String pBatchJobId1 = "BJI0000001";
        String pBatchJobId2 = "BJI0000002";
        String pBatchJobId3 = "BJI0000003";
        String pBatchJobId4 = "BJI0000004";

        AS_BatchOrder aS_BatchOrder1 = baseDomManager.getBatchOrderByBatchJobId(pBatchJobId1);
        if ( null == aS_BatchOrder1 ) {

            aS_BatchOrder1 = new AS_BatchOrder();
            aS_BatchOrder1.setBatchJobId(pBatchJobId1);
            aS_BatchOrder1.setKinouId(pKinouId1);

            baseDomManager.insert(aS_BatchOrder1);
        }

        AS_BatchOrder aS_BatchOrder2 = baseDomManager.getBatchOrderByBatchJobId(pBatchJobId2);
        if ( null == aS_BatchOrder2 ) {

            aS_BatchOrder2 = new AS_BatchOrder();
            aS_BatchOrder2.setBatchJobId(pBatchJobId2);
            aS_BatchOrder2.setKinouId(pKinouId1);

            baseDomManager.insert(aS_BatchOrder2);
        }

        AS_BatchOrder aS_BatchOrder3 = baseDomManager.getBatchOrderByBatchJobId(pBatchJobId3);
        if ( null == aS_BatchOrder3 ) {

            aS_BatchOrder3 = new AS_BatchOrder();
            aS_BatchOrder3.setBatchJobId(pBatchJobId3);
            aS_BatchOrder3.setKinouId(pKinouId1);

            baseDomManager.insert(aS_BatchOrder3);
        }

        AS_BatchOrder aS_BatchOrder4 = baseDomManager.getBatchOrderByBatchJobId(pBatchJobId4);
        if ( null == aS_BatchOrder4 ) {

            aS_BatchOrder4 = new AS_BatchOrder();
            aS_BatchOrder4.setBatchJobId(pBatchJobId4);
            aS_BatchOrder4.setKinouId(pKinouId2);

            baseDomManager.insert(aS_BatchOrder4);
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

        AS_BatchOrder aS_BatchOrder1 = baseDomManager.getBatchOrderByBatchJobId(pBatchJobId1);
        if ( null != aS_BatchOrder1 ) {

            baseDomManager.delete(aS_BatchOrder1);
        }

        AS_BatchOrder aS_BatchOrder2 = baseDomManager.getBatchOrderByBatchJobId(pBatchJobId2);
        if ( null != aS_BatchOrder2 ) {

            baseDomManager.delete(aS_BatchOrder2);
        }

        AS_BatchOrder aS_BatchOrder3 = baseDomManager.getBatchOrderByBatchJobId(pBatchJobId3);
        if ( null != aS_BatchOrder3 ) {

            baseDomManager.delete(aS_BatchOrder3);
        }

        AS_BatchOrder aS_BatchOrder4 = baseDomManager.getBatchOrderByBatchJobId(pBatchJobId4);
        if ( null != aS_BatchOrder4 ) {

            baseDomManager.delete(aS_BatchOrder4);
        }

        String pKinouId1 = "KI00000001";
        String pKinouId2 = "KI00000002";

        AM_Batch aM_Batch1 = baseDomManager.getBatch(pKinouId1);
        if ( null != aM_Batch1 ) {

            baseDomManager.delete(aM_Batch1);
        }

        AM_Batch aM_Batch2 = baseDomManager.getBatch(pKinouId2);
        if ( null != aM_Batch2 ) {

            baseDomManager.delete(aM_Batch2);
        }

        AS_Kinou aS_Kinou1 = baseDomManager.getKinou(pKinouId1);
        if ( null != aS_Kinou1 ) {

            baseDomManager.delete(aS_Kinou1);
        }

        AS_Kinou aS_Kinou2 = baseDomManager.getKinou(pKinouId2);
        if ( null != aS_Kinou2 ) {

            baseDomManager.delete(aS_Kinou2);
        }

    }

    @Test
    public void test001(){
        String pKinouId = "KI00000099";
        List<AS_BatchOrder> aS_BatchOrderList = baseDomManager.getBatchOrderByKinouId(pKinouId);

        assertEquals(0, aS_BatchOrderList.size());
    }


    @Test
    public void test002(){
        String pKinouId = "KI00000002";
        List<AS_BatchOrder> aS_BatchOrderList = baseDomManager.getBatchOrderByKinouId(pKinouId);

        assertEquals(1, aS_BatchOrderList.size());
    }


    @Test
    public void test003(){
        String pKinouId = "KI00000001";
        List<AS_BatchOrder> aS_BatchOrderList = baseDomManager.getBatchOrderByKinouId(pKinouId);

        assertEquals(3, aS_BatchOrderList.size());
    }


    @Test
    public void test004(){
        String pKinouId = "";
        List<AS_BatchOrder> aS_BatchOrderList = baseDomManager.getBatchOrderByKinouId(pKinouId);

        assertEquals(0, aS_BatchOrderList.size());
    }


    @Test
    public void test005(){
        String pKinouId = null;
        List<AS_BatchOrder> aS_BatchOrderList = baseDomManager.getBatchOrderByKinouId(pKinouId);

        assertEquals(4, aS_BatchOrderList.size());
    }

}
