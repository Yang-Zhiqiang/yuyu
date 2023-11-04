package yuyu.def.hozen.manager;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;
import static org.junit.Assert.*;

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
import yuyu.def.db.entity.IT_BAK_KhHaitouKanri;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * HozenDomManagerクラスの、<br />
 * getBAKKhHaitouKanriBySyonoTrkssikibetukey() メソッドのテストクラスです。
 */
@RunWith(OrderedRunner.class)
public class HozenDomManagerTest_getBAKKhHaitouKanriBySyonoTrkssikibetukey {

    private final static String fileName = "UT-SP_単体テスト仕様書（DomManager）_getBAKKhHaitouKanriBySyonoTrkssikibetukey";

    private final static String sheetName = "INデータ";

    @Inject
    HozenDomManager hozenDomManager;

    @BeforeClass
    @Transactional
    public static void preProcess() {

        deleteTestSubData();

        HozenDomManager hozenDomManager = SWAKInjector.getInstance(HozenDomManager.class);

        List<IT_BAK_KhHaitouKanri> bAKKhHaitouKanriLst = hozenDomManager.getBAKKhHaitouKanriBySyonoTrkssikibetukey("11807111118", "000000000000000001");

        Assert.assertEquals(0, bAKKhHaitouKanriLst.size());

        insertTestData();
    }

    @Transactional
    public static void insertTestData() {
        try {
            TestDataMaker testDataMaker = new TestDataMaker();
            HashMap<String, Map<String, List<Map<String, String>>>> testDataAndTblMap;
            testDataAndTblMap = testDataMaker.getInData(HozenDomManagerTest_getBAKKhHaitouKanriBySyonoTrkssikibetukey.class,
                fileName, sheetName);
            testDataMaker.insDataByDataId("データ001", testDataAndTblMap);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Transactional
    public static void deleteTestSubData() {

        HozenDomManager hozenDomManager = SWAKInjector.getInstance(HozenDomManager.class);
        hozenDomManager.delete(hozenDomManager.getAllBAKKhHaitouKanri());

    }

    @AfterClass
    @Transactional
    public static void deleteTestData() {

        deleteTestSubData();
    }

    @Test
    @TestOrder(10)
    public void noResult1() {

        List<IT_BAK_KhHaitouKanri> bAKKhHaitouKanriLst = hozenDomManager.getBAKKhHaitouKanriBySyonoTrkssikibetukey("11807111244", "000000000000000001");

        Assert.assertEquals(0, bAKKhHaitouKanriLst.size());
    }

    @Test
    @TestOrder(20)
    public void normal1() {

        List<IT_BAK_KhHaitouKanri> bAKKhHaitouKanriLst = hozenDomManager.getBAKKhHaitouKanriBySyonoTrkssikibetukey("11807111118", "000000000000000001");

        Assert.assertEquals(1, bAKKhHaitouKanriLst.size());

        Assert.assertEquals("01", bAKKhHaitouKanriLst.get(0).getKbnkey());
        Assert.assertEquals("11807111118", bAKKhHaitouKanriLst.get(0).getSyono());
        Assert.assertEquals("000000000000000001", bAKKhHaitouKanriLst.get(0).getTrkssikibetukey());
        Assert.assertEquals(BizDateY.valueOf(2018), bAKKhHaitouKanriLst.get(0).getHaitounendo());
        Assert.assertEquals(1, bAKKhHaitouKanriLst.get(0).getRenno().intValue());
        Assert.assertEquals(C_HaitoukinsksKbn.BLNK, bAKKhHaitouKanriLst.get(0).getHaitoukinskskbn());
        Assert.assertEquals(C_HaitoumeisaiKbn.SYU, bAKKhHaitouKanriLst.get(0).getHaitoumeisaikbn());
    }

    @Test
    @TestOrder(30)
    public void normal2() {

        List<IT_BAK_KhHaitouKanri> bAKKhHaitouKanriLst = hozenDomManager.getBAKKhHaitouKanriBySyonoTrkssikibetukey("11807111129", "000000000000000001");

        Assert.assertEquals(3, bAKKhHaitouKanriLst.size());
        Map<String, String> map = new HashMap<String, String>();
        map.put($("02", "11807111129", "000000000000000001", BizDateY.valueOf(2016), 3, C_HaitoukinsksKbn.BLNK, C_HaitoumeisaiKbn.SYU), "1");
        map.put($("02", "11807111129", "000000000000000001", BizDateY.valueOf(2016), 2, C_HaitoukinsksKbn.BLNK, C_HaitoumeisaiKbn.SYU), "1");
        map.put($("02", "11807111129", "000000000000000001", BizDateY.valueOf(2016), 1, C_HaitoukinsksKbn.BLNK, C_HaitoumeisaiKbn.SYU), "1");

        for (IT_BAK_KhHaitouKanri bAKKhHaitouKanri : bAKKhHaitouKanriLst) {
            map.remove($(bAKKhHaitouKanri.getKbnkey(), bAKKhHaitouKanri.getSyono(), bAKKhHaitouKanri
                .getTrkssikibetukey(), bAKKhHaitouKanri.getHaitounendo(), bAKKhHaitouKanri.getRenno().intValue(),
                bAKKhHaitouKanri.getHaitoukinskskbn(), bAKKhHaitouKanri.getHaitoumeisaikbn()));
        }
        assertTrue(map.isEmpty());
    }

    @Test
    @TestOrder(40)
    public void blankCondition1() {

        List<IT_BAK_KhHaitouKanri> bAKKhHaitouKanriLst = hozenDomManager.getBAKKhHaitouKanriBySyonoTrkssikibetukey("", "000000000000000001");

        Assert.assertEquals(0, bAKKhHaitouKanriLst.size());

    }

    @Test
    @TestOrder(50)
    public void blankCondition2() {

        List<IT_BAK_KhHaitouKanri> bAKKhHaitouKanriLst = hozenDomManager.getBAKKhHaitouKanriBySyonoTrkssikibetukey("11807111118", "");

        Assert.assertEquals(0, bAKKhHaitouKanriLst.size());

    }
}
