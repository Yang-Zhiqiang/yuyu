package yuyu.def.biz.detacher;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.db.ExDBEntityManager;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.def.biz.manager.BizDomManager;
import yuyu.def.classification.C_DensysKbn;
import yuyu.def.db.entity.BT_DenpyoData;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * 経理伝票データテーブル(BT_DenpyoData) デタッチャーのテストクラスです。<br />
 */
@RunWith(OrderedRunner.class)
public class BT_DenpyoDataDetacherTest_detachDenpyoDatatouched {

    @Inject
    BizDomManager bizDomManager;

    @BeforeClass
    @Transactional
    public static void insertTestData() {

        BizDomManager bizDomManager = SWAKInjector.getInstance(BizDomManager.class);


        BT_DenpyoData denpyoData1 = new BT_DenpyoData(C_DensysKbn.BLNK, "1", 1);

        bizDomManager.insert(denpyoData1);

        BT_DenpyoData denpyoData2 = new BT_DenpyoData(C_DensysKbn.AGKANRI, "1", 1);

        bizDomManager.insert(denpyoData2);

    }

    @AfterClass
    @Transactional
    public static void deleteTestData() {

        BizDomManager bizDomManager = SWAKInjector.getInstance(BizDomManager.class);
        bizDomManager.delete(bizDomManager.getAllDenpyoData());
    }

    @Test
    @TestOrder(10)
    public void testDetach() {

        BT_DenpyoData bT_DenpyoData = bizDomManager.getDenpyoData(C_DensysKbn.BLNK, "1", 1);

        if (bT_DenpyoData != null) {
            bT_DenpyoData = BT_DenpyoDataDetacher.detachDenpyoDatatouched(bT_DenpyoData);

            ExDBEntityManager em = SWAKInjector.getInstance(ExDBEntityManager.class);

            boolean result = em.getEntityManager().contains(bT_DenpyoData);

            Assert.assertFalse(result);
        }
        else {
            Assert.assertTrue(false);
        }
    }
    @Test
    @TestOrder(20)
    public void testDetach2() {

        BT_DenpyoData bT_DenpyoData = bizDomManager.getDenpyoData(C_DensysKbn.HOZEN, "1", 1);

        bT_DenpyoData = BT_DenpyoDataDetacher.detachDenpyoDatatouched(bT_DenpyoData);

        Assert.assertNull(bT_DenpyoData);
    }
}
