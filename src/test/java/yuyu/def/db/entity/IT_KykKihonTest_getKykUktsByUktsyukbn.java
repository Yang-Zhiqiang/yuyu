package yuyu.def.db.entity;

import java.util.List;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.core.test.SWAKTestRunner;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.def.classification.C_UktsyuKbn;
import yuyu.def.hozen.manager.HozenDomManager;
import yuyu.testinfr.TestOrder;

/**
 * 契約受取人テーブルエンティティリスト取得(受取人種類区分)<br />
 */
@RunWith(SWAKTestRunner.class)
public class IT_KykKihonTest_getKykUktsByUktsyukbn {

    @Inject
    private HozenDomManager hozenDomManager;

    @BeforeClass
    @Transactional
    public static void insertTestData() {
        HozenDomManager hozenDomManager = SWAKInjector.getInstance(HozenDomManager.class);

        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("160");
        if (kykKihon == null) {
            kykKihon = new IT_KykKihon("1", "10000000060");
            Assert.assertEquals(0, kykKihon.getKykUktsByUktsyukbn(C_UktsyuKbn.SBUKT).size());
            IT_KykUkt kykUkt1 = kykKihon.createKykUkt();
            kykUkt1.setUktsyukbn(C_UktsyuKbn.SBUKT);
            kykUkt1.setUktsyurenno(1);

            IT_KykUkt kykUkt2 = kykKihon.createKykUkt();
            kykUkt2.setUktsyukbn(C_UktsyuKbn.SBUKT);
            kykUkt2.setUktsyurenno(2);

            IT_KykUkt kykUkt3 = kykKihon.createKykUkt();
            kykUkt3.setUktsyukbn(C_UktsyuKbn.SBUKT);
            kykUkt3.setUktsyurenno(3);

            IT_KykUkt kykUkt4 = kykKihon.createKykUkt();
            kykUkt4.setUktsyukbn(C_UktsyuKbn.NKUKT);
            kykUkt4.setUktsyurenno(3);

            hozenDomManager.insert(kykKihon);
        }

        IT_KykKihon kykKihon2 = hozenDomManager.getKykKihon("10000000061");
        if (kykKihon2 == null) {
            kykKihon2 = new IT_KykKihon("1", "10000000061");

            IT_KykUkt kykUkt3 = kykKihon2.createKykUkt();
            kykUkt3.setUktsyukbn(C_UktsyuKbn.STDRSK);
            kykUkt3.setUktsyurenno(1);

            hozenDomManager.insert(kykKihon2);
        }

        IT_KykKihon kykKihon3 = hozenDomManager.getKykKihon("10000000062");
        if (kykKihon3 == null) {
            kykKihon3 = new IT_KykKihon("1", "10000000062");

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
        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("10000000060");
        List<IT_KykUkt> kykKihonList = kykKihon.getKykUktsByUktsyukbn(C_UktsyuKbn.SONOTA);

        Assert.assertEquals(0, kykKihonList.size());
    }

    @Test
    @TestOrder(20)
    public void normal1() {
        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("10000000061");
        List<IT_KykUkt> kykKihonList = kykKihon.getKykUktsByUktsyukbn(C_UktsyuKbn.STDRSK);

        Assert.assertEquals(1, kykKihonList.size());

        Assert.assertEquals("10000000061", kykKihonList.get(0).getSyono());
        Assert.assertEquals("1", kykKihonList.get(0).getKbnkey());
        Assert.assertEquals(1, kykKihonList.get(0).getUktsyurenno().intValue());
        Assert.assertEquals(C_UktsyuKbn.STDRSK, kykKihonList.get(0).getUktsyukbn());

    }

    @Test
    @TestOrder(30)
    public void normal2() {
        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("10000000060");
        List<IT_KykUkt> kykKihonList = kykKihon.getKykUktsByUktsyukbn(C_UktsyuKbn.SBUKT);

        Assert.assertEquals(3, kykKihonList.size());

        Assert.assertEquals("10000000060", kykKihonList.get(0).getSyono());
        Assert.assertEquals("1", kykKihonList.get(0).getKbnkey());
        Assert.assertEquals(1, kykKihonList.get(0).getUktsyurenno().intValue());
        Assert.assertEquals(C_UktsyuKbn.SBUKT, kykKihonList.get(0).getUktsyukbn());

        Assert.assertEquals("10000000060", kykKihonList.get(1).getSyono());
        Assert.assertEquals("1", kykKihonList.get(1).getKbnkey());
        Assert.assertEquals(2, kykKihonList.get(1).getUktsyurenno().intValue());
        Assert.assertEquals(C_UktsyuKbn.SBUKT, kykKihonList.get(0).getUktsyukbn());

        Assert.assertEquals("10000000060", kykKihonList.get(2).getSyono());
        Assert.assertEquals("1", kykKihonList.get(2).getKbnkey());
        Assert.assertEquals(3, kykKihonList.get(2).getUktsyurenno().intValue());
        Assert.assertEquals(C_UktsyuKbn.SBUKT, kykKihonList.get(0).getUktsyukbn());
    }

}
