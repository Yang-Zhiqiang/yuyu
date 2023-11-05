package yuyu.def.db.entity;

import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.core.test.SWAKTestRunner;
import jp.co.slcs.swak.number.BizCurrency;
import jp.co.slcs.swak.number.currencytype.BizCurrencyTypes;
import jp.co.slcs.swak.number.currencytype.CurrencyType;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.def.classification.C_KoujyosyoumeipKbn;
import yuyu.def.hozen.manager.HozenDomManager;
import yuyu.testinfr.TestOrder;

/**
 * 控除証明内容テーブルのテストクラス<br />
 */
@RunWith(SWAKTestRunner.class)
public class IT_KykKihonTest_getKoujyoSymNaiyouKoujyosyoumeipkbnSumKoujyosyoumeigks {

    @Inject
    private HozenDomManager hozenDomManager;

    private final static String kbnkey1 = "01";

    private final static String syono1 = "11807111118";

    private final static String syono2 = "11807111130";

    private final static String syono3 = "11807111129";

    private final static String syouhncd1 = "M210";

    private final static Integer renno3keta1 = Integer.valueOf(101);

    private final static Integer renno3keta2 = Integer.valueOf(102);

    private final static Integer renno3keta3 = Integer.valueOf(103);

    private final static Integer renno3keta4 = Integer.valueOf(104);

    private final static Integer renno3keta5 = Integer.valueOf(105);

    private final static Integer renno3keta6 = Integer.valueOf(106);

    private final static Integer renno3keta7 = Integer.valueOf(107);

    private final static Integer renno3keta8 = Integer.valueOf(108);

    private final static Integer renno3keta9 = Integer.valueOf(109);

    private final static Integer renno3keta10 = Integer.valueOf(110);

    private final static Integer renno3keta11 = Integer.valueOf(111);

    private final static Integer renno3keta12 = Integer.valueOf(112);

    private final static Integer renno3keta13 = Integer.valueOf(113);

    private final static Integer renno3keta14 = Integer.valueOf(114);

    private final static Integer renno3keta15 = Integer.valueOf(115);

    private final static Integer renno3keta16 = Integer.valueOf(116);

    private final static Integer renno3keta17 = Integer.valueOf(117);

    private final static Integer renno3keta18 = Integer.valueOf(118);

    private final static Integer renno3keta19 = Integer.valueOf(119);

    private final static Integer renno3keta20 = Integer.valueOf(120);

    private final static Integer renno3keta21 = Integer.valueOf(121);

    @BeforeClass
    @Transactional
    public static void insertTestData() {
        HozenDomManager hozenDomManager = SWAKInjector.getInstance(HozenDomManager.class);

        IT_KykKihon kykKihon = hozenDomManager.getKykKihon(syono3);

        if (kykKihon == null) {

            kykKihon = new IT_KykKihon(kbnkey1, syono3);

            List<Object[]> kykSyouhnLst = kykKihon.getKoujyoSymNaiyouKoujyosyoumeipkbnSumKoujyosyoumeigks();

            Assert.assertEquals(0, kykSyouhnLst.size());

            IT_KykKihon kykKihon1 = new IT_KykKihon(kbnkey1, syono1);

            IT_KoujyoSymNaiyou koujyoSymNaiyou1 = kykKihon1.createKoujyoSymNaiyou();
            koujyoSymNaiyou1.setSyono(syono1);
            koujyoSymNaiyou1.setSyouhncd(syouhncd1);
            koujyoSymNaiyou1.setRenno3keta(renno3keta1);
            koujyoSymNaiyou1.setKoujyosyoumeipkbn(C_KoujyosyoumeipKbn.IPPAN);
            koujyoSymNaiyou1.setKoujyosyoumeigk(BizCurrency.valueOf(100, BizCurrencyTypes.YEN));

            IT_KoujyoSymNaiyou koujyoSymNaiyou2 = kykKihon1.createKoujyoSymNaiyou();
            koujyoSymNaiyou2.setSyono(syono1);
            koujyoSymNaiyou2.setSyouhncd(syouhncd1);
            koujyoSymNaiyou2.setRenno3keta(renno3keta2);
            koujyoSymNaiyou2.setKoujyosyoumeipkbn(C_KoujyosyoumeipKbn.IPPAN);
            koujyoSymNaiyou2.setKoujyosyoumeigk(BizCurrency.valueOf(110, BizCurrencyTypes.YEN));

            IT_KoujyoSymNaiyou koujyoSymNaiyou3 = kykKihon1.createKoujyoSymNaiyou();
            koujyoSymNaiyou3.setSyono(syono1);
            koujyoSymNaiyou3.setSyouhncd(syouhncd1);
            koujyoSymNaiyou3.setRenno3keta(renno3keta3);
            koujyoSymNaiyou3.setKoujyosyoumeipkbn(C_KoujyosyoumeipKbn.IPPAN);
            koujyoSymNaiyou3.setKoujyosyoumeigk(BizCurrency.valueOf(8000, BizCurrencyTypes.EURO));

            IT_KoujyoSymNaiyou koujyoSymNaiyou4 = kykKihon1.createKoujyoSymNaiyou();
            koujyoSymNaiyou4.setSyono(syono1);
            koujyoSymNaiyou4.setSyouhncd(syouhncd1);
            koujyoSymNaiyou4.setRenno3keta(renno3keta4);
            koujyoSymNaiyou4.setKoujyosyoumeipkbn(C_KoujyosyoumeipKbn.IPPAN);
            koujyoSymNaiyou4.setKoujyosyoumeigk(BizCurrency.valueOf(120, BizCurrencyTypes.EURO));

            IT_KoujyoSymNaiyou koujyoSymNaiyou5 = kykKihon1.createKoujyoSymNaiyou();
            koujyoSymNaiyou5.setSyono(syono1);
            koujyoSymNaiyou5.setSyouhncd(syouhncd1);
            koujyoSymNaiyou5.setRenno3keta(renno3keta5);
            koujyoSymNaiyou5.setKoujyosyoumeipkbn(C_KoujyosyoumeipKbn.IPPAN);
            koujyoSymNaiyou5.setKoujyosyoumeigk(BizCurrency.valueOf(130, BizCurrencyTypes.MANYEN));

            IT_KoujyoSymNaiyou koujyoSymNaiyou6 = kykKihon1.createKoujyoSymNaiyou();
            koujyoSymNaiyou6.setSyono(syono1);
            koujyoSymNaiyou6.setSyouhncd(syouhncd1);
            koujyoSymNaiyou6.setRenno3keta(renno3keta6);
            koujyoSymNaiyou6.setKoujyosyoumeipkbn(C_KoujyosyoumeipKbn.IPPAN);
            koujyoSymNaiyou6.setKoujyosyoumeigk(BizCurrency.valueOf(9000, BizCurrencyTypes.MANYEN));

            IT_KoujyoSymNaiyou koujyoSymNaiyou22 = kykKihon1.createKoujyoSymNaiyou();
            koujyoSymNaiyou22.setSyono(syono1);
            koujyoSymNaiyou22.setSyouhncd(syouhncd1);
            koujyoSymNaiyou22.setRenno3keta(renno3keta21);
            koujyoSymNaiyou22.setKoujyosyoumeipkbn(C_KoujyosyoumeipKbn.IPPAN);
            koujyoSymNaiyou22.setKoujyosyoumeigk(null);

            IT_KoujyoSymNaiyou koujyoSymNaiyou7 = kykKihon1.createKoujyoSymNaiyou();
            koujyoSymNaiyou7.setSyono(syono1);
            koujyoSymNaiyou7.setSyouhncd(syouhncd1);
            koujyoSymNaiyou7.setRenno3keta(renno3keta7);
            koujyoSymNaiyou7.setKoujyosyoumeipkbn(C_KoujyosyoumeipKbn.KAIGOIRYOU);
            koujyoSymNaiyou7.setKoujyosyoumeigk(BizCurrency.valueOf(1, BizCurrencyTypes.YEN));

            IT_KoujyoSymNaiyou koujyoSymNaiyou8 = kykKihon1.createKoujyoSymNaiyou();
            koujyoSymNaiyou8.setSyono(syono1);
            koujyoSymNaiyou8.setSyouhncd(syouhncd1);
            koujyoSymNaiyou8.setRenno3keta(renno3keta8);
            koujyoSymNaiyou8.setKoujyosyoumeipkbn(C_KoujyosyoumeipKbn.KAIGOIRYOU);
            koujyoSymNaiyou8.setKoujyosyoumeigk(BizCurrency.valueOf(2, BizCurrencyTypes.YEN));

            IT_KoujyoSymNaiyou koujyoSymNaiyou17 = kykKihon1.createKoujyoSymNaiyou();
            koujyoSymNaiyou17.setSyono(syono1);
            koujyoSymNaiyou17.setSyouhncd(syouhncd1);
            koujyoSymNaiyou17.setRenno3keta(renno3keta16);
            koujyoSymNaiyou17.setKoujyosyoumeipkbn(C_KoujyosyoumeipKbn.KAIGOIRYOU);
            koujyoSymNaiyou17.setKoujyosyoumeigk(BizCurrency.valueOf(3.2, BizCurrencyTypes.DOLLAR));

            IT_KoujyoSymNaiyou koujyoSymNaiyou18 = kykKihon1.createKoujyoSymNaiyou();
            koujyoSymNaiyou18.setSyono(syono1);
            koujyoSymNaiyou18.setSyouhncd(syouhncd1);
            koujyoSymNaiyou18.setRenno3keta(renno3keta17);
            koujyoSymNaiyou18.setKoujyosyoumeipkbn(C_KoujyosyoumeipKbn.KAIGOIRYOU);
            koujyoSymNaiyou18.setKoujyosyoumeigk(BizCurrency.valueOf(5.6, BizCurrencyTypes.DOLLAR));

            IT_KoujyoSymNaiyou koujyoSymNaiyou19 = kykKihon1.createKoujyoSymNaiyou();
            koujyoSymNaiyou19.setSyono(syono1);
            koujyoSymNaiyou19.setSyouhncd(syouhncd1);
            koujyoSymNaiyou19.setRenno3keta(renno3keta18);
            koujyoSymNaiyou19.setKoujyosyoumeipkbn(C_KoujyosyoumeipKbn.KAIGOIRYOU);
            koujyoSymNaiyou19.setKoujyosyoumeigk(BizCurrency.valueOf(114, BizCurrencyTypes.AU_DOLLAR));

            IT_KoujyoSymNaiyou koujyoSymNaiyou20 = kykKihon1.createKoujyoSymNaiyou();
            koujyoSymNaiyou20.setSyono(syono1);
            koujyoSymNaiyou20.setSyouhncd(syouhncd1);
            koujyoSymNaiyou20.setRenno3keta(renno3keta19);
            koujyoSymNaiyou20.setKoujyosyoumeipkbn(C_KoujyosyoumeipKbn.KAIGOIRYOU);
            koujyoSymNaiyou20.setKoujyosyoumeigk(BizCurrency.valueOf(246, BizCurrencyTypes.AU_DOLLAR));

            IT_KoujyoSymNaiyou koujyoSymNaiyou21 = kykKihon1.createKoujyoSymNaiyou();
            koujyoSymNaiyou21.setSyono(syono1);
            koujyoSymNaiyou21.setSyouhncd(syouhncd1);
            koujyoSymNaiyou21.setRenno3keta(renno3keta20);
            koujyoSymNaiyou21.setKoujyosyoumeipkbn(C_KoujyosyoumeipKbn.KAIGOIRYOU);
            koujyoSymNaiyou21.setKoujyosyoumeigk(null);

            IT_KoujyoSymNaiyou koujyoSymNaiyou9 = kykKihon1.createKoujyoSymNaiyou();
            koujyoSymNaiyou9.setSyono(syono1);
            koujyoSymNaiyou9.setSyouhncd(syouhncd1);
            koujyoSymNaiyou9.setRenno3keta(renno3keta9);
            koujyoSymNaiyou9.setKoujyosyoumeipkbn(C_KoujyosyoumeipKbn.NENKIN);
            koujyoSymNaiyou9.setKoujyosyoumeigk(BizCurrency.valueOf(4000, BizCurrencyTypes.YEN));

            IT_KoujyoSymNaiyou koujyoSymNaiyou10 = kykKihon1.createKoujyoSymNaiyou();
            koujyoSymNaiyou10.setSyono(syono1);
            koujyoSymNaiyou10.setSyouhncd(syouhncd1);
            koujyoSymNaiyou10.setRenno3keta(renno3keta10);
            koujyoSymNaiyou10.setKoujyosyoumeipkbn(C_KoujyosyoumeipKbn.NENKIN);
            koujyoSymNaiyou10.setKoujyosyoumeigk(BizCurrency.valueOf(4, BizCurrencyTypes.YEN));

            IT_KoujyoSymNaiyou koujyoSymNaiyou11 = kykKihon1.createKoujyoSymNaiyou();
            koujyoSymNaiyou11.setSyono(syono1);
            koujyoSymNaiyou11.setSyouhncd(syouhncd1);
            koujyoSymNaiyou11.setRenno3keta(renno3keta11);
            koujyoSymNaiyou11.setKoujyosyoumeipkbn(C_KoujyosyoumeipKbn.NENKIN);
            koujyoSymNaiyou11.setKoujyosyoumeigk(BizCurrency.valueOf(3000, BizCurrencyTypes.DOLLAR));

            IT_KoujyoSymNaiyou koujyoSymNaiyou12 = kykKihon1.createKoujyoSymNaiyou();
            koujyoSymNaiyou12.setSyono(syono1);
            koujyoSymNaiyou12.setSyouhncd(syouhncd1);
            koujyoSymNaiyou12.setRenno3keta(renno3keta12);
            koujyoSymNaiyou12.setKoujyosyoumeipkbn(C_KoujyosyoumeipKbn.NENKIN);
            koujyoSymNaiyou12.setKoujyosyoumeigk(BizCurrency.valueOf(300, BizCurrencyTypes.DOLLAR));

            IT_KoujyoSymNaiyou koujyoSymNaiyou13 = kykKihon1.createKoujyoSymNaiyou();
            koujyoSymNaiyou13.setSyono(syono1);
            koujyoSymNaiyou13.setSyouhncd(syouhncd1);
            koujyoSymNaiyou13.setRenno3keta(renno3keta13);
            koujyoSymNaiyou13.setKoujyosyoumeipkbn(C_KoujyosyoumeipKbn.NENKIN);
            koujyoSymNaiyou13.setKoujyosyoumeigk(BizCurrency.valueOf(6000, BizCurrencyTypes.MANYEN));

            IT_KoujyoSymNaiyou koujyoSymNaiyou14 = kykKihon1.createKoujyoSymNaiyou();
            koujyoSymNaiyou14.setSyono(syono1);
            koujyoSymNaiyou14.setSyouhncd(syouhncd1);
            koujyoSymNaiyou14.setRenno3keta(renno3keta14);
            koujyoSymNaiyou14.setKoujyosyoumeipkbn(C_KoujyosyoumeipKbn.NENKIN);
            koujyoSymNaiyou14.setKoujyosyoumeigk(BizCurrency.valueOf(666, BizCurrencyTypes.MANYEN));

            IT_KoujyoSymNaiyou koujyoSymNaiyou16 = kykKihon1.createKoujyoSymNaiyou();
            koujyoSymNaiyou16.setSyono(syono1);
            koujyoSymNaiyou16.setSyouhncd(syouhncd1);
            koujyoSymNaiyou16.setRenno3keta(renno3keta15);
            koujyoSymNaiyou16.setKoujyosyoumeipkbn(C_KoujyosyoumeipKbn.NENKIN);
            koujyoSymNaiyou16.setKoujyosyoumeigk(null);

            hozenDomManager.insert(kykKihon1);

            IT_KykKihon kykKihon2 = new IT_KykKihon(kbnkey1, syono2);
            hozenDomManager.insert(kykKihon2);

            IT_KykKihon kykKihon3 = new IT_KykKihon(kbnkey1, syono3);

            IT_KoujyoSymNaiyou koujyoSymNaiyou15 = kykKihon1.createKoujyoSymNaiyou();
            koujyoSymNaiyou15.setSyono(syono3);
            koujyoSymNaiyou15.setSyouhncd(syouhncd1);
            koujyoSymNaiyou15.setRenno3keta(renno3keta14);
            koujyoSymNaiyou15.setKoujyosyoumeipkbn(C_KoujyosyoumeipKbn.NENKIN);
            koujyoSymNaiyou15.setKoujyosyoumeigk(BizCurrency.valueOf(70000, BizCurrencyTypes.MANYEN));

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

        IT_KykKihon kykKihon = hozenDomManager.getKykKihon(syono2);

        List<Object[]> kykSyouhnLst = kykKihon.getKoujyoSymNaiyouKoujyosyoumeipkbnSumKoujyosyoumeigks();

        Assert.assertEquals(0, kykSyouhnLst.size());
    }

    @SuppressWarnings("unchecked")
    @Test
    @TestOrder(20)
    public void normal1() {

        IT_KykKihon kykKihon = hozenDomManager.getKykKihon(syono3);

        List<Object[]> kykSyouhnLst = kykKihon.getKoujyoSymNaiyouKoujyosyoumeipkbnSumKoujyosyoumeigks();

        Assert.assertEquals(1, kykSyouhnLst.size());

        Assert.assertEquals(C_KoujyosyoumeipKbn.NENKIN, kykSyouhnLst.get(0)[0]);
        Map<CurrencyType, BizCurrency> koujyosyoumeigkMap1 = (Map<CurrencyType, BizCurrency>) kykSyouhnLst.get(0)[1];
        Assert.assertEquals(BizCurrency.valueOf(70000, BizCurrencyTypes.MANYEN),
                koujyosyoumeigkMap1.get(BizCurrencyTypes.MANYEN));

    }

    @SuppressWarnings("unchecked")
    @Test
    @TestOrder(30)
    public void normal2() {

        IT_KykKihon kykKihon = hozenDomManager.getKykKihon(syono1);

        List<Object[]> kykSyouhnLst = kykKihon.getKoujyoSymNaiyouKoujyosyoumeipkbnSumKoujyosyoumeigks();

        Assert.assertEquals(3, kykSyouhnLst.size());

        Assert.assertEquals(C_KoujyosyoumeipKbn.NENKIN, kykSyouhnLst.get(0)[0]);
        Map<CurrencyType, BizCurrency> koujyosyoumeigkMap1 = (Map<CurrencyType, BizCurrency>) kykSyouhnLst.get(0)[1];
        Assert.assertEquals(BizCurrency.valueOf(4004), koujyosyoumeigkMap1.get(BizCurrencyTypes.YEN));
        Assert.assertEquals(BizCurrency.valueOf(6666, BizCurrencyTypes.MANYEN),
                koujyosyoumeigkMap1.get(BizCurrencyTypes.MANYEN));
        Assert.assertEquals(BizCurrency.valueOf(3300, BizCurrencyTypes.DOLLAR),
                koujyosyoumeigkMap1.get(BizCurrencyTypes.DOLLAR));

        Assert.assertEquals(C_KoujyosyoumeipKbn.KAIGOIRYOU, kykSyouhnLst.get(1)[0]);
        Map<CurrencyType, BizCurrency> koujyosyoumeigkMap2 = (Map<CurrencyType, BizCurrency>) kykSyouhnLst.get(1)[1];
        Assert.assertEquals(BizCurrency.valueOf(3), koujyosyoumeigkMap2.get(BizCurrencyTypes.YEN));
        Assert.assertEquals(BizCurrency.valueOf(360, BizCurrencyTypes.AU_DOLLAR),
                koujyosyoumeigkMap2.get(BizCurrencyTypes.AU_DOLLAR));
        Assert.assertEquals(BizCurrency.valueOf(8.8, BizCurrencyTypes.DOLLAR),
                koujyosyoumeigkMap2.get(BizCurrencyTypes.DOLLAR));

        Assert.assertEquals(C_KoujyosyoumeipKbn.IPPAN, kykSyouhnLst.get(2)[0]);
        Map<CurrencyType, BizCurrency> koujyosyoumeigkMap3 = (Map<CurrencyType, BizCurrency>) kykSyouhnLst.get(2)[1];
        Assert.assertEquals(BizCurrency.valueOf(210), koujyosyoumeigkMap3.get(BizCurrencyTypes.YEN));
        Assert.assertEquals(BizCurrency.valueOf(9130, BizCurrencyTypes.MANYEN),
                koujyosyoumeigkMap3.get(BizCurrencyTypes.MANYEN));
        Assert.assertEquals(BizCurrency.valueOf(8120, BizCurrencyTypes.EURO),
                koujyosyoumeigkMap3.get(BizCurrencyTypes.EURO));

    }
}
