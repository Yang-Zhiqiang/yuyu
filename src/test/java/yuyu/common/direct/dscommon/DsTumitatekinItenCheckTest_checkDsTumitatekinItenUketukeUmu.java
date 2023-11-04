package yuyu.common.direct.dscommon;

import static yuyu.testinfr.YuyuFunctionTestUtil.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.transaction.Transactional;

import jp.co.slcs.swak.core.inject.SWAKInjector;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.app.base.ref.TestDataMaker;
import yuyu.def.classification.C_UmuKbn;
import yuyu.def.direct.manager.DirectDomManager;
import yuyu.def.hozen.manager.HozenDomManager;
import yuyu.testinfr.AbstractTest;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * ＤＳ積立金移転共通チェッククラスのメソッド {@link DsTumitatekinItenCheck#checkDsTumitatekinItenUketukeUmu(String)} テスト用クラスです。<br />
 */
@RunWith(OrderedRunner.class)
public class DsTumitatekinItenCheckTest_checkDsTumitatekinItenUketukeUmu extends AbstractTest{

    private final static String fileName = "UT-SP_単体テスト仕様書（共通）_ＤＳ積立金移転共通チェック";

    private final static String sheetName = "INデータ";

    @BeforeClass
    @Transactional
    public static void insertTestData() {
        try {
            TestDataMaker testDataMaker = new TestDataMaker();
            HashMap<String, Map<String, List<Map<String, String>>>> testDataAndTblMap;
            testDataAndTblMap = testDataMaker.getInData(DsTumitatekinItenCheckTest_checkDsTumitatekinItenUketukeUmu.class, fileName, sheetName);
            testDataMaker.insDataByDataId("データ001", testDataAndTblMap);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @AfterClass
    @Transactional
    public static void deleteTestData() {

        HozenDomManager hozenDomManager = SWAKInjector.getInstance(HozenDomManager.class);
        hozenDomManager.delete(hozenDomManager.getAllKykKihon());
        hozenDomManager.delete(hozenDomManager.getAllKhHenkouUktk());
        DirectDomManager directDomManager = SWAKInjector.getInstance(DirectDomManager.class);
        directDomManager.delete(directDomManager.getAllKhHenkouUktkYyk());
    }


    @Test
    @TestOrder(10)
    public void testCheckDsTumitatekinItenUketukeUmu_A1() {

        DsTumitatekinItenCheck dsTumitatekinItenCheck = SWAKInjector.getInstance(DsTumitatekinItenCheck.class);

        C_UmuKbn tumitatekinUtSyoruiKbn =
            dsTumitatekinItenCheck.checkDsTumitatekinItenUketukeUmu("17806000079");

        exClassificationEquals(tumitatekinUtSyoruiKbn, C_UmuKbn.ARI, "有無区分");
    }

    @Test
    @TestOrder(20)
    public void testCheckDsTumitatekinItenUketukeUmu_A2() {

        DsTumitatekinItenCheck dsTumitatekinItenCheck = SWAKInjector.getInstance(DsTumitatekinItenCheck.class);

        C_UmuKbn tumitatekinUtSyoruiKbn =
            dsTumitatekinItenCheck.checkDsTumitatekinItenUketukeUmu("17806000068");

        exClassificationEquals(tumitatekinUtSyoruiKbn, C_UmuKbn.ARI, "有無区分");
    }
    @Test
    @TestOrder(30)
    public void testCheckDsTumitatekinItenUketukeUmu_A3() {

        DsTumitatekinItenCheck dsTumitatekinItenCheck = SWAKInjector.getInstance(DsTumitatekinItenCheck.class);

        C_UmuKbn tumitatekinUtSyoruiKbn =
            dsTumitatekinItenCheck.checkDsTumitatekinItenUketukeUmu("18808000087");

        exClassificationEquals(tumitatekinUtSyoruiKbn, C_UmuKbn.ARI, "有無区分");
    }

    @Test
    @TestOrder(40)
    public void testCheckDsTumitatekinItenUketukeUmu_A4() {

        DsTumitatekinItenCheck dsTumitatekinItenCheck = SWAKInjector.getInstance(DsTumitatekinItenCheck.class);

        C_UmuKbn tumitatekinUtSyoruiKbn =
            dsTumitatekinItenCheck.checkDsTumitatekinItenUketukeUmu("18808000098");

        exClassificationEquals(tumitatekinUtSyoruiKbn, C_UmuKbn.NONE, "有無区分");
    }

}
