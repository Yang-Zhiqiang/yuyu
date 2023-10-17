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

/**
 * バッチ予約テーブル エンティティのテストクラス<br />
 */
@RunWith(SWAKTestRunner.class)
public class AS_BatchOrderEntityTest implements EntityTestInterface {

    @Inject
    private BaseDomManager baseDomManager;

    @BeforeClass
    @Transactional
    public static void insertTestData() {
        BaseDomManager baseDomManager = SWAKInjector.getInstance(BaseDomManager.class);

        String pBatchJobId1 = "BJI0000001";
        String pBatchJobId2 = "BJI0000002";
        String pBatchJobId3 = "BJI0000003";
        String pBatchJobId4 = "BJI0000004";
        String pBatchJobId5 = "BJI0000005";

        AS_BatchOrder aS_BatchOrder1 = baseDomManager.getBatchOrderByBatchJobId(pBatchJobId1);
        if ( null == aS_BatchOrder1 ){

            aS_BatchOrder1 = new AS_BatchOrder();
            aS_BatchOrder1.setBatchJobId(pBatchJobId1);

            baseDomManager.insert(aS_BatchOrder1);
        }

        AS_BatchOrder aS_BatchOrder2 = baseDomManager.getBatchOrderByBatchJobId(pBatchJobId2);
        if ( null == aS_BatchOrder2 ){

            aS_BatchOrder2 = new AS_BatchOrder();
            aS_BatchOrder2.setBatchJobId(pBatchJobId2);

            baseDomManager.insert(aS_BatchOrder2);
        }

        AS_BatchOrder aS_BatchOrder3 = baseDomManager.getBatchOrderByBatchJobId(pBatchJobId3);
        if ( null == aS_BatchOrder3 ){

            aS_BatchOrder3 = new AS_BatchOrder();
            aS_BatchOrder3.setBatchJobId(pBatchJobId3);

            baseDomManager.insert(aS_BatchOrder3);
        }

        AS_BatchOrder aS_BatchOrder4 = baseDomManager.getBatchOrderByBatchJobId(pBatchJobId4);
        if ( null == aS_BatchOrder4 ){

            aS_BatchOrder4 = new AS_BatchOrder();
            aS_BatchOrder4.setBatchJobId(pBatchJobId4);

            baseDomManager.insert(aS_BatchOrder4);
        }

        AS_BatchOrder aS_BatchOrder5 = baseDomManager.getBatchOrderByBatchJobId(pBatchJobId5);
        if ( null == aS_BatchOrder5 ){

            aS_BatchOrder5 = new AS_BatchOrder();
            aS_BatchOrder5.setBatchJobId(pBatchJobId5);

            baseDomManager.insert(aS_BatchOrder5);
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

        AS_BatchOrder aS_BatchOrder1 = baseDomManager.getBatchOrderByBatchJobId(pBatchJobId1);
        if (null != aS_BatchOrder1) {

            baseDomManager.delete(aS_BatchOrder1);
        }

        AS_BatchOrder aS_BatchOrder2 = baseDomManager.getBatchOrderByBatchJobId(pBatchJobId2);
        if (null != aS_BatchOrder2) {

            baseDomManager.delete(aS_BatchOrder2);
        }

        AS_BatchOrder aS_BatchOrder3 = baseDomManager.getBatchOrderByBatchJobId(pBatchJobId3);
        if (null != aS_BatchOrder3) {

            baseDomManager.delete(aS_BatchOrder3);
        }

        AS_BatchOrder aS_BatchOrder4 = baseDomManager.getBatchOrderByBatchJobId(pBatchJobId4);
        if (null != aS_BatchOrder4) {

            baseDomManager.delete(aS_BatchOrder4);
        }

        AS_BatchOrder aS_BatchOrder5 = baseDomManager.getBatchOrderByBatchJobId(pBatchJobId5);
        if (null != aS_BatchOrder5) {

            baseDomManager.delete(aS_BatchOrder5);
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
        AS_BatchOrder aS_BatchOrder = baseDomManager.getBatchOrderByBatchJobId(pBatchJobId);

        assertEquals(pBatchJobId, aS_BatchOrder.getBatchJobId());
    }

    @Override
    @Test
    public void noUniqueEntity() {
        String pBatchJobId = "BJI0000099";
        AS_BatchOrder aS_BatchOrder = baseDomManager.getBatchOrderByBatchJobId(pBatchJobId);

        assertNull(aS_BatchOrder);
    }

    @Override
    @Test
    public void blankCondition() {
        String pBatchJobId = "";
        AS_BatchOrder aS_BatchOrder = baseDomManager.getBatchOrderByBatchJobId(pBatchJobId);

        assertNull(aS_BatchOrder);
    }

    @Override
    @Test
    public void nullCondition() {
        String pBatchJobId = null;
        try {
            baseDomManager.getBatchOrderByBatchJobId(pBatchJobId);
        } catch (Exception e) {
            assertThat(e, instanceOf(NonUniqueResultException.class));
        }
    }
}
