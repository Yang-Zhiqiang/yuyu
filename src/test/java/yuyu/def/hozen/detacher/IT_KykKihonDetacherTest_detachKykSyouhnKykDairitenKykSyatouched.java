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

import yuyu.def.classification.C_SyutkKbn;
import yuyu.def.db.entity.IT_KykDairiten;
import yuyu.def.db.entity.IT_KykKihon;
import yuyu.def.db.entity.IT_KykSya;
import yuyu.def.db.entity.IT_KykSyouhn;
import yuyu.def.hozen.manager.HozenDomManager;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * 契約基本テーブル(IT_KykKihon) デタッチャーのテストクラスです。<br />
 */
@RunWith(OrderedRunner.class)
public class IT_KykKihonDetacherTest_detachKykSyouhnKykDairitenKykSyatouched {

    @Inject
    HozenDomManager hozenDomManager;

    @BeforeClass
    @Transactional
    public static void insertTestData() {

        HozenDomManager hozenDomManager = SWAKInjector.getInstance(HozenDomManager.class);

        IT_KykKihon kykKihon1 = new IT_KykKihon("10", "11807111118");

        IT_KykSyouhn kykSyouhn1 = kykKihon1.createKykSyouhn();
        kykSyouhn1.setSyutkkbn(C_SyutkKbn.valueOf("1"));
        kykSyouhn1.setSyouhncd("M210");
        kykSyouhn1.setSyouhnsdno(1);
        kykSyouhn1.setKyksyouhnrenno(1);

        IT_KykSyouhn kykSyouhn2 = kykKihon1.createKykSyouhn();
        kykSyouhn2.setSyutkkbn(C_SyutkKbn.valueOf("1"));
        kykSyouhn2.setSyouhncd("M210");
        kykSyouhn2.setSyouhnsdno(1);
        kykSyouhn2.setKyksyouhnrenno(2);

        IT_KykDairiten kykDairiten1 = kykKihon1.createKykDairiten();
        kykDairiten1.setDrtenrenno(1);

        IT_KykDairiten kykDairiten2 = kykKihon1.createKykDairiten();
        kykDairiten2.setDrtenrenno(2);

        IT_KykSya kykSya1 = kykKihon1.createKykSya();

        hozenDomManager.insert(kykKihon1);

        IT_KykKihon kykKihon2 = new IT_KykKihon("10", "11807111129");

        IT_KykSyouhn kykSyouhn3 = kykKihon2.createKykSyouhn();
        kykSyouhn3.setSyutkkbn(C_SyutkKbn.valueOf("1"));
        kykSyouhn3.setSyouhncd("M210");
        kykSyouhn3.setSyouhnsdno(1);
        kykSyouhn3.setKyksyouhnrenno(3);

        IT_KykSya kykSya2 = kykKihon2.createKykSya();

        hozenDomManager.insert(kykKihon2);

        IT_KykKihon kykKihon3 = new IT_KykKihon("10", "11807111130");

        IT_KykDairiten kykDairiten3 = kykKihon3.createKykDairiten();
        kykDairiten3.setDrtenrenno(3);

        hozenDomManager.insert(kykKihon3);

    }

    @AfterClass
    @Transactional
    public static void deleteTestData() {

        HozenDomManager hozenDomManager = SWAKInjector.getInstance(HozenDomManager.class);

        hozenDomManager.delete(hozenDomManager.getAllKykKihon());

    }

    @Test
    @TestOrder(10)
    public void testDetach1() {

        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("11807111118");

        kykKihon = IT_KykKihonDetacher.detachKykSyouhnKykDairitenKykSyatouched(kykKihon);
        List<IT_KykSyouhn> kykSyouhnLst = kykKihon.getKykSyouhns();

        Assert.assertEquals("10", kykSyouhnLst.get(0).getKbnkey());
        Assert.assertEquals("11807111118", kykSyouhnLst.get(0).getSyono());
        Assert.assertEquals(C_SyutkKbn.SYU, kykSyouhnLst.get(0).getSyutkkbn());
        Assert.assertEquals("M210", kykSyouhnLst.get(0).getSyouhncd());
        Assert.assertEquals(Integer.valueOf(1), kykSyouhnLst.get(0).getSyouhnsdno());
        Assert.assertEquals(Integer.valueOf(1), kykSyouhnLst.get(0).getKyksyouhnrenno());

        Assert.assertEquals("10", kykSyouhnLst.get(1).getKbnkey());
        Assert.assertEquals("11807111118", kykSyouhnLst.get(1).getSyono());
        Assert.assertEquals(C_SyutkKbn.SYU, kykSyouhnLst.get(1).getSyutkkbn());
        Assert.assertEquals("M210", kykSyouhnLst.get(1).getSyouhncd());
        Assert.assertEquals(Integer.valueOf(1), kykSyouhnLst.get(1).getSyouhnsdno());
        Assert.assertEquals(Integer.valueOf(2), kykSyouhnLst.get(1).getKyksyouhnrenno());

        List<IT_KykDairiten> kykDairitenLst = kykKihon.getKykDairitens();

        Assert.assertEquals("10", kykDairitenLst.get(0).getKbnkey());
        Assert.assertEquals("11807111118", kykDairitenLst.get(0).getSyono());
        Assert.assertEquals(Integer.valueOf(1), kykDairitenLst.get(0).getDrtenrenno());

        Assert.assertEquals("10", kykDairitenLst.get(1).getKbnkey());
        Assert.assertEquals("11807111118", kykDairitenLst.get(1).getSyono());
        Assert.assertEquals(Integer.valueOf(2), kykDairitenLst.get(1).getDrtenrenno());
        IT_KykSya kykSya = kykKihon.getKykSya();

        Assert.assertEquals("10", kykSya.getKbnkey());
        Assert.assertEquals("11807111118", kykSya.getSyono());

        ExDBEntityManager em = SWAKInjector.getInstance(ExDBEntityManager.class);

        boolean result = em.getEntityManager().contains(kykKihon);

        Assert.assertFalse(result);

    }

    @Test
    @TestOrder(20)
    public void testDetach2() {

        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("11807111314");

        kykKihon = IT_KykKihonDetacher.detachKykSyouhnKykDairitenKykSyatouched(kykKihon);

        Assert.assertNull(kykKihon);

    }
}
