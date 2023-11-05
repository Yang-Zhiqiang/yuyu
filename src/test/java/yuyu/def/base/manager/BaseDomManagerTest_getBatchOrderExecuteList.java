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
import yuyu.def.classification.C_OrderStatusuKbn;
import yuyu.def.db.entity.AM_Batch;
import yuyu.def.db.entity.AS_BatchOrder;
import yuyu.def.db.entity.AS_Kinou;
import yuyu.testinfr.AbstractTest;

/**
 * BaseDomManagerクラスの、<br />
 * getBatchOrderExecuteList() メソッドのテストクラスです。
 */
@RunWith(SWAKTestRunner.class)
public class BaseDomManagerTest_getBatchOrderExecuteList extends AbstractTest {

    @Inject
    BaseDomManager baseDomManager;

    @BeforeClass
    @Transactional
    public static void insertTestData() {
        BaseDomManager baseDomManager = SWAKInjector.getInstance(BaseDomManager.class);

        String pKinouId1 = "KI00000001";
        String pKinouId2 = "KI00000002";
        String pKinouId3 = "KI00000003";
        String pKinouId4 = "KI00000004";

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

        String pBatchClass = "BC00000001";
        C_KahiKbn pTajuukidouKahiKbn = C_KahiKbn.KA;
        C_BatchModeKbn pBatchMode = C_BatchModeKbn .HIDOUKI;
        C_KahiKbn pTyuudanKahi = C_KahiKbn.HUKA;

        AM_Batch aM_Batch1 = baseDomManager.getBatch(pKinouId1);
        if ( null == aM_Batch1 ) {

            aM_Batch1 = new AM_Batch();
            aM_Batch1.setKinouId(pKinouId1);
            aM_Batch1.setBatchClass(pBatchClass);
            aM_Batch1.setTajuukidouKahiKbn(pTajuukidouKahiKbn);
            aM_Batch1.setBatchMode(pBatchMode);
            aM_Batch1.setTyuudanKahi(pTyuudanKahi);

            baseDomManager.insert(aM_Batch1);
        }

        AM_Batch aM_Batch2 = baseDomManager.getBatch(pKinouId2);
        if ( null == aM_Batch2 ) {

            aM_Batch2 = new AM_Batch();
            aM_Batch2.setKinouId(pKinouId2);
            aM_Batch2.setBatchClass(pBatchClass);
            aM_Batch2.setTajuukidouKahiKbn(pTajuukidouKahiKbn);
            aM_Batch2.setBatchMode(pBatchMode);
            aM_Batch2.setTyuudanKahi(pTyuudanKahi);

            baseDomManager.insert(aM_Batch2);
        }

        AM_Batch aM_Batch3 = baseDomManager.getBatch(pKinouId3);
        if ( null == aM_Batch3 ) {

            aM_Batch3 = new AM_Batch();
            aM_Batch3.setKinouId(pKinouId3);
            aM_Batch3.setBatchClass(pBatchClass);
            aM_Batch3.setTajuukidouKahiKbn(pTajuukidouKahiKbn);
            aM_Batch3.setBatchMode(pBatchMode);
            aM_Batch3.setTyuudanKahi(pTyuudanKahi);

            baseDomManager.insert(aM_Batch3);
        }

        AM_Batch aM_Batch4 = baseDomManager.getBatch(pKinouId4);
        if ( null == aM_Batch4 ) {

            aM_Batch4 = new AM_Batch();
            aM_Batch4.setKinouId(pKinouId4);
            aM_Batch4.setBatchClass(pBatchClass);
            aM_Batch4.setTajuukidouKahiKbn(pTajuukidouKahiKbn);
            aM_Batch4.setBatchMode(pBatchMode);
            aM_Batch4.setTyuudanKahi(pTyuudanKahi);

            baseDomManager.insert(aM_Batch4);
        }

        String pBatchJobId1 = "BJI0000001";
        String pBatchJobId2 = "BJI0000002";
        String pBatchJobId3 = "BJI0000003";
        String pBatchJobId4 = "BJI0000004";
        C_OrderStatusuKbn pOrderStatus1 = C_OrderStatusuKbn.APPOINTMENT;
        C_OrderStatusuKbn pOrderStatus2 = C_OrderStatusuKbn.EXECUTE;
        C_OrderStatusuKbn pOrderStatus3 = C_OrderStatusuKbn.EXECUTE;
        C_OrderStatusuKbn pOrderStatus4 = C_OrderStatusuKbn.EXECUTE;

        AS_BatchOrder aS_BatchOrder1 = baseDomManager.getBatchOrderByBatchJobId(pBatchJobId1);
        if ( null == aS_BatchOrder1 ) {

            aS_BatchOrder1 = new AS_BatchOrder();
            aS_BatchOrder1.setKinouId(pKinouId1);
            aS_BatchOrder1.setBatchJobId(pBatchJobId1);
            aS_BatchOrder1.setOrderStatus(pOrderStatus1);

            baseDomManager.insert(aS_BatchOrder1);
        }

        AS_BatchOrder aS_BatchOrder2 = baseDomManager.getBatchOrderByBatchJobId(pBatchJobId2);
        if ( null == aS_BatchOrder2 ) {

            aS_BatchOrder2 = new AS_BatchOrder();
            aS_BatchOrder2.setKinouId(pKinouId2);
            aS_BatchOrder2.setBatchJobId(pBatchJobId2);
            aS_BatchOrder2.setOrderStatus(pOrderStatus2);

            baseDomManager.insert(aS_BatchOrder2);
        }

        AS_BatchOrder aS_BatchOrder3 = baseDomManager.getBatchOrderByBatchJobId(pBatchJobId3);
        if ( null == aS_BatchOrder3 ) {

            aS_BatchOrder3 = new AS_BatchOrder();
            aS_BatchOrder3.setKinouId(pKinouId3);
            aS_BatchOrder3.setBatchJobId(pBatchJobId3);
            aS_BatchOrder3.setOrderStatus(pOrderStatus3);

            baseDomManager.insert(aS_BatchOrder3);
        }

        AS_BatchOrder aS_BatchOrder4 = baseDomManager.getBatchOrderByBatchJobId(pBatchJobId4);
        if ( null == aS_BatchOrder4 ) {

            aS_BatchOrder4 = new AS_BatchOrder();
            aS_BatchOrder4.setKinouId(pKinouId4);
            aS_BatchOrder4.setBatchJobId(pBatchJobId4);
            aS_BatchOrder4.setOrderStatus(pOrderStatus4);

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
        String pKinouId3 = "KI00000003";
        String pKinouId4 = "KI00000004";

        AM_Batch aM_Batch1 = baseDomManager.getBatch(pKinouId1);
        if ( null != aM_Batch1 ) {

            baseDomManager.delete(aM_Batch1);
        }

        AM_Batch aM_Batch2 = baseDomManager.getBatch(pKinouId2);
        if ( null != aM_Batch2 ) {

            baseDomManager.delete(aM_Batch2);
        }

        AM_Batch aM_Batch3 = baseDomManager.getBatch(pKinouId3);
        if ( null != aM_Batch3 ) {

            baseDomManager.delete(aM_Batch3);
        }

        AM_Batch aM_Batch4 = baseDomManager.getBatch(pKinouId4);
        if ( null != aM_Batch4 ) {

            baseDomManager.delete(aM_Batch4);
        }

        AS_Kinou aS_Kinou1 = baseDomManager.getKinou(pKinouId1);
        if ( null != aS_Kinou1 ) {

            baseDomManager.getKinou(pKinouId1);
        }

        AS_Kinou aS_Kinou2 = baseDomManager.getKinou(pKinouId2);
        if ( null != aS_Kinou2 ) {

            baseDomManager.getKinou(pKinouId2);
        }

        AS_Kinou aS_Kinou3 = baseDomManager.getKinou(pKinouId3);
        if ( null != aS_Kinou3 ) {

            baseDomManager.getKinou(pKinouId3);
        }

        AS_Kinou aS_Kinou4 = baseDomManager.getKinou(pKinouId4);
        if ( null != aS_Kinou4 ) {

            baseDomManager.getKinou(pKinouId4);
        }

    }

    @Test
    public void test001(){
        String pBatchJobId = "BJI0000002";
        List<AS_BatchOrder> aS_BatchOrderList = baseDomManager.getBatchOrderExecuteList(pBatchJobId);

        assertEquals(2, aS_BatchOrderList.size());
    }

    @Test
    public void test002(){
        String pBatchJobId = "BJI0000099";
        List<AS_BatchOrder> aS_BatchOrderList = baseDomManager.getBatchOrderExecuteList(pBatchJobId);

        assertEquals(3, aS_BatchOrderList.size());
    }


    @Test
    public void test003(){
        String pBatchJobId = "";
        List<AS_BatchOrder> aS_BatchOrderList = baseDomManager.getBatchOrderExecuteList(pBatchJobId);

        assertEquals(3, aS_BatchOrderList.size());
    }


    @Test
    public void test004(){
        String pBatchJobId = null;
        List<AS_BatchOrder> aS_BatchOrderList = baseDomManager.getBatchOrderExecuteList(pBatchJobId);

        assertEquals(0, aS_BatchOrderList.size());
    }


}
