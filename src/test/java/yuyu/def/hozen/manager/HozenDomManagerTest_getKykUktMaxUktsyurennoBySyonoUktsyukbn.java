package yuyu.def.hozen.manager;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.slcs.swak.core.inject.SWAKInjector;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.def.classification.C_Tdk;
import yuyu.def.classification.C_UktsyuKbn;
import yuyu.def.db.entity.IT_KykKihon;
import yuyu.def.db.entity.IT_KykUkt;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * HozenDomManagerクラスの、<br />
 * getKykUktMaxUktsyurennoBySyonoUktsyukbn() メソッドのテストクラスです。
 */
@RunWith(OrderedRunner.class)
public class HozenDomManagerTest_getKykUktMaxUktsyurennoBySyonoUktsyukbn {

    @Inject
    HozenDomManager hozenDomManager;

    @BeforeClass
    @Transactional
    public static void insertTestData() {

        HozenDomManager hozenDomManager = SWAKInjector.getInstance(HozenDomManager.class);

        IT_KykUkt kykUkt = hozenDomManager.getKykUktMaxUktsyurennoBySyonoUktsyukbn("10000000060",C_UktsyuKbn.SBUKT);
        Assert.assertEquals(null, kykUkt);


        IT_KykKihon kykKihon1 = new IT_KykKihon("10", "10000000060");

        IT_KykUkt kykUkt1 = kykKihon1.createKykUkt();
        kykUkt1.setUktsyukbn(C_UktsyuKbn.valueOf("1"));
        kykUkt1.setUktsyurenno(3);
        kykUkt1.setUktnmkn("アイウエ");
        kykUkt1.setUktnmkj("亜入雨画");
        kykUkt1.setUkttdk(C_Tdk.valueOf("1"));

        IT_KykUkt kykUkt2 = kykKihon1.createKykUkt();
        kykUkt2.setUktsyukbn(C_UktsyuKbn.valueOf("2"));
        kykUkt2.setUktsyurenno(8);
        kykUkt2.setUktnmkn("アイウエ");
        kykUkt2.setUktnmkj("亜入雨画");
        kykUkt2.setUkttdk(C_Tdk.valueOf("1"));

        IT_KykUkt kykUkt4 = kykKihon1.createKykUkt();
        kykUkt4.setUktsyukbn(C_UktsyuKbn.valueOf("1"));
        kykUkt4.setUktsyurenno(7);
        kykUkt4.setUktnmkn("アイウエ");
        kykUkt4.setUktnmkj("亜入雨画");
        kykUkt4.setUkttdk(C_Tdk.valueOf("1"));

        hozenDomManager.insert(kykKihon1);

        IT_KykKihon kykKihon2 = new IT_KykKihon("10", "10000000070");

        IT_KykUkt kykUkt3 = kykKihon2.createKykUkt();
        kykUkt3.setUktsyukbn(C_UktsyuKbn.valueOf("1"));
        kykUkt3.setUktsyurenno(9);
        kykUkt3.setUktnmkn("アイウエ");
        kykUkt3.setUktnmkj("亜入雨画");
        kykUkt3.setUkttdk(C_Tdk.valueOf("1"));

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
    public void noResult1() {

        IT_KykUkt kykUkt = hozenDomManager.getKykUktMaxUktsyurennoBySyonoUktsyukbn("10000000080",C_UktsyuKbn.SBUKT);
        Assert.assertEquals(null, kykUkt);

    }

    @Test
    @TestOrder(20)
    public void blank() {

        IT_KykUkt kykUkt = hozenDomManager.getKykUktMaxUktsyurennoBySyonoUktsyukbn("",C_UktsyuKbn.SBUKT);
        Assert.assertEquals(null, kykUkt);

    }
    @Test
    @TestOrder(30)
    public void normal1() {

        IT_KykUkt kykUkt = hozenDomManager.getKykUktMaxUktsyurennoBySyonoUktsyukbn("10000000060",C_UktsyuKbn.SBUKT);

        Assert.assertEquals("10000000060", kykUkt.getSyono());
        Assert.assertEquals(C_UktsyuKbn.SBUKT, kykUkt.getUktsyukbn());
        Assert.assertEquals(7, kykUkt.getUktsyurenno().intValue());
        Assert.assertEquals("アイウエ", kykUkt.getUktnmkn());
        Assert.assertEquals("亜入雨画", kykUkt.getUktnmkj());
        Assert.assertEquals(C_Tdk.HONNIN, kykUkt.getUkttdk());

    }
}
