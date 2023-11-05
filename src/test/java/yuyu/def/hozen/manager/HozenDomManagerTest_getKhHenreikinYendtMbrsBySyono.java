package yuyu.def.hozen.manager;

import java.util.HashMap;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;
import static org.junit.Assert.*;

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
import yuyu.def.db.entity.IT_KhHenreikin;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * HozenDomManagerクラスの、<br />
 * getKhHenreikinYendtMbrsBySyono() メソッドのテストクラスです。
 */
@RunWith(OrderedRunner.class)
public class HozenDomManagerTest_getKhHenreikinYendtMbrsBySyono {

    private final static String fileName = "UT-SP_単体テスト仕様書（DomManager）_getKhHenreikinYendtMbrsBySyono";

    private final static String sheetName = "INデータ";

    @Inject
    HozenDomManager hozenDomManager;

    @BeforeClass
    @Transactional
    public static void preProcess() {

        deleteTestSubData();

        HozenDomManager hozenDomManager = SWAKInjector.getInstance(HozenDomManager.class);

        List<IT_KhHenreikin> khHenreikinLst = hozenDomManager.getKhHenreikinYendtMbrsBySyono("11807111118");

        Assert.assertEquals(0, khHenreikinLst.size());

        insertTestData();
    }

    @Transactional
    public static void insertTestData() {
        try {
            TestDataMaker testDataMaker = new TestDataMaker();
            HashMap<String, Map<String, List<Map<String, String>>>> testDataAndTblMap;
            testDataAndTblMap = testDataMaker.getInData(HozenDomManagerTest_getKhHenreikinYendtMbrsBySyono.class,
                fileName, sheetName);
            testDataMaker.insDataByDataId("データ001", testDataAndTblMap);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Transactional
    public static void deleteTestSubData() {

        HozenDomManager hozenDomManager = SWAKInjector.getInstance(HozenDomManager.class);
        hozenDomManager.delete(hozenDomManager.getAllKykKihon());

    }

    @AfterClass
    @Transactional
    public static void deleteTestData() {

        deleteTestSubData();
    }

    @Test
    @TestOrder(10)
    public void noResult1() {

        List<IT_KhHenreikin> khHenreikinLst = hozenDomManager.getKhHenreikinYendtMbrsBySyono("11807111244");

        Assert.assertEquals(0, khHenreikinLst.size());
    }

    @Test
    @TestOrder(20)
    public void normal1() {

        List<IT_KhHenreikin> khHenreikinLst = hozenDomManager.getKhHenreikinYendtMbrsBySyono("11807111118");

        Assert.assertEquals(1, khHenreikinLst.size());

        Assert.assertEquals("01", khHenreikinLst.get(0).getKbnkey());
        Assert.assertEquals("11807111118", khHenreikinLst.get(0).getSyono());
        Assert.assertEquals("201801231035123456", khHenreikinLst.get(0).getHenkousikibetukey());
    }

    @Test
    @TestOrder(30)
    public void normal2() {

        List<IT_KhHenreikin> khHenreikinLst = hozenDomManager.getKhHenreikinYendtMbrsBySyono("11807111129");

        Assert.assertEquals(3, khHenreikinLst.size());
        Map<String, String> map = new HashMap<String, String>();
        map.put($("02", "11807111129", "201801231035123456"), "1");
        map.put($("02", "11807111129", "201801231035123457"), "1");
        map.put($("02", "11807111129", "201801231035123458"), "1");

        for (IT_KhHenreikin khHenreikin : khHenreikinLst) {
            map.remove($(khHenreikin.getKbnkey(), khHenreikin.getSyono(), khHenreikin.getHenkousikibetukey()));
        }
        assertTrue(map.isEmpty());
    }

    @Test
    @TestOrder(40)
    public void blankCondition1() {

        List<IT_KhHenreikin> khHenreikinLst = hozenDomManager.getKhHenreikinYendtMbrsBySyono("");

        Assert.assertEquals(0, khHenreikinLst.size());

    }
}
