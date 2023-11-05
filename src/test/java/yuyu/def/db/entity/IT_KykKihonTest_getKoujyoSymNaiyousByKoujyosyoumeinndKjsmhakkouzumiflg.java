package yuyu.def.db.entity;

import java.util.List;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.slcs.swak.core.inject.SWAKInjector;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.def.classification.C_Kjsmhakkouzumiflg;
import yuyu.def.hozen.manager.HozenDomManager;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * 控除証明内容テーブルのテストクラス<br />
 */
@RunWith(OrderedRunner.class)
public class IT_KykKihonTest_getKoujyoSymNaiyousByKoujyosyoumeinndKjsmhakkouzumiflg {

    @Inject
    private HozenDomManager hozenDomManager;

    @BeforeClass
    @Transactional
    public static void insertTestData() {
        HozenDomManager hozenDomManager = SWAKInjector.getInstance(HozenDomManager.class);

        List<IT_KykKihon> kykKihonLst = hozenDomManager.getAllKykKihon();
        if (kykKihonLst.size() == 0) {
            IT_KykKihon kykKihon = new IT_KykKihon("10","11807111118");

            List<IT_KoujyoSymNaiyou> koujyoSymNaiyouLst = kykKihon.getKoujyoSymNaiyousByKoujyosyoumeinndKjsmhakkouzumiflg("2016", C_Kjsmhakkouzumiflg.BLNK);
            Assert.assertEquals(0, koujyoSymNaiyouLst.size());

            IT_KoujyoSymNaiyou koujyoSymNaiyou = kykKihon.createKoujyoSymNaiyou();
            koujyoSymNaiyou.setSyouhncd("001");
            koujyoSymNaiyou.setRenno3keta(10);
            koujyoSymNaiyou.setKoujyosyoumeinnd("2016");
            koujyoSymNaiyou.setKjsmhakkouzumiflg(C_Kjsmhakkouzumiflg.BLNK);

            IT_KoujyoSymNaiyou koujyoSymNaiyou2 = kykKihon.createKoujyoSymNaiyou();
            koujyoSymNaiyou2.setSyouhncd("003");
            koujyoSymNaiyou2.setRenno3keta(12);
            koujyoSymNaiyou2.setKoujyosyoumeinnd("2018");
            koujyoSymNaiyou2.setKjsmhakkouzumiflg(C_Kjsmhakkouzumiflg.SUMI);

            IT_KoujyoSymNaiyou koujyoSymNaiyou3 = kykKihon.createKoujyoSymNaiyou();
            koujyoSymNaiyou3.setSyouhncd("004");
            koujyoSymNaiyou3.setRenno3keta(13);
            koujyoSymNaiyou3.setKoujyosyoumeinnd("2018");
            koujyoSymNaiyou3.setKjsmhakkouzumiflg(C_Kjsmhakkouzumiflg.SUMI);

            IT_KoujyoSymNaiyou koujyoSymNaiyou4 = kykKihon.createKoujyoSymNaiyou();
            koujyoSymNaiyou4.setSyouhncd("005");
            koujyoSymNaiyou4.setRenno3keta(14);
            koujyoSymNaiyou4.setKoujyosyoumeinnd("2018");
            koujyoSymNaiyou4.setKjsmhakkouzumiflg(C_Kjsmhakkouzumiflg.SUMI);

            IT_KoujyoSymNaiyou koujyoSymNaiyou5 = kykKihon.createKoujyoSymNaiyou();
            koujyoSymNaiyou5.setSyouhncd("006");
            koujyoSymNaiyou5.setRenno3keta(15);
            koujyoSymNaiyou5.setKoujyosyoumeinnd("2019");
            koujyoSymNaiyou5.setKjsmhakkouzumiflg(C_Kjsmhakkouzumiflg.BLNK);

            IT_KoujyoSymNaiyou koujyoSymNaiyou6 = kykKihon.createKoujyoSymNaiyou();
            koujyoSymNaiyou6.setSyouhncd("007");
            koujyoSymNaiyou6.setRenno3keta(16);
            koujyoSymNaiyou6.setKoujyosyoumeinnd("2016");
            koujyoSymNaiyou6.setKjsmhakkouzumiflg(C_Kjsmhakkouzumiflg.SUMI);

            hozenDomManager.insert(kykKihon);
        }
        List<IT_KykKihon> kykKihonLst1 = hozenDomManager.getAllKykKihon();

        if (kykKihonLst1.size() == 0) {
            IT_KykKihon kykKihon1 = new IT_KykKihon("10","11807111129");

            IT_KoujyoSymNaiyou koujyoSymNaiyou = kykKihon1.createKoujyoSymNaiyou();
            koujyoSymNaiyou.setSyouhncd("001");
            koujyoSymNaiyou.setRenno3keta(10);
            koujyoSymNaiyou.setKoujyosyoumeinnd("2016");
            koujyoSymNaiyou.setKjsmhakkouzumiflg(C_Kjsmhakkouzumiflg.BLNK);

            hozenDomManager.insert(kykKihon1);
        }

    }
    @AfterClass
    @Transactional
    public static void deleteTestData() {
        HozenDomManager hozenDomManager = SWAKInjector.getInstance(HozenDomManager.class);
        hozenDomManager.delete(hozenDomManager.getAllKykKihon());
    }

    @Test
    @TestOrder(10)
    public void noResult1() {
        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("11807111118");
        List<IT_KoujyoSymNaiyou> koujyoSymNaiyouLst = kykKihon.getKoujyoSymNaiyousByKoujyosyoumeinndKjsmhakkouzumiflg("2019", C_Kjsmhakkouzumiflg.SUMI);

        Assert.assertEquals(0, koujyoSymNaiyouLst.size());
    }

    @Test
    @TestOrder(30)
    public void normal1() {
        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("11807111118");
        List<IT_KoujyoSymNaiyou> koujyoSymNaiyouLst = kykKihon.getKoujyoSymNaiyousByKoujyosyoumeinndKjsmhakkouzumiflg("2016", C_Kjsmhakkouzumiflg.BLNK);

        Assert.assertEquals("10", koujyoSymNaiyouLst.get(0).getKbnkey());
        Assert.assertEquals("11807111118", koujyoSymNaiyouLst.get(0).getSyono());
        Assert.assertEquals("001", koujyoSymNaiyouLst.get(0).getSyouhncd());
        Assert.assertEquals(Integer.valueOf(10), koujyoSymNaiyouLst.get(0).getRenno3keta());
        Assert.assertEquals(1, koujyoSymNaiyouLst.size());
    }

    @Test
    @TestOrder(40)
    public void normal3() {
        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("11807111118");
        List<IT_KoujyoSymNaiyou> koujyoSymNaiyouLst = kykKihon.getKoujyoSymNaiyousByKoujyosyoumeinndKjsmhakkouzumiflg("2018", C_Kjsmhakkouzumiflg.SUMI);

        Assert.assertEquals("10", koujyoSymNaiyouLst.get(0).getKbnkey());
        Assert.assertEquals("11807111118", koujyoSymNaiyouLst.get(0).getSyono());
        Assert.assertEquals("003", koujyoSymNaiyouLst.get(0).getSyouhncd());
        Assert.assertEquals(Integer.valueOf(12), koujyoSymNaiyouLst.get(0).getRenno3keta());

        Assert.assertEquals("10", koujyoSymNaiyouLst.get(1).getKbnkey());
        Assert.assertEquals("11807111118", koujyoSymNaiyouLst.get(1).getSyono());
        Assert.assertEquals("004", koujyoSymNaiyouLst.get(1).getSyouhncd());
        Assert.assertEquals(Integer.valueOf(13), koujyoSymNaiyouLst.get(1).getRenno3keta());

        Assert.assertEquals("10", koujyoSymNaiyouLst.get(2).getKbnkey());
        Assert.assertEquals("11807111118", koujyoSymNaiyouLst.get(2).getSyono());
        Assert.assertEquals("005", koujyoSymNaiyouLst.get(2).getSyouhncd());
        Assert.assertEquals(Integer.valueOf(14), koujyoSymNaiyouLst.get(2).getRenno3keta());
        Assert.assertEquals(3, koujyoSymNaiyouLst.size());
    }

    @Test
    @TestOrder(50)
    @Transactional
    public void normal2() {
        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("11807111118");
        List<IT_KoujyoSymNaiyou> koujyoSymNaiyouLst = kykKihon.getKoujyoSymNaiyousByKoujyosyoumeinndKjsmhakkouzumiflg("2016", C_Kjsmhakkouzumiflg.BLNK);

        Assert.assertEquals(1, koujyoSymNaiyouLst.size());
        Assert.assertEquals("10", koujyoSymNaiyouLst.get(0).getKbnkey());
        Assert.assertEquals("11807111118", koujyoSymNaiyouLst.get(0).getSyono());
        Assert.assertEquals("001", koujyoSymNaiyouLst.get(0).getSyouhncd());
        Assert.assertEquals(Integer.valueOf(10), koujyoSymNaiyouLst.get(0).getRenno3keta());

        koujyoSymNaiyouLst.get(0).setKoujyosyoumeinnd("2020");
        hozenDomManager.update(kykKihon);
    }

    @Test
    @TestOrder(60)
    public void normal4() {
        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("11807111118");
        List<IT_KoujyoSymNaiyou> koujyoSymNaiyouLst = kykKihon.getKoujyoSymNaiyousByKoujyosyoumeinndKjsmhakkouzumiflg("2020", C_Kjsmhakkouzumiflg.BLNK);

        Assert.assertEquals(1, koujyoSymNaiyouLst.size());
        Assert.assertEquals("10", koujyoSymNaiyouLst.get(0).getKbnkey());
        Assert.assertEquals("11807111118", koujyoSymNaiyouLst.get(0).getSyono());
        Assert.assertEquals("001", koujyoSymNaiyouLst.get(0).getSyouhncd());
        Assert.assertEquals(Integer.valueOf(10), koujyoSymNaiyouLst.get(0).getRenno3keta());

    }

    @Test
    @TestOrder(70)
    public void blankCondition() {
        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("11807111118");
        List<IT_KoujyoSymNaiyou> koujyoSymNaiyouLst = kykKihon.getKoujyoSymNaiyousByKoujyosyoumeinndKjsmhakkouzumiflg("", C_Kjsmhakkouzumiflg.BLNK);

        Assert.assertEquals(0, koujyoSymNaiyouLst.size());
    }
}
