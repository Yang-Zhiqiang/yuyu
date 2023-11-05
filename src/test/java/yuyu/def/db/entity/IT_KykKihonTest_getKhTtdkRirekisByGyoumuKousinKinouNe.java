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
 * 控除証明内容テーブルのテストクラス<br />
 */
@RunWith(OrderedRunner.class)
public class IT_KykKihonTest_getKhTtdkRirekisByGyoumuKousinKinouNe {

    @Inject
    private HozenDomManager hozenDomManager;

    @BeforeClass
    @Transactional
    public static void insertTestData() {
        HozenDomManager hozenDomManager = SWAKInjector.getInstance(HozenDomManager.class);

        IT_KykKihon kykKihon1 = hozenDomManager.getKykKihon("11807111118");

        if ( kykKihon1 == null) {
            kykKihon1 = new IT_KykKihon("10","11807111118");
            Assert.assertEquals(0, kykKihon1.getKhTtdkRirekisByGyoumuKousinKinouNe("aa001").size());

            IT_KhTtdkRireki khTtdkRireki1 = kykKihon1.createKhTtdkRireki();
            khTtdkRireki1.setHenkousikibetukey("1");
            khTtdkRireki1.setGyoumuKousinKinou("aa001");

            hozenDomManager.insert(kykKihon1);
        }

        IT_KykKihon kykKihon2 = hozenDomManager.getKykKihon("11807111129");

        if ( kykKihon2 == null) {

            kykKihon2 = new IT_KykKihon("10","11807111129");

            IT_KhTtdkRireki khTtdkRireki2 = kykKihon2.createKhTtdkRireki();
            khTtdkRireki2.setHenkousikibetukey("2");
            khTtdkRireki2.setGyoumuKousinKinou("aa002");

            hozenDomManager.insert(kykKihon2);
        }

        IT_KykKihon kykKihon3 = hozenDomManager.getKykKihon("11807111130");

        if ( kykKihon3 == null) {

            kykKihon3 = new IT_KykKihon("10","11807111130");

            IT_KhTtdkRireki khTtdkRireki3 = kykKihon3.createKhTtdkRireki();
            khTtdkRireki3.setHenkousikibetukey("3");
            khTtdkRireki3.setGyoumuKousinKinou("aa003");

            IT_KhTtdkRireki khTtdkRireki4 = kykKihon3.createKhTtdkRireki();
            khTtdkRireki4.setHenkousikibetukey("4");
            khTtdkRireki4.setGyoumuKousinKinou("aa004");

            IT_KhTtdkRireki khTtdkRireki5 = kykKihon3.createKhTtdkRireki();
            khTtdkRireki5.setHenkousikibetukey("5");
            khTtdkRireki5.setGyoumuKousinKinou("aa005");

            hozenDomManager.insert(kykKihon3);
        }

        IT_KykKihon kykKihon6 = hozenDomManager.getKykKihon("11807111141");

        if ( kykKihon6 == null) {

            kykKihon6 = new IT_KykKihon("10","11807111141");

            IT_KhTtdkRireki khTtdkRireki6 = kykKihon6.createKhTtdkRireki();
            khTtdkRireki6.setHenkousikibetukey("6");
            khTtdkRireki6.setGyoumuKousinKinou("aa006");

            hozenDomManager.insert(kykKihon6);
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
        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("11807111118");
        List<IT_KhTtdkRireki> khTtdkRirekiLst = kykKihon.getKhTtdkRirekisByGyoumuKousinKinouNe("aa001");

        Assert.assertEquals(0, khTtdkRirekiLst.size());
    }

    @Test
    @TestOrder(20)
    public void normal1() {
        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("11807111129");
        List<IT_KhTtdkRireki> khTtdkRirekiLst = kykKihon.getKhTtdkRirekisByGyoumuKousinKinouNe("aa001");

        Assert.assertEquals(1, khTtdkRirekiLst.size());
        Assert.assertEquals("10", khTtdkRirekiLst.get(0).getKbnkey());
        Assert.assertEquals("11807111129", khTtdkRirekiLst.get(0).getSyono());
        Assert.assertEquals("2", khTtdkRirekiLst.get(0).getHenkousikibetukey());

    }

    @Test
    @TestOrder(30)
    public void normal2() {
        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("11807111130");
        List<IT_KhTtdkRireki> khTtdkRirekiLst = kykKihon.getKhTtdkRirekisByGyoumuKousinKinouNe("aa002");

        Assert.assertEquals(3, khTtdkRirekiLst.size());
        Assert.assertEquals("10", khTtdkRirekiLst.get(0).getKbnkey());
        Assert.assertEquals("11807111130", khTtdkRirekiLst.get(0).getSyono());
        Assert.assertEquals("3", khTtdkRirekiLst.get(0).getHenkousikibetukey());

        Assert.assertEquals("10", khTtdkRirekiLst.get(1).getKbnkey());
        Assert.assertEquals("11807111130", khTtdkRirekiLst.get(1).getSyono());
        Assert.assertEquals("4", khTtdkRirekiLst.get(1).getHenkousikibetukey());

        Assert.assertEquals("10", khTtdkRirekiLst.get(2).getKbnkey());
        Assert.assertEquals("11807111130", khTtdkRirekiLst.get(2).getSyono());
        Assert.assertEquals("5", khTtdkRirekiLst.get(2).getHenkousikibetukey());
    }

    @Test
    @TestOrder(40)
    public void blankCondition1() {
        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("11807111118");
        List<IT_KhTtdkRireki> khTtdkRirekiLst = kykKihon.getKhTtdkRirekisByGyoumuKousinKinouNe("");

        Assert.assertEquals(1, khTtdkRirekiLst.size());
        Assert.assertEquals("10", khTtdkRirekiLst.get(0).getKbnkey());
        Assert.assertEquals("11807111118", khTtdkRirekiLst.get(0).getSyono());
        Assert.assertEquals("1", khTtdkRirekiLst.get(0).getHenkousikibetukey());
    }
}
