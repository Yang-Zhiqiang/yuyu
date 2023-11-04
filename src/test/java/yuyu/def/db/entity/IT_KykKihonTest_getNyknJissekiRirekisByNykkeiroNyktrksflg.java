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

import yuyu.def.classification.C_Nykkeiro;
import yuyu.def.classification.C_Nyktrksflg;
import yuyu.def.hozen.manager.HozenDomManager;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * 入金実績履歴テーブルのテストクラス<br />
 */
@RunWith(OrderedRunner.class)
public class IT_KykKihonTest_getNyknJissekiRirekisByNykkeiroNyktrksflg {
    @Inject
    private HozenDomManager hozenDomManager;

    @BeforeClass
    @Transactional
    public static void insertTestData() {
        HozenDomManager hozenDomManager = SWAKInjector.getInstance(HozenDomManager.class);

        IT_KykKihon kykKihon1 = hozenDomManager.getKykKihon("11807111118");
        if (kykKihon1 == null) {
            kykKihon1 = new IT_KykKihon("01", "11807111118");
            List<IT_NyknJissekiRireki> nyknJissekiRirekiLst = kykKihon1.getNyknJissekiRirekisByNykkeiroNyktrksflg(C_Nykkeiro.SKEI, C_Nyktrksflg.BLNK);
            Assert.assertEquals(0, nyknJissekiRirekiLst.size());

            IT_NyknJissekiRireki nyknJissekiRireki0 = kykKihon1.createNyknJissekiRireki();
            nyknJissekiRireki0.setJyutoustartym(BizDateYM.valueOf(201603));
            nyknJissekiRireki0.setRenno(1);
            nyknJissekiRireki0.setNykkeiro(C_Nykkeiro.valueOf("40"));
            nyknJissekiRireki0.setNyktrksflg(C_Nyktrksflg.valueOf("0"));

            IT_NyknJissekiRireki nyknJissekiRireki1 = kykKihon1.createNyknJissekiRireki();
            nyknJissekiRireki1.setJyutoustartym(BizDateYM.valueOf(201603));
            nyknJissekiRireki1.setRenno(6);
            nyknJissekiRireki1.setNyktrksflg(C_Nyktrksflg.valueOf("0"));

            IT_NyknJissekiRireki nyknJissekiRireki2 = kykKihon1.createNyknJissekiRireki();
            nyknJissekiRireki2.setJyutoustartym(BizDateYM.valueOf(201603));
            nyknJissekiRireki2.setRenno(2);
            nyknJissekiRireki2.setNykkeiro(C_Nykkeiro.valueOf("80"));
            nyknJissekiRireki2.setNyktrksflg(C_Nyktrksflg.valueOf("0"));

            IT_NyknJissekiRireki nyknJissekiRireki3 = kykKihon1.createNyknJissekiRireki();
            nyknJissekiRireki3.setJyutoustartym(BizDateYM.valueOf(201603));
            nyknJissekiRireki3.setRenno(3);
            nyknJissekiRireki3.setNykkeiro(C_Nykkeiro.valueOf("40"));
            nyknJissekiRireki3.setNyktrksflg(C_Nyktrksflg.valueOf("1"));

            IT_NyknJissekiRireki nyknJissekiRireki4 = kykKihon1.createNyknJissekiRireki();
            nyknJissekiRireki4.setJyutoustartym(BizDateYM.valueOf(201603));
            nyknJissekiRireki4.setRenno(4);
            nyknJissekiRireki4.setNykkeiro(C_Nykkeiro.valueOf("40"));
            nyknJissekiRireki4.setNyktrksflg(C_Nyktrksflg.valueOf("1"));

            IT_NyknJissekiRireki nyknJissekiRireki5 = kykKihon1.createNyknJissekiRireki();
            nyknJissekiRireki5.setJyutoustartym(BizDateYM.valueOf(201603));
            nyknJissekiRireki5.setRenno(5);
            nyknJissekiRireki5.setNykkeiro(C_Nykkeiro.valueOf("40"));
            nyknJissekiRireki5.setNyktrksflg(C_Nyktrksflg.valueOf("1"));

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
    @TestOrder(20)
    public void noResult1() {

        IT_KykKihon kykKihon1 = hozenDomManager.getKykKihon("11807111118");
        List<IT_NyknJissekiRireki> nyknJissekiRirekiLst = kykKihon1.getNyknJissekiRirekisByNykkeiroNyktrksflg(C_Nykkeiro.BANK, C_Nyktrksflg.TORIKESI);
        Assert.assertEquals(0, nyknJissekiRirekiLst.size());
    }

    @Test
    @TestOrder(30)
    public void normal1() {
        IT_KykKihon kykKihon1 = hozenDomManager.getKykKihon("11807111118");
        List<IT_NyknJissekiRireki> nyknJissekiRirekiLst = kykKihon1.getNyknJissekiRirekisByNykkeiroNyktrksflg(C_Nykkeiro.SKEI, C_Nyktrksflg.BLNK);
        Assert.assertEquals(1, nyknJissekiRirekiLst.size());

        Assert.assertEquals("01", nyknJissekiRirekiLst.get(0).getKbnkey());
        Assert.assertEquals("11807111118", nyknJissekiRirekiLst.get(0).getSyono());
        Assert.assertEquals(BizDateYM.valueOf(201603), nyknJissekiRirekiLst.get(0).getJyutoustartym());
        Assert.assertEquals(Integer.valueOf(1), nyknJissekiRirekiLst.get(0).getRenno());
    }

    @Test
    @TestOrder(40)
    public void normal2() {
        IT_KykKihon kykKihon1 = hozenDomManager.getKykKihon("11807111118");
        List<IT_NyknJissekiRireki> nyknJissekiRirekiLst = kykKihon1.getNyknJissekiRirekisByNykkeiroNyktrksflg(C_Nykkeiro.SKEI, C_Nyktrksflg.TORIKESI);
        Assert.assertEquals(3, nyknJissekiRirekiLst.size());

        Assert.assertEquals("01", nyknJissekiRirekiLst.get(0).getKbnkey());
        Assert.assertEquals("11807111118", nyknJissekiRirekiLst.get(0).getSyono());
        Assert.assertEquals(BizDateYM.valueOf(201603), nyknJissekiRirekiLst.get(0).getJyutoustartym());
        Assert.assertEquals(Integer.valueOf(3), nyknJissekiRirekiLst.get(0).getRenno());

        Assert.assertEquals("01", nyknJissekiRirekiLst.get(1).getKbnkey());
        Assert.assertEquals("11807111118", nyknJissekiRirekiLst.get(1).getSyono());
        Assert.assertEquals(BizDateYM.valueOf(201603), nyknJissekiRirekiLst.get(1).getJyutoustartym());
        Assert.assertEquals(Integer.valueOf(4), nyknJissekiRirekiLst.get(1).getRenno());

        Assert.assertEquals("01", nyknJissekiRirekiLst.get(2).getKbnkey());
        Assert.assertEquals("11807111118", nyknJissekiRirekiLst.get(2).getSyono());
        Assert.assertEquals(BizDateYM.valueOf(201603), nyknJissekiRirekiLst.get(2).getJyutoustartym());
        Assert.assertEquals(Integer.valueOf(5), nyknJissekiRirekiLst.get(2).getRenno());

    }
}
