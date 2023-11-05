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
import yuyu.def.db.entity.BM_SyouhnZokusei;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * 保険金給付金支払<br />
 * 保険金給付金備金情報抽出<br />
 * 商品属性マスタエンティティデタッチ(商品属性マスタエンティティ)のテストクラスです。<br />
 */
@RunWith(OrderedRunner.class)
public class BM_SyouhnZokuseiDetacherTest_detachSyouhnZokuseitouched {

    @Inject
    BizDomManager bizDomManager;

    static String P_SYOUHNCD_01 = "SCD1";
    static Integer P_SYOUHNSDNO_01 = new Integer(11);

    @BeforeClass
    @Transactional
    public static void insertTestData() {

        BizDomManager bizDomManager = SWAKInjector.getInstance(BizDomManager.class);

        BM_SyouhnZokusei bM_SyouhnZokusei1 = new BM_SyouhnZokusei(P_SYOUHNCD_01, P_SYOUHNSDNO_01);

        bizDomManager.insert(bM_SyouhnZokusei1);
    }

    @AfterClass
    @Transactional
    public static void deleteTestData() {

        BizDomManager bizDomManager = SWAKInjector.getInstance(BizDomManager.class);

        bizDomManager.delete(bizDomManager.getAllSyouhnZokusei());
    }

    @Test
    @TestOrder(10)
    public void testDetach() {

        BM_SyouhnZokusei bM_SyouhnZokusei = bizDomManager.getSyouhnZokusei(P_SYOUHNCD_01, P_SYOUHNSDNO_01);

        bM_SyouhnZokusei = BM_SyouhnZokuseiDetacher.detachSyouhnZokuseitouched(bM_SyouhnZokusei);

        ExDBEntityManager em = SWAKInjector.getInstance(ExDBEntityManager.class);

        Assert.assertFalse(em.getEntityManager().contains(bM_SyouhnZokusei));
    }

    @Test
    @TestOrder(20)
    public void testDetach2() {

        BM_SyouhnZokusei bM_SyouhnZokusei = null;

        Assert.assertNull(BM_SyouhnZokuseiDetacher.detachSyouhnZokuseitouched(bM_SyouhnZokusei));
    }
}
