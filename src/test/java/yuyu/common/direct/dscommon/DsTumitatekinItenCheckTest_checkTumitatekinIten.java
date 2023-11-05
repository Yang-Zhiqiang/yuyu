package yuyu.common.direct.dscommon;

import static yuyu.testinfr.YuyuFunctionTestUtil.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.transaction.Transactional;

import jp.co.dgic.testing.common.virtualmock.MockObjectManager;
import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.app.base.ref.TestDataMaker;
import yuyu.common.hozen.khcommon.CheckTmttkinIten;
import yuyu.common.hozen.khcommon.CheckTmttkinItenBean;
import yuyu.common.hozen.khcommon.CheckTmttkinItenMockForDirect;
import yuyu.def.classification.C_DsTmttknitenchkkekkaKbn;
import yuyu.def.classification.C_ErrorKbn;
import yuyu.def.classification.C_Tmttknitenkbn;
import yuyu.def.direct.manager.DirectDomManager;
import yuyu.def.hozen.manager.HozenDomManager;
import yuyu.testinfr.AbstractTest;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;
import yuyu.testinfr.inject.MockModuleBinder;

import com.google.inject.AbstractModule;

/**
 * ＤＳ積立金移転共通チェッククラスのメソッド {@link DsTumitatekinItenCheck#checkTumitatekinIten(String , BizDate , BizDate)} テスト用クラスです。<br />
 */
@RunWith(OrderedRunner.class)
public class DsTumitatekinItenCheckTest_checkTumitatekinIten extends AbstractTest{

    private final static String fileName = "UT-SP_単体テスト仕様書（共通）_ＤＳ積立金移転共通チェック";

    private final static String sheetName = "INデータ";

    @Before
    public void before(){
        MockModuleBinder.bind(new AbstractModule(){
            @Override
            protected void configure() {
                bind(CheckTmttkinIten.class).to(CheckTmttkinItenMockForDirect.class);
            }
        });
    }

    @BeforeClass
    @Transactional
    public static void testInit() {

        CheckTmttkinItenMockForDirect.caller = DsTumitatekinItenCheckTest_checkTumitatekinIten.class;
    }

    @BeforeClass
    @Transactional
    public static void insertTestData() {
        try {
            TestDataMaker testDataMaker = new TestDataMaker();
            HashMap<String, Map<String, List<Map<String, String>>>> testDataAndTblMap;
            testDataAndTblMap = testDataMaker.getInData(DsTumitatekinItenCheckTest_checkTumitatekinIten.class, fileName, sheetName);
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

    @AfterClass
    public static void testClear() {

        MockObjectManager.initialize();

        CheckTmttkinItenMockForDirect.caller = null;
        CheckTmttkinItenMockForDirect.SYORIPTN = null;

    }

    @Test
    @TestOrder(10)
    public void testCheckTumitatekinIten_A1() {

        MockObjectManager.initialize();

        CheckTmttkinItenMockForDirect.SYORIPTN = CheckTmttkinItenMockForDirect.TESTPATTERN1;

        DsTumitatekinItenCheck dsTumitatekinItenCheck = SWAKInjector.getInstance(DsTumitatekinItenCheck.class);

        DsTumitatekinItenCheckResultBean dsTumitatekinItenCheckResultBean =
            dsTumitatekinItenCheck.checkTumitatekinIten("17806000013",
                BizDate.valueOf(20180102), BizDate.valueOf(20180101));

        exClassificationEquals(dsTumitatekinItenCheckResultBean.getErrorKbn(), C_ErrorKbn.ERROR, "エラー区分");
        exClassificationEquals(dsTumitatekinItenCheckResultBean.getDsTmttknitenchkkekkaKbn(), C_DsTmttknitenchkkekkaKbn.TEIRITUTUMITATE, "ＤＳ積立金移転共通チェック結果区分");

        MockObjectManager.assertArgumentPassed(CheckTmttkinItenMockForDirect.class, "exec", 0, "drctservice");
        MockObjectManager.assertArgumentPassed(CheckTmttkinItenMockForDirect.class, "exec", 1, "");
        CheckTmttkinItenBean checkTmttkinItenBean= (CheckTmttkinItenBean)MockObjectManager.getArgument(CheckTmttkinItenMockForDirect.class, "exec", 2);
        exDateEquals(checkTmttkinItenBean.getSyoruiukeymd(), BizDate.valueOf(20180102), "書類受付日");
        exClassificationEquals(checkTmttkinItenBean.getTmttknitenkbn(), C_Tmttknitenkbn.ITEN, "積立金移転区分");
        exDateEquals(checkTmttkinItenBean.getTmttknitenymd(), BizDate.valueOf(20180101), "積立金移転日");
        exStringEquals(checkTmttkinItenBean.getKykKihon().getKbnkey(), "01", "区分キー");
        exStringEquals(checkTmttkinItenBean.getKykKihon().getSyono(), "17806000013", "証券番号");
    }

    @Test
    @TestOrder(20)
    public void testCheckTumitatekinIten_A2() {
        MockObjectManager.initialize();

        CheckTmttkinItenMockForDirect.SYORIPTN = CheckTmttkinItenMockForDirect.TESTPATTERN2;

        DsTumitatekinItenCheck dsTumitatekinItenCheck = SWAKInjector.getInstance(DsTumitatekinItenCheck.class);

        DsTumitatekinItenCheckResultBean dsTumitatekinItenCheckResultBean =
            dsTumitatekinItenCheck.checkTumitatekinIten("17806000024",
                BizDate.valueOf(20180102), BizDate.valueOf(20180101));

        exClassificationEquals(dsTumitatekinItenCheckResultBean.getErrorKbn(), C_ErrorKbn.ERROR, "エラー区分");
        exClassificationEquals(dsTumitatekinItenCheckResultBean.getDsTmttknitenchkkekkaKbn(), C_DsTmttknitenchkkekkaKbn.KYKYMDMITOURAI, "ＤＳ積立金移転共通チェック結果区分");
    }

    @Test
    @TestOrder(30)
    public void testCheckTumitatekinIten_A3() {
        MockObjectManager.initialize();

        CheckTmttkinItenMockForDirect.SYORIPTN = CheckTmttkinItenMockForDirect.TESTPATTERN3;

        DsTumitatekinItenCheck dsTumitatekinItenCheck = SWAKInjector.getInstance(DsTumitatekinItenCheck.class);

        DsTumitatekinItenCheckResultBean dsTumitatekinItenCheckResultBean =
            dsTumitatekinItenCheck.checkTumitatekinIten("17806000035",
                BizDate.valueOf(20180102), BizDate.valueOf(20180101));

        exClassificationEquals(dsTumitatekinItenCheckResultBean.getErrorKbn(), C_ErrorKbn.ERROR, "エラー区分");
        exClassificationEquals(dsTumitatekinItenCheckResultBean.getDsTmttknitenchkkekkaKbn(), C_DsTmttknitenchkkekkaKbn.SAISYUUHOKENNENDO, "ＤＳ積立金移転共通チェック結果区分");
    }

    @Test
    @TestOrder(40)
    public void testCheckTumitatekinIten_A4() {
        MockObjectManager.initialize();

        CheckTmttkinItenMockForDirect.SYORIPTN = CheckTmttkinItenMockForDirect.TESTPATTERN4;

        DsTumitatekinItenCheck dsTumitatekinItenCheck = SWAKInjector.getInstance(DsTumitatekinItenCheck.class);

        DsTumitatekinItenCheckResultBean dsTumitatekinItenCheckResultBean =
            dsTumitatekinItenCheck.checkTumitatekinIten("17806000046",
                BizDate.valueOf(20180102), BizDate.valueOf(20180101));

        exClassificationEquals(dsTumitatekinItenCheckResultBean.getErrorKbn(), C_ErrorKbn.ERROR, "エラー区分");
        exClassificationEquals(dsTumitatekinItenCheckResultBean.getDsTmttknitenchkkekkaKbn(), C_DsTmttknitenchkkekkaKbn.UKTKKKN, "ＤＳ積立金移転共通チェック結果区分");
    }

    @Test
    @TestOrder(50)
    public void testCheckTumitatekinIten_A5() {
        MockObjectManager.initialize();

        CheckTmttkinItenMockForDirect.SYORIPTN = CheckTmttkinItenMockForDirect.TESTPATTERN5;

        DsTumitatekinItenCheck dsTumitatekinItenCheck = SWAKInjector.getInstance(DsTumitatekinItenCheck.class);

        DsTumitatekinItenCheckResultBean dsTumitatekinItenCheckResultBean =
            dsTumitatekinItenCheck.checkTumitatekinIten("17806000057",
                BizDate.valueOf(20180102), BizDate.valueOf(20180101));

        exClassificationEquals(dsTumitatekinItenCheckResultBean.getErrorKbn(), C_ErrorKbn.ERROR, "エラー区分");
        exClassificationEquals(dsTumitatekinItenCheckResultBean.getDsTmttknitenchkkekkaKbn(), C_DsTmttknitenchkkekkaKbn.UKTKKKN, "ＤＳ積立金移転共通チェック結果区分");
    }

    @Test
    @TestOrder(60)
    public void testCheckTumitatekinIten_A6() {
        MockObjectManager.initialize();

        CheckTmttkinItenMockForDirect.SYORIPTN = CheckTmttkinItenMockForDirect.TESTPATTERN6;

        DsTumitatekinItenCheck dsTumitatekinItenCheck = SWAKInjector.getInstance(DsTumitatekinItenCheck.class);

        DsTumitatekinItenCheckResultBean dsTumitatekinItenCheckResultBean =
            dsTumitatekinItenCheck.checkTumitatekinIten("17806000068",
                BizDate.valueOf(20180102), BizDate.valueOf(20180101));

        exClassificationEquals(dsTumitatekinItenCheckResultBean.getErrorKbn(), C_ErrorKbn.ERROR, "エラー区分");
        exClassificationEquals(dsTumitatekinItenCheckResultBean.getDsTmttknitenchkkekkaKbn(), C_DsTmttknitenchkkekkaKbn.TMTTKNITENUKTKUMU, "ＤＳ積立金移転共通チェック結果区分");
    }

    @Test
    @TestOrder(70)
    public void testCheckTumitatekinIten_A7() {
        MockObjectManager.initialize();

        CheckTmttkinItenMockForDirect.SYORIPTN = CheckTmttkinItenMockForDirect.TESTPATTERN7;

        DsTumitatekinItenCheck dsTumitatekinItenCheck = SWAKInjector.getInstance(DsTumitatekinItenCheck.class);

        DsTumitatekinItenCheckResultBean dsTumitatekinItenCheckResultBean =
            dsTumitatekinItenCheck.checkTumitatekinIten("17806000079",
                BizDate.valueOf(20180102), BizDate.valueOf(20180101));

        exClassificationEquals(dsTumitatekinItenCheckResultBean.getErrorKbn(), C_ErrorKbn.ERROR, "エラー区分");
        exClassificationEquals(dsTumitatekinItenCheckResultBean.getDsTmttknitenchkkekkaKbn(), C_DsTmttknitenchkkekkaKbn.TMTTKNITENUKTKUMU, "ＤＳ積立金移転共通チェック結果区分");
    }

    @Test
    @TestOrder(80)
    public void testCheckTumitatekinIten_A8() {
        MockObjectManager.initialize();

        CheckTmttkinItenMockForDirect.SYORIPTN = CheckTmttkinItenMockForDirect.TESTPATTERN7;

        DsTumitatekinItenCheck dsTumitatekinItenCheck = SWAKInjector.getInstance(DsTumitatekinItenCheck.class);

        DsTumitatekinItenCheckResultBean dsTumitatekinItenCheckResultBean =
            dsTumitatekinItenCheck.checkTumitatekinIten("18808000087",
                BizDate.valueOf(20180102), BizDate.valueOf(20180101));

        exClassificationEquals(dsTumitatekinItenCheckResultBean.getErrorKbn(), C_ErrorKbn.ERROR, "エラー区分");
        exClassificationEquals(dsTumitatekinItenCheckResultBean.getDsTmttknitenchkkekkaKbn(), C_DsTmttknitenchkkekkaKbn.TMTTKNITENUKTKUMU, "ＤＳ積立金移転共通チェック結果区分");
    }

    @Test
    @TestOrder(90)
    public void testCheckTumitatekinIten_A9() {
        MockObjectManager.initialize();

        MockObjectManager.initialize();

        CheckTmttkinItenMockForDirect.SYORIPTN = CheckTmttkinItenMockForDirect.TESTPATTERN6;
        DsTumitatekinItenCheck dsTumitatekinItenCheck = SWAKInjector.getInstance(DsTumitatekinItenCheck.class);

        DsTumitatekinItenCheckResultBean dsTumitatekinItenCheckResultBean =
            dsTumitatekinItenCheck.checkTumitatekinIten("18808000098",
                BizDate.valueOf(20180102), BizDate.valueOf(20180101));

        exClassificationEquals(dsTumitatekinItenCheckResultBean.getErrorKbn(), C_ErrorKbn.ERROR, "エラー区分");
        exClassificationEquals(dsTumitatekinItenCheckResultBean.getDsTmttknitenchkkekkaKbn(), C_DsTmttknitenchkkekkaKbn.HOZENJYOUTAI, "ＤＳ積立金移転共通チェック結果区分");

    }

    @Test
    @TestOrder(100)
    public void testCheckTumitatekinIten_A10() {
        MockObjectManager.initialize();

        MockObjectManager.initialize();

        CheckTmttkinItenMockForDirect.SYORIPTN = CheckTmttkinItenMockForDirect.TESTPATTERN6;
        DsTumitatekinItenCheck dsTumitatekinItenCheck = SWAKInjector.getInstance(DsTumitatekinItenCheck.class);

        DsTumitatekinItenCheckResultBean dsTumitatekinItenCheckResultBean =
            dsTumitatekinItenCheck.checkTumitatekinIten("17806000105",
                BizDate.valueOf(20180102), BizDate.valueOf(20180101));

        exClassificationEquals(dsTumitatekinItenCheckResultBean.getErrorKbn(), C_ErrorKbn.ERROR, "エラー区分");
        exClassificationEquals(dsTumitatekinItenCheckResultBean.getDsTmttknitenchkkekkaKbn(), C_DsTmttknitenchkkekkaKbn.TETUDUKITYUUI, "ＤＳ積立金移転共通チェック結果区分");

    }

    @Test
    @TestOrder(110)
    public void testCheckTumitatekinIten_A11() {
        MockObjectManager.initialize();

        CheckTmttkinItenMockForDirect.SYORIPTN = CheckTmttkinItenMockForDirect.TESTPATTERN6;
        DsTumitatekinItenCheck dsTumitatekinItenCheck = SWAKInjector.getInstance(DsTumitatekinItenCheck.class);

        DsTumitatekinItenCheckResultBean dsTumitatekinItenCheckResultBean =
            dsTumitatekinItenCheck.checkTumitatekinIten("18808000113",
                BizDate.valueOf(20180102), BizDate.valueOf(20180101));

        exClassificationEquals(dsTumitatekinItenCheckResultBean.getErrorKbn(), C_ErrorKbn.OK , "エラー区分");
        exClassificationEquals(dsTumitatekinItenCheckResultBean.getDsTmttknitenchkkekkaKbn(), C_DsTmttknitenchkkekkaKbn.BLNK, "ＤＳ積立金移転共通チェック結果区分");
    }

    @Test
    @TestOrder(120)
    public void testCheckTumitatekinIten_A12() {
        MockObjectManager.initialize();

        CheckTmttkinItenMockForDirect.SYORIPTN = CheckTmttkinItenMockForDirect.TESTPATTERN8;

        DsTumitatekinItenCheck dsTumitatekinItenCheck = SWAKInjector.getInstance(DsTumitatekinItenCheck.class);

        DsTumitatekinItenCheckResultBean dsTumitatekinItenCheckResultBean =
            dsTumitatekinItenCheck.checkTumitatekinIten("18808000124",
                BizDate.valueOf(20180102), BizDate.valueOf(20180101));

        exClassificationEquals(dsTumitatekinItenCheckResultBean.getErrorKbn(), C_ErrorKbn.ERROR , "エラー区分");
        exClassificationEquals(dsTumitatekinItenCheckResultBean.getDsTmttknitenchkkekkaKbn(), C_DsTmttknitenchkkekkaKbn.TRATKITISYSYOUHN, "ＤＳ積立金移転共通チェック結果区分");

    }
}
