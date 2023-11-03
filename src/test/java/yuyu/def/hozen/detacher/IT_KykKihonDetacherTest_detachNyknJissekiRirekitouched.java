package yuyu.def.hozen.detacher;

import java.util.List;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDateYM;
import jp.co.slcs.swak.db.ExDBEntityManager;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.def.db.entity.IT_KykKihon;
import yuyu.def.db.entity.IT_NyknJissekiRireki;
import yuyu.def.hozen.manager.HozenDomManager;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * 契約基本テーブル(IT_KykKihon) デタッチャークラスです。<br />
 */
@RunWith(OrderedRunner.class)
public class IT_KykKihonDetacherTest_detachNyknJissekiRirekitouched {

    @Inject
    HozenDomManager hozenDomManager;

    @BeforeClass
    @Transactional
    public static void insertTestData() {

        HozenDomManager hozenDomManager = SWAKInjector.getInstance(HozenDomManager .class);

        IT_KykKihon kykKihon1 = new IT_KykKihon("01", "11807111118");

        IT_NyknJissekiRireki nyknJissekiRireki1 = kykKihon1.createNyknJissekiRireki();
        nyknJissekiRireki1.setJyutoustartym(BizDateYM.valueOf(201601));
        nyknJissekiRireki1.setRenno(1);

        IT_NyknJissekiRireki nyknJissekiRireki2 = kykKihon1.createNyknJissekiRireki();
        nyknJissekiRireki2.setJyutoustartym(BizDateYM.valueOf(201602));
        nyknJissekiRireki2.setRenno(2);

        IT_NyknJissekiRireki nyknJissekiRireki3 = kykKihon1.createNyknJissekiRireki();
        nyknJissekiRireki3.setJyutoustartym(BizDateYM.valueOf(201603));
        nyknJissekiRireki3.setRenno(3);

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

        IT_KykKihon entity = IT_KykKihonDetacher.detachNyknJissekiRirekitouched(iT_KykKihon);

        ExDBEntityManager em = SWAKInjector.getInstance(ExDBEntityManager.class);

        Assert.assertFalse(em.getEntityManager().contains(entity));

        List<IT_NyknJissekiRireki> nyknJissekiRirekis = entity.getNyknJissekiRirekis();

        Assert.assertEquals(3, nyknJissekiRirekis.size());

        IT_NyknJissekiRireki nyknJissekiRireki1 = nyknJissekiRirekis.get(0);
        Assert.assertEquals("01", nyknJissekiRireki1.getKbnkey());
        Assert.assertEquals("11807111118", nyknJissekiRireki1.getSyono());
        Assert.assertEquals(BizDateYM.valueOf(201601), nyknJissekiRireki1.getJyutoustartym());
        Assert.assertEquals(Integer.valueOf(1), nyknJissekiRireki1.getRenno());

        IT_NyknJissekiRireki nyknJissekiRireki2 = nyknJissekiRirekis.get(1);
        Assert.assertEquals("01", nyknJissekiRireki2.getKbnkey());
        Assert.assertEquals("11807111118", nyknJissekiRireki2.getSyono());
        Assert.assertEquals(BizDateYM.valueOf(201602), nyknJissekiRireki2.getJyutoustartym());
        Assert.assertEquals(Integer.valueOf(2), nyknJissekiRireki2.getRenno());

        IT_NyknJissekiRireki nyknJissekiRireki3 = nyknJissekiRirekis.get(2);
        Assert.assertEquals("01", nyknJissekiRireki3.getKbnkey());
        Assert.assertEquals("11807111118", nyknJissekiRireki3.getSyono());
        Assert.assertEquals(BizDateYM.valueOf(201603), nyknJissekiRireki3.getJyutoustartym());
        Assert.assertEquals(Integer.valueOf(3), nyknJissekiRireki3.getRenno());

    }

    @Test
    @TestOrder(20)
    public void testDetach2() {

        IT_KykKihon iT_KykKihon = null;

        Assert.assertNull(IT_KykKihonDetacher.detachNyknJissekiRirekitouched(iT_KykKihon));
    }
}
