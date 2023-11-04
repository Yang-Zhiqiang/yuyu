package yuyu.def.hozen.manager;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDateY;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.app.base.ref.TestDataMaker;
import yuyu.def.classification.C_HaitoukinsksKbn;
import yuyu.def.classification.C_HaitoumeisaiKbn;
import yuyu.def.db.entity.IT_KhHaitouKanri;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * HozenDomManagerクラスの、<br />
 * getKhHaitouKanriBySyono() メソッドのテストクラスです。
 */
@RunWith(OrderedRunner.class)
public class HozenDomManagerTest_getKhHaitouKanriBySyono {

    private final static String fileName = "UT-SP_単体テスト仕様書（DomManager）_getKhHaitouKanriBySyono";

    private final static String sheetName = "INデータ";

    @Inject
    HozenDomManager hozenDomManager;

    @BeforeClass
    @Transactional
    public static void preProcess() {

        deleteTestSubData();

        HozenDomManager hozenDomManager = SWAKInjector.getInstance(HozenDomManager.class);

        List<IT_KhHaitouKanri> khHaitouKanriLst = hozenDomManager.getKhHaitouKanriBySyono("11807111118");

        Assert.assertEquals(0, khHaitouKanriLst.size());

        insertTestData();
    }

    @Transactional
    public static void insertTestData() {
        try {
            TestDataMaker testDataMaker = new TestDataMaker();
            HashMap<String, Map<String, List<Map<String, String>>>> testDataAndTblMap;
            testDataAndTblMap = testDataMaker.getInData(HozenDomManagerTest_getKhHaitouKanriBySyono.class,
                fileName, sheetName);
            testDataMaker.insDataByDataId("データ001", testDataAndTblMap);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Transactional
    public static void deleteTestSubData() {

        HozenDomManager hozenDomManager = SWAKInjector.getInstance(HozenDomManager.class);
        hozenDomManager.delete(hozenDomManager.getAllKhHaitouKanri());

    }

    @AfterClass
    @Transactional
    public static void deleteTestData() {

        deleteTestSubData();
    }

    @Test
    @TestOrder(10)
    public void noResult1() {

        List<IT_KhHaitouKanri> khHaitouKanriLst = hozenDomManager.getKhHaitouKanriBySyono("11807111244");

        Assert.assertEquals(0, khHaitouKanriLst.size());
    }

    @Test
    @TestOrder(20)
    public void normal1() {

        List<IT_KhHaitouKanri> khHaitouKanriLst = hozenDomManager.getKhHaitouKanriBySyono("11807111118");

        Assert.assertEquals(1, khHaitouKanriLst.size());

        Assert.assertEquals("01", khHaitouKanriLst.get(0).getKbnkey());
        Assert.assertEquals("11807111118", khHaitouKanriLst.get(0).getSyono());
        Assert.assertEquals(BizDateY.valueOf(2018), khHaitouKanriLst.get(0).getHaitounendo());
        Assert.assertEquals(1, khHaitouKanriLst.get(0).getRenno().intValue());
        Assert.assertEquals(C_HaitoukinsksKbn.BLNK, khHaitouKanriLst.get(0).getHaitoukinskskbn());
        Assert.assertEquals(C_HaitoumeisaiKbn.SYU, khHaitouKanriLst.get(0).getHaitoumeisaikbn());
    }

    @Test
    @TestOrder(30)
    public void normal2() {

        List<IT_KhHaitouKanri> khHaitouKanriLst = hozenDomManager.getKhHaitouKanriBySyono("11807111129");

        Assert.assertEquals(8, khHaitouKanriLst.size());

        Assert.assertEquals("02", khHaitouKanriLst.get(0).getKbnkey());
        Assert.assertEquals("11807111129", khHaitouKanriLst.get(0).getSyono());
        Assert.assertEquals(BizDateY.valueOf(2016), khHaitouKanriLst.get(0).getHaitounendo());
        Assert.assertEquals(1, khHaitouKanriLst.get(0).getRenno().intValue());
        Assert.assertEquals(C_HaitoukinsksKbn.KARIWARIATE1, khHaitouKanriLst.get(0).getHaitoukinskskbn());
        Assert.assertEquals(C_HaitoumeisaiKbn.BLNK, khHaitouKanriLst.get(0).getHaitoumeisaikbn());

        Assert.assertEquals("02", khHaitouKanriLst.get(1).getKbnkey());
        Assert.assertEquals("11807111129", khHaitouKanriLst.get(1).getSyono());
        Assert.assertEquals(BizDateY.valueOf(2016), khHaitouKanriLst.get(1).getHaitounendo());
        Assert.assertEquals(1, khHaitouKanriLst.get(1).getRenno().intValue());
        Assert.assertEquals(C_HaitoukinsksKbn.KARIWARIATE1, khHaitouKanriLst.get(1).getHaitoukinskskbn());
        Assert.assertEquals(C_HaitoumeisaiKbn.SYU, khHaitouKanriLst.get(1).getHaitoumeisaikbn());

        Assert.assertEquals("02", khHaitouKanriLst.get(2).getKbnkey());
        Assert.assertEquals("11807111129", khHaitouKanriLst.get(2).getSyono());
        Assert.assertEquals(BizDateY.valueOf(2016), khHaitouKanriLst.get(2).getHaitounendo());
        Assert.assertEquals(1, khHaitouKanriLst.get(2).getRenno().intValue());
        Assert.assertEquals(C_HaitoukinsksKbn.KARIWARIATE2, khHaitouKanriLst.get(2).getHaitoukinskskbn());
        Assert.assertEquals(C_HaitoumeisaiKbn.SYU, khHaitouKanriLst.get(2).getHaitoumeisaikbn());

        Assert.assertEquals("02", khHaitouKanriLst.get(3).getKbnkey());
        Assert.assertEquals("11807111129", khHaitouKanriLst.get(3).getSyono());
        Assert.assertEquals(BizDateY.valueOf(2016), khHaitouKanriLst.get(3).getHaitounendo());
        Assert.assertEquals(1, khHaitouKanriLst.get(3).getRenno().intValue());
        Assert.assertEquals(C_HaitoukinsksKbn.KARIWARIATE3, khHaitouKanriLst.get(3).getHaitoukinskskbn());
        Assert.assertEquals(C_HaitoumeisaiKbn.SYU, khHaitouKanriLst.get(3).getHaitoumeisaikbn());

        Assert.assertEquals("02", khHaitouKanriLst.get(4).getKbnkey());
        Assert.assertEquals("11807111129", khHaitouKanriLst.get(4).getSyono());
        Assert.assertEquals(BizDateY.valueOf(2016), khHaitouKanriLst.get(4).getHaitounendo());
        Assert.assertEquals(2, khHaitouKanriLst.get(4).getRenno().intValue());
        Assert.assertEquals(C_HaitoukinsksKbn.BLNK, khHaitouKanriLst.get(4).getHaitoukinskskbn());
        Assert.assertEquals(C_HaitoumeisaiKbn.SYU, khHaitouKanriLst.get(4).getHaitoumeisaikbn());

        Assert.assertEquals("02", khHaitouKanriLst.get(5).getKbnkey());
        Assert.assertEquals("11807111129", khHaitouKanriLst.get(5).getSyono());
        Assert.assertEquals(BizDateY.valueOf(2016), khHaitouKanriLst.get(5).getHaitounendo());
        Assert.assertEquals(3, khHaitouKanriLst.get(5).getRenno().intValue());
        Assert.assertEquals(C_HaitoukinsksKbn.BLNK, khHaitouKanriLst.get(5).getHaitoukinskskbn());
        Assert.assertEquals(C_HaitoumeisaiKbn.SYU, khHaitouKanriLst.get(5).getHaitoumeisaikbn());

        Assert.assertEquals("02", khHaitouKanriLst.get(6).getKbnkey());
        Assert.assertEquals("11807111129", khHaitouKanriLst.get(6).getSyono());
        Assert.assertEquals(BizDateY.valueOf(2017), khHaitouKanriLst.get(6).getHaitounendo());
        Assert.assertEquals(2, khHaitouKanriLst.get(6).getRenno().intValue());
        Assert.assertEquals(C_HaitoukinsksKbn.BLNK, khHaitouKanriLst.get(6).getHaitoukinskskbn());
        Assert.assertEquals(C_HaitoumeisaiKbn.SYU, khHaitouKanriLst.get(6).getHaitoumeisaikbn());

        Assert.assertEquals("02", khHaitouKanriLst.get(7).getKbnkey());
        Assert.assertEquals("11807111129", khHaitouKanriLst.get(7).getSyono());
        Assert.assertEquals(BizDateY.valueOf(2018), khHaitouKanriLst.get(7).getHaitounendo());
        Assert.assertEquals(1, khHaitouKanriLst.get(7).getRenno().intValue());
        Assert.assertEquals(C_HaitoukinsksKbn.BLNK, khHaitouKanriLst.get(7).getHaitoukinskskbn());
        Assert.assertEquals(C_HaitoumeisaiKbn.SYU, khHaitouKanriLst.get(7).getHaitoumeisaikbn());
    }

    @Test
    @TestOrder(40)
    public void blankCondition1() {

        List<IT_KhHaitouKanri> khHaitouKanriLst = hozenDomManager.getKhHaitouKanriBySyono("");

        Assert.assertEquals(0, khHaitouKanriLst.size());

    }
}
