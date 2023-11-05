package yuyu.def.biz.detacher;


import java.util.ArrayList;
import java.util.List;

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
import yuyu.def.db.entity.BM_Bosyuunin;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * 業務共通<br />
 * 募集人コード取得（募集人登録番号を指定）<br />
 * 募集人マスタエンティティデタッチ(募集人マスタエンティティリスト)のテストクラス<br />
 */
@RunWith(OrderedRunner.class)
public class BM_BosyuuninDetacherTest_detachBosyuunintouchedLst {

    @Inject
    BizDomManager bizDomManager;

    static String P_DRTENCDD_01 = "111111";
    static String P_DRTENCDD_02 = "111112";
    static String P_DRTENCDD_03 = "111113";

    @BeforeClass
    @Transactional
    public static void insertTestData() {

        BizDomManager bizDomManager = SWAKInjector.getInstance(BizDomManager .class);

        bizDomManager.insert(new BM_Bosyuunin(P_DRTENCDD_01));
        bizDomManager.insert(new BM_Bosyuunin(P_DRTENCDD_02));
        bizDomManager.insert(new BM_Bosyuunin(P_DRTENCDD_03));
    }

    @AfterClass
    @Transactional
    public static void deleteTestData() {

        BizDomManager bizDomManager = SWAKInjector.getInstance(BizDomManager.class);

        bizDomManager.delete(bizDomManager.getAllBosyuunin());
    }

    @Test
    @TestOrder(10)
    public void testDetach1() {

        List<BM_Bosyuunin> bM_BosyuuninLst = bizDomManager.getAllBosyuunin();

        List<BM_Bosyuunin> entityList = BM_BosyuuninDetacher.detachBosyuunintouched(bM_BosyuuninLst);

        ExDBEntityManager em = SWAKInjector.getInstance(ExDBEntityManager.class);

        for(BM_Bosyuunin entity : entityList) {

            Assert.assertFalse(em.getEntityManager().contains(entity));
        }
    }

    @Test
    @TestOrder(20)
    public void testDetach2() {

        List<BM_Bosyuunin> bM_BosyuuninLst = new ArrayList<>();
        bM_BosyuuninLst.add(null);
        bM_BosyuuninLst.add(null);

        List<BM_Bosyuunin> entityList = BM_BosyuuninDetacher.detachBosyuunintouched(bM_BosyuuninLst);

        for(BM_Bosyuunin entity : entityList) {

            Assert.assertNull(entity);
        }
    }
}
