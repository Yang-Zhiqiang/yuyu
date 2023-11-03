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
import yuyu.common.sinkeiyaku.skcommon.ConvNenSaiManki;
import yuyu.common.sinkeiyaku.skcommon.ConvNenSaiMankiMockForSinkeiyaku;
import yuyu.common.sinkeiyaku.skcommon.DrtenTkykTratkiHantei;
import yuyu.common.sinkeiyaku.skcommon.EditNenkinKoumokuUtil;
import yuyu.common.sinkeiyaku.skcommon.EditNenkinKoumokuUtilMockForSinkeiyaku;
import yuyu.common.sinkeiyaku.skcommon.GetKiteiCheckYenkansangk;
import yuyu.common.sinkeiyaku.skcommon.GetKiteiCheckYenkansangkMockForSinkeiyaku;
import yuyu.def.biz.manager.BizDomManager;
import yuyu.def.classification.C_Channelcd;
import yuyu.def.classification.C_HubisyubetuKbn;
import yuyu.def.classification.C_HubisyubetusyousaiKbn;
import yuyu.def.classification.C_KouzokujkKbn;
import yuyu.def.classification.C_SeihowebsousasyaKbn;
import yuyu.def.classification.C_SekmossakuseiErroutKbn;
import yuyu.def.classification.C_SkeijimuKbn;
import yuyu.def.classification.C_SysKbn;
import yuyu.def.classification.C_SyutkKbn;
import yuyu.def.classification.C_UmuKbn;
import yuyu.def.classification.C_YoteirirituhendouKbn;
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
public class CheckTblMosSyouhinTest_exec5 {

    @Inject
    private MosnaiCheckParam mosnaiCheckParam;

    @Inject
    private BizDomManager bizDomManager;

    @Inject
    private SinkeiyakuDomManager sinkeiyakuDomManager;

    private final static String fileName = "UT-SP_単体テスト仕様書（共通）_申込商品TBLチェック";

    private final static String sheetName = "INデータ(5)";

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
                bind(DrtenTkykTratkiHantei.class).to(DrtenTkykTratkiHanteiMockForSinkeiyaku.class);
                bind(ConvNenSaiManki.class).to(ConvNenSaiMankiMockForSinkeiyaku.class);

            }
        });
    }

    @BeforeClass
    @Transactional
    public static void insertTestData() {
        try {
            TestDataMaker testDataMaker = new TestDataMaker();
            HashMap<String, Map<String, List<Map<String, String>>>> testDataAndTblMap;
            testDataAndTblMap = testDataMaker.getInData(CheckTblMosSyouhinTest_exec5.class, fileName, sheetName);
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
        BzGetAgInfoMockForSinkeiyaku.caller = CheckTblMosSyouhinTest_exec5.class;

        CheckSaiteiPMockForSinkeiyaku.caller = CheckTblMosSyouhinTest_exec5.class;

        HanteiMoschkMockForSinkeiyaku.caller = CheckTblMosSyouhinTest_exec5.class;

        EditNenkinKoumokuUtilMockForSinkeiyaku.caller = CheckTblMosSyouhinTest_exec5.class;

        ConvNenSaiMankiMockForSinkeiyaku.caller = CheckTblMosSyouhinTest_exec5.class;

        DrtenTkykTratkiHanteiMockForSinkeiyaku.caller = CheckTblMosSyouhinTest_exec5.class;
    }

    @AfterClass
    public static void testClear() {

        BzGetAgInfoMockForSinkeiyaku.caller = null;
        BzGetAgInfoMockForSinkeiyaku.SYORIPTN = null;
        CheckSaiteiPMockForSinkeiyaku.caller = null;
        CheckSaiteiPMockForSinkeiyaku.SYORIPTN = null;

        EditNenkinKoumokuUtilMockForSinkeiyaku.caller = null;
        EditNenkinKoumokuUtilMockForSinkeiyaku.SYORIPTN = null;

        HanteiMoschkMockForSinkeiyaku.caller = null;
        HanteiMoschkMockForSinkeiyaku.SYORIPTN = null;

        DrtenTkykTratkiHanteiMockForSinkeiyaku.caller = null;
        DrtenTkykTratkiHanteiMockForSinkeiyaku.SYORIPTN = null;

        MockObjectManager.initialize();

    }

    @Test
    @TestOrder(3110)
    @Transactional
    public void testExec_A26() {
        MockObjectManager.initialize();
        BzGetAgInfoMockForSinkeiyaku.SYORIPTN = BzGetAgInfoMockForSinkeiyaku.TESTPATTERN1;
        CheckSaiteiPMockForSinkeiyaku.SYORIPTN = CheckSaiteiPMockForSinkeiyaku.TESTPATTERN1;
        HanteiMoschkMockForSinkeiyaku.SYORIPTN = HanteiMoschkMockForSinkeiyaku.TESTPATTERN1;
        EditNenkinKoumokuUtilMockForSinkeiyaku.SYORIPTN = EditNenkinKoumokuUtilMockForSinkeiyaku.TESTPATTERN1;
        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("970002275");
        CheckTblMosSyouhin checkTblMosSyouhin = SWAKInjector.getInstance(CheckTblMosSyouhin.class);

        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setSysKbn(C_SysKbn.SKEI);
        mosnaiCheckParam.setKokutiChkHuyoUmu(C_UmuKbn.NONE);
        mosnaiCheckParam.setSysDate(BizDate.valueOf(20160102));
        mosnaiCheckParam.setSekmossakuseiSousasyaKbn(C_SeihowebsousasyaKbn.DIRTNBSYNN);
        mosnaiCheckParam.setListHubiMsg(new ArrayList<HT_HubiMsg>());
        mosnaiCheckParam.setKosID("JUnitTest");
        mosnaiCheckParam.setKosTime("20160509141230000");
        mosnaiCheckParam.setKiteiCheckChannelCd(C_Channelcd.TIGIN);

        List<BM_SyouhnZokusei> listTkSyouhnZokusei = new ArrayList<>();
        BM_SyouhnZokusei syouhnZokusei1 = new BM_SyouhnZokusei();
        syouhnZokusei1.setSyouhncd("ｱ1");
        syouhnZokusei1.setSyouhnsdno(1);
        syouhnZokusei1.setNkhknumu(C_UmuKbn.ARI);
        syouhnZokusei1.setSyouhnnm("商品名００１");
        BM_SyouhnZokusei syouhnZokusei2 = new BM_SyouhnZokusei();
        syouhnZokusei2.setSyouhncd("ｱ8");
        syouhnZokusei2.setSyouhnsdno(1);
        syouhnZokusei2.setSyouhnnm("商品名００２");
        BM_SyouhnZokusei syouhnZokusei3 = new BM_SyouhnZokusei();
        syouhnZokusei3.setSyouhncd("ｱ9");
        syouhnZokusei3.setSyouhnsdno(1);
        syouhnZokusei3.setSyouhnnm("商品名００３");
        listTkSyouhnZokusei.add(syouhnZokusei1);
        listTkSyouhnZokusei.add(syouhnZokusei2);
        listTkSyouhnZokusei.add(syouhnZokusei3);
        mosnaiCheckParam.setListTkSyouhnZokusei(listTkSyouhnZokusei);
        BM_SyouhnZokusei syouhnZokusei = new BM_SyouhnZokusei();
        syouhnZokusei.setSyouhncd("ｱ1");
        syouhnZokusei.setSyouhnsdno(1);
        syouhnZokusei.setSyouhnnm("商品名０００");
        syouhnZokusei.setNkhknumu(C_UmuKbn.ARI);
        mosnaiCheckParam.setSyuSyouhnZokusei(syouhnZokusei);

        checkTblMosSyouhin.exec(mosnaiCheckParam);

        List<HT_HubiMsg> hubiMsgLst = mosnaiCheckParam.getListHubiMsg();
        boolean hanteiflg = false;
        exNumericEquals(hubiMsgLst.size(), 2, "不備メッセージテーブルエンティティリストのサイズ");
        for (HT_HubiMsg hubiMsg : hubiMsgLst) {
            if ("EBC0046".equals(hubiMsg.getMessageId())) {
                hanteiflg = true;
                exStringEquals(hubiMsg.getMosno(), "970002275", "申込番号");
                exNumericEquals(hubiMsg.getRenno(), 1, "連番");
                exStringEquals(hubiMsg.getMessageId(), "EBC0046", "メッセージＩＤ");
                exStringEquals(hubiMsg.getHubimsg(), "据置期間が正しくありません。", "不備メッセージ");
                exClassificationEquals(hubiMsg.getHubisyubetukbn(), C_HubisyubetuKbn.KETHORYU_HUBI, "不備種別区分");
                exClassificationEquals(hubiMsg.getHubisyubetusyousaikbn(), C_HubisyubetusyousaiKbn.NONE,
                    "不備種別詳細区分");
                exStringEquals(hubiMsg.getGyoumuKousinsyaId(), "JUnitTest", "業務用更新者ＩＤ");
                exStringEquals(hubiMsg.getGyoumuKousinTime(), "20160509141230000", "業務用更新時間");
            }
        }
        exBooleanEquals(hanteiflg, true, "メッセージＩＤが'EBC0046'のデータが存在します");

    }

    @Test
    @TestOrder(3120)
    @Transactional
    public void testExec_A27() {
        MockObjectManager.initialize();
        BzGetAgInfoMockForSinkeiyaku.SYORIPTN = BzGetAgInfoMockForSinkeiyaku.TESTPATTERN1;
        CheckSaiteiPMockForSinkeiyaku.SYORIPTN = CheckSaiteiPMockForSinkeiyaku.TESTPATTERN1;
        HanteiMoschkMockForSinkeiyaku.SYORIPTN = HanteiMoschkMockForSinkeiyaku.TESTPATTERN2;
        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("970002226");
        CheckTblMosSyouhin checkTblMosSyouhin = SWAKInjector.getInstance(CheckTblMosSyouhin.class);

        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setSysKbn(C_SysKbn.SKEI);
        mosnaiCheckParam.setKokutiChkHuyoUmu(C_UmuKbn.NONE);
        mosnaiCheckParam.setSysDate(BizDate.valueOf(20160102));
        mosnaiCheckParam.setSekmossakuseiSousasyaKbn(C_SeihowebsousasyaKbn.DIRTNBSYNN);
        mosnaiCheckParam.setListHubiMsg(new ArrayList<HT_HubiMsg>());
        mosnaiCheckParam.setKosID("JUnitTest");
        mosnaiCheckParam.setKosTime("20160509141230000");
        mosnaiCheckParam.setKiteiCheckChannelCd(C_Channelcd.TIGIN);

        List<BM_SyouhnZokusei> listTkSyouhnZokusei = new ArrayList<>();
        BM_SyouhnZokusei syouhnZokusei1 = new BM_SyouhnZokusei();
        syouhnZokusei1.setSyouhncd("ｱ1");
        syouhnZokusei1.setSyouhnsdno(1);

        syouhnZokusei1.setSyouhnnm("商品名００１");

        BM_SyouhnZokusei syouhnZokusei2 = new BM_SyouhnZokusei();
        syouhnZokusei2.setSyouhncd("ｱ2");
        syouhnZokusei2.setSyouhnsdno(1);

        syouhnZokusei2.setSyouhnnm("商品名００２");

        BM_SyouhnZokusei syouhnZokusei3 = new BM_SyouhnZokusei();
        syouhnZokusei3.setSyouhncd("ｱ9");
        syouhnZokusei3.setSyouhnsdno(1);
        syouhnZokusei3.setSyouhnnm("商品名００３");

        listTkSyouhnZokusei.add(syouhnZokusei1);
        listTkSyouhnZokusei.add(syouhnZokusei2);
        listTkSyouhnZokusei.add(syouhnZokusei3);

        mosnaiCheckParam.setListTkSyouhnZokusei(listTkSyouhnZokusei);

        BM_SyouhnZokusei syouhnZokusei = new BM_SyouhnZokusei();
        syouhnZokusei.setSyouhncd("ｱ1");
        syouhnZokusei.setSyouhnsdno(1);

        syouhnZokusei.setSyouhnnm("商品名０００");
        syouhnZokusei.setKyhkataumu(C_UmuKbn.ARI);
        syouhnZokusei.setNkhknumu(C_UmuKbn.ARI);
        mosnaiCheckParam.setSyuSyouhnZokusei(syouhnZokusei);

        checkTblMosSyouhin.exec(mosnaiCheckParam);

        List<HT_HubiMsg> hubiMsgLst = mosnaiCheckParam.getListHubiMsg();
        boolean hanteiflg = false;
        exNumericEquals(hubiMsgLst.size(), 3, "不備メッセージテーブルエンティティリストのサイズ");
        for (HT_HubiMsg hubiMsg : hubiMsgLst) {
            if ("EHC0028".equals(hubiMsg.getMessageId()) && hubiMsg.getRenno()==1) {
                hanteiflg = true;
                exStringEquals(hubiMsg.getMosno(), "970002226", "申込番号");
                exNumericEquals(hubiMsg.getRenno(), 1, "連番");
                exStringEquals(hubiMsg.getMessageId(), "EHC0028", "メッセージＩＤ");
                exStringEquals(hubiMsg.getHubimsg(), "商品名０００の契約可能期間・年齢範囲外です。", "不備メッセージ");
                exClassificationEquals(hubiMsg.getHubisyubetukbn(), C_HubisyubetuKbn.KETHORYU_HUBI, "不備種別区分");
                exClassificationEquals(hubiMsg.getHubisyubetusyousaikbn(), C_HubisyubetusyousaiKbn.NONE,
                    "不備種別詳細区分");
                exStringEquals(hubiMsg.getGyoumuKousinsyaId(), "JUnitTest", "業務用更新者ＩＤ");
                exStringEquals(hubiMsg.getGyoumuKousinTime(), "20160509141230000", "業務用更新時間");
            }

            if ("EHC0019".equals(hubiMsg.getMessageId())) {
                hanteiflg = true;
                exStringEquals(hubiMsg.getMosno(), "970002226", "申込番号");
                exNumericEquals(hubiMsg.getRenno(), 2, "連番");
                exStringEquals(hubiMsg.getMessageId(), "EHC0019", "メッセージＩＤ");
                exStringEquals(hubiMsg.getHubimsg(), "商品名０００のは取扱えません。", "不備メッセージ");
                exClassificationEquals(hubiMsg.getHubisyubetukbn(), C_HubisyubetuKbn.KETHORYU_HUBI, "不備種別区分");
                exClassificationEquals(hubiMsg.getHubisyubetusyousaikbn(), C_HubisyubetusyousaiKbn.NONE,
                    "不備種別詳細区分");
                exStringEquals(hubiMsg.getGyoumuKousinsyaId(), "JUnitTest", "業務用更新者ＩＤ");
                exStringEquals(hubiMsg.getGyoumuKousinTime(), "20160509141230000", "業務用更新時間");
            }

            if ("EHC0028".equals(hubiMsg.getMessageId())&& hubiMsg.getRenno() == 3 ) {
                hanteiflg = true;
                exStringEquals(hubiMsg.getMosno(), "970002226", "申込番号");
                exNumericEquals(hubiMsg.getRenno(), 3, "連番");
                exStringEquals(hubiMsg.getMessageId(), "EHC0028", "メッセージＩＤ");
                exStringEquals(hubiMsg.getHubimsg(), "商品名００２の契約可能期間・年齢範囲外です。", "不備メッセージ");
                exClassificationEquals(hubiMsg.getHubisyubetukbn(), C_HubisyubetuKbn.KETHORYU_HUBI, "不備種別区分");
                exClassificationEquals(hubiMsg.getHubisyubetusyousaikbn(), C_HubisyubetusyousaiKbn.NONE,
                    "不備種別詳細区分");
                exStringEquals(hubiMsg.getGyoumuKousinsyaId(), "JUnitTest", "業務用更新者ＩＤ");
                exStringEquals(hubiMsg.getGyoumuKousinTime(), "20160509141230000", "業務用更新時間");
            }

        }

    }

    @Test
    @TestOrder(3130)
    @Transactional
    public void testExec_A28() {
        MockObjectManager.initialize();
        BzGetAgInfoMockForSinkeiyaku.SYORIPTN = BzGetAgInfoMockForSinkeiyaku.TESTPATTERN1;
        CheckSaiteiPMockForSinkeiyaku.SYORIPTN = CheckSaiteiPMockForSinkeiyaku.TESTPATTERN1;
        HanteiMoschkMockForSinkeiyaku.SYORIPTN = HanteiMoschkMockForSinkeiyaku.TESTPATTERN1;
        EditNenkinKoumokuUtilMockForSinkeiyaku.SYORIPTN = EditNenkinKoumokuUtilMockForSinkeiyaku.TESTPATTERN2;
        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("970002226");
        CheckTblMosSyouhin checkTblMosSyouhin = SWAKInjector.getInstance(CheckTblMosSyouhin.class);

        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setSysKbn(C_SysKbn.SKEI);
        mosnaiCheckParam.setKokutiChkHuyoUmu(C_UmuKbn.NONE);
        mosnaiCheckParam.setSysDate(BizDate.valueOf(20160102));
        mosnaiCheckParam.setSekmossakuseiSousasyaKbn(C_SeihowebsousasyaKbn.DIRTNBSYNN);
        mosnaiCheckParam.setListHubiMsg(new ArrayList<HT_HubiMsg>());
        mosnaiCheckParam.setKosID("JUnitTest");
        mosnaiCheckParam.setKosTime("20160509141230000");
        mosnaiCheckParam.setKiteiCheckChannelCd(C_Channelcd.TIGIN);

        List<BM_SyouhnZokusei> listTkSyouhnZokusei = new ArrayList<>();
        BM_SyouhnZokusei syouhnZokusei1 = new BM_SyouhnZokusei();
        syouhnZokusei1.setSyouhncd("ｱ1");
        syouhnZokusei1.setSyouhnsdno(1);

        syouhnZokusei1.setNkhknumu(C_UmuKbn.ARI);

        syouhnZokusei1.setSyouhnnm("商品名００１");

        BM_SyouhnZokusei syouhnZokusei2 = new BM_SyouhnZokusei();
        syouhnZokusei2.setSyouhncd("ｱ2");
        syouhnZokusei2.setSyouhnsdno(1);

        syouhnZokusei2.setSyouhnnm("商品名００２");

        BM_SyouhnZokusei syouhnZokusei3 = new BM_SyouhnZokusei();
        syouhnZokusei3.setSyouhncd("ｱ3");
        syouhnZokusei3.setSyouhnsdno(1);
        syouhnZokusei3.setSyouhnnm("商品名００３");

        listTkSyouhnZokusei.add(syouhnZokusei1);
        listTkSyouhnZokusei.add(syouhnZokusei2);
        listTkSyouhnZokusei.add(syouhnZokusei3);

        mosnaiCheckParam.setListTkSyouhnZokusei(listTkSyouhnZokusei);

        BM_SyouhnZokusei syouhnZokusei = new BM_SyouhnZokusei();
        syouhnZokusei.setSyouhncd("ｱ3");
        syouhnZokusei.setSyouhnsdno(1);

        syouhnZokusei.setSyouhnnm("商品名０００");
        syouhnZokusei.setKyhkataumu(C_UmuKbn.ARI);
        syouhnZokusei.setNkhknumu(C_UmuKbn.ARI);
        mosnaiCheckParam.setSyuSyouhnZokusei(syouhnZokusei);

        checkTblMosSyouhin.exec(mosnaiCheckParam);
        List<HT_HubiMsg> hubiMsgLst = mosnaiCheckParam.getListHubiMsg();
        boolean hanteiflg = false;
        exNumericEquals(hubiMsgLst.size(), 4, "不備メッセージテーブルエンティティリストのサイズ");
        for (HT_HubiMsg hubiMsg : hubiMsgLst) {
            if ("EBC0046".equals(hubiMsg.getMessageId())) {
                hanteiflg = true;
                exStringEquals(hubiMsg.getMosno(), "970002226", "申込番号");
                exNumericEquals(hubiMsg.getRenno(), 1, "連番");
                exStringEquals(hubiMsg.getMessageId(), "EBC0046", "メッセージＩＤ");
                exStringEquals(hubiMsg.getHubimsg(), "据置期間が正しくありません。", "不備メッセージ");
                exClassificationEquals(hubiMsg.getHubisyubetukbn(), C_HubisyubetuKbn.KETHORYU_HUBI, "不備種別区分");
                exClassificationEquals(hubiMsg.getHubisyubetusyousaikbn(), C_HubisyubetusyousaiKbn.NONE,
                    "不備種別詳細区分");
                exStringEquals(hubiMsg.getGyoumuKousinsyaId(), "JUnitTest", "業務用更新者ＩＤ");
                exStringEquals(hubiMsg.getGyoumuKousinTime(), "20160509141230000", "業務用更新時間");
            }
        }
        exBooleanEquals(hanteiflg, true, "メッセージＩＤが'EBC0046'のデータが存在します");

    }

    @Test
    @TestOrder(3140)
    @Transactional
    public void testExec_A29() {
        MockObjectManager.initialize();
        CheckSaiteiPMockForSinkeiyaku.SYORIPTN = CheckSaiteiPMockForSinkeiyaku.TESTPATTERN1;
        HanteiMoschkMockForSinkeiyaku.SYORIPTN = HanteiMoschkMockForSinkeiyaku.TESTPATTERN2;
        CheckTblMosSyouhin checkTblMosSyouhin = SWAKInjector.getInstance(CheckTblMosSyouhin.class);

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("970002218");
        List<BM_SyouhnZokusei> listTkSyouhnZokusei = new ArrayList<>();
        BM_SyouhnZokusei syouhnZokusei1 = new BM_SyouhnZokusei();
        syouhnZokusei1.setSyouhncd("ｱ1");
        syouhnZokusei1.setSyouhnsdno(1);

        syouhnZokusei1.setNkhknumu(C_UmuKbn.ARI);

        syouhnZokusei1.setSyouhnnm("商品名００１");

        BM_SyouhnZokusei syouhnZokusei2 = new BM_SyouhnZokusei();
        syouhnZokusei2.setSyouhncd("ｱ8");
        syouhnZokusei2.setSyouhnsdno(1);

        syouhnZokusei2.setSyouhnnm("商品名００２");

        BM_SyouhnZokusei syouhnZokusei3 = new BM_SyouhnZokusei();
        syouhnZokusei3.setSyouhncd("ｱ9");
        syouhnZokusei3.setSyouhnsdno(1);
        syouhnZokusei3.setSyouhnnm("商品名００３");

        listTkSyouhnZokusei.add(syouhnZokusei1);
        listTkSyouhnZokusei.add(syouhnZokusei2);
        listTkSyouhnZokusei.add(syouhnZokusei3);

        mosnaiCheckParam.setListTkSyouhnZokusei(listTkSyouhnZokusei);

        BM_SyouhnZokusei syouhnZokusei = new BM_SyouhnZokusei();
        syouhnZokusei.setSyouhncd("ﾕｲ");
        syouhnZokusei.setSyouhnsdno(1);

        syouhnZokusei.setSyouhnnm("商品名０００");

        syouhnZokusei.setYoteirirituhendoukbn(C_YoteirirituhendouKbn.TUKI1KAI);

        syouhnZokusei.setNkhknumu(C_UmuKbn.ARI);
        mosnaiCheckParam.setSyuSyouhnZokusei(syouhnZokusei);

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
    @TestOrder(3150)
    @Transactional
    public void testExec_A30() {
        MockObjectManager.initialize();
        CheckSaiteiPMockForSinkeiyaku.SYORIPTN = CheckSaiteiPMockForSinkeiyaku.TESTPATTERN1;
        HanteiMoschkMockForSinkeiyaku.SYORIPTN = HanteiMoschkMockForSinkeiyaku.TESTPATTERN2;
        CheckTblMosSyouhin checkTblMosSyouhin = SWAKInjector.getInstance(CheckTblMosSyouhin.class);

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("970002242");
        List<BM_SyouhnZokusei> listTkSyouhnZokusei = new ArrayList<>();
        BM_SyouhnZokusei syouhnZokusei1 = new BM_SyouhnZokusei();
        syouhnZokusei1.setSyouhncd("ｱ1");
        syouhnZokusei1.setSyouhnsdno(1);

        syouhnZokusei1.setNkhknumu(C_UmuKbn.ARI);

        syouhnZokusei1.setSyouhnnm("商品名００１");

        BM_SyouhnZokusei syouhnZokusei2 = new BM_SyouhnZokusei();
        syouhnZokusei2.setSyouhncd("ｱ8");
        syouhnZokusei2.setSyouhnsdno(1);

        syouhnZokusei2.setSyouhnnm("商品名００２");

        BM_SyouhnZokusei syouhnZokusei3 = new BM_SyouhnZokusei();
        syouhnZokusei3.setSyouhncd("ｱ9");
        syouhnZokusei3.setSyouhnsdno(1);
        syouhnZokusei3.setSyouhnnm("商品名００３");

        listTkSyouhnZokusei.add(syouhnZokusei1);
        listTkSyouhnZokusei.add(syouhnZokusei2);
        listTkSyouhnZokusei.add(syouhnZokusei3);

        mosnaiCheckParam.setListTkSyouhnZokusei(listTkSyouhnZokusei);

        BM_SyouhnZokusei syouhnZokusei = new BM_SyouhnZokusei();
        syouhnZokusei.setSyouhncd("ﾕｳ");
        syouhnZokusei.setSyouhnsdno(1);

        syouhnZokusei.setSyouhnnm("商品名０００");

        syouhnZokusei.setYoteirirituhendoukbn(C_YoteirirituhendouKbn.TUKI1KAI);

        syouhnZokusei.setNkhknumu(C_UmuKbn.ARI);
        mosnaiCheckParam.setSyuSyouhnZokusei(syouhnZokusei);

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
    @TestOrder(3160)
    @Transactional
    public void testExec_A31() {
        MockObjectManager.initialize();
        CheckSaiteiPMockForSinkeiyaku.SYORIPTN = CheckSaiteiPMockForSinkeiyaku.TESTPATTERN1;
        HanteiMoschkMockForSinkeiyaku.SYORIPTN = HanteiMoschkMockForSinkeiyaku.TESTPATTERN2;
        CheckTblMosSyouhin checkTblMosSyouhin = SWAKInjector.getInstance(CheckTblMosSyouhin.class);

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("970002259");
        List<BM_SyouhnZokusei> listTkSyouhnZokusei = new ArrayList<>();
        BM_SyouhnZokusei syouhnZokusei1 = new BM_SyouhnZokusei();
        syouhnZokusei1.setSyouhncd("ｱ1");
        syouhnZokusei1.setSyouhnsdno(1);

        syouhnZokusei1.setNkhknumu(C_UmuKbn.ARI);

        syouhnZokusei1.setSyouhnnm("商品名００１");

        BM_SyouhnZokusei syouhnZokusei2 = new BM_SyouhnZokusei();
        syouhnZokusei2.setSyouhncd("ｱ8");
        syouhnZokusei2.setSyouhnsdno(1);

        syouhnZokusei2.setSyouhnnm("商品名００２");

        BM_SyouhnZokusei syouhnZokusei3 = new BM_SyouhnZokusei();
        syouhnZokusei3.setSyouhncd("ｱ9");
        syouhnZokusei3.setSyouhnsdno(1);
        syouhnZokusei3.setSyouhnnm("商品名００３");

        listTkSyouhnZokusei.add(syouhnZokusei1);
        listTkSyouhnZokusei.add(syouhnZokusei2);
        listTkSyouhnZokusei.add(syouhnZokusei3);

        mosnaiCheckParam.setListTkSyouhnZokusei(listTkSyouhnZokusei);

        BM_SyouhnZokusei syouhnZokusei = new BM_SyouhnZokusei();
        syouhnZokusei.setSyouhncd("ﾕｳ");
        syouhnZokusei.setSyouhnsdno(1);

        syouhnZokusei.setSyouhnnm("商品名０００");

        syouhnZokusei.setYoteirirituhendoukbn(C_YoteirirituhendouKbn.TUKI1KAI);

        syouhnZokusei.setNkhknumu(C_UmuKbn.ARI);
        mosnaiCheckParam.setSyuSyouhnZokusei(syouhnZokusei);

        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setSysKbn(C_SysKbn.ESHIEN);
        mosnaiCheckParam.setKokutiChkHuyoUmu(C_UmuKbn.NONE);
        mosnaiCheckParam.setSysDate(BizDate.valueOf(20160102));
        mosnaiCheckParam.setSekmossakuseiSousasyaKbn(C_SeihowebsousasyaKbn.SUPPORTDESK);
        mosnaiCheckParam.setKiteiCheckChannelCd(C_Channelcd.TIGIN);

        checkTblMosSyouhin.exec(mosnaiCheckParam);

        exClassificationEquals(mosnaiCheckParam.getSekmossakuseiErroutKbn(), C_SekmossakuseiErroutKbn.GAMEN, "設計書申込書作成エラー出力区分");
        exStringEquals(mosnaiCheckParam.getSekmossakuseiErrmsg1(), "初期死亡時円換算支払額最低保証特約は募集年齢範囲外です　　当予定利率期間の募集年", "設計書申込書作成エラーメッセージ１");
        exStringEquals(mosnaiCheckParam.getSekmossakuseiErrmsg2(), "齢範囲は１歳から９８歳です", "設計書申込書作成エラーメッセージ２");
        exClassificationEquals(mosnaiCheckParam.getKouzokuSyoriJikkouKbn(), C_KouzokujkKbn.NONE, "後続処理実行区分");
    }

    @Test
    @TestOrder(3170)
    @Transactional
    public void testExec_A32() {
        MockObjectManager.initialize();
        CheckSaiteiPMockForSinkeiyaku.SYORIPTN = CheckSaiteiPMockForSinkeiyaku.TESTPATTERN1;
        HanteiMoschkMockForSinkeiyaku.SYORIPTN = HanteiMoschkMockForSinkeiyaku.TESTPATTERN2;
        CheckTblMosSyouhin checkTblMosSyouhin = SWAKInjector.getInstance(CheckTblMosSyouhin.class);

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("970002267");
        List<BM_SyouhnZokusei> listTkSyouhnZokusei = new ArrayList<>();
        BM_SyouhnZokusei syouhnZokusei1 = new BM_SyouhnZokusei();
        syouhnZokusei1.setSyouhncd("ｱ1");
        syouhnZokusei1.setSyouhnsdno(1);

        syouhnZokusei1.setNkhknumu(C_UmuKbn.ARI);

        syouhnZokusei1.setSyouhnnm("商品名００１");

        BM_SyouhnZokusei syouhnZokusei2 = new BM_SyouhnZokusei();
        syouhnZokusei2.setSyouhncd("ｱ8");
        syouhnZokusei2.setSyouhnsdno(1);

        syouhnZokusei2.setSyouhnnm("商品名００２");

        BM_SyouhnZokusei syouhnZokusei3 = new BM_SyouhnZokusei();
        syouhnZokusei3.setSyouhncd("ｱ9");
        syouhnZokusei3.setSyouhnsdno(1);
        syouhnZokusei3.setSyouhnnm("商品名００３");

        listTkSyouhnZokusei.add(syouhnZokusei1);
        listTkSyouhnZokusei.add(syouhnZokusei2);
        listTkSyouhnZokusei.add(syouhnZokusei3);

        mosnaiCheckParam.setListTkSyouhnZokusei(listTkSyouhnZokusei);

        BM_SyouhnZokusei syouhnZokusei = new BM_SyouhnZokusei();
        syouhnZokusei.setSyouhncd("ﾕｳ");
        syouhnZokusei.setSyouhnsdno(1);

        syouhnZokusei.setSyouhnnm("商品名０００");

        syouhnZokusei.setYoteirirituhendoukbn(C_YoteirirituhendouKbn.TUKI1KAI);

        syouhnZokusei.setNkhknumu(C_UmuKbn.ARI);
        mosnaiCheckParam.setSyuSyouhnZokusei(syouhnZokusei);

        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setSysKbn(C_SysKbn.ESHIEN);
        mosnaiCheckParam.setKokutiChkHuyoUmu(C_UmuKbn.NONE);
        mosnaiCheckParam.setSysDate(BizDate.valueOf(20160102));
        mosnaiCheckParam.setSekmossakuseiSousasyaKbn(C_SeihowebsousasyaKbn.SUPPORTDESK);
        mosnaiCheckParam.setKiteiCheckChannelCd(C_Channelcd.TIGIN);

        checkTblMosSyouhin.exec(mosnaiCheckParam);

        exClassificationEquals(mosnaiCheckParam.getSekmossakuseiErroutKbn(), C_SekmossakuseiErroutKbn.GAMEN, "設計書申込書作成エラー出力区分");
        exStringEquals(mosnaiCheckParam.getSekmossakuseiErrmsg1(), "", "設計書申込書作成エラーメッセージ１");
        exStringEquals(mosnaiCheckParam.getSekmossakuseiErrmsg2(), "募集年齢範囲外です　当予定利率期間の募集年齢範囲は１歳から１００歳です", "設計書申込書作成エラーメッセージ２");
        exClassificationEquals(mosnaiCheckParam.getKouzokuSyoriJikkouKbn(), C_KouzokujkKbn.NONE, "後続処理実行区分");
    }

    @Test
    @TestOrder(3180)
    @Transactional
    public void testExec_A33() {
        MockObjectManager.initialize();
        CheckSaiteiPMockForSinkeiyaku.SYORIPTN = CheckSaiteiPMockForSinkeiyaku.TESTPATTERN1;
        HanteiMoschkMockForSinkeiyaku.SYORIPTN = HanteiMoschkMockForSinkeiyaku.TESTPATTERN2;
        CheckTblMosSyouhin checkTblMosSyouhin = SWAKInjector.getInstance(CheckTblMosSyouhin.class);

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("870000114");
        List<BM_SyouhnZokusei> listTkSyouhnZokusei = new ArrayList<>();
        BM_SyouhnZokusei syouhnZokusei1 = new BM_SyouhnZokusei();
        syouhnZokusei1.setSyouhncd("ｱ1");
        syouhnZokusei1.setSyouhnsdno(1);

        syouhnZokusei1.setNkhknumu(C_UmuKbn.ARI);

        syouhnZokusei1.setSyouhnnm("商品名００１");

        BM_SyouhnZokusei syouhnZokusei2 = new BM_SyouhnZokusei();
        syouhnZokusei2.setSyouhncd("ｱ8");
        syouhnZokusei2.setSyouhnsdno(1);

        syouhnZokusei2.setSyouhnnm("商品名００２");

        BM_SyouhnZokusei syouhnZokusei3 = new BM_SyouhnZokusei();
        syouhnZokusei3.setSyouhncd("ｱ9");
        syouhnZokusei3.setSyouhnsdno(1);
        syouhnZokusei3.setSyouhnnm("商品名００３");

        listTkSyouhnZokusei.add(syouhnZokusei1);
        listTkSyouhnZokusei.add(syouhnZokusei2);
        listTkSyouhnZokusei.add(syouhnZokusei3);

        mosnaiCheckParam.setListTkSyouhnZokusei(listTkSyouhnZokusei);

        BM_SyouhnZokusei syouhnZokusei = new BM_SyouhnZokusei();
        syouhnZokusei.setSyouhncd("ﾕｹ");
        syouhnZokusei.setSyouhnsdno(1);

        syouhnZokusei.setSyouhnnm("商品名０００");

        syouhnZokusei.setYoteirirituhendoukbn(C_YoteirirituhendouKbn.TUKI1KAI);

        syouhnZokusei.setNkhknumu(C_UmuKbn.ARI);
        mosnaiCheckParam.setSyuSyouhnZokusei(syouhnZokusei);

        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setSysKbn(C_SysKbn.ESHIEN);
        mosnaiCheckParam.setKokutiChkHuyoUmu(C_UmuKbn.NONE);
        mosnaiCheckParam.setSysDate(BizDate.valueOf(20160102));
        mosnaiCheckParam.setSekmossakuseiSousasyaKbn(C_SeihowebsousasyaKbn.SUPPORTDESK);
        mosnaiCheckParam.setKiteiCheckChannelCd(C_Channelcd.TIGIN);

        checkTblMosSyouhin.exec(mosnaiCheckParam);

        exClassificationEquals(mosnaiCheckParam.getSekmossakuseiErroutKbn(), C_SekmossakuseiErroutKbn.GAMEN, "設計書申込書作成エラー出力区分");
        exStringEquals(mosnaiCheckParam.getSekmossakuseiErrmsg1(), "", "設計書申込書作成エラーメッセージ１");
        exStringEquals(mosnaiCheckParam.getSekmossakuseiErrmsg2(), "据置期間１０年は選択できません", "設計書申込書作成エラーメッセージ２");
        exClassificationEquals(mosnaiCheckParam.getKouzokuSyoriJikkouKbn(), C_KouzokujkKbn.NONE, "後続処理実行区分");
    }

    @Test
    @TestOrder(3190)
    @Transactional
    public void testExec_A34() {
        MockObjectManager.initialize();
        CheckSaiteiPMockForSinkeiyaku.SYORIPTN = CheckSaiteiPMockForSinkeiyaku.TESTPATTERN1;
        HanteiMoschkMockForSinkeiyaku.SYORIPTN = HanteiMoschkMockForSinkeiyaku.TESTPATTERN2;
        CheckTblMosSyouhin checkTblMosSyouhin = SWAKInjector.getInstance(CheckTblMosSyouhin.class);

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("870000122");
        List<BM_SyouhnZokusei> listTkSyouhnZokusei = new ArrayList<>();
        BM_SyouhnZokusei syouhnZokusei1 = new BM_SyouhnZokusei();
        syouhnZokusei1.setSyouhncd("ｱ1");
        syouhnZokusei1.setSyouhnsdno(1);

        syouhnZokusei1.setNkhknumu(C_UmuKbn.ARI);

        syouhnZokusei1.setSyouhnnm("商品名００１");

        BM_SyouhnZokusei syouhnZokusei2 = new BM_SyouhnZokusei();
        syouhnZokusei2.setSyouhncd("ｱ8");
        syouhnZokusei2.setSyouhnsdno(1);

        syouhnZokusei2.setSyouhnnm("商品名００２");

        BM_SyouhnZokusei syouhnZokusei3 = new BM_SyouhnZokusei();
        syouhnZokusei3.setSyouhncd("ｱ9");
        syouhnZokusei3.setSyouhnsdno(1);
        syouhnZokusei3.setSyouhnnm("商品名００３");

        listTkSyouhnZokusei.add(syouhnZokusei1);
        listTkSyouhnZokusei.add(syouhnZokusei2);
        listTkSyouhnZokusei.add(syouhnZokusei3);

        mosnaiCheckParam.setListTkSyouhnZokusei(listTkSyouhnZokusei);

        BM_SyouhnZokusei syouhnZokusei = new BM_SyouhnZokusei();
        syouhnZokusei.setSyouhncd("ﾕｹ");
        syouhnZokusei.setSyouhnsdno(1);

        syouhnZokusei.setSyouhnnm("商品名０００");

        syouhnZokusei.setYoteirirituhendoukbn(C_YoteirirituhendouKbn.TUKI1KAI);

        syouhnZokusei.setNkhknumu(C_UmuKbn.ARI);
        mosnaiCheckParam.setSyuSyouhnZokusei(syouhnZokusei);

        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setSysKbn(C_SysKbn.ESHIEN);
        mosnaiCheckParam.setKokutiChkHuyoUmu(C_UmuKbn.NONE);
        mosnaiCheckParam.setSysDate(BizDate.valueOf(20160102));
        mosnaiCheckParam.setSekmossakuseiSousasyaKbn(C_SeihowebsousasyaKbn.SUPPORTDESK);
        mosnaiCheckParam.setKiteiCheckChannelCd(C_Channelcd.TIGIN);

        checkTblMosSyouhin.exec(mosnaiCheckParam);

        exClassificationEquals(mosnaiCheckParam.getSekmossakuseiErroutKbn(), C_SekmossakuseiErroutKbn.GAMEN, "設計書申込書作成エラー出力区分");
        exStringEquals(mosnaiCheckParam.getSekmossakuseiErrmsg1(), "", "設計書申込書作成エラーメッセージ１");
        exStringEquals(mosnaiCheckParam.getSekmossakuseiErrmsg2(), "据置期間１０年は選択できません", "設計書申込書作成エラーメッセージ２");
        exClassificationEquals(mosnaiCheckParam.getKouzokuSyoriJikkouKbn(), C_KouzokujkKbn.NONE, "後続処理実行区分");
    }

    @Test
    @TestOrder(3200)
    @Transactional
    public void testExec_A35() {
        MockObjectManager.initialize();
        CheckSaiteiPMockForSinkeiyaku.SYORIPTN = CheckSaiteiPMockForSinkeiyaku.TESTPATTERN1;
        HanteiMoschkMockForSinkeiyaku.SYORIPTN = HanteiMoschkMockForSinkeiyaku.TESTPATTERN2;
        CheckTblMosSyouhin checkTblMosSyouhin = SWAKInjector.getInstance(CheckTblMosSyouhin.class);

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("870000130");
        List<BM_SyouhnZokusei> listTkSyouhnZokusei = new ArrayList<>();
        BM_SyouhnZokusei syouhnZokusei1 = new BM_SyouhnZokusei();
        syouhnZokusei1.setSyouhncd("ｱ1");
        syouhnZokusei1.setSyouhnsdno(1);

        syouhnZokusei1.setNkhknumu(C_UmuKbn.ARI);

        syouhnZokusei1.setSyouhnnm("商品名００１");

        BM_SyouhnZokusei syouhnZokusei2 = new BM_SyouhnZokusei();
        syouhnZokusei2.setSyouhncd("ｱ8");
        syouhnZokusei2.setSyouhnsdno(1);

        syouhnZokusei2.setSyouhnnm("商品名００２");

        BM_SyouhnZokusei syouhnZokusei3 = new BM_SyouhnZokusei();
        syouhnZokusei3.setSyouhncd("ｱ9");
        syouhnZokusei3.setSyouhnsdno(1);
        syouhnZokusei3.setSyouhnnm("商品名００３");

        listTkSyouhnZokusei.add(syouhnZokusei1);
        listTkSyouhnZokusei.add(syouhnZokusei2);
        listTkSyouhnZokusei.add(syouhnZokusei3);

        mosnaiCheckParam.setListTkSyouhnZokusei(listTkSyouhnZokusei);

        BM_SyouhnZokusei syouhnZokusei = new BM_SyouhnZokusei();
        syouhnZokusei.setSyouhncd("ﾕｹ");
        syouhnZokusei.setSyouhnsdno(1);

        syouhnZokusei.setSyouhnnm("商品名０００");

        syouhnZokusei.setYoteirirituhendoukbn(C_YoteirirituhendouKbn.TUKI1KAI);

        syouhnZokusei.setNkhknumu(C_UmuKbn.ARI);
        mosnaiCheckParam.setSyuSyouhnZokusei(syouhnZokusei);

        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setSysKbn(C_SysKbn.ESHIEN);
        mosnaiCheckParam.setKokutiChkHuyoUmu(C_UmuKbn.NONE);
        mosnaiCheckParam.setSysDate(BizDate.valueOf(20160102));
        mosnaiCheckParam.setSekmossakuseiSousasyaKbn(C_SeihowebsousasyaKbn.SUPPORTDESK);
        mosnaiCheckParam.setKiteiCheckChannelCd(C_Channelcd.TIGIN);

        checkTblMosSyouhin.exec(mosnaiCheckParam);

        exClassificationEquals(mosnaiCheckParam.getSekmossakuseiErroutKbn(), C_SekmossakuseiErroutKbn.GAMEN, "設計書申込書作成エラー出力区分");
        exStringEquals(mosnaiCheckParam.getSekmossakuseiErrmsg1(), "", "設計書申込書作成エラーメッセージ１");
        exStringEquals(mosnaiCheckParam.getSekmossakuseiErrmsg2(), "据置期間１０年は選択できません", "設計書申込書作成エラーメッセージ２");
        exClassificationEquals(mosnaiCheckParam.getKouzokuSyoriJikkouKbn(), C_KouzokujkKbn.NONE, "後続処理実行区分");
    }

    @Test
    @TestOrder(3210)
    @Transactional
    public void testExec_A36() {
        MockObjectManager.initialize();
        CheckSaiteiPMockForSinkeiyaku.SYORIPTN = CheckSaiteiPMockForSinkeiyaku.TESTPATTERN1;
        HanteiMoschkMockForSinkeiyaku.SYORIPTN = HanteiMoschkMockForSinkeiyaku.TESTPATTERN2;
        CheckTblMosSyouhin checkTblMosSyouhin = SWAKInjector.getInstance(CheckTblMosSyouhin.class);

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("870000148");
        List<BM_SyouhnZokusei> listTkSyouhnZokusei = new ArrayList<>();
        BM_SyouhnZokusei syouhnZokusei1 = new BM_SyouhnZokusei();
        syouhnZokusei1.setSyouhncd("ｱ1");
        syouhnZokusei1.setSyouhnsdno(1);

        syouhnZokusei1.setNkhknumu(C_UmuKbn.ARI);

        syouhnZokusei1.setSyouhnnm("商品名００１");

        BM_SyouhnZokusei syouhnZokusei2 = new BM_SyouhnZokusei();
        syouhnZokusei2.setSyouhncd("ｱ8");
        syouhnZokusei2.setSyouhnsdno(1);

        syouhnZokusei2.setSyouhnnm("商品名００２");

        BM_SyouhnZokusei syouhnZokusei3 = new BM_SyouhnZokusei();
        syouhnZokusei3.setSyouhncd("ｱ9");
        syouhnZokusei3.setSyouhnsdno(1);
        syouhnZokusei3.setSyouhnnm("商品名００３");

        listTkSyouhnZokusei.add(syouhnZokusei1);
        listTkSyouhnZokusei.add(syouhnZokusei2);
        listTkSyouhnZokusei.add(syouhnZokusei3);

        mosnaiCheckParam.setListTkSyouhnZokusei(listTkSyouhnZokusei);

        BM_SyouhnZokusei syouhnZokusei = new BM_SyouhnZokusei();
        syouhnZokusei.setSyouhncd("ﾕｹ");
        syouhnZokusei.setSyouhnsdno(1);

        syouhnZokusei.setSyouhnnm("商品名０００");

        syouhnZokusei.setYoteirirituhendoukbn(C_YoteirirituhendouKbn.TUKI1KAI);

        syouhnZokusei.setNkhknumu(C_UmuKbn.ARI);
        mosnaiCheckParam.setSyuSyouhnZokusei(syouhnZokusei);

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
    @TestOrder(3220)
    @Transactional
    public void testExec_A37() {
        MockObjectManager.initialize();
        CheckSaiteiPMockForSinkeiyaku.SYORIPTN = CheckSaiteiPMockForSinkeiyaku.TESTPATTERN1;
        HanteiMoschkMockForSinkeiyaku.SYORIPTN = HanteiMoschkMockForSinkeiyaku.TESTPATTERN2;
        CheckTblMosSyouhin checkTblMosSyouhin = SWAKInjector.getInstance(CheckTblMosSyouhin.class);

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("870000155");
        List<BM_SyouhnZokusei> listTkSyouhnZokusei = new ArrayList<>();
        BM_SyouhnZokusei syouhnZokusei1 = new BM_SyouhnZokusei();
        syouhnZokusei1.setSyouhncd("ｱ1");
        syouhnZokusei1.setSyouhnsdno(1);

        syouhnZokusei1.setNkhknumu(C_UmuKbn.ARI);

        syouhnZokusei1.setSyouhnnm("商品名００１");

        BM_SyouhnZokusei syouhnZokusei2 = new BM_SyouhnZokusei();
        syouhnZokusei2.setSyouhncd("ｱ8");
        syouhnZokusei2.setSyouhnsdno(1);

        syouhnZokusei2.setSyouhnnm("商品名００２");

        BM_SyouhnZokusei syouhnZokusei3 = new BM_SyouhnZokusei();
        syouhnZokusei3.setSyouhncd("ｱ9");
        syouhnZokusei3.setSyouhnsdno(1);
        syouhnZokusei3.setSyouhnnm("商品名００３");

        listTkSyouhnZokusei.add(syouhnZokusei1);
        listTkSyouhnZokusei.add(syouhnZokusei2);
        listTkSyouhnZokusei.add(syouhnZokusei3);

        mosnaiCheckParam.setListTkSyouhnZokusei(listTkSyouhnZokusei);

        BM_SyouhnZokusei syouhnZokusei = new BM_SyouhnZokusei();
        syouhnZokusei.setSyouhncd("ﾕｹ");
        syouhnZokusei.setSyouhnsdno(1);

        syouhnZokusei.setSyouhnnm("商品名０００");

        syouhnZokusei.setYoteirirituhendoukbn(C_YoteirirituhendouKbn.TUKI1KAI);

        syouhnZokusei.setNkhknumu(C_UmuKbn.ARI);
        mosnaiCheckParam.setSyuSyouhnZokusei(syouhnZokusei);

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
    @TestOrder(3230)
    @Transactional
    public void testExec_A38() {
        MockObjectManager.initialize();
        CheckSaiteiPMockForSinkeiyaku.SYORIPTN = CheckSaiteiPMockForSinkeiyaku.TESTPATTERN1;
        HanteiMoschkMockForSinkeiyaku.SYORIPTN = HanteiMoschkMockForSinkeiyaku.TESTPATTERN2;
        CheckTblMosSyouhin checkTblMosSyouhin = SWAKInjector.getInstance(CheckTblMosSyouhin.class);

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("870000163");
        List<BM_SyouhnZokusei> listTkSyouhnZokusei = new ArrayList<>();
        BM_SyouhnZokusei syouhnZokusei1 = new BM_SyouhnZokusei();
        syouhnZokusei1.setSyouhncd("ｱ1");
        syouhnZokusei1.setSyouhnsdno(1);

        syouhnZokusei1.setNkhknumu(C_UmuKbn.ARI);

        syouhnZokusei1.setSyouhnnm("商品名００１");

        BM_SyouhnZokusei syouhnZokusei2 = new BM_SyouhnZokusei();
        syouhnZokusei2.setSyouhncd("ｱ8");
        syouhnZokusei2.setSyouhnsdno(1);

        syouhnZokusei2.setSyouhnnm("商品名００２");

        BM_SyouhnZokusei syouhnZokusei3 = new BM_SyouhnZokusei();
        syouhnZokusei3.setSyouhncd("ｱ9");
        syouhnZokusei3.setSyouhnsdno(1);
        syouhnZokusei3.setSyouhnnm("商品名００３");

        listTkSyouhnZokusei.add(syouhnZokusei1);
        listTkSyouhnZokusei.add(syouhnZokusei2);
        listTkSyouhnZokusei.add(syouhnZokusei3);

        mosnaiCheckParam.setListTkSyouhnZokusei(listTkSyouhnZokusei);

        BM_SyouhnZokusei syouhnZokusei = new BM_SyouhnZokusei();
        syouhnZokusei.setSyouhncd("ﾕｹ");
        syouhnZokusei.setSyouhnsdno(1);

        syouhnZokusei.setSyouhnnm("商品名０００");

        syouhnZokusei.setYoteirirituhendoukbn(C_YoteirirituhendouKbn.TUKI1KAI);

        syouhnZokusei.setNkhknumu(C_UmuKbn.ARI);
        mosnaiCheckParam.setSyuSyouhnZokusei(syouhnZokusei);

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
    @TestOrder(3240)
    @Transactional
    public void testExec_A39() {
        MockObjectManager.initialize();
        CheckSaiteiPMockForSinkeiyaku.SYORIPTN = CheckSaiteiPMockForSinkeiyaku.TESTPATTERN1;
        HanteiMoschkMockForSinkeiyaku.SYORIPTN = HanteiMoschkMockForSinkeiyaku.TESTPATTERN2;
        CheckTblMosSyouhin checkTblMosSyouhin = SWAKInjector.getInstance(CheckTblMosSyouhin.class);

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("870000171");
        List<BM_SyouhnZokusei> listTkSyouhnZokusei = new ArrayList<>();
        BM_SyouhnZokusei syouhnZokusei1 = new BM_SyouhnZokusei();
        syouhnZokusei1.setSyouhncd("ｱ1");
        syouhnZokusei1.setSyouhnsdno(1);

        syouhnZokusei1.setNkhknumu(C_UmuKbn.ARI);

        syouhnZokusei1.setSyouhnnm("商品名００１");

        BM_SyouhnZokusei syouhnZokusei2 = new BM_SyouhnZokusei();
        syouhnZokusei2.setSyouhncd("ｱ8");
        syouhnZokusei2.setSyouhnsdno(1);

        syouhnZokusei2.setSyouhnnm("商品名００２");

        BM_SyouhnZokusei syouhnZokusei3 = new BM_SyouhnZokusei();
        syouhnZokusei3.setSyouhncd("ｱ9");
        syouhnZokusei3.setSyouhnsdno(1);
        syouhnZokusei3.setSyouhnnm("商品名００３");

        listTkSyouhnZokusei.add(syouhnZokusei1);
        listTkSyouhnZokusei.add(syouhnZokusei2);
        listTkSyouhnZokusei.add(syouhnZokusei3);

        mosnaiCheckParam.setListTkSyouhnZokusei(listTkSyouhnZokusei);

        BM_SyouhnZokusei syouhnZokusei = new BM_SyouhnZokusei();
        syouhnZokusei.setSyouhncd("ﾕｹ");
        syouhnZokusei.setSyouhnsdno(1);

        syouhnZokusei.setSyouhnnm("商品名０００");

        syouhnZokusei.setYoteirirituhendoukbn(C_YoteirirituhendouKbn.TUKI1KAI);

        syouhnZokusei.setNkhknumu(C_UmuKbn.ARI);
        mosnaiCheckParam.setSyuSyouhnZokusei(syouhnZokusei);

        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setSysKbn(C_SysKbn.ESHIEN);
        mosnaiCheckParam.setKokutiChkHuyoUmu(C_UmuKbn.NONE);
        mosnaiCheckParam.setSysDate(BizDate.valueOf(20160102));
        mosnaiCheckParam.setSekmossakuseiSousasyaKbn(C_SeihowebsousasyaKbn.SUPPORTDESK);
        mosnaiCheckParam.setKiteiCheckChannelCd(C_Channelcd.TIGIN);

        checkTblMosSyouhin.exec(mosnaiCheckParam);

        exClassificationEquals(mosnaiCheckParam.getSekmossakuseiErroutKbn(), C_SekmossakuseiErroutKbn.GAMEN, "設計書申込書作成エラー出力区分");
        exStringEquals(mosnaiCheckParam.getSekmossakuseiErrmsg1(), "", "設計書申込書作成エラーメッセージ１");
        exStringEquals(mosnaiCheckParam.getSekmossakuseiErrmsg2(), "終身年金の据置期間５年は選択できません", "設計書申込書作成エラーメッセージ２");
        exClassificationEquals(mosnaiCheckParam.getKouzokuSyoriJikkouKbn(), C_KouzokujkKbn.NONE, "後続処理実行区分");
    }

    @Test
    @TestOrder(3250)
    @Transactional
    public void testExec_A40() {
        MockObjectManager.initialize();
        CheckSaiteiPMockForSinkeiyaku.SYORIPTN = CheckSaiteiPMockForSinkeiyaku.TESTPATTERN1;
        HanteiMoschkMockForSinkeiyaku.SYORIPTN = HanteiMoschkMockForSinkeiyaku.TESTPATTERN2;
        CheckTblMosSyouhin checkTblMosSyouhin = SWAKInjector.getInstance(CheckTblMosSyouhin.class);

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("870000189");
        List<BM_SyouhnZokusei> listTkSyouhnZokusei = new ArrayList<>();
        BM_SyouhnZokusei syouhnZokusei1 = new BM_SyouhnZokusei();
        syouhnZokusei1.setSyouhncd("ｱ1");
        syouhnZokusei1.setSyouhnsdno(1);

        syouhnZokusei1.setNkhknumu(C_UmuKbn.ARI);

        syouhnZokusei1.setSyouhnnm("商品名００１");

        BM_SyouhnZokusei syouhnZokusei2 = new BM_SyouhnZokusei();
        syouhnZokusei2.setSyouhncd("ｱ8");
        syouhnZokusei2.setSyouhnsdno(1);

        syouhnZokusei2.setSyouhnnm("商品名００２");

        BM_SyouhnZokusei syouhnZokusei3 = new BM_SyouhnZokusei();
        syouhnZokusei3.setSyouhncd("ｱ9");
        syouhnZokusei3.setSyouhnsdno(1);
        syouhnZokusei3.setSyouhnnm("商品名００３");

        listTkSyouhnZokusei.add(syouhnZokusei1);
        listTkSyouhnZokusei.add(syouhnZokusei2);
        listTkSyouhnZokusei.add(syouhnZokusei3);

        mosnaiCheckParam.setListTkSyouhnZokusei(listTkSyouhnZokusei);

        BM_SyouhnZokusei syouhnZokusei = new BM_SyouhnZokusei();
        syouhnZokusei.setSyouhncd("ﾕｹ");
        syouhnZokusei.setSyouhnsdno(1);

        syouhnZokusei.setSyouhnnm("商品名０００");

        syouhnZokusei.setYoteirirituhendoukbn(C_YoteirirituhendouKbn.TUKI1KAI);

        syouhnZokusei.setNkhknumu(C_UmuKbn.ARI);
        mosnaiCheckParam.setSyuSyouhnZokusei(syouhnZokusei);

        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setSysKbn(C_SysKbn.ESHIEN);
        mosnaiCheckParam.setKokutiChkHuyoUmu(C_UmuKbn.NONE);
        mosnaiCheckParam.setSysDate(BizDate.valueOf(20160102));
        mosnaiCheckParam.setSekmossakuseiSousasyaKbn(C_SeihowebsousasyaKbn.SUPPORTDESK);
        mosnaiCheckParam.setKiteiCheckChannelCd(C_Channelcd.TIGIN);

        checkTblMosSyouhin.exec(mosnaiCheckParam);

        exClassificationEquals(mosnaiCheckParam.getSekmossakuseiErroutKbn(), C_SekmossakuseiErroutKbn.GAMEN, "設計書申込書作成エラー出力区分");
        exStringEquals(mosnaiCheckParam.getSekmossakuseiErrmsg1(), "", "設計書申込書作成エラーメッセージ１");
        exStringEquals(mosnaiCheckParam.getSekmossakuseiErrmsg2(), "終身年金の据置期間５年は選択できません", "設計書申込書作成エラーメッセージ２");
        exClassificationEquals(mosnaiCheckParam.getKouzokuSyoriJikkouKbn(), C_KouzokujkKbn.NONE, "後続処理実行区分");
    }

    @Test
    @TestOrder(3260)
    @Transactional
    public void testExec_A41() {
        MockObjectManager.initialize();
        CheckSaiteiPMockForSinkeiyaku.SYORIPTN = CheckSaiteiPMockForSinkeiyaku.TESTPATTERN1;
        HanteiMoschkMockForSinkeiyaku.SYORIPTN = HanteiMoschkMockForSinkeiyaku.TESTPATTERN2;
        CheckTblMosSyouhin checkTblMosSyouhin = SWAKInjector.getInstance(CheckTblMosSyouhin.class);

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("870000197");
        List<BM_SyouhnZokusei> listTkSyouhnZokusei = new ArrayList<>();
        BM_SyouhnZokusei syouhnZokusei1 = new BM_SyouhnZokusei();
        syouhnZokusei1.setSyouhncd("ｱ1");
        syouhnZokusei1.setSyouhnsdno(1);

        syouhnZokusei1.setNkhknumu(C_UmuKbn.ARI);

        syouhnZokusei1.setSyouhnnm("商品名００１");

        BM_SyouhnZokusei syouhnZokusei2 = new BM_SyouhnZokusei();
        syouhnZokusei2.setSyouhncd("ｱ8");
        syouhnZokusei2.setSyouhnsdno(1);

        syouhnZokusei2.setSyouhnnm("商品名００２");

        BM_SyouhnZokusei syouhnZokusei3 = new BM_SyouhnZokusei();
        syouhnZokusei3.setSyouhncd("ｱ9");
        syouhnZokusei3.setSyouhnsdno(1);
        syouhnZokusei3.setSyouhnnm("商品名００３");

        listTkSyouhnZokusei.add(syouhnZokusei1);
        listTkSyouhnZokusei.add(syouhnZokusei2);
        listTkSyouhnZokusei.add(syouhnZokusei3);

        mosnaiCheckParam.setListTkSyouhnZokusei(listTkSyouhnZokusei);

        BM_SyouhnZokusei syouhnZokusei = new BM_SyouhnZokusei();
        syouhnZokusei.setSyouhncd("ﾕｹ");
        syouhnZokusei.setSyouhnsdno(1);

        syouhnZokusei.setSyouhnnm("商品名０００");

        syouhnZokusei.setYoteirirituhendoukbn(C_YoteirirituhendouKbn.TUKI1KAI);

        syouhnZokusei.setNkhknumu(C_UmuKbn.ARI);
        mosnaiCheckParam.setSyuSyouhnZokusei(syouhnZokusei);

        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setSysKbn(C_SysKbn.ESHIEN);
        mosnaiCheckParam.setKokutiChkHuyoUmu(C_UmuKbn.NONE);
        mosnaiCheckParam.setSysDate(BizDate.valueOf(20160102));
        mosnaiCheckParam.setSekmossakuseiSousasyaKbn(C_SeihowebsousasyaKbn.SUPPORTDESK);
        mosnaiCheckParam.setKiteiCheckChannelCd(C_Channelcd.TIGIN);

        checkTblMosSyouhin.exec(mosnaiCheckParam);

        exClassificationEquals(mosnaiCheckParam.getSekmossakuseiErroutKbn(), C_SekmossakuseiErroutKbn.GAMEN, "設計書申込書作成エラー出力区分");
        exStringEquals(mosnaiCheckParam.getSekmossakuseiErrmsg1(), "", "設計書申込書作成エラーメッセージ１");
        exStringEquals(mosnaiCheckParam.getSekmossakuseiErrmsg2(), "終身年金の据置期間５年は選択できません", "設計書申込書作成エラーメッセージ２");
        exClassificationEquals(mosnaiCheckParam.getKouzokuSyoriJikkouKbn(), C_KouzokujkKbn.NONE, "後続処理実行区分");
    }

    @Test
    @TestOrder(3270)
    @Transactional
    public void testExec_A42() {
        MockObjectManager.initialize();
        CheckSaiteiPMockForSinkeiyaku.SYORIPTN = CheckSaiteiPMockForSinkeiyaku.TESTPATTERN1;
        HanteiMoschkMockForSinkeiyaku.SYORIPTN = HanteiMoschkMockForSinkeiyaku.TESTPATTERN2;
        CheckTblMosSyouhin checkTblMosSyouhin = SWAKInjector.getInstance(CheckTblMosSyouhin.class);

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("870000205");
        List<BM_SyouhnZokusei> listTkSyouhnZokusei = new ArrayList<>();
        BM_SyouhnZokusei syouhnZokusei1 = new BM_SyouhnZokusei();
        syouhnZokusei1.setSyouhncd("ｱ1");
        syouhnZokusei1.setSyouhnsdno(1);

        syouhnZokusei1.setNkhknumu(C_UmuKbn.ARI);

        syouhnZokusei1.setSyouhnnm("商品名００１");

        BM_SyouhnZokusei syouhnZokusei2 = new BM_SyouhnZokusei();
        syouhnZokusei2.setSyouhncd("ｱ8");
        syouhnZokusei2.setSyouhnsdno(1);

        syouhnZokusei2.setSyouhnnm("商品名００２");

        BM_SyouhnZokusei syouhnZokusei3 = new BM_SyouhnZokusei();
        syouhnZokusei3.setSyouhncd("ｱ9");
        syouhnZokusei3.setSyouhnsdno(1);
        syouhnZokusei3.setSyouhnnm("商品名００３");

        listTkSyouhnZokusei.add(syouhnZokusei1);
        listTkSyouhnZokusei.add(syouhnZokusei2);
        listTkSyouhnZokusei.add(syouhnZokusei3);

        mosnaiCheckParam.setListTkSyouhnZokusei(listTkSyouhnZokusei);

        BM_SyouhnZokusei syouhnZokusei = new BM_SyouhnZokusei();
        syouhnZokusei.setSyouhncd("ﾕｹ");
        syouhnZokusei.setSyouhnsdno(1);

        syouhnZokusei.setSyouhnnm("商品名０００");

        syouhnZokusei.setYoteirirituhendoukbn(C_YoteirirituhendouKbn.TUKI1KAI);

        syouhnZokusei.setNkhknumu(C_UmuKbn.ARI);
        mosnaiCheckParam.setSyuSyouhnZokusei(syouhnZokusei);

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
    @TestOrder(3280)
    @Transactional
    public void testExec_A43() {
        MockObjectManager.initialize();
        CheckSaiteiPMockForSinkeiyaku.SYORIPTN = CheckSaiteiPMockForSinkeiyaku.TESTPATTERN1;
        HanteiMoschkMockForSinkeiyaku.SYORIPTN = HanteiMoschkMockForSinkeiyaku.TESTPATTERN2;
        CheckTblMosSyouhin checkTblMosSyouhin = SWAKInjector.getInstance(CheckTblMosSyouhin.class);

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("870000213");
        List<BM_SyouhnZokusei> listTkSyouhnZokusei = new ArrayList<>();
        BM_SyouhnZokusei syouhnZokusei1 = new BM_SyouhnZokusei();
        syouhnZokusei1.setSyouhncd("ｱ1");
        syouhnZokusei1.setSyouhnsdno(1);

        syouhnZokusei1.setNkhknumu(C_UmuKbn.ARI);

        syouhnZokusei1.setSyouhnnm("商品名００１");

        BM_SyouhnZokusei syouhnZokusei2 = new BM_SyouhnZokusei();
        syouhnZokusei2.setSyouhncd("ｱ8");
        syouhnZokusei2.setSyouhnsdno(1);

        syouhnZokusei2.setSyouhnnm("商品名００２");

        BM_SyouhnZokusei syouhnZokusei3 = new BM_SyouhnZokusei();
        syouhnZokusei3.setSyouhncd("ｱ9");
        syouhnZokusei3.setSyouhnsdno(1);
        syouhnZokusei3.setSyouhnnm("商品名００３");

        listTkSyouhnZokusei.add(syouhnZokusei1);
        listTkSyouhnZokusei.add(syouhnZokusei2);
        listTkSyouhnZokusei.add(syouhnZokusei3);

        mosnaiCheckParam.setListTkSyouhnZokusei(listTkSyouhnZokusei);

        BM_SyouhnZokusei syouhnZokusei = new BM_SyouhnZokusei();
        syouhnZokusei.setSyouhncd("ﾕｹ");
        syouhnZokusei.setSyouhnsdno(1);

        syouhnZokusei.setSyouhnnm("商品名０００");

        syouhnZokusei.setYoteirirituhendoukbn(C_YoteirirituhendouKbn.TUKI1KAI);

        syouhnZokusei.setNkhknumu(C_UmuKbn.ARI);
        mosnaiCheckParam.setSyuSyouhnZokusei(syouhnZokusei);

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
    @TestOrder(3290)
    @Transactional
    public void testExec_A44() {
        MockObjectManager.initialize();
        CheckSaiteiPMockForSinkeiyaku.SYORIPTN = CheckSaiteiPMockForSinkeiyaku.TESTPATTERN1;
        HanteiMoschkMockForSinkeiyaku.SYORIPTN = HanteiMoschkMockForSinkeiyaku.TESTPATTERN2;
        CheckTblMosSyouhin checkTblMosSyouhin = SWAKInjector.getInstance(CheckTblMosSyouhin.class);

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("870000221");
        List<BM_SyouhnZokusei> listTkSyouhnZokusei = new ArrayList<>();
        BM_SyouhnZokusei syouhnZokusei1 = new BM_SyouhnZokusei();
        syouhnZokusei1.setSyouhncd("ｱ1");
        syouhnZokusei1.setSyouhnsdno(1);

        syouhnZokusei1.setNkhknumu(C_UmuKbn.ARI);

        syouhnZokusei1.setSyouhnnm("商品名００１");

        BM_SyouhnZokusei syouhnZokusei2 = new BM_SyouhnZokusei();
        syouhnZokusei2.setSyouhncd("ｱ8");
        syouhnZokusei2.setSyouhnsdno(1);

        syouhnZokusei2.setSyouhnnm("商品名００２");

        BM_SyouhnZokusei syouhnZokusei3 = new BM_SyouhnZokusei();
        syouhnZokusei3.setSyouhncd("ｱ9");
        syouhnZokusei3.setSyouhnsdno(1);
        syouhnZokusei3.setSyouhnnm("商品名００３");

        listTkSyouhnZokusei.add(syouhnZokusei1);
        listTkSyouhnZokusei.add(syouhnZokusei2);
        listTkSyouhnZokusei.add(syouhnZokusei3);

        mosnaiCheckParam.setListTkSyouhnZokusei(listTkSyouhnZokusei);

        BM_SyouhnZokusei syouhnZokusei = new BM_SyouhnZokusei();
        syouhnZokusei.setSyouhncd("ﾕｹ");
        syouhnZokusei.setSyouhnsdno(1);

        syouhnZokusei.setSyouhnnm("商品名０００");

        syouhnZokusei.setYoteirirituhendoukbn(C_YoteirirituhendouKbn.TUKI1KAI);

        syouhnZokusei.setNkhknumu(C_UmuKbn.ARI);
        mosnaiCheckParam.setSyuSyouhnZokusei(syouhnZokusei);

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
    @TestOrder(3300)
    @Transactional
    public void testExec_A45() {
        MockObjectManager.initialize();
        CheckSaiteiPMockForSinkeiyaku.SYORIPTN = CheckSaiteiPMockForSinkeiyaku.TESTPATTERN1;
        HanteiMoschkMockForSinkeiyaku.SYORIPTN = HanteiMoschkMockForSinkeiyaku.TESTPATTERN2;
        CheckTblMosSyouhin checkTblMosSyouhin = SWAKInjector.getInstance(CheckTblMosSyouhin.class);

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("870000239");
        List<BM_SyouhnZokusei> listTkSyouhnZokusei = new ArrayList<>();
        BM_SyouhnZokusei syouhnZokusei1 = new BM_SyouhnZokusei();
        syouhnZokusei1.setSyouhncd("ｱ1");
        syouhnZokusei1.setSyouhnsdno(1);

        syouhnZokusei1.setNkhknumu(C_UmuKbn.ARI);

        syouhnZokusei1.setSyouhnnm("商品名００１");

        BM_SyouhnZokusei syouhnZokusei2 = new BM_SyouhnZokusei();
        syouhnZokusei2.setSyouhncd("ｱ8");
        syouhnZokusei2.setSyouhnsdno(1);

        syouhnZokusei2.setSyouhnnm("商品名００２");

        BM_SyouhnZokusei syouhnZokusei3 = new BM_SyouhnZokusei();
        syouhnZokusei3.setSyouhncd("ｱ9");
        syouhnZokusei3.setSyouhnsdno(1);
        syouhnZokusei3.setSyouhnnm("商品名００３");

        listTkSyouhnZokusei.add(syouhnZokusei1);
        listTkSyouhnZokusei.add(syouhnZokusei2);
        listTkSyouhnZokusei.add(syouhnZokusei3);

        mosnaiCheckParam.setListTkSyouhnZokusei(listTkSyouhnZokusei);

        BM_SyouhnZokusei syouhnZokusei = new BM_SyouhnZokusei();
        syouhnZokusei.setSyouhncd("ﾕｹ");
        syouhnZokusei.setSyouhnsdno(1);

        syouhnZokusei.setSyouhnnm("商品名０００");

        syouhnZokusei.setYoteirirituhendoukbn(C_YoteirirituhendouKbn.TUKI1KAI);

        syouhnZokusei.setNkhknumu(C_UmuKbn.ARI);
        mosnaiCheckParam.setSyuSyouhnZokusei(syouhnZokusei);

        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setSysKbn(C_SysKbn.ESHIEN);
        mosnaiCheckParam.setKokutiChkHuyoUmu(C_UmuKbn.NONE);
        mosnaiCheckParam.setSysDate(BizDate.valueOf(20160102));
        mosnaiCheckParam.setSekmossakuseiSousasyaKbn(C_SeihowebsousasyaKbn.SUPPORTDESK);
        mosnaiCheckParam.setKiteiCheckChannelCd(C_Channelcd.TIGIN);

        checkTblMosSyouhin.exec(mosnaiCheckParam);

        exClassificationEquals(mosnaiCheckParam.getSekmossakuseiErroutKbn(), C_SekmossakuseiErroutKbn.GAMEN, "設計書申込書作成エラー出力区分");
        exStringEquals(mosnaiCheckParam.getSekmossakuseiErrmsg1(), "", "設計書申込書作成エラーメッセージ１");
        exStringEquals(mosnaiCheckParam.getSekmossakuseiErrmsg2(), "終身年金は選択できません", "設計書申込書作成エラーメッセージ２");
        exClassificationEquals(mosnaiCheckParam.getKouzokuSyoriJikkouKbn(), C_KouzokujkKbn.NONE, "後続処理実行区分");
    }

    @Test
    @TestOrder(3310)
    @Transactional
    public void testExec_A46() {
        MockObjectManager.initialize();
        CheckSaiteiPMockForSinkeiyaku.SYORIPTN = CheckSaiteiPMockForSinkeiyaku.TESTPATTERN1;
        HanteiMoschkMockForSinkeiyaku.SYORIPTN = HanteiMoschkMockForSinkeiyaku.TESTPATTERN2;
        CheckTblMosSyouhin checkTblMosSyouhin = SWAKInjector.getInstance(CheckTblMosSyouhin.class);

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("870000247");
        List<BM_SyouhnZokusei> listTkSyouhnZokusei = new ArrayList<>();
        BM_SyouhnZokusei syouhnZokusei1 = new BM_SyouhnZokusei();
        syouhnZokusei1.setSyouhncd("ｱ1");
        syouhnZokusei1.setSyouhnsdno(1);

        syouhnZokusei1.setNkhknumu(C_UmuKbn.ARI);

        syouhnZokusei1.setSyouhnnm("商品名００１");

        BM_SyouhnZokusei syouhnZokusei2 = new BM_SyouhnZokusei();
        syouhnZokusei2.setSyouhncd("ｱ8");
        syouhnZokusei2.setSyouhnsdno(1);

        syouhnZokusei2.setSyouhnnm("商品名００２");

        BM_SyouhnZokusei syouhnZokusei3 = new BM_SyouhnZokusei();
        syouhnZokusei3.setSyouhncd("ｱ9");
        syouhnZokusei3.setSyouhnsdno(1);
        syouhnZokusei3.setSyouhnnm("商品名００３");

        listTkSyouhnZokusei.add(syouhnZokusei1);
        listTkSyouhnZokusei.add(syouhnZokusei2);
        listTkSyouhnZokusei.add(syouhnZokusei3);

        mosnaiCheckParam.setListTkSyouhnZokusei(listTkSyouhnZokusei);

        BM_SyouhnZokusei syouhnZokusei = new BM_SyouhnZokusei();
        syouhnZokusei.setSyouhncd("ﾕｹ");
        syouhnZokusei.setSyouhnsdno(1);

        syouhnZokusei.setSyouhnnm("商品名０００");

        syouhnZokusei.setYoteirirituhendoukbn(C_YoteirirituhendouKbn.TUKI1KAI);

        syouhnZokusei.setNkhknumu(C_UmuKbn.ARI);
        mosnaiCheckParam.setSyuSyouhnZokusei(syouhnZokusei);

        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setSysKbn(C_SysKbn.ESHIEN);
        mosnaiCheckParam.setKokutiChkHuyoUmu(C_UmuKbn.NONE);
        mosnaiCheckParam.setSysDate(BizDate.valueOf(20160102));
        mosnaiCheckParam.setSekmossakuseiSousasyaKbn(C_SeihowebsousasyaKbn.SUPPORTDESK);
        mosnaiCheckParam.setKiteiCheckChannelCd(C_Channelcd.TIGIN);

        checkTblMosSyouhin.exec(mosnaiCheckParam);

        exClassificationEquals(mosnaiCheckParam.getSekmossakuseiErroutKbn(), C_SekmossakuseiErroutKbn.GAMEN, "設計書申込書作成エラー出力区分");
        exStringEquals(mosnaiCheckParam.getSekmossakuseiErrmsg1(), "", "設計書申込書作成エラーメッセージ１");
        exStringEquals(mosnaiCheckParam.getSekmossakuseiErrmsg2(), "終身年金は選択できません", "設計書申込書作成エラーメッセージ２");
        exClassificationEquals(mosnaiCheckParam.getKouzokuSyoriJikkouKbn(), C_KouzokujkKbn.NONE, "後続処理実行区分");
    }

    @Test
    @TestOrder(3320)
    @Transactional
    public void testExec_A47() {
        MockObjectManager.initialize();
        CheckSaiteiPMockForSinkeiyaku.SYORIPTN = CheckSaiteiPMockForSinkeiyaku.TESTPATTERN1;
        HanteiMoschkMockForSinkeiyaku.SYORIPTN = HanteiMoschkMockForSinkeiyaku.TESTPATTERN2;
        CheckTblMosSyouhin checkTblMosSyouhin = SWAKInjector.getInstance(CheckTblMosSyouhin.class);

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("870000254");
        List<BM_SyouhnZokusei> listTkSyouhnZokusei = new ArrayList<>();
        BM_SyouhnZokusei syouhnZokusei1 = new BM_SyouhnZokusei();
        syouhnZokusei1.setSyouhncd("ｱ1");
        syouhnZokusei1.setSyouhnsdno(1);

        syouhnZokusei1.setNkhknumu(C_UmuKbn.ARI);

        syouhnZokusei1.setSyouhnnm("商品名００１");

        BM_SyouhnZokusei syouhnZokusei2 = new BM_SyouhnZokusei();
        syouhnZokusei2.setSyouhncd("ｱ8");
        syouhnZokusei2.setSyouhnsdno(1);

        syouhnZokusei2.setSyouhnnm("商品名００２");

        BM_SyouhnZokusei syouhnZokusei3 = new BM_SyouhnZokusei();
        syouhnZokusei3.setSyouhncd("ｱ9");
        syouhnZokusei3.setSyouhnsdno(1);
        syouhnZokusei3.setSyouhnnm("商品名００３");

        listTkSyouhnZokusei.add(syouhnZokusei1);
        listTkSyouhnZokusei.add(syouhnZokusei2);
        listTkSyouhnZokusei.add(syouhnZokusei3);

        mosnaiCheckParam.setListTkSyouhnZokusei(listTkSyouhnZokusei);

        BM_SyouhnZokusei syouhnZokusei = new BM_SyouhnZokusei();
        syouhnZokusei.setSyouhncd("ﾕｹ");
        syouhnZokusei.setSyouhnsdno(1);

        syouhnZokusei.setSyouhnnm("商品名０００");

        syouhnZokusei.setYoteirirituhendoukbn(C_YoteirirituhendouKbn.TUKI1KAI);

        syouhnZokusei.setNkhknumu(C_UmuKbn.ARI);
        mosnaiCheckParam.setSyuSyouhnZokusei(syouhnZokusei);

        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setSysKbn(C_SysKbn.ESHIEN);
        mosnaiCheckParam.setKokutiChkHuyoUmu(C_UmuKbn.NONE);
        mosnaiCheckParam.setSysDate(BizDate.valueOf(20160102));
        mosnaiCheckParam.setSekmossakuseiSousasyaKbn(C_SeihowebsousasyaKbn.SUPPORTDESK);
        mosnaiCheckParam.setKiteiCheckChannelCd(C_Channelcd.TIGIN);

        checkTblMosSyouhin.exec(mosnaiCheckParam);

        exClassificationEquals(mosnaiCheckParam.getSekmossakuseiErroutKbn(), C_SekmossakuseiErroutKbn.GAMEN, "設計書申込書作成エラー出力区分");
        exStringEquals(mosnaiCheckParam.getSekmossakuseiErrmsg1(), "", "設計書申込書作成エラーメッセージ１");
        exStringEquals(mosnaiCheckParam.getSekmossakuseiErrmsg2(), "終身年金は選択できません", "設計書申込書作成エラーメッセージ２");
        exClassificationEquals(mosnaiCheckParam.getKouzokuSyoriJikkouKbn(), C_KouzokujkKbn.NONE, "後続処理実行区分");
    }


    @Test
    @TestOrder(3330)
    @Transactional
    public void testExec_A48() {
        MockObjectManager.initialize();
        CheckSaiteiPMockForSinkeiyaku.SYORIPTN = CheckSaiteiPMockForSinkeiyaku.TESTPATTERN1;
        HanteiMoschkMockForSinkeiyaku.SYORIPTN = HanteiMoschkMockForSinkeiyaku.TESTPATTERN2;
        CheckTblMosSyouhin checkTblMosSyouhin = SWAKInjector.getInstance(CheckTblMosSyouhin.class);

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("870000262");
        List<BM_SyouhnZokusei> listTkSyouhnZokusei = new ArrayList<>();
        BM_SyouhnZokusei syouhnZokusei1 = new BM_SyouhnZokusei();
        syouhnZokusei1.setSyouhncd("ｱ1");
        syouhnZokusei1.setSyouhnsdno(1);

        syouhnZokusei1.setNkhknumu(C_UmuKbn.ARI);

        syouhnZokusei1.setSyouhnnm("商品名００１");

        BM_SyouhnZokusei syouhnZokusei2 = new BM_SyouhnZokusei();
        syouhnZokusei2.setSyouhncd("ｱ8");
        syouhnZokusei2.setSyouhnsdno(1);

        syouhnZokusei2.setSyouhnnm("商品名００２");

        BM_SyouhnZokusei syouhnZokusei3 = new BM_SyouhnZokusei();
        syouhnZokusei3.setSyouhncd("ｱ9");
        syouhnZokusei3.setSyouhnsdno(1);
        syouhnZokusei3.setSyouhnnm("商品名００３");

        listTkSyouhnZokusei.add(syouhnZokusei1);
        listTkSyouhnZokusei.add(syouhnZokusei2);
        listTkSyouhnZokusei.add(syouhnZokusei3);

        mosnaiCheckParam.setListTkSyouhnZokusei(listTkSyouhnZokusei);

        BM_SyouhnZokusei syouhnZokusei = new BM_SyouhnZokusei();
        syouhnZokusei.setSyouhncd("ｱ1");
        syouhnZokusei.setSyouhnsdno(1);

        syouhnZokusei.setSyouhnnm("商品名０００");

        syouhnZokusei.setYoteirirituhendoukbn(C_YoteirirituhendouKbn.TUKI1KAI);

        syouhnZokusei.setNkhknumu(C_UmuKbn.ARI);
        mosnaiCheckParam.setSyuSyouhnZokusei(syouhnZokusei);

        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setSysKbn(C_SysKbn.ESHIEN);
        mosnaiCheckParam.setKokutiChkHuyoUmu(C_UmuKbn.NONE);
        mosnaiCheckParam.setSysDate(BizDate.valueOf(20160102));
        mosnaiCheckParam.setSekmossakuseiSousasyaKbn(C_SeihowebsousasyaKbn.SUPPORTDESK);
        mosnaiCheckParam.setKiteiCheckChannelCd(C_Channelcd.TIGIN);

        checkTblMosSyouhin.exec(mosnaiCheckParam);

        exClassificationEquals(mosnaiCheckParam.getSekmossakuseiErroutKbn(), C_SekmossakuseiErroutKbn.GAMEN, "設計書申込書作成エラー出力区分");
        exStringEquals(mosnaiCheckParam.getSekmossakuseiErrmsg1(), "", "設計書申込書作成エラーメッセージ１");
        exStringEquals(mosnaiCheckParam.getSekmossakuseiErrmsg2(), "募集年齢範囲外です　当予定利率期間の募集年齢範囲は１歳から１０歳です", "設計書申込書作成エラーメッセージ２");
        exClassificationEquals(mosnaiCheckParam.getKouzokuSyoriJikkouKbn(), C_KouzokujkKbn.NONE, "後続処理実行区分");

    }

    @Test
    @TestOrder(3340)
    @Transactional
    public void testExec_A49() {
        MockObjectManager.initialize();
        CheckSaiteiPMockForSinkeiyaku.SYORIPTN = CheckSaiteiPMockForSinkeiyaku.TESTPATTERN1;
        HanteiMoschkMockForSinkeiyaku.SYORIPTN = HanteiMoschkMockForSinkeiyaku.TESTPATTERN2;
        CheckTblMosSyouhin checkTblMosSyouhin = SWAKInjector.getInstance(CheckTblMosSyouhin.class);

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("870000262");
        List<BM_SyouhnZokusei> listTkSyouhnZokusei = new ArrayList<>();
        BM_SyouhnZokusei syouhnZokusei1 = new BM_SyouhnZokusei();
        syouhnZokusei1.setSyouhncd("ｱ1");
        syouhnZokusei1.setSyouhnsdno(1);

        syouhnZokusei1.setNkhknumu(C_UmuKbn.ARI);

        syouhnZokusei1.setSyouhnnm("商品名００１");

        BM_SyouhnZokusei syouhnZokusei2 = new BM_SyouhnZokusei();
        syouhnZokusei2.setSyouhncd("ｱ8");
        syouhnZokusei2.setSyouhnsdno(1);

        syouhnZokusei2.setSyouhnnm("商品名００２");

        BM_SyouhnZokusei syouhnZokusei3 = new BM_SyouhnZokusei();
        syouhnZokusei3.setSyouhncd("ｱ9");
        syouhnZokusei3.setSyouhnsdno(1);
        syouhnZokusei3.setSyouhnnm("商品名００３");

        listTkSyouhnZokusei.add(syouhnZokusei1);
        listTkSyouhnZokusei.add(syouhnZokusei2);
        listTkSyouhnZokusei.add(syouhnZokusei3);

        mosnaiCheckParam.setListTkSyouhnZokusei(listTkSyouhnZokusei);

        BM_SyouhnZokusei syouhnZokusei = new BM_SyouhnZokusei();
        syouhnZokusei.setSyouhncd("ｱ1");
        syouhnZokusei.setSyouhnsdno(1);

        syouhnZokusei.setSyouhnnm("商品名０００");

        syouhnZokusei.setYoteirirituhendoukbn(C_YoteirirituhendouKbn.NONE);

        syouhnZokusei.setNkhknumu(C_UmuKbn.NONE);
        mosnaiCheckParam.setSyuSyouhnZokusei(syouhnZokusei);

        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setSysKbn(C_SysKbn.ESHIEN);
        mosnaiCheckParam.setKokutiChkHuyoUmu(C_UmuKbn.NONE);
        mosnaiCheckParam.setSysDate(BizDate.valueOf(20160102));
        mosnaiCheckParam.setSekmossakuseiSousasyaKbn(C_SeihowebsousasyaKbn.SUPPORTDESK);
        mosnaiCheckParam.setKiteiCheckChannelCd(C_Channelcd.TIGIN);

        checkTblMosSyouhin.exec(mosnaiCheckParam);

        exClassificationEquals(mosnaiCheckParam.getSekmossakuseiErroutKbn(), C_SekmossakuseiErroutKbn.GAMEN, "設計書申込書作成エラー出力区分");
        exStringEquals(mosnaiCheckParam.getSekmossakuseiErrmsg1(), "", "設計書申込書作成エラーメッセージ１");
        exStringEquals(mosnaiCheckParam.getSekmossakuseiErrmsg2(), "契約年齢範囲外です　契約年齢は１歳から１０歳です", "設計書申込書作成エラーメッセージ２");
        exClassificationEquals(mosnaiCheckParam.getKouzokuSyoriJikkouKbn(), C_KouzokujkKbn.NONE, "後続処理実行区分");
    }

    @Test
    @TestOrder(3350)
    @Transactional
    public void testExec_A50() {
        MockObjectManager.initialize();
        CheckSaiteiPMockForSinkeiyaku.SYORIPTN = CheckSaiteiPMockForSinkeiyaku.TESTPATTERN1;
        HanteiMoschkMockForSinkeiyaku.SYORIPTN = HanteiMoschkMockForSinkeiyaku.TESTPATTERN2;
        CheckTblMosSyouhin checkTblMosSyouhin = SWAKInjector.getInstance(CheckTblMosSyouhin.class);

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("860000025");
        List<BM_SyouhnZokusei> listTkSyouhnZokusei = new ArrayList<>();
        BM_SyouhnZokusei syouhnZokusei1 = new BM_SyouhnZokusei();
        syouhnZokusei1.setSyouhncd("ｱ1");
        syouhnZokusei1.setSyouhnsdno(1);

        syouhnZokusei1.setNkhknumu(C_UmuKbn.ARI);

        syouhnZokusei1.setSyouhnnm("商品名００１");

        BM_SyouhnZokusei syouhnZokusei2 = new BM_SyouhnZokusei();
        syouhnZokusei2.setSyouhncd("ｱ8");
        syouhnZokusei2.setSyouhnsdno(1);

        syouhnZokusei2.setSyouhnnm("商品名００２");

        BM_SyouhnZokusei syouhnZokusei3 = new BM_SyouhnZokusei();
        syouhnZokusei3.setSyouhncd("ｱ9");
        syouhnZokusei3.setSyouhnsdno(1);
        syouhnZokusei3.setSyouhnnm("商品名００３");

        listTkSyouhnZokusei.add(syouhnZokusei1);
        listTkSyouhnZokusei.add(syouhnZokusei2);
        listTkSyouhnZokusei.add(syouhnZokusei3);

        mosnaiCheckParam.setListTkSyouhnZokusei(listTkSyouhnZokusei);

        BM_SyouhnZokusei syouhnZokusei = new BM_SyouhnZokusei();
        syouhnZokusei.setSyouhncd("ﾕｹ");
        syouhnZokusei.setSyouhnsdno(1);

        syouhnZokusei.setSyouhnnm("商品名０００");

        syouhnZokusei.setYoteirirituhendoukbn(C_YoteirirituhendouKbn.TUKI1KAI);

        syouhnZokusei.setNkhknumu(C_UmuKbn.ARI);
        mosnaiCheckParam.setSyuSyouhnZokusei(syouhnZokusei);

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
    @TestOrder(3360)
    @Transactional
    public void testExec_A51() {
        MockObjectManager.initialize();
        BzGetAgInfoMockForSinkeiyaku.SYORIPTN = BzGetAgInfoMockForSinkeiyaku.TESTPATTERN1;
        CheckSaiteiPMockForSinkeiyaku.SYORIPTN = CheckSaiteiPMockForSinkeiyaku.TESTPATTERN1;
        HanteiMoschkMockForSinkeiyaku.SYORIPTN = HanteiMoschkMockForSinkeiyaku.TESTPATTERN1;
        EditNenkinKoumokuUtilMockForSinkeiyaku.SYORIPTN = EditNenkinKoumokuUtilMockForSinkeiyaku.TESTPATTERN4;
        CheckTblMosSyouhin checkTblMosSyouhin = SWAKInjector.getInstance(CheckTblMosSyouhin.class);
        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("970002226");

        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setSysKbn(C_SysKbn.SKEI);
        mosnaiCheckParam.setKokutiChkHuyoUmu(C_UmuKbn.NONE);
        mosnaiCheckParam.setSysDate(BizDate.valueOf(20160102));
        mosnaiCheckParam.setSekmossakuseiSousasyaKbn(C_SeihowebsousasyaKbn.DIRTNBSYNN);
        mosnaiCheckParam.setListHubiMsg(new ArrayList<HT_HubiMsg>());
        mosnaiCheckParam.setKosID("JUnitTest");
        mosnaiCheckParam.setKosTime("20160509141230000");
        mosnaiCheckParam.setKiteiCheckChannelCd(C_Channelcd.TIGIN);

        List<BM_SyouhnZokusei> listTkSyouhnZokusei = new ArrayList<>();
        BM_SyouhnZokusei syouhnZokusei1 = new BM_SyouhnZokusei();
        syouhnZokusei1.setSyouhncd("ｱ1");
        syouhnZokusei1.setSyouhnsdno(1);

        syouhnZokusei1.setNkhknumu(C_UmuKbn.ARI);

        syouhnZokusei1.setSyouhnnm("商品名００１");

        BM_SyouhnZokusei syouhnZokusei2 = new BM_SyouhnZokusei();
        syouhnZokusei2.setSyouhncd("ｱ2");
        syouhnZokusei2.setSyouhnsdno(1);

        syouhnZokusei2.setSyouhnnm("商品名００２");

        BM_SyouhnZokusei syouhnZokusei3 = new BM_SyouhnZokusei();
        syouhnZokusei3.setSyouhncd("ｱ3");
        syouhnZokusei3.setSyouhnsdno(1);
        syouhnZokusei3.setSyouhnnm("商品名００３");

        listTkSyouhnZokusei.add(syouhnZokusei1);
        listTkSyouhnZokusei.add(syouhnZokusei2);
        listTkSyouhnZokusei.add(syouhnZokusei3);

        mosnaiCheckParam.setListTkSyouhnZokusei(listTkSyouhnZokusei);

        BM_SyouhnZokusei syouhnZokusei = new BM_SyouhnZokusei();
        syouhnZokusei.setSyouhncd("ｱ3");
        syouhnZokusei.setSyouhnsdno(1);

        syouhnZokusei.setSyouhnnm("商品名０００");
        syouhnZokusei.setKyhkataumu(C_UmuKbn.ARI);
        syouhnZokusei.setNkhknumu(C_UmuKbn.ARI);
        mosnaiCheckParam.setSyuSyouhnZokusei(syouhnZokusei);

        checkTblMosSyouhin.exec(mosnaiCheckParam);
        List<HT_HubiMsg> hubiMsgLst = mosnaiCheckParam.getListHubiMsg();
        boolean hanteiflg = true;
        exNumericEquals(hubiMsgLst.size(), 4, "不備メッセージテーブルエンティティリストのサイズ");
        for (HT_HubiMsg hubiMsg : hubiMsgLst) {
            if ("EBC0046".equals(hubiMsg.getMessageId())) {
                hanteiflg = false;
                exStringEquals(hubiMsg.getMosno(), "970002226", "申込番号");
                exNumericEquals(hubiMsg.getRenno(), 1, "連番");
                exStringEquals(hubiMsg.getMessageId(), "EBC0046", "メッセージＩＤ");
                exStringEquals(hubiMsg.getHubimsg(), "据置期間が正しくありません。", "不備メッセージ");
                exClassificationEquals(hubiMsg.getHubisyubetukbn(), C_HubisyubetuKbn.KETHORYU_HUBI, "不備種別区分");
                exClassificationEquals(hubiMsg.getHubisyubetusyousaikbn(), C_HubisyubetusyousaiKbn.NONE,
                    "不備種別詳細区分");
                exStringEquals(hubiMsg.getGyoumuKousinsyaId(), "JUnitTest", "業務用更新者ＩＤ");
                exStringEquals(hubiMsg.getGyoumuKousinTime(), "20160509141230000", "業務用更新時間");
            }
        }
        exBooleanEquals(hanteiflg, false, "メッセージＩＤが'EBC0046'のデータが存在する");

    }

    @Test
    @TestOrder(3370)
    @Transactional
    public void testExec_A52() {
        MockObjectManager.initialize();
        BzGetAgInfoMockForSinkeiyaku.SYORIPTN = BzGetAgInfoMockForSinkeiyaku.TESTPATTERN1;
        CheckSaiteiPMockForSinkeiyaku.SYORIPTN = CheckSaiteiPMockForSinkeiyaku.TESTPATTERN1;
        HanteiMoschkMockForSinkeiyaku.SYORIPTN = HanteiMoschkMockForSinkeiyaku.TESTPATTERN1;
        EditNenkinKoumokuUtilMockForSinkeiyaku.SYORIPTN = EditNenkinKoumokuUtilMockForSinkeiyaku.TESTPATTERN4;
        CheckTblMosSyouhin checkTblMosSyouhin = SWAKInjector.getInstance(CheckTblMosSyouhin.class);
        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("860000017");

        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setSysKbn(C_SysKbn.ESHIEN);
        mosnaiCheckParam.setKokutiChkHuyoUmu(C_UmuKbn.NONE);
        mosnaiCheckParam.setSysDate(BizDate.valueOf(20160102));
        mosnaiCheckParam.setSekmossakuseiSousasyaKbn(C_SeihowebsousasyaKbn.DIRTNBSYNN);
        mosnaiCheckParam.setListHubiMsg(new ArrayList<HT_HubiMsg>());
        mosnaiCheckParam.setKosID("JUnitTest");
        mosnaiCheckParam.setKosTime("20160509141230000");
        mosnaiCheckParam.setKiteiCheckChannelCd(C_Channelcd.MIZUHO);

        List<BM_SyouhnZokusei> listTkSyouhnZokusei = new ArrayList<>();
        BM_SyouhnZokusei syouhnZokusei1 = new BM_SyouhnZokusei();
        syouhnZokusei1.setSyouhncd("ｱ1");
        syouhnZokusei1.setSyouhnsdno(1);

        syouhnZokusei1.setNkhknumu(C_UmuKbn.ARI);

        syouhnZokusei1.setSyouhnnm("商品名００１");

        BM_SyouhnZokusei syouhnZokusei2 = new BM_SyouhnZokusei();
        syouhnZokusei2.setSyouhncd("ｱ2");
        syouhnZokusei2.setSyouhnsdno(1);

        syouhnZokusei2.setSyouhnnm("商品名００２");

        BM_SyouhnZokusei syouhnZokusei3 = new BM_SyouhnZokusei();
        syouhnZokusei3.setSyouhncd("ｱ3");
        syouhnZokusei3.setSyouhnsdno(1);
        syouhnZokusei3.setSyouhnnm("商品名００３");

        listTkSyouhnZokusei.add(syouhnZokusei1);
        listTkSyouhnZokusei.add(syouhnZokusei2);
        listTkSyouhnZokusei.add(syouhnZokusei3);

        mosnaiCheckParam.setListTkSyouhnZokusei(listTkSyouhnZokusei);

        BM_SyouhnZokusei syouhnZokusei = new BM_SyouhnZokusei();
        syouhnZokusei.setSyouhncd("ｱ3");
        syouhnZokusei.setSyouhnsdno(1);

        syouhnZokusei.setSyouhnnm("商品名０００");
        syouhnZokusei.setKyhkataumu(C_UmuKbn.NONE);
        syouhnZokusei.setNkhknumu(C_UmuKbn.ARI);
        syouhnZokusei.setYoteirirituhendoukbn(C_YoteirirituhendouKbn.NONE);
        mosnaiCheckParam.setSyuSyouhnZokusei(syouhnZokusei);

        checkTblMosSyouhin.exec(mosnaiCheckParam);

        exClassificationEquals(mosnaiCheckParam.getSekmossakuseiErroutKbn(), C_SekmossakuseiErroutKbn.GAMEN, "設計書申込書作成エラー出力区分");
        exStringEquals(mosnaiCheckParam.getSekmossakuseiErrmsg1(), "", "設計書申込書作成エラーメッセージ１");
        exStringEquals(mosnaiCheckParam.getSekmossakuseiErrmsg2(), "契約年齢範囲外です", "設計書申込書作成エラーメッセージ２");
        exClassificationEquals(mosnaiCheckParam.getKouzokuSyoriJikkouKbn(), C_KouzokujkKbn.NONE, "後続処理実行区分");

    }

    @Test
    @TestOrder(3380)
    @Transactional
    public void testExec_A53() {
        MockObjectManager.initialize();
        BzGetAgInfoMockForSinkeiyaku.SYORIPTN = BzGetAgInfoMockForSinkeiyaku.TESTPATTERN1;
        CheckSaiteiPMockForSinkeiyaku.SYORIPTN = CheckSaiteiPMockForSinkeiyaku.TESTPATTERN1;
        HanteiMoschkMockForSinkeiyaku.SYORIPTN = HanteiMoschkMockForSinkeiyaku.TESTPATTERN1;
        EditNenkinKoumokuUtilMockForSinkeiyaku.SYORIPTN = EditNenkinKoumokuUtilMockForSinkeiyaku.TESTPATTERN4;
        CheckTblMosSyouhin checkTblMosSyouhin = SWAKInjector.getInstance(CheckTblMosSyouhin.class);
        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("860000082");

        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setSysKbn(C_SysKbn.ESHIEN);
        mosnaiCheckParam.setKokutiChkHuyoUmu(C_UmuKbn.NONE);
        mosnaiCheckParam.setSysDate(BizDate.valueOf(20160102));
        mosnaiCheckParam.setSekmossakuseiSousasyaKbn(C_SeihowebsousasyaKbn.DIRTNBSYNN);
        mosnaiCheckParam.setListHubiMsg(new ArrayList<HT_HubiMsg>());
        mosnaiCheckParam.setKosID("JUnitTest");
        mosnaiCheckParam.setKosTime("20160509141230000");
        mosnaiCheckParam.setKiteiCheckChannelCd(C_Channelcd.MIZUHO);

        List<BM_SyouhnZokusei> listTkSyouhnZokusei = new ArrayList<>();
        BM_SyouhnZokusei syouhnZokusei1 = new BM_SyouhnZokusei();
        syouhnZokusei1.setSyouhncd("ｱ1");
        syouhnZokusei1.setSyouhnsdno(1);

        syouhnZokusei1.setNkhknumu(C_UmuKbn.ARI);

        syouhnZokusei1.setSyouhnnm("商品名００１");

        BM_SyouhnZokusei syouhnZokusei2 = new BM_SyouhnZokusei();
        syouhnZokusei2.setSyouhncd("ｱ2");
        syouhnZokusei2.setSyouhnsdno(1);

        syouhnZokusei2.setSyouhnnm("商品名００２");

        BM_SyouhnZokusei syouhnZokusei3 = new BM_SyouhnZokusei();
        syouhnZokusei3.setSyouhncd("ｱ3");
        syouhnZokusei3.setSyouhnsdno(1);
        syouhnZokusei3.setSyouhnnm("商品名００３");

        listTkSyouhnZokusei.add(syouhnZokusei1);
        listTkSyouhnZokusei.add(syouhnZokusei2);
        listTkSyouhnZokusei.add(syouhnZokusei3);

        mosnaiCheckParam.setListTkSyouhnZokusei(listTkSyouhnZokusei);

        BM_SyouhnZokusei syouhnZokusei = new BM_SyouhnZokusei();
        syouhnZokusei.setSyouhncd("ｱ3");
        syouhnZokusei.setSyouhnsdno(1);

        syouhnZokusei.setSyouhnnm("商品名０００");
        syouhnZokusei.setKyhkataumu(C_UmuKbn.NONE);
        syouhnZokusei.setNkhknumu(C_UmuKbn.ARI);
        syouhnZokusei.setYoteirirituhendoukbn(C_YoteirirituhendouKbn.NONE);
        mosnaiCheckParam.setSyuSyouhnZokusei(syouhnZokusei);

        checkTblMosSyouhin.exec(mosnaiCheckParam);

        exClassificationEquals(mosnaiCheckParam.getSekmossakuseiErroutKbn(), C_SekmossakuseiErroutKbn.GAMEN, "設計書申込書作成エラー出力区分");
        exStringEquals(mosnaiCheckParam.getSekmossakuseiErrmsg1(), "", "設計書申込書作成エラーメッセージ１");
        exStringEquals(mosnaiCheckParam.getSekmossakuseiErrmsg2(), "募集年齢範囲外です　当予定利率期間の募集年齢範囲は１歳から１０歳です", "設計書申込書作成エラーメッセージ２");
        exClassificationEquals(mosnaiCheckParam.getKouzokuSyoriJikkouKbn(), C_KouzokujkKbn.NONE, "後続処理実行区分");

    }

    @Test
    @TestOrder(3390)
    @Transactional
    public void testExec_A54() {
        MockObjectManager.initialize();
        BzGetAgInfoMockForSinkeiyaku.SYORIPTN = BzGetAgInfoMockForSinkeiyaku.TESTPATTERN1;
        CheckSaiteiPMockForSinkeiyaku.SYORIPTN = CheckSaiteiPMockForSinkeiyaku.TESTPATTERN1;
        HanteiMoschkMockForSinkeiyaku.SYORIPTN = HanteiMoschkMockForSinkeiyaku.TESTPATTERN1;
        EditNenkinKoumokuUtilMockForSinkeiyaku.SYORIPTN = EditNenkinKoumokuUtilMockForSinkeiyaku.TESTPATTERN4;
        CheckTblMosSyouhin checkTblMosSyouhin = SWAKInjector.getInstance(CheckTblMosSyouhin.class);
        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("860000033");

        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setSysKbn(C_SysKbn.ESHIEN);
        mosnaiCheckParam.setKokutiChkHuyoUmu(C_UmuKbn.NONE);
        mosnaiCheckParam.setSysDate(BizDate.valueOf(20160102));
        mosnaiCheckParam.setSekmossakuseiSousasyaKbn(C_SeihowebsousasyaKbn.DIRTNBSYNN);
        mosnaiCheckParam.setListHubiMsg(new ArrayList<HT_HubiMsg>());
        mosnaiCheckParam.setKosID("JUnitTest");
        mosnaiCheckParam.setKosTime("20160509141230000");
        mosnaiCheckParam.setKiteiCheckChannelCd(C_Channelcd.MIZUHO);

        List<BM_SyouhnZokusei> listTkSyouhnZokusei = new ArrayList<>();
        BM_SyouhnZokusei syouhnZokusei1 = new BM_SyouhnZokusei();
        syouhnZokusei1.setSyouhncd("ｱ1");
        syouhnZokusei1.setSyouhnsdno(1);

        syouhnZokusei1.setNkhknumu(C_UmuKbn.ARI);

        syouhnZokusei1.setSyouhnnm("商品名００１");

        BM_SyouhnZokusei syouhnZokusei2 = new BM_SyouhnZokusei();
        syouhnZokusei2.setSyouhncd("ｱ2");
        syouhnZokusei2.setSyouhnsdno(1);

        syouhnZokusei2.setSyouhnnm("商品名００２");

        BM_SyouhnZokusei syouhnZokusei3 = new BM_SyouhnZokusei();
        syouhnZokusei3.setSyouhncd("ｱ3");
        syouhnZokusei3.setSyouhnsdno(1);
        syouhnZokusei3.setSyouhnnm("商品名００３");

        listTkSyouhnZokusei.add(syouhnZokusei1);
        listTkSyouhnZokusei.add(syouhnZokusei2);
        listTkSyouhnZokusei.add(syouhnZokusei3);

        mosnaiCheckParam.setListTkSyouhnZokusei(listTkSyouhnZokusei);

        BM_SyouhnZokusei syouhnZokusei = new BM_SyouhnZokusei();
        syouhnZokusei.setSyouhncd("ｱ3");
        syouhnZokusei.setSyouhnsdno(1);

        syouhnZokusei.setSyouhnnm("商品名０００");
        syouhnZokusei.setKyhkataumu(C_UmuKbn.NONE);
        syouhnZokusei.setNkhknumu(C_UmuKbn.ARI);
        syouhnZokusei.setYoteirirituhendoukbn(C_YoteirirituhendouKbn.NONE);
        mosnaiCheckParam.setSyuSyouhnZokusei(syouhnZokusei);

        checkTblMosSyouhin.exec(mosnaiCheckParam);

        exClassificationEquals(mosnaiCheckParam.getSekmossakuseiErroutKbn(), C_SekmossakuseiErroutKbn.GAMEN, "設計書申込書作成エラー出力区分");
        exStringEquals(mosnaiCheckParam.getSekmossakuseiErrmsg1(), "", "設計書申込書作成エラーメッセージ１");
        exStringEquals(mosnaiCheckParam.getSekmossakuseiErrmsg2(), "募集年齢範囲外です　当予定利率期間の募集年齢範囲は１歳から６０歳です", "設計書申込書作成エラーメッセージ２");
        exClassificationEquals(mosnaiCheckParam.getKouzokuSyoriJikkouKbn(), C_KouzokujkKbn.NONE, "後続処理実行区分");

    }

    @Test
    @TestOrder(3400)
    @Transactional
    public void testExec_A55() {
        MockObjectManager.initialize();
        BzGetAgInfoMockForSinkeiyaku.SYORIPTN = BzGetAgInfoMockForSinkeiyaku.TESTPATTERN1;
        CheckSaiteiPMockForSinkeiyaku.SYORIPTN = CheckSaiteiPMockForSinkeiyaku.TESTPATTERN1;
        HanteiMoschkMockForSinkeiyaku.SYORIPTN = HanteiMoschkMockForSinkeiyaku.TESTPATTERN1;
        EditNenkinKoumokuUtilMockForSinkeiyaku.SYORIPTN = EditNenkinKoumokuUtilMockForSinkeiyaku.TESTPATTERN4;
        CheckTblMosSyouhin checkTblMosSyouhin = SWAKInjector.getInstance(CheckTblMosSyouhin.class);
        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("860000041");

        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setSysKbn(C_SysKbn.ESHIEN);
        mosnaiCheckParam.setKokutiChkHuyoUmu(C_UmuKbn.NONE);
        mosnaiCheckParam.setSysDate(BizDate.valueOf(20160102));
        mosnaiCheckParam.setSekmossakuseiSousasyaKbn(C_SeihowebsousasyaKbn.DIRTNBSYNN);
        mosnaiCheckParam.setListHubiMsg(new ArrayList<HT_HubiMsg>());
        mosnaiCheckParam.setKosID("JUnitTest");
        mosnaiCheckParam.setKosTime("20160509141230000");
        mosnaiCheckParam.setKiteiCheckChannelCd(C_Channelcd.MIZUHO);

        List<BM_SyouhnZokusei> listTkSyouhnZokusei = new ArrayList<>();
        BM_SyouhnZokusei syouhnZokusei1 = new BM_SyouhnZokusei();
        syouhnZokusei1.setSyouhncd("ｱ1");
        syouhnZokusei1.setSyouhnsdno(1);

        syouhnZokusei1.setNkhknumu(C_UmuKbn.ARI);

        syouhnZokusei1.setSyouhnnm("商品名００１");

        BM_SyouhnZokusei syouhnZokusei2 = new BM_SyouhnZokusei();
        syouhnZokusei2.setSyouhncd("ｱ2");
        syouhnZokusei2.setSyouhnsdno(1);

        syouhnZokusei2.setSyouhnnm("商品名００２");

        BM_SyouhnZokusei syouhnZokusei3 = new BM_SyouhnZokusei();
        syouhnZokusei3.setSyouhncd("ｱ3");
        syouhnZokusei3.setSyouhnsdno(1);
        syouhnZokusei3.setSyouhnnm("商品名００３");

        listTkSyouhnZokusei.add(syouhnZokusei1);
        listTkSyouhnZokusei.add(syouhnZokusei2);
        listTkSyouhnZokusei.add(syouhnZokusei3);

        mosnaiCheckParam.setListTkSyouhnZokusei(listTkSyouhnZokusei);

        BM_SyouhnZokusei syouhnZokusei = new BM_SyouhnZokusei();
        syouhnZokusei.setSyouhncd("ｱ3");
        syouhnZokusei.setSyouhnsdno(1);

        syouhnZokusei.setSyouhnnm("商品名０００");
        syouhnZokusei.setKyhkataumu(C_UmuKbn.NONE);
        syouhnZokusei.setNkhknumu(C_UmuKbn.ARI);
        syouhnZokusei.setYoteirirituhendoukbn(C_YoteirirituhendouKbn.NONE);
        mosnaiCheckParam.setSyuSyouhnZokusei(syouhnZokusei);

        checkTblMosSyouhin.exec(mosnaiCheckParam);

        exClassificationEquals(mosnaiCheckParam.getSekmossakuseiErroutKbn(), C_SekmossakuseiErroutKbn.GAMEN, "設計書申込書作成エラー出力区分");
        exStringEquals(mosnaiCheckParam.getSekmossakuseiErrmsg1(), "初期死亡時円換算支払額最低保証特約は募集年齢範囲外です　　当予定利率期間の募集年", "設計書申込書作成エラーメッセージ１");
        exStringEquals(mosnaiCheckParam.getSekmossakuseiErrmsg2(), "齢範囲は２０歳から８０歳です", "設計書申込書作成エラーメッセージ２");
        exClassificationEquals(mosnaiCheckParam.getKouzokuSyoriJikkouKbn(), C_KouzokujkKbn.NONE, "後続処理実行区分");

    }

    @Test
    @TestOrder(3410)
    @Transactional
    public void testExec_A56() {
        MockObjectManager.initialize();
        BzGetAgInfoMockForSinkeiyaku.SYORIPTN = BzGetAgInfoMockForSinkeiyaku.TESTPATTERN1;
        CheckSaiteiPMockForSinkeiyaku.SYORIPTN = CheckSaiteiPMockForSinkeiyaku.TESTPATTERN1;
        HanteiMoschkMockForSinkeiyaku.SYORIPTN = HanteiMoschkMockForSinkeiyaku.TESTPATTERN1;
        EditNenkinKoumokuUtilMockForSinkeiyaku.SYORIPTN = EditNenkinKoumokuUtilMockForSinkeiyaku.TESTPATTERN4;
        CheckTblMosSyouhin checkTblMosSyouhin = SWAKInjector.getInstance(CheckTblMosSyouhin.class);
        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("860000058");

        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setSysKbn(C_SysKbn.ESHIEN);
        mosnaiCheckParam.setKokutiChkHuyoUmu(C_UmuKbn.NONE);
        mosnaiCheckParam.setSysDate(BizDate.valueOf(20160102));
        mosnaiCheckParam.setSekmossakuseiSousasyaKbn(C_SeihowebsousasyaKbn.DIRTNBSYNN);
        mosnaiCheckParam.setListHubiMsg(new ArrayList<HT_HubiMsg>());
        mosnaiCheckParam.setKosID("JUnitTest");
        mosnaiCheckParam.setKosTime("20160509141230000");
        mosnaiCheckParam.setKiteiCheckChannelCd(C_Channelcd.MIZUHO);

        List<BM_SyouhnZokusei> listTkSyouhnZokusei = new ArrayList<>();
        BM_SyouhnZokusei syouhnZokusei1 = new BM_SyouhnZokusei();
        syouhnZokusei1.setSyouhncd("ｱ1");
        syouhnZokusei1.setSyouhnsdno(1);

        syouhnZokusei1.setNkhknumu(C_UmuKbn.ARI);

        syouhnZokusei1.setSyouhnnm("商品名００１");

        BM_SyouhnZokusei syouhnZokusei2 = new BM_SyouhnZokusei();
        syouhnZokusei2.setSyouhncd("ｱ2");
        syouhnZokusei2.setSyouhnsdno(1);

        syouhnZokusei2.setSyouhnnm("商品名００２");

        BM_SyouhnZokusei syouhnZokusei3 = new BM_SyouhnZokusei();
        syouhnZokusei3.setSyouhncd("ｱ3");
        syouhnZokusei3.setSyouhnsdno(1);
        syouhnZokusei3.setSyouhnnm("商品名００３");

        listTkSyouhnZokusei.add(syouhnZokusei1);
        listTkSyouhnZokusei.add(syouhnZokusei2);
        listTkSyouhnZokusei.add(syouhnZokusei3);

        mosnaiCheckParam.setListTkSyouhnZokusei(listTkSyouhnZokusei);

        BM_SyouhnZokusei syouhnZokusei = new BM_SyouhnZokusei();
        syouhnZokusei.setSyouhncd("ｱ3");
        syouhnZokusei.setSyouhnsdno(1);

        syouhnZokusei.setSyouhnnm("商品名０００");
        syouhnZokusei.setKyhkataumu(C_UmuKbn.NONE);
        syouhnZokusei.setNkhknumu(C_UmuKbn.ARI);
        syouhnZokusei.setYoteirirituhendoukbn(C_YoteirirituhendouKbn.NONE);
        mosnaiCheckParam.setSyuSyouhnZokusei(syouhnZokusei);

        checkTblMosSyouhin.exec(mosnaiCheckParam);

        exClassificationEquals(mosnaiCheckParam.getSekmossakuseiErroutKbn(), C_SekmossakuseiErroutKbn.GAMEN, "設計書申込書作成エラー出力区分");
        exStringEquals(mosnaiCheckParam.getSekmossakuseiErrmsg1(), "初期死亡時円換算支払額最低保証特約は募集年齢範囲外です　　当予定利率期間の募集年", "設計書申込書作成エラーメッセージ１");
        exStringEquals(mosnaiCheckParam.getSekmossakuseiErrmsg2(), "齢範囲は２０歳から８０歳です", "設計書申込書作成エラーメッセージ２");
        exClassificationEquals(mosnaiCheckParam.getKouzokuSyoriJikkouKbn(), C_KouzokujkKbn.NONE, "後続処理実行区分");

    }

    @Test
    @TestOrder(3420)
    @Transactional
    public void testExec_A57() {
        MockObjectManager.initialize();
        BzGetAgInfoMockForSinkeiyaku.SYORIPTN = BzGetAgInfoMockForSinkeiyaku.TESTPATTERN1;
        CheckSaiteiPMockForSinkeiyaku.SYORIPTN = CheckSaiteiPMockForSinkeiyaku.TESTPATTERN1;
        HanteiMoschkMockForSinkeiyaku.SYORIPTN = HanteiMoschkMockForSinkeiyaku.TESTPATTERN1;
        EditNenkinKoumokuUtilMockForSinkeiyaku.SYORIPTN = EditNenkinKoumokuUtilMockForSinkeiyaku.TESTPATTERN4;
        CheckTblMosSyouhin checkTblMosSyouhin = SWAKInjector.getInstance(CheckTblMosSyouhin.class);
        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("860000066");

        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setSysKbn(C_SysKbn.ESHIEN);
        mosnaiCheckParam.setKokutiChkHuyoUmu(C_UmuKbn.NONE);
        mosnaiCheckParam.setSysDate(BizDate.valueOf(20160102));
        mosnaiCheckParam.setSekmossakuseiSousasyaKbn(C_SeihowebsousasyaKbn.DIRTNBSYNN);
        mosnaiCheckParam.setListHubiMsg(new ArrayList<HT_HubiMsg>());
        mosnaiCheckParam.setKosID("JUnitTest");
        mosnaiCheckParam.setKosTime("20160509141230000");
        mosnaiCheckParam.setKiteiCheckChannelCd(C_Channelcd.MIZUHO);

        List<BM_SyouhnZokusei> listTkSyouhnZokusei = new ArrayList<>();
        BM_SyouhnZokusei syouhnZokusei1 = new BM_SyouhnZokusei();
        syouhnZokusei1.setSyouhncd("ｱ1");
        syouhnZokusei1.setSyouhnsdno(1);

        syouhnZokusei1.setNkhknumu(C_UmuKbn.ARI);

        syouhnZokusei1.setSyouhnnm("商品名００１");

        BM_SyouhnZokusei syouhnZokusei2 = new BM_SyouhnZokusei();
        syouhnZokusei2.setSyouhncd("ｱ2");
        syouhnZokusei2.setSyouhnsdno(1);

        syouhnZokusei2.setSyouhnnm("商品名００２");

        BM_SyouhnZokusei syouhnZokusei3 = new BM_SyouhnZokusei();
        syouhnZokusei3.setSyouhncd("ｱ3");
        syouhnZokusei3.setSyouhnsdno(1);
        syouhnZokusei3.setSyouhnnm("商品名００３");

        listTkSyouhnZokusei.add(syouhnZokusei1);
        listTkSyouhnZokusei.add(syouhnZokusei2);
        listTkSyouhnZokusei.add(syouhnZokusei3);

        mosnaiCheckParam.setListTkSyouhnZokusei(listTkSyouhnZokusei);

        BM_SyouhnZokusei syouhnZokusei = new BM_SyouhnZokusei();
        syouhnZokusei.setSyouhncd("ｱ3");
        syouhnZokusei.setSyouhnsdno(1);

        syouhnZokusei.setSyouhnnm("商品名０００");
        syouhnZokusei.setKyhkataumu(C_UmuKbn.NONE);
        syouhnZokusei.setNkhknumu(C_UmuKbn.ARI);
        syouhnZokusei.setYoteirirituhendoukbn(C_YoteirirituhendouKbn.NONE);
        mosnaiCheckParam.setSyuSyouhnZokusei(syouhnZokusei);

        checkTblMosSyouhin.exec(mosnaiCheckParam);

        exClassificationEquals(mosnaiCheckParam.getSekmossakuseiErroutKbn(), C_SekmossakuseiErroutKbn.GAMEN, "設計書申込書作成エラー出力区分");
        exStringEquals(mosnaiCheckParam.getSekmossakuseiErrmsg1(), "", "設計書申込書作成エラーメッセージ１");
        exStringEquals(mosnaiCheckParam.getSekmossakuseiErrmsg2(), "募集年齢範囲外です　当予定利率期間の募集年齢範囲は２０歳から２０歳です", "設計書申込書作成エラーメッセージ２");
        exClassificationEquals(mosnaiCheckParam.getKouzokuSyoriJikkouKbn(), C_KouzokujkKbn.NONE, "後続処理実行区分");

    }

    @Test
    @TestOrder(3430)
    @Transactional
    public void testExec_A58() {
        MockObjectManager.initialize();
        BzGetAgInfoMockForSinkeiyaku.SYORIPTN = BzGetAgInfoMockForSinkeiyaku.TESTPATTERN1;
        CheckSaiteiPMockForSinkeiyaku.SYORIPTN = CheckSaiteiPMockForSinkeiyaku.TESTPATTERN1;
        HanteiMoschkMockForSinkeiyaku.SYORIPTN = HanteiMoschkMockForSinkeiyaku.TESTPATTERN1;
        EditNenkinKoumokuUtilMockForSinkeiyaku.SYORIPTN = EditNenkinKoumokuUtilMockForSinkeiyaku.TESTPATTERN4;
        CheckTblMosSyouhin checkTblMosSyouhin = SWAKInjector.getInstance(CheckTblMosSyouhin.class);
        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("860000074");

        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setSysKbn(C_SysKbn.ESHIEN);
        mosnaiCheckParam.setKokutiChkHuyoUmu(C_UmuKbn.NONE);
        mosnaiCheckParam.setSysDate(BizDate.valueOf(20160102));
        mosnaiCheckParam.setSekmossakuseiSousasyaKbn(C_SeihowebsousasyaKbn.DIRTNBSYNN);
        mosnaiCheckParam.setListHubiMsg(new ArrayList<HT_HubiMsg>());
        mosnaiCheckParam.setKosID("JUnitTest");
        mosnaiCheckParam.setKosTime("20160509141230000");
        mosnaiCheckParam.setKiteiCheckChannelCd(C_Channelcd.MIZUHO);

        List<BM_SyouhnZokusei> listTkSyouhnZokusei = new ArrayList<>();
        BM_SyouhnZokusei syouhnZokusei1 = new BM_SyouhnZokusei();
        syouhnZokusei1.setSyouhncd("ｱ1");
        syouhnZokusei1.setSyouhnsdno(1);

        syouhnZokusei1.setNkhknumu(C_UmuKbn.ARI);

        syouhnZokusei1.setSyouhnnm("商品名００１");

        BM_SyouhnZokusei syouhnZokusei2 = new BM_SyouhnZokusei();
        syouhnZokusei2.setSyouhncd("ｱ2");
        syouhnZokusei2.setSyouhnsdno(1);

        syouhnZokusei2.setSyouhnnm("商品名００２");

        BM_SyouhnZokusei syouhnZokusei3 = new BM_SyouhnZokusei();
        syouhnZokusei3.setSyouhncd("ｱ3");
        syouhnZokusei3.setSyouhnsdno(1);
        syouhnZokusei3.setSyouhnnm("商品名００３");

        listTkSyouhnZokusei.add(syouhnZokusei1);
        listTkSyouhnZokusei.add(syouhnZokusei2);
        listTkSyouhnZokusei.add(syouhnZokusei3);

        mosnaiCheckParam.setListTkSyouhnZokusei(listTkSyouhnZokusei);

        BM_SyouhnZokusei syouhnZokusei = new BM_SyouhnZokusei();
        syouhnZokusei.setSyouhncd("ｱ3");
        syouhnZokusei.setSyouhnsdno(1);

        syouhnZokusei.setSyouhnnm("商品名０００");
        syouhnZokusei.setKyhkataumu(C_UmuKbn.NONE);
        syouhnZokusei.setNkhknumu(C_UmuKbn.ARI);
        syouhnZokusei.setYoteirirituhendoukbn(C_YoteirirituhendouKbn.TUKI1KAI);
        mosnaiCheckParam.setSyuSyouhnZokusei(syouhnZokusei);

        checkTblMosSyouhin.exec(mosnaiCheckParam);

        exClassificationEquals(mosnaiCheckParam.getSekmossakuseiErroutKbn(), C_SekmossakuseiErroutKbn.GAMEN, "設計書申込書作成エラー出力区分");
        exStringEquals(mosnaiCheckParam.getSekmossakuseiErrmsg1(), "", "設計書申込書作成エラーメッセージ１");
        exStringEquals(mosnaiCheckParam.getSekmossakuseiErrmsg2(), "募集年齢範囲外です", "設計書申込書作成エラーメッセージ２");
        exClassificationEquals(mosnaiCheckParam.getKouzokuSyoriJikkouKbn(), C_KouzokujkKbn.NONE, "後続処理実行区分");

    }



    @Test(expected = CommonBizAppException.class)
    @TestOrder(3200)
    @Transactional
    public void testExec_A59() {
        MockObjectManager.initialize();
        BzGetAgInfoMockForSinkeiyaku.SYORIPTN = BzGetAgInfoMockForSinkeiyaku.TESTPATTERN2;
        CheckSaiteiPMockForSinkeiyaku.SYORIPTN = CheckSaiteiPMockForSinkeiyaku.TESTPATTERN1;
        CheckTblMosSyouhin checkTblMosSyouhin = SWAKInjector.getInstance(CheckTblMosSyouhin.class);

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("860001916");
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

        try {

            checkTblMosSyouhin.exec(mosnaiCheckParam);
        } catch (CommonBizAppException e) {

            List<HT_HubiMsg> hubiMsgLst = mosnaiCheckParam.getListHubiMsg();

            exNumericEquals(hubiMsgLst.size(), 2, "不備メッセージテーブルエンティティリストのサイズ");

            exStringEquals(hubiMsgLst.get(0).getMosno(), "860001916", "申込番号");
            exNumericEquals(hubiMsgLst.get(0).getRenno(), 1, "連番");
            exStringEquals(hubiMsgLst.get(0).getMessageId(), "EHC0019", "メッセージＩＤ");
            exStringEquals(hubiMsgLst.get(0).getHubimsg(), "外貨建て一時払終身保険（毎年受取型）　１５年毎利率再設定の本人・子型は取扱えません。", "不備メッセージ");
            exClassificationEquals(hubiMsgLst.get(0).getHubisyubetukbn(), C_HubisyubetuKbn.KETHORYU_HUBI, "不備種別区分");
            exClassificationEquals(hubiMsgLst.get(0).getHubisyubetusyousaikbn(), C_HubisyubetusyousaiKbn.NONE,
                "不備種別詳細区分");
            exStringEquals(hubiMsgLst.get(0).getGyoumuKousinsyaId(), "JUnitTest", "業務用更新者ＩＤ");
            exStringEquals(hubiMsgLst.get(0).getGyoumuKousinTime(), "20160509141230000", "業務用更新時間");

            exStringEquals(hubiMsgLst.get(1).getMosno(), "860001916", "申込番号");
            exNumericEquals(hubiMsgLst.get(1).getRenno(), 2, "連番");
            exStringEquals(hubiMsgLst.get(1).getMessageId(), "EHC0019", "メッセージＩＤ");
            exStringEquals(hubiMsgLst.get(1).getHubimsg(), "外貨建て一時払終身保険（毎年受取型）　１５年毎利率再設定の本人・子型は取扱えません。", "不備メッセージ");
            exClassificationEquals(hubiMsgLst.get(1).getHubisyubetukbn(), C_HubisyubetuKbn.KETHORYU_HUBI, "不備種別区分");
            exClassificationEquals(hubiMsgLst.get(1).getHubisyubetusyousaikbn(), C_HubisyubetusyousaiKbn.NONE,
                "不備種別詳細区分");
            exStringEquals(hubiMsgLst.get(1).getGyoumuKousinsyaId(), "JUnitTest", "業務用更新者ＩＤ");
            exStringEquals(hubiMsgLst.get(1).getGyoumuKousinTime(), "20160509141230000", "業務用更新時間");

            exStringEquals(e.getMessage(), "システム整合性エラーです。最低Ｐテーブルにデータが見つかりません。", "エラーメッセージ");
            throw e;
        }
    }

    @Test(expected = CommonBizAppException.class)
    @TestOrder(3210)
    @Transactional
    public void testExec_A60() {
        MockObjectManager.initialize();
        BzGetAgInfoMockForSinkeiyaku.SYORIPTN = BzGetAgInfoMockForSinkeiyaku.TESTPATTERN2;
        CheckSaiteiPMockForSinkeiyaku.SYORIPTN = CheckSaiteiPMockForSinkeiyaku.TESTPATTERN1;
        CheckTblMosSyouhin checkTblMosSyouhin = SWAKInjector.getInstance(CheckTblMosSyouhin.class);

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("860001924");
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

        try {
            checkTblMosSyouhin.exec(mosnaiCheckParam);
        } catch (CommonBizAppException e) {

            List<HT_HubiMsg> hubiMsgLst = mosnaiCheckParam.getListHubiMsg();

            exNumericEquals(hubiMsgLst.size(), 2, "不備メッセージテーブルエンティティリストのサイズ");

            exStringEquals(hubiMsgLst.get(0).getMosno(), "860001924", "申込番号");
            exNumericEquals(hubiMsgLst.get(0).getRenno(), 1, "連番");
            exStringEquals(hubiMsgLst.get(0).getMessageId(), "EHC0028", "メッセージＩＤ");
            exStringEquals(hubiMsgLst.get(0).getHubimsg(), "外貨建て一時払終身保険（毎年受取型）　１５年毎利率再設定の契約可能期間・年齢範囲外です。", "不備メッセージ");
            exClassificationEquals(hubiMsgLst.get(0).getHubisyubetukbn(), C_HubisyubetuKbn.KETHORYU_HUBI, "不備種別区分");
            exClassificationEquals(hubiMsgLst.get(0).getHubisyubetusyousaikbn(), C_HubisyubetusyousaiKbn.NONE,
                "不備種別詳細区分");

            exStringEquals(hubiMsgLst.get(1).getMosno(), "860001924", "申込番号");
            exNumericEquals(hubiMsgLst.get(1).getRenno(), 2, "連番");
            exStringEquals(hubiMsgLst.get(1).getMessageId(), "EHC0019", "メッセージＩＤ");
            exStringEquals(hubiMsgLst.get(1).getHubimsg(), "外貨建て一時払終身保険（毎年受取型）　１５年毎利率再設定の本人型は取扱えません。", "不備メッセージ");
            exClassificationEquals(hubiMsgLst.get(1).getHubisyubetukbn(), C_HubisyubetuKbn.KETHORYU_HUBI, "不備種別区分");
            exClassificationEquals(hubiMsgLst.get(1).getHubisyubetusyousaikbn(), C_HubisyubetusyousaiKbn.NONE,
                "不備種別詳細区分");

            exStringEquals(e.getMessage(), "システム整合性エラーです。最低Ｐテーブルにデータが見つかりません。", "エラーメッセージ");
            throw e;
        }
    }

    @Test(expected = CommonBizAppException.class)
    @TestOrder(3220)
    @Transactional
    public void testExec_A61() {
        MockObjectManager.initialize();
        CheckSaiteiPMockForSinkeiyaku.SYORIPTN = CheckSaiteiPMockForSinkeiyaku.TESTPATTERN1;
        ConvNenSaiMankiMockForSinkeiyaku.SYORIPTN = ConvNenSaiMankiMockForSinkeiyaku.TESTPATTERN2;
        CheckTblMosSyouhin checkTblMosSyouhin = SWAKInjector.getInstance(CheckTblMosSyouhin.class);

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("860001932");
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
        mosnaiCheckParam.setKiteiCheckChannelCd(C_Channelcd.SINKIN);

        try {
            checkTblMosSyouhin.exec(mosnaiCheckParam);
        } catch (CommonBizAppException e) {

            exClassificationEquals(mosnaiCheckParam.getSekmossakuseiErroutKbn(), C_SekmossakuseiErroutKbn.GAMEN, "設計書申込書作成エラー出力区分");
            exStringEquals(mosnaiCheckParam.getSekmossakuseiErrmsg1(), "外貨建て一時払終身保険（毎年受取型）　１５年毎利率再設定の本人・妻型は取扱えませ", "設計書申込書作成エラーメッセージ１");
            exStringEquals(mosnaiCheckParam.getSekmossakuseiErrmsg2(), "ん。", "設計書申込書作成エラーメッセージ２");
            exClassificationEquals(mosnaiCheckParam.getKouzokuSyoriJikkouKbn(), C_KouzokujkKbn.NONE, "後続処理実行区分");

            exStringEquals(e.getMessage(), "システム整合性エラーです。最低Ｐテーブルにデータが見つかりません。", "エラーメッセージ");
            throw e;
        }
    }

    @Test(expected = CommonBizAppException.class)
    @TestOrder(3230)
    @Transactional
    public void testExec_A62() {
        MockObjectManager.initialize();
        CheckSaiteiPMockForSinkeiyaku.SYORIPTN = CheckSaiteiPMockForSinkeiyaku.TESTPATTERN1;
        ConvNenSaiMankiMockForSinkeiyaku.SYORIPTN = ConvNenSaiMankiMockForSinkeiyaku.TESTPATTERN3;
        CheckTblMosSyouhin checkTblMosSyouhin = SWAKInjector.getInstance(CheckTblMosSyouhin.class);

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("860001940");
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
            exStringEquals(mosnaiCheckParam.getSekmossakuseiErrmsg1(), "外貨建て一時払終身保険（毎年受取型）　１５年毎利率再設定の本人・子型は取扱えませ", "設計書申込書作成エラーメッセージ１");
            exStringEquals(mosnaiCheckParam.getSekmossakuseiErrmsg2(), "ん。", "設計書申込書作成エラーメッセージ２");
            exClassificationEquals(mosnaiCheckParam.getKouzokuSyoriJikkouKbn(), C_KouzokujkKbn.NONE, "後続処理実行区分");

            exStringEquals(e.getMessage(), "システム整合性エラーです。最低Ｐテーブルにデータが見つかりません。", "エラーメッセージ");
            throw e;
        }
    }

    @Test(expected = CommonBizAppException.class)
    @TestOrder(3240)
    @Transactional
    public void testExec_A63() {
        MockObjectManager.initialize();
        CheckSaiteiPMockForSinkeiyaku.SYORIPTN = CheckSaiteiPMockForSinkeiyaku.TESTPATTERN1;
        ConvNenSaiMankiMockForSinkeiyaku.SYORIPTN = ConvNenSaiMankiMockForSinkeiyaku.TESTPATTERN1;
        CheckTblMosSyouhin checkTblMosSyouhin = SWAKInjector.getInstance(CheckTblMosSyouhin.class);

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("880001003");
        List<HT_MosSyouhn> syuMosSyouhnParamLst = syoriCTL.getMosSyouhnsBySyutkkbn(C_SyutkKbn.TK);
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
        mosnaiCheckParam.setKiteiCheckChannelCd(C_Channelcd.SMBC);

        try{
            checkTblMosSyouhin.exec(mosnaiCheckParam);
        } catch (CommonBizAppException e) {

            List<HT_HubiMsg> hubiMsgLst = mosnaiCheckParam.getListHubiMsg();

            exNumericEquals(hubiMsgLst.size(), 2, "不備メッセージテーブルエンティティリストのサイズ");

            exStringEquals(hubiMsgLst.get(0).getMosno(), "880001003", "申込番号");
            exNumericEquals(hubiMsgLst.get(0).getRenno(), 1, "連番");
            exStringEquals(hubiMsgLst.get(0).getMessageId(), "THC0091", "メッセージＩＤ");
            exStringEquals(hubiMsgLst.get(0).getHubimsg(), "【特認可能】特約ありのため被保険者年齢７０歳超は取扱えません。", "不備メッセージ");
            exClassificationEquals(hubiMsgLst.get(0).getHubisyubetukbn(), C_HubisyubetuKbn.KETHORYU_HUBI, "不備種別区分");
            exStringEquals(hubiMsgLst.get(0).getGyoumuKousinsyaId(), "JUnitTest", "業務用更新者ＩＤ");
            exStringEquals(hubiMsgLst.get(0).getGyoumuKousinTime(), "20160509141230000", "業務用更新時間");

            exStringEquals(hubiMsgLst.get(1).getMosno(), "880001003", "申込番号");
            exNumericEquals(hubiMsgLst.get(1).getRenno(), 2, "連番");
            exStringEquals(hubiMsgLst.get(1).getMessageId(), "EHC0019", "メッセージＩＤ");
            exStringEquals(hubiMsgLst.get(1).getHubimsg(), "外貨建て一時払終身保険（毎年受取型）　１５年毎利率再設定の本人型は取扱えません。", "不備メッセージ");
            exClassificationEquals(hubiMsgLst.get(1).getHubisyubetukbn(), C_HubisyubetuKbn.KETHORYU_HUBI, "不備種別区分");
            exStringEquals(hubiMsgLst.get(1).getGyoumuKousinsyaId(), "JUnitTest", "業務用更新者ＩＤ");
            exStringEquals(hubiMsgLst.get(1).getGyoumuKousinTime(), "20160509141230000", "業務用更新時間");

            exStringEquals(e.getMessage(), "システム整合性エラーです。最低Ｐテーブルにデータが見つかりません。", "エラーメッセージ");
            throw e;
        }
    }

    @Test(expected = CommonBizAppException.class)
    @TestOrder(3250)
    @Transactional
    public void testExec_A64() {
        MockObjectManager.initialize();
        CheckSaiteiPMockForSinkeiyaku.SYORIPTN = CheckSaiteiPMockForSinkeiyaku.TESTPATTERN1;
        ConvNenSaiMankiMockForSinkeiyaku.SYORIPTN = ConvNenSaiMankiMockForSinkeiyaku.TESTPATTERN1;
        CheckTblMosSyouhin checkTblMosSyouhin = SWAKInjector.getInstance(CheckTblMosSyouhin.class);

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("880000997");
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
        mosnaiCheckParam.setKiteiCheckChannelCd(C_Channelcd.MIZUHO);

        try{
            checkTblMosSyouhin.exec(mosnaiCheckParam);
        } catch (CommonBizAppException e) {

            List<HT_HubiMsg> hubiMsgLst = mosnaiCheckParam.getListHubiMsg();

            exNumericEquals(hubiMsgLst.size(), 3, "不備メッセージテーブルエンティティリストのサイズ");

            exStringEquals(hubiMsgLst.get(0).getMosno(), "880000997", "申込番号");
            exNumericEquals(hubiMsgLst.get(0).getRenno(), 1, "連番");
            exStringEquals(hubiMsgLst.get(0).getMessageId(), "THC0028", "メッセージＩＤ");
            exStringEquals(hubiMsgLst.get(0).getHubimsg(), "【特認可能】外貨建て一時払終身保険（毎年受取型）　１５年毎利率再設定の契約可能期間・年齢範囲外です。", "不備メッセージ");
            exClassificationEquals(hubiMsgLst.get(0).getHubisyubetukbn(), C_HubisyubetuKbn.KETHORYU_HUBI, "不備種別区分");
            exStringEquals(hubiMsgLst.get(0).getGyoumuKousinsyaId(), "JUnitTest", "業務用更新者ＩＤ");
            exStringEquals(hubiMsgLst.get(0).getGyoumuKousinTime(), "20160509141230000", "業務用更新時間");

            exStringEquals(hubiMsgLst.get(1).getMosno(), "880000997", "申込番号");
            exNumericEquals(hubiMsgLst.get(1).getRenno(), 2, "連番");
            exStringEquals(hubiMsgLst.get(1).getMessageId(), "THC0019", "メッセージＩＤ");
            exStringEquals(hubiMsgLst.get(1).getHubimsg(), "【特認可能】外貨建て一時払終身保険（毎年受取型）　１５年毎利率再設定の集団は取扱えません。", "不備メッセージ");
            exClassificationEquals(hubiMsgLst.get(1).getHubisyubetukbn(), C_HubisyubetuKbn.KETHORYU_HUBI, "不備種別区分");
            exStringEquals(hubiMsgLst.get(1).getGyoumuKousinsyaId(), "JUnitTest", "業務用更新者ＩＤ");
            exStringEquals(hubiMsgLst.get(1).getGyoumuKousinTime(), "20160509141230000", "業務用更新時間");

            exStringEquals(hubiMsgLst.get(2).getMosno(), "880000997", "申込番号");
            exNumericEquals(hubiMsgLst.get(2).getRenno(), 3, "連番");
            exStringEquals(hubiMsgLst.get(2).getMessageId(), "EHC0019", "メッセージＩＤ");
            exStringEquals(hubiMsgLst.get(2).getHubimsg(), "外貨建て一時払終身保険（毎年受取型）　１５年毎利率再設定の本人型は取扱えません。", "不備メッセージ");
            exClassificationEquals(hubiMsgLst.get(2).getHubisyubetukbn(), C_HubisyubetuKbn.KETHORYU_HUBI, "不備種別区分");
            exStringEquals(hubiMsgLst.get(2).getGyoumuKousinsyaId(), "JUnitTest", "業務用更新者ＩＤ");
            exStringEquals(hubiMsgLst.get(2).getGyoumuKousinTime(), "20160509141230000", "業務用更新時間");

            exStringEquals(e.getMessage(), "システム整合性エラーです。最低Ｐテーブルにデータが見つかりません。", "エラーメッセージ");
            throw e;
        }
    }

    @Test
    @TestOrder(3440)
    @Transactional
    public void testExec_A65() {
        MockObjectManager.initialize();
        BzGetAgInfoMockForSinkeiyaku.SYORIPTN = BzGetAgInfoMockForSinkeiyaku.TESTPATTERN1;
        CheckSaiteiPMockForSinkeiyaku.SYORIPTN = CheckSaiteiPMockForSinkeiyaku.TESTPATTERN1;
        HanteiMoschkMockForSinkeiyaku.SYORIPTN = HanteiMoschkMockForSinkeiyaku.TESTPATTERN1;
        EditNenkinKoumokuUtilMockForSinkeiyaku.SYORIPTN = EditNenkinKoumokuUtilMockForSinkeiyaku.TESTPATTERN4;
        DrtenTkykTratkiHanteiMockForSinkeiyaku.SYORIPTN = DrtenTkykTratkiHanteiMockForSinkeiyaku.TESTPATTERN1;
        CheckTblMosSyouhin checkTblMosSyouhin = SWAKInjector.getInstance(CheckTblMosSyouhin.class);

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("860000314");

        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setSysKbn(C_SysKbn.ESHIEN);
        mosnaiCheckParam.setKokutiChkHuyoUmu(C_UmuKbn.NONE);
        mosnaiCheckParam.setSysDate(BizDate.valueOf(20160102));
        mosnaiCheckParam.setSekmossakuseiSousasyaKbn(C_SeihowebsousasyaKbn.DIRTNBSYNN);
        mosnaiCheckParam.setSekmossakuseiOyaAgCd("5100001");


        mosnaiCheckParam.setListHubiMsg(new ArrayList<HT_HubiMsg>());
        mosnaiCheckParam.setKosID("JUnitTest");
        mosnaiCheckParam.setKosTime("20160509141230000");
        mosnaiCheckParam.setKiteiCheckChannelCd(C_Channelcd.MIZUHO);

        List<BM_SyouhnZokusei> listTkSyouhnZokusei = new ArrayList<>();

        BM_SyouhnZokusei syouhnZokusei1 = new BM_SyouhnZokusei();
        syouhnZokusei1.setSyouhncd("ｱ1");
        syouhnZokusei1.setSyouhnsdno(1);
        syouhnZokusei1.setNkhknumu(C_UmuKbn.ARI);
        syouhnZokusei1.setSyouhnnm("商品名００１");

        listTkSyouhnZokusei.add(syouhnZokusei1);
        mosnaiCheckParam.setListTkSyouhnZokusei(listTkSyouhnZokusei);

        BM_SyouhnZokusei syouhnZokusei = new BM_SyouhnZokusei();
        syouhnZokusei.setSyouhncd("ﾕﾉ");
        syouhnZokusei.setSyouhnsdno(1);
        syouhnZokusei.setSyouhnnm("商品名０００");
        syouhnZokusei.setKyhkataumu(C_UmuKbn.NONE);
        syouhnZokusei.setNkhknumu(C_UmuKbn.ARI);
        syouhnZokusei.setSyksbyensitihsyutktekiumu(C_UmuKbn.ARI);
        syouhnZokusei.setYoteirirituhendoukbn(C_YoteirirituhendouKbn.NONE);
        mosnaiCheckParam.setSyuSyouhnZokusei(syouhnZokusei);

        checkTblMosSyouhin.exec(mosnaiCheckParam);

        exClassificationEquals(mosnaiCheckParam.getSekmossakuseiErroutKbn(), C_SekmossakuseiErroutKbn.GAMEN, "設計書申込書作成エラー出力区分");
        exStringEquals(mosnaiCheckParam.getSekmossakuseiErrmsg1(), "", "設計書申込書作成エラーメッセージ１");
        exStringEquals(mosnaiCheckParam.getSekmossakuseiErrmsg2(), "募集年齢範囲外です　当予定利率期間の募集年齢範囲は１歳から１０歳です", "設計書申込書作成エラーメッセージ２");
        exClassificationEquals(mosnaiCheckParam.getKouzokuSyoriJikkouKbn(), C_KouzokujkKbn.NONE, "後続処理実行区分");

        String pSyouhncd = (String) MockObjectManager.getArgument(
            DrtenTkykTratkiHanteiMockForSinkeiyaku.class, "initsbjiYenknsnshrgkSaiteihsytkTratkiHantei", 0, 0);

        exStringEquals(pSyouhncd, "ﾕﾉ", "商品コード");

        C_UmuKbn syksbyensitihsyutktekiumu = (C_UmuKbn) MockObjectManager.getArgument(
            DrtenTkykTratkiHanteiMockForSinkeiyaku.class, "initsbjiYenknsnshrgkSaiteihsytkTratkiHantei", 0, 1);

        exClassificationEquals(syksbyensitihsyutktekiumu, C_UmuKbn.ARI, "初期死亡時円換算最低保証特約適用有無");

        C_SkeijimuKbn skeijimuKbn = (C_SkeijimuKbn) MockObjectManager.getArgument(
            DrtenTkykTratkiHanteiMockForSinkeiyaku.class, "initsbjiYenknsnshrgkSaiteihsytkTratkiHantei", 0, 2);

        exClassificationEquals(skeijimuKbn, C_SkeijimuKbn.TIGINSINKIN, "新契約事務区分");

        String pOyadrtencd = (String) MockObjectManager.getArgument(
            DrtenTkykTratkiHanteiMockForSinkeiyaku.class, "initsbjiYenknsnshrgkSaiteihsytkTratkiHantei", 0, 3);

        exStringEquals(pOyadrtencd, "5100001", "親代理店コード ");

    }

    @Test
    @TestOrder(3450)
    @Transactional
    public void testExec_A66() {
        MockObjectManager.initialize();
        BzGetAgInfoMockForSinkeiyaku.SYORIPTN = BzGetAgInfoMockForSinkeiyaku.TESTPATTERN1;
        CheckSaiteiPMockForSinkeiyaku.SYORIPTN = CheckSaiteiPMockForSinkeiyaku.TESTPATTERN1;
        HanteiMoschkMockForSinkeiyaku.SYORIPTN = HanteiMoschkMockForSinkeiyaku.TESTPATTERN1;
        EditNenkinKoumokuUtilMockForSinkeiyaku.SYORIPTN = EditNenkinKoumokuUtilMockForSinkeiyaku.TESTPATTERN4;
        DrtenTkykTratkiHanteiMockForSinkeiyaku.SYORIPTN = DrtenTkykTratkiHanteiMockForSinkeiyaku.TESTPATTERN2;
        CheckTblMosSyouhin checkTblMosSyouhin = SWAKInjector.getInstance(CheckTblMosSyouhin.class);

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("860000306");

        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setSysKbn(C_SysKbn.ESHIEN);
        mosnaiCheckParam.setKokutiChkHuyoUmu(C_UmuKbn.NONE);
        mosnaiCheckParam.setSysDate(BizDate.valueOf(20160102));
        mosnaiCheckParam.setSekmossakuseiSousasyaKbn(C_SeihowebsousasyaKbn.DIRTNBSYNN);

        mosnaiCheckParam.setListHubiMsg(new ArrayList<HT_HubiMsg>());
        mosnaiCheckParam.setKosID("JUnitTest");
        mosnaiCheckParam.setKosTime("20160509141230000");
        mosnaiCheckParam.setKiteiCheckChannelCd(C_Channelcd.MIZUHO);

        List<BM_SyouhnZokusei> listTkSyouhnZokusei = new ArrayList<>();

        BM_SyouhnZokusei syouhnZokusei1 = new BM_SyouhnZokusei();
        syouhnZokusei1.setSyouhncd("ｱ1");
        syouhnZokusei1.setSyouhnsdno(1);
        syouhnZokusei1.setNkhknumu(C_UmuKbn.ARI);
        syouhnZokusei1.setSyouhnnm("商品名００１");

        listTkSyouhnZokusei.add(syouhnZokusei1);
        mosnaiCheckParam.setListTkSyouhnZokusei(listTkSyouhnZokusei);

        BM_SyouhnZokusei syouhnZokusei = new BM_SyouhnZokusei();
        syouhnZokusei.setSyouhncd("ﾕﾉ");
        syouhnZokusei.setSyouhnsdno(1);
        syouhnZokusei.setSyouhnnm("商品名０００");
        syouhnZokusei.setKyhkataumu(C_UmuKbn.NONE);
        syouhnZokusei.setNkhknumu(C_UmuKbn.ARI);
        syouhnZokusei.setYoteirirituhendoukbn(C_YoteirirituhendouKbn.NONE);
        mosnaiCheckParam.setSyuSyouhnZokusei(syouhnZokusei);

        checkTblMosSyouhin.exec(mosnaiCheckParam);

        exClassificationEquals(mosnaiCheckParam.getSekmossakuseiErroutKbn(), C_SekmossakuseiErroutKbn.GAMEN, "設計書申込書作成エラー出力区分");
        exStringEquals(mosnaiCheckParam.getSekmossakuseiErrmsg1(), "", "設計書申込書作成エラーメッセージ１");
        exStringEquals(mosnaiCheckParam.getSekmossakuseiErrmsg2(), "募集年齢範囲外です　当予定利率期間の募集年齢範囲は１歳から１０歳です", "設計書申込書作成エラーメッセージ２");
        exClassificationEquals(mosnaiCheckParam.getKouzokuSyoriJikkouKbn(), C_KouzokujkKbn.NONE, "後続処理実行区分");

    }

    @Test
    @TestOrder(3460)
    @Transactional
    public void testExec_A67() {
        MockObjectManager.initialize();
        BzGetAgInfoMockForSinkeiyaku.SYORIPTN = BzGetAgInfoMockForSinkeiyaku.TESTPATTERN1;
        CheckSaiteiPMockForSinkeiyaku.SYORIPTN = CheckSaiteiPMockForSinkeiyaku.TESTPATTERN1;
        HanteiMoschkMockForSinkeiyaku.SYORIPTN = HanteiMoschkMockForSinkeiyaku.TESTPATTERN1;
        EditNenkinKoumokuUtilMockForSinkeiyaku.SYORIPTN = EditNenkinKoumokuUtilMockForSinkeiyaku.TESTPATTERN4;
        CheckTblMosSyouhin checkTblMosSyouhin = SWAKInjector.getInstance(CheckTblMosSyouhin.class);

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("860000322");

        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setSysKbn(C_SysKbn.ESHIEN);
        mosnaiCheckParam.setKokutiChkHuyoUmu(C_UmuKbn.NONE);
        mosnaiCheckParam.setSysDate(BizDate.valueOf(20160102));
        mosnaiCheckParam.setSekmossakuseiSousasyaKbn(C_SeihowebsousasyaKbn.DIRTNBSYNN);

        mosnaiCheckParam.setListHubiMsg(new ArrayList<HT_HubiMsg>());
        mosnaiCheckParam.setKosID("JUnitTest");
        mosnaiCheckParam.setKosTime("20160509141230000");
        mosnaiCheckParam.setKiteiCheckChannelCd(C_Channelcd.MIZUHO);

        List<BM_SyouhnZokusei> listTkSyouhnZokusei = new ArrayList<>();

        BM_SyouhnZokusei syouhnZokusei1 = new BM_SyouhnZokusei();
        syouhnZokusei1.setSyouhncd("ｱ1");
        syouhnZokusei1.setSyouhnsdno(1);
        syouhnZokusei1.setNkhknumu(C_UmuKbn.ARI);
        syouhnZokusei1.setSyouhnnm("商品名００１");

        listTkSyouhnZokusei.add(syouhnZokusei1);
        mosnaiCheckParam.setListTkSyouhnZokusei(listTkSyouhnZokusei);

        BM_SyouhnZokusei syouhnZokusei = new BM_SyouhnZokusei();
        syouhnZokusei.setSyouhncd("ﾕﾉ");
        syouhnZokusei.setSyouhnsdno(1);
        syouhnZokusei.setSyouhnnm("商品名０００");
        syouhnZokusei.setKyhkataumu(C_UmuKbn.NONE);
        syouhnZokusei.setNkhknumu(C_UmuKbn.ARI);
        syouhnZokusei.setYoteirirituhendoukbn(C_YoteirirituhendouKbn.NONE);
        mosnaiCheckParam.setSyuSyouhnZokusei(syouhnZokusei);

        checkTblMosSyouhin.exec(mosnaiCheckParam);

        exClassificationEquals(mosnaiCheckParam.getSekmossakuseiErroutKbn(), C_SekmossakuseiErroutKbn.GAMEN, "設計書申込書作成エラー出力区分");
        exStringEquals(mosnaiCheckParam.getSekmossakuseiErrmsg1(), "", "設計書申込書作成エラーメッセージ１");
        exStringEquals(mosnaiCheckParam.getSekmossakuseiErrmsg2(), "募集年齢範囲外です　当予定利率期間の募集年齢範囲は１歳から１０歳です", "設計書申込書作成エラーメッセージ２");
        exClassificationEquals(mosnaiCheckParam.getKouzokuSyoriJikkouKbn(), C_KouzokujkKbn.NONE, "後続処理実行区分");

    }


    @Test
    @TestOrder(3470)
    @Transactional
    public void testExec_A68() {
        MockObjectManager.initialize();
        BzGetAgInfoMockForSinkeiyaku.SYORIPTN = BzGetAgInfoMockForSinkeiyaku.TESTPATTERN1;
        CheckSaiteiPMockForSinkeiyaku.SYORIPTN = CheckSaiteiPMockForSinkeiyaku.TESTPATTERN1;
        HanteiMoschkMockForSinkeiyaku.SYORIPTN = HanteiMoschkMockForSinkeiyaku.TESTPATTERN1;
        EditNenkinKoumokuUtilMockForSinkeiyaku.SYORIPTN = EditNenkinKoumokuUtilMockForSinkeiyaku.TESTPATTERN4;
        DrtenTkykTratkiHanteiMockForSinkeiyaku.SYORIPTN = DrtenTkykTratkiHanteiMockForSinkeiyaku.TESTPATTERN1;
        CheckTblMosSyouhin checkTblMosSyouhin = SWAKInjector.getInstance(CheckTblMosSyouhin.class);

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("860000330");

        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setSysKbn(C_SysKbn.ESHIEN);
        mosnaiCheckParam.setKokutiChkHuyoUmu(C_UmuKbn.NONE);
        mosnaiCheckParam.setSysDate(BizDate.valueOf(20160102));
        mosnaiCheckParam.setSekmossakuseiSousasyaKbn(C_SeihowebsousasyaKbn.DIRTNBSYNN);
        mosnaiCheckParam.setSekmossakuseiOyaAgCd("5100001");


        mosnaiCheckParam.setListHubiMsg(new ArrayList<HT_HubiMsg>());
        mosnaiCheckParam.setKosID("JUnitTest");
        mosnaiCheckParam.setKosTime("20160509141230000");
        mosnaiCheckParam.setKiteiCheckChannelCd(C_Channelcd.MIZUHO);

        List<BM_SyouhnZokusei> listTkSyouhnZokusei = new ArrayList<>();

        BM_SyouhnZokusei syouhnZokusei1 = new BM_SyouhnZokusei();
        syouhnZokusei1.setSyouhncd("ｱ1");
        syouhnZokusei1.setSyouhnsdno(1);
        syouhnZokusei1.setNkhknumu(C_UmuKbn.ARI);
        syouhnZokusei1.setSyouhnnm("商品名００１");

        listTkSyouhnZokusei.add(syouhnZokusei1);
        mosnaiCheckParam.setListTkSyouhnZokusei(listTkSyouhnZokusei);

        BM_SyouhnZokusei syouhnZokusei = new BM_SyouhnZokusei();
        syouhnZokusei.setSyouhncd("ﾕﾋ");
        syouhnZokusei.setSyouhnsdno(1);
        syouhnZokusei.setSyouhnnm("商品名０００");
        syouhnZokusei.setKyhkataumu(C_UmuKbn.NONE);
        syouhnZokusei.setNkhknumu(C_UmuKbn.ARI);
        syouhnZokusei.setSyksbyensitihsyutktekiumu(C_UmuKbn.ARI);
        syouhnZokusei.setYoteirirituhendoukbn(C_YoteirirituhendouKbn.NONE);
        mosnaiCheckParam.setSyuSyouhnZokusei(syouhnZokusei);

        checkTblMosSyouhin.exec(mosnaiCheckParam);

        exClassificationEquals(mosnaiCheckParam.getSekmossakuseiErroutKbn(), C_SekmossakuseiErroutKbn.GAMEN, "設計書申込書作成エラー出力区分");
        exStringEquals(mosnaiCheckParam.getSekmossakuseiErrmsg1(), "", "設計書申込書作成エラーメッセージ１");
        exStringEquals(mosnaiCheckParam.getSekmossakuseiErrmsg2(), "募集年齢範囲外です　当予定利率期間の募集年齢範囲は１歳から１０歳です", "設計書申込書作成エラーメッセージ２");
        exClassificationEquals(mosnaiCheckParam.getKouzokuSyoriJikkouKbn(), C_KouzokujkKbn.NONE, "後続処理実行区分");

        String pSyouhncd = (String) MockObjectManager.getArgument(
            DrtenTkykTratkiHanteiMockForSinkeiyaku.class, "initsbjiYenknsnshrgkSaiteihsytkTratkiHantei", 0, 0);

        exStringEquals(pSyouhncd, "ﾕﾋ", "商品コード");

        C_UmuKbn syksbyensitihsyutktekiumu = (C_UmuKbn) MockObjectManager.getArgument(
            DrtenTkykTratkiHanteiMockForSinkeiyaku.class, "initsbjiYenknsnshrgkSaiteihsytkTratkiHantei", 0, 1);

        exClassificationEquals(syksbyensitihsyutktekiumu, C_UmuKbn.ARI, "初期死亡時円換算最低保証特約適用有無");

        C_SkeijimuKbn skeijimuKbn = (C_SkeijimuKbn) MockObjectManager.getArgument(
            DrtenTkykTratkiHanteiMockForSinkeiyaku.class, "initsbjiYenknsnshrgkSaiteihsytkTratkiHantei", 0, 2);

        exClassificationEquals(skeijimuKbn, C_SkeijimuKbn.TIGINSINKIN, "新契約事務区分");

        String pOyadrtencd = (String) MockObjectManager.getArgument(
            DrtenTkykTratkiHanteiMockForSinkeiyaku.class, "initsbjiYenknsnshrgkSaiteihsytkTratkiHantei", 0, 3);

        exStringEquals(pOyadrtencd, "5100001", "親代理店コード ");

    }


    @Test
    @TestOrder(3480)
    @Transactional
    public void testExec_A69() {
        MockObjectManager.initialize();
        CheckSaiteiPMockForSinkeiyaku.SYORIPTN = CheckSaiteiPMockForSinkeiyaku.TESTPATTERN1;
        HanteiMoschkMockForSinkeiyaku.SYORIPTN = HanteiMoschkMockForSinkeiyaku.TESTPATTERN2;
        CheckTblMosSyouhin checkTblMosSyouhin = SWAKInjector.getInstance(CheckTblMosSyouhin.class);

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("860000348");
        List<BM_SyouhnZokusei> listTkSyouhnZokusei = new ArrayList<>();
        BM_SyouhnZokusei syouhnZokusei1 = new BM_SyouhnZokusei();
        syouhnZokusei1.setSyouhncd("ｱ1");
        syouhnZokusei1.setSyouhnsdno(1);

        syouhnZokusei1.setNkhknumu(C_UmuKbn.ARI);

        syouhnZokusei1.setSyouhnnm("商品名００１");

        BM_SyouhnZokusei syouhnZokusei2 = new BM_SyouhnZokusei();
        syouhnZokusei2.setSyouhncd("ｱ8");
        syouhnZokusei2.setSyouhnsdno(1);

        syouhnZokusei2.setSyouhnnm("商品名００２");

        BM_SyouhnZokusei syouhnZokusei3 = new BM_SyouhnZokusei();
        syouhnZokusei3.setSyouhncd("ｱ9");
        syouhnZokusei3.setSyouhnsdno(1);
        syouhnZokusei3.setSyouhnnm("商品名００３");

        listTkSyouhnZokusei.add(syouhnZokusei1);
        listTkSyouhnZokusei.add(syouhnZokusei2);
        listTkSyouhnZokusei.add(syouhnZokusei3);

        mosnaiCheckParam.setListTkSyouhnZokusei(listTkSyouhnZokusei);

        BM_SyouhnZokusei syouhnZokusei = new BM_SyouhnZokusei();
        syouhnZokusei.setSyouhncd("ﾕﾍ");
        syouhnZokusei.setSyouhnsdno(1);

        syouhnZokusei.setSyouhnnm("商品名０００");

        syouhnZokusei.setYoteirirituhendoukbn(C_YoteirirituhendouKbn.TUKI1KAI);

        syouhnZokusei.setNkhknumu(C_UmuKbn.ARI);
        mosnaiCheckParam.setSyuSyouhnZokusei(syouhnZokusei);

        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setSysKbn(C_SysKbn.ESHIEN);
        mosnaiCheckParam.setKokutiChkHuyoUmu(C_UmuKbn.NONE);
        mosnaiCheckParam.setSysDate(BizDate.valueOf(20160102));
        mosnaiCheckParam.setSekmossakuseiSousasyaKbn(C_SeihowebsousasyaKbn.SUPPORTDESK);
        mosnaiCheckParam.setKiteiCheckChannelCd(C_Channelcd.TIGIN);

        checkTblMosSyouhin.exec(mosnaiCheckParam);

        exClassificationEquals(mosnaiCheckParam.getSekmossakuseiErroutKbn(), C_SekmossakuseiErroutKbn.GAMEN, "設計書申込書作成エラー出力区分");
        exStringEquals(mosnaiCheckParam.getSekmossakuseiErrmsg1(), "", "設計書申込書作成エラーメッセージ１");
        exStringEquals(mosnaiCheckParam.getSekmossakuseiErrmsg2(), "据置期間１０年は選択できません", "設計書申込書作成エラーメッセージ２");
        exClassificationEquals(mosnaiCheckParam.getKouzokuSyoriJikkouKbn(), C_KouzokujkKbn.NONE, "後続処理実行区分");
    }

    @Test
    @TestOrder(3490)
    @Transactional
    public void testExec_A70() {
        MockObjectManager.initialize();
        CheckSaiteiPMockForSinkeiyaku.SYORIPTN = CheckSaiteiPMockForSinkeiyaku.TESTPATTERN1;
        HanteiMoschkMockForSinkeiyaku.SYORIPTN = HanteiMoschkMockForSinkeiyaku.TESTPATTERN2;
        CheckTblMosSyouhin checkTblMosSyouhin = SWAKInjector.getInstance(CheckTblMosSyouhin.class);

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("860000355");
        List<BM_SyouhnZokusei> listTkSyouhnZokusei = new ArrayList<>();
        BM_SyouhnZokusei syouhnZokusei1 = new BM_SyouhnZokusei();
        syouhnZokusei1.setSyouhncd("ｱ1");
        syouhnZokusei1.setSyouhnsdno(1);

        syouhnZokusei1.setNkhknumu(C_UmuKbn.ARI);

        syouhnZokusei1.setSyouhnnm("商品名００１");

        BM_SyouhnZokusei syouhnZokusei2 = new BM_SyouhnZokusei();
        syouhnZokusei2.setSyouhncd("ｱ8");
        syouhnZokusei2.setSyouhnsdno(1);

        syouhnZokusei2.setSyouhnnm("商品名００２");

        BM_SyouhnZokusei syouhnZokusei3 = new BM_SyouhnZokusei();
        syouhnZokusei3.setSyouhncd("ｱ9");
        syouhnZokusei3.setSyouhnsdno(1);
        syouhnZokusei3.setSyouhnnm("商品名００３");

        listTkSyouhnZokusei.add(syouhnZokusei1);
        listTkSyouhnZokusei.add(syouhnZokusei2);
        listTkSyouhnZokusei.add(syouhnZokusei3);

        mosnaiCheckParam.setListTkSyouhnZokusei(listTkSyouhnZokusei);

        BM_SyouhnZokusei syouhnZokusei = new BM_SyouhnZokusei();
        syouhnZokusei.setSyouhncd("ﾕﾍ");
        syouhnZokusei.setSyouhnsdno(1);

        syouhnZokusei.setSyouhnnm("商品名０００");

        syouhnZokusei.setYoteirirituhendoukbn(C_YoteirirituhendouKbn.TUKI1KAI);

        syouhnZokusei.setNkhknumu(C_UmuKbn.ARI);
        mosnaiCheckParam.setSyuSyouhnZokusei(syouhnZokusei);

        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setSysKbn(C_SysKbn.ESHIEN);
        mosnaiCheckParam.setKokutiChkHuyoUmu(C_UmuKbn.NONE);
        mosnaiCheckParam.setSysDate(BizDate.valueOf(20160102));
        mosnaiCheckParam.setSekmossakuseiSousasyaKbn(C_SeihowebsousasyaKbn.SUPPORTDESK);
        mosnaiCheckParam.setKiteiCheckChannelCd(C_Channelcd.TIGIN);

        checkTblMosSyouhin.exec(mosnaiCheckParam);

        exClassificationEquals(mosnaiCheckParam.getSekmossakuseiErroutKbn(), C_SekmossakuseiErroutKbn.GAMEN, "設計書申込書作成エラー出力区分");
        exStringEquals(mosnaiCheckParam.getSekmossakuseiErrmsg1(), "", "設計書申込書作成エラーメッセージ１");
        exStringEquals(mosnaiCheckParam.getSekmossakuseiErrmsg2(), "据置期間１０年は選択できません", "設計書申込書作成エラーメッセージ２");
        exClassificationEquals(mosnaiCheckParam.getKouzokuSyoriJikkouKbn(), C_KouzokujkKbn.NONE, "後続処理実行区分");
    }

    @Test
    @TestOrder(3500)
    @Transactional
    public void testExec_A71() {
        MockObjectManager.initialize();
        CheckSaiteiPMockForSinkeiyaku.SYORIPTN = CheckSaiteiPMockForSinkeiyaku.TESTPATTERN1;
        HanteiMoschkMockForSinkeiyaku.SYORIPTN = HanteiMoschkMockForSinkeiyaku.TESTPATTERN2;
        CheckTblMosSyouhin checkTblMosSyouhin = SWAKInjector.getInstance(CheckTblMosSyouhin.class);

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("860000363");
        List<BM_SyouhnZokusei> listTkSyouhnZokusei = new ArrayList<>();
        BM_SyouhnZokusei syouhnZokusei1 = new BM_SyouhnZokusei();
        syouhnZokusei1.setSyouhncd("ｱ1");
        syouhnZokusei1.setSyouhnsdno(1);

        syouhnZokusei1.setNkhknumu(C_UmuKbn.ARI);

        syouhnZokusei1.setSyouhnnm("商品名００１");

        BM_SyouhnZokusei syouhnZokusei2 = new BM_SyouhnZokusei();
        syouhnZokusei2.setSyouhncd("ｱ8");
        syouhnZokusei2.setSyouhnsdno(1);

        syouhnZokusei2.setSyouhnnm("商品名００２");

        BM_SyouhnZokusei syouhnZokusei3 = new BM_SyouhnZokusei();
        syouhnZokusei3.setSyouhncd("ｱ9");
        syouhnZokusei3.setSyouhnsdno(1);
        syouhnZokusei3.setSyouhnnm("商品名００３");

        listTkSyouhnZokusei.add(syouhnZokusei1);
        listTkSyouhnZokusei.add(syouhnZokusei2);
        listTkSyouhnZokusei.add(syouhnZokusei3);

        mosnaiCheckParam.setListTkSyouhnZokusei(listTkSyouhnZokusei);

        BM_SyouhnZokusei syouhnZokusei = new BM_SyouhnZokusei();
        syouhnZokusei.setSyouhncd("ﾕﾍ");
        syouhnZokusei.setSyouhnsdno(1);

        syouhnZokusei.setSyouhnnm("商品名０００");

        syouhnZokusei.setYoteirirituhendoukbn(C_YoteirirituhendouKbn.TUKI1KAI);

        syouhnZokusei.setNkhknumu(C_UmuKbn.ARI);
        mosnaiCheckParam.setSyuSyouhnZokusei(syouhnZokusei);

        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setSysKbn(C_SysKbn.ESHIEN);
        mosnaiCheckParam.setKokutiChkHuyoUmu(C_UmuKbn.NONE);
        mosnaiCheckParam.setSysDate(BizDate.valueOf(20160102));
        mosnaiCheckParam.setSekmossakuseiSousasyaKbn(C_SeihowebsousasyaKbn.SUPPORTDESK);
        mosnaiCheckParam.setKiteiCheckChannelCd(C_Channelcd.TIGIN);

        checkTblMosSyouhin.exec(mosnaiCheckParam);

        exClassificationEquals(mosnaiCheckParam.getSekmossakuseiErroutKbn(), C_SekmossakuseiErroutKbn.GAMEN, "設計書申込書作成エラー出力区分");
        exStringEquals(mosnaiCheckParam.getSekmossakuseiErrmsg1(), "", "設計書申込書作成エラーメッセージ１");
        exStringEquals(mosnaiCheckParam.getSekmossakuseiErrmsg2(), "据置期間１０年は選択できません", "設計書申込書作成エラーメッセージ２");
        exClassificationEquals(mosnaiCheckParam.getKouzokuSyoriJikkouKbn(), C_KouzokujkKbn.NONE, "後続処理実行区分");
    }

    @Test
    @TestOrder(3510)
    @Transactional
    public void testExec_A72() {
        MockObjectManager.initialize();
        CheckSaiteiPMockForSinkeiyaku.SYORIPTN = CheckSaiteiPMockForSinkeiyaku.TESTPATTERN1;
        HanteiMoschkMockForSinkeiyaku.SYORIPTN = HanteiMoschkMockForSinkeiyaku.TESTPATTERN2;
        CheckTblMosSyouhin checkTblMosSyouhin = SWAKInjector.getInstance(CheckTblMosSyouhin.class);

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("860000371");
        List<BM_SyouhnZokusei> listTkSyouhnZokusei = new ArrayList<>();
        BM_SyouhnZokusei syouhnZokusei1 = new BM_SyouhnZokusei();
        syouhnZokusei1.setSyouhncd("ｱ1");
        syouhnZokusei1.setSyouhnsdno(1);

        syouhnZokusei1.setNkhknumu(C_UmuKbn.ARI);

        syouhnZokusei1.setSyouhnnm("商品名００１");

        BM_SyouhnZokusei syouhnZokusei2 = new BM_SyouhnZokusei();
        syouhnZokusei2.setSyouhncd("ｱ8");
        syouhnZokusei2.setSyouhnsdno(1);

        syouhnZokusei2.setSyouhnnm("商品名００２");

        BM_SyouhnZokusei syouhnZokusei3 = new BM_SyouhnZokusei();
        syouhnZokusei3.setSyouhncd("ｱ9");
        syouhnZokusei3.setSyouhnsdno(1);
        syouhnZokusei3.setSyouhnnm("商品名００３");

        listTkSyouhnZokusei.add(syouhnZokusei1);
        listTkSyouhnZokusei.add(syouhnZokusei2);
        listTkSyouhnZokusei.add(syouhnZokusei3);

        mosnaiCheckParam.setListTkSyouhnZokusei(listTkSyouhnZokusei);

        BM_SyouhnZokusei syouhnZokusei = new BM_SyouhnZokusei();
        syouhnZokusei.setSyouhncd("ﾕﾍ");
        syouhnZokusei.setSyouhnsdno(1);

        syouhnZokusei.setSyouhnnm("商品名０００");

        syouhnZokusei.setYoteirirituhendoukbn(C_YoteirirituhendouKbn.TUKI1KAI);

        syouhnZokusei.setNkhknumu(C_UmuKbn.ARI);
        mosnaiCheckParam.setSyuSyouhnZokusei(syouhnZokusei);

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
    @TestOrder(3520)
    @Transactional
    public void testExec_A73() {
        MockObjectManager.initialize();
        CheckSaiteiPMockForSinkeiyaku.SYORIPTN = CheckSaiteiPMockForSinkeiyaku.TESTPATTERN1;
        HanteiMoschkMockForSinkeiyaku.SYORIPTN = HanteiMoschkMockForSinkeiyaku.TESTPATTERN2;
        CheckTblMosSyouhin checkTblMosSyouhin = SWAKInjector.getInstance(CheckTblMosSyouhin.class);

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("860000389");
        List<BM_SyouhnZokusei> listTkSyouhnZokusei = new ArrayList<>();
        BM_SyouhnZokusei syouhnZokusei1 = new BM_SyouhnZokusei();
        syouhnZokusei1.setSyouhncd("ｱ1");
        syouhnZokusei1.setSyouhnsdno(1);

        syouhnZokusei1.setNkhknumu(C_UmuKbn.ARI);

        syouhnZokusei1.setSyouhnnm("商品名００１");

        BM_SyouhnZokusei syouhnZokusei2 = new BM_SyouhnZokusei();
        syouhnZokusei2.setSyouhncd("ｱ8");
        syouhnZokusei2.setSyouhnsdno(1);

        syouhnZokusei2.setSyouhnnm("商品名００２");

        BM_SyouhnZokusei syouhnZokusei3 = new BM_SyouhnZokusei();
        syouhnZokusei3.setSyouhncd("ｱ9");
        syouhnZokusei3.setSyouhnsdno(1);
        syouhnZokusei3.setSyouhnnm("商品名００３");

        listTkSyouhnZokusei.add(syouhnZokusei1);
        listTkSyouhnZokusei.add(syouhnZokusei2);
        listTkSyouhnZokusei.add(syouhnZokusei3);

        mosnaiCheckParam.setListTkSyouhnZokusei(listTkSyouhnZokusei);

        BM_SyouhnZokusei syouhnZokusei = new BM_SyouhnZokusei();
        syouhnZokusei.setSyouhncd("ﾕﾍ");
        syouhnZokusei.setSyouhnsdno(1);

        syouhnZokusei.setSyouhnnm("商品名０００");

        syouhnZokusei.setYoteirirituhendoukbn(C_YoteirirituhendouKbn.TUKI1KAI);

        syouhnZokusei.setNkhknumu(C_UmuKbn.ARI);
        mosnaiCheckParam.setSyuSyouhnZokusei(syouhnZokusei);

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
    @TestOrder(3530)
    @Transactional
    public void testExec_A74() {
        MockObjectManager.initialize();
        CheckSaiteiPMockForSinkeiyaku.SYORIPTN = CheckSaiteiPMockForSinkeiyaku.TESTPATTERN1;
        HanteiMoschkMockForSinkeiyaku.SYORIPTN = HanteiMoschkMockForSinkeiyaku.TESTPATTERN2;
        CheckTblMosSyouhin checkTblMosSyouhin = SWAKInjector.getInstance(CheckTblMosSyouhin.class);

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("860000397");
        List<BM_SyouhnZokusei> listTkSyouhnZokusei = new ArrayList<>();
        BM_SyouhnZokusei syouhnZokusei1 = new BM_SyouhnZokusei();
        syouhnZokusei1.setSyouhncd("ｱ1");
        syouhnZokusei1.setSyouhnsdno(1);

        syouhnZokusei1.setNkhknumu(C_UmuKbn.ARI);

        syouhnZokusei1.setSyouhnnm("商品名００１");

        BM_SyouhnZokusei syouhnZokusei2 = new BM_SyouhnZokusei();
        syouhnZokusei2.setSyouhncd("ｱ8");
        syouhnZokusei2.setSyouhnsdno(1);

        syouhnZokusei2.setSyouhnnm("商品名００２");

        BM_SyouhnZokusei syouhnZokusei3 = new BM_SyouhnZokusei();
        syouhnZokusei3.setSyouhncd("ｱ9");
        syouhnZokusei3.setSyouhnsdno(1);
        syouhnZokusei3.setSyouhnnm("商品名００３");

        listTkSyouhnZokusei.add(syouhnZokusei1);
        listTkSyouhnZokusei.add(syouhnZokusei2);
        listTkSyouhnZokusei.add(syouhnZokusei3);

        mosnaiCheckParam.setListTkSyouhnZokusei(listTkSyouhnZokusei);

        BM_SyouhnZokusei syouhnZokusei = new BM_SyouhnZokusei();
        syouhnZokusei.setSyouhncd("ﾕﾍ");
        syouhnZokusei.setSyouhnsdno(1);

        syouhnZokusei.setSyouhnnm("商品名０００");

        syouhnZokusei.setYoteirirituhendoukbn(C_YoteirirituhendouKbn.TUKI1KAI);

        syouhnZokusei.setNkhknumu(C_UmuKbn.ARI);
        mosnaiCheckParam.setSyuSyouhnZokusei(syouhnZokusei);

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
    @TestOrder(3540)
    @Transactional
    public void testExec_A75() {
        MockObjectManager.initialize();
        CheckSaiteiPMockForSinkeiyaku.SYORIPTN = CheckSaiteiPMockForSinkeiyaku.TESTPATTERN1;
        HanteiMoschkMockForSinkeiyaku.SYORIPTN = HanteiMoschkMockForSinkeiyaku.TESTPATTERN2;
        CheckTblMosSyouhin checkTblMosSyouhin = SWAKInjector.getInstance(CheckTblMosSyouhin.class);

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("860000405");
        List<BM_SyouhnZokusei> listTkSyouhnZokusei = new ArrayList<>();
        BM_SyouhnZokusei syouhnZokusei1 = new BM_SyouhnZokusei();
        syouhnZokusei1.setSyouhncd("ｱ1");
        syouhnZokusei1.setSyouhnsdno(1);

        syouhnZokusei1.setNkhknumu(C_UmuKbn.ARI);

        syouhnZokusei1.setSyouhnnm("商品名００１");

        BM_SyouhnZokusei syouhnZokusei2 = new BM_SyouhnZokusei();
        syouhnZokusei2.setSyouhncd("ｱ8");
        syouhnZokusei2.setSyouhnsdno(1);

        syouhnZokusei2.setSyouhnnm("商品名００２");

        BM_SyouhnZokusei syouhnZokusei3 = new BM_SyouhnZokusei();
        syouhnZokusei3.setSyouhncd("ｱ9");
        syouhnZokusei3.setSyouhnsdno(1);
        syouhnZokusei3.setSyouhnnm("商品名００３");

        listTkSyouhnZokusei.add(syouhnZokusei1);
        listTkSyouhnZokusei.add(syouhnZokusei2);
        listTkSyouhnZokusei.add(syouhnZokusei3);

        mosnaiCheckParam.setListTkSyouhnZokusei(listTkSyouhnZokusei);

        BM_SyouhnZokusei syouhnZokusei = new BM_SyouhnZokusei();
        syouhnZokusei.setSyouhncd("ﾕﾍ");
        syouhnZokusei.setSyouhnsdno(1);

        syouhnZokusei.setSyouhnnm("商品名０００");

        syouhnZokusei.setYoteirirituhendoukbn(C_YoteirirituhendouKbn.TUKI1KAI);

        syouhnZokusei.setNkhknumu(C_UmuKbn.ARI);
        mosnaiCheckParam.setSyuSyouhnZokusei(syouhnZokusei);

        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setSysKbn(C_SysKbn.ESHIEN);
        mosnaiCheckParam.setKokutiChkHuyoUmu(C_UmuKbn.NONE);
        mosnaiCheckParam.setSysDate(BizDate.valueOf(20160102));
        mosnaiCheckParam.setSekmossakuseiSousasyaKbn(C_SeihowebsousasyaKbn.SUPPORTDESK);
        mosnaiCheckParam.setKiteiCheckChannelCd(C_Channelcd.TIGIN);

        checkTblMosSyouhin.exec(mosnaiCheckParam);

        exClassificationEquals(mosnaiCheckParam.getSekmossakuseiErroutKbn(), C_SekmossakuseiErroutKbn.GAMEN, "設計書申込書作成エラー出力区分");
        exStringEquals(mosnaiCheckParam.getSekmossakuseiErrmsg1(), "", "設計書申込書作成エラーメッセージ１");
        exStringEquals(mosnaiCheckParam.getSekmossakuseiErrmsg2(), "終身年金の据置期間５年は選択できません", "設計書申込書作成エラーメッセージ２");
        exClassificationEquals(mosnaiCheckParam.getKouzokuSyoriJikkouKbn(), C_KouzokujkKbn.NONE, "後続処理実行区分");
    }

    @Test
    @TestOrder(3550)
    @Transactional
    public void testExec_A76() {
        MockObjectManager.initialize();
        CheckSaiteiPMockForSinkeiyaku.SYORIPTN = CheckSaiteiPMockForSinkeiyaku.TESTPATTERN1;
        HanteiMoschkMockForSinkeiyaku.SYORIPTN = HanteiMoschkMockForSinkeiyaku.TESTPATTERN2;
        CheckTblMosSyouhin checkTblMosSyouhin = SWAKInjector.getInstance(CheckTblMosSyouhin.class);

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("860000413");
        List<BM_SyouhnZokusei> listTkSyouhnZokusei = new ArrayList<>();
        BM_SyouhnZokusei syouhnZokusei1 = new BM_SyouhnZokusei();
        syouhnZokusei1.setSyouhncd("ｱ1");
        syouhnZokusei1.setSyouhnsdno(1);

        syouhnZokusei1.setNkhknumu(C_UmuKbn.ARI);

        syouhnZokusei1.setSyouhnnm("商品名００１");

        BM_SyouhnZokusei syouhnZokusei2 = new BM_SyouhnZokusei();
        syouhnZokusei2.setSyouhncd("ｱ8");
        syouhnZokusei2.setSyouhnsdno(1);

        syouhnZokusei2.setSyouhnnm("商品名００２");

        BM_SyouhnZokusei syouhnZokusei3 = new BM_SyouhnZokusei();
        syouhnZokusei3.setSyouhncd("ｱ9");
        syouhnZokusei3.setSyouhnsdno(1);
        syouhnZokusei3.setSyouhnnm("商品名００３");

        listTkSyouhnZokusei.add(syouhnZokusei1);
        listTkSyouhnZokusei.add(syouhnZokusei2);
        listTkSyouhnZokusei.add(syouhnZokusei3);

        mosnaiCheckParam.setListTkSyouhnZokusei(listTkSyouhnZokusei);

        BM_SyouhnZokusei syouhnZokusei = new BM_SyouhnZokusei();
        syouhnZokusei.setSyouhncd("ﾕﾍ");
        syouhnZokusei.setSyouhnsdno(1);

        syouhnZokusei.setSyouhnnm("商品名０００");

        syouhnZokusei.setYoteirirituhendoukbn(C_YoteirirituhendouKbn.TUKI1KAI);

        syouhnZokusei.setNkhknumu(C_UmuKbn.ARI);
        mosnaiCheckParam.setSyuSyouhnZokusei(syouhnZokusei);

        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setSysKbn(C_SysKbn.ESHIEN);
        mosnaiCheckParam.setKokutiChkHuyoUmu(C_UmuKbn.NONE);
        mosnaiCheckParam.setSysDate(BizDate.valueOf(20160102));
        mosnaiCheckParam.setSekmossakuseiSousasyaKbn(C_SeihowebsousasyaKbn.SUPPORTDESK);
        mosnaiCheckParam.setKiteiCheckChannelCd(C_Channelcd.TIGIN);

        checkTblMosSyouhin.exec(mosnaiCheckParam);

        exClassificationEquals(mosnaiCheckParam.getSekmossakuseiErroutKbn(), C_SekmossakuseiErroutKbn.GAMEN, "設計書申込書作成エラー出力区分");
        exStringEquals(mosnaiCheckParam.getSekmossakuseiErrmsg1(), "", "設計書申込書作成エラーメッセージ１");
        exStringEquals(mosnaiCheckParam.getSekmossakuseiErrmsg2(), "終身年金の据置期間５年は選択できません", "設計書申込書作成エラーメッセージ２");
        exClassificationEquals(mosnaiCheckParam.getKouzokuSyoriJikkouKbn(), C_KouzokujkKbn.NONE, "後続処理実行区分");
    }

    @Test
    @TestOrder(3560)
    @Transactional
    public void testExec_A77() {
        MockObjectManager.initialize();
        CheckSaiteiPMockForSinkeiyaku.SYORIPTN = CheckSaiteiPMockForSinkeiyaku.TESTPATTERN1;
        HanteiMoschkMockForSinkeiyaku.SYORIPTN = HanteiMoschkMockForSinkeiyaku.TESTPATTERN2;
        CheckTblMosSyouhin checkTblMosSyouhin = SWAKInjector.getInstance(CheckTblMosSyouhin.class);

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("860000421");
        List<BM_SyouhnZokusei> listTkSyouhnZokusei = new ArrayList<>();
        BM_SyouhnZokusei syouhnZokusei1 = new BM_SyouhnZokusei();
        syouhnZokusei1.setSyouhncd("ｱ1");
        syouhnZokusei1.setSyouhnsdno(1);

        syouhnZokusei1.setNkhknumu(C_UmuKbn.ARI);

        syouhnZokusei1.setSyouhnnm("商品名００１");

        BM_SyouhnZokusei syouhnZokusei2 = new BM_SyouhnZokusei();
        syouhnZokusei2.setSyouhncd("ｱ8");
        syouhnZokusei2.setSyouhnsdno(1);

        syouhnZokusei2.setSyouhnnm("商品名００２");

        BM_SyouhnZokusei syouhnZokusei3 = new BM_SyouhnZokusei();
        syouhnZokusei3.setSyouhncd("ｱ9");
        syouhnZokusei3.setSyouhnsdno(1);
        syouhnZokusei3.setSyouhnnm("商品名００３");

        listTkSyouhnZokusei.add(syouhnZokusei1);
        listTkSyouhnZokusei.add(syouhnZokusei2);
        listTkSyouhnZokusei.add(syouhnZokusei3);

        mosnaiCheckParam.setListTkSyouhnZokusei(listTkSyouhnZokusei);

        BM_SyouhnZokusei syouhnZokusei = new BM_SyouhnZokusei();
        syouhnZokusei.setSyouhncd("ﾕﾍ");
        syouhnZokusei.setSyouhnsdno(1);

        syouhnZokusei.setSyouhnnm("商品名０００");

        syouhnZokusei.setYoteirirituhendoukbn(C_YoteirirituhendouKbn.TUKI1KAI);

        syouhnZokusei.setNkhknumu(C_UmuKbn.ARI);
        mosnaiCheckParam.setSyuSyouhnZokusei(syouhnZokusei);

        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setSysKbn(C_SysKbn.ESHIEN);
        mosnaiCheckParam.setKokutiChkHuyoUmu(C_UmuKbn.NONE);
        mosnaiCheckParam.setSysDate(BizDate.valueOf(20160102));
        mosnaiCheckParam.setSekmossakuseiSousasyaKbn(C_SeihowebsousasyaKbn.SUPPORTDESK);
        mosnaiCheckParam.setKiteiCheckChannelCd(C_Channelcd.TIGIN);

        checkTblMosSyouhin.exec(mosnaiCheckParam);

        exClassificationEquals(mosnaiCheckParam.getSekmossakuseiErroutKbn(), C_SekmossakuseiErroutKbn.GAMEN, "設計書申込書作成エラー出力区分");
        exStringEquals(mosnaiCheckParam.getSekmossakuseiErrmsg1(), "", "設計書申込書作成エラーメッセージ１");
        exStringEquals(mosnaiCheckParam.getSekmossakuseiErrmsg2(), "終身年金の据置期間５年は選択できません", "設計書申込書作成エラーメッセージ２");
        exClassificationEquals(mosnaiCheckParam.getKouzokuSyoriJikkouKbn(), C_KouzokujkKbn.NONE, "後続処理実行区分");
    }

    @Test
    @TestOrder(3570)
    @Transactional
    public void testExec_A78() {
        MockObjectManager.initialize();
        CheckSaiteiPMockForSinkeiyaku.SYORIPTN = CheckSaiteiPMockForSinkeiyaku.TESTPATTERN1;
        HanteiMoschkMockForSinkeiyaku.SYORIPTN = HanteiMoschkMockForSinkeiyaku.TESTPATTERN2;
        CheckTblMosSyouhin checkTblMosSyouhin = SWAKInjector.getInstance(CheckTblMosSyouhin.class);

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("860000439");
        List<BM_SyouhnZokusei> listTkSyouhnZokusei = new ArrayList<>();
        BM_SyouhnZokusei syouhnZokusei1 = new BM_SyouhnZokusei();
        syouhnZokusei1.setSyouhncd("ｱ1");
        syouhnZokusei1.setSyouhnsdno(1);

        syouhnZokusei1.setNkhknumu(C_UmuKbn.ARI);

        syouhnZokusei1.setSyouhnnm("商品名００１");

        BM_SyouhnZokusei syouhnZokusei2 = new BM_SyouhnZokusei();
        syouhnZokusei2.setSyouhncd("ｱ8");
        syouhnZokusei2.setSyouhnsdno(1);

        syouhnZokusei2.setSyouhnnm("商品名００２");

        BM_SyouhnZokusei syouhnZokusei3 = new BM_SyouhnZokusei();
        syouhnZokusei3.setSyouhncd("ｱ9");
        syouhnZokusei3.setSyouhnsdno(1);
        syouhnZokusei3.setSyouhnnm("商品名００３");

        listTkSyouhnZokusei.add(syouhnZokusei1);
        listTkSyouhnZokusei.add(syouhnZokusei2);
        listTkSyouhnZokusei.add(syouhnZokusei3);

        mosnaiCheckParam.setListTkSyouhnZokusei(listTkSyouhnZokusei);

        BM_SyouhnZokusei syouhnZokusei = new BM_SyouhnZokusei();
        syouhnZokusei.setSyouhncd("ﾕﾍ");
        syouhnZokusei.setSyouhnsdno(1);

        syouhnZokusei.setSyouhnnm("商品名０００");

        syouhnZokusei.setYoteirirituhendoukbn(C_YoteirirituhendouKbn.TUKI1KAI);

        syouhnZokusei.setNkhknumu(C_UmuKbn.ARI);
        mosnaiCheckParam.setSyuSyouhnZokusei(syouhnZokusei);

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
    @TestOrder(3580)
    @Transactional
    public void testExec_A79() {
        MockObjectManager.initialize();
        CheckSaiteiPMockForSinkeiyaku.SYORIPTN = CheckSaiteiPMockForSinkeiyaku.TESTPATTERN1;
        HanteiMoschkMockForSinkeiyaku.SYORIPTN = HanteiMoschkMockForSinkeiyaku.TESTPATTERN2;
        CheckTblMosSyouhin checkTblMosSyouhin = SWAKInjector.getInstance(CheckTblMosSyouhin.class);

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("860000496");
        List<BM_SyouhnZokusei> listTkSyouhnZokusei = new ArrayList<>();
        BM_SyouhnZokusei syouhnZokusei1 = new BM_SyouhnZokusei();
        syouhnZokusei1.setSyouhncd("ｱ1");
        syouhnZokusei1.setSyouhnsdno(1);

        syouhnZokusei1.setNkhknumu(C_UmuKbn.ARI);

        syouhnZokusei1.setSyouhnnm("商品名００１");

        BM_SyouhnZokusei syouhnZokusei2 = new BM_SyouhnZokusei();
        syouhnZokusei2.setSyouhncd("ｱ8");
        syouhnZokusei2.setSyouhnsdno(1);

        syouhnZokusei2.setSyouhnnm("商品名００２");

        BM_SyouhnZokusei syouhnZokusei3 = new BM_SyouhnZokusei();
        syouhnZokusei3.setSyouhncd("ｱ9");
        syouhnZokusei3.setSyouhnsdno(1);
        syouhnZokusei3.setSyouhnnm("商品名００３");

        listTkSyouhnZokusei.add(syouhnZokusei1);
        listTkSyouhnZokusei.add(syouhnZokusei2);
        listTkSyouhnZokusei.add(syouhnZokusei3);

        mosnaiCheckParam.setListTkSyouhnZokusei(listTkSyouhnZokusei);

        BM_SyouhnZokusei syouhnZokusei = new BM_SyouhnZokusei();
        syouhnZokusei.setSyouhncd("ﾕﾍ");
        syouhnZokusei.setSyouhnsdno(1);

        syouhnZokusei.setSyouhnnm("商品名０００");

        syouhnZokusei.setYoteirirituhendoukbn(C_YoteirirituhendouKbn.TUKI1KAI);

        syouhnZokusei.setNkhknumu(C_UmuKbn.ARI);
        mosnaiCheckParam.setSyuSyouhnZokusei(syouhnZokusei);

        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setSysKbn(C_SysKbn.ESHIEN);
        mosnaiCheckParam.setKokutiChkHuyoUmu(C_UmuKbn.NONE);
        mosnaiCheckParam.setSysDate(BizDate.valueOf(20160102));
        mosnaiCheckParam.setSekmossakuseiSousasyaKbn(C_SeihowebsousasyaKbn.SUPPORTDESK);
        mosnaiCheckParam.setKiteiCheckChannelCd(C_Channelcd.TIGIN);

        checkTblMosSyouhin.exec(mosnaiCheckParam);

        exClassificationEquals(mosnaiCheckParam.getSekmossakuseiErroutKbn(), C_SekmossakuseiErroutKbn.GAMEN, "設計書申込書作成エラー出力区分");
        exStringEquals(mosnaiCheckParam.getSekmossakuseiErrmsg1(), "", "設計書申込書作成エラーメッセージ１");
        exStringEquals(mosnaiCheckParam.getSekmossakuseiErrmsg2(), "終身年金は選択できません", "設計書申込書作成エラーメッセージ２");
        exClassificationEquals(mosnaiCheckParam.getKouzokuSyoriJikkouKbn(), C_KouzokujkKbn.NONE, "後続処理実行区分");
    }

    @Test
    @TestOrder(3590)
    @Transactional
    public void testExec_A80() {
        MockObjectManager.initialize();
        CheckSaiteiPMockForSinkeiyaku.SYORIPTN = CheckSaiteiPMockForSinkeiyaku.TESTPATTERN1;
        HanteiMoschkMockForSinkeiyaku.SYORIPTN = HanteiMoschkMockForSinkeiyaku.TESTPATTERN2;
        CheckTblMosSyouhin checkTblMosSyouhin = SWAKInjector.getInstance(CheckTblMosSyouhin.class);

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("860000447");
        List<BM_SyouhnZokusei> listTkSyouhnZokusei = new ArrayList<>();
        BM_SyouhnZokusei syouhnZokusei1 = new BM_SyouhnZokusei();
        syouhnZokusei1.setSyouhncd("ｱ1");
        syouhnZokusei1.setSyouhnsdno(1);

        syouhnZokusei1.setNkhknumu(C_UmuKbn.ARI);

        syouhnZokusei1.setSyouhnnm("商品名００１");

        BM_SyouhnZokusei syouhnZokusei2 = new BM_SyouhnZokusei();
        syouhnZokusei2.setSyouhncd("ｱ8");
        syouhnZokusei2.setSyouhnsdno(1);

        syouhnZokusei2.setSyouhnnm("商品名００２");

        BM_SyouhnZokusei syouhnZokusei3 = new BM_SyouhnZokusei();
        syouhnZokusei3.setSyouhncd("ｱ9");
        syouhnZokusei3.setSyouhnsdno(1);
        syouhnZokusei3.setSyouhnnm("商品名００３");

        listTkSyouhnZokusei.add(syouhnZokusei1);
        listTkSyouhnZokusei.add(syouhnZokusei2);
        listTkSyouhnZokusei.add(syouhnZokusei3);

        mosnaiCheckParam.setListTkSyouhnZokusei(listTkSyouhnZokusei);

        BM_SyouhnZokusei syouhnZokusei = new BM_SyouhnZokusei();
        syouhnZokusei.setSyouhncd("ﾕﾍ");
        syouhnZokusei.setSyouhnsdno(1);

        syouhnZokusei.setSyouhnnm("商品名０００");

        syouhnZokusei.setYoteirirituhendoukbn(C_YoteirirituhendouKbn.TUKI1KAI);

        syouhnZokusei.setNkhknumu(C_UmuKbn.ARI);
        mosnaiCheckParam.setSyuSyouhnZokusei(syouhnZokusei);

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
    @TestOrder(3600)
    @Transactional
    public void testExec_A81() {
        MockObjectManager.initialize();
        CheckSaiteiPMockForSinkeiyaku.SYORIPTN = CheckSaiteiPMockForSinkeiyaku.TESTPATTERN1;
        HanteiMoschkMockForSinkeiyaku.SYORIPTN = HanteiMoschkMockForSinkeiyaku.TESTPATTERN2;
        CheckTblMosSyouhin checkTblMosSyouhin = SWAKInjector.getInstance(CheckTblMosSyouhin.class);

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("860000454");
        List<BM_SyouhnZokusei> listTkSyouhnZokusei = new ArrayList<>();
        BM_SyouhnZokusei syouhnZokusei1 = new BM_SyouhnZokusei();
        syouhnZokusei1.setSyouhncd("ｱ1");
        syouhnZokusei1.setSyouhnsdno(1);

        syouhnZokusei1.setNkhknumu(C_UmuKbn.ARI);

        syouhnZokusei1.setSyouhnnm("商品名００１");

        BM_SyouhnZokusei syouhnZokusei2 = new BM_SyouhnZokusei();
        syouhnZokusei2.setSyouhncd("ｱ8");
        syouhnZokusei2.setSyouhnsdno(1);

        syouhnZokusei2.setSyouhnnm("商品名００２");

        BM_SyouhnZokusei syouhnZokusei3 = new BM_SyouhnZokusei();
        syouhnZokusei3.setSyouhncd("ｱ9");
        syouhnZokusei3.setSyouhnsdno(1);
        syouhnZokusei3.setSyouhnnm("商品名００３");

        listTkSyouhnZokusei.add(syouhnZokusei1);
        listTkSyouhnZokusei.add(syouhnZokusei2);
        listTkSyouhnZokusei.add(syouhnZokusei3);

        mosnaiCheckParam.setListTkSyouhnZokusei(listTkSyouhnZokusei);

        BM_SyouhnZokusei syouhnZokusei = new BM_SyouhnZokusei();
        syouhnZokusei.setSyouhncd("ﾕﾍ");
        syouhnZokusei.setSyouhnsdno(1);

        syouhnZokusei.setSyouhnnm("商品名０００");

        syouhnZokusei.setYoteirirituhendoukbn(C_YoteirirituhendouKbn.TUKI1KAI);

        syouhnZokusei.setNkhknumu(C_UmuKbn.ARI);
        mosnaiCheckParam.setSyuSyouhnZokusei(syouhnZokusei);

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
    @TestOrder(3610)
    @Transactional
    public void testExec_A82() {
        MockObjectManager.initialize();
        CheckSaiteiPMockForSinkeiyaku.SYORIPTN = CheckSaiteiPMockForSinkeiyaku.TESTPATTERN1;
        HanteiMoschkMockForSinkeiyaku.SYORIPTN = HanteiMoschkMockForSinkeiyaku.TESTPATTERN2;
        CheckTblMosSyouhin checkTblMosSyouhin = SWAKInjector.getInstance(CheckTblMosSyouhin.class);

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("860000462");
        List<BM_SyouhnZokusei> listTkSyouhnZokusei = new ArrayList<>();
        BM_SyouhnZokusei syouhnZokusei1 = new BM_SyouhnZokusei();
        syouhnZokusei1.setSyouhncd("ｱ1");
        syouhnZokusei1.setSyouhnsdno(1);

        syouhnZokusei1.setNkhknumu(C_UmuKbn.ARI);

        syouhnZokusei1.setSyouhnnm("商品名００１");

        BM_SyouhnZokusei syouhnZokusei2 = new BM_SyouhnZokusei();
        syouhnZokusei2.setSyouhncd("ｱ8");
        syouhnZokusei2.setSyouhnsdno(1);

        syouhnZokusei2.setSyouhnnm("商品名００２");

        BM_SyouhnZokusei syouhnZokusei3 = new BM_SyouhnZokusei();
        syouhnZokusei3.setSyouhncd("ｱ9");
        syouhnZokusei3.setSyouhnsdno(1);
        syouhnZokusei3.setSyouhnnm("商品名００３");

        listTkSyouhnZokusei.add(syouhnZokusei1);
        listTkSyouhnZokusei.add(syouhnZokusei2);
        listTkSyouhnZokusei.add(syouhnZokusei3);

        mosnaiCheckParam.setListTkSyouhnZokusei(listTkSyouhnZokusei);

        BM_SyouhnZokusei syouhnZokusei = new BM_SyouhnZokusei();
        syouhnZokusei.setSyouhncd("ﾕﾍ");
        syouhnZokusei.setSyouhnsdno(1);

        syouhnZokusei.setSyouhnnm("商品名０００");

        syouhnZokusei.setYoteirirituhendoukbn(C_YoteirirituhendouKbn.TUKI1KAI);

        syouhnZokusei.setNkhknumu(C_UmuKbn.ARI);
        mosnaiCheckParam.setSyuSyouhnZokusei(syouhnZokusei);

        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setSysKbn(C_SysKbn.ESHIEN);
        mosnaiCheckParam.setKokutiChkHuyoUmu(C_UmuKbn.NONE);
        mosnaiCheckParam.setSysDate(BizDate.valueOf(20160102));
        mosnaiCheckParam.setSekmossakuseiSousasyaKbn(C_SeihowebsousasyaKbn.SUPPORTDESK);
        mosnaiCheckParam.setKiteiCheckChannelCd(C_Channelcd.TIGIN);

        checkTblMosSyouhin.exec(mosnaiCheckParam);

        exClassificationEquals(mosnaiCheckParam.getSekmossakuseiErroutKbn(), C_SekmossakuseiErroutKbn.GAMEN, "設計書申込書作成エラー出力区分");
        exStringEquals(mosnaiCheckParam.getSekmossakuseiErrmsg1(), "", "設計書申込書作成エラーメッセージ１");
        exStringEquals(mosnaiCheckParam.getSekmossakuseiErrmsg2(), "終身年金は選択できません", "設計書申込書作成エラーメッセージ２");
        exClassificationEquals(mosnaiCheckParam.getKouzokuSyoriJikkouKbn(), C_KouzokujkKbn.NONE, "後続処理実行区分");
    }

    @Test
    @TestOrder(3620)
    @Transactional
    public void testExec_A83() {
        MockObjectManager.initialize();
        CheckSaiteiPMockForSinkeiyaku.SYORIPTN = CheckSaiteiPMockForSinkeiyaku.TESTPATTERN1;
        HanteiMoschkMockForSinkeiyaku.SYORIPTN = HanteiMoschkMockForSinkeiyaku.TESTPATTERN2;
        CheckTblMosSyouhin checkTblMosSyouhin = SWAKInjector.getInstance(CheckTblMosSyouhin.class);

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("860000470");
        List<BM_SyouhnZokusei> listTkSyouhnZokusei = new ArrayList<>();
        BM_SyouhnZokusei syouhnZokusei1 = new BM_SyouhnZokusei();
        syouhnZokusei1.setSyouhncd("ｱ1");
        syouhnZokusei1.setSyouhnsdno(1);

        syouhnZokusei1.setNkhknumu(C_UmuKbn.ARI);

        syouhnZokusei1.setSyouhnnm("商品名００１");

        BM_SyouhnZokusei syouhnZokusei2 = new BM_SyouhnZokusei();
        syouhnZokusei2.setSyouhncd("ｱ8");
        syouhnZokusei2.setSyouhnsdno(1);

        syouhnZokusei2.setSyouhnnm("商品名００２");

        BM_SyouhnZokusei syouhnZokusei3 = new BM_SyouhnZokusei();
        syouhnZokusei3.setSyouhncd("ｱ9");
        syouhnZokusei3.setSyouhnsdno(1);
        syouhnZokusei3.setSyouhnnm("商品名００３");

        listTkSyouhnZokusei.add(syouhnZokusei1);
        listTkSyouhnZokusei.add(syouhnZokusei2);
        listTkSyouhnZokusei.add(syouhnZokusei3);

        mosnaiCheckParam.setListTkSyouhnZokusei(listTkSyouhnZokusei);

        BM_SyouhnZokusei syouhnZokusei = new BM_SyouhnZokusei();
        syouhnZokusei.setSyouhncd("ﾕﾍ");
        syouhnZokusei.setSyouhnsdno(1);

        syouhnZokusei.setSyouhnnm("商品名０００");

        syouhnZokusei.setYoteirirituhendoukbn(C_YoteirirituhendouKbn.TUKI1KAI);

        syouhnZokusei.setNkhknumu(C_UmuKbn.ARI);
        mosnaiCheckParam.setSyuSyouhnZokusei(syouhnZokusei);

        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setSysKbn(C_SysKbn.ESHIEN);
        mosnaiCheckParam.setKokutiChkHuyoUmu(C_UmuKbn.NONE);
        mosnaiCheckParam.setSysDate(BizDate.valueOf(20160102));
        mosnaiCheckParam.setSekmossakuseiSousasyaKbn(C_SeihowebsousasyaKbn.SUPPORTDESK);
        mosnaiCheckParam.setKiteiCheckChannelCd(C_Channelcd.TIGIN);

        checkTblMosSyouhin.exec(mosnaiCheckParam);

        exClassificationEquals(mosnaiCheckParam.getSekmossakuseiErroutKbn(), C_SekmossakuseiErroutKbn.GAMEN, "設計書申込書作成エラー出力区分");
        exStringEquals(mosnaiCheckParam.getSekmossakuseiErrmsg1(), "", "設計書申込書作成エラーメッセージ１");
        exStringEquals(mosnaiCheckParam.getSekmossakuseiErrmsg2(), "終身年金は選択できません", "設計書申込書作成エラーメッセージ２");
        exClassificationEquals(mosnaiCheckParam.getKouzokuSyoriJikkouKbn(), C_KouzokujkKbn.NONE, "後続処理実行区分");
    }

    @Test
    @TestOrder(3630)
    @Transactional
    public void testExec_A84() {
        MockObjectManager.initialize();
        CheckSaiteiPMockForSinkeiyaku.SYORIPTN = CheckSaiteiPMockForSinkeiyaku.TESTPATTERN1;
        HanteiMoschkMockForSinkeiyaku.SYORIPTN = HanteiMoschkMockForSinkeiyaku.TESTPATTERN2;
        CheckTblMosSyouhin checkTblMosSyouhin = SWAKInjector.getInstance(CheckTblMosSyouhin.class);

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("860000488");
        List<BM_SyouhnZokusei> listTkSyouhnZokusei = new ArrayList<>();
        BM_SyouhnZokusei syouhnZokusei1 = new BM_SyouhnZokusei();
        syouhnZokusei1.setSyouhncd("ｱ1");
        syouhnZokusei1.setSyouhnsdno(1);

        syouhnZokusei1.setNkhknumu(C_UmuKbn.ARI);

        syouhnZokusei1.setSyouhnnm("商品名００１");

        BM_SyouhnZokusei syouhnZokusei2 = new BM_SyouhnZokusei();
        syouhnZokusei2.setSyouhncd("ｱ8");
        syouhnZokusei2.setSyouhnsdno(1);

        syouhnZokusei2.setSyouhnnm("商品名００２");

        BM_SyouhnZokusei syouhnZokusei3 = new BM_SyouhnZokusei();
        syouhnZokusei3.setSyouhncd("ｱ9");
        syouhnZokusei3.setSyouhnsdno(1);
        syouhnZokusei3.setSyouhnnm("商品名００３");

        listTkSyouhnZokusei.add(syouhnZokusei1);
        listTkSyouhnZokusei.add(syouhnZokusei2);
        listTkSyouhnZokusei.add(syouhnZokusei3);

        mosnaiCheckParam.setListTkSyouhnZokusei(listTkSyouhnZokusei);

        BM_SyouhnZokusei syouhnZokusei = new BM_SyouhnZokusei();
        syouhnZokusei.setSyouhncd("ﾕﾍ");
        syouhnZokusei.setSyouhnsdno(1);

        syouhnZokusei.setSyouhnnm("商品名０００");

        syouhnZokusei.setYoteirirituhendoukbn(C_YoteirirituhendouKbn.TUKI1KAI);

        syouhnZokusei.setNkhknumu(C_UmuKbn.ARI);
        mosnaiCheckParam.setSyuSyouhnZokusei(syouhnZokusei);

        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setSysKbn(C_SysKbn.ESHIEN);
        mosnaiCheckParam.setKokutiChkHuyoUmu(C_UmuKbn.NONE);
        mosnaiCheckParam.setSysDate(BizDate.valueOf(20160102));
        mosnaiCheckParam.setSekmossakuseiSousasyaKbn(C_SeihowebsousasyaKbn.SUPPORTDESK);
        mosnaiCheckParam.setKiteiCheckChannelCd(C_Channelcd.TIGIN);

        checkTblMosSyouhin.exec(mosnaiCheckParam);

        exClassificationEquals(mosnaiCheckParam.getSekmossakuseiErroutKbn(), C_SekmossakuseiErroutKbn.GAMEN, "設計書申込書作成エラー出力区分");
        exStringEquals(mosnaiCheckParam.getSekmossakuseiErrmsg1(), "", "設計書申込書作成エラーメッセージ１");
        exStringEquals(mosnaiCheckParam.getSekmossakuseiErrmsg2(), "終身年金は選択できません", "設計書申込書作成エラーメッセージ２");
        exClassificationEquals(mosnaiCheckParam.getKouzokuSyoriJikkouKbn(), C_KouzokujkKbn.NONE, "後続処理実行区分");
    }

    @Test
    @TestOrder(3640)
    @Transactional
    public void testExec_A85() {
        MockObjectManager.initialize();
        CheckSaiteiPMockForSinkeiyaku.SYORIPTN = CheckSaiteiPMockForSinkeiyaku.TESTPATTERN1;
        HanteiMoschkMockForSinkeiyaku.SYORIPTN = HanteiMoschkMockForSinkeiyaku.TESTPATTERN2;
        CheckTblMosSyouhin checkTblMosSyouhin = SWAKInjector.getInstance(CheckTblMosSyouhin.class);

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("860000504");
        List<BM_SyouhnZokusei> listTkSyouhnZokusei = new ArrayList<>();
        BM_SyouhnZokusei syouhnZokusei1 = new BM_SyouhnZokusei();
        syouhnZokusei1.setSyouhncd("ｱ1");
        syouhnZokusei1.setSyouhnsdno(1);

        syouhnZokusei1.setNkhknumu(C_UmuKbn.ARI);

        syouhnZokusei1.setSyouhnnm("商品名００１");

        BM_SyouhnZokusei syouhnZokusei2 = new BM_SyouhnZokusei();
        syouhnZokusei2.setSyouhncd("ｱ8");
        syouhnZokusei2.setSyouhnsdno(1);

        syouhnZokusei2.setSyouhnnm("商品名００２");

        BM_SyouhnZokusei syouhnZokusei3 = new BM_SyouhnZokusei();
        syouhnZokusei3.setSyouhncd("ｱ9");
        syouhnZokusei3.setSyouhnsdno(1);
        syouhnZokusei3.setSyouhnnm("商品名００３");

        listTkSyouhnZokusei.add(syouhnZokusei1);
        listTkSyouhnZokusei.add(syouhnZokusei2);
        listTkSyouhnZokusei.add(syouhnZokusei3);

        mosnaiCheckParam.setListTkSyouhnZokusei(listTkSyouhnZokusei);

        BM_SyouhnZokusei syouhnZokusei = new BM_SyouhnZokusei();
        syouhnZokusei.setSyouhncd("ﾕﾍ");
        syouhnZokusei.setSyouhnsdno(1);

        syouhnZokusei.setSyouhnnm("商品名０００");

        syouhnZokusei.setYoteirirituhendoukbn(C_YoteirirituhendouKbn.TUKI1KAI);

        syouhnZokusei.setNkhknumu(C_UmuKbn.ARI);
        mosnaiCheckParam.setSyuSyouhnZokusei(syouhnZokusei);

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
}