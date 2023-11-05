package yuyu.def.hozen.detacher;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.db.ExDBEntityManager;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.def.db.entity.IT_KhTtdkTyuui;
import yuyu.def.db.entity.IT_KykKihon;
import yuyu.def.hozen.manager.HozenDomManager;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * 契約基本テーブル(IT_KykKihon) デタッチャークラスです。<br />
 */
@RunWith(OrderedRunner.class)
public class IT_KykKihonDetacherTest_detachKhTtdkTyuuitouched {

    @Inject
    HozenDomManager hozenDomManager;

    @BeforeClass
    @Transactional
    public static void insertTestData() {

        HozenDomManager hozenDomManager = SWAKInjector.getInstance(HozenDomManager .class);

        IT_KykKihon kykKihon1 = new IT_KykKihon("01", "11807111118");

        IT_KhTtdkTyuui khTtdkTyuui1 = kykKihon1.createKhTtdkTyuui();

        hozenDomManager.insert(kykKihon1);


    }

    @AfterClass
    @Transactional
    public static void deleteTestData() {

        HozenDomManager hozenDomManager = SWAKInjector.getInstance(HozenDomManager .class);

        hozenDomManager.delete(hozenDomManager.getAllKykKihon());
    }

    @Test
    @TestOrder(10)
    public void testDetach1() {

        IT_KykKihon iT_KykKihon = hozenDomManager.getKykKihon("11807111118");

        IT_KykKihon entity = IT_KykKihonDetacher.detachKhTtdkTyuuitouched(iT_KykKihon);

        ExDBEntityManager em = SWAKInjector.getInstance(ExDBEntityManager.class);

        Assert.assertFalse(em.getEntityManager().contains(entity));

        IT_KhTtdkTyuui iT_KhTtdkTyuui = entity.getKhTtdkTyuui();

        Assert.assertEquals("01", iT_KhTtdkTyuui.getKbnkey());
        Assert.assertEquals("11807111118", iT_KhTtdkTyuui.getSyono());

    }

    @Test
    @TestOrder(20)
    public void testDetach2() {

        IT_KykKihon iT_KykKihon = null;

        Assert.assertNull(IT_KykKihonDetacher.detachKhTtdkTyuuitouched(iT_KykKihon));
    }
}
