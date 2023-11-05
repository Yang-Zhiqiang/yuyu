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

import yuyu.def.db.entity.JM_Byoumei;
import yuyu.def.siharai.manager.SiharaiDomManager;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * 保険金給付金支払<br />
 * 死因判定<br />
 * 病名マスタエンティティデタッチ(病名マスタエンティティ)<br />
 */
@RunWith(OrderedRunner.class)
public class JM_ByoumeiDetacherTest_detachByoumeitouched {

    @Inject
    SiharaiDomManager siharaiDomManager;

    @BeforeClass
    @Transactional
    public static void insertTestData() {

        SiharaiDomManager siharaiDomManager = SWAKInjector.getInstance(SiharaiDomManager .class);

        JM_Byoumei jM_Byoumei1 = new JM_Byoumei("B12345");

        siharaiDomManager.insert(jM_Byoumei1);

        JM_Byoumei jM_Byoumei2 = new JM_Byoumei("B22345");

        siharaiDomManager.insert(jM_Byoumei2);
    }

    @AfterClass
    @Transactional
    public static void deleteTestData() {

        SiharaiDomManager siharaiDomManager = SWAKInjector.getInstance(SiharaiDomManager.class);

        siharaiDomManager.delete(siharaiDomManager.getAllByoumei());
    }

    @Test
    @TestOrder(10)
    public void testDetach1() {

        JM_Byoumei jM_Byoumei = siharaiDomManager.getByoumei("B12345");

        jM_Byoumei = JM_ByoumeiDetacher.detachByoumeitouched(jM_Byoumei);

        ExDBEntityManager em = SWAKInjector.getInstance(ExDBEntityManager.class);

        boolean result = em.getEntityManager().contains(jM_Byoumei);

        Assert.assertFalse(result);
    }

    @Test
    @TestOrder(20)
    public void testDetach2() {

        JM_Byoumei jM_Byoumei = siharaiDomManager.getByoumei("B12346");

        jM_Byoumei = JM_ByoumeiDetacher.detachByoumeitouched(jM_Byoumei);

        Assert.assertNull(jM_Byoumei);
    }
}
