package yuyu.def.db.entity;

import java.util.Map;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.number.BizCurrency;
import jp.co.slcs.swak.number.currencytype.BizCurrencyTypes;
import jp.co.slcs.swak.number.currencytype.CurrencyType;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.def.classification.C_Krkseisanzumiflg;
import yuyu.def.hozen.manager.HozenDomManager;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * 仮受金額合計マップクラス<br />
 */
@RunWith(OrderedRunner.class)
public class IT_KykKihonTest_getKariukekinSumKrkgkByKrkseisanzumiflg {

    @Inject
    HozenDomManager hozenDomManager;

    @BeforeClass
    @Transactional
    public static void insertTestData() {

        HozenDomManager hozenDomManager = SWAKInjector.getInstance(HozenDomManager.class);

        IT_KykKihon kykKihon1 = hozenDomManager.getKykKihon("11807111118");
        if( null == kykKihon1 ) {
            kykKihon1 = new IT_KykKihon("01", "11807111118");

            Map<CurrencyType, BizCurrency> sumKrkgkMap = kykKihon1.getKariukekinSumKrkgkByKrkseisanzumiflg(C_Krkseisanzumiflg.valueOf("1"));
            Assert.assertEquals(0, sumKrkgkMap.size());

            IT_Kariukekin kariukekin0 = kykKihon1.createKariukekin();
            kariukekin0.setKrkno(1);
            kariukekin0.setKrkgk(BizCurrency.valueOf(2000, BizCurrencyTypes.YEN));
            kariukekin0.setKrkseisanzumiflg(C_Krkseisanzumiflg.valueOf("0"));

            IT_Kariukekin kariukekin1 = kykKihon1.createKariukekin();
            kariukekin1.setKrkno(14);
            kariukekin1.setKrkgk(BizCurrency.valueOf(1000, BizCurrencyTypes.YEN));

            hozenDomManager.insert(kykKihon1);
        }

        IT_KykKihon kykKihon2 = new IT_KykKihon("02", "11807111129");

        IT_Kariukekin kariukekin2 = kykKihon2.createKariukekin();
        kariukekin2.setKrkno(2);
        kariukekin2.setKrkgk(BizCurrency.valueOf(2000, BizCurrencyTypes.YEN));
        kariukekin2.setKrkseisanzumiflg(C_Krkseisanzumiflg.valueOf("0"));

        hozenDomManager.insert(kykKihon2);

        IT_KykKihon kykKihon3 = new IT_KykKihon("03", "11807111130");

        IT_Kariukekin kariukekin3 = kykKihon3.createKariukekin();
        kariukekin3.setKrkno(3);
        kariukekin3.setKrkgk(BizCurrency.valueOf(3000, BizCurrencyTypes.YEN));
        kariukekin3.setKrkseisanzumiflg(C_Krkseisanzumiflg.valueOf("1"));

        IT_Kariukekin kariukekin4 = kykKihon3.createKariukekin();
        kariukekin4.setKrkno(4);
        kariukekin4.setKrkgk(BizCurrency.valueOf(0, BizCurrencyTypes.YEN));
        kariukekin4.setKrkseisanzumiflg(C_Krkseisanzumiflg.valueOf("1"));

        IT_Kariukekin kariukekin5 = kykKihon3.createKariukekin();
        kariukekin5.setKrkno(5);
        kariukekin5.setKrkgk(BizCurrency.valueOf(25, BizCurrencyTypes.MANYEN));
        kariukekin5.setKrkseisanzumiflg(C_Krkseisanzumiflg.valueOf("1"));

        IT_Kariukekin kariukekin6 = kykKihon3.createKariukekin();
        kariukekin6.setKrkno(6);
        kariukekin6.setKrkgk(BizCurrency.valueOf(34, BizCurrencyTypes.MANYEN));
        kariukekin6.setKrkseisanzumiflg(C_Krkseisanzumiflg.valueOf("1"));

        IT_Kariukekin kariukekin7 = kykKihon3.createKariukekin();
        kariukekin7.setKrkno(7);
        kariukekin7.setKrkgk(BizCurrency.valueOf(66.5, BizCurrencyTypes.DOLLAR));
        kariukekin7.setKrkseisanzumiflg(C_Krkseisanzumiflg.valueOf("1"));

        IT_Kariukekin kariukekin8 = kykKihon3.createKariukekin();
        kariukekin8.setKrkno(8);
        kariukekin8.setKrkgk(BizCurrency.valueOf(43.5, BizCurrencyTypes.DOLLAR));
        kariukekin8.setKrkseisanzumiflg(C_Krkseisanzumiflg.valueOf("1"));

        IT_Kariukekin kariukekin9 = kykKihon3.createKariukekin();
        kariukekin9.setKrkno(9);
        kariukekin9.setKrkseisanzumiflg(C_Krkseisanzumiflg.valueOf("1"));

        IT_Kariukekin kariukekin10 = kykKihon3.createKariukekin();
        kariukekin10.setKrkno(10);
        kariukekin10.setKrkgk(BizCurrency.valueOf(0, BizCurrencyTypes.AU_DOLLAR));
        kariukekin10.setKrkseisanzumiflg(C_Krkseisanzumiflg.valueOf("1"));

        IT_Kariukekin kariukekin11 = kykKihon3.createKariukekin();
        kariukekin11.setKrkno(11);
        kariukekin11.setKrkgk(BizCurrency.valueOf(400, BizCurrencyTypes.AU_DOLLAR));
        kariukekin11.setKrkseisanzumiflg(C_Krkseisanzumiflg.valueOf("1"));

        IT_Kariukekin kariukekin12 = kykKihon3.createKariukekin();
        kariukekin12.setKrkno(12);
        kariukekin12.setKrkgk(BizCurrency.valueOf(600, BizCurrencyTypes.EURO));
        kariukekin12.setKrkseisanzumiflg(C_Krkseisanzumiflg.valueOf("1"));

        IT_Kariukekin kariukekin13 = kykKihon3.createKariukekin();
        kariukekin13.setKrkno(13);
        kariukekin13.setKrkgk(BizCurrency.valueOf(1000, BizCurrencyTypes.EURO));
        kariukekin13.setKrkseisanzumiflg(C_Krkseisanzumiflg.valueOf("1"));

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
    public void noResult1() {

        IT_KykKihon kykKihon1 = hozenDomManager.getKykKihon("11807111129");
        Map<CurrencyType, BizCurrency> sumKrkgkMap = kykKihon1.getKariukekinSumKrkgkByKrkseisanzumiflg(C_Krkseisanzumiflg.valueOf("0"));

        Assert.assertEquals(0, sumKrkgkMap.size());

    }

    @Test
    @TestOrder(20)
    public void normal1() {

        IT_KykKihon kykKihon1 = hozenDomManager.getKykKihon("11807111118");
        Map<CurrencyType, BizCurrency> sumKrkgkMap = kykKihon1.getKariukekinSumKrkgkByKrkseisanzumiflg(C_Krkseisanzumiflg.valueOf("1"));
        Assert.assertEquals(1, sumKrkgkMap.size());

        Assert.assertEquals(BizCurrency.valueOf(2000), sumKrkgkMap.get(BizCurrencyTypes.YEN));

    }

    @Test
    @TestOrder(30)
    public void normal2() {

        IT_KykKihon kykKihon1 = hozenDomManager.getKykKihon("11807111130");
        Map<CurrencyType, BizCurrency> sumKrkgkMap = kykKihon1.getKariukekinSumKrkgkByKrkseisanzumiflg(C_Krkseisanzumiflg.valueOf("0"));
        Assert.assertEquals(5, sumKrkgkMap.size());

        Assert.assertEquals(BizCurrency.valueOf(3000, BizCurrencyTypes.YEN), sumKrkgkMap.get(BizCurrencyTypes.YEN));
        Assert.assertEquals(BizCurrency.valueOf(59, BizCurrencyTypes.MANYEN), sumKrkgkMap.get(BizCurrencyTypes.MANYEN));
        Assert.assertEquals(BizCurrency.valueOf(110, BizCurrencyTypes.DOLLAR), sumKrkgkMap.get(BizCurrencyTypes.DOLLAR));
        Assert.assertEquals(BizCurrency.valueOf(400, BizCurrencyTypes.AU_DOLLAR), sumKrkgkMap.get(BizCurrencyTypes.AU_DOLLAR));
        Assert.assertEquals(BizCurrency.valueOf(1600, BizCurrencyTypes.EURO), sumKrkgkMap.get(BizCurrencyTypes.EURO));
    }

}
