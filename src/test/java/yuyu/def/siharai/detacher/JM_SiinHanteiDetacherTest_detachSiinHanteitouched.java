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

import yuyu.def.classification.C_GeninKbn;
import yuyu.def.classification.C_UmuKbn;
import yuyu.def.db.entity.JM_SiinHantei;
import yuyu.def.siharai.manager.SiharaiDomManager;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * 保険金給付金支払<br />
 * 死因判定<br />
 * 死因判定マスタエンティティデタッチ(死因判定マスタエンティティ)<br />
 */
@RunWith(OrderedRunner.class)
public class JM_SiinHanteiDetacherTest_detachSiinHanteitouched {

    @Inject
    SiharaiDomManager siharaiDomManager;

    @BeforeClass
    @Transactional
    public static void insertTestData() {

        SiharaiDomManager siharaiDomManager = SWAKInjector.getInstance(SiharaiDomManager .class);

        JM_SiinHantei siinHantei1 = new JM_SiinHantei(C_GeninKbn.valueOf("0"), C_GeninKbn.valueOf("0"),
                C_UmuKbn.valueOf("0"), C_UmuKbn.valueOf("0"), C_UmuKbn.valueOf("0"), C_UmuKbn.valueOf("0"), C_UmuKbn.valueOf("0"));

        siharaiDomManager.insert(siinHantei1);

        JM_SiinHantei siinHantei2 = new JM_SiinHantei(C_GeninKbn.valueOf("1"), C_GeninKbn.valueOf("1"),
                C_UmuKbn.valueOf("1"), C_UmuKbn.valueOf("1"), C_UmuKbn.valueOf("1"), C_UmuKbn.valueOf("1"), C_UmuKbn.valueOf("1"));

        siharaiDomManager.insert(siinHantei2);
    }

    @AfterClass
    @Transactional
    public static void deleteTestData() {

        SiharaiDomManager siharaiDomManager = SWAKInjector.getInstance(SiharaiDomManager.class);

        siharaiDomManager.delete(siharaiDomManager.getAllSiinHantei());
    }

    @Test
    @TestOrder(10)
    public void testDetach1() {

        JM_SiinHantei jM_SiinHantei = siharaiDomManager.getSiinHantei(C_GeninKbn.BLNK, C_GeninKbn.BLNK, C_UmuKbn.NONE,
                C_UmuKbn.NONE, C_UmuKbn.NONE, C_UmuKbn.NONE, C_UmuKbn.NONE);

        jM_SiinHantei = JM_SiinHanteiDetacher.detachSiinHanteitouched(jM_SiinHantei);

        ExDBEntityManager em = SWAKInjector.getInstance(ExDBEntityManager.class);

        boolean result = em.getEntityManager().contains(jM_SiinHantei);

        Assert.assertFalse(result);
    }

    @Test
    @TestOrder(20)
    public void testDetach2() {

        JM_SiinHantei jM_SiinHantei = siharaiDomManager.getSiinHantei(C_GeninKbn.SG, C_GeninKbn.SG, C_UmuKbn.NONE,
                C_UmuKbn.NONE, C_UmuKbn.NONE, C_UmuKbn.NONE, C_UmuKbn.NONE);

        jM_SiinHantei = JM_SiinHanteiDetacher.detachSiinHanteitouched(jM_SiinHantei);

        Assert.assertNull(jM_SiinHantei);
    }
}
