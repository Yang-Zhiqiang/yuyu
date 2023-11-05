package yuyu.def.hozen.manager;

import java.util.List;

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

import yuyu.def.classification.C_KoujyosymnaiyourecKbn;
import yuyu.def.classification.C_KoujyosyoumeipKbn;
import yuyu.def.classification.C_SyutkKbn;
import yuyu.def.classification.C_YuukousyoumetuKbn;
import yuyu.def.db.entity.IT_KihrkmpSeisanRireki;
import yuyu.def.db.entity.IT_KoujyoSymNaiyou;
import yuyu.def.db.entity.IT_KykKihon;
import yuyu.def.db.entity.IT_KykSyouhn;
import yuyu.def.hozen.result.bean.KoujyoSymNaiyouKihrkmpSeisanRirekisBySyonoBean;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * HozenDomManagerクラスの、<br />
 * getKoujyoSymNaiyouKihrkmpSeisanRirekisBySyono() メソッドのテストクラスです。
 */
@RunWith(OrderedRunner.class)
public class HozenDomManagerTest_getKoujyoSymNaiyouKihrkmpSeisanRirekisBySyono {

    @Inject
    HozenDomManager hozenDomManager;

    @BeforeClass
    @Transactional
    public static void insertTestData() {

        HozenDomManager hozenDomManager = SWAKInjector.getInstance(HozenDomManager.class);

        List<KoujyoSymNaiyouKihrkmpSeisanRirekisBySyonoBean> BeanLst =
                hozenDomManager.getKoujyoSymNaiyouKihrkmpSeisanRirekisBySyono("11807111118");
        Assert.assertEquals(0, BeanLst.size());

        IT_KykKihon kykKihon1 = new IT_KykKihon("01", "11807111118");

        IT_KykSyouhn kykSyouhn1 = kykKihon1.createKykSyouhn();
        kykSyouhn1.setSyutkkbn(C_SyutkKbn.valueOf("1"));
        kykSyouhn1.setSyouhncd("A100");
        kykSyouhn1.setSyouhnsdno(20);
        kykSyouhn1.setKyksyouhnrenno(40);
        kykSyouhn1.setYuukousyoumetukbn(C_YuukousyoumetuKbn.valueOf("1"));

        IT_KykSyouhn kykSyouhn3 = kykKihon1.createKykSyouhn();
        kykSyouhn3.setSyutkkbn(C_SyutkKbn.valueOf("2"));
        kykSyouhn3.setSyouhncd("A100");
        kykSyouhn3.setSyouhnsdno(20);
        kykSyouhn3.setKyksyouhnrenno(40);
        kykSyouhn3.setYuukousyoumetukbn(C_YuukousyoumetuKbn.valueOf("1"));

        IT_KihrkmpSeisanRireki kihrkmpSeisanRireki1 = kykKihon1.createKihrkmpSeisanRireki();
        kihrkmpSeisanRireki1.setRenno(1);
        kihrkmpSeisanRireki1.setJyuutouym(BizDateYM.valueOf(201603));
        kihrkmpSeisanRireki1.setSeijyutoukaisuum(03);
        kihrkmpSeisanRireki1.setSeijyutoukaisuuy(2016);
        kihrkmpSeisanRireki1.setSeisanpgoukei(BizCurrency.valueOf(10000));
        kihrkmpSeisanRireki1.setGyoumuKousinKinou("qwert");

        IT_KihrkmpSeisanRireki kihrkmpSeisanRireki3 = kykKihon1.createKihrkmpSeisanRireki();
        kihrkmpSeisanRireki3.setRenno(2);
        kihrkmpSeisanRireki3.setJyuutouym(BizDateYM.valueOf(201603));
        kihrkmpSeisanRireki3.setSeijyutoukaisuum(03);
        kihrkmpSeisanRireki3.setSeijyutoukaisuuy(2016);
        kihrkmpSeisanRireki3.setSeisanpgoukei(BizCurrency.valueOf(10000));
        kihrkmpSeisanRireki3.setGyoumuKousinKinou("qwert");

        IT_KihrkmpSeisanRireki kihrkmpSeisanRireki4 = kykKihon1.createKihrkmpSeisanRireki();
        kihrkmpSeisanRireki4.setRenno(3);
        kihrkmpSeisanRireki4.setJyuutouym(BizDateYM.valueOf(201603));
        kihrkmpSeisanRireki4.setSeijyutoukaisuum(03);
        kihrkmpSeisanRireki4.setSeijyutoukaisuuy(2016);
        kihrkmpSeisanRireki4.setSeisanpgoukei(BizCurrency.valueOf(0));
        kihrkmpSeisanRireki4.setGyoumuKousinKinou("qwert");

        IT_KoujyoSymNaiyou koujyoSymNaiyou1 = kykKihon1.createKoujyoSymNaiyou();
        koujyoSymNaiyou1.setSyouhncd("A100");
        koujyoSymNaiyou1.setRenno3keta(100);
        koujyoSymNaiyou1.setKoujyosyoumeipkbn(C_KoujyosyoumeipKbn.valueOf("1"));
        koujyoSymNaiyou1.setKoujyosymnaiyoureckbn(C_KoujyosymnaiyourecKbn.valueOf("1"));
        koujyoSymNaiyou1.setKoujyosyoumeigk(BizCurrency.valueOf(1000,BizCurrencyTypes.YEN));
        koujyoSymNaiyou1.setKihrkpssrrkrenno(1);

        IT_KoujyoSymNaiyou koujyoSymNaiyou3 = kykKihon1.createKoujyoSymNaiyou();
        koujyoSymNaiyou3.setSyouhncd("A100");
        koujyoSymNaiyou3.setRenno3keta(110);
        koujyoSymNaiyou3.setKoujyosyoumeipkbn(C_KoujyosyoumeipKbn.valueOf("1"));
        koujyoSymNaiyou3.setKoujyosymnaiyoureckbn(C_KoujyosymnaiyourecKbn.valueOf("1"));
        koujyoSymNaiyou3.setKoujyosyoumeigk(BizCurrency.valueOf(1000,BizCurrencyTypes.YEN));
        koujyoSymNaiyou3.setKihrkpssrrkrenno(3);
        hozenDomManager.insert(kykKihon1);

        IT_KykKihon kykKihon2 = new IT_KykKihon("02", "11807111129");

        IT_KykSyouhn kykSyouhn2 = kykKihon2.createKykSyouhn();
        kykSyouhn2.setSyutkkbn(C_SyutkKbn.valueOf("1"));
        kykSyouhn2.setSyouhncd("A100");
        kykSyouhn2.setSyouhnsdno(20);
        kykSyouhn2.setKyksyouhnrenno(40);
        kykSyouhn2.setYuukousyoumetukbn(C_YuukousyoumetuKbn.valueOf("1"));

        IT_KihrkmpSeisanRireki kihrkmpSeisanRireki2 = kykKihon2.createKihrkmpSeisanRireki();
        kihrkmpSeisanRireki2.setRenno(1);
        kihrkmpSeisanRireki2.setJyuutouym(BizDateYM.valueOf(201603));
        kihrkmpSeisanRireki2.setSeijyutoukaisuum(03);
        kihrkmpSeisanRireki2.setSeijyutoukaisuuy(2016);
        kihrkmpSeisanRireki2.setSeisanpgoukei(BizCurrency.valueOf(10000));
        kihrkmpSeisanRireki2.setGyoumuKousinKinou("qwert");

        IT_KoujyoSymNaiyou koujyoSymNaiyou2 = kykKihon2.createKoujyoSymNaiyou();
        koujyoSymNaiyou2.setSyouhncd("A100");
        koujyoSymNaiyou2.setRenno3keta(100);
        koujyoSymNaiyou2.setKoujyosyoumeipkbn(C_KoujyosyoumeipKbn.valueOf("1"));
        koujyoSymNaiyou2.setKoujyosymnaiyoureckbn(C_KoujyosymnaiyourecKbn.valueOf("1"));
        koujyoSymNaiyou2.setKoujyosyoumeigk(BizCurrency.valueOf(1000,BizCurrencyTypes.YEN));
        koujyoSymNaiyou2.setKihrkpssrrkrenno(1);
        hozenDomManager.insert(kykKihon2);

        IT_KykKihon kykKihon3 = new IT_KykKihon("03", "11807111130");

        IT_KykSyouhn kykSyouhn4 = kykKihon3.createKykSyouhn();
        kykSyouhn4.setSyutkkbn(C_SyutkKbn.valueOf("1"));
        kykSyouhn4.setSyouhncd("A100");
        kykSyouhn4.setSyouhnsdno(20);
        kykSyouhn4.setKyksyouhnrenno(40);
        kykSyouhn4.setYuukousyoumetukbn(C_YuukousyoumetuKbn.valueOf("1"));

        IT_KihrkmpSeisanRireki kihrkmpSeisanRireki5 = kykKihon3.createKihrkmpSeisanRireki();
        kihrkmpSeisanRireki5.setRenno(1);
        kihrkmpSeisanRireki5.setJyuutouym(BizDateYM.valueOf(201605));
        kihrkmpSeisanRireki5.setSeijyutoukaisuum(03);
        kihrkmpSeisanRireki5.setSeijyutoukaisuuy(2016);
        kihrkmpSeisanRireki5.setSeisanpgoukei(BizCurrency.valueOf(10000));
        kihrkmpSeisanRireki5.setGyoumuKousinKinou("qwert");

        IT_KihrkmpSeisanRireki kihrkmpSeisanRireki6 = kykKihon3.createKihrkmpSeisanRireki();
        kihrkmpSeisanRireki6.setRenno(2);
        kihrkmpSeisanRireki6.setJyuutouym(BizDateYM.valueOf(201602));
        kihrkmpSeisanRireki6.setSeijyutoukaisuum(03);
        kihrkmpSeisanRireki6.setSeijyutoukaisuuy(2016);
        kihrkmpSeisanRireki6.setSeisanpgoukei(BizCurrency.valueOf(10000));
        kihrkmpSeisanRireki6.setGyoumuKousinKinou("qwert");

        IT_KihrkmpSeisanRireki kihrkmpSeisanRireki7 = kykKihon3.createKihrkmpSeisanRireki();
        kihrkmpSeisanRireki7.setRenno(3);
        kihrkmpSeisanRireki7.setJyuutouym(BizDateYM.valueOf(201601));
        kihrkmpSeisanRireki7.setSeijyutoukaisuum(03);
        kihrkmpSeisanRireki7.setSeijyutoukaisuuy(2016);
        kihrkmpSeisanRireki7.setSeisanpgoukei(BizCurrency.valueOf(10000));
        kihrkmpSeisanRireki7.setGyoumuKousinKinou("qwert");

        IT_KoujyoSymNaiyou koujyoSymNaiyou4 = kykKihon3.createKoujyoSymNaiyou();
        koujyoSymNaiyou4.setSyouhncd("A100");
        koujyoSymNaiyou4.setRenno3keta(100);
        koujyoSymNaiyou4.setKoujyosyoumeipkbn(C_KoujyosyoumeipKbn.valueOf("1"));
        koujyoSymNaiyou4.setKoujyosymnaiyoureckbn(C_KoujyosymnaiyourecKbn.valueOf("1"));
        koujyoSymNaiyou4.setKoujyosyoumeigk(BizCurrency.valueOf(1000,BizCurrencyTypes.YEN));
        koujyoSymNaiyou4.setKihrkpssrrkrenno(1);

        IT_KoujyoSymNaiyou koujyoSymNaiyou5 = kykKihon3.createKoujyoSymNaiyou();
        koujyoSymNaiyou5.setSyouhncd("A100");
        koujyoSymNaiyou5.setRenno3keta(101);
        koujyoSymNaiyou5.setKoujyosyoumeipkbn(C_KoujyosyoumeipKbn.valueOf("1"));
        koujyoSymNaiyou5.setKoujyosymnaiyoureckbn(C_KoujyosymnaiyourecKbn.valueOf("1"));
        koujyoSymNaiyou5.setKoujyosyoumeigk(BizCurrency.valueOf(1000,BizCurrencyTypes.MANYEN));
        koujyoSymNaiyou5.setKihrkpssrrkrenno(2);

        IT_KoujyoSymNaiyou koujyoSymNaiyou6 = kykKihon3.createKoujyoSymNaiyou();
        koujyoSymNaiyou6.setSyouhncd("A100");
        koujyoSymNaiyou6.setRenno3keta(102);
        koujyoSymNaiyou6.setKoujyosyoumeipkbn(C_KoujyosyoumeipKbn.valueOf("1"));
        koujyoSymNaiyou6.setKoujyosymnaiyoureckbn(C_KoujyosymnaiyourecKbn.valueOf("1"));
        koujyoSymNaiyou6.setKoujyosyoumeigk(BizCurrency.valueOf(1000,BizCurrencyTypes.DOLLAR));
        koujyoSymNaiyou6.setKihrkpssrrkrenno(3);
        hozenDomManager.insert(kykKihon3);

        IT_KykKihon kykKihon4 = new IT_KykKihon("04", "11807111141");

        IT_KihrkmpSeisanRireki kihrkmpSeisanRireki8 = kykKihon4.createKihrkmpSeisanRireki();
        kihrkmpSeisanRireki8.setRenno(1);
        kihrkmpSeisanRireki8.setJyuutouym(BizDateYM.valueOf(201603));
        kihrkmpSeisanRireki8.setSeijyutoukaisuum(03);
        kihrkmpSeisanRireki8.setSeijyutoukaisuuy(2016);
        kihrkmpSeisanRireki8.setSeisanpgoukei(BizCurrency.valueOf(10000));
        kihrkmpSeisanRireki8.setGyoumuKousinKinou("qwert");
        hozenDomManager.insert(kykKihon4);
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

        List<KoujyoSymNaiyouKihrkmpSeisanRirekisBySyonoBean> BeanLst =
                hozenDomManager.getKoujyoSymNaiyouKihrkmpSeisanRirekisBySyono("11807111141");
        Assert.assertEquals(0, BeanLst.size());

    }

    @Test
    @TestOrder(20)
    public void normal1() {

        List<KoujyoSymNaiyouKihrkmpSeisanRirekisBySyonoBean> BeanLst =
                hozenDomManager.getKoujyoSymNaiyouKihrkmpSeisanRirekisBySyono("11807111118");
        Assert.assertEquals(1, BeanLst.size());

        Assert.assertEquals(C_KoujyosyoumeipKbn.IPPAN, BeanLst.get(0).getKoujyosyoumeipkbn());
        Assert.assertEquals(C_KoujyosymnaiyourecKbn.HKRNK, BeanLst.get(0).getKoujyosymnaiyoureckbn());
        Assert.assertEquals(BizCurrency.valueOf(1000,BizCurrencyTypes.YEN), BeanLst.get(0).getKoujyosyoumeigk());
        Assert.assertEquals(BizDateYM.valueOf(201603), BeanLst.get(0).getJyuutouym());
        Assert.assertEquals(03, BeanLst.get(0).getSeijyutoukaisuum().intValue());
        Assert.assertEquals(2016, BeanLst.get(0).getSeijyutoukaisuuy().intValue());
        Assert.assertEquals("qwert", BeanLst.get(0).getGyoumuKousinKinou());
        Assert.assertEquals(C_YuukousyoumetuKbn.YUUKOU, BeanLst.get(0).getYuukousyoumetukbn());


    }
    @Test
    @TestOrder(30)
    public void normal2() {

        List<KoujyoSymNaiyouKihrkmpSeisanRirekisBySyonoBean> BeanLst =
                hozenDomManager.getKoujyoSymNaiyouKihrkmpSeisanRirekisBySyono("11807111130");
        Assert.assertEquals(3, BeanLst.size());

        Assert.assertEquals(C_KoujyosyoumeipKbn.IPPAN, BeanLst.get(0).getKoujyosyoumeipkbn());
        Assert.assertEquals(C_KoujyosymnaiyourecKbn.HKRNK, BeanLst.get(0).getKoujyosymnaiyoureckbn());
        Assert.assertEquals(BizCurrency.valueOf(1000,BizCurrencyTypes.DOLLAR), BeanLst.get(0).getKoujyosyoumeigk());
        Assert.assertEquals(BizDateYM.valueOf(201601), BeanLst.get(0).getJyuutouym());
        Assert.assertEquals(03, BeanLst.get(0).getSeijyutoukaisuum().intValue());
        Assert.assertEquals(2016, BeanLst.get(0).getSeijyutoukaisuuy().intValue());
        Assert.assertEquals("qwert", BeanLst.get(0).getGyoumuKousinKinou());
        Assert.assertEquals(C_YuukousyoumetuKbn.YUUKOU, BeanLst.get(0).getYuukousyoumetukbn());

        Assert.assertEquals(C_KoujyosyoumeipKbn.IPPAN, BeanLst.get(1).getKoujyosyoumeipkbn());
        Assert.assertEquals(C_KoujyosymnaiyourecKbn.HKRNK, BeanLst.get(1).getKoujyosymnaiyoureckbn());
        Assert.assertEquals(BizCurrency.valueOf(1000,BizCurrencyTypes.MANYEN), BeanLst.get(1).getKoujyosyoumeigk());
        Assert.assertEquals(BizDateYM.valueOf(201602), BeanLst.get(1).getJyuutouym());
        Assert.assertEquals(03, BeanLst.get(1).getSeijyutoukaisuum().intValue());
        Assert.assertEquals(2016, BeanLst.get(1).getSeijyutoukaisuuy().intValue());
        Assert.assertEquals("qwert", BeanLst.get(1).getGyoumuKousinKinou());
        Assert.assertEquals(C_YuukousyoumetuKbn.YUUKOU, BeanLst.get(1).getYuukousyoumetukbn());

        Assert.assertEquals(C_KoujyosyoumeipKbn.IPPAN, BeanLst.get(2).getKoujyosyoumeipkbn());
        Assert.assertEquals(C_KoujyosymnaiyourecKbn.HKRNK, BeanLst.get(2).getKoujyosymnaiyoureckbn());
        Assert.assertEquals(BizCurrency.valueOf(1000,BizCurrencyTypes.YEN), BeanLst.get(2).getKoujyosyoumeigk());
        Assert.assertEquals(BizDateYM.valueOf(201605), BeanLst.get(2).getJyuutouym());
        Assert.assertEquals(03, BeanLst.get(2).getSeijyutoukaisuum().intValue());
        Assert.assertEquals(2016, BeanLst.get(2).getSeijyutoukaisuuy().intValue());
        Assert.assertEquals("qwert", BeanLst.get(2).getGyoumuKousinKinou());
        Assert.assertEquals(C_YuukousyoumetuKbn.YUUKOU, BeanLst.get(2).getYuukousyoumetukbn());
    }
    @Test
    @TestOrder(40)
    public void blankCondition1() {

        List<KoujyoSymNaiyouKihrkmpSeisanRirekisBySyonoBean> BeanLst =
                hozenDomManager.getKoujyoSymNaiyouKihrkmpSeisanRirekisBySyono("");
        Assert.assertEquals(0, BeanLst.size());

    }
}
