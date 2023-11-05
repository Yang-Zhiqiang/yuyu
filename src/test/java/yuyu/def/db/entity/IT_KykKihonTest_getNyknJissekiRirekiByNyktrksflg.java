package yuyu.def.db.entity;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDateYM;
import jp.co.slcs.swak.number.BizCurrency;
import jp.co.slcs.swak.number.currencytype.BizCurrencyTypes;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.def.classification.C_Nyktrksflg;
import yuyu.def.hozen.manager.HozenDomManager;
import yuyu.def.hozen.result.bean.NyknJissekiRirekiByNyktrksflgBean;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * 入金実績履歴Bean取得<br />
 */
@RunWith(OrderedRunner.class)
public class IT_KykKihonTest_getNyknJissekiRirekiByNyktrksflg {

    @Inject
    private HozenDomManager hozenDomManager;

    @BeforeClass
    @Transactional
    public static void insertTestData() {
        HozenDomManager hozenDomManager = SWAKInjector.getInstance(HozenDomManager.class);

        IT_KykKihon kykKihon1 = hozenDomManager.getKykKihon("11807111141");
        if (kykKihon1 == null) {
            kykKihon1 = new IT_KykKihon("10", "11807111141");

            NyknJissekiRirekiByNyktrksflgBean nyknJissekiRirekiByNyktrksflgBean = kykKihon1.getNyknJissekiRirekiByNyktrksflg(C_Nyktrksflg.BLNK);
            Assert.assertEquals("", nyknJissekiRirekiByNyktrksflgBean.getSyono());
            Assert.assertEquals(0, nyknJissekiRirekiByNyktrksflgBean.getSumRsgaku().size());
            Assert.assertEquals(0, nyknJissekiRirekiByNyktrksflgBean.getSumYenkansannyknkingk().size());

            IT_NyknJissekiRireki nyknJissekiRireki1 = kykKihon1.createNyknJissekiRireki();
            nyknJissekiRireki1.setJyutoustartym(BizDateYM.valueOf(201506));
            nyknJissekiRireki1.setRenno(1);
            nyknJissekiRireki1.setRsgaku(BizCurrency.valueOf(101,BizCurrencyTypes.YEN));
            nyknJissekiRireki1.setNyktrksflg(C_Nyktrksflg.TORIKESI);
            nyknJissekiRireki1.setYenkansannyknkingk(BizCurrency.valueOf(0,BizCurrencyTypes.YEN));

            IT_NyknJissekiRireki nyknJissekiRireki2 = kykKihon1.createNyknJissekiRireki();
            nyknJissekiRireki2.setJyutoustartym(BizDateYM.valueOf(201506));
            nyknJissekiRireki2.setRenno(2);
            nyknJissekiRireki2.setRsgaku(BizCurrency.valueOf(102,BizCurrencyTypes.YEN));
            nyknJissekiRireki2.setNyktrksflg(C_Nyktrksflg.BLNK);
            nyknJissekiRireki2.setYenkansannyknkingk(BizCurrency.valueOf(0,BizCurrencyTypes.YEN));

            IT_NyknJissekiRireki nyknJissekiRireki3 = kykKihon1.createNyknJissekiRireki();
            nyknJissekiRireki3.setJyutoustartym(BizDateYM.valueOf(201506));
            nyknJissekiRireki3.setRenno(3);
            nyknJissekiRireki3.setRsgaku(BizCurrency.valueOf(103,BizCurrencyTypes.YEN));
            nyknJissekiRireki3.setNyktrksflg(C_Nyktrksflg.BLNK);
            nyknJissekiRireki3.setYenkansannyknkingk(BizCurrency.valueOf(1,BizCurrencyTypes.YEN));

            IT_NyknJissekiRireki nyknJissekiRireki4 = kykKihon1.createNyknJissekiRireki();
            nyknJissekiRireki4.setJyutoustartym(BizDateYM.valueOf(201506));
            nyknJissekiRireki4.setRenno(4);
            nyknJissekiRireki4.setRsgaku(BizCurrency.valueOf(104,BizCurrencyTypes.YEN));
            nyknJissekiRireki4.setNyktrksflg(C_Nyktrksflg.BLNK);
            nyknJissekiRireki4.setYenkansannyknkingk(BizCurrency.valueOf(2,BizCurrencyTypes.YEN));

            IT_NyknJissekiRireki nyknJissekiRireki5 = kykKihon1.createNyknJissekiRireki();
            nyknJissekiRireki5.setJyutoustartym(BizDateYM.valueOf(201506));
            nyknJissekiRireki5.setRenno(5);
            nyknJissekiRireki5.setRsgaku(BizCurrency.valueOf(105,BizCurrencyTypes.MANYEN));
            nyknJissekiRireki5.setNyktrksflg(C_Nyktrksflg.BLNK);
            nyknJissekiRireki5.setYenkansannyknkingk(BizCurrency.valueOf(3,BizCurrencyTypes.MANYEN));

            IT_NyknJissekiRireki nyknJissekiRireki6 = kykKihon1.createNyknJissekiRireki();
            nyknJissekiRireki6.setJyutoustartym(BizDateYM.valueOf(201506));
            nyknJissekiRireki6.setRenno(6);
            nyknJissekiRireki6.setRsgaku(BizCurrency.valueOf(106,BizCurrencyTypes.DOLLAR));
            nyknJissekiRireki6.setNyktrksflg(C_Nyktrksflg.BLNK);
            nyknJissekiRireki6.setYenkansannyknkingk(BizCurrency.valueOf(4,BizCurrencyTypes.YEN));

            IT_NyknJissekiRireki nyknJissekiRireki7 = kykKihon1.createNyknJissekiRireki();
            nyknJissekiRireki7.setJyutoustartym(BizDateYM.valueOf(201506));
            nyknJissekiRireki7.setRenno(7);
            nyknJissekiRireki7.setNyktrksflg(C_Nyktrksflg.BLNK);
            nyknJissekiRireki7.setYenkansannyknkingk(BizCurrency.valueOf(5,BizCurrencyTypes.YEN));

            IT_NyknJissekiRireki nyknJissekiRireki8 = kykKihon1.createNyknJissekiRireki();
            nyknJissekiRireki8.setJyutoustartym(BizDateYM.valueOf(201506));
            nyknJissekiRireki8.setRenno(8);
            nyknJissekiRireki8.setRsgaku(BizCurrency.valueOf(0,BizCurrencyTypes.YEN));
            nyknJissekiRireki8.setNyktrksflg(C_Nyktrksflg.BLNK);
            nyknJissekiRireki8.setYenkansannyknkingk(BizCurrency.valueOf(401,BizCurrencyTypes.YEN));

            IT_NyknJissekiRireki nyknJissekiRireki9 = kykKihon1.createNyknJissekiRireki();
            nyknJissekiRireki9.setJyutoustartym(BizDateYM.valueOf(201506));
            nyknJissekiRireki9.setRenno(9);
            nyknJissekiRireki9.setRsgaku(BizCurrency.valueOf(0,BizCurrencyTypes.YEN));
            nyknJissekiRireki9.setNyktrksflg(C_Nyktrksflg.BLNK);
            nyknJissekiRireki9.setYenkansannyknkingk(BizCurrency.valueOf(402,BizCurrencyTypes.YEN));

            IT_NyknJissekiRireki nyknJissekiRireki10 = kykKihon1.createNyknJissekiRireki();
            nyknJissekiRireki10.setJyutoustartym(BizDateYM.valueOf(201506));
            nyknJissekiRireki10.setRenno(10);
            nyknJissekiRireki10.setRsgaku(BizCurrency.valueOf(6,BizCurrencyTypes.YEN));
            nyknJissekiRireki10.setNyktrksflg(C_Nyktrksflg.BLNK);
            nyknJissekiRireki10.setYenkansannyknkingk(BizCurrency.valueOf(403,BizCurrencyTypes.YEN));

            IT_NyknJissekiRireki nyknJissekiRireki11 = kykKihon1.createNyknJissekiRireki();
            nyknJissekiRireki11.setJyutoustartym(BizDateYM.valueOf(201506));
            nyknJissekiRireki11.setRenno(11);
            nyknJissekiRireki11.setRsgaku(BizCurrency.valueOf(7,BizCurrencyTypes.YEN));
            nyknJissekiRireki11.setNyktrksflg(C_Nyktrksflg.BLNK);
            nyknJissekiRireki11.setYenkansannyknkingk(BizCurrency.valueOf(404,BizCurrencyTypes.MANYEN));

            IT_NyknJissekiRireki nyknJissekiRireki12 = kykKihon1.createNyknJissekiRireki();
            nyknJissekiRireki12.setJyutoustartym(BizDateYM.valueOf(201506));
            nyknJissekiRireki12.setRenno(12);
            nyknJissekiRireki12.setRsgaku(BizCurrency.valueOf(8,BizCurrencyTypes.YEN));
            nyknJissekiRireki12.setNyktrksflg(C_Nyktrksflg.BLNK);
            nyknJissekiRireki12.setYenkansannyknkingk(BizCurrency.valueOf(405,BizCurrencyTypes.DOLLAR));

            IT_NyknJissekiRireki nyknJissekiRireki13 = kykKihon1.createNyknJissekiRireki();
            nyknJissekiRireki13.setJyutoustartym(BizDateYM.valueOf(201506));
            nyknJissekiRireki13.setRenno(13);
            nyknJissekiRireki13.setRsgaku(BizCurrency.valueOf(9, BizCurrencyTypes.YEN));
            nyknJissekiRireki13.setNyktrksflg(C_Nyktrksflg.BLNK);

            IT_NyknJissekiRireki nyknJissekiRireki14 = kykKihon1.createNyknJissekiRireki();
            nyknJissekiRireki14.setJyutoustartym(BizDateYM.valueOf(201506));
            nyknJissekiRireki14.setRenno(14);

            nyknJissekiRireki14.setNyktrksflg(C_Nyktrksflg.BLNK);

            hozenDomManager.insert(kykKihon1);
        }

        IT_KykKihon kykKihon2 = hozenDomManager.getKykKihon("11807111118");
        if (kykKihon2 == null) {
            kykKihon2 = new IT_KykKihon("10", "11807111118");

            IT_NyknJissekiRireki nyknJissekiRireki11 = kykKihon2.createNyknJissekiRireki();
            nyknJissekiRireki11.setJyutoustartym(BizDateYM.valueOf(201506));
            nyknJissekiRireki11.setRenno(1);
            nyknJissekiRireki11.setRsgaku(BizCurrency.valueOf(10, BizCurrencyTypes.YEN));
            nyknJissekiRireki11.setNyktrksflg(C_Nyktrksflg.TORIKESI);
            nyknJissekiRireki11.setYenkansannyknkingk(BizCurrency.valueOf(406, BizCurrencyTypes.DOLLAR));

            hozenDomManager.insert(kykKihon2);
        }

        IT_KykKihon kykKihon3 = hozenDomManager.getKykKihon("11807111129");
        if (kykKihon3 == null) {
            kykKihon3 = new IT_KykKihon("10", "11807111129");
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
        NyknJissekiRirekiByNyktrksflgBean nyknJissekiRirekiByNyktrksflgBean = kykKihon.getNyknJissekiRirekiByNyktrksflg(C_Nyktrksflg.BLNK);
        Assert.assertEquals("", nyknJissekiRirekiByNyktrksflgBean.getSyono());
        Assert.assertEquals(0, nyknJissekiRirekiByNyktrksflgBean.getSumRsgaku().size());
        Assert.assertEquals(0, nyknJissekiRirekiByNyktrksflgBean.getSumYenkansannyknkingk().size());

    }

    @Test
    @TestOrder(20)
    public void normal1() {
        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("11807111118");
        NyknJissekiRirekiByNyktrksflgBean nyknJissekiRirekiByNyktrksflgBean = kykKihon.getNyknJissekiRirekiByNyktrksflg(C_Nyktrksflg.TORIKESI);
        Assert.assertEquals("11807111118", nyknJissekiRirekiByNyktrksflgBean.getSyono());
        Assert.assertEquals(1, nyknJissekiRirekiByNyktrksflgBean.getSumRsgaku().size());
        Assert.assertEquals(BizCurrency.valueOf(10), nyknJissekiRirekiByNyktrksflgBean.getSumRsgaku().get(BizCurrencyTypes.YEN));
        Assert.assertEquals(1, nyknJissekiRirekiByNyktrksflgBean.getSumYenkansannyknkingk().size());
        Assert.assertEquals(BizCurrency.valueOf(406,BizCurrencyTypes.DOLLAR), nyknJissekiRirekiByNyktrksflgBean.getSumYenkansannyknkingk().get(BizCurrencyTypes.DOLLAR));

    }

    @Test
    @TestOrder(30)
    public void normal2() {
        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("11807111141");
        NyknJissekiRirekiByNyktrksflgBean nyknJissekiRirekiByNyktrksflgBean = kykKihon.getNyknJissekiRirekiByNyktrksflg(C_Nyktrksflg.BLNK);
        Assert.assertEquals("11807111141", nyknJissekiRirekiByNyktrksflgBean.getSyono());
        Assert.assertEquals(3, nyknJissekiRirekiByNyktrksflgBean.getSumRsgaku().size());
        Assert.assertEquals(BizCurrency.valueOf(339), nyknJissekiRirekiByNyktrksflgBean.getSumRsgaku().get(BizCurrencyTypes.YEN));
        Assert.assertEquals(BizCurrency.valueOf(105,BizCurrencyTypes.MANYEN), nyknJissekiRirekiByNyktrksflgBean.getSumRsgaku().get(BizCurrencyTypes.MANYEN));
        Assert.assertEquals(BizCurrency.valueOf(106,BizCurrencyTypes.DOLLAR), nyknJissekiRirekiByNyktrksflgBean.getSumRsgaku().get(BizCurrencyTypes.DOLLAR));
        Assert.assertEquals(3, nyknJissekiRirekiByNyktrksflgBean.getSumYenkansannyknkingk().size());
        Assert.assertEquals(BizCurrency.valueOf(1218), nyknJissekiRirekiByNyktrksflgBean.getSumYenkansannyknkingk().get(BizCurrencyTypes.YEN));
        Assert.assertEquals(BizCurrency.valueOf(407,BizCurrencyTypes.MANYEN), nyknJissekiRirekiByNyktrksflgBean.getSumYenkansannyknkingk().get(BizCurrencyTypes.MANYEN));
        Assert.assertEquals(BizCurrency.valueOf(405,BizCurrencyTypes.DOLLAR), nyknJissekiRirekiByNyktrksflgBean.getSumYenkansannyknkingk().get(BizCurrencyTypes.DOLLAR));
    }
}
