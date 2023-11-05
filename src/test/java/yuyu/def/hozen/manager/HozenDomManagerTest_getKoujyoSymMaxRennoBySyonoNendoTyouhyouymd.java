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

import yuyu.def.db.entity.IT_KoujyoSym;
import yuyu.def.db.entity.IT_KykKihon;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * HozenDomManagerクラスの、<br />
 * getKoujyoSymMaxRennoBySyonoNendoTyouhyouymd() メソッドのテストクラスです。
 */
@RunWith(OrderedRunner.class)
public class HozenDomManagerTest_getKoujyoSymMaxRennoBySyonoNendoTyouhyouymd {
    @Inject
    HozenDomManager hozenDomManager;

    @BeforeClass
    @Transactional
    public static void insertTestData() {

        HozenDomManager hozenDomManager = SWAKInjector.getInstance(HozenDomManager.class);

        Integer maxRenno = hozenDomManager.getKoujyoSymMaxRennoBySyonoNendoTyouhyouymd("11807111130", "2016", BizDate.valueOf("20160223"));

        Assert.assertEquals(null, maxRenno);

        IT_KykKihon kykKihon1 = hozenDomManager.getKykKihon("11807111130");
        if( null == kykKihon1 ) {
            kykKihon1 = new IT_KykKihon("10", "11807111130");

            IT_KoujyoSym koujyoSym1 = kykKihon1.createKoujyoSym();
            koujyoSym1.setNendo("2016");
            koujyoSym1.setTyouhyouymd(BizDate.valueOf("20160223"));
            koujyoSym1.setRenno(1);

            IT_KoujyoSym koujyoSym2 = kykKihon1.createKoujyoSym();
            koujyoSym2.setNendo("2016");
            koujyoSym2.setTyouhyouymd(BizDate.valueOf("20160223"));
            koujyoSym2.setRenno(2);

            IT_KoujyoSym koujyoSym3 = kykKihon1.createKoujyoSym();
            koujyoSym3.setNendo("2016");
            koujyoSym3.setTyouhyouymd(BizDate.valueOf("20160223"));
            koujyoSym3.setRenno(3);

            IT_KoujyoSym koujyoSym4 = kykKihon1.createKoujyoSym();
            koujyoSym4.setNendo("2015");
            koujyoSym4.setTyouhyouymd(BizDate.valueOf("20160223"));
            koujyoSym4.setRenno(4);

            IT_KoujyoSym koujyoSym5 = kykKihon1.createKoujyoSym();
            koujyoSym5.setNendo("2016");
            koujyoSym5.setTyouhyouymd(BizDate.valueOf("20160224"));
            koujyoSym5.setRenno(5);

            hozenDomManager.insert(kykKihon1);

        }

        IT_KykKihon kykKihon2 = hozenDomManager.getKykKihon("11807111118");
        if( null == kykKihon2 ) {
            kykKihon2 = new IT_KykKihon("10", "11807111118");

            IT_KoujyoSym koujyoSym6 = kykKihon2.createKoujyoSym();
            koujyoSym6.setNendo("2016");
            koujyoSym6.setTyouhyouymd(BizDate.valueOf("20160223"));
            koujyoSym6.setRenno(6);

            hozenDomManager.insert(kykKihon2);
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

        Integer maxRenno = hozenDomManager.getKoujyoSymMaxRennoBySyonoNendoTyouhyouymd("11807111130", "2016", BizDate.valueOf("20160220"));
        Assert.assertEquals(null, maxRenno);
    }

    @Test
    @TestOrder(20)
    public void normal1() {

        Integer maxRenno = hozenDomManager.getKoujyoSymMaxRennoBySyonoNendoTyouhyouymd("11807111130", "2016", BizDate.valueOf("20160223"));
        Assert.assertEquals(Integer.valueOf(3), maxRenno);

    }

    @Test
    @TestOrder(30)
    public void blank1() {

        Integer maxRenno = hozenDomManager.getKoujyoSymMaxRennoBySyonoNendoTyouhyouymd("", "2016", BizDate.valueOf("20160223"));
        Assert.assertEquals(null, maxRenno);

    }

    @Test
    @TestOrder(40)
    public void blank2() {

        Integer maxRenno = hozenDomManager.getKoujyoSymMaxRennoBySyonoNendoTyouhyouymd("11807111130", "", BizDate.valueOf("20160223"));
        Assert.assertEquals(null, maxRenno);

    }
}
