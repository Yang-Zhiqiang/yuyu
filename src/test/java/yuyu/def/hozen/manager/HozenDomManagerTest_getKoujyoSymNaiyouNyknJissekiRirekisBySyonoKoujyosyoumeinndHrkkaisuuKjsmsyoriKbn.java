package yuyu.def.hozen.manager;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;
import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

import yuyu.def.classification.C_Hrkkaisuu;
import yuyu.def.classification.C_Kjsmhakkouzumiflg;
import yuyu.def.classification.C_KjsmsyoriKbn;
import yuyu.def.classification.C_KoujyosyoumeipKbn;
import yuyu.def.classification.C_Nyktrksflg;
import yuyu.def.db.entity.IT_KoujyoSymNaiyou;
import yuyu.def.db.entity.IT_KykKihon;
import yuyu.def.db.entity.IT_NyknJissekiRireki;
import yuyu.def.hozen.result.bean.KoujyoSymNaiyouNyknJissekiRirekisBySyonoKoujyosyoumeinndHrkkaisuuKjsmsyoriKbnBean;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * HozenDomManagerクラスの、<br />
 * getKoujyoSymNaiyouNyknJissekiRirekisBySyonoKoujyosyoumeinndHrkkaisuuKjsmsyoriKbn() メソッドのテストクラスです。
 */
@RunWith(OrderedRunner.class)
public class HozenDomManagerTest_getKoujyoSymNaiyouNyknJissekiRirekisBySyonoKoujyosyoumeinndHrkkaisuuKjsmsyoriKbn {

    @Inject
    HozenDomManager hozenDomManager;

    @BeforeClass
    @Transactional
    public static void insertTestData() {

        HozenDomManager hozenDomManager = SWAKInjector.getInstance(HozenDomManager.class);

        List<KoujyoSymNaiyouNyknJissekiRirekisBySyonoKoujyosyoumeinndHrkkaisuuKjsmsyoriKbnBean> KSNNJRBeanLst =
            hozenDomManager.getKoujyoSymNaiyouNyknJissekiRirekisBySyonoKoujyosyoumeinndHrkkaisuuKjsmsyoriKbn(
                "11807111118", "2016", C_Hrkkaisuu.TUKI, C_KjsmsyoriKbn.KJSMBATCH);
        Assert.assertEquals(0, KSNNJRBeanLst.size());

        IT_KykKihon kykKihon1 = new IT_KykKihon("01", "11807111118");

        IT_KoujyoSymNaiyou koujyoSymNaiyou1 = kykKihon1.createKoujyoSymNaiyou();
        koujyoSymNaiyou1.setSyouhncd("A100");
        koujyoSymNaiyou1.setRenno3keta(100);
        koujyoSymNaiyou1.setKoujyosyoumeinnd("2016");
        koujyoSymNaiyou1.setSyoumeistartym(BizDateYM.valueOf(201603));
        koujyoSymNaiyou1.setSyoumeiendym(BizDateYM.valueOf(201605));
        koujyoSymNaiyou1.setKoujyosyoumeipkbn(C_KoujyosyoumeipKbn.valueOf("1"));
        koujyoSymNaiyou1.setKoujyosyoumeigk(BizCurrency.valueOf(10000,BizCurrencyTypes.YEN));
        koujyoSymNaiyou1.setJyutoustartym(BizDateYM.valueOf(201603));
        koujyoSymNaiyou1.setNyknjskrrkrenno(1);
        koujyoSymNaiyou1.setKjsmhakkouzumiflg(C_Kjsmhakkouzumiflg.valueOf("0"));

        IT_KoujyoSymNaiyou koujyoSymNaiyou3 = kykKihon1.createKoujyoSymNaiyou();
        koujyoSymNaiyou3.setSyouhncd("A100");
        koujyoSymNaiyou3.setRenno3keta(101);
        koujyoSymNaiyou3.setKoujyosyoumeinnd("2017");
        koujyoSymNaiyou3.setSyoumeistartym(BizDateYM.valueOf(201603));
        koujyoSymNaiyou3.setSyoumeiendym(BizDateYM.valueOf(201605));
        koujyoSymNaiyou3.setKoujyosyoumeipkbn(C_KoujyosyoumeipKbn.valueOf("1"));
        koujyoSymNaiyou3.setKoujyosyoumeigk(BizCurrency.valueOf(10000,BizCurrencyTypes.YEN));
        koujyoSymNaiyou3.setJyutoustartym(BizDateYM.valueOf(201603));
        koujyoSymNaiyou3.setNyknjskrrkrenno(1);
        koujyoSymNaiyou3.setKjsmhakkouzumiflg(C_Kjsmhakkouzumiflg.valueOf("0"));

        IT_KoujyoSymNaiyou koujyoSymNaiyou7 = kykKihon1.createKoujyoSymNaiyou();
        koujyoSymNaiyou7.setSyouhncd("A200");
        koujyoSymNaiyou7.setRenno3keta(100);
        koujyoSymNaiyou7.setKoujyosyoumeinnd("2016");
        koujyoSymNaiyou7.setSyoumeistartym(BizDateYM.valueOf(201602));
        koujyoSymNaiyou7.setSyoumeiendym(BizDateYM.valueOf(201605));
        koujyoSymNaiyou7.setKoujyosyoumeipkbn(C_KoujyosyoumeipKbn.valueOf("1"));
        koujyoSymNaiyou7.setKoujyosyoumeigk(BizCurrency.valueOf(10000,BizCurrencyTypes.MANYEN));
        koujyoSymNaiyou7.setJyutoustartym(BizDateYM.valueOf(201603));
        koujyoSymNaiyou7.setNyknjskrrkrenno(1);
        koujyoSymNaiyou7.setKjsmhakkouzumiflg(C_Kjsmhakkouzumiflg.valueOf("1"));

        IT_KoujyoSymNaiyou koujyoSymNaiyou8 = kykKihon1.createKoujyoSymNaiyou();
        koujyoSymNaiyou8.setSyouhncd("A300");
        koujyoSymNaiyou8.setRenno3keta(100);
        koujyoSymNaiyou8.setKoujyosyoumeinnd("2016");
        koujyoSymNaiyou8.setSyoumeistartym(BizDateYM.valueOf(201601));
        koujyoSymNaiyou8.setSyoumeiendym(BizDateYM.valueOf(201605));
        koujyoSymNaiyou8.setKoujyosyoumeipkbn(C_KoujyosyoumeipKbn.valueOf("1"));
        koujyoSymNaiyou8.setKoujyosyoumeigk(BizCurrency.valueOf(10000,BizCurrencyTypes.DOLLAR));
        koujyoSymNaiyou8.setJyutoustartym(BizDateYM.valueOf(201603));
        koujyoSymNaiyou8.setNyknjskrrkrenno(1);
        koujyoSymNaiyou8.setKjsmhakkouzumiflg(C_Kjsmhakkouzumiflg.valueOf("1"));

        IT_KoujyoSymNaiyou koujyoSymNaiyou9 = kykKihon1.createKoujyoSymNaiyou();
        koujyoSymNaiyou9.setSyouhncd("A100");
        koujyoSymNaiyou9.setRenno3keta(102);
        koujyoSymNaiyou9.setKoujyosyoumeinnd("2016");
        koujyoSymNaiyou9.setSyoumeistartym(BizDateYM.valueOf(201603));
        koujyoSymNaiyou9.setSyoumeiendym(BizDateYM.valueOf(201605));
        koujyoSymNaiyou9.setKoujyosyoumeipkbn(C_KoujyosyoumeipKbn.valueOf("1"));
        koujyoSymNaiyou9.setKoujyosyoumeigk(BizCurrency.valueOf(10000,BizCurrencyTypes.YEN));
        koujyoSymNaiyou9.setJyutoustartym(BizDateYM.valueOf(201603));
        koujyoSymNaiyou9.setNyknjskrrkrenno(3);
        koujyoSymNaiyou9.setKjsmhakkouzumiflg(C_Kjsmhakkouzumiflg.valueOf("0"));

        IT_KoujyoSymNaiyou koujyoSymNaiyou10 = kykKihon1.createKoujyoSymNaiyou();
        koujyoSymNaiyou10.setSyouhncd("A100");
        koujyoSymNaiyou10.setRenno3keta(103);
        koujyoSymNaiyou10.setKoujyosyoumeinnd("2016");
        koujyoSymNaiyou10.setSyoumeistartym(BizDateYM.valueOf(201603));
        koujyoSymNaiyou10.setSyoumeiendym(BizDateYM.valueOf(201605));
        koujyoSymNaiyou10.setKoujyosyoumeipkbn(C_KoujyosyoumeipKbn.valueOf("1"));
        koujyoSymNaiyou10.setKoujyosyoumeigk(BizCurrency.valueOf(10000,BizCurrencyTypes.YEN));
        koujyoSymNaiyou10.setJyutoustartym(BizDateYM.valueOf(201603));
        koujyoSymNaiyou10.setNyknjskrrkrenno(4);
        koujyoSymNaiyou10.setKjsmhakkouzumiflg(C_Kjsmhakkouzumiflg.valueOf("0"));

        IT_NyknJissekiRireki nyknJissekiRireki1 = kykKihon1.createNyknJissekiRireki();
        nyknJissekiRireki1.setJyutoustartym(BizDateYM.valueOf(201603));
        nyknJissekiRireki1.setRenno(1);
        nyknJissekiRireki1.setHrkkaisuu(C_Hrkkaisuu.valueOf("1"));
        nyknJissekiRireki1.setNyktrksflg(C_Nyktrksflg.valueOf("0"));

        IT_NyknJissekiRireki nyknJissekiRireki3 = kykKihon1.createNyknJissekiRireki();
        nyknJissekiRireki3.setJyutoustartym(BizDateYM.valueOf(201603));
        nyknJissekiRireki3.setRenno(3);
        nyknJissekiRireki3.setHrkkaisuu(C_Hrkkaisuu.valueOf("0"));
        nyknJissekiRireki3.setNyktrksflg(C_Nyktrksflg.valueOf("0"));

        IT_NyknJissekiRireki nyknJissekiRireki4 = kykKihon1.createNyknJissekiRireki();
        nyknJissekiRireki4.setJyutoustartym(BizDateYM.valueOf(201604));
        nyknJissekiRireki4.setRenno(1);
        nyknJissekiRireki4.setHrkkaisuu(C_Hrkkaisuu.valueOf("1"));
        nyknJissekiRireki4.setNyktrksflg(C_Nyktrksflg.valueOf("0"));

        IT_NyknJissekiRireki nyknJissekiRireki5 = kykKihon1.createNyknJissekiRireki();
        nyknJissekiRireki5.setJyutoustartym(BizDateYM.valueOf(201603));
        nyknJissekiRireki5.setRenno(2);
        nyknJissekiRireki5.setHrkkaisuu(C_Hrkkaisuu.valueOf("1"));
        nyknJissekiRireki5.setNyktrksflg(C_Nyktrksflg.valueOf("0"));

        IT_NyknJissekiRireki nyknJissekiRireki6 = kykKihon1.createNyknJissekiRireki();
        nyknJissekiRireki6.setJyutoustartym(BizDateYM.valueOf(201603));
        nyknJissekiRireki6.setRenno(4);
        nyknJissekiRireki6.setHrkkaisuu(C_Hrkkaisuu.valueOf("1"));
        nyknJissekiRireki6.setNyktrksflg(C_Nyktrksflg.valueOf("1"));

        hozenDomManager.insert(kykKihon1);

        IT_KykKihon kykKihon2 = new IT_KykKihon("02", "11807111129");

        IT_KoujyoSymNaiyou koujyoSymNaiyou2 = kykKihon2.createKoujyoSymNaiyou();
        koujyoSymNaiyou2.setSyouhncd("A100");
        koujyoSymNaiyou2.setRenno3keta(100);
        koujyoSymNaiyou2.setKoujyosyoumeinnd("2016");
        koujyoSymNaiyou2.setSyoumeistartym(BizDateYM.valueOf(201603));
        koujyoSymNaiyou2.setSyoumeiendym(BizDateYM.valueOf(201605));
        koujyoSymNaiyou2.setKoujyosyoumeipkbn(C_KoujyosyoumeipKbn.valueOf("1"));
        koujyoSymNaiyou2.setKoujyosyoumeigk(BizCurrency.valueOf(10000,BizCurrencyTypes.YEN));
        koujyoSymNaiyou2.setJyutoustartym(BizDateYM.valueOf(201603));
        koujyoSymNaiyou2.setNyknjskrrkrenno(1);
        koujyoSymNaiyou2.setKjsmhakkouzumiflg(C_Kjsmhakkouzumiflg.valueOf("0"));

        IT_NyknJissekiRireki nyknJissekiRireki2 = kykKihon2.createNyknJissekiRireki();
        nyknJissekiRireki2.setJyutoustartym(BizDateYM.valueOf(201603));
        nyknJissekiRireki2.setRenno(1);
        nyknJissekiRireki2.setHrkkaisuu(C_Hrkkaisuu.valueOf("1"));
        nyknJissekiRireki2.setNyktrksflg(C_Nyktrksflg.valueOf("0"));

        hozenDomManager.insert(kykKihon2);

        IT_KykKihon kykKihon3 = new IT_KykKihon("03", "11807111130");

        IT_KoujyoSymNaiyou koujyoSymNaiyou4 = kykKihon3.createKoujyoSymNaiyou();
        koujyoSymNaiyou4.setSyouhncd("A100");
        koujyoSymNaiyou4.setRenno3keta(100);
        koujyoSymNaiyou4.setKoujyosyoumeinnd("2016");
        koujyoSymNaiyou4.setSyoumeistartym(BizDateYM.valueOf(201603));
        koujyoSymNaiyou4.setSyoumeiendym(BizDateYM.valueOf(201605));
        koujyoSymNaiyou4.setKoujyosyoumeipkbn(C_KoujyosyoumeipKbn.valueOf("1"));
        koujyoSymNaiyou4.setKoujyosyoumeigk(BizCurrency.valueOf(10000,BizCurrencyTypes.YEN));
        koujyoSymNaiyou4.setJyutoustartym(BizDateYM.valueOf(201603));
        koujyoSymNaiyou4.setNyknjskrrkrenno(1);
        koujyoSymNaiyou4.setKjsmhakkouzumiflg(C_Kjsmhakkouzumiflg.valueOf("0"));

        IT_KoujyoSymNaiyou koujyoSymNaiyou5 = kykKihon3.createKoujyoSymNaiyou();
        koujyoSymNaiyou5.setSyouhncd("A100");
        koujyoSymNaiyou5.setRenno3keta(101);
        koujyoSymNaiyou5.setKoujyosyoumeinnd("2016");
        koujyoSymNaiyou5.setSyoumeistartym(BizDateYM.valueOf(201603));
        koujyoSymNaiyou5.setSyoumeiendym(BizDateYM.valueOf(201605));
        koujyoSymNaiyou5.setKoujyosyoumeipkbn(C_KoujyosyoumeipKbn.valueOf("1"));
        koujyoSymNaiyou5.setKoujyosyoumeigk(BizCurrency.valueOf(10000,BizCurrencyTypes.YEN));
        koujyoSymNaiyou5.setJyutoustartym(BizDateYM.valueOf(201603));
        koujyoSymNaiyou5.setNyknjskrrkrenno(2);
        koujyoSymNaiyou5.setKjsmhakkouzumiflg(C_Kjsmhakkouzumiflg.valueOf("0"));

        IT_KoujyoSymNaiyou koujyoSymNaiyou6 = kykKihon3.createKoujyoSymNaiyou();
        koujyoSymNaiyou6.setSyouhncd("A100");
        koujyoSymNaiyou6.setRenno3keta(102);
        koujyoSymNaiyou6.setKoujyosyoumeinnd("2016");
        koujyoSymNaiyou6.setSyoumeistartym(BizDateYM.valueOf(201603));
        koujyoSymNaiyou6.setSyoumeiendym(BizDateYM.valueOf(201605));
        koujyoSymNaiyou6.setKoujyosyoumeipkbn(C_KoujyosyoumeipKbn.valueOf("1"));
        koujyoSymNaiyou6.setKoujyosyoumeigk(BizCurrency.valueOf(10000,BizCurrencyTypes.YEN));
        koujyoSymNaiyou6.setJyutoustartym(BizDateYM.valueOf(201603));
        koujyoSymNaiyou6.setNyknjskrrkrenno(3);
        koujyoSymNaiyou6.setKjsmhakkouzumiflg(C_Kjsmhakkouzumiflg.valueOf("0"));

        IT_NyknJissekiRireki nyknJissekiRireki7 = kykKihon3.createNyknJissekiRireki();
        nyknJissekiRireki7.setJyutoustartym(BizDateYM.valueOf(201603));
        nyknJissekiRireki7.setRenno(1);
        nyknJissekiRireki7.setHrkkaisuu(C_Hrkkaisuu.valueOf("6"));
        nyknJissekiRireki7.setNyktrksflg(C_Nyktrksflg.valueOf("0"));

        IT_NyknJissekiRireki nyknJissekiRireki8 = kykKihon3.createNyknJissekiRireki();
        nyknJissekiRireki8.setJyutoustartym(BizDateYM.valueOf(201603));
        nyknJissekiRireki8.setRenno(2);
        nyknJissekiRireki8.setHrkkaisuu(C_Hrkkaisuu.valueOf("12"));
        nyknJissekiRireki8.setNyktrksflg(C_Nyktrksflg.valueOf("0"));

        IT_NyknJissekiRireki nyknJissekiRireki9 = kykKihon3.createNyknJissekiRireki();
        nyknJissekiRireki9.setJyutoustartym(BizDateYM.valueOf(201603));
        nyknJissekiRireki9.setRenno(3);
        nyknJissekiRireki9.setHrkkaisuu(C_Hrkkaisuu.valueOf("12"));
        nyknJissekiRireki9.setNyktrksflg(C_Nyktrksflg.valueOf("0"));

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

        List<KoujyoSymNaiyouNyknJissekiRirekisBySyonoKoujyosyoumeinndHrkkaisuuKjsmsyoriKbnBean> KSNNJRBeanLst =
            hozenDomManager.getKoujyoSymNaiyouNyknJissekiRirekisBySyonoKoujyosyoumeinndHrkkaisuuKjsmsyoriKbn(
                "11807111141", "2016", C_Hrkkaisuu.TUKI, C_KjsmsyoriKbn.KJSMBATCH);
        Assert.assertEquals(0, KSNNJRBeanLst.size());

    }

    @Test
    @TestOrder(20)
    public void normal1() {

        List<KoujyoSymNaiyouNyknJissekiRirekisBySyonoKoujyosyoumeinndHrkkaisuuKjsmsyoriKbnBean> KSNNJRBeanLst =
            hozenDomManager.getKoujyoSymNaiyouNyknJissekiRirekisBySyonoKoujyosyoumeinndHrkkaisuuKjsmsyoriKbn(
                "11807111118", "2016", C_Hrkkaisuu.TUKI, C_KjsmsyoriKbn.KJSMBATCH);
        Assert.assertEquals(1, KSNNJRBeanLst.size());

        Assert.assertEquals("A100", KSNNJRBeanLst.get(0).getSyouhncd());
        Assert.assertEquals(100, KSNNJRBeanLst.get(0).getRenno3keta().intValue());
        Assert.assertEquals(C_KoujyosyoumeipKbn.IPPAN, KSNNJRBeanLst.get(0).getKoujyosyoumeipkbn());
        Assert.assertEquals(BizCurrency.valueOf(10000,BizCurrencyTypes.YEN), KSNNJRBeanLst.get(0).getKoujyosyoumeigk());
        Assert.assertEquals(BizDateYM.valueOf(201603), KSNNJRBeanLst.get(0).getSyoumeistartym());
        Assert.assertEquals(BizDateYM.valueOf(201605), KSNNJRBeanLst.get(0).getSyoumeiendym());
        Assert.assertEquals(C_Hrkkaisuu.TUKI, KSNNJRBeanLst.get(0).getHrkkaisuu());

    }
    @Test
    @TestOrder(30)
    public void normal2() {

        Map<String,String> map = new HashMap<String,String>();

        map.put($("A100", 100, C_KoujyosyoumeipKbn.IPPAN, BizCurrency.valueOf(10000,BizCurrencyTypes.YEN), BizDateYM.valueOf(201603), BizDateYM.valueOf(201605), C_Hrkkaisuu.HALFY),"1");
        map.put($("A100", 101, C_KoujyosyoumeipKbn.IPPAN, BizCurrency.valueOf(10000,BizCurrencyTypes.YEN), BizDateYM.valueOf(201603), BizDateYM.valueOf(201605), C_Hrkkaisuu.NEN),"1");
        map.put($("A100", 102, C_KoujyosyoumeipKbn.IPPAN, BizCurrency.valueOf(10000,BizCurrencyTypes.YEN), BizDateYM.valueOf(201603), BizDateYM.valueOf(201605), C_Hrkkaisuu.NEN),"1");

        List<KoujyoSymNaiyouNyknJissekiRirekisBySyonoKoujyosyoumeinndHrkkaisuuKjsmsyoriKbnBean> KSNNJRBeanLst =
            hozenDomManager.getKoujyoSymNaiyouNyknJissekiRirekisBySyonoKoujyosyoumeinndHrkkaisuuKjsmsyoriKbn(
                "11807111130", "2016", C_Hrkkaisuu.BLNK, C_KjsmsyoriKbn.KJSMBATCH);
        Assert.assertEquals(3, KSNNJRBeanLst.size());

        assertTrue(map.containsKey($(KSNNJRBeanLst.get(0).getSyouhncd(), KSNNJRBeanLst.get(0).getRenno3keta().intValue(), KSNNJRBeanLst.get(0).getKoujyosyoumeipkbn(), KSNNJRBeanLst.get(0).getKoujyosyoumeigk(), KSNNJRBeanLst.get(0).getSyoumeistartym(), KSNNJRBeanLst.get(0).getSyoumeiendym(), KSNNJRBeanLst.get(0).getHrkkaisuu())));
        assertTrue(map.containsKey($(KSNNJRBeanLst.get(1).getSyouhncd(), KSNNJRBeanLst.get(1).getRenno3keta().intValue(), KSNNJRBeanLst.get(1).getKoujyosyoumeipkbn(), KSNNJRBeanLst.get(1).getKoujyosyoumeigk(), KSNNJRBeanLst.get(1).getSyoumeistartym(), KSNNJRBeanLst.get(1).getSyoumeiendym(), KSNNJRBeanLst.get(1).getHrkkaisuu())));
        assertTrue(map.containsKey($(KSNNJRBeanLst.get(2).getSyouhncd(), KSNNJRBeanLst.get(2).getRenno3keta().intValue(), KSNNJRBeanLst.get(2).getKoujyosyoumeipkbn(), KSNNJRBeanLst.get(2).getKoujyosyoumeigk(), KSNNJRBeanLst.get(2).getSyoumeistartym(), KSNNJRBeanLst.get(2).getSyoumeiendym(), KSNNJRBeanLst.get(2).getHrkkaisuu())));

        map.remove($(KSNNJRBeanLst.get(0).getSyouhncd(), KSNNJRBeanLst.get(0).getRenno3keta().intValue(), KSNNJRBeanLst.get(0).getKoujyosyoumeipkbn(), KSNNJRBeanLst.get(0).getKoujyosyoumeigk(), KSNNJRBeanLst.get(0).getSyoumeistartym(), KSNNJRBeanLst.get(0).getSyoumeiendym(), KSNNJRBeanLst.get(0).getHrkkaisuu()));
        map.remove($(KSNNJRBeanLst.get(1).getSyouhncd(), KSNNJRBeanLst.get(1).getRenno3keta().intValue(), KSNNJRBeanLst.get(1).getKoujyosyoumeipkbn(), KSNNJRBeanLst.get(1).getKoujyosyoumeigk(), KSNNJRBeanLst.get(1).getSyoumeistartym(), KSNNJRBeanLst.get(1).getSyoumeiendym(), KSNNJRBeanLst.get(1).getHrkkaisuu()));
        map.remove($(KSNNJRBeanLst.get(2).getSyouhncd(), KSNNJRBeanLst.get(2).getRenno3keta().intValue(), KSNNJRBeanLst.get(2).getKoujyosyoumeipkbn(), KSNNJRBeanLst.get(2).getKoujyosyoumeigk(), KSNNJRBeanLst.get(2).getSyoumeistartym(), KSNNJRBeanLst.get(2).getSyoumeiendym(), KSNNJRBeanLst.get(2).getHrkkaisuu()));

        assertTrue(map.isEmpty());

    }
    @Test
    @TestOrder(40)
    public void normal3() {

        List<KoujyoSymNaiyouNyknJissekiRirekisBySyonoKoujyosyoumeinndHrkkaisuuKjsmsyoriKbnBean> KSNNJRBeanLst =
            hozenDomManager.getKoujyoSymNaiyouNyknJissekiRirekisBySyonoKoujyosyoumeinndHrkkaisuuKjsmsyoriKbn(
                "11807111118", "2016", C_Hrkkaisuu.TUKI, C_KjsmsyoriKbn.BLNK);
        Assert.assertEquals(3, KSNNJRBeanLst.size());

        Assert.assertEquals("A300", KSNNJRBeanLst.get(0).getSyouhncd());
        Assert.assertEquals(100, KSNNJRBeanLst.get(0).getRenno3keta().intValue());
        Assert.assertEquals(C_KoujyosyoumeipKbn.IPPAN, KSNNJRBeanLst.get(0).getKoujyosyoumeipkbn());
        Assert.assertEquals(BizCurrency.valueOf(10000,BizCurrencyTypes.DOLLAR), KSNNJRBeanLst.get(0).getKoujyosyoumeigk());
        Assert.assertEquals(BizDateYM.valueOf(201601), KSNNJRBeanLst.get(0).getSyoumeistartym());
        Assert.assertEquals(BizDateYM.valueOf(201605), KSNNJRBeanLst.get(0).getSyoumeiendym());
        Assert.assertEquals(C_Hrkkaisuu.TUKI, KSNNJRBeanLst.get(0).getHrkkaisuu());

        Assert.assertEquals("A200", KSNNJRBeanLst.get(1).getSyouhncd());
        Assert.assertEquals(100, KSNNJRBeanLst.get(1).getRenno3keta().intValue());
        Assert.assertEquals(C_KoujyosyoumeipKbn.IPPAN, KSNNJRBeanLst.get(1).getKoujyosyoumeipkbn());
        Assert.assertEquals(BizCurrency.valueOf(10000,BizCurrencyTypes.MANYEN), KSNNJRBeanLst.get(1).getKoujyosyoumeigk());
        Assert.assertEquals(BizDateYM.valueOf(201602), KSNNJRBeanLst.get(1).getSyoumeistartym());
        Assert.assertEquals(BizDateYM.valueOf(201605), KSNNJRBeanLst.get(1).getSyoumeiendym());
        Assert.assertEquals(C_Hrkkaisuu.TUKI, KSNNJRBeanLst.get(1).getHrkkaisuu());

        Assert.assertEquals("A100", KSNNJRBeanLst.get(2).getSyouhncd());
        Assert.assertEquals(100, KSNNJRBeanLst.get(2).getRenno3keta().intValue());
        Assert.assertEquals(C_KoujyosyoumeipKbn.IPPAN, KSNNJRBeanLst.get(2).getKoujyosyoumeipkbn());
        Assert.assertEquals(BizCurrency.valueOf(10000,BizCurrencyTypes.YEN), KSNNJRBeanLst.get(2).getKoujyosyoumeigk());
        Assert.assertEquals(BizDateYM.valueOf(201603), KSNNJRBeanLst.get(2).getSyoumeistartym());
        Assert.assertEquals(BizDateYM.valueOf(201605), KSNNJRBeanLst.get(2).getSyoumeiendym());
        Assert.assertEquals(C_Hrkkaisuu.TUKI, KSNNJRBeanLst.get(2).getHrkkaisuu());
    }

    @Test
    @TestOrder(50)
    public void blankCondition1() {

        List<KoujyoSymNaiyouNyknJissekiRirekisBySyonoKoujyosyoumeinndHrkkaisuuKjsmsyoriKbnBean> KSNNJRBeanLst =
            hozenDomManager.getKoujyoSymNaiyouNyknJissekiRirekisBySyonoKoujyosyoumeinndHrkkaisuuKjsmsyoriKbn(
                "", "2016", C_Hrkkaisuu.TUKI, C_KjsmsyoriKbn.KJSMBATCH);
        Assert.assertEquals(0, KSNNJRBeanLst.size());

    }

    @Test
    @TestOrder(60)
    public void blankCondition2() {

        List<KoujyoSymNaiyouNyknJissekiRirekisBySyonoKoujyosyoumeinndHrkkaisuuKjsmsyoriKbnBean> KSNNJRBeanLst =
            hozenDomManager.getKoujyoSymNaiyouNyknJissekiRirekisBySyonoKoujyosyoumeinndHrkkaisuuKjsmsyoriKbn(
                "11807111141", "", C_Hrkkaisuu.TUKI, C_KjsmsyoriKbn.KJSMBATCH);
        Assert.assertEquals(0, KSNNJRBeanLst.size());

    }
}
