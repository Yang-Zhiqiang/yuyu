package yuyu.def.hozen.manager;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.slcs.swak.core.inject.SWAKInjector;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.def.db.entity.IT_KoujyoSymNaiyou;
import yuyu.def.db.entity.IT_KykKihon;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * HozenDomManagerクラスの、<br />
 * getKoujyoSymNaiyouMaxRenno3ketaBySyonoSyouhncd() メソッドのテストクラスです。
 */
@RunWith(OrderedRunner.class)
public class HozenDomManagerTest_getKoujyoSymNaiyouMaxRenno3ketaBySyonoSyouhncd {

    @Inject
    HozenDomManager hozenDomManager;

    @BeforeClass
    @Transactional
    public static void insertTestData() {

        HozenDomManager hozenDomManager = SWAKInjector.getInstance(HozenDomManager.class);

        Assert.assertEquals(null, hozenDomManager.getKoujyoSymNaiyouMaxRenno3ketaBySyonoSyouhncd("11807111118", "A100"));

        IT_KykKihon kykKihon1 = new IT_KykKihon("10", "11807111118");

        IT_KoujyoSymNaiyou koujyoSymNaiyou1 = kykKihon1.createKoujyoSymNaiyou();
        koujyoSymNaiyou1.setSyouhncd("A100");
        koujyoSymNaiyou1.setRenno3keta(3);

        IT_KoujyoSymNaiyou koujyoSymNaiyou3 = kykKihon1.createKoujyoSymNaiyou();
        koujyoSymNaiyou3.setSyouhncd("A200");
        koujyoSymNaiyou3.setRenno3keta(5);

        IT_KoujyoSymNaiyou koujyoSymNaiyou4 = kykKihon1.createKoujyoSymNaiyou();
        koujyoSymNaiyou4.setSyouhncd("A100");
        koujyoSymNaiyou4.setRenno3keta(6);

        IT_KoujyoSymNaiyou koujyoSymNaiyou5 = kykKihon1.createKoujyoSymNaiyou();
        koujyoSymNaiyou5.setSyouhncd("A100");
        koujyoSymNaiyou5.setRenno3keta(2);

        hozenDomManager.insert(kykKihon1);

        IT_KykKihon kykKihon2 = new IT_KykKihon("10", "11807111129");

        IT_KoujyoSymNaiyou koujyoSymNaiyou2 = kykKihon2.createKoujyoSymNaiyou();
        koujyoSymNaiyou2.setSyouhncd("A100");
        koujyoSymNaiyou2.setRenno3keta(4);

        hozenDomManager.insert(kykKihon2);


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

        Integer maxrenno3keta = hozenDomManager.getKoujyoSymNaiyouMaxRenno3ketaBySyonoSyouhncd("11807111152", "A100");
        Assert.assertNull(maxrenno3keta);

    }

    @Test
    @TestOrder(20)
    public void normal1(){

        Integer maxrenno3keta = hozenDomManager.getKoujyoSymNaiyouMaxRenno3ketaBySyonoSyouhncd("11807111118", "A100");
        Assert.assertEquals(6, maxrenno3keta.intValue());
    }
    @Test
    @TestOrder(30)
    public void blankCondition1(){

        Integer maxrenno3keta = hozenDomManager.getKoujyoSymNaiyouMaxRenno3ketaBySyonoSyouhncd("", "A100");
        Assert.assertNull(maxrenno3keta);
    }
    @Test
    @TestOrder(40)
    public void blankCondition2() {

        Integer maxrenno3keta = hozenDomManager.getKoujyoSymNaiyouMaxRenno3ketaBySyonoSyouhncd("11807111118", "");
        Assert.assertNull(maxrenno3keta);

    }
}
