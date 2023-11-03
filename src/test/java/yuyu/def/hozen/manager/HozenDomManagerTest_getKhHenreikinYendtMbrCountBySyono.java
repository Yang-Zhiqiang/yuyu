package yuyu.def.hozen.manager;

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
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * HozenDomManagerクラスの、<br />
 * getKhHenreikinYendtMbrCountBySyono() メソッドのテストクラスです。
 */
@RunWith(OrderedRunner.class)
public class HozenDomManagerTest_getKhHenreikinYendtMbrCountBySyono {

    private final static String fileName = "UT-SP_単体テスト仕様書（DomManager）_getKhHenreikinYendtMbrCountBySyono";

    private final static String sheetName = "INデータ";

    @Inject
    HozenDomManager hozenDomManager;

    @BeforeClass
    @Transactional
    public static void preProcess() {

        deleteTestSubData();

        HozenDomManager hozenDomManager = SWAKInjector.getInstance(HozenDomManager.class);

        Long khHenreikinKns = hozenDomManager.getKhHenreikinYendtMbrCountBySyono("11807111129");

        Assert.assertEquals(0, khHenreikinKns.intValue());

        insertTestData();
    }

    @Transactional
    public static void insertTestData() {
        try {
            TestDataMaker testDataMaker = new TestDataMaker();
            HashMap<String, Map<String, List<Map<String, String>>>> testDataAndTblMap;
            testDataAndTblMap = testDataMaker.getInData(HozenDomManagerTest_getKhHenreikinYendtMbrCountBySyono.class,
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

        Long khHenreikinKns = hozenDomManager.getKhHenreikinYendtMbrCountBySyono("11807111244");

        Assert.assertEquals(0, khHenreikinKns.intValue());
    }

    @Test
    @TestOrder(20)
    public void normal1() {

        Long khHenreikinKns = hozenDomManager.getKhHenreikinYendtMbrCountBySyono("11807111129");

        Assert.assertEquals(3, khHenreikinKns.intValue());
    }

    @Test
    @TestOrder(30)
    public void blankCondition1() {

        Long khHenreikinKns = hozenDomManager.getKhHenreikinYendtMbrCountBySyono("");

        Assert.assertEquals(0, khHenreikinKns.intValue());

    }
}
