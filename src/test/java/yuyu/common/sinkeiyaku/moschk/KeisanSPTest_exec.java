package yuyu.common.sinkeiyaku.moschk;

import static yuyu.testinfr.YuyuFunctionTestUtil.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.dgic.testing.common.virtualmock.MockObjectManager;
import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.number.BizCurrency;
import jp.co.slcs.swak.number.BizNumber;
import jp.co.slcs.swak.number.currencytype.BizCurrencyTypes;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.app.base.ref.TestDataMaker;
import yuyu.common.biz.bzcommon.KeisanGaikakanzanMockForSinkeiyaku;
import yuyu.common.biz.exception.CommonBizAppException;
import yuyu.common.hozen.ascommon.KeisanZennouNyuukinGk2;
import yuyu.common.hozen.ascommon.KeisanZennouNyuukinGk2MockForSinkeiyaku;
import yuyu.common.hozen.khcommon.KeisanIkkatuNyuukinGkBean;
import yuyu.common.hozen.khcommon.KeisanTukiIkkatuNyuukinGkMockForSinkeiyaku;
import yuyu.common.hozen.khcommon.KeisanTukiIkkatuNyuukinGk;
import yuyu.def.biz.manager.BizDomManager;
import yuyu.def.classification.C_ErrorKbn;
import yuyu.def.classification.C_HasuusyoriKbn;
import yuyu.def.classification.C_Hhknsei;
import yuyu.def.classification.C_HknkknsmnKbn;
import yuyu.def.classification.C_Hrkkaisuu;
import yuyu.def.classification.C_Hrkkeiro;
import yuyu.def.classification.C_Kykjyoutai;
import yuyu.def.classification.C_Nykkeiro;
import yuyu.def.classification.C_NyknaiyouKbn;
import yuyu.def.classification.C_Sdpd;
import yuyu.def.classification.C_TkiktbrisyuruiKbn;
import yuyu.def.classification.C_Tuukasyu;
import yuyu.def.db.entity.HT_MosSyouhn;
import yuyu.def.db.entity.HT_SyoriCTL;
import yuyu.def.sinkeiyaku.manager.SinkeiyakuDomManager;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;
import yuyu.testinfr.inject.MockModuleBinder;

import com.google.inject.AbstractModule;

/**
 * SP計算クラスのメソッド {@link KeisanSP#exec(MosnaiCheckParam pMP)} テスト用クラスです。<br />
 */
@RunWith(OrderedRunner.class)
public class KeisanSPTest_exec {

    @Inject
    private MosnaiCheckParam mosnaiCheckParam;


    @Inject
    private SinkeiyakuDomManager sinkeiyakuDomManager;

    private final static String fileName = "UT_SP_単体テスト仕様書_SP計算";

    private final static String sheetName = "テストデータ_20160909";

    @Before
    public void before(){
        MockModuleBinder.bind(new AbstractModule(){
            @Override
            protected void configure() {
                bind(yuyu.common.hozen.khcommon.KeisanSP.class).to(yuyu.common.hozen.khcommon.KeisanSPMockForSinkeiyaku.class);
                bind(yuyu.common.biz.bzcommon.KeisanGaikakanzan.class).to(yuyu.common.biz.bzcommon.KeisanGaikakanzanMockForSinkeiyaku.class);
                bind(KeisanTukiIkkatuNyuukinGk.class).to(KeisanTukiIkkatuNyuukinGkMockForSinkeiyaku.class);
                bind(KeisanZennouNyuukinGk2.class).to(KeisanZennouNyuukinGk2MockForSinkeiyaku.class);
            }
        });
    }

    @BeforeClass
    public static void testInit(){
        yuyu.common.hozen.khcommon.KeisanSPMockForSinkeiyaku.caller = KeisanSPTest_exec.class;
        yuyu.common.biz.bzcommon.KeisanGaikakanzanMockForSinkeiyaku.caller = KeisanSPTest_exec.class;
        KeisanTukiIkkatuNyuukinGkMockForSinkeiyaku.caller = KeisanSPTest_exec.class;
        KeisanZennouNyuukinGk2MockForSinkeiyaku.caller = KeisanSPTest_exec.class;
    }

    @AfterClass
    public static void testClear() {
        MockObjectManager.initialize();
        yuyu.common.hozen.khcommon.KeisanSPMockForSinkeiyaku.caller = null;
        yuyu.common.biz.bzcommon.KeisanGaikakanzanMockForSinkeiyaku.caller = null;
        yuyu.common.hozen.khcommon.KeisanSPMockForSinkeiyaku.SYORIPTN = null;
        yuyu.common.biz.bzcommon.KeisanGaikakanzanMockForSinkeiyaku.SYORIPTN = null;
        KeisanTukiIkkatuNyuukinGkMockForSinkeiyaku.caller = null;
        KeisanTukiIkkatuNyuukinGkMockForSinkeiyaku.SYORIPTN = null;
        KeisanZennouNyuukinGk2MockForSinkeiyaku.caller = null;
        KeisanZennouNyuukinGk2MockForSinkeiyaku.SYORIPTN = null;
    }

    @BeforeClass
    @Transactional
    public static void insertTestData() {
        try {
            TestDataMaker testDataMaker = new TestDataMaker();
            HashMap<String, Map<String, List<Map<String, String>>>> testDataAndTblMap;
            testDataAndTblMap = testDataMaker.getInData(KeisanSPTest_exec.class, fileName, sheetName);
            testDataMaker.insDataByDataId("データ001", testDataAndTblMap);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @AfterClass
    @Transactional
    public static void deleteTestData() {
        SinkeiyakuDomManager sinkeiyakuDomManager = SWAKInjector.getInstance(SinkeiyakuDomManager.class);
        BizDomManager bizDomManager = SWAKInjector.getInstance(BizDomManager.class);
        sinkeiyakuDomManager.delete(sinkeiyakuDomManager.getAllSyoriCTL());
        bizDomManager.delete(bizDomManager.getAllSyouhnZokusei());
    }

    @Test(expected = CommonBizAppException.class)
    @TestOrder(10)
    public void testExec_A1() {

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("860000017");
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setKosID("user001");
        mosnaiCheckParam.setKosTime("20160110161400000");
        try {
            KeisanSP keisanSP = SWAKInjector.getInstance(yuyu.common.sinkeiyaku.moschk.KeisanSP.class);
            keisanSP.exec(mosnaiCheckParam);
        } catch (CommonBizAppException e) {

            exStringEquals(e.getMessage(), "システム整合性エラーです。申込番号 = 860000017", "エラーメッセージ");
            throw e;
        }
    }

    @Test(expected = CommonBizAppException.class)
    @TestOrder(20)
    public void testExec_A2() {

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("860000025");
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setKosID("user001");
        mosnaiCheckParam.setKosTime("20160110161400000");
        try {
            KeisanSP keisanSP = SWAKInjector.getInstance(yuyu.common.sinkeiyaku.moschk.KeisanSP.class);
            keisanSP.exec(mosnaiCheckParam);
        } catch (CommonBizAppException e) {

            exStringEquals(e.getMessage(), "システム整合性エラーです。申込番号 = 860000025 主契約・特約区分 = 主契約", "エラーメッセージ");
            throw e;
        }
    }

    @Test
    @TestOrder(30)
    public void testExec_A3() {
        MockObjectManager.initialize();
        yuyu.common.hozen.khcommon.KeisanSPMockForSinkeiyaku.SYORIPTN = yuyu.common.hozen.khcommon.KeisanSPMockForSinkeiyaku.TESTPATTERN2;
        KeisanTukiIkkatuNyuukinGkMockForSinkeiyaku.SYORIPTN = KeisanTukiIkkatuNyuukinGkMockForSinkeiyaku.TESTPATTERN1;
        KeisanZennouNyuukinGk2MockForSinkeiyaku.SYORIPTN = KeisanZennouNyuukinGk2MockForSinkeiyaku.TESTPATTERN4;

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("860000033");
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setKosID("user001");
        mosnaiCheckParam.setKosTime("20160110161400000");

        KeisanSP keisanSP = SWAKInjector.getInstance(yuyu.common.sinkeiyaku.moschk.KeisanSP.class);
        keisanSP.exec(mosnaiCheckParam);

        List<HT_MosSyouhn> MosSyouhnLst = syoriCTL.getMosSyouhns();

        exNumericEquals(MosSyouhnLst.size(), 1, "件数");
        exBizCalcbleEquals(MosSyouhnLst.get(0).getSeitoukihons(), BizCurrency.valueOf(80), "正当基本S");
        exBizCalcbleEquals(MosSyouhnLst.get(0).getSyutkp(), BizCurrency.valueOf(11), "主契約・特約P");
        exStringEquals(MosSyouhnLst.get(0).getGyoumuKousinsyaId(), "user001", "業務用更新者ＩＤ");
        exStringEquals(MosSyouhnLst.get(0).getGyoumuKousinTime(), "20160110161400000", "業務用更新時間");
        exBizCalcbleEquals(MosSyouhnLst.get(0).getTkjyp(), BizCurrency.valueOf(0), "特条保険料");

        exBizCalcbleEquals(keisanSP.getSeitoufstpkei(), BizCurrency.valueOf(11), "正当初回P合計額");
        exBizCalcbleEquals(keisanSP.getFstphrkgk(), BizCurrency.valueOf(1230), "初回P払込必要額");
        exBizCalcbleEquals(keisanSP.getHyouteiP(), BizCurrency.valueOf(11), "表定保険料");
        exBizCalcbleEquals(keisanSP.getHeijyunp(), BizCurrency.valueOf(11), "平準払P");
        exBizCalcbleEquals(keisanSP.getHeijyunpryoumasinasi(), BizCurrency.valueOf(11), "平準払P（料増除）");
        exBizCalcbleEquals(keisanSP.getIkkatup(), BizCurrency.valueOf(14, BizCurrencyTypes.DOLLAR), "一括払P");
        exBizCalcbleEquals(keisanSP.getZennoup(), BizCurrency.valueOf(10000), "前納P");
        exBizCalcbleEquals(keisanSP.getZennoujyuutoup(), BizCurrency.valueOf(14, BizCurrencyTypes.DOLLAR), "前納年払充当P");
        exBizCalcbleEquals(keisanSP.getTokujyouPGoukei(), BizCurrency.valueOf(0), "特条P合計");
        exBizCalcbleEquals(keisanSP.getPharaikomisougaku(), BizCurrency.valueOf(1320), "保険料払込総額");
        exClassificationEquals(keisanSP.getiErrorKbn(), C_ErrorKbn.OK, "エラー区分");

    }

    @Test
    @TestOrder(40)
    public void testExec_A4() {
        MockObjectManager.initialize();
        yuyu.common.hozen.khcommon.KeisanSPMockForSinkeiyaku.SYORIPTN = yuyu.common.hozen.khcommon.KeisanSPMockForSinkeiyaku.TESTPATTERN2;
        yuyu.common.biz.bzcommon.KeisanGaikakanzanMockForSinkeiyaku.SYORIPTN = yuyu.common.biz.bzcommon.KeisanGaikakanzanMockForSinkeiyaku.TESTPATTERN2;
        KeisanTukiIkkatuNyuukinGkMockForSinkeiyaku.SYORIPTN = KeisanTukiIkkatuNyuukinGkMockForSinkeiyaku.TESTPATTERN1;
        KeisanZennouNyuukinGk2MockForSinkeiyaku.SYORIPTN = KeisanZennouNyuukinGk2MockForSinkeiyaku.TESTPATTERN1;

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("860000041");
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setKosID("user001");
        mosnaiCheckParam.setKosTime("20160110161400000");

        KeisanSP keisanSP = SWAKInjector.getInstance(yuyu.common.sinkeiyaku.moschk.KeisanSP.class);
        keisanSP.exec(mosnaiCheckParam);

        exClassificationEquals((C_Tuukasyu)MockObjectManager.getArgument(yuyu.common.biz.bzcommon.KeisanGaikakanzanMockForSinkeiyaku.class, "execDivide", 0, 0),
            C_Tuukasyu.JPY, "通貨種類");
        exBizCalcbleEquals((BizCurrency)MockObjectManager.getArgument(yuyu.common.biz.bzcommon.KeisanGaikakanzanMockForSinkeiyaku.class, "execDivide", 0, 1),
            BizCurrency.valueOf(12, BizCurrencyTypes.DOLLAR), "金額");
        exBizCalcbleEquals((BizNumber)MockObjectManager.getArgument(yuyu.common.biz.bzcommon.KeisanGaikakanzanMockForSinkeiyaku.class, "execDivide", 0, 2),
            BizNumber.ONE, "レート");
        exClassificationEquals((C_HasuusyoriKbn)MockObjectManager.getArgument(yuyu.common.biz.bzcommon.KeisanGaikakanzanMockForSinkeiyaku.class, "execDivide", 0, 3),
            C_HasuusyoriKbn.AGE, "端数処理区分");

        exStringEquals((String)MockObjectManager.getArgument(
            yuyu.common.hozen.khcommon.KeisanSPMockForSinkeiyaku.class, "exec", 0, 0), "MD10", "商品コード");
        exStringEquals((String)MockObjectManager.getArgument(
            yuyu.common.hozen.khcommon.KeisanSPMockForSinkeiyaku.class, "exec", 0, 1), "3", "料率世代番号");
        exBizCalcbleEquals((BizNumber)MockObjectManager.getArgument(
            yuyu.common.hozen.khcommon.KeisanSPMockForSinkeiyaku.class, "exec", 0, 2), BizNumber.ZERO, "予定利率");
        exClassificationEquals((C_Hrkkaisuu)MockObjectManager.getArgument(
            yuyu.common.hozen.khcommon.KeisanSPMockForSinkeiyaku.class, "exec", 0, 3), C_Hrkkaisuu.TUKI, "払込回数");
        exNumericEquals((int)MockObjectManager.getArgument(
            yuyu.common.hozen.khcommon.KeisanSPMockForSinkeiyaku.class, "exec", 0, 4), 50, "被保険者年齢");
        exClassificationEquals((C_Hhknsei)MockObjectManager.getArgument(
            yuyu.common.hozen.khcommon.KeisanSPMockForSinkeiyaku.class, "exec", 0, 5), C_Hhknsei.BLNK, "被保険者性別");
        exClassificationEquals((C_HknkknsmnKbn)MockObjectManager.getArgument(
            yuyu.common.hozen.khcommon.KeisanSPMockForSinkeiyaku.class, "exec", 0, 6), C_HknkknsmnKbn.BLNK, "保険期間歳満期区分");
        exNumericEquals((int)MockObjectManager.getArgument(
            yuyu.common.hozen.khcommon.KeisanSPMockForSinkeiyaku.class, "exec", 0, 7), 0, "保険期間");
        exNumericEquals((int)MockObjectManager.getArgument(
            yuyu.common.hozen.khcommon.KeisanSPMockForSinkeiyaku.class, "exec", 0, 8), 60, "払込期間");
        exClassificationEquals((C_Sdpd)MockObjectManager.getArgument(
            yuyu.common.hozen.khcommon.KeisanSPMockForSinkeiyaku.class, "exec", 0, 9), C_Sdpd.SD, "Ｓ建Ｐ建区分");
        exBizCalcbleEquals((BizCurrency)MockObjectManager.getArgument(
            yuyu.common.hozen.khcommon.KeisanSPMockForSinkeiyaku.class, "exec", 0, 10), BizCurrency.valueOf(100), "保険金額");
        exBizCalcbleEquals((BizCurrency)MockObjectManager.getArgument(
            yuyu.common.hozen.khcommon.KeisanSPMockForSinkeiyaku.class, "exec", 0, 11), BizCurrency.valueOf(0), "保険料");
        exClassificationEquals((C_Tuukasyu)MockObjectManager.getArgument(
            yuyu.common.hozen.khcommon.KeisanSPMockForSinkeiyaku.class, "exec", 0, 12), C_Tuukasyu.JPY, "契約通貨種類");
        exClassificationEquals((C_Kykjyoutai)MockObjectManager.getArgument(
            yuyu.common.hozen.khcommon.KeisanSPMockForSinkeiyaku.class, "exec", 0, 13), C_Kykjyoutai.HRKMTYUU, "契約状態");
        exNumericEquals((int)MockObjectManager.getArgument(
            yuyu.common.hozen.khcommon.KeisanSPMockForSinkeiyaku.class, "exec", 0, 14), 5, "第１保険期間");
        exClassificationEquals((C_Hrkkeiro)MockObjectManager.getArgument(
            yuyu.common.hozen.khcommon.KeisanSPMockForSinkeiyaku.class, "exec", 0, 15), C_Hrkkeiro.BLNK, "払込経路");


        List<HT_MosSyouhn> MosSyouhnLst = syoriCTL.getMosSyouhns();

        exNumericEquals(MosSyouhnLst.size(), 3, "件数");

        exBizCalcbleEquals(MosSyouhnLst.get(0).getSeitoukihons(), BizCurrency.valueOf(100), "正当基本S");
        exBizCalcbleEquals(MosSyouhnLst.get(0).getSyutkp(), BizCurrency.valueOf(80), "主契約・特約P");
        exStringEquals(MosSyouhnLst.get(0).getGyoumuKousinsyaId(), "user001", "業務用更新者ＩＤ");
        exStringEquals(MosSyouhnLst.get(0).getGyoumuKousinTime(), "20160110161400000", "業務用更新時間");
        exBizCalcbleEquals(MosSyouhnLst.get(0).getTkjyp(), BizCurrency.valueOf(0), "特条保険料");

        exBizCalcbleEquals(MosSyouhnLst.get(1).getSeitoukihons(), BizCurrency.valueOf(100), "正当基本S");
        exBizCalcbleEquals(MosSyouhnLst.get(1).getSyutkp(), BizCurrency.valueOf(80), "主契約・特約P");
        exStringEquals(MosSyouhnLst.get(1).getGyoumuKousinsyaId(), "user001", "業務用更新者ＩＤ");
        exStringEquals(MosSyouhnLst.get(1).getGyoumuKousinTime(), "20160110161400000", "業務用更新時間");
        exBizCalcbleEquals(MosSyouhnLst.get(1).getTkjyp(), BizCurrency.valueOf(0), "特条保険料");

        exBizCalcbleEquals(MosSyouhnLst.get(2).getSeitoukihons(), BizCurrency.valueOf(0), "正当基本S");
        exBizCalcbleEquals(MosSyouhnLst.get(2).getSyutkp(), BizCurrency.valueOf(80), "主契約・特約P");
        exStringEquals(MosSyouhnLst.get(2).getGyoumuKousinsyaId(), "user001", "業務用更新者ＩＤ");
        exStringEquals(MosSyouhnLst.get(2).getGyoumuKousinTime(), "20160110161400000", "業務用更新時間");
        exBizCalcbleEquals(MosSyouhnLst.get(2).getTkjyp(), BizCurrency.valueOf(0), "特条保険料");

        exBizCalcbleEquals(keisanSP.getSeitoufstpkei(), BizCurrency.valueOf(240, BizCurrencyTypes.YEN), "正当初回P合計額");
        exBizCalcbleEquals(keisanSP.getFstphrkgk(), BizCurrency.valueOf(14, BizCurrencyTypes.DOLLAR), "初回P払込必要額");
        exBizCalcbleEquals(keisanSP.getHyouteiP(), BizCurrency.valueOf(240), "表定保険料");
        exBizCalcbleEquals(keisanSP.getHeijyunp(), BizCurrency.valueOf(240, BizCurrencyTypes.DOLLAR), "平準払P");
        exBizCalcbleEquals(keisanSP.getHeijyunpryoumasinasi(), BizCurrency.valueOf(240, BizCurrencyTypes.DOLLAR), "平準払P（料増除）");
        exBizCalcbleEquals(keisanSP.getIkkatup(), BizCurrency.valueOf(14, BizCurrencyTypes.DOLLAR), "一括払P");
        exBizCalcbleEquals(keisanSP.getZennoup(), BizCurrency.valueOf(0, BizCurrencyTypes.DOLLAR), "前納P");
        exBizCalcbleEquals(keisanSP.getZennoujyuutoup(), BizCurrency.valueOf(0, BizCurrencyTypes.DOLLAR), "前納年払充当P");
        exBizCalcbleEquals(keisanSP.getTokujyouPGoukei(), BizCurrency.valueOf(0), "特条P合計");
        exBizCalcbleEquals(keisanSP.getPharaikomisougaku(), BizCurrency.valueOf(28800, BizCurrencyTypes.DOLLAR), "保険料払込総額");
        exClassificationEquals(keisanSP.getiErrorKbn(), C_ErrorKbn.OK, "エラー区分");
    }

    @Test
    @TestOrder(50)
    public void testExec_A5() {

        MockObjectManager.initialize();
        yuyu.common.biz.bzcommon.KeisanGaikakanzanMockForSinkeiyaku.SYORIPTN = yuyu.common.biz.bzcommon.KeisanGaikakanzanMockForSinkeiyaku.TESTPATTERN2;
        yuyu.common.hozen.khcommon.KeisanSPMockForSinkeiyaku.SYORIPTN = yuyu.common.hozen.khcommon.KeisanSPMockForSinkeiyaku.TESTPATTERN2;
        KeisanZennouNyuukinGk2MockForSinkeiyaku.SYORIPTN = KeisanZennouNyuukinGk2MockForSinkeiyaku.TESTPATTERN1;

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("860000058");
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setKosID("user001");
        mosnaiCheckParam.setKosTime("20160110161400000");

        KeisanSP keisanSP = SWAKInjector.getInstance(yuyu.common.sinkeiyaku.moschk.KeisanSP.class);
        keisanSP.exec(mosnaiCheckParam);

        exClassificationEquals((C_Tuukasyu)MockObjectManager.getArgument(yuyu.common.biz.bzcommon.KeisanGaikakanzanMockForSinkeiyaku.class, "execDivide", 0, 0),
            C_Tuukasyu.JPY, "通貨種類");
        exBizCalcbleEquals((BizCurrency)MockObjectManager.getArgument(yuyu.common.biz.bzcommon.KeisanGaikakanzanMockForSinkeiyaku.class, "execDivide", 0, 1),
            BizCurrency.valueOf(15, BizCurrencyTypes.DOLLAR), "金額");
        exBizCalcbleEquals((BizNumber)MockObjectManager.getArgument(yuyu.common.biz.bzcommon.KeisanGaikakanzanMockForSinkeiyaku.class, "execDivide", 0, 2),
            BizNumber.ONE, "レート");
        exClassificationEquals((C_HasuusyoriKbn)MockObjectManager.getArgument(yuyu.common.biz.bzcommon.KeisanGaikakanzanMockForSinkeiyaku.class, "execDivide", 0, 3),
            C_HasuusyoriKbn.AGE, "端数処理区分");

        List<HT_MosSyouhn> MosSyouhnLst = syoriCTL.getMosSyouhns();

        exNumericEquals(MosSyouhnLst.size(), 1, "件数");

        exBizCalcbleEquals(MosSyouhnLst.get(0).getSeitoukihons(), BizCurrency.valueOf(80), "正当基本S");
        exBizCalcbleEquals(MosSyouhnLst.get(0).getSyutkp(), BizCurrency.valueOf(100), "主契約・特約P");
        exStringEquals(MosSyouhnLst.get(0).getGyoumuKousinsyaId(), "user001", "業務用更新者ＩＤ");
        exStringEquals(MosSyouhnLst.get(0).getGyoumuKousinTime(), "20160110161400000", "業務用更新時間");
        exBizCalcbleEquals(MosSyouhnLst.get(0).getTkjyp(), BizCurrency.valueOf(0), "特条保険料");

        exBizCalcbleEquals(keisanSP.getSeitoufstpkei(), BizCurrency.valueOf(100), "正当初回P合計額");
        exBizCalcbleEquals(keisanSP.getFstphrkgk(), BizCurrency.valueOf(15, BizCurrencyTypes.DOLLAR), "初回P払込必要額");
        exBizCalcbleEquals(keisanSP.getHyouteiP(), BizCurrency.valueOf(100), "表定保険料");
        exBizCalcbleEquals(keisanSP.getHeijyunp(), BizCurrency.valueOf(15, BizCurrencyTypes.DOLLAR), "平準払P");
        exBizCalcbleEquals(keisanSP.getHeijyunpryoumasinasi(), BizCurrency.valueOf(15, BizCurrencyTypes.DOLLAR), "平準払P（料増除）");
        exBizCalcbleEquals(keisanSP.getIkkatup(), BizCurrency.valueOf(0, BizCurrencyTypes.DOLLAR), "一括払P");
        exBizCalcbleEquals(keisanSP.getZennoup(), BizCurrency.valueOf(0, BizCurrencyTypes.DOLLAR), "前納P");
        exBizCalcbleEquals(keisanSP.getZennoujyuutoup(), BizCurrency.valueOf(0, BizCurrencyTypes.DOLLAR), "前納年払充当P");
        exBizCalcbleEquals(keisanSP.getTokujyouPGoukei(), BizCurrency.valueOf(0), "特条P合計");
        exBizCalcbleEquals(keisanSP.getPharaikomisougaku(), BizCurrency.valueOf(0, BizCurrencyTypes.DOLLAR), "保険料払込総額");
        exClassificationEquals(keisanSP.getiErrorKbn(), C_ErrorKbn.OK, "エラー区分");
    }

    @Test
    @TestOrder(60)
    public void testExec_A6() {
        MockObjectManager.initialize();
        yuyu.common.hozen.khcommon.KeisanSPMockForSinkeiyaku.SYORIPTN = yuyu.common.hozen.khcommon.KeisanSPMockForSinkeiyaku.TESTPATTERN2;
        KeisanTukiIkkatuNyuukinGkMockForSinkeiyaku.SYORIPTN = KeisanTukiIkkatuNyuukinGkMockForSinkeiyaku.TESTPATTERN1;
        KeisanZennouNyuukinGk2MockForSinkeiyaku.SYORIPTN = KeisanZennouNyuukinGk2MockForSinkeiyaku.TESTPATTERN1;

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("860000074");
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setKosID("user001");
        mosnaiCheckParam.setKosTime("20160110161400000");

        KeisanSP keisanSP = SWAKInjector.getInstance(yuyu.common.sinkeiyaku.moschk.KeisanSP.class);
        keisanSP.exec(mosnaiCheckParam);

        List<HT_MosSyouhn> MosSyouhnLst = syoriCTL.getMosSyouhns();

        exNumericEquals(MosSyouhnLst.size(), 1, "件数");
        exBizCalcbleEquals(MosSyouhnLst.get(0).getSeitoukihons(), BizCurrency.valueOf(16), "正当基本S");
        exBizCalcbleEquals(MosSyouhnLst.get(0).getSyutkp(), BizCurrency.valueOf(80), "主契約・特約P");
        exStringEquals(MosSyouhnLst.get(0).getGyoumuKousinsyaId(), "user001", "業務用更新者ＩＤ");
        exStringEquals(MosSyouhnLst.get(0).getGyoumuKousinTime(), "20160110161400000", "業務用更新時間");
        exBizCalcbleEquals(MosSyouhnLst.get(0).getTkjyp(), BizCurrency.valueOf(0), "特条保険料");

        exBizCalcbleEquals(keisanSP.getSeitoufstpkei(), BizCurrency.valueOf(80), "正当初回P合計額");
        exBizCalcbleEquals(keisanSP.getFstphrkgk(), BizCurrency.valueOf(11), "初回P払込必要額");
        exBizCalcbleEquals(keisanSP.getHyouteiP(), BizCurrency.valueOf(80), "表定保険料");
        exBizCalcbleEquals(keisanSP.getHeijyunp(), BizCurrency.valueOf(0), "平準払P");
        exBizCalcbleEquals(keisanSP.getHeijyunpryoumasinasi(), BizCurrency.valueOf(0), "平準払P（料増除）");
        exBizCalcbleEquals(keisanSP.getIkkatup(), BizCurrency.valueOf(14, BizCurrencyTypes.DOLLAR), "一括払P");
        exBizCalcbleEquals(keisanSP.getZennoup(), BizCurrency.valueOf(10000), "前納P");
        exBizCalcbleEquals(keisanSP.getZennoujyuutoup(), BizCurrency.valueOf(14, BizCurrencyTypes.DOLLAR), "前納年払充当P");
        exBizCalcbleEquals(keisanSP.getTokujyouPGoukei(), BizCurrency.valueOf(0), "特条P合計");
        exBizCalcbleEquals(keisanSP.getPharaikomisougaku(), BizCurrency.valueOf(0), "保険料払込総額");
        exClassificationEquals(keisanSP.getiErrorKbn(), C_ErrorKbn.OK, "エラー区分");
    }

    @Test
    @TestOrder(70)
    public void testExec_A7() {
        MockObjectManager.initialize();
        yuyu.common.hozen.khcommon.KeisanSPMockForSinkeiyaku.SYORIPTN = yuyu.common.hozen.khcommon.KeisanSPMockForSinkeiyaku.TESTPATTERN1;
        KeisanTukiIkkatuNyuukinGkMockForSinkeiyaku.SYORIPTN = KeisanTukiIkkatuNyuukinGkMockForSinkeiyaku.TESTPATTERN1;
        KeisanZennouNyuukinGk2MockForSinkeiyaku.SYORIPTN = KeisanZennouNyuukinGk2MockForSinkeiyaku.TESTPATTERN1;

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("860000082");
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setKosID("user001");
        mosnaiCheckParam.setKosTime("20160110161400000");

        KeisanSP keisanSP = SWAKInjector.getInstance(yuyu.common.sinkeiyaku.moschk.KeisanSP.class);
        keisanSP.exec(mosnaiCheckParam);

        List<HT_MosSyouhn> MosSyouhnLst = syoriCTL.getMosSyouhns();

        exNumericEquals(MosSyouhnLst.size(), 1, "件数");
        exBizCalcbleEquals(MosSyouhnLst.get(0).getSeitoukihons(), BizCurrency.valueOf(0), "正当基本S");
        exBizCalcbleEquals(MosSyouhnLst.get(0).getSyutkp(), BizCurrency.valueOf(0), "主契約・特約P");
        exStringEquals(MosSyouhnLst.get(0).getGyoumuKousinsyaId(), null, "業務用更新者ＩＤ");
        exStringEquals(MosSyouhnLst.get(0).getGyoumuKousinTime(), null, "業務用更新時間");
        exBizCalcbleEquals(MosSyouhnLst.get(0).getTkjyp(), BizCurrency.valueOf(0), "特条保険料");

        exBizCalcbleEquals(keisanSP.getSeitoufstpkei(), BizCurrency.valueOf(0), "正当初回P合計額");
        exBizCalcbleEquals(keisanSP.getFstphrkgk(), BizCurrency.valueOf(0), "初回P払込必要額");
        exBizCalcbleEquals(keisanSP.getHyouteiP(), BizCurrency.valueOf(0), "表定保険料");
        exBizCalcbleEquals(keisanSP.getHeijyunp(), BizCurrency.valueOf(0), "平準払P");
        exBizCalcbleEquals(keisanSP.getHeijyunpryoumasinasi(), BizCurrency.valueOf(0), "平準払P（料増除）");
        exBizCalcbleEquals(keisanSP.getIkkatup(), BizCurrency.valueOf(0), "一括払P");
        exBizCalcbleEquals(keisanSP.getZennoup(), BizCurrency.valueOf(0), "前納P");
        exBizCalcbleEquals(keisanSP.getZennoujyuutoup(), BizCurrency.valueOf(0), "前納年払充当P");
        exBizCalcbleEquals(keisanSP.getTokujyouPGoukei(), BizCurrency.valueOf(0), "特条P合計");
        exBizCalcbleEquals(keisanSP.getPharaikomisougaku(), BizCurrency.valueOf(0), "保険料払込総額");
        exClassificationEquals(keisanSP.getiErrorKbn(), C_ErrorKbn.ERROR, "エラー区分");
    }

    @Test
    @TestOrder(80)
    public void testExec_A8() {
        MockObjectManager.initialize();
        yuyu.common.hozen.khcommon.KeisanSPMockForSinkeiyaku.SYORIPTN = yuyu.common.hozen.khcommon.KeisanSPMockForSinkeiyaku.TESTPATTERN2;
        KeisanTukiIkkatuNyuukinGkMockForSinkeiyaku.SYORIPTN = KeisanTukiIkkatuNyuukinGkMockForSinkeiyaku.TESTPATTERN4;
        KeisanZennouNyuukinGk2MockForSinkeiyaku.SYORIPTN = KeisanZennouNyuukinGk2MockForSinkeiyaku.TESTPATTERN1;
        KeisanGaikakanzanMockForSinkeiyaku.SYORIPTN = KeisanGaikakanzanMockForSinkeiyaku.TESTPATTERN1;

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("860000090");
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setKosID("user001");
        mosnaiCheckParam.setKosTime("20160110161400000");

        KeisanSP keisanSP = SWAKInjector.getInstance(yuyu.common.sinkeiyaku.moschk.KeisanSP.class);
        keisanSP.exec(mosnaiCheckParam);

        exClassificationEquals((C_Tuukasyu) MockObjectManager.getArgument(KeisanGaikakanzanMockForSinkeiyaku.class, "exec", 0, 0),
            C_Tuukasyu.USD, "通貨種類");
        exBizCalcbleEquals((BizCurrency) MockObjectManager.getArgument(KeisanGaikakanzanMockForSinkeiyaku.class, "exec", 0, 1),
            BizCurrency.valueOf(80), "金額");
        exBizCalcbleEquals((BizNumber) MockObjectManager.getArgument(KeisanGaikakanzanMockForSinkeiyaku.class, "exec", 0, 2),
            BizNumber.ZERO, "レート");
        exClassificationEquals(
            (C_HasuusyoriKbn) MockObjectManager.getArgument(KeisanGaikakanzanMockForSinkeiyaku.class, "exec", 0, 3),
            C_HasuusyoriKbn.SUTE, "端数処理区分");

        KeisanIkkatuNyuukinGkBean keisanIkkatuNyuukinGkBean = (KeisanIkkatuNyuukinGkBean) MockObjectManager
            .getArgument(KeisanTukiIkkatuNyuukinGkMockForSinkeiyaku.class, "exec", 0, 0);
        exNumericEquals(keisanIkkatuNyuukinGkBean.getKeisanIkkatuNyuukinGkSyouhnBeanLst().size(), 1,
            "一括入金額計算用Bean.一括入金額計算用商品情報Beanリスト");
        exStringEquals(keisanIkkatuNyuukinGkBean.getKeisanIkkatuNyuukinGkSyouhnBeanLst().get(0).getSyouhnCd(),
            "MD16", "商品コード");
        exNumericEquals(keisanIkkatuNyuukinGkBean.getKeisanIkkatuNyuukinGkSyouhnBeanLst().get(0).getSyouhnsdNo(),
            18, "商品世代番号");
        exStringEquals(keisanIkkatuNyuukinGkBean.getKeisanIkkatuNyuukinGkSyouhnBeanLst().get(0).getRyouritusdNo(),
            "9", "料率世代番号");
        exBizCalcbleEquals(keisanIkkatuNyuukinGkBean.getKeisanIkkatuNyuukinGkSyouhnBeanLst().get(0).getHokenryou(),
            BizCurrency.valueOf(10,  BizCurrencyTypes.DOLLAR), "保険料");
        exNumericEquals(keisanIkkatuNyuukinGkBean.getJyuutoutuKisuu(), 6, "一括入金額計算用Bean.充当月数");
        exClassificationEquals(keisanIkkatuNyuukinGkBean.getTkiktbrisyuruiKbn(), C_TkiktbrisyuruiKbn.TEIKI_6MONTHS,
            "一括入金額計算用Bean.定期一括払種類区分");
        exClassificationEquals(keisanIkkatuNyuukinGkBean.getRstuukasyu(), C_Tuukasyu.USD,
            "一括入金額計算用Bean.領収通貨種類");
        exClassificationEquals(keisanIkkatuNyuukinGkBean.getNyknaiyoukbn(), C_NyknaiyouKbn.BLNK,
            "一括入金額計算用Bean.入金内容区分");
        exClassificationEquals(keisanIkkatuNyuukinGkBean.getNykkeiro(), C_Nykkeiro.BLNK,
            "一括入金額計算用Bean.入金経路");
        exDateEquals(keisanIkkatuNyuukinGkBean.getSyokaiprsYmd(), null,
            "一括入金額計算用Bean.領収年月日");
        exDateYMEquals(keisanIkkatuNyuukinGkBean.getJyutoustartYm(), null,
            "一括入金額計算用Bean.充当開始年月");
        exBooleanEquals((boolean) MockObjectManager.getArgument(KeisanTukiIkkatuNyuukinGkMockForSinkeiyaku.class, "exec", 0, 1), false,
            "一括割引不要フラグ");

        exDateEquals((BizDate) MockObjectManager.getArgument(KeisanZennouNyuukinGk2MockForSinkeiyaku.class,
            "execKeisanSinkeiyakuDoujiZennouNyuukinGk", 0, 0), BizDate.valueOf(20161111), "基準日");
        exBizCalcbleEquals((BizCurrency) MockObjectManager.getArgument(KeisanZennouNyuukinGk2MockForSinkeiyaku.class,
            "execKeisanSinkeiyakuDoujiZennouNyuukinGk", 0, 1), BizCurrency.valueOf(14,  BizCurrencyTypes.DOLLAR), "前納時払込保険料");
        exNumericEquals((Integer) MockObjectManager.getArgument(KeisanZennouNyuukinGk2MockForSinkeiyaku.class,
            "execKeisanSinkeiyakuDoujiZennouNyuukinGk", 0, 2), 1, "前納期間");
        exClassificationEquals((C_Tuukasyu) MockObjectManager.getArgument(KeisanZennouNyuukinGk2MockForSinkeiyaku.class,
            "execKeisanSinkeiyakuDoujiZennouNyuukinGk", 0, 3), null, "領収通貨種類");
        exBizCalcbleEquals((BizNumber) MockObjectManager.getArgument(KeisanZennouNyuukinGk2MockForSinkeiyaku.class,
            "execKeisanSinkeiyakuDoujiZennouNyuukinGk", 0, 4), null, "領収為替レート");
        exBizCalcbleEquals((BizNumber) MockObjectManager.getArgument(KeisanZennouNyuukinGk2MockForSinkeiyaku.class,
            "execKeisanSinkeiyakuDoujiZennouNyuukinGk", 0, 5), null, "円換算適用為替レート");

        List<HT_MosSyouhn> MosSyouhnLst = syoriCTL.getMosSyouhns();

        exNumericEquals(MosSyouhnLst.size(), 1, "件数");
        exBizCalcbleEquals(MosSyouhnLst.get(0).getSeitoukihons(), BizCurrency.valueOf(0), "正当基本S");
        exBizCalcbleEquals(MosSyouhnLst.get(0).getSyutkp(), BizCurrency.valueOf(80), "主契約・特約P");
        exStringEquals(MosSyouhnLst.get(0).getGyoumuKousinsyaId(), "user001", "業務用更新者ＩＤ");
        exStringEquals(MosSyouhnLst.get(0).getGyoumuKousinTime(), "20160110161400000", "業務用更新時間");
        exBizCalcbleEquals(MosSyouhnLst.get(0).getTkjyp(), BizCurrency.valueOf(0), "特条保険料");

        exBizCalcbleEquals(keisanSP.getSeitoufstpkei(), BizCurrency.valueOf(80), "正当初回P合計額");
        exBizCalcbleEquals(keisanSP.getFstphrkgk(), BizCurrency.valueOf(11), "初回P払込必要額");
        exBizCalcbleEquals(keisanSP.getHyouteiP(), BizCurrency.valueOf(80), "表定保険料");
        exBizCalcbleEquals(keisanSP.getHeijyunp(), BizCurrency.valueOf(10, BizCurrencyTypes.DOLLAR), "平準払P");
        exBizCalcbleEquals(keisanSP.getHeijyunpryoumasinasi(), BizCurrency.valueOf(10, BizCurrencyTypes.DOLLAR), "平準払P（料増除）");
        exBizCalcbleEquals(keisanSP.getIkkatup(), BizCurrency.valueOf(14, BizCurrencyTypes.DOLLAR), "一括払P");
        exBizCalcbleEquals(keisanSP.getZennoup(), BizCurrency.valueOf(10000), "前納P");
        exBizCalcbleEquals(keisanSP.getZennoujyuutoup(), BizCurrency.valueOf(14, BizCurrencyTypes.DOLLAR), "前納年払充当P");
        exBizCalcbleEquals(keisanSP.getTokujyouPGoukei(), BizCurrency.valueOf(0), "特条P合計");
        exBizCalcbleEquals(keisanSP.getPharaikomisougaku(), BizCurrency.valueOf(1200, BizCurrencyTypes.DOLLAR), "保険料払込総額");
        exClassificationEquals(keisanSP.getiErrorKbn(), C_ErrorKbn.OK, "エラー区分");
    }

    @Test
    @TestOrder(90)
    public void testExec_A9() {

        MockObjectManager.initialize();
        KeisanTukiIkkatuNyuukinGkMockForSinkeiyaku.SYORIPTN = KeisanTukiIkkatuNyuukinGkMockForSinkeiyaku.TESTPATTERN2;

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("860000108");
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setKosID("user001");
        mosnaiCheckParam.setKosTime("20160110161400000");

        KeisanSP keisanSP = SWAKInjector.getInstance(yuyu.common.sinkeiyaku.moschk.KeisanSP.class);
        keisanSP.exec(mosnaiCheckParam);

        exClassificationEquals(keisanSP.getiErrorKbn(), C_ErrorKbn.ERROR, "エラー区分");

    }

    @Test
    @TestOrder(100)
    public void testExec_A10() {

        MockObjectManager.initialize();
        KeisanTukiIkkatuNyuukinGkMockForSinkeiyaku.SYORIPTN = KeisanTukiIkkatuNyuukinGkMockForSinkeiyaku.TESTPATTERN3;

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("860000116");
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setKosID("user001");
        mosnaiCheckParam.setKosTime("20160110161400000");

        KeisanSP keisanSP = SWAKInjector.getInstance(yuyu.common.sinkeiyaku.moschk.KeisanSP.class);
        keisanSP.exec(mosnaiCheckParam);

        KeisanIkkatuNyuukinGkBean keisanIkkatuNyuukinGkBean = (KeisanIkkatuNyuukinGkBean) MockObjectManager
            .getArgument(KeisanTukiIkkatuNyuukinGkMockForSinkeiyaku.class, "exec", 0, 0);
        exClassificationEquals(keisanIkkatuNyuukinGkBean.getTkiktbrisyuruiKbn(), C_TkiktbrisyuruiKbn.BLNK,
            "一括入金額計算用Bean.定期一括払種類区分");

        exClassificationEquals(keisanSP.getiErrorKbn(), C_ErrorKbn.OK, "エラー区分");

    }

    @Test
    @TestOrder(110)
    public void testExec_A11() {

        MockObjectManager.initialize();
        KeisanTukiIkkatuNyuukinGkMockForSinkeiyaku.SYORIPTN = KeisanTukiIkkatuNyuukinGkMockForSinkeiyaku.TESTPATTERN1;
        KeisanZennouNyuukinGk2MockForSinkeiyaku.SYORIPTN = KeisanZennouNyuukinGk2MockForSinkeiyaku.TESTPATTERN2;

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("860000124");
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setKosID("user001");
        mosnaiCheckParam.setKosTime("20160110161400000");

        KeisanSP keisanSP = SWAKInjector.getInstance(yuyu.common.sinkeiyaku.moschk.KeisanSP.class);
        keisanSP.exec(mosnaiCheckParam);

        KeisanIkkatuNyuukinGkBean keisanIkkatuNyuukinGkBean = (KeisanIkkatuNyuukinGkBean) MockObjectManager
            .getArgument(KeisanTukiIkkatuNyuukinGkMockForSinkeiyaku.class, "exec", 0, 0);
        exClassificationEquals(keisanIkkatuNyuukinGkBean.getTkiktbrisyuruiKbn(), C_TkiktbrisyuruiKbn.TEIKI_12MONTHS,
            "一括入金額計算用Bean.定期一括払種類区分");

        exClassificationEquals(keisanSP.getiErrorKbn(), C_ErrorKbn.ERROR, "エラー区分");

    }

    @Test
    @TestOrder(120)
    public void testExec_A12() {

        MockObjectManager.initialize();
        KeisanTukiIkkatuNyuukinGkMockForSinkeiyaku.SYORIPTN = KeisanTukiIkkatuNyuukinGkMockForSinkeiyaku.TESTPATTERN1;
        KeisanZennouNyuukinGk2MockForSinkeiyaku.SYORIPTN = KeisanZennouNyuukinGk2MockForSinkeiyaku.TESTPATTERN3;

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("860000132");
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setKosID("user001");
        mosnaiCheckParam.setKosTime("20160110161400000");

        KeisanSP keisanSP = SWAKInjector.getInstance(yuyu.common.sinkeiyaku.moschk.KeisanSP.class);
        keisanSP.exec(mosnaiCheckParam);

        exClassificationEquals(keisanSP.getiErrorKbn(), C_ErrorKbn.ERROR, "エラー区分");

    }

    @Test
    @TestOrder(130)
    public void testExec_A13() {

        MockObjectManager.initialize();
        KeisanTukiIkkatuNyuukinGkMockForSinkeiyaku.SYORIPTN = KeisanTukiIkkatuNyuukinGkMockForSinkeiyaku.TESTPATTERN3;

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("860000066");
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setKosID("user001");
        mosnaiCheckParam.setKosTime("20160110161400000");

        KeisanSP keisanSP = SWAKInjector.getInstance(yuyu.common.sinkeiyaku.moschk.KeisanSP.class);
        keisanSP.exec(mosnaiCheckParam);

        List<HT_MosSyouhn> MosSyouhnLst = syoriCTL.getMosSyouhns();

        exNumericEquals(MosSyouhnLst.size(), 1, "件数");
        exBizCalcbleEquals(MosSyouhnLst.get(0).getTeikisiharaikin(), BizCurrency.valueOf(1), "定期支払金");

        exClassificationEquals(keisanSP.getiErrorKbn(), C_ErrorKbn.OK, "エラー区分");

    }

    @Test
    @TestOrder(140)
    public void testExec_A14() {

        MockObjectManager.initialize();
        KeisanTukiIkkatuNyuukinGkMockForSinkeiyaku.SYORIPTN = KeisanTukiIkkatuNyuukinGkMockForSinkeiyaku.TESTPATTERN3;

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("860000140");
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setKosID("user001");
        mosnaiCheckParam.setKosTime("20160110161400000");

        KeisanSP keisanSP = SWAKInjector.getInstance(yuyu.common.sinkeiyaku.moschk.KeisanSP.class);
        keisanSP.exec(mosnaiCheckParam);

        List<HT_MosSyouhn> MosSyouhnLst = syoriCTL.getMosSyouhns();

        exNumericEquals(MosSyouhnLst.size(), 1, "件数");
        exBizCalcbleEquals(MosSyouhnLst.get(0).getTeikisiharaikin(), BizCurrency.valueOf(0, BizCurrencyTypes.YEN), "定期支払金");

        exClassificationEquals(keisanSP.getiErrorKbn(), C_ErrorKbn.OK, "エラー区分");

    }

    @Test
    @TestOrder(150)
    public void testExec_A15() {

        MockObjectManager.initialize();
        KeisanTukiIkkatuNyuukinGkMockForSinkeiyaku.SYORIPTN = KeisanTukiIkkatuNyuukinGkMockForSinkeiyaku.TESTPATTERN3;

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("860000157");
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setKosID("user001");
        mosnaiCheckParam.setKosTime("20160110161400000");

        KeisanSP keisanSP = SWAKInjector.getInstance(yuyu.common.sinkeiyaku.moschk.KeisanSP.class);
        keisanSP.exec(mosnaiCheckParam);

        List<HT_MosSyouhn> MosSyouhnLst = syoriCTL.getMosSyouhns();

        exNumericEquals(MosSyouhnLst.size(), 1, "件数");
        exBizCalcbleEquals(MosSyouhnLst.get(0).getTeikisiharaikin(), null, "定期支払金");

        exClassificationEquals(keisanSP.getiErrorKbn(), C_ErrorKbn.OK, "エラー区分");

    }

    @Test
    @TestOrder(160)
    public void testExec_A16() {

        MockObjectManager.initialize();
        KeisanTukiIkkatuNyuukinGkMockForSinkeiyaku.SYORIPTN = KeisanTukiIkkatuNyuukinGkMockForSinkeiyaku.TESTPATTERN3;

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("860000165");
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setKosID("user001");
        mosnaiCheckParam.setKosTime("20160110161400000");

        KeisanSP keisanSP = SWAKInjector.getInstance(yuyu.common.sinkeiyaku.moschk.KeisanSP.class);
        keisanSP.exec(mosnaiCheckParam);

        List<HT_MosSyouhn> MosSyouhnLst = syoriCTL.getMosSyouhns();

        exNumericEquals(MosSyouhnLst.size(), 1, "件数");
        exBizCalcbleEquals(MosSyouhnLst.get(0).getTeikisiharaikin(), BizCurrency.valueOf(0, BizCurrencyTypes.YEN), "定期支払金");

        exClassificationEquals(keisanSP.getiErrorKbn(), C_ErrorKbn.OK, "エラー区分");

    }

    @Test
    @TestOrder(170)
    public void testExec_A17() {

        MockObjectManager.initialize();
        yuyu.common.hozen.khcommon.KeisanSPMockForSinkeiyaku.SYORIPTN = yuyu.common.hozen.khcommon.KeisanSPMockForSinkeiyaku.TESTPATTERN2;
        KeisanTukiIkkatuNyuukinGkMockForSinkeiyaku.SYORIPTN = KeisanTukiIkkatuNyuukinGkMockForSinkeiyaku.TESTPATTERN3;

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("860007053");
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setKosID("user001");
        mosnaiCheckParam.setKosTime("20160110161400000");

        KeisanSP keisanSP = SWAKInjector.getInstance(yuyu.common.sinkeiyaku.moschk.KeisanSP.class);
        keisanSP.exec(mosnaiCheckParam);

        exBizCalcbleEquals(mosnaiCheckParam.getPRate(), BizNumber.valueOf(1.23), "Ｐレート");
        exBizCalcbleEquals(mosnaiCheckParam.getPdateSRate(), BizNumber.valueOf(2.34), "Ｐ建Ｓレート");
        exBizCalcbleEquals(mosnaiCheckParam.getHrbtJyousu(), BizNumber.valueOf(3.45), "払別乗数");
    }
}
