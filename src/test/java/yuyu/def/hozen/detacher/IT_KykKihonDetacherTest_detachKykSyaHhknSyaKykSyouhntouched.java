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
import yuyu.def.db.entity.IT_HhknSya;
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
public class IT_KykKihonDetacherTest_detachKykSyaHhknSyaKykSyouhntouched {

    @Inject
    HozenDomManager hozenDomManager;

    @BeforeClass
    @Transactional
    public static void insertTestData() {

        HozenDomManager hozenDomManager = SWAKInjector.getInstance(HozenDomManager.class);

        IT_KykKihon kykKihon1 = new IT_KykKihon("01", "11807111118");

        IT_KykSyouhn kykSyouhn1 = kykKihon1.createKykSyouhn();
        kykSyouhn1.setSyutkkbn(C_SyutkKbn.valueOf("1"));
        kykSyouhn1.setSyouhncd("M210");
        kykSyouhn1.setSyouhnsdno(1);
        kykSyouhn1.setKyksyouhnrenno(1);

        IT_KykSyouhn kykSyouhn2 = kykKihon1.createKykSyouhn();
        kykSyouhn2.setSyutkkbn(C_SyutkKbn.valueOf("2"));
        kykSyouhn2.setSyouhncd("M210");
        kykSyouhn2.setSyouhnsdno(1);
        kykSyouhn2.setKyksyouhnrenno(2);

        kykKihon1.createKykSya();

        kykKihon1.createHhknSya();

        hozenDomManager.insert(kykKihon1);

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

        kykKihon = IT_KykKihonDetacher.detachKykSyaHhknSyaKykSyouhntouched(kykKihon);
        List<IT_KykSyouhn> kykSyouhnLst = kykKihon.getKykSyouhns();

        Assert.assertEquals("01", kykSyouhnLst.get(0).getKbnkey());
        Assert.assertEquals("11807111118", kykSyouhnLst.get(0).getSyono());
        Assert.assertEquals(C_SyutkKbn.SYU, kykSyouhnLst.get(0).getSyutkkbn());
        Assert.assertEquals("M210", kykSyouhnLst.get(0).getSyouhncd());
        Assert.assertEquals(Integer.valueOf(1), kykSyouhnLst.get(0).getSyouhnsdno());
        Assert.assertEquals(Integer.valueOf(1), kykSyouhnLst.get(0).getKyksyouhnrenno());

        Assert.assertEquals("01", kykSyouhnLst.get(1).getKbnkey());
        Assert.assertEquals("11807111118", kykSyouhnLst.get(1).getSyono());
        Assert.assertEquals(C_SyutkKbn.TK, kykSyouhnLst.get(1).getSyutkkbn());
        Assert.assertEquals("M210", kykSyouhnLst.get(1).getSyouhncd());
        Assert.assertEquals(Integer.valueOf(1), kykSyouhnLst.get(1).getSyouhnsdno());
        Assert.assertEquals(Integer.valueOf(2), kykSyouhnLst.get(1).getKyksyouhnrenno());

        IT_HhknSya hhknSya = kykKihon.getHhknSya();

        Assert.assertEquals("01", hhknSya.getKbnkey());
        Assert.assertEquals("11807111118", hhknSya.getSyono());

        IT_KykSya kykSya = kykKihon.getKykSya();

        Assert.assertEquals("01", kykSya.getKbnkey());
        Assert.assertEquals("11807111118", kykSya.getSyono());

        ExDBEntityManager em = SWAKInjector.getInstance(ExDBEntityManager.class);

        boolean result = em.getEntityManager().contains(kykKihon);

        Assert.assertFalse(result);

    }

    @Test
    @TestOrder(20)
    public void testDetach2() {

        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("11807111314");

        kykKihon = IT_KykKihonDetacher.detachKykSyaHhknSyaKykSyouhntouched(kykKihon);

        Assert.assertNull(kykKihon);

    }
}
