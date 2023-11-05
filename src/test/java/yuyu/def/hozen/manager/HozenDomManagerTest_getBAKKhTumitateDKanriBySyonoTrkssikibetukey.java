package yuyu.def.hozen.manager;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;
import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.app.base.ref.TestDataMaker;
import yuyu.def.db.entity.IT_BAK_KhTumitateDKanri;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * HozenDomManagerクラスの、<br />
 * getBAKKhTumitateDKanriBySyonoTrkssikibetukey() メソッドのテストクラスです。
 */
@RunWith(OrderedRunner.class)
public class HozenDomManagerTest_getBAKKhTumitateDKanriBySyonoTrkssikibetukey {

    private final static String fileName = "UT-SP_単体テスト仕様書（DomManager）_getBAKKhTumitateDKanriBySyonoTrkssikibetukey";

    private final static String sheetName = "INデータ";

    @Inject
    HozenDomManager hozenDomManager;

    @BeforeClass
    @Transactional
    public static void preProcess() {

        deleteTestSubData();

        HozenDomManager hozenDomManager = SWAKInjector.getInstance(HozenDomManager.class);

        List<IT_BAK_KhTumitateDKanri> bAKKhTumitateDKanriLst = hozenDomManager.getBAKKhTumitateDKanriBySyonoTrkssikibetukey("11807111118", "000000000000000001");

        Assert.assertEquals(0, bAKKhTumitateDKanriLst.size());

        insertTestData();
    }

    @Transactional
    public static void insertTestData() {
        try {
            TestDataMaker testDataMaker = new TestDataMaker();
            HashMap<String, Map<String, List<Map<String, String>>>> testDataAndTblMap;
            testDataAndTblMap = testDataMaker.getInData(HozenDomManagerTest_getBAKKhTumitateDKanriBySyonoTrkssikibetukey.class,
                fileName, sheetName);
            testDataMaker.insDataByDataId("データ001", testDataAndTblMap);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Transactional
    public static void deleteTestSubData() {

        HozenDomManager hozenDomManager = SWAKInjector.getInstance(HozenDomManager.class);
        hozenDomManager.delete(hozenDomManager.getAllBAKKhTumitateDKanri());

    }

    @AfterClass
    @Transactional
    public static void deleteTestData() {

        deleteTestSubData();
    }

    @Test
    @TestOrder(10)
    public void noResult1() {

        List<IT_BAK_KhTumitateDKanri> bAKKhTumitateDKanriLst = hozenDomManager.getBAKKhTumitateDKanriBySyonoTrkssikibetukey("11807111244", "000000000000000001");

        Assert.assertEquals(0, bAKKhTumitateDKanriLst.size());
    }

    @Test
    @TestOrder(20)
    public void normal1() {

        List<IT_BAK_KhTumitateDKanri> bAKKhTumitateDKanriLst = hozenDomManager.getBAKKhTumitateDKanriBySyonoTrkssikibetukey("11807111118", "000000000000000001");

        Assert.assertEquals(1, bAKKhTumitateDKanriLst.size());

        Assert.assertEquals("01", bAKKhTumitateDKanriLst.get(0).getKbnkey());
        Assert.assertEquals("11807111118", bAKKhTumitateDKanriLst.get(0).getSyono());
        Assert.assertEquals("000000000000000001", bAKKhTumitateDKanriLst.get(0).getTrkssikibetukey());
        Assert.assertEquals(BizDate.valueOf(20181017), bAKKhTumitateDKanriLst.get(0).getTumitatedtumitateymd());
        Assert.assertEquals(1, bAKKhTumitateDKanriLst.get(0).getRenno().intValue());
    }

    @Test
    @TestOrder(30)
    public void normal2() {

        List<IT_BAK_KhTumitateDKanri> bAKKhTumitateDKanriLst = hozenDomManager.getBAKKhTumitateDKanriBySyonoTrkssikibetukey("11807111129", "000000000000000001");

        Assert.assertEquals(3, bAKKhTumitateDKanriLst.size());
        Map<String, String> map = new HashMap<String, String>();
        map.put($("02", "11807111129", "000000000000000001", BizDate.valueOf(20181015), 1), "1");
        map.put($("02", "11807111129", "000000000000000001", BizDate.valueOf(20181015), 2), "1");
        map.put($("02", "11807111129", "000000000000000001", BizDate.valueOf(20181015), 3), "1");

        for (IT_BAK_KhTumitateDKanri bAKKhTumitateDKanri : bAKKhTumitateDKanriLst) {
            map.remove($(bAKKhTumitateDKanri.getKbnkey(), bAKKhTumitateDKanri.getSyono(),
                bAKKhTumitateDKanri.getTrkssikibetukey(), bAKKhTumitateDKanri.getTumitatedtumitateymd(),
                bAKKhTumitateDKanri.getRenno().intValue()));
        }
        assertTrue(map.isEmpty());
    }

    @Test
    @TestOrder(40)
    public void blankCondition1() {

        List<IT_BAK_KhTumitateDKanri> bAKKhTumitateDKanriLst = hozenDomManager.getBAKKhTumitateDKanriBySyonoTrkssikibetukey("", "000000000000000001");

        Assert.assertEquals(0, bAKKhTumitateDKanriLst.size());

    }

    @Test
    @TestOrder(50)
    public void blankCondition2() {

        List<IT_BAK_KhTumitateDKanri> bAKKhTumitateDKanriLst = hozenDomManager.getBAKKhTumitateDKanriBySyonoTrkssikibetukey("11807111118", "");

        Assert.assertEquals(0, bAKKhTumitateDKanriLst.size());

    }
}
