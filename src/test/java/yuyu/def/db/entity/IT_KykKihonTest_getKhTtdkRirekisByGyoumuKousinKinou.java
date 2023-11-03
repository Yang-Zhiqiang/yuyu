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
public class IT_KykKihonTest_getKhTtdkRirekisByGyoumuKousinKinou {

    @Inject
    private HozenDomManager hozenDomManager;
    @BeforeClass
    @Transactional
    public static void insertTestData() {
        HozenDomManager hozenDomManager = SWAKInjector.getInstance(HozenDomManager.class);

        IT_KykKihon kykKihon1 = hozenDomManager.getKykKihon("11807111118");

        if (kykKihon1 == null) {

            kykKihon1 = new IT_KykKihon("01", "11807111118");

            List<IT_KhTtdkRireki> khTtdkRirekiLst = kykKihon1.getKhTtdkRirekisByGyoumuKousinKinou("10000000001");

            Assert.assertEquals(0, khTtdkRirekiLst.size());

            IT_KhTtdkRireki khTtdkRireki1 = kykKihon1.createKhTtdkRireki();
            khTtdkRireki1.setHenkousikibetukey("201520161001");
            khTtdkRireki1.setGyoumuKousinKinou("10000000001");

            IT_KhTtdkRireki khTtdkRireki2 = kykKihon1.createKhTtdkRireki();
            khTtdkRireki2.setHenkousikibetukey("201520161002");
            khTtdkRireki2.setGyoumuKousinKinou("10000000002");

            hozenDomManager.insert(kykKihon1);
        }

        IT_KykKihon kykKihon2 = new IT_KykKihon("02", "11807111129");

        IT_KhTtdkRireki khTtdkRireki3 = kykKihon2.createKhTtdkRireki();
        khTtdkRireki3.setHenkousikibetukey("201520161003");
        khTtdkRireki3.setGyoumuKousinKinou("10000000003");

        IT_KhTtdkRireki khTtdkRireki4 = kykKihon2.createKhTtdkRireki();
        khTtdkRireki4.setHenkousikibetukey("201520161004");
        khTtdkRireki4.setGyoumuKousinKinou("10000000003");

        IT_KhTtdkRireki khTtdkRireki5 = kykKihon2.createKhTtdkRireki();
        khTtdkRireki5.setHenkousikibetukey("201520161005");
        khTtdkRireki5.setGyoumuKousinKinou("10000000003");

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

        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("11807111118");

        List<IT_KhTtdkRireki> khTtdkRirekiLst = kykKihon.getKhTtdkRirekisByGyoumuKousinKinou("10000000004");

        Assert.assertEquals(0, khTtdkRirekiLst.size());
    }

    @Test
    @TestOrder(20)
    public void normal1() {

        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("11807111118");

        List<IT_KhTtdkRireki> khTtdkRirekiLst = kykKihon.getKhTtdkRirekisByGyoumuKousinKinou("10000000001");

        Assert.assertEquals(1, khTtdkRirekiLst.size());


        Assert.assertEquals("01", khTtdkRirekiLst.get(0).getKbnkey());
        Assert.assertEquals("11807111118", khTtdkRirekiLst.get(0).getSyono());
        Assert.assertEquals("201520161001", khTtdkRirekiLst.get(0).getHenkousikibetukey());

    }

    @Test
    @TestOrder(30)
    public void normal2() {

        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("11807111129");

        List<IT_KhTtdkRireki> khTtdkRirekiLst = kykKihon.getKhTtdkRirekisByGyoumuKousinKinou("10000000003");

        Assert.assertEquals(3, khTtdkRirekiLst.size());

        Assert.assertEquals("02", khTtdkRirekiLst.get(0).getKbnkey());
        Assert.assertEquals("11807111129", khTtdkRirekiLst.get(0).getSyono());
        Assert.assertEquals("201520161003", khTtdkRirekiLst.get(0).getHenkousikibetukey());

        Assert.assertEquals("02", khTtdkRirekiLst.get(1).getKbnkey());
        Assert.assertEquals("11807111129", khTtdkRirekiLst.get(1).getSyono());
        Assert.assertEquals("201520161004", khTtdkRirekiLst.get(1).getHenkousikibetukey());

        Assert.assertEquals("02", khTtdkRirekiLst.get(2).getKbnkey());
        Assert.assertEquals("11807111129", khTtdkRirekiLst.get(2).getSyono());
        Assert.assertEquals("201520161005", khTtdkRirekiLst.get(2).getHenkousikibetukey());

    }
    @Test
    @TestOrder(40)
    public void blankCondition1() {

        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("11807111118");

        List<IT_KhTtdkRireki> khTtdkRirekiLst = kykKihon.getKhTtdkRirekisByGyoumuKousinKinou("");

        Assert.assertEquals(0, khTtdkRirekiLst.size());

    }
}

