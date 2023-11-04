package yuyu.def.hozen.detacher;

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

import yuyu.def.db.entity.IT_KhTtdkRireki;
import yuyu.def.db.entity.IT_KykKihon;
import yuyu.def.hozen.manager.HozenDomManager;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * 契約基本テーブル(IT_KykKihon) デタッチャークラスです。<br />
 */
@RunWith(OrderedRunner.class)
public class IT_KykKihonDetacherTest_detachKhTtdkRirekitouched {

    @Inject
    HozenDomManager hozenDomManager;

    @BeforeClass
    @Transactional
    public static void insertTestData() {

        HozenDomManager hozenDomManager = SWAKInjector.getInstance(HozenDomManager .class);

        IT_KykKihon kykKihon1 = new IT_KykKihon("01", "11807111118");

        IT_KhTtdkRireki khTtdkRireki1 = kykKihon1.createKhTtdkRireki();
        khTtdkRireki1.setHenkousikibetukey("201520161001");

        IT_KhTtdkRireki khTtdkRireki2 = kykKihon1.createKhTtdkRireki();
        khTtdkRireki2.setHenkousikibetukey("201520161002");

        IT_KhTtdkRireki khTtdkRireki3 = kykKihon1.createKhTtdkRireki();
        khTtdkRireki3.setHenkousikibetukey("201520161003");

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

        IT_KykKihon entity = IT_KykKihonDetacher.detachKhTtdkRirekitouched(iT_KykKihon);

        ExDBEntityManager em = SWAKInjector.getInstance(ExDBEntityManager.class);

        Assert.assertFalse(em.getEntityManager().contains(entity));

        List<IT_KhTtdkRireki> khTtdkRirekis = entity.getKhTtdkRirekis();

        Assert.assertEquals(3, khTtdkRirekis.size());

        IT_KhTtdkRireki khTtdkRireki1 = khTtdkRirekis.get(0);
        Assert.assertEquals("01", khTtdkRireki1.getKbnkey());
        Assert.assertEquals("11807111118", khTtdkRireki1.getSyono());
        Assert.assertEquals("201520161001", khTtdkRireki1.getHenkousikibetukey());

        IT_KhTtdkRireki khTtdkRireki2 = khTtdkRirekis.get(1);
        Assert.assertEquals("01", khTtdkRireki2.getKbnkey());
        Assert.assertEquals("11807111118", khTtdkRireki2.getSyono());
        Assert.assertEquals("201520161002", khTtdkRireki2.getHenkousikibetukey());

        IT_KhTtdkRireki khTtdkRireki3 = khTtdkRirekis.get(2);
        Assert.assertEquals("01", khTtdkRireki3.getKbnkey());
        Assert.assertEquals("11807111118", khTtdkRireki3.getSyono());
        Assert.assertEquals("201520161003", khTtdkRireki3.getHenkousikibetukey());
    }

    @Test
    @TestOrder(20)
    public void testDetach2() {

        IT_KykKihon iT_KykKihon = null;

        Assert.assertNull(IT_KykKihonDetacher.detachKhTtdkRirekitouched(iT_KykKihon));
    }
}
