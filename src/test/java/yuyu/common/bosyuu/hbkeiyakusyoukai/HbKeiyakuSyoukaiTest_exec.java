package yuyu.common.bosyuu.hbkeiyakusyoukai;

import static yuyu.testinfr.YuyuFunctionTestUtil.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.dgic.testing.common.virtualmock.MockObjectManager;
import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.date.BizDateYM;
import jp.co.slcs.swak.number.BizCurrency;
import jp.co.slcs.swak.number.BizNumber;
import jp.co.slcs.swak.number.configuration.BizNumberConfig;
import jp.co.slcs.swak.number.currencytype.BizCurrencyTypes;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;

import yuyu.app.base.ref.TestDataMaker;
import yuyu.app.base.ref.TestDataMakerException;
import yuyu.common.biz.bzcommon.BzGetAdrData;
import yuyu.common.biz.bzcommon.BzGetAdrDataMockForHozen;
import yuyu.common.biz.bzcommon.KeisanGaikakanzan;
import yuyu.common.biz.bzcommon.KeisanGaikakanzanMockForHozen;
import yuyu.common.biz.bzcommon.SetNenrei;
import yuyu.common.biz.bzcommon.SetNenreiMockForHozen;
import yuyu.common.biz.koutei.BzGetProcessSummary;
import yuyu.common.biz.koutei.BzGetProcessSummaryInBean;
import yuyu.common.biz.koutei.BzGetProcessSummaryMockForHozen;
import yuyu.common.hozen.khcommon.HanteiKhSisuurendoTmttknJyoutai;
import yuyu.common.hozen.khcommon.HanteiKhSisuurendoTmttknJyoutaiMockForHozen;
import yuyu.common.hozen.khcommon.HanteiTmttknJyoutaiBean;
import yuyu.common.hozen.khcommon.KeisanKijyungk;
import yuyu.common.hozen.khcommon.KeisanKijyungkMockForHozen;
import yuyu.common.hozen.khcommon.KeisanW;
import yuyu.common.hozen.khcommon.KeisanWExt;
import yuyu.common.hozen.khcommon.KeisanWExtMockForHozen;
import yuyu.common.hozen.khcommon.KeisanWMockForHozen;
import yuyu.common.siharai.sicommon.CalcHkShrKngk;
import yuyu.common.siharai.sicommon.CalcHkShrKngkMockForHozen;
import yuyu.def.biz.manager.BizDomManager;
import yuyu.def.classification.C_HasuusyoriKbn;
import yuyu.def.classification.C_Hhknsei;
import yuyu.def.classification.C_HknkknsmnKbn;
import yuyu.def.classification.C_HokenkinsyuruiKbn;
import yuyu.def.classification.C_Hrkkaisuu;
import yuyu.def.classification.C_HrkkknsmnKbn;
import yuyu.def.classification.C_Kouteikanristatus;
import yuyu.def.classification.C_Kykjyoutai;
import yuyu.def.classification.C_SiinKbn;
import yuyu.def.classification.C_TanmatuSiyouKbn;
import yuyu.def.classification.C_Tkhukaumu;
import yuyu.def.classification.C_Tuukasyu;
import yuyu.def.hozen.manager.HozenDomManager;
import yuyu.def.siharai.manager.SiharaiDomManager;
import yuyu.testinfr.AbstractTest;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;
import yuyu.testinfr.inject.MockModuleBinder;

import com.google.inject.AbstractModule;

/**
 * 生保Ｗｅｂ契約内容照会 {@link HbKeiyakuSyoukai#exec(String, BizDate, C_TanmatuSiyouKbn)} テスト用クラスです。<br />
 */
@RunWith(OrderedRunner.class)
public class HbKeiyakuSyoukaiTest_exec extends AbstractTest {

    @Inject
    private HbKeiyakuSyoukai hbKeiyakuSyoukai;

    private final static String fileName = "UT_SP_単体テスト仕様書_生保Ｗｅｂ契約内容照会";

    private final static String sheetName = "INデータ";

    @Inject
    private static Logger logger;

    @Before
    public void before(){
        MockModuleBinder.bind(new AbstractModule(){
            @Override
            protected void configure() {
                bind(BzGetProcessSummary.class).to(BzGetProcessSummaryMockForHozen.class);
                bind(CalcHkShrKngk.class).to(CalcHkShrKngkMockForHozen.class);
                bind(KeisanWExt.class).to(KeisanWExtMockForHozen.class);
                bind(BzGetAdrData.class).to(BzGetAdrDataMockForHozen.class);
                bind(KeisanKijyungk.class).to(KeisanKijyungkMockForHozen.class);
                bind(KeisanGaikakanzan.class).to(KeisanGaikakanzanMockForHozen.class);
                bind(SetNenrei.class).to(SetNenreiMockForHozen.class);
                bind(KeisanW.class).to(KeisanWMockForHozen.class);
                bind(HanteiKhSisuurendoTmttknJyoutai.class).to(HanteiKhSisuurendoTmttknJyoutaiMockForHozen.class);
            }
        });
    }

    @BeforeClass
    public static void testInit() {
        BzGetProcessSummaryMockForHozen.caller = HbKeiyakuSyoukaiTest_exec.class;
        CalcHkShrKngkMockForHozen.caller = HbKeiyakuSyoukaiTest_exec.class;
        KeisanWExtMockForHozen.caller = HbKeiyakuSyoukaiTest_exec.class;
        BzGetAdrDataMockForHozen.caller = HbKeiyakuSyoukaiTest_exec.class;
        KeisanKijyungkMockForHozen.caller = HbKeiyakuSyoukaiTest_exec.class;
        KeisanGaikakanzanMockForHozen.caller = HbKeiyakuSyoukaiTest_exec.class;
        SetNenreiMockForHozen.caller = HbKeiyakuSyoukaiTest_exec.class;
        KeisanWMockForHozen.caller = HbKeiyakuSyoukaiTest_exec.class;
        HanteiKhSisuurendoTmttknJyoutaiMockForHozen.caller = HbKeiyakuSyoukaiTest_exec.class;
    }

    @AfterClass
    public static void testClear() {
        BzGetProcessSummaryMockForHozen.caller = null;
        BzGetProcessSummaryMockForHozen.SYORIPTN = null;
        CalcHkShrKngkMockForHozen.caller = null;
        CalcHkShrKngkMockForHozen.SYORIPTN = null;
        KeisanWExtMockForHozen.caller = null;
        KeisanWExtMockForHozen.SYORIPTN = null;
        BzGetAdrDataMockForHozen.caller = null;
        BzGetAdrDataMockForHozen.SYORIPTN = null;
        KeisanKijyungkMockForHozen.caller = null;
        KeisanKijyungkMockForHozen.SYORIPTN = null;
        KeisanGaikakanzanMockForHozen.caller = null;
        KeisanGaikakanzanMockForHozen.SYORIPTN = null;
        SetNenreiMockForHozen.caller = null;
        SetNenreiMockForHozen.SYORIPTN = null;
        KeisanWMockForHozen.caller = null;
        KeisanWMockForHozen.SYORIPTN = null;

        MockObjectManager.initialize();
    }

    @BeforeClass
    @Transactional
    public static void insertTestData() {
        try {
            TestDataMaker testDataMaker = new TestDataMaker();
            HashMap<String, Map<String, List<Map<String, String>>>> testDataAndTblMap;
            testDataAndTblMap = testDataMaker.getInData(HbKeiyakuSyoukaiTest_exec.class, fileName, sheetName);
            testDataMaker.insDataByDataId("データ001", testDataAndTblMap);
        } catch (TestDataMakerException e) {
            e.printStackTrace();
        }
    }

    @AfterClass
    @Transactional
    public static void deleteTestData() {
        HozenDomManager hozenDomManager = SWAKInjector.getInstance(HozenDomManager.class);
        BizDomManager bizDomManager = SWAKInjector.getInstance(BizDomManager.class);
        SiharaiDomManager siharaiDomManager = SWAKInjector.getInstance(SiharaiDomManager.class);
        hozenDomManager.delete(hozenDomManager.getAllKykKihon());
        hozenDomManager.delete(hozenDomManager.getAllSyorijtkahi());
        hozenDomManager.delete(hozenDomManager.getAllAnsyuKihon());
        siharaiDomManager.delete(siharaiDomManager.getAllSkKihon());
        bizDomManager.delete(bizDomManager.getAllSyouhnZokusei());
    }

    @Test
    @TestOrder(10)
    public void testExec_A1() {
        changeSystemDate();

        WebKykNaiyouSyoukaiInfoBean webKykNaiyouSyoukaiInfoBean =
            hbKeiyakuSyoukai.exec("99806000019", BizDate.valueOf("20160621"), C_TanmatuSiyouKbn.SOUGOU_IPPAN, null);

        exStringEquals(webKykNaiyouSyoukaiInfoBean.getErrorKbn(), "1", "エラー区分");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getErrorMsg()
            , "誤った証券番号が入力されています。正しい証券番号を確認のうえ、再度照会ください。", "エラーメッセージ");
        CheckEebKykNaiyouSyoukaiInfoBean(webKykNaiyouSyoukaiInfoBean);
    }

    @Test
    @TestOrder(20)
    public void testExec_A2() {
        changeSystemDate();

        WebKykNaiyouSyoukaiInfoBean webKykNaiyouSyoukaiInfoBean =
            hbKeiyakuSyoukai.exec("99809111116", BizDate.valueOf("20160621"), C_TanmatuSiyouKbn.SOUGOU_IPPAN, null);

        exStringEquals(webKykNaiyouSyoukaiInfoBean.getErrorKbn(), "1", "エラー区分");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getErrorMsg()
            , "選択されたご契約についてはご照会できません。", "エラーメッセージ");
        CheckEebKykNaiyouSyoukaiInfoBean(webKykNaiyouSyoukaiInfoBean);
    }

    @Test
    @TestOrder(30)
    public void testExec_A3() {
        changeSystemDate();

        MockObjectManager.initialize();
        WebKykNaiyouSyoukaiInfoBean webKykNaiyouSyoukaiInfoBean =
            hbKeiyakuSyoukai.exec("99809111703", BizDate.valueOf("20160621"), C_TanmatuSiyouKbn.DAIRITENBOSYUUNIN,
                "100016");

        exStringEquals(webKykNaiyouSyoukaiInfoBean.getErrorKbn(), "1", "エラー区分");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getErrorMsg()
            , "選択されたご契約についてはご照会できません。", "エラーメッセージ");
        CheckEebKykNaiyouSyoukaiInfoBean(webKykNaiyouSyoukaiInfoBean);

    }

    @Test
    @TestOrder(40)
    public void testExec_A4() {
        changeSystemDate();

        MockObjectManager.initialize();
        WebKykNaiyouSyoukaiInfoBean webKykNaiyouSyoukaiInfoBean =
            hbKeiyakuSyoukai.exec("99809111703", BizDate.valueOf("20160621"), C_TanmatuSiyouKbn.DAIRITENBOSYUUNIN,
                "100016");

        exStringEquals(webKykNaiyouSyoukaiInfoBean.getErrorKbn(), "1", "エラー区分");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getErrorMsg()
            , "選択されたご契約についてはご照会できません。", "エラーメッセージ");
        CheckEebKykNaiyouSyoukaiInfoBean(webKykNaiyouSyoukaiInfoBean);
    }

    @Test
    @TestOrder(50)
    public void testExec_A5() {
        changeSystemDate();

        MockObjectManager.initialize();
        WebKykNaiyouSyoukaiInfoBean webKykNaiyouSyoukaiInfoBean =
            hbKeiyakuSyoukai.exec("17806001003", BizDate.valueOf("20160621"), C_TanmatuSiyouKbn.DAIRITENBOSYUUNIN,
                "100006");

        exStringEquals(webKykNaiyouSyoukaiInfoBean.getErrorKbn(), "1", "エラー区分");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getErrorMsg()
            , "選択されたご契約についてはご照会できません。", "エラーメッセージ");
        CheckEebKykNaiyouSyoukaiInfoBean(webKykNaiyouSyoukaiInfoBean);

    }

    @Test
    @TestOrder(60)
    public void testExec_A6() {
        changeSystemDate();

        MockObjectManager.initialize();
        WebKykNaiyouSyoukaiInfoBean webKykNaiyouSyoukaiInfoBean =
            hbKeiyakuSyoukai.exec("17806001003", BizDate.valueOf("20160621"), C_TanmatuSiyouKbn.DAIRITENBOSYUUNIN,
                "100006");

        exStringEquals(webKykNaiyouSyoukaiInfoBean.getErrorKbn(), "1", "エラー区分");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getErrorMsg()
            , "選択されたご契約についてはご照会できません。", "エラーメッセージ");
        CheckEebKykNaiyouSyoukaiInfoBean(webKykNaiyouSyoukaiInfoBean);
    }


    @Test
    @TestOrder(70)
    public void testExec_A7() {
        changeSystemDate();

        MockObjectManager.initialize();
        WebKykNaiyouSyoukaiInfoBean webKykNaiyouSyoukaiInfoBean =
            hbKeiyakuSyoukai.exec("17806001106", BizDate.valueOf("20160621"), C_TanmatuSiyouKbn.DAIRITENBOSYUUNIN,
                "100006");

        exStringEquals(webKykNaiyouSyoukaiInfoBean.getErrorKbn(), "1", "エラー区分");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getErrorMsg()
            , "選択されたご契約は、他代理店募集契約につき、ご照会できません。", "エラーメッセージ");
        CheckEebKykNaiyouSyoukaiInfoBean(webKykNaiyouSyoukaiInfoBean);
    }

    @Test
    @TestOrder(80)
    public void testExec_A8() {
        changeSystemDate();

        MockObjectManager.initialize();

        WebKykNaiyouSyoukaiInfoBean webKykNaiyouSyoukaiInfoBean =
            hbKeiyakuSyoukai.exec("99809111127", BizDate.valueOf("20160621"), C_TanmatuSiyouKbn.DAIRITENBOSYUUNIN,
                "100006");

        exStringEquals(webKykNaiyouSyoukaiInfoBean.getErrorKbn(), "1", "エラー区分");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getErrorMsg()
            , "選択されたご契約についてはご照会できません。", "エラーメッセージ");
        CheckEebKykNaiyouSyoukaiInfoBean(webKykNaiyouSyoukaiInfoBean);
    }

    @Test
    @TestOrder(90)
    public void testExec_A9() {
        changeSystemDate();

        MockObjectManager.initialize();
        WebKykNaiyouSyoukaiInfoBean webKykNaiyouSyoukaiInfoBean =
            hbKeiyakuSyoukai.exec("99809111138", BizDate.valueOf("20160621"), C_TanmatuSiyouKbn.SOUGOU_IPPAN, null);

        exStringEquals(webKykNaiyouSyoukaiInfoBean.getErrorKbn(), "1", "エラー区分");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getErrorMsg()
            , "選択されたご契約についてはご照会できません。", "エラーメッセージ");
        CheckEebKykNaiyouSyoukaiInfoBean(webKykNaiyouSyoukaiInfoBean);
    }

    @Test
    @TestOrder(100)
    public void testExec_A10() {
        changeSystemDate();

        MockObjectManager.initialize();
        BzGetProcessSummaryMockForHozen.SYORIPTN = BzGetProcessSummaryMockForHozen.TESTPATTERN1;

        WebKykNaiyouSyoukaiInfoBean webKykNaiyouSyoukaiInfoBean =
            hbKeiyakuSyoukai.exec("99809111149", BizDate.valueOf("20160621"), C_TanmatuSiyouKbn.SOUGOU_IPPAN, null);

        exStringEquals(webKykNaiyouSyoukaiInfoBean.getErrorKbn(), "1", "エラー区分");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getErrorMsg()
            , "選択されたご契約についてはご照会できません。", "エラーメッセージ");
        CheckEebKykNaiyouSyoukaiInfoBean(webKykNaiyouSyoukaiInfoBean);

        BzGetProcessSummaryInBean bzGetProcessSummaryInBean = (BzGetProcessSummaryInBean) MockObjectManager
            .getArgument(BzGetProcessSummaryMockForHozen.class, "exec", 0, 0);
        exClassificationEquals(bzGetProcessSummaryInBean.getKouteiKanriStatuss()[0], C_Kouteikanristatus.SYORITYUU,
            "工程管理状況");
        exStringEquals(bzGetProcessSummaryInBean.getSyoNo(), "99809111149", "証券番号");
    }

    @Test
    @TestOrder(110)
    public void testExec_A11() {
        changeSystemDate();

        MockObjectManager.initialize();
        BzGetProcessSummaryMockForHozen.SYORIPTN = BzGetProcessSummaryMockForHozen.TESTPATTERN3;

        WebKykNaiyouSyoukaiInfoBean webKykNaiyouSyoukaiInfoBean =
            hbKeiyakuSyoukai.exec("99809111150", BizDate.valueOf("20160621"), C_TanmatuSiyouKbn.SOUGOU_IPPAN, null);

        exStringEquals(webKykNaiyouSyoukaiInfoBean.getErrorKbn(), "1", "エラー区分");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getErrorMsg()
            , "選択されたご契約についてはご照会できません。", "エラーメッセージ");
        CheckEebKykNaiyouSyoukaiInfoBean(webKykNaiyouSyoukaiInfoBean);
    }

    @Test
    @TestOrder(120)
    public void testExec_A12() {
        changeSystemDate();

        MockObjectManager.initialize();
        BzGetProcessSummaryMockForHozen.SYORIPTN = BzGetProcessSummaryMockForHozen.TESTPATTERN4;

        WebKykNaiyouSyoukaiInfoBean webKykNaiyouSyoukaiInfoBean =
            hbKeiyakuSyoukai.exec("99809111172", BizDate.valueOf("20160621"), C_TanmatuSiyouKbn.SOUGOU_IPPAN, null);

        exStringEquals(webKykNaiyouSyoukaiInfoBean.getErrorKbn(), "1", "エラー区分");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getErrorMsg()
            , "選択されたご契約についてはご照会できません。", "エラーメッセージ");
        CheckEebKykNaiyouSyoukaiInfoBean(webKykNaiyouSyoukaiInfoBean);
    }

    @Test
    @TestOrder(130)
    public void testExec_A13() {
        changeSystemDate();

        MockObjectManager.initialize();
        BzGetProcessSummaryMockForHozen.SYORIPTN = BzGetProcessSummaryMockForHozen.TESTPATTERN5;

        WebKykNaiyouSyoukaiInfoBean webKykNaiyouSyoukaiInfoBean =
            hbKeiyakuSyoukai.exec("99809111183", BizDate.valueOf("20160621"), C_TanmatuSiyouKbn.SOUGOU_IPPAN, null);

        exStringEquals(webKykNaiyouSyoukaiInfoBean.getErrorKbn(), "1", "エラー区分");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getErrorMsg()
            , "選択されたご契約についてはご照会できません。", "エラーメッセージ");
        CheckEebKykNaiyouSyoukaiInfoBean(webKykNaiyouSyoukaiInfoBean);
    }

    @Test
    @TestOrder(140)
    public void testExec_A14() {
        changeSystemDate();

        MockObjectManager.initialize();
        BzGetProcessSummaryMockForHozen.SYORIPTN = BzGetProcessSummaryMockForHozen.TESTPATTERN2;

        WebKykNaiyouSyoukaiInfoBean webKykNaiyouSyoukaiInfoBean =
            hbKeiyakuSyoukai.exec("99809111208", BizDate.valueOf("20160621"), C_TanmatuSiyouKbn.SOUGOU_IPPAN, null);

        exStringEquals(webKykNaiyouSyoukaiInfoBean.getErrorKbn(), "1", "エラー区分");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getErrorMsg()
            , "選択されたご契約についてはご照会できません。", "エラーメッセージ");
        CheckEebKykNaiyouSyoukaiInfoBean(webKykNaiyouSyoukaiInfoBean);
    }

    @Test
    @TestOrder(150)
    public void testExec_A15() {
        changeSystemDate();

        MockObjectManager.initialize();
        BzGetProcessSummaryMockForHozen.SYORIPTN = BzGetProcessSummaryMockForHozen.TESTPATTERN2;

        WebKykNaiyouSyoukaiInfoBean webKykNaiyouSyoukaiInfoBean =
            hbKeiyakuSyoukai.exec("99809111220", BizDate.valueOf("20160621"), C_TanmatuSiyouKbn.SOUGOU_IPPAN, null);

        exStringEquals(webKykNaiyouSyoukaiInfoBean.getErrorKbn(), "1", "エラー区分");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getErrorMsg()
            , "選択されたご契約についてはご照会できません。", "エラーメッセージ");
        CheckEebKykNaiyouSyoukaiInfoBean(webKykNaiyouSyoukaiInfoBean);
    }

    @Test
    @TestOrder(160)
    public void testExec_A16() {
        changeSystemDate();

        MockObjectManager.initialize();
        BzGetProcessSummaryMockForHozen.SYORIPTN = BzGetProcessSummaryMockForHozen.TESTPATTERN2;

        WebKykNaiyouSyoukaiInfoBean webKykNaiyouSyoukaiInfoBean =
            hbKeiyakuSyoukai.exec("99809111688", BizDate.valueOf("20160621"), C_TanmatuSiyouKbn.SOUGOU_IPPAN, null);

        exStringEquals(webKykNaiyouSyoukaiInfoBean.getErrorKbn(), "1", "エラー区分");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getErrorMsg()
            , "選択されたご契約についてはご照会できません。", "エラーメッセージ");
        CheckEebKykNaiyouSyoukaiInfoBean(webKykNaiyouSyoukaiInfoBean);
    }

    @Test
    @TestOrder(170)
    public void testExec_A17() {
        changeSystemDate();

        MockObjectManager.initialize();
        BzGetProcessSummaryMockForHozen.SYORIPTN = BzGetProcessSummaryMockForHozen.TESTPATTERN2;
        BzGetAdrDataMockForHozen.SYORIPTN = BzGetAdrDataMockForHozen.TESTPATTERN1;

        WebKykNaiyouSyoukaiInfoBean webKykNaiyouSyoukaiInfoBean =
            hbKeiyakuSyoukai.exec("17806001140", BizDate.valueOf("20160621"), C_TanmatuSiyouKbn.SOUGOU_IPPAN, null);

        exStringEquals(webKykNaiyouSyoukaiInfoBean.getErrorKbn(), "1", "エラー区分");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getErrorMsg()
            , "選択されたご契約についてはご照会できません。", "エラーメッセージ");
        CheckEebKykNaiyouSyoukaiInfoBean(webKykNaiyouSyoukaiInfoBean);
    }

    @Test
    @TestOrder(180)
    public void testExec_A18() {
        changeSystemDate();

        MockObjectManager.initialize();
        BzGetProcessSummaryMockForHozen.SYORIPTN = BzGetProcessSummaryMockForHozen.TESTPATTERN2;
        BzGetAdrDataMockForHozen.SYORIPTN = BzGetAdrDataMockForHozen.TESTPATTERN1;

        WebKykNaiyouSyoukaiInfoBean webKykNaiyouSyoukaiInfoBean =
            hbKeiyakuSyoukai.exec("17806001140", BizDate.valueOf("20160621"), C_TanmatuSiyouKbn.SOUGOU_IPPAN, null);

        exStringEquals(webKykNaiyouSyoukaiInfoBean.getErrorKbn(), "1", "エラー区分");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getErrorMsg()
            , "選択されたご契約についてはご照会できません。", "エラーメッセージ");
        CheckEebKykNaiyouSyoukaiInfoBean(webKykNaiyouSyoukaiInfoBean);
    }

    @Test
    @TestOrder(190)
    public void testExec_A19() {
        changeSystemDate();

        MockObjectManager.initialize();
        BzGetProcessSummaryMockForHozen.SYORIPTN = BzGetProcessSummaryMockForHozen.TESTPATTERN2;
        BzGetAdrDataMockForHozen.SYORIPTN = BzGetAdrDataMockForHozen.TESTPATTERN1;

        WebKykNaiyouSyoukaiInfoBean webKykNaiyouSyoukaiInfoBean =
            hbKeiyakuSyoukai.exec("17806000541", BizDate.valueOf("20160621"), C_TanmatuSiyouKbn.SOUGOU_IPPAN, null);

        exStringEquals(webKykNaiyouSyoukaiInfoBean.getErrorKbn(), "1", "エラー区分");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getErrorMsg()
            , "選択されたご契約についてはご照会できません。", "エラーメッセージ");
        CheckEebKykNaiyouSyoukaiInfoBean(webKykNaiyouSyoukaiInfoBean);

        exStringEquals(
            (String) MockObjectManager.getArgument(BzGetAdrDataMockForHozen.class, "execAdrKanaBlankAriByPostalcd", 0, 0),
            "1234567", "郵便番号");


    }

    @Test
    @TestOrder(200)
    public void testExec_A20() {
        changeSystemDate();

        MockObjectManager.initialize();
        BzGetProcessSummaryMockForHozen.SYORIPTN = BzGetProcessSummaryMockForHozen.TESTPATTERN2;
        BzGetAdrDataMockForHozen.SYORIPTN = BzGetAdrDataMockForHozen.TESTPATTERN1;

        WebKykNaiyouSyoukaiInfoBean webKykNaiyouSyoukaiInfoBean =
            hbKeiyakuSyoukai.exec("17806000840", BizDate.valueOf("20160621"), C_TanmatuSiyouKbn.SOUGOU_IPPAN, null);

        exStringEquals(webKykNaiyouSyoukaiInfoBean.getErrorKbn(), "1", "エラー区分");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getErrorMsg()
            , "選択されたご契約についてはご照会できません。", "エラーメッセージ");
        CheckEebKykNaiyouSyoukaiInfoBean(webKykNaiyouSyoukaiInfoBean);


    }

    @Test
    @TestOrder(210)
    public void testExec_A21() {
        changeSystemDate();

        MockObjectManager.initialize();
        BzGetProcessSummaryMockForHozen.SYORIPTN = BzGetProcessSummaryMockForHozen.TESTPATTERN2;
        BzGetAdrDataMockForHozen.SYORIPTN = BzGetAdrDataMockForHozen.TESTPATTERN1;
        CalcHkShrKngkMockForHozen.SYORIPTN = CalcHkShrKngkMockForHozen.TESTPATTERN1;

        WebKykNaiyouSyoukaiInfoBean webKykNaiyouSyoukaiInfoBean =
            hbKeiyakuSyoukai.exec("99809111242", BizDate.valueOf("20160621"), C_TanmatuSiyouKbn.SOUGOU_IPPAN, null);

        exStringEquals(webKykNaiyouSyoukaiInfoBean.getErrorKbn(), "1", "エラー区分");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getErrorMsg()
            , "選択されたご契約についてはご照会できません。", "エラーメッセージ");
        CheckEebKykNaiyouSyoukaiInfoBean(webKykNaiyouSyoukaiInfoBean);

        exStringEquals((String) MockObjectManager.getArgument(CalcHkShrKngkMockForHozen.class, "execByKeisanWExt", 0, 0),
            "99809111242", "証券番号");
        exDateEquals((BizDate) MockObjectManager.getArgument(CalcHkShrKngkMockForHozen.class, "execByKeisanWExt", 0, 1),
            BizDate.getSysDate(), "計算基準日");
        exNumericEquals((Integer) MockObjectManager.getArgument(CalcHkShrKngkMockForHozen.class, "execByKeisanWExt", 0, 2),
            10, "第１保険期間");
        exNumericEquals((Integer) MockObjectManager.getArgument(CalcHkShrKngkMockForHozen.class, "execByKeisanWExt", 0, 3),
            1, "ＭＶＡ適用期間");
        exClassificationEquals((C_SiinKbn) MockObjectManager.getArgument(CalcHkShrKngkMockForHozen.class, "execByKeisanWExt", 0, 4),
            C_SiinKbn.SP, "死因区分");
        exClassificationEquals(
            (C_HokenkinsyuruiKbn) MockObjectManager.getArgument(CalcHkShrKngkMockForHozen.class, "execByKeisanWExt", 0, 5),
            C_HokenkinsyuruiKbn.SBHOKENKIN, "保険金種類区分");
        exClassificationEquals(
            (C_Kykjyoutai) MockObjectManager.getArgument(CalcHkShrKngkMockForHozen.class, "execByKeisanWExt", 0, 6),
            C_Kykjyoutai.HRKMTYUU, "契約状態");
    }

    @Test
    @TestOrder(220)
    public void testExec_A22() {
        changeSystemDate();

        MockObjectManager.initialize();
        BzGetProcessSummaryMockForHozen.SYORIPTN = BzGetProcessSummaryMockForHozen.TESTPATTERN2;
        BzGetAdrDataMockForHozen.SYORIPTN = BzGetAdrDataMockForHozen.TESTPATTERN2;
        CalcHkShrKngkMockForHozen.SYORIPTN = CalcHkShrKngkMockForHozen.TESTPATTERN6;

        WebKykNaiyouSyoukaiInfoBean webKykNaiyouSyoukaiInfoBean =
            hbKeiyakuSyoukai.exec("99809111242", BizDate.valueOf("20160621"), C_TanmatuSiyouKbn.SOUGOU_IPPAN, null);

        exStringEquals(webKykNaiyouSyoukaiInfoBean.getErrorKbn(), "1", "エラー区分");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getErrorMsg()
            , "選択されたご契約についてはご照会できません。", "エラーメッセージ");
        CheckEebKykNaiyouSyoukaiInfoBean(webKykNaiyouSyoukaiInfoBean);

        exStringEquals((String) MockObjectManager.getArgument(CalcHkShrKngkMockForHozen.class, "exec", 0, 0),"T110","商品コード");
        exNumericEquals((Integer) MockObjectManager.getArgument(CalcHkShrKngkMockForHozen.class, "exec", 0, 1),1,"商品世代番号");
        exStringEquals((String) MockObjectManager.getArgument(CalcHkShrKngkMockForHozen.class, "exec", 0, 2),"11","料率世代番号");
        exBizCalcbleEquals((BizNumber) MockObjectManager.getArgument(CalcHkShrKngkMockForHozen.class, "exec",0, 3),BizNumber.valueOf(1.25),"予定利率");
        exClassificationEquals((C_Hrkkaisuu) MockObjectManager.getArgument(CalcHkShrKngkMockForHozen.class, "exec", 0, 4),C_Hrkkaisuu.NEN,"払込回数");
        exClassificationEquals((C_HknkknsmnKbn) MockObjectManager.getArgument(CalcHkShrKngkMockForHozen.class, "exec", 0, 5),C_HknkknsmnKbn.NENMANKI,"保険期間歳満期区分");
        exNumericEquals((Integer) MockObjectManager.getArgument(CalcHkShrKngkMockForHozen.class, "exec", 0, 6),20,"保険期間");
        exNumericEquals((Integer) MockObjectManager.getArgument(CalcHkShrKngkMockForHozen.class, "exec", 0, 7),30,"払込期間");
        exNumericEquals((Integer) MockObjectManager.getArgument(CalcHkShrKngkMockForHozen.class, "exec", 0, 8),35,"被保険者年齢");
        exClassificationEquals((C_Hhknsei) MockObjectManager.getArgument(CalcHkShrKngkMockForHozen.class, "exec", 0, 9),C_Hhknsei.FEMALE,"被保険者性別");
        exBizCalcbleEquals((BizCurrency) MockObjectManager.getArgument(CalcHkShrKngkMockForHozen.class, "exec", 0, 10),BizCurrency.valueOf(12, BizCurrencyTypes.DOLLAR),"基本S");
        exDateEquals((BizDate) MockObjectManager.getArgument(CalcHkShrKngkMockForHozen.class, "exec", 0, 11),BizDate.valueOf("20160619"),"契約日");
        exDateEquals((BizDate) MockObjectManager.getArgument(CalcHkShrKngkMockForHozen.class, "exec", 0, 12),BizDate.valueOf("20170619"),"計算基準日");
        exStringEquals((String) MockObjectManager.getArgument(CalcHkShrKngkMockForHozen.class, "exec", 0, 13),"99809111242","証券番号");
        exClassificationEquals((C_Tuukasyu) MockObjectManager.getArgument(CalcHkShrKngkMockForHozen.class, "exec", 0, 14),C_Tuukasyu.USD,"通貨種類");
        exNumericEquals((Integer) MockObjectManager.getArgument(CalcHkShrKngkMockForHozen.class, "exec", 0, 15),10,"第１保険期間");
        exNumericEquals((Integer) MockObjectManager.getArgument(CalcHkShrKngkMockForHozen.class, "exec", 0, 16),1,"ＭＶＡ適用期間");
        exClassificationEquals((C_SiinKbn) MockObjectManager.getArgument(CalcHkShrKngkMockForHozen.class, "exec", 0, 17),C_SiinKbn.SP,"死因区分");
        exClassificationEquals((C_HokenkinsyuruiKbn) MockObjectManager.getArgument(CalcHkShrKngkMockForHozen.class, "exec", 0, 18),C_HokenkinsyuruiKbn.SBHOKENKIN,"保険金種類区分");
        exBizCalcbleEquals((BizCurrency) MockObjectManager.getArgument(CalcHkShrKngkMockForHozen.class, "exec", 0, 19),BizCurrency.valueOf(2200,BizCurrencyTypes.YEN),"保険料");
        exBizCalcbleEquals((BizNumber) MockObjectManager.getArgument(CalcHkShrKngkMockForHozen.class, "exec", 0, 20),BizNumber.valueOf(0),"解約時市場価格調整用利率");
        exBizCalcbleEquals((BizNumber) MockObjectManager.getArgument(CalcHkShrKngkMockForHozen.class, "exec", 0, 21),BizNumber.valueOf(5.26),"契約時市場価格調整用利率");
        exDateYMEquals((BizDateYM) MockObjectManager.getArgument(CalcHkShrKngkMockForHozen.class, "exec", 0, 22),null,"積立金対象年月");
        exBizCalcbleEquals((BizCurrency) MockObjectManager.getArgument(CalcHkShrKngkMockForHozen.class, "exec", 0, 23),BizCurrency.valueOf(0),"定率積立金額");
        exBizCalcbleEquals((BizCurrency) MockObjectManager.getArgument(CalcHkShrKngkMockForHozen.class, "exec", 0, 24),BizCurrency.valueOf(0),"指数連動積立金額");
        exBizCalcbleEquals((BizNumber) MockObjectManager.getArgument(CalcHkShrKngkMockForHozen.class, "exec", 0, 25),BizNumber.valueOf(0),"積立利率");
        exClassificationEquals((C_HrkkknsmnKbn) MockObjectManager.getArgument(CalcHkShrKngkMockForHozen.class, "exec", 0, 26),null,"払込期間歳満期区分");
        exDateYMEquals((BizDateYM) MockObjectManager.getArgument(CalcHkShrKngkMockForHozen.class, "exec", 0, 27),null,"次回Ｐ充当年月");
        exBizCalcbleEquals((BizCurrency) MockObjectManager.getArgument(CalcHkShrKngkMockForHozen.class, "exec", 0, 28),null,"保険料積立金額");
        exBizCalcbleEquals((BizCurrency) MockObjectManager.getArgument(CalcHkShrKngkMockForHozen.class, "exec", 0, 29),null,"既払込保険料相当額");
        exDateEquals((BizDate) MockObjectManager.getArgument(CalcHkShrKngkMockForHozen.class, "exec", 0, 30),null,"初回保険料領収日");
        exBizCalcbleEquals((BizNumber) MockObjectManager.getArgument(CalcHkShrKngkMockForHozen.class, "exec", 0, 31),null,"予定利率変動時保証利率");
        exClassificationEquals((C_Kykjyoutai) MockObjectManager.getArgument(CalcHkShrKngkMockForHozen.class, "exec", 0, 32),C_Kykjyoutai.HRKMTYUU,"契約状態");
        exDateEquals((BizDate) MockObjectManager.getArgument(CalcHkShrKngkMockForHozen.class, "exec", 0, 33),BizDate.valueOf("20180316"),"円建変更日");
    }

    @Test
    @TestOrder(230)
    public void testExec_A23() {
        changeSystemDate();

        MockObjectManager.initialize();
        BzGetProcessSummaryMockForHozen.SYORIPTN = BzGetProcessSummaryMockForHozen.TESTPATTERN2;
        BzGetAdrDataMockForHozen.SYORIPTN = BzGetAdrDataMockForHozen.TESTPATTERN2;
        CalcHkShrKngkMockForHozen.SYORIPTN = CalcHkShrKngkMockForHozen.TESTPATTERN2;
        KeisanWExtMockForHozen.SYORIPTN = KeisanWExtMockForHozen.TESTPATTERN1;

        WebKykNaiyouSyoukaiInfoBean webKykNaiyouSyoukaiInfoBean =
            hbKeiyakuSyoukai.exec("99809111242", BizDate.valueOf("20160621"), C_TanmatuSiyouKbn.SOUGOU_IPPAN, null);

        exStringEquals(webKykNaiyouSyoukaiInfoBean.getErrorKbn(), "1", "エラー区分");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getErrorMsg()
            , "選択されたご契約についてはご照会できません。", "エラーメッセージ");

        CheckEebKykNaiyouSyoukaiInfoBean(webKykNaiyouSyoukaiInfoBean);


        exStringEquals((String) MockObjectManager.getArgument(KeisanWExtMockForHozen.class, "exec", 0, 0),
            "99809111242", "証券番号");
        exDateEquals((BizDate) MockObjectManager.getArgument(KeisanWExtMockForHozen.class, "exec", 0, 1),
            BizDate.getSysDate(), "計算基準日");
    }

    @Test
    @TestOrder(240)
    public void testExec_A24() {
        changeSystemDate();

        MockObjectManager.initialize();
        BzGetProcessSummaryMockForHozen.SYORIPTN = BzGetProcessSummaryMockForHozen.TESTPATTERN2;
        BzGetAdrDataMockForHozen.SYORIPTN = BzGetAdrDataMockForHozen.TESTPATTERN2;
        CalcHkShrKngkMockForHozen.SYORIPTN = CalcHkShrKngkMockForHozen.TESTPATTERN2;
        KeisanWExtMockForHozen.SYORIPTN = KeisanWExtMockForHozen.TESTPATTERN2;
        KeisanWMockForHozen.SYORIPTN = KeisanWMockForHozen.TESTPATTERN1;
        KeisanKijyungkMockForHozen.SYORIPTN = KeisanKijyungkMockForHozen.TESTPATTERN1;

        WebKykNaiyouSyoukaiInfoBean webKykNaiyouSyoukaiInfoBean =
            hbKeiyakuSyoukai.exec("99809111286", BizDate.valueOf("20270621"), C_TanmatuSiyouKbn.SOUGOU_IPPAN, null);

        exStringEquals(webKykNaiyouSyoukaiInfoBean.getErrorKbn(), "1", "エラー区分");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getErrorMsg()
            , "選択されたご契約についてはご照会できません。", "エラーメッセージ");

        CheckEebKykNaiyouSyoukaiInfoBean(webKykNaiyouSyoukaiInfoBean);

        exDateEquals((BizDate) MockObjectManager.getArgument(KeisanKijyungkMockForHozen.class, "exec", 0, 0),
            BizDate.valueOf("20170701"), "保険料領収日");
        exBizCalcbleEquals((BizCurrency) MockObjectManager.getArgument(KeisanKijyungkMockForHozen.class, "exec", 0, 1),
            BizCurrency.valueOf(1001), "領収金額");
        exBizCalcbleEquals((BizCurrency) MockObjectManager.getArgument(KeisanKijyungkMockForHozen.class, "exec", 0, 2),
            BizCurrency.valueOf(1001), "保険料");
        exClassificationEquals((C_Tuukasyu) MockObjectManager.getArgument(KeisanKijyungkMockForHozen.class, "exec", 0, 3),
            C_Tuukasyu.EUR, "契約通貨種類");
        exClassificationEquals((C_Tkhukaumu) MockObjectManager.getArgument(KeisanKijyungkMockForHozen.class, "exec", 0, 4),
            C_Tkhukaumu.NONE, "円入金特約付加区分");

    }

    @Test
    @TestOrder(250)
    public void testExec_A25() {
        changeSystemDate();

        MockObjectManager.initialize();
        BzGetProcessSummaryMockForHozen.SYORIPTN = BzGetProcessSummaryMockForHozen.TESTPATTERN2;
        BzGetAdrDataMockForHozen.SYORIPTN = BzGetAdrDataMockForHozen.TESTPATTERN1;
        CalcHkShrKngkMockForHozen.SYORIPTN = CalcHkShrKngkMockForHozen.TESTPATTERN3;
        KeisanWExtMockForHozen.SYORIPTN = KeisanWExtMockForHozen.TESTPATTERN2;
        KeisanWMockForHozen.SYORIPTN = KeisanWMockForHozen.TESTPATTERN1;
        KeisanKijyungkMockForHozen.SYORIPTN = KeisanKijyungkMockForHozen.TESTPATTERN2;
        KeisanGaikakanzanMockForHozen.SYORIPTN = KeisanGaikakanzanMockForHozen.TESTPATTERN1;
        SetNenreiMockForHozen.SYORIPTN = SetNenreiMockForHozen.TESTPATTERN1;
        HanteiKhSisuurendoTmttknJyoutaiMockForHozen.SYORIPTN = HanteiKhSisuurendoTmttknJyoutaiMockForHozen.TESTPATTERN2;

        WebKykNaiyouSyoukaiInfoBean webKykNaiyouSyoukaiInfoBean =
            hbKeiyakuSyoukai.exec("17806000024", BizDate.valueOf("20160621"), C_TanmatuSiyouKbn.SOUGOU_IPPAN, null);

        exStringEquals(webKykNaiyouSyoukaiInfoBean.getErrorKbn(), "", "エラー区分");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getErrorMsg(), "", "エラーメッセージ");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getKyknmkn(), "ｶﾅ", "契約者名（カナ）");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getKyknmkj(), "契約者名漢字１－２９　様", "契約者名（漢字）");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getKykseiymd(), "昭和５５年　１月　１日", "契約者生年月日");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getKojinhjnKbn(), "個人", "個人法人区分");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTelno(), "010-1234-5678", "電話番号");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getPostalCd(), "２２３－４５６７", "郵便番号");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getAdr(), "通信先住所１通信先住所２通信先住所３", "住所");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getAdrkn(), "ｶﾅｶﾅｶﾅｶﾅ", "住所(ｶﾅ)");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHhknnm(), "被保険者名１－２９　様", "被保険者氏名");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHhknsei(), "女性", "被保険者性別");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHhknseiymd(), "昭和５６年　１月　１日", "被保険者生年月日");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHhknNen(), "３５歳", "被保険者年齢");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHhknKykjiNen(), "２５歳", "被保険者契約時年齢");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getSyouhnnm(), "商品名称５６７８９０１２３４５６７８９０１２３４５６７８９０１２３４５６　しんきんらいふ終身Ｓ　ふるはーとＪロードグローバ", "商品名");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getSyurui(), "", "種類");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getSyono(), "17806000024", "証券番号");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getCifCd(), "100000000000001", "CIFｺｰﾄﾞ");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getKykymd(), "平成１８年　１月　１日", "契約日");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHrkhou(), "", "払込方法");
        exBizCalcbleEquals(webKykNaiyouSyoukaiInfoBean.getSibous()
            , BizCurrency.valueOf(10000.00, BizCurrencyTypes.EURO), "死亡保険金");
        Assert.assertEquals(webKykNaiyouSyoukaiInfoBean.getSibous().getType(), BizCurrencyTypes.EURO);
        exBizCalcbleEquals(webKykNaiyouSyoukaiInfoBean.getHrkp()
            , BizCurrency.valueOf(1001, BizCurrencyTypes.YEN), "払込保険料");
        Assert.assertEquals(webKykNaiyouSyoukaiInfoBean.getHrkp().getType(), BizCurrencyTypes.YEN);
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getNkShrStartYmd(), "", "年金支払開始日");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getNenkinHosyouYear(), "", "年金保証年");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getNenkinKbn(), "", "年金区分");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHaitouKbn(), "", "配当区分");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getSinsaKbn(), "告知書扱", "診査区分");
        exNumericEquals(webKykNaiyouSyoukaiInfoBean.getTksuu(), 2, "特約数");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getLivingneedsTkhyj(), "", "リビングニーズ特約表示");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHokenMankiDay(), "平成２８年　２月２９日", "保険満期日");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getSyunm(), "", "主契約名称");
        exBizCalcbleEquals(webKykNaiyouSyoukaiInfoBean.getSyus()
            , BizCurrency.valueOf(1002, BizCurrencyTypes.YEN), "主契約保険金額");
        Assert.assertEquals(webKykNaiyouSyoukaiInfoBean.getSyus().getType(), BizCurrencyTypes.YEN);
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getSyuhknkkn(), "", "主契約保険期間");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getSyuhrkkkn(), "", "主契約払込期間");
        exNumericEquals(webKykNaiyouSyoukaiInfoBean.getTkNaiyouGyousuu(), 2, "特約内容行数");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTknm1(), "保険料指定外通貨払込特約", "特約名称１");
        exBizCalcbleEquals(webKykNaiyouSyoukaiInfoBean.getTks1(), BizCurrency.optional(), "特約保険金額１");
        Assert.assertEquals(webKykNaiyouSyoukaiInfoBean.getTks1().getType()
            , BizNumberConfig.instance.getDefaultCurrencyType());
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTokuyakuhokenkikan1(), "", "特約保険期間１");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTokuyakuharaikomikikan1(), "", "特約払込期間１");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTknm2(), "指定代理請求特約", "特約名称２");
        exBizCalcbleEquals(webKykNaiyouSyoukaiInfoBean.getTks2(), BizCurrency.optional(), "特約保険金額２");
        Assert.assertEquals(webKykNaiyouSyoukaiInfoBean.getTks2().getType()
            , BizNumberConfig.instance.getDefaultCurrencyType());
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTokuyakuhokenkikan2(), "", "特約保険期間２");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTokuyakuharaikomikikan2(), "", "特約払込期間２");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTknm3(), "", "特約名称３");
        exBizCalcbleEquals(webKykNaiyouSyoukaiInfoBean.getTks3(), BizCurrency.optional(), "特約保険金額３");
        Assert.assertEquals(webKykNaiyouSyoukaiInfoBean.getTks3().getType()
            , BizNumberConfig.instance.getDefaultCurrencyType());
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTokuyakuhokenkikan3(), "", "特約保険期間３");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTokuyakuharaikomikikan3(), "", "特約払込期間３");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTknm4(), "", "特約名称４");
        exBizCalcbleEquals(webKykNaiyouSyoukaiInfoBean.getTks4(), BizCurrency.optional(), "特約保険金額４");
        Assert.assertEquals(webKykNaiyouSyoukaiInfoBean.getTks4().getType()
            , BizNumberConfig.instance.getDefaultCurrencyType());
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTokuyakuhokenkikan4(), "", "特約保険期間４");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTokuyakuharaikomikikan4(), "", "特約払込期間４");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTknm5(), "", "特約名称５");
        exBizCalcbleEquals(webKykNaiyouSyoukaiInfoBean.getTks5(), BizCurrency.optional(), "特約保険金額５");
        Assert.assertEquals(webKykNaiyouSyoukaiInfoBean.getTks5().getType()
            , BizNumberConfig.instance.getDefaultCurrencyType());
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTokuyakuhokenkikan5(), "", "特約保険期間５");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTokuyakuharaikomikikan5(), "", "特約払込期間５");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTknm6(), "", "特約名称６");
        exBizCalcbleEquals(webKykNaiyouSyoukaiInfoBean.getTks6(), BizCurrency.optional(), "特約保険金額６");
        Assert.assertEquals(webKykNaiyouSyoukaiInfoBean.getTks6().getType()
            , BizNumberConfig.instance.getDefaultCurrencyType());
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTokuyakuhokenkikan6(), "", "特約保険期間６");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTokuyakuharaikomikikan6(), "", "特約払込期間６");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTknm7(), "", "特約名称７");
        exBizCalcbleEquals(webKykNaiyouSyoukaiInfoBean.getTks7(), BizCurrency.optional(), "特約保険金額７");
        Assert.assertEquals(webKykNaiyouSyoukaiInfoBean.getTks7().getType()
            , BizNumberConfig.instance.getDefaultCurrencyType());
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTokuyakuhokenkikan7(), "", "特約保険期間７");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTokuyakuharaikomikikan7(), "", "特約払込期間７");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTknm8(), "", "特約名称８");
        exBizCalcbleEquals(webKykNaiyouSyoukaiInfoBean.getTks8(), BizCurrency.optional(), "特約保険金額８");
        Assert.assertEquals(webKykNaiyouSyoukaiInfoBean.getTks8().getType()
            , BizNumberConfig.instance.getDefaultCurrencyType());
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTokuyakuhokenkikan8(), "", "特約保険期間８");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTokuyakuharaikomikikan8(), "", "特約払込期間８");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTknm9(), "", "特約名称９");
        exBizCalcbleEquals(webKykNaiyouSyoukaiInfoBean.getTks9(), BizCurrency.optional(), "特約保険金額９");
        Assert.assertEquals(webKykNaiyouSyoukaiInfoBean.getTks9().getType()
            , BizNumberConfig.instance.getDefaultCurrencyType());
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTokuyakuhokenkikan9(), "", "特約保険期間９");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTokuyakuharaikomikikan9(), "", "特約払込期間９");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTknm10(), "", "特約名称１０");
        exBizCalcbleEquals(webKykNaiyouSyoukaiInfoBean.getTks10(), BizCurrency.optional(), "特約保険金額１０");
        Assert.assertEquals(webKykNaiyouSyoukaiInfoBean.getTks10().getType()
            , BizNumberConfig.instance.getDefaultCurrencyType());
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTokuyakuhokenkikan10(), "", "特約保険期間１０");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTokuyakuharaikomikikan10(), "", "特約払込期間１０");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTknm11(), "", "特約名称１１");
        exBizCalcbleEquals(webKykNaiyouSyoukaiInfoBean.getTks11(), BizCurrency.optional(), "特約保険金額１１");
        Assert.assertEquals(webKykNaiyouSyoukaiInfoBean.getTks11().getType()
            , BizNumberConfig.instance.getDefaultCurrencyType());
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTokuyakuhokenkikan11(), "", "特約保険期間１１");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTokuyakuharaikomikikan11(), "", "特約払込期間１１");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTknm12(), "", "特約名称１２");
        exBizCalcbleEquals(webKykNaiyouSyoukaiInfoBean.getTks12(), BizCurrency.optional(), "特約保険金額１２");
        Assert.assertEquals(webKykNaiyouSyoukaiInfoBean.getTks12().getType()
            , BizNumberConfig.instance.getDefaultCurrencyType());
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTokuyakuhokenkikan12(), "", "特約保険期間１２");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTokuyakuharaikomikikan12(), "", "特約払込期間１２");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTknm13(), "", "特約名称１３");
        exBizCalcbleEquals(webKykNaiyouSyoukaiInfoBean.getTks13(), BizCurrency.optional(), "特約保険金額１３");
        Assert.assertEquals(webKykNaiyouSyoukaiInfoBean.getTks13().getType()
            , BizNumberConfig.instance.getDefaultCurrencyType());
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTokuyakuhokenkikan13(), "", "特約保険期間１３");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTokuyakuharaikomikikan13(), "", "特約払込期間１３");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTknm14(), "", "特約名称１４");
        exBizCalcbleEquals(webKykNaiyouSyoukaiInfoBean.getTks14(), BizCurrency.optional(), "特約保険金額１４");
        Assert.assertEquals(webKykNaiyouSyoukaiInfoBean.getTks14().getType()
            , BizNumberConfig.instance.getDefaultCurrencyType());
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTokuyakuhokenkikan14(), "", "特約保険期間１４");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTokuyakuharaikomikikan14(), "", "特約払込期間１４");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTknm15(), "", "特約名称１５");
        exBizCalcbleEquals(webKykNaiyouSyoukaiInfoBean.getTks15(), BizCurrency.optional(), "特約保険金額１５");
        Assert.assertEquals(webKykNaiyouSyoukaiInfoBean.getTks15().getType()
            , BizNumberConfig.instance.getDefaultCurrencyType());
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTokuyakuhokenkikan15(), "", "特約保険期間１５");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTokuyakuharaikomikikan15(), "", "特約払込期間１５");
        exNumericEquals(webKykNaiyouSyoukaiInfoBean.getSyouhnNaiyouGyousuu(), 1, "商品内容行数");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getSyouhnNaiyou1(), "現在の保障内容は下記のとおりです。", "商品内容１");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getSyouhnNaiyou2(), "", "商品内容２");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getSyouhnNaiyou3(), "", "商品内容３");
        exNumericEquals(webKykNaiyouSyoukaiInfoBean.getHosyouNaiyouGyousuu(), 10, "保障内容行数");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHosyouNaiyou1(), "死亡時支払金受取人　被保険者　様", "保障内容１");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHosyouNaiyou2(), "指定代理請求人　　　指定特定名義　１－２９　様　　　　　　　", "保障内容２");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHosyouNaiyou3(), "　第２保険期間（照会日時点）　　　　　　　　　　　１０，０００円", "保障内容３");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHosyouNaiyou4(), "　　　　　　　　　　　　　　　　　　　　　　　　　（円）", "保障内容４");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHosyouNaiyou5(), "　第３保険期間（契約日から１５年経過時点）　　　　１０，０００．００円", "保障内容５");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHosyouNaiyou6(), "　　　　　　　　　　　　　　　　　　　　　　　　　（０円）", "保障内容６");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHosyouNaiyou7(), "解約返戻金額（照会日時点）　１，０００円", "保障内容７");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHosyouNaiyou8(), "積立金額（照会日時点）　１，０００円", "保障内容８");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHosyouNaiyou9(), "保険法対応契約", "保障内容９");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHosyouNaiyou10(), "指定代理請求特約あり", "保障内容１０");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHosyouNaiyou11(), "", "保障内容１１");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHosyouNaiyou12(), "", "保障内容１２");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHosyouNaiyou13(), "", "保障内容１３");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHosyouNaiyou14(), "", "保障内容１４");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHosyouNaiyou15(), "", "保障内容１５");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHosyouNaiyou16(), "", "保障内容１６");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHosyouNaiyou17(), "", "保障内容１７");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHosyouNaiyou18(), "", "保障内容１８");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHosyouNaiyou19(), "", "保障内容１９");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHosyouNaiyou20(), "", "保障内容２０");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHosyouNaiyou21(), "", "保障内容２１");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHosyouNaiyou22(), "", "保障内容２２");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHosyouNaiyou23(), "", "保障内容２３");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHosyouNaiyou24(), "", "保障内容２４");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHosyouNaiyou25(), "", "保障内容２５");
        exNumericEquals(webKykNaiyouSyoukaiInfoBean.getHenkouKeiiGyousuu(), 9, "変更経緯行数");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHenkouKeii1(), "平成２７年１２月　２日　契約内容変更", "変更経緯１");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHenkouKeii2(), "平成２７年１２月　２日　保険料払方変更", "変更経緯２");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHenkouKeii3(), "平成２７年１２月　２日　住所変更", "変更経緯３");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHenkouKeii4(), "平成２７年１２月　２日　契約内容変更", "変更経緯４");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHenkouKeii5(), "平成２７年１２月　２日　名義変更", "変更経緯５");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHenkouKeii6(), "平成２７年１２月　２日　名義変更", "変更経緯６");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHenkouKeii7(), "平成２７年１２月　２日　名義変更", "変更経緯７");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHenkouKeii8(), "平成２７年１２月　２日　契約内容変更", "変更経緯８");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHenkouKeii9(), "平成２７年１２月　２日　契約内容変更", "変更経緯９");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHenkouKeii10(), "", "変更経緯１０");
        exNumericEquals(webKykNaiyouSyoukaiInfoBean.getBosyuDrtenGyousuu(), 1, "募集代理店行数");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getBosyuDrtenNm1(), "取扱代理店名３", "募集代理店名１");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getDrtenBnwari1(), "", "代理店分割割合１");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getBosyuDrtenNm2(), "", "募集代理店名２");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getDrtenBnwari2(), "", "代理店分割割合２");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getMsgOutKbn(), "2", "MSG出力区分");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHosyouIkkatuMinaokeiyakuHyouji(), "0", "保障一括見直契約表示");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHhknnmkn(), "ﾋﾎｹﾝｼｶﾅ", "被保険者氏名(ｶﾅ)");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHokenryouSyuunouJyoukyou(), "未収あり", "保険料収納状況");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getJikaiHokenryouJyuutouYm(), "平成２８年　５月", "次回保険料充当年月");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getMdhansybetuKbn(), "01", "窓販種別区分");

        exDateEquals((BizDate) MockObjectManager.getArgument(SetNenreiMockForHozen.class, "exec", 0, 0), BizDate.getSysDate(), "基準日");
        exDateEquals((BizDate) MockObjectManager.getArgument(SetNenreiMockForHozen.class, "exec", 0, 1), BizDate.valueOf("19810101"), "生年月日");

    }

    @Test
    @TestOrder(260)
    public void testExec_A26() {
        changeSystemDate();

        MockObjectManager.initialize();
        BzGetProcessSummaryMockForHozen.SYORIPTN = BzGetProcessSummaryMockForHozen.TESTPATTERN2;
        BzGetAdrDataMockForHozen.SYORIPTN = BzGetAdrDataMockForHozen.TESTPATTERN2;
        CalcHkShrKngkMockForHozen.SYORIPTN = CalcHkShrKngkMockForHozen.TESTPATTERN3;
        KeisanWExtMockForHozen.SYORIPTN = KeisanWExtMockForHozen.TESTPATTERN2;
        KeisanWMockForHozen.SYORIPTN = KeisanWMockForHozen.TESTPATTERN1;
        KeisanKijyungkMockForHozen.SYORIPTN = KeisanKijyungkMockForHozen.TESTPATTERN2;
        KeisanGaikakanzanMockForHozen.SYORIPTN = KeisanGaikakanzanMockForHozen.TESTPATTERN1;
        SetNenreiMockForHozen.SYORIPTN = SetNenreiMockForHozen.TESTPATTERN1;

        WebKykNaiyouSyoukaiInfoBean webKykNaiyouSyoukaiInfoBean =
            hbKeiyakuSyoukai.exec("99809111297", BizDate.valueOf("20160621"), C_TanmatuSiyouKbn.SOUGOU_IPPAN, null);

        exStringEquals(webKykNaiyouSyoukaiInfoBean.getErrorKbn(), "", "エラー区分");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getErrorMsg(), "", "エラーメッセージ");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getKyknmkn(), "ｹｲﾔｸｼﾔﾒｲｶﾅ1-14", "契約者名（カナ）");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getKyknmkj(), "契約者名漢字１－１４　様", "契約者名（漢字）");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getKykseiymd(), "昭和５５年　１月　１日", "契約者生年月日");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getKojinhjnKbn(), "個人", "個人法人区分");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTelno(), "010-1234-5678", "電話番号");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getPostalCd(), "１２３－４５６７", "郵便番号");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getAdr(), "通信先住所１通信先住所２通信先住所３", "住所");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getAdrkn(), "", "住所(ｶﾅ)");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHhknnm(), "被保険者名　様", "被保険者氏名");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHhknsei(), "性", "被保険者性別");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHhknseiymd(), "昭和５６年　１月　１日", "被保険者生年月日");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHhknNen(), "３５歳", "被保険者年齢");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHhknKykjiNen(), "２５歳", "被保険者契約時年齢");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getSyouhnnm(), "笑顔の約束", "商品名");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getSyurui(), "終身保険", "種類");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getSyono(), "99809111297", "証券番号");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getCifCd(), "*****", "CIFｺｰﾄﾞ");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getKykymd(), "平成２８年　６月２１日", "契約日");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHrkhou(), "前納中", "払込方法");
        exBizCalcbleEquals(webKykNaiyouSyoukaiInfoBean.getSibous()
            , BizCurrency.valueOf(10000.00, BizCurrencyTypes.EURO), "死亡保険金");
        Assert.assertEquals(webKykNaiyouSyoukaiInfoBean.getSibous().getType(), BizCurrencyTypes.EURO);
        exBizCalcbleEquals(webKykNaiyouSyoukaiInfoBean.getHrkp()
            , BizCurrency.valueOf(1001.00, BizCurrencyTypes.EURO), "払込保険料");
        Assert.assertEquals(webKykNaiyouSyoukaiInfoBean.getHrkp().getType(), BizCurrencyTypes.EURO);
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getNkShrStartYmd(), "平成２８年　２月２９日", "年金支払開始日");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getNenkinHosyouYear(), "１０年", "年金保証年");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getNenkinKbn(), "確定年金", "年金区分");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHaitouKbn(), "準有配当", "配当区分");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getSinsaKbn(), "告知書扱", "診査区分");
        exNumericEquals(webKykNaiyouSyoukaiInfoBean.getTksuu(), 5, "特約数");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getLivingneedsTkhyj(), "", "リビングニーズ特約表示");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHokenMankiDay(), "終身", "保険満期日");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getSyunm(), "終身保険", "主契約名称");
        exBizCalcbleEquals(webKykNaiyouSyoukaiInfoBean.getSyus()
            , BizCurrency.optional(), "主契約保険金額");
        Assert.assertEquals(webKykNaiyouSyoukaiInfoBean.getSyus().getType()
            , BizNumberConfig.instance.getDefaultCurrencyType());
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getSyuhknkkn(), "終身", "主契約保険期間");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getSyuhrkkkn(), "", "主契約払込期間");
        exNumericEquals(webKykNaiyouSyoukaiInfoBean.getTkNaiyouGyousuu(), 5, "特約内容行数");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTknm1(), "重度介護前払特約", "特約名称１");
        exBizCalcbleEquals(webKykNaiyouSyoukaiInfoBean.getTks1(), BizCurrency.optional(), "特約保険金額１");
        Assert.assertEquals(webKykNaiyouSyoukaiInfoBean.getTks1().getType()
            , BizNumberConfig.instance.getDefaultCurrencyType());
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTokuyakuhokenkikan1(), "", "特約保険期間１");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTokuyakuharaikomikikan1(), "", "特約払込期間１");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTknm2(), "初期死亡時円換算支払額最低保証特約", "特約名称２");
        exBizCalcbleEquals(webKykNaiyouSyoukaiInfoBean.getTks2(), BizCurrency.optional(), "特約保険金額２");
        Assert.assertEquals(webKykNaiyouSyoukaiInfoBean.getTks2().getType()
            , BizNumberConfig.instance.getDefaultCurrencyType());
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTokuyakuhokenkikan2(), "", "特約保険期間２");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTokuyakuharaikomikikan2(), "", "特約払込期間２");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTknm3(), "保険料円貨払込特約", "特約名称３");
        exBizCalcbleEquals(webKykNaiyouSyoukaiInfoBean.getTks3(), BizCurrency.optional(), "特約保険金額３");
        Assert.assertEquals(webKykNaiyouSyoukaiInfoBean.getTks3().getType()
            , BizNumberConfig.instance.getDefaultCurrencyType());
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTokuyakuhokenkikan3(), "", "特約保険期間３");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTokuyakuharaikomikikan3(), "", "特約払込期間３");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTknm4(), "目標到達時円建終身保険変更特約　指定なし", "特約名称４");
        exBizCalcbleEquals(webKykNaiyouSyoukaiInfoBean.getTks4(), BizCurrency.optional(), "特約保険金額４");
        Assert.assertEquals(webKykNaiyouSyoukaiInfoBean.getTks4().getType()
            , BizNumberConfig.instance.getDefaultCurrencyType());
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTokuyakuhokenkikan4(), "", "特約保険期間４");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTokuyakuharaikomikikan4(), "", "特約払込期間４");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTknm5(), "指定代理請求特約", "特約名称５");
        exBizCalcbleEquals(webKykNaiyouSyoukaiInfoBean.getTks5(), BizCurrency.optional(), "特約保険金額５");
        Assert.assertEquals(webKykNaiyouSyoukaiInfoBean.getTks5().getType()
            , BizNumberConfig.instance.getDefaultCurrencyType());
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTokuyakuhokenkikan5(), "", "特約保険期間５");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTokuyakuharaikomikikan5(), "", "特約払込期間５");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTknm6(), "", "特約名称６");
        exBizCalcbleEquals(webKykNaiyouSyoukaiInfoBean.getTks6(), BizCurrency.optional(), "特約保険金額６");
        Assert.assertEquals(webKykNaiyouSyoukaiInfoBean.getTks6().getType()
            , BizNumberConfig.instance.getDefaultCurrencyType());
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTokuyakuhokenkikan6(), "", "特約保険期間６");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTokuyakuharaikomikikan6(), "", "特約払込期間６");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTknm7(), "", "特約名称７");
        exBizCalcbleEquals(webKykNaiyouSyoukaiInfoBean.getTks7(), BizCurrency.optional(), "特約保険金額７");
        Assert.assertEquals(webKykNaiyouSyoukaiInfoBean.getTks7().getType()
            , BizNumberConfig.instance.getDefaultCurrencyType());
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTokuyakuhokenkikan7(), "", "特約保険期間７");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTokuyakuharaikomikikan7(), "", "特約払込期間７");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTknm8(), "", "特約名称８");
        exBizCalcbleEquals(webKykNaiyouSyoukaiInfoBean.getTks8(), BizCurrency.optional(), "特約保険金額８");
        Assert.assertEquals(webKykNaiyouSyoukaiInfoBean.getTks8().getType()
            , BizNumberConfig.instance.getDefaultCurrencyType());
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTokuyakuhokenkikan8(), "", "特約保険期間８");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTokuyakuharaikomikikan8(), "", "特約払込期間８");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTknm9(), "", "特約名称９");
        exBizCalcbleEquals(webKykNaiyouSyoukaiInfoBean.getTks9(), BizCurrency.optional(), "特約保険金額９");
        Assert.assertEquals(webKykNaiyouSyoukaiInfoBean.getTks9().getType()
            , BizNumberConfig.instance.getDefaultCurrencyType());
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTokuyakuhokenkikan9(), "", "特約保険期間９");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTokuyakuharaikomikikan9(), "", "特約払込期間９");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTknm10(), "", "特約名称１０");
        exBizCalcbleEquals(webKykNaiyouSyoukaiInfoBean.getTks10(), BizCurrency.optional(), "特約保険金額１０");
        Assert.assertEquals(webKykNaiyouSyoukaiInfoBean.getTks10().getType()
            , BizNumberConfig.instance.getDefaultCurrencyType());
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTokuyakuhokenkikan10(), "", "特約保険期間１０");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTokuyakuharaikomikikan10(), "", "特約払込期間１０");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTknm11(), "", "特約名称１１");
        exBizCalcbleEquals(webKykNaiyouSyoukaiInfoBean.getTks11(), BizCurrency.optional(), "特約保険金額１１");
        Assert.assertEquals(webKykNaiyouSyoukaiInfoBean.getTks11().getType()
            , BizNumberConfig.instance.getDefaultCurrencyType());
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTokuyakuhokenkikan11(), "", "特約保険期間１１");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTokuyakuharaikomikikan11(), "", "特約払込期間１１");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTknm12(), "", "特約名称１２");
        exBizCalcbleEquals(webKykNaiyouSyoukaiInfoBean.getTks12(), BizCurrency.optional(), "特約保険金額１２");
        Assert.assertEquals(webKykNaiyouSyoukaiInfoBean.getTks12().getType()
            , BizNumberConfig.instance.getDefaultCurrencyType());
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTokuyakuhokenkikan12(), "", "特約保険期間１２");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTokuyakuharaikomikikan12(), "", "特約払込期間１２");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTknm13(), "", "特約名称１３");
        exBizCalcbleEquals(webKykNaiyouSyoukaiInfoBean.getTks13(), BizCurrency.optional(), "特約保険金額１３");
        Assert.assertEquals(webKykNaiyouSyoukaiInfoBean.getTks13().getType()
            , BizNumberConfig.instance.getDefaultCurrencyType());
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTokuyakuhokenkikan13(), "", "特約保険期間１３");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTokuyakuharaikomikikan13(), "", "特約払込期間１３");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTknm14(), "", "特約名称１４");
        exBizCalcbleEquals(webKykNaiyouSyoukaiInfoBean.getTks14(), BizCurrency.optional(), "特約保険金額１４");
        Assert.assertEquals(webKykNaiyouSyoukaiInfoBean.getTks14().getType()
            , BizNumberConfig.instance.getDefaultCurrencyType());
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTokuyakuhokenkikan14(), "", "特約保険期間１４");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTokuyakuharaikomikikan14(), "", "特約払込期間１４");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTknm15(), "", "特約名称１５");
        exBizCalcbleEquals(webKykNaiyouSyoukaiInfoBean.getTks15(), BizCurrency.optional(), "特約保険金額１５");
        Assert.assertEquals(webKykNaiyouSyoukaiInfoBean.getTks15().getType()
            , BizNumberConfig.instance.getDefaultCurrencyType());
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTokuyakuhokenkikan15(), "", "特約保険期間１５");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTokuyakuharaikomikikan15(), "", "特約払込期間１５");
        exNumericEquals(webKykNaiyouSyoukaiInfoBean.getSyouhnNaiyouGyousuu(), 1, "商品内容行数");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getSyouhnNaiyou1()
            , "現在の保障内容は下記のとおりです。", "商品内容１");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getSyouhnNaiyou2(), "", "商品内容２");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getSyouhnNaiyou3(), "", "商品内容３");
        exNumericEquals(webKykNaiyouSyoukaiInfoBean.getHosyouNaiyouGyousuu(), 22, "保障内容行数");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHosyouNaiyou1(), "死亡時支払金受取人　契約者　様", "保障内容１");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHosyouNaiyou2(), "年金受取人　　　　　契約者　様", "保障内容２");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHosyouNaiyou3(), "指定代理請求人　　　指定特定名義１－１４　様　　　　　　　　　　生年月日　平成１３年　１月　１日", "保障内容３");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHosyouNaiyou4(), "死亡時", "保障内容４");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHosyouNaiyou5(), "（保険料の払込回数に応じて計算しております。）", "保障内容５");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHosyouNaiyou6(), "　第１保険期間（照会日時点）　　　　　　　　　　　１０，０００．００ユーロ", "保障内容６");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHosyouNaiyou7(), "　　　　　　　　　　　　　　　　　　　　　　　　　（１００円）", "保障内容７");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHosyouNaiyou8(), "　第２保険期間（契約日から１０年経過時点）※", "保障内容８");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHosyouNaiyou9(),"　※第２保険期間中は、基本保険金額と解約返戻金額のうちいずれか大きい金額でお支払いします。", "保障内容９");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHosyouNaiyou10(), "　第３保険期間（契約日から１５年経過時点）　　　　１０，０００．００ユーロ", "保障内容１０");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHosyouNaiyou11(), "　　　　　　　　　　　　　　　　　　　　　　　　　（１００円）", "保障内容１１");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHosyouNaiyou12(), "解約返戻金額（照会日時点）　１，０００．００ユーロ　　（１００円）", "保障内容１２");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHosyouNaiyou13(),"積立金額（照会日時点）　１，０００．００ユーロ　　（１００円）", "保障内容１３");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHosyouNaiyou14(),"上記（）内の金額は、照会時点の為替レートで円換算した参考値であり変動します。", "保障内容１４");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHosyouNaiyou15(),"年金開始日　　　　　　　　平成２８年　２月２９日","保障内容１５");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHosyouNaiyou16(),"保険法対応契約", "保障内容１６");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHosyouNaiyou17(),"重度介護前払特約あり","保障内容１７");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHosyouNaiyou18(),"保険料円貨払込特約あり　　　　　加入時保険料入金額　　　１，２３０円", "保障内容１８");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHosyouNaiyou19(),"　保険料領収日時点の払込特約レート　１ユーロ＝１円（平成２９年　７月　１日）", "保障内容１９");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHosyouNaiyou20(),"初期死亡時円換算支払額最低保証特約あり","保障内容２０");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHosyouNaiyou21(), "指定代理請求特約あり", "保障内容２１");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHosyouNaiyou22(), "目標到達時円建終身保険変更特約あり　　　　　（目標額割合　指定なし）", "保障内容２２");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHosyouNaiyou23(), "", "保障内容２３");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHosyouNaiyou24(), "", "保障内容２４");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHosyouNaiyou25(), "", "保障内容２５");
        exNumericEquals(webKykNaiyouSyoukaiInfoBean.getHenkouKeiiGyousuu(), 10, "変更経緯行数");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHenkouKeii1(), "平成２７年１２月　１日　契約内容変更", "変更経緯１");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHenkouKeii2(), "平成２７年１２月　１日　契約内容変更", "変更経緯２");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHenkouKeii3(), "平成２７年１２月　１日　契約内容変更", "変更経緯３");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHenkouKeii4(), "平成２７年１２月　１日　契約内容変更", "変更経緯４");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHenkouKeii5(), "平成２７年１２月　１日　契約内容変更", "変更経緯５");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHenkouKeii6(), "平成２７年１２月　１日　契約内容変更", "変更経緯６");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHenkouKeii7(), "平成２７年１２月　１日　契約内容変更", "変更経緯７");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHenkouKeii8(), "平成２７年１２月　１日　契約内容変更", "変更経緯８");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHenkouKeii9(), "平成２７年１２月　１日　契約内容変更", "変更経緯９");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHenkouKeii10(), "平成２７年１２月　１日　契約内容変更", "変更経緯１０");
        exNumericEquals(webKykNaiyouSyoukaiInfoBean.getBosyuDrtenGyousuu(), 2, "募集代理店行数");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getBosyuDrtenNm1(), "取扱代理店名３", "募集代理店名１");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getDrtenBnwari1(), "", "代理店分割割合１");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getBosyuDrtenNm2(), "取扱代理店名３", "募集代理店名２");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getDrtenBnwari2(), "", "代理店分割割合２");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getMsgOutKbn(), "2", "MSG出力区分");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHosyouIkkatuMinaokeiyakuHyouji(), "0", "保障一括見直契約表示");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHhknnmkn(), "ﾋﾎｹﾝｼｶﾅ", "被保険者氏名(ｶﾅ)");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHokenryouSyuunouJyoukyou(), "正常収納中", "保険料収納状況");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getJikaiHokenryouJyuutouYm(), "－", "次回保険料充当年月");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getMdhansybetuKbn(), "01", "窓販種別区分");

        exClassificationEquals((C_Tuukasyu) MockObjectManager.getArgument(KeisanGaikakanzanMockForHozen.class, "exec", 0, 0), C_Tuukasyu.JPY, "通貨種類");
        exBizCalcbleEquals((BizCurrency) MockObjectManager.getArgument(KeisanGaikakanzanMockForHozen.class, "exec", 0, 1), BizCurrency.valueOf(10000, BizCurrencyTypes.EURO), "金額");
        exBizCalcbleEquals((BizNumber) MockObjectManager.getArgument(KeisanGaikakanzanMockForHozen.class, "exec", 0, 2), BizNumber.valueOf(1), "レート");
        exClassificationEquals((C_HasuusyoriKbn) MockObjectManager.getArgument(KeisanGaikakanzanMockForHozen.class, "exec", 0, 3), C_HasuusyoriKbn.AGE, "端数処理区分");

    }

    @Test
    @TestOrder(270)
    public void testExec_A27() {
        changeSystemDate();

        MockObjectManager.initialize();
        BzGetProcessSummaryMockForHozen.SYORIPTN = BzGetProcessSummaryMockForHozen.TESTPATTERN2;
        BzGetAdrDataMockForHozen.SYORIPTN = BzGetAdrDataMockForHozen.TESTPATTERN1;
        CalcHkShrKngkMockForHozen.SYORIPTN = CalcHkShrKngkMockForHozen.TESTPATTERN4;
        KeisanWExtMockForHozen.SYORIPTN = KeisanWExtMockForHozen.TESTPATTERN2;
        KeisanWMockForHozen.SYORIPTN = KeisanWMockForHozen.TESTPATTERN1;
        KeisanKijyungkMockForHozen.SYORIPTN = KeisanKijyungkMockForHozen.TESTPATTERN2;
        KeisanGaikakanzanMockForHozen.SYORIPTN = KeisanGaikakanzanMockForHozen.TESTPATTERN1;
        SetNenreiMockForHozen.SYORIPTN = SetNenreiMockForHozen.TESTPATTERN1;
        HanteiKhSisuurendoTmttknJyoutaiMockForHozen.SYORIPTN = HanteiKhSisuurendoTmttknJyoutaiMockForHozen.TESTPATTERN2;

        WebKykNaiyouSyoukaiInfoBean webKykNaiyouSyoukaiInfoBean =
            hbKeiyakuSyoukai.exec("99809111301", BizDate.valueOf("20160621"), C_TanmatuSiyouKbn.SOUGOU_IPPAN, null);

        exStringEquals(webKykNaiyouSyoukaiInfoBean.getErrorKbn(), "", "エラー区分");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getErrorMsg(), "", "エラーメッセージ");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getKyknmkn(), "ｶﾅ", "契約者名（カナ）");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getKyknmkj(), "契約者名漢字１－１５　様", "契約者名（漢字）");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getKykseiymd(), "昭和５５年　１月　１日", "契約者生年月日");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getKojinhjnKbn(), "個人", "個人法人区分");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTelno(), "010-1234-5678", "電話番号");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getPostalCd(), "１２３－４５６７", "郵便番号");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getAdr(), "通信先住所１通信先住所２通信先住所３", "住所");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getAdrkn(), "ｶﾅｶﾅｶﾅｶﾅ", "住所(ｶﾅ)");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHhknnm(), "被保険者名　様", "被保険者氏名");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHhknsei(), "男性", "被保険者性別");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHhknseiymd(), "昭和５６年　１月　１日", "被保険者生年月日");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHhknNen(), "３５歳", "被保険者年齢");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHhknKykjiNen(), "２５歳", "被保険者契約時年齢");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getSyouhnnm(), "商品名略称商品名略称商品名略称　しんきんらいふ年金Ｓ　たのしみグローバル（定率増加プラン）", "商品名");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getSyurui(), "年金保険", "種類");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getSyono(), "99809111301", "証券番号");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getCifCd(), "*****", "CIFｺｰﾄﾞ");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getKykymd(), "平成２８年　６月２１日", "契約日");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHrkhou(), "前納中", "払込方法");
        exBizCalcbleEquals(webKykNaiyouSyoukaiInfoBean.getSibous()
            , BizCurrency.valueOf(10000.00, BizCurrencyTypes.AU_DOLLAR), "死亡保険金");
        Assert.assertEquals(webKykNaiyouSyoukaiInfoBean.getSibous().getType(), BizCurrencyTypes.AU_DOLLAR);
        exBizCalcbleEquals(webKykNaiyouSyoukaiInfoBean.getHrkp()
            , BizCurrency.valueOf(1001.00, BizCurrencyTypes.AU_DOLLAR), "払込保険料");
        Assert.assertEquals(webKykNaiyouSyoukaiInfoBean.getHrkp().getType(), BizCurrencyTypes.AU_DOLLAR);
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getNkShrStartYmd(), "平成２９年　１月　１日", "年金支払開始日");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getNenkinHosyouYear(), "終身", "年金保証年");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getNenkinKbn(), "終身年金", "年金区分");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHaitouKbn(), "準有配当", "配当区分");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getSinsaKbn(), "社医扱", "診査区分");
        exNumericEquals(webKykNaiyouSyoukaiInfoBean.getTksuu(), 2, "特約数");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getLivingneedsTkhyj(), "", "リビングニーズ特約表示");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHokenMankiDay(), "平成２８年１２月３１日", "保険満期日");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getSyunm(), "個人年金", "主契約名称");
        exBizCalcbleEquals(webKykNaiyouSyoukaiInfoBean.getSyus()
            , BizCurrency.optional(), "主契約保険金額");
        Assert.assertEquals(webKykNaiyouSyoukaiInfoBean.getSyus().getType()
            , BizNumberConfig.instance.getDefaultCurrencyType());
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getSyuhknkkn(), "　０年間", "主契約保険期間");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getSyuhrkkkn(), "", "主契約払込期間");
        exNumericEquals(webKykNaiyouSyoukaiInfoBean.getTkNaiyouGyousuu(), 2, "特約内容行数");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTknm1(), "目標到達時円建終身保険変更特約　指定なし", "特約名称１");
        exBizCalcbleEquals(webKykNaiyouSyoukaiInfoBean.getTks1(), BizCurrency.optional(), "特約保険金額１");
        Assert.assertEquals(webKykNaiyouSyoukaiInfoBean.getTks1().getType()
            , BizNumberConfig.instance.getDefaultCurrencyType());
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTokuyakuhokenkikan1(), "", "特約保険期間１");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTokuyakuharaikomikikan1(), "", "特約払込期間１");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTknm2(), "指定代理請求特約", "特約名称２");
        exBizCalcbleEquals(webKykNaiyouSyoukaiInfoBean.getTks2(), BizCurrency.optional(), "特約保険金額２");
        Assert.assertEquals(webKykNaiyouSyoukaiInfoBean.getTks2().getType()
            , BizNumberConfig.instance.getDefaultCurrencyType());
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTokuyakuhokenkikan2(), "", "特約保険期間２");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTokuyakuharaikomikikan2(), "", "特約払込期間２");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTknm3(), "", "特約名称３");
        exBizCalcbleEquals(webKykNaiyouSyoukaiInfoBean.getTks3(), BizCurrency.optional(), "特約保険金額３");
        Assert.assertEquals(webKykNaiyouSyoukaiInfoBean.getTks3().getType()
            , BizNumberConfig.instance.getDefaultCurrencyType());
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTokuyakuhokenkikan3(), "", "特約保険期間３");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTokuyakuharaikomikikan3(), "", "特約払込期間３");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTknm4(), "", "特約名称４");
        exBizCalcbleEquals(webKykNaiyouSyoukaiInfoBean.getTks4(), BizCurrency.optional(), "特約保険金額４");
        Assert.assertEquals(webKykNaiyouSyoukaiInfoBean.getTks4().getType()
            , BizNumberConfig.instance.getDefaultCurrencyType());
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTokuyakuhokenkikan4(), "", "特約保険期間４");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTokuyakuharaikomikikan4(), "", "特約払込期間４");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTknm5(), "", "特約名称５");
        exBizCalcbleEquals(webKykNaiyouSyoukaiInfoBean.getTks5(), BizCurrency.optional(), "特約保険金額５");
        Assert.assertEquals(webKykNaiyouSyoukaiInfoBean.getTks5().getType()
            , BizNumberConfig.instance.getDefaultCurrencyType());
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTokuyakuhokenkikan5(), "", "特約保険期間５");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTokuyakuharaikomikikan5(), "", "特約払込期間５");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTknm6(), "", "特約名称６");
        exBizCalcbleEquals(webKykNaiyouSyoukaiInfoBean.getTks6(), BizCurrency.optional(), "特約保険金額６");
        Assert.assertEquals(webKykNaiyouSyoukaiInfoBean.getTks6().getType()
            , BizNumberConfig.instance.getDefaultCurrencyType());
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTokuyakuhokenkikan6(), "", "特約保険期間６");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTokuyakuharaikomikikan6(), "", "特約払込期間６");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTknm7(), "", "特約名称７");
        exBizCalcbleEquals(webKykNaiyouSyoukaiInfoBean.getTks7(), BizCurrency.optional(), "特約保険金額７");
        Assert.assertEquals(webKykNaiyouSyoukaiInfoBean.getTks7().getType()
            , BizNumberConfig.instance.getDefaultCurrencyType());
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTokuyakuhokenkikan7(), "", "特約保険期間７");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTokuyakuharaikomikikan7(), "", "特約払込期間７");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTknm8(), "", "特約名称８");
        exBizCalcbleEquals(webKykNaiyouSyoukaiInfoBean.getTks8(), BizCurrency.optional(), "特約保険金額８");
        Assert.assertEquals(webKykNaiyouSyoukaiInfoBean.getTks8().getType()
            , BizNumberConfig.instance.getDefaultCurrencyType());
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTokuyakuhokenkikan8(), "", "特約保険期間８");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTokuyakuharaikomikikan8(), "", "特約払込期間８");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTknm9(), "", "特約名称９");
        exBizCalcbleEquals(webKykNaiyouSyoukaiInfoBean.getTks9(), BizCurrency.optional(), "特約保険金額９");
        Assert.assertEquals(webKykNaiyouSyoukaiInfoBean.getTks9().getType()
            , BizNumberConfig.instance.getDefaultCurrencyType());
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTokuyakuhokenkikan9(), "", "特約保険期間９");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTokuyakuharaikomikikan9(), "", "特約払込期間９");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTknm10(), "", "特約名称１０");
        exBizCalcbleEquals(webKykNaiyouSyoukaiInfoBean.getTks10(), BizCurrency.optional(), "特約保険金額１０");
        Assert.assertEquals(webKykNaiyouSyoukaiInfoBean.getTks10().getType()
            , BizNumberConfig.instance.getDefaultCurrencyType());
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTokuyakuhokenkikan10(), "", "特約保険期間１０");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTokuyakuharaikomikikan10(), "", "特約払込期間１０");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTknm11(), "", "特約名称１１");
        exBizCalcbleEquals(webKykNaiyouSyoukaiInfoBean.getTks11(), BizCurrency.optional(), "特約保険金額１１");
        Assert.assertEquals(webKykNaiyouSyoukaiInfoBean.getTks11().getType()
            , BizNumberConfig.instance.getDefaultCurrencyType());
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTokuyakuhokenkikan11(), "", "特約保険期間１１");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTokuyakuharaikomikikan11(), "", "特約払込期間１１");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTknm12(), "", "特約名称１２");
        exBizCalcbleEquals(webKykNaiyouSyoukaiInfoBean.getTks12(), BizCurrency.optional(), "特約保険金額１２");
        Assert.assertEquals(webKykNaiyouSyoukaiInfoBean.getTks12().getType()
            , BizNumberConfig.instance.getDefaultCurrencyType());
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTokuyakuhokenkikan12(), "", "特約保険期間１２");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTokuyakuharaikomikikan12(), "", "特約払込期間１２");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTknm13(), "", "特約名称１３");
        exBizCalcbleEquals(webKykNaiyouSyoukaiInfoBean.getTks13(), BizCurrency.optional(), "特約保険金額１３");
        Assert.assertEquals(webKykNaiyouSyoukaiInfoBean.getTks13().getType()
            , BizNumberConfig.instance.getDefaultCurrencyType());
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTokuyakuhokenkikan13(), "", "特約保険期間１３");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTokuyakuharaikomikikan13(), "", "特約払込期間１３");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTknm14(), "", "特約名称１４");
        exBizCalcbleEquals(webKykNaiyouSyoukaiInfoBean.getTks14(), BizCurrency.optional(), "特約保険金額１４");
        Assert.assertEquals(webKykNaiyouSyoukaiInfoBean.getTks14().getType()
            , BizNumberConfig.instance.getDefaultCurrencyType());
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTokuyakuhokenkikan14(), "", "特約保険期間１４");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTokuyakuharaikomikikan14(), "", "特約払込期間１４");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTknm15(), "", "特約名称１５");
        exBizCalcbleEquals(webKykNaiyouSyoukaiInfoBean.getTks15(), BizCurrency.optional(), "特約保険金額１５");
        Assert.assertEquals(webKykNaiyouSyoukaiInfoBean.getTks15().getType()
            , BizNumberConfig.instance.getDefaultCurrencyType());
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTokuyakuhokenkikan15(), "", "特約保険期間１５");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTokuyakuharaikomikikan15(), "", "特約払込期間１５");
        exNumericEquals(webKykNaiyouSyoukaiInfoBean.getSyouhnNaiyouGyousuu(), 1, "商品内容行数");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getSyouhnNaiyou1(), "現在の保障内容は下記のとおりです。", "商品内容１");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getSyouhnNaiyou2(), "", "商品内容２");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getSyouhnNaiyou3(), "", "商品内容３");
        exNumericEquals(webKykNaiyouSyoukaiInfoBean.getHosyouNaiyouGyousuu(), 13, "保障内容行数");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHosyouNaiyou1(), "死亡時支払金受取人　契約者　様", "保障内容１");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHosyouNaiyou2()
            , "年金受取人　　　　　契約者　様", "保障内容２");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHosyouNaiyou3()
            , "指定代理請求人　　　契約者名漢字１－１５　様　　　　　　　　　　生年月日　昭和５５年　１月　１日", "保障内容３");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHosyouNaiyou4()
            , "払込保険料の円換算額　　　　１１，０００円", "保障内容４");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHosyouNaiyou5()
            , "　保険料領収日時点の円換算為替レート　１豪ドル＝５０円（平成２９年　７月　１日）", "保障内容５");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHosyouNaiyou6()
            , "死亡時（照会日時点）　　　　１０，０００．００豪ドル　　（１０１円）", "保障内容６");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHosyouNaiyou7()
            , "（保険料の払込回数に応じて計算しております。）", "保障内容７");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHosyouNaiyou8()
            , "解約返戻金額（照会日時点）　１，０００．００豪ドル　　（１００円）", "保障内容８");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHosyouNaiyou9()
            , "積立金額（照会日時点）　１，０００．００豪ドル　　（１００円）", "保障内容９");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHosyouNaiyou10()
            , "上記（）内の金額は、照会時点の為替レートで円換算した参考値であり変動します。", "保障内容１０");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHosyouNaiyou11()
            , "年金開始日　　　　　　　　平成２９年　１月　１日", "保障内容１１");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHosyouNaiyou12()
            , "保険法対応契約", "保障内容１２");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHosyouNaiyou13()
            , "指定代理請求特約あり", "保障内容１３");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHosyouNaiyou14(), "", "保障内容１４");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHosyouNaiyou15(), "", "保障内容１５");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHosyouNaiyou16(), "", "保障内容１６");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHosyouNaiyou17(), "", "保障内容１７");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHosyouNaiyou18(), "", "保障内容１８");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHosyouNaiyou19(), "", "保障内容１９");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHosyouNaiyou20(), "", "保障内容２０");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHosyouNaiyou21(), "", "保障内容２１");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHosyouNaiyou22(), "", "保障内容２２");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHosyouNaiyou23(), "", "保障内容２３");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHosyouNaiyou24(), "", "保障内容２４");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHosyouNaiyou25(), "", "保障内容２５");
        exNumericEquals(webKykNaiyouSyoukaiInfoBean.getHenkouKeiiGyousuu(), 1, "変更経緯行数");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHenkouKeii1(), "＊＊＊＊＊", "変更経緯１");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHenkouKeii2(), "", "変更経緯２");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHenkouKeii3(), "", "変更経緯３");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHenkouKeii4(), "", "変更経緯４");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHenkouKeii5(), "", "変更経緯５");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHenkouKeii6(), "", "変更経緯６");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHenkouKeii7(), "", "変更経緯７");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHenkouKeii8(), "", "変更経緯８");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHenkouKeii9(), "", "変更経緯９");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHenkouKeii10(), "", "変更経緯１０");
        exNumericEquals(webKykNaiyouSyoukaiInfoBean.getBosyuDrtenGyousuu(), 1, "募集代理店行数");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getBosyuDrtenNm1(), "取扱代理店名３", "募集代理店名１");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getDrtenBnwari1(), "", "代理店分割割合１");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getBosyuDrtenNm2(), "", "募集代理店名２");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getDrtenBnwari2(), "", "代理店分割割合２");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getMsgOutKbn(), "2", "MSG出力区分");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHosyouIkkatuMinaokeiyakuHyouji(), "0", "保障一括見直契約表示");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHhknnmkn(), "ﾋﾎｹﾝｼｶﾅ", "被保険者氏名(ｶﾅ)");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHokenryouSyuunouJyoukyou(), "正常収納中", "保険料収納状況");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getJikaiHokenryouJyuutouYm(), "－", "次回保険料充当年月");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getMdhansybetuKbn(), "01", "窓販種別区分");

    }

    @Test
    @TestOrder(280)
    public void testExec_A28() {
        changeSystemDate();

        MockObjectManager.initialize();
        BzGetProcessSummaryMockForHozen.SYORIPTN = BzGetProcessSummaryMockForHozen.TESTPATTERN2;
        BzGetAdrDataMockForHozen.SYORIPTN = BzGetAdrDataMockForHozen.TESTPATTERN1;
        CalcHkShrKngkMockForHozen.SYORIPTN = CalcHkShrKngkMockForHozen.TESTPATTERN4;
        KeisanWExtMockForHozen.SYORIPTN = KeisanWExtMockForHozen.TESTPATTERN2;
        KeisanWMockForHozen.SYORIPTN = KeisanWMockForHozen.TESTPATTERN1;
        KeisanKijyungkMockForHozen.SYORIPTN = KeisanKijyungkMockForHozen.TESTPATTERN2;
        KeisanGaikakanzanMockForHozen.SYORIPTN = KeisanGaikakanzanMockForHozen.TESTPATTERN1;
        SetNenreiMockForHozen.SYORIPTN = SetNenreiMockForHozen.TESTPATTERN1;

        WebKykNaiyouSyoukaiInfoBean webKykNaiyouSyoukaiInfoBean =
            hbKeiyakuSyoukai.exec("99809111275", BizDate.valueOf("20200401"), C_TanmatuSiyouKbn.DAIRITENBOSYUUNIN, "100006");

        exStringEquals(webKykNaiyouSyoukaiInfoBean.getErrorKbn(), "", "エラー区分");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getErrorMsg(), "", "エラーメッセージ");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getKyknmkn(), "ｶﾅ", "契約者名（カナ）");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getKyknmkj(), "契約者名漢字１－１６　様", "契約者名（漢字）");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getKykseiymd(), "昭和５５年　１月　１日", "契約者生年月日");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getKojinhjnKbn(), "個人", "個人法人区分");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTelno(), "010-1234-5678", "電話番号");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getPostalCd(), "１２３－４５６７", "郵便番号");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getAdr(), "通信先住所１通信先住所２通信先住所３", "住所");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getAdrkn(), "ｶﾅｶﾅｶﾅｶﾅ", "住所(ｶﾅ)");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHhknnm(), "被保険者名　様", "被保険者氏名");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHhknsei(), "男性", "被保険者性別");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHhknseiymd(), "昭和５６年　１月　１日", "被保険者生年月日");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHhknNen(), "３５歳", "被保険者年齢");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHhknKykjiNen(), "２５歳", "被保険者契約時年齢");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getSyouhnnm(), "充実外貨（毎年受取型）", "商品名");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getSyurui(), "終身保険", "種類");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getSyono(), "99809111275", "証券番号");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getCifCd(), "*****", "CIFｺｰﾄﾞ");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getKykymd(), "平成２８年　６月２１日", "契約日");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHrkhou(), "前納中", "払込方法");
        exBizCalcbleEquals(webKykNaiyouSyoukaiInfoBean.getSibous()
            , BizCurrency.valueOf(10000.00, BizCurrencyTypes.AU_DOLLAR) , "死亡保険金");
        Assert.assertEquals(webKykNaiyouSyoukaiInfoBean.getSibous().getType(), BizCurrencyTypes.AU_DOLLAR);
        exBizCalcbleEquals(webKykNaiyouSyoukaiInfoBean.getHrkp()
            , BizCurrency.valueOf(1001.00, BizCurrencyTypes.DOLLAR), "払込保険料");
        Assert.assertEquals(webKykNaiyouSyoukaiInfoBean.getHrkp().getType(), BizCurrencyTypes.DOLLAR);
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getNkShrStartYmd(), "平成２９年　１月　１日", "年金支払開始日");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getNenkinHosyouYear(), "", "年金保証年");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getNenkinKbn(), "", "年金区分");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHaitouKbn(), "準有配当", "配当区分");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getSinsaKbn(), "社医扱", "診査区分");
        exNumericEquals(webKykNaiyouSyoukaiInfoBean.getTksuu(), 5, "特約数");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getLivingneedsTkhyj(), "", "リビングニーズ特約表示");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHokenMankiDay(), "終身", "保険満期日");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getSyunm(), "終身保険", "主契約名称");
        exBizCalcbleEquals(webKykNaiyouSyoukaiInfoBean.getSyus()
            , BizCurrency.optional(), "主契約保険金額");
        Assert.assertEquals(webKykNaiyouSyoukaiInfoBean.getSyus().getType(), BizNumberConfig.instance.getDefaultCurrencyType());
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getSyuhknkkn(), "終身", "主契約保険期間");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getSyuhrkkkn(), "", "主契約払込期間");
        exNumericEquals(webKykNaiyouSyoukaiInfoBean.getTkNaiyouGyousuu(), 5, "特約内容行数");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTknm1(), "重度介護前払特約", "特約名称１");
        exBizCalcbleEquals(webKykNaiyouSyoukaiInfoBean.getTks1(), BizCurrency.optional(), "特約保険金額１");
        Assert.assertEquals(webKykNaiyouSyoukaiInfoBean.getTks1().getType()
            , BizNumberConfig.instance.getDefaultCurrencyType());
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTokuyakuhokenkikan1(), "", "特約保険期間１");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTokuyakuharaikomikikan1(), "", "特約払込期間１");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTknm2(), "初期死亡時円換算支払額最低保証特約", "特約名称２");
        exBizCalcbleEquals(webKykNaiyouSyoukaiInfoBean.getTks2(), BizCurrency.optional(), "特約保険金額２");
        Assert.assertEquals(webKykNaiyouSyoukaiInfoBean.getTks2().getType()
            , BizNumberConfig.instance.getDefaultCurrencyType());
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTokuyakuhokenkikan2(), "", "特約保険期間２");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTokuyakuharaikomikikan2(), "", "特約払込期間２");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTknm3(), "保険料円貨払込特約（一時払い）", "特約名称３");
        exBizCalcbleEquals(webKykNaiyouSyoukaiInfoBean.getTks3(), BizCurrency.optional(), "特約保険金額３");
        Assert.assertEquals(webKykNaiyouSyoukaiInfoBean.getTks3().getType()
            , BizNumberConfig.instance.getDefaultCurrencyType());
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTokuyakuhokenkikan3(), "", "特約保険期間３");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTokuyakuharaikomikikan3(), "", "特約払込期間３");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTknm4(), "目標到達時円建終身保険変更特約　指定なし", "特約名称４");
        exBizCalcbleEquals(webKykNaiyouSyoukaiInfoBean.getTks4(), BizCurrency.optional(), "特約保険金額４");
        Assert.assertEquals(webKykNaiyouSyoukaiInfoBean.getTks4().getType()
            , BizNumberConfig.instance.getDefaultCurrencyType());
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTokuyakuhokenkikan4(), "", "特約保険期間４");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTokuyakuharaikomikikan4(), "", "特約払込期間４");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTknm5(), "被保険者代理特約", "特約名称５");
        exBizCalcbleEquals(webKykNaiyouSyoukaiInfoBean.getTks5(), BizCurrency.optional(), "特約保険金額５");
        Assert.assertEquals(webKykNaiyouSyoukaiInfoBean.getTks5().getType()
            , BizNumberConfig.instance.getDefaultCurrencyType());
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTokuyakuhokenkikan5(), "", "特約保険期間５");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTokuyakuharaikomikikan5(), "", "特約払込期間５");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTknm6(), "", "特約名称６");
        exBizCalcbleEquals(webKykNaiyouSyoukaiInfoBean.getTks6(), BizCurrency.optional(), "特約保険金額６");
        Assert.assertEquals(webKykNaiyouSyoukaiInfoBean.getTks6().getType()
            , BizNumberConfig.instance.getDefaultCurrencyType());
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTokuyakuhokenkikan6(), "", "特約保険期間６");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTokuyakuharaikomikikan6(), "", "特約払込期間６");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTknm7(), "", "特約名称７");
        exBizCalcbleEquals(webKykNaiyouSyoukaiInfoBean.getTks7(), BizCurrency.optional(), "特約保険金額７");
        Assert.assertEquals(webKykNaiyouSyoukaiInfoBean.getTks7().getType()
            , BizNumberConfig.instance.getDefaultCurrencyType());
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTokuyakuhokenkikan7(), "", "特約保険期間７");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTokuyakuharaikomikikan7(), "", "特約払込期間７");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTknm8(), "", "特約名称８");
        exBizCalcbleEquals(webKykNaiyouSyoukaiInfoBean.getTks8(), BizCurrency.optional(), "特約保険金額８");
        Assert.assertEquals(webKykNaiyouSyoukaiInfoBean.getTks8().getType()
            , BizNumberConfig.instance.getDefaultCurrencyType());
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTokuyakuhokenkikan8(), "", "特約保険期間８");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTokuyakuharaikomikikan8(), "", "特約払込期間８");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTknm9(), "", "特約名称９");
        exBizCalcbleEquals(webKykNaiyouSyoukaiInfoBean.getTks9(), BizCurrency.optional(), "特約保険金額９");
        Assert.assertEquals(webKykNaiyouSyoukaiInfoBean.getTks9().getType()
            , BizNumberConfig.instance.getDefaultCurrencyType());
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTokuyakuhokenkikan9(), "", "特約保険期間９");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTokuyakuharaikomikikan9(), "", "特約払込期間９");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTknm10(), "", "特約名称１０");
        exBizCalcbleEquals(webKykNaiyouSyoukaiInfoBean.getTks10(), BizCurrency.optional(), "特約保険金額１０");
        Assert.assertEquals(webKykNaiyouSyoukaiInfoBean.getTks10().getType()
            , BizNumberConfig.instance.getDefaultCurrencyType());
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTokuyakuhokenkikan10(), "", "特約保険期間１０");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTokuyakuharaikomikikan10(), "", "特約払込期間１０");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTknm11(), "", "特約名称１１");
        exBizCalcbleEquals(webKykNaiyouSyoukaiInfoBean.getTks11(), BizCurrency.optional(), "特約保険金額１１");
        Assert.assertEquals(webKykNaiyouSyoukaiInfoBean.getTks11().getType()
            , BizNumberConfig.instance.getDefaultCurrencyType());
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTokuyakuhokenkikan11(), "", "特約保険期間１１");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTokuyakuharaikomikikan11(), "", "特約払込期間１１");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTknm12(), "", "特約名称１２");
        exBizCalcbleEquals(webKykNaiyouSyoukaiInfoBean.getTks12(), BizCurrency.optional(), "特約保険金額１２");
        Assert.assertEquals(webKykNaiyouSyoukaiInfoBean.getTks12().getType()
            , BizNumberConfig.instance.getDefaultCurrencyType());
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTokuyakuhokenkikan12(), "", "特約保険期間１２");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTokuyakuharaikomikikan12(), "", "特約払込期間１２");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTknm13(), "", "特約名称１３");
        exBizCalcbleEquals(webKykNaiyouSyoukaiInfoBean.getTks13(), BizCurrency.optional(), "特約保険金額１３");
        Assert.assertEquals(webKykNaiyouSyoukaiInfoBean.getTks13().getType()
            , BizNumberConfig.instance.getDefaultCurrencyType());
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTokuyakuhokenkikan13(), "", "特約保険期間１３");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTokuyakuharaikomikikan13(), "", "特約払込期間１３");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTknm14(), "", "特約名称１４");
        exBizCalcbleEquals(webKykNaiyouSyoukaiInfoBean.getTks14(), BizCurrency.optional(), "特約保険金額１４");
        Assert.assertEquals(webKykNaiyouSyoukaiInfoBean.getTks14().getType()
            , BizNumberConfig.instance.getDefaultCurrencyType());
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTokuyakuhokenkikan14(), "", "特約保険期間１４");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTokuyakuharaikomikikan14(), "", "特約払込期間１４");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTknm15(), "", "特約名称１５");
        exBizCalcbleEquals(webKykNaiyouSyoukaiInfoBean.getTks15(), BizCurrency.optional(), "特約保険金額１５");
        Assert.assertEquals(webKykNaiyouSyoukaiInfoBean.getTks15().getType()
            , BizNumberConfig.instance.getDefaultCurrencyType());
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTokuyakuhokenkikan15(), "", "特約保険期間１５");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTokuyakuharaikomikikan15(), "", "特約払込期間１５");
        exNumericEquals(webKykNaiyouSyoukaiInfoBean.getSyouhnNaiyouGyousuu(), 1, "商品内容行数");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getSyouhnNaiyou1(), "現在の保障内容は下記のとおりです。", "商品内容１");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getSyouhnNaiyou2(), "", "商品内容２");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getSyouhnNaiyou3(), "", "商品内容３");
        exNumericEquals(webKykNaiyouSyoukaiInfoBean.getHosyouNaiyouGyousuu(), 22, "保障内容行数");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHosyouNaiyou1(), "死亡時支払金受取人　相続人　様", "保障内容１");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHosyouNaiyou2(), "年金受取人　　　　　契約者　様", "保障内容２");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHosyouNaiyou3(), "被保険者代理人　　　カナ　様　　　　　　　　　　　　　　　　　　生年月日　昭和５５年　１月　１日", "保障内容３");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHosyouNaiyou4(), "死亡時", "保障内容４");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHosyouNaiyou5(), "（保険料の払込回数に応じて計算しております。）", "保障内容５");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHosyouNaiyou6(), "　第１保険期間（照会日時点）　　　　　　　　　　　１０，０００．００米ドル", "保障内容６");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHosyouNaiyou7(), "　　　　　　　　　　　　　　　　　　　　　　　　　（１００円）", "保障内容７");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHosyouNaiyou8(), "　第２保険期間（契約日から１０年経過時点）※", "保障内容８");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHosyouNaiyou9(), "　※第２保険期間中は、基本保険金額と解約返戻金額のうちいずれか大きい金額でお支払いします。", "保障内容９");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHosyouNaiyou10(), "　第３保険期間（契約日から１５年経過時点）　　　　１０，０００．００米ドル", "保障内容１０");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHosyouNaiyou11(), "　　　　　　　　　　　　　　　　　　　　　　　　　（１００円）", "保障内容１１");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHosyouNaiyou12(), "解約返戻金額（照会日時点）　１，０００．００米ドル　　（１００円）", "保障内容１２");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHosyouNaiyou13(), "積立金額（照会日時点）　１，０００．００米ドル　　（１００円）", "保障内容１３");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHosyouNaiyou14(), "上記（）内の金額は、照会時点の為替レートで円換算した参考値であり変動します。", "保障内容１４");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHosyouNaiyou15(), "年金開始日　　　　　　　　平成２９年　１月　１日", "保障内容１５");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHosyouNaiyou16(), "保険法対応契約", "保障内容１６");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHosyouNaiyou17(), "重度介護前払特約あり", "保障内容１７");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHosyouNaiyou18(), "保険料円貨払込特約（一時払い）あり　　　　　加入時保険料入金額　　　１，２３０円", "保障内容１８");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHosyouNaiyou19(), "　保険料領収日時点の払込特約レート　１米ドル＝１円（平成２９年　７月　１日）", "保障内容１９");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHosyouNaiyou20(), "初期死亡時円換算支払額最低保証特約あり", "保障内容２０");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHosyouNaiyou21(), "被保険者代理特約あり", "保障内容２１");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHosyouNaiyou22(), "目標到達時円建終身保険変更特約あり　　　　　（目標額割合　指定なし）", "保障内容２２");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHosyouNaiyou23(), "", "保障内容２３");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHosyouNaiyou24(), "", "保障内容２４");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHosyouNaiyou25(), "", "保障内容２５");
        exNumericEquals(webKykNaiyouSyoukaiInfoBean.getHenkouKeiiGyousuu(), 10, "変更経緯行数");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHenkouKeii1(), "平成２７年１２月　１日　契約内容変更", "変更経緯１");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHenkouKeii2(), "平成２７年１２月　１日　住所変更", "変更経緯２");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHenkouKeii3(), "平成２７年１２月　１日　契約内容変更", "変更経緯３");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHenkouKeii4(), "平成２７年１２月　１日　住所変更", "変更経緯４");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHenkouKeii5(), "平成２７年１２月　１日　契約内容変更", "変更経緯５");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHenkouKeii6(), "平成２７年１２月　１日　住所変更", "変更経緯６");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHenkouKeii7(), "平成２７年１２月　１日　契約内容変更", "変更経緯７");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHenkouKeii8(), "平成２７年１２月　１日　住所変更", "変更経緯８");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHenkouKeii9(), "平成２７年１２月　１日　契約内容変更", "変更経緯９");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHenkouKeii10(), "平成２７年１２月　１日　住所変更", "変更経緯１０");
        exNumericEquals(webKykNaiyouSyoukaiInfoBean.getBosyuDrtenGyousuu(), 2, "募集代理店行数");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getBosyuDrtenNm1(), "取扱代理店名３", "募集代理店名１");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getDrtenBnwari1(), "", "代理店分割割合１");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getBosyuDrtenNm2(), "取扱代理店名３", "募集代理店名２");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getDrtenBnwari2(), "", "代理店分割割合２");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getMsgOutKbn(), "2", "MSG出力区分");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHosyouIkkatuMinaokeiyakuHyouji(), "0", "保障一括見直契約表示");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHhknnmkn(), "ﾋﾎｹﾝｼｶﾅ", "被保険者氏名(ｶﾅ)");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHokenryouSyuunouJyoukyou(), "正常収納中", "保険料収納状況");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getJikaiHokenryouJyuutouYm(), "－", "次回保険料充当年月");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getMdhansybetuKbn(), "01", "窓販種別区分");
    }

    @Test
    @TestOrder(290)
    public void testExec_A29() {
        changeSystemDate();

        MockObjectManager.initialize();
        BzGetProcessSummaryMockForHozen.SYORIPTN = BzGetProcessSummaryMockForHozen.TESTPATTERN2;
        BzGetAdrDataMockForHozen.SYORIPTN = BzGetAdrDataMockForHozen.TESTPATTERN1;
        CalcHkShrKngkMockForHozen.SYORIPTN = CalcHkShrKngkMockForHozen.TESTPATTERN4;
        KeisanWExtMockForHozen.SYORIPTN = KeisanWExtMockForHozen.TESTPATTERN2;
        KeisanWMockForHozen.SYORIPTN = KeisanWMockForHozen.TESTPATTERN1;
        KeisanKijyungkMockForHozen.SYORIPTN = KeisanKijyungkMockForHozen.TESTPATTERN2;
        KeisanGaikakanzanMockForHozen.SYORIPTN = KeisanGaikakanzanMockForHozen.TESTPATTERN1;
        SetNenreiMockForHozen.SYORIPTN = SetNenreiMockForHozen.TESTPATTERN1;

        WebKykNaiyouSyoukaiInfoBean webKykNaiyouSyoukaiInfoBean =
            hbKeiyakuSyoukai.exec("99809111390", BizDate.valueOf("20160621"), C_TanmatuSiyouKbn.DAIRITENBOSYUUNIN, "100006");

        exStringEquals(webKykNaiyouSyoukaiInfoBean.getErrorKbn(), "", "エラー区分");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getErrorMsg(), "", "エラーメッセージ");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getKyknmkn(), "ｶﾅ", "契約者名（カナ）");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getKyknmkj(), "契約者名漢字１－１７　様", "契約者名（漢字）");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getKykseiymd(), "昭和５５年　１月　１日", "契約者生年月日");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getKojinhjnKbn(), "個人", "個人法人区分");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTelno(), "010-1234-5678", "電話番号");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getPostalCd(), "１２３－４５６７", "郵便番号");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getAdr(), "通信先住所１通信先住所２通信先住所３", "住所");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getAdrkn(), "ｶﾅｶﾅｶﾅｶﾅ", "住所(ｶﾅ)");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHhknnm(), "被保険者名　様", "被保険者氏名");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHhknsei(), "男性", "被保険者性別");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHhknseiymd(), "昭和５６年　１月　１日", "被保険者生年月日");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHhknNen(), "３５歳", "被保険者年齢");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHhknKykjiNen(), "２５歳", "被保険者契約時年齢");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getSyouhnnm(), "笑顔の約束", "商品名");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getSyurui(), "終身保険", "種類");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getSyono(), "99809111390", "証券番号");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getCifCd(), "*****", "CIFｺｰﾄﾞ");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getKykymd(), "平成２８年　６月２１日", "契約日");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHrkhou(), "一時払", "払込方法");
        exBizCalcbleEquals(webKykNaiyouSyoukaiInfoBean.getSibous()
            , BizCurrency.valueOf(10000.00, BizCurrencyTypes.AU_DOLLAR) , "死亡保険金");
        Assert.assertEquals(webKykNaiyouSyoukaiInfoBean.getSibous().getType(), BizCurrencyTypes.AU_DOLLAR);
        exBizCalcbleEquals(webKykNaiyouSyoukaiInfoBean.getHrkp()
            , BizCurrency.valueOf(1001.00, BizCurrencyTypes.DOLLAR), "払込保険料");
        Assert.assertEquals(webKykNaiyouSyoukaiInfoBean.getHrkp().getType(), BizCurrencyTypes.DOLLAR);
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getNkShrStartYmd(), "平成２９年　１月　１日", "年金支払開始日");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getNenkinHosyouYear(), "", "年金保証年");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getNenkinKbn(), "", "年金区分");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHaitouKbn(), "準有配当", "配当区分");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getSinsaKbn(), "健康証明書扱、準人間ドック扱", "診査区分");
        exNumericEquals(webKykNaiyouSyoukaiInfoBean.getTksuu(), 5, "特約数");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getLivingneedsTkhyj(), "", "リビングニーズ特約表示");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHokenMankiDay(), "終身", "保険満期日");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getSyunm(), "終身保険", "主契約名称");
        exBizCalcbleEquals(webKykNaiyouSyoukaiInfoBean.getSyus()
            , BizCurrency.optional(), "主契約保険金額");
        Assert.assertEquals(webKykNaiyouSyoukaiInfoBean.getSyus().getType(), BizNumberConfig.instance.getDefaultCurrencyType());
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getSyuhknkkn(), "終身", "主契約保険期間");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getSyuhrkkkn(), "", "主契約払込期間");
        exNumericEquals(webKykNaiyouSyoukaiInfoBean.getTkNaiyouGyousuu(), 5, "特約内容行数");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTknm1(), "重度介護前払特約", "特約名称１");
        exBizCalcbleEquals(webKykNaiyouSyoukaiInfoBean.getTks1(), BizCurrency.optional(), "特約保険金額１");
        Assert.assertEquals(webKykNaiyouSyoukaiInfoBean.getTks1().getType()
            , BizNumberConfig.instance.getDefaultCurrencyType());
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTokuyakuhokenkikan1(), "", "特約保険期間１");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTokuyakuharaikomikikan1(), "", "特約払込期間１");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTknm2(), "初期死亡時円換算支払額最低保証特約", "特約名称２");
        exBizCalcbleEquals(webKykNaiyouSyoukaiInfoBean.getTks2(), BizCurrency.optional(), "特約保険金額２");
        Assert.assertEquals(webKykNaiyouSyoukaiInfoBean.getTks2().getType()
            , BizNumberConfig.instance.getDefaultCurrencyType());
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTokuyakuhokenkikan2(), "", "特約保険期間２");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTokuyakuharaikomikikan2(), "", "特約払込期間２");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTknm3(), "保険料指定外通貨払込特約", "特約名称３");
        exBizCalcbleEquals(webKykNaiyouSyoukaiInfoBean.getTks3(), BizCurrency.optional(), "特約保険金額３");
        Assert.assertEquals(webKykNaiyouSyoukaiInfoBean.getTks3().getType()
            , BizNumberConfig.instance.getDefaultCurrencyType());
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTokuyakuhokenkikan3(), "", "特約保険期間３");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTokuyakuharaikomikikan3(), "", "特約払込期間３");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTknm4(), "目標到達時円建終身保険変更特約　１％", "特約名称４");
        exBizCalcbleEquals(webKykNaiyouSyoukaiInfoBean.getTks4(), BizCurrency.optional(), "特約保険金額４");
        Assert.assertEquals(webKykNaiyouSyoukaiInfoBean.getTks4().getType()
            , BizNumberConfig.instance.getDefaultCurrencyType());
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTokuyakuhokenkikan4(), "", "特約保険期間４");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTokuyakuharaikomikikan4(), "", "特約払込期間４");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTknm5(), "指定代理請求特約", "特約名称５");
        exBizCalcbleEquals(webKykNaiyouSyoukaiInfoBean.getTks5(), BizCurrency.optional(), "特約保険金額５");
        Assert.assertEquals(webKykNaiyouSyoukaiInfoBean.getTks5().getType()
            , BizNumberConfig.instance.getDefaultCurrencyType());
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTokuyakuhokenkikan5(), "", "特約保険期間５");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTokuyakuharaikomikikan5(), "", "特約払込期間５");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTknm6(), "", "特約名称６");
        exBizCalcbleEquals(webKykNaiyouSyoukaiInfoBean.getTks6(), BizCurrency.optional(), "特約保険金額６");
        Assert.assertEquals(webKykNaiyouSyoukaiInfoBean.getTks6().getType()
            , BizNumberConfig.instance.getDefaultCurrencyType());
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTokuyakuhokenkikan6(), "", "特約保険期間６");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTokuyakuharaikomikikan6(), "", "特約払込期間６");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTknm7(), "", "特約名称７");
        exBizCalcbleEquals(webKykNaiyouSyoukaiInfoBean.getTks7(), BizCurrency.optional(), "特約保険金額７");
        Assert.assertEquals(webKykNaiyouSyoukaiInfoBean.getTks7().getType()
            , BizNumberConfig.instance.getDefaultCurrencyType());
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTokuyakuhokenkikan7(), "", "特約保険期間７");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTokuyakuharaikomikikan7(), "", "特約払込期間７");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTknm8(), "", "特約名称８");
        exBizCalcbleEquals(webKykNaiyouSyoukaiInfoBean.getTks8(), BizCurrency.optional(), "特約保険金額８");
        Assert.assertEquals(webKykNaiyouSyoukaiInfoBean.getTks8().getType()
            , BizNumberConfig.instance.getDefaultCurrencyType());
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTokuyakuhokenkikan8(), "", "特約保険期間８");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTokuyakuharaikomikikan8(), "", "特約払込期間８");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTknm9(), "", "特約名称９");
        exBizCalcbleEquals(webKykNaiyouSyoukaiInfoBean.getTks9(), BizCurrency.optional(), "特約保険金額９");
        Assert.assertEquals(webKykNaiyouSyoukaiInfoBean.getTks9().getType()
            , BizNumberConfig.instance.getDefaultCurrencyType());
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTokuyakuhokenkikan9(), "", "特約保険期間９");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTokuyakuharaikomikikan9(), "", "特約払込期間９");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTknm10(), "", "特約名称１０");
        exBizCalcbleEquals(webKykNaiyouSyoukaiInfoBean.getTks10(), BizCurrency.optional(), "特約保険金額１０");
        Assert.assertEquals(webKykNaiyouSyoukaiInfoBean.getTks10().getType()
            , BizNumberConfig.instance.getDefaultCurrencyType());
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTokuyakuhokenkikan10(), "", "特約保険期間１０");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTokuyakuharaikomikikan10(), "", "特約払込期間１０");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTknm11(), "", "特約名称１１");
        exBizCalcbleEquals(webKykNaiyouSyoukaiInfoBean.getTks11(), BizCurrency.optional(), "特約保険金額１１");
        Assert.assertEquals(webKykNaiyouSyoukaiInfoBean.getTks11().getType()
            , BizNumberConfig.instance.getDefaultCurrencyType());
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTokuyakuhokenkikan11(), "", "特約保険期間１１");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTokuyakuharaikomikikan11(), "", "特約払込期間１１");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTknm12(), "", "特約名称１２");
        exBizCalcbleEquals(webKykNaiyouSyoukaiInfoBean.getTks12(), BizCurrency.optional(), "特約保険金額１２");
        Assert.assertEquals(webKykNaiyouSyoukaiInfoBean.getTks12().getType()
            , BizNumberConfig.instance.getDefaultCurrencyType());
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTokuyakuhokenkikan12(), "", "特約保険期間１２");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTokuyakuharaikomikikan12(), "", "特約払込期間１２");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTknm13(), "", "特約名称１３");
        exBizCalcbleEquals(webKykNaiyouSyoukaiInfoBean.getTks13(), BizCurrency.optional(), "特約保険金額１３");
        Assert.assertEquals(webKykNaiyouSyoukaiInfoBean.getTks13().getType()
            , BizNumberConfig.instance.getDefaultCurrencyType());
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTokuyakuhokenkikan13(), "", "特約保険期間１３");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTokuyakuharaikomikikan13(), "", "特約払込期間１３");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTknm14(), "", "特約名称１４");
        exBizCalcbleEquals(webKykNaiyouSyoukaiInfoBean.getTks14(), BizCurrency.optional(), "特約保険金額１４");
        Assert.assertEquals(webKykNaiyouSyoukaiInfoBean.getTks14().getType()
            , BizNumberConfig.instance.getDefaultCurrencyType());
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTokuyakuhokenkikan14(), "", "特約保険期間１４");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTokuyakuharaikomikikan14(), "", "特約払込期間１４");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTknm15(), "", "特約名称１５");
        exBizCalcbleEquals(webKykNaiyouSyoukaiInfoBean.getTks15(), BizCurrency.optional(), "特約保険金額１５");
        Assert.assertEquals(webKykNaiyouSyoukaiInfoBean.getTks15().getType()
            , BizNumberConfig.instance.getDefaultCurrencyType());
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTokuyakuhokenkikan15(), "", "特約保険期間１５");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTokuyakuharaikomikikan15(), "", "特約払込期間１５");
        exNumericEquals(webKykNaiyouSyoukaiInfoBean.getSyouhnNaiyouGyousuu(), 1, "商品内容行数");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getSyouhnNaiyou1(), "現在の保障内容は下記のとおりです。", "商品内容１");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getSyouhnNaiyou2(), "", "商品内容２");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getSyouhnNaiyou3(), "", "商品内容３");
        exNumericEquals(webKykNaiyouSyoukaiInfoBean.getHosyouNaiyouGyousuu(), 24, "保障内容行数");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHosyouNaiyou1(), "死亡時支払金受取人　トクテイメイギ１－１７　様", "保障内容１");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHosyouNaiyou2(), "年金受取人　　　　　契約者　様", "保障内容２");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHosyouNaiyou3(), "指定代理請求人　　　トクテイメイギ１－１７　様　　　　　　　　　生年月日　平成１３年　１月　１日", "保障内容３");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHosyouNaiyou4(), "登録家族（１人目）　家族名１　１－１７　様　　　　　　　　　　　生年月日　昭和６３年　１月　１日", "保障内容４");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHosyouNaiyou5(), "登録家族（２人目）　家族名２　１－１７　様　　　　　　　　　　　生年月日　平成１０年　１月　１日", "保障内容５");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHosyouNaiyou6(), "定率増加部分繰り入れ割合　１００％", "保障内容６");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHosyouNaiyou7(), "払込保険料の円換算額　　　　１１，０００円", "保障内容７");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHosyouNaiyou8(), "　保険料領収日時点の円換算為替レート　１豪ドル＝５０円（平成２９年　７月　１日）", "保障内容８");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHosyouNaiyou9(), "死亡時" , "保障内容９");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHosyouNaiyou10(), "　第１保険期間（照会日時点）　　　　　　　　　　　１０，０００．００豪ドル", "保障内容１０");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHosyouNaiyou11(), "　　　　　　　　　　　　　　　　　　　　　　　　　（１０１円）", "保障内容１１");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHosyouNaiyou12(), "　第２保険期間（契約日から１０年経過以後）※　　　　１，００２．００豪ドル", "保障内容１２");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHosyouNaiyou13(), "　　　　　　　　　　　　　　　　　　　　　　　　　（１００円）", "保障内容１３");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHosyouNaiyou14(), "　※第２保険期間中は、基本保険金額と解約返戻金額のうちいずれか大きい金額でお支払いします。", "保障内容１４");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHosyouNaiyou15(), "解約返戻金額（照会日時点）　１，０００．００豪ドル　　（１００円）", "保障内容１５");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHosyouNaiyou16(), "積立金額（照会日時点）　１，０００．００豪ドル　　（１００円）", "保障内容１６");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHosyouNaiyou17(), "上記（）内の金額は、照会時点の為替レートで円換算した参考値であり変動します。", "保障内容１７");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHosyouNaiyou18(), "保険法対応契約", "保障内容１８");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHosyouNaiyou19(), "重度介護前払特約あり", "保障内容１９");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHosyouNaiyou20(), "保険料指定外通貨払込特約あり　　加入時保険料入金額　　１，２３０．００米ドル", "保障内容２０");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHosyouNaiyou21(), "　保険料領収日時点の払込特約レート　１豪ドル＝１米ドル（平成２９年　７月　１日）", "保障内容２１");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHosyouNaiyou22(), "初期死亡時円換算支払額最低保証特約あり", "保障内容２２");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHosyouNaiyou23(), "指定代理請求特約あり", "保障内容２３");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHosyouNaiyou24(), "目標到達時円建終身保険変更特約あり　　　　　（目標額割合　１％）", "保障内容２４");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHosyouNaiyou25(), "", "保障内容２５");
        exNumericEquals(webKykNaiyouSyoukaiInfoBean.getHenkouKeiiGyousuu(), 2, "変更経緯行数");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHenkouKeii1(), "平成２７年１２月　１日　契約内容変更", "変更経緯１");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHenkouKeii2(), "平成２７年１２月　１日　契約内容変更", "変更経緯２");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHenkouKeii3(), "", "変更経緯３");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHenkouKeii4(), "", "変更経緯４");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHenkouKeii5(), "", "変更経緯５");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHenkouKeii6(), "", "変更経緯６");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHenkouKeii7(), "", "変更経緯７");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHenkouKeii8(), "", "変更経緯８");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHenkouKeii9(), "", "変更経緯９");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHenkouKeii10(), "", "変更経緯１０");
        exNumericEquals(webKykNaiyouSyoukaiInfoBean.getBosyuDrtenGyousuu(), 2, "募集代理店行数");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getBosyuDrtenNm1(), "取扱代理店名３", "募集代理店名１");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getDrtenBnwari1(), "", "代理店分割割合１");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getBosyuDrtenNm2(), "取扱代理店名３", "募集代理店名２");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getDrtenBnwari2(), "", "代理店分割割合２");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getMsgOutKbn(), "2", "MSG出力区分");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHosyouIkkatuMinaokeiyakuHyouji(), "0", "保障一括見直契約表示");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHhknnmkn(), "ﾋﾎｹﾝｼｶﾅ", "被保険者氏名(ｶﾅ)");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHokenryouSyuunouJyoukyou(), "－", "保険料収納状況");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getJikaiHokenryouJyuutouYm(), "－", "次回保険料充当年月");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getMdhansybetuKbn(), "01", "窓販種別区分");
    }

    @Test
    @TestOrder(300)
    public void testExec_A30() {
        changeSystemDate();

        MockObjectManager.initialize();
        BzGetProcessSummaryMockForHozen.SYORIPTN = BzGetProcessSummaryMockForHozen.TESTPATTERN2;
        BzGetAdrDataMockForHozen.SYORIPTN = BzGetAdrDataMockForHozen.TESTPATTERN1;
        CalcHkShrKngkMockForHozen.SYORIPTN = CalcHkShrKngkMockForHozen.TESTPATTERN4;
        KeisanWExtMockForHozen.SYORIPTN = KeisanWExtMockForHozen.TESTPATTERN2;
        KeisanWMockForHozen.SYORIPTN = KeisanWMockForHozen.TESTPATTERN1;
        KeisanKijyungkMockForHozen.SYORIPTN = KeisanKijyungkMockForHozen.TESTPATTERN2;
        KeisanGaikakanzanMockForHozen.SYORIPTN = KeisanGaikakanzanMockForHozen.TESTPATTERN1;
        SetNenreiMockForHozen.SYORIPTN = SetNenreiMockForHozen.TESTPATTERN1;

        WebKykNaiyouSyoukaiInfoBean webKykNaiyouSyoukaiInfoBean =
            hbKeiyakuSyoukai.exec("31809111338", BizDate.valueOf("20160621"), C_TanmatuSiyouKbn.DAIRITENBOSYUUNIN, "100006");

        exStringEquals(webKykNaiyouSyoukaiInfoBean.getErrorKbn(), "", "エラー区分");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getErrorMsg(), "", "エラーメッセージ");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getKyknmkn(), "ｶﾅ", "契約者名（カナ）");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getKyknmkj(), "契約者名漢字１－１８　様", "契約者名（漢字）");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getKykseiymd(), "昭和５５年　１月　１日", "契約者生年月日");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getKojinhjnKbn(), "個人", "個人法人区分");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTelno(), "010-1234-5678", "電話番号");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getPostalCd(), "１２３－４５６７", "郵便番号");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getAdr(), "通信先住所１通信先住所２通信先住所３", "住所");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getAdrkn(), "ｶﾅｶﾅｶﾅｶﾅ", "住所(ｶﾅ)");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHhknnm(), "被保険者名　様", "被保険者氏名");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHhknsei(), "男性", "被保険者性別");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHhknseiymd(), "昭和５６年　１月　１日", "被保険者生年月日");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHhknNen(), "３５歳", "被保険者年齢");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHhknKykjiNen(), "２５歳", "被保険者契約時年齢");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getSyouhnnm(), "笑顔の約束", "商品名");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getSyurui(), "終身保険", "種類");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getSyono(), "31809111338", "証券番号");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getCifCd(), "*****", "CIFｺｰﾄﾞ");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getKykymd(), "平成２８年　６月２１日", "契約日");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHrkhou(), "前納中", "払込方法");
        exBizCalcbleEquals(webKykNaiyouSyoukaiInfoBean.getSibous()
            , BizCurrency.valueOf(10000.00, BizCurrencyTypes.AU_DOLLAR) , "死亡保険金");
        Assert.assertEquals(webKykNaiyouSyoukaiInfoBean.getSibous().getType(), BizCurrencyTypes.AU_DOLLAR);
        exBizCalcbleEquals(webKykNaiyouSyoukaiInfoBean.getHrkp()
            , BizCurrency.valueOf(1001.00, BizCurrencyTypes.DOLLAR), "払込保険料");
        Assert.assertEquals(webKykNaiyouSyoukaiInfoBean.getHrkp().getType(), BizCurrencyTypes.DOLLAR);
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getNkShrStartYmd(), "", "年金支払開始日");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getNenkinHosyouYear(), "", "年金保証年");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getNenkinKbn(), "", "年金区分");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHaitouKbn(), "準有配当", "配当区分");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getSinsaKbn(), "健康証明書扱、準人間ドック扱", "診査区分");
        exNumericEquals(webKykNaiyouSyoukaiInfoBean.getTksuu(), 6, "特約数");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getLivingneedsTkhyj(), "", "リビングニーズ特約表示");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHokenMankiDay(), "終身", "保険満期日");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getSyunm(), "終身保険", "主契約名称");
        exBizCalcbleEquals(webKykNaiyouSyoukaiInfoBean.getSyus()
            , BizCurrency.valueOf(1002.00, BizCurrencyTypes.DOLLAR), "主契約保険金額");
        Assert.assertEquals(webKykNaiyouSyoukaiInfoBean.getSyus().getType(), BizCurrencyTypes.DOLLAR);
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getSyuhknkkn(), "終身", "主契約保険期間");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getSyuhrkkkn(), "", "主契約払込期間");
        exNumericEquals(webKykNaiyouSyoukaiInfoBean.getTkNaiyouGyousuu(), 6, "特約内容行数");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTknm1(), "重度介護前払特約", "特約名称１");
        exBizCalcbleEquals(webKykNaiyouSyoukaiInfoBean.getTks1(), BizCurrency.optional(), "特約保険金額１");
        Assert.assertEquals(webKykNaiyouSyoukaiInfoBean.getTks1().getType()
            , BizNumberConfig.instance.getDefaultCurrencyType());
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTokuyakuhokenkikan1(), "", "特約保険期間１");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTokuyakuharaikomikikan1(), "", "特約払込期間１");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTknm2(), "初期死亡時円換算支払額最低保証特約", "特約名称２");
        exBizCalcbleEquals(webKykNaiyouSyoukaiInfoBean.getTks2(), BizCurrency.optional(), "特約保険金額２");
        Assert.assertEquals(webKykNaiyouSyoukaiInfoBean.getTks2().getType()
            , BizNumberConfig.instance.getDefaultCurrencyType());
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTokuyakuhokenkikan2(), "", "特約保険期間２");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTokuyakuharaikomikikan2(), "", "特約払込期間２");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTknm3(), "保険料円貨払込特約", "特約名称３");
        exBizCalcbleEquals(webKykNaiyouSyoukaiInfoBean.getTks3(), BizCurrency.optional(), "特約保険金額３");
        Assert.assertEquals(webKykNaiyouSyoukaiInfoBean.getTks3().getType()
            , BizNumberConfig.instance.getDefaultCurrencyType());
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTokuyakuhokenkikan3(), "", "特約保険期間３");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTokuyakuharaikomikikan3(), "", "特約払込期間３");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTknm4(), "保険料指定外通貨払込特約", "特約名称４");
        exBizCalcbleEquals(webKykNaiyouSyoukaiInfoBean.getTks4(), BizCurrency.optional(), "特約保険金額４");
        Assert.assertEquals(webKykNaiyouSyoukaiInfoBean.getTks4().getType()
            , BizNumberConfig.instance.getDefaultCurrencyType());
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTokuyakuhokenkikan4(), "", "特約保険期間４");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTokuyakuharaikomikikan4(), "", "特約払込期間４");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTknm5(), "目標到達時円建終身保険変更特約　１％", "特約名称５");
        exBizCalcbleEquals(webKykNaiyouSyoukaiInfoBean.getTks5(), BizCurrency.optional(), "特約保険金額５");
        Assert.assertEquals(webKykNaiyouSyoukaiInfoBean.getTks5().getType()
            , BizNumberConfig.instance.getDefaultCurrencyType());
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTokuyakuhokenkikan5(), "", "特約保険期間５");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTokuyakuharaikomikikan5(), "", "特約払込期間５");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTknm6(), "指定代理請求特約", "特約名称６");
        exBizCalcbleEquals(webKykNaiyouSyoukaiInfoBean.getTks6(), BizCurrency.optional(), "特約保険金額６");
        Assert.assertEquals(webKykNaiyouSyoukaiInfoBean.getTks6().getType()
            , BizNumberConfig.instance.getDefaultCurrencyType());
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTokuyakuhokenkikan6(), "", "特約保険期間６");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTokuyakuharaikomikikan6(), "", "特約払込期間６");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTknm7(), "", "特約名称７");
        exBizCalcbleEquals(webKykNaiyouSyoukaiInfoBean.getTks7(), BizCurrency.optional(), "特約保険金額７");
        Assert.assertEquals(webKykNaiyouSyoukaiInfoBean.getTks7().getType()
            , BizNumberConfig.instance.getDefaultCurrencyType());
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTokuyakuhokenkikan7(), "", "特約保険期間７");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTokuyakuharaikomikikan7(), "", "特約払込期間７");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTknm8(), "", "特約名称８");
        exBizCalcbleEquals(webKykNaiyouSyoukaiInfoBean.getTks8(), BizCurrency.optional(), "特約保険金額８");
        Assert.assertEquals(webKykNaiyouSyoukaiInfoBean.getTks8().getType()
            , BizNumberConfig.instance.getDefaultCurrencyType());
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTokuyakuhokenkikan8(), "", "特約保険期間８");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTokuyakuharaikomikikan8(), "", "特約払込期間８");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTknm9(), "", "特約名称９");
        exBizCalcbleEquals(webKykNaiyouSyoukaiInfoBean.getTks9(), BizCurrency.optional(), "特約保険金額９");
        Assert.assertEquals(webKykNaiyouSyoukaiInfoBean.getTks9().getType()
            , BizNumberConfig.instance.getDefaultCurrencyType());
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTokuyakuhokenkikan9(), "", "特約保険期間９");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTokuyakuharaikomikikan9(), "", "特約払込期間９");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTknm10(), "", "特約名称１０");
        exBizCalcbleEquals(webKykNaiyouSyoukaiInfoBean.getTks10(), BizCurrency.optional(), "特約保険金額１０");
        Assert.assertEquals(webKykNaiyouSyoukaiInfoBean.getTks10().getType()
            , BizNumberConfig.instance.getDefaultCurrencyType());
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTokuyakuhokenkikan10(), "", "特約保険期間１０");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTokuyakuharaikomikikan10(), "", "特約払込期間１０");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTknm11(), "", "特約名称１１");
        exBizCalcbleEquals(webKykNaiyouSyoukaiInfoBean.getTks11(), BizCurrency.optional(), "特約保険金額１１");
        Assert.assertEquals(webKykNaiyouSyoukaiInfoBean.getTks11().getType()
            , BizNumberConfig.instance.getDefaultCurrencyType());
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTokuyakuhokenkikan11(), "", "特約保険期間１１");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTokuyakuharaikomikikan11(), "", "特約払込期間１１");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTknm12(), "", "特約名称１２");
        exBizCalcbleEquals(webKykNaiyouSyoukaiInfoBean.getTks12(), BizCurrency.optional(), "特約保険金額１２");
        Assert.assertEquals(webKykNaiyouSyoukaiInfoBean.getTks12().getType()
            , BizNumberConfig.instance.getDefaultCurrencyType());
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTokuyakuhokenkikan12(), "", "特約保険期間１２");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTokuyakuharaikomikikan12(), "", "特約払込期間１２");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTknm13(), "", "特約名称１３");
        exBizCalcbleEquals(webKykNaiyouSyoukaiInfoBean.getTks13(), BizCurrency.optional(), "特約保険金額１３");
        Assert.assertEquals(webKykNaiyouSyoukaiInfoBean.getTks13().getType()
            , BizNumberConfig.instance.getDefaultCurrencyType());
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTokuyakuhokenkikan13(), "", "特約保険期間１３");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTokuyakuharaikomikikan13(), "", "特約払込期間１３");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTknm14(), "", "特約名称１４");
        exBizCalcbleEquals(webKykNaiyouSyoukaiInfoBean.getTks14(), BizCurrency.optional(), "特約保険金額１４");
        Assert.assertEquals(webKykNaiyouSyoukaiInfoBean.getTks14().getType()
            , BizNumberConfig.instance.getDefaultCurrencyType());
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTokuyakuhokenkikan14(), "", "特約保険期間１４");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTokuyakuharaikomikikan14(), "", "特約払込期間１４");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTknm15(), "", "特約名称１５");
        exBizCalcbleEquals(webKykNaiyouSyoukaiInfoBean.getTks15(), BizCurrency.optional(), "特約保険金額１５");
        Assert.assertEquals(webKykNaiyouSyoukaiInfoBean.getTks15().getType()
            , BizNumberConfig.instance.getDefaultCurrencyType());
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTokuyakuhokenkikan15(), "", "特約保険期間１５");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTokuyakuharaikomikikan15(), "", "特約払込期間１５");
        exNumericEquals(webKykNaiyouSyoukaiInfoBean.getSyouhnNaiyouGyousuu(), 1, "商品内容行数");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getSyouhnNaiyou1(), "現在の保障内容は下記のとおりです。", "商品内容１");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getSyouhnNaiyou2(), "", "商品内容２");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getSyouhnNaiyou3(), "", "商品内容３");
        exNumericEquals(webKykNaiyouSyoukaiInfoBean.getHosyouNaiyouGyousuu(), 22, "保障内容行数");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHosyouNaiyou1(), "死亡時支払金受取人　特定名義１－１８　様", "保障内容１");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHosyouNaiyou2(), "指定代理請求人　　　特定名義１－１８　様　　　　　　　　　　　　生年月日　平成１３年　１月　１日", "保障内容２");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHosyouNaiyou3(), "予定利率　１２５％", "保障内容３");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHosyouNaiyou4(), "死亡時", "保障内容４");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHosyouNaiyou5(), "　第１保険期間（照会日時点）　　　　　　　　　　　１０，０００．００米ドル", "保障内容５");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHosyouNaiyou6(), "　　　　　　　　　　　　　　　　　　　　　　　　　（１００円）", "保障内容６");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHosyouNaiyou7(), "　第２保険期間（契約日から１０年経過時点）※", "保障内容７");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHosyouNaiyou8(), "　※第２保険期間中は、基本保険金額と解約返戻金額のうちいずれか大きい金額でお支払いします。", "保障内容８");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHosyouNaiyou9(), "　第３保険期間（契約日から１５年経過時点）　　　　１０，０００．００米ドル", "保障内容９");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHosyouNaiyou10(), "　　　　　　　　　　　　　　　　　　　　　　　　　（１００円）", "保障内容１０");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHosyouNaiyou11(), "解約返戻金額（照会日時点）　１，０００．００米ドル　　（１００円）", "保障内容１１");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHosyouNaiyou12(), "積立金額（照会日時点）　１，０００．００米ドル　　（１００円）", "保障内容１２");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHosyouNaiyou13(), "上記（）内の金額は、照会時点の為替レートで円換算した参考値であり変動します。", "保障内容１３");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHosyouNaiyou14(), "保険法対応契約", "保障内容１４");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHosyouNaiyou15(), "重度介護前払特約あり", "保障内容１５");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHosyouNaiyou16(), "保険料円貨払込特約あり　　　　　加入時保険料入金額　　　１，２３０．００円", "保障内容１６");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHosyouNaiyou17(), "　保険料領収日時点の払込特約レート　１米ドル＝１円（平成２９年　７月　１日）", "保障内容１７");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHosyouNaiyou18(), "保険料指定外通貨払込特約あり　　加入時保険料入金額　　１，２３０．００ユーロ", "保障内容１８");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHosyouNaiyou19(), "　保険料領収日時点の払込特約レート　１米ドル＝１ユーロ（平成２９年　７月　１日）", "保障内容１９");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHosyouNaiyou20(), "初期死亡時円換算支払額最低保証特約あり", "保障内容２０");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHosyouNaiyou21(), "指定代理請求特約あり", "保障内容２１");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHosyouNaiyou22(), "目標到達時円建終身保険変更特約あり　　　　　（目標額割合　１％）", "保障内容２２");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHosyouNaiyou23(), "", "保障内容２３");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHosyouNaiyou24(), "", "保障内容２４");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHosyouNaiyou25(), "", "保障内容２５");
        exNumericEquals(webKykNaiyouSyoukaiInfoBean.getHenkouKeiiGyousuu(), 1, "変更経緯行数");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHenkouKeii1(), "＊＊＊＊＊", "変更経緯１");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHenkouKeii2(), "", "変更経緯２");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHenkouKeii3(), "", "変更経緯３");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHenkouKeii4(), "", "変更経緯４");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHenkouKeii5(), "", "変更経緯５");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHenkouKeii6(), "", "変更経緯６");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHenkouKeii7(), "", "変更経緯７");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHenkouKeii8(), "", "変更経緯８");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHenkouKeii9(), "", "変更経緯９");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHenkouKeii10(), "", "変更経緯１０");
        exNumericEquals(webKykNaiyouSyoukaiInfoBean.getBosyuDrtenGyousuu(), 2, "募集代理店行数");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getBosyuDrtenNm1(), "取扱代理店名３", "募集代理店名１");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getDrtenBnwari1(), "", "代理店分割割合１");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getBosyuDrtenNm2(), "取扱代理店名３", "募集代理店名２");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getDrtenBnwari2(), "", "代理店分割割合２");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getMsgOutKbn(), "2", "MSG出力区分");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHosyouIkkatuMinaokeiyakuHyouji(), "0", "保障一括見直契約表示");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHhknnmkn(), "ﾋﾎｹﾝｼｶﾅ", "被保険者氏名(ｶﾅ)");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHokenryouSyuunouJyoukyou(), "正常収納中", "保険料収納状況");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getJikaiHokenryouJyuutouYm(), "－", "次回保険料充当年月");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getMdhansybetuKbn(), "01", "窓販種別区分");
    }

    @Test
    @TestOrder(310)
    public void testExec_A31() {
        changeSystemDate();

        MockObjectManager.initialize();
        BzGetProcessSummaryMockForHozen.SYORIPTN = BzGetProcessSummaryMockForHozen.TESTPATTERN2;
        BzGetAdrDataMockForHozen.SYORIPTN = BzGetAdrDataMockForHozen.TESTPATTERN1;
        CalcHkShrKngkMockForHozen.SYORIPTN = CalcHkShrKngkMockForHozen.TESTPATTERN4;
        KeisanWExtMockForHozen.SYORIPTN = KeisanWExtMockForHozen.TESTPATTERN2;
        KeisanWMockForHozen.SYORIPTN = KeisanWMockForHozen.TESTPATTERN1;
        KeisanKijyungkMockForHozen.SYORIPTN = KeisanKijyungkMockForHozen.TESTPATTERN2;
        KeisanGaikakanzanMockForHozen.SYORIPTN = KeisanGaikakanzanMockForHozen.TESTPATTERN1;
        SetNenreiMockForHozen.SYORIPTN = SetNenreiMockForHozen.TESTPATTERN1;
        WebKykNaiyouSyoukaiInfoBean webKykNaiyouSyoukaiInfoBean =
            hbKeiyakuSyoukai.exec("31809111110", BizDate.valueOf("20160621"), C_TanmatuSiyouKbn.DAIRITENBOSYUUNIN, "100006");

        exStringEquals(webKykNaiyouSyoukaiInfoBean.getErrorKbn(), "", "エラー区分");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getErrorMsg(), "", "エラーメッセージ");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getKyknmkn(), "ｶﾅ", "契約者名（カナ）");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getKyknmkj(), "契約者名漢字１－１９　様", "契約者名（漢字）");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getKykseiymd(), "昭和５５年　１月　１日", "契約者生年月日");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getKojinhjnKbn(), "個人", "個人法人区分");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTelno(), "010-1234-5678", "電話番号");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getPostalCd(), "１２３－４５６７", "郵便番号");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getAdr(), "通信先住所１通信先住所２通信先住所３", "住所");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getAdrkn(), "ｶﾅｶﾅｶﾅｶﾅ", "住所(ｶﾅ)");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHhknnm(), "被保険者名　様", "被保険者氏名");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHhknsei(), "男性", "被保険者性別");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHhknseiymd(), "昭和５６年　１月　１日", "被保険者生年月日");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHhknNen(), "３５歳", "被保険者年齢");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHhknKykjiNen(), "２５歳", "被保険者契約時年齢");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getSyouhnnm(), "笑顔の約束", "商品名");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getSyurui(), "終身保険", "種類");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getSyono(), "31809111110", "証券番号");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getCifCd(), "*****", "CIFｺｰﾄﾞ");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getKykymd(), "平成２８年　６月２１日", "契約日");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHrkhou(), "一時払", "払込方法");
        exBizCalcbleEquals(webKykNaiyouSyoukaiInfoBean.getSibous()
            , BizCurrency.valueOf(10000.00, BizCurrencyTypes.AU_DOLLAR) , "死亡保険金");
        Assert.assertEquals(webKykNaiyouSyoukaiInfoBean.getSibous().getType(), BizCurrencyTypes.AU_DOLLAR);
        exBizCalcbleEquals(webKykNaiyouSyoukaiInfoBean.getHrkp()
            , BizCurrency.valueOf(1001.00, BizCurrencyTypes.DOLLAR), "払込保険料");
        Assert.assertEquals(webKykNaiyouSyoukaiInfoBean.getHrkp().getType(), BizCurrencyTypes.DOLLAR);
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getNkShrStartYmd(), "平成２９年　１月　１日", "年金支払開始日");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getNenkinHosyouYear(), "", "年金保証年");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getNenkinKbn(), "", "年金区分");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHaitouKbn(), "準有配当", "配当区分");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getSinsaKbn(), "健康証明書扱、準人間ドック扱", "診査区分");
        exNumericEquals(webKykNaiyouSyoukaiInfoBean.getTksuu(), 6, "特約数");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getLivingneedsTkhyj(), "", "リビングニーズ特約表示");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHokenMankiDay(), "終身", "保険満期日");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getSyunm(), "終身保険", "主契約名称");
        exBizCalcbleEquals(webKykNaiyouSyoukaiInfoBean.getSyus()
            , BizCurrency.optional(), "主契約保険金額");
        Assert.assertEquals(webKykNaiyouSyoukaiInfoBean.getSyus().getType(), BizNumberConfig.instance.getDefaultCurrencyType());
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getSyuhknkkn(), "終身", "主契約保険期間");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getSyuhrkkkn(), "", "主契約払込期間");
        exNumericEquals(webKykNaiyouSyoukaiInfoBean.getTkNaiyouGyousuu(), 6, "特約内容行数");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTknm1(), "重度介護前払特約", "特約名称１");
        exBizCalcbleEquals(webKykNaiyouSyoukaiInfoBean.getTks1(), BizCurrency.optional(), "特約保険金額１");
        Assert.assertEquals(webKykNaiyouSyoukaiInfoBean.getTks1().getType()
            , BizNumberConfig.instance.getDefaultCurrencyType());
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTokuyakuhokenkikan1(), "", "特約保険期間１");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTokuyakuharaikomikikan1(), "", "特約払込期間１");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTknm2(), "初期死亡時円換算支払額最低保証特約", "特約名称２");
        exBizCalcbleEquals(webKykNaiyouSyoukaiInfoBean.getTks2(), BizCurrency.optional(), "特約保険金額２");
        Assert.assertEquals(webKykNaiyouSyoukaiInfoBean.getTks2().getType()
            , BizNumberConfig.instance.getDefaultCurrencyType());
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTokuyakuhokenkikan2(), "", "特約保険期間２");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTokuyakuharaikomikikan2(), "", "特約払込期間２");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTknm3(), "保険料円貨払込特約", "特約名称３");
        exBizCalcbleEquals(webKykNaiyouSyoukaiInfoBean.getTks3(), BizCurrency.optional(), "特約保険金額３");
        Assert.assertEquals(webKykNaiyouSyoukaiInfoBean.getTks3().getType()
            , BizNumberConfig.instance.getDefaultCurrencyType());
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTokuyakuhokenkikan3(), "", "特約保険期間３");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTokuyakuharaikomikikan3(), "", "特約払込期間３");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTknm4(), "保険料指定外通貨払込特約", "特約名称４");
        exBizCalcbleEquals(webKykNaiyouSyoukaiInfoBean.getTks4(), BizCurrency.optional(), "特約保険金額４");
        Assert.assertEquals(webKykNaiyouSyoukaiInfoBean.getTks4().getType()
            , BizNumberConfig.instance.getDefaultCurrencyType());
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTokuyakuhokenkikan4(), "", "特約保険期間４");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTokuyakuharaikomikikan4(), "", "特約払込期間４");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTknm5(), "目標到達時円建終身保険変更特約　１％", "特約名称５");
        exBizCalcbleEquals(webKykNaiyouSyoukaiInfoBean.getTks5(), BizCurrency.optional(), "特約保険金額５");
        Assert.assertEquals(webKykNaiyouSyoukaiInfoBean.getTks5().getType()
            , BizNumberConfig.instance.getDefaultCurrencyType());
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTokuyakuhokenkikan5(), "", "特約保険期間５");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTokuyakuharaikomikikan5(), "", "特約払込期間５");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTknm6(), "指定代理請求特約", "特約名称６");
        exBizCalcbleEquals(webKykNaiyouSyoukaiInfoBean.getTks6(), BizCurrency.optional(), "特約保険金額６");
        Assert.assertEquals(webKykNaiyouSyoukaiInfoBean.getTks6().getType()
            , BizNumberConfig.instance.getDefaultCurrencyType());
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTokuyakuhokenkikan6(), "", "特約保険期間６");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTokuyakuharaikomikikan6(), "", "特約払込期間６");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTknm7(), "", "特約名称７");
        exBizCalcbleEquals(webKykNaiyouSyoukaiInfoBean.getTks7(), BizCurrency.optional(), "特約保険金額７");
        Assert.assertEquals(webKykNaiyouSyoukaiInfoBean.getTks7().getType()
            , BizNumberConfig.instance.getDefaultCurrencyType());
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTokuyakuhokenkikan7(), "", "特約保険期間７");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTokuyakuharaikomikikan7(), "", "特約払込期間７");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTknm8(), "", "特約名称８");
        exBizCalcbleEquals(webKykNaiyouSyoukaiInfoBean.getTks8(), BizCurrency.optional(), "特約保険金額８");
        Assert.assertEquals(webKykNaiyouSyoukaiInfoBean.getTks8().getType()
            , BizNumberConfig.instance.getDefaultCurrencyType());
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTokuyakuhokenkikan8(), "", "特約保険期間８");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTokuyakuharaikomikikan8(), "", "特約払込期間８");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTknm9(), "", "特約名称９");
        exBizCalcbleEquals(webKykNaiyouSyoukaiInfoBean.getTks9(), BizCurrency.optional(), "特約保険金額９");
        Assert.assertEquals(webKykNaiyouSyoukaiInfoBean.getTks9().getType()
            , BizNumberConfig.instance.getDefaultCurrencyType());
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTokuyakuhokenkikan9(), "", "特約保険期間９");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTokuyakuharaikomikikan9(), "", "特約払込期間９");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTknm10(), "", "特約名称１０");
        exBizCalcbleEquals(webKykNaiyouSyoukaiInfoBean.getTks10(), BizCurrency.optional(), "特約保険金額１０");
        Assert.assertEquals(webKykNaiyouSyoukaiInfoBean.getTks10().getType()
            , BizNumberConfig.instance.getDefaultCurrencyType());
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTokuyakuhokenkikan10(), "", "特約保険期間１０");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTokuyakuharaikomikikan10(), "", "特約払込期間１０");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTknm11(), "", "特約名称１１");
        exBizCalcbleEquals(webKykNaiyouSyoukaiInfoBean.getTks11(), BizCurrency.optional(), "特約保険金額１１");
        Assert.assertEquals(webKykNaiyouSyoukaiInfoBean.getTks11().getType()
            , BizNumberConfig.instance.getDefaultCurrencyType());
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTokuyakuhokenkikan11(), "", "特約保険期間１１");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTokuyakuharaikomikikan11(), "", "特約払込期間１１");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTknm12(), "", "特約名称１２");
        exBizCalcbleEquals(webKykNaiyouSyoukaiInfoBean.getTks12(), BizCurrency.optional(), "特約保険金額１２");
        Assert.assertEquals(webKykNaiyouSyoukaiInfoBean.getTks12().getType()
            , BizNumberConfig.instance.getDefaultCurrencyType());
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTokuyakuhokenkikan12(), "", "特約保険期間１２");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTokuyakuharaikomikikan12(), "", "特約払込期間１２");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTknm13(), "", "特約名称１３");
        exBizCalcbleEquals(webKykNaiyouSyoukaiInfoBean.getTks13(), BizCurrency.optional(), "特約保険金額１３");
        Assert.assertEquals(webKykNaiyouSyoukaiInfoBean.getTks13().getType()
            , BizNumberConfig.instance.getDefaultCurrencyType());
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTokuyakuhokenkikan13(), "", "特約保険期間１３");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTokuyakuharaikomikikan13(), "", "特約払込期間１３");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTknm14(), "", "特約名称１４");
        exBizCalcbleEquals(webKykNaiyouSyoukaiInfoBean.getTks14(), BizCurrency.optional(), "特約保険金額１４");
        Assert.assertEquals(webKykNaiyouSyoukaiInfoBean.getTks14().getType()
            , BizNumberConfig.instance.getDefaultCurrencyType());
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTokuyakuhokenkikan14(), "", "特約保険期間１４");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTokuyakuharaikomikikan14(), "", "特約払込期間１４");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTknm15(), "", "特約名称１５");
        exBizCalcbleEquals(webKykNaiyouSyoukaiInfoBean.getTks15(), BizCurrency.optional(), "特約保険金額１５");
        Assert.assertEquals(webKykNaiyouSyoukaiInfoBean.getTks15().getType()
            , BizNumberConfig.instance.getDefaultCurrencyType());
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTokuyakuhokenkikan15(), "", "特約保険期間１５");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTokuyakuharaikomikikan15(), "", "特約払込期間１５");
        exNumericEquals(webKykNaiyouSyoukaiInfoBean.getSyouhnNaiyouGyousuu(), 1, "商品内容行数");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getSyouhnNaiyou1(), "現在の保障内容は下記のとおりです。", "商品内容１");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getSyouhnNaiyou2(), "", "商品内容２");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getSyouhnNaiyou3(), "", "商品内容３");
        exNumericEquals(webKykNaiyouSyoukaiInfoBean.getHosyouNaiyouGyousuu(), 22, "保障内容行数");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHosyouNaiyou1(), "死亡時支払金受取人　複数", "保障内容１");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHosyouNaiyou2(), "年金受取人　　　　　契約者　様", "保障内容２");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHosyouNaiyou3(), "指定代理請求人　　　シテイトクテイメイギ１－１９　様　　　　　　生年月日　平成１３年　１月　１日", "保障内容３");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHosyouNaiyou4(), "定率増加部分繰り入れ割合　１００％", "保障内容４");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHosyouNaiyou5(), "死亡時", "保障内容５");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHosyouNaiyou6(), "　第１保険期間（照会日時点）　　　　　　　　　　　１０，０００．００米ドル", "保障内容６");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHosyouNaiyou7(), "　　　　　　　　　　　　　　　　　　　　　　　　　（１００円）" , "保障内容７");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHosyouNaiyou8(), "　第２保険期間（契約日から１０年経過以後）※　　　　１，００２．００米ドル", "保障内容８");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHosyouNaiyou9(), "　　　　　　　　　　　　　　　　　　　　　　　　　（１００円）", "保障内容９");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHosyouNaiyou10(), "　※第２保険期間中は、基本保険金額と解約返戻金額のうちいずれか大きい金額でお支払いします。", "保障内容１０");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHosyouNaiyou11(), "解約返戻金額（照会日時点）　１，０００．００米ドル　　（１００円）", "保障内容１１");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHosyouNaiyou12(), "積立金額（照会日時点）　１，０００．００米ドル　　（１００円）", "保障内容１２");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHosyouNaiyou13(), "上記（）内の金額は、照会時点の為替レートで円換算した参考値であり変動します。", "保障内容１３");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHosyouNaiyou14(), "保険法対応契約", "保障内容１４");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHosyouNaiyou15(), "重度介護前払特約あり", "保障内容１５");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHosyouNaiyou16(), "保険料円貨払込特約あり　　　　　加入時保険料入金額　　　１，２３０．００円", "保障内容１６");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHosyouNaiyou17(), "　保険料領収日時点の払込特約レート　１米ドル＝１円（平成２９年　７月　１日）", "保障内容１７");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHosyouNaiyou18(), "保険料指定外通貨払込特約あり　　加入時保険料入金額　　１，２３０．００豪ドル", "保障内容１８");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHosyouNaiyou19(), "　保険料領収日時点の払込特約レート　１米ドル＝１豪ドル（平成２９年　７月　１日）", "保障内容１９");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHosyouNaiyou20(), "初期死亡時円換算支払額最低保証特約あり", "保障内容２０");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHosyouNaiyou21(), "指定代理請求特約あり", "保障内容２１");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHosyouNaiyou22(), "目標到達時円建終身保険変更特約あり　　　　　（目標額割合　１％）", "保障内容２２");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHosyouNaiyou23(), "", "保障内容２３");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHosyouNaiyou24(), "", "保障内容２４");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHosyouNaiyou25(), "", "保障内容２５");
        exNumericEquals(webKykNaiyouSyoukaiInfoBean.getHenkouKeiiGyousuu(), 1, "変更経緯行数");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHenkouKeii1(), "＊＊＊＊＊", "変更経緯１");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHenkouKeii2(), "", "変更経緯２");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHenkouKeii3(), "", "変更経緯３");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHenkouKeii4(), "", "変更経緯４");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHenkouKeii5(), "", "変更経緯５");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHenkouKeii6(), "", "変更経緯６");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHenkouKeii7(), "", "変更経緯７");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHenkouKeii8(), "", "変更経緯８");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHenkouKeii9(), "", "変更経緯９");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHenkouKeii10(), "", "変更経緯１０");
        exNumericEquals(webKykNaiyouSyoukaiInfoBean.getBosyuDrtenGyousuu(), 2, "募集代理店行数");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getBosyuDrtenNm1(), "取扱代理店名３", "募集代理店名１");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getDrtenBnwari1(), "", "代理店分割割合１");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getBosyuDrtenNm2(), "取扱代理店名３", "募集代理店名２");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getDrtenBnwari2(), "", "代理店分割割合２");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getMsgOutKbn(), "2", "MSG出力区分");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHosyouIkkatuMinaokeiyakuHyouji(), "0", "保障一括見直契約表示");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHhknnmkn(), "ﾋﾎｹﾝｼｶﾅ", "被保険者氏名(ｶﾅ)");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHokenryouSyuunouJyoukyou(), "－", "保険料収納状況");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getJikaiHokenryouJyuutouYm(), "－", "次回保険料充当年月");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getMdhansybetuKbn(), "01", "窓販種別区分");
    }

    @Test
    @TestOrder(320)
    public void testExec_A32() {
        changeSystemDate();

        MockObjectManager.initialize();
        BzGetProcessSummaryMockForHozen.SYORIPTN = BzGetProcessSummaryMockForHozen.TESTPATTERN2;
        BzGetAdrDataMockForHozen.SYORIPTN = BzGetAdrDataMockForHozen.TESTPATTERN1;
        CalcHkShrKngkMockForHozen.SYORIPTN = CalcHkShrKngkMockForHozen.TESTPATTERN4;
        KeisanWExtMockForHozen.SYORIPTN = KeisanWExtMockForHozen.TESTPATTERN2;
        KeisanWMockForHozen.SYORIPTN = KeisanWMockForHozen.TESTPATTERN1;
        KeisanKijyungkMockForHozen.SYORIPTN = KeisanKijyungkMockForHozen.TESTPATTERN2;
        KeisanGaikakanzanMockForHozen.SYORIPTN = KeisanGaikakanzanMockForHozen.TESTPATTERN1;
        SetNenreiMockForHozen.SYORIPTN = SetNenreiMockForHozen.TESTPATTERN1;

        WebKykNaiyouSyoukaiInfoBean webKykNaiyouSyoukaiInfoBean =
            hbKeiyakuSyoukai.exec("31809111121", BizDate.valueOf("20160621"), C_TanmatuSiyouKbn.DAIRITENBOSYUUNIN, "100006");

        exStringEquals(webKykNaiyouSyoukaiInfoBean.getErrorKbn(), "", "エラー区分");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getErrorMsg(), "", "エラーメッセージ");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getKyknmkn(), "ｶﾅ", "契約者名（カナ）");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getKyknmkj(), "契約者名漢字１－２０　様", "契約者名（漢字）");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getKykseiymd(), "昭和５５年　１月　１日", "契約者生年月日");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getKojinhjnKbn(), "個人", "個人法人区分");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTelno(), "010-1234-5678", "電話番号");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getPostalCd(), "１２３－４５６７", "郵便番号");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getAdr(), "通信先住所１通信先住所２通信先住所３", "住所");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getAdrkn(), "ｶﾅｶﾅｶﾅｶﾅ", "住所(ｶﾅ)");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHhknnm(), "被保険者名１－２０　様", "被保険者氏名");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHhknsei(), "男性", "被保険者性別");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHhknseiymd(), "昭和５５年　１月　１日", "被保険者生年月日");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHhknNen(), "３５歳", "被保険者年齢");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHhknKykjiNen(), "２５歳", "被保険者契約時年齢");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getSyouhnnm(), "笑顔の約束", "商品名");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getSyurui(), "終身保険", "種類");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getSyono(), "31809111121", "証券番号");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getCifCd(), "*****", "CIFｺｰﾄﾞ");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getKykymd(), "平成２８年　６月２１日", "契約日");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHrkhou(), "", "払込方法");
        exBizCalcbleEquals(webKykNaiyouSyoukaiInfoBean.getSibous()
            , BizCurrency.valueOf(10000.00, BizCurrencyTypes.AU_DOLLAR) , "死亡保険金");
        Assert.assertEquals(webKykNaiyouSyoukaiInfoBean.getSibous().getType(), BizCurrencyTypes.AU_DOLLAR);
        exBizCalcbleEquals(webKykNaiyouSyoukaiInfoBean.getHrkp()
            , BizCurrency.valueOf(1001.00, BizCurrencyTypes.DOLLAR), "払込保険料");
        Assert.assertEquals(webKykNaiyouSyoukaiInfoBean.getHrkp().getType(), BizCurrencyTypes.DOLLAR);
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getNkShrStartYmd(), "平成２９年　１月　１日", "年金支払開始日");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getNenkinHosyouYear(), "", "年金保証年");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getNenkinKbn(), "", "年金区分");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHaitouKbn(), "準有配当", "配当区分");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getSinsaKbn(), "", "診査区分");
        exNumericEquals(webKykNaiyouSyoukaiInfoBean.getTksuu(), 5, "特約数");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getLivingneedsTkhyj(), "", "リビングニーズ特約表示");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHokenMankiDay(), "終身", "保険満期日");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getSyunm(), "終身保険", "主契約名称");
        exBizCalcbleEquals(webKykNaiyouSyoukaiInfoBean.getSyus()
            , BizCurrency.optional(), "主契約保険金額");
        Assert.assertEquals(webKykNaiyouSyoukaiInfoBean.getSyus().getType(), BizNumberConfig.instance.getDefaultCurrencyType());
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getSyuhknkkn(), "終身", "主契約保険期間");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getSyuhrkkkn(), "", "主契約払込期間");
        exNumericEquals(webKykNaiyouSyoukaiInfoBean.getTkNaiyouGyousuu(), 5, "特約内容行数");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTknm1(), "保険料円貨払込特約", "特約名称１");
        exBizCalcbleEquals(webKykNaiyouSyoukaiInfoBean.getTks1(), BizCurrency.optional(), "特約保険金額１");
        Assert.assertEquals(webKykNaiyouSyoukaiInfoBean.getTks1().getType()
            , BizNumberConfig.instance.getDefaultCurrencyType());
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTokuyakuhokenkikan1(), "", "特約保険期間１");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTokuyakuharaikomikikan1(), "", "特約払込期間１");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTknm2(), "目標到達時円建年金保険変更特約　１％", "特約名称２");
        exBizCalcbleEquals(webKykNaiyouSyoukaiInfoBean.getTks2(), BizCurrency.optional(), "特約保険金額２");
        Assert.assertEquals(webKykNaiyouSyoukaiInfoBean.getTks2().getType()
            , BizNumberConfig.instance.getDefaultCurrencyType());
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTokuyakuhokenkikan2(), "", "特約保険期間２");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTokuyakuharaikomikikan2(), "", "特約払込期間２");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTknm3(), "保険契約者代理特約", "特約名称３");
        exBizCalcbleEquals(webKykNaiyouSyoukaiInfoBean.getTks3(), BizCurrency.optional(), "特約保険金額３");
        Assert.assertEquals(webKykNaiyouSyoukaiInfoBean.getTks3().getType()
            , BizNumberConfig.instance.getDefaultCurrencyType());
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTokuyakuhokenkikan3(), "", "特約保険期間３");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTokuyakuharaikomikikan3(), "", "特約払込期間３");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTknm4(), "指定代理請求特約", "特約名称４");
        exBizCalcbleEquals(webKykNaiyouSyoukaiInfoBean.getTks4(), BizCurrency.optional(), "特約保険金額４");
        Assert.assertEquals(webKykNaiyouSyoukaiInfoBean.getTks4().getType()
            , BizNumberConfig.instance.getDefaultCurrencyType());
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTokuyakuhokenkikan4(), "", "特約保険期間４");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTokuyakuharaikomikikan4(), "", "特約払込期間４");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTknm5(), "個人年金保険料税制適格特約（’９０）", "特約名称５");
        exBizCalcbleEquals(webKykNaiyouSyoukaiInfoBean.getTks5(), BizCurrency.optional(), "特約保険金額５");
        Assert.assertEquals(webKykNaiyouSyoukaiInfoBean.getTks5().getType()
            , BizNumberConfig.instance.getDefaultCurrencyType());
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTokuyakuhokenkikan5(), "", "特約保険期間５");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTokuyakuharaikomikikan5(), "", "特約払込期間５");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTknm6(), "", "特約名称６");
        exBizCalcbleEquals(webKykNaiyouSyoukaiInfoBean.getTks6(), BizCurrency.optional(), "特約保険金額６");
        Assert.assertEquals(webKykNaiyouSyoukaiInfoBean.getTks6().getType()
            , BizNumberConfig.instance.getDefaultCurrencyType());
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTokuyakuhokenkikan6(), "", "特約保険期間６");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTokuyakuharaikomikikan6(), "", "特約払込期間６");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTknm7(), "", "特約名称７");
        exBizCalcbleEquals(webKykNaiyouSyoukaiInfoBean.getTks7(), BizCurrency.optional(), "特約保険金額７");
        Assert.assertEquals(webKykNaiyouSyoukaiInfoBean.getTks7().getType()
            , BizNumberConfig.instance.getDefaultCurrencyType());
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTokuyakuhokenkikan7(), "", "特約保険期間７");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTokuyakuharaikomikikan7(), "", "特約払込期間７");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTknm8(), "", "特約名称８");
        exBizCalcbleEquals(webKykNaiyouSyoukaiInfoBean.getTks8(), BizCurrency.optional(), "特約保険金額８");
        Assert.assertEquals(webKykNaiyouSyoukaiInfoBean.getTks8().getType()
            , BizNumberConfig.instance.getDefaultCurrencyType());
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTokuyakuhokenkikan8(), "", "特約保険期間８");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTokuyakuharaikomikikan8(), "", "特約払込期間８");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTknm9(), "", "特約名称９");
        exBizCalcbleEquals(webKykNaiyouSyoukaiInfoBean.getTks9(), BizCurrency.optional(), "特約保険金額９");
        Assert.assertEquals(webKykNaiyouSyoukaiInfoBean.getTks9().getType()
            , BizNumberConfig.instance.getDefaultCurrencyType());
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTokuyakuhokenkikan9(), "", "特約保険期間９");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTokuyakuharaikomikikan9(), "", "特約払込期間９");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTknm10(), "", "特約名称１０");
        exBizCalcbleEquals(webKykNaiyouSyoukaiInfoBean.getTks10(), BizCurrency.optional(), "特約保険金額１０");
        Assert.assertEquals(webKykNaiyouSyoukaiInfoBean.getTks10().getType()
            , BizNumberConfig.instance.getDefaultCurrencyType());
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTokuyakuhokenkikan10(), "", "特約保険期間１０");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTokuyakuharaikomikikan10(), "", "特約払込期間１０");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTknm11(), "", "特約名称１１");
        exBizCalcbleEquals(webKykNaiyouSyoukaiInfoBean.getTks11(), BizCurrency.optional(), "特約保険金額１１");
        Assert.assertEquals(webKykNaiyouSyoukaiInfoBean.getTks11().getType()
            , BizNumberConfig.instance.getDefaultCurrencyType());
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTokuyakuhokenkikan11(), "", "特約保険期間１１");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTokuyakuharaikomikikan11(), "", "特約払込期間１１");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTknm12(), "", "特約名称１２");
        exBizCalcbleEquals(webKykNaiyouSyoukaiInfoBean.getTks12(), BizCurrency.optional(), "特約保険金額１２");
        Assert.assertEquals(webKykNaiyouSyoukaiInfoBean.getTks12().getType()
            , BizNumberConfig.instance.getDefaultCurrencyType());
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTokuyakuhokenkikan12(), "", "特約保険期間１２");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTokuyakuharaikomikikan12(), "", "特約払込期間１２");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTknm13(), "", "特約名称１３");
        exBizCalcbleEquals(webKykNaiyouSyoukaiInfoBean.getTks13(), BizCurrency.optional(), "特約保険金額１３");
        Assert.assertEquals(webKykNaiyouSyoukaiInfoBean.getTks13().getType()
            , BizNumberConfig.instance.getDefaultCurrencyType());
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTokuyakuhokenkikan13(), "", "特約保険期間１３");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTokuyakuharaikomikikan13(), "", "特約払込期間１３");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTknm14(), "", "特約名称１４");
        exBizCalcbleEquals(webKykNaiyouSyoukaiInfoBean.getTks14(), BizCurrency.optional(), "特約保険金額１４");
        Assert.assertEquals(webKykNaiyouSyoukaiInfoBean.getTks14().getType()
            , BizNumberConfig.instance.getDefaultCurrencyType());
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTokuyakuhokenkikan14(), "", "特約保険期間１４");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTokuyakuharaikomikikan14(), "", "特約払込期間１４");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTknm15(), "", "特約名称１５");
        exBizCalcbleEquals(webKykNaiyouSyoukaiInfoBean.getTks15(), BizCurrency.optional(), "特約保険金額１５");
        Assert.assertEquals(webKykNaiyouSyoukaiInfoBean.getTks15().getType()
            , BizNumberConfig.instance.getDefaultCurrencyType());
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTokuyakuhokenkikan15(), "", "特約保険期間１５");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTokuyakuharaikomikikan15(), "", "特約払込期間１５");
        exNumericEquals(webKykNaiyouSyoukaiInfoBean.getSyouhnNaiyouGyousuu(), 1, "商品内容行数");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getSyouhnNaiyou1(), "現在の保障内容は下記のとおりです。", "商品内容１");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getSyouhnNaiyou2(), "", "商品内容２");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getSyouhnNaiyou3(), "", "商品内容３");
        exNumericEquals(webKykNaiyouSyoukaiInfoBean.getHosyouNaiyouGyousuu(), 25, "保障内容行数");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHosyouNaiyou1(), "死亡時支払金受取人　被保険者　様", "保障内容１");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHosyouNaiyou2(), "年金受取人　　　　　被保険者　様", "保障内容２");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHosyouNaiyou3(), "契約者代理人　　　　家族名１　１－２０　様　　　　　　　　　", "保障内容３");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHosyouNaiyou4(), "指定代理請求人　　　家族名１　１－２０　様　　　　　　　　　", "保障内容４");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHosyouNaiyou5(), "登録家族（１人目）　家族名１　１－２０　様　　　　　　　　　", "保障内容５");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHosyouNaiyou6(), "登録家族（２人目）　家族名２　１－２０　様　　　　　　　　　", "保障内容６");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHosyouNaiyou7(), "死亡時", "保障内容７");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHosyouNaiyou8(), "（保険料の払込回数に応じて計算しております。）", "保障内容８");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHosyouNaiyou9(), "　第１保険期間（照会日時点）　　　　　　　　　　　１０，０００．００米ドル", "保障内容９");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHosyouNaiyou10(), "　　　　　　　　　　　　　　　　　　　　　　　　　（１００円）", "保障内容１０");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHosyouNaiyou11(), "　第２保険期間（契約日から１０年経過時点）※", "保障内容１１");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHosyouNaiyou12(), "　※第２保険期間中は、基本保険金額と解約返戻金額のうちいずれか大きい金額でお支払いします。", "保障内容１２");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHosyouNaiyou13(), "　第３保険期間（契約日から１５年経過時点）　　　　１０，０００．００米ドル", "保障内容１３");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHosyouNaiyou14(), "　　　　　　　　　　　　　　　　　　　　　　　　　（１００円）", "保障内容１４");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHosyouNaiyou15(), "解約返戻金額（照会日時点）　１，０００．００米ドル　　（１００円）", "保障内容１５");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHosyouNaiyou16(), "積立金額（照会日時点）　１，０００．００米ドル　　（１００円）", "保障内容１６");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHosyouNaiyou17(), "上記（）内の金額は、照会時点の為替レートで円換算した参考値であり変動します。", "保障内容１７");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHosyouNaiyou18(), "年金開始日　　　　　　　　平成２９年　１月　１日", "保障内容１８");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHosyouNaiyou19(), "保険法対応契約", "保障内容１９");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHosyouNaiyou20(), "保険料円貨払込特約あり　　　　　加入時保険料入金額　　　１，２３０．００円", "保障内容２０");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHosyouNaiyou21(), "　保険料領収日時点の払込特約レート　１米ドル＝１円（平成２９年　７月　１日）", "保障内容２１");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHosyouNaiyou22(), "個人年金保険料税制適格特約（’９０）あり", "保障内容２２");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHosyouNaiyou23(), "保険契約者代理特約あり", "保障内容２３");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHosyouNaiyou24(), "指定代理請求特約あり", "保障内容２４");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHosyouNaiyou25(), "目標到達時円建年金保険変更特約あり　　　　　（目標額割合　１％）", "保障内容２５");
        exNumericEquals(webKykNaiyouSyoukaiInfoBean.getHenkouKeiiGyousuu(), 1, "変更経緯行数");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHenkouKeii1(), "平成２７年１２月　１日　契約内容変更", "変更経緯１");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHenkouKeii2(), "", "変更経緯２");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHenkouKeii3(), "", "変更経緯３");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHenkouKeii4(), "", "変更経緯４");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHenkouKeii5(), "", "変更経緯５");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHenkouKeii6(), "", "変更経緯６");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHenkouKeii7(), "", "変更経緯７");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHenkouKeii8(), "", "変更経緯８");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHenkouKeii9(), "", "変更経緯９");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHenkouKeii10(), "", "変更経緯１０");
        exNumericEquals(webKykNaiyouSyoukaiInfoBean.getBosyuDrtenGyousuu(), 2, "募集代理店行数");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getBosyuDrtenNm1(), "取扱代理店名３", "募集代理店名１");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getDrtenBnwari1(), "", "代理店分割割合１");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getBosyuDrtenNm2(), "取扱代理店名３", "募集代理店名２");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getDrtenBnwari2(), "", "代理店分割割合２");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getMsgOutKbn(), "2", "MSG出力区分");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHosyouIkkatuMinaokeiyakuHyouji(), "0", "保障一括見直契約表示");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHhknnmkn(), "ﾋﾎｹﾝｼﾔｶﾅ1-20", "被保険者氏名(ｶﾅ)");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHokenryouSyuunouJyoukyou(), "正常収納中", "保険料収納状況");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getJikaiHokenryouJyuutouYm(), "平成２８年　６月", "次回保険料充当年月");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getMdhansybetuKbn(), "01", "窓販種別区分");
    }


    @Test
    @TestOrder(330)
    public void testExec_A33() {
        changeSystemDate();

        MockObjectManager.initialize();
        BzGetProcessSummaryMockForHozen.SYORIPTN = BzGetProcessSummaryMockForHozen.TESTPATTERN2;
        BzGetAdrDataMockForHozen.SYORIPTN = BzGetAdrDataMockForHozen.TESTPATTERN1;
        CalcHkShrKngkMockForHozen.SYORIPTN = CalcHkShrKngkMockForHozen.TESTPATTERN4;
        KeisanWExtMockForHozen.SYORIPTN = KeisanWExtMockForHozen.TESTPATTERN2;
        KeisanWMockForHozen.SYORIPTN = KeisanWMockForHozen.TESTPATTERN1;
        KeisanKijyungkMockForHozen.SYORIPTN = KeisanKijyungkMockForHozen.TESTPATTERN2;
        KeisanGaikakanzanMockForHozen.SYORIPTN = KeisanGaikakanzanMockForHozen.TESTPATTERN1;
        SetNenreiMockForHozen.SYORIPTN = SetNenreiMockForHozen.TESTPATTERN1;

        WebKykNaiyouSyoukaiInfoBean webKykNaiyouSyoukaiInfoBean =
            hbKeiyakuSyoukai.exec("31809111132", BizDate.valueOf("20160621"), C_TanmatuSiyouKbn.DAIRITENBOSYUUNIN, "100006");

        exStringEquals(webKykNaiyouSyoukaiInfoBean.getErrorKbn(), "", "エラー区分");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getErrorMsg(), "", "エラーメッセージ");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getKyknmkn(), "ｶﾅ", "契約者名（カナ）");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getKyknmkj(), "契約者名漢字１－２１　様", "契約者名（漢字）");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getKykseiymd(), "昭和５５年　１月　１日", "契約者生年月日");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getKojinhjnKbn(), "個人", "個人法人区分");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTelno(), "010-1234-5678", "電話番号");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getPostalCd(), "１２３－４５６７", "郵便番号");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getAdr(), "通信先住所１通信先住所２通信先住所３", "住所");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getAdrkn(), "ｶﾅｶﾅｶﾅｶﾅ", "住所(ｶﾅ)");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHhknnm(), "被保険者名１－２１　様", "被保険者氏名");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHhknsei(), "男性", "被保険者性別");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHhknseiymd(), "昭和５５年　１月　１日", "被保険者生年月日");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHhknNen(), "３５歳", "被保険者年齢");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHhknKykjiNen(), "２５歳", "被保険者契約時年齢");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getSyouhnnm(), "笑顔の約束", "商品名");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getSyurui(), "終身保険", "種類");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getSyono(), "31809111132", "証券番号");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getCifCd(), "*****", "CIFｺｰﾄﾞ");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getKykymd(), "平成２８年　６月２１日", "契約日");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHrkhou(), "", "払込方法");
        exBizCalcbleEquals(webKykNaiyouSyoukaiInfoBean.getSibous()
            , BizCurrency.valueOf(10000.00, BizCurrencyTypes.AU_DOLLAR) , "死亡保険金");
        Assert.assertEquals(webKykNaiyouSyoukaiInfoBean.getSibous().getType(), BizCurrencyTypes.AU_DOLLAR);
        exBizCalcbleEquals(webKykNaiyouSyoukaiInfoBean.getHrkp()
            , BizCurrency.valueOf(1001.00, BizCurrencyTypes.DOLLAR), "払込保険料");
        Assert.assertEquals(webKykNaiyouSyoukaiInfoBean.getHrkp().getType(), BizCurrencyTypes.DOLLAR);
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getNkShrStartYmd(), "平成２９年　１月　１日", "年金支払開始日");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getNenkinHosyouYear(), "", "年金保証年");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getNenkinKbn(), "", "年金区分");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHaitouKbn(), "準有配当", "配当区分");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getSinsaKbn(), "", "診査区分");
        exNumericEquals(webKykNaiyouSyoukaiInfoBean.getTksuu(), 8, "特約数");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getLivingneedsTkhyj(), "", "リビングニーズ特約表示");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHokenMankiDay(), "終身", "保険満期日");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getSyunm(), "終身保険", "主契約名称");
        exBizCalcbleEquals(webKykNaiyouSyoukaiInfoBean.getSyus()
            , BizCurrency.optional(), "主契約保険金額");
        Assert.assertEquals(webKykNaiyouSyoukaiInfoBean.getSyus().getType(), BizNumberConfig.instance.getDefaultCurrencyType());
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getSyuhknkkn(), "終身", "主契約保険期間");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getSyuhrkkkn(), "", "主契約払込期間");
        exNumericEquals(webKykNaiyouSyoukaiInfoBean.getTkNaiyouGyousuu(), 8, "特約内容行数");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTknm1(), "重度介護前払特約", "特約名称１");
        exBizCalcbleEquals(webKykNaiyouSyoukaiInfoBean.getTks1(), BizCurrency.optional(), "特約保険金額１");
        Assert.assertEquals(webKykNaiyouSyoukaiInfoBean.getTks1().getType()
            , BizNumberConfig.instance.getDefaultCurrencyType());
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTokuyakuhokenkikan1(), "", "特約保険期間１");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTokuyakuharaikomikikan1(), "", "特約払込期間１");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTknm2(), "初期死亡時円換算支払額最低保証特約", "特約名称２");
        exBizCalcbleEquals(webKykNaiyouSyoukaiInfoBean.getTks2(), BizCurrency.optional(), "特約保険金額２");
        Assert.assertEquals(webKykNaiyouSyoukaiInfoBean.getTks2().getType()
            , BizNumberConfig.instance.getDefaultCurrencyType());
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTokuyakuhokenkikan2(), "", "特約保険期間２");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTokuyakuharaikomikikan2(), "", "特約払込期間２");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTknm3(), "保険料円貨払込特約", "特約名称３");
        exBizCalcbleEquals(webKykNaiyouSyoukaiInfoBean.getTks3(), BizCurrency.optional(), "特約保険金額３");
        Assert.assertEquals(webKykNaiyouSyoukaiInfoBean.getTks3().getType()
            , BizNumberConfig.instance.getDefaultCurrencyType());
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTokuyakuhokenkikan3(), "", "特約保険期間３");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTokuyakuharaikomikikan3(), "", "特約払込期間３");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTknm4(), "保険料指定外通貨払込特約", "特約名称４");
        exBizCalcbleEquals(webKykNaiyouSyoukaiInfoBean.getTks4(), BizCurrency.optional(), "特約保険金額４");
        Assert.assertEquals(webKykNaiyouSyoukaiInfoBean.getTks4().getType()
            , BizNumberConfig.instance.getDefaultCurrencyType());
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTokuyakuhokenkikan4(), "", "特約保険期間４");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTokuyakuharaikomikikan4(), "", "特約払込期間４");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTknm5(), "目標到達時円建終身保険変更特約　１％", "特約名称５");
        exBizCalcbleEquals(webKykNaiyouSyoukaiInfoBean.getTks5(), BizCurrency.optional(), "特約保険金額５");
        Assert.assertEquals(webKykNaiyouSyoukaiInfoBean.getTks5().getType()
            , BizNumberConfig.instance.getDefaultCurrencyType());
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTokuyakuhokenkikan5(), "", "特約保険期間５");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTokuyakuharaikomikikan5(), "", "特約払込期間５");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTknm6(), "保険契約者代理特約", "特約名称６");
        exBizCalcbleEquals(webKykNaiyouSyoukaiInfoBean.getTks6(), BizCurrency.optional(), "特約保険金額６");
        Assert.assertEquals(webKykNaiyouSyoukaiInfoBean.getTks6().getType()
            , BizNumberConfig.instance.getDefaultCurrencyType());
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTokuyakuhokenkikan6(), "", "特約保険期間６");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTokuyakuharaikomikikan6(), "", "特約払込期間６");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTknm7(), "指定代理請求特約", "特約名称７");
        exBizCalcbleEquals(webKykNaiyouSyoukaiInfoBean.getTks7(), BizCurrency.optional(), "特約保険金額７");
        Assert.assertEquals(webKykNaiyouSyoukaiInfoBean.getTks7().getType()
            , BizNumberConfig.instance.getDefaultCurrencyType());
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTokuyakuhokenkikan7(), "", "特約保険期間７");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTokuyakuharaikomikikan7(), "", "特約払込期間７");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTknm8(), "個人年金保険料税制適格特約（’９０）", "特約名称８");
        exBizCalcbleEquals(webKykNaiyouSyoukaiInfoBean.getTks8(), BizCurrency.optional(), "特約保険金額８");
        Assert.assertEquals(webKykNaiyouSyoukaiInfoBean.getTks8().getType()
            , BizNumberConfig.instance.getDefaultCurrencyType());
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTokuyakuhokenkikan8(), "", "特約保険期間８");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTokuyakuharaikomikikan8(), "", "特約払込期間８");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTknm9(), "", "特約名称９");
        exBizCalcbleEquals(webKykNaiyouSyoukaiInfoBean.getTks9(), BizCurrency.optional(), "特約保険金額９");
        Assert.assertEquals(webKykNaiyouSyoukaiInfoBean.getTks9().getType()
            , BizNumberConfig.instance.getDefaultCurrencyType());
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTokuyakuhokenkikan9(), "", "特約保険期間９");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTokuyakuharaikomikikan9(), "", "特約払込期間９");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTknm10(), "", "特約名称１０");
        exBizCalcbleEquals(webKykNaiyouSyoukaiInfoBean.getTks10(), BizCurrency.optional(), "特約保険金額１０");
        Assert.assertEquals(webKykNaiyouSyoukaiInfoBean.getTks10().getType()
            , BizNumberConfig.instance.getDefaultCurrencyType());
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTokuyakuhokenkikan10(), "", "特約保険期間１０");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTokuyakuharaikomikikan10(), "", "特約払込期間１０");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTknm11(), "", "特約名称１１");
        exBizCalcbleEquals(webKykNaiyouSyoukaiInfoBean.getTks11(), BizCurrency.optional(), "特約保険金額１１");
        Assert.assertEquals(webKykNaiyouSyoukaiInfoBean.getTks11().getType()
            , BizNumberConfig.instance.getDefaultCurrencyType());
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTokuyakuhokenkikan11(), "", "特約保険期間１１");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTokuyakuharaikomikikan11(), "", "特約払込期間１１");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTknm12(), "", "特約名称１２");
        exBizCalcbleEquals(webKykNaiyouSyoukaiInfoBean.getTks12(), BizCurrency.optional(), "特約保険金額１２");
        Assert.assertEquals(webKykNaiyouSyoukaiInfoBean.getTks12().getType()
            , BizNumberConfig.instance.getDefaultCurrencyType());
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTokuyakuhokenkikan12(), "", "特約保険期間１２");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTokuyakuharaikomikikan12(), "", "特約払込期間１２");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTknm13(), "", "特約名称１３");
        exBizCalcbleEquals(webKykNaiyouSyoukaiInfoBean.getTks13(), BizCurrency.optional(), "特約保険金額１３");
        Assert.assertEquals(webKykNaiyouSyoukaiInfoBean.getTks13().getType()
            , BizNumberConfig.instance.getDefaultCurrencyType());
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTokuyakuhokenkikan13(), "", "特約保険期間１３");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTokuyakuharaikomikikan13(), "", "特約払込期間１３");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTknm14(), "", "特約名称１４");
        exBizCalcbleEquals(webKykNaiyouSyoukaiInfoBean.getTks14(), BizCurrency.optional(), "特約保険金額１４");
        Assert.assertEquals(webKykNaiyouSyoukaiInfoBean.getTks14().getType()
            , BizNumberConfig.instance.getDefaultCurrencyType());
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTokuyakuhokenkikan14(), "", "特約保険期間１４");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTokuyakuharaikomikikan14(), "", "特約払込期間１４");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTknm15(), "", "特約名称１５");
        exBizCalcbleEquals(webKykNaiyouSyoukaiInfoBean.getTks15(), BizCurrency.optional(), "特約保険金額１５");
        Assert.assertEquals(webKykNaiyouSyoukaiInfoBean.getTks15().getType()
            , BizNumberConfig.instance.getDefaultCurrencyType());
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTokuyakuhokenkikan15(), "", "特約保険期間１５");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTokuyakuharaikomikikan15(), "", "特約払込期間１５");
        exNumericEquals(webKykNaiyouSyoukaiInfoBean.getSyouhnNaiyouGyousuu(), 1, "商品内容行数");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getSyouhnNaiyou1(), "現在の保障内容は下記のとおりです。", "商品内容１");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getSyouhnNaiyou2(), "", "商品内容２");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getSyouhnNaiyou3(), "", "商品内容３");
        exNumericEquals(webKykNaiyouSyoukaiInfoBean.getHosyouNaiyouGyousuu(), 25, "保障内容行数");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHosyouNaiyou1(), "死亡時支払金受取人　被保険者　様", "保障内容１");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHosyouNaiyou2(), "年金受取人　　　　　被保険者　様", "保障内容２");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHosyouNaiyou3(), "契約者代理人　　　　契代名　１－２１　様　　　　　　　　　　　　生年月日　平成１３年　１月　１日", "保障内容３");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHosyouNaiyou4(), "指定代理請求人　　　指定されておりません　　　　　　　　　　", "保障内容４");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHosyouNaiyou5(), "死亡時", "保障内容５");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHosyouNaiyou6(), "（保険料の払込回数に応じて計算しております。）", "保障内容６");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHosyouNaiyou7(), "　第１保険期間（照会日時点）　　　　　　　　　　　１０，０００．００米ドル", "保障内容７");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHosyouNaiyou8(), "　　　　　　　　　　　　　　　　　　　　　　　　　（１００円）", "保障内容８");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHosyouNaiyou9(), "　第２保険期間（契約日から１０年経過時点）※", "保障内容９");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHosyouNaiyou10(), "　※第２保険期間中は、基本保険金額と解約返戻金額のうちいずれか大きい金額でお支払いします。", "保障内容１０");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHosyouNaiyou11(), "　第３保険期間（契約日から１５年経過時点）　　　　１０，０００．００米ドル", "保障内容１１");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHosyouNaiyou12(), "　　　　　　　　　　　　　　　　　　　　　　　　　（１００円）", "保障内容１２");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHosyouNaiyou13(), "解約返戻金額（照会日時点）　１，０００．００米ドル　　（１００円）", "保障内容１３");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHosyouNaiyou14(), "積立金額（照会日時点）　１，０００．００米ドル　　（１００円）", "保障内容１４");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHosyouNaiyou15(), "上記（）内の金額は、照会時点の為替レートで円換算した参考値であり変動します。", "保障内容１５");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHosyouNaiyou16(), "年金開始日　　　　　　　　平成２９年　１月　１日", "保障内容１６");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHosyouNaiyou17(), "保険法対応契約", "保障内容１７");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHosyouNaiyou18(), "重度介護前払特約あり", "保障内容１８");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHosyouNaiyou19(), "保険料円貨払込特約あり　　　　　加入時保険料入金額　　　１，２３０．００円", "保障内容１９");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHosyouNaiyou20(), "　保険料領収日時点の払込特約レート　１米ドル＝１円（平成２９年　７月　１日）", "保障内容２０");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHosyouNaiyou21(), "保険料指定外通貨払込特約あり　　加入時保険料入金額　　１，２３０．００ユーロ", "保障内容２１");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHosyouNaiyou22(), "　保険料領収日時点の払込特約レート　１米ドル＝１ユーロ（平成２９年　７月　１日）", "保障内容２２");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHosyouNaiyou23(), "個人年金保険料税制適格特約（’９０）あり", "保障内容２３");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHosyouNaiyou24(), "初期死亡時円換算支払額最低保証特約あり", "保障内容２４");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHosyouNaiyou25(), "保険契約者代理特約あり", "保障内容２５");
        exNumericEquals(webKykNaiyouSyoukaiInfoBean.getHenkouKeiiGyousuu(), 1, "変更経緯行数");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHenkouKeii1(), "平成２７年１２月　１日　契約内容変更", "変更経緯１");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHenkouKeii2(), "", "変更経緯２");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHenkouKeii3(), "", "変更経緯３");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHenkouKeii4(), "", "変更経緯４");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHenkouKeii5(), "", "変更経緯５");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHenkouKeii6(), "", "変更経緯６");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHenkouKeii7(), "", "変更経緯７");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHenkouKeii8(), "", "変更経緯８");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHenkouKeii9(), "", "変更経緯９");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHenkouKeii10(), "", "変更経緯１０");
        exNumericEquals(webKykNaiyouSyoukaiInfoBean.getBosyuDrtenGyousuu(), 2, "募集代理店行数");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getBosyuDrtenNm1(), "取扱代理店名３", "募集代理店名１");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getDrtenBnwari1(), "", "代理店分割割合１");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getBosyuDrtenNm2(), "取扱代理店名３", "募集代理店名２");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getDrtenBnwari2(), "", "代理店分割割合２");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getMsgOutKbn(), "2", "MSG出力区分");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHosyouIkkatuMinaokeiyakuHyouji(), "0", "保障一括見直契約表示");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHhknnmkn(), "ﾋﾎｹﾝｼｶﾅ", "被保険者氏名(ｶﾅ)");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHokenryouSyuunouJyoukyou(), "正常収納中", "保険料収納状況");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getJikaiHokenryouJyuutouYm(), "平成２８年　６月", "次回保険料充当年月");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getMdhansybetuKbn(), "01", "窓販種別区分");
    }

    @Test
    @TestOrder(340)
    public void testExec_A34() {
        changeSystemDate();

        MockObjectManager.initialize();
        BzGetProcessSummaryMockForHozen.SYORIPTN = BzGetProcessSummaryMockForHozen.TESTPATTERN2;
        BzGetAdrDataMockForHozen.SYORIPTN = BzGetAdrDataMockForHozen.TESTPATTERN1;
        CalcHkShrKngkMockForHozen.SYORIPTN = CalcHkShrKngkMockForHozen.TESTPATTERN4;
        KeisanWExtMockForHozen.SYORIPTN = KeisanWExtMockForHozen.TESTPATTERN2;
        KeisanWMockForHozen.SYORIPTN = KeisanWMockForHozen.TESTPATTERN1;
        KeisanKijyungkMockForHozen.SYORIPTN = KeisanKijyungkMockForHozen.TESTPATTERN2;
        KeisanGaikakanzanMockForHozen.SYORIPTN = KeisanGaikakanzanMockForHozen.TESTPATTERN1;
        SetNenreiMockForHozen.SYORIPTN = SetNenreiMockForHozen.TESTPATTERN1;

        WebKykNaiyouSyoukaiInfoBean webKykNaiyouSyoukaiInfoBean =
            hbKeiyakuSyoukai.exec("31809111143", BizDate.valueOf("20160621"), C_TanmatuSiyouKbn.DAIRITENBOSYUUNIN, "100006");

        exStringEquals(webKykNaiyouSyoukaiInfoBean.getErrorKbn(), "", "エラー区分");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getErrorMsg(), "", "エラーメッセージ");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getKyknmkn(), "ｶﾅ", "契約者名（カナ）");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getKyknmkj(), "契約者名漢字１－２２　様", "契約者名（漢字）");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getKykseiymd(), "昭和５５年　１月　１日", "契約者生年月日");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getKojinhjnKbn(), "個人", "個人法人区分");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTelno(), "010-1234-5678", "電話番号");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getPostalCd(), "１２３－４５６７", "郵便番号");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getAdr(), "通信先住所１通信先住所２通信先住所３", "住所");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getAdrkn(), "ｶﾅｶﾅｶﾅｶﾅ", "住所(ｶﾅ)");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHhknnm(), "被保険者名　様", "被保険者氏名");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHhknsei(), "男性", "被保険者性別");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHhknseiymd(), "昭和５５年　１月　１日", "被保険者生年月日");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHhknNen(), "３５歳", "被保険者年齢");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHhknKykjiNen(), "２５歳", "被保険者契約時年齢");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getSyouhnnm(), "笑顔の約束", "商品名");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getSyurui(), "終身保険", "種類");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getSyono(), "31809111143", "証券番号");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getCifCd(), "*****", "CIFｺｰﾄﾞ");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getKykymd(), "平成２８年　６月２１日", "契約日");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHrkhou(), "", "払込方法");
        exBizCalcbleEquals(webKykNaiyouSyoukaiInfoBean.getSibous()
            , BizCurrency.valueOf(10000.00, BizCurrencyTypes.AU_DOLLAR) , "死亡保険金");
        Assert.assertEquals(webKykNaiyouSyoukaiInfoBean.getSibous().getType(), BizCurrencyTypes.AU_DOLLAR);
        exBizCalcbleEquals(webKykNaiyouSyoukaiInfoBean.getHrkp()
            , BizCurrency.valueOf(1001.00, BizCurrencyTypes.DOLLAR), "払込保険料");
        Assert.assertEquals(webKykNaiyouSyoukaiInfoBean.getHrkp().getType(), BizCurrencyTypes.DOLLAR);
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getNkShrStartYmd(), "平成２９年　１月　１日", "年金支払開始日");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getNenkinHosyouYear(), "", "年金保証年");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getNenkinKbn(), "", "年金区分");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHaitouKbn(), "準有配当", "配当区分");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getSinsaKbn(), "", "診査区分");
        exNumericEquals(webKykNaiyouSyoukaiInfoBean.getTksuu(), 1, "特約数");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getLivingneedsTkhyj(), "", "リビングニーズ特約表示");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHokenMankiDay(), "終身", "保険満期日");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getSyunm(), "終身保険", "主契約名称");
        exBizCalcbleEquals(webKykNaiyouSyoukaiInfoBean.getSyus()
            , BizCurrency.optional(), "主契約保険金額");
        Assert.assertEquals(webKykNaiyouSyoukaiInfoBean.getSyus().getType(), BizNumberConfig.instance.getDefaultCurrencyType());
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getSyuhknkkn(), "終身", "主契約保険期間");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getSyuhrkkkn(), "", "主契約払込期間");
        exNumericEquals(webKykNaiyouSyoukaiInfoBean.getTkNaiyouGyousuu(), 1, "特約内容行数");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTknm1(), "個人年金保険料税制適格特約（’９０）", "特約名称１");
        exBizCalcbleEquals(webKykNaiyouSyoukaiInfoBean.getTks1(), BizCurrency.optional(), "特約保険金額１");
        Assert.assertEquals(webKykNaiyouSyoukaiInfoBean.getTks1().getType()
            , BizNumberConfig.instance.getDefaultCurrencyType());
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTokuyakuhokenkikan1(), "", "特約保険期間１");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTokuyakuharaikomikikan1(), "", "特約払込期間１");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTknm2(), "", "特約名称２");
        exBizCalcbleEquals(webKykNaiyouSyoukaiInfoBean.getTks2(), BizCurrency.optional(), "特約保険金額２");
        Assert.assertEquals(webKykNaiyouSyoukaiInfoBean.getTks2().getType()
            , BizNumberConfig.instance.getDefaultCurrencyType());
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTokuyakuhokenkikan2(), "", "特約保険期間２");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTokuyakuharaikomikikan2(), "", "特約払込期間２");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTknm3(), "", "特約名称３");
        exBizCalcbleEquals(webKykNaiyouSyoukaiInfoBean.getTks3(), BizCurrency.optional(), "特約保険金額３");
        Assert.assertEquals(webKykNaiyouSyoukaiInfoBean.getTks3().getType()
            , BizNumberConfig.instance.getDefaultCurrencyType());
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTokuyakuhokenkikan3(), "", "特約保険期間３");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTokuyakuharaikomikikan3(), "", "特約払込期間３");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTknm4(), "", "特約名称４");
        exBizCalcbleEquals(webKykNaiyouSyoukaiInfoBean.getTks4(), BizCurrency.optional(), "特約保険金額４");
        Assert.assertEquals(webKykNaiyouSyoukaiInfoBean.getTks4().getType()
            , BizNumberConfig.instance.getDefaultCurrencyType());
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTokuyakuhokenkikan4(), "", "特約保険期間４");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTokuyakuharaikomikikan4(), "", "特約払込期間４");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTknm5(), "", "特約名称５");
        exBizCalcbleEquals(webKykNaiyouSyoukaiInfoBean.getTks5(), BizCurrency.optional(), "特約保険金額５");
        Assert.assertEquals(webKykNaiyouSyoukaiInfoBean.getTks5().getType()
            , BizNumberConfig.instance.getDefaultCurrencyType());
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTokuyakuhokenkikan5(), "", "特約保険期間５");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTokuyakuharaikomikikan5(), "", "特約払込期間５");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTknm6(), "", "特約名称６");
        exBizCalcbleEquals(webKykNaiyouSyoukaiInfoBean.getTks6(), BizCurrency.optional(), "特約保険金額６");
        Assert.assertEquals(webKykNaiyouSyoukaiInfoBean.getTks6().getType()
            , BizNumberConfig.instance.getDefaultCurrencyType());
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTokuyakuhokenkikan6(), "", "特約保険期間６");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTokuyakuharaikomikikan6(), "", "特約払込期間６");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTknm7(), "", "特約名称７");
        exBizCalcbleEquals(webKykNaiyouSyoukaiInfoBean.getTks7(), BizCurrency.optional(), "特約保険金額７");
        Assert.assertEquals(webKykNaiyouSyoukaiInfoBean.getTks7().getType()
            , BizNumberConfig.instance.getDefaultCurrencyType());
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTokuyakuhokenkikan7(), "", "特約保険期間７");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTokuyakuharaikomikikan7(), "", "特約払込期間７");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTknm8(), "", "特約名称８");
        exBizCalcbleEquals(webKykNaiyouSyoukaiInfoBean.getTks8(), BizCurrency.optional(), "特約保険金額８");
        Assert.assertEquals(webKykNaiyouSyoukaiInfoBean.getTks8().getType()
            , BizNumberConfig.instance.getDefaultCurrencyType());
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTokuyakuhokenkikan8(), "", "特約保険期間８");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTokuyakuharaikomikikan8(), "", "特約払込期間８");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTknm9(), "", "特約名称９");
        exBizCalcbleEquals(webKykNaiyouSyoukaiInfoBean.getTks9(), BizCurrency.optional(), "特約保険金額９");
        Assert.assertEquals(webKykNaiyouSyoukaiInfoBean.getTks9().getType()
            , BizNumberConfig.instance.getDefaultCurrencyType());
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTokuyakuhokenkikan9(), "", "特約保険期間９");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTokuyakuharaikomikikan9(), "", "特約払込期間９");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTknm10(), "", "特約名称１０");
        exBizCalcbleEquals(webKykNaiyouSyoukaiInfoBean.getTks10(), BizCurrency.optional(), "特約保険金額１０");
        Assert.assertEquals(webKykNaiyouSyoukaiInfoBean.getTks10().getType()
            , BizNumberConfig.instance.getDefaultCurrencyType());
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTokuyakuhokenkikan10(), "", "特約保険期間１０");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTokuyakuharaikomikikan10(), "", "特約払込期間１０");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTknm11(), "", "特約名称１１");
        exBizCalcbleEquals(webKykNaiyouSyoukaiInfoBean.getTks11(), BizCurrency.optional(), "特約保険金額１１");
        Assert.assertEquals(webKykNaiyouSyoukaiInfoBean.getTks11().getType()
            , BizNumberConfig.instance.getDefaultCurrencyType());
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTokuyakuhokenkikan11(), "", "特約保険期間１１");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTokuyakuharaikomikikan11(), "", "特約払込期間１１");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTknm12(), "", "特約名称１２");
        exBizCalcbleEquals(webKykNaiyouSyoukaiInfoBean.getTks12(), BizCurrency.optional(), "特約保険金額１２");
        Assert.assertEquals(webKykNaiyouSyoukaiInfoBean.getTks12().getType()
            , BizNumberConfig.instance.getDefaultCurrencyType());
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTokuyakuhokenkikan12(), "", "特約保険期間１２");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTokuyakuharaikomikikan12(), "", "特約払込期間１２");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTknm13(), "", "特約名称１３");
        exBizCalcbleEquals(webKykNaiyouSyoukaiInfoBean.getTks13(), BizCurrency.optional(), "特約保険金額１３");
        Assert.assertEquals(webKykNaiyouSyoukaiInfoBean.getTks13().getType()
            , BizNumberConfig.instance.getDefaultCurrencyType());
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTokuyakuhokenkikan13(), "", "特約保険期間１３");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTokuyakuharaikomikikan13(), "", "特約払込期間１３");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTknm14(), "", "特約名称１４");
        exBizCalcbleEquals(webKykNaiyouSyoukaiInfoBean.getTks14(), BizCurrency.optional(), "特約保険金額１４");
        Assert.assertEquals(webKykNaiyouSyoukaiInfoBean.getTks14().getType()
            , BizNumberConfig.instance.getDefaultCurrencyType());
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTokuyakuhokenkikan14(), "", "特約保険期間１４");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTokuyakuharaikomikikan14(), "", "特約払込期間１４");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTknm15(), "", "特約名称１５");
        exBizCalcbleEquals(webKykNaiyouSyoukaiInfoBean.getTks15(), BizCurrency.optional(), "特約保険金額１５");
        Assert.assertEquals(webKykNaiyouSyoukaiInfoBean.getTks15().getType()
            , BizNumberConfig.instance.getDefaultCurrencyType());
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTokuyakuhokenkikan15(), "", "特約保険期間１５");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTokuyakuharaikomikikan15(), "", "特約払込期間１５");
        exNumericEquals(webKykNaiyouSyoukaiInfoBean.getSyouhnNaiyouGyousuu(), 1, "商品内容行数");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getSyouhnNaiyou1(), "現在の保障内容は下記のとおりです。", "商品内容１");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getSyouhnNaiyou2(), "", "商品内容２");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getSyouhnNaiyou3(), "", "商品内容３");
        exNumericEquals(webKykNaiyouSyoukaiInfoBean.getHosyouNaiyouGyousuu(), 18, "保障内容行数");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHosyouNaiyou1(), "死亡時支払金受取人　契約者　様", "保障内容１");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHosyouNaiyou2(), "年金受取人　　　　　契約者　様", "保障内容２");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHosyouNaiyou3(), "払込保険料の円換算額　　　　１１，０００円", "保障内容３");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHosyouNaiyou4(), "　保険料領収日時点の円換算為替レート　１米ドル＝５０円（平成２９年　７月　１日）", "保障内容４");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHosyouNaiyou5(), "死亡時", "保障内容５");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHosyouNaiyou6(), "（保険料の払込回数に応じて計算しております。）", "保障内容６");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHosyouNaiyou7(), "　第１保険期間（照会日時点）　　　　　　　　　　　１０，０００．００米ドル", "保障内容７");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHosyouNaiyou8(), "　　　　　　　　　　　　　　　　　　　　　　　　　（１００円）", "保障内容８");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHosyouNaiyou9(), "　第２保険期間（契約日から１０年経過時点）※", "保障内容９");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHosyouNaiyou10(), "　※第２保険期間中は、基本保険金額と解約返戻金額のうちいずれか大きい金額でお支払いします。", "保障内容１０");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHosyouNaiyou11(), "　第３保険期間（契約日から１５年経過時点）　　　　１０，０００．００米ドル", "保障内容１１");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHosyouNaiyou12(), "　　　　　　　　　　　　　　　　　　　　　　　　　（１００円）", "保障内容１２");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHosyouNaiyou13(), "解約返戻金額（照会日時点）　１，０００．００米ドル　　（１００円）", "保障内容１３");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHosyouNaiyou14(), "積立金額（照会日時点）　１，０００．００米ドル　　（１００円）", "保障内容１４");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHosyouNaiyou15(), "上記（）内の金額は、照会時点の為替レートで円換算した参考値であり変動します。", "保障内容１５");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHosyouNaiyou16(), "年金開始日　　　　　　　　平成２９年　１月　１日", "保障内容１６");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHosyouNaiyou17(), "保険法対応契約", "保障内容１７");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHosyouNaiyou18(), "個人年金保険料税制適格特約（’９０）あり", "保障内容１８");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHosyouNaiyou19(), "", "保障内容１９");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHosyouNaiyou20(), "", "保障内容２０");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHosyouNaiyou21(), "", "保障内容２１");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHosyouNaiyou22(), "", "保障内容２２");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHosyouNaiyou23(), "", "保障内容２３");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHosyouNaiyou24(), "", "保障内容２４");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHosyouNaiyou25(), "", "保障内容２５");
        exNumericEquals(webKykNaiyouSyoukaiInfoBean.getHenkouKeiiGyousuu(), 1, "変更経緯行数");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHenkouKeii1(), "＊＊＊＊＊", "変更経緯１");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHenkouKeii2(), "", "変更経緯２");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHenkouKeii3(), "", "変更経緯３");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHenkouKeii4(), "", "変更経緯４");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHenkouKeii5(), "", "変更経緯５");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHenkouKeii6(), "", "変更経緯６");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHenkouKeii7(), "", "変更経緯７");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHenkouKeii8(), "", "変更経緯８");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHenkouKeii9(), "", "変更経緯９");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHenkouKeii10(), "", "変更経緯１０");
        exNumericEquals(webKykNaiyouSyoukaiInfoBean.getBosyuDrtenGyousuu(), 2, "募集代理店行数");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getBosyuDrtenNm1(), "取扱代理店名３", "募集代理店名１");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getDrtenBnwari1(), "", "代理店分割割合１");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getBosyuDrtenNm2(), "取扱代理店名３", "募集代理店名２");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getDrtenBnwari2(), "", "代理店分割割合２");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getMsgOutKbn(), "2", "MSG出力区分");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHosyouIkkatuMinaokeiyakuHyouji(), "0", "保障一括見直契約表示");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHhknnmkn(), "ﾋﾎｹﾝｼｶﾅ", "被保険者氏名(ｶﾅ)");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHokenryouSyuunouJyoukyou(), "正常収納中", "保険料収納状況");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getJikaiHokenryouJyuutouYm(), "平成２８年　６月", "次回保険料充当年月");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getMdhansybetuKbn(), "01", "窓販種別区分");
    }

    @Test
    @TestOrder(350)
    public void testExec_A35() {
        changeSystemDate();

        MockObjectManager.initialize();
        BzGetProcessSummaryMockForHozen.SYORIPTN = BzGetProcessSummaryMockForHozen.TESTPATTERN2;
        BzGetAdrDataMockForHozen.SYORIPTN = BzGetAdrDataMockForHozen.TESTPATTERN1;
        CalcHkShrKngkMockForHozen.SYORIPTN = CalcHkShrKngkMockForHozen.TESTPATTERN4;
        KeisanWExtMockForHozen.SYORIPTN = KeisanWExtMockForHozen.TESTPATTERN2;
        KeisanWMockForHozen.SYORIPTN = KeisanWMockForHozen.TESTPATTERN1;
        KeisanKijyungkMockForHozen.SYORIPTN = KeisanKijyungkMockForHozen.TESTPATTERN2;
        KeisanGaikakanzanMockForHozen.SYORIPTN = KeisanGaikakanzanMockForHozen.TESTPATTERN1;
        SetNenreiMockForHozen.SYORIPTN = SetNenreiMockForHozen.TESTPATTERN1;

        WebKykNaiyouSyoukaiInfoBean webKykNaiyouSyoukaiInfoBean =
            hbKeiyakuSyoukai.exec("31809111497", BizDate.valueOf("20160621"), C_TanmatuSiyouKbn.DAIRITENBOSYUUNIN,"A10010");

        exStringEquals(webKykNaiyouSyoukaiInfoBean.getErrorKbn(), "", "エラー区分");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getErrorMsg(), "", "エラーメッセージ");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getKyknmkn(), "ｶﾅ", "契約者名（カナ）");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getKyknmkj(), "契約者名漢字１－２３　様", "契約者名（漢字）");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getKykseiymd(), "昭和５５年　１月　１日", "契約者生年月日");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getKojinhjnKbn(), "個人", "個人法人区分");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTelno(), "010-1234-5678", "電話番号");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getPostalCd(), "１２３－４５６７", "郵便番号");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getAdr(), "通信先住所１通信先住所２通信先住所３", "住所");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getAdrkn(), "ｶﾅｶﾅｶﾅｶﾅ", "住所(ｶﾅ)");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHhknnm(), "被保険者名　様", "被保険者氏名");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHhknsei(), "男性", "被保険者性別");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHhknseiymd(), "昭和５５年　１月　１日", "被保険者生年月日");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHhknNen(), "３５歳", "被保険者年齢");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHhknKykjiNen(), "２５歳", "被保険者契約時年齢");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getSyouhnnm(), "笑顔の約束", "商品名");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getSyurui(), "年金保険", "種類");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getSyono(), "31809111497", "証券番号");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getCifCd(), "*****", "CIFｺｰﾄﾞ");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getKykymd(), "平成２８年　６月２０日", "契約日");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHrkhou(), "", "払込方法");
        exBizCalcbleEquals(webKykNaiyouSyoukaiInfoBean.getSibous()
            , BizCurrency.valueOf(10000.00, BizCurrencyTypes.AU_DOLLAR) , "死亡保険金");
        Assert.assertEquals(webKykNaiyouSyoukaiInfoBean.getSibous().getType(), BizCurrencyTypes.AU_DOLLAR);
        exBizCalcbleEquals(webKykNaiyouSyoukaiInfoBean.getHrkp()
            , BizCurrency.valueOf(1001.00, BizCurrencyTypes.DOLLAR), "払込保険料");
        Assert.assertEquals(webKykNaiyouSyoukaiInfoBean.getHrkp().getType(), BizCurrencyTypes.DOLLAR);
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getNkShrStartYmd(), "平成２８年　３月　１日", "年金支払開始日");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getNenkinHosyouYear(), "　５年", "年金保証年");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getNenkinKbn(), "確定年金", "年金区分");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHaitouKbn(), "準有配当", "配当区分");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getSinsaKbn(), "", "診査区分");
        exNumericEquals(webKykNaiyouSyoukaiInfoBean.getTksuu(), 5, "特約数");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getLivingneedsTkhyj(), "", "リビングニーズ特約表示");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHokenMankiDay(), "平成２８年　２月２９日", "保険満期日");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getSyunm(), "個人年金", "主契約名称");
        exBizCalcbleEquals(webKykNaiyouSyoukaiInfoBean.getSyus()
            , BizCurrency.optional(), "主契約保険金額");
        Assert.assertEquals(webKykNaiyouSyoukaiInfoBean.getSyus().getType(), BizNumberConfig.instance.getDefaultCurrencyType());
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getSyuhknkkn(), "１１年間", "主契約保険期間");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getSyuhrkkkn(), "", "主契約払込期間");
        exNumericEquals(webKykNaiyouSyoukaiInfoBean.getTkNaiyouGyousuu(), 5, "特約内容行数");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTknm1(), "保険料円貨払込特約", "特約名称１");
        exBizCalcbleEquals(webKykNaiyouSyoukaiInfoBean.getTks1(), BizCurrency.optional(), "特約保険金額１");
        Assert.assertEquals(webKykNaiyouSyoukaiInfoBean.getTks1().getType()
            , BizNumberConfig.instance.getDefaultCurrencyType());
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTokuyakuhokenkikan1(), "", "特約保険期間１");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTokuyakuharaikomikikan1(), "", "特約払込期間１");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTknm2(), "保険料指定外通貨払込特約", "特約名称２");
        exBizCalcbleEquals(webKykNaiyouSyoukaiInfoBean.getTks2(), BizCurrency.optional(), "特約保険金額２");
        Assert.assertEquals(webKykNaiyouSyoukaiInfoBean.getTks2().getType()
            , BizNumberConfig.instance.getDefaultCurrencyType());
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTokuyakuhokenkikan2(), "", "特約保険期間２");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTokuyakuharaikomikikan2(), "", "特約払込期間２");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTknm3(), "保険契約者代理特約", "特約名称３");
        exBizCalcbleEquals(webKykNaiyouSyoukaiInfoBean.getTks3(), BizCurrency.optional(), "特約保険金額３");
        Assert.assertEquals(webKykNaiyouSyoukaiInfoBean.getTks3().getType()
            , BizNumberConfig.instance.getDefaultCurrencyType());
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTokuyakuhokenkikan3(), "", "特約保険期間３");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTokuyakuharaikomikikan3(), "", "特約払込期間３");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTknm4(), "指定代理請求特約", "特約名称４");
        exBizCalcbleEquals(webKykNaiyouSyoukaiInfoBean.getTks4(), BizCurrency.optional(), "特約保険金額４");
        Assert.assertEquals(webKykNaiyouSyoukaiInfoBean.getTks4().getType()
            , BizNumberConfig.instance.getDefaultCurrencyType());
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTokuyakuhokenkikan4(), "", "特約保険期間４");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTokuyakuharaikomikikan4(), "", "特約払込期間４");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTknm5(), "個人年金保険料税制適格特約（’９０）", "特約名称５");
        exBizCalcbleEquals(webKykNaiyouSyoukaiInfoBean.getTks5(), BizCurrency.optional(), "特約保険金額５");
        Assert.assertEquals(webKykNaiyouSyoukaiInfoBean.getTks5().getType()
            , BizNumberConfig.instance.getDefaultCurrencyType());
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTokuyakuhokenkikan5(), "", "特約保険期間５");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTokuyakuharaikomikikan5(), "", "特約払込期間５");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTknm6(), "", "特約名称６");
        exBizCalcbleEquals(webKykNaiyouSyoukaiInfoBean.getTks6(), BizCurrency.optional(), "特約保険金額６");
        Assert.assertEquals(webKykNaiyouSyoukaiInfoBean.getTks6().getType()
            , BizNumberConfig.instance.getDefaultCurrencyType());
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTokuyakuhokenkikan6(), "", "特約保険期間６");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTokuyakuharaikomikikan6(), "", "特約払込期間６");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTknm7(), "", "特約名称７");
        exBizCalcbleEquals(webKykNaiyouSyoukaiInfoBean.getTks7(), BizCurrency.optional(), "特約保険金額７");
        Assert.assertEquals(webKykNaiyouSyoukaiInfoBean.getTks7().getType()
            , BizNumberConfig.instance.getDefaultCurrencyType());
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTokuyakuhokenkikan7(), "", "特約保険期間７");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTokuyakuharaikomikikan7(), "", "特約払込期間７");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTknm8(), "", "特約名称８");
        exBizCalcbleEquals(webKykNaiyouSyoukaiInfoBean.getTks8(), BizCurrency.optional(), "特約保険金額８");
        Assert.assertEquals(webKykNaiyouSyoukaiInfoBean.getTks8().getType()
            , BizNumberConfig.instance.getDefaultCurrencyType());
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTokuyakuhokenkikan8(), "", "特約保険期間８");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTokuyakuharaikomikikan8(), "", "特約払込期間８");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTknm9(), "", "特約名称９");
        exBizCalcbleEquals(webKykNaiyouSyoukaiInfoBean.getTks9(), BizCurrency.optional(), "特約保険金額９");
        Assert.assertEquals(webKykNaiyouSyoukaiInfoBean.getTks9().getType()
            , BizNumberConfig.instance.getDefaultCurrencyType());
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTokuyakuhokenkikan9(), "", "特約保険期間９");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTokuyakuharaikomikikan9(), "", "特約払込期間９");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTknm10(), "", "特約名称１０");
        exBizCalcbleEquals(webKykNaiyouSyoukaiInfoBean.getTks10(), BizCurrency.optional(), "特約保険金額１０");
        Assert.assertEquals(webKykNaiyouSyoukaiInfoBean.getTks10().getType()
            , BizNumberConfig.instance.getDefaultCurrencyType());
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTokuyakuhokenkikan10(), "", "特約保険期間１０");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTokuyakuharaikomikikan10(), "", "特約払込期間１０");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTknm11(), "", "特約名称１１");
        exBizCalcbleEquals(webKykNaiyouSyoukaiInfoBean.getTks11(), BizCurrency.optional(), "特約保険金額１１");
        Assert.assertEquals(webKykNaiyouSyoukaiInfoBean.getTks11().getType()
            , BizNumberConfig.instance.getDefaultCurrencyType());
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTokuyakuhokenkikan11(), "", "特約保険期間１１");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTokuyakuharaikomikikan11(), "", "特約払込期間１１");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTknm12(), "", "特約名称１２");
        exBizCalcbleEquals(webKykNaiyouSyoukaiInfoBean.getTks12(), BizCurrency.optional(), "特約保険金額１２");
        Assert.assertEquals(webKykNaiyouSyoukaiInfoBean.getTks12().getType()
            , BizNumberConfig.instance.getDefaultCurrencyType());
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTokuyakuhokenkikan12(), "", "特約保険期間１２");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTokuyakuharaikomikikan12(), "", "特約払込期間１２");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTknm13(), "", "特約名称１３");
        exBizCalcbleEquals(webKykNaiyouSyoukaiInfoBean.getTks13(), BizCurrency.optional(), "特約保険金額１３");
        Assert.assertEquals(webKykNaiyouSyoukaiInfoBean.getTks13().getType()
            , BizNumberConfig.instance.getDefaultCurrencyType());
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTokuyakuhokenkikan13(), "", "特約保険期間１３");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTokuyakuharaikomikikan13(), "", "特約払込期間１３");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTknm14(), "", "特約名称１４");
        exBizCalcbleEquals(webKykNaiyouSyoukaiInfoBean.getTks14(), BizCurrency.optional(), "特約保険金額１４");
        Assert.assertEquals(webKykNaiyouSyoukaiInfoBean.getTks14().getType()
            , BizNumberConfig.instance.getDefaultCurrencyType());
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTokuyakuhokenkikan14(), "", "特約保険期間１４");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTokuyakuharaikomikikan14(), "", "特約払込期間１４");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTknm15(), "", "特約名称１５");
        exBizCalcbleEquals(webKykNaiyouSyoukaiInfoBean.getTks15(), BizCurrency.optional(), "特約保険金額１５");
        Assert.assertEquals(webKykNaiyouSyoukaiInfoBean.getTks15().getType()
            , BizNumberConfig.instance.getDefaultCurrencyType());
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTokuyakuhokenkikan15(), "", "特約保険期間１５");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTokuyakuharaikomikikan15(), "", "特約払込期間１５");
        exNumericEquals(webKykNaiyouSyoukaiInfoBean.getSyouhnNaiyouGyousuu(), 1, "商品内容行数");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getSyouhnNaiyou1(), "現在の保障内容は下記のとおりです。", "商品内容１");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getSyouhnNaiyou2(), "", "商品内容２");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getSyouhnNaiyou3(), "", "商品内容３");
        exNumericEquals(webKykNaiyouSyoukaiInfoBean.getHosyouNaiyouGyousuu(), 15, "保障内容行数");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHosyouNaiyou1(), "死亡時支払金受取人　契約者　様", "保障内容１");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHosyouNaiyou2(), "年金受取人　　　　　契約者　様", "保障内容２");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHosyouNaiyou3(), "契約者代理人　　　　カゾクメイ１　１－２３　様　　　　　　　", "保障内容３");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHosyouNaiyou4(), "指定代理請求人　　　カゾクメイ１　１－２３　様　　　　　　　", "保障内容４");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHosyouNaiyou5(), "登録家族（１人目）　カゾクメイ１　１－２３　様　　　　　　　", "保障内容５");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHosyouNaiyou6(), "登録家族（２人目）　カゾクメイ２　１－２３　様　　　　　　　", "保障内容６");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHosyouNaiyou7(), "死亡時　　　　　　　　　　　１０，０００円", "保障内容７");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHosyouNaiyou8(), "（保険料の払込回数に応じて計算しております。）", "保障内容８");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHosyouNaiyou9(), "解約返戻金額（照会日時点）　１，０００円", "保障内容９");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHosyouNaiyou10(), "積立金額（照会日時点）　１，０００円", "保障内容１０");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHosyouNaiyou11(), "年金開始日　　　　　　　　平成２８年　３月　１日", "保障内容１１");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHosyouNaiyou12(), "保険法対応契約", "保障内容１２");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHosyouNaiyou13(), "個人年金保険料税制適格特約（’９０）あり", "保障内容１３");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHosyouNaiyou14(), "保険契約者代理特約あり", "保障内容１４");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHosyouNaiyou15(), "指定代理請求特約あり", "保障内容１５");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHosyouNaiyou16(), "", "保障内容１６");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHosyouNaiyou17(), "", "保障内容１７");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHosyouNaiyou18(), "", "保障内容１８");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHosyouNaiyou19(), "", "保障内容１９");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHosyouNaiyou20(), "", "保障内容２０");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHosyouNaiyou21(), "", "保障内容２１");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHosyouNaiyou22(), "", "保障内容２２");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHosyouNaiyou23(), "", "保障内容２３");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHosyouNaiyou24(), "", "保障内容２４");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHosyouNaiyou25(), "", "保障内容２５");
        exNumericEquals(webKykNaiyouSyoukaiInfoBean.getHenkouKeiiGyousuu(), 1, "変更経緯行数");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHenkouKeii1(), "平成２７年１２月　１日　契約内容変更", "変更経緯１");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHenkouKeii2(), "", "変更経緯２");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHenkouKeii3(), "", "変更経緯３");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHenkouKeii4(), "", "変更経緯４");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHenkouKeii5(), "", "変更経緯５");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHenkouKeii6(), "", "変更経緯６");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHenkouKeii7(), "", "変更経緯７");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHenkouKeii8(), "", "変更経緯８");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHenkouKeii9(), "", "変更経緯９");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHenkouKeii10(), "", "変更経緯１０");
        exNumericEquals(webKykNaiyouSyoukaiInfoBean.getBosyuDrtenGyousuu(), 2, "募集代理店行数");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getBosyuDrtenNm1(), "取扱代理店名３", "募集代理店名１");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getDrtenBnwari1(), "", "代理店分割割合１");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getBosyuDrtenNm2(), "取扱代理店名３", "募集代理店名２");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getDrtenBnwari2(), "", "代理店分割割合２");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getMsgOutKbn(), "2", "MSG出力区分");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHosyouIkkatuMinaokeiyakuHyouji(), "0", "保障一括見直契約表示");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHhknnmkn(), "ﾋﾎｹﾝｼｶﾅ", "被保険者氏名(ｶﾅ)");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHokenryouSyuunouJyoukyou(), "正常収納中", "保険料収納状況");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getJikaiHokenryouJyuutouYm(), "平成２８年　６月", "次回保険料充当年月");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getMdhansybetuKbn(), "01", "窓販種別区分");
    }


    @Test
    @TestOrder(360)
    public void testExec_A36() {
        changeSystemDate();

        MockObjectManager.initialize();
        BzGetProcessSummaryMockForHozen.SYORIPTN = BzGetProcessSummaryMockForHozen.TESTPATTERN2;
        BzGetAdrDataMockForHozen.SYORIPTN = BzGetAdrDataMockForHozen.TESTPATTERN1;
        CalcHkShrKngkMockForHozen.SYORIPTN = CalcHkShrKngkMockForHozen.TESTPATTERN4;
        KeisanWExtMockForHozen.SYORIPTN = KeisanWExtMockForHozen.TESTPATTERN2;
        KeisanWMockForHozen.SYORIPTN = KeisanWMockForHozen.TESTPATTERN1;
        KeisanKijyungkMockForHozen.SYORIPTN = KeisanKijyungkMockForHozen.TESTPATTERN2;
        KeisanGaikakanzanMockForHozen.SYORIPTN = KeisanGaikakanzanMockForHozen.TESTPATTERN1;
        SetNenreiMockForHozen.SYORIPTN = SetNenreiMockForHozen.TESTPATTERN1;

        WebKykNaiyouSyoukaiInfoBean webKykNaiyouSyoukaiInfoBean =
            hbKeiyakuSyoukai.exec("31809111501", BizDate.valueOf("20160621"), C_TanmatuSiyouKbn.SOUGOU_IPPAN,"A10010");

        exStringEquals(webKykNaiyouSyoukaiInfoBean.getErrorKbn(), "", "エラー区分");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getErrorMsg(), "", "エラーメッセージ");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getKyknmkn(), "ｶﾅ", "契約者名（カナ）");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getKyknmkj(), "契約者名漢字１－２４　様", "契約者名（漢字）");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getKykseiymd(), "昭和５５年　１月　１日", "契約者生年月日");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getKojinhjnKbn(), "個人", "個人法人区分");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTelno(), "010-1234-5678", "電話番号");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getPostalCd(), "１２３－４５６７", "郵便番号");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getAdr(), "通信先住所１通信先住所２通信先住所３", "住所");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getAdrkn(), "ｶﾅｶﾅｶﾅｶﾅ", "住所(ｶﾅ)");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHhknnm(), "被保険者名　様", "被保険者氏名");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHhknsei(), "男性", "被保険者性別");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHhknseiymd(), "昭和５５年　１月　１日", "被保険者生年月日");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHhknNen(), "３５歳", "被保険者年齢");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHhknKykjiNen(), "２５歳", "被保険者契約時年齢");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getSyouhnnm(), "商品名称５６７８９０１２３４５６７８９０１２３４５６７８９０１　しんきんらいふ年金Ｓ　たのしみグローバル（指数連動プラン）", "商品名");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getSyurui(), "", "種類");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getSyono(), "31809111501", "証券番号");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getCifCd(), "*****", "CIFｺｰﾄﾞ");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getKykymd(), "平成２８年　６月２１日", "契約日");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHrkhou(), "", "払込方法");
        exBizCalcbleEquals(webKykNaiyouSyoukaiInfoBean.getSibous()
            , BizCurrency.valueOf(10000.00, BizCurrencyTypes.AU_DOLLAR) , "死亡保険金");
        Assert.assertEquals(webKykNaiyouSyoukaiInfoBean.getSibous().getType(), BizCurrencyTypes.AU_DOLLAR);
        exBizCalcbleEquals(webKykNaiyouSyoukaiInfoBean.getHrkp()
            , BizCurrency.valueOf(1001.00, BizCurrencyTypes.DOLLAR), "払込保険料");
        Assert.assertEquals(webKykNaiyouSyoukaiInfoBean.getHrkp().getType(), BizCurrencyTypes.DOLLAR);
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getNkShrStartYmd(), "", "年金支払開始日");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getNenkinHosyouYear(), "", "年金保証年");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getNenkinKbn(), "", "年金区分");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHaitouKbn(), "準有配当", "配当区分");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getSinsaKbn(), "", "診査区分");
        exNumericEquals(webKykNaiyouSyoukaiInfoBean.getTksuu(), 5, "特約数");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getLivingneedsTkhyj(), "", "リビングニーズ特約表示");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHokenMankiDay(), "平成２８年　２月２８日", "保険満期日");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getSyunm(), "", "主契約名称");
        exBizCalcbleEquals(webKykNaiyouSyoukaiInfoBean.getSyus()
            , BizCurrency.valueOf(1002.00, BizCurrencyTypes.EURO), "主契約保険金額");
        Assert.assertEquals(webKykNaiyouSyoukaiInfoBean.getSyus().getType(), BizCurrencyTypes.EURO);
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getSyuhknkkn(), "", "主契約保険期間");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getSyuhrkkkn(), "", "主契約払込期間");
        exNumericEquals(webKykNaiyouSyoukaiInfoBean.getTkNaiyouGyousuu(), 5, "特約内容行数");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTknm1(), "保険料円貨払込特約", "特約名称１");
        exBizCalcbleEquals(webKykNaiyouSyoukaiInfoBean.getTks1(), BizCurrency.optional(), "特約保険金額１");
        Assert.assertEquals(webKykNaiyouSyoukaiInfoBean.getTks1().getType()
            , BizNumberConfig.instance.getDefaultCurrencyType());
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTokuyakuhokenkikan1(), "", "特約保険期間１");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTokuyakuharaikomikikan1(), "", "特約払込期間１");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTknm2(), "保険料指定外通貨払込特約", "特約名称２");
        exBizCalcbleEquals(webKykNaiyouSyoukaiInfoBean.getTks2(), BizCurrency.optional(), "特約保険金額２");
        Assert.assertEquals(webKykNaiyouSyoukaiInfoBean.getTks2().getType()
            , BizNumberConfig.instance.getDefaultCurrencyType());
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTokuyakuhokenkikan2(), "", "特約保険期間２");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTokuyakuharaikomikikan2(), "", "特約払込期間２");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTknm3(), "目標到達時円建年金保険変更特約　指定なし", "特約名称３");
        exBizCalcbleEquals(webKykNaiyouSyoukaiInfoBean.getTks3(), BizCurrency.optional(), "特約保険金額３");
        Assert.assertEquals(webKykNaiyouSyoukaiInfoBean.getTks3().getType()
            , BizNumberConfig.instance.getDefaultCurrencyType());
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTokuyakuhokenkikan3(), "", "特約保険期間３");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTokuyakuharaikomikikan3(), "", "特約払込期間３");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTknm4(), "保険契約者代理特約", "特約名称４");
        exBizCalcbleEquals(webKykNaiyouSyoukaiInfoBean.getTks4(), BizCurrency.optional(), "特約保険金額４");
        Assert.assertEquals(webKykNaiyouSyoukaiInfoBean.getTks4().getType()
            , BizNumberConfig.instance.getDefaultCurrencyType());
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTokuyakuhokenkikan4(), "", "特約保険期間４");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTokuyakuharaikomikikan4(), "", "特約払込期間４");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTknm5(), "指定代理請求特約", "特約名称５");
        exBizCalcbleEquals(webKykNaiyouSyoukaiInfoBean.getTks5(), BizCurrency.optional(), "特約保険金額５");
        Assert.assertEquals(webKykNaiyouSyoukaiInfoBean.getTks5().getType()
            , BizNumberConfig.instance.getDefaultCurrencyType());
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTokuyakuhokenkikan5(), "", "特約保険期間５");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTokuyakuharaikomikikan5(), "", "特約払込期間５");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTknm6(), "", "特約名称６");
        exBizCalcbleEquals(webKykNaiyouSyoukaiInfoBean.getTks6(), BizCurrency.optional(), "特約保険金額６");
        Assert.assertEquals(webKykNaiyouSyoukaiInfoBean.getTks6().getType()
            , BizNumberConfig.instance.getDefaultCurrencyType());
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTokuyakuhokenkikan6(), "", "特約保険期間６");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTokuyakuharaikomikikan6(), "", "特約払込期間６");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTknm7(), "", "特約名称７");
        exBizCalcbleEquals(webKykNaiyouSyoukaiInfoBean.getTks7(), BizCurrency.optional(), "特約保険金額７");
        Assert.assertEquals(webKykNaiyouSyoukaiInfoBean.getTks7().getType()
            , BizNumberConfig.instance.getDefaultCurrencyType());
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTokuyakuhokenkikan7(), "", "特約保険期間７");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTokuyakuharaikomikikan7(), "", "特約払込期間７");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTknm8(), "", "特約名称８");
        exBizCalcbleEquals(webKykNaiyouSyoukaiInfoBean.getTks8(), BizCurrency.optional(), "特約保険金額８");
        Assert.assertEquals(webKykNaiyouSyoukaiInfoBean.getTks8().getType()
            , BizNumberConfig.instance.getDefaultCurrencyType());
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTokuyakuhokenkikan8(), "", "特約保険期間８");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTokuyakuharaikomikikan8(), "", "特約払込期間８");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTknm9(), "", "特約名称９");
        exBizCalcbleEquals(webKykNaiyouSyoukaiInfoBean.getTks9(), BizCurrency.optional(), "特約保険金額９");
        Assert.assertEquals(webKykNaiyouSyoukaiInfoBean.getTks9().getType()
            , BizNumberConfig.instance.getDefaultCurrencyType());
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTokuyakuhokenkikan9(), "", "特約保険期間９");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTokuyakuharaikomikikan9(), "", "特約払込期間９");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTknm10(), "", "特約名称１０");
        exBizCalcbleEquals(webKykNaiyouSyoukaiInfoBean.getTks10(), BizCurrency.optional(), "特約保険金額１０");
        Assert.assertEquals(webKykNaiyouSyoukaiInfoBean.getTks10().getType()
            , BizNumberConfig.instance.getDefaultCurrencyType());
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTokuyakuhokenkikan10(), "", "特約保険期間１０");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTokuyakuharaikomikikan10(), "", "特約払込期間１０");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTknm11(), "", "特約名称１１");
        exBizCalcbleEquals(webKykNaiyouSyoukaiInfoBean.getTks11(), BizCurrency.optional(), "特約保険金額１１");
        Assert.assertEquals(webKykNaiyouSyoukaiInfoBean.getTks11().getType()
            , BizNumberConfig.instance.getDefaultCurrencyType());
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTokuyakuhokenkikan11(), "", "特約保険期間１１");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTokuyakuharaikomikikan11(), "", "特約払込期間１１");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTknm12(), "", "特約名称１２");
        exBizCalcbleEquals(webKykNaiyouSyoukaiInfoBean.getTks12(), BizCurrency.optional(), "特約保険金額１２");
        Assert.assertEquals(webKykNaiyouSyoukaiInfoBean.getTks12().getType()
            , BizNumberConfig.instance.getDefaultCurrencyType());
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTokuyakuhokenkikan12(), "", "特約保険期間１２");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTokuyakuharaikomikikan12(), "", "特約払込期間１２");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTknm13(), "", "特約名称１３");
        exBizCalcbleEquals(webKykNaiyouSyoukaiInfoBean.getTks13(), BizCurrency.optional(), "特約保険金額１３");
        Assert.assertEquals(webKykNaiyouSyoukaiInfoBean.getTks13().getType()
            , BizNumberConfig.instance.getDefaultCurrencyType());
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTokuyakuhokenkikan13(), "", "特約保険期間１３");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTokuyakuharaikomikikan13(), "", "特約払込期間１３");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTknm14(), "", "特約名称１４");
        exBizCalcbleEquals(webKykNaiyouSyoukaiInfoBean.getTks14(), BizCurrency.optional(), "特約保険金額１４");
        Assert.assertEquals(webKykNaiyouSyoukaiInfoBean.getTks14().getType()
            , BizNumberConfig.instance.getDefaultCurrencyType());
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTokuyakuhokenkikan14(), "", "特約保険期間１４");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTokuyakuharaikomikikan14(), "", "特約払込期間１４");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTknm15(), "", "特約名称１５");
        exBizCalcbleEquals(webKykNaiyouSyoukaiInfoBean.getTks15(), BizCurrency.optional(), "特約保険金額１５");
        Assert.assertEquals(webKykNaiyouSyoukaiInfoBean.getTks15().getType()
            , BizNumberConfig.instance.getDefaultCurrencyType());
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTokuyakuhokenkikan15(), "", "特約保険期間１５");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTokuyakuharaikomikikan15(), "", "特約払込期間１５");
        exNumericEquals(webKykNaiyouSyoukaiInfoBean.getSyouhnNaiyouGyousuu(), 1, "商品内容行数");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getSyouhnNaiyou1(), "現在の保障内容は下記のとおりです。", "商品内容１");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getSyouhnNaiyou2(), "", "商品内容２");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getSyouhnNaiyou3(), "", "商品内容３");
        exNumericEquals(webKykNaiyouSyoukaiInfoBean.getHosyouNaiyouGyousuu(), 15, "保障内容行数");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHosyouNaiyou1(), "死亡時支払金受取人　契約者　様", "保障内容１");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHosyouNaiyou2(), "契約者代理人　　　　ケイダイメイ　１－２４　様　　　　　　　　　生年月日　平成１３年　１月　１日", "保障内容２");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHosyouNaiyou3(), "指定代理請求人　　　シテイトクテイメイギ１－２４　様　　　　", "保障内容３");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHosyouNaiyou4(), "死亡時（照会日時点）　　　　１０，０００．００ユーロ　　（１００円）", "保障内容４");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHosyouNaiyou5(), "解約返戻金額（照会日時点）　１，０００．００ユーロ　　（１００円）", "保障内容５");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHosyouNaiyou6(), "積立金額（照会日時点）　１，０００．００ユーロ　　（１００円）", "保障内容６");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHosyouNaiyou7(), "上記（）内の金額は、照会時点の為替レートで円換算した参考値であり変動します。", "保障内容７");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHosyouNaiyou8(), "保険法対応契約", "保障内容８");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHosyouNaiyou9(), "保険料円貨払込特約あり　　　　　加入時保険料入金額　　　１，２３０．００円", "保障内容９");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHosyouNaiyou10(), "　保険料領収日時点の払込特約レート　１ユーロ＝１円（平成２９年　７月　１日）", "保障内容１０");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHosyouNaiyou11(), "保険料指定外通貨払込特約あり　　加入時保険料入金額　　１，２３０．００米ドル", "保障内容１１");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHosyouNaiyou12(), "　保険料領収日時点の払込特約レート　１ユーロ＝１米ドル（平成２９年　７月　１日）", "保障内容１２");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHosyouNaiyou13(), "保険契約者代理特約あり", "保障内容１３");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHosyouNaiyou14(), "指定代理請求特約あり", "保障内容１４");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHosyouNaiyou15(), "目標到達時円建年金保険変更特約あり　　　　　（目標額割合　指定なし）", "保障内容１５");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHosyouNaiyou16(), "", "保障内容１６");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHosyouNaiyou17(), "", "保障内容１７");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHosyouNaiyou18(), "", "保障内容１８");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHosyouNaiyou19(), "", "保障内容１９");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHosyouNaiyou20(), "", "保障内容２０");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHosyouNaiyou21(), "", "保障内容２１");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHosyouNaiyou22(), "", "保障内容２２");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHosyouNaiyou23(), "", "保障内容２３");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHosyouNaiyou24(), "", "保障内容２４");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHosyouNaiyou25(), "", "保障内容２５");
        exNumericEquals(webKykNaiyouSyoukaiInfoBean.getHenkouKeiiGyousuu(), 1, "変更経緯行数");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHenkouKeii1(), "平成２７年１２月　１日　契約内容変更", "変更経緯１");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHenkouKeii2(), "", "変更経緯２");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHenkouKeii3(), "", "変更経緯３");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHenkouKeii4(), "", "変更経緯４");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHenkouKeii5(), "", "変更経緯５");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHenkouKeii6(), "", "変更経緯６");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHenkouKeii7(), "", "変更経緯７");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHenkouKeii8(), "", "変更経緯８");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHenkouKeii9(), "", "変更経緯９");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHenkouKeii10(), "", "変更経緯１０");
        exNumericEquals(webKykNaiyouSyoukaiInfoBean.getBosyuDrtenGyousuu(), 2, "募集代理店行数");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getBosyuDrtenNm1(), "取扱代理店名３", "募集代理店名１");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getDrtenBnwari1(), "", "代理店分割割合１");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getBosyuDrtenNm2(), "取扱代理店名３", "募集代理店名２");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getDrtenBnwari2(), "", "代理店分割割合２");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getMsgOutKbn(), "2", "MSG出力区分");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHosyouIkkatuMinaokeiyakuHyouji(), "0", "保障一括見直契約表示");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHhknnmkn(), "ﾋﾎｹﾝｼｶﾅ", "被保険者氏名(ｶﾅ)");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHokenryouSyuunouJyoukyou(), "正常収納中", "保険料収納状況");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getJikaiHokenryouJyuutouYm(), "平成２８年　６月", "次回保険料充当年月");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getMdhansybetuKbn(), "01", "窓販種別区分");
    }

    @Test
    @TestOrder(370)
    public void testExec_A37() {
        changeSystemDate();

        MockObjectManager.initialize();
        BzGetProcessSummaryMockForHozen.SYORIPTN = BzGetProcessSummaryMockForHozen.TESTPATTERN2;
        BzGetAdrDataMockForHozen.SYORIPTN = BzGetAdrDataMockForHozen.TESTPATTERN1;
        CalcHkShrKngkMockForHozen.SYORIPTN = CalcHkShrKngkMockForHozen.TESTPATTERN4;
        KeisanWExtMockForHozen.SYORIPTN = KeisanWExtMockForHozen.TESTPATTERN2;
        KeisanWMockForHozen.SYORIPTN = KeisanWMockForHozen.TESTPATTERN1;
        KeisanKijyungkMockForHozen.SYORIPTN = KeisanKijyungkMockForHozen.TESTPATTERN2;
        KeisanGaikakanzanMockForHozen.SYORIPTN = KeisanGaikakanzanMockForHozen.TESTPATTERN1;
        SetNenreiMockForHozen.SYORIPTN = SetNenreiMockForHozen.TESTPATTERN1;

        WebKykNaiyouSyoukaiInfoBean webKykNaiyouSyoukaiInfoBean =
            hbKeiyakuSyoukai.exec("31809111512", BizDate.valueOf("20160621"), C_TanmatuSiyouKbn.SOUGOU_IPPAN,"A10010");

        exStringEquals(webKykNaiyouSyoukaiInfoBean.getErrorKbn(), "", "エラー区分");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getErrorMsg(), "", "エラーメッセージ");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getKyknmkn(), "ｶﾅ", "契約者名（カナ）");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getKyknmkj(), "契約者名漢字１－２５　様", "契約者名（漢字）");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getKykseiymd(), "昭和５５年　１月　１日", "契約者生年月日");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getKojinhjnKbn(), "個人", "個人法人区分");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTelno(), "010-1234-5678", "電話番号");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getPostalCd(), "１２３－４５６７", "郵便番号");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getAdr(), "通信先住所１通信先住所２通信先住所３", "住所");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getAdrkn(), "ｶﾅｶﾅｶﾅｶﾅ", "住所(ｶﾅ)");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHhknnm(), "被保険者名　様", "被保険者氏名");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHhknsei(), "男性", "被保険者性別");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHhknseiymd(), "昭和５５年　１月　１日", "被保険者生年月日");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHhknNen(), "３５歳", "被保険者年齢");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHhknKykjiNen(), "２５歳", "被保険者契約時年齢");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getSyouhnnm(), "笑顔の約束", "商品名");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getSyurui(), "終身保険", "種類");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getSyono(), "31809111512", "証券番号");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getCifCd(), "*****", "CIFｺｰﾄﾞ");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getKykymd(), "平成　７年　１月　１日", "契約日");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHrkhou(), "一時払", "払込方法");
        exBizCalcbleEquals(webKykNaiyouSyoukaiInfoBean.getSibous()
            , BizCurrency.valueOf(10000.00, BizCurrencyTypes.AU_DOLLAR) , "死亡保険金");
        Assert.assertEquals(webKykNaiyouSyoukaiInfoBean.getSibous().getType(), BizCurrencyTypes.AU_DOLLAR);
        exBizCalcbleEquals(webKykNaiyouSyoukaiInfoBean.getHrkp()
            , BizCurrency.valueOf(1001.00, BizCurrencyTypes.DOLLAR), "払込保険料");
        Assert.assertEquals(webKykNaiyouSyoukaiInfoBean.getHrkp().getType(), BizCurrencyTypes.DOLLAR);
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getNkShrStartYmd(), "平成２９年　１月　１日", "年金支払開始日");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getNenkinHosyouYear(), "", "年金保証年");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getNenkinKbn(), "", "年金区分");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHaitouKbn(), "準有配当", "配当区分");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getSinsaKbn(), "", "診査区分");
        exNumericEquals(webKykNaiyouSyoukaiInfoBean.getTksuu(), 2, "特約数");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getLivingneedsTkhyj(), "", "リビングニーズ特約表示");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHokenMankiDay(), "終身", "保険満期日");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getSyunm(), "終身保険", "主契約名称");
        exBizCalcbleEquals(webKykNaiyouSyoukaiInfoBean.getSyus()
            , BizCurrency.optional(), "主契約保険金額");
        Assert.assertEquals(webKykNaiyouSyoukaiInfoBean.getSyus().getType(), BizNumberConfig.instance.getDefaultCurrencyType());
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getSyuhknkkn(), "終身", "主契約保険期間");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getSyuhrkkkn(), "", "主契約払込期間");
        exNumericEquals(webKykNaiyouSyoukaiInfoBean.getTkNaiyouGyousuu(), 2, "特約内容行数");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTknm1(), "保険料円貨払込特約", "特約名称１");
        exBizCalcbleEquals(webKykNaiyouSyoukaiInfoBean.getTks1(), BizCurrency.optional(), "特約保険金額１");
        Assert.assertEquals(webKykNaiyouSyoukaiInfoBean.getTks1().getType()
            , BizNumberConfig.instance.getDefaultCurrencyType());
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTokuyakuhokenkikan1(), "", "特約保険期間１");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTokuyakuharaikomikikan1(), "", "特約払込期間１");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTknm2(), "保険料指定外通貨払込特約", "特約名称２");
        exBizCalcbleEquals(webKykNaiyouSyoukaiInfoBean.getTks2(), BizCurrency.optional(), "特約保険金額２");
        Assert.assertEquals(webKykNaiyouSyoukaiInfoBean.getTks2().getType()
            , BizNumberConfig.instance.getDefaultCurrencyType());
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTokuyakuhokenkikan2(), "", "特約保険期間２");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTokuyakuharaikomikikan2(), "", "特約払込期間２");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTknm3(), "", "特約名称３");
        exBizCalcbleEquals(webKykNaiyouSyoukaiInfoBean.getTks3(), BizCurrency.optional(), "特約保険金額３");
        Assert.assertEquals(webKykNaiyouSyoukaiInfoBean.getTks3().getType()
            , BizNumberConfig.instance.getDefaultCurrencyType());
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTokuyakuhokenkikan3(), "", "特約保険期間３");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTokuyakuharaikomikikan3(), "", "特約払込期間３");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTknm4(), "", "特約名称４");
        exBizCalcbleEquals(webKykNaiyouSyoukaiInfoBean.getTks4(), BizCurrency.optional(), "特約保険金額４");
        Assert.assertEquals(webKykNaiyouSyoukaiInfoBean.getTks4().getType()
            , BizNumberConfig.instance.getDefaultCurrencyType());
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTokuyakuhokenkikan4(), "", "特約保険期間４");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTokuyakuharaikomikikan4(), "", "特約払込期間４");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTknm5(), "", "特約名称５");
        exBizCalcbleEquals(webKykNaiyouSyoukaiInfoBean.getTks5(), BizCurrency.optional(), "特約保険金額５");
        Assert.assertEquals(webKykNaiyouSyoukaiInfoBean.getTks5().getType()
            , BizNumberConfig.instance.getDefaultCurrencyType());
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTokuyakuhokenkikan5(), "", "特約保険期間５");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTokuyakuharaikomikikan5(), "", "特約払込期間５");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTknm6(), "", "特約名称６");
        exBizCalcbleEquals(webKykNaiyouSyoukaiInfoBean.getTks6(), BizCurrency.optional(), "特約保険金額６");
        Assert.assertEquals(webKykNaiyouSyoukaiInfoBean.getTks6().getType()
            , BizNumberConfig.instance.getDefaultCurrencyType());
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTokuyakuhokenkikan6(), "", "特約保険期間６");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTokuyakuharaikomikikan6(), "", "特約払込期間６");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTknm7(), "", "特約名称７");
        exBizCalcbleEquals(webKykNaiyouSyoukaiInfoBean.getTks7(), BizCurrency.optional(), "特約保険金額７");
        Assert.assertEquals(webKykNaiyouSyoukaiInfoBean.getTks7().getType()
            , BizNumberConfig.instance.getDefaultCurrencyType());
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTokuyakuhokenkikan7(), "", "特約保険期間７");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTokuyakuharaikomikikan7(), "", "特約払込期間７");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTknm8(), "", "特約名称８");
        exBizCalcbleEquals(webKykNaiyouSyoukaiInfoBean.getTks8(), BizCurrency.optional(), "特約保険金額８");
        Assert.assertEquals(webKykNaiyouSyoukaiInfoBean.getTks8().getType()
            , BizNumberConfig.instance.getDefaultCurrencyType());
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTokuyakuhokenkikan8(), "", "特約保険期間８");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTokuyakuharaikomikikan8(), "", "特約払込期間８");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTknm9(), "", "特約名称９");
        exBizCalcbleEquals(webKykNaiyouSyoukaiInfoBean.getTks9(), BizCurrency.optional(), "特約保険金額９");
        Assert.assertEquals(webKykNaiyouSyoukaiInfoBean.getTks9().getType()
            , BizNumberConfig.instance.getDefaultCurrencyType());
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTokuyakuhokenkikan9(), "", "特約保険期間９");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTokuyakuharaikomikikan9(), "", "特約払込期間９");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTknm10(), "", "特約名称１０");
        exBizCalcbleEquals(webKykNaiyouSyoukaiInfoBean.getTks10(), BizCurrency.optional(), "特約保険金額１０");
        Assert.assertEquals(webKykNaiyouSyoukaiInfoBean.getTks10().getType()
            , BizNumberConfig.instance.getDefaultCurrencyType());
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTokuyakuhokenkikan10(), "", "特約保険期間１０");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTokuyakuharaikomikikan10(), "", "特約払込期間１０");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTknm11(), "", "特約名称１１");
        exBizCalcbleEquals(webKykNaiyouSyoukaiInfoBean.getTks11(), BizCurrency.optional(), "特約保険金額１１");
        Assert.assertEquals(webKykNaiyouSyoukaiInfoBean.getTks11().getType()
            , BizNumberConfig.instance.getDefaultCurrencyType());
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTokuyakuhokenkikan11(), "", "特約保険期間１１");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTokuyakuharaikomikikan11(), "", "特約払込期間１１");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTknm12(), "", "特約名称１２");
        exBizCalcbleEquals(webKykNaiyouSyoukaiInfoBean.getTks12(), BizCurrency.optional(), "特約保険金額１２");
        Assert.assertEquals(webKykNaiyouSyoukaiInfoBean.getTks12().getType()
            , BizNumberConfig.instance.getDefaultCurrencyType());
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTokuyakuhokenkikan12(), "", "特約保険期間１２");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTokuyakuharaikomikikan12(), "", "特約払込期間１２");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTknm13(), "", "特約名称１３");
        exBizCalcbleEquals(webKykNaiyouSyoukaiInfoBean.getTks13(), BizCurrency.optional(), "特約保険金額１３");
        Assert.assertEquals(webKykNaiyouSyoukaiInfoBean.getTks13().getType()
            , BizNumberConfig.instance.getDefaultCurrencyType());
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTokuyakuhokenkikan13(), "", "特約保険期間１３");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTokuyakuharaikomikikan13(), "", "特約払込期間１３");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTknm14(), "", "特約名称１４");
        exBizCalcbleEquals(webKykNaiyouSyoukaiInfoBean.getTks14(), BizCurrency.optional(), "特約保険金額１４");
        Assert.assertEquals(webKykNaiyouSyoukaiInfoBean.getTks14().getType()
            , BizNumberConfig.instance.getDefaultCurrencyType());
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTokuyakuhokenkikan14(), "", "特約保険期間１４");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTokuyakuharaikomikikan14(), "", "特約払込期間１４");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTknm15(), "", "特約名称１５");
        exBizCalcbleEquals(webKykNaiyouSyoukaiInfoBean.getTks15(), BizCurrency.optional(), "特約保険金額１５");
        Assert.assertEquals(webKykNaiyouSyoukaiInfoBean.getTks15().getType()
            , BizNumberConfig.instance.getDefaultCurrencyType());
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTokuyakuhokenkikan15(), "", "特約保険期間１５");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTokuyakuharaikomikikan15(), "", "特約払込期間１５");
        exNumericEquals(webKykNaiyouSyoukaiInfoBean.getSyouhnNaiyouGyousuu(), 1, "商品内容行数");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getSyouhnNaiyou1(), "現在の保障内容は下記のとおりです。", "商品内容１");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getSyouhnNaiyou2(), "", "商品内容２");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getSyouhnNaiyou3(), "", "商品内容３");
        exNumericEquals(webKykNaiyouSyoukaiInfoBean.getHosyouNaiyouGyousuu(), 14, "保障内容行数");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHosyouNaiyou1(), "死亡時支払金受取人　契約者　様", "保障内容１");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHosyouNaiyou2(), "年金受取人　　　　　契約者　様", "保障内容２");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHosyouNaiyou3(), "定率増加部分繰り入れ割合　１００％", "保障内容３");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHosyouNaiyou4(), "死亡時", "保障内容４");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHosyouNaiyou5(), "第３保険期間（照会日時点）　　　　　　　　　　　１０，０００．００豪ドル", "保障内容５");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHosyouNaiyou6(), "　　　　　　　　　　　　　　　　　　　　　　　　（１００円）", "保障内容６");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHosyouNaiyou7(), "解約返戻金額（照会日時点）　１，０００．００豪ドル　　（１００円）", "保障内容７");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHosyouNaiyou8(), "積立金額（照会日時点）　１，０００．００豪ドル　　（１００円）", "保障内容８");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHosyouNaiyou9(), "上記（）内の金額は、照会時点の為替レートで円換算した参考値であり変動します。", "保障内容９");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHosyouNaiyou10(), "保険法対応契約", "保障内容１０");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHosyouNaiyou11(), "保険料円貨払込特約あり　　　　　加入時保険料入金額　　　１，２３０円", "保障内容１１");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHosyouNaiyou12(), "　保険料領収日時点の払込特約レート　１豪ドル＝１円（平成２９年　７月　１日）", "保障内容１２");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHosyouNaiyou13(), "保険料指定外通貨払込特約あり　　加入時保険料入金額　　１，２３０円", "保障内容１３");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHosyouNaiyou14(), "　保険料領収日時点の払込特約レート　１豪ドル＝１円（平成２９年　７月　１日）", "保障内容１４");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHosyouNaiyou15(), "", "保障内容１５");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHosyouNaiyou16(), "", "保障内容１６");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHosyouNaiyou17(), "", "保障内容１７");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHosyouNaiyou18(), "", "保障内容１８");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHosyouNaiyou19(), "", "保障内容１９");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHosyouNaiyou20(), "", "保障内容２０");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHosyouNaiyou21(), "", "保障内容２１");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHosyouNaiyou22(), "", "保障内容２２");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHosyouNaiyou23(), "", "保障内容２３");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHosyouNaiyou24(), "", "保障内容２４");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHosyouNaiyou25(), "", "保障内容２５");
        exNumericEquals(webKykNaiyouSyoukaiInfoBean.getHenkouKeiiGyousuu(), 1, "変更経緯行数");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHenkouKeii1(), "＊＊＊＊＊", "変更経緯１");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHenkouKeii2(), "", "変更経緯２");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHenkouKeii3(), "", "変更経緯３");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHenkouKeii4(), "", "変更経緯４");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHenkouKeii5(), "", "変更経緯５");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHenkouKeii6(), "", "変更経緯６");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHenkouKeii7(), "", "変更経緯７");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHenkouKeii8(), "", "変更経緯８");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHenkouKeii9(), "", "変更経緯９");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHenkouKeii10(), "", "変更経緯１０");
        exNumericEquals(webKykNaiyouSyoukaiInfoBean.getBosyuDrtenGyousuu(), 2, "募集代理店行数");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getBosyuDrtenNm1(), "取扱代理店名３", "募集代理店名１");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getDrtenBnwari1(), "", "代理店分割割合１");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getBosyuDrtenNm2(), "取扱代理店名３", "募集代理店名２");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getDrtenBnwari2(), "", "代理店分割割合２");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getMsgOutKbn(), "2", "MSG出力区分");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHosyouIkkatuMinaokeiyakuHyouji(), "0", "保障一括見直契約表示");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHhknnmkn(), "ﾋﾎｹﾝｼｶﾅ", "被保険者氏名(ｶﾅ)");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHokenryouSyuunouJyoukyou(), "－", "保険料収納状況");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getJikaiHokenryouJyuutouYm(), "－", "次回保険料充当年月");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getMdhansybetuKbn(), "01", "窓販種別区分");
    }

    @Test
    @TestOrder(380)
    public void testExec_A38() {
        changeSystemDate();

        MockObjectManager.initialize();
        BzGetProcessSummaryMockForHozen.SYORIPTN = BzGetProcessSummaryMockForHozen.TESTPATTERN2;
        BzGetAdrDataMockForHozen.SYORIPTN = BzGetAdrDataMockForHozen.TESTPATTERN1;
        CalcHkShrKngkMockForHozen.SYORIPTN = CalcHkShrKngkMockForHozen.TESTPATTERN4;
        KeisanWExtMockForHozen.SYORIPTN = KeisanWExtMockForHozen.TESTPATTERN2;
        KeisanWMockForHozen.SYORIPTN = KeisanWMockForHozen.TESTPATTERN1;
        KeisanKijyungkMockForHozen.SYORIPTN = KeisanKijyungkMockForHozen.TESTPATTERN2;
        KeisanGaikakanzanMockForHozen.SYORIPTN = KeisanGaikakanzanMockForHozen.TESTPATTERN1;
        SetNenreiMockForHozen.SYORIPTN = SetNenreiMockForHozen.TESTPATTERN1;


        WebKykNaiyouSyoukaiInfoBean webKykNaiyouSyoukaiInfoBean =
            hbKeiyakuSyoukai.exec("31809111523", BizDate.valueOf("20160621"), C_TanmatuSiyouKbn.SOUGOU_IPPAN,"A10010");

        exStringEquals(webKykNaiyouSyoukaiInfoBean.getErrorKbn(), "", "エラー区分");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getErrorMsg(), "", "エラーメッセージ");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getKyknmkn(), "ｶﾅ", "契約者名（カナ）");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getKyknmkj(), "契約者名漢字１－２６　様", "契約者名（漢字）");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getKykseiymd(), "昭和５５年　１月　１日", "契約者生年月日");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getKojinhjnKbn(), "個人", "個人法人区分");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTelno(), "010-1234-5678", "電話番号");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getPostalCd(), "１２３－４５６７", "郵便番号");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getAdr(), "通信先住所１通信先住所２通信先住所３", "住所");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getAdrkn(), "ｶﾅｶﾅｶﾅｶﾅ", "住所(ｶﾅ)");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHhknnm(), "被保険者名　様", "被保険者氏名");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHhknsei(), "男性", "被保険者性別");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHhknseiymd(), "昭和５５年　１月　１日", "被保険者生年月日");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHhknNen(), "３５歳", "被保険者年齢");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHhknKykjiNen(), "２５歳", "被保険者契約時年齢");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getSyouhnnm(), "たのしみステップ", "商品名");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getSyurui(), "年金保険", "種類");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getSyono(), "31809111523", "証券番号");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getCifCd(), "*****", "CIFｺｰﾄﾞ");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getKykymd(), "平成２８年　６月２０日", "契約日");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHrkhou(), "一時払", "払込方法");
        exBizCalcbleEquals(webKykNaiyouSyoukaiInfoBean.getSibous()
            , BizCurrency.valueOf(10000.00, BizCurrencyTypes.AU_DOLLAR) , "死亡保険金");
        Assert.assertEquals(webKykNaiyouSyoukaiInfoBean.getSibous().getType(), BizCurrencyTypes.AU_DOLLAR);
        exBizCalcbleEquals(webKykNaiyouSyoukaiInfoBean.getHrkp()
            , BizCurrency.valueOf(1001.00, BizCurrencyTypes.DOLLAR), "払込保険料");
        Assert.assertEquals(webKykNaiyouSyoukaiInfoBean.getHrkp().getType(), BizCurrencyTypes.DOLLAR);
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getNkShrStartYmd(), "平成２８年　３月　１日", "年金支払開始日");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getNenkinHosyouYear(), "　９年", "年金保証年");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getNenkinKbn(), "確定年金", "年金区分");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHaitouKbn(), "準有配当", "配当区分");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getSinsaKbn(), "", "診査区分");
        exNumericEquals(webKykNaiyouSyoukaiInfoBean.getTksuu(), 7, "特約数");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getLivingneedsTkhyj(), "", "リビングニーズ特約表示");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHokenMankiDay(), "平成２８年　２月２９日", "保険満期日");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getSyunm(), "個人年金", "主契約名称");
        exBizCalcbleEquals(webKykNaiyouSyoukaiInfoBean.getSyus()
            , BizCurrency.optional(), "主契約保険金額");
        Assert.assertEquals(webKykNaiyouSyoukaiInfoBean.getSyus().getType(), BizNumberConfig.instance.getDefaultCurrencyType());
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getSyuhknkkn(), "１０年間", "主契約保険期間");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getSyuhrkkkn(), "", "主契約払込期間");
        exNumericEquals(webKykNaiyouSyoukaiInfoBean.getTkNaiyouGyousuu(), 7, "特約内容行数");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTknm1(), "重度介護前払特約", "特約名称１");
        exBizCalcbleEquals(webKykNaiyouSyoukaiInfoBean.getTks1(), BizCurrency.optional(), "特約保険金額１");
        Assert.assertEquals(webKykNaiyouSyoukaiInfoBean.getTks1().getType()
            , BizNumberConfig.instance.getDefaultCurrencyType());
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTokuyakuhokenkikan1(), "", "特約保険期間１");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTokuyakuharaikomikikan1(), "", "特約払込期間１");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTknm2(), "初期死亡時円換算支払額最低保証特約", "特約名称２");
        exBizCalcbleEquals(webKykNaiyouSyoukaiInfoBean.getTks2(), BizCurrency.optional(), "特約保険金額２");
        Assert.assertEquals(webKykNaiyouSyoukaiInfoBean.getTks2().getType()
            , BizNumberConfig.instance.getDefaultCurrencyType());
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTokuyakuhokenkikan2(), "", "特約保険期間２");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTokuyakuharaikomikikan2(), "", "特約払込期間２");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTknm3(), "保険料円貨払込特約", "特約名称３");
        exBizCalcbleEquals(webKykNaiyouSyoukaiInfoBean.getTks3(), BizCurrency.optional(), "特約保険金額３");
        Assert.assertEquals(webKykNaiyouSyoukaiInfoBean.getTks3().getType()
            , BizNumberConfig.instance.getDefaultCurrencyType());
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTokuyakuhokenkikan3(), "", "特約保険期間３");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTokuyakuharaikomikikan3(), "", "特約払込期間３");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTknm4(), "保険料指定外通貨払込特約", "特約名称４");
        exBizCalcbleEquals(webKykNaiyouSyoukaiInfoBean.getTks4(), BizCurrency.optional(), "特約保険金額４");
        Assert.assertEquals(webKykNaiyouSyoukaiInfoBean.getTks4().getType()
            , BizNumberConfig.instance.getDefaultCurrencyType());
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTokuyakuhokenkikan4(), "", "特約保険期間４");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTokuyakuharaikomikikan4(), "", "特約払込期間４");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTknm5(), "目標到達時円建終身保険変更特約　１％", "特約名称５");
        exBizCalcbleEquals(webKykNaiyouSyoukaiInfoBean.getTks5(), BizCurrency.optional(), "特約保険金額５");
        Assert.assertEquals(webKykNaiyouSyoukaiInfoBean.getTks5().getType()
            , BizNumberConfig.instance.getDefaultCurrencyType());
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTokuyakuhokenkikan5(), "", "特約保険期間５");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTokuyakuharaikomikikan5(), "", "特約払込期間５");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTknm6(), "保険契約者代理特約", "特約名称６");
        exBizCalcbleEquals(webKykNaiyouSyoukaiInfoBean.getTks6(), BizCurrency.optional(), "特約保険金額６");
        Assert.assertEquals(webKykNaiyouSyoukaiInfoBean.getTks6().getType()
            , BizNumberConfig.instance.getDefaultCurrencyType());
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTokuyakuhokenkikan6(), "", "特約保険期間６");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTokuyakuharaikomikikan6(), "", "特約払込期間６");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTknm7(), "指定代理請求特約", "特約名称７");
        exBizCalcbleEquals(webKykNaiyouSyoukaiInfoBean.getTks7(), BizCurrency.optional(), "特約保険金額７");
        Assert.assertEquals(webKykNaiyouSyoukaiInfoBean.getTks7().getType()
            , BizNumberConfig.instance.getDefaultCurrencyType());
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTokuyakuhokenkikan7(), "", "特約保険期間７");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTokuyakuharaikomikikan7(), "", "特約払込期間７");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTknm8(), "", "特約名称８");
        exBizCalcbleEquals(webKykNaiyouSyoukaiInfoBean.getTks8(), BizCurrency.optional(), "特約保険金額８");
        Assert.assertEquals(webKykNaiyouSyoukaiInfoBean.getTks8().getType()
            , BizNumberConfig.instance.getDefaultCurrencyType());
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTokuyakuhokenkikan8(), "", "特約保険期間８");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTokuyakuharaikomikikan8(), "", "特約払込期間８");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTknm9(), "", "特約名称９");
        exBizCalcbleEquals(webKykNaiyouSyoukaiInfoBean.getTks9(), BizCurrency.optional(), "特約保険金額９");
        Assert.assertEquals(webKykNaiyouSyoukaiInfoBean.getTks9().getType()
            , BizNumberConfig.instance.getDefaultCurrencyType());
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTokuyakuhokenkikan9(), "", "特約保険期間９");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTokuyakuharaikomikikan9(), "", "特約払込期間９");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTknm10(), "", "特約名称１０");
        exBizCalcbleEquals(webKykNaiyouSyoukaiInfoBean.getTks10(), BizCurrency.optional(), "特約保険金額１０");
        Assert.assertEquals(webKykNaiyouSyoukaiInfoBean.getTks10().getType()
            , BizNumberConfig.instance.getDefaultCurrencyType());
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTokuyakuhokenkikan10(), "", "特約保険期間１０");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTokuyakuharaikomikikan10(), "", "特約払込期間１０");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTknm11(), "", "特約名称１１");
        exBizCalcbleEquals(webKykNaiyouSyoukaiInfoBean.getTks11(), BizCurrency.optional(), "特約保険金額１１");
        Assert.assertEquals(webKykNaiyouSyoukaiInfoBean.getTks11().getType()
            , BizNumberConfig.instance.getDefaultCurrencyType());
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTokuyakuhokenkikan11(), "", "特約保険期間１１");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTokuyakuharaikomikikan11(), "", "特約払込期間１１");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTknm12(), "", "特約名称１２");
        exBizCalcbleEquals(webKykNaiyouSyoukaiInfoBean.getTks12(), BizCurrency.optional(), "特約保険金額１２");
        Assert.assertEquals(webKykNaiyouSyoukaiInfoBean.getTks12().getType()
            , BizNumberConfig.instance.getDefaultCurrencyType());
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTokuyakuhokenkikan12(), "", "特約保険期間１２");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTokuyakuharaikomikikan12(), "", "特約払込期間１２");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTknm13(), "", "特約名称１３");
        exBizCalcbleEquals(webKykNaiyouSyoukaiInfoBean.getTks13(), BizCurrency.optional(), "特約保険金額１３");
        Assert.assertEquals(webKykNaiyouSyoukaiInfoBean.getTks13().getType()
            , BizNumberConfig.instance.getDefaultCurrencyType());
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTokuyakuhokenkikan13(), "", "特約保険期間１３");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTokuyakuharaikomikikan13(), "", "特約払込期間１３");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTknm14(), "", "特約名称１４");
        exBizCalcbleEquals(webKykNaiyouSyoukaiInfoBean.getTks14(), BizCurrency.optional(), "特約保険金額１４");
        Assert.assertEquals(webKykNaiyouSyoukaiInfoBean.getTks14().getType()
            , BizNumberConfig.instance.getDefaultCurrencyType());
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTokuyakuhokenkikan14(), "", "特約保険期間１４");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTokuyakuharaikomikikan14(), "", "特約払込期間１４");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTknm15(), "", "特約名称１５");
        exBizCalcbleEquals(webKykNaiyouSyoukaiInfoBean.getTks15(), BizCurrency.optional(), "特約保険金額１５");
        Assert.assertEquals(webKykNaiyouSyoukaiInfoBean.getTks15().getType()
            , BizNumberConfig.instance.getDefaultCurrencyType());
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTokuyakuhokenkikan15(), "", "特約保険期間１５");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTokuyakuharaikomikikan15(), "", "特約払込期間１５");
        exNumericEquals(webKykNaiyouSyoukaiInfoBean.getSyouhnNaiyouGyousuu(), 1, "商品内容行数");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getSyouhnNaiyou1(), "現在の保障内容は下記のとおりです。", "商品内容１");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getSyouhnNaiyou2(), "", "商品内容２");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getSyouhnNaiyou3(), "", "商品内容３");
        exNumericEquals(webKykNaiyouSyoukaiInfoBean.getHosyouNaiyouGyousuu(),17, "保障内容行数");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHosyouNaiyou1(), "平成３０年　３月１６日　目標到達（目標値：１％）により円建年金保険に変更済", "保障内容１");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHosyouNaiyou2(), "　　　　　　　　　　　　到達金額　　　　　５０，０００円", "保障内容２");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHosyouNaiyou3(), "死亡時支払金受取人　シボウトクテイメイギ１－２６　様", "保障内容３");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHosyouNaiyou4(), "年金受取人　　　　　契約者　様", "保障内容４");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHosyouNaiyou5(), "契約者代理人　　　　ケイダイメイ　１－２６　様　　　　　　　", "保障内容５");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHosyouNaiyou6(), "指定代理請求人　　　シボウトクテイメイギ１－２６　様　　　　", "保障内容６");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHosyouNaiyou7(), "契約加入時しおり約款検索コード　０１－１９１２－２７６１", "保障内容７");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHosyouNaiyou8(), "約款受領方法　Ｗｅｂでの受取り（インターネット環境で確認）", "保障内容８");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHosyouNaiyou9(), "第３保険期間（照会日時点）　　　　　　　　　　　１０，０００円", "保障内容９");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHosyouNaiyou10(), "　　　　　　　　　　　　　　　　　　　　　　　　（円）", "保障内容１０");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHosyouNaiyou11(), "解約返戻金額（照会日時点）　１，０００円", "保障内容１１");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHosyouNaiyou12(), "積立金額（照会日時点）　１，０００円", "保障内容１２");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHosyouNaiyou13(), "保険法対応契約", "保障内容１３");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHosyouNaiyou14(), "重度介護前払特約あり", "保障内容１４");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHosyouNaiyou15(), "初期死亡時円換算支払額最低保証特約あり", "保障内容１５");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHosyouNaiyou16(), "保険契約者代理特約あり", "保障内容１６");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHosyouNaiyou17(), "指定代理請求特約あり", "保障内容１７");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHosyouNaiyou18(), "", "保障内容１８");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHosyouNaiyou19(), "", "保障内容１９");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHosyouNaiyou20(), "", "保障内容２０");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHosyouNaiyou21(), "", "保障内容２１");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHosyouNaiyou22(), "", "保障内容２２");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHosyouNaiyou23(), "", "保障内容２３");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHosyouNaiyou24(), "", "保障内容２４");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHosyouNaiyou25(), "", "保障内容２５");
        exNumericEquals(webKykNaiyouSyoukaiInfoBean.getHenkouKeiiGyousuu(), 2, "変更経緯行数");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHenkouKeii1(), "平成２７年１２月　１日　契約内容変更", "変更経緯１");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHenkouKeii2(), "平成２７年１２月　１日　契約内容変更", "変更経緯２");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHenkouKeii3(), "", "変更経緯３");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHenkouKeii4(), "", "変更経緯４");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHenkouKeii5(), "", "変更経緯５");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHenkouKeii6(), "", "変更経緯６");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHenkouKeii7(), "", "変更経緯７");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHenkouKeii8(), "", "変更経緯８");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHenkouKeii9(), "", "変更経緯９");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHenkouKeii10(), "", "変更経緯１０");
        exNumericEquals(webKykNaiyouSyoukaiInfoBean.getBosyuDrtenGyousuu(), 2, "募集代理店行数");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getBosyuDrtenNm1(), "取扱代理店名３", "募集代理店名１");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getDrtenBnwari1(), "", "代理店分割割合１");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getBosyuDrtenNm2(), "取扱代理店名３", "募集代理店名２");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getDrtenBnwari2(), "", "代理店分割割合２");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getMsgOutKbn(), "2", "MSG出力区分");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHosyouIkkatuMinaokeiyakuHyouji(), "0", "保障一括見直契約表示");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHhknnmkn(), "ﾋﾎｹﾝｼｶﾅ", "被保険者氏名(ｶﾅ)");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHokenryouSyuunouJyoukyou(), "－", "保険料収納状況");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getJikaiHokenryouJyuutouYm(), "－", "次回保険料充当年月");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getMdhansybetuKbn(), "01", "窓販種別区分");
    }

    @Test
    @TestOrder(390)
    public void testExec_A39() {
        changeSystemDate();

        MockObjectManager.initialize();
        BzGetProcessSummaryMockForHozen.SYORIPTN = BzGetProcessSummaryMockForHozen.TESTPATTERN2;
        BzGetAdrDataMockForHozen.SYORIPTN = BzGetAdrDataMockForHozen.TESTPATTERN1;
        CalcHkShrKngkMockForHozen.SYORIPTN = CalcHkShrKngkMockForHozen.TESTPATTERN4;
        KeisanWExtMockForHozen.SYORIPTN = KeisanWExtMockForHozen.TESTPATTERN2;
        KeisanWMockForHozen.SYORIPTN = KeisanWMockForHozen.TESTPATTERN1;
        KeisanKijyungkMockForHozen.SYORIPTN = KeisanKijyungkMockForHozen.TESTPATTERN2;
        KeisanGaikakanzanMockForHozen.SYORIPTN = KeisanGaikakanzanMockForHozen.TESTPATTERN1;
        SetNenreiMockForHozen.SYORIPTN = SetNenreiMockForHozen.TESTPATTERN1;

        WebKykNaiyouSyoukaiInfoBean webKykNaiyouSyoukaiInfoBean =
            hbKeiyakuSyoukai.exec("31809111534", BizDate.valueOf("20160621"), C_TanmatuSiyouKbn.SOUGOU_IPPAN,"A10010");

        exStringEquals(webKykNaiyouSyoukaiInfoBean.getErrorKbn(), "", "エラー区分");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getErrorMsg(), "", "エラーメッセージ");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getKyknmkn(), "ｶﾅ", "契約者名（カナ）");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getKyknmkj(), "契約者名漢字１－２７　様", "契約者名（漢字）");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getKykseiymd(), "昭和５５年　１月　１日", "契約者生年月日");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getKojinhjnKbn(), "個人", "個人法人区分");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTelno(), "010-1234-5678", "電話番号");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getPostalCd(), "１２３－４５６７", "郵便番号");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getAdr(), "通信先住所１通信先住所２通信先住所３", "住所");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getAdrkn(), "ｶﾅｶﾅｶﾅｶﾅ", "住所(ｶﾅ)");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHhknnm(), "被保険者名　様", "被保険者氏名");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHhknsei(), "男性", "被保険者性別");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHhknseiymd(), "昭和５５年　１月　１日", "被保険者生年月日");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHhknNen(), "３５歳", "被保険者年齢");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHhknKykjiNen(), "２５歳", "被保険者契約時年齢");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getSyouhnnm(), "たのしみステップ", "商品名");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getSyurui(), "年金保険", "種類");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getSyono(), "31809111534", "証券番号");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getCifCd(), "*****", "CIFｺｰﾄﾞ");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getKykymd(), "平成２８年　６月２１日", "契約日");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHrkhou(), "一時払", "払込方法");
        exBizCalcbleEquals(webKykNaiyouSyoukaiInfoBean.getSibous()
            , BizCurrency.valueOf(10000.00, BizCurrencyTypes.AU_DOLLAR) , "死亡保険金");
        Assert.assertEquals(webKykNaiyouSyoukaiInfoBean.getSibous().getType(), BizCurrencyTypes.AU_DOLLAR);
        exBizCalcbleEquals(webKykNaiyouSyoukaiInfoBean.getHrkp()
            , BizCurrency.valueOf(1001.00, BizCurrencyTypes.DOLLAR), "払込保険料");
        Assert.assertEquals(webKykNaiyouSyoukaiInfoBean.getHrkp().getType(), BizCurrencyTypes.DOLLAR);
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getNkShrStartYmd(), "平成２８年　２月２９日", "年金支払開始日");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getNenkinHosyouYear(), "１０年", "年金保証年");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getNenkinKbn(), "確定年金", "年金区分");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHaitouKbn(), "準有配当", "配当区分");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getSinsaKbn(), "", "診査区分");
        exNumericEquals(webKykNaiyouSyoukaiInfoBean.getTksuu(), 7, "特約数");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getLivingneedsTkhyj(), "", "リビングニーズ特約表示");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHokenMankiDay(), "平成２８年　２月２８日", "保険満期日");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getSyunm(), "個人年金", "主契約名称");
        exBizCalcbleEquals(webKykNaiyouSyoukaiInfoBean.getSyus()
            , BizCurrency.optional(), "主契約保険金額");
        Assert.assertEquals(webKykNaiyouSyoukaiInfoBean.getSyus().getType(), BizNumberConfig.instance.getDefaultCurrencyType());
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getSyuhknkkn(), "１１年間", "主契約保険期間");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getSyuhrkkkn(), "", "主契約払込期間");
        exNumericEquals(webKykNaiyouSyoukaiInfoBean.getTkNaiyouGyousuu(), 7, "特約内容行数");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTknm1(), "重度介護前払特約", "特約名称１");
        exBizCalcbleEquals(webKykNaiyouSyoukaiInfoBean.getTks1(), BizCurrency.optional(), "特約保険金額１");
        Assert.assertEquals(webKykNaiyouSyoukaiInfoBean.getTks1().getType()
            , BizNumberConfig.instance.getDefaultCurrencyType());
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTokuyakuhokenkikan1(), "", "特約保険期間１");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTokuyakuharaikomikikan1(), "", "特約払込期間１");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTknm2(), "初期死亡時円換算支払額最低保証特約", "特約名称２");
        exBizCalcbleEquals(webKykNaiyouSyoukaiInfoBean.getTks2(), BizCurrency.optional(), "特約保険金額２");
        Assert.assertEquals(webKykNaiyouSyoukaiInfoBean.getTks2().getType()
            , BizNumberConfig.instance.getDefaultCurrencyType());
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTokuyakuhokenkikan2(), "", "特約保険期間２");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTokuyakuharaikomikikan2(), "", "特約払込期間２");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTknm3(), "保険料円貨払込特約", "特約名称３");
        exBizCalcbleEquals(webKykNaiyouSyoukaiInfoBean.getTks3(), BizCurrency.optional(), "特約保険金額３");
        Assert.assertEquals(webKykNaiyouSyoukaiInfoBean.getTks3().getType()
            , BizNumberConfig.instance.getDefaultCurrencyType());
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTokuyakuhokenkikan3(), "", "特約保険期間３");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTokuyakuharaikomikikan3(), "", "特約払込期間３");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTknm4(), "保険料指定外通貨払込特約", "特約名称４");
        exBizCalcbleEquals(webKykNaiyouSyoukaiInfoBean.getTks4(), BizCurrency.optional(), "特約保険金額４");
        Assert.assertEquals(webKykNaiyouSyoukaiInfoBean.getTks4().getType()
            , BizNumberConfig.instance.getDefaultCurrencyType());
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTokuyakuhokenkikan4(), "", "特約保険期間４");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTokuyakuharaikomikikan4(), "", "特約払込期間４");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTknm5(), "目標到達時円建終身保険変更特約　指定なし", "特約名称５");
        exBizCalcbleEquals(webKykNaiyouSyoukaiInfoBean.getTks5(), BizCurrency.optional(), "特約保険金額５");
        Assert.assertEquals(webKykNaiyouSyoukaiInfoBean.getTks5().getType()
            , BizNumberConfig.instance.getDefaultCurrencyType());
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTokuyakuhokenkikan5(), "", "特約保険期間５");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTokuyakuharaikomikikan5(), "", "特約払込期間５");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTknm6(), "保険契約者代理特約", "特約名称６");
        exBizCalcbleEquals(webKykNaiyouSyoukaiInfoBean.getTks6(), BizCurrency.optional(), "特約保険金額６");
        Assert.assertEquals(webKykNaiyouSyoukaiInfoBean.getTks6().getType()
            , BizNumberConfig.instance.getDefaultCurrencyType());
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTokuyakuhokenkikan6(), "", "特約保険期間６");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTokuyakuharaikomikikan6(), "", "特約払込期間６");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTknm7(), "指定代理請求特約", "特約名称７");
        exBizCalcbleEquals(webKykNaiyouSyoukaiInfoBean.getTks7(), BizCurrency.optional(), "特約保険金額７");
        Assert.assertEquals(webKykNaiyouSyoukaiInfoBean.getTks7().getType()
            , BizNumberConfig.instance.getDefaultCurrencyType());
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTokuyakuhokenkikan7(), "", "特約保険期間７");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTokuyakuharaikomikikan7(), "", "特約払込期間７");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTknm8(), "", "特約名称８");
        exBizCalcbleEquals(webKykNaiyouSyoukaiInfoBean.getTks8(), BizCurrency.optional(), "特約保険金額８");
        Assert.assertEquals(webKykNaiyouSyoukaiInfoBean.getTks8().getType()
            , BizNumberConfig.instance.getDefaultCurrencyType());
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTokuyakuhokenkikan8(), "", "特約保険期間８");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTokuyakuharaikomikikan8(), "", "特約払込期間８");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTknm9(), "", "特約名称９");
        exBizCalcbleEquals(webKykNaiyouSyoukaiInfoBean.getTks9(), BizCurrency.optional(), "特約保険金額９");
        Assert.assertEquals(webKykNaiyouSyoukaiInfoBean.getTks9().getType()
            , BizNumberConfig.instance.getDefaultCurrencyType());
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTokuyakuhokenkikan9(), "", "特約保険期間９");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTokuyakuharaikomikikan9(), "", "特約払込期間９");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTknm10(), "", "特約名称１０");
        exBizCalcbleEquals(webKykNaiyouSyoukaiInfoBean.getTks10(), BizCurrency.optional(), "特約保険金額１０");
        Assert.assertEquals(webKykNaiyouSyoukaiInfoBean.getTks10().getType()
            , BizNumberConfig.instance.getDefaultCurrencyType());
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTokuyakuhokenkikan10(), "", "特約保険期間１０");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTokuyakuharaikomikikan10(), "", "特約払込期間１０");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTknm11(), "", "特約名称１１");
        exBizCalcbleEquals(webKykNaiyouSyoukaiInfoBean.getTks11(), BizCurrency.optional(), "特約保険金額１１");
        Assert.assertEquals(webKykNaiyouSyoukaiInfoBean.getTks11().getType()
            , BizNumberConfig.instance.getDefaultCurrencyType());
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTokuyakuhokenkikan11(), "", "特約保険期間１１");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTokuyakuharaikomikikan11(), "", "特約払込期間１１");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTknm12(), "", "特約名称１２");
        exBizCalcbleEquals(webKykNaiyouSyoukaiInfoBean.getTks12(), BizCurrency.optional(), "特約保険金額１２");
        Assert.assertEquals(webKykNaiyouSyoukaiInfoBean.getTks12().getType()
            , BizNumberConfig.instance.getDefaultCurrencyType());
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTokuyakuhokenkikan12(), "", "特約保険期間１２");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTokuyakuharaikomikikan12(), "", "特約払込期間１２");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTknm13(), "", "特約名称１３");
        exBizCalcbleEquals(webKykNaiyouSyoukaiInfoBean.getTks13(), BizCurrency.optional(), "特約保険金額１３");
        Assert.assertEquals(webKykNaiyouSyoukaiInfoBean.getTks13().getType()
            , BizNumberConfig.instance.getDefaultCurrencyType());
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTokuyakuhokenkikan13(), "", "特約保険期間１３");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTokuyakuharaikomikikan13(), "", "特約払込期間１３");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTknm14(), "", "特約名称１４");
        exBizCalcbleEquals(webKykNaiyouSyoukaiInfoBean.getTks14(), BizCurrency.optional(), "特約保険金額１４");
        Assert.assertEquals(webKykNaiyouSyoukaiInfoBean.getTks14().getType()
            , BizNumberConfig.instance.getDefaultCurrencyType());
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTokuyakuhokenkikan14(), "", "特約保険期間１４");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTokuyakuharaikomikikan14(), "", "特約払込期間１４");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTknm15(), "", "特約名称１５");
        exBizCalcbleEquals(webKykNaiyouSyoukaiInfoBean.getTks15(), BizCurrency.optional(), "特約保険金額１５");
        Assert.assertEquals(webKykNaiyouSyoukaiInfoBean.getTks15().getType()
            , BizNumberConfig.instance.getDefaultCurrencyType());
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTokuyakuhokenkikan15(), "", "特約保険期間１５");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTokuyakuharaikomikikan15(), "", "特約払込期間１５");
        exNumericEquals(webKykNaiyouSyoukaiInfoBean.getSyouhnNaiyouGyousuu(), 1, "商品内容行数");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getSyouhnNaiyou1(), "現在の保障内容は下記のとおりです。", "商品内容１");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getSyouhnNaiyou2(), "", "商品内容２");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getSyouhnNaiyou3(), "", "商品内容３");
        exNumericEquals(webKykNaiyouSyoukaiInfoBean.getHosyouNaiyouGyousuu(), 22, "保障内容行数");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHosyouNaiyou1(), "死亡時支払金受取人　契約者　様", "保障内容１");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHosyouNaiyou2(), "年金受取人　　　　　契約者　様", "保障内容２");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHosyouNaiyou3(), "契約者代理人　　　　カゾクメイ１　１－２７　様　　　　　　　　　生年月日　平成１３年　１月　１日", "保障内容３");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHosyouNaiyou4(), "指定代理請求人　　　カゾクメイ１　１－２７　様　　　　　　　　　生年月日　平成１３年　１月　１日", "保障内容４");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHosyouNaiyou5(), "登録家族（１人目）　カゾクメイ１　１－２７　様　　　　　　　　　生年月日　平成１３年　１月　１日", "保障内容５");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHosyouNaiyou6(), "登録家族（２人目）　カゾクメイ２　１－２７　様　　　　　　　　　生年月日　平成１４年　１月　１日", "保障内容６");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHosyouNaiyou7(), "定率増加部分繰り入れ割合　　　０％", "保障内容７");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHosyouNaiyou8(), "死亡時", "保障内容８");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHosyouNaiyou9(), "第３保険期間（照会日時点）　　　　　　　　　　　１０，０００．００ユーロ", "保障内容９");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHosyouNaiyou10(), "　　　　　　　　　　　　　　　　　　　　　　　　（１００円）", "保障内容１０");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHosyouNaiyou11(), "解約返戻金額（照会日時点）　１，０００．００ユーロ　　（１００円）", "保障内容１１");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHosyouNaiyou12(), "積立金額（照会日時点）　１，０００．００ユーロ　　（１００円）", "保障内容１２");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHosyouNaiyou13(), "上記（）内の金額は、照会時点の為替レートで円換算した参考値であり変動します。", "保障内容１３");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHosyouNaiyou14(), "保険法対応契約", "保障内容１４");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHosyouNaiyou15(), "重度介護前払特約あり", "保障内容１５");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHosyouNaiyou16(), "保険料円貨払込特約あり　　　　　加入時保険料入金額　　　１，２３０．００円", "保障内容１６");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHosyouNaiyou17(), "　保険料領収日時点の払込特約レート　１ユーロ＝１円（平成２９年　７月　１日）", "保障内容１７");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHosyouNaiyou18(), "保険料指定外通貨払込特約あり　　加入時保険料入金額　　１，２３０．００ユーロ", "保障内容１８");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHosyouNaiyou19(), "　保険料領収日時点の払込特約レート　１ユーロ＝１ユーロ（平成２９年　７月　１日）", "保障内容１９");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHosyouNaiyou20(), "初期死亡時円換算支払額最低保証特約あり", "保障内容２０");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHosyouNaiyou21(), "保険契約者代理特約あり", "保障内容２１");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHosyouNaiyou22(), "指定代理請求特約あり", "保障内容２２");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHosyouNaiyou23(), "", "保障内容２３");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHosyouNaiyou24(), "", "保障内容２４");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHosyouNaiyou25(), "", "保障内容２５");
        exNumericEquals(webKykNaiyouSyoukaiInfoBean.getHenkouKeiiGyousuu(), 1, "変更経緯行数");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHenkouKeii1(), "平成２７年１２月　１日　契約内容変更", "変更経緯１");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHenkouKeii2(), "", "変更経緯２");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHenkouKeii3(), "", "変更経緯３");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHenkouKeii4(), "", "変更経緯４");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHenkouKeii5(), "", "変更経緯５");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHenkouKeii6(), "", "変更経緯６");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHenkouKeii7(), "", "変更経緯７");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHenkouKeii8(), "", "変更経緯８");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHenkouKeii9(), "", "変更経緯９");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHenkouKeii10(), "", "変更経緯１０");
        exNumericEquals(webKykNaiyouSyoukaiInfoBean.getBosyuDrtenGyousuu(), 2, "募集代理店行数");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getBosyuDrtenNm1(), "取扱代理店名３", "募集代理店名１");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getDrtenBnwari1(), "", "代理店分割割合１");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getBosyuDrtenNm2(), "取扱代理店名３", "募集代理店名２");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getDrtenBnwari2(), "", "代理店分割割合２");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getMsgOutKbn(), "2", "MSG出力区分");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHosyouIkkatuMinaokeiyakuHyouji(), "0", "保障一括見直契約表示");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHhknnmkn(), "ﾋﾎｹﾝｼｶﾅ", "被保険者氏名(ｶﾅ)");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHokenryouSyuunouJyoukyou(), "－", "保険料収納状況");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getJikaiHokenryouJyuutouYm(), "－", "次回保険料充当年月");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getMdhansybetuKbn(), "01", "窓販種別区分");
    }

    @Test
    @TestOrder(400)
    public void testExec_A40() {
        changeSystemDate();

        MockObjectManager.initialize();
        BzGetProcessSummaryMockForHozen.SYORIPTN = BzGetProcessSummaryMockForHozen.TESTPATTERN6;

        WebKykNaiyouSyoukaiInfoBean webKykNaiyouSyoukaiInfoBean =
            hbKeiyakuSyoukai.exec("99809111149", BizDate.valueOf("20160621"), C_TanmatuSiyouKbn.SOUGOU_IPPAN, null);

        exStringEquals(webKykNaiyouSyoukaiInfoBean.getErrorKbn(), "1", "エラー区分");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getErrorMsg()
            , "選択されたご契約についてはご照会できません。", "エラーメッセージ");
        CheckEebKykNaiyouSyoukaiInfoBean(webKykNaiyouSyoukaiInfoBean);
    }

    @Test
    @TestOrder(410)
    public void testExec_A41() {
        changeSystemDate();

        MockObjectManager.initialize();

        WebKykNaiyouSyoukaiInfoBean webKykNaiyouSyoukaiInfoBean =
            hbKeiyakuSyoukai.exec("17806000013", BizDate.valueOf("20160621"), C_TanmatuSiyouKbn.DAIRITENBOSYUUNIN, "100006");

        exStringEquals(webKykNaiyouSyoukaiInfoBean.getErrorKbn(), "1", "エラー区分");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getErrorMsg()
            , "選択されたご契約についてはご照会できません。", "エラーメッセージ");
        CheckEebKykNaiyouSyoukaiInfoBean(webKykNaiyouSyoukaiInfoBean);
    }

    @Test
    @TestOrder(420)
    public void testExec_A42() {
        changeSystemDate();

        MockObjectManager.initialize();
        BzGetProcessSummaryMockForHozen.SYORIPTN = BzGetProcessSummaryMockForHozen.TESTPATTERN1;

        WebKykNaiyouSyoukaiInfoBean webKykNaiyouSyoukaiInfoBean =
            hbKeiyakuSyoukai.exec("17806000035", BizDate.valueOf("20160621"), C_TanmatuSiyouKbn.SOUGOU_IPPAN, null);

        exStringEquals(webKykNaiyouSyoukaiInfoBean.getErrorKbn(), "1", "エラー区分");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getErrorMsg()
            , "選択されたご契約についてはご照会できません。", "エラーメッセージ");
        CheckEebKykNaiyouSyoukaiInfoBean(webKykNaiyouSyoukaiInfoBean);

    }

    @Test
    @TestOrder(430)
    public void testExec_A43() {
        changeSystemDate();

        MockObjectManager.initialize();
        BzGetProcessSummaryMockForHozen.SYORIPTN = BzGetProcessSummaryMockForHozen.TESTPATTERN2;
        BzGetAdrDataMockForHozen.SYORIPTN = BzGetAdrDataMockForHozen.TESTPATTERN2;
        CalcHkShrKngkMockForHozen.SYORIPTN = CalcHkShrKngkMockForHozen.TESTPATTERN2;
        KeisanWExtMockForHozen.SYORIPTN = KeisanWExtMockForHozen.TESTPATTERN2;
        KeisanWMockForHozen.SYORIPTN = KeisanWMockForHozen.TESTPATTERN2;

        WebKykNaiyouSyoukaiInfoBean webKykNaiyouSyoukaiInfoBean =
            hbKeiyakuSyoukai.exec("17806000046", BizDate.valueOf("20270621"), C_TanmatuSiyouKbn.SOUGOU_IPPAN, null);

        exStringEquals(webKykNaiyouSyoukaiInfoBean.getErrorKbn(), "1", "エラー区分");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getErrorMsg()
            , "選択されたご契約についてはご照会できません。", "エラーメッセージ");

        CheckEebKykNaiyouSyoukaiInfoBean(webKykNaiyouSyoukaiInfoBean);
    }

    @Test
    @TestOrder(440)
    public void testExec_A44() {
        changeSystemDate();

        MockObjectManager.initialize();
        BzGetProcessSummaryMockForHozen.SYORIPTN = BzGetProcessSummaryMockForHozen.TESTPATTERN2;
        BzGetAdrDataMockForHozen.SYORIPTN = BzGetAdrDataMockForHozen.TESTPATTERN1;
        CalcHkShrKngkMockForHozen.SYORIPTN = CalcHkShrKngkMockForHozen.TESTPATTERN4;
        KeisanWExtMockForHozen.SYORIPTN = KeisanWExtMockForHozen.TESTPATTERN2;
        KeisanWMockForHozen.SYORIPTN = KeisanWMockForHozen.TESTPATTERN1;
        KeisanKijyungkMockForHozen.SYORIPTN = KeisanKijyungkMockForHozen.TESTPATTERN2;
        KeisanGaikakanzanMockForHozen.SYORIPTN = KeisanGaikakanzanMockForHozen.TESTPATTERN1;
        SetNenreiMockForHozen.SYORIPTN = SetNenreiMockForHozen.TESTPATTERN1;

        WebKykNaiyouSyoukaiInfoBean webKykNaiyouSyoukaiInfoBean =
            hbKeiyakuSyoukai.exec("17806000057", BizDate.valueOf("20160621"), C_TanmatuSiyouKbn.SOUGOU_IPPAN, "A10010");

        exStringEquals(webKykNaiyouSyoukaiInfoBean.getErrorKbn(), "", "エラー区分");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getErrorMsg(), "", "エラーメッセージ");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getKyknmkn(), "ｶﾅ", "契約者名（カナ）");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getKyknmkj(), "契約者名漢字１－３２　様", "契約者名（漢字）");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getKykseiymd(), "昭和５５年　１月　１日", "契約者生年月日");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getKojinhjnKbn(), "個人", "個人法人区分");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTelno(), "010-1234-5678", "電話番号");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getPostalCd(), "１２３－４５６７", "郵便番号");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getAdr(), "通信先住所１通信先住所２通信先住所３", "住所");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getAdrkn(), "ｶﾅｶﾅｶﾅｶﾅ", "住所(ｶﾅ)");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHhknnm(), "被保険者名　様", "被保険者氏名");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHhknsei(), "男性", "被保険者性別");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHhknseiymd(), "昭和５５年　１月　１日", "被保険者生年月日");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHhknNen(), "３５歳", "被保険者年齢");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHhknKykjiNen(), "２５歳", "被保険者契約時年齢");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getSyouhnnm(), "たのしみステップ", "商品名");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getSyurui(), "年金保険", "種類");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getSyono(), "17806000057", "証券番号");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getCifCd(), "*****", "CIFｺｰﾄﾞ");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getKykymd(), "平成２８年　６月２１日", "契約日");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHrkhou(), "", "払込方法");
        exBizCalcbleEquals(webKykNaiyouSyoukaiInfoBean.getSibous()
            , BizCurrency.valueOf(10000.00, BizCurrencyTypes.AU_DOLLAR) , "死亡保険金");
        Assert.assertEquals(webKykNaiyouSyoukaiInfoBean.getSibous().getType(), BizCurrencyTypes.AU_DOLLAR);
        exBizCalcbleEquals(webKykNaiyouSyoukaiInfoBean.getHrkp()
            , BizCurrency.valueOf(1001.00, BizCurrencyTypes.DOLLAR), "払込保険料");
        Assert.assertEquals(webKykNaiyouSyoukaiInfoBean.getHrkp().getType(), BizCurrencyTypes.DOLLAR);
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getNkShrStartYmd(), "平成２９年　１月　１日", "年金支払開始日");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getNenkinHosyouYear(), "１１年", "年金保証年");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getNenkinKbn(), "確定年金", "年金区分");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHaitouKbn(), "準有配当", "配当区分");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getSinsaKbn(), "", "診査区分");
        exNumericEquals(webKykNaiyouSyoukaiInfoBean.getTksuu(), 2, "特約数");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getLivingneedsTkhyj(), "", "リビングニーズ特約表示");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHokenMankiDay(), "平成２８年１２月３１日", "保険満期日");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getSyunm(), "個人年金", "主契約名称");
        exBizCalcbleEquals(webKykNaiyouSyoukaiInfoBean.getSyus()
            , BizCurrency.optional(), "主契約保険金額");
        Assert.assertEquals(webKykNaiyouSyoukaiInfoBean.getSyus().getType(), BizNumberConfig.instance.getDefaultCurrencyType());
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getSyuhknkkn(), "　９年間", "主契約保険期間");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getSyuhrkkkn(), "", "主契約払込期間");
        exNumericEquals(webKykNaiyouSyoukaiInfoBean.getTkNaiyouGyousuu(), 2, "特約内容行数");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTknm1(), "保険契約者代理特約", "特約名称１");
        exBizCalcbleEquals(webKykNaiyouSyoukaiInfoBean.getTks1(), BizCurrency.optional(), "特約保険金額１");
        Assert.assertEquals(webKykNaiyouSyoukaiInfoBean.getTks1().getType()
            , BizNumberConfig.instance.getDefaultCurrencyType());
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTokuyakuhokenkikan1(), "", "特約保険期間１");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTokuyakuharaikomikikan1(), "", "特約払込期間１");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTknm2(), "指定代理請求特約", "特約名称２");
        exBizCalcbleEquals(webKykNaiyouSyoukaiInfoBean.getTks2(), BizCurrency.optional(), "特約保険金額２");
        Assert.assertEquals(webKykNaiyouSyoukaiInfoBean.getTks2().getType()
            , BizNumberConfig.instance.getDefaultCurrencyType());
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTokuyakuhokenkikan2(), "", "特約保険期間２");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTokuyakuharaikomikikan2(), "", "特約払込期間２");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTknm3(), "", "特約名称３");
        exBizCalcbleEquals(webKykNaiyouSyoukaiInfoBean.getTks3(), BizCurrency.optional(), "特約保険金額３");
        Assert.assertEquals(webKykNaiyouSyoukaiInfoBean.getTks3().getType()
            , BizNumberConfig.instance.getDefaultCurrencyType());
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTokuyakuhokenkikan3(), "", "特約保険期間３");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTokuyakuharaikomikikan3(), "", "特約払込期間３");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTknm4(), "", "特約名称４");
        exBizCalcbleEquals(webKykNaiyouSyoukaiInfoBean.getTks4(), BizCurrency.optional(), "特約保険金額４");
        Assert.assertEquals(webKykNaiyouSyoukaiInfoBean.getTks4().getType()
            , BizNumberConfig.instance.getDefaultCurrencyType());
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTokuyakuhokenkikan4(), "", "特約保険期間４");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTokuyakuharaikomikikan4(), "", "特約払込期間４");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTknm5(), "", "特約名称５");
        exBizCalcbleEquals(webKykNaiyouSyoukaiInfoBean.getTks5(), BizCurrency.optional(), "特約保険金額５");
        Assert.assertEquals(webKykNaiyouSyoukaiInfoBean.getTks5().getType()
            , BizNumberConfig.instance.getDefaultCurrencyType());
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTokuyakuhokenkikan5(), "", "特約保険期間５");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTokuyakuharaikomikikan5(), "", "特約払込期間５");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTknm6(), "", "特約名称６");
        exBizCalcbleEquals(webKykNaiyouSyoukaiInfoBean.getTks6(), BizCurrency.optional(), "特約保険金額６");
        Assert.assertEquals(webKykNaiyouSyoukaiInfoBean.getTks6().getType()
            , BizNumberConfig.instance.getDefaultCurrencyType());
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTokuyakuhokenkikan6(), "", "特約保険期間６");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTokuyakuharaikomikikan6(), "", "特約払込期間６");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTknm7(), "", "特約名称７");
        exBizCalcbleEquals(webKykNaiyouSyoukaiInfoBean.getTks7(), BizCurrency.optional(), "特約保険金額７");
        Assert.assertEquals(webKykNaiyouSyoukaiInfoBean.getTks7().getType()
            , BizNumberConfig.instance.getDefaultCurrencyType());
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTokuyakuhokenkikan7(), "", "特約保険期間７");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTokuyakuharaikomikikan7(), "", "特約払込期間７");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTknm8(), "", "特約名称８");
        exBizCalcbleEquals(webKykNaiyouSyoukaiInfoBean.getTks8(), BizCurrency.optional(), "特約保険金額８");
        Assert.assertEquals(webKykNaiyouSyoukaiInfoBean.getTks8().getType()
            , BizNumberConfig.instance.getDefaultCurrencyType());
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTokuyakuhokenkikan8(), "", "特約保険期間８");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTokuyakuharaikomikikan8(), "", "特約払込期間８");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTknm9(), "", "特約名称９");
        exBizCalcbleEquals(webKykNaiyouSyoukaiInfoBean.getTks9(), BizCurrency.optional(), "特約保険金額９");
        Assert.assertEquals(webKykNaiyouSyoukaiInfoBean.getTks9().getType()
            , BizNumberConfig.instance.getDefaultCurrencyType());
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTokuyakuhokenkikan9(), "", "特約保険期間９");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTokuyakuharaikomikikan9(), "", "特約払込期間９");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTknm10(), "", "特約名称１０");
        exBizCalcbleEquals(webKykNaiyouSyoukaiInfoBean.getTks10(), BizCurrency.optional(), "特約保険金額１０");
        Assert.assertEquals(webKykNaiyouSyoukaiInfoBean.getTks10().getType()
            , BizNumberConfig.instance.getDefaultCurrencyType());
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTokuyakuhokenkikan10(), "", "特約保険期間１０");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTokuyakuharaikomikikan10(), "", "特約払込期間１０");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTknm11(), "", "特約名称１１");
        exBizCalcbleEquals(webKykNaiyouSyoukaiInfoBean.getTks11(), BizCurrency.optional(), "特約保険金額１１");
        Assert.assertEquals(webKykNaiyouSyoukaiInfoBean.getTks11().getType()
            , BizNumberConfig.instance.getDefaultCurrencyType());
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTokuyakuhokenkikan11(), "", "特約保険期間１１");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTokuyakuharaikomikikan11(), "", "特約払込期間１１");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTknm12(), "", "特約名称１２");
        exBizCalcbleEquals(webKykNaiyouSyoukaiInfoBean.getTks12(), BizCurrency.optional(), "特約保険金額１２");
        Assert.assertEquals(webKykNaiyouSyoukaiInfoBean.getTks12().getType()
            , BizNumberConfig.instance.getDefaultCurrencyType());
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTokuyakuhokenkikan12(), "", "特約保険期間１２");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTokuyakuharaikomikikan12(), "", "特約払込期間１２");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTknm13(), "", "特約名称１３");
        exBizCalcbleEquals(webKykNaiyouSyoukaiInfoBean.getTks13(), BizCurrency.optional(), "特約保険金額１３");
        Assert.assertEquals(webKykNaiyouSyoukaiInfoBean.getTks13().getType()
            , BizNumberConfig.instance.getDefaultCurrencyType());
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTokuyakuhokenkikan13(), "", "特約保険期間１３");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTokuyakuharaikomikikan13(), "", "特約払込期間１３");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTknm14(), "", "特約名称１４");
        exBizCalcbleEquals(webKykNaiyouSyoukaiInfoBean.getTks14(), BizCurrency.optional(), "特約保険金額１４");
        Assert.assertEquals(webKykNaiyouSyoukaiInfoBean.getTks14().getType()
            , BizNumberConfig.instance.getDefaultCurrencyType());
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTokuyakuhokenkikan14(), "", "特約保険期間１４");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTokuyakuharaikomikikan14(), "", "特約払込期間１４");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTknm15(), "", "特約名称１５");
        exBizCalcbleEquals(webKykNaiyouSyoukaiInfoBean.getTks15(), BizCurrency.optional(), "特約保険金額１５");
        Assert.assertEquals(webKykNaiyouSyoukaiInfoBean.getTks15().getType()
            , BizNumberConfig.instance.getDefaultCurrencyType());
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTokuyakuhokenkikan15(), "", "特約保険期間１５");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTokuyakuharaikomikikan15(), "", "特約払込期間１５");
        exNumericEquals(webKykNaiyouSyoukaiInfoBean.getSyouhnNaiyouGyousuu(), 1, "商品内容行数");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getSyouhnNaiyou1(), "現在の保障内容は下記のとおりです。", "商品内容１");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getSyouhnNaiyou2(), "", "商品内容２");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getSyouhnNaiyou3(), "", "商品内容３");
        exNumericEquals(webKykNaiyouSyoukaiInfoBean.getHosyouNaiyouGyousuu(), 15, "保障内容行数");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHosyouNaiyou1(), "死亡時支払金受取人　死亡特定名義１－３２　様", "保障内容１");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHosyouNaiyou2(), "年金受取人　　　　　契約者　様", "保障内容２");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHosyouNaiyou3(), "契約者代理人　　　　契代名　１－３２　様　　　　　　　　　　", "保障内容３");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHosyouNaiyou4(), "指定代理請求人　　　死亡特定名義１－３２　様　　　　　　　　", "保障内容４");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHosyouNaiyou5(), "払込保険料の円換算額　　　　１１，０００円", "保障内容５");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHosyouNaiyou6(), "　保険料領収日時点の円換算為替レート　１豪ドル＝５０円（平成２９年　７月　１日）", "保障内容６");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHosyouNaiyou7(), "死亡時（照会日時点）　　　　１０，０００．００豪ドル　　（１００円）", "保障内容７");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHosyouNaiyou8(), "（保険料の払込回数に応じて計算しております。）", "保障内容８");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHosyouNaiyou9(), "解約返戻金額（照会日時点）　１，０００．００豪ドル　　（１００円）", "保障内容９");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHosyouNaiyou10(), "積立金額（照会日時点）　１，０００．００豪ドル　　（１００円）", "保障内容１０");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHosyouNaiyou11(), "上記（）内の金額は、照会時点の為替レートで円換算した参考値であり変動します。", "保障内容１１");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHosyouNaiyou12(), "年金開始日　　　　　　　　平成２９年　１月　１日", "保障内容１２");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHosyouNaiyou13(), "保険法対応契約", "保障内容１３");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHosyouNaiyou14(), "保険契約者代理特約あり", "保障内容１４");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHosyouNaiyou15(), "指定代理請求特約あり", "保障内容１５");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHosyouNaiyou16(), "", "保障内容１６");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHosyouNaiyou17(), "", "保障内容１７");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHosyouNaiyou18(), "", "保障内容１８");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHosyouNaiyou19(), "", "保障内容１９");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHosyouNaiyou20(), "", "保障内容２０");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHosyouNaiyou21(), "", "保障内容２１");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHosyouNaiyou22(), "", "保障内容２２");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHosyouNaiyou23(), "", "保障内容２３");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHosyouNaiyou24(), "", "保障内容２４");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHosyouNaiyou25(), "", "保障内容２５");
        exNumericEquals(webKykNaiyouSyoukaiInfoBean.getHenkouKeiiGyousuu(), 1, "変更経緯行数");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHenkouKeii1(), "平成２７年１２月　１日　契約内容変更", "変更経緯１");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHenkouKeii2(), "", "変更経緯２");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHenkouKeii3(), "", "変更経緯３");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHenkouKeii4(), "", "変更経緯４");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHenkouKeii5(), "", "変更経緯５");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHenkouKeii6(), "", "変更経緯６");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHenkouKeii7(), "", "変更経緯７");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHenkouKeii8(), "", "変更経緯８");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHenkouKeii9(), "", "変更経緯９");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHenkouKeii10(), "", "変更経緯１０");
        exNumericEquals(webKykNaiyouSyoukaiInfoBean.getBosyuDrtenGyousuu(), 1, "募集代理店行数");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getBosyuDrtenNm1(), "取扱代理店名３", "募集代理店名１");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getDrtenBnwari1(), "", "代理店分割割合１");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getBosyuDrtenNm2(), "", "募集代理店名２");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getDrtenBnwari2(), "", "代理店分割割合２");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getMsgOutKbn(), "2", "MSG出力区分");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHosyouIkkatuMinaokeiyakuHyouji(), "0", "保障一括見直契約表示");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHhknnmkn(), "ﾋﾎｹﾝｼｶﾅ", "被保険者氏名(ｶﾅ)");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHokenryouSyuunouJyoukyou(), "正常収納中", "保険料収納状況");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getJikaiHokenryouJyuutouYm(), "平成２８年　６月", "次回保険料充当年月");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getMdhansybetuKbn(), "01", "窓販種別区分");
    }

    private void CheckEebKykNaiyouSyoukaiInfoBean(WebKykNaiyouSyoukaiInfoBean pWebKykNaiyouSyoukaiInfoBean) {

        exStringEquals(pWebKykNaiyouSyoukaiInfoBean.getKyknmkn(), "", "契約者名（カナ）");
        exStringEquals(pWebKykNaiyouSyoukaiInfoBean.getKyknmkj(), "", "契約者名（漢字）");
        exStringEquals(pWebKykNaiyouSyoukaiInfoBean.getKykseiymd(), "", "契約者生年月日");
        exStringEquals(pWebKykNaiyouSyoukaiInfoBean.getKojinhjnKbn(), "", "個人法人区分");
        exStringEquals(pWebKykNaiyouSyoukaiInfoBean.getTelno(), "", "電話番号");
        exStringEquals(pWebKykNaiyouSyoukaiInfoBean.getPostalCd(), "", "郵便番号");
        exStringEquals(pWebKykNaiyouSyoukaiInfoBean.getAdr(), "", "住所");
        exStringEquals(pWebKykNaiyouSyoukaiInfoBean.getAdrkn(), "", "住所(ｶﾅ)");
        exStringEquals(pWebKykNaiyouSyoukaiInfoBean.getHhknnm(), "", "被保険者氏名");
        exStringEquals(pWebKykNaiyouSyoukaiInfoBean.getHhknsei(), "", "被保険者性別");
        exStringEquals(pWebKykNaiyouSyoukaiInfoBean.getHhknseiymd(), "", "被保険者生年月日");
        exStringEquals(pWebKykNaiyouSyoukaiInfoBean.getHhknNen(), "", "被保険者年齢");
        exStringEquals(pWebKykNaiyouSyoukaiInfoBean.getHhknKykjiNen(), "", "被保険者契約時年齢");
        exStringEquals(pWebKykNaiyouSyoukaiInfoBean.getSyouhnnm(), "", "商品名");
        exStringEquals(pWebKykNaiyouSyoukaiInfoBean.getSyurui(), "", "種類");
        exStringEquals(pWebKykNaiyouSyoukaiInfoBean.getSyono(), "", "証券番号");
        exStringEquals(pWebKykNaiyouSyoukaiInfoBean.getCifCd(), "", "CIFｺｰﾄﾞ");
        exStringEquals(pWebKykNaiyouSyoukaiInfoBean.getKykymd(), "", "契約日");
        exStringEquals(pWebKykNaiyouSyoukaiInfoBean.getHrkhou(), "", "払込方法");
        exBizCalcbleEquals(pWebKykNaiyouSyoukaiInfoBean.getSibous(), BizCurrency.optional(), "死亡保険金");
        Assert.assertEquals(pWebKykNaiyouSyoukaiInfoBean.getSibous().getType()
            , BizNumberConfig.instance.getDefaultCurrencyType());
        exBizCalcbleEquals(pWebKykNaiyouSyoukaiInfoBean.getHrkp(), BizCurrency.optional(), "払込保険料");
        Assert.assertEquals(pWebKykNaiyouSyoukaiInfoBean.getHrkp().getType()
            , BizNumberConfig.instance.getDefaultCurrencyType());
        exStringEquals(pWebKykNaiyouSyoukaiInfoBean.getNkShrStartYmd(), "", "年金支払開始日");
        exStringEquals(pWebKykNaiyouSyoukaiInfoBean.getNenkinHosyouYear(), "", "年金保証年");
        exStringEquals(pWebKykNaiyouSyoukaiInfoBean.getNenkinKbn(), "", "年金区分");
        exStringEquals(pWebKykNaiyouSyoukaiInfoBean.getHaitouKbn(), "", "配当区分");
        exStringEquals(pWebKykNaiyouSyoukaiInfoBean.getSinsaKbn(), "", "診査区分");
        exNumericEquals(pWebKykNaiyouSyoukaiInfoBean.getTksuu(), 0, "特約数");
        exStringEquals(pWebKykNaiyouSyoukaiInfoBean.getLivingneedsTkhyj(), "", "リビングニーズ特約表示");
        exStringEquals(pWebKykNaiyouSyoukaiInfoBean.getHokenMankiDay(), "", "保険満期日");
        exStringEquals(pWebKykNaiyouSyoukaiInfoBean.getSyunm(), "", "主契約名称");
        exBizCalcbleEquals(pWebKykNaiyouSyoukaiInfoBean.getSyus(), BizCurrency.optional(), "主契約保険金額");
        Assert.assertEquals(pWebKykNaiyouSyoukaiInfoBean.getSyus().getType()
            , BizNumberConfig.instance.getDefaultCurrencyType());
        exStringEquals(pWebKykNaiyouSyoukaiInfoBean.getSyuhknkkn(), "", "主契約保険期間");
        exStringEquals(pWebKykNaiyouSyoukaiInfoBean.getSyuhrkkkn(), "", "主契約払込期間");
        exNumericEquals(pWebKykNaiyouSyoukaiInfoBean.getTkNaiyouGyousuu(), 0, "特約内容行数");
        exStringEquals(pWebKykNaiyouSyoukaiInfoBean.getTknm1(), "", "特約名称１");
        exBizCalcbleEquals(pWebKykNaiyouSyoukaiInfoBean.getTks1(), BizCurrency.optional(), "特約保険金額１");
        Assert.assertEquals(pWebKykNaiyouSyoukaiInfoBean.getTks1().getType()
            , BizNumberConfig.instance.getDefaultCurrencyType());
        exStringEquals(pWebKykNaiyouSyoukaiInfoBean.getTokuyakuhokenkikan1(), "", "特約保険期間１");
        exStringEquals(pWebKykNaiyouSyoukaiInfoBean.getTokuyakuharaikomikikan1(), "", "特約払込期間１");
        exStringEquals(pWebKykNaiyouSyoukaiInfoBean.getTknm2(), "", "特約名称２");
        exBizCalcbleEquals(pWebKykNaiyouSyoukaiInfoBean.getTks2(), BizCurrency.optional(), "特約保険金額２");
        Assert.assertEquals(pWebKykNaiyouSyoukaiInfoBean.getTks2().getType()
            , BizNumberConfig.instance.getDefaultCurrencyType());
        exStringEquals(pWebKykNaiyouSyoukaiInfoBean.getTokuyakuhokenkikan2(), "", "特約保険期間２");
        exStringEquals(pWebKykNaiyouSyoukaiInfoBean.getTokuyakuharaikomikikan2(), "", "特約払込期間２");
        exStringEquals(pWebKykNaiyouSyoukaiInfoBean.getTknm3(), "", "特約名称３");
        exBizCalcbleEquals(pWebKykNaiyouSyoukaiInfoBean.getTks3(), BizCurrency.optional(), "特約保険金額３");
        Assert.assertEquals(pWebKykNaiyouSyoukaiInfoBean.getTks3().getType()
            , BizNumberConfig.instance.getDefaultCurrencyType());
        exStringEquals(pWebKykNaiyouSyoukaiInfoBean.getTokuyakuhokenkikan3(), "", "特約保険期間３");
        exStringEquals(pWebKykNaiyouSyoukaiInfoBean.getTokuyakuharaikomikikan3(), "", "特約払込期間３");
        exStringEquals(pWebKykNaiyouSyoukaiInfoBean.getTknm4(), "", "特約名称４");
        exBizCalcbleEquals(pWebKykNaiyouSyoukaiInfoBean.getTks4(), BizCurrency.optional(), "特約保険金額４");
        Assert.assertEquals(pWebKykNaiyouSyoukaiInfoBean.getTks4().getType()
            , BizNumberConfig.instance.getDefaultCurrencyType());
        exStringEquals(pWebKykNaiyouSyoukaiInfoBean.getTokuyakuhokenkikan4(), "", "特約保険期間４");
        exStringEquals(pWebKykNaiyouSyoukaiInfoBean.getTokuyakuharaikomikikan4(), "", "特約払込期間４");
        exStringEquals(pWebKykNaiyouSyoukaiInfoBean.getTknm5(), "", "特約名称５");
        exBizCalcbleEquals(pWebKykNaiyouSyoukaiInfoBean.getTks5(), BizCurrency.optional(), "特約保険金額５");
        Assert.assertEquals(pWebKykNaiyouSyoukaiInfoBean.getTks5().getType()
            , BizNumberConfig.instance.getDefaultCurrencyType());
        exStringEquals(pWebKykNaiyouSyoukaiInfoBean.getTokuyakuhokenkikan5(), "", "特約保険期間５");
        exStringEquals(pWebKykNaiyouSyoukaiInfoBean.getTokuyakuharaikomikikan5(), "", "特約払込期間５");
        exStringEquals(pWebKykNaiyouSyoukaiInfoBean.getTknm6(), "", "特約名称６");
        exBizCalcbleEquals(pWebKykNaiyouSyoukaiInfoBean.getTks6(), BizCurrency.optional(), "特約保険金額６");
        Assert.assertEquals(pWebKykNaiyouSyoukaiInfoBean.getTks6().getType()
            , BizNumberConfig.instance.getDefaultCurrencyType());
        exStringEquals(pWebKykNaiyouSyoukaiInfoBean.getTokuyakuhokenkikan6(), "", "特約保険期間６");
        exStringEquals(pWebKykNaiyouSyoukaiInfoBean.getTokuyakuharaikomikikan6(), "", "特約払込期間６");
        exStringEquals(pWebKykNaiyouSyoukaiInfoBean.getTknm7(), "", "特約名称７");
        exBizCalcbleEquals(pWebKykNaiyouSyoukaiInfoBean.getTks7(), BizCurrency.optional(), "特約保険金額７");
        Assert.assertEquals(pWebKykNaiyouSyoukaiInfoBean.getTks7().getType()
            , BizNumberConfig.instance.getDefaultCurrencyType());
        exStringEquals(pWebKykNaiyouSyoukaiInfoBean.getTokuyakuhokenkikan7(), "", "特約保険期間７");
        exStringEquals(pWebKykNaiyouSyoukaiInfoBean.getTokuyakuharaikomikikan7(), "", "特約払込期間７");
        exStringEquals(pWebKykNaiyouSyoukaiInfoBean.getTknm8(), "", "特約名称８");
        exBizCalcbleEquals(pWebKykNaiyouSyoukaiInfoBean.getTks8(), BizCurrency.optional(), "特約保険金額８");
        Assert.assertEquals(pWebKykNaiyouSyoukaiInfoBean.getTks8().getType()
            , BizNumberConfig.instance.getDefaultCurrencyType());
        exStringEquals(pWebKykNaiyouSyoukaiInfoBean.getTokuyakuhokenkikan8(), "", "特約保険期間８");
        exStringEquals(pWebKykNaiyouSyoukaiInfoBean.getTokuyakuharaikomikikan8(), "", "特約払込期間８");
        exStringEquals(pWebKykNaiyouSyoukaiInfoBean.getTknm9(), "", "特約名称９");
        exBizCalcbleEquals(pWebKykNaiyouSyoukaiInfoBean.getTks9(), BizCurrency.optional(), "特約保険金額９");
        Assert.assertEquals(pWebKykNaiyouSyoukaiInfoBean.getTks9().getType()
            , BizNumberConfig.instance.getDefaultCurrencyType());
        exStringEquals(pWebKykNaiyouSyoukaiInfoBean.getTokuyakuhokenkikan9(), "", "特約保険期間９");
        exStringEquals(pWebKykNaiyouSyoukaiInfoBean.getTokuyakuharaikomikikan9(), "", "特約払込期間９");
        exStringEquals(pWebKykNaiyouSyoukaiInfoBean.getTknm10(), "", "特約名称１０");
        exBizCalcbleEquals(pWebKykNaiyouSyoukaiInfoBean.getTks10(), BizCurrency.optional(), "特約保険金額１０");
        Assert.assertEquals(pWebKykNaiyouSyoukaiInfoBean.getTks10().getType()
            , BizNumberConfig.instance.getDefaultCurrencyType());
        exStringEquals(pWebKykNaiyouSyoukaiInfoBean.getTokuyakuhokenkikan10(), "", "特約保険期間１０");
        exStringEquals(pWebKykNaiyouSyoukaiInfoBean.getTokuyakuharaikomikikan10(), "", "特約払込期間１０");
        exStringEquals(pWebKykNaiyouSyoukaiInfoBean.getTknm11(), "", "特約名称１１");
        exBizCalcbleEquals(pWebKykNaiyouSyoukaiInfoBean.getTks11(), BizCurrency.optional(), "特約保険金額１１");
        Assert.assertEquals(pWebKykNaiyouSyoukaiInfoBean.getTks11().getType()
            , BizNumberConfig.instance.getDefaultCurrencyType());
        exStringEquals(pWebKykNaiyouSyoukaiInfoBean.getTokuyakuhokenkikan11(), "", "特約保険期間１１");
        exStringEquals(pWebKykNaiyouSyoukaiInfoBean.getTokuyakuharaikomikikan11(), "", "特約払込期間１１");
        exStringEquals(pWebKykNaiyouSyoukaiInfoBean.getTknm12(), "", "特約名称１２");
        exBizCalcbleEquals(pWebKykNaiyouSyoukaiInfoBean.getTks12(), BizCurrency.optional(), "特約保険金額１２");
        Assert.assertEquals(pWebKykNaiyouSyoukaiInfoBean.getTks12().getType()
            , BizNumberConfig.instance.getDefaultCurrencyType());
        exStringEquals(pWebKykNaiyouSyoukaiInfoBean.getTokuyakuhokenkikan12(), "", "特約保険期間１２");
        exStringEquals(pWebKykNaiyouSyoukaiInfoBean.getTokuyakuharaikomikikan12(), "", "特約払込期間１２");
        exStringEquals(pWebKykNaiyouSyoukaiInfoBean.getTknm13(), "", "特約名称１３");
        exBizCalcbleEquals(pWebKykNaiyouSyoukaiInfoBean.getTks13(), BizCurrency.optional(), "特約保険金額１３");
        Assert.assertEquals(pWebKykNaiyouSyoukaiInfoBean.getTks13().getType()
            , BizNumberConfig.instance.getDefaultCurrencyType());
        exStringEquals(pWebKykNaiyouSyoukaiInfoBean.getTokuyakuhokenkikan13(), "", "特約保険期間１３");
        exStringEquals(pWebKykNaiyouSyoukaiInfoBean.getTokuyakuharaikomikikan13(), "", "特約払込期間１３");
        exStringEquals(pWebKykNaiyouSyoukaiInfoBean.getTknm14(), "", "特約名称１４");
        exBizCalcbleEquals(pWebKykNaiyouSyoukaiInfoBean.getTks14(), BizCurrency.optional(), "特約保険金額１４");
        Assert.assertEquals(pWebKykNaiyouSyoukaiInfoBean.getTks14().getType()
            , BizNumberConfig.instance.getDefaultCurrencyType());
        exStringEquals(pWebKykNaiyouSyoukaiInfoBean.getTokuyakuhokenkikan14(), "", "特約保険期間１４");
        exStringEquals(pWebKykNaiyouSyoukaiInfoBean.getTokuyakuharaikomikikan14(), "", "特約払込期間１４");
        exStringEquals(pWebKykNaiyouSyoukaiInfoBean.getTknm15(), "", "特約名称１５");
        exBizCalcbleEquals(pWebKykNaiyouSyoukaiInfoBean.getTks15(), BizCurrency.optional(), "特約保険金額１５");
        Assert.assertEquals(pWebKykNaiyouSyoukaiInfoBean.getTks15().getType()
            , BizNumberConfig.instance.getDefaultCurrencyType());
        exStringEquals(pWebKykNaiyouSyoukaiInfoBean.getTokuyakuhokenkikan15(), "", "特約保険期間１５");
        exStringEquals(pWebKykNaiyouSyoukaiInfoBean.getTokuyakuharaikomikikan15(), "", "特約払込期間１５");
        exNumericEquals(pWebKykNaiyouSyoukaiInfoBean.getSyouhnNaiyouGyousuu(), 0, "商品内容行数");
        exStringEquals(pWebKykNaiyouSyoukaiInfoBean.getSyouhnNaiyou1(), "", "商品内容１");
        exStringEquals(pWebKykNaiyouSyoukaiInfoBean.getSyouhnNaiyou2(), "", "商品内容２");
        exStringEquals(pWebKykNaiyouSyoukaiInfoBean.getSyouhnNaiyou3(), "", "商品内容３");
        exNumericEquals(pWebKykNaiyouSyoukaiInfoBean.getHosyouNaiyouGyousuu(), 0, "保障内容行数");
        exStringEquals(pWebKykNaiyouSyoukaiInfoBean.getHosyouNaiyou1(), "", "保障内容１");
        exStringEquals(pWebKykNaiyouSyoukaiInfoBean.getHosyouNaiyou2(), "", "保障内容２");
        exStringEquals(pWebKykNaiyouSyoukaiInfoBean.getHosyouNaiyou3(), "", "保障内容３");
        exStringEquals(pWebKykNaiyouSyoukaiInfoBean.getHosyouNaiyou4(), "", "保障内容４");
        exStringEquals(pWebKykNaiyouSyoukaiInfoBean.getHosyouNaiyou5(), "", "保障内容５");
        exStringEquals(pWebKykNaiyouSyoukaiInfoBean.getHosyouNaiyou6(), "", "保障内容６");
        exStringEquals(pWebKykNaiyouSyoukaiInfoBean.getHosyouNaiyou7(), "", "保障内容７");
        exStringEquals(pWebKykNaiyouSyoukaiInfoBean.getHosyouNaiyou8(), "", "保障内容８");
        exStringEquals(pWebKykNaiyouSyoukaiInfoBean.getHosyouNaiyou9(), "", "保障内容９");
        exStringEquals(pWebKykNaiyouSyoukaiInfoBean.getHosyouNaiyou10(), "", "保障内容１０");
        exStringEquals(pWebKykNaiyouSyoukaiInfoBean.getHosyouNaiyou11(), "", "保障内容１１");
        exStringEquals(pWebKykNaiyouSyoukaiInfoBean.getHosyouNaiyou12(), "", "保障内容１２");
        exStringEquals(pWebKykNaiyouSyoukaiInfoBean.getHosyouNaiyou13(), "", "保障内容１３");
        exStringEquals(pWebKykNaiyouSyoukaiInfoBean.getHosyouNaiyou14(), "", "保障内容１４");
        exStringEquals(pWebKykNaiyouSyoukaiInfoBean.getHosyouNaiyou15(), "", "保障内容１５");
        exStringEquals(pWebKykNaiyouSyoukaiInfoBean.getHosyouNaiyou16(), "", "保障内容１６");
        exStringEquals(pWebKykNaiyouSyoukaiInfoBean.getHosyouNaiyou17(), "", "保障内容１７");
        exStringEquals(pWebKykNaiyouSyoukaiInfoBean.getHosyouNaiyou18(), "", "保障内容１８");
        exStringEquals(pWebKykNaiyouSyoukaiInfoBean.getHosyouNaiyou19(), "", "保障内容１９");
        exStringEquals(pWebKykNaiyouSyoukaiInfoBean.getHosyouNaiyou20(), "", "保障内容２０");
        exStringEquals(pWebKykNaiyouSyoukaiInfoBean.getHosyouNaiyou21(), "", "保障内容２１");
        exStringEquals(pWebKykNaiyouSyoukaiInfoBean.getHosyouNaiyou22(), "", "保障内容２２");
        exStringEquals(pWebKykNaiyouSyoukaiInfoBean.getHosyouNaiyou23(), "", "保障内容２３");
        exStringEquals(pWebKykNaiyouSyoukaiInfoBean.getHosyouNaiyou24(), "", "保障内容２４");
        exStringEquals(pWebKykNaiyouSyoukaiInfoBean.getHosyouNaiyou25(), "", "保障内容２５");
        exNumericEquals(pWebKykNaiyouSyoukaiInfoBean.getHenkouKeiiGyousuu(), 0, "変更経緯行数");
        exStringEquals(pWebKykNaiyouSyoukaiInfoBean.getHenkouKeii1(), "", "変更経緯１");
        exStringEquals(pWebKykNaiyouSyoukaiInfoBean.getHenkouKeii2(), "", "変更経緯２");
        exStringEquals(pWebKykNaiyouSyoukaiInfoBean.getHenkouKeii3(), "", "変更経緯３");
        exStringEquals(pWebKykNaiyouSyoukaiInfoBean.getHenkouKeii4(), "", "変更経緯４");
        exStringEquals(pWebKykNaiyouSyoukaiInfoBean.getHenkouKeii5(), "", "変更経緯５");
        exStringEquals(pWebKykNaiyouSyoukaiInfoBean.getHenkouKeii6(), "", "変更経緯６");
        exStringEquals(pWebKykNaiyouSyoukaiInfoBean.getHenkouKeii7(), "", "変更経緯７");
        exStringEquals(pWebKykNaiyouSyoukaiInfoBean.getHenkouKeii8(), "", "変更経緯８");
        exStringEquals(pWebKykNaiyouSyoukaiInfoBean.getHenkouKeii9(), "", "変更経緯９");
        exStringEquals(pWebKykNaiyouSyoukaiInfoBean.getHenkouKeii10(), "", "変更経緯１０");
        exNumericEquals(pWebKykNaiyouSyoukaiInfoBean.getBosyuDrtenGyousuu(), 0, "募集代理店行数");
        exStringEquals(pWebKykNaiyouSyoukaiInfoBean.getBosyuDrtenNm1(), "", "募集代理店名１");
        exStringEquals(pWebKykNaiyouSyoukaiInfoBean.getDrtenBnwari1(), "", "代理店分割割合１");
        exStringEquals(pWebKykNaiyouSyoukaiInfoBean.getBosyuDrtenNm2(), "", "募集代理店名２");
        exStringEquals(pWebKykNaiyouSyoukaiInfoBean.getDrtenBnwari2(), "", "代理店分割割合２");
        exStringEquals(pWebKykNaiyouSyoukaiInfoBean.getMsgOutKbn(), "", "MSG出力区分");
        exStringEquals(pWebKykNaiyouSyoukaiInfoBean.getHosyouIkkatuMinaokeiyakuHyouji(), "", "保障一括見直契約表示");
        exStringEquals(pWebKykNaiyouSyoukaiInfoBean.getHhknnmkn(), "", "被保険者氏名(ｶﾅ)");
        exStringEquals(pWebKykNaiyouSyoukaiInfoBean.getHokenryouSyuunouJyoukyou(), "", "保険料収納状況");
        exStringEquals(pWebKykNaiyouSyoukaiInfoBean.getJikaiHokenryouJyuutouYm(), "", "次回保険料充当年月");
        exStringEquals(pWebKykNaiyouSyoukaiInfoBean.getMdhansybetuKbn(), "", "窓販種別区分");
    }

    @Test
    @TestOrder(450)
    public void testExec_A45() {
        changeSystemDate();

        MockObjectManager.initialize();
        BzGetProcessSummaryMockForHozen.SYORIPTN = BzGetProcessSummaryMockForHozen.TESTPATTERN2;
        BzGetAdrDataMockForHozen.SYORIPTN = BzGetAdrDataMockForHozen.TESTPATTERN1;
        CalcHkShrKngkMockForHozen.SYORIPTN = CalcHkShrKngkMockForHozen.TESTPATTERN1;

        WebKykNaiyouSyoukaiInfoBean webKykNaiyouSyoukaiInfoBean =
            hbKeiyakuSyoukai.exec("17806000105", BizDate.valueOf("20160621"), C_TanmatuSiyouKbn.SOUGOU_IPPAN, null);

        exStringEquals(webKykNaiyouSyoukaiInfoBean.getErrorKbn(), "1", "エラー区分");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getErrorMsg()
            , "選択されたご契約についてはご照会できません。", "エラーメッセージ");
        CheckEebKykNaiyouSyoukaiInfoBean(webKykNaiyouSyoukaiInfoBean);
    }

    @Test
    @TestOrder(460)
    public void testExec_A46() {
        changeSystemDate();

        MockObjectManager.initialize();
        BzGetProcessSummaryMockForHozen.SYORIPTN = BzGetProcessSummaryMockForHozen.TESTPATTERN2;
        BzGetAdrDataMockForHozen.SYORIPTN = BzGetAdrDataMockForHozen.TESTPATTERN1;
        CalcHkShrKngkMockForHozen.SYORIPTN = CalcHkShrKngkMockForHozen.TESTPATTERN4;
        KeisanWExtMockForHozen.SYORIPTN = KeisanWExtMockForHozen.TESTPATTERN2;
        KeisanWMockForHozen.SYORIPTN = KeisanWMockForHozen.TESTPATTERN1;
        KeisanKijyungkMockForHozen.SYORIPTN = KeisanKijyungkMockForHozen.TESTPATTERN2;
        KeisanGaikakanzanMockForHozen.SYORIPTN = KeisanGaikakanzanMockForHozen.TESTPATTERN1;
        SetNenreiMockForHozen.SYORIPTN = SetNenreiMockForHozen.TESTPATTERN1;

        WebKykNaiyouSyoukaiInfoBean webKykNaiyouSyoukaiInfoBean =
            hbKeiyakuSyoukai.exec("17806000068", BizDate.valueOf("20160621"), C_TanmatuSiyouKbn.DAIRITENBOSYUUNIN, "100006");


        exStringEquals(webKykNaiyouSyoukaiInfoBean.getErrorKbn(), "", "エラー区分");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getErrorMsg(), "", "エラーメッセージ");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getSyono(), "17806000068", "証券番号");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHrkhou(), "前納中", "払込方法");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getNenkinHosyouYear(), "　５年", "年金保証年");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getNenkinKbn(), "確定年金", "年金区分");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHokenryouSyuunouJyoukyou(), "正常収納中", "保険料収納状況");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getJikaiHokenryouJyuutouYm(), "－", "次回保険料充当年月");
        Assert.assertEquals(webKykNaiyouSyoukaiInfoBean.getSyus().getType(), BizNumberConfig.instance.getDefaultCurrencyType());
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getSyuhrkkkn(), "　５歳まで", "主契約払込期間");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTknm1(), "保険料円貨払込特約（円貨払込額指定型）", "特約名称１");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHosyouNaiyou3(), "指定代理請求人　　　カナ　様　　　　　　　　　　　　　　　　", "保障内容３");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHosyouNaiyou11(), "保険料円貨払込特約（円貨払込額指定型）あり", "保障内容１１");


    }

    @Test
    @TestOrder(470)
    public void testExec_A47() {
        changeSystemDate();

        MockObjectManager.initialize();
        BzGetProcessSummaryMockForHozen.SYORIPTN = BzGetProcessSummaryMockForHozen.TESTPATTERN2;
        BzGetAdrDataMockForHozen.SYORIPTN = BzGetAdrDataMockForHozen.TESTPATTERN1;
        CalcHkShrKngkMockForHozen.SYORIPTN = CalcHkShrKngkMockForHozen.TESTPATTERN4;
        KeisanWExtMockForHozen.SYORIPTN = KeisanWExtMockForHozen.TESTPATTERN2;
        KeisanWMockForHozen.SYORIPTN = KeisanWMockForHozen.TESTPATTERN1;
        KeisanKijyungkMockForHozen.SYORIPTN = KeisanKijyungkMockForHozen.TESTPATTERN2;
        KeisanGaikakanzanMockForHozen.SYORIPTN = KeisanGaikakanzanMockForHozen.TESTPATTERN1;
        SetNenreiMockForHozen.SYORIPTN = SetNenreiMockForHozen.TESTPATTERN1;

        WebKykNaiyouSyoukaiInfoBean webKykNaiyouSyoukaiInfoBean =
            hbKeiyakuSyoukai.exec("17806000079", BizDate.valueOf("20160621"), C_TanmatuSiyouKbn.DAIRITENBOSYUUNIN, "100006");


        exStringEquals(webKykNaiyouSyoukaiInfoBean.getErrorKbn(), "", "エラー区分");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getErrorMsg(), "", "エラーメッセージ");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getSyono(), "17806000079", "証券番号");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHrkhou(), "６か月一括払　口座振替扱　一括入金中", "払込方法");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getNenkinHosyouYear(), "　５年", "年金保証年");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getNenkinKbn(), "確定年金　第１回倍額", "年金区分");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHokenryouSyuunouJyoukyou(), "正常収納中", "保険料収納状況");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getJikaiHokenryouJyuutouYm(), "平成２８年　７月", "次回保険料充当年月");
        Assert.assertEquals(webKykNaiyouSyoukaiInfoBean.getSyus().getType(), BizNumberConfig.instance.getDefaultCurrencyType());
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getSyuhrkkkn(), "４０歳まで", "主契約払込期間");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHosyouNaiyou3(), "指定代理請求人　　　契約者名漢字１－３４　様　　　　　　　　", "保障内容３");


    }

    @Test
    @TestOrder(480)
    public void testExec_A48() {
        changeSystemDate();

        MockObjectManager.initialize();
        BzGetProcessSummaryMockForHozen.SYORIPTN = BzGetProcessSummaryMockForHozen.TESTPATTERN2;
        BzGetAdrDataMockForHozen.SYORIPTN = BzGetAdrDataMockForHozen.TESTPATTERN1;
        CalcHkShrKngkMockForHozen.SYORIPTN = CalcHkShrKngkMockForHozen.TESTPATTERN4;
        KeisanWExtMockForHozen.SYORIPTN = KeisanWExtMockForHozen.TESTPATTERN2;
        KeisanWMockForHozen.SYORIPTN = KeisanWMockForHozen.TESTPATTERN1;
        KeisanKijyungkMockForHozen.SYORIPTN = KeisanKijyungkMockForHozen.TESTPATTERN2;
        KeisanGaikakanzanMockForHozen.SYORIPTN = KeisanGaikakanzanMockForHozen.TESTPATTERN1;
        SetNenreiMockForHozen.SYORIPTN = SetNenreiMockForHozen.TESTPATTERN1;

        WebKykNaiyouSyoukaiInfoBean webKykNaiyouSyoukaiInfoBean =
            hbKeiyakuSyoukai.exec("17806000080", BizDate.valueOf("20160621"), C_TanmatuSiyouKbn.DAIRITENBOSYUUNIN, "100006");


        exStringEquals(webKykNaiyouSyoukaiInfoBean.getErrorKbn(), "", "エラー区分");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getErrorMsg(), "", "エラーメッセージ");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getSyono(), "17806000080", "証券番号");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHrkhou(), "１２か月一括払　口座振替扱　一括入金中", "払込方法");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHokenryouSyuunouJyoukyou(), "正常収納中", "保険料収納状況");

    }

    @Test
    @TestOrder(490)
    public void testExec_A49() {
        changeSystemDate();

        MockObjectManager.initialize();
        BzGetProcessSummaryMockForHozen.SYORIPTN = BzGetProcessSummaryMockForHozen.TESTPATTERN2;
        BzGetAdrDataMockForHozen.SYORIPTN = BzGetAdrDataMockForHozen.TESTPATTERN1;
        CalcHkShrKngkMockForHozen.SYORIPTN = CalcHkShrKngkMockForHozen.TESTPATTERN4;
        KeisanWExtMockForHozen.SYORIPTN = KeisanWExtMockForHozen.TESTPATTERN2;
        KeisanWMockForHozen.SYORIPTN = KeisanWMockForHozen.TESTPATTERN1;
        KeisanKijyungkMockForHozen.SYORIPTN = KeisanKijyungkMockForHozen.TESTPATTERN2;
        KeisanGaikakanzanMockForHozen.SYORIPTN = KeisanGaikakanzanMockForHozen.TESTPATTERN1;
        SetNenreiMockForHozen.SYORIPTN = SetNenreiMockForHozen.TESTPATTERN1;

        WebKykNaiyouSyoukaiInfoBean webKykNaiyouSyoukaiInfoBean =
            hbKeiyakuSyoukai.exec("17806000091", BizDate.valueOf("20160621"), C_TanmatuSiyouKbn.DAIRITENBOSYUUNIN, "100006");


        exStringEquals(webKykNaiyouSyoukaiInfoBean.getErrorKbn(), "", "エラー区分");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getErrorMsg(), "", "エラーメッセージ");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getSyono(), "17806000091", "証券番号");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHrkhou(), "お払込停止", "払込方法");

    }

    @Test
    @TestOrder(500)
    public void testExec_A50() {
        changeSystemDate();

        MockObjectManager.initialize();
        BzGetProcessSummaryMockForHozen.SYORIPTN = BzGetProcessSummaryMockForHozen.TESTPATTERN2;
        BzGetAdrDataMockForHozen.SYORIPTN = BzGetAdrDataMockForHozen.TESTPATTERN1;
        CalcHkShrKngkMockForHozen.SYORIPTN = CalcHkShrKngkMockForHozen.TESTPATTERN4;
        KeisanWExtMockForHozen.SYORIPTN = KeisanWExtMockForHozen.TESTPATTERN2;
        KeisanWMockForHozen.SYORIPTN = KeisanWMockForHozen.TESTPATTERN1;
        KeisanKijyungkMockForHozen.SYORIPTN = KeisanKijyungkMockForHozen.TESTPATTERN2;
        KeisanGaikakanzanMockForHozen.SYORIPTN = KeisanGaikakanzanMockForHozen.TESTPATTERN1;
        SetNenreiMockForHozen.SYORIPTN = SetNenreiMockForHozen.TESTPATTERN1;

        WebKykNaiyouSyoukaiInfoBean webKykNaiyouSyoukaiInfoBean =
            hbKeiyakuSyoukai.exec("17806000116", BizDate.valueOf("20160621"), C_TanmatuSiyouKbn.DAIRITENBOSYUUNIN, "100006");


        exStringEquals(webKykNaiyouSyoukaiInfoBean.getErrorKbn(), "", "エラー区分");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getErrorMsg(), "", "エラーメッセージ");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getSyono(), "17806000116", "証券番号");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHrkhou(), "月払　口座振替扱", "払込方法");

    }

    @Test
    @TestOrder(510)
    public void testExec_A51() {
        changeSystemDate();

        MockObjectManager.initialize();
        BzGetProcessSummaryMockForHozen.SYORIPTN = BzGetProcessSummaryMockForHozen.TESTPATTERN2;
        HanteiKhSisuurendoTmttknJyoutaiMockForHozen.SYORIPTN = HanteiKhSisuurendoTmttknJyoutaiMockForHozen.TESTPATTERN2;

        WebKykNaiyouSyoukaiInfoBean webKykNaiyouSyoukaiInfoBean =
            hbKeiyakuSyoukai.exec("17806000127", BizDate.valueOf("20160621"), C_TanmatuSiyouKbn.DAIRITENBOSYUUNIN, "100006");

        exStringEquals(webKykNaiyouSyoukaiInfoBean.getErrorKbn(), "1", "エラー区分");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getErrorMsg(), "選択されたご契約については手続き中のためご照会できません。", "エラーメッセージ");
        CheckEebKykNaiyouSyoukaiInfoBean(webKykNaiyouSyoukaiInfoBean);

        HanteiTmttknJyoutaiBean hanteiTmttknJyoutaiBean = (HanteiTmttknJyoutaiBean) MockObjectManager.getArgument(HanteiKhSisuurendoTmttknJyoutaiMockForHozen.class, "execChokuzenOutouymTmttknHantei", 0, 0);

        exDateEquals(hanteiTmttknJyoutaiBean.getHanteiKijyunymd(), BizDate.getSysDate(), "判定基準日");
        exStringEquals(hanteiTmttknJyoutaiBean.getSyono(),         "17806000127", "証券番号");
        exDateEquals(hanteiTmttknJyoutaiBean.getKykymd(), BizDate.valueOf("20160620"), "契約日");
    }

    @Test
    @TestOrder(520)
    public void testExec_A52() {

        changeSystemDate(BizDate.valueOf(20190827));

        MockObjectManager.initialize();
        BzGetProcessSummaryMockForHozen.SYORIPTN = BzGetProcessSummaryMockForHozen.TESTPATTERN2;
        BzGetAdrDataMockForHozen.SYORIPTN = BzGetAdrDataMockForHozen.TESTPATTERN1;
        CalcHkShrKngkMockForHozen.SYORIPTN = CalcHkShrKngkMockForHozen.TESTPATTERN4;
        KeisanWExtMockForHozen.SYORIPTN = KeisanWExtMockForHozen.TESTPATTERN2;
        KeisanWMockForHozen.SYORIPTN = KeisanWMockForHozen.TESTPATTERN1;
        KeisanKijyungkMockForHozen.SYORIPTN = KeisanKijyungkMockForHozen.TESTPATTERN2;
        KeisanGaikakanzanMockForHozen.SYORIPTN = KeisanGaikakanzanMockForHozen.TESTPATTERN1;
        SetNenreiMockForHozen.SYORIPTN = SetNenreiMockForHozen.TESTPATTERN1;
        HanteiKhSisuurendoTmttknJyoutaiMockForHozen.SYORIPTN = HanteiKhSisuurendoTmttknJyoutaiMockForHozen.TESTPATTERN1;

        WebKykNaiyouSyoukaiInfoBean webKykNaiyouSyoukaiInfoBean =
            hbKeiyakuSyoukai.exec("17806000127", BizDate.valueOf("20160621"), C_TanmatuSiyouKbn.SOUGOU_IPPAN, null);

        exStringEquals(webKykNaiyouSyoukaiInfoBean.getErrorKbn(), "", "エラー区分");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getErrorMsg(), "", "エラーメッセージ");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getKyknmkn(), "ｶﾅ", "契約者名（カナ）");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getKyknmkj(), "契約者名漢字１－３９　様", "契約者名（漢字）");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getKykseiymd(), "昭和５５年　１月　１日", "契約者生年月日");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getKojinhjnKbn(), "個人", "個人法人区分");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTelno(), "010-1234-5678", "電話番号");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getPostalCd(), "２２３－４５６７", "郵便番号");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getAdr(), "通信先住所１通信先住所２通信先住所３", "住所");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getAdrkn(), "ｶﾅｶﾅｶﾅｶﾅ", "住所(ｶﾅ)");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHhknnm(), "被保険者名　様", "被保険者氏名");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHhknsei(), "女性", "被保険者性別");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHhknseiymd(), "昭和５６年　１月　１日", "被保険者生年月日");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHhknNen(), "３５歳", "被保険者年齢");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHhknKykjiNen(), "２５歳", "被保険者契約時年齢");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getSyouhnnm(), "カスケード　しんきんらいふ終身Ｓ　ふるはーとＪロードグローバル", "商品名");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getSyurui(), "年金保険", "種類");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getSyono(), "17806000127", "証券番号");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getCifCd(), "100000000000001", "CIFｺｰﾄﾞ");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getKykymd(), "平成２８年　６月２０日", "契約日");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHrkhou(), "一時払", "払込方法");
        exBizCalcbleEquals(webKykNaiyouSyoukaiInfoBean.getSibous()
            , BizCurrency.valueOf(10000.00, BizCurrencyTypes.AU_DOLLAR), "死亡保険金");
        Assert.assertEquals(webKykNaiyouSyoukaiInfoBean.getSibous().getType(), BizCurrencyTypes.AU_DOLLAR);
        exBizCalcbleEquals(webKykNaiyouSyoukaiInfoBean.getHrkp()
            , BizCurrency.valueOf(1001, BizCurrencyTypes.YEN), "払込保険料");
        Assert.assertEquals(webKykNaiyouSyoukaiInfoBean.getHrkp().getType(), BizCurrencyTypes.YEN);
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getNkShrStartYmd(), "平成２８年　３月　１日", "年金支払開始日");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getNenkinHosyouYear(), "　５年", "年金保証年");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getNenkinKbn(), "確定年金", "年金区分");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHaitouKbn(), "準有配当", "配当区分");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getSinsaKbn(), "告知書扱", "診査区分");
        exNumericEquals(webKykNaiyouSyoukaiInfoBean.getTksuu(), 3, "特約数");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getLivingneedsTkhyj(), "", "リビングニーズ特約表示");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHokenMankiDay(), "平成２８年　２月２９日", "保険満期日");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getSyunm(), "個人年金", "主契約名称");
        exBizCalcbleEquals(webKykNaiyouSyoukaiInfoBean.getSyus(), BizCurrency.optional(), "主契約保険金額");
        Assert.assertEquals(webKykNaiyouSyoukaiInfoBean.getSyus().getType()
            , BizNumberConfig.instance.getDefaultCurrencyType());
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getSyuhknkkn(), "　９年間", "主契約保険期間");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getSyuhrkkkn(), "", "主契約払込期間");
        exNumericEquals(webKykNaiyouSyoukaiInfoBean.getTkNaiyouGyousuu(), 3, "特約内容行数");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTknm1(), "保険料指定外通貨払込特約", "特約名称１");
        exBizCalcbleEquals(webKykNaiyouSyoukaiInfoBean.getTks1(), BizCurrency.optional(), "特約保険金額１");
        Assert.assertEquals(webKykNaiyouSyoukaiInfoBean.getTks1().getType()
            , BizNumberConfig.instance.getDefaultCurrencyType());
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTokuyakuhokenkikan1(), "", "特約保険期間１");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTokuyakuharaikomikikan1(), "", "特約払込期間１");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTknm2(), "保険契約者代理特約", "特約名称２");
        exBizCalcbleEquals(webKykNaiyouSyoukaiInfoBean.getTks2(), BizCurrency.optional(), "特約保険金額２");
        Assert.assertEquals(webKykNaiyouSyoukaiInfoBean.getTks2().getType()
            , BizNumberConfig.instance.getDefaultCurrencyType());
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTokuyakuhokenkikan2(), "", "特約保険期間２");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTokuyakuharaikomikikan2(), "", "特約払込期間２");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTknm3(), "指定代理請求特約", "特約名称３");
        exBizCalcbleEquals(webKykNaiyouSyoukaiInfoBean.getTks3(), BizCurrency.optional(), "特約保険金額３");
        Assert.assertEquals(webKykNaiyouSyoukaiInfoBean.getTks3().getType()
            , BizNumberConfig.instance.getDefaultCurrencyType());
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTokuyakuhokenkikan3(), "", "特約保険期間３");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTokuyakuharaikomikikan3(), "", "特約払込期間３");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTknm4(), "", "特約名称４");
        exBizCalcbleEquals(webKykNaiyouSyoukaiInfoBean.getTks4(), BizCurrency.optional(), "特約保険金額４");
        Assert.assertEquals(webKykNaiyouSyoukaiInfoBean.getTks4().getType()
            , BizNumberConfig.instance.getDefaultCurrencyType());
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTokuyakuhokenkikan4(), "", "特約保険期間４");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTokuyakuharaikomikikan4(), "", "特約払込期間４");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTknm5(), "", "特約名称５");
        exBizCalcbleEquals(webKykNaiyouSyoukaiInfoBean.getTks5(), BizCurrency.optional(), "特約保険金額５");
        Assert.assertEquals(webKykNaiyouSyoukaiInfoBean.getTks5().getType()
            , BizNumberConfig.instance.getDefaultCurrencyType());
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTokuyakuhokenkikan5(), "", "特約保険期間５");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTokuyakuharaikomikikan5(), "", "特約払込期間５");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTknm6(), "", "特約名称６");
        exBizCalcbleEquals(webKykNaiyouSyoukaiInfoBean.getTks6(), BizCurrency.optional(), "特約保険金額６");
        Assert.assertEquals(webKykNaiyouSyoukaiInfoBean.getTks6().getType()
            , BizNumberConfig.instance.getDefaultCurrencyType());
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTokuyakuhokenkikan6(), "", "特約保険期間６");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTokuyakuharaikomikikan6(), "", "特約払込期間６");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTknm7(), "", "特約名称７");
        exBizCalcbleEquals(webKykNaiyouSyoukaiInfoBean.getTks7(), BizCurrency.optional(), "特約保険金額７");
        Assert.assertEquals(webKykNaiyouSyoukaiInfoBean.getTks7().getType()
            , BizNumberConfig.instance.getDefaultCurrencyType());
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTokuyakuhokenkikan7(), "", "特約保険期間７");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTokuyakuharaikomikikan7(), "", "特約払込期間７");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTknm8(), "", "特約名称８");
        exBizCalcbleEquals(webKykNaiyouSyoukaiInfoBean.getTks8(), BizCurrency.optional(), "特約保険金額８");
        Assert.assertEquals(webKykNaiyouSyoukaiInfoBean.getTks8().getType()
            , BizNumberConfig.instance.getDefaultCurrencyType());
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTokuyakuhokenkikan8(), "", "特約保険期間８");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTokuyakuharaikomikikan8(), "", "特約払込期間８");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTknm9(), "", "特約名称９");
        exBizCalcbleEquals(webKykNaiyouSyoukaiInfoBean.getTks9(), BizCurrency.optional(), "特約保険金額９");
        Assert.assertEquals(webKykNaiyouSyoukaiInfoBean.getTks9().getType()
            , BizNumberConfig.instance.getDefaultCurrencyType());
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTokuyakuhokenkikan9(), "", "特約保険期間９");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTokuyakuharaikomikikan9(), "", "特約払込期間９");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTknm10(), "", "特約名称１０");
        exBizCalcbleEquals(webKykNaiyouSyoukaiInfoBean.getTks10(), BizCurrency.optional(), "特約保険金額１０");
        Assert.assertEquals(webKykNaiyouSyoukaiInfoBean.getTks10().getType()
            , BizNumberConfig.instance.getDefaultCurrencyType());
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTokuyakuhokenkikan10(), "", "特約保険期間１０");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTokuyakuharaikomikikan10(), "", "特約払込期間１０");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTknm11(), "", "特約名称１１");
        exBizCalcbleEquals(webKykNaiyouSyoukaiInfoBean.getTks11(), BizCurrency.optional(), "特約保険金額１１");
        Assert.assertEquals(webKykNaiyouSyoukaiInfoBean.getTks11().getType()
            , BizNumberConfig.instance.getDefaultCurrencyType());
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTokuyakuhokenkikan11(), "", "特約保険期間１１");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTokuyakuharaikomikikan11(), "", "特約払込期間１１");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTknm12(), "", "特約名称１２");
        exBizCalcbleEquals(webKykNaiyouSyoukaiInfoBean.getTks12(), BizCurrency.optional(), "特約保険金額１２");
        Assert.assertEquals(webKykNaiyouSyoukaiInfoBean.getTks12().getType()
            , BizNumberConfig.instance.getDefaultCurrencyType());
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTokuyakuhokenkikan12(), "", "特約保険期間１２");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTokuyakuharaikomikikan12(), "", "特約払込期間１２");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTknm13(), "", "特約名称１３");
        exBizCalcbleEquals(webKykNaiyouSyoukaiInfoBean.getTks13(), BizCurrency.optional(), "特約保険金額１３");
        Assert.assertEquals(webKykNaiyouSyoukaiInfoBean.getTks13().getType()
            , BizNumberConfig.instance.getDefaultCurrencyType());
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTokuyakuhokenkikan13(), "", "特約保険期間１３");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTokuyakuharaikomikikan13(), "", "特約払込期間１３");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTknm14(), "", "特約名称１４");
        exBizCalcbleEquals(webKykNaiyouSyoukaiInfoBean.getTks14(), BizCurrency.optional(), "特約保険金額１４");
        Assert.assertEquals(webKykNaiyouSyoukaiInfoBean.getTks14().getType()
            , BizNumberConfig.instance.getDefaultCurrencyType());
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTokuyakuhokenkikan14(), "", "特約保険期間１４");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTokuyakuharaikomikikan14(), "", "特約払込期間１４");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTknm15(), "", "特約名称１５");
        exBizCalcbleEquals(webKykNaiyouSyoukaiInfoBean.getTks15(), BizCurrency.optional(), "特約保険金額１５");
        Assert.assertEquals(webKykNaiyouSyoukaiInfoBean.getTks15().getType()
            , BizNumberConfig.instance.getDefaultCurrencyType());
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTokuyakuhokenkikan15(), "", "特約保険期間１５");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTokuyakuharaikomikikan15(), "", "特約払込期間１５");
        exNumericEquals(webKykNaiyouSyoukaiInfoBean.getSyouhnNaiyouGyousuu(), 1, "商品内容行数");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getSyouhnNaiyou1(), "現在の保障内容は下記のとおりです。", "商品内容１");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getSyouhnNaiyou2(), "", "商品内容２");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getSyouhnNaiyou3(), "", "商品内容３");
        exNumericEquals(webKykNaiyouSyoukaiInfoBean.getHosyouNaiyouGyousuu(), 19, "保障内容行数");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHosyouNaiyou1(), "死亡時支払金受取人　契約者　様", "保障内容１");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHosyouNaiyou2(), "年金受取人　　　　　", "保障内容２");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHosyouNaiyou3(), "契約者代理人　　　　家族名１　１－３９　様　　　　　　　　　　　生年月日　平成１３年　１月　１日", "保障内容３");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHosyouNaiyou4(), "指定代理請求人　　　家族名１　１－３９　様　　　　　　　　　　　生年月日　平成１３年　１月　１日", "保障内容４");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHosyouNaiyou5(), "登録家族（１人目）　家族名１　１－３９　様　　　　　　　　　　　生年月日　平成１３年　１月　１日", "保障内容５");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHosyouNaiyou6(), "登録家族（２人目）　登録されておりません", "保障内容６");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHosyouNaiyou7(), "定率増加部分繰り入れ割合　１００％　積立金移転日　令和　１年　８月２６日", "保障内容７");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHosyouNaiyou8(), "払込保険料の円換算額　　　　１１，０００円", "保障内容８");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHosyouNaiyou9(), "　保険料領収日時点の円換算為替レート　１米ドル＝５０円（平成２９年　７月　１日）", "保障内容９");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHosyouNaiyou10(), "積立利率　３．３％", "保障内容１０");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHosyouNaiyou11(), "死亡時（照会日時点）　　　　１０，０００．００米ドル　　（１００円）", "保障内容１１");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHosyouNaiyou12(), "解約返戻金額（照会日時点）　１，０００．００米ドル　　（１００円）", "保障内容１２");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHosyouNaiyou13(), "積立金額（照会日時点）　１，０００．００米ドル　　（１００円）", "保障内容１３");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHosyouNaiyou14(), "上記（）内の金額は、照会時点の為替レートで円換算した参考値であり変動します。", "保障内容１４");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHosyouNaiyou15(), "保険法対応契約", "保障内容１５");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHosyouNaiyou16(), "保険料指定外通貨払込特約あり　　加入時保険料入金額　　１，２３０．００米ドル", "保障内容１６");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHosyouNaiyou17(), "　保険料領収日時点の払込特約レート　１米ドル＝１米ドル（平成２９年　７月　１日）", "保障内容１７");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHosyouNaiyou18(), "保険契約者代理特約あり", "保障内容１８");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHosyouNaiyou19(), "指定代理請求特約あり", "保障内容１９");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHosyouNaiyou20(), "", "保障内容２０");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHosyouNaiyou21(), "", "保障内容２１");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHosyouNaiyou22(), "", "保障内容２２");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHosyouNaiyou23(), "", "保障内容２３");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHosyouNaiyou24(), "", "保障内容２４");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHosyouNaiyou25(), "", "保障内容２５");
        exNumericEquals(webKykNaiyouSyoukaiInfoBean.getHenkouKeiiGyousuu(), 1, "変更経緯行数");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHenkouKeii1(), "平成２７年１２月　１日　契約内容変更", "変更経緯１");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHenkouKeii2(), "", "変更経緯２");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHenkouKeii3(), "", "変更経緯３");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHenkouKeii4(), "", "変更経緯４");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHenkouKeii5(), "", "変更経緯５");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHenkouKeii6(), "", "変更経緯６");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHenkouKeii7(), "", "変更経緯７");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHenkouKeii8(), "", "変更経緯８");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHenkouKeii9(), "", "変更経緯９");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHenkouKeii10(), "", "変更経緯１０");
        exNumericEquals(webKykNaiyouSyoukaiInfoBean.getBosyuDrtenGyousuu(), 1, "募集代理店行数");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getBosyuDrtenNm1(), "取扱代理店名３", "募集代理店名１");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getDrtenBnwari1(), "", "代理店分割割合１");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getBosyuDrtenNm2(), "", "募集代理店名２");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getDrtenBnwari2(), "", "代理店分割割合２");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getMsgOutKbn(), "2", "MSG出力区分");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHosyouIkkatuMinaokeiyakuHyouji(), "0", "保障一括見直契約表示");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHhknnmkn(), "ﾋﾎｹﾝｼｶﾅ", "被保険者氏名(ｶﾅ)");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHokenryouSyuunouJyoukyou(), "－", "保険料収納状況");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getJikaiHokenryouJyuutouYm(), "－", "次回保険料充当年月");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getMdhansybetuKbn(), "01", "窓販種別区分");

    }

    @Test
    @TestOrder(530)
    public void testExec_A53() {

        changeSystemDate(BizDate.valueOf(20190826));

        MockObjectManager.initialize();
        BzGetProcessSummaryMockForHozen.SYORIPTN = BzGetProcessSummaryMockForHozen.TESTPATTERN2;
        BzGetAdrDataMockForHozen.SYORIPTN = BzGetAdrDataMockForHozen.TESTPATTERN1;
        CalcHkShrKngkMockForHozen.SYORIPTN = CalcHkShrKngkMockForHozen.TESTPATTERN4;
        KeisanWExtMockForHozen.SYORIPTN = KeisanWExtMockForHozen.TESTPATTERN2;
        KeisanWMockForHozen.SYORIPTN = KeisanWMockForHozen.TESTPATTERN1;
        KeisanKijyungkMockForHozen.SYORIPTN = KeisanKijyungkMockForHozen.TESTPATTERN2;
        KeisanGaikakanzanMockForHozen.SYORIPTN = KeisanGaikakanzanMockForHozen.TESTPATTERN1;
        SetNenreiMockForHozen.SYORIPTN = SetNenreiMockForHozen.TESTPATTERN1;
        HanteiKhSisuurendoTmttknJyoutaiMockForHozen.SYORIPTN = HanteiKhSisuurendoTmttknJyoutaiMockForHozen.TESTPATTERN1;

        WebKykNaiyouSyoukaiInfoBean webKykNaiyouSyoukaiInfoBean =
            hbKeiyakuSyoukai.exec("17806000127", BizDate.valueOf("20160621"), C_TanmatuSiyouKbn.SOUGOU_IPPAN, null);

        exStringEquals(webKykNaiyouSyoukaiInfoBean.getErrorKbn(), "", "エラー区分");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getErrorMsg(), "", "エラーメッセージ");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHosyouNaiyou7(), "定率増加部分繰り入れ割合　１００％　積立金移転日　令和　１年　８月２６日", "保障内容７");
    }

    @Test
    @TestOrder(540)
    public void testExec_A54() {

        changeSystemDate(BizDate.valueOf(20190825));

        MockObjectManager.initialize();
        BzGetProcessSummaryMockForHozen.SYORIPTN = BzGetProcessSummaryMockForHozen.TESTPATTERN2;
        BzGetAdrDataMockForHozen.SYORIPTN = BzGetAdrDataMockForHozen.TESTPATTERN1;
        CalcHkShrKngkMockForHozen.SYORIPTN = CalcHkShrKngkMockForHozen.TESTPATTERN4;
        KeisanWExtMockForHozen.SYORIPTN = KeisanWExtMockForHozen.TESTPATTERN2;
        KeisanWMockForHozen.SYORIPTN = KeisanWMockForHozen.TESTPATTERN1;
        KeisanKijyungkMockForHozen.SYORIPTN = KeisanKijyungkMockForHozen.TESTPATTERN2;
        KeisanGaikakanzanMockForHozen.SYORIPTN = KeisanGaikakanzanMockForHozen.TESTPATTERN1;
        SetNenreiMockForHozen.SYORIPTN = SetNenreiMockForHozen.TESTPATTERN1;
        HanteiKhSisuurendoTmttknJyoutaiMockForHozen.SYORIPTN = HanteiKhSisuurendoTmttknJyoutaiMockForHozen.TESTPATTERN1;

        WebKykNaiyouSyoukaiInfoBean webKykNaiyouSyoukaiInfoBean =
            hbKeiyakuSyoukai.exec("17806000127", BizDate.valueOf("20160621"), C_TanmatuSiyouKbn.SOUGOU_IPPAN, null);

        exStringEquals(webKykNaiyouSyoukaiInfoBean.getErrorKbn(), "", "エラー区分");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getErrorMsg(), "", "エラーメッセージ");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHosyouNaiyou7(), "定率増加部分繰り入れ割合　１００％", "保障内容７");
    }

    @Test
    @TestOrder(550)
    public void testExec_A55() {

        changeSystemDate(BizDate.valueOf(20190826));

        MockObjectManager.initialize();
        BzGetProcessSummaryMockForHozen.SYORIPTN = BzGetProcessSummaryMockForHozen.TESTPATTERN2;
        BzGetAdrDataMockForHozen.SYORIPTN = BzGetAdrDataMockForHozen.TESTPATTERN1;
        CalcHkShrKngkMockForHozen.SYORIPTN = CalcHkShrKngkMockForHozen.TESTPATTERN4;
        KeisanWExtMockForHozen.SYORIPTN = KeisanWExtMockForHozen.TESTPATTERN2;
        KeisanWMockForHozen.SYORIPTN = KeisanWMockForHozen.TESTPATTERN1;
        KeisanKijyungkMockForHozen.SYORIPTN = KeisanKijyungkMockForHozen.TESTPATTERN2;
        KeisanGaikakanzanMockForHozen.SYORIPTN = KeisanGaikakanzanMockForHozen.TESTPATTERN1;
        SetNenreiMockForHozen.SYORIPTN = SetNenreiMockForHozen.TESTPATTERN1;
        HanteiKhSisuurendoTmttknJyoutaiMockForHozen.SYORIPTN = HanteiKhSisuurendoTmttknJyoutaiMockForHozen.TESTPATTERN2;

        WebKykNaiyouSyoukaiInfoBean webKykNaiyouSyoukaiInfoBean =
            hbKeiyakuSyoukai.exec("17806000138", BizDate.valueOf("20160621"), C_TanmatuSiyouKbn.SOUGOU_IPPAN, null);

        exStringEquals(webKykNaiyouSyoukaiInfoBean.getErrorKbn(), "", "エラー区分");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getErrorMsg(), "", "エラーメッセージ");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getKyknmkn(), "ｶﾅ", "契約者名（カナ）");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getKyknmkj(), "契約者名漢字１－４０　様", "契約者名（漢字）");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getKykseiymd(), "昭和５５年　１月　１日", "契約者生年月日");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getKojinhjnKbn(), "個人", "個人法人区分");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTelno(), "010-1234-5678", "電話番号");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getPostalCd(), "２２３－４５６７", "郵便番号");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getAdr(), "通信先住所１通信先住所２通信先住所３", "住所");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getAdrkn(), "ｶﾅｶﾅｶﾅｶﾅ", "住所(ｶﾅ)");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHhknnm(), "被保険者名　様", "被保険者氏名");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHhknsei(), "女性", "被保険者性別");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHhknseiymd(), "昭和５６年　１月　１日", "被保険者生年月日");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHhknNen(), "３５歳", "被保険者年齢");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHhknKykjiNen(), "２５歳", "被保険者契約時年齢");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getSyouhnnm(), "カスケード　しんきんらいふ終身Ｓ　ふるはーとＪロードグローバル", "商品名");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getSyurui(), "年金保険", "種類");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getSyono(), "17806000138", "証券番号");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getCifCd(), "100000000000001", "CIFｺｰﾄﾞ");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getKykymd(), "平成２８年　６月２０日", "契約日");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHrkhou(), "一時払", "払込方法");
        exBizCalcbleEquals(webKykNaiyouSyoukaiInfoBean.getSibous()
            , BizCurrency.valueOf(10000.00, BizCurrencyTypes.AU_DOLLAR), "死亡保険金");
        Assert.assertEquals(webKykNaiyouSyoukaiInfoBean.getSibous().getType(), BizCurrencyTypes.AU_DOLLAR);
        exBizCalcbleEquals(webKykNaiyouSyoukaiInfoBean.getHrkp()
            , BizCurrency.valueOf(1001, BizCurrencyTypes.YEN), "払込保険料");
        Assert.assertEquals(webKykNaiyouSyoukaiInfoBean.getHrkp().getType(), BizCurrencyTypes.YEN);
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getNkShrStartYmd(), "平成２８年　３月　１日", "年金支払開始日");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getNenkinHosyouYear(), "　５年", "年金保証年");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getNenkinKbn(), "確定年金", "年金区分");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHaitouKbn(), "準有配当", "配当区分");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getSinsaKbn(), "告知書扱", "診査区分");
        exNumericEquals(webKykNaiyouSyoukaiInfoBean.getTksuu(), 3, "特約数");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getLivingneedsTkhyj(), "", "リビングニーズ特約表示");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHokenMankiDay(), "平成２８年　２月２９日", "保険満期日");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getSyunm(), "個人年金", "主契約名称");
        exBizCalcbleEquals(webKykNaiyouSyoukaiInfoBean.getSyus(), BizCurrency.optional(), "主契約保険金額");
        Assert.assertEquals(webKykNaiyouSyoukaiInfoBean.getSyus().getType()
            , BizNumberConfig.instance.getDefaultCurrencyType());
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getSyuhknkkn(), "　９年間", "主契約保険期間");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getSyuhrkkkn(), "", "主契約払込期間");
        exNumericEquals(webKykNaiyouSyoukaiInfoBean.getTkNaiyouGyousuu(), 3, "特約内容行数");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTknm1(), "保険料指定外通貨払込特約", "特約名称１");
        exBizCalcbleEquals(webKykNaiyouSyoukaiInfoBean.getTks1(), BizCurrency.optional(), "特約保険金額１");
        Assert.assertEquals(webKykNaiyouSyoukaiInfoBean.getTks1().getType()
            , BizNumberConfig.instance.getDefaultCurrencyType());
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTokuyakuhokenkikan1(), "", "特約保険期間１");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTokuyakuharaikomikikan1(), "", "特約払込期間１");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTknm2(), "保険契約者代理特約", "特約名称２");
        exBizCalcbleEquals(webKykNaiyouSyoukaiInfoBean.getTks2(), BizCurrency.optional(), "特約保険金額２");
        Assert.assertEquals(webKykNaiyouSyoukaiInfoBean.getTks2().getType()
            , BizNumberConfig.instance.getDefaultCurrencyType());
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTokuyakuhokenkikan2(), "", "特約保険期間２");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTokuyakuharaikomikikan2(), "", "特約払込期間２");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTknm3(), "指定代理請求特約", "特約名称３");
        exBizCalcbleEquals(webKykNaiyouSyoukaiInfoBean.getTks3(), BizCurrency.optional(), "特約保険金額３");
        Assert.assertEquals(webKykNaiyouSyoukaiInfoBean.getTks3().getType()
            , BizNumberConfig.instance.getDefaultCurrencyType());
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTokuyakuhokenkikan3(), "", "特約保険期間３");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTokuyakuharaikomikikan3(), "", "特約払込期間３");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTknm4(), "", "特約名称４");
        exBizCalcbleEquals(webKykNaiyouSyoukaiInfoBean.getTks4(), BizCurrency.optional(), "特約保険金額４");
        Assert.assertEquals(webKykNaiyouSyoukaiInfoBean.getTks4().getType()
            , BizNumberConfig.instance.getDefaultCurrencyType());
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTokuyakuhokenkikan4(), "", "特約保険期間４");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTokuyakuharaikomikikan4(), "", "特約払込期間４");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTknm5(), "", "特約名称５");
        exBizCalcbleEquals(webKykNaiyouSyoukaiInfoBean.getTks5(), BizCurrency.optional(), "特約保険金額５");
        Assert.assertEquals(webKykNaiyouSyoukaiInfoBean.getTks5().getType()
            , BizNumberConfig.instance.getDefaultCurrencyType());
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTokuyakuhokenkikan5(), "", "特約保険期間５");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTokuyakuharaikomikikan5(), "", "特約払込期間５");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTknm6(), "", "特約名称６");
        exBizCalcbleEquals(webKykNaiyouSyoukaiInfoBean.getTks6(), BizCurrency.optional(), "特約保険金額６");
        Assert.assertEquals(webKykNaiyouSyoukaiInfoBean.getTks6().getType()
            , BizNumberConfig.instance.getDefaultCurrencyType());
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTokuyakuhokenkikan6(), "", "特約保険期間６");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTokuyakuharaikomikikan6(), "", "特約払込期間６");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTknm7(), "", "特約名称７");
        exBizCalcbleEquals(webKykNaiyouSyoukaiInfoBean.getTks7(), BizCurrency.optional(), "特約保険金額７");
        Assert.assertEquals(webKykNaiyouSyoukaiInfoBean.getTks7().getType()
            , BizNumberConfig.instance.getDefaultCurrencyType());
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTokuyakuhokenkikan7(), "", "特約保険期間７");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTokuyakuharaikomikikan7(), "", "特約払込期間７");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTknm8(), "", "特約名称８");
        exBizCalcbleEquals(webKykNaiyouSyoukaiInfoBean.getTks8(), BizCurrency.optional(), "特約保険金額８");
        Assert.assertEquals(webKykNaiyouSyoukaiInfoBean.getTks8().getType()
            , BizNumberConfig.instance.getDefaultCurrencyType());
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTokuyakuhokenkikan8(), "", "特約保険期間８");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTokuyakuharaikomikikan8(), "", "特約払込期間８");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTknm9(), "", "特約名称９");
        exBizCalcbleEquals(webKykNaiyouSyoukaiInfoBean.getTks9(), BizCurrency.optional(), "特約保険金額９");
        Assert.assertEquals(webKykNaiyouSyoukaiInfoBean.getTks9().getType()
            , BizNumberConfig.instance.getDefaultCurrencyType());
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTokuyakuhokenkikan9(), "", "特約保険期間９");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTokuyakuharaikomikikan9(), "", "特約払込期間９");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTknm10(), "", "特約名称１０");
        exBizCalcbleEquals(webKykNaiyouSyoukaiInfoBean.getTks10(), BizCurrency.optional(), "特約保険金額１０");
        Assert.assertEquals(webKykNaiyouSyoukaiInfoBean.getTks10().getType()
            , BizNumberConfig.instance.getDefaultCurrencyType());
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTokuyakuhokenkikan10(), "", "特約保険期間１０");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTokuyakuharaikomikikan10(), "", "特約払込期間１０");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTknm11(), "", "特約名称１１");
        exBizCalcbleEquals(webKykNaiyouSyoukaiInfoBean.getTks11(), BizCurrency.optional(), "特約保険金額１１");
        Assert.assertEquals(webKykNaiyouSyoukaiInfoBean.getTks11().getType()
            , BizNumberConfig.instance.getDefaultCurrencyType());
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTokuyakuhokenkikan11(), "", "特約保険期間１１");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTokuyakuharaikomikikan11(), "", "特約払込期間１１");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTknm12(), "", "特約名称１２");
        exBizCalcbleEquals(webKykNaiyouSyoukaiInfoBean.getTks12(), BizCurrency.optional(), "特約保険金額１２");
        Assert.assertEquals(webKykNaiyouSyoukaiInfoBean.getTks12().getType()
            , BizNumberConfig.instance.getDefaultCurrencyType());
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTokuyakuhokenkikan12(), "", "特約保険期間１２");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTokuyakuharaikomikikan12(), "", "特約払込期間１２");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTknm13(), "", "特約名称１３");
        exBizCalcbleEquals(webKykNaiyouSyoukaiInfoBean.getTks13(), BizCurrency.optional(), "特約保険金額１３");
        Assert.assertEquals(webKykNaiyouSyoukaiInfoBean.getTks13().getType()
            , BizNumberConfig.instance.getDefaultCurrencyType());
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTokuyakuhokenkikan13(), "", "特約保険期間１３");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTokuyakuharaikomikikan13(), "", "特約払込期間１３");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTknm14(), "", "特約名称１４");
        exBizCalcbleEquals(webKykNaiyouSyoukaiInfoBean.getTks14(), BizCurrency.optional(), "特約保険金額１４");
        Assert.assertEquals(webKykNaiyouSyoukaiInfoBean.getTks14().getType()
            , BizNumberConfig.instance.getDefaultCurrencyType());
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTokuyakuhokenkikan14(), "", "特約保険期間１４");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTokuyakuharaikomikikan14(), "", "特約払込期間１４");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTknm15(), "", "特約名称１５");
        exBizCalcbleEquals(webKykNaiyouSyoukaiInfoBean.getTks15(), BizCurrency.optional(), "特約保険金額１５");
        Assert.assertEquals(webKykNaiyouSyoukaiInfoBean.getTks15().getType()
            , BizNumberConfig.instance.getDefaultCurrencyType());
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTokuyakuhokenkikan15(), "", "特約保険期間１５");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTokuyakuharaikomikikan15(), "", "特約払込期間１５");
        exNumericEquals(webKykNaiyouSyoukaiInfoBean.getSyouhnNaiyouGyousuu(), 1, "商品内容行数");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getSyouhnNaiyou1(), "現在の保障内容は下記のとおりです。", "商品内容１");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getSyouhnNaiyou2(), "", "商品内容２");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getSyouhnNaiyou3(), "", "商品内容３");
        exNumericEquals(webKykNaiyouSyoukaiInfoBean.getHosyouNaiyouGyousuu(), 13, "保障内容行数");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHosyouNaiyou1(), "死亡時支払金受取人　契約者　様", "保障内容１");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHosyouNaiyou2(), "年金受取人　　　　　", "保障内容２");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHosyouNaiyou3(), "契約者代理人　　　　カゾクメイ２　１－４０　様　　　　　　　", "保障内容３");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHosyouNaiyou4(), "指定代理請求人　　　カゾクメイ２　１－４０　様　　　　　　　", "保障内容４");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHosyouNaiyou5(), "登録家族（１人目）　登録されておりません", "保障内容５");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHosyouNaiyou6(), "登録家族（２人目）　カゾクメイ２　１－４０　様　　　　　　　", "保障内容６");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHosyouNaiyou7(), "積立利率　２．５％", "保障内容７");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHosyouNaiyou8(), "死亡時　　　　　　　　　　　１０，０００円", "保障内容８");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHosyouNaiyou9(), "解約返戻金額（照会日時点）　１，０００円", "保障内容９");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHosyouNaiyou10(), "積立金額（照会日時点）　１，０００円", "保障内容１０");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHosyouNaiyou11(), "保険法対応契約", "保障内容１１");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHosyouNaiyou12(), "保険契約者代理特約あり", "保障内容１２");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHosyouNaiyou13(), "指定代理請求特約あり", "保障内容１３");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHosyouNaiyou14(), "", "保障内容１４");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHosyouNaiyou15(), "", "保障内容１５");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHosyouNaiyou16(), "", "保障内容１６");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHosyouNaiyou17(), "", "保障内容１７");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHosyouNaiyou18(), "", "保障内容１８");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHosyouNaiyou19(), "", "保障内容１９");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHosyouNaiyou20(), "", "保障内容２０");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHosyouNaiyou21(), "", "保障内容２１");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHosyouNaiyou22(), "", "保障内容２２");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHosyouNaiyou23(), "", "保障内容２３");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHosyouNaiyou24(), "", "保障内容２４");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHosyouNaiyou25(), "", "保障内容２５");
        exNumericEquals(webKykNaiyouSyoukaiInfoBean.getHenkouKeiiGyousuu(), 1, "変更経緯行数");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHenkouKeii1(), "平成２７年１２月　１日　契約内容変更", "変更経緯１");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHenkouKeii2(), "", "変更経緯２");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHenkouKeii3(), "", "変更経緯３");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHenkouKeii4(), "", "変更経緯４");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHenkouKeii5(), "", "変更経緯５");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHenkouKeii6(), "", "変更経緯６");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHenkouKeii7(), "", "変更経緯７");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHenkouKeii8(), "", "変更経緯８");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHenkouKeii9(), "", "変更経緯９");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHenkouKeii10(), "", "変更経緯１０");
        exNumericEquals(webKykNaiyouSyoukaiInfoBean.getBosyuDrtenGyousuu(), 1, "募集代理店行数");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getBosyuDrtenNm1(), "取扱代理店名３", "募集代理店名１");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getDrtenBnwari1(), "", "代理店分割割合１");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getBosyuDrtenNm2(), "", "募集代理店名２");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getDrtenBnwari2(), "", "代理店分割割合２");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getMsgOutKbn(), "2", "MSG出力区分");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHosyouIkkatuMinaokeiyakuHyouji(), "0", "保障一括見直契約表示");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHhknnmkn(), "ﾋﾎｹﾝｼｶﾅ", "被保険者氏名(ｶﾅ)");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHokenryouSyuunouJyoukyou(), "－", "保険料収納状況");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getJikaiHokenryouJyuutouYm(), "－", "次回保険料充当年月");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getMdhansybetuKbn(), "01", "窓販種別区分");

    }

    @Test
    @TestOrder(560)
    public void testExec_A56() {
        changeSystemDate();

        MockObjectManager.initialize();
        BzGetProcessSummaryMockForHozen.SYORIPTN = BzGetProcessSummaryMockForHozen.TESTPATTERN2;
        BzGetAdrDataMockForHozen.SYORIPTN = BzGetAdrDataMockForHozen.TESTPATTERN1;
        CalcHkShrKngkMockForHozen.SYORIPTN = CalcHkShrKngkMockForHozen.TESTPATTERN4;
        KeisanWExtMockForHozen.SYORIPTN = KeisanWExtMockForHozen.TESTPATTERN2;
        KeisanWMockForHozen.SYORIPTN = KeisanWMockForHozen.TESTPATTERN1;
        KeisanKijyungkMockForHozen.SYORIPTN = KeisanKijyungkMockForHozen.TESTPATTERN2;
        KeisanGaikakanzanMockForHozen.SYORIPTN = KeisanGaikakanzanMockForHozen.TESTPATTERN1;
        SetNenreiMockForHozen.SYORIPTN = SetNenreiMockForHozen.TESTPATTERN1;
        HanteiKhSisuurendoTmttknJyoutaiMockForHozen.SYORIPTN = HanteiKhSisuurendoTmttknJyoutaiMockForHozen.TESTPATTERN1;

        WebKykNaiyouSyoukaiInfoBean webKykNaiyouSyoukaiInfoBean =
            hbKeiyakuSyoukai.exec("17806000149", BizDate.valueOf("20170621"), C_TanmatuSiyouKbn.DAIRITENBOSYUUNIN, "100006");

        exStringEquals(webKykNaiyouSyoukaiInfoBean.getErrorKbn(), "", "エラー区分");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getErrorMsg(), "", "エラーメッセージ");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getKyknmkn(), "ｶﾅ", "契約者名（カナ）");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getKyknmkj(), "契約者名漢字１－４１　様", "契約者名（漢字）");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getKykseiymd(), "昭和５５年　１月　１日", "契約者生年月日");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getKojinhjnKbn(), "個人", "個人法人区分");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTelno(), "010-1234-5678", "電話番号");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getPostalCd(), "２２３－４５６７", "郵便番号");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getAdr(), "通信先住所１通信先住所２通信先住所３", "住所");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getAdrkn(), "ｶﾅｶﾅｶﾅｶﾅ", "住所(ｶﾅ)");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHhknnm(), "被保険者名　様", "被保険者氏名");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHhknsei(), "女性", "被保険者性別");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHhknseiymd(), "昭和５６年　１月　１日", "被保険者生年月日");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHhknNen(), "３５歳", "被保険者年齢");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHhknKykjiNen(), "２５歳", "被保険者契約時年齢");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getSyouhnnm(), "笑顔の約束", "商品名");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getSyurui(), "年金保険", "種類");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getSyono(), "17806000149", "証券番号");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getCifCd(), "*****", "CIFｺｰﾄﾞ");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getKykymd(), "平成２８年　６月２１日", "契約日");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHrkhou(), "月払　口座振替扱", "払込方法");
        exBizCalcbleEquals(webKykNaiyouSyoukaiInfoBean.getSibous()
            , BizCurrency.valueOf(10000.00, BizCurrencyTypes.AU_DOLLAR), "死亡保険金");
        Assert.assertEquals(webKykNaiyouSyoukaiInfoBean.getSibous().getType(), BizCurrencyTypes.AU_DOLLAR);
        exBizCalcbleEquals(webKykNaiyouSyoukaiInfoBean.getHrkp()
            , BizCurrency.valueOf(1001.00, BizCurrencyTypes.AU_DOLLAR), "払込保険料");
        Assert.assertEquals(webKykNaiyouSyoukaiInfoBean.getHrkp().getType(), BizCurrencyTypes.AU_DOLLAR);
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getNkShrStartYmd(), "平成２９年　１月　１日", "年金支払開始日");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getNenkinHosyouYear(), "", "年金保証年");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getNenkinKbn(), "", "年金区分");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHaitouKbn(), "準有配当", "配当区分");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getSinsaKbn(), "", "診査区分");
        exNumericEquals(webKykNaiyouSyoukaiInfoBean.getTksuu(), 3, "特約数");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getLivingneedsTkhyj(), "", "リビングニーズ特約表示");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHokenMankiDay(), "平成２８年１２月３１日", "保険満期日");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getSyunm(), "個人年金", "主契約名称");
        exBizCalcbleEquals(webKykNaiyouSyoukaiInfoBean.getSyus(), BizCurrency.optional(), "主契約保険金額");
        Assert.assertEquals(webKykNaiyouSyoukaiInfoBean.getSyus().getType()
            , BizNumberConfig.instance.getDefaultCurrencyType());
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getSyuhknkkn(), "６０歳まで", "主契約保険期間");
        exNumericEquals(webKykNaiyouSyoukaiInfoBean.getTkNaiyouGyousuu(), 3, "特約内容行数");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTknm1(), "保険契約者代理特約", "特約名称１");
        exBizCalcbleEquals(webKykNaiyouSyoukaiInfoBean.getTks1(), BizCurrency.optional(), "特約保険金額１");
        Assert.assertEquals(webKykNaiyouSyoukaiInfoBean.getTks1().getType()
            , BizNumberConfig.instance.getDefaultCurrencyType());
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTokuyakuhokenkikan1(), "", "特約保険期間１");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTokuyakuharaikomikikan1(), "", "特約払込期間１");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTknm2(),"指定代理請求特約", "特約名称２");
        exBizCalcbleEquals(webKykNaiyouSyoukaiInfoBean.getTks2(),BizCurrency.optional(), "特約保険金額２");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTokuyakuhokenkikan2(), "", "特約保険期間２");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTokuyakuharaikomikikan2(), "", "特約払込期間２");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTknm3(), "個人年金保険料税制適格特約（’９０）", "特約名称３");
        exBizCalcbleEquals(webKykNaiyouSyoukaiInfoBean.getTks3(), BizCurrency.optional(), "特約保険金額３");
        Assert.assertEquals(webKykNaiyouSyoukaiInfoBean.getTks3().getType()
            , BizNumberConfig.instance.getDefaultCurrencyType());
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTokuyakuhokenkikan3(), "", "特約保険期間３");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTokuyakuharaikomikikan3(), "", "特約払込期間３");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTknm4(), "", "特約名称４");
        exBizCalcbleEquals(webKykNaiyouSyoukaiInfoBean.getTks4(), BizCurrency.optional(), "特約保険金額４");
        Assert.assertEquals(webKykNaiyouSyoukaiInfoBean.getTks4().getType()
            , BizNumberConfig.instance.getDefaultCurrencyType());
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTokuyakuhokenkikan4(), "", "特約保険期間４");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTokuyakuharaikomikikan4(), "", "特約払込期間４");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTknm5(), "", "特約名称５");
        exBizCalcbleEquals(webKykNaiyouSyoukaiInfoBean.getTks5(), BizCurrency.optional(), "特約保険金額５");
        Assert.assertEquals(webKykNaiyouSyoukaiInfoBean.getTks5().getType()
            , BizNumberConfig.instance.getDefaultCurrencyType());
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTokuyakuhokenkikan5(), "", "特約保険期間５");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTokuyakuharaikomikikan5(), "", "特約払込期間５");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTknm6(), "", "特約名称６");
        exBizCalcbleEquals(webKykNaiyouSyoukaiInfoBean.getTks6(), BizCurrency.optional(), "特約保険金額６");
        Assert.assertEquals(webKykNaiyouSyoukaiInfoBean.getTks6().getType()
            , BizNumberConfig.instance.getDefaultCurrencyType());
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTokuyakuhokenkikan6(), "", "特約保険期間６");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTokuyakuharaikomikikan6(), "", "特約払込期間６");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTknm7(), "", "特約名称７");
        exBizCalcbleEquals(webKykNaiyouSyoukaiInfoBean.getTks7(), BizCurrency.optional(), "特約保険金額７");
        Assert.assertEquals(webKykNaiyouSyoukaiInfoBean.getTks7().getType()
            , BizNumberConfig.instance.getDefaultCurrencyType());
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTokuyakuhokenkikan7(), "", "特約保険期間７");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTokuyakuharaikomikikan7(), "", "特約払込期間７");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTknm8(), "", "特約名称８");
        exBizCalcbleEquals(webKykNaiyouSyoukaiInfoBean.getTks8(), BizCurrency.optional(), "特約保険金額８");
        Assert.assertEquals(webKykNaiyouSyoukaiInfoBean.getTks8().getType()
            , BizNumberConfig.instance.getDefaultCurrencyType());
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTokuyakuhokenkikan8(), "", "特約保険期間８");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTokuyakuharaikomikikan8(), "", "特約払込期間８");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTknm9(), "", "特約名称９");
        exBizCalcbleEquals(webKykNaiyouSyoukaiInfoBean.getTks9(), BizCurrency.optional(), "特約保険金額９");
        Assert.assertEquals(webKykNaiyouSyoukaiInfoBean.getTks9().getType()
            , BizNumberConfig.instance.getDefaultCurrencyType());
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTokuyakuhokenkikan9(), "", "特約保険期間９");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTokuyakuharaikomikikan9(), "", "特約払込期間９");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTknm10(), "", "特約名称１０");
        exBizCalcbleEquals(webKykNaiyouSyoukaiInfoBean.getTks10(), BizCurrency.optional(), "特約保険金額１０");
        Assert.assertEquals(webKykNaiyouSyoukaiInfoBean.getTks10().getType()
            , BizNumberConfig.instance.getDefaultCurrencyType());
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTokuyakuhokenkikan10(), "", "特約保険期間１０");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTokuyakuharaikomikikan10(), "", "特約払込期間１０");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTknm11(), "", "特約名称１１");
        exBizCalcbleEquals(webKykNaiyouSyoukaiInfoBean.getTks11(), BizCurrency.optional(), "特約保険金額１１");
        Assert.assertEquals(webKykNaiyouSyoukaiInfoBean.getTks11().getType()
            , BizNumberConfig.instance.getDefaultCurrencyType());
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTokuyakuhokenkikan11(), "", "特約保険期間１１");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTokuyakuharaikomikikan11(), "", "特約払込期間１１");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTknm12(), "", "特約名称１２");
        exBizCalcbleEquals(webKykNaiyouSyoukaiInfoBean.getTks12(), BizCurrency.optional(), "特約保険金額１２");
        Assert.assertEquals(webKykNaiyouSyoukaiInfoBean.getTks12().getType()
            , BizNumberConfig.instance.getDefaultCurrencyType());
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTokuyakuhokenkikan12(), "", "特約保険期間１２");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTokuyakuharaikomikikan12(), "", "特約払込期間１２");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTknm13(), "", "特約名称１３");
        exBizCalcbleEquals(webKykNaiyouSyoukaiInfoBean.getTks13(), BizCurrency.optional(), "特約保険金額１３");
        Assert.assertEquals(webKykNaiyouSyoukaiInfoBean.getTks13().getType()
            , BizNumberConfig.instance.getDefaultCurrencyType());
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTokuyakuhokenkikan13(), "", "特約保険期間１３");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTokuyakuharaikomikikan13(), "", "特約払込期間１３");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTknm14(), "", "特約名称１４");
        exBizCalcbleEquals(webKykNaiyouSyoukaiInfoBean.getTks14(), BizCurrency.optional(), "特約保険金額１４");
        Assert.assertEquals(webKykNaiyouSyoukaiInfoBean.getTks14().getType()
            , BizNumberConfig.instance.getDefaultCurrencyType());
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTokuyakuhokenkikan14(), "", "特約保険期間１４");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTokuyakuharaikomikikan14(), "", "特約払込期間１４");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTknm15(), "", "特約名称１５");
        exBizCalcbleEquals(webKykNaiyouSyoukaiInfoBean.getTks15(), BizCurrency.optional(), "特約保険金額１５");
        Assert.assertEquals(webKykNaiyouSyoukaiInfoBean.getTks15().getType()
            , BizNumberConfig.instance.getDefaultCurrencyType());
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTokuyakuhokenkikan15(), "", "特約保険期間１５");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTokuyakuharaikomikikan15(), "", "特約払込期間１５");
        exNumericEquals(webKykNaiyouSyoukaiInfoBean.getSyouhnNaiyouGyousuu(), 1, "商品内容行数");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getSyouhnNaiyou1(), "現在の保障内容は下記のとおりです。", "商品内容１");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getSyouhnNaiyou2(), "", "商品内容２");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getSyouhnNaiyou3(), "", "商品内容３");
        exNumericEquals(webKykNaiyouSyoukaiInfoBean.getHosyouNaiyouGyousuu(), 18, "保障内容行数");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHosyouNaiyou1(), "死亡時支払金受取人　契約者　様", "保障内容１");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHosyouNaiyou2(), "年金受取人　　　　　", "保障内容２");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHosyouNaiyou3(), "契約者代理人　　　　カゾクメイ２　１－４１　様　　　　　　　　　生年月日　平成１３年　１月　１日", "保障内容３");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHosyouNaiyou4(), "指定代理請求人　　　カゾクメイ２　１－４１　様　　　　　　　　　生年月日　平成１３年　１月　１日", "保障内容４");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHosyouNaiyou5(), "登録家族（１人目）　登録されておりません", "保障内容５");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHosyouNaiyou6(), "登録家族（２人目）　カゾクメイ２　１－４１　様　　　　　　　　　生年月日　平成１３年　１月　１日", "保障内容６");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHosyouNaiyou7(), "払込保険料の円換算額　　　　１１，０００円", "保障内容７");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHosyouNaiyou8(), "　保険料領収日時点の円換算為替レート　１豪ドル＝５０円（平成２９年　７月　１日）", "保障内容８");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHosyouNaiyou9(), "予定利率　３．４３％", "保障内容９");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHosyouNaiyou10(), "死亡時（照会日時点）　　　　１０，０００．００豪ドル　　（１００円）", "保障内容１０");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHosyouNaiyou11(), "（保険料の払込回数に応じて計算しております。）", "保障内容１１");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHosyouNaiyou12(), "解約返戻金額（照会日時点）　１，０００．００豪ドル　　（１００円）", "保障内容１２");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHosyouNaiyou13(), "上記（）内の金額は、照会時点の為替レートで円換算した参考値であり変動します。", "保障内容１３");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHosyouNaiyou14(), "年金開始日　　　　　　　　平成２９年　１月　１日", "保障内容１４");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHosyouNaiyou15(), "保険法対応契約", "保障内容１５");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHosyouNaiyou16(), "個人年金保険料税制適格特約（’９０）あり", "保障内容１６");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHosyouNaiyou17(), "保険契約者代理特約あり", "保障内容１７");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHosyouNaiyou18(), "指定代理請求特約あり", "保障内容１８");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHosyouNaiyou19(), "", "保障内容１９");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHosyouNaiyou20(), "", "保障内容２０");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHosyouNaiyou21(), "", "保障内容２１");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHosyouNaiyou22(), "", "保障内容２２");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHosyouNaiyou23(), "", "保障内容２３");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHosyouNaiyou24(), "", "保障内容２４");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHosyouNaiyou25(), "", "保障内容２５");
        exNumericEquals(webKykNaiyouSyoukaiInfoBean.getHenkouKeiiGyousuu(), 1, "変更経緯行数");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHenkouKeii1(), "平成２７年１２月　１日　契約内容変更", "変更経緯１");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHenkouKeii2(), "", "変更経緯２");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHenkouKeii3(), "", "変更経緯３");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHenkouKeii4(), "", "変更経緯４");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHenkouKeii5(), "", "変更経緯５");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHenkouKeii6(), "", "変更経緯６");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHenkouKeii7(), "", "変更経緯７");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHenkouKeii8(), "", "変更経緯８");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHenkouKeii9(), "", "変更経緯９");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHenkouKeii10(), "", "変更経緯１０");
        exNumericEquals(webKykNaiyouSyoukaiInfoBean.getBosyuDrtenGyousuu(), 1, "募集代理店行数");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getBosyuDrtenNm1(), "取扱代理店名３", "募集代理店名１");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getDrtenBnwari1(), "", "代理店分割割合１");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getBosyuDrtenNm2(), "", "募集代理店名２");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getDrtenBnwari2(), "", "代理店分割割合２");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getMsgOutKbn(), "2", "MSG出力区分");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHosyouIkkatuMinaokeiyakuHyouji(), "0", "保障一括見直契約表示");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHhknnmkn(), "ﾋﾎｹﾝｼｶﾅ", "被保険者氏名(ｶﾅ)");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHokenryouSyuunouJyoukyou(), "正常収納中", "保険料収納状況");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getJikaiHokenryouJyuutouYm(), "平成２８年　７月", "次回保険料充当年月");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getMdhansybetuKbn(), "01", "窓販種別区分");

    }

    @Test
    @TestOrder(570)
    public void testExec_A57() {
        changeSystemDate();

        MockObjectManager.initialize();
        BzGetProcessSummaryMockForHozen.SYORIPTN = BzGetProcessSummaryMockForHozen.TESTPATTERN2;
        BzGetAdrDataMockForHozen.SYORIPTN = BzGetAdrDataMockForHozen.TESTPATTERN1;
        CalcHkShrKngkMockForHozen.SYORIPTN = CalcHkShrKngkMockForHozen.TESTPATTERN4;
        KeisanWExtMockForHozen.SYORIPTN = KeisanWExtMockForHozen.TESTPATTERN2;
        KeisanWMockForHozen.SYORIPTN = KeisanWMockForHozen.TESTPATTERN1;
        KeisanKijyungkMockForHozen.SYORIPTN = KeisanKijyungkMockForHozen.TESTPATTERN2;
        KeisanGaikakanzanMockForHozen.SYORIPTN = KeisanGaikakanzanMockForHozen.TESTPATTERN1;
        SetNenreiMockForHozen.SYORIPTN = SetNenreiMockForHozen.TESTPATTERN1;
        HanteiKhSisuurendoTmttknJyoutaiMockForHozen.SYORIPTN = HanteiKhSisuurendoTmttknJyoutaiMockForHozen.TESTPATTERN1;

        WebKykNaiyouSyoukaiInfoBean webKykNaiyouSyoukaiInfoBean =
            hbKeiyakuSyoukai.exec("17806000150", BizDate.valueOf("20161221"), C_TanmatuSiyouKbn.DAIRITENBOSYUUNIN, "100006");

        exStringEquals(webKykNaiyouSyoukaiInfoBean.getErrorKbn(), "", "エラー区分");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getErrorMsg(), "", "エラーメッセージ");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getKyknmkn(), "ｶﾅ", "契約者名（カナ）");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getKyknmkj(), "契約者名漢字１－４２　様", "契約者名（漢字）");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getKykseiymd(), "昭和５５年　１月　１日", "契約者生年月日");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getKojinhjnKbn(), "個人", "個人法人区分");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTelno(), "010-1234-5678", "電話番号");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getPostalCd(), "２２３－４５６７", "郵便番号");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getAdr(), "通信先住所１通信先住所２通信先住所３", "住所");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getAdrkn(), "ｶﾅｶﾅｶﾅｶﾅ", "住所(ｶﾅ)");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHhknnm(), "被保険者名　様", "被保険者氏名");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHhknsei(), "女性", "被保険者性別");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHhknseiymd(), "昭和５６年　１月　１日", "被保険者生年月日");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHhknNen(), "３５歳", "被保険者年齢");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHhknKykjiNen(), "２５歳", "被保険者契約時年齢");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getSyouhnnm(), "笑顔の約束", "商品名");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getSyurui(), "年金保険", "種類");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getSyono(), "17806000150", "証券番号");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getCifCd(), "*****", "CIFｺｰﾄﾞ");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getKykymd(), "平成２８年　６月２１日", "契約日");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHrkhou(), "月払　口座振替扱", "払込方法");
        exBizCalcbleEquals(webKykNaiyouSyoukaiInfoBean.getSibous()
            , BizCurrency.valueOf(10000.00, BizCurrencyTypes.AU_DOLLAR), "死亡保険金");
        Assert.assertEquals(webKykNaiyouSyoukaiInfoBean.getSibous().getType(), BizCurrencyTypes.AU_DOLLAR);
        exBizCalcbleEquals(webKykNaiyouSyoukaiInfoBean.getHrkp()
            , BizCurrency.valueOf(1001.00, BizCurrencyTypes.AU_DOLLAR), "払込保険料");
        Assert.assertEquals(webKykNaiyouSyoukaiInfoBean.getHrkp().getType(), BizCurrencyTypes.AU_DOLLAR);
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getNkShrStartYmd(), "平成２９年　１月　１日", "年金支払開始日");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getNenkinHosyouYear(), "", "年金保証年");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getNenkinKbn(), "", "年金区分");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHaitouKbn(), "準有配当", "配当区分");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getSinsaKbn(), "", "診査区分");
        exNumericEquals(webKykNaiyouSyoukaiInfoBean.getTksuu(), 3, "特約数");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getLivingneedsTkhyj(), "", "リビングニーズ特約表示");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHokenMankiDay(), "平成２８年１２月３１日", "保険満期日");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getSyunm(), "個人年金", "主契約名称");
        exBizCalcbleEquals(webKykNaiyouSyoukaiInfoBean.getSyus(), BizCurrency.optional(), "主契約保険金額");
        Assert.assertEquals(webKykNaiyouSyoukaiInfoBean.getSyus().getType()
            , BizNumberConfig.instance.getDefaultCurrencyType());
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getSyuhknkkn(), "６０歳まで", "主契約保険期間");
        exNumericEquals(webKykNaiyouSyoukaiInfoBean.getTkNaiyouGyousuu(), 3, "特約内容行数");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTknm1(), "保険契約者代理特約", "特約名称１");
        exBizCalcbleEquals(webKykNaiyouSyoukaiInfoBean.getTks1(), BizCurrency.optional(), "特約保険金額１");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTokuyakuhokenkikan1(), "", "特約保険期間１");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTokuyakuharaikomikikan1(), "", "特約払込期間１");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTknm2(),"指定代理請求特約", "特約名称２");
        exBizCalcbleEquals(webKykNaiyouSyoukaiInfoBean.getTks2(),BizCurrency.optional(), "特約保険金額２");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTokuyakuhokenkikan2(), "", "特約保険期間２");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTokuyakuharaikomikikan2(), "", "特約払込期間２");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTknm3(), "個人年金保険料税制適格特約（’９０）", "特約名称３");
        exBizCalcbleEquals(webKykNaiyouSyoukaiInfoBean.getTks3(), BizCurrency.optional(), "特約保険金額３");
        Assert.assertEquals(webKykNaiyouSyoukaiInfoBean.getTks3().getType()
            , BizNumberConfig.instance.getDefaultCurrencyType());
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTokuyakuhokenkikan3(), "", "特約保険期間３");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTokuyakuharaikomikikan3(), "", "特約払込期間３");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTknm4(), "", "特約名称４");
        exBizCalcbleEquals(webKykNaiyouSyoukaiInfoBean.getTks4(), BizCurrency.optional(), "特約保険金額４");
        Assert.assertEquals(webKykNaiyouSyoukaiInfoBean.getTks4().getType()
            , BizNumberConfig.instance.getDefaultCurrencyType());
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTokuyakuhokenkikan4(), "", "特約保険期間４");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTokuyakuharaikomikikan4(), "", "特約払込期間４");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTknm5(), "", "特約名称５");
        exBizCalcbleEquals(webKykNaiyouSyoukaiInfoBean.getTks5(), BizCurrency.optional(), "特約保険金額５");
        Assert.assertEquals(webKykNaiyouSyoukaiInfoBean.getTks5().getType()
            , BizNumberConfig.instance.getDefaultCurrencyType());
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTokuyakuhokenkikan5(), "", "特約保険期間５");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTokuyakuharaikomikikan5(), "", "特約払込期間５");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTknm6(), "", "特約名称６");
        exBizCalcbleEquals(webKykNaiyouSyoukaiInfoBean.getTks6(), BizCurrency.optional(), "特約保険金額６");
        Assert.assertEquals(webKykNaiyouSyoukaiInfoBean.getTks6().getType()
            , BizNumberConfig.instance.getDefaultCurrencyType());
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTokuyakuhokenkikan6(), "", "特約保険期間６");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTokuyakuharaikomikikan6(), "", "特約払込期間６");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTknm7(), "", "特約名称７");
        exBizCalcbleEquals(webKykNaiyouSyoukaiInfoBean.getTks7(), BizCurrency.optional(), "特約保険金額７");
        Assert.assertEquals(webKykNaiyouSyoukaiInfoBean.getTks7().getType()
            , BizNumberConfig.instance.getDefaultCurrencyType());
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTokuyakuhokenkikan7(), "", "特約保険期間７");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTokuyakuharaikomikikan7(), "", "特約払込期間７");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTknm8(), "", "特約名称８");
        exBizCalcbleEquals(webKykNaiyouSyoukaiInfoBean.getTks8(), BizCurrency.optional(), "特約保険金額８");
        Assert.assertEquals(webKykNaiyouSyoukaiInfoBean.getTks8().getType()
            , BizNumberConfig.instance.getDefaultCurrencyType());
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTokuyakuhokenkikan8(), "", "特約保険期間８");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTokuyakuharaikomikikan8(), "", "特約払込期間８");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTknm9(), "", "特約名称９");
        exBizCalcbleEquals(webKykNaiyouSyoukaiInfoBean.getTks9(), BizCurrency.optional(), "特約保険金額９");
        Assert.assertEquals(webKykNaiyouSyoukaiInfoBean.getTks9().getType()
            , BizNumberConfig.instance.getDefaultCurrencyType());
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTokuyakuhokenkikan9(), "", "特約保険期間９");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTokuyakuharaikomikikan9(), "", "特約払込期間９");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTknm10(), "", "特約名称１０");
        exBizCalcbleEquals(webKykNaiyouSyoukaiInfoBean.getTks10(), BizCurrency.optional(), "特約保険金額１０");
        Assert.assertEquals(webKykNaiyouSyoukaiInfoBean.getTks10().getType()
            , BizNumberConfig.instance.getDefaultCurrencyType());
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTokuyakuhokenkikan10(), "", "特約保険期間１０");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTokuyakuharaikomikikan10(), "", "特約払込期間１０");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTknm11(), "", "特約名称１１");
        exBizCalcbleEquals(webKykNaiyouSyoukaiInfoBean.getTks11(), BizCurrency.optional(), "特約保険金額１１");
        Assert.assertEquals(webKykNaiyouSyoukaiInfoBean.getTks11().getType()
            , BizNumberConfig.instance.getDefaultCurrencyType());
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTokuyakuhokenkikan11(), "", "特約保険期間１１");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTokuyakuharaikomikikan11(), "", "特約払込期間１１");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTknm12(), "", "特約名称１２");
        exBizCalcbleEquals(webKykNaiyouSyoukaiInfoBean.getTks12(), BizCurrency.optional(), "特約保険金額１２");
        Assert.assertEquals(webKykNaiyouSyoukaiInfoBean.getTks12().getType()
            , BizNumberConfig.instance.getDefaultCurrencyType());
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTokuyakuhokenkikan12(), "", "特約保険期間１２");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTokuyakuharaikomikikan12(), "", "特約払込期間１２");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTknm13(), "", "特約名称１３");
        exBizCalcbleEquals(webKykNaiyouSyoukaiInfoBean.getTks13(), BizCurrency.optional(), "特約保険金額１３");
        Assert.assertEquals(webKykNaiyouSyoukaiInfoBean.getTks13().getType()
            , BizNumberConfig.instance.getDefaultCurrencyType());
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTokuyakuhokenkikan13(), "", "特約保険期間１３");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTokuyakuharaikomikikan13(), "", "特約払込期間１３");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTknm14(), "", "特約名称１４");
        exBizCalcbleEquals(webKykNaiyouSyoukaiInfoBean.getTks14(), BizCurrency.optional(), "特約保険金額１４");
        Assert.assertEquals(webKykNaiyouSyoukaiInfoBean.getTks14().getType()
            , BizNumberConfig.instance.getDefaultCurrencyType());
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTokuyakuhokenkikan14(), "", "特約保険期間１４");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTokuyakuharaikomikikan14(), "", "特約払込期間１４");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTknm15(), "", "特約名称１５");
        exBizCalcbleEquals(webKykNaiyouSyoukaiInfoBean.getTks15(), BizCurrency.optional(), "特約保険金額１５");
        Assert.assertEquals(webKykNaiyouSyoukaiInfoBean.getTks15().getType()
            , BizNumberConfig.instance.getDefaultCurrencyType());
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTokuyakuhokenkikan15(), "", "特約保険期間１５");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTokuyakuharaikomikikan15(), "", "特約払込期間１５");
        exNumericEquals(webKykNaiyouSyoukaiInfoBean.getSyouhnNaiyouGyousuu(), 1, "商品内容行数");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getSyouhnNaiyou1(), "現在の保障内容は下記のとおりです。", "商品内容１");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getSyouhnNaiyou2(), "", "商品内容２");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getSyouhnNaiyou3(), "", "商品内容３");
        exNumericEquals(webKykNaiyouSyoukaiInfoBean.getHosyouNaiyouGyousuu(), 15, "保障内容行数");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHosyouNaiyou1(), "死亡時支払金受取人　契約者　様", "保障内容１");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHosyouNaiyou2(), "年金受取人　　　　　", "保障内容２");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHosyouNaiyou3(), "契約者代理人　　　　家族名２　１－４２　様　　　　　　　　　", "保障内容３");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHosyouNaiyou4(), "指定代理請求人　　　家族名２　１－４２　様　　　　　　　　　", "保障内容４");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHosyouNaiyou5(), "登録家族（１人目）　登録されておりません", "保障内容５");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHosyouNaiyou6(), "登録家族（２人目）　家族名２　１－４２　様　　　　　　　　　", "保障内容６");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHosyouNaiyou7(), "予定利率　３．１９％", "保障内容７");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHosyouNaiyou8(), "死亡時　　　　　　　　　　　１０，０００円", "保障内容８");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHosyouNaiyou9(), "（保険料の払込回数に応じて計算しております。）", "保障内容９");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHosyouNaiyou10(), "解約返戻金額（照会日時点）　１，０００円", "保障内容１０");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHosyouNaiyou11(), "年金開始日　　　　　　　　平成２９年　１月　１日", "保障内容１１");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHosyouNaiyou12(), "保険法対応契約", "保障内容１２");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHosyouNaiyou13(), "個人年金保険料税制適格特約（’９０）あり", "保障内容１３");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHosyouNaiyou14(), "保険契約者代理特約あり", "保障内容１４");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHosyouNaiyou15(), "指定代理請求特約あり", "保障内容１５");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHosyouNaiyou16(), "", "保障内容１６");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHosyouNaiyou17(), "", "保障内容１７");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHosyouNaiyou18(), "", "保障内容１８");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHosyouNaiyou19(), "", "保障内容１９");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHosyouNaiyou20(), "", "保障内容２０");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHosyouNaiyou21(), "", "保障内容２１");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHosyouNaiyou22(), "", "保障内容２２");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHosyouNaiyou23(), "", "保障内容２３");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHosyouNaiyou24(), "", "保障内容２４");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHosyouNaiyou25(), "", "保障内容２５");
        exNumericEquals(webKykNaiyouSyoukaiInfoBean.getHenkouKeiiGyousuu(), 1, "変更経緯行数");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHenkouKeii1(), "平成２７年１２月　１日　契約内容変更", "変更経緯１");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHenkouKeii2(), "", "変更経緯２");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHenkouKeii3(), "", "変更経緯３");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHenkouKeii4(), "", "変更経緯４");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHenkouKeii5(), "", "変更経緯５");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHenkouKeii6(), "", "変更経緯６");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHenkouKeii7(), "", "変更経緯７");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHenkouKeii8(), "", "変更経緯８");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHenkouKeii9(), "", "変更経緯９");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHenkouKeii10(), "", "変更経緯１０");
        exNumericEquals(webKykNaiyouSyoukaiInfoBean.getBosyuDrtenGyousuu(), 1, "募集代理店行数");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getBosyuDrtenNm1(), "取扱代理店名３", "募集代理店名１");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getDrtenBnwari1(), "", "代理店分割割合１");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getBosyuDrtenNm2(), "", "募集代理店名２");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getDrtenBnwari2(), "", "代理店分割割合２");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getMsgOutKbn(), "2", "MSG出力区分");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHosyouIkkatuMinaokeiyakuHyouji(), "0", "保障一括見直契約表示");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHhknnmkn(), "ﾋﾎｹﾝｼｶﾅ", "被保険者氏名(ｶﾅ)");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHokenryouSyuunouJyoukyou(), "正常収納中", "保険料収納状況");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getJikaiHokenryouJyuutouYm(), "平成２８年　７月", "次回保険料充当年月");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getMdhansybetuKbn(), "01", "窓販種別区分");

    }

    @Test
    @TestOrder(580)
    public void testExec_A58() {
        changeSystemDate();

        MockObjectManager.initialize();
        WebKykNaiyouSyoukaiInfoBean webKykNaiyouSyoukaiInfoBean =
            hbKeiyakuSyoukai.exec("99809111703", BizDate.valueOf("20160621"), C_TanmatuSiyouKbn.DAIRITENBOSYUUNIN,
                "100007");

        exStringEquals(webKykNaiyouSyoukaiInfoBean.getErrorKbn(), "1", "エラー区分");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getErrorMsg()
            , "選択されたご契約についてはご照会できません。", "エラーメッセージ");
        CheckEebKykNaiyouSyoukaiInfoBean(webKykNaiyouSyoukaiInfoBean);

    }

    @Test
    @TestOrder(590)
    public void testExec_A59() {
        changeSystemDate();

        MockObjectManager.initialize();
        BzGetProcessSummaryMockForHozen.SYORIPTN = BzGetProcessSummaryMockForHozen.TESTPATTERN2;
        BzGetAdrDataMockForHozen.SYORIPTN = BzGetAdrDataMockForHozen.TESTPATTERN1;
        WebKykNaiyouSyoukaiInfoBean webKykNaiyouSyoukaiInfoBean =
            hbKeiyakuSyoukai.exec("17806000943", BizDate.valueOf("20160621"), C_TanmatuSiyouKbn.SOUGOU_IPPAN, null);

        exStringEquals(webKykNaiyouSyoukaiInfoBean.getErrorKbn(), "1", "エラー区分");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getErrorMsg()
            , "選択されたご契約についてはご照会できません。", "エラーメッセージ");
        CheckEebKykNaiyouSyoukaiInfoBean(webKykNaiyouSyoukaiInfoBean);

    }

    @Test
    @TestOrder(600)
    public void testExec_A60() {
        changeSystemDate();

        MockObjectManager.initialize();
        BzGetProcessSummaryMockForHozen.SYORIPTN = BzGetProcessSummaryMockForHozen.TESTPATTERN2;
        BzGetAdrDataMockForHozen.SYORIPTN = BzGetAdrDataMockForHozen.TESTPATTERN1;


        WebKykNaiyouSyoukaiInfoBean webKykNaiyouSyoukaiInfoBean =
            hbKeiyakuSyoukai.exec("17806000943", BizDate.valueOf("20160621"), C_TanmatuSiyouKbn.SOUGOU_IPPAN, null);

        exStringEquals(webKykNaiyouSyoukaiInfoBean.getErrorKbn(), "1", "エラー区分");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getErrorMsg()
            , "選択されたご契約についてはご照会できません。", "エラーメッセージ");
        CheckEebKykNaiyouSyoukaiInfoBean(webKykNaiyouSyoukaiInfoBean);

    }

    @Test
    @TestOrder(610)
    public void testExec_A61() {
        changeSystemDate();

        MockObjectManager.initialize();
        BzGetProcessSummaryMockForHozen.SYORIPTN = BzGetProcessSummaryMockForHozen.TESTPATTERN2;
        BzGetAdrDataMockForHozen.SYORIPTN = BzGetAdrDataMockForHozen.TESTPATTERN1;
        CalcHkShrKngkMockForHozen.SYORIPTN = CalcHkShrKngkMockForHozen.TESTPATTERN3;
        KeisanWExtMockForHozen.SYORIPTN = KeisanWExtMockForHozen.TESTPATTERN2;
        KeisanWMockForHozen.SYORIPTN = KeisanWMockForHozen.TESTPATTERN1;
        KeisanKijyungkMockForHozen.SYORIPTN = KeisanKijyungkMockForHozen.TESTPATTERN2;
        KeisanGaikakanzanMockForHozen.SYORIPTN = KeisanGaikakanzanMockForHozen.TESTPATTERN1;
        SetNenreiMockForHozen.SYORIPTN = SetNenreiMockForHozen.TESTPATTERN1;
        HanteiKhSisuurendoTmttknJyoutaiMockForHozen.SYORIPTN = HanteiKhSisuurendoTmttknJyoutaiMockForHozen.TESTPATTERN2;



        WebKykNaiyouSyoukaiInfoBean webKykNaiyouSyoukaiInfoBean =
            hbKeiyakuSyoukai.exec("17806000161", BizDate.valueOf("20160621"), C_TanmatuSiyouKbn.DAIRITENBOSYUUNIN, "100006");

        exStringEquals(webKykNaiyouSyoukaiInfoBean.getErrorKbn(), "", "エラー区分");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getErrorMsg(), "", "エラーメッセージ");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getKyknmkn(), "ｶﾅ", "契約者名（カナ）");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getKyknmkj(), "契約者名漢字１－４３　様", "契約者名（漢字）");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getKykseiymd(), "昭和５５年　１月　１日", "契約者生年月日");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getKojinhjnKbn(), "個人", "個人法人区分");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTelno(), "010-1234-5678", "電話番号");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getPostalCd(), "１２３－４５６７", "郵便番号");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getAdr(), "通信先住所１通信先住所２通信先住所３", "住所");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getAdrkn(), "ｶﾅｶﾅｶﾅｶﾅ", "住所(ｶﾅ)");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHhknnm(), "被保険者名　様", "被保険者氏名");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHhknsei(), "男性", "被保険者性別");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHhknseiymd(), "昭和５５年　１月　１日", "被保険者生年月日");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHhknNen(), "３５歳", "被保険者年齢");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHhknKykjiNen(), "２５歳", "被保険者契約時年齢");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getSyouhnnm(), "笑顔の約束", "商品名");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getSyurui(), "終身保険", "種類");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getSyono(), "17806000161", "証券番号");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getCifCd(), "*****", "CIFｺｰﾄﾞ");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getKykymd(), "平成２５年　６月２１日", "契約日");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHrkhou(), "一時払", "払込方法");
        exBizCalcbleEquals(webKykNaiyouSyoukaiInfoBean.getSibous()
            , BizCurrency.valueOf(10000.00, BizCurrencyTypes.EURO) , "死亡保険金");
        Assert.assertEquals(webKykNaiyouSyoukaiInfoBean.getSibous().getType(), BizCurrencyTypes.EURO);
        exBizCalcbleEquals(webKykNaiyouSyoukaiInfoBean.getHrkp()
            , BizCurrency.valueOf(1001.00, BizCurrencyTypes.DOLLAR), "払込保険料");
        Assert.assertEquals(webKykNaiyouSyoukaiInfoBean.getHrkp().getType(), BizCurrencyTypes.DOLLAR);
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getNkShrStartYmd(), "", "年金支払開始日");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getNenkinHosyouYear(), "", "年金保証年");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getNenkinKbn(), "", "年金区分");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHaitouKbn(), "準有配当", "配当区分");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getSinsaKbn(), "", "診査区分");
        exNumericEquals(webKykNaiyouSyoukaiInfoBean.getTksuu(), 5, "特約数");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getLivingneedsTkhyj(), "", "リビングニーズ特約表示");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHokenMankiDay(), "終身", "保険満期日");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getSyunm(), "終身保険", "主契約名称");
        exBizCalcbleEquals(webKykNaiyouSyoukaiInfoBean.getSyus()
            , BizCurrency.valueOf(1002.00, BizCurrencyTypes.DOLLAR), "主契約保険金額");
        Assert.assertEquals(webKykNaiyouSyoukaiInfoBean.getSyus().getType(), BizCurrencyTypes.DOLLAR);
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getSyuhknkkn(), "終身", "主契約保険期間");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getSyuhrkkkn(), "", "主契約払込期間");
        exNumericEquals(webKykNaiyouSyoukaiInfoBean.getTkNaiyouGyousuu(), 5, "特約内容行数");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTknm1(), "保険料円貨払込特約", "特約名称１");
        exBizCalcbleEquals(webKykNaiyouSyoukaiInfoBean.getTks1(), BizCurrency.optional(), "特約保険金額１");
        Assert.assertEquals(webKykNaiyouSyoukaiInfoBean.getTks1().getType()
            , BizNumberConfig.instance.getDefaultCurrencyType());
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTokuyakuhokenkikan1(), "", "特約保険期間１");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTokuyakuharaikomikikan1(), "", "特約払込期間１");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTknm2(), "目標到達時円建年金保険変更特約　１％", "特約名称２");
        exBizCalcbleEquals(webKykNaiyouSyoukaiInfoBean.getTks2(), BizCurrency.optional(), "特約保険金額２");
        Assert.assertEquals(webKykNaiyouSyoukaiInfoBean.getTks2().getType()
            , BizNumberConfig.instance.getDefaultCurrencyType());
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTokuyakuhokenkikan2(), "", "特約保険期間２");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTokuyakuharaikomikikan2(), "", "特約払込期間２");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTknm3(), "保険契約者代理特約", "特約名称３");
        exBizCalcbleEquals(webKykNaiyouSyoukaiInfoBean.getTks3(), BizCurrency.optional(), "特約保険金額３");
        Assert.assertEquals(webKykNaiyouSyoukaiInfoBean.getTks3().getType()
            , BizNumberConfig.instance.getDefaultCurrencyType());
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTokuyakuhokenkikan3(), "", "特約保険期間３");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTokuyakuharaikomikikan3(), "", "特約払込期間３");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTknm4(), "指定代理請求特約", "特約名称４");
        exBizCalcbleEquals(webKykNaiyouSyoukaiInfoBean.getTks4(), BizCurrency.optional(), "特約保険金額４");
        Assert.assertEquals(webKykNaiyouSyoukaiInfoBean.getTks4().getType()
            , BizNumberConfig.instance.getDefaultCurrencyType());
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTokuyakuhokenkikan4(), "", "特約保険期間４");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTokuyakuharaikomikikan4(), "", "特約払込期間４");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTknm5(), "個人年金保険料税制適格特約（’９０）", "特約名称５");
        exBizCalcbleEquals(webKykNaiyouSyoukaiInfoBean.getTks5(), BizCurrency.optional(), "特約保険金額５");
        Assert.assertEquals(webKykNaiyouSyoukaiInfoBean.getTks5().getType()
            , BizNumberConfig.instance.getDefaultCurrencyType());
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTokuyakuhokenkikan5(), "", "特約保険期間５");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTokuyakuharaikomikikan5(), "", "特約払込期間５");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTknm6(), "", "特約名称６");
        exBizCalcbleEquals(webKykNaiyouSyoukaiInfoBean.getTks6(), BizCurrency.optional(), "特約保険金額６");
        Assert.assertEquals(webKykNaiyouSyoukaiInfoBean.getTks6().getType()
            , BizNumberConfig.instance.getDefaultCurrencyType());
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTokuyakuhokenkikan6(), "", "特約保険期間６");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTokuyakuharaikomikikan6(), "", "特約払込期間６");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTknm7(), "", "特約名称７");
        exBizCalcbleEquals(webKykNaiyouSyoukaiInfoBean.getTks7(), BizCurrency.optional(), "特約保険金額７");
        Assert.assertEquals(webKykNaiyouSyoukaiInfoBean.getTks7().getType()
            , BizNumberConfig.instance.getDefaultCurrencyType());
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTokuyakuhokenkikan7(), "", "特約保険期間７");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTokuyakuharaikomikikan7(), "", "特約払込期間７");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTknm8(), "", "特約名称８");
        exBizCalcbleEquals(webKykNaiyouSyoukaiInfoBean.getTks8(), BizCurrency.optional(), "特約保険金額８");
        Assert.assertEquals(webKykNaiyouSyoukaiInfoBean.getTks8().getType()
            , BizNumberConfig.instance.getDefaultCurrencyType());
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTokuyakuhokenkikan8(), "", "特約保険期間８");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTokuyakuharaikomikikan8(), "", "特約払込期間８");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTknm9(), "", "特約名称９");
        exBizCalcbleEquals(webKykNaiyouSyoukaiInfoBean.getTks9(), BizCurrency.optional(), "特約保険金額９");
        Assert.assertEquals(webKykNaiyouSyoukaiInfoBean.getTks9().getType()
            , BizNumberConfig.instance.getDefaultCurrencyType());
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTokuyakuhokenkikan9(), "", "特約保険期間９");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTokuyakuharaikomikikan9(), "", "特約払込期間９");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTknm10(), "", "特約名称１０");
        exBizCalcbleEquals(webKykNaiyouSyoukaiInfoBean.getTks10(), BizCurrency.optional(), "特約保険金額１０");
        Assert.assertEquals(webKykNaiyouSyoukaiInfoBean.getTks10().getType()
            , BizNumberConfig.instance.getDefaultCurrencyType());
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTokuyakuhokenkikan10(), "", "特約保険期間１０");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTokuyakuharaikomikikan10(), "", "特約払込期間１０");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTknm11(), "", "特約名称１１");
        exBizCalcbleEquals(webKykNaiyouSyoukaiInfoBean.getTks11(), BizCurrency.optional(), "特約保険金額１１");
        Assert.assertEquals(webKykNaiyouSyoukaiInfoBean.getTks11().getType()
            , BizNumberConfig.instance.getDefaultCurrencyType());
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTokuyakuhokenkikan11(), "", "特約保険期間１１");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTokuyakuharaikomikikan11(), "", "特約払込期間１１");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTknm12(), "", "特約名称１２");
        exBizCalcbleEquals(webKykNaiyouSyoukaiInfoBean.getTks12(), BizCurrency.optional(), "特約保険金額１２");
        Assert.assertEquals(webKykNaiyouSyoukaiInfoBean.getTks12().getType()
            , BizNumberConfig.instance.getDefaultCurrencyType());
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTokuyakuhokenkikan12(), "", "特約保険期間１２");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTokuyakuharaikomikikan12(), "", "特約払込期間１２");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTknm13(), "", "特約名称１３");
        exBizCalcbleEquals(webKykNaiyouSyoukaiInfoBean.getTks13(), BizCurrency.optional(), "特約保険金額１３");
        Assert.assertEquals(webKykNaiyouSyoukaiInfoBean.getTks13().getType()
            , BizNumberConfig.instance.getDefaultCurrencyType());
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTokuyakuhokenkikan13(), "", "特約保険期間１３");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTokuyakuharaikomikikan13(), "", "特約払込期間１３");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTknm14(), "", "特約名称１４");
        exBizCalcbleEquals(webKykNaiyouSyoukaiInfoBean.getTks14(), BizCurrency.optional(), "特約保険金額１４");
        Assert.assertEquals(webKykNaiyouSyoukaiInfoBean.getTks14().getType()
            , BizNumberConfig.instance.getDefaultCurrencyType());
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTokuyakuhokenkikan14(), "", "特約保険期間１４");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTokuyakuharaikomikikan14(), "", "特約払込期間１４");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTknm15(), "", "特約名称１５");
        exBizCalcbleEquals(webKykNaiyouSyoukaiInfoBean.getTks15(), BizCurrency.optional(), "特約保険金額１５");
        Assert.assertEquals(webKykNaiyouSyoukaiInfoBean.getTks15().getType()
            , BizNumberConfig.instance.getDefaultCurrencyType());
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTokuyakuhokenkikan15(), "", "特約保険期間１５");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTokuyakuharaikomikikan15(), "", "特約払込期間１５");
        exNumericEquals(webKykNaiyouSyoukaiInfoBean.getSyouhnNaiyouGyousuu(), 1, "商品内容行数");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getSyouhnNaiyou1(), "現在の保障内容は下記のとおりです。", "商品内容１");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getSyouhnNaiyou2(), "", "商品内容２");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getSyouhnNaiyou3(), "", "商品内容３");
        exNumericEquals(webKykNaiyouSyoukaiInfoBean.getHosyouNaiyouGyousuu(), 20, "保障内容行数");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHosyouNaiyou1(), "死亡時支払金受取人　被保険者　様", "保障内容１");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHosyouNaiyou2(), "契約者代理人　　　　家族名２　１－４３　様　　　　　　　　　　　生年月日　平成１３年　１月　１日", "保障内容２");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHosyouNaiyou3(), "指定代理請求人　　　家族名２　１－４３　様　　　　　　　　　　　生年月日　平成１３年　１月　１日", "保障内容３");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHosyouNaiyou4(), "登録家族（１人目）　登録されておりません", "保障内容４");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHosyouNaiyou5(), "登録家族（２人目）　家族名２　１－４３　様　　　　　　　　　　　生年月日　平成１３年　１月　１日", "保障内容５");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHosyouNaiyou6(), "積立利率　契約時点　３．７２％　　契約時から１０年経過後　３．９８％", "保障内容６");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHosyouNaiyou7(), "死亡時", "保障内容７");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHosyouNaiyou8(), "　第２保険期間（照会日時点）※　　　　　　　　　　１０，０００．００米ドル", "保障内容８");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHosyouNaiyou9(), "　　　　　　　　　　　　　　　　　　　　　　　　　（１００円）", "保障内容９");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHosyouNaiyou10(), "　※第２保険期間中は、基本保険金額と解約返戻金額のうちいずれか大きい金額でお支払いします。", "保障内容１０");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHosyouNaiyou11(), "解約返戻金額（照会日時点）　１，０００．００米ドル　　（１００円）", "保障内容１１");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHosyouNaiyou12(), "積立金額（照会日時点）　１，０００．００米ドル　　（１００円）", "保障内容１２");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHosyouNaiyou13(), "上記（）内の金額は、照会時点の為替レートで円換算した参考値であり変動します。", "保障内容１３");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHosyouNaiyou14(), "保険法対応契約", "保障内容１４");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHosyouNaiyou15(), "保険料円貨払込特約あり　　　　　加入時保険料入金額　　　１，２３０．００円", "保障内容１５");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHosyouNaiyou16(), "　保険料領収日時点の払込特約レート　１米ドル＝１円（平成２９年　７月　１日）", "保障内容１６");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHosyouNaiyou17(), "個人年金保険料税制適格特約（’９０）あり", "保障内容１７");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHosyouNaiyou18(), "保険契約者代理特約あり", "保障内容１８");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHosyouNaiyou19(), "指定代理請求特約あり", "保障内容１９");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHosyouNaiyou20(), "目標到達時円建年金保険変更特約あり　　　　　（目標額割合　１％）", "保障内容２０");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHosyouNaiyou21(), "", "保障内容２１");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHosyouNaiyou22(), "", "保障内容２２");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHosyouNaiyou23(), "", "保障内容２３");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHosyouNaiyou24(), "", "保障内容２４");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHosyouNaiyou25(), "", "保障内容２５");
        exNumericEquals(webKykNaiyouSyoukaiInfoBean.getHenkouKeiiGyousuu(), 1, "変更経緯行数");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHenkouKeii1(), "平成２７年１２月　１日　契約内容変更", "変更経緯１");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHenkouKeii2(), "", "変更経緯２");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHenkouKeii3(), "", "変更経緯３");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHenkouKeii4(), "", "変更経緯４");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHenkouKeii5(), "", "変更経緯５");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHenkouKeii6(), "", "変更経緯６");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHenkouKeii7(), "", "変更経緯７");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHenkouKeii8(), "", "変更経緯８");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHenkouKeii9(), "", "変更経緯９");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHenkouKeii10(), "", "変更経緯１０");
        exNumericEquals(webKykNaiyouSyoukaiInfoBean.getBosyuDrtenGyousuu(), 2, "募集代理店行数");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getBosyuDrtenNm1(), "取扱代理店名３", "募集代理店名１");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getDrtenBnwari1(), "", "代理店分割割合１");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getBosyuDrtenNm2(), "取扱代理店名３", "募集代理店名２");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getDrtenBnwari2(), "", "代理店分割割合２");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getMsgOutKbn(), "2", "MSG出力区分");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHosyouIkkatuMinaokeiyakuHyouji(), "0", "保障一括見直契約表示");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHhknnmkn(), "ﾋﾎｹﾝｼﾔｶﾅ", "被保険者氏名(ｶﾅ)");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHokenryouSyuunouJyoukyou(), "－", "保険料収納状況");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getJikaiHokenryouJyuutouYm(), "－", "次回保険料充当年月");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getMdhansybetuKbn(), "01", "窓販種別区分");
    }


    @Test
    @TestOrder(620)
    public void testExec_A62() {

        MockObjectManager.initialize();
        BzGetProcessSummaryMockForHozen.SYORIPTN = BzGetProcessSummaryMockForHozen.TESTPATTERN2;
        BzGetAdrDataMockForHozen.SYORIPTN = BzGetAdrDataMockForHozen.TESTPATTERN1;
        CalcHkShrKngkMockForHozen.SYORIPTN = CalcHkShrKngkMockForHozen.TESTPATTERN4;
        KeisanWExtMockForHozen.SYORIPTN = KeisanWExtMockForHozen.TESTPATTERN2;
        KeisanWMockForHozen.SYORIPTN = KeisanWMockForHozen.TESTPATTERN1;
        KeisanKijyungkMockForHozen.SYORIPTN = KeisanKijyungkMockForHozen.TESTPATTERN2;
        KeisanGaikakanzanMockForHozen.SYORIPTN = KeisanGaikakanzanMockForHozen.TESTPATTERN1;
        SetNenreiMockForHozen.SYORIPTN = SetNenreiMockForHozen.TESTPATTERN1;

        WebKykNaiyouSyoukaiInfoBean webKykNaiyouSyoukaiInfoBean =
            hbKeiyakuSyoukai.exec("99806011138", BizDate.valueOf("20200401"), C_TanmatuSiyouKbn.SOUGOU_IPPAN,"A10010");

        exStringEquals(webKykNaiyouSyoukaiInfoBean.getErrorKbn(), "", "エラー区分");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getErrorMsg(), "", "エラーメッセージ");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getKyknmkn(), "ｶﾅ", "契約者名（カナ）");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getKyknmkj(), "契約者名漢字１－４４　様", "契約者名（漢字）");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getKykseiymd(), "", "契約者生年月日");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getKojinhjnKbn(), "個人", "個人法人区分");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTelno(), "010-1234-5678", "電話番号");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getPostalCd(), "１２３－４５６７", "郵便番号");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getAdr(), "通信先住所１通信先住所２通信先住所３", "住所");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getAdrkn(), "ｶﾅｶﾅｶﾅｶﾅ", "住所(ｶﾅ)");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHhknnm(), "被保険者名　様", "被保険者氏名");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHhknsei(), "男性", "被保険者性別");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHhknseiymd(), "昭和５５年　１月　１日", "被保険者生年月日");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHhknNen(), "３５歳", "被保険者年齢");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHhknKykjiNen(), "２５歳", "被保険者契約時年齢");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getSyouhnnm(), "５年ごと利差配当付指定通貨建終身保険（一時払い）　ふるはーとＪロードグローバル", "商品名");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getSyurui(), "終身保険", "種類");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getSyono(), "99806011138", "証券番号");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getCifCd(), "*****", "CIFｺｰﾄﾞ");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getKykymd(), "平成２８年　６月２０日", "契約日");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHrkhou(), "", "払込方法");
        exBizCalcbleEquals(webKykNaiyouSyoukaiInfoBean.getSibous()
            , BizCurrency.valueOf(10000.00, BizCurrencyTypes.AU_DOLLAR) , "死亡保険金");
        Assert.assertEquals(webKykNaiyouSyoukaiInfoBean.getSibous().getType(), BizCurrencyTypes.AU_DOLLAR);
        exBizCalcbleEquals(webKykNaiyouSyoukaiInfoBean.getHrkp()
            , BizCurrency.valueOf(1001.00, BizCurrencyTypes.DOLLAR), "払込保険料");
        Assert.assertEquals(webKykNaiyouSyoukaiInfoBean.getHrkp().getType(), BizCurrencyTypes.DOLLAR);
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getNkShrStartYmd(), "", "年金支払開始日");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getNenkinHosyouYear(), "", "年金保証年");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getNenkinKbn(), "", "年金区分");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHaitouKbn(), "準有配当", "配当区分");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getSinsaKbn(), "", "診査区分");
        exNumericEquals(webKykNaiyouSyoukaiInfoBean.getTksuu(), 0, "特約数");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getLivingneedsTkhyj(), "", "リビングニーズ特約表示");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHokenMankiDay(), "終身", "保険満期日");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getSyunm(), "終身保険", "主契約名称");
        exBizCalcbleEquals(webKykNaiyouSyoukaiInfoBean.getSyus()
            ,BizCurrency.valueOf(1002, BizCurrencyTypes.YEN), "主契約保険金額");
        Assert.assertEquals(webKykNaiyouSyoukaiInfoBean.getSyus().getType(), BizNumberConfig.instance.getDefaultCurrencyType());
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getSyuhknkkn(), "終身", "主契約保険期間");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getSyuhrkkkn(), "", "主契約払込期間");
        exNumericEquals(webKykNaiyouSyoukaiInfoBean.getTkNaiyouGyousuu(), 0, "特約内容行数");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTknm1(), "", "特約名称１");
        exBizCalcbleEquals(webKykNaiyouSyoukaiInfoBean.getTks1(), BizCurrency.optional(), "特約保険金額１");
        Assert.assertEquals(webKykNaiyouSyoukaiInfoBean.getTks1().getType()
            , BizNumberConfig.instance.getDefaultCurrencyType());
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTokuyakuhokenkikan1(), "", "特約保険期間１");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTokuyakuharaikomikikan1(), "", "特約払込期間１");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTknm2(), "", "特約名称２");
        exBizCalcbleEquals(webKykNaiyouSyoukaiInfoBean.getTks2(), BizCurrency.optional(), "特約保険金額２");
        Assert.assertEquals(webKykNaiyouSyoukaiInfoBean.getTks2().getType()
            , BizNumberConfig.instance.getDefaultCurrencyType());
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTokuyakuhokenkikan2(), "", "特約保険期間２");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTokuyakuharaikomikikan2(), "", "特約払込期間２");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTknm3(), "", "特約名称３");
        exBizCalcbleEquals(webKykNaiyouSyoukaiInfoBean.getTks3(), BizCurrency.optional(), "特約保険金額３");
        Assert.assertEquals(webKykNaiyouSyoukaiInfoBean.getTks3().getType()
            , BizNumberConfig.instance.getDefaultCurrencyType());
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTokuyakuhokenkikan3(), "", "特約保険期間３");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTokuyakuharaikomikikan3(), "", "特約払込期間３");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTknm4(), "", "特約名称４");
        exBizCalcbleEquals(webKykNaiyouSyoukaiInfoBean.getTks4(), BizCurrency.optional(), "特約保険金額４");
        Assert.assertEquals(webKykNaiyouSyoukaiInfoBean.getTks4().getType()
            , BizNumberConfig.instance.getDefaultCurrencyType());
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTokuyakuhokenkikan4(), "", "特約保険期間４");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTokuyakuharaikomikikan4(), "", "特約払込期間４");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTknm5(), "", "特約名称５");
        exBizCalcbleEquals(webKykNaiyouSyoukaiInfoBean.getTks5(), BizCurrency.optional(), "特約保険金額５");
        Assert.assertEquals(webKykNaiyouSyoukaiInfoBean.getTks5().getType()
            , BizNumberConfig.instance.getDefaultCurrencyType());
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTokuyakuhokenkikan5(), "", "特約保険期間５");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTokuyakuharaikomikikan5(), "", "特約払込期間５");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTknm6(), "", "特約名称６");
        exBizCalcbleEquals(webKykNaiyouSyoukaiInfoBean.getTks6(), BizCurrency.optional(), "特約保険金額６");
        Assert.assertEquals(webKykNaiyouSyoukaiInfoBean.getTks6().getType()
            , BizNumberConfig.instance.getDefaultCurrencyType());
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTokuyakuhokenkikan6(), "", "特約保険期間６");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTokuyakuharaikomikikan6(), "", "特約払込期間６");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTknm7(), "", "特約名称７");
        exBizCalcbleEquals(webKykNaiyouSyoukaiInfoBean.getTks7(), BizCurrency.optional(), "特約保険金額７");
        Assert.assertEquals(webKykNaiyouSyoukaiInfoBean.getTks7().getType()
            , BizNumberConfig.instance.getDefaultCurrencyType());
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTokuyakuhokenkikan7(), "", "特約保険期間７");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTokuyakuharaikomikikan7(), "", "特約払込期間７");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTknm8(), "", "特約名称８");
        exBizCalcbleEquals(webKykNaiyouSyoukaiInfoBean.getTks8(), BizCurrency.optional(), "特約保険金額８");
        Assert.assertEquals(webKykNaiyouSyoukaiInfoBean.getTks8().getType()
            , BizNumberConfig.instance.getDefaultCurrencyType());
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTokuyakuhokenkikan8(), "", "特約保険期間８");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTokuyakuharaikomikikan8(), "", "特約払込期間８");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTknm9(), "", "特約名称９");
        exBizCalcbleEquals(webKykNaiyouSyoukaiInfoBean.getTks9(), BizCurrency.optional(), "特約保険金額９");
        Assert.assertEquals(webKykNaiyouSyoukaiInfoBean.getTks9().getType()
            , BizNumberConfig.instance.getDefaultCurrencyType());
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTokuyakuhokenkikan9(), "", "特約保険期間９");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTokuyakuharaikomikikan9(), "", "特約払込期間９");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTknm10(), "", "特約名称１０");
        exBizCalcbleEquals(webKykNaiyouSyoukaiInfoBean.getTks10(), BizCurrency.optional(), "特約保険金額１０");
        Assert.assertEquals(webKykNaiyouSyoukaiInfoBean.getTks10().getType()
            , BizNumberConfig.instance.getDefaultCurrencyType());
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTokuyakuhokenkikan10(), "", "特約保険期間１０");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTokuyakuharaikomikikan10(), "", "特約払込期間１０");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTknm11(), "", "特約名称１１");
        exBizCalcbleEquals(webKykNaiyouSyoukaiInfoBean.getTks11(), BizCurrency.optional(), "特約保険金額１１");
        Assert.assertEquals(webKykNaiyouSyoukaiInfoBean.getTks11().getType()
            , BizNumberConfig.instance.getDefaultCurrencyType());
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTokuyakuhokenkikan11(), "", "特約保険期間１１");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTokuyakuharaikomikikan11(), "", "特約払込期間１１");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTknm12(), "", "特約名称１２");
        exBizCalcbleEquals(webKykNaiyouSyoukaiInfoBean.getTks12(), BizCurrency.optional(), "特約保険金額１２");
        Assert.assertEquals(webKykNaiyouSyoukaiInfoBean.getTks12().getType()
            , BizNumberConfig.instance.getDefaultCurrencyType());
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTokuyakuhokenkikan12(), "", "特約保険期間１２");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTokuyakuharaikomikikan12(), "", "特約払込期間１２");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTknm13(), "", "特約名称１３");
        exBizCalcbleEquals(webKykNaiyouSyoukaiInfoBean.getTks13(), BizCurrency.optional(), "特約保険金額１３");
        Assert.assertEquals(webKykNaiyouSyoukaiInfoBean.getTks13().getType()
            , BizNumberConfig.instance.getDefaultCurrencyType());
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTokuyakuhokenkikan13(), "", "特約保険期間１３");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTokuyakuharaikomikikan13(), "", "特約払込期間１３");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTknm14(), "", "特約名称１４");
        exBizCalcbleEquals(webKykNaiyouSyoukaiInfoBean.getTks14(), BizCurrency.optional(), "特約保険金額１４");
        Assert.assertEquals(webKykNaiyouSyoukaiInfoBean.getTks14().getType()
            , BizNumberConfig.instance.getDefaultCurrencyType());
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTokuyakuhokenkikan14(), "", "特約保険期間１４");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTokuyakuharaikomikikan14(), "", "特約払込期間１４");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTknm15(), "", "特約名称１５");
        exBizCalcbleEquals(webKykNaiyouSyoukaiInfoBean.getTks15(), BizCurrency.optional(), "特約保険金額１５");
        Assert.assertEquals(webKykNaiyouSyoukaiInfoBean.getTks15().getType()
            , BizNumberConfig.instance.getDefaultCurrencyType());
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTokuyakuhokenkikan15(), "", "特約保険期間１５");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTokuyakuharaikomikikan15(), "", "特約払込期間１５");
        exNumericEquals(webKykNaiyouSyoukaiInfoBean.getSyouhnNaiyouGyousuu(), 1, "商品内容行数");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getSyouhnNaiyou1(), "現在の保障内容は下記のとおりです。", "商品内容１");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getSyouhnNaiyou2(), "", "商品内容２");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getSyouhnNaiyou3(), "", "商品内容３");
        exNumericEquals(webKykNaiyouSyoukaiInfoBean.getHosyouNaiyouGyousuu(), 9, "保障内容行数");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHosyouNaiyou1(), "平成３０年　３月１６日　目標到達（目標値：１％）により円建終身保険に変更済", "保障内容１");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHosyouNaiyou2(), "　　　　　　　　　　　　到達金額　　　　　５０，０００円", "保障内容２");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHosyouNaiyou3(), "　　　　　　　　　　　　円建変更時返戻金　５，０００円　（未請求）", "保障内容３");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHosyouNaiyou4(), "死亡時支払金受取人　契約者　様", "保障内容４");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHosyouNaiyou5(), "契約加入時しおり約款検索コード　０１－１９１２－２７６１", "保障内容５");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHosyouNaiyou6(), "約款受領方法　冊子での受取り", "保障内容６");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHosyouNaiyou7(), "解約返戻金額（照会日時点）　１，０００円", "保障内容７");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHosyouNaiyou8(), "積立金額（照会日時点）　１，０００円", "保障内容８");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHosyouNaiyou9(), "保険法対応契約", "保障内容９");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHosyouNaiyou10(), "", "保障内容１０");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHosyouNaiyou11(), "", "保障内容１１");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHosyouNaiyou12(), "", "保障内容１２");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHosyouNaiyou13(), "", "保障内容１３");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHosyouNaiyou14(), "", "保障内容１４");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHosyouNaiyou15(), "", "保障内容１５");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHosyouNaiyou16(), "", "保障内容１６");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHosyouNaiyou17(), "", "保障内容１７");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHosyouNaiyou18(), "", "保障内容１８");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHosyouNaiyou19(), "", "保障内容１９");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHosyouNaiyou20(), "", "保障内容２０");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHosyouNaiyou21(), "", "保障内容２１");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHosyouNaiyou22(), "", "保障内容２２");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHosyouNaiyou23(), "", "保障内容２３");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHosyouNaiyou24(), "", "保障内容２４");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHosyouNaiyou25(), "", "保障内容２５");
        exNumericEquals(webKykNaiyouSyoukaiInfoBean.getHenkouKeiiGyousuu(), 1, "変更経緯行数");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHenkouKeii1(), "平成２７年１２月　１日　契約内容変更", "変更経緯１");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHenkouKeii2(), "", "変更経緯２");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHenkouKeii3(), "", "変更経緯３");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHenkouKeii4(), "", "変更経緯４");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHenkouKeii5(), "", "変更経緯５");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHenkouKeii6(), "", "変更経緯６");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHenkouKeii7(), "", "変更経緯７");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHenkouKeii8(), "", "変更経緯８");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHenkouKeii9(), "", "変更経緯９");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHenkouKeii10(), "", "変更経緯１０");
        exNumericEquals(webKykNaiyouSyoukaiInfoBean.getBosyuDrtenGyousuu(), 1, "募集代理店行数");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getBosyuDrtenNm1(), "取扱代理店名３", "募集代理店名１");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getDrtenBnwari1(), "", "代理店分割割合１");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getBosyuDrtenNm2(), "", "募集代理店名２");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getDrtenBnwari2(), "", "代理店分割割合２");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getMsgOutKbn(), "2", "MSG出力区分");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHosyouIkkatuMinaokeiyakuHyouji(), "0", "保障一括見直契約表示");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHhknnmkn(), "ﾋﾎｹﾝｼｶﾅ", "被保険者氏名(ｶﾅ)");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHokenryouSyuunouJyoukyou(), "正常収納中", "保険料収納状況");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getJikaiHokenryouJyuutouYm(), "平成２８年　６月", "次回保険料充当年月");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getMdhansybetuKbn(), "01", "窓販種別区分");
    }

    @Test
    @TestOrder(630)
    public void testExec_A63() {


        MockObjectManager.initialize();
        BzGetProcessSummaryMockForHozen.SYORIPTN = BzGetProcessSummaryMockForHozen.TESTPATTERN2;
        BzGetAdrDataMockForHozen.SYORIPTN = BzGetAdrDataMockForHozen.TESTPATTERN1;
        CalcHkShrKngkMockForHozen.SYORIPTN = CalcHkShrKngkMockForHozen.TESTPATTERN4;
        KeisanWExtMockForHozen.SYORIPTN = KeisanWExtMockForHozen.TESTPATTERN2;
        KeisanWMockForHozen.SYORIPTN = KeisanWMockForHozen.TESTPATTERN1;
        KeisanKijyungkMockForHozen.SYORIPTN = KeisanKijyungkMockForHozen.TESTPATTERN2;
        KeisanGaikakanzanMockForHozen.SYORIPTN = KeisanGaikakanzanMockForHozen.TESTPATTERN1;
        SetNenreiMockForHozen.SYORIPTN = SetNenreiMockForHozen.TESTPATTERN1;
        WebKykNaiyouSyoukaiInfoBean webKykNaiyouSyoukaiInfoBean =
            hbKeiyakuSyoukai.exec("99806011116", BizDate.valueOf("20200401"), C_TanmatuSiyouKbn.SOUGOU_IPPAN,"A10010");

        exStringEquals(webKykNaiyouSyoukaiInfoBean.getErrorKbn(), "", "エラー区分");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getErrorMsg(), "", "エラーメッセージ");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getKyknmkn(), "ｶﾅ", "契約者名（カナ）");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getKyknmkj(), "契約者名漢字１－４５　様", "契約者名（漢字）");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getKykseiymd(), "", "契約者生年月日");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getKojinhjnKbn(), "個人", "個人法人区分");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTelno(), "010-1234-5678", "電話番号");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getPostalCd(), "１２３－４５６７", "郵便番号");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getAdr(), "通信先住所１通信先住所２通信先住所３", "住所");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getAdrkn(), "ｶﾅｶﾅｶﾅｶﾅ", "住所(ｶﾅ)");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHhknnm(), "被保険者名　様", "被保険者氏名");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHhknsei(), "男性", "被保険者性別");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHhknseiymd(), "昭和５５年　１月　１日", "被保険者生年月日");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHhknNen(), "３５歳", "被保険者年齢");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHhknKykjiNen(), "２５歳", "被保険者契約時年齢");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getSyouhnnm(), "５年ごと利差配当付指定通貨建終身保険（一時払い）　ふるはーとＪロードグローバル", "商品名");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getSyurui(), "終身保険", "種類");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getSyono(), "99806011116", "証券番号");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getCifCd(), "*****", "CIFｺｰﾄﾞ");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getKykymd(), "平成２８年　６月２０日", "契約日");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHrkhou(), "", "払込方法");
        exBizCalcbleEquals(webKykNaiyouSyoukaiInfoBean.getSibous()
            , BizCurrency.valueOf(10000.00, BizCurrencyTypes.AU_DOLLAR) , "死亡保険金");
        Assert.assertEquals(webKykNaiyouSyoukaiInfoBean.getSibous().getType(), BizCurrencyTypes.AU_DOLLAR);
        exBizCalcbleEquals(webKykNaiyouSyoukaiInfoBean.getHrkp()
            , BizCurrency.valueOf(1001.00, BizCurrencyTypes.DOLLAR), "払込保険料");
        Assert.assertEquals(webKykNaiyouSyoukaiInfoBean.getHrkp().getType(), BizCurrencyTypes.DOLLAR);
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getNkShrStartYmd(), "", "年金支払開始日");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getNenkinHosyouYear(), "", "年金保証年");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getNenkinKbn(), "", "年金区分");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHaitouKbn(), "準有配当", "配当区分");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getSinsaKbn(), "", "診査区分");
        exNumericEquals(webKykNaiyouSyoukaiInfoBean.getTksuu(), 0, "特約数");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getLivingneedsTkhyj(), "", "リビングニーズ特約表示");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHokenMankiDay(), "終身", "保険満期日");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getSyunm(), "終身保険", "主契約名称");
        exBizCalcbleEquals(webKykNaiyouSyoukaiInfoBean.getSyus()
            ,BizCurrency.valueOf(1002, BizCurrencyTypes.YEN), "主契約保険金額");
        Assert.assertEquals(webKykNaiyouSyoukaiInfoBean.getSyus().getType(), BizNumberConfig.instance.getDefaultCurrencyType());
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getSyuhknkkn(), "終身", "主契約保険期間");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getSyuhrkkkn(), "", "主契約払込期間");
        exNumericEquals(webKykNaiyouSyoukaiInfoBean.getTkNaiyouGyousuu(), 0, "特約内容行数");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTknm1(), "", "特約名称１");
        exBizCalcbleEquals(webKykNaiyouSyoukaiInfoBean.getTks1(), BizCurrency.optional(), "特約保険金額１");
        Assert.assertEquals(webKykNaiyouSyoukaiInfoBean.getTks1().getType()
            , BizNumberConfig.instance.getDefaultCurrencyType());
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTokuyakuhokenkikan1(), "", "特約保険期間１");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTokuyakuharaikomikikan1(), "", "特約払込期間１");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTknm2(), "", "特約名称２");
        exBizCalcbleEquals(webKykNaiyouSyoukaiInfoBean.getTks2(), BizCurrency.optional(), "特約保険金額２");
        Assert.assertEquals(webKykNaiyouSyoukaiInfoBean.getTks2().getType()
            , BizNumberConfig.instance.getDefaultCurrencyType());
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTokuyakuhokenkikan2(), "", "特約保険期間２");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTokuyakuharaikomikikan2(), "", "特約払込期間２");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTknm3(), "", "特約名称３");
        exBizCalcbleEquals(webKykNaiyouSyoukaiInfoBean.getTks3(), BizCurrency.optional(), "特約保険金額３");
        Assert.assertEquals(webKykNaiyouSyoukaiInfoBean.getTks3().getType()
            , BizNumberConfig.instance.getDefaultCurrencyType());
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTokuyakuhokenkikan3(), "", "特約保険期間３");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTokuyakuharaikomikikan3(), "", "特約払込期間３");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTknm4(), "", "特約名称４");
        exBizCalcbleEquals(webKykNaiyouSyoukaiInfoBean.getTks4(), BizCurrency.optional(), "特約保険金額４");
        Assert.assertEquals(webKykNaiyouSyoukaiInfoBean.getTks4().getType()
            , BizNumberConfig.instance.getDefaultCurrencyType());
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTokuyakuhokenkikan4(), "", "特約保険期間４");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTokuyakuharaikomikikan4(), "", "特約払込期間４");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTknm5(), "", "特約名称５");
        exBizCalcbleEquals(webKykNaiyouSyoukaiInfoBean.getTks5(), BizCurrency.optional(), "特約保険金額５");
        Assert.assertEquals(webKykNaiyouSyoukaiInfoBean.getTks5().getType()
            , BizNumberConfig.instance.getDefaultCurrencyType());
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTokuyakuhokenkikan5(), "", "特約保険期間５");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTokuyakuharaikomikikan5(), "", "特約払込期間５");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTknm6(), "", "特約名称６");
        exBizCalcbleEquals(webKykNaiyouSyoukaiInfoBean.getTks6(), BizCurrency.optional(), "特約保険金額６");
        Assert.assertEquals(webKykNaiyouSyoukaiInfoBean.getTks6().getType()
            , BizNumberConfig.instance.getDefaultCurrencyType());
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTokuyakuhokenkikan6(), "", "特約保険期間６");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTokuyakuharaikomikikan6(), "", "特約払込期間６");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTknm7(), "", "特約名称７");
        exBizCalcbleEquals(webKykNaiyouSyoukaiInfoBean.getTks7(), BizCurrency.optional(), "特約保険金額７");
        Assert.assertEquals(webKykNaiyouSyoukaiInfoBean.getTks7().getType()
            , BizNumberConfig.instance.getDefaultCurrencyType());
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTokuyakuhokenkikan7(), "", "特約保険期間７");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTokuyakuharaikomikikan7(), "", "特約払込期間７");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTknm8(), "", "特約名称８");
        exBizCalcbleEquals(webKykNaiyouSyoukaiInfoBean.getTks8(), BizCurrency.optional(), "特約保険金額８");
        Assert.assertEquals(webKykNaiyouSyoukaiInfoBean.getTks8().getType()
            , BizNumberConfig.instance.getDefaultCurrencyType());
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTokuyakuhokenkikan8(), "", "特約保険期間８");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTokuyakuharaikomikikan8(), "", "特約払込期間８");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTknm9(), "", "特約名称９");
        exBizCalcbleEquals(webKykNaiyouSyoukaiInfoBean.getTks9(), BizCurrency.optional(), "特約保険金額９");
        Assert.assertEquals(webKykNaiyouSyoukaiInfoBean.getTks9().getType()
            , BizNumberConfig.instance.getDefaultCurrencyType());
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTokuyakuhokenkikan9(), "", "特約保険期間９");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTokuyakuharaikomikikan9(), "", "特約払込期間９");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTknm10(), "", "特約名称１０");
        exBizCalcbleEquals(webKykNaiyouSyoukaiInfoBean.getTks10(), BizCurrency.optional(), "特約保険金額１０");
        Assert.assertEquals(webKykNaiyouSyoukaiInfoBean.getTks10().getType()
            , BizNumberConfig.instance.getDefaultCurrencyType());
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTokuyakuhokenkikan10(), "", "特約保険期間１０");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTokuyakuharaikomikikan10(), "", "特約払込期間１０");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTknm11(), "", "特約名称１１");
        exBizCalcbleEquals(webKykNaiyouSyoukaiInfoBean.getTks11(), BizCurrency.optional(), "特約保険金額１１");
        Assert.assertEquals(webKykNaiyouSyoukaiInfoBean.getTks11().getType()
            , BizNumberConfig.instance.getDefaultCurrencyType());
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTokuyakuhokenkikan11(), "", "特約保険期間１１");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTokuyakuharaikomikikan11(), "", "特約払込期間１１");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTknm12(), "", "特約名称１２");
        exBizCalcbleEquals(webKykNaiyouSyoukaiInfoBean.getTks12(), BizCurrency.optional(), "特約保険金額１２");
        Assert.assertEquals(webKykNaiyouSyoukaiInfoBean.getTks12().getType()
            , BizNumberConfig.instance.getDefaultCurrencyType());
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTokuyakuhokenkikan12(), "", "特約保険期間１２");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTokuyakuharaikomikikan12(), "", "特約払込期間１２");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTknm13(), "", "特約名称１３");
        exBizCalcbleEquals(webKykNaiyouSyoukaiInfoBean.getTks13(), BizCurrency.optional(), "特約保険金額１３");
        Assert.assertEquals(webKykNaiyouSyoukaiInfoBean.getTks13().getType()
            , BizNumberConfig.instance.getDefaultCurrencyType());
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTokuyakuhokenkikan13(), "", "特約保険期間１３");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTokuyakuharaikomikikan13(), "", "特約払込期間１３");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTknm14(), "", "特約名称１４");
        exBizCalcbleEquals(webKykNaiyouSyoukaiInfoBean.getTks14(), BizCurrency.optional(), "特約保険金額１４");
        Assert.assertEquals(webKykNaiyouSyoukaiInfoBean.getTks14().getType()
            , BizNumberConfig.instance.getDefaultCurrencyType());
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTokuyakuhokenkikan14(), "", "特約保険期間１４");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTokuyakuharaikomikikan14(), "", "特約払込期間１４");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTknm15(), "", "特約名称１５");
        exBizCalcbleEquals(webKykNaiyouSyoukaiInfoBean.getTks15(), BizCurrency.optional(), "特約保険金額１５");
        Assert.assertEquals(webKykNaiyouSyoukaiInfoBean.getTks15().getType()
            , BizNumberConfig.instance.getDefaultCurrencyType());
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTokuyakuhokenkikan15(), "", "特約保険期間１５");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTokuyakuharaikomikikan15(), "", "特約払込期間１５");
        exNumericEquals(webKykNaiyouSyoukaiInfoBean.getSyouhnNaiyouGyousuu(), 1, "商品内容行数");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getSyouhnNaiyou1(), "現在の保障内容は下記のとおりです。", "商品内容１");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getSyouhnNaiyou2(), "", "商品内容２");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getSyouhnNaiyou3(), "", "商品内容３");
        exNumericEquals(webKykNaiyouSyoukaiInfoBean.getHosyouNaiyouGyousuu(), 8, "保障内容行数");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHosyouNaiyou1(), "平成３０年　３月１６日　目標到達（目標値：１％）により円建終身保険に変更済", "保障内容１");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHosyouNaiyou2(), "　　　　　　　　　　　　到達金額　　　　　５０，０００円", "保障内容２");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHosyouNaiyou3(), "死亡時支払金受取人　契約者　様", "保障内容３");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHosyouNaiyou4(), "契約加入時しおり約款検索コード　０１－１９１２－２７６１", "保障内容４");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHosyouNaiyou5(), "約款受領方法　Ｗｅｂでの受取り（冊子も送付）", "保障内容５");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHosyouNaiyou6(), "解約返戻金額（照会日時点）　１，０００円", "保障内容６");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHosyouNaiyou7(), "積立金額（照会日時点）　１，０００円", "保障内容７");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHosyouNaiyou8(), "保険法対応契約", "保障内容８");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHosyouNaiyou9(), "", "保障内容９");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHosyouNaiyou10(), "", "保障内容１０");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHosyouNaiyou11(), "", "保障内容１１");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHosyouNaiyou12(), "", "保障内容１２");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHosyouNaiyou13(), "", "保障内容１３");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHosyouNaiyou14(), "", "保障内容１４");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHosyouNaiyou15(), "", "保障内容１５");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHosyouNaiyou16(), "", "保障内容１６");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHosyouNaiyou17(), "", "保障内容１７");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHosyouNaiyou18(), "", "保障内容１８");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHosyouNaiyou19(), "", "保障内容１９");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHosyouNaiyou20(), "", "保障内容２０");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHosyouNaiyou21(), "", "保障内容２１");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHosyouNaiyou22(), "", "保障内容２２");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHosyouNaiyou23(), "", "保障内容２３");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHosyouNaiyou24(), "", "保障内容２４");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHosyouNaiyou25(), "", "保障内容２５");
        exNumericEquals(webKykNaiyouSyoukaiInfoBean.getHenkouKeiiGyousuu(), 1, "変更経緯行数");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHenkouKeii1(), "平成２７年１２月　１日　契約内容変更", "変更経緯１");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHenkouKeii2(), "", "変更経緯２");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHenkouKeii3(), "", "変更経緯３");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHenkouKeii4(), "", "変更経緯４");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHenkouKeii5(), "", "変更経緯５");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHenkouKeii6(), "", "変更経緯６");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHenkouKeii7(), "", "変更経緯７");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHenkouKeii8(), "", "変更経緯８");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHenkouKeii9(), "", "変更経緯９");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHenkouKeii10(), "", "変更経緯１０");
        exNumericEquals(webKykNaiyouSyoukaiInfoBean.getBosyuDrtenGyousuu(), 1, "募集代理店行数");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getBosyuDrtenNm1(), "取扱代理店名３", "募集代理店名１");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getDrtenBnwari1(), "", "代理店分割割合１");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getBosyuDrtenNm2(), "", "募集代理店名２");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getDrtenBnwari2(), "", "代理店分割割合２");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getMsgOutKbn(), "2", "MSG出力区分");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHosyouIkkatuMinaokeiyakuHyouji(), "0", "保障一括見直契約表示");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHhknnmkn(), "ﾋﾎｹﾝｼｶﾅ", "被保険者氏名(ｶﾅ)");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHokenryouSyuunouJyoukyou(), "正常収納中", "保険料収納状況");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getJikaiHokenryouJyuutouYm(), "平成２８年　６月", "次回保険料充当年月");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getMdhansybetuKbn(), "01", "窓販種別区分");
    }

    @Test
    @TestOrder(640)
    public void testExec_A64() {


        MockObjectManager.initialize();
        BzGetProcessSummaryMockForHozen.SYORIPTN = BzGetProcessSummaryMockForHozen.TESTPATTERN2;
        BzGetAdrDataMockForHozen.SYORIPTN = BzGetAdrDataMockForHozen.TESTPATTERN1;
        CalcHkShrKngkMockForHozen.SYORIPTN = CalcHkShrKngkMockForHozen.TESTPATTERN4;
        KeisanWExtMockForHozen.SYORIPTN = KeisanWExtMockForHozen.TESTPATTERN2;
        KeisanWMockForHozen.SYORIPTN = KeisanWMockForHozen.TESTPATTERN1;
        KeisanKijyungkMockForHozen.SYORIPTN = KeisanKijyungkMockForHozen.TESTPATTERN2;
        KeisanGaikakanzanMockForHozen.SYORIPTN = KeisanGaikakanzanMockForHozen.TESTPATTERN1;
        SetNenreiMockForHozen.SYORIPTN = SetNenreiMockForHozen.TESTPATTERN1;

        WebKykNaiyouSyoukaiInfoBean webKykNaiyouSyoukaiInfoBean =
            hbKeiyakuSyoukai.exec("99806011149", BizDate.valueOf("20200401"), C_TanmatuSiyouKbn.SOUGOU_IPPAN,"A10010");

        exStringEquals(webKykNaiyouSyoukaiInfoBean.getErrorKbn(), "", "エラー区分");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getErrorMsg(), "", "エラーメッセージ");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getKyknmkn(), "ｶﾅ", "契約者名（カナ）");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getKyknmkj(), "契約者名漢字１－４６　様", "契約者名（漢字）");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getKykseiymd(), "", "契約者生年月日");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getKojinhjnKbn(), "個人", "個人法人区分");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTelno(), "010-1234-5678", "電話番号");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getPostalCd(), "１２３－４５６７", "郵便番号");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getAdr(), "通信先住所１通信先住所２通信先住所３", "住所");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getAdrkn(), "ｶﾅｶﾅｶﾅｶﾅ", "住所(ｶﾅ)");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHhknnm(), "被保険者名　様", "被保険者氏名");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHhknsei(), "男性", "被保険者性別");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHhknseiymd(), "昭和５５年　１月　１日", "被保険者生年月日");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHhknNen(), "３５歳", "被保険者年齢");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHhknKykjiNen(), "２５歳", "被保険者契約時年齢");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getSyouhnnm(), "５年ごと利差配当付指定通貨建終身保険（一時払い）　ふるはーとＪロードグローバル", "商品名");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getSyurui(), "終身保険", "種類");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getSyono(), "99806011149", "証券番号");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getCifCd(), "*****", "CIFｺｰﾄﾞ");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getKykymd(), "平成２８年　６月２０日", "契約日");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHrkhou(), "", "払込方法");
        exBizCalcbleEquals(webKykNaiyouSyoukaiInfoBean.getSibous()
            , BizCurrency.valueOf(10000.00, BizCurrencyTypes.AU_DOLLAR) , "死亡保険金");
        Assert.assertEquals(webKykNaiyouSyoukaiInfoBean.getSibous().getType(), BizCurrencyTypes.AU_DOLLAR);
        exBizCalcbleEquals(webKykNaiyouSyoukaiInfoBean.getHrkp()
            , BizCurrency.valueOf(1001.00, BizCurrencyTypes.DOLLAR), "払込保険料");
        Assert.assertEquals(webKykNaiyouSyoukaiInfoBean.getHrkp().getType(), BizCurrencyTypes.DOLLAR);
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getNkShrStartYmd(), "", "年金支払開始日");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getNenkinHosyouYear(), "", "年金保証年");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getNenkinKbn(), "", "年金区分");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHaitouKbn(), "準有配当", "配当区分");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getSinsaKbn(), "", "診査区分");
        exNumericEquals(webKykNaiyouSyoukaiInfoBean.getTksuu(), 0, "特約数");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getLivingneedsTkhyj(), "", "リビングニーズ特約表示");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHokenMankiDay(), "終身", "保険満期日");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getSyunm(), "終身保険", "主契約名称");
        exBizCalcbleEquals(webKykNaiyouSyoukaiInfoBean.getSyus()
            ,BizCurrency.valueOf(1002, BizCurrencyTypes.YEN), "主契約保険金額");
        Assert.assertEquals(webKykNaiyouSyoukaiInfoBean.getSyus().getType(), BizNumberConfig.instance.getDefaultCurrencyType());
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getSyuhknkkn(), "終身", "主契約保険期間");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getSyuhrkkkn(), "", "主契約払込期間");
        exNumericEquals(webKykNaiyouSyoukaiInfoBean.getTkNaiyouGyousuu(), 0, "特約内容行数");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTknm1(), "", "特約名称１");
        exBizCalcbleEquals(webKykNaiyouSyoukaiInfoBean.getTks1(), BizCurrency.optional(), "特約保険金額１");
        Assert.assertEquals(webKykNaiyouSyoukaiInfoBean.getTks1().getType()
            , BizNumberConfig.instance.getDefaultCurrencyType());
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTokuyakuhokenkikan1(), "", "特約保険期間１");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTokuyakuharaikomikikan1(), "", "特約払込期間１");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTknm2(), "", "特約名称２");
        exBizCalcbleEquals(webKykNaiyouSyoukaiInfoBean.getTks2(), BizCurrency.optional(), "特約保険金額２");
        Assert.assertEquals(webKykNaiyouSyoukaiInfoBean.getTks2().getType()
            , BizNumberConfig.instance.getDefaultCurrencyType());
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTokuyakuhokenkikan2(), "", "特約保険期間２");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTokuyakuharaikomikikan2(), "", "特約払込期間２");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTknm3(), "", "特約名称３");
        exBizCalcbleEquals(webKykNaiyouSyoukaiInfoBean.getTks3(), BizCurrency.optional(), "特約保険金額３");
        Assert.assertEquals(webKykNaiyouSyoukaiInfoBean.getTks3().getType()
            , BizNumberConfig.instance.getDefaultCurrencyType());
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTokuyakuhokenkikan3(), "", "特約保険期間３");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTokuyakuharaikomikikan3(), "", "特約払込期間３");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTknm4(), "", "特約名称４");
        exBizCalcbleEquals(webKykNaiyouSyoukaiInfoBean.getTks4(), BizCurrency.optional(), "特約保険金額４");
        Assert.assertEquals(webKykNaiyouSyoukaiInfoBean.getTks4().getType()
            , BizNumberConfig.instance.getDefaultCurrencyType());
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTokuyakuhokenkikan4(), "", "特約保険期間４");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTokuyakuharaikomikikan4(), "", "特約払込期間４");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTknm5(), "", "特約名称５");
        exBizCalcbleEquals(webKykNaiyouSyoukaiInfoBean.getTks5(), BizCurrency.optional(), "特約保険金額５");
        Assert.assertEquals(webKykNaiyouSyoukaiInfoBean.getTks5().getType()
            , BizNumberConfig.instance.getDefaultCurrencyType());
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTokuyakuhokenkikan5(), "", "特約保険期間５");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTokuyakuharaikomikikan5(), "", "特約払込期間５");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTknm6(), "", "特約名称６");
        exBizCalcbleEquals(webKykNaiyouSyoukaiInfoBean.getTks6(), BizCurrency.optional(), "特約保険金額６");
        Assert.assertEquals(webKykNaiyouSyoukaiInfoBean.getTks6().getType()
            , BizNumberConfig.instance.getDefaultCurrencyType());
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTokuyakuhokenkikan6(), "", "特約保険期間６");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTokuyakuharaikomikikan6(), "", "特約払込期間６");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTknm7(), "", "特約名称７");
        exBizCalcbleEquals(webKykNaiyouSyoukaiInfoBean.getTks7(), BizCurrency.optional(), "特約保険金額７");
        Assert.assertEquals(webKykNaiyouSyoukaiInfoBean.getTks7().getType()
            , BizNumberConfig.instance.getDefaultCurrencyType());
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTokuyakuhokenkikan7(), "", "特約保険期間７");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTokuyakuharaikomikikan7(), "", "特約払込期間７");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTknm8(), "", "特約名称８");
        exBizCalcbleEquals(webKykNaiyouSyoukaiInfoBean.getTks8(), BizCurrency.optional(), "特約保険金額８");
        Assert.assertEquals(webKykNaiyouSyoukaiInfoBean.getTks8().getType()
            , BizNumberConfig.instance.getDefaultCurrencyType());
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTokuyakuhokenkikan8(), "", "特約保険期間８");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTokuyakuharaikomikikan8(), "", "特約払込期間８");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTknm9(), "", "特約名称９");
        exBizCalcbleEquals(webKykNaiyouSyoukaiInfoBean.getTks9(), BizCurrency.optional(), "特約保険金額９");
        Assert.assertEquals(webKykNaiyouSyoukaiInfoBean.getTks9().getType()
            , BizNumberConfig.instance.getDefaultCurrencyType());
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTokuyakuhokenkikan9(), "", "特約保険期間９");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTokuyakuharaikomikikan9(), "", "特約払込期間９");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTknm10(), "", "特約名称１０");
        exBizCalcbleEquals(webKykNaiyouSyoukaiInfoBean.getTks10(), BizCurrency.optional(), "特約保険金額１０");
        Assert.assertEquals(webKykNaiyouSyoukaiInfoBean.getTks10().getType()
            , BizNumberConfig.instance.getDefaultCurrencyType());
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTokuyakuhokenkikan10(), "", "特約保険期間１０");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTokuyakuharaikomikikan10(), "", "特約払込期間１０");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTknm11(), "", "特約名称１１");
        exBizCalcbleEquals(webKykNaiyouSyoukaiInfoBean.getTks11(), BizCurrency.optional(), "特約保険金額１１");
        Assert.assertEquals(webKykNaiyouSyoukaiInfoBean.getTks11().getType()
            , BizNumberConfig.instance.getDefaultCurrencyType());
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTokuyakuhokenkikan11(), "", "特約保険期間１１");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTokuyakuharaikomikikan11(), "", "特約払込期間１１");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTknm12(), "", "特約名称１２");
        exBizCalcbleEquals(webKykNaiyouSyoukaiInfoBean.getTks12(), BizCurrency.optional(), "特約保険金額１２");
        Assert.assertEquals(webKykNaiyouSyoukaiInfoBean.getTks12().getType()
            , BizNumberConfig.instance.getDefaultCurrencyType());
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTokuyakuhokenkikan12(), "", "特約保険期間１２");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTokuyakuharaikomikikan12(), "", "特約払込期間１２");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTknm13(), "", "特約名称１３");
        exBizCalcbleEquals(webKykNaiyouSyoukaiInfoBean.getTks13(), BizCurrency.optional(), "特約保険金額１３");
        Assert.assertEquals(webKykNaiyouSyoukaiInfoBean.getTks13().getType()
            , BizNumberConfig.instance.getDefaultCurrencyType());
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTokuyakuhokenkikan13(), "", "特約保険期間１３");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTokuyakuharaikomikikan13(), "", "特約払込期間１３");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTknm14(), "", "特約名称１４");
        exBizCalcbleEquals(webKykNaiyouSyoukaiInfoBean.getTks14(), BizCurrency.optional(), "特約保険金額１４");
        Assert.assertEquals(webKykNaiyouSyoukaiInfoBean.getTks14().getType()
            , BizNumberConfig.instance.getDefaultCurrencyType());
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTokuyakuhokenkikan14(), "", "特約保険期間１４");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTokuyakuharaikomikikan14(), "", "特約払込期間１４");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTknm15(), "", "特約名称１５");
        exBizCalcbleEquals(webKykNaiyouSyoukaiInfoBean.getTks15(), BizCurrency.optional(), "特約保険金額１５");
        Assert.assertEquals(webKykNaiyouSyoukaiInfoBean.getTks15().getType()
            , BizNumberConfig.instance.getDefaultCurrencyType());
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTokuyakuhokenkikan15(), "", "特約保険期間１５");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTokuyakuharaikomikikan15(), "", "特約払込期間１５");
        exNumericEquals(webKykNaiyouSyoukaiInfoBean.getSyouhnNaiyouGyousuu(), 1, "商品内容行数");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getSyouhnNaiyou1(), "現在の保障内容は下記のとおりです。", "商品内容１");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getSyouhnNaiyou2(), "", "商品内容２");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getSyouhnNaiyou3(), "", "商品内容３");
        exNumericEquals(webKykNaiyouSyoukaiInfoBean.getHosyouNaiyouGyousuu(), 6, "保障内容行数");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHosyouNaiyou1(), "平成３０年　３月１６日　請求により円建終身保険に変更済", "保障内容１");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHosyouNaiyou2(), "　　　　　　　　　　　　到達金額　　　　　５０，０００円", "保障内容２");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHosyouNaiyou3(), "死亡時支払金受取人　契約者　様", "保障内容３");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHosyouNaiyou4(), "解約返戻金額（照会日時点）　１，０００円", "保障内容４");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHosyouNaiyou5(), "積立金額（照会日時点）　１，０００円", "保障内容５");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHosyouNaiyou6(), "保険法対応契約", "保障内容６");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHosyouNaiyou7(), "", "保障内容７");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHosyouNaiyou8(), "", "保障内容８");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHosyouNaiyou9(), "", "保障内容９");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHosyouNaiyou10(), "", "保障内容１０");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHosyouNaiyou11(), "", "保障内容１１");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHosyouNaiyou12(), "", "保障内容１２");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHosyouNaiyou13(), "", "保障内容１３");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHosyouNaiyou14(), "", "保障内容１４");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHosyouNaiyou15(), "", "保障内容１５");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHosyouNaiyou16(), "", "保障内容１６");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHosyouNaiyou17(), "", "保障内容１７");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHosyouNaiyou18(), "", "保障内容１８");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHosyouNaiyou19(), "", "保障内容１９");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHosyouNaiyou20(), "", "保障内容２０");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHosyouNaiyou21(), "", "保障内容２１");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHosyouNaiyou22(), "", "保障内容２２");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHosyouNaiyou23(), "", "保障内容２３");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHosyouNaiyou24(), "", "保障内容２４");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHosyouNaiyou25(), "", "保障内容２５");
        exNumericEquals(webKykNaiyouSyoukaiInfoBean.getHenkouKeiiGyousuu(), 1, "変更経緯行数");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHenkouKeii1(), "平成２７年１２月　１日　契約内容変更", "変更経緯１");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHenkouKeii2(), "", "変更経緯２");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHenkouKeii3(), "", "変更経緯３");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHenkouKeii4(), "", "変更経緯４");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHenkouKeii5(), "", "変更経緯５");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHenkouKeii6(), "", "変更経緯６");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHenkouKeii7(), "", "変更経緯７");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHenkouKeii8(), "", "変更経緯８");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHenkouKeii9(), "", "変更経緯９");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHenkouKeii10(), "", "変更経緯１０");
        exNumericEquals(webKykNaiyouSyoukaiInfoBean.getBosyuDrtenGyousuu(), 1, "募集代理店行数");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getBosyuDrtenNm1(), "取扱代理店名３", "募集代理店名１");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getDrtenBnwari1(), "", "代理店分割割合１");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getBosyuDrtenNm2(), "", "募集代理店名２");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getDrtenBnwari2(), "", "代理店分割割合２");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getMsgOutKbn(), "2", "MSG出力区分");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHosyouIkkatuMinaokeiyakuHyouji(), "0", "保障一括見直契約表示");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHhknnmkn(), "ﾋﾎｹﾝｼｶﾅ", "被保険者氏名(ｶﾅ)");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHokenryouSyuunouJyoukyou(), "正常収納中", "保険料収納状況");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getJikaiHokenryouJyuutouYm(), "平成２８年　６月", "次回保険料充当年月");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getMdhansybetuKbn(), "01", "窓販種別区分");
    }

    @Test
    @TestOrder(650)
    public void testExec_A65() {


        MockObjectManager.initialize();
        BzGetProcessSummaryMockForHozen.SYORIPTN = BzGetProcessSummaryMockForHozen.TESTPATTERN2;
        BzGetAdrDataMockForHozen.SYORIPTN = BzGetAdrDataMockForHozen.TESTPATTERN1;
        CalcHkShrKngkMockForHozen.SYORIPTN = CalcHkShrKngkMockForHozen.TESTPATTERN4;
        KeisanWExtMockForHozen.SYORIPTN = KeisanWExtMockForHozen.TESTPATTERN2;
        KeisanWMockForHozen.SYORIPTN = KeisanWMockForHozen.TESTPATTERN1;
        KeisanKijyungkMockForHozen.SYORIPTN = KeisanKijyungkMockForHozen.TESTPATTERN2;
        KeisanGaikakanzanMockForHozen.SYORIPTN = KeisanGaikakanzanMockForHozen.TESTPATTERN1;
        SetNenreiMockForHozen.SYORIPTN = SetNenreiMockForHozen.TESTPATTERN1;

        WebKykNaiyouSyoukaiInfoBean webKykNaiyouSyoukaiInfoBean =
            hbKeiyakuSyoukai.exec("31809111545", BizDate.valueOf("20160621"), C_TanmatuSiyouKbn.SOUGOU_IPPAN,"A10010");

        exStringEquals(webKykNaiyouSyoukaiInfoBean.getErrorKbn(), "", "エラー区分");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getErrorMsg(), "", "エラーメッセージ");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getKyknmkn(), "ｶﾅ", "契約者名（カナ）");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getKyknmkj(), "契約者名漢字１－４７　様", "契約者名（漢字）");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getKykseiymd(), "昭和５５年　１月　１日", "契約者生年月日");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getKojinhjnKbn(), "個人", "個人法人区分");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTelno(), "010-1234-5678", "電話番号");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getPostalCd(), "１２３－４５６７", "郵便番号");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getAdr(), "通信先住所１通信先住所２通信先住所３", "住所");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getAdrkn(), "ｶﾅｶﾅｶﾅｶﾅ", "住所(ｶﾅ)");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHhknnm(), "被保険者名　様", "被保険者氏名");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHhknsei(), "男性", "被保険者性別");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHhknseiymd(), "昭和５５年　１月　１日", "被保険者生年月日");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHhknNen(), "３５歳", "被保険者年齢");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHhknKykjiNen(), "２５歳", "被保険者契約時年齢");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getSyouhnnm(), "たのしみステップ", "商品名");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getSyurui(), "年金保険", "種類");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getSyono(), "31809111545", "証券番号");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getCifCd(), "*****", "CIFｺｰﾄﾞ");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getKykymd(), "平成２８年　６月２０日", "契約日");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHrkhou(), "一時払", "払込方法");
        exBizCalcbleEquals(webKykNaiyouSyoukaiInfoBean.getSibous()
            , BizCurrency.valueOf(10000.00, BizCurrencyTypes.AU_DOLLAR) , "死亡保険金");
        Assert.assertEquals(webKykNaiyouSyoukaiInfoBean.getSibous().getType(), BizCurrencyTypes.AU_DOLLAR);
        exBizCalcbleEquals(webKykNaiyouSyoukaiInfoBean.getHrkp()
            , BizCurrency.valueOf(1001.00, BizCurrencyTypes.DOLLAR), "払込保険料");
        Assert.assertEquals(webKykNaiyouSyoukaiInfoBean.getHrkp().getType(), BizCurrencyTypes.DOLLAR);
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getNkShrStartYmd(), "平成２８年　３月　１日", "年金支払開始日");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getNenkinHosyouYear(), "　９年", "年金保証年");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getNenkinKbn(), "確定年金", "年金区分");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHaitouKbn(), "準有配当", "配当区分");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getSinsaKbn(), "", "診査区分");
        exNumericEquals(webKykNaiyouSyoukaiInfoBean.getTksuu(), 6, "特約数");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getLivingneedsTkhyj(), "", "リビングニーズ特約表示");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHokenMankiDay(), "平成２８年　２月２９日", "保険満期日");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getSyunm(), "個人年金", "主契約名称");
        exBizCalcbleEquals(webKykNaiyouSyoukaiInfoBean.getSyus()
            , BizCurrency.optional(), "主契約保険金額");
        Assert.assertEquals(webKykNaiyouSyoukaiInfoBean.getSyus().getType(), BizNumberConfig.instance.getDefaultCurrencyType());
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getSyuhknkkn(), "１０年間", "主契約保険期間");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getSyuhrkkkn(), "", "主契約払込期間");
        exNumericEquals(webKykNaiyouSyoukaiInfoBean.getTkNaiyouGyousuu(), 6, "特約内容行数");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTknm1(), "重度介護前払特約", "特約名称１");
        exBizCalcbleEquals(webKykNaiyouSyoukaiInfoBean.getTks1(), BizCurrency.optional(), "特約保険金額１");
        Assert.assertEquals(webKykNaiyouSyoukaiInfoBean.getTks1().getType()
            , BizNumberConfig.instance.getDefaultCurrencyType());
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTokuyakuhokenkikan1(), "", "特約保険期間１");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTokuyakuharaikomikikan1(), "", "特約払込期間１");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTknm2(), "初期死亡時円換算支払額最低保証特約", "特約名称２");
        exBizCalcbleEquals(webKykNaiyouSyoukaiInfoBean.getTks2(), BizCurrency.optional(), "特約保険金額２");
        Assert.assertEquals(webKykNaiyouSyoukaiInfoBean.getTks2().getType()
            , BizNumberConfig.instance.getDefaultCurrencyType());
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTokuyakuhokenkikan2(), "", "特約保険期間２");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTokuyakuharaikomikikan2(), "", "特約払込期間２");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTknm3(), "保険料円貨払込特約", "特約名称３");
        exBizCalcbleEquals(webKykNaiyouSyoukaiInfoBean.getTks3(), BizCurrency.optional(), "特約保険金額３");
        Assert.assertEquals(webKykNaiyouSyoukaiInfoBean.getTks3().getType()
            , BizNumberConfig.instance.getDefaultCurrencyType());
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTokuyakuhokenkikan3(), "", "特約保険期間３");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTokuyakuharaikomikikan3(), "", "特約払込期間３");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTknm4(), "保険料指定外通貨払込特約", "特約名称４");
        exBizCalcbleEquals(webKykNaiyouSyoukaiInfoBean.getTks4(), BizCurrency.optional(), "特約保険金額４");
        Assert.assertEquals(webKykNaiyouSyoukaiInfoBean.getTks4().getType()
            , BizNumberConfig.instance.getDefaultCurrencyType());
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTokuyakuhokenkikan4(), "", "特約保険期間４");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTokuyakuharaikomikikan4(), "", "特約払込期間４");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTknm5(), "保険契約者代理特約", "特約名称５");
        exBizCalcbleEquals(webKykNaiyouSyoukaiInfoBean.getTks5(), BizCurrency.optional(), "特約保険金額５");
        Assert.assertEquals(webKykNaiyouSyoukaiInfoBean.getTks5().getType()
            , BizNumberConfig.instance.getDefaultCurrencyType());
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTokuyakuhokenkikan5(), "", "特約保険期間５");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTokuyakuharaikomikikan5(), "", "特約払込期間５");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTknm6(), "指定代理請求特約", "特約名称６");
        exBizCalcbleEquals(webKykNaiyouSyoukaiInfoBean.getTks6(), BizCurrency.optional(), "特約保険金額６");
        Assert.assertEquals(webKykNaiyouSyoukaiInfoBean.getTks6().getType()
            , BizNumberConfig.instance.getDefaultCurrencyType());
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTokuyakuhokenkikan6(), "", "特約保険期間６");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTokuyakuharaikomikikan6(), "", "特約払込期間６");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTknm7(), "", "特約名称７");
        exBizCalcbleEquals(webKykNaiyouSyoukaiInfoBean.getTks7(), BizCurrency.optional(), "特約保険金額７");
        Assert.assertEquals(webKykNaiyouSyoukaiInfoBean.getTks7().getType()
            , BizNumberConfig.instance.getDefaultCurrencyType());
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTokuyakuhokenkikan7(), "", "特約保険期間７");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTokuyakuharaikomikikan7(), "", "特約払込期間７");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTknm8(), "", "特約名称８");
        exBizCalcbleEquals(webKykNaiyouSyoukaiInfoBean.getTks8(), BizCurrency.optional(), "特約保険金額８");
        Assert.assertEquals(webKykNaiyouSyoukaiInfoBean.getTks8().getType()
            , BizNumberConfig.instance.getDefaultCurrencyType());
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTokuyakuhokenkikan8(), "", "特約保険期間８");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTokuyakuharaikomikikan8(), "", "特約払込期間８");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTknm9(), "", "特約名称９");
        exBizCalcbleEquals(webKykNaiyouSyoukaiInfoBean.getTks9(), BizCurrency.optional(), "特約保険金額９");
        Assert.assertEquals(webKykNaiyouSyoukaiInfoBean.getTks9().getType()
            , BizNumberConfig.instance.getDefaultCurrencyType());
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTokuyakuhokenkikan9(), "", "特約保険期間９");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTokuyakuharaikomikikan9(), "", "特約払込期間９");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTknm10(), "", "特約名称１０");
        exBizCalcbleEquals(webKykNaiyouSyoukaiInfoBean.getTks10(), BizCurrency.optional(), "特約保険金額１０");
        Assert.assertEquals(webKykNaiyouSyoukaiInfoBean.getTks10().getType()
            , BizNumberConfig.instance.getDefaultCurrencyType());
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTokuyakuhokenkikan10(), "", "特約保険期間１０");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTokuyakuharaikomikikan10(), "", "特約払込期間１０");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTknm11(), "", "特約名称１１");
        exBizCalcbleEquals(webKykNaiyouSyoukaiInfoBean.getTks11(), BizCurrency.optional(), "特約保険金額１１");
        Assert.assertEquals(webKykNaiyouSyoukaiInfoBean.getTks11().getType()
            , BizNumberConfig.instance.getDefaultCurrencyType());
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTokuyakuhokenkikan11(), "", "特約保険期間１１");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTokuyakuharaikomikikan11(), "", "特約払込期間１１");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTknm12(), "", "特約名称１２");
        exBizCalcbleEquals(webKykNaiyouSyoukaiInfoBean.getTks12(), BizCurrency.optional(), "特約保険金額１２");
        Assert.assertEquals(webKykNaiyouSyoukaiInfoBean.getTks12().getType()
            , BizNumberConfig.instance.getDefaultCurrencyType());
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTokuyakuhokenkikan12(), "", "特約保険期間１２");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTokuyakuharaikomikikan12(), "", "特約払込期間１２");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTknm13(), "", "特約名称１３");
        exBizCalcbleEquals(webKykNaiyouSyoukaiInfoBean.getTks13(), BizCurrency.optional(), "特約保険金額１３");
        Assert.assertEquals(webKykNaiyouSyoukaiInfoBean.getTks13().getType()
            , BizNumberConfig.instance.getDefaultCurrencyType());
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTokuyakuhokenkikan13(), "", "特約保険期間１３");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTokuyakuharaikomikikan13(), "", "特約払込期間１３");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTknm14(), "", "特約名称１４");
        exBizCalcbleEquals(webKykNaiyouSyoukaiInfoBean.getTks14(), BizCurrency.optional(), "特約保険金額１４");
        Assert.assertEquals(webKykNaiyouSyoukaiInfoBean.getTks14().getType()
            , BizNumberConfig.instance.getDefaultCurrencyType());
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTokuyakuhokenkikan14(), "", "特約保険期間１４");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTokuyakuharaikomikikan14(), "", "特約払込期間１４");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTknm15(), "", "特約名称１５");
        exBizCalcbleEquals(webKykNaiyouSyoukaiInfoBean.getTks15(), BizCurrency.optional(), "特約保険金額１５");
        Assert.assertEquals(webKykNaiyouSyoukaiInfoBean.getTks15().getType()
            , BizNumberConfig.instance.getDefaultCurrencyType());
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTokuyakuhokenkikan15(), "", "特約保険期間１５");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTokuyakuharaikomikikan15(), "", "特約払込期間１５");
        exNumericEquals(webKykNaiyouSyoukaiInfoBean.getSyouhnNaiyouGyousuu(), 1, "商品内容行数");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getSyouhnNaiyou1(), "現在の保障内容は下記のとおりです。", "商品内容１");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getSyouhnNaiyou2(), "", "商品内容２");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getSyouhnNaiyou3(), "", "商品内容３");
        exNumericEquals(webKykNaiyouSyoukaiInfoBean.getHosyouNaiyouGyousuu(),17, "保障内容行数");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHosyouNaiyou1(), "平成３０年　３月１６日　請求により円建年金保険に変更済", "保障内容１");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHosyouNaiyou2(), "　　　　　　　　　　　　到達金額　　　　　５０，０００円", "保障内容２");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHosyouNaiyou3(), "死亡時支払金受取人　シボウトクテイメイギ１－４７　様", "保障内容３");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHosyouNaiyou4(), "年金受取人　　　　　契約者　様", "保障内容４");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHosyouNaiyou5(), "契約者代理人　　　　ケイダイメイ　１－４７　様　　　　　　　", "保障内容５");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHosyouNaiyou6(), "指定代理請求人　　　シボウトクテイメイギ１－４７　様　　　　", "保障内容６");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHosyouNaiyou7(), "契約加入時しおり約款検索コード　０１－１９１２－２７６１", "保障内容７");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHosyouNaiyou8(), "約款受領方法　Ｗｅｂでの受取り（インターネット環境で確認）", "保障内容８");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHosyouNaiyou9(), "第３保険期間（照会日時点）　　　　　　　　　　　１０，０００円", "保障内容９");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHosyouNaiyou10(), "　　　　　　　　　　　　　　　　　　　　　　　　（円）", "保障内容１０");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHosyouNaiyou11(), "解約返戻金額（照会日時点）　１，０００円", "保障内容１１");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHosyouNaiyou12(), "積立金額（照会日時点）　１，０００円", "保障内容１２");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHosyouNaiyou13(), "保険法対応契約", "保障内容１３");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHosyouNaiyou14(), "重度介護前払特約あり", "保障内容１４");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHosyouNaiyou15(), "初期死亡時円換算支払額最低保証特約あり", "保障内容１５");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHosyouNaiyou16(), "保険契約者代理特約あり", "保障内容１６");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHosyouNaiyou17(), "指定代理請求特約あり", "保障内容１７");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHosyouNaiyou18(), "", "保障内容１８");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHosyouNaiyou19(), "", "保障内容１９");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHosyouNaiyou20(), "", "保障内容２０");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHosyouNaiyou21(), "", "保障内容２１");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHosyouNaiyou22(), "", "保障内容２２");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHosyouNaiyou23(), "", "保障内容２３");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHosyouNaiyou24(), "", "保障内容２４");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHosyouNaiyou25(), "", "保障内容２５");
        exNumericEquals(webKykNaiyouSyoukaiInfoBean.getHenkouKeiiGyousuu(), 2, "変更経緯行数");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHenkouKeii1(), "平成２７年１２月　１日　契約内容変更", "変更経緯１");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHenkouKeii2(), "平成２７年１２月　１日　契約内容変更", "変更経緯２");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHenkouKeii3(), "", "変更経緯３");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHenkouKeii4(), "", "変更経緯４");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHenkouKeii5(), "", "変更経緯５");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHenkouKeii6(), "", "変更経緯６");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHenkouKeii7(), "", "変更経緯７");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHenkouKeii8(), "", "変更経緯８");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHenkouKeii9(), "", "変更経緯９");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHenkouKeii10(), "", "変更経緯１０");
        exNumericEquals(webKykNaiyouSyoukaiInfoBean.getBosyuDrtenGyousuu(), 2, "募集代理店行数");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getBosyuDrtenNm1(), "取扱代理店名３", "募集代理店名１");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getDrtenBnwari1(), "", "代理店分割割合１");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getBosyuDrtenNm2(), "取扱代理店名３", "募集代理店名２");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getDrtenBnwari2(), "", "代理店分割割合２");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getMsgOutKbn(), "2", "MSG出力区分");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHosyouIkkatuMinaokeiyakuHyouji(), "0", "保障一括見直契約表示");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHhknnmkn(), "ﾋﾎｹﾝｼｶﾅ", "被保険者氏名(ｶﾅ)");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHokenryouSyuunouJyoukyou(), "－", "保険料収納状況");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getJikaiHokenryouJyuutouYm(), "－", "次回保険料充当年月");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getMdhansybetuKbn(), "01", "窓販種別区分");
    }


    @Test
    @TestOrder(660)
    public void testExec_A66() {

        MockObjectManager.initialize();
        BzGetProcessSummaryMockForHozen.SYORIPTN = BzGetProcessSummaryMockForHozen.TESTPATTERN2;
        BzGetAdrDataMockForHozen.SYORIPTN = BzGetAdrDataMockForHozen.TESTPATTERN1;
        SetNenreiMockForHozen.SYORIPTN = SetNenreiMockForHozen.TESTPATTERN1;

        WebKykNaiyouSyoukaiInfoBean webKykNaiyouSyoukaiInfoBean =
            hbKeiyakuSyoukai.exec("99806011127", BizDate.valueOf("20200401"), C_TanmatuSiyouKbn.SOUGOU_IPPAN, "A10010");

        exStringEquals(webKykNaiyouSyoukaiInfoBean.getErrorKbn(), "1", "エラー区分");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getErrorMsg()
            , "選択されたご契約についてはご照会できません。", "エラーメッセージ");
        CheckEebKykNaiyouSyoukaiInfoBean(webKykNaiyouSyoukaiInfoBean);
    }

    @Test
    @TestOrder(670)
    public void testExec_A67() {


        MockObjectManager.initialize();
        BzGetProcessSummaryMockForHozen.SYORIPTN = BzGetProcessSummaryMockForHozen.TESTPATTERN2;
        BzGetAdrDataMockForHozen.SYORIPTN = BzGetAdrDataMockForHozen.TESTPATTERN1;
        CalcHkShrKngkMockForHozen.SYORIPTN = CalcHkShrKngkMockForHozen.TESTPATTERN4;
        KeisanWExtMockForHozen.SYORIPTN = KeisanWExtMockForHozen.TESTPATTERN2;
        KeisanWMockForHozen.SYORIPTN = KeisanWMockForHozen.TESTPATTERN1;
        KeisanKijyungkMockForHozen.SYORIPTN = KeisanKijyungkMockForHozen.TESTPATTERN2;
        KeisanGaikakanzanMockForHozen.SYORIPTN = KeisanGaikakanzanMockForHozen.TESTPATTERN1;
        SetNenreiMockForHozen.SYORIPTN = SetNenreiMockForHozen.TESTPATTERN1;


        WebKykNaiyouSyoukaiInfoBean webKykNaiyouSyoukaiInfoBean =
            hbKeiyakuSyoukai.exec("17806000183", BizDate.valueOf("20200401"), C_TanmatuSiyouKbn.DAIRITENBOSYUUNIN, "100006");


        exStringEquals(webKykNaiyouSyoukaiInfoBean.getErrorKbn(), "", "エラー区分");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getErrorMsg(), "", "エラーメッセージ");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getSyono(), "17806000183", "証券番号");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHrkhou(), "６か月一括払　クレジット払扱　一括入金中", "払込方法");



    }

    @Test
    @TestOrder(680)
    public void testExec_A68() {


        MockObjectManager.initialize();
        BzGetProcessSummaryMockForHozen.SYORIPTN = BzGetProcessSummaryMockForHozen.TESTPATTERN2;
        BzGetAdrDataMockForHozen.SYORIPTN = BzGetAdrDataMockForHozen.TESTPATTERN1;
        CalcHkShrKngkMockForHozen.SYORIPTN = CalcHkShrKngkMockForHozen.TESTPATTERN4;
        KeisanWExtMockForHozen.SYORIPTN = KeisanWExtMockForHozen.TESTPATTERN2;
        KeisanWMockForHozen.SYORIPTN = KeisanWMockForHozen.TESTPATTERN1;
        KeisanKijyungkMockForHozen.SYORIPTN = KeisanKijyungkMockForHozen.TESTPATTERN2;
        KeisanGaikakanzanMockForHozen.SYORIPTN = KeisanGaikakanzanMockForHozen.TESTPATTERN1;
        SetNenreiMockForHozen.SYORIPTN = SetNenreiMockForHozen.TESTPATTERN1;

        WebKykNaiyouSyoukaiInfoBean webKykNaiyouSyoukaiInfoBean =
            hbKeiyakuSyoukai.exec("17806000194", BizDate.valueOf("20200401"), C_TanmatuSiyouKbn.DAIRITENBOSYUUNIN, "100006");


        exStringEquals(webKykNaiyouSyoukaiInfoBean.getErrorKbn(), "", "エラー区分");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getErrorMsg(), "", "エラーメッセージ");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getSyono(), "17806000194", "証券番号");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHrkhou(), "１２か月一括払　クレジット払扱　一括入金中", "払込方法");        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHokenryouSyuunouJyoukyou(), "正常収納中", "保険料収納状況");

    }

    @Test
    @TestOrder(690)
    public void testExec_A69() {


        MockObjectManager.initialize();
        BzGetProcessSummaryMockForHozen.SYORIPTN = BzGetProcessSummaryMockForHozen.TESTPATTERN2;
        BzGetAdrDataMockForHozen.SYORIPTN = BzGetAdrDataMockForHozen.TESTPATTERN1;
        CalcHkShrKngkMockForHozen.SYORIPTN = CalcHkShrKngkMockForHozen.TESTPATTERN4;
        KeisanWExtMockForHozen.SYORIPTN = KeisanWExtMockForHozen.TESTPATTERN2;
        KeisanWMockForHozen.SYORIPTN = KeisanWMockForHozen.TESTPATTERN1;
        KeisanKijyungkMockForHozen.SYORIPTN = KeisanKijyungkMockForHozen.TESTPATTERN2;
        KeisanGaikakanzanMockForHozen.SYORIPTN = KeisanGaikakanzanMockForHozen.TESTPATTERN1;
        SetNenreiMockForHozen.SYORIPTN = SetNenreiMockForHozen.TESTPATTERN1;
        WebKykNaiyouSyoukaiInfoBean webKykNaiyouSyoukaiInfoBean =
            hbKeiyakuSyoukai.exec("17806000208", BizDate.valueOf("20200401"), C_TanmatuSiyouKbn.DAIRITENBOSYUUNIN, "100006");


        exStringEquals(webKykNaiyouSyoukaiInfoBean.getErrorKbn(), "", "エラー区分");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getErrorMsg(), "", "エラーメッセージ");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getSyono(), "17806000208", "証券番号");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHrkhou(), "月払　クレジット払扱", "払込方法");
    }
    @Test
    @TestOrder(700)
    public void testExec_A70() {

        MockObjectManager.initialize();
        BzGetProcessSummaryMockForHozen.SYORIPTN = BzGetProcessSummaryMockForHozen.TESTPATTERN2;
        BzGetAdrDataMockForHozen.SYORIPTN = BzGetAdrDataMockForHozen.TESTPATTERN1;
        CalcHkShrKngkMockForHozen.SYORIPTN = CalcHkShrKngkMockForHozen.TESTPATTERN4;
        KeisanWExtMockForHozen.SYORIPTN = KeisanWExtMockForHozen.TESTPATTERN2;
        KeisanWMockForHozen.SYORIPTN = KeisanWMockForHozen.TESTPATTERN1;
        KeisanKijyungkMockForHozen.SYORIPTN = KeisanKijyungkMockForHozen.TESTPATTERN2;
        KeisanGaikakanzanMockForHozen.SYORIPTN = KeisanGaikakanzanMockForHozen.TESTPATTERN1;
        SetNenreiMockForHozen.SYORIPTN = SetNenreiMockForHozen.TESTPATTERN1;

        WebKykNaiyouSyoukaiInfoBean webKykNaiyouSyoukaiInfoBean =
            hbKeiyakuSyoukai.exec("99806011150", BizDate.valueOf("20200401"), C_TanmatuSiyouKbn.SOUGOU_IPPAN,"A10010");

        exStringEquals(webKykNaiyouSyoukaiInfoBean.getErrorKbn(), "", "エラー区分");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getErrorMsg(), "", "エラーメッセージ");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getSyouhnnm(), "５年ごと利差配当付指定通貨建終身保険（一時払い）　ふるはーとＪロードグローバル", "商品名");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getSyurui(), "終身保険", "種類");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getSyono(), "99806011150", "証券番号");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHosyouNaiyou1(), "平成３０年　３月１６日　目標到達（目標値：１％）により円建終身保険に変更済", "保障内容１");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHosyouNaiyou2(), "　　　　　　　　　　　　到達金額　　　　　５０，０００円", "保障内容２");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHosyouNaiyou3(), "　　　　　　　　　　　　円建変更時返戻金　５，０００円　（支払済）", "保障内容３");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHenkouKeii1(), "平成２７年１２月　１日　契約内容変更", "変更経緯１");
    }
    @Test
    @TestOrder(710)
    public void testExec_A71() {

        MockObjectManager.initialize();
        BzGetProcessSummaryMockForHozen.SYORIPTN = BzGetProcessSummaryMockForHozen.TESTPATTERN2;
        BzGetAdrDataMockForHozen.SYORIPTN = BzGetAdrDataMockForHozen.TESTPATTERN1;
        CalcHkShrKngkMockForHozen.SYORIPTN = CalcHkShrKngkMockForHozen.TESTPATTERN4;
        KeisanWExtMockForHozen.SYORIPTN = KeisanWExtMockForHozen.TESTPATTERN2;
        KeisanWMockForHozen.SYORIPTN = KeisanWMockForHozen.TESTPATTERN1;
        KeisanKijyungkMockForHozen.SYORIPTN = KeisanKijyungkMockForHozen.TESTPATTERN2;
        KeisanGaikakanzanMockForHozen.SYORIPTN = KeisanGaikakanzanMockForHozen.TESTPATTERN1;
        SetNenreiMockForHozen.SYORIPTN = SetNenreiMockForHozen.TESTPATTERN1;

        WebKykNaiyouSyoukaiInfoBean webKykNaiyouSyoukaiInfoBean =
            hbKeiyakuSyoukai.exec("99806011161", BizDate.valueOf("20200401"), C_TanmatuSiyouKbn.SOUGOU_IPPAN,"A10010");

        exStringEquals(webKykNaiyouSyoukaiInfoBean.getSyouhnnm(), "５年ごと利差配当付指定通貨建終身保険（一時払い）　ふるはーとＪロードグローバル", "商品名");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getSyurui(), "終身保険", "種類");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getSyono(), "99806011161", "証券番号");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHosyouNaiyou1(), "平成３０年　３月１６日　目標到達（目標値：１％）により円建終身保険に変更済", "保障内容１");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHosyouNaiyou2(), "　　　　　　　　　　　　到達金額　　　　　５０，０００円", "保障内容２");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHosyouNaiyou3(), "死亡時支払金受取人　契約者　様", "保障内容３");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHenkouKeii1(), "平成２７年１２月　１日　契約内容変更", "変更経緯１");
    }
    @Test
    @TestOrder(720)
    public void testExec_A72() {
        changeSystemDate();

        MockObjectManager.initialize();
        BzGetProcessSummaryMockForHozen.SYORIPTN = BzGetProcessSummaryMockForHozen.TESTPATTERN2;
        BzGetAdrDataMockForHozen.SYORIPTN = BzGetAdrDataMockForHozen.TESTPATTERN1;
        CalcHkShrKngkMockForHozen.SYORIPTN = CalcHkShrKngkMockForHozen.TESTPATTERN4;
        KeisanWExtMockForHozen.SYORIPTN = KeisanWExtMockForHozen.TESTPATTERN2;
        KeisanWMockForHozen.SYORIPTN = KeisanWMockForHozen.TESTPATTERN1;
        KeisanKijyungkMockForHozen.SYORIPTN = KeisanKijyungkMockForHozen.TESTPATTERN2;
        KeisanGaikakanzanMockForHozen.SYORIPTN = KeisanGaikakanzanMockForHozen.TESTPATTERN1;
        SetNenreiMockForHozen.SYORIPTN = SetNenreiMockForHozen.TESTPATTERN1;
        HanteiKhSisuurendoTmttknJyoutaiMockForHozen.SYORIPTN = HanteiKhSisuurendoTmttknJyoutaiMockForHozen.TESTPATTERN1;

        WebKykNaiyouSyoukaiInfoBean webKykNaiyouSyoukaiInfoBean =
            hbKeiyakuSyoukai.exec("31809111556", BizDate.valueOf("20160621"), C_TanmatuSiyouKbn.SOUGOU_IPPAN,"A10010");

        exStringEquals(webKykNaiyouSyoukaiInfoBean.getErrorKbn(), "", "エラー区分");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getErrorMsg(), "", "エラーメッセージ");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getKyknmkn(), "ｶﾅ", "契約者名（カナ）");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getKyknmkj(), "契約者名漢字１－６０　様", "契約者名（漢字）");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getKykseiymd(), "昭和５５年　１月　１日", "契約者生年月日");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getKojinhjnKbn(), "個人", "個人法人区分");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTelno(), "010-1234-5678", "電話番号");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getPostalCd(), "１２３－４５６７", "郵便番号");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getAdr(), "通信先住所１通信先住所２通信先住所３", "住所");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getAdrkn(), "ｶﾅｶﾅｶﾅｶﾅ", "住所(ｶﾅ)");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHhknnm(), "被保険者名　様", "被保険者氏名");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHhknsei(), "男性", "被保険者性別");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHhknseiymd(), "昭和５５年　１月　１日", "被保険者生年月日");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHhknNen(), "３５歳", "被保険者年齢");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHhknKykjiNen(), "２５歳", "被保険者契約時年齢");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getSyouhnnm(), "カスケード　たのしみグローバル（指数連動プラン）", "商品名");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getSyurui(), "年金保険", "種類");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getSyono(), "31809111556", "証券番号");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getCifCd(), "*****", "CIFｺｰﾄﾞ");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getKykymd(), "平成　７年　１月　１日", "契約日");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHrkhou(), "一時払", "払込方法");
        exBizCalcbleEquals(webKykNaiyouSyoukaiInfoBean.getSibous()
            , BizCurrency.valueOf(10000.00, BizCurrencyTypes.AU_DOLLAR) , "死亡保険金");
        Assert.assertEquals(webKykNaiyouSyoukaiInfoBean.getSibous().getType(), BizCurrencyTypes.AU_DOLLAR);
        exBizCalcbleEquals(webKykNaiyouSyoukaiInfoBean.getHrkp()
            , BizCurrency.valueOf(1001.00, BizCurrencyTypes.DOLLAR), "払込保険料");
        Assert.assertEquals(webKykNaiyouSyoukaiInfoBean.getHrkp().getType(), BizCurrencyTypes.DOLLAR);
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getNkShrStartYmd(), "平成２９年　１月　１日", "年金支払開始日");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getNenkinHosyouYear(), "１５年", "年金保証年");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getNenkinKbn(), "確定年金", "年金区分");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHaitouKbn(), "準有配当", "配当区分");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getSinsaKbn(), "", "診査区分");
        exNumericEquals(webKykNaiyouSyoukaiInfoBean.getTksuu(), 0, "特約数");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getLivingneedsTkhyj(), "", "リビングニーズ特約表示");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHokenMankiDay(), "平成２８年１２月３１日", "保険満期日");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getSyunm(), "個人年金", "主契約名称");
        exBizCalcbleEquals(webKykNaiyouSyoukaiInfoBean.getSyus()
            , BizCurrency.optional(), "主契約保険金額");
        Assert.assertEquals(webKykNaiyouSyoukaiInfoBean.getSyus().getType(), BizNumberConfig.instance.getDefaultCurrencyType());
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getSyuhknkkn(), "　０年間", "主契約保険期間");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getSyuhrkkkn(), "", "主契約払込期間");
        exNumericEquals(webKykNaiyouSyoukaiInfoBean.getTkNaiyouGyousuu(), 0, "特約内容行数");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTknm1(), "", "特約名称１");
        exBizCalcbleEquals(webKykNaiyouSyoukaiInfoBean.getTks1(), BizCurrency.optional(), "特約保険金額１");
        Assert.assertEquals(webKykNaiyouSyoukaiInfoBean.getTks1().getType()
            , BizNumberConfig.instance.getDefaultCurrencyType());
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTokuyakuhokenkikan1(), "", "特約保険期間１");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTokuyakuharaikomikikan1(), "", "特約払込期間１");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTknm2(), "", "特約名称２");
        exBizCalcbleEquals(webKykNaiyouSyoukaiInfoBean.getTks2(), BizCurrency.optional(), "特約保険金額２");
        Assert.assertEquals(webKykNaiyouSyoukaiInfoBean.getTks2().getType()
            , BizNumberConfig.instance.getDefaultCurrencyType());
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTokuyakuhokenkikan2(), "", "特約保険期間２");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTokuyakuharaikomikikan2(), "", "特約払込期間２");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTknm3(), "", "特約名称３");
        exBizCalcbleEquals(webKykNaiyouSyoukaiInfoBean.getTks3(), BizCurrency.optional(), "特約保険金額３");
        Assert.assertEquals(webKykNaiyouSyoukaiInfoBean.getTks3().getType()
            , BizNumberConfig.instance.getDefaultCurrencyType());
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTokuyakuhokenkikan3(), "", "特約保険期間３");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTokuyakuharaikomikikan3(), "", "特約払込期間３");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTknm4(), "", "特約名称４");
        exBizCalcbleEquals(webKykNaiyouSyoukaiInfoBean.getTks4(), BizCurrency.optional(), "特約保険金額４");
        Assert.assertEquals(webKykNaiyouSyoukaiInfoBean.getTks4().getType()
            , BizNumberConfig.instance.getDefaultCurrencyType());
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTokuyakuhokenkikan4(), "", "特約保険期間４");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTokuyakuharaikomikikan4(), "", "特約払込期間４");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTknm5(), "", "特約名称５");
        exBizCalcbleEquals(webKykNaiyouSyoukaiInfoBean.getTks5(), BizCurrency.optional(), "特約保険金額５");
        Assert.assertEquals(webKykNaiyouSyoukaiInfoBean.getTks5().getType()
            , BizNumberConfig.instance.getDefaultCurrencyType());
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTokuyakuhokenkikan5(), "", "特約保険期間５");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTokuyakuharaikomikikan5(), "", "特約払込期間５");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTknm6(), "", "特約名称６");
        exBizCalcbleEquals(webKykNaiyouSyoukaiInfoBean.getTks6(), BizCurrency.optional(), "特約保険金額６");
        Assert.assertEquals(webKykNaiyouSyoukaiInfoBean.getTks6().getType()
            , BizNumberConfig.instance.getDefaultCurrencyType());
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTokuyakuhokenkikan6(), "", "特約保険期間６");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTokuyakuharaikomikikan6(), "", "特約払込期間６");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTknm7(), "", "特約名称７");
        exBizCalcbleEquals(webKykNaiyouSyoukaiInfoBean.getTks7(), BizCurrency.optional(), "特約保険金額７");
        Assert.assertEquals(webKykNaiyouSyoukaiInfoBean.getTks7().getType()
            , BizNumberConfig.instance.getDefaultCurrencyType());
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTokuyakuhokenkikan7(), "", "特約保険期間７");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTokuyakuharaikomikikan7(), "", "特約払込期間７");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTknm8(), "", "特約名称８");
        exBizCalcbleEquals(webKykNaiyouSyoukaiInfoBean.getTks8(), BizCurrency.optional(), "特約保険金額８");
        Assert.assertEquals(webKykNaiyouSyoukaiInfoBean.getTks8().getType()
            , BizNumberConfig.instance.getDefaultCurrencyType());
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTokuyakuhokenkikan8(), "", "特約保険期間８");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTokuyakuharaikomikikan8(), "", "特約払込期間８");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTknm9(), "", "特約名称９");
        exBizCalcbleEquals(webKykNaiyouSyoukaiInfoBean.getTks9(), BizCurrency.optional(), "特約保険金額９");
        Assert.assertEquals(webKykNaiyouSyoukaiInfoBean.getTks9().getType()
            , BizNumberConfig.instance.getDefaultCurrencyType());
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTokuyakuhokenkikan9(), "", "特約保険期間９");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTokuyakuharaikomikikan9(), "", "特約払込期間９");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTknm10(), "", "特約名称１０");
        exBizCalcbleEquals(webKykNaiyouSyoukaiInfoBean.getTks10(), BizCurrency.optional(), "特約保険金額１０");
        Assert.assertEquals(webKykNaiyouSyoukaiInfoBean.getTks10().getType()
            , BizNumberConfig.instance.getDefaultCurrencyType());
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTokuyakuhokenkikan10(), "", "特約保険期間１０");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTokuyakuharaikomikikan10(), "", "特約払込期間１０");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTknm11(), "", "特約名称１１");
        exBizCalcbleEquals(webKykNaiyouSyoukaiInfoBean.getTks11(), BizCurrency.optional(), "特約保険金額１１");
        Assert.assertEquals(webKykNaiyouSyoukaiInfoBean.getTks11().getType()
            , BizNumberConfig.instance.getDefaultCurrencyType());
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTokuyakuhokenkikan11(), "", "特約保険期間１１");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTokuyakuharaikomikikan11(), "", "特約払込期間１１");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTknm12(), "", "特約名称１２");
        exBizCalcbleEquals(webKykNaiyouSyoukaiInfoBean.getTks12(), BizCurrency.optional(), "特約保険金額１２");
        Assert.assertEquals(webKykNaiyouSyoukaiInfoBean.getTks12().getType()
            , BizNumberConfig.instance.getDefaultCurrencyType());
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTokuyakuhokenkikan12(), "", "特約保険期間１２");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTokuyakuharaikomikikan12(), "", "特約払込期間１２");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTknm13(), "", "特約名称１３");
        exBizCalcbleEquals(webKykNaiyouSyoukaiInfoBean.getTks13(), BizCurrency.optional(), "特約保険金額１３");
        Assert.assertEquals(webKykNaiyouSyoukaiInfoBean.getTks13().getType()
            , BizNumberConfig.instance.getDefaultCurrencyType());
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTokuyakuhokenkikan13(), "", "特約保険期間１３");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTokuyakuharaikomikikan13(), "", "特約払込期間１３");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTknm14(), "", "特約名称１４");
        exBizCalcbleEquals(webKykNaiyouSyoukaiInfoBean.getTks14(), BizCurrency.optional(), "特約保険金額１４");
        Assert.assertEquals(webKykNaiyouSyoukaiInfoBean.getTks14().getType()
            , BizNumberConfig.instance.getDefaultCurrencyType());
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTokuyakuhokenkikan14(), "", "特約保険期間１４");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTokuyakuharaikomikikan14(), "", "特約払込期間１４");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTknm15(), "", "特約名称１５");
        exBizCalcbleEquals(webKykNaiyouSyoukaiInfoBean.getTks15(), BizCurrency.optional(), "特約保険金額１５");
        Assert.assertEquals(webKykNaiyouSyoukaiInfoBean.getTks15().getType()
            , BizNumberConfig.instance.getDefaultCurrencyType());
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTokuyakuhokenkikan15(), "", "特約保険期間１５");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTokuyakuharaikomikikan15(), "", "特約払込期間１５");
        exNumericEquals(webKykNaiyouSyoukaiInfoBean.getSyouhnNaiyouGyousuu(), 1, "商品内容行数");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getSyouhnNaiyou1(), "現在の保障内容は下記のとおりです。", "商品内容１");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getSyouhnNaiyou2(), "", "商品内容２");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getSyouhnNaiyou3(), "", "商品内容３");
        exNumericEquals(webKykNaiyouSyoukaiInfoBean.getHosyouNaiyouGyousuu(), 11, "保障内容行数");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHosyouNaiyou1(), "死亡時支払金受取人　契約者　様", "保障内容１");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHosyouNaiyou2(), "年金受取人　　　　　契約者　様", "保障内容２");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHosyouNaiyou3(), "定率増加部分繰り入れ割合　　　０％", "保障内容３");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHosyouNaiyou4(), "払込保険料の円換算額　　　　１１，０００円", "保障内容４");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHosyouNaiyou5(), "　保険料領収日時点の円換算為替レート　１米ドル＝５０円（平成２９年　７月　１日）", "保障内容５");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHosyouNaiyou6(), "積立利率　２．４％　　積立金増加率上限　４．０５％　　たのしみ倍率　１．０２倍", "保障内容６");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHosyouNaiyou7(), "死亡時（照会日時点）　　　　１０，０００．００米ドル　　（１００円）", "保障内容７");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHosyouNaiyou8(), "解約返戻金額（照会日時点）　１，０００．００米ドル　　（１００円）", "保障内容８");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHosyouNaiyou9(), "積立金額（照会日時点）　１，０００．００米ドル　　（１００円）", "保障内容９");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHosyouNaiyou10(), "上記（）内の金額は、照会時点の為替レートで円換算した参考値であり変動します。", "保障内容１０");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHosyouNaiyou11(), "保険法対応契約", "保障内容１１");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHosyouNaiyou12(), "", "保障内容１２");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHosyouNaiyou13(), "", "保障内容１３");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHosyouNaiyou14(), "", "保障内容１４");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHosyouNaiyou15(), "", "保障内容１５");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHosyouNaiyou16(), "", "保障内容１６");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHosyouNaiyou17(), "", "保障内容１７");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHosyouNaiyou18(), "", "保障内容１８");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHosyouNaiyou19(), "", "保障内容１９");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHosyouNaiyou20(), "", "保障内容２０");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHosyouNaiyou21(), "", "保障内容２１");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHosyouNaiyou22(), "", "保障内容２２");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHosyouNaiyou23(), "", "保障内容２３");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHosyouNaiyou24(), "", "保障内容２４");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHosyouNaiyou25(), "", "保障内容２５");
        exNumericEquals(webKykNaiyouSyoukaiInfoBean.getHenkouKeiiGyousuu(), 1, "変更経緯行数");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHenkouKeii1(), "＊＊＊＊＊", "変更経緯１");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHenkouKeii2(), "", "変更経緯２");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHenkouKeii3(), "", "変更経緯３");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHenkouKeii4(), "", "変更経緯４");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHenkouKeii5(), "", "変更経緯５");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHenkouKeii6(), "", "変更経緯６");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHenkouKeii7(), "", "変更経緯７");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHenkouKeii8(), "", "変更経緯８");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHenkouKeii9(), "", "変更経緯９");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHenkouKeii10(), "", "変更経緯１０");
        exNumericEquals(webKykNaiyouSyoukaiInfoBean.getBosyuDrtenGyousuu(), 0, "募集代理店行数");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getBosyuDrtenNm1(), "", "募集代理店名１");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getDrtenBnwari1(), "", "代理店分割割合１");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getBosyuDrtenNm2(), "", "募集代理店名２");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getDrtenBnwari2(), "", "代理店分割割合２");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getMsgOutKbn(), "2", "MSG出力区分");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHosyouIkkatuMinaokeiyakuHyouji(), "0", "保障一括見直契約表示");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHhknnmkn(), "ﾋﾎｹﾝｼｶﾅ", "被保険者氏名(ｶﾅ)");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHokenryouSyuunouJyoukyou(), "－", "保険料収納状況");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getJikaiHokenryouJyuutouYm(), "－", "次回保険料充当年月");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getMdhansybetuKbn(), "01", "窓販種別区分");
    }
    @Test
    @TestOrder(730)
    public void testExec_A73() {
        changeSystemDate();

        MockObjectManager.initialize();
        BzGetProcessSummaryMockForHozen.SYORIPTN = BzGetProcessSummaryMockForHozen.TESTPATTERN2;
        BzGetAdrDataMockForHozen.SYORIPTN = BzGetAdrDataMockForHozen.TESTPATTERN1;
        CalcHkShrKngkMockForHozen.SYORIPTN = CalcHkShrKngkMockForHozen.TESTPATTERN4;
        KeisanWExtMockForHozen.SYORIPTN = KeisanWExtMockForHozen.TESTPATTERN2;
        KeisanWMockForHozen.SYORIPTN = KeisanWMockForHozen.TESTPATTERN1;
        KeisanKijyungkMockForHozen.SYORIPTN = KeisanKijyungkMockForHozen.TESTPATTERN2;
        KeisanGaikakanzanMockForHozen.SYORIPTN = KeisanGaikakanzanMockForHozen.TESTPATTERN1;
        SetNenreiMockForHozen.SYORIPTN = SetNenreiMockForHozen.TESTPATTERN1;
        HanteiKhSisuurendoTmttknJyoutaiMockForHozen.SYORIPTN = HanteiKhSisuurendoTmttknJyoutaiMockForHozen.TESTPATTERN1;

        WebKykNaiyouSyoukaiInfoBean webKykNaiyouSyoukaiInfoBean =
            hbKeiyakuSyoukai.exec("31809111567", BizDate.valueOf("20200930"), C_TanmatuSiyouKbn.SOUGOU_IPPAN,"A10010");

        exStringEquals(webKykNaiyouSyoukaiInfoBean.getErrorKbn(), "", "エラー区分");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getErrorMsg(), "", "エラーメッセージ");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getKyknmkn(), "ｶﾅ", "契約者名（カナ）");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getKyknmkj(), "契約者名漢字１－６１　様", "契約者名（漢字）");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getKykseiymd(), "昭和５５年　１月　１日", "契約者生年月日");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getKojinhjnKbn(), "個人", "個人法人区分");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTelno(), "010-1234-5678", "電話番号");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getPostalCd(), "１２３－４５６７", "郵便番号");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getAdr(), "通信先住所１通信先住所２通信先住所３", "住所");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getAdrkn(), "ｶﾅｶﾅｶﾅｶﾅ", "住所(ｶﾅ)");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHhknnm(), "被保険者名　様", "被保険者氏名");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHhknsei(), "男性", "被保険者性別");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHhknseiymd(), "昭和６０年　１月　１日", "被保険者生年月日");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHhknNen(), "３５歳", "被保険者年齢");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHhknKykjiNen(), "３５歳", "被保険者契約時年齢");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getSyouhnnm(), "５年ごと利差配当付指定通貨建個人年金保険（一時払い）（２０）　たのしみグローバルⅡ（指数連動プラン）", "商品名");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getSyurui(), "年金保険", "種類");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getSyono(), "31809111567", "証券番号");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getCifCd(), "*****", "CIFｺｰﾄﾞ");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getKykymd(), "令和　２年　９月　１日", "契約日");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHrkhou(), "一時払", "払込方法");
        exBizCalcbleEquals(webKykNaiyouSyoukaiInfoBean.getSibous()
            , BizCurrency.valueOf(10000.00, BizCurrencyTypes.AU_DOLLAR) , "死亡保険金");
        Assert.assertEquals(webKykNaiyouSyoukaiInfoBean.getSibous().getType(), BizCurrencyTypes.AU_DOLLAR);
        exBizCalcbleEquals(webKykNaiyouSyoukaiInfoBean.getHrkp()
            , BizCurrency.valueOf(1001.00, BizCurrencyTypes.DOLLAR), "払込保険料");
        Assert.assertEquals(webKykNaiyouSyoukaiInfoBean.getHrkp().getType(), BizCurrencyTypes.DOLLAR);
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getNkShrStartYmd(), "令和１２年　９月　１日", "年金支払開始日");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getNenkinHosyouYear(), "１０年", "年金保証年");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getNenkinKbn(), "確定年金", "年金区分");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHaitouKbn(), "準有配当", "配当区分");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getSinsaKbn(), "", "診査区分");
        exNumericEquals(webKykNaiyouSyoukaiInfoBean.getTksuu(), 0, "特約数");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getLivingneedsTkhyj(), "", "リビングニーズ特約表示");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHokenMankiDay(), "令和１２年　８月３１日", "保険満期日");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getSyunm(), "個人年金", "主契約名称");
        exBizCalcbleEquals(webKykNaiyouSyoukaiInfoBean.getSyus()
            , BizCurrency.optional(), "主契約保険金額");
        Assert.assertEquals(webKykNaiyouSyoukaiInfoBean.getSyus().getType(), BizNumberConfig.instance.getDefaultCurrencyType());
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getSyuhknkkn(), "　０年間", "主契約保険期間");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getSyuhrkkkn(), "", "主契約払込期間");
        exNumericEquals(webKykNaiyouSyoukaiInfoBean.getTkNaiyouGyousuu(), 0, "特約内容行数");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTknm1(), "", "特約名称１");
        exBizCalcbleEquals(webKykNaiyouSyoukaiInfoBean.getTks1(), BizCurrency.optional(), "特約保険金額１");
        Assert.assertEquals(webKykNaiyouSyoukaiInfoBean.getTks1().getType()
            , BizNumberConfig.instance.getDefaultCurrencyType());
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTokuyakuhokenkikan1(), "", "特約保険期間１");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTokuyakuharaikomikikan1(), "", "特約払込期間１");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTknm2(), "", "特約名称２");
        exBizCalcbleEquals(webKykNaiyouSyoukaiInfoBean.getTks2(), BizCurrency.optional(), "特約保険金額２");
        Assert.assertEquals(webKykNaiyouSyoukaiInfoBean.getTks2().getType()
            , BizNumberConfig.instance.getDefaultCurrencyType());
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTokuyakuhokenkikan2(), "", "特約保険期間２");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTokuyakuharaikomikikan2(), "", "特約払込期間２");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTknm3(), "", "特約名称３");
        exBizCalcbleEquals(webKykNaiyouSyoukaiInfoBean.getTks3(), BizCurrency.optional(), "特約保険金額３");
        Assert.assertEquals(webKykNaiyouSyoukaiInfoBean.getTks3().getType()
            , BizNumberConfig.instance.getDefaultCurrencyType());
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTokuyakuhokenkikan3(), "", "特約保険期間３");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTokuyakuharaikomikikan3(), "", "特約払込期間３");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTknm4(), "", "特約名称４");
        exBizCalcbleEquals(webKykNaiyouSyoukaiInfoBean.getTks4(), BizCurrency.optional(), "特約保険金額４");
        Assert.assertEquals(webKykNaiyouSyoukaiInfoBean.getTks4().getType()
            , BizNumberConfig.instance.getDefaultCurrencyType());
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTokuyakuhokenkikan4(), "", "特約保険期間４");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTokuyakuharaikomikikan4(), "", "特約払込期間４");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTknm5(), "", "特約名称５");
        exBizCalcbleEquals(webKykNaiyouSyoukaiInfoBean.getTks5(), BizCurrency.optional(), "特約保険金額５");
        Assert.assertEquals(webKykNaiyouSyoukaiInfoBean.getTks5().getType()
            , BizNumberConfig.instance.getDefaultCurrencyType());
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTokuyakuhokenkikan5(), "", "特約保険期間５");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTokuyakuharaikomikikan5(), "", "特約払込期間５");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTknm6(), "", "特約名称６");
        exBizCalcbleEquals(webKykNaiyouSyoukaiInfoBean.getTks6(), BizCurrency.optional(), "特約保険金額６");
        Assert.assertEquals(webKykNaiyouSyoukaiInfoBean.getTks6().getType()
            , BizNumberConfig.instance.getDefaultCurrencyType());
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTokuyakuhokenkikan6(), "", "特約保険期間６");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTokuyakuharaikomikikan6(), "", "特約払込期間６");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTknm7(), "", "特約名称７");
        exBizCalcbleEquals(webKykNaiyouSyoukaiInfoBean.getTks7(), BizCurrency.optional(), "特約保険金額７");
        Assert.assertEquals(webKykNaiyouSyoukaiInfoBean.getTks7().getType()
            , BizNumberConfig.instance.getDefaultCurrencyType());
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTokuyakuhokenkikan7(), "", "特約保険期間７");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTokuyakuharaikomikikan7(), "", "特約払込期間７");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTknm8(), "", "特約名称８");
        exBizCalcbleEquals(webKykNaiyouSyoukaiInfoBean.getTks8(), BizCurrency.optional(), "特約保険金額８");
        Assert.assertEquals(webKykNaiyouSyoukaiInfoBean.getTks8().getType()
            , BizNumberConfig.instance.getDefaultCurrencyType());
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTokuyakuhokenkikan8(), "", "特約保険期間８");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTokuyakuharaikomikikan8(), "", "特約払込期間８");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTknm9(), "", "特約名称９");
        exBizCalcbleEquals(webKykNaiyouSyoukaiInfoBean.getTks9(), BizCurrency.optional(), "特約保険金額９");
        Assert.assertEquals(webKykNaiyouSyoukaiInfoBean.getTks9().getType()
            , BizNumberConfig.instance.getDefaultCurrencyType());
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTokuyakuhokenkikan9(), "", "特約保険期間９");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTokuyakuharaikomikikan9(), "", "特約払込期間９");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTknm10(), "", "特約名称１０");
        exBizCalcbleEquals(webKykNaiyouSyoukaiInfoBean.getTks10(), BizCurrency.optional(), "特約保険金額１０");
        Assert.assertEquals(webKykNaiyouSyoukaiInfoBean.getTks10().getType()
            , BizNumberConfig.instance.getDefaultCurrencyType());
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTokuyakuhokenkikan10(), "", "特約保険期間１０");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTokuyakuharaikomikikan10(), "", "特約払込期間１０");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTknm11(), "", "特約名称１１");
        exBizCalcbleEquals(webKykNaiyouSyoukaiInfoBean.getTks11(), BizCurrency.optional(), "特約保険金額１１");
        Assert.assertEquals(webKykNaiyouSyoukaiInfoBean.getTks11().getType()
            , BizNumberConfig.instance.getDefaultCurrencyType());
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTokuyakuhokenkikan11(), "", "特約保険期間１１");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTokuyakuharaikomikikan11(), "", "特約払込期間１１");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTknm12(), "", "特約名称１２");
        exBizCalcbleEquals(webKykNaiyouSyoukaiInfoBean.getTks12(), BizCurrency.optional(), "特約保険金額１２");
        Assert.assertEquals(webKykNaiyouSyoukaiInfoBean.getTks12().getType()
            , BizNumberConfig.instance.getDefaultCurrencyType());
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTokuyakuhokenkikan12(), "", "特約保険期間１２");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTokuyakuharaikomikikan12(), "", "特約払込期間１２");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTknm13(), "", "特約名称１３");
        exBizCalcbleEquals(webKykNaiyouSyoukaiInfoBean.getTks13(), BizCurrency.optional(), "特約保険金額１３");
        Assert.assertEquals(webKykNaiyouSyoukaiInfoBean.getTks13().getType()
            , BizNumberConfig.instance.getDefaultCurrencyType());
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTokuyakuhokenkikan13(), "", "特約保険期間１３");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTokuyakuharaikomikikan13(), "", "特約払込期間１３");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTknm14(), "", "特約名称１４");
        exBizCalcbleEquals(webKykNaiyouSyoukaiInfoBean.getTks14(), BizCurrency.optional(), "特約保険金額１４");
        Assert.assertEquals(webKykNaiyouSyoukaiInfoBean.getTks14().getType()
            , BizNumberConfig.instance.getDefaultCurrencyType());
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTokuyakuhokenkikan14(), "", "特約保険期間１４");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTokuyakuharaikomikikan14(), "", "特約払込期間１４");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTknm15(), "", "特約名称１５");
        exBizCalcbleEquals(webKykNaiyouSyoukaiInfoBean.getTks15(), BizCurrency.optional(), "特約保険金額１５");
        Assert.assertEquals(webKykNaiyouSyoukaiInfoBean.getTks15().getType()
            , BizNumberConfig.instance.getDefaultCurrencyType());
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTokuyakuhokenkikan15(), "", "特約保険期間１５");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTokuyakuharaikomikikan15(), "", "特約払込期間１５");
        exNumericEquals(webKykNaiyouSyoukaiInfoBean.getSyouhnNaiyouGyousuu(), 1, "商品内容行数");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getSyouhnNaiyou1(), "現在の保障内容は下記のとおりです。", "商品内容１");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getSyouhnNaiyou2(), "", "商品内容２");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getSyouhnNaiyou3(), "", "商品内容３");
        exNumericEquals(webKykNaiyouSyoukaiInfoBean.getHosyouNaiyouGyousuu(), 11, "保障内容行数");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHosyouNaiyou1(), "死亡時支払金受取人　契約者　様", "保障内容１");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHosyouNaiyou2(), "年金受取人　　　　　契約者　様", "保障内容２");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHosyouNaiyou3(), "定率増加部分繰り入れ割合　　　０％", "保障内容３");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHosyouNaiyou4(), "払込保険料の円換算額　　　　１１，０００円", "保障内容４");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHosyouNaiyou5(), "　保険料領収日時点の円換算為替レート　１米ドル＝５０円（令和　２年　９月　１日）", "保障内容５");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHosyouNaiyou6(), "積立利率　２．４％　　連動率　６１％", "保障内容６");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHosyouNaiyou7(), "死亡時（照会日時点）　　　　１０，０００．００米ドル　　（１００円）", "保障内容７");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHosyouNaiyou8(), "解約返戻金額（照会日時点）　１，０００．００米ドル　　（１００円）", "保障内容８");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHosyouNaiyou9(), "積立金額（照会日時点）　１，０００．００米ドル　　（１００円）", "保障内容９");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHosyouNaiyou10(), "上記（）内の金額は、照会時点の為替レートで円換算した参考値であり変動します。", "保障内容１０");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHosyouNaiyou11(), "保険法対応契約", "保障内容１１");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHosyouNaiyou12(), "", "保障内容１２");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHosyouNaiyou13(), "", "保障内容１３");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHosyouNaiyou14(), "", "保障内容１４");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHosyouNaiyou15(), "", "保障内容１５");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHosyouNaiyou16(), "", "保障内容１６");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHosyouNaiyou17(), "", "保障内容１７");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHosyouNaiyou18(), "", "保障内容１８");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHosyouNaiyou19(), "", "保障内容１９");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHosyouNaiyou20(), "", "保障内容２０");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHosyouNaiyou21(), "", "保障内容２１");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHosyouNaiyou22(), "", "保障内容２２");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHosyouNaiyou23(), "", "保障内容２３");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHosyouNaiyou24(), "", "保障内容２４");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHosyouNaiyou25(), "", "保障内容２５");
        exNumericEquals(webKykNaiyouSyoukaiInfoBean.getHenkouKeiiGyousuu(), 1, "変更経緯行数");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHenkouKeii1(), "＊＊＊＊＊", "変更経緯１");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHenkouKeii2(), "", "変更経緯２");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHenkouKeii3(), "", "変更経緯３");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHenkouKeii4(), "", "変更経緯４");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHenkouKeii5(), "", "変更経緯５");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHenkouKeii6(), "", "変更経緯６");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHenkouKeii7(), "", "変更経緯７");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHenkouKeii8(), "", "変更経緯８");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHenkouKeii9(), "", "変更経緯９");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHenkouKeii10(), "", "変更経緯１０");
        exNumericEquals(webKykNaiyouSyoukaiInfoBean.getBosyuDrtenGyousuu(), 0, "募集代理店行数");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getBosyuDrtenNm1(), "", "募集代理店名１");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getDrtenBnwari1(), "", "代理店分割割合１");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getBosyuDrtenNm2(), "", "募集代理店名２");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getDrtenBnwari2(), "", "代理店分割割合２");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getMsgOutKbn(), "2", "MSG出力区分");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHosyouIkkatuMinaokeiyakuHyouji(), "0", "保障一括見直契約表示");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHhknnmkn(), "ﾋﾎｹﾝｼｶﾅ", "被保険者氏名(ｶﾅ)");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHokenryouSyuunouJyoukyou(), "－", "保険料収納状況");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getJikaiHokenryouJyuutouYm(), "－", "次回保険料充当年月");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getMdhansybetuKbn(), "01", "窓販種別区分");
    }
    @Test
    @TestOrder(740)
    public void testExec_A74() {
        changeSystemDate();

        MockObjectManager.initialize();
        BzGetProcessSummaryMockForHozen.SYORIPTN = BzGetProcessSummaryMockForHozen.TESTPATTERN2;
        HanteiKhSisuurendoTmttknJyoutaiMockForHozen.SYORIPTN = HanteiKhSisuurendoTmttknJyoutaiMockForHozen.TESTPATTERN2;

        WebKykNaiyouSyoukaiInfoBean webKykNaiyouSyoukaiInfoBean =
            hbKeiyakuSyoukai.exec("31809111567", BizDate.valueOf("20200930"), C_TanmatuSiyouKbn.SOUGOU_IPPAN,"A10010");

        exStringEquals(webKykNaiyouSyoukaiInfoBean.getErrorKbn(), "1", "エラー区分");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getErrorMsg(), "選択されたご契約については手続き中のためご照会できません。", "エラーメッセージ");
        CheckEebKykNaiyouSyoukaiInfoBean(webKykNaiyouSyoukaiInfoBean);

        HanteiTmttknJyoutaiBean hanteiTmttknJyoutaiBean = (HanteiTmttknJyoutaiBean) MockObjectManager.getArgument(HanteiKhSisuurendoTmttknJyoutaiMockForHozen.class, "execChokuzenOutouymTmttknHantei", 0, 0);

        exDateEquals(hanteiTmttknJyoutaiBean.getHanteiKijyunymd(), BizDate.getSysDate(), "判定基準日");
        exStringEquals(hanteiTmttknJyoutaiBean.getSyono(),         "31809111567", "証券番号");
        exDateEquals(hanteiTmttknJyoutaiBean.getKykymd(), BizDate.valueOf("20200901"), "契約日");
    }
    @Test
    @TestOrder(750)
    public void testExec_A75() {
        changeSystemDate();

        MockObjectManager.initialize();
        BzGetProcessSummaryMockForHozen.SYORIPTN = BzGetProcessSummaryMockForHozen.TESTPATTERN2;
        BzGetAdrDataMockForHozen.SYORIPTN = BzGetAdrDataMockForHozen.TESTPATTERN1;
        CalcHkShrKngkMockForHozen.SYORIPTN = CalcHkShrKngkMockForHozen.TESTPATTERN4;
        KeisanWExtMockForHozen.SYORIPTN = KeisanWExtMockForHozen.TESTPATTERN2;
        KeisanWMockForHozen.SYORIPTN = KeisanWMockForHozen.TESTPATTERN1;
        KeisanKijyungkMockForHozen.SYORIPTN = KeisanKijyungkMockForHozen.TESTPATTERN2;
        KeisanGaikakanzanMockForHozen.SYORIPTN = KeisanGaikakanzanMockForHozen.TESTPATTERN1;
        SetNenreiMockForHozen.SYORIPTN = SetNenreiMockForHozen.TESTPATTERN1;
        HanteiKhSisuurendoTmttknJyoutaiMockForHozen.SYORIPTN = HanteiKhSisuurendoTmttknJyoutaiMockForHozen.TESTPATTERN1;

        WebKykNaiyouSyoukaiInfoBean webKykNaiyouSyoukaiInfoBean =
            hbKeiyakuSyoukai.exec("31809111578", BizDate.valueOf("20200930"), C_TanmatuSiyouKbn.SOUGOU_IPPAN,"A10010");

        exStringEquals(webKykNaiyouSyoukaiInfoBean.getErrorKbn(), "", "エラー区分");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getErrorMsg(), "", "エラーメッセージ");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getSyouhnnm(), "５年ごと利差配当付指定通貨建個人年金保険（一時払い）（２０）　たのしみグローバルⅡ（指数連動プラン）", "商品名");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getSyurui(), "年金保険", "種類");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getSyono(), "31809111578", "証券番号");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getKykymd(), "令和　２年　９月　１日", "契約日");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHosyouNaiyou3(), "定率増加部分繰り入れ割合　１００％", "保障内容３");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHosyouNaiyou6(), "積立利率　２．４％", "保障内容６");
    }

    @Test
    @TestOrder(760)
    public void testExec_A76() {
        BizDate syoriymd = BizDate.valueOf("20221021");

        changeSystemDate(syoriymd);

        MockObjectManager.initialize();
        BzGetProcessSummaryMockForHozen.SYORIPTN = BzGetProcessSummaryMockForHozen.TESTPATTERN4;
        BzGetAdrDataMockForHozen.SYORIPTN = null;
        CalcHkShrKngkMockForHozen.SYORIPTN = null;
        KeisanWExtMockForHozen.SYORIPTN = null;
        KeisanWMockForHozen.SYORIPTN = null;
        KeisanKijyungkMockForHozen.SYORIPTN = null;
        KeisanGaikakanzanMockForHozen.SYORIPTN = null;
        SetNenreiMockForHozen.SYORIPTN = null;

        WebKykNaiyouSyoukaiInfoBean webKykNaiyouSyoukaiInfoBean =
            hbKeiyakuSyoukai.exec("99806040206", syoriymd, C_TanmatuSiyouKbn.SOUGOU_IPPAN,"A10010");

        displayContents(webKykNaiyouSyoukaiInfoBean);

        exStringEquals(webKykNaiyouSyoukaiInfoBean.getErrorKbn(), "", "エラー区分");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getErrorMsg(), "", "エラーメッセージ");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getKyknmkn(), "ｺﾂｳｹｲﾒｲﾖﾝﾉｲﾁ ﾃｽﾄｲﾁ", "契約者名（カナ）");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getKyknmkj(), "顧通契名４０１　テスト１２３４　様", "契約者名（漢字）");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getKykseiymd(), "昭和５０年　１月　１日", "契約者生年月日");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getKojinhjnKbn(), "個人", "個人法人区分");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTelno(), "090-1111-1111", "電話番号");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getPostalCd(), "１００－０００１", "郵便番号");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getAdr(), "東京都千代田区千代田１－１－１", "住所");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getAdrkn(), "", "住所(ｶﾅ)");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHhknnm(), "顧通被名４０１　テスト１２３４　様", "被保険者氏名");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHhknsei(), "女性", "被保険者性別");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHhknseiymd(), "昭和４９年　１月　１日", "被保険者生年月日");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHhknNen(), "４８歳", "被保険者年齢");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHhknKykjiNen(), "４６歳", "被保険者契約時年齢");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getSyouhnnm(), "笑顔の約束Ⅱ", "商品名");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getSyurui(), "終身保険", "種類");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getSyono(), "99806040206", "証券番号");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getCifCd(), "*****", "CIFｺｰﾄﾞ");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getKykymd(), "令和　２年　９月１０日", "契約日");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHrkhou(), "一時払", "払込方法");
        exBizCalcbleEquals(webKykNaiyouSyoukaiInfoBean.getSibous(), BizCurrency.valueOf(0, BizCurrencyTypes.YEN), "死亡保険金");
        exBizCalcbleEquals(webKykNaiyouSyoukaiInfoBean.getHrkp(), BizCurrency.valueOf(0, BizCurrencyTypes.YEN), "払込保険料");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getNkShrStartYmd(), "", "年金支払開始日");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getNenkinHosyouYear(), "", "年金保証年");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getNenkinKbn(), "", "年金区分");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHaitouKbn(), "準有配当", "配当区分");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getSinsaKbn(), "告知書扱", "診査区分");
        exNumericEquals(webKykNaiyouSyoukaiInfoBean.getTksuu(), 1, "特約数");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getLivingneedsTkhyj(), "", "リビングニーズ特約表示");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHokenMankiDay(), "終身", "保険満期日");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getSyunm(), "終身保険", "主契約名称");
        exBizCalcbleEquals(webKykNaiyouSyoukaiInfoBean.getSyus(), BizCurrency.valueOf(144066921, BizCurrencyTypes.YEN), "主契約保険金額");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getSyuhknkkn(), "終身", "主契約保険期間");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getSyuhrkkkn(), "", "主契約払込期間");
        exNumericEquals(webKykNaiyouSyoukaiInfoBean.getTkNaiyouGyousuu(), 1, "特約内容行数");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTknm1(), "被保険者代理特約", "特約名称１");
        exBizCalcbleEquals(webKykNaiyouSyoukaiInfoBean.getTks1(), BizCurrency.optional(), "特約保険金額１");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTokuyakuhokenkikan1(), "", "特約保険期間１");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTokuyakuharaikomikikan1(), "", "特約払込期間１");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTknm2(), "", "特約名称２");
        exBizCalcbleEquals(webKykNaiyouSyoukaiInfoBean.getTks2(), BizCurrency.optional(), "特約保険金額２");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTokuyakuhokenkikan2(), "", "特約保険期間２");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTokuyakuharaikomikikan2(), "", "特約払込期間２");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTknm3(), "", "特約名称３");
        exBizCalcbleEquals(webKykNaiyouSyoukaiInfoBean.getTks3(), BizCurrency.optional(), "特約保険金額３");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTokuyakuhokenkikan3(), "", "特約保険期間３");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTokuyakuharaikomikikan3(), "", "特約払込期間３");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTknm4(), "", "特約名称４");
        exBizCalcbleEquals(webKykNaiyouSyoukaiInfoBean.getTks4(), BizCurrency.optional(), "特約保険金額４");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTokuyakuhokenkikan4(), "", "特約保険期間４");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTokuyakuharaikomikikan4(), "", "特約払込期間４");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTknm5(), "", "特約名称５");
        exBizCalcbleEquals(webKykNaiyouSyoukaiInfoBean.getTks5(), BizCurrency.optional(), "特約保険金額５");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTokuyakuhokenkikan5(), "", "特約保険期間５");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTokuyakuharaikomikikan5(), "", "特約払込期間５");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTknm6(), "", "特約名称６");
        exBizCalcbleEquals(webKykNaiyouSyoukaiInfoBean.getTks6(), BizCurrency.optional(), "特約保険金額６");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTokuyakuhokenkikan6(), "", "特約保険期間６");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTokuyakuharaikomikikan6(), "", "特約払込期間６");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTknm7(), "", "特約名称７");
        exBizCalcbleEquals(webKykNaiyouSyoukaiInfoBean.getTks7(), BizCurrency.optional(), "特約保険金額７");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTokuyakuhokenkikan7(), "", "特約保険期間７");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTokuyakuharaikomikikan7(), "", "特約払込期間７");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTknm8(), "", "特約名称８");
        exBizCalcbleEquals(webKykNaiyouSyoukaiInfoBean.getTks8(), BizCurrency.optional(), "特約保険金額８");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTokuyakuhokenkikan8(), "", "特約保険期間８");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTokuyakuharaikomikikan8(), "", "特約払込期間８");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTknm9(), "", "特約名称９");
        exBizCalcbleEquals(webKykNaiyouSyoukaiInfoBean.getTks9(), BizCurrency.optional(), "特約保険金額９");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTokuyakuhokenkikan9(), "", "特約保険期間９");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTokuyakuharaikomikikan9(), "", "特約払込期間９");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTknm10(), "", "特約名称１０");
        exBizCalcbleEquals(webKykNaiyouSyoukaiInfoBean.getTks10(), BizCurrency.optional(), "特約保険金額１０");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTokuyakuhokenkikan10(), "", "特約保険期間１０");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTokuyakuharaikomikikan10(), "", "特約払込期間１０");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTknm11(), "", "特約名称１１");
        exBizCalcbleEquals(webKykNaiyouSyoukaiInfoBean.getTks11(), BizCurrency.optional(), "特約保険金額１１");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTokuyakuhokenkikan11(), "", "特約保険期間１１");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTokuyakuharaikomikikan11(), "", "特約払込期間１１");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTknm12(), "", "特約名称１２");
        exBizCalcbleEquals(webKykNaiyouSyoukaiInfoBean.getTks12(), BizCurrency.optional(), "特約保険金額１２");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTokuyakuhokenkikan12(), "", "特約保険期間１２");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTokuyakuharaikomikikan12(), "", "特約払込期間１２");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTknm13(), "", "特約名称１３");
        exBizCalcbleEquals(webKykNaiyouSyoukaiInfoBean.getTks13(), BizCurrency.optional(), "特約保険金額１３");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTokuyakuhokenkikan13(), "", "特約保険期間１３");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTokuyakuharaikomikikan13(), "", "特約払込期間１３");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTknm14(), "", "特約名称１４");
        exBizCalcbleEquals(webKykNaiyouSyoukaiInfoBean.getTks14(), BizCurrency.optional(), "特約保険金額１４");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTokuyakuhokenkikan14(), "", "特約保険期間１４");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTokuyakuharaikomikikan14(), "", "特約払込期間１４");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTknm15(), "", "特約名称１５");
        exBizCalcbleEquals(webKykNaiyouSyoukaiInfoBean.getTks15(), BizCurrency.optional(), "特約保険金額１５");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTokuyakuhokenkikan15(), "", "特約保険期間１５");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTokuyakuharaikomikikan15(), "", "特約払込期間１５");
        exNumericEquals(webKykNaiyouSyoukaiInfoBean.getSyouhnNaiyouGyousuu(), 1, "商品内容行数");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getSyouhnNaiyou1(), "現在の保障内容は下記のとおりです。", "商品内容１");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getSyouhnNaiyou2(), "", "商品内容２");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getSyouhnNaiyou3(), "", "商品内容３");
        exNumericEquals(webKykNaiyouSyoukaiInfoBean.getHosyouNaiyouGyousuu(),11, "保障内容行数");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHosyouNaiyou1(), "令和　４年１０月２０日　請求により円建終身保険に変更済", "保障内容１");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHosyouNaiyou2(), "　　　　　　　　　　　　到達金額　　　　　１４４，０６６，９２１円", "保障内容２");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHosyouNaiyou3(), "死亡時支払金受取人　契約者　様", "保障内容３");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHosyouNaiyou4(), "被保険者代理人　　　顧通契名４０１　テスト１２３４　様　　　　　生年月日　昭和５０年　１月　１日", "保障内容４");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHosyouNaiyou5(), "契約加入時しおり約款検索コード　０１－２００４－２７６１", "保障内容５");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHosyouNaiyou6(), "約款受領方法　Ｗｅｂでの受取り（インターネット環境で確認）", "保障内容６");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHosyouNaiyou7(), "積立利率　０．０５％", "保障内容７");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHosyouNaiyou8(), "積立金額（照会日時点）　１４４，０６６，９２１円", "保障内容８");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHosyouNaiyou9(), "　※死亡保険金額（照会日時点）、解約返戻金額（照会日時点）も同額になります。", "保障内容９");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHosyouNaiyou10(), "保険法対応契約", "保障内容１０");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHosyouNaiyou11(), "被保険者代理特約あり", "保障内容１１");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHosyouNaiyou12(), "", "保障内容１２");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHosyouNaiyou13(), "", "保障内容１３");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHosyouNaiyou14(), "", "保障内容１４");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHosyouNaiyou15(), "", "保障内容１５");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHosyouNaiyou16(), "", "保障内容１６");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHosyouNaiyou17(), "", "保障内容１７");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHosyouNaiyou18(), "", "保障内容１８");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHosyouNaiyou19(), "", "保障内容１９");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHosyouNaiyou20(), "", "保障内容２０");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHosyouNaiyou21(), "", "保障内容２１");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHosyouNaiyou22(), "", "保障内容２２");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHosyouNaiyou23(), "", "保障内容２３");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHosyouNaiyou24(), "", "保障内容２４");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHosyouNaiyou25(), "", "保障内容２５");
        exNumericEquals(webKykNaiyouSyoukaiInfoBean.getHenkouKeiiGyousuu(), 1, "変更経緯行数");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHenkouKeii1(), "令和　４年１０月１９日　契約内容変更", "変更経緯１");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHenkouKeii2(), "", "変更経緯２");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHenkouKeii3(), "", "変更経緯３");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHenkouKeii4(), "", "変更経緯４");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHenkouKeii5(), "", "変更経緯５");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHenkouKeii6(), "", "変更経緯６");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHenkouKeii7(), "", "変更経緯７");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHenkouKeii8(), "", "変更経緯８");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHenkouKeii9(), "", "変更経緯９");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHenkouKeii10(), "", "変更経緯１０");
        exNumericEquals(webKykNaiyouSyoukaiInfoBean.getBosyuDrtenGyousuu(), 1, "募集代理店行数");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getBosyuDrtenNm1(), "取扱代理店名３", "募集代理店名１");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getDrtenBnwari1(), "", "代理店分割割合１");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getBosyuDrtenNm2(), "", "募集代理店名２");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getDrtenBnwari2(), "", "代理店分割割合２");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getMsgOutKbn(), "2", "MSG出力区分");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHosyouIkkatuMinaokeiyakuHyouji(), "0", "保障一括見直契約表示");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHhknnmkn(), "ｺﾂｳﾋﾒｲﾖﾝﾉｲﾁ ﾃｽﾄｲﾁﾆ", "被保険者氏名(ｶﾅ)");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHokenryouSyuunouJyoukyou(), "－", "保険料収納状況");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getJikaiHokenryouJyuutouYm(), "－", "次回保険料充当年月");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getMdhansybetuKbn(), "01", "窓販種別区分");
    }

    @Test
    @TestOrder(770)
    public void testExec_A77() {
        BizDate syoriymd = BizDate.valueOf("20221021");

        changeSystemDate(syoriymd);

        MockObjectManager.initialize();
        BzGetProcessSummaryMockForHozen.SYORIPTN = BzGetProcessSummaryMockForHozen.TESTPATTERN4;
        BzGetAdrDataMockForHozen.SYORIPTN = null;
        CalcHkShrKngkMockForHozen.SYORIPTN = null;
        KeisanWExtMockForHozen.SYORIPTN = null;
        KeisanWMockForHozen.SYORIPTN = null;
        KeisanKijyungkMockForHozen.SYORIPTN = null;
        KeisanGaikakanzanMockForHozen.SYORIPTN = null;
        SetNenreiMockForHozen.SYORIPTN = null;

        WebKykNaiyouSyoukaiInfoBean webKykNaiyouSyoukaiInfoBean =
            hbKeiyakuSyoukai.exec("99806040262", syoriymd, C_TanmatuSiyouKbn.SOUGOU_IPPAN,"A10010");

        displayContents(webKykNaiyouSyoukaiInfoBean);

        exStringEquals(webKykNaiyouSyoukaiInfoBean.getErrorKbn(), "", "エラー区分");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getErrorMsg(), "", "エラーメッセージ");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getKyknmkn(), "ｺﾂｳｹｲﾒｲﾖﾝﾉﾖﾝ ﾃｽﾄｲﾁ", "契約者名（カナ）");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getKyknmkj(), "顧通契名４０４　テスト１２３４　様", "契約者名（漢字）");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getKykseiymd(), "昭和５０年　１月　１日", "契約者生年月日");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getKojinhjnKbn(), "個人", "個人法人区分");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTelno(), "090-1111-1111", "電話番号");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getPostalCd(), "１００－０００１", "郵便番号");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getAdr(), "東京都千代田区千代田１－１－１", "住所");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getAdrkn(), "", "住所(ｶﾅ)");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHhknnm(), "顧通被名４０４　テスト１２３４　様", "被保険者氏名");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHhknsei(), "女性", "被保険者性別");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHhknseiymd(), "昭和４９年　１月　１日", "被保険者生年月日");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHhknNen(), "４８歳", "被保険者年齢");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHhknKykjiNen(), "４６歳", "被保険者契約時年齢");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getSyouhnnm(), "５年ごと利差配当付指定通貨建終身保険（一時払い）（１９）Ⅱ型　ふるはーとＪロードグローバルⅡ", "商品名");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getSyurui(), "終身保険", "種類");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getSyono(), "99806040262", "証券番号");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getCifCd(), "*****", "CIFｺｰﾄﾞ");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getKykymd(), "令和　２年　９月１０日", "契約日");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHrkhou(), "一時払", "払込方法");
        exBizCalcbleEquals(webKykNaiyouSyoukaiInfoBean.getSibous(), BizCurrency.valueOf(0, BizCurrencyTypes.YEN), "死亡保険金");
        exBizCalcbleEquals(webKykNaiyouSyoukaiInfoBean.getHrkp(), BizCurrency.valueOf(0, BizCurrencyTypes.YEN), "払込保険料");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getNkShrStartYmd(), "", "年金支払開始日");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getNenkinHosyouYear(), "", "年金保証年");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getNenkinKbn(), "", "年金区分");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHaitouKbn(), "準有配当", "配当区分");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getSinsaKbn(), "告知書扱", "診査区分");
        exNumericEquals(webKykNaiyouSyoukaiInfoBean.getTksuu(), 3, "特約数");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getLivingneedsTkhyj(), "", "リビングニーズ特約表示");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHokenMankiDay(), "終身", "保険満期日");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getSyunm(), "終身保険", "主契約名称");
        exBizCalcbleEquals(webKykNaiyouSyoukaiInfoBean.getSyus(), BizCurrency.valueOf(145232346, BizCurrencyTypes.YEN), "主契約保険金額");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getSyuhknkkn(), "終身", "主契約保険期間");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getSyuhrkkkn(), "", "主契約払込期間");
        exNumericEquals(webKykNaiyouSyoukaiInfoBean.getTkNaiyouGyousuu(), 3, "特約内容行数");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTknm1(), "保険料指定外通貨払込特約", "特約名称１");
        exBizCalcbleEquals(webKykNaiyouSyoukaiInfoBean.getTks1(), BizCurrency.optional(), "特約保険金額１");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTokuyakuhokenkikan1(), "", "特約保険期間１");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTokuyakuharaikomikikan1(), "", "特約払込期間１");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTknm2(), "保険契約者代理特約", "特約名称２");
        exBizCalcbleEquals(webKykNaiyouSyoukaiInfoBean.getTks2(), BizCurrency.optional(), "特約保険金額２");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTokuyakuhokenkikan2(), "", "特約保険期間２");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTokuyakuharaikomikikan2(), "", "特約払込期間２");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTknm3(), "被保険者代理特約", "特約名称３");
        exBizCalcbleEquals(webKykNaiyouSyoukaiInfoBean.getTks3(), BizCurrency.optional(), "特約保険金額３");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTokuyakuhokenkikan3(), "", "特約保険期間３");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTokuyakuharaikomikikan3(), "", "特約払込期間３");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTknm4(), "", "特約名称４");
        exBizCalcbleEquals(webKykNaiyouSyoukaiInfoBean.getTks4(), BizCurrency.optional(), "特約保険金額４");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTokuyakuhokenkikan4(), "", "特約保険期間４");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTokuyakuharaikomikikan4(), "", "特約払込期間４");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTknm5(), "", "特約名称５");
        exBizCalcbleEquals(webKykNaiyouSyoukaiInfoBean.getTks5(), BizCurrency.optional(), "特約保険金額５");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTokuyakuhokenkikan5(), "", "特約保険期間５");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTokuyakuharaikomikikan5(), "", "特約払込期間５");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTknm6(), "", "特約名称６");
        exBizCalcbleEquals(webKykNaiyouSyoukaiInfoBean.getTks6(), BizCurrency.optional(), "特約保険金額６");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTokuyakuhokenkikan6(), "", "特約保険期間６");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTokuyakuharaikomikikan6(), "", "特約払込期間６");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTknm7(), "", "特約名称７");
        exBizCalcbleEquals(webKykNaiyouSyoukaiInfoBean.getTks7(), BizCurrency.optional(), "特約保険金額７");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTokuyakuhokenkikan7(), "", "特約保険期間７");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTokuyakuharaikomikikan7(), "", "特約払込期間７");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTknm8(), "", "特約名称８");
        exBizCalcbleEquals(webKykNaiyouSyoukaiInfoBean.getTks8(), BizCurrency.optional(), "特約保険金額８");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTokuyakuhokenkikan8(), "", "特約保険期間８");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTokuyakuharaikomikikan8(), "", "特約払込期間８");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTknm9(), "", "特約名称９");
        exBizCalcbleEquals(webKykNaiyouSyoukaiInfoBean.getTks9(), BizCurrency.optional(), "特約保険金額９");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTokuyakuhokenkikan9(), "", "特約保険期間９");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTokuyakuharaikomikikan9(), "", "特約払込期間９");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTknm10(), "", "特約名称１０");
        exBizCalcbleEquals(webKykNaiyouSyoukaiInfoBean.getTks10(), BizCurrency.optional(), "特約保険金額１０");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTokuyakuhokenkikan10(), "", "特約保険期間１０");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTokuyakuharaikomikikan10(), "", "特約払込期間１０");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTknm11(), "", "特約名称１１");
        exBizCalcbleEquals(webKykNaiyouSyoukaiInfoBean.getTks11(), BizCurrency.optional(), "特約保険金額１１");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTokuyakuhokenkikan11(), "", "特約保険期間１１");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTokuyakuharaikomikikan11(), "", "特約払込期間１１");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTknm12(), "", "特約名称１２");
        exBizCalcbleEquals(webKykNaiyouSyoukaiInfoBean.getTks12(), BizCurrency.optional(), "特約保険金額１２");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTokuyakuhokenkikan12(), "", "特約保険期間１２");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTokuyakuharaikomikikan12(), "", "特約払込期間１２");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTknm13(), "", "特約名称１３");
        exBizCalcbleEquals(webKykNaiyouSyoukaiInfoBean.getTks13(), BizCurrency.optional(), "特約保険金額１３");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTokuyakuhokenkikan13(), "", "特約保険期間１３");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTokuyakuharaikomikikan13(), "", "特約払込期間１３");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTknm14(), "", "特約名称１４");
        exBizCalcbleEquals(webKykNaiyouSyoukaiInfoBean.getTks14(), BizCurrency.optional(), "特約保険金額１４");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTokuyakuhokenkikan14(), "", "特約保険期間１４");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTokuyakuharaikomikikan14(), "", "特約払込期間１４");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTknm15(), "", "特約名称１５");
        exBizCalcbleEquals(webKykNaiyouSyoukaiInfoBean.getTks15(), BizCurrency.optional(), "特約保険金額１５");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTokuyakuhokenkikan15(), "", "特約保険期間１５");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getTokuyakuharaikomikikan15(), "", "特約払込期間１５");
        exNumericEquals(webKykNaiyouSyoukaiInfoBean.getSyouhnNaiyouGyousuu(), 1, "商品内容行数");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getSyouhnNaiyou1(), "現在の保障内容は下記のとおりです。", "商品内容１");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getSyouhnNaiyou2(), "", "商品内容２");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getSyouhnNaiyou3(), "", "商品内容３");
        exNumericEquals(webKykNaiyouSyoukaiInfoBean.getHosyouNaiyouGyousuu(),15, "保障内容行数");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHosyouNaiyou1(), "令和　４年１０月２０日　目標到達（目標値：１１０％）により円建終身保険に変更済", "保障内容１");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHosyouNaiyou2(), "　　　　　　　　　　　　到達金額　　　　　１４５，２３２，３４６円", "保障内容２");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHosyouNaiyou3(), "死亡時支払金受取人　複数", "保障内容３");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHosyouNaiyou4(), "契約者代理人　　　　顧通契代名４０４　テスト１２３　様　　　　　生年月日　昭和５０年　４月　４日", "保障内容４");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHosyouNaiyou5(), "被保険者代理人　　　顧通１家族名４０４　テスト１２　様　　　　　生年月日　平成１０年　１月　１日", "保障内容５");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHosyouNaiyou6(), "登録家族（１人目）　顧通１家族名４０４　テスト１２　様　　　　　生年月日　平成１０年　１月　１日", "保障内容６");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHosyouNaiyou7(), "登録家族（２人目）　顧通２家族名４０４　テスト１２　様　　　　　生年月日　平成１０年　２月　２日", "保障内容７");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHosyouNaiyou8(), "契約加入時しおり約款検索コード　０１－２００４－２４６３", "保障内容８");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHosyouNaiyou9(), "約款受領方法　Ｗｅｂでの受取り（インターネット環境で確認）", "保障内容９");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHosyouNaiyou10(), "積立利率　０．０５％", "保障内容１０");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHosyouNaiyou11(), "積立金額（照会日時点）　１４５，２３２，３４６円", "保障内容１１");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHosyouNaiyou12(), "　※死亡保険金額（照会日時点）、解約返戻金額（照会日時点）も同額になります。", "保障内容１２");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHosyouNaiyou13(), "保険法対応契約", "保障内容１３");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHosyouNaiyou14(), "保険契約者代理特約あり", "保障内容１４");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHosyouNaiyou15(), "被保険者代理特約あり", "保障内容１５");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHosyouNaiyou16(), "", "保障内容１６");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHosyouNaiyou17(), "", "保障内容１７");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHosyouNaiyou18(), "", "保障内容１８");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHosyouNaiyou19(), "", "保障内容１９");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHosyouNaiyou20(), "", "保障内容２０");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHosyouNaiyou21(), "", "保障内容２１");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHosyouNaiyou22(), "", "保障内容２２");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHosyouNaiyou23(), "", "保障内容２３");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHosyouNaiyou24(), "", "保障内容２４");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHosyouNaiyou25(), "", "保障内容２５");
        exNumericEquals(webKykNaiyouSyoukaiInfoBean.getHenkouKeiiGyousuu(), 1, "変更経緯行数");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHenkouKeii1(), "令和　４年１０月１９日　契約内容変更", "変更経緯１");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHenkouKeii2(), "", "変更経緯２");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHenkouKeii3(), "", "変更経緯３");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHenkouKeii4(), "", "変更経緯４");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHenkouKeii5(), "", "変更経緯５");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHenkouKeii6(), "", "変更経緯６");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHenkouKeii7(), "", "変更経緯７");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHenkouKeii8(), "", "変更経緯８");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHenkouKeii9(), "", "変更経緯９");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHenkouKeii10(), "", "変更経緯１０");
        exNumericEquals(webKykNaiyouSyoukaiInfoBean.getBosyuDrtenGyousuu(), 1, "募集代理店行数");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getBosyuDrtenNm1(), "取扱代理店名３", "募集代理店名１");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getDrtenBnwari1(), "", "代理店分割割合１");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getBosyuDrtenNm2(), "", "募集代理店名２");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getDrtenBnwari2(), "", "代理店分割割合２");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getMsgOutKbn(), "2", "MSG出力区分");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHosyouIkkatuMinaokeiyakuHyouji(), "0", "保障一括見直契約表示");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHhknnmkn(), "ｺﾂｳﾋﾒｲﾖﾝﾉﾖﾝ ﾃｽﾄｲﾁﾆ", "被保険者氏名(ｶﾅ)");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getHokenryouSyuunouJyoukyou(), "－", "保険料収納状況");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getJikaiHokenryouJyuutouYm(), "－", "次回保険料充当年月");
        exStringEquals(webKykNaiyouSyoukaiInfoBean.getMdhansybetuKbn(), "01", "窓販種別区分");
    }

    private void changeSystemDate() {
        changeSystemDate(BizDate.valueOf(2019, 10, 29));
    }

    private void displayContents(WebKykNaiyouSyoukaiInfoBean webKykNaiyouSyoukaiInfoBean) {
        logger.debug("▼ 結果ログ出力");
        logger.debug("│ ★エラー区分 = {}", webKykNaiyouSyoukaiInfoBean.getErrorKbn());
        logger.debug("│ ★エラーメッセージ = {}", webKykNaiyouSyoukaiInfoBean.getErrorMsg());
        logger.debug("│ ★契約者名（カナ） = {}", webKykNaiyouSyoukaiInfoBean.getKyknmkn());
        logger.debug("│ ★契約者名（漢字） = {}", webKykNaiyouSyoukaiInfoBean.getKyknmkj());
        logger.debug("│ ★契約者生年月日 = {}", webKykNaiyouSyoukaiInfoBean.getKykseiymd());
        logger.debug("│ ★個人法人区分 = {}", webKykNaiyouSyoukaiInfoBean.getKojinhjnKbn());
        logger.debug("│ ★電話番号 = {}", webKykNaiyouSyoukaiInfoBean.getTelno());
        logger.debug("│ ★郵便番号 = {}", webKykNaiyouSyoukaiInfoBean.getPostalCd());
        logger.debug("│ ★住所 = {}", webKykNaiyouSyoukaiInfoBean.getAdr());
        logger.debug("│ ★住所(ｶﾅ) = {}", webKykNaiyouSyoukaiInfoBean.getAdrkn());
        logger.debug("│ ★被保険者氏名 = {}", webKykNaiyouSyoukaiInfoBean.getHhknnm());
        logger.debug("│ ★被保険者性別 = {}", webKykNaiyouSyoukaiInfoBean.getHhknsei());
        logger.debug("│ ★被保険者生年月日 = {}", webKykNaiyouSyoukaiInfoBean.getHhknseiymd());
        logger.debug("│ ★被保険者年齢 = {}", webKykNaiyouSyoukaiInfoBean.getHhknNen());
        logger.debug("│ ★被保険者契約時年齢 = {}", webKykNaiyouSyoukaiInfoBean.getHhknKykjiNen());
        logger.debug("│ ★商品名 = {}", webKykNaiyouSyoukaiInfoBean.getSyouhnnm());
        logger.debug("│ ★種類 = {}", webKykNaiyouSyoukaiInfoBean.getSyurui());
        logger.debug("│ ★証券番号 = {}", webKykNaiyouSyoukaiInfoBean.getSyono());
        logger.debug("│ ★CIFｺｰﾄﾞ = {}", webKykNaiyouSyoukaiInfoBean.getCifCd());
        logger.debug("│ ★契約日 = {}", webKykNaiyouSyoukaiInfoBean.getKykymd());
        logger.debug("│ ★払込方法 = {}", webKykNaiyouSyoukaiInfoBean.getHrkhou());
        logger.debug("│ ★死亡保険金 = {}{}", webKykNaiyouSyoukaiInfoBean.getSibous(), webKykNaiyouSyoukaiInfoBean.getSibous().getType());
        logger.debug("│ ★払込保険料 = {}{}", webKykNaiyouSyoukaiInfoBean.getHrkp(),webKykNaiyouSyoukaiInfoBean.getHrkp().getType());
        logger.debug("│ ★年金支払開始日 = {}", webKykNaiyouSyoukaiInfoBean.getNkShrStartYmd());
        logger.debug("│ ★年金保証年 = {}", webKykNaiyouSyoukaiInfoBean.getNenkinHosyouYear());
        logger.debug("│ ★年金区分 = {}", webKykNaiyouSyoukaiInfoBean.getNenkinKbn());
        logger.debug("│ ★配当区分 = {}", webKykNaiyouSyoukaiInfoBean.getHaitouKbn());
        logger.debug("│ ★診査区分 = {}", webKykNaiyouSyoukaiInfoBean.getSinsaKbn());
        logger.debug("│ ★特約数 = {}", webKykNaiyouSyoukaiInfoBean.getTksuu());
        logger.debug("│ ★リビングニーズ特約表示 = {}", webKykNaiyouSyoukaiInfoBean.getLivingneedsTkhyj());
        logger.debug("│ ★保険満期日 = {}", webKykNaiyouSyoukaiInfoBean.getHokenMankiDay());
        logger.debug("│ ★主契約名称 = {}", webKykNaiyouSyoukaiInfoBean.getSyunm());
        logger.debug("│ ★主契約保険金額 = {}{}", webKykNaiyouSyoukaiInfoBean.getSyus(),webKykNaiyouSyoukaiInfoBean.getSyus().getType());
        logger.debug("│ ★主契約保険期間 = {}", webKykNaiyouSyoukaiInfoBean.getSyuhknkkn());
        logger.debug("│ ★主契約払込期間 = {}", webKykNaiyouSyoukaiInfoBean.getSyuhrkkkn());
        logger.debug("│ ★特約内容行数 = {}", webKykNaiyouSyoukaiInfoBean.getTkNaiyouGyousuu());
        logger.debug("│ ★特約名称１ = {}", webKykNaiyouSyoukaiInfoBean.getTknm1());
        logger.debug("│ ★特約保険金額１ = {}{}", webKykNaiyouSyoukaiInfoBean.getTks1(),webKykNaiyouSyoukaiInfoBean.getTks1().getType());
        logger.debug("│ ★特約保険期間１ = {}", webKykNaiyouSyoukaiInfoBean.getTokuyakuhokenkikan1());
        logger.debug("│ ★特約払込期間１ = {}", webKykNaiyouSyoukaiInfoBean.getTokuyakuharaikomikikan1());
        logger.debug("│ ★特約名称２ = {}", webKykNaiyouSyoukaiInfoBean.getTknm2());
        logger.debug("│ ★特約保険金額２ = {}{}", webKykNaiyouSyoukaiInfoBean.getTks2(),webKykNaiyouSyoukaiInfoBean.getTks2().getType());
        logger.debug("│ ★特約保険期間２ = {}", webKykNaiyouSyoukaiInfoBean.getTokuyakuhokenkikan2());
        logger.debug("│ ★特約払込期間２ = {}", webKykNaiyouSyoukaiInfoBean.getTokuyakuharaikomikikan2());
        logger.debug("│ ★特約名称３ = {}", webKykNaiyouSyoukaiInfoBean.getTknm3());
        logger.debug("│ ★特約保険金額３ = {}{}", webKykNaiyouSyoukaiInfoBean.getTks3(),webKykNaiyouSyoukaiInfoBean.getTks3().getType());
        logger.debug("│ ★特約保険期間３ = {}", webKykNaiyouSyoukaiInfoBean.getTokuyakuhokenkikan3());
        logger.debug("│ ★特約払込期間３ = {}", webKykNaiyouSyoukaiInfoBean.getTokuyakuharaikomikikan3());
        logger.debug("│ ★特約名称４ = {}", webKykNaiyouSyoukaiInfoBean.getTknm4());
        logger.debug("│ ★特約保険金額４ = {}{}", webKykNaiyouSyoukaiInfoBean.getTks4(),webKykNaiyouSyoukaiInfoBean.getTks4().getType());
        logger.debug("│ ★特約保険期間４ = {}", webKykNaiyouSyoukaiInfoBean.getTokuyakuhokenkikan4());
        logger.debug("│ ★特約払込期間４ = {}", webKykNaiyouSyoukaiInfoBean.getTokuyakuharaikomikikan4());
        logger.debug("│ ★特約名称５ = {}", webKykNaiyouSyoukaiInfoBean.getTknm5());
        logger.debug("│ ★特約保険金額５ = {}{}", webKykNaiyouSyoukaiInfoBean.getTks5(),webKykNaiyouSyoukaiInfoBean.getTks5().getType());
        logger.debug("│ ★特約保険期間５ = {}", webKykNaiyouSyoukaiInfoBean.getTokuyakuhokenkikan5());
        logger.debug("│ ★特約払込期間５ = {}", webKykNaiyouSyoukaiInfoBean.getTokuyakuharaikomikikan5());
        logger.debug("│ ★特約名称６ = {}", webKykNaiyouSyoukaiInfoBean.getTknm6());
        logger.debug("│ ★特約保険金額６ = {}{}", webKykNaiyouSyoukaiInfoBean.getTks6(),webKykNaiyouSyoukaiInfoBean.getTks6().getType());
        logger.debug("│ ★特約保険期間６ = {}", webKykNaiyouSyoukaiInfoBean.getTokuyakuhokenkikan6());
        logger.debug("│ ★特約払込期間６ = {}", webKykNaiyouSyoukaiInfoBean.getTokuyakuharaikomikikan6());
        logger.debug("│ ★特約名称７ = {}", webKykNaiyouSyoukaiInfoBean.getTknm7());
        logger.debug("│ ★特約保険金額７ = {}{}", webKykNaiyouSyoukaiInfoBean.getTks7(),webKykNaiyouSyoukaiInfoBean.getTks7().getType());
        logger.debug("│ ★特約保険期間７ = {}", webKykNaiyouSyoukaiInfoBean.getTokuyakuhokenkikan7());
        logger.debug("│ ★特約払込期間７ = {}", webKykNaiyouSyoukaiInfoBean.getTokuyakuharaikomikikan7());
        logger.debug("│ ★特約名称８ = {}", webKykNaiyouSyoukaiInfoBean.getTknm8());
        logger.debug("│ ★特約保険金額８ = {}{}", webKykNaiyouSyoukaiInfoBean.getTks8(),webKykNaiyouSyoukaiInfoBean.getTks8().getType());
        logger.debug("│ ★特約保険期間８ = {}", webKykNaiyouSyoukaiInfoBean.getTokuyakuhokenkikan8());
        logger.debug("│ ★特約払込期間８ = {}", webKykNaiyouSyoukaiInfoBean.getTokuyakuharaikomikikan8());
        logger.debug("│ ★特約名称９ = {}", webKykNaiyouSyoukaiInfoBean.getTknm9());
        logger.debug("│ ★特約保険金額９ = {}{}", webKykNaiyouSyoukaiInfoBean.getTks9(),webKykNaiyouSyoukaiInfoBean.getTks9().getType());
        logger.debug("│ ★特約保険期間９ = {}", webKykNaiyouSyoukaiInfoBean.getTokuyakuhokenkikan9());
        logger.debug("│ ★特約払込期間９ = {}", webKykNaiyouSyoukaiInfoBean.getTokuyakuharaikomikikan9());
        logger.debug("│ ★特約名称１０ = {}", webKykNaiyouSyoukaiInfoBean.getTknm10());
        logger.debug("│ ★特約保険金額１０ = {}{}", webKykNaiyouSyoukaiInfoBean.getTks10(),webKykNaiyouSyoukaiInfoBean.getTks10().getType());
        logger.debug("│ ★特約保険期間１０ = {}", webKykNaiyouSyoukaiInfoBean.getTokuyakuhokenkikan10());
        logger.debug("│ ★特約払込期間１０ = {}", webKykNaiyouSyoukaiInfoBean.getTokuyakuharaikomikikan10());
        logger.debug("│ ★特約名称１１ = {}", webKykNaiyouSyoukaiInfoBean.getTknm11());
        logger.debug("│ ★特約保険金額１１ = {}{}", webKykNaiyouSyoukaiInfoBean.getTks11(),webKykNaiyouSyoukaiInfoBean.getTks11().getType());
        logger.debug("│ ★特約保険期間１１ = {}", webKykNaiyouSyoukaiInfoBean.getTokuyakuhokenkikan11());
        logger.debug("│ ★特約払込期間１１ = {}", webKykNaiyouSyoukaiInfoBean.getTokuyakuharaikomikikan11());
        logger.debug("│ ★特約名称１２ = {}", webKykNaiyouSyoukaiInfoBean.getTknm12());
        logger.debug("│ ★特約保険金額１２ = {}{}", webKykNaiyouSyoukaiInfoBean.getTks12(),webKykNaiyouSyoukaiInfoBean.getTks12().getType());
        logger.debug("│ ★特約保険期間１２ = {}", webKykNaiyouSyoukaiInfoBean.getTokuyakuhokenkikan12());
        logger.debug("│ ★特約払込期間１２ = {}", webKykNaiyouSyoukaiInfoBean.getTokuyakuharaikomikikan12());
        logger.debug("│ ★特約名称１３ = {}", webKykNaiyouSyoukaiInfoBean.getTknm13());
        logger.debug("│ ★特約保険金額１３ = {}{}", webKykNaiyouSyoukaiInfoBean.getTks13(),webKykNaiyouSyoukaiInfoBean.getTks13().getType());
        logger.debug("│ ★特約保険期間１３ = {}", webKykNaiyouSyoukaiInfoBean.getTokuyakuhokenkikan13());
        logger.debug("│ ★特約払込期間１３ = {}", webKykNaiyouSyoukaiInfoBean.getTokuyakuharaikomikikan13());
        logger.debug("│ ★特約名称１４ = {}", webKykNaiyouSyoukaiInfoBean.getTknm14());
        logger.debug("│ ★特約保険金額１４ = {}{}", webKykNaiyouSyoukaiInfoBean.getTks14(),webKykNaiyouSyoukaiInfoBean.getTks14().getType());
        logger.debug("│ ★特約保険期間１４ = {}", webKykNaiyouSyoukaiInfoBean.getTokuyakuhokenkikan14());
        logger.debug("│ ★特約払込期間１４ = {}", webKykNaiyouSyoukaiInfoBean.getTokuyakuharaikomikikan14());
        logger.debug("│ ★特約名称１５ = {}", webKykNaiyouSyoukaiInfoBean.getTknm15());
        logger.debug("│ ★特約保険金額１５ = {}{}", webKykNaiyouSyoukaiInfoBean.getTks15(),webKykNaiyouSyoukaiInfoBean.getTks15().getType());
        logger.debug("│ ★特約保険期間１５ = {}", webKykNaiyouSyoukaiInfoBean.getTokuyakuhokenkikan15());
        logger.debug("│ ★特約払込期間１５ = {}", webKykNaiyouSyoukaiInfoBean.getTokuyakuharaikomikikan15());
        logger.debug("│ ★商品内容行数 = {}", webKykNaiyouSyoukaiInfoBean.getSyouhnNaiyouGyousuu());
        logger.debug("│ ★商品内容１ = {}", webKykNaiyouSyoukaiInfoBean.getSyouhnNaiyou1());
        logger.debug("│ ★商品内容２ = {}", webKykNaiyouSyoukaiInfoBean.getSyouhnNaiyou2());
        logger.debug("│ ★商品内容３ = {}", webKykNaiyouSyoukaiInfoBean.getSyouhnNaiyou3());
        logger.debug("│ ★保障内容行数 = {}", webKykNaiyouSyoukaiInfoBean.getHosyouNaiyouGyousuu());
        logger.debug("│ ★保障内容１ = {}", webKykNaiyouSyoukaiInfoBean.getHosyouNaiyou1());
        logger.debug("│ ★保障内容２ = {}", webKykNaiyouSyoukaiInfoBean.getHosyouNaiyou2());
        logger.debug("│ ★保障内容３ = {}", webKykNaiyouSyoukaiInfoBean.getHosyouNaiyou3());
        logger.debug("│ ★保障内容４ = {}", webKykNaiyouSyoukaiInfoBean.getHosyouNaiyou4());
        logger.debug("│ ★保障内容５ = {}", webKykNaiyouSyoukaiInfoBean.getHosyouNaiyou5());
        logger.debug("│ ★保障内容６ = {}", webKykNaiyouSyoukaiInfoBean.getHosyouNaiyou6());
        logger.debug("│ ★保障内容７ = {}", webKykNaiyouSyoukaiInfoBean.getHosyouNaiyou7());
        logger.debug("│ ★保障内容８ = {}", webKykNaiyouSyoukaiInfoBean.getHosyouNaiyou8());
        logger.debug("│ ★保障内容９ = {}", webKykNaiyouSyoukaiInfoBean.getHosyouNaiyou9());
        logger.debug("│ ★保障内容１０ = {}", webKykNaiyouSyoukaiInfoBean.getHosyouNaiyou10());
        logger.debug("│ ★保障内容１１ = {}", webKykNaiyouSyoukaiInfoBean.getHosyouNaiyou11());
        logger.debug("│ ★保障内容１２ = {}", webKykNaiyouSyoukaiInfoBean.getHosyouNaiyou12());
        logger.debug("│ ★保障内容１３ = {}", webKykNaiyouSyoukaiInfoBean.getHosyouNaiyou13());
        logger.debug("│ ★保障内容１４ = {}", webKykNaiyouSyoukaiInfoBean.getHosyouNaiyou14());
        logger.debug("│ ★保障内容１５ = {}", webKykNaiyouSyoukaiInfoBean.getHosyouNaiyou15());
        logger.debug("│ ★保障内容１６ = {}", webKykNaiyouSyoukaiInfoBean.getHosyouNaiyou16());
        logger.debug("│ ★保障内容１７ = {}", webKykNaiyouSyoukaiInfoBean.getHosyouNaiyou17());
        logger.debug("│ ★保障内容１８ = {}", webKykNaiyouSyoukaiInfoBean.getHosyouNaiyou18());
        logger.debug("│ ★保障内容１９ = {}", webKykNaiyouSyoukaiInfoBean.getHosyouNaiyou19());
        logger.debug("│ ★保障内容２０ = {}", webKykNaiyouSyoukaiInfoBean.getHosyouNaiyou20());
        logger.debug("│ ★保障内容２１ = {}", webKykNaiyouSyoukaiInfoBean.getHosyouNaiyou21());
        logger.debug("│ ★保障内容２２ = {}", webKykNaiyouSyoukaiInfoBean.getHosyouNaiyou22());
        logger.debug("│ ★保障内容２３ = {}", webKykNaiyouSyoukaiInfoBean.getHosyouNaiyou23());
        logger.debug("│ ★保障内容２４ = {}", webKykNaiyouSyoukaiInfoBean.getHosyouNaiyou24());
        logger.debug("│ ★保障内容２５ = {}", webKykNaiyouSyoukaiInfoBean.getHosyouNaiyou25());
        logger.debug("│ ★変更経緯行数 = {}", webKykNaiyouSyoukaiInfoBean.getHenkouKeiiGyousuu());
        logger.debug("│ ★変更経緯１ = {}", webKykNaiyouSyoukaiInfoBean.getHenkouKeii1());
        logger.debug("│ ★変更経緯２ = {}", webKykNaiyouSyoukaiInfoBean.getHenkouKeii2());
        logger.debug("│ ★変更経緯３ = {}", webKykNaiyouSyoukaiInfoBean.getHenkouKeii3());
        logger.debug("│ ★変更経緯４ = {}", webKykNaiyouSyoukaiInfoBean.getHenkouKeii4());
        logger.debug("│ ★変更経緯５ = {}", webKykNaiyouSyoukaiInfoBean.getHenkouKeii5());
        logger.debug("│ ★変更経緯６ = {}", webKykNaiyouSyoukaiInfoBean.getHenkouKeii6());
        logger.debug("│ ★変更経緯７ = {}", webKykNaiyouSyoukaiInfoBean.getHenkouKeii7());
        logger.debug("│ ★変更経緯８ = {}", webKykNaiyouSyoukaiInfoBean.getHenkouKeii8());
        logger.debug("│ ★変更経緯９ = {}", webKykNaiyouSyoukaiInfoBean.getHenkouKeii9());
        logger.debug("│ ★変更経緯１０ = {}", webKykNaiyouSyoukaiInfoBean.getHenkouKeii10());
        logger.debug("│ ★募集代理店行数 = {}", webKykNaiyouSyoukaiInfoBean.getBosyuDrtenGyousuu());
        logger.debug("│ ★募集代理店名１ = {}", webKykNaiyouSyoukaiInfoBean.getBosyuDrtenNm1());
        logger.debug("│ ★代理店分割割合１ = {}", webKykNaiyouSyoukaiInfoBean.getDrtenBnwari1());
        logger.debug("│ ★募集代理店名２ = {}", webKykNaiyouSyoukaiInfoBean.getBosyuDrtenNm2());
        logger.debug("│ ★代理店分割割合２ = {}", webKykNaiyouSyoukaiInfoBean.getDrtenBnwari2());
        logger.debug("│ ★MSG出力区分 = {}", webKykNaiyouSyoukaiInfoBean.getMsgOutKbn());
        logger.debug("│ ★保障一括見直契約表示 = {}", webKykNaiyouSyoukaiInfoBean.getHosyouIkkatuMinaokeiyakuHyouji());
        logger.debug("│ ★被保険者氏名(ｶﾅ) = {}", webKykNaiyouSyoukaiInfoBean.getHhknnmkn());
        logger.debug("│ ★保険料収納状況 = {}", webKykNaiyouSyoukaiInfoBean.getHokenryouSyuunouJyoukyou());
        logger.debug("│ ★次回保険料充当年月 = {}", webKykNaiyouSyoukaiInfoBean.getJikaiHokenryouJyuutouYm());
        logger.debug("│ ★窓販種別区分 = {}", webKykNaiyouSyoukaiInfoBean.getMdhansybetuKbn());
        logger.debug("▲ 結果ログ出力");
    }
}
