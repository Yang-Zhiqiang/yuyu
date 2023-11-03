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

import com.google.inject.AbstractModule;

import yuyu.app.base.ref.TestDataMaker;
import yuyu.app.base.ref.TestDataMakerException;
import yuyu.common.biz.bzcommon.KeisanGaikakanzan;
import yuyu.common.biz.bzcommon.KeisanGaikakanzanMockForSinkeiyaku;
import yuyu.common.biz.bzdairiten.BzGetAgInfo;
import yuyu.common.biz.bzdairiten.BzGetAgInfoMockForSinkeiyaku;
import yuyu.common.sinkeiyaku.skcommon.EditNenkinKoumokuUtil;
import yuyu.common.sinkeiyaku.skcommon.EditNenkinKoumokuUtilMockForSinkeiyaku;
import yuyu.common.sinkeiyaku.skcommon.GetKiteiCheckYenkansangk;
import yuyu.common.sinkeiyaku.skcommon.GetKiteiCheckYenkansangkMockForSinkeiyaku;
import yuyu.def.biz.manager.BizDomManager;
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

/**
 * 申込商品TBLチェックのメソッド {@link CheckTblMosSyouhin#exec(MosnaiCheckParam)} テスト用クラスです。<br />
 * テスト実行用クラスです。<br />
 */
@RunWith(OrderedRunner.class)
public class CheckTblMosSyouhinTest_exec4 {

    @Inject
    private MosnaiCheckParam mosnaiCheckParam;

    @Inject
    private SinkeiyakuDomManager sinkeiyakuDomManager;

    @Inject
    private BizDomManager bizDomManager;
    private final static String fileName = "UT-SP_単体テスト仕様書（共通）_申込商品TBLチェック";

    private final static String sheetName = "INデータ(4)";

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

    @Test
    @TestOrder(17010)
    @Transactional
    public void testExec_Q1() {
        MockObjectManager.initialize();
        BzGetAgInfoMockForSinkeiyaku.SYORIPTN = BzGetAgInfoMockForSinkeiyaku.TESTPATTERN4;
        KeisanGaikakanzanMockForSinkeiyaku.SYORIPTN = KeisanGaikakanzanMockForSinkeiyaku.TESTPATTERN1;
        GetKiteiCheckYenkansangkMockForSinkeiyaku.SYORIPTN = GetKiteiCheckYenkansangkMockForSinkeiyaku.TESTPATTERN1;
        CheckSaiteiPMockForSinkeiyaku.SYORIPTN = CheckSaiteiPMockForSinkeiyaku.TESTPATTERN1;
        CheckTblMosSyouhin checkTblMosSyouhin = SWAKInjector.getInstance(CheckTblMosSyouhin.class);

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("860001452");
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

        exNumericEquals(hubiMsgLst.size(), 3, "不備メッセージテーブルエンティティリストのサイズ");

        exStringEquals(hubiMsgLst.get(1).getMosno(), "860001452", "申込番号");
        exNumericEquals(hubiMsgLst.get(1).getRenno(), 2, "連番");
        exStringEquals(hubiMsgLst.get(1).getMessageId(), "EHC0150", "メッセージＩＤ");
        exStringEquals(hubiMsgLst.get(1).getHubimsg(), "外貨建て一時払変額年金保険（ブレンド型）　年金原資最低保証１２５％と外貨建て一時払終身保険（即時保障型）　１５年毎利率再設定の給付型が不一致です。", "不備メッセージ");
        exClassificationEquals(hubiMsgLst.get(1).getHubisyubetukbn(), C_HubisyubetuKbn.KETHORYU_HUBI, "不備種別区分");
        exStringEquals(hubiMsgLst.get(1).getGyoumuKousinsyaId(), "JUnitTest", "業務用更新者ＩＤ");
        exStringEquals(hubiMsgLst.get(1).getGyoumuKousinTime(), "20160509141230000", "業務用更新時間");

        exNumericEquals(hubiMsgLst.get(2).getRenno(), 3, "連番");
        exStringEquals(hubiMsgLst.get(2).getMessageId(), "EHC0150", "メッセージＩＤ");
        exStringEquals(hubiMsgLst.get(2).getHubimsg(), "外貨建て一時払変額年金保険（ブレンド型）　年金原資最低保証１２５％と外貨建て一時払終身保険（即時保障型）　１５年毎利率再設定の給付型が不一致です。", "不備メッセージ");
        exClassificationEquals(hubiMsgLst.get(2).getHubisyubetukbn(), C_HubisyubetuKbn.KETHORYU_HUBI, "不備種別区分");
    }
    @Test
    @TestOrder(17020)
    @Transactional
    public void testExec_Q2() {
        MockObjectManager.initialize();
        BzGetAgInfoMockForSinkeiyaku.SYORIPTN = BzGetAgInfoMockForSinkeiyaku.TESTPATTERN4;
        KeisanGaikakanzanMockForSinkeiyaku.SYORIPTN = KeisanGaikakanzanMockForSinkeiyaku.TESTPATTERN1;
        GetKiteiCheckYenkansangkMockForSinkeiyaku.SYORIPTN = GetKiteiCheckYenkansangkMockForSinkeiyaku.TESTPATTERN1;
        CheckSaiteiPMockForSinkeiyaku.SYORIPTN = CheckSaiteiPMockForSinkeiyaku.TESTPATTERN1;
        CheckTblMosSyouhin checkTblMosSyouhin = SWAKInjector.getInstance(CheckTblMosSyouhin.class);

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("860001460");
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

        exNumericEquals(hubiMsgLst.size(), 2, "不備メッセージテーブルエンティティリストのサイズ");

        exStringEquals(hubiMsgLst.get(1).getMosno(), "860001460", "申込番号");
        exNumericEquals(hubiMsgLst.get(1).getRenno(), 2, "連番");
        exStringEquals(hubiMsgLst.get(1).getMessageId(), "EHC0150", "メッセージＩＤ");
        exStringEquals(hubiMsgLst.get(1).getHubimsg(), "外貨建て一時払変額年金保険（ブレンド型）　年金原資最低保証１２５％と外貨建て一時払終身保険（即時保障型）　１５年毎利率再設定の給付型が不一致です。", "不備メッセージ");
        exClassificationEquals(hubiMsgLst.get(1).getHubisyubetukbn(), C_HubisyubetuKbn.KETHORYU_HUBI, "不備種別区分");
        exStringEquals(hubiMsgLst.get(1).getGyoumuKousinsyaId(), "JUnitTest", "業務用更新者ＩＤ");
        exStringEquals(hubiMsgLst.get(1).getGyoumuKousinTime(), "20160509141230000", "業務用更新時間");
    }
    @Test
    @TestOrder(17030)
    @Transactional
    public void testExec_Q3() {
        MockObjectManager.initialize();
        BzGetAgInfoMockForSinkeiyaku.SYORIPTN = BzGetAgInfoMockForSinkeiyaku.TESTPATTERN4;
        KeisanGaikakanzanMockForSinkeiyaku.SYORIPTN = KeisanGaikakanzanMockForSinkeiyaku.TESTPATTERN1;
        GetKiteiCheckYenkansangkMockForSinkeiyaku.SYORIPTN = GetKiteiCheckYenkansangkMockForSinkeiyaku.TESTPATTERN1;
        CheckSaiteiPMockForSinkeiyaku.SYORIPTN = CheckSaiteiPMockForSinkeiyaku.TESTPATTERN1;
        CheckTblMosSyouhin checkTblMosSyouhin = SWAKInjector.getInstance(CheckTblMosSyouhin.class);

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("860001478");
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

        exNumericEquals(hubiMsgLst.size(), 2, "不備メッセージテーブルエンティティリストのサイズ");

        exStringEquals(hubiMsgLst.get(1).getMosno(), "860001478", "申込番号");
        exNumericEquals(hubiMsgLst.get(1).getRenno(), 2, "連番");
        exStringEquals(hubiMsgLst.get(1).getMessageId(), "EHC0150", "メッセージＩＤ");
        exStringEquals(hubiMsgLst.get(1).getHubimsg(), "外貨建て一時払変額年金保険（ブレンド型）　年金原資最低保証１２５％と外貨建て一時払終身保険（即時保障型）　１５年毎利率再設定の給付型が不一致です。", "不備メッセージ");
        exClassificationEquals(hubiMsgLst.get(1).getHubisyubetukbn(), C_HubisyubetuKbn.KETHORYU_HUBI, "不備種別区分");
        exStringEquals(hubiMsgLst.get(1).getGyoumuKousinsyaId(), "JUnitTest", "業務用更新者ＩＤ");
        exStringEquals(hubiMsgLst.get(1).getGyoumuKousinTime(), "20160509141230000", "業務用更新時間");
    }
    @Test
    @TestOrder(17040)
    @Transactional
    public void testExec_Q4() {
        MockObjectManager.initialize();
        BzGetAgInfoMockForSinkeiyaku.SYORIPTN = BzGetAgInfoMockForSinkeiyaku.TESTPATTERN4;
        KeisanGaikakanzanMockForSinkeiyaku.SYORIPTN = KeisanGaikakanzanMockForSinkeiyaku.TESTPATTERN1;
        GetKiteiCheckYenkansangkMockForSinkeiyaku.SYORIPTN = GetKiteiCheckYenkansangkMockForSinkeiyaku.TESTPATTERN1;
        CheckSaiteiPMockForSinkeiyaku.SYORIPTN = CheckSaiteiPMockForSinkeiyaku.TESTPATTERN1;
        CheckTblMosSyouhin checkTblMosSyouhin = SWAKInjector.getInstance(CheckTblMosSyouhin.class);

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("860001486");
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

        exNumericEquals(hubiMsgLst.size(), 2, "不備メッセージテーブルエンティティリストのサイズ");

        exStringEquals(hubiMsgLst.get(1).getMosno(), "860001486", "申込番号");
        exNumericEquals(hubiMsgLst.get(1).getRenno(), 2, "連番");
        exStringEquals(hubiMsgLst.get(1).getMessageId(), "EHC0150", "メッセージＩＤ");
        exStringEquals(hubiMsgLst.get(1).getHubimsg(), "外貨建て一時払変額年金保険（ブレンド型）　年金原資最低保証１２５％と外貨建て一時払終身保険（即時保障型）　１５年毎利率再設定の給付型が不一致です。", "不備メッセージ");
        exClassificationEquals(hubiMsgLst.get(1).getHubisyubetukbn(), C_HubisyubetuKbn.KETHORYU_HUBI, "不備種別区分");
        exStringEquals(hubiMsgLst.get(1).getGyoumuKousinsyaId(), "JUnitTest", "業務用更新者ＩＤ");
        exStringEquals(hubiMsgLst.get(1).getGyoumuKousinTime(), "20160509141230000", "業務用更新時間");
    }
    @Test
    @TestOrder(17050)
    @Transactional
    public void testExec_Q5() {
        MockObjectManager.initialize();
        BzGetAgInfoMockForSinkeiyaku.SYORIPTN = BzGetAgInfoMockForSinkeiyaku.TESTPATTERN4;
        KeisanGaikakanzanMockForSinkeiyaku.SYORIPTN = KeisanGaikakanzanMockForSinkeiyaku.TESTPATTERN1;
        GetKiteiCheckYenkansangkMockForSinkeiyaku.SYORIPTN = GetKiteiCheckYenkansangkMockForSinkeiyaku.TESTPATTERN1;
        CheckSaiteiPMockForSinkeiyaku.SYORIPTN = CheckSaiteiPMockForSinkeiyaku.TESTPATTERN1;
        CheckTblMosSyouhin checkTblMosSyouhin = SWAKInjector.getInstance(CheckTblMosSyouhin.class);

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("860001494");
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

        checkTblMosSyouhin.exec(mosnaiCheckParam);

        List<HT_HubiMsg> hubiMsgLst = mosnaiCheckParam.getListHubiMsg();

        exNumericEquals(hubiMsgLst.size(), 1, "不備メッセージテーブルエンティティリストのサイズ");
        exStringEquals(hubiMsgLst.get(0).getMosno(), "860001494", "申込番号");
        exNumericEquals(hubiMsgLst.get(0).getRenno(), 1, "連番");
        exStringEquals(hubiMsgLst.get(0).getMessageId(), "EBC0046", "メッセージＩＤ");
        exStringEquals(hubiMsgLst.get(0).getHubimsg(), "据置期間が正しくありません。", "不備メッセージ");
        exClassificationEquals(hubiMsgLst.get(0).getHubisyubetukbn(), C_HubisyubetuKbn.KETHORYU_HUBI, "不備種別区分");
        exClassificationEquals(hubiMsgLst.get(0).getHubisyubetusyousaikbn(), C_HubisyubetusyousaiKbn.NONE,
            "不備種別詳細区分");
    }
    @Test
    @TestOrder(17060)
    @Transactional
    public void testExec_Q6() {
        MockObjectManager.initialize();
        BzGetAgInfoMockForSinkeiyaku.SYORIPTN = BzGetAgInfoMockForSinkeiyaku.TESTPATTERN4;
        KeisanGaikakanzanMockForSinkeiyaku.SYORIPTN = KeisanGaikakanzanMockForSinkeiyaku.TESTPATTERN1;
        GetKiteiCheckYenkansangkMockForSinkeiyaku.SYORIPTN = GetKiteiCheckYenkansangkMockForSinkeiyaku.TESTPATTERN1;
        CheckSaiteiPMockForSinkeiyaku.SYORIPTN = CheckSaiteiPMockForSinkeiyaku.TESTPATTERN1;
        CheckTblMosSyouhin checkTblMosSyouhin = SWAKInjector.getInstance(CheckTblMosSyouhin.class);

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("860001502");
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

        exNumericEquals(hubiMsgLst.size(), 2, "不備メッセージテーブルエンティティリストのサイズ");

        exStringEquals(hubiMsgLst.get(1).getMosno(), "860001502", "申込番号");
        exNumericEquals(hubiMsgLst.get(1).getRenno(), 2, "連番");
        exStringEquals(hubiMsgLst.get(1).getMessageId(), "EHC0019", "メッセージＩＤ");
        exStringEquals(hubiMsgLst.get(1).getHubimsg(), "外貨建て一時払終身保険（即時保障型）　１５年毎利率再設定の１８０日型は取扱えません。", "不備メッセージ");
        exClassificationEquals(hubiMsgLst.get(1).getHubisyubetukbn(), C_HubisyubetuKbn.KETHORYU_HUBI, "不備種別区分");
        exStringEquals(hubiMsgLst.get(1).getGyoumuKousinsyaId(), "JUnitTest", "業務用更新者ＩＤ");
        exStringEquals(hubiMsgLst.get(1).getGyoumuKousinTime(), "20160509141230000", "業務用更新時間");
    }
    @Test
    @TestOrder(17070)
    @Transactional
    public void testExec_Q7() {
        MockObjectManager.initialize();
        BzGetAgInfoMockForSinkeiyaku.SYORIPTN = BzGetAgInfoMockForSinkeiyaku.TESTPATTERN4;
        KeisanGaikakanzanMockForSinkeiyaku.SYORIPTN = KeisanGaikakanzanMockForSinkeiyaku.TESTPATTERN1;
        GetKiteiCheckYenkansangkMockForSinkeiyaku.SYORIPTN = GetKiteiCheckYenkansangkMockForSinkeiyaku.TESTPATTERN1;
        CheckSaiteiPMockForSinkeiyaku.SYORIPTN = CheckSaiteiPMockForSinkeiyaku.TESTPATTERN1;
        CheckTblMosSyouhin checkTblMosSyouhin = SWAKInjector.getInstance(CheckTblMosSyouhin.class);

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("860001510");
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

        checkTblMosSyouhin.exec(mosnaiCheckParam);

        List<HT_HubiMsg> hubiMsgLst = mosnaiCheckParam.getListHubiMsg();

        exNumericEquals(hubiMsgLst.size(), 1, "不備メッセージテーブルエンティティリストのサイズ");
        exStringEquals(hubiMsgLst.get(0).getMosno(), "860001510", "申込番号");
        exNumericEquals(hubiMsgLst.get(0).getRenno(), 1, "連番");
        exStringEquals(hubiMsgLst.get(0).getMessageId(), "EBC0046", "メッセージＩＤ");
        exStringEquals(hubiMsgLst.get(0).getHubimsg(), "据置期間が正しくありません。", "不備メッセージ");
        exClassificationEquals(hubiMsgLst.get(0).getHubisyubetukbn(), C_HubisyubetuKbn.KETHORYU_HUBI, "不備種別区分");
        exClassificationEquals(hubiMsgLst.get(0).getHubisyubetusyousaikbn(), C_HubisyubetusyousaiKbn.NONE,
            "不備種別詳細区分");
    }
    @Test
    @TestOrder(17080)
    @Transactional
    public void testExec_Q8() {
        MockObjectManager.initialize();
        BzGetAgInfoMockForSinkeiyaku.SYORIPTN = BzGetAgInfoMockForSinkeiyaku.TESTPATTERN4;
        KeisanGaikakanzanMockForSinkeiyaku.SYORIPTN = KeisanGaikakanzanMockForSinkeiyaku.TESTPATTERN1;
        GetKiteiCheckYenkansangkMockForSinkeiyaku.SYORIPTN = GetKiteiCheckYenkansangkMockForSinkeiyaku.TESTPATTERN1;
        CheckSaiteiPMockForSinkeiyaku.SYORIPTN = CheckSaiteiPMockForSinkeiyaku.TESTPATTERN1;
        CheckTblMosSyouhin checkTblMosSyouhin = SWAKInjector.getInstance(CheckTblMosSyouhin.class);

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("860001528");
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

        checkTblMosSyouhin.exec(mosnaiCheckParam);

        List<HT_HubiMsg> hubiMsgLst = mosnaiCheckParam.getListHubiMsg();

        exNumericEquals(hubiMsgLst.size(), 1, "不備メッセージテーブルエンティティリストのサイズ");
        exStringEquals(hubiMsgLst.get(0).getMosno(), "860001528", "申込番号");
        exNumericEquals(hubiMsgLst.get(0).getRenno(), 1, "連番");
        exStringEquals(hubiMsgLst.get(0).getMessageId(), "EBC0046", "メッセージＩＤ");
        exStringEquals(hubiMsgLst.get(0).getHubimsg(), "据置期間が正しくありません。", "不備メッセージ");
        exClassificationEquals(hubiMsgLst.get(0).getHubisyubetukbn(), C_HubisyubetuKbn.KETHORYU_HUBI, "不備種別区分");
        exClassificationEquals(hubiMsgLst.get(0).getHubisyubetusyousaikbn(), C_HubisyubetusyousaiKbn.NONE,
            "不備種別詳細区分");
    }
    @Test
    @TestOrder(18010)
    @Transactional
    public void testExec_R1() {
        MockObjectManager.initialize();
        BzGetAgInfoMockForSinkeiyaku.SYORIPTN = BzGetAgInfoMockForSinkeiyaku.TESTPATTERN4;
        KeisanGaikakanzanMockForSinkeiyaku.SYORIPTN = KeisanGaikakanzanMockForSinkeiyaku.TESTPATTERN1;
        GetKiteiCheckYenkansangkMockForSinkeiyaku.SYORIPTN = GetKiteiCheckYenkansangkMockForSinkeiyaku.TESTPATTERN1;
        SetKyuuhuNitigakuMockForSinkeiyaku.SYORIPTN = SetKyuuhuNitigakuMockForSinkeiyaku.TESTPATTERN2;
        CheckSaiteiPMockForSinkeiyaku.SYORIPTN = CheckSaiteiPMockForSinkeiyaku.TESTPATTERN1;
        CheckTblMosSyouhin checkTblMosSyouhin = SWAKInjector.getInstance(CheckTblMosSyouhin.class);

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("860001536");
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

        checkTblMosSyouhin.exec(mosnaiCheckParam);

        List<HT_HubiMsg> hubiMsgLst = mosnaiCheckParam.getListHubiMsg();

        exNumericEquals(hubiMsgLst.size(), 1, "不備メッセージテーブルエンティティリストのサイズ");
        exStringEquals(hubiMsgLst.get(0).getMosno(), "860001536", "申込番号");
        exNumericEquals(hubiMsgLst.get(0).getRenno(), 1, "連番");
        exStringEquals(hubiMsgLst.get(0).getMessageId(), "EBC0046", "メッセージＩＤ");
        exStringEquals(hubiMsgLst.get(0).getHubimsg(), "据置期間が正しくありません。", "不備メッセージ");
        exClassificationEquals(hubiMsgLst.get(0).getHubisyubetukbn(), C_HubisyubetuKbn.KETHORYU_HUBI, "不備種別区分");
        exClassificationEquals(hubiMsgLst.get(0).getHubisyubetusyousaikbn(), C_HubisyubetusyousaiKbn.NONE,
            "不備種別詳細区分");
    }
    @Test
    @TestOrder(18020)
    @Transactional
    public void testExec_R2() {
        MockObjectManager.initialize();
        BzGetAgInfoMockForSinkeiyaku.SYORIPTN = BzGetAgInfoMockForSinkeiyaku.TESTPATTERN4;
        KeisanGaikakanzanMockForSinkeiyaku.SYORIPTN = KeisanGaikakanzanMockForSinkeiyaku.TESTPATTERN1;
        GetKiteiCheckYenkansangkMockForSinkeiyaku.SYORIPTN = GetKiteiCheckYenkansangkMockForSinkeiyaku.TESTPATTERN1;
        SetKyuuhuNitigakuMockForSinkeiyaku.SYORIPTN = SetKyuuhuNitigakuMockForSinkeiyaku.TESTPATTERN2;
        CheckSaiteiPMockForSinkeiyaku.SYORIPTN = CheckSaiteiPMockForSinkeiyaku.TESTPATTERN1;
        CheckTblMosSyouhin checkTblMosSyouhin = SWAKInjector.getInstance(CheckTblMosSyouhin.class);

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("860001544");
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

        checkTblMosSyouhin.exec(mosnaiCheckParam);

        List<HT_HubiMsg> hubiMsgLst = mosnaiCheckParam.getListHubiMsg();

        exNumericEquals(hubiMsgLst.size(), 1, "不備メッセージテーブルエンティティリストのサイズ");
        exStringEquals(hubiMsgLst.get(0).getMosno(), "860001544", "申込番号");
        exNumericEquals(hubiMsgLst.get(0).getRenno(), 1, "連番");
        exStringEquals(hubiMsgLst.get(0).getMessageId(), "EBC0046", "メッセージＩＤ");
        exStringEquals(hubiMsgLst.get(0).getHubimsg(), "据置期間が正しくありません。", "不備メッセージ");
        exClassificationEquals(hubiMsgLst.get(0).getHubisyubetukbn(), C_HubisyubetuKbn.KETHORYU_HUBI, "不備種別区分");
        exClassificationEquals(hubiMsgLst.get(0).getHubisyubetusyousaikbn(), C_HubisyubetusyousaiKbn.NONE,
            "不備種別詳細区分");
    }
    @Test
    @TestOrder(18030)
    @Transactional
    public void testExec_R3() {
        MockObjectManager.initialize();
        BzGetAgInfoMockForSinkeiyaku.SYORIPTN = BzGetAgInfoMockForSinkeiyaku.TESTPATTERN4;
        KeisanGaikakanzanMockForSinkeiyaku.SYORIPTN = KeisanGaikakanzanMockForSinkeiyaku.TESTPATTERN1;
        GetKiteiCheckYenkansangkMockForSinkeiyaku.SYORIPTN = GetKiteiCheckYenkansangkMockForSinkeiyaku.TESTPATTERN1;
        SetKyuuhuNitigakuMockForSinkeiyaku.SYORIPTN = SetKyuuhuNitigakuMockForSinkeiyaku.TESTPATTERN2;
        CheckSaiteiPMockForSinkeiyaku.SYORIPTN = CheckSaiteiPMockForSinkeiyaku.TESTPATTERN1;
        CheckTblMosSyouhin checkTblMosSyouhin = SWAKInjector.getInstance(CheckTblMosSyouhin.class);

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("860001551");
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

        exNumericEquals(hubiMsgLst.size(), 2, "不備メッセージテーブルエンティティリストのサイズ");

        exStringEquals(hubiMsgLst.get(1).getMosno(), "860001551", "申込番号");
        exNumericEquals(hubiMsgLst.get(1).getRenno(), 2, "連番");
        exStringEquals(hubiMsgLst.get(1).getMessageId(), "KHC0187", "メッセージＩＤ");
        exStringEquals(hubiMsgLst.get(1).getHubimsg(), "（特認済）商品単位給付日額が告知上限日額の２，６００，０００．００ユーロをオーバーしています。商品名　外貨建て一時払終身保険（毎年受取型）　１０年毎利率再設定", "不備メッセージ");
        exClassificationEquals(hubiMsgLst.get(1).getHubisyubetukbn(), C_HubisyubetuKbn.KETHORYU_HUBI, "不備種別区分");
        exStringEquals(hubiMsgLst.get(1).getGyoumuKousinsyaId(), "JUnitTest", "業務用更新者ＩＤ");
        exStringEquals(hubiMsgLst.get(1).getGyoumuKousinTime(), "20160509141230000", "業務用更新時間");
    }
    @Test
    @TestOrder(18040)
    @Transactional
    public void testExec_R4() {
        MockObjectManager.initialize();
        BzGetAgInfoMockForSinkeiyaku.SYORIPTN = BzGetAgInfoMockForSinkeiyaku.TESTPATTERN4;
        KeisanGaikakanzanMockForSinkeiyaku.SYORIPTN = KeisanGaikakanzanMockForSinkeiyaku.TESTPATTERN1;
        GetKiteiCheckYenkansangkMockForSinkeiyaku.SYORIPTN = GetKiteiCheckYenkansangkMockForSinkeiyaku.TESTPATTERN1;
        SetKyuuhuNitigakuMockForSinkeiyaku.SYORIPTN = SetKyuuhuNitigakuMockForSinkeiyaku.TESTPATTERN2;
        CheckSaiteiPMockForSinkeiyaku.SYORIPTN = CheckSaiteiPMockForSinkeiyaku.TESTPATTERN1;
        CheckTblMosSyouhin checkTblMosSyouhin = SWAKInjector.getInstance(CheckTblMosSyouhin.class);

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("860001569");
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

        exNumericEquals(hubiMsgLst.size(), 2, "不備メッセージテーブルエンティティリストのサイズ");

        exStringEquals(hubiMsgLst.get(1).getMosno(), "860001569", "申込番号");
        exNumericEquals(hubiMsgLst.get(1).getRenno(), 2, "連番");
        exStringEquals(hubiMsgLst.get(1).getMessageId(), "THC0187", "メッセージＩＤ");
        exStringEquals(hubiMsgLst.get(1).getHubimsg(), "【特認可能】商品単位給付日額が告知上限日額の２，６００，０００．００ユーロをオーバーしています。商品名　外貨建て一時払終身保険（毎年受取型）　１０年毎利率再設定", "不備メッセージ");
        exClassificationEquals(hubiMsgLst.get(1).getHubisyubetukbn(), C_HubisyubetuKbn.KETHORYU_HUBI, "不備種別区分");
        exStringEquals(hubiMsgLst.get(1).getGyoumuKousinsyaId(), "JUnitTest", "業務用更新者ＩＤ");
        exStringEquals(hubiMsgLst.get(1).getGyoumuKousinTime(), "20160509141230000", "業務用更新時間");
    }
    @Test
    @TestOrder(18050)
    @Transactional
    public void testExec_R5() {
        MockObjectManager.initialize();
        BzGetAgInfoMockForSinkeiyaku.SYORIPTN = BzGetAgInfoMockForSinkeiyaku.TESTPATTERN4;
        KeisanGaikakanzanMockForSinkeiyaku.SYORIPTN = KeisanGaikakanzanMockForSinkeiyaku.TESTPATTERN1;
        GetKiteiCheckYenkansangkMockForSinkeiyaku.SYORIPTN = GetKiteiCheckYenkansangkMockForSinkeiyaku.TESTPATTERN1;
        SetKyuuhuNitigakuMockForSinkeiyaku.SYORIPTN = SetKyuuhuNitigakuMockForSinkeiyaku.TESTPATTERN2;
        CheckSaiteiPMockForSinkeiyaku.SYORIPTN = CheckSaiteiPMockForSinkeiyaku.TESTPATTERN1;
        CheckTblMosSyouhin checkTblMosSyouhin = SWAKInjector.getInstance(CheckTblMosSyouhin.class);

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("860001577");
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

        exClassificationEquals(mosnaiCheckParam.getKokutiChkKekkaKbn(), C_KktatkichkkekkaKbn.KKTJGSOV, "告知扱チェック結果区分");
        exClassificationEquals(mosnaiCheckParam.getSekmossakuseiErroutKbn(), C_SekmossakuseiErroutKbn.GAMEN, "設計書申込書作成エラー出力区分");
        exStringEquals(mosnaiCheckParam.getSekmossakuseiErrmsg1(), "告知書での取扱上限を超えているため、健康診断書の提出をご案内ください。（告知上限", "設計書申込書作成エラーメッセージ１");
        exStringEquals(mosnaiCheckParam.getSekmossakuseiErrmsg2(), "Ｓオーバー）", "設計書申込書作成エラーメッセージ２");
        exClassificationEquals(mosnaiCheckParam.getKouzokuSyoriJikkouKbn(), C_KouzokujkKbn.NONE, "後続処理実行区分");
    }
    @Test
    @TestOrder(18060)
    @Transactional
    public void testExec_R6() {
        MockObjectManager.initialize();
        BzGetAgInfoMockForSinkeiyaku.SYORIPTN = BzGetAgInfoMockForSinkeiyaku.TESTPATTERN4;
        KeisanGaikakanzanMockForSinkeiyaku.SYORIPTN = KeisanGaikakanzanMockForSinkeiyaku.TESTPATTERN1;
        GetKiteiCheckYenkansangkMockForSinkeiyaku.SYORIPTN = GetKiteiCheckYenkansangkMockForSinkeiyaku.TESTPATTERN1;
        SetKyuuhuNitigakuMockForSinkeiyaku.SYORIPTN = SetKyuuhuNitigakuMockForSinkeiyaku.TESTPATTERN2;
        CheckSaiteiPMockForSinkeiyaku.SYORIPTN = CheckSaiteiPMockForSinkeiyaku.TESTPATTERN1;
        CheckTblMosSyouhin checkTblMosSyouhin = SWAKInjector.getInstance(CheckTblMosSyouhin.class);

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("860001585");
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
    @TestOrder(18070)
    @Transactional
    public void testExec_R7() {
        MockObjectManager.initialize();
        BzGetAgInfoMockForSinkeiyaku.SYORIPTN = BzGetAgInfoMockForSinkeiyaku.TESTPATTERN4;
        KeisanGaikakanzanMockForSinkeiyaku.SYORIPTN = KeisanGaikakanzanMockForSinkeiyaku.TESTPATTERN1;
        GetKiteiCheckYenkansangkMockForSinkeiyaku.SYORIPTN = GetKiteiCheckYenkansangkMockForSinkeiyaku.TESTPATTERN1;
        SetKyuuhuNitigakuMockForSinkeiyaku.SYORIPTN = SetKyuuhuNitigakuMockForSinkeiyaku.TESTPATTERN2;
        CheckSaiteiPMockForSinkeiyaku.SYORIPTN = CheckSaiteiPMockForSinkeiyaku.TESTPATTERN1;
        CheckTblMosSyouhin checkTblMosSyouhin = SWAKInjector.getInstance(CheckTblMosSyouhin.class);

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("860001593");
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
    @TestOrder(18080)
    @Transactional
    public void testExec_R8() {
        MockObjectManager.initialize();
        BzGetAgInfoMockForSinkeiyaku.SYORIPTN = BzGetAgInfoMockForSinkeiyaku.TESTPATTERN4;
        KeisanGaikakanzanMockForSinkeiyaku.SYORIPTN = KeisanGaikakanzanMockForSinkeiyaku.TESTPATTERN1;
        GetKiteiCheckYenkansangkMockForSinkeiyaku.SYORIPTN = GetKiteiCheckYenkansangkMockForSinkeiyaku.TESTPATTERN1;
        SetKyuuhuNitigakuMockForSinkeiyaku.SYORIPTN = SetKyuuhuNitigakuMockForSinkeiyaku.TESTPATTERN2;
        CheckSaiteiPMockForSinkeiyaku.SYORIPTN = CheckSaiteiPMockForSinkeiyaku.TESTPATTERN1;
        CheckTblMosSyouhin checkTblMosSyouhin = SWAKInjector.getInstance(CheckTblMosSyouhin.class);

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("860001601");
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
    @TestOrder(19010)
    @Transactional
    public void testExec_S1() {
        MockObjectManager.initialize();
        BzGetAgInfoMockForSinkeiyaku.SYORIPTN = BzGetAgInfoMockForSinkeiyaku.TESTPATTERN4;
        KeisanGaikakanzanMockForSinkeiyaku.SYORIPTN = KeisanGaikakanzanMockForSinkeiyaku.TESTPATTERN1;
        SetKyuuhuNitigakuMockForSinkeiyaku.SYORIPTN = SetKyuuhuNitigakuMockForSinkeiyaku.TESTPATTERN1;
        GetKiteiCheckYenkansangkMockForSinkeiyaku.SYORIPTN = GetKiteiCheckYenkansangkMockForSinkeiyaku.TESTPATTERN1;
        CheckSaiteiPMockForSinkeiyaku.SYORIPTN = CheckSaiteiPMockForSinkeiyaku.TESTPATTERN1;
        CheckTblMosSyouhin checkTblMosSyouhin = SWAKInjector.getInstance(CheckTblMosSyouhin.class);

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("860001619");
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

        exClassificationEquals(mosnaiCheckParam.getSekmossakuseiErroutKbn(), C_SekmossakuseiErroutKbn.GAMEN, "設計書申込書作成エラー出力区分");
        exStringEquals(mosnaiCheckParam.getSekmossakuseiErrmsg1(), "給付日額が最高日額の６，０００，０００．００ユーロをオーバーしています。（ＮＵＬ", "設計書申込書作成エラーメッセージ１");
        exStringEquals(mosnaiCheckParam.getSekmossakuseiErrmsg2(), "Ｌ）", "設計書申込書作成エラーメッセージ２");
        exClassificationEquals(mosnaiCheckParam.getKouzokuSyoriJikkouKbn(), C_KouzokujkKbn.NONE, "後続処理実行区分");
    }
    @Test
    @TestOrder(19020)
    @Transactional
    public void testExec_S2() {
        MockObjectManager.initialize();
        BzGetAgInfoMockForSinkeiyaku.SYORIPTN = BzGetAgInfoMockForSinkeiyaku.TESTPATTERN4;
        KeisanGaikakanzanMockForSinkeiyaku.SYORIPTN = KeisanGaikakanzanMockForSinkeiyaku.TESTPATTERN1;
        SetKyuuhuNitigakuMockForSinkeiyaku.SYORIPTN = SetKyuuhuNitigakuMockForSinkeiyaku.TESTPATTERN2;
        GetKiteiCheckYenkansangkMockForSinkeiyaku.SYORIPTN = GetKiteiCheckYenkansangkMockForSinkeiyaku.TESTPATTERN1;
        CheckSaiteiPMockForSinkeiyaku.SYORIPTN = CheckSaiteiPMockForSinkeiyaku.TESTPATTERN1;
        CheckTblMosSyouhin checkTblMosSyouhin = SWAKInjector.getInstance(CheckTblMosSyouhin.class);

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("860001627");
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

        exClassificationEquals(mosnaiCheckParam.getKouzokuSyoriJikkouKbn(), C_KouzokujkKbn.NONE, "後続処理実行区分");
    }
    @Test
    @TestOrder(19030)
    @Transactional
    public void testExec_S3() {
        MockObjectManager.initialize();
        BzGetAgInfoMockForSinkeiyaku.SYORIPTN = BzGetAgInfoMockForSinkeiyaku.TESTPATTERN4;
        KeisanGaikakanzanMockForSinkeiyaku.SYORIPTN = KeisanGaikakanzanMockForSinkeiyaku.TESTPATTERN1;
        SetKyuuhuNitigakuMockForSinkeiyaku.SYORIPTN = SetKyuuhuNitigakuMockForSinkeiyaku.TESTPATTERN3;
        GetKiteiCheckYenkansangkMockForSinkeiyaku.SYORIPTN = GetKiteiCheckYenkansangkMockForSinkeiyaku.TESTPATTERN1;
        CheckSaiteiPMockForSinkeiyaku.SYORIPTN = CheckSaiteiPMockForSinkeiyaku.TESTPATTERN1;
        CheckTblMosSyouhin checkTblMosSyouhin = SWAKInjector.getInstance(CheckTblMosSyouhin.class);

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("860001635");
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

        exNumericEquals(hubiMsgLst.size(), 4, "不備メッセージテーブルエンティティリストのサイズ");

        exStringEquals(hubiMsgLst.get(1).getMosno(), "860001635", "申込番号");
        exNumericEquals(hubiMsgLst.get(1).getRenno(), 2, "連番");
        exStringEquals(hubiMsgLst.get(1).getMessageId(), "THC0151", "メッセージＩＤ");
        exStringEquals(hubiMsgLst.get(1).getHubimsg(), "【特認可能】契約単位給付日額が最高日額１の６，０００，０００．００ユーロをオーバーしています。", "不備メッセージ");
        exClassificationEquals(hubiMsgLst.get(1).getHubisyubetukbn(), C_HubisyubetuKbn.KETHORYU_HUBI, "不備種別区分");
        exStringEquals(hubiMsgLst.get(1).getGyoumuKousinsyaId(), "JUnitTest", "業務用更新者ＩＤ");
        exStringEquals(hubiMsgLst.get(1).getGyoumuKousinTime(), "20160509141230000", "業務用更新時間");

        exNumericEquals(hubiMsgLst.get(2).getRenno(), 3, "連番");
        exStringEquals(hubiMsgLst.get(2).getMessageId(), "THC0152", "メッセージＩＤ");
        exStringEquals(hubiMsgLst.get(2).getHubimsg(), "【特認可能】契約単位給付日額が最高日額２の６，０００，０００．００ユーロをオーバーしています。", "不備メッセージ");
        exClassificationEquals(hubiMsgLst.get(2).getHubisyubetukbn(), C_HubisyubetuKbn.KETHORYU_HUBI, "不備種別区分");

        exNumericEquals(hubiMsgLst.get(3).getRenno(), 4, "連番");
        exStringEquals(hubiMsgLst.get(3).getMessageId(), "THC0153", "メッセージＩＤ");
        exStringEquals(hubiMsgLst.get(3).getHubimsg(), "【特認可能】契約単位給付日額が最高日額３の６，０００，０００．００ユーロをオーバーしています。", "不備メッセージ");
        exClassificationEquals(hubiMsgLst.get(3).getHubisyubetukbn(), C_HubisyubetuKbn.KETHORYU_HUBI, "不備種別区分");
    }
    @Test
    @TestOrder(19040)
    @Transactional
    public void testExec_S4() {
        MockObjectManager.initialize();
        BzGetAgInfoMockForSinkeiyaku.SYORIPTN = BzGetAgInfoMockForSinkeiyaku.TESTPATTERN4;
        KeisanGaikakanzanMockForSinkeiyaku.SYORIPTN = KeisanGaikakanzanMockForSinkeiyaku.TESTPATTERN1;
        SetKyuuhuNitigakuMockForSinkeiyaku.SYORIPTN = SetKyuuhuNitigakuMockForSinkeiyaku.TESTPATTERN3;
        GetKiteiCheckYenkansangkMockForSinkeiyaku.SYORIPTN = GetKiteiCheckYenkansangkMockForSinkeiyaku.TESTPATTERN1;
        CheckSaiteiPMockForSinkeiyaku.SYORIPTN = CheckSaiteiPMockForSinkeiyaku.TESTPATTERN1;
        CheckTblMosSyouhin checkTblMosSyouhin = SWAKInjector.getInstance(CheckTblMosSyouhin.class);

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("860001643");
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

        exNumericEquals(hubiMsgLst.size(), 4, "不備メッセージテーブルエンティティリストのサイズ");

        exStringEquals(hubiMsgLst.get(1).getMosno(), "860001643", "申込番号");
        exNumericEquals(hubiMsgLst.get(1).getRenno(), 2, "連番");
        exStringEquals(hubiMsgLst.get(1).getMessageId(), "KHC0151", "メッセージＩＤ");
        exStringEquals(hubiMsgLst.get(1).getHubimsg(), "（特認済）契約単位給付日額が最高日額１の６，０００，０００．００ユーロをオーバーしています。", "不備メッセージ");
        exClassificationEquals(hubiMsgLst.get(1).getHubisyubetukbn(), C_HubisyubetuKbn.KETHORYU_HUBI, "不備種別区分");
        exStringEquals(hubiMsgLst.get(1).getGyoumuKousinsyaId(), "JUnitTest", "業務用更新者ＩＤ");
        exStringEquals(hubiMsgLst.get(1).getGyoumuKousinTime(), "20160509141230000", "業務用更新時間");

        exNumericEquals(hubiMsgLst.get(2).getRenno(), 3, "連番");
        exStringEquals(hubiMsgLst.get(2).getMessageId(), "KHC0152", "メッセージＩＤ");
        exStringEquals(hubiMsgLst.get(2).getHubimsg(), "（特認済）契約単位給付日額が最高日額２の６，０００，０００．００ユーロをオーバーしています。", "不備メッセージ");
        exClassificationEquals(hubiMsgLst.get(2).getHubisyubetukbn(), C_HubisyubetuKbn.KETHORYU_HUBI, "不備種別区分");

        exNumericEquals(hubiMsgLst.get(3).getRenno(), 4, "連番");
        exStringEquals(hubiMsgLst.get(3).getMessageId(), "KHC0153", "メッセージＩＤ");
        exStringEquals(hubiMsgLst.get(3).getHubimsg(), "（特認済）契約単位給付日額が最高日額３の６，０００，０００．００ユーロをオーバーしています。", "不備メッセージ");
        exClassificationEquals(hubiMsgLst.get(3).getHubisyubetukbn(), C_HubisyubetuKbn.KETHORYU_HUBI, "不備種別区分");
    }
    @Test
    @TestOrder(19050)
    @Transactional
    public void testExec_S5() {
        MockObjectManager.initialize();
        BzGetAgInfoMockForSinkeiyaku.SYORIPTN = BzGetAgInfoMockForSinkeiyaku.TESTPATTERN4;
        KeisanGaikakanzanMockForSinkeiyaku.SYORIPTN = KeisanGaikakanzanMockForSinkeiyaku.TESTPATTERN1;
        SetKyuuhuNitigakuMockForSinkeiyaku.SYORIPTN = SetKyuuhuNitigakuMockForSinkeiyaku.TESTPATTERN4;
        GetKiteiCheckYenkansangkMockForSinkeiyaku.SYORIPTN = GetKiteiCheckYenkansangkMockForSinkeiyaku.TESTPATTERN1;
        CheckSaiteiPMockForSinkeiyaku.SYORIPTN = CheckSaiteiPMockForSinkeiyaku.TESTPATTERN1;
        CheckTblMosSyouhin checkTblMosSyouhin = SWAKInjector.getInstance(CheckTblMosSyouhin.class);

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("860001650");
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

        checkTblMosSyouhin.exec(mosnaiCheckParam);

        List<HT_HubiMsg> hubiMsgLst = mosnaiCheckParam.getListHubiMsg();

        exNumericEquals(hubiMsgLst.size(), 1, "不備メッセージテーブルエンティティリストのサイズ");
        exStringEquals(hubiMsgLst.get(0).getMosno(), "860001650", "申込番号");
        exNumericEquals(hubiMsgLst.get(0).getRenno(), 1, "連番");
        exStringEquals(hubiMsgLst.get(0).getMessageId(), "EBC0046", "メッセージＩＤ");
        exStringEquals(hubiMsgLst.get(0).getHubimsg(), "据置期間が正しくありません。", "不備メッセージ");
        exClassificationEquals(hubiMsgLst.get(0).getHubisyubetukbn(), C_HubisyubetuKbn.KETHORYU_HUBI, "不備種別区分");
        exClassificationEquals(hubiMsgLst.get(0).getHubisyubetusyousaikbn(), C_HubisyubetusyousaiKbn.NONE,
            "不備種別詳細区分");
    }

    @Test
    @TestOrder(19070)
    @Transactional
    public void testExec_S7() {
        MockObjectManager.initialize();
        BzGetAgInfoMockForSinkeiyaku.SYORIPTN = BzGetAgInfoMockForSinkeiyaku.TESTPATTERN4;
        KeisanGaikakanzanMockForSinkeiyaku.SYORIPTN = KeisanGaikakanzanMockForSinkeiyaku.TESTPATTERN1;
        SetKyuuhuNitigakuMockForSinkeiyaku.SYORIPTN = SetKyuuhuNitigakuMockForSinkeiyaku.TESTPATTERN5;
        GetKiteiCheckYenkansangkMockForSinkeiyaku.SYORIPTN = GetKiteiCheckYenkansangkMockForSinkeiyaku.TESTPATTERN1;
        CheckSaiteiPMockForSinkeiyaku.SYORIPTN = CheckSaiteiPMockForSinkeiyaku.TESTPATTERN1;
        CheckTblMosSyouhin checkTblMosSyouhin = SWAKInjector.getInstance(CheckTblMosSyouhin.class);

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("980000079");
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

        exClassificationEquals(mosnaiCheckParam.getSekmossakuseiErroutKbn(), C_SekmossakuseiErroutKbn.GAMEN, "設計書申込書作成エラー出力区分");
        exStringEquals(mosnaiCheckParam.getSekmossakuseiErrmsg1(), "給付日額が最高日額の６，０００，０００．００ユーロをオーバーしています。（ＮＵＬ", "設計書申込書作成エラーメッセージ１");
        exStringEquals(mosnaiCheckParam.getSekmossakuseiErrmsg2(), "Ｌ＋ＮＵＬＬ＋ＮＵＬＬ）", "設計書申込書作成エラーメッセージ２");
        exClassificationEquals(mosnaiCheckParam.getKouzokuSyoriJikkouKbn(), C_KouzokujkKbn.NONE, "後続処理実行区分");
    }

    @Test
    @TestOrder(19080)
    @Transactional
    public void testExec_S8() {
        MockObjectManager.initialize();
        BzGetAgInfoMockForSinkeiyaku.SYORIPTN = BzGetAgInfoMockForSinkeiyaku.TESTPATTERN4;
        KeisanGaikakanzanMockForSinkeiyaku.SYORIPTN = KeisanGaikakanzanMockForSinkeiyaku.TESTPATTERN1;
        SetKyuuhuNitigakuMockForSinkeiyaku.SYORIPTN = SetKyuuhuNitigakuMockForSinkeiyaku.TESTPATTERN6;
        GetKiteiCheckYenkansangkMockForSinkeiyaku.SYORIPTN = GetKiteiCheckYenkansangkMockForSinkeiyaku.TESTPATTERN1;
        CheckSaiteiPMockForSinkeiyaku.SYORIPTN = CheckSaiteiPMockForSinkeiyaku.TESTPATTERN1;
        CheckTblMosSyouhin checkTblMosSyouhin = SWAKInjector.getInstance(CheckTblMosSyouhin.class);

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("980000087");
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

        exClassificationEquals(mosnaiCheckParam.getSekmossakuseiErroutKbn(), C_SekmossakuseiErroutKbn.GAMEN, "設計書申込書作成エラー出力区分");
        exStringEquals(mosnaiCheckParam.getSekmossakuseiErrmsg1(), "給付日額が最高日額の６，０００，０００．００ユーロをオーバーしています。（ＮＵＬ", "設計書申込書作成エラーメッセージ１");
        exStringEquals(mosnaiCheckParam.getSekmossakuseiErrmsg2(), "Ｌ＋ＮＵＬＬ＋ＮＵＬＬ＋ＮＵＬＬ）", "設計書申込書作成エラーメッセージ２");
        exClassificationEquals(mosnaiCheckParam.getKouzokuSyoriJikkouKbn(), C_KouzokujkKbn.NONE, "後続処理実行区分");
    }
    @Test
    @TestOrder(20010)
    @Transactional
    public void testExec_T1() {
        MockObjectManager.initialize();
        BzGetAgInfoMockForSinkeiyaku.SYORIPTN = BzGetAgInfoMockForSinkeiyaku.TESTPATTERN4;
        KeisanGaikakanzanMockForSinkeiyaku.SYORIPTN = KeisanGaikakanzanMockForSinkeiyaku.TESTPATTERN1;
        SetKyuuhuNitigakuMockForSinkeiyaku.SYORIPTN = SetKyuuhuNitigakuMockForSinkeiyaku.TESTPATTERN7;
        GetKiteiCheckYenkansangkMockForSinkeiyaku.SYORIPTN = GetKiteiCheckYenkansangkMockForSinkeiyaku.TESTPATTERN1;
        CheckSaiteiPMockForSinkeiyaku.SYORIPTN = CheckSaiteiPMockForSinkeiyaku.TESTPATTERN1;
        CheckTblMosSyouhin checkTblMosSyouhin = SWAKInjector.getInstance(CheckTblMosSyouhin.class);

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("860001668");
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

        checkTblMosSyouhin.exec(mosnaiCheckParam);

        List<HT_HubiMsg> hubiMsgLst = mosnaiCheckParam.getListHubiMsg();

        exNumericEquals(hubiMsgLst.size(), 1, "不備メッセージテーブルエンティティリストのサイズ");
        exStringEquals(hubiMsgLst.get(0).getMosno(), "860001668", "申込番号");
        exNumericEquals(hubiMsgLst.get(0).getRenno(), 1, "連番");
        exStringEquals(hubiMsgLst.get(0).getMessageId(), "EBC0046", "メッセージＩＤ");
        exStringEquals(hubiMsgLst.get(0).getHubimsg(), "据置期間が正しくありません。", "不備メッセージ");
        exClassificationEquals(hubiMsgLst.get(0).getHubisyubetukbn(), C_HubisyubetuKbn.KETHORYU_HUBI, "不備種別区分");
        exClassificationEquals(hubiMsgLst.get(0).getHubisyubetusyousaikbn(), C_HubisyubetusyousaiKbn.NONE,
            "不備種別詳細区分");
    }
    @Test
    @TestOrder(20020)
    @Transactional
    public void testExec_T2() {
        MockObjectManager.initialize();
        BzGetAgInfoMockForSinkeiyaku.SYORIPTN = BzGetAgInfoMockForSinkeiyaku.TESTPATTERN4;
        KeisanGaikakanzanMockForSinkeiyaku.SYORIPTN = KeisanGaikakanzanMockForSinkeiyaku.TESTPATTERN1;
        SetKyuuhuNitigakuMockForSinkeiyaku.SYORIPTN = SetKyuuhuNitigakuMockForSinkeiyaku.TESTPATTERN7;
        GetKiteiCheckYenkansangkMockForSinkeiyaku.SYORIPTN = GetKiteiCheckYenkansangkMockForSinkeiyaku.TESTPATTERN1;
        CheckSaiteiPMockForSinkeiyaku.SYORIPTN = CheckSaiteiPMockForSinkeiyaku.TESTPATTERN1;
        CheckTblMosSyouhin checkTblMosSyouhin = SWAKInjector.getInstance(CheckTblMosSyouhin.class);

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("860001676");
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

        checkTblMosSyouhin.exec(mosnaiCheckParam);

        List<HT_HubiMsg> hubiMsgLst = mosnaiCheckParam.getListHubiMsg();

        exNumericEquals(hubiMsgLst.size(), 1, "不備メッセージテーブルエンティティリストのサイズ");
        exStringEquals(hubiMsgLst.get(0).getMosno(), "860001676", "申込番号");
        exNumericEquals(hubiMsgLst.get(0).getRenno(), 1, "連番");
        exStringEquals(hubiMsgLst.get(0).getMessageId(), "EBC0046", "メッセージＩＤ");
        exStringEquals(hubiMsgLst.get(0).getHubimsg(), "据置期間が正しくありません。", "不備メッセージ");
        exClassificationEquals(hubiMsgLst.get(0).getHubisyubetukbn(), C_HubisyubetuKbn.KETHORYU_HUBI, "不備種別区分");
        exClassificationEquals(hubiMsgLst.get(0).getHubisyubetusyousaikbn(), C_HubisyubetusyousaiKbn.NONE,
            "不備種別詳細区分");
    }
    @Test
    @TestOrder(20030)
    @Transactional
    public void testExec_T3() {
        MockObjectManager.initialize();
        BzGetAgInfoMockForSinkeiyaku.SYORIPTN = BzGetAgInfoMockForSinkeiyaku.TESTPATTERN4;
        KeisanGaikakanzanMockForSinkeiyaku.SYORIPTN = KeisanGaikakanzanMockForSinkeiyaku.TESTPATTERN1;
        SetKyuuhuNitigakuMockForSinkeiyaku.SYORIPTN = SetKyuuhuNitigakuMockForSinkeiyaku.TESTPATTERN7;
        GetKiteiCheckYenkansangkMockForSinkeiyaku.SYORIPTN = GetKiteiCheckYenkansangkMockForSinkeiyaku.TESTPATTERN1;
        CheckSaiteiPMockForSinkeiyaku.SYORIPTN = CheckSaiteiPMockForSinkeiyaku.TESTPATTERN1;
        CheckTblMosSyouhin checkTblMosSyouhin = SWAKInjector.getInstance(CheckTblMosSyouhin.class);

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("860001684");
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

        checkTblMosSyouhin.exec(mosnaiCheckParam);

        List<HT_HubiMsg> hubiMsgLst = mosnaiCheckParam.getListHubiMsg();

        exNumericEquals(hubiMsgLst.size(), 1, "不備メッセージテーブルエンティティリストのサイズ");
        exStringEquals(hubiMsgLst.get(0).getMosno(), "860001684", "申込番号");
        exNumericEquals(hubiMsgLst.get(0).getRenno(), 1, "連番");
        exStringEquals(hubiMsgLst.get(0).getMessageId(), "EBC0046", "メッセージＩＤ");
        exStringEquals(hubiMsgLst.get(0).getHubimsg(), "据置期間が正しくありません。", "不備メッセージ");
        exClassificationEquals(hubiMsgLst.get(0).getHubisyubetukbn(), C_HubisyubetuKbn.KETHORYU_HUBI, "不備種別区分");
        exClassificationEquals(hubiMsgLst.get(0).getHubisyubetusyousaikbn(), C_HubisyubetusyousaiKbn.NONE,
            "不備種別詳細区分");
    }
    @Test
    @TestOrder(20040)
    @Transactional
    public void testExec_T4() {
        MockObjectManager.initialize();
        BzGetAgInfoMockForSinkeiyaku.SYORIPTN = BzGetAgInfoMockForSinkeiyaku.TESTPATTERN4;
        KeisanGaikakanzanMockForSinkeiyaku.SYORIPTN = KeisanGaikakanzanMockForSinkeiyaku.TESTPATTERN1;
        SetKyuuhuNitigakuMockForSinkeiyaku.SYORIPTN = SetKyuuhuNitigakuMockForSinkeiyaku.TESTPATTERN2;
        GetKiteiCheckYenkansangkMockForSinkeiyaku.SYORIPTN = GetKiteiCheckYenkansangkMockForSinkeiyaku.TESTPATTERN1;
        CheckSaiteiPMockForSinkeiyaku.SYORIPTN = CheckSaiteiPMockForSinkeiyaku.TESTPATTERN1;
        CheckTblMosSyouhin checkTblMosSyouhin = SWAKInjector.getInstance(CheckTblMosSyouhin.class);

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("860001692");
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

        exNumericEquals(hubiMsgLst.size(), 2, "不備メッセージテーブルエンティティリストのサイズ");

        exStringEquals(hubiMsgLst.get(1).getMosno(), "860001692", "申込番号");
        exNumericEquals(hubiMsgLst.get(1).getRenno(), 2, "連番");
        exStringEquals(hubiMsgLst.get(1).getMessageId(), "THC0155", "メッセージＩＤ");
        exStringEquals(hubiMsgLst.get(1).getHubimsg(), "【特認可能】契約単位給付日額が告知上限日額の５，０００，０００．００ユーロをオーバーしています。", "不備メッセージ");
        exClassificationEquals(hubiMsgLst.get(1).getHubisyubetukbn(), C_HubisyubetuKbn.KETHORYU_HUBI, "不備種別区分");
        exStringEquals(hubiMsgLst.get(1).getGyoumuKousinsyaId(), "JUnitTest", "業務用更新者ＩＤ");
        exStringEquals(hubiMsgLst.get(1).getGyoumuKousinTime(), "20160509141230000", "業務用更新時間");
    }
    @Test
    @TestOrder(20050)
    @Transactional
    public void testExec_T5() {
        MockObjectManager.initialize();
        BzGetAgInfoMockForSinkeiyaku.SYORIPTN = BzGetAgInfoMockForSinkeiyaku.TESTPATTERN4;
        KeisanGaikakanzanMockForSinkeiyaku.SYORIPTN = KeisanGaikakanzanMockForSinkeiyaku.TESTPATTERN1;
        SetKyuuhuNitigakuMockForSinkeiyaku.SYORIPTN = SetKyuuhuNitigakuMockForSinkeiyaku.TESTPATTERN2;
        GetKiteiCheckYenkansangkMockForSinkeiyaku.SYORIPTN = GetKiteiCheckYenkansangkMockForSinkeiyaku.TESTPATTERN1;
        CheckSaiteiPMockForSinkeiyaku.SYORIPTN = CheckSaiteiPMockForSinkeiyaku.TESTPATTERN1;
        CheckTblMosSyouhin checkTblMosSyouhin = SWAKInjector.getInstance(CheckTblMosSyouhin.class);

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("860001700");
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

        exNumericEquals(hubiMsgLst.size(), 2, "不備メッセージテーブルエンティティリストのサイズ");

        exStringEquals(hubiMsgLst.get(1).getMosno(), "860001700", "申込番号");
        exNumericEquals(hubiMsgLst.get(1).getRenno(), 2, "連番");
        exStringEquals(hubiMsgLst.get(1).getMessageId(), "KHC0155", "メッセージＩＤ");
        exStringEquals(hubiMsgLst.get(1).getHubimsg(), "（特認済）契約単位給付日額が告知上限日額の５，０００，０００．００ユーロをオーバーしています。", "不備メッセージ");
        exClassificationEquals(hubiMsgLst.get(1).getHubisyubetukbn(), C_HubisyubetuKbn.KETHORYU_HUBI, "不備種別区分");
        exStringEquals(hubiMsgLst.get(1).getGyoumuKousinsyaId(), "JUnitTest", "業務用更新者ＩＤ");
        exStringEquals(hubiMsgLst.get(1).getGyoumuKousinTime(), "20160509141230000", "業務用更新時間");
    }
    @Test
    @TestOrder(20060)
    @Transactional
    public void testExec_T6() {
        MockObjectManager.initialize();
        BzGetAgInfoMockForSinkeiyaku.SYORIPTN = BzGetAgInfoMockForSinkeiyaku.TESTPATTERN4;
        KeisanGaikakanzanMockForSinkeiyaku.SYORIPTN = KeisanGaikakanzanMockForSinkeiyaku.TESTPATTERN1;
        SetKyuuhuNitigakuMockForSinkeiyaku.SYORIPTN = SetKyuuhuNitigakuMockForSinkeiyaku.TESTPATTERN2;
        GetKiteiCheckYenkansangkMockForSinkeiyaku.SYORIPTN = GetKiteiCheckYenkansangkMockForSinkeiyaku.TESTPATTERN1;
        CheckSaiteiPMockForSinkeiyaku.SYORIPTN = CheckSaiteiPMockForSinkeiyaku.TESTPATTERN1;
        CheckTblMosSyouhin checkTblMosSyouhin = SWAKInjector.getInstance(CheckTblMosSyouhin.class);

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("860001718");
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

        exClassificationEquals(mosnaiCheckParam.getSekmossakuseiErroutKbn(), C_SekmossakuseiErroutKbn.GAMEN, "設計書申込書作成エラー出力区分");
        exStringEquals(mosnaiCheckParam.getSekmossakuseiErrmsg1(), "告知書での取扱上限を超えているため、健康診断書の提出をご案内ください。（告知上限", "設計書申込書作成エラーメッセージ１");
        exStringEquals(mosnaiCheckParam.getSekmossakuseiErrmsg2(), "Ｓオーバー）", "設計書申込書作成エラーメッセージ２");
        exClassificationEquals(mosnaiCheckParam.getKouzokuSyoriJikkouKbn(), C_KouzokujkKbn.NONE, "後続処理実行区分");
    }
    @Test
    @TestOrder(21010)
    @Transactional
    public void testExec_U1() {
        MockObjectManager.initialize();
        BzGetAgInfoMockForSinkeiyaku.SYORIPTN = BzGetAgInfoMockForSinkeiyaku.TESTPATTERN4;
        KeisanGaikakanzanMockForSinkeiyaku.SYORIPTN = KeisanGaikakanzanMockForSinkeiyaku.TESTPATTERN1;
        GetKiteiCheckYenkansangkMockForSinkeiyaku.SYORIPTN = GetKiteiCheckYenkansangkMockForSinkeiyaku.TESTPATTERN1;
        CheckSaiteiPMockForSinkeiyaku.SYORIPTN = CheckSaiteiPMockForSinkeiyaku.TESTPATTERN1;
        CheckTblMosSyouhin checkTblMosSyouhin = SWAKInjector.getInstance(CheckTblMosSyouhin.class);

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("860001726");
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

        checkTblMosSyouhin.exec(mosnaiCheckParam);

        List<HT_HubiMsg> hubiMsgLst = mosnaiCheckParam.getListHubiMsg();

        exNumericEquals(hubiMsgLst.size(), 1, "不備メッセージテーブルエンティティリストのサイズ");
        exStringEquals(hubiMsgLst.get(0).getMosno(), "860001726", "申込番号");
        exNumericEquals(hubiMsgLst.get(0).getRenno(), 1, "連番");
        exStringEquals(hubiMsgLst.get(0).getMessageId(), "EBC0046", "メッセージＩＤ");
        exStringEquals(hubiMsgLst.get(0).getHubimsg(), "据置期間が正しくありません。", "不備メッセージ");
        exClassificationEquals(hubiMsgLst.get(0).getHubisyubetukbn(), C_HubisyubetuKbn.KETHORYU_HUBI, "不備種別区分");
        exClassificationEquals(hubiMsgLst.get(0).getHubisyubetusyousaikbn(), C_HubisyubetusyousaiKbn.NONE,
            "不備種別詳細区分");
    }
    @Test
    @TestOrder(21020)
    @Transactional
    public void testExec_U2() {
        MockObjectManager.initialize();
        BzGetAgInfoMockForSinkeiyaku.SYORIPTN = BzGetAgInfoMockForSinkeiyaku.TESTPATTERN4;
        KeisanGaikakanzanMockForSinkeiyaku.SYORIPTN = KeisanGaikakanzanMockForSinkeiyaku.TESTPATTERN1;
        GetKiteiCheckYenkansangkMockForSinkeiyaku.SYORIPTN = GetKiteiCheckYenkansangkMockForSinkeiyaku.TESTPATTERN1;
        CheckSaiteiPMockForSinkeiyaku.SYORIPTN = CheckSaiteiPMockForSinkeiyaku.TESTPATTERN1;
        CheckTblMosSyouhin checkTblMosSyouhin = SWAKInjector.getInstance(CheckTblMosSyouhin.class);

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("860001734");
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

        checkTblMosSyouhin.exec(mosnaiCheckParam);

        List<HT_HubiMsg> hubiMsgLst = mosnaiCheckParam.getListHubiMsg();

        exNumericEquals(hubiMsgLst.size(), 1, "不備メッセージテーブルエンティティリストのサイズ");
        exStringEquals(hubiMsgLst.get(0).getMosno(), "860001734", "申込番号");
        exNumericEquals(hubiMsgLst.get(0).getRenno(), 1, "連番");
        exStringEquals(hubiMsgLst.get(0).getMessageId(), "EBC0046", "メッセージＩＤ");
        exStringEquals(hubiMsgLst.get(0).getHubimsg(), "据置期間が正しくありません。", "不備メッセージ");
        exClassificationEquals(hubiMsgLst.get(0).getHubisyubetukbn(), C_HubisyubetuKbn.KETHORYU_HUBI, "不備種別区分");
        exClassificationEquals(hubiMsgLst.get(0).getHubisyubetusyousaikbn(), C_HubisyubetusyousaiKbn.NONE,
            "不備種別詳細区分");
    }
    @Test
    @TestOrder(21030)
    @Transactional
    public void testExec_U3() {
        MockObjectManager.initialize();
        BzGetAgInfoMockForSinkeiyaku.SYORIPTN = BzGetAgInfoMockForSinkeiyaku.TESTPATTERN4;
        KeisanGaikakanzanMockForSinkeiyaku.SYORIPTN = KeisanGaikakanzanMockForSinkeiyaku.TESTPATTERN1;
        GetKiteiCheckYenkansangkMockForSinkeiyaku.SYORIPTN = GetKiteiCheckYenkansangkMockForSinkeiyaku.TESTPATTERN1;
        CheckSaiteiPMockForSinkeiyaku.SYORIPTN = CheckSaiteiPMockForSinkeiyaku.TESTPATTERN1;
        CheckTblMosSyouhin checkTblMosSyouhin = SWAKInjector.getInstance(CheckTblMosSyouhin.class);

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("860001742");
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

        exNumericEquals(hubiMsgLst.size(), 2, "不備メッセージテーブルエンティティリストのサイズ");

        exStringEquals(hubiMsgLst.get(1).getMosno(), "860001742", "申込番号");
        exNumericEquals(hubiMsgLst.get(1).getRenno(), 2, "連番");
        exStringEquals(hubiMsgLst.get(1).getMessageId(), "EHC0038", "メッセージＩＤ");
        exStringEquals(hubiMsgLst.get(1).getHubimsg(), "外貨建て一時払変額年金保険（ブレンド型）　年金原資最低保証１２５％の払込期間が取扱範囲外です。", "不備メッセージ");
        exClassificationEquals(hubiMsgLst.get(1).getHubisyubetukbn(), C_HubisyubetuKbn.KETHORYU_HUBI, "不備種別区分");
        exStringEquals(hubiMsgLst.get(1).getGyoumuKousinsyaId(), "JUnitTest", "業務用更新者ＩＤ");
        exStringEquals(hubiMsgLst.get(1).getGyoumuKousinTime(), "20160509141230000", "業務用更新時間");
    }
    @Test
    @TestOrder(21040)
    @Transactional
    public void testExec_U4() {
        MockObjectManager.initialize();
        BzGetAgInfoMockForSinkeiyaku.SYORIPTN = BzGetAgInfoMockForSinkeiyaku.TESTPATTERN4;
        KeisanGaikakanzanMockForSinkeiyaku.SYORIPTN = KeisanGaikakanzanMockForSinkeiyaku.TESTPATTERN1;
        GetKiteiCheckYenkansangkMockForSinkeiyaku.SYORIPTN = GetKiteiCheckYenkansangkMockForSinkeiyaku.TESTPATTERN1;
        CheckSaiteiPMockForSinkeiyaku.SYORIPTN = CheckSaiteiPMockForSinkeiyaku.TESTPATTERN1;
        CheckTblMosSyouhin checkTblMosSyouhin = SWAKInjector.getInstance(CheckTblMosSyouhin.class);

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("860001759");
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

        exNumericEquals(hubiMsgLst.size(), 2, "不備メッセージテーブルエンティティリストのサイズ");

        exStringEquals(hubiMsgLst.get(1).getMosno(), "860001759", "申込番号");
        exNumericEquals(hubiMsgLst.get(1).getRenno(), 2, "連番");
        exStringEquals(hubiMsgLst.get(1).getMessageId(), "EHC0038", "メッセージＩＤ");
        exStringEquals(hubiMsgLst.get(1).getHubimsg(), "外貨建て一時払変額年金保険（ブレンド型）　年金原資最低保証１２５％の保険期間が取扱範囲外です。", "不備メッセージ");
        exClassificationEquals(hubiMsgLst.get(1).getHubisyubetukbn(), C_HubisyubetuKbn.KETHORYU_HUBI, "不備種別区分");
        exStringEquals(hubiMsgLst.get(1).getGyoumuKousinsyaId(), "JUnitTest", "業務用更新者ＩＤ");
        exStringEquals(hubiMsgLst.get(1).getGyoumuKousinTime(), "20160509141230000", "業務用更新時間");
    }
    @Test
    @TestOrder(21050)
    @Transactional
    public void testExec_U5() {
        MockObjectManager.initialize();
        BzGetAgInfoMockForSinkeiyaku.SYORIPTN = BzGetAgInfoMockForSinkeiyaku.TESTPATTERN4;
        KeisanGaikakanzanMockForSinkeiyaku.SYORIPTN = KeisanGaikakanzanMockForSinkeiyaku.TESTPATTERN1;
        GetKiteiCheckYenkansangkMockForSinkeiyaku.SYORIPTN = GetKiteiCheckYenkansangkMockForSinkeiyaku.TESTPATTERN1;
        CheckSaiteiPMockForSinkeiyaku.SYORIPTN = CheckSaiteiPMockForSinkeiyaku.TESTPATTERN1;
        CheckTblMosSyouhin checkTblMosSyouhin = SWAKInjector.getInstance(CheckTblMosSyouhin.class);

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("860001767");
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

        exNumericEquals(hubiMsgLst.size(), 2, "不備メッセージテーブルエンティティリストのサイズ");

        exStringEquals(hubiMsgLst.get(1).getMosno(), "860001767", "申込番号");
        exNumericEquals(hubiMsgLst.get(1).getRenno(), 2, "連番");
        exStringEquals(hubiMsgLst.get(1).getMessageId(), "EHC0038", "メッセージＩＤ");
        exStringEquals(hubiMsgLst.get(1).getHubimsg(), "外貨建て一時払変額年金保険（ブレンド型）　年金原資最低保証１２５％の保険期間が取扱範囲外です。", "不備メッセージ");
        exClassificationEquals(hubiMsgLst.get(1).getHubisyubetukbn(), C_HubisyubetuKbn.KETHORYU_HUBI, "不備種別区分");
        exStringEquals(hubiMsgLst.get(1).getGyoumuKousinsyaId(), "JUnitTest", "業務用更新者ＩＤ");
        exStringEquals(hubiMsgLst.get(1).getGyoumuKousinTime(), "20160509141230000", "業務用更新時間");
    }
    @Test
    @TestOrder(21060)
    @Transactional
    public void testExec_U6() {
        MockObjectManager.initialize();
        BzGetAgInfoMockForSinkeiyaku.SYORIPTN = BzGetAgInfoMockForSinkeiyaku.TESTPATTERN4;
        KeisanGaikakanzanMockForSinkeiyaku.SYORIPTN = KeisanGaikakanzanMockForSinkeiyaku.TESTPATTERN1;
        GetKiteiCheckYenkansangkMockForSinkeiyaku.SYORIPTN = GetKiteiCheckYenkansangkMockForSinkeiyaku.TESTPATTERN1;
        CheckSaiteiPMockForSinkeiyaku.SYORIPTN = CheckSaiteiPMockForSinkeiyaku.TESTPATTERN1;
        CheckTblMosSyouhin checkTblMosSyouhin = SWAKInjector.getInstance(CheckTblMosSyouhin.class);

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("860001775");
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

        checkTblMosSyouhin.exec(mosnaiCheckParam);

        List<HT_HubiMsg> hubiMsgLst = mosnaiCheckParam.getListHubiMsg();

        exNumericEquals(hubiMsgLst.size(), 1, "不備メッセージテーブルエンティティリストのサイズ");
        exStringEquals(hubiMsgLst.get(0).getMosno(), "860001775", "申込番号");
        exNumericEquals(hubiMsgLst.get(0).getRenno(), 1, "連番");
        exStringEquals(hubiMsgLst.get(0).getMessageId(), "EBC0046", "メッセージＩＤ");
        exStringEquals(hubiMsgLst.get(0).getHubimsg(), "据置期間が正しくありません。", "不備メッセージ");
        exClassificationEquals(hubiMsgLst.get(0).getHubisyubetukbn(), C_HubisyubetuKbn.KETHORYU_HUBI, "不備種別区分");
        exClassificationEquals(hubiMsgLst.get(0).getHubisyubetusyousaikbn(), C_HubisyubetusyousaiKbn.NONE,
            "不備種別詳細区分");
    }
    @Test
    @TestOrder(21070)
    @Transactional
    public void testExec_U7() {
        MockObjectManager.initialize();
        BzGetAgInfoMockForSinkeiyaku.SYORIPTN = BzGetAgInfoMockForSinkeiyaku.TESTPATTERN4;
        KeisanGaikakanzanMockForSinkeiyaku.SYORIPTN = KeisanGaikakanzanMockForSinkeiyaku.TESTPATTERN1;
        GetKiteiCheckYenkansangkMockForSinkeiyaku.SYORIPTN = GetKiteiCheckYenkansangkMockForSinkeiyaku.TESTPATTERN1;
        CheckSaiteiPMockForSinkeiyaku.SYORIPTN = CheckSaiteiPMockForSinkeiyaku.TESTPATTERN1;
        CheckTblMosSyouhin checkTblMosSyouhin = SWAKInjector.getInstance(CheckTblMosSyouhin.class);

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("860001783");
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

        checkTblMosSyouhin.exec(mosnaiCheckParam);

        List<HT_HubiMsg> hubiMsgLst = mosnaiCheckParam.getListHubiMsg();

        exNumericEquals(hubiMsgLst.size(), 1, "不備メッセージテーブルエンティティリストのサイズ");
        exStringEquals(hubiMsgLst.get(0).getMosno(), "860001783", "申込番号");
        exNumericEquals(hubiMsgLst.get(0).getRenno(), 1, "連番");
        exStringEquals(hubiMsgLst.get(0).getMessageId(), "EBC0046", "メッセージＩＤ");
        exStringEquals(hubiMsgLst.get(0).getHubimsg(), "据置期間が正しくありません。", "不備メッセージ");
        exClassificationEquals(hubiMsgLst.get(0).getHubisyubetukbn(), C_HubisyubetuKbn.KETHORYU_HUBI, "不備種別区分");
        exClassificationEquals(hubiMsgLst.get(0).getHubisyubetusyousaikbn(), C_HubisyubetusyousaiKbn.NONE,
            "不備種別詳細区分");
    }
    @Test
    @TestOrder(21080)
    @Transactional
    public void testExec_U8() {
        MockObjectManager.initialize();
        BzGetAgInfoMockForSinkeiyaku.SYORIPTN = BzGetAgInfoMockForSinkeiyaku.TESTPATTERN4;
        KeisanGaikakanzanMockForSinkeiyaku.SYORIPTN = KeisanGaikakanzanMockForSinkeiyaku.TESTPATTERN1;
        GetKiteiCheckYenkansangkMockForSinkeiyaku.SYORIPTN = GetKiteiCheckYenkansangkMockForSinkeiyaku.TESTPATTERN1;
        CheckSaiteiPMockForSinkeiyaku.SYORIPTN = CheckSaiteiPMockForSinkeiyaku.TESTPATTERN1;
        CheckTblMosSyouhin checkTblMosSyouhin = SWAKInjector.getInstance(CheckTblMosSyouhin.class);

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("860001791");
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

        exNumericEquals(hubiMsgLst.size(), 2, "不備メッセージテーブルエンティティリストのサイズ");

        exStringEquals(hubiMsgLst.get(1).getMosno(), "860001791", "申込番号");
        exNumericEquals(hubiMsgLst.get(1).getRenno(), 2, "連番");
        exStringEquals(hubiMsgLst.get(1).getMessageId(), "EHC0038", "メッセージＩＤ");
        exStringEquals(hubiMsgLst.get(1).getHubimsg(), "外貨建て一時払変額年金保険（ブレンド型）　年金原資最低保証１２５％の払込期間が取扱範囲外です。", "不備メッセージ");
        exClassificationEquals(hubiMsgLst.get(1).getHubisyubetukbn(), C_HubisyubetuKbn.KETHORYU_HUBI, "不備種別区分");
        exStringEquals(hubiMsgLst.get(1).getGyoumuKousinsyaId(), "JUnitTest", "業務用更新者ＩＤ");
        exStringEquals(hubiMsgLst.get(1).getGyoumuKousinTime(), "20160509141230000", "業務用更新時間");
    }
    @Test
    @TestOrder(21090)
    @Transactional
    public void testExec_U9() {
        MockObjectManager.initialize();
        BzGetAgInfoMockForSinkeiyaku.SYORIPTN = BzGetAgInfoMockForSinkeiyaku.TESTPATTERN4;
        KeisanGaikakanzanMockForSinkeiyaku.SYORIPTN = KeisanGaikakanzanMockForSinkeiyaku.TESTPATTERN1;
        GetKiteiCheckYenkansangkMockForSinkeiyaku.SYORIPTN = GetKiteiCheckYenkansangkMockForSinkeiyaku.TESTPATTERN1;
        CheckSaiteiPMockForSinkeiyaku.SYORIPTN = CheckSaiteiPMockForSinkeiyaku.TESTPATTERN1;
        CheckTblMosSyouhin checkTblMosSyouhin = SWAKInjector.getInstance(CheckTblMosSyouhin.class);

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("860001809");
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

        exNumericEquals(hubiMsgLst.size(), 2, "不備メッセージテーブルエンティティリストのサイズ");

        exStringEquals(hubiMsgLst.get(1).getMosno(), "860001809", "申込番号");
        exNumericEquals(hubiMsgLst.get(1).getRenno(), 2, "連番");
        exStringEquals(hubiMsgLst.get(1).getMessageId(), "EHC0038", "メッセージＩＤ");
        exStringEquals(hubiMsgLst.get(1).getHubimsg(), "外貨建て一時払変額年金保険（ブレンド型）　年金原資最低保証１２５％の払込期間が取扱範囲外です。", "不備メッセージ");
        exClassificationEquals(hubiMsgLst.get(1).getHubisyubetukbn(), C_HubisyubetuKbn.KETHORYU_HUBI, "不備種別区分");
        exStringEquals(hubiMsgLst.get(1).getGyoumuKousinsyaId(), "JUnitTest", "業務用更新者ＩＤ");
        exStringEquals(hubiMsgLst.get(1).getGyoumuKousinTime(), "20160509141230000", "業務用更新時間");
    }
    @Test
    @TestOrder(21100)
    @Transactional
    public void testExec_U10() {
        MockObjectManager.initialize();
        BzGetAgInfoMockForSinkeiyaku.SYORIPTN = BzGetAgInfoMockForSinkeiyaku.TESTPATTERN4;
        KeisanGaikakanzanMockForSinkeiyaku.SYORIPTN = KeisanGaikakanzanMockForSinkeiyaku.TESTPATTERN1;
        GetKiteiCheckYenkansangkMockForSinkeiyaku.SYORIPTN = GetKiteiCheckYenkansangkMockForSinkeiyaku.TESTPATTERN1;
        CheckSaiteiPMockForSinkeiyaku.SYORIPTN = CheckSaiteiPMockForSinkeiyaku.TESTPATTERN1;
        CheckTblMosSyouhin checkTblMosSyouhin = SWAKInjector.getInstance(CheckTblMosSyouhin.class);

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("860001817");
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

        checkTblMosSyouhin.exec(mosnaiCheckParam);

        List<HT_HubiMsg> hubiMsgLst = mosnaiCheckParam.getListHubiMsg();

        exNumericEquals(hubiMsgLst.size(), 1, "不備メッセージテーブルエンティティリストのサイズ");
        exStringEquals(hubiMsgLst.get(0).getMosno(), "860001817", "申込番号");
        exNumericEquals(hubiMsgLst.get(0).getRenno(), 1, "連番");
        exStringEquals(hubiMsgLst.get(0).getMessageId(), "EBC0046", "メッセージＩＤ");
        exStringEquals(hubiMsgLst.get(0).getHubimsg(), "据置期間が正しくありません。", "不備メッセージ");
        exClassificationEquals(hubiMsgLst.get(0).getHubisyubetukbn(), C_HubisyubetuKbn.KETHORYU_HUBI, "不備種別区分");
        exClassificationEquals(hubiMsgLst.get(0).getHubisyubetusyousaikbn(), C_HubisyubetusyousaiKbn.NONE,
            "不備種別詳細区分");
    }
    @Test
    @TestOrder(21110)
    @Transactional
    public void testExec_U11() {
        MockObjectManager.initialize();
        BzGetAgInfoMockForSinkeiyaku.SYORIPTN = BzGetAgInfoMockForSinkeiyaku.TESTPATTERN4;
        KeisanGaikakanzanMockForSinkeiyaku.SYORIPTN = KeisanGaikakanzanMockForSinkeiyaku.TESTPATTERN1;
        GetKiteiCheckYenkansangkMockForSinkeiyaku.SYORIPTN = GetKiteiCheckYenkansangkMockForSinkeiyaku.TESTPATTERN1;
        CheckSaiteiPMockForSinkeiyaku.SYORIPTN = CheckSaiteiPMockForSinkeiyaku.TESTPATTERN1;
        CheckTblMosSyouhin checkTblMosSyouhin = SWAKInjector.getInstance(CheckTblMosSyouhin.class);

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("860001825");
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

        exNumericEquals(hubiMsgLst.size(), 2, "不備メッセージテーブルエンティティリストのサイズ");

        exStringEquals(hubiMsgLst.get(1).getMosno(), "860001825", "申込番号");
        exNumericEquals(hubiMsgLst.get(1).getRenno(), 2, "連番");
        exStringEquals(hubiMsgLst.get(1).getMessageId(), "EHC0038", "メッセージＩＤ");
        exStringEquals(hubiMsgLst.get(1).getHubimsg(), "外貨建て一時払変額年金保険（ブレンド型）　年金原資最低保証１２５％の払込期間が取扱範囲外です。", "不備メッセージ");
        exClassificationEquals(hubiMsgLst.get(1).getHubisyubetukbn(), C_HubisyubetuKbn.KETHORYU_HUBI, "不備種別区分");
        exStringEquals(hubiMsgLst.get(1).getGyoumuKousinsyaId(), "JUnitTest", "業務用更新者ＩＤ");
        exStringEquals(hubiMsgLst.get(1).getGyoumuKousinTime(), "20160509141230000", "業務用更新時間");
    }
    @Test
    @TestOrder(21120)
    @Transactional
    public void testExec_U12() {
        MockObjectManager.initialize();
        BzGetAgInfoMockForSinkeiyaku.SYORIPTN = BzGetAgInfoMockForSinkeiyaku.TESTPATTERN4;
        KeisanGaikakanzanMockForSinkeiyaku.SYORIPTN = KeisanGaikakanzanMockForSinkeiyaku.TESTPATTERN1;
        GetKiteiCheckYenkansangkMockForSinkeiyaku.SYORIPTN = GetKiteiCheckYenkansangkMockForSinkeiyaku.TESTPATTERN1;
        CheckSaiteiPMockForSinkeiyaku.SYORIPTN = CheckSaiteiPMockForSinkeiyaku.TESTPATTERN1;
        CheckTblMosSyouhin checkTblMosSyouhin = SWAKInjector.getInstance(CheckTblMosSyouhin.class);

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("860001833");
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

        exNumericEquals(hubiMsgLst.size(), 2, "不備メッセージテーブルエンティティリストのサイズ");

        exStringEquals(hubiMsgLst.get(1).getMosno(), "860001833", "申込番号");
        exNumericEquals(hubiMsgLst.get(1).getRenno(), 2, "連番");
        exStringEquals(hubiMsgLst.get(1).getMessageId(), "EHC0038", "メッセージＩＤ");
        exStringEquals(hubiMsgLst.get(1).getHubimsg(), "外貨建て一時払変額年金保険（ブレンド型）　年金原資最低保証１２５％の保険期間が取扱範囲外です。", "不備メッセージ");
        exClassificationEquals(hubiMsgLst.get(1).getHubisyubetukbn(), C_HubisyubetuKbn.KETHORYU_HUBI, "不備種別区分");
        exStringEquals(hubiMsgLst.get(1).getGyoumuKousinsyaId(), "JUnitTest", "業務用更新者ＩＤ");
        exStringEquals(hubiMsgLst.get(1).getGyoumuKousinTime(), "20160509141230000", "業務用更新時間");
    }
    @Test
    @TestOrder(22010)
    @Transactional
    public void testExec_V1() {
        MockObjectManager.initialize();
        BzGetAgInfoMockForSinkeiyaku.SYORIPTN = BzGetAgInfoMockForSinkeiyaku.TESTPATTERN4;
        KeisanGaikakanzanMockForSinkeiyaku.SYORIPTN = KeisanGaikakanzanMockForSinkeiyaku.TESTPATTERN1;
        GetKiteiCheckYenkansangkMockForSinkeiyaku.SYORIPTN = GetKiteiCheckYenkansangkMockForSinkeiyaku.TESTPATTERN1;
        CheckSaiteiPMockForSinkeiyaku.SYORIPTN = CheckSaiteiPMockForSinkeiyaku.TESTPATTERN1;
        CheckTblMosSyouhin checkTblMosSyouhin = SWAKInjector.getInstance(CheckTblMosSyouhin.class);

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("860001841");
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
    @TestOrder(22030)
    @Transactional
    public void testExec_V3() {
        MockObjectManager.initialize();
        BzGetAgInfoMockForSinkeiyaku.SYORIPTN = BzGetAgInfoMockForSinkeiyaku.TESTPATTERN4;
        KeisanGaikakanzanMockForSinkeiyaku.SYORIPTN = KeisanGaikakanzanMockForSinkeiyaku.TESTPATTERN1;
        GetKiteiCheckYenkansangkMockForSinkeiyaku.SYORIPTN = GetKiteiCheckYenkansangkMockForSinkeiyaku.TESTPATTERN1;
        CheckSaiteiPMockForSinkeiyaku.SYORIPTN = CheckSaiteiPMockForSinkeiyaku.TESTPATTERN1;
        CheckTblMosSyouhin checkTblMosSyouhin = SWAKInjector.getInstance(CheckTblMosSyouhin.class);

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("860001866");
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

}