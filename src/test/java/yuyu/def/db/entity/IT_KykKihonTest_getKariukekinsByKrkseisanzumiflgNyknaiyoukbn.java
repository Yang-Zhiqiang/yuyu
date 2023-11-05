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

import yuyu.def.classification.C_Krkseisanzumiflg;
import yuyu.def.classification.C_NyknaiyouKbn;
import yuyu.def.hozen.manager.HozenDomManager;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * 仮受金テーブルのテストクラス<br />
 */
@RunWith(OrderedRunner.class)
public class IT_KykKihonTest_getKariukekinsByKrkseisanzumiflgNyknaiyoukbn {
    @Inject
    private HozenDomManager hozenDomManager;

    @BeforeClass
    @Transactional
    public static void insertTestData() {
        HozenDomManager hozenDomManager = SWAKInjector.getInstance(HozenDomManager.class);

        IT_KykKihon kykKihon1 = hozenDomManager.getKykKihon("11807111130");
        if (kykKihon1 == null) {
            kykKihon1 = new IT_KykKihon("10","11807111130");
            List<IT_Kariukekin> kariukekinLst = kykKihon1.getKariukekinsByKrkseisanzumiflgNyknaiyoukbn(C_Krkseisanzumiflg.BLNK, C_NyknaiyouKbn.BLNK);
            Assert.assertEquals(0, kariukekinLst.size());

            IT_Kariukekin kariukekin1 = kykKihon1.createKariukekin();
            kariukekin1.setKrkno(1);
            kariukekin1.setKrkseisanzumiflg(C_Krkseisanzumiflg.BLNK);
            kariukekin1.setNyknaiyoukbn(C_NyknaiyouKbn.HOZENHENKOUYOUP);

            IT_Kariukekin kariukekin2 = kykKihon1.createKariukekin();
            kariukekin2.setKrkno(2);
            kariukekin2.setKrkseisanzumiflg(C_Krkseisanzumiflg.BLNK);
            kariukekin2.setNyknaiyoukbn(C_NyknaiyouKbn.HOZENHENKOUYOUP);

            IT_Kariukekin kariukekin3 = kykKihon1.createKariukekin();
            kariukekin3.setKrkno(3);
            kariukekin3.setKrkseisanzumiflg(C_Krkseisanzumiflg.BLNK);
            kariukekin3.setNyknaiyoukbn(C_NyknaiyouKbn.HOZENHENKOUYOUP);

            IT_Kariukekin kariukekin4 = kykKihon1.createKariukekin();
            kariukekin4.setKrkno(4);
            kariukekin4.setKrkseisanzumiflg(C_Krkseisanzumiflg.BLNK);
            kariukekin4.setNyknaiyoukbn(C_NyknaiyouKbn.KEIZOKUP);

            IT_Kariukekin kariukekin5 = kykKihon1.createKariukekin();
            kariukekin5.setKrkno(5);
            kariukekin5.setKrkseisanzumiflg(C_Krkseisanzumiflg.SUMI);
            kariukekin5.setNyknaiyoukbn(C_NyknaiyouKbn.HOZENHENKOUYOUP);

            IT_Kariukekin kariukekin6 = kykKihon1.createKariukekin();
            kariukekin6.setKrkno(6);
            kariukekin6.setKrkseisanzumiflg(C_Krkseisanzumiflg.BLNK);
            kariukekin6.setNyknaiyoukbn(C_NyknaiyouKbn.HARAIHENYOUP);

            IT_Kariukekin kariukekin7 = kykKihon1.createKariukekin();
            kariukekin7.setKrkno(7);
            kariukekin7.setNyknaiyoukbn(C_NyknaiyouKbn.KEIZOKUP);

            hozenDomManager.insert(kykKihon1);

        }

        IT_KykKihon kykKihon7 = hozenDomManager.getKykKihon("11807111118");
        if (kykKihon7 == null) {
            kykKihon7 = new IT_KykKihon("10","11807111118");
            IT_Kariukekin kariukekin7 = kykKihon7.createKariukekin();
            kariukekin7.setKrkno(1);
            kariukekin7.setKrkseisanzumiflg(C_Krkseisanzumiflg.BLNK);
            kariukekin7.setNyknaiyoukbn(C_NyknaiyouKbn.HOZENHENKOUYOUP);
            hozenDomManager.insert(kykKihon7);

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
        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("11807111130");
        List<IT_Kariukekin> kariukekinLst = kykKihon.getKariukekinsByKrkseisanzumiflgNyknaiyoukbn(C_Krkseisanzumiflg.BLNK, C_NyknaiyouKbn.BLNK);
        Assert.assertEquals(0, kariukekinLst.size());
    }

    @Test
    @TestOrder(20)
    public void normal1() {
        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("11807111130");
        List<IT_Kariukekin> kariukekinLst = kykKihon.getKariukekinsByKrkseisanzumiflgNyknaiyoukbn(C_Krkseisanzumiflg.SUMI, C_NyknaiyouKbn.KEIZOKUP);
        Assert.assertEquals(1, kariukekinLst.size());

        Assert.assertEquals("10", kariukekinLst.get(0).getKbnkey());
        Assert.assertEquals("11807111130", kariukekinLst.get(0).getSyono());
        Assert.assertEquals(Integer.valueOf(4), kariukekinLst.get(0).getKrkno());
        Assert.assertEquals(C_Krkseisanzumiflg.BLNK, kariukekinLst.get(0).getKrkseisanzumiflg());
        Assert.assertEquals(C_NyknaiyouKbn.KEIZOKUP, kariukekinLst.get(0).getNyknaiyoukbn());
    }

    @Test
    @TestOrder(30)
    public void normal2() {
        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("11807111130");
        List<IT_Kariukekin> kariukekinLst = kykKihon.getKariukekinsByKrkseisanzumiflgNyknaiyoukbn(C_Krkseisanzumiflg.SUMI, C_NyknaiyouKbn.HOZENHENKOUYOUP);
        Assert.assertEquals(3, kariukekinLst.size());

        Assert.assertEquals("10", kariukekinLst.get(0).getKbnkey());
        Assert.assertEquals("11807111130", kariukekinLst.get(0).getSyono());
        Assert.assertEquals(Integer.valueOf(1), kariukekinLst.get(0).getKrkno());
        Assert.assertEquals(C_Krkseisanzumiflg.BLNK, kariukekinLst.get(0).getKrkseisanzumiflg());
        Assert.assertEquals(C_NyknaiyouKbn.HOZENHENKOUYOUP, kariukekinLst.get(0).getNyknaiyoukbn());

        Assert.assertEquals("10", kariukekinLst.get(1).getKbnkey());
        Assert.assertEquals("11807111130", kariukekinLst.get(1).getSyono());
        Assert.assertEquals(Integer.valueOf(2), kariukekinLst.get(1).getKrkno());
        Assert.assertEquals(C_Krkseisanzumiflg.BLNK, kariukekinLst.get(1).getKrkseisanzumiflg());
        Assert.assertEquals(C_NyknaiyouKbn.HOZENHENKOUYOUP, kariukekinLst.get(1).getNyknaiyoukbn());

        Assert.assertEquals("10", kariukekinLst.get(2).getKbnkey());
        Assert.assertEquals("11807111130", kariukekinLst.get(2).getSyono());
        Assert.assertEquals(Integer.valueOf(3), kariukekinLst.get(2).getKrkno());
        Assert.assertEquals(C_Krkseisanzumiflg.BLNK, kariukekinLst.get(2).getKrkseisanzumiflg());
        Assert.assertEquals(C_NyknaiyouKbn.HOZENHENKOUYOUP, kariukekinLst.get(2).getNyknaiyoukbn());

    }

}
