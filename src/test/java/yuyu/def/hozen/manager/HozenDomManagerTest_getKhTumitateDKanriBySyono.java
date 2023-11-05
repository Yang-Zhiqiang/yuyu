package yuyu.def.hozen.manager;

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
import yuyu.def.db.entity.IT_KhTumitateDKanri;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * HozenDomManagerクラスの、<br />
 * getKhTumitateDKanriBySyono() メソッドのテストクラスです。
 */
@RunWith(OrderedRunner.class)
public class HozenDomManagerTest_getKhTumitateDKanriBySyono {

    private final static String fileName = "UT-SP_単体テスト仕様書（DomManager）_getKhTumitateDKanriBySyono";

    private final static String sheetName = "INデータ";

    @Inject
    HozenDomManager hozenDomManager;

    @BeforeClass
    @Transactional
    public static void preProcess() {

        deleteTestSubData();

        HozenDomManager hozenDomManager = SWAKInjector.getInstance(HozenDomManager.class);

        List<IT_KhTumitateDKanri> khTumitateDKanriLst = hozenDomManager.getKhTumitateDKanriBySyono("11807111118");

        Assert.assertEquals(0, khTumitateDKanriLst.size());

        insertTestData();
    }

    @Transactional
    public static void insertTestData() {
        try {
            TestDataMaker testDataMaker = new TestDataMaker();
            HashMap<String, Map<String, List<Map<String, String>>>> testDataAndTblMap;
            testDataAndTblMap = testDataMaker.getInData(HozenDomManagerTest_getKhTumitateDKanriBySyono.class,
                fileName, sheetName);
            testDataMaker.insDataByDataId("データ001", testDataAndTblMap);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Transactional
    public static void deleteTestSubData() {

        HozenDomManager hozenDomManager = SWAKInjector.getInstance(HozenDomManager.class);
        hozenDomManager.delete(hozenDomManager.getAllKhTumitateDKanri());

    }

    @AfterClass
    @Transactional
    public static void deleteTestData() {

        deleteTestSubData();
    }

    @Test
    @TestOrder(10)
    public void noResult1() {

        List<IT_KhTumitateDKanri> khTumitateDKanriLst = hozenDomManager.getKhTumitateDKanriBySyono("11807111244");

        Assert.assertEquals(0, khTumitateDKanriLst.size());
    }

    @Test
    @TestOrder(20)
    public void normal1() {

        List<IT_KhTumitateDKanri> khTumitateDKanriLst = hozenDomManager.getKhTumitateDKanriBySyono("11807111118");

        Assert.assertEquals(1, khTumitateDKanriLst.size());

        Assert.assertEquals("01", khTumitateDKanriLst.get(0).getKbnkey());
        Assert.assertEquals("11807111118", khTumitateDKanriLst.get(0).getSyono());
        Assert.assertEquals(BizDate.valueOf(20181017), khTumitateDKanriLst.get(0).getTumitatedtumitateymd());
        Assert.assertEquals(1, khTumitateDKanriLst.get(0).getRenno().intValue());
    }

    @Test
    @TestOrder(30)
    public void normal2() {

        List<IT_KhTumitateDKanri> khTumitateDKanriLst = hozenDomManager.getKhTumitateDKanriBySyono("11807111129");

        Assert.assertEquals(5, khTumitateDKanriLst.size());

        Assert.assertEquals("02", khTumitateDKanriLst.get(0).getKbnkey());
        Assert.assertEquals("11807111129", khTumitateDKanriLst.get(0).getSyono());
        Assert.assertEquals(BizDate.valueOf(20181015), khTumitateDKanriLst.get(0).getTumitatedtumitateymd());
        Assert.assertEquals(1, khTumitateDKanriLst.get(0).getRenno().intValue());

        Assert.assertEquals("02", khTumitateDKanriLst.get(1).getKbnkey());
        Assert.assertEquals("11807111129", khTumitateDKanriLst.get(1).getSyono());
        Assert.assertEquals(BizDate.valueOf(20181015), khTumitateDKanriLst.get(1).getTumitatedtumitateymd());
        Assert.assertEquals(2, khTumitateDKanriLst.get(1).getRenno().intValue());

        Assert.assertEquals("02", khTumitateDKanriLst.get(2).getKbnkey());
        Assert.assertEquals("11807111129", khTumitateDKanriLst.get(2).getSyono());
        Assert.assertEquals(BizDate.valueOf(20181015), khTumitateDKanriLst.get(2).getTumitatedtumitateymd());
        Assert.assertEquals(3, khTumitateDKanriLst.get(2).getRenno().intValue());

        Assert.assertEquals("02", khTumitateDKanriLst.get(3).getKbnkey());
        Assert.assertEquals("11807111129", khTumitateDKanriLst.get(3).getSyono());
        Assert.assertEquals(BizDate.valueOf(20181016), khTumitateDKanriLst.get(3).getTumitatedtumitateymd());
        Assert.assertEquals(1, khTumitateDKanriLst.get(3).getRenno().intValue());

        Assert.assertEquals("02", khTumitateDKanriLst.get(4).getKbnkey());
        Assert.assertEquals("11807111129", khTumitateDKanriLst.get(4).getSyono());
        Assert.assertEquals(BizDate.valueOf(20181017), khTumitateDKanriLst.get(4).getTumitatedtumitateymd());
        Assert.assertEquals(1, khTumitateDKanriLst.get(4).getRenno().intValue());

    }

    @Test
    @TestOrder(40)
    public void blankCondition1() {

        List<IT_KhTumitateDKanri> khTumitateDKanriLst = hozenDomManager.getKhTumitateDKanriBySyono("");

        Assert.assertEquals(0, khTumitateDKanriLst.size());

    }
}
