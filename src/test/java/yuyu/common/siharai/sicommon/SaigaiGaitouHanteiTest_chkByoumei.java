package yuyu.common.siharai.sicommon;

import static yuyu.testinfr.YuyuFunctionTestUtil.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.slcs.swak.core.inject.SWAKInjector;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.app.base.ref.TestDataMaker;
import yuyu.def.classification.C_SKNaiyouChkKbn;
import yuyu.def.siharai.manager.SiharaiDomManager;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * 災害該当判定クラスの災害該当判定（病名）メソッド {@link SaigaiGaitouHantei#chkByoumei(List<String>)}テスト用クラスです。<br />
 */
@RunWith(OrderedRunner.class)
public class SaigaiGaitouHanteiTest_chkByoumei {

    @Inject
    private SaigaiGaitouHantei saigaiGaitouHantei;

    private final static String fileName = "UT-SP_単体テスト仕様書（共通）_災害該当判定";

    private final static String sheetName = "INデータ";
    @BeforeClass
    @Transactional
    public static void insertTestData() {
        try {
            TestDataMaker testDataMaker = new TestDataMaker();
            HashMap<String, Map<String, List<Map<String, String>>>> testDataAndTblMap;
            testDataAndTblMap = testDataMaker.getInData(SaigaiGaitouHanteiTest_chkByoumei.class, fileName, sheetName);
            testDataMaker.insDataByDataId("データ001", testDataAndTblMap);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @AfterClass
    @Transactional
    public static void deleteTestData() {
        SiharaiDomManager siharaiDomManager = SWAKInjector.getInstance(SiharaiDomManager.class);
        siharaiDomManager.delete(siharaiDomManager.getAllByoumei());
    }

    @Test
    @TestOrder(210)
    public void testChkByoumei_A1() {

        boolean result = saigaiGaitouHantei.chkByoumei(null, C_SKNaiyouChkKbn.SATEICHK_SAIGAI_BYOUMEI);

        exBooleanEquals(result, false, "判定結果フラグ");
    }

    @Test
    @TestOrder(220)
    public void testChkByoumei_A2() {

        List<String> byoumeiTourokuNoLst = new ArrayList<>();

        boolean result = saigaiGaitouHantei.chkByoumei(byoumeiTourokuNoLst, C_SKNaiyouChkKbn.SATEICHK_SAIGAI_BYOUMEI);

        exBooleanEquals(result, false, "判定結果フラグ");
    }

    @Test
    @TestOrder(230)
    public void testChkByoumei_A3() {

        List<String> byoumeiTourokuNoLst = new ArrayList<>();
        byoumeiTourokuNoLst.add("100001");

        boolean result = saigaiGaitouHantei.chkByoumei(byoumeiTourokuNoLst, C_SKNaiyouChkKbn.SATEICHK_SAIGAI_BYOUMEI);

        exBooleanEquals(result, false, "判定結果フラグ");
    }

    @Test
    @TestOrder(240)
    public void testChkByoumei_A4() {

        List<String> byoumeiTourokuNoLst = new ArrayList<>();
        byoumeiTourokuNoLst.add("100001");
        byoumeiTourokuNoLst.add("100003");
        byoumeiTourokuNoLst.add("100005");

        boolean result = saigaiGaitouHantei.chkByoumei(byoumeiTourokuNoLst,
            C_SKNaiyouChkKbn.SATEICHK_SGSBJISATUMENSEKI_BYOUMEI);

        exBooleanEquals(result, false, "判定結果フラグ");
    }

    @Test
    @TestOrder(250)
    public void testChkByoumei_A5() {

        List<String> byoumeiTourokuNoLst = new ArrayList<>();
        byoumeiTourokuNoLst.add("100005");

        boolean result = saigaiGaitouHantei.chkByoumei(byoumeiTourokuNoLst, C_SKNaiyouChkKbn.SATEICHK_SAIGAI_BYOUMEI);

        exBooleanEquals(result, true, "判定結果フラグ");
    }

    @Test
    @TestOrder(260)
    public void testChkByoumei_A6() {

        List<String> byoumeiTourokuNoLst = new ArrayList<>();
        byoumeiTourokuNoLst.add("100003");
        byoumeiTourokuNoLst.add("100005");
        byoumeiTourokuNoLst.add("100006");

        boolean result = saigaiGaitouHantei.chkByoumei(byoumeiTourokuNoLst, C_SKNaiyouChkKbn.SATEICHK_SAIGAI_BYOUMEI);

        exBooleanEquals(result, true, "判定結果フラグ");
    }

    @Test
    @TestOrder(270)
    public void testChkByoumei_A7() {

        List<String> byoumeiTourokuNoLst = new ArrayList<>();
        byoumeiTourokuNoLst.add("100004");

        boolean result = saigaiGaitouHantei.chkByoumei(byoumeiTourokuNoLst,
            C_SKNaiyouChkKbn.SATEICHK_SGSBJISATUMENSEKI_BYOUMEI);

        exBooleanEquals(result, true, "判定結果フラグ");
    }

    @Test
    @TestOrder(280)
    public void testChkByoumei_A8() {

        List<String> byoumeiTourokuNoLst = new ArrayList<>();
        byoumeiTourokuNoLst.add("100004");

        boolean result = saigaiGaitouHantei.chkByoumei(byoumeiTourokuNoLst, C_SKNaiyouChkKbn.SATEICHK_SAIGAI_BYOUMEI);

        exBooleanEquals(result, true, "判定結果フラグ");
    }

    @Test
    @TestOrder(290)
    public void testChkByoumei_A9() {

        List<String> byoumeiTourokuNoLst = new ArrayList<>();
        byoumeiTourokuNoLst.add("100006");

        boolean result = saigaiGaitouHantei.chkByoumei(byoumeiTourokuNoLst, C_SKNaiyouChkKbn.SATEICHK_SAIGAI_BYOUMEI);

        exBooleanEquals(result, false, "判定結果フラグ");
    }

}
