package yuyu.def.hozen.manager;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.def.db.entity.IT_KoujyoSymSougou;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * HozenDomManagerクラスの、<br />
 * getKoujyoSymSougouMaxRennoBySyonoNendoTyouhyouymd() メソッドのテストクラスです。
 */
@RunWith(OrderedRunner.class)
public class HozenDomManagerTest_getKoujyoSymSougouMaxRennoBySyonoNendoTyouhyouymd {
    @Inject
    HozenDomManager hozenDomManager;

    @BeforeClass
    @Transactional
    public static void insertTestData() {

        HozenDomManager hozenDomManager = SWAKInjector.getInstance(HozenDomManager.class);

        Integer maxRenno = hozenDomManager.getKoujyoSymSougouMaxRennoBySyonoNendoTyouhyouymd("11807111130", "2016", BizDate.valueOf("20160223"));

        Assert.assertEquals(null, maxRenno);

        IT_KoujyoSymSougou koujyoSymSougou1 = new IT_KoujyoSymSougou();
        koujyoSymSougou1.setKbnkey("1");
        koujyoSymSougou1.setSyono("11807111130");
        koujyoSymSougou1.setNendo("2016");
        koujyoSymSougou1.setTyouhyouymd(BizDate.valueOf("20160223"));
        koujyoSymSougou1.setRenno(1);
        hozenDomManager.insert(koujyoSymSougou1);

        IT_KoujyoSymSougou koujyoSymSougou2 = new IT_KoujyoSymSougou();
        koujyoSymSougou2.setKbnkey("1");
        koujyoSymSougou2.setSyono("11807111130");
        koujyoSymSougou2.setNendo("2016");
        koujyoSymSougou2.setTyouhyouymd(BizDate.valueOf("20160223"));
        koujyoSymSougou2.setRenno(2);
        hozenDomManager.insert(koujyoSymSougou2);

        IT_KoujyoSymSougou koujyoSymSougou3 = new IT_KoujyoSymSougou();
        koujyoSymSougou3.setKbnkey("1");
        koujyoSymSougou3.setSyono("11807111130");
        koujyoSymSougou3.setNendo("2016");
        koujyoSymSougou3.setTyouhyouymd(BizDate.valueOf("20160223"));
        koujyoSymSougou3.setRenno(3);
        hozenDomManager.insert(koujyoSymSougou3);

        IT_KoujyoSymSougou koujyoSymSougou4 = new IT_KoujyoSymSougou();
        koujyoSymSougou4.setKbnkey("1");
        koujyoSymSougou4.setSyono("11807111118");
        koujyoSymSougou4.setNendo("2016");
        koujyoSymSougou4.setTyouhyouymd(BizDate.valueOf("20160223"));
        koujyoSymSougou4.setRenno(4);
        hozenDomManager.insert(koujyoSymSougou4);

        IT_KoujyoSymSougou koujyoSymSougou5 = new IT_KoujyoSymSougou();
        koujyoSymSougou5.setKbnkey("1");
        koujyoSymSougou5.setSyono("11807111130");
        koujyoSymSougou5.setNendo("2015");
        koujyoSymSougou5.setTyouhyouymd(BizDate.valueOf("20160223"));
        koujyoSymSougou5.setRenno(5);
        hozenDomManager.insert(koujyoSymSougou5);

        IT_KoujyoSymSougou koujyoSymSougou6 = new IT_KoujyoSymSougou();
        koujyoSymSougou6.setKbnkey("1");
        koujyoSymSougou6.setSyono("11807111130");
        koujyoSymSougou6.setNendo("2016");
        koujyoSymSougou6.setTyouhyouymd(BizDate.valueOf("20160224"));
        koujyoSymSougou6.setRenno(6);
        hozenDomManager.insert(koujyoSymSougou6);

    }

    @AfterClass
    @Transactional
    public static void deleteTestData() {
        HozenDomManager hozenDomManager = SWAKInjector.getInstance(HozenDomManager.class);
        hozenDomManager.delete(hozenDomManager.getAllKoujyoSymSougou());
    }

    @Test
    @TestOrder(10)
    public void noResult1() {

        Integer maxRenno = hozenDomManager.getKoujyoSymSougouMaxRennoBySyonoNendoTyouhyouymd("11807111130", "2016", BizDate.valueOf("20160220"));
        Assert.assertEquals(null, maxRenno);
    }

    @Test
    @TestOrder(20)
    public void normal1() {

        Integer maxRenno = hozenDomManager.getKoujyoSymSougouMaxRennoBySyonoNendoTyouhyouymd("11807111130", "2016", BizDate.valueOf("20160223"));
        Assert.assertEquals(Integer.valueOf(3), maxRenno);

    }

    @Test
    @TestOrder(30)
    public void blank1() {

        Integer maxRenno = hozenDomManager.getKoujyoSymSougouMaxRennoBySyonoNendoTyouhyouymd("", "2016", BizDate.valueOf("20160223"));
        Assert.assertEquals(null, maxRenno);

    }

    @Test
    @TestOrder(40)
    public void blank2() {

        Integer maxRenno = hozenDomManager.getKoujyoSymSougouMaxRennoBySyonoNendoTyouhyouymd("11807111130", "", BizDate.valueOf("20160223"));
        Assert.assertEquals(null, maxRenno);

    }
}
