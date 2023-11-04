package yuyu.common.hozen.khcommon;

import static yuyu.testinfr.YuyuFunctionTestUtil.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.transaction.Transactional;

import jp.co.dgic.testing.common.virtualmock.MockObjectManager;
import jp.co.slcs.swak.bizinfr.exception.BizAppException;
import jp.co.slcs.swak.bizinfr.exception.BizLogicException;
import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.app.base.ref.TestDataMaker;
import yuyu.app.base.ref.TestDataMakerException;
import yuyu.def.classification.C_ChkkekkaKbn;
import yuyu.def.classification.C_Tmttknitenkbn;
import yuyu.def.hozen.manager.HozenDomManager;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * 積立金移転共通チェッククラスのメソッド {@link CheckTmttkinIten#exec(String, String, CheckTmttkinItenBean)} テスト用クラスです。<br />
 */
@RunWith(OrderedRunner.class)
public class CheckTmttkinItenTest_exec {

    private final static String fileName = "UT-SP_単体テスト仕様書（共通）_積立金移転共通チェック";

    private final static String sheetName = "INデータ";

    @BeforeClass
    @Transactional
    public static void insertTestData() {
        try {

            TestDataMaker testDataMaker = new TestDataMaker();

            HashMap<String, Map<String, List<Map<String, String>>>> testDataAndTblMap;

            testDataAndTblMap = testDataMaker.getInData(CheckTmttkinItenTest_exec.class, fileName, sheetName);

            testDataMaker.insDataByDataId("データ001", testDataAndTblMap);

        } catch (TestDataMakerException e) {
            e.printStackTrace();
        }
    }

    @AfterClass
    @Transactional
    public static void deleteTestData() {

        MockObjectManager.initialize();

        HozenDomManager hozenDomManager = SWAKInjector.getInstance(HozenDomManager.class);
        hozenDomManager.delete(hozenDomManager.getAllKykKihon());

    }

    @Test
    @TestOrder(1010)
    public void testExec_A1() {

        CheckTmttkinIten checkTmttkinIten = SWAKInjector.getInstance(CheckTmttkinIten.class);

        C_ChkkekkaKbn chkkekkaKbn = checkTmttkinIten.exec(null, "inputkey", null);

        exClassificationEquals(chkkekkaKbn, C_ChkkekkaKbn.SEIJYOU, "チェック結果区分");
        exStringEquals(checkTmttkinIten.getErrorMessage(), "", "エラーメッセージ");
        exStringEquals(checkTmttkinIten.getErrorMessageCode(), "", "エラーメッセージコード");
        exDateEquals(checkTmttkinIten.getKykymd(), null, "契約日");
    }

    @Test
    @TestOrder(1020)
    public void testExec_A2() {

        CheckTmttkinIten checkTmttkinIten = SWAKInjector.getInstance(CheckTmttkinIten.class);

        C_ChkkekkaKbn chkkekkaKbn = checkTmttkinIten.exec("online", null, null);

        exClassificationEquals(chkkekkaKbn, C_ChkkekkaKbn.SEIJYOU, "チェック結果区分");
        exStringEquals(checkTmttkinIten.getErrorMessage(), "", "エラーメッセージ");
        exStringEquals(checkTmttkinIten.getErrorMessageCode(), "", "エラーメッセージコード");
        exDateEquals(checkTmttkinIten.getKykymd(), null, "契約日");
    }

    @Test(expected = BizAppException.class)
    @TestOrder(1030)
    public void testExec_A3() {

        CheckTmttkinIten checkTmttkinIten = SWAKInjector.getInstance(CheckTmttkinIten.class);

        CheckTmttkinItenBean checkTmttkinItenBean = SWAKInjector.getInstance(CheckTmttkinItenBean.class);

        checkTmttkinItenBean.setSyoruiukeymd(BizDate.valueOf(20180208));
        checkTmttkinItenBean.setTmttknitenkbn(C_Tmttknitenkbn.ITEN);
        checkTmttkinItenBean.setTmttknitenymd(BizDate.valueOf(20180207));

        HozenDomManager hozenDomManager = SWAKInjector.getInstance(HozenDomManager.class);
        checkTmttkinItenBean.setKykKihon(hozenDomManager.getKykKihon("11809111114"));

        try {
            checkTmttkinIten.exec("online", "inputkey", checkTmttkinItenBean);
        } catch (Exception e) {
            exStringEquals(e.getMessage(),
                "テーブル取得エラー　IT_KykSyouhn　key:syono=11809111114",
                "エラーメッセージ(BizAppException)");
            throw e;
        }
    }

    @Test
    @TestOrder(1040)
    public void testExec_A4() {

        CheckTmttkinIten checkTmttkinIten = SWAKInjector.getInstance(CheckTmttkinIten.class);

        CheckTmttkinItenBean checkTmttkinItenBean = SWAKInjector.getInstance(CheckTmttkinItenBean.class);

        checkTmttkinItenBean.setSyoruiukeymd(BizDate.valueOf(20180208));
        checkTmttkinItenBean.setTmttknitenkbn(C_Tmttknitenkbn.ITEN);
        checkTmttkinItenBean.setTmttknitenymd(BizDate.valueOf(20180207));

        HozenDomManager hozenDomManager = SWAKInjector.getInstance(HozenDomManager.class);
        checkTmttkinItenBean.setKykKihon(hozenDomManager.getKykKihon("17810000061"));

        C_ChkkekkaKbn chkkekkaKbn = checkTmttkinIten.exec("drctservice", "inputkey", checkTmttkinItenBean);

        exClassificationEquals(chkkekkaKbn, C_ChkkekkaKbn.ERROR, "チェック結果区分");
        exStringEquals(checkTmttkinIten.getErrorMessage(),
            "テーブル取得エラー　IT_KykSyouhn　key:syono=17810000061", "エラーメッセージ");
        exStringEquals(checkTmttkinIten.getErrorMessageCode(), "4002", "エラーメッセージコード");
        exDateEquals(checkTmttkinIten.getKykymd(), null, "契約日");
    }

    @Test(expected = BizLogicException.class)
    @TestOrder(1050)
    public void testExec_A5() {

        CheckTmttkinIten checkTmttkinIten = SWAKInjector.getInstance(CheckTmttkinIten.class);

        CheckTmttkinItenBean checkTmttkinItenBean = SWAKInjector.getInstance(CheckTmttkinItenBean.class);

        checkTmttkinItenBean.setSyoruiukeymd(BizDate.valueOf(20180208));
        checkTmttkinItenBean.setTmttknitenkbn(C_Tmttknitenkbn.ITEN);
        checkTmttkinItenBean.setTmttknitenymd(BizDate.valueOf(20180207));

        HozenDomManager hozenDomManager = SWAKInjector.getInstance(HozenDomManager.class);
        checkTmttkinItenBean.setKykKihon(hozenDomManager.getKykKihon("11809111125"));

        try {
            checkTmttkinIten.exec("online", "inputkey", checkTmttkinItenBean);
        } catch (Exception e) {
            exStringEquals(e.getMessage(),
                "取扱対象外の保険種類のため処理できません。",
                "エラーメッセージ(BizLogicException)");
            throw e;
        }
    }

    @Test
    @TestOrder(1060)
    public void testExec_A6() {

        CheckTmttkinIten checkTmttkinIten = SWAKInjector.getInstance(CheckTmttkinIten.class);

        CheckTmttkinItenBean checkTmttkinItenBean = SWAKInjector.getInstance(CheckTmttkinItenBean.class);

        checkTmttkinItenBean.setSyoruiukeymd(BizDate.valueOf(20180208));
        checkTmttkinItenBean.setTmttknitenkbn(C_Tmttknitenkbn.ITEN);
        checkTmttkinItenBean.setTmttknitenymd(BizDate.valueOf(20180207));

        HozenDomManager hozenDomManager = SWAKInjector.getInstance(HozenDomManager.class);
        checkTmttkinItenBean.setKykKihon(hozenDomManager.getKykKihon("11809111125"));

        C_ChkkekkaKbn chkkekkaKbn = checkTmttkinIten.exec("drctservice", "inputkey", checkTmttkinItenBean);

        exClassificationEquals(chkkekkaKbn, C_ChkkekkaKbn.ERROR, "チェック結果区分");
        exStringEquals(checkTmttkinIten.getErrorMessage(),
            "取扱対象外の保険種類のため処理できません。", "エラーメッセージ");
        exStringEquals(checkTmttkinIten.getErrorMessageCode(), "4003", "エラーメッセージコード");
        exDateEquals(checkTmttkinIten.getKykymd(), null, "契約日");
    }

    @Test(expected = BizLogicException.class)
    @TestOrder(1070)
    public void testExec_A7() {

        CheckTmttkinIten checkTmttkinIten = SWAKInjector.getInstance(CheckTmttkinIten.class);

        CheckTmttkinItenBean checkTmttkinItenBean = SWAKInjector.getInstance(CheckTmttkinItenBean.class);

        checkTmttkinItenBean.setSyoruiukeymd(BizDate.valueOf(20180208));
        checkTmttkinItenBean.setTmttknitenkbn(C_Tmttknitenkbn.ITEN);
        checkTmttkinItenBean.setTmttknitenymd(BizDate.valueOf(20180207));

        HozenDomManager hozenDomManager = SWAKInjector.getInstance(HozenDomManager.class);
        checkTmttkinItenBean.setKykKihon(hozenDomManager.getKykKihon("11809111136"));

        try {
            checkTmttkinIten.exec("online", "inputkey", checkTmttkinItenBean);
        } catch (Exception e) {
            exStringEquals(e.getMessage(),
                "取扱対象外の保険種類のため処理できません。",
                "エラーメッセージ(BizLogicException)");
            throw e;
        }
    }

    @Test
    @TestOrder(1080)
    public void testExec_A8() {

        CheckTmttkinIten checkTmttkinIten = SWAKInjector.getInstance(CheckTmttkinIten.class);

        CheckTmttkinItenBean checkTmttkinItenBean = SWAKInjector.getInstance(CheckTmttkinItenBean.class);

        checkTmttkinItenBean.setSyoruiukeymd(BizDate.valueOf(20170302));
        checkTmttkinItenBean.setTmttknitenkbn(C_Tmttknitenkbn.ITEN);
        checkTmttkinItenBean.setTmttknitenymd(BizDate.valueOf(20180207));

        HozenDomManager hozenDomManager = SWAKInjector.getInstance(HozenDomManager.class);
        checkTmttkinItenBean.setKykKihon(hozenDomManager.getKykKihon("11809111147"));

        C_ChkkekkaKbn chkkekkaKbn = checkTmttkinIten.exec("online", "inputkey", checkTmttkinItenBean);

        exClassificationEquals(chkkekkaKbn, C_ChkkekkaKbn.SEIJYOU, "チェック結果区分");
        exStringEquals(checkTmttkinIten.getErrorMessage(), "", "エラーメッセージ");
        exStringEquals(checkTmttkinIten.getErrorMessageCode(), "", "エラーメッセージコード");
        exDateEquals(checkTmttkinIten.getKykymd(), BizDate.valueOf(20170302), "契約日");
    }

    @Test
    @TestOrder(1090)
    public void testExec_A9() {

        CheckTmttkinIten checkTmttkinIten = SWAKInjector.getInstance(CheckTmttkinIten.class);

        CheckTmttkinItenBean checkTmttkinItenBean = SWAKInjector.getInstance(CheckTmttkinItenBean.class);

        checkTmttkinItenBean.setSyoruiukeymd(BizDate.valueOf(20170302));
        checkTmttkinItenBean.setTmttknitenkbn(C_Tmttknitenkbn.ITEN_TORIKESI);
        checkTmttkinItenBean.setTmttknitenymd(BizDate.valueOf(20170601));

        HozenDomManager hozenDomManager = SWAKInjector.getInstance(HozenDomManager.class);
        checkTmttkinItenBean.setKykKihon(hozenDomManager.getKykKihon("11809111147"));

        C_ChkkekkaKbn chkkekkaKbn = checkTmttkinIten.exec("drctservice", "reference", checkTmttkinItenBean);

        exClassificationEquals(chkkekkaKbn, C_ChkkekkaKbn.SEIJYOU, "チェック結果区分");
        exStringEquals(checkTmttkinIten.getErrorMessage(), "", "エラーメッセージ");
        exStringEquals(checkTmttkinIten.getErrorMessageCode(), "", "エラーメッセージコード");
        exDateEquals(checkTmttkinIten.getKykymd(), BizDate.valueOf(20170302), "契約日");
    }

    @Test
    @TestOrder(1100)
    public void testExec_A10() {

        CheckTmttkinIten checkTmttkinIten = SWAKInjector.getInstance(CheckTmttkinIten.class);

        CheckTmttkinItenBean checkTmttkinItenBean = SWAKInjector.getInstance(CheckTmttkinItenBean.class);

        checkTmttkinItenBean.setSyoruiukeymd(BizDate.valueOf(20170302));
        checkTmttkinItenBean.setTmttknitenkbn(C_Tmttknitenkbn.ITEN);
        checkTmttkinItenBean.setTmttknitenymd(BizDate.valueOf(20170302));

        HozenDomManager hozenDomManager = SWAKInjector.getInstance(HozenDomManager.class);
        checkTmttkinItenBean.setKykKihon(hozenDomManager.getKykKihon("11809111158"));

        C_ChkkekkaKbn chkkekkaKbn = checkTmttkinIten.exec("online", "inputcontents", checkTmttkinItenBean);

        exClassificationEquals(chkkekkaKbn, C_ChkkekkaKbn.SEIJYOU, "チェック結果区分");
        exStringEquals(checkTmttkinIten.getErrorMessage(), "", "エラーメッセージ");
        exStringEquals(checkTmttkinIten.getErrorMessageCode(), "", "エラーメッセージコード");
        exDateEquals(checkTmttkinIten.getKykymd(), null, "契約日");
    }

    @Test(expected = BizLogicException.class)
    @TestOrder(1110)
    public void testExec_A11() {

        CheckTmttkinIten checkTmttkinIten = SWAKInjector.getInstance(CheckTmttkinIten.class);

        CheckTmttkinItenBean checkTmttkinItenBean = SWAKInjector.getInstance(CheckTmttkinItenBean.class);

        checkTmttkinItenBean.setSyoruiukeymd(BizDate.valueOf(20170301));
        checkTmttkinItenBean.setTmttknitenkbn(C_Tmttknitenkbn.ITEN);
        checkTmttkinItenBean.setTmttknitenymd(BizDate.valueOf(20180207));

        HozenDomManager hozenDomManager = SWAKInjector.getInstance(HozenDomManager.class);
        checkTmttkinItenBean.setKykKihon(hozenDomManager.getKykKihon("11810111118"));

        try {
            checkTmttkinIten.exec("online", "inputcontents", checkTmttkinItenBean);
        } catch (Exception e) {
            exStringEquals(e.getMessage(),
                "書類受付日が契約日前のため処理できません。",
                "エラーメッセージ(BizLogicException)");
            throw e;
        }
    }

    @Test
    @TestOrder(1120)
    public void testExec_A12() {

        CheckTmttkinIten checkTmttkinIten = SWAKInjector.getInstance(CheckTmttkinIten.class);

        CheckTmttkinItenBean checkTmttkinItenBean = SWAKInjector.getInstance(CheckTmttkinItenBean.class);

        checkTmttkinItenBean.setSyoruiukeymd(BizDate.valueOf(20170301));
        checkTmttkinItenBean.setTmttknitenkbn(C_Tmttknitenkbn.ITEN);
        checkTmttkinItenBean.setTmttknitenymd(BizDate.valueOf(20180207));

        HozenDomManager hozenDomManager = SWAKInjector.getInstance(HozenDomManager.class);
        checkTmttkinItenBean.setKykKihon(hozenDomManager.getKykKihon("11810111118"));

        C_ChkkekkaKbn chkkekkaKbn = checkTmttkinIten.exec("drctservice", "reference", checkTmttkinItenBean);

        exClassificationEquals(chkkekkaKbn, C_ChkkekkaKbn.ERROR, "チェック結果区分");
        exStringEquals(checkTmttkinIten.getErrorMessage(),
            "積立金移転受付日が契約日前のため処理できません。", "エラーメッセージ");
        exStringEquals(checkTmttkinIten.getErrorMessageCode(), "3001", "エラーメッセージコード");
        exDateEquals(checkTmttkinIten.getKykymd(), BizDate.valueOf(20170302), "契約日");
    }

    @Test(expected = BizLogicException.class)
    @TestOrder(1130)
    public void testExec_A13() {

        CheckTmttkinIten checkTmttkinIten = SWAKInjector.getInstance(CheckTmttkinIten.class);

        CheckTmttkinItenBean checkTmttkinItenBean = SWAKInjector.getInstance(CheckTmttkinItenBean.class);

        checkTmttkinItenBean.setSyoruiukeymd(BizDate.valueOf(20170303));
        checkTmttkinItenBean.setTmttknitenkbn(C_Tmttknitenkbn.ITEN);
        checkTmttkinItenBean.setTmttknitenymd(BizDate.valueOf(20170202));

        HozenDomManager hozenDomManager = SWAKInjector.getInstance(HozenDomManager.class);
        checkTmttkinItenBean.setKykKihon(hozenDomManager.getKykKihon("11810111118"));

        try {
            checkTmttkinIten.exec("online", "inputcontents", checkTmttkinItenBean);
        } catch (Exception e) {
            exStringEquals(e.getMessage(),
                "積立金移転日が年金開始と同日になるため、処理できません。",
                "エラーメッセージ(BizLogicException)");
            throw e;
        }
    }

    @Test
    @TestOrder(1140)
    public void testExec_A14() {

        CheckTmttkinIten checkTmttkinIten = SWAKInjector.getInstance(CheckTmttkinIten.class);

        CheckTmttkinItenBean checkTmttkinItenBean = SWAKInjector.getInstance(CheckTmttkinItenBean.class);

        checkTmttkinItenBean.setSyoruiukeymd(BizDate.valueOf(20170303));
        checkTmttkinItenBean.setTmttknitenkbn(C_Tmttknitenkbn.ITEN);
        checkTmttkinItenBean.setTmttknitenymd(BizDate.valueOf(20170202));

        HozenDomManager hozenDomManager = SWAKInjector.getInstance(HozenDomManager.class);
        checkTmttkinItenBean.setKykKihon(hozenDomManager.getKykKihon("11810111118"));

        C_ChkkekkaKbn chkkekkaKbn = checkTmttkinIten.exec("drctservice", "reference", checkTmttkinItenBean);

        exClassificationEquals(chkkekkaKbn, C_ChkkekkaKbn.ERROR, "チェック結果区分");
        exStringEquals(checkTmttkinIten.getErrorMessage(),
            "積立金移転日が年金開始と同日になるため、処理できません。", "エラーメッセージ");
        exStringEquals(checkTmttkinIten.getErrorMessageCode(), "3002", "エラーメッセージコード");
        exDateEquals(checkTmttkinIten.getKykymd(), BizDate.valueOf(20170302), "契約日");
    }

    @Test(expected = BizLogicException.class)
    @TestOrder(1150)
    public void testExec_A15() {

        CheckTmttkinIten checkTmttkinIten = SWAKInjector.getInstance(CheckTmttkinIten.class);

        CheckTmttkinItenBean checkTmttkinItenBean = SWAKInjector.getInstance(CheckTmttkinItenBean.class);

        checkTmttkinItenBean.setSyoruiukeymd(BizDate.valueOf(20170303));
        checkTmttkinItenBean.setTmttknitenkbn(C_Tmttknitenkbn.ITEN);
        checkTmttkinItenBean.setTmttknitenymd(BizDate.valueOf(20170604));

        HozenDomManager hozenDomManager = SWAKInjector.getInstance(HozenDomManager.class);
        checkTmttkinItenBean.setKykKihon(hozenDomManager.getKykKihon("11810111129"));

        try {
            checkTmttkinIten.exec("online", "reference", checkTmttkinItenBean);
        } catch (Exception e) {
            exStringEquals(e.getMessage(),
                "積立金移転の受付可能期間外のため処理できません。",
                "エラーメッセージ(BizLogicException)");
            throw e;
        }
    }

    @Test
    @TestOrder(1160)
    public void testExec_A16() {

        CheckTmttkinIten checkTmttkinIten = SWAKInjector.getInstance(CheckTmttkinIten.class);

        CheckTmttkinItenBean checkTmttkinItenBean = SWAKInjector.getInstance(CheckTmttkinItenBean.class);

        checkTmttkinItenBean.setSyoruiukeymd(BizDate.valueOf(20170303));
        checkTmttkinItenBean.setTmttknitenkbn(C_Tmttknitenkbn.ITEN);
        checkTmttkinItenBean.setTmttknitenymd(BizDate.valueOf(20180313));

        HozenDomManager hozenDomManager = SWAKInjector.getInstance(HozenDomManager.class);
        checkTmttkinItenBean.setKykKihon(hozenDomManager.getKykKihon("11810111129"));

        C_ChkkekkaKbn chkkekkaKbn = checkTmttkinIten.exec("drctservice", "reference", checkTmttkinItenBean);

        exClassificationEquals(chkkekkaKbn, C_ChkkekkaKbn.ERROR, "チェック結果区分");
        exStringEquals(checkTmttkinIten.getErrorMessage(),
            "積立金移転の受付可能期間外のため処理できません。", "エラーメッセージ");
        exStringEquals(checkTmttkinIten.getErrorMessageCode(), "3003", "エラーメッセージコード");
        exDateEquals(checkTmttkinIten.getKykymd(), BizDate.valueOf(20170302), "契約日");
    }

    @Test(expected = BizLogicException.class)
    @TestOrder(1170)
    public void testExec_A17() {

        CheckTmttkinIten checkTmttkinIten = SWAKInjector.getInstance(CheckTmttkinIten.class);

        CheckTmttkinItenBean checkTmttkinItenBean = SWAKInjector.getInstance(CheckTmttkinItenBean.class);

        checkTmttkinItenBean.setSyoruiukeymd(BizDate.valueOf(20170307));
        checkTmttkinItenBean.setTmttknitenkbn(C_Tmttknitenkbn.ITEN);
        checkTmttkinItenBean.setTmttknitenymd(BizDate.valueOf(20170318));

        HozenDomManager hozenDomManager = SWAKInjector.getInstance(HozenDomManager.class);
        checkTmttkinItenBean.setKykKihon(hozenDomManager.getKykKihon("11810111130"));

        try {
            checkTmttkinIten.exec("online", "reference", checkTmttkinItenBean);
        } catch (Exception e) {
            exStringEquals(e.getMessage(),
                "積立金移転の受付可能期間外のため処理できません。",
                "エラーメッセージ(BizLogicException)");
            throw e;
        }
    }

    @Test
    @TestOrder(1180)
    public void testExec_A18() {

        CheckTmttkinIten checkTmttkinIten = SWAKInjector.getInstance(CheckTmttkinIten.class);

        CheckTmttkinItenBean checkTmttkinItenBean = SWAKInjector.getInstance(CheckTmttkinItenBean.class);

        checkTmttkinItenBean.setSyoruiukeymd(BizDate.valueOf(20170307));
        checkTmttkinItenBean.setTmttknitenkbn(C_Tmttknitenkbn.ITEN);
        checkTmttkinItenBean.setTmttknitenymd(BizDate.valueOf(20170318));

        HozenDomManager hozenDomManager = SWAKInjector.getInstance(HozenDomManager.class);
        checkTmttkinItenBean.setKykKihon(hozenDomManager.getKykKihon("11810111130"));

        C_ChkkekkaKbn chkkekkaKbn = checkTmttkinIten.exec("drctservice", "reference", checkTmttkinItenBean);

        exClassificationEquals(chkkekkaKbn, C_ChkkekkaKbn.ERROR, "チェック結果区分");
        exStringEquals(checkTmttkinIten.getErrorMessage(),
            "積立金移転の受付可能期間外のため処理できません。", "エラーメッセージ");
        exStringEquals(checkTmttkinIten.getErrorMessageCode(), "3004", "エラーメッセージコード");
        exDateEquals(checkTmttkinIten.getKykymd(), BizDate.valueOf(20170307), "契約日");
    }

    @Test(expected = BizAppException.class)
    @TestOrder(1190)
    public void testExec_A19() {

        CheckTmttkinIten checkTmttkinIten = SWAKInjector.getInstance(CheckTmttkinIten.class);

        CheckTmttkinItenBean checkTmttkinItenBean = SWAKInjector.getInstance(CheckTmttkinItenBean.class);

        checkTmttkinItenBean.setSyoruiukeymd(BizDate.valueOf(20180208));
        checkTmttkinItenBean.setTmttknitenkbn(C_Tmttknitenkbn.ITEN);
        checkTmttkinItenBean.setTmttknitenymd(BizDate.valueOf(20180207));

        HozenDomManager hozenDomManager = SWAKInjector.getInstance(HozenDomManager.class);
        checkTmttkinItenBean.setKykKihon(hozenDomManager.getKykKihon("11810111141"));

        try {
            checkTmttkinIten.exec("online", "inputcontents", checkTmttkinItenBean);
        } catch (Exception e) {
            exStringEquals(e.getMessage(),
                "テーブル取得エラー　IT_KykSyouhn　key:syono=11810111141",
                "エラーメッセージ(BizAppException)");
            throw e;
        }
    }

    @Test
    @TestOrder(1200)
    public void testExec_A20() {

        CheckTmttkinIten checkTmttkinIten = SWAKInjector.getInstance(CheckTmttkinIten.class);

        CheckTmttkinItenBean checkTmttkinItenBean = SWAKInjector.getInstance(CheckTmttkinItenBean.class);

        checkTmttkinItenBean.setSyoruiukeymd(BizDate.valueOf(20170302));
        checkTmttkinItenBean.setTmttknitenkbn(C_Tmttknitenkbn.ITEN_TORIKESI);
        checkTmttkinItenBean.setTmttknitenymd(BizDate.valueOf(20170316));

        HozenDomManager hozenDomManager = SWAKInjector.getInstance(HozenDomManager.class);
        checkTmttkinItenBean.setKykKihon(hozenDomManager.getKykKihon("11810111174"));

        C_ChkkekkaKbn chkkekkaKbn = checkTmttkinIten.exec("drctservice", "inputcontents", checkTmttkinItenBean);

        exClassificationEquals(chkkekkaKbn, C_ChkkekkaKbn.SEIJYOU, "チェック結果区分");
        exStringEquals(checkTmttkinIten.getErrorMessage(), "", "エラーメッセージ");
        exStringEquals(checkTmttkinIten.getErrorMessageCode(), "", "エラーメッセージコード");
        exDateEquals(checkTmttkinIten.getKykymd(), BizDate.valueOf(20170228), "契約日");
    }

    @Test
    @TestOrder(1210)
    public void testExec_A21() {

        CheckTmttkinIten checkTmttkinIten = SWAKInjector.getInstance(CheckTmttkinIten.class);

        CheckTmttkinItenBean checkTmttkinItenBean = SWAKInjector.getInstance(CheckTmttkinItenBean.class);

        checkTmttkinItenBean.setSyoruiukeymd(BizDate.valueOf(20170303));
        checkTmttkinItenBean.setTmttknitenkbn(C_Tmttknitenkbn.ITEN);
        checkTmttkinItenBean.setTmttknitenymd(BizDate.valueOf(20170603));

        HozenDomManager hozenDomManager = SWAKInjector.getInstance(HozenDomManager.class);
        checkTmttkinItenBean.setKykKihon(hozenDomManager.getKykKihon("11810111174"));

        C_ChkkekkaKbn chkkekkaKbn = checkTmttkinIten.exec("online", "reference", checkTmttkinItenBean);

        exClassificationEquals(chkkekkaKbn, C_ChkkekkaKbn.SEIJYOU, "チェック結果区分");
        exStringEquals(checkTmttkinIten.getErrorMessage(), "", "エラーメッセージ");
        exStringEquals(checkTmttkinIten.getErrorMessageCode(), "", "エラーメッセージコード");
        exDateEquals(checkTmttkinIten.getKykymd(), null, "契約日");
    }

    @Test
    @TestOrder(1220)
    public void testExec_A22() {

        CheckTmttkinIten checkTmttkinIten = SWAKInjector.getInstance(CheckTmttkinIten.class);

        CheckTmttkinItenBean checkTmttkinItenBean = SWAKInjector.getInstance(CheckTmttkinItenBean.class);

        checkTmttkinItenBean.setSyoruiukeymd(BizDate.valueOf(20170302));
        checkTmttkinItenBean.setTmttknitenkbn(C_Tmttknitenkbn.ITEN);
        checkTmttkinItenBean.setTmttknitenymd(BizDate.valueOf(20170317));

        HozenDomManager hozenDomManager = SWAKInjector.getInstance(HozenDomManager.class);
        checkTmttkinItenBean.setKykKihon(hozenDomManager.getKykKihon("11810111174"));

        C_ChkkekkaKbn chkkekkaKbn = checkTmttkinIten.exec("online", "reference", checkTmttkinItenBean);

        exClassificationEquals(chkkekkaKbn, C_ChkkekkaKbn.SEIJYOU, "チェック結果区分");
        exStringEquals(checkTmttkinIten.getErrorMessage(), "", "エラーメッセージ");
        exStringEquals(checkTmttkinIten.getErrorMessageCode(), "", "エラーメッセージコード");
        exDateEquals(checkTmttkinIten.getKykymd(), null, "契約日");
    }

    @Test
    @TestOrder(1230)
    public void testExec_A23() {

        CheckTmttkinIten checkTmttkinIten = SWAKInjector.getInstance(CheckTmttkinIten.class);

        CheckTmttkinItenBean checkTmttkinItenBean = SWAKInjector.getInstance(CheckTmttkinItenBean.class);

        checkTmttkinItenBean.setSyoruiukeymd(BizDate.valueOf(20170228));
        checkTmttkinItenBean.setTmttknitenkbn(C_Tmttknitenkbn.ITEN);
        checkTmttkinItenBean.setTmttknitenymd(BizDate.valueOf(20170530));

        HozenDomManager hozenDomManager = SWAKInjector.getInstance(HozenDomManager.class);
        checkTmttkinItenBean.setKykKihon(hozenDomManager.getKykKihon("11810111174"));

        C_ChkkekkaKbn chkkekkaKbn = checkTmttkinIten.exec("online", "reference", checkTmttkinItenBean);

        exClassificationEquals(chkkekkaKbn, C_ChkkekkaKbn.SEIJYOU, "チェック結果区分");
        exStringEquals(checkTmttkinIten.getErrorMessage(), "", "エラーメッセージ");
        exStringEquals(checkTmttkinIten.getErrorMessageCode(), "", "エラーメッセージコード");
        exDateEquals(checkTmttkinIten.getKykymd(), null, "契約日");
    }

    @Test
    @TestOrder(1240)
    public void testExec_A24() {

        CheckTmttkinIten checkTmttkinIten = SWAKInjector.getInstance(CheckTmttkinIten.class);

        CheckTmttkinItenBean checkTmttkinItenBean = SWAKInjector.getInstance(CheckTmttkinItenBean.class);

        checkTmttkinItenBean.setSyoruiukeymd(BizDate.valueOf(20180208));
        checkTmttkinItenBean.setTmttknitenkbn(C_Tmttknitenkbn.ITEN);
        checkTmttkinItenBean.setTmttknitenymd(BizDate.valueOf(20180207));

        HozenDomManager hozenDomManager = SWAKInjector.getInstance(HozenDomManager.class);
        checkTmttkinItenBean.setKykKihon(hozenDomManager.getKykKihon("11810111141"));

        C_ChkkekkaKbn chkkekkaKbn = checkTmttkinIten.exec("drctservice", "inputkey", checkTmttkinItenBean);

        exClassificationEquals(chkkekkaKbn, C_ChkkekkaKbn.ERROR, "チェック結果区分");
        exStringEquals(checkTmttkinIten.getErrorMessage(),
            "テーブル取得エラー　IT_KykSyouhn　key:syono=11810111141", "エラーメッセージ");
        exStringEquals(checkTmttkinIten.getErrorMessageCode(), "4002", "エラーメッセージコード");
        exDateEquals(checkTmttkinIten.getKykymd(), null, "契約日");
    }

    @Test
    @TestOrder(1250)
    public void testExec_A25() {

        CheckTmttkinIten checkTmttkinIten = SWAKInjector.getInstance(CheckTmttkinIten.class);

        C_ChkkekkaKbn chkkekkaKbn = checkTmttkinIten.exec(null, "inputcontents", null);

        exClassificationEquals(chkkekkaKbn, C_ChkkekkaKbn.SEIJYOU, "チェック結果区分");
        exStringEquals(checkTmttkinIten.getErrorMessage(), "", "エラーメッセージ");
        exStringEquals(checkTmttkinIten.getErrorMessageCode(), "", "エラーメッセージコード");
        exDateEquals(checkTmttkinIten.getKykymd(), null, "契約日");
    }

    @Test(expected = BizAppException.class)
    @TestOrder(1260)
    public void testExec_A26() {

        CheckTmttkinIten checkTmttkinIten = SWAKInjector.getInstance(CheckTmttkinIten.class);

        CheckTmttkinItenBean checkTmttkinItenBean = SWAKInjector.getInstance(CheckTmttkinItenBean.class);

        checkTmttkinItenBean.setSyoruiukeymd(BizDate.valueOf(20180208));
        checkTmttkinItenBean.setTmttknitenkbn(C_Tmttknitenkbn.ITEN);
        checkTmttkinItenBean.setTmttknitenymd(BizDate.valueOf(20180207));

        HozenDomManager hozenDomManager = SWAKInjector.getInstance(HozenDomManager.class);
        checkTmttkinItenBean.setKykKihon(hozenDomManager.getKykKihon("11809111114"));

        try {
            checkTmttkinIten.exec("online", "inputcontents", checkTmttkinItenBean);
        } catch (Exception e) {
            exStringEquals(e.getMessage(),
                "テーブル取得エラー　IT_KykSyouhn　key:syono=11809111114",
                "エラーメッセージ(BizAppException)");
            throw e;
        }
    }

    @Test(expected = BizAppException.class)
    @TestOrder(1270)
    public void testExec_A27() {

        CheckTmttkinIten checkTmttkinIten = SWAKInjector.getInstance(CheckTmttkinIten.class);

        CheckTmttkinItenBean checkTmttkinItenBean = SWAKInjector.getInstance(CheckTmttkinItenBean.class);

        checkTmttkinItenBean.setSyoruiukeymd(BizDate.valueOf(20180208));
        checkTmttkinItenBean.setTmttknitenkbn(C_Tmttknitenkbn.ITEN);
        checkTmttkinItenBean.setTmttknitenymd(BizDate.valueOf(20180207));

        HozenDomManager hozenDomManager = SWAKInjector.getInstance(HozenDomManager.class);
        checkTmttkinItenBean.setKykKihon(hozenDomManager.getKykKihon("17810000061"));

        try {
            checkTmttkinIten.exec("online", "inputcontents", checkTmttkinItenBean);
        } catch (Exception e) {
            exStringEquals(e.getMessage(),
                "テーブル取得エラー　IT_KykSyouhn　key:syono=17810000061",
                "エラーメッセージ(BizAppException)");
            throw e;
        }
    }

    @Test(expected = BizLogicException.class)
    @TestOrder(1280)
    public void testExec_A28() {

        CheckTmttkinIten checkTmttkinIten = SWAKInjector.getInstance(CheckTmttkinIten.class);

        CheckTmttkinItenBean checkTmttkinItenBean = SWAKInjector.getInstance(CheckTmttkinItenBean.class);

        checkTmttkinItenBean.setSyoruiukeymd(BizDate.valueOf(20180208));
        checkTmttkinItenBean.setTmttknitenkbn(C_Tmttknitenkbn.ITEN);
        checkTmttkinItenBean.setTmttknitenymd(BizDate.valueOf(20180207));

        HozenDomManager hozenDomManager = SWAKInjector.getInstance(HozenDomManager.class);
        checkTmttkinItenBean.setKykKihon(hozenDomManager.getKykKihon("11809111169"));

        try {
            checkTmttkinIten.exec("online", "inputkey", checkTmttkinItenBean);
        } catch (Exception e) {
            exStringEquals(e.getMessage(),
                "全額が定率積立のため、処理できません。",
                "エラーメッセージ(BizLogicException)");
            throw e;
        }
    }

    @Test
    @TestOrder(1290)
    public void testExec_A29() {

        CheckTmttkinIten checkTmttkinIten = SWAKInjector.getInstance(CheckTmttkinIten.class);

        CheckTmttkinItenBean checkTmttkinItenBean = SWAKInjector.getInstance(CheckTmttkinItenBean.class);

        checkTmttkinItenBean.setSyoruiukeymd(BizDate.valueOf(20180208));
        checkTmttkinItenBean.setTmttknitenkbn(C_Tmttknitenkbn.ITEN);
        checkTmttkinItenBean.setTmttknitenymd(BizDate.valueOf(20180207));

        HozenDomManager hozenDomManager = SWAKInjector.getInstance(HozenDomManager.class);
        checkTmttkinItenBean.setKykKihon(hozenDomManager.getKykKihon("11809111169"));

        C_ChkkekkaKbn chkkekkaKbn = checkTmttkinIten.exec("drctservice", "inputkey", checkTmttkinItenBean);

        exClassificationEquals(chkkekkaKbn, C_ChkkekkaKbn.ERROR, "チェック結果区分");
        exStringEquals(checkTmttkinIten.getErrorMessage(),
            "全額が定率積立のため、処理できません。", "エラーメッセージ");
        exStringEquals(checkTmttkinIten.getErrorMessageCode(), "4001", "エラーメッセージコード");
        exDateEquals(checkTmttkinIten.getKykymd(), null, "契約日");
    }
}