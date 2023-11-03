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
import yuyu.def.db.entity.BM_Dairiten;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * 業務共通<br />
 * 代理店コード取得（金融機関指定）<br />
 * 代理店マスタエンティティデタッチ(代理店マスタエンティティリスト)のテストクラス<br />
 */
@RunWith(OrderedRunner.class)
public class BM_DairitenDetacherTest_detachDairitentouchedList {

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
        bizDomManager.insert(new BM_Dairiten(P_DRTENCDD_03));
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

        List<BM_Dairiten> bM_DairitenLst = bizDomManager.getAllDairiten();

        List<BM_Dairiten> entityList = BM_DairitenDetacher.detachDairitentouched(bM_DairitenLst);

        ExDBEntityManager em = SWAKInjector.getInstance(ExDBEntityManager.class);

        for(BM_Dairiten entity : entityList) {

            Assert.assertFalse(em.getEntityManager().contains(entity));
        }
    }

    @Test
    @TestOrder(20)
    public void testDetach2() {

        List<BM_Dairiten> bM_DairitenLst = new ArrayList<>();
        bM_DairitenLst.add(null);
        bM_DairitenLst.add(null);

        List<BM_Dairiten> entityList = BM_DairitenDetacher.detachDairitentouched(bM_DairitenLst);

        for(BM_Dairiten entity : entityList) {

            Assert.assertNull(entity);
        }
    }
}
