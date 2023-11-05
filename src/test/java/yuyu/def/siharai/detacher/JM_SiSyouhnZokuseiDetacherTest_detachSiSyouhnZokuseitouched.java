package yuyu.def.siharai.detacher;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.db.ExDBEntityManager;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.def.classification.C_KyhgndkataKbn;
import yuyu.def.db.entity.JM_SiSyouhnZokusei;
import yuyu.def.siharai.manager.SiharaiDomManager;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * 保険金<br />
 * 保険金給付金備金情報抽出<br />
 * 支払商品属性マスタエンティティをアンマネージド取得のテストクラス<br />
 */
@RunWith(OrderedRunner.class)
public class JM_SiSyouhnZokuseiDetacherTest_detachSiSyouhnZokuseitouched {

    @Inject
    SiharaiDomManager siharaiDomManager;

    static String P_SYOUHNCD_01 = "SH01";
    static Integer P_SYOUHNSDNO_1 = new Integer(10);
    static String P_KYUUHUCD_01 = "KH01";

    @BeforeClass
    @Transactional
    public static void insertTestData() {

        SiharaiDomManager siharaiDomManager = SWAKInjector.getInstance(SiharaiDomManager.class);

        siharaiDomManager.insert(new JM_SiSyouhnZokusei(P_SYOUHNCD_01, C_KyhgndkataKbn.TYPE60, P_SYOUHNSDNO_1, P_KYUUHUCD_01));
    }

    @AfterClass
    @Transactional
    public static void deleteTestData() {

        SiharaiDomManager siharaiDomManager = SWAKInjector.getInstance(SiharaiDomManager.class);

        siharaiDomManager.delete(siharaiDomManager.getAllSiSyouhnZokusei());
    }

    @Test
    @TestOrder(10)
    public void testDetach1() {

        JM_SiSyouhnZokusei jM_SiSyouhnZokusei = siharaiDomManager.getSiSyouhnZokusei(P_SYOUHNCD_01, C_KyhgndkataKbn.TYPE60, P_SYOUHNSDNO_1, P_KYUUHUCD_01);

        JM_SiSyouhnZokusei entity = JM_SiSyouhnZokuseiDetacher.detachSiSyouhnZokuseitouched(jM_SiSyouhnZokusei);

        ExDBEntityManager em = SWAKInjector.getInstance(ExDBEntityManager.class);

        Assert.assertFalse(em.getEntityManager().contains(entity));
    }

    @Test
    @TestOrder(20)
    public void testDetach2() {

        JM_SiSyouhnZokusei jM_SiSyouhnZokusei = null;

        Assert.assertNull(JM_SiSyouhnZokuseiDetacher.detachSiSyouhnZokuseitouched(jM_SiSyouhnZokusei));
    }
}
