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
public class IT_KykKihonTest_getNyknJissekiRirekisByJyutouymNyktrksflg {

    @Inject
    HozenDomManager hozenDomManager;

    @BeforeClass
    @Transactional
    public static void insertTestData() {

        HozenDomManager hozenDomManager = SWAKInjector.getInstance(HozenDomManager.class);

        IT_KykKihon kykKihon1 = hozenDomManager.getKykKihon("11807111118");
        if (kykKihon1 == null) {
            kykKihon1 = new IT_KykKihon("11", "11807111118");
            Assert.assertEquals(0, kykKihon1.getNyknJissekiRirekisByJyutouymNyktrksflg(BizDateYM.valueOf(201606), C_Nyktrksflg.TORIKESI).size());

            IT_NyknJissekiRireki nyknJissekiRireki1 = kykKihon1.createNyknJissekiRireki();
            nyknJissekiRireki1.setJyutoustartym(BizDateYM.valueOf(201602));
            nyknJissekiRireki1.setRenno(21);
            nyknJissekiRireki1.setJyutouendym(BizDateYM.valueOf(201612));
            nyknJissekiRireki1.setNyktrksflg(C_Nyktrksflg.BLNK);

            IT_NyknJissekiRireki nyknJissekiRireki10 = kykKihon1.createNyknJissekiRireki();
            nyknJissekiRireki10.setJyutoustartym(BizDateYM.valueOf(201603));
            nyknJissekiRireki10.setRenno(21);
            nyknJissekiRireki10.setNyktrksflg(C_Nyktrksflg.BLNK);

            IT_NyknJissekiRireki nyknJissekiRireki11 = kykKihon1.createNyknJissekiRireki();
            nyknJissekiRireki11.setJyutoustartym(BizDateYM.valueOf(201604));
            nyknJissekiRireki11.setRenno(21);
            nyknJissekiRireki11.setJyutouendym(BizDateYM.valueOf(201612));

            IT_NyknJissekiRireki nyknJissekiRireki3 = kykKihon1.createNyknJissekiRireki();
            nyknJissekiRireki3.setJyutoustartym(BizDateYM.valueOf(201606));
            nyknJissekiRireki3.setRenno(21);
            nyknJissekiRireki3.setJyutouendym(BizDateYM.valueOf(201612));
            nyknJissekiRireki3.setNyktrksflg(C_Nyktrksflg.BLNK);

            IT_NyknJissekiRireki nyknJissekiRireki4 = kykKihon1.createNyknJissekiRireki();
            nyknJissekiRireki4.setJyutoustartym(BizDateYM.valueOf(201608));
            nyknJissekiRireki4.setRenno(21);
            nyknJissekiRireki4.setJyutouendym(BizDateYM.valueOf(201612));
            nyknJissekiRireki4.setNyktrksflg(C_Nyktrksflg.BLNK);

            IT_NyknJissekiRireki nyknJissekiRireki5 = kykKihon1.createNyknJissekiRireki();
            nyknJissekiRireki5.setJyutoustartym(BizDateYM.valueOf(201602));
            nyknJissekiRireki5.setRenno(22);
            nyknJissekiRireki5.setJyutouendym(BizDateYM.valueOf(201605));
            nyknJissekiRireki5.setNyktrksflg(C_Nyktrksflg.BLNK);

            IT_NyknJissekiRireki nyknJissekiRireki6 = kykKihon1.createNyknJissekiRireki();
            nyknJissekiRireki6.setJyutoustartym(BizDateYM.valueOf(201602));
            nyknJissekiRireki6.setRenno(23);
            nyknJissekiRireki6.setJyutouendym(BizDateYM.valueOf(201612));
            nyknJissekiRireki6.setNyktrksflg(C_Nyktrksflg.TORIKESI);

            hozenDomManager.insert(kykKihon1);

            IT_KykKihon kykKihon2 = new IT_KykKihon("11", "11807111129");

            IT_NyknJissekiRireki nyknJissekiRireki2 = kykKihon2.createNyknJissekiRireki();
            nyknJissekiRireki2.setJyutoustartym(BizDateYM.valueOf(201602));
            nyknJissekiRireki2.setRenno(21);
            nyknJissekiRireki2.setJyutouendym(BizDateYM.valueOf(201612));
            nyknJissekiRireki2.setNyktrksflg(C_Nyktrksflg.BLNK);

            hozenDomManager.insert(kykKihon2);

            IT_KykKihon kykKihon3 = new IT_KykKihon("12", "11807111130");

            IT_NyknJissekiRireki nyknJissekiRireki7 = kykKihon3.createNyknJissekiRireki();
            nyknJissekiRireki7.setJyutoustartym(BizDateYM.valueOf(201603));
            nyknJissekiRireki7.setRenno(24);
            nyknJissekiRireki7.setJyutouendym(BizDateYM.valueOf(201606));
            nyknJissekiRireki7.setNyktrksflg(C_Nyktrksflg.BLNK);

            IT_NyknJissekiRireki nyknJissekiRireki8 = kykKihon3.createNyknJissekiRireki();
            nyknJissekiRireki8.setJyutoustartym(BizDateYM.valueOf(201604));
            nyknJissekiRireki8.setRenno(25);
            nyknJissekiRireki8.setJyutouendym(BizDateYM.valueOf(201611));
            nyknJissekiRireki8.setNyktrksflg(C_Nyktrksflg.BLNK);

            IT_NyknJissekiRireki nyknJissekiRireki9 = kykKihon3.createNyknJissekiRireki();
            nyknJissekiRireki9.setJyutoustartym(BizDateYM.valueOf(201605));
            nyknJissekiRireki9.setRenno(26);
            nyknJissekiRireki9.setJyutouendym(BizDateYM.valueOf(201609));
            nyknJissekiRireki9.setNyktrksflg(C_Nyktrksflg.BLNK);

            hozenDomManager.insert(kykKihon3);
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
        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("11807111129");
        List<IT_NyknJissekiRireki> nyknJissekiRirekiList = kykKihon.getNyknJissekiRirekisByJyutouymNyktrksflg(BizDateYM.valueOf(201602), C_Nyktrksflg.BLNK);

        Assert.assertEquals(0, nyknJissekiRirekiList.size());
    }

    @Test
    @TestOrder(20)
    public void normal1() {
        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("11807111118");
        List<IT_NyknJissekiRireki> nyknJissekiRirekiList = kykKihon.getNyknJissekiRirekisByJyutouymNyktrksflg(BizDateYM.valueOf(201606), C_Nyktrksflg.BLNK);

        Assert.assertEquals(1, nyknJissekiRirekiList.size());

        Assert.assertEquals("11", nyknJissekiRirekiList.get(0).getKbnkey());
        Assert.assertEquals("11807111118", nyknJissekiRirekiList.get(0).getSyono());
        Assert.assertEquals(BizDateYM.valueOf(201602), nyknJissekiRirekiList.get(0).getJyutoustartym());
        Assert.assertEquals(23, nyknJissekiRirekiList.get(0).getRenno().intValue());
        Assert.assertEquals(BizDateYM.valueOf(201612), nyknJissekiRirekiList.get(0).getJyutouendym());

    }

    @Test
    @TestOrder(30)
    public void normal2() {
        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("11807111130");
        List<IT_NyknJissekiRireki> nyknJissekiRirekiList = kykKihon.getNyknJissekiRirekisByJyutouymNyktrksflg(BizDateYM.valueOf(201606), C_Nyktrksflg.TORIKESI);

        Assert.assertEquals(3, nyknJissekiRirekiList.size());

        Assert.assertEquals("12", nyknJissekiRirekiList.get(0).getKbnkey());
        Assert.assertEquals("11807111130", nyknJissekiRirekiList.get(0).getSyono());
        Assert.assertEquals(BizDateYM.valueOf(201603), nyknJissekiRirekiList.get(0).getJyutoustartym());
        Assert.assertEquals(24, nyknJissekiRirekiList.get(0).getRenno().intValue());
        Assert.assertEquals(BizDateYM.valueOf(201606), nyknJissekiRirekiList.get(0).getJyutouendym());

        Assert.assertEquals("12", nyknJissekiRirekiList.get(1).getKbnkey());
        Assert.assertEquals("11807111130", nyknJissekiRirekiList.get(1).getSyono());
        Assert.assertEquals(BizDateYM.valueOf(201604), nyknJissekiRirekiList.get(1).getJyutoustartym());
        Assert.assertEquals(25, nyknJissekiRirekiList.get(1).getRenno().intValue());
        Assert.assertEquals(BizDateYM.valueOf(201611), nyknJissekiRirekiList.get(1).getJyutouendym());

        Assert.assertEquals("12", nyknJissekiRirekiList.get(2).getKbnkey());
        Assert.assertEquals("11807111130", nyknJissekiRirekiList.get(2).getSyono());
        Assert.assertEquals(BizDateYM.valueOf(201605), nyknJissekiRirekiList.get(2).getJyutoustartym());
        Assert.assertEquals(26, nyknJissekiRirekiList.get(2).getRenno().intValue());
        Assert.assertEquals(BizDateYM.valueOf(201609), nyknJissekiRirekiList.get(2).getJyutouendym());
    }
}



