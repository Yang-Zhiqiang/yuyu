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

import yuyu.def.biz.manager.BizDomManager;
import yuyu.def.classification.C_KoujyosyoumeipKbn;
import yuyu.def.classification.C_SyutkKbn;
import yuyu.def.hozen.manager.HozenDomManager;
import yuyu.testinfr.TestOrder;

/**
 * 契約商品テーブルのテストクラス<br />
 */
@RunWith(SWAKTestRunner.class)
public class IT_KykKihonTest_getKoujyosyoumeipkbnKykSyouhnSumHokenryouSyouhnTokujouSumTkjyps {

    @Inject
    private HozenDomManager hozenDomManager;
    BizDomManager bizDomManager;

    @BeforeClass
    @Transactional
    public static void insertTestData() {
        HozenDomManager hozenDomManager = SWAKInjector.getInstance(HozenDomManager.class);
        BizDomManager bizDomManager = SWAKInjector.getInstance(BizDomManager.class);

        IT_KykKihon kykKihon1 = hozenDomManager.getKykKihon("11807111118");

        if (kykKihon1 == null) {

            kykKihon1 = new IT_KykKihon("01", "11807111118");

            List<Object[]> kykSyouhnLst = kykKihon1.getKoujyosyoumeipkbnKykSyouhnSumHokenryouSyouhnTokujouSumTkjyps();

            Assert.assertEquals(0, kykSyouhnLst.size());

            IT_KykSyouhn kykSyouhn1 = kykKihon1.createKykSyouhn();
            kykSyouhn1.setSyutkkbn(C_SyutkKbn.valueOf("1"));
            kykSyouhn1.setSyouhncd("1001");
            kykSyouhn1.setSyouhnsdno(11);
            kykSyouhn1.setKyksyouhnrenno(21);
            kykSyouhn1.setHokenryou(BizCurrency.valueOf(1.5, BizCurrencyTypes.DOLLAR));

            IT_KykSyouhn kykSyouhn4 = kykKihon1.createKykSyouhn();
            kykSyouhn4.setSyutkkbn(C_SyutkKbn.valueOf("1"));
            kykSyouhn4.setSyouhncd("1001");
            kykSyouhn4.setSyouhnsdno(14);
            kykSyouhn4.setKyksyouhnrenno(23);
            kykSyouhn4.setHokenryou(BizCurrency.valueOf(2.5, BizCurrencyTypes.DOLLAR));

            IT_KykSyouhn kykSyouhn5 = kykKihon1.createKykSyouhn();
            kykSyouhn5.setSyutkkbn(C_SyutkKbn.valueOf("1"));
            kykSyouhn5.setSyouhncd("1001");
            kykSyouhn5.setSyouhnsdno(11);
            kykSyouhn5.setKyksyouhnrenno(24);
            kykSyouhn5.setHokenryou(BizCurrency.valueOf(110, BizCurrencyTypes.YEN));

            IT_KykSyouhn kykSyouhn6 = kykKihon1.createKykSyouhn();
            kykSyouhn6.setSyutkkbn(C_SyutkKbn.valueOf("1"));
            kykSyouhn6.setSyouhncd("1001");
            kykSyouhn6.setSyouhnsdno(14);
            kykSyouhn6.setKyksyouhnrenno(25);
            kykSyouhn6.setHokenryou(BizCurrency.valueOf(100, BizCurrencyTypes.YEN));

            IT_KykSyouhn kykSyouhn7 = kykKihon1.createKykSyouhn();
            kykSyouhn7.setSyutkkbn(C_SyutkKbn.valueOf("1"));
            kykSyouhn7.setSyouhncd("1001");
            kykSyouhn7.setSyouhnsdno(11);
            kykSyouhn7.setKyksyouhnrenno(26);
            kykSyouhn7.setHokenryou(BizCurrency.valueOf(25, BizCurrencyTypes.MANYEN));

            IT_KykSyouhn kykSyouhn8 = kykKihon1.createKykSyouhn();
            kykSyouhn8.setSyutkkbn(C_SyutkKbn.valueOf("1"));
            kykSyouhn8.setSyouhncd("1001");
            kykSyouhn8.setSyouhnsdno(14);
            kykSyouhn8.setKyksyouhnrenno(27);
            kykSyouhn8.setHokenryou(BizCurrency.valueOf(15, BizCurrencyTypes.MANYEN));

            IT_KykSyouhn kykSyouhn9 = kykKihon1.createKykSyouhn();
            kykSyouhn9.setSyutkkbn(C_SyutkKbn.valueOf("1"));
            kykSyouhn9.setSyouhncd("1001");
            kykSyouhn9.setSyouhnsdno(11);
            kykSyouhn9.setKyksyouhnrenno(28);

            IT_KykSyouhn kykSyouhn10 = kykKihon1.createKykSyouhn();
            kykSyouhn10.setSyutkkbn(C_SyutkKbn.valueOf("1"));
            kykSyouhn10.setSyouhncd("1001");
            kykSyouhn10.setSyouhnsdno(15);
            kykSyouhn10.setKyksyouhnrenno(29);
            kykSyouhn10.setHokenryou(BizCurrency.valueOf(102, BizCurrencyTypes.YEN));

            IT_KykSyouhn kykSyouhn11 = kykKihon1.createKykSyouhn();
            kykSyouhn11.setSyutkkbn(C_SyutkKbn.valueOf("1"));
            kykSyouhn11.setSyouhncd("1001");
            kykSyouhn11.setSyouhnsdno(17);
            kykSyouhn11.setKyksyouhnrenno(30);
            kykSyouhn11.setHokenryou(BizCurrency.valueOf(201, BizCurrencyTypes.YEN));

            IT_KykSyouhn kykSyouhn12 = kykKihon1.createKykSyouhn();
            kykSyouhn12.setSyutkkbn(C_SyutkKbn.valueOf("1"));
            kykSyouhn12.setSyouhncd("1001");
            kykSyouhn12.setSyouhnsdno(15);
            kykSyouhn12.setKyksyouhnrenno(31);
            kykSyouhn12.setHokenryou(BizCurrency.valueOf(11, BizCurrencyTypes.MANYEN));

            IT_KykSyouhn kykSyouhn13 = kykKihon1.createKykSyouhn();
            kykSyouhn13.setSyutkkbn(C_SyutkKbn.valueOf("1"));
            kykSyouhn13.setSyouhncd("1001");
            kykSyouhn13.setSyouhnsdno(17);
            kykSyouhn13.setKyksyouhnrenno(32);
            kykSyouhn13.setHokenryou(BizCurrency.valueOf(11, BizCurrencyTypes.MANYEN));

            IT_KykSyouhn kykSyouhn14 = kykKihon1.createKykSyouhn();
            kykSyouhn14.setSyutkkbn(C_SyutkKbn.valueOf("1"));
            kykSyouhn14.setSyouhncd("1001");
            kykSyouhn14.setSyouhnsdno(15);
            kykSyouhn14.setKyksyouhnrenno(33);
            kykSyouhn14.setHokenryou(BizCurrency.valueOf(55, BizCurrencyTypes.AU_DOLLAR));

            IT_KykSyouhn kykSyouhn15 = kykKihon1.createKykSyouhn();
            kykSyouhn15.setSyutkkbn(C_SyutkKbn.valueOf("1"));
            kykSyouhn15.setSyouhncd("1001");
            kykSyouhn15.setSyouhnsdno(17);
            kykSyouhn15.setKyksyouhnrenno(34);
            kykSyouhn15.setHokenryou(BizCurrency.valueOf(10, BizCurrencyTypes.AU_DOLLAR));

            IT_KykSyouhn kykSyouhn16 = kykKihon1.createKykSyouhn();
            kykSyouhn16.setSyutkkbn(C_SyutkKbn.valueOf("1"));
            kykSyouhn16.setSyouhncd("1001");
            kykSyouhn16.setSyouhnsdno(15);
            kykSyouhn16.setKyksyouhnrenno(35);

            IT_KykSyouhn kykSyouhn17 = kykKihon1.createKykSyouhn();
            kykSyouhn17.setSyutkkbn(C_SyutkKbn.valueOf("1"));
            kykSyouhn17.setSyouhncd("1001");
            kykSyouhn17.setSyouhnsdno(16);
            kykSyouhn17.setKyksyouhnrenno(36);
            kykSyouhn17.setHokenryou(BizCurrency.valueOf(111, BizCurrencyTypes.YEN));

            IT_KykSyouhn kykSyouhn18 = kykKihon1.createKykSyouhn();
            kykSyouhn18.setSyutkkbn(C_SyutkKbn.valueOf("1"));
            kykSyouhn18.setSyouhncd("1001");
            kykSyouhn18.setSyouhnsdno(18);
            kykSyouhn18.setKyksyouhnrenno(37);
            kykSyouhn18.setHokenryou(BizCurrency.valueOf(222, BizCurrencyTypes.YEN));

            IT_KykSyouhn kykSyouhn19 = kykKihon1.createKykSyouhn();
            kykSyouhn19.setSyutkkbn(C_SyutkKbn.valueOf("1"));
            kykSyouhn19.setSyouhncd("1001");
            kykSyouhn19.setSyouhnsdno(16);
            kykSyouhn19.setKyksyouhnrenno(38);
            kykSyouhn19.setHokenryou(BizCurrency.valueOf(2, BizCurrencyTypes.DOLLAR));

            IT_KykSyouhn kykSyouhn20 = kykKihon1.createKykSyouhn();
            kykSyouhn20.setSyutkkbn(C_SyutkKbn.valueOf("1"));
            kykSyouhn20.setSyouhncd("1001");
            kykSyouhn20.setSyouhnsdno(18);
            kykSyouhn20.setKyksyouhnrenno(39);
            kykSyouhn20.setHokenryou(BizCurrency.valueOf(12, BizCurrencyTypes.DOLLAR));

            IT_KykSyouhn kykSyouhn21 = kykKihon1.createKykSyouhn();
            kykSyouhn21.setSyutkkbn(C_SyutkKbn.valueOf("1"));
            kykSyouhn21.setSyouhncd("1001");
            kykSyouhn21.setSyouhnsdno(16);
            kykSyouhn21.setKyksyouhnrenno(40);
            kykSyouhn21.setHokenryou(BizCurrency.valueOf(5, BizCurrencyTypes.EURO));

            IT_KykSyouhn kykSyouhn22 = kykKihon1.createKykSyouhn();
            kykSyouhn22.setSyutkkbn(C_SyutkKbn.valueOf("1"));
            kykSyouhn22.setSyouhncd("1001");
            kykSyouhn22.setSyouhnsdno(18);
            kykSyouhn22.setKyksyouhnrenno(41);
            kykSyouhn22.setHokenryou(BizCurrency.valueOf(10, BizCurrencyTypes.EURO));

            IT_KykSyouhn kykSyouhn23 = kykKihon1.createKykSyouhn();
            kykSyouhn23.setSyutkkbn(C_SyutkKbn.valueOf("1"));
            kykSyouhn23.setSyouhncd("1001");
            kykSyouhn23.setSyouhnsdno(16);
            kykSyouhn23.setKyksyouhnrenno(42);

            IT_SyouhnTokujou syouhnTokujou1 = kykKihon1.createSyouhnTokujou();
            syouhnTokujou1.setSyutkkbn(C_SyutkKbn.valueOf("1"));
            syouhnTokujou1.setSyouhncd("1001");
            syouhnTokujou1.setSyouhnsdno(11);
            syouhnTokujou1.setKyksyouhnrenno(21);
            syouhnTokujou1.setTkjyp(BizCurrency.valueOf(100, BizCurrencyTypes.YEN));

            IT_SyouhnTokujou syouhnTokujou3 = kykKihon1.createSyouhnTokujou();
            syouhnTokujou3.setSyutkkbn(C_SyutkKbn.valueOf("1"));
            syouhnTokujou3.setSyouhncd("1001");
            syouhnTokujou3.setSyouhnsdno(14);
            syouhnTokujou3.setKyksyouhnrenno(23);
            syouhnTokujou3.setTkjyp(BizCurrency.valueOf(120, BizCurrencyTypes.YEN));

            IT_SyouhnTokujou syouhnTokujou4 = kykKihon1.createSyouhnTokujou();
            syouhnTokujou4.setSyutkkbn(C_SyutkKbn.valueOf("1"));
            syouhnTokujou4.setSyouhncd("1001");
            syouhnTokujou4.setSyouhnsdno(11);
            syouhnTokujou4.setKyksyouhnrenno(24);
            syouhnTokujou4.setTkjyp(BizCurrency.valueOf(22, BizCurrencyTypes.MANYEN));

            IT_SyouhnTokujou syouhnTokujou5 = kykKihon1.createSyouhnTokujou();
            syouhnTokujou5.setSyutkkbn(C_SyutkKbn.valueOf("1"));
            syouhnTokujou5.setSyouhncd("1001");
            syouhnTokujou5.setSyouhnsdno(14);
            syouhnTokujou5.setKyksyouhnrenno(25);
            syouhnTokujou5.setTkjyp(BizCurrency.valueOf(45, BizCurrencyTypes.MANYEN));

            IT_SyouhnTokujou syouhnTokujou6 = kykKihon1.createSyouhnTokujou();
            syouhnTokujou6.setSyutkkbn(C_SyutkKbn.valueOf("1"));
            syouhnTokujou6.setSyouhncd("1001");
            syouhnTokujou6.setSyouhnsdno(11);
            syouhnTokujou6.setKyksyouhnrenno(26);
            syouhnTokujou6.setTkjyp(BizCurrency.valueOf(1.5, BizCurrencyTypes.DOLLAR));

            IT_SyouhnTokujou syouhnTokujou7 = kykKihon1.createSyouhnTokujou();
            syouhnTokujou7.setSyutkkbn(C_SyutkKbn.valueOf("1"));
            syouhnTokujou7.setSyouhncd("1001");
            syouhnTokujou7.setSyouhnsdno(14);
            syouhnTokujou7.setKyksyouhnrenno(27);
            syouhnTokujou7.setTkjyp(BizCurrency.valueOf(10.5, BizCurrencyTypes.DOLLAR));

            IT_SyouhnTokujou syouhnTokujou8 = kykKihon1.createSyouhnTokujou();
            syouhnTokujou8.setSyutkkbn(C_SyutkKbn.valueOf("1"));
            syouhnTokujou8.setSyouhncd("1001");
            syouhnTokujou8.setSyouhnsdno(11);
            syouhnTokujou8.setKyksyouhnrenno(28);

            IT_SyouhnTokujou syouhnTokujou9 = kykKihon1.createSyouhnTokujou();
            syouhnTokujou9.setSyutkkbn(C_SyutkKbn.valueOf("1"));
            syouhnTokujou9.setSyouhncd("1001");
            syouhnTokujou9.setSyouhnsdno(15);
            syouhnTokujou9.setKyksyouhnrenno(29);
            syouhnTokujou9.setTkjyp(BizCurrency.valueOf(102, BizCurrencyTypes.YEN));

            IT_SyouhnTokujou syouhnTokujou10 = kykKihon1.createSyouhnTokujou();
            syouhnTokujou10.setSyutkkbn(C_SyutkKbn.valueOf("1"));
            syouhnTokujou10.setSyouhncd("1001");
            syouhnTokujou10.setSyouhnsdno(17);
            syouhnTokujou10.setKyksyouhnrenno(30);
            syouhnTokujou10.setTkjyp(BizCurrency.valueOf(201, BizCurrencyTypes.YEN));

            IT_SyouhnTokujou syouhnTokujou11 = kykKihon1.createSyouhnTokujou();
            syouhnTokujou11.setSyutkkbn(C_SyutkKbn.valueOf("1"));
            syouhnTokujou11.setSyouhncd("1001");
            syouhnTokujou11.setSyouhnsdno(15);
            syouhnTokujou11.setKyksyouhnrenno(31);
            syouhnTokujou11.setTkjyp(BizCurrency.valueOf(11, BizCurrencyTypes.MANYEN));

            IT_SyouhnTokujou syouhnTokujou12 = kykKihon1.createSyouhnTokujou();
            syouhnTokujou12.setSyutkkbn(C_SyutkKbn.valueOf("1"));
            syouhnTokujou12.setSyouhncd("1001");
            syouhnTokujou12.setSyouhnsdno(17);
            syouhnTokujou12.setKyksyouhnrenno(32);
            syouhnTokujou12.setTkjyp(BizCurrency.valueOf(11, BizCurrencyTypes.MANYEN));

            IT_SyouhnTokujou syouhnTokujou13 = kykKihon1.createSyouhnTokujou();
            syouhnTokujou13.setSyutkkbn(C_SyutkKbn.valueOf("1"));
            syouhnTokujou13.setSyouhncd("1001");
            syouhnTokujou13.setSyouhnsdno(15);
            syouhnTokujou13.setKyksyouhnrenno(33);
            syouhnTokujou13.setTkjyp(BizCurrency.valueOf(55, BizCurrencyTypes.AU_DOLLAR));

            IT_SyouhnTokujou syouhnTokujou14 = kykKihon1.createSyouhnTokujou();
            syouhnTokujou14.setSyutkkbn(C_SyutkKbn.valueOf("1"));
            syouhnTokujou14.setSyouhncd("1001");
            syouhnTokujou14.setSyouhnsdno(17);
            syouhnTokujou14.setKyksyouhnrenno(34);
            syouhnTokujou14.setTkjyp(BizCurrency.valueOf(10, BizCurrencyTypes.AU_DOLLAR));

            IT_SyouhnTokujou syouhnTokujou15 = kykKihon1.createSyouhnTokujou();
            syouhnTokujou15.setSyutkkbn(C_SyutkKbn.valueOf("1"));
            syouhnTokujou15.setSyouhncd("1001");
            syouhnTokujou15.setSyouhnsdno(15);
            syouhnTokujou15.setKyksyouhnrenno(35);

            IT_SyouhnTokujou syouhnTokujou16 = kykKihon1.createSyouhnTokujou();
            syouhnTokujou16.setSyutkkbn(C_SyutkKbn.valueOf("1"));
            syouhnTokujou16.setSyouhncd("1001");
            syouhnTokujou16.setSyouhnsdno(16);
            syouhnTokujou16.setKyksyouhnrenno(36);
            syouhnTokujou16.setTkjyp(BizCurrency.valueOf(111, BizCurrencyTypes.YEN));

            IT_SyouhnTokujou syouhnTokujou17 = kykKihon1.createSyouhnTokujou();
            syouhnTokujou17.setSyutkkbn(C_SyutkKbn.valueOf("1"));
            syouhnTokujou17.setSyouhncd("1001");
            syouhnTokujou17.setSyouhnsdno(18);
            syouhnTokujou17.setKyksyouhnrenno(37);
            syouhnTokujou17.setTkjyp(BizCurrency.valueOf(222, BizCurrencyTypes.YEN));

            IT_SyouhnTokujou syouhnTokujou18 = kykKihon1.createSyouhnTokujou();
            syouhnTokujou18.setSyutkkbn(C_SyutkKbn.valueOf("1"));
            syouhnTokujou18.setSyouhncd("1001");
            syouhnTokujou18.setSyouhnsdno(16);
            syouhnTokujou18.setKyksyouhnrenno(38);
            syouhnTokujou18.setTkjyp(BizCurrency.valueOf(2, BizCurrencyTypes.DOLLAR));

            IT_SyouhnTokujou syouhnTokujou19 = kykKihon1.createSyouhnTokujou();
            syouhnTokujou19.setSyutkkbn(C_SyutkKbn.valueOf("1"));
            syouhnTokujou19.setSyouhncd("1001");
            syouhnTokujou19.setSyouhnsdno(18);
            syouhnTokujou19.setKyksyouhnrenno(39);
            syouhnTokujou19.setTkjyp(BizCurrency.valueOf(12, BizCurrencyTypes.DOLLAR));

            IT_SyouhnTokujou syouhnTokujou20 = kykKihon1.createSyouhnTokujou();
            syouhnTokujou20.setSyutkkbn(C_SyutkKbn.valueOf("1"));
            syouhnTokujou20.setSyouhncd("1001");
            syouhnTokujou20.setSyouhnsdno(16);
            syouhnTokujou20.setKyksyouhnrenno(40);
            syouhnTokujou20.setTkjyp(BizCurrency.valueOf(5, BizCurrencyTypes.EURO));

            IT_SyouhnTokujou syouhnTokujou21 = kykKihon1.createSyouhnTokujou();
            syouhnTokujou21.setSyutkkbn(C_SyutkKbn.valueOf("1"));
            syouhnTokujou21.setSyouhncd("1001");
            syouhnTokujou21.setSyouhnsdno(18);
            syouhnTokujou21.setKyksyouhnrenno(41);
            syouhnTokujou21.setTkjyp(BizCurrency.valueOf(10, BizCurrencyTypes.EURO));

            IT_SyouhnTokujou syouhnTokujou22 = kykKihon1.createSyouhnTokujou();
            syouhnTokujou22.setSyutkkbn(C_SyutkKbn.valueOf("1"));
            syouhnTokujou22.setSyouhncd("1001");
            syouhnTokujou22.setSyouhnsdno(16);
            syouhnTokujou22.setKyksyouhnrenno(42);

            hozenDomManager.insert(kykKihon1);

        }

        IT_KykKihon kykKihon2 = new IT_KykKihon("02", "11807111129");

        IT_KykSyouhn kykSyouhn2 = kykKihon2.createKykSyouhn();
        kykSyouhn2.setSyutkkbn(C_SyutkKbn.valueOf("1"));
        kykSyouhn2.setSyouhncd("1002");
        kykSyouhn2.setSyouhnsdno(12);
        kykSyouhn2.setKyksyouhnrenno(22);
        kykSyouhn2.setHokenryou(BizCurrency.valueOf(900, BizCurrencyTypes.YEN));

        IT_SyouhnTokujou syouhnTokujou2 = kykKihon2.createSyouhnTokujou();
        syouhnTokujou2.setSyutkkbn(C_SyutkKbn.valueOf("1"));
        syouhnTokujou2.setSyouhncd("1002");
        syouhnTokujou2.setSyouhnsdno(12);
        syouhnTokujou2.setKyksyouhnrenno(22);
        syouhnTokujou2.setTkjyp(BizCurrency.valueOf(800, BizCurrencyTypes.YEN));

        hozenDomManager.insert(kykKihon2);

        IT_KykKihon kykKihon3 = new IT_KykKihon("03", "11807111130");

        IT_KykSyouhn kykSyouhn3 = kykKihon3.createKykSyouhn();
        kykSyouhn3.setSyutkkbn(C_SyutkKbn.valueOf("1"));
        kykSyouhn3.setSyouhncd("1002");
        kykSyouhn3.setSyouhnsdno(12);
        kykSyouhn3.setKyksyouhnrenno(22);
        kykSyouhn3.setHokenryou(BizCurrency.valueOf(900, BizCurrencyTypes.YEN));

        hozenDomManager.insert(kykKihon3);

        IT_KykKihon kykKihon4 = new IT_KykKihon("04", "11807111141");

        hozenDomManager.insert(kykKihon4);

        BM_SyouhnZokusei syouhnZokusei1 = new BM_SyouhnZokusei("1001", 11);
        syouhnZokusei1.setKoujyosyoumeipkbn(C_KoujyosyoumeipKbn.valueOf("1"));

        bizDomManager.insert(syouhnZokusei1);

        BM_SyouhnZokusei syouhnZokusei2 = new BM_SyouhnZokusei("1002", 12);
        syouhnZokusei2.setKoujyosyoumeipkbn(C_KoujyosyoumeipKbn.valueOf("3"));

        bizDomManager.insert(syouhnZokusei2);

        BM_SyouhnZokusei syouhnZokusei3 = new BM_SyouhnZokusei("1003", 11);
        syouhnZokusei3.setKoujyosyoumeipkbn(C_KoujyosyoumeipKbn.valueOf("3"));

        bizDomManager.insert(syouhnZokusei3);

        BM_SyouhnZokusei syouhnZokusei4 = new BM_SyouhnZokusei("1001", 13);
        syouhnZokusei4.setKoujyosyoumeipkbn(C_KoujyosyoumeipKbn.valueOf("3"));

        bizDomManager.insert(syouhnZokusei4);

        BM_SyouhnZokusei syouhnZokusei5 = new BM_SyouhnZokusei("1001", 15);
        syouhnZokusei5.setKoujyosyoumeipkbn(C_KoujyosyoumeipKbn.valueOf("2"));

        bizDomManager.insert(syouhnZokusei5);

        BM_SyouhnZokusei syouhnZokusei6 = new BM_SyouhnZokusei("1001", 16);
        syouhnZokusei6.setKoujyosyoumeipkbn(C_KoujyosyoumeipKbn.valueOf("3"));

        bizDomManager.insert(syouhnZokusei6);

        BM_SyouhnZokusei syouhnZokusei7 = new BM_SyouhnZokusei("1001", 14);
        syouhnZokusei7.setKoujyosyoumeipkbn(C_KoujyosyoumeipKbn.valueOf("1"));

        bizDomManager.insert(syouhnZokusei7);

        BM_SyouhnZokusei syouhnZokusei8 = new BM_SyouhnZokusei("1001", 17);
        syouhnZokusei8.setKoujyosyoumeipkbn(C_KoujyosyoumeipKbn.valueOf("2"));

        bizDomManager.insert(syouhnZokusei8);

        BM_SyouhnZokusei syouhnZokusei9 = new BM_SyouhnZokusei("1001", 18);
        syouhnZokusei9.setKoujyosyoumeipkbn(C_KoujyosyoumeipKbn.valueOf("3"));

        bizDomManager.insert(syouhnZokusei9);
    }

    @AfterClass
    @Transactional
    public static void deleteTestData() {
        HozenDomManager hozenDomManager = SWAKInjector.getInstance(HozenDomManager.class);
        hozenDomManager.delete(hozenDomManager.getAllKykKihon());
        BizDomManager bizDomManager = SWAKInjector.getInstance(BizDomManager.class);
        bizDomManager.delete(bizDomManager.getAllSyouhnZokusei());
    }


    @Test
    @TestOrder(30)
    public void noResult1() {

        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("11807111141");

        List<Object[]> kykSyouhnLst = kykKihon.getKoujyosyoumeipkbnKykSyouhnSumHokenryouSyouhnTokujouSumTkjyps();

        Assert.assertEquals(0, kykSyouhnLst.size());
    }

    @Test
    @TestOrder(40)
    public void normal1() {

        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("11807111129");

        List<Object[]> kykSyouhnLst = kykKihon.getKoujyosyoumeipkbnKykSyouhnSumHokenryouSyouhnTokujouSumTkjyps();

        Assert.assertEquals(1, kykSyouhnLst.size());

        Assert.assertEquals(C_KoujyosyoumeipKbn.NENKIN, kykSyouhnLst.get(0)[0]);

        Map<CurrencyType, BizCurrency> mapKykSyouhnSumHokenryou1 = (Map<CurrencyType, BizCurrency>) kykSyouhnLst.get(0)[1];
        Assert.assertEquals(BizCurrency.valueOf(900, BizCurrencyTypes.YEN),
                mapKykSyouhnSumHokenryou1.get(BizCurrencyTypes.YEN));

        Map<CurrencyType, BizCurrency> mapSyouhnTokujouSumTkjyp1 = (Map<CurrencyType, BizCurrency>) kykSyouhnLst.get(0)[2];
        Assert.assertEquals(BizCurrency.valueOf(800), mapSyouhnTokujouSumTkjyp1.get(BizCurrencyTypes.YEN));
    }

    @Test
    @TestOrder(50)
    public void normal2() {

        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("11807111118");

        List<Object[]> kykSyouhnLst = kykKihon.getKoujyosyoumeipkbnKykSyouhnSumHokenryouSyouhnTokujouSumTkjyps();

        Assert.assertEquals(3, kykSyouhnLst.size());

        Assert.assertEquals(C_KoujyosyoumeipKbn.NENKIN, kykSyouhnLst.get(0)[0]);

        Map<CurrencyType, BizCurrency> mapKykSyouhnSumHokenryou1 = (Map<CurrencyType, BizCurrency>) kykSyouhnLst.get(0)[1];
        Assert.assertEquals(BizCurrency.valueOf(333), mapKykSyouhnSumHokenryou1.get(BizCurrencyTypes.YEN));
        Assert.assertEquals(BizCurrency.valueOf(14, BizCurrencyTypes.DOLLAR),
                mapKykSyouhnSumHokenryou1.get(BizCurrencyTypes.DOLLAR));
        Assert.assertEquals(BizCurrency.valueOf(15, BizCurrencyTypes.EURO),
                mapKykSyouhnSumHokenryou1.get(BizCurrencyTypes.EURO));

        Map<CurrencyType, BizCurrency> mapSyouhnTokujouSumTkjyp1 = (Map<CurrencyType, BizCurrency>) kykSyouhnLst.get(0)[2];
        Assert.assertEquals(BizCurrency.valueOf(333), mapSyouhnTokujouSumTkjyp1.get(BizCurrencyTypes.YEN));
        Assert.assertEquals(BizCurrency.valueOf(14, BizCurrencyTypes.DOLLAR),
                mapSyouhnTokujouSumTkjyp1.get(BizCurrencyTypes.DOLLAR));
        Assert.assertEquals(BizCurrency.valueOf(15, BizCurrencyTypes.EURO),
                mapSyouhnTokujouSumTkjyp1.get(BizCurrencyTypes.EURO));

        Assert.assertEquals(C_KoujyosyoumeipKbn.KAIGOIRYOU, kykSyouhnLst.get(1)[0]);

        Map<CurrencyType, BizCurrency> mapKykSyouhnSumHokenryou2 = (Map<CurrencyType, BizCurrency>) kykSyouhnLst.get(1)[1];
        Assert.assertEquals(BizCurrency.valueOf(303), mapKykSyouhnSumHokenryou2.get(BizCurrencyTypes.YEN));
        Assert.assertEquals(BizCurrency.valueOf(22, BizCurrencyTypes.MANYEN),
                mapKykSyouhnSumHokenryou2.get(BizCurrencyTypes.MANYEN));

        Assert.assertEquals(BizCurrency.valueOf(65, BizCurrencyTypes.AU_DOLLAR),
                mapKykSyouhnSumHokenryou2.get(BizCurrencyTypes.AU_DOLLAR));

        Map<CurrencyType, BizCurrency> mapSyouhnTokujouSumTkjyp2 = (Map<CurrencyType, BizCurrency>) kykSyouhnLst.get(1)[2];
        Assert.assertEquals(BizCurrency.valueOf(303), mapSyouhnTokujouSumTkjyp2.get(BizCurrencyTypes.YEN));
        Assert.assertEquals(BizCurrency.valueOf(22, BizCurrencyTypes.MANYEN),
                mapSyouhnTokujouSumTkjyp2.get(BizCurrencyTypes.MANYEN));
        Assert.assertEquals(BizCurrency.valueOf(65, BizCurrencyTypes.AU_DOLLAR),
                mapSyouhnTokujouSumTkjyp2.get(BizCurrencyTypes.AU_DOLLAR));

        Assert.assertEquals(C_KoujyosyoumeipKbn.IPPAN, kykSyouhnLst.get(2)[0]);

        Map<CurrencyType, BizCurrency> mapKykSyouhnSumHokenryou3 = (Map<CurrencyType, BizCurrency>) kykSyouhnLst.get(2)[1];
        Assert.assertEquals(BizCurrency.valueOf(210), mapKykSyouhnSumHokenryou3.get(BizCurrencyTypes.YEN));

        Assert.assertEquals(BizCurrency.valueOf(40, BizCurrencyTypes.MANYEN),
                mapKykSyouhnSumHokenryou3.get(BizCurrencyTypes.MANYEN));

        Assert.assertEquals(BizCurrency.valueOf(4, BizCurrencyTypes.DOLLAR),
                mapKykSyouhnSumHokenryou3.get(BizCurrencyTypes.DOLLAR));

        Map<CurrencyType, BizCurrency> mapSyouhnTokujouSumTkjyp3 = (Map<CurrencyType, BizCurrency>) kykSyouhnLst.get(2)[2];
        Assert.assertEquals(BizCurrency.valueOf(220), mapSyouhnTokujouSumTkjyp3.get(BizCurrencyTypes.YEN));

        Assert.assertEquals(BizCurrency.valueOf(67, BizCurrencyTypes.MANYEN),
                mapSyouhnTokujouSumTkjyp3.get(BizCurrencyTypes.MANYEN));

        Assert.assertEquals(BizCurrency.valueOf(12, BizCurrencyTypes.DOLLAR),
                mapSyouhnTokujouSumTkjyp3.get(BizCurrencyTypes.DOLLAR));

    }
}
