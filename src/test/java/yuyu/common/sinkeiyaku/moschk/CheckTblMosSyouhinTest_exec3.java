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
import yuyu.def.classification.C_KktatkichkkekkaKbn;
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
public class CheckTblMosSyouhinTest_exec3 {

    @Inject
    private MosnaiCheckParam mosnaiCheckParam;

    @Inject
    private SinkeiyakuDomManager sinkeiyakuDomManager;
    @Inject
    private BizDomManager bizDomManager;
    private final static String fileName = "UT-SP_単体テスト仕様書（共通）_申込商品TBLチェック";

    private final static String sheetName = "INデータ(3)";

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
        HanteiMoschkMockForSinkeiyaku.caller = CheckTblMosSyouhinTest_exec.class;
        EditNenkinKoumokuUtilMockForSinkeiyaku.caller = CheckTblMosSyouhinTest_exec.class;

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

    @Test
    @TestOrder(9010)
    @Transactional
    public void testExec_I1() {
        MockObjectManager.initialize();
        BzGetAgInfoMockForSinkeiyaku.SYORIPTN = BzGetAgInfoMockForSinkeiyaku.TESTPATTERN4;
        KeisanGaikakanzanMockForSinkeiyaku.SYORIPTN = KeisanGaikakanzanMockForSinkeiyaku.TESTPATTERN1;
        GetKiteiCheckYenkansangkMockForSinkeiyaku.SYORIPTN = GetKiteiCheckYenkansangkMockForSinkeiyaku.TESTPATTERN1;
        CheckSaiteiPMockForSinkeiyaku.SYORIPTN = CheckSaiteiPMockForSinkeiyaku.TESTPATTERN1;
        HanteiMoschkMockForSinkeiyaku.SYORIPTN = HanteiMoschkMockForSinkeiyaku.TESTPATTERN1;
        EditNenkinKoumokuUtilMockForSinkeiyaku.SYORIPTN = EditNenkinKoumokuUtilMockForSinkeiyaku.TESTPATTERN1;
        CheckTblMosSyouhin checkTblMosSyouhin = SWAKInjector.getInstance(CheckTblMosSyouhin.class);

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("860001007");
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
        mosnaiCheckParam.setKiteiCheckChannelCd(C_Channelcd.TIGIN);

        checkTblMosSyouhin.exec(mosnaiCheckParam);

        exClassificationEquals(mosnaiCheckParam.getSekmossakuseiErroutKbn(), C_SekmossakuseiErroutKbn.GAMEN, "設計書申込書作成エラー出力区分");
        exStringEquals(mosnaiCheckParam.getSekmossakuseiErrmsg1(), "外貨建て一時払終身保険（即時保障型）　１０年毎利率再設定には外貨建て一時払終身保", "設計書申込書作成エラーメッセージ１");
        exStringEquals(mosnaiCheckParam.getSekmossakuseiErrmsg2(), "険（毎年受取型）　１５年毎利率再設定を付加できません。", "設計書申込書作成エラーメッセージ２");
        exClassificationEquals(mosnaiCheckParam.getKouzokuSyoriJikkouKbn(), C_KouzokujkKbn.NONE, "後続処理実行区分");
    }

    @Test
    @TestOrder(9020)
    @Transactional
    public void testExec_I2() {
        MockObjectManager.initialize();
        BzGetAgInfoMockForSinkeiyaku.SYORIPTN = BzGetAgInfoMockForSinkeiyaku.TESTPATTERN4;
        KeisanGaikakanzanMockForSinkeiyaku.SYORIPTN = KeisanGaikakanzanMockForSinkeiyaku.TESTPATTERN1;
        GetKiteiCheckYenkansangkMockForSinkeiyaku.SYORIPTN = GetKiteiCheckYenkansangkMockForSinkeiyaku.TESTPATTERN1;
        CheckSaiteiPMockForSinkeiyaku.SYORIPTN = CheckSaiteiPMockForSinkeiyaku.TESTPATTERN1;

        HanteiMoschkMockForSinkeiyaku.SYORIPTN = HanteiMoschkMockForSinkeiyaku.TESTPATTERN1;
        EditNenkinKoumokuUtilMockForSinkeiyaku.SYORIPTN = EditNenkinKoumokuUtilMockForSinkeiyaku.TESTPATTERN1;
        CheckTblMosSyouhin checkTblMosSyouhin = SWAKInjector.getInstance(CheckTblMosSyouhin.class);

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("860001015");
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

        exNumericEquals(hubiMsgLst.size(), 2, "不備メッセージテーブルエンティティリストのサイズ");

        exStringEquals(hubiMsgLst.get(1).getMosno(), "860001015", "申込番号");
        exNumericEquals(hubiMsgLst.get(1).getRenno(), 2, "連番");
        exStringEquals(hubiMsgLst.get(1).getMessageId(), "EBC0014", "メッセージＩＤ");
        exStringEquals(hubiMsgLst.get(1).getHubimsg(), "外貨建て一時払終身保険（毎年受取型）　１５年毎利率再設定は付加できません。", "不備メッセージ");
        exClassificationEquals(hubiMsgLst.get(1).getHubisyubetukbn(), C_HubisyubetuKbn.KETHORYU_HUBI, "不備種別区分");
        exStringEquals(hubiMsgLst.get(1).getGyoumuKousinsyaId(), "JUnitTest", "業務用更新者ＩＤ");
        exStringEquals(hubiMsgLst.get(1).getGyoumuKousinTime(), "20160509141230000", "業務用更新時間");
    }
    @Test
    @TestOrder(9040)
    @Transactional
    public void testExec_I4() {
        MockObjectManager.initialize();
        BzGetAgInfoMockForSinkeiyaku.SYORIPTN = BzGetAgInfoMockForSinkeiyaku.TESTPATTERN4;
        KeisanGaikakanzanMockForSinkeiyaku.SYORIPTN = KeisanGaikakanzanMockForSinkeiyaku.TESTPATTERN1;
        GetKiteiCheckYenkansangkMockForSinkeiyaku.SYORIPTN = GetKiteiCheckYenkansangkMockForSinkeiyaku.TESTPATTERN1;
        CheckSaiteiPMockForSinkeiyaku.SYORIPTN = CheckSaiteiPMockForSinkeiyaku.TESTPATTERN1;

        HanteiMoschkMockForSinkeiyaku.SYORIPTN = HanteiMoschkMockForSinkeiyaku.TESTPATTERN1;
        EditNenkinKoumokuUtilMockForSinkeiyaku.SYORIPTN = EditNenkinKoumokuUtilMockForSinkeiyaku.TESTPATTERN1;
        CheckTblMosSyouhin checkTblMosSyouhin = SWAKInjector.getInstance(CheckTblMosSyouhin.class);

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("860001031");
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
        mosnaiCheckParam.setKiteiCheckChannelCd(C_Channelcd.TIGIN);

        checkTblMosSyouhin.exec(mosnaiCheckParam);

        List<HT_HubiMsg> hubiMsgLst = mosnaiCheckParam.getListHubiMsg();

        exNumericEquals(hubiMsgLst.size(), 1, "不備メッセージテーブルエンティティリストのサイズ");
        exStringEquals(hubiMsgLst.get(0).getMosno(), "860001031", "申込番号");
        exNumericEquals(hubiMsgLst.get(0).getRenno(), 1, "連番");
        exStringEquals(hubiMsgLst.get(0).getMessageId(), "EBC0046", "メッセージＩＤ");
        exStringEquals(hubiMsgLst.get(0).getHubimsg(), "据置期間が正しくありません。", "不備メッセージ");
        exClassificationEquals(hubiMsgLst.get(0).getHubisyubetukbn(), C_HubisyubetuKbn.KETHORYU_HUBI, "不備種別区分");
        exClassificationEquals(hubiMsgLst.get(0).getHubisyubetusyousaikbn(), C_HubisyubetusyousaiKbn.NONE,
            "不備種別詳細区分");
    }
    @Test
    @TestOrder(9050)
    @Transactional
    public void testExec_I5() {
        MockObjectManager.initialize();
        BzGetAgInfoMockForSinkeiyaku.SYORIPTN = BzGetAgInfoMockForSinkeiyaku.TESTPATTERN4;
        KeisanGaikakanzanMockForSinkeiyaku.SYORIPTN = KeisanGaikakanzanMockForSinkeiyaku.TESTPATTERN1;
        GetKiteiCheckYenkansangkMockForSinkeiyaku.SYORIPTN = GetKiteiCheckYenkansangkMockForSinkeiyaku.TESTPATTERN1;
        CheckSaiteiPMockForSinkeiyaku.SYORIPTN = CheckSaiteiPMockForSinkeiyaku.TESTPATTERN1;

        HanteiMoschkMockForSinkeiyaku.SYORIPTN = HanteiMoschkMockForSinkeiyaku.TESTPATTERN1;
        EditNenkinKoumokuUtilMockForSinkeiyaku.SYORIPTN = EditNenkinKoumokuUtilMockForSinkeiyaku.TESTPATTERN1;
        CheckTblMosSyouhin checkTblMosSyouhin = SWAKInjector.getInstance(CheckTblMosSyouhin.class);

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("860001049");
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

        exNumericEquals(hubiMsgLst.size(), 3, "不備メッセージテーブルエンティティリストのサイズ");

        exStringEquals(hubiMsgLst.get(1).getMosno(), "860001049", "申込番号");
        exNumericEquals(hubiMsgLst.get(1).getRenno(), 2, "連番");
        exStringEquals(hubiMsgLst.get(1).getMessageId(), "EHC0035", "メッセージＩＤ");
        exStringEquals(hubiMsgLst.get(1).getHubimsg(), "外貨建て一時払終身保険（即時保障型）　１０年毎利率再設定は主契約の払込期間未満でないと付加できません。", "不備メッセージ");
        exClassificationEquals(hubiMsgLst.get(1).getHubisyubetukbn(), C_HubisyubetuKbn.KETHORYU_HUBI, "不備種別区分");
        exStringEquals(hubiMsgLst.get(1).getGyoumuKousinsyaId(), "JUnitTest", "業務用更新者ＩＤ");
        exStringEquals(hubiMsgLst.get(1).getGyoumuKousinTime(), "20160509141230000", "業務用更新時間");

        exNumericEquals(hubiMsgLst.get(2).getRenno(), 3, "連番");
        exStringEquals(hubiMsgLst.get(2).getMessageId(), "EHC0038", "メッセージＩＤ");
        exStringEquals(hubiMsgLst.get(2).getHubimsg(), "外貨建て一時払終身保険（即時保障型）　１０年毎利率再設定の保険期間が取扱範囲外です。", "不備メッセージ");
        exClassificationEquals(hubiMsgLst.get(2).getHubisyubetukbn(), C_HubisyubetuKbn.KETHORYU_HUBI, "不備種別区分");
    }
    @Test
    @TestOrder(9060)
    @Transactional
    public void testExec_I6() {
        MockObjectManager.initialize();
        BzGetAgInfoMockForSinkeiyaku.SYORIPTN = BzGetAgInfoMockForSinkeiyaku.TESTPATTERN4;
        KeisanGaikakanzanMockForSinkeiyaku.SYORIPTN = KeisanGaikakanzanMockForSinkeiyaku.TESTPATTERN1;
        GetKiteiCheckYenkansangkMockForSinkeiyaku.SYORIPTN = GetKiteiCheckYenkansangkMockForSinkeiyaku.TESTPATTERN1;
        CheckSaiteiPMockForSinkeiyaku.SYORIPTN = CheckSaiteiPMockForSinkeiyaku.TESTPATTERN1;

        HanteiMoschkMockForSinkeiyaku.SYORIPTN = HanteiMoschkMockForSinkeiyaku.TESTPATTERN1;
        EditNenkinKoumokuUtilMockForSinkeiyaku.SYORIPTN = EditNenkinKoumokuUtilMockForSinkeiyaku.TESTPATTERN1;
        CheckTblMosSyouhin checkTblMosSyouhin = SWAKInjector.getInstance(CheckTblMosSyouhin.class);

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("860001056");
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

        exNumericEquals(hubiMsgLst.size(), 3, "不備メッセージテーブルエンティティリストのサイズ");

        exStringEquals(hubiMsgLst.get(1).getMosno(), "860001056", "申込番号");
        exNumericEquals(hubiMsgLst.get(1).getRenno(), 2, "連番");
        exStringEquals(hubiMsgLst.get(1).getMessageId(), "EHC0035", "メッセージＩＤ");
        exStringEquals(hubiMsgLst.get(1).getHubimsg(), "外貨建て一時払終身保険（即時保障型）　１０年毎利率再設定は主契約の払込期間未満でないと付加できません。", "不備メッセージ");
        exClassificationEquals(hubiMsgLst.get(1).getHubisyubetukbn(), C_HubisyubetuKbn.KETHORYU_HUBI, "不備種別区分");
        exStringEquals(hubiMsgLst.get(1).getGyoumuKousinsyaId(), "JUnitTest", "業務用更新者ＩＤ");
        exStringEquals(hubiMsgLst.get(1).getGyoumuKousinTime(), "20160509141230000", "業務用更新時間");

        exNumericEquals(hubiMsgLst.get(2).getRenno(), 3, "連番");
        exStringEquals(hubiMsgLst.get(2).getMessageId(), "EHC0038", "メッセージＩＤ");
        exStringEquals(hubiMsgLst.get(2).getHubimsg(), "外貨建て一時払終身保険（即時保障型）　１０年毎利率再設定の保険期間が取扱範囲外です。", "不備メッセージ");
        exClassificationEquals(hubiMsgLst.get(2).getHubisyubetukbn(), C_HubisyubetuKbn.KETHORYU_HUBI, "不備種別区分");
    }
    @Test
    @TestOrder(9070)
    @Transactional
    public void testExec_I7() {
        MockObjectManager.initialize();
        BzGetAgInfoMockForSinkeiyaku.SYORIPTN = BzGetAgInfoMockForSinkeiyaku.TESTPATTERN4;
        KeisanGaikakanzanMockForSinkeiyaku.SYORIPTN = KeisanGaikakanzanMockForSinkeiyaku.TESTPATTERN1;
        GetKiteiCheckYenkansangkMockForSinkeiyaku.SYORIPTN = GetKiteiCheckYenkansangkMockForSinkeiyaku.TESTPATTERN1;
        CheckSaiteiPMockForSinkeiyaku.SYORIPTN = CheckSaiteiPMockForSinkeiyaku.TESTPATTERN1;

        HanteiMoschkMockForSinkeiyaku.SYORIPTN = HanteiMoschkMockForSinkeiyaku.TESTPATTERN1;
        EditNenkinKoumokuUtilMockForSinkeiyaku.SYORIPTN = EditNenkinKoumokuUtilMockForSinkeiyaku.TESTPATTERN1;
        CheckTblMosSyouhin checkTblMosSyouhin = SWAKInjector.getInstance(CheckTblMosSyouhin.class);

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("860001064");
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
        mosnaiCheckParam.setKiteiCheckChannelCd(C_Channelcd.TIGIN);

        checkTblMosSyouhin.exec(mosnaiCheckParam);

        List<HT_HubiMsg> hubiMsgLst = mosnaiCheckParam.getListHubiMsg();

        exNumericEquals(hubiMsgLst.size(), 1, "不備メッセージテーブルエンティティリストのサイズ");
        exStringEquals(hubiMsgLst.get(0).getMosno(), "860001064", "申込番号");
        exNumericEquals(hubiMsgLst.get(0).getRenno(), 1, "連番");
        exStringEquals(hubiMsgLst.get(0).getMessageId(), "EBC0046", "メッセージＩＤ");
        exStringEquals(hubiMsgLst.get(0).getHubimsg(), "据置期間が正しくありません。", "不備メッセージ");
        exClassificationEquals(hubiMsgLst.get(0).getHubisyubetukbn(), C_HubisyubetuKbn.KETHORYU_HUBI, "不備種別区分");
        exClassificationEquals(hubiMsgLst.get(0).getHubisyubetusyousaikbn(), C_HubisyubetusyousaiKbn.NONE,
            "不備種別詳細区分");
    }
    @Test
    @TestOrder(9080)
    @Transactional
    public void testExec_I8() {
        MockObjectManager.initialize();
        BzGetAgInfoMockForSinkeiyaku.SYORIPTN = BzGetAgInfoMockForSinkeiyaku.TESTPATTERN4;
        KeisanGaikakanzanMockForSinkeiyaku.SYORIPTN = KeisanGaikakanzanMockForSinkeiyaku.TESTPATTERN1;
        GetKiteiCheckYenkansangkMockForSinkeiyaku.SYORIPTN = GetKiteiCheckYenkansangkMockForSinkeiyaku.TESTPATTERN1;
        CheckSaiteiPMockForSinkeiyaku.SYORIPTN = CheckSaiteiPMockForSinkeiyaku.TESTPATTERN1;
        CheckTblMosSyouhin checkTblMosSyouhin = SWAKInjector.getInstance(CheckTblMosSyouhin.class);

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("860001072");
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

        exNumericEquals(hubiMsgLst.size(), 2, "不備メッセージテーブルエンティティリストのサイズ");

        exStringEquals(hubiMsgLst.get(1).getMosno(), "860001072", "申込番号");
        exNumericEquals(hubiMsgLst.get(1).getRenno(), 2, "連番");
        exStringEquals(hubiMsgLst.get(1).getMessageId(), "EHC0036", "メッセージＩＤ");
        exStringEquals(hubiMsgLst.get(1).getHubimsg(), "外貨建て一時払変額年金保険（ブレンド型）　年金原資最低保証１２０％は本人型しか付加できません。", "不備メッセージ");
        exClassificationEquals(hubiMsgLst.get(1).getHubisyubetukbn(), C_HubisyubetuKbn.KETHORYU_HUBI, "不備種別区分");
        exStringEquals(hubiMsgLst.get(1).getGyoumuKousinsyaId(), "JUnitTest", "業務用更新者ＩＤ");
        exStringEquals(hubiMsgLst.get(1).getGyoumuKousinTime(), "20160509141230000", "業務用更新時間");
    }
    @Test
    @TestOrder(9090)
    @Transactional
    public void testExec_I9() {
        MockObjectManager.initialize();
        BzGetAgInfoMockForSinkeiyaku.SYORIPTN = BzGetAgInfoMockForSinkeiyaku.TESTPATTERN4;
        KeisanGaikakanzanMockForSinkeiyaku.SYORIPTN = KeisanGaikakanzanMockForSinkeiyaku.TESTPATTERN1;
        GetKiteiCheckYenkansangkMockForSinkeiyaku.SYORIPTN = GetKiteiCheckYenkansangkMockForSinkeiyaku.TESTPATTERN1;
        CheckSaiteiPMockForSinkeiyaku.SYORIPTN = CheckSaiteiPMockForSinkeiyaku.TESTPATTERN1;
        CheckTblMosSyouhin checkTblMosSyouhin = SWAKInjector.getInstance(CheckTblMosSyouhin.class);

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("860001080");
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
        mosnaiCheckParam.setKiteiCheckChannelCd(C_Channelcd.TIGIN);

        checkTblMosSyouhin.exec(mosnaiCheckParam);

        List<HT_HubiMsg> hubiMsgLst = mosnaiCheckParam.getListHubiMsg();

        exNumericEquals(hubiMsgLst.size(), 1, "不備メッセージテーブルエンティティリストのサイズ");
        exStringEquals(hubiMsgLst.get(0).getMosno(), "860001080", "申込番号");
        exNumericEquals(hubiMsgLst.get(0).getRenno(), 1, "連番");
        exStringEquals(hubiMsgLst.get(0).getMessageId(), "EBC0046", "メッセージＩＤ");
        exStringEquals(hubiMsgLst.get(0).getHubimsg(), "据置期間が正しくありません。", "不備メッセージ");
        exClassificationEquals(hubiMsgLst.get(0).getHubisyubetukbn(), C_HubisyubetuKbn.KETHORYU_HUBI, "不備種別区分");
        exClassificationEquals(hubiMsgLst.get(0).getHubisyubetusyousaikbn(), C_HubisyubetusyousaiKbn.NONE,
            "不備種別詳細区分");
    }
    @Test
    @TestOrder(9100)
    @Transactional
    public void testExec_I10() {
        MockObjectManager.initialize();
        BzGetAgInfoMockForSinkeiyaku.SYORIPTN = BzGetAgInfoMockForSinkeiyaku.TESTPATTERN4;
        KeisanGaikakanzanMockForSinkeiyaku.SYORIPTN = KeisanGaikakanzanMockForSinkeiyaku.TESTPATTERN1;
        GetKiteiCheckYenkansangkMockForSinkeiyaku.SYORIPTN = GetKiteiCheckYenkansangkMockForSinkeiyaku.TESTPATTERN1;
        CheckSaiteiPMockForSinkeiyaku.SYORIPTN = CheckSaiteiPMockForSinkeiyaku.TESTPATTERN1;
        CheckTblMosSyouhin checkTblMosSyouhin = SWAKInjector.getInstance(CheckTblMosSyouhin.class);

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("860001098");
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
        mosnaiCheckParam.setKiteiCheckChannelCd(C_Channelcd.TIGIN);

        checkTblMosSyouhin.exec(mosnaiCheckParam);

        List<HT_HubiMsg> hubiMsgLst = mosnaiCheckParam.getListHubiMsg();

        exNumericEquals(hubiMsgLst.size(), 1, "不備メッセージテーブルエンティティリストのサイズ");
        exStringEquals(hubiMsgLst.get(0).getMosno(), "860001098", "申込番号");
        exNumericEquals(hubiMsgLst.get(0).getRenno(), 1, "連番");
        exStringEquals(hubiMsgLst.get(0).getMessageId(), "EBC0046", "メッセージＩＤ");
        exStringEquals(hubiMsgLst.get(0).getHubimsg(), "据置期間が正しくありません。", "不備メッセージ");
        exClassificationEquals(hubiMsgLst.get(0).getHubisyubetukbn(), C_HubisyubetuKbn.KETHORYU_HUBI, "不備種別区分");
        exClassificationEquals(hubiMsgLst.get(0).getHubisyubetusyousaikbn(), C_HubisyubetusyousaiKbn.NONE,
            "不備種別詳細区分");
    }
    @Test
    @TestOrder(9110)
    @Transactional
    public void testExec_I11() {
        MockObjectManager.initialize();
        BzGetAgInfoMockForSinkeiyaku.SYORIPTN = BzGetAgInfoMockForSinkeiyaku.TESTPATTERN4;
        KeisanGaikakanzanMockForSinkeiyaku.SYORIPTN = KeisanGaikakanzanMockForSinkeiyaku.TESTPATTERN1;
        GetKiteiCheckYenkansangkMockForSinkeiyaku.SYORIPTN = GetKiteiCheckYenkansangkMockForSinkeiyaku.TESTPATTERN1;
        CheckSaiteiPMockForSinkeiyaku.SYORIPTN = CheckSaiteiPMockForSinkeiyaku.TESTPATTERN1;
        CheckTblMosSyouhin checkTblMosSyouhin = SWAKInjector.getInstance(CheckTblMosSyouhin.class);

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("860001106");
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

        exNumericEquals(hubiMsgLst.size(), 2, "不備メッセージテーブルエンティティリストのサイズ");

        exStringEquals(hubiMsgLst.get(1).getMosno(), "860001106", "申込番号");
        exNumericEquals(hubiMsgLst.get(1).getRenno(), 2, "連番");
        exStringEquals(hubiMsgLst.get(1).getMessageId(), "EHC0029", "メッセージＩＤ");
        exStringEquals(hubiMsgLst.get(1).getHubimsg(), "外貨建て一時払終身保険（毎年受取型）　１０年毎利率再設定は子型を含む型は加できません。", "不備メッセージ");
        exClassificationEquals(hubiMsgLst.get(1).getHubisyubetukbn(), C_HubisyubetuKbn.KETHORYU_HUBI, "不備種別区分");
        exStringEquals(hubiMsgLst.get(1).getGyoumuKousinsyaId(), "JUnitTest", "業務用更新者ＩＤ");
        exStringEquals(hubiMsgLst.get(1).getGyoumuKousinTime(), "20160509141230000", "業務用更新時間");
    }
    @Test
    @TestOrder(9120)
    @Transactional
    public void testExec_I12() {
        MockObjectManager.initialize();
        BzGetAgInfoMockForSinkeiyaku.SYORIPTN = BzGetAgInfoMockForSinkeiyaku.TESTPATTERN4;
        KeisanGaikakanzanMockForSinkeiyaku.SYORIPTN = KeisanGaikakanzanMockForSinkeiyaku.TESTPATTERN1;
        GetKiteiCheckYenkansangkMockForSinkeiyaku.SYORIPTN = GetKiteiCheckYenkansangkMockForSinkeiyaku.TESTPATTERN1;
        CheckSaiteiPMockForSinkeiyaku.SYORIPTN = CheckSaiteiPMockForSinkeiyaku.TESTPATTERN1;
        CheckTblMosSyouhin checkTblMosSyouhin = SWAKInjector.getInstance(CheckTblMosSyouhin.class);

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("860001114");
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

        exNumericEquals(hubiMsgLst.size(), 2, "不備メッセージテーブルエンティティリストのサイズ");

        exStringEquals(hubiMsgLst.get(1).getMosno(), "860001114", "申込番号");
        exNumericEquals(hubiMsgLst.get(1).getRenno(), 2, "連番");
        exStringEquals(hubiMsgLst.get(1).getMessageId(), "EHC0077", "メッセージＩＤ");
        exStringEquals(hubiMsgLst.get(1).getHubimsg(), "外貨建て一時払変額年金保険（ブレンド型）　年金原資最低保証１００％の歳満期は付加できません。", "不備メッセージ");
        exClassificationEquals(hubiMsgLst.get(1).getHubisyubetukbn(), C_HubisyubetuKbn.KETHORYU_HUBI, "不備種別区分");
        exStringEquals(hubiMsgLst.get(1).getGyoumuKousinsyaId(), "JUnitTest", "業務用更新者ＩＤ");
        exStringEquals(hubiMsgLst.get(1).getGyoumuKousinTime(), "20160509141230000", "業務用更新時間");
    }
    @Test
    @TestOrder(9130)
    @Transactional
    public void testExec_I13() {
        MockObjectManager.initialize();
        BzGetAgInfoMockForSinkeiyaku.SYORIPTN = BzGetAgInfoMockForSinkeiyaku.TESTPATTERN4;
        KeisanGaikakanzanMockForSinkeiyaku.SYORIPTN = KeisanGaikakanzanMockForSinkeiyaku.TESTPATTERN1;
        GetKiteiCheckYenkansangkMockForSinkeiyaku.SYORIPTN = GetKiteiCheckYenkansangkMockForSinkeiyaku.TESTPATTERN1;
        CheckSaiteiPMockForSinkeiyaku.SYORIPTN = CheckSaiteiPMockForSinkeiyaku.TESTPATTERN1;
        CheckTblMosSyouhin checkTblMosSyouhin = SWAKInjector.getInstance(CheckTblMosSyouhin.class);

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("860001122");
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
        mosnaiCheckParam.setKiteiCheckChannelCd(C_Channelcd.TIGIN);

        checkTblMosSyouhin.exec(mosnaiCheckParam);

        List<HT_HubiMsg> hubiMsgLst = mosnaiCheckParam.getListHubiMsg();

        exNumericEquals(hubiMsgLst.size(), 1, "不備メッセージテーブルエンティティリストのサイズ");
        exStringEquals(hubiMsgLst.get(0).getMosno(), "860001122", "申込番号");
        exNumericEquals(hubiMsgLst.get(0).getRenno(), 1, "連番");
        exStringEquals(hubiMsgLst.get(0).getMessageId(), "EBC0046", "メッセージＩＤ");
        exStringEquals(hubiMsgLst.get(0).getHubimsg(), "据置期間が正しくありません。", "不備メッセージ");
        exClassificationEquals(hubiMsgLst.get(0).getHubisyubetukbn(), C_HubisyubetuKbn.KETHORYU_HUBI, "不備種別区分");
        exClassificationEquals(hubiMsgLst.get(0).getHubisyubetusyousaikbn(), C_HubisyubetusyousaiKbn.NONE,
            "不備種別詳細区分");
    }
    @Test
    @TestOrder(9140)
    @Transactional
    public void testExec_I14() {
        MockObjectManager.initialize();
        BzGetAgInfoMockForSinkeiyaku.SYORIPTN = BzGetAgInfoMockForSinkeiyaku.TESTPATTERN4;
        KeisanGaikakanzanMockForSinkeiyaku.SYORIPTN = KeisanGaikakanzanMockForSinkeiyaku.TESTPATTERN1;
        GetKiteiCheckYenkansangkMockForSinkeiyaku.SYORIPTN = GetKiteiCheckYenkansangkMockForSinkeiyaku.TESTPATTERN1;
        CheckSaiteiPMockForSinkeiyaku.SYORIPTN = CheckSaiteiPMockForSinkeiyaku.TESTPATTERN1;
        CheckTblMosSyouhin checkTblMosSyouhin = SWAKInjector.getInstance(CheckTblMosSyouhin.class);

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("860001130");
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
        mosnaiCheckParam.setKiteiCheckChannelCd(C_Channelcd.TIGIN);

        checkTblMosSyouhin.exec(mosnaiCheckParam);

        List<HT_HubiMsg> hubiMsgLst = mosnaiCheckParam.getListHubiMsg();

        exNumericEquals(hubiMsgLst.size(), 1, "不備メッセージテーブルエンティティリストのサイズ");
        exStringEquals(hubiMsgLst.get(0).getMosno(), "860001130", "申込番号");
        exNumericEquals(hubiMsgLst.get(0).getRenno(), 1, "連番");
        exStringEquals(hubiMsgLst.get(0).getMessageId(), "EBC0046", "メッセージＩＤ");
        exStringEquals(hubiMsgLst.get(0).getHubimsg(), "据置期間が正しくありません。", "不備メッセージ");
        exClassificationEquals(hubiMsgLst.get(0).getHubisyubetukbn(), C_HubisyubetuKbn.KETHORYU_HUBI, "不備種別区分");
        exClassificationEquals(hubiMsgLst.get(0).getHubisyubetusyousaikbn(), C_HubisyubetusyousaiKbn.NONE,
            "不備種別詳細区分");
    }
    @Test(expected = CommonBizAppException.class)
    @TestOrder(9140)
    @Transactional
    public void testExec_I15() {
        MockObjectManager.initialize();
        BzGetAgInfoMockForSinkeiyaku.SYORIPTN = BzGetAgInfoMockForSinkeiyaku.TESTPATTERN4;
        KeisanGaikakanzanMockForSinkeiyaku.SYORIPTN = KeisanGaikakanzanMockForSinkeiyaku.TESTPATTERN1;
        GetKiteiCheckYenkansangkMockForSinkeiyaku.SYORIPTN = GetKiteiCheckYenkansangkMockForSinkeiyaku.TESTPATTERN1;
        CheckSaiteiPMockForSinkeiyaku.SYORIPTN = CheckSaiteiPMockForSinkeiyaku.TESTPATTERN1;
        CheckTblMosSyouhin checkTblMosSyouhin = SWAKInjector.getInstance(CheckTblMosSyouhin.class);

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("860001148");
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
        mosnaiCheckParam.setKiteiCheckChannelCd(C_Channelcd.TIGIN);

        try {
            checkTblMosSyouhin.exec(mosnaiCheckParam);
        } catch (CommonBizAppException e) {
            exStringEquals(e.getMessage(), "システム整合性エラーです。", "エラーメッセージ");
            throw e;
        }
    }
    @Test
    @TestOrder(10010)
    @Transactional
    public void testExec_J1() {
        MockObjectManager.initialize();
        BzGetAgInfoMockForSinkeiyaku.SYORIPTN = BzGetAgInfoMockForSinkeiyaku.TESTPATTERN4;
        KeisanGaikakanzanMockForSinkeiyaku.SYORIPTN = KeisanGaikakanzanMockForSinkeiyaku.TESTPATTERN1;
        GetKiteiCheckYenkansangkMockForSinkeiyaku.SYORIPTN = GetKiteiCheckYenkansangkMockForSinkeiyaku.TESTPATTERN1;
        CheckSaiteiPMockForSinkeiyaku.SYORIPTN = CheckSaiteiPMockForSinkeiyaku.TESTPATTERN1;
        CheckTblMosSyouhin checkTblMosSyouhin = SWAKInjector.getInstance(CheckTblMosSyouhin.class);

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("860001155");
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

        exNumericEquals(hubiMsgLst.size(), 1, "不備メッセージテーブルエンティティリストのサイズ");
        exStringEquals(hubiMsgLst.get(0).getMosno(), "860001155", "申込番号");
        exNumericEquals(hubiMsgLst.get(0).getRenno(), 1, "連番");
        exStringEquals(hubiMsgLst.get(0).getMessageId(), "EBC0046", "メッセージＩＤ");
        exStringEquals(hubiMsgLst.get(0).getHubimsg(), "据置期間が正しくありません。", "不備メッセージ");
        exClassificationEquals(hubiMsgLst.get(0).getHubisyubetukbn(), C_HubisyubetuKbn.KETHORYU_HUBI, "不備種別区分");
        exClassificationEquals(hubiMsgLst.get(0).getHubisyubetusyousaikbn(), C_HubisyubetusyousaiKbn.NONE,
            "不備種別詳細区分");
    }
    @Test
    @TestOrder(10020)
    @Transactional
    public void testExec_J2() {
        MockObjectManager.initialize();
        BzGetAgInfoMockForSinkeiyaku.SYORIPTN = BzGetAgInfoMockForSinkeiyaku.TESTPATTERN4;
        KeisanGaikakanzanMockForSinkeiyaku.SYORIPTN = KeisanGaikakanzanMockForSinkeiyaku.TESTPATTERN1;
        GetKiteiCheckYenkansangkMockForSinkeiyaku.SYORIPTN = GetKiteiCheckYenkansangkMockForSinkeiyaku.TESTPATTERN1;
        CheckSaiteiPMockForSinkeiyaku.SYORIPTN = CheckSaiteiPMockForSinkeiyaku.TESTPATTERN1;
        CheckTblMosSyouhin checkTblMosSyouhin = SWAKInjector.getInstance(CheckTblMosSyouhin.class);

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("860001163");
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

        exNumericEquals(hubiMsgLst.size(), 2, "不備メッセージテーブルエンティティリストのサイズ");

        exStringEquals(hubiMsgLst.get(1).getMosno(), "860001163", "申込番号");
        exNumericEquals(hubiMsgLst.get(1).getRenno(), 2, "連番");
        exStringEquals(hubiMsgLst.get(1).getMessageId(), "EHC0141", "メッセージＩＤ");
        exStringEquals(hubiMsgLst.get(1).getHubimsg(), "外貨建て一時払終身保険（毎年受取型）　１０年毎利率再設定は付加可能額１０，０００，０００．００ユーロと相違しています。", "不備メッセージ");
        exClassificationEquals(hubiMsgLst.get(1).getHubisyubetukbn(), C_HubisyubetuKbn.KETHORYU_HUBI, "不備種別区分");
        exStringEquals(hubiMsgLst.get(1).getGyoumuKousinsyaId(), "JUnitTest", "業務用更新者ＩＤ");
        exStringEquals(hubiMsgLst.get(1).getGyoumuKousinTime(), "20160509141230000", "業務用更新時間");
    }
    @Test
    @TestOrder(10030)
    @Transactional
    public void testExec_J3() {
        MockObjectManager.initialize();
        BzGetAgInfoMockForSinkeiyaku.SYORIPTN = BzGetAgInfoMockForSinkeiyaku.TESTPATTERN4;
        KeisanGaikakanzanMockForSinkeiyaku.SYORIPTN = KeisanGaikakanzanMockForSinkeiyaku.TESTPATTERN1;
        GetKiteiCheckYenkansangkMockForSinkeiyaku.SYORIPTN = GetKiteiCheckYenkansangkMockForSinkeiyaku.TESTPATTERN1;
        CheckSaiteiPMockForSinkeiyaku.SYORIPTN = CheckSaiteiPMockForSinkeiyaku.TESTPATTERN1;
        CheckTblMosSyouhin checkTblMosSyouhin = SWAKInjector.getInstance(CheckTblMosSyouhin.class);

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("860001171");
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

        exNumericEquals(hubiMsgLst.size(), 2, "不備メッセージテーブルエンティティリストのサイズ");

        exStringEquals(hubiMsgLst.get(1).getMosno(), "860001171", "申込番号");
        exNumericEquals(hubiMsgLst.get(1).getRenno(), 2, "連番");
        exStringEquals(hubiMsgLst.get(1).getMessageId(), "EHC0037", "メッセージＩＤ");
        exStringEquals(hubiMsgLst.get(1).getHubimsg(), "外貨建て一時払変額年金保険（ブレンド型）　年金原資最低保証１００％は付加限度額５，５００，０００．００ユーロをオーバーしています。", "不備メッセージ");
        exClassificationEquals(hubiMsgLst.get(1).getHubisyubetukbn(), C_HubisyubetuKbn.KETHORYU_HUBI, "不備種別区分");
        exStringEquals(hubiMsgLst.get(1).getGyoumuKousinsyaId(), "JUnitTest", "業務用更新者ＩＤ");
        exStringEquals(hubiMsgLst.get(1).getGyoumuKousinTime(), "20160509141230000", "業務用更新時間");
    }
    @Test
    @TestOrder(10040)
    @Transactional
    public void testExec_J4() {
        MockObjectManager.initialize();
        BzGetAgInfoMockForSinkeiyaku.SYORIPTN = BzGetAgInfoMockForSinkeiyaku.TESTPATTERN4;
        KeisanGaikakanzanMockForSinkeiyaku.SYORIPTN = KeisanGaikakanzanMockForSinkeiyaku.TESTPATTERN1;
        GetKiteiCheckYenkansangkMockForSinkeiyaku.SYORIPTN = GetKiteiCheckYenkansangkMockForSinkeiyaku.TESTPATTERN1;
        CheckSaiteiPMockForSinkeiyaku.SYORIPTN = CheckSaiteiPMockForSinkeiyaku.TESTPATTERN1;
        CheckTblMosSyouhin checkTblMosSyouhin = SWAKInjector.getInstance(CheckTblMosSyouhin.class);

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("860001189");
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

        exNumericEquals(hubiMsgLst.size(), 1, "不備メッセージテーブルエンティティリストのサイズ");
        exStringEquals(hubiMsgLst.get(0).getMosno(), "860001189", "申込番号");
        exNumericEquals(hubiMsgLst.get(0).getRenno(), 1, "連番");
        exStringEquals(hubiMsgLst.get(0).getMessageId(), "EBC0046", "メッセージＩＤ");
        exStringEquals(hubiMsgLst.get(0).getHubimsg(), "据置期間が正しくありません。", "不備メッセージ");
        exClassificationEquals(hubiMsgLst.get(0).getHubisyubetukbn(), C_HubisyubetuKbn.KETHORYU_HUBI, "不備種別区分");
        exClassificationEquals(hubiMsgLst.get(0).getHubisyubetusyousaikbn(), C_HubisyubetusyousaiKbn.NONE,
            "不備種別詳細区分");
    }
    @Test
    @TestOrder(10050)
    @Transactional
    public void testExec_J5() {
        MockObjectManager.initialize();
        BzGetAgInfoMockForSinkeiyaku.SYORIPTN = BzGetAgInfoMockForSinkeiyaku.TESTPATTERN4;
        KeisanGaikakanzanMockForSinkeiyaku.SYORIPTN = KeisanGaikakanzanMockForSinkeiyaku.TESTPATTERN1;
        GetKiteiCheckYenkansangkMockForSinkeiyaku.SYORIPTN = GetKiteiCheckYenkansangkMockForSinkeiyaku.TESTPATTERN1;
        CheckSaiteiPMockForSinkeiyaku.SYORIPTN = CheckSaiteiPMockForSinkeiyaku.TESTPATTERN1;
        CheckTblMosSyouhin checkTblMosSyouhin = SWAKInjector.getInstance(CheckTblMosSyouhin.class);

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("860001197");
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

        exNumericEquals(hubiMsgLst.size(), 3, "不備メッセージテーブルエンティティリストのサイズ");

        exStringEquals(hubiMsgLst.get(1).getMosno(), "860001197", "申込番号");
        exNumericEquals(hubiMsgLst.get(1).getRenno(), 2, "連番");
        exStringEquals(hubiMsgLst.get(1).getMessageId(), "EHC0141", "メッセージＩＤ");
        exStringEquals(hubiMsgLst.get(1).getHubimsg(), "外貨建て一時払終身保険（毎年受取型）　１０年毎利率再設定は付加可能額２，５００，０００．００ユーロと相違しています。", "不備メッセージ");
        exClassificationEquals(hubiMsgLst.get(1).getHubisyubetukbn(), C_HubisyubetuKbn.KETHORYU_HUBI, "不備種別区分");
        exStringEquals(hubiMsgLst.get(1).getGyoumuKousinsyaId(), "JUnitTest", "業務用更新者ＩＤ");
        exStringEquals(hubiMsgLst.get(1).getGyoumuKousinTime(), "20160509141230000", "業務用更新時間");

        exNumericEquals(hubiMsgLst.get(2).getRenno(), 3, "連番");
        exStringEquals(hubiMsgLst.get(2).getMessageId(), "EHC0038", "メッセージＩＤ");
        exStringEquals(hubiMsgLst.get(2).getHubimsg(), "外貨建て一時払終身保険（毎年受取型）　１０年毎利率再設定の保険期間が取扱範囲外です。", "不備メッセージ");
        exClassificationEquals(hubiMsgLst.get(2).getHubisyubetukbn(), C_HubisyubetuKbn.KETHORYU_HUBI, "不備種別区分");
    }
    @Test
    @TestOrder(10060)
    @Transactional
    public void testExec_J6() {
        MockObjectManager.initialize();
        BzGetAgInfoMockForSinkeiyaku.SYORIPTN = BzGetAgInfoMockForSinkeiyaku.TESTPATTERN4;
        KeisanGaikakanzanMockForSinkeiyaku.SYORIPTN = KeisanGaikakanzanMockForSinkeiyaku.TESTPATTERN1;
        GetKiteiCheckYenkansangkMockForSinkeiyaku.SYORIPTN = GetKiteiCheckYenkansangkMockForSinkeiyaku.TESTPATTERN1;
        CheckSaiteiPMockForSinkeiyaku.SYORIPTN = CheckSaiteiPMockForSinkeiyaku.TESTPATTERN1;
        CheckTblMosSyouhin checkTblMosSyouhin = SWAKInjector.getInstance(CheckTblMosSyouhin.class);

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("860001205");
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

        exNumericEquals(hubiMsgLst.size(), 3, "不備メッセージテーブルエンティティリストのサイズ");

        exStringEquals(hubiMsgLst.get(1).getMosno(), "860001205", "申込番号");
        exNumericEquals(hubiMsgLst.get(1).getRenno(), 2, "連番");
        exStringEquals(hubiMsgLst.get(1).getMessageId(), "EHC0037", "メッセージＩＤ");
        exStringEquals(hubiMsgLst.get(1).getHubimsg(), "外貨建て一時払終身保険（毎年受取型）　１５年毎利率再設定は付加限度額１０，０００，０００．００ユーロをオーバーしています。", "不備メッセージ");
        exClassificationEquals(hubiMsgLst.get(1).getHubisyubetukbn(), C_HubisyubetuKbn.KETHORYU_HUBI, "不備種別区分");
        exStringEquals(hubiMsgLst.get(1).getGyoumuKousinsyaId(), "JUnitTest", "業務用更新者ＩＤ");
        exStringEquals(hubiMsgLst.get(1).getGyoumuKousinTime(), "20160509141230000", "業務用更新時間");

        exNumericEquals(hubiMsgLst.get(2).getRenno(), 3, "連番");
        exStringEquals(hubiMsgLst.get(2).getMessageId(), "EHC0038", "メッセージＩＤ");
        exStringEquals(hubiMsgLst.get(2).getHubimsg(), "外貨建て一時払終身保険（毎年受取型）　１５年毎利率再設定の保険期間が取扱範囲外です。", "不備メッセージ");
        exClassificationEquals(hubiMsgLst.get(2).getHubisyubetukbn(), C_HubisyubetuKbn.KETHORYU_HUBI, "不備種別区分");
    }
    @Test(expected = CommonBizAppException.class)
    @TestOrder(10070)
    @Transactional
    public void testExec_J7() {
        MockObjectManager.initialize();
        BzGetAgInfoMockForSinkeiyaku.SYORIPTN = BzGetAgInfoMockForSinkeiyaku.TESTPATTERN4;
        KeisanGaikakanzanMockForSinkeiyaku.SYORIPTN = KeisanGaikakanzanMockForSinkeiyaku.TESTPATTERN1;
        GetKiteiCheckYenkansangkMockForSinkeiyaku.SYORIPTN = GetKiteiCheckYenkansangkMockForSinkeiyaku.TESTPATTERN1;
        CheckSaiteiPMockForSinkeiyaku.SYORIPTN = CheckSaiteiPMockForSinkeiyaku.TESTPATTERN1;
        CheckTblMosSyouhin checkTblMosSyouhin = SWAKInjector.getInstance(CheckTblMosSyouhin.class);

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("860001023");
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
        mosnaiCheckParam.setKiteiCheckChannelCd(C_Channelcd.TIGIN);

        try {
            checkTblMosSyouhin.exec(mosnaiCheckParam);
        } catch (CommonBizAppException e) {
            exStringEquals(e.getMessage(), "システム整合性エラーです。特約倍率チェック：予期していない演算子が登録されています。:#", "エラーメッセージ");
            throw e;
        }
    }
    @Test
    @TestOrder(11010)
    @Transactional
    public void testExec_K1() {
        MockObjectManager.initialize();
        BzGetAgInfoMockForSinkeiyaku.SYORIPTN = BzGetAgInfoMockForSinkeiyaku.TESTPATTERN4;
        KeisanGaikakanzanMockForSinkeiyaku.SYORIPTN = KeisanGaikakanzanMockForSinkeiyaku.TESTPATTERN1;
        GetKiteiCheckYenkansangkMockForSinkeiyaku.SYORIPTN = GetKiteiCheckYenkansangkMockForSinkeiyaku.TESTPATTERN1;
        CheckSaiteiPMockForSinkeiyaku.SYORIPTN = CheckSaiteiPMockForSinkeiyaku.TESTPATTERN1;
        CheckTblMosSyouhin checkTblMosSyouhin = SWAKInjector.getInstance(CheckTblMosSyouhin.class);

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("860001213");
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

        exNumericEquals(hubiMsgLst.size(), 2, "不備メッセージテーブルエンティティリストのサイズ");

        exStringEquals(hubiMsgLst.get(1).getMosno(), "860001213", "申込番号");
        exNumericEquals(hubiMsgLst.get(1).getRenno(), 2, "連番");
        exStringEquals(hubiMsgLst.get(1).getMessageId(), "THC0162", "メッセージＩＤ");
        exStringEquals(hubiMsgLst.get(1).getHubimsg(), "【特認可能】外貨建て一時払終身保険（即時保障型）　１０年毎利率再設定は付加できません。（特約付加制限）", "不備メッセージ");
        exClassificationEquals(hubiMsgLst.get(1).getHubisyubetukbn(), C_HubisyubetuKbn.KETHORYU_HUBI, "不備種別区分");
        exStringEquals(hubiMsgLst.get(1).getGyoumuKousinsyaId(), "JUnitTest", "業務用更新者ＩＤ");
        exStringEquals(hubiMsgLst.get(1).getGyoumuKousinTime(), "20160509141230000", "業務用更新時間");
    }
    @Test
    @TestOrder(11020)
    @Transactional
    public void testExec_K2() {
        MockObjectManager.initialize();
        BzGetAgInfoMockForSinkeiyaku.SYORIPTN = BzGetAgInfoMockForSinkeiyaku.TESTPATTERN4;
        KeisanGaikakanzanMockForSinkeiyaku.SYORIPTN = KeisanGaikakanzanMockForSinkeiyaku.TESTPATTERN1;
        GetKiteiCheckYenkansangkMockForSinkeiyaku.SYORIPTN = GetKiteiCheckYenkansangkMockForSinkeiyaku.TESTPATTERN1;
        CheckSaiteiPMockForSinkeiyaku.SYORIPTN = CheckSaiteiPMockForSinkeiyaku.TESTPATTERN1;
        CheckTblMosSyouhin checkTblMosSyouhin = SWAKInjector.getInstance(CheckTblMosSyouhin.class);

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("860001221");
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

        exNumericEquals(hubiMsgLst.size(), 2, "不備メッセージテーブルエンティティリストのサイズ");

        exStringEquals(hubiMsgLst.get(1).getMosno(), "860001221", "申込番号");
        exNumericEquals(hubiMsgLst.get(1).getRenno(), 2, "連番");
        exStringEquals(hubiMsgLst.get(1).getMessageId(), "KHC0162", "メッセージＩＤ");
        exStringEquals(hubiMsgLst.get(1).getHubimsg(), "（特認済）外貨建て一時払終身保険（即時保障型）　１０年毎利率再設定は付加できません。（特約付加制限）", "不備メッセージ");
        exClassificationEquals(hubiMsgLst.get(1).getHubisyubetukbn(), C_HubisyubetuKbn.KETHORYU_HUBI, "不備種別区分");
        exStringEquals(hubiMsgLst.get(1).getGyoumuKousinsyaId(), "JUnitTest", "業務用更新者ＩＤ");
        exStringEquals(hubiMsgLst.get(1).getGyoumuKousinTime(), "20160509141230000", "業務用更新時間");
    }
    @Test
    @TestOrder(11030)
    @Transactional
    public void testExec_K3() {
        MockObjectManager.initialize();
        BzGetAgInfoMockForSinkeiyaku.SYORIPTN = BzGetAgInfoMockForSinkeiyaku.TESTPATTERN4;
        KeisanGaikakanzanMockForSinkeiyaku.SYORIPTN = KeisanGaikakanzanMockForSinkeiyaku.TESTPATTERN1;
        GetKiteiCheckYenkansangkMockForSinkeiyaku.SYORIPTN = GetKiteiCheckYenkansangkMockForSinkeiyaku.TESTPATTERN1;
        CheckSaiteiPMockForSinkeiyaku.SYORIPTN = CheckSaiteiPMockForSinkeiyaku.TESTPATTERN1;
        CheckTblMosSyouhin checkTblMosSyouhin = SWAKInjector.getInstance(CheckTblMosSyouhin.class);

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("860001239");
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

        exClassificationEquals(mosnaiCheckParam.getKokutiChkKekkaKbn(), C_KktatkichkkekkaKbn.TKHKSGERR, "告知扱チェック結果区分");
        exClassificationEquals(mosnaiCheckParam.getSekmossakuseiErroutKbn(), C_SekmossakuseiErroutKbn.GAMEN, "設計書申込書作成エラー出力区分");
        exStringEquals(mosnaiCheckParam.getSekmossakuseiErrmsg1(), "告知書での取扱上限を超えているため、健康診断書の提出をご案内ください。（特約年齢", "設計書申込書作成エラーメッセージ１");
        exStringEquals(mosnaiCheckParam.getSekmossakuseiErrmsg2(), "制限オーバー　外貨建て一時払終身保険（即時保障型）　１０年毎利率再設定）", "設計書申込書作成エラーメッセージ２");
        exClassificationEquals(mosnaiCheckParam.getKouzokuSyoriJikkouKbn(), C_KouzokujkKbn.NONE, "後続処理実行区分");
    }
    @Test
    @TestOrder(11040)
    @Transactional
    public void testExec_K4() {
        MockObjectManager.initialize();
        BzGetAgInfoMockForSinkeiyaku.SYORIPTN = BzGetAgInfoMockForSinkeiyaku.TESTPATTERN4;
        KeisanGaikakanzanMockForSinkeiyaku.SYORIPTN = KeisanGaikakanzanMockForSinkeiyaku.TESTPATTERN1;
        GetKiteiCheckYenkansangkMockForSinkeiyaku.SYORIPTN = GetKiteiCheckYenkansangkMockForSinkeiyaku.TESTPATTERN1;
        CheckSaiteiPMockForSinkeiyaku.SYORIPTN = CheckSaiteiPMockForSinkeiyaku.TESTPATTERN1;
        CheckTblMosSyouhin checkTblMosSyouhin = SWAKInjector.getInstance(CheckTblMosSyouhin.class);

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("860001247");
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
        mosnaiCheckParam.setSysKbn(C_SysKbn.ESHIEN);
        mosnaiCheckParam.setKokutiChkHuyoUmu(C_UmuKbn.ARI);
        mosnaiCheckParam.setSysDate(BizDate.valueOf(20160102));

        checkTblMosSyouhin.exec(mosnaiCheckParam);

        exClassificationEquals(mosnaiCheckParam.getKokutiChkKekkaKbn(), C_KktatkichkkekkaKbn.NONE, "告知扱チェック結果区分");
        exClassificationEquals(mosnaiCheckParam.getKouzokuSyoriJikkouKbn(), C_KouzokujkKbn.NONE, "後続処理実行区分");
    }
    @Test
    @TestOrder(11050)
    @Transactional
    public void testExec_K5() {
        MockObjectManager.initialize();
        BzGetAgInfoMockForSinkeiyaku.SYORIPTN = BzGetAgInfoMockForSinkeiyaku.TESTPATTERN4;
        KeisanGaikakanzanMockForSinkeiyaku.SYORIPTN = KeisanGaikakanzanMockForSinkeiyaku.TESTPATTERN1;
        GetKiteiCheckYenkansangkMockForSinkeiyaku.SYORIPTN = GetKiteiCheckYenkansangkMockForSinkeiyaku.TESTPATTERN1;
        CheckSaiteiPMockForSinkeiyaku.SYORIPTN = CheckSaiteiPMockForSinkeiyaku.TESTPATTERN1;
        CheckTblMosSyouhin checkTblMosSyouhin = SWAKInjector.getInstance(CheckTblMosSyouhin.class);

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("860001254");
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
        mosnaiCheckParam.setSysKbn(C_SysKbn.ESHIEN);
        mosnaiCheckParam.setKokutiChkHuyoUmu(C_UmuKbn.NONE);
        mosnaiCheckParam.setSysDate(BizDate.valueOf(20160102));

        checkTblMosSyouhin.exec(mosnaiCheckParam);

        exClassificationEquals(mosnaiCheckParam.getKokutiChkKekkaKbn(), C_KktatkichkkekkaKbn.NONE, "告知扱チェック結果区分");
        exClassificationEquals(mosnaiCheckParam.getKouzokuSyoriJikkouKbn(), C_KouzokujkKbn.NONE, "後続処理実行区分");
    }
    @Test
    @TestOrder(13010)
    @Transactional
    public void testExec_M1() {
        MockObjectManager.initialize();
        BzGetAgInfoMockForSinkeiyaku.SYORIPTN = BzGetAgInfoMockForSinkeiyaku.TESTPATTERN4;
        KeisanGaikakanzanMockForSinkeiyaku.SYORIPTN = KeisanGaikakanzanMockForSinkeiyaku.TESTPATTERN1;
        GetKiteiCheckYenkansangkMockForSinkeiyaku.SYORIPTN = GetKiteiCheckYenkansangkMockForSinkeiyaku.TESTPATTERN1;
        CheckSaiteiPMockForSinkeiyaku.SYORIPTN = CheckSaiteiPMockForSinkeiyaku.TESTPATTERN1;
        CheckTblMosSyouhin checkTblMosSyouhin = SWAKInjector.getInstance(CheckTblMosSyouhin.class);

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("860001262");
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
        mosnaiCheckParam.setSysKbn(C_SysKbn.ESHIEN);
        mosnaiCheckParam.setKokutiChkHuyoUmu(C_UmuKbn.NONE);
        mosnaiCheckParam.setSysDate(BizDate.valueOf(20160102));
        mosnaiCheckParam.setKiteiCheckChannelCd(C_Channelcd.TIGIN);

        checkTblMosSyouhin.exec(mosnaiCheckParam);

        exClassificationEquals(mosnaiCheckParam.getSekmossakuseiErroutKbn(), C_SekmossakuseiErroutKbn.GAMEN, "設計書申込書作成エラー出力区分");
        exStringEquals(mosnaiCheckParam.getSekmossakuseiErrmsg1(), "外貨建て一時払終身保険（即時保障型）　１０年毎利率再設定の契約可能期間・年齢・性", "設計書申込書作成エラーメッセージ１");
        exStringEquals(mosnaiCheckParam.getSekmossakuseiErrmsg2(), "別の取扱範囲外です。", "設計書申込書作成エラーメッセージ２");
        exClassificationEquals(mosnaiCheckParam.getKouzokuSyoriJikkouKbn(), C_KouzokujkKbn.NONE, "後続処理実行区分");
    }
    @Test
    @TestOrder(13020)
    @Transactional
    public void testExec_M2() {
        MockObjectManager.initialize();
        BzGetAgInfoMockForSinkeiyaku.SYORIPTN = BzGetAgInfoMockForSinkeiyaku.TESTPATTERN4;
        KeisanGaikakanzanMockForSinkeiyaku.SYORIPTN = KeisanGaikakanzanMockForSinkeiyaku.TESTPATTERN1;
        GetKiteiCheckYenkansangkMockForSinkeiyaku.SYORIPTN = GetKiteiCheckYenkansangkMockForSinkeiyaku.TESTPATTERN1;
        CheckSaiteiPMockForSinkeiyaku.SYORIPTN = CheckSaiteiPMockForSinkeiyaku.TESTPATTERN1;
        CheckTblMosSyouhin checkTblMosSyouhin = SWAKInjector.getInstance(CheckTblMosSyouhin.class);

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("860001270");
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
        mosnaiCheckParam.setSysKbn(C_SysKbn.ESHIEN);
        mosnaiCheckParam.setKokutiChkHuyoUmu(C_UmuKbn.NONE);
        mosnaiCheckParam.setSysDate(BizDate.valueOf(20160102));
        mosnaiCheckParam.setKiteiCheckChannelCd(C_Channelcd.TIGIN);

        checkTblMosSyouhin.exec(mosnaiCheckParam);

        exClassificationEquals(mosnaiCheckParam.getKouzokuSyoriJikkouKbn(), C_KouzokujkKbn.NONE, "後続処理実行区分");
    }
    @Test
    @TestOrder(13030)
    @Transactional
    public void testExec_M3() {
        MockObjectManager.initialize();
        BzGetAgInfoMockForSinkeiyaku.SYORIPTN = BzGetAgInfoMockForSinkeiyaku.TESTPATTERN4;
        KeisanGaikakanzanMockForSinkeiyaku.SYORIPTN = KeisanGaikakanzanMockForSinkeiyaku.TESTPATTERN1;
        GetKiteiCheckYenkansangkMockForSinkeiyaku.SYORIPTN = GetKiteiCheckYenkansangkMockForSinkeiyaku.TESTPATTERN1;
        CheckSaiteiPMockForSinkeiyaku.SYORIPTN = CheckSaiteiPMockForSinkeiyaku.TESTPATTERN1;
        CheckTblMosSyouhin checkTblMosSyouhin = SWAKInjector.getInstance(CheckTblMosSyouhin.class);

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("860001288");
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

        exNumericEquals(hubiMsgLst.size(), 2, "不備メッセージテーブルエンティティリストのサイズ");

        exStringEquals(hubiMsgLst.get(1).getMosno(), "860001288", "申込番号");
        exNumericEquals(hubiMsgLst.get(1).getRenno(), 2, "連番");
        exStringEquals(hubiMsgLst.get(1).getMessageId(), "THC0028", "メッセージＩＤ");
        exStringEquals(hubiMsgLst.get(1).getHubimsg(), "【特認可能】外貨建て一時払終身保険（即時保障型）　１０年毎利率再設定の契約可能期間・年齢範囲外です。", "不備メッセージ");
        exClassificationEquals(hubiMsgLst.get(1).getHubisyubetukbn(), C_HubisyubetuKbn.KETHORYU_HUBI, "不備種別区分");
        exStringEquals(hubiMsgLst.get(1).getGyoumuKousinsyaId(), "JUnitTest", "業務用更新者ＩＤ");
        exStringEquals(hubiMsgLst.get(1).getGyoumuKousinTime(), "20160509141230000", "業務用更新時間");
    }
    @Test
    @TestOrder(13040)
    @Transactional
    public void testExec_M4() {
        MockObjectManager.initialize();
        BzGetAgInfoMockForSinkeiyaku.SYORIPTN = BzGetAgInfoMockForSinkeiyaku.TESTPATTERN4;
        KeisanGaikakanzanMockForSinkeiyaku.SYORIPTN = KeisanGaikakanzanMockForSinkeiyaku.TESTPATTERN1;
        GetKiteiCheckYenkansangkMockForSinkeiyaku.SYORIPTN = GetKiteiCheckYenkansangkMockForSinkeiyaku.TESTPATTERN1;
        CheckSaiteiPMockForSinkeiyaku.SYORIPTN = CheckSaiteiPMockForSinkeiyaku.TESTPATTERN1;
        CheckTblMosSyouhin checkTblMosSyouhin = SWAKInjector.getInstance(CheckTblMosSyouhin.class);

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("860001296");
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
        mosnaiCheckParam.setKiteiCheckChannelCd(C_Channelcd.TIGIN);

        checkTblMosSyouhin.exec(mosnaiCheckParam);

        List<HT_HubiMsg> hubiMsgLst = mosnaiCheckParam.getListHubiMsg();

        exNumericEquals(hubiMsgLst.size(), 1, "不備メッセージテーブルエンティティリストのサイズ");
        exStringEquals(hubiMsgLst.get(0).getMosno(), "860001296", "申込番号");
        exNumericEquals(hubiMsgLst.get(0).getRenno(), 1, "連番");
        exStringEquals(hubiMsgLst.get(0).getMessageId(), "EBC0046", "メッセージＩＤ");
        exStringEquals(hubiMsgLst.get(0).getHubimsg(), "据置期間が正しくありません。", "不備メッセージ");
        exClassificationEquals(hubiMsgLst.get(0).getHubisyubetukbn(), C_HubisyubetuKbn.KETHORYU_HUBI, "不備種別区分");
        exClassificationEquals(hubiMsgLst.get(0).getHubisyubetusyousaikbn(), C_HubisyubetusyousaiKbn.NONE,
            "不備種別詳細区分");
    }
    @Test
    @TestOrder(13050)
    @Transactional
    public void testExec_M5() {
        MockObjectManager.initialize();
        BzGetAgInfoMockForSinkeiyaku.SYORIPTN = BzGetAgInfoMockForSinkeiyaku.TESTPATTERN4;
        KeisanGaikakanzanMockForSinkeiyaku.SYORIPTN = KeisanGaikakanzanMockForSinkeiyaku.TESTPATTERN1;
        GetKiteiCheckYenkansangkMockForSinkeiyaku.SYORIPTN = GetKiteiCheckYenkansangkMockForSinkeiyaku.TESTPATTERN1;
        CheckSaiteiPMockForSinkeiyaku.SYORIPTN = CheckSaiteiPMockForSinkeiyaku.TESTPATTERN1;
        CheckTblMosSyouhin checkTblMosSyouhin = SWAKInjector.getInstance(CheckTblMosSyouhin.class);

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("860001304");
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

        exNumericEquals(hubiMsgLst.size(), 2, "不備メッセージテーブルエンティティリストのサイズ");

        exStringEquals(hubiMsgLst.get(1).getMosno(), "860001304", "申込番号");
        exNumericEquals(hubiMsgLst.get(1).getRenno(), 2, "連番");
        exStringEquals(hubiMsgLst.get(1).getMessageId(), "EHC0028", "メッセージＩＤ");
        exStringEquals(hubiMsgLst.get(1).getHubimsg(), "外貨建て一時払終身保険（即時保障型）　１０年毎利率再設定の契約可能期間・年齢範囲外です。", "不備メッセージ");
        exClassificationEquals(hubiMsgLst.get(1).getHubisyubetukbn(), C_HubisyubetuKbn.KETHORYU_HUBI, "不備種別区分");
        exStringEquals(hubiMsgLst.get(1).getGyoumuKousinsyaId(), "JUnitTest", "業務用更新者ＩＤ");
        exStringEquals(hubiMsgLst.get(1).getGyoumuKousinTime(), "20160509141230000", "業務用更新時間");
    }
    @Test
    @TestOrder(13060)
    @Transactional
    public void testExec_M6() {
        MockObjectManager.initialize();
        BzGetAgInfoMockForSinkeiyaku.SYORIPTN = BzGetAgInfoMockForSinkeiyaku.TESTPATTERN4;
        KeisanGaikakanzanMockForSinkeiyaku.SYORIPTN = KeisanGaikakanzanMockForSinkeiyaku.TESTPATTERN1;
        GetKiteiCheckYenkansangkMockForSinkeiyaku.SYORIPTN = GetKiteiCheckYenkansangkMockForSinkeiyaku.TESTPATTERN1;
        CheckSaiteiPMockForSinkeiyaku.SYORIPTN = CheckSaiteiPMockForSinkeiyaku.TESTPATTERN1;
        CheckTblMosSyouhin checkTblMosSyouhin = SWAKInjector.getInstance(CheckTblMosSyouhin.class);

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("860001312");
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
        mosnaiCheckParam.setKiteiCheckChannelCd(C_Channelcd.TIGIN);

        checkTblMosSyouhin.exec(mosnaiCheckParam);

        List<HT_HubiMsg> hubiMsgLst = mosnaiCheckParam.getListHubiMsg();

        exNumericEquals(hubiMsgLst.size(), 1, "不備メッセージテーブルエンティティリストのサイズ");
        exStringEquals(hubiMsgLst.get(0).getMosno(), "860001312", "申込番号");
        exNumericEquals(hubiMsgLst.get(0).getRenno(), 1, "連番");
        exStringEquals(hubiMsgLst.get(0).getMessageId(), "EBC0046", "メッセージＩＤ");
        exStringEquals(hubiMsgLst.get(0).getHubimsg(), "据置期間が正しくありません。", "不備メッセージ");
        exClassificationEquals(hubiMsgLst.get(0).getHubisyubetukbn(), C_HubisyubetuKbn.KETHORYU_HUBI, "不備種別区分");
        exClassificationEquals(hubiMsgLst.get(0).getHubisyubetusyousaikbn(), C_HubisyubetusyousaiKbn.NONE,
            "不備種別詳細区分");
    }
    @Test
    @TestOrder(14010)
    @Transactional
    public void testExec_N1() {
        MockObjectManager.initialize();
        BzGetAgInfoMockForSinkeiyaku.SYORIPTN = BzGetAgInfoMockForSinkeiyaku.TESTPATTERN4;
        KeisanGaikakanzanMockForSinkeiyaku.SYORIPTN = KeisanGaikakanzanMockForSinkeiyaku.TESTPATTERN1;
        GetKiteiCheckYenkansangkMockForSinkeiyaku.SYORIPTN = GetKiteiCheckYenkansangkMockForSinkeiyaku.TESTPATTERN1;
        CheckSaiteiPMockForSinkeiyaku.SYORIPTN = CheckSaiteiPMockForSinkeiyaku.TESTPATTERN1;
        CheckTblMosSyouhin checkTblMosSyouhin = SWAKInjector.getInstance(CheckTblMosSyouhin.class);

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("860001320");
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

        exNumericEquals(hubiMsgLst.size(), 3, "不備メッセージテーブルエンティティリストのサイズ");

        exStringEquals(hubiMsgLst.get(1).getMosno(), "860001320", "申込番号");
        exNumericEquals(hubiMsgLst.get(1).getRenno(), 2, "連番");
        exStringEquals(hubiMsgLst.get(1).getMessageId(), "EHC0019", "メッセージＩＤ");
        exStringEquals(hubiMsgLst.get(1).getHubimsg(), "外貨建て一時払終身保険（即時保障型）　１５年毎利率再設定の本人・妻型は取扱えません。", "不備メッセージ");
        exClassificationEquals(hubiMsgLst.get(1).getHubisyubetukbn(), C_HubisyubetuKbn.KETHORYU_HUBI, "不備種別区分");
        exStringEquals(hubiMsgLst.get(1).getGyoumuKousinsyaId(), "JUnitTest", "業務用更新者ＩＤ");
        exStringEquals(hubiMsgLst.get(1).getGyoumuKousinTime(), "20160509141230000", "業務用更新時間");

        exNumericEquals(hubiMsgLst.get(2).getRenno(), 3, "連番");
        exStringEquals(hubiMsgLst.get(2).getMessageId(), "EHC0019", "メッセージＩＤ");
        exStringEquals(hubiMsgLst.get(2).getHubimsg(), "外貨建て一時払終身保険（即時保障型）　１５年毎利率再設定の１８０日型は取扱えません。", "不備メッセージ");
        exClassificationEquals(hubiMsgLst.get(2).getHubisyubetukbn(), C_HubisyubetuKbn.KETHORYU_HUBI, "不備種別区分");
    }
    @Test
    @TestOrder(14020)
    @Transactional
    public void testExec_N2() {
        MockObjectManager.initialize();
        BzGetAgInfoMockForSinkeiyaku.SYORIPTN = BzGetAgInfoMockForSinkeiyaku.TESTPATTERN4;
        KeisanGaikakanzanMockForSinkeiyaku.SYORIPTN = KeisanGaikakanzanMockForSinkeiyaku.TESTPATTERN1;
        GetKiteiCheckYenkansangkMockForSinkeiyaku.SYORIPTN = GetKiteiCheckYenkansangkMockForSinkeiyaku.TESTPATTERN1;
        CheckSaiteiPMockForSinkeiyaku.SYORIPTN = CheckSaiteiPMockForSinkeiyaku.TESTPATTERN1;
        CheckTblMosSyouhin checkTblMosSyouhin = SWAKInjector.getInstance(CheckTblMosSyouhin.class);

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("860001338");
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

        exNumericEquals(hubiMsgLst.size(), 1, "不備メッセージテーブルエンティティリストのサイズ");
        exStringEquals(hubiMsgLst.get(0).getMosno(), "860001338", "申込番号");
        exNumericEquals(hubiMsgLst.get(0).getRenno(), 1, "連番");
        exStringEquals(hubiMsgLst.get(0).getMessageId(), "EBC0046", "メッセージＩＤ");
        exStringEquals(hubiMsgLst.get(0).getHubimsg(), "据置期間が正しくありません。", "不備メッセージ");
        exClassificationEquals(hubiMsgLst.get(0).getHubisyubetukbn(), C_HubisyubetuKbn.KETHORYU_HUBI, "不備種別区分");
        exClassificationEquals(hubiMsgLst.get(0).getHubisyubetusyousaikbn(), C_HubisyubetusyousaiKbn.NONE,
            "不備種別詳細区分");
    }
    @Test
    @TestOrder(14030)
    @Transactional
    public void testExec_N3() {
        MockObjectManager.initialize();
        BzGetAgInfoMockForSinkeiyaku.SYORIPTN = BzGetAgInfoMockForSinkeiyaku.TESTPATTERN4;
        KeisanGaikakanzanMockForSinkeiyaku.SYORIPTN = KeisanGaikakanzanMockForSinkeiyaku.TESTPATTERN1;
        GetKiteiCheckYenkansangkMockForSinkeiyaku.SYORIPTN = GetKiteiCheckYenkansangkMockForSinkeiyaku.TESTPATTERN1;
        CheckSaiteiPMockForSinkeiyaku.SYORIPTN = CheckSaiteiPMockForSinkeiyaku.TESTPATTERN1;
        CheckTblMosSyouhin checkTblMosSyouhin = SWAKInjector.getInstance(CheckTblMosSyouhin.class);

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("860001346");
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

        exNumericEquals(hubiMsgLst.size(), 2, "不備メッセージテーブルエンティティリストのサイズ");

        exStringEquals(hubiMsgLst.get(1).getMosno(), "860001346", "申込番号");
        exNumericEquals(hubiMsgLst.get(1).getRenno(), 2, "連番");
        exStringEquals(hubiMsgLst.get(1).getMessageId(), "EHC0130", "メッセージＩＤ");
        exStringEquals(hubiMsgLst.get(1).getHubimsg(), "外貨建て一時払終身保険（毎年受取型）　１５年毎利率再設定の給付型の入力は不要です。", "不備メッセージ");
        exClassificationEquals(hubiMsgLst.get(1).getHubisyubetukbn(), C_HubisyubetuKbn.KETHORYU_HUBI, "不備種別区分");
        exStringEquals(hubiMsgLst.get(1).getGyoumuKousinsyaId(), "JUnitTest", "業務用更新者ＩＤ");
        exStringEquals(hubiMsgLst.get(1).getGyoumuKousinTime(), "20160509141230000", "業務用更新時間");
    }
    @Test
    @TestOrder(14040)
    @Transactional
    public void testExec_N4() {
        MockObjectManager.initialize();
        BzGetAgInfoMockForSinkeiyaku.SYORIPTN = BzGetAgInfoMockForSinkeiyaku.TESTPATTERN4;
        KeisanGaikakanzanMockForSinkeiyaku.SYORIPTN = KeisanGaikakanzanMockForSinkeiyaku.TESTPATTERN1;
        GetKiteiCheckYenkansangkMockForSinkeiyaku.SYORIPTN = GetKiteiCheckYenkansangkMockForSinkeiyaku.TESTPATTERN1;
        CheckSaiteiPMockForSinkeiyaku.SYORIPTN = CheckSaiteiPMockForSinkeiyaku.TESTPATTERN1;
        CheckTblMosSyouhin checkTblMosSyouhin = SWAKInjector.getInstance(CheckTblMosSyouhin.class);

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("860001353");
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

        exNumericEquals(hubiMsgLst.size(), 1, "不備メッセージテーブルエンティティリストのサイズ");
        exStringEquals(hubiMsgLst.get(0).getMosno(), "860001353", "申込番号");
        exNumericEquals(hubiMsgLst.get(0).getRenno(), 1, "連番");
        exStringEquals(hubiMsgLst.get(0).getMessageId(), "EBC0046", "メッセージＩＤ");
        exStringEquals(hubiMsgLst.get(0).getHubimsg(), "据置期間が正しくありません。", "不備メッセージ");
        exClassificationEquals(hubiMsgLst.get(0).getHubisyubetukbn(), C_HubisyubetuKbn.KETHORYU_HUBI, "不備種別区分");
        exClassificationEquals(hubiMsgLst.get(0).getHubisyubetusyousaikbn(), C_HubisyubetusyousaiKbn.NONE,
            "不備種別詳細区分");
    }
    @Test(expected = CommonBizAppException.class)
    @TestOrder(15010)
    @Transactional
    public void testExec_O1() {
        MockObjectManager.initialize();
        BzGetAgInfoMockForSinkeiyaku.SYORIPTN = BzGetAgInfoMockForSinkeiyaku.TESTPATTERN4;
        KeisanGaikakanzanMockForSinkeiyaku.SYORIPTN = KeisanGaikakanzanMockForSinkeiyaku.TESTPATTERN1;
        GetKiteiCheckYenkansangkMockForSinkeiyaku.SYORIPTN = GetKiteiCheckYenkansangkMockForSinkeiyaku.TESTPATTERN1;
        CheckSaiteiPMockForSinkeiyaku.SYORIPTN = CheckSaiteiPMockForSinkeiyaku.TESTPATTERN1;
        CheckTblMosSyouhin checkTblMosSyouhin = SWAKInjector.getInstance(CheckTblMosSyouhin.class);

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("860001361");
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

        try {
            checkTblMosSyouhin.exec(mosnaiCheckParam);
        } catch (CommonBizAppException e) {
            exStringEquals(e.getMessage(), "システム整合性エラーです。最低Ｐテーブルにデータが見つかりません。", "エラーメッセージ");
            throw e;
        }
    }
    @Test(expected = CommonBizAppException.class)
    @TestOrder(15020)
    @Transactional
    public void testExec_O2() {
        MockObjectManager.initialize();
        BzGetAgInfoMockForSinkeiyaku.SYORIPTN = BzGetAgInfoMockForSinkeiyaku.TESTPATTERN4;
        KeisanGaikakanzanMockForSinkeiyaku.SYORIPTN = KeisanGaikakanzanMockForSinkeiyaku.TESTPATTERN1;
        GetKiteiCheckYenkansangkMockForSinkeiyaku.SYORIPTN = GetKiteiCheckYenkansangkMockForSinkeiyaku.TESTPATTERN1;
        CheckSaiteiPMockForSinkeiyaku.SYORIPTN = CheckSaiteiPMockForSinkeiyaku.TESTPATTERN1;
        CheckTblMosSyouhin checkTblMosSyouhin = SWAKInjector.getInstance(CheckTblMosSyouhin.class);

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("860001379");
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

        try {
            checkTblMosSyouhin.exec(mosnaiCheckParam);
        } catch (CommonBizAppException e) {
            exStringEquals(e.getMessage(), "システム整合性エラーです。最高ＳＳ単位テーブルにデータが見つかりません。", "エラーメッセージ");
            throw e;
        }
    }
    @Test(expected = CommonBizAppException.class)
    @TestOrder(15030)
    @Transactional
    public void testExec_O3() {
        MockObjectManager.initialize();
        BzGetAgInfoMockForSinkeiyaku.SYORIPTN = BzGetAgInfoMockForSinkeiyaku.TESTPATTERN4;
        KeisanGaikakanzanMockForSinkeiyaku.SYORIPTN = KeisanGaikakanzanMockForSinkeiyaku.TESTPATTERN1;
        GetKiteiCheckYenkansangkMockForSinkeiyaku.SYORIPTN = GetKiteiCheckYenkansangkMockForSinkeiyaku.TESTPATTERN1;
        CheckSaiteiPMockForSinkeiyaku.SYORIPTN = CheckSaiteiPMockForSinkeiyaku.TESTPATTERN1;
        CheckTblMosSyouhin checkTblMosSyouhin = SWAKInjector.getInstance(CheckTblMosSyouhin.class);

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("860001387");
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

        try {
            checkTblMosSyouhin.exec(mosnaiCheckParam);
        } catch (CommonBizAppException e) {
            exStringEquals(e.getMessage(), "システム整合性エラーです。最高ＳＳ単位テーブルにデータが見つかりません。", "エラーメッセージ");
            throw e;
        }
    }
    @Test(expected = CommonBizAppException.class)
    @TestOrder(15040)
    @Transactional
    public void testExec_O4() {
        MockObjectManager.initialize();
        BzGetAgInfoMockForSinkeiyaku.SYORIPTN = BzGetAgInfoMockForSinkeiyaku.TESTPATTERN4;
        KeisanGaikakanzanMockForSinkeiyaku.SYORIPTN = KeisanGaikakanzanMockForSinkeiyaku.TESTPATTERN1;
        GetKiteiCheckYenkansangkMockForSinkeiyaku.SYORIPTN = GetKiteiCheckYenkansangkMockForSinkeiyaku.TESTPATTERN1;
        CheckSaiteiPMockForSinkeiyaku.SYORIPTN = CheckSaiteiPMockForSinkeiyaku.TESTPATTERN1;
        CheckTblMosSyouhin checkTblMosSyouhin = SWAKInjector.getInstance(CheckTblMosSyouhin.class);

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("860001395");
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

        try {
            checkTblMosSyouhin.exec(mosnaiCheckParam);
        } catch (CommonBizAppException e) {
            exStringEquals(e.getMessage(), "システム整合性エラーです。最低Ｓテーブルにデータが見つかりません。", "エラーメッセージ");
            throw e;
        }
    }
    @Test
    @TestOrder(15050)
    @Transactional
    public void testExec_O5() {
        MockObjectManager.initialize();
        BzGetAgInfoMockForSinkeiyaku.SYORIPTN = BzGetAgInfoMockForSinkeiyaku.TESTPATTERN4;
        KeisanGaikakanzanMockForSinkeiyaku.SYORIPTN = KeisanGaikakanzanMockForSinkeiyaku.TESTPATTERN1;
        GetKiteiCheckYenkansangkMockForSinkeiyaku.SYORIPTN = GetKiteiCheckYenkansangkMockForSinkeiyaku.TESTPATTERN1;
        CheckSaiteiPMockForSinkeiyaku.SYORIPTN = CheckSaiteiPMockForSinkeiyaku.TESTPATTERN1;
        CheckTblMosSyouhin checkTblMosSyouhin = SWAKInjector.getInstance(CheckTblMosSyouhin.class);

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("860001403");
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

        checkTblMosSyouhin.exec(mosnaiCheckParam);

        List<HT_HubiMsg> hubiMsgLst = mosnaiCheckParam.getListHubiMsg();

        exNumericEquals(hubiMsgLst.size(), 1, "不備メッセージテーブルエンティティリストのサイズ");
        exStringEquals(hubiMsgLst.get(0).getMosno(), "860001403", "申込番号");
        exNumericEquals(hubiMsgLst.get(0).getRenno(), 1, "連番");
        exStringEquals(hubiMsgLst.get(0).getMessageId(), "EBC0046", "メッセージＩＤ");
        exStringEquals(hubiMsgLst.get(0).getHubimsg(), "据置期間が正しくありません。", "不備メッセージ");
        exClassificationEquals(hubiMsgLst.get(0).getHubisyubetukbn(), C_HubisyubetuKbn.KETHORYU_HUBI, "不備種別区分");
        exClassificationEquals(hubiMsgLst.get(0).getHubisyubetusyousaikbn(), C_HubisyubetusyousaiKbn.NONE,
            "不備種別詳細区分");
    }
    @Test(expected = CommonBizAppException.class)
    @TestOrder(15060)
    @Transactional
    public void testExec_O6() {
        MockObjectManager.initialize();
        BzGetAgInfoMockForSinkeiyaku.SYORIPTN = BzGetAgInfoMockForSinkeiyaku.TESTPATTERN4;
        KeisanGaikakanzanMockForSinkeiyaku.SYORIPTN = KeisanGaikakanzanMockForSinkeiyaku.TESTPATTERN1;
        GetKiteiCheckYenkansangkMockForSinkeiyaku.SYORIPTN = GetKiteiCheckYenkansangkMockForSinkeiyaku.TESTPATTERN1;
        CheckSaiteiPMockForSinkeiyaku.SYORIPTN = CheckSaiteiPMockForSinkeiyaku.TESTPATTERN1;
        CheckTblMosSyouhin checkTblMosSyouhin = SWAKInjector.getInstance(CheckTblMosSyouhin.class);

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("860001411");
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

        try {
            checkTblMosSyouhin.exec(mosnaiCheckParam);
        } catch (CommonBizAppException e) {
            exStringEquals(e.getMessage(), "システム整合性エラーです。最高ＳＳ単位テーブルにデータが見つかりません。", "エラーメッセージ");
            throw e;
        }
    }
    @Test(expected = CommonBizAppException.class)
    @TestOrder(15070)
    @Transactional
    public void testExec_O7() {
        MockObjectManager.initialize();
        BzGetAgInfoMockForSinkeiyaku.SYORIPTN = BzGetAgInfoMockForSinkeiyaku.TESTPATTERN4;
        KeisanGaikakanzanMockForSinkeiyaku.SYORIPTN = KeisanGaikakanzanMockForSinkeiyaku.TESTPATTERN1;
        GetKiteiCheckYenkansangkMockForSinkeiyaku.SYORIPTN = GetKiteiCheckYenkansangkMockForSinkeiyaku.TESTPATTERN1;
        CheckSaiteiPMockForSinkeiyaku.SYORIPTN = CheckSaiteiPMockForSinkeiyaku.TESTPATTERN1;
        CheckTblMosSyouhin checkTblMosSyouhin = SWAKInjector.getInstance(CheckTblMosSyouhin.class);

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("860001429");
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

        try {
            checkTblMosSyouhin.exec(mosnaiCheckParam);
        } catch (CommonBizAppException e) {
            exStringEquals(e.getMessage(), "システム整合性エラーです。最低Ｓテーブルにデータが見つかりません。", "エラーメッセージ");
            throw e;
        }
    }
    @Test
    @TestOrder(15080)
    @Transactional
    public void testExec_O8() {
        MockObjectManager.initialize();
        BzGetAgInfoMockForSinkeiyaku.SYORIPTN = BzGetAgInfoMockForSinkeiyaku.TESTPATTERN4;
        KeisanGaikakanzanMockForSinkeiyaku.SYORIPTN = KeisanGaikakanzanMockForSinkeiyaku.TESTPATTERN1;
        GetKiteiCheckYenkansangkMockForSinkeiyaku.SYORIPTN = GetKiteiCheckYenkansangkMockForSinkeiyaku.TESTPATTERN1;
        CheckSaiteiPMockForSinkeiyaku.SYORIPTN = CheckSaiteiPMockForSinkeiyaku.TESTPATTERN1;
        CheckTblMosSyouhin checkTblMosSyouhin = SWAKInjector.getInstance(CheckTblMosSyouhin.class);

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("860001437");
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

        exNumericEquals(hubiMsgLst.size(), 2, "不備メッセージテーブルエンティティリストのサイズ");

        exNumericEquals(hubiMsgLst.get(1).getRenno(), 2, "連番");
        exStringEquals(hubiMsgLst.get(1).getMessageId(), "EHC0033", "メッセージＩＤ");
        exStringEquals(hubiMsgLst.get(1).getHubimsg(), "外貨建て一時払終身保険（即時保障型）　１０年毎利率再設定の保険金額が１，０２１，０００円単位になっていません。", "不備メッセージ");
        exClassificationEquals(hubiMsgLst.get(1).getHubisyubetukbn(), C_HubisyubetuKbn.KETHORYU_HUBI, "不備種別区分");
    }
    @Test
    @TestOrder(15090)
    @Transactional
    public void testExec_O9() {
        MockObjectManager.initialize();
        BzGetAgInfoMockForSinkeiyaku.SYORIPTN = BzGetAgInfoMockForSinkeiyaku.TESTPATTERN4;
        KeisanGaikakanzanMockForSinkeiyaku.SYORIPTN = KeisanGaikakanzanMockForSinkeiyaku.TESTPATTERN1;
        GetKiteiCheckYenkansangkMockForSinkeiyaku.SYORIPTN = GetKiteiCheckYenkansangkMockForSinkeiyaku.TESTPATTERN1;
        CheckSaiteiPMockForSinkeiyaku.SYORIPTN = CheckSaiteiPMockForSinkeiyaku.TESTPATTERN1;
        CheckTblMosSyouhin checkTblMosSyouhin = SWAKInjector.getInstance(CheckTblMosSyouhin.class);

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("860001916");
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

        exNumericEquals(hubiMsgLst.size(), 2, "不備メッセージテーブルエンティティリストのサイズ");

        exStringEquals(hubiMsgLst.get(1).getMosno(), "860001916", "申込番号");
        exNumericEquals(hubiMsgLst.get(1).getRenno(), 2, "連番");
        exStringEquals(hubiMsgLst.get(1).getMessageId(), "THC1038", "メッセージＩＤ");
        exStringEquals(hubiMsgLst.get(1).getHubimsg(), "【特認可能】外貨建て一時払終身保険（即時保障型）　１０年毎利率再設定の保険料（円換算額）が最高Ｐの１，０２０，３００円をオーバーしています。", "不備メッセージ");
        exClassificationEquals(hubiMsgLst.get(1).getHubisyubetukbn(), C_HubisyubetuKbn.KETHORYU_HUBI, "不備種別区分");
        exStringEquals(hubiMsgLst.get(1).getGyoumuKousinsyaId(), "JUnitTest", "業務用更新者ＩＤ");
        exStringEquals(hubiMsgLst.get(1).getGyoumuKousinTime(), "20160509141230000", "業務用更新時間");

    }
    @Test(expected = CommonBizAppException.class)
    @TestOrder(15100)
    @Transactional
    public void testExec_O10() {
        MockObjectManager.initialize();
        BzGetAgInfoMockForSinkeiyaku.SYORIPTN = BzGetAgInfoMockForSinkeiyaku.TESTPATTERN4;
        KeisanGaikakanzanMockForSinkeiyaku.SYORIPTN = KeisanGaikakanzanMockForSinkeiyaku.TESTPATTERN1;
        GetKiteiCheckYenkansangkMockForSinkeiyaku.SYORIPTN = GetKiteiCheckYenkansangkMockForSinkeiyaku.TESTPATTERN1;
        CheckSaiteiPMockForSinkeiyaku.SYORIPTN = CheckSaiteiPMockForSinkeiyaku.TESTPATTERN1;
        CheckTblMosSyouhin checkTblMosSyouhin = SWAKInjector.getInstance(CheckTblMosSyouhin.class);

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("860001924");
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

        try {
            checkTblMosSyouhin.exec(mosnaiCheckParam);
        } catch (CommonBizAppException e) {
            exStringEquals(e.getMessage(), "システム整合性エラーです。Ｓ単位テーブルにデータが見つかりません。", "エラーメッセージ");
            throw e;
        }
    }

    @Test
    @TestOrder(15110)
    @Transactional
    public void testExec_O11() {
        MockObjectManager.initialize();
        BzGetAgInfoMockForSinkeiyaku.SYORIPTN = BzGetAgInfoMockForSinkeiyaku.TESTPATTERN4;
        KeisanGaikakanzanMockForSinkeiyaku.SYORIPTN = KeisanGaikakanzanMockForSinkeiyaku.TESTPATTERN1;
        GetKiteiCheckYenkansangkMockForSinkeiyaku.SYORIPTN = GetKiteiCheckYenkansangkMockForSinkeiyaku.TESTPATTERN1;
        CheckSaiteiPMockForSinkeiyaku.SYORIPTN = CheckSaiteiPMockForSinkeiyaku.TESTPATTERN1;
        CheckTblMosSyouhin checkTblMosSyouhin = SWAKInjector.getInstance(CheckTblMosSyouhin.class);

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("870000056");
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

        exNumericEquals(hubiMsgLst.size(), 3, "不備メッセージテーブルエンティティリストのサイズ");

        exStringEquals(hubiMsgLst.get(1).getMosno(), "870000056", "申込番号");
        exNumericEquals(hubiMsgLst.get(1).getRenno(), 2, "連番");
        exStringEquals(hubiMsgLst.get(1).getMessageId(), "EHC0019", "メッセージＩＤ");
        exStringEquals(hubiMsgLst.get(1).getHubimsg(), "外貨建て一時払終身保険（毎年受取型）　１５年毎利率再設定の本人・妻型は取扱えません。", "不備メッセージ");
        exClassificationEquals(hubiMsgLst.get(1).getHubisyubetukbn(), C_HubisyubetuKbn.KETHORYU_HUBI, "不備種別区分");
        exStringEquals(hubiMsgLst.get(1).getGyoumuKousinsyaId(), "JUnitTest", "業務用更新者ＩＤ");
        exStringEquals(hubiMsgLst.get(1).getGyoumuKousinTime(), "20160509141230000", "業務用更新時間");

        exStringEquals(hubiMsgLst.get(2).getMosno(), "870000056", "申込番号");
        exNumericEquals(hubiMsgLst.get(2).getRenno(), 3, "連番");
        exStringEquals(hubiMsgLst.get(2).getMessageId(), "EHC0130", "メッセージＩＤ");
        exStringEquals(hubiMsgLst.get(2).getHubimsg(), "外貨建て一時払終身保険（毎年受取型）　１５年毎利率再設定の給付型の入力は不要です。", "不備メッセージ");
        exClassificationEquals(hubiMsgLst.get(2).getHubisyubetukbn(), C_HubisyubetuKbn.KETHORYU_HUBI, "不備種別区分");
        exStringEquals(hubiMsgLst.get(2).getGyoumuKousinsyaId(), "JUnitTest", "業務用更新者ＩＤ");
        exStringEquals(hubiMsgLst.get(2).getGyoumuKousinTime(), "20160509141230000", "業務用更新時間");
    }

    @Test(expected = CommonBizAppException.class)
    @TestOrder(15120)
    @Transactional
    public void testExec_O12() {
        MockObjectManager.initialize();
        BzGetAgInfoMockForSinkeiyaku.SYORIPTN = BzGetAgInfoMockForSinkeiyaku.TESTPATTERN4;
        KeisanGaikakanzanMockForSinkeiyaku.SYORIPTN = KeisanGaikakanzanMockForSinkeiyaku.TESTPATTERN1;
        GetKiteiCheckYenkansangkMockForSinkeiyaku.SYORIPTN = GetKiteiCheckYenkansangkMockForSinkeiyaku.TESTPATTERN1;
        CheckSaiteiPMockForSinkeiyaku.SYORIPTN = CheckSaiteiPMockForSinkeiyaku.TESTPATTERN1;
        CheckTblMosSyouhin checkTblMosSyouhin = SWAKInjector.getInstance(CheckTblMosSyouhin.class);

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("870000049");
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

        exNumericEquals(hubiMsgLst.size(), 3, "不備メッセージテーブルエンティティリストのサイズ");

        exStringEquals(hubiMsgLst.get(1).getMosno(), "870000049", "申込番号");
        exNumericEquals(hubiMsgLst.get(1).getRenno(), 2, "連番");
        exStringEquals(hubiMsgLst.get(1).getMessageId(), "EHC0019", "メッセージＩＤ");
        exStringEquals(hubiMsgLst.get(1).getHubimsg(), "外貨建て一時払終身保険（毎年受取型）　１５年毎利率再設定の本人・妻型は取扱えません。", "不備メッセージ");
        exClassificationEquals(hubiMsgLst.get(1).getHubisyubetukbn(), C_HubisyubetuKbn.KETHORYU_HUBI, "不備種別区分");
        exStringEquals(hubiMsgLst.get(1).getGyoumuKousinsyaId(), "JUnitTest", "業務用更新者ＩＤ");
        exStringEquals(hubiMsgLst.get(1).getGyoumuKousinTime(), "20160509141230000", "業務用更新時間");

        exStringEquals(hubiMsgLst.get(2).getMosno(), "870000049", "申込番号");
        exNumericEquals(hubiMsgLst.get(2).getRenno(), 3, "連番");
        exStringEquals(hubiMsgLst.get(2).getMessageId(), "EHC0130", "メッセージＩＤ");
        exStringEquals(hubiMsgLst.get(2).getHubimsg(), "外貨建て一時払終身保険（毎年受取型）　１５年毎利率再設定の給付型の入力は不要です。", "不備メッセージ");
        exClassificationEquals(hubiMsgLst.get(2).getHubisyubetukbn(), C_HubisyubetuKbn.KETHORYU_HUBI, "不備種別区分");
        exStringEquals(hubiMsgLst.get(2).getGyoumuKousinsyaId(), "JUnitTest", "業務用更新者ＩＤ");
        exStringEquals(hubiMsgLst.get(2).getGyoumuKousinTime(), "20160509141230000", "業務用更新時間");
    }

    @Test
    @TestOrder(15130)
    @Transactional
    public void testExec_O13() {
        MockObjectManager.initialize();
        BzGetAgInfoMockForSinkeiyaku.SYORIPTN = BzGetAgInfoMockForSinkeiyaku.TESTPATTERN4;
        KeisanGaikakanzanMockForSinkeiyaku.SYORIPTN = KeisanGaikakanzanMockForSinkeiyaku.TESTPATTERN1;
        GetKiteiCheckYenkansangkMockForSinkeiyaku.SYORIPTN = GetKiteiCheckYenkansangkMockForSinkeiyaku.TESTPATTERN1;
        CheckSaiteiPMockForSinkeiyaku.SYORIPTN = CheckSaiteiPMockForSinkeiyaku.TESTPATTERN1;
        CheckTblMosSyouhin checkTblMosSyouhin = SWAKInjector.getInstance(CheckTblMosSyouhin.class);

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("860002252");
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

        exNumericEquals(hubiMsgLst.size(), 3, "不備メッセージテーブルエンティティリストのサイズ");

        exStringEquals(hubiMsgLst.get(1).getMosno(), "860002252", "申込番号");
        exNumericEquals(hubiMsgLst.get(1).getRenno(), 2, "連番");
        exStringEquals(hubiMsgLst.get(1).getMessageId(), "EHC0019", "メッセージＩＤ");
        exStringEquals(hubiMsgLst.get(1).getHubimsg(), "低解約返戻金型５年ごと利差配当付選択通貨建特別終身保険の本人・妻型は取扱えません。", "不備メッセージ");
        exClassificationEquals(hubiMsgLst.get(1).getHubisyubetukbn(), C_HubisyubetuKbn.KETHORYU_HUBI, "不備種別区分");
        exStringEquals(hubiMsgLst.get(1).getGyoumuKousinsyaId(), "JUnitTest", "業務用更新者ＩＤ");
        exStringEquals(hubiMsgLst.get(1).getGyoumuKousinTime(), "20160509141230000", "業務用更新時間");

        exStringEquals(hubiMsgLst.get(2).getMosno(), "860002252", "申込番号");
        exNumericEquals(hubiMsgLst.get(2).getRenno(), 3, "連番");
        exStringEquals(hubiMsgLst.get(2).getMessageId(), "EHC0130", "メッセージＩＤ");
        exStringEquals(hubiMsgLst.get(2).getHubimsg(), "低解約返戻金型５年ごと利差配当付選択通貨建特別終身保険の給付型の入力は不要です。", "不備メッセージ");
        exClassificationEquals(hubiMsgLst.get(2).getHubisyubetukbn(), C_HubisyubetuKbn.KETHORYU_HUBI, "不備種別区分");
        exStringEquals(hubiMsgLst.get(2).getGyoumuKousinsyaId(), "JUnitTest", "業務用更新者ＩＤ");
        exStringEquals(hubiMsgLst.get(2).getGyoumuKousinTime(), "20160509141230000", "業務用更新時間");
    }

    @Test
    @TestOrder(16010)
    @Transactional
    public void testExec_P1() {
        MockObjectManager.initialize();
        BzGetAgInfoMockForSinkeiyaku.SYORIPTN = BzGetAgInfoMockForSinkeiyaku.TESTPATTERN4;
        KeisanGaikakanzanMockForSinkeiyaku.SYORIPTN = KeisanGaikakanzanMockForSinkeiyaku.TESTPATTERN1;
        GetKiteiCheckYenkansangkMockForSinkeiyaku.SYORIPTN = GetKiteiCheckYenkansangkMockForSinkeiyaku.TESTPATTERN1;
        CheckSaiteiPMockForSinkeiyaku.SYORIPTN = CheckSaiteiPMockForSinkeiyaku.TESTPATTERN1;
        CheckTblMosSyouhin checkTblMosSyouhin = SWAKInjector.getInstance(CheckTblMosSyouhin.class);

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("860001445");
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
        mosnaiCheckParam.setKosID("JUnitTest");
        mosnaiCheckParam.setKosTime("20160509141230000");

        checkTblMosSyouhin.exec(mosnaiCheckParam);

        List<HT_HubiMsg> hubiMsgLst = mosnaiCheckParam.getListHubiMsg();

        exNumericEquals(hubiMsgLst.size(), 7, "不備メッセージテーブルエンティティリストのサイズ");

        exStringEquals(hubiMsgLst.get(1).getMosno(), "860001445", "申込番号");
        exNumericEquals(hubiMsgLst.get(1).getRenno(), 2, "連番");
        exStringEquals(hubiMsgLst.get(1).getMessageId(), "EHC0038", "メッセージＩＤ");
        exStringEquals(hubiMsgLst.get(1).getHubimsg(), "外貨建て一時払変額年金保険（ブレンド型）　年金原資最低保証１１５％の保険期間が取扱範囲外です。", "不備メッセージ");
        exClassificationEquals(hubiMsgLst.get(1).getHubisyubetukbn(), C_HubisyubetuKbn.KETHORYU_HUBI, "不備種別区分");
        exStringEquals(hubiMsgLst.get(1).getGyoumuKousinsyaId(), "JUnitTest", "業務用更新者ＩＤ");
        exStringEquals(hubiMsgLst.get(1).getGyoumuKousinTime(), "20160509141230000", "業務用更新時間");

        exNumericEquals(hubiMsgLst.get(2).getRenno(), 3, "連番");
        exStringEquals(hubiMsgLst.get(2).getMessageId(), "EHC0040", "メッセージＩＤ");
        exStringEquals(hubiMsgLst.get(2).getHubimsg(), "外貨建て一時払変額年金保険（ブレンド型）　年金原資最低保証１００％と外貨建て一時払変額年金保険（ブレンド型）　年金原資最低保証１１５％の期間が不一致です。", "不備メッセージ");
        exClassificationEquals(hubiMsgLst.get(2).getHubisyubetukbn(), C_HubisyubetuKbn.KETHORYU_HUBI, "不備種別区分");

        exNumericEquals(hubiMsgLst.get(3).getRenno(), 4, "連番");
        exStringEquals(hubiMsgLst.get(3).getMessageId(), "EHC0038", "メッセージＩＤ");
        exStringEquals(hubiMsgLst.get(3).getHubimsg(), "外貨建て一時払変額年金保険（ブレンド型）　年金原資最低保証１２０％の払込期間が取扱範囲外です。", "不備メッセージ");
        exClassificationEquals(hubiMsgLst.get(3).getHubisyubetukbn(), C_HubisyubetuKbn.KETHORYU_HUBI, "不備種別区分");

        exNumericEquals(hubiMsgLst.get(4).getRenno(), 5, "連番");
        exStringEquals(hubiMsgLst.get(4).getMessageId(), "EHC0039", "メッセージＩＤ");
        exStringEquals(hubiMsgLst.get(4).getHubimsg(), "外貨建て一時払変額年金保険（ブレンド型）　年金原資最低保証１００％と外貨建て一時払変額年金保険（ブレンド型）　年金原資最低保証１２０％の日額が不一致です。", "不備メッセージ");
        exClassificationEquals(hubiMsgLst.get(4).getHubisyubetukbn(), C_HubisyubetuKbn.KETHORYU_HUBI, "不備種別区分");

        exNumericEquals(hubiMsgLst.get(5).getRenno(), 6, "連番");
        exStringEquals(hubiMsgLst.get(5).getMessageId(), "EHC0040", "メッセージＩＤ");
        exStringEquals(hubiMsgLst.get(5).getHubimsg(), "外貨建て一時払変額年金保険（ブレンド型）　年金原資最低保証１００％と外貨建て一時払変額年金保険（ブレンド型）　年金原資最低保証１２０％の期間が不一致です。", "不備メッセージ");
        exClassificationEquals(hubiMsgLst.get(5).getHubisyubetukbn(), C_HubisyubetuKbn.KETHORYU_HUBI, "不備種別区分");

        exNumericEquals(hubiMsgLst.get(6).getRenno(), 7, "連番");
        exStringEquals(hubiMsgLst.get(6).getMessageId(), "EHC0027", "メッセージＩＤ");
        exStringEquals(hubiMsgLst.get(6).getHubimsg(), "外貨建て一時払変額年金保険（ブレンド型）　年金原資最低保証１００％と外貨建て一時払変額年金保険（ブレンド型）　年金原資最低保証１２０％の型が不一致です。", "不備メッセージ");
        exClassificationEquals(hubiMsgLst.get(6).getHubisyubetukbn(), C_HubisyubetuKbn.KETHORYU_HUBI, "不備種別区分");
    }
}