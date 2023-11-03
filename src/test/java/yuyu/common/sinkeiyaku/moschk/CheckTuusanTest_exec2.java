package yuyu.common.sinkeiyaku.moschk;

import static yuyu.testinfr.YuyuFunctionTestUtil.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.dgic.testing.common.virtualmock.MockObjectManager;
import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.number.BizNumber;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.app.base.ref.TestDataMaker;
import yuyu.app.base.ref.TestDataMakerException;
import yuyu.common.biz.bzcommon.KeisanGaikakanzan;
import yuyu.common.biz.bzcommon.KeisanGaikakanzanMockForSinkeiyaku;
import yuyu.common.biz.bzcommon.Tuusan;
import yuyu.common.biz.bzcommon.TuusanMockForSinkeiyaku;
import yuyu.common.biz.exception.CommonBizAppException;
import yuyu.common.hozen.khcommon.KeisanSP;
import yuyu.common.hozen.khcommon.KeisanSPMockForSinkeiyaku;
import yuyu.common.sinkeiyaku.skcommon.GetKiteiCheckYenkansangk;
import yuyu.common.sinkeiyaku.skcommon.GetKiteiCheckYenkansangkMockForSinkeiyaku;
import yuyu.def.biz.manager.BizDomManager;
import yuyu.def.classification.C_HubisyubetuKbn;
import yuyu.def.classification.C_KouzokujkKbn;
import yuyu.def.classification.C_SakuintsnKbn;
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
 * 通算チェッククラスのメソッド {@link CheckTuusan#exec(MosnaiCheckParam, Tuusan)} テスト用クラスです。<br />
 */

@RunWith(OrderedRunner.class)
public class CheckTuusanTest_exec2 {

    @Inject
    private CheckTuusan checkTuusan;

    @Inject
    private MosnaiCheckParam mosnaiCheckParam;

    @Inject
    private SinkeiyakuDomManager sinkeiyakuDomManager;

    @Inject
    private BizDomManager bizDomManager;

    private final static String fileName = "UT_SP_単体テスト仕様書_通算チェック";
    private final static String sheetName = "INデータ20201225";

    @Before
    public void before() {

        MockModuleBinder.bind(new AbstractModule() {
            @Override
            protected void configure() {
                bind(Tuusan.class).to(TuusanMockForSinkeiyaku.class);
                bind(CheckSaiteiP.class).to(CheckSaiteiPMockForSinkeiyaku.class);
                bind(KeisanSP.class).to(KeisanSPMockForSinkeiyaku.class);
                bind(KeisanGaikakanzan.class).to(KeisanGaikakanzanMockForSinkeiyaku.class);
                bind(GetKiteiCheckYenkansangk.class).to(GetKiteiCheckYenkansangkMockForSinkeiyaku.class);
            }
        });
    }

    @BeforeClass
    public static void testInit() {

        TuusanMockForSinkeiyaku.caller = CheckTuusanTest_exec2.class;
        CheckSaiteiPMockForSinkeiyaku.caller = CheckTuusanTest_exec2.class;
        KeisanSPMockForSinkeiyaku.caller = CheckTuusanTest_exec2.class;
        KeisanGaikakanzanMockForSinkeiyaku.caller = CheckTuusanTest_exec2.class;
        GetKiteiCheckYenkansangkMockForSinkeiyaku.caller = CheckTuusanTest_exec2.class;
        GetKiteiCheckYenkansangkMockForSinkeiyaku.LoopFlag = 0;
    }

    @BeforeClass
    @Transactional
    public static void insertTestData() {
        try {
            TestDataMaker testDataMaker = new TestDataMaker();
            HashMap<String, Map<String, List<Map<String, String>>>> testDataAndTblMap;
            testDataAndTblMap = testDataMaker.getInData(CheckTuusanTest_exec2.class, fileName, sheetName);
            testDataMaker.insDataByDataId("データ001", testDataAndTblMap);
        } catch (TestDataMakerException e) {
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
        bizDomManager.delete(bizDomManager.getAllChkTuusanS());
        bizDomManager.delete(bizDomManager.getAllChkNkgns());
        bizDomManager.delete(bizDomManager.getAllChkKykDairitenTuusanS());
        bizDomManager.delete(bizDomManager.getAllChkHrkPTani());
        bizDomManager.delete(bizDomManager.getAllKijyungkHanteiKawaseRate());
        bizDomManager.delete(bizDomManager.getAllChkSTani());
        bizDomManager.delete(bizDomManager.getAllChkSaiteiP());
        bizDomManager.delete(bizDomManager.getAllChkSTani());
        bizDomManager.delete(bizDomManager.getAllChkTuusanS());
        bizDomManager.delete(bizDomManager.getAllChkSaiteiS());
        bizDomManager.delete(bizDomManager.getAllChkKykDairitenTuusanS());
        bizDomManager.delete(bizDomManager.getAllKijyungkHanteiKawaseRate());
    }

    @AfterClass
    public static void testClear() {
        TuusanMockForSinkeiyaku.caller = CheckTuusanTest_exec2.class;
        TuusanMockForSinkeiyaku.SYORIPTN = null;
        CheckSaiteiPMockForSinkeiyaku.caller = CheckTuusanTest_exec2.class;
        CheckSaiteiPMockForSinkeiyaku.SYORIPTN = null;
        KeisanSPMockForSinkeiyaku.caller = CheckTuusanTest_exec2.class;
        KeisanSPMockForSinkeiyaku.SYORIPTN = null;
        CheckSaiteiPMockForSinkeiyaku.caller = CheckTuusanTest_exec2.class;
        KeisanSPMockForSinkeiyaku.SYORIPTN = null;
        MockObjectManager.initialize();
    }


    @Test
    @TestOrder(10)
    public void testExec_A1() {
        TuusanMockForSinkeiyaku.SYORIPTN = TuusanMockForSinkeiyaku.TESTPATTERN1;

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("791112238");
        List<HT_MosSyouhn> mosSyouhnLst = syoriCTL.getMosSyouhnsBySyutkkbn(C_SyutkKbn.SYU);

        HT_MosSyouhn mosSyouhn = mosSyouhnLst.get(0);
        BM_SyouhnZokusei syouhnZokusei =
            bizDomManager.getSyouhnZokusei(mosSyouhn.getSyouhncd(), mosSyouhn.getSyouhnsdno());
        mosnaiCheckParam.setSyuSyouhnZokusei(syouhnZokusei);

        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setSysKbn(C_SysKbn.ESHIEN);
        List<HT_HubiMsg> hubiMsgLst = syoriCTL.getHubiMsgs();
        mosnaiCheckParam.setListHubiMsg(hubiMsgLst);

        Tuusan tuusan = SWAKInjector.getInstance(Tuusan.class);

        checkTuusan.exec(mosnaiCheckParam, tuusan);

        exNumericEquals(hubiMsgLst.size(), 0, "不備メッセージテーブルエンティティリストの件数");
        exClassificationEquals(mosnaiCheckParam.getSekmossakuseiErroutKbn(), C_SekmossakuseiErroutKbn.GAMEN,
            "設計書申込書作成エラー出力区分");
        exStringEquals(mosnaiCheckParam.getSekmossakuseiErrmsg1(), "通算年金原資額が限度額を超えています", "設計書申込書作成エラーメッセージ１");
        exStringEquals(mosnaiCheckParam.getSekmossakuseiErrmsg2(), "保険料は０円までにしてください", "設計書申込書作成エラーメッセージ２");
        exClassificationEquals(mosnaiCheckParam.getKouzokuSyoriJikkouKbn(), C_KouzokujkKbn.NONE, "後続処理実行区分");
        exClassificationEquals(mosnaiCheckParam.getSakuinTsnKbn(), C_SakuintsnKbn.ERROR, "索引通算区分");
    }

    @Test
    @TestOrder(20)
    public void testExec_A2() {
        TuusanMockForSinkeiyaku.SYORIPTN = TuusanMockForSinkeiyaku.TESTPATTERN2;
        KeisanSPMockForSinkeiyaku.SYORIPTN = KeisanSPMockForSinkeiyaku.TESTPATTERN2;

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("860000025");
        List<HT_MosSyouhn> mosSyouhnLst = syoriCTL.getMosSyouhnsBySyutkkbn(C_SyutkKbn.SYU);

        HT_MosSyouhn mosSyouhn = mosSyouhnLst.get(0);
        BM_SyouhnZokusei syouhnZokusei =
            bizDomManager.getSyouhnZokusei(mosSyouhn.getSyouhncd(), mosSyouhn.getSyouhnsdno());
        mosnaiCheckParam.setSyuSyouhnZokusei(syouhnZokusei);

        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setSysKbn(C_SysKbn.ESHIEN);
        List<HT_HubiMsg> hubiMsgLst = syoriCTL.getHubiMsgs();
        mosnaiCheckParam.setListHubiMsg(hubiMsgLst);
        Tuusan tuusan = SWAKInjector.getInstance(Tuusan.class);

        checkTuusan.exec(mosnaiCheckParam, tuusan);

        exNumericEquals(hubiMsgLst.size(), 0, "不備メッセージテーブルエンティティリストの件数");
        exClassificationEquals(mosnaiCheckParam.getSekmossakuseiErroutKbn(), C_SekmossakuseiErroutKbn.GAMEN,
            "設計書申込書作成エラー出力区分");
        exStringEquals(mosnaiCheckParam.getSekmossakuseiErrmsg1(), "", "設計書申込書作成エラーメッセージ１");
        exStringEquals(mosnaiCheckParam.getSekmossakuseiErrmsg2(), "通算保険金額が限度額を超えています　ご加入できません", "設計書申込書作成エラーメッセージ２");
        exClassificationEquals(mosnaiCheckParam.getKouzokuSyoriJikkouKbn(), C_KouzokujkKbn.NONE, "後続処理実行区分");
        exClassificationEquals(mosnaiCheckParam.getSakuinTsnKbn(), C_SakuintsnKbn.ERROR, "索引通算区分");
    }

    @Test
    @TestOrder(30)
    public void testExec_A3() {
        TuusanMockForSinkeiyaku.SYORIPTN = TuusanMockForSinkeiyaku.TESTPATTERN3;
        KeisanSPMockForSinkeiyaku.SYORIPTN = KeisanSPMockForSinkeiyaku.TESTPATTERN3;

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("860000033");
        List<HT_MosSyouhn> mosSyouhnLst = syoriCTL.getMosSyouhnsBySyutkkbn(C_SyutkKbn.SYU);

        HT_MosSyouhn mosSyouhn = mosSyouhnLst.get(0);
        BM_SyouhnZokusei syouhnZokusei =
            bizDomManager.getSyouhnZokusei(mosSyouhn.getSyouhncd(), mosSyouhn.getSyouhnsdno());
        mosnaiCheckParam.setSyuSyouhnZokusei(syouhnZokusei);

        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setSysKbn(C_SysKbn.ESHIEN);
        List<HT_HubiMsg> hubiMsgLst = syoriCTL.getHubiMsgs();
        mosnaiCheckParam.setListHubiMsg(hubiMsgLst);
        Tuusan tuusan = SWAKInjector.getInstance(Tuusan.class);

        try {
            checkTuusan.exec(mosnaiCheckParam, tuusan);
        } catch (CommonBizAppException e) {
            exStringEquals(e.getMessage(), "システム整合性エラーです。Ｓ単位テーブルにデータが見つかりません。", "エラーメッセージ");
        }
    }

    @Test
    @TestOrder(40)
    public void testExec_A4() {
        TuusanMockForSinkeiyaku.SYORIPTN = TuusanMockForSinkeiyaku.TESTPATTERN3;
        KeisanSPMockForSinkeiyaku.SYORIPTN = KeisanSPMockForSinkeiyaku.TESTPATTERN3;

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("860000041");
        List<HT_MosSyouhn> mosSyouhnLst = syoriCTL.getMosSyouhnsBySyutkkbn(C_SyutkKbn.SYU);

        HT_MosSyouhn mosSyouhn = mosSyouhnLst.get(0);
        BM_SyouhnZokusei syouhnZokusei =
            bizDomManager.getSyouhnZokusei(mosSyouhn.getSyouhncd(), mosSyouhn.getSyouhnsdno());
        mosnaiCheckParam.setSyuSyouhnZokusei(syouhnZokusei);

        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setSysKbn(C_SysKbn.SKEI);
        mosnaiCheckParam.setTkrtkKinyuuknUmuKbn(C_UmuKbn.NONE);
        mosnaiCheckParam.setKydsskKinyuuknUmuKbn(C_UmuKbn.ARI);
        List<HT_HubiMsg> hubiMsgLst = syoriCTL.getHubiMsgs();
        mosnaiCheckParam.setListHubiMsg(hubiMsgLst);
        Tuusan tuusan = SWAKInjector.getInstance(Tuusan.class);
        checkTuusan.exec(mosnaiCheckParam, tuusan);

        exNumericEquals(hubiMsgLst.size(), 1, "不備メッセージテーブルエンティティリストの件数");
        exStringEquals(hubiMsgLst.get(0).getMosno(), "860000041", "申込番号");
        exNumericEquals(hubiMsgLst.get(0).getRenno(), 1, "連番");
        exStringEquals(hubiMsgLst.get(0).getHubimsg(), "【特認可能】年金原資限度額の１０円をオーバーしています。　年金原資　１００円", "不備メッセージ");
        exStringEquals(hubiMsgLst.get(0).getMessageId(), "THC1027", "メッセージＩＤ");
        exClassificationEquals(hubiMsgLst.get(0).getHubisyubetukbn(), C_HubisyubetuKbn.KETHORYU_HUBI, "不備種別区分");
        exClassificationEquals(mosnaiCheckParam.getSekmossakuseiErroutKbn(), C_SekmossakuseiErroutKbn.NONE,
            "設計書申込書作成エラー出力区分");
        exStringEquals(mosnaiCheckParam.getSekmossakuseiErrmsg1(), "", "設計書申込書作成エラーメッセージ１");
        exStringEquals(mosnaiCheckParam.getSekmossakuseiErrmsg2(), "", "設計書申込書作成エラーメッセージ２");
        exClassificationEquals(mosnaiCheckParam.getKouzokuSyoriJikkouKbn(), C_KouzokujkKbn.JIKKOU, "後続処理実行区分");
        exClassificationEquals(mosnaiCheckParam.getSakuinTsnKbn(), C_SakuintsnKbn.ERROR, "索引通算区分");
    }

    @Test
    @TestOrder(50)
    public void testExec_A5() {
        TuusanMockForSinkeiyaku.SYORIPTN = TuusanMockForSinkeiyaku.TESTPATTERN5;

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("860000058");
        List<HT_MosSyouhn> mosSyouhnLst = syoriCTL.getMosSyouhnsBySyutkkbn(C_SyutkKbn.SYU);

        HT_MosSyouhn mosSyouhn = mosSyouhnLst.get(0);
        BM_SyouhnZokusei syouhnZokusei =
            bizDomManager.getSyouhnZokusei(mosSyouhn.getSyouhncd(), mosSyouhn.getSyouhnsdno());
        mosnaiCheckParam.setSyuSyouhnZokusei(syouhnZokusei);

        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setSysKbn(C_SysKbn.SKEI);
        mosnaiCheckParam.setTkrtkKinyuuknUmuKbn(C_UmuKbn.ARI);
        mosnaiCheckParam.setKydsskKinyuuknUmuKbn(C_UmuKbn.NONE);
        List<HT_HubiMsg> hubiMsgLst = syoriCTL.getHubiMsgs();
        mosnaiCheckParam.setListHubiMsg(hubiMsgLst);
        Tuusan tuusan = SWAKInjector.getInstance(Tuusan.class);
        checkTuusan.exec(mosnaiCheckParam, tuusan);

        exNumericEquals(hubiMsgLst.size(), 1, "不備メッセージテーブルエンティティリストの件数");
        exStringEquals(hubiMsgLst.get(0).getMosno(), "860000058", "申込番号");
        exNumericEquals(hubiMsgLst.get(0).getRenno(), 1, "連番");
        exStringEquals(hubiMsgLst.get(0).getHubimsg(), "【特認可能】年金原資限度額の１０円をオーバーしています。　年金原資　１００円", "不備メッセージ");
        exStringEquals(hubiMsgLst.get(0).getMessageId(), "THC1027", "メッセージＩＤ");
        exClassificationEquals(hubiMsgLst.get(0).getHubisyubetukbn(), C_HubisyubetuKbn.KETHORYU_HUBI, "不備種別区分");
        exClassificationEquals(mosnaiCheckParam.getSekmossakuseiErroutKbn(), C_SekmossakuseiErroutKbn.NONE,
            "設計書申込書作成エラー出力区分");
        exStringEquals(mosnaiCheckParam.getSekmossakuseiErrmsg1(), "", "設計書申込書作成エラーメッセージ１");
        exStringEquals(mosnaiCheckParam.getSekmossakuseiErrmsg2(), "", "設計書申込書作成エラーメッセージ２");
        exClassificationEquals(mosnaiCheckParam.getKouzokuSyoriJikkouKbn(), C_KouzokujkKbn.JIKKOU, "後続処理実行区分");
        exClassificationEquals(mosnaiCheckParam.getSakuinTsnKbn(), C_SakuintsnKbn.ERROR, "索引通算区分");
    }

    @Test
    @TestOrder(60)
    public void testExec_A6() {
        TuusanMockForSinkeiyaku.SYORIPTN = TuusanMockForSinkeiyaku.TESTPATTERN6;

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("860000066");
        List<HT_MosSyouhn> mosSyouhnLst = syoriCTL.getMosSyouhnsBySyutkkbn(C_SyutkKbn.SYU);

        HT_MosSyouhn mosSyouhn = mosSyouhnLst.get(0);
        BM_SyouhnZokusei syouhnZokusei =
            bizDomManager.getSyouhnZokusei(mosSyouhn.getSyouhncd(), mosSyouhn.getSyouhnsdno());
        mosnaiCheckParam.setSyuSyouhnZokusei(syouhnZokusei);

        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setSysKbn(C_SysKbn.SKEI);
        mosnaiCheckParam.setTkrtkKinyuuknUmuKbn(C_UmuKbn.NONE);
        mosnaiCheckParam.setKydsskKinyuuknUmuKbn(C_UmuKbn.NONE);
        mosnaiCheckParam.setSakuinTsnKbn(C_SakuintsnKbn.SEIJYOU);
        List<HT_HubiMsg> hubiMsgLst = syoriCTL.getHubiMsgs();
        mosnaiCheckParam.setListHubiMsg(hubiMsgLst);
        Tuusan tuusan = SWAKInjector.getInstance(Tuusan.class);
        checkTuusan.exec(mosnaiCheckParam, tuusan);

        exNumericEquals(hubiMsgLst.size(), 1, "不備メッセージテーブルエンティティリストの件数");
        exStringEquals(hubiMsgLst.get(0).getMosno(), "860000066", "申込番号");
        exNumericEquals(hubiMsgLst.get(0).getRenno(), 1, "連番");
        exStringEquals(hubiMsgLst.get(0).getHubimsg(), "【特認可能】通算２年未経過総死亡Ｓ限度額の１０１円をオーバーしています。　保険金額は１２３円までにしてください。", "不備メッセージ");
        exStringEquals(hubiMsgLst.get(0).getMessageId(), "THC1045", "メッセージＩＤ");
        exClassificationEquals(hubiMsgLst.get(0).getHubisyubetukbn(), C_HubisyubetuKbn.KETHORYU_HUBI, "不備種別区分");
        exClassificationEquals(mosnaiCheckParam.getSekmossakuseiErroutKbn(), C_SekmossakuseiErroutKbn.NONE,
            "設計書申込書作成エラー出力区分");
        exStringEquals(mosnaiCheckParam.getSekmossakuseiErrmsg1(), "", "設計書申込書作成エラーメッセージ１");
        exStringEquals(mosnaiCheckParam.getSekmossakuseiErrmsg2(), "", "設計書申込書作成エラーメッセージ２");
        exClassificationEquals(mosnaiCheckParam.getKouzokuSyoriJikkouKbn(), C_KouzokujkKbn.JIKKOU, "後続処理実行区分");
        exClassificationEquals(mosnaiCheckParam.getSakuinTsnKbn(), C_SakuintsnKbn.ERROR, "索引通算区分");
    }

    @Test
    @TestOrder(70)
    public void testExec_A7() {
        TuusanMockForSinkeiyaku.SYORIPTN = TuusanMockForSinkeiyaku.TESTPATTERN7;
        KeisanSPMockForSinkeiyaku.SYORIPTN = KeisanSPMockForSinkeiyaku.TESTPATTERN7;

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("860000074");
        List<HT_MosSyouhn> mosSyouhnLst = syoriCTL.getMosSyouhnsBySyutkkbn(C_SyutkKbn.SYU);

        HT_MosSyouhn mosSyouhn = mosSyouhnLst.get(0);
        BM_SyouhnZokusei syouhnZokusei =
            bizDomManager.getSyouhnZokusei(mosSyouhn.getSyouhncd(), mosSyouhn.getSyouhnsdno());
        mosnaiCheckParam.setSyuSyouhnZokusei(syouhnZokusei);

        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setSysKbn(C_SysKbn.SKEI);
        List<HT_HubiMsg> hubiMsgLst = syoriCTL.getHubiMsgs();
        mosnaiCheckParam.setListHubiMsg(hubiMsgLst);
        Tuusan tuusan = SWAKInjector.getInstance(Tuusan.class);

        checkTuusan.exec(mosnaiCheckParam, tuusan);

        exNumericEquals(hubiMsgLst.size(), 1, "不備メッセージテーブルエンティティリストの件数");
        exStringEquals(hubiMsgLst.get(0).getMosno(), "860000074", "申込番号");
        exNumericEquals(hubiMsgLst.get(0).getRenno(), 1, "連番");
        exStringEquals(hubiMsgLst.get(0).getHubimsg(), "【特認可能】ふるはーとＦⅡ通算Ｓ限度額の５０円をオーバーしています。　保険料は０円までにしてください。", "不備メッセージ");
        exStringEquals(hubiMsgLst.get(0).getMessageId(), "THC1168", "メッセージＩＤ");
        exClassificationEquals(hubiMsgLst.get(0).getHubisyubetukbn(), C_HubisyubetuKbn.KETHORYU_HUBI, "不備種別区分");
        exClassificationEquals(mosnaiCheckParam.getSekmossakuseiErroutKbn(), C_SekmossakuseiErroutKbn.NONE,
            "設計書申込書作成エラー出力区分");
        exStringEquals(mosnaiCheckParam.getSekmossakuseiErrmsg1(), "", "設計書申込書作成エラーメッセージ１");
        exStringEquals(mosnaiCheckParam.getSekmossakuseiErrmsg2(), "", "設計書申込書作成エラーメッセージ２");
        exClassificationEquals(mosnaiCheckParam.getKouzokuSyoriJikkouKbn(), C_KouzokujkKbn.JIKKOU, "後続処理実行区分");
        exClassificationEquals(mosnaiCheckParam.getSakuinTsnKbn(), C_SakuintsnKbn.ERROR, "索引通算区分");
    }

    @Test
    @TestOrder(80)
    public void testExec_A8() {
        TuusanMockForSinkeiyaku.SYORIPTN = TuusanMockForSinkeiyaku.TESTPATTERN8;
        KeisanSPMockForSinkeiyaku.SYORIPTN = KeisanSPMockForSinkeiyaku.TESTPATTERN8;

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("860000082");
        List<HT_MosSyouhn> mosSyouhnLst = syoriCTL.getMosSyouhnsBySyutkkbn(C_SyutkKbn.SYU);

        HT_MosSyouhn mosSyouhn = mosSyouhnLst.get(0);
        BM_SyouhnZokusei syouhnZokusei =
            bizDomManager.getSyouhnZokusei(mosSyouhn.getSyouhncd(), mosSyouhn.getSyouhnsdno());
        mosnaiCheckParam.setSyuSyouhnZokusei(syouhnZokusei);

        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setSysKbn(C_SysKbn.SKEI);
        List<HT_HubiMsg> hubiMsgLst = syoriCTL.getHubiMsgs();
        mosnaiCheckParam.setListHubiMsg(hubiMsgLst);
        Tuusan tuusan = SWAKInjector.getInstance(Tuusan.class);

        checkTuusan.exec(mosnaiCheckParam, tuusan);

        exNumericEquals(hubiMsgLst.size(), 1, "不備メッセージテーブルエンティティリストの件数");
        exStringEquals(hubiMsgLst.get(0).getMosno(), "860000082", "申込番号");
        exNumericEquals(hubiMsgLst.get(0).getRenno(), 1, "連番");
        exStringEquals(hubiMsgLst.get(0).getHubimsg(), "【特認可能】ふるはーとＦⅡ通算Ｓ限度額の５０円をオーバーしています。　保険料は０円までにしてください。", "不備メッセージ");
        exStringEquals(hubiMsgLst.get(0).getMessageId(), "THC1168", "メッセージＩＤ");
        exClassificationEquals(hubiMsgLst.get(0).getHubisyubetukbn(), C_HubisyubetuKbn.KETHORYU_HUBI, "不備種別区分");
        exClassificationEquals(mosnaiCheckParam.getSekmossakuseiErroutKbn(), C_SekmossakuseiErroutKbn.NONE,
            "設計書申込書作成エラー出力区分");
        exStringEquals(mosnaiCheckParam.getSekmossakuseiErrmsg1(), "", "設計書申込書作成エラーメッセージ１");
        exStringEquals(mosnaiCheckParam.getSekmossakuseiErrmsg2(), "", "設計書申込書作成エラーメッセージ２");
        exClassificationEquals(mosnaiCheckParam.getKouzokuSyoriJikkouKbn(), C_KouzokujkKbn.JIKKOU, "後続処理実行区分");
        exClassificationEquals(mosnaiCheckParam.getSakuinTsnKbn(), C_SakuintsnKbn.ERROR, "索引通算区分");
    }

    @Test
    @TestOrder(90)
    public void testExec_A9() {
        TuusanMockForSinkeiyaku.SYORIPTN = TuusanMockForSinkeiyaku.TESTPATTERN9;
        CheckSaiteiPMockForSinkeiyaku.SYORIPTN = CheckSaiteiPMockForSinkeiyaku.TESTPATTERN9;
        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("860000090");
        List<HT_MosSyouhn> mosSyouhnLst = syoriCTL.getMosSyouhnsBySyutkkbn(C_SyutkKbn.SYU);

        HT_MosSyouhn mosSyouhn = mosSyouhnLst.get(0);
        BM_SyouhnZokusei syouhnZokusei =
            bizDomManager.getSyouhnZokusei(mosSyouhn.getSyouhncd(), mosSyouhn.getSyouhnsdno());
        mosnaiCheckParam.setSyuSyouhnZokusei(syouhnZokusei);

        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setSysKbn(C_SysKbn.SKEI);

        mosnaiCheckParam.setPdateSRate(BizNumber.valueOf(7));
        mosnaiCheckParam.setHrbtJyousu(BizNumber.valueOf(5));
        mosnaiCheckParam.setNyuukinKawaseRate(BizNumber.valueOf(15));
        List<HT_HubiMsg> hubiMsgLst = syoriCTL.getHubiMsgs();
        mosnaiCheckParam.setListHubiMsg(hubiMsgLst);
        Tuusan tuusan = SWAKInjector.getInstance(Tuusan.class);

        checkTuusan.exec(mosnaiCheckParam, tuusan);

        exNumericEquals(hubiMsgLst.size(), 1, "不備メッセージテーブルエンティティリストの件数");
        exStringEquals(hubiMsgLst.get(0).getMosno(), "860000090", "申込番号");
        exNumericEquals(hubiMsgLst.get(0).getRenno(), 1, "連番");
        exStringEquals(hubiMsgLst.get(0).getHubimsg(), "【特認可能】ふるはーとＦⅡ通算Ｓ限度額の５０円をオーバーしています。　ご加入できません。", "不備メッセージ");
        exStringEquals(hubiMsgLst.get(0).getMessageId(), "THC1167", "メッセージＩＤ");
        exClassificationEquals(hubiMsgLst.get(0).getHubisyubetukbn(), C_HubisyubetuKbn.KETHORYU_HUBI, "不備種別区分");
        exClassificationEquals(mosnaiCheckParam.getSekmossakuseiErroutKbn(), C_SekmossakuseiErroutKbn.NONE,
            "設計書申込書作成エラー出力区分");
        exStringEquals(mosnaiCheckParam.getSekmossakuseiErrmsg1(), "", "設計書申込書作成エラーメッセージ１");
        exStringEquals(mosnaiCheckParam.getSekmossakuseiErrmsg2(), "", "設計書申込書作成エラーメッセージ２");
        exClassificationEquals(mosnaiCheckParam.getKouzokuSyoriJikkouKbn(), C_KouzokujkKbn.JIKKOU, "後続処理実行区分");
        exClassificationEquals(mosnaiCheckParam.getSakuinTsnKbn(), C_SakuintsnKbn.ERROR, "索引通算区分");
    }

    @Test
    @TestOrder(100)
    public void testExec_A10() {
        TuusanMockForSinkeiyaku.SYORIPTN = TuusanMockForSinkeiyaku.TESTPATTERN9;
        CheckSaiteiPMockForSinkeiyaku.SYORIPTN = CheckSaiteiPMockForSinkeiyaku.TESTPATTERN10;
        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("860000108");
        List<HT_MosSyouhn> mosSyouhnLst = syoriCTL.getMosSyouhnsBySyutkkbn(C_SyutkKbn.SYU);

        HT_MosSyouhn mosSyouhn = mosSyouhnLst.get(0);
        BM_SyouhnZokusei syouhnZokusei =
            bizDomManager.getSyouhnZokusei(mosSyouhn.getSyouhncd(), mosSyouhn.getSyouhnsdno());
        mosnaiCheckParam.setSyuSyouhnZokusei(syouhnZokusei);

        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setSysKbn(C_SysKbn.SKEI);

        mosnaiCheckParam.setPdateSRate(BizNumber.valueOf(7));
        mosnaiCheckParam.setHrbtJyousu(BizNumber.valueOf(5));
        mosnaiCheckParam.setNyuukinKawaseRate(BizNumber.valueOf(15));
        List<HT_HubiMsg> hubiMsgLst = syoriCTL.getHubiMsgs();
        mosnaiCheckParam.setListHubiMsg(hubiMsgLst);
        Tuusan tuusan = SWAKInjector.getInstance(Tuusan.class);

        checkTuusan.exec(mosnaiCheckParam, tuusan);

        exNumericEquals(hubiMsgLst.size(), 1, "不備メッセージテーブルエンティティリストの件数");
        exStringEquals(hubiMsgLst.get(0).getMosno(), "860000108", "申込番号");
        exNumericEquals(hubiMsgLst.get(0).getRenno(), 1, "連番");
        exStringEquals(hubiMsgLst.get(0).getHubimsg(), "【特認可能】ふるはーとＦⅡ通算Ｓ限度額の５０円をオーバーしています。　保険料は２３円までにしてください。", "不備メッセージ");
        exStringEquals(hubiMsgLst.get(0).getMessageId(), "THC1168", "メッセージＩＤ");
        exClassificationEquals(hubiMsgLst.get(0).getHubisyubetukbn(), C_HubisyubetuKbn.KETHORYU_HUBI, "不備種別区分");
        exClassificationEquals(mosnaiCheckParam.getSekmossakuseiErroutKbn(), C_SekmossakuseiErroutKbn.NONE,
            "設計書申込書作成エラー出力区分");
        exStringEquals(mosnaiCheckParam.getSekmossakuseiErrmsg1(), "", "設計書申込書作成エラーメッセージ１");
        exStringEquals(mosnaiCheckParam.getSekmossakuseiErrmsg2(), "", "設計書申込書作成エラーメッセージ２");
        exClassificationEquals(mosnaiCheckParam.getKouzokuSyoriJikkouKbn(), C_KouzokujkKbn.JIKKOU, "後続処理実行区分");
        exClassificationEquals(mosnaiCheckParam.getSakuinTsnKbn(), C_SakuintsnKbn.ERROR, "索引通算区分");
    }

    @Test
    @TestOrder(110)
    public void testExec_A11() {
        TuusanMockForSinkeiyaku.SYORIPTN = TuusanMockForSinkeiyaku.TESTPATTERN9;
        CheckSaiteiPMockForSinkeiyaku.SYORIPTN = CheckSaiteiPMockForSinkeiyaku.TESTPATTERN14;
        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("860000116");
        List<HT_MosSyouhn> mosSyouhnLst = syoriCTL.getMosSyouhnsBySyutkkbn(C_SyutkKbn.SYU);

        HT_MosSyouhn mosSyouhn = mosSyouhnLst.get(0);
        BM_SyouhnZokusei syouhnZokusei =
            bizDomManager.getSyouhnZokusei(mosSyouhn.getSyouhncd(), mosSyouhn.getSyouhnsdno());
        mosnaiCheckParam.setSyuSyouhnZokusei(syouhnZokusei);

        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setSysKbn(C_SysKbn.SKEI);

        mosnaiCheckParam.setPdateSRate(BizNumber.valueOf(7));
        mosnaiCheckParam.setHrbtJyousu(BizNumber.valueOf(5));
        mosnaiCheckParam.setNyuukinKawaseRate(BizNumber.valueOf(15));
        List<HT_HubiMsg> hubiMsgLst = syoriCTL.getHubiMsgs();
        mosnaiCheckParam.setListHubiMsg(hubiMsgLst);
        Tuusan tuusan = SWAKInjector.getInstance(Tuusan.class);

        checkTuusan.exec(mosnaiCheckParam, tuusan);
        exNumericEquals(hubiMsgLst.size(), 1, "不備メッセージテーブルエンティティリストの件数");
        exStringEquals(hubiMsgLst.get(0).getMosno(), "860000116", "申込番号");
        exNumericEquals(hubiMsgLst.get(0).getRenno(), 1, "連番");
        exStringEquals(hubiMsgLst.get(0).getHubimsg(), "【特認可能】ふるはーとＦⅡ通算Ｓ限度額の５０円をオーバーしています。　ご加入できません。", "不備メッセージ");
        exStringEquals(hubiMsgLst.get(0).getMessageId(), "THC1167", "メッセージＩＤ");
        exClassificationEquals(hubiMsgLst.get(0).getHubisyubetukbn(), C_HubisyubetuKbn.KETHORYU_HUBI, "不備種別区分");
        exClassificationEquals(mosnaiCheckParam.getSekmossakuseiErroutKbn(), C_SekmossakuseiErroutKbn.NONE,
            "設計書申込書作成エラー出力区分");
        exStringEquals(mosnaiCheckParam.getSekmossakuseiErrmsg1(), "", "設計書申込書作成エラーメッセージ１");
        exStringEquals(mosnaiCheckParam.getSekmossakuseiErrmsg2(), "", "設計書申込書作成エラーメッセージ２");
        exClassificationEquals(mosnaiCheckParam.getKouzokuSyoriJikkouKbn(), C_KouzokujkKbn.JIKKOU, "後続処理実行区分");
        exClassificationEquals(mosnaiCheckParam.getSakuinTsnKbn(), C_SakuintsnKbn.ERROR, "索引通算区分");
    }

    @Test
    @TestOrder(120)
    public void testExec_A12() {
        TuusanMockForSinkeiyaku.SYORIPTN = TuusanMockForSinkeiyaku.TESTPATTERN9;
        CheckSaiteiPMockForSinkeiyaku.SYORIPTN = CheckSaiteiPMockForSinkeiyaku.TESTPATTERN12;
        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("860000124");
        List<HT_MosSyouhn> mosSyouhnLst = syoriCTL.getMosSyouhnsBySyutkkbn(C_SyutkKbn.SYU);

        HT_MosSyouhn mosSyouhn = mosSyouhnLst.get(0);
        BM_SyouhnZokusei syouhnZokusei =
            bizDomManager.getSyouhnZokusei(mosSyouhn.getSyouhncd(), mosSyouhn.getSyouhnsdno());
        mosnaiCheckParam.setSyuSyouhnZokusei(syouhnZokusei);

        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setSysKbn(C_SysKbn.SKEI);

        mosnaiCheckParam.setPdateSRate(BizNumber.valueOf(7));
        mosnaiCheckParam.setHrbtJyousu(BizNumber.valueOf(5));
        mosnaiCheckParam.setNyuukinKawaseRate(BizNumber.valueOf(15));
        List<HT_HubiMsg> hubiMsgLst = syoriCTL.getHubiMsgs();
        mosnaiCheckParam.setListHubiMsg(hubiMsgLst);
        Tuusan tuusan = SWAKInjector.getInstance(Tuusan.class);

        checkTuusan.exec(mosnaiCheckParam, tuusan);

        exNumericEquals(hubiMsgLst.size(), 1, "不備メッセージテーブルエンティティリストの件数");
        exStringEquals(hubiMsgLst.get(0).getMosno(), "860000124", "申込番号");
        exNumericEquals(hubiMsgLst.get(0).getRenno(), 1, "連番");
        exStringEquals(hubiMsgLst.get(0).getHubimsg(), "【特認可能】ふるはーとＦⅡ通算Ｓ限度額の５０円をオーバーしています。　ご加入できません。", "不備メッセージ");
        exStringEquals(hubiMsgLst.get(0).getMessageId(), "THC1167", "メッセージＩＤ");
        exClassificationEquals(hubiMsgLst.get(0).getHubisyubetukbn(), C_HubisyubetuKbn.KETHORYU_HUBI, "不備種別区分");
        exClassificationEquals(mosnaiCheckParam.getSekmossakuseiErroutKbn(), C_SekmossakuseiErroutKbn.NONE,
            "設計書申込書作成エラー出力区分");
        exStringEquals(mosnaiCheckParam.getSekmossakuseiErrmsg1(), "", "設計書申込書作成エラーメッセージ１");
        exStringEquals(mosnaiCheckParam.getSekmossakuseiErrmsg2(), "", "設計書申込書作成エラーメッセージ２");
        exClassificationEquals(mosnaiCheckParam.getKouzokuSyoriJikkouKbn(), C_KouzokujkKbn.JIKKOU, "後続処理実行区分");
        exClassificationEquals(mosnaiCheckParam.getSakuinTsnKbn(), C_SakuintsnKbn.ERROR, "索引通算区分");
    }

    @Test
    @TestOrder(130)
    public void testExec_A13() {
        TuusanMockForSinkeiyaku.SYORIPTN = TuusanMockForSinkeiyaku.TESTPATTERN9;
        CheckSaiteiPMockForSinkeiyaku.SYORIPTN = CheckSaiteiPMockForSinkeiyaku.TESTPATTERN13;
        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("860000132");
        List<HT_MosSyouhn> mosSyouhnLst = syoriCTL.getMosSyouhnsBySyutkkbn(C_SyutkKbn.SYU);

        HT_MosSyouhn mosSyouhn = mosSyouhnLst.get(0);
        BM_SyouhnZokusei syouhnZokusei =
            bizDomManager.getSyouhnZokusei(mosSyouhn.getSyouhncd(), mosSyouhn.getSyouhnsdno());
        mosnaiCheckParam.setSyuSyouhnZokusei(syouhnZokusei);

        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setSysKbn(C_SysKbn.SKEI);

        mosnaiCheckParam.setPdateSRate(BizNumber.valueOf(7));
        mosnaiCheckParam.setHrbtJyousu(BizNumber.valueOf(5));
        mosnaiCheckParam.setNyuukinKawaseRate(BizNumber.valueOf(15));
        List<HT_HubiMsg> hubiMsgLst = syoriCTL.getHubiMsgs();
        mosnaiCheckParam.setListHubiMsg(hubiMsgLst);
        Tuusan tuusan = SWAKInjector.getInstance(Tuusan.class);

        checkTuusan.exec(mosnaiCheckParam, tuusan);

        exNumericEquals(hubiMsgLst.size(), 1, "不備メッセージテーブルエンティティリストの件数");
        exStringEquals(hubiMsgLst.get(0).getMosno(), "860000132", "申込番号");
        exNumericEquals(hubiMsgLst.get(0).getRenno(), 1, "連番");
        exStringEquals(hubiMsgLst.get(0).getHubimsg(), "【特認可能】ふるはーとＦⅡ通算Ｓ限度額の５０円をオーバーしています。　ご加入できません。", "不備メッセージ");
        exStringEquals(hubiMsgLst.get(0).getMessageId(), "THC1167", "メッセージＩＤ");
        exClassificationEquals(hubiMsgLst.get(0).getHubisyubetukbn(), C_HubisyubetuKbn.KETHORYU_HUBI, "不備種別区分");
        exClassificationEquals(mosnaiCheckParam.getSekmossakuseiErroutKbn(), C_SekmossakuseiErroutKbn.NONE,
            "設計書申込書作成エラー出力区分");
        exStringEquals(mosnaiCheckParam.getSekmossakuseiErrmsg1(), "", "設計書申込書作成エラーメッセージ１");
        exStringEquals(mosnaiCheckParam.getSekmossakuseiErrmsg2(), "", "設計書申込書作成エラーメッセージ２");
        exClassificationEquals(mosnaiCheckParam.getKouzokuSyoriJikkouKbn(), C_KouzokujkKbn.JIKKOU, "後続処理実行区分");
        exClassificationEquals(mosnaiCheckParam.getSakuinTsnKbn(), C_SakuintsnKbn.ERROR, "索引通算区分");
    }

    @Test
    @TestOrder(140)
    public void testExec_A14() {
        TuusanMockForSinkeiyaku.SYORIPTN = TuusanMockForSinkeiyaku.TESTPATTERN14;

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("860000140");
        List<HT_MosSyouhn> mosSyouhnLst = syoriCTL.getMosSyouhnsBySyutkkbn(C_SyutkKbn.SYU);

        HT_MosSyouhn mosSyouhn = mosSyouhnLst.get(0);
        BM_SyouhnZokusei syouhnZokusei =
            bizDomManager.getSyouhnZokusei(mosSyouhn.getSyouhncd(), mosSyouhn.getSyouhnsdno());
        mosnaiCheckParam.setSyuSyouhnZokusei(syouhnZokusei);

        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setSysKbn(C_SysKbn.SKEI);
        List<HT_HubiMsg> hubiMsgLst = syoriCTL.getHubiMsgs();
        mosnaiCheckParam.setListHubiMsg(hubiMsgLst);
        Tuusan tuusan = SWAKInjector.getInstance(Tuusan.class);

        checkTuusan.exec(mosnaiCheckParam, tuusan);

        exNumericEquals(hubiMsgLst.size(), 1, "不備メッセージテーブルエンティティリストの件数");
        exStringEquals(hubiMsgLst.get(0).getMosno(), "860000140", "申込番号");
        exNumericEquals(hubiMsgLst.get(0).getRenno(), 1, "連番");
        exStringEquals(hubiMsgLst.get(0).getHubimsg(), "【特認可能】ふるはーとＦⅡ通算Ｓ限度額の５０円をオーバーしています。　ご加入できません。", "不備メッセージ");
        exStringEquals(hubiMsgLst.get(0).getMessageId(), "THC1167", "メッセージＩＤ");
        exClassificationEquals(hubiMsgLst.get(0).getHubisyubetukbn(), C_HubisyubetuKbn.KETHORYU_HUBI, "不備種別区分");
        exClassificationEquals(mosnaiCheckParam.getSekmossakuseiErroutKbn(), C_SekmossakuseiErroutKbn.NONE,
            "設計書申込書作成エラー出力区分");
        exStringEquals(mosnaiCheckParam.getSekmossakuseiErrmsg1(), "", "設計書申込書作成エラーメッセージ１");
        exStringEquals(mosnaiCheckParam.getSekmossakuseiErrmsg2(), "", "設計書申込書作成エラーメッセージ２");
        exClassificationEquals(mosnaiCheckParam.getKouzokuSyoriJikkouKbn(), C_KouzokujkKbn.JIKKOU, "後続処理実行区分");
        exClassificationEquals(mosnaiCheckParam.getSakuinTsnKbn(), C_SakuintsnKbn.ERROR, "索引通算区分");
    }

    @Test
    @TestOrder(150)
    public void testExec_A15() {
        TuusanMockForSinkeiyaku.SYORIPTN = TuusanMockForSinkeiyaku.TESTPATTERN15;

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("860000157");
        List<HT_MosSyouhn> mosSyouhnLst = syoriCTL.getMosSyouhnsBySyutkkbn(C_SyutkKbn.SYU);

        HT_MosSyouhn mosSyouhn = mosSyouhnLst.get(0);
        BM_SyouhnZokusei syouhnZokusei =
            bizDomManager.getSyouhnZokusei(mosSyouhn.getSyouhncd(), mosSyouhn.getSyouhnsdno());
        mosnaiCheckParam.setSyuSyouhnZokusei(syouhnZokusei);

        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setSysKbn(C_SysKbn.SKEI);
        List<HT_HubiMsg> hubiMsgLst = syoriCTL.getHubiMsgs();
        mosnaiCheckParam.setListHubiMsg(hubiMsgLst);
        Tuusan tuusan = SWAKInjector.getInstance(Tuusan.class);

        checkTuusan.exec(mosnaiCheckParam, tuusan);

        exNumericEquals(hubiMsgLst.size(), 1, "不備メッセージテーブルエンティティリストの件数");
        exStringEquals(hubiMsgLst.get(0).getMosno(), "860000157", "申込番号");
        exNumericEquals(hubiMsgLst.get(0).getRenno(), 1, "連番");
        exStringEquals(hubiMsgLst.get(0).getHubimsg(), "【特認可能】ふるはーとＦⅡ通算Ｓ限度額の５０円をオーバーしています。　保険金額は４０円までにしてください。", "不備メッセージ");
        exStringEquals(hubiMsgLst.get(0).getMessageId(), "THC1168", "メッセージＩＤ");
        exClassificationEquals(hubiMsgLst.get(0).getHubisyubetukbn(), C_HubisyubetuKbn.KETHORYU_HUBI, "不備種別区分");
        exClassificationEquals(mosnaiCheckParam.getSekmossakuseiErroutKbn(), C_SekmossakuseiErroutKbn.NONE,
            "設計書申込書作成エラー出力区分");
        exStringEquals(mosnaiCheckParam.getSekmossakuseiErrmsg1(), "", "設計書申込書作成エラーメッセージ１");
        exStringEquals(mosnaiCheckParam.getSekmossakuseiErrmsg2(), "", "設計書申込書作成エラーメッセージ２");
        exClassificationEquals(mosnaiCheckParam.getKouzokuSyoriJikkouKbn(), C_KouzokujkKbn.JIKKOU, "後続処理実行区分");
        exClassificationEquals(mosnaiCheckParam.getSakuinTsnKbn(), C_SakuintsnKbn.ERROR, "索引通算区分");
    }

    @Test
    @TestOrder(160)
    public void testExec_A16() {
        TuusanMockForSinkeiyaku.SYORIPTN = TuusanMockForSinkeiyaku.TESTPATTERN16;

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("860000165");
        List<HT_MosSyouhn> mosSyouhnLst = syoriCTL.getMosSyouhnsBySyutkkbn(C_SyutkKbn.SYU);

        HT_MosSyouhn mosSyouhn = mosSyouhnLst.get(0);
        BM_SyouhnZokusei syouhnZokusei =
            bizDomManager.getSyouhnZokusei(mosSyouhn.getSyouhncd(), mosSyouhn.getSyouhnsdno());
        mosnaiCheckParam.setSyuSyouhnZokusei(syouhnZokusei);

        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setSysKbn(C_SysKbn.SKEI);
        List<HT_HubiMsg> hubiMsgLst = syoriCTL.getHubiMsgs();
        mosnaiCheckParam.setListHubiMsg(hubiMsgLst);
        Tuusan tuusan = SWAKInjector.getInstance(Tuusan.class);

        checkTuusan.exec(mosnaiCheckParam, tuusan);

        exNumericEquals(hubiMsgLst.size(), 1, "不備メッセージテーブルエンティティリストの件数");
        exStringEquals(hubiMsgLst.get(0).getMosno(), "860000165", "申込番号");
        exNumericEquals(hubiMsgLst.get(0).getRenno(), 1, "連番");
        exStringEquals(hubiMsgLst.get(0).getHubimsg(), "【特認可能】ふるはーとＦⅡ通算Ｓ限度額の５０円をオーバーしています。　保険金額は４０円までにしてください。", "不備メッセージ");
        exStringEquals(hubiMsgLst.get(0).getMessageId(), "THC1168", "メッセージＩＤ");
        exClassificationEquals(hubiMsgLst.get(0).getHubisyubetukbn(), C_HubisyubetuKbn.KETHORYU_HUBI, "不備種別区分");
        exClassificationEquals(mosnaiCheckParam.getSekmossakuseiErroutKbn(), C_SekmossakuseiErroutKbn.NONE,
            "設計書申込書作成エラー出力区分");
        exStringEquals(mosnaiCheckParam.getSekmossakuseiErrmsg1(), "", "設計書申込書作成エラーメッセージ１");
        exStringEquals(mosnaiCheckParam.getSekmossakuseiErrmsg2(), "", "設計書申込書作成エラーメッセージ２");
        exClassificationEquals(mosnaiCheckParam.getKouzokuSyoriJikkouKbn(), C_KouzokujkKbn.JIKKOU, "後続処理実行区分");
        exClassificationEquals(mosnaiCheckParam.getSakuinTsnKbn(), C_SakuintsnKbn.ERROR, "索引通算区分");
    }

    @Test
    @TestOrder(170)
    public void testExec_A17() {
        TuusanMockForSinkeiyaku.SYORIPTN = TuusanMockForSinkeiyaku.TESTPATTERN17;

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("860000173");
        List<HT_MosSyouhn> mosSyouhnLst = syoriCTL.getMosSyouhnsBySyutkkbn(C_SyutkKbn.SYU);

        HT_MosSyouhn mosSyouhn = mosSyouhnLst.get(0);
        BM_SyouhnZokusei syouhnZokusei =
            bizDomManager.getSyouhnZokusei(mosSyouhn.getSyouhncd(), mosSyouhn.getSyouhnsdno());
        mosnaiCheckParam.setSyuSyouhnZokusei(syouhnZokusei);

        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setSysKbn(C_SysKbn.SKEI);
        mosnaiCheckParam.setTkrtkKinyuuknUmuKbn(C_UmuKbn.NONE);
        mosnaiCheckParam.setKydsskKinyuuknUmuKbn(C_UmuKbn.NONE);
        mosnaiCheckParam.setSakuinTsnKbn(C_SakuintsnKbn.SEIJYOU);
        List<HT_HubiMsg> hubiMsgLst = syoriCTL.getHubiMsgs();
        mosnaiCheckParam.setListHubiMsg(hubiMsgLst);
        Tuusan tuusan = SWAKInjector.getInstance(Tuusan.class);
        checkTuusan.exec(mosnaiCheckParam, tuusan);

        exNumericEquals(hubiMsgLst.size(), 1, "不備メッセージテーブルエンティティリストの件数");
        exStringEquals(hubiMsgLst.get(0).getMosno(), "860000173", "申込番号");
        exNumericEquals(hubiMsgLst.get(0).getRenno(), 1, "連番");
        exStringEquals(hubiMsgLst.get(0).getHubimsg(), "【特認可能】通算２年未経過総死亡Ｓ限度額の１０１円をオーバーしています。　保険金額は２４５円までにしてください。", "不備メッセージ");
        exStringEquals(hubiMsgLst.get(0).getMessageId(), "THC1045", "メッセージＩＤ");
        exClassificationEquals(hubiMsgLst.get(0).getHubisyubetukbn(), C_HubisyubetuKbn.KETHORYU_HUBI, "不備種別区分");
        exClassificationEquals(mosnaiCheckParam.getSekmossakuseiErroutKbn(), C_SekmossakuseiErroutKbn.NONE,
            "設計書申込書作成エラー出力区分");
        exStringEquals(mosnaiCheckParam.getSekmossakuseiErrmsg1(), "", "設計書申込書作成エラーメッセージ１");
        exStringEquals(mosnaiCheckParam.getSekmossakuseiErrmsg2(), "", "設計書申込書作成エラーメッセージ２");
        exClassificationEquals(mosnaiCheckParam.getKouzokuSyoriJikkouKbn(), C_KouzokujkKbn.JIKKOU, "後続処理実行区分");
        exClassificationEquals(mosnaiCheckParam.getSakuinTsnKbn(), C_SakuintsnKbn.ERROR, "索引通算区分");
    }

    @Test
    @TestOrder(180)
    public void testExec_A18() {
        TuusanMockForSinkeiyaku.SYORIPTN = TuusanMockForSinkeiyaku.TESTPATTERN17;

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("860000181");
        List<HT_MosSyouhn> mosSyouhnLst = syoriCTL.getMosSyouhnsBySyutkkbn(C_SyutkKbn.SYU);

        HT_MosSyouhn mosSyouhn = mosSyouhnLst.get(0);
        BM_SyouhnZokusei syouhnZokusei =
            bizDomManager.getSyouhnZokusei(mosSyouhn.getSyouhncd(), mosSyouhn.getSyouhnsdno());
        mosnaiCheckParam.setSyuSyouhnZokusei(syouhnZokusei);

        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setSysKbn(C_SysKbn.SKEI);
        mosnaiCheckParam.setTkrtkKinyuuknUmuKbn(C_UmuKbn.NONE);
        mosnaiCheckParam.setKydsskKinyuuknUmuKbn(C_UmuKbn.NONE);
        mosnaiCheckParam.setSakuinTsnKbn(C_SakuintsnKbn.SEIJYOU);
        List<HT_HubiMsg> hubiMsgLst = syoriCTL.getHubiMsgs();
        mosnaiCheckParam.setListHubiMsg(hubiMsgLst);
        Tuusan tuusan = SWAKInjector.getInstance(Tuusan.class);
        checkTuusan.exec(mosnaiCheckParam, tuusan);

        exNumericEquals(hubiMsgLst.size(), 1, "不備メッセージテーブルエンティティリストの件数");
        exStringEquals(hubiMsgLst.get(0).getMosno(), "860000181", "申込番号");
        exNumericEquals(hubiMsgLst.get(0).getRenno(), 1, "連番");
        exStringEquals(hubiMsgLst.get(0).getHubimsg(), "【特認可能】通算２年未経過総死亡Ｓ限度額の１０１円をオーバーしています。　ご加入できません。", "不備メッセージ");
        exStringEquals(hubiMsgLst.get(0).getMessageId(), "THC1044", "メッセージＩＤ");
        exClassificationEquals(hubiMsgLst.get(0).getHubisyubetukbn(), C_HubisyubetuKbn.KETHORYU_HUBI, "不備種別区分");
        exClassificationEquals(mosnaiCheckParam.getSekmossakuseiErroutKbn(), C_SekmossakuseiErroutKbn.NONE,
            "設計書申込書作成エラー出力区分");
        exStringEquals(mosnaiCheckParam.getSekmossakuseiErrmsg1(), "", "設計書申込書作成エラーメッセージ１");
        exStringEquals(mosnaiCheckParam.getSekmossakuseiErrmsg2(), "", "設計書申込書作成エラーメッセージ２");
        exClassificationEquals(mosnaiCheckParam.getKouzokuSyoriJikkouKbn(), C_KouzokujkKbn.JIKKOU, "後続処理実行区分");
        exClassificationEquals(mosnaiCheckParam.getSakuinTsnKbn(), C_SakuintsnKbn.ERROR, "索引通算区分");
    }

    @Test
    @TestOrder(190)
    public void testExec_A19() {
        TuusanMockForSinkeiyaku.SYORIPTN = TuusanMockForSinkeiyaku.TESTPATTERN17;
        KeisanSPMockForSinkeiyaku.SYORIPTN = KeisanSPMockForSinkeiyaku.TESTPATTERN19;
        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("860000199");
        List<HT_MosSyouhn> mosSyouhnLst = syoriCTL.getMosSyouhnsBySyutkkbn(C_SyutkKbn.SYU);

        HT_MosSyouhn mosSyouhn = mosSyouhnLst.get(0);
        BM_SyouhnZokusei syouhnZokusei =
            bizDomManager.getSyouhnZokusei(mosSyouhn.getSyouhncd(), mosSyouhn.getSyouhnsdno());
        mosnaiCheckParam.setSyuSyouhnZokusei(syouhnZokusei);

        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setSysKbn(C_SysKbn.ESHIEN);
        mosnaiCheckParam.setTkrtkKinyuuknUmuKbn(C_UmuKbn.NONE);
        mosnaiCheckParam.setKydsskKinyuuknUmuKbn(C_UmuKbn.NONE);
        mosnaiCheckParam.setSakuinTsnKbn(C_SakuintsnKbn.SEIJYOU);
        List<HT_HubiMsg> hubiMsgLst = syoriCTL.getHubiMsgs();
        mosnaiCheckParam.setListHubiMsg(hubiMsgLst);
        Tuusan tuusan = SWAKInjector.getInstance(Tuusan.class);
        checkTuusan.exec(mosnaiCheckParam, tuusan);

        exNumericEquals(hubiMsgLst.size(), 0, "不備メッセージテーブルエンティティリストの件数");
        exClassificationEquals(mosnaiCheckParam.getSekmossakuseiErroutKbn(), C_SekmossakuseiErroutKbn.GAMEN,
            "設計書申込書作成エラー出力区分");
        exStringEquals(mosnaiCheckParam.getSekmossakuseiErrmsg1(), "", "設計書申込書作成エラーメッセージ１");
        exStringEquals(mosnaiCheckParam.getSekmossakuseiErrmsg2(), "通算保険金額が限度額を超えています　ご加入できません", "設計書申込書作成エラーメッセージ２");
        exClassificationEquals(mosnaiCheckParam.getKouzokuSyoriJikkouKbn(), C_KouzokujkKbn.NONE, "後続処理実行区分");
        exClassificationEquals(mosnaiCheckParam.getSakuinTsnKbn(), C_SakuintsnKbn.ERROR, "索引通算区分");
    }

    @Test
    @TestOrder(200)
    public void testExec_A20() {
        TuusanMockForSinkeiyaku.SYORIPTN = TuusanMockForSinkeiyaku.TESTPATTERN17;
        KeisanSPMockForSinkeiyaku.SYORIPTN = KeisanSPMockForSinkeiyaku.TESTPATTERN20;
        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("860000207");
        List<HT_MosSyouhn> mosSyouhnLst = syoriCTL.getMosSyouhnsBySyutkkbn(C_SyutkKbn.SYU);

        HT_MosSyouhn mosSyouhn = mosSyouhnLst.get(0);
        BM_SyouhnZokusei syouhnZokusei =
            bizDomManager.getSyouhnZokusei(mosSyouhn.getSyouhncd(), mosSyouhn.getSyouhnsdno());
        mosnaiCheckParam.setSyuSyouhnZokusei(syouhnZokusei);

        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setSysKbn(C_SysKbn.SKEI);
        mosnaiCheckParam.setTkrtkKinyuuknUmuKbn(C_UmuKbn.NONE);
        mosnaiCheckParam.setKydsskKinyuuknUmuKbn(C_UmuKbn.NONE);
        mosnaiCheckParam.setSakuinTsnKbn(C_SakuintsnKbn.SEIJYOU);
        List<HT_HubiMsg> hubiMsgLst = syoriCTL.getHubiMsgs();
        mosnaiCheckParam.setListHubiMsg(hubiMsgLst);
        Tuusan tuusan = SWAKInjector.getInstance(Tuusan.class);
        checkTuusan.exec(mosnaiCheckParam, tuusan);

        exNumericEquals(hubiMsgLst.size(), 1, "不備メッセージテーブルエンティティリストの件数");
        exStringEquals(hubiMsgLst.get(0).getMosno(), "860000207", "申込番号");
        exNumericEquals(hubiMsgLst.get(0).getRenno(), 1, "連番");
        exStringEquals(hubiMsgLst.get(0).getHubimsg(), "【特認可能】通算２年未経過総死亡Ｓ限度額の１０１円をオーバーしています。　保険料は０円までにしてください。", "不備メッセージ");
        exStringEquals(hubiMsgLst.get(0).getMessageId(), "THC1045", "メッセージＩＤ");
        exClassificationEquals(hubiMsgLst.get(0).getHubisyubetukbn(), C_HubisyubetuKbn.KETHORYU_HUBI, "不備種別区分");
        exClassificationEquals(mosnaiCheckParam.getSekmossakuseiErroutKbn(), C_SekmossakuseiErroutKbn.NONE,
            "設計書申込書作成エラー出力区分");
        exStringEquals(mosnaiCheckParam.getSekmossakuseiErrmsg1(), "", "設計書申込書作成エラーメッセージ１");
        exStringEquals(mosnaiCheckParam.getSekmossakuseiErrmsg2(), "", "設計書申込書作成エラーメッセージ２");
        exClassificationEquals(mosnaiCheckParam.getKouzokuSyoriJikkouKbn(), C_KouzokujkKbn.JIKKOU, "後続処理実行区分");
        exClassificationEquals(mosnaiCheckParam.getSakuinTsnKbn(), C_SakuintsnKbn.ERROR, "索引通算区分");
    }

    @Test
    @TestOrder(210)
    public void testExec_A21() {
        TuusanMockForSinkeiyaku.SYORIPTN = TuusanMockForSinkeiyaku.TESTPATTERN17;
        KeisanSPMockForSinkeiyaku.SYORIPTN = KeisanSPMockForSinkeiyaku.TESTPATTERN21;
        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("860000215");
        List<HT_MosSyouhn> mosSyouhnLst = syoriCTL.getMosSyouhnsBySyutkkbn(C_SyutkKbn.SYU);

        HT_MosSyouhn mosSyouhn = mosSyouhnLst.get(0);
        BM_SyouhnZokusei syouhnZokusei =
            bizDomManager.getSyouhnZokusei(mosSyouhn.getSyouhncd(), mosSyouhn.getSyouhnsdno());
        mosnaiCheckParam.setSyuSyouhnZokusei(syouhnZokusei);

        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setSysKbn(C_SysKbn.SKEI);
        mosnaiCheckParam.setTkrtkKinyuuknUmuKbn(C_UmuKbn.NONE);
        mosnaiCheckParam.setKydsskKinyuuknUmuKbn(C_UmuKbn.NONE);
        mosnaiCheckParam.setSakuinTsnKbn(C_SakuintsnKbn.SEIJYOU);
        List<HT_HubiMsg> hubiMsgLst = syoriCTL.getHubiMsgs();
        mosnaiCheckParam.setListHubiMsg(hubiMsgLst);
        Tuusan tuusan = SWAKInjector.getInstance(Tuusan.class);
        checkTuusan.exec(mosnaiCheckParam, tuusan);

        exNumericEquals(hubiMsgLst.size(), 1, "不備メッセージテーブルエンティティリストの件数");
        exStringEquals(hubiMsgLst.get(0).getMosno(), "860000215", "申込番号");
        exNumericEquals(hubiMsgLst.get(0).getRenno(), 1, "連番");
        exStringEquals(hubiMsgLst.get(0).getHubimsg(), "【特認可能】通算２年未経過総死亡Ｓ限度額の１０１円をオーバーしています。　保険料は０円までにしてください。", "不備メッセージ");
        exStringEquals(hubiMsgLst.get(0).getMessageId(), "THC1045", "メッセージＩＤ");
        exClassificationEquals(hubiMsgLst.get(0).getHubisyubetukbn(), C_HubisyubetuKbn.KETHORYU_HUBI, "不備種別区分");
        exClassificationEquals(mosnaiCheckParam.getSekmossakuseiErroutKbn(), C_SekmossakuseiErroutKbn.NONE,
            "設計書申込書作成エラー出力区分");
        exStringEquals(mosnaiCheckParam.getSekmossakuseiErrmsg1(), "", "設計書申込書作成エラーメッセージ１");
        exStringEquals(mosnaiCheckParam.getSekmossakuseiErrmsg2(), "", "設計書申込書作成エラーメッセージ２");
        exClassificationEquals(mosnaiCheckParam.getKouzokuSyoriJikkouKbn(), C_KouzokujkKbn.JIKKOU, "後続処理実行区分");
        exClassificationEquals(mosnaiCheckParam.getSakuinTsnKbn(), C_SakuintsnKbn.ERROR, "索引通算区分");
    }

    @Test
    @TestOrder(220)
    public void testExec_A22() {
        TuusanMockForSinkeiyaku.SYORIPTN = TuusanMockForSinkeiyaku.TESTPATTERN17;
        KeisanSPMockForSinkeiyaku.SYORIPTN = KeisanSPMockForSinkeiyaku.TESTPATTERN21;
        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("860000223");
        List<HT_MosSyouhn> mosSyouhnLst = syoriCTL.getMosSyouhnsBySyutkkbn(C_SyutkKbn.SYU);

        HT_MosSyouhn mosSyouhn = mosSyouhnLst.get(0);
        BM_SyouhnZokusei syouhnZokusei =
            bizDomManager.getSyouhnZokusei(mosSyouhn.getSyouhncd(), mosSyouhn.getSyouhnsdno());
        mosnaiCheckParam.setSyuSyouhnZokusei(syouhnZokusei);

        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setSysKbn(C_SysKbn.SKEI);
        mosnaiCheckParam.setTkrtkKinyuuknUmuKbn(C_UmuKbn.NONE);
        mosnaiCheckParam.setKydsskKinyuuknUmuKbn(C_UmuKbn.NONE);
        mosnaiCheckParam.setSakuinTsnKbn(C_SakuintsnKbn.SEIJYOU);
        List<HT_HubiMsg> hubiMsgLst = syoriCTL.getHubiMsgs();
        mosnaiCheckParam.setListHubiMsg(hubiMsgLst);
        Tuusan tuusan = SWAKInjector.getInstance(Tuusan.class);
        checkTuusan.exec(mosnaiCheckParam, tuusan);

        exNumericEquals(hubiMsgLst.size(), 1, "不備メッセージテーブルエンティティリストの件数");
        exStringEquals(hubiMsgLst.get(0).getMosno(), "860000223", "申込番号");
        exNumericEquals(hubiMsgLst.get(0).getRenno(), 1, "連番");
        exStringEquals(hubiMsgLst.get(0).getHubimsg(), "【特認可能】通算２年未経過総死亡Ｓ限度額の１０１円をオーバーしています。　ご加入できません。", "不備メッセージ");
        exStringEquals(hubiMsgLst.get(0).getMessageId(), "THC1044", "メッセージＩＤ");
        exClassificationEquals(hubiMsgLst.get(0).getHubisyubetukbn(), C_HubisyubetuKbn.KETHORYU_HUBI, "不備種別区分");
        exClassificationEquals(mosnaiCheckParam.getSekmossakuseiErroutKbn(), C_SekmossakuseiErroutKbn.NONE,
            "設計書申込書作成エラー出力区分");
        exStringEquals(mosnaiCheckParam.getSekmossakuseiErrmsg1(), "", "設計書申込書作成エラーメッセージ１");
        exStringEquals(mosnaiCheckParam.getSekmossakuseiErrmsg2(), "", "設計書申込書作成エラーメッセージ２");
        exClassificationEquals(mosnaiCheckParam.getKouzokuSyoriJikkouKbn(), C_KouzokujkKbn.JIKKOU, "後続処理実行区分");
        exClassificationEquals(mosnaiCheckParam.getSakuinTsnKbn(), C_SakuintsnKbn.ERROR, "索引通算区分");
    }

    @Test
    @TestOrder(230)
    public void testExec_A23() {
        TuusanMockForSinkeiyaku.SYORIPTN = TuusanMockForSinkeiyaku.TESTPATTERN23;
        CheckSaiteiPMockForSinkeiyaku.SYORIPTN = CheckSaiteiPMockForSinkeiyaku.TESTPATTERN23;
        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("860000231");
        List<HT_MosSyouhn> mosSyouhnLst = syoriCTL.getMosSyouhnsBySyutkkbn(C_SyutkKbn.SYU);

        HT_MosSyouhn mosSyouhn = mosSyouhnLst.get(0);
        BM_SyouhnZokusei syouhnZokusei =
            bizDomManager.getSyouhnZokusei(mosSyouhn.getSyouhncd(), mosSyouhn.getSyouhnsdno());
        mosnaiCheckParam.setSyuSyouhnZokusei(syouhnZokusei);

        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setSysKbn(C_SysKbn.ESHIEN);
        mosnaiCheckParam.setTkrtkKinyuuknUmuKbn(C_UmuKbn.NONE);
        mosnaiCheckParam.setKydsskKinyuuknUmuKbn(C_UmuKbn.NONE);
        mosnaiCheckParam.setSakuinTsnKbn(C_SakuintsnKbn.SEIJYOU);
        mosnaiCheckParam.setPdateSRate(BizNumber.valueOf(7));
        mosnaiCheckParam.setHrbtJyousu(BizNumber.valueOf(5));
        mosnaiCheckParam.setNyuukinKawaseRate(BizNumber.valueOf(15));
        List<HT_HubiMsg> hubiMsgLst = syoriCTL.getHubiMsgs();
        mosnaiCheckParam.setListHubiMsg(hubiMsgLst);
        Tuusan tuusan = SWAKInjector.getInstance(Tuusan.class);
        checkTuusan.exec(mosnaiCheckParam, tuusan);

        exNumericEquals(hubiMsgLst.size(), 0, "不備メッセージテーブルエンティティリストの件数");
        exClassificationEquals(mosnaiCheckParam.getSekmossakuseiErroutKbn(), C_SekmossakuseiErroutKbn.GAMEN,
            "設計書申込書作成エラー出力区分");
        exStringEquals(mosnaiCheckParam.getSekmossakuseiErrmsg1(), "通算保険金額が限度額を超えています", "設計書申込書作成エラーメッセージ１");
        exStringEquals(mosnaiCheckParam.getSekmossakuseiErrmsg2(), "保険料は１６１円までにしてください", "設計書申込書作成エラーメッセージ２");
        exClassificationEquals(mosnaiCheckParam.getKouzokuSyoriJikkouKbn(), C_KouzokujkKbn.NONE, "後続処理実行区分");
        exClassificationEquals(mosnaiCheckParam.getSakuinTsnKbn(), C_SakuintsnKbn.ERROR, "索引通算区分");
    }

    @Test
    @TestOrder(240)
    public void testExec_A24() {
        TuusanMockForSinkeiyaku.SYORIPTN = TuusanMockForSinkeiyaku.TESTPATTERN23;
        CheckSaiteiPMockForSinkeiyaku.SYORIPTN = CheckSaiteiPMockForSinkeiyaku.TESTPATTERN24;
        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("860000249");
        List<HT_MosSyouhn> mosSyouhnLst = syoriCTL.getMosSyouhnsBySyutkkbn(C_SyutkKbn.SYU);

        HT_MosSyouhn mosSyouhn = mosSyouhnLst.get(0);
        BM_SyouhnZokusei syouhnZokusei =
            bizDomManager.getSyouhnZokusei(mosSyouhn.getSyouhncd(), mosSyouhn.getSyouhnsdno());
        mosnaiCheckParam.setSyuSyouhnZokusei(syouhnZokusei);

        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setSysKbn(C_SysKbn.ESHIEN);
        mosnaiCheckParam.setTkrtkKinyuuknUmuKbn(C_UmuKbn.NONE);
        mosnaiCheckParam.setKydsskKinyuuknUmuKbn(C_UmuKbn.NONE);
        mosnaiCheckParam.setSakuinTsnKbn(C_SakuintsnKbn.SEIJYOU);
        mosnaiCheckParam.setPdateSRate(BizNumber.valueOf(7));
        mosnaiCheckParam.setHrbtJyousu(BizNumber.valueOf(5));
        mosnaiCheckParam.setNyuukinKawaseRate(BizNumber.valueOf(15));
        List<HT_HubiMsg> hubiMsgLst = syoriCTL.getHubiMsgs();
        mosnaiCheckParam.setListHubiMsg(hubiMsgLst);
        Tuusan tuusan = SWAKInjector.getInstance(Tuusan.class);
        checkTuusan.exec(mosnaiCheckParam, tuusan);

        exNumericEquals(hubiMsgLst.size(), 0, "不備メッセージテーブルエンティティリストの件数");
        exClassificationEquals(mosnaiCheckParam.getSekmossakuseiErroutKbn(), C_SekmossakuseiErroutKbn.GAMEN,
            "設計書申込書作成エラー出力区分");
        exStringEquals(mosnaiCheckParam.getSekmossakuseiErrmsg1(), "通算保険金額が限度額を超えています", "設計書申込書作成エラーメッセージ１");
        exStringEquals(mosnaiCheckParam.getSekmossakuseiErrmsg2(), "保険料は１６１円までにしてください", "設計書申込書作成エラーメッセージ２");
        exClassificationEquals(mosnaiCheckParam.getKouzokuSyoriJikkouKbn(), C_KouzokujkKbn.NONE, "後続処理実行区分");
        exClassificationEquals(mosnaiCheckParam.getSakuinTsnKbn(), C_SakuintsnKbn.ERROR, "索引通算区分");
    }

    @Test
    @TestOrder(250)
    public void testExec_A25() {
        TuusanMockForSinkeiyaku.SYORIPTN = TuusanMockForSinkeiyaku.TESTPATTERN23;
        CheckSaiteiPMockForSinkeiyaku.SYORIPTN = CheckSaiteiPMockForSinkeiyaku.TESTPATTERN25;
        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("860000256");
        List<HT_MosSyouhn> mosSyouhnLst = syoriCTL.getMosSyouhnsBySyutkkbn(C_SyutkKbn.SYU);

        HT_MosSyouhn mosSyouhn = mosSyouhnLst.get(0);
        BM_SyouhnZokusei syouhnZokusei =
            bizDomManager.getSyouhnZokusei(mosSyouhn.getSyouhncd(), mosSyouhn.getSyouhnsdno());
        mosnaiCheckParam.setSyuSyouhnZokusei(syouhnZokusei);

        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setSysKbn(C_SysKbn.ESHIEN);
        mosnaiCheckParam.setTkrtkKinyuuknUmuKbn(C_UmuKbn.NONE);
        mosnaiCheckParam.setKydsskKinyuuknUmuKbn(C_UmuKbn.NONE);
        mosnaiCheckParam.setSakuinTsnKbn(C_SakuintsnKbn.SEIJYOU);
        mosnaiCheckParam.setPdateSRate(BizNumber.valueOf(7));
        mosnaiCheckParam.setHrbtJyousu(BizNumber.valueOf(5));
        mosnaiCheckParam.setNyuukinKawaseRate(BizNumber.valueOf(15));
        List<HT_HubiMsg> hubiMsgLst = syoriCTL.getHubiMsgs();
        mosnaiCheckParam.setListHubiMsg(hubiMsgLst);
        Tuusan tuusan = SWAKInjector.getInstance(Tuusan.class);
        checkTuusan.exec(mosnaiCheckParam, tuusan);

        exNumericEquals(hubiMsgLst.size(), 0, "不備メッセージテーブルエンティティリストの件数");
        exClassificationEquals(mosnaiCheckParam.getSekmossakuseiErroutKbn(), C_SekmossakuseiErroutKbn.GAMEN,
            "設計書申込書作成エラー出力区分");
        exStringEquals(mosnaiCheckParam.getSekmossakuseiErrmsg1(), "", "設計書申込書作成エラーメッセージ１");
        exStringEquals(mosnaiCheckParam.getSekmossakuseiErrmsg2(), "通算保険金額が限度額を超えています　ご加入できません", "設計書申込書作成エラーメッセージ２");
        exClassificationEquals(mosnaiCheckParam.getKouzokuSyoriJikkouKbn(), C_KouzokujkKbn.NONE, "後続処理実行区分");
        exClassificationEquals(mosnaiCheckParam.getSakuinTsnKbn(), C_SakuintsnKbn.ERROR, "索引通算区分");
    }

    @Test
    @TestOrder(260)
    public void testExec_A26() {
        TuusanMockForSinkeiyaku.SYORIPTN = TuusanMockForSinkeiyaku.TESTPATTERN26;
        KeisanSPMockForSinkeiyaku.SYORIPTN = KeisanSPMockForSinkeiyaku.TESTPATTERN26;
        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("860000264");
        List<HT_MosSyouhn> mosSyouhnLst = syoriCTL.getMosSyouhnsBySyutkkbn(C_SyutkKbn.SYU);

        HT_MosSyouhn mosSyouhn = mosSyouhnLst.get(0);
        BM_SyouhnZokusei syouhnZokusei =
            bizDomManager.getSyouhnZokusei(mosSyouhn.getSyouhncd(), mosSyouhn.getSyouhnsdno());
        mosnaiCheckParam.setSyuSyouhnZokusei(syouhnZokusei);

        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setSysKbn(C_SysKbn.SKEI);
        mosnaiCheckParam.setTkrtkKinyuuknUmuKbn(C_UmuKbn.ARI);
        mosnaiCheckParam.setKydsskKinyuuknUmuKbn(C_UmuKbn.NONE);
        List<HT_HubiMsg> hubiMsgLst = syoriCTL.getHubiMsgs();
        mosnaiCheckParam.setListHubiMsg(hubiMsgLst);
        Tuusan tuusan = SWAKInjector.getInstance(Tuusan.class);
        checkTuusan.exec(mosnaiCheckParam, tuusan);

        exNumericEquals(hubiMsgLst.size(), 1, "不備メッセージテーブルエンティティリストの件数");
        exStringEquals(hubiMsgLst.get(0).getMosno(), "860000264", "申込番号");
        exNumericEquals(hubiMsgLst.get(0).getRenno(), 1, "連番");
        exStringEquals(hubiMsgLst.get(0).getHubimsg(), "【特認可能】通算総死亡Ｓ限度額の１００円をオーバーしています。　保険料は０円までにしてください。", "不備メッセージ");
        exStringEquals(hubiMsgLst.get(0).getMessageId(), "THC1043", "メッセージＩＤ");
        exClassificationEquals(hubiMsgLst.get(0).getHubisyubetukbn(), C_HubisyubetuKbn.KETHORYU_HUBI, "不備種別区分");
        exClassificationEquals(mosnaiCheckParam.getSekmossakuseiErroutKbn(), C_SekmossakuseiErroutKbn.NONE,
            "設計書申込書作成エラー出力区分");
        exStringEquals(mosnaiCheckParam.getSekmossakuseiErrmsg1(), "", "設計書申込書作成エラーメッセージ１");
        exStringEquals(mosnaiCheckParam.getSekmossakuseiErrmsg2(), "", "設計書申込書作成エラーメッセージ２");
        exClassificationEquals(mosnaiCheckParam.getKouzokuSyoriJikkouKbn(), C_KouzokujkKbn.JIKKOU, "後続処理実行区分");
        exClassificationEquals(mosnaiCheckParam.getSakuinTsnKbn(), C_SakuintsnKbn.ERROR, "索引通算区分");
    }

    @Test
    @TestOrder(270)
    public void testExec_A27() {
        TuusanMockForSinkeiyaku.SYORIPTN = TuusanMockForSinkeiyaku.TESTPATTERN26;
        KeisanSPMockForSinkeiyaku.SYORIPTN = KeisanSPMockForSinkeiyaku.TESTPATTERN27;
        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("860000272");
        List<HT_MosSyouhn> mosSyouhnLst = syoriCTL.getMosSyouhnsBySyutkkbn(C_SyutkKbn.SYU);

        HT_MosSyouhn mosSyouhn = mosSyouhnLst.get(0);
        BM_SyouhnZokusei syouhnZokusei =
            bizDomManager.getSyouhnZokusei(mosSyouhn.getSyouhncd(), mosSyouhn.getSyouhnsdno());
        mosnaiCheckParam.setSyuSyouhnZokusei(syouhnZokusei);

        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setSysKbn(C_SysKbn.ESHIEN);
        mosnaiCheckParam.setTkrtkKinyuuknUmuKbn(C_UmuKbn.ARI);
        mosnaiCheckParam.setKydsskKinyuuknUmuKbn(C_UmuKbn.NONE);
        List<HT_HubiMsg> hubiMsgLst = syoriCTL.getHubiMsgs();
        mosnaiCheckParam.setListHubiMsg(hubiMsgLst);
        Tuusan tuusan = SWAKInjector.getInstance(Tuusan.class);
        checkTuusan.exec(mosnaiCheckParam, tuusan);

        exNumericEquals(hubiMsgLst.size(), 0, "不備メッセージテーブルエンティティリストの件数");
        exClassificationEquals(mosnaiCheckParam.getSekmossakuseiErroutKbn(), C_SekmossakuseiErroutKbn.GAMEN,
            "設計書申込書作成エラー出力区分");
        exStringEquals(mosnaiCheckParam.getSekmossakuseiErrmsg1(), "通算保険金額が限度額を超えています", "設計書申込書作成エラーメッセージ１");
        exStringEquals(mosnaiCheckParam.getSekmossakuseiErrmsg2(), "保険料は０円までにしてください", "設計書申込書作成エラーメッセージ２");
        exClassificationEquals(mosnaiCheckParam.getKouzokuSyoriJikkouKbn(), C_KouzokujkKbn.NONE, "後続処理実行区分");
        exClassificationEquals(mosnaiCheckParam.getSakuinTsnKbn(), C_SakuintsnKbn.ERROR, "索引通算区分");
    }

    @Test
    @TestOrder(280)
    public void testExec_A28() {
        TuusanMockForSinkeiyaku.SYORIPTN = TuusanMockForSinkeiyaku.TESTPATTERN26;
        KeisanSPMockForSinkeiyaku.SYORIPTN = KeisanSPMockForSinkeiyaku.TESTPATTERN28;
        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("860000280");
        List<HT_MosSyouhn> mosSyouhnLst = syoriCTL.getMosSyouhnsBySyutkkbn(C_SyutkKbn.SYU);

        HT_MosSyouhn mosSyouhn = mosSyouhnLst.get(0);
        BM_SyouhnZokusei syouhnZokusei =
            bizDomManager.getSyouhnZokusei(mosSyouhn.getSyouhncd(), mosSyouhn.getSyouhnsdno());
        mosnaiCheckParam.setSyuSyouhnZokusei(syouhnZokusei);

        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setSysKbn(C_SysKbn.SKEI);
        mosnaiCheckParam.setTkrtkKinyuuknUmuKbn(C_UmuKbn.ARI);
        mosnaiCheckParam.setKydsskKinyuuknUmuKbn(C_UmuKbn.NONE);

        Tuusan tuusan = SWAKInjector.getInstance(Tuusan.class);
        checkTuusan.exec(mosnaiCheckParam, tuusan);

        List<HT_HubiMsg> hubiMsgLst = syoriCTL.getHubiMsgs();
        exNumericEquals(hubiMsgLst.size(), 0, "不備メッセージテーブルエンティティリストの件数");
        exClassificationEquals(mosnaiCheckParam.getSekmossakuseiErroutKbn(), C_SekmossakuseiErroutKbn.NONE,
            "設計書申込書作成エラー出力区分");
        exStringEquals(mosnaiCheckParam.getSekmossakuseiErrmsg1(), "", "設計書申込書作成エラーメッセージ１");
        exStringEquals(mosnaiCheckParam.getSekmossakuseiErrmsg2(), "", "設計書申込書作成エラーメッセージ２");
        exClassificationEquals(mosnaiCheckParam.getKouzokuSyoriJikkouKbn(), C_KouzokujkKbn.JIKKOU, "後続処理実行区分");
        exClassificationEquals(mosnaiCheckParam.getSakuinTsnKbn(), C_SakuintsnKbn.ERROR, "索引通算区分");
    }

    @Test
    @TestOrder(290)
    public void testExec_A29() {
        TuusanMockForSinkeiyaku.SYORIPTN = TuusanMockForSinkeiyaku.TESTPATTERN29;

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("860000298");
        List<HT_MosSyouhn> mosSyouhnLst = syoriCTL.getMosSyouhnsBySyutkkbn(C_SyutkKbn.SYU);

        HT_MosSyouhn mosSyouhn = mosSyouhnLst.get(0);
        BM_SyouhnZokusei syouhnZokusei =
            bizDomManager.getSyouhnZokusei(mosSyouhn.getSyouhncd(), mosSyouhn.getSyouhnsdno());
        mosnaiCheckParam.setSyuSyouhnZokusei(syouhnZokusei);

        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setSysKbn(C_SysKbn.ESHIEN);
        mosnaiCheckParam.setTkrtkKinyuuknUmuKbn(C_UmuKbn.ARI);
        mosnaiCheckParam.setKydsskKinyuuknUmuKbn(C_UmuKbn.NONE);
        List<HT_HubiMsg> hubiMsgLst = syoriCTL.getHubiMsgs();
        mosnaiCheckParam.setListHubiMsg(hubiMsgLst);
        Tuusan tuusan = SWAKInjector.getInstance(Tuusan.class);
        checkTuusan.exec(mosnaiCheckParam, tuusan);

        exNumericEquals(hubiMsgLst.size(), 0, "不備メッセージテーブルエンティティリストの件数");
        exClassificationEquals(mosnaiCheckParam.getSekmossakuseiErroutKbn(), C_SekmossakuseiErroutKbn.GAMEN,
            "設計書申込書作成エラー出力区分");
        exStringEquals(mosnaiCheckParam.getSekmossakuseiErrmsg1(), "通算保険金額が限度額を超えています", "設計書申込書作成エラーメッセージ１");
        exStringEquals(mosnaiCheckParam.getSekmossakuseiErrmsg2(), "保険金額は９５円までにしてください", "設計書申込書作成エラーメッセージ２");
        exClassificationEquals(mosnaiCheckParam.getKouzokuSyoriJikkouKbn(), C_KouzokujkKbn.NONE, "後続処理実行区分");
        exClassificationEquals(mosnaiCheckParam.getSakuinTsnKbn(), C_SakuintsnKbn.ERROR, "索引通算区分");
    }


    @Test
    @TestOrder(300)
    public void testExec_A30() {
        TuusanMockForSinkeiyaku.SYORIPTN = TuusanMockForSinkeiyaku.TESTPATTERN29;

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("860000306");
        List<HT_MosSyouhn> mosSyouhnLst = syoriCTL.getMosSyouhnsBySyutkkbn(C_SyutkKbn.SYU);

        HT_MosSyouhn mosSyouhn = mosSyouhnLst.get(0);
        BM_SyouhnZokusei syouhnZokusei =
            bizDomManager.getSyouhnZokusei(mosSyouhn.getSyouhncd(), mosSyouhn.getSyouhnsdno());
        mosnaiCheckParam.setSyuSyouhnZokusei(syouhnZokusei);

        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setSysKbn(C_SysKbn.ESHIEN);
        mosnaiCheckParam.setTkrtkKinyuuknUmuKbn(C_UmuKbn.ARI);
        mosnaiCheckParam.setKydsskKinyuuknUmuKbn(C_UmuKbn.NONE);
        List<HT_HubiMsg> hubiMsgLst = syoriCTL.getHubiMsgs();
        mosnaiCheckParam.setListHubiMsg(hubiMsgLst);
        Tuusan tuusan = SWAKInjector.getInstance(Tuusan.class);
        checkTuusan.exec(mosnaiCheckParam, tuusan);

        exNumericEquals(hubiMsgLst.size(), 0, "不備メッセージテーブルエンティティリストの件数");
        exClassificationEquals(mosnaiCheckParam.getSekmossakuseiErroutKbn(), C_SekmossakuseiErroutKbn.GAMEN,
            "設計書申込書作成エラー出力区分");
        exStringEquals(mosnaiCheckParam.getSekmossakuseiErrmsg1(), "通算保険金額が限度額を超えています", "設計書申込書作成エラーメッセージ１");
        exStringEquals(mosnaiCheckParam.getSekmossakuseiErrmsg2(), "保険金額は９５円までにしてください", "設計書申込書作成エラーメッセージ２");
        exClassificationEquals(mosnaiCheckParam.getKouzokuSyoriJikkouKbn(), C_KouzokujkKbn.NONE, "後続処理実行区分");
        exClassificationEquals(mosnaiCheckParam.getSakuinTsnKbn(), C_SakuintsnKbn.ERROR, "索引通算区分");
    }


    @Test
    @TestOrder(310)
    public void testExec_A31() {
        TuusanMockForSinkeiyaku.SYORIPTN = TuusanMockForSinkeiyaku.TESTPATTERN29;

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("860000314");
        List<HT_MosSyouhn> mosSyouhnLst = syoriCTL.getMosSyouhnsBySyutkkbn(C_SyutkKbn.SYU);

        HT_MosSyouhn mosSyouhn = mosSyouhnLst.get(0);
        BM_SyouhnZokusei syouhnZokusei =
            bizDomManager.getSyouhnZokusei(mosSyouhn.getSyouhncd(), mosSyouhn.getSyouhnsdno());
        mosnaiCheckParam.setSyuSyouhnZokusei(syouhnZokusei);

        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setSysKbn(C_SysKbn.ESHIEN);
        mosnaiCheckParam.setTkrtkKinyuuknUmuKbn(C_UmuKbn.ARI);
        mosnaiCheckParam.setKydsskKinyuuknUmuKbn(C_UmuKbn.NONE);
        List<HT_HubiMsg> hubiMsgLst = syoriCTL.getHubiMsgs();
        mosnaiCheckParam.setListHubiMsg(hubiMsgLst);
        Tuusan tuusan = SWAKInjector.getInstance(Tuusan.class);
        checkTuusan.exec(mosnaiCheckParam, tuusan);

        exNumericEquals(hubiMsgLst.size(), 0, "不備メッセージテーブルエンティティリストの件数");
        exClassificationEquals(mosnaiCheckParam.getSekmossakuseiErroutKbn(), C_SekmossakuseiErroutKbn.GAMEN,
            "設計書申込書作成エラー出力区分");
        exStringEquals(mosnaiCheckParam.getSekmossakuseiErrmsg1(), "", "設計書申込書作成エラーメッセージ１");
        exStringEquals(mosnaiCheckParam.getSekmossakuseiErrmsg2(), "通算保険金額が限度額を超えています　ご加入できません", "設計書申込書作成エラーメッセージ２");
        exClassificationEquals(mosnaiCheckParam.getKouzokuSyoriJikkouKbn(), C_KouzokujkKbn.NONE, "後続処理実行区分");
        exClassificationEquals(mosnaiCheckParam.getSakuinTsnKbn(), C_SakuintsnKbn.ERROR, "索引通算区分");
    }

    @Test
    @TestOrder(320)
    public void testExec_A32() {
        TuusanMockForSinkeiyaku.SYORIPTN = TuusanMockForSinkeiyaku.TESTPATTERN29;
        CheckSaiteiPMockForSinkeiyaku.SYORIPTN = CheckSaiteiPMockForSinkeiyaku.TESTPATTERN32;
        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("860000322");
        List<HT_MosSyouhn> mosSyouhnLst = syoriCTL.getMosSyouhnsBySyutkkbn(C_SyutkKbn.SYU);

        HT_MosSyouhn mosSyouhn = mosSyouhnLst.get(0);
        BM_SyouhnZokusei syouhnZokusei =
            bizDomManager.getSyouhnZokusei(mosSyouhn.getSyouhncd(), mosSyouhn.getSyouhnsdno());
        mosnaiCheckParam.setSyuSyouhnZokusei(syouhnZokusei);

        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setSysKbn(C_SysKbn.SKEI);


        mosnaiCheckParam.setTkrtkKinyuuknUmuKbn(C_UmuKbn.NONE);
        mosnaiCheckParam.setKydsskKinyuuknUmuKbn(C_UmuKbn.NONE);
        mosnaiCheckParam.setSakuinTsnKbn(C_SakuintsnKbn.SEIJYOU);
        mosnaiCheckParam.setPdateSRate(BizNumber.valueOf(7));
        mosnaiCheckParam.setHrbtJyousu(BizNumber.valueOf(5));
        mosnaiCheckParam.setNyuukinKawaseRate(BizNumber.valueOf(15));
        List<HT_HubiMsg> hubiMsgLst = syoriCTL.getHubiMsgs();
        mosnaiCheckParam.setListHubiMsg(hubiMsgLst);
        Tuusan tuusan = SWAKInjector.getInstance(Tuusan.class);
        checkTuusan.exec(mosnaiCheckParam, tuusan);

        exNumericEquals(hubiMsgLst.size(), 1, "不備メッセージテーブルエンティティリストの件数");
        exStringEquals(hubiMsgLst.get(0).getMosno(), "860000322", "申込番号");
        exNumericEquals(hubiMsgLst.get(0).getRenno(), 1, "連番");
        exStringEquals(hubiMsgLst.get(0).getHubimsg(), "【特認可能】通算総死亡Ｓ限度額の１００円をオーバーしています。　保険料は６９円までにしてください。", "不備メッセージ");
        exStringEquals(hubiMsgLst.get(0).getMessageId(), "THC1043", "メッセージＩＤ");
        exClassificationEquals(hubiMsgLst.get(0).getHubisyubetukbn(), C_HubisyubetuKbn.KETHORYU_HUBI, "不備種別区分");
        exClassificationEquals(mosnaiCheckParam.getSekmossakuseiErroutKbn(), C_SekmossakuseiErroutKbn.NONE,
            "設計書申込書作成エラー出力区分");
        exStringEquals(mosnaiCheckParam.getSekmossakuseiErrmsg1(), "", "設計書申込書作成エラーメッセージ１");
        exStringEquals(mosnaiCheckParam.getSekmossakuseiErrmsg2(), "", "設計書申込書作成エラーメッセージ２");
        exClassificationEquals(mosnaiCheckParam.getKouzokuSyoriJikkouKbn(), C_KouzokujkKbn.JIKKOU, "後続処理実行区分");
        exClassificationEquals(mosnaiCheckParam.getSakuinTsnKbn(), C_SakuintsnKbn.ERROR, "索引通算区分");
    }

    @Test
    @TestOrder(330)
    public void testExec_A33() {
        TuusanMockForSinkeiyaku.SYORIPTN = TuusanMockForSinkeiyaku.TESTPATTERN29;
        CheckSaiteiPMockForSinkeiyaku.SYORIPTN = CheckSaiteiPMockForSinkeiyaku.TESTPATTERN33;
        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("860000322");
        List<HT_MosSyouhn> mosSyouhnLst = syoriCTL.getMosSyouhnsBySyutkkbn(C_SyutkKbn.SYU);

        HT_MosSyouhn mosSyouhn = mosSyouhnLst.get(0);
        BM_SyouhnZokusei syouhnZokusei =
            bizDomManager.getSyouhnZokusei(mosSyouhn.getSyouhncd(), mosSyouhn.getSyouhnsdno());
        mosnaiCheckParam.setSyuSyouhnZokusei(syouhnZokusei);

        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setSysKbn(C_SysKbn.SKEI);

        mosnaiCheckParam.setTkrtkKinyuuknUmuKbn(C_UmuKbn.NONE);
        mosnaiCheckParam.setKydsskKinyuuknUmuKbn(C_UmuKbn.NONE);
        mosnaiCheckParam.setSakuinTsnKbn(C_SakuintsnKbn.SEIJYOU);
        mosnaiCheckParam.setPdateSRate(BizNumber.valueOf(7));
        mosnaiCheckParam.setHrbtJyousu(BizNumber.valueOf(5));
        mosnaiCheckParam.setNyuukinKawaseRate(BizNumber.valueOf(15));
        List<HT_HubiMsg> hubiMsgLst = syoriCTL.getHubiMsgs();
        mosnaiCheckParam.setListHubiMsg(hubiMsgLst);
        Tuusan tuusan = SWAKInjector.getInstance(Tuusan.class);
        checkTuusan.exec(mosnaiCheckParam, tuusan);

        exNumericEquals(hubiMsgLst.size(), 1, "不備メッセージテーブルエンティティリストの件数");
        exStringEquals(hubiMsgLst.get(0).getMosno(), "860000322", "申込番号");
        exNumericEquals(hubiMsgLst.get(0).getRenno(), 1, "連番");
        exStringEquals(hubiMsgLst.get(0).getHubimsg(), "【特認可能】通算総死亡Ｓ限度額の１００円をオーバーしています。　保険料は６９円までにしてください。", "不備メッセージ");
        exStringEquals(hubiMsgLst.get(0).getMessageId(), "THC1043", "メッセージＩＤ");
        exClassificationEquals(hubiMsgLst.get(0).getHubisyubetukbn(), C_HubisyubetuKbn.KETHORYU_HUBI, "不備種別区分");
        exClassificationEquals(mosnaiCheckParam.getSekmossakuseiErroutKbn(), C_SekmossakuseiErroutKbn.NONE,
            "設計書申込書作成エラー出力区分");
        exStringEquals(mosnaiCheckParam.getSekmossakuseiErrmsg1(), "", "設計書申込書作成エラーメッセージ１");
        exStringEquals(mosnaiCheckParam.getSekmossakuseiErrmsg2(), "", "設計書申込書作成エラーメッセージ２");
        exClassificationEquals(mosnaiCheckParam.getKouzokuSyoriJikkouKbn(), C_KouzokujkKbn.JIKKOU, "後続処理実行区分");
        exClassificationEquals(mosnaiCheckParam.getSakuinTsnKbn(), C_SakuintsnKbn.ERROR, "索引通算区分");
    }

    @Test
    @TestOrder(340)
    public void testExec_A34() {
        TuusanMockForSinkeiyaku.SYORIPTN = TuusanMockForSinkeiyaku.TESTPATTERN29;
        CheckSaiteiPMockForSinkeiyaku.SYORIPTN = CheckSaiteiPMockForSinkeiyaku.TESTPATTERN34;
        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("860000322");
        List<HT_MosSyouhn> mosSyouhnLst = syoriCTL.getMosSyouhnsBySyutkkbn(C_SyutkKbn.SYU);

        HT_MosSyouhn mosSyouhn = mosSyouhnLst.get(0);
        BM_SyouhnZokusei syouhnZokusei =
            bizDomManager.getSyouhnZokusei(mosSyouhn.getSyouhncd(), mosSyouhn.getSyouhnsdno());
        mosnaiCheckParam.setSyuSyouhnZokusei(syouhnZokusei);

        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setSysKbn(C_SysKbn.SKEI);

        mosnaiCheckParam.setTkrtkKinyuuknUmuKbn(C_UmuKbn.NONE);
        mosnaiCheckParam.setKydsskKinyuuknUmuKbn(C_UmuKbn.NONE);
        mosnaiCheckParam.setSakuinTsnKbn(C_SakuintsnKbn.SEIJYOU);
        mosnaiCheckParam.setPdateSRate(BizNumber.valueOf(7));
        mosnaiCheckParam.setHrbtJyousu(BizNumber.valueOf(5));
        mosnaiCheckParam.setNyuukinKawaseRate(BizNumber.valueOf(15));
        List<HT_HubiMsg> hubiMsgLst = syoriCTL.getHubiMsgs();
        mosnaiCheckParam.setListHubiMsg(hubiMsgLst);
        Tuusan tuusan = SWAKInjector.getInstance(Tuusan.class);
        checkTuusan.exec(mosnaiCheckParam, tuusan);

        exNumericEquals(hubiMsgLst.size(), 1, "不備メッセージテーブルエンティティリストの件数");
        exStringEquals(hubiMsgLst.get(0).getMosno(), "860000322", "申込番号");
        exNumericEquals(hubiMsgLst.get(0).getRenno(), 1, "連番");
        exStringEquals(hubiMsgLst.get(0).getHubimsg(), "【特認可能】通算総死亡Ｓ限度額の１００円をオーバーしています。　ご加入できません。", "不備メッセージ");
        exStringEquals(hubiMsgLst.get(0).getMessageId(), "THC1042", "メッセージＩＤ");
        exClassificationEquals(hubiMsgLst.get(0).getHubisyubetukbn(), C_HubisyubetuKbn.KETHORYU_HUBI, "不備種別区分");
        exClassificationEquals(mosnaiCheckParam.getSekmossakuseiErroutKbn(), C_SekmossakuseiErroutKbn.NONE,
            "設計書申込書作成エラー出力区分");
        exStringEquals(mosnaiCheckParam.getSekmossakuseiErrmsg1(), "", "設計書申込書作成エラーメッセージ１");
        exStringEquals(mosnaiCheckParam.getSekmossakuseiErrmsg2(), "", "設計書申込書作成エラーメッセージ２");
        exClassificationEquals(mosnaiCheckParam.getKouzokuSyoriJikkouKbn(), C_KouzokujkKbn.JIKKOU, "後続処理実行区分");
        exClassificationEquals(mosnaiCheckParam.getSakuinTsnKbn(), C_SakuintsnKbn.ERROR, "索引通算区分");
    }

    @Test
    @TestOrder(350)
    public void testExec_A35() {
        TuusanMockForSinkeiyaku.SYORIPTN = TuusanMockForSinkeiyaku.TESTPATTERN5;

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("860000058");
        List<HT_MosSyouhn> mosSyouhnLst = syoriCTL.getMosSyouhnsBySyutkkbn(C_SyutkKbn.SYU);

        HT_MosSyouhn mosSyouhn = mosSyouhnLst.get(0);
        BM_SyouhnZokusei syouhnZokusei =
            bizDomManager.getSyouhnZokusei(mosSyouhn.getSyouhncd(), mosSyouhn.getSyouhnsdno());
        mosnaiCheckParam.setSyuSyouhnZokusei(syouhnZokusei);

        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setSysKbn(C_SysKbn.SKEI);
        mosnaiCheckParam.setTkrtkKinyuuknUmuKbn(C_UmuKbn.NONE);
        mosnaiCheckParam.setKydsskKinyuuknUmuKbn(C_UmuKbn.NONE);
        List<HT_HubiMsg> hubiMsgLst = syoriCTL.getHubiMsgs();
        mosnaiCheckParam.setListHubiMsg(hubiMsgLst);
        Tuusan tuusan = SWAKInjector.getInstance(Tuusan.class);
        checkTuusan.exec(mosnaiCheckParam, tuusan);

        exNumericEquals(hubiMsgLst.size(), 1, "不備メッセージテーブルエンティティリストの件数");
        exStringEquals(hubiMsgLst.get(0).getMosno(), "860000058", "申込番号");
        exNumericEquals(hubiMsgLst.get(0).getRenno(), 1, "連番");
        exStringEquals(hubiMsgLst.get(0).getHubimsg(), "【特認可能】年金原資限度額の１０円をオーバーしています。　年金原資　１００円", "不備メッセージ");
        exStringEquals(hubiMsgLst.get(0).getMessageId(), "THC1027", "メッセージＩＤ");
        exClassificationEquals(hubiMsgLst.get(0).getHubisyubetukbn(), C_HubisyubetuKbn.KETHORYU_HUBI, "不備種別区分");
        exClassificationEquals(mosnaiCheckParam.getSekmossakuseiErroutKbn(), C_SekmossakuseiErroutKbn.NONE,
            "設計書申込書作成エラー出力区分");
        exStringEquals(mosnaiCheckParam.getSekmossakuseiErrmsg1(), "", "設計書申込書作成エラーメッセージ１");
        exStringEquals(mosnaiCheckParam.getSekmossakuseiErrmsg2(), "", "設計書申込書作成エラーメッセージ２");
        exClassificationEquals(mosnaiCheckParam.getKouzokuSyoriJikkouKbn(), C_KouzokujkKbn.JIKKOU, "後続処理実行区分");
        exClassificationEquals(mosnaiCheckParam.getSakuinTsnKbn(), C_SakuintsnKbn.ERROR, "索引通算区分");
    }

    @Test
    @TestOrder(360)
    public void testExec_A36() {
        TuusanMockForSinkeiyaku.SYORIPTN = TuusanMockForSinkeiyaku.TESTPATTERN9;
        CheckSaiteiPMockForSinkeiyaku.SYORIPTN = CheckSaiteiPMockForSinkeiyaku.TESTPATTERN12;
        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("860000355");
        List<HT_MosSyouhn> mosSyouhnLst = syoriCTL.getMosSyouhnsBySyutkkbn(C_SyutkKbn.SYU);

        HT_MosSyouhn mosSyouhn = mosSyouhnLst.get(0);
        BM_SyouhnZokusei syouhnZokusei =
            bizDomManager.getSyouhnZokusei(mosSyouhn.getSyouhncd(), mosSyouhn.getSyouhnsdno());
        mosnaiCheckParam.setSyuSyouhnZokusei(syouhnZokusei);

        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setSysKbn(C_SysKbn.SKEI);

        mosnaiCheckParam.setPdateSRate(BizNumber.valueOf(7));
        mosnaiCheckParam.setHrbtJyousu(BizNumber.valueOf(5));
        mosnaiCheckParam.setNyuukinKawaseRate(BizNumber.valueOf(15));
        List<HT_HubiMsg> hubiMsgLst = syoriCTL.getHubiMsgs();
        mosnaiCheckParam.setListHubiMsg(hubiMsgLst);
        Tuusan tuusan = SWAKInjector.getInstance(Tuusan.class);

        checkTuusan.exec(mosnaiCheckParam, tuusan);

        exNumericEquals(hubiMsgLst.size(), 1, "不備メッセージテーブルエンティティリストの件数");
        exStringEquals(hubiMsgLst.get(0).getMosno(), "860000355", "申込番号");
        exNumericEquals(hubiMsgLst.get(0).getRenno(), 1, "連番");
        exStringEquals(hubiMsgLst.get(0).getHubimsg(),
            "（特認済）ふるはーとＦⅡ通算Ｓ限度額の５０円をオーバーしています。　ご加入できません。",
            "不備メッセージ");
        exStringEquals(hubiMsgLst.get(0).getMessageId(), "KHC1167", "メッセージＩＤ");
        exClassificationEquals(hubiMsgLst.get(0).getHubisyubetukbn(), C_HubisyubetuKbn.KETHORYU_HUBI, "不備種別区分");
        exClassificationEquals(mosnaiCheckParam.getSekmossakuseiErroutKbn(), C_SekmossakuseiErroutKbn.NONE,
            "設計書申込書作成エラー出力区分");
        exStringEquals(mosnaiCheckParam.getSekmossakuseiErrmsg1(), "", "設計書申込書作成エラーメッセージ１");
        exStringEquals(mosnaiCheckParam.getSekmossakuseiErrmsg2(), "", "設計書申込書作成エラーメッセージ２");
        exClassificationEquals(mosnaiCheckParam.getKouzokuSyoriJikkouKbn(), C_KouzokujkKbn.JIKKOU, "後続処理実行区分");
        exClassificationEquals(mosnaiCheckParam.getSakuinTsnKbn(), C_SakuintsnKbn.ERROR, "索引通算区分");
    }

    @Test
    @TestOrder(370)
    public void testExec_A37() {
        TuusanMockForSinkeiyaku.SYORIPTN = TuusanMockForSinkeiyaku.TESTPATTERN5;

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("860000355");
        List<HT_MosSyouhn> mosSyouhnLst = syoriCTL.getMosSyouhnsBySyutkkbn(C_SyutkKbn.SYU);

        HT_MosSyouhn mosSyouhn = mosSyouhnLst.get(0);
        BM_SyouhnZokusei syouhnZokusei =
            bizDomManager.getSyouhnZokusei(mosSyouhn.getSyouhncd(), mosSyouhn.getSyouhnsdno());
        mosnaiCheckParam.setSyuSyouhnZokusei(syouhnZokusei);

        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setSysKbn(C_SysKbn.SKEI);
        mosnaiCheckParam.setTkrtkKinyuuknUmuKbn(C_UmuKbn.ARI);
        mosnaiCheckParam.setKydsskKinyuuknUmuKbn(C_UmuKbn.NONE);
        List<HT_HubiMsg> hubiMsgLst = syoriCTL.getHubiMsgs();
        mosnaiCheckParam.setListHubiMsg(hubiMsgLst);
        Tuusan tuusan = SWAKInjector.getInstance(Tuusan.class);
        mosnaiCheckParam.setSakuinTsnKbn(C_SakuintsnKbn.ERROR);
        checkTuusan.exec(mosnaiCheckParam, tuusan);

        exNumericEquals(hubiMsgLst.size(), 0, "不備メッセージテーブルエンティティリストの件数");
        exClassificationEquals(mosnaiCheckParam.getSekmossakuseiErroutKbn(), C_SekmossakuseiErroutKbn.NONE,
            "設計書申込書作成エラー出力区分");
        exStringEquals(mosnaiCheckParam.getSekmossakuseiErrmsg1(), "", "設計書申込書作成エラーメッセージ１");
        exStringEquals(mosnaiCheckParam.getSekmossakuseiErrmsg2(), "", "設計書申込書作成エラーメッセージ２");
        exClassificationEquals(mosnaiCheckParam.getKouzokuSyoriJikkouKbn(), C_KouzokujkKbn.JIKKOU, "後続処理実行区分");
        exClassificationEquals(mosnaiCheckParam.getSakuinTsnKbn(), C_SakuintsnKbn.ERROR, "索引通算区分");
    }

    @Test
    @TestOrder(380)
    public void testExec_A38() {
        TuusanMockForSinkeiyaku.SYORIPTN = TuusanMockForSinkeiyaku.TESTPATTERN26;
        KeisanSPMockForSinkeiyaku.SYORIPTN = KeisanSPMockForSinkeiyaku.TESTPATTERN26;
        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("860000017");
        List<HT_MosSyouhn> mosSyouhnLst = syoriCTL.getMosSyouhnsBySyutkkbn(C_SyutkKbn.SYU);

        HT_MosSyouhn mosSyouhn = mosSyouhnLst.get(0);
        BM_SyouhnZokusei syouhnZokusei =
            bizDomManager.getSyouhnZokusei(mosSyouhn.getSyouhncd(), mosSyouhn.getSyouhnsdno());
        mosnaiCheckParam.setSyuSyouhnZokusei(syouhnZokusei);

        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setSysKbn(C_SysKbn.SKEI);
        mosnaiCheckParam.setTkrtkKinyuuknUmuKbn(C_UmuKbn.ARI);
        mosnaiCheckParam.setKydsskKinyuuknUmuKbn(C_UmuKbn.NONE);
        List<HT_HubiMsg> hubiMsgLst = syoriCTL.getHubiMsgs();
        mosnaiCheckParam.setListHubiMsg(hubiMsgLst);
        Tuusan tuusan = SWAKInjector.getInstance(Tuusan.class);
        checkTuusan.exec(mosnaiCheckParam, tuusan);

        exNumericEquals(hubiMsgLst.size(), 1, "不備メッセージテーブルエンティティリストの件数");
        exStringEquals(hubiMsgLst.get(0).getMosno(), "860000017", "申込番号");
        exNumericEquals(hubiMsgLst.get(0).getRenno(), 1, "連番");
        exStringEquals(hubiMsgLst.get(0).getHubimsg(), "【特認可能】通算総死亡Ｓ限度額の１００円をオーバーしています。　保険金額は９５円までにしてください。", "不備メッセージ");
        exStringEquals(hubiMsgLst.get(0).getMessageId(), "THC1043", "メッセージＩＤ");
        exClassificationEquals(hubiMsgLst.get(0).getHubisyubetukbn(), C_HubisyubetuKbn.KETHORYU_HUBI, "不備種別区分");
        exClassificationEquals(mosnaiCheckParam.getSekmossakuseiErroutKbn(), C_SekmossakuseiErroutKbn.NONE,
            "設計書申込書作成エラー出力区分");
        exStringEquals(mosnaiCheckParam.getSekmossakuseiErrmsg1(), "", "設計書申込書作成エラーメッセージ１");
        exStringEquals(mosnaiCheckParam.getSekmossakuseiErrmsg2(), "", "設計書申込書作成エラーメッセージ２");
        exClassificationEquals(mosnaiCheckParam.getKouzokuSyoriJikkouKbn(), C_KouzokujkKbn.JIKKOU, "後続処理実行区分");
        exClassificationEquals(mosnaiCheckParam.getSakuinTsnKbn(), C_SakuintsnKbn.ERROR, "索引通算区分");
    }
    @Test
    @TestOrder(390)
    public void testExec_A39() {
        TuusanMockForSinkeiyaku.SYORIPTN = TuusanMockForSinkeiyaku.TESTPATTERN69;

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("860000355");
        List<HT_MosSyouhn> mosSyouhnLst = syoriCTL.getMosSyouhnsBySyutkkbn(C_SyutkKbn.SYU);

        HT_MosSyouhn mosSyouhn = mosSyouhnLst.get(0);
        BM_SyouhnZokusei syouhnZokusei =
            bizDomManager.getSyouhnZokusei(mosSyouhn.getSyouhncd(), mosSyouhn.getSyouhnsdno());
        mosnaiCheckParam.setSyuSyouhnZokusei(syouhnZokusei);

        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setSysKbn(C_SysKbn.SKEI);
        mosnaiCheckParam.setTkrtkKinyuuknUmuKbn(C_UmuKbn.ARI);
        mosnaiCheckParam.setKydsskKinyuuknUmuKbn(C_UmuKbn.NONE);
        List<HT_HubiMsg> hubiMsgLst = syoriCTL.getHubiMsgs();
        mosnaiCheckParam.setListHubiMsg(hubiMsgLst);
        Tuusan tuusan = SWAKInjector.getInstance(Tuusan.class);
        mosnaiCheckParam.setSakuinTsnKbn(C_SakuintsnKbn.SEIJYOU);
        checkTuusan.exec(mosnaiCheckParam, tuusan);

        exNumericEquals(hubiMsgLst.size(), 1, "不備メッセージテーブルエンティティリストの件数");
        exClassificationEquals(mosnaiCheckParam.getSekmossakuseiErroutKbn(), C_SekmossakuseiErroutKbn.NONE,
            "設計書申込書作成エラー出力区分");
        exStringEquals(mosnaiCheckParam.getSekmossakuseiErrmsg1(), "", "設計書申込書作成エラーメッセージ１");
        exStringEquals(mosnaiCheckParam.getSekmossakuseiErrmsg2(), "", "設計書申込書作成エラーメッセージ２");
        exClassificationEquals(mosnaiCheckParam.getKouzokuSyoriJikkouKbn(), C_KouzokujkKbn.JIKKOU, "後続処理実行区分");
        exClassificationEquals(mosnaiCheckParam.getSakuinTsnKbn(), C_SakuintsnKbn.ERROR, "索引通算区分");
    }

    @Test
    @TestOrder(400)
    public void testExec_A40() {
        TuusanMockForSinkeiyaku.SYORIPTN = TuusanMockForSinkeiyaku.TESTPATTERN68;

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("860000355");
        List<HT_MosSyouhn> mosSyouhnLst = syoriCTL.getMosSyouhnsBySyutkkbn(C_SyutkKbn.SYU);

        HT_MosSyouhn mosSyouhn = mosSyouhnLst.get(0);
        BM_SyouhnZokusei syouhnZokusei =
            bizDomManager.getSyouhnZokusei(mosSyouhn.getSyouhncd(), mosSyouhn.getSyouhnsdno());
        mosnaiCheckParam.setSyuSyouhnZokusei(syouhnZokusei);

        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setSysKbn(C_SysKbn.SKEI);
        mosnaiCheckParam.setTkrtkKinyuuknUmuKbn(C_UmuKbn.ARI);
        mosnaiCheckParam.setKydsskKinyuuknUmuKbn(C_UmuKbn.NONE);
        List<HT_HubiMsg> hubiMsgLst = syoriCTL.getHubiMsgs();
        mosnaiCheckParam.setListHubiMsg(hubiMsgLst);
        Tuusan tuusan = SWAKInjector.getInstance(Tuusan.class);
        mosnaiCheckParam.setSakuinTsnKbn(C_SakuintsnKbn.SEIJYOU);
        checkTuusan.exec(mosnaiCheckParam, tuusan);

        exNumericEquals(hubiMsgLst.size(), 0, "不備メッセージテーブルエンティティリストの件数");
        exClassificationEquals(mosnaiCheckParam.getSekmossakuseiErroutKbn(), C_SekmossakuseiErroutKbn.NONE,
            "設計書申込書作成エラー出力区分");
        exStringEquals(mosnaiCheckParam.getSekmossakuseiErrmsg1(), "", "設計書申込書作成エラーメッセージ１");
        exStringEquals(mosnaiCheckParam.getSekmossakuseiErrmsg2(), "", "設計書申込書作成エラーメッセージ２");
        exClassificationEquals(mosnaiCheckParam.getKouzokuSyoriJikkouKbn(), C_KouzokujkKbn.JIKKOU, "後続処理実行区分");
        exClassificationEquals(mosnaiCheckParam.getSakuinTsnKbn(), C_SakuintsnKbn.SEIJYOU, "索引通算区分");
    }

    @Test
    @TestOrder(410)
    public void testExec_A41() {
        TuusanMockForSinkeiyaku.SYORIPTN = TuusanMockForSinkeiyaku.TESTPATTERN2;
        KeisanSPMockForSinkeiyaku.SYORIPTN = KeisanSPMockForSinkeiyaku.TESTPATTERN2;

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("860000140");
        List<HT_MosSyouhn> mosSyouhnLst = syoriCTL.getMosSyouhnsBySyutkkbn(C_SyutkKbn.SYU);

        HT_MosSyouhn mosSyouhn = mosSyouhnLst.get(0);
        BM_SyouhnZokusei syouhnZokusei =
            bizDomManager.getSyouhnZokusei(mosSyouhn.getSyouhncd(), mosSyouhn.getSyouhnsdno());
        mosnaiCheckParam.setSyuSyouhnZokusei(syouhnZokusei);

        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setSysKbn(C_SysKbn.ESHIEN);
        List<HT_HubiMsg> hubiMsgLst = syoriCTL.getHubiMsgs();
        mosnaiCheckParam.setListHubiMsg(hubiMsgLst);
        Tuusan tuusan = SWAKInjector.getInstance(Tuusan.class);

        checkTuusan.exec(mosnaiCheckParam, tuusan);

        exNumericEquals(hubiMsgLst.size(), 0, "不備メッセージテーブルエンティティリストの件数");
        exClassificationEquals(mosnaiCheckParam.getSekmossakuseiErroutKbn(), C_SekmossakuseiErroutKbn.GAMEN,
            "設計書申込書作成エラー出力区分");
        exStringEquals(mosnaiCheckParam.getSekmossakuseiErrmsg1(), "", "設計書申込書作成エラーメッセージ１");
        exStringEquals(mosnaiCheckParam.getSekmossakuseiErrmsg2(), "通算保険金額が限度額を超えています　ご加入できません", "設計書申込書作成エラーメッセージ２");
        exClassificationEquals(mosnaiCheckParam.getKouzokuSyoriJikkouKbn(), C_KouzokujkKbn.NONE, "後続処理実行区分");
        exClassificationEquals(mosnaiCheckParam.getSakuinTsnKbn(), C_SakuintsnKbn.ERROR, "索引通算区分");
    }

    @Test
    @TestOrder(420)
    public void testExec_A42() {
        TuusanMockForSinkeiyaku.SYORIPTN = TuusanMockForSinkeiyaku.TESTPATTERN73;

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("860000389");
        List<HT_MosSyouhn> mosSyouhnLst = syoriCTL.getMosSyouhnsBySyutkkbn(C_SyutkKbn.SYU);

        HT_MosSyouhn mosSyouhn = mosSyouhnLst.get(0);
        BM_SyouhnZokusei syouhnZokusei =
            bizDomManager.getSyouhnZokusei(mosSyouhn.getSyouhncd(), mosSyouhn.getSyouhnsdno());
        mosnaiCheckParam.setSyuSyouhnZokusei(syouhnZokusei);

        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setSysKbn(C_SysKbn.SKEI);
        mosnaiCheckParam.setTkrtkKinyuuknUmuKbn(C_UmuKbn.ARI);
        mosnaiCheckParam.setKydsskKinyuuknUmuKbn(C_UmuKbn.NONE);
        List<HT_HubiMsg> hubiMsgLst = syoriCTL.getHubiMsgs();
        mosnaiCheckParam.setListHubiMsg(hubiMsgLst);
        Tuusan tuusan = SWAKInjector.getInstance(Tuusan.class);
        checkTuusan.exec(mosnaiCheckParam, tuusan);

        exNumericEquals(hubiMsgLst.size(), 0, "不備メッセージテーブルエンティティリストの件数");
        exClassificationEquals(mosnaiCheckParam.getSekmossakuseiErroutKbn(), C_SekmossakuseiErroutKbn.NONE,
            "設計書申込書作成エラー出力区分");
        exStringEquals(mosnaiCheckParam.getSekmossakuseiErrmsg1(), "", "設計書申込書作成エラーメッセージ１");
        exStringEquals(mosnaiCheckParam.getSekmossakuseiErrmsg2(), "", "設計書申込書作成エラーメッセージ２");
        exClassificationEquals(mosnaiCheckParam.getKouzokuSyoriJikkouKbn(), C_KouzokujkKbn.JIKKOU, "後続処理実行区分");
        exClassificationEquals(mosnaiCheckParam.getSakuinTsnKbn(), C_SakuintsnKbn.SEIJYOU, "索引通算区分");
    }

    @Test
    @TestOrder(430)
    public void testExec_A43() {
        TuusanMockForSinkeiyaku.SYORIPTN = TuusanMockForSinkeiyaku.TESTPATTERN68;

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("860000397");
        List<HT_MosSyouhn> mosSyouhnLst = syoriCTL.getMosSyouhnsBySyutkkbn(C_SyutkKbn.SYU);

        HT_MosSyouhn mosSyouhn = mosSyouhnLst.get(0);
        BM_SyouhnZokusei syouhnZokusei =
            bizDomManager.getSyouhnZokusei(mosSyouhn.getSyouhncd(), mosSyouhn.getSyouhnsdno());
        mosnaiCheckParam.setSyuSyouhnZokusei(syouhnZokusei);

        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setSysKbn(C_SysKbn.SKEI);
        mosnaiCheckParam.setTkrtkKinyuuknUmuKbn(C_UmuKbn.ARI);
        mosnaiCheckParam.setKydsskKinyuuknUmuKbn(C_UmuKbn.NONE);
        List<HT_HubiMsg> hubiMsgLst = syoriCTL.getHubiMsgs();
        mosnaiCheckParam.setListHubiMsg(hubiMsgLst);
        Tuusan tuusan = SWAKInjector.getInstance(Tuusan.class);
        checkTuusan.exec(mosnaiCheckParam, tuusan);

        exNumericEquals(hubiMsgLst.size(), 0, "不備メッセージテーブルエンティティリストの件数");
        exClassificationEquals(mosnaiCheckParam.getSekmossakuseiErroutKbn(), C_SekmossakuseiErroutKbn.NONE,
            "設計書申込書作成エラー出力区分");
        exStringEquals(mosnaiCheckParam.getSekmossakuseiErrmsg1(), "", "設計書申込書作成エラーメッセージ１");
        exStringEquals(mosnaiCheckParam.getSekmossakuseiErrmsg2(), "", "設計書申込書作成エラーメッセージ２");
        exClassificationEquals(mosnaiCheckParam.getKouzokuSyoriJikkouKbn(), C_KouzokujkKbn.JIKKOU, "後続処理実行区分");
        exClassificationEquals(mosnaiCheckParam.getSakuinTsnKbn(), C_SakuintsnKbn.SEIJYOU, "索引通算区分");
    }

    @Test
    @TestOrder(440)
    public void testExec_A44() {
        TuusanMockForSinkeiyaku.SYORIPTN = TuusanMockForSinkeiyaku.TESTPATTERN2;
        KeisanSPMockForSinkeiyaku.SYORIPTN = KeisanSPMockForSinkeiyaku.TESTPATTERN2;

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("860000405");
        List<HT_MosSyouhn> mosSyouhnLst = syoriCTL.getMosSyouhnsBySyutkkbn(C_SyutkKbn.SYU);

        HT_MosSyouhn mosSyouhn = mosSyouhnLst.get(0);
        BM_SyouhnZokusei syouhnZokusei =
            bizDomManager.getSyouhnZokusei(mosSyouhn.getSyouhncd(), mosSyouhn.getSyouhnsdno());
        mosnaiCheckParam.setSyuSyouhnZokusei(syouhnZokusei);

        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setSysKbn(C_SysKbn.ESHIEN);
        List<HT_HubiMsg> hubiMsgLst = syoriCTL.getHubiMsgs();
        mosnaiCheckParam.setListHubiMsg(hubiMsgLst);
        Tuusan tuusan = SWAKInjector.getInstance(Tuusan.class);

        try {
            checkTuusan.exec(mosnaiCheckParam, tuusan);
        } catch (CommonBizAppException e) {
            exStringEquals(e.getMessage(), "システム整合性エラーです。申込番号=860000405", "エラーメッセージ");
        }
    }

    @Test
    @TestOrder(450)
    public void testExec_A45() {
        TuusanMockForSinkeiyaku.SYORIPTN = TuusanMockForSinkeiyaku.TESTPATTERN70;

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("860000413");
        List<HT_MosSyouhn> mosSyouhnLst = syoriCTL.getMosSyouhnsBySyutkkbn(C_SyutkKbn.SYU);

        HT_MosSyouhn mosSyouhn = mosSyouhnLst.get(0);
        BM_SyouhnZokusei syouhnZokusei =
            bizDomManager.getSyouhnZokusei(mosSyouhn.getSyouhncd(), mosSyouhn.getSyouhnsdno());
        mosnaiCheckParam.setSyuSyouhnZokusei(syouhnZokusei);

        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setSysKbn(C_SysKbn.SKEI);
        mosnaiCheckParam.setTkrtkKinyuuknUmuKbn(C_UmuKbn.ARI);
        mosnaiCheckParam.setKydsskKinyuuknUmuKbn(C_UmuKbn.NONE);
        List<HT_HubiMsg> hubiMsgLst = syoriCTL.getHubiMsgs();
        mosnaiCheckParam.setListHubiMsg(hubiMsgLst);
        Tuusan tuusan = SWAKInjector.getInstance(Tuusan.class);
        checkTuusan.exec(mosnaiCheckParam, tuusan);

        exNumericEquals(hubiMsgLst.size(), 1, "不備メッセージテーブルエンティティリストの件数");
        exStringEquals(hubiMsgLst.get(0).getMosno(), "860000413", "申込番号");
        exNumericEquals(hubiMsgLst.get(0).getRenno(), 1, "連番");
        exStringEquals(hubiMsgLst.get(0).getHubimsg(), "年齢別通算総死亡Ｓ限度額の１２５円をオーバーしています。　年齢別通算総死亡Ｓ　１５３円", "不備メッセージ");
        exStringEquals(hubiMsgLst.get(0).getMessageId(), "EHC1030", "メッセージＩＤ");
        exClassificationEquals(hubiMsgLst.get(0).getHubisyubetukbn(), C_HubisyubetuKbn.KETHORYU_HUBI, "不備種別区分");
        exClassificationEquals(mosnaiCheckParam.getSekmossakuseiErroutKbn(), C_SekmossakuseiErroutKbn.NONE,
            "設計書申込書作成エラー出力区分");
        exStringEquals(mosnaiCheckParam.getSekmossakuseiErrmsg1(), "", "設計書申込書作成エラーメッセージ１");
        exStringEquals(mosnaiCheckParam.getSekmossakuseiErrmsg2(), "", "設計書申込書作成エラーメッセージ２");
        exClassificationEquals(mosnaiCheckParam.getKouzokuSyoriJikkouKbn(), C_KouzokujkKbn.JIKKOU, "後続処理実行区分");
        exClassificationEquals(mosnaiCheckParam.getSakuinTsnKbn(), C_SakuintsnKbn.ERROR, "索引通算区分");
    }

    @Test
    @TestOrder(460)
    public void testExec_A46() {
        TuusanMockForSinkeiyaku.SYORIPTN = TuusanMockForSinkeiyaku.TESTPATTERN71;

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("860000413");
        List<HT_MosSyouhn> mosSyouhnLst = syoriCTL.getMosSyouhnsBySyutkkbn(C_SyutkKbn.SYU);

        HT_MosSyouhn mosSyouhn = mosSyouhnLst.get(0);
        BM_SyouhnZokusei syouhnZokusei =
            bizDomManager.getSyouhnZokusei(mosSyouhn.getSyouhncd(), mosSyouhn.getSyouhnsdno());
        mosnaiCheckParam.setSyuSyouhnZokusei(syouhnZokusei);

        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setSysKbn(C_SysKbn.SKEI);
        mosnaiCheckParam.setTkrtkKinyuuknUmuKbn(C_UmuKbn.ARI);
        mosnaiCheckParam.setKydsskKinyuuknUmuKbn(C_UmuKbn.NONE);
        List<HT_HubiMsg> hubiMsgLst = syoriCTL.getHubiMsgs();
        mosnaiCheckParam.setListHubiMsg(hubiMsgLst);
        Tuusan tuusan = SWAKInjector.getInstance(Tuusan.class);
        checkTuusan.exec(mosnaiCheckParam, tuusan);

        exNumericEquals(hubiMsgLst.size(), 0, "不備メッセージテーブルエンティティリストの件数");
        exClassificationEquals(mosnaiCheckParam.getSekmossakuseiErroutKbn(), C_SekmossakuseiErroutKbn.NONE,
            "設計書申込書作成エラー出力区分");
        exStringEquals(mosnaiCheckParam.getSekmossakuseiErrmsg1(), "", "設計書申込書作成エラーメッセージ１");
        exStringEquals(mosnaiCheckParam.getSekmossakuseiErrmsg2(), "", "設計書申込書作成エラーメッセージ２");
        exClassificationEquals(mosnaiCheckParam.getKouzokuSyoriJikkouKbn(), C_KouzokujkKbn.JIKKOU, "後続処理実行区分");
        exClassificationEquals(mosnaiCheckParam.getSakuinTsnKbn(), C_SakuintsnKbn.SEIJYOU, "索引通算区分");
    }

    @Test
    @TestOrder(470)
    public void testExec_A47() {
        TuusanMockForSinkeiyaku.SYORIPTN = TuusanMockForSinkeiyaku.TESTPATTERN72;

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("860000413");
        List<HT_MosSyouhn> mosSyouhnLst = syoriCTL.getMosSyouhnsBySyutkkbn(C_SyutkKbn.SYU);

        HT_MosSyouhn mosSyouhn = mosSyouhnLst.get(0);
        BM_SyouhnZokusei syouhnZokusei =
            bizDomManager.getSyouhnZokusei(mosSyouhn.getSyouhncd(), mosSyouhn.getSyouhnsdno());
        mosnaiCheckParam.setSyuSyouhnZokusei(syouhnZokusei);

        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setSysKbn(C_SysKbn.SKEI);
        mosnaiCheckParam.setTkrtkKinyuuknUmuKbn(C_UmuKbn.ARI);
        mosnaiCheckParam.setKydsskKinyuuknUmuKbn(C_UmuKbn.NONE);
        List<HT_HubiMsg> hubiMsgLst = syoriCTL.getHubiMsgs();
        mosnaiCheckParam.setListHubiMsg(hubiMsgLst);
        Tuusan tuusan = SWAKInjector.getInstance(Tuusan.class);
        checkTuusan.exec(mosnaiCheckParam, tuusan);

        exNumericEquals(hubiMsgLst.size(), 1, "不備メッセージテーブルエンティティリストの件数");
        exStringEquals(hubiMsgLst.get(0).getMosno(), "860000413", "申込番号");
        exNumericEquals(hubiMsgLst.get(0).getRenno(), 1, "連番");
        exStringEquals(hubiMsgLst.get(0).getHubimsg(), "年齢年収通算総死亡Ｓ限度額の１２５，０００，０００円をオーバーしています。　年齢年収通算総死亡Ｓ　１２５，０００，００１円", "不備メッセージ");
        exStringEquals(hubiMsgLst.get(0).getMessageId(), "EHC1032", "メッセージＩＤ");
        exClassificationEquals(hubiMsgLst.get(0).getHubisyubetukbn(), C_HubisyubetuKbn.KETHORYU_HUBI, "不備種別区分");
        exClassificationEquals(mosnaiCheckParam.getSekmossakuseiErroutKbn(), C_SekmossakuseiErroutKbn.NONE,
            "設計書申込書作成エラー出力区分");
        exStringEquals(mosnaiCheckParam.getSekmossakuseiErrmsg1(), "", "設計書申込書作成エラーメッセージ１");
        exStringEquals(mosnaiCheckParam.getSekmossakuseiErrmsg2(), "", "設計書申込書作成エラーメッセージ２");
        exClassificationEquals(mosnaiCheckParam.getKouzokuSyoriJikkouKbn(), C_KouzokujkKbn.JIKKOU, "後続処理実行区分");
        exClassificationEquals(mosnaiCheckParam.getSakuinTsnKbn(), C_SakuintsnKbn.ERROR, "索引通算区分");
        exBooleanEquals(mosnaiCheckParam.getNensyuTuusanSOverHanteiKekka(), true, "年収通算Ｓオーバー契約判定結果");
    }

    @Test
    @TestOrder(480)
    public void testExec_A48() {
        TuusanMockForSinkeiyaku.SYORIPTN = TuusanMockForSinkeiyaku.TESTPATTERN72;

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("860000413");
        List<HT_MosSyouhn> mosSyouhnLst = syoriCTL.getMosSyouhnsBySyutkkbn(C_SyutkKbn.SYU);

        HT_MosSyouhn mosSyouhn = mosSyouhnLst.get(0);
        BM_SyouhnZokusei syouhnZokusei =
            bizDomManager.getSyouhnZokusei(mosSyouhn.getSyouhncd(), mosSyouhn.getSyouhnsdno());
        mosnaiCheckParam.setSyuSyouhnZokusei(syouhnZokusei);

        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setSysKbn(C_SysKbn.ESHIEN);
        mosnaiCheckParam.setTkrtkKinyuuknUmuKbn(C_UmuKbn.ARI);
        mosnaiCheckParam.setKydsskKinyuuknUmuKbn(C_UmuKbn.NONE);
        List<HT_HubiMsg> hubiMsgLst = syoriCTL.getHubiMsgs();
        mosnaiCheckParam.setListHubiMsg(hubiMsgLst);
        Tuusan tuusan = SWAKInjector.getInstance(Tuusan.class);
        checkTuusan.exec(mosnaiCheckParam, tuusan);

        exNumericEquals(hubiMsgLst.size(), 0, "不備メッセージテーブルエンティティリストの件数");
        exClassificationEquals(mosnaiCheckParam.getSekmossakuseiErroutKbn(), C_SekmossakuseiErroutKbn.NONE,
            "設計書申込書作成エラー出力区分");
        exStringEquals(mosnaiCheckParam.getSekmossakuseiErrmsg1(), "", "設計書申込書作成エラーメッセージ１");
        exStringEquals(mosnaiCheckParam.getSekmossakuseiErrmsg2(), "", "設計書申込書作成エラーメッセージ２");
        exClassificationEquals(mosnaiCheckParam.getKouzokuSyoriJikkouKbn(), C_KouzokujkKbn.JIKKOU, "後続処理実行区分");
        exClassificationEquals(mosnaiCheckParam.getSakuinTsnKbn(), C_SakuintsnKbn.ERROR, "索引通算区分");
        exBooleanEquals(mosnaiCheckParam.getNensyuTuusanSOverHanteiKekka(), true, "年収通算Ｓオーバー契約判定結果");
    }


}
