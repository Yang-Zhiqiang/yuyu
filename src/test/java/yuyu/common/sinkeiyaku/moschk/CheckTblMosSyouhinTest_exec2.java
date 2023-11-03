package yuyu.common.sinkeiyaku.moschk;

import static yuyu.testinfr.YuyuFunctionTestUtil.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;
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
import yuyu.app.base.ref.TestDataMakerException;
import yuyu.common.biz.bzcommon.KeisanGaikakanzan;
import yuyu.common.biz.bzcommon.KeisanGaikakanzanMockForSinkeiyaku;
import yuyu.common.biz.bzdairiten.BzGetAgInfo;
import yuyu.common.biz.bzdairiten.BzGetAgInfoMockForSinkeiyaku;
import yuyu.common.biz.exception.CommonBizAppException;
import yuyu.common.sinkeiyaku.skcommon.EditNenkinKoumokuUtil;
import yuyu.common.sinkeiyaku.skcommon.EditNenkinKoumokuUtilMockForSinkeiyaku;
import yuyu.common.sinkeiyaku.skcommon.GetKiteiCheckYenkansangk;
import yuyu.common.sinkeiyaku.skcommon.GetKiteiCheckYenkansangkMockForSinkeiyaku;
import yuyu.def.biz.manager.BizDomManager;
import yuyu.def.classification.C_Channelcd;
import yuyu.def.classification.C_HubisyubetuKbn;
import yuyu.def.classification.C_HubisyubetusyousaiKbn;
import yuyu.def.classification.C_KouzokujkKbn;
import yuyu.def.classification.C_SekmossakuseiErroutKbn;
import yuyu.def.classification.C_SysKbn;
import yuyu.def.classification.C_SyutkKbn;
import yuyu.def.classification.C_UmuKbn;
import yuyu.def.db.entity.BM_SyouhnZokusei;
import yuyu.def.db.entity.HT_HubiMsg;
import yuyu.def.db.entity.HT_MosSyouhn;
import yuyu.def.db.entity.HT_SyoriCTL;
import yuyu.def.sinkeiyaku.manager.SinkeiyakuDomManager;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;
import yuyu.testinfr.inject.MockModuleBinder;

import com.google.inject.AbstractModule;

/**
 * 申込商品TBLチェックのメソッド {@link CheckTblMosSyouhin#exec(MosnaiCheckParam)} テスト用クラスです。<br />
 * テスト実行用クラスです。<br />
 */
@RunWith(OrderedRunner.class)
public class CheckTblMosSyouhinTest_exec2 {

    @Inject
    private MosnaiCheckParam mosnaiCheckParam;

    @Inject
    private SinkeiyakuDomManager sinkeiyakuDomManager;

    @Inject
    private BizDomManager bizDomManager;
    private final static String fileName = "UT-SP_単体テスト仕様書（共通）_申込商品TBLチェック";

    private final static String sheetName = "INデータ(2)";

    @Before
    public void before(){
        MockModuleBinder.bind(new AbstractModule(){
            @Override
            protected void configure() {

                bind(BzGetAgInfo.class).to(BzGetAgInfoMockForSinkeiyaku.class);
                bind(KeisanGaikakanzan.class).to(KeisanGaikakanzanMockForSinkeiyaku.class);
                bind(SetKyuuhuNitigaku.class).to(SetKyuuhuNitigakuMockForSinkeiyaku.class);
                bind(GetKiteiCheckYenkansangk.class).to(GetKiteiCheckYenkansangkMockForSinkeiyaku.class);
                bind(CheckSaiteiP.class).to(CheckSaiteiPMockForSinkeiyaku.class);
                bind(HanteiMoschk.class).to(HanteiMoschkMockForSinkeiyaku.class);
                bind(EditNenkinKoumokuUtil.class).to(EditNenkinKoumokuUtilMockForSinkeiyaku.class);

            }
        });
    }

    @BeforeClass
    @Transactional
    public static void insertTestData() {
        try {
            TestDataMaker testDataMaker = new TestDataMaker();
            HashMap<String, Map<String, List<Map<String, String>>>> testDataAndTblMap;
            testDataAndTblMap = testDataMaker.getInData(CheckTblMosSyouhinTest_exec1.class, fileName, sheetName);
            testDataMaker.insDataByDataId("データ001", testDataAndTblMap);
        } catch (TestDataMakerException e) {

            e.printStackTrace();
        }
    }

    @AfterClass
    @Transactional
    public static void deleteTestData() {
        SinkeiyakuDomManager sinkeiyakuDomManager = SWAKInjector.getInstance(SinkeiyakuDomManager.class);
        sinkeiyakuDomManager.delete(sinkeiyakuDomManager.getAllSyoriCTL());

        BizDomManager bizDomManager = SWAKInjector.getInstance(BizDomManager.class);
        bizDomManager.delete(bizDomManager.getAllChkKata());
        bizDomManager.delete(bizDomManager.getAllChkJhNenreiHani2());
        bizDomManager.delete(bizDomManager.getAllChkNenreiHani2());
        bizDomManager.delete(bizDomManager.getAllChkTkykHukaKahi());
        bizDomManager.delete(bizDomManager.getAllChkKyuuhuKata());
        bizDomManager.delete(bizDomManager.getAllChkKhnKyhKgBairitu());

        bizDomManager.delete(bizDomManager.getAllChkSaiteiS());
        bizDomManager.delete(bizDomManager.getAllChkJhSaiteiS());
        bizDomManager.delete(bizDomManager.getAllChkSaikouSSTani());
        bizDomManager.delete(bizDomManager.getAllChkJhSaikouSSTani());
        bizDomManager.delete(bizDomManager.getAllChkSaiteiP());
        bizDomManager.delete(bizDomManager.getAllChkJhSaiteiP());
        bizDomManager.delete(bizDomManager.getAllSyouhnZokusei());
        bizDomManager.delete(bizDomManager.getAllChkTkykHukaSeigen());
        bizDomManager.delete(bizDomManager.getAllChkSyouhnKokutiJougenS());
        bizDomManager.delete(bizDomManager.getAllChkKeiyakuTaniSaikouS());
        bizDomManager.delete(bizDomManager.getAllChkKokutiJougenS());
        bizDomManager.delete(bizDomManager.getAllChkHrkPTani());
        bizDomManager.delete(bizDomManager.getAllChkSTani());
        bizDomManager.delete(bizDomManager.getAllKijyungkHanteiKawaseRate());
    }

    @BeforeClass
    public static void testInit(){
        BzGetAgInfoMockForSinkeiyaku.caller = CheckTblMosSyouhinTest_exec.class;
        KeisanGaikakanzanMockForSinkeiyaku.caller = CheckTblMosSyouhinTest_exec.class;
        SetKyuuhuNitigakuMockForSinkeiyaku.caller = CheckTblMosSyouhinTest_exec.class;
        GetKiteiCheckYenkansangkMockForSinkeiyaku.caller = CheckTblMosSyouhinTest_exec.class;
        CheckSaiteiPMockForSinkeiyaku.caller = CheckTblMosSyouhinTest_exec.class;

    }

    @AfterClass
    public static void testClear() {

        BzGetAgInfoMockForSinkeiyaku.caller = null;
        BzGetAgInfoMockForSinkeiyaku.SYORIPTN = null;
        KeisanGaikakanzanMockForSinkeiyaku.caller = null;
        KeisanGaikakanzanMockForSinkeiyaku.SYORIPTN = null;
        SetKyuuhuNitigakuMockForSinkeiyaku.caller = null;
        SetKyuuhuNitigakuMockForSinkeiyaku.SYORIPTN = null;
        GetKiteiCheckYenkansangkMockForSinkeiyaku.caller = null;
        GetKiteiCheckYenkansangkMockForSinkeiyaku.SYORIPTN = null;
        CheckSaiteiPMockForSinkeiyaku.caller = null;
        CheckSaiteiPMockForSinkeiyaku.SYORIPTN = null;
        MockObjectManager.initialize();

    }

    @Test(expected = CommonBizAppException.class)
    @TestOrder(5010)
    @Transactional
    public void testExec_E1() {
        MockObjectManager.initialize();
        BzGetAgInfoMockForSinkeiyaku.SYORIPTN = BzGetAgInfoMockForSinkeiyaku.TESTPATTERN4;
        KeisanGaikakanzanMockForSinkeiyaku.SYORIPTN = KeisanGaikakanzanMockForSinkeiyaku.TESTPATTERN1;
        GetKiteiCheckYenkansangkMockForSinkeiyaku.SYORIPTN = GetKiteiCheckYenkansangkMockForSinkeiyaku.TESTPATTERN5;
        CheckSaiteiPMockForSinkeiyaku.SYORIPTN = CheckSaiteiPMockForSinkeiyaku.TESTPATTERN1;
        CheckTblMosSyouhin checkTblMosSyouhin = SWAKInjector.getInstance(CheckTblMosSyouhin.class);

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("860000686");
        List<HT_MosSyouhn> syuMosSyouhnParamLst = syoriCTL.getMosSyouhnsBySyutkkbn(C_SyutkKbn.SYU);
        HT_MosSyouhn syuMosSyouhnParam = syuMosSyouhnParamLst.get(0);
        BM_SyouhnZokusei syuSyouhnZokusei = bizDomManager.getSyouhnZokusei(syuMosSyouhnParam.getSyouhncd(),
            syuMosSyouhnParam.getSyouhnsdno());
        mosnaiCheckParam.setSyuSyouhnZokusei(syuSyouhnZokusei);
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setSysKbn(C_SysKbn.SKEI);
        mosnaiCheckParam.setKokutiChkHuyoUmu(C_UmuKbn.NONE);
        mosnaiCheckParam.setSysDate(BizDate.valueOf(20160102));

        try {
            checkTblMosSyouhin.exec(mosnaiCheckParam);
        } catch (CommonBizAppException e) {
            exStringEquals(e.getMessage(), "システム整合性エラーです。最低Ｓテーブルにデータが見つかりません。", "エラーメッセージ");
            throw e;
        }
    }
    @Test
    @TestOrder(5020)
    @Transactional
    public void testExec_E2() {
        MockObjectManager.initialize();
        BzGetAgInfoMockForSinkeiyaku.SYORIPTN = BzGetAgInfoMockForSinkeiyaku.TESTPATTERN4;
        KeisanGaikakanzanMockForSinkeiyaku.SYORIPTN = KeisanGaikakanzanMockForSinkeiyaku.TESTPATTERN1;
        GetKiteiCheckYenkansangkMockForSinkeiyaku.SYORIPTN = GetKiteiCheckYenkansangkMockForSinkeiyaku.TESTPATTERN5;
        CheckSaiteiPMockForSinkeiyaku.SYORIPTN = CheckSaiteiPMockForSinkeiyaku.TESTPATTERN1;
        CheckTblMosSyouhin checkTblMosSyouhin = SWAKInjector.getInstance(CheckTblMosSyouhin.class);

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("860000694");
        List<HT_MosSyouhn> syuMosSyouhnParamLst = syoriCTL.getMosSyouhnsBySyutkkbn(C_SyutkKbn.SYU);
        HT_MosSyouhn syuMosSyouhnParam = syuMosSyouhnParamLst.get(0);
        BM_SyouhnZokusei syuSyouhnZokusei = bizDomManager.getSyouhnZokusei(syuMosSyouhnParam.getSyouhncd(),
            syuMosSyouhnParam.getSyouhnsdno());
        mosnaiCheckParam.setSyuSyouhnZokusei(syuSyouhnZokusei);
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setSysKbn(C_SysKbn.SKEI);
        mosnaiCheckParam.setKokutiChkHuyoUmu(C_UmuKbn.NONE);
        mosnaiCheckParam.setSysDate(BizDate.valueOf(20160102));

        checkTblMosSyouhin.exec(mosnaiCheckParam);

        List<HT_HubiMsg> hubiMsgLst = mosnaiCheckParam.getListHubiMsg();

        exNumericEquals(hubiMsgLst.size(), 2, "不備メッセージテーブルエンティティリストのサイズ");

        exStringEquals(hubiMsgLst.get(0).getMosno(), "860000694", "申込番号");
        exNumericEquals(hubiMsgLst.get(0).getRenno(), 1, "連番");
        exStringEquals(hubiMsgLst.get(0).getMessageId(), "THC0032", "メッセージＩＤ");
        exStringEquals(hubiMsgLst.get(0).getHubimsg(), "【特認可能】外貨建て一時払終身保険（即時保障型）　１０年毎利率再設定の保険金額が最高Ｓの１，０２０，３００円をオーバーしています。", "不備メッセージ");
        exClassificationEquals(hubiMsgLst.get(0).getHubisyubetukbn(), C_HubisyubetuKbn.KETHORYU_HUBI, "不備種別区分");

        exStringEquals(hubiMsgLst.get(1).getMosno(), "860000694", "申込番号");
        exNumericEquals(hubiMsgLst.get(1).getRenno(), 2, "連番");
        exStringEquals(hubiMsgLst.get(1).getMessageId(), "THC0031", "メッセージＩＤ");
        exStringEquals(hubiMsgLst.get(1).getHubimsg(), "【特認可能】外貨建て一時払終身保険（即時保障型）　１０年毎利率再設定の保険金額が最低Ｓの４，０００，１００．００ユーロに未達です。", "不備メッセージ");
        exClassificationEquals(hubiMsgLst.get(0).getHubisyubetukbn(), C_HubisyubetuKbn.KETHORYU_HUBI, "不備種別区分");
    }
    @Test
    @TestOrder(5030)
    @Transactional
    public void testExec_E3() {
        MockObjectManager.initialize();
        BzGetAgInfoMockForSinkeiyaku.SYORIPTN = BzGetAgInfoMockForSinkeiyaku.TESTPATTERN4;
        KeisanGaikakanzanMockForSinkeiyaku.SYORIPTN = KeisanGaikakanzanMockForSinkeiyaku.TESTPATTERN1;
        GetKiteiCheckYenkansangkMockForSinkeiyaku.SYORIPTN = GetKiteiCheckYenkansangkMockForSinkeiyaku.TESTPATTERN5;
        CheckSaiteiPMockForSinkeiyaku.SYORIPTN = CheckSaiteiPMockForSinkeiyaku.TESTPATTERN1;
        CheckTblMosSyouhin checkTblMosSyouhin = SWAKInjector.getInstance(CheckTblMosSyouhin.class);

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("860000702");
        List<HT_MosSyouhn> syuMosSyouhnParamLst = syoriCTL.getMosSyouhnsBySyutkkbn(C_SyutkKbn.SYU);
        HT_MosSyouhn syuMosSyouhnParam = syuMosSyouhnParamLst.get(0);
        BM_SyouhnZokusei syuSyouhnZokusei = bizDomManager.getSyouhnZokusei(syuMosSyouhnParam.getSyouhncd(),
            syuMosSyouhnParam.getSyouhnsdno());
        mosnaiCheckParam.setSyuSyouhnZokusei(syuSyouhnZokusei);
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setSysKbn(C_SysKbn.SKEI);
        mosnaiCheckParam.setKokutiChkHuyoUmu(C_UmuKbn.NONE);
        mosnaiCheckParam.setSysDate(BizDate.valueOf(20160102));
        mosnaiCheckParam.setListHubiMsg(new ArrayList<HT_HubiMsg>());
        mosnaiCheckParam.setKosID("JUnitTest");
        mosnaiCheckParam.setKosTime("20160509141230000");

        checkTblMosSyouhin.exec(mosnaiCheckParam);

        List<HT_HubiMsg> hubiMsgLst = mosnaiCheckParam.getListHubiMsg();

        exNumericEquals(hubiMsgLst.size(), 3, "不備メッセージテーブルエンティティリストのサイズ");

        exStringEquals(hubiMsgLst.get(0).getMosno(), "860000702", "申込番号");
        exNumericEquals(hubiMsgLst.get(0).getRenno(), 1, "連番");
        exStringEquals(hubiMsgLst.get(0).getMessageId(), "EHC0019", "メッセージＩＤ");
        exStringEquals(hubiMsgLst.get(0).getHubimsg(), "外貨建て一時払終身保険（即時保障型）　１５年毎利率再設定の１倍は取扱えません。", "不備メッセージ");
        exClassificationEquals(hubiMsgLst.get(0).getHubisyubetukbn(), C_HubisyubetuKbn.KETHORYU_HUBI, "不備種別区分");
        exStringEquals(hubiMsgLst.get(0).getGyoumuKousinsyaId(), "JUnitTest", "業務用更新者ＩＤ");
        exStringEquals(hubiMsgLst.get(0).getGyoumuKousinTime(), "20160509141230000", "業務用更新時間");

        exNumericEquals(hubiMsgLst.get(1).getRenno(), 2, "連番");
        exStringEquals(hubiMsgLst.get(1).getMessageId(), "THC0032", "メッセージＩＤ");
        exStringEquals(hubiMsgLst.get(1).getHubimsg(), "【特認可能】外貨建て一時払終身保険（即時保障型）　１５年毎利率再設定の保険金額が最高Ｓの２０，１００円をオーバーしています。", "不備メッセージ");
        exClassificationEquals(hubiMsgLst.get(1).getHubisyubetukbn(), C_HubisyubetuKbn.KETHORYU_HUBI, "不備種別区分");

        exNumericEquals(hubiMsgLst.get(2).getRenno(), 3, "連番");
        exStringEquals(hubiMsgLst.get(2).getMessageId(), "THC0031", "メッセージＩＤ");
        exStringEquals(hubiMsgLst.get(2).getHubimsg(), "【特認可能】外貨建て一時払終身保険（即時保障型）　１５年毎利率再設定の保険金額が最低Ｓの４，０００，２００．００ユーロに未達です。", "不備メッセージ");
        exClassificationEquals(hubiMsgLst.get(2).getHubisyubetukbn(), C_HubisyubetuKbn.KETHORYU_HUBI, "不備種別区分");
    }
    @Test
    @TestOrder(5040)
    @Transactional
    public void testExec_E4() {
        MockObjectManager.initialize();
        BzGetAgInfoMockForSinkeiyaku.SYORIPTN = BzGetAgInfoMockForSinkeiyaku.TESTPATTERN4;
        KeisanGaikakanzanMockForSinkeiyaku.SYORIPTN = KeisanGaikakanzanMockForSinkeiyaku.TESTPATTERN1;
        GetKiteiCheckYenkansangkMockForSinkeiyaku.SYORIPTN = GetKiteiCheckYenkansangkMockForSinkeiyaku.TESTPATTERN5;
        CheckSaiteiPMockForSinkeiyaku.SYORIPTN = CheckSaiteiPMockForSinkeiyaku.TESTPATTERN1;
        CheckTblMosSyouhin checkTblMosSyouhin = SWAKInjector.getInstance(CheckTblMosSyouhin.class);

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("860000710");
        List<HT_MosSyouhn> syuMosSyouhnParamLst = syoriCTL.getMosSyouhnsBySyutkkbn(C_SyutkKbn.SYU);
        HT_MosSyouhn syuMosSyouhnParam = syuMosSyouhnParamLst.get(0);
        BM_SyouhnZokusei syuSyouhnZokusei = bizDomManager.getSyouhnZokusei(syuMosSyouhnParam.getSyouhncd(),
            syuMosSyouhnParam.getSyouhnsdno());
        mosnaiCheckParam.setSyuSyouhnZokusei(syuSyouhnZokusei);
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setSysKbn(C_SysKbn.SKEI);
        mosnaiCheckParam.setKokutiChkHuyoUmu(C_UmuKbn.NONE);
        mosnaiCheckParam.setSysDate(BizDate.valueOf(20160102));
        mosnaiCheckParam.setListHubiMsg(new ArrayList<HT_HubiMsg>());
        mosnaiCheckParam.setKosID("JUnitTest");
        mosnaiCheckParam.setKosTime("20160509141230000");

        checkTblMosSyouhin.exec(mosnaiCheckParam);

        List<HT_HubiMsg> hubiMsgLst = mosnaiCheckParam.getListHubiMsg();

        exNumericEquals(hubiMsgLst.size(), 2, "不備メッセージテーブルエンティティリストのサイズ");

        exStringEquals(hubiMsgLst.get(0).getMosno(), "860000710", "申込番号");
        exNumericEquals(hubiMsgLst.get(0).getRenno(), 1, "連番");
        exStringEquals(hubiMsgLst.get(0).getMessageId(), "THC0082", "メッセージＩＤ");
        exStringEquals(hubiMsgLst.get(0).getHubimsg(), "【特認可能】外貨建て一時払終身保険（毎年受取型）　１０年毎利率再設定の給付日額が最高日額の２０，２００円をオーバーしています。", "不備メッセージ");
        exClassificationEquals(hubiMsgLst.get(0).getHubisyubetukbn(), C_HubisyubetuKbn.KETHORYU_HUBI, "不備種別区分");
        exStringEquals(hubiMsgLst.get(0).getGyoumuKousinsyaId(), "JUnitTest", "業務用更新者ＩＤ");
        exStringEquals(hubiMsgLst.get(0).getGyoumuKousinTime(), "20160509141230000", "業務用更新時間");

        exStringEquals(hubiMsgLst.get(1).getMosno(), "860000710", "申込番号");
        exNumericEquals(hubiMsgLst.get(1).getRenno(), 2, "連番");
        exStringEquals(hubiMsgLst.get(1).getMessageId(), "THC0081", "メッセージＩＤ");
        exStringEquals(hubiMsgLst.get(1).getHubimsg(), "【特認可能】外貨建て一時払終身保険（毎年受取型）　１０年毎利率再設定の給付日額が最低日額の４，０００，３００．００ユーロに未達です。", "不備メッセージ");
        exClassificationEquals(hubiMsgLst.get(1).getHubisyubetukbn(), C_HubisyubetuKbn.KETHORYU_HUBI, "不備種別区分");
        exStringEquals(hubiMsgLst.get(1).getGyoumuKousinsyaId(), "JUnitTest", "業務用更新者ＩＤ");
        exStringEquals(hubiMsgLst.get(1).getGyoumuKousinTime(), "20160509141230000", "業務用更新時間");
    }
    @Test
    @TestOrder(5050)
    @Transactional
    public void testExec_E5() {
        MockObjectManager.initialize();
        BzGetAgInfoMockForSinkeiyaku.SYORIPTN = BzGetAgInfoMockForSinkeiyaku.TESTPATTERN4;
        KeisanGaikakanzanMockForSinkeiyaku.SYORIPTN = KeisanGaikakanzanMockForSinkeiyaku.TESTPATTERN1;
        GetKiteiCheckYenkansangkMockForSinkeiyaku.SYORIPTN = GetKiteiCheckYenkansangkMockForSinkeiyaku.TESTPATTERN5;
        CheckSaiteiPMockForSinkeiyaku.SYORIPTN = CheckSaiteiPMockForSinkeiyaku.TESTPATTERN1;
        CheckTblMosSyouhin checkTblMosSyouhin = SWAKInjector.getInstance(CheckTblMosSyouhin.class);

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("860000728");
        List<HT_MosSyouhn> syuMosSyouhnParamLst = syoriCTL.getMosSyouhnsBySyutkkbn(C_SyutkKbn.SYU);
        HT_MosSyouhn syuMosSyouhnParam = syuMosSyouhnParamLst.get(0);
        BM_SyouhnZokusei syuSyouhnZokusei = bizDomManager.getSyouhnZokusei(syuMosSyouhnParam.getSyouhncd(),
            syuMosSyouhnParam.getSyouhnsdno());
        mosnaiCheckParam.setSyuSyouhnZokusei(syuSyouhnZokusei);
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setSysKbn(C_SysKbn.SKEI);
        mosnaiCheckParam.setKokutiChkHuyoUmu(C_UmuKbn.NONE);
        mosnaiCheckParam.setSysDate(BizDate.valueOf(20160102));
        mosnaiCheckParam.setListHubiMsg(new ArrayList<HT_HubiMsg>());
        mosnaiCheckParam.setKosID("JUnitTest");
        mosnaiCheckParam.setKosTime("20160509141230000");

        checkTblMosSyouhin.exec(mosnaiCheckParam);

        List<HT_HubiMsg> hubiMsgLst = mosnaiCheckParam.getListHubiMsg();

        exNumericEquals(hubiMsgLst.size(), 2, "不備メッセージテーブルエンティティリストのサイズ");

        exStringEquals(hubiMsgLst.get(0).getMosno(), "860000728", "申込番号");
        exNumericEquals(hubiMsgLst.get(0).getRenno(), 1, "連番");
        exStringEquals(hubiMsgLst.get(0).getMessageId(), "THC0113", "メッセージＩＤ");
        exStringEquals(hubiMsgLst.get(0).getHubimsg(), "【特認可能】外貨建て一時払終身保険（毎年受取型）　１５年毎利率再設定の最高手術給付金額の２０，４００円をオーバーしています。", "不備メッセージ");
        exClassificationEquals(hubiMsgLst.get(0).getHubisyubetukbn(), C_HubisyubetuKbn.KETHORYU_HUBI, "不備種別区分");
        exStringEquals(hubiMsgLst.get(0).getGyoumuKousinsyaId(), "JUnitTest", "業務用更新者ＩＤ");
        exStringEquals(hubiMsgLst.get(0).getGyoumuKousinTime(), "20160509141230000", "業務用更新時間");

        exStringEquals(hubiMsgLst.get(1).getMosno(), "860000728", "申込番号");
        exNumericEquals(hubiMsgLst.get(1).getRenno(), 2, "連番");
        exStringEquals(hubiMsgLst.get(1).getMessageId(), "THC0115", "メッセージＩＤ");
        exStringEquals(hubiMsgLst.get(1).getHubimsg(), "【特認可能】外貨建て一時払終身保険（毎年受取型）　１５年毎利率再設定の給付金額が最低給付金額の４，０００，４００．００ユーロに未達です。", "不備メッセージ");
        exClassificationEquals(hubiMsgLst.get(1).getHubisyubetukbn(), C_HubisyubetuKbn.KETHORYU_HUBI, "不備種別区分");
        exStringEquals(hubiMsgLst.get(1).getGyoumuKousinsyaId(), "JUnitTest", "業務用更新者ＩＤ");
        exStringEquals(hubiMsgLst.get(1).getGyoumuKousinTime(), "20160509141230000", "業務用更新時間");
    }
    @Test
    @TestOrder(5060)
    @Transactional
    public void testExec_E6() {
        MockObjectManager.initialize();
        BzGetAgInfoMockForSinkeiyaku.SYORIPTN = BzGetAgInfoMockForSinkeiyaku.TESTPATTERN4;
        KeisanGaikakanzanMockForSinkeiyaku.SYORIPTN = KeisanGaikakanzanMockForSinkeiyaku.TESTPATTERN1;
        GetKiteiCheckYenkansangkMockForSinkeiyaku.SYORIPTN = GetKiteiCheckYenkansangkMockForSinkeiyaku.TESTPATTERN5;
        CheckSaiteiPMockForSinkeiyaku.SYORIPTN = CheckSaiteiPMockForSinkeiyaku.TESTPATTERN1;
        CheckTblMosSyouhin checkTblMosSyouhin = SWAKInjector.getInstance(CheckTblMosSyouhin.class);

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("860000736");
        List<HT_MosSyouhn> syuMosSyouhnParamLst = syoriCTL.getMosSyouhnsBySyutkkbn(C_SyutkKbn.SYU);
        HT_MosSyouhn syuMosSyouhnParam = syuMosSyouhnParamLst.get(0);
        BM_SyouhnZokusei syuSyouhnZokusei = bizDomManager.getSyouhnZokusei(syuMosSyouhnParam.getSyouhncd(),
            syuMosSyouhnParam.getSyouhnsdno());
        mosnaiCheckParam.setSyuSyouhnZokusei(syuSyouhnZokusei);
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setSysKbn(C_SysKbn.SKEI);
        mosnaiCheckParam.setKokutiChkHuyoUmu(C_UmuKbn.NONE);
        mosnaiCheckParam.setSysDate(BizDate.valueOf(20160102));
        mosnaiCheckParam.setListHubiMsg(new ArrayList<HT_HubiMsg>());
        mosnaiCheckParam.setKosID("JUnitTest");
        mosnaiCheckParam.setKosTime("20160509141230000");

        checkTblMosSyouhin.exec(mosnaiCheckParam);

        List<HT_HubiMsg> hubiMsgLst = mosnaiCheckParam.getListHubiMsg();
        boolean hanteiflg = false;
        exNumericEquals(hubiMsgLst.size(), 3, "不備メッセージテーブルエンティティリストのサイズ");
        for (HT_HubiMsg hubiMsg : hubiMsgLst) {
            if ("THC0115".equals(hubiMsg.getMessageId())) {
                hanteiflg = true;
                exStringEquals(hubiMsg.getMosno(), "860000736", "申込番号");
                exNumericEquals(hubiMsg.getRenno(), 3, "連番");
                exStringEquals(hubiMsg.getMessageId(), "THC0115", "メッセージＩＤ");
                exStringEquals(hubiMsg.getHubimsg(),
                    "【特認可能】外貨建て一時払変額年金保険（ブレンド型）　年金原資最低保証１００％の給付金額が最低給付金額の４，０００，５００．００ユーロに未達です。", "不備メッセージ");
                exClassificationEquals(hubiMsg.getHubisyubetukbn(), C_HubisyubetuKbn.KETHORYU_HUBI, "不備種別区分");
                exStringEquals(hubiMsg.getGyoumuKousinsyaId(), "JUnitTest", "業務用更新者ＩＤ");
                exStringEquals(hubiMsg.getGyoumuKousinTime(), "20160509141230000", "業務用更新時間");
            }
        }
        exBooleanEquals(hanteiflg, true, "メッセージＩＤが'THC0115'のデータが存在します");
    }
    @Test
    @TestOrder(5070)
    @Transactional
    public void testExec_E7() {
        MockObjectManager.initialize();
        BzGetAgInfoMockForSinkeiyaku.SYORIPTN = BzGetAgInfoMockForSinkeiyaku.TESTPATTERN4;
        KeisanGaikakanzanMockForSinkeiyaku.SYORIPTN = KeisanGaikakanzanMockForSinkeiyaku.TESTPATTERN1;
        GetKiteiCheckYenkansangkMockForSinkeiyaku.SYORIPTN = GetKiteiCheckYenkansangkMockForSinkeiyaku.TESTPATTERN5;
        CheckSaiteiPMockForSinkeiyaku.SYORIPTN = CheckSaiteiPMockForSinkeiyaku.TESTPATTERN1;
        CheckTblMosSyouhin checkTblMosSyouhin = SWAKInjector.getInstance(CheckTblMosSyouhin.class);

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("860000744");
        List<HT_MosSyouhn> syuMosSyouhnParamLst = syoriCTL.getMosSyouhnsBySyutkkbn(C_SyutkKbn.SYU);
        HT_MosSyouhn syuMosSyouhnParam = syuMosSyouhnParamLst.get(0);
        BM_SyouhnZokusei syuSyouhnZokusei = bizDomManager.getSyouhnZokusei(syuMosSyouhnParam.getSyouhncd(),
            syuMosSyouhnParam.getSyouhnsdno());
        mosnaiCheckParam.setSyuSyouhnZokusei(syuSyouhnZokusei);
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setSysKbn(C_SysKbn.SKEI);
        mosnaiCheckParam.setKokutiChkHuyoUmu(C_UmuKbn.NONE);
        mosnaiCheckParam.setSysDate(BizDate.valueOf(20160102));
        mosnaiCheckParam.setListHubiMsg(new ArrayList<HT_HubiMsg>());
        mosnaiCheckParam.setKosID("JUnitTest");
        mosnaiCheckParam.setKosTime("20160509141230000");

        checkTblMosSyouhin.exec(mosnaiCheckParam);

        List<HT_HubiMsg> hubiMsgLst = mosnaiCheckParam.getListHubiMsg();
        boolean hanteiflg = false;
        exNumericEquals(hubiMsgLst.size(), 3, "不備メッセージテーブルエンティティリストのサイズ");
        for (HT_HubiMsg hubiMsg : hubiMsgLst) {
            if ("THC0127".equals(hubiMsg.getMessageId())) {
                hanteiflg = true;
                exStringEquals(hubiMsg.getMosno(), "860000744", "申込番号");
                exNumericEquals(hubiMsg.getRenno(), 3, "連番");
                exStringEquals(hubiMsg.getMessageId(), "THC0127", "メッセージＩＤ");
                exStringEquals(hubiMsg.getHubimsg(),
                    "【特認可能】外貨建て一時払変額年金保険（ブレンド型）　年金原資最低保証１２０％の通算限度額が最低通算限度額の４，０００，７００．００ユーロに未達です。", "不備メッセージ");
                exClassificationEquals(hubiMsg.getHubisyubetukbn(), C_HubisyubetuKbn.KETHORYU_HUBI, "不備種別区分");
                exStringEquals(hubiMsg.getGyoumuKousinsyaId(), "JUnitTest", "業務用更新者ＩＤ");
                exStringEquals(hubiMsg.getGyoumuKousinTime(), "20160509141230000", "業務用更新時間");
            }
        }
        exBooleanEquals(hanteiflg, true, "メッセージＩＤが'THC0127'のデータが存在します");
    }
    @Test
    @TestOrder(5080)
    @Transactional
    public void testExec_E8() {
        MockObjectManager.initialize();
        BzGetAgInfoMockForSinkeiyaku.SYORIPTN = BzGetAgInfoMockForSinkeiyaku.TESTPATTERN4;
        KeisanGaikakanzanMockForSinkeiyaku.SYORIPTN = KeisanGaikakanzanMockForSinkeiyaku.TESTPATTERN1;
        GetKiteiCheckYenkansangkMockForSinkeiyaku.SYORIPTN = GetKiteiCheckYenkansangkMockForSinkeiyaku.TESTPATTERN5;
        CheckSaiteiPMockForSinkeiyaku.SYORIPTN = CheckSaiteiPMockForSinkeiyaku.TESTPATTERN1;
        CheckTblMosSyouhin checkTblMosSyouhin = SWAKInjector.getInstance(CheckTblMosSyouhin.class);

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("860000751");
        List<HT_MosSyouhn> syuMosSyouhnParamLst = syoriCTL.getMosSyouhnsBySyutkkbn(C_SyutkKbn.SYU);
        HT_MosSyouhn syuMosSyouhnParam = syuMosSyouhnParamLst.get(0);
        BM_SyouhnZokusei syuSyouhnZokusei = bizDomManager.getSyouhnZokusei(syuMosSyouhnParam.getSyouhncd(),
            syuMosSyouhnParam.getSyouhnsdno());
        mosnaiCheckParam.setSyuSyouhnZokusei(syuSyouhnZokusei);
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setSysKbn(C_SysKbn.SKEI);
        mosnaiCheckParam.setKokutiChkHuyoUmu(C_UmuKbn.NONE);
        mosnaiCheckParam.setSysDate(BizDate.valueOf(20160102));
        mosnaiCheckParam.setListHubiMsg(new ArrayList<HT_HubiMsg>());
        mosnaiCheckParam.setKosID("JUnitTest");
        mosnaiCheckParam.setKosTime("20160509141230000");

        checkTblMosSyouhin.exec(mosnaiCheckParam);

        List<HT_HubiMsg> hubiMsgLst = mosnaiCheckParam.getListHubiMsg();
        boolean hanteiflg = false;
        exNumericEquals(hubiMsgLst.size(), 3, "不備メッセージテーブルエンティティリストのサイズ");
        for (HT_HubiMsg hubiMsg : hubiMsgLst) {
            if ("THC0204".equals(hubiMsg.getMessageId())) {
                hanteiflg = true;
                exStringEquals(hubiMsg.getMosno(), "860000751", "申込番号");
                exNumericEquals(hubiMsg.getRenno(), 3, "連番");
                exStringEquals(hubiMsg.getMessageId(), "THC0204", "メッセージＩＤ");
                exStringEquals(hubiMsg.getHubimsg(),
                    "【特認可能】外貨建て一時払変額年金保険（ブレンド型）　年金原資最低保証１１５％の給付月額が最低給付月額の４，０００，６００．００ユーロに未達です。", "不備メッセージ");
                exClassificationEquals(hubiMsg.getHubisyubetukbn(), C_HubisyubetuKbn.KETHORYU_HUBI, "不備種別区分");
                exStringEquals(hubiMsg.getGyoumuKousinsyaId(), "JUnitTest", "業務用更新者ＩＤ");
                exStringEquals(hubiMsg.getGyoumuKousinTime(), "20160509141230000", "業務用更新時間");
            }
        }
        exBooleanEquals(hanteiflg, true, "メッセージＩＤが'THC0204'のデータが存在します");
    }
    @Test
    @TestOrder(5090)
    @Transactional
    public void testExec_E9() {
        MockObjectManager.initialize();
        BzGetAgInfoMockForSinkeiyaku.SYORIPTN = BzGetAgInfoMockForSinkeiyaku.TESTPATTERN4;
        KeisanGaikakanzanMockForSinkeiyaku.SYORIPTN = KeisanGaikakanzanMockForSinkeiyaku.TESTPATTERN1;
        GetKiteiCheckYenkansangkMockForSinkeiyaku.SYORIPTN = GetKiteiCheckYenkansangkMockForSinkeiyaku.TESTPATTERN5;
        CheckSaiteiPMockForSinkeiyaku.SYORIPTN = CheckSaiteiPMockForSinkeiyaku.TESTPATTERN1;
        CheckTblMosSyouhin checkTblMosSyouhin = SWAKInjector.getInstance(CheckTblMosSyouhin.class);

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("860000769");
        List<HT_MosSyouhn> syuMosSyouhnParamLst = syoriCTL.getMosSyouhnsBySyutkkbn(C_SyutkKbn.SYU);
        HT_MosSyouhn syuMosSyouhnParam = syuMosSyouhnParamLst.get(0);
        BM_SyouhnZokusei syuSyouhnZokusei = bizDomManager.getSyouhnZokusei(syuMosSyouhnParam.getSyouhncd(),
            syuMosSyouhnParam.getSyouhnsdno());
        mosnaiCheckParam.setSyuSyouhnZokusei(syuSyouhnZokusei);
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setSysKbn(C_SysKbn.SKEI);
        mosnaiCheckParam.setKokutiChkHuyoUmu(C_UmuKbn.NONE);
        mosnaiCheckParam.setSysDate(BizDate.valueOf(20160102));
        mosnaiCheckParam.setListHubiMsg(new ArrayList<HT_HubiMsg>());

        checkTblMosSyouhin.exec(mosnaiCheckParam);

        List<HT_HubiMsg> hubiMsgLst = mosnaiCheckParam.getListHubiMsg();

        exNumericEquals(hubiMsgLst.size(), 1, "不備メッセージテーブルエンティティリストのサイズ");
        exStringEquals(hubiMsgLst.get(0).getMosno(), "860000769", "申込番号");
        exNumericEquals(hubiMsgLst.get(0).getRenno(), 1, "連番");
        exStringEquals(hubiMsgLst.get(0).getMessageId(), "EBC0046", "メッセージＩＤ");
        exStringEquals(hubiMsgLst.get(0).getHubimsg(), "据置期間が正しくありません。", "不備メッセージ");
        exClassificationEquals(hubiMsgLst.get(0).getHubisyubetukbn(), C_HubisyubetuKbn.KETHORYU_HUBI, "不備種別区分");
        exClassificationEquals(hubiMsgLst.get(0).getHubisyubetusyousaikbn(), C_HubisyubetusyousaiKbn.NONE,
            "不備種別詳細区分");
    }
    @Test
    @TestOrder(5100)
    @Transactional
    public void testExec_E10() {
        MockObjectManager.initialize();
        BzGetAgInfoMockForSinkeiyaku.SYORIPTN = BzGetAgInfoMockForSinkeiyaku.TESTPATTERN4;
        KeisanGaikakanzanMockForSinkeiyaku.SYORIPTN = KeisanGaikakanzanMockForSinkeiyaku.TESTPATTERN1;
        GetKiteiCheckYenkansangkMockForSinkeiyaku.SYORIPTN = GetKiteiCheckYenkansangkMockForSinkeiyaku.TESTPATTERN5;
        CheckSaiteiPMockForSinkeiyaku.SYORIPTN = CheckSaiteiPMockForSinkeiyaku.TESTPATTERN1;
        CheckTblMosSyouhin checkTblMosSyouhin = SWAKInjector.getInstance(CheckTblMosSyouhin.class);

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("860000777");
        List<HT_MosSyouhn> syuMosSyouhnParamLst = syoriCTL.getMosSyouhnsBySyutkkbn(C_SyutkKbn.SYU);
        HT_MosSyouhn syuMosSyouhnParam = syuMosSyouhnParamLst.get(0);
        BM_SyouhnZokusei syuSyouhnZokusei = bizDomManager.getSyouhnZokusei(syuMosSyouhnParam.getSyouhncd(),
            syuMosSyouhnParam.getSyouhnsdno());
        mosnaiCheckParam.setSyuSyouhnZokusei(syuSyouhnZokusei);
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setSysKbn(C_SysKbn.SKEI);
        mosnaiCheckParam.setKokutiChkHuyoUmu(C_UmuKbn.NONE);
        mosnaiCheckParam.setSysDate(BizDate.valueOf(20160102));
        mosnaiCheckParam.setListHubiMsg(new ArrayList<HT_HubiMsg>());

        checkTblMosSyouhin.exec(mosnaiCheckParam);

        List<HT_HubiMsg> hubiMsgLst = mosnaiCheckParam.getListHubiMsg();

        exNumericEquals(hubiMsgLst.size(), 1, "不備メッセージテーブルエンティティリストのサイズ");
    }
    @Test
    @TestOrder(5110)
    @Transactional
    public void testExec_E11() {
        MockObjectManager.initialize();
        BzGetAgInfoMockForSinkeiyaku.SYORIPTN = BzGetAgInfoMockForSinkeiyaku.TESTPATTERN4;
        KeisanGaikakanzanMockForSinkeiyaku.SYORIPTN = KeisanGaikakanzanMockForSinkeiyaku.TESTPATTERN1;
        GetKiteiCheckYenkansangkMockForSinkeiyaku.SYORIPTN = GetKiteiCheckYenkansangkMockForSinkeiyaku.TESTPATTERN5;
        CheckSaiteiPMockForSinkeiyaku.SYORIPTN = CheckSaiteiPMockForSinkeiyaku.TESTPATTERN1;
        CheckTblMosSyouhin checkTblMosSyouhin = SWAKInjector.getInstance(CheckTblMosSyouhin.class);

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("860000785");
        List<HT_MosSyouhn> syuMosSyouhnParamLst = syoriCTL.getMosSyouhnsBySyutkkbn(C_SyutkKbn.SYU);
        HT_MosSyouhn syuMosSyouhnParam = syuMosSyouhnParamLst.get(0);
        BM_SyouhnZokusei syuSyouhnZokusei = bizDomManager.getSyouhnZokusei(syuMosSyouhnParam.getSyouhncd(),
            syuMosSyouhnParam.getSyouhnsdno());
        mosnaiCheckParam.setSyuSyouhnZokusei(syuSyouhnZokusei);
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setSysKbn(C_SysKbn.SKEI);
        mosnaiCheckParam.setKokutiChkHuyoUmu(C_UmuKbn.NONE);
        mosnaiCheckParam.setSysDate(BizDate.valueOf(20160102));
        mosnaiCheckParam.setListHubiMsg(new ArrayList<HT_HubiMsg>());

        checkTblMosSyouhin.exec(mosnaiCheckParam);

        List<HT_HubiMsg> hubiMsgLst = mosnaiCheckParam.getListHubiMsg();

        exNumericEquals(hubiMsgLst.size(), 1, "不備メッセージテーブルエンティティリストのサイズ");
    }
    @Test(expected = CommonBizAppException.class)
    @TestOrder(5120)
    @Transactional
    public void testExec_E12() {
        MockObjectManager.initialize();
        BzGetAgInfoMockForSinkeiyaku.SYORIPTN = BzGetAgInfoMockForSinkeiyaku.TESTPATTERN4;
        KeisanGaikakanzanMockForSinkeiyaku.SYORIPTN = KeisanGaikakanzanMockForSinkeiyaku.TESTPATTERN1;
        GetKiteiCheckYenkansangkMockForSinkeiyaku.SYORIPTN = GetKiteiCheckYenkansangkMockForSinkeiyaku.TESTPATTERN5;
        CheckSaiteiPMockForSinkeiyaku.SYORIPTN = CheckSaiteiPMockForSinkeiyaku.TESTPATTERN1;
        CheckTblMosSyouhin checkTblMosSyouhin = SWAKInjector.getInstance(CheckTblMosSyouhin.class);

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("860000793");
        List<HT_MosSyouhn> syuMosSyouhnParamLst = syoriCTL.getMosSyouhnsBySyutkkbn(C_SyutkKbn.SYU);
        HT_MosSyouhn syuMosSyouhnParam = syuMosSyouhnParamLst.get(0);
        BM_SyouhnZokusei syuSyouhnZokusei = bizDomManager.getSyouhnZokusei(syuMosSyouhnParam.getSyouhncd(),
            syuMosSyouhnParam.getSyouhnsdno());
        mosnaiCheckParam.setSyuSyouhnZokusei(syuSyouhnZokusei);
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setSysKbn(C_SysKbn.SKEI);
        mosnaiCheckParam.setKokutiChkHuyoUmu(C_UmuKbn.NONE);
        mosnaiCheckParam.setSysDate(BizDate.valueOf(20160102));

        try {
            checkTblMosSyouhin.exec(mosnaiCheckParam);
        } catch (CommonBizAppException e) {
            exStringEquals(e.getMessage(), "システム整合性エラーです。最低Ｓテーブルにデータが見つかりません。", "エラーメッセージ");
            throw e;
        }
    }
    @Test
    @TestOrder(5130)
    @Transactional
    public void testExec_E13() {
        MockObjectManager.initialize();
        BzGetAgInfoMockForSinkeiyaku.SYORIPTN = BzGetAgInfoMockForSinkeiyaku.TESTPATTERN4;
        KeisanGaikakanzanMockForSinkeiyaku.SYORIPTN = KeisanGaikakanzanMockForSinkeiyaku.TESTPATTERN1;
        GetKiteiCheckYenkansangkMockForSinkeiyaku.SYORIPTN = GetKiteiCheckYenkansangkMockForSinkeiyaku.TESTPATTERN5;
        CheckSaiteiPMockForSinkeiyaku.SYORIPTN = CheckSaiteiPMockForSinkeiyaku.TESTPATTERN1;
        CheckTblMosSyouhin checkTblMosSyouhin = SWAKInjector.getInstance(CheckTblMosSyouhin.class);

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("860000801");
        List<HT_MosSyouhn> syuMosSyouhnParamLst = syoriCTL.getMosSyouhnsBySyutkkbn(C_SyutkKbn.SYU);
        HT_MosSyouhn syuMosSyouhnParam = syuMosSyouhnParamLst.get(0);
        BM_SyouhnZokusei syuSyouhnZokusei = bizDomManager.getSyouhnZokusei(syuMosSyouhnParam.getSyouhncd(),
            syuMosSyouhnParam.getSyouhnsdno());
        mosnaiCheckParam.setSyuSyouhnZokusei(syuSyouhnZokusei);
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setSysKbn(C_SysKbn.SKEI);
        mosnaiCheckParam.setKokutiChkHuyoUmu(C_UmuKbn.NONE);
        mosnaiCheckParam.setSysDate(BizDate.valueOf(20160102));
        mosnaiCheckParam.setListHubiMsg(new ArrayList<HT_HubiMsg>());
        mosnaiCheckParam.setKosID("JUnitTest");
        mosnaiCheckParam.setKosTime("20160509141230000");

        checkTblMosSyouhin.exec(mosnaiCheckParam);

        List<HT_HubiMsg> hubiMsgLst = mosnaiCheckParam.getListHubiMsg();

        exNumericEquals(hubiMsgLst.size(), 2, "不備メッセージテーブルエンティティリストのサイズ");

        exStringEquals(hubiMsgLst.get(0).getMosno(), "860000801", "申込番号");
        exNumericEquals(hubiMsgLst.get(0).getRenno(), 1, "連番");
        exStringEquals(hubiMsgLst.get(0).getMessageId(), "EHC0032", "メッセージＩＤ");
        exStringEquals(hubiMsgLst.get(0).getHubimsg(), "外貨建て一時払終身保険（即時保障型）　１０年毎利率再設定の保険金額が最高Ｓの３０，０００円をオーバーしています。", "不備メッセージ");
        exClassificationEquals(hubiMsgLst.get(0).getHubisyubetukbn(), C_HubisyubetuKbn.KETHORYU_HUBI, "不備種別区分");
        exStringEquals(hubiMsgLst.get(0).getGyoumuKousinsyaId(), "JUnitTest", "業務用更新者ＩＤ");
        exStringEquals(hubiMsgLst.get(0).getGyoumuKousinTime(), "20160509141230000", "業務用更新時間");

        exStringEquals(hubiMsgLst.get(1).getMosno(), "860000801", "申込番号");
        exNumericEquals(hubiMsgLst.get(1).getRenno(), 2, "連番");
        exStringEquals(hubiMsgLst.get(1).getMessageId(), "EHC0031", "メッセージＩＤ");
        exStringEquals(hubiMsgLst.get(1).getHubimsg(), "外貨建て一時払終身保険（即時保障型）　１０年毎利率再設定の保険金額が最低Ｓの５，０００，１００．００ユーロに未達です。", "不備メッセージ");
        exClassificationEquals(hubiMsgLst.get(1).getHubisyubetukbn(), C_HubisyubetuKbn.KETHORYU_HUBI, "不備種別区分");
        exStringEquals(hubiMsgLst.get(1).getGyoumuKousinsyaId(), "JUnitTest", "業務用更新者ＩＤ");
        exStringEquals(hubiMsgLst.get(1).getGyoumuKousinTime(), "20160509141230000", "業務用更新時間");
    }
    @Test
    @TestOrder(5140)
    @Transactional
    public void testExec_E14() {
        MockObjectManager.initialize();
        BzGetAgInfoMockForSinkeiyaku.SYORIPTN = BzGetAgInfoMockForSinkeiyaku.TESTPATTERN4;
        KeisanGaikakanzanMockForSinkeiyaku.SYORIPTN = KeisanGaikakanzanMockForSinkeiyaku.TESTPATTERN1;
        GetKiteiCheckYenkansangkMockForSinkeiyaku.SYORIPTN = GetKiteiCheckYenkansangkMockForSinkeiyaku.TESTPATTERN5;
        CheckSaiteiPMockForSinkeiyaku.SYORIPTN = CheckSaiteiPMockForSinkeiyaku.TESTPATTERN1;
        CheckTblMosSyouhin checkTblMosSyouhin = SWAKInjector.getInstance(CheckTblMosSyouhin.class);

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("860000819");
        List<HT_MosSyouhn> syuMosSyouhnParamLst = syoriCTL.getMosSyouhnsBySyutkkbn(C_SyutkKbn.SYU);
        HT_MosSyouhn syuMosSyouhnParam = syuMosSyouhnParamLst.get(0);
        BM_SyouhnZokusei syuSyouhnZokusei = bizDomManager.getSyouhnZokusei(syuMosSyouhnParam.getSyouhncd(),
            syuMosSyouhnParam.getSyouhnsdno());
        mosnaiCheckParam.setSyuSyouhnZokusei(syuSyouhnZokusei);
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setSysKbn(C_SysKbn.SKEI);
        mosnaiCheckParam.setKokutiChkHuyoUmu(C_UmuKbn.NONE);
        mosnaiCheckParam.setSysDate(BizDate.valueOf(20160102));
        mosnaiCheckParam.setListHubiMsg(new ArrayList<HT_HubiMsg>());
        mosnaiCheckParam.setKosID("JUnitTest");
        mosnaiCheckParam.setKosTime("20160509141230000");

        checkTblMosSyouhin.exec(mosnaiCheckParam);

        List<HT_HubiMsg> hubiMsgLst = mosnaiCheckParam.getListHubiMsg();

        exNumericEquals(hubiMsgLst.size(), 3, "不備メッセージテーブルエンティティリストのサイズ");

        exStringEquals(hubiMsgLst.get(0).getMosno(), "860000819", "申込番号");
        exNumericEquals(hubiMsgLst.get(0).getRenno(), 1, "連番");
        exStringEquals(hubiMsgLst.get(0).getMessageId(), "EHC0019", "メッセージＩＤ");
        exStringEquals(hubiMsgLst.get(0).getHubimsg(), "外貨建て一時払終身保険（即時保障型）　１５年毎利率再設定の１倍は取扱えません。", "不備メッセージ");
        exClassificationEquals(hubiMsgLst.get(0).getHubisyubetukbn(), C_HubisyubetuKbn.KETHORYU_HUBI, "不備種別区分");
        exStringEquals(hubiMsgLst.get(0).getGyoumuKousinsyaId(), "JUnitTest", "業務用更新者ＩＤ");
        exStringEquals(hubiMsgLst.get(0).getGyoumuKousinTime(), "20160509141230000", "業務用更新時間");

        exNumericEquals(hubiMsgLst.get(1).getRenno(), 2, "連番");
        exStringEquals(hubiMsgLst.get(1).getMessageId(), "EHC0032", "メッセージＩＤ");
        exStringEquals(hubiMsgLst.get(1).getHubimsg(), "外貨建て一時払終身保険（即時保障型）　１５年毎利率再設定の保険金額が最高Ｓの３０，１００円をオーバーしています。", "不備メッセージ");
        exClassificationEquals(hubiMsgLst.get(1).getHubisyubetukbn(), C_HubisyubetuKbn.KETHORYU_HUBI, "不備種別区分");

        exNumericEquals(hubiMsgLst.get(2).getRenno(), 3, "連番");
        exStringEquals(hubiMsgLst.get(2).getMessageId(), "EHC0031", "メッセージＩＤ");
        exStringEquals(hubiMsgLst.get(2).getHubimsg(), "外貨建て一時払終身保険（即時保障型）　１５年毎利率再設定の保険金額が最低Ｓの５，０００，２００．００ユーロに未達です。", "不備メッセージ");
        exClassificationEquals(hubiMsgLst.get(2).getHubisyubetukbn(), C_HubisyubetuKbn.KETHORYU_HUBI, "不備種別区分");
    }
    @Test
    @TestOrder(5150)
    @Transactional
    public void testExec_E15() {
        MockObjectManager.initialize();
        BzGetAgInfoMockForSinkeiyaku.SYORIPTN = BzGetAgInfoMockForSinkeiyaku.TESTPATTERN4;
        KeisanGaikakanzanMockForSinkeiyaku.SYORIPTN = KeisanGaikakanzanMockForSinkeiyaku.TESTPATTERN1;
        GetKiteiCheckYenkansangkMockForSinkeiyaku.SYORIPTN = GetKiteiCheckYenkansangkMockForSinkeiyaku.TESTPATTERN5;
        CheckSaiteiPMockForSinkeiyaku.SYORIPTN = CheckSaiteiPMockForSinkeiyaku.TESTPATTERN1;
        CheckTblMosSyouhin checkTblMosSyouhin = SWAKInjector.getInstance(CheckTblMosSyouhin.class);

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("860000827");
        List<HT_MosSyouhn> syuMosSyouhnParamLst = syoriCTL.getMosSyouhnsBySyutkkbn(C_SyutkKbn.SYU);
        HT_MosSyouhn syuMosSyouhnParam = syuMosSyouhnParamLst.get(0);
        BM_SyouhnZokusei syuSyouhnZokusei = bizDomManager.getSyouhnZokusei(syuMosSyouhnParam.getSyouhncd(),
            syuMosSyouhnParam.getSyouhnsdno());
        mosnaiCheckParam.setSyuSyouhnZokusei(syuSyouhnZokusei);
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setSysKbn(C_SysKbn.SKEI);
        mosnaiCheckParam.setKokutiChkHuyoUmu(C_UmuKbn.NONE);
        mosnaiCheckParam.setSysDate(BizDate.valueOf(20160102));
        mosnaiCheckParam.setListHubiMsg(new ArrayList<HT_HubiMsg>());
        mosnaiCheckParam.setKosID("JUnitTest");
        mosnaiCheckParam.setKosTime("20160509141230000");

        checkTblMosSyouhin.exec(mosnaiCheckParam);

        List<HT_HubiMsg> hubiMsgLst = mosnaiCheckParam.getListHubiMsg();

        exNumericEquals(hubiMsgLst.size(), 2, "不備メッセージテーブルエンティティリストのサイズ");

        exStringEquals(hubiMsgLst.get(0).getMosno(), "860000827", "申込番号");
        exNumericEquals(hubiMsgLst.get(0).getRenno(), 1, "連番");
        exStringEquals(hubiMsgLst.get(0).getMessageId(), "EHC0082", "メッセージＩＤ");
        exStringEquals(hubiMsgLst.get(0).getHubimsg(), "外貨建て一時払終身保険（毎年受取型）　１０年毎利率再設定の給付日額が最高日額の３０，２００円をオーバーしています。", "不備メッセージ");
        exClassificationEquals(hubiMsgLst.get(0).getHubisyubetukbn(), C_HubisyubetuKbn.KETHORYU_HUBI, "不備種別区分");
        exStringEquals(hubiMsgLst.get(0).getGyoumuKousinsyaId(), "JUnitTest", "業務用更新者ＩＤ");
        exStringEquals(hubiMsgLst.get(0).getGyoumuKousinTime(), "20160509141230000", "業務用更新時間");

        exStringEquals(hubiMsgLst.get(1).getMosno(), "860000827", "申込番号");
        exNumericEquals(hubiMsgLst.get(1).getRenno(), 2, "連番");
        exStringEquals(hubiMsgLst.get(1).getMessageId(), "EHC0081", "メッセージＩＤ");
        exStringEquals(hubiMsgLst.get(1).getHubimsg(), "外貨建て一時払終身保険（毎年受取型）　１０年毎利率再設定の給付日額が最低日額の５，０００，３００．００ユーロに未達です。", "不備メッセージ");
        exClassificationEquals(hubiMsgLst.get(1).getHubisyubetukbn(), C_HubisyubetuKbn.KETHORYU_HUBI, "不備種別区分");
        exStringEquals(hubiMsgLst.get(1).getGyoumuKousinsyaId(), "JUnitTest", "業務用更新者ＩＤ");
        exStringEquals(hubiMsgLst.get(1).getGyoumuKousinTime(), "20160509141230000", "業務用更新時間");
    }
    @Test
    @TestOrder(5160)
    @Transactional
    public void testExec_E16() {
        MockObjectManager.initialize();
        BzGetAgInfoMockForSinkeiyaku.SYORIPTN = BzGetAgInfoMockForSinkeiyaku.TESTPATTERN4;
        KeisanGaikakanzanMockForSinkeiyaku.SYORIPTN = KeisanGaikakanzanMockForSinkeiyaku.TESTPATTERN1;
        GetKiteiCheckYenkansangkMockForSinkeiyaku.SYORIPTN = GetKiteiCheckYenkansangkMockForSinkeiyaku.TESTPATTERN5;
        CheckSaiteiPMockForSinkeiyaku.SYORIPTN = CheckSaiteiPMockForSinkeiyaku.TESTPATTERN1;
        CheckTblMosSyouhin checkTblMosSyouhin = SWAKInjector.getInstance(CheckTblMosSyouhin.class);

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("860000835");
        List<HT_MosSyouhn> syuMosSyouhnParamLst = syoriCTL.getMosSyouhnsBySyutkkbn(C_SyutkKbn.SYU);
        HT_MosSyouhn syuMosSyouhnParam = syuMosSyouhnParamLst.get(0);
        BM_SyouhnZokusei syuSyouhnZokusei = bizDomManager.getSyouhnZokusei(syuMosSyouhnParam.getSyouhncd(),
            syuMosSyouhnParam.getSyouhnsdno());
        mosnaiCheckParam.setSyuSyouhnZokusei(syuSyouhnZokusei);
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setSysKbn(C_SysKbn.SKEI);
        mosnaiCheckParam.setKokutiChkHuyoUmu(C_UmuKbn.NONE);
        mosnaiCheckParam.setSysDate(BizDate.valueOf(20160102));
        mosnaiCheckParam.setListHubiMsg(new ArrayList<HT_HubiMsg>());
        mosnaiCheckParam.setKosID("JUnitTest");
        mosnaiCheckParam.setKosTime("20160509141230000");

        checkTblMosSyouhin.exec(mosnaiCheckParam);

        List<HT_HubiMsg> hubiMsgLst = mosnaiCheckParam.getListHubiMsg();

        exNumericEquals(hubiMsgLst.size(), 2, "不備メッセージテーブルエンティティリストのサイズ");

        exStringEquals(hubiMsgLst.get(0).getMosno(), "860000835", "申込番号");
        exNumericEquals(hubiMsgLst.get(0).getRenno(), 1, "連番");
        exStringEquals(hubiMsgLst.get(0).getMessageId(), "EHC0113", "メッセージＩＤ");
        exStringEquals(hubiMsgLst.get(0).getHubimsg(), "外貨建て一時払終身保険（毎年受取型）　１５年毎利率再設定の最高手術給付金額の３０，３００円をオーバーしています。", "不備メッセージ");
        exClassificationEquals(hubiMsgLst.get(0).getHubisyubetukbn(), C_HubisyubetuKbn.KETHORYU_HUBI, "不備種別区分");
        exStringEquals(hubiMsgLst.get(0).getGyoumuKousinsyaId(), "JUnitTest", "業務用更新者ＩＤ");
        exStringEquals(hubiMsgLst.get(0).getGyoumuKousinTime(), "20160509141230000", "業務用更新時間");

        exStringEquals(hubiMsgLst.get(1).getMosno(), "860000835", "申込番号");
        exNumericEquals(hubiMsgLst.get(1).getRenno(), 2, "連番");
        exStringEquals(hubiMsgLst.get(1).getMessageId(), "EHC0115", "メッセージＩＤ");
        exStringEquals(hubiMsgLst.get(1).getHubimsg(), "外貨建て一時払終身保険（毎年受取型）　１５年毎利率再設定の給付金額が最低給付金額の５，０００，４００．００ユーロに未達です。", "不備メッセージ");
        exClassificationEquals(hubiMsgLst.get(1).getHubisyubetukbn(), C_HubisyubetuKbn.KETHORYU_HUBI, "不備種別区分");
        exStringEquals(hubiMsgLst.get(1).getGyoumuKousinsyaId(), "JUnitTest", "業務用更新者ＩＤ");
        exStringEquals(hubiMsgLst.get(1).getGyoumuKousinTime(), "20160509141230000", "業務用更新時間");
    }
    @Test
    @TestOrder(5170)
    @Transactional
    public void testExec_E17() {
        MockObjectManager.initialize();
        BzGetAgInfoMockForSinkeiyaku.SYORIPTN = BzGetAgInfoMockForSinkeiyaku.TESTPATTERN4;
        KeisanGaikakanzanMockForSinkeiyaku.SYORIPTN = KeisanGaikakanzanMockForSinkeiyaku.TESTPATTERN1;
        GetKiteiCheckYenkansangkMockForSinkeiyaku.SYORIPTN = GetKiteiCheckYenkansangkMockForSinkeiyaku.TESTPATTERN5;
        CheckSaiteiPMockForSinkeiyaku.SYORIPTN = CheckSaiteiPMockForSinkeiyaku.TESTPATTERN1;
        CheckTblMosSyouhin checkTblMosSyouhin = SWAKInjector.getInstance(CheckTblMosSyouhin.class);

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("860000843");
        List<HT_MosSyouhn> syuMosSyouhnParamLst = syoriCTL.getMosSyouhnsBySyutkkbn(C_SyutkKbn.SYU);
        HT_MosSyouhn syuMosSyouhnParam = syuMosSyouhnParamLst.get(0);
        BM_SyouhnZokusei syuSyouhnZokusei = bizDomManager.getSyouhnZokusei(syuMosSyouhnParam.getSyouhncd(),
            syuMosSyouhnParam.getSyouhnsdno());
        mosnaiCheckParam.setSyuSyouhnZokusei(syuSyouhnZokusei);
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setSysKbn(C_SysKbn.SKEI);
        mosnaiCheckParam.setKokutiChkHuyoUmu(C_UmuKbn.NONE);
        mosnaiCheckParam.setSysDate(BizDate.valueOf(20160102));
        mosnaiCheckParam.setListHubiMsg(new ArrayList<HT_HubiMsg>());
        mosnaiCheckParam.setKosID("JUnitTest");
        mosnaiCheckParam.setKosTime("20160509141230000");

        checkTblMosSyouhin.exec(mosnaiCheckParam);

        List<HT_HubiMsg> hubiMsgLst = mosnaiCheckParam.getListHubiMsg();
        boolean hanteiflg = false;
        exNumericEquals(hubiMsgLst.size(), 3, "不備メッセージテーブルエンティティリストのサイズ");
        for (HT_HubiMsg hubiMsg : hubiMsgLst) {
            if ("EHC0115".equals(hubiMsg.getMessageId())) {
                hanteiflg = true;
                exStringEquals(hubiMsg.getMosno(), "860000843", "申込番号");
                exNumericEquals(hubiMsg.getRenno(), 3, "連番");
                exStringEquals(hubiMsg.getMessageId(), "EHC0115", "メッセージＩＤ");
                exStringEquals(hubiMsg.getHubimsg(),
                    "外貨建て一時払変額年金保険（ブレンド型）　年金原資最低保証１００％の給付金額が最低給付金額の５，０００，５００．００ユーロに未達です。", "不備メッセージ");
                exClassificationEquals(hubiMsg.getHubisyubetukbn(), C_HubisyubetuKbn.KETHORYU_HUBI, "不備種別区分");
                exStringEquals(hubiMsg.getGyoumuKousinsyaId(), "JUnitTest", "業務用更新者ＩＤ");
                exStringEquals(hubiMsg.getGyoumuKousinTime(), "20160509141230000", "業務用更新時間");
            }
        }
        exBooleanEquals(hanteiflg, true, "メッセージＩＤが'EHC0115'のデータが存在します");
    }
    @Test
    @TestOrder(5180)
    @Transactional
    public void testExec_E18() {
        MockObjectManager.initialize();
        BzGetAgInfoMockForSinkeiyaku.SYORIPTN = BzGetAgInfoMockForSinkeiyaku.TESTPATTERN4;
        KeisanGaikakanzanMockForSinkeiyaku.SYORIPTN = KeisanGaikakanzanMockForSinkeiyaku.TESTPATTERN1;
        GetKiteiCheckYenkansangkMockForSinkeiyaku.SYORIPTN = GetKiteiCheckYenkansangkMockForSinkeiyaku.TESTPATTERN5;
        CheckSaiteiPMockForSinkeiyaku.SYORIPTN = CheckSaiteiPMockForSinkeiyaku.TESTPATTERN1;
        CheckTblMosSyouhin checkTblMosSyouhin = SWAKInjector.getInstance(CheckTblMosSyouhin.class);

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("860000850");
        List<HT_MosSyouhn> syuMosSyouhnParamLst = syoriCTL.getMosSyouhnsBySyutkkbn(C_SyutkKbn.SYU);
        HT_MosSyouhn syuMosSyouhnParam = syuMosSyouhnParamLst.get(0);
        BM_SyouhnZokusei syuSyouhnZokusei = bizDomManager.getSyouhnZokusei(syuMosSyouhnParam.getSyouhncd(),
            syuMosSyouhnParam.getSyouhnsdno());
        mosnaiCheckParam.setSyuSyouhnZokusei(syuSyouhnZokusei);
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setSysKbn(C_SysKbn.SKEI);
        mosnaiCheckParam.setKokutiChkHuyoUmu(C_UmuKbn.NONE);
        mosnaiCheckParam.setSysDate(BizDate.valueOf(20160102));
        mosnaiCheckParam.setListHubiMsg(new ArrayList<HT_HubiMsg>());
        mosnaiCheckParam.setKosID("JUnitTest");
        mosnaiCheckParam.setKosTime("20160509141230000");

        checkTblMosSyouhin.exec(mosnaiCheckParam);

        List<HT_HubiMsg> hubiMsgLst = mosnaiCheckParam.getListHubiMsg();
        boolean hanteiflg = false;
        exNumericEquals(hubiMsgLst.size(), 3, "不備メッセージテーブルエンティティリストのサイズ");
        for (HT_HubiMsg hubiMsg : hubiMsgLst) {
            if ("EHC0127".equals(hubiMsg.getMessageId())) {
                hanteiflg = true;
                exStringEquals(hubiMsg.getMosno(), "860000850", "申込番号");
                exNumericEquals(hubiMsg.getRenno(), 3, "連番");
                exStringEquals(hubiMsg.getMessageId(), "EHC0127", "メッセージＩＤ");
                exStringEquals(hubiMsg.getHubimsg(),
                    "外貨建て一時払変額年金保険（ブレンド型）　年金原資最低保証１２０％の通算限度額が最低通算限度額の５，０００，７００．００ユーロに未達です。", "不備メッセージ");
                exClassificationEquals(hubiMsg.getHubisyubetukbn(), C_HubisyubetuKbn.KETHORYU_HUBI, "不備種別区分");
                exStringEquals(hubiMsg.getGyoumuKousinsyaId(), "JUnitTest", "業務用更新者ＩＤ");
                exStringEquals(hubiMsg.getGyoumuKousinTime(), "20160509141230000", "業務用更新時間");
            }
        }
        exBooleanEquals(hanteiflg, true, "メッセージＩＤが'EHC0127'のデータが存在します");
    }
    @Test
    @TestOrder(5190)
    @Transactional
    public void testExec_E19() {
        MockObjectManager.initialize();
        BzGetAgInfoMockForSinkeiyaku.SYORIPTN = BzGetAgInfoMockForSinkeiyaku.TESTPATTERN4;
        KeisanGaikakanzanMockForSinkeiyaku.SYORIPTN = KeisanGaikakanzanMockForSinkeiyaku.TESTPATTERN1;
        GetKiteiCheckYenkansangkMockForSinkeiyaku.SYORIPTN = GetKiteiCheckYenkansangkMockForSinkeiyaku.TESTPATTERN5;
        CheckSaiteiPMockForSinkeiyaku.SYORIPTN = CheckSaiteiPMockForSinkeiyaku.TESTPATTERN1;
        CheckTblMosSyouhin checkTblMosSyouhin = SWAKInjector.getInstance(CheckTblMosSyouhin.class);

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("860000868");
        List<HT_MosSyouhn> syuMosSyouhnParamLst = syoriCTL.getMosSyouhnsBySyutkkbn(C_SyutkKbn.SYU);
        HT_MosSyouhn syuMosSyouhnParam = syuMosSyouhnParamLst.get(0);
        BM_SyouhnZokusei syuSyouhnZokusei = bizDomManager.getSyouhnZokusei(syuMosSyouhnParam.getSyouhncd(),
            syuMosSyouhnParam.getSyouhnsdno());
        mosnaiCheckParam.setSyuSyouhnZokusei(syuSyouhnZokusei);
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setSysKbn(C_SysKbn.SKEI);
        mosnaiCheckParam.setKokutiChkHuyoUmu(C_UmuKbn.NONE);
        mosnaiCheckParam.setSysDate(BizDate.valueOf(20160102));
        mosnaiCheckParam.setListHubiMsg(new ArrayList<HT_HubiMsg>());
        mosnaiCheckParam.setKosID("JUnitTest");
        mosnaiCheckParam.setKosTime("20160509141230000");

        checkTblMosSyouhin.exec(mosnaiCheckParam);

        List<HT_HubiMsg> hubiMsgLst = mosnaiCheckParam.getListHubiMsg();
        boolean hanteiflg = false;
        exNumericEquals(hubiMsgLst.size(), 2, "不備メッセージテーブルエンティティリストのサイズ");
        for (HT_HubiMsg hubiMsg : hubiMsgLst) {
            if ("EHC0204".equals(hubiMsg.getMessageId())) {
                hanteiflg = true;
                exStringEquals(hubiMsg.getMosno(), "860000868", "申込番号");
                exNumericEquals(hubiMsg.getRenno(), 2, "連番");
                exStringEquals(hubiMsg.getMessageId(), "EHC0204", "メッセージＩＤ");
                exStringEquals(hubiMsg.getHubimsg(),
                    "外貨建て一時払変額年金保険（ブレンド型）　年金原資最低保証１１５％の給付月額が最低給付月額の５，０００，６００．００ユーロに未達です。", "不備メッセージ");
                exClassificationEquals(hubiMsg.getHubisyubetukbn(), C_HubisyubetuKbn.KETHORYU_HUBI, "不備種別区分");
                exStringEquals(hubiMsg.getGyoumuKousinsyaId(), "JUnitTest", "業務用更新者ＩＤ");
                exStringEquals(hubiMsg.getGyoumuKousinTime(), "20160509141230000", "業務用更新時間");
            }
        }
        exBooleanEquals(hanteiflg, true, "メッセージＩＤが'EHC0204'のデータが存在します");
    }
    @Test
    @TestOrder(5200)
    @Transactional
    public void testExec_E20() {
        MockObjectManager.initialize();
        BzGetAgInfoMockForSinkeiyaku.SYORIPTN = BzGetAgInfoMockForSinkeiyaku.TESTPATTERN4;
        KeisanGaikakanzanMockForSinkeiyaku.SYORIPTN = KeisanGaikakanzanMockForSinkeiyaku.TESTPATTERN1;
        GetKiteiCheckYenkansangkMockForSinkeiyaku.SYORIPTN = GetKiteiCheckYenkansangkMockForSinkeiyaku.TESTPATTERN5;
        CheckSaiteiPMockForSinkeiyaku.SYORIPTN = CheckSaiteiPMockForSinkeiyaku.TESTPATTERN1;
        CheckTblMosSyouhin checkTblMosSyouhin = SWAKInjector.getInstance(CheckTblMosSyouhin.class);

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("860000876");
        List<HT_MosSyouhn> syuMosSyouhnParamLst = syoriCTL.getMosSyouhnsBySyutkkbn(C_SyutkKbn.SYU);
        HT_MosSyouhn syuMosSyouhnParam = syuMosSyouhnParamLst.get(0);
        BM_SyouhnZokusei syuSyouhnZokusei = bizDomManager.getSyouhnZokusei(syuMosSyouhnParam.getSyouhncd(),
            syuMosSyouhnParam.getSyouhnsdno());
        mosnaiCheckParam.setSyuSyouhnZokusei(syuSyouhnZokusei);
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setSysKbn(C_SysKbn.SKEI);
        mosnaiCheckParam.setKokutiChkHuyoUmu(C_UmuKbn.NONE);
        mosnaiCheckParam.setSysDate(BizDate.valueOf(20160102));
        mosnaiCheckParam.setListHubiMsg(new ArrayList<HT_HubiMsg>());

        checkTblMosSyouhin.exec(mosnaiCheckParam);

        List<HT_HubiMsg> hubiMsgLst = mosnaiCheckParam.getListHubiMsg();

        exNumericEquals(hubiMsgLst.size(), 1, "不備メッセージテーブルエンティティリストのサイズ");
        exStringEquals(hubiMsgLst.get(0).getMosno(), "860000876", "申込番号");
        exNumericEquals(hubiMsgLst.get(0).getRenno(), 1, "連番");
        exStringEquals(hubiMsgLst.get(0).getMessageId(), "EBC0046", "メッセージＩＤ");
        exStringEquals(hubiMsgLst.get(0).getHubimsg(), "据置期間が正しくありません。", "不備メッセージ");
        exClassificationEquals(hubiMsgLst.get(0).getHubisyubetukbn(), C_HubisyubetuKbn.KETHORYU_HUBI, "不備種別区分");
        exClassificationEquals(hubiMsgLst.get(0).getHubisyubetusyousaikbn(), C_HubisyubetusyousaiKbn.NONE,
            "不備種別詳細区分");
    }
    @Test
    @TestOrder(5210)
    @Transactional
    public void testExec_E21() {
        MockObjectManager.initialize();
        BzGetAgInfoMockForSinkeiyaku.SYORIPTN = BzGetAgInfoMockForSinkeiyaku.TESTPATTERN4;
        KeisanGaikakanzanMockForSinkeiyaku.SYORIPTN = null;
        GetKiteiCheckYenkansangkMockForSinkeiyaku.SYORIPTN = GetKiteiCheckYenkansangkMockForSinkeiyaku.TESTPATTERN5;
        CheckSaiteiPMockForSinkeiyaku.SYORIPTN = CheckSaiteiPMockForSinkeiyaku.TESTPATTERN1;
        CheckTblMosSyouhin checkTblMosSyouhin = SWAKInjector.getInstance(CheckTblMosSyouhin.class);

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("980000061");
        List<HT_MosSyouhn> syuMosSyouhnParamLst = syoriCTL.getMosSyouhnsBySyutkkbn(C_SyutkKbn.SYU);
        HT_MosSyouhn syuMosSyouhnParam = syuMosSyouhnParamLst.get(0);
        BM_SyouhnZokusei syuSyouhnZokusei = bizDomManager.getSyouhnZokusei(syuMosSyouhnParam.getSyouhncd(),
            syuMosSyouhnParam.getSyouhnsdno());
        mosnaiCheckParam.setSyuSyouhnZokusei(syuSyouhnZokusei);
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setSysKbn(C_SysKbn.ESHIEN);
        mosnaiCheckParam.setKokutiChkHuyoUmu(C_UmuKbn.NONE);
        mosnaiCheckParam.setSysDate(BizDate.valueOf(20160102));

        checkTblMosSyouhin.exec(mosnaiCheckParam);

        exClassificationEquals(mosnaiCheckParam.getSekmossakuseiErroutKbn(), C_SekmossakuseiErroutKbn.GAMEN, "設計書申込書作成エラー出力区分");
        exStringEquals(mosnaiCheckParam.getSekmossakuseiErrmsg1(), "", "設計書申込書作成エラーメッセージ１");
        exStringEquals(mosnaiCheckParam.getSekmossakuseiErrmsg2(), "最低保険金額未達　保険金額は４，０００，１００ユーロ以上にしてください", "設計書申込書作成エラーメッセージ２");
        exClassificationEquals(mosnaiCheckParam.getKouzokuSyoriJikkouKbn(), C_KouzokujkKbn.NONE, "後続処理実行区分");
    }
    @Test(expected = CommonBizAppException.class)
    @TestOrder(6010)
    @Transactional
    public void testExec_F1() {
        MockObjectManager.initialize();
        BzGetAgInfoMockForSinkeiyaku.SYORIPTN = BzGetAgInfoMockForSinkeiyaku.TESTPATTERN4;
        KeisanGaikakanzanMockForSinkeiyaku.SYORIPTN = KeisanGaikakanzanMockForSinkeiyaku.TESTPATTERN1;
        GetKiteiCheckYenkansangkMockForSinkeiyaku.SYORIPTN = GetKiteiCheckYenkansangkMockForSinkeiyaku.TESTPATTERN1;
        CheckSaiteiPMockForSinkeiyaku.SYORIPTN = CheckSaiteiPMockForSinkeiyaku.TESTPATTERN1;
        CheckTblMosSyouhin checkTblMosSyouhin = SWAKInjector.getInstance(CheckTblMosSyouhin.class);

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("860000884");
        List<HT_MosSyouhn> syuMosSyouhnParamLst = syoriCTL.getMosSyouhnsBySyutkkbn(C_SyutkKbn.SYU);
        HT_MosSyouhn syuMosSyouhnParam = syuMosSyouhnParamLst.get(0);
        BM_SyouhnZokusei syuSyouhnZokusei = bizDomManager.getSyouhnZokusei(syuMosSyouhnParam.getSyouhncd(),
            syuMosSyouhnParam.getSyouhnsdno());
        mosnaiCheckParam.setSyuSyouhnZokusei(syuSyouhnZokusei);
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setSysKbn(C_SysKbn.SKEI);
        mosnaiCheckParam.setKokutiChkHuyoUmu(C_UmuKbn.NONE);
        mosnaiCheckParam.setSysDate(BizDate.valueOf(20160102));

        try {
            checkTblMosSyouhin.exec(mosnaiCheckParam);
        } catch (CommonBizAppException e) {
            exStringEquals(e.getMessage(), "システム整合性エラーです。代表申込番号の異常", "エラーメッセージ");
            throw e;
        }
    }
    @Test
    @TestOrder(6020)
    @Transactional
    public void testExec_F2() {
        MockObjectManager.initialize();
        BzGetAgInfoMockForSinkeiyaku.SYORIPTN = BzGetAgInfoMockForSinkeiyaku.TESTPATTERN4;
        KeisanGaikakanzanMockForSinkeiyaku.SYORIPTN = KeisanGaikakanzanMockForSinkeiyaku.TESTPATTERN1;
        GetKiteiCheckYenkansangkMockForSinkeiyaku.SYORIPTN = GetKiteiCheckYenkansangkMockForSinkeiyaku.TESTPATTERN1;
        CheckSaiteiPMockForSinkeiyaku.SYORIPTN = CheckSaiteiPMockForSinkeiyaku.TESTPATTERN1;
        CheckTblMosSyouhin checkTblMosSyouhin = SWAKInjector.getInstance(CheckTblMosSyouhin.class);

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("860000892");
        List<HT_MosSyouhn> syuMosSyouhnParamLst = syoriCTL.getMosSyouhnsBySyutkkbn(C_SyutkKbn.SYU);
        HT_MosSyouhn syuMosSyouhnParam = syuMosSyouhnParamLst.get(0);
        BM_SyouhnZokusei syuSyouhnZokusei = bizDomManager.getSyouhnZokusei(syuMosSyouhnParam.getSyouhncd(),
            syuMosSyouhnParam.getSyouhnsdno());
        mosnaiCheckParam.setSyuSyouhnZokusei(syuSyouhnZokusei);
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setSysKbn(C_SysKbn.SKEI);
        mosnaiCheckParam.setKokutiChkHuyoUmu(C_UmuKbn.NONE);
        mosnaiCheckParam.setSysDate(BizDate.valueOf(20160102));
        mosnaiCheckParam.setListHubiMsg(new ArrayList<HT_HubiMsg>());
        mosnaiCheckParam.setKosID("JUnitTest");
        mosnaiCheckParam.setKosTime("20160509141230000");

        checkTblMosSyouhin.exec(mosnaiCheckParam);

        List<HT_HubiMsg> hubiMsgLst = mosnaiCheckParam.getListHubiMsg();

        exNumericEquals(hubiMsgLst.size(), 1, "不備メッセージテーブルエンティティリストのサイズ");

        exStringEquals(hubiMsgLst.get(0).getMosno(), "860000892", "申込番号");
        exNumericEquals(hubiMsgLst.get(0).getRenno(), 1, "連番");
        exStringEquals(hubiMsgLst.get(0).getMessageId(), "EHC0085", "メッセージＩＤ");
        exStringEquals(hubiMsgLst.get(0).getHubimsg(), "事業一括の取扱商品ではありません。", "不備メッセージ");
        exClassificationEquals(hubiMsgLst.get(0).getHubisyubetukbn(), C_HubisyubetuKbn.KETHORYU_HUBI, "不備種別区分");
        exStringEquals(hubiMsgLst.get(0).getGyoumuKousinsyaId(), "JUnitTest", "業務用更新者ＩＤ");
        exStringEquals(hubiMsgLst.get(0).getGyoumuKousinTime(), "20160509141230000", "業務用更新時間");
    }
    @Test
    @TestOrder(6030)
    @Transactional
    public void testExec_F3() {
        MockObjectManager.initialize();
        BzGetAgInfoMockForSinkeiyaku.SYORIPTN = BzGetAgInfoMockForSinkeiyaku.TESTPATTERN4;
        KeisanGaikakanzanMockForSinkeiyaku.SYORIPTN = KeisanGaikakanzanMockForSinkeiyaku.TESTPATTERN1;
        GetKiteiCheckYenkansangkMockForSinkeiyaku.SYORIPTN = GetKiteiCheckYenkansangkMockForSinkeiyaku.TESTPATTERN1;
        CheckSaiteiPMockForSinkeiyaku.SYORIPTN = CheckSaiteiPMockForSinkeiyaku.TESTPATTERN1;
        CheckTblMosSyouhin checkTblMosSyouhin = SWAKInjector.getInstance(CheckTblMosSyouhin.class);

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("860000900");
        List<HT_MosSyouhn> syuMosSyouhnParamLst = syoriCTL.getMosSyouhnsBySyutkkbn(C_SyutkKbn.SYU);
        HT_MosSyouhn syuMosSyouhnParam = syuMosSyouhnParamLst.get(0);
        BM_SyouhnZokusei syuSyouhnZokusei = bizDomManager.getSyouhnZokusei(syuMosSyouhnParam.getSyouhncd(),
            syuMosSyouhnParam.getSyouhnsdno());
        mosnaiCheckParam.setSyuSyouhnZokusei(syuSyouhnZokusei);
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setSysKbn(C_SysKbn.SKEI);
        mosnaiCheckParam.setKokutiChkHuyoUmu(C_UmuKbn.NONE);
        mosnaiCheckParam.setSysDate(BizDate.valueOf(20160102));
        mosnaiCheckParam.setListHubiMsg(new ArrayList<HT_HubiMsg>());
        mosnaiCheckParam.setKosID("JUnitTest");
        mosnaiCheckParam.setKosTime("20160509141230000");

        checkTblMosSyouhin.exec(mosnaiCheckParam);

        List<HT_HubiMsg> hubiMsgLst = mosnaiCheckParam.getListHubiMsg();

        exNumericEquals(hubiMsgLst.size(), 1, "不備メッセージテーブルエンティティリストのサイズ");

        exStringEquals(hubiMsgLst.get(0).getMosno(), "860000900", "申込番号");
        exNumericEquals(hubiMsgLst.get(0).getRenno(), 1, "連番");
        exStringEquals(hubiMsgLst.get(0).getMessageId(), "EHC0084", "メッセージＩＤ");
        exStringEquals(hubiMsgLst.get(0).getHubimsg(), "主契約商品が代表申込番号の商品と相違しています。", "不備メッセージ");
        exClassificationEquals(hubiMsgLst.get(0).getHubisyubetukbn(), C_HubisyubetuKbn.KETHORYU_HUBI, "不備種別区分");
        exStringEquals(hubiMsgLst.get(0).getGyoumuKousinsyaId(), "JUnitTest", "業務用更新者ＩＤ");
        exStringEquals(hubiMsgLst.get(0).getGyoumuKousinTime(), "20160509141230000", "業務用更新時間");
    }
    @Test
    @TestOrder(6040)
    @Transactional
    public void testExec_F4() {
        MockObjectManager.initialize();
        BzGetAgInfoMockForSinkeiyaku.SYORIPTN = BzGetAgInfoMockForSinkeiyaku.TESTPATTERN4;
        KeisanGaikakanzanMockForSinkeiyaku.SYORIPTN = KeisanGaikakanzanMockForSinkeiyaku.TESTPATTERN1;
        GetKiteiCheckYenkansangkMockForSinkeiyaku.SYORIPTN = GetKiteiCheckYenkansangkMockForSinkeiyaku.TESTPATTERN1;
        CheckSaiteiPMockForSinkeiyaku.SYORIPTN = CheckSaiteiPMockForSinkeiyaku.TESTPATTERN1;
        CheckTblMosSyouhin checkTblMosSyouhin = SWAKInjector.getInstance(CheckTblMosSyouhin.class);

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("860000918");
        List<HT_MosSyouhn> syuMosSyouhnParamLst = syoriCTL.getMosSyouhnsBySyutkkbn(C_SyutkKbn.SYU);
        HT_MosSyouhn syuMosSyouhnParam = syuMosSyouhnParamLst.get(0);
        BM_SyouhnZokusei syuSyouhnZokusei = bizDomManager.getSyouhnZokusei(syuMosSyouhnParam.getSyouhncd(),
            syuMosSyouhnParam.getSyouhnsdno());
        mosnaiCheckParam.setSyuSyouhnZokusei(syuSyouhnZokusei);
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setSysKbn(C_SysKbn.SKEI);
        mosnaiCheckParam.setKokutiChkHuyoUmu(C_UmuKbn.NONE);
        mosnaiCheckParam.setSysDate(BizDate.valueOf(20160102));
        mosnaiCheckParam.setListHubiMsg(new ArrayList<HT_HubiMsg>());

        checkTblMosSyouhin.exec(mosnaiCheckParam);

        List<HT_HubiMsg> hubiMsgLst = mosnaiCheckParam.getListHubiMsg();

        exNumericEquals(hubiMsgLst.size(), 0, "不備メッセージテーブルエンティティリストのサイズ");
    }
    @Test
    @TestOrder(7010)
    @Transactional
    public void testExec_G1() {
        MockObjectManager.initialize();
        BzGetAgInfoMockForSinkeiyaku.SYORIPTN = BzGetAgInfoMockForSinkeiyaku.TESTPATTERN4;
        KeisanGaikakanzanMockForSinkeiyaku.SYORIPTN = KeisanGaikakanzanMockForSinkeiyaku.TESTPATTERN1;
        GetKiteiCheckYenkansangkMockForSinkeiyaku.SYORIPTN = GetKiteiCheckYenkansangkMockForSinkeiyaku.TESTPATTERN1;
        CheckSaiteiPMockForSinkeiyaku.SYORIPTN = CheckSaiteiPMockForSinkeiyaku.TESTPATTERN1;
        CheckTblMosSyouhin checkTblMosSyouhin = SWAKInjector.getInstance(CheckTblMosSyouhin.class);

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("860000926");
        List<HT_MosSyouhn> syuMosSyouhnParamLst = syoriCTL.getMosSyouhnsBySyutkkbn(C_SyutkKbn.SYU);
        HT_MosSyouhn syuMosSyouhnParam = syuMosSyouhnParamLst.get(0);
        BM_SyouhnZokusei syuSyouhnZokusei = bizDomManager.getSyouhnZokusei(syuMosSyouhnParam.getSyouhncd(),
            syuMosSyouhnParam.getSyouhnsdno());
        mosnaiCheckParam.setSyuSyouhnZokusei(syuSyouhnZokusei);
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setSysKbn(C_SysKbn.SKEI);
        mosnaiCheckParam.setKokutiChkHuyoUmu(C_UmuKbn.NONE);
        mosnaiCheckParam.setSysDate(BizDate.valueOf(20160102));
        mosnaiCheckParam.setListHubiMsg(new ArrayList<HT_HubiMsg>());
        mosnaiCheckParam.setKosID("JUnitTest");
        mosnaiCheckParam.setKosTime("20160509141230000");
        mosnaiCheckParam.setKiteiCheckChannelCd(C_Channelcd.TIGIN);

        checkTblMosSyouhin.exec(mosnaiCheckParam);

        List<HT_HubiMsg> hubiMsgLst = mosnaiCheckParam.getListHubiMsg();
        boolean hanteiflg = false;
        exNumericEquals(hubiMsgLst.size(), 2, "不備メッセージテーブルエンティティリストのサイズ");
        for (HT_HubiMsg hubiMsg : hubiMsgLst) {
            if ("EHC0117".equals(hubiMsg.getMessageId())) {
                hanteiflg = true;
                exStringEquals(hubiMsg.getMosno(), "860000926", "申込番号");
                exNumericEquals(hubiMsg.getRenno(), 2, "連番");
                exStringEquals(hubiMsg.getMessageId(), "EHC0117", "メッセージＩＤ");
                exStringEquals(hubiMsg.getHubimsg(),
                    "外貨建て一時払変額年金保険（ブレンド型）　年金原資最低保証１００％は外貨建て一時払終身保険（即時保障型）　１５年毎利率再設定の付加が必須です。", "不備メッセージ");
                exClassificationEquals(hubiMsg.getHubisyubetukbn(), C_HubisyubetuKbn.KETHORYU_HUBI, "不備種別区分");
                exStringEquals(hubiMsg.getGyoumuKousinsyaId(), "JUnitTest", "業務用更新者ＩＤ");
                exStringEquals(hubiMsg.getGyoumuKousinTime(), "20160509141230000", "業務用更新時間");
            }
        }
        exBooleanEquals(hanteiflg, true, "メッセージＩＤが'EHC0117'のデータが存在します");
    }

    @Test
    @TestOrder(7020)
    @Transactional
    public void testExec_G2() {
        MockObjectManager.initialize();
        BzGetAgInfoMockForSinkeiyaku.SYORIPTN = BzGetAgInfoMockForSinkeiyaku.TESTPATTERN4;
        KeisanGaikakanzanMockForSinkeiyaku.SYORIPTN = KeisanGaikakanzanMockForSinkeiyaku.TESTPATTERN1;
        GetKiteiCheckYenkansangkMockForSinkeiyaku.SYORIPTN = GetKiteiCheckYenkansangkMockForSinkeiyaku.TESTPATTERN1;
        CheckSaiteiPMockForSinkeiyaku.SYORIPTN = CheckSaiteiPMockForSinkeiyaku.TESTPATTERN1;
        CheckTblMosSyouhin checkTblMosSyouhin = SWAKInjector.getInstance(CheckTblMosSyouhin.class);

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("860000934");
        List<HT_MosSyouhn> syuMosSyouhnParamLst = syoriCTL.getMosSyouhnsBySyutkkbn(C_SyutkKbn.SYU);
        HT_MosSyouhn syuMosSyouhnParam = syuMosSyouhnParamLst.get(0);
        BM_SyouhnZokusei syuSyouhnZokusei = bizDomManager.getSyouhnZokusei(syuMosSyouhnParam.getSyouhncd(),
            syuMosSyouhnParam.getSyouhnsdno());
        mosnaiCheckParam.setSyuSyouhnZokusei(syuSyouhnZokusei);

        List<BM_SyouhnZokusei> listTkSyouhnZokusei = new ArrayList<>();
        List<HT_MosSyouhn> syuMosSyouhnParamLst1 = syoriCTL.getMosSyouhnsBySyutkkbn(C_SyutkKbn.TK);
        HT_MosSyouhn syuMosSyouhnParam1 = syuMosSyouhnParamLst1.get(0);

        BM_SyouhnZokusei syuSyouhnZokusei1 = bizDomManager.getSyouhnZokusei(syuMosSyouhnParam1.getSyouhncd(),
            syuMosSyouhnParam1.getSyouhnsdno());
        listTkSyouhnZokusei.add(syuSyouhnZokusei1);
        mosnaiCheckParam.setListTkSyouhnZokusei(listTkSyouhnZokusei);

        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setSysKbn(C_SysKbn.SKEI);
        mosnaiCheckParam.setKokutiChkHuyoUmu(C_UmuKbn.NONE);
        mosnaiCheckParam.setSysDate(BizDate.valueOf(20160102));
        mosnaiCheckParam.setListHubiMsg(new ArrayList<HT_HubiMsg>());
        mosnaiCheckParam.setKosID("JUnitTest");
        mosnaiCheckParam.setKosTime("20160509141230000");
        mosnaiCheckParam.setKiteiCheckChannelCd(C_Channelcd.TIGIN);

        checkTblMosSyouhin.exec(mosnaiCheckParam);

        List<HT_HubiMsg> hubiMsgLst = mosnaiCheckParam.getListHubiMsg();
        boolean hanteiflg = false;
        boolean hanteiflg2 = false;
        exNumericEquals(hubiMsgLst.size(), 3, "不備メッセージテーブルエンティティリストのサイズ");
        for (HT_HubiMsg hubiMsg : hubiMsgLst) {
            if ("EHC0117".equals(hubiMsg.getMessageId())) {
                hanteiflg = true;
                exStringEquals(hubiMsg.getMosno(), "860000934", "申込番号");
                exNumericEquals(hubiMsg.getRenno(), 2, "連番");
                exStringEquals(hubiMsg.getMessageId(), "EHC0117", "メッセージＩＤ");
                exStringEquals(hubiMsg.getHubimsg(),
                    "外貨建て一時払変額年金保険（ブレンド型）　年金原資最低保証１００％は外貨建て一時払終身保険（即時保障型）　１５年毎利率再設定の付加が必須です。", "不備メッセージ");
                exClassificationEquals(hubiMsg.getHubisyubetukbn(), C_HubisyubetuKbn.KETHORYU_HUBI, "不備種別区分");
                exStringEquals(hubiMsg.getGyoumuKousinsyaId(), "JUnitTest", "業務用更新者ＩＤ");
                exStringEquals(hubiMsg.getGyoumuKousinTime(), "20160509141230000", "業務用更新時間");
            }
            if ("EBC0014".equals(hubiMsg.getMessageId())) {
                hanteiflg2 = true;
                exNumericEquals(hubiMsg.getRenno(), 3, "連番");
                exStringEquals(hubiMsg.getMessageId(), "EBC0014", "メッセージＩＤ");
                exStringEquals(hubiMsg.getHubimsg(), "外貨建て一時払終身保険（毎年受取型）　１０年毎利率再設定は付加できません。", "不備メッセージ");
                exClassificationEquals(hubiMsg.getHubisyubetukbn(), C_HubisyubetuKbn.KETHORYU_HUBI, "不備種別区分");
            }
        }
        exBooleanEquals(hanteiflg, true, "メッセージＩＤが'EHC0117'のデータが存在します");
        exBooleanEquals(hanteiflg2, true, "メッセージＩＤが'EBC0014'のデータが存在します");
    }

    @Test
    @TestOrder(7030)
    @Transactional
    public void testExec_G3() {
        MockObjectManager.initialize();
        BzGetAgInfoMockForSinkeiyaku.SYORIPTN = BzGetAgInfoMockForSinkeiyaku.TESTPATTERN4;
        KeisanGaikakanzanMockForSinkeiyaku.SYORIPTN = KeisanGaikakanzanMockForSinkeiyaku.TESTPATTERN1;
        GetKiteiCheckYenkansangkMockForSinkeiyaku.SYORIPTN = GetKiteiCheckYenkansangkMockForSinkeiyaku.TESTPATTERN1;
        CheckSaiteiPMockForSinkeiyaku.SYORIPTN = CheckSaiteiPMockForSinkeiyaku.TESTPATTERN1;
        CheckTblMosSyouhin checkTblMosSyouhin = SWAKInjector.getInstance(CheckTblMosSyouhin.class);

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("860000942");
        List<HT_MosSyouhn> syuMosSyouhnParamLst = syoriCTL.getMosSyouhnsBySyutkkbn(C_SyutkKbn.SYU);
        HT_MosSyouhn syuMosSyouhnParam = syuMosSyouhnParamLst.get(0);
        BM_SyouhnZokusei syuSyouhnZokusei = bizDomManager.getSyouhnZokusei(syuMosSyouhnParam.getSyouhncd(),
            syuMosSyouhnParam.getSyouhnsdno());
        mosnaiCheckParam.setSyuSyouhnZokusei(syuSyouhnZokusei);

        List<BM_SyouhnZokusei> listTkSyouhnZokusei = new ArrayList<>();
        List<HT_MosSyouhn> syuMosSyouhnParamLst1 = syoriCTL.getMosSyouhnsBySyutkkbn(C_SyutkKbn.TK);

        for (HT_MosSyouhn hubiMsg : syuMosSyouhnParamLst1) {
            BM_SyouhnZokusei syuSyouhnZokusei1 = bizDomManager.getSyouhnZokusei(hubiMsg.getSyouhncd(),
                hubiMsg.getSyouhnsdno());
            listTkSyouhnZokusei.add(syuSyouhnZokusei1);
        }

        mosnaiCheckParam.setListTkSyouhnZokusei(listTkSyouhnZokusei);
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setSysKbn(C_SysKbn.SKEI);
        mosnaiCheckParam.setKokutiChkHuyoUmu(C_UmuKbn.NONE);
        mosnaiCheckParam.setSysDate(BizDate.valueOf(20160102));
        mosnaiCheckParam.setListHubiMsg(new ArrayList<HT_HubiMsg>());
        mosnaiCheckParam.setKiteiCheckChannelCd(C_Channelcd.TIGIN);

        checkTblMosSyouhin.exec(mosnaiCheckParam);

        List<HT_HubiMsg> hubiMsgLst = mosnaiCheckParam.getListHubiMsg();

        exNumericEquals(hubiMsgLst.size(), 0, "不備メッセージテーブルエンティティリストのサイズ");
    }

    @Test
    @TestOrder(7040)
    @Transactional
    public void testExec_G4() {
        MockObjectManager.initialize();
        BzGetAgInfoMockForSinkeiyaku.SYORIPTN = BzGetAgInfoMockForSinkeiyaku.TESTPATTERN4;
        KeisanGaikakanzanMockForSinkeiyaku.SYORIPTN = KeisanGaikakanzanMockForSinkeiyaku.TESTPATTERN1;
        GetKiteiCheckYenkansangkMockForSinkeiyaku.SYORIPTN = GetKiteiCheckYenkansangkMockForSinkeiyaku.TESTPATTERN1;
        CheckSaiteiPMockForSinkeiyaku.SYORIPTN = CheckSaiteiPMockForSinkeiyaku.TESTPATTERN1;
        CheckTblMosSyouhin checkTblMosSyouhin = SWAKInjector.getInstance(CheckTblMosSyouhin.class);

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("860000959");
        List<HT_MosSyouhn> syuMosSyouhnParamLst = syoriCTL.getMosSyouhnsBySyutkkbn(C_SyutkKbn.SYU);
        HT_MosSyouhn syuMosSyouhnParam = syuMosSyouhnParamLst.get(0);
        BM_SyouhnZokusei syuSyouhnZokusei = bizDomManager.getSyouhnZokusei(syuMosSyouhnParam.getSyouhncd(),
            syuMosSyouhnParam.getSyouhnsdno());
        mosnaiCheckParam.setSyuSyouhnZokusei(syuSyouhnZokusei);
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setSysKbn(C_SysKbn.SKEI);
        mosnaiCheckParam.setKokutiChkHuyoUmu(C_UmuKbn.NONE);
        mosnaiCheckParam.setSysDate(BizDate.valueOf(20160102));
        mosnaiCheckParam.setListHubiMsg(new ArrayList<HT_HubiMsg>());

        checkTblMosSyouhin.exec(mosnaiCheckParam);

        List<HT_HubiMsg> hubiMsgLst = mosnaiCheckParam.getListHubiMsg();

        exNumericEquals(hubiMsgLst.size(), 1, "不備メッセージテーブルエンティティリストのサイズ");
        exStringEquals(hubiMsgLst.get(0).getMosno(), "860000959", "申込番号");
        exNumericEquals(hubiMsgLst.get(0).getRenno(), 1, "連番");
        exStringEquals(hubiMsgLst.get(0).getMessageId(), "EBC0046", "メッセージＩＤ");
        exStringEquals(hubiMsgLst.get(0).getHubimsg(), "据置期間が正しくありません。", "不備メッセージ");
        exClassificationEquals(hubiMsgLst.get(0).getHubisyubetukbn(), C_HubisyubetuKbn.KETHORYU_HUBI, "不備種別区分");
        exClassificationEquals(hubiMsgLst.get(0).getHubisyubetusyousaikbn(), C_HubisyubetusyousaiKbn.NONE,
            "不備種別詳細区分");
    }
    @Test
    @TestOrder(8010)
    @Transactional
    public void testExec_H1() {
        MockObjectManager.initialize();
        BzGetAgInfoMockForSinkeiyaku.SYORIPTN = BzGetAgInfoMockForSinkeiyaku.TESTPATTERN4;
        KeisanGaikakanzanMockForSinkeiyaku.SYORIPTN = KeisanGaikakanzanMockForSinkeiyaku.TESTPATTERN1;
        GetKiteiCheckYenkansangkMockForSinkeiyaku.SYORIPTN = GetKiteiCheckYenkansangkMockForSinkeiyaku.TESTPATTERN1;
        CheckSaiteiPMockForSinkeiyaku.SYORIPTN = CheckSaiteiPMockForSinkeiyaku.TESTPATTERN1;
        CheckTblMosSyouhin checkTblMosSyouhin = SWAKInjector.getInstance(CheckTblMosSyouhin.class);

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("860000967");
        List<HT_MosSyouhn> syuMosSyouhnParamLst = syoriCTL.getMosSyouhnsBySyutkkbn(C_SyutkKbn.SYU);
        HT_MosSyouhn syuMosSyouhnParam = syuMosSyouhnParamLst.get(0);
        BM_SyouhnZokusei syuSyouhnZokusei = bizDomManager.getSyouhnZokusei(syuMosSyouhnParam.getSyouhncd(),
            syuMosSyouhnParam.getSyouhnsdno());
        mosnaiCheckParam.setSyuSyouhnZokusei(syuSyouhnZokusei);

        List<BM_SyouhnZokusei> listTkSyouhnZokusei = new ArrayList<>();
        List<HT_MosSyouhn> syuMosSyouhnParamLst1 = syoriCTL.getMosSyouhnsBySyutkkbn(C_SyutkKbn.TK);
        HT_MosSyouhn syuMosSyouhnParam1 = syuMosSyouhnParamLst1.get(0);

        BM_SyouhnZokusei syuSyouhnZokusei1 = bizDomManager.getSyouhnZokusei(syuMosSyouhnParam1.getSyouhncd(),
            syuMosSyouhnParam1.getSyouhnsdno());
        listTkSyouhnZokusei.add(syuSyouhnZokusei1);
        mosnaiCheckParam.setListTkSyouhnZokusei(listTkSyouhnZokusei);
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setSysKbn(C_SysKbn.ESHIEN);
        mosnaiCheckParam.setKokutiChkHuyoUmu(C_UmuKbn.NONE);
        mosnaiCheckParam.setSysDate(BizDate.valueOf(20160102));

        checkTblMosSyouhin.exec(mosnaiCheckParam);

        exClassificationEquals(mosnaiCheckParam.getSekmossakuseiErroutKbn(), C_SekmossakuseiErroutKbn.GAMEN, "設計書申込書作成エラー出力区分");
        exStringEquals(mosnaiCheckParam.getSekmossakuseiErrmsg1(), "外貨建て一時払終身保険（毎年受取型）　１５年毎利率再設定には外貨建て一時払終身保", "設計書申込書作成エラーメッセージ１");
        exStringEquals(mosnaiCheckParam.getSekmossakuseiErrmsg2(), "険（即時保障型）　１０年毎利率再設定を付加できません。", "設計書申込書作成エラーメッセージ２");
        exClassificationEquals(mosnaiCheckParam.getKouzokuSyoriJikkouKbn(), C_KouzokujkKbn.NONE, "後続処理実行区分");
    }
    @Test
    @TestOrder(8020)
    @Transactional
    public void testExec_H2() {
        MockObjectManager.initialize();
        BzGetAgInfoMockForSinkeiyaku.SYORIPTN = BzGetAgInfoMockForSinkeiyaku.TESTPATTERN4;
        KeisanGaikakanzanMockForSinkeiyaku.SYORIPTN = KeisanGaikakanzanMockForSinkeiyaku.TESTPATTERN1;
        GetKiteiCheckYenkansangkMockForSinkeiyaku.SYORIPTN = GetKiteiCheckYenkansangkMockForSinkeiyaku.TESTPATTERN1;
        CheckSaiteiPMockForSinkeiyaku.SYORIPTN = CheckSaiteiPMockForSinkeiyaku.TESTPATTERN1;
        CheckTblMosSyouhin checkTblMosSyouhin = SWAKInjector.getInstance(CheckTblMosSyouhin.class);

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("860000975");
        List<HT_MosSyouhn> syuMosSyouhnParamLst = syoriCTL.getMosSyouhnsBySyutkkbn(C_SyutkKbn.SYU);
        HT_MosSyouhn syuMosSyouhnParam = syuMosSyouhnParamLst.get(0);
        BM_SyouhnZokusei syuSyouhnZokusei = bizDomManager.getSyouhnZokusei(syuMosSyouhnParam.getSyouhncd(),
            syuMosSyouhnParam.getSyouhnsdno());
        mosnaiCheckParam.setSyuSyouhnZokusei(syuSyouhnZokusei);

        List<BM_SyouhnZokusei> listTkSyouhnZokusei = new ArrayList<>();
        List<HT_MosSyouhn> syuMosSyouhnParamLst1 = syoriCTL.getMosSyouhnsBySyutkkbn(C_SyutkKbn.TK);
        HT_MosSyouhn syuMosSyouhnParam1 = syuMosSyouhnParamLst1.get(0);

        BM_SyouhnZokusei syuSyouhnZokusei1 = bizDomManager.getSyouhnZokusei(syuMosSyouhnParam1.getSyouhncd(),
            syuMosSyouhnParam1.getSyouhnsdno());
        listTkSyouhnZokusei.add(syuSyouhnZokusei1);
        mosnaiCheckParam.setListTkSyouhnZokusei(listTkSyouhnZokusei);
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setSysKbn(C_SysKbn.SKEI);
        mosnaiCheckParam.setKokutiChkHuyoUmu(C_UmuKbn.NONE);
        mosnaiCheckParam.setSysDate(BizDate.valueOf(20160102));
        mosnaiCheckParam.setListHubiMsg(new ArrayList<HT_HubiMsg>());
        mosnaiCheckParam.setKosID("JUnitTest");
        mosnaiCheckParam.setKosTime("20160509141230000");
        mosnaiCheckParam.setKiteiCheckChannelCd(C_Channelcd.BLNK);

        checkTblMosSyouhin.exec(mosnaiCheckParam);

        List<HT_HubiMsg> hubiMsgLst = mosnaiCheckParam.getListHubiMsg();

        exNumericEquals(hubiMsgLst.size(), 1, "不備メッセージテーブルエンティティリストのサイズ");

        exStringEquals(hubiMsgLst.get(0).getMosno(), "860000975", "申込番号");
        exNumericEquals(hubiMsgLst.get(0).getRenno(), 1, "連番");
        exStringEquals(hubiMsgLst.get(0).getMessageId(), "EBC0014", "メッセージＩＤ");
        exStringEquals(hubiMsgLst.get(0).getHubimsg(), "外貨建て一時払終身保険（即時保障型）　１０年毎利率再設定は付加できません。", "不備メッセージ");
        exClassificationEquals(hubiMsgLst.get(0).getHubisyubetukbn(), C_HubisyubetuKbn.KETHORYU_HUBI, "不備種別区分");
        exStringEquals(hubiMsgLst.get(0).getGyoumuKousinsyaId(), "JUnitTest", "業務用更新者ＩＤ");
        exStringEquals(hubiMsgLst.get(0).getGyoumuKousinTime(), "20160509141230000", "業務用更新時間");
    }
    @Test
    @TestOrder(8030)
    @Transactional
    public void testExec_H3() {
        MockObjectManager.initialize();
        BzGetAgInfoMockForSinkeiyaku.SYORIPTN = BzGetAgInfoMockForSinkeiyaku.TESTPATTERN4;
        KeisanGaikakanzanMockForSinkeiyaku.SYORIPTN = KeisanGaikakanzanMockForSinkeiyaku.TESTPATTERN1;
        GetKiteiCheckYenkansangkMockForSinkeiyaku.SYORIPTN = GetKiteiCheckYenkansangkMockForSinkeiyaku.TESTPATTERN1;
        CheckSaiteiPMockForSinkeiyaku.SYORIPTN = CheckSaiteiPMockForSinkeiyaku.TESTPATTERN1;
        CheckTblMosSyouhin checkTblMosSyouhin = SWAKInjector.getInstance(CheckTblMosSyouhin.class);

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("860000983");
        List<HT_MosSyouhn> syuMosSyouhnParamLst = syoriCTL.getMosSyouhnsBySyutkkbn(C_SyutkKbn.SYU);
        HT_MosSyouhn syuMosSyouhnParam = syuMosSyouhnParamLst.get(0);
        BM_SyouhnZokusei syuSyouhnZokusei = bizDomManager.getSyouhnZokusei(syuMosSyouhnParam.getSyouhncd(),
            syuMosSyouhnParam.getSyouhnsdno());
        mosnaiCheckParam.setSyuSyouhnZokusei(syuSyouhnZokusei);

        List<BM_SyouhnZokusei> listTkSyouhnZokusei = new ArrayList<>();
        List<HT_MosSyouhn> syuMosSyouhnParamLst1 = syoriCTL.getMosSyouhnsBySyutkkbn(C_SyutkKbn.TK);
        HT_MosSyouhn syuMosSyouhnParam1 = syuMosSyouhnParamLst1.get(0);

        BM_SyouhnZokusei syuSyouhnZokusei1 = bizDomManager.getSyouhnZokusei(syuMosSyouhnParam1.getSyouhncd(),
            syuMosSyouhnParam1.getSyouhnsdno());
        listTkSyouhnZokusei.add(syuSyouhnZokusei1);
        mosnaiCheckParam.setListTkSyouhnZokusei(listTkSyouhnZokusei);
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setSysKbn(C_SysKbn.SKEI);
        mosnaiCheckParam.setKokutiChkHuyoUmu(C_UmuKbn.NONE);
        mosnaiCheckParam.setSysDate(BizDate.valueOf(20160102));
        mosnaiCheckParam.setListHubiMsg(new ArrayList<HT_HubiMsg>());
        mosnaiCheckParam.setKosID("JUnitTest");
        mosnaiCheckParam.setKosTime("20160509141230000");

        checkTblMosSyouhin.exec(mosnaiCheckParam);

        List<HT_HubiMsg> hubiMsgLst = mosnaiCheckParam.getListHubiMsg();

        exNumericEquals(hubiMsgLst.size(), 1, "不備メッセージテーブルエンティティリストのサイズ");

        exStringEquals(hubiMsgLst.get(0).getMosno(), "860000983", "申込番号");
        exNumericEquals(hubiMsgLst.get(0).getRenno(), 1, "連番");
        exStringEquals(hubiMsgLst.get(0).getMessageId(), "EBC0014", "メッセージＩＤ");
        exStringEquals(hubiMsgLst.get(0).getHubimsg(), "外貨建て一時払終身保険（即時保障型）　１０年毎利率再設定は付加できません。", "不備メッセージ");
        exClassificationEquals(hubiMsgLst.get(0).getHubisyubetukbn(), C_HubisyubetuKbn.KETHORYU_HUBI, "不備種別区分");
        exStringEquals(hubiMsgLst.get(0).getGyoumuKousinsyaId(), "JUnitTest", "業務用更新者ＩＤ");
        exStringEquals(hubiMsgLst.get(0).getGyoumuKousinTime(), "20160509141230000", "業務用更新時間");
    }

    @Test
    @TestOrder(8040)
    @Transactional
    public void testExec_H4() {
        MockObjectManager.initialize();
        BzGetAgInfoMockForSinkeiyaku.SYORIPTN = BzGetAgInfoMockForSinkeiyaku.TESTPATTERN4;
        KeisanGaikakanzanMockForSinkeiyaku.SYORIPTN = KeisanGaikakanzanMockForSinkeiyaku.TESTPATTERN1;
        GetKiteiCheckYenkansangkMockForSinkeiyaku.SYORIPTN = GetKiteiCheckYenkansangkMockForSinkeiyaku.TESTPATTERN1;
        CheckSaiteiPMockForSinkeiyaku.SYORIPTN = CheckSaiteiPMockForSinkeiyaku.TESTPATTERN1;
        CheckTblMosSyouhin checkTblMosSyouhin = SWAKInjector.getInstance(CheckTblMosSyouhin.class);

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("860000991");
        List<HT_MosSyouhn> syuMosSyouhnParamLst = syoriCTL.getMosSyouhnsBySyutkkbn(C_SyutkKbn.SYU);
        HT_MosSyouhn syuMosSyouhnParam = syuMosSyouhnParamLst.get(0);
        BM_SyouhnZokusei syuSyouhnZokusei = bizDomManager.getSyouhnZokusei(syuMosSyouhnParam.getSyouhncd(),
            syuMosSyouhnParam.getSyouhnsdno());
        mosnaiCheckParam.setSyuSyouhnZokusei(syuSyouhnZokusei);

        List<BM_SyouhnZokusei> listTkSyouhnZokusei = new ArrayList<>();
        List<HT_MosSyouhn> syuMosSyouhnParamLst1 = syoriCTL.getMosSyouhnsBySyutkkbn(C_SyutkKbn.TK);
        HT_MosSyouhn syuMosSyouhnParam1 = syuMosSyouhnParamLst1.get(0);

        BM_SyouhnZokusei syuSyouhnZokusei1 = bizDomManager.getSyouhnZokusei(syuMosSyouhnParam1.getSyouhncd(),
            syuMosSyouhnParam1.getSyouhnsdno());
        listTkSyouhnZokusei.add(syuSyouhnZokusei1);
        mosnaiCheckParam.setListTkSyouhnZokusei(listTkSyouhnZokusei);
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setSysKbn(C_SysKbn.SKEI);
        mosnaiCheckParam.setKokutiChkHuyoUmu(C_UmuKbn.NONE);
        mosnaiCheckParam.setSysDate(BizDate.valueOf(20160102));
        mosnaiCheckParam.setListHubiMsg(new ArrayList<HT_HubiMsg>());

        checkTblMosSyouhin.exec(mosnaiCheckParam);

        List<HT_HubiMsg> hubiMsgLst = mosnaiCheckParam.getListHubiMsg();

        exNumericEquals(hubiMsgLst.size(), 0, "不備メッセージテーブルエンティティリストのサイズ");
    }
}