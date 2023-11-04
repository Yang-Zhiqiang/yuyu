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
import yuyu.def.classification.C_TantouCdKbn;
import yuyu.def.db.entity.BM_TantouCd;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * 担当コードマスタデタッチャーのテストクラスです。<br />
 */
@RunWith(OrderedRunner.class)
public class BM_TantouCdDetacherTest_detachTantouCdtouched {

    @Inject
    BizDomManager bizDomManager;

    @BeforeClass
    @Transactional
    public static void insertTestData() {

        BizDomManager bizDomManager = SWAKInjector.getInstance(BizDomManager.class);

        BM_TantouCd tantouCd1 = new BM_TantouCd(C_TantouCdKbn.valueOf("1"));

        bizDomManager.insert(tantouCd1);

        BM_TantouCd tantouCd2 = new BM_TantouCd(C_TantouCdKbn.valueOf("2"));

        bizDomManager.insert(tantouCd2);

    }

    @AfterClass
    @Transactional
    public static void deleteTestData() {

        BizDomManager bizDomManager = SWAKInjector.getInstance(BizDomManager.class);
        bizDomManager.delete(bizDomManager.getAllTantouCd());
    }

    @Test
    @TestOrder(10)
    public void testDetach() {

        BM_TantouCd tantouCd = bizDomManager.getTantouCd(C_TantouCdKbn.IMUSATEI);

        if (tantouCd != null) {
            tantouCd = BM_TantouCdDetacher.detachTantouCdtouched(tantouCd);

            ExDBEntityManager em = SWAKInjector.getInstance(ExDBEntityManager.class);

            boolean result = em.getEntityManager().contains(tantouCd);

            Assert.assertFalse(result);
        }
        else {
            Assert.assertTrue(false);
        }
    }
    @Test
    @TestOrder(20)
    public void testDetach2() {

        BM_TantouCd tantouCd = bizDomManager.getTantouCd(C_TantouCdKbn.IMUIMU);

        tantouCd = BM_TantouCdDetacher.detachTantouCdtouched(tantouCd);

        Assert.assertNull(tantouCd);
    }
}
