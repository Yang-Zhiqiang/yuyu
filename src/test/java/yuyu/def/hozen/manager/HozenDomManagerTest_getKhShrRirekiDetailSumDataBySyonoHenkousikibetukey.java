package yuyu.def.hozen.manager;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.number.BizCurrency;
import jp.co.slcs.swak.number.currencytype.BizCurrencyTypes;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.def.db.entity.IT_KhShrRireki;
import yuyu.def.db.entity.IT_KhShrRirekiDetail;
import yuyu.def.db.entity.IT_KhTtdkRireki;
import yuyu.def.db.entity.IT_KykKihon;
import yuyu.def.hozen.result.bean.KhShrRirekiDetailSumDataBySyonoHenkousikibetukeyBean;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * HozenDomManagerクラスの、<br />
 * getKhShrRirekiDetailSumDataBySyonoHenkousikibetukey() メソッドのテストクラスです。
 */
@RunWith(OrderedRunner.class)
public class HozenDomManagerTest_getKhShrRirekiDetailSumDataBySyonoHenkousikibetukey {

    @Inject
    HozenDomManager hozenDomManager;

    @BeforeClass
    @Transactional
    public static void insertTestData() {

        HozenDomManager hozenDomManager = SWAKInjector.getInstance(HozenDomManager.class);


        KhShrRirekiDetailSumDataBySyonoHenkousikibetukeyBean khShrRirekiDetailSumDataBySyonoHenkousikibetukeyBean = hozenDomManager.getKhShrRirekiDetailSumDataBySyonoHenkousikibetukey("11807111118", "20161001");

        Assert.assertEquals(0, khShrRirekiDetailSumDataBySyonoHenkousikibetukeyBean.getSyushrgk().size());
        Assert.assertEquals(0, khShrRirekiDetailSumDataBySyonoHenkousikibetukeyBean.getSjkkktyouseigk().size());
        Assert.assertEquals(0, khShrRirekiDetailSumDataBySyonoHenkousikibetukeyBean.getShrtstmttkinhngkbbn().size());
        Assert.assertEquals(0, khShrRirekiDetailSumDataBySyonoHenkousikibetukeyBean.getShrtstmttkin().size());
        Assert.assertEquals(0, khShrRirekiDetailSumDataBySyonoHenkousikibetukeyBean.getKaiyakukjgk().size());

        IT_KykKihon kykKihon1 = new IT_KykKihon("11", "11807111118");

        IT_KhTtdkRireki khTtdkRireki1 = kykKihon1.createKhTtdkRireki();
        khTtdkRireki1.setHenkousikibetukey("20161001");

        IT_KhShrRireki khShrRireki1 = khTtdkRireki1.createKhShrRireki();

        IT_KhShrRirekiDetail khShrRirekiDetail1 = khShrRireki1.createKhShrRirekiDetail();
        khShrRirekiDetail1.setSyouhncd("1001");
        khShrRirekiDetail1.setSyouhnsdno(1);
        khShrRirekiDetail1.setKyksyouhnrenno(31);
        khShrRirekiDetail1.setSyushrgk(BizCurrency.valueOf(111, BizCurrencyTypes.YEN));
        khShrRirekiDetail1.setShrtstmttkin(BizCurrency.valueOf(11, BizCurrencyTypes.YEN));
        khShrRirekiDetail1.setShrtstmttkinhngkbbn(BizCurrency.valueOf(7, BizCurrencyTypes.YEN));
        khShrRirekiDetail1.setSjkkktyouseigk(BizCurrency.valueOf(6, BizCurrencyTypes.YEN));
        khShrRirekiDetail1.setKaiyakukjgk(BizCurrency.valueOf(5, BizCurrencyTypes.YEN));

        IT_KhTtdkRireki khTtdkRireki2 = kykKihon1.createKhTtdkRireki();
        khTtdkRireki2.setHenkousikibetukey("20161002");

        IT_KhShrRireki khShrRireki2 = khTtdkRireki2.createKhShrRireki();

        IT_KhShrRirekiDetail khShrRirekiDetail2 = khShrRireki2.createKhShrRirekiDetail();
        khShrRirekiDetail2.setSyouhncd("1001");
        khShrRirekiDetail2.setSyouhnsdno(1);
        khShrRirekiDetail2.setKyksyouhnrenno(31);
        khShrRirekiDetail2.setSyushrgk(BizCurrency.valueOf(111, BizCurrencyTypes.YEN));
        khShrRirekiDetail2.setShrtstmttkin(BizCurrency.valueOf(11, BizCurrencyTypes.YEN));
        khShrRirekiDetail2.setShrtstmttkinhngkbbn(BizCurrency.valueOf(7, BizCurrencyTypes.YEN));
        khShrRirekiDetail2.setSjkkktyouseigk(BizCurrency.valueOf(6, BizCurrencyTypes.YEN));
        khShrRirekiDetail2.setKaiyakukjgk(BizCurrency.valueOf(5, BizCurrencyTypes.YEN));

        hozenDomManager.insert(kykKihon1);

        IT_KykKihon kykKihon2 = new IT_KykKihon("11", "11807111129");

        IT_KhTtdkRireki khTtdkRireki3 = kykKihon2.createKhTtdkRireki();
        khTtdkRireki3.setHenkousikibetukey("20161001");

        IT_KhShrRireki khShrRireki3 = khTtdkRireki3.createKhShrRireki();

        IT_KhShrRirekiDetail khShrRirekiDetail3 = khShrRireki3.createKhShrRirekiDetail();
        khShrRirekiDetail3.setSyouhncd("1001");
        khShrRirekiDetail3.setSyouhnsdno(1);
        khShrRirekiDetail3.setKyksyouhnrenno(31);
        khShrRirekiDetail3.setSyushrgk(BizCurrency.valueOf(111, BizCurrencyTypes.YEN));
        khShrRirekiDetail3.setShrtstmttkin(BizCurrency.valueOf(11, BizCurrencyTypes.YEN));
        khShrRirekiDetail3.setShrtstmttkinhngkbbn(BizCurrency.valueOf(7, BizCurrencyTypes.YEN));
        khShrRirekiDetail3.setSjkkktyouseigk(BizCurrency.valueOf(6, BizCurrencyTypes.YEN));
        khShrRirekiDetail3.setKaiyakukjgk(BizCurrency.valueOf(5, BizCurrencyTypes.YEN));

        hozenDomManager.insert(kykKihon2);

        IT_KykKihon kykKihon3 = new IT_KykKihon("12", "11807111118");

        IT_KhTtdkRireki khTtdkRireki4 = kykKihon3.createKhTtdkRireki();
        khTtdkRireki4.setHenkousikibetukey("20161001");

        IT_KhShrRireki khShrRireki4 = khTtdkRireki4.createKhShrRireki();

        IT_KhShrRirekiDetail khShrRirekiDetail4 = khShrRireki4.createKhShrRirekiDetail();
        khShrRirekiDetail4.setSyouhncd("1002");
        khShrRirekiDetail4.setSyouhnsdno(2);
        khShrRirekiDetail4.setKyksyouhnrenno(32);
        khShrRirekiDetail4.setSyushrgk(BizCurrency.valueOf(124, BizCurrencyTypes.YEN));
        khShrRirekiDetail4.setShrtstmttkin(BizCurrency.valueOf(1, BizCurrencyTypes.YEN));
        khShrRirekiDetail4.setShrtstmttkinhngkbbn(BizCurrency.valueOf(1112, BizCurrencyTypes.YEN));
        khShrRirekiDetail4.setSjkkktyouseigk(BizCurrency.valueOf(77, BizCurrencyTypes.YEN));
        khShrRirekiDetail4.setKaiyakukjgk(BizCurrency.valueOf(12, BizCurrencyTypes.YEN));

        hozenDomManager.insert(kykKihon3);

        IT_KykKihon kykKihon4 = new IT_KykKihon("13", "11807111118");

        IT_KhTtdkRireki khTtdkRireki5 = kykKihon4.createKhTtdkRireki();
        khTtdkRireki5.setHenkousikibetukey("20161001");

        IT_KhShrRireki khShrRireki5 = khTtdkRireki5.createKhShrRireki();

        IT_KhShrRirekiDetail khShrRirekiDetail5 = khShrRireki5.createKhShrRirekiDetail();
        khShrRirekiDetail5.setSyouhncd("1003");
        khShrRirekiDetail5.setSyouhnsdno(3);
        khShrRirekiDetail5.setKyksyouhnrenno(33);
        khShrRirekiDetail5.setSyushrgk(BizCurrency.valueOf(521, BizCurrencyTypes.YEN));
        khShrRirekiDetail5.setShrtstmttkin(BizCurrency.valueOf(45, BizCurrencyTypes.YEN));
        khShrRirekiDetail5.setShrtstmttkinhngkbbn(BizCurrency.valueOf(5, BizCurrencyTypes.YEN));
        khShrRirekiDetail5.setSjkkktyouseigk(BizCurrency.valueOf(211, BizCurrencyTypes.YEN));
        khShrRirekiDetail5.setKaiyakukjgk(BizCurrency.valueOf(15, BizCurrencyTypes.YEN));

        hozenDomManager.insert(kykKihon4);

        IT_KykKihon kykKihon5 = new IT_KykKihon("14", "11807111130");

        IT_KhTtdkRireki khTtdkRireki6 = kykKihon5.createKhTtdkRireki();
        khTtdkRireki6.setHenkousikibetukey("20161003");

        IT_KhShrRireki khShrRireki6 = khTtdkRireki6.createKhShrRireki();

        IT_KhShrRirekiDetail khShrRirekiDetail6 = khShrRireki6.createKhShrRirekiDetail();
        khShrRirekiDetail6.setSyouhncd("1004");
        khShrRirekiDetail6.setSyouhnsdno(4);
        khShrRirekiDetail6.setKyksyouhnrenno(34);
        khShrRirekiDetail6.setSyushrgk(BizCurrency.valueOf(200, BizCurrencyTypes.YEN));
        khShrRirekiDetail6.setShrtstmttkin(BizCurrency.valueOf(120, BizCurrencyTypes.YEN));
        khShrRirekiDetail6.setShrtstmttkinhngkbbn(BizCurrency.valueOf(110, BizCurrencyTypes.YEN));
        khShrRirekiDetail6.setSjkkktyouseigk(BizCurrency.valueOf(5, BizCurrencyTypes.YEN));
        khShrRirekiDetail6.setKaiyakukjgk(BizCurrency.valueOf(3, BizCurrencyTypes.YEN));

        hozenDomManager.insert(kykKihon5);

        IT_KykKihon kykKihon6 = new IT_KykKihon("15", "11807111130");

        IT_KhTtdkRireki khTtdkRireki7 = kykKihon6.createKhTtdkRireki();
        khTtdkRireki7.setHenkousikibetukey("20161003");

        IT_KhShrRireki khShrRireki7 = khTtdkRireki7.createKhShrRireki();

        IT_KhShrRirekiDetail khShrRirekiDetail7 = khShrRireki7.createKhShrRirekiDetail();
        khShrRirekiDetail7.setSyouhncd("1005");
        khShrRirekiDetail7.setSyouhnsdno(5);
        khShrRirekiDetail7.setKyksyouhnrenno(35);
        khShrRirekiDetail7.setSyushrgk(BizCurrency.valueOf(1, BizCurrencyTypes.YEN));
        khShrRirekiDetail7.setShrtstmttkin(BizCurrency.valueOf(20, BizCurrencyTypes.YEN));
        khShrRirekiDetail7.setShrtstmttkinhngkbbn(BizCurrency.valueOf(10, BizCurrencyTypes.YEN));
        khShrRirekiDetail7.setSjkkktyouseigk(BizCurrency.valueOf(13, BizCurrencyTypes.YEN));
        khShrRirekiDetail7.setKaiyakukjgk(BizCurrency.valueOf(5, BizCurrencyTypes.YEN));

        hozenDomManager.insert(kykKihon6);

        IT_KykKihon kykKihon7 = new IT_KykKihon("16", "11807111130");

        IT_KhTtdkRireki khTtdkRireki8 = kykKihon7.createKhTtdkRireki();
        khTtdkRireki8.setHenkousikibetukey("20161003");

        IT_KhShrRireki khShrRireki8 = khTtdkRireki8.createKhShrRireki();

        IT_KhShrRirekiDetail khShrRirekiDetail8 = khShrRireki8.createKhShrRirekiDetail();
        khShrRirekiDetail8.setSyouhncd("1006");
        khShrRirekiDetail8.setSyouhnsdno(6);
        khShrRirekiDetail8.setKyksyouhnrenno(36);
        khShrRirekiDetail8.setSyushrgk(BizCurrency.valueOf(2, BizCurrencyTypes.YEN));
        khShrRirekiDetail8.setShrtstmttkin(BizCurrency.valueOf(2, BizCurrencyTypes.YEN));
        khShrRirekiDetail8.setShrtstmttkinhngkbbn(BizCurrency.valueOf(10, BizCurrencyTypes.YEN));
        khShrRirekiDetail8.setSjkkktyouseigk(BizCurrency.valueOf(111, BizCurrencyTypes.YEN));
        khShrRirekiDetail8.setKaiyakukjgk(BizCurrency.valueOf(150, BizCurrencyTypes.YEN));

        hozenDomManager.insert(kykKihon7);

        IT_KykKihon kykKihon8 = new IT_KykKihon("17", "11807111130");

        IT_KhTtdkRireki khTtdkRireki9 = kykKihon8.createKhTtdkRireki();
        khTtdkRireki9.setHenkousikibetukey("20161003");

        IT_KhShrRireki khShrRireki9 = khTtdkRireki9.createKhShrRireki();

        IT_KhShrRirekiDetail khShrRirekiDetail9 = khShrRireki9.createKhShrRirekiDetail();
        khShrRirekiDetail9.setSyouhncd("1007");
        khShrRirekiDetail9.setSyouhnsdno(7);
        khShrRirekiDetail9.setKyksyouhnrenno(37);
        khShrRirekiDetail9.setSyushrgk(BizCurrency.valueOf(0, BizCurrencyTypes.YEN));
        khShrRirekiDetail9.setShrtstmttkin(BizCurrency.valueOf(0, BizCurrencyTypes.YEN));
        khShrRirekiDetail9.setShrtstmttkinhngkbbn(BizCurrency.valueOf(0, BizCurrencyTypes.YEN));
        khShrRirekiDetail9.setSjkkktyouseigk(BizCurrency.valueOf(0, BizCurrencyTypes.YEN));
        khShrRirekiDetail9.setKaiyakukjgk(BizCurrency.valueOf(0, BizCurrencyTypes.YEN));

        hozenDomManager.insert(kykKihon8);

        IT_KykKihon kykKihon9 = new IT_KykKihon("18", "11807111130");

        IT_KhTtdkRireki khTtdkRireki10 = kykKihon9.createKhTtdkRireki();
        khTtdkRireki10.setHenkousikibetukey("20161003");

        IT_KhShrRireki khShrRireki10 = khTtdkRireki10.createKhShrRireki();

        IT_KhShrRirekiDetail khShrRirekiDetail10 = khShrRireki10.createKhShrRirekiDetail();
        khShrRirekiDetail10.setSyouhncd("1008");
        khShrRirekiDetail10.setSyouhnsdno(8);
        khShrRirekiDetail10.setKyksyouhnrenno(38);

        hozenDomManager.insert(kykKihon9);

        IT_KykKihon kykKihon10 = new IT_KykKihon("19", "11807111130");

        IT_KhTtdkRireki khTtdkRireki11 = kykKihon10.createKhTtdkRireki();
        khTtdkRireki11.setHenkousikibetukey("20161003");

        IT_KhShrRireki khShrRireki11 = khTtdkRireki11.createKhShrRireki();

        IT_KhShrRirekiDetail khShrRirekiDetail11 = khShrRireki11.createKhShrRirekiDetail();
        khShrRirekiDetail11.setSyouhncd("1009");
        khShrRirekiDetail11.setSyouhnsdno(9);
        khShrRirekiDetail11.setKyksyouhnrenno(39);
        khShrRirekiDetail11.setSyushrgk(BizCurrency.valueOf(1, BizCurrencyTypes.MANYEN));
        khShrRirekiDetail11.setShrtstmttkin(BizCurrency.valueOf(2, BizCurrencyTypes.MANYEN));
        khShrRirekiDetail11.setShrtstmttkinhngkbbn(BizCurrency.valueOf(6, BizCurrencyTypes.MANYEN));
        khShrRirekiDetail11.setSjkkktyouseigk(BizCurrency.valueOf(3, BizCurrencyTypes.MANYEN));
        khShrRirekiDetail11.setKaiyakukjgk(BizCurrency.valueOf(1, BizCurrencyTypes.MANYEN));

        hozenDomManager.insert(kykKihon10);

        IT_KykKihon kykKihon11 = new IT_KykKihon("20", "11807111130");

        IT_KhTtdkRireki khTtdkRireki12 = kykKihon11.createKhTtdkRireki();
        khTtdkRireki12.setHenkousikibetukey("20161003");

        IT_KhShrRireki khShrRireki12 = khTtdkRireki12.createKhShrRireki();

        IT_KhShrRirekiDetail khShrRirekiDetail12 = khShrRireki12.createKhShrRirekiDetail();
        khShrRirekiDetail12.setSyouhncd("1010");
        khShrRirekiDetail12.setSyouhnsdno(10);
        khShrRirekiDetail12.setKyksyouhnrenno(40);
        khShrRirekiDetail12.setSyushrgk(BizCurrency.valueOf(50, BizCurrencyTypes.MANYEN));
        khShrRirekiDetail12.setShrtstmttkin(BizCurrency.valueOf(3, BizCurrencyTypes.MANYEN));
        khShrRirekiDetail12.setShrtstmttkinhngkbbn(BizCurrency.valueOf(7, BizCurrencyTypes.MANYEN));
        khShrRirekiDetail12.setSjkkktyouseigk(BizCurrency.valueOf(6, BizCurrencyTypes.MANYEN));
        khShrRirekiDetail12.setKaiyakukjgk(BizCurrency.valueOf(5, BizCurrencyTypes.MANYEN));

        hozenDomManager.insert(kykKihon11);

        IT_KykKihon kykKihon12 = new IT_KykKihon("21", "11807111130");

        IT_KhTtdkRireki khTtdkRireki13 = kykKihon12.createKhTtdkRireki();
        khTtdkRireki13.setHenkousikibetukey("20161003");

        IT_KhShrRireki khShrRireki13 = khTtdkRireki13.createKhShrRireki();

        IT_KhShrRirekiDetail khShrRirekiDetail13 = khShrRireki13.createKhShrRirekiDetail();
        khShrRirekiDetail13.setSyouhncd("1011");
        khShrRirekiDetail13.setSyouhnsdno(51);
        khShrRirekiDetail13.setKyksyouhnrenno(41);
        khShrRirekiDetail13.setSyushrgk(BizCurrency.valueOf(45, BizCurrencyTypes.MANYEN));
        khShrRirekiDetail13.setShrtstmttkin(BizCurrency.valueOf(4, BizCurrencyTypes.MANYEN));
        khShrRirekiDetail13.setShrtstmttkinhngkbbn(BizCurrency.valueOf(8, BizCurrencyTypes.MANYEN));
        khShrRirekiDetail13.setSjkkktyouseigk(BizCurrency.valueOf(9, BizCurrencyTypes.MANYEN));
        khShrRirekiDetail13.setKaiyakukjgk(BizCurrency.valueOf(9, BizCurrencyTypes.MANYEN));

        hozenDomManager.insert(kykKihon12);

        IT_KykKihon kykKihon13 = new IT_KykKihon("22", "11807111130");

        IT_KhTtdkRireki khTtdkRireki14 = kykKihon13.createKhTtdkRireki();
        khTtdkRireki14.setHenkousikibetukey("20161003");

        IT_KhShrRireki khShrRireki14 = khTtdkRireki14.createKhShrRireki();

        IT_KhShrRirekiDetail khShrRirekiDetail14 = khShrRireki14.createKhShrRirekiDetail();
        khShrRirekiDetail14.setSyouhncd("1012");
        khShrRirekiDetail14.setSyouhnsdno(52);
        khShrRirekiDetail14.setKyksyouhnrenno(42);
        khShrRirekiDetail14.setSyushrgk(BizCurrency.valueOf(0, BizCurrencyTypes.MANYEN));
        khShrRirekiDetail14.setShrtstmttkin(BizCurrency.valueOf(0, BizCurrencyTypes.MANYEN));
        khShrRirekiDetail14.setShrtstmttkinhngkbbn(BizCurrency.valueOf(0, BizCurrencyTypes.MANYEN));
        khShrRirekiDetail14.setSjkkktyouseigk(BizCurrency.valueOf(0, BizCurrencyTypes.MANYEN));
        khShrRirekiDetail14.setKaiyakukjgk(BizCurrency.valueOf(0, BizCurrencyTypes.MANYEN));

        hozenDomManager.insert(kykKihon13);

        IT_KykKihon kykKihon14 = new IT_KykKihon("23", "11807111130");

        IT_KhTtdkRireki khTtdkRireki15 = kykKihon14.createKhTtdkRireki();
        khTtdkRireki15.setHenkousikibetukey("20161003");

        IT_KhShrRireki khShrRireki15 = khTtdkRireki15.createKhShrRireki();

        IT_KhShrRirekiDetail khShrRirekiDetail15 = khShrRireki15.createKhShrRirekiDetail();
        khShrRirekiDetail15.setSyouhncd("1013");
        khShrRirekiDetail15.setSyouhnsdno(53);
        khShrRirekiDetail15.setKyksyouhnrenno(43);

        hozenDomManager.insert(kykKihon14);

        IT_KykKihon kykKihon15 = new IT_KykKihon("24", "11807111130");

        IT_KhTtdkRireki khTtdkRireki16 = kykKihon15.createKhTtdkRireki();
        khTtdkRireki16.setHenkousikibetukey("20161003");

        IT_KhShrRireki khShrRireki16 = khTtdkRireki16.createKhShrRireki();

        IT_KhShrRirekiDetail khShrRirekiDetail16 = khShrRireki16.createKhShrRirekiDetail();
        khShrRirekiDetail16.setSyouhncd("1014");
        khShrRirekiDetail16.setSyouhnsdno(54);
        khShrRirekiDetail16.setKyksyouhnrenno(44);
        khShrRirekiDetail16.setSyushrgk(BizCurrency.valueOf(11.5, BizCurrencyTypes.DOLLAR));
        khShrRirekiDetail16.setShrtstmttkin(BizCurrency.valueOf(17, BizCurrencyTypes.DOLLAR));
        khShrRirekiDetail16.setShrtstmttkinhngkbbn(BizCurrency.valueOf(5.5, BizCurrencyTypes.DOLLAR));
        khShrRirekiDetail16.setSjkkktyouseigk(BizCurrency.valueOf(4, BizCurrencyTypes.DOLLAR));
        khShrRirekiDetail16.setKaiyakukjgk(BizCurrency.valueOf(9, BizCurrencyTypes.DOLLAR));

        hozenDomManager.insert(kykKihon15);

        IT_KykKihon kykKihon16 = new IT_KykKihon("25", "11807111130");

        IT_KhTtdkRireki khTtdkRireki17 = kykKihon16.createKhTtdkRireki();
        khTtdkRireki17.setHenkousikibetukey("20161003");

        IT_KhShrRireki khShrRireki17 = khTtdkRireki17.createKhShrRireki();

        IT_KhShrRirekiDetail khShrRirekiDetail17 = khShrRireki17.createKhShrRirekiDetail();
        khShrRirekiDetail17.setSyouhncd("1015");
        khShrRirekiDetail17.setSyouhnsdno(55);
        khShrRirekiDetail17.setKyksyouhnrenno(45);
        khShrRirekiDetail17.setSyushrgk(BizCurrency.valueOf(20, BizCurrencyTypes.DOLLAR));
        khShrRirekiDetail17.setShrtstmttkin(BizCurrency.valueOf(2, BizCurrencyTypes.DOLLAR));
        khShrRirekiDetail17.setShrtstmttkinhngkbbn(BizCurrency.valueOf(12, BizCurrencyTypes.DOLLAR));
        khShrRirekiDetail17.setSjkkktyouseigk(BizCurrency.valueOf(2.5, BizCurrencyTypes.DOLLAR));
        khShrRirekiDetail17.setKaiyakukjgk(BizCurrency.valueOf(4, BizCurrencyTypes.DOLLAR));

        hozenDomManager.insert(kykKihon16);

        IT_KykKihon kykKihon17 = new IT_KykKihon("26", "11807111130");

        IT_KhTtdkRireki khTtdkRireki18 = kykKihon17.createKhTtdkRireki();
        khTtdkRireki18.setHenkousikibetukey("20161003");

        IT_KhShrRireki khShrRireki18 = khTtdkRireki18.createKhShrRireki();

        IT_KhShrRirekiDetail khShrRirekiDetail18 = khShrRireki18.createKhShrRirekiDetail();
        khShrRirekiDetail18.setSyouhncd("1016");
        khShrRirekiDetail18.setSyouhnsdno(56);
        khShrRirekiDetail18.setKyksyouhnrenno(46);
        khShrRirekiDetail18.setSyushrgk(BizCurrency.valueOf(16, BizCurrencyTypes.DOLLAR));
        khShrRirekiDetail18.setShrtstmttkin(BizCurrency.valueOf(3.5, BizCurrencyTypes.DOLLAR));
        khShrRirekiDetail18.setShrtstmttkinhngkbbn(BizCurrency.valueOf(4, BizCurrencyTypes.DOLLAR));
        khShrRirekiDetail18.setSjkkktyouseigk(BizCurrency.valueOf(1, BizCurrencyTypes.DOLLAR));
        khShrRirekiDetail18.setKaiyakukjgk(BizCurrency.valueOf(6.5, BizCurrencyTypes.DOLLAR));

        hozenDomManager.insert(kykKihon17);

        IT_KykKihon kykKihon18 = new IT_KykKihon("27", "11807111130");

        IT_KhTtdkRireki khTtdkRireki19 = kykKihon18.createKhTtdkRireki();
        khTtdkRireki19.setHenkousikibetukey("20161003");

        IT_KhShrRireki khShrRireki19 = khTtdkRireki19.createKhShrRireki();

        IT_KhShrRirekiDetail khShrRirekiDetail19 = khShrRireki19.createKhShrRirekiDetail();
        khShrRirekiDetail19.setSyouhncd("1017");
        khShrRirekiDetail19.setSyouhnsdno(57);
        khShrRirekiDetail19.setKyksyouhnrenno(47);
        khShrRirekiDetail19.setSyushrgk(BizCurrency.valueOf(0, BizCurrencyTypes.DOLLAR));
        khShrRirekiDetail19.setShrtstmttkin(BizCurrency.valueOf(0, BizCurrencyTypes.DOLLAR));
        khShrRirekiDetail19.setShrtstmttkinhngkbbn(BizCurrency.valueOf(0, BizCurrencyTypes.DOLLAR));
        khShrRirekiDetail19.setSjkkktyouseigk(BizCurrency.valueOf(0, BizCurrencyTypes.DOLLAR));
        khShrRirekiDetail19.setKaiyakukjgk(BizCurrency.valueOf(0, BizCurrencyTypes.DOLLAR));

        hozenDomManager.insert(kykKihon18);

        IT_KykKihon kykKihon19 = new IT_KykKihon("28", "11807111130");

        IT_KhTtdkRireki khTtdkRireki20 = kykKihon19.createKhTtdkRireki();
        khTtdkRireki20.setHenkousikibetukey("20161003");

        IT_KhShrRireki khShrRireki20 = khTtdkRireki20.createKhShrRireki();

        IT_KhShrRirekiDetail khShrRirekiDetail20 = khShrRireki20.createKhShrRirekiDetail();
        khShrRirekiDetail20.setSyouhncd("1018");
        khShrRirekiDetail20.setSyouhnsdno(58);
        khShrRirekiDetail20.setKyksyouhnrenno(48);

        hozenDomManager.insert(kykKihon19);

    }

    @AfterClass
    @Transactional
    public static void deleteTestData() {

        HozenDomManager hozenDomManager = SWAKInjector.getInstance(HozenDomManager.class);
        hozenDomManager.delete(hozenDomManager.getAllKykKihon());
    }
    @Test
    @TestOrder(10)
    public void noResult1(){

        KhShrRirekiDetailSumDataBySyonoHenkousikibetukeyBean khShrRirekiDetailSumDataBySyonoHenkousikibetukeyBean = hozenDomManager.getKhShrRirekiDetailSumDataBySyonoHenkousikibetukey("11807111129", "20161002");

        Assert.assertEquals(0, khShrRirekiDetailSumDataBySyonoHenkousikibetukeyBean.getSyushrgk().size());
        Assert.assertEquals(0, khShrRirekiDetailSumDataBySyonoHenkousikibetukeyBean.getSjkkktyouseigk().size());
        Assert.assertEquals(0, khShrRirekiDetailSumDataBySyonoHenkousikibetukeyBean.getShrtstmttkinhngkbbn().size());
        Assert.assertEquals(0, khShrRirekiDetailSumDataBySyonoHenkousikibetukeyBean.getShrtstmttkin().size());
        Assert.assertEquals(0, khShrRirekiDetailSumDataBySyonoHenkousikibetukeyBean.getKaiyakukjgk().size());

    }

    @Test
    @TestOrder(20)
    public void normal1(){

        KhShrRirekiDetailSumDataBySyonoHenkousikibetukeyBean khShrRirekiDetailSumDataBySyonoHenkousikibetukeyBean = hozenDomManager.getKhShrRirekiDetailSumDataBySyonoHenkousikibetukey("11807111118", "20161001");

        Assert.assertEquals(1, khShrRirekiDetailSumDataBySyonoHenkousikibetukeyBean.getSyushrgk().size());
        Assert.assertEquals(BizCurrency.valueOf(756), khShrRirekiDetailSumDataBySyonoHenkousikibetukeyBean.getSyushrgk().get(BizCurrencyTypes.YEN));
        Assert.assertEquals(1, khShrRirekiDetailSumDataBySyonoHenkousikibetukeyBean.getShrtstmttkin().size());
        Assert.assertEquals(BizCurrency.valueOf(57), khShrRirekiDetailSumDataBySyonoHenkousikibetukeyBean.getShrtstmttkin().get(BizCurrencyTypes.YEN));
        Assert.assertEquals(1, khShrRirekiDetailSumDataBySyonoHenkousikibetukeyBean.getShrtstmttkinhngkbbn().size());
        Assert.assertEquals(BizCurrency.valueOf(1124), khShrRirekiDetailSumDataBySyonoHenkousikibetukeyBean.getShrtstmttkinhngkbbn().get(BizCurrencyTypes.YEN));
        Assert.assertEquals(1, khShrRirekiDetailSumDataBySyonoHenkousikibetukeyBean.getSjkkktyouseigk().size());
        Assert.assertEquals(BizCurrency.valueOf(294), khShrRirekiDetailSumDataBySyonoHenkousikibetukeyBean.getSjkkktyouseigk().get(BizCurrencyTypes.YEN));
        Assert.assertEquals(1, khShrRirekiDetailSumDataBySyonoHenkousikibetukeyBean.getKaiyakukjgk().size());
        Assert.assertEquals(BizCurrency.valueOf(32), khShrRirekiDetailSumDataBySyonoHenkousikibetukeyBean.getKaiyakukjgk().get(BizCurrencyTypes.YEN));
    }
    @Test
    @TestOrder(30)
    public void normal2(){


        KhShrRirekiDetailSumDataBySyonoHenkousikibetukeyBean khShrRirekiDetailSumDataBySyonoHenkousikibetukeyBean = hozenDomManager.getKhShrRirekiDetailSumDataBySyonoHenkousikibetukey("11807111130", "20161003");

        Assert.assertEquals(3, khShrRirekiDetailSumDataBySyonoHenkousikibetukeyBean.getSyushrgk().size());
        Assert.assertEquals(BizCurrency.valueOf(203), khShrRirekiDetailSumDataBySyonoHenkousikibetukeyBean.getSyushrgk().get(BizCurrencyTypes.YEN));
        Assert.assertEquals(BizCurrency.valueOf(96, BizCurrencyTypes.MANYEN), khShrRirekiDetailSumDataBySyonoHenkousikibetukeyBean.getSyushrgk().get(BizCurrencyTypes.MANYEN));
        Assert.assertEquals(BizCurrency.valueOf(47.5, BizCurrencyTypes.DOLLAR), khShrRirekiDetailSumDataBySyonoHenkousikibetukeyBean.getSyushrgk().get(BizCurrencyTypes.DOLLAR));
        Assert.assertEquals(3, khShrRirekiDetailSumDataBySyonoHenkousikibetukeyBean.getShrtstmttkin().size());
        Assert.assertEquals(BizCurrency.valueOf(142), khShrRirekiDetailSumDataBySyonoHenkousikibetukeyBean.getShrtstmttkin().get(BizCurrencyTypes.YEN));
        Assert.assertEquals(BizCurrency.valueOf(9, BizCurrencyTypes.MANYEN), khShrRirekiDetailSumDataBySyonoHenkousikibetukeyBean.getShrtstmttkin().get(BizCurrencyTypes.MANYEN));
        Assert.assertEquals(BizCurrency.valueOf(22.5, BizCurrencyTypes.DOLLAR), khShrRirekiDetailSumDataBySyonoHenkousikibetukeyBean.getShrtstmttkin().get(BizCurrencyTypes.DOLLAR));
        Assert.assertEquals(3, khShrRirekiDetailSumDataBySyonoHenkousikibetukeyBean.getShrtstmttkinhngkbbn().size());
        Assert.assertEquals(BizCurrency.valueOf(130), khShrRirekiDetailSumDataBySyonoHenkousikibetukeyBean.getShrtstmttkinhngkbbn().get(BizCurrencyTypes.YEN));
        Assert.assertEquals(BizCurrency.valueOf(21, BizCurrencyTypes.MANYEN), khShrRirekiDetailSumDataBySyonoHenkousikibetukeyBean.getShrtstmttkinhngkbbn().get(BizCurrencyTypes.MANYEN));
        Assert.assertEquals(BizCurrency.valueOf(21.5, BizCurrencyTypes.DOLLAR), khShrRirekiDetailSumDataBySyonoHenkousikibetukeyBean.getShrtstmttkinhngkbbn().get(BizCurrencyTypes.DOLLAR));
        Assert.assertEquals(3, khShrRirekiDetailSumDataBySyonoHenkousikibetukeyBean.getSjkkktyouseigk().size());
        Assert.assertEquals(BizCurrency.valueOf(129), khShrRirekiDetailSumDataBySyonoHenkousikibetukeyBean.getSjkkktyouseigk().get(BizCurrencyTypes.YEN));
        Assert.assertEquals(BizCurrency.valueOf(18, BizCurrencyTypes.MANYEN), khShrRirekiDetailSumDataBySyonoHenkousikibetukeyBean.getSjkkktyouseigk().get(BizCurrencyTypes.MANYEN));
        Assert.assertEquals(BizCurrency.valueOf(7.5, BizCurrencyTypes.DOLLAR), khShrRirekiDetailSumDataBySyonoHenkousikibetukeyBean.getSjkkktyouseigk().get(BizCurrencyTypes.DOLLAR));
        Assert.assertEquals(3, khShrRirekiDetailSumDataBySyonoHenkousikibetukeyBean.getKaiyakukjgk().size());
        Assert.assertEquals(BizCurrency.valueOf(158), khShrRirekiDetailSumDataBySyonoHenkousikibetukeyBean.getKaiyakukjgk().get(BizCurrencyTypes.YEN));
        Assert.assertEquals(BizCurrency.valueOf(15, BizCurrencyTypes.MANYEN), khShrRirekiDetailSumDataBySyonoHenkousikibetukeyBean.getKaiyakukjgk().get(BizCurrencyTypes.MANYEN));
        Assert.assertEquals(BizCurrency.valueOf(19.5, BizCurrencyTypes.DOLLAR), khShrRirekiDetailSumDataBySyonoHenkousikibetukeyBean.getKaiyakukjgk().get(BizCurrencyTypes.DOLLAR));
    }
    @Test
    @TestOrder(40)
    public void blankCondition1() {

        KhShrRirekiDetailSumDataBySyonoHenkousikibetukeyBean khShrRirekiDetailSumDataBySyonoHenkousikibetukeyBean = hozenDomManager.getKhShrRirekiDetailSumDataBySyonoHenkousikibetukey("", "20161001");

        Assert.assertEquals(0, khShrRirekiDetailSumDataBySyonoHenkousikibetukeyBean.getSyushrgk().size());
        Assert.assertEquals(0, khShrRirekiDetailSumDataBySyonoHenkousikibetukeyBean.getSjkkktyouseigk().size());
        Assert.assertEquals(0, khShrRirekiDetailSumDataBySyonoHenkousikibetukeyBean.getShrtstmttkinhngkbbn().size());
        Assert.assertEquals(0, khShrRirekiDetailSumDataBySyonoHenkousikibetukeyBean.getShrtstmttkin().size());
        Assert.assertEquals(0, khShrRirekiDetailSumDataBySyonoHenkousikibetukeyBean.getKaiyakukjgk().size());

    }
    @Test
    @TestOrder(50)
    public void blankCondition2() {

        KhShrRirekiDetailSumDataBySyonoHenkousikibetukeyBean khShrRirekiDetailSumDataBySyonoHenkousikibetukeyBean = hozenDomManager.getKhShrRirekiDetailSumDataBySyonoHenkousikibetukey("11807111118", "");

        Assert.assertEquals(0, khShrRirekiDetailSumDataBySyonoHenkousikibetukeyBean.getSyushrgk().size());
        Assert.assertEquals(0, khShrRirekiDetailSumDataBySyonoHenkousikibetukeyBean.getSjkkktyouseigk().size());
        Assert.assertEquals(0, khShrRirekiDetailSumDataBySyonoHenkousikibetukeyBean.getShrtstmttkinhngkbbn().size());
        Assert.assertEquals(0, khShrRirekiDetailSumDataBySyonoHenkousikibetukeyBean.getShrtstmttkin().size());
        Assert.assertEquals(0, khShrRirekiDetailSumDataBySyonoHenkousikibetukeyBean.getKaiyakukjgk().size());

    }
}


