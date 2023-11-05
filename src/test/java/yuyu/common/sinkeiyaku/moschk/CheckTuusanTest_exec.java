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
import jp.co.slcs.swak.number.BizCurrency;

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
import yuyu.def.classification.C_BosyuusysctrlKbn;
import yuyu.def.classification.C_Channelcd;
import yuyu.def.classification.C_HubisyubetuKbn;
import yuyu.def.classification.C_KouzokujkKbn;
import yuyu.def.classification.C_PtratkituukasiteiKbn;
import yuyu.def.classification.C_SakuintsnKbn;
import yuyu.def.classification.C_SekmossakuseiErroutKbn;
import yuyu.def.classification.C_SysKbn;
import yuyu.def.classification.C_SyutkKbn;
import yuyu.def.classification.C_UmuKbn;
import yuyu.def.db.entity.BM_SyouhnZokusei;
import yuyu.def.db.entity.HT_HubiMsg;
import yuyu.def.db.entity.HT_MosKihon;
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
public class CheckTuusanTest_exec {

    @Inject
    private CheckTuusan checkTuusan;

    @Inject
    private MosnaiCheckParam mosnaiCheckParam;

    @Inject
    private SinkeiyakuDomManager sinkeiyakuDomManager;

    @Inject
    private BizDomManager bizDomManager;

    private final static String fileName = "UT_SP_単体テスト仕様書_通算チェック";
    private final static String sheetName = "INデータ";

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

        TuusanMockForSinkeiyaku.caller = CheckTuusanTest_exec.class;
        CheckSaiteiPMockForSinkeiyaku.caller = CheckTuusanTest_exec.class;
        KeisanSPMockForSinkeiyaku.caller = CheckTuusanTest_exec.class;
        KeisanGaikakanzanMockForSinkeiyaku.caller = CheckTuusanTest_exec.class;
        GetKiteiCheckYenkansangkMockForSinkeiyaku.caller = CheckTuusanTest_exec.class;
        GetKiteiCheckYenkansangkMockForSinkeiyaku.LoopFlag = 0;
    }

    @BeforeClass
    @Transactional
    public static void insertTestData() {
        try {
            TestDataMaker testDataMaker = new TestDataMaker();
            HashMap<String, Map<String, List<Map<String, String>>>> testDataAndTblMap;
            testDataAndTblMap = testDataMaker.getInData(CheckTuusanTest_exec.class, fileName, sheetName);
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
        bizDomManager.delete(bizDomManager.getAllChkKokutiTuusanS());
        bizDomManager.delete(bizDomManager.getAllChkNkgns());
        bizDomManager.delete(bizDomManager.getAllChkItijibrTuusanS());
        bizDomManager.delete(bizDomManager.getAllChkJhTuusanS());
        bizDomManager.delete(bizDomManager.getAllChkJhKokutiTuusanS());
        bizDomManager.delete(bizDomManager.getAllChkJhNkgns());
        bizDomManager.delete(bizDomManager.getAllChkNensyuuBairitu());
        bizDomManager.delete(bizDomManager.getAllChkKykDairitenTuusanS());
        bizDomManager.delete(bizDomManager.getAllChkSyokugyou());
        bizDomManager.delete(bizDomManager.getAllChkItijibrTuusanP());
        bizDomManager.delete(bizDomManager.getAllChkHrkPTani());
        bizDomManager.delete(bizDomManager.getAllKijyungkHanteiKawaseRate());
    }

    @AfterClass
    public static void testClear() {
        TuusanMockForSinkeiyaku.caller = CheckTuusanTest_exec.class;
        TuusanMockForSinkeiyaku.SYORIPTN = null;
        CheckSaiteiPMockForSinkeiyaku.caller = CheckTuusanTest_exec.class;
        CheckSaiteiPMockForSinkeiyaku.SYORIPTN = null;
        KeisanSPMockForSinkeiyaku.caller = CheckTuusanTest_exec.class;
        KeisanSPMockForSinkeiyaku.SYORIPTN = null;
        KeisanGaikakanzanMockForSinkeiyaku.caller = CheckTuusanTest_exec.class;
        KeisanGaikakanzanMockForSinkeiyaku.SYORIPTN = null;
        GetKiteiCheckYenkansangkMockForSinkeiyaku.caller = CheckTuusanTest_exec.class;
        GetKiteiCheckYenkansangkMockForSinkeiyaku.SYORIPTN = null;
        GetKiteiCheckYenkansangkMockForSinkeiyaku.LoopFlag = 0;
        MockObjectManager.initialize();
    }

    @Test(expected = CommonBizAppException.class)
    @TestOrder(10)
    public void testExec_A1() {
        TuusanMockForSinkeiyaku.SYORIPTN = null;
        CheckSaiteiPMockForSinkeiyaku.SYORIPTN = null;
        KeisanSPMockForSinkeiyaku.SYORIPTN = null;
        KeisanGaikakanzanMockForSinkeiyaku.SYORIPTN = null;
        GetKiteiCheckYenkansangkMockForSinkeiyaku.SYORIPTN = null;
        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("791112220");
        List<HT_MosSyouhn> mosSyouhnLst = syoriCTL.getMosSyouhnsBySyutkkbn(C_SyutkKbn.SYU);
        Tuusan tuusan = SWAKInjector.getInstance(Tuusan.class);
        if (mosSyouhnLst.size() > 0) {
            HT_MosSyouhn mosSyouhn = mosSyouhnLst.get(0);
            BM_SyouhnZokusei syouhnZokusei =
                bizDomManager.getSyouhnZokusei(mosSyouhn.getSyouhncd(), mosSyouhn.getSyouhnsdno());
            mosnaiCheckParam.setSyuSyouhnZokusei(syouhnZokusei);
        }
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        try {
            checkTuusan.exec(mosnaiCheckParam, tuusan);
        } catch (CommonBizAppException e) {
            exStringEquals(e.getMessage(), "システム整合性エラーです。主契約申込商品件数異常 申込番号：791112220", "エラーメッセージ");
            throw e;
        }
    }

    @Test(expected = CommonBizAppException.class)
    @TestOrder(20)
    public void testExec_A2() {
        CheckSaiteiPMockForSinkeiyaku.SYORIPTN = null;
        KeisanSPMockForSinkeiyaku.SYORIPTN = null;
        KeisanGaikakanzanMockForSinkeiyaku.SYORIPTN = null;
        GetKiteiCheckYenkansangkMockForSinkeiyaku.SYORIPTN = null;
        TuusanMockForSinkeiyaku.SYORIPTN = TuusanMockForSinkeiyaku.TESTPATTERN1;
        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("791112238");
        List<HT_MosSyouhn> mosSyouhnLst = syoriCTL.getMosSyouhnsBySyutkkbn(C_SyutkKbn.SYU);
        Tuusan tuusan = SWAKInjector.getInstance(Tuusan.class);

        if (mosSyouhnLst.size() > 0) {
            HT_MosSyouhn mosSyouhn = mosSyouhnLst.get(0);
            BM_SyouhnZokusei syouhnZokusei =
                bizDomManager.getSyouhnZokusei(mosSyouhn.getSyouhncd(), mosSyouhn.getSyouhnsdno());
            mosnaiCheckParam.setSyuSyouhnZokusei(syouhnZokusei);
        }
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setSysKbn(C_SysKbn.ESHIEN);
        try {
            checkTuusan.exec(mosnaiCheckParam, tuusan);
        } catch (CommonBizAppException e) {
            exStringEquals(e.getMessage(), "システム整合性エラーです。申込番号=791112238", "エラーメッセージ");
            throw e;
        }
    }

    @Test(expected = CommonBizAppException.class)
    @TestOrder(30)
    public void testExec_A3() {
        CheckSaiteiPMockForSinkeiyaku.SYORIPTN = null;
        KeisanSPMockForSinkeiyaku.SYORIPTN = null;
        KeisanGaikakanzanMockForSinkeiyaku.SYORIPTN = null;
        GetKiteiCheckYenkansangkMockForSinkeiyaku.SYORIPTN = null;
        TuusanMockForSinkeiyaku.SYORIPTN = TuusanMockForSinkeiyaku.TESTPATTERN2;
        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("791112238");
        List<HT_MosSyouhn> mosSyouhnLst = syoriCTL.getMosSyouhnsBySyutkkbn(C_SyutkKbn.SYU);
        Tuusan tuusan = SWAKInjector.getInstance(Tuusan.class);
        if (mosSyouhnLst.size() > 0) {
            HT_MosSyouhn mosSyouhn = mosSyouhnLst.get(0);
            BM_SyouhnZokusei syouhnZokusei =
                bizDomManager.getSyouhnZokusei(mosSyouhn.getSyouhncd(), mosSyouhn.getSyouhnsdno());
            mosnaiCheckParam.setSyuSyouhnZokusei(syouhnZokusei);
        }
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setSysKbn(C_SysKbn.ESHIEN);
        try {
            checkTuusan.exec(mosnaiCheckParam, tuusan);
        } catch (CommonBizAppException e) {
            exStringEquals(e.getMessage(), "システム整合性エラーです。申込番号=791112238", "エラーメッセージ");
            throw e;
        }
    }

    @Test(expected = CommonBizAppException.class)
    @TestOrder(40)
    public void testExec_A4() {
        CheckSaiteiPMockForSinkeiyaku.SYORIPTN = null;
        KeisanSPMockForSinkeiyaku.SYORIPTN = null;
        KeisanGaikakanzanMockForSinkeiyaku.SYORIPTN = null;
        GetKiteiCheckYenkansangkMockForSinkeiyaku.SYORIPTN = null;
        TuusanMockForSinkeiyaku.SYORIPTN = TuusanMockForSinkeiyaku.TESTPATTERN10;
        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("791112238");
        List<HT_MosSyouhn> mosSyouhnLst = syoriCTL.getMosSyouhnsBySyutkkbn(C_SyutkKbn.SYU);
        Tuusan tuusan = SWAKInjector.getInstance(Tuusan.class);
        if (mosSyouhnLst.size() > 0) {
            HT_MosSyouhn mosSyouhn = mosSyouhnLst.get(0);
            BM_SyouhnZokusei syouhnZokusei =
                bizDomManager.getSyouhnZokusei(mosSyouhn.getSyouhncd(), mosSyouhn.getSyouhnsdno());
            mosnaiCheckParam.setSyuSyouhnZokusei(syouhnZokusei);
        }
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setSysKbn(C_SysKbn.ESHIEN);
        try {
            checkTuusan.exec(mosnaiCheckParam, tuusan);
        } catch (CommonBizAppException e) {
            exStringEquals(e.getMessage(), "システム整合性エラーです。申込番号=791112238", "エラーメッセージ");
            throw e;
        }
    }

    @Test
    @TestOrder(50)
    public void testExec_A5() {
        KeisanSPMockForSinkeiyaku.SYORIPTN = null;
        KeisanGaikakanzanMockForSinkeiyaku.SYORIPTN = null;
        GetKiteiCheckYenkansangkMockForSinkeiyaku.SYORIPTN = null;
        TuusanMockForSinkeiyaku.SYORIPTN = TuusanMockForSinkeiyaku.TESTPATTERN10;
        CheckSaiteiPMockForSinkeiyaku.SYORIPTN = CheckSaiteiPMockForSinkeiyaku.TESTPATTERN1;
        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("791112345");
        List<HT_MosSyouhn> mosSyouhnLst = syoriCTL.getMosSyouhnsBySyutkkbn(C_SyutkKbn.SYU);
        Tuusan tuusan = SWAKInjector.getInstance(Tuusan.class);
        if (mosSyouhnLst.size() > 0) {
            HT_MosSyouhn mosSyouhn = mosSyouhnLst.get(0);
            BM_SyouhnZokusei syouhnZokusei =
                bizDomManager.getSyouhnZokusei(mosSyouhn.getSyouhncd(), mosSyouhn.getSyouhnsdno());
            mosnaiCheckParam.setSyuSyouhnZokusei(syouhnZokusei);
        }
        List<HT_HubiMsg> hubiMsgLst = syoriCTL.getHubiMsgs();
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setListHubiMsg(hubiMsgLst);
        mosnaiCheckParam.setSysKbn(C_SysKbn.SKEI);
        mosnaiCheckParam.setSakuinTsnKbn(C_SakuintsnKbn.SEIJYOU);
        mosnaiCheckParam.setKiteiCheckChannelCd(C_Channelcd.TIGIN);

        checkTuusan.exec(mosnaiCheckParam, tuusan);
        exNumericEquals(hubiMsgLst.size(), 0, "不備メッセージテーブルエンティティリストの件数");
        exClassificationEquals(mosnaiCheckParam.getSakuinTsnKbn(), C_SakuintsnKbn.SEIJYOU, "索引通算区分");

    }

    @Test(expected = CommonBizAppException.class)
    @TestOrder(60)
    public void testExec_A6() {
        CheckSaiteiPMockForSinkeiyaku.SYORIPTN = null;
        KeisanSPMockForSinkeiyaku.SYORIPTN = null;
        KeisanGaikakanzanMockForSinkeiyaku.SYORIPTN = null;
        GetKiteiCheckYenkansangkMockForSinkeiyaku.SYORIPTN = null;
        TuusanMockForSinkeiyaku.SYORIPTN = TuusanMockForSinkeiyaku.TESTPATTERN2;
        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("791112246");
        List<HT_MosSyouhn> mosSyouhnLst = syoriCTL.getMosSyouhnsBySyutkkbn(C_SyutkKbn.SYU);
        Tuusan tuusan = SWAKInjector.getInstance(Tuusan.class);
        if (mosSyouhnLst.size() > 0) {
            HT_MosSyouhn mosSyouhn = mosSyouhnLst.get(0);
            BM_SyouhnZokusei syouhnZokusei =
                bizDomManager.getSyouhnZokusei(mosSyouhn.getSyouhncd(), mosSyouhn.getSyouhnsdno());
            mosnaiCheckParam.setSyuSyouhnZokusei(syouhnZokusei);
        }
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setSysKbn(C_SysKbn.SKEI);
        mosnaiCheckParam.setKiteiCheckChannelCd(C_Channelcd.TIGIN);
        try {
            checkTuusan.exec(mosnaiCheckParam, tuusan);
        } catch (CommonBizAppException e) {
            exStringEquals(e.getMessage(), "システム整合性エラーです。申込番号=791112246", "エラーメッセージ");
            throw e;
        }
    }

    @Test
    @TestOrder(70)
    public void testExec_A7() {
        KeisanGaikakanzanMockForSinkeiyaku.SYORIPTN = null;
        TuusanMockForSinkeiyaku.SYORIPTN = TuusanMockForSinkeiyaku.TESTPATTERN13;
        CheckSaiteiPMockForSinkeiyaku.SYORIPTN = CheckSaiteiPMockForSinkeiyaku.TESTPATTERN2;
        KeisanSPMockForSinkeiyaku.SYORIPTN = null;
        GetKiteiCheckYenkansangkMockForSinkeiyaku.SYORIPTN = GetKiteiCheckYenkansangkMockForSinkeiyaku.TESTPATTERN4;
        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("791112386");
        List<HT_MosSyouhn> mosSyouhnLst = syoriCTL.getMosSyouhnsBySyutkkbn(C_SyutkKbn.SYU);
        Tuusan tuusan = SWAKInjector.getInstance(Tuusan.class);
        if (mosSyouhnLst.size() > 0) {
            HT_MosSyouhn mosSyouhn = mosSyouhnLst.get(0);
            BM_SyouhnZokusei syouhnZokusei =
                bizDomManager.getSyouhnZokusei(mosSyouhn.getSyouhncd(), mosSyouhn.getSyouhnsdno());
            mosnaiCheckParam.setSyuSyouhnZokusei(syouhnZokusei);
        }
        List<HT_HubiMsg> hubiMsgLst = syoriCTL.getHubiMsgs();
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setListHubiMsg(hubiMsgLst);
        mosnaiCheckParam.setSysKbn(C_SysKbn.SKEI);
        mosnaiCheckParam.setSakuinTsnKbn(C_SakuintsnKbn.SEIJYOU);
        mosnaiCheckParam.setKiteiCheckChannelCd(C_Channelcd.TIGIN);
        checkTuusan.exec(mosnaiCheckParam, tuusan);
        exNumericEquals(hubiMsgLst.size(), 1, "不備メッセージテーブルエンティティリストの件数");
        exStringEquals(hubiMsgLst.get(0).getMosno(), "791112386", "申込番号");
        exNumericEquals(hubiMsgLst.get(0).getRenno(), 1, "連番");
        exStringEquals(hubiMsgLst.get(0).getHubimsg(), "通算２年未経過総死亡Ｓ限度額の１２０円をオーバーしています。　ご加入できません。", "不備メッセージ");
        exStringEquals(hubiMsgLst.get(0).getMessageId(), "EHC1044", "メッセージＩＤ");
        exClassificationEquals(hubiMsgLst.get(0).getHubisyubetukbn(), C_HubisyubetuKbn.KETHORYU_HUBI, "不備種別区分");

        exClassificationEquals(mosnaiCheckParam.getSakuinTsnKbn(), C_SakuintsnKbn.ERROR, "索引通算区分");

    }

    @Test
    @TestOrder(80)
    public void testExec_A8() {
        MockObjectManager.initialize();
        KeisanSPMockForSinkeiyaku.SYORIPTN = null;
        KeisanGaikakanzanMockForSinkeiyaku.SYORIPTN = null;
        GetKiteiCheckYenkansangkMockForSinkeiyaku.SYORIPTN = null;
        TuusanMockForSinkeiyaku.SYORIPTN = TuusanMockForSinkeiyaku.TESTPATTERN59;
        CheckSaiteiPMockForSinkeiyaku.SYORIPTN = CheckSaiteiPMockForSinkeiyaku.TESTPATTERN1;
        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("792223364");
        List<HT_MosSyouhn> mosSyouhnLst = syoriCTL.getMosSyouhnsBySyutkkbn(C_SyutkKbn.SYU);
        Tuusan tuusan = SWAKInjector.getInstance(Tuusan.class);
        if (mosSyouhnLst.size() > 0) {
            HT_MosSyouhn mosSyouhn = mosSyouhnLst.get(0);
            BM_SyouhnZokusei syouhnZokusei =
                bizDomManager.getSyouhnZokusei(mosSyouhn.getSyouhncd(), mosSyouhn.getSyouhnsdno());
            mosnaiCheckParam.setSyuSyouhnZokusei(syouhnZokusei);
        }
        List<HT_HubiMsg> hubiMsgLst = syoriCTL.getHubiMsgs();
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setListHubiMsg(hubiMsgLst);
        mosnaiCheckParam.setSysKbn(C_SysKbn.SKEI);
        mosnaiCheckParam.setSakuinTsnKbn(C_SakuintsnKbn.SEIJYOU);
        mosnaiCheckParam.setKiteiCheckChannelCd(C_Channelcd.TIGIN);
        checkTuusan.exec(mosnaiCheckParam, tuusan);
        exNumericEquals(hubiMsgLst.size(), 1, "不備メッセージテーブルエンティティリストの件数");
        exStringEquals(hubiMsgLst.get(0).getMosno(), "792223364", "申込番号");
        exNumericEquals(hubiMsgLst.get(0).getRenno(), 1, "連番");
        exStringEquals(hubiMsgLst.get(0).getHubimsg(), "通計保険限度額の４９円をオーバーしています。　通計保険金額　５０円", "不備メッセージ");
        exStringEquals(hubiMsgLst.get(0).getMessageId(), "EHC1031", "メッセージＩＤ");
        exClassificationEquals(hubiMsgLst.get(0).getHubisyubetukbn(), C_HubisyubetuKbn.KETHORYU_HUBI, "不備種別区分");

        exClassificationEquals(mosnaiCheckParam.getSakuinTsnKbn(), C_SakuintsnKbn.ERROR, "索引通算区分");

    }

    @Test(expected = CommonBizAppException.class)
    @TestOrder(90)
    public void testExec_A9() {
        CheckSaiteiPMockForSinkeiyaku.SYORIPTN = null;
        KeisanSPMockForSinkeiyaku.SYORIPTN = null;
        KeisanGaikakanzanMockForSinkeiyaku.SYORIPTN = null;
        GetKiteiCheckYenkansangkMockForSinkeiyaku.SYORIPTN = null;
        TuusanMockForSinkeiyaku.SYORIPTN = TuusanMockForSinkeiyaku.TESTPATTERN3;
        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("791112253");
        List<HT_MosSyouhn> mosSyouhnLst = syoriCTL.getMosSyouhnsBySyutkkbn(C_SyutkKbn.SYU);
        Tuusan tuusan = SWAKInjector.getInstance(Tuusan.class);
        if (mosSyouhnLst.size() > 0) {
            HT_MosSyouhn mosSyouhn = mosSyouhnLst.get(0);
            BM_SyouhnZokusei syouhnZokusei =
                bizDomManager.getSyouhnZokusei(mosSyouhn.getSyouhncd(), mosSyouhn.getSyouhnsdno());
            mosnaiCheckParam.setSyuSyouhnZokusei(syouhnZokusei);
        }
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setSysKbn(C_SysKbn.ESHIEN);
        mosnaiCheckParam.setKiteiCheckChannelCd(C_Channelcd.TIGIN);
        try {
            checkTuusan.exec(mosnaiCheckParam, tuusan);
        } catch (CommonBizAppException e) {
            exStringEquals(e.getMessage(), "システム整合性エラーです。申込番号=791112253", "エラーメッセージ");
            throw e;
        }
    }

    @Test(expected = CommonBizAppException.class)
    @TestOrder(100)
    public void testExec_A10() {
        CheckSaiteiPMockForSinkeiyaku.SYORIPTN = null;
        KeisanSPMockForSinkeiyaku.SYORIPTN = null;
        KeisanGaikakanzanMockForSinkeiyaku.SYORIPTN = null;
        GetKiteiCheckYenkansangkMockForSinkeiyaku.SYORIPTN = null;
        TuusanMockForSinkeiyaku.SYORIPTN = TuusanMockForSinkeiyaku.TESTPATTERN4;
        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("791112253");
        List<HT_MosSyouhn> mosSyouhnLst = syoriCTL.getMosSyouhnsBySyutkkbn(C_SyutkKbn.SYU);
        Tuusan tuusan = SWAKInjector.getInstance(Tuusan.class);
        if (mosSyouhnLst.size() > 0) {
            HT_MosSyouhn mosSyouhn = mosSyouhnLst.get(0);
            BM_SyouhnZokusei syouhnZokusei =
                bizDomManager.getSyouhnZokusei(mosSyouhn.getSyouhncd(), mosSyouhn.getSyouhnsdno());
            mosnaiCheckParam.setSyuSyouhnZokusei(syouhnZokusei);
        }
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setSysKbn(C_SysKbn.ESHIEN);
        mosnaiCheckParam.setKiteiCheckChannelCd(C_Channelcd.TIGIN);
        try {
            checkTuusan.exec(mosnaiCheckParam, tuusan);
        } catch (CommonBizAppException e) {
            exStringEquals(e.getMessage(), "システム整合性エラーです。申込番号=791112253", "エラーメッセージ");
            throw e;
        }
    }

    @Test(expected = CommonBizAppException.class)
    @TestOrder(110)
    public void testExec_A11() {
        CheckSaiteiPMockForSinkeiyaku.SYORIPTN = null;
        KeisanSPMockForSinkeiyaku.SYORIPTN = null;
        KeisanGaikakanzanMockForSinkeiyaku.SYORIPTN = null;
        GetKiteiCheckYenkansangkMockForSinkeiyaku.SYORIPTN = null;
        TuusanMockForSinkeiyaku.SYORIPTN = TuusanMockForSinkeiyaku.TESTPATTERN27;
        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("791112253");
        List<HT_MosSyouhn> mosSyouhnLst = syoriCTL.getMosSyouhnsBySyutkkbn(C_SyutkKbn.SYU);
        Tuusan tuusan = SWAKInjector.getInstance(Tuusan.class);
        if (mosSyouhnLst.size() > 0) {
            HT_MosSyouhn mosSyouhn = mosSyouhnLst.get(0);
            BM_SyouhnZokusei syouhnZokusei =
                bizDomManager.getSyouhnZokusei(mosSyouhn.getSyouhncd(), mosSyouhn.getSyouhnsdno());
            mosnaiCheckParam.setSyuSyouhnZokusei(syouhnZokusei);
        }
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setSysKbn(C_SysKbn.ESHIEN);
        mosnaiCheckParam.setKiteiCheckChannelCd(C_Channelcd.TIGIN);
        try {
            checkTuusan.exec(mosnaiCheckParam, tuusan);
        } catch (CommonBizAppException e) {
            exStringEquals(e.getMessage(), "システム整合性エラーです。申込番号=791112253", "エラーメッセージ");
            throw e;
        }
    }

    @Test(expected = CommonBizAppException.class)
    @TestOrder(120)
    public void testExec_A12() {
        CheckSaiteiPMockForSinkeiyaku.SYORIPTN = null;
        KeisanSPMockForSinkeiyaku.SYORIPTN = null;
        KeisanGaikakanzanMockForSinkeiyaku.SYORIPTN = null;
        GetKiteiCheckYenkansangkMockForSinkeiyaku.SYORIPTN = null;
        TuusanMockForSinkeiyaku.SYORIPTN = TuusanMockForSinkeiyaku.TESTPATTERN4;
        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("791112261");
        List<HT_MosSyouhn> mosSyouhnLst = syoriCTL.getMosSyouhnsBySyutkkbn(C_SyutkKbn.SYU);
        Tuusan tuusan = SWAKInjector.getInstance(Tuusan.class);
        if (mosSyouhnLst.size() > 0) {
            HT_MosSyouhn mosSyouhn = mosSyouhnLst.get(0);
            BM_SyouhnZokusei syouhnZokusei =
                bizDomManager.getSyouhnZokusei(mosSyouhn.getSyouhncd(), mosSyouhn.getSyouhnsdno());
            mosnaiCheckParam.setSyuSyouhnZokusei(syouhnZokusei);
        }
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setSysKbn(C_SysKbn.SKEI);
        mosnaiCheckParam.setKiteiCheckChannelCd(C_Channelcd.TIGIN);
        try {
            checkTuusan.exec(mosnaiCheckParam, tuusan);
        } catch (CommonBizAppException e) {
            exStringEquals(e.getMessage(), "システム整合性エラーです。申込番号=791112261", "エラーメッセージ");
            throw e;
        }
    }

    @Test
    @TestOrder(130)
    public void testExec_A13() {
        MockObjectManager.initialize();
        KeisanSPMockForSinkeiyaku.SYORIPTN = null;
        KeisanGaikakanzanMockForSinkeiyaku.SYORIPTN = null;
        GetKiteiCheckYenkansangkMockForSinkeiyaku.SYORIPTN = null;
        TuusanMockForSinkeiyaku.SYORIPTN = TuusanMockForSinkeiyaku.TESTPATTERN11;
        CheckSaiteiPMockForSinkeiyaku.SYORIPTN = CheckSaiteiPMockForSinkeiyaku.TESTPATTERN1;
        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("791112352");
        List<HT_MosSyouhn> mosSyouhnLst = syoriCTL.getMosSyouhnsBySyutkkbn(C_SyutkKbn.SYU);
        Tuusan tuusan = SWAKInjector.getInstance(Tuusan.class);
        if (mosSyouhnLst.size() > 0) {
            HT_MosSyouhn mosSyouhn = mosSyouhnLst.get(0);
            BM_SyouhnZokusei syouhnZokusei =
                bizDomManager.getSyouhnZokusei(mosSyouhn.getSyouhncd(), mosSyouhn.getSyouhnsdno());
            mosnaiCheckParam.setSyuSyouhnZokusei(syouhnZokusei);
        }
        List<HT_HubiMsg> hubiMsgLst = syoriCTL.getHubiMsgs();
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setListHubiMsg(hubiMsgLst);
        mosnaiCheckParam.setSysKbn(C_SysKbn.SKEI);
        mosnaiCheckParam.setSakuinTsnKbn(C_SakuintsnKbn.SEIJYOU);
        mosnaiCheckParam.setKiteiCheckChannelCd(C_Channelcd.TIGIN);

        checkTuusan.exec(mosnaiCheckParam, tuusan);
        exNumericEquals(hubiMsgLst.size(), 0, "不備メッセージテーブルエンティティリストの件数");
        exClassificationEquals(mosnaiCheckParam.getSakuinTsnKbn(), C_SakuintsnKbn.SEIJYOU, "索引通算区分");

    }

    @Test(expected = CommonBizAppException.class)
    @TestOrder(140)
    public void testExec_A14() {
        MockObjectManager.initialize();
        KeisanSPMockForSinkeiyaku.SYORIPTN = null;
        KeisanGaikakanzanMockForSinkeiyaku.SYORIPTN = null;
        GetKiteiCheckYenkansangkMockForSinkeiyaku.SYORIPTN = null;
        TuusanMockForSinkeiyaku.SYORIPTN = TuusanMockForSinkeiyaku.TESTPATTERN26;
        CheckSaiteiPMockForSinkeiyaku.SYORIPTN = CheckSaiteiPMockForSinkeiyaku.TESTPATTERN3;
        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("792223349");
        List<HT_MosSyouhn> mosSyouhnLst = syoriCTL.getMosSyouhnsBySyutkkbn(C_SyutkKbn.SYU);
        Tuusan tuusan = SWAKInjector.getInstance(Tuusan.class);
        if (mosSyouhnLst.size() > 0) {
            HT_MosSyouhn mosSyouhn = mosSyouhnLst.get(0);
            BM_SyouhnZokusei syouhnZokusei =
                bizDomManager.getSyouhnZokusei(mosSyouhn.getSyouhncd(), mosSyouhn.getSyouhnsdno());
            mosnaiCheckParam.setSyuSyouhnZokusei(syouhnZokusei);
        }
        mosnaiCheckParam.setSysKbn(C_SysKbn.SKEI);
        mosnaiCheckParam.setSakuinTsnKbn(C_SakuintsnKbn.SEIJYOU);
        mosnaiCheckParam.setKiteiCheckChannelCd(C_Channelcd.TIGIN);
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        try {
            checkTuusan.exec(mosnaiCheckParam, tuusan);
        } catch (CommonBizAppException e) {
            exStringEquals(e.getMessage(), "システム整合性エラーです。申込番号=792223349", "エラーメッセージ");
            throw e;
        }
    }

    @Test
    @TestOrder(150)
    public void testExec_A15() {
        KeisanSPMockForSinkeiyaku.SYORIPTN = null;
        KeisanGaikakanzanMockForSinkeiyaku.SYORIPTN = null;
        GetKiteiCheckYenkansangkMockForSinkeiyaku.SYORIPTN = null;
        TuusanMockForSinkeiyaku.SYORIPTN = TuusanMockForSinkeiyaku.TESTPATTERN28;
        CheckSaiteiPMockForSinkeiyaku.SYORIPTN = CheckSaiteiPMockForSinkeiyaku.TESTPATTERN1;
        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("791112311");
        List<HT_MosSyouhn> mosSyouhnLst = syoriCTL.getMosSyouhnsBySyutkkbn(C_SyutkKbn.SYU);
        if (mosSyouhnLst.size() > 0) {
            HT_MosSyouhn mosSyouhn = mosSyouhnLst.get(0);
            BM_SyouhnZokusei syouhnZokusei =
                bizDomManager.getSyouhnZokusei(mosSyouhn.getSyouhncd(), mosSyouhn.getSyouhnsdno());
            mosnaiCheckParam.setSyuSyouhnZokusei(syouhnZokusei);
        }
        List<HT_HubiMsg> hubiMsgLst = new ArrayList<HT_HubiMsg>();
        mosnaiCheckParam.setListHubiMsg(hubiMsgLst);
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setSysKbn(C_SysKbn.SKEI);
        mosnaiCheckParam.setSakuinTsnKbn(C_SakuintsnKbn.ERROR);
        mosnaiCheckParam.setKiteiCheckChannelCd(C_Channelcd.TIGIN);
        exNumericEquals(hubiMsgLst.size(), 0, "不備メッセージテーブルエンティティリストの件数");
    }

    @Test
    @TestOrder(160)
    public void testExec_A16() {
        MockObjectManager.initialize();
        KeisanSPMockForSinkeiyaku.SYORIPTN = null;
        KeisanGaikakanzanMockForSinkeiyaku.SYORIPTN = null;
        GetKiteiCheckYenkansangkMockForSinkeiyaku.SYORIPTN = null;
        TuusanMockForSinkeiyaku.SYORIPTN = TuusanMockForSinkeiyaku.TESTPATTERN25;
        CheckSaiteiPMockForSinkeiyaku.SYORIPTN = CheckSaiteiPMockForSinkeiyaku.TESTPATTERN1;
        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("791112717");
        List<HT_MosSyouhn> mosSyouhnLst = syoriCTL.getMosSyouhnsBySyutkkbn(C_SyutkKbn.SYU);
        Tuusan tuusan = SWAKInjector.getInstance(Tuusan.class);
        if (mosSyouhnLst.size() > 0) {
            HT_MosSyouhn mosSyouhn = mosSyouhnLst.get(0);
            BM_SyouhnZokusei syouhnZokusei =
                bizDomManager.getSyouhnZokusei(mosSyouhn.getSyouhncd(), mosSyouhn.getSyouhnsdno());
            mosnaiCheckParam.setSyuSyouhnZokusei(syouhnZokusei);
        }
        List<HT_HubiMsg> hubiMsgLst = syoriCTL.getHubiMsgs();
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setListHubiMsg(hubiMsgLst);
        mosnaiCheckParam.setSysKbn(C_SysKbn.ESHIEN);
        mosnaiCheckParam.setSakuinTsnKbn(C_SakuintsnKbn.SEIJYOU);
        mosnaiCheckParam.setBosyuuSysCtrlKbn(C_BosyuusysctrlKbn.SMBC);
        mosnaiCheckParam.setSekmossakuseiOyaAgCd("5102150");
        mosnaiCheckParam.setKiteiCheckChannelCd(C_Channelcd.TIGIN);
        checkTuusan.exec(mosnaiCheckParam, tuusan);
        exNumericEquals(hubiMsgLst.size(), 0, "不備メッセージテーブルエンティティリストの件数");
        exClassificationEquals(mosnaiCheckParam.getSekmossakuseiErroutKbn(), C_SekmossakuseiErroutKbn.GAMEN,
            "設計書申込書作成エラー出力区分 ");
        exStringEquals(mosnaiCheckParam.getSekmossakuseiErrmsg1(), "通算保険料が限度額を超えています", "設計書申込書作成エラーメッセージ１");
        exStringEquals(mosnaiCheckParam.getSekmossakuseiErrmsg2(), "払込金額は２４０円までにしてください", "設計書申込書作成エラーメッセージ２");
        exClassificationEquals(mosnaiCheckParam.getKouzokuSyoriJikkouKbn(), C_KouzokujkKbn.NONE, "後続処理実行区分");
        exClassificationEquals(mosnaiCheckParam.getSakuinTsnKbn(), C_SakuintsnKbn.ERROR, "索引通算区分");

    }

    @Test
    @TestOrder(170)
    public void testExec_A17() {
        MockObjectManager.initialize();
        KeisanSPMockForSinkeiyaku.SYORIPTN = null;
        TuusanMockForSinkeiyaku.SYORIPTN = TuusanMockForSinkeiyaku.TESTPATTERN25;
        CheckSaiteiPMockForSinkeiyaku.SYORIPTN = CheckSaiteiPMockForSinkeiyaku.TESTPATTERN1;
        KeisanGaikakanzanMockForSinkeiyaku.SYORIPTN = KeisanGaikakanzanMockForSinkeiyaku.TESTPATTERN1;
        GetKiteiCheckYenkansangkMockForSinkeiyaku.SYORIPTN = GetKiteiCheckYenkansangkMockForSinkeiyaku.TESTPATTERN1;
        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("860000017");
        List<HT_MosSyouhn> mosSyouhnLst = syoriCTL.getMosSyouhnsBySyutkkbn(C_SyutkKbn.SYU);
        Tuusan tuusan = SWAKInjector.getInstance(Tuusan.class);
        if (mosSyouhnLst.size() > 0) {
            HT_MosSyouhn mosSyouhn = mosSyouhnLst.get(0);
            BM_SyouhnZokusei syouhnZokusei =
                bizDomManager.getSyouhnZokusei(mosSyouhn.getSyouhncd(), mosSyouhn.getSyouhnsdno());
            mosnaiCheckParam.setSyuSyouhnZokusei(syouhnZokusei);
        }
        List<HT_HubiMsg> hubiMsgLst = syoriCTL.getHubiMsgs();
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setListHubiMsg(hubiMsgLst);
        mosnaiCheckParam.setSysKbn(C_SysKbn.ESHIEN);
        mosnaiCheckParam.setSakuinTsnKbn(C_SakuintsnKbn.SEIJYOU);
        mosnaiCheckParam.setBosyuuSysCtrlKbn(C_BosyuusysctrlKbn.SMBC);
        mosnaiCheckParam.setKiteiCheckChannelCd(C_Channelcd.TIGIN);
        checkTuusan.exec(mosnaiCheckParam, tuusan);
        exNumericEquals(hubiMsgLst.size(), 0, "不備メッセージテーブルエンティティリストの件数");
        exClassificationEquals(mosnaiCheckParam.getSekmossakuseiErroutKbn(), C_SekmossakuseiErroutKbn.GAMEN,
            "設計書申込書作成エラー出力区分 ");
        exStringEquals(mosnaiCheckParam.getSekmossakuseiErrmsg1(), "通算保険料が限度額を超えています", "設計書申込書作成エラーメッセージ１");
        exStringEquals(mosnaiCheckParam.getSekmossakuseiErrmsg2(), "払込金額は２００円までにしてください", "設計書申込書作成エラーメッセージ２");
        exClassificationEquals(mosnaiCheckParam.getKouzokuSyoriJikkouKbn(), C_KouzokujkKbn.NONE, "後続処理実行区分");
        exClassificationEquals(mosnaiCheckParam.getSakuinTsnKbn(), C_SakuintsnKbn.ERROR, "索引通算区分");

    }

    @Test
    @TestOrder(180)
    public void testExec_A18() {
        MockObjectManager.initialize();
        KeisanSPMockForSinkeiyaku.SYORIPTN = null;
        TuusanMockForSinkeiyaku.SYORIPTN = TuusanMockForSinkeiyaku.TESTPATTERN25;
        CheckSaiteiPMockForSinkeiyaku.SYORIPTN = CheckSaiteiPMockForSinkeiyaku.TESTPATTERN1;
        KeisanGaikakanzanMockForSinkeiyaku.SYORIPTN = KeisanGaikakanzanMockForSinkeiyaku.TESTPATTERN2;
        GetKiteiCheckYenkansangkMockForSinkeiyaku.SYORIPTN = GetKiteiCheckYenkansangkMockForSinkeiyaku.TESTPATTERN2;
        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("860000025");
        List<HT_MosSyouhn> mosSyouhnLst = syoriCTL.getMosSyouhnsBySyutkkbn(C_SyutkKbn.SYU);
        Tuusan tuusan = SWAKInjector.getInstance(Tuusan.class);
        if (mosSyouhnLst.size() > 0) {
            HT_MosSyouhn mosSyouhn = mosSyouhnLst.get(0);
            BM_SyouhnZokusei syouhnZokusei =
                bizDomManager.getSyouhnZokusei(mosSyouhn.getSyouhncd(), mosSyouhn.getSyouhnsdno());
            mosnaiCheckParam.setSyuSyouhnZokusei(syouhnZokusei);
        }
        List<HT_HubiMsg> hubiMsgLst = syoriCTL.getHubiMsgs();
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setListHubiMsg(hubiMsgLst);
        mosnaiCheckParam.setSysKbn(C_SysKbn.ESHIEN);
        mosnaiCheckParam.setSakuinTsnKbn(C_SakuintsnKbn.SEIJYOU);
        mosnaiCheckParam.setBosyuuSysCtrlKbn(C_BosyuusysctrlKbn.SMBC);
        mosnaiCheckParam.setKiteiCheckChannelCd(C_Channelcd.TIGIN);
        checkTuusan.exec(mosnaiCheckParam, tuusan);
        exNumericEquals(hubiMsgLst.size(), 0, "不備メッセージテーブルエンティティリストの件数");
        exClassificationEquals(mosnaiCheckParam.getSekmossakuseiErroutKbn(), C_SekmossakuseiErroutKbn.GAMEN,
            "設計書申込書作成エラー出力区分 ");
        exStringEquals(mosnaiCheckParam.getSekmossakuseiErrmsg1(), "通算保険料が限度額を超えています", "設計書申込書作成エラーメッセージ１");
        exStringEquals(mosnaiCheckParam.getSekmossakuseiErrmsg2(), "払込金額は２４０円までにしてください", "設計書申込書作成エラーメッセージ２");
        exClassificationEquals(mosnaiCheckParam.getKouzokuSyoriJikkouKbn(), C_KouzokujkKbn.NONE, "後続処理実行区分");
        exClassificationEquals(mosnaiCheckParam.getSakuinTsnKbn(), C_SakuintsnKbn.ERROR, "索引通算区分");

    }

    @Test
    @TestOrder(190)
    public void testExec_A19() {
        MockObjectManager.initialize();
        KeisanSPMockForSinkeiyaku.SYORIPTN = null;
        TuusanMockForSinkeiyaku.SYORIPTN = TuusanMockForSinkeiyaku.TESTPATTERN25;
        CheckSaiteiPMockForSinkeiyaku.SYORIPTN = CheckSaiteiPMockForSinkeiyaku.TESTPATTERN1;
        KeisanGaikakanzanMockForSinkeiyaku.SYORIPTN = KeisanGaikakanzanMockForSinkeiyaku.TESTPATTERN3;
        GetKiteiCheckYenkansangkMockForSinkeiyaku.SYORIPTN = GetKiteiCheckYenkansangkMockForSinkeiyaku.TESTPATTERN3;
        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("860000033");
        List<HT_MosSyouhn> mosSyouhnLst = syoriCTL.getMosSyouhnsBySyutkkbn(C_SyutkKbn.SYU);
        Tuusan tuusan = SWAKInjector.getInstance(Tuusan.class);
        if (mosSyouhnLst.size() > 0) {
            HT_MosSyouhn mosSyouhn = mosSyouhnLst.get(0);
            BM_SyouhnZokusei syouhnZokusei =
                bizDomManager.getSyouhnZokusei(mosSyouhn.getSyouhncd(), mosSyouhn.getSyouhnsdno());
            mosnaiCheckParam.setSyuSyouhnZokusei(syouhnZokusei);
        }
        List<HT_HubiMsg> hubiMsgLst = syoriCTL.getHubiMsgs();
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setListHubiMsg(hubiMsgLst);
        mosnaiCheckParam.setSysKbn(C_SysKbn.ESHIEN);
        mosnaiCheckParam.setSakuinTsnKbn(C_SakuintsnKbn.SEIJYOU);
        mosnaiCheckParam.setBosyuuSysCtrlKbn(C_BosyuusysctrlKbn.SMBC);
        mosnaiCheckParam.setKiteiCheckChannelCd(C_Channelcd.TIGIN);
        checkTuusan.exec(mosnaiCheckParam, tuusan);
        exNumericEquals(hubiMsgLst.size(), 0, "不備メッセージテーブルエンティティリストの件数");
        exClassificationEquals(mosnaiCheckParam.getSekmossakuseiErroutKbn(), C_SekmossakuseiErroutKbn.GAMEN,
            "設計書申込書作成エラー出力区分 ");
        exStringEquals(mosnaiCheckParam.getSekmossakuseiErrmsg1(), "通算保険料が限度額を超えています", "設計書申込書作成エラーメッセージ１");
        exStringEquals(mosnaiCheckParam.getSekmossakuseiErrmsg2(), "払込金額は２４０円までにしてください", "設計書申込書作成エラーメッセージ２");
        exClassificationEquals(mosnaiCheckParam.getKouzokuSyoriJikkouKbn(), C_KouzokujkKbn.NONE, "後続処理実行区分");
        exClassificationEquals(mosnaiCheckParam.getSakuinTsnKbn(), C_SakuintsnKbn.ERROR, "索引通算区分");

    }

    @Test
    @TestOrder(200)
    public void testExec_A20() {
        MockObjectManager.initialize();
        KeisanSPMockForSinkeiyaku.SYORIPTN = null;
        KeisanGaikakanzanMockForSinkeiyaku.SYORIPTN = null;
        GetKiteiCheckYenkansangkMockForSinkeiyaku.SYORIPTN = null;
        TuusanMockForSinkeiyaku.SYORIPTN = TuusanMockForSinkeiyaku.TESTPATTERN26;
        CheckSaiteiPMockForSinkeiyaku.SYORIPTN = CheckSaiteiPMockForSinkeiyaku.TESTPATTERN8;
        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("791112725");
        List<HT_MosSyouhn> mosSyouhnLst = syoriCTL.getMosSyouhnsBySyutkkbn(C_SyutkKbn.SYU);
        Tuusan tuusan = SWAKInjector.getInstance(Tuusan.class);
        if (mosSyouhnLst.size() > 0) {
            HT_MosSyouhn mosSyouhn = mosSyouhnLst.get(0);
            BM_SyouhnZokusei syouhnZokusei =
                bizDomManager.getSyouhnZokusei(mosSyouhn.getSyouhncd(), mosSyouhn.getSyouhnsdno());
            mosnaiCheckParam.setSyuSyouhnZokusei(syouhnZokusei);
        }
        List<HT_HubiMsg> hubiMsgLst = syoriCTL.getHubiMsgs();
        mosnaiCheckParam.setListHubiMsg(hubiMsgLst);
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setSysKbn(C_SysKbn.ESHIEN);
        mosnaiCheckParam.setSakuinTsnKbn(C_SakuintsnKbn.SEIJYOU);
        mosnaiCheckParam.setKiteiCheckChannelCd(C_Channelcd.TIGIN);
        checkTuusan.exec(mosnaiCheckParam, tuusan);
        exNumericEquals(hubiMsgLst.size(), 0, "不備メッセージテーブルエンティティリストの件数");
        exClassificationEquals(mosnaiCheckParam.getSekmossakuseiErroutKbn(), C_SekmossakuseiErroutKbn.GAMEN,
            "設計書申込書作成エラー出力区分 ");
        exStringEquals(mosnaiCheckParam.getSekmossakuseiErrmsg1(), "通算保険料が限度額を超えています", "設計書申込書作成エラーメッセージ１");
        exStringEquals(mosnaiCheckParam.getSekmossakuseiErrmsg2(), "保険料は２３０円までにしてください", "設計書申込書作成エラーメッセージ２");
        exClassificationEquals(mosnaiCheckParam.getKouzokuSyoriJikkouKbn(), C_KouzokujkKbn.NONE, "後続処理実行区分");
        exClassificationEquals(mosnaiCheckParam.getSakuinTsnKbn(), C_SakuintsnKbn.ERROR, "索引通算区分");
    }

    @Test
    @TestOrder(210)
    public void testExec_A21() {
        MockObjectManager.initialize();
        KeisanSPMockForSinkeiyaku.SYORIPTN = null;
        KeisanGaikakanzanMockForSinkeiyaku.SYORIPTN = null;
        GetKiteiCheckYenkansangkMockForSinkeiyaku.SYORIPTN = null;
        TuusanMockForSinkeiyaku.SYORIPTN = TuusanMockForSinkeiyaku.TESTPATTERN26;
        CheckSaiteiPMockForSinkeiyaku.SYORIPTN = CheckSaiteiPMockForSinkeiyaku.TESTPATTERN3;
        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("791112733");
        List<HT_MosSyouhn> mosSyouhnLst = syoriCTL.getMosSyouhnsBySyutkkbn(C_SyutkKbn.SYU);
        Tuusan tuusan = SWAKInjector.getInstance(Tuusan.class);
        if (mosSyouhnLst.size() > 0) {
            HT_MosSyouhn mosSyouhn = mosSyouhnLst.get(0);
            BM_SyouhnZokusei syouhnZokusei =
                bizDomManager.getSyouhnZokusei(mosSyouhn.getSyouhncd(), mosSyouhn.getSyouhnsdno());
            mosnaiCheckParam.setSyuSyouhnZokusei(syouhnZokusei);
        }
        List<HT_HubiMsg> hubiMsgLst = syoriCTL.getHubiMsgs();
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setListHubiMsg(hubiMsgLst);
        mosnaiCheckParam.setSysKbn(C_SysKbn.ESHIEN);
        mosnaiCheckParam.setSakuinTsnKbn(C_SakuintsnKbn.SEIJYOU);
        mosnaiCheckParam.setKiteiCheckChannelCd(C_Channelcd.TIGIN);
        checkTuusan.exec(mosnaiCheckParam, tuusan);
        exNumericEquals(hubiMsgLst.size(), 0, "不備メッセージテーブルエンティティリストの件数");
        exClassificationEquals(mosnaiCheckParam.getSekmossakuseiErroutKbn(), C_SekmossakuseiErroutKbn.GAMEN,
            "設計書申込書作成エラー出力区分 ");
        exStringEquals(mosnaiCheckParam.getSekmossakuseiErrmsg1(), "", "設計書申込書作成エラーメッセージ１");
        exStringEquals(mosnaiCheckParam.getSekmossakuseiErrmsg2(), "通算保険料が限度額を超えています　ご加入できません", "設計書申込書作成エラーメッセージ２");
        exClassificationEquals(mosnaiCheckParam.getKouzokuSyoriJikkouKbn(), C_KouzokujkKbn.NONE, "後続処理実行区分");
        exClassificationEquals(mosnaiCheckParam.getSakuinTsnKbn(), C_SakuintsnKbn.ERROR, "索引通算区分");
    }

    @Test
    @TestOrder(220)
    public void testExec_A22() {
        MockObjectManager.initialize();
        KeisanSPMockForSinkeiyaku.SYORIPTN = null;
        KeisanGaikakanzanMockForSinkeiyaku.SYORIPTN = null;
        GetKiteiCheckYenkansangkMockForSinkeiyaku.SYORIPTN = null;
        TuusanMockForSinkeiyaku.SYORIPTN = TuusanMockForSinkeiyaku.TESTPATTERN25;
        CheckSaiteiPMockForSinkeiyaku.SYORIPTN = CheckSaiteiPMockForSinkeiyaku.TESTPATTERN1;
        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("792223331");
        List<HT_MosSyouhn> mosSyouhnLst = syoriCTL.getMosSyouhnsBySyutkkbn(C_SyutkKbn.SYU);
        Tuusan tuusan = SWAKInjector.getInstance(Tuusan.class);
        if (mosSyouhnLst.size() > 0) {
            HT_MosSyouhn mosSyouhn = mosSyouhnLst.get(0);
            BM_SyouhnZokusei syouhnZokusei =
                bizDomManager.getSyouhnZokusei(mosSyouhn.getSyouhncd(), mosSyouhn.getSyouhnsdno());
            mosnaiCheckParam.setSyuSyouhnZokusei(syouhnZokusei);
        }
        List<HT_HubiMsg> hubiMsgLst = syoriCTL.getHubiMsgs();
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setListHubiMsg(hubiMsgLst);
        mosnaiCheckParam.setSysKbn(C_SysKbn.SKEI);
        mosnaiCheckParam.setSakuinTsnKbn(C_SakuintsnKbn.SEIJYOU);
        mosnaiCheckParam.setKiteiCheckChannelCd(C_Channelcd.TIGIN);
        checkTuusan.exec(mosnaiCheckParam, tuusan);
        exNumericEquals(hubiMsgLst.size(), 1, "不備メッセージテーブルエンティティリストの件数");
        exStringEquals(hubiMsgLst.get(0).getMosno(), "792223331", "申込番号");
        exNumericEquals(hubiMsgLst.get(0).getRenno(), 1, "連番");
        exStringEquals(hubiMsgLst.get(0).getHubimsg(), "【特認可能】通算一時払Ｐ限度額の３００円をオーバーしています。　一時払保険料は２４０円までにしてください。",
            "不備メッセージ");
        exStringEquals(hubiMsgLst.get(0).getMessageId(), "THC1041", "メッセージＩＤ");
        exClassificationEquals(hubiMsgLst.get(0).getHubisyubetukbn(), C_HubisyubetuKbn.KETHORYU_HUBI, "不備種別区分");
        exClassificationEquals(mosnaiCheckParam.getSakuinTsnKbn(), C_SakuintsnKbn.ERROR, "索引通算区分");

    }

    @Test
    @TestOrder(230)
    public void testExec_A23() {
        MockObjectManager.initialize();
        KeisanSPMockForSinkeiyaku.SYORIPTN = null;
        KeisanGaikakanzanMockForSinkeiyaku.SYORIPTN = null;
        GetKiteiCheckYenkansangkMockForSinkeiyaku.SYORIPTN = null;
        TuusanMockForSinkeiyaku.SYORIPTN = TuusanMockForSinkeiyaku.TESTPATTERN26;
        CheckSaiteiPMockForSinkeiyaku.SYORIPTN = CheckSaiteiPMockForSinkeiyaku.TESTPATTERN8;
        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("791112493");
        List<HT_MosSyouhn> mosSyouhnLst = syoriCTL.getMosSyouhnsBySyutkkbn(C_SyutkKbn.SYU);
        Tuusan tuusan = SWAKInjector.getInstance(Tuusan.class);
        if (mosSyouhnLst.size() > 0) {
            HT_MosSyouhn mosSyouhn = mosSyouhnLst.get(0);
            BM_SyouhnZokusei syouhnZokusei =
                bizDomManager.getSyouhnZokusei(mosSyouhn.getSyouhncd(), mosSyouhn.getSyouhnsdno());
            mosnaiCheckParam.setSyuSyouhnZokusei(syouhnZokusei);
        }
        List<HT_HubiMsg> hubiMsgLst = syoriCTL.getHubiMsgs();
        mosnaiCheckParam.setListHubiMsg(hubiMsgLst);
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setSysKbn(C_SysKbn.SKEI);
        mosnaiCheckParam.setSakuinTsnKbn(C_SakuintsnKbn.SEIJYOU);
        mosnaiCheckParam.setKiteiCheckChannelCd(C_Channelcd.TIGIN);
        checkTuusan.exec(mosnaiCheckParam, tuusan);
        exNumericEquals(hubiMsgLst.size(), 1, "不備メッセージテーブルエンティティリストの件数");
        exStringEquals(hubiMsgLst.get(0).getMosno(), "791112493", "申込番号");
        exNumericEquals(hubiMsgLst.get(0).getRenno(), 1, "連番");
        exStringEquals(hubiMsgLst.get(0).getHubimsg(), "【特認可能】通算一時払Ｐ限度額の３００円をオーバーしています。　一時払保険料は２３０円までにしてください。",
            "不備メッセージ");
        exStringEquals(hubiMsgLst.get(0).getMessageId(), "THC1041", "メッセージＩＤ");
        exClassificationEquals(hubiMsgLst.get(0).getHubisyubetukbn(), C_HubisyubetuKbn.KETHORYU_HUBI, "不備種別区分");
        exClassificationEquals(mosnaiCheckParam.getSakuinTsnKbn(), C_SakuintsnKbn.ERROR, "索引通算区分");
    }

    @Test
    @TestOrder(240)
    public void testExec_A24() {
        MockObjectManager.initialize();
        KeisanSPMockForSinkeiyaku.SYORIPTN = null;
        KeisanGaikakanzanMockForSinkeiyaku.SYORIPTN = null;
        GetKiteiCheckYenkansangkMockForSinkeiyaku.SYORIPTN = null;
        TuusanMockForSinkeiyaku.SYORIPTN = TuusanMockForSinkeiyaku.TESTPATTERN26;
        CheckSaiteiPMockForSinkeiyaku.SYORIPTN = CheckSaiteiPMockForSinkeiyaku.TESTPATTERN3;
        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("791112501");
        List<HT_MosSyouhn> mosSyouhnLst = syoriCTL.getMosSyouhnsBySyutkkbn(C_SyutkKbn.SYU);
        Tuusan tuusan = SWAKInjector.getInstance(Tuusan.class);
        if (mosSyouhnLst.size() > 0) {
            HT_MosSyouhn mosSyouhn = mosSyouhnLst.get(0);
            BM_SyouhnZokusei syouhnZokusei =
                bizDomManager.getSyouhnZokusei(mosSyouhn.getSyouhncd(), mosSyouhn.getSyouhnsdno());
            mosnaiCheckParam.setSyuSyouhnZokusei(syouhnZokusei);
        }
        List<HT_HubiMsg> hubiMsgLst = syoriCTL.getHubiMsgs();
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setListHubiMsg(hubiMsgLst);
        mosnaiCheckParam.setSysKbn(C_SysKbn.SKEI);
        mosnaiCheckParam.setSakuinTsnKbn(C_SakuintsnKbn.SEIJYOU);
        mosnaiCheckParam.setKiteiCheckChannelCd(C_Channelcd.TIGIN);
        checkTuusan.exec(mosnaiCheckParam, tuusan);
        exNumericEquals(hubiMsgLst.size(), 1, "不備メッセージテーブルエンティティリストの件数");
        exStringEquals(hubiMsgLst.get(0).getMosno(), "791112501", "申込番号");
        exNumericEquals(hubiMsgLst.get(0).getRenno(), 1, "連番");
        exStringEquals(hubiMsgLst.get(0).getHubimsg(), "【特認可能】通算一時払Ｐ限度額の３００円をオーバーしています。　ご加入できません。", "不備メッセージ");
        exStringEquals(hubiMsgLst.get(0).getMessageId(), "THC1040", "メッセージＩＤ");
        exClassificationEquals(hubiMsgLst.get(0).getHubisyubetukbn(), C_HubisyubetuKbn.KETHORYU_HUBI, "不備種別区分");
        exClassificationEquals(mosnaiCheckParam.getSakuinTsnKbn(), C_SakuintsnKbn.ERROR, "索引通算区分");
    }

    @Test
    @TestOrder(250)
    public void testExec_A25() {
        MockObjectManager.initialize();
        KeisanSPMockForSinkeiyaku.SYORIPTN = null;
        KeisanGaikakanzanMockForSinkeiyaku.SYORIPTN = null;
        GetKiteiCheckYenkansangkMockForSinkeiyaku.SYORIPTN = null;
        TuusanMockForSinkeiyaku.SYORIPTN = TuusanMockForSinkeiyaku.TESTPATTERN29;
        CheckSaiteiPMockForSinkeiyaku.SYORIPTN = CheckSaiteiPMockForSinkeiyaku.TESTPATTERN8;
        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("791112725");
        List<HT_MosSyouhn> mosSyouhnLst = syoriCTL.getMosSyouhnsBySyutkkbn(C_SyutkKbn.SYU);
        Tuusan tuusan = SWAKInjector.getInstance(Tuusan.class);
        if (mosSyouhnLst.size() > 0) {
            HT_MosSyouhn mosSyouhn = mosSyouhnLst.get(0);
            BM_SyouhnZokusei syouhnZokusei =
                bizDomManager.getSyouhnZokusei(mosSyouhn.getSyouhncd(), mosSyouhn.getSyouhnsdno());
            mosnaiCheckParam.setSyuSyouhnZokusei(syouhnZokusei);
        }
        List<HT_HubiMsg> hubiMsgLst = syoriCTL.getHubiMsgs();
        mosnaiCheckParam.setListHubiMsg(hubiMsgLst);
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setSysKbn(C_SysKbn.ESHIEN);
        mosnaiCheckParam.setSakuinTsnKbn(C_SakuintsnKbn.SEIJYOU);
        mosnaiCheckParam.setKiteiCheckChannelCd(C_Channelcd.TIGIN);
        checkTuusan.exec(mosnaiCheckParam, tuusan);
        exNumericEquals(hubiMsgLst.size(), 0, "不備メッセージテーブルエンティティリストの件数");
        exClassificationEquals(mosnaiCheckParam.getSekmossakuseiErroutKbn(), C_SekmossakuseiErroutKbn.GAMEN,
            "設計書申込書作成エラー出力区分 ");
        exStringEquals(mosnaiCheckParam.getSekmossakuseiErrmsg1(), "通算保険料が限度額を超えています", "設計書申込書作成エラーメッセージ１");
        exStringEquals(mosnaiCheckParam.getSekmossakuseiErrmsg2(), "保険料は２３０円までにしてください", "設計書申込書作成エラーメッセージ２");
        exClassificationEquals(mosnaiCheckParam.getKouzokuSyoriJikkouKbn(), C_KouzokujkKbn.NONE, "後続処理実行区分");
        exClassificationEquals(mosnaiCheckParam.getSakuinTsnKbn(), C_SakuintsnKbn.ERROR, "索引通算区分");
    }

    @Test
    @TestOrder(260)
    public void testExec_A26() {
        KeisanSPMockForSinkeiyaku.SYORIPTN = KeisanSPMockForSinkeiyaku.TESTPATTERN4;
        KeisanGaikakanzanMockForSinkeiyaku.SYORIPTN = null;
        GetKiteiCheckYenkansangkMockForSinkeiyaku.SYORIPTN = GetKiteiCheckYenkansangkMockForSinkeiyaku.TESTPATTERN18;
        TuusanMockForSinkeiyaku.SYORIPTN = TuusanMockForSinkeiyaku.TESTPATTERN13;
        CheckSaiteiPMockForSinkeiyaku.SYORIPTN = CheckSaiteiPMockForSinkeiyaku.TESTPATTERN16;
        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("791112378");
        List<HT_MosSyouhn> mosSyouhnLst = syoriCTL.getMosSyouhnsBySyutkkbn(C_SyutkKbn.SYU);
        Tuusan tuusan = SWAKInjector.getInstance(Tuusan.class);
        if (mosSyouhnLst.size() > 0) {
            HT_MosSyouhn mosSyouhn = mosSyouhnLst.get(0);
            BM_SyouhnZokusei syouhnZokusei =
                bizDomManager.getSyouhnZokusei(mosSyouhn.getSyouhncd(), mosSyouhn.getSyouhnsdno());
            mosnaiCheckParam.setSyuSyouhnZokusei(syouhnZokusei);
        }
        List<HT_HubiMsg> hubiMsgLst = syoriCTL.getHubiMsgs();
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setListHubiMsg(hubiMsgLst);
        mosnaiCheckParam.setSysKbn(C_SysKbn.ESHIEN);
        mosnaiCheckParam.setSakuinTsnKbn(C_SakuintsnKbn.SEIJYOU);
        mosnaiCheckParam.setBosyuuSysCtrlKbn(C_BosyuusysctrlKbn.SMBC);
        mosnaiCheckParam.setKiteiCheckChannelCd(C_Channelcd.TIGIN);

        checkTuusan.exec(mosnaiCheckParam, tuusan);
        exNumericEquals(hubiMsgLst.size(), 0, "不備メッセージテーブルエンティティリストの件数");
        exClassificationEquals(mosnaiCheckParam.getSekmossakuseiErroutKbn(), C_SekmossakuseiErroutKbn.GAMEN,
            "設計書申込書作成エラー出力区分 ");
        exStringEquals(mosnaiCheckParam.getSekmossakuseiErrmsg1(), "通算年金原資額が限度額を超えています", "設計書申込書作成エラーメッセージ１");
        exStringEquals(mosnaiCheckParam.getSekmossakuseiErrmsg2(), "払込金額は４８円までにしてください", "設計書申込書作成エラーメッセージ２");
        exClassificationEquals(mosnaiCheckParam.getKouzokuSyoriJikkouKbn(), C_KouzokujkKbn.NONE, "後続処理実行区分");
        exClassificationEquals(mosnaiCheckParam.getSakuinTsnKbn(), C_SakuintsnKbn.ERROR, "索引通算区分");

    }

    @Test
    @TestOrder(270)
    public void testExec_A27() {
        KeisanGaikakanzanMockForSinkeiyaku.SYORIPTN = null;
        TuusanMockForSinkeiyaku.SYORIPTN = TuusanMockForSinkeiyaku.TESTPATTERN13;
        CheckSaiteiPMockForSinkeiyaku.SYORIPTN = CheckSaiteiPMockForSinkeiyaku.TESTPATTERN2;
        KeisanSPMockForSinkeiyaku.SYORIPTN = null;
        GetKiteiCheckYenkansangkMockForSinkeiyaku.SYORIPTN = GetKiteiCheckYenkansangkMockForSinkeiyaku.TESTPATTERN4;
        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("860000041");
        List<HT_MosSyouhn> mosSyouhnLst = syoriCTL.getMosSyouhnsBySyutkkbn(C_SyutkKbn.SYU);
        Tuusan tuusan = SWAKInjector.getInstance(Tuusan.class);
        if (mosSyouhnLst.size() > 0) {
            HT_MosSyouhn mosSyouhn = mosSyouhnLst.get(0);
            BM_SyouhnZokusei syouhnZokusei =
                bizDomManager.getSyouhnZokusei(mosSyouhn.getSyouhncd(), mosSyouhn.getSyouhnsdno());
            mosnaiCheckParam.setSyuSyouhnZokusei(syouhnZokusei);
        }
        List<HT_HubiMsg> hubiMsgLst = syoriCTL.getHubiMsgs();
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setListHubiMsg(hubiMsgLst);
        mosnaiCheckParam.setSysKbn(C_SysKbn.SKEI);
        mosnaiCheckParam.setSakuinTsnKbn(C_SakuintsnKbn.SEIJYOU);
        mosnaiCheckParam.setKiteiCheckChannelCd(C_Channelcd.TIGIN);
        checkTuusan.exec(mosnaiCheckParam, tuusan);
        exNumericEquals(hubiMsgLst.size(), 1, "不備メッセージテーブルエンティティリストの件数");
        exStringEquals(hubiMsgLst.get(0).getMosno(), "860000041", "申込番号");
        exNumericEquals(hubiMsgLst.get(0).getRenno(), 1, "連番");
        exStringEquals(hubiMsgLst.get(0).getHubimsg(), "通算２年未経過総死亡Ｓ限度額の１２０円をオーバーしています。　通算２年未経過総死亡Ｓ　２００円", "不備メッセージ");
        exStringEquals(hubiMsgLst.get(0).getMessageId(), "EHC1023", "メッセージＩＤ");
        exClassificationEquals(hubiMsgLst.get(0).getHubisyubetukbn(), C_HubisyubetuKbn.KETHORYU_HUBI, "不備種別区分");

        exClassificationEquals(mosnaiCheckParam.getSakuinTsnKbn(), C_SakuintsnKbn.ERROR, "索引通算区分");

    }

    @Test
    @TestOrder(280)
    public void testExec_A28() {
        KeisanGaikakanzanMockForSinkeiyaku.SYORIPTN = null;
        TuusanMockForSinkeiyaku.SYORIPTN = TuusanMockForSinkeiyaku.TESTPATTERN13;
        CheckSaiteiPMockForSinkeiyaku.SYORIPTN = CheckSaiteiPMockForSinkeiyaku.TESTPATTERN8;
        KeisanSPMockForSinkeiyaku.SYORIPTN = KeisanSPMockForSinkeiyaku.TESTPATTERN8;
        KeisanGaikakanzanMockForSinkeiyaku.SYORIPTN = KeisanGaikakanzanMockForSinkeiyaku.TESTPATTERN1;
        GetKiteiCheckYenkansangkMockForSinkeiyaku.SYORIPTN = GetKiteiCheckYenkansangkMockForSinkeiyaku.TESTPATTERN5;
        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("791112386");
        List<HT_MosSyouhn> mosSyouhnLst = syoriCTL.getMosSyouhnsBySyutkkbn(C_SyutkKbn.SYU);
        Tuusan tuusan = SWAKInjector.getInstance(Tuusan.class);
        if (mosSyouhnLst.size() > 0) {
            HT_MosSyouhn mosSyouhn = mosSyouhnLst.get(0);
            BM_SyouhnZokusei syouhnZokusei =
                bizDomManager.getSyouhnZokusei(mosSyouhn.getSyouhncd(), mosSyouhn.getSyouhnsdno());
            mosnaiCheckParam.setSyuSyouhnZokusei(syouhnZokusei);
        }
        List<HT_HubiMsg> hubiMsgLst = syoriCTL.getHubiMsgs();
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setListHubiMsg(hubiMsgLst);
        mosnaiCheckParam.setSysKbn(C_SysKbn.SKEI);
        mosnaiCheckParam.setSakuinTsnKbn(C_SakuintsnKbn.SEIJYOU);
        mosnaiCheckParam.setKiteiCheckChannelCd(C_Channelcd.TIGIN);
        checkTuusan.exec(mosnaiCheckParam, tuusan);
        exNumericEquals(hubiMsgLst.size(), 1, "不備メッセージテーブルエンティティリストの件数");
        exStringEquals(hubiMsgLst.get(0).getMosno(), "791112386", "申込番号");
        exNumericEquals(hubiMsgLst.get(0).getRenno(), 1, "連番");
        exStringEquals(hubiMsgLst.get(0).getHubimsg(), "通算２年未経過総死亡Ｓ限度額の１２０円をオーバーしています。　保険料は２３０円までにしてください。",
            "不備メッセージ");
        exStringEquals(hubiMsgLst.get(0).getMessageId(), "EHC1045", "メッセージＩＤ");
        exClassificationEquals(hubiMsgLst.get(0).getHubisyubetukbn(), C_HubisyubetuKbn.KETHORYU_HUBI, "不備種別区分");

        exClassificationEquals(mosnaiCheckParam.getSakuinTsnKbn(), C_SakuintsnKbn.ERROR, "索引通算区分");

    }

    @Test
    @TestOrder(290)
    public void testExec_A29() {
        KeisanGaikakanzanMockForSinkeiyaku.SYORIPTN = null;
        TuusanMockForSinkeiyaku.SYORIPTN = TuusanMockForSinkeiyaku.TESTPATTERN13;
        CheckSaiteiPMockForSinkeiyaku.SYORIPTN = CheckSaiteiPMockForSinkeiyaku.TESTPATTERN9;
        KeisanSPMockForSinkeiyaku.SYORIPTN = KeisanSPMockForSinkeiyaku.TESTPATTERN8;
        KeisanGaikakanzanMockForSinkeiyaku.SYORIPTN = KeisanGaikakanzanMockForSinkeiyaku.TESTPATTERN1;
        GetKiteiCheckYenkansangkMockForSinkeiyaku.SYORIPTN = GetKiteiCheckYenkansangkMockForSinkeiyaku.TESTPATTERN5;
        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("791112386");
        List<HT_MosSyouhn> mosSyouhnLst = syoriCTL.getMosSyouhnsBySyutkkbn(C_SyutkKbn.SYU);
        Tuusan tuusan = SWAKInjector.getInstance(Tuusan.class);
        if (mosSyouhnLst.size() > 0) {
            HT_MosSyouhn mosSyouhn = mosSyouhnLst.get(0);
            BM_SyouhnZokusei syouhnZokusei =
                bizDomManager.getSyouhnZokusei(mosSyouhn.getSyouhncd(), mosSyouhn.getSyouhnsdno());
            mosnaiCheckParam.setSyuSyouhnZokusei(syouhnZokusei);
        }
        List<HT_HubiMsg> hubiMsgLst = syoriCTL.getHubiMsgs();
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setListHubiMsg(hubiMsgLst);
        mosnaiCheckParam.setSysKbn(C_SysKbn.SKEI);
        mosnaiCheckParam.setSakuinTsnKbn(C_SakuintsnKbn.SEIJYOU);
        mosnaiCheckParam.setKiteiCheckChannelCd(C_Channelcd.TIGIN);
        checkTuusan.exec(mosnaiCheckParam, tuusan);
        exNumericEquals(hubiMsgLst.size(), 1, "不備メッセージテーブルエンティティリストの件数");
        exStringEquals(hubiMsgLst.get(0).getMosno(), "791112386", "申込番号");
        exNumericEquals(hubiMsgLst.get(0).getRenno(), 1, "連番");
        exStringEquals(hubiMsgLst.get(0).getHubimsg(), "通算２年未経過総死亡Ｓ限度額の１２０円をオーバーしています。　保険料は２３０円までにしてください。",
            "不備メッセージ");
        exStringEquals(hubiMsgLst.get(0).getMessageId(), "EHC1045", "メッセージＩＤ");
        exClassificationEquals(hubiMsgLst.get(0).getHubisyubetukbn(), C_HubisyubetuKbn.KETHORYU_HUBI, "不備種別区分");

        exClassificationEquals(mosnaiCheckParam.getSakuinTsnKbn(), C_SakuintsnKbn.ERROR, "索引通算区分");

    }

    @Test
    @TestOrder(300)
    public void testExec_A30() {
        KeisanGaikakanzanMockForSinkeiyaku.SYORIPTN = null;
        TuusanMockForSinkeiyaku.SYORIPTN = TuusanMockForSinkeiyaku.TESTPATTERN15;
        CheckSaiteiPMockForSinkeiyaku.SYORIPTN = CheckSaiteiPMockForSinkeiyaku.TESTPATTERN10;
        KeisanSPMockForSinkeiyaku.SYORIPTN = KeisanSPMockForSinkeiyaku.TESTPATTERN1;
        GetKiteiCheckYenkansangkMockForSinkeiyaku.SYORIPTN = GetKiteiCheckYenkansangkMockForSinkeiyaku.TESTPATTERN6;
        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("791112519");
        List<HT_MosSyouhn> mosSyouhnLst = syoriCTL.getMosSyouhnsBySyutkkbn(C_SyutkKbn.SYU);
        Tuusan tuusan = SWAKInjector.getInstance(Tuusan.class);
        if (mosSyouhnLst.size() > 0) {
            HT_MosSyouhn mosSyouhn = mosSyouhnLst.get(0);
            BM_SyouhnZokusei syouhnZokusei =
                bizDomManager.getSyouhnZokusei(mosSyouhn.getSyouhncd(), mosSyouhn.getSyouhnsdno());
            mosnaiCheckParam.setSyuSyouhnZokusei(syouhnZokusei);
        }
        List<HT_HubiMsg> hubiMsgLst = syoriCTL.getHubiMsgs();
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setListHubiMsg(hubiMsgLst);
        mosnaiCheckParam.setSysKbn(C_SysKbn.ESHIEN);
        mosnaiCheckParam.setSakuinTsnKbn(C_SakuintsnKbn.SEIJYOU);
        mosnaiCheckParam.setKiteiCheckChannelCd(C_Channelcd.TIGIN);
        checkTuusan.exec(mosnaiCheckParam, tuusan);
        exNumericEquals(hubiMsgLst.size(), 0, "不備メッセージテーブルエンティティリストの件数");
        exClassificationEquals(mosnaiCheckParam.getSekmossakuseiErroutKbn(), C_SekmossakuseiErroutKbn.GAMEN,
            "設計書申込書作成エラー出力区分 ");
        exStringEquals(mosnaiCheckParam.getSekmossakuseiErrmsg1(), "", "設計書申込書作成エラーメッセージ１");
        exStringEquals(mosnaiCheckParam.getSekmossakuseiErrmsg2(), "通算保険金額が限度額を超えています　ご加入できません", "設計書申込書作成エラーメッセージ２");
        exClassificationEquals(mosnaiCheckParam.getKouzokuSyoriJikkouKbn(), C_KouzokujkKbn.NONE, "後続処理実行区分");
        exClassificationEquals(mosnaiCheckParam.getSakuinTsnKbn(), C_SakuintsnKbn.ERROR, "索引通算区分");
    }

    @Test
    @TestOrder(310)
    public void testExec_A31() {
        KeisanGaikakanzanMockForSinkeiyaku.SYORIPTN = null;
        TuusanMockForSinkeiyaku.SYORIPTN = TuusanMockForSinkeiyaku.TESTPATTERN15;
        CheckSaiteiPMockForSinkeiyaku.SYORIPTN = CheckSaiteiPMockForSinkeiyaku.TESTPATTERN14;
        KeisanSPMockForSinkeiyaku.SYORIPTN = null;
        GetKiteiCheckYenkansangkMockForSinkeiyaku.SYORIPTN = GetKiteiCheckYenkansangkMockForSinkeiyaku.TESTPATTERN6;
        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("791112519");
        List<HT_MosSyouhn> mosSyouhnLst = syoriCTL.getMosSyouhnsBySyutkkbn(C_SyutkKbn.SYU);
        Tuusan tuusan = SWAKInjector.getInstance(Tuusan.class);
        if (mosSyouhnLst.size() > 0) {
            HT_MosSyouhn mosSyouhn = mosSyouhnLst.get(0);
            BM_SyouhnZokusei syouhnZokusei =
                bizDomManager.getSyouhnZokusei(mosSyouhn.getSyouhncd(), mosSyouhn.getSyouhnsdno());
            mosnaiCheckParam.setSyuSyouhnZokusei(syouhnZokusei);
        }
        List<HT_HubiMsg> hubiMsgLst = syoriCTL.getHubiMsgs();
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setListHubiMsg(hubiMsgLst);
        mosnaiCheckParam.setSysKbn(C_SysKbn.ESHIEN);
        mosnaiCheckParam.setSakuinTsnKbn(C_SakuintsnKbn.SEIJYOU);
        mosnaiCheckParam.setSekmossakuseiOyaAgCd("5102150");
        mosnaiCheckParam.setKiteiCheckChannelCd(C_Channelcd.TIGIN);
        checkTuusan.exec(mosnaiCheckParam, tuusan);
        exNumericEquals(hubiMsgLst.size(), 0, "不備メッセージテーブルエンティティリストの件数");
        exClassificationEquals(mosnaiCheckParam.getSekmossakuseiErroutKbn(), C_SekmossakuseiErroutKbn.GAMEN,
            "設計書申込書作成エラー出力区分 ");
        exStringEquals(mosnaiCheckParam.getSekmossakuseiErrmsg1(), "通算保険金額が限度額を超えています", "設計書申込書作成エラーメッセージ１");
        exStringEquals(mosnaiCheckParam.getSekmossakuseiErrmsg2(), "保険料は９２円までにしてください", "設計書申込書作成エラーメッセージ２");
        exClassificationEquals(mosnaiCheckParam.getKouzokuSyoriJikkouKbn(), C_KouzokujkKbn.NONE, "後続処理実行区分");
        exClassificationEquals(mosnaiCheckParam.getSakuinTsnKbn(), C_SakuintsnKbn.ERROR, "索引通算区分");
    }

    @Test
    @TestOrder(320)
    public void testExec_A32() {
        KeisanGaikakanzanMockForSinkeiyaku.SYORIPTN = null;
        TuusanMockForSinkeiyaku.SYORIPTN = TuusanMockForSinkeiyaku.TESTPATTERN15;
        CheckSaiteiPMockForSinkeiyaku.SYORIPTN = CheckSaiteiPMockForSinkeiyaku.TESTPATTERN15;
        KeisanSPMockForSinkeiyaku.SYORIPTN = null;
        GetKiteiCheckYenkansangkMockForSinkeiyaku.SYORIPTN = GetKiteiCheckYenkansangkMockForSinkeiyaku.TESTPATTERN6;
        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("791112519");
        List<HT_MosSyouhn> mosSyouhnLst = syoriCTL.getMosSyouhnsBySyutkkbn(C_SyutkKbn.SYU);
        Tuusan tuusan = SWAKInjector.getInstance(Tuusan.class);
        if (mosSyouhnLst.size() > 0) {
            HT_MosSyouhn mosSyouhn = mosSyouhnLst.get(0);
            BM_SyouhnZokusei syouhnZokusei =
                bizDomManager.getSyouhnZokusei(mosSyouhn.getSyouhncd(), mosSyouhn.getSyouhnsdno());
            mosnaiCheckParam.setSyuSyouhnZokusei(syouhnZokusei);
        }
        List<HT_HubiMsg> hubiMsgLst = syoriCTL.getHubiMsgs();
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setListHubiMsg(hubiMsgLst);
        mosnaiCheckParam.setSysKbn(C_SysKbn.ESHIEN);
        mosnaiCheckParam.setSakuinTsnKbn(C_SakuintsnKbn.SEIJYOU);
        mosnaiCheckParam.setKiteiCheckChannelCd(C_Channelcd.TIGIN);
        checkTuusan.exec(mosnaiCheckParam, tuusan);
        exNumericEquals(hubiMsgLst.size(), 0, "不備メッセージテーブルエンティティリストの件数");
        exClassificationEquals(mosnaiCheckParam.getSekmossakuseiErroutKbn(), C_SekmossakuseiErroutKbn.GAMEN,
            "設計書申込書作成エラー出力区分 ");
        exStringEquals(mosnaiCheckParam.getSekmossakuseiErrmsg1(), "通算保険金額が限度額を超えています", "設計書申込書作成エラーメッセージ１");
        exStringEquals(mosnaiCheckParam.getSekmossakuseiErrmsg2(), "保険料は９２円までにしてください", "設計書申込書作成エラーメッセージ２");
        exClassificationEquals(mosnaiCheckParam.getKouzokuSyoriJikkouKbn(), C_KouzokujkKbn.NONE, "後続処理実行区分");
        exClassificationEquals(mosnaiCheckParam.getSakuinTsnKbn(), C_SakuintsnKbn.ERROR, "索引通算区分");
    }

    @Test
    @TestOrder(330)
    public void testExec_A33() {
        TuusanMockForSinkeiyaku.SYORIPTN = TuusanMockForSinkeiyaku.TESTPATTERN31;
        CheckSaiteiPMockForSinkeiyaku.SYORIPTN = CheckSaiteiPMockForSinkeiyaku.TESTPATTERN9;
        KeisanSPMockForSinkeiyaku.SYORIPTN = KeisanSPMockForSinkeiyaku.TESTPATTERN8;
        KeisanGaikakanzanMockForSinkeiyaku.SYORIPTN = KeisanGaikakanzanMockForSinkeiyaku.TESTPATTERN1;
        GetKiteiCheckYenkansangkMockForSinkeiyaku.SYORIPTN = GetKiteiCheckYenkansangkMockForSinkeiyaku.TESTPATTERN5;
        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("791112386");
        List<HT_MosSyouhn> mosSyouhnLst = syoriCTL.getMosSyouhnsBySyutkkbn(C_SyutkKbn.SYU);
        Tuusan tuusan = SWAKInjector.getInstance(Tuusan.class);
        if (mosSyouhnLst.size() > 0) {
            HT_MosSyouhn mosSyouhn = mosSyouhnLst.get(0);
            BM_SyouhnZokusei syouhnZokusei =
                bizDomManager.getSyouhnZokusei(mosSyouhn.getSyouhncd(), mosSyouhn.getSyouhnsdno());
            mosnaiCheckParam.setSyuSyouhnZokusei(syouhnZokusei);
        }
        List<HT_HubiMsg> hubiMsgLst = syoriCTL.getHubiMsgs();
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setListHubiMsg(hubiMsgLst);
        mosnaiCheckParam.setSysKbn(C_SysKbn.SKEI);
        mosnaiCheckParam.setSakuinTsnKbn(C_SakuintsnKbn.SEIJYOU);
        mosnaiCheckParam.setKiteiCheckChannelCd(C_Channelcd.TIGIN);
        checkTuusan.exec(mosnaiCheckParam, tuusan);
        exNumericEquals(hubiMsgLst.size(), 1, "不備メッセージテーブルエンティティリストの件数");
        exStringEquals(hubiMsgLst.get(0).getMosno(), "791112386", "申込番号");
        exNumericEquals(hubiMsgLst.get(0).getRenno(), 1, "連番");
        exStringEquals(hubiMsgLst.get(0).getHubimsg(), "通算２年未経過総死亡Ｓ限度額の１２０円をオーバーしています。　保険料は２３０円までにしてください。",
            "不備メッセージ");
        exStringEquals(hubiMsgLst.get(0).getMessageId(), "EHC1045", "メッセージＩＤ");
        exClassificationEquals(hubiMsgLst.get(0).getHubisyubetukbn(), C_HubisyubetuKbn.KETHORYU_HUBI, "不備種別区分");

        exClassificationEquals(mosnaiCheckParam.getSakuinTsnKbn(), C_SakuintsnKbn.ERROR, "索引通算区分");

    }

    @Test
    @TestOrder(340)
    public void testExec_A34() {
        KeisanGaikakanzanMockForSinkeiyaku.SYORIPTN = null;
        TuusanMockForSinkeiyaku.SYORIPTN = TuusanMockForSinkeiyaku.TESTPATTERN66;
        CheckSaiteiPMockForSinkeiyaku.SYORIPTN = CheckSaiteiPMockForSinkeiyaku.TESTPATTERN11;
        KeisanSPMockForSinkeiyaku.SYORIPTN = KeisanSPMockForSinkeiyaku.TESTPATTERN2;
        GetKiteiCheckYenkansangkMockForSinkeiyaku.SYORIPTN = GetKiteiCheckYenkansangkMockForSinkeiyaku.TESTPATTERN7;
        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("791112360");
        List<HT_MosSyouhn> mosSyouhnLst = syoriCTL.getMosSyouhnsBySyutkkbn(C_SyutkKbn.SYU);
        Tuusan tuusan = SWAKInjector.getInstance(Tuusan.class);
        if (mosSyouhnLst.size() > 0) {
            HT_MosSyouhn mosSyouhn = mosSyouhnLst.get(0);
            BM_SyouhnZokusei syouhnZokusei =
                bizDomManager.getSyouhnZokusei(mosSyouhn.getSyouhncd(), mosSyouhn.getSyouhnsdno());
            mosnaiCheckParam.setSyuSyouhnZokusei(syouhnZokusei);
        }
        List<HT_HubiMsg> hubiMsgLst = syoriCTL.getHubiMsgs();
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setListHubiMsg(hubiMsgLst);
        mosnaiCheckParam.setSysKbn(C_SysKbn.SKEI);
        mosnaiCheckParam.setSakuinTsnKbn(C_SakuintsnKbn.SEIJYOU);
        mosnaiCheckParam.setKiteiCheckChannelCd(C_Channelcd.TIGIN);
        checkTuusan.exec(mosnaiCheckParam, tuusan);
        exNumericEquals(hubiMsgLst.size(), 0, "不備メッセージテーブルエンティティリストの件数");
        exClassificationEquals(mosnaiCheckParam.getSakuinTsnKbn(), C_SakuintsnKbn.SEIJYOU, "索引通算区分");

    }

    @Test
    @TestOrder(350)
    public void testExec_A35() {
        KeisanGaikakanzanMockForSinkeiyaku.SYORIPTN = null;
        GetKiteiCheckYenkansangkMockForSinkeiyaku.SYORIPTN = null;
        TuusanMockForSinkeiyaku.SYORIPTN = TuusanMockForSinkeiyaku.TESTPATTERN12;
        CheckSaiteiPMockForSinkeiyaku.SYORIPTN = CheckSaiteiPMockForSinkeiyaku.TESTPATTERN1;
        KeisanSPMockForSinkeiyaku.SYORIPTN = KeisanSPMockForSinkeiyaku.TESTPATTERN1;
        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("791112360");
        List<HT_MosSyouhn> mosSyouhnLst = syoriCTL.getMosSyouhnsBySyutkkbn(C_SyutkKbn.SYU);
        Tuusan tuusan = SWAKInjector.getInstance(Tuusan.class);
        if (mosSyouhnLst.size() > 0) {
            HT_MosSyouhn mosSyouhn = mosSyouhnLst.get(0);
            BM_SyouhnZokusei syouhnZokusei =
                bizDomManager.getSyouhnZokusei(mosSyouhn.getSyouhncd(), mosSyouhn.getSyouhnsdno());
            mosnaiCheckParam.setSyuSyouhnZokusei(syouhnZokusei);
        }
        List<HT_HubiMsg> hubiMsgLst = syoriCTL.getHubiMsgs();
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setListHubiMsg(hubiMsgLst);
        mosnaiCheckParam.setSysKbn(C_SysKbn.ESHIEN);
        mosnaiCheckParam.setSakuinTsnKbn(C_SakuintsnKbn.SEIJYOU);
        mosnaiCheckParam.setKiteiCheckChannelCd(C_Channelcd.TIGIN);

        checkTuusan.exec(mosnaiCheckParam, tuusan);
        exNumericEquals(hubiMsgLst.size(), 0, "不備メッセージテーブルエンティティリストの件数");
        exClassificationEquals(mosnaiCheckParam.getSekmossakuseiErroutKbn(), C_SekmossakuseiErroutKbn.GAMEN,
            "設計書申込書作成エラー出力区分 ");
        exStringEquals(mosnaiCheckParam.getSekmossakuseiErrmsg1(), "通算保険金額が限度額を超えています", "設計書申込書作成エラーメッセージ１");
        exStringEquals(mosnaiCheckParam.getSekmossakuseiErrmsg2(), "保険料は０円までにしてください", "設計書申込書作成エラーメッセージ２");
        exClassificationEquals(mosnaiCheckParam.getKouzokuSyoriJikkouKbn(), C_KouzokujkKbn.NONE, "後続処理実行区分");
        exClassificationEquals(mosnaiCheckParam.getSakuinTsnKbn(), C_SakuintsnKbn.ERROR, "索引通算区分");

    }

    @Test
    @TestOrder(360)
    public void testExec_A36() {
        KeisanGaikakanzanMockForSinkeiyaku.SYORIPTN = null;
        TuusanMockForSinkeiyaku.SYORIPTN = TuusanMockForSinkeiyaku.TESTPATTERN12;
        CheckSaiteiPMockForSinkeiyaku.SYORIPTN = CheckSaiteiPMockForSinkeiyaku.TESTPATTERN11;
        KeisanSPMockForSinkeiyaku.SYORIPTN = KeisanSPMockForSinkeiyaku.TESTPATTERN2;
        GetKiteiCheckYenkansangkMockForSinkeiyaku.SYORIPTN = GetKiteiCheckYenkansangkMockForSinkeiyaku.TESTPATTERN7;
        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("791112360");
        List<HT_MosSyouhn> mosSyouhnLst = syoriCTL.getMosSyouhnsBySyutkkbn(C_SyutkKbn.SYU);
        Tuusan tuusan = SWAKInjector.getInstance(Tuusan.class);
        if (mosSyouhnLst.size() > 0) {
            HT_MosSyouhn mosSyouhn = mosSyouhnLst.get(0);
            BM_SyouhnZokusei syouhnZokusei =
                bizDomManager.getSyouhnZokusei(mosSyouhn.getSyouhncd(), mosSyouhn.getSyouhnsdno());
            mosnaiCheckParam.setSyuSyouhnZokusei(syouhnZokusei);
        }
        List<HT_HubiMsg> hubiMsgLst = syoriCTL.getHubiMsgs();
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setListHubiMsg(hubiMsgLst);
        mosnaiCheckParam.setSysKbn(C_SysKbn.SKEI);
        mosnaiCheckParam.setSakuinTsnKbn(C_SakuintsnKbn.SEIJYOU);
        mosnaiCheckParam.setKiteiCheckChannelCd(C_Channelcd.TIGIN);
        checkTuusan.exec(mosnaiCheckParam, tuusan);
        exNumericEquals(hubiMsgLst.size(), 1, "不備メッセージテーブルエンティティリストの件数");
        exStringEquals(hubiMsgLst.get(0).getMosno(), "791112360", "申込番号");
        exNumericEquals(hubiMsgLst.get(0).getRenno(), 1, "連番");
        exStringEquals(hubiMsgLst.get(0).getHubimsg(), "【特認可能】通算総死亡Ｓ限度額の１０５円をオーバーしています。　ご加入できません。", "不備メッセージ");
        exStringEquals(hubiMsgLst.get(0).getMessageId(), "THC1042", "メッセージＩＤ");
        exClassificationEquals(hubiMsgLst.get(0).getHubisyubetukbn(), C_HubisyubetuKbn.KETHORYU_HUBI, "不備種別区分");

        exClassificationEquals(mosnaiCheckParam.getSakuinTsnKbn(), C_SakuintsnKbn.ERROR, "索引通算区分");

    }

    @Test
    @TestOrder(370)
    public void testExec_A37() {
        KeisanGaikakanzanMockForSinkeiyaku.SYORIPTN = null;
        TuusanMockForSinkeiyaku.SYORIPTN = TuusanMockForSinkeiyaku.TESTPATTERN12;
        CheckSaiteiPMockForSinkeiyaku.SYORIPTN = CheckSaiteiPMockForSinkeiyaku.TESTPATTERN12;
        KeisanSPMockForSinkeiyaku.SYORIPTN = KeisanSPMockForSinkeiyaku.TESTPATTERN2;
        GetKiteiCheckYenkansangkMockForSinkeiyaku.SYORIPTN = GetKiteiCheckYenkansangkMockForSinkeiyaku.TESTPATTERN7;
        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("791112360");
        List<HT_MosSyouhn> mosSyouhnLst = syoriCTL.getMosSyouhnsBySyutkkbn(C_SyutkKbn.SYU);
        Tuusan tuusan = SWAKInjector.getInstance(Tuusan.class);
        if (mosSyouhnLst.size() > 0) {
            HT_MosSyouhn mosSyouhn = mosSyouhnLst.get(0);
            BM_SyouhnZokusei syouhnZokusei =
                bizDomManager.getSyouhnZokusei(mosSyouhn.getSyouhncd(), mosSyouhn.getSyouhnsdno());
            mosnaiCheckParam.setSyuSyouhnZokusei(syouhnZokusei);
        }
        List<HT_HubiMsg> hubiMsgLst = syoriCTL.getHubiMsgs();
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setListHubiMsg(hubiMsgLst);
        mosnaiCheckParam.setSysKbn(C_SysKbn.SKEI);
        mosnaiCheckParam.setSakuinTsnKbn(C_SakuintsnKbn.SEIJYOU);
        mosnaiCheckParam.setKiteiCheckChannelCd(C_Channelcd.TIGIN);
        checkTuusan.exec(mosnaiCheckParam, tuusan);
        exNumericEquals(hubiMsgLst.size(), 1, "不備メッセージテーブルエンティティリストの件数");
        exStringEquals(hubiMsgLst.get(0).getMosno(), "791112360", "申込番号");
        exNumericEquals(hubiMsgLst.get(0).getRenno(), 1, "連番");
        exStringEquals(hubiMsgLst.get(0).getHubimsg(), "【特認可能】通算総死亡Ｓ限度額の１０５円をオーバーしています。　保険料は６４４円までにしてください。", "不備メッセージ");
        exStringEquals(hubiMsgLst.get(0).getMessageId(), "THC1043", "メッセージＩＤ");
        exClassificationEquals(hubiMsgLst.get(0).getHubisyubetukbn(), C_HubisyubetuKbn.KETHORYU_HUBI, "不備種別区分");

        exClassificationEquals(mosnaiCheckParam.getSakuinTsnKbn(), C_SakuintsnKbn.ERROR, "索引通算区分");

    }

    @Test
    @TestOrder(380)
    public void testExec_A38() {
        KeisanGaikakanzanMockForSinkeiyaku.SYORIPTN = null;
        TuusanMockForSinkeiyaku.SYORIPTN = TuusanMockForSinkeiyaku.TESTPATTERN12;
        CheckSaiteiPMockForSinkeiyaku.SYORIPTN = CheckSaiteiPMockForSinkeiyaku.TESTPATTERN13;
        KeisanSPMockForSinkeiyaku.SYORIPTN = KeisanSPMockForSinkeiyaku.TESTPATTERN2;
        GetKiteiCheckYenkansangkMockForSinkeiyaku.SYORIPTN = GetKiteiCheckYenkansangkMockForSinkeiyaku.TESTPATTERN7;
        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("791112360");
        List<HT_MosSyouhn> mosSyouhnLst = syoriCTL.getMosSyouhnsBySyutkkbn(C_SyutkKbn.SYU);
        Tuusan tuusan = SWAKInjector.getInstance(Tuusan.class);
        if (mosSyouhnLst.size() > 0) {
            HT_MosSyouhn mosSyouhn = mosSyouhnLst.get(0);
            BM_SyouhnZokusei syouhnZokusei =
                bizDomManager.getSyouhnZokusei(mosSyouhn.getSyouhncd(), mosSyouhn.getSyouhnsdno());
            mosnaiCheckParam.setSyuSyouhnZokusei(syouhnZokusei);
        }
        List<HT_HubiMsg> hubiMsgLst = syoriCTL.getHubiMsgs();
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setListHubiMsg(hubiMsgLst);
        mosnaiCheckParam.setSysKbn(C_SysKbn.SKEI);
        mosnaiCheckParam.setSakuinTsnKbn(C_SakuintsnKbn.SEIJYOU);
        mosnaiCheckParam.setKiteiCheckChannelCd(C_Channelcd.TIGIN);
        checkTuusan.exec(mosnaiCheckParam, tuusan);
        exNumericEquals(hubiMsgLst.size(), 1, "不備メッセージテーブルエンティティリストの件数");
        exStringEquals(hubiMsgLst.get(0).getMosno(), "791112360", "申込番号");
        exNumericEquals(hubiMsgLst.get(0).getRenno(), 1, "連番");
        exStringEquals(hubiMsgLst.get(0).getHubimsg(), "【特認可能】通算総死亡Ｓ限度額の１０５円をオーバーしています。　保険料は６４４円までにしてください。", "不備メッセージ");
        exStringEquals(hubiMsgLst.get(0).getMessageId(), "THC1043", "メッセージＩＤ");
        exClassificationEquals(hubiMsgLst.get(0).getHubisyubetukbn(), C_HubisyubetuKbn.KETHORYU_HUBI, "不備種別区分");

        exClassificationEquals(mosnaiCheckParam.getSakuinTsnKbn(), C_SakuintsnKbn.ERROR, "索引通算区分");

    }

    @Test
    @TestOrder(390)
    public void testExec_A39() {
        KeisanGaikakanzanMockForSinkeiyaku.SYORIPTN = null;
        TuusanMockForSinkeiyaku.SYORIPTN = TuusanMockForSinkeiyaku.TESTPATTERN12;
        CheckSaiteiPMockForSinkeiyaku.SYORIPTN = CheckSaiteiPMockForSinkeiyaku.TESTPATTERN11;
        KeisanSPMockForSinkeiyaku.SYORIPTN = KeisanSPMockForSinkeiyaku.TESTPATTERN2;
        GetKiteiCheckYenkansangkMockForSinkeiyaku.SYORIPTN = GetKiteiCheckYenkansangkMockForSinkeiyaku.TESTPATTERN7;
        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("860000058");
        List<HT_MosSyouhn> mosSyouhnLst = syoriCTL.getMosSyouhnsBySyutkkbn(C_SyutkKbn.SYU);
        Tuusan tuusan = SWAKInjector.getInstance(Tuusan.class);
        if (mosSyouhnLst.size() > 0) {
            HT_MosSyouhn mosSyouhn = mosSyouhnLst.get(0);
            BM_SyouhnZokusei syouhnZokusei =
                bizDomManager.getSyouhnZokusei(mosSyouhn.getSyouhncd(), mosSyouhn.getSyouhnsdno());
            mosnaiCheckParam.setSyuSyouhnZokusei(syouhnZokusei);
        }
        List<HT_HubiMsg> hubiMsgLst = syoriCTL.getHubiMsgs();
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setListHubiMsg(hubiMsgLst);
        mosnaiCheckParam.setSysKbn(C_SysKbn.SKEI);
        mosnaiCheckParam.setSakuinTsnKbn(C_SakuintsnKbn.SEIJYOU);
        mosnaiCheckParam.setKiteiCheckChannelCd(C_Channelcd.TIGIN);
        checkTuusan.exec(mosnaiCheckParam, tuusan);
        exNumericEquals(hubiMsgLst.size(), 1, "不備メッセージテーブルエンティティリストの件数");
        exStringEquals(hubiMsgLst.get(0).getMosno(), "860000058", "申込番号");
        exNumericEquals(hubiMsgLst.get(0).getRenno(), 1, "連番");
        exStringEquals(hubiMsgLst.get(0).getHubimsg(), "【特認可能】通算総死亡Ｓ限度額の１０５円をオーバーしています。　通算総死亡Ｓ　３００円", "不備メッセージ");
        exStringEquals(hubiMsgLst.get(0).getMessageId(), "THC1022", "メッセージＩＤ");
        exClassificationEquals(hubiMsgLst.get(0).getHubisyubetukbn(), C_HubisyubetuKbn.KETHORYU_HUBI, "不備種別区分");

        exClassificationEquals(mosnaiCheckParam.getSakuinTsnKbn(), C_SakuintsnKbn.ERROR, "索引通算区分");

    }

    @Test(expected = CommonBizAppException.class)
    @TestOrder(400)
    public void testExec_A40() {
        KeisanSPMockForSinkeiyaku.SYORIPTN = null;
        KeisanGaikakanzanMockForSinkeiyaku.SYORIPTN = null;
        GetKiteiCheckYenkansangkMockForSinkeiyaku.SYORIPTN = null;
        TuusanMockForSinkeiyaku.SYORIPTN = TuusanMockForSinkeiyaku.TESTPATTERN5;
        CheckSaiteiPMockForSinkeiyaku.SYORIPTN = CheckSaiteiPMockForSinkeiyaku.TESTPATTERN1;
        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("791112279");
        List<HT_MosSyouhn> mosSyouhnLst = syoriCTL.getMosSyouhnsBySyutkkbn(C_SyutkKbn.SYU);
        Tuusan tuusan = SWAKInjector.getInstance(Tuusan.class);
        if (mosSyouhnLst.size() > 0) {
            HT_MosSyouhn mosSyouhn = mosSyouhnLst.get(0);
            BM_SyouhnZokusei syouhnZokusei =
                bizDomManager.getSyouhnZokusei(mosSyouhn.getSyouhncd(), mosSyouhn.getSyouhnsdno());
            mosnaiCheckParam.setSyuSyouhnZokusei(syouhnZokusei);
        }
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setSysKbn(C_SysKbn.ESHIEN);
        mosnaiCheckParam.setSakuinTsnKbn(C_SakuintsnKbn.SEIJYOU);
        mosnaiCheckParam.setKiteiCheckChannelCd(C_Channelcd.TIGIN);

        try {
            checkTuusan.exec(mosnaiCheckParam, tuusan);
        } catch (CommonBizAppException e) {
            exStringEquals(e.getMessage(), "システム整合性エラーです。申込番号=791112279", "エラーメッセージ");
            throw e;
        }
    }

    @Test(expected = CommonBizAppException.class)
    @TestOrder(410)
    public void testExec_A41() {
        KeisanSPMockForSinkeiyaku.SYORIPTN = null;
        KeisanGaikakanzanMockForSinkeiyaku.SYORIPTN = null;
        GetKiteiCheckYenkansangkMockForSinkeiyaku.SYORIPTN = null;
        TuusanMockForSinkeiyaku.SYORIPTN = TuusanMockForSinkeiyaku.TESTPATTERN6;
        CheckSaiteiPMockForSinkeiyaku.SYORIPTN = CheckSaiteiPMockForSinkeiyaku.TESTPATTERN1;
        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("791112287");
        List<HT_MosSyouhn> mosSyouhnLst = syoriCTL.getMosSyouhnsBySyutkkbn(C_SyutkKbn.SYU);
        Tuusan tuusan = SWAKInjector.getInstance(Tuusan.class);
        if (mosSyouhnLst.size() > 0) {
            HT_MosSyouhn mosSyouhn = mosSyouhnLst.get(0);
            BM_SyouhnZokusei syouhnZokusei =
                bizDomManager.getSyouhnZokusei(mosSyouhn.getSyouhncd(), mosSyouhn.getSyouhnsdno());
            mosnaiCheckParam.setSyuSyouhnZokusei(syouhnZokusei);
        }
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setSysKbn(C_SysKbn.SKEI);
        mosnaiCheckParam.setSakuinTsnKbn(C_SakuintsnKbn.SEIJYOU);
        mosnaiCheckParam.setKiteiCheckChannelCd(C_Channelcd.TIGIN);
        try {
            checkTuusan.exec(mosnaiCheckParam, tuusan);
        } catch (CommonBizAppException e) {
            exStringEquals(e.getMessage(), "システム整合性エラーです。申込番号=791112287", "エラーメッセージ");
            throw e;
        }
    }

    @Test
    @TestOrder(420)
    public void testExec_A42() {
        MockObjectManager.initialize();
        KeisanSPMockForSinkeiyaku.SYORIPTN = null;
        KeisanGaikakanzanMockForSinkeiyaku.SYORIPTN = null;
        GetKiteiCheckYenkansangkMockForSinkeiyaku.SYORIPTN = null;
        TuusanMockForSinkeiyaku.SYORIPTN = TuusanMockForSinkeiyaku.TESTPATTERN30;
        CheckSaiteiPMockForSinkeiyaku.SYORIPTN = CheckSaiteiPMockForSinkeiyaku.TESTPATTERN8;
        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("860000132");
        List<HT_MosSyouhn> mosSyouhnLst = syoriCTL.getMosSyouhnsBySyutkkbn(C_SyutkKbn.SYU);
        Tuusan tuusan = SWAKInjector.getInstance(Tuusan.class);
        if (mosSyouhnLst.size() > 0) {
            HT_MosSyouhn mosSyouhn = mosSyouhnLst.get(0);
            BM_SyouhnZokusei syouhnZokusei =
                bizDomManager.getSyouhnZokusei(mosSyouhn.getSyouhncd(), mosSyouhn.getSyouhnsdno());
            mosnaiCheckParam.setSyuSyouhnZokusei(syouhnZokusei);
        }
        List<HT_HubiMsg> hubiMsgLst = syoriCTL.getHubiMsgs();
        mosnaiCheckParam.setListHubiMsg(hubiMsgLst);
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setSysKbn(C_SysKbn.ESHIEN);
        mosnaiCheckParam.setSakuinTsnKbn(C_SakuintsnKbn.SEIJYOU);
        mosnaiCheckParam.setKiteiCheckChannelCd(C_Channelcd.TIGIN);
        checkTuusan.exec(mosnaiCheckParam, tuusan);
        exNumericEquals(hubiMsgLst.size(), 0, "不備メッセージテーブルエンティティリストの件数");
        exClassificationEquals(mosnaiCheckParam.getSekmossakuseiErroutKbn(), C_SekmossakuseiErroutKbn.GAMEN,
            "設計書申込書作成エラー出力区分 ");
        exStringEquals(mosnaiCheckParam.getSekmossakuseiErrmsg1(), "通算保険料が限度額を超えています", "設計書申込書作成エラーメッセージ１");
        exStringEquals(mosnaiCheckParam.getSekmossakuseiErrmsg2(), "保険料は２３０円までにしてください", "設計書申込書作成エラーメッセージ２");
        exClassificationEquals(mosnaiCheckParam.getKouzokuSyoriJikkouKbn(), C_KouzokujkKbn.NONE, "後続処理実行区分");
        exClassificationEquals(mosnaiCheckParam.getSakuinTsnKbn(), C_SakuintsnKbn.ERROR, "索引通算区分");
    }

    @Test
    @TestOrder(430)
    public void testExec_A43() {
        MockObjectManager.initialize();
        KeisanSPMockForSinkeiyaku.SYORIPTN = null;
        KeisanGaikakanzanMockForSinkeiyaku.SYORIPTN = null;
        GetKiteiCheckYenkansangkMockForSinkeiyaku.SYORIPTN = null;
        TuusanMockForSinkeiyaku.SYORIPTN = TuusanMockForSinkeiyaku.TESTPATTERN61;
        CheckSaiteiPMockForSinkeiyaku.SYORIPTN = CheckSaiteiPMockForSinkeiyaku.TESTPATTERN1;
        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("792223364");
        List<HT_MosSyouhn> mosSyouhnLst = syoriCTL.getMosSyouhnsBySyutkkbn(C_SyutkKbn.SYU);
        Tuusan tuusan = SWAKInjector.getInstance(Tuusan.class);
        if (mosSyouhnLst.size() > 0) {
            HT_MosSyouhn mosSyouhn = mosSyouhnLst.get(0);
            BM_SyouhnZokusei syouhnZokusei =
                bizDomManager.getSyouhnZokusei(mosSyouhn.getSyouhncd(), mosSyouhn.getSyouhnsdno());
            mosnaiCheckParam.setSyuSyouhnZokusei(syouhnZokusei);
        }
        List<HT_HubiMsg> hubiMsgLst = syoriCTL.getHubiMsgs();
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setListHubiMsg(hubiMsgLst);
        mosnaiCheckParam.setSysKbn(C_SysKbn.SKEI);
        mosnaiCheckParam.setSakuinTsnKbn(C_SakuintsnKbn.SEIJYOU);
        mosnaiCheckParam.setKiteiCheckChannelCd(C_Channelcd.TIGIN);
        checkTuusan.exec(mosnaiCheckParam, tuusan);
        exNumericEquals(hubiMsgLst.size(), 0, "不備メッセージテーブルエンティティリストの件数");
        exClassificationEquals(mosnaiCheckParam.getSakuinTsnKbn(), C_SakuintsnKbn.SEIJYOU, "索引通算区分");

    }

    @Test
    @TestOrder(440)
    public void testExec_A44() {
        KeisanSPMockForSinkeiyaku.SYORIPTN = KeisanSPMockForSinkeiyaku.TESTPATTERN4;
        KeisanGaikakanzanMockForSinkeiyaku.SYORIPTN = null;
        GetKiteiCheckYenkansangkMockForSinkeiyaku.SYORIPTN = GetKiteiCheckYenkansangkMockForSinkeiyaku.TESTPATTERN18;
        TuusanMockForSinkeiyaku.SYORIPTN = TuusanMockForSinkeiyaku.TESTPATTERN13;
        CheckSaiteiPMockForSinkeiyaku.SYORIPTN = CheckSaiteiPMockForSinkeiyaku.TESTPATTERN18;
        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("791112378");
        List<HT_MosSyouhn> mosSyouhnLst = syoriCTL.getMosSyouhnsBySyutkkbn(C_SyutkKbn.SYU);
        Tuusan tuusan = SWAKInjector.getInstance(Tuusan.class);
        if (mosSyouhnLst.size() > 0) {
            HT_MosSyouhn mosSyouhn = mosSyouhnLst.get(0);
            BM_SyouhnZokusei syouhnZokusei =
                bizDomManager.getSyouhnZokusei(mosSyouhn.getSyouhncd(), mosSyouhn.getSyouhnsdno());
            mosnaiCheckParam.setSyuSyouhnZokusei(syouhnZokusei);
        }
        List<HT_HubiMsg> hubiMsgLst = syoriCTL.getHubiMsgs();
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setListHubiMsg(hubiMsgLst);
        mosnaiCheckParam.setSysKbn(C_SysKbn.SKEI);
        mosnaiCheckParam.setSakuinTsnKbn(C_SakuintsnKbn.SEIJYOU);
        mosnaiCheckParam.setKiteiCheckChannelCd(C_Channelcd.TIGIN);
        checkTuusan.exec(mosnaiCheckParam, tuusan);
        exNumericEquals(hubiMsgLst.size(), 1, "不備メッセージテーブルエンティティリストの件数");
        exStringEquals(hubiMsgLst.get(0).getMosno(), "791112378", "申込番号");
        exNumericEquals(hubiMsgLst.get(0).getRenno(), 1, "連番");
        exStringEquals(hubiMsgLst.get(0).getHubimsg(), "【特認可能】年金原資限度額の１００円をオーバーしています。　一時払保険料は４８円までにしてください。", "不備メッセージ");
        exStringEquals(hubiMsgLst.get(0).getMessageId(), "THC1064", "メッセージＩＤ");
        exClassificationEquals(hubiMsgLst.get(0).getHubisyubetukbn(), C_HubisyubetuKbn.KETHORYU_HUBI, "不備種別区分");

        exClassificationEquals(mosnaiCheckParam.getSakuinTsnKbn(), C_SakuintsnKbn.ERROR, "索引通算区分");

    }

    @Test
    @TestOrder(450)
    public void testExec_A45() {
        KeisanSPMockForSinkeiyaku.SYORIPTN = null;
        KeisanGaikakanzanMockForSinkeiyaku.SYORIPTN = null;
        GetKiteiCheckYenkansangkMockForSinkeiyaku.SYORIPTN = null;
        TuusanMockForSinkeiyaku.SYORIPTN = TuusanMockForSinkeiyaku.TESTPATTERN18;
        CheckSaiteiPMockForSinkeiyaku.SYORIPTN = CheckSaiteiPMockForSinkeiyaku.TESTPATTERN1;
        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("791112410");
        List<HT_MosSyouhn> mosSyouhnLst = syoriCTL.getMosSyouhnsBySyutkkbn(C_SyutkKbn.SYU);
        Tuusan tuusan = SWAKInjector.getInstance(Tuusan.class);
        if (mosSyouhnLst.size() > 0) {
            HT_MosSyouhn mosSyouhn = mosSyouhnLst.get(0);
            BM_SyouhnZokusei syouhnZokusei =
                bizDomManager.getSyouhnZokusei(mosSyouhn.getSyouhncd(), mosSyouhn.getSyouhnsdno());
            mosnaiCheckParam.setSyuSyouhnZokusei(syouhnZokusei);
        }
        List<HT_HubiMsg> hubiMsgLst = syoriCTL.getHubiMsgs();
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setListHubiMsg(hubiMsgLst);
        mosnaiCheckParam.setSysKbn(C_SysKbn.SKEI);
        mosnaiCheckParam.setSakuinTsnKbn(C_SakuintsnKbn.SEIJYOU);
        mosnaiCheckParam.setKiteiCheckChannelCd(C_Channelcd.TIGIN);
        checkTuusan.exec(mosnaiCheckParam, tuusan);
        exNumericEquals(hubiMsgLst.size(), 1, "不備メッセージテーブルエンティティリストの件数");
        exStringEquals(hubiMsgLst.get(0).getMosno(), "791112410", "申込番号");
        exNumericEquals(hubiMsgLst.get(0).getRenno(), 1, "連番");
        exStringEquals(hubiMsgLst.get(0).getHubimsg(), "【特認可能】職業別通算Ｓ限度額の１８０円をオーバーしています。　職業別通算Ｓ　１８１円", "不備メッセージ");
        exStringEquals(hubiMsgLst.get(0).getMessageId(), "THC1029", "メッセージＩＤ");
        exClassificationEquals(hubiMsgLst.get(0).getHubisyubetukbn(), C_HubisyubetuKbn.KETHORYU_HUBI, "不備種別区分");
        exClassificationEquals(mosnaiCheckParam.getSakuinTsnKbn(), C_SakuintsnKbn.ERROR, "索引通算区分");

    }

    @Test
    @TestOrder(460)
    public void testExec_A46() {
        KeisanSPMockForSinkeiyaku.SYORIPTN = null;
        KeisanGaikakanzanMockForSinkeiyaku.SYORIPTN = null;
        GetKiteiCheckYenkansangkMockForSinkeiyaku.SYORIPTN = null;
        TuusanMockForSinkeiyaku.SYORIPTN = TuusanMockForSinkeiyaku.TESTPATTERN19;
        CheckSaiteiPMockForSinkeiyaku.SYORIPTN = CheckSaiteiPMockForSinkeiyaku.TESTPATTERN1;
        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("791112428");
        List<HT_MosSyouhn> mosSyouhnLst = syoriCTL.getMosSyouhnsBySyutkkbn(C_SyutkKbn.SYU);
        Tuusan tuusan = SWAKInjector.getInstance(Tuusan.class);
        if (mosSyouhnLst.size() > 0) {
            HT_MosSyouhn mosSyouhn = mosSyouhnLst.get(0);
            BM_SyouhnZokusei syouhnZokusei =
                bizDomManager.getSyouhnZokusei(mosSyouhn.getSyouhncd(), mosSyouhn.getSyouhnsdno());
            mosnaiCheckParam.setSyuSyouhnZokusei(syouhnZokusei);
        }
        List<HT_HubiMsg> hubiMsgLst = syoriCTL.getHubiMsgs();
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setListHubiMsg(hubiMsgLst);
        mosnaiCheckParam.setSysKbn(C_SysKbn.SKEI);
        mosnaiCheckParam.setSakuinTsnKbn(C_SakuintsnKbn.SEIJYOU);
        mosnaiCheckParam.setKiteiCheckChannelCd(C_Channelcd.TIGIN);
        checkTuusan.exec(mosnaiCheckParam, tuusan);
        exNumericEquals(hubiMsgLst.size(), 1, "不備メッセージテーブルエンティティリストの件数");
        exStringEquals(hubiMsgLst.get(0).getMosno(), "791112428", "申込番号");
        exNumericEquals(hubiMsgLst.get(0).getRenno(), 1, "連番");
        exStringEquals(hubiMsgLst.get(0).getHubimsg(), "【特認可能】年齢年収通算総死亡Ｓ限度額の１３０円をオーバーしています。　年齢年収通算総死亡Ｓ　１３１円", "不備メッセージ");
        exStringEquals(hubiMsgLst.get(0).getMessageId(), "THC1032", "メッセージＩＤ");
        exClassificationEquals(hubiMsgLst.get(0).getHubisyubetukbn(), C_HubisyubetuKbn.KETHORYU_HUBI, "不備種別区分");
        exClassificationEquals(mosnaiCheckParam.getSakuinTsnKbn(), C_SakuintsnKbn.ERROR, "索引通算区分");
        exBooleanEquals(mosnaiCheckParam.getNensyuTuusanSOverHanteiKekka(), true, "年収通算Ｓオーバー契約判定結果");

    }

    @Test
    @TestOrder(470)
    public void testExec_A47() {
        MockObjectManager.initialize();
        KeisanSPMockForSinkeiyaku.SYORIPTN = null;
        KeisanGaikakanzanMockForSinkeiyaku.SYORIPTN = null;
        GetKiteiCheckYenkansangkMockForSinkeiyaku.SYORIPTN = null;
        TuusanMockForSinkeiyaku.SYORIPTN = TuusanMockForSinkeiyaku.TESTPATTERN11;
        CheckSaiteiPMockForSinkeiyaku.SYORIPTN = CheckSaiteiPMockForSinkeiyaku.TESTPATTERN1;
        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("860000066");
        List<HT_MosSyouhn> mosSyouhnLst = syoriCTL.getMosSyouhnsBySyutkkbn(C_SyutkKbn.SYU);
        Tuusan tuusan = SWAKInjector.getInstance(Tuusan.class);
        if (mosSyouhnLst.size() > 0) {
            HT_MosSyouhn mosSyouhn = mosSyouhnLst.get(0);
            BM_SyouhnZokusei syouhnZokusei =
                bizDomManager.getSyouhnZokusei(mosSyouhn.getSyouhncd(), mosSyouhn.getSyouhnsdno());
            mosnaiCheckParam.setSyuSyouhnZokusei(syouhnZokusei);
        }
        List<HT_HubiMsg> hubiMsgLst = syoriCTL.getHubiMsgs();
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setListHubiMsg(hubiMsgLst);
        mosnaiCheckParam.setSysKbn(C_SysKbn.SKEI);
        mosnaiCheckParam.setSakuinTsnKbn(C_SakuintsnKbn.SEIJYOU);
        mosnaiCheckParam.setKiteiCheckChannelCd(C_Channelcd.TIGIN);

        checkTuusan.exec(mosnaiCheckParam, tuusan);
        exNumericEquals(hubiMsgLst.size(), 0, "不備メッセージテーブルエンティティリストの件数");
        exClassificationEquals(mosnaiCheckParam.getSakuinTsnKbn(), C_SakuintsnKbn.SEIJYOU, "索引通算区分");

    }

    @Test
    @TestOrder(480)
    public void testExec_A48() {
        MockObjectManager.initialize();
        KeisanSPMockForSinkeiyaku.SYORIPTN = null;
        KeisanGaikakanzanMockForSinkeiyaku.SYORIPTN = null;
        GetKiteiCheckYenkansangkMockForSinkeiyaku.SYORIPTN = null;
        TuusanMockForSinkeiyaku.SYORIPTN = TuusanMockForSinkeiyaku.TESTPATTERN11;
        CheckSaiteiPMockForSinkeiyaku.SYORIPTN = CheckSaiteiPMockForSinkeiyaku.TESTPATTERN1;
        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("860000074");
        List<HT_MosSyouhn> mosSyouhnLst = syoriCTL.getMosSyouhnsBySyutkkbn(C_SyutkKbn.SYU);
        Tuusan tuusan = SWAKInjector.getInstance(Tuusan.class);
        if (mosSyouhnLst.size() > 0) {
            HT_MosSyouhn mosSyouhn = mosSyouhnLst.get(0);
            BM_SyouhnZokusei syouhnZokusei =
                bizDomManager.getSyouhnZokusei(mosSyouhn.getSyouhncd(), mosSyouhn.getSyouhnsdno());
            mosnaiCheckParam.setSyuSyouhnZokusei(syouhnZokusei);
        }
        List<HT_HubiMsg> hubiMsgLst = syoriCTL.getHubiMsgs();
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setListHubiMsg(hubiMsgLst);
        mosnaiCheckParam.setSysKbn(C_SysKbn.SKEI);
        mosnaiCheckParam.setSakuinTsnKbn(C_SakuintsnKbn.SEIJYOU);
        mosnaiCheckParam.setKiteiCheckChannelCd(C_Channelcd.TIGIN);

        checkTuusan.exec(mosnaiCheckParam, tuusan);
        exNumericEquals(hubiMsgLst.size(), 0, "不備メッセージテーブルエンティティリストの件数");
        exClassificationEquals(mosnaiCheckParam.getSakuinTsnKbn(), C_SakuintsnKbn.SEIJYOU, "索引通算区分");

    }

    @Test
    @TestOrder(490)
    public void testExec_A49() {
        KeisanSPMockForSinkeiyaku.SYORIPTN = null;
        KeisanGaikakanzanMockForSinkeiyaku.SYORIPTN = null;
        GetKiteiCheckYenkansangkMockForSinkeiyaku.SYORIPTN = null;
        TuusanMockForSinkeiyaku.SYORIPTN = TuusanMockForSinkeiyaku.TESTPATTERN18;
        CheckSaiteiPMockForSinkeiyaku.SYORIPTN = CheckSaiteiPMockForSinkeiyaku.TESTPATTERN1;
        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("791112410");
        List<HT_MosSyouhn> mosSyouhnLst = syoriCTL.getMosSyouhnsBySyutkkbn(C_SyutkKbn.SYU);
        Tuusan tuusan = SWAKInjector.getInstance(Tuusan.class);
        if (mosSyouhnLst.size() > 0) {
            HT_MosSyouhn mosSyouhn = mosSyouhnLst.get(0);
            BM_SyouhnZokusei syouhnZokusei =
                bizDomManager.getSyouhnZokusei(mosSyouhn.getSyouhncd(), mosSyouhn.getSyouhnsdno());
            mosnaiCheckParam.setSyuSyouhnZokusei(syouhnZokusei);
        }
        List<HT_HubiMsg> hubiMsgLst = syoriCTL.getHubiMsgs();
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setListHubiMsg(hubiMsgLst);
        mosnaiCheckParam.setSysKbn(C_SysKbn.ESHIEN);
        mosnaiCheckParam.setSakuinTsnKbn(C_SakuintsnKbn.SEIJYOU);
        mosnaiCheckParam.setKiteiCheckChannelCd(C_Channelcd.TIGIN);
        checkTuusan.exec(mosnaiCheckParam, tuusan);
        exNumericEquals(hubiMsgLst.size(), 0, "不備メッセージテーブルエンティティリストの件数");
        exClassificationEquals(mosnaiCheckParam.getSakuinTsnKbn(), C_SakuintsnKbn.ERROR, "索引通算区分");

    }

    @Test
    @TestOrder(500)
    public void testExec_A50() {
        KeisanSPMockForSinkeiyaku.SYORIPTN = null;
        KeisanGaikakanzanMockForSinkeiyaku.SYORIPTN = null;
        GetKiteiCheckYenkansangkMockForSinkeiyaku.SYORIPTN = null;
        TuusanMockForSinkeiyaku.SYORIPTN = TuusanMockForSinkeiyaku.TESTPATTERN18;
        CheckSaiteiPMockForSinkeiyaku.SYORIPTN = CheckSaiteiPMockForSinkeiyaku.TESTPATTERN1;
        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("791112410");
        List<HT_MosSyouhn> mosSyouhnLst = syoriCTL.getMosSyouhnsBySyutkkbn(C_SyutkKbn.SYU);
        Tuusan tuusan = SWAKInjector.getInstance(Tuusan.class);
        if (mosSyouhnLst.size() > 0) {
            HT_MosSyouhn mosSyouhn = mosSyouhnLst.get(0);
            BM_SyouhnZokusei syouhnZokusei =
                bizDomManager.getSyouhnZokusei(mosSyouhn.getSyouhncd(), mosSyouhn.getSyouhnsdno());
            mosnaiCheckParam.setSyuSyouhnZokusei(syouhnZokusei);
        }
        List<HT_HubiMsg> hubiMsgLst = syoriCTL.getHubiMsgs();
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setListHubiMsg(hubiMsgLst);
        mosnaiCheckParam.setSysKbn(C_SysKbn.SKEI);
        mosnaiCheckParam.setSakuinTsnKbn(C_SakuintsnKbn.SEIJYOU);
        mosnaiCheckParam.setKiteiCheckChannelCd(C_Channelcd.TIGIN);
        checkTuusan.exec(mosnaiCheckParam, tuusan);
        exNumericEquals(hubiMsgLst.size(), 1, "不備メッセージテーブルエンティティリストの件数");
        exStringEquals(hubiMsgLst.get(0).getMosno(), "791112410", "申込番号");
        exNumericEquals(hubiMsgLst.get(0).getRenno(), 1, "連番");
        exStringEquals(hubiMsgLst.get(0).getHubimsg(), "【特認可能】職業別通算Ｓ限度額の１８０円をオーバーしています。　職業別通算Ｓ　１８１円", "不備メッセージ");
        exStringEquals(hubiMsgLst.get(0).getMessageId(), "THC1029", "メッセージＩＤ");
        exClassificationEquals(hubiMsgLst.get(0).getHubisyubetukbn(), C_HubisyubetuKbn.KETHORYU_HUBI, "不備種別区分");
        exClassificationEquals(mosnaiCheckParam.getSakuinTsnKbn(), C_SakuintsnKbn.ERROR, "索引通算区分");

    }

    @Test
    @TestOrder(510)
    public void testExec_A51() {
        KeisanSPMockForSinkeiyaku.SYORIPTN = null;
        KeisanGaikakanzanMockForSinkeiyaku.SYORIPTN = null;
        GetKiteiCheckYenkansangkMockForSinkeiyaku.SYORIPTN = null;
        TuusanMockForSinkeiyaku.SYORIPTN = TuusanMockForSinkeiyaku.TESTPATTERN37;
        CheckSaiteiPMockForSinkeiyaku.SYORIPTN = CheckSaiteiPMockForSinkeiyaku.TESTPATTERN1;
        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("860000108");
        List<HT_MosSyouhn> mosSyouhnLst = syoriCTL.getMosSyouhnsBySyutkkbn(C_SyutkKbn.SYU);
        Tuusan tuusan = SWAKInjector.getInstance(Tuusan.class);
        if (mosSyouhnLst.size() > 0) {
            HT_MosSyouhn mosSyouhn = mosSyouhnLst.get(0);
            BM_SyouhnZokusei syouhnZokusei =
                bizDomManager.getSyouhnZokusei(mosSyouhn.getSyouhncd(), mosSyouhn.getSyouhnsdno());
            mosnaiCheckParam.setSyuSyouhnZokusei(syouhnZokusei);
        }
        List<HT_HubiMsg> hubiMsgLst = syoriCTL.getHubiMsgs();
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setListHubiMsg(hubiMsgLst);
        mosnaiCheckParam.setSysKbn(C_SysKbn.SKEI);
        mosnaiCheckParam.setSakuinTsnKbn(C_SakuintsnKbn.SEIJYOU);
        mosnaiCheckParam.setKiteiCheckChannelCd(C_Channelcd.TIGIN);
        checkTuusan.exec(mosnaiCheckParam, tuusan);
        exNumericEquals(hubiMsgLst.size(), 1, "不備メッセージテーブルエンティティリストの件数");
        exStringEquals(hubiMsgLst.get(0).getMosno(), "860000108", "申込番号");
        exNumericEquals(hubiMsgLst.get(0).getRenno(), 1, "連番");
        exStringEquals(hubiMsgLst.get(0).getHubimsg(), "年齢別通算総死亡Ｓ限度額の１５０円をオーバーしています。　年齢別通算総死亡Ｓ　１５２円", "不備メッセージ");
        exStringEquals(hubiMsgLst.get(0).getMessageId(), "EHC1030", "メッセージＩＤ");
        exClassificationEquals(hubiMsgLst.get(0).getHubisyubetukbn(), C_HubisyubetuKbn.KETHORYU_HUBI, "不備種別区分");
        exClassificationEquals(mosnaiCheckParam.getSakuinTsnKbn(), C_SakuintsnKbn.ERROR, "索引通算区分");

    }

    @Test
    @TestOrder(520)
    public void testExec_A52() {
        MockObjectManager.initialize();
        KeisanSPMockForSinkeiyaku.SYORIPTN = null;
        KeisanGaikakanzanMockForSinkeiyaku.SYORIPTN = null;
        GetKiteiCheckYenkansangkMockForSinkeiyaku.SYORIPTN = null;
        TuusanMockForSinkeiyaku.SYORIPTN = TuusanMockForSinkeiyaku.TESTPATTERN32;
        CheckSaiteiPMockForSinkeiyaku.SYORIPTN = CheckSaiteiPMockForSinkeiyaku.TESTPATTERN1;
        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("860000082");
        List<HT_MosSyouhn> mosSyouhnLst = syoriCTL.getMosSyouhnsBySyutkkbn(C_SyutkKbn.SYU);
        Tuusan tuusan = SWAKInjector.getInstance(Tuusan.class);
        if (mosSyouhnLst.size() > 0) {
            HT_MosSyouhn mosSyouhn = mosSyouhnLst.get(0);
            BM_SyouhnZokusei syouhnZokusei =
                bizDomManager.getSyouhnZokusei(mosSyouhn.getSyouhncd(), mosSyouhn.getSyouhnsdno());
            mosnaiCheckParam.setSyuSyouhnZokusei(syouhnZokusei);
        }
        List<HT_HubiMsg> hubiMsgLst = syoriCTL.getHubiMsgs();
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setListHubiMsg(hubiMsgLst);
        mosnaiCheckParam.setSysKbn(C_SysKbn.SKEI);
        mosnaiCheckParam.setSakuinTsnKbn(C_SakuintsnKbn.SEIJYOU);
        mosnaiCheckParam.setKiteiCheckChannelCd(C_Channelcd.TIGIN);

        checkTuusan.exec(mosnaiCheckParam, tuusan);
        exNumericEquals(hubiMsgLst.size(), 0, "不備メッセージテーブルエンティティリストの件数");
        exClassificationEquals(mosnaiCheckParam.getSakuinTsnKbn(), C_SakuintsnKbn.SEIJYOU, "索引通算区分");

    }

    @Test
    @TestOrder(530)
    public void testExec_A53() {
        MockObjectManager.initialize();
        KeisanSPMockForSinkeiyaku.SYORIPTN = null;
        KeisanGaikakanzanMockForSinkeiyaku.SYORIPTN = null;
        GetKiteiCheckYenkansangkMockForSinkeiyaku.SYORIPTN = null;
        TuusanMockForSinkeiyaku.SYORIPTN = TuusanMockForSinkeiyaku.TESTPATTERN33;
        CheckSaiteiPMockForSinkeiyaku.SYORIPTN = CheckSaiteiPMockForSinkeiyaku.TESTPATTERN1;
        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("860000082");
        List<HT_MosSyouhn> mosSyouhnLst = syoriCTL.getMosSyouhnsBySyutkkbn(C_SyutkKbn.SYU);
        Tuusan tuusan = SWAKInjector.getInstance(Tuusan.class);
        if (mosSyouhnLst.size() > 0) {
            HT_MosSyouhn mosSyouhn = mosSyouhnLst.get(0);
            BM_SyouhnZokusei syouhnZokusei =
                bizDomManager.getSyouhnZokusei(mosSyouhn.getSyouhncd(), mosSyouhn.getSyouhnsdno());
            mosnaiCheckParam.setSyuSyouhnZokusei(syouhnZokusei);
        }
        List<HT_HubiMsg> hubiMsgLst = syoriCTL.getHubiMsgs();
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setListHubiMsg(hubiMsgLst);
        mosnaiCheckParam.setSysKbn(C_SysKbn.SKEI);
        mosnaiCheckParam.setSakuinTsnKbn(C_SakuintsnKbn.SEIJYOU);
        mosnaiCheckParam.setKiteiCheckChannelCd(C_Channelcd.TIGIN);

        checkTuusan.exec(mosnaiCheckParam, tuusan);
        exNumericEquals(hubiMsgLst.size(), 0, "不備メッセージテーブルエンティティリストの件数");
        exClassificationEquals(mosnaiCheckParam.getSakuinTsnKbn(), C_SakuintsnKbn.SEIJYOU, "索引通算区分");

    }

    @Test
    @TestOrder(540)
    public void testExec_A54() {
        KeisanSPMockForSinkeiyaku.SYORIPTN = null;
        KeisanGaikakanzanMockForSinkeiyaku.SYORIPTN = null;
        GetKiteiCheckYenkansangkMockForSinkeiyaku.SYORIPTN = null;
        TuusanMockForSinkeiyaku.SYORIPTN = TuusanMockForSinkeiyaku.TESTPATTERN17;
        CheckSaiteiPMockForSinkeiyaku.SYORIPTN = CheckSaiteiPMockForSinkeiyaku.TESTPATTERN1;
        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("791112402");
        List<HT_MosSyouhn> mosSyouhnLst = syoriCTL.getMosSyouhnsBySyutkkbn(C_SyutkKbn.SYU);
        Tuusan tuusan = SWAKInjector.getInstance(Tuusan.class);
        if (mosSyouhnLst.size() > 0) {
            HT_MosSyouhn mosSyouhn = mosSyouhnLst.get(0);
            BM_SyouhnZokusei syouhnZokusei =
                bizDomManager.getSyouhnZokusei(mosSyouhn.getSyouhncd(), mosSyouhn.getSyouhnsdno());
            mosnaiCheckParam.setSyuSyouhnZokusei(syouhnZokusei);
        }
        List<HT_HubiMsg> hubiMsgLst = syoriCTL.getHubiMsgs();
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setListHubiMsg(hubiMsgLst);
        mosnaiCheckParam.setSysKbn(C_SysKbn.ESHIEN);
        mosnaiCheckParam.setSakuinTsnKbn(C_SakuintsnKbn.SEIJYOU);
        mosnaiCheckParam.setKiteiCheckChannelCd(C_Channelcd.TIGIN);
        checkTuusan.exec(mosnaiCheckParam, tuusan);
        exNumericEquals(hubiMsgLst.size(), 0, "不備メッセージテーブルエンティティリストの件数");
        exClassificationEquals(mosnaiCheckParam.getSakuinTsnKbn(), C_SakuintsnKbn.ERROR, "索引通算区分");

    }

    @Test
    @TestOrder(550)
    public void testExec_A55() {
        KeisanSPMockForSinkeiyaku.SYORIPTN = null;
        KeisanGaikakanzanMockForSinkeiyaku.SYORIPTN = null;
        GetKiteiCheckYenkansangkMockForSinkeiyaku.SYORIPTN = null;
        TuusanMockForSinkeiyaku.SYORIPTN = TuusanMockForSinkeiyaku.TESTPATTERN17;
        CheckSaiteiPMockForSinkeiyaku.SYORIPTN = CheckSaiteiPMockForSinkeiyaku.TESTPATTERN1;
        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("791112402");
        List<HT_MosSyouhn> mosSyouhnLst = syoriCTL.getMosSyouhnsBySyutkkbn(C_SyutkKbn.SYU);
        Tuusan tuusan = SWAKInjector.getInstance(Tuusan.class);
        if (mosSyouhnLst.size() > 0) {
            HT_MosSyouhn mosSyouhn = mosSyouhnLst.get(0);
            BM_SyouhnZokusei syouhnZokusei =
                bizDomManager.getSyouhnZokusei(mosSyouhn.getSyouhncd(), mosSyouhn.getSyouhnsdno());
            mosnaiCheckParam.setSyuSyouhnZokusei(syouhnZokusei);
        }
        List<HT_HubiMsg> hubiMsgLst = syoriCTL.getHubiMsgs();
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setListHubiMsg(hubiMsgLst);
        mosnaiCheckParam.setSysKbn(C_SysKbn.SKEI);
        mosnaiCheckParam.setSakuinTsnKbn(C_SakuintsnKbn.SEIJYOU);
        mosnaiCheckParam.setKiteiCheckChannelCd(C_Channelcd.TIGIN);
        checkTuusan.exec(mosnaiCheckParam, tuusan);
        exNumericEquals(hubiMsgLst.size(), 1, "不備メッセージテーブルエンティティリストの件数");
        exStringEquals(hubiMsgLst.get(0).getMosno(), "791112402", "申込番号");
        exNumericEquals(hubiMsgLst.get(0).getRenno(), 1, "連番");
        exStringEquals(hubiMsgLst.get(0).getHubimsg(), "【特認可能】年齢別通算総死亡Ｓ限度額の１７０円をオーバーしています。　年齢別通算総死亡Ｓ　１８０円", "不備メッセージ");
        exStringEquals(hubiMsgLst.get(0).getMessageId(), "THC1030", "メッセージＩＤ");
        exClassificationEquals(hubiMsgLst.get(0).getHubisyubetukbn(), C_HubisyubetuKbn.KETHORYU_HUBI, "不備種別区分");

        exClassificationEquals(mosnaiCheckParam.getSakuinTsnKbn(), C_SakuintsnKbn.ERROR, "索引通算区分");

    }

    @Test
    @TestOrder(560)
    public void testExec_A56() {
        KeisanSPMockForSinkeiyaku.SYORIPTN = null;
        KeisanGaikakanzanMockForSinkeiyaku.SYORIPTN = null;
        GetKiteiCheckYenkansangkMockForSinkeiyaku.SYORIPTN = null;
        TuusanMockForSinkeiyaku.SYORIPTN = TuusanMockForSinkeiyaku.TESTPATTERN20;
        CheckSaiteiPMockForSinkeiyaku.SYORIPTN = CheckSaiteiPMockForSinkeiyaku.TESTPATTERN1;
        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("791112436");
        List<HT_MosSyouhn> mosSyouhnLst = syoriCTL.getMosSyouhnsBySyutkkbn(C_SyutkKbn.SYU);
        Tuusan tuusan = SWAKInjector.getInstance(Tuusan.class);
        if (mosSyouhnLst.size() > 0) {
            HT_MosSyouhn mosSyouhn = mosSyouhnLst.get(0);
            BM_SyouhnZokusei syouhnZokusei =
                bizDomManager.getSyouhnZokusei(mosSyouhn.getSyouhncd(), mosSyouhn.getSyouhnsdno());
            mosnaiCheckParam.setSyuSyouhnZokusei(syouhnZokusei);
        }
        List<HT_HubiMsg> hubiMsgLst = syoriCTL.getHubiMsgs();
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setListHubiMsg(hubiMsgLst);
        mosnaiCheckParam.setSysKbn(C_SysKbn.SKEI);
        mosnaiCheckParam.setSakuinTsnKbn(C_SakuintsnKbn.SEIJYOU);
        mosnaiCheckParam.setKiteiCheckChannelCd(C_Channelcd.TIGIN);
        checkTuusan.exec(mosnaiCheckParam, tuusan);
        exNumericEquals(hubiMsgLst.size(), 1, "不備メッセージテーブルエンティティリストの件数");
        exStringEquals(hubiMsgLst.get(0).getMosno(), "791112436", "申込番号");
        exNumericEquals(hubiMsgLst.get(0).getRenno(), 1, "連番");
        exStringEquals(hubiMsgLst.get(0).getHubimsg(), "【特認可能】年齢別通算総死亡Ｓ限度額の１５０円をオーバーしています。　年齢別通算総死亡Ｓ　１５１円", "不備メッセージ");
        exStringEquals(hubiMsgLst.get(0).getMessageId(), "THC1030", "メッセージＩＤ");
        exClassificationEquals(hubiMsgLst.get(0).getHubisyubetukbn(), C_HubisyubetuKbn.KETHORYU_HUBI, "不備種別区分");
        exClassificationEquals(mosnaiCheckParam.getSakuinTsnKbn(), C_SakuintsnKbn.ERROR, "索引通算区分");

    }

    @Test
    @TestOrder(570)
    public void testExec_A57() {
        KeisanSPMockForSinkeiyaku.SYORIPTN = null;
        KeisanGaikakanzanMockForSinkeiyaku.SYORIPTN = null;
        GetKiteiCheckYenkansangkMockForSinkeiyaku.SYORIPTN = null;
        TuusanMockForSinkeiyaku.SYORIPTN = TuusanMockForSinkeiyaku.TESTPATTERN34;
        CheckSaiteiPMockForSinkeiyaku.SYORIPTN = CheckSaiteiPMockForSinkeiyaku.TESTPATTERN1;
        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("791112436");
        List<HT_MosSyouhn> mosSyouhnLst = syoriCTL.getMosSyouhnsBySyutkkbn(C_SyutkKbn.SYU);
        Tuusan tuusan = SWAKInjector.getInstance(Tuusan.class);
        if (mosSyouhnLst.size() > 0) {
            HT_MosSyouhn mosSyouhn = mosSyouhnLst.get(0);
            BM_SyouhnZokusei syouhnZokusei =
                bizDomManager.getSyouhnZokusei(mosSyouhn.getSyouhncd(), mosSyouhn.getSyouhnsdno());
            mosnaiCheckParam.setSyuSyouhnZokusei(syouhnZokusei);
        }
        List<HT_HubiMsg> hubiMsgLst = syoriCTL.getHubiMsgs();
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setListHubiMsg(hubiMsgLst);
        mosnaiCheckParam.setSysKbn(C_SysKbn.SKEI);
        mosnaiCheckParam.setSakuinTsnKbn(C_SakuintsnKbn.SEIJYOU);
        mosnaiCheckParam.setKiteiCheckChannelCd(C_Channelcd.TIGIN);
        checkTuusan.exec(mosnaiCheckParam, tuusan);
        exNumericEquals(hubiMsgLst.size(), 0, "不備メッセージテーブルエンティティリストの件数");
        exClassificationEquals(mosnaiCheckParam.getSakuinTsnKbn(), C_SakuintsnKbn.SEIJYOU, "索引通算区分");

    }

    @Test(expected = CommonBizAppException.class)
    @TestOrder(580)
    public void testExec_A58() {
        KeisanSPMockForSinkeiyaku.SYORIPTN = null;
        KeisanGaikakanzanMockForSinkeiyaku.SYORIPTN = null;
        GetKiteiCheckYenkansangkMockForSinkeiyaku.SYORIPTN = null;
        TuusanMockForSinkeiyaku.SYORIPTN = TuusanMockForSinkeiyaku.TESTPATTERN20;
        CheckSaiteiPMockForSinkeiyaku.SYORIPTN = CheckSaiteiPMockForSinkeiyaku.TESTPATTERN1;
        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("860000090");
        List<HT_MosSyouhn> mosSyouhnLst = syoriCTL.getMosSyouhnsBySyutkkbn(C_SyutkKbn.SYU);
        Tuusan tuusan = SWAKInjector.getInstance(Tuusan.class);
        if (mosSyouhnLst.size() > 0) {
            HT_MosSyouhn mosSyouhn = mosSyouhnLst.get(0);
            BM_SyouhnZokusei syouhnZokusei =
                bizDomManager.getSyouhnZokusei(mosSyouhn.getSyouhncd(), mosSyouhn.getSyouhnsdno());
            mosnaiCheckParam.setSyuSyouhnZokusei(syouhnZokusei);
        }
        List<HT_HubiMsg> hubiMsgLst = syoriCTL.getHubiMsgs();
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setListHubiMsg(hubiMsgLst);
        mosnaiCheckParam.setSysKbn(C_SysKbn.SKEI);
        mosnaiCheckParam.setSakuinTsnKbn(C_SakuintsnKbn.SEIJYOU);
        mosnaiCheckParam.setKiteiCheckChannelCd(C_Channelcd.TIGIN);
        try {
            checkTuusan.exec(mosnaiCheckParam, tuusan);
        } catch (CommonBizAppException e) {
            exStringEquals(e.getMessage(), "システム整合性エラーです。申込番号=860000090", "エラーメッセージ");
            throw e;
        }

    }

    @Test
    @TestOrder(590)
    public void testExec_A59() {
        KeisanSPMockForSinkeiyaku.SYORIPTN = null;
        KeisanGaikakanzanMockForSinkeiyaku.SYORIPTN = null;
        GetKiteiCheckYenkansangkMockForSinkeiyaku.SYORIPTN = null;
        TuusanMockForSinkeiyaku.SYORIPTN = TuusanMockForSinkeiyaku.TESTPATTERN35;
        CheckSaiteiPMockForSinkeiyaku.SYORIPTN = CheckSaiteiPMockForSinkeiyaku.TESTPATTERN1;
        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("791112436");
        List<HT_MosSyouhn> mosSyouhnLst = syoriCTL.getMosSyouhnsBySyutkkbn(C_SyutkKbn.SYU);
        Tuusan tuusan = SWAKInjector.getInstance(Tuusan.class);
        if (mosSyouhnLst.size() > 0) {
            HT_MosSyouhn mosSyouhn = mosSyouhnLst.get(0);
            BM_SyouhnZokusei syouhnZokusei =
                bizDomManager.getSyouhnZokusei(mosSyouhn.getSyouhncd(), mosSyouhn.getSyouhnsdno());
            mosnaiCheckParam.setSyuSyouhnZokusei(syouhnZokusei);
        }
        List<HT_HubiMsg> hubiMsgLst = syoriCTL.getHubiMsgs();
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setListHubiMsg(hubiMsgLst);
        mosnaiCheckParam.setSysKbn(C_SysKbn.SKEI);
        mosnaiCheckParam.setSakuinTsnKbn(C_SakuintsnKbn.SEIJYOU);
        mosnaiCheckParam.setKiteiCheckChannelCd(C_Channelcd.TIGIN);
        checkTuusan.exec(mosnaiCheckParam, tuusan);
        exNumericEquals(hubiMsgLst.size(), 0, "不備メッセージテーブルエンティティリストの件数");
        exClassificationEquals(mosnaiCheckParam.getSakuinTsnKbn(), C_SakuintsnKbn.SEIJYOU, "索引通算区分");

    }

    @Test
    @TestOrder(600)
    public void testExec_A60() {
        KeisanSPMockForSinkeiyaku.SYORIPTN = null;
        KeisanGaikakanzanMockForSinkeiyaku.SYORIPTN = null;
        GetKiteiCheckYenkansangkMockForSinkeiyaku.SYORIPTN = null;
        TuusanMockForSinkeiyaku.SYORIPTN = TuusanMockForSinkeiyaku.TESTPATTERN36;
        CheckSaiteiPMockForSinkeiyaku.SYORIPTN = CheckSaiteiPMockForSinkeiyaku.TESTPATTERN1;
        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("791112436");
        List<HT_MosSyouhn> mosSyouhnLst = syoriCTL.getMosSyouhnsBySyutkkbn(C_SyutkKbn.SYU);
        Tuusan tuusan = SWAKInjector.getInstance(Tuusan.class);
        if (mosSyouhnLst.size() > 0) {
            HT_MosSyouhn mosSyouhn = mosSyouhnLst.get(0);
            BM_SyouhnZokusei syouhnZokusei =
                bizDomManager.getSyouhnZokusei(mosSyouhn.getSyouhncd(), mosSyouhn.getSyouhnsdno());
            mosnaiCheckParam.setSyuSyouhnZokusei(syouhnZokusei);
        }
        List<HT_HubiMsg> hubiMsgLst = syoriCTL.getHubiMsgs();
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setListHubiMsg(hubiMsgLst);
        mosnaiCheckParam.setSysKbn(C_SysKbn.SKEI);
        mosnaiCheckParam.setSakuinTsnKbn(C_SakuintsnKbn.SEIJYOU);
        mosnaiCheckParam.setKiteiCheckChannelCd(C_Channelcd.TIGIN);
        checkTuusan.exec(mosnaiCheckParam, tuusan);
        exNumericEquals(hubiMsgLst.size(), 0, "不備メッセージテーブルエンティティリストの件数");
        exClassificationEquals(mosnaiCheckParam.getSakuinTsnKbn(), C_SakuintsnKbn.SEIJYOU, "索引通算区分");
    }

    @Test
    @TestOrder(610)
    public void testExec_A61() {
        KeisanSPMockForSinkeiyaku.SYORIPTN = null;
        KeisanGaikakanzanMockForSinkeiyaku.SYORIPTN = null;
        GetKiteiCheckYenkansangkMockForSinkeiyaku.SYORIPTN = null;
        TuusanMockForSinkeiyaku.SYORIPTN = TuusanMockForSinkeiyaku.TESTPATTERN20;
        CheckSaiteiPMockForSinkeiyaku.SYORIPTN = CheckSaiteiPMockForSinkeiyaku.TESTPATTERN1;
        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("791112436");
        List<HT_MosSyouhn> mosSyouhnLst = syoriCTL.getMosSyouhnsBySyutkkbn(C_SyutkKbn.SYU);
        Tuusan tuusan = SWAKInjector.getInstance(Tuusan.class);
        if (mosSyouhnLst.size() > 0) {
            HT_MosSyouhn mosSyouhn = mosSyouhnLst.get(0);
            BM_SyouhnZokusei syouhnZokusei =
                bizDomManager.getSyouhnZokusei(mosSyouhn.getSyouhncd(), mosSyouhn.getSyouhnsdno());
            mosnaiCheckParam.setSyuSyouhnZokusei(syouhnZokusei);
        }
        List<HT_HubiMsg> hubiMsgLst = syoriCTL.getHubiMsgs();
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setListHubiMsg(hubiMsgLst);
        mosnaiCheckParam.setSysKbn(C_SysKbn.ESHIEN);
        mosnaiCheckParam.setSakuinTsnKbn(C_SakuintsnKbn.SEIJYOU);
        mosnaiCheckParam.setKiteiCheckChannelCd(C_Channelcd.TIGIN);
        checkTuusan.exec(mosnaiCheckParam, tuusan);
        exNumericEquals(hubiMsgLst.size(), 0, "不備メッセージテーブルエンティティリストの件数");
        exClassificationEquals(mosnaiCheckParam.getSakuinTsnKbn(), C_SakuintsnKbn.ERROR, "索引通算区分");
    }

    @Test
    @TestOrder(620)
    public void testExec_A62() {
        KeisanSPMockForSinkeiyaku.SYORIPTN = null;
        KeisanGaikakanzanMockForSinkeiyaku.SYORIPTN = null;
        GetKiteiCheckYenkansangkMockForSinkeiyaku.SYORIPTN = null;
        TuusanMockForSinkeiyaku.SYORIPTN = TuusanMockForSinkeiyaku.TESTPATTERN38;
        CheckSaiteiPMockForSinkeiyaku.SYORIPTN = CheckSaiteiPMockForSinkeiyaku.TESTPATTERN1;
        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("860000116");
        List<HT_MosSyouhn> mosSyouhnLst = syoriCTL.getMosSyouhnsBySyutkkbn(C_SyutkKbn.SYU);
        Tuusan tuusan = SWAKInjector.getInstance(Tuusan.class);
        if (mosSyouhnLst.size() > 0) {
            HT_MosSyouhn mosSyouhn = mosSyouhnLst.get(0);
            BM_SyouhnZokusei syouhnZokusei =
                bizDomManager.getSyouhnZokusei(mosSyouhn.getSyouhncd(), mosSyouhn.getSyouhnsdno());
            mosnaiCheckParam.setSyuSyouhnZokusei(syouhnZokusei);
        }
        List<HT_HubiMsg> hubiMsgLst = syoriCTL.getHubiMsgs();
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setListHubiMsg(hubiMsgLst);
        mosnaiCheckParam.setSysKbn(C_SysKbn.SKEI);
        mosnaiCheckParam.setSakuinTsnKbn(C_SakuintsnKbn.SEIJYOU);
        mosnaiCheckParam.setKiteiCheckChannelCd(C_Channelcd.TIGIN);
        checkTuusan.exec(mosnaiCheckParam, tuusan);
        exNumericEquals(hubiMsgLst.size(), 1, "不備メッセージテーブルエンティティリストの件数");
        exStringEquals(hubiMsgLst.get(0).getMosno(), "860000116", "申込番号");
        exNumericEquals(hubiMsgLst.get(0).getRenno(), 1, "連番");
        exStringEquals(hubiMsgLst.get(0).getHubimsg(), "【特認可能】職業別通算Ｓ限度額の１８０円をオーバーしています。　職業別通算Ｓ　１８１円", "不備メッセージ");
        exStringEquals(hubiMsgLst.get(0).getMessageId(), "THC1029", "メッセージＩＤ");
        exClassificationEquals(hubiMsgLst.get(0).getHubisyubetukbn(), C_HubisyubetuKbn.KETHORYU_HUBI, "不備種別区分");
        exClassificationEquals(mosnaiCheckParam.getSakuinTsnKbn(), C_SakuintsnKbn.ERROR, "索引通算区分");

    }

    @Test(expected = CommonBizAppException.class)
    @TestOrder(630)
    public void testExec_A63() {
        KeisanSPMockForSinkeiyaku.SYORIPTN = null;
        KeisanGaikakanzanMockForSinkeiyaku.SYORIPTN = null;
        GetKiteiCheckYenkansangkMockForSinkeiyaku.SYORIPTN = null;
        TuusanMockForSinkeiyaku.SYORIPTN = TuusanMockForSinkeiyaku.TESTPATTERN43;
        CheckSaiteiPMockForSinkeiyaku.SYORIPTN = CheckSaiteiPMockForSinkeiyaku.TESTPATTERN1;
        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("791112303");
        List<HT_MosSyouhn> mosSyouhnLst = syoriCTL.getMosSyouhnsBySyutkkbn(C_SyutkKbn.SYU);
        Tuusan tuusan = SWAKInjector.getInstance(Tuusan.class);
        if (mosSyouhnLst.size() > 0) {
            HT_MosSyouhn mosSyouhn = mosSyouhnLst.get(0);
            BM_SyouhnZokusei syouhnZokusei =
                bizDomManager.getSyouhnZokusei(mosSyouhn.getSyouhncd(), mosSyouhn.getSyouhnsdno());
            mosnaiCheckParam.setSyuSyouhnZokusei(syouhnZokusei);
        }
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setSysKbn(C_SysKbn.ESHIEN);
        mosnaiCheckParam.setSakuinTsnKbn(C_SakuintsnKbn.SEIJYOU);
        mosnaiCheckParam.setKiteiCheckChannelCd(C_Channelcd.TIGIN);
        try {
            checkTuusan.exec(mosnaiCheckParam, tuusan);
        } catch (CommonBizAppException e) {
            exStringEquals(e.getMessage(), "システム整合性エラーです。申込番号=791112303", "エラーメッセージ");
            throw e;
        }
    }

    @Test
    @TestOrder(640)
    public void testExec_A64() {
        KeisanSPMockForSinkeiyaku.SYORIPTN = null;
        KeisanGaikakanzanMockForSinkeiyaku.SYORIPTN = null;
        GetKiteiCheckYenkansangkMockForSinkeiyaku.SYORIPTN = null;
        TuusanMockForSinkeiyaku.SYORIPTN = TuusanMockForSinkeiyaku.TESTPATTERN39;
        CheckSaiteiPMockForSinkeiyaku.SYORIPTN = CheckSaiteiPMockForSinkeiyaku.TESTPATTERN1;
        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("791112410");
        List<HT_MosSyouhn> mosSyouhnLst = syoriCTL.getMosSyouhnsBySyutkkbn(C_SyutkKbn.SYU);
        Tuusan tuusan = SWAKInjector.getInstance(Tuusan.class);
        if (mosSyouhnLst.size() > 0) {
            HT_MosSyouhn mosSyouhn = mosSyouhnLst.get(0);
            BM_SyouhnZokusei syouhnZokusei =
                bizDomManager.getSyouhnZokusei(mosSyouhn.getSyouhncd(), mosSyouhn.getSyouhnsdno());
            mosnaiCheckParam.setSyuSyouhnZokusei(syouhnZokusei);
        }
        List<HT_HubiMsg> hubiMsgLst = syoriCTL.getHubiMsgs();
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setListHubiMsg(hubiMsgLst);
        mosnaiCheckParam.setSysKbn(C_SysKbn.SKEI);
        mosnaiCheckParam.setSakuinTsnKbn(C_SakuintsnKbn.SEIJYOU);
        mosnaiCheckParam.setKiteiCheckChannelCd(C_Channelcd.TIGIN);
        checkTuusan.exec(mosnaiCheckParam, tuusan);
        exNumericEquals(hubiMsgLst.size(), 1, "不備メッセージテーブルエンティティリストの件数");
        exStringEquals(hubiMsgLst.get(0).getMosno(), "791112410", "申込番号");
        exNumericEquals(hubiMsgLst.get(0).getRenno(), 1, "連番");
        exStringEquals(hubiMsgLst.get(0).getHubimsg(), "【特認可能】職業別通算Ｓ限度額の１８０円をオーバーしています。　職業別通算Ｓ　１８１円", "不備メッセージ");
        exStringEquals(hubiMsgLst.get(0).getMessageId(), "THC1029", "メッセージＩＤ");
        exClassificationEquals(hubiMsgLst.get(0).getHubisyubetukbn(), C_HubisyubetuKbn.KETHORYU_HUBI, "不備種別区分");
        exClassificationEquals(mosnaiCheckParam.getSakuinTsnKbn(), C_SakuintsnKbn.ERROR, "索引通算区分");

    }

    @Test
    @TestOrder(650)
    public void testExec_A65() {
        KeisanSPMockForSinkeiyaku.SYORIPTN = null;
        KeisanGaikakanzanMockForSinkeiyaku.SYORIPTN = null;
        GetKiteiCheckYenkansangkMockForSinkeiyaku.SYORIPTN = null;
        TuusanMockForSinkeiyaku.SYORIPTN = TuusanMockForSinkeiyaku.TESTPATTERN14;
        CheckSaiteiPMockForSinkeiyaku.SYORIPTN = CheckSaiteiPMockForSinkeiyaku.TESTPATTERN1;
        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("791112394");
        List<HT_MosSyouhn> mosSyouhnLst = syoriCTL.getMosSyouhnsBySyutkkbn(C_SyutkKbn.SYU);
        Tuusan tuusan = SWAKInjector.getInstance(Tuusan.class);
        if (mosSyouhnLst.size() > 0) {
            HT_MosSyouhn mosSyouhn = mosSyouhnLst.get(0);
            BM_SyouhnZokusei syouhnZokusei =
                bizDomManager.getSyouhnZokusei(mosSyouhn.getSyouhncd(), mosSyouhn.getSyouhnsdno());
            mosnaiCheckParam.setSyuSyouhnZokusei(syouhnZokusei);
        }
        List<HT_HubiMsg> hubiMsgLst = syoriCTL.getHubiMsgs();
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setListHubiMsg(hubiMsgLst);
        mosnaiCheckParam.setSysKbn(C_SysKbn.SKEI);
        mosnaiCheckParam.setSakuinTsnKbn(C_SakuintsnKbn.SEIJYOU);
        mosnaiCheckParam.setKiteiCheckChannelCd(C_Channelcd.TIGIN);
        checkTuusan.exec(mosnaiCheckParam, tuusan);
        exNumericEquals(hubiMsgLst.size(), 1, "不備メッセージテーブルエンティティリストの件数");
        exStringEquals(hubiMsgLst.get(0).getMosno(), "791112394", "申込番号");
        exNumericEquals(hubiMsgLst.get(0).getRenno(), 1, "連番");
        exStringEquals(hubiMsgLst.get(0).getHubimsg(), "通算未成年用年齢別総死亡Ｓ限度額の１４０円をオーバーしています。　通算未成年用年齢別総死亡Ｓ　１４１円", "不備メッセージ");
        exStringEquals(hubiMsgLst.get(0).getMessageId(), "EHC1028", "メッセージＩＤ");
        exClassificationEquals(hubiMsgLst.get(0).getHubisyubetukbn(), C_HubisyubetuKbn.KETHORYU_HUBI, "不備種別区分");

        exClassificationEquals(mosnaiCheckParam.getSakuinTsnKbn(), C_SakuintsnKbn.ERROR, "索引通算区分");

    }

    @Test
    @TestOrder(660)
    public void testExec_A66() {
        KeisanSPMockForSinkeiyaku.SYORIPTN = null;
        KeisanGaikakanzanMockForSinkeiyaku.SYORIPTN = null;
        GetKiteiCheckYenkansangkMockForSinkeiyaku.SYORIPTN = null;
        TuusanMockForSinkeiyaku.SYORIPTN = TuusanMockForSinkeiyaku.TESTPATTERN40;
        CheckSaiteiPMockForSinkeiyaku.SYORIPTN = CheckSaiteiPMockForSinkeiyaku.TESTPATTERN1;
        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("791112394");
        List<HT_MosSyouhn> mosSyouhnLst = syoriCTL.getMosSyouhnsBySyutkkbn(C_SyutkKbn.SYU);
        Tuusan tuusan = SWAKInjector.getInstance(Tuusan.class);
        if (mosSyouhnLst.size() > 0) {
            HT_MosSyouhn mosSyouhn = mosSyouhnLst.get(0);
            BM_SyouhnZokusei syouhnZokusei =
                bizDomManager.getSyouhnZokusei(mosSyouhn.getSyouhncd(), mosSyouhn.getSyouhnsdno());
            mosnaiCheckParam.setSyuSyouhnZokusei(syouhnZokusei);
        }
        List<HT_HubiMsg> hubiMsgLst = syoriCTL.getHubiMsgs();
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setListHubiMsg(hubiMsgLst);
        mosnaiCheckParam.setSysKbn(C_SysKbn.SKEI);
        mosnaiCheckParam.setSakuinTsnKbn(C_SakuintsnKbn.SEIJYOU);
        mosnaiCheckParam.setKiteiCheckChannelCd(C_Channelcd.TIGIN);
        checkTuusan.exec(mosnaiCheckParam, tuusan);
        exNumericEquals(hubiMsgLst.size(), 1, "不備メッセージテーブルエンティティリストの件数");
        exStringEquals(hubiMsgLst.get(0).getMosno(), "791112394", "申込番号");
        exNumericEquals(hubiMsgLst.get(0).getRenno(), 1, "連番");
        exStringEquals(hubiMsgLst.get(0).getHubimsg(), "通算未成年用年齢別総死亡Ｓ限度額の１４０円をオーバーしています。　通算未成年用年齢別総死亡Ｓ　１４１円", "不備メッセージ");
        exStringEquals(hubiMsgLst.get(0).getMessageId(), "EHC1028", "メッセージＩＤ");
        exClassificationEquals(hubiMsgLst.get(0).getHubisyubetukbn(), C_HubisyubetuKbn.KETHORYU_HUBI, "不備種別区分");

        exClassificationEquals(mosnaiCheckParam.getSakuinTsnKbn(), C_SakuintsnKbn.ERROR, "索引通算区分");

    }

    @Test
    @TestOrder(670)
    public void testExec_A67() {
        KeisanSPMockForSinkeiyaku.SYORIPTN = null;
        KeisanGaikakanzanMockForSinkeiyaku.SYORIPTN = null;
        GetKiteiCheckYenkansangkMockForSinkeiyaku.SYORIPTN = null;
        TuusanMockForSinkeiyaku.SYORIPTN = TuusanMockForSinkeiyaku.TESTPATTERN19;
        CheckSaiteiPMockForSinkeiyaku.SYORIPTN = CheckSaiteiPMockForSinkeiyaku.TESTPATTERN1;
        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("791112428");
        List<HT_MosSyouhn> mosSyouhnLst = syoriCTL.getMosSyouhnsBySyutkkbn(C_SyutkKbn.SYU);
        Tuusan tuusan = SWAKInjector.getInstance(Tuusan.class);
        if (mosSyouhnLst.size() > 0) {
            HT_MosSyouhn mosSyouhn = mosSyouhnLst.get(0);
            BM_SyouhnZokusei syouhnZokusei =
                bizDomManager.getSyouhnZokusei(mosSyouhn.getSyouhncd(), mosSyouhn.getSyouhnsdno());
            mosnaiCheckParam.setSyuSyouhnZokusei(syouhnZokusei);
        }
        List<HT_HubiMsg> hubiMsgLst = syoriCTL.getHubiMsgs();
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setListHubiMsg(hubiMsgLst);
        mosnaiCheckParam.setSysKbn(C_SysKbn.ESHIEN);
        mosnaiCheckParam.setSakuinTsnKbn(C_SakuintsnKbn.SEIJYOU);
        mosnaiCheckParam.setKiteiCheckChannelCd(C_Channelcd.TIGIN);
        checkTuusan.exec(mosnaiCheckParam, tuusan);
        exNumericEquals(hubiMsgLst.size(), 0, "不備メッセージテーブルエンティティリストの件数");
        exClassificationEquals(mosnaiCheckParam.getSakuinTsnKbn(), C_SakuintsnKbn.ERROR, "索引通算区分");

    }

    @Test
    @TestOrder(680)
    public void testExec_A68() {
        KeisanSPMockForSinkeiyaku.SYORIPTN = null;
        KeisanGaikakanzanMockForSinkeiyaku.SYORIPTN = null;
        GetKiteiCheckYenkansangkMockForSinkeiyaku.SYORIPTN = null;
        TuusanMockForSinkeiyaku.SYORIPTN = TuusanMockForSinkeiyaku.TESTPATTERN41;
        CheckSaiteiPMockForSinkeiyaku.SYORIPTN = CheckSaiteiPMockForSinkeiyaku.TESTPATTERN1;
        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("791112394");
        List<HT_MosSyouhn> mosSyouhnLst = syoriCTL.getMosSyouhnsBySyutkkbn(C_SyutkKbn.SYU);
        Tuusan tuusan = SWAKInjector.getInstance(Tuusan.class);
        if (mosSyouhnLst.size() > 0) {
            HT_MosSyouhn mosSyouhn = mosSyouhnLst.get(0);
            BM_SyouhnZokusei syouhnZokusei =
                bizDomManager.getSyouhnZokusei(mosSyouhn.getSyouhncd(), mosSyouhn.getSyouhnsdno());
            mosnaiCheckParam.setSyuSyouhnZokusei(syouhnZokusei);
        }
        List<HT_HubiMsg> hubiMsgLst = syoriCTL.getHubiMsgs();
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setListHubiMsg(hubiMsgLst);
        mosnaiCheckParam.setSysKbn(C_SysKbn.SKEI);
        mosnaiCheckParam.setSakuinTsnKbn(C_SakuintsnKbn.SEIJYOU);
        mosnaiCheckParam.setKiteiCheckChannelCd(C_Channelcd.TIGIN);
        checkTuusan.exec(mosnaiCheckParam, tuusan);
        exNumericEquals(hubiMsgLst.size(), 1, "不備メッセージテーブルエンティティリストの件数");
        exStringEquals(hubiMsgLst.get(0).getMosno(), "791112394", "申込番号");
        exNumericEquals(hubiMsgLst.get(0).getRenno(), 1, "連番");
        exStringEquals(hubiMsgLst.get(0).getHubimsg(), "通算未成年用年齢別総死亡Ｓ限度額の１４０円をオーバーしています。　通算未成年用年齢別総死亡Ｓ　１４１円", "不備メッセージ");
        exStringEquals(hubiMsgLst.get(0).getMessageId(), "EHC1028", "メッセージＩＤ");
        exClassificationEquals(hubiMsgLst.get(0).getHubisyubetukbn(), C_HubisyubetuKbn.KETHORYU_HUBI, "不備種別区分");

        exClassificationEquals(mosnaiCheckParam.getSakuinTsnKbn(), C_SakuintsnKbn.ERROR, "索引通算区分");

    }

    @Test
    @TestOrder(690)
    public void testExec_A69() {
        KeisanSPMockForSinkeiyaku.SYORIPTN = null;
        KeisanGaikakanzanMockForSinkeiyaku.SYORIPTN = null;
        GetKiteiCheckYenkansangkMockForSinkeiyaku.SYORIPTN = null;
        TuusanMockForSinkeiyaku.SYORIPTN = TuusanMockForSinkeiyaku.TESTPATTERN42;
        CheckSaiteiPMockForSinkeiyaku.SYORIPTN = CheckSaiteiPMockForSinkeiyaku.TESTPATTERN1;
        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("860000124");
        List<HT_MosSyouhn> mosSyouhnLst = syoriCTL.getMosSyouhnsBySyutkkbn(C_SyutkKbn.SYU);
        Tuusan tuusan = SWAKInjector.getInstance(Tuusan.class);
        if (mosSyouhnLst.size() > 0) {
            HT_MosSyouhn mosSyouhn = mosSyouhnLst.get(0);
            BM_SyouhnZokusei syouhnZokusei =
                bizDomManager.getSyouhnZokusei(mosSyouhn.getSyouhncd(), mosSyouhn.getSyouhnsdno());
            mosnaiCheckParam.setSyuSyouhnZokusei(syouhnZokusei);
        }
        List<HT_HubiMsg> hubiMsgLst = syoriCTL.getHubiMsgs();
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setListHubiMsg(hubiMsgLst);
        mosnaiCheckParam.setSysKbn(C_SysKbn.SKEI);
        mosnaiCheckParam.setSakuinTsnKbn(C_SakuintsnKbn.SEIJYOU);
        mosnaiCheckParam.setKiteiCheckChannelCd(C_Channelcd.TIGIN);
        checkTuusan.exec(mosnaiCheckParam, tuusan);
        exNumericEquals(hubiMsgLst.size(), 0, "不備メッセージテーブルエンティティリストの件数");
        exClassificationEquals(mosnaiCheckParam.getSakuinTsnKbn(), C_SakuintsnKbn.SEIJYOU, "索引通算区分");

    }

    @Test
    @TestOrder(700)
    public void testExec_A70() {
        KeisanSPMockForSinkeiyaku.SYORIPTN = null;
        KeisanGaikakanzanMockForSinkeiyaku.SYORIPTN = null;
        GetKiteiCheckYenkansangkMockForSinkeiyaku.SYORIPTN = null;
        TuusanMockForSinkeiyaku.SYORIPTN = TuusanMockForSinkeiyaku.TESTPATTERN48;
        CheckSaiteiPMockForSinkeiyaku.SYORIPTN = CheckSaiteiPMockForSinkeiyaku.TESTPATTERN1;
        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("791112394");
        List<HT_MosSyouhn> mosSyouhnLst = syoriCTL.getMosSyouhnsBySyutkkbn(C_SyutkKbn.SYU);
        Tuusan tuusan = SWAKInjector.getInstance(Tuusan.class);
        if (mosSyouhnLst.size() > 0) {
            HT_MosSyouhn mosSyouhn = mosSyouhnLst.get(0);
            BM_SyouhnZokusei syouhnZokusei =
                bizDomManager.getSyouhnZokusei(mosSyouhn.getSyouhncd(), mosSyouhn.getSyouhnsdno());
            mosnaiCheckParam.setSyuSyouhnZokusei(syouhnZokusei);
        }
        List<HT_HubiMsg> hubiMsgLst = syoriCTL.getHubiMsgs();
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setListHubiMsg(hubiMsgLst);
        mosnaiCheckParam.setSysKbn(C_SysKbn.SKEI);
        mosnaiCheckParam.setSakuinTsnKbn(C_SakuintsnKbn.SEIJYOU);
        mosnaiCheckParam.setKiteiCheckChannelCd(C_Channelcd.TIGIN);
        checkTuusan.exec(mosnaiCheckParam, tuusan);
        exNumericEquals(hubiMsgLst.size(), 0, "不備メッセージテーブルエンティティリストの件数");
        exClassificationEquals(mosnaiCheckParam.getSakuinTsnKbn(), C_SakuintsnKbn.SEIJYOU, "索引通算区分");

    }

    @Test
    @TestOrder(710)
    public void testExec_A71() {
        KeisanSPMockForSinkeiyaku.SYORIPTN = null;
        KeisanGaikakanzanMockForSinkeiyaku.SYORIPTN = null;
        GetKiteiCheckYenkansangkMockForSinkeiyaku.SYORIPTN = null;
        TuusanMockForSinkeiyaku.SYORIPTN = TuusanMockForSinkeiyaku.TESTPATTERN49;
        CheckSaiteiPMockForSinkeiyaku.SYORIPTN = CheckSaiteiPMockForSinkeiyaku.TESTPATTERN1;
        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("791112394");
        List<HT_MosSyouhn> mosSyouhnLst = syoriCTL.getMosSyouhnsBySyutkkbn(C_SyutkKbn.SYU);
        Tuusan tuusan = SWAKInjector.getInstance(Tuusan.class);
        if (mosSyouhnLst.size() > 0) {
            HT_MosSyouhn mosSyouhn = mosSyouhnLst.get(0);
            BM_SyouhnZokusei syouhnZokusei =
                bizDomManager.getSyouhnZokusei(mosSyouhn.getSyouhncd(), mosSyouhn.getSyouhnsdno());
            mosnaiCheckParam.setSyuSyouhnZokusei(syouhnZokusei);
        }
        List<HT_HubiMsg> hubiMsgLst = syoriCTL.getHubiMsgs();
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setListHubiMsg(hubiMsgLst);
        mosnaiCheckParam.setSysKbn(C_SysKbn.SKEI);
        mosnaiCheckParam.setSakuinTsnKbn(C_SakuintsnKbn.SEIJYOU);
        mosnaiCheckParam.setKiteiCheckChannelCd(C_Channelcd.TIGIN);
        checkTuusan.exec(mosnaiCheckParam, tuusan);
        exNumericEquals(hubiMsgLst.size(), 0, "不備メッセージテーブルエンティティリストの件数");
        exClassificationEquals(mosnaiCheckParam.getSakuinTsnKbn(), C_SakuintsnKbn.SEIJYOU, "索引通算区分");

    }

    @Test
    @TestOrder(720)
    public void testExec_A72() {
        KeisanSPMockForSinkeiyaku.SYORIPTN = null;
        KeisanGaikakanzanMockForSinkeiyaku.SYORIPTN = null;
        GetKiteiCheckYenkansangkMockForSinkeiyaku.SYORIPTN = null;
        TuusanMockForSinkeiyaku.SYORIPTN = TuusanMockForSinkeiyaku.TESTPATTERN50;
        CheckSaiteiPMockForSinkeiyaku.SYORIPTN = CheckSaiteiPMockForSinkeiyaku.TESTPATTERN1;
        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("791112394");
        List<HT_MosSyouhn> mosSyouhnLst = syoriCTL.getMosSyouhnsBySyutkkbn(C_SyutkKbn.SYU);
        Tuusan tuusan = SWAKInjector.getInstance(Tuusan.class);
        if (mosSyouhnLst.size() > 0) {
            HT_MosSyouhn mosSyouhn = mosSyouhnLst.get(0);
            BM_SyouhnZokusei syouhnZokusei =
                bizDomManager.getSyouhnZokusei(mosSyouhn.getSyouhncd(), mosSyouhn.getSyouhnsdno());
            mosnaiCheckParam.setSyuSyouhnZokusei(syouhnZokusei);
        }
        List<HT_HubiMsg> hubiMsgLst = syoriCTL.getHubiMsgs();
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setListHubiMsg(hubiMsgLst);
        mosnaiCheckParam.setSysKbn(C_SysKbn.SKEI);
        mosnaiCheckParam.setSakuinTsnKbn(C_SakuintsnKbn.SEIJYOU);
        mosnaiCheckParam.setKiteiCheckChannelCd(C_Channelcd.TIGIN);
        checkTuusan.exec(mosnaiCheckParam, tuusan);
        exNumericEquals(hubiMsgLst.size(), 0, "不備メッセージテーブルエンティティリストの件数");
        exClassificationEquals(mosnaiCheckParam.getSakuinTsnKbn(), C_SakuintsnKbn.SEIJYOU, "索引通算区分");

    }

    @Test
    @TestOrder(730)
    public void testExec_A73() {
        KeisanSPMockForSinkeiyaku.SYORIPTN = null;
        KeisanGaikakanzanMockForSinkeiyaku.SYORIPTN = null;
        GetKiteiCheckYenkansangkMockForSinkeiyaku.SYORIPTN = null;
        TuusanMockForSinkeiyaku.SYORIPTN = TuusanMockForSinkeiyaku.TESTPATTERN44;
        CheckSaiteiPMockForSinkeiyaku.SYORIPTN = CheckSaiteiPMockForSinkeiyaku.TESTPATTERN1;
        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("791112394");
        List<HT_MosSyouhn> mosSyouhnLst = syoriCTL.getMosSyouhnsBySyutkkbn(C_SyutkKbn.SYU);
        Tuusan tuusan = SWAKInjector.getInstance(Tuusan.class);
        if (mosSyouhnLst.size() > 0) {
            HT_MosSyouhn mosSyouhn = mosSyouhnLst.get(0);
            BM_SyouhnZokusei syouhnZokusei =
                bizDomManager.getSyouhnZokusei(mosSyouhn.getSyouhncd(), mosSyouhn.getSyouhnsdno());
            mosnaiCheckParam.setSyuSyouhnZokusei(syouhnZokusei);
        }
        List<HT_HubiMsg> hubiMsgLst = syoriCTL.getHubiMsgs();
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setListHubiMsg(hubiMsgLst);
        mosnaiCheckParam.setSysKbn(C_SysKbn.ESHIEN);
        mosnaiCheckParam.setSakuinTsnKbn(C_SakuintsnKbn.SEIJYOU);
        mosnaiCheckParam.setKiteiCheckChannelCd(C_Channelcd.TIGIN);
        checkTuusan.exec(mosnaiCheckParam, tuusan);
        exNumericEquals(hubiMsgLst.size(), 0, "不備メッセージテーブルエンティティリストの件数");
        exClassificationEquals(mosnaiCheckParam.getSakuinTsnKbn(), C_SakuintsnKbn.ERROR, "索引通算区分");

    }

    @Test
    @TestOrder(740)
    public void testExec_A74() {
        KeisanSPMockForSinkeiyaku.SYORIPTN = null;
        KeisanGaikakanzanMockForSinkeiyaku.SYORIPTN = null;
        GetKiteiCheckYenkansangkMockForSinkeiyaku.SYORIPTN = null;
        TuusanMockForSinkeiyaku.SYORIPTN = TuusanMockForSinkeiyaku.TESTPATTERN47;
        CheckSaiteiPMockForSinkeiyaku.SYORIPTN = CheckSaiteiPMockForSinkeiyaku.TESTPATTERN1;
        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("791112451");
        List<HT_MosSyouhn> mosSyouhnLst = syoriCTL.getMosSyouhnsBySyutkkbn(C_SyutkKbn.SYU);
        Tuusan tuusan = SWAKInjector.getInstance(Tuusan.class);
        if (mosSyouhnLst.size() > 0) {
            HT_MosSyouhn mosSyouhn = mosSyouhnLst.get(0);
            BM_SyouhnZokusei syouhnZokusei =
                bizDomManager.getSyouhnZokusei(mosSyouhn.getSyouhncd(), mosSyouhn.getSyouhnsdno());
            mosnaiCheckParam.setSyuSyouhnZokusei(syouhnZokusei);
        }
        List<HT_HubiMsg> hubiMsgLst = syoriCTL.getHubiMsgs();
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setListHubiMsg(hubiMsgLst);
        mosnaiCheckParam.setSysKbn(C_SysKbn.ESHIEN);
        mosnaiCheckParam.setSakuinTsnKbn(C_SakuintsnKbn.SEIJYOU);
        mosnaiCheckParam.setKiteiCheckChannelCd(C_Channelcd.TIGIN);
        checkTuusan.exec(mosnaiCheckParam, tuusan);
        exNumericEquals(hubiMsgLst.size(), 0, "不備メッセージテーブルエンティティリストの件数");

        exClassificationEquals(mosnaiCheckParam.getSakuinTsnKbn(), C_SakuintsnKbn.SEIJYOU, "索引通算区分");

    }

    @Test
    @TestOrder(750)
    public void testExec_A75() {
        KeisanSPMockForSinkeiyaku.SYORIPTN = null;
        KeisanGaikakanzanMockForSinkeiyaku.SYORIPTN = null;
        GetKiteiCheckYenkansangkMockForSinkeiyaku.SYORIPTN = null;
        TuusanMockForSinkeiyaku.SYORIPTN = TuusanMockForSinkeiyaku.TESTPATTERN45;
        CheckSaiteiPMockForSinkeiyaku.SYORIPTN = CheckSaiteiPMockForSinkeiyaku.TESTPATTERN1;
        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("791112451");
        List<HT_MosSyouhn> mosSyouhnLst = syoriCTL.getMosSyouhnsBySyutkkbn(C_SyutkKbn.SYU);
        Tuusan tuusan = SWAKInjector.getInstance(Tuusan.class);
        if (mosSyouhnLst.size() > 0) {
            HT_MosSyouhn mosSyouhn = mosSyouhnLst.get(0);
            BM_SyouhnZokusei syouhnZokusei =
                bizDomManager.getSyouhnZokusei(mosSyouhn.getSyouhncd(), mosSyouhn.getSyouhnsdno());
            mosnaiCheckParam.setSyuSyouhnZokusei(syouhnZokusei);
        }
        List<HT_HubiMsg> hubiMsgLst = syoriCTL.getHubiMsgs();
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setListHubiMsg(hubiMsgLst);
        mosnaiCheckParam.setSysKbn(C_SysKbn.SKEI);
        mosnaiCheckParam.setSakuinTsnKbn(C_SakuintsnKbn.SEIJYOU);
        mosnaiCheckParam.setKiteiCheckChannelCd(C_Channelcd.TIGIN);
        checkTuusan.exec(mosnaiCheckParam, tuusan);
        exNumericEquals(hubiMsgLst.size(), 0, "不備メッセージテーブルエンティティリストの件数");
        exClassificationEquals(mosnaiCheckParam.getSakuinTsnKbn(), C_SakuintsnKbn.SEIJYOU, "索引通算区分");
    }

    @Test
    @TestOrder(760)
    public void testExec_A76() {
        KeisanSPMockForSinkeiyaku.SYORIPTN = null;
        KeisanGaikakanzanMockForSinkeiyaku.SYORIPTN = null;
        GetKiteiCheckYenkansangkMockForSinkeiyaku.SYORIPTN = null;
        TuusanMockForSinkeiyaku.SYORIPTN = TuusanMockForSinkeiyaku.TESTPATTERN46;
        CheckSaiteiPMockForSinkeiyaku.SYORIPTN = CheckSaiteiPMockForSinkeiyaku.TESTPATTERN1;
        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("791112451");
        List<HT_MosSyouhn> mosSyouhnLst = syoriCTL.getMosSyouhnsBySyutkkbn(C_SyutkKbn.SYU);
        Tuusan tuusan = SWAKInjector.getInstance(Tuusan.class);
        if (mosSyouhnLst.size() > 0) {
            HT_MosSyouhn mosSyouhn = mosSyouhnLst.get(0);
            BM_SyouhnZokusei syouhnZokusei =
                bizDomManager.getSyouhnZokusei(mosSyouhn.getSyouhncd(), mosSyouhn.getSyouhnsdno());
            mosnaiCheckParam.setSyuSyouhnZokusei(syouhnZokusei);
        }
        List<HT_HubiMsg> hubiMsgLst = syoriCTL.getHubiMsgs();
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setListHubiMsg(hubiMsgLst);
        mosnaiCheckParam.setSysKbn(C_SysKbn.SKEI);
        mosnaiCheckParam.setSakuinTsnKbn(C_SakuintsnKbn.SEIJYOU);
        mosnaiCheckParam.setKiteiCheckChannelCd(C_Channelcd.TIGIN);
        checkTuusan.exec(mosnaiCheckParam, tuusan);
        exNumericEquals(hubiMsgLst.size(), 0, "不備メッセージテーブルエンティティリストの件数");
        exClassificationEquals(mosnaiCheckParam.getSakuinTsnKbn(), C_SakuintsnKbn.SEIJYOU, "索引通算区分");

    }

    @Test
    @TestOrder(770)
    public void testExec_A77() {
        KeisanSPMockForSinkeiyaku.SYORIPTN = null;
        KeisanGaikakanzanMockForSinkeiyaku.SYORIPTN = null;
        GetKiteiCheckYenkansangkMockForSinkeiyaku.SYORIPTN = null;
        TuusanMockForSinkeiyaku.SYORIPTN = TuusanMockForSinkeiyaku.TESTPATTERN21;
        CheckSaiteiPMockForSinkeiyaku.SYORIPTN = CheckSaiteiPMockForSinkeiyaku.TESTPATTERN1;
        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("791112451");
        List<HT_MosSyouhn> mosSyouhnLst = syoriCTL.getMosSyouhnsBySyutkkbn(C_SyutkKbn.SYU);
        Tuusan tuusan = SWAKInjector.getInstance(Tuusan.class);
        if (mosSyouhnLst.size() > 0) {
            HT_MosSyouhn mosSyouhn = mosSyouhnLst.get(0);
            BM_SyouhnZokusei syouhnZokusei =
                bizDomManager.getSyouhnZokusei(mosSyouhn.getSyouhncd(), mosSyouhn.getSyouhnsdno());
            mosnaiCheckParam.setSyuSyouhnZokusei(syouhnZokusei);
        }
        List<HT_HubiMsg> hubiMsgLst = syoriCTL.getHubiMsgs();
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setListHubiMsg(hubiMsgLst);
        mosnaiCheckParam.setSysKbn(C_SysKbn.SKEI);
        mosnaiCheckParam.setSakuinTsnKbn(C_SakuintsnKbn.SEIJYOU);
        mosnaiCheckParam.setKiteiCheckChannelCd(C_Channelcd.TIGIN);
        checkTuusan.exec(mosnaiCheckParam, tuusan);
        exNumericEquals(hubiMsgLst.size(), 1, "不備メッセージテーブルエンティティリストの件数");
        exStringEquals(hubiMsgLst.get(0).getMosno(), "791112451", "申込番号");
        exNumericEquals(hubiMsgLst.get(0).getRenno(), 1, "連番");
        exStringEquals(hubiMsgLst.get(0).getHubimsg(), "通算総告知書実保障限度額の５０円をオーバーしています。　通算総告知書実保障額　５１円", "不備メッセージ");
        exStringEquals(hubiMsgLst.get(0).getMessageId(), "EHC1024", "メッセージＩＤ");
        exClassificationEquals(hubiMsgLst.get(0).getHubisyubetukbn(), C_HubisyubetuKbn.KETHORYU_HUBI, "不備種別区分");
        exClassificationEquals(mosnaiCheckParam.getSakuinTsnKbn(), C_SakuintsnKbn.ERROR, "索引通算区分");

    }

    @Test
    @TestOrder(780)
    public void testExec_A78() {
        KeisanSPMockForSinkeiyaku.SYORIPTN = null;
        KeisanGaikakanzanMockForSinkeiyaku.SYORIPTN = null;
        GetKiteiCheckYenkansangkMockForSinkeiyaku.SYORIPTN = null;
        TuusanMockForSinkeiyaku.SYORIPTN = TuusanMockForSinkeiyaku.TESTPATTERN22;
        CheckSaiteiPMockForSinkeiyaku.SYORIPTN = CheckSaiteiPMockForSinkeiyaku.TESTPATTERN1;
        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("791112451");
        List<HT_MosSyouhn> mosSyouhnLst = syoriCTL.getMosSyouhnsBySyutkkbn(C_SyutkKbn.SYU);
        Tuusan tuusan = SWAKInjector.getInstance(Tuusan.class);
        if (mosSyouhnLst.size() > 0) {
            HT_MosSyouhn mosSyouhn = mosSyouhnLst.get(0);
            BM_SyouhnZokusei syouhnZokusei =
                bizDomManager.getSyouhnZokusei(mosSyouhn.getSyouhncd(), mosSyouhn.getSyouhnsdno());
            mosnaiCheckParam.setSyuSyouhnZokusei(syouhnZokusei);
        }
        List<HT_HubiMsg> hubiMsgLst = syoriCTL.getHubiMsgs();
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setListHubiMsg(hubiMsgLst);
        mosnaiCheckParam.setSysKbn(C_SysKbn.ESHIEN);
        mosnaiCheckParam.setSakuinTsnKbn(C_SakuintsnKbn.SEIJYOU);
        mosnaiCheckParam.setKiteiCheckChannelCd(C_Channelcd.TIGIN);
        checkTuusan.exec(mosnaiCheckParam, tuusan);
        exNumericEquals(hubiMsgLst.size(), 0, "不備メッセージテーブルエンティティリストの件数");

        exClassificationEquals(mosnaiCheckParam.getSakuinTsnKbn(), C_SakuintsnKbn.ERROR, "索引通算区分");

    }

    @Test
    @TestOrder(790)
    public void testExec_A79() {
        MockObjectManager.initialize();
        KeisanSPMockForSinkeiyaku.SYORIPTN = null;
        KeisanGaikakanzanMockForSinkeiyaku.SYORIPTN = null;
        GetKiteiCheckYenkansangkMockForSinkeiyaku.SYORIPTN = null;
        TuusanMockForSinkeiyaku.SYORIPTN = TuusanMockForSinkeiyaku.TESTPATTERN51;
        CheckSaiteiPMockForSinkeiyaku.SYORIPTN = CheckSaiteiPMockForSinkeiyaku.TESTPATTERN1;
        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("791112469");
        List<HT_MosSyouhn> mosSyouhnLst = syoriCTL.getMosSyouhnsBySyutkkbn(C_SyutkKbn.SYU);
        Tuusan tuusan = SWAKInjector.getInstance(Tuusan.class);
        if (mosSyouhnLst.size() > 0) {
            HT_MosSyouhn mosSyouhn = mosSyouhnLst.get(0);
            BM_SyouhnZokusei syouhnZokusei =
                bizDomManager.getSyouhnZokusei(mosSyouhn.getSyouhncd(), mosSyouhn.getSyouhnsdno());
            mosnaiCheckParam.setSyuSyouhnZokusei(syouhnZokusei);
        }
        List<HT_HubiMsg> hubiMsgLst = syoriCTL.getHubiMsgs();
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setListHubiMsg(hubiMsgLst);
        mosnaiCheckParam.setSysKbn(C_SysKbn.SKEI);
        mosnaiCheckParam.setSakuinTsnKbn(C_SakuintsnKbn.SEIJYOU);
        mosnaiCheckParam.setKiteiCheckChannelCd(C_Channelcd.TIGIN);
        checkTuusan.exec(mosnaiCheckParam, tuusan);
        exNumericEquals(hubiMsgLst.size(), 0, "不備メッセージテーブルエンティティリストの件数");
        exClassificationEquals(mosnaiCheckParam.getSakuinTsnKbn(), C_SakuintsnKbn.SEIJYOU, "索引通算区分");

    }

    @Test
    @TestOrder(800)
    public void testExec_A80() {
        MockObjectManager.initialize();
        KeisanSPMockForSinkeiyaku.SYORIPTN = null;
        KeisanGaikakanzanMockForSinkeiyaku.SYORIPTN = null;
        GetKiteiCheckYenkansangkMockForSinkeiyaku.SYORIPTN = null;
        TuusanMockForSinkeiyaku.SYORIPTN = TuusanMockForSinkeiyaku.TESTPATTERN52;
        CheckSaiteiPMockForSinkeiyaku.SYORIPTN = CheckSaiteiPMockForSinkeiyaku.TESTPATTERN1;
        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("791112469");
        List<HT_MosSyouhn> mosSyouhnLst = syoriCTL.getMosSyouhnsBySyutkkbn(C_SyutkKbn.SYU);
        Tuusan tuusan = SWAKInjector.getInstance(Tuusan.class);
        if (mosSyouhnLst.size() > 0) {
            HT_MosSyouhn mosSyouhn = mosSyouhnLst.get(0);
            BM_SyouhnZokusei syouhnZokusei =
                bizDomManager.getSyouhnZokusei(mosSyouhn.getSyouhncd(), mosSyouhn.getSyouhnsdno());
            mosnaiCheckParam.setSyuSyouhnZokusei(syouhnZokusei);
        }
        List<HT_HubiMsg> hubiMsgLst = syoriCTL.getHubiMsgs();
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setListHubiMsg(hubiMsgLst);
        mosnaiCheckParam.setSysKbn(C_SysKbn.SKEI);
        mosnaiCheckParam.setSakuinTsnKbn(C_SakuintsnKbn.SEIJYOU);
        mosnaiCheckParam.setKiteiCheckChannelCd(C_Channelcd.TIGIN);
        checkTuusan.exec(mosnaiCheckParam, tuusan);
        exNumericEquals(hubiMsgLst.size(), 0, "不備メッセージテーブルエンティティリストの件数");
        exClassificationEquals(mosnaiCheckParam.getSakuinTsnKbn(), C_SakuintsnKbn.SEIJYOU, "索引通算区分");

    }

    @Test
    @TestOrder(810)
    public void testExec_A81() {
        MockObjectManager.initialize();
        KeisanSPMockForSinkeiyaku.SYORIPTN = null;
        KeisanGaikakanzanMockForSinkeiyaku.SYORIPTN = null;
        GetKiteiCheckYenkansangkMockForSinkeiyaku.SYORIPTN = null;
        TuusanMockForSinkeiyaku.SYORIPTN = TuusanMockForSinkeiyaku.TESTPATTERN53;
        CheckSaiteiPMockForSinkeiyaku.SYORIPTN = CheckSaiteiPMockForSinkeiyaku.TESTPATTERN1;
        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("791112469");
        List<HT_MosSyouhn> mosSyouhnLst = syoriCTL.getMosSyouhnsBySyutkkbn(C_SyutkKbn.SYU);
        Tuusan tuusan = SWAKInjector.getInstance(Tuusan.class);
        if (mosSyouhnLst.size() > 0) {
            HT_MosSyouhn mosSyouhn = mosSyouhnLst.get(0);
            BM_SyouhnZokusei syouhnZokusei =
                bizDomManager.getSyouhnZokusei(mosSyouhn.getSyouhncd(), mosSyouhn.getSyouhnsdno());
            mosnaiCheckParam.setSyuSyouhnZokusei(syouhnZokusei);
        }
        List<HT_HubiMsg> hubiMsgLst = syoriCTL.getHubiMsgs();
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setListHubiMsg(hubiMsgLst);
        mosnaiCheckParam.setSysKbn(C_SysKbn.SKEI);
        mosnaiCheckParam.setSakuinTsnKbn(C_SakuintsnKbn.SEIJYOU);
        mosnaiCheckParam.setKiteiCheckChannelCd(C_Channelcd.TIGIN);
        checkTuusan.exec(mosnaiCheckParam, tuusan);
        exNumericEquals(hubiMsgLst.size(), 0, "不備メッセージテーブルエンティティリストの件数");
        exClassificationEquals(mosnaiCheckParam.getSakuinTsnKbn(), C_SakuintsnKbn.SEIJYOU, "索引通算区分");

    }

    @Test
    @TestOrder(820)
    public void testExec_A82() {
        KeisanSPMockForSinkeiyaku.SYORIPTN = null;
        KeisanGaikakanzanMockForSinkeiyaku.SYORIPTN = null;
        GetKiteiCheckYenkansangkMockForSinkeiyaku.SYORIPTN = null;
        TuusanMockForSinkeiyaku.SYORIPTN = TuusanMockForSinkeiyaku.TESTPATTERN23;
        CheckSaiteiPMockForSinkeiyaku.SYORIPTN = CheckSaiteiPMockForSinkeiyaku.TESTPATTERN1;
        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("791112469");
        List<HT_MosSyouhn> mosSyouhnLst = syoriCTL.getMosSyouhnsBySyutkkbn(C_SyutkKbn.SYU);
        Tuusan tuusan = SWAKInjector.getInstance(Tuusan.class);
        if (mosSyouhnLst.size() > 0) {
            HT_MosSyouhn mosSyouhn = mosSyouhnLst.get(0);
            BM_SyouhnZokusei syouhnZokusei =
                bizDomManager.getSyouhnZokusei(mosSyouhn.getSyouhncd(), mosSyouhn.getSyouhnsdno());
            mosnaiCheckParam.setSyuSyouhnZokusei(syouhnZokusei);
        }
        List<HT_HubiMsg> hubiMsgLst = syoriCTL.getHubiMsgs();
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setListHubiMsg(hubiMsgLst);
        mosnaiCheckParam.setSysKbn(C_SysKbn.ESHIEN);
        mosnaiCheckParam.setSakuinTsnKbn(C_SakuintsnKbn.SEIJYOU);
        mosnaiCheckParam.setKiteiCheckChannelCd(C_Channelcd.TIGIN);
        checkTuusan.exec(mosnaiCheckParam, tuusan);
        exNumericEquals(hubiMsgLst.size(), 0, "不備メッセージテーブルエンティティリストの件数");

        exClassificationEquals(mosnaiCheckParam.getSakuinTsnKbn(), C_SakuintsnKbn.ERROR, "索引通算区分");

    }

    @Test
    @TestOrder(830)
    public void testExec_A83() {
        MockObjectManager.initialize();
        KeisanSPMockForSinkeiyaku.SYORIPTN = null;
        KeisanGaikakanzanMockForSinkeiyaku.SYORIPTN = null;
        GetKiteiCheckYenkansangkMockForSinkeiyaku.SYORIPTN = null;
        TuusanMockForSinkeiyaku.SYORIPTN = TuusanMockForSinkeiyaku.TESTPATTERN23;
        CheckSaiteiPMockForSinkeiyaku.SYORIPTN = CheckSaiteiPMockForSinkeiyaku.TESTPATTERN1;
        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("791112469");
        List<HT_MosSyouhn> mosSyouhnLst = syoriCTL.getMosSyouhnsBySyutkkbn(C_SyutkKbn.SYU);
        Tuusan tuusan = SWAKInjector.getInstance(Tuusan.class);
        if (mosSyouhnLst.size() > 0) {
            HT_MosSyouhn mosSyouhn = mosSyouhnLst.get(0);
            BM_SyouhnZokusei syouhnZokusei =
                bizDomManager.getSyouhnZokusei(mosSyouhn.getSyouhncd(), mosSyouhn.getSyouhnsdno());
            mosnaiCheckParam.setSyuSyouhnZokusei(syouhnZokusei);
        }
        List<HT_HubiMsg> hubiMsgLst = syoriCTL.getHubiMsgs();
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setListHubiMsg(hubiMsgLst);
        mosnaiCheckParam.setSysKbn(C_SysKbn.SKEI);
        mosnaiCheckParam.setSakuinTsnKbn(C_SakuintsnKbn.SEIJYOU);
        mosnaiCheckParam.setKiteiCheckChannelCd(C_Channelcd.TIGIN);
        checkTuusan.exec(mosnaiCheckParam, tuusan);
        exNumericEquals(hubiMsgLst.size(), 1, "不備メッセージテーブルエンティティリストの件数");
        exStringEquals(hubiMsgLst.get(0).getMosno(), "791112469", "申込番号");
        exNumericEquals(hubiMsgLst.get(0).getRenno(), 1, "連番");
        exStringEquals(hubiMsgLst.get(0).getHubimsg(), "【特認可能】通算告知書実質保障限度額１の２１０円をオーバーしています。　通算告知書実質保障額１　２１１円",
            "不備メッセージ");
        exStringEquals(hubiMsgLst.get(0).getMessageId(), "THC1025", "メッセージＩＤ");
        exClassificationEquals(hubiMsgLst.get(0).getHubisyubetukbn(), C_HubisyubetuKbn.KETHORYU_HUBI, "不備種別区分");

        exClassificationEquals(mosnaiCheckParam.getSakuinTsnKbn(), C_SakuintsnKbn.ERROR, "索引通算区分");

    }

    @Test
    @TestOrder(840)
    public void testExec_A84() {
        KeisanSPMockForSinkeiyaku.SYORIPTN = null;
        KeisanGaikakanzanMockForSinkeiyaku.SYORIPTN = null;
        GetKiteiCheckYenkansangkMockForSinkeiyaku.SYORIPTN = null;
        TuusanMockForSinkeiyaku.SYORIPTN = TuusanMockForSinkeiyaku.TESTPATTERN55;
        CheckSaiteiPMockForSinkeiyaku.SYORIPTN = CheckSaiteiPMockForSinkeiyaku.TESTPATTERN1;
        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("791112444");
        List<HT_MosSyouhn> mosSyouhnLst = syoriCTL.getMosSyouhnsBySyutkkbn(C_SyutkKbn.SYU);
        Tuusan tuusan = SWAKInjector.getInstance(Tuusan.class);
        if (mosSyouhnLst.size() > 0) {
            HT_MosSyouhn mosSyouhn = mosSyouhnLst.get(0);
            BM_SyouhnZokusei syouhnZokusei =
                bizDomManager.getSyouhnZokusei(mosSyouhn.getSyouhncd(), mosSyouhn.getSyouhnsdno());
            mosnaiCheckParam.setSyuSyouhnZokusei(syouhnZokusei);
        }
        List<HT_HubiMsg> hubiMsgLst = syoriCTL.getHubiMsgs();
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setListHubiMsg(hubiMsgLst);
        mosnaiCheckParam.setSysKbn(C_SysKbn.SKEI);
        mosnaiCheckParam.setSakuinTsnKbn(C_SakuintsnKbn.SEIJYOU);
        mosnaiCheckParam.setKiteiCheckChannelCd(C_Channelcd.TIGIN);
        checkTuusan.exec(mosnaiCheckParam, tuusan);
        exNumericEquals(hubiMsgLst.size(), 0, "不備メッセージテーブルエンティティリストの件数");
        exClassificationEquals(mosnaiCheckParam.getSakuinTsnKbn(), C_SakuintsnKbn.SEIJYOU, "索引通算区分");

    }

    @Test
    @TestOrder(850)
    public void testExec_A85() {
        KeisanSPMockForSinkeiyaku.SYORIPTN = null;
        KeisanGaikakanzanMockForSinkeiyaku.SYORIPTN = null;
        GetKiteiCheckYenkansangkMockForSinkeiyaku.SYORIPTN = null;
        TuusanMockForSinkeiyaku.SYORIPTN = TuusanMockForSinkeiyaku.TESTPATTERN56;
        CheckSaiteiPMockForSinkeiyaku.SYORIPTN = CheckSaiteiPMockForSinkeiyaku.TESTPATTERN1;
        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("791112444");
        List<HT_MosSyouhn> mosSyouhnLst = syoriCTL.getMosSyouhnsBySyutkkbn(C_SyutkKbn.SYU);
        Tuusan tuusan = SWAKInjector.getInstance(Tuusan.class);
        if (mosSyouhnLst.size() > 0) {
            HT_MosSyouhn mosSyouhn = mosSyouhnLst.get(0);
            BM_SyouhnZokusei syouhnZokusei =
                bizDomManager.getSyouhnZokusei(mosSyouhn.getSyouhncd(), mosSyouhn.getSyouhnsdno());
            mosnaiCheckParam.setSyuSyouhnZokusei(syouhnZokusei);
        }
        List<HT_HubiMsg> hubiMsgLst = syoriCTL.getHubiMsgs();
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setListHubiMsg(hubiMsgLst);
        mosnaiCheckParam.setSysKbn(C_SysKbn.SKEI);
        mosnaiCheckParam.setSakuinTsnKbn(C_SakuintsnKbn.SEIJYOU);
        mosnaiCheckParam.setKiteiCheckChannelCd(C_Channelcd.TIGIN);
        checkTuusan.exec(mosnaiCheckParam, tuusan);
        exNumericEquals(hubiMsgLst.size(), 0, "不備メッセージテーブルエンティティリストの件数");
        exClassificationEquals(mosnaiCheckParam.getSakuinTsnKbn(), C_SakuintsnKbn.SEIJYOU, "索引通算区分");

    }

    @Test
    @TestOrder(860)
    public void testExec_A86() {
        KeisanSPMockForSinkeiyaku.SYORIPTN = null;
        KeisanGaikakanzanMockForSinkeiyaku.SYORIPTN = null;
        GetKiteiCheckYenkansangkMockForSinkeiyaku.SYORIPTN = null;
        TuusanMockForSinkeiyaku.SYORIPTN = TuusanMockForSinkeiyaku.TESTPATTERN57;
        CheckSaiteiPMockForSinkeiyaku.SYORIPTN = CheckSaiteiPMockForSinkeiyaku.TESTPATTERN1;
        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("791112444");
        List<HT_MosSyouhn> mosSyouhnLst = syoriCTL.getMosSyouhnsBySyutkkbn(C_SyutkKbn.SYU);
        Tuusan tuusan = SWAKInjector.getInstance(Tuusan.class);
        if (mosSyouhnLst.size() > 0) {
            HT_MosSyouhn mosSyouhn = mosSyouhnLst.get(0);
            BM_SyouhnZokusei syouhnZokusei =
                bizDomManager.getSyouhnZokusei(mosSyouhn.getSyouhncd(), mosSyouhn.getSyouhnsdno());
            mosnaiCheckParam.setSyuSyouhnZokusei(syouhnZokusei);
        }
        List<HT_HubiMsg> hubiMsgLst = syoriCTL.getHubiMsgs();
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setListHubiMsg(hubiMsgLst);
        mosnaiCheckParam.setSysKbn(C_SysKbn.SKEI);
        mosnaiCheckParam.setSakuinTsnKbn(C_SakuintsnKbn.SEIJYOU);
        mosnaiCheckParam.setKiteiCheckChannelCd(C_Channelcd.TIGIN);
        checkTuusan.exec(mosnaiCheckParam, tuusan);
        exNumericEquals(hubiMsgLst.size(), 0, "不備メッセージテーブルエンティティリストの件数");
        exClassificationEquals(mosnaiCheckParam.getSakuinTsnKbn(), C_SakuintsnKbn.SEIJYOU, "索引通算区分");

    }

    @Test
    @TestOrder(870)
    public void testExec_A87() {
        KeisanSPMockForSinkeiyaku.SYORIPTN = null;
        KeisanGaikakanzanMockForSinkeiyaku.SYORIPTN = null;
        GetKiteiCheckYenkansangkMockForSinkeiyaku.SYORIPTN = null;
        TuusanMockForSinkeiyaku.SYORIPTN = TuusanMockForSinkeiyaku.TESTPATTERN54;
        CheckSaiteiPMockForSinkeiyaku.SYORIPTN = CheckSaiteiPMockForSinkeiyaku.TESTPATTERN1;
        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("791112444");
        List<HT_MosSyouhn> mosSyouhnLst = syoriCTL.getMosSyouhnsBySyutkkbn(C_SyutkKbn.SYU);
        Tuusan tuusan = SWAKInjector.getInstance(Tuusan.class);
        if (mosSyouhnLst.size() > 0) {
            HT_MosSyouhn mosSyouhn = mosSyouhnLst.get(0);
            BM_SyouhnZokusei syouhnZokusei =
                bizDomManager.getSyouhnZokusei(mosSyouhn.getSyouhncd(), mosSyouhn.getSyouhnsdno());
            mosnaiCheckParam.setSyuSyouhnZokusei(syouhnZokusei);
        }
        List<HT_HubiMsg> hubiMsgLst = syoriCTL.getHubiMsgs();
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setListHubiMsg(hubiMsgLst);
        mosnaiCheckParam.setSysKbn(C_SysKbn.ESHIEN);
        mosnaiCheckParam.setSakuinTsnKbn(C_SakuintsnKbn.SEIJYOU);
        mosnaiCheckParam.setKiteiCheckChannelCd(C_Channelcd.TIGIN);
        checkTuusan.exec(mosnaiCheckParam, tuusan);
        exNumericEquals(hubiMsgLst.size(), 0, "不備メッセージテーブルエンティティリストの件数");
        exClassificationEquals(mosnaiCheckParam.getSakuinTsnKbn(), C_SakuintsnKbn.ERROR, "索引通算区分");

    }

    @Test
    @TestOrder(880)
    public void testExec_A88() {
        KeisanSPMockForSinkeiyaku.SYORIPTN = null;
        KeisanGaikakanzanMockForSinkeiyaku.SYORIPTN = null;
        GetKiteiCheckYenkansangkMockForSinkeiyaku.SYORIPTN = null;
        TuusanMockForSinkeiyaku.SYORIPTN = TuusanMockForSinkeiyaku.TESTPATTERN54;
        CheckSaiteiPMockForSinkeiyaku.SYORIPTN = CheckSaiteiPMockForSinkeiyaku.TESTPATTERN1;
        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("791112444");
        List<HT_MosSyouhn> mosSyouhnLst = syoriCTL.getMosSyouhnsBySyutkkbn(C_SyutkKbn.SYU);
        Tuusan tuusan = SWAKInjector.getInstance(Tuusan.class);
        if (mosSyouhnLst.size() > 0) {
            HT_MosSyouhn mosSyouhn = mosSyouhnLst.get(0);
            BM_SyouhnZokusei syouhnZokusei =
                bizDomManager.getSyouhnZokusei(mosSyouhn.getSyouhncd(), mosSyouhn.getSyouhnsdno());
            mosnaiCheckParam.setSyuSyouhnZokusei(syouhnZokusei);
        }
        List<HT_HubiMsg> hubiMsgLst = syoriCTL.getHubiMsgs();
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setListHubiMsg(hubiMsgLst);
        mosnaiCheckParam.setSysKbn(C_SysKbn.SKEI);
        mosnaiCheckParam.setSakuinTsnKbn(C_SakuintsnKbn.SEIJYOU);
        mosnaiCheckParam.setKiteiCheckChannelCd(C_Channelcd.TIGIN);
        checkTuusan.exec(mosnaiCheckParam, tuusan);
        exNumericEquals(hubiMsgLst.size(), 1, "不備メッセージテーブルエンティティリストの件数");
        exStringEquals(hubiMsgLst.get(0).getMosno(), "791112444", "申込番号");
        exNumericEquals(hubiMsgLst.get(0).getRenno(), 1, "連番");
        exStringEquals(hubiMsgLst.get(0).getHubimsg(), "【特認可能】通算告知書実質保障限度額２の３１０円をオーバーしています。　通算告知書実質保障額２　３１１円",
            "不備メッセージ");
        exStringEquals(hubiMsgLst.get(0).getMessageId(), "THC1026", "メッセージＩＤ");
        exClassificationEquals(hubiMsgLst.get(0).getHubisyubetukbn(), C_HubisyubetuKbn.KETHORYU_HUBI, "不備種別区分");
        exClassificationEquals(mosnaiCheckParam.getSakuinTsnKbn(), C_SakuintsnKbn.ERROR, "索引通算区分");

    }

    @Test(expected = CommonBizAppException.class)
    @TestOrder(890)
    public void testExec_A89() {
        MockObjectManager.initialize();
        KeisanSPMockForSinkeiyaku.SYORIPTN = null;
        KeisanGaikakanzanMockForSinkeiyaku.SYORIPTN = null;
        GetKiteiCheckYenkansangkMockForSinkeiyaku.SYORIPTN = null;
        TuusanMockForSinkeiyaku.SYORIPTN = TuusanMockForSinkeiyaku.TESTPATTERN58;
        CheckSaiteiPMockForSinkeiyaku.SYORIPTN = CheckSaiteiPMockForSinkeiyaku.TESTPATTERN1;
        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("792223356");
        List<HT_MosSyouhn> mosSyouhnLst = syoriCTL.getMosSyouhnsBySyutkkbn(C_SyutkKbn.SYU);
        Tuusan tuusan = SWAKInjector.getInstance(Tuusan.class);
        if (mosSyouhnLst.size() > 0) {
            HT_MosSyouhn mosSyouhn = mosSyouhnLst.get(0);
            BM_SyouhnZokusei syouhnZokusei =
                bizDomManager.getSyouhnZokusei(mosSyouhn.getSyouhncd(), mosSyouhn.getSyouhnsdno());
            mosnaiCheckParam.setSyuSyouhnZokusei(syouhnZokusei);
        }
        List<HT_HubiMsg> hubiMsgLst = syoriCTL.getHubiMsgs();
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setListHubiMsg(hubiMsgLst);
        mosnaiCheckParam.setSysKbn(C_SysKbn.SKEI);
        mosnaiCheckParam.setSakuinTsnKbn(C_SakuintsnKbn.SEIJYOU);
        mosnaiCheckParam.setKiteiCheckChannelCd(C_Channelcd.TIGIN);
        try {
            checkTuusan.exec(mosnaiCheckParam, tuusan);
        } catch (CommonBizAppException e) {
            exStringEquals(e.getMessage(), "システム整合性エラーです。申込番号=792223356", "エラーメッセージ");
            throw e;
        }

    }

    @Test
    @TestOrder(900)
    public void testExec_A90() {
        MockObjectManager.initialize();
        KeisanSPMockForSinkeiyaku.SYORIPTN = null;
        KeisanGaikakanzanMockForSinkeiyaku.SYORIPTN = null;
        GetKiteiCheckYenkansangkMockForSinkeiyaku.SYORIPTN = null;
        TuusanMockForSinkeiyaku.SYORIPTN = TuusanMockForSinkeiyaku.TESTPATTERN59;
        CheckSaiteiPMockForSinkeiyaku.SYORIPTN = CheckSaiteiPMockForSinkeiyaku.TESTPATTERN1;
        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("792223372");
        List<HT_MosSyouhn> mosSyouhnLst = syoriCTL.getMosSyouhnsBySyutkkbn(C_SyutkKbn.SYU);
        Tuusan tuusan = SWAKInjector.getInstance(Tuusan.class);
        if (mosSyouhnLst.size() > 0) {
            HT_MosSyouhn mosSyouhn = mosSyouhnLst.get(0);
            BM_SyouhnZokusei syouhnZokusei =
                bizDomManager.getSyouhnZokusei(mosSyouhn.getSyouhncd(), mosSyouhn.getSyouhnsdno());
            mosnaiCheckParam.setSyuSyouhnZokusei(syouhnZokusei);
        }
        List<HT_HubiMsg> hubiMsgLst = syoriCTL.getHubiMsgs();
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setListHubiMsg(hubiMsgLst);
        mosnaiCheckParam.setSysKbn(C_SysKbn.SKEI);
        mosnaiCheckParam.setSakuinTsnKbn(C_SakuintsnKbn.SEIJYOU);
        mosnaiCheckParam.setKiteiCheckChannelCd(C_Channelcd.TIGIN);
        checkTuusan.exec(mosnaiCheckParam, tuusan);
        exNumericEquals(hubiMsgLst.size(), 0, "不備メッセージテーブルエンティティリストの件数");
        exClassificationEquals(mosnaiCheckParam.getSakuinTsnKbn(), C_SakuintsnKbn.SEIJYOU, "索引通算区分");

    }

    @Test
    @TestOrder(910)
    public void testExec_A91() {
        MockObjectManager.initialize();
        KeisanSPMockForSinkeiyaku.SYORIPTN = null;
        KeisanGaikakanzanMockForSinkeiyaku.SYORIPTN = null;
        GetKiteiCheckYenkansangkMockForSinkeiyaku.SYORIPTN = null;
        TuusanMockForSinkeiyaku.SYORIPTN = TuusanMockForSinkeiyaku.TESTPATTERN60;
        CheckSaiteiPMockForSinkeiyaku.SYORIPTN = CheckSaiteiPMockForSinkeiyaku.TESTPATTERN1;
        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("792223364");
        List<HT_MosSyouhn> mosSyouhnLst = syoriCTL.getMosSyouhnsBySyutkkbn(C_SyutkKbn.SYU);
        Tuusan tuusan = SWAKInjector.getInstance(Tuusan.class);
        if (mosSyouhnLst.size() > 0) {
            HT_MosSyouhn mosSyouhn = mosSyouhnLst.get(0);
            BM_SyouhnZokusei syouhnZokusei =
                bizDomManager.getSyouhnZokusei(mosSyouhn.getSyouhncd(), mosSyouhn.getSyouhnsdno());
            mosnaiCheckParam.setSyuSyouhnZokusei(syouhnZokusei);
        }
        List<HT_HubiMsg> hubiMsgLst = syoriCTL.getHubiMsgs();
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setListHubiMsg(hubiMsgLst);
        mosnaiCheckParam.setSysKbn(C_SysKbn.SKEI);
        mosnaiCheckParam.setSakuinTsnKbn(C_SakuintsnKbn.SEIJYOU);
        mosnaiCheckParam.setKiteiCheckChannelCd(C_Channelcd.TIGIN);
        checkTuusan.exec(mosnaiCheckParam, tuusan);
        exNumericEquals(hubiMsgLst.size(), 0, "不備メッセージテーブルエンティティリストの件数");
        exClassificationEquals(mosnaiCheckParam.getSakuinTsnKbn(), C_SakuintsnKbn.SEIJYOU, "索引通算区分");

    }

    @Test
    @TestOrder(920)
    public void testExec_A92() {
        MockObjectManager.initialize();
        KeisanSPMockForSinkeiyaku.SYORIPTN = null;
        KeisanGaikakanzanMockForSinkeiyaku.SYORIPTN = null;
        GetKiteiCheckYenkansangkMockForSinkeiyaku.SYORIPTN = null;
        TuusanMockForSinkeiyaku.SYORIPTN = TuusanMockForSinkeiyaku.TESTPATTERN59;
        CheckSaiteiPMockForSinkeiyaku.SYORIPTN = CheckSaiteiPMockForSinkeiyaku.TESTPATTERN1;
        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("792223364");
        List<HT_MosSyouhn> mosSyouhnLst = syoriCTL.getMosSyouhnsBySyutkkbn(C_SyutkKbn.SYU);
        Tuusan tuusan = SWAKInjector.getInstance(Tuusan.class);
        if (mosSyouhnLst.size() > 0) {
            HT_MosSyouhn mosSyouhn = mosSyouhnLst.get(0);
            BM_SyouhnZokusei syouhnZokusei =
                bizDomManager.getSyouhnZokusei(mosSyouhn.getSyouhncd(), mosSyouhn.getSyouhnsdno());
            mosnaiCheckParam.setSyuSyouhnZokusei(syouhnZokusei);
        }
        List<HT_HubiMsg> hubiMsgLst = syoriCTL.getHubiMsgs();
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setListHubiMsg(hubiMsgLst);
        mosnaiCheckParam.setSysKbn(C_SysKbn.ESHIEN);
        mosnaiCheckParam.setSakuinTsnKbn(C_SakuintsnKbn.SEIJYOU);
        mosnaiCheckParam.setKiteiCheckChannelCd(C_Channelcd.TIGIN);
        checkTuusan.exec(mosnaiCheckParam, tuusan);
        exNumericEquals(hubiMsgLst.size(), 0, "不備メッセージテーブルエンティティリストの件数");
        exClassificationEquals(mosnaiCheckParam.getSakuinTsnKbn(), C_SakuintsnKbn.SEIJYOU, "索引通算区分");

    }

    @Test
    @TestOrder(930)
    public void testExec_A93() {
        MockObjectManager.initialize();
        KeisanSPMockForSinkeiyaku.SYORIPTN = null;
        KeisanGaikakanzanMockForSinkeiyaku.SYORIPTN = null;
        GetKiteiCheckYenkansangkMockForSinkeiyaku.SYORIPTN = null;
        TuusanMockForSinkeiyaku.SYORIPTN = TuusanMockForSinkeiyaku.TESTPATTERN61;
        CheckSaiteiPMockForSinkeiyaku.SYORIPTN = CheckSaiteiPMockForSinkeiyaku.TESTPATTERN1;
        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("792223364");
        List<HT_MosSyouhn> mosSyouhnLst = syoriCTL.getMosSyouhnsBySyutkkbn(C_SyutkKbn.SYU);
        Tuusan tuusan = SWAKInjector.getInstance(Tuusan.class);
        if (mosSyouhnLst.size() > 0) {
            HT_MosSyouhn mosSyouhn = mosSyouhnLst.get(0);
            BM_SyouhnZokusei syouhnZokusei =
                bizDomManager.getSyouhnZokusei(mosSyouhn.getSyouhncd(), mosSyouhn.getSyouhnsdno());
            mosnaiCheckParam.setSyuSyouhnZokusei(syouhnZokusei);
        }
        List<HT_HubiMsg> hubiMsgLst = syoriCTL.getHubiMsgs();
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setListHubiMsg(hubiMsgLst);
        mosnaiCheckParam.setSysKbn(C_SysKbn.SKEI);
        mosnaiCheckParam.setSakuinTsnKbn(C_SakuintsnKbn.SEIJYOU);
        mosnaiCheckParam.setKiteiCheckChannelCd(C_Channelcd.TIGIN);
        checkTuusan.exec(mosnaiCheckParam, tuusan);
        exNumericEquals(hubiMsgLst.size(), 0, "不備メッセージテーブルエンティティリストの件数");
        exClassificationEquals(mosnaiCheckParam.getSakuinTsnKbn(), C_SakuintsnKbn.SEIJYOU, "索引通算区分");

    }

    @Test
    @TestOrder(940)
    public void testExec_A94() {
        KeisanGaikakanzanMockForSinkeiyaku.SYORIPTN = null;
        TuusanMockForSinkeiyaku.SYORIPTN = TuusanMockForSinkeiyaku.TESTPATTERN13;
        CheckSaiteiPMockForSinkeiyaku.SYORIPTN = CheckSaiteiPMockForSinkeiyaku.TESTPATTERN1;
        KeisanSPMockForSinkeiyaku.SYORIPTN = null;
        GetKiteiCheckYenkansangkMockForSinkeiyaku.SYORIPTN = GetKiteiCheckYenkansangkMockForSinkeiyaku.TESTPATTERN4;
        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("791112386");
        List<HT_MosSyouhn> mosSyouhnLst = syoriCTL.getMosSyouhnsBySyutkkbn(C_SyutkKbn.SYU);
        Tuusan tuusan = SWAKInjector.getInstance(Tuusan.class);
        if (mosSyouhnLst.size() > 0) {
            HT_MosSyouhn mosSyouhn = mosSyouhnLst.get(0);
            BM_SyouhnZokusei syouhnZokusei =
                bizDomManager.getSyouhnZokusei(mosSyouhn.getSyouhncd(), mosSyouhn.getSyouhnsdno());
            mosnaiCheckParam.setSyuSyouhnZokusei(syouhnZokusei);
        }
        List<HT_HubiMsg> hubiMsgLst = syoriCTL.getHubiMsgs();
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setListHubiMsg(hubiMsgLst);
        mosnaiCheckParam.setSysKbn(C_SysKbn.SKEI);
        mosnaiCheckParam.setSakuinTsnKbn(C_SakuintsnKbn.SEIJYOU);
        mosnaiCheckParam.setKiteiCheckChannelCd(C_Channelcd.TIGIN);
        checkTuusan.exec(mosnaiCheckParam, tuusan);
        exNumericEquals(hubiMsgLst.size(), 1, "不備メッセージテーブルエンティティリストの件数");
        exStringEquals(hubiMsgLst.get(0).getMosno(), "791112386", "申込番号");
        exNumericEquals(hubiMsgLst.get(0).getRenno(), 1, "連番");
        exStringEquals(hubiMsgLst.get(0).getHubimsg(), "通算２年未経過総死亡Ｓ限度額の１２０円をオーバーしています。　保険料は０円までにしてください。", "不備メッセージ");
        exStringEquals(hubiMsgLst.get(0).getMessageId(), "EHC1045", "メッセージＩＤ");
        exClassificationEquals(hubiMsgLst.get(0).getHubisyubetukbn(), C_HubisyubetuKbn.KETHORYU_HUBI, "不備種別区分");

        exClassificationEquals(mosnaiCheckParam.getSakuinTsnKbn(), C_SakuintsnKbn.ERROR, "索引通算区分");

    }

    @Test
    @TestOrder(950)
    public void testExec_A95() {
        CheckSaiteiPMockForSinkeiyaku.SYORIPTN = null;
        KeisanGaikakanzanMockForSinkeiyaku.SYORIPTN = null;
        TuusanMockForSinkeiyaku.SYORIPTN = TuusanMockForSinkeiyaku.TESTPATTERN15;
        KeisanSPMockForSinkeiyaku.flg = "0";
        KeisanSPMockForSinkeiyaku.SYORIPTN = KeisanSPMockForSinkeiyaku.TESTPATTERN3;
        GetKiteiCheckYenkansangkMockForSinkeiyaku.LoopFlag = 0;
        GetKiteiCheckYenkansangkMockForSinkeiyaku.SYORIPTN = GetKiteiCheckYenkansangkMockForSinkeiyaku.TESTPATTERN8;
        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("791112519");
        List<HT_MosSyouhn> mosSyouhnLst = syoriCTL.getMosSyouhnsBySyutkkbn(C_SyutkKbn.SYU);
        Tuusan tuusan = SWAKInjector.getInstance(Tuusan.class);
        if (mosSyouhnLst.size() > 0) {
            HT_MosSyouhn mosSyouhn = mosSyouhnLst.get(0);
            BM_SyouhnZokusei syouhnZokusei =
                bizDomManager.getSyouhnZokusei(mosSyouhn.getSyouhncd(), mosSyouhn.getSyouhnsdno());
            mosnaiCheckParam.setSyuSyouhnZokusei(syouhnZokusei);
        }
        List<HT_HubiMsg> hubiMsgLst = syoriCTL.getHubiMsgs();
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setListHubiMsg(hubiMsgLst);
        mosnaiCheckParam.setSysKbn(C_SysKbn.ESHIEN);
        mosnaiCheckParam.setSakuinTsnKbn(C_SakuintsnKbn.SEIJYOU);
        mosnaiCheckParam.setKiteiCheckChannelCd(C_Channelcd.TIGIN);
        checkTuusan.exec(mosnaiCheckParam, tuusan);
        exNumericEquals(hubiMsgLst.size(), 0, "不備メッセージテーブルエンティティリストの件数");
        exClassificationEquals(mosnaiCheckParam.getSekmossakuseiErroutKbn(), C_SekmossakuseiErroutKbn.GAMEN,
            "設計書申込書作成エラー出力区分 ");
        exStringEquals(mosnaiCheckParam.getSekmossakuseiErrmsg1(), "通算保険金額が限度額を超えています", "設計書申込書作成エラーメッセージ１");
        exStringEquals(mosnaiCheckParam.getSekmossakuseiErrmsg2(), "保険料は０円までにしてください", "設計書申込書作成エラーメッセージ２");
        exClassificationEquals(mosnaiCheckParam.getKouzokuSyoriJikkouKbn(), C_KouzokujkKbn.NONE, "後続処理実行区分");
        exClassificationEquals(mosnaiCheckParam.getSakuinTsnKbn(), C_SakuintsnKbn.ERROR, "索引通算区分");
    }

    @Test
    @TestOrder(960)
    public void testExec_A96() {
        CheckSaiteiPMockForSinkeiyaku.SYORIPTN = null;
        KeisanGaikakanzanMockForSinkeiyaku.SYORIPTN = null;
        TuusanMockForSinkeiyaku.SYORIPTN = TuusanMockForSinkeiyaku.TESTPATTERN15;
        KeisanSPMockForSinkeiyaku.SYORIPTN = null;
        GetKiteiCheckYenkansangkMockForSinkeiyaku.LoopFlag = 0;
        GetKiteiCheckYenkansangkMockForSinkeiyaku.SYORIPTN = GetKiteiCheckYenkansangkMockForSinkeiyaku.TESTPATTERN9;
        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("791112519");
        List<HT_MosSyouhn> mosSyouhnLst = syoriCTL.getMosSyouhnsBySyutkkbn(C_SyutkKbn.SYU);
        Tuusan tuusan = SWAKInjector.getInstance(Tuusan.class);
        if (mosSyouhnLst.size() > 0) {
            HT_MosSyouhn mosSyouhn = mosSyouhnLst.get(0);
            BM_SyouhnZokusei syouhnZokusei =
                bizDomManager.getSyouhnZokusei(mosSyouhn.getSyouhncd(), mosSyouhn.getSyouhnsdno());
            mosnaiCheckParam.setSyuSyouhnZokusei(syouhnZokusei);
        }
        List<HT_HubiMsg> hubiMsgLst = syoriCTL.getHubiMsgs();
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setListHubiMsg(hubiMsgLst);
        mosnaiCheckParam.setSysKbn(C_SysKbn.ESHIEN);
        mosnaiCheckParam.setSakuinTsnKbn(C_SakuintsnKbn.SEIJYOU);
        mosnaiCheckParam.setKiteiCheckChannelCd(C_Channelcd.TIGIN);
        checkTuusan.exec(mosnaiCheckParam, tuusan);
        exNumericEquals(hubiMsgLst.size(), 0, "不備メッセージテーブルエンティティリストの件数");
        exClassificationEquals(mosnaiCheckParam.getSekmossakuseiErroutKbn(), C_SekmossakuseiErroutKbn.GAMEN,
            "設計書申込書作成エラー出力区分 ");
        exStringEquals(mosnaiCheckParam.getSekmossakuseiErrmsg1(), "通算保険金額が限度額を超えています", "設計書申込書作成エラーメッセージ１");
        exStringEquals(mosnaiCheckParam.getSekmossakuseiErrmsg2(), "保険料は１１５円までにしてください", "設計書申込書作成エラーメッセージ２");
        exClassificationEquals(mosnaiCheckParam.getKouzokuSyoriJikkouKbn(), C_KouzokujkKbn.NONE, "後続処理実行区分");
        exClassificationEquals(mosnaiCheckParam.getSakuinTsnKbn(), C_SakuintsnKbn.ERROR, "索引通算区分");
    }

    @Test(expected = CommonBizAppException.class)
    @TestOrder(970)
    public void testExec_A97() {
        CheckSaiteiPMockForSinkeiyaku.SYORIPTN = null;
        KeisanGaikakanzanMockForSinkeiyaku.SYORIPTN = null;
        TuusanMockForSinkeiyaku.SYORIPTN = TuusanMockForSinkeiyaku.TESTPATTERN15;
        KeisanSPMockForSinkeiyaku.SYORIPTN = null;
        GetKiteiCheckYenkansangkMockForSinkeiyaku.SYORIPTN = GetKiteiCheckYenkansangkMockForSinkeiyaku.TESTPATTERN19;
        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("791112519");
        List<HT_MosSyouhn> mosSyouhnLst = syoriCTL.getMosSyouhnsBySyutkkbn(C_SyutkKbn.SYU);
        Tuusan tuusan = SWAKInjector.getInstance(Tuusan.class);
        if (mosSyouhnLst.size() > 0) {
            HT_MosSyouhn mosSyouhn = mosSyouhnLst.get(0);
            BM_SyouhnZokusei syouhnZokusei =
                bizDomManager.getSyouhnZokusei(mosSyouhn.getSyouhncd(), mosSyouhn.getSyouhnsdno());
            mosnaiCheckParam.setSyuSyouhnZokusei(syouhnZokusei);
        }
        List<HT_HubiMsg> hubiMsgLst = syoriCTL.getHubiMsgs();
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setListHubiMsg(hubiMsgLst);
        mosnaiCheckParam.setSysKbn(C_SysKbn.ESHIEN);
        mosnaiCheckParam.setSakuinTsnKbn(C_SakuintsnKbn.SEIJYOU);
        mosnaiCheckParam.setKiteiCheckChannelCd(C_Channelcd.TIGIN);
        checkTuusan.exec(mosnaiCheckParam, tuusan);
        try {
            checkTuusan.exec(mosnaiCheckParam, tuusan);
        } catch (CommonBizAppException e) {
            exStringEquals(e.getMessage(), "限度範囲内保険料取得　申込番号=791112519", "エラーメッセージ");
            throw e;
        }
    }

    @Test
    @TestOrder(980)
    public void testExec_A98() {
        CheckSaiteiPMockForSinkeiyaku.SYORIPTN = null;
        KeisanGaikakanzanMockForSinkeiyaku.SYORIPTN = null;
        TuusanMockForSinkeiyaku.SYORIPTN = TuusanMockForSinkeiyaku.TESTPATTERN15;
        KeisanSPMockForSinkeiyaku.SYORIPTN = null;
        GetKiteiCheckYenkansangkMockForSinkeiyaku.LoopFlag = 0;
        GetKiteiCheckYenkansangkMockForSinkeiyaku.SYORIPTN = GetKiteiCheckYenkansangkMockForSinkeiyaku.TESTPATTERN11;
        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("791112519");
        List<HT_MosSyouhn> mosSyouhnLst = syoriCTL.getMosSyouhnsBySyutkkbn(C_SyutkKbn.SYU);
        Tuusan tuusan = SWAKInjector.getInstance(Tuusan.class);
        if (mosSyouhnLst.size() > 0) {
            HT_MosSyouhn mosSyouhn = mosSyouhnLst.get(0);
            BM_SyouhnZokusei syouhnZokusei =
                bizDomManager.getSyouhnZokusei(mosSyouhn.getSyouhncd(), mosSyouhn.getSyouhnsdno());
            mosnaiCheckParam.setSyuSyouhnZokusei(syouhnZokusei);
        }
        List<HT_HubiMsg> hubiMsgLst = syoriCTL.getHubiMsgs();
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setListHubiMsg(hubiMsgLst);
        mosnaiCheckParam.setSysKbn(C_SysKbn.ESHIEN);
        mosnaiCheckParam.setSakuinTsnKbn(C_SakuintsnKbn.SEIJYOU);
        mosnaiCheckParam.setKiteiCheckChannelCd(C_Channelcd.TIGIN);
        checkTuusan.exec(mosnaiCheckParam, tuusan);
        exNumericEquals(hubiMsgLst.size(), 0, "不備メッセージテーブルエンティティリストの件数");
        exClassificationEquals(mosnaiCheckParam.getSekmossakuseiErroutKbn(), C_SekmossakuseiErroutKbn.GAMEN,
            "設計書申込書作成エラー出力区分 ");
        exStringEquals(mosnaiCheckParam.getSekmossakuseiErrmsg1(), "通算保険金額が限度額を超えています", "設計書申込書作成エラーメッセージ１");
        exStringEquals(mosnaiCheckParam.getSekmossakuseiErrmsg2(), "保険料は６９円までにしてください", "設計書申込書作成エラーメッセージ２");
        exClassificationEquals(mosnaiCheckParam.getKouzokuSyoriJikkouKbn(), C_KouzokujkKbn.NONE, "後続処理実行区分");
        exClassificationEquals(mosnaiCheckParam.getSakuinTsnKbn(), C_SakuintsnKbn.ERROR, "索引通算区分");
    }

    @Test
    @TestOrder(990)
    public void testExec_A99() {
        CheckSaiteiPMockForSinkeiyaku.SYORIPTN = null;
        KeisanGaikakanzanMockForSinkeiyaku.SYORIPTN = null;
        TuusanMockForSinkeiyaku.SYORIPTN = TuusanMockForSinkeiyaku.TESTPATTERN15;
        KeisanSPMockForSinkeiyaku.SYORIPTN = null;
        GetKiteiCheckYenkansangkMockForSinkeiyaku.SYORIPTN = GetKiteiCheckYenkansangkMockForSinkeiyaku.TESTPATTERN12;
        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("791112519");
        List<HT_MosSyouhn> mosSyouhnLst = syoriCTL.getMosSyouhnsBySyutkkbn(C_SyutkKbn.SYU);
        Tuusan tuusan = SWAKInjector.getInstance(Tuusan.class);
        if (mosSyouhnLst.size() > 0) {
            HT_MosSyouhn mosSyouhn = mosSyouhnLst.get(0);
            BM_SyouhnZokusei syouhnZokusei =
                bizDomManager.getSyouhnZokusei(mosSyouhn.getSyouhncd(), mosSyouhn.getSyouhnsdno());
            mosnaiCheckParam.setSyuSyouhnZokusei(syouhnZokusei);
        }
        List<HT_HubiMsg> hubiMsgLst = syoriCTL.getHubiMsgs();
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setListHubiMsg(hubiMsgLst);
        mosnaiCheckParam.setSysKbn(C_SysKbn.ESHIEN);
        mosnaiCheckParam.setSakuinTsnKbn(C_SakuintsnKbn.SEIJYOU);
        mosnaiCheckParam.setKiteiCheckChannelCd(C_Channelcd.TIGIN);
        checkTuusan.exec(mosnaiCheckParam, tuusan);
        exNumericEquals(hubiMsgLst.size(), 0, "不備メッセージテーブルエンティティリストの件数");
        exClassificationEquals(mosnaiCheckParam.getSekmossakuseiErroutKbn(), C_SekmossakuseiErroutKbn.GAMEN,
            "設計書申込書作成エラー出力区分 ");
        exStringEquals(mosnaiCheckParam.getSekmossakuseiErrmsg1(), "通算保険金額が限度額を超えています", "設計書申込書作成エラーメッセージ１");
        exStringEquals(mosnaiCheckParam.getSekmossakuseiErrmsg2(), "保険料は６９円までにしてください", "設計書申込書作成エラーメッセージ２");
        exClassificationEquals(mosnaiCheckParam.getKouzokuSyoriJikkouKbn(), C_KouzokujkKbn.NONE, "後続処理実行区分");
        exClassificationEquals(mosnaiCheckParam.getSakuinTsnKbn(), C_SakuintsnKbn.ERROR, "索引通算区分");
    }

    @Test(expected = CommonBizAppException.class)
    @TestOrder(1050)
    public void testExec_A105() {
        CheckSaiteiPMockForSinkeiyaku.SYORIPTN = null;
        KeisanGaikakanzanMockForSinkeiyaku.SYORIPTN = null;
        TuusanMockForSinkeiyaku.SYORIPTN = TuusanMockForSinkeiyaku.TESTPATTERN15;
        KeisanSPMockForSinkeiyaku.SYORIPTN = null;
        GetKiteiCheckYenkansangkMockForSinkeiyaku.SYORIPTN = GetKiteiCheckYenkansangkMockForSinkeiyaku.TESTPATTERN17;
        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("860000199");
        List<HT_MosSyouhn> mosSyouhnLst = syoriCTL.getMosSyouhnsBySyutkkbn(C_SyutkKbn.SYU);
        Tuusan tuusan = SWAKInjector.getInstance(Tuusan.class);
        if (mosSyouhnLst.size() > 0) {
            HT_MosSyouhn mosSyouhn = mosSyouhnLst.get(0);
            BM_SyouhnZokusei syouhnZokusei =
                bizDomManager.getSyouhnZokusei(mosSyouhn.getSyouhncd(), mosSyouhn.getSyouhnsdno());
            mosnaiCheckParam.setSyuSyouhnZokusei(syouhnZokusei);
        }
        List<HT_HubiMsg> hubiMsgLst = syoriCTL.getHubiMsgs();
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setListHubiMsg(hubiMsgLst);
        mosnaiCheckParam.setSysKbn(C_SysKbn.ESHIEN);
        mosnaiCheckParam.setSakuinTsnKbn(C_SakuintsnKbn.SEIJYOU);
        mosnaiCheckParam.setKiteiCheckChannelCd(C_Channelcd.TIGIN);
        try {
            checkTuusan.exec(mosnaiCheckParam, tuusan);
        } catch (CommonBizAppException e) {
            exStringEquals(e.getMessage(), "システム整合性エラーです。申込番号=860000199", "エラーメッセージ");
            throw e;
        }
    }

    @Test(expected = CommonBizAppException.class)
    @TestOrder(1060)
    public void testExec_A106() {
        KeisanGaikakanzanMockForSinkeiyaku.SYORIPTN = null;
        TuusanMockForSinkeiyaku.SYORIPTN = TuusanMockForSinkeiyaku.TESTPATTERN13;
        CheckSaiteiPMockForSinkeiyaku.SYORIPTN = CheckSaiteiPMockForSinkeiyaku.TESTPATTERN2;
        KeisanSPMockForSinkeiyaku.SYORIPTN = null;
        GetKiteiCheckYenkansangkMockForSinkeiyaku.SYORIPTN = GetKiteiCheckYenkansangkMockForSinkeiyaku.TESTPATTERN4;
        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("860000165");
        List<HT_MosSyouhn> mosSyouhnLst = syoriCTL.getMosSyouhnsBySyutkkbn(C_SyutkKbn.SYU);
        Tuusan tuusan = SWAKInjector.getInstance(Tuusan.class);
        if (mosSyouhnLst.size() > 0) {
            HT_MosSyouhn mosSyouhn = mosSyouhnLst.get(0);
            BM_SyouhnZokusei syouhnZokusei =
                bizDomManager.getSyouhnZokusei(mosSyouhn.getSyouhncd(), mosSyouhn.getSyouhnsdno());
            mosnaiCheckParam.setSyuSyouhnZokusei(syouhnZokusei);
        }
        List<HT_HubiMsg> hubiMsgLst = syoriCTL.getHubiMsgs();
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setListHubiMsg(hubiMsgLst);
        mosnaiCheckParam.setSysKbn(C_SysKbn.SKEI);
        mosnaiCheckParam.setSakuinTsnKbn(C_SakuintsnKbn.SEIJYOU);
        mosnaiCheckParam.setKiteiCheckChannelCd(C_Channelcd.TIGIN);
        try {
            checkTuusan.exec(mosnaiCheckParam, tuusan);
        } catch (CommonBizAppException e) {
            exStringEquals(e.getMessage(), "システム整合性エラーです。申込番号 = 860000165", "エラーメッセージ");
            throw e;
        }
    }

    @Test
    @TestOrder(1070)
    public void testExec_A107() {
        CheckSaiteiPMockForSinkeiyaku.SYORIPTN = CheckSaiteiPMockForSinkeiyaku.TESTPATTERN1;
        KeisanGaikakanzanMockForSinkeiyaku.SYORIPTN = null;
        TuusanMockForSinkeiyaku.SYORIPTN = TuusanMockForSinkeiyaku.TESTPATTERN11;
        KeisanSPMockForSinkeiyaku.SYORIPTN = null;
        GetKiteiCheckYenkansangkMockForSinkeiyaku.SYORIPTN = null;
        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("860000207");
        List<HT_MosSyouhn> mosSyouhnLst = syoriCTL.getMosSyouhnsBySyutkkbn(C_SyutkKbn.SYU);
        Tuusan tuusan = SWAKInjector.getInstance(Tuusan.class);
        if (mosSyouhnLst.size() > 0) {
            HT_MosSyouhn mosSyouhn = mosSyouhnLst.get(0);
            BM_SyouhnZokusei syouhnZokusei =
                bizDomManager.getSyouhnZokusei(mosSyouhn.getSyouhncd(), mosSyouhn.getSyouhnsdno());
            mosnaiCheckParam.setSyuSyouhnZokusei(syouhnZokusei);
        }
        List<HT_HubiMsg> hubiMsgLst = syoriCTL.getHubiMsgs();
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setListHubiMsg(hubiMsgLst);
        mosnaiCheckParam.setSysKbn(C_SysKbn.SKEI);
        mosnaiCheckParam.setSakuinTsnKbn(C_SakuintsnKbn.SEIJYOU);
        mosnaiCheckParam.setKiteiCheckChannelCd(C_Channelcd.TIGIN);
        checkTuusan.exec(mosnaiCheckParam, tuusan);
        exNumericEquals(hubiMsgLst.size(), 1, "不備メッセージテーブルエンティティリストの件数");
        exStringEquals(hubiMsgLst.get(0).getMosno(), "860000207", "申込番号");
        exNumericEquals(hubiMsgLst.get(0).getRenno(), 1, "連番");
        exStringEquals(hubiMsgLst.get(0).getHubimsg(), "【特認可能】通算総死亡Ｓ限度額の１０５円をオーバーしています。　通算総死亡Ｓ　１１０円", "不備メッセージ");
        exStringEquals(hubiMsgLst.get(0).getMessageId(), "THC1022", "メッセージＩＤ");
        exClassificationEquals(hubiMsgLst.get(0).getHubisyubetukbn(), C_HubisyubetuKbn.KETHORYU_HUBI, "不備種別区分");
        exClassificationEquals(mosnaiCheckParam.getSakuinTsnKbn(), C_SakuintsnKbn.ERROR, "索引通算区分");
    }

    @Test
    @TestOrder(1080)
    public void testExec_A108() {
        CheckSaiteiPMockForSinkeiyaku.SYORIPTN = CheckSaiteiPMockForSinkeiyaku.TESTPATTERN1;
        KeisanGaikakanzanMockForSinkeiyaku.SYORIPTN = null;
        TuusanMockForSinkeiyaku.SYORIPTN = TuusanMockForSinkeiyaku.TESTPATTERN11;
        KeisanSPMockForSinkeiyaku.SYORIPTN = null;
        GetKiteiCheckYenkansangkMockForSinkeiyaku.SYORIPTN = null;
        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("860000215");
        List<HT_MosSyouhn> mosSyouhnLst = syoriCTL.getMosSyouhnsBySyutkkbn(C_SyutkKbn.SYU);
        Tuusan tuusan = SWAKInjector.getInstance(Tuusan.class);
        if (mosSyouhnLst.size() > 0) {
            HT_MosSyouhn mosSyouhn = mosSyouhnLst.get(0);
            BM_SyouhnZokusei syouhnZokusei =
                bizDomManager.getSyouhnZokusei(mosSyouhn.getSyouhncd(), mosSyouhn.getSyouhnsdno());
            mosnaiCheckParam.setSyuSyouhnZokusei(syouhnZokusei);
        }
        List<HT_HubiMsg> hubiMsgLst = syoriCTL.getHubiMsgs();
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setListHubiMsg(hubiMsgLst);
        mosnaiCheckParam.setSysKbn(C_SysKbn.SKEI);
        mosnaiCheckParam.setSakuinTsnKbn(C_SakuintsnKbn.SEIJYOU);
        mosnaiCheckParam.setKiteiCheckChannelCd(C_Channelcd.TIGIN);
        checkTuusan.exec(mosnaiCheckParam, tuusan);
        exNumericEquals(hubiMsgLst.size(), 1, "不備メッセージテーブルエンティティリストの件数");
        exStringEquals(hubiMsgLst.get(0).getMosno(), "860000215", "申込番号");
        exNumericEquals(hubiMsgLst.get(0).getRenno(), 1, "連番");
        exStringEquals(hubiMsgLst.get(0).getHubimsg(), "【特認可能】通算総死亡Ｓ限度額の１０５円をオーバーしています。　通算総死亡Ｓ　１１０円", "不備メッセージ");
        exStringEquals(hubiMsgLst.get(0).getMessageId(), "THC1022", "メッセージＩＤ");
        exClassificationEquals(hubiMsgLst.get(0).getHubisyubetukbn(), C_HubisyubetuKbn.KETHORYU_HUBI, "不備種別区分");
        exClassificationEquals(mosnaiCheckParam.getSakuinTsnKbn(), C_SakuintsnKbn.ERROR, "索引通算区分");
    }

    @Test
    @TestOrder(1090)
    public void testExec_A109() {
        CheckSaiteiPMockForSinkeiyaku.SYORIPTN = CheckSaiteiPMockForSinkeiyaku.TESTPATTERN1;
        KeisanGaikakanzanMockForSinkeiyaku.SYORIPTN = null;
        TuusanMockForSinkeiyaku.SYORIPTN = TuusanMockForSinkeiyaku.TESTPATTERN11;
        KeisanSPMockForSinkeiyaku.SYORIPTN = null;
        GetKiteiCheckYenkansangkMockForSinkeiyaku.SYORIPTN = null;
        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("860000223");
        List<HT_MosSyouhn> mosSyouhnLst = syoriCTL.getMosSyouhnsBySyutkkbn(C_SyutkKbn.SYU);
        Tuusan tuusan = SWAKInjector.getInstance(Tuusan.class);
        if (mosSyouhnLst.size() > 0) {
            HT_MosSyouhn mosSyouhn = mosSyouhnLst.get(0);
            BM_SyouhnZokusei syouhnZokusei =
                bizDomManager.getSyouhnZokusei(mosSyouhn.getSyouhncd(), mosSyouhn.getSyouhnsdno());
            mosnaiCheckParam.setSyuSyouhnZokusei(syouhnZokusei);
        }
        List<HT_HubiMsg> hubiMsgLst = syoriCTL.getHubiMsgs();
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setListHubiMsg(hubiMsgLst);
        mosnaiCheckParam.setSysKbn(C_SysKbn.SKEI);
        mosnaiCheckParam.setSakuinTsnKbn(C_SakuintsnKbn.SEIJYOU);
        mosnaiCheckParam.setKiteiCheckChannelCd(C_Channelcd.TIGIN);
        checkTuusan.exec(mosnaiCheckParam, tuusan);
        exNumericEquals(hubiMsgLst.size(), 1, "不備メッセージテーブルエンティティリストの件数");
        exStringEquals(hubiMsgLst.get(0).getMosno(), "860000223", "申込番号");
        exNumericEquals(hubiMsgLst.get(0).getRenno(), 1, "連番");
        exStringEquals(hubiMsgLst.get(0).getHubimsg(), "【特認可能】通算総死亡Ｓ限度額の１０５円をオーバーしています。　通算総死亡Ｓ　１１０円", "不備メッセージ");
        exStringEquals(hubiMsgLst.get(0).getMessageId(), "THC1022", "メッセージＩＤ");
        exClassificationEquals(hubiMsgLst.get(0).getHubisyubetukbn(), C_HubisyubetuKbn.KETHORYU_HUBI, "不備種別区分");
        exClassificationEquals(mosnaiCheckParam.getSakuinTsnKbn(), C_SakuintsnKbn.ERROR, "索引通算区分");
    }

    @Test
    @TestOrder(1100)
    public void testExec_A110() {
        CheckSaiteiPMockForSinkeiyaku.SYORIPTN = CheckSaiteiPMockForSinkeiyaku.TESTPATTERN1;
        KeisanGaikakanzanMockForSinkeiyaku.SYORIPTN = null;
        TuusanMockForSinkeiyaku.SYORIPTN = TuusanMockForSinkeiyaku.TESTPATTERN14;
        KeisanSPMockForSinkeiyaku.SYORIPTN = null;
        GetKiteiCheckYenkansangkMockForSinkeiyaku.SYORIPTN = null;
        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("860000231");
        List<HT_MosSyouhn> mosSyouhnLst = syoriCTL.getMosSyouhnsBySyutkkbn(C_SyutkKbn.SYU);
        Tuusan tuusan = SWAKInjector.getInstance(Tuusan.class);
        if (mosSyouhnLst.size() > 0) {
            HT_MosSyouhn mosSyouhn = mosSyouhnLst.get(0);
            BM_SyouhnZokusei syouhnZokusei =
                bizDomManager.getSyouhnZokusei(mosSyouhn.getSyouhncd(), mosSyouhn.getSyouhnsdno());
            mosnaiCheckParam.setSyuSyouhnZokusei(syouhnZokusei);
        }
        List<HT_HubiMsg> hubiMsgLst = syoriCTL.getHubiMsgs();
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setListHubiMsg(hubiMsgLst);
        mosnaiCheckParam.setSysKbn(C_SysKbn.SKEI);
        mosnaiCheckParam.setSakuinTsnKbn(C_SakuintsnKbn.SEIJYOU);
        mosnaiCheckParam.setKiteiCheckChannelCd(C_Channelcd.TIGIN);
        checkTuusan.exec(mosnaiCheckParam, tuusan);
        exNumericEquals(hubiMsgLst.size(), 0, "不備メッセージテーブルエンティティリストの件数");

        exClassificationEquals(mosnaiCheckParam.getSakuinTsnKbn(), C_SakuintsnKbn.SEIJYOU, "索引通算区分");
    }

    @Test
    @TestOrder(1110)
    public void testExec_A111() {
        CheckSaiteiPMockForSinkeiyaku.SYORIPTN = CheckSaiteiPMockForSinkeiyaku.TESTPATTERN1;
        KeisanGaikakanzanMockForSinkeiyaku.SYORIPTN = null;
        TuusanMockForSinkeiyaku.SYORIPTN = TuusanMockForSinkeiyaku.TESTPATTERN40;
        KeisanSPMockForSinkeiyaku.SYORIPTN = null;
        GetKiteiCheckYenkansangkMockForSinkeiyaku.SYORIPTN = null;
        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("860000231");
        List<HT_MosSyouhn> mosSyouhnLst = syoriCTL.getMosSyouhnsBySyutkkbn(C_SyutkKbn.SYU);
        Tuusan tuusan = SWAKInjector.getInstance(Tuusan.class);
        if (mosSyouhnLst.size() > 0) {
            HT_MosSyouhn mosSyouhn = mosSyouhnLst.get(0);
            BM_SyouhnZokusei syouhnZokusei =
                bizDomManager.getSyouhnZokusei(mosSyouhn.getSyouhncd(), mosSyouhn.getSyouhnsdno());
            mosnaiCheckParam.setSyuSyouhnZokusei(syouhnZokusei);
        }
        List<HT_HubiMsg> hubiMsgLst = syoriCTL.getHubiMsgs();
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setListHubiMsg(hubiMsgLst);
        mosnaiCheckParam.setSysKbn(C_SysKbn.SKEI);
        mosnaiCheckParam.setSakuinTsnKbn(C_SakuintsnKbn.SEIJYOU);
        mosnaiCheckParam.setKiteiCheckChannelCd(C_Channelcd.TIGIN);
        checkTuusan.exec(mosnaiCheckParam, tuusan);
        exNumericEquals(hubiMsgLst.size(), 0, "不備メッセージテーブルエンティティリストの件数");

        exClassificationEquals(mosnaiCheckParam.getSakuinTsnKbn(), C_SakuintsnKbn.SEIJYOU, "索引通算区分");
    }

    @Test
    @TestOrder(1120)
    public void testExec_A112() {
        CheckSaiteiPMockForSinkeiyaku.SYORIPTN = CheckSaiteiPMockForSinkeiyaku.TESTPATTERN1;
        KeisanGaikakanzanMockForSinkeiyaku.SYORIPTN = null;
        TuusanMockForSinkeiyaku.SYORIPTN = TuusanMockForSinkeiyaku.TESTPATTERN41;
        KeisanSPMockForSinkeiyaku.SYORIPTN = null;
        GetKiteiCheckYenkansangkMockForSinkeiyaku.SYORIPTN = null;
        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("860000231");
        List<HT_MosSyouhn> mosSyouhnLst = syoriCTL.getMosSyouhnsBySyutkkbn(C_SyutkKbn.SYU);
        Tuusan tuusan = SWAKInjector.getInstance(Tuusan.class);
        if (mosSyouhnLst.size() > 0) {
            HT_MosSyouhn mosSyouhn = mosSyouhnLst.get(0);
            BM_SyouhnZokusei syouhnZokusei =
                bizDomManager.getSyouhnZokusei(mosSyouhn.getSyouhncd(), mosSyouhn.getSyouhnsdno());
            mosnaiCheckParam.setSyuSyouhnZokusei(syouhnZokusei);
        }
        List<HT_HubiMsg> hubiMsgLst = syoriCTL.getHubiMsgs();
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setListHubiMsg(hubiMsgLst);
        mosnaiCheckParam.setSysKbn(C_SysKbn.SKEI);
        mosnaiCheckParam.setSakuinTsnKbn(C_SakuintsnKbn.SEIJYOU);
        mosnaiCheckParam.setKiteiCheckChannelCd(C_Channelcd.TIGIN);
        checkTuusan.exec(mosnaiCheckParam, tuusan);
        exNumericEquals(hubiMsgLst.size(), 0, "不備メッセージテーブルエンティティリストの件数");

        exClassificationEquals(mosnaiCheckParam.getSakuinTsnKbn(), C_SakuintsnKbn.SEIJYOU, "索引通算区分");
    }

    @Test
    @TestOrder(1130)
    public void testExec_A113() {
        KeisanSPMockForSinkeiyaku.SYORIPTN = KeisanSPMockForSinkeiyaku.TESTPATTERN4;
        KeisanGaikakanzanMockForSinkeiyaku.SYORIPTN = null;
        GetKiteiCheckYenkansangkMockForSinkeiyaku.SYORIPTN = GetKiteiCheckYenkansangkMockForSinkeiyaku.TESTPATTERN18;
        TuusanMockForSinkeiyaku.SYORIPTN = TuusanMockForSinkeiyaku.TESTPATTERN13;
        CheckSaiteiPMockForSinkeiyaku.SYORIPTN = CheckSaiteiPMockForSinkeiyaku.TESTPATTERN17;
        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("791112378");
        List<HT_MosSyouhn> mosSyouhnLst = syoriCTL.getMosSyouhnsBySyutkkbn(C_SyutkKbn.SYU);
        Tuusan tuusan = SWAKInjector.getInstance(Tuusan.class);
        if (mosSyouhnLst.size() > 0) {
            HT_MosSyouhn mosSyouhn = mosSyouhnLst.get(0);
            BM_SyouhnZokusei syouhnZokusei =
                bizDomManager.getSyouhnZokusei(mosSyouhn.getSyouhncd(), mosSyouhn.getSyouhnsdno());
            mosnaiCheckParam.setSyuSyouhnZokusei(syouhnZokusei);
        }
        List<HT_HubiMsg> hubiMsgLst = syoriCTL.getHubiMsgs();
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setListHubiMsg(hubiMsgLst);
        mosnaiCheckParam.setSysKbn(C_SysKbn.SKEI);
        mosnaiCheckParam.setSakuinTsnKbn(C_SakuintsnKbn.SEIJYOU);
        mosnaiCheckParam.setKiteiCheckChannelCd(C_Channelcd.TIGIN);

        checkTuusan.exec(mosnaiCheckParam, tuusan);
        exNumericEquals(hubiMsgLst.size(), 1, "不備メッセージテーブルエンティティリストの件数");
        exStringEquals(hubiMsgLst.get(0).getMosno(), "791112378", "申込番号");
        exNumericEquals(hubiMsgLst.get(0).getRenno(), 1, "連番");
        exStringEquals(hubiMsgLst.get(0).getHubimsg(), "【特認可能】年金原資限度額の１００円をオーバーしています。　ご加入できません。", "不備メッセージ");
        exStringEquals(hubiMsgLst.get(0).getMessageId(), "THC1063", "メッセージＩＤ");
        exClassificationEquals(hubiMsgLst.get(0).getHubisyubetukbn(), C_HubisyubetuKbn.KETHORYU_HUBI, "不備種別区分");
        exClassificationEquals(mosnaiCheckParam.getSakuinTsnKbn(), C_SakuintsnKbn.ERROR, "索引通算区分");

    }

    @Test
    @TestOrder(1140)
    public void testExec_A114() {
        KeisanSPMockForSinkeiyaku.SYORIPTN = KeisanSPMockForSinkeiyaku.TESTPATTERN4;
        KeisanGaikakanzanMockForSinkeiyaku.SYORIPTN = null;
        GetKiteiCheckYenkansangkMockForSinkeiyaku.SYORIPTN = GetKiteiCheckYenkansangkMockForSinkeiyaku.TESTPATTERN18;
        TuusanMockForSinkeiyaku.SYORIPTN = TuusanMockForSinkeiyaku.TESTPATTERN13;
        CheckSaiteiPMockForSinkeiyaku.SYORIPTN = CheckSaiteiPMockForSinkeiyaku.TESTPATTERN17;
        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("791112378");
        List<HT_MosSyouhn> mosSyouhnLst = syoriCTL.getMosSyouhnsBySyutkkbn(C_SyutkKbn.SYU);
        Tuusan tuusan = SWAKInjector.getInstance(Tuusan.class);
        if (mosSyouhnLst.size() > 0) {
            HT_MosSyouhn mosSyouhn = mosSyouhnLst.get(0);
            BM_SyouhnZokusei syouhnZokusei =
                bizDomManager.getSyouhnZokusei(mosSyouhn.getSyouhncd(), mosSyouhn.getSyouhnsdno());
            mosnaiCheckParam.setSyuSyouhnZokusei(syouhnZokusei);
        }
        List<HT_HubiMsg> hubiMsgLst = syoriCTL.getHubiMsgs();
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setListHubiMsg(hubiMsgLst);
        mosnaiCheckParam.setSysKbn(C_SysKbn.ESHIEN);
        mosnaiCheckParam.setSakuinTsnKbn(C_SakuintsnKbn.SEIJYOU);
        mosnaiCheckParam.setKiteiCheckChannelCd(C_Channelcd.TIGIN);

        checkTuusan.exec(mosnaiCheckParam, tuusan);
        exNumericEquals(hubiMsgLst.size(), 0, "不備メッセージテーブルエンティティリストの件数");
        exClassificationEquals(mosnaiCheckParam.getSekmossakuseiErroutKbn(), C_SekmossakuseiErroutKbn.GAMEN,
            "設計書申込書作成エラー出力区分 ");
        exStringEquals(mosnaiCheckParam.getSekmossakuseiErrmsg1(), "", "設計書申込書作成エラーメッセージ１");
        exStringEquals(mosnaiCheckParam.getSekmossakuseiErrmsg2(), "通算年金原資額が限度額を超えています　ご加入できません", "設計書申込書作成エラーメッセージ２");
        exClassificationEquals(mosnaiCheckParam.getKouzokuSyoriJikkouKbn(), C_KouzokujkKbn.NONE, "後続処理実行区分");
        exClassificationEquals(mosnaiCheckParam.getSakuinTsnKbn(), C_SakuintsnKbn.ERROR, "索引通算区分");

    }

    @Test
    @TestOrder(1150)
    public void testExec_A115() {
        KeisanSPMockForSinkeiyaku.SYORIPTN = KeisanSPMockForSinkeiyaku.TESTPATTERN4;
        KeisanGaikakanzanMockForSinkeiyaku.SYORIPTN = null;
        GetKiteiCheckYenkansangkMockForSinkeiyaku.SYORIPTN = GetKiteiCheckYenkansangkMockForSinkeiyaku.TESTPATTERN18;
        TuusanMockForSinkeiyaku.SYORIPTN = TuusanMockForSinkeiyaku.TESTPATTERN13;
        CheckSaiteiPMockForSinkeiyaku.SYORIPTN = CheckSaiteiPMockForSinkeiyaku.TESTPATTERN17;
        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("860000249");
        List<HT_MosSyouhn> mosSyouhnLst = syoriCTL.getMosSyouhnsBySyutkkbn(C_SyutkKbn.SYU);
        Tuusan tuusan = SWAKInjector.getInstance(Tuusan.class);
        if (mosSyouhnLst.size() > 0) {
            HT_MosSyouhn mosSyouhn = mosSyouhnLst.get(0);
            BM_SyouhnZokusei syouhnZokusei =
                bizDomManager.getSyouhnZokusei(mosSyouhn.getSyouhncd(), mosSyouhn.getSyouhnsdno());
            mosnaiCheckParam.setSyuSyouhnZokusei(syouhnZokusei);
        }
        List<HT_HubiMsg> hubiMsgLst = syoriCTL.getHubiMsgs();
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setListHubiMsg(hubiMsgLst);
        mosnaiCheckParam.setSysKbn(C_SysKbn.ESHIEN);
        mosnaiCheckParam.setSakuinTsnKbn(C_SakuintsnKbn.SEIJYOU);
        mosnaiCheckParam.setKiteiCheckChannelCd(C_Channelcd.TIGIN);

        checkTuusan.exec(mosnaiCheckParam, tuusan);
        exNumericEquals(hubiMsgLst.size(), 0, "不備メッセージテーブルエンティティリストの件数");
        exClassificationEquals(mosnaiCheckParam.getSekmossakuseiErroutKbn(), C_SekmossakuseiErroutKbn.GAMEN,
            "設計書申込書作成エラー出力区分 ");
        exStringEquals(mosnaiCheckParam.getSekmossakuseiErrmsg1(), "", "設計書申込書作成エラーメッセージ１");
        exStringEquals(mosnaiCheckParam.getSekmossakuseiErrmsg2(), "通算年金原資額が限度額を超えています　ご加入できません", "設計書申込書作成エラーメッセージ２");
        exClassificationEquals(mosnaiCheckParam.getKouzokuSyoriJikkouKbn(), C_KouzokujkKbn.NONE, "後続処理実行区分");
        exClassificationEquals(mosnaiCheckParam.getSakuinTsnKbn(), C_SakuintsnKbn.ERROR, "索引通算区分");

    }

    @Test
    @TestOrder(1160)
    public void testExec_A116() {
        KeisanSPMockForSinkeiyaku.SYORIPTN = KeisanSPMockForSinkeiyaku.TESTPATTERN4;
        KeisanGaikakanzanMockForSinkeiyaku.SYORIPTN = null;
        GetKiteiCheckYenkansangkMockForSinkeiyaku.SYORIPTN = GetKiteiCheckYenkansangkMockForSinkeiyaku.TESTPATTERN18;
        TuusanMockForSinkeiyaku.SYORIPTN = TuusanMockForSinkeiyaku.TESTPATTERN13;
        CheckSaiteiPMockForSinkeiyaku.SYORIPTN = CheckSaiteiPMockForSinkeiyaku.TESTPATTERN17;
        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("860000256");
        List<HT_MosSyouhn> mosSyouhnLst = syoriCTL.getMosSyouhnsBySyutkkbn(C_SyutkKbn.SYU);
        Tuusan tuusan = SWAKInjector.getInstance(Tuusan.class);
        if (mosSyouhnLst.size() > 0) {
            HT_MosSyouhn mosSyouhn = mosSyouhnLst.get(0);
            BM_SyouhnZokusei syouhnZokusei =
                bizDomManager.getSyouhnZokusei(mosSyouhn.getSyouhncd(), mosSyouhn.getSyouhnsdno());
            mosnaiCheckParam.setSyuSyouhnZokusei(syouhnZokusei);
        }
        List<HT_HubiMsg> hubiMsgLst = syoriCTL.getHubiMsgs();
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setListHubiMsg(hubiMsgLst);
        mosnaiCheckParam.setSysKbn(C_SysKbn.ESHIEN);
        mosnaiCheckParam.setSakuinTsnKbn(C_SakuintsnKbn.SEIJYOU);
        mosnaiCheckParam.setKiteiCheckChannelCd(C_Channelcd.TIGIN);

        checkTuusan.exec(mosnaiCheckParam, tuusan);
        exNumericEquals(hubiMsgLst.size(), 0, "不備メッセージテーブルエンティティリストの件数");
        exClassificationEquals(mosnaiCheckParam.getSekmossakuseiErroutKbn(), C_SekmossakuseiErroutKbn.GAMEN,
            "設計書申込書作成エラー出力区分 ");
        exStringEquals(mosnaiCheckParam.getSekmossakuseiErrmsg1(), "", "設計書申込書作成エラーメッセージ１");
        exStringEquals(mosnaiCheckParam.getSekmossakuseiErrmsg2(), "通算年金原資額が限度額を超えています　ご加入できません", "設計書申込書作成エラーメッセージ２");
        exClassificationEquals(mosnaiCheckParam.getKouzokuSyoriJikkouKbn(), C_KouzokujkKbn.NONE, "後続処理実行区分");
        exClassificationEquals(mosnaiCheckParam.getSakuinTsnKbn(), C_SakuintsnKbn.ERROR, "索引通算区分");

    }

    @Test
    @TestOrder(1170)
    public void testExec_A117() {
        KeisanSPMockForSinkeiyaku.SYORIPTN = KeisanSPMockForSinkeiyaku.TESTPATTERN4;
        KeisanGaikakanzanMockForSinkeiyaku.SYORIPTN = null;
        GetKiteiCheckYenkansangkMockForSinkeiyaku.SYORIPTN = GetKiteiCheckYenkansangkMockForSinkeiyaku.TESTPATTERN18;
        TuusanMockForSinkeiyaku.SYORIPTN = TuusanMockForSinkeiyaku.TESTPATTERN13;
        CheckSaiteiPMockForSinkeiyaku.SYORIPTN = CheckSaiteiPMockForSinkeiyaku.TESTPATTERN17;
        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("860000264");
        List<HT_MosSyouhn> mosSyouhnLst = syoriCTL.getMosSyouhnsBySyutkkbn(C_SyutkKbn.SYU);
        Tuusan tuusan = SWAKInjector.getInstance(Tuusan.class);
        if (mosSyouhnLst.size() > 0) {
            HT_MosSyouhn mosSyouhn = mosSyouhnLst.get(0);
            BM_SyouhnZokusei syouhnZokusei =
                bizDomManager.getSyouhnZokusei(mosSyouhn.getSyouhncd(), mosSyouhn.getSyouhnsdno());
            mosnaiCheckParam.setSyuSyouhnZokusei(syouhnZokusei);
        }
        List<HT_HubiMsg> hubiMsgLst = syoriCTL.getHubiMsgs();
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setListHubiMsg(hubiMsgLst);
        mosnaiCheckParam.setSysKbn(C_SysKbn.SKEI);
        mosnaiCheckParam.setSakuinTsnKbn(C_SakuintsnKbn.SEIJYOU);
        mosnaiCheckParam.setKiteiCheckChannelCd(C_Channelcd.TIGIN);

        checkTuusan.exec(mosnaiCheckParam, tuusan);
        exNumericEquals(hubiMsgLst.size(), 1, "不備メッセージテーブルエンティティリストの件数");
        exStringEquals(hubiMsgLst.get(0).getMosno(), "860000264", "申込番号");
        exNumericEquals(hubiMsgLst.get(0).getRenno(), 1, "連番");
        exStringEquals(hubiMsgLst.get(0).getHubimsg(), "【特認可能】年金原資限度額の１００円をオーバーしています。　年金原資　１０１円", "不備メッセージ");
        exStringEquals(hubiMsgLst.get(0).getMessageId(), "THC1027", "メッセージＩＤ");
        exClassificationEquals(hubiMsgLst.get(0).getHubisyubetukbn(), C_HubisyubetuKbn.KETHORYU_HUBI, "不備種別区分");
        exClassificationEquals(mosnaiCheckParam.getSakuinTsnKbn(), C_SakuintsnKbn.ERROR, "索引通算区分");

    }

    @Test
    @TestOrder(1180)
    public void testExec_A118() {
        KeisanGaikakanzanMockForSinkeiyaku.SYORIPTN = null;
        TuusanMockForSinkeiyaku.SYORIPTN = TuusanMockForSinkeiyaku.TESTPATTERN13;
        CheckSaiteiPMockForSinkeiyaku.SYORIPTN = CheckSaiteiPMockForSinkeiyaku.TESTPATTERN8;
        KeisanSPMockForSinkeiyaku.SYORIPTN = KeisanSPMockForSinkeiyaku.TESTPATTERN8;
        KeisanGaikakanzanMockForSinkeiyaku.SYORIPTN = KeisanGaikakanzanMockForSinkeiyaku.TESTPATTERN1;
        GetKiteiCheckYenkansangkMockForSinkeiyaku.LoopFlag = 0;
        GetKiteiCheckYenkansangkMockForSinkeiyaku.SYORIPTN = GetKiteiCheckYenkansangkMockForSinkeiyaku.TESTPATTERN5;
        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("860000272");
        List<HT_MosSyouhn> mosSyouhnLst = syoriCTL.getMosSyouhnsBySyutkkbn(C_SyutkKbn.SYU);
        Tuusan tuusan = SWAKInjector.getInstance(Tuusan.class);
        if (mosSyouhnLst.size() > 0) {
            HT_MosSyouhn mosSyouhn = mosSyouhnLst.get(0);
            BM_SyouhnZokusei syouhnZokusei =
                bizDomManager.getSyouhnZokusei(mosSyouhn.getSyouhncd(), mosSyouhn.getSyouhnsdno());
            mosnaiCheckParam.setSyuSyouhnZokusei(syouhnZokusei);
        }
        List<HT_HubiMsg> hubiMsgLst = syoriCTL.getHubiMsgs();
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setListHubiMsg(hubiMsgLst);
        mosnaiCheckParam.setSysKbn(C_SysKbn.SKEI);
        mosnaiCheckParam.setSakuinTsnKbn(C_SakuintsnKbn.SEIJYOU);
        mosnaiCheckParam.setKiteiCheckChannelCd(C_Channelcd.TIGIN);
        checkTuusan.exec(mosnaiCheckParam, tuusan);
        exNumericEquals(hubiMsgLst.size(), 1, "不備メッセージテーブルエンティティリストの件数");
        exStringEquals(hubiMsgLst.get(0).getMosno(), "860000272", "申込番号");
        exNumericEquals(hubiMsgLst.get(0).getRenno(), 1, "連番");
        exStringEquals(hubiMsgLst.get(0).getHubimsg(), "通算２年未経過総死亡Ｓ限度額の１２０円をオーバーしています。　一時払保険料は２４０円までにしてください。",
            "不備メッセージ");
        exStringEquals(hubiMsgLst.get(0).getMessageId(), "EHC1045", "メッセージＩＤ");
        exClassificationEquals(hubiMsgLst.get(0).getHubisyubetukbn(), C_HubisyubetuKbn.KETHORYU_HUBI, "不備種別区分");

        exClassificationEquals(mosnaiCheckParam.getSakuinTsnKbn(), C_SakuintsnKbn.ERROR, "索引通算区分");

    }

    @Test
    @TestOrder(1190)
    public void testExec_A119() {
        KeisanGaikakanzanMockForSinkeiyaku.SYORIPTN = null;
        TuusanMockForSinkeiyaku.SYORIPTN = TuusanMockForSinkeiyaku.TESTPATTERN13;
        CheckSaiteiPMockForSinkeiyaku.SYORIPTN = CheckSaiteiPMockForSinkeiyaku.TESTPATTERN9;
        KeisanSPMockForSinkeiyaku.SYORIPTN = KeisanSPMockForSinkeiyaku.TESTPATTERN8;
        KeisanGaikakanzanMockForSinkeiyaku.SYORIPTN = KeisanGaikakanzanMockForSinkeiyaku.TESTPATTERN1;
        GetKiteiCheckYenkansangkMockForSinkeiyaku.SYORIPTN = GetKiteiCheckYenkansangkMockForSinkeiyaku.TESTPATTERN5;
        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("860000272");
        List<HT_MosSyouhn> mosSyouhnLst = syoriCTL.getMosSyouhnsBySyutkkbn(C_SyutkKbn.SYU);
        Tuusan tuusan = SWAKInjector.getInstance(Tuusan.class);
        if (mosSyouhnLst.size() > 0) {
            HT_MosSyouhn mosSyouhn = mosSyouhnLst.get(0);
            BM_SyouhnZokusei syouhnZokusei =
                bizDomManager.getSyouhnZokusei(mosSyouhn.getSyouhncd(), mosSyouhn.getSyouhnsdno());
            mosnaiCheckParam.setSyuSyouhnZokusei(syouhnZokusei);
        }
        List<HT_HubiMsg> hubiMsgLst = syoriCTL.getHubiMsgs();
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setListHubiMsg(hubiMsgLst);
        mosnaiCheckParam.setSysKbn(C_SysKbn.SKEI);
        mosnaiCheckParam.setSakuinTsnKbn(C_SakuintsnKbn.SEIJYOU);
        mosnaiCheckParam.setKiteiCheckChannelCd(C_Channelcd.TIGIN);
        checkTuusan.exec(mosnaiCheckParam, tuusan);
        exNumericEquals(hubiMsgLst.size(), 1, "不備メッセージテーブルエンティティリストの件数");
        exStringEquals(hubiMsgLst.get(0).getMosno(), "860000272", "申込番号");
        exNumericEquals(hubiMsgLst.get(0).getRenno(), 1, "連番");
        exStringEquals(hubiMsgLst.get(0).getHubimsg(), "通算２年未経過総死亡Ｓ限度額の１２０円をオーバーしています。　一時払保険料は２４０円までにしてください。",
            "不備メッセージ");
        exStringEquals(hubiMsgLst.get(0).getMessageId(), "EHC1045", "メッセージＩＤ");
        exClassificationEquals(hubiMsgLst.get(0).getHubisyubetukbn(), C_HubisyubetuKbn.KETHORYU_HUBI, "不備種別区分");

        exClassificationEquals(mosnaiCheckParam.getSakuinTsnKbn(), C_SakuintsnKbn.ERROR, "索引通算区分");

    }

    @Test
    @TestOrder(1200)
    public void testExec_A120() {
        KeisanGaikakanzanMockForSinkeiyaku.SYORIPTN = null;
        TuusanMockForSinkeiyaku.SYORIPTN = TuusanMockForSinkeiyaku.TESTPATTERN12;
        CheckSaiteiPMockForSinkeiyaku.SYORIPTN = CheckSaiteiPMockForSinkeiyaku.TESTPATTERN22;
        KeisanSPMockForSinkeiyaku.SYORIPTN = KeisanSPMockForSinkeiyaku.TESTPATTERN2;
        GetKiteiCheckYenkansangkMockForSinkeiyaku.SYORIPTN = GetKiteiCheckYenkansangkMockForSinkeiyaku.TESTPATTERN7;
        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("860000280");
        List<HT_MosSyouhn> mosSyouhnLst = syoriCTL.getMosSyouhnsBySyutkkbn(C_SyutkKbn.SYU);
        Tuusan tuusan = SWAKInjector.getInstance(Tuusan.class);
        if (mosSyouhnLst.size() > 0) {
            HT_MosSyouhn mosSyouhn = mosSyouhnLst.get(0);
            BM_SyouhnZokusei syouhnZokusei =
                bizDomManager.getSyouhnZokusei(mosSyouhn.getSyouhncd(), mosSyouhn.getSyouhnsdno());
            mosnaiCheckParam.setSyuSyouhnZokusei(syouhnZokusei);
        }
        List<HT_HubiMsg> hubiMsgLst = syoriCTL.getHubiMsgs();
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setListHubiMsg(hubiMsgLst);
        mosnaiCheckParam.setSysKbn(C_SysKbn.SKEI);
        mosnaiCheckParam.setSakuinTsnKbn(C_SakuintsnKbn.SEIJYOU);
        mosnaiCheckParam.setKiteiCheckChannelCd(C_Channelcd.TIGIN);
        checkTuusan.exec(mosnaiCheckParam, tuusan);
        exNumericEquals(hubiMsgLst.size(), 1, "不備メッセージテーブルエンティティリストの件数");
        exStringEquals(hubiMsgLst.get(0).getMosno(), "860000280", "申込番号");
        exNumericEquals(hubiMsgLst.get(0).getRenno(), 1, "連番");
        exStringEquals(hubiMsgLst.get(0).getHubimsg(), "【特認可能】通算総死亡Ｓ限度額の１０５円をオーバーしています。　一時払保険料は６２４円までにしてください。",
            "不備メッセージ");
        exStringEquals(hubiMsgLst.get(0).getMessageId(), "THC1043", "メッセージＩＤ");
        exClassificationEquals(hubiMsgLst.get(0).getHubisyubetukbn(), C_HubisyubetuKbn.KETHORYU_HUBI, "不備種別区分");

        exClassificationEquals(mosnaiCheckParam.getSakuinTsnKbn(), C_SakuintsnKbn.ERROR, "索引通算区分");

    }

    @Test
    @TestOrder(1210)
    public void testExec_A121() {
        KeisanGaikakanzanMockForSinkeiyaku.SYORIPTN = null;
        TuusanMockForSinkeiyaku.SYORIPTN = TuusanMockForSinkeiyaku.TESTPATTERN12;
        CheckSaiteiPMockForSinkeiyaku.SYORIPTN = CheckSaiteiPMockForSinkeiyaku.TESTPATTERN23;
        KeisanSPMockForSinkeiyaku.SYORIPTN = KeisanSPMockForSinkeiyaku.TESTPATTERN2;
        GetKiteiCheckYenkansangkMockForSinkeiyaku.SYORIPTN = GetKiteiCheckYenkansangkMockForSinkeiyaku.TESTPATTERN7;
        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("860000280");
        List<HT_MosSyouhn> mosSyouhnLst = syoriCTL.getMosSyouhnsBySyutkkbn(C_SyutkKbn.SYU);
        Tuusan tuusan = SWAKInjector.getInstance(Tuusan.class);
        if (mosSyouhnLst.size() > 0) {
            HT_MosSyouhn mosSyouhn = mosSyouhnLst.get(0);
            BM_SyouhnZokusei syouhnZokusei =
                bizDomManager.getSyouhnZokusei(mosSyouhn.getSyouhncd(), mosSyouhn.getSyouhnsdno());
            mosnaiCheckParam.setSyuSyouhnZokusei(syouhnZokusei);
        }
        List<HT_HubiMsg> hubiMsgLst = syoriCTL.getHubiMsgs();
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setListHubiMsg(hubiMsgLst);
        mosnaiCheckParam.setSysKbn(C_SysKbn.SKEI);
        mosnaiCheckParam.setSakuinTsnKbn(C_SakuintsnKbn.SEIJYOU);
        mosnaiCheckParam.setKiteiCheckChannelCd(C_Channelcd.TIGIN);
        checkTuusan.exec(mosnaiCheckParam, tuusan);
        exNumericEquals(hubiMsgLst.size(), 1, "不備メッセージテーブルエンティティリストの件数");
        exStringEquals(hubiMsgLst.get(0).getMosno(), "860000280", "申込番号");
        exNumericEquals(hubiMsgLst.get(0).getRenno(), 1, "連番");
        exStringEquals(hubiMsgLst.get(0).getHubimsg(), "【特認可能】通算総死亡Ｓ限度額の１０５円をオーバーしています。　一時払保険料は６２４円までにしてください。",
            "不備メッセージ");
        exStringEquals(hubiMsgLst.get(0).getMessageId(), "THC1043", "メッセージＩＤ");
        exClassificationEquals(hubiMsgLst.get(0).getHubisyubetukbn(), C_HubisyubetuKbn.KETHORYU_HUBI, "不備種別区分");

        exClassificationEquals(mosnaiCheckParam.getSakuinTsnKbn(), C_SakuintsnKbn.ERROR, "索引通算区分");

    }

    @Test
    @TestOrder(1220)
    public void testExec_A122() {
        KeisanSPMockForSinkeiyaku.SYORIPTN = KeisanSPMockForSinkeiyaku.TESTPATTERN4;
        KeisanGaikakanzanMockForSinkeiyaku.SYORIPTN = null;
        GetKiteiCheckYenkansangkMockForSinkeiyaku.SYORIPTN = GetKiteiCheckYenkansangkMockForSinkeiyaku.TESTPATTERN18;
        TuusanMockForSinkeiyaku.SYORIPTN = TuusanMockForSinkeiyaku.TESTPATTERN13;
        CheckSaiteiPMockForSinkeiyaku.SYORIPTN = CheckSaiteiPMockForSinkeiyaku.TESTPATTERN19;
        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("860000298");
        List<HT_MosSyouhn> mosSyouhnLst = syoriCTL.getMosSyouhnsBySyutkkbn(C_SyutkKbn.SYU);
        Tuusan tuusan = SWAKInjector.getInstance(Tuusan.class);
        if (mosSyouhnLst.size() > 0) {
            HT_MosSyouhn mosSyouhn = mosSyouhnLst.get(0);
            BM_SyouhnZokusei syouhnZokusei =
                bizDomManager.getSyouhnZokusei(mosSyouhn.getSyouhncd(), mosSyouhn.getSyouhnsdno());
            mosnaiCheckParam.setSyuSyouhnZokusei(syouhnZokusei);
        }
        List<HT_HubiMsg> hubiMsgLst = syoriCTL.getHubiMsgs();
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setListHubiMsg(hubiMsgLst);
        mosnaiCheckParam.setSysKbn(C_SysKbn.SKEI);
        mosnaiCheckParam.setSakuinTsnKbn(C_SakuintsnKbn.SEIJYOU);
        mosnaiCheckParam.setKiteiCheckChannelCd(C_Channelcd.TIGIN);
        checkTuusan.exec(mosnaiCheckParam, tuusan);
        exNumericEquals(hubiMsgLst.size(), 1, "不備メッセージテーブルエンティティリストの件数");
        exStringEquals(hubiMsgLst.get(0).getMosno(), "860000298", "申込番号");
        exNumericEquals(hubiMsgLst.get(0).getRenno(), 1, "連番");
        exStringEquals(hubiMsgLst.get(0).getHubimsg(), "【特認可能】年金原資限度額の１００円をオーバーしています。　保険料は６９円までにしてください。", "不備メッセージ");
        exStringEquals(hubiMsgLst.get(0).getMessageId(), "THC1064", "メッセージＩＤ");
        exClassificationEquals(hubiMsgLst.get(0).getHubisyubetukbn(), C_HubisyubetuKbn.KETHORYU_HUBI, "不備種別区分");

        exClassificationEquals(mosnaiCheckParam.getSakuinTsnKbn(), C_SakuintsnKbn.ERROR, "索引通算区分");

    }

    @Test
    @TestOrder(1230)
    public void testExec_A123() {
        KeisanSPMockForSinkeiyaku.SYORIPTN = KeisanSPMockForSinkeiyaku.TESTPATTERN4;
        KeisanGaikakanzanMockForSinkeiyaku.SYORIPTN = null;
        GetKiteiCheckYenkansangkMockForSinkeiyaku.SYORIPTN = GetKiteiCheckYenkansangkMockForSinkeiyaku.TESTPATTERN18;
        TuusanMockForSinkeiyaku.SYORIPTN = TuusanMockForSinkeiyaku.TESTPATTERN13;
        CheckSaiteiPMockForSinkeiyaku.SYORIPTN = CheckSaiteiPMockForSinkeiyaku.TESTPATTERN20;
        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("860000298");
        List<HT_MosSyouhn> mosSyouhnLst = syoriCTL.getMosSyouhnsBySyutkkbn(C_SyutkKbn.SYU);
        Tuusan tuusan = SWAKInjector.getInstance(Tuusan.class);
        if (mosSyouhnLst.size() > 0) {
            HT_MosSyouhn mosSyouhn = mosSyouhnLst.get(0);
            BM_SyouhnZokusei syouhnZokusei =
                bizDomManager.getSyouhnZokusei(mosSyouhn.getSyouhncd(), mosSyouhn.getSyouhnsdno());
            mosnaiCheckParam.setSyuSyouhnZokusei(syouhnZokusei);
        }
        List<HT_HubiMsg> hubiMsgLst = syoriCTL.getHubiMsgs();
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setListHubiMsg(hubiMsgLst);
        mosnaiCheckParam.setSysKbn(C_SysKbn.ESHIEN);
        mosnaiCheckParam.setSakuinTsnKbn(C_SakuintsnKbn.SEIJYOU);
        mosnaiCheckParam.setKiteiCheckChannelCd(C_Channelcd.TIGIN);

        checkTuusan.exec(mosnaiCheckParam, tuusan);
        exNumericEquals(hubiMsgLst.size(), 0, "不備メッセージテーブルエンティティリストの件数");
        exClassificationEquals(mosnaiCheckParam.getSekmossakuseiErroutKbn(), C_SekmossakuseiErroutKbn.GAMEN,
            "設計書申込書作成エラー出力区分 ");
        exStringEquals(mosnaiCheckParam.getSekmossakuseiErrmsg1(), "通算年金原資額が限度額を超えています", "設計書申込書作成エラーメッセージ１");
        exStringEquals(mosnaiCheckParam.getSekmossakuseiErrmsg2(), "保険料は６９円までにしてください", "設計書申込書作成エラーメッセージ２");
        exClassificationEquals(mosnaiCheckParam.getKouzokuSyoriJikkouKbn(), C_KouzokujkKbn.NONE, "後続処理実行区分");
        exClassificationEquals(mosnaiCheckParam.getSakuinTsnKbn(), C_SakuintsnKbn.ERROR, "索引通算区分");

    }

    @Test
    @TestOrder(1240)
    public void testExec_A124() {
        KeisanSPMockForSinkeiyaku.SYORIPTN = KeisanSPMockForSinkeiyaku.TESTPATTERN4;
        KeisanGaikakanzanMockForSinkeiyaku.SYORIPTN = null;
        GetKiteiCheckYenkansangkMockForSinkeiyaku.SYORIPTN = GetKiteiCheckYenkansangkMockForSinkeiyaku.TESTPATTERN18;
        TuusanMockForSinkeiyaku.SYORIPTN = TuusanMockForSinkeiyaku.TESTPATTERN13;
        CheckSaiteiPMockForSinkeiyaku.SYORIPTN = CheckSaiteiPMockForSinkeiyaku.TESTPATTERN21;
        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("860000298");
        List<HT_MosSyouhn> mosSyouhnLst = syoriCTL.getMosSyouhnsBySyutkkbn(C_SyutkKbn.SYU);
        Tuusan tuusan = SWAKInjector.getInstance(Tuusan.class);
        if (mosSyouhnLst.size() > 0) {
            HT_MosSyouhn mosSyouhn = mosSyouhnLst.get(0);
            BM_SyouhnZokusei syouhnZokusei =
                bizDomManager.getSyouhnZokusei(mosSyouhn.getSyouhncd(), mosSyouhn.getSyouhnsdno());
            mosnaiCheckParam.setSyuSyouhnZokusei(syouhnZokusei);
        }
        List<HT_HubiMsg> hubiMsgLst = syoriCTL.getHubiMsgs();
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setListHubiMsg(hubiMsgLst);
        mosnaiCheckParam.setSysKbn(C_SysKbn.SKEI);
        mosnaiCheckParam.setSakuinTsnKbn(C_SakuintsnKbn.SEIJYOU);
        mosnaiCheckParam.setKiteiCheckChannelCd(C_Channelcd.TIGIN);

        checkTuusan.exec(mosnaiCheckParam, tuusan);
        exNumericEquals(hubiMsgLst.size(), 1, "不備メッセージテーブルエンティティリストの件数");
        exStringEquals(hubiMsgLst.get(0).getMosno(), "860000298", "申込番号");
        exNumericEquals(hubiMsgLst.get(0).getRenno(), 1, "連番");
        exStringEquals(hubiMsgLst.get(0).getHubimsg(), "【特認可能】年金原資限度額の１００円をオーバーしています。　ご加入できません。", "不備メッセージ");
        exStringEquals(hubiMsgLst.get(0).getMessageId(), "THC1063", "メッセージＩＤ");
        exClassificationEquals(hubiMsgLst.get(0).getHubisyubetukbn(), C_HubisyubetuKbn.KETHORYU_HUBI, "不備種別区分");
        exClassificationEquals(mosnaiCheckParam.getSakuinTsnKbn(), C_SakuintsnKbn.ERROR, "索引通算区分");

    }

    @Test
    @TestOrder(1250)
    public void testExec_A125() {
        KeisanSPMockForSinkeiyaku.SYORIPTN = KeisanSPMockForSinkeiyaku.TESTPATTERN4;
        KeisanGaikakanzanMockForSinkeiyaku.SYORIPTN = null;
        GetKiteiCheckYenkansangkMockForSinkeiyaku.SYORIPTN = GetKiteiCheckYenkansangkMockForSinkeiyaku.TESTPATTERN18;
        TuusanMockForSinkeiyaku.SYORIPTN = TuusanMockForSinkeiyaku.TESTPATTERN13;
        CheckSaiteiPMockForSinkeiyaku.SYORIPTN = CheckSaiteiPMockForSinkeiyaku.TESTPATTERN17;
        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("860000298");
        List<HT_MosSyouhn> mosSyouhnLst = syoriCTL.getMosSyouhnsBySyutkkbn(C_SyutkKbn.SYU);

        syoriCTL.getMosSyouhnsBySyutkkbn(C_SyutkKbn.SYU).get(0).setHrkkknsmnkbn(null);

        Tuusan tuusan = SWAKInjector.getInstance(Tuusan.class);
        if (mosSyouhnLst.size() > 0) {
            HT_MosSyouhn mosSyouhn = mosSyouhnLst.get(0);
            BM_SyouhnZokusei syouhnZokusei =
                bizDomManager.getSyouhnZokusei(mosSyouhn.getSyouhncd(), mosSyouhn.getSyouhnsdno());
            mosnaiCheckParam.setSyuSyouhnZokusei(syouhnZokusei);
        }
        List<HT_HubiMsg> hubiMsgLst = syoriCTL.getHubiMsgs();
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setListHubiMsg(hubiMsgLst);
        mosnaiCheckParam.setSysKbn(C_SysKbn.ESHIEN);
        mosnaiCheckParam.setSakuinTsnKbn(C_SakuintsnKbn.SEIJYOU);
        mosnaiCheckParam.setKiteiCheckChannelCd(C_Channelcd.TIGIN);

        checkTuusan.exec(mosnaiCheckParam, tuusan);
        exNumericEquals(hubiMsgLst.size(), 0, "不備メッセージテーブルエンティティリストの件数");
        exClassificationEquals(mosnaiCheckParam.getSekmossakuseiErroutKbn(), C_SekmossakuseiErroutKbn.GAMEN,
            "設計書申込書作成エラー出力区分 ");
        exStringEquals(mosnaiCheckParam.getSekmossakuseiErrmsg1(), "", "設計書申込書作成エラーメッセージ１");
        exStringEquals(mosnaiCheckParam.getSekmossakuseiErrmsg2(), "通算年金原資額が限度額を超えています　ご加入できません", "設計書申込書作成エラーメッセージ２");
        exClassificationEquals(mosnaiCheckParam.getKouzokuSyoriJikkouKbn(), C_KouzokujkKbn.NONE, "後続処理実行区分");
        exClassificationEquals(mosnaiCheckParam.getSakuinTsnKbn(), C_SakuintsnKbn.ERROR, "索引通算区分");

    }

    @Test
    @TestOrder(1260)
    public void testExec_A126() {
        KeisanSPMockForSinkeiyaku.SYORIPTN = KeisanSPMockForSinkeiyaku.TESTPATTERN4;
        KeisanGaikakanzanMockForSinkeiyaku.SYORIPTN = null;
        GetKiteiCheckYenkansangkMockForSinkeiyaku.SYORIPTN = GetKiteiCheckYenkansangkMockForSinkeiyaku.TESTPATTERN18;
        TuusanMockForSinkeiyaku.SYORIPTN = TuusanMockForSinkeiyaku.TESTPATTERN13;
        CheckSaiteiPMockForSinkeiyaku.SYORIPTN = CheckSaiteiPMockForSinkeiyaku.TESTPATTERN17;
        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("790000186");
        List<HT_MosSyouhn> mosSyouhnLst = syoriCTL.getMosSyouhnsBySyutkkbn(C_SyutkKbn.SYU);
        Tuusan tuusan = SWAKInjector.getInstance(Tuusan.class);
        if (mosSyouhnLst.size() > 0) {
            HT_MosSyouhn mosSyouhn = mosSyouhnLst.get(0);
            BM_SyouhnZokusei syouhnZokusei =
                bizDomManager.getSyouhnZokusei(mosSyouhn.getSyouhncd(), mosSyouhn.getSyouhnsdno());
            mosnaiCheckParam.setSyuSyouhnZokusei(syouhnZokusei);
        }
        List<HT_HubiMsg> hubiMsgLst = syoriCTL.getHubiMsgs();
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setListHubiMsg(hubiMsgLst);
        mosnaiCheckParam.setSysKbn(C_SysKbn.SKEI);
        mosnaiCheckParam.setSakuinTsnKbn(C_SakuintsnKbn.SEIJYOU);
        mosnaiCheckParam.setKiteiCheckChannelCd(C_Channelcd.TIGIN);

        checkTuusan.exec(mosnaiCheckParam, tuusan);
        exNumericEquals(hubiMsgLst.size(), 1, "不備メッセージテーブルエンティティリストの件数");
        exStringEquals(hubiMsgLst.get(0).getMosno(), "790000186", "申込番号");
        exNumericEquals(hubiMsgLst.get(0).getRenno(), 1, "連番");
        exStringEquals(hubiMsgLst.get(0).getHubimsg(), "【特認可能】年金原資限度額の１００円をオーバーしています。　一時払保険料は８０円までにしてください。", "不備メッセージ");
        exStringEquals(hubiMsgLst.get(0).getMessageId(), "THC1064", "メッセージＩＤ");
        exClassificationEquals(hubiMsgLst.get(0).getHubisyubetukbn(), C_HubisyubetuKbn.KETHORYU_HUBI, "不備種別区分");
        exClassificationEquals(mosnaiCheckParam.getSakuinTsnKbn(), C_SakuintsnKbn.ERROR, "索引通算区分");
    }

    @Test
    @TestOrder(1270)
    public void testExec_A127() {
        KeisanSPMockForSinkeiyaku.SYORIPTN = KeisanSPMockForSinkeiyaku.TESTPATTERN4;
        KeisanGaikakanzanMockForSinkeiyaku.SYORIPTN = null;
        GetKiteiCheckYenkansangkMockForSinkeiyaku.SYORIPTN = GetKiteiCheckYenkansangkMockForSinkeiyaku.TESTPATTERN18;
        TuusanMockForSinkeiyaku.SYORIPTN = TuusanMockForSinkeiyaku.TESTPATTERN13;
        CheckSaiteiPMockForSinkeiyaku.SYORIPTN = CheckSaiteiPMockForSinkeiyaku.TESTPATTERN17;
        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("790000194");
        List<HT_MosSyouhn> mosSyouhnLst = syoriCTL.getMosSyouhnsBySyutkkbn(C_SyutkKbn.SYU);
        Tuusan tuusan = SWAKInjector.getInstance(Tuusan.class);
        if (mosSyouhnLst.size() > 0) {
            HT_MosSyouhn mosSyouhn = mosSyouhnLst.get(0);
            BM_SyouhnZokusei syouhnZokusei =
                bizDomManager.getSyouhnZokusei(mosSyouhn.getSyouhncd(), mosSyouhn.getSyouhnsdno());
            mosnaiCheckParam.setSyuSyouhnZokusei(syouhnZokusei);
        }
        List<HT_HubiMsg> hubiMsgLst = syoriCTL.getHubiMsgs();
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setListHubiMsg(hubiMsgLst);
        mosnaiCheckParam.setSysKbn(C_SysKbn.SKEI);
        mosnaiCheckParam.setSakuinTsnKbn(C_SakuintsnKbn.SEIJYOU);
        mosnaiCheckParam.setKiteiCheckChannelCd(C_Channelcd.TIGIN);

        checkTuusan.exec(mosnaiCheckParam, tuusan);
        exNumericEquals(hubiMsgLst.size(), 1, "不備メッセージテーブルエンティティリストの件数");
        exStringEquals(hubiMsgLst.get(0).getMosno(), "790000194", "申込番号");
        exNumericEquals(hubiMsgLst.get(0).getRenno(), 1, "連番");
        exStringEquals(hubiMsgLst.get(0).getHubimsg(), "【特認可能】年金原資限度額の１００円をオーバーしています。　ご加入できません。", "不備メッセージ");
        exStringEquals(hubiMsgLst.get(0).getMessageId(), "THC1063", "メッセージＩＤ");
        exClassificationEquals(hubiMsgLst.get(0).getHubisyubetukbn(), C_HubisyubetuKbn.KETHORYU_HUBI, "不備種別区分");
        exClassificationEquals(mosnaiCheckParam.getSakuinTsnKbn(), C_SakuintsnKbn.ERROR, "索引通算区分");
    }

    @Test
    @TestOrder(1280)
    public void testExec_A128() {
        KeisanSPMockForSinkeiyaku.SYORIPTN = KeisanSPMockForSinkeiyaku.TESTPATTERN4;
        KeisanGaikakanzanMockForSinkeiyaku.SYORIPTN = null;
        GetKiteiCheckYenkansangkMockForSinkeiyaku.SYORIPTN = GetKiteiCheckYenkansangkMockForSinkeiyaku.TESTPATTERN18;
        TuusanMockForSinkeiyaku.SYORIPTN = TuusanMockForSinkeiyaku.TESTPATTERN67;
        CheckSaiteiPMockForSinkeiyaku.SYORIPTN = CheckSaiteiPMockForSinkeiyaku.TESTPATTERN17;
        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("790000202");
        List<HT_MosSyouhn> mosSyouhnLst = syoriCTL.getMosSyouhnsBySyutkkbn(C_SyutkKbn.SYU);
        Tuusan tuusan = SWAKInjector.getInstance(Tuusan.class);
        if (mosSyouhnLst.size() > 0) {
            HT_MosSyouhn mosSyouhn = mosSyouhnLst.get(0);
            BM_SyouhnZokusei syouhnZokusei =
                bizDomManager.getSyouhnZokusei(mosSyouhn.getSyouhncd(), mosSyouhn.getSyouhnsdno());
            mosnaiCheckParam.setSyuSyouhnZokusei(syouhnZokusei);
        }
        List<HT_HubiMsg> hubiMsgLst = syoriCTL.getHubiMsgs();
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setListHubiMsg(hubiMsgLst);
        mosnaiCheckParam.setSysKbn(C_SysKbn.SKEI);
        mosnaiCheckParam.setSakuinTsnKbn(C_SakuintsnKbn.SEIJYOU);
        mosnaiCheckParam.setKiteiCheckChannelCd(C_Channelcd.TIGIN);

        checkTuusan.exec(mosnaiCheckParam, tuusan);

        exNumericEquals(hubiMsgLst.size(), 1, "不備メッセージテーブルエンティティリストの件数");
        exStringEquals(hubiMsgLst.get(0).getMosno(), "790000202", "申込番号");
        exNumericEquals(hubiMsgLst.get(0).getRenno(), 1, "連番");
        exStringEquals(hubiMsgLst.get(0).getHubimsg(), "【特認可能】年金原資限度額の１００円をオーバーしています。　一時払保険料は８０円までにしてください。", "不備メッセージ");
        exStringEquals(hubiMsgLst.get(0).getMessageId(), "THC1064", "メッセージＩＤ");
        exClassificationEquals(hubiMsgLst.get(0).getHubisyubetukbn(), C_HubisyubetuKbn.KETHORYU_HUBI, "不備種別区分");
        exClassificationEquals(mosnaiCheckParam.getSakuinTsnKbn(), C_SakuintsnKbn.ERROR, "索引通算区分");

    }


    @Test
    @TestOrder(1290)
    public void testGndHaninaiPbyItjbrSouhrkp_A1() {
        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("791112378");
        HT_MosKihon mosKihon = syoriCTL.getMosKihon();
        HT_MosSyouhn mosSyouhn = null;
        BizCurrency haseiSyupHrk = checkTuusan.getGndHaninaiPbyItjbrSouhrkp(
            syoriCTL, mosKihon, mosSyouhn, null, BizCurrency.valueOf(2000), C_UmuKbn.NONE, C_PtratkituukasiteiKbn.HRKTUUKA);

        exBizCalcbleEquals(haseiSyupHrk, BizCurrency.valueOf(2000), "補正用主契約Ｐ（払込通貨）");

    }
}
