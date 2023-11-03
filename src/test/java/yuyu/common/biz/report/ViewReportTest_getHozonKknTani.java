package yuyu.common.biz.report;

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
import yuyu.def.base.manager.BaseDomManager;
import yuyu.def.classification.C_SyoruiCdKbn;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * {@link ViewReport}クラスに含まれる、{@link ViewReport#getHozonKknTani (C_SyoruiCdKbn)} メソッドのテストです。 * <br />
 */
@RunWith(OrderedRunner.class)
public class ViewReportTest_getHozonKknTani {

    private C_SyoruiCdKbn syoruicdkbn;
    private static String result;
    private static String expect;

    private final static String fileName = "UT-SP_単体テスト仕様書（共通）_帳票表示用の各種データ編集";

    private final static String sheetName = "INデータ";

    @BeforeClass
    @Transactional
    public static void resetDefaultVal(){
        result = null;
        expect = null;

        try {
            TestDataMaker testDataMaker = new TestDataMaker();
            HashMap<String, Map<String, List<Map<String, String>>>> testDataAndTblMap;
            testDataAndTblMap = testDataMaker.getInData(ViewReportTest_getHozonKknTani.class, fileName, sheetName);
            testDataMaker.insDataByDataId("データ001", testDataAndTblMap);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @AfterClass
    @Transactional
    public static void deleteTestData() {

        BaseDomManager baseDomManager = SWAKInjector.getInstance(BaseDomManager.class);
        baseDomManager.delete(baseDomManager.getAllSyoruiZokuseis());
    }

    @Test(expected=NullPointerException.class)
    @TestOrder(10)
    public void testGetHozonKknTani_A1(){
        ViewReport viewReport = SWAKInjector
            .getInstance(ViewReport.class);
        syoruicdkbn = null;
        result = viewReport.getHozonKknTani(syoruicdkbn);
    }

    @Test(expected=NullPointerException.class)
    @TestOrder(20)
    public void testGetHozonKknTani_A2(){
        syoruicdkbn = C_SyoruiCdKbn.BLNK;
        result = ViewReport.getHozonKknTani(syoruicdkbn);
    }

    @Test
    @Transactional
    @TestOrder(30)
    public void testGetHozonKknTani_A3(){
        syoruicdkbn = C_SyoruiCdKbn.SK_MOSSYO;
        result = ViewReport.getHozonKknTani(syoruicdkbn);
        expect = "10 年";
        exStringEquals(result, expect, "保存期間");
    }

    @Test
    @Transactional
    @TestOrder(40)
    public void testGetHozonKknTani_A4(){
        syoruicdkbn = C_SyoruiCdKbn.SK_PPLESSMOSIKOUKAKSYO;
        result = ViewReport.getHozonKknTani(syoruicdkbn);
        expect = "11ヵ月";
        exStringEquals(result, expect, "保存期間");
    }

    @Test
    @Transactional
    @TestOrder(50)
    public void testGetHozonKknTani_A5(){
        syoruicdkbn = C_SyoruiCdKbn.SK_KOKUSYO;
        result = ViewReport.getHozonKknTani(syoruicdkbn);
        expect = "12";
        exStringEquals(result, expect, "保存期間");
    }

    @Test
    @TestOrder(60)
    public void testGetHozonKknTani_A6(){
        syoruicdkbn = C_SyoruiCdKbn.SK_PPLESSKOKUSYO;
        result = ViewReport.getHozonKknTani(syoruicdkbn);
        expect = "";
        exStringEquals(result, expect, "保存期間");
    }

    @Test
    @TestOrder(70)
    public void testGetHozonKknTani_A7(){
        syoruicdkbn = C_SyoruiCdKbn.SK_IKOUKAKSYO;
        result = ViewReport.getHozonKknTani(syoruicdkbn);
        expect = "永久";
        exStringEquals(result, expect, "保存期間");
    }
}
