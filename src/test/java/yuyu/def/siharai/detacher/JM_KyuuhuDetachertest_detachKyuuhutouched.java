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

import yuyu.def.db.entity.JM_Kyuuhu;
import yuyu.def.siharai.manager.SiharaiDomManager;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * 保険金給付金支払<br />
 * 保険金給付金備金抽出<br />
 * 給付マスタエンティティデタッチ(給付マスタエンティティ)<br />
 */
@RunWith(OrderedRunner.class)
public class JM_KyuuhuDetachertest_detachKyuuhutouched {

    @Inject
    SiharaiDomManager siharaiDomManager;

    @BeforeClass
    @Transactional
    public static void insertTestData() {

        SiharaiDomManager siharaiDomManager = SWAKInjector.getInstance(SiharaiDomManager .class);

        JM_Kyuuhu kyuuhu1 = new JM_Kyuuhu("1001");

        siharaiDomManager.insert(kyuuhu1);

        JM_Kyuuhu kyuuhu2 = new JM_Kyuuhu("1002");

        siharaiDomManager.insert(kyuuhu2);
    }

    @AfterClass
    @Transactional
    public static void deleteTestData() {

        SiharaiDomManager siharaiDomManager = SWAKInjector.getInstance(SiharaiDomManager.class);

        siharaiDomManager.delete(siharaiDomManager.getAllKyuuhu());
    }

    @Test
    @TestOrder(10)
    public void testDetach1() {

        JM_Kyuuhu jM_Kyuuhu = siharaiDomManager.getKyuuhu("1001");

        jM_Kyuuhu = JM_KyuuhuDetacher.detachKyuuhutouched(jM_Kyuuhu);

        ExDBEntityManager em = SWAKInjector.getInstance(ExDBEntityManager.class);

        boolean result = em.getEntityManager().contains(jM_Kyuuhu);

        Assert.assertFalse(result);
    }

    @Test
    @TestOrder(20)
    public void testDetach2() {

        JM_Kyuuhu jM_Kyuuhu = siharaiDomManager.getKyuuhu("1003");

        jM_Kyuuhu = JM_KyuuhuDetacher.detachKyuuhutouched(jM_Kyuuhu);

        Assert.assertNull(jM_Kyuuhu);
    }
}
