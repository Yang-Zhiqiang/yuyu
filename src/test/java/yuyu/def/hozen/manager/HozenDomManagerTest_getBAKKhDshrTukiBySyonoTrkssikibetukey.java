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
import yuyu.def.db.entity.IT_BAK_KhDshrTuki;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * HozenDomManagerクラスの、<br />
 * getBAKKhDshrTukiBySyonoTrkssikibetukey() メソッドのテストクラスです。
 */
@RunWith(OrderedRunner.class)
public class HozenDomManagerTest_getBAKKhDshrTukiBySyonoTrkssikibetukey {

    private final static String fileName = "UT-SP_単体テスト仕様書（DomManager）_getBAKKhDshrTukiBySyonoTrkssikibetukey";

    private final static String sheetName = "INデータ";

    @Inject
    HozenDomManager hozenDomManager;

    @BeforeClass
    @Transactional
    public static void preProcess() {

        deleteTestSubData();

        HozenDomManager hozenDomManager = SWAKInjector.getInstance(HozenDomManager.class);

        List<IT_BAK_KhDshrTuki> bAK_bAK_KhDshrTukiLst = hozenDomManager.getBAKKhDshrTukiBySyonoTrkssikibetukey("11807111118", "000000000000000001");

        Assert.assertEquals(0, bAK_bAK_KhDshrTukiLst.size());

        insertTestData();
    }

    @Transactional
    public static void insertTestData() {
        try {
            TestDataMaker testDataMaker = new TestDataMaker();
            HashMap<String, Map<String, List<Map<String, String>>>> testDataAndTblMap;
            testDataAndTblMap = testDataMaker.getInData(HozenDomManagerTest_getBAKKhDshrTukiBySyonoTrkssikibetukey.class,
                fileName, sheetName);
            testDataMaker.insDataByDataId("データ001", testDataAndTblMap);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Transactional
    public static void deleteTestSubData() {

        HozenDomManager hozenDomManager = SWAKInjector.getInstance(HozenDomManager.class);
        hozenDomManager.delete(hozenDomManager.getAllBAKKhDshrTuki());

    }

    @AfterClass
    @Transactional
    public static void deleteTestData() {

        deleteTestSubData();
    }

    @Test
    @TestOrder(10)
    public void noResult1() {

        List<IT_BAK_KhDshrTuki> bAK_KhDshrTukiLst = hozenDomManager.getBAKKhDshrTukiBySyonoTrkssikibetukey("11807111244", "000000000000000001");

        Assert.assertEquals(0, bAK_KhDshrTukiLst.size());
    }

    @Test
    @TestOrder(20)
    public void normal1() {

        List<IT_BAK_KhDshrTuki> bAK_KhDshrTukiLst = hozenDomManager.getBAKKhDshrTukiBySyonoTrkssikibetukey("11807111118", "000000000000000001");

        Assert.assertEquals(1, bAK_KhDshrTukiLst.size());

        Assert.assertEquals("1001", bAK_KhDshrTukiLst.get(0).getDshrtoukeisikibetukey());
        Assert.assertEquals("11807111118", bAK_KhDshrTukiLst.get(0).getSyono());
        Assert.assertEquals("000000000000000001", bAK_KhDshrTukiLst.get(0).getTrkssikibetukey());
    }

    @Test
    @TestOrder(30)
    public void normal2() {

        List<IT_BAK_KhDshrTuki> bAK_KhDshrTukiLst = hozenDomManager.getBAKKhDshrTukiBySyonoTrkssikibetukey("11807111129", "000000000000000001");

        Assert.assertEquals(3, bAK_KhDshrTukiLst.size());
        Map<String, String> map = new HashMap<String, String>();
        map.put($("1002", "11807111129", "000000000000000001"), "1");
        map.put($("1003", "11807111129", "000000000000000001"), "1");
        map.put($("1004", "11807111129", "000000000000000001"), "1");

        for (IT_BAK_KhDshrTuki bAk_KhDshrTuki : bAK_KhDshrTukiLst) {
            map.remove($(bAk_KhDshrTuki.getDshrtoukeisikibetukey(), bAk_KhDshrTuki.getSyono(), bAk_KhDshrTuki.getTrkssikibetukey()));
        }
        assertTrue(map.isEmpty());

    }

    @Test
    @TestOrder(40)
    public void blankCondition1() {

        List<IT_BAK_KhDshrTuki> bAK_KhDshrTukiLst = hozenDomManager.getBAKKhDshrTukiBySyonoTrkssikibetukey("", "000000000000000001");

        Assert.assertEquals(0, bAK_KhDshrTukiLst.size());

    }

    @Test
    @TestOrder(50)
    public void blankCondition2() {

        List<IT_BAK_KhDshrTuki> bAK_KhDshrTukiLst = hozenDomManager.getBAKKhDshrTukiBySyonoTrkssikibetukey("11807111118", "");

        Assert.assertEquals(0, bAK_KhDshrTukiLst.size());

    }
}
