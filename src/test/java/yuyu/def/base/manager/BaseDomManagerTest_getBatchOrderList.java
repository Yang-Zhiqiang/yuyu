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

import yuyu.def.db.entity.AS_BatchOrder;
import yuyu.testinfr.AbstractTest;

/**
 * BaseDomManagerクラスの、<br />
 * getBatchOrderList() メソッドのテストクラスです。
 */
@RunWith(SWAKTestRunner.class)
public class BaseDomManagerTest_getBatchOrderList extends AbstractTest {

    @Inject
    BaseDomManager baseDomManager;

    @BeforeClass
    @Transactional
    public static void insertTestData() {
    }

    @AfterClass
    @Transactional
    public static void deleteTestData() {
        BaseDomManager baseDomManager = SWAKInjector.getInstance(BaseDomManager.class);

        String pBatchJobId1 = "BJI0000001";
        String pBatchJobId2 = "BJI0000002";
        String pBatchJobId3 = "BJI0000003";

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

    }

    @Test
    @Transactional
    public void test001(){

        List<AS_BatchOrder> aS_BatchOrderList = baseDomManager.getBatchOrderList();

        assertEquals(0, aS_BatchOrderList.size());

        BaseDomManager baseDomManager1 = SWAKInjector.getInstance(BaseDomManager.class);

        String pBatchJobId = "BJI0000001";

        AS_BatchOrder aS_BatchOrder = baseDomManager1.getBatchOrderByBatchJobId(pBatchJobId);
        if ( null == aS_BatchOrder ) {

            aS_BatchOrder = new AS_BatchOrder();
            aS_BatchOrder.setBatchJobId(pBatchJobId);

            baseDomManager1.insert(aS_BatchOrder);
        }
    }

    @Test
    @Transactional
    public void test002(){

        List<AS_BatchOrder> aS_BatchOrderList = baseDomManager.getBatchOrderList();

        assertEquals(1, aS_BatchOrderList.size());

        BaseDomManager baseDomManager1 = SWAKInjector.getInstance(BaseDomManager.class);

        String pBatchJobId1 = "BJI0000002";
        String pBatchJobId2 = "BJI0000003";

        AS_BatchOrder aS_BatchOrder1 = baseDomManager1.getBatchOrderByBatchJobId(pBatchJobId1);
        if ( null == aS_BatchOrder1 ) {

            aS_BatchOrder1 = new AS_BatchOrder();
            aS_BatchOrder1.setBatchJobId(pBatchJobId1);

            baseDomManager1.insert(aS_BatchOrder1);
        }

        AS_BatchOrder aS_BatchOrder2 = baseDomManager1.getBatchOrderByBatchJobId(pBatchJobId2);
        if ( null == aS_BatchOrder2 ) {

            aS_BatchOrder2 = new AS_BatchOrder();
            aS_BatchOrder2.setBatchJobId(pBatchJobId2);

            baseDomManager1.insert(aS_BatchOrder2);
        }
    }

    @Test
    public void test003(){

        List<AS_BatchOrder> aS_BatchOrderList = baseDomManager.getBatchOrderList();

        assertEquals(3, aS_BatchOrderList.size());
    }
}
