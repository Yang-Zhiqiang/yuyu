package yuyu.def.db.entity;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.slcs.swak.core.inject.SWAKInjector;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.def.classification.C_UktsyuKbn;
import yuyu.def.hozen.manager.HozenDomManager;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * 契約受取人テーブルのテストクラス<br />
 */
@RunWith(OrderedRunner.class)
public class IT_KykKihonTest_getKykUktsByUktsyukbnUktsyurenno {
    @Inject
    private HozenDomManager hozenDomManager;

    @BeforeClass
    @Transactional
    public static void insertTestData() {
        HozenDomManager hozenDomManager = SWAKInjector.getInstance(HozenDomManager.class);

        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("10000000060");
        if (kykKihon == null) {
            kykKihon = new IT_KykKihon("10","10000000060");
            Assert.assertEquals(null, kykKihon.getKykUktsByUktsyukbnUktsyurenno(C_UktsyuKbn.SBUKT, 5));
            IT_KykUkt kykUkt = kykKihon.createKykUkt();
            kykUkt.setUktsyukbn(C_UktsyuKbn.SBUKT);
            kykUkt.setUktsyurenno(5);

            IT_KykUkt kykUkt1 = kykKihon.createKykUkt();
            kykUkt1.setUktsyukbn(C_UktsyuKbn.STDRSK);
            kykUkt1.setUktsyurenno(5);

            IT_KykUkt kykUkt2 = kykKihon.createKykUkt();
            kykUkt2.setUktsyukbn(C_UktsyuKbn.SBUKT);
            kykUkt2.setUktsyurenno(6);
            hozenDomManager.insert(kykKihon);
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
        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("10000000060");
        IT_KykUkt kykUkt = kykKihon.getKykUktsByUktsyukbnUktsyurenno(C_UktsyuKbn.SBUKT, 4);

        Assert.assertEquals(null, kykUkt);
    }

    @Test
    @TestOrder(20)
    public void normal1() {
        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("10000000060");
        IT_KykUkt kykUkt = kykKihon.getKykUktsByUktsyukbnUktsyurenno(C_UktsyuKbn.SBUKT, 5);

        Assert.assertEquals("10", kykUkt.getKbnkey());
        Assert.assertEquals("10000000060", kykUkt.getSyono());
        Assert.assertEquals(C_UktsyuKbn.SBUKT, kykUkt.getUktsyukbn());
        Assert.assertEquals(5, kykUkt.getUktsyurenno().intValue());
    }
}
