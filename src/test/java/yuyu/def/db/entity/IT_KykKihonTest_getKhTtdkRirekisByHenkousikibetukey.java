package yuyu.def.db.entity;

import java.util.List;

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
 * 契約保全手続履歴テーブルのテストクラス<br />
 */
@RunWith(OrderedRunner.class)
public class IT_KykKihonTest_getKhTtdkRirekisByHenkousikibetukey {
    @Inject
    private HozenDomManager hozenDomManager;

    @BeforeClass
    @Transactional
    public static void insertTestData() {
        HozenDomManager hozenDomManager = SWAKInjector.getInstance(HozenDomManager.class);

        IT_KykKihon kykKihon1 = hozenDomManager.getKykKihon("10000000060");
        if (kykKihon1 == null) {
            kykKihon1 = new IT_KykKihon("10","10000000060");
            List<IT_KhTtdkRireki> khTtdkRirekiLst = kykKihon1.getKhTtdkRirekisByHenkousikibetukey("ASD124");
            Assert.assertEquals(0, khTtdkRirekiLst.size());

            IT_KhTtdkRireki khTtdkRireki1 = kykKihon1.createKhTtdkRireki();
            khTtdkRireki1.setHenkousikibetukey("ASD123");

            IT_KhTtdkRireki khTtdkRireki2 = kykKihon1.createKhTtdkRireki();
            khTtdkRireki2.setHenkousikibetukey("ASD124");

            IT_KhTtdkRireki khTtdkRireki3 = kykKihon1.createKhTtdkRireki();
            khTtdkRireki3.setHenkousikibetukey("ASD125");

            IT_KhTtdkRireki khTtdkRireki4 = kykKihon1.createKhTtdkRireki();
            khTtdkRireki4.setHenkousikibetukey("ASD100");

            hozenDomManager.insert(kykKihon1);
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
        List<IT_KhTtdkRireki> khTtdkRirekiLst = kykKihon.getKhTtdkRirekisByHenkousikibetukey("ASD200");
        Assert.assertEquals(0, khTtdkRirekiLst.size());
    }

    @Test
    @TestOrder(20)
    public void normal1() {
        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("10000000060");
        List<IT_KhTtdkRireki> khTtdkRirekiLst = kykKihon.getKhTtdkRirekisByHenkousikibetukey("ASD124");
        Assert.assertEquals(1, khTtdkRirekiLst.size());

        Assert.assertEquals("10", khTtdkRirekiLst.get(0).getKbnkey());
        Assert.assertEquals("10000000060", khTtdkRirekiLst.get(0).getSyono());
        Assert.assertEquals("ASD125", khTtdkRirekiLst.get(0).getHenkousikibetukey());
    }

    @Test
    @TestOrder(30)
    public void normal2() {
        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("10000000060");
        List<IT_KhTtdkRireki> khTtdkRirekiLst = kykKihon.getKhTtdkRirekisByHenkousikibetukey("ASD120");
        Assert.assertEquals(3, khTtdkRirekiLst.size());

        Assert.assertEquals("10", khTtdkRirekiLst.get(0).getKbnkey());
        Assert.assertEquals("10000000060", khTtdkRirekiLst.get(0).getSyono());
        Assert.assertEquals("ASD123", khTtdkRirekiLst.get(0).getHenkousikibetukey());

        Assert.assertEquals("10", khTtdkRirekiLst.get(1).getKbnkey());
        Assert.assertEquals("10000000060", khTtdkRirekiLst.get(1).getSyono());
        Assert.assertEquals("ASD124", khTtdkRirekiLst.get(1).getHenkousikibetukey());

        Assert.assertEquals("10", khTtdkRirekiLst.get(2).getKbnkey());
        Assert.assertEquals("10000000060", khTtdkRirekiLst.get(2).getSyono());
        Assert.assertEquals("ASD125", khTtdkRirekiLst.get(2).getHenkousikibetukey());
    }
    @Test
    @TestOrder(40)
    public void blankCondition1() {
        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("10000000060");
        List<IT_KhTtdkRireki> khTtdkRirekiLst = kykKihon.getKhTtdkRirekisByHenkousikibetukey("");
        Assert.assertEquals(4, khTtdkRirekiLst.size());

        Assert.assertEquals("10", khTtdkRirekiLst.get(0).getKbnkey());
        Assert.assertEquals("10000000060", khTtdkRirekiLst.get(0).getSyono());
        Assert.assertEquals("ASD100", khTtdkRirekiLst.get(0).getHenkousikibetukey());

        Assert.assertEquals("10", khTtdkRirekiLst.get(1).getKbnkey());
        Assert.assertEquals("10000000060", khTtdkRirekiLst.get(1).getSyono());
        Assert.assertEquals("ASD123", khTtdkRirekiLst.get(1).getHenkousikibetukey());

        Assert.assertEquals("10", khTtdkRirekiLst.get(2).getKbnkey());
        Assert.assertEquals("10000000060", khTtdkRirekiLst.get(2).getSyono());
        Assert.assertEquals("ASD124", khTtdkRirekiLst.get(2).getHenkousikibetukey());

        Assert.assertEquals("10", khTtdkRirekiLst.get(3).getKbnkey());
        Assert.assertEquals("10000000060", khTtdkRirekiLst.get(3).getSyono());
        Assert.assertEquals("ASD125", khTtdkRirekiLst.get(3).getHenkousikibetukey());

    }
}
