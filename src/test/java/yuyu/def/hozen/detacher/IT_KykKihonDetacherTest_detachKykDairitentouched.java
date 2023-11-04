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

import yuyu.def.db.entity.IT_KykDairiten;
import yuyu.def.db.entity.IT_KykKihon;
import yuyu.def.hozen.manager.HozenDomManager;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * 契約基本テーブル(IT_KykKihon) デタッチャークラスです。<br />
 */
@RunWith(OrderedRunner.class)
public class IT_KykKihonDetacherTest_detachKykDairitentouched {

    @Inject
    HozenDomManager hozenDomManager;

    @BeforeClass
    @Transactional
    public static void insertTestData() {

        HozenDomManager hozenDomManager = SWAKInjector.getInstance(HozenDomManager .class);

        IT_KykKihon kykKihon1 = new IT_KykKihon("01", "11807111118");

        IT_KykDairiten kykDairiten1 = kykKihon1.createKykDairiten();
        kykDairiten1.setDrtenrenno(1);

        IT_KykDairiten kykDairiten2 = kykKihon1.createKykDairiten();
        kykDairiten2.setDrtenrenno(2);

        IT_KykDairiten kykDairiten3 = kykKihon1.createKykDairiten();
        kykDairiten3.setDrtenrenno(3);

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

        IT_KykKihon entity = IT_KykKihonDetacher.detachKykDairitentouched(iT_KykKihon);

        ExDBEntityManager em = SWAKInjector.getInstance(ExDBEntityManager.class);

        Assert.assertFalse(em.getEntityManager().contains(entity));

        List<IT_KykDairiten> kykDairitenLst = entity.getKykDairitens();

        Assert.assertEquals(3, kykDairitenLst.size());

        IT_KykDairiten kykDairiten1 = kykDairitenLst.get(0);
        Assert.assertEquals("01", kykDairiten1.getKbnkey());
        Assert.assertEquals("11807111118", kykDairiten1.getSyono());
        Assert.assertEquals(1, kykDairiten1.getDrtenrenno().intValue());

        IT_KykDairiten kykDairiten2 = kykDairitenLst.get(1);
        Assert.assertEquals("01", kykDairiten2.getKbnkey());
        Assert.assertEquals("11807111118", kykDairiten2.getSyono());
        Assert.assertEquals(2, kykDairiten2.getDrtenrenno().intValue());

        IT_KykDairiten kykDairiten3 = kykDairitenLst.get(2);
        Assert.assertEquals("01", kykDairiten3.getKbnkey());
        Assert.assertEquals("11807111118", kykDairiten3.getSyono());
        Assert.assertEquals(3, kykDairiten3.getDrtenrenno().intValue());
    }

    @Test
    @TestOrder(20)
    public void testDetach2() {

        IT_KykKihon iT_KykKihon = hozenDomManager.getKykKihon("11807111129");

        Assert.assertNull(IT_KykKihonDetacher.detachKykDairitentouched(iT_KykKihon));
    }
}
