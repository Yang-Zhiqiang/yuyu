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
import yuyu.common.sinkeiyaku.skcommon.ConvNenSaiMankiMockForSinkeiyaku;
import yuyu.common.sinkeiyaku.skcommon.EditNenkinKoumokuUtil;
import yuyu.common.sinkeiyaku.skcommon.EditNenkinKoumokuUtilMockForSinkeiyaku;
import yuyu.common.sinkeiyaku.skcommon.GetKiteiCheckYenkansangk;
import yuyu.common.sinkeiyaku.skcommon.GetKiteiCheckYenkansangkMockForSinkeiyaku;
import yuyu.def.biz.manager.BizDomManager;
import yuyu.def.classification.C_BosyuusysctrlKbn;
import yuyu.def.classification.C_Channelcd;
import yuyu.def.classification.C_HubisyubetuKbn;
import yuyu.def.classification.C_HubisyubetusyousaiKbn;
import yuyu.def.classification.C_KouzokujkKbn;
import yuyu.def.classification.C_SeihowebsousasyaKbn;
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
public class CheckTblMosSyouhinTest_exec {

    @Inject
    private MosnaiCheckParam mosnaiCheckParam;

    @Inject
    private SinkeiyakuDomManager sinkeiyakuDomManager;

    @Inject
    private BizDomManager bizDomManager;
    private final static String fileName = "UT-SP_単体テスト仕様書（共通）_申込商品TBLチェック";

    private final static String sheetName = "INデータ";

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
            testDataAndTblMap = testDataMaker.getInData(CheckTblMosSyouhinTest_exec.class, fileName, sheetName);
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
        HanteiMoschkMockForSinkeiyaku.caller = CheckTblMosSyouhinTest_exec.class;
        EditNenkinKoumokuUtilMockForSinkeiyaku.caller = CheckTblMosSyouhinTest_exec.class;

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

        EditNenkinKoumokuUtilMockForSinkeiyaku.caller = null;
        EditNenkinKoumokuUtilMockForSinkeiyaku.SYORIPTN = null;

        HanteiMoschkMockForSinkeiyaku.caller = null;
        HanteiMoschkMockForSinkeiyaku.SYORIPTN = null;

        MockObjectManager.initialize();

    }

    @Test(expected = CommonBizAppException.class)
    @TestOrder(1010)
    @Transactional
    public void testExec_A1() {

        CheckTblMosSyouhin checkTblMosSyouhin = SWAKInjector.getInstance(CheckTblMosSyouhin.class);

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("860000017");
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setSysKbn(C_SysKbn.ESHIEN);
        mosnaiCheckParam.setKokutiChkHuyoUmu(C_UmuKbn.NONE);
        mosnaiCheckParam.setSekmossakuseiSousasyaKbn(C_SeihowebsousasyaKbn.DIRTNBSYNN);

        try {
            checkTblMosSyouhin.exec(mosnaiCheckParam);
        } catch (CommonBizAppException e) {
            exStringEquals(e.getMessage(), "システム整合性エラーです。主契約申込商品件数異常 申込番号：860000017", "エラーメッセージ");
            throw e;
        }
    }
    @Test
    @TestOrder(1020)
    @Transactional
    public void testExec_A2() {

        MockObjectManager.initialize();
        CheckSaiteiPMockForSinkeiyaku.SYORIPTN = CheckSaiteiPMockForSinkeiyaku.TESTPATTERN1;
        CheckTblMosSyouhin checkTblMosSyouhin = SWAKInjector.getInstance(CheckTblMosSyouhin.class);

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("860000025");
        List<HT_MosSyouhn> syuMosSyouhnParamLst = syoriCTL.getMosSyouhnsBySyutkkbn(C_SyutkKbn.SYU);
        HT_MosSyouhn syuMosSyouhnParam = syuMosSyouhnParamLst.get(0);
        BM_SyouhnZokusei syuSyouhnZokusei = bizDomManager.getSyouhnZokusei(syuMosSyouhnParam.getSyouhncd(),
            syuMosSyouhnParam.getSyouhnsdno());
        mosnaiCheckParam.setSyuSyouhnZokusei(syuSyouhnZokusei);
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setSysKbn(C_SysKbn.ESHIEN);
        mosnaiCheckParam.setKokutiChkHuyoUmu(C_UmuKbn.NONE);
        mosnaiCheckParam.setSysDate(BizDate.valueOf(20160102));
        mosnaiCheckParam.setSekmossakuseiSousasyaKbn(C_SeihowebsousasyaKbn.SUPPORTDESK);
        mosnaiCheckParam.setKiteiCheckChannelCd(C_Channelcd.BLNK);

        checkTblMosSyouhin.exec(mosnaiCheckParam);

        exClassificationEquals(mosnaiCheckParam.getKouzokuSyoriJikkouKbn(), C_KouzokujkKbn.JIKKOU, "後続処理実行区分");

    }
    @Test
    @TestOrder(1030)
    @Transactional
    public void testExec_A3() {
        MockObjectManager.initialize();
        BzGetAgInfoMockForSinkeiyaku.SYORIPTN = BzGetAgInfoMockForSinkeiyaku.TESTPATTERN1;
        CheckSaiteiPMockForSinkeiyaku.SYORIPTN = CheckSaiteiPMockForSinkeiyaku.TESTPATTERN1;
        CheckTblMosSyouhin checkTblMosSyouhin = SWAKInjector.getInstance(CheckTblMosSyouhin.class);

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("860000033");
        List<HT_MosSyouhn> syuMosSyouhnParamLst = syoriCTL.getMosSyouhnsBySyutkkbn(C_SyutkKbn.SYU);
        HT_MosSyouhn syuMosSyouhnParam = syuMosSyouhnParamLst.get(0);
        BM_SyouhnZokusei syuSyouhnZokusei = bizDomManager.getSyouhnZokusei(syuMosSyouhnParam.getSyouhncd(),
            syuMosSyouhnParam.getSyouhnsdno());
        mosnaiCheckParam.setSyuSyouhnZokusei(syuSyouhnZokusei);
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setSysKbn(C_SysKbn.SKEI);
        mosnaiCheckParam.setKokutiChkHuyoUmu(C_UmuKbn.NONE);
        mosnaiCheckParam.setSysDate(BizDate.valueOf(20160102));
        mosnaiCheckParam.setSekmossakuseiSousasyaKbn(C_SeihowebsousasyaKbn.DIRTNBSYNN);
        mosnaiCheckParam.setListHubiMsg(new ArrayList<HT_HubiMsg>());
        mosnaiCheckParam.setKosID("JUnitTest");
        mosnaiCheckParam.setKosTime("20160509141230000");
        mosnaiCheckParam.setKiteiCheckChannelCd(C_Channelcd.TIGIN);
        checkTblMosSyouhin.exec(mosnaiCheckParam);

        List<HT_HubiMsg> hubiMsgLst = mosnaiCheckParam.getListHubiMsg();

        exNumericEquals(hubiMsgLst.size(), 1, "不備メッセージテーブルエンティティリストのサイズ");

        exStringEquals(hubiMsgLst.get(0).getMosno(), "860000033", "申込番号");
        exNumericEquals(hubiMsgLst.get(0).getRenno(), 1, "連番");
        exStringEquals(hubiMsgLst.get(0).getMessageId(), "EHC0028", "メッセージＩＤ");
        exStringEquals(hubiMsgLst.get(0).getHubimsg(), "外貨建て一時払終身保険（即時保障型）　１０年毎利率再設定の契約可能期間・年齢範囲外です。", "不備メッセージ");
        exClassificationEquals(hubiMsgLst.get(0).getHubisyubetukbn(), C_HubisyubetuKbn.KETHORYU_HUBI, "不備種別区分");
        exClassificationEquals(hubiMsgLst.get(0).getHubisyubetusyousaikbn(), C_HubisyubetusyousaiKbn.NONE, "不備種別詳細区分");
        exStringEquals(hubiMsgLst.get(0).getGyoumuKousinsyaId(), "JUnitTest", "業務用更新者ＩＤ");
        exStringEquals(hubiMsgLst.get(0).getGyoumuKousinTime(), "20160509141230000", "業務用更新時間");

    }
    @Test
    @TestOrder(1040)
    @Transactional
    public void testExec_A4() {
        MockObjectManager.initialize();
        BzGetAgInfoMockForSinkeiyaku.SYORIPTN = BzGetAgInfoMockForSinkeiyaku.TESTPATTERN2;
        CheckSaiteiPMockForSinkeiyaku.SYORIPTN = CheckSaiteiPMockForSinkeiyaku.TESTPATTERN1;
        CheckTblMosSyouhin checkTblMosSyouhin = SWAKInjector.getInstance(CheckTblMosSyouhin.class);

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("860000041");
        List<HT_MosSyouhn> syuMosSyouhnParamLst = syoriCTL.getMosSyouhnsBySyutkkbn(C_SyutkKbn.SYU);
        HT_MosSyouhn syuMosSyouhnParam = syuMosSyouhnParamLst.get(0);
        BM_SyouhnZokusei syuSyouhnZokusei = bizDomManager.getSyouhnZokusei(syuMosSyouhnParam.getSyouhncd(),
            syuMosSyouhnParam.getSyouhnsdno());
        mosnaiCheckParam.setSyuSyouhnZokusei(syuSyouhnZokusei);
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setSysKbn(C_SysKbn.SKEI);
        mosnaiCheckParam.setKokutiChkHuyoUmu(C_UmuKbn.NONE);
        mosnaiCheckParam.setSysDate(BizDate.valueOf(20160102));
        mosnaiCheckParam.setSekmossakuseiSousasyaKbn(C_SeihowebsousasyaKbn.DIRTNBSYNN);
        mosnaiCheckParam.setListHubiMsg(new ArrayList<HT_HubiMsg>());
        mosnaiCheckParam.setKiteiCheckChannelCd(C_Channelcd.TIGIN);
        mosnaiCheckParam.setKosID("JUnitTest");
        mosnaiCheckParam.setKosTime("20160509141230000");

        checkTblMosSyouhin.exec(mosnaiCheckParam);

        List<HT_HubiMsg> hubiMsgLst = mosnaiCheckParam.getListHubiMsg();

        exNumericEquals(hubiMsgLst.size(), 0, "不備メッセージテーブルエンティティリストのサイズ");



    }

    @Test
    @TestOrder(1050)
    @Transactional
    public void testExec_A5() {
        MockObjectManager.initialize();
        BzGetAgInfoMockForSinkeiyaku.SYORIPTN = BzGetAgInfoMockForSinkeiyaku.TESTPATTERN3;
        CheckSaiteiPMockForSinkeiyaku.SYORIPTN = CheckSaiteiPMockForSinkeiyaku.TESTPATTERN1;
        CheckTblMosSyouhin checkTblMosSyouhin = SWAKInjector.getInstance(CheckTblMosSyouhin.class);

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("860000058");
        List<HT_MosSyouhn> syuMosSyouhnParamLst = syoriCTL.getMosSyouhnsBySyutkkbn(C_SyutkKbn.SYU);
        HT_MosSyouhn syuMosSyouhnParam = syuMosSyouhnParamLst.get(0);
        BM_SyouhnZokusei syuSyouhnZokusei = bizDomManager.getSyouhnZokusei(syuMosSyouhnParam.getSyouhncd(),
            syuMosSyouhnParam.getSyouhnsdno());
        mosnaiCheckParam.setSyuSyouhnZokusei(syuSyouhnZokusei);
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setSysKbn(C_SysKbn.ESHIEN);
        mosnaiCheckParam.setKokutiChkHuyoUmu(C_UmuKbn.NONE);
        mosnaiCheckParam.setSysDate(BizDate.valueOf(20160102));
        mosnaiCheckParam.setSekmossakuseiSousasyaKbn(C_SeihowebsousasyaKbn.DIRTNBSYNN);
        mosnaiCheckParam.setKiteiCheckChannelCd(C_Channelcd.TIGIN);

        checkTblMosSyouhin.exec(mosnaiCheckParam);

        exClassificationEquals(mosnaiCheckParam.getSekmossakuseiErroutKbn(), C_SekmossakuseiErroutKbn.GAMEN, "設計書申込書作成エラー出力区分");
        exStringEquals(mosnaiCheckParam.getSekmossakuseiErrmsg1(), "", "設計書申込書作成エラーメッセージ１");
        exStringEquals(mosnaiCheckParam.getSekmossakuseiErrmsg2(), "契約年齢範囲外です", "設計書申込書作成エラーメッセージ２");
        exClassificationEquals(mosnaiCheckParam.getKouzokuSyoriJikkouKbn(), C_KouzokujkKbn.NONE, "後続処理実行区分");

    }

    @Test(expected = CommonBizAppException.class)
    @TestOrder(1060)
    @Transactional
    public void testExec_A6() {
        MockObjectManager.initialize();
        CheckSaiteiPMockForSinkeiyaku.SYORIPTN = CheckSaiteiPMockForSinkeiyaku.TESTPATTERN1;
        ConvNenSaiMankiMockForSinkeiyaku.SYORIPTN = ConvNenSaiMankiMockForSinkeiyaku.TESTPATTERN1;
        CheckTblMosSyouhin checkTblMosSyouhin = SWAKInjector.getInstance(CheckTblMosSyouhin.class);

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("860000066");
        List<HT_MosSyouhn> syuMosSyouhnParamLst = syoriCTL.getMosSyouhnsBySyutkkbn(C_SyutkKbn.SYU);
        HT_MosSyouhn syuMosSyouhnParam = syuMosSyouhnParamLst.get(0);
        BM_SyouhnZokusei syuSyouhnZokusei = bizDomManager.getSyouhnZokusei(syuMosSyouhnParam.getSyouhncd(),
            syuMosSyouhnParam.getSyouhnsdno());
        mosnaiCheckParam.setSyuSyouhnZokusei(syuSyouhnZokusei);
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setSysKbn(C_SysKbn.ESHIEN);
        mosnaiCheckParam.setKokutiChkHuyoUmu(C_UmuKbn.NONE);
        mosnaiCheckParam.setSysDate(BizDate.valueOf(20160102));
        mosnaiCheckParam.setSekmossakuseiSousasyaKbn(C_SeihowebsousasyaKbn.SUPPORTDESK);
        mosnaiCheckParam.setKiteiCheckChannelCd(C_Channelcd.TIGIN);

        try {
            checkTblMosSyouhin.exec(mosnaiCheckParam);
        } catch (CommonBizAppException e) {

            exClassificationEquals(mosnaiCheckParam.getSekmossakuseiErroutKbn(), C_SekmossakuseiErroutKbn.GAMEN, "設計書申込書作成エラー出力区分");
            exStringEquals(mosnaiCheckParam.getSekmossakuseiErrmsg1(), "", "設計書申込書作成エラーメッセージ１");
            exStringEquals(mosnaiCheckParam.getSekmossakuseiErrmsg2(), "外貨建て一時払終身保険（毎年受取型）　１５年毎利率再設定の本人型は取扱えません。", "設計書申込書作成エラーメッセージ２");
            exClassificationEquals(mosnaiCheckParam.getKouzokuSyoriJikkouKbn(), C_KouzokujkKbn.NONE, "後続処理実行区分");

            exStringEquals(e.getMessage(), "システム整合性エラーです。最低Ｐテーブルにデータが見つかりません。", "エラーメッセージ");
            throw e;
        }
    }

    @Test
    @TestOrder(1070)
    @Transactional
    public void testExec_A7() {

        MockObjectManager.initialize();
        CheckSaiteiPMockForSinkeiyaku.SYORIPTN = CheckSaiteiPMockForSinkeiyaku.TESTPATTERN1;
        CheckTblMosSyouhin checkTblMosSyouhin = SWAKInjector.getInstance(CheckTblMosSyouhin.class);

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("860000074");
        List<HT_MosSyouhn> syuMosSyouhnParamLst = syoriCTL.getMosSyouhnsBySyutkkbn(C_SyutkKbn.SYU);
        HT_MosSyouhn syuMosSyouhnParam = syuMosSyouhnParamLst.get(0);
        BM_SyouhnZokusei syuSyouhnZokusei = bizDomManager.getSyouhnZokusei(syuMosSyouhnParam.getSyouhncd(),
            syuMosSyouhnParam.getSyouhnsdno());
        mosnaiCheckParam.setSyuSyouhnZokusei(syuSyouhnZokusei);
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setSysKbn(C_SysKbn.ESHIEN);
        mosnaiCheckParam.setKokutiChkHuyoUmu(C_UmuKbn.NONE);
        mosnaiCheckParam.setSysDate(BizDate.valueOf(20160102));
        mosnaiCheckParam.setSekmossakuseiSousasyaKbn(C_SeihowebsousasyaKbn.SUPPORTDESK);
        mosnaiCheckParam.setKiteiCheckChannelCd(C_Channelcd.TIGIN);

        checkTblMosSyouhin.exec(mosnaiCheckParam);

        exClassificationEquals(mosnaiCheckParam.getSekmossakuseiErroutKbn(), C_SekmossakuseiErroutKbn.GAMEN, "設計書申込書作成エラー出力区分");
        exStringEquals(mosnaiCheckParam.getSekmossakuseiErrmsg1(), "", "設計書申込書作成エラーメッセージ１");
        exStringEquals(mosnaiCheckParam.getSekmossakuseiErrmsg2(), "外貨建て一時払終身保険（即時保障型）　１０年毎利率再設定の集団は取扱えません。", "設計書申込書作成エラーメッセージ２");
        exClassificationEquals(mosnaiCheckParam.getKouzokuSyoriJikkouKbn(), C_KouzokujkKbn.NONE, "後続処理実行区分");
    }

    @Test
    @TestOrder(1080)
    @Transactional
    public void testExec_A8() {
        MockObjectManager.initialize();
        CheckSaiteiPMockForSinkeiyaku.SYORIPTN = CheckSaiteiPMockForSinkeiyaku.TESTPATTERN1;
        CheckTblMosSyouhin checkTblMosSyouhin = SWAKInjector.getInstance(CheckTblMosSyouhin.class);

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("860000082");
        List<HT_MosSyouhn> syuMosSyouhnParamLst = syoriCTL.getMosSyouhnsBySyutkkbn(C_SyutkKbn.SYU);
        HT_MosSyouhn syuMosSyouhnParam = syuMosSyouhnParamLst.get(0);
        BM_SyouhnZokusei syuSyouhnZokusei = bizDomManager.getSyouhnZokusei(syuMosSyouhnParam.getSyouhncd(),
            syuMosSyouhnParam.getSyouhnsdno());
        mosnaiCheckParam.setSyuSyouhnZokusei(syuSyouhnZokusei);
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setSysKbn(C_SysKbn.SKEI);
        mosnaiCheckParam.setKokutiChkHuyoUmu(C_UmuKbn.NONE);
        mosnaiCheckParam.setSysDate(BizDate.valueOf(20160102));
        mosnaiCheckParam.setSekmossakuseiSousasyaKbn(C_SeihowebsousasyaKbn.SUPPORTDESK);
        mosnaiCheckParam.setListHubiMsg(new ArrayList<HT_HubiMsg>());
        mosnaiCheckParam.setKosID("JUnitTest");
        mosnaiCheckParam.setKosTime("20160509141230000");
        mosnaiCheckParam.setKiteiCheckChannelCd(C_Channelcd.TIGIN);

        checkTblMosSyouhin.exec(mosnaiCheckParam);

        List<HT_HubiMsg> hubiMsgLst = mosnaiCheckParam.getListHubiMsg();

        exNumericEquals(hubiMsgLst.size(), 1, "不備メッセージテーブルエンティティリストのサイズ");

        exStringEquals(hubiMsgLst.get(0).getMosno(), "860000082", "申込番号");
        exNumericEquals(hubiMsgLst.get(0).getRenno(), 1, "連番");
        exStringEquals(hubiMsgLst.get(0).getMessageId(), "THC0028", "メッセージＩＤ");
        exStringEquals(hubiMsgLst.get(0).getHubimsg(), "【特認可能】外貨建て一時払終身保険（即時保障型）　１０年毎利率再設定の契約可能期間・年齢範囲外です。", "不備メッセージ");
        exClassificationEquals(hubiMsgLst.get(0).getHubisyubetukbn(), C_HubisyubetuKbn.KETHORYU_HUBI, "不備種別区分");
        exStringEquals(hubiMsgLst.get(0).getGyoumuKousinsyaId(), "JUnitTest", "業務用更新者ＩＤ");
        exStringEquals(hubiMsgLst.get(0).getGyoumuKousinTime(), "20160509141230000", "業務用更新時間");
    }
    @Test
    @TestOrder(1090)
    @Transactional
    public void testExec_A9() {
        MockObjectManager.initialize();
        CheckSaiteiPMockForSinkeiyaku.SYORIPTN = CheckSaiteiPMockForSinkeiyaku.TESTPATTERN1;
        CheckTblMosSyouhin checkTblMosSyouhin = SWAKInjector.getInstance(CheckTblMosSyouhin.class);

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("860000090");
        List<HT_MosSyouhn> syuMosSyouhnParamLst = syoriCTL.getMosSyouhnsBySyutkkbn(C_SyutkKbn.SYU);
        HT_MosSyouhn syuMosSyouhnParam = syuMosSyouhnParamLst.get(0);
        BM_SyouhnZokusei syuSyouhnZokusei = bizDomManager.getSyouhnZokusei(syuMosSyouhnParam.getSyouhncd(),
            syuMosSyouhnParam.getSyouhnsdno());
        mosnaiCheckParam.setSyuSyouhnZokusei(syuSyouhnZokusei);
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setSysKbn(C_SysKbn.SKEI);
        mosnaiCheckParam.setKokutiChkHuyoUmu(C_UmuKbn.NONE);
        mosnaiCheckParam.setSysDate(BizDate.valueOf(20160102));
        mosnaiCheckParam.setSekmossakuseiSousasyaKbn(C_SeihowebsousasyaKbn.SUPPORTDESK);
        mosnaiCheckParam.setListHubiMsg(new ArrayList<HT_HubiMsg>());
        mosnaiCheckParam.setKiteiCheckChannelCd(C_Channelcd.TIGIN);

        checkTblMosSyouhin.exec(mosnaiCheckParam);

        List<HT_HubiMsg> hubiMsgLst = mosnaiCheckParam.getListHubiMsg();

        exNumericEquals(hubiMsgLst.size(), 0, "不備メッセージテーブルエンティティリストのサイズ");

    }
    @Test
    @TestOrder(1100)
    @Transactional
    public void testExec_A10() {
        MockObjectManager.initialize();
        CheckSaiteiPMockForSinkeiyaku.SYORIPTN = CheckSaiteiPMockForSinkeiyaku.TESTPATTERN1;
        CheckTblMosSyouhin checkTblMosSyouhin = SWAKInjector.getInstance(CheckTblMosSyouhin.class);

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("860000108");
        List<HT_MosSyouhn> syuMosSyouhnParamLst = syoriCTL.getMosSyouhnsBySyutkkbn(C_SyutkKbn.SYU);
        HT_MosSyouhn syuMosSyouhnParam = syuMosSyouhnParamLst.get(0);
        BM_SyouhnZokusei syuSyouhnZokusei = bizDomManager.getSyouhnZokusei(syuMosSyouhnParam.getSyouhncd(),
            syuMosSyouhnParam.getSyouhnsdno());
        mosnaiCheckParam.setSyuSyouhnZokusei(syuSyouhnZokusei);
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setSysKbn(C_SysKbn.SKEI);
        mosnaiCheckParam.setKokutiChkHuyoUmu(C_UmuKbn.NONE);
        mosnaiCheckParam.setSysDate(BizDate.valueOf(20160102));
        mosnaiCheckParam.setSekmossakuseiSousasyaKbn(C_SeihowebsousasyaKbn.SUPPORTDESK);
        mosnaiCheckParam.setListHubiMsg(new ArrayList<HT_HubiMsg>());
        mosnaiCheckParam.setKosID("JUnitTest");
        mosnaiCheckParam.setKosTime("20160509141230000");
        mosnaiCheckParam.setKiteiCheckChannelCd(C_Channelcd.TIGIN);

        checkTblMosSyouhin.exec(mosnaiCheckParam);

        List<HT_HubiMsg> hubiMsgLst = mosnaiCheckParam.getListHubiMsg();

        exNumericEquals(hubiMsgLst.size(), 1, "不備メッセージテーブルエンティティリストのサイズ");

        exStringEquals(hubiMsgLst.get(0).getMosno(), "860000108", "申込番号");
        exNumericEquals(hubiMsgLst.get(0).getRenno(), 1, "連番");
        exStringEquals(hubiMsgLst.get(0).getMessageId(), "THC0019", "メッセージＩＤ");
        exStringEquals(hubiMsgLst.get(0).getHubimsg(), "【特認可能】外貨建て一時払終身保険（即時保障型）　１０年毎利率再設定の集団は取扱えません。", "不備メッセージ");
        exClassificationEquals(hubiMsgLst.get(0).getHubisyubetukbn(), C_HubisyubetuKbn.KETHORYU_HUBI, "不備種別区分");
        exStringEquals(hubiMsgLst.get(0).getGyoumuKousinsyaId(), "JUnitTest", "業務用更新者ＩＤ");
        exStringEquals(hubiMsgLst.get(0).getGyoumuKousinTime(), "20160509141230000", "業務用更新時間");
    }
    @Test
    @TestOrder(1110)
    @Transactional
    public void testExec_A11() {
        MockObjectManager.initialize();
        CheckSaiteiPMockForSinkeiyaku.SYORIPTN = CheckSaiteiPMockForSinkeiyaku.TESTPATTERN1;
        CheckTblMosSyouhin checkTblMosSyouhin = SWAKInjector.getInstance(CheckTblMosSyouhin.class);

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("860000116");
        List<HT_MosSyouhn> syuMosSyouhnParamLst = syoriCTL.getMosSyouhnsBySyutkkbn(C_SyutkKbn.SYU);
        HT_MosSyouhn syuMosSyouhnParam = syuMosSyouhnParamLst.get(0);
        BM_SyouhnZokusei syuSyouhnZokusei = bizDomManager.getSyouhnZokusei(syuMosSyouhnParam.getSyouhncd(),
            syuMosSyouhnParam.getSyouhnsdno());
        mosnaiCheckParam.setSyuSyouhnZokusei(syuSyouhnZokusei);
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setSysKbn(C_SysKbn.SKEI);
        mosnaiCheckParam.setKokutiChkHuyoUmu(C_UmuKbn.NONE);
        mosnaiCheckParam.setSysDate(BizDate.valueOf(20160102));
        mosnaiCheckParam.setSekmossakuseiSousasyaKbn(C_SeihowebsousasyaKbn.SUPPORTDESK);
        mosnaiCheckParam.setListHubiMsg(new ArrayList<HT_HubiMsg>());
        mosnaiCheckParam.setKosID("JUnitTest");
        mosnaiCheckParam.setKosTime("20160509141230000");
        mosnaiCheckParam.setKiteiCheckChannelCd(C_Channelcd.TIGIN);

        checkTblMosSyouhin.exec(mosnaiCheckParam);

        List<HT_HubiMsg> hubiMsgLst = mosnaiCheckParam.getListHubiMsg();

        exNumericEquals(hubiMsgLst.size(), 1, "不備メッセージテーブルエンティティリストのサイズ");

        exStringEquals(hubiMsgLst.get(0).getMosno(), "860000116", "申込番号");
        exNumericEquals(hubiMsgLst.get(0).getRenno(), 1, "連番");
        exStringEquals(hubiMsgLst.get(0).getMessageId(), "THC0019", "メッセージＩＤ");
        exStringEquals(hubiMsgLst.get(0).getHubimsg(), "【特認可能】外貨建て一時払終身保険（即時保障型）　１０年毎利率再設定の団体は取扱えません。", "不備メッセージ");
        exClassificationEquals(hubiMsgLst.get(0).getHubisyubetukbn(), C_HubisyubetuKbn.KETHORYU_HUBI, "不備種別区分");
        exStringEquals(hubiMsgLst.get(0).getGyoumuKousinsyaId(), "JUnitTest", "業務用更新者ＩＤ");
        exStringEquals(hubiMsgLst.get(0).getGyoumuKousinTime(), "20160509141230000", "業務用更新時間");
    }

    @Test
    @TestOrder(1120)
    @Transactional
    public void testExec_A12() {
        MockObjectManager.initialize();
        CheckSaiteiPMockForSinkeiyaku.SYORIPTN = CheckSaiteiPMockForSinkeiyaku.TESTPATTERN1;
        CheckTblMosSyouhin checkTblMosSyouhin = SWAKInjector.getInstance(CheckTblMosSyouhin.class);

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("860000124");
        List<HT_MosSyouhn> syuMosSyouhnParamLst = syoriCTL.getMosSyouhnsBySyutkkbn(C_SyutkKbn.SYU);
        HT_MosSyouhn syuMosSyouhnParam = syuMosSyouhnParamLst.get(0);
        BM_SyouhnZokusei syuSyouhnZokusei = bizDomManager.getSyouhnZokusei(syuMosSyouhnParam.getSyouhncd(),
            syuMosSyouhnParam.getSyouhnsdno());
        mosnaiCheckParam.setSyuSyouhnZokusei(syuSyouhnZokusei);
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setSysKbn(C_SysKbn.SKEI);
        mosnaiCheckParam.setKokutiChkHuyoUmu(C_UmuKbn.NONE);
        mosnaiCheckParam.setSysDate(BizDate.valueOf(20160102));
        mosnaiCheckParam.setSekmossakuseiSousasyaKbn(C_SeihowebsousasyaKbn.SUPPORTDESK);
        mosnaiCheckParam.setListHubiMsg(new ArrayList<HT_HubiMsg>());
        mosnaiCheckParam.setKosID("JUnitTest");
        mosnaiCheckParam.setKosTime("20160509141230000");
        mosnaiCheckParam.setKiteiCheckChannelCd(C_Channelcd.TIGIN);

        checkTblMosSyouhin.exec(mosnaiCheckParam);

        List<HT_HubiMsg> hubiMsgLst = mosnaiCheckParam.getListHubiMsg();

        exNumericEquals(hubiMsgLst.size(), 1, "不備メッセージテーブルエンティティリストのサイズ");

        exStringEquals(hubiMsgLst.get(0).getMosno(), "860000124", "申込番号");
        exNumericEquals(hubiMsgLst.get(0).getRenno(), 1, "連番");
        exStringEquals(hubiMsgLst.get(0).getMessageId(), "THC0028", "メッセージＩＤ");
        exStringEquals(hubiMsgLst.get(0).getHubimsg(), "【特認可能】外貨建て一時払終身保険（即時保障型）　１０年毎利率再設定の契約可能期間・年齢範囲外です。", "不備メッセージ");
        exClassificationEquals(hubiMsgLst.get(0).getHubisyubetukbn(), C_HubisyubetuKbn.KETHORYU_HUBI, "不備種別区分");
        exStringEquals(hubiMsgLst.get(0).getGyoumuKousinsyaId(), "JUnitTest", "業務用更新者ＩＤ");
        exStringEquals(hubiMsgLst.get(0).getGyoumuKousinTime(), "20160509141230000", "業務用更新時間");
    }

    @Test
    @TestOrder(1130)
    @Transactional
    public void testExec_A13() {
        MockObjectManager.initialize();
        CheckSaiteiPMockForSinkeiyaku.SYORIPTN = CheckSaiteiPMockForSinkeiyaku.TESTPATTERN1;
        GetKiteiCheckYenkansangkMockForSinkeiyaku.SYORIPTN = GetKiteiCheckYenkansangkMockForSinkeiyaku.TESTPATTERN1;
        CheckTblMosSyouhin checkTblMosSyouhin = SWAKInjector.getInstance(CheckTblMosSyouhin.class);

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("860000132");
        List<HT_MosSyouhn> syuMosSyouhnParamLst = syoriCTL.getMosSyouhnsBySyutkkbn(C_SyutkKbn.SYU);
        HT_MosSyouhn syuMosSyouhnParam = syuMosSyouhnParamLst.get(0);
        BM_SyouhnZokusei syuSyouhnZokusei = bizDomManager.getSyouhnZokusei(syuMosSyouhnParam.getSyouhncd(),
            syuMosSyouhnParam.getSyouhnsdno());
        mosnaiCheckParam.setSyuSyouhnZokusei(syuSyouhnZokusei);
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setSysKbn(C_SysKbn.SKEI);
        mosnaiCheckParam.setKokutiChkHuyoUmu(C_UmuKbn.NONE);
        mosnaiCheckParam.setSysDate(BizDate.valueOf(20160102));
        mosnaiCheckParam.setSekmossakuseiSousasyaKbn(C_SeihowebsousasyaKbn.SUPPORTDESK);
        mosnaiCheckParam.setListHubiMsg(new ArrayList<HT_HubiMsg>());
        mosnaiCheckParam.setKosID("JUnitTest");
        mosnaiCheckParam.setKosTime("20160509141230000");
        mosnaiCheckParam.setKiteiCheckChannelCd(C_Channelcd.TIGIN);

        checkTblMosSyouhin.exec(mosnaiCheckParam);

        List<HT_HubiMsg> hubiMsgLst = mosnaiCheckParam.getListHubiMsg();

        exNumericEquals(hubiMsgLst.size(), 1, "不備メッセージテーブルエンティティリストのサイズ");

        exStringEquals(hubiMsgLst.get(0).getMosno(), "860000132", "申込番号");
        exNumericEquals(hubiMsgLst.get(0).getRenno(), 1, "連番");
        exStringEquals(hubiMsgLst.get(0).getMessageId(), "THC0030", "メッセージＩＤ");
        exStringEquals(hubiMsgLst.get(0).getHubimsg(), "【特認可能】外貨建て一時払終身保険（即時保障型）　１０年毎利率再設定は年払いしか取扱いません。", "不備メッセージ");
        exClassificationEquals(hubiMsgLst.get(0).getHubisyubetukbn(), C_HubisyubetuKbn.KETHORYU_HUBI, "不備種別区分");
        exStringEquals(hubiMsgLst.get(0).getGyoumuKousinsyaId(), "JUnitTest", "業務用更新者ＩＤ");
        exStringEquals(hubiMsgLst.get(0).getGyoumuKousinTime(), "20160509141230000", "業務用更新時間");
    }
    @Test
    @TestOrder(1140)
    @Transactional
    public void testExec_A14() {
        MockObjectManager.initialize();
        CheckSaiteiPMockForSinkeiyaku.SYORIPTN = CheckSaiteiPMockForSinkeiyaku.TESTPATTERN1;
        GetKiteiCheckYenkansangkMockForSinkeiyaku.SYORIPTN = GetKiteiCheckYenkansangkMockForSinkeiyaku.TESTPATTERN1;
        CheckTblMosSyouhin checkTblMosSyouhin = SWAKInjector.getInstance(CheckTblMosSyouhin.class);

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("860000140");
        List<HT_MosSyouhn> syuMosSyouhnParamLst = syoriCTL.getMosSyouhnsBySyutkkbn(C_SyutkKbn.SYU);
        HT_MosSyouhn syuMosSyouhnParam = syuMosSyouhnParamLst.get(0);
        BM_SyouhnZokusei syuSyouhnZokusei = bizDomManager.getSyouhnZokusei(syuMosSyouhnParam.getSyouhncd(),
            syuMosSyouhnParam.getSyouhnsdno());
        mosnaiCheckParam.setSyuSyouhnZokusei(syuSyouhnZokusei);
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setSysKbn(C_SysKbn.SKEI);
        mosnaiCheckParam.setKokutiChkHuyoUmu(C_UmuKbn.NONE);
        mosnaiCheckParam.setSysDate(BizDate.valueOf(20160102));
        mosnaiCheckParam.setSekmossakuseiSousasyaKbn(C_SeihowebsousasyaKbn.SUPPORTDESK);
        mosnaiCheckParam.setListHubiMsg(new ArrayList<HT_HubiMsg>());
        mosnaiCheckParam.setKiteiCheckChannelCd(C_Channelcd.TIGIN);

        checkTblMosSyouhin.exec(mosnaiCheckParam);

        List<HT_HubiMsg> hubiMsgLst = mosnaiCheckParam.getListHubiMsg();

        exNumericEquals(hubiMsgLst.size(), 0, "不備メッセージテーブルエンティティリストのサイズ");

    }

    @Test
    @TestOrder(1150)
    @Transactional
    public void testExec_A15() {
        MockObjectManager.initialize();
        CheckSaiteiPMockForSinkeiyaku.SYORIPTN = CheckSaiteiPMockForSinkeiyaku.TESTPATTERN1;
        CheckTblMosSyouhin checkTblMosSyouhin = SWAKInjector.getInstance(CheckTblMosSyouhin.class);

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("860000157");
        List<HT_MosSyouhn> syuMosSyouhnParamLst = syoriCTL.getMosSyouhnsBySyutkkbn(C_SyutkKbn.SYU);
        HT_MosSyouhn syuMosSyouhnParam = syuMosSyouhnParamLst.get(0);
        BM_SyouhnZokusei syuSyouhnZokusei = bizDomManager.getSyouhnZokusei(syuMosSyouhnParam.getSyouhncd(),
            syuMosSyouhnParam.getSyouhnsdno());
        mosnaiCheckParam.setSyuSyouhnZokusei(syuSyouhnZokusei);
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setSysKbn(C_SysKbn.SKEI);
        mosnaiCheckParam.setKokutiChkHuyoUmu(C_UmuKbn.NONE);
        mosnaiCheckParam.setSysDate(BizDate.valueOf(20160102));
        mosnaiCheckParam.setSekmossakuseiSousasyaKbn(C_SeihowebsousasyaKbn.SUPPORTDESK);
        mosnaiCheckParam.setListHubiMsg(new ArrayList<HT_HubiMsg>());
        mosnaiCheckParam.setKosID("JUnitTest");
        mosnaiCheckParam.setKosTime("20160509141230000");
        mosnaiCheckParam.setKiteiCheckChannelCd(C_Channelcd.TIGIN);

        checkTblMosSyouhin.exec(mosnaiCheckParam);

        List<HT_HubiMsg> hubiMsgLst = mosnaiCheckParam.getListHubiMsg();

        exNumericEquals(hubiMsgLst.size(), 1, "不備メッセージテーブルエンティティリストのサイズ");

        exStringEquals(hubiMsgLst.get(0).getMosno(), "860000157", "申込番号");
        exNumericEquals(hubiMsgLst.get(0).getRenno(), 1, "連番");
        exStringEquals(hubiMsgLst.get(0).getMessageId(), "THC0028", "メッセージＩＤ");
        exStringEquals(hubiMsgLst.get(0).getHubimsg(), "【特認可能】外貨建て一時払終身保険（即時保障型）　１０年毎利率再設定の契約可能期間・年齢範囲外です。", "不備メッセージ");
        exClassificationEquals(hubiMsgLst.get(0).getHubisyubetukbn(), C_HubisyubetuKbn.KETHORYU_HUBI, "不備種別区分");
        exStringEquals(hubiMsgLst.get(0).getGyoumuKousinsyaId(), "JUnitTest", "業務用更新者ＩＤ");
        exStringEquals(hubiMsgLst.get(0).getGyoumuKousinTime(), "20160509141230000", "業務用更新時間");
    }

    @Test
    @TestOrder(1160)
    @Transactional
    public void testExec_A16() {
        MockObjectManager.initialize();
        CheckSaiteiPMockForSinkeiyaku.SYORIPTN = CheckSaiteiPMockForSinkeiyaku.TESTPATTERN1;
        CheckTblMosSyouhin checkTblMosSyouhin = SWAKInjector.getInstance(CheckTblMosSyouhin.class);

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("860000165");
        List<HT_MosSyouhn> syuMosSyouhnParamLst = syoriCTL.getMosSyouhnsBySyutkkbn(C_SyutkKbn.SYU);
        HT_MosSyouhn syuMosSyouhnParam = syuMosSyouhnParamLst.get(0);
        BM_SyouhnZokusei syuSyouhnZokusei = bizDomManager.getSyouhnZokusei(syuMosSyouhnParam.getSyouhncd(),
            syuMosSyouhnParam.getSyouhnsdno());
        mosnaiCheckParam.setSyuSyouhnZokusei(syuSyouhnZokusei);
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setSysKbn(C_SysKbn.SKEI);
        mosnaiCheckParam.setKokutiChkHuyoUmu(C_UmuKbn.NONE);
        mosnaiCheckParam.setSysDate(BizDate.valueOf(20160102));
        mosnaiCheckParam.setSekmossakuseiSousasyaKbn(C_SeihowebsousasyaKbn.SUPPORTDESK);
        mosnaiCheckParam.setListHubiMsg(new ArrayList<HT_HubiMsg>());
        mosnaiCheckParam.setKosID("JUnitTest");
        mosnaiCheckParam.setKosTime("20160509141230000");
        mosnaiCheckParam.setKiteiCheckChannelCd(C_Channelcd.TIGIN);

        checkTblMosSyouhin.exec(mosnaiCheckParam);

        List<HT_HubiMsg> hubiMsgLst = mosnaiCheckParam.getListHubiMsg();

        exNumericEquals(hubiMsgLst.size(), 1, "不備メッセージテーブルエンティティリストのサイズ");

        exStringEquals(hubiMsgLst.get(0).getMosno(), "860000165", "申込番号");
        exNumericEquals(hubiMsgLst.get(0).getRenno(), 1, "連番");
        exStringEquals(hubiMsgLst.get(0).getMessageId(), "THC0028", "メッセージＩＤ");
        exStringEquals(hubiMsgLst.get(0).getHubimsg(), "【特認可能】外貨建て一時払終身保険（即時保障型）　１０年毎利率再設定の契約可能期間・年齢範囲外です。", "不備メッセージ");
        exClassificationEquals(hubiMsgLst.get(0).getHubisyubetukbn(), C_HubisyubetuKbn.KETHORYU_HUBI, "不備種別区分");
        exStringEquals(hubiMsgLst.get(0).getGyoumuKousinsyaId(), "JUnitTest", "業務用更新者ＩＤ");
        exStringEquals(hubiMsgLst.get(0).getGyoumuKousinTime(), "20160509141230000", "業務用更新時間");
    }

    @Test
    @TestOrder(1170)
    @Transactional
    public void testExec_A17() {
        MockObjectManager.initialize();
        CheckSaiteiPMockForSinkeiyaku.SYORIPTN = CheckSaiteiPMockForSinkeiyaku.TESTPATTERN1;
        GetKiteiCheckYenkansangkMockForSinkeiyaku.SYORIPTN = GetKiteiCheckYenkansangkMockForSinkeiyaku.TESTPATTERN1;
        CheckTblMosSyouhin checkTblMosSyouhin = SWAKInjector.getInstance(CheckTblMosSyouhin.class);

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("860000173");
        List<HT_MosSyouhn> syuMosSyouhnParamLst = syoriCTL.getMosSyouhnsBySyutkkbn(C_SyutkKbn.SYU);
        HT_MosSyouhn syuMosSyouhnParam = syuMosSyouhnParamLst.get(0);
        BM_SyouhnZokusei syuSyouhnZokusei = bizDomManager.getSyouhnZokusei(syuMosSyouhnParam.getSyouhncd(),
            syuMosSyouhnParam.getSyouhnsdno());
        mosnaiCheckParam.setSyuSyouhnZokusei(syuSyouhnZokusei);
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setSysKbn(C_SysKbn.SKEI);
        mosnaiCheckParam.setKokutiChkHuyoUmu(C_UmuKbn.NONE);
        mosnaiCheckParam.setSysDate(BizDate.valueOf(20160102));
        mosnaiCheckParam.setSekmossakuseiSousasyaKbn(C_SeihowebsousasyaKbn.SUPPORTDESK);
        mosnaiCheckParam.setListHubiMsg(new ArrayList<HT_HubiMsg>());
        mosnaiCheckParam.setKosID("JUnitTest");
        mosnaiCheckParam.setKosTime("20160509141230000");
        mosnaiCheckParam.setKiteiCheckChannelCd(C_Channelcd.TIGIN);

        checkTblMosSyouhin.exec(mosnaiCheckParam);

        List<HT_HubiMsg> hubiMsgLst = mosnaiCheckParam.getListHubiMsg();

        exNumericEquals(hubiMsgLst.size(), 1, "不備メッセージテーブルエンティティリストのサイズ");

        exStringEquals(hubiMsgLst.get(0).getMosno(), "860000173", "申込番号");
        exNumericEquals(hubiMsgLst.get(0).getRenno(), 1, "連番");
        exStringEquals(hubiMsgLst.get(0).getMessageId(), "THC0028", "メッセージＩＤ");
        exStringEquals(hubiMsgLst.get(0).getHubimsg(), "【特認可能】外貨建て一時払終身保険（即時保障型）　１０年毎利率再設定の契約可能期間・年齢範囲外です。", "不備メッセージ");
        exClassificationEquals(hubiMsgLst.get(0).getHubisyubetukbn(), C_HubisyubetuKbn.KETHORYU_HUBI, "不備種別区分");
        exStringEquals(hubiMsgLst.get(0).getGyoumuKousinsyaId(), "JUnitTest", "業務用更新者ＩＤ");
        exStringEquals(hubiMsgLst.get(0).getGyoumuKousinTime(), "20160509141230000", "業務用更新時間");
    }
    @Test
    @TestOrder(1180)
    @Transactional
    public void testExec_A18() {
        MockObjectManager.initialize();
        CheckSaiteiPMockForSinkeiyaku.SYORIPTN = CheckSaiteiPMockForSinkeiyaku.TESTPATTERN1;
        GetKiteiCheckYenkansangkMockForSinkeiyaku.SYORIPTN = GetKiteiCheckYenkansangkMockForSinkeiyaku.TESTPATTERN1;
        CheckTblMosSyouhin checkTblMosSyouhin = SWAKInjector.getInstance(CheckTblMosSyouhin.class);

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("860000181");
        List<HT_MosSyouhn> syuMosSyouhnParamLst = syoriCTL.getMosSyouhnsBySyutkkbn(C_SyutkKbn.SYU);
        HT_MosSyouhn syuMosSyouhnParam = syuMosSyouhnParamLst.get(0);
        BM_SyouhnZokusei syuSyouhnZokusei = bizDomManager.getSyouhnZokusei(syuMosSyouhnParam.getSyouhncd(),
            syuMosSyouhnParam.getSyouhnsdno());
        mosnaiCheckParam.setSyuSyouhnZokusei(syuSyouhnZokusei);
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setSysKbn(C_SysKbn.SKEI);
        mosnaiCheckParam.setKokutiChkHuyoUmu(C_UmuKbn.NONE);
        mosnaiCheckParam.setSysDate(BizDate.valueOf(20160102));
        mosnaiCheckParam.setSekmossakuseiSousasyaKbn(C_SeihowebsousasyaKbn.SUPPORTDESK);
        mosnaiCheckParam.setListHubiMsg(new ArrayList<HT_HubiMsg>());
        mosnaiCheckParam.setKiteiCheckChannelCd(C_Channelcd.TIGIN);

        checkTblMosSyouhin.exec(mosnaiCheckParam);

        List<HT_HubiMsg> hubiMsgLst = mosnaiCheckParam.getListHubiMsg();

        exNumericEquals(hubiMsgLst.size(), 1, "不備メッセージテーブルエンティティリストのサイズ");

    }
    @Test
    @TestOrder(1190)
    @Transactional
    public void testExec_A19() {
        MockObjectManager.initialize();
        CheckSaiteiPMockForSinkeiyaku.SYORIPTN = CheckSaiteiPMockForSinkeiyaku.TESTPATTERN1;
        GetKiteiCheckYenkansangkMockForSinkeiyaku.SYORIPTN = GetKiteiCheckYenkansangkMockForSinkeiyaku.TESTPATTERN1;
        CheckTblMosSyouhin checkTblMosSyouhin = SWAKInjector.getInstance(CheckTblMosSyouhin.class);

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("860000199");
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
        mosnaiCheckParam.setSekmossakuseiSousasyaKbn(C_SeihowebsousasyaKbn.SUPPORTDESK);
        mosnaiCheckParam.setListHubiMsg(new ArrayList<HT_HubiMsg>());
        mosnaiCheckParam.setKosID("JUnitTest");
        mosnaiCheckParam.setKosTime("20160509141230000");
        mosnaiCheckParam.setKiteiCheckChannelCd(C_Channelcd.TIGIN);

        checkTblMosSyouhin.exec(mosnaiCheckParam);

        List<HT_HubiMsg> hubiMsgLst = mosnaiCheckParam.getListHubiMsg();

        exNumericEquals(hubiMsgLst.size(), 2, "不備メッセージテーブルエンティティリストのサイズ");

        exStringEquals(hubiMsgLst.get(0).getMosno(), "860000199", "申込番号");
        exNumericEquals(hubiMsgLst.get(0).getRenno(), 1, "連番");
        exStringEquals(hubiMsgLst.get(0).getMessageId(), "THC0028", "メッセージＩＤ");
        exStringEquals(hubiMsgLst.get(0).getHubimsg(), "【特認可能】外貨建て一時払終身保険（即時保障型）　１０年毎利率再設定の契約可能期間・年齢範囲外です。", "不備メッセージ");
        exClassificationEquals(hubiMsgLst.get(0).getHubisyubetukbn(), C_HubisyubetuKbn.KETHORYU_HUBI, "不備種別区分");
        exStringEquals(hubiMsgLst.get(0).getGyoumuKousinsyaId(), "JUnitTest", "業務用更新者ＩＤ");
        exStringEquals(hubiMsgLst.get(0).getGyoumuKousinTime(), "20160509141230000", "業務用更新時間");
    }
    @Test
    @TestOrder(1200)
    @Transactional
    public void testExec_A20() {
        MockObjectManager.initialize();
        CheckSaiteiPMockForSinkeiyaku.SYORIPTN = CheckSaiteiPMockForSinkeiyaku.TESTPATTERN1;
        GetKiteiCheckYenkansangkMockForSinkeiyaku.SYORIPTN = GetKiteiCheckYenkansangkMockForSinkeiyaku.TESTPATTERN1;
        CheckTblMosSyouhin checkTblMosSyouhin = SWAKInjector.getInstance(CheckTblMosSyouhin.class);

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("860000207");
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
        mosnaiCheckParam.setSekmossakuseiSousasyaKbn(C_SeihowebsousasyaKbn.SUPPORTDESK);
        mosnaiCheckParam.setListHubiMsg(new ArrayList<HT_HubiMsg>());
        mosnaiCheckParam.setKiteiCheckChannelCd(C_Channelcd.TIGIN);

        checkTblMosSyouhin.exec(mosnaiCheckParam);

        List<HT_HubiMsg> hubiMsgLst = mosnaiCheckParam.getListHubiMsg();

        exNumericEquals(hubiMsgLst.size(), 2, "不備メッセージテーブルエンティティリストのサイズ");
    }
    @Test
    @TestOrder(1210)
    @Transactional
    public void testExec_A21() {
        MockObjectManager.initialize();
        CheckSaiteiPMockForSinkeiyaku.SYORIPTN = CheckSaiteiPMockForSinkeiyaku.TESTPATTERN1;
        GetKiteiCheckYenkansangkMockForSinkeiyaku.SYORIPTN = GetKiteiCheckYenkansangkMockForSinkeiyaku.TESTPATTERN1;
        CheckTblMosSyouhin checkTblMosSyouhin = SWAKInjector.getInstance(CheckTblMosSyouhin.class);

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("860000215");
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
        mosnaiCheckParam.setSekmossakuseiSousasyaKbn(C_SeihowebsousasyaKbn.SUPPORTDESK);
        mosnaiCheckParam.setListHubiMsg(new ArrayList<HT_HubiMsg>());
        mosnaiCheckParam.setKiteiCheckChannelCd(C_Channelcd.TIGIN);

        checkTblMosSyouhin.exec(mosnaiCheckParam);

        List<HT_HubiMsg> hubiMsgLst = mosnaiCheckParam.getListHubiMsg();

        exNumericEquals(hubiMsgLst.size(), 2, "不備メッセージテーブルエンティティリストのサイズ");
    }

    @Test(expected = CommonBizAppException.class)
    @TestOrder(1220)
    @Transactional
    public void testExec_A22() {
        MockObjectManager.initialize();
        CheckTblMosSyouhin checkTblMosSyouhin = SWAKInjector.getInstance(CheckTblMosSyouhin.class);

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("860000223");
        List<HT_MosSyouhn> syuMosSyouhnParamLst = syoriCTL.getMosSyouhnsBySyutkkbn(C_SyutkKbn.SYU);
        HT_MosSyouhn syuMosSyouhnParam = syuMosSyouhnParamLst.get(0);
        BM_SyouhnZokusei syuSyouhnZokusei = bizDomManager.getSyouhnZokusei(syuMosSyouhnParam.getSyouhncd(),
            syuMosSyouhnParam.getSyouhnsdno());
        mosnaiCheckParam.setSyuSyouhnZokusei(syuSyouhnZokusei);
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setSysKbn(C_SysKbn.SKEI);
        mosnaiCheckParam.setKokutiChkHuyoUmu(C_UmuKbn.NONE);
        mosnaiCheckParam.setSysDate(BizDate.valueOf(20160102));
        mosnaiCheckParam.setSekmossakuseiSousasyaKbn(C_SeihowebsousasyaKbn.SUPPORTDESK);
        mosnaiCheckParam.setKiteiCheckChannelCd(C_Channelcd.TIGIN);

        try {
            checkTblMosSyouhin.exec(mosnaiCheckParam);
        } catch (CommonBizAppException e) {
            exStringEquals(e.getMessage(), "システム整合性エラーです。", "エラーメッセージ");
            throw e;
        }
    }

    @Test
    @TestOrder(1230)
    @Transactional
    public void testExec_A23() {
        MockObjectManager.initialize();
        CheckSaiteiPMockForSinkeiyaku.SYORIPTN = CheckSaiteiPMockForSinkeiyaku.TESTPATTERN1;
        GetKiteiCheckYenkansangkMockForSinkeiyaku.SYORIPTN = GetKiteiCheckYenkansangkMockForSinkeiyaku.TESTPATTERN1;
        CheckTblMosSyouhin checkTblMosSyouhin = SWAKInjector.getInstance(CheckTblMosSyouhin.class);

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("980000012");
        List<HT_MosSyouhn> syuMosSyouhnParamLst = syoriCTL.getMosSyouhnsBySyutkkbn(C_SyutkKbn.SYU);
        HT_MosSyouhn syuMosSyouhnParam = syuMosSyouhnParamLst.get(0);
        BM_SyouhnZokusei syuSyouhnZokusei = bizDomManager.getSyouhnZokusei(syuMosSyouhnParam.getSyouhncd(),
            syuMosSyouhnParam.getSyouhnsdno());
        mosnaiCheckParam.setSyuSyouhnZokusei(syuSyouhnZokusei);
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setSysKbn(C_SysKbn.ESHIEN);
        mosnaiCheckParam.setKokutiChkHuyoUmu(C_UmuKbn.NONE);
        mosnaiCheckParam.setSysDate(BizDate.valueOf(20160102));
        mosnaiCheckParam.setSekmossakuseiSousasyaKbn(C_SeihowebsousasyaKbn.SUPPORTDESK);
        mosnaiCheckParam.setKiteiCheckChannelCd(C_Channelcd.TIGIN);

        checkTblMosSyouhin.exec(mosnaiCheckParam);

        exClassificationEquals(mosnaiCheckParam.getSekmossakuseiErroutKbn(), C_SekmossakuseiErroutKbn.GAMEN, "設計書申込書作成エラー出力区分");
        exStringEquals(mosnaiCheckParam.getSekmossakuseiErrmsg1(), "", "設計書申込書作成エラーメッセージ１");
        exStringEquals(mosnaiCheckParam.getSekmossakuseiErrmsg2(), "募集年齢範囲外です", "設計書申込書作成エラーメッセージ２");
        exClassificationEquals(mosnaiCheckParam.getKouzokuSyoriJikkouKbn(), C_KouzokujkKbn.NONE, "後続処理実行区分");
    }

    @Test
    @TestOrder(1240)
    @Transactional
    public void testExec_A24() {
        MockObjectManager.initialize();
        CheckSaiteiPMockForSinkeiyaku.SYORIPTN = CheckSaiteiPMockForSinkeiyaku.TESTPATTERN1;
        CheckTblMosSyouhin checkTblMosSyouhin = SWAKInjector.getInstance(CheckTblMosSyouhin.class);

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("980000020");
        List<HT_MosSyouhn> syuMosSyouhnParamLst = syoriCTL.getMosSyouhnsBySyutkkbn(C_SyutkKbn.SYU);
        HT_MosSyouhn syuMosSyouhnParam = syuMosSyouhnParamLst.get(0);
        BM_SyouhnZokusei syuSyouhnZokusei = bizDomManager.getSyouhnZokusei(syuMosSyouhnParam.getSyouhncd(),
            syuMosSyouhnParam.getSyouhnsdno());
        mosnaiCheckParam.setSyuSyouhnZokusei(syuSyouhnZokusei);
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setSysKbn(C_SysKbn.ESHIEN);
        mosnaiCheckParam.setKokutiChkHuyoUmu(C_UmuKbn.NONE);
        mosnaiCheckParam.setSysDate(BizDate.valueOf(20160102));
        mosnaiCheckParam.setSekmossakuseiSousasyaKbn(C_SeihowebsousasyaKbn.SUPPORTDESK);
        mosnaiCheckParam.setKiteiCheckChannelCd(C_Channelcd.TIGIN);

        checkTblMosSyouhin.exec(mosnaiCheckParam);

        exClassificationEquals(mosnaiCheckParam.getSekmossakuseiErroutKbn(), C_SekmossakuseiErroutKbn.GAMEN, "設計書申込書作成エラー出力区分");
        exStringEquals(mosnaiCheckParam.getSekmossakuseiErrmsg1(), "", "設計書申込書作成エラーメッセージ１");
        exStringEquals(mosnaiCheckParam.getSekmossakuseiErrmsg2(), "契約年齢範囲外です　契約年齢は１歳から９８歳です", "設計書申込書作成エラーメッセージ２");
        exClassificationEquals(mosnaiCheckParam.getKouzokuSyoriJikkouKbn(), C_KouzokujkKbn.NONE, "後続処理実行区分");
    }

    @Test
    @TestOrder(1250)
    @Transactional
    public void testExec_A25() {
        MockObjectManager.initialize();
        CheckSaiteiPMockForSinkeiyaku.SYORIPTN = CheckSaiteiPMockForSinkeiyaku.TESTPATTERN1;
        GetKiteiCheckYenkansangkMockForSinkeiyaku.SYORIPTN = GetKiteiCheckYenkansangkMockForSinkeiyaku.TESTPATTERN1;
        CheckTblMosSyouhin checkTblMosSyouhin = SWAKInjector.getInstance(CheckTblMosSyouhin.class);

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("980000038");
        List<HT_MosSyouhn> syuMosSyouhnParamLst = syoriCTL.getMosSyouhnsBySyutkkbn(C_SyutkKbn.SYU);
        HT_MosSyouhn syuMosSyouhnParam = syuMosSyouhnParamLst.get(0);
        BM_SyouhnZokusei syuSyouhnZokusei = bizDomManager.getSyouhnZokusei(syuMosSyouhnParam.getSyouhncd(),
            syuMosSyouhnParam.getSyouhnsdno());
        mosnaiCheckParam.setSyuSyouhnZokusei(syuSyouhnZokusei);
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setSysKbn(C_SysKbn.ESHIEN);
        mosnaiCheckParam.setKokutiChkHuyoUmu(C_UmuKbn.NONE);
        mosnaiCheckParam.setSysDate(BizDate.valueOf(20160102));
        mosnaiCheckParam.setSekmossakuseiSousasyaKbn(C_SeihowebsousasyaKbn.SUPPORTDESK);
        mosnaiCheckParam.setKiteiCheckChannelCd(C_Channelcd.TIGIN);

        checkTblMosSyouhin.exec(mosnaiCheckParam);

        exClassificationEquals(mosnaiCheckParam.getSekmossakuseiErroutKbn(), C_SekmossakuseiErroutKbn.GAMEN, "設計書申込書作成エラー出力区分");
        exStringEquals(mosnaiCheckParam.getSekmossakuseiErrmsg1(), "", "設計書申込書作成エラーメッセージ１");
        exStringEquals(mosnaiCheckParam.getSekmossakuseiErrmsg2(), "募集年齢範囲外です　当予定利率期間の募集年齢範囲は０歳から１００歳です", "設計書申込書作成エラーメッセージ２");
        exClassificationEquals(mosnaiCheckParam.getKouzokuSyoriJikkouKbn(), C_KouzokujkKbn.NONE, "後続処理実行区分");
    }

    @Test
    @TestOrder(2010)
    @Transactional
    public void testExec_B1() {
        MockObjectManager.initialize();
        CheckSaiteiPMockForSinkeiyaku.SYORIPTN = CheckSaiteiPMockForSinkeiyaku.TESTPATTERN1;
        CheckTblMosSyouhin checkTblMosSyouhin = SWAKInjector.getInstance(CheckTblMosSyouhin.class);

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("860000231");
        List<HT_MosSyouhn> syuMosSyouhnParamLst = syoriCTL.getMosSyouhnsBySyutkkbn(C_SyutkKbn.SYU);
        HT_MosSyouhn syuMosSyouhnParam = syuMosSyouhnParamLst.get(0);
        BM_SyouhnZokusei syuSyouhnZokusei = bizDomManager.getSyouhnZokusei(syuMosSyouhnParam.getSyouhncd(),
            syuMosSyouhnParam.getSyouhnsdno());
        mosnaiCheckParam.setSyuSyouhnZokusei(syuSyouhnZokusei);
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setSysKbn(C_SysKbn.SKEI);
        mosnaiCheckParam.setKokutiChkHuyoUmu(C_UmuKbn.NONE);
        mosnaiCheckParam.setSysDate(BizDate.valueOf(20160102));
        mosnaiCheckParam.setSekmossakuseiSousasyaKbn(C_SeihowebsousasyaKbn.SUPPORTDESK);
        mosnaiCheckParam.setKiteiCheckChannelCd(C_Channelcd.TIGIN);

        checkTblMosSyouhin.exec(mosnaiCheckParam);

        List<HT_HubiMsg> hubiMsgLst = mosnaiCheckParam.getListHubiMsg();

        exNumericEquals(hubiMsgLst.size(), 7, "不備メッセージテーブルエンティティリストのサイズ");

        exStringEquals(hubiMsgLst.get(0).getMosno(), "860000231", "申込番号");
        exNumericEquals(hubiMsgLst.get(0).getRenno(), 1, "連番");
        exStringEquals(hubiMsgLst.get(0).getMessageId(), "THC0028", "メッセージＩＤ");
        exStringEquals(hubiMsgLst.get(0).getHubimsg(), "【特認可能】外貨建て一時払終身保険（即時保障型）　１５年毎利率再設定の契約可能期間・年齢範囲外です。", "不備メッセージ");
        exClassificationEquals(hubiMsgLst.get(0).getHubisyubetukbn(), C_HubisyubetuKbn.KETHORYU_HUBI, "不備種別区分");

        exStringEquals(hubiMsgLst.get(1).getMosno(), "860000231", "申込番号");
        exNumericEquals(hubiMsgLst.get(1).getRenno(), 2, "連番");
        exStringEquals(hubiMsgLst.get(1).getMessageId(), "EHC0019", "メッセージＩＤ");
        exStringEquals(hubiMsgLst.get(1).getHubimsg(), "外貨建て一時払終身保険（即時保障型）　１５年毎利率再設定の２０／１万　型は取扱えません。", "不備メッセージ");
        exClassificationEquals(hubiMsgLst.get(1).getHubisyubetukbn(), C_HubisyubetuKbn.KETHORYU_HUBI, "不備種別区分");

        exNumericEquals(hubiMsgLst.get(2).getRenno(), 3, "連番");
        exStringEquals(hubiMsgLst.get(2).getMessageId(), "EHC0019", "メッセージＩＤ");
        exStringEquals(hubiMsgLst.get(2).getHubimsg(), "外貨建て一時払終身保険（即時保障型）　１５年毎利率再設定の１８０日型は取扱えません。", "不備メッセージ");
        exClassificationEquals(hubiMsgLst.get(2).getHubisyubetukbn(), C_HubisyubetuKbn.KETHORYU_HUBI, "不備種別区分");

        exNumericEquals(hubiMsgLst.get(3).getRenno(), 4, "連番");
        exStringEquals(hubiMsgLst.get(3).getMessageId(), "EBC0045", "メッセージＩＤ");
        exStringEquals(hubiMsgLst.get(3).getHubimsg(), "手術給付金型の入力が必要です。", "不備メッセージ");
        exClassificationEquals(hubiMsgLst.get(3).getHubisyubetukbn(), C_HubisyubetuKbn.KETHORYU_HUBI, "不備種別区分");

        exNumericEquals(hubiMsgLst.get(4).getRenno(), 5, "連番");
        exStringEquals(hubiMsgLst.get(4).getMessageId(), "EBC0045", "メッセージＩＤ");
        exStringEquals(hubiMsgLst.get(4).getHubimsg(), "基本給付金額倍率の入力が必要です。", "不備メッセージ");
        exClassificationEquals(hubiMsgLst.get(4).getHubisyubetukbn(), C_HubisyubetuKbn.KETHORYU_HUBI, "不備種別区分");

        exNumericEquals(hubiMsgLst.get(5).getRenno(), 6, "連番");
        exStringEquals(hubiMsgLst.get(5).getMessageId(), "EBC0045", "メッセージＩＤ");
        exStringEquals(hubiMsgLst.get(5).getHubimsg(), "６大生活習慣病追加給付の入力が必要です。", "不備メッセージ");
        exClassificationEquals(hubiMsgLst.get(5).getHubisyubetukbn(), C_HubisyubetuKbn.KETHORYU_HUBI, "不備種別区分");

        exNumericEquals(hubiMsgLst.get(6).getRenno(), 7, "連番");
        exStringEquals(hubiMsgLst.get(6).getMessageId(), "EHC1053", "メッセージＩＤ");
        exStringEquals(hubiMsgLst.get(6).getHubimsg(), "基準額判定用為替レート適用範囲外です。　申込日２０１６０５１１", "不備メッセージ");
        exClassificationEquals(hubiMsgLst.get(6).getHubisyubetukbn(), C_HubisyubetuKbn.KETHORYU_HUBI, "不備種別区分");



    }

    @Test
    @TestOrder(2020)
    @Transactional
    public void testExec_B2() {
        MockObjectManager.initialize();
        CheckSaiteiPMockForSinkeiyaku.SYORIPTN = CheckSaiteiPMockForSinkeiyaku.TESTPATTERN1;
        CheckTblMosSyouhin checkTblMosSyouhin = SWAKInjector.getInstance(CheckTblMosSyouhin.class);

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("860000249");
        List<HT_MosSyouhn> syuMosSyouhnParamLst = syoriCTL.getMosSyouhnsBySyutkkbn(C_SyutkKbn.SYU);
        HT_MosSyouhn syuMosSyouhnParam = syuMosSyouhnParamLst.get(0);
        BM_SyouhnZokusei syuSyouhnZokusei = bizDomManager.getSyouhnZokusei(syuMosSyouhnParam.getSyouhncd(),
            syuMosSyouhnParam.getSyouhnsdno());
        mosnaiCheckParam.setSyuSyouhnZokusei(syuSyouhnZokusei);
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setSysKbn(C_SysKbn.SKEI);
        mosnaiCheckParam.setKokutiChkHuyoUmu(C_UmuKbn.NONE);
        mosnaiCheckParam.setSysDate(BizDate.valueOf(20160102));
        mosnaiCheckParam.setSekmossakuseiSousasyaKbn(C_SeihowebsousasyaKbn.SUPPORTDESK);

        checkTblMosSyouhin.exec(mosnaiCheckParam);

        List<HT_HubiMsg> hubiMsgLst = mosnaiCheckParam.getListHubiMsg();

        exNumericEquals(hubiMsgLst.size(), 1, "不備メッセージテーブルエンティティリストのサイズ");

        exStringEquals(hubiMsgLst.get(0).getMosno(), "860000249", "申込番号");
        exNumericEquals(hubiMsgLst.get(0).getRenno(), 1, "連番");
        exStringEquals(hubiMsgLst.get(0).getMessageId(), "EHC0019", "メッセージＩＤ");
        exStringEquals(hubiMsgLst.get(0).getHubimsg(), "外貨建て一時払終身保険（即時保障型）　１５年毎利率再設定の１倍は取扱えません。", "不備メッセージ");
        exClassificationEquals(hubiMsgLst.get(0).getHubisyubetukbn(), C_HubisyubetuKbn.KETHORYU_HUBI, "不備種別区分");
    }

    @Test
    @TestOrder(2030)
    @Transactional
    public void testExec_B3() {
        MockObjectManager.initialize();
        CheckSaiteiPMockForSinkeiyaku.SYORIPTN = CheckSaiteiPMockForSinkeiyaku.TESTPATTERN1;
        CheckTblMosSyouhin checkTblMosSyouhin = SWAKInjector.getInstance(CheckTblMosSyouhin.class);

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("860000256");
        List<HT_MosSyouhn> syuMosSyouhnParamLst = syoriCTL.getMosSyouhnsBySyutkkbn(C_SyutkKbn.SYU);
        HT_MosSyouhn syuMosSyouhnParam = syuMosSyouhnParamLst.get(0);
        BM_SyouhnZokusei syuSyouhnZokusei = bizDomManager.getSyouhnZokusei(syuMosSyouhnParam.getSyouhncd(),
            syuMosSyouhnParam.getSyouhnsdno());
        mosnaiCheckParam.setSyuSyouhnZokusei(syuSyouhnZokusei);
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setSysKbn(C_SysKbn.SKEI);
        mosnaiCheckParam.setKokutiChkHuyoUmu(C_UmuKbn.NONE);
        mosnaiCheckParam.setSysDate(BizDate.valueOf(20160102));
        mosnaiCheckParam.setSekmossakuseiSousasyaKbn(C_SeihowebsousasyaKbn.SUPPORTDESK);

        checkTblMosSyouhin.exec(mosnaiCheckParam);

        List<HT_HubiMsg> hubiMsgLst = mosnaiCheckParam.getListHubiMsg();

        exNumericEquals(hubiMsgLst.size(), 1, "不備メッセージテーブルエンティティリストのサイズ");

        exStringEquals(hubiMsgLst.get(0).getMosno(), "860000256", "申込番号");
        exNumericEquals(hubiMsgLst.get(0).getRenno(), 1, "連番");
        exStringEquals(hubiMsgLst.get(0).getMessageId(), "EBC0007", "メッセージＩＤ");
        exStringEquals(hubiMsgLst.get(0).getHubimsg(), "６大生活習慣病追加給付は不要です。", "不備メッセージ");
        exClassificationEquals(hubiMsgLst.get(0).getHubisyubetukbn(), C_HubisyubetuKbn.KETHORYU_HUBI, "不備種別区分");
    }

    @Test
    @TestOrder(2040)
    @Transactional
    public void testExec_B4() {
        MockObjectManager.initialize();
        CheckSaiteiPMockForSinkeiyaku.SYORIPTN = CheckSaiteiPMockForSinkeiyaku.TESTPATTERN1;
        CheckTblMosSyouhin checkTblMosSyouhin = SWAKInjector.getInstance(CheckTblMosSyouhin.class);

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("860000264");
        List<HT_MosSyouhn> syuMosSyouhnParamLst = syoriCTL.getMosSyouhnsBySyutkkbn(C_SyutkKbn.SYU);
        HT_MosSyouhn syuMosSyouhnParam = syuMosSyouhnParamLst.get(0);
        BM_SyouhnZokusei syuSyouhnZokusei = bizDomManager.getSyouhnZokusei(syuMosSyouhnParam.getSyouhncd(),
            syuMosSyouhnParam.getSyouhnsdno());
        mosnaiCheckParam.setSyuSyouhnZokusei(syuSyouhnZokusei);
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setSysKbn(C_SysKbn.SKEI);
        mosnaiCheckParam.setKokutiChkHuyoUmu(C_UmuKbn.NONE);
        mosnaiCheckParam.setSysDate(BizDate.valueOf(20160102));
        mosnaiCheckParam.setSekmossakuseiSousasyaKbn(C_SeihowebsousasyaKbn.SUPPORTDESK);

        checkTblMosSyouhin.exec(mosnaiCheckParam);

        List<HT_HubiMsg> hubiMsgLst = mosnaiCheckParam.getListHubiMsg();

        exNumericEquals(hubiMsgLst.size(), 3, "不備メッセージテーブルエンティティリストのサイズ");

        exStringEquals(hubiMsgLst.get(0).getMosno(), "860000264", "申込番号");
        exNumericEquals(hubiMsgLst.get(0).getRenno(), 1, "連番");
        exStringEquals(hubiMsgLst.get(0).getMessageId(), "EHC0130", "メッセージＩＤ");
        exStringEquals(hubiMsgLst.get(0).getHubimsg(), "外貨建て一時払終身保険（即時保障型）　１０年毎利率再設定の給付型の入力は不要です。", "不備メッセージ");
        exClassificationEquals(hubiMsgLst.get(0).getHubisyubetukbn(), C_HubisyubetuKbn.KETHORYU_HUBI, "不備種別区分");

        exNumericEquals(hubiMsgLst.get(1).getRenno(), 2, "連番");
        exStringEquals(hubiMsgLst.get(1).getMessageId(), "EBC0007", "メッセージＩＤ");
        exStringEquals(hubiMsgLst.get(1).getHubimsg(), "手術給付金型は不要です。", "不備メッセージ");
        exClassificationEquals(hubiMsgLst.get(1).getHubisyubetukbn(), C_HubisyubetuKbn.KETHORYU_HUBI, "不備種別区分");

        exNumericEquals(hubiMsgLst.get(2).getRenno(), 3, "連番");
        exStringEquals(hubiMsgLst.get(2).getMessageId(), "EBC0007", "メッセージＩＤ");
        exStringEquals(hubiMsgLst.get(2).getHubimsg(), "基本給付金額倍率は不要です。", "不備メッセージ");
        exClassificationEquals(hubiMsgLst.get(2).getHubisyubetukbn(), C_HubisyubetuKbn.KETHORYU_HUBI, "不備種別区分");
    }

    @Test
    @TestOrder(2050)
    @Transactional
    public void testExec_B5() {
        MockObjectManager.initialize();
        CheckSaiteiPMockForSinkeiyaku.SYORIPTN = CheckSaiteiPMockForSinkeiyaku.TESTPATTERN1;
        CheckTblMosSyouhin checkTblMosSyouhin = SWAKInjector.getInstance(CheckTblMosSyouhin.class);

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("860000272");
        List<HT_MosSyouhn> syuMosSyouhnParamLst = syoriCTL.getMosSyouhnsBySyutkkbn(C_SyutkKbn.SYU);
        HT_MosSyouhn syuMosSyouhnParam = syuMosSyouhnParamLst.get(0);
        BM_SyouhnZokusei syuSyouhnZokusei = bizDomManager.getSyouhnZokusei(syuMosSyouhnParam.getSyouhncd(),
            syuMosSyouhnParam.getSyouhnsdno());
        mosnaiCheckParam.setSyuSyouhnZokusei(syuSyouhnZokusei);
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setSysKbn(C_SysKbn.SKEI);
        mosnaiCheckParam.setKokutiChkHuyoUmu(C_UmuKbn.NONE);
        mosnaiCheckParam.setSysDate(BizDate.valueOf(20160102));
        mosnaiCheckParam.setSekmossakuseiSousasyaKbn(C_SeihowebsousasyaKbn.SUPPORTDESK);

        checkTblMosSyouhin.exec(mosnaiCheckParam);

        List<HT_HubiMsg> hubiMsgLst = mosnaiCheckParam.getListHubiMsg();

        exNumericEquals(hubiMsgLst.size(), 0, "不備メッセージテーブルエンティティリストのサイズ");

    }
    @Test(expected = CommonBizAppException.class)
    @TestOrder(3010)
    @Transactional
    public void testExec_C1() {
        MockObjectManager.initialize();
        CheckTblMosSyouhin checkTblMosSyouhin = SWAKInjector.getInstance(CheckTblMosSyouhin.class);

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("860000280");
        List<HT_MosSyouhn> syuMosSyouhnParamLst = syoriCTL.getMosSyouhnsBySyutkkbn(C_SyutkKbn.SYU);
        HT_MosSyouhn syuMosSyouhnParam = syuMosSyouhnParamLst.get(0);
        BM_SyouhnZokusei syuSyouhnZokusei = bizDomManager.getSyouhnZokusei(syuMosSyouhnParam.getSyouhncd(),
            syuMosSyouhnParam.getSyouhnsdno());
        mosnaiCheckParam.setSyuSyouhnZokusei(syuSyouhnZokusei);
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setSysKbn(C_SysKbn.SKEI);
        mosnaiCheckParam.setKokutiChkHuyoUmu(C_UmuKbn.NONE);
        mosnaiCheckParam.setSysDate(BizDate.valueOf(20160102));
        mosnaiCheckParam.setSekmossakuseiSousasyaKbn(C_SeihowebsousasyaKbn.SUPPORTDESK);

        try {
            checkTblMosSyouhin.exec(mosnaiCheckParam);
        } catch (CommonBizAppException e) {
            exStringEquals(e.getMessage(), "システム整合性エラーです。最低Ｐテーブルにデータが見つかりません。", "エラーメッセージ");
            throw e;
        }
    }

    @Test
    @TestOrder(3020)
    @Transactional
    public void testExec_C2() {
        MockObjectManager.initialize();
        CheckSaiteiPMockForSinkeiyaku.SYORIPTN = CheckSaiteiPMockForSinkeiyaku.TESTPATTERN1;
        HanteiMoschkMockForSinkeiyaku.SYORIPTN = HanteiMoschkMockForSinkeiyaku.TESTPATTERN1;
        EditNenkinKoumokuUtilMockForSinkeiyaku.SYORIPTN = EditNenkinKoumokuUtilMockForSinkeiyaku.TESTPATTERN1;
        CheckTblMosSyouhin checkTblMosSyouhin = SWAKInjector.getInstance(CheckTblMosSyouhin.class);

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("860000298");
        List<HT_MosSyouhn> syuMosSyouhnParamLst = syoriCTL.getMosSyouhnsBySyutkkbn(C_SyutkKbn.SYU);
        HT_MosSyouhn syuMosSyouhnParam = syuMosSyouhnParamLst.get(0);
        BM_SyouhnZokusei syuSyouhnZokusei = bizDomManager.getSyouhnZokusei(syuMosSyouhnParam.getSyouhncd(),
            syuMosSyouhnParam.getSyouhnsdno());
        mosnaiCheckParam.setSyuSyouhnZokusei(syuSyouhnZokusei);
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setSysKbn(C_SysKbn.SKEI);
        mosnaiCheckParam.setKokutiChkHuyoUmu(C_UmuKbn.NONE);
        mosnaiCheckParam.setSysDate(BizDate.valueOf(20160102));
        mosnaiCheckParam.setSekmossakuseiSousasyaKbn(C_SeihowebsousasyaKbn.SUPPORTDESK);
        mosnaiCheckParam.setListHubiMsg(new ArrayList<HT_HubiMsg>());
        mosnaiCheckParam.setKosID("JUnitTest");
        mosnaiCheckParam.setKosTime("20160509141230000");

        checkTblMosSyouhin.exec(mosnaiCheckParam);

        List<HT_HubiMsg> hubiMsgLst = mosnaiCheckParam.getListHubiMsg();

        exNumericEquals(hubiMsgLst.size(), 3, "不備メッセージテーブルエンティティリストのサイズ");

        exStringEquals(hubiMsgLst.get(1).getMosno(), "860000298", "申込番号");
        exNumericEquals(hubiMsgLst.get(1).getRenno(), 2, "連番");
        exStringEquals(hubiMsgLst.get(1).getMessageId(), "EHC1015", "メッセージＩＤ");
        exStringEquals(hubiMsgLst.get(1).getHubimsg(), "外貨建て一時払終身保険（即時保障型）　１０年毎利率再設定の保険料が１，０２０，３００円単位になっていません。", "不備メッセージ");
        exClassificationEquals(hubiMsgLst.get(1).getHubisyubetukbn(), C_HubisyubetuKbn.KETHORYU_HUBI, "不備種別区分");
        exStringEquals(hubiMsgLst.get(1).getGyoumuKousinsyaId(), "JUnitTest", "業務用更新者ＩＤ");
        exStringEquals(hubiMsgLst.get(1).getGyoumuKousinTime(), "20160509141230000", "業務用更新時間");

        exStringEquals(hubiMsgLst.get(2).getMosno(), "860000298", "申込番号");
        exNumericEquals(hubiMsgLst.get(2).getRenno(), 3, "連番");
        exStringEquals(hubiMsgLst.get(2).getMessageId(), "THC1038", "メッセージＩＤ");
        exStringEquals(hubiMsgLst.get(2).getHubimsg(), "【特認可能】外貨建て一時払終身保険（即時保障型）　１０年毎利率再設定の保険料（円換算額）が最高Ｐの１，０２０，３００円をオーバーしています。", "不備メッセージ");
        exClassificationEquals(hubiMsgLst.get(2).getHubisyubetukbn(), C_HubisyubetuKbn.KETHORYU_HUBI, "不備種別区分");
        exStringEquals(hubiMsgLst.get(2).getGyoumuKousinsyaId(), "JUnitTest", "業務用更新者ＩＤ");
        exStringEquals(hubiMsgLst.get(2).getGyoumuKousinTime(), "20160509141230000", "業務用更新時間");
    }

    @Test
    @TestOrder(3030)
    @Transactional
    public void testExec_C3() {
        MockObjectManager.initialize();
        CheckSaiteiPMockForSinkeiyaku.SYORIPTN = CheckSaiteiPMockForSinkeiyaku.TESTPATTERN1;
        CheckTblMosSyouhin checkTblMosSyouhin = SWAKInjector.getInstance(CheckTblMosSyouhin.class);

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("860000306");
        List<HT_MosSyouhn> syuMosSyouhnParamLst = syoriCTL.getMosSyouhnsBySyutkkbn(C_SyutkKbn.SYU);
        HT_MosSyouhn syuMosSyouhnParam = syuMosSyouhnParamLst.get(0);
        BM_SyouhnZokusei syuSyouhnZokusei = bizDomManager.getSyouhnZokusei(syuMosSyouhnParam.getSyouhncd(),
            syuMosSyouhnParam.getSyouhnsdno());
        mosnaiCheckParam.setSyuSyouhnZokusei(syuSyouhnZokusei);
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setSysKbn(C_SysKbn.ESHIEN);
        mosnaiCheckParam.setKokutiChkHuyoUmu(C_UmuKbn.NONE);
        mosnaiCheckParam.setSysDate(BizDate.valueOf(20160102));
        mosnaiCheckParam.setSekmossakuseiSousasyaKbn(C_SeihowebsousasyaKbn.SUPPORTDESK);
        mosnaiCheckParam.setBosyuuSysCtrlKbn(C_BosyuusysctrlKbn.SMBC);
        mosnaiCheckParam.setSekmossakuseiOyaAgCd("1234567");
        mosnaiCheckParam.setKiteiCheckChannelCd(C_Channelcd.BLNK);

        checkTblMosSyouhin.exec(mosnaiCheckParam);

        exClassificationEquals(mosnaiCheckParam.getSekmossakuseiErroutKbn(), C_SekmossakuseiErroutKbn.GAMEN, "設計書申込書作成エラー出力区分");
        exStringEquals(mosnaiCheckParam.getSekmossakuseiErrmsg1(), "", "設計書申込書作成エラーメッセージ１");
        exStringEquals(mosnaiCheckParam.getSekmossakuseiErrmsg2(), "払込金額は１０２万円単位にしてください", "設計書申込書作成エラーメッセージ２");
        exClassificationEquals(mosnaiCheckParam.getKouzokuSyoriJikkouKbn(), C_KouzokujkKbn.NONE, "後続処理実行区分");



    }

    @Test
    @TestOrder(3040)
    @Transactional
    public void testExec_C4() {
        MockObjectManager.initialize();
        CheckSaiteiPMockForSinkeiyaku.SYORIPTN = CheckSaiteiPMockForSinkeiyaku.TESTPATTERN1;
        HanteiMoschkMockForSinkeiyaku.SYORIPTN = HanteiMoschkMockForSinkeiyaku.TESTPATTERN1;
        EditNenkinKoumokuUtilMockForSinkeiyaku.SYORIPTN = EditNenkinKoumokuUtilMockForSinkeiyaku.TESTPATTERN1;
        CheckTblMosSyouhin checkTblMosSyouhin = SWAKInjector.getInstance(CheckTblMosSyouhin.class);

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("860000314");
        List<HT_MosSyouhn> syuMosSyouhnParamLst = syoriCTL.getMosSyouhnsBySyutkkbn(C_SyutkKbn.SYU);
        HT_MosSyouhn syuMosSyouhnParam = syuMosSyouhnParamLst.get(0);
        BM_SyouhnZokusei syuSyouhnZokusei = bizDomManager.getSyouhnZokusei(syuMosSyouhnParam.getSyouhncd(),
            syuMosSyouhnParam.getSyouhnsdno());
        mosnaiCheckParam.setSyuSyouhnZokusei(syuSyouhnZokusei);
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setSysKbn(C_SysKbn.ESHIEN);
        mosnaiCheckParam.setKokutiChkHuyoUmu(C_UmuKbn.NONE);
        mosnaiCheckParam.setSysDate(BizDate.valueOf(20160102));
        mosnaiCheckParam.setSekmossakuseiSousasyaKbn(C_SeihowebsousasyaKbn.SUPPORTDESK);
        mosnaiCheckParam.setBosyuuSysCtrlKbn(C_BosyuusysctrlKbn.SMBC);
        mosnaiCheckParam.setSekmossakuseiOyaAgCd("1234567");
        mosnaiCheckParam.setKiteiCheckChannelCd(C_Channelcd.BLNK);

        checkTblMosSyouhin.exec(mosnaiCheckParam);

        exClassificationEquals(mosnaiCheckParam.getSekmossakuseiErroutKbn(), C_SekmossakuseiErroutKbn.GAMEN, "設計書申込書作成エラー出力区分");
        exStringEquals(mosnaiCheckParam.getSekmossakuseiErrmsg1(), "", "設計書申込書作成エラーメッセージ１");
        exStringEquals(mosnaiCheckParam.getSekmossakuseiErrmsg2(), "最高保険料を超えています　払込金額は１０２万円までにしてください", "設計書申込書作成エラーメッセージ２");
        exClassificationEquals(mosnaiCheckParam.getKouzokuSyoriJikkouKbn(), C_KouzokujkKbn.NONE, "後続処理実行区分");


    }

    @Test
    @TestOrder(3050)
    @Transactional
    public void testExec_C5() {
        MockObjectManager.initialize();
        CheckSaiteiPMockForSinkeiyaku.SYORIPTN = CheckSaiteiPMockForSinkeiyaku.TESTPATTERN1;
        CheckTblMosSyouhin checkTblMosSyouhin = SWAKInjector.getInstance(CheckTblMosSyouhin.class);

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("860000322");
        List<HT_MosSyouhn> syuMosSyouhnParamLst = syoriCTL.getMosSyouhnsBySyutkkbn(C_SyutkKbn.SYU);
        HT_MosSyouhn syuMosSyouhnParam = syuMosSyouhnParamLst.get(0);
        BM_SyouhnZokusei syuSyouhnZokusei = bizDomManager.getSyouhnZokusei(syuMosSyouhnParam.getSyouhncd(),
            syuMosSyouhnParam.getSyouhnsdno());
        mosnaiCheckParam.setSyuSyouhnZokusei(syuSyouhnZokusei);
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setSysKbn(C_SysKbn.SKEI);
        mosnaiCheckParam.setKokutiChkHuyoUmu(C_UmuKbn.NONE);
        mosnaiCheckParam.setSysDate(BizDate.valueOf(20160102));
        mosnaiCheckParam.setSekmossakuseiSousasyaKbn(C_SeihowebsousasyaKbn.SUPPORTDESK);
        mosnaiCheckParam.setListHubiMsg(new ArrayList<HT_HubiMsg>());
        mosnaiCheckParam.setKiteiCheckChannelCd(C_Channelcd.BLNK);

        checkTblMosSyouhin.exec(mosnaiCheckParam);

        List<HT_HubiMsg> hubiMsgLst = mosnaiCheckParam.getListHubiMsg();

        exNumericEquals(hubiMsgLst.size(), 1, "不備メッセージテーブルエンティティリストのサイズ");
        exStringEquals(hubiMsgLst.get(0).getMosno(), "860000322", "申込番号");
        exNumericEquals(hubiMsgLst.get(0).getRenno(), 1, "連番");
        exStringEquals(hubiMsgLst.get(0).getMessageId(), "EBC0046", "メッセージＩＤ");
        exStringEquals(hubiMsgLst.get(0).getHubimsg(), "据置期間が正しくありません。", "不備メッセージ");
        exClassificationEquals(hubiMsgLst.get(0).getHubisyubetukbn(), C_HubisyubetuKbn.KETHORYU_HUBI, "不備種別区分");
        exClassificationEquals(hubiMsgLst.get(0).getHubisyubetusyousaikbn(), C_HubisyubetusyousaiKbn.NONE,
            "不備種別詳細区分");


    }

    @Test(expected = CommonBizAppException.class)
    @TestOrder(3060)
    @Transactional
    public void testExec_C6() {
        MockObjectManager.initialize();
        CheckSaiteiPMockForSinkeiyaku.SYORIPTN = CheckSaiteiPMockForSinkeiyaku.TESTPATTERN1;
        HanteiMoschkMockForSinkeiyaku.SYORIPTN = HanteiMoschkMockForSinkeiyaku.TESTPATTERN1;
        EditNenkinKoumokuUtilMockForSinkeiyaku.SYORIPTN = EditNenkinKoumokuUtilMockForSinkeiyaku.TESTPATTERN1;
        CheckTblMosSyouhin checkTblMosSyouhin = SWAKInjector.getInstance(CheckTblMosSyouhin.class);

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("980000046");
        List<HT_MosSyouhn> syuMosSyouhnParamLst = syoriCTL.getMosSyouhnsBySyutkkbn(C_SyutkKbn.SYU);
        HT_MosSyouhn syuMosSyouhnParam = syuMosSyouhnParamLst.get(0);
        BM_SyouhnZokusei syuSyouhnZokusei = bizDomManager.getSyouhnZokusei(syuMosSyouhnParam.getSyouhncd(),
            syuMosSyouhnParam.getSyouhnsdno());
        mosnaiCheckParam.setSyuSyouhnZokusei(syuSyouhnZokusei);
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setSysKbn(C_SysKbn.SKEI);
        mosnaiCheckParam.setKokutiChkHuyoUmu(C_UmuKbn.NONE);
        mosnaiCheckParam.setSysDate(BizDate.valueOf(20160102));
        mosnaiCheckParam.setSekmossakuseiSousasyaKbn(C_SeihowebsousasyaKbn.SUPPORTDESK);

        try {
            checkTblMosSyouhin.exec(mosnaiCheckParam);
        } catch (CommonBizAppException e) {
            exStringEquals(e.getMessage(), "システム整合性エラーです。最高ＳＳ単位テーブルにデータが見つかりません。", "エラーメッセージ");
            throw e;
        }
    }

    @Test
    @TestOrder(3070)
    @Transactional
    public void testExec_C7() {
        MockObjectManager.initialize();
        KeisanGaikakanzanMockForSinkeiyaku.SYORIPTN = KeisanGaikakanzanMockForSinkeiyaku.TESTPATTERN1;
        GetKiteiCheckYenkansangkMockForSinkeiyaku.SYORIPTN = GetKiteiCheckYenkansangkMockForSinkeiyaku.TESTPATTERN2;
        CheckSaiteiPMockForSinkeiyaku.SYORIPTN = CheckSaiteiPMockForSinkeiyaku.TESTPATTERN1;
        HanteiMoschkMockForSinkeiyaku.SYORIPTN = HanteiMoschkMockForSinkeiyaku.TESTPATTERN1;
        EditNenkinKoumokuUtilMockForSinkeiyaku.SYORIPTN = EditNenkinKoumokuUtilMockForSinkeiyaku.TESTPATTERN1;
        CheckTblMosSyouhin checkTblMosSyouhin = SWAKInjector.getInstance(CheckTblMosSyouhin.class);

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("990000010");
        List<HT_MosSyouhn> syuMosSyouhnParamLst = syoriCTL.getMosSyouhnsBySyutkkbn(C_SyutkKbn.SYU);
        HT_MosSyouhn syuMosSyouhnParam = syuMosSyouhnParamLst.get(0);
        BM_SyouhnZokusei syuSyouhnZokusei = bizDomManager.getSyouhnZokusei(syuMosSyouhnParam.getSyouhncd(),
            syuMosSyouhnParam.getSyouhnsdno());
        mosnaiCheckParam.setSyuSyouhnZokusei(syuSyouhnZokusei);
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setSysKbn(C_SysKbn.ESHIEN);
        mosnaiCheckParam.setKokutiChkHuyoUmu(C_UmuKbn.NONE);
        mosnaiCheckParam.setSysDate(BizDate.valueOf(20160102));
        mosnaiCheckParam.setSekmossakuseiSousasyaKbn(C_SeihowebsousasyaKbn.SUPPORTDESK);
        mosnaiCheckParam.setBosyuuSysCtrlKbn(C_BosyuusysctrlKbn.SMBC);
        mosnaiCheckParam.setKiteiCheckChannelCd(C_Channelcd.BLNK);

        checkTblMosSyouhin.exec(mosnaiCheckParam);

        exClassificationEquals(mosnaiCheckParam.getSekmossakuseiErroutKbn(), C_SekmossakuseiErroutKbn.GAMEN, "設計書申込書作成エラー出力区分");
        exStringEquals(mosnaiCheckParam.getSekmossakuseiErrmsg1(), "最高保険料を超えています　払込金額は１０２，０３０，０００．００米ドルまでにして", "設計書申込書作成エラーメッセージ１");
        exStringEquals(mosnaiCheckParam.getSekmossakuseiErrmsg2(), "ください", "設計書申込書作成エラーメッセージ２");
        exClassificationEquals(mosnaiCheckParam.getKouzokuSyoriJikkouKbn(), C_KouzokujkKbn.NONE, "後続処理実行区分");

    }

    @Test
    @TestOrder(3080)
    @Transactional
    public void testExec_C8() {
        MockObjectManager.initialize();
        KeisanGaikakanzanMockForSinkeiyaku.SYORIPTN = KeisanGaikakanzanMockForSinkeiyaku.TESTPATTERN2;
        GetKiteiCheckYenkansangkMockForSinkeiyaku.SYORIPTN = GetKiteiCheckYenkansangkMockForSinkeiyaku.TESTPATTERN2;
        CheckSaiteiPMockForSinkeiyaku.SYORIPTN = CheckSaiteiPMockForSinkeiyaku.TESTPATTERN1;
        HanteiMoschkMockForSinkeiyaku.SYORIPTN = HanteiMoschkMockForSinkeiyaku.TESTPATTERN1;
        EditNenkinKoumokuUtilMockForSinkeiyaku.SYORIPTN = EditNenkinKoumokuUtilMockForSinkeiyaku.TESTPATTERN1;
        CheckTblMosSyouhin checkTblMosSyouhin = SWAKInjector.getInstance(CheckTblMosSyouhin.class);

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("990000028");
        List<HT_MosSyouhn> syuMosSyouhnParamLst = syoriCTL.getMosSyouhnsBySyutkkbn(C_SyutkKbn.SYU);
        HT_MosSyouhn syuMosSyouhnParam = syuMosSyouhnParamLst.get(0);
        BM_SyouhnZokusei syuSyouhnZokusei = bizDomManager.getSyouhnZokusei(syuMosSyouhnParam.getSyouhncd(),
            syuMosSyouhnParam.getSyouhnsdno());
        mosnaiCheckParam.setSyuSyouhnZokusei(syuSyouhnZokusei);
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setSysKbn(C_SysKbn.ESHIEN);
        mosnaiCheckParam.setKokutiChkHuyoUmu(C_UmuKbn.NONE);
        mosnaiCheckParam.setSysDate(BizDate.valueOf(20160102));
        mosnaiCheckParam.setSekmossakuseiSousasyaKbn(C_SeihowebsousasyaKbn.SUPPORTDESK);
        mosnaiCheckParam.setBosyuuSysCtrlKbn(C_BosyuusysctrlKbn.SMBC);
        mosnaiCheckParam.setKiteiCheckChannelCd(C_Channelcd.BLNK);

        checkTblMosSyouhin.exec(mosnaiCheckParam);

        exClassificationEquals(mosnaiCheckParam.getSekmossakuseiErroutKbn(), C_SekmossakuseiErroutKbn.GAMEN, "設計書申込書作成エラー出力区分");
        exStringEquals(mosnaiCheckParam.getSekmossakuseiErrmsg1(), "", "設計書申込書作成エラーメッセージ１");
        exStringEquals(mosnaiCheckParam.getSekmossakuseiErrmsg2(), "最高保険料を超えています　払込金額は２０，４０６．００米ドルまでにしてください", "設計書申込書作成エラーメッセージ２");
        exClassificationEquals(mosnaiCheckParam.getKouzokuSyoriJikkouKbn(), C_KouzokujkKbn.NONE, "後続処理実行区分");


    }

    @Test(expected = CommonBizAppException.class)
    @TestOrder(3090)
    @Transactional
    public void testExec_C9() {
        MockObjectManager.initialize();
        KeisanGaikakanzanMockForSinkeiyaku.SYORIPTN = KeisanGaikakanzanMockForSinkeiyaku.TESTPATTERN2;
        GetKiteiCheckYenkansangkMockForSinkeiyaku.SYORIPTN = GetKiteiCheckYenkansangkMockForSinkeiyaku.TESTPATTERN2;
        CheckSaiteiPMockForSinkeiyaku.SYORIPTN = CheckSaiteiPMockForSinkeiyaku.TESTPATTERN1;
        CheckTblMosSyouhin checkTblMosSyouhin = SWAKInjector.getInstance(CheckTblMosSyouhin.class);

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("990000036");
        List<HT_MosSyouhn> syuMosSyouhnParamLst = syoriCTL.getMosSyouhnsBySyutkkbn(C_SyutkKbn.SYU);
        HT_MosSyouhn syuMosSyouhnParam = syuMosSyouhnParamLst.get(0);
        BM_SyouhnZokusei syuSyouhnZokusei = bizDomManager.getSyouhnZokusei(syuMosSyouhnParam.getSyouhncd(),
            syuMosSyouhnParam.getSyouhnsdno());
        mosnaiCheckParam.setSyuSyouhnZokusei(syuSyouhnZokusei);
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setSysKbn(C_SysKbn.ESHIEN);
        mosnaiCheckParam.setKokutiChkHuyoUmu(C_UmuKbn.NONE);
        mosnaiCheckParam.setSysDate(BizDate.valueOf(20160102));
        mosnaiCheckParam.setSekmossakuseiSousasyaKbn(C_SeihowebsousasyaKbn.SUPPORTDESK);

        try {
            checkTblMosSyouhin.exec(mosnaiCheckParam);
        } catch (CommonBizAppException e) {
            exStringEquals(e.getMessage(), "システム整合性エラーです。申込番号 = 990000036", "エラーメッセージ");
            throw e;
        }
    }

    @Test
    @TestOrder(3100)
    @Transactional
    public void testExec_C10() {
        MockObjectManager.initialize();
        CheckSaiteiPMockForSinkeiyaku.SYORIPTN = CheckSaiteiPMockForSinkeiyaku.TESTPATTERN1;
        CheckTblMosSyouhin checkTblMosSyouhin = SWAKInjector.getInstance(CheckTblMosSyouhin.class);

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("860001908");
        List<HT_MosSyouhn> syuMosSyouhnParamLst = syoriCTL.getMosSyouhnsBySyutkkbn(C_SyutkKbn.SYU);
        HT_MosSyouhn syuMosSyouhnParam = syuMosSyouhnParamLst.get(0);
        BM_SyouhnZokusei syuSyouhnZokusei = bizDomManager.getSyouhnZokusei(syuMosSyouhnParam.getSyouhncd(),
            syuMosSyouhnParam.getSyouhnsdno());
        mosnaiCheckParam.setSyuSyouhnZokusei(syuSyouhnZokusei);
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setSysKbn(C_SysKbn.SKEI);
        mosnaiCheckParam.setKokutiChkHuyoUmu(C_UmuKbn.NONE);
        mosnaiCheckParam.setSysDate(BizDate.valueOf(20160102));
        mosnaiCheckParam.setSekmossakuseiSousasyaKbn(C_SeihowebsousasyaKbn.SUPPORTDESK);
        mosnaiCheckParam.setListHubiMsg(new ArrayList<HT_HubiMsg>());
        mosnaiCheckParam.setKosID("JUnitTest");
        mosnaiCheckParam.setKosTime("20160509141230000");

        checkTblMosSyouhin.exec(mosnaiCheckParam);

        List<HT_HubiMsg> hubiMsgLst = mosnaiCheckParam.getListHubiMsg();

        exNumericEquals(hubiMsgLst.size(), 1, "不備メッセージテーブルエンティティリストのサイズ");
        exStringEquals(hubiMsgLst.get(0).getMosno(), "860001908", "申込番号");
        exNumericEquals(hubiMsgLst.get(0).getRenno(), 1, "連番");
        exStringEquals(hubiMsgLst.get(0).getMessageId(), "EBC0046", "メッセージＩＤ");
        exStringEquals(hubiMsgLst.get(0).getHubimsg(), "据置期間が正しくありません。", "不備メッセージ");
        exClassificationEquals(hubiMsgLst.get(0).getHubisyubetukbn(), C_HubisyubetuKbn.KETHORYU_HUBI, "不備種別区分");
        exClassificationEquals(hubiMsgLst.get(0).getHubisyubetusyousaikbn(), C_HubisyubetusyousaiKbn.NONE,
            "不備種別詳細区分");
        exStringEquals(hubiMsgLst.get(0).getGyoumuKousinsyaId(), "JUnitTest", "業務用更新者ＩＤ");
        exStringEquals(hubiMsgLst.get(0).getGyoumuKousinTime(), "20160509141230000", "業務用更新時間");

    }

    @Test(expected = CommonBizAppException.class)
    @TestOrder(3110)
    @Transactional
    public void testExec_C11() {
        MockObjectManager.initialize();
        CheckSaiteiPMockForSinkeiyaku.SYORIPTN = CheckSaiteiPMockForSinkeiyaku.TESTPATTERN1;
        HanteiMoschkMockForSinkeiyaku.SYORIPTN = HanteiMoschkMockForSinkeiyaku.TESTPATTERN1;
        EditNenkinKoumokuUtilMockForSinkeiyaku.SYORIPTN = EditNenkinKoumokuUtilMockForSinkeiyaku.TESTPATTERN1;
        CheckTblMosSyouhin checkTblMosSyouhin = SWAKInjector.getInstance(CheckTblMosSyouhin.class);

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("870000015");
        List<HT_MosSyouhn> syuMosSyouhnParamLst = syoriCTL.getMosSyouhnsBySyutkkbn(C_SyutkKbn.SYU);
        HT_MosSyouhn syuMosSyouhnParam = syuMosSyouhnParamLst.get(0);
        BM_SyouhnZokusei syuSyouhnZokusei = bizDomManager.getSyouhnZokusei(syuMosSyouhnParam.getSyouhncd(),
            syuMosSyouhnParam.getSyouhnsdno());
        mosnaiCheckParam.setSyuSyouhnZokusei(syuSyouhnZokusei);
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setSysKbn(C_SysKbn.SKEI);
        mosnaiCheckParam.setKokutiChkHuyoUmu(C_UmuKbn.NONE);
        mosnaiCheckParam.setSysDate(BizDate.valueOf(20160102));
        mosnaiCheckParam.setSekmossakuseiSousasyaKbn(C_SeihowebsousasyaKbn.SUPPORTDESK);
        mosnaiCheckParam.setListHubiMsg(new ArrayList<HT_HubiMsg>());
        mosnaiCheckParam.setKosID("JUnitTest");
        mosnaiCheckParam.setKosTime("20160509141230000");

        try {
            checkTblMosSyouhin.exec(mosnaiCheckParam);
        } catch (CommonBizAppException e) {
            exStringEquals(e.getMessage(), "システム整合性エラーです。最高ＳＳ単位テーブルにデータが見つかりません。", "エラーメッセージ");
            throw e;
        }
    }

    @Test(expected = CommonBizAppException.class)
    @TestOrder(3120)
    @Transactional
    public void testExec_C12() {
        MockObjectManager.initialize();
        CheckSaiteiPMockForSinkeiyaku.SYORIPTN = CheckSaiteiPMockForSinkeiyaku.TESTPATTERN1;
        HanteiMoschkMockForSinkeiyaku.SYORIPTN = HanteiMoschkMockForSinkeiyaku.TESTPATTERN1;
        EditNenkinKoumokuUtilMockForSinkeiyaku.SYORIPTN = EditNenkinKoumokuUtilMockForSinkeiyaku.TESTPATTERN1;
        CheckTblMosSyouhin checkTblMosSyouhin = SWAKInjector.getInstance(CheckTblMosSyouhin.class);

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("870000023");
        List<HT_MosSyouhn> syuMosSyouhnParamLst = syoriCTL.getMosSyouhnsBySyutkkbn(C_SyutkKbn.SYU);
        HT_MosSyouhn syuMosSyouhnParam = syuMosSyouhnParamLst.get(0);
        BM_SyouhnZokusei syuSyouhnZokusei = bizDomManager.getSyouhnZokusei(syuMosSyouhnParam.getSyouhncd(),
            syuMosSyouhnParam.getSyouhnsdno());
        mosnaiCheckParam.setSyuSyouhnZokusei(syuSyouhnZokusei);
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setSysKbn(C_SysKbn.SKEI);
        mosnaiCheckParam.setKokutiChkHuyoUmu(C_UmuKbn.NONE);
        mosnaiCheckParam.setSysDate(BizDate.valueOf(20160102));
        mosnaiCheckParam.setSekmossakuseiSousasyaKbn(C_SeihowebsousasyaKbn.SUPPORTDESK);
        mosnaiCheckParam.setListHubiMsg(new ArrayList<HT_HubiMsg>());
        mosnaiCheckParam.setKosID("JUnitTest");
        mosnaiCheckParam.setKosTime("20160509141230000");

        try {
            checkTblMosSyouhin.exec(mosnaiCheckParam);
        } catch (CommonBizAppException e) {
            exStringEquals(e.getMessage(), "システム整合性エラーです。最高ＳＳ単位テーブルにデータが見つかりません。", "エラーメッセージ");
            throw e;
        }
    }

    @Test
    @TestOrder(3130)
    @Transactional
    public void testExec_C13() {
        MockObjectManager.initialize();
        CheckSaiteiPMockForSinkeiyaku.SYORIPTN = CheckSaiteiPMockForSinkeiyaku.TESTPATTERN1;
        HanteiMoschkMockForSinkeiyaku.SYORIPTN = HanteiMoschkMockForSinkeiyaku.TESTPATTERN1;
        GetKiteiCheckYenkansangkMockForSinkeiyaku.SYORIPTN = GetKiteiCheckYenkansangkMockForSinkeiyaku.TESTPATTERN2;
        CheckTblMosSyouhin checkTblMosSyouhin = SWAKInjector.getInstance(CheckTblMosSyouhin.class);

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("860001122");
        List<HT_MosSyouhn> syuMosSyouhnParamLst = syoriCTL.getMosSyouhnsBySyutkkbn(C_SyutkKbn.SYU);
        HT_MosSyouhn syuMosSyouhnParam = syuMosSyouhnParamLst.get(0);
        BM_SyouhnZokusei syuSyouhnZokusei = bizDomManager.getSyouhnZokusei(syuMosSyouhnParam.getSyouhncd(),
            syuMosSyouhnParam.getSyouhnsdno());
        mosnaiCheckParam.setSyuSyouhnZokusei(syuSyouhnZokusei);
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setSysKbn(C_SysKbn.ESHIEN);
        mosnaiCheckParam.setKokutiChkHuyoUmu(C_UmuKbn.NONE);
        mosnaiCheckParam.setSysDate(BizDate.valueOf(20160102));
        mosnaiCheckParam.setSekmossakuseiSousasyaKbn(C_SeihowebsousasyaKbn.SUPPORTDESK);
        mosnaiCheckParam.setBosyuuSysCtrlKbn(C_BosyuusysctrlKbn.SMBC);
        mosnaiCheckParam.setSekmossakuseiOyaAgCd("1234567");
        mosnaiCheckParam.setKiteiCheckChannelCd(C_Channelcd.BLNK);

        checkTblMosSyouhin.exec(mosnaiCheckParam);

        exClassificationEquals(mosnaiCheckParam.getSekmossakuseiErroutKbn(), C_SekmossakuseiErroutKbn.GAMEN, "設計書申込書作成エラー出力区分");
        exStringEquals(mosnaiCheckParam.getSekmossakuseiErrmsg1(), "", "設計書申込書作成エラーメッセージ１");
        exStringEquals(mosnaiCheckParam.getSekmossakuseiErrmsg2(), "最高保険料を超えています　払込金額は２０，４０６米ドルまでにしてください", "設計書申込書作成エラーメッセージ２");
        exClassificationEquals(mosnaiCheckParam.getKouzokuSyoriJikkouKbn(), C_KouzokujkKbn.NONE, "後続処理実行区分");
    }
}