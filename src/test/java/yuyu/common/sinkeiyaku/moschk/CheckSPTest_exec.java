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
import yuyu.common.biz.exception.CommonBizAppException;
import yuyu.def.biz.manager.BizDomManager;
import yuyu.def.classification.C_BosyuusysctrlKbn;
import yuyu.def.classification.C_Channelcd;
import yuyu.def.classification.C_HubisyubetuKbn;
import yuyu.def.classification.C_KouzokujkKbn;
import yuyu.def.classification.C_SekmossakuseiErroutKbn;
import yuyu.def.classification.C_SysKbn;
import yuyu.def.classification.C_SyutkKbn;
import yuyu.def.classification.C_Tuukasyu;
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
 * SPチェッククラスのメソッド {@link CheckSP#exec(MosnaiCheckParam)} テスト用クラスです。<br />
 */

@RunWith(OrderedRunner.class)
public class CheckSPTest_exec {

    @Inject
    private MosnaiCheckParam mosnaiCheckParam;

    @Inject
    private SinkeiyakuDomManager sinkeiyakuDomManager;

    @Inject
    private BizDomManager bizDomManager;

    private final static String fileName = "UT-SP_単体テスト仕様書（共通）_SPチェック";

    private final static String sheetName = "INデータ";

    @Before
    public void before(){
        MockModuleBinder.bind(new AbstractModule(){
            @Override
            protected void configure() {
                bind(CheckSaiteiP.class).to(CheckSaiteiPMockForSinkeiyaku.class);
                bind(yuyu.common.hozen.khcommon.KeisanSP.class).to(yuyu.common.hozen.khcommon.KeisanSPMockForSinkeiyaku.class);
                bind(KeisanGaikakanzan.class).to(KeisanGaikakanzanMockForSinkeiyaku.class);
                bind(HanteiMoschk.class).to(HanteiMoschkMockForSinkeiyaku.class);
                bind(CheckTuusan.class).to(CheckTuusanMockForSinkeiyaku.class);
            }
        });
    }

    @BeforeClass
    public static void testInit() {
        CheckSaiteiPMockForSinkeiyaku.caller = CheckSPTest_exec.class;
        yuyu.common.hozen.khcommon.KeisanSPMockForSinkeiyaku.caller = CheckSPTest_exec.class;
        KeisanGaikakanzanMockForSinkeiyaku.caller = CheckSPTest_exec.class;
        HanteiMoschkMockForSinkeiyaku.caller = CheckSPTest_exec.class;

        CheckTuusanMockForSinkeiyaku.caller = CheckSPTest_exec.class;

        CheckSaiteiPMockForSinkeiyaku.SYORIPTN = null;
        yuyu.common.hozen.khcommon.KeisanSPMockForSinkeiyaku.SYORIPTN = null;
        KeisanGaikakanzanMockForSinkeiyaku.SYORIPTN = null;
        HanteiMoschkMockForSinkeiyaku.SYORIPTN = null;
        CheckTuusanMockForSinkeiyaku.SYORIPTN = null;
    }

    @AfterClass
    public static void testClear() {
        MockObjectManager.initialize();
        CheckSaiteiPMockForSinkeiyaku.caller = null;
        CheckSaiteiPMockForSinkeiyaku.SYORIPTN = null;
        yuyu.common.hozen.khcommon.KeisanSPMockForSinkeiyaku.caller = null;
        yuyu.common.hozen.khcommon.KeisanSPMockForSinkeiyaku.SYORIPTN = null;
        KeisanGaikakanzanMockForSinkeiyaku.caller = null;
        KeisanGaikakanzanMockForSinkeiyaku.SYORIPTN = null;
        HanteiMoschkMockForSinkeiyaku.caller = null;
        HanteiMoschkMockForSinkeiyaku.SYORIPTN = null;
        CheckTuusanMockForSinkeiyaku.caller = null;
        CheckTuusanMockForSinkeiyaku.SYORIPTN = null;
    }

    @BeforeClass
    @Transactional
    public static void insertTestData() {
        try {
            TestDataMaker testDataMaker = new TestDataMaker();
            HashMap<String, Map<String, List<Map<String, String>>>> testDataAndTblMap;
            testDataAndTblMap = testDataMaker.getInData(CheckSPTest_exec.class, fileName, sheetName);
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
        bizDomManager.delete(bizDomManager.getAllChkSaiteiP());
        bizDomManager.delete(bizDomManager.getAllChkJhSaiteiS());
        bizDomManager.delete(bizDomManager.getAllChkHrkPTani());
    }

    @Test(expected = CommonBizAppException.class)
    @Transactional
    @TestOrder(10)
    public void testExec_A1() {
        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("791112238");
        BM_SyouhnZokusei syuSyouhnZokusei = null;
        List<BM_SyouhnZokusei> syouhnZokuseiList = null;

        mosnaiCheckParam.setSyuSyouhnZokusei(syuSyouhnZokusei);
        mosnaiCheckParam.setListTkSyouhnZokusei(syouhnZokuseiList);
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setKosID("user001");
        mosnaiCheckParam.setKosTime("20160831011400000");
        mosnaiCheckParam.setSysKbn(C_SysKbn.SKEI);

        try {
            CheckSP checkSP = SWAKInjector.getInstance(CheckSP.class);
            checkSP.exec(mosnaiCheckParam);
        } catch (CommonBizAppException e) {
            exStringEquals(e.getMessage(), "システム整合性エラーです。申込番号 = 791112238", "エラーメッセージ");
            throw e;
        }
    }

    @Test(expected = CommonBizAppException.class)
    @Transactional
    @TestOrder(20)
    public void testExec_A2() {
        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("791112295");
        List<HT_MosSyouhn> syuMosSyouhnLst = syoriCTL.getMosSyouhnsBySyutkkbn(C_SyutkKbn.SYU);
        HT_MosSyouhn syuSyouhnnm = syuMosSyouhnLst.get(0);
        BM_SyouhnZokusei syuSyouhnZokusei = bizDomManager.getSyouhnZokusei(syuSyouhnnm.getSyouhncd(), syuSyouhnnm.getSyouhnsdno());
        List<BM_SyouhnZokusei> syouhnZokuseiList = new ArrayList<>();
        syouhnZokuseiList.add(syuSyouhnZokusei);

        mosnaiCheckParam.setSyuSyouhnZokusei(syuSyouhnZokusei);
        mosnaiCheckParam.setListTkSyouhnZokusei(syouhnZokuseiList);
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setKosID("user001");
        mosnaiCheckParam.setKosTime("20160831011400000");
        mosnaiCheckParam.setSysKbn(C_SysKbn.SKEI);

        try {
            CheckSP checkSP = SWAKInjector.getInstance(CheckSP.class);
            checkSP.exec(mosnaiCheckParam);
        } catch (CommonBizAppException e) {
            exStringEquals(e.getMessage(), "システム整合性エラーです。主契約申込商品件数異常 申込番号：791112295", "エラーメッセージ");
            throw e;
        }
    }

    @Test
    @Transactional
    @TestOrder(30)
    public void testExec_A3_1() {

        MockObjectManager.initialize();
        CheckSaiteiPMockForSinkeiyaku.SYORIPTN = CheckSaiteiPMockForSinkeiyaku.TESTPATTERN1;
        HanteiMoschkMockForSinkeiyaku.SYORIPTN = HanteiMoschkMockForSinkeiyaku.TESTPATTERN1;
        CheckTuusanMockForSinkeiyaku.SYORIPTN = CheckTuusanMockForSinkeiyaku.TESTPATTERN2;

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("791112303");

        List<HT_HubiMsg> hubiMsg = syoriCTL.getHubiMsgs();
        List<HT_MosSyouhn> syuMosSyouhnLst = syoriCTL.getMosSyouhnsBySyutkkbn(C_SyutkKbn.SYU);
        HT_MosSyouhn syuSyouhnnm = syuMosSyouhnLst.get(0);
        BM_SyouhnZokusei syuSyouhnZokusei = bizDomManager.getSyouhnZokusei(syuSyouhnnm.getSyouhncd(), syuSyouhnnm.getSyouhnsdno());
        List<BM_SyouhnZokusei> syouhnZokuseiList = new ArrayList<>();
        syouhnZokuseiList.add(syuSyouhnZokusei);

        mosnaiCheckParam.setSyuSyouhnZokusei(syuSyouhnZokusei);
        mosnaiCheckParam.setListTkSyouhnZokusei(syouhnZokuseiList);
        mosnaiCheckParam.setListHubiMsg(hubiMsg);
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setKosID("user001");
        mosnaiCheckParam.setKosTime("20160831011400000");
        mosnaiCheckParam.setSysKbn(C_SysKbn.SKEI);
        CheckSP checkSP = SWAKInjector.getInstance(CheckSP.class);
        checkSP.exec(mosnaiCheckParam);

        List<HT_HubiMsg> hubiMsgLst = mosnaiCheckParam.getListHubiMsg();
        exNumericEquals(hubiMsgLst.size(), 0, "不備メッセージテーブルエンティティリスト件数");

        MosnaiCheckParam mosnaiCheckParamtemp = (MosnaiCheckParam) MockObjectManager.getArgument(
            CheckSaiteiPMockForSinkeiyaku.class, "exec", 0, 0);

        exStringEquals(mosnaiCheckParamtemp.getKosID(), "user001", "更新者ＩＤ");
        exStringEquals(mosnaiCheckParamtemp.getKosTime(), "20160831011400000", "更新時間");
        exClassificationEquals(mosnaiCheckParamtemp.getSysKbn(), C_SysKbn.SKEI, "システム区分");

        HT_MosSyouhn mosSyouhn = (HT_MosSyouhn) MockObjectManager.getArgument(CheckSaiteiPMockForSinkeiyaku.class, "exec", 0, 1);

        exStringEquals(mosSyouhn.getMosno(), "791112303", "申込番号");
        exStringEquals(mosSyouhn.getSyouhncd(), "ｲ1", "商品コード");

        BM_SyouhnZokusei syouhnZokusei = (BM_SyouhnZokusei) MockObjectManager.getArgument(CheckSaiteiPMockForSinkeiyaku.class,
            "exec", 0, 2);

        exStringEquals(syouhnZokusei.getSyouhncd(), "ｲ1", "商品コード");
        exNumericEquals(syouhnZokusei.getSyouhnsdno(), 1, "商品世代番号");

        exBizCalcbleEquals((BizCurrency) MockObjectManager.getArgument(CheckSaiteiPMockForSinkeiyaku.class, "exec", 0, 3),
            BizCurrency.valueOf(1000), "判定用保険料");

        exClassificationEquals((C_Tuukasyu) MockObjectManager.getArgument(CheckSaiteiPMockForSinkeiyaku.class, "exec", 0, 4),
            C_Tuukasyu.JPY, "通貨種類");

    }

    @Test
    @Transactional
    @TestOrder(40)
    public void testExec_A3_2() {
        MockObjectManager.initialize();
        CheckSaiteiPMockForSinkeiyaku.SYORIPTN = CheckSaiteiPMockForSinkeiyaku.TESTPATTERN1;
        HanteiMoschkMockForSinkeiyaku.SYORIPTN = HanteiMoschkMockForSinkeiyaku.TESTPATTERN1;
        CheckTuusanMockForSinkeiyaku.SYORIPTN = CheckTuusanMockForSinkeiyaku.TESTPATTERN2;

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("791112220");

        List<HT_HubiMsg> hubiMsg = syoriCTL.getHubiMsgs();
        List<HT_MosSyouhn> syuMosSyouhnLst = syoriCTL.getMosSyouhnsBySyutkkbn(C_SyutkKbn.SYU);
        HT_MosSyouhn syuSyouhnnm = syuMosSyouhnLst.get(0);
        BM_SyouhnZokusei syuSyouhnZokusei = bizDomManager.getSyouhnZokusei(syuSyouhnnm.getSyouhncd(), syuSyouhnnm.getSyouhnsdno());
        List<BM_SyouhnZokusei> syouhnZokuseiList = new ArrayList<>();
        syouhnZokuseiList.add(syuSyouhnZokusei);

        mosnaiCheckParam.setSyuSyouhnZokusei(syuSyouhnZokusei);
        mosnaiCheckParam.setListTkSyouhnZokusei(syouhnZokuseiList);
        mosnaiCheckParam.setListHubiMsg(hubiMsg);
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setKosID("user001");
        mosnaiCheckParam.setKosTime("20160831011400000");
        mosnaiCheckParam.setSysKbn(C_SysKbn.SKEI);
        CheckSP checkSP = SWAKInjector.getInstance(CheckSP.class);
        checkSP.exec(mosnaiCheckParam);

        List<HT_HubiMsg> hubiMsgLst = mosnaiCheckParam.getListHubiMsg();
        exNumericEquals(hubiMsgLst.size(), 0, "不備メッセージテーブルエンティティリスト件数");

    }

    @Test
    @Transactional
    @TestOrder(50)
    public void testExec_A3_3() {
        MockObjectManager.initialize();
        CheckSaiteiPMockForSinkeiyaku.SYORIPTN = CheckSaiteiPMockForSinkeiyaku.TESTPATTERN1;
        HanteiMoschkMockForSinkeiyaku.SYORIPTN = HanteiMoschkMockForSinkeiyaku.TESTPATTERN1;
        CheckTuusanMockForSinkeiyaku.SYORIPTN = CheckTuusanMockForSinkeiyaku.TESTPATTERN2;

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("791112246");

        List<HT_HubiMsg> hubiMsg = syoriCTL.getHubiMsgs();
        List<HT_MosSyouhn> syuMosSyouhnLst = syoriCTL.getMosSyouhnsBySyutkkbn(C_SyutkKbn.SYU);
        HT_MosSyouhn syuSyouhnnm = syuMosSyouhnLst.get(0);
        BM_SyouhnZokusei syuSyouhnZokusei = bizDomManager.getSyouhnZokusei(syuSyouhnnm.getSyouhncd(), syuSyouhnnm.getSyouhnsdno());
        List<BM_SyouhnZokusei> syouhnZokuseiList = new ArrayList<>();
        syouhnZokuseiList.add(syuSyouhnZokusei);

        mosnaiCheckParam.setSyuSyouhnZokusei(syuSyouhnZokusei);
        mosnaiCheckParam.setListTkSyouhnZokusei(syouhnZokuseiList);
        mosnaiCheckParam.setListHubiMsg(hubiMsg);
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setKosID("user001");
        mosnaiCheckParam.setKosTime("20160831011400000");
        mosnaiCheckParam.setSysKbn(C_SysKbn.SKEI);
        CheckSP checkSP = SWAKInjector.getInstance(CheckSP.class);
        checkSP.exec(mosnaiCheckParam);

        List<HT_HubiMsg> hubiMsgLst = mosnaiCheckParam.getListHubiMsg();
        exNumericEquals(hubiMsgLst.size(), 1, "不備メッセージテーブルエンティティリスト件数");
        exStringEquals(hubiMsgLst.get(0).getMosno(), "791112246", "申込番号");
        exNumericEquals(hubiMsgLst.get(0).getRenno(), 1, "連番");
        exStringEquals(hubiMsgLst.get(0).getMessageId(), "EHC0060", "メッセージＩＤ");
        exStringEquals(hubiMsgLst.get(0).getHubimsg(), "商品名１の保険料が相違しています。　正当保険料　１００円", "不備メッセージ");
        exClassificationEquals(hubiMsgLst.get(0).getHubisyubetukbn(), C_HubisyubetuKbn.KETHORYU_HUBI, "不備種別区分");

    }
    @Test
    @Transactional
    @TestOrder(51)
    public void testExec_A3_4() {
        MockObjectManager.initialize();
        CheckSaiteiPMockForSinkeiyaku.SYORIPTN = CheckSaiteiPMockForSinkeiyaku.TESTPATTERN2;
        HanteiMoschkMockForSinkeiyaku.SYORIPTN = HanteiMoschkMockForSinkeiyaku.TESTPATTERN5;
        CheckTuusanMockForSinkeiyaku.SYORIPTN = CheckTuusanMockForSinkeiyaku.TESTPATTERN2;

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("791112246");

        List<HT_HubiMsg> hubiMsg = syoriCTL.getHubiMsgs();
        List<HT_MosSyouhn> syuMosSyouhnLst = syoriCTL.getMosSyouhnsBySyutkkbn(C_SyutkKbn.SYU);
        HT_MosSyouhn syuSyouhnnm = syuMosSyouhnLst.get(0);
        BM_SyouhnZokusei syuSyouhnZokusei = bizDomManager.getSyouhnZokusei(syuSyouhnnm.getSyouhncd(), syuSyouhnnm.getSyouhnsdno());
        List<BM_SyouhnZokusei> syouhnZokuseiList = new ArrayList<>();
        syouhnZokuseiList.add(syuSyouhnZokusei);

        mosnaiCheckParam.setSyuSyouhnZokusei(syuSyouhnZokusei);
        mosnaiCheckParam.setListTkSyouhnZokusei(syouhnZokuseiList);
        mosnaiCheckParam.setListHubiMsg(hubiMsg);
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setKosID("user001");
        mosnaiCheckParam.setKosTime("20160831011400000");
        mosnaiCheckParam.setSysKbn(C_SysKbn.SKEI);
        CheckSP checkSP = SWAKInjector.getInstance(CheckSP.class);
        checkSP.exec(mosnaiCheckParam);

        exClassificationEquals(mosnaiCheckParam.getCheckspJissiUmuKbnSeijyou(), C_UmuKbn.ARI, "SPチェック実施済有無区分（正常終了）");

    }

    @Test
    @Transactional
    @TestOrder(51)
    public void testExec_A3_5() {
        MockObjectManager.initialize();
        CheckSaiteiPMockForSinkeiyaku.SYORIPTN = CheckSaiteiPMockForSinkeiyaku.TESTPATTERN1;
        HanteiMoschkMockForSinkeiyaku.SYORIPTN = HanteiMoschkMockForSinkeiyaku.TESTPATTERN5;
        CheckTuusanMockForSinkeiyaku.SYORIPTN = CheckTuusanMockForSinkeiyaku.TESTPATTERN2;

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("791112220");

        List<HT_HubiMsg> hubiMsg = syoriCTL.getHubiMsgs();
        List<HT_MosSyouhn> syuMosSyouhnLst = syoriCTL.getMosSyouhnsBySyutkkbn(C_SyutkKbn.SYU);
        HT_MosSyouhn syuSyouhnnm = syuMosSyouhnLst.get(0);
        BM_SyouhnZokusei syuSyouhnZokusei = bizDomManager.getSyouhnZokusei(syuSyouhnnm.getSyouhncd(), syuSyouhnnm.getSyouhnsdno());
        List<BM_SyouhnZokusei> syouhnZokuseiList = new ArrayList<>();
        syouhnZokuseiList.add(syuSyouhnZokusei);

        mosnaiCheckParam.setSyuSyouhnZokusei(syuSyouhnZokusei);
        mosnaiCheckParam.setListTkSyouhnZokusei(syouhnZokuseiList);
        mosnaiCheckParam.setListHubiMsg(hubiMsg);
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setKosID("user001");
        mosnaiCheckParam.setKosTime("20160831011400000");
        mosnaiCheckParam.setSysKbn(C_SysKbn.SKEI);
        CheckSP checkSP = SWAKInjector.getInstance(CheckSP.class);
        checkSP.exec(mosnaiCheckParam);

        exClassificationEquals(mosnaiCheckParam.getCheckspJissiUmuKbnSeijyou(), C_UmuKbn.NONE, "SPチェック実施済有無区分（正常終了）");

    }
    @Test
    @Transactional
    @TestOrder(52)
    public void testExec_A3_6() {

        MockObjectManager.initialize();
        CheckSaiteiPMockForSinkeiyaku.SYORIPTN = CheckSaiteiPMockForSinkeiyaku.TESTPATTERN1;
        HanteiMoschkMockForSinkeiyaku.SYORIPTN = HanteiMoschkMockForSinkeiyaku.TESTPATTERN6;
        CheckTuusanMockForSinkeiyaku.SYORIPTN = CheckTuusanMockForSinkeiyaku.TESTPATTERN2;

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("791112246");

        List<HT_HubiMsg> hubiMsg = syoriCTL.getHubiMsgs();
        List<HT_MosSyouhn> syuMosSyouhnLst = syoriCTL.getMosSyouhnsBySyutkkbn(C_SyutkKbn.SYU);
        HT_MosSyouhn syuSyouhnnm = syuMosSyouhnLst.get(0);
        BM_SyouhnZokusei syuSyouhnZokusei = bizDomManager.getSyouhnZokusei(syuSyouhnnm.getSyouhncd(), syuSyouhnnm.getSyouhnsdno());
        List<BM_SyouhnZokusei> syouhnZokuseiList = new ArrayList<>();
        syouhnZokuseiList.add(syuSyouhnZokusei);

        mosnaiCheckParam.setSyuSyouhnZokusei(syuSyouhnZokusei);
        mosnaiCheckParam.setListTkSyouhnZokusei(syouhnZokuseiList);
        mosnaiCheckParam.setListHubiMsg(hubiMsg);
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setKosID("user001");
        mosnaiCheckParam.setKosTime("20160831011400000");
        mosnaiCheckParam.setSysKbn(C_SysKbn.SKEI);
        CheckSP checkSP = SWAKInjector.getInstance(CheckSP.class);
        checkSP.exec(mosnaiCheckParam);

        exClassificationEquals(mosnaiCheckParam.getCheckspJissiUmuKbnSeijyou(), C_UmuKbn.ARI, "SPチェック実施済有無区分（正常終了）");

    }


    @Test
    @Transactional
    @TestOrder(53)
    public void testExec_A3_7() {
        MockObjectManager.initialize();
        CheckSaiteiPMockForSinkeiyaku.SYORIPTN = CheckSaiteiPMockForSinkeiyaku.TESTPATTERN1;
        HanteiMoschkMockForSinkeiyaku.SYORIPTN = HanteiMoschkMockForSinkeiyaku.TESTPATTERN1;
        CheckTuusanMockForSinkeiyaku.SYORIPTN = CheckTuusanMockForSinkeiyaku.TESTPATTERN2;

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("880000021");

        List<HT_HubiMsg> hubiMsg = syoriCTL.getHubiMsgs();
        List<HT_MosSyouhn> syuMosSyouhnLst = syoriCTL.getMosSyouhnsBySyutkkbn(C_SyutkKbn.SYU);
        HT_MosSyouhn syuSyouhnnm = syuMosSyouhnLst.get(0);
        BM_SyouhnZokusei syuSyouhnZokusei = bizDomManager.getSyouhnZokusei(syuSyouhnnm.getSyouhncd(), syuSyouhnnm.getSyouhnsdno());
        List<BM_SyouhnZokusei> syouhnZokuseiList = new ArrayList<>();
        syouhnZokuseiList.add(syuSyouhnZokusei);

        mosnaiCheckParam.setSyuSyouhnZokusei(syuSyouhnZokusei);
        mosnaiCheckParam.setListTkSyouhnZokusei(syouhnZokuseiList);
        mosnaiCheckParam.setListHubiMsg(hubiMsg);
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setKosID("user001");
        mosnaiCheckParam.setKosTime("20160831011400000");
        mosnaiCheckParam.setSysKbn(C_SysKbn.SKEI);
        CheckSP checkSP = SWAKInjector.getInstance(CheckSP.class);
        checkSP.exec(mosnaiCheckParam);

        List<HT_HubiMsg> hubiMsgLst = mosnaiCheckParam.getListHubiMsg();
        exNumericEquals(hubiMsgLst.size(), 1, "不備メッセージテーブルエンティティリスト件数");
        exStringEquals(hubiMsgLst.get(0).getMosno(), "880000021", "申込番号");
        exNumericEquals(hubiMsgLst.get(0).getRenno(), 1, "連番");
        exStringEquals(hubiMsgLst.get(0).getMessageId(), "EHC0060", "メッセージＩＤ");
        exStringEquals(hubiMsgLst.get(0).getHubimsg(), "商品名２の保険料が相違しています。　正当保険料　１０１円", "不備メッセージ");
        exClassificationEquals(hubiMsgLst.get(0).getHubisyubetukbn(), C_HubisyubetuKbn.KETHORYU_HUBI, "不備種別区分");

    }

    @Test(expected = CommonBizAppException.class)
    @Transactional
    @TestOrder(60)
    public void testExec_A4_1() {
        MockObjectManager.initialize();
        HanteiMoschkMockForSinkeiyaku.SYORIPTN = HanteiMoschkMockForSinkeiyaku.TESTPATTERN1;
        CheckTuusanMockForSinkeiyaku.SYORIPTN = CheckTuusanMockForSinkeiyaku.TESTPATTERN2;

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("791112253");
        List<HT_MosSyouhn> syuMosSyouhnLst = syoriCTL.getMosSyouhnsBySyutkkbn(C_SyutkKbn.SYU);
        HT_MosSyouhn syuSyouhnnm = syuMosSyouhnLst.get(0);
        BM_SyouhnZokusei syuSyouhnZokusei = bizDomManager.getSyouhnZokusei(syuSyouhnnm.getSyouhncd(), syuSyouhnnm.getSyouhnsdno());
        List<BM_SyouhnZokusei> syouhnZokuseiList = new ArrayList<>();
        syouhnZokuseiList.add(syuSyouhnZokusei);

        mosnaiCheckParam.setSyuSyouhnZokusei(syuSyouhnZokusei);
        mosnaiCheckParam.setListTkSyouhnZokusei(syouhnZokuseiList);
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setKosID("user001");
        mosnaiCheckParam.setKosTime("20160831011400000");
        mosnaiCheckParam.setSysKbn(C_SysKbn.SKEI);

        try {
            CheckSP checkSP = SWAKInjector.getInstance(CheckSP.class);
            checkSP.exec(mosnaiCheckParam);
        } catch (CommonBizAppException e) {
            exStringEquals(e.getMessage(), "システム整合性エラーです。最低Ｓ事方書チェックマスタにデータが存在しません。", "エラーメッセージ");
            throw e;
        }
    }

    @Test
    @Transactional
    @TestOrder(70)
    public void testExec_A4_2() {
        MockObjectManager.initialize();
        HanteiMoschkMockForSinkeiyaku.SYORIPTN = HanteiMoschkMockForSinkeiyaku.TESTPATTERN1;
        CheckTuusanMockForSinkeiyaku.SYORIPTN = CheckTuusanMockForSinkeiyaku.TESTPATTERN2;

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("791112261");

        List<HT_HubiMsg> hubiMsg = syoriCTL.getHubiMsgs();
        List<HT_MosSyouhn> syuMosSyouhnLst = syoriCTL.getMosSyouhnsBySyutkkbn(C_SyutkKbn.SYU);
        HT_MosSyouhn syuSyouhnnm = syuMosSyouhnLst.get(0);
        BM_SyouhnZokusei syuSyouhnZokusei = bizDomManager.getSyouhnZokusei(syuSyouhnnm.getSyouhncd(), syuSyouhnnm.getSyouhnsdno());
        List<BM_SyouhnZokusei> syouhnZokuseiList = new ArrayList<>();
        syouhnZokuseiList.add(syuSyouhnZokusei);

        mosnaiCheckParam.setSyuSyouhnZokusei(syuSyouhnZokusei);
        mosnaiCheckParam.setListTkSyouhnZokusei(syouhnZokuseiList);
        mosnaiCheckParam.setListHubiMsg(hubiMsg);
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setKosID("user001");
        mosnaiCheckParam.setKosTime("20160831011400000");
        mosnaiCheckParam.setSysKbn(C_SysKbn.SKEI);
        CheckSP checkSP = SWAKInjector.getInstance(CheckSP.class);
        checkSP.exec(mosnaiCheckParam);

        List<HT_HubiMsg> hubiMsgLst = mosnaiCheckParam.getListHubiMsg();
        exNumericEquals(hubiMsgLst.size(), 0, "不備メッセージテーブルエンティティリスト件数");

    }

    @Test
    @Transactional
    @TestOrder(80)
    public void testExec_A4_3() {
        MockObjectManager.initialize();
        HanteiMoschkMockForSinkeiyaku.SYORIPTN = HanteiMoschkMockForSinkeiyaku.TESTPATTERN1;
        CheckTuusanMockForSinkeiyaku.SYORIPTN = CheckTuusanMockForSinkeiyaku.TESTPATTERN2;

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("791112279");

        List<HT_HubiMsg> hubiMsg = syoriCTL.getHubiMsgs();
        List<HT_MosSyouhn> syuMosSyouhnLst = syoriCTL.getMosSyouhnsBySyutkkbn(C_SyutkKbn.SYU);
        HT_MosSyouhn syuSyouhnnm = syuMosSyouhnLst.get(0);
        BM_SyouhnZokusei syuSyouhnZokusei = bizDomManager.getSyouhnZokusei(syuSyouhnnm.getSyouhncd(), syuSyouhnnm.getSyouhnsdno());
        List<BM_SyouhnZokusei> syouhnZokuseiList = new ArrayList<>();
        syouhnZokuseiList.add(syuSyouhnZokusei);

        mosnaiCheckParam.setSyuSyouhnZokusei(syuSyouhnZokusei);
        mosnaiCheckParam.setListTkSyouhnZokusei(syouhnZokuseiList);
        mosnaiCheckParam.setListHubiMsg(hubiMsg);
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setKosID("user001");
        mosnaiCheckParam.setKosTime("20160831011400000");
        mosnaiCheckParam.setSysKbn(C_SysKbn.SKEI);
        CheckSP checkSP = SWAKInjector.getInstance(CheckSP.class);
        checkSP.exec(mosnaiCheckParam);

        List<HT_HubiMsg> hubiMsgLst = mosnaiCheckParam.getListHubiMsg();
        exNumericEquals(hubiMsgLst.size(), 1, "不備メッセージテーブルエンティティリスト件数");
        exStringEquals(hubiMsgLst.get(0).getMosno(), "791112279", "申込番号");
        exNumericEquals(hubiMsgLst.get(0).getRenno(), 1, "連番");
        exStringEquals(hubiMsgLst.get(0).getMessageId(), "EHC0061", "メッセージＩＤ");
        exStringEquals(hubiMsgLst.get(0).getHubimsg(), "商品名１の保険金額が相違しています。　正当保険金　５００，００１円", "不備メッセージ");
        exClassificationEquals(hubiMsgLst.get(0).getHubisyubetukbn(), C_HubisyubetuKbn.KETHORYU_HUBI, "不備種別区分");
        exClassificationEquals(mosnaiCheckParam.getCheckspJissiUmuKbnSeijyou(), C_UmuKbn.NONE, "SPチェック実施済有無区分（正常終了）");

    }

    @Test
    @Transactional
    @TestOrder(90)
    public void testExec_A4_4() {
        MockObjectManager.initialize();
        HanteiMoschkMockForSinkeiyaku.SYORIPTN = HanteiMoschkMockForSinkeiyaku.TESTPATTERN1;
        CheckTuusanMockForSinkeiyaku.SYORIPTN = CheckTuusanMockForSinkeiyaku.TESTPATTERN2;

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("791112287");

        List<HT_HubiMsg> hubiMsg = syoriCTL.getHubiMsgs();
        List<HT_MosSyouhn> syuMosSyouhnLst = syoriCTL.getMosSyouhnsBySyutkkbn(C_SyutkKbn.SYU);
        HT_MosSyouhn syuSyouhnnm = syuMosSyouhnLst.get(0);
        BM_SyouhnZokusei syuSyouhnZokusei = bizDomManager.getSyouhnZokusei(syuSyouhnnm.getSyouhncd(), syuSyouhnnm.getSyouhnsdno());
        List<BM_SyouhnZokusei> syouhnZokuseiList = new ArrayList<>();
        syouhnZokuseiList.add(syuSyouhnZokusei);

        mosnaiCheckParam.setSyuSyouhnZokusei(syuSyouhnZokusei);
        mosnaiCheckParam.setListTkSyouhnZokusei(syouhnZokuseiList);
        mosnaiCheckParam.setListHubiMsg(hubiMsg);
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setKosID("user001");
        mosnaiCheckParam.setKosTime("20160831011400000");
        mosnaiCheckParam.setSysKbn(C_SysKbn.SKEI);
        CheckSP checkSP = SWAKInjector.getInstance(CheckSP.class);
        checkSP.exec(mosnaiCheckParam);

        List<HT_HubiMsg> hubiMsgLst = mosnaiCheckParam.getListHubiMsg();
        exNumericEquals(hubiMsgLst.size(), 1, "不備メッセージテーブルエンティティリスト件数");
        exStringEquals(hubiMsgLst.get(0).getMosno(), "791112287", "申込番号");
        exNumericEquals(hubiMsgLst.get(0).getRenno(), 1, "連番");
        exStringEquals(hubiMsgLst.get(0).getMessageId(), "EHC0061", "メッセージＩＤ");
        exStringEquals(hubiMsgLst.get(0).getHubimsg(), "商品名２の保険金額が相違しています。　正当保険金　５００，０００円", "不備メッセージ");
        exClassificationEquals(hubiMsgLst.get(0).getHubisyubetukbn(), C_HubisyubetuKbn.KETHORYU_HUBI, "不備種別区分");

    }

    @Test
    @Transactional
    @TestOrder(100)
    public void testExec_A4_5() {
        MockObjectManager.initialize();
        HanteiMoschkMockForSinkeiyaku.SYORIPTN = HanteiMoschkMockForSinkeiyaku.TESTPATTERN1;
        CheckTuusanMockForSinkeiyaku.SYORIPTN = CheckTuusanMockForSinkeiyaku.TESTPATTERN2;

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("791112311");

        List<HT_HubiMsg> hubiMsg = syoriCTL.getHubiMsgs();
        List<HT_MosSyouhn> syuMosSyouhnLst = syoriCTL.getMosSyouhnsBySyutkkbn(C_SyutkKbn.SYU);
        HT_MosSyouhn syuSyouhnnm = syuMosSyouhnLst.get(0);
        BM_SyouhnZokusei syuSyouhnZokusei = bizDomManager.getSyouhnZokusei(syuSyouhnnm.getSyouhncd(), syuSyouhnnm.getSyouhnsdno());
        List<BM_SyouhnZokusei> syouhnZokuseiList = new ArrayList<>();
        syouhnZokuseiList.add(syuSyouhnZokusei);

        mosnaiCheckParam.setSyuSyouhnZokusei(syuSyouhnZokusei);
        mosnaiCheckParam.setListTkSyouhnZokusei(syouhnZokuseiList);
        mosnaiCheckParam.setListHubiMsg(hubiMsg);
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setKosID("user001");
        mosnaiCheckParam.setKosTime("20160831011400000");
        mosnaiCheckParam.setSysKbn(C_SysKbn.SKEI);
        CheckSP checkSP = SWAKInjector.getInstance(CheckSP.class);
        checkSP.exec(mosnaiCheckParam);

        List<HT_HubiMsg> hubiMsgLst = mosnaiCheckParam.getListHubiMsg();
        exNumericEquals(hubiMsgLst.size(), 2, "不備メッセージテーブルエンティティリスト件数");
        exStringEquals(hubiMsgLst.get(0).getMosno(), "791112311", "申込番号");
        exNumericEquals(hubiMsgLst.get(0).getRenno(), 1, "連番");
        exStringEquals(hubiMsgLst.get(0).getMessageId(), "EHC0031", "メッセージＩＤ");
        exStringEquals(hubiMsgLst.get(0).getHubimsg(), "商品名２の保険金額が最低Ｓの５００，０００円に未達です。", "不備メッセージ");
        exClassificationEquals(hubiMsgLst.get(0).getHubisyubetukbn(), C_HubisyubetuKbn.KETHORYU_HUBI, "不備種別区分");

        exStringEquals(hubiMsgLst.get(1).getMosno(), "791112311", "申込番号");
        exNumericEquals(hubiMsgLst.get(1).getRenno(), 2, "連番");
        exStringEquals(hubiMsgLst.get(1).getMessageId(), "EHC0061", "メッセージＩＤ");
        exStringEquals(hubiMsgLst.get(1).getHubimsg(), "商品名２の保険金額が相違しています。　正当保険金　４９９，９９９円", "不備メッセージ");
        exClassificationEquals(hubiMsgLst.get(1).getHubisyubetukbn(), C_HubisyubetuKbn.KETHORYU_HUBI, "不備種別区分");
        exClassificationEquals(mosnaiCheckParam.getCheckspJissiUmuKbnSeijyou(), C_UmuKbn.NONE, "SPチェック実施済有無区分（正常終了）");
    }

    @Test(expected = CommonBizAppException.class)
    @Transactional
    @TestOrder(101)
    public void testExec_A4_6() {
        MockObjectManager.initialize();
        HanteiMoschkMockForSinkeiyaku.SYORIPTN = HanteiMoschkMockForSinkeiyaku.TESTPATTERN1;
        CheckTuusanMockForSinkeiyaku.SYORIPTN = CheckTuusanMockForSinkeiyaku.TESTPATTERN2;

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("870000015");
        List<HT_MosSyouhn> syuMosSyouhnLst = syoriCTL.getMosSyouhnsBySyutkkbn(C_SyutkKbn.SYU);
        HT_MosSyouhn syuSyouhnnm = syuMosSyouhnLst.get(0);
        BM_SyouhnZokusei syuSyouhnZokusei = bizDomManager.getSyouhnZokusei(syuSyouhnnm.getSyouhncd(), syuSyouhnnm.getSyouhnsdno());
        List<BM_SyouhnZokusei> syouhnZokuseiList = new ArrayList<>();
        syouhnZokuseiList.add(syuSyouhnZokusei);

        mosnaiCheckParam.setSyuSyouhnZokusei(syuSyouhnZokusei);
        mosnaiCheckParam.setListTkSyouhnZokusei(syouhnZokuseiList);
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setKosID("user001");
        mosnaiCheckParam.setKosTime("20160831011400000");
        mosnaiCheckParam.setSysKbn(C_SysKbn.SKEI);

        try {
            CheckSP checkSP = SWAKInjector.getInstance(CheckSP.class);
            checkSP.exec(mosnaiCheckParam);
        } catch (CommonBizAppException e) {
            exStringEquals(e.getMessage(), "システム整合性エラーです。最低Ｓチェックマスタにデータが存在しません。", "エラーメッセージ");
            throw e;
        }
    }


    @Test(expected = CommonBizAppException.class)
    @Transactional
    @TestOrder(102)
    public void testExec_A4_7() {
        MockObjectManager.initialize();
        HanteiMoschkMockForSinkeiyaku.SYORIPTN = HanteiMoschkMockForSinkeiyaku.TESTPATTERN1;
        CheckTuusanMockForSinkeiyaku.SYORIPTN = CheckTuusanMockForSinkeiyaku.TESTPATTERN2;

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("870000023");
        List<HT_MosSyouhn> syuMosSyouhnLst = syoriCTL.getMosSyouhnsBySyutkkbn(C_SyutkKbn.SYU);
        HT_MosSyouhn syuSyouhnnm = syuMosSyouhnLst.get(0);
        BM_SyouhnZokusei syuSyouhnZokusei = bizDomManager.getSyouhnZokusei(syuSyouhnnm.getSyouhncd(), syuSyouhnnm.getSyouhnsdno());
        List<BM_SyouhnZokusei> syouhnZokuseiList = new ArrayList<>();
        syouhnZokuseiList.add(syuSyouhnZokusei);

        mosnaiCheckParam.setSyuSyouhnZokusei(syuSyouhnZokusei);
        mosnaiCheckParam.setListTkSyouhnZokusei(syouhnZokuseiList);
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setKosID("user001");
        mosnaiCheckParam.setKosTime("20160831011400000");
        mosnaiCheckParam.setSysKbn(C_SysKbn.SKEI);

        try {
            CheckSP checkSP = SWAKInjector.getInstance(CheckSP.class);
            checkSP.exec(mosnaiCheckParam);
        } catch (CommonBizAppException e) {
            exStringEquals(e.getMessage(), "システム整合性エラーです。最低Ｓ事方書チェックマスタにデータが存在しません。", "エラーメッセージ");
            throw e;
        }
    }

    @Test
    @Transactional
    @TestOrder(103)
    public void testExec_A4_8() {
        MockObjectManager.initialize();
        HanteiMoschkMockForSinkeiyaku.SYORIPTN = HanteiMoschkMockForSinkeiyaku.TESTPATTERN1;
        CheckTuusanMockForSinkeiyaku.SYORIPTN = CheckTuusanMockForSinkeiyaku.TESTPATTERN2;

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("870000031");

        List<HT_HubiMsg> hubiMsg = syoriCTL.getHubiMsgs();
        List<HT_MosSyouhn> syuMosSyouhnLst = syoriCTL.getMosSyouhnsBySyutkkbn(C_SyutkKbn.SYU);
        HT_MosSyouhn syuSyouhnnm = syuMosSyouhnLst.get(0);
        BM_SyouhnZokusei syuSyouhnZokusei = bizDomManager.getSyouhnZokusei(syuSyouhnnm.getSyouhncd(), syuSyouhnnm.getSyouhnsdno());
        List<BM_SyouhnZokusei> syouhnZokuseiList = new ArrayList<>();
        syouhnZokuseiList.add(syuSyouhnZokusei);

        mosnaiCheckParam.setSyuSyouhnZokusei(syuSyouhnZokusei);
        mosnaiCheckParam.setListTkSyouhnZokusei(syouhnZokuseiList);
        mosnaiCheckParam.setListHubiMsg(hubiMsg);
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setKosID("user001");
        mosnaiCheckParam.setKosTime("20160831011400000");
        mosnaiCheckParam.setSysKbn(C_SysKbn.SKEI);
        CheckSP checkSP = SWAKInjector.getInstance(CheckSP.class);
        checkSP.exec(mosnaiCheckParam);

        List<HT_HubiMsg> hubiMsgLst = mosnaiCheckParam.getListHubiMsg();
        exNumericEquals(hubiMsgLst.size(), 0, "不備メッセージテーブルエンティティリスト件数");

    }

    @Test
    @Transactional
    @TestOrder(104)
    public void testExec_A4_9() {
        MockObjectManager.initialize();
        HanteiMoschkMockForSinkeiyaku.SYORIPTN = HanteiMoschkMockForSinkeiyaku.TESTPATTERN1;
        CheckTuusanMockForSinkeiyaku.SYORIPTN = CheckTuusanMockForSinkeiyaku.TESTPATTERN2;

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("870000049");

        List<HT_HubiMsg> hubiMsg = syoriCTL.getHubiMsgs();
        List<HT_MosSyouhn> syuMosSyouhnLst = syoriCTL.getMosSyouhnsBySyutkkbn(C_SyutkKbn.SYU);
        HT_MosSyouhn syuSyouhnnm = syuMosSyouhnLst.get(0);
        BM_SyouhnZokusei syuSyouhnZokusei = bizDomManager.getSyouhnZokusei(syuSyouhnnm.getSyouhncd(), syuSyouhnnm.getSyouhnsdno());
        List<BM_SyouhnZokusei> syouhnZokuseiList = new ArrayList<>();
        syouhnZokuseiList.add(syuSyouhnZokusei);

        mosnaiCheckParam.setSyuSyouhnZokusei(syuSyouhnZokusei);
        mosnaiCheckParam.setListTkSyouhnZokusei(syouhnZokuseiList);
        mosnaiCheckParam.setListHubiMsg(hubiMsg);
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setKosID("user001");
        mosnaiCheckParam.setKosTime("20160831011400000");
        mosnaiCheckParam.setSysKbn(C_SysKbn.SKEI);
        CheckSP checkSP = SWAKInjector.getInstance(CheckSP.class);
        checkSP.exec(mosnaiCheckParam);

        List<HT_HubiMsg> hubiMsgLst = mosnaiCheckParam.getListHubiMsg();
        exNumericEquals(hubiMsgLst.size(), 1, "不備メッセージテーブルエンティティリスト件数");
        exStringEquals(hubiMsgLst.get(0).getMosno(), "870000049", "申込番号");
        exNumericEquals(hubiMsgLst.get(0).getRenno(), 1, "連番");
        exStringEquals(hubiMsgLst.get(0).getMessageId(), "EHC0061", "メッセージＩＤ");
        exStringEquals(hubiMsgLst.get(0).getHubimsg(), "商品名２の保険金額が相違しています。　正当保険金　５００，００１円", "不備メッセージ");
        exClassificationEquals(hubiMsgLst.get(0).getHubisyubetukbn(), C_HubisyubetuKbn.KETHORYU_HUBI, "不備種別区分");
        exClassificationEquals(mosnaiCheckParam.getCheckspJissiUmuKbnSeijyou(), C_UmuKbn.NONE, "SPチェック実施済有無区分（正常終了）");

    }

    @Test
    @Transactional
    @TestOrder(105)
    public void testExec_A4_10() {
        MockObjectManager.initialize();
        HanteiMoschkMockForSinkeiyaku.SYORIPTN = HanteiMoschkMockForSinkeiyaku.TESTPATTERN1;
        CheckTuusanMockForSinkeiyaku.SYORIPTN = CheckTuusanMockForSinkeiyaku.TESTPATTERN2;

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("870000056");

        List<HT_HubiMsg> hubiMsg = syoriCTL.getHubiMsgs();
        List<HT_MosSyouhn> syuMosSyouhnLst = syoriCTL.getMosSyouhnsBySyutkkbn(C_SyutkKbn.SYU);
        HT_MosSyouhn syuSyouhnnm = syuMosSyouhnLst.get(0);
        BM_SyouhnZokusei syuSyouhnZokusei = bizDomManager.getSyouhnZokusei(syuSyouhnnm.getSyouhncd(), syuSyouhnnm.getSyouhnsdno());
        List<BM_SyouhnZokusei> syouhnZokuseiList = new ArrayList<>();
        syouhnZokuseiList.add(syuSyouhnZokusei);

        mosnaiCheckParam.setSyuSyouhnZokusei(syuSyouhnZokusei);
        mosnaiCheckParam.setListTkSyouhnZokusei(syouhnZokuseiList);
        mosnaiCheckParam.setListHubiMsg(hubiMsg);
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setKosID("user001");
        mosnaiCheckParam.setKosTime("20160831011400000");
        mosnaiCheckParam.setSysKbn(C_SysKbn.SKEI);
        CheckSP checkSP = SWAKInjector.getInstance(CheckSP.class);
        checkSP.exec(mosnaiCheckParam);

        List<HT_HubiMsg> hubiMsgLst = mosnaiCheckParam.getListHubiMsg();
        exNumericEquals(hubiMsgLst.size(), 1, "不備メッセージテーブルエンティティリスト件数");
        exStringEquals(hubiMsgLst.get(0).getMosno(), "870000056", "申込番号");
        exNumericEquals(hubiMsgLst.get(0).getRenno(), 1, "連番");
        exStringEquals(hubiMsgLst.get(0).getMessageId(), "EHC0061", "メッセージＩＤ");
        exStringEquals(hubiMsgLst.get(0).getHubimsg(), "商品名２の保険金額が相違しています。　正当保険金　５００，０００円", "不備メッセージ");
        exClassificationEquals(hubiMsgLst.get(0).getHubisyubetukbn(), C_HubisyubetuKbn.KETHORYU_HUBI, "不備種別区分");

    }

    @Test
    @Transactional
    @TestOrder(106)
    public void testExec_A4_11() {
        MockObjectManager.initialize();
        HanteiMoschkMockForSinkeiyaku.SYORIPTN = HanteiMoschkMockForSinkeiyaku.TESTPATTERN1;
        CheckTuusanMockForSinkeiyaku.SYORIPTN = CheckTuusanMockForSinkeiyaku.TESTPATTERN2;

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("870000064");

        List<HT_HubiMsg> hubiMsg = syoriCTL.getHubiMsgs();
        List<HT_MosSyouhn> syuMosSyouhnLst = syoriCTL.getMosSyouhnsBySyutkkbn(C_SyutkKbn.SYU);
        HT_MosSyouhn syuSyouhnnm = syuMosSyouhnLst.get(0);
        BM_SyouhnZokusei syuSyouhnZokusei = bizDomManager.getSyouhnZokusei(syuSyouhnnm.getSyouhncd(), syuSyouhnnm.getSyouhnsdno());
        List<BM_SyouhnZokusei> syouhnZokuseiList = new ArrayList<>();
        syouhnZokuseiList.add(syuSyouhnZokusei);

        mosnaiCheckParam.setSyuSyouhnZokusei(syuSyouhnZokusei);
        mosnaiCheckParam.setListTkSyouhnZokusei(syouhnZokuseiList);
        mosnaiCheckParam.setListHubiMsg(hubiMsg);
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setKosID("user001");
        mosnaiCheckParam.setKosTime("20160831011400000");
        mosnaiCheckParam.setSysKbn(C_SysKbn.SKEI);
        mosnaiCheckParam.setPdateSRate(BizNumber.valueOf(1.3));
        CheckSP checkSP = SWAKInjector.getInstance(CheckSP.class);
        checkSP.exec(mosnaiCheckParam);

        List<HT_HubiMsg> hubiMsgLst = mosnaiCheckParam.getListHubiMsg();
        exNumericEquals(hubiMsgLst.size(), 2, "不備メッセージテーブルエンティティリスト件数");
        exStringEquals(hubiMsgLst.get(0).getMosno(), "870000064", "申込番号");
        exNumericEquals(hubiMsgLst.get(0).getRenno(), 1, "連番");
        exStringEquals(hubiMsgLst.get(0).getMessageId(), "THC0031", "メッセージＩＤ");
        exStringEquals(hubiMsgLst.get(0).getHubimsg(), "【特認可能】商品名２の保険金額が最低Ｓの５００，０００円に未達です。", "不備メッセージ");
        exClassificationEquals(hubiMsgLst.get(0).getHubisyubetukbn(), C_HubisyubetuKbn.KETHORYU_HUBI, "不備種別区分");

        exStringEquals(hubiMsgLst.get(1).getMosno(), "870000064", "申込番号");
        exNumericEquals(hubiMsgLst.get(1).getRenno(), 2, "連番");
        exStringEquals(hubiMsgLst.get(1).getMessageId(), "EHC0061", "メッセージＩＤ");
        exStringEquals(hubiMsgLst.get(1).getHubimsg(), "商品名２の保険金額が相違しています。　正当保険金　４９９，９９９円", "不備メッセージ");
        exClassificationEquals(hubiMsgLst.get(1).getHubisyubetukbn(), C_HubisyubetuKbn.KETHORYU_HUBI, "不備種別区分");

    }
    @Test
    @Transactional
    @TestOrder(110)
    public void testExec_A5_1() {
        MockObjectManager.initialize();

        HanteiMoschkMockForSinkeiyaku.SYORIPTN = HanteiMoschkMockForSinkeiyaku.TESTPATTERN1;
        CheckTuusanMockForSinkeiyaku.SYORIPTN = CheckTuusanMockForSinkeiyaku.TESTPATTERN2;

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("791112329");
        List<HT_MosSyouhn> syuMosSyouhnLst = syoriCTL.getMosSyouhnsBySyutkkbn(C_SyutkKbn.SYU);
        HT_MosSyouhn syuSyouhnnm = syuMosSyouhnLst.get(0);
        BM_SyouhnZokusei syuSyouhnZokusei = bizDomManager.getSyouhnZokusei(syuSyouhnnm.getSyouhncd(), syuSyouhnnm.getSyouhnsdno());
        List<BM_SyouhnZokusei> syouhnZokuseiList = new ArrayList<>();
        syouhnZokuseiList.add(syuSyouhnZokusei);

        mosnaiCheckParam.setSyuSyouhnZokusei(syuSyouhnZokusei);
        mosnaiCheckParam.setListTkSyouhnZokusei(syouhnZokuseiList);
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setKosID("user001");
        mosnaiCheckParam.setKosTime("20160831011400000");
        mosnaiCheckParam.setSysKbn(C_SysKbn.ESHIEN);
        mosnaiCheckParam.setBosyuuSysCtrlKbn(C_BosyuusysctrlKbn.SINKIN);
        mosnaiCheckParam.setPdateSRate(BizNumber.valueOf(1.3));
        mosnaiCheckParam.setHrbtJyousu(BizNumber.valueOf(0.5));
        CheckSP checkSP = SWAKInjector.getInstance(CheckSP.class);
        checkSP.exec(mosnaiCheckParam);

        List<HT_HubiMsg> hubiMsgLst = mosnaiCheckParam.getListHubiMsg();
        exNumericEquals(hubiMsgLst.size(), 0, "不備メッセージ件数");

        exClassificationEquals(mosnaiCheckParam.getSekmossakuseiErroutKbn(), C_SekmossakuseiErroutKbn.GAMEN,
            "設計書申込書作成エラー出力区分");
        exStringEquals(mosnaiCheckParam.getSekmossakuseiErrmsg1(), "", "設計書申込書作成エラーメッセージ１");
        exStringEquals(mosnaiCheckParam.getSekmossakuseiErrmsg2(), "最低保険金額未達　保険料は１９２，２７０円以上にしてください",
            "設計書申込書作成エラーメッセージ２");
        exClassificationEquals(mosnaiCheckParam.getKouzokuSyoriJikkouKbn(), C_KouzokujkKbn.NONE, "後続処理実行区分 ");
        exClassificationEquals(mosnaiCheckParam.getCheckspJissiUmuKbnSeijyou(), C_UmuKbn.NONE, "SPチェック実施済有無区分（正常終了）");

    }

    @Test(expected = CommonBizAppException.class)
    @Transactional
    @TestOrder(120)
    public void testExec_A5_2() {
        MockObjectManager.initialize();
        HanteiMoschkMockForSinkeiyaku.SYORIPTN = HanteiMoschkMockForSinkeiyaku.TESTPATTERN1;
        CheckTuusanMockForSinkeiyaku.SYORIPTN = null;

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("791112337");
        List<HT_MosSyouhn> syuMosSyouhnLst = syoriCTL.getMosSyouhnsBySyutkkbn(C_SyutkKbn.SYU);
        HT_MosSyouhn syuSyouhnnm = syuMosSyouhnLst.get(0);
        BM_SyouhnZokusei syuSyouhnZokusei = bizDomManager.getSyouhnZokusei(syuSyouhnnm.getSyouhncd(), syuSyouhnnm.getSyouhnsdno());
        List<BM_SyouhnZokusei> syouhnZokuseiList = new ArrayList<>();
        syouhnZokuseiList.add(syuSyouhnZokusei);

        mosnaiCheckParam.setSyuSyouhnZokusei(syuSyouhnZokusei);
        mosnaiCheckParam.setListTkSyouhnZokusei(syouhnZokuseiList);
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setKosID("user001");
        mosnaiCheckParam.setKosTime("20160831011400000");
        mosnaiCheckParam.setSysKbn(C_SysKbn.ESHIEN);
        mosnaiCheckParam.setBosyuuSysCtrlKbn(C_BosyuusysctrlKbn.SINKIN);

        try {
            CheckSP checkSP = SWAKInjector.getInstance(CheckSP.class);
            checkSP.exec(mosnaiCheckParam);
        } catch (CommonBizAppException e) {
            exStringEquals(e.getMessage(), "システム整合性エラーです。申込番号=791112337", "エラーメッセージ");
            throw e;
        }
    }

    @Test
    @Transactional
    @TestOrder(130)
    public void testExec_A5_3() {

        MockObjectManager.initialize();
        KeisanGaikakanzanMockForSinkeiyaku.SYORIPTN = KeisanGaikakanzanMockForSinkeiyaku.TESTPATTERN3;
        HanteiMoschkMockForSinkeiyaku.SYORIPTN = HanteiMoschkMockForSinkeiyaku.TESTPATTERN1;
        CheckTuusanMockForSinkeiyaku.SYORIPTN = CheckTuusanMockForSinkeiyaku.TESTPATTERN3;

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("791112345");
        List<HT_MosSyouhn> syuMosSyouhnLst = syoriCTL.getMosSyouhnsBySyutkkbn(C_SyutkKbn.SYU);
        HT_MosSyouhn syuSyouhnnm = syuMosSyouhnLst.get(0);
        BM_SyouhnZokusei syuSyouhnZokusei = bizDomManager.getSyouhnZokusei(syuSyouhnnm.getSyouhncd(), syuSyouhnnm.getSyouhnsdno());
        List<BM_SyouhnZokusei> syouhnZokuseiList = new ArrayList<>();
        syouhnZokuseiList.add(syuSyouhnZokusei);

        mosnaiCheckParam.setSyuSyouhnZokusei(syuSyouhnZokusei);
        mosnaiCheckParam.setListTkSyouhnZokusei(syouhnZokuseiList);
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setKosID("user001");
        mosnaiCheckParam.setKosTime("20160831011400000");
        mosnaiCheckParam.setSysKbn(C_SysKbn.ESHIEN);
        mosnaiCheckParam.setBosyuuSysCtrlKbn(C_BosyuusysctrlKbn.SINKIN);
        mosnaiCheckParam.setSekmossakuseiOyaAgCd("1234567");
        mosnaiCheckParam.setKiteiCheckChannelCd(C_Channelcd.TIGIN);

        CheckSP checkSP = SWAKInjector.getInstance(CheckSP.class);
        checkSP.exec(mosnaiCheckParam);

        List<HT_HubiMsg> hubiMsgLst = mosnaiCheckParam.getListHubiMsg();
        exNumericEquals(hubiMsgLst.size(), 0, "不備メッセージ件数");

        exClassificationEquals(mosnaiCheckParam.getSekmossakuseiErroutKbn(), C_SekmossakuseiErroutKbn.GAMEN,
            "設計書申込書作成エラー出力区分");
        exStringEquals(mosnaiCheckParam.getSekmossakuseiErrmsg1(), "", "設計書申込書作成エラーメッセージ１");
        exStringEquals(mosnaiCheckParam.getSekmossakuseiErrmsg2(), "最低保険金額未達　保険料は０円以上にしてください",
            "設計書申込書作成エラーメッセージ２");
        exClassificationEquals(mosnaiCheckParam.getKouzokuSyoriJikkouKbn(), C_KouzokujkKbn.NONE, "後続処理実行区分 ");

        MockObjectManager.assertArgumentPassed(CheckTuusanMockForSinkeiyaku.class, "getPTani", 0, syoriCTL);
        MockObjectManager.assertArgumentPassed(CheckTuusanMockForSinkeiyaku.class, "getPTani", 1, syoriCTL.getMosKihon());
        MockObjectManager.assertArgumentPassed(CheckTuusanMockForSinkeiyaku.class, "getPTani", 2, syoriCTL.getMosSyouhns().get(0));
        MockObjectManager.assertArgumentPassed(CheckTuusanMockForSinkeiyaku.class, "getPTani", 3, C_Channelcd.TIGIN);
    }


    @Test
    @Transactional
    @TestOrder(131)
    public void testExec_A5_4() {

        MockObjectManager.initialize();
        KeisanGaikakanzanMockForSinkeiyaku.SYORIPTN = KeisanGaikakanzanMockForSinkeiyaku.TESTPATTERN2;
        HanteiMoschkMockForSinkeiyaku.SYORIPTN = HanteiMoschkMockForSinkeiyaku.TESTPATTERN1;
        CheckTuusanMockForSinkeiyaku.SYORIPTN = CheckTuusanMockForSinkeiyaku.TESTPATTERN2;

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("791112352");
        List<HT_MosSyouhn> syuMosSyouhnLst = syoriCTL.getMosSyouhnsBySyutkkbn(C_SyutkKbn.SYU);
        HT_MosSyouhn syuSyouhnnm = syuMosSyouhnLst.get(0);
        BM_SyouhnZokusei syuSyouhnZokusei = bizDomManager.getSyouhnZokusei(syuSyouhnnm.getSyouhncd(), syuSyouhnnm.getSyouhnsdno());
        List<BM_SyouhnZokusei> syouhnZokuseiList = new ArrayList<>();
        syouhnZokuseiList.add(syuSyouhnZokusei);

        mosnaiCheckParam.setSyuSyouhnZokusei(syuSyouhnZokusei);
        mosnaiCheckParam.setListTkSyouhnZokusei(syouhnZokuseiList);
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setKosID("user001");
        mosnaiCheckParam.setKosTime("20160831011400000");
        mosnaiCheckParam.setSysKbn(C_SysKbn.ESHIEN);
        mosnaiCheckParam.setBosyuuSysCtrlKbn(C_BosyuusysctrlKbn.SINKIN);
        mosnaiCheckParam.setSekmossakuseiOyaAgCd("1234567");
        mosnaiCheckParam.setKiteiCheckChannelCd(C_Channelcd.TIGIN);
        mosnaiCheckParam.setPdateSRate(BizNumber.valueOf(1.3));

        CheckSP checkSP = SWAKInjector.getInstance(CheckSP.class);
        checkSP.exec(mosnaiCheckParam);

        List<HT_HubiMsg> hubiMsgLst = mosnaiCheckParam.getListHubiMsg();
        exNumericEquals(hubiMsgLst.size(), 0, "不備メッセージ件数");

        exClassificationEquals(mosnaiCheckParam.getSekmossakuseiErroutKbn(), C_SekmossakuseiErroutKbn.GAMEN,
            "設計書申込書作成エラー出力区分");
        exStringEquals(mosnaiCheckParam.getSekmossakuseiErrmsg1(), "", "設計書申込書作成エラーメッセージ１");
        exStringEquals(mosnaiCheckParam.getSekmossakuseiErrmsg2(), "最低保険金額未達　保険料は０米ドル以上にしてください",
            "設計書申込書作成エラーメッセージ２");
        exClassificationEquals(mosnaiCheckParam.getKouzokuSyoriJikkouKbn(), C_KouzokujkKbn.NONE, "後続処理実行区分 ");

        MockObjectManager.assertArgumentPassed(CheckTuusanMockForSinkeiyaku.class, "getPTani", 0, syoriCTL);
        MockObjectManager.assertArgumentPassed(CheckTuusanMockForSinkeiyaku.class, "getPTani", 1, syoriCTL.getMosKihon());
        MockObjectManager.assertArgumentPassed(CheckTuusanMockForSinkeiyaku.class, "getPTani", 2, syoriCTL.getMosSyouhns().get(0));
        MockObjectManager.assertArgumentPassed(CheckTuusanMockForSinkeiyaku.class, "getPTani", 3, C_Channelcd.TIGIN);

    }

    @Test
    @Transactional
    @TestOrder(132)
    public void testExec_A5_5() {

        MockObjectManager.initialize();
        yuyu.common.hozen.khcommon.KeisanSPMockForSinkeiyaku.SYORIPTN =  "";
        KeisanGaikakanzanMockForSinkeiyaku.SYORIPTN = KeisanGaikakanzanMockForSinkeiyaku.TESTPATTERN2;
        HanteiMoschkMockForSinkeiyaku.SYORIPTN = HanteiMoschkMockForSinkeiyaku.TESTPATTERN1;
        CheckTuusanMockForSinkeiyaku.SYORIPTN = CheckTuusanMockForSinkeiyaku.TESTPATTERN2;

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("791112360");
        List<HT_MosSyouhn> syuMosSyouhnLst = syoriCTL.getMosSyouhnsBySyutkkbn(C_SyutkKbn.SYU);
        HT_MosSyouhn syuSyouhnnm = syuMosSyouhnLst.get(0);
        BM_SyouhnZokusei syuSyouhnZokusei = bizDomManager.getSyouhnZokusei(syuSyouhnnm.getSyouhncd(), syuSyouhnnm.getSyouhnsdno());
        List<BM_SyouhnZokusei> syouhnZokuseiList = new ArrayList<>();
        syouhnZokuseiList.add(syuSyouhnZokusei);

        mosnaiCheckParam.setSyuSyouhnZokusei(syuSyouhnZokusei);
        mosnaiCheckParam.setListTkSyouhnZokusei(syouhnZokuseiList);
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setKosID("user001");
        mosnaiCheckParam.setKosTime("20160831011400000");
        mosnaiCheckParam.setSysKbn(C_SysKbn.ESHIEN);
        mosnaiCheckParam.setBosyuuSysCtrlKbn(C_BosyuusysctrlKbn.SINKIN);
        mosnaiCheckParam.setSekmossakuseiOyaAgCd("1234567");
        mosnaiCheckParam.setKiteiCheckChannelCd(C_Channelcd.TIGIN);

        CheckSP checkSP = SWAKInjector.getInstance(CheckSP.class);
        checkSP.exec(mosnaiCheckParam);

        List<HT_HubiMsg> hubiMsgLst = mosnaiCheckParam.getListHubiMsg();
        exNumericEquals(hubiMsgLst.size(), 0, "不備メッセージ件数");

        exClassificationEquals(mosnaiCheckParam.getSekmossakuseiErroutKbn(), C_SekmossakuseiErroutKbn.GAMEN,
            "設計書申込書作成エラー出力区分");
        exStringEquals(mosnaiCheckParam.getSekmossakuseiErrmsg1(), "", "設計書申込書作成エラーメッセージ１");
        exStringEquals(mosnaiCheckParam.getSekmossakuseiErrmsg2(), "最低保険金額未達　保険料は５，０００米ドル以上にしてください",
            "設計書申込書作成エラーメッセージ２");
        exClassificationEquals(mosnaiCheckParam.getKouzokuSyoriJikkouKbn(), C_KouzokujkKbn.NONE, "後続処理実行区分 ");

        MockObjectManager.assertArgumentPassed(CheckTuusanMockForSinkeiyaku.class, "getPTani", 0, syoriCTL);
        MockObjectManager.assertArgumentPassed(CheckTuusanMockForSinkeiyaku.class, "getPTani", 1, syoriCTL.getMosKihon());
        MockObjectManager.assertArgumentPassed(CheckTuusanMockForSinkeiyaku.class, "getPTani", 2, syoriCTL.getMosSyouhns().get(0));
        MockObjectManager.assertArgumentPassed(CheckTuusanMockForSinkeiyaku.class, "getPTani", 3, C_Channelcd.TIGIN);
    }

    @Test
    @Transactional
    @TestOrder(133)
    public void testExec_A5_6() {

        MockObjectManager.initialize();
        HanteiMoschkMockForSinkeiyaku.SYORIPTN = HanteiMoschkMockForSinkeiyaku.TESTPATTERN1;
        CheckTuusanMockForSinkeiyaku.SYORIPTN = CheckTuusanMockForSinkeiyaku.TESTPATTERN4;

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("791112378");
        List<HT_MosSyouhn> syuMosSyouhnLst = syoriCTL.getMosSyouhnsBySyutkkbn(C_SyutkKbn.SYU);
        HT_MosSyouhn syuSyouhnnm = syuMosSyouhnLst.get(0);
        BM_SyouhnZokusei syuSyouhnZokusei = bizDomManager.getSyouhnZokusei(syuSyouhnnm.getSyouhncd(), syuSyouhnnm.getSyouhnsdno());
        List<BM_SyouhnZokusei> syouhnZokuseiList = new ArrayList<>();
        syouhnZokuseiList.add(syuSyouhnZokusei);

        mosnaiCheckParam.setSyuSyouhnZokusei(syuSyouhnZokusei);
        mosnaiCheckParam.setListTkSyouhnZokusei(syouhnZokuseiList);
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setKosID("user001");
        mosnaiCheckParam.setKosTime("20160831011400000");
        mosnaiCheckParam.setSysKbn(C_SysKbn.ESHIEN);
        mosnaiCheckParam.setBosyuuSysCtrlKbn(C_BosyuusysctrlKbn.SINKIN);
        mosnaiCheckParam.setSekmossakuseiOyaAgCd("1234567");
        mosnaiCheckParam.setKiteiCheckChannelCd(C_Channelcd.TIGIN);
        mosnaiCheckParam.setPdateSRate(BizNumber.valueOf(1.1));
        CheckSP checkSP = SWAKInjector.getInstance(CheckSP.class);
        checkSP.exec(mosnaiCheckParam);

        List<HT_HubiMsg> hubiMsgLst = mosnaiCheckParam.getListHubiMsg();
        exNumericEquals(hubiMsgLst.size(), 0, "不備メッセージ件数");

        exClassificationEquals(mosnaiCheckParam.getSekmossakuseiErroutKbn(), C_SekmossakuseiErroutKbn.GAMEN,
            "設計書申込書作成エラー出力区分");
        exStringEquals(mosnaiCheckParam.getSekmossakuseiErrmsg1(), "", "設計書申込書作成エラーメッセージ１");
        exStringEquals(mosnaiCheckParam.getSekmossakuseiErrmsg2(), "最低保険金額未達　保険料は４，５４６米ドル以上にしてください",
            "設計書申込書作成エラーメッセージ２");
        exClassificationEquals(mosnaiCheckParam.getKouzokuSyoriJikkouKbn(), C_KouzokujkKbn.NONE, "後続処理実行区分 ");

        MockObjectManager.assertArgumentPassed(CheckTuusanMockForSinkeiyaku.class, "getPTani", 0, syoriCTL);
        MockObjectManager.assertArgumentPassed(CheckTuusanMockForSinkeiyaku.class, "getPTani", 1, syoriCTL.getMosKihon());
        MockObjectManager.assertArgumentPassed(CheckTuusanMockForSinkeiyaku.class, "getPTani", 2, syoriCTL.getMosSyouhns().get(0));
        MockObjectManager.assertArgumentPassed(CheckTuusanMockForSinkeiyaku.class, "getPTani", 3, C_Channelcd.TIGIN);

    }

    @Test
    @Transactional
    @TestOrder(134)
    public void testExec_A5_7() {

        MockObjectManager.initialize();
        HanteiMoschkMockForSinkeiyaku.SYORIPTN = HanteiMoschkMockForSinkeiyaku.TESTPATTERN1;
        CheckTuusanMockForSinkeiyaku.SYORIPTN = CheckTuusanMockForSinkeiyaku.TESTPATTERN4;

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("791112386");
        List<HT_MosSyouhn> syuMosSyouhnLst = syoriCTL.getMosSyouhnsBySyutkkbn(C_SyutkKbn.SYU);
        HT_MosSyouhn syuSyouhnnm = syuMosSyouhnLst.get(0);
        BM_SyouhnZokusei syuSyouhnZokusei = bizDomManager.getSyouhnZokusei(syuSyouhnnm.getSyouhncd(), syuSyouhnnm.getSyouhnsdno());
        List<BM_SyouhnZokusei> syouhnZokuseiList = new ArrayList<>();
        syouhnZokuseiList.add(syuSyouhnZokusei);

        mosnaiCheckParam.setSyuSyouhnZokusei(syuSyouhnZokusei);
        mosnaiCheckParam.setListTkSyouhnZokusei(syouhnZokuseiList);
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setKosID("user001");
        mosnaiCheckParam.setKosTime("20160831011400000");
        mosnaiCheckParam.setSysKbn(C_SysKbn.ESHIEN);
        mosnaiCheckParam.setBosyuuSysCtrlKbn(C_BosyuusysctrlKbn.SINKIN);
        mosnaiCheckParam.setSekmossakuseiOyaAgCd("1234567");
        mosnaiCheckParam.setKiteiCheckChannelCd(C_Channelcd.TIGIN);
        mosnaiCheckParam.setNyuukinKawaseRate(BizNumber.valueOf(2.1));
        mosnaiCheckParam.setPdateSRate(BizNumber.valueOf(1.3));
        CheckSP checkSP = SWAKInjector.getInstance(CheckSP.class);
        checkSP.exec(mosnaiCheckParam);

        List<HT_HubiMsg> hubiMsgLst = mosnaiCheckParam.getListHubiMsg();
        exNumericEquals(hubiMsgLst.size(), 0, "不備メッセージ件数");

        exClassificationEquals(mosnaiCheckParam.getSekmossakuseiErroutKbn(), C_SekmossakuseiErroutKbn.GAMEN,
            "設計書申込書作成エラー出力区分");
        exStringEquals(mosnaiCheckParam.getSekmossakuseiErrmsg1(), "", "設計書申込書作成エラーメッセージ１");
        exStringEquals(mosnaiCheckParam.getSekmossakuseiErrmsg2(), "最低保険金額未達　保険料は３，８４７米ドル以上にしてください",
            "設計書申込書作成エラーメッセージ２");
        exClassificationEquals(mosnaiCheckParam.getKouzokuSyoriJikkouKbn(), C_KouzokujkKbn.NONE, "後続処理実行区分 ");
        exClassificationEquals(mosnaiCheckParam.getCheckspJissiUmuKbnSeijyou(), C_UmuKbn.NONE, "SPチェック実施済有無区分（正常終了）");
    }

    @Test
    @Transactional
    @TestOrder(135)
    public void testExec_A5_8() {

        MockObjectManager.initialize();
        KeisanGaikakanzanMockForSinkeiyaku.SYORIPTN = KeisanGaikakanzanMockForSinkeiyaku.TESTPATTERN4;
        HanteiMoschkMockForSinkeiyaku.SYORIPTN = HanteiMoschkMockForSinkeiyaku.TESTPATTERN1;
        CheckTuusanMockForSinkeiyaku.SYORIPTN = CheckTuusanMockForSinkeiyaku.TESTPATTERN2;

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("791112394");
        List<HT_MosSyouhn> syuMosSyouhnLst = syoriCTL.getMosSyouhnsBySyutkkbn(C_SyutkKbn.SYU);
        HT_MosSyouhn syuSyouhnnm = syuMosSyouhnLst.get(0);
        BM_SyouhnZokusei syuSyouhnZokusei = bizDomManager.getSyouhnZokusei(syuSyouhnnm.getSyouhncd(), syuSyouhnnm.getSyouhnsdno());
        List<BM_SyouhnZokusei> syouhnZokuseiList = new ArrayList<>();
        syouhnZokuseiList.add(syuSyouhnZokusei);

        mosnaiCheckParam.setSyuSyouhnZokusei(syuSyouhnZokusei);
        mosnaiCheckParam.setListTkSyouhnZokusei(syouhnZokuseiList);
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setKosID("user001");
        mosnaiCheckParam.setKosTime("20160831011400000");
        mosnaiCheckParam.setSysKbn(C_SysKbn.ESHIEN);
        mosnaiCheckParam.setBosyuuSysCtrlKbn(C_BosyuusysctrlKbn.SINKIN);
        mosnaiCheckParam.setSekmossakuseiOyaAgCd("1234567");
        mosnaiCheckParam.setKiteiCheckChannelCd(C_Channelcd.TIGIN);
        mosnaiCheckParam.setPdateSRate(BizNumber.valueOf(1.3));
        mosnaiCheckParam.setHrbtJyousu(BizNumber.valueOf(1.5));
        mosnaiCheckParam.setNyuukinKawaseRate(BizNumber.valueOf(2.1));
        CheckSP checkSP = SWAKInjector.getInstance(CheckSP.class);
        checkSP.exec(mosnaiCheckParam);

        List<HT_HubiMsg> hubiMsgLst = mosnaiCheckParam.getListHubiMsg();
        exNumericEquals(hubiMsgLst.size(), 0, "不備メッセージ件数");

        exClassificationEquals(mosnaiCheckParam.getSekmossakuseiErroutKbn(), C_SekmossakuseiErroutKbn.GAMEN,
            "設計書申込書作成エラー出力区分");
        exStringEquals(mosnaiCheckParam.getSekmossakuseiErrmsg1(), "", "設計書申込書作成エラーメッセージ１");
        exStringEquals(mosnaiCheckParam.getSekmossakuseiErrmsg2(), "最低保険金額未達　保険料は１，１１２円以上にしてください",
            "設計書申込書作成エラーメッセージ２");
        exClassificationEquals(mosnaiCheckParam.getKouzokuSyoriJikkouKbn(), C_KouzokujkKbn.NONE, "後続処理実行区分 ");
        exClassificationEquals(mosnaiCheckParam.getCheckspJissiUmuKbnSeijyou(), C_UmuKbn.NONE, "SPチェック実施済有無区分（正常終了）");
    }

    @Test
    @Transactional
    @TestOrder(136)
    public void testExec_A5_9() {

        MockObjectManager.initialize();
        KeisanGaikakanzanMockForSinkeiyaku.SYORIPTN = KeisanGaikakanzanMockForSinkeiyaku.TESTPATTERN1;
        HanteiMoschkMockForSinkeiyaku.SYORIPTN = HanteiMoschkMockForSinkeiyaku.TESTPATTERN1;
        CheckTuusanMockForSinkeiyaku.SYORIPTN = CheckTuusanMockForSinkeiyaku.TESTPATTERN4;

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("791112402");
        List<HT_MosSyouhn> syuMosSyouhnLst = syoriCTL.getMosSyouhnsBySyutkkbn(C_SyutkKbn.SYU);
        HT_MosSyouhn syuSyouhnnm = syuMosSyouhnLst.get(0);
        BM_SyouhnZokusei syuSyouhnZokusei = bizDomManager.getSyouhnZokusei(syuSyouhnnm.getSyouhncd(), syuSyouhnnm.getSyouhnsdno());
        List<BM_SyouhnZokusei> syouhnZokuseiList = new ArrayList<>();
        syouhnZokuseiList.add(syuSyouhnZokusei);

        mosnaiCheckParam.setSyuSyouhnZokusei(syuSyouhnZokusei);
        mosnaiCheckParam.setListTkSyouhnZokusei(syouhnZokuseiList);
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setKosID("user001");
        mosnaiCheckParam.setKosTime("20160831011400000");
        mosnaiCheckParam.setSysKbn(C_SysKbn.ESHIEN);
        mosnaiCheckParam.setBosyuuSysCtrlKbn(C_BosyuusysctrlKbn.SINKIN);
        mosnaiCheckParam.setSekmossakuseiOyaAgCd("1234567");
        mosnaiCheckParam.setKiteiCheckChannelCd(C_Channelcd.TIGIN);
        mosnaiCheckParam.setPdateSRate(BizNumber.valueOf(1.3));
        mosnaiCheckParam.setHrbtJyousu(BizNumber.valueOf(0.5));
        mosnaiCheckParam.setNyuukinKawaseRate(BizNumber.valueOf(2.1));
        CheckSP checkSP = SWAKInjector.getInstance(CheckSP.class);
        checkSP.exec(mosnaiCheckParam);

        List<HT_HubiMsg> hubiMsgLst = mosnaiCheckParam.getListHubiMsg();
        exNumericEquals(hubiMsgLst.size(), 0, "不備メッセージ件数");

        exClassificationEquals(mosnaiCheckParam.getSekmossakuseiErroutKbn(), C_SekmossakuseiErroutKbn.GAMEN,
            "設計書申込書作成エラー出力区分");
        exStringEquals(mosnaiCheckParam.getSekmossakuseiErrmsg1(), "", "設計書申込書作成エラーメッセージ１");
        exStringEquals(mosnaiCheckParam.getSekmossakuseiErrmsg2(), "最低保険金額未達　保険料は１２米ドル以上にしてください",
            "設計書申込書作成エラーメッセージ２");
        exClassificationEquals(mosnaiCheckParam.getKouzokuSyoriJikkouKbn(), C_KouzokujkKbn.NONE, "後続処理実行区分 ");
        exClassificationEquals(mosnaiCheckParam.getCheckspJissiUmuKbnSeijyou(), C_UmuKbn.NONE, "SPチェック実施済有無区分（正常終了）");
    }

    @Test
    @Transactional
    @TestOrder(137)
    public void testExec_A5_10() {

        MockObjectManager.initialize();
        HanteiMoschkMockForSinkeiyaku.SYORIPTN = HanteiMoschkMockForSinkeiyaku.TESTPATTERN1;
        CheckTuusanMockForSinkeiyaku.SYORIPTN = CheckTuusanMockForSinkeiyaku.TESTPATTERN4;

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("880000013");
        List<HT_MosSyouhn> syuMosSyouhnLst = syoriCTL.getMosSyouhnsBySyutkkbn(C_SyutkKbn.SYU);
        HT_MosSyouhn syuSyouhnnm = syuMosSyouhnLst.get(0);
        BM_SyouhnZokusei syuSyouhnZokusei = bizDomManager.getSyouhnZokusei(syuSyouhnnm.getSyouhncd(), syuSyouhnnm.getSyouhnsdno());
        List<BM_SyouhnZokusei> syouhnZokuseiList = new ArrayList<>();
        syouhnZokuseiList.add(syuSyouhnZokusei);

        mosnaiCheckParam.setSyuSyouhnZokusei(syuSyouhnZokusei);
        mosnaiCheckParam.setListTkSyouhnZokusei(syouhnZokuseiList);
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setKosID("user001");
        mosnaiCheckParam.setKosTime("20160831011400000");
        mosnaiCheckParam.setSysKbn(C_SysKbn.ESHIEN);
        mosnaiCheckParam.setBosyuuSysCtrlKbn(C_BosyuusysctrlKbn.SINKIN);
        mosnaiCheckParam.setSekmossakuseiOyaAgCd("1234567");
        mosnaiCheckParam.setKiteiCheckChannelCd(C_Channelcd.TIGIN);
        mosnaiCheckParam.setPdateSRate(BizNumber.valueOf(1.3));
        CheckSP checkSP = SWAKInjector.getInstance(CheckSP.class);
        checkSP.exec(mosnaiCheckParam);

        List<HT_HubiMsg> hubiMsgLst = mosnaiCheckParam.getListHubiMsg();
        exNumericEquals(hubiMsgLst.size(), 0, "不備メッセージ件数");

        exClassificationEquals(mosnaiCheckParam.getSekmossakuseiErroutKbn(), C_SekmossakuseiErroutKbn.GAMEN,
            "設計書申込書作成エラー出力区分");
        exStringEquals(mosnaiCheckParam.getSekmossakuseiErrmsg1(), "", "設計書申込書作成エラーメッセージ１");
        exStringEquals(mosnaiCheckParam.getSekmossakuseiErrmsg2(), "最低保険金額未達　保険料は３，８４７米ドル以上にしてください",
            "設計書申込書作成エラーメッセージ２");
        exClassificationEquals(mosnaiCheckParam.getKouzokuSyoriJikkouKbn(), C_KouzokujkKbn.NONE, "後続処理実行区分 ");
        exClassificationEquals(mosnaiCheckParam.getCheckspJissiUmuKbnSeijyou(), C_UmuKbn.NONE, "SPチェック実施済有無区分（正常終了）");
    }

    @Test
    @Transactional
    @TestOrder(140)
    public void testExec_A6() {
        MockObjectManager.initialize();
        HanteiMoschkMockForSinkeiyaku.SYORIPTN = HanteiMoschkMockForSinkeiyaku.TESTPATTERN2;
        CheckTuusanMockForSinkeiyaku.SYORIPTN = CheckTuusanMockForSinkeiyaku.TESTPATTERN1;
        CheckSaiteiPMockForSinkeiyaku.SYORIPTN = CheckSaiteiPMockForSinkeiyaku.TESTPATTERN1;

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("860000017");

        List<HT_HubiMsg> hubiMsg = syoriCTL.getHubiMsgs();
        List<HT_MosSyouhn> syuMosSyouhnLst = syoriCTL.getMosSyouhnsBySyutkkbn(C_SyutkKbn.SYU);
        HT_MosSyouhn syuSyouhnnm = syuMosSyouhnLst.get(0);
        BM_SyouhnZokusei syuSyouhnZokusei = bizDomManager.getSyouhnZokusei(syuSyouhnnm.getSyouhncd(), syuSyouhnnm.getSyouhnsdno());
        List<BM_SyouhnZokusei> syouhnZokuseiList = new ArrayList<>();
        syouhnZokuseiList.add(syuSyouhnZokusei);

        mosnaiCheckParam.setSyuSyouhnZokusei(syuSyouhnZokusei);
        mosnaiCheckParam.setListTkSyouhnZokusei(syouhnZokuseiList);
        mosnaiCheckParam.setListHubiMsg(hubiMsg);
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setKosID("user001");
        mosnaiCheckParam.setKosTime("20160831011400000");
        mosnaiCheckParam.setSysKbn(C_SysKbn.SKEI);
        CheckSP checkSP = SWAKInjector.getInstance(CheckSP.class);
        checkSP.exec(mosnaiCheckParam);

        List<HT_HubiMsg> hubiMsgLst = mosnaiCheckParam.getListHubiMsg();
        exNumericEquals(hubiMsgLst.size(), 2, "不備メッセージテーブルエンティティリスト件数");
        exStringEquals(hubiMsgLst.get(0).getMosno(), "860000017", "申込番号");
        exNumericEquals(hubiMsgLst.get(0).getRenno(), 1, "連番");
        exStringEquals(hubiMsgLst.get(0).getMessageId(), "EHC1110", "メッセージＩＤ");
        exStringEquals(hubiMsgLst.get(0).getHubimsg(), "定期一括払保険料が相違しています。　定期一括払保険料　１，０００円", "不備メッセージ");
        exClassificationEquals(hubiMsgLst.get(0).getHubisyubetukbn(), C_HubisyubetuKbn.KETHORYU_HUBI, "不備種別区分");

        exStringEquals(hubiMsgLst.get(1).getMosno(), "860000017", "申込番号");
        exNumericEquals(hubiMsgLst.get(1).getRenno(), 2, "連番");
        exStringEquals(hubiMsgLst.get(1).getMessageId(), "EHC1110", "メッセージＩＤ");
        exStringEquals(hubiMsgLst.get(1).getHubimsg(), "前納保険料が相違しています。　前納保険料　１１，０００円", "不備メッセージ");
        exClassificationEquals(hubiMsgLst.get(1).getHubisyubetukbn(), C_HubisyubetuKbn.KETHORYU_HUBI, "不備種別区分");
        exClassificationEquals(mosnaiCheckParam.getCheckspJissiUmuKbnSeijyou(), C_UmuKbn.NONE, "SPチェック実施済有無区分（正常終了）");
    }

    @Test
    @Transactional
    @TestOrder(150)
    public void testExec_A7() {
        MockObjectManager.initialize();
        HanteiMoschkMockForSinkeiyaku.SYORIPTN = HanteiMoschkMockForSinkeiyaku.TESTPATTERN2;
        CheckTuusanMockForSinkeiyaku.SYORIPTN = CheckTuusanMockForSinkeiyaku.TESTPATTERN2;
        CheckSaiteiPMockForSinkeiyaku.SYORIPTN = CheckSaiteiPMockForSinkeiyaku.TESTPATTERN1;

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("860000025");

        List<HT_HubiMsg> hubiMsg = syoriCTL.getHubiMsgs();
        List<HT_MosSyouhn> syuMosSyouhnLst = syoriCTL.getMosSyouhnsBySyutkkbn(C_SyutkKbn.SYU);
        HT_MosSyouhn syuSyouhnnm = syuMosSyouhnLst.get(0);
        BM_SyouhnZokusei syuSyouhnZokusei = bizDomManager.getSyouhnZokusei(syuSyouhnnm.getSyouhncd(), syuSyouhnnm.getSyouhnsdno());
        List<BM_SyouhnZokusei> syouhnZokuseiList = new ArrayList<>();
        syouhnZokuseiList.add(syuSyouhnZokusei);

        mosnaiCheckParam.setSyuSyouhnZokusei(syuSyouhnZokusei);
        mosnaiCheckParam.setListTkSyouhnZokusei(syouhnZokuseiList);
        mosnaiCheckParam.setListHubiMsg(hubiMsg);
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setKosID("user001");
        mosnaiCheckParam.setKosTime("20160831011400000");
        mosnaiCheckParam.setSysKbn(C_SysKbn.SKEI);
        CheckSP checkSP = SWAKInjector.getInstance(CheckSP.class);
        checkSP.exec(mosnaiCheckParam);

        List<HT_HubiMsg> hubiMsgLst = mosnaiCheckParam.getListHubiMsg();
        exNumericEquals(hubiMsgLst.size(), 2, "不備メッセージテーブルエンティティリスト件数");
        exStringEquals(hubiMsgLst.get(0).getMosno(), "860000025", "申込番号");
        exNumericEquals(hubiMsgLst.get(0).getRenno(), 1, "連番");
        exStringEquals(hubiMsgLst.get(0).getMessageId(), "EHC1062", "メッセージＩＤ");
        exStringEquals(hubiMsgLst.get(0).getHubimsg(), "商品名２の年金原資額が最高年金原資額の０円をオーバーしています。", "不備メッセージ");
        exClassificationEquals(hubiMsgLst.get(0).getHubisyubetukbn(), C_HubisyubetuKbn.KETHORYU_HUBI, "不備種別区分");

        exStringEquals(hubiMsgLst.get(1).getMosno(), "860000025", "申込番号");
        exNumericEquals(hubiMsgLst.get(1).getRenno(), 2, "連番");
        exStringEquals(hubiMsgLst.get(1).getMessageId(), "EHC1110", "メッセージＩＤ");
        exStringEquals(hubiMsgLst.get(1).getHubimsg(), "定期一括払保険料が相違しています。　定期一括払保険料　１，０００円", "不備メッセージ");
        exClassificationEquals(hubiMsgLst.get(1).getHubisyubetukbn(), C_HubisyubetuKbn.KETHORYU_HUBI, "不備種別区分");

    }

    @Test
    @Transactional
    @TestOrder(160)
    public void testExec_A8() {
        MockObjectManager.initialize();
        HanteiMoschkMockForSinkeiyaku.SYORIPTN = HanteiMoschkMockForSinkeiyaku.TESTPATTERN2;
        CheckTuusanMockForSinkeiyaku.SYORIPTN = CheckTuusanMockForSinkeiyaku.TESTPATTERN2;
        CheckSaiteiPMockForSinkeiyaku.SYORIPTN = CheckSaiteiPMockForSinkeiyaku.TESTPATTERN1;

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("860000033");

        List<HT_HubiMsg> hubiMsg = syoriCTL.getHubiMsgs();
        List<HT_MosSyouhn> syuMosSyouhnLst = syoriCTL.getMosSyouhnsBySyutkkbn(C_SyutkKbn.SYU);
        HT_MosSyouhn syuSyouhnnm = syuMosSyouhnLst.get(0);
        BM_SyouhnZokusei syuSyouhnZokusei = bizDomManager.getSyouhnZokusei(syuSyouhnnm.getSyouhncd(), syuSyouhnnm.getSyouhnsdno());
        List<BM_SyouhnZokusei> syouhnZokuseiList = new ArrayList<>();
        syouhnZokuseiList.add(syuSyouhnZokusei);

        mosnaiCheckParam.setSyuSyouhnZokusei(syuSyouhnZokusei);
        mosnaiCheckParam.setListTkSyouhnZokusei(syouhnZokuseiList);
        mosnaiCheckParam.setListHubiMsg(hubiMsg);
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setKosID("user001");
        mosnaiCheckParam.setKosTime("20160831011400000");
        mosnaiCheckParam.setSysKbn(C_SysKbn.SKEI);
        CheckSP checkSP = SWAKInjector.getInstance(CheckSP.class);
        checkSP.exec(mosnaiCheckParam);

        List<HT_HubiMsg> hubiMsgLst = mosnaiCheckParam.getListHubiMsg();
        exNumericEquals(hubiMsgLst.size(), 0, "不備メッセージテーブルエンティティリスト件数");
    }

    @Test
    @Transactional
    @TestOrder(170)
    public void testExec_A9() {
        MockObjectManager.initialize();
        HanteiMoschkMockForSinkeiyaku.SYORIPTN = HanteiMoschkMockForSinkeiyaku.TESTPATTERN2;
        CheckTuusanMockForSinkeiyaku.SYORIPTN = CheckTuusanMockForSinkeiyaku.TESTPATTERN2;
        CheckSaiteiPMockForSinkeiyaku.SYORIPTN = CheckSaiteiPMockForSinkeiyaku.TESTPATTERN1;

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("860000041");

        List<HT_HubiMsg> hubiMsg = syoriCTL.getHubiMsgs();
        List<HT_MosSyouhn> syuMosSyouhnLst = syoriCTL.getMosSyouhnsBySyutkkbn(C_SyutkKbn.SYU);
        HT_MosSyouhn syuSyouhnnm = syuMosSyouhnLst.get(0);
        BM_SyouhnZokusei syuSyouhnZokusei = bizDomManager.getSyouhnZokusei(syuSyouhnnm.getSyouhncd(), syuSyouhnnm.getSyouhnsdno());
        List<BM_SyouhnZokusei> syouhnZokuseiList = new ArrayList<>();
        syouhnZokuseiList.add(syuSyouhnZokusei);

        mosnaiCheckParam.setSyuSyouhnZokusei(syuSyouhnZokusei);
        mosnaiCheckParam.setListTkSyouhnZokusei(syouhnZokuseiList);
        mosnaiCheckParam.setListHubiMsg(hubiMsg);
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setKosID("user001");
        mosnaiCheckParam.setKosTime("20160831011400000");
        mosnaiCheckParam.setSysKbn(C_SysKbn.SKEI);
        CheckSP checkSP = SWAKInjector.getInstance(CheckSP.class);
        checkSP.exec(mosnaiCheckParam);

        List<HT_HubiMsg> hubiMsgLst = mosnaiCheckParam.getListHubiMsg();
        exNumericEquals(hubiMsgLst.size(), 0, "不備メッセージテーブルエンティティリスト件数");
    }

    @Test
    @Transactional
    @TestOrder(180)
    public void testExec_A10() {
        MockObjectManager.initialize();
        HanteiMoschkMockForSinkeiyaku.SYORIPTN = HanteiMoschkMockForSinkeiyaku.TESTPATTERN2;
        CheckTuusanMockForSinkeiyaku.SYORIPTN = CheckTuusanMockForSinkeiyaku.TESTPATTERN1;
        CheckSaiteiPMockForSinkeiyaku.SYORIPTN = CheckSaiteiPMockForSinkeiyaku.TESTPATTERN1;

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("860000058");

        List<HT_HubiMsg> hubiMsg = syoriCTL.getHubiMsgs();
        List<HT_MosSyouhn> syuMosSyouhnLst = syoriCTL.getMosSyouhnsBySyutkkbn(C_SyutkKbn.SYU);
        HT_MosSyouhn syuSyouhnnm = syuMosSyouhnLst.get(0);
        BM_SyouhnZokusei syuSyouhnZokusei = bizDomManager.getSyouhnZokusei(syuSyouhnnm.getSyouhncd(), syuSyouhnnm.getSyouhnsdno());
        List<BM_SyouhnZokusei> syouhnZokuseiList = new ArrayList<>();
        syouhnZokuseiList.add(syuSyouhnZokusei);

        mosnaiCheckParam.setSyuSyouhnZokusei(syuSyouhnZokusei);
        mosnaiCheckParam.setListTkSyouhnZokusei(syouhnZokuseiList);
        mosnaiCheckParam.setListHubiMsg(hubiMsg);
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setKosID("user001");
        mosnaiCheckParam.setKosTime("20160831011400000");
        mosnaiCheckParam.setSysKbn(C_SysKbn.ESHIEN);
        CheckSP checkSP = SWAKInjector.getInstance(CheckSP.class);
        checkSP.exec(mosnaiCheckParam);

        List<HT_HubiMsg> hubiMsgLst = mosnaiCheckParam.getListHubiMsg();
        exNumericEquals(hubiMsgLst.size(), 0, "不備メッセージ件数");

        exClassificationEquals(mosnaiCheckParam.getSekmossakuseiErroutKbn(), C_SekmossakuseiErroutKbn.GAMEN,
            "設計書申込書作成エラー出力区分");
        exStringEquals(mosnaiCheckParam.getSekmossakuseiErrmsg1(), "", "設計書申込書作成エラーメッセージ１");
        exStringEquals(mosnaiCheckParam.getSekmossakuseiErrmsg2(), "最高年金原資額を超えています　保険料は０円までにしてください",
            "設計書申込書作成エラーメッセージ２");
        exClassificationEquals(mosnaiCheckParam.getKouzokuSyoriJikkouKbn(), C_KouzokujkKbn.NONE, "後続処理実行区分 ");
        exClassificationEquals(mosnaiCheckParam.getCheckspJissiUmuKbnSeijyou(), C_UmuKbn.NONE, "SPチェック実施済有無区分（正常終了）");
    }

    @Test
    @Transactional
    @TestOrder(190)
    public void testExec_A11() {
        MockObjectManager.initialize();
        HanteiMoschkMockForSinkeiyaku.SYORIPTN = HanteiMoschkMockForSinkeiyaku.TESTPATTERN2;
        CheckTuusanMockForSinkeiyaku.SYORIPTN = CheckTuusanMockForSinkeiyaku.TESTPATTERN2;
        KeisanGaikakanzanMockForSinkeiyaku.SYORIPTN = KeisanGaikakanzanMockForSinkeiyaku.TESTPATTERN2;
        CheckSaiteiPMockForSinkeiyaku.SYORIPTN = CheckSaiteiPMockForSinkeiyaku.TESTPATTERN1;

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("860000066");

        List<HT_HubiMsg> hubiMsg = syoriCTL.getHubiMsgs();
        List<HT_MosSyouhn> syuMosSyouhnLst = syoriCTL.getMosSyouhnsBySyutkkbn(C_SyutkKbn.SYU);
        HT_MosSyouhn syuSyouhnnm = syuMosSyouhnLst.get(0);
        BM_SyouhnZokusei syuSyouhnZokusei = bizDomManager.getSyouhnZokusei(syuSyouhnnm.getSyouhncd(), syuSyouhnnm.getSyouhnsdno());
        List<BM_SyouhnZokusei> syouhnZokuseiList = new ArrayList<>();
        syouhnZokuseiList.add(syuSyouhnZokusei);

        mosnaiCheckParam.setSyuSyouhnZokusei(syuSyouhnZokusei);
        mosnaiCheckParam.setListTkSyouhnZokusei(syouhnZokuseiList);
        mosnaiCheckParam.setListHubiMsg(hubiMsg);
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setKosID("user001");
        mosnaiCheckParam.setKosTime("20160831011400000");
        mosnaiCheckParam.setSysKbn(C_SysKbn.ESHIEN);
        mosnaiCheckParam.setBosyuuSysCtrlKbn(C_BosyuusysctrlKbn.SMBC);
        CheckSP checkSP = SWAKInjector.getInstance(CheckSP.class);
        checkSP.exec(mosnaiCheckParam);

        List<HT_HubiMsg> hubiMsgLst = mosnaiCheckParam.getListHubiMsg();
        exNumericEquals(hubiMsgLst.size(), 0, "不備メッセージ件数");

        exClassificationEquals(mosnaiCheckParam.getSekmossakuseiErroutKbn(), C_SekmossakuseiErroutKbn.GAMEN,
            "設計書申込書作成エラー出力区分");
        exStringEquals(mosnaiCheckParam.getSekmossakuseiErrmsg1(), "", "設計書申込書作成エラーメッセージ１");
        exStringEquals(mosnaiCheckParam.getSekmossakuseiErrmsg2(), "最高年金原資額を超えています　払込金額は９，９９９円までにしてください",
            "設計書申込書作成エラーメッセージ２");
        exClassificationEquals(mosnaiCheckParam.getKouzokuSyoriJikkouKbn(), C_KouzokujkKbn.NONE, "後続処理実行区分 ");

        MockObjectManager.assertArgumentPassed(CheckTuusanMockForSinkeiyaku.class, "getGndHaninaiPbyItjbrSouhrkp", 0, syoriCTL);
        MockObjectManager.assertArgumentPassed(CheckTuusanMockForSinkeiyaku.class, "getGndHaninaiPbyItjbrSouhrkp", 1, syoriCTL.getMosKihon());
        MockObjectManager.assertArgumentPassed(CheckTuusanMockForSinkeiyaku.class, "getGndHaninaiPbyItjbrSouhrkp", 2, syoriCTL.getMosSyouhns().get(0));
        MockObjectManager.assertArgumentPassed(CheckTuusanMockForSinkeiyaku.class, "getGndHaninaiPbyItjbrSouhrkp", 3, C_Channelcd.BLNK);
        MockObjectManager.assertArgumentPassed(CheckTuusanMockForSinkeiyaku.class, "getGndHaninaiPbyItjbrSouhrkp", 4, BizCurrency.valueOf(0));
        MockObjectManager.assertArgumentPassed(CheckTuusanMockForSinkeiyaku.class, "getGndHaninaiPbyItjbrSouhrkp", 5, C_UmuKbn.NONE);

    }

    @Test(expected = CommonBizAppException.class)
    @Transactional
    @TestOrder(200)
    public void testExec_A12() {
        MockObjectManager.initialize();
        HanteiMoschkMockForSinkeiyaku.SYORIPTN = HanteiMoschkMockForSinkeiyaku.TESTPATTERN2;
        CheckSaiteiPMockForSinkeiyaku.SYORIPTN = CheckSaiteiPMockForSinkeiyaku.TESTPATTERN1;

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("860000074");

        List<HT_HubiMsg> hubiMsg = syoriCTL.getHubiMsgs();
        List<HT_MosSyouhn> syuMosSyouhnLst = syoriCTL.getMosSyouhnsBySyutkkbn(C_SyutkKbn.SYU);
        HT_MosSyouhn syuSyouhnnm = syuMosSyouhnLst.get(0);
        BM_SyouhnZokusei syuSyouhnZokusei = bizDomManager.getSyouhnZokusei(syuSyouhnnm.getSyouhncd(), syuSyouhnnm.getSyouhnsdno());
        List<BM_SyouhnZokusei> syouhnZokuseiList = new ArrayList<>();
        syouhnZokuseiList.add(syuSyouhnZokusei);

        mosnaiCheckParam.setSyuSyouhnZokusei(syuSyouhnZokusei);
        mosnaiCheckParam.setListTkSyouhnZokusei(syouhnZokuseiList);
        mosnaiCheckParam.setListHubiMsg(hubiMsg);
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setKosID("user001");
        mosnaiCheckParam.setKosTime("20160831011400000");
        mosnaiCheckParam.setSysKbn(C_SysKbn.ESHIEN);

        try {
            CheckSP checkSP = SWAKInjector.getInstance(CheckSP.class);
            checkSP.exec(mosnaiCheckParam);
        } catch (CommonBizAppException e) {
            exStringEquals(e.getMessage(), "システム整合性エラーです。年金原資本件チェックマスタにデータが存在しません。", "エラーメッセージ");
            throw e;
        }
    }

    @Test
    @Transactional
    @TestOrder(210)
    public void testExec_A13() {
        MockObjectManager.initialize();
        HanteiMoschkMockForSinkeiyaku.SYORIPTN = HanteiMoschkMockForSinkeiyaku.TESTPATTERN2;
        CheckTuusanMockForSinkeiyaku.SYORIPTN = CheckTuusanMockForSinkeiyaku.TESTPATTERN2;
        CheckSaiteiPMockForSinkeiyaku.SYORIPTN = CheckSaiteiPMockForSinkeiyaku.TESTPATTERN1;

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("870000429");

        List<HT_HubiMsg> hubiMsg = syoriCTL.getHubiMsgs();
        List<HT_MosSyouhn> syuMosSyouhnLst = syoriCTL.getMosSyouhnsBySyutkkbn(C_SyutkKbn.SYU);
        HT_MosSyouhn syuSyouhnnm = syuMosSyouhnLst.get(0);
        BM_SyouhnZokusei syuSyouhnZokusei = bizDomManager.getSyouhnZokusei(syuSyouhnnm.getSyouhncd(), syuSyouhnnm.getSyouhnsdno());
        List<BM_SyouhnZokusei> syouhnZokuseiList = new ArrayList<>();
        syouhnZokuseiList.add(syuSyouhnZokusei);

        mosnaiCheckParam.setSyuSyouhnZokusei(syuSyouhnZokusei);
        mosnaiCheckParam.setListTkSyouhnZokusei(syouhnZokuseiList);
        mosnaiCheckParam.setListHubiMsg(hubiMsg);
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setKosID("user001");
        mosnaiCheckParam.setKosTime("20160831011400000");
        mosnaiCheckParam.setSysKbn(C_SysKbn.SKEI);
        CheckSP checkSP = SWAKInjector.getInstance(CheckSP.class);
        checkSP.exec(mosnaiCheckParam);

        List<HT_HubiMsg> hubiMsgLst = mosnaiCheckParam.getListHubiMsg();
        exNumericEquals(hubiMsgLst.size(), 1, "不備メッセージ件数");
        exStringEquals(hubiMsgLst.get(0).getMosno(), "870000429", "申込番号");
        exNumericEquals(hubiMsgLst.get(0).getRenno(), 1, "連番");
        exStringEquals(hubiMsgLst.get(0).getMessageId(), "EHC1039", "メッセージＩＤ");
        exStringEquals(hubiMsgLst.get(0).getHubimsg(), "円換算処理でエラーが発生しました。年金原資限度額（本件）チェックが未実施です。", "不備メッセージ");
        exClassificationEquals(hubiMsgLst.get(0).getHubisyubetukbn(), C_HubisyubetuKbn.KETHORYU_HUBI, "不備種別区分");
    }

    @Test
    @Transactional
    @TestOrder(220)
    public void testExec_A14() {
        MockObjectManager.initialize();
        HanteiMoschkMockForSinkeiyaku.SYORIPTN = HanteiMoschkMockForSinkeiyaku.TESTPATTERN2;
        CheckTuusanMockForSinkeiyaku.SYORIPTN = CheckTuusanMockForSinkeiyaku.TESTPATTERN2;
        CheckSaiteiPMockForSinkeiyaku.SYORIPTN = CheckSaiteiPMockForSinkeiyaku.TESTPATTERN1;

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("870000452");

        List<HT_HubiMsg> hubiMsg = syoriCTL.getHubiMsgs();
        List<HT_MosSyouhn> syuMosSyouhnLst = syoriCTL.getMosSyouhnsBySyutkkbn(C_SyutkKbn.SYU);
        HT_MosSyouhn syuSyouhnnm = syuMosSyouhnLst.get(0);
        BM_SyouhnZokusei syuSyouhnZokusei = bizDomManager.getSyouhnZokusei(syuSyouhnnm.getSyouhncd(), syuSyouhnnm.getSyouhnsdno());
        List<BM_SyouhnZokusei> syouhnZokuseiList = new ArrayList<>();
        syouhnZokuseiList.add(syuSyouhnZokusei);

        mosnaiCheckParam.setSyuSyouhnZokusei(syuSyouhnZokusei);
        mosnaiCheckParam.setListTkSyouhnZokusei(syouhnZokuseiList);
        mosnaiCheckParam.setListHubiMsg(hubiMsg);
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setKosID("user001");
        mosnaiCheckParam.setKosTime("20160831011400000");
        mosnaiCheckParam.setSysKbn(C_SysKbn.SKEI);
        CheckSP checkSP = SWAKInjector.getInstance(CheckSP.class);
        checkSP.exec(mosnaiCheckParam);

        List<HT_HubiMsg> hubiMsgLst = mosnaiCheckParam.getListHubiMsg();
        exNumericEquals(hubiMsgLst.size(), 1, "不備メッセージ件数");
        exStringEquals(hubiMsgLst.get(0).getMosno(), "870000452", "申込番号");
        exNumericEquals(hubiMsgLst.get(0).getRenno(), 1, "連番");
        exStringEquals(hubiMsgLst.get(0).getMessageId(), "EHC1039", "メッセージＩＤ");
        exStringEquals(hubiMsgLst.get(0).getHubimsg(), "円換算処理でエラーが発生しました。年金原資限度額（本件）チェックが未実施です。", "不備メッセージ");
        exClassificationEquals(hubiMsgLst.get(0).getHubisyubetukbn(), C_HubisyubetuKbn.KETHORYU_HUBI, "不備種別区分");
    }

    @Test
    @Transactional
    @TestOrder(230)
    public void testExec_A15() {
        MockObjectManager.initialize();
        HanteiMoschkMockForSinkeiyaku.SYORIPTN = HanteiMoschkMockForSinkeiyaku.TESTPATTERN2;
        CheckTuusanMockForSinkeiyaku.SYORIPTN = CheckTuusanMockForSinkeiyaku.TESTPATTERN2;
        CheckSaiteiPMockForSinkeiyaku.SYORIPTN = CheckSaiteiPMockForSinkeiyaku.TESTPATTERN1;

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("870000395");

        List<HT_HubiMsg> hubiMsg = syoriCTL.getHubiMsgs();
        List<HT_MosSyouhn> syuMosSyouhnLst = syoriCTL.getMosSyouhnsBySyutkkbn(C_SyutkKbn.SYU);
        HT_MosSyouhn syuSyouhnnm = syuMosSyouhnLst.get(0);
        BM_SyouhnZokusei syuSyouhnZokusei = bizDomManager.getSyouhnZokusei(syuSyouhnnm.getSyouhncd(), syuSyouhnnm.getSyouhnsdno());
        List<BM_SyouhnZokusei> syouhnZokuseiList = new ArrayList<>();
        syouhnZokuseiList.add(syuSyouhnZokusei);

        mosnaiCheckParam.setSyuSyouhnZokusei(syuSyouhnZokusei);
        mosnaiCheckParam.setListTkSyouhnZokusei(syouhnZokuseiList);
        mosnaiCheckParam.setListHubiMsg(hubiMsg);
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setKosID("user001");
        mosnaiCheckParam.setKosTime("20160831011400000");
        mosnaiCheckParam.setSysKbn(C_SysKbn.ESHIEN);
        CheckSP checkSP = SWAKInjector.getInstance(CheckSP.class);
        checkSP.exec(mosnaiCheckParam);

        List<HT_HubiMsg> hubiMsgLst = mosnaiCheckParam.getListHubiMsg();
        exNumericEquals(hubiMsgLst.size(), 0, "不備メッセージ件数");

        exClassificationEquals(mosnaiCheckParam.getSekmossakuseiErroutKbn(), C_SekmossakuseiErroutKbn.GAMEN,
            "設計書申込書作成エラー出力区分");
        exStringEquals(mosnaiCheckParam.getSekmossakuseiErrmsg1(), "", "設計書申込書作成エラーメッセージ１");
        exStringEquals(mosnaiCheckParam.getSekmossakuseiErrmsg2(), "システム障害が発生しています。サポートデスクへお問い合わせください。",
            "設計書申込書作成エラーメッセージ２");
        exClassificationEquals(mosnaiCheckParam.getKouzokuSyoriJikkouKbn(), C_KouzokujkKbn.NONE, "後続処理実行区分 ");
        exClassificationEquals(mosnaiCheckParam.getCheckspJissiUmuKbnSeijyou(), C_UmuKbn.NONE, "SPチェック実施済有無区分（正常終了）");
    }

    @Test
    @Transactional
    @TestOrder(240)
    public void testExec_A16() {
        MockObjectManager.initialize();

        HanteiMoschkMockForSinkeiyaku.SYORIPTN = HanteiMoschkMockForSinkeiyaku.TESTPATTERN2;
        CheckTuusanMockForSinkeiyaku.SYORIPTN = CheckTuusanMockForSinkeiyaku.TESTPATTERN1;
        CheckSaiteiPMockForSinkeiyaku.SYORIPTN = CheckSaiteiPMockForSinkeiyaku.TESTPATTERN1;
        KeisanGaikakanzanMockForSinkeiyaku.SYORIPTN = KeisanGaikakanzanMockForSinkeiyaku.TESTPATTERN2;

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("870000411");

        List<HT_HubiMsg> hubiMsg = syoriCTL.getHubiMsgs();
        List<HT_MosSyouhn> syuMosSyouhnLst = syoriCTL.getMosSyouhnsBySyutkkbn(C_SyutkKbn.SYU);
        HT_MosSyouhn syuSyouhnnm = syuMosSyouhnLst.get(0);
        BM_SyouhnZokusei syuSyouhnZokusei = bizDomManager.getSyouhnZokusei(syuSyouhnnm.getSyouhncd(), syuSyouhnnm.getSyouhnsdno());
        List<BM_SyouhnZokusei> syouhnZokuseiList = new ArrayList<>();
        syouhnZokuseiList.add(syuSyouhnZokusei);

        mosnaiCheckParam.setSyuSyouhnZokusei(syuSyouhnZokusei);
        mosnaiCheckParam.setListTkSyouhnZokusei(syouhnZokuseiList);
        mosnaiCheckParam.setListHubiMsg(hubiMsg);
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setKosID("user001");
        mosnaiCheckParam.setKosTime("20160831011400000");
        mosnaiCheckParam.setSysKbn(C_SysKbn.ESHIEN);
        CheckSP checkSP = SWAKInjector.getInstance(CheckSP.class);
        checkSP.exec(mosnaiCheckParam);

        List<HT_HubiMsg> hubiMsgLst = mosnaiCheckParam.getListHubiMsg();
        exNumericEquals(hubiMsgLst.size(), 0, "不備メッセージ件数");

        exClassificationEquals(mosnaiCheckParam.getSekmossakuseiErroutKbn(), C_SekmossakuseiErroutKbn.GAMEN,
            "設計書申込書作成エラー出力区分");
        exStringEquals(mosnaiCheckParam.getSekmossakuseiErrmsg1(), "", "設計書申込書作成エラーメッセージ１");
        exStringEquals(mosnaiCheckParam.getSekmossakuseiErrmsg2(), "最高年金原資額を超えています　保険料は０円までにしてください",
            "設計書申込書作成エラーメッセージ２");
        exClassificationEquals(mosnaiCheckParam.getKouzokuSyoriJikkouKbn(), C_KouzokujkKbn.NONE, "後続処理実行区分 ");

    }

    @Test
    @Transactional
    @TestOrder(250)
    public void testExec_A17() {
        MockObjectManager.initialize();

        HanteiMoschkMockForSinkeiyaku.SYORIPTN = HanteiMoschkMockForSinkeiyaku.TESTPATTERN4;
        CheckTuusanMockForSinkeiyaku.SYORIPTN = CheckTuusanMockForSinkeiyaku.TESTPATTERN1;
        CheckSaiteiPMockForSinkeiyaku.SYORIPTN = CheckSaiteiPMockForSinkeiyaku.TESTPATTERN1;

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("860000231");

        List<HT_HubiMsg> hubiMsg = syoriCTL.getHubiMsgs();
        List<HT_MosSyouhn> syuMosSyouhnLst = syoriCTL.getMosSyouhnsBySyutkkbn(C_SyutkKbn.SYU);
        HT_MosSyouhn syuSyouhnnm = syuMosSyouhnLst.get(0);
        BM_SyouhnZokusei syuSyouhnZokusei = bizDomManager.getSyouhnZokusei(syuSyouhnnm.getSyouhncd(), syuSyouhnnm.getSyouhnsdno());
        List<BM_SyouhnZokusei> syouhnZokuseiList = new ArrayList<>();
        syouhnZokuseiList.add(syuSyouhnZokusei);

        mosnaiCheckParam.setSyuSyouhnZokusei(syuSyouhnZokusei);
        mosnaiCheckParam.setListTkSyouhnZokusei(syouhnZokuseiList);
        mosnaiCheckParam.setListHubiMsg(hubiMsg);
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setKosID("user001");
        mosnaiCheckParam.setKosTime("20160831011400000");
        mosnaiCheckParam.setSysKbn(C_SysKbn.ESHIEN);
        CheckSP checkSP = SWAKInjector.getInstance(CheckSP.class);
        checkSP.exec(mosnaiCheckParam);

        List<HT_HubiMsg> hubiMsgLst = mosnaiCheckParam.getListHubiMsg();
        exNumericEquals(hubiMsgLst.size(), 0, "不備メッセージ件数");

        exClassificationEquals(mosnaiCheckParam.getSekmossakuseiErroutKbn(), C_SekmossakuseiErroutKbn.NONE,
            "設計書申込書作成エラー出力区分");
        exStringEquals(mosnaiCheckParam.getSekmossakuseiErrmsg1(), "", "設計書申込書作成エラーメッセージ１");
        exStringEquals(mosnaiCheckParam.getSekmossakuseiErrmsg2(), "", "設計書申込書作成エラーメッセージ２");
        exClassificationEquals(mosnaiCheckParam.getKouzokuSyoriJikkouKbn(), C_KouzokujkKbn.JIKKOU, "後続処理実行区分 ");
    }

    @Test
    @Transactional
    @TestOrder(260)
    public void testExec_A18() {
        MockObjectManager.initialize();

        HanteiMoschkMockForSinkeiyaku.SYORIPTN = HanteiMoschkMockForSinkeiyaku.TESTPATTERN3;
        CheckTuusanMockForSinkeiyaku.SYORIPTN = CheckTuusanMockForSinkeiyaku.TESTPATTERN1;
        CheckSaiteiPMockForSinkeiyaku.SYORIPTN = CheckSaiteiPMockForSinkeiyaku.TESTPATTERN1;

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("860000249");

        List<HT_HubiMsg> hubiMsg = syoriCTL.getHubiMsgs();
        List<HT_MosSyouhn> syuMosSyouhnLst = syoriCTL.getMosSyouhnsBySyutkkbn(C_SyutkKbn.SYU);
        HT_MosSyouhn syuSyouhnnm = syuMosSyouhnLst.get(0);
        BM_SyouhnZokusei syuSyouhnZokusei = bizDomManager.getSyouhnZokusei(syuSyouhnnm.getSyouhncd(), syuSyouhnnm.getSyouhnsdno());
        List<BM_SyouhnZokusei> syouhnZokuseiList = new ArrayList<>();
        syouhnZokuseiList.add(syuSyouhnZokusei);

        mosnaiCheckParam.setSyuSyouhnZokusei(syuSyouhnZokusei);
        mosnaiCheckParam.setListTkSyouhnZokusei(syouhnZokuseiList);
        mosnaiCheckParam.setListHubiMsg(hubiMsg);
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setKosID("user001");
        mosnaiCheckParam.setKosTime("20160831011400000");
        mosnaiCheckParam.setSysKbn(C_SysKbn.ESHIEN);
        CheckSP checkSP = SWAKInjector.getInstance(CheckSP.class);
        checkSP.exec(mosnaiCheckParam);

        List<HT_HubiMsg> hubiMsgLst = mosnaiCheckParam.getListHubiMsg();
        exNumericEquals(hubiMsgLst.size(), 0, "不備メッセージ件数");

        exClassificationEquals(mosnaiCheckParam.getSekmossakuseiErroutKbn(), C_SekmossakuseiErroutKbn.NONE,
            "設計書申込書作成エラー出力区分");
        exStringEquals(mosnaiCheckParam.getSekmossakuseiErrmsg1(), "", "設計書申込書作成エラーメッセージ１");
        exStringEquals(mosnaiCheckParam.getSekmossakuseiErrmsg2(), "", "設計書申込書作成エラーメッセージ２");
        exClassificationEquals(mosnaiCheckParam.getKouzokuSyoriJikkouKbn(), C_KouzokujkKbn.JIKKOU, "後続処理実行区分 ");
    }

    @Test
    @Transactional
    @TestOrder(270)
    public void testExec_A19() {
        MockObjectManager.initialize();

        HanteiMoschkMockForSinkeiyaku.SYORIPTN = HanteiMoschkMockForSinkeiyaku.TESTPATTERN3;
        CheckTuusanMockForSinkeiyaku.SYORIPTN = CheckTuusanMockForSinkeiyaku.TESTPATTERN1;
        CheckSaiteiPMockForSinkeiyaku.SYORIPTN = CheckSaiteiPMockForSinkeiyaku.TESTPATTERN1;

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("860000256");

        List<HT_HubiMsg> hubiMsg = syoriCTL.getHubiMsgs();
        List<HT_MosSyouhn> syuMosSyouhnLst = syoriCTL.getMosSyouhnsBySyutkkbn(C_SyutkKbn.SYU);
        HT_MosSyouhn syuSyouhnnm = syuMosSyouhnLst.get(0);
        BM_SyouhnZokusei syuSyouhnZokusei = bizDomManager.getSyouhnZokusei(syuSyouhnnm.getSyouhncd(), syuSyouhnnm.getSyouhnsdno());
        List<BM_SyouhnZokusei> syouhnZokuseiList = new ArrayList<>();
        syouhnZokuseiList.add(syuSyouhnZokusei);

        mosnaiCheckParam.setSyuSyouhnZokusei(syuSyouhnZokusei);
        mosnaiCheckParam.setListTkSyouhnZokusei(syouhnZokuseiList);
        mosnaiCheckParam.setListHubiMsg(hubiMsg);
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setKosID("user001");
        mosnaiCheckParam.setKosTime("20160831011400000");
        mosnaiCheckParam.setSysKbn(C_SysKbn.SKEI);
        CheckSP checkSP = SWAKInjector.getInstance(CheckSP.class);
        checkSP.exec(mosnaiCheckParam);


        List<HT_HubiMsg> hubiMsgLst = mosnaiCheckParam.getListHubiMsg();
        exNumericEquals(hubiMsgLst.size(), 1, "不備メッセージ件数");
        exStringEquals(hubiMsgLst.get(0).getMosno(), "860000256", "申込番号");
        exNumericEquals(hubiMsgLst.get(0).getRenno(), 1, "連番");
        exStringEquals(hubiMsgLst.get(0).getMessageId(), "EHC1039", "メッセージＩＤ");
        exStringEquals(hubiMsgLst.get(0).getHubimsg(), "円換算処理でエラーが発生しました。最高保険金額（ＳＰ）チェックが未実施です。", "不備メッセージ");
        exClassificationEquals(hubiMsgLst.get(0).getHubisyubetukbn(), C_HubisyubetuKbn.KETHORYU_HUBI, "不備種別区分");
    }

    @Test
    @Transactional
    @TestOrder(280)
    public void testExec_A20() {
        MockObjectManager.initialize();

        HanteiMoschkMockForSinkeiyaku.SYORIPTN = HanteiMoschkMockForSinkeiyaku.TESTPATTERN3;
        CheckTuusanMockForSinkeiyaku.SYORIPTN = CheckTuusanMockForSinkeiyaku.TESTPATTERN1;
        CheckSaiteiPMockForSinkeiyaku.SYORIPTN = CheckSaiteiPMockForSinkeiyaku.TESTPATTERN1;

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("860000264");

        List<HT_HubiMsg> hubiMsg = syoriCTL.getHubiMsgs();
        List<HT_MosSyouhn> syuMosSyouhnLst = syoriCTL.getMosSyouhnsBySyutkkbn(C_SyutkKbn.SYU);
        HT_MosSyouhn syuSyouhnnm = syuMosSyouhnLst.get(0);
        BM_SyouhnZokusei syuSyouhnZokusei = bizDomManager.getSyouhnZokusei(syuSyouhnnm.getSyouhncd(), syuSyouhnnm.getSyouhnsdno());
        List<BM_SyouhnZokusei> syouhnZokuseiList = new ArrayList<>();
        syouhnZokuseiList.add(syuSyouhnZokusei);

        mosnaiCheckParam.setSyuSyouhnZokusei(syuSyouhnZokusei);
        mosnaiCheckParam.setListTkSyouhnZokusei(syouhnZokuseiList);
        mosnaiCheckParam.setListHubiMsg(hubiMsg);
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setKosID("user001");
        mosnaiCheckParam.setKosTime("20160831011400000");
        mosnaiCheckParam.setSysKbn(C_SysKbn.ESHIEN);
        CheckSP checkSP = SWAKInjector.getInstance(CheckSP.class);
        checkSP.exec(mosnaiCheckParam);

        List<HT_HubiMsg> hubiMsgLst = mosnaiCheckParam.getListHubiMsg();
        exNumericEquals(hubiMsgLst.size(),0, "不備メッセージ件数");

        exClassificationEquals(mosnaiCheckParam.getSekmossakuseiErroutKbn(), C_SekmossakuseiErroutKbn.GAMEN,
            "設計書申込書作成エラー出力区分");
        exStringEquals(mosnaiCheckParam.getSekmossakuseiErrmsg1(), "", "設計書申込書作成エラーメッセージ１");
        exStringEquals(mosnaiCheckParam.getSekmossakuseiErrmsg2(), "最高保険金額を超えています　保険料は０円までにしてください",
            "設計書申込書作成エラーメッセージ２");
        exClassificationEquals(mosnaiCheckParam.getKouzokuSyoriJikkouKbn(), C_KouzokujkKbn.NONE, "後続処理実行区分 ");
    }

    @Test(expected = CommonBizAppException.class)
    @Transactional
    @TestOrder(290)
    public void testExec_A21() {
        MockObjectManager.initialize();

        HanteiMoschkMockForSinkeiyaku.SYORIPTN = HanteiMoschkMockForSinkeiyaku.TESTPATTERN3;
        CheckTuusanMockForSinkeiyaku.SYORIPTN = CheckTuusanMockForSinkeiyaku.TESTPATTERN1;
        CheckSaiteiPMockForSinkeiyaku.SYORIPTN = CheckSaiteiPMockForSinkeiyaku.TESTPATTERN1;

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("860000272");

        List<HT_HubiMsg> hubiMsg = syoriCTL.getHubiMsgs();
        List<HT_MosSyouhn> syuMosSyouhnLst = syoriCTL.getMosSyouhnsBySyutkkbn(C_SyutkKbn.SYU);
        HT_MosSyouhn syuSyouhnnm = syuMosSyouhnLst.get(0);
        BM_SyouhnZokusei syuSyouhnZokusei = bizDomManager.getSyouhnZokusei(syuSyouhnnm.getSyouhncd(), syuSyouhnnm.getSyouhnsdno());
        List<BM_SyouhnZokusei> syouhnZokuseiList = new ArrayList<>();
        syouhnZokuseiList.add(syuSyouhnZokusei);

        mosnaiCheckParam.setSyuSyouhnZokusei(syuSyouhnZokusei);
        mosnaiCheckParam.setListTkSyouhnZokusei(syouhnZokuseiList);
        mosnaiCheckParam.setListHubiMsg(hubiMsg);
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setKosID("user001");
        mosnaiCheckParam.setKosTime("20160831011400000");
        mosnaiCheckParam.setSysKbn(C_SysKbn.ESHIEN);
        try {
            CheckSP checkSP = SWAKInjector.getInstance(CheckSP.class);
            checkSP.exec(mosnaiCheckParam);
        } catch (CommonBizAppException e) {
            exStringEquals(e.getMessage(), "システム整合性エラーです。最高ＳＳ単位テーブルにデータが存在しません。", "エラーメッセージ");
            throw e;
        }
    }



    @Test(expected = CommonBizAppException.class)
    @Transactional
    @TestOrder(310)
    public void testExec_A22() {
        MockObjectManager.initialize();

        HanteiMoschkMockForSinkeiyaku.SYORIPTN = HanteiMoschkMockForSinkeiyaku.TESTPATTERN3;
        CheckTuusanMockForSinkeiyaku.SYORIPTN = CheckTuusanMockForSinkeiyaku.TESTPATTERN1;
        CheckSaiteiPMockForSinkeiyaku.SYORIPTN = CheckSaiteiPMockForSinkeiyaku.TESTPATTERN1;

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("860000298");

        List<HT_HubiMsg> hubiMsg = syoriCTL.getHubiMsgs();
        List<HT_MosSyouhn> syuMosSyouhnLst = syoriCTL.getMosSyouhnsBySyutkkbn(C_SyutkKbn.SYU);
        HT_MosSyouhn syuSyouhnnm = syuMosSyouhnLst.get(0);
        BM_SyouhnZokusei syuSyouhnZokusei = bizDomManager.getSyouhnZokusei(syuSyouhnnm.getSyouhncd(), syuSyouhnnm.getSyouhnsdno());
        List<BM_SyouhnZokusei> syouhnZokuseiList = new ArrayList<>();
        syouhnZokuseiList.add(syuSyouhnZokusei);

        mosnaiCheckParam.setSyuSyouhnZokusei(syuSyouhnZokusei);
        mosnaiCheckParam.setListTkSyouhnZokusei(syouhnZokuseiList);
        mosnaiCheckParam.setListHubiMsg(hubiMsg);
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setKosID("user001");
        mosnaiCheckParam.setKosTime("20160831011400000");
        mosnaiCheckParam.setSysKbn(C_SysKbn.SKEI);
        try {
            CheckSP checkSP = SWAKInjector.getInstance(CheckSP.class);
            checkSP.exec(mosnaiCheckParam);
        } catch (CommonBizAppException e) {
            exStringEquals(e.getMessage(), "システム整合性エラーです。最高ＳＳ単位事方書テーブルにデータが存在しません。", "エラーメッセージ");
            throw e;
        }
    }

    @Test
    @Transactional
    @TestOrder(320)
    public void testExec_A23() {
        MockObjectManager.initialize();

        HanteiMoschkMockForSinkeiyaku.SYORIPTN = HanteiMoschkMockForSinkeiyaku.TESTPATTERN3;
        CheckTuusanMockForSinkeiyaku.SYORIPTN = CheckTuusanMockForSinkeiyaku.TESTPATTERN1;
        CheckSaiteiPMockForSinkeiyaku.SYORIPTN = CheckSaiteiPMockForSinkeiyaku.TESTPATTERN1;

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("860000306");

        List<HT_HubiMsg> hubiMsg = syoriCTL.getHubiMsgs();
        List<HT_MosSyouhn> syuMosSyouhnLst = syoriCTL.getMosSyouhnsBySyutkkbn(C_SyutkKbn.SYU);
        HT_MosSyouhn syuSyouhnnm = syuMosSyouhnLst.get(0);
        BM_SyouhnZokusei syuSyouhnZokusei = bizDomManager.getSyouhnZokusei(syuSyouhnnm.getSyouhncd(), syuSyouhnnm.getSyouhnsdno());
        List<BM_SyouhnZokusei> syouhnZokuseiList = new ArrayList<>();
        syouhnZokuseiList.add(syuSyouhnZokusei);

        mosnaiCheckParam.setSyuSyouhnZokusei(syuSyouhnZokusei);
        mosnaiCheckParam.setListTkSyouhnZokusei(syouhnZokuseiList);
        mosnaiCheckParam.setListHubiMsg(hubiMsg);
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setKosID("user001");
        mosnaiCheckParam.setKosTime("20160831011400000");
        mosnaiCheckParam.setSysKbn(C_SysKbn.ESHIEN);
        CheckSP checkSP = SWAKInjector.getInstance(CheckSP.class);
        checkSP.exec(mosnaiCheckParam);

        List<HT_HubiMsg> hubiMsgLst = mosnaiCheckParam.getListHubiMsg();
        exNumericEquals(hubiMsgLst.size(),0, "不備メッセージ件数");

        exClassificationEquals(mosnaiCheckParam.getSekmossakuseiErroutKbn(), C_SekmossakuseiErroutKbn.GAMEN,
            "設計書申込書作成エラー出力区分");
        exStringEquals(mosnaiCheckParam.getSekmossakuseiErrmsg1(), "", "設計書申込書作成エラーメッセージ１");
        exStringEquals(mosnaiCheckParam.getSekmossakuseiErrmsg2(), "システム障害が発生しています。サポートデスクへお問い合わせください。",
            "設計書申込書作成エラーメッセージ２");
        exClassificationEquals(mosnaiCheckParam.getKouzokuSyoriJikkouKbn(), C_KouzokujkKbn.NONE, "後続処理実行区分 ");
    }

    @Test
    @Transactional
    @TestOrder(330)
    public void testExec_A24() {
        MockObjectManager.initialize();

        HanteiMoschkMockForSinkeiyaku.SYORIPTN = HanteiMoschkMockForSinkeiyaku.TESTPATTERN3;
        CheckTuusanMockForSinkeiyaku.SYORIPTN = CheckTuusanMockForSinkeiyaku.TESTPATTERN1;
        CheckSaiteiPMockForSinkeiyaku.SYORIPTN = CheckSaiteiPMockForSinkeiyaku.TESTPATTERN1;

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("860000082");

        List<HT_HubiMsg> hubiMsg = syoriCTL.getHubiMsgs();
        List<HT_MosSyouhn> syuMosSyouhnLst = syoriCTL.getMosSyouhnsBySyutkkbn(C_SyutkKbn.SYU);
        HT_MosSyouhn syuSyouhnnm = syuMosSyouhnLst.get(0);
        BM_SyouhnZokusei syuSyouhnZokusei = bizDomManager.getSyouhnZokusei(syuSyouhnnm.getSyouhncd(), syuSyouhnnm.getSyouhnsdno());
        List<BM_SyouhnZokusei> syouhnZokuseiList = new ArrayList<>();
        syouhnZokuseiList.add(syuSyouhnZokusei);

        mosnaiCheckParam.setSyuSyouhnZokusei(syuSyouhnZokusei);
        mosnaiCheckParam.setListTkSyouhnZokusei(syouhnZokuseiList);
        mosnaiCheckParam.setListHubiMsg(hubiMsg);
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setKosID("user001");
        mosnaiCheckParam.setKosTime("20160831011400000");
        mosnaiCheckParam.setSysKbn(C_SysKbn.ESHIEN);
        CheckSP checkSP = SWAKInjector.getInstance(CheckSP.class);
        checkSP.exec(mosnaiCheckParam);

        List<HT_HubiMsg> hubiMsgLst = mosnaiCheckParam.getListHubiMsg();
        exNumericEquals(hubiMsgLst.size(),0, "不備メッセージ件数");

        exClassificationEquals(mosnaiCheckParam.getSekmossakuseiErroutKbn(), C_SekmossakuseiErroutKbn.NONE,
            "設計書申込書作成エラー出力区分");
        exStringEquals(mosnaiCheckParam.getSekmossakuseiErrmsg1(), "", "設計書申込書作成エラーメッセージ１");
        exStringEquals(mosnaiCheckParam.getSekmossakuseiErrmsg2(), "",
            "設計書申込書作成エラーメッセージ２");
        exClassificationEquals(mosnaiCheckParam.getKouzokuSyoriJikkouKbn(), C_KouzokujkKbn.JIKKOU, "後続処理実行区分 ");

    }

    @Test
    @Transactional
    @TestOrder(340)
    public void testExec_A25() {
        MockObjectManager.initialize();

        HanteiMoschkMockForSinkeiyaku.SYORIPTN = HanteiMoschkMockForSinkeiyaku.TESTPATTERN3;
        CheckTuusanMockForSinkeiyaku.SYORIPTN = CheckTuusanMockForSinkeiyaku.TESTPATTERN1;
        CheckSaiteiPMockForSinkeiyaku.SYORIPTN = CheckSaiteiPMockForSinkeiyaku.TESTPATTERN1;

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("860000090");

        List<HT_HubiMsg> hubiMsg = syoriCTL.getHubiMsgs();
        List<HT_MosSyouhn> syuMosSyouhnLst = syoriCTL.getMosSyouhnsBySyutkkbn(C_SyutkKbn.SYU);
        HT_MosSyouhn syuSyouhnnm = syuMosSyouhnLst.get(0);
        BM_SyouhnZokusei syuSyouhnZokusei = bizDomManager.getSyouhnZokusei(syuSyouhnnm.getSyouhncd(), syuSyouhnnm.getSyouhnsdno());
        List<BM_SyouhnZokusei> syouhnZokuseiList = new ArrayList<>();
        syouhnZokuseiList.add(syuSyouhnZokusei);

        mosnaiCheckParam.setSyuSyouhnZokusei(syuSyouhnZokusei);
        mosnaiCheckParam.setListTkSyouhnZokusei(syouhnZokuseiList);
        mosnaiCheckParam.setListHubiMsg(hubiMsg);
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setKosID("user001");
        mosnaiCheckParam.setKosTime("20160831011400000");
        mosnaiCheckParam.setSysKbn(C_SysKbn.ESHIEN);
        CheckSP checkSP = SWAKInjector.getInstance(CheckSP.class);
        checkSP.exec(mosnaiCheckParam);

        List<HT_HubiMsg> hubiMsgLst = mosnaiCheckParam.getListHubiMsg();
        exNumericEquals(hubiMsgLst.size(),0, "不備メッセージ件数");

        exClassificationEquals(mosnaiCheckParam.getSekmossakuseiErroutKbn(), C_SekmossakuseiErroutKbn.NONE,
            "設計書申込書作成エラー出力区分");
        exStringEquals(mosnaiCheckParam.getSekmossakuseiErrmsg1(), "", "設計書申込書作成エラーメッセージ１");
        exStringEquals(mosnaiCheckParam.getSekmossakuseiErrmsg2(), "",
            "設計書申込書作成エラーメッセージ２");
        exClassificationEquals(mosnaiCheckParam.getKouzokuSyoriJikkouKbn(), C_KouzokujkKbn.JIKKOU, "後続処理実行区分 ");

    }

    @Test
    @Transactional
    @TestOrder(350)
    public void testExec_A26() {
        MockObjectManager.initialize();

        HanteiMoschkMockForSinkeiyaku.SYORIPTN = HanteiMoschkMockForSinkeiyaku.TESTPATTERN3;
        CheckTuusanMockForSinkeiyaku.SYORIPTN = CheckTuusanMockForSinkeiyaku.TESTPATTERN1;
        CheckSaiteiPMockForSinkeiyaku.SYORIPTN = CheckSaiteiPMockForSinkeiyaku.TESTPATTERN1;

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("860000108");

        List<HT_HubiMsg> hubiMsg = syoriCTL.getHubiMsgs();
        List<HT_MosSyouhn> syuMosSyouhnLst = syoriCTL.getMosSyouhnsBySyutkkbn(C_SyutkKbn.SYU);
        HT_MosSyouhn syuSyouhnnm = syuMosSyouhnLst.get(0);
        BM_SyouhnZokusei syuSyouhnZokusei = bizDomManager.getSyouhnZokusei(syuSyouhnnm.getSyouhncd(), syuSyouhnnm.getSyouhnsdno());
        List<BM_SyouhnZokusei> syouhnZokuseiList = new ArrayList<>();
        syouhnZokuseiList.add(syuSyouhnZokusei);

        mosnaiCheckParam.setSyuSyouhnZokusei(syuSyouhnZokusei);
        mosnaiCheckParam.setListTkSyouhnZokusei(syouhnZokuseiList);
        mosnaiCheckParam.setListHubiMsg(hubiMsg);
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setKosID("user001");
        mosnaiCheckParam.setKosTime("20160831011400000");
        mosnaiCheckParam.setSysKbn(C_SysKbn.SKEI);
        CheckSP checkSP = SWAKInjector.getInstance(CheckSP.class);
        checkSP.exec(mosnaiCheckParam);

        List<HT_HubiMsg> hubiMsgLst = mosnaiCheckParam.getListHubiMsg();
        exNumericEquals(hubiMsgLst.size(), 1, "不備メッセージ件数");
        exStringEquals(hubiMsgLst.get(0).getMosno(), "860000108", "申込番号");
        exNumericEquals(hubiMsgLst.get(0).getRenno(), 1, "連番");
        exStringEquals(hubiMsgLst.get(0).getMessageId(), "THC1118", "メッセージＩＤ");
        exStringEquals(hubiMsgLst.get(0).getHubimsg(), "【特認可能】最高保険金額の０円をオーバーしています。　一時払保険料は０円までにしてください。", "不備メッセージ");
        exClassificationEquals(hubiMsgLst.get(0).getHubisyubetukbn(), C_HubisyubetuKbn.KETHORYU_HUBI, "不備種別区分");
    }

    @Test
    @Transactional
    @TestOrder(360)
    public void testExec_A27() {
        MockObjectManager.initialize();

        HanteiMoschkMockForSinkeiyaku.SYORIPTN = HanteiMoschkMockForSinkeiyaku.TESTPATTERN3;
        CheckTuusanMockForSinkeiyaku.SYORIPTN = CheckTuusanMockForSinkeiyaku.TESTPATTERN2;
        CheckSaiteiPMockForSinkeiyaku.SYORIPTN = CheckSaiteiPMockForSinkeiyaku.TESTPATTERN1;

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("860000116");

        List<HT_HubiMsg> hubiMsg = syoriCTL.getHubiMsgs();
        List<HT_MosSyouhn> syuMosSyouhnLst = syoriCTL.getMosSyouhnsBySyutkkbn(C_SyutkKbn.SYU);
        HT_MosSyouhn syuSyouhnnm = syuMosSyouhnLst.get(0);
        BM_SyouhnZokusei syuSyouhnZokusei = bizDomManager.getSyouhnZokusei(syuSyouhnnm.getSyouhncd(), syuSyouhnnm.getSyouhnsdno());
        List<BM_SyouhnZokusei> syouhnZokuseiList = new ArrayList<>();
        syouhnZokuseiList.add(syuSyouhnZokusei);

        mosnaiCheckParam.setSyuSyouhnZokusei(syuSyouhnZokusei);
        mosnaiCheckParam.setListTkSyouhnZokusei(syouhnZokuseiList);
        mosnaiCheckParam.setListHubiMsg(hubiMsg);
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setKosID("user001");
        mosnaiCheckParam.setKosTime("20160831011400000");
        mosnaiCheckParam.setSysKbn(C_SysKbn.SKEI);
        CheckSP checkSP = SWAKInjector.getInstance(CheckSP.class);
        checkSP.exec(mosnaiCheckParam);

        List<HT_HubiMsg> hubiMsgLst = mosnaiCheckParam.getListHubiMsg();
        exNumericEquals(hubiMsgLst.size(), 1, "不備メッセージ件数");
        exStringEquals(hubiMsgLst.get(0).getMosno(), "860000116", "申込番号");
        exNumericEquals(hubiMsgLst.get(0).getRenno(), 1, "連番");
        exStringEquals(hubiMsgLst.get(0).getMessageId(), "EHC1118", "メッセージＩＤ");
        exStringEquals(hubiMsgLst.get(0).getHubimsg(), "最高保険金額の１００円をオーバーしています。　保険料は５０円までにしてください。", "不備メッセージ");
        exClassificationEquals(hubiMsgLst.get(0).getHubisyubetukbn(), C_HubisyubetuKbn.KETHORYU_HUBI, "不備種別区分");
    }

    @Test
    @Transactional
    @TestOrder(370)
    public void testExec_A28() {
        MockObjectManager.initialize();

        HanteiMoschkMockForSinkeiyaku.SYORIPTN = HanteiMoschkMockForSinkeiyaku.TESTPATTERN3;
        CheckTuusanMockForSinkeiyaku.SYORIPTN = CheckTuusanMockForSinkeiyaku.TESTPATTERN1;
        CheckSaiteiPMockForSinkeiyaku.SYORIPTN = CheckSaiteiPMockForSinkeiyaku.TESTPATTERN1;

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("860000280");

        List<HT_HubiMsg> hubiMsg = syoriCTL.getHubiMsgs();
        List<HT_MosSyouhn> syuMosSyouhnLst = syoriCTL.getMosSyouhnsBySyutkkbn(C_SyutkKbn.SYU);
        HT_MosSyouhn syuSyouhnnm = syuMosSyouhnLst.get(0);
        BM_SyouhnZokusei syuSyouhnZokusei = bizDomManager.getSyouhnZokusei(syuSyouhnnm.getSyouhncd(), syuSyouhnnm.getSyouhnsdno());
        List<BM_SyouhnZokusei> syouhnZokuseiList = new ArrayList<>();
        syouhnZokuseiList.add(syuSyouhnZokusei);

        mosnaiCheckParam.setSyuSyouhnZokusei(syuSyouhnZokusei);
        mosnaiCheckParam.setListTkSyouhnZokusei(syouhnZokuseiList);
        mosnaiCheckParam.setListHubiMsg(hubiMsg);
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setKosID("user001");
        mosnaiCheckParam.setKosTime("20160831011400000");
        mosnaiCheckParam.setSysKbn(C_SysKbn.SKEI);
        CheckSP checkSP = SWAKInjector.getInstance(CheckSP.class);
        checkSP.exec(mosnaiCheckParam);


        List<HT_HubiMsg> hubiMsgLst = mosnaiCheckParam.getListHubiMsg();
        exNumericEquals(hubiMsgLst.size(), 1, "不備メッセージ件数");
        exStringEquals(hubiMsgLst.get(0).getMosno(), "860000280", "申込番号");
        exNumericEquals(hubiMsgLst.get(0).getRenno(), 1, "連番");
        exStringEquals(hubiMsgLst.get(0).getMessageId(), "EHC1039", "メッセージＩＤ");
        exStringEquals(hubiMsgLst.get(0).getHubimsg(), "円換算処理でエラーが発生しました。最高保険金額（ＳＰ）チェックが未実施です。", "不備メッセージ");
        exClassificationEquals(hubiMsgLst.get(0).getHubisyubetukbn(), C_HubisyubetuKbn.KETHORYU_HUBI, "不備種別区分");
    }

    @Test
    @Transactional
    @TestOrder(380)
    public void testExec_A29() {
        MockObjectManager.initialize();

        HanteiMoschkMockForSinkeiyaku.SYORIPTN = HanteiMoschkMockForSinkeiyaku.TESTPATTERN3;
        CheckTuusanMockForSinkeiyaku.SYORIPTN = CheckTuusanMockForSinkeiyaku.TESTPATTERN2;
        CheckSaiteiPMockForSinkeiyaku.SYORIPTN = CheckSaiteiPMockForSinkeiyaku.TESTPATTERN1;

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("860000207");

        List<HT_HubiMsg> hubiMsg = syoriCTL.getHubiMsgs();
        List<HT_MosSyouhn> syuMosSyouhnLst = syoriCTL.getMosSyouhnsBySyutkkbn(C_SyutkKbn.SYU);
        HT_MosSyouhn syuSyouhnnm = syuMosSyouhnLst.get(0);
        BM_SyouhnZokusei syuSyouhnZokusei = bizDomManager.getSyouhnZokusei(syuSyouhnnm.getSyouhncd(), syuSyouhnnm.getSyouhnsdno());
        List<BM_SyouhnZokusei> syouhnZokuseiList = new ArrayList<>();
        syouhnZokuseiList.add(syuSyouhnZokusei);

        mosnaiCheckParam.setSyuSyouhnZokusei(syuSyouhnZokusei);
        mosnaiCheckParam.setListTkSyouhnZokusei(syouhnZokuseiList);
        mosnaiCheckParam.setListHubiMsg(hubiMsg);
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setKosID("user001");
        mosnaiCheckParam.setKosTime("20160831011400000");
        mosnaiCheckParam.setSysKbn(C_SysKbn.SKEI);
        CheckSP checkSP = SWAKInjector.getInstance(CheckSP.class);
        checkSP.exec(mosnaiCheckParam);


        List<HT_HubiMsg> hubiMsgLst = mosnaiCheckParam.getListHubiMsg();
        exNumericEquals(hubiMsgLst.size(), 1, "不備メッセージ件数");
        exStringEquals(hubiMsgLst.get(0).getMosno(), "860000207", "申込番号");
        exNumericEquals(hubiMsgLst.get(0).getRenno(), 1, "連番");
        exStringEquals(hubiMsgLst.get(0).getMessageId(), "THC1118", "メッセージＩＤ");
        exStringEquals(hubiMsgLst.get(0).getHubimsg(), "【特認可能】最高保険金額の１０円をオーバーしています。　保険料は５０円までにしてください。", "不備メッセージ");
        exClassificationEquals(hubiMsgLst.get(0).getHubisyubetukbn(), C_HubisyubetuKbn.KETHORYU_HUBI, "不備種別区分");
    }

}