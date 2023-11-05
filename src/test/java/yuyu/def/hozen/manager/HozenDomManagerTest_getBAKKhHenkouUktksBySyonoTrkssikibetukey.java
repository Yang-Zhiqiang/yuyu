package yuyu.def.hozen.manager;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;
import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.slcs.swak.core.inject.SWAKInjector;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.app.base.ref.TestDataMaker;
import yuyu.def.db.entity.IT_BAK_KhHenkouUktk;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * HozenDomManagerクラスの、<br />
 * getBAKKhHenkouUktksBySyonoTrkssikibetukey() メソッドのテストクラスです。
 */
@RunWith(OrderedRunner.class)
public class HozenDomManagerTest_getBAKKhHenkouUktksBySyonoTrkssikibetukey {

    private final static String fileName = "UT-SP_単体テスト仕様書（DomManager）_getBAKKhHenkouUktksBySyonoTrkssikibetukey";

    private final static String sheetName = "INデータ";

    @Inject
    HozenDomManager hozenDomManager;

    @BeforeClass
    @Transactional
    public static void preProcess() {

        deleteTestSubData();

        HozenDomManager hozenDomManager = SWAKInjector.getInstance(HozenDomManager.class);


        List<IT_BAK_KhHenkouUktk> bakKhHenkouUktkLst =
            hozenDomManager.getBAKKhHenkouUktksBySyonoTrkssikibetukey("17806000013", "1001");

        Assert.assertEquals(0, bakKhHenkouUktkLst.size());

        insertTestData();
    }

    @Transactional
    public static void insertTestData() {
        try {
            TestDataMaker testDataMaker = new TestDataMaker();
            HashMap<String, Map<String, List<Map<String, String>>>> testDataAndTblMap;
            testDataAndTblMap = testDataMaker.getInData(HozenDomManagerTest_getKhHenkouUktksBySyono1.class,
                fileName, sheetName);
            testDataMaker.insDataByDataId("データ001", testDataAndTblMap);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Transactional
    public static void deleteTestSubData() {


        HozenDomManager hozenDomManager = SWAKInjector.getInstance(HozenDomManager.class);
        hozenDomManager.delete(hozenDomManager.getAllBAKKhHenkouUktk());
    }

    @AfterClass
    @Transactional
    public static void deleteTestData() {

        deleteTestSubData();
    }

    @Test
    @TestOrder(10)
    public void noResult1() {


        List<IT_BAK_KhHenkouUktk> bakKhHenkouUktkLst =
            hozenDomManager.getBAKKhHenkouUktksBySyonoTrkssikibetukey("17806000024", "1002");

        Assert.assertEquals(0, bakKhHenkouUktkLst.size());
    }

    @Test
    @TestOrder(20)
    public void normal1() {


        List<IT_BAK_KhHenkouUktk> bakKhHenkouUktkLst =
            hozenDomManager.getBAKKhHenkouUktksBySyonoTrkssikibetukey("17806000013", "1001");

        Assert.assertEquals(1, bakKhHenkouUktkLst.size());

        Assert.assertEquals("01", bakKhHenkouUktkLst.get(0).getKbnkey());
        Assert.assertEquals("17806000013", bakKhHenkouUktkLst.get(0).getSyono());
        Assert.assertEquals("1001", bakKhHenkouUktkLst.get(0).getTrkssikibetukey());
        Assert.assertEquals(Integer.valueOf(10001), bakKhHenkouUktkLst.get(0).getHozenhenkouuktkrenno());
    }

    @Test
    @TestOrder(30)
    public void normal2() {


        List<IT_BAK_KhHenkouUktk> bakKhHenkouUktkLst =
            hozenDomManager.getBAKKhHenkouUktksBySyonoTrkssikibetukey("17806000046", "1004");

        Assert.assertEquals(3, bakKhHenkouUktkLst.size());
        Map<String, String> map = new HashMap<String, String>();
        map.put($("04", "17806000046", "1004", "10004"), "1");
        map.put($("04", "17806000046", "1004", "10005"), "1");
        map.put($("04", "17806000046", "1004", "10006"), "1");

        for (IT_BAK_KhHenkouUktk bakKhHenkouUktk : bakKhHenkouUktkLst) {
            map.remove($(bakKhHenkouUktk.getKbnkey(), bakKhHenkouUktk.getSyono(),
                bakKhHenkouUktk.getTrkssikibetukey(), bakKhHenkouUktk.getHozenhenkouuktkrenno()));
        }
        assertTrue(map.isEmpty());
    }

    @Test
    @TestOrder(40)
    public void blankCondition1() {

        List<IT_BAK_KhHenkouUktk> bakKhHenkouUktkLst =
            hozenDomManager.getBAKKhHenkouUktksBySyonoTrkssikibetukey("", "1001");

        Assert.assertEquals(0, bakKhHenkouUktkLst.size());
    }

    @Test
    @TestOrder(50)
    public void blankCondition2() {

        List<IT_BAK_KhHenkouUktk> bakKhHenkouUktkLst =
            hozenDomManager.getBAKKhHenkouUktksBySyonoTrkssikibetukey("17806000013", "");

        Assert.assertEquals(0, bakKhHenkouUktkLst.size());
    }

}
