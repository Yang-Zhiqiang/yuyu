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
import yuyu.def.db.entity.BM_Dairiten;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * 業務共通<br />
 * 代理店コード取得（金融機関指定）<br />
 * 代理店マスタエンティティデタッチ(代理店マスタエンティティ)のテストクラス<br />
 */
@RunWith(OrderedRunner.class)
public class BM_DairitenDetacherTest_detachDairitentouched {

    @Inject
    BizDomManager bizDomManager;

    static String P_DRTENCDD_01 = "1111111";
    static String P_DRTENCDD_02 = "1111112";
    static String P_DRTENCDD_03 = "1111113";

    @BeforeClass
    @Transactional
    public static void insertTestData() {

        BizDomManager bizDomManager = SWAKInjector.getInstance(BizDomManager .class);

        bizDomManager.insert(new BM_Dairiten(P_DRTENCDD_01));
        bizDomManager.insert(new BM_Dairiten(P_DRTENCDD_02));
    }

    @AfterClass
    @Transactional
    public static void deleteTestData() {

        BizDomManager bizDomManager = SWAKInjector.getInstance(BizDomManager.class);

        bizDomManager.delete(bizDomManager.getAllDairiten());
    }

    @Test
    @TestOrder(10)
    public void testDetach1() {

        BM_Dairiten bM_Dairiten = bizDomManager.getDairiten(P_DRTENCDD_01);

        bM_Dairiten = BM_DairitenDetacher.detachDairitentouched(bM_Dairiten);

        ExDBEntityManager em = SWAKInjector.getInstance(ExDBEntityManager.class);

        boolean result = em.getEntityManager().contains(bM_Dairiten);

        Assert.assertFalse(result);
    }

    @Test
    @TestOrder(20)
    public void testDetach2() {

        BM_Dairiten bM_Dairiten = bizDomManager.getDairiten(P_DRTENCDD_03);

        bM_Dairiten = BM_DairitenDetacher.detachDairitentouched(bM_Dairiten);

        Assert.assertNull(bM_Dairiten);
    }
}
