package yuyu.def.db.entity;

import java.util.List;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDateYM;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.def.classification.C_Nyktrksflg;
import yuyu.def.hozen.manager.HozenDomManager;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * 入金実績履歴テーブルのテストクラス<br />
 */
@RunWith(OrderedRunner.class)
public class IT_KykKihonTest_getNyknJissekiRirekisByNyktrksflg {
    @Inject
    private HozenDomManager hozenDomManager;

    @BeforeClass
    @Transactional
    public static void insertTestData() {
        HozenDomManager hozenDomManager = SWAKInjector.getInstance(HozenDomManager.class);

        IT_KykKihon kykKihon1 = hozenDomManager.getKykKihon("11807111130");
        if (kykKihon1 == null) {
            kykKihon1 = new IT_KykKihon("10","11807111130");
            List<IT_NyknJissekiRireki> nyknJissekiRirekiLst = kykKihon1.getNyknJissekiRirekisByNyktrksflg(C_Nyktrksflg.BLNK);
            Assert.assertEquals(0, nyknJissekiRirekiLst.size());

            IT_NyknJissekiRireki nyknJissekiRireki1 = kykKihon1.createNyknJissekiRireki();
            nyknJissekiRireki1.setRenno(2);
            nyknJissekiRireki1.setJyutoustartym(BizDateYM.valueOf("201602"));
            nyknJissekiRireki1.setNyktrksflg(C_Nyktrksflg.BLNK);

            IT_NyknJissekiRireki nyknJissekiRireki2 = kykKihon1.createNyknJissekiRireki();
            nyknJissekiRireki2.setRenno(1);
            nyknJissekiRireki2.setJyutoustartym(BizDateYM.valueOf("201602"));
            nyknJissekiRireki2.setNyktrksflg(C_Nyktrksflg.BLNK);

            IT_NyknJissekiRireki nyknJissekiRireki3 = kykKihon1.createNyknJissekiRireki();
            nyknJissekiRireki3.setRenno(3);
            nyknJissekiRireki3.setJyutoustartym(BizDateYM.valueOf("201602"));
            nyknJissekiRireki3.setNyktrksflg(C_Nyktrksflg.BLNK);

            IT_NyknJissekiRireki nyknJissekiRireki4 = kykKihon1.createNyknJissekiRireki();
            nyknJissekiRireki4.setRenno(4);
            nyknJissekiRireki4.setJyutoustartym(BizDateYM.valueOf("201602"));
            nyknJissekiRireki4.setNyktrksflg(C_Nyktrksflg.TORIKESI);

            hozenDomManager.insert(kykKihon1);
        }

        IT_KykKihon kykKihon2 = hozenDomManager.getKykKihon("11807111118");
        if (kykKihon2 == null) {
            kykKihon2 = new IT_KykKihon("10","11807111118");

            IT_NyknJissekiRireki nyknJissekiRireki5 = kykKihon2.createNyknJissekiRireki();
            nyknJissekiRireki5.setRenno(5);
            nyknJissekiRireki5.setJyutoustartym(BizDateYM.valueOf("201602"));
            nyknJissekiRireki5.setNyktrksflg(C_Nyktrksflg.BLNK);

            hozenDomManager.insert(kykKihon2);
        }

        IT_KykKihon kykKihon3 = hozenDomManager.getKykKihon("11807111406");
        if (kykKihon3 == null) {
            kykKihon3 = new IT_KykKihon("10","11807111406");

            IT_NyknJissekiRireki nyknJissekiRireki6 = kykKihon3.createNyknJissekiRireki();
            nyknJissekiRireki6.setRenno(6);
            nyknJissekiRireki6.setJyutoustartym(BizDateYM.valueOf("201602"));
            nyknJissekiRireki6.setNyktrksflg(C_Nyktrksflg.BLNK);

            IT_NyknJissekiRireki nyknJissekiRireki11 = kykKihon3.createNyknJissekiRireki();
            nyknJissekiRireki11.setRenno(11);
            nyknJissekiRireki11.setJyutoustartym(BizDateYM.valueOf("201602"));

            hozenDomManager.insert(kykKihon3);
        }

        IT_KykKihon kykKihon4 = hozenDomManager.getKykKihon("11807111129");
        if (kykKihon4 == null) {
            kykKihon4 = new IT_KykKihon("10","11807111129");

            IT_NyknJissekiRireki nyknJissekiRireki7 = kykKihon4.createNyknJissekiRireki();
            nyknJissekiRireki7.setRenno(7);
            nyknJissekiRireki7.setJyutoustartym(BizDateYM.valueOf("201602"));
            nyknJissekiRireki7.setNyktrksflg(C_Nyktrksflg.TORIKESI);

            hozenDomManager.insert(kykKihon4);
        }

        IT_KykKihon kykKihon5 = hozenDomManager.getKykKihon("11807111370");
        if (kykKihon5 == null) {
            kykKihon5 = new IT_KykKihon("10","11807111370");

            IT_NyknJissekiRireki nyknJissekiRireki8 = kykKihon5.createNyknJissekiRireki();
            nyknJissekiRireki8.setRenno(8);
            nyknJissekiRireki8.setJyutoustartym(BizDateYM.valueOf("201602"));
            nyknJissekiRireki8.setNyktrksflg(C_Nyktrksflg.TORIKESI);

            IT_NyknJissekiRireki nyknJissekiRireki9 = kykKihon5.createNyknJissekiRireki();
            nyknJissekiRireki9.setRenno(9);
            nyknJissekiRireki9.setJyutoustartym(BizDateYM.valueOf("201602"));
            nyknJissekiRireki9.setNyktrksflg(C_Nyktrksflg.TORIKESI);

            IT_NyknJissekiRireki nyknJissekiRireki10 = kykKihon5.createNyknJissekiRireki();
            nyknJissekiRireki10.setRenno(10);
            nyknJissekiRireki10.setJyutoustartym(BizDateYM.valueOf("201602"));
            nyknJissekiRireki10.setNyktrksflg(C_Nyktrksflg.TORIKESI);

            hozenDomManager.insert(kykKihon5);
        }
    }

    @AfterClass
    @Transactional
    public static void deleteTestData() {
        HozenDomManager hozenDomManager = SWAKInjector.getInstance(HozenDomManager.class);
        hozenDomManager.delete(hozenDomManager.getAllKykKihon());
    }

    @Test
    @TestOrder(20)
    public void noResult1() {
        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("11807111129");
        List<IT_NyknJissekiRireki> nyknJissekiRirekiLst = kykKihon.getNyknJissekiRirekisByNyktrksflg(C_Nyktrksflg.TORIKESI);
        Assert.assertEquals(0, nyknJissekiRirekiLst.size());
    }

    @Test
    @TestOrder(30)
    public void normal1() {
        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("11807111406");
        List<IT_NyknJissekiRireki> nyknJissekiRirekiLst = kykKihon.getNyknJissekiRirekisByNyktrksflg(C_Nyktrksflg.TORIKESI);
        Assert.assertEquals(1, nyknJissekiRirekiLst.size());

        Assert.assertEquals("10", nyknJissekiRirekiLst.get(0).getKbnkey());
        Assert.assertEquals("11807111406", nyknJissekiRirekiLst.get(0).getSyono());
        Assert.assertEquals(Integer.valueOf(6), nyknJissekiRirekiLst.get(0).getRenno());
        Assert.assertEquals(BizDateYM.valueOf("201602"), nyknJissekiRirekiLst.get(0).getJyutoustartym());
        Assert.assertEquals(C_Nyktrksflg.BLNK, nyknJissekiRirekiLst.get(0).getNyktrksflg());
    }

    @Test
    @TestOrder(40)
    public void normal2() {
        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("11807111130");
        List<IT_NyknJissekiRireki> nyknJissekiRirekiLst = kykKihon.getNyknJissekiRirekisByNyktrksflg(C_Nyktrksflg.TORIKESI);
        Assert.assertEquals(3, nyknJissekiRirekiLst.size());

        Assert.assertEquals("10", nyknJissekiRirekiLst.get(0).getKbnkey());
        Assert.assertEquals("11807111130", nyknJissekiRirekiLst.get(0).getSyono());
        Assert.assertEquals(Integer.valueOf(1), nyknJissekiRirekiLst.get(0).getRenno());
        Assert.assertEquals(BizDateYM.valueOf("201602"), nyknJissekiRirekiLst.get(0).getJyutoustartym());
        Assert.assertEquals(C_Nyktrksflg.BLNK, nyknJissekiRirekiLst.get(0).getNyktrksflg());

        Assert.assertEquals("10", nyknJissekiRirekiLst.get(1).getKbnkey());
        Assert.assertEquals("11807111130", nyknJissekiRirekiLst.get(1).getSyono());
        Assert.assertEquals(Integer.valueOf(2), nyknJissekiRirekiLst.get(1).getRenno());
        Assert.assertEquals(BizDateYM.valueOf("201602"), nyknJissekiRirekiLst.get(1).getJyutoustartym());
        Assert.assertEquals(C_Nyktrksflg.BLNK, nyknJissekiRirekiLst.get(1).getNyktrksflg());

        Assert.assertEquals("10", nyknJissekiRirekiLst.get(2).getKbnkey());
        Assert.assertEquals("11807111130", nyknJissekiRirekiLst.get(2).getSyono());
        Assert.assertEquals(Integer.valueOf(3), nyknJissekiRirekiLst.get(2).getRenno());
        Assert.assertEquals(BizDateYM.valueOf("201602"), nyknJissekiRirekiLst.get(2).getJyutoustartym());
        Assert.assertEquals(C_Nyktrksflg.BLNK, nyknJissekiRirekiLst.get(2).getNyktrksflg());

    }

    @Test
    @TestOrder(50)
    public void normal3() {
        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("11807111370");
        List<IT_NyknJissekiRireki> nyknJissekiRirekiLst = kykKihon.getNyknJissekiRirekisByNyktrksflg(C_Nyktrksflg.BLNK);
        Assert.assertEquals(3, nyknJissekiRirekiLst.size());

        Assert.assertEquals("10", nyknJissekiRirekiLst.get(0).getKbnkey());
        Assert.assertEquals("11807111370", nyknJissekiRirekiLst.get(0).getSyono());
        Assert.assertEquals(Integer.valueOf(8), nyknJissekiRirekiLst.get(0).getRenno());
        Assert.assertEquals(BizDateYM.valueOf("201602"), nyknJissekiRirekiLst.get(0).getJyutoustartym());
        Assert.assertEquals(C_Nyktrksflg.TORIKESI, nyknJissekiRirekiLst.get(0).getNyktrksflg());

        Assert.assertEquals("10", nyknJissekiRirekiLst.get(1).getKbnkey());
        Assert.assertEquals("11807111370", nyknJissekiRirekiLst.get(1).getSyono());
        Assert.assertEquals(Integer.valueOf(9), nyknJissekiRirekiLst.get(1).getRenno());
        Assert.assertEquals(BizDateYM.valueOf("201602"), nyknJissekiRirekiLst.get(1).getJyutoustartym());
        Assert.assertEquals(C_Nyktrksflg.TORIKESI, nyknJissekiRirekiLst.get(1).getNyktrksflg());

        Assert.assertEquals("10", nyknJissekiRirekiLst.get(2).getKbnkey());
        Assert.assertEquals("11807111370", nyknJissekiRirekiLst.get(2).getSyono());
        Assert.assertEquals(Integer.valueOf(10), nyknJissekiRirekiLst.get(2).getRenno());
        Assert.assertEquals(BizDateYM.valueOf("201602"), nyknJissekiRirekiLst.get(2).getJyutoustartym());
        Assert.assertEquals(C_Nyktrksflg.TORIKESI, nyknJissekiRirekiLst.get(2).getNyktrksflg());

    }
}
