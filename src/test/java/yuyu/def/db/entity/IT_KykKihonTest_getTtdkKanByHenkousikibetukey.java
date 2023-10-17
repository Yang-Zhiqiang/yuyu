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
 * 手続完了テーブルエンティティ情報取得(変更識別キー)<br />
 */
@RunWith(OrderedRunner.class)
public class IT_KykKihonTest_getTtdkKanByHenkousikibetukey {

    @Inject
    private HozenDomManager hozenDomManager;

    @BeforeClass
    @Transactional
    public static void insertTestData() {
        HozenDomManager hozenDomManager = SWAKInjector.getInstance(HozenDomManager.class);

        IT_KykKihon kykKihon1 = hozenDomManager.getKykKihon("11807111130");
        if (kykKihon1 == null) {
            kykKihon1 = new IT_KykKihon("10", "11807111130");

            IT_TtdkKan ttdkKan = kykKihon1.getTtdkKanByHenkousikibetukey("20160202");
            Assert.assertEquals(null, ttdkKan);

            IT_TtdkKan ttdkKan1 = kykKihon1.createTtdkKan();
            ttdkKan1.setHenkousikibetukey("20160202");

            IT_TtdkKan ttdkKan2 = kykKihon1.createTtdkKan();
            ttdkKan2.setHenkousikibetukey("20160203");

            hozenDomManager.insert(kykKihon1);

        }

        IT_KykKihon kykKihon2 = hozenDomManager.getKykKihon("11807111118");
        if (kykKihon2 == null) {

            kykKihon2 = new IT_KykKihon("10", "11807111118");

            IT_TtdkKan ttdkKan = kykKihon2.getTtdkKanByHenkousikibetukey("20160202");
            Assert.assertEquals(null, ttdkKan);

            IT_TtdkKan ttdkKan3 = kykKihon2.createTtdkKan();
            ttdkKan3.setHenkousikibetukey("20160202");

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
        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("11807111130");
        IT_TtdkKan ttdkKan = kykKihon.getTtdkKanByHenkousikibetukey("20160201");
        Assert.assertEquals(null, ttdkKan);

    }

    @Test
    @TestOrder(20)
    public void normal1() {
        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("11807111130");
        IT_TtdkKan ttdkKan = kykKihon.getTtdkKanByHenkousikibetukey("20160202");
        Assert.assertEquals("10", ttdkKan.getKbnkey());
        Assert.assertEquals("11807111130", ttdkKan.getSyono());
        Assert.assertEquals("20160202", ttdkKan.getHenkousikibetukey());

    }

    @Test
    @TestOrder(30)
    public void blank1() {
        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("11807111130");
        IT_TtdkKan ttdkKan = kykKihon.getTtdkKanByHenkousikibetukey("");
        Assert.assertEquals(null, ttdkKan);

    }

}
