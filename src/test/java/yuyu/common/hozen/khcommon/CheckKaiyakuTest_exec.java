package yuyu.common.hozen.khcommon;

import static yuyu.testinfr.YuyuFunctionTestUtil.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.dgic.testing.common.virtualmock.MockObjectManager;
import jp.co.slcs.swak.bizinfr.exception.BizAppException;
import jp.co.slcs.swak.bizinfr.exception.BizLogicException;
import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.date.BizDateYM;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.app.base.ref.TestDataMaker;
import yuyu.app.base.ref.TestDataMakerException;
import yuyu.common.biz.exception.CommonBizAppException;
import yuyu.common.hozen.haitou.CheckDShrKaiyaku;
import yuyu.def.classification.C_KaiyakuchkkekkaKbn;
import yuyu.def.classification.C_YouhiKbn;
import yuyu.def.hozen.manager.HozenDomManager;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;
import yuyu.testinfr.inject.MockModuleBinder;

import com.google.inject.AbstractModule;

/**
 * 解約共通チェッククラスのメソッド {@link CheckKaiyaku#exec(String, String, CheckKaiyakuBean)} テスト用クラスです。<br />
 */
@RunWith(OrderedRunner.class)
public class CheckKaiyakuTest_exec {

    @Inject
    private CheckKaiyaku checkKaiyaku;

    private final static String fileName = "UT-SP_単体テスト仕様書（共通）_解約共通チェック";

    private final static String sheetName = "INデータ";

    @Before
    public void Before () {
        MockModuleBinder.bind(new AbstractModule() {
            @Override
            protected void configure() {
                bind(CheckDShrKaiyaku.class).to(CheckDShrKaiyakuMockForHozen.class);
                bind(HanteiKhSisuurendoTmttknJyoutai.class).to(HanteiKhSisuurendoTmttknJyoutaiMockForHozen.class);
            }
        });
    }

    @BeforeClass
    public static void testInit() {

        CheckDShrKaiyakuMockForHozen.caller = CheckKaiyakuTest_exec.class;
        HanteiKhSisuurendoTmttknJyoutaiMockForHozen.caller = CheckKaiyakuTest_exec.class;
    }

    @AfterClass
    public static void testClear() {

        CheckDShrKaiyakuMockForHozen.caller = null;
        CheckDShrKaiyakuMockForHozen.SYORIPTN = null;
        HanteiKhSisuurendoTmttknJyoutaiMockForHozen.caller = null;
        HanteiKhSisuurendoTmttknJyoutaiMockForHozen.SYORIPTN = null;
    }

    @BeforeClass
    @Transactional
    public static void insertTestData() {
        try {

            TestDataMaker testDataMaker = new TestDataMaker();

            HashMap<String, Map<String, List<Map<String, String>>>> testDataAndTblMap;

            testDataAndTblMap = testDataMaker.getInData(CheckKaiyakuTest_exec.class, fileName, sheetName);

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
        C_KaiyakuchkkekkaKbn kaiyakuchkkekkaKbn = checkKaiyaku.exec(null, "inputcontents", null);

        exClassificationEquals(kaiyakuchkkekkaKbn, C_KaiyakuchkkekkaKbn.SEIJYOU, "解約共通チェック結果区分");
        exStringEquals(checkKaiyaku.getErrorMessage(), "", "エラーメッセージ");
        exStringEquals(checkKaiyaku.getErrorMessageCode(), "", "エラーメッセージコード");
    }

    @Test
    @TestOrder(1020)
    public void testExec_A2() {
        C_KaiyakuchkkekkaKbn kaiyakuchkkekkaKbn = checkKaiyaku.exec("online", "inputkey", new CheckKaiyakuBean());

        exClassificationEquals(kaiyakuchkkekkaKbn, C_KaiyakuchkkekkaKbn.SEIJYOU, "解約共通チェック結果区分");
        exStringEquals(checkKaiyaku.getErrorMessage(), "", "エラーメッセージ");
        exStringEquals(checkKaiyaku.getErrorMessageCode(), "", "エラーメッセージコード");
    }

    @Test(expected = BizLogicException.class)
    @TestOrder(1030)
    public void testExec_A3() {

        CheckKaiyakuBean checkKaiyakuBean = new CheckKaiyakuBean();
        checkKaiyakuBean.setSyoruiukeYmd(BizDate.valueOf(20180207));
        checkKaiyakuBean.setYendthnkYmd(BizDate.valueOf(20180208));

        try {
            checkKaiyaku.exec("online", "inputcontents", checkKaiyakuBean);
        } catch (Exception e) {
            exStringEquals(e.getMessage(),
                "書類受付日以降に円建変更が行われています。円建変更取消をしてください。",
                "エラーメッセージ(BizLogicException)");
            throw e;
        }
    }

    @Test
    @TestOrder(1040)
    public void testExec_A4() {
        CheckKaiyakuBean checkKaiyakuBean = new CheckKaiyakuBean();
        checkKaiyakuBean.setSyoruiukeYmd(BizDate.valueOf(20180207));
        checkKaiyakuBean.setYendthnkYmd(BizDate.valueOf(20180208));

        C_KaiyakuchkkekkaKbn kaiyakuchkkekkaKbn = checkKaiyaku.exec("batch", "inputcontents", checkKaiyakuBean);

        exClassificationEquals(kaiyakuchkkekkaKbn, C_KaiyakuchkkekkaKbn.ERROR, "解約共通チェック結果区分");
        exStringEquals(checkKaiyaku.getErrorMessage(),
            "書類受付日以降に円建変更が行われています。円建変更取消をしてください。", "エラーメッセージ");
        exStringEquals(checkKaiyaku.getErrorMessageCode(), "3003", "エラーメッセージコード");
    }

    @Test
    @TestOrder(1050)
    public void testExec_A5() {
        CheckKaiyakuBean checkKaiyakuBean = new CheckKaiyakuBean();
        checkKaiyakuBean.setSyoruiukeYmd(BizDate.valueOf(20180207));
        checkKaiyakuBean.setYendthnkYmd(BizDate.valueOf(20180208));

        C_KaiyakuchkkekkaKbn kaiyakuchkkekkaKbn = checkKaiyaku.exec("drctservice", "reference", checkKaiyakuBean);

        exClassificationEquals(kaiyakuchkkekkaKbn, C_KaiyakuchkkekkaKbn.ERROR, "解約共通チェック結果区分");
        exStringEquals(checkKaiyaku.getErrorMessage(),
            "書類受付日以降に円建変更が行われています。円建変更取消をしてください。", "エラーメッセージ");
        exStringEquals(checkKaiyaku.getErrorMessageCode(), "3003", "エラーメッセージコード");
    }

    @Test(expected = BizLogicException.class)
    @TestOrder(1060)
    public void testExec_A6() {

        CheckKaiyakuBean checkKaiyakuBean = new CheckKaiyakuBean();
        checkKaiyakuBean.setSyoruiukeYmd(BizDate.valueOf(20180208));
        checkKaiyakuBean.setYendthnkYmd(BizDate.valueOf(20180208));
        checkKaiyakuBean.setSyukykYmd(BizDate.valueOf(20180207));

        HozenDomManager hozenDomManager = SWAKInjector.getInstance(HozenDomManager.class);
        checkKaiyakuBean.setKykKihon(hozenDomManager.getKykKihon("11809111114"));

        try {
            checkKaiyaku.exec("online", "inputcontents", checkKaiyakuBean);
        } catch (Exception e) {
            exStringEquals(e.getMessage(),
                "先日付の変更があるため処理できません。", "エラーメッセージ(BizLogicException)");
            throw e;
        }
    }

    @Test
    @TestOrder(1070)
    public void testExec_A7() {
        CheckKaiyakuBean checkKaiyakuBean = new CheckKaiyakuBean();
        checkKaiyakuBean.setSyoruiukeYmd(BizDate.valueOf(20180208));
        checkKaiyakuBean.setYendthnkYmd(BizDate.valueOf(20180207));
        checkKaiyakuBean.setSyukykYmd(BizDate.valueOf(20180207));
        HozenDomManager hozenDomManager = SWAKInjector.getInstance(HozenDomManager.class);
        checkKaiyakuBean.setKykKihon(hozenDomManager.getKykKihon("11809111114"));

        C_KaiyakuchkkekkaKbn kaiyakuchkkekkaKbn = checkKaiyaku.exec("batch", "inputcontents", checkKaiyakuBean);

        exClassificationEquals(kaiyakuchkkekkaKbn, C_KaiyakuchkkekkaKbn.ERROR, "解約共通チェック結果区分");
        exStringEquals(checkKaiyaku.getErrorMessage(),
            "先日付の変更があるため処理できません。", "エラーメッセージ");
        exStringEquals(checkKaiyaku.getErrorMessageCode(), "3001", "エラーメッセージコード");
    }

    @Test
    @TestOrder(1080)
    public void testExec_A8() {
        CheckKaiyakuBean checkKaiyakuBean = new CheckKaiyakuBean();
        checkKaiyakuBean.setSyoruiukeYmd(BizDate.valueOf(20180208));
        checkKaiyakuBean.setYendthnkYmd(null);
        checkKaiyakuBean.setSyukykYmd(BizDate.valueOf(20180208));
        HozenDomManager hozenDomManager = SWAKInjector.getInstance(HozenDomManager.class);
        checkKaiyakuBean.setKykKihon(hozenDomManager.getKykKihon("11809111136"));

        C_KaiyakuchkkekkaKbn kaiyakuchkkekkaKbn = checkKaiyaku.exec("drctservice", "reference", checkKaiyakuBean);

        exClassificationEquals(kaiyakuchkkekkaKbn, C_KaiyakuchkkekkaKbn.ERROR, "解約共通チェック結果区分");
        exStringEquals(checkKaiyaku.getErrorMessage(),
            "先日付の変更があるため処理できません。", "エラーメッセージ");
        exStringEquals(checkKaiyaku.getErrorMessageCode(), "3001", "エラーメッセージコード");
    }

    @Test
    @TestOrder(1090)
    public void testExec_A9 () {
        MockObjectManager.initialize();
        CheckDShrKaiyakuMockForHozen.SYORIPTN = CheckDShrKaiyakuMockForHozen.TESTPATTERN4;
        CheckKaiyakuBean checkKaiyakuBean = new CheckKaiyakuBean();
        checkKaiyakuBean.setSyoruiukeYmd(BizDate.valueOf(20180208));
        checkKaiyakuBean.setYendthnkYmd(null);
        checkKaiyakuBean.setSyukykYmd(BizDate.valueOf(20180207));
        checkKaiyakuBean.setSyoriYmd(BizDate.valueOf(20180206));
        HozenDomManager hozenDomManager = SWAKInjector.getInstance(HozenDomManager.class);
        checkKaiyakuBean.setKykKihon(hozenDomManager.getKykKihon("11809111147"));
        checkKaiyakuBean.setAnsyuKihon(hozenDomManager.getAnsyuKihon("11809111147"));

        C_KaiyakuchkkekkaKbn kaiyakuchkkekkaKbn = checkKaiyaku.exec("online", "inputcontents", checkKaiyakuBean);

        exClassificationEquals(kaiyakuchkkekkaKbn, C_KaiyakuchkkekkaKbn.SEIJYOU, "解約共通チェック結果区分");
        exStringEquals(checkKaiyaku.getErrorMessage(), "", "エラーメッセージ");
        exStringEquals(checkKaiyaku.getErrorMessageCode(), "", "エラーメッセージコード");


        String syono = (String) MockObjectManager.getArgument(CheckDShrKaiyakuMockForHozen.class, "checkDShr", 0, 0);
        exStringEquals(syono, "11809111147", "証券番号");
        BizDate kijyunYmd = (BizDate) MockObjectManager.getArgument(CheckDShrKaiyakuMockForHozen.class, "checkDShr", 0, 1);
        exDateEquals(kijyunYmd, BizDate.valueOf(20180208), "計算基準日");
        BizDateYM jkipjytYm = (BizDateYM) MockObjectManager.getArgument(CheckDShrKaiyakuMockForHozen.class, "checkDShr", 0, 2);
        exDateYMEquals(jkipjytYm, BizDateYM.valueOf(202005), "次回Ｐ充当年月");
        C_YouhiKbn pMinyuuCheckYouhi = (C_YouhiKbn) MockObjectManager.getArgument(CheckDShrKaiyakuMockForHozen.class, "checkDShr", 0, 3);
        exClassificationEquals(pMinyuuCheckYouhi, C_YouhiKbn.YOU, "Ｐ未入チェック要否");
        BizDate syoriYmd = (BizDate) MockObjectManager.getArgument(CheckDShrKaiyakuMockForHozen.class, "checkDShr", 0, 4);
        exDateEquals(syoriYmd, BizDate.valueOf(20180206), "処理日");

    }

    @Test
    @TestOrder(1100)
    public void testExec_A10() {
        MockObjectManager.initialize();
        CheckDShrKaiyakuMockForHozen.SYORIPTN = CheckDShrKaiyakuMockForHozen.TESTPATTERN4;
        CheckKaiyakuBean checkKaiyakuBean = new CheckKaiyakuBean();
        checkKaiyakuBean.setSyoruiukeYmd(BizDate.valueOf(20180208));
        checkKaiyakuBean.setYendthnkYmd(null);
        HozenDomManager hozenDomManager = SWAKInjector.getInstance(HozenDomManager.class);
        checkKaiyakuBean.setKykKihon(hozenDomManager.getKykKihon("99806001010"));
        checkKaiyakuBean.setAnsyuKihon(hozenDomManager.getAnsyuKihon("99806001010"));

        C_KaiyakuchkkekkaKbn kaiyakuchkkekkaKbn = checkKaiyaku.exec("batch", "inputcontents", checkKaiyakuBean);

        exClassificationEquals(kaiyakuchkkekkaKbn, C_KaiyakuchkkekkaKbn.SEIJYOU, "解約共通チェック結果区分");
        exStringEquals(checkKaiyaku.getErrorMessage(), "", "エラーメッセージ");
        exStringEquals(checkKaiyaku.getErrorMessageCode(), "", "エラーメッセージコード");
    }

    @Test(expected = BizLogicException.class)
    @TestOrder(1110)
    public void testExec_A11() {

        CheckKaiyakuBean checkKaiyakuBean = new CheckKaiyakuBean();
        checkKaiyakuBean.setSyoruiukeYmd(BizDate.valueOf(20180207));
        checkKaiyakuBean.setYendthnkYmd(null);
        checkKaiyakuBean.setSyukykYmd(BizDate.valueOf(20180208));

        try {
            checkKaiyaku.exec("online", "inputcontents", checkKaiyakuBean);
        } catch (Exception e) {
            exStringEquals(e.getMessage(),
                "書類受付日が契約日前のため処理できません。", "エラーメッセージ(BizLogicException)");
            throw e;
        }
    }

    @Test
    @TestOrder(1120)
    public void testExec_A12() {
        CheckKaiyakuBean checkKaiyakuBean = new CheckKaiyakuBean();
        checkKaiyakuBean.setSyoruiukeYmd(BizDate.valueOf(20180207));
        checkKaiyakuBean.setYendthnkYmd(null);
        checkKaiyakuBean.setSyukykYmd(BizDate.valueOf(20180208));

        C_KaiyakuchkkekkaKbn kaiyakuchkkekkaKbn = checkKaiyaku.exec("batch", "startinputcontents", checkKaiyakuBean);

        exClassificationEquals(kaiyakuchkkekkaKbn, C_KaiyakuchkkekkaKbn.ERROR, "解約共通チェック結果区分");
        exStringEquals(checkKaiyaku.getErrorMessage(),
            "解約受付日が契約日前のため処理できません。", "エラーメッセージ");
        exStringEquals(checkKaiyaku.getErrorMessageCode(), "3002", "エラーメッセージコード");
    }

    @Test
    @TestOrder(1130)
    public void testExec_A13() {
        CheckKaiyakuBean checkKaiyakuBean = new CheckKaiyakuBean();
        checkKaiyakuBean.setSyoruiukeYmd(BizDate.valueOf(20180207));
        checkKaiyakuBean.setYendthnkYmd(null);
        checkKaiyakuBean.setSyukykYmd(BizDate.valueOf(20180208));

        C_KaiyakuchkkekkaKbn kaiyakuchkkekkaKbn = checkKaiyaku.exec("drctservice", "reference", checkKaiyakuBean);

        exClassificationEquals(kaiyakuchkkekkaKbn, C_KaiyakuchkkekkaKbn.ERROR, "解約共通チェック結果区分");
        exStringEquals(checkKaiyaku.getErrorMessage(),
            "解約受付日が契約日前のため処理できません。", "エラーメッセージ");
        exStringEquals(checkKaiyaku.getErrorMessageCode(), "3002", "エラーメッセージコード");
    }

    @Test
    @TestOrder(1140)
    public void testExec_A14() {
        MockObjectManager.initialize();
        CheckDShrKaiyakuMockForHozen.SYORIPTN = CheckDShrKaiyakuMockForHozen.TESTPATTERN4;
        CheckKaiyakuBean checkKaiyakuBean = new CheckKaiyakuBean();
        checkKaiyakuBean.setSyoruiukeYmd(BizDate.valueOf(20180208));
        checkKaiyakuBean.setYendthnkYmd(null);
        checkKaiyakuBean.setSyukykYmd(BizDate.valueOf(20180208));
        HozenDomManager hozenDomManager = SWAKInjector.getInstance(HozenDomManager.class);
        checkKaiyakuBean.setKykKihon(hozenDomManager.getKykKihon("11809111158"));
        checkKaiyakuBean.setAnsyuKihon(hozenDomManager.getAnsyuKihon("11809111158"));

        C_KaiyakuchkkekkaKbn kaiyakuchkkekkaKbn = checkKaiyaku.exec("batch", null, checkKaiyakuBean);

        exClassificationEquals(kaiyakuchkkekkaKbn, C_KaiyakuchkkekkaKbn.SEIJYOU, "解約共通チェック結果区分");
        exStringEquals(checkKaiyaku.getErrorMessage(), "", "エラーメッセージ");
        exStringEquals(checkKaiyaku.getErrorMessageCode(), "", "エラーメッセージコード");
    }

    @Test
    @TestOrder(1150)
    public void testExec_A15() {
        MockObjectManager.initialize();
        CheckDShrKaiyakuMockForHozen.SYORIPTN = CheckDShrKaiyakuMockForHozen.TESTPATTERN4;
        CheckKaiyakuBean checkKaiyakuBean = new CheckKaiyakuBean();
        checkKaiyakuBean.setSyoruiukeYmd(BizDate.valueOf(20180209));
        checkKaiyakuBean.setYendthnkYmd(null);
        checkKaiyakuBean.setSyukykYmd(BizDate.valueOf(20180208));
        HozenDomManager hozenDomManager = SWAKInjector.getInstance(HozenDomManager.class);
        checkKaiyakuBean.setKykKihon(hozenDomManager.getKykKihon("11809111158"));
        checkKaiyakuBean.setAnsyuKihon(hozenDomManager.getAnsyuKihon("11809111158"));

        C_KaiyakuchkkekkaKbn kaiyakuchkkekkaKbn = checkKaiyaku.exec("drctservice", null, checkKaiyakuBean);

        exClassificationEquals(kaiyakuchkkekkaKbn, C_KaiyakuchkkekkaKbn.SEIJYOU, "解約共通チェック結果区分");
        exStringEquals(checkKaiyaku.getErrorMessage(), "", "エラーメッセージ");
        exStringEquals(checkKaiyaku.getErrorMessageCode(), "", "エラーメッセージコード");
    }

    @Test(expected = CommonBizAppException.class)
    @TestOrder(1160)
    public void testExec_A16() {
        MockObjectManager.initialize();
        CheckDShrKaiyakuMockForHozen.SYORIPTN = CheckDShrKaiyakuMockForHozen.TESTPATTERN5;
        CheckKaiyakuBean checkKaiyakuBean = new CheckKaiyakuBean();
        checkKaiyakuBean.setSyoruiukeYmd(BizDate.valueOf(20180208));
        checkKaiyakuBean.setYendthnkYmd(null);
        checkKaiyakuBean.setSyukykYmd(BizDate.valueOf(20180207));
        checkKaiyakuBean.setSyoriYmd(BizDate.valueOf(20180202));
        HozenDomManager hozenDomManager = SWAKInjector.getInstance(HozenDomManager.class);
        checkKaiyakuBean.setKykKihon(hozenDomManager.getKykKihon("11809111147"));
        checkKaiyakuBean.setAnsyuKihon(hozenDomManager.getAnsyuKihon("11809111147"));
        try {
            checkKaiyaku.exec("online", "inputcontents", checkKaiyakuBean);
        } catch (BizAppException e) {
            exStringEquals(e.getMessage(),
                "システム整合性エラーです。配当支払チェックが実行できませんでした。", "エラーメッセージ");
            throw e;
        }
    }

    @Test
    @TestOrder(1170)
    public void testExec_A17() {
        MockObjectManager.initialize();
        CheckDShrKaiyakuMockForHozen.SYORIPTN = CheckDShrKaiyakuMockForHozen.TESTPATTERN1;
        CheckKaiyakuBean checkKaiyakuBean = new CheckKaiyakuBean();
        checkKaiyakuBean.setSyoruiukeYmd(BizDate.valueOf(20180208));
        checkKaiyakuBean.setYendthnkYmd(null);
        checkKaiyakuBean.setSyukykYmd(BizDate.valueOf(20180208));
        checkKaiyakuBean.setSyoriYmd(BizDate.valueOf(20180202));
        HozenDomManager hozenDomManager = SWAKInjector.getInstance(HozenDomManager.class);
        checkKaiyakuBean.setKykKihon(hozenDomManager.getKykKihon("11809111158"));
        checkKaiyakuBean.setAnsyuKihon(hozenDomManager.getAnsyuKihon("11809111158"));

        C_KaiyakuchkkekkaKbn kaiyakuchkkekkaKbn = checkKaiyaku.exec("batch", "inputcontents", checkKaiyakuBean);

        exClassificationEquals(kaiyakuchkkekkaKbn, C_KaiyakuchkkekkaKbn.ERROR, "解約共通チェック結果区分");
        exStringEquals(checkKaiyaku.getErrorMessage(),
            "配当整合チェックエラーです。システム管理者にお問い合わせください。", "エラーメッセージ");
        exStringEquals(checkKaiyaku.getErrorMessageCode(), "5001", "エラーメッセージコード");

        String syono = (String) MockObjectManager.getArgument(CheckDShrKaiyakuMockForHozen.class, "checkDShr", 0, 0);
        exStringEquals(syono, "11809111158", "証券番号");

        BizDate kijyunYmd = (BizDate) MockObjectManager.getArgument(CheckDShrKaiyakuMockForHozen.class, "checkDShr", 0, 1);
        exDateEquals(kijyunYmd, BizDate.valueOf(20180208), "計算基準日");

        BizDateYM jkipjytYm = (BizDateYM) MockObjectManager.getArgument(CheckDShrKaiyakuMockForHozen.class, "checkDShr", 0, 2);
        exDateYMEquals(jkipjytYm, BizDateYM.valueOf(202005), "次回Ｐ充当年月");

        C_YouhiKbn pMinyuuCheckYouhi = (C_YouhiKbn) MockObjectManager.getArgument(CheckDShrKaiyakuMockForHozen.class, "checkDShr", 0, 3);
        exClassificationEquals(pMinyuuCheckYouhi, null, "Ｐ未入チェック要否");

        BizDate syoriYmd = (BizDate) MockObjectManager.getArgument(CheckDShrKaiyakuMockForHozen.class, "checkDShr", 0, 4);
        exDateEquals(syoriYmd, BizDate.valueOf(20180202), "処理日");

    }

    @Test
    @TestOrder(1180)
    public void testExec_A18() {
        MockObjectManager.initialize();
        CheckDShrKaiyakuMockForHozen.SYORIPTN = CheckDShrKaiyakuMockForHozen.TESTPATTERN1;
        CheckKaiyakuBean checkKaiyakuBean = new CheckKaiyakuBean();
        checkKaiyakuBean.setSyoruiukeYmd(BizDate.valueOf(20180209));
        checkKaiyakuBean.setYendthnkYmd(null);
        checkKaiyakuBean.setSyukykYmd(BizDate.valueOf(20180208));
        checkKaiyakuBean.setSyoriYmd(BizDate.valueOf(20180202));
        HozenDomManager hozenDomManager = SWAKInjector.getInstance(HozenDomManager.class);
        checkKaiyakuBean.setKykKihon(hozenDomManager.getKykKihon("11809111192"));
        checkKaiyakuBean.setAnsyuKihon(hozenDomManager.getAnsyuKihon("11809111192"));

        C_KaiyakuchkkekkaKbn kaiyakuchkkekkaKbn = checkKaiyaku.exec("drctservice", null, checkKaiyakuBean);

        exClassificationEquals(kaiyakuchkkekkaKbn, C_KaiyakuchkkekkaKbn.ERROR, "解約共通チェック結果区分");
        exStringEquals(checkKaiyaku.getErrorMessage(),
            "配当整合チェックエラーです。システム管理者にお問い合わせください。", "エラーメッセージ");
        exStringEquals(checkKaiyaku.getErrorMessageCode(), "5001", "エラーメッセージコード");

        String syono = (String) MockObjectManager.getArgument(CheckDShrKaiyakuMockForHozen.class, "checkDShr", 0, 0);
        exStringEquals(syono, "11809111192", "証券番号");

        BizDate kijyunYmd = (BizDate) MockObjectManager.getArgument(CheckDShrKaiyakuMockForHozen.class, "checkDShr", 0, 1);
        exDateEquals(kijyunYmd, BizDate.valueOf(20180209), "計算基準日");

        BizDateYM jkipjytYm = (BizDateYM) MockObjectManager.getArgument(CheckDShrKaiyakuMockForHozen.class, "checkDShr", 0, 2);
        exDateYMEquals(jkipjytYm, BizDateYM.valueOf(202005), "次回Ｐ充当年月");

        C_YouhiKbn pMinyuuCheckYouhi = (C_YouhiKbn) MockObjectManager.getArgument(CheckDShrKaiyakuMockForHozen.class, "checkDShr", 0, 3);
        exClassificationEquals(pMinyuuCheckYouhi, C_YouhiKbn.YOU, "Ｐ未入チェック要否");

        BizDate syoriYmd = (BizDate) MockObjectManager.getArgument(CheckDShrKaiyakuMockForHozen.class, "checkDShr", 0, 4);
        exDateEquals(syoriYmd, BizDate.valueOf(20180202), "処理日");

    }

    @Test(expected = BizLogicException.class)
    @TestOrder(1190)
    public void testExec_A19() {
        MockObjectManager.initialize();
        CheckDShrKaiyakuMockForHozen.SYORIPTN = CheckDShrKaiyakuMockForHozen.TESTPATTERN1;
        CheckKaiyakuBean checkKaiyakuBean = new CheckKaiyakuBean();
        checkKaiyakuBean.setSyoruiukeYmd(BizDate.valueOf(20180208));
        checkKaiyakuBean.setYendthnkYmd(null);
        checkKaiyakuBean.setSyukykYmd(BizDate.valueOf(20180207));
        checkKaiyakuBean.setSyoriYmd(BizDate.valueOf(20180202));
        HozenDomManager hozenDomManager = SWAKInjector.getInstance(HozenDomManager.class);
        checkKaiyakuBean.setKykKihon(hozenDomManager.getKykKihon("11809111147"));
        checkKaiyakuBean.setAnsyuKihon(hozenDomManager.getAnsyuKihon("11809111147"));
        try {
            checkKaiyaku.exec("online", "inputcontents", checkKaiyakuBean);
        } catch (BizAppException e) {
            exStringEquals(e.getMessage(),
                "システム整合性エラーです。配当整合チェックエラーです。システム管理者にお問い合わせください。",
                "エラーメッセージ");
            throw e;
        }
    }

    @Test
    @TestOrder(1200)
    public void testExec_A20() {
        MockObjectManager.initialize();
        CheckDShrKaiyakuMockForHozen.SYORIPTN = CheckDShrKaiyakuMockForHozen.TESTPATTERN2;
        CheckKaiyakuBean checkKaiyakuBean = new CheckKaiyakuBean();
        checkKaiyakuBean.setSyoruiukeYmd(BizDate.valueOf(20180208));
        checkKaiyakuBean.setYendthnkYmd(null);
        checkKaiyakuBean.setSyukykYmd(BizDate.valueOf(20180208));
        checkKaiyakuBean.setSyoriYmd(BizDate.valueOf(20180202));
        HozenDomManager hozenDomManager = SWAKInjector.getInstance(HozenDomManager.class);
        checkKaiyakuBean.setKykKihon(hozenDomManager.getKykKihon("12806000018"));
        checkKaiyakuBean.setAnsyuKihon(hozenDomManager.getAnsyuKihon("12806000018"));

        C_KaiyakuchkkekkaKbn kaiyakuchkkekkaKbn = checkKaiyaku.exec("batch", "inputcontents", checkKaiyakuBean);

        exClassificationEquals(kaiyakuchkkekkaKbn, C_KaiyakuchkkekkaKbn.ERROR, "解約共通チェック結果区分");
        exStringEquals(checkKaiyaku.getErrorMessage(),
            "配当金が未反映のため、処理できません。配当金反映後に処理可能となります。", "エラーメッセージ");
        exStringEquals(checkKaiyaku.getErrorMessageCode(), "5002", "エラーメッセージコード");
        String syono = (String) MockObjectManager.getArgument(CheckDShrKaiyakuMockForHozen.class, "checkDShr", 0, 0);
        exStringEquals(syono, "12806000018", "証券番号");

        BizDate kijyunYmd = (BizDate) MockObjectManager.getArgument(CheckDShrKaiyakuMockForHozen.class, "checkDShr", 0, 1);
        exDateEquals(kijyunYmd, BizDate.valueOf(20180208), "計算基準日");

        BizDateYM jkipjytYm = (BizDateYM) MockObjectManager.getArgument(CheckDShrKaiyakuMockForHozen.class, "checkDShr", 0, 2);
        exDateYMEquals(jkipjytYm, BizDateYM.valueOf(202005), "次回Ｐ充当年月");

        C_YouhiKbn pMinyuuCheckYouhi = (C_YouhiKbn) MockObjectManager.getArgument(CheckDShrKaiyakuMockForHozen.class, "checkDShr", 0, 3);
        exClassificationEquals(pMinyuuCheckYouhi, C_YouhiKbn.HUYOU, "Ｐ未入チェック要否");

        BizDate syoriYmd = (BizDate) MockObjectManager.getArgument(CheckDShrKaiyakuMockForHozen.class, "checkDShr", 0, 4);
        exDateEquals(syoriYmd, BizDate.valueOf(20180202), "処理日");
    }

    @Test
    @TestOrder(1210)
    public void testExec_A21() {
        MockObjectManager.initialize();
        CheckDShrKaiyakuMockForHozen.SYORIPTN = CheckDShrKaiyakuMockForHozen.TESTPATTERN2;
        CheckKaiyakuBean checkKaiyakuBean = new CheckKaiyakuBean();
        checkKaiyakuBean.setSyoruiukeYmd(BizDate.valueOf(20180209));
        checkKaiyakuBean.setYendthnkYmd(null);
        checkKaiyakuBean.setSyukykYmd(BizDate.valueOf(20180208));
        checkKaiyakuBean.setSyoriYmd(BizDate.valueOf(20180202));
        HozenDomManager hozenDomManager = SWAKInjector.getInstance(HozenDomManager.class);
        checkKaiyakuBean.setKykKihon(hozenDomManager.getKykKihon("11809111158"));
        checkKaiyakuBean.setAnsyuKihon(hozenDomManager.getAnsyuKihon("11809111158"));

        C_KaiyakuchkkekkaKbn kaiyakuchkkekkaKbn = checkKaiyaku.exec("drctservice", null, checkKaiyakuBean);

        exClassificationEquals(kaiyakuchkkekkaKbn, C_KaiyakuchkkekkaKbn.ERROR, "解約共通チェック結果区分");
        exStringEquals(checkKaiyaku.getErrorMessage(),
            "配当金が未反映のため、処理できません。配当金反映後に処理可能となります。", "エラーメッセージ");
        exStringEquals(checkKaiyaku.getErrorMessageCode(), "5002", "エラーメッセージコード");
        String syono = (String) MockObjectManager.getArgument(CheckDShrKaiyakuMockForHozen.class, "checkDShr", 0, 0);
        exStringEquals(syono, "11809111158", "証券番号");

        BizDate kijyunYmd = (BizDate) MockObjectManager.getArgument(CheckDShrKaiyakuMockForHozen.class, "checkDShr", 0, 1);
        exDateEquals(kijyunYmd, BizDate.valueOf(20180209), "計算基準日");

        BizDateYM jkipjytYm = (BizDateYM) MockObjectManager.getArgument(CheckDShrKaiyakuMockForHozen.class, "checkDShr", 0, 2);
        exDateYMEquals(jkipjytYm, BizDateYM.valueOf(202005), "次回Ｐ充当年月");

        C_YouhiKbn pMinyuuCheckYouhi = (C_YouhiKbn) MockObjectManager.getArgument(CheckDShrKaiyakuMockForHozen.class, "checkDShr", 0, 3);
        exClassificationEquals(pMinyuuCheckYouhi, null, "Ｐ未入チェック要否");

        BizDate syoriYmd = (BizDate) MockObjectManager.getArgument(CheckDShrKaiyakuMockForHozen.class, "checkDShr", 0, 4);
        exDateEquals(syoriYmd, BizDate.valueOf(20180202), "処理日");
    }

    @Test(expected = BizLogicException.class)
    @TestOrder(1220)
    public void testExec_A22() {
        MockObjectManager.initialize();
        CheckDShrKaiyakuMockForHozen.SYORIPTN = CheckDShrKaiyakuMockForHozen.TESTPATTERN2;
        CheckKaiyakuBean checkKaiyakuBean = new CheckKaiyakuBean();
        checkKaiyakuBean.setSyoruiukeYmd(BizDate.valueOf(20180208));
        checkKaiyakuBean.setYendthnkYmd(null);
        checkKaiyakuBean.setSyukykYmd(BizDate.valueOf(20180207));
        checkKaiyakuBean.setSyoriYmd(BizDate.valueOf(20180202));
        HozenDomManager hozenDomManager = SWAKInjector.getInstance(HozenDomManager.class);
        checkKaiyakuBean.setKykKihon(hozenDomManager.getKykKihon("11809111147"));
        checkKaiyakuBean.setAnsyuKihon(hozenDomManager.getAnsyuKihon("11809111147"));
        try {
            checkKaiyaku.exec("online", "inputcontents", checkKaiyakuBean);
        } catch (Exception e) {
            exStringEquals(e.getMessage(),
                "配当金が未反映のため、処理できません。配当金反映後に処理可能となります。",
                "エラーメッセージ(BizLogicException)");
            throw e;
        }
    }

    @Test
    @TestOrder(1230)
    public void testExec_A23() {
        MockObjectManager.initialize();
        CheckDShrKaiyakuMockForHozen.SYORIPTN = CheckDShrKaiyakuMockForHozen.TESTPATTERN3;
        CheckKaiyakuBean checkKaiyakuBean = new CheckKaiyakuBean();
        checkKaiyakuBean.setSyoruiukeYmd(BizDate.valueOf(20180208));
        checkKaiyakuBean.setYendthnkYmd(null);
        checkKaiyakuBean.setSyukykYmd(BizDate.valueOf(20180208));
        checkKaiyakuBean.setSyoriYmd(BizDate.valueOf(20180202));
        HozenDomManager hozenDomManager = SWAKInjector.getInstance(HozenDomManager.class);
        checkKaiyakuBean.setKykKihon(hozenDomManager.getKykKihon("11809111158"));
        checkKaiyakuBean.setAnsyuKihon(hozenDomManager.getAnsyuKihon("11809111158"));

        C_KaiyakuchkkekkaKbn kaiyakuchkkekkaKbn = checkKaiyaku.exec("batch", "inputcontents", checkKaiyakuBean);

        exClassificationEquals(kaiyakuchkkekkaKbn, C_KaiyakuchkkekkaKbn.ERROR, "解約共通チェック結果区分");
        exStringEquals(checkKaiyaku.getErrorMessage(),
            "消滅日が配当金支払の処理日より前のため処理できません。手続き内容をご確認ください。",
            "エラーメッセージ");
        exStringEquals(checkKaiyaku.getErrorMessageCode(), "5003", "エラーメッセージコード");
        String syono = (String) MockObjectManager.getArgument(CheckDShrKaiyakuMockForHozen.class, "checkDShr", 0, 0);
        exStringEquals(syono, "11809111158", "証券番号");

        BizDate kijyunYmd = (BizDate) MockObjectManager.getArgument(CheckDShrKaiyakuMockForHozen.class, "checkDShr", 0, 1);
        exDateEquals(kijyunYmd, BizDate.valueOf(20180208), "計算基準日");

        BizDateYM jkipjytYm = (BizDateYM) MockObjectManager.getArgument(CheckDShrKaiyakuMockForHozen.class, "checkDShr", 0, 2);
        exDateYMEquals(jkipjytYm, BizDateYM.valueOf(202005), "次回Ｐ充当年月");

        C_YouhiKbn pMinyuuCheckYouhi = (C_YouhiKbn) MockObjectManager.getArgument(CheckDShrKaiyakuMockForHozen.class, "checkDShr", 0, 3);
        exClassificationEquals(pMinyuuCheckYouhi, null, "Ｐ未入チェック要否");

        BizDate syoriYmd = (BizDate) MockObjectManager.getArgument(CheckDShrKaiyakuMockForHozen.class, "checkDShr", 0, 4);
        exDateEquals(syoriYmd, BizDate.valueOf(20180202), "処理日");
    }

    @Test
    @TestOrder(1240)
    public void testExec_A24() {
        MockObjectManager.initialize();
        CheckDShrKaiyakuMockForHozen.SYORIPTN = CheckDShrKaiyakuMockForHozen.TESTPATTERN3;
        CheckKaiyakuBean checkKaiyakuBean = new CheckKaiyakuBean();
        checkKaiyakuBean.setSyoruiukeYmd(BizDate.valueOf(20180209));
        checkKaiyakuBean.setYendthnkYmd(null);
        checkKaiyakuBean.setSyukykYmd(BizDate.valueOf(20180208));
        checkKaiyakuBean.setSyoriYmd(BizDate.valueOf(20180202));
        HozenDomManager hozenDomManager = SWAKInjector.getInstance(HozenDomManager.class);
        checkKaiyakuBean.setKykKihon(hozenDomManager.getKykKihon("11809111158"));
        checkKaiyakuBean.setAnsyuKihon(hozenDomManager.getAnsyuKihon("11809111158"));

        C_KaiyakuchkkekkaKbn kaiyakuchkkekkaKbn = checkKaiyaku.exec("drctservice", null, checkKaiyakuBean);

        exClassificationEquals(kaiyakuchkkekkaKbn, C_KaiyakuchkkekkaKbn.ERROR, "解約共通チェック結果区分");
        exStringEquals(checkKaiyaku.getErrorMessage(),
            "消滅日が配当金支払の処理日より前のため処理できません。手続き内容をご確認ください。",
            "エラーメッセージ");
        exStringEquals(checkKaiyaku.getErrorMessageCode(), "5003", "エラーメッセージコード");
        String syono = (String) MockObjectManager.getArgument(CheckDShrKaiyakuMockForHozen.class, "checkDShr", 0, 0);
        exStringEquals(syono, "11809111158", "証券番号");

        BizDate kijyunYmd = (BizDate) MockObjectManager.getArgument(CheckDShrKaiyakuMockForHozen.class, "checkDShr", 0, 1);
        exDateEquals(kijyunYmd, BizDate.valueOf(20180209), "計算基準日");

        BizDateYM jkipjytYm = (BizDateYM) MockObjectManager.getArgument(CheckDShrKaiyakuMockForHozen.class, "checkDShr", 0, 2);
        exDateYMEquals(jkipjytYm, BizDateYM.valueOf(202005), "次回Ｐ充当年月");

        C_YouhiKbn pMinyuuCheckYouhi = (C_YouhiKbn) MockObjectManager.getArgument(CheckDShrKaiyakuMockForHozen.class, "checkDShr", 0, 3);
        exClassificationEquals(pMinyuuCheckYouhi, null, "Ｐ未入チェック要否");

        BizDate syoriYmd = (BizDate) MockObjectManager.getArgument(CheckDShrKaiyakuMockForHozen.class, "checkDShr", 0, 4);
        exDateEquals(syoriYmd, BizDate.valueOf(20180202), "処理日");
    }

    @Test(expected = BizLogicException.class)
    @TestOrder(1250)
    public void testExec_A25() {
        MockObjectManager.initialize();
        CheckDShrKaiyakuMockForHozen.SYORIPTN = CheckDShrKaiyakuMockForHozen.TESTPATTERN3;
        CheckKaiyakuBean checkKaiyakuBean = new CheckKaiyakuBean();
        checkKaiyakuBean.setSyoruiukeYmd(BizDate.valueOf(20180208));
        checkKaiyakuBean.setYendthnkYmd(null);
        checkKaiyakuBean.setSyukykYmd(BizDate.valueOf(20180207));
        checkKaiyakuBean.setSyoriYmd(BizDate.valueOf(20180202));
        HozenDomManager hozenDomManager = SWAKInjector.getInstance(HozenDomManager.class);
        checkKaiyakuBean.setKykKihon(hozenDomManager.getKykKihon("11809111147"));
        checkKaiyakuBean.setAnsyuKihon(hozenDomManager.getAnsyuKihon("11809111147"));
        try {
            checkKaiyaku.exec("online", "inputcontents", checkKaiyakuBean);
        } catch (Exception e) {
            exStringEquals(e.getMessage(),
                "消滅日が配当金支払の処理日より前のため処理できません。手続き内容をご確認ください。",
                "エラーメッセージ(BizLogicException)");
            throw e;
        }
    }

    @Test
    @TestOrder(1260)
    public void testExec_A26() {
        MockObjectManager.initialize();
        CheckDShrKaiyakuMockForHozen.SYORIPTN = CheckDShrKaiyakuMockForHozen.TESTPATTERN5;
        CheckKaiyakuBean checkKaiyakuBean = new CheckKaiyakuBean();
        checkKaiyakuBean.setSyoruiukeYmd(BizDate.valueOf(20180208));
        checkKaiyakuBean.setYendthnkYmd(null);
        checkKaiyakuBean.setSyukykYmd(BizDate.valueOf(20180208));
        checkKaiyakuBean.setSyoriYmd(BizDate.valueOf(20180202));
        HozenDomManager hozenDomManager = SWAKInjector.getInstance(HozenDomManager.class);
        checkKaiyakuBean.setKykKihon(hozenDomManager.getKykKihon("11809111158"));
        checkKaiyakuBean.setAnsyuKihon(hozenDomManager.getAnsyuKihon("11809111158"));

        C_KaiyakuchkkekkaKbn kaiyakuchkkekkaKbn = checkKaiyaku.exec("batch", "inputcontents", checkKaiyakuBean);

        exClassificationEquals(kaiyakuchkkekkaKbn, C_KaiyakuchkkekkaKbn.ERROR, "解約共通チェック結果区分");
        exStringEquals(checkKaiyaku.getErrorMessage(),
            "配当支払チェックが実行できませんでした。", "エラーメッセージ");
        exStringEquals(checkKaiyaku.getErrorMessageCode(), "5004", "エラーメッセージコード");
        String syono = (String) MockObjectManager.getArgument(CheckDShrKaiyakuMockForHozen.class, "checkDShr", 0, 0);
        exStringEquals(syono, "11809111158", "証券番号");

        BizDate kijyunYmd = (BizDate) MockObjectManager.getArgument(CheckDShrKaiyakuMockForHozen.class, "checkDShr", 0, 1);
        exDateEquals(kijyunYmd, BizDate.valueOf(20180208), "計算基準日");

        BizDateYM jkipjytYm = (BizDateYM) MockObjectManager.getArgument(CheckDShrKaiyakuMockForHozen.class, "checkDShr", 0, 2);
        exDateYMEquals(jkipjytYm, BizDateYM.valueOf(202005), "次回Ｐ充当年月");

        C_YouhiKbn pMinyuuCheckYouhi = (C_YouhiKbn) MockObjectManager.getArgument(CheckDShrKaiyakuMockForHozen.class, "checkDShr", 0, 3);
        exClassificationEquals(pMinyuuCheckYouhi, null, "Ｐ未入チェック要否");

        BizDate syoriYmd = (BizDate) MockObjectManager.getArgument(CheckDShrKaiyakuMockForHozen.class, "checkDShr", 0, 4);
        exDateEquals(syoriYmd, BizDate.valueOf(20180202), "処理日");
    }

    @Test
    @TestOrder(1270)
    public void testExec_A27() {
        MockObjectManager.initialize();
        CheckDShrKaiyakuMockForHozen.SYORIPTN = CheckDShrKaiyakuMockForHozen.TESTPATTERN5;
        CheckKaiyakuBean checkKaiyakuBean = new CheckKaiyakuBean();
        checkKaiyakuBean.setSyoruiukeYmd(BizDate.valueOf(20180209));
        checkKaiyakuBean.setYendthnkYmd(null);
        checkKaiyakuBean.setSyukykYmd(BizDate.valueOf(20180208));
        checkKaiyakuBean.setSyoriYmd(BizDate.valueOf(20180202));
        HozenDomManager hozenDomManager = SWAKInjector.getInstance(HozenDomManager.class);
        checkKaiyakuBean.setKykKihon(hozenDomManager.getKykKihon("11809111158"));
        checkKaiyakuBean.setAnsyuKihon(hozenDomManager.getAnsyuKihon("11809111158"));

        C_KaiyakuchkkekkaKbn kaiyakuchkkekkaKbn = checkKaiyaku.exec("drctservice", null, checkKaiyakuBean);

        exClassificationEquals(kaiyakuchkkekkaKbn, C_KaiyakuchkkekkaKbn.ERROR, "解約共通チェック結果区分");
        exStringEquals(checkKaiyaku.getErrorMessage(),
            "配当支払チェックが実行できませんでした。", "エラーメッセージ");
        exStringEquals(checkKaiyaku.getErrorMessageCode(), "5004", "エラーメッセージコード");
        String syono = (String) MockObjectManager.getArgument(CheckDShrKaiyakuMockForHozen.class, "checkDShr", 0, 0);
        exStringEquals(syono, "11809111158", "証券番号");

        BizDate kijyunYmd = (BizDate) MockObjectManager.getArgument(CheckDShrKaiyakuMockForHozen.class, "checkDShr", 0, 1);
        exDateEquals(kijyunYmd, BizDate.valueOf(20180209), "計算基準日");

        BizDateYM jkipjytYm = (BizDateYM) MockObjectManager.getArgument(CheckDShrKaiyakuMockForHozen.class, "checkDShr", 0, 2);
        exDateYMEquals(jkipjytYm, BizDateYM.valueOf(202005), "次回Ｐ充当年月");

        C_YouhiKbn pMinyuuCheckYouhi = (C_YouhiKbn) MockObjectManager.getArgument(CheckDShrKaiyakuMockForHozen.class, "checkDShr", 0, 3);
        exClassificationEquals(pMinyuuCheckYouhi, null, "Ｐ未入チェック要否");

        BizDate syoriYmd = (BizDate) MockObjectManager.getArgument(CheckDShrKaiyakuMockForHozen.class, "checkDShr", 0, 4);
        exDateEquals(syoriYmd, BizDate.valueOf(20180202), "処理日");
    }

    @Test
    @TestOrder(1280)
    public void testExec_A28() {
        MockObjectManager.initialize();
        CheckDShrKaiyakuMockForHozen.SYORIPTN = CheckDShrKaiyakuMockForHozen.TESTPATTERN4;
        HanteiKhSisuurendoTmttknJyoutaiMockForHozen.SYORIPTN = HanteiKhSisuurendoTmttknJyoutaiMockForHozen.TESTPATTERN1;
        CheckKaiyakuBean checkKaiyakuBean = new CheckKaiyakuBean();
        checkKaiyakuBean.setSyoruiukeYmd(BizDate.valueOf(20180208));
        checkKaiyakuBean.setYendthnkYmd(null);
        checkKaiyakuBean.setSyukykYmd(BizDate.valueOf(20180207));
        checkKaiyakuBean.setSyoriYmd(BizDate.valueOf(20180206));
        HozenDomManager hozenDomManager = SWAKInjector.getInstance(HozenDomManager.class);
        checkKaiyakuBean.setKykKihon(hozenDomManager.getKykKihon("99806031156"));
        checkKaiyakuBean.setAnsyuKihon(hozenDomManager.getAnsyuKihon("99806031156"));

        C_KaiyakuchkkekkaKbn kaiyakuchkkekkaKbn = checkKaiyaku.exec("online", "inputcontents", checkKaiyakuBean);

        exClassificationEquals(kaiyakuchkkekkaKbn, C_KaiyakuchkkekkaKbn.SEIJYOU, "解約共通チェック結果区分");
        exStringEquals(checkKaiyaku.getErrorMessage(), "", "エラーメッセージ");
        exStringEquals(checkKaiyaku.getErrorMessageCode(), "", "エラーメッセージコード");
        String syono = (String) MockObjectManager.getArgument(CheckDShrKaiyakuMockForHozen.class, "checkDShr", 0, 0);
        exStringEquals(syono, "99806031156", "証券番号");

        BizDate kijyunYmd = (BizDate) MockObjectManager.getArgument(CheckDShrKaiyakuMockForHozen.class, "checkDShr", 0, 1);
        exDateEquals(kijyunYmd, BizDate.valueOf(20180208), "計算基準日");

        BizDateYM jkipjytYm = (BizDateYM) MockObjectManager.getArgument(CheckDShrKaiyakuMockForHozen.class, "checkDShr", 0, 2);
        exDateYMEquals(jkipjytYm, BizDateYM.valueOf(202005), "次回Ｐ充当年月");

        C_YouhiKbn pMinyuuCheckYouhi = (C_YouhiKbn) MockObjectManager.getArgument(CheckDShrKaiyakuMockForHozen.class, "checkDShr", 0, 3);
        exClassificationEquals(pMinyuuCheckYouhi, C_YouhiKbn.YOU, "Ｐ未入チェック要否");

        BizDate syoriYmd = (BizDate) MockObjectManager.getArgument(CheckDShrKaiyakuMockForHozen.class, "checkDShr", 0, 4);
        exDateEquals(syoriYmd, BizDate.valueOf(20180206), "処理日");
    }

    @Test(expected = BizLogicException.class)
    @TestOrder(1290)
    public void testExec_A29() {
        MockObjectManager.initialize();
        CheckDShrKaiyakuMockForHozen.SYORIPTN = CheckDShrKaiyakuMockForHozen.TESTPATTERN4;
        HanteiKhSisuurendoTmttknJyoutaiMockForHozen.SYORIPTN = HanteiKhSisuurendoTmttknJyoutaiMockForHozen.TESTPATTERN2;
        CheckKaiyakuBean checkKaiyakuBean = new CheckKaiyakuBean();
        checkKaiyakuBean.setSyoruiukeYmd(BizDate.valueOf(20180208));
        checkKaiyakuBean.setYendthnkYmd(null);
        checkKaiyakuBean.setSyukykYmd(BizDate.valueOf(20180207));
        checkKaiyakuBean.setSyoriYmd(BizDate.valueOf(20180206));
        HozenDomManager hozenDomManager = SWAKInjector.getInstance(HozenDomManager.class);
        checkKaiyakuBean.setKykKihon(hozenDomManager.getKykKihon("11809111169"));
        checkKaiyakuBean.setAnsyuKihon(hozenDomManager.getAnsyuKihon("11809111169"));
        try {
            checkKaiyaku.exec("online", "inputcontents", checkKaiyakuBean);
        } catch (Exception e) {
            exStringEquals(e.getMessage(),
                "積立金が未反映のため、処理できません。積立金反映後に処理可能となります。",
                "エラーメッセージ(BizLogicException)");
            throw e;
        }
    }

    @Test
    @TestOrder(1300)
    public void testExec_A30() {
        MockObjectManager.initialize();
        CheckDShrKaiyakuMockForHozen.SYORIPTN = CheckDShrKaiyakuMockForHozen.TESTPATTERN4;
        HanteiKhSisuurendoTmttknJyoutaiMockForHozen.SYORIPTN = HanteiKhSisuurendoTmttknJyoutaiMockForHozen.TESTPATTERN2;
        CheckKaiyakuBean checkKaiyakuBean = new CheckKaiyakuBean();
        checkKaiyakuBean.setSyoruiukeYmd(BizDate.valueOf(20180208));
        checkKaiyakuBean.setYendthnkYmd(null);
        checkKaiyakuBean.setSyukykYmd(BizDate.valueOf(20180207));
        checkKaiyakuBean.setSyoriYmd(BizDate.valueOf(20180206));
        HozenDomManager hozenDomManager = SWAKInjector.getInstance(HozenDomManager.class);
        checkKaiyakuBean.setKykKihon(hozenDomManager.getKykKihon("11809111169"));
        checkKaiyakuBean.setAnsyuKihon(hozenDomManager.getAnsyuKihon("11809111169"));

        C_KaiyakuchkkekkaKbn kaiyakuchkkekkaKbn = checkKaiyaku.exec("batch", null, checkKaiyakuBean);

        exClassificationEquals(kaiyakuchkkekkaKbn, C_KaiyakuchkkekkaKbn.ERROR, "解約共通チェック結果区分");
        exStringEquals(checkKaiyaku.getErrorMessage(),
            "積立金が未反映のため、処理できません。積立金反映後に処理可能となります。", "エラーメッセージ");
        exStringEquals(checkKaiyaku.getErrorMessageCode(), "5005", "エラーメッセージコード");
    }

    @Test
    @TestOrder(1310)
    public void testExec_A31() {
        MockObjectManager.initialize();
        CheckDShrKaiyakuMockForHozen.SYORIPTN = CheckDShrKaiyakuMockForHozen.TESTPATTERN4;
        HanteiKhSisuurendoTmttknJyoutaiMockForHozen.SYORIPTN = HanteiKhSisuurendoTmttknJyoutaiMockForHozen.TESTPATTERN2;
        CheckKaiyakuBean checkKaiyakuBean = new CheckKaiyakuBean();
        checkKaiyakuBean.setSyoruiukeYmd(BizDate.valueOf(20180208));
        checkKaiyakuBean.setYendthnkYmd(null);
        checkKaiyakuBean.setSyukykYmd(BizDate.valueOf(20180207));
        checkKaiyakuBean.setSyoriYmd(BizDate.valueOf(20180206));
        HozenDomManager hozenDomManager = SWAKInjector.getInstance(HozenDomManager.class);
        checkKaiyakuBean.setKykKihon(hozenDomManager.getKykKihon("11809111169"));
        checkKaiyakuBean.setAnsyuKihon(hozenDomManager.getAnsyuKihon("11809111169"));

        C_KaiyakuchkkekkaKbn kaiyakuchkkekkaKbn = checkKaiyaku.exec("drctservice", null, checkKaiyakuBean);

        exClassificationEquals(kaiyakuchkkekkaKbn, C_KaiyakuchkkekkaKbn.ERROR, "解約共通チェック結果区分");
        exStringEquals(checkKaiyaku.getErrorMessage(),
            "積立金が未反映のため、処理できません。積立金反映後に処理可能となります。", "エラーメッセージ");
        exStringEquals(checkKaiyaku.getErrorMessageCode(), "5005", "エラーメッセージコード");
    }

    @Test
    @TestOrder(1320)
    public void testExec_A32() {
        MockObjectManager.initialize();
        CheckDShrKaiyakuMockForHozen.SYORIPTN = CheckDShrKaiyakuMockForHozen.TESTPATTERN4;
        CheckKaiyakuBean checkKaiyakuBean = new CheckKaiyakuBean();
        checkKaiyakuBean.setSyoruiukeYmd(BizDate.valueOf(20190208));
        checkKaiyakuBean.setYendthnkYmd(null);
        checkKaiyakuBean.setSyukykYmd(BizDate.valueOf(20180208));
        HozenDomManager hozenDomManager = SWAKInjector.getInstance(HozenDomManager.class);
        checkKaiyakuBean.setKykKihon(hozenDomManager.getKykKihon("11809111170"));
        checkKaiyakuBean.setAnsyuKihon(hozenDomManager.getAnsyuKihon("11809111170"));

        C_KaiyakuchkkekkaKbn kaiyakuchkkekkaKbn = checkKaiyaku.exec("batch", null, checkKaiyakuBean);

        exClassificationEquals(kaiyakuchkkekkaKbn, C_KaiyakuchkkekkaKbn.ERROR, "解約共通チェック結果区分");
        exStringEquals(checkKaiyaku.getErrorMessage(),
            "前納Ｐが充当されていないため、処理できません。前納Ｐ充当後に処理してください。",
            "エラーメッセージ");
        exStringEquals(checkKaiyaku.getErrorMessageCode(), "5006", "エラーメッセージコード");
    }

    @Test
    @TestOrder(1330)
    public void testExec_A33() {
        MockObjectManager.initialize();
        CheckDShrKaiyakuMockForHozen.SYORIPTN = CheckDShrKaiyakuMockForHozen.TESTPATTERN4;
        CheckKaiyakuBean checkKaiyakuBean = new CheckKaiyakuBean();
        checkKaiyakuBean.setSyoruiukeYmd(BizDate.valueOf(20190209));
        checkKaiyakuBean.setYendthnkYmd(null);
        checkKaiyakuBean.setSyukykYmd(BizDate.valueOf(20180208));
        HozenDomManager hozenDomManager = SWAKInjector.getInstance(HozenDomManager.class);
        checkKaiyakuBean.setKykKihon(hozenDomManager.getKykKihon("11809111170"));
        checkKaiyakuBean.setAnsyuKihon(hozenDomManager.getAnsyuKihon("11809111170"));

        C_KaiyakuchkkekkaKbn kaiyakuchkkekkaKbn = checkKaiyaku.exec("drctservice", null, checkKaiyakuBean);

        exClassificationEquals(kaiyakuchkkekkaKbn, C_KaiyakuchkkekkaKbn.ERROR, "解約共通チェック結果区分");
        exStringEquals(checkKaiyaku.getErrorMessage(),
            "前納Ｐが充当されていないため、処理できません。前納Ｐ充当後に処理してください。",
            "エラーメッセージ");
        exStringEquals(checkKaiyaku.getErrorMessageCode(), "5006", "エラーメッセージコード");
    }

    @Test
    @TestOrder(1340)
    public void testExec_A34() {
        MockObjectManager.initialize();
        CheckDShrKaiyakuMockForHozen.SYORIPTN = CheckDShrKaiyakuMockForHozen.TESTPATTERN4;
        CheckKaiyakuBean checkKaiyakuBean = new CheckKaiyakuBean();
        checkKaiyakuBean.setSyoruiukeYmd(BizDate.valueOf(20190207));
        checkKaiyakuBean.setYendthnkYmd(null);
        checkKaiyakuBean.setSyukykYmd(BizDate.valueOf(20180208));
        HozenDomManager hozenDomManager = SWAKInjector.getInstance(HozenDomManager.class);
        checkKaiyakuBean.setKykKihon(hozenDomManager.getKykKihon("11809111181"));
        checkKaiyakuBean.setAnsyuKihon(hozenDomManager.getAnsyuKihon("11809111181"));

        C_KaiyakuchkkekkaKbn kaiyakuchkkekkaKbn = checkKaiyaku.exec("batch", null, checkKaiyakuBean);

        exClassificationEquals(kaiyakuchkkekkaKbn, C_KaiyakuchkkekkaKbn.SEIJYOU, "解約共通チェック結果区分");
        exStringEquals(checkKaiyaku.getErrorMessage(), "", "エラーメッセージ");
        exStringEquals(checkKaiyaku.getErrorMessageCode(), "", "エラーメッセージコード");
    }

    @Test
    @TestOrder(1350)
    public void testExec_A35() {
        MockObjectManager.initialize();
        CheckDShrKaiyakuMockForHozen.SYORIPTN = CheckDShrKaiyakuMockForHozen.TESTPATTERN1;
        CheckKaiyakuBean checkKaiyakuBean = new CheckKaiyakuBean();
        checkKaiyakuBean.setSyoruiukeYmd(BizDate.valueOf(20180208));
        checkKaiyakuBean.setYendthnkYmd(null);
        checkKaiyakuBean.setSyukykYmd(BizDate.valueOf(20180208));
        checkKaiyakuBean.setSyoriYmd(BizDate.valueOf(20180202));
        HozenDomManager hozenDomManager = SWAKInjector.getInstance(HozenDomManager.class);
        checkKaiyakuBean.setKykKihon(hozenDomManager.getKykKihon("12806000029"));
        checkKaiyakuBean.setAnsyuKihon(hozenDomManager.getAnsyuKihon("12806000029"));

        try {
            checkKaiyaku.exec("batch", "inputcontents", checkKaiyakuBean);
        } catch (Exception e) {

            String syono = (String) MockObjectManager.getArgument(CheckDShrKaiyakuMockForHozen.class, "checkDShr", 0, 0);
            exStringEquals(syono, "12806000029", "証券番号");

            BizDate kijyunYmd = (BizDate) MockObjectManager.getArgument(CheckDShrKaiyakuMockForHozen.class, "checkDShr", 0, 1);
            exDateEquals(kijyunYmd, BizDate.valueOf(20180208), "計算基準日");

            BizDateYM jkipjytYm = (BizDateYM) MockObjectManager.getArgument(CheckDShrKaiyakuMockForHozen.class, "checkDShr", 0, 2);
            exDateYMEquals(jkipjytYm, BizDateYM.valueOf(202005), "次回Ｐ充当年月");

            C_YouhiKbn pMinyuuCheckYouhi = (C_YouhiKbn) MockObjectManager.getArgument(CheckDShrKaiyakuMockForHozen.class, "checkDShr", 0, 3);
            exClassificationEquals(pMinyuuCheckYouhi, null, "Ｐ未入チェック要否");

            BizDate syoriYmd = (BizDate) MockObjectManager.getArgument(CheckDShrKaiyakuMockForHozen.class, "checkDShr", 0, 4);
            exDateEquals(syoriYmd, BizDate.valueOf(20180202), "処理日");

            throw e;
        }

    }
}