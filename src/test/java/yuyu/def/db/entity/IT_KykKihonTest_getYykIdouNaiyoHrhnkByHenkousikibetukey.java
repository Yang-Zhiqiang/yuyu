package yuyu.def.db.entity;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.slcs.swak.core.inject.SWAKInjector;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.def.hozen.manager.HozenDomManager;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * 予約異動受付内容（払方変更）テーブルのテストクラス<br />
 */
@RunWith(OrderedRunner.class)
public class IT_KykKihonTest_getYykIdouNaiyoHrhnkByHenkousikibetukey {
    @Inject
    private HozenDomManager hozenDomManager;

    @BeforeClass
    @Transactional
    public static void insertTestData() {
        HozenDomManager hozenDomManager = SWAKInjector.getInstance(HozenDomManager.class);

        IT_KykKihon kykKihon1 = hozenDomManager.getKykKihon("11807111130");
        if (kykKihon1 == null) {
            kykKihon1 = new IT_KykKihon("10", "11807111130");

            IT_YykIdouNaiyoHrhnk yykIdouNaiyoHrhnk = kykKihon1.getYykIdouNaiyoHrhnkByHenkousikibetukey("M001");
            Assert.assertEquals(null, yykIdouNaiyoHrhnk);

            IT_YykIdouNaiyoHrhnk yykIdouNaiyoHrhnk1 = kykKihon1.createYykIdouNaiyoHrhnk();
            yykIdouNaiyoHrhnk1.setHenkousikibetukey("M001");

            IT_YykIdouNaiyoHrhnk yykIdouNaiyoHrhnk2 = kykKihon1.createYykIdouNaiyoHrhnk();
            yykIdouNaiyoHrhnk2.setHenkousikibetukey("M002");

            hozenDomManager.insert(kykKihon1);
        }

        IT_KykKihon kykKihon2 = hozenDomManager.getKykKihon("11807111118");
        if (kykKihon2 == null) {
            kykKihon2 = new IT_KykKihon("10", "11807111118");

            IT_YykIdouNaiyoHrhnk yykIdouNaiyoHrhnk3 = kykKihon2.createYykIdouNaiyoHrhnk();
            yykIdouNaiyoHrhnk3.setHenkousikibetukey("M001");

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
    @TestOrder(20)
    public void noResult1() {

        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("11807111130");
        IT_YykIdouNaiyoHrhnk yykIdouNaiyoHrhnk = kykKihon.getYykIdouNaiyoHrhnkByHenkousikibetukey("M003");
        Assert.assertEquals(null, yykIdouNaiyoHrhnk);
    }

    @Test
    @TestOrder(30)
    public void normal1() {

        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("11807111130");
        IT_YykIdouNaiyoHrhnk yykIdouNaiyoHrhnk = kykKihon.getYykIdouNaiyoHrhnkByHenkousikibetukey("M001");

        Assert.assertEquals("M001", yykIdouNaiyoHrhnk.getHenkousikibetukey());
        Assert.assertEquals("11807111130", yykIdouNaiyoHrhnk.getSyono());
        Assert.assertEquals("10", yykIdouNaiyoHrhnk.getKbnkey());

    }

    @Test
    @TestOrder(40)
    public void blank1() {

        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("11807111130");
        IT_YykIdouNaiyoHrhnk yykIdouNaiyoHrhnk = kykKihon.getYykIdouNaiyoHrhnkByHenkousikibetukey("");
        Assert.assertEquals(null, yykIdouNaiyoHrhnk);

    }
}
