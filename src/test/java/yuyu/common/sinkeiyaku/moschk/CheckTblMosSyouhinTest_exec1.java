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
public class CheckTblMosSyouhinTest_exec1 {

    @Inject
    private MosnaiCheckParam mosnaiCheckParam;

    @Inject
    private SinkeiyakuDomManager sinkeiyakuDomManager;

    @Inject
    private BizDomManager bizDomManager;
    private final static String fileName = "UT-SP_単体テスト仕様書（共通）_申込商品TBLチェック";

    private final static String sheetName = "INデータ(1)";

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
        GetKiteiCheckYenkansangkMockForSinkeiyaku.caller = CheckTblMosSyouhinTest_exec.class;
        CheckSaiteiPMockForSinkeiyaku.caller = CheckTblMosSyouhinTest_exec.class;

    }

    @AfterClass
    public static void testClear() {

        BzGetAgInfoMockForSinkeiyaku.caller = null;
        BzGetAgInfoMockForSinkeiyaku.SYORIPTN = null;
        KeisanGaikakanzanMockForSinkeiyaku.caller = null;
        KeisanGaikakanzanMockForSinkeiyaku.SYORIPTN = null;
        GetKiteiCheckYenkansangkMockForSinkeiyaku.caller = null;
        GetKiteiCheckYenkansangkMockForSinkeiyaku.SYORIPTN = null;
        CheckSaiteiPMockForSinkeiyaku.caller = null;
        CheckSaiteiPMockForSinkeiyaku.SYORIPTN = null;
        MockObjectManager.initialize();

    }

    @Test(expected = CommonBizAppException.class)
    @TestOrder(4010)
    @Transactional
    public void testExec_D1() {
        MockObjectManager.initialize();
        BzGetAgInfoMockForSinkeiyaku.SYORIPTN = BzGetAgInfoMockForSinkeiyaku.TESTPATTERN4;
        GetKiteiCheckYenkansangkMockForSinkeiyaku.SYORIPTN = GetKiteiCheckYenkansangkMockForSinkeiyaku.TESTPATTERN2;
        CheckSaiteiPMockForSinkeiyaku.SYORIPTN = CheckSaiteiPMockForSinkeiyaku.TESTPATTERN1;
        CheckTblMosSyouhin checkTblMosSyouhin = SWAKInjector.getInstance(CheckTblMosSyouhin.class);

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("860000330");

        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setSysKbn(C_SysKbn.SKEI);
        mosnaiCheckParam.setKokutiChkHuyoUmu(C_UmuKbn.NONE);
        mosnaiCheckParam.setSysDate(BizDate.valueOf(20160102));
        List<HT_MosSyouhn> syuMosSyouhnParamLst = syoriCTL.getMosSyouhnsBySyutkkbn(C_SyutkKbn.SYU);
        HT_MosSyouhn syuMosSyouhnParam = syuMosSyouhnParamLst.get(0);
        BM_SyouhnZokusei syuSyouhnZokusei = bizDomManager.getSyouhnZokusei(syuMosSyouhnParam.getSyouhncd(),
            syuMosSyouhnParam.getSyouhnsdno());
        mosnaiCheckParam.setSyuSyouhnZokusei(syuSyouhnZokusei);
        try {
            checkTblMosSyouhin.exec(mosnaiCheckParam);
        } catch (CommonBizAppException e) {
            exStringEquals(e.getMessage(), "システム整合性エラーです。最高ＳＳ単位テーブルにデータが見つかりません。", "エラーメッセージ");
            throw e;
        }
    }

    @Test
    @TestOrder(4020)
    @Transactional
    public void testExec_D2() {
        MockObjectManager.initialize();
        BzGetAgInfoMockForSinkeiyaku.SYORIPTN = BzGetAgInfoMockForSinkeiyaku.TESTPATTERN4;
        KeisanGaikakanzanMockForSinkeiyaku.SYORIPTN = KeisanGaikakanzanMockForSinkeiyaku.TESTPATTERN1;
        GetKiteiCheckYenkansangkMockForSinkeiyaku.SYORIPTN = GetKiteiCheckYenkansangkMockForSinkeiyaku.TESTPATTERN2;
        CheckSaiteiPMockForSinkeiyaku.SYORIPTN = CheckSaiteiPMockForSinkeiyaku.TESTPATTERN1;
        CheckTblMosSyouhin checkTblMosSyouhin = SWAKInjector.getInstance(CheckTblMosSyouhin.class);

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("860000348");
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

        exStringEquals(hubiMsgLst.get(0).getMosno(), "860000348", "申込番号");
        exNumericEquals(hubiMsgLst.get(0).getRenno(), 1, "連番");
        exStringEquals(hubiMsgLst.get(0).getMessageId(), "EHC1053", "メッセージＩＤ");
        exStringEquals(hubiMsgLst.get(0).getHubimsg(), "基準額判定用為替レート適用範囲外です。　申込日２０１７０４０３", "不備メッセージ");
        exClassificationEquals(hubiMsgLst.get(0).getHubisyubetukbn(), C_HubisyubetuKbn.KETHORYU_HUBI, "不備種別区分");
        exStringEquals(hubiMsgLst.get(0).getGyoumuKousinsyaId(), "JUnitTest", "業務用更新者ＩＤ");
        exStringEquals(hubiMsgLst.get(0).getGyoumuKousinTime(), "20160509141230000", "業務用更新時間");

        exStringEquals(hubiMsgLst.get(1).getMosno(), "860000348", "申込番号");
        exNumericEquals(hubiMsgLst.get(1).getRenno(), 2, "連番");
        exStringEquals(hubiMsgLst.get(1).getMessageId(), "THC0033", "メッセージＩＤ");
        exStringEquals(hubiMsgLst.get(1).getHubimsg(), "【特認可能】外貨建て一時払終身保険（即時保障型）　１０年毎利率再設定の保険金額が１，０２０，０００．００米ドル単位になっていません。", "不備メッセージ");
        exClassificationEquals(hubiMsgLst.get(1).getHubisyubetukbn(), C_HubisyubetuKbn.KETHORYU_HUBI, "不備種別区分");
        exStringEquals(hubiMsgLst.get(1).getGyoumuKousinsyaId(), "JUnitTest", "業務用更新者ＩＤ");
        exStringEquals(hubiMsgLst.get(1).getGyoumuKousinTime(), "20160509141230000", "業務用更新時間");
    }

    @Test
    @TestOrder(4030)
    @Transactional
    public void testExec_D3() {
        MockObjectManager.initialize();
        BzGetAgInfoMockForSinkeiyaku.SYORIPTN = BzGetAgInfoMockForSinkeiyaku.TESTPATTERN4;
        KeisanGaikakanzanMockForSinkeiyaku.SYORIPTN = KeisanGaikakanzanMockForSinkeiyaku.TESTPATTERN1;
        GetKiteiCheckYenkansangkMockForSinkeiyaku.SYORIPTN = GetKiteiCheckYenkansangkMockForSinkeiyaku.TESTPATTERN2;
        CheckSaiteiPMockForSinkeiyaku.SYORIPTN = CheckSaiteiPMockForSinkeiyaku.TESTPATTERN1;
        CheckTblMosSyouhin checkTblMosSyouhin = SWAKInjector.getInstance(CheckTblMosSyouhin.class);

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("860000355");
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

        exStringEquals(hubiMsgLst.get(0).getMosno(), "860000355", "申込番号");
        exNumericEquals(hubiMsgLst.get(0).getRenno(), 1, "連番");
        exStringEquals(hubiMsgLst.get(0).getMessageId(), "EHC0019", "メッセージＩＤ");
        exStringEquals(hubiMsgLst.get(0).getHubimsg(), "外貨建て一時払終身保険（即時保障型）　１５年毎利率再設定の１倍は取扱えません。", "不備メッセージ");
        exClassificationEquals(hubiMsgLst.get(0).getHubisyubetukbn(), C_HubisyubetuKbn.KETHORYU_HUBI, "不備種別区分");
        exStringEquals(hubiMsgLst.get(0).getGyoumuKousinsyaId(), "JUnitTest", "業務用更新者ＩＤ");
        exStringEquals(hubiMsgLst.get(0).getGyoumuKousinTime(), "20160509141230000", "業務用更新時間");

        exNumericEquals(hubiMsgLst.get(1).getRenno(), 2, "連番");
        exStringEquals(hubiMsgLst.get(1).getMessageId(), "THC0033", "メッセージＩＤ");
        exStringEquals(hubiMsgLst.get(1).getHubimsg(), "【特認可能】外貨建て一時払終身保険（即時保障型）　１５年毎利率再設定の保険金額が１，０２０，４００円単位になっていません。", "不備メッセージ");
        exClassificationEquals(hubiMsgLst.get(1).getHubisyubetukbn(), C_HubisyubetuKbn.KETHORYU_HUBI, "不備種別区分");
    }

    @Test
    @TestOrder(4040)
    @Transactional
    public void testExec_D4() {
        MockObjectManager.initialize();
        BzGetAgInfoMockForSinkeiyaku.SYORIPTN = BzGetAgInfoMockForSinkeiyaku.TESTPATTERN4;
        KeisanGaikakanzanMockForSinkeiyaku.SYORIPTN = KeisanGaikakanzanMockForSinkeiyaku.TESTPATTERN1;
        GetKiteiCheckYenkansangkMockForSinkeiyaku.SYORIPTN = GetKiteiCheckYenkansangkMockForSinkeiyaku.TESTPATTERN2;
        CheckSaiteiPMockForSinkeiyaku.SYORIPTN = CheckSaiteiPMockForSinkeiyaku.TESTPATTERN1;
        CheckTblMosSyouhin checkTblMosSyouhin = SWAKInjector.getInstance(CheckTblMosSyouhin.class);

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("860000363");
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

        exStringEquals(hubiMsgLst.get(0).getMosno(), "860000363", "申込番号");
        exNumericEquals(hubiMsgLst.get(0).getRenno(), 1, "連番");
        exStringEquals(hubiMsgLst.get(0).getMessageId(), "THC0083", "メッセージＩＤ");
        exStringEquals(hubiMsgLst.get(0).getHubimsg(), "【特認可能】外貨建て一時払終身保険（毎年受取型）　１０年毎利率再設定の給付日額が１，４８０，０００円単位になっていません。", "不備メッセージ");
        exClassificationEquals(hubiMsgLst.get(0).getHubisyubetukbn(), C_HubisyubetuKbn.KETHORYU_HUBI, "不備種別区分");
        exStringEquals(hubiMsgLst.get(0).getGyoumuKousinsyaId(), "JUnitTest", "業務用更新者ＩＤ");
        exStringEquals(hubiMsgLst.get(0).getGyoumuKousinTime(), "20160509141230000", "業務用更新時間");
    }

    @Test
    @TestOrder(4050)
    @Transactional
    public void testExec_D5() {
        MockObjectManager.initialize();
        BzGetAgInfoMockForSinkeiyaku.SYORIPTN = BzGetAgInfoMockForSinkeiyaku.TESTPATTERN4;
        KeisanGaikakanzanMockForSinkeiyaku.SYORIPTN = KeisanGaikakanzanMockForSinkeiyaku.TESTPATTERN1;
        GetKiteiCheckYenkansangkMockForSinkeiyaku.SYORIPTN = GetKiteiCheckYenkansangkMockForSinkeiyaku.TESTPATTERN2;
        CheckSaiteiPMockForSinkeiyaku.SYORIPTN = CheckSaiteiPMockForSinkeiyaku.TESTPATTERN1;
        CheckTblMosSyouhin checkTblMosSyouhin = SWAKInjector.getInstance(CheckTblMosSyouhin.class);

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("860000371");
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

        exStringEquals(hubiMsgLst.get(0).getMosno(), "860000371", "申込番号");
        exNumericEquals(hubiMsgLst.get(0).getRenno(), 1, "連番");
        exStringEquals(hubiMsgLst.get(0).getMessageId(), "THC0114", "メッセージＩＤ");
        exStringEquals(hubiMsgLst.get(0).getHubimsg(), "【特認可能】外貨建て一時払終身保険（毎年受取型）　１５年毎利率再設定の給付金額が１，０２０，５００円単位になっていません。", "不備メッセージ");
        exClassificationEquals(hubiMsgLst.get(0).getHubisyubetukbn(), C_HubisyubetuKbn.KETHORYU_HUBI, "不備種別区分");
        exStringEquals(hubiMsgLst.get(0).getGyoumuKousinsyaId(), "JUnitTest", "業務用更新者ＩＤ");
        exStringEquals(hubiMsgLst.get(0).getGyoumuKousinTime(), "20160509141230000", "業務用更新時間");
    }
    @Test
    @TestOrder(4060)
    @Transactional
    public void testExec_D6() {
        MockObjectManager.initialize();
        BzGetAgInfoMockForSinkeiyaku.SYORIPTN = BzGetAgInfoMockForSinkeiyaku.TESTPATTERN4;
        KeisanGaikakanzanMockForSinkeiyaku.SYORIPTN = KeisanGaikakanzanMockForSinkeiyaku.TESTPATTERN1;
        GetKiteiCheckYenkansangkMockForSinkeiyaku.SYORIPTN = GetKiteiCheckYenkansangkMockForSinkeiyaku.TESTPATTERN2;
        CheckSaiteiPMockForSinkeiyaku.SYORIPTN = CheckSaiteiPMockForSinkeiyaku.TESTPATTERN1;
        CheckTblMosSyouhin checkTblMosSyouhin = SWAKInjector.getInstance(CheckTblMosSyouhin.class);

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("860000389");
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
        for (HT_HubiMsg hubiMsg : hubiMsgLst) {
            if ("THC0114".equals(hubiMsg.getMessageId())) {
                exStringEquals(hubiMsg.getMosno(), "860000389", "申込番号");
                exNumericEquals(hubiMsg.getRenno(), 2, "連番");
                exStringEquals(hubiMsg.getMessageId(), "THC0114", "メッセージＩＤ");
                exStringEquals(hubiMsg.getHubimsg(),
                    "【特認可能】外貨建て一時払変額年金保険（ブレンド型）　年金原資最低保証１００％の給付金額が１，０２０，６００円単位になっていません。", "不備メッセージ");
                exClassificationEquals(hubiMsg.getHubisyubetukbn(), C_HubisyubetuKbn.KETHORYU_HUBI, "不備種別区分");
                exStringEquals(hubiMsg.getGyoumuKousinsyaId(), "JUnitTest", "業務用更新者ＩＤ");
                exStringEquals(hubiMsg.getGyoumuKousinTime(), "20160509141230000", "業務用更新時間");
            }
        }
    }
    @Test
    @TestOrder(4070)
    @Transactional
    public void testExec_D7() {
        MockObjectManager.initialize();
        BzGetAgInfoMockForSinkeiyaku.SYORIPTN = BzGetAgInfoMockForSinkeiyaku.TESTPATTERN4;
        KeisanGaikakanzanMockForSinkeiyaku.SYORIPTN = KeisanGaikakanzanMockForSinkeiyaku.TESTPATTERN1;
        GetKiteiCheckYenkansangkMockForSinkeiyaku.SYORIPTN = GetKiteiCheckYenkansangkMockForSinkeiyaku.TESTPATTERN2;
        CheckSaiteiPMockForSinkeiyaku.SYORIPTN = CheckSaiteiPMockForSinkeiyaku.TESTPATTERN1;
        CheckTblMosSyouhin checkTblMosSyouhin = SWAKInjector.getInstance(CheckTblMosSyouhin.class);

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("860000397");
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

        for (HT_HubiMsg hubiMsg : hubiMsgLst) {
            if ("THC0203".equals(hubiMsg.getMessageId())) {
                exStringEquals(hubiMsg.getMosno(), "860000397", "申込番号");
                exNumericEquals(hubiMsg.getRenno(), 2, "連番");
                exStringEquals(hubiMsg.getMessageId(), "THC0203", "メッセージＩＤ");
                exStringEquals(hubiMsg.getHubimsg(),
                    "【特認可能】外貨建て一時払変額年金保険（ブレンド型）　年金原資最低保証１１５％の給付月額が１，０２０，７００円単位になっていません。", "不備メッセージ");
                exClassificationEquals(hubiMsg.getHubisyubetukbn(), C_HubisyubetuKbn.KETHORYU_HUBI, "不備種別区分");
                exStringEquals(hubiMsg.getGyoumuKousinsyaId(), "JUnitTest", "業務用更新者ＩＤ");
                exStringEquals(hubiMsg.getGyoumuKousinTime(), "20160509141230000", "業務用更新時間");
            }
        }}
    @Test
    @TestOrder(4080)
    @Transactional
    public void testExec_D8() {
        MockObjectManager.initialize();
        BzGetAgInfoMockForSinkeiyaku.SYORIPTN = BzGetAgInfoMockForSinkeiyaku.TESTPATTERN4;
        KeisanGaikakanzanMockForSinkeiyaku.SYORIPTN = KeisanGaikakanzanMockForSinkeiyaku.TESTPATTERN1;
        GetKiteiCheckYenkansangkMockForSinkeiyaku.SYORIPTN = GetKiteiCheckYenkansangkMockForSinkeiyaku.TESTPATTERN2;
        CheckSaiteiPMockForSinkeiyaku.SYORIPTN = CheckSaiteiPMockForSinkeiyaku.TESTPATTERN1;
        CheckTblMosSyouhin checkTblMosSyouhin = SWAKInjector.getInstance(CheckTblMosSyouhin.class);

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("860000405");
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

        exNumericEquals(hubiMsgLst.size(), 2, "不備メッセージテーブルエンティティリストのサイズ");
        exStringEquals(hubiMsgLst.get(0).getMosno(), "860000405", "申込番号");
        exNumericEquals(hubiMsgLst.get(0).getRenno(), 1, "連番");
        exStringEquals(hubiMsgLst.get(0).getMessageId(), "EBC0046", "メッセージＩＤ");
        exStringEquals(hubiMsgLst.get(0).getHubimsg(), "据置期間が正しくありません。", "不備メッセージ");
        exClassificationEquals(hubiMsgLst.get(0).getHubisyubetukbn(), C_HubisyubetuKbn.KETHORYU_HUBI, "不備種別区分");
        exClassificationEquals(hubiMsgLst.get(0).getHubisyubetusyousaikbn(), C_HubisyubetusyousaiKbn.NONE,
            "不備種別詳細区分");

        exStringEquals(hubiMsgLst.get(1).getMosno(), "860000405", "申込番号");
        exNumericEquals(hubiMsgLst.get(1).getRenno(), 2, "連番");
        exStringEquals(hubiMsgLst.get(1).getMessageId(), "THC0126", "メッセージＩＤ");
        exStringEquals(hubiMsgLst.get(1).getHubimsg(), "【特認可能】外貨建て一時払変額年金保険（ブレンド型）　年金原資最低保証１２０％の最高通算限度額の２０，７００円をオーバーしています。", "不備メッセージ");
        exClassificationEquals(hubiMsgLst.get(1).getHubisyubetukbn(), C_HubisyubetuKbn.KETHORYU_HUBI, "不備種別区分");
        exClassificationEquals(hubiMsgLst.get(1).getHubisyubetusyousaikbn(), C_HubisyubetusyousaiKbn.NONE,
            "不備種別詳細区分");
    }
    @Test
    @TestOrder(4090)
    @Transactional
    public void testExec_D9() {
        MockObjectManager.initialize();
        BzGetAgInfoMockForSinkeiyaku.SYORIPTN = BzGetAgInfoMockForSinkeiyaku.TESTPATTERN4;
        KeisanGaikakanzanMockForSinkeiyaku.SYORIPTN = KeisanGaikakanzanMockForSinkeiyaku.TESTPATTERN1;
        GetKiteiCheckYenkansangkMockForSinkeiyaku.SYORIPTN = GetKiteiCheckYenkansangkMockForSinkeiyaku.TESTPATTERN2;
        CheckSaiteiPMockForSinkeiyaku.SYORIPTN = CheckSaiteiPMockForSinkeiyaku.TESTPATTERN1;
        CheckTblMosSyouhin checkTblMosSyouhin = SWAKInjector.getInstance(CheckTblMosSyouhin.class);

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("860000413");
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

        exStringEquals(hubiMsgLst.get(0).getMosno(), "860000413", "申込番号");
        exNumericEquals(hubiMsgLst.get(0).getRenno(), 1, "連番");
        exStringEquals(hubiMsgLst.get(0).getMessageId(), "THC0032", "メッセージＩＤ");
        exStringEquals(hubiMsgLst.get(0).getHubimsg(), "【特認可能】外貨建て一時払終身保険（即時保障型）　１０年毎利率再設定の保険金額が最高Ｓの１，０２０，３００円をオーバーしています。", "不備メッセージ");
        exClassificationEquals(hubiMsgLst.get(0).getHubisyubetukbn(), C_HubisyubetuKbn.KETHORYU_HUBI, "不備種別区分");
        exStringEquals(hubiMsgLst.get(0).getGyoumuKousinsyaId(), "JUnitTest", "業務用更新者ＩＤ");
        exStringEquals(hubiMsgLst.get(0).getGyoumuKousinTime(), "20160509141230000", "業務用更新時間");
    }
    @Test
    @TestOrder(4100)
    @Transactional
    public void testExec_D10() {
        MockObjectManager.initialize();
        BzGetAgInfoMockForSinkeiyaku.SYORIPTN = BzGetAgInfoMockForSinkeiyaku.TESTPATTERN4;
        KeisanGaikakanzanMockForSinkeiyaku.SYORIPTN = KeisanGaikakanzanMockForSinkeiyaku.TESTPATTERN1;
        GetKiteiCheckYenkansangkMockForSinkeiyaku.SYORIPTN = GetKiteiCheckYenkansangkMockForSinkeiyaku.TESTPATTERN2;
        CheckSaiteiPMockForSinkeiyaku.SYORIPTN = CheckSaiteiPMockForSinkeiyaku.TESTPATTERN1;
        CheckTblMosSyouhin checkTblMosSyouhin = SWAKInjector.getInstance(CheckTblMosSyouhin.class);

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("860000421");
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

        exStringEquals(hubiMsgLst.get(0).getMosno(), "860000421", "申込番号");
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
    }
    @Test
    @TestOrder(4110)
    @Transactional
    public void testExec_D11() {

        BzGetAgInfoMockForSinkeiyaku.SYORIPTN = BzGetAgInfoMockForSinkeiyaku.TESTPATTERN4;
        KeisanGaikakanzanMockForSinkeiyaku.SYORIPTN = KeisanGaikakanzanMockForSinkeiyaku.TESTPATTERN1;
        GetKiteiCheckYenkansangkMockForSinkeiyaku.SYORIPTN = GetKiteiCheckYenkansangkMockForSinkeiyaku.TESTPATTERN2;
        CheckSaiteiPMockForSinkeiyaku.SYORIPTN = CheckSaiteiPMockForSinkeiyaku.TESTPATTERN1;
        CheckTblMosSyouhin checkTblMosSyouhin = SWAKInjector.getInstance(CheckTblMosSyouhin.class);

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("860000439");
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
        exStringEquals(mosnaiCheckParam.getSekmossakuseiErrmsg2(), "最高保険金額を超えています　保険金額は２万円までにしてください", "設計書申込書作成エラーメッセージ２");
        exClassificationEquals(mosnaiCheckParam.getKouzokuSyoriJikkouKbn(), C_KouzokujkKbn.NONE, "後続処理実行区分");
    }
    @Test
    @TestOrder(4120)
    @Transactional
    public void testExec_D12() {
        MockObjectManager.initialize();
        BzGetAgInfoMockForSinkeiyaku.SYORIPTN = BzGetAgInfoMockForSinkeiyaku.TESTPATTERN4;
        KeisanGaikakanzanMockForSinkeiyaku.SYORIPTN = KeisanGaikakanzanMockForSinkeiyaku.TESTPATTERN1;
        GetKiteiCheckYenkansangkMockForSinkeiyaku.SYORIPTN = GetKiteiCheckYenkansangkMockForSinkeiyaku.TESTPATTERN2;
        CheckSaiteiPMockForSinkeiyaku.SYORIPTN = CheckSaiteiPMockForSinkeiyaku.TESTPATTERN1;
        CheckTblMosSyouhin checkTblMosSyouhin = SWAKInjector.getInstance(CheckTblMosSyouhin.class);

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("860000447");
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

        exStringEquals(hubiMsgLst.get(0).getMosno(), "860000447", "申込番号");
        exNumericEquals(hubiMsgLst.get(0).getRenno(), 1, "連番");
        exStringEquals(hubiMsgLst.get(0).getMessageId(), "THC0082", "メッセージＩＤ");
        exStringEquals(hubiMsgLst.get(0).getHubimsg(), "【特認可能】外貨建て一時払終身保険（毎年受取型）　１０年毎利率再設定の給付日額が最高日額の２０，２００円をオーバーしています。", "不備メッセージ");
        exClassificationEquals(hubiMsgLst.get(0).getHubisyubetukbn(), C_HubisyubetuKbn.KETHORYU_HUBI, "不備種別区分");
        exStringEquals(hubiMsgLst.get(0).getGyoumuKousinsyaId(), "JUnitTest", "業務用更新者ＩＤ");
        exStringEquals(hubiMsgLst.get(0).getGyoumuKousinTime(), "20160509141230000", "業務用更新時間");
    }
    @Test
    @TestOrder(4130)
    @Transactional
    public void testExec_D13() {
        MockObjectManager.initialize();
        BzGetAgInfoMockForSinkeiyaku.SYORIPTN = BzGetAgInfoMockForSinkeiyaku.TESTPATTERN4;
        KeisanGaikakanzanMockForSinkeiyaku.SYORIPTN = KeisanGaikakanzanMockForSinkeiyaku.TESTPATTERN1;
        GetKiteiCheckYenkansangkMockForSinkeiyaku.SYORIPTN = GetKiteiCheckYenkansangkMockForSinkeiyaku.TESTPATTERN2;
        CheckSaiteiPMockForSinkeiyaku.SYORIPTN = CheckSaiteiPMockForSinkeiyaku.TESTPATTERN1;
        CheckTblMosSyouhin checkTblMosSyouhin = SWAKInjector.getInstance(CheckTblMosSyouhin.class);

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("860000454");
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

        exStringEquals(hubiMsgLst.get(0).getMosno(), "860000454", "申込番号");
        exNumericEquals(hubiMsgLst.get(0).getRenno(), 1, "連番");
        exStringEquals(hubiMsgLst.get(0).getMessageId(), "THC0113", "メッセージＩＤ");
        exStringEquals(hubiMsgLst.get(0).getHubimsg(), "【特認可能】外貨建て一時払終身保険（毎年受取型）　１５年毎利率再設定の最高手術給付金額の２０，４００円をオーバーしています。", "不備メッセージ");
        exClassificationEquals(hubiMsgLst.get(0).getHubisyubetukbn(), C_HubisyubetuKbn.KETHORYU_HUBI, "不備種別区分");
        exStringEquals(hubiMsgLst.get(0).getGyoumuKousinsyaId(), "JUnitTest", "業務用更新者ＩＤ");
        exStringEquals(hubiMsgLst.get(0).getGyoumuKousinTime(), "20160509141230000", "業務用更新時間");
    }
    @Test
    @TestOrder(4140)
    @Transactional
    public void testExec_D14() {
        MockObjectManager.initialize();
        BzGetAgInfoMockForSinkeiyaku.SYORIPTN = BzGetAgInfoMockForSinkeiyaku.TESTPATTERN4;
        KeisanGaikakanzanMockForSinkeiyaku.SYORIPTN = KeisanGaikakanzanMockForSinkeiyaku.TESTPATTERN1;
        GetKiteiCheckYenkansangkMockForSinkeiyaku.SYORIPTN = GetKiteiCheckYenkansangkMockForSinkeiyaku.TESTPATTERN3;
        CheckSaiteiPMockForSinkeiyaku.SYORIPTN = CheckSaiteiPMockForSinkeiyaku.TESTPATTERN1;
        CheckTblMosSyouhin checkTblMosSyouhin = SWAKInjector.getInstance(CheckTblMosSyouhin.class);

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("860000462");
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
        for (HT_HubiMsg hubiMsg : hubiMsgLst) {
            if ("THC0126".equals(hubiMsg.getMessageId())) {
                exStringEquals(hubiMsg.getMosno(), "860000462", "申込番号");
                exNumericEquals(hubiMsg.getRenno(), 2, "連番");
                exStringEquals(hubiMsg.getMessageId(), "THC0126", "メッセージＩＤ");
                exStringEquals(hubiMsg.getHubimsg(),
                    "【特認可能】外貨建て一時払変額年金保険（ブレンド型）　年金原資最低保証１２０％の最高通算限度額の２０，７００円をオーバーしています。", "不備メッセージ");
                exClassificationEquals(hubiMsg.getHubisyubetukbn(), C_HubisyubetuKbn.KETHORYU_HUBI, "不備種別区分");
                exStringEquals(hubiMsg.getGyoumuKousinsyaId(), "JUnitTest", "業務用更新者ＩＤ");
                exStringEquals(hubiMsg.getGyoumuKousinTime(), "20160509141230000", "業務用更新時間");
            }
        }
    }
    @Test
    @TestOrder(4150)
    @Transactional
    public void testExec_D15() {
        MockObjectManager.initialize();
        BzGetAgInfoMockForSinkeiyaku.SYORIPTN = BzGetAgInfoMockForSinkeiyaku.TESTPATTERN4;
        KeisanGaikakanzanMockForSinkeiyaku.SYORIPTN = KeisanGaikakanzanMockForSinkeiyaku.TESTPATTERN1;
        GetKiteiCheckYenkansangkMockForSinkeiyaku.SYORIPTN = GetKiteiCheckYenkansangkMockForSinkeiyaku.TESTPATTERN2;
        CheckSaiteiPMockForSinkeiyaku.SYORIPTN = CheckSaiteiPMockForSinkeiyaku.TESTPATTERN1;
        CheckTblMosSyouhin checkTblMosSyouhin = SWAKInjector.getInstance(CheckTblMosSyouhin.class);

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("860000470");
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
        for (HT_HubiMsg hubiMsg : hubiMsgLst) {
            if ("THC0201".equals(hubiMsg.getMessageId())) {
                exStringEquals(hubiMsg.getMosno(), "860000470", "申込番号");
                exNumericEquals(hubiMsg.getRenno(), 2, "連番");
                exStringEquals(hubiMsg.getMessageId(), "THC0201", "メッセージＩＤ");
                exStringEquals(hubiMsg.getHubimsg(),
                    "【特認可能】外貨建て一時払変額年金保険（ブレンド型）　年金原資最低保証１００％の給付金額が最高給付金額の２０，５００円をオーバーしています。", "不備メッセージ");
                exClassificationEquals(hubiMsg.getHubisyubetukbn(), C_HubisyubetuKbn.KETHORYU_HUBI, "不備種別区分");
                exStringEquals(hubiMsg.getGyoumuKousinsyaId(), "JUnitTest", "業務用更新者ＩＤ");
                exStringEquals(hubiMsg.getGyoumuKousinTime(), "20160509141230000", "業務用更新時間");
            }
        }
    }
    @Test
    @TestOrder(4160)
    @Transactional
    public void testExec_D16() {
        MockObjectManager.initialize();
        BzGetAgInfoMockForSinkeiyaku.SYORIPTN = BzGetAgInfoMockForSinkeiyaku.TESTPATTERN4;
        KeisanGaikakanzanMockForSinkeiyaku.SYORIPTN = KeisanGaikakanzanMockForSinkeiyaku.TESTPATTERN1;
        GetKiteiCheckYenkansangkMockForSinkeiyaku.SYORIPTN = GetKiteiCheckYenkansangkMockForSinkeiyaku.TESTPATTERN2;
        CheckSaiteiPMockForSinkeiyaku.SYORIPTN = CheckSaiteiPMockForSinkeiyaku.TESTPATTERN1;
        CheckTblMosSyouhin checkTblMosSyouhin = SWAKInjector.getInstance(CheckTblMosSyouhin.class);

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("860000488");
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
        for (HT_HubiMsg hubiMsg : hubiMsgLst) {
            if ("THC0202".equals(hubiMsg.getMessageId())) {
                exStringEquals(hubiMsg.getMosno(), "860000488", "申込番号");
                exNumericEquals(hubiMsg.getRenno(), 2, "連番");
                exStringEquals(hubiMsg.getMessageId(), "THC0202", "メッセージＩＤ");
                exStringEquals(hubiMsg.getHubimsg(),
                    "【特認可能】外貨建て一時払変額年金保険（ブレンド型）　年金原資最低保証１１５％の給付月額が最高給付月額の２０，６００円をオーバーしています。", "不備メッセージ");
                exClassificationEquals(hubiMsg.getHubisyubetukbn(), C_HubisyubetuKbn.KETHORYU_HUBI, "不備種別区分");
                exStringEquals(hubiMsg.getGyoumuKousinsyaId(), "JUnitTest", "業務用更新者ＩＤ");
                exStringEquals(hubiMsg.getGyoumuKousinTime(), "20160509141230000", "業務用更新時間");
            }
        }
    }
    @Test
    @TestOrder(4170)
    @Transactional
    public void testExec_D17() {
        MockObjectManager.initialize();
        BzGetAgInfoMockForSinkeiyaku.SYORIPTN = BzGetAgInfoMockForSinkeiyaku.TESTPATTERN4;
        KeisanGaikakanzanMockForSinkeiyaku.SYORIPTN = KeisanGaikakanzanMockForSinkeiyaku.TESTPATTERN1;
        GetKiteiCheckYenkansangkMockForSinkeiyaku.SYORIPTN = GetKiteiCheckYenkansangkMockForSinkeiyaku.TESTPATTERN2;
        CheckSaiteiPMockForSinkeiyaku.SYORIPTN = CheckSaiteiPMockForSinkeiyaku.TESTPATTERN1;
        CheckTblMosSyouhin checkTblMosSyouhin = SWAKInjector.getInstance(CheckTblMosSyouhin.class);

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("860000496");
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
        exStringEquals(hubiMsgLst.get(0).getMosno(), "860000496", "申込番号");
        exNumericEquals(hubiMsgLst.get(0).getRenno(), 1, "連番");
        exStringEquals(hubiMsgLst.get(0).getMessageId(), "EBC0046", "メッセージＩＤ");
        exStringEquals(hubiMsgLst.get(0).getHubimsg(), "据置期間が正しくありません。", "不備メッセージ");
        exClassificationEquals(hubiMsgLst.get(0).getHubisyubetukbn(), C_HubisyubetuKbn.KETHORYU_HUBI, "不備種別区分");
        exClassificationEquals(hubiMsgLst.get(0).getHubisyubetusyousaikbn(), C_HubisyubetusyousaiKbn.NONE,
            "不備種別詳細区分");
    }
    @Test(expected = CommonBizAppException.class)
    @TestOrder(4180)
    @Transactional
    public void testExec_D18() {
        MockObjectManager.initialize();
        BzGetAgInfoMockForSinkeiyaku.SYORIPTN = BzGetAgInfoMockForSinkeiyaku.TESTPATTERN4;
        KeisanGaikakanzanMockForSinkeiyaku.SYORIPTN = KeisanGaikakanzanMockForSinkeiyaku.TESTPATTERN1;
        GetKiteiCheckYenkansangkMockForSinkeiyaku.SYORIPTN = GetKiteiCheckYenkansangkMockForSinkeiyaku.TESTPATTERN2;
        CheckSaiteiPMockForSinkeiyaku.SYORIPTN = CheckSaiteiPMockForSinkeiyaku.TESTPATTERN1;
        CheckTblMosSyouhin checkTblMosSyouhin = SWAKInjector.getInstance(CheckTblMosSyouhin.class);

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("860000504");
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
            exStringEquals(e.getMessage(), "システム整合性エラーです。最高ＳＳ単位テーブルにデータが見つかりません。", "エラーメッセージ");
            throw e;
        }
    }
    @Test
    @TestOrder(4190)
    @Transactional
    public void testExec_D19() {
        MockObjectManager.initialize();
        BzGetAgInfoMockForSinkeiyaku.SYORIPTN = BzGetAgInfoMockForSinkeiyaku.TESTPATTERN4;
        KeisanGaikakanzanMockForSinkeiyaku.SYORIPTN = KeisanGaikakanzanMockForSinkeiyaku.TESTPATTERN1;
        GetKiteiCheckYenkansangkMockForSinkeiyaku.SYORIPTN = GetKiteiCheckYenkansangkMockForSinkeiyaku.TESTPATTERN2;
        CheckSaiteiPMockForSinkeiyaku.SYORIPTN = CheckSaiteiPMockForSinkeiyaku.TESTPATTERN1;
        CheckTblMosSyouhin checkTblMosSyouhin = SWAKInjector.getInstance(CheckTblMosSyouhin.class);

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("860000512");
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

        exStringEquals(hubiMsgLst.get(0).getMosno(), "860000512", "申込番号");
        exNumericEquals(hubiMsgLst.get(0).getRenno(), 1, "連番");
        exStringEquals(hubiMsgLst.get(0).getMessageId(), "EHC0033", "メッセージＩＤ");
        exStringEquals(hubiMsgLst.get(0).getHubimsg(), "外貨建て一時払終身保険（即時保障型）　１０年毎利率再設定の保険金額が１，０２１，０００円単位になっていません。", "不備メッセージ");
        exClassificationEquals(hubiMsgLst.get(0).getHubisyubetukbn(), C_HubisyubetuKbn.KETHORYU_HUBI, "不備種別区分");
        exStringEquals(hubiMsgLst.get(0).getGyoumuKousinsyaId(), "JUnitTest", "業務用更新者ＩＤ");
        exStringEquals(hubiMsgLst.get(0).getGyoumuKousinTime(), "20160509141230000", "業務用更新時間");
    }
    @Test
    @TestOrder(4200)
    @Transactional
    public void testExec_D20() {
        MockObjectManager.initialize();
        BzGetAgInfoMockForSinkeiyaku.SYORIPTN = BzGetAgInfoMockForSinkeiyaku.TESTPATTERN4;
        KeisanGaikakanzanMockForSinkeiyaku.SYORIPTN = KeisanGaikakanzanMockForSinkeiyaku.TESTPATTERN1;
        GetKiteiCheckYenkansangkMockForSinkeiyaku.SYORIPTN = GetKiteiCheckYenkansangkMockForSinkeiyaku.TESTPATTERN2;
        CheckSaiteiPMockForSinkeiyaku.SYORIPTN = CheckSaiteiPMockForSinkeiyaku.TESTPATTERN1;
        CheckTblMosSyouhin checkTblMosSyouhin = SWAKInjector.getInstance(CheckTblMosSyouhin.class);

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("860000520");
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

        exStringEquals(hubiMsgLst.get(0).getMosno(), "860000520", "申込番号");
        exNumericEquals(hubiMsgLst.get(0).getRenno(), 1, "連番");
        exStringEquals(hubiMsgLst.get(0).getMessageId(), "EHC0019", "メッセージＩＤ");
        exStringEquals(hubiMsgLst.get(0).getHubimsg(), "外貨建て一時払終身保険（即時保障型）　１５年毎利率再設定の１倍は取扱えません。", "不備メッセージ");
        exClassificationEquals(hubiMsgLst.get(0).getHubisyubetukbn(), C_HubisyubetuKbn.KETHORYU_HUBI, "不備種別区分");
        exStringEquals(hubiMsgLst.get(0).getGyoumuKousinsyaId(), "JUnitTest", "業務用更新者ＩＤ");
        exStringEquals(hubiMsgLst.get(0).getGyoumuKousinTime(), "20160509141230000", "業務用更新時間");

        exNumericEquals(hubiMsgLst.get(1).getRenno(), 2, "連番");
        exStringEquals(hubiMsgLst.get(1).getMessageId(), "EHC0033", "メッセージＩＤ");
        exStringEquals(hubiMsgLst.get(1).getHubimsg(), "外貨建て一時払終身保険（即時保障型）　１５年毎利率再設定の保険金額が１，０２０，４００円単位になっていません。", "不備メッセージ");
        exClassificationEquals(hubiMsgLst.get(1).getHubisyubetukbn(), C_HubisyubetuKbn.KETHORYU_HUBI, "不備種別区分");
    }

    @Test
    @TestOrder(4210)
    @Transactional
    public void testExec_D21() {
        MockObjectManager.initialize();
        BzGetAgInfoMockForSinkeiyaku.SYORIPTN = BzGetAgInfoMockForSinkeiyaku.TESTPATTERN4;
        KeisanGaikakanzanMockForSinkeiyaku.SYORIPTN = KeisanGaikakanzanMockForSinkeiyaku.TESTPATTERN1;
        GetKiteiCheckYenkansangkMockForSinkeiyaku.SYORIPTN = GetKiteiCheckYenkansangkMockForSinkeiyaku.TESTPATTERN2;
        CheckSaiteiPMockForSinkeiyaku.SYORIPTN = CheckSaiteiPMockForSinkeiyaku.TESTPATTERN1;
        CheckTblMosSyouhin checkTblMosSyouhin = SWAKInjector.getInstance(CheckTblMosSyouhin.class);

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("860000538");
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

        exStringEquals(hubiMsgLst.get(0).getMosno(), "860000538", "申込番号");
        exNumericEquals(hubiMsgLst.get(0).getRenno(), 1, "連番");
        exStringEquals(hubiMsgLst.get(0).getMessageId(), "EHC0083", "メッセージＩＤ");
        exStringEquals(hubiMsgLst.get(0).getHubimsg(), "外貨建て一時払終身保険（毎年受取型）　１０年毎利率再設定の給付日額が１，４８０，０００円単位になっていません。", "不備メッセージ");
        exClassificationEquals(hubiMsgLst.get(0).getHubisyubetukbn(), C_HubisyubetuKbn.KETHORYU_HUBI, "不備種別区分");
        exStringEquals(hubiMsgLst.get(0).getGyoumuKousinsyaId(), "JUnitTest", "業務用更新者ＩＤ");
        exStringEquals(hubiMsgLst.get(0).getGyoumuKousinTime(), "20160509141230000", "業務用更新時間");
    }

    @Test
    @TestOrder(4220)
    @Transactional
    public void testExec_D22() {
        MockObjectManager.initialize();
        BzGetAgInfoMockForSinkeiyaku.SYORIPTN = BzGetAgInfoMockForSinkeiyaku.TESTPATTERN4;
        KeisanGaikakanzanMockForSinkeiyaku.SYORIPTN = KeisanGaikakanzanMockForSinkeiyaku.TESTPATTERN1;
        GetKiteiCheckYenkansangkMockForSinkeiyaku.SYORIPTN = GetKiteiCheckYenkansangkMockForSinkeiyaku.TESTPATTERN2;
        CheckSaiteiPMockForSinkeiyaku.SYORIPTN = CheckSaiteiPMockForSinkeiyaku.TESTPATTERN1;
        CheckTblMosSyouhin checkTblMosSyouhin = SWAKInjector.getInstance(CheckTblMosSyouhin.class);

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("860000546");
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

        exStringEquals(hubiMsgLst.get(0).getMosno(), "860000546", "申込番号");
        exNumericEquals(hubiMsgLst.get(0).getRenno(), 1, "連番");
        exStringEquals(hubiMsgLst.get(0).getMessageId(), "EHC0114", "メッセージＩＤ");
        exStringEquals(hubiMsgLst.get(0).getHubimsg(), "外貨建て一時払終身保険（毎年受取型）　１５年毎利率再設定の給付金額が１，０２０，５００円単位になっていません。", "不備メッセージ");
        exClassificationEquals(hubiMsgLst.get(0).getHubisyubetukbn(), C_HubisyubetuKbn.KETHORYU_HUBI, "不備種別区分");
        exStringEquals(hubiMsgLst.get(0).getGyoumuKousinsyaId(), "JUnitTest", "業務用更新者ＩＤ");
        exStringEquals(hubiMsgLst.get(0).getGyoumuKousinTime(), "20160509141230000", "業務用更新時間");
    }
    @Test
    @TestOrder(4230)
    @Transactional
    public void testExec_D23() {
        MockObjectManager.initialize();
        BzGetAgInfoMockForSinkeiyaku.SYORIPTN = BzGetAgInfoMockForSinkeiyaku.TESTPATTERN4;
        KeisanGaikakanzanMockForSinkeiyaku.SYORIPTN = KeisanGaikakanzanMockForSinkeiyaku.TESTPATTERN1;
        GetKiteiCheckYenkansangkMockForSinkeiyaku.SYORIPTN = GetKiteiCheckYenkansangkMockForSinkeiyaku.TESTPATTERN2;
        CheckSaiteiPMockForSinkeiyaku.SYORIPTN = CheckSaiteiPMockForSinkeiyaku.TESTPATTERN1;
        CheckTblMosSyouhin checkTblMosSyouhin = SWAKInjector.getInstance(CheckTblMosSyouhin.class);

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("860000553");
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
        for (HT_HubiMsg hubiMsg : hubiMsgLst) {
            if ("EHC0114".equals(hubiMsg.getMessageId())) {
                exStringEquals(hubiMsg.getMosno(), "860000553", "申込番号");
                exNumericEquals(hubiMsg.getRenno(), 2, "連番");
                exStringEquals(hubiMsg.getMessageId(), "EHC0114", "メッセージＩＤ");
                exStringEquals(hubiMsg.getHubimsg(), "外貨建て一時払変額年金保険（ブレンド型）　年金原資最低保証１００％の給付金額が１，０２０，６００円単位になっていません。",
                    "不備メッセージ");
                exClassificationEquals(hubiMsg.getHubisyubetukbn(), C_HubisyubetuKbn.KETHORYU_HUBI, "不備種別区分");
                exStringEquals(hubiMsg.getGyoumuKousinsyaId(), "JUnitTest", "業務用更新者ＩＤ");
                exStringEquals(hubiMsg.getGyoumuKousinTime(), "20160509141230000", "業務用更新時間");
            }
        }
    }
    @Test
    @TestOrder(4240)
    @Transactional
    public void testExec_D24() {
        MockObjectManager.initialize();
        BzGetAgInfoMockForSinkeiyaku.SYORIPTN = BzGetAgInfoMockForSinkeiyaku.TESTPATTERN4;
        KeisanGaikakanzanMockForSinkeiyaku.SYORIPTN = KeisanGaikakanzanMockForSinkeiyaku.TESTPATTERN1;
        GetKiteiCheckYenkansangkMockForSinkeiyaku.SYORIPTN = GetKiteiCheckYenkansangkMockForSinkeiyaku.TESTPATTERN2;
        CheckSaiteiPMockForSinkeiyaku.SYORIPTN = CheckSaiteiPMockForSinkeiyaku.TESTPATTERN1;
        CheckTblMosSyouhin checkTblMosSyouhin = SWAKInjector.getInstance(CheckTblMosSyouhin.class);

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("860000561");
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
        for (HT_HubiMsg hubiMsg : hubiMsgLst) {
            if ("EHC0203".equals(hubiMsg.getMessageId())) {
                exStringEquals(hubiMsg.getMosno(), "860000561", "申込番号");
                exNumericEquals(hubiMsg.getRenno(), 2, "連番");
                exStringEquals(hubiMsg.getMessageId(), "EHC0203", "メッセージＩＤ");
                exStringEquals(hubiMsg.getHubimsg(), "外貨建て一時払変額年金保険（ブレンド型）　年金原資最低保証１１５％の給付月額が１，０２０，７００円単位になっていません。",
                    "不備メッセージ");
                exClassificationEquals(hubiMsg.getHubisyubetukbn(), C_HubisyubetuKbn.KETHORYU_HUBI, "不備種別区分");
                exStringEquals(hubiMsg.getGyoumuKousinsyaId(), "JUnitTest", "業務用更新者ＩＤ");
                exStringEquals(hubiMsg.getGyoumuKousinTime(), "20160509141230000", "業務用更新時間");
            }
        }
    }
    @Test
    @TestOrder(4250)
    @Transactional
    public void testExec_D25() {
        MockObjectManager.initialize();
        BzGetAgInfoMockForSinkeiyaku.SYORIPTN = BzGetAgInfoMockForSinkeiyaku.TESTPATTERN4;
        KeisanGaikakanzanMockForSinkeiyaku.SYORIPTN = KeisanGaikakanzanMockForSinkeiyaku.TESTPATTERN1;
        GetKiteiCheckYenkansangkMockForSinkeiyaku.SYORIPTN = GetKiteiCheckYenkansangkMockForSinkeiyaku.TESTPATTERN2;
        CheckSaiteiPMockForSinkeiyaku.SYORIPTN = CheckSaiteiPMockForSinkeiyaku.TESTPATTERN1;
        CheckTblMosSyouhin checkTblMosSyouhin = SWAKInjector.getInstance(CheckTblMosSyouhin.class);

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("860000579");
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

        exNumericEquals(hubiMsgLst.size(), 2, "不備メッセージテーブルエンティティリストのサイズ");
        exStringEquals(hubiMsgLst.get(0).getMosno(), "860000579", "申込番号");
        exNumericEquals(hubiMsgLst.get(0).getRenno(), 1, "連番");
        exStringEquals(hubiMsgLst.get(0).getMessageId(), "EBC0046", "メッセージＩＤ");
        exStringEquals(hubiMsgLst.get(0).getHubimsg(), "据置期間が正しくありません。", "不備メッセージ");
        exClassificationEquals(hubiMsgLst.get(0).getHubisyubetukbn(), C_HubisyubetuKbn.KETHORYU_HUBI, "不備種別区分");
        exClassificationEquals(hubiMsgLst.get(0).getHubisyubetusyousaikbn(), C_HubisyubetusyousaiKbn.NONE,
            "不備種別詳細区分");

        exStringEquals(hubiMsgLst.get(1).getMosno(), "860000579", "申込番号");
        exNumericEquals(hubiMsgLst.get(1).getRenno(), 2, "連番");
        exStringEquals(hubiMsgLst.get(1).getMessageId(), "EHC0126", "メッセージＩＤ");
        exStringEquals(hubiMsgLst.get(1).getHubimsg(), "外貨建て一時払変額年金保険（ブレンド型）　年金原資最低保証１２０％の最高通算限度額の３０，６００円をオーバーしています。", "不備メッセージ");
        exClassificationEquals(hubiMsgLst.get(1).getHubisyubetukbn(), C_HubisyubetuKbn.KETHORYU_HUBI, "不備種別区分");
        exClassificationEquals(hubiMsgLst.get(1).getHubisyubetusyousaikbn(), C_HubisyubetusyousaiKbn.NONE,
            "不備種別詳細区分");
    }
    @Test
    @TestOrder(4260)
    @Transactional
    public void testExec_D26() {
        MockObjectManager.initialize();
        BzGetAgInfoMockForSinkeiyaku.SYORIPTN = BzGetAgInfoMockForSinkeiyaku.TESTPATTERN4;
        KeisanGaikakanzanMockForSinkeiyaku.SYORIPTN = KeisanGaikakanzanMockForSinkeiyaku.TESTPATTERN1;
        GetKiteiCheckYenkansangkMockForSinkeiyaku.SYORIPTN = GetKiteiCheckYenkansangkMockForSinkeiyaku.TESTPATTERN2;
        CheckSaiteiPMockForSinkeiyaku.SYORIPTN = CheckSaiteiPMockForSinkeiyaku.TESTPATTERN1;
        CheckTblMosSyouhin checkTblMosSyouhin = SWAKInjector.getInstance(CheckTblMosSyouhin.class);

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("860000587");
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

        exStringEquals(hubiMsgLst.get(0).getMosno(), "860000587", "申込番号");
        exNumericEquals(hubiMsgLst.get(0).getRenno(), 1, "連番");
        exStringEquals(hubiMsgLst.get(0).getMessageId(), "EHC0032", "メッセージＩＤ");
        exStringEquals(hubiMsgLst.get(0).getHubimsg(), "外貨建て一時払終身保険（即時保障型）　１０年毎利率再設定の保険金額が最高Ｓの３０，０００円をオーバーしています。", "不備メッセージ");
        exClassificationEquals(hubiMsgLst.get(0).getHubisyubetukbn(), C_HubisyubetuKbn.KETHORYU_HUBI, "不備種別区分");
        exStringEquals(hubiMsgLst.get(0).getGyoumuKousinsyaId(), "JUnitTest", "業務用更新者ＩＤ");
        exStringEquals(hubiMsgLst.get(0).getGyoumuKousinTime(), "20160509141230000", "業務用更新時間");
    }
    @Test
    @TestOrder(4270)
    @Transactional
    public void testExec_D27() {
        MockObjectManager.initialize();
        BzGetAgInfoMockForSinkeiyaku.SYORIPTN = BzGetAgInfoMockForSinkeiyaku.TESTPATTERN4;
        KeisanGaikakanzanMockForSinkeiyaku.SYORIPTN = KeisanGaikakanzanMockForSinkeiyaku.TESTPATTERN1;
        GetKiteiCheckYenkansangkMockForSinkeiyaku.SYORIPTN = GetKiteiCheckYenkansangkMockForSinkeiyaku.TESTPATTERN2;
        CheckSaiteiPMockForSinkeiyaku.SYORIPTN = CheckSaiteiPMockForSinkeiyaku.TESTPATTERN1;
        CheckTblMosSyouhin checkTblMosSyouhin = SWAKInjector.getInstance(CheckTblMosSyouhin.class);

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("860000595");
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

        exStringEquals(hubiMsgLst.get(0).getMosno(), "860000595", "申込番号");
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
    }
    @Test
    @TestOrder(4280)
    @Transactional
    public void testExec_D28() {
        MockObjectManager.initialize();
        BzGetAgInfoMockForSinkeiyaku.SYORIPTN = BzGetAgInfoMockForSinkeiyaku.TESTPATTERN4;
        KeisanGaikakanzanMockForSinkeiyaku.SYORIPTN = KeisanGaikakanzanMockForSinkeiyaku.TESTPATTERN1;
        GetKiteiCheckYenkansangkMockForSinkeiyaku.SYORIPTN = GetKiteiCheckYenkansangkMockForSinkeiyaku.TESTPATTERN2;
        CheckSaiteiPMockForSinkeiyaku.SYORIPTN = CheckSaiteiPMockForSinkeiyaku.TESTPATTERN1;
        CheckTblMosSyouhin checkTblMosSyouhin = SWAKInjector.getInstance(CheckTblMosSyouhin.class);

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("860000603");
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

        exStringEquals(hubiMsgLst.get(0).getMosno(), "860000603", "申込番号");
        exNumericEquals(hubiMsgLst.get(0).getRenno(), 1, "連番");
        exStringEquals(hubiMsgLst.get(0).getMessageId(), "EHC0082", "メッセージＩＤ");
        exStringEquals(hubiMsgLst.get(0).getHubimsg(), "外貨建て一時払終身保険（毎年受取型）　１０年毎利率再設定の給付日額が最高日額の３０，２００円をオーバーしています。", "不備メッセージ");
        exClassificationEquals(hubiMsgLst.get(0).getHubisyubetukbn(), C_HubisyubetuKbn.KETHORYU_HUBI, "不備種別区分");
        exStringEquals(hubiMsgLst.get(0).getGyoumuKousinsyaId(), "JUnitTest", "業務用更新者ＩＤ");
        exStringEquals(hubiMsgLst.get(0).getGyoumuKousinTime(), "20160509141230000", "業務用更新時間");
    }
    @Test
    @TestOrder(4290)
    @Transactional
    public void testExec_D29() {
        MockObjectManager.initialize();
        BzGetAgInfoMockForSinkeiyaku.SYORIPTN = BzGetAgInfoMockForSinkeiyaku.TESTPATTERN4;
        KeisanGaikakanzanMockForSinkeiyaku.SYORIPTN = KeisanGaikakanzanMockForSinkeiyaku.TESTPATTERN1;
        GetKiteiCheckYenkansangkMockForSinkeiyaku.SYORIPTN = GetKiteiCheckYenkansangkMockForSinkeiyaku.TESTPATTERN2;
        CheckSaiteiPMockForSinkeiyaku.SYORIPTN = CheckSaiteiPMockForSinkeiyaku.TESTPATTERN1;
        CheckTblMosSyouhin checkTblMosSyouhin = SWAKInjector.getInstance(CheckTblMosSyouhin.class);

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("860000611");
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

        exStringEquals(hubiMsgLst.get(0).getMosno(), "860000611", "申込番号");
        exNumericEquals(hubiMsgLst.get(0).getRenno(), 1, "連番");
        exStringEquals(hubiMsgLst.get(0).getMessageId(), "EHC0113", "メッセージＩＤ");
        exStringEquals(hubiMsgLst.get(0).getHubimsg(), "外貨建て一時払終身保険（毎年受取型）　１５年毎利率再設定の最高手術給付金額の３０，３００円をオーバーしています。", "不備メッセージ");
        exClassificationEquals(hubiMsgLst.get(0).getHubisyubetukbn(), C_HubisyubetuKbn.KETHORYU_HUBI, "不備種別区分");
        exStringEquals(hubiMsgLst.get(0).getGyoumuKousinsyaId(), "JUnitTest", "業務用更新者ＩＤ");
        exStringEquals(hubiMsgLst.get(0).getGyoumuKousinTime(), "20160509141230000", "業務用更新時間");
    }
    @Test
    @TestOrder(4300)
    @Transactional
    public void testExec_D30() {
        MockObjectManager.initialize();
        BzGetAgInfoMockForSinkeiyaku.SYORIPTN = BzGetAgInfoMockForSinkeiyaku.TESTPATTERN4;
        KeisanGaikakanzanMockForSinkeiyaku.SYORIPTN = KeisanGaikakanzanMockForSinkeiyaku.TESTPATTERN1;
        GetKiteiCheckYenkansangkMockForSinkeiyaku.SYORIPTN = GetKiteiCheckYenkansangkMockForSinkeiyaku.TESTPATTERN3;
        CheckSaiteiPMockForSinkeiyaku.SYORIPTN = CheckSaiteiPMockForSinkeiyaku.TESTPATTERN1;
        CheckTblMosSyouhin checkTblMosSyouhin = SWAKInjector.getInstance(CheckTblMosSyouhin.class);

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("860000629");
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
        for (HT_HubiMsg hubiMsg : hubiMsgLst) {
            if ("EHC0126".equals(hubiMsg.getMessageId())) {
                exStringEquals(hubiMsg.getMosno(), "860000629", "申込番号");
                exNumericEquals(hubiMsg.getRenno(), 2, "連番");
                exStringEquals(hubiMsg.getMessageId(), "EHC0126", "メッセージＩＤ");
                exStringEquals(hubiMsg.getHubimsg(),
                    "外貨建て一時払変額年金保険（ブレンド型）　年金原資最低保証１２０％の最高通算限度額の３０，６００円をオーバーしています。", "不備メッセージ");
                exClassificationEquals(hubiMsg.getHubisyubetukbn(), C_HubisyubetuKbn.KETHORYU_HUBI, "不備種別区分");
                exStringEquals(hubiMsg.getGyoumuKousinsyaId(), "JUnitTest", "業務用更新者ＩＤ");
                exStringEquals(hubiMsg.getGyoumuKousinTime(), "20160509141230000", "業務用更新時間");
            }
        }
    }
    @Test
    @TestOrder(4310)
    @Transactional
    public void testExec_D31() {
        MockObjectManager.initialize();
        BzGetAgInfoMockForSinkeiyaku.SYORIPTN = BzGetAgInfoMockForSinkeiyaku.TESTPATTERN4;
        KeisanGaikakanzanMockForSinkeiyaku.SYORIPTN = KeisanGaikakanzanMockForSinkeiyaku.TESTPATTERN1;
        GetKiteiCheckYenkansangkMockForSinkeiyaku.SYORIPTN = GetKiteiCheckYenkansangkMockForSinkeiyaku.TESTPATTERN2;
        CheckSaiteiPMockForSinkeiyaku.SYORIPTN = CheckSaiteiPMockForSinkeiyaku.TESTPATTERN1;
        CheckTblMosSyouhin checkTblMosSyouhin = SWAKInjector.getInstance(CheckTblMosSyouhin.class);

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("860000637");
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
        for (HT_HubiMsg hubiMsg : hubiMsgLst) {
            if ("EHC0201".equals(hubiMsg.getMessageId())) {
                exStringEquals(hubiMsg.getMosno(), "860000637", "申込番号");
                exNumericEquals(hubiMsg.getRenno(), 2, "連番");
                exStringEquals(hubiMsg.getMessageId(), "EHC0201", "メッセージＩＤ");
                exStringEquals(hubiMsg.getHubimsg(),
                    "外貨建て一時払変額年金保険（ブレンド型）　年金原資最低保証１００％の給付金額が最高給付金額の３０，４００円をオーバーしています。", "不備メッセージ");
                exClassificationEquals(hubiMsg.getHubisyubetukbn(), C_HubisyubetuKbn.KETHORYU_HUBI, "不備種別区分");
                exStringEquals(hubiMsg.getGyoumuKousinsyaId(), "JUnitTest", "業務用更新者ＩＤ");
                exStringEquals(hubiMsg.getGyoumuKousinTime(), "20160509141230000", "業務用更新時間");
            }
        }
    }
    @Test
    @TestOrder(4320)
    @Transactional
    public void testExec_D32() {
        MockObjectManager.initialize();
        BzGetAgInfoMockForSinkeiyaku.SYORIPTN = BzGetAgInfoMockForSinkeiyaku.TESTPATTERN4;
        KeisanGaikakanzanMockForSinkeiyaku.SYORIPTN = KeisanGaikakanzanMockForSinkeiyaku.TESTPATTERN1;
        GetKiteiCheckYenkansangkMockForSinkeiyaku.SYORIPTN = GetKiteiCheckYenkansangkMockForSinkeiyaku.TESTPATTERN2;
        CheckSaiteiPMockForSinkeiyaku.SYORIPTN = CheckSaiteiPMockForSinkeiyaku.TESTPATTERN1;
        CheckTblMosSyouhin checkTblMosSyouhin = SWAKInjector.getInstance(CheckTblMosSyouhin.class);

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("860000645");
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
        for (HT_HubiMsg hubiMsg : hubiMsgLst) {
            if ("EHC0202".equals(hubiMsg.getMessageId())) {
                exStringEquals(hubiMsg.getMosno(), "860000645", "申込番号");
                exNumericEquals(hubiMsg.getRenno(), 2, "連番");
                exStringEquals(hubiMsg.getMessageId(), "EHC0202", "メッセージＩＤ");
                exStringEquals(hubiMsg.getHubimsg(), "外貨建て一時払変額年金保険（ブレンド型）　年金原資最低保証１１５％の給付月額が最高給付月額の４，０６３，０００円をオーバーしています。", "不備メッセージ");
                exClassificationEquals(hubiMsg.getHubisyubetukbn(), C_HubisyubetuKbn.KETHORYU_HUBI, "不備種別区分");
                exStringEquals(hubiMsg.getGyoumuKousinsyaId(), "JUnitTest", "業務用更新者ＩＤ");
                exStringEquals(hubiMsg.getGyoumuKousinTime(), "20160509141230000", "業務用更新時間");}}
    }
    @Test
    @TestOrder(4330)
    @Transactional
    public void testExec_D33() {
        MockObjectManager.initialize();
        BzGetAgInfoMockForSinkeiyaku.SYORIPTN = BzGetAgInfoMockForSinkeiyaku.TESTPATTERN4;
        KeisanGaikakanzanMockForSinkeiyaku.SYORIPTN = KeisanGaikakanzanMockForSinkeiyaku.TESTPATTERN1;
        GetKiteiCheckYenkansangkMockForSinkeiyaku.SYORIPTN = GetKiteiCheckYenkansangkMockForSinkeiyaku.TESTPATTERN2;
        CheckSaiteiPMockForSinkeiyaku.SYORIPTN = CheckSaiteiPMockForSinkeiyaku.TESTPATTERN1;
        CheckTblMosSyouhin checkTblMosSyouhin = SWAKInjector.getInstance(CheckTblMosSyouhin.class);

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("860000652");
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
        exStringEquals(hubiMsgLst.get(0).getMosno(), "860000652", "申込番号");
        exNumericEquals(hubiMsgLst.get(0).getRenno(), 1, "連番");
        exStringEquals(hubiMsgLst.get(0).getMessageId(), "EBC0046", "メッセージＩＤ");
        exStringEquals(hubiMsgLst.get(0).getHubimsg(), "据置期間が正しくありません。", "不備メッセージ");
        exClassificationEquals(hubiMsgLst.get(0).getHubisyubetukbn(), C_HubisyubetuKbn.KETHORYU_HUBI, "不備種別区分");
        exClassificationEquals(hubiMsgLst.get(0).getHubisyubetusyousaikbn(), C_HubisyubetusyousaiKbn.NONE,
            "不備種別詳細区分");
    }
    @Test
    @TestOrder(4340)
    @Transactional
    public void testExec_D34() {
        MockObjectManager.initialize();
        BzGetAgInfoMockForSinkeiyaku.SYORIPTN = BzGetAgInfoMockForSinkeiyaku.TESTPATTERN4;
        KeisanGaikakanzanMockForSinkeiyaku.SYORIPTN = KeisanGaikakanzanMockForSinkeiyaku.TESTPATTERN1;
        GetKiteiCheckYenkansangkMockForSinkeiyaku.SYORIPTN = GetKiteiCheckYenkansangkMockForSinkeiyaku.TESTPATTERN4;
        CheckSaiteiPMockForSinkeiyaku.SYORIPTN = CheckSaiteiPMockForSinkeiyaku.TESTPATTERN1;
        CheckTblMosSyouhin checkTblMosSyouhin = SWAKInjector.getInstance(CheckTblMosSyouhin.class);

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("860000660");
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
        exStringEquals(hubiMsgLst.get(0).getMosno(), "860000660", "申込番号");
        exNumericEquals(hubiMsgLst.get(0).getRenno(), 1, "連番");
        exStringEquals(hubiMsgLst.get(0).getMessageId(), "EBC0046", "メッセージＩＤ");
        exStringEquals(hubiMsgLst.get(0).getHubimsg(), "据置期間が正しくありません。", "不備メッセージ");
        exClassificationEquals(hubiMsgLst.get(0).getHubisyubetukbn(), C_HubisyubetuKbn.KETHORYU_HUBI, "不備種別区分");
        exClassificationEquals(hubiMsgLst.get(0).getHubisyubetusyousaikbn(), C_HubisyubetusyousaiKbn.NONE,
            "不備種別詳細区分");
    }
    @Test
    @TestOrder(4350)
    @Transactional
    public void testExec_D35() {
        MockObjectManager.initialize();
        BzGetAgInfoMockForSinkeiyaku.SYORIPTN = BzGetAgInfoMockForSinkeiyaku.TESTPATTERN4;
        KeisanGaikakanzanMockForSinkeiyaku.SYORIPTN = KeisanGaikakanzanMockForSinkeiyaku.TESTPATTERN1;
        GetKiteiCheckYenkansangkMockForSinkeiyaku.SYORIPTN = GetKiteiCheckYenkansangkMockForSinkeiyaku.TESTPATTERN5;
        CheckSaiteiPMockForSinkeiyaku.SYORIPTN = CheckSaiteiPMockForSinkeiyaku.TESTPATTERN1;
        CheckTblMosSyouhin checkTblMosSyouhin = SWAKInjector.getInstance(CheckTblMosSyouhin.class);

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("860000678");
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
        exStringEquals(hubiMsgLst.get(0).getMosno(), "860000678", "申込番号");
        exNumericEquals(hubiMsgLst.get(0).getRenno(), 1, "連番");
        exStringEquals(hubiMsgLst.get(0).getMessageId(), "EBC0046", "メッセージＩＤ");
        exStringEquals(hubiMsgLst.get(0).getHubimsg(), "据置期間が正しくありません。", "不備メッセージ");
        exClassificationEquals(hubiMsgLst.get(0).getHubisyubetukbn(), C_HubisyubetuKbn.KETHORYU_HUBI, "不備種別区分");
        exClassificationEquals(hubiMsgLst.get(0).getHubisyubetusyousaikbn(), C_HubisyubetusyousaiKbn.NONE,
            "不備種別詳細区分");
    }
    @Test
    @TestOrder(4360)
    @Transactional
    public void testExec_D36() {
        MockObjectManager.initialize();
        BzGetAgInfoMockForSinkeiyaku.SYORIPTN = BzGetAgInfoMockForSinkeiyaku.TESTPATTERN4;
        KeisanGaikakanzanMockForSinkeiyaku.SYORIPTN = KeisanGaikakanzanMockForSinkeiyaku.TESTPATTERN1;
        GetKiteiCheckYenkansangkMockForSinkeiyaku.SYORIPTN = GetKiteiCheckYenkansangkMockForSinkeiyaku.TESTPATTERN2;
        CheckSaiteiPMockForSinkeiyaku.SYORIPTN = CheckSaiteiPMockForSinkeiyaku.TESTPATTERN1;
        CheckTblMosSyouhin checkTblMosSyouhin = SWAKInjector.getInstance(CheckTblMosSyouhin.class);

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("980000053");
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
        exStringEquals(mosnaiCheckParam.getSekmossakuseiErrmsg2(), "保険金額は１０２万円単位にしてください", "設計書申込書作成エラーメッセージ２");
        exClassificationEquals(mosnaiCheckParam.getKouzokuSyoriJikkouKbn(), C_KouzokujkKbn.NONE, "後続処理実行区分");
    }

    @Test(expected = CommonBizAppException.class)
    @TestOrder(4370)
    @Transactional
    public void testExec_D37() {
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
        mosnaiCheckParam.setListHubiMsg(new ArrayList<HT_HubiMsg>());
        try {
            checkTblMosSyouhin.exec(mosnaiCheckParam);
        } catch (CommonBizAppException e) {
            exStringEquals(e.getMessage(), "システム整合性エラーです。Ｓ単位テーブルにデータが見つかりません。", "エラーメッセージ");
            throw e;
        }
    }

    @Test
    @TestOrder(4380)
    @Transactional
    public void testExec_D38() {

        BzGetAgInfoMockForSinkeiyaku.SYORIPTN = BzGetAgInfoMockForSinkeiyaku.TESTPATTERN4;
        KeisanGaikakanzanMockForSinkeiyaku.SYORIPTN = null;
        GetKiteiCheckYenkansangkMockForSinkeiyaku.SYORIPTN = GetKiteiCheckYenkansangkMockForSinkeiyaku.TESTPATTERN2;
        CheckSaiteiPMockForSinkeiyaku.SYORIPTN = CheckSaiteiPMockForSinkeiyaku.TESTPATTERN1;
        CheckTblMosSyouhin checkTblMosSyouhin = SWAKInjector.getInstance(CheckTblMosSyouhin.class);

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("860000017");
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
        exStringEquals(mosnaiCheckParam.getSekmossakuseiErrmsg2(), "最高保険金額を超えています　保険金額は１４，８００ユーロまでにしてください", "設計書申込書作成エラーメッセージ２");
        exClassificationEquals(mosnaiCheckParam.getKouzokuSyoriJikkouKbn(), C_KouzokujkKbn.NONE, "後続処理実行区分");
    }

}