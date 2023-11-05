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
import yuyu.def.db.entity.IT_NyuukinKakusyouData;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * HozenDomManagerクラスの、<br />
 * getNyuukinKakusyouDataBySyono() メソッドのテストクラスです。
 */
@RunWith(OrderedRunner.class)
public class HozenDomManagerTest_getNyuukinKakusyouDataBySyono {

    private final static String fileName = "UT-SP_単体テスト仕様書（DomManager）_getNyuukinKakusyouDataBySyono";

    private final static String sheetName = "INデータ";

    @Inject
    HozenDomManager hozenDomManager;

    @BeforeClass
    @Transactional
    public static void preProcess() {

        deleteTestSubData();

        HozenDomManager hozenDomManager = SWAKInjector.getInstance(HozenDomManager.class);

        List<IT_NyuukinKakusyouData> nyuukinKakusyouDataLst = hozenDomManager.getNyuukinKakusyouDataBySyono("11807111118");

        Assert.assertEquals(0, nyuukinKakusyouDataLst.size());

        insertTestData();
    }

    @Transactional
    public static void insertTestData() {
        try {
            TestDataMaker testDataMaker = new TestDataMaker();
            HashMap<String, Map<String, List<Map<String, String>>>> testDataAndTblMap;
            testDataAndTblMap = testDataMaker.getInData(HozenDomManagerTest_getNyuukinKakusyouDataBySyono.class,
                fileName, sheetName);
            testDataMaker.insDataByDataId("データ001", testDataAndTblMap);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Transactional
    public static void deleteTestSubData() {

        HozenDomManager hozenDomManager = SWAKInjector.getInstance(HozenDomManager.class);
        hozenDomManager.delete(hozenDomManager.getAllNyuukinKakusyouData());

    }

    @AfterClass
    @Transactional
    public static void deleteTestData() {

        deleteTestSubData();
    }

    @Test
    @TestOrder(10)
    public void noResult1() {

        List<IT_NyuukinKakusyouData> nyuukinKakusyouDataLst = hozenDomManager.getNyuukinKakusyouDataBySyono("11807111244");

        Assert.assertEquals(0, nyuukinKakusyouDataLst.size());
    }

    @Test
    @TestOrder(20)
    public void normal1() {

        List<IT_NyuukinKakusyouData> nyuukinKakusyouDataLst = hozenDomManager.getNyuukinKakusyouDataBySyono("11807111118");

        Assert.assertEquals(1, nyuukinKakusyouDataLst.size());

        Assert.assertEquals("01", nyuukinKakusyouDataLst.get(0).getKbnkey());
        Assert.assertEquals("11807111118", nyuukinKakusyouDataLst.get(0).getNyuukinkakusyouno());
        Assert.assertEquals("11807111118", nyuukinKakusyouDataLst.get(0).getSyono());
    }

    @Test
    @TestOrder(30)
    public void normal2() {

        List<IT_NyuukinKakusyouData> nyuukinKakusyouDataLst = hozenDomManager.getNyuukinKakusyouDataBySyono("11807111129");

        Assert.assertEquals(3, nyuukinKakusyouDataLst.size());
        Map<String, String> map = new HashMap<String, String>();
        map.put($("02", "118071111293", "11807111129"), "1");
        map.put($("02", "118071111291", "11807111129"), "1");
        map.put($("02", "118071111292", "11807111129"), "1");

        for (IT_NyuukinKakusyouData nyuukinKakusyouData : nyuukinKakusyouDataLst) {
            map.remove($(nyuukinKakusyouData.getKbnkey(), nyuukinKakusyouData.getNyuukinkakusyouno(), nyuukinKakusyouData.getSyono()));
        }
        assertTrue(map.isEmpty());
    }

    @Test
    @TestOrder(40)
    public void blankCondition1() {

        List<IT_NyuukinKakusyouData> nyuukinKakusyouDataLst = hozenDomManager.getNyuukinKakusyouDataBySyono("");

        Assert.assertEquals(0, nyuukinKakusyouDataLst.size());

    }
}
