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
import jp.co.slcs.swak.number.BizNumber;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.app.base.ref.TestDataMaker;
import yuyu.app.base.ref.TestDataMakerException;
import yuyu.common.biz.bzcommon.SetNenrei;
import yuyu.common.biz.bzcommon.SetNenreiMockForSinkeiyaku;
import yuyu.common.biz.exception.CommonBizAppException;
import yuyu.common.sinkeiyaku.skcommon.EditPdfYoteirirtu;
import yuyu.common.sinkeiyaku.skcommon.EditPdfYoteirirtuMockForSinkeiyaku;
import yuyu.def.biz.manager.BizDomManager;
import yuyu.def.classification.C_HubisyubetuKbn;
import yuyu.def.classification.C_HubisyubetusyousaiKbn;
import yuyu.def.classification.C_KetsrhkosKbn;
import yuyu.def.classification.C_MsgKbn;
import yuyu.def.classification.C_SpKeisanKahiKbn;
import yuyu.def.classification.C_SysKbn;
import yuyu.def.classification.C_TknKbn;
import yuyu.def.classification.C_UmuKbn;
import yuyu.def.classification.C_YoteikykymdKbn;
import yuyu.def.db.entity.BM_SyouhnZokusei;
import yuyu.def.db.entity.HT_HubiMsg;
import yuyu.def.db.entity.HT_MosKihon;
import yuyu.def.db.entity.HT_SyoriCTL;
import yuyu.def.sinkeiyaku.manager.SinkeiyakuDomManager;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;
import yuyu.testinfr.inject.MockModuleBinder;

import com.google.inject.AbstractModule;

/**
 * 保険料有効期限チェッククラスのメソッド {@link CheckHokenRyouYuukouKigen#exec(MosnaiCheckParam)} (利率変動時の動き)テスト用クラスです。<br />
 */
@RunWith(OrderedRunner.class)
public class CheckHokenRyouYuukouKigenTest_exec {

    @Inject
    private SinkeiyakuDomManager sinkeiyakuDomManager;

    private final static String fileName = "UT_SP_単体テスト仕様書_保険料有効期限チェック";

    private final static String sheetName = "INデータ";

    @Inject
    BizDomManager bizDomManager;

    @BeforeClass
    @Transactional
    public static void insertTestData() {

        try {
            TestDataMaker testDataMaker = new TestDataMaker();
            HashMap<String, Map<String, List<Map<String, String>>>> testDataAndTblMap;
            testDataAndTblMap = testDataMaker.getInData(CheckHokenRyouYuukouKigenTest_exec.class, fileName, sheetName);
            testDataMaker.insDataByDataId("データ001", testDataAndTblMap);
        } catch (TestDataMakerException e) {

            e.printStackTrace();
        }

    }

    @Before
    public void before(){
        MockModuleBinder.bind(new AbstractModule(){
            @Override
            protected void configure() {

                bind(HanteiMoschk.class).to(HanteiMoschkMockForSinkeiyaku.class);
                bind(SetKisoKoumoku.class).to(SetKisoKoumokuMockForSinkeiyaku.class);
                bind(SetNenrei.class).to(SetNenreiMockForSinkeiyaku.class);
                bind(SetHubiMsg.class).to(SetHubiMsgMockForSinkeiyaku.class);
                bind(EditPdfYoteirirtu.class).to(EditPdfYoteirirtuMockForSinkeiyaku.class);

            }
        });
    }

    @BeforeClass
    public static void testInit(){
        HanteiMoschkMockForSinkeiyaku.caller = CheckHokenRyouYuukouKigenTest_exec.class;
        SetKisoKoumokuMockForSinkeiyaku.caller = CheckHokenRyouYuukouKigenTest_exec.class;
        SetNenreiMockForSinkeiyaku.caller = CheckHokenRyouYuukouKigenTest_exec.class;
        SetHubiMsgMockForSinkeiyaku.caller = CheckHokenRyouYuukouKigenTest_exec.class;
        EditPdfYoteirirtuMockForSinkeiyaku.caller = CheckHokenRyouYuukouKigenTest_exec.class;
    }

    @AfterClass
    public static void testClear() {
        MockObjectManager.initialize();
        HanteiMoschkMockForSinkeiyaku.caller = null;
        HanteiMoschkMockForSinkeiyaku.SYORIPTN = null;

        SetKisoKoumokuMockForSinkeiyaku.caller = null;
        SetKisoKoumokuMockForSinkeiyaku.SYORIPTN = null;

        SetNenreiMockForSinkeiyaku.caller = null;
        SetNenreiMockForSinkeiyaku.SYORIPTN = null;

        SetHubiMsgMockForSinkeiyaku.caller = null;
        SetHubiMsgMockForSinkeiyaku.SYORIPTN = null;

        EditPdfYoteirirtuMockForSinkeiyaku.caller = null;
        EditPdfYoteirirtuMockForSinkeiyaku.SYORIPTN = null;
    }

    @AfterClass
    @Transactional
    public static void deleteTestData() {
        MockObjectManager.initialize();
        SinkeiyakuDomManager sinkeiyakuDomManager = SWAKInjector.getInstance(SinkeiyakuDomManager.class);
        BizDomManager bizDomManager = SWAKInjector.getInstance(BizDomManager.class);
        sinkeiyakuDomManager.delete(sinkeiyakuDomManager.getAllSyoriCTL());
        bizDomManager.delete(bizDomManager.getAllSyouhnZokusei());
        bizDomManager.delete(bizDomManager.getAllYoteiRiritu());
        bizDomManager.delete(bizDomManager.getAllChkNenreiHani());
    }

    @Test(expected = CommonBizAppException.class)
    @Transactional
    @TestOrder(10)
    public void testExec_A1() {

        try {
            CheckHokenRyouYuukouKigen checkHokenRyouYuukouKigen = SWAKInjector.getInstance(CheckHokenRyouYuukouKigen.class);
            MosnaiCheckParam mosnaiCheckParam = SWAKInjector.getInstance(MosnaiCheckParam.class);

            HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("791112220");
            List<HT_HubiMsg> hubiMsg = syoriCTL.getHubiMsgs();
            mosnaiCheckParam.setDataSyoriControl(syoriCTL);
            mosnaiCheckParam.setSysDate(BizDate.valueOf("20160907"));
            mosnaiCheckParam.setListHubiMsg(hubiMsg);
            checkHokenRyouYuukouKigen.exec(mosnaiCheckParam);
        } catch (CommonBizAppException e) {
            exStringEquals(e.getMessage(), "システム整合性エラーです。主契約申込商品件数異常 申込番号：791112220", "エラーメッセージ");
            throw e;
        }

    }

    @Test
    @Transactional
    @TestOrder(20)
    public void testExec_A2() {

        MockObjectManager.initialize();
        HanteiMoschkMockForSinkeiyaku.SYORIPTN = HanteiMoschkMockForSinkeiyaku.TESTPATTERN1;

        CheckHokenRyouYuukouKigen checkHokenRyouYuukouKigen = SWAKInjector.getInstance(CheckHokenRyouYuukouKigen.class);
        MosnaiCheckParam mosnaiCheckParam = SWAKInjector.getInstance(MosnaiCheckParam.class);

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("791112238");
        List<HT_HubiMsg> hubiMsg = syoriCTL.getHubiMsgs();
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        BM_SyouhnZokusei syouhnZokusei = bizDomManager.getSyouhnZokusei("ﾕｱ", 1);
        mosnaiCheckParam.setSyuSyouhnZokusei(syouhnZokusei);
        mosnaiCheckParam.setSysDate(BizDate.valueOf("20170907"));
        mosnaiCheckParam.setListHubiMsg(hubiMsg);
        checkHokenRyouYuukouKigen.exec(mosnaiCheckParam);

        exNumericEquals(hubiMsg.size(), 0, "不備メッセージ件数");

    }

    @Test
    @Transactional
    @TestOrder(30)
    public void testExec_A3() {

        MockObjectManager.initialize();
        HanteiMoschkMockForSinkeiyaku.SYORIPTN = HanteiMoschkMockForSinkeiyaku.TESTPATTERN2;
        SetKisoKoumokuMockForSinkeiyaku.SYORIPTN = SetKisoKoumokuMockForSinkeiyaku.TESTPATTERN1;
        SetNenreiMockForSinkeiyaku.SYORIPTN = SetNenreiMockForSinkeiyaku.TESTPATTERN1;
        SetHubiMsgMockForSinkeiyaku.SYORIPTN = SetHubiMsgMockForSinkeiyaku.TESTPATTERN1;

        CheckHokenRyouYuukouKigen checkHokenRyouYuukouKigen = SWAKInjector.getInstance(CheckHokenRyouYuukouKigen.class);
        MosnaiCheckParam mosnaiCheckParam = SWAKInjector.getInstance(MosnaiCheckParam.class);

        sinkeiyakuDomManager.flush();
        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("791112246");
        List<HT_HubiMsg> hubiMsg = syoriCTL.getHubiMsgs();
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        BM_SyouhnZokusei syouhnZokusei = bizDomManager.getSyouhnZokusei("ﾕｲ", 1);
        mosnaiCheckParam.setSyuSyouhnZokusei(syouhnZokusei);
        mosnaiCheckParam.setSysDate(BizDate.valueOf("20160907"));
        mosnaiCheckParam.setListHubiMsg(hubiMsg);
        checkHokenRyouYuukouKigen.exec(mosnaiCheckParam);

        exNumericEquals(hubiMsg.size(), 1, "不備メッセージ件数");
        exStringEquals(hubiMsg.get(0).getHubimsg(), "被保険者年齢がアップしています。", "不備メッセージ");
        exStringEquals(hubiMsg.get(0).getMessageId(), "EHC1034", "メッセージＩＤ");
        exStringEquals(hubiMsg.get(0).getMosno(), "791112246", "申込番号");
        exNumericEquals(hubiMsg.get(0).getRenno(), 1, "連番");
        exClassificationEquals(hubiMsg.get(0).getHubisyubetukbn(), C_HubisyubetuKbn.KETHORYU_HUBI, "不備種別区分");
        exClassificationEquals(hubiMsg.get(0).getHubisyubetusyousaikbn(), C_HubisyubetusyousaiKbn.NONE, "不備種別詳細区分");

        exDateEquals((BizDate)MockObjectManager.getArgument(SetKisoKoumokuMockForSinkeiyaku.class, "setkykymdHantei", 0, 2), null, "領収日");
        exDateEquals((BizDate)MockObjectManager.getArgument(SetKisoKoumokuMockForSinkeiyaku.class, "setkykymdHantei", 0, 3), BizDate.valueOf(20160701), "申込日");
        exDateEquals((BizDate)MockObjectManager.getArgument(SetKisoKoumokuMockForSinkeiyaku.class, "setkykymdHantei", 0, 4), BizDate.valueOf(20160701), "責任開始日");
        exDateEquals((BizDate)MockObjectManager.getArgument(SetKisoKoumokuMockForSinkeiyaku.class, "setkykymdHantei", 0, 5), BizDate.valueOf(20160701), "処理日");
        exClassificationEquals((C_SysKbn)MockObjectManager.getArgument(SetKisoKoumokuMockForSinkeiyaku.class, "setkykymdHantei", 0, 6), C_SysKbn.SKEI, "システム区分");
        exClassificationEquals((C_YoteikykymdKbn)MockObjectManager.getArgument(SetKisoKoumokuMockForSinkeiyaku.class, "setkykymdHantei", 0, 7), C_YoteikykymdKbn.AUTO, "予定契約日区分");
        exDateEquals((BizDate)MockObjectManager.getArgument(SetNenreiMockForSinkeiyaku.class, "exec", 0, 0), BizDate.valueOf(20180203), "基準日");
        exDateEquals((BizDate)MockObjectManager.getArgument(SetNenreiMockForSinkeiyaku.class, "exec", 0, 1), BizDate.valueOf(20010101), "生年月日");
        exClassificationEquals((C_KetsrhkosKbn)MockObjectManager.getArgument(SetHubiMsgMockForSinkeiyaku.class, "exec", 0, 0), C_KetsrhkosKbn.KETHORYU_HUBI, "決定・成立保留更新区分");
        exClassificationEquals((C_SpKeisanKahiKbn)MockObjectManager.getArgument(SetHubiMsgMockForSinkeiyaku.class, "exec", 0, 1), C_SpKeisanKahiKbn.SPKEISANKA, "決定保留時ＳＰ計算可否区分");
        exClassificationEquals((C_HubisyubetusyousaiKbn)MockObjectManager.getArgument(SetHubiMsgMockForSinkeiyaku.class, "exec", 0, 2), C_HubisyubetusyousaiKbn.NONE, "不備種別詳細区分");
        exStringEquals((String)MockObjectManager.getArgument(SetHubiMsgMockForSinkeiyaku.class, "exec", 0, 3), "EHC1034 被保険者年齢がアップしています。", "メッセージ文言");
        exClassificationEquals((C_TknKbn)MockObjectManager.getArgument(SetHubiMsgMockForSinkeiyaku.class, "exec", 0, 5), C_TknKbn.SUMI, "特認区分");
        exClassificationEquals((C_MsgKbn)MockObjectManager.getArgument(SetHubiMsgMockForSinkeiyaku.class, "exec", 0, 6), C_MsgKbn.ERROR, "メッセージ区分");
    }

    @Test
    @Transactional
    @TestOrder(40)
    public void testExec_A4() {

        MockObjectManager.initialize();
        HanteiMoschkMockForSinkeiyaku.SYORIPTN = HanteiMoschkMockForSinkeiyaku.TESTPATTERN2;
        SetKisoKoumokuMockForSinkeiyaku.SYORIPTN = SetKisoKoumokuMockForSinkeiyaku.TESTPATTERN1;
        SetNenreiMockForSinkeiyaku.SYORIPTN = SetNenreiMockForSinkeiyaku.TESTPATTERN1;
        SetHubiMsgMockForSinkeiyaku.SYORIPTN = SetHubiMsgMockForSinkeiyaku.TESTPATTERN7;

        CheckHokenRyouYuukouKigen checkHokenRyouYuukouKigen = SWAKInjector.getInstance(CheckHokenRyouYuukouKigen.class);
        MosnaiCheckParam mosnaiCheckParam = SWAKInjector.getInstance(MosnaiCheckParam.class);

        sinkeiyakuDomManager.flush();
        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("791112253");
        List<HT_HubiMsg> hubiMsg = syoriCTL.getHubiMsgs();
        BM_SyouhnZokusei syouhnZokusei = bizDomManager.getSyouhnZokusei("ﾕｳ", 1);
        mosnaiCheckParam.setSyuSyouhnZokusei(syouhnZokusei);
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setSysDate(BizDate.valueOf("20160907"));
        mosnaiCheckParam.setListHubiMsg(hubiMsg);
        checkHokenRyouYuukouKigen.exec(mosnaiCheckParam);

        exNumericEquals(hubiMsg.size(), 1, "不備メッセージ件数");
        exStringEquals(hubiMsg.get(0).getHubimsg(), "被保険者年齢がアップしています。", "不備メッセージ");
        exStringEquals(hubiMsg.get(0).getMessageId(), "WHC1022", "メッセージＩＤ");
        exStringEquals(hubiMsg.get(0).getMosno(), "791112253", "申込番号");
        exNumericEquals(hubiMsg.get(0).getRenno(), 1, "連番");
        exClassificationEquals(hubiMsg.get(0).getHubisyubetukbn(), C_HubisyubetuKbn.WARNING, "不備種別区分");
        exClassificationEquals(hubiMsg.get(0).getHubisyubetusyousaikbn(), C_HubisyubetusyousaiKbn.NONE, "不備種別詳細区分");

        exDateEquals((BizDate)MockObjectManager.getArgument(SetKisoKoumokuMockForSinkeiyaku.class, "setkykymdHantei", 0, 2), null, "領収日");
        exDateEquals((BizDate)MockObjectManager.getArgument(SetKisoKoumokuMockForSinkeiyaku.class, "setkykymdHantei", 0, 3), BizDate.valueOf(20160701), "申込日");
        exDateEquals((BizDate)MockObjectManager.getArgument(SetKisoKoumokuMockForSinkeiyaku.class, "setkykymdHantei", 0, 4), BizDate.valueOf(20160701), "責任開始日");
        exDateEquals((BizDate)MockObjectManager.getArgument(SetKisoKoumokuMockForSinkeiyaku.class, "setkykymdHantei", 0, 5), BizDate.valueOf(20160701), "処理日");
        exClassificationEquals((C_SysKbn)MockObjectManager.getArgument(SetKisoKoumokuMockForSinkeiyaku.class, "setkykymdHantei", 0, 6), C_SysKbn.SKEI, "システム区分");
        exClassificationEquals((C_YoteikykymdKbn)MockObjectManager.getArgument(SetKisoKoumokuMockForSinkeiyaku.class, "setkykymdHantei", 0, 7), C_YoteikykymdKbn.AUTO, "予定契約日区分");
        exDateEquals((BizDate)MockObjectManager.getArgument(SetNenreiMockForSinkeiyaku.class, "exec", 0, 0), BizDate.valueOf(20180203), "基準日");
        exDateEquals((BizDate)MockObjectManager.getArgument(SetNenreiMockForSinkeiyaku.class, "exec", 0, 1), BizDate.valueOf(20010101), "生年月日");
        exClassificationEquals((C_KetsrhkosKbn)MockObjectManager.getArgument(SetHubiMsgMockForSinkeiyaku.class, "exec", 0, 0), C_KetsrhkosKbn.WARNING, "決定・成立保留更新区分");
        exStringEquals((String)MockObjectManager.getArgument(SetHubiMsgMockForSinkeiyaku.class, "exec", 0, 1), "WHC1022 被保険者年齢がアップしています。", "メッセージ文言");
        exClassificationEquals((C_TknKbn)MockObjectManager.getArgument(SetHubiMsgMockForSinkeiyaku.class, "exec", 0, 3), C_TknKbn.NONE, "特認区分");
        exClassificationEquals((C_MsgKbn)MockObjectManager.getArgument(SetHubiMsgMockForSinkeiyaku.class, "exec", 0, 4), C_MsgKbn.WARNING, "メッセージ区分");
    }

    @Test
    @Transactional
    @TestOrder(50)
    public void testExec_A5() {

        MockObjectManager.initialize();
        HanteiMoschkMockForSinkeiyaku.SYORIPTN = HanteiMoschkMockForSinkeiyaku.TESTPATTERN2;
        SetKisoKoumokuMockForSinkeiyaku.SYORIPTN = SetKisoKoumokuMockForSinkeiyaku.TESTPATTERN1;
        SetNenreiMockForSinkeiyaku.SYORIPTN = SetNenreiMockForSinkeiyaku.TESTPATTERN1;
        SetHubiMsgMockForSinkeiyaku.SYORIPTN = SetHubiMsgMockForSinkeiyaku.TESTPATTERN8;

        CheckHokenRyouYuukouKigen checkHokenRyouYuukouKigen = SWAKInjector.getInstance(CheckHokenRyouYuukouKigen.class);
        MosnaiCheckParam mosnaiCheckParam = SWAKInjector.getInstance(MosnaiCheckParam.class);

        sinkeiyakuDomManager.flush();
        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("791112261");
        List<HT_HubiMsg> hubiMsg = syoriCTL.getHubiMsgs();
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        BM_SyouhnZokusei syouhnZokusei = bizDomManager.getSyouhnZokusei("ﾕｴ", 1);
        mosnaiCheckParam.setSyuSyouhnZokusei(syouhnZokusei);
        mosnaiCheckParam.setSysDate(BizDate.valueOf("20160907"));
        mosnaiCheckParam.setListHubiMsg(hubiMsg);
        checkHokenRyouYuukouKigen.exec(mosnaiCheckParam);

        exNumericEquals(hubiMsg.size(), 1, "不備メッセージ件数");
        exStringEquals(hubiMsg.get(0).getHubimsg(), "被保険者年齢がアップしています。", "不備メッセージ");
        exStringEquals(hubiMsg.get(0).getMessageId(), "WHC1022", "メッセージＩＤ");
        exStringEquals(hubiMsg.get(0).getMosno(), "791112261", "申込番号");
        exNumericEquals(hubiMsg.get(0).getRenno(), 1, "連番");
        exClassificationEquals(hubiMsg.get(0).getHubisyubetukbn(), C_HubisyubetuKbn.WARNING, "不備種別区分");
        exClassificationEquals(hubiMsg.get(0).getHubisyubetusyousaikbn(), C_HubisyubetusyousaiKbn.NONE, "不備種別詳細区分");

        exDateEquals((BizDate)MockObjectManager.getArgument(SetKisoKoumokuMockForSinkeiyaku.class, "setkykymdHantei", 0, 2), null, "領収日");
        exDateEquals((BizDate)MockObjectManager.getArgument(SetKisoKoumokuMockForSinkeiyaku.class, "setkykymdHantei", 0, 3), BizDate.valueOf(20160701), "申込日");
        exDateEquals((BizDate)MockObjectManager.getArgument(SetKisoKoumokuMockForSinkeiyaku.class, "setkykymdHantei", 0, 4), BizDate.valueOf(20160701), "責任開始日");
        exDateEquals((BizDate)MockObjectManager.getArgument(SetKisoKoumokuMockForSinkeiyaku.class, "setkykymdHantei", 0, 5), BizDate.valueOf(20160701), "処理日");
        exClassificationEquals((C_SysKbn)MockObjectManager.getArgument(SetKisoKoumokuMockForSinkeiyaku.class, "setkykymdHantei", 0, 6), C_SysKbn.SKEI, "システム区分");
        exClassificationEquals((C_YoteikykymdKbn)MockObjectManager.getArgument(SetKisoKoumokuMockForSinkeiyaku.class, "setkykymdHantei", 0, 7), C_YoteikykymdKbn.AUTO, "予定契約日区分");
        exDateEquals((BizDate)MockObjectManager.getArgument(SetNenreiMockForSinkeiyaku.class, "exec", 0, 0), BizDate.valueOf(20180203), "基準日");
        exDateEquals((BizDate)MockObjectManager.getArgument(SetNenreiMockForSinkeiyaku.class, "exec", 0, 1), BizDate.valueOf(20010101), "生年月日");
        exClassificationEquals((C_KetsrhkosKbn)MockObjectManager.getArgument(SetHubiMsgMockForSinkeiyaku.class, "exec", 0, 0), C_KetsrhkosKbn.WARNING, "決定・成立保留更新区分");
        exStringEquals((String)MockObjectManager.getArgument(SetHubiMsgMockForSinkeiyaku.class, "exec", 0, 1), "WHC1022 被保険者年齢がアップしています。", "メッセージ文言");
        exClassificationEquals((C_TknKbn)MockObjectManager.getArgument(SetHubiMsgMockForSinkeiyaku.class, "exec", 0, 3), C_TknKbn.NONE, "特認区分");
        exClassificationEquals((C_MsgKbn)MockObjectManager.getArgument(SetHubiMsgMockForSinkeiyaku.class, "exec", 0, 4), C_MsgKbn.WARNING, "メッセージ区分");
    }

    @Test
    @Transactional
    @TestOrder(60)
    public void testExec_A6() {

        MockObjectManager.initialize();
        HanteiMoschkMockForSinkeiyaku.SYORIPTN = HanteiMoschkMockForSinkeiyaku.TESTPATTERN2;
        SetKisoKoumokuMockForSinkeiyaku.SYORIPTN = SetKisoKoumokuMockForSinkeiyaku.TESTPATTERN2;
        SetNenreiMockForSinkeiyaku.SYORIPTN = SetNenreiMockForSinkeiyaku.TESTPATTERN2;

        CheckHokenRyouYuukouKigen checkHokenRyouYuukouKigen = SWAKInjector.getInstance(CheckHokenRyouYuukouKigen.class);
        MosnaiCheckParam mosnaiCheckParam = SWAKInjector.getInstance(MosnaiCheckParam.class);

        sinkeiyakuDomManager.flush();
        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("791112279");
        List<HT_HubiMsg> hubiMsg = syoriCTL.getHubiMsgs();
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        BM_SyouhnZokusei syouhnZokusei = bizDomManager.getSyouhnZokusei("ﾕｵ", 1);
        mosnaiCheckParam.setSyuSyouhnZokusei(syouhnZokusei);
        mosnaiCheckParam.setSysDate(BizDate.valueOf("20160907"));
        mosnaiCheckParam.setListHubiMsg(hubiMsg);
        checkHokenRyouYuukouKigen.exec(mosnaiCheckParam);

        exNumericEquals(hubiMsg.size(), 0, "不備メッセージ件数");

        exDateEquals((BizDate)MockObjectManager.getArgument(SetKisoKoumokuMockForSinkeiyaku.class, "setkykymdHantei", 0, 2), null, "領収日");
        exDateEquals((BizDate)MockObjectManager.getArgument(SetKisoKoumokuMockForSinkeiyaku.class, "setkykymdHantei", 0, 3), BizDate.valueOf(20160701), "申込日");
        exDateEquals((BizDate)MockObjectManager.getArgument(SetKisoKoumokuMockForSinkeiyaku.class, "setkykymdHantei", 0, 4), BizDate.valueOf(20160701), "責任開始日");
        exDateEquals((BizDate)MockObjectManager.getArgument(SetKisoKoumokuMockForSinkeiyaku.class, "setkykymdHantei", 0, 5), BizDate.valueOf(20160701), "処理日");
        exClassificationEquals((C_SysKbn)MockObjectManager.getArgument(SetKisoKoumokuMockForSinkeiyaku.class, "setkykymdHantei", 0, 6), C_SysKbn.SKEI, "システム区分");
        exClassificationEquals((C_YoteikykymdKbn)MockObjectManager.getArgument(SetKisoKoumokuMockForSinkeiyaku.class, "setkykymdHantei", 0, 7), C_YoteikykymdKbn.AUTO, "予定契約日区分");
        exDateEquals((BizDate)MockObjectManager.getArgument(SetNenreiMockForSinkeiyaku.class, "exec", 0, 0), BizDate.valueOf(20180303), "基準日");
        exDateEquals((BizDate)MockObjectManager.getArgument(SetNenreiMockForSinkeiyaku.class, "exec", 0, 1), BizDate.valueOf(20010101), "生年月日");
    }

    @Test
    @Transactional
    @TestOrder(70)
    public void testExec_A7() {

        MockObjectManager.initialize();
        HanteiMoschkMockForSinkeiyaku.SYORIPTN = HanteiMoschkMockForSinkeiyaku.TESTPATTERN3;
        SetKisoKoumokuMockForSinkeiyaku.SYORIPTN = SetKisoKoumokuMockForSinkeiyaku.TESTPATTERN3;
        SetNenreiMockForSinkeiyaku.SYORIPTN = SetNenreiMockForSinkeiyaku.TESTPATTERN3;

        CheckHokenRyouYuukouKigen checkHokenRyouYuukouKigen = SWAKInjector.getInstance(CheckHokenRyouYuukouKigen.class);
        MosnaiCheckParam mosnaiCheckParam = SWAKInjector.getInstance(MosnaiCheckParam.class);

        sinkeiyakuDomManager.flush();
        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("791112287");
        List<HT_HubiMsg> hubiMsg = syoriCTL.getHubiMsgs();
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        BM_SyouhnZokusei syouhnZokusei = bizDomManager.getSyouhnZokusei("ﾕｶ", 1);
        mosnaiCheckParam.setSyuSyouhnZokusei(syouhnZokusei);
        mosnaiCheckParam.setSysDate(BizDate.valueOf("20160907"));
        mosnaiCheckParam.setListHubiMsg(hubiMsg);
        checkHokenRyouYuukouKigen.exec(mosnaiCheckParam);

        exNumericEquals(hubiMsg.size(), 0, "不備メッセージ件数");

        exDateEquals((BizDate)MockObjectManager.getArgument(SetKisoKoumokuMockForSinkeiyaku.class, "setkykymdHantei", 0, 2), null, "領収日");
        exDateEquals((BizDate)MockObjectManager.getArgument(SetKisoKoumokuMockForSinkeiyaku.class, "setkykymdHantei", 0, 3), BizDate.valueOf(20160701), "申込日");
        exDateEquals((BizDate)MockObjectManager.getArgument(SetKisoKoumokuMockForSinkeiyaku.class, "setkykymdHantei", 0, 4), BizDate.valueOf(20160701), "責任開始日");
        exDateEquals((BizDate)MockObjectManager.getArgument(SetKisoKoumokuMockForSinkeiyaku.class, "setkykymdHantei", 0, 5), BizDate.valueOf(20160701), "処理日");
        exClassificationEquals((C_SysKbn)MockObjectManager.getArgument(SetKisoKoumokuMockForSinkeiyaku.class, "setkykymdHantei", 0, 6), C_SysKbn.SKEI, "システム区分");
        exClassificationEquals((C_YoteikykymdKbn)MockObjectManager.getArgument(SetKisoKoumokuMockForSinkeiyaku.class, "setkykymdHantei", 0, 7), C_YoteikykymdKbn.AUTO, "予定契約日区分");
        exDateEquals((BizDate)MockObjectManager.getArgument(SetNenreiMockForSinkeiyaku.class, "exec", 0, 0), BizDate.valueOf(20180503), "基準日");
        exDateEquals((BizDate)MockObjectManager.getArgument(SetNenreiMockForSinkeiyaku.class, "exec", 0, 1), BizDate.valueOf(20010101), "生年月日");

    }

    @Test
    @Transactional
    @TestOrder(80)
    public void testExec_A8() {

        MockObjectManager.initialize();
        HanteiMoschkMockForSinkeiyaku.SYORIPTN = HanteiMoschkMockForSinkeiyaku.TESTPATTERN3;

        CheckHokenRyouYuukouKigen checkHokenRyouYuukouKigen = SWAKInjector.getInstance(CheckHokenRyouYuukouKigen.class);
        MosnaiCheckParam mosnaiCheckParam = SWAKInjector.getInstance(MosnaiCheckParam.class);

        sinkeiyakuDomManager.flush();
        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("791112295");
        List<HT_HubiMsg> hubiMsg = syoriCTL.getHubiMsgs();
        BM_SyouhnZokusei syouhnZokusei = bizDomManager.getSyouhnZokusei("ﾕｷ", 1);
        mosnaiCheckParam.setSyuSyouhnZokusei(syouhnZokusei);
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setSysDate(BizDate.valueOf("20160907"));
        mosnaiCheckParam.setListHubiMsg(hubiMsg);
        checkHokenRyouYuukouKigen.exec(mosnaiCheckParam);

        exNumericEquals(hubiMsg.size(), 0, "不備メッセージ件数");

        exDateEquals((BizDate)MockObjectManager.getArgument(SetKisoKoumokuMockForSinkeiyaku.class, "setkykymdHantei", 0, 2), null, "領収日");
        exDateEquals((BizDate)MockObjectManager.getArgument(SetKisoKoumokuMockForSinkeiyaku.class, "setkykymdHantei", 0, 3), BizDate.valueOf(20160701), "申込日");
        exDateEquals((BizDate)MockObjectManager.getArgument(SetKisoKoumokuMockForSinkeiyaku.class, "setkykymdHantei", 0, 4), BizDate.valueOf(20160701), "責任開始日");
        exDateEquals((BizDate)MockObjectManager.getArgument(SetKisoKoumokuMockForSinkeiyaku.class, "setkykymdHantei", 0, 5), BizDate.valueOf(20160701), "処理日");
        exClassificationEquals((C_SysKbn)MockObjectManager.getArgument(SetKisoKoumokuMockForSinkeiyaku.class, "setkykymdHantei", 0, 6), C_SysKbn.SKEI, "システム区分");
        exClassificationEquals((C_YoteikykymdKbn)MockObjectManager.getArgument(SetKisoKoumokuMockForSinkeiyaku.class, "setkykymdHantei", 0, 7), C_YoteikykymdKbn.AUTO, "予定契約日区分");

    }

    @Test
    @Transactional
    @TestOrder(90)
    public void testExec_A9() {

        MockObjectManager.initialize();
        HanteiMoschkMockForSinkeiyaku.SYORIPTN = HanteiMoschkMockForSinkeiyaku.TESTPATTERN4;
        SetKisoKoumokuMockForSinkeiyaku.SYORIPTN = SetKisoKoumokuMockForSinkeiyaku.TESTPATTERN4;
        SetNenreiMockForSinkeiyaku.SYORIPTN = SetNenreiMockForSinkeiyaku.TESTPATTERN4;
        SetHubiMsgMockForSinkeiyaku.SYORIPTN = SetHubiMsgMockForSinkeiyaku.TESTPATTERN1;

        CheckHokenRyouYuukouKigen checkHokenRyouYuukouKigen = SWAKInjector.getInstance(CheckHokenRyouYuukouKigen.class);
        MosnaiCheckParam mosnaiCheckParam = SWAKInjector.getInstance(MosnaiCheckParam.class);

        sinkeiyakuDomManager.flush();
        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("791112725");
        List<HT_HubiMsg> hubiMsg = syoriCTL.getHubiMsgs();
        BM_SyouhnZokusei syouhnZokusei = bizDomManager.getSyouhnZokusei("ﾕｸ", 1);
        mosnaiCheckParam.setSyuSyouhnZokusei(syouhnZokusei);
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setSysDate(BizDate.valueOf("20160907"));
        mosnaiCheckParam.setListHubiMsg(hubiMsg);
        checkHokenRyouYuukouKigen.exec(mosnaiCheckParam);

        exNumericEquals(hubiMsg.size(), 1, "不備メッセージ件数");
        exStringEquals(hubiMsg.get(0).getHubimsg(), "6月4日までに責任開始しない場合、契約年齢範囲外となります。", "不備メッセージ");
        exStringEquals(hubiMsg.get(0).getMessageId(), "WHC1015", "メッセージＩＤ");
        exStringEquals(hubiMsg.get(0).getMosno(), "791112725", "申込番号");
        exNumericEquals(hubiMsg.get(0).getRenno(), 1, "連番");
        exClassificationEquals(hubiMsg.get(0).getHubisyubetukbn(), C_HubisyubetuKbn.WARNING, "不備種別区分");
        exClassificationEquals(hubiMsg.get(0).getHubisyubetusyousaikbn(), C_HubisyubetusyousaiKbn.NONE, "不備種別詳細区分");

        exDateEquals((BizDate)MockObjectManager.getArgument(SetKisoKoumokuMockForSinkeiyaku.class, "setkykymdHantei", 0, 2), null, "領収日");
        exDateEquals((BizDate)MockObjectManager.getArgument(SetKisoKoumokuMockForSinkeiyaku.class, "setkykymdHantei", 0, 3), BizDate.valueOf(20160701), "申込日");
        exDateEquals((BizDate)MockObjectManager.getArgument(SetKisoKoumokuMockForSinkeiyaku.class, "setkykymdHantei", 0, 4), BizDate.valueOf(20160701), "責任開始日");
        exDateEquals((BizDate)MockObjectManager.getArgument(SetKisoKoumokuMockForSinkeiyaku.class, "setkykymdHantei", 0, 5), BizDate.valueOf(20160701), "処理日");
        exClassificationEquals((C_SysKbn)MockObjectManager.getArgument(SetKisoKoumokuMockForSinkeiyaku.class, "setkykymdHantei", 0, 6), C_SysKbn.SKEI, "システム区分");
        exClassificationEquals((C_YoteikykymdKbn)MockObjectManager.getArgument(SetKisoKoumokuMockForSinkeiyaku.class, "setkykymdHantei", 0, 7), C_YoteikykymdKbn.AUTO, "予定契約日区分");
        exDateEquals((BizDate)MockObjectManager.getArgument(SetKisoKoumokuMockForSinkeiyaku.class, "setkykymdHantei", 1, 2), null, "領収日");
        exDateEquals((BizDate)MockObjectManager.getArgument(SetKisoKoumokuMockForSinkeiyaku.class, "setkykymdHantei", 1, 3), BizDate.valueOf(20160907), "申込日");
        exDateEquals((BizDate)MockObjectManager.getArgument(SetKisoKoumokuMockForSinkeiyaku.class, "setkykymdHantei", 1, 4), BizDate.valueOf(20160907), "責任開始日");
        exDateEquals((BizDate)MockObjectManager.getArgument(SetKisoKoumokuMockForSinkeiyaku.class, "setkykymdHantei", 1, 5), BizDate.valueOf(20160907), "処理日");
        exClassificationEquals((C_SysKbn)MockObjectManager.getArgument(SetKisoKoumokuMockForSinkeiyaku.class, "setkykymdHantei", 0, 6), C_SysKbn.SKEI, "システム区分");
        exClassificationEquals((C_YoteikykymdKbn)MockObjectManager.getArgument(SetKisoKoumokuMockForSinkeiyaku.class, "setkykymdHantei", 0, 7), C_YoteikykymdKbn.AUTO, "予定契約日区分");

        exDateEquals((BizDate)MockObjectManager.getArgument(SetKisoKoumokuMockForSinkeiyaku.class, "getNextkykymd", 0, 2), BizDate.valueOf(20180505), "基準日");
        exDateEquals((BizDate)MockObjectManager.getArgument(SetKisoKoumokuMockForSinkeiyaku.class, "getNextkykymd", 1, 2), BizDate.valueOf(20160907), "基準日");

        exDateEquals((BizDate)MockObjectManager.getArgument(SetNenreiMockForSinkeiyaku.class, "exec", 0, 0), BizDate.valueOf(20180503), "基準日");
        exDateEquals((BizDate)MockObjectManager.getArgument(SetNenreiMockForSinkeiyaku.class, "exec", 0, 1), BizDate.valueOf(20010505), "生年月日");
        exClassificationEquals((C_KetsrhkosKbn)MockObjectManager.getArgument(SetHubiMsgMockForSinkeiyaku.class, "exec", 0, 0), C_KetsrhkosKbn.WARNING, "決定・成立保留更新区分");
        exStringEquals((String)MockObjectManager.getArgument(SetHubiMsgMockForSinkeiyaku.class, "exec", 0, 1), "WHC1015 6月4日までに責任開始しない場合、契約年齢範囲外となります。", "メッセージ文言");
        exClassificationEquals((C_TknKbn)MockObjectManager.getArgument(SetHubiMsgMockForSinkeiyaku.class, "exec", 0, 3), C_TknKbn.NONE, "特認区分");
        exClassificationEquals((C_MsgKbn)MockObjectManager.getArgument(SetHubiMsgMockForSinkeiyaku.class, "exec", 0, 4), C_MsgKbn.WARNING, "メッセージ区分");

    }

    @Test
    @Transactional
    @TestOrder(100)
    public void testExec_A10() {

        MockObjectManager.initialize();
        HanteiMoschkMockForSinkeiyaku.SYORIPTN = HanteiMoschkMockForSinkeiyaku.TESTPATTERN3;
        SetKisoKoumokuMockForSinkeiyaku.SYORIPTN = SetKisoKoumokuMockForSinkeiyaku.TESTPATTERN5;
        SetNenreiMockForSinkeiyaku.SYORIPTN = SetNenreiMockForSinkeiyaku.TESTPATTERN5;
        SetHubiMsgMockForSinkeiyaku.SYORIPTN = SetHubiMsgMockForSinkeiyaku.TESTPATTERN2;

        CheckHokenRyouYuukouKigen checkHokenRyouYuukouKigen = SWAKInjector.getInstance(CheckHokenRyouYuukouKigen.class);
        MosnaiCheckParam mosnaiCheckParam = SWAKInjector.getInstance(MosnaiCheckParam.class);

        sinkeiyakuDomManager.flush();
        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("791112303");
        List<HT_HubiMsg> hubiMsg = syoriCTL.getHubiMsgs();
        BM_SyouhnZokusei syouhnZokusei = bizDomManager.getSyouhnZokusei("ﾕｱ", 2);
        mosnaiCheckParam.setSyuSyouhnZokusei(syouhnZokusei);
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setSysDate(BizDate.valueOf("20160907"));
        mosnaiCheckParam.setListHubiMsg(hubiMsg);
        checkHokenRyouYuukouKigen.exec(mosnaiCheckParam);

        exNumericEquals(hubiMsg.size(), 1, "不備メッセージ件数");
        exStringEquals(hubiMsg.get(0).getHubimsg(), "6月4日までに責任開始しない場合、契約年齢があがります。", "不備メッセージ");
        exStringEquals(hubiMsg.get(0).getMessageId(), "WHC1016", "メッセージＩＤ");
        exStringEquals(hubiMsg.get(0).getMosno(), "791112303", "申込番号");
        exNumericEquals(hubiMsg.get(0).getRenno(), 1, "連番");
        exClassificationEquals(hubiMsg.get(0).getHubisyubetukbn(), C_HubisyubetuKbn.WARNING, "不備種別区分");
        exClassificationEquals(hubiMsg.get(0).getHubisyubetusyousaikbn(), C_HubisyubetusyousaiKbn.NONE, "不備種別詳細区分");

        exDateEquals((BizDate)MockObjectManager.getArgument(SetKisoKoumokuMockForSinkeiyaku.class, "setkykymdHantei", 0, 2), null, "領収日");
        exDateEquals((BizDate)MockObjectManager.getArgument(SetKisoKoumokuMockForSinkeiyaku.class, "setkykymdHantei", 0, 3), BizDate.valueOf(20160701), "申込日");
        exDateEquals((BizDate)MockObjectManager.getArgument(SetKisoKoumokuMockForSinkeiyaku.class, "setkykymdHantei", 0, 4), BizDate.valueOf(20160701), "責任開始日");
        exDateEquals((BizDate)MockObjectManager.getArgument(SetKisoKoumokuMockForSinkeiyaku.class, "setkykymdHantei", 0, 5), BizDate.valueOf(20160701), "処理日");
        exClassificationEquals((C_SysKbn)MockObjectManager.getArgument(SetKisoKoumokuMockForSinkeiyaku.class, "setkykymdHantei", 0, 6), C_SysKbn.SKEI, "システム区分");
        exClassificationEquals((C_YoteikykymdKbn)MockObjectManager.getArgument(SetKisoKoumokuMockForSinkeiyaku.class, "setkykymdHantei", 0, 7), C_YoteikykymdKbn.AUTO, "予定契約日区分");
        exDateEquals((BizDate)MockObjectManager.getArgument(SetKisoKoumokuMockForSinkeiyaku.class, "setkykymdHantei", 1, 2), null, "領収日");
        exDateEquals((BizDate)MockObjectManager.getArgument(SetKisoKoumokuMockForSinkeiyaku.class, "setkykymdHantei", 1, 3), BizDate.valueOf(20160907), "申込日");
        exDateEquals((BizDate)MockObjectManager.getArgument(SetKisoKoumokuMockForSinkeiyaku.class, "setkykymdHantei", 1, 4), BizDate.valueOf(20160907), "責任開始日");
        exDateEquals((BizDate)MockObjectManager.getArgument(SetKisoKoumokuMockForSinkeiyaku.class, "setkykymdHantei", 1, 5), BizDate.valueOf(20160907), "処理日");
        exClassificationEquals((C_SysKbn)MockObjectManager.getArgument(SetKisoKoumokuMockForSinkeiyaku.class, "setkykymdHantei", 0, 6), C_SysKbn.SKEI, "システム区分");
        exClassificationEquals((C_YoteikykymdKbn)MockObjectManager.getArgument(SetKisoKoumokuMockForSinkeiyaku.class, "setkykymdHantei", 0, 7), C_YoteikykymdKbn.AUTO, "予定契約日区分");

        exDateEquals((BizDate)MockObjectManager.getArgument(SetKisoKoumokuMockForSinkeiyaku.class, "getNextkykymd", 0, 2), BizDate.valueOf(20180504), "基準日");
        exDateEquals((BizDate)MockObjectManager.getArgument(SetKisoKoumokuMockForSinkeiyaku.class, "getNextkykymd", 1, 2), BizDate.valueOf(20160907), "基準日");

        exDateEquals((BizDate)MockObjectManager.getArgument(SetNenreiMockForSinkeiyaku.class, "exec", 0, 0), BizDate.valueOf(20180503), "基準日");
        exDateEquals((BizDate)MockObjectManager.getArgument(SetNenreiMockForSinkeiyaku.class, "exec", 0, 1), BizDate.valueOf(20010505), "生年月日");
        exClassificationEquals((C_KetsrhkosKbn)MockObjectManager.getArgument(SetHubiMsgMockForSinkeiyaku.class, "exec", 0, 0), C_KetsrhkosKbn.WARNING, "決定・成立保留更新区分");
        exStringEquals((String)MockObjectManager.getArgument(SetHubiMsgMockForSinkeiyaku.class, "exec", 0, 1), "WHC1016 6月4日までに責任開始しない場合、契約年齢があがります。", "メッセージ文言");
        exClassificationEquals((C_TknKbn)MockObjectManager.getArgument(SetHubiMsgMockForSinkeiyaku.class, "exec", 0, 3), C_TknKbn.NONE, "特認区分");
        exClassificationEquals((C_MsgKbn)MockObjectManager.getArgument(SetHubiMsgMockForSinkeiyaku.class, "exec", 0, 4), C_MsgKbn.WARNING, "メッセージ区分");

    }

    @Test
    @Transactional
    @TestOrder(110)
    public void testExec_A11() {

        MockObjectManager.initialize();
        HanteiMoschkMockForSinkeiyaku.SYORIPTN = HanteiMoschkMockForSinkeiyaku.TESTPATTERN3;
        SetKisoKoumokuMockForSinkeiyaku.SYORIPTN = SetKisoKoumokuMockForSinkeiyaku.TESTPATTERN6;
        SetNenreiMockForSinkeiyaku.SYORIPTN = SetNenreiMockForSinkeiyaku.TESTPATTERN1;
        SetHubiMsgMockForSinkeiyaku.SYORIPTN = SetHubiMsgMockForSinkeiyaku.TESTPATTERN3;

        CheckHokenRyouYuukouKigen checkHokenRyouYuukouKigen = SWAKInjector.getInstance(CheckHokenRyouYuukouKigen.class);
        MosnaiCheckParam mosnaiCheckParam = SWAKInjector.getInstance(MosnaiCheckParam.class);

        sinkeiyakuDomManager.flush();
        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("791112311");
        List<HT_HubiMsg> hubiMsg = syoriCTL.getHubiMsgs();
        BM_SyouhnZokusei syouhnZokusei = bizDomManager.getSyouhnZokusei("ﾕｲ", 2);
        mosnaiCheckParam.setSyuSyouhnZokusei(syouhnZokusei);
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setSysDate(BizDate.valueOf("20160907"));
        mosnaiCheckParam.setListHubiMsg(hubiMsg);
        checkHokenRyouYuukouKigen.exec(mosnaiCheckParam);

        exNumericEquals(hubiMsg.size(), 1, "不備メッセージ件数");
        exStringEquals(hubiMsg.get(0).getHubimsg(), "6月4日までに責任開始しない場合、契約年齢があがります。", "不備メッセージ");
        exStringEquals(hubiMsg.get(0).getMessageId(), "WHC1016", "メッセージＩＤ");
        exStringEquals(hubiMsg.get(0).getMosno(), "791112311", "申込番号");
        exNumericEquals(hubiMsg.get(0).getRenno(), 1, "連番");
        exClassificationEquals(hubiMsg.get(0).getHubisyubetukbn(), C_HubisyubetuKbn.WARNING, "不備種別区分");
        exClassificationEquals(hubiMsg.get(0).getHubisyubetusyousaikbn(), C_HubisyubetusyousaiKbn.NONE, "不備種別詳細区分");

        exDateEquals((BizDate)MockObjectManager.getArgument(SetKisoKoumokuMockForSinkeiyaku.class, "setkykymdHantei", 0, 2), null, "領収日");
        exDateEquals((BizDate)MockObjectManager.getArgument(SetKisoKoumokuMockForSinkeiyaku.class, "setkykymdHantei", 0, 3), BizDate.valueOf(20160701), "申込日");
        exDateEquals((BizDate)MockObjectManager.getArgument(SetKisoKoumokuMockForSinkeiyaku.class, "setkykymdHantei", 0, 4), BizDate.valueOf(20160701), "責任開始日");
        exDateEquals((BizDate)MockObjectManager.getArgument(SetKisoKoumokuMockForSinkeiyaku.class, "setkykymdHantei", 0, 5), BizDate.valueOf(20160701), "処理日");
        exClassificationEquals((C_SysKbn)MockObjectManager.getArgument(SetKisoKoumokuMockForSinkeiyaku.class, "setkykymdHantei", 0, 6), C_SysKbn.SKEI, "システム区分");
        exClassificationEquals((C_YoteikykymdKbn)MockObjectManager.getArgument(SetKisoKoumokuMockForSinkeiyaku.class, "setkykymdHantei", 0, 7), C_YoteikykymdKbn.AUTO, "予定契約日区分");
        exDateEquals((BizDate)MockObjectManager.getArgument(SetKisoKoumokuMockForSinkeiyaku.class, "setkykymdHantei", 1, 2), null, "領収日");
        exDateEquals((BizDate)MockObjectManager.getArgument(SetKisoKoumokuMockForSinkeiyaku.class, "setkykymdHantei", 1, 3), BizDate.valueOf(20160907), "申込日");
        exDateEquals((BizDate)MockObjectManager.getArgument(SetKisoKoumokuMockForSinkeiyaku.class, "setkykymdHantei", 1, 4), BizDate.valueOf(20160907), "責任開始日");
        exDateEquals((BizDate)MockObjectManager.getArgument(SetKisoKoumokuMockForSinkeiyaku.class, "setkykymdHantei", 1, 5), BizDate.valueOf(20160907), "処理日");
        exClassificationEquals((C_SysKbn)MockObjectManager.getArgument(SetKisoKoumokuMockForSinkeiyaku.class, "setkykymdHantei", 0, 6), C_SysKbn.SKEI, "システム区分");
        exClassificationEquals((C_YoteikykymdKbn)MockObjectManager.getArgument(SetKisoKoumokuMockForSinkeiyaku.class, "setkykymdHantei", 0, 7), C_YoteikykymdKbn.AUTO, "予定契約日区分");

        exDateEquals((BizDate)MockObjectManager.getArgument(SetKisoKoumokuMockForSinkeiyaku.class, "getNextkykymd", 0, 2), BizDate.valueOf(20180505), "基準日");
        exDateEquals((BizDate)MockObjectManager.getArgument(SetKisoKoumokuMockForSinkeiyaku.class, "getNextkykymd", 1, 2), BizDate.valueOf(20160907), "基準日");

        exDateEquals((BizDate)MockObjectManager.getArgument(SetNenreiMockForSinkeiyaku.class, "exec", 0, 0), BizDate.valueOf(20180503), "基準日");
        exDateEquals((BizDate)MockObjectManager.getArgument(SetNenreiMockForSinkeiyaku.class, "exec", 0, 1), BizDate.valueOf(20010505), "生年月日");
        exClassificationEquals((C_KetsrhkosKbn)MockObjectManager.getArgument(SetHubiMsgMockForSinkeiyaku.class, "exec", 0, 0), C_KetsrhkosKbn.WARNING, "決定・成立保留更新区分");
        exStringEquals((String)MockObjectManager.getArgument(SetHubiMsgMockForSinkeiyaku.class, "exec", 0, 1), "WHC1016 6月4日までに責任開始しない場合、契約年齢があがります。", "メッセージ文言");
        exClassificationEquals((C_TknKbn)MockObjectManager.getArgument(SetHubiMsgMockForSinkeiyaku.class, "exec", 0, 3), C_TknKbn.NONE, "特認区分");
        exClassificationEquals((C_MsgKbn)MockObjectManager.getArgument(SetHubiMsgMockForSinkeiyaku.class, "exec", 0, 4), C_MsgKbn.WARNING, "メッセージ区分");

    }

    @Test
    @Transactional
    @TestOrder(120)
    public void testExec_A12() {

        MockObjectManager.initialize();
        HanteiMoschkMockForSinkeiyaku.SYORIPTN = HanteiMoschkMockForSinkeiyaku.TESTPATTERN3;
        SetKisoKoumokuMockForSinkeiyaku.SYORIPTN = SetKisoKoumokuMockForSinkeiyaku.TESTPATTERN4;

        CheckHokenRyouYuukouKigen checkHokenRyouYuukouKigen = SWAKInjector.getInstance(CheckHokenRyouYuukouKigen.class);
        MosnaiCheckParam mosnaiCheckParam = SWAKInjector.getInstance(MosnaiCheckParam.class);

        sinkeiyakuDomManager.flush();
        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("791112378");
        List<HT_HubiMsg> hubiMsg = syoriCTL.getHubiMsgs();
        BM_SyouhnZokusei syouhnZokusei = bizDomManager.getSyouhnZokusei("ﾕｳ", 7);
        mosnaiCheckParam.setSyuSyouhnZokusei(syouhnZokusei);
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setSysDate(BizDate.valueOf("20160907"));
        mosnaiCheckParam.setListHubiMsg(hubiMsg);
        checkHokenRyouYuukouKigen.exec(mosnaiCheckParam);

        exNumericEquals(hubiMsg.size(), 0, "不備メッセージ件数");

        exDateEquals((BizDate)MockObjectManager.getArgument(SetKisoKoumokuMockForSinkeiyaku.class, "setkykymdHantei", 1, 2), null, "領収日");
        exDateEquals((BizDate)MockObjectManager.getArgument(SetKisoKoumokuMockForSinkeiyaku.class, "setkykymdHantei", 1, 3), BizDate.valueOf(20160907), "申込日");
        exDateEquals((BizDate)MockObjectManager.getArgument(SetKisoKoumokuMockForSinkeiyaku.class, "setkykymdHantei", 1, 4), BizDate.valueOf(20160907), "責任開始日");
        exDateEquals((BizDate)MockObjectManager.getArgument(SetKisoKoumokuMockForSinkeiyaku.class, "setkykymdHantei", 1, 5), BizDate.valueOf(20160907), "処理日");
        exClassificationEquals((C_SysKbn)MockObjectManager.getArgument(SetKisoKoumokuMockForSinkeiyaku.class, "setkykymdHantei", 0, 6), C_SysKbn.SKEI, "システム区分");
        exClassificationEquals((C_YoteikykymdKbn)MockObjectManager.getArgument(SetKisoKoumokuMockForSinkeiyaku.class, "setkykymdHantei", 0, 7), C_YoteikykymdKbn.AUTO, "予定契約日区分");

        exDateEquals((BizDate)MockObjectManager.getArgument(SetKisoKoumokuMockForSinkeiyaku.class, "getNextkykymd", 0, 2), BizDate.valueOf(20180505), "基準日");
    }

    @Test
    @Transactional
    @TestOrder(130)
    public void testExec_A13() {

        MockObjectManager.initialize();
        HanteiMoschkMockForSinkeiyaku.SYORIPTN = HanteiMoschkMockForSinkeiyaku.TESTPATTERN3;
        SetKisoKoumokuMockForSinkeiyaku.SYORIPTN = SetKisoKoumokuMockForSinkeiyaku.TESTPATTERN4;

        CheckHokenRyouYuukouKigen checkHokenRyouYuukouKigen = SWAKInjector.getInstance(CheckHokenRyouYuukouKigen.class);
        MosnaiCheckParam mosnaiCheckParam = SWAKInjector.getInstance(MosnaiCheckParam.class);

        sinkeiyakuDomManager.flush();
        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("791112386");
        List<HT_HubiMsg> hubiMsg = syoriCTL.getHubiMsgs();
        BM_SyouhnZokusei syouhnZokusei = bizDomManager.getSyouhnZokusei("ﾕｴ", 7);
        mosnaiCheckParam.setSyuSyouhnZokusei(syouhnZokusei);
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setSysDate(BizDate.valueOf("20160907"));
        mosnaiCheckParam.setListHubiMsg(hubiMsg);
        checkHokenRyouYuukouKigen.exec(mosnaiCheckParam);

        exNumericEquals(hubiMsg.size(), 0, "不備メッセージ件数");

        exDateEquals((BizDate)MockObjectManager.getArgument(SetKisoKoumokuMockForSinkeiyaku.class, "setkykymdHantei", 1, 2), null, "領収日");
        exDateEquals((BizDate)MockObjectManager.getArgument(SetKisoKoumokuMockForSinkeiyaku.class, "setkykymdHantei", 1, 3), BizDate.valueOf(20160907), "申込日");
        exDateEquals((BizDate)MockObjectManager.getArgument(SetKisoKoumokuMockForSinkeiyaku.class, "setkykymdHantei", 1, 4), BizDate.valueOf(20160907), "責任開始日");
        exDateEquals((BizDate)MockObjectManager.getArgument(SetKisoKoumokuMockForSinkeiyaku.class, "setkykymdHantei", 1, 5), BizDate.valueOf(20160907), "処理日");
        exClassificationEquals((C_SysKbn)MockObjectManager.getArgument(SetKisoKoumokuMockForSinkeiyaku.class, "setkykymdHantei", 0, 6), C_SysKbn.SKEI, "システム区分");
        exClassificationEquals((C_YoteikykymdKbn)MockObjectManager.getArgument(SetKisoKoumokuMockForSinkeiyaku.class, "setkykymdHantei", 0, 7), C_YoteikykymdKbn.AUTO, "予定契約日区分");

        exDateEquals((BizDate)MockObjectManager.getArgument(SetKisoKoumokuMockForSinkeiyaku.class, "getNextkykymd", 0, 2), BizDate.valueOf(20180505), "基準日");

    }


    @Test
    @Transactional
    @TestOrder(140)
    public void testExec_A14() {

        MockObjectManager.initialize();
        HanteiMoschkMockForSinkeiyaku.SYORIPTN = HanteiMoschkMockForSinkeiyaku.TESTPATTERN5;
        SetKisoKoumokuMockForSinkeiyaku.SYORIPTN = SetKisoKoumokuMockForSinkeiyaku.TESTPATTERN4;

        CheckHokenRyouYuukouKigen checkHokenRyouYuukouKigen = SWAKInjector.getInstance(CheckHokenRyouYuukouKigen.class);
        MosnaiCheckParam mosnaiCheckParam = SWAKInjector.getInstance(MosnaiCheckParam.class);

        sinkeiyakuDomManager.flush();
        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("791112329");
        List<HT_HubiMsg> hubiMsg = syoriCTL.getHubiMsgs();
        BM_SyouhnZokusei syouhnZokusei = bizDomManager.getSyouhnZokusei("ﾕｳ", 2);
        mosnaiCheckParam.setSyuSyouhnZokusei(syouhnZokusei);
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setSysDate(BizDate.valueOf("20160907"));
        mosnaiCheckParam.setListHubiMsg(hubiMsg);
        checkHokenRyouYuukouKigen.exec(mosnaiCheckParam);

        exNumericEquals(hubiMsg.size(), 0, "不備メッセージ件数");

        exDateEquals((BizDate)MockObjectManager.getArgument(SetKisoKoumokuMockForSinkeiyaku.class, "setkykymdHantei", 0, 2), null, "領収日");
        exDateEquals((BizDate)MockObjectManager.getArgument(SetKisoKoumokuMockForSinkeiyaku.class, "setkykymdHantei", 0, 3), BizDate.valueOf(20160701), "申込日");
        exDateEquals((BizDate)MockObjectManager.getArgument(SetKisoKoumokuMockForSinkeiyaku.class, "setkykymdHantei", 0, 4), BizDate.valueOf(20160701), "責任開始日");
        exDateEquals((BizDate)MockObjectManager.getArgument(SetKisoKoumokuMockForSinkeiyaku.class, "setkykymdHantei", 0, 5), BizDate.valueOf(20160701), "処理日");
        exClassificationEquals((C_SysKbn)MockObjectManager.getArgument(SetKisoKoumokuMockForSinkeiyaku.class, "setkykymdHantei", 0, 6), C_SysKbn.SKEI, "システム区分");
        exClassificationEquals((C_YoteikykymdKbn)MockObjectManager.getArgument(SetKisoKoumokuMockForSinkeiyaku.class, "setkykymdHantei", 0, 7), C_YoteikykymdKbn.AUTO, "予定契約日区分");

        exDateEquals((BizDate)MockObjectManager.getArgument(SetKisoKoumokuMockForSinkeiyaku.class, "setkykymdHantei", 1, 2), null, "領収日");
        exDateEquals((BizDate)MockObjectManager.getArgument(SetKisoKoumokuMockForSinkeiyaku.class, "setkykymdHantei", 1, 3), BizDate.valueOf(20160907), "申込日");
        exDateEquals((BizDate)MockObjectManager.getArgument(SetKisoKoumokuMockForSinkeiyaku.class, "setkykymdHantei", 1, 4), BizDate.valueOf(20160907), "責任開始日");
        exDateEquals((BizDate)MockObjectManager.getArgument(SetKisoKoumokuMockForSinkeiyaku.class, "setkykymdHantei", 1, 5), BizDate.valueOf(20160907), "処理日");
        exClassificationEquals((C_SysKbn)MockObjectManager.getArgument(SetKisoKoumokuMockForSinkeiyaku.class, "setkykymdHantei", 0, 6), C_SysKbn.SKEI, "システム区分");
        exClassificationEquals((C_YoteikykymdKbn)MockObjectManager.getArgument(SetKisoKoumokuMockForSinkeiyaku.class, "setkykymdHantei", 0, 7), C_YoteikykymdKbn.AUTO, "予定契約日区分");

    }

    @Test
    @Transactional
    @TestOrder(150)
    public void testExec_A15() {

        MockObjectManager.initialize();
        HanteiMoschkMockForSinkeiyaku.SYORIPTN = HanteiMoschkMockForSinkeiyaku.TESTPATTERN5;
        SetKisoKoumokuMockForSinkeiyaku.SYORIPTN = SetKisoKoumokuMockForSinkeiyaku.TESTPATTERN4;
        SetNenreiMockForSinkeiyaku.SYORIPTN = SetNenreiMockForSinkeiyaku.TESTPATTERN1;

        CheckHokenRyouYuukouKigen checkHokenRyouYuukouKigen = SWAKInjector.getInstance(CheckHokenRyouYuukouKigen.class);
        MosnaiCheckParam mosnaiCheckParam = SWAKInjector.getInstance(MosnaiCheckParam.class);

        sinkeiyakuDomManager.flush();
        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("791112337");
        List<HT_HubiMsg> hubiMsg = syoriCTL.getHubiMsgs();
        BM_SyouhnZokusei syouhnZokusei = bizDomManager.getSyouhnZokusei("ﾕｴ", 2);
        mosnaiCheckParam.setSyuSyouhnZokusei(syouhnZokusei);
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setSysDate(BizDate.valueOf("20160907"));
        mosnaiCheckParam.setListHubiMsg(hubiMsg);
        checkHokenRyouYuukouKigen.exec(mosnaiCheckParam);

        exNumericEquals(hubiMsg.size(), 0, "不備メッセージ件数");

        exDateEquals((BizDate)MockObjectManager.getArgument(SetKisoKoumokuMockForSinkeiyaku.class, "setkykymdHantei", 0, 2), null, "領収日");
        exDateEquals((BizDate)MockObjectManager.getArgument(SetKisoKoumokuMockForSinkeiyaku.class, "setkykymdHantei", 0, 3), BizDate.valueOf(20160701), "申込日");
        exDateEquals((BizDate)MockObjectManager.getArgument(SetKisoKoumokuMockForSinkeiyaku.class, "setkykymdHantei", 0, 4), BizDate.valueOf(20160701), "責任開始日");
        exDateEquals((BizDate)MockObjectManager.getArgument(SetKisoKoumokuMockForSinkeiyaku.class, "setkykymdHantei", 0, 5), BizDate.valueOf(20160701), "処理日");
        exClassificationEquals((C_SysKbn)MockObjectManager.getArgument(SetKisoKoumokuMockForSinkeiyaku.class, "setkykymdHantei", 0, 6), C_SysKbn.SKEI, "システム区分");
        exClassificationEquals((C_YoteikykymdKbn)MockObjectManager.getArgument(SetKisoKoumokuMockForSinkeiyaku.class, "setkykymdHantei", 0, 7), C_YoteikykymdKbn.AUTO, "予定契約日区分");

        exDateEquals((BizDate)MockObjectManager.getArgument(SetKisoKoumokuMockForSinkeiyaku.class, "setkykymdHantei", 1, 2), null, "領収日");
        exDateEquals((BizDate)MockObjectManager.getArgument(SetKisoKoumokuMockForSinkeiyaku.class, "setkykymdHantei", 1, 3), BizDate.valueOf(20160907), "申込日");
        exDateEquals((BizDate)MockObjectManager.getArgument(SetKisoKoumokuMockForSinkeiyaku.class, "setkykymdHantei", 1, 4), BizDate.valueOf(20160907), "責任開始日");
        exDateEquals((BizDate)MockObjectManager.getArgument(SetKisoKoumokuMockForSinkeiyaku.class, "setkykymdHantei", 1, 5), BizDate.valueOf(20160907), "処理日");
        exClassificationEquals((C_SysKbn)MockObjectManager.getArgument(SetKisoKoumokuMockForSinkeiyaku.class, "setkykymdHantei", 0, 6), C_SysKbn.SKEI, "システム区分");
        exClassificationEquals((C_YoteikykymdKbn)MockObjectManager.getArgument(SetKisoKoumokuMockForSinkeiyaku.class, "setkykymdHantei", 0, 7), C_YoteikykymdKbn.AUTO, "予定契約日区分");

        exDateEquals((BizDate)MockObjectManager.getArgument(SetNenreiMockForSinkeiyaku.class, "exec", 0, 0), BizDate.valueOf(20180503), "基準日");
        exDateEquals((BizDate)MockObjectManager.getArgument(SetNenreiMockForSinkeiyaku.class, "exec", 0, 1), BizDate.valueOf(20010505), "生年月日");
    }

    @Test
    @Transactional
    @TestOrder(160)
    public void testExec_A16() {

        MockObjectManager.initialize();
        HanteiMoschkMockForSinkeiyaku.SYORIPTN = HanteiMoschkMockForSinkeiyaku.TESTPATTERN5;
        SetKisoKoumokuMockForSinkeiyaku.SYORIPTN = SetKisoKoumokuMockForSinkeiyaku.TESTPATTERN4;
        SetNenreiMockForSinkeiyaku.SYORIPTN = SetNenreiMockForSinkeiyaku.TESTPATTERN6;
        SetHubiMsgMockForSinkeiyaku.SYORIPTN = SetHubiMsgMockForSinkeiyaku.TESTPATTERN4;

        CheckHokenRyouYuukouKigen checkHokenRyouYuukouKigen = SWAKInjector.getInstance(CheckHokenRyouYuukouKigen.class);
        MosnaiCheckParam mosnaiCheckParam = SWAKInjector.getInstance(MosnaiCheckParam.class);

        sinkeiyakuDomManager.flush();
        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("791112345");
        List<HT_HubiMsg> hubiMsg = syoriCTL.getHubiMsgs();
        BM_SyouhnZokusei syouhnZokusei = bizDomManager.getSyouhnZokusei("ﾕｵ", 2);
        mosnaiCheckParam.setSyuSyouhnZokusei(syouhnZokusei);
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setSysDate(BizDate.valueOf("20160907"));
        mosnaiCheckParam.setListHubiMsg(hubiMsg);
        checkHokenRyouYuukouKigen.exec(mosnaiCheckParam);

        exNumericEquals(hubiMsg.size(), 1, "不備メッセージ件数");
        exStringEquals(hubiMsg.get(0).getHubimsg(), "保険料有効期限を過ぎたため契約年齢範囲外となる可能性があります。", "不備メッセージ");
        exStringEquals(hubiMsg.get(0).getMessageId(), "WHC1017", "メッセージＩＤ");
        exStringEquals(hubiMsg.get(0).getMosno(), "791112345", "申込番号");
        exNumericEquals(hubiMsg.get(0).getRenno(), 1, "連番");
        exClassificationEquals(hubiMsg.get(0).getHubisyubetukbn(), C_HubisyubetuKbn.WARNING, "不備種別区分");
        exClassificationEquals(hubiMsg.get(0).getHubisyubetusyousaikbn(), C_HubisyubetusyousaiKbn.NONE, "不備種別詳細区分");

        exDateEquals((BizDate)MockObjectManager.getArgument(SetKisoKoumokuMockForSinkeiyaku.class, "setkykymdHantei", 0, 2), null, "領収日");
        exDateEquals((BizDate)MockObjectManager.getArgument(SetKisoKoumokuMockForSinkeiyaku.class, "setkykymdHantei", 0, 3), BizDate.valueOf(20160701), "申込日");
        exDateEquals((BizDate)MockObjectManager.getArgument(SetKisoKoumokuMockForSinkeiyaku.class, "setkykymdHantei", 0, 4), BizDate.valueOf(20160701), "責任開始日");
        exDateEquals((BizDate)MockObjectManager.getArgument(SetKisoKoumokuMockForSinkeiyaku.class, "setkykymdHantei", 0, 5), BizDate.valueOf(20160701), "処理日");
        exClassificationEquals((C_SysKbn)MockObjectManager.getArgument(SetKisoKoumokuMockForSinkeiyaku.class, "setkykymdHantei", 0, 6), C_SysKbn.SKEI, "システム区分");
        exClassificationEquals((C_YoteikykymdKbn)MockObjectManager.getArgument(SetKisoKoumokuMockForSinkeiyaku.class, "setkykymdHantei", 0, 7), C_YoteikykymdKbn.AUTO, "予定契約日区分");

        exDateEquals((BizDate)MockObjectManager.getArgument(SetKisoKoumokuMockForSinkeiyaku.class, "setkykymdHantei", 1, 2), null, "領収日");
        exDateEquals((BizDate)MockObjectManager.getArgument(SetKisoKoumokuMockForSinkeiyaku.class, "setkykymdHantei", 1, 3), BizDate.valueOf(20160907), "申込日");
        exDateEquals((BizDate)MockObjectManager.getArgument(SetKisoKoumokuMockForSinkeiyaku.class, "setkykymdHantei", 1, 4), BizDate.valueOf(20160907), "責任開始日");
        exDateEquals((BizDate)MockObjectManager.getArgument(SetKisoKoumokuMockForSinkeiyaku.class, "setkykymdHantei", 1, 5), BizDate.valueOf(20160907), "処理日");
        exClassificationEquals((C_SysKbn)MockObjectManager.getArgument(SetKisoKoumokuMockForSinkeiyaku.class, "setkykymdHantei", 0, 6), C_SysKbn.SKEI, "システム区分");
        exClassificationEquals((C_YoteikykymdKbn)MockObjectManager.getArgument(SetKisoKoumokuMockForSinkeiyaku.class, "setkykymdHantei", 0, 7), C_YoteikykymdKbn.AUTO, "予定契約日区分");

        exDateEquals((BizDate)MockObjectManager.getArgument(SetNenreiMockForSinkeiyaku.class, "exec", 0, 0), BizDate.valueOf(20180503), "基準日");
        exDateEquals((BizDate)MockObjectManager.getArgument(SetNenreiMockForSinkeiyaku.class, "exec", 0, 1), BizDate.valueOf(20010504), "生年月日");

        exClassificationEquals((C_KetsrhkosKbn)MockObjectManager.getArgument(SetHubiMsgMockForSinkeiyaku.class, "exec", 0, 0), C_KetsrhkosKbn.WARNING, "決定・成立保留更新区分");
        exStringEquals((String)MockObjectManager.getArgument(SetHubiMsgMockForSinkeiyaku.class, "exec", 0, 1), "WHC1017 保険料有効期限を過ぎたため契約年齢範囲外となる可能性があります。", "メッセージ文言");
        exClassificationEquals((C_TknKbn)MockObjectManager.getArgument(SetHubiMsgMockForSinkeiyaku.class, "exec", 0, 3), C_TknKbn.NONE, "特認区分");
        exClassificationEquals((C_MsgKbn)MockObjectManager.getArgument(SetHubiMsgMockForSinkeiyaku.class, "exec", 0, 4), C_MsgKbn.WARNING, "メッセージ区分");
    }

    @Test
    @Transactional
    @TestOrder(170)
    public void testExec_A17() {

        MockObjectManager.initialize();
        HanteiMoschkMockForSinkeiyaku.SYORIPTN = HanteiMoschkMockForSinkeiyaku.TESTPATTERN5;
        SetKisoKoumokuMockForSinkeiyaku.SYORIPTN = SetKisoKoumokuMockForSinkeiyaku.TESTPATTERN7;
        SetNenreiMockForSinkeiyaku.SYORIPTN = SetNenreiMockForSinkeiyaku.TESTPATTERN1;
        SetHubiMsgMockForSinkeiyaku.SYORIPTN = SetHubiMsgMockForSinkeiyaku.TESTPATTERN5;

        CheckHokenRyouYuukouKigen checkHokenRyouYuukouKigen = SWAKInjector.getInstance(CheckHokenRyouYuukouKigen.class);
        MosnaiCheckParam mosnaiCheckParam = SWAKInjector.getInstance(MosnaiCheckParam.class);

        sinkeiyakuDomManager.flush();
        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("791112352");
        List<HT_HubiMsg> hubiMsg = syoriCTL.getHubiMsgs();
        BM_SyouhnZokusei syouhnZokusei = bizDomManager.getSyouhnZokusei("ﾕｶ", 2);
        mosnaiCheckParam.setSyuSyouhnZokusei(syouhnZokusei);
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setSysDate(BizDate.valueOf("20160907"));
        mosnaiCheckParam.setListHubiMsg(hubiMsg);
        checkHokenRyouYuukouKigen.exec(mosnaiCheckParam);

        exNumericEquals(hubiMsg.size(), 1, "不備メッセージ件数");
        exStringEquals(hubiMsg.get(0).getHubimsg(), "保険料有効期限を過ぎたため契約年齢があがっている可能性があります。", "不備メッセージ");
        exStringEquals(hubiMsg.get(0).getMessageId(), "WHC1018", "メッセージＩＤ");
        exStringEquals(hubiMsg.get(0).getMosno(), "791112352", "申込番号");
        exNumericEquals(hubiMsg.get(0).getRenno(), 1, "連番");
        exClassificationEquals(hubiMsg.get(0).getHubisyubetukbn(), C_HubisyubetuKbn.WARNING, "不備種別区分");
        exClassificationEquals(hubiMsg.get(0).getHubisyubetusyousaikbn(), C_HubisyubetusyousaiKbn.NONE, "不備種別詳細区分");

        exDateEquals((BizDate)MockObjectManager.getArgument(SetKisoKoumokuMockForSinkeiyaku.class, "setkykymdHantei", 0, 2), null, "領収日");
        exDateEquals((BizDate)MockObjectManager.getArgument(SetKisoKoumokuMockForSinkeiyaku.class, "setkykymdHantei", 0, 3), BizDate.valueOf(20160701), "申込日");
        exDateEquals((BizDate)MockObjectManager.getArgument(SetKisoKoumokuMockForSinkeiyaku.class, "setkykymdHantei", 0, 4), BizDate.valueOf(20160701), "責任開始日");
        exDateEquals((BizDate)MockObjectManager.getArgument(SetKisoKoumokuMockForSinkeiyaku.class, "setkykymdHantei", 0, 5), BizDate.valueOf(20160701), "処理日");
        exClassificationEquals((C_SysKbn)MockObjectManager.getArgument(SetKisoKoumokuMockForSinkeiyaku.class, "setkykymdHantei", 0, 6), C_SysKbn.SKEI, "システム区分");
        exClassificationEquals((C_YoteikykymdKbn)MockObjectManager.getArgument(SetKisoKoumokuMockForSinkeiyaku.class, "setkykymdHantei", 0, 7), C_YoteikykymdKbn.AUTO, "予定契約日区分");

        exDateEquals((BizDate)MockObjectManager.getArgument(SetKisoKoumokuMockForSinkeiyaku.class, "setkykymdHantei", 1, 2), null, "領収日");
        exDateEquals((BizDate)MockObjectManager.getArgument(SetKisoKoumokuMockForSinkeiyaku.class, "setkykymdHantei", 1, 3), BizDate.valueOf(20160907), "申込日");
        exDateEquals((BizDate)MockObjectManager.getArgument(SetKisoKoumokuMockForSinkeiyaku.class, "setkykymdHantei", 1, 4), BizDate.valueOf(20160907), "責任開始日");
        exDateEquals((BizDate)MockObjectManager.getArgument(SetKisoKoumokuMockForSinkeiyaku.class, "setkykymdHantei", 1, 5), BizDate.valueOf(20160907), "処理日");
        exClassificationEquals((C_SysKbn)MockObjectManager.getArgument(SetKisoKoumokuMockForSinkeiyaku.class, "setkykymdHantei", 0, 6), C_SysKbn.SKEI, "システム区分");
        exClassificationEquals((C_YoteikykymdKbn)MockObjectManager.getArgument(SetKisoKoumokuMockForSinkeiyaku.class, "setkykymdHantei", 0, 7), C_YoteikykymdKbn.AUTO, "予定契約日区分");

        exDateEquals((BizDate)MockObjectManager.getArgument(SetNenreiMockForSinkeiyaku.class, "exec", 0, 0), BizDate.valueOf(20180502), "基準日");
        exDateEquals((BizDate)MockObjectManager.getArgument(SetNenreiMockForSinkeiyaku.class, "exec", 0, 1), BizDate.valueOf(20010504), "生年月日");

        exClassificationEquals((C_KetsrhkosKbn)MockObjectManager.getArgument(SetHubiMsgMockForSinkeiyaku.class, "exec", 0, 0), C_KetsrhkosKbn.WARNING, "決定・成立保留更新区分");
        exStringEquals((String)MockObjectManager.getArgument(SetHubiMsgMockForSinkeiyaku.class, "exec", 0, 1), "WHC1018 保険料有効期限を過ぎたため契約年齢があがっている可能性があります。", "メッセージ文言");
        exClassificationEquals((C_TknKbn)MockObjectManager.getArgument(SetHubiMsgMockForSinkeiyaku.class, "exec", 0, 3), C_TknKbn.NONE, "特認区分");
        exClassificationEquals((C_MsgKbn)MockObjectManager.getArgument(SetHubiMsgMockForSinkeiyaku.class, "exec", 0, 4), C_MsgKbn.WARNING, "メッセージ区分");
    }

    @Test
    @Transactional
    @TestOrder(180)
    public void testExec_A18() {

        MockObjectManager.initialize();
        HanteiMoschkMockForSinkeiyaku.SYORIPTN = HanteiMoschkMockForSinkeiyaku.TESTPATTERN5;
        SetKisoKoumokuMockForSinkeiyaku.SYORIPTN = SetKisoKoumokuMockForSinkeiyaku.TESTPATTERN8;
        SetNenreiMockForSinkeiyaku.SYORIPTN = SetNenreiMockForSinkeiyaku.TESTPATTERN7;
        SetHubiMsgMockForSinkeiyaku.SYORIPTN = SetHubiMsgMockForSinkeiyaku.TESTPATTERN6;

        CheckHokenRyouYuukouKigen checkHokenRyouYuukouKigen = SWAKInjector.getInstance(CheckHokenRyouYuukouKigen.class);
        MosnaiCheckParam mosnaiCheckParam = SWAKInjector.getInstance(MosnaiCheckParam.class);

        sinkeiyakuDomManager.flush();
        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("791112360");
        List<HT_HubiMsg> hubiMsg = syoriCTL.getHubiMsgs();
        BM_SyouhnZokusei syouhnZokusei = bizDomManager.getSyouhnZokusei("ﾕｷ", 2);
        mosnaiCheckParam.setSyuSyouhnZokusei(syouhnZokusei);
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setSysDate(BizDate.valueOf("20160907"));
        mosnaiCheckParam.setListHubiMsg(hubiMsg);
        checkHokenRyouYuukouKigen.exec(mosnaiCheckParam);

        exNumericEquals(hubiMsg.size(), 1, "不備メッセージ件数");
        exStringEquals(hubiMsg.get(0).getHubimsg(), "保険料有効期限を過ぎたため契約年齢があがっている可能性があります。", "不備メッセージ");
        exStringEquals(hubiMsg.get(0).getMessageId(), "WHC1018", "メッセージＩＤ");
        exStringEquals(hubiMsg.get(0).getMosno(), "791112360", "申込番号");
        exNumericEquals(hubiMsg.get(0).getRenno(), 1, "連番");
        exClassificationEquals(hubiMsg.get(0).getHubisyubetukbn(), C_HubisyubetuKbn.WARNING, "不備種別区分");
        exClassificationEquals(hubiMsg.get(0).getHubisyubetusyousaikbn(), C_HubisyubetusyousaiKbn.NONE, "不備種別詳細区分");

        exDateEquals((BizDate)MockObjectManager.getArgument(SetKisoKoumokuMockForSinkeiyaku.class, "setkykymdHantei", 0, 2), null, "領収日");
        exDateEquals((BizDate)MockObjectManager.getArgument(SetKisoKoumokuMockForSinkeiyaku.class, "setkykymdHantei", 0, 3), BizDate.valueOf(20160701), "申込日");
        exDateEquals((BizDate)MockObjectManager.getArgument(SetKisoKoumokuMockForSinkeiyaku.class, "setkykymdHantei", 0, 4), BizDate.valueOf(20160701), "責任開始日");
        exDateEquals((BizDate)MockObjectManager.getArgument(SetKisoKoumokuMockForSinkeiyaku.class, "setkykymdHantei", 0, 5), BizDate.valueOf(20160701), "処理日");
        exClassificationEquals((C_SysKbn)MockObjectManager.getArgument(SetKisoKoumokuMockForSinkeiyaku.class, "setkykymdHantei", 0, 6), C_SysKbn.SKEI, "システム区分");
        exClassificationEquals((C_YoteikykymdKbn)MockObjectManager.getArgument(SetKisoKoumokuMockForSinkeiyaku.class, "setkykymdHantei", 0, 7), C_YoteikykymdKbn.AUTO, "予定契約日区分");

        exDateEquals((BizDate)MockObjectManager.getArgument(SetKisoKoumokuMockForSinkeiyaku.class, "setkykymdHantei", 1, 2), null, "領収日");
        exDateEquals((BizDate)MockObjectManager.getArgument(SetKisoKoumokuMockForSinkeiyaku.class, "setkykymdHantei", 1, 3), BizDate.valueOf(20160907), "申込日");
        exDateEquals((BizDate)MockObjectManager.getArgument(SetKisoKoumokuMockForSinkeiyaku.class, "setkykymdHantei", 1, 4), BizDate.valueOf(20160907), "責任開始日");
        exDateEquals((BizDate)MockObjectManager.getArgument(SetKisoKoumokuMockForSinkeiyaku.class, "setkykymdHantei", 1, 5), BizDate.valueOf(20160907), "処理日");
        exClassificationEquals((C_SysKbn)MockObjectManager.getArgument(SetKisoKoumokuMockForSinkeiyaku.class, "setkykymdHantei", 0, 6), C_SysKbn.SKEI, "システム区分");
        exClassificationEquals((C_YoteikykymdKbn)MockObjectManager.getArgument(SetKisoKoumokuMockForSinkeiyaku.class, "setkykymdHantei", 0, 7), C_YoteikykymdKbn.AUTO, "予定契約日区分");

        exDateEquals((BizDate)MockObjectManager.getArgument(SetNenreiMockForSinkeiyaku.class, "exec", 0, 0), BizDate.valueOf(20180503), "基準日");
        exDateEquals((BizDate)MockObjectManager.getArgument(SetNenreiMockForSinkeiyaku.class, "exec", 0, 1), BizDate.valueOf(20010504), "生年月日");

        exClassificationEquals((C_KetsrhkosKbn)MockObjectManager.getArgument(SetHubiMsgMockForSinkeiyaku.class, "exec", 0, 0), C_KetsrhkosKbn.WARNING, "決定・成立保留更新区分");
        exStringEquals((String)MockObjectManager.getArgument(SetHubiMsgMockForSinkeiyaku.class, "exec", 0, 1), "WHC1018 保険料有効期限を過ぎたため契約年齢があがっている可能性があります。", "メッセージ文言");
        exClassificationEquals((C_TknKbn)MockObjectManager.getArgument(SetHubiMsgMockForSinkeiyaku.class, "exec", 0, 3), C_TknKbn.NONE, "特認区分");
        exClassificationEquals((C_MsgKbn)MockObjectManager.getArgument(SetHubiMsgMockForSinkeiyaku.class, "exec", 0, 4), C_MsgKbn.WARNING, "メッセージ区分");
    }

    @Test
    @Transactional
    @TestOrder(190)
    public void testExec_A19() {

        MockObjectManager.initialize();
        HanteiMoschkMockForSinkeiyaku.SYORIPTN = HanteiMoschkMockForSinkeiyaku.TESTPATTERN5;
        SetKisoKoumokuMockForSinkeiyaku.SYORIPTN = SetKisoKoumokuMockForSinkeiyaku.TESTPATTERN4;

        CheckHokenRyouYuukouKigen checkHokenRyouYuukouKigen = SWAKInjector.getInstance(CheckHokenRyouYuukouKigen.class);
        MosnaiCheckParam mosnaiCheckParam = SWAKInjector.getInstance(MosnaiCheckParam.class);

        sinkeiyakuDomManager.flush();
        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("791113210");
        List<HT_HubiMsg> hubiMsg = syoriCTL.getHubiMsgs();
        BM_SyouhnZokusei syouhnZokusei = bizDomManager.getSyouhnZokusei("ﾕｸ", 2);
        mosnaiCheckParam.setSyuSyouhnZokusei(syouhnZokusei);
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setSysDate(BizDate.valueOf("20160907"));
        mosnaiCheckParam.setListHubiMsg(hubiMsg);
        checkHokenRyouYuukouKigen.exec(mosnaiCheckParam);

        exNumericEquals(hubiMsg.size(), 0, "不備メッセージ件数");

        exDateEquals((BizDate)MockObjectManager.getArgument(SetKisoKoumokuMockForSinkeiyaku.class, "setkykymdHantei", 0, 2), null, "領収日");
        exDateEquals((BizDate)MockObjectManager.getArgument(SetKisoKoumokuMockForSinkeiyaku.class, "setkykymdHantei", 0, 3), BizDate.valueOf(20160701), "申込日");
        exDateEquals((BizDate)MockObjectManager.getArgument(SetKisoKoumokuMockForSinkeiyaku.class, "setkykymdHantei", 0, 4), BizDate.valueOf(20160701), "責任開始日");
        exDateEquals((BizDate)MockObjectManager.getArgument(SetKisoKoumokuMockForSinkeiyaku.class, "setkykymdHantei", 0, 5), BizDate.valueOf(20160701), "処理日");
        exClassificationEquals((C_SysKbn)MockObjectManager.getArgument(SetKisoKoumokuMockForSinkeiyaku.class, "setkykymdHantei", 0, 6), C_SysKbn.SKEI, "システム区分");
        exClassificationEquals((C_YoteikykymdKbn)MockObjectManager.getArgument(SetKisoKoumokuMockForSinkeiyaku.class, "setkykymdHantei", 0, 7), C_YoteikykymdKbn.AUTO, "予定契約日区分");

        exDateEquals((BizDate)MockObjectManager.getArgument(SetKisoKoumokuMockForSinkeiyaku.class, "setkykymdHantei", 1, 2), null, "領収日");
        exDateEquals((BizDate)MockObjectManager.getArgument(SetKisoKoumokuMockForSinkeiyaku.class, "setkykymdHantei", 1, 3), BizDate.valueOf(20160907), "申込日");
        exDateEquals((BizDate)MockObjectManager.getArgument(SetKisoKoumokuMockForSinkeiyaku.class, "setkykymdHantei", 1, 4), BizDate.valueOf(20160907), "責任開始日");
        exDateEquals((BizDate)MockObjectManager.getArgument(SetKisoKoumokuMockForSinkeiyaku.class, "setkykymdHantei", 1, 5), BizDate.valueOf(20160907), "処理日");
        exClassificationEquals((C_SysKbn)MockObjectManager.getArgument(SetKisoKoumokuMockForSinkeiyaku.class, "setkykymdHantei", 0, 6), C_SysKbn.SKEI, "システム区分");
        exClassificationEquals((C_YoteikykymdKbn)MockObjectManager.getArgument(SetKisoKoumokuMockForSinkeiyaku.class, "setkykymdHantei", 0, 7), C_YoteikykymdKbn.AUTO, "予定契約日区分");
    }

    @Test
    @Transactional
    @TestOrder(200)
    public void testExec_A20() {

        MockObjectManager.initialize();
        HanteiMoschkMockForSinkeiyaku.SYORIPTN = HanteiMoschkMockForSinkeiyaku.TESTPATTERN5;
        SetKisoKoumokuMockForSinkeiyaku.SYORIPTN = SetKisoKoumokuMockForSinkeiyaku.TESTPATTERN4;

        CheckHokenRyouYuukouKigen checkHokenRyouYuukouKigen = SWAKInjector.getInstance(CheckHokenRyouYuukouKigen.class);
        MosnaiCheckParam mosnaiCheckParam = SWAKInjector.getInstance(MosnaiCheckParam.class);

        sinkeiyakuDomManager.flush();
        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("791113202");
        List<HT_HubiMsg> hubiMsg = syoriCTL.getHubiMsgs();
        BM_SyouhnZokusei syouhnZokusei = bizDomManager.getSyouhnZokusei("ﾕｱ", 3);
        mosnaiCheckParam.setSyuSyouhnZokusei(syouhnZokusei);
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setSysDate(BizDate.valueOf("20160907"));
        mosnaiCheckParam.setListHubiMsg(hubiMsg);
        checkHokenRyouYuukouKigen.exec(mosnaiCheckParam);

        exNumericEquals(hubiMsg.size(), 0, "不備メッセージ件数");
        exDateEquals((BizDate)MockObjectManager.getArgument(SetKisoKoumokuMockForSinkeiyaku.class, "setkykymdHantei", 0, 2), null, "領収日");
        exDateEquals((BizDate)MockObjectManager.getArgument(SetKisoKoumokuMockForSinkeiyaku.class, "setkykymdHantei", 0, 3), BizDate.valueOf(20160701), "申込日");
        exDateEquals((BizDate)MockObjectManager.getArgument(SetKisoKoumokuMockForSinkeiyaku.class, "setkykymdHantei", 0, 4), BizDate.valueOf(20160701), "責任開始日");
        exDateEquals((BizDate)MockObjectManager.getArgument(SetKisoKoumokuMockForSinkeiyaku.class, "setkykymdHantei", 0, 5), BizDate.valueOf(20160701), "処理日");
        exClassificationEquals((C_SysKbn)MockObjectManager.getArgument(SetKisoKoumokuMockForSinkeiyaku.class, "setkykymdHantei", 0, 6), C_SysKbn.SKEI, "システム区分");
        exClassificationEquals((C_YoteikykymdKbn)MockObjectManager.getArgument(SetKisoKoumokuMockForSinkeiyaku.class, "setkykymdHantei", 0, 7), C_YoteikykymdKbn.AUTO, "予定契約日区分");

        exDateEquals((BizDate)MockObjectManager.getArgument(SetKisoKoumokuMockForSinkeiyaku.class, "setkykymdHantei", 1, 2), null, "領収日");
        exDateEquals((BizDate)MockObjectManager.getArgument(SetKisoKoumokuMockForSinkeiyaku.class, "setkykymdHantei", 1, 3), BizDate.valueOf(20160907), "申込日");
        exDateEquals((BizDate)MockObjectManager.getArgument(SetKisoKoumokuMockForSinkeiyaku.class, "setkykymdHantei", 1, 4), BizDate.valueOf(20160907), "責任開始日");
        exDateEquals((BizDate)MockObjectManager.getArgument(SetKisoKoumokuMockForSinkeiyaku.class, "setkykymdHantei", 1, 5), BizDate.valueOf(20160907), "処理日");
        exClassificationEquals((C_SysKbn)MockObjectManager.getArgument(SetKisoKoumokuMockForSinkeiyaku.class, "setkykymdHantei", 0, 6), C_SysKbn.SKEI, "システム区分");
        exClassificationEquals((C_YoteikykymdKbn)MockObjectManager.getArgument(SetKisoKoumokuMockForSinkeiyaku.class, "setkykymdHantei", 0, 7), C_YoteikykymdKbn.AUTO, "予定契約日区分");
    }

    @Test
    @Transactional
    @TestOrder(210)
    public void testExec_A21() {

        MockObjectManager.initialize();
        HanteiMoschkMockForSinkeiyaku.SYORIPTN = HanteiMoschkMockForSinkeiyaku.TESTPATTERN6;

        CheckHokenRyouYuukouKigen checkHokenRyouYuukouKigen = SWAKInjector.getInstance(CheckHokenRyouYuukouKigen.class);
        MosnaiCheckParam mosnaiCheckParam = SWAKInjector.getInstance(MosnaiCheckParam.class);

        sinkeiyakuDomManager.flush();
        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("791112402");
        List<HT_HubiMsg> hubiMsg = syoriCTL.getHubiMsgs();
        BM_SyouhnZokusei syouhnZokusei = bizDomManager.getSyouhnZokusei("ﾕｳ", 3);
        mosnaiCheckParam.setSyuSyouhnZokusei(syouhnZokusei);
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setSysDate(BizDate.valueOf("20160907"));
        mosnaiCheckParam.setListHubiMsg(hubiMsg);
        checkHokenRyouYuukouKigen.exec(mosnaiCheckParam);

        exNumericEquals(hubiMsg.size(), 0, "不備メッセージ件数");

    }

    @Test
    @Transactional
    @TestOrder(220)
    public void testExec_A22() {

        MockObjectManager.initialize();
        HanteiMoschkMockForSinkeiyaku.SYORIPTN = HanteiMoschkMockForSinkeiyaku.TESTPATTERN6;
        SetKisoKoumokuMockForSinkeiyaku.SYORIPTN = SetKisoKoumokuMockForSinkeiyaku.TESTPATTERN1;
        SetNenreiMockForSinkeiyaku.SYORIPTN = SetNenreiMockForSinkeiyaku.TESTPATTERN1;

        CheckHokenRyouYuukouKigen checkHokenRyouYuukouKigen = SWAKInjector.getInstance(CheckHokenRyouYuukouKigen.class);
        MosnaiCheckParam mosnaiCheckParam = SWAKInjector.getInstance(MosnaiCheckParam.class);

        sinkeiyakuDomManager.flush();
        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("791112410");
        List<HT_HubiMsg> hubiMsg = syoriCTL.getHubiMsgs();
        BM_SyouhnZokusei syouhnZokusei = bizDomManager.getSyouhnZokusei("ﾕｴ", 3);
        mosnaiCheckParam.setSyuSyouhnZokusei(syouhnZokusei);
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setSysDate(BizDate.valueOf("20160907"));
        mosnaiCheckParam.setListHubiMsg(hubiMsg);
        checkHokenRyouYuukouKigen.exec(mosnaiCheckParam);

        exNumericEquals(hubiMsg.size(), 0, "不備メッセージ件数");

        exDateEquals((BizDate)MockObjectManager.getArgument(SetKisoKoumokuMockForSinkeiyaku.class, "setkykymdHantei", 0, 2), null, "領収日");
        exDateEquals((BizDate)MockObjectManager.getArgument(SetKisoKoumokuMockForSinkeiyaku.class, "setkykymdHantei", 0, 3), BizDate.valueOf(20160701), "申込日");
        exDateEquals((BizDate)MockObjectManager.getArgument(SetKisoKoumokuMockForSinkeiyaku.class, "setkykymdHantei", 0, 4), BizDate.valueOf(20160701), "責任開始日");
        exDateEquals((BizDate)MockObjectManager.getArgument(SetKisoKoumokuMockForSinkeiyaku.class, "setkykymdHantei", 0, 5), BizDate.valueOf(20160701), "処理日");
        exClassificationEquals((C_SysKbn)MockObjectManager.getArgument(SetKisoKoumokuMockForSinkeiyaku.class, "setkykymdHantei", 0, 6), C_SysKbn.SKEI, "システム区分");
        exClassificationEquals((C_YoteikykymdKbn)MockObjectManager.getArgument(SetKisoKoumokuMockForSinkeiyaku.class, "setkykymdHantei", 0, 7), C_YoteikykymdKbn.AUTO, "予定契約日区分");

        exDateEquals((BizDate)MockObjectManager.getArgument(SetNenreiMockForSinkeiyaku.class, "exec", 0, 0), BizDate.valueOf(20180203), "基準日");
        exDateEquals((BizDate)MockObjectManager.getArgument(SetNenreiMockForSinkeiyaku.class, "exec", 0, 1), BizDate.valueOf(20010505), "生年月日");

    }

    @Test
    @Transactional
    @TestOrder(230)
    public void testExec_A23() {

        MockObjectManager.initialize();
        HanteiMoschkMockForSinkeiyaku.SYORIPTN = HanteiMoschkMockForSinkeiyaku.TESTPATTERN6;
        SetKisoKoumokuMockForSinkeiyaku.SYORIPTN = SetKisoKoumokuMockForSinkeiyaku.TESTPATTERN1;
        SetNenreiMockForSinkeiyaku.SYORIPTN = SetNenreiMockForSinkeiyaku.TESTPATTERN1;
        SetHubiMsgMockForSinkeiyaku.SYORIPTN = SetHubiMsgMockForSinkeiyaku.TESTPATTERN5;

        CheckHokenRyouYuukouKigen checkHokenRyouYuukouKigen = SWAKInjector.getInstance(CheckHokenRyouYuukouKigen.class);
        MosnaiCheckParam mosnaiCheckParam = SWAKInjector.getInstance(MosnaiCheckParam.class);

        sinkeiyakuDomManager.flush();
        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("791112428");
        List<HT_HubiMsg> hubiMsg = syoriCTL.getHubiMsgs();
        BM_SyouhnZokusei syouhnZokusei = bizDomManager.getSyouhnZokusei("ﾕA", 3);
        mosnaiCheckParam.setSyuSyouhnZokusei(syouhnZokusei);
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setSysDate(BizDate.valueOf("20160907"));
        mosnaiCheckParam.setListHubiMsg(hubiMsg);
        checkHokenRyouYuukouKigen.exec(mosnaiCheckParam);

        exNumericEquals(hubiMsg.size(), 1, "不備メッセージ件数");
        exStringEquals(hubiMsg.get(0).getHubimsg(), "５年ごと利差配当付指定通貨建終身保険（一時払い）　１０年　最低保証なし（米ドル）の予定利率が取得できません。申込日　20160701", "不備メッセージ");
        exStringEquals(hubiMsg.get(0).getMessageId(), "EHC1055", "メッセージＩＤ");
        exStringEquals(hubiMsg.get(0).getMosno(), "791112428", "申込番号");
        exNumericEquals(hubiMsg.get(0).getRenno(), 1, "連番");
        exClassificationEquals(hubiMsg.get(0).getHubisyubetukbn(), C_HubisyubetuKbn.KETHORYU_HUBI, "不備種別区分");
        exClassificationEquals(hubiMsg.get(0).getHubisyubetusyousaikbn(), C_HubisyubetusyousaiKbn.NONE, "不備種別詳細区分");

        exDateEquals((BizDate)MockObjectManager.getArgument(SetKisoKoumokuMockForSinkeiyaku.class, "setkykymdHantei", 0, 2), null, "領収日");
        exDateEquals((BizDate)MockObjectManager.getArgument(SetKisoKoumokuMockForSinkeiyaku.class, "setkykymdHantei", 0, 3), BizDate.valueOf(20160701), "申込日");
        exDateEquals((BizDate)MockObjectManager.getArgument(SetKisoKoumokuMockForSinkeiyaku.class, "setkykymdHantei", 0, 4), BizDate.valueOf(20160701), "責任開始日");
        exDateEquals((BizDate)MockObjectManager.getArgument(SetKisoKoumokuMockForSinkeiyaku.class, "setkykymdHantei", 0, 5), BizDate.valueOf(20160701), "処理日");
        exClassificationEquals((C_SysKbn)MockObjectManager.getArgument(SetKisoKoumokuMockForSinkeiyaku.class, "setkykymdHantei", 0, 6), C_SysKbn.SKEI, "システム区分");
        exClassificationEquals((C_YoteikykymdKbn)MockObjectManager.getArgument(SetKisoKoumokuMockForSinkeiyaku.class, "setkykymdHantei", 0, 7), C_YoteikykymdKbn.AUTO, "予定契約日区分");

        exDateEquals((BizDate)MockObjectManager.getArgument(SetNenreiMockForSinkeiyaku.class, "exec", 0, 0), BizDate.valueOf(20180203), "基準日");
        exDateEquals((BizDate)MockObjectManager.getArgument(SetNenreiMockForSinkeiyaku.class, "exec", 0, 1), BizDate.valueOf(20010505), "生年月日");

        exClassificationEquals((C_KetsrhkosKbn)MockObjectManager.getArgument(SetHubiMsgMockForSinkeiyaku.class, "exec", 0, 0), C_KetsrhkosKbn.KETHORYU_HUBI, "決定・成立保留更新区分");
        exClassificationEquals((C_SpKeisanKahiKbn)MockObjectManager.getArgument(SetHubiMsgMockForSinkeiyaku.class, "exec", 0, 1), C_SpKeisanKahiKbn.SPKEISANKA, "決定保留時ＳＰ計算可否区分");
        exClassificationEquals((C_HubisyubetusyousaiKbn)MockObjectManager.getArgument(SetHubiMsgMockForSinkeiyaku.class, "exec", 0, 2), C_HubisyubetusyousaiKbn.NONE, "不備種別詳細区分");
        exStringEquals((String)MockObjectManager.getArgument(SetHubiMsgMockForSinkeiyaku.class, "exec", 0, 3), "EHC1055 ５年ごと利差配当付指定通貨建終身保険（一時払い）　１０年　最低保証なし（米ドル）の予定利率が取得できません。申込日　20160701", "メッセージ文言");
        exClassificationEquals((C_TknKbn)MockObjectManager.getArgument(SetHubiMsgMockForSinkeiyaku.class, "exec", 0, 5), C_TknKbn.NONE, "特認区分");
        exClassificationEquals((C_MsgKbn)MockObjectManager.getArgument(SetHubiMsgMockForSinkeiyaku.class, "exec", 0, 6), C_MsgKbn.ERROR, "メッセージ区分");
    }

    @Test
    @Transactional
    @TestOrder(240)
    public void testExec_A24() {

        MockObjectManager.initialize();
        HanteiMoschkMockForSinkeiyaku.SYORIPTN = HanteiMoschkMockForSinkeiyaku.TESTPATTERN6;
        SetKisoKoumokuMockForSinkeiyaku.SYORIPTN = SetKisoKoumokuMockForSinkeiyaku.TESTPATTERN1;
        SetNenreiMockForSinkeiyaku.SYORIPTN = SetNenreiMockForSinkeiyaku.TESTPATTERN1;
        SetHubiMsgMockForSinkeiyaku.SYORIPTN = SetHubiMsgMockForSinkeiyaku.TESTPATTERN6;

        CheckHokenRyouYuukouKigen checkHokenRyouYuukouKigen = SWAKInjector.getInstance(CheckHokenRyouYuukouKigen.class);
        MosnaiCheckParam mosnaiCheckParam = SWAKInjector.getInstance(MosnaiCheckParam.class);

        sinkeiyakuDomManager.flush();
        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("791112733");
        List<HT_HubiMsg> hubiMsg = syoriCTL.getHubiMsgs();
        BM_SyouhnZokusei syouhnZokusei = bizDomManager.getSyouhnZokusei("ﾕｶ", 7);
        mosnaiCheckParam.setSyuSyouhnZokusei(syouhnZokusei);
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setSysDate(BizDate.valueOf("20160907"));
        mosnaiCheckParam.setListHubiMsg(hubiMsg);
        checkHokenRyouYuukouKigen.exec(mosnaiCheckParam);

        exNumericEquals(hubiMsg.size(), 1, "不備メッセージ件数");
        exStringEquals(hubiMsg.get(0).getHubimsg(), "予定利率が申込時点から上昇しています。申込日　10.00％　契約日　20.00％", "不備メッセージ");
        exStringEquals(hubiMsg.get(0).getMessageId(), "EHC1056", "メッセージＩＤ");
        exStringEquals(hubiMsg.get(0).getMosno(), "791112733", "申込番号");
        exNumericEquals(hubiMsg.get(0).getRenno(), 1, "連番");
        exClassificationEquals(hubiMsg.get(0).getHubisyubetukbn(), C_HubisyubetuKbn.KETHORYU_HUBI, "不備種別区分");
        exClassificationEquals(hubiMsg.get(0).getHubisyubetusyousaikbn(), C_HubisyubetusyousaiKbn.NONE, "不備種別詳細区分");

        exDateEquals((BizDate)MockObjectManager.getArgument(SetKisoKoumokuMockForSinkeiyaku.class, "setkykymdHantei", 0, 2), null, "領収日");
        exDateEquals((BizDate)MockObjectManager.getArgument(SetKisoKoumokuMockForSinkeiyaku.class, "setkykymdHantei", 0, 3), BizDate.valueOf(20160701), "申込日");
        exDateEquals((BizDate)MockObjectManager.getArgument(SetKisoKoumokuMockForSinkeiyaku.class, "setkykymdHantei", 0, 4), BizDate.valueOf(20160701), "責任開始日");
        exDateEquals((BizDate)MockObjectManager.getArgument(SetKisoKoumokuMockForSinkeiyaku.class, "setkykymdHantei", 0, 5), BizDate.valueOf(20160701), "処理日");
        exClassificationEquals((C_SysKbn)MockObjectManager.getArgument(SetKisoKoumokuMockForSinkeiyaku.class, "setkykymdHantei", 0, 6), C_SysKbn.SKEI, "システム区分");
        exClassificationEquals((C_YoteikykymdKbn)MockObjectManager.getArgument(SetKisoKoumokuMockForSinkeiyaku.class, "setkykymdHantei", 0, 7), C_YoteikykymdKbn.AUTO, "予定契約日区分");

        exDateEquals((BizDate)MockObjectManager.getArgument(SetNenreiMockForSinkeiyaku.class, "exec", 0, 0), BizDate.valueOf(20180203), "基準日");
        exDateEquals((BizDate)MockObjectManager.getArgument(SetNenreiMockForSinkeiyaku.class, "exec", 0, 1), BizDate.valueOf(20010505), "生年月日");

        exClassificationEquals((C_KetsrhkosKbn)MockObjectManager.getArgument(SetHubiMsgMockForSinkeiyaku.class, "exec", 0, 0), C_KetsrhkosKbn.KETHORYU_HUBI, "決定・成立保留更新区分");
        exClassificationEquals((C_SpKeisanKahiKbn)MockObjectManager.getArgument(SetHubiMsgMockForSinkeiyaku.class, "exec", 0, 1), C_SpKeisanKahiKbn.SPKEISANKA, "決定保留時ＳＰ計算可否区分");
        exClassificationEquals((C_HubisyubetusyousaiKbn)MockObjectManager.getArgument(SetHubiMsgMockForSinkeiyaku.class, "exec", 0, 2), C_HubisyubetusyousaiKbn.NONE, "不備種別詳細区分");
        exStringEquals((String)MockObjectManager.getArgument(SetHubiMsgMockForSinkeiyaku.class, "exec", 0, 3), "EHC1056 予定利率が申込時点から上昇しています。申込日　10.00％　契約日　20.00％", "メッセージ文言");
        exClassificationEquals((C_TknKbn)MockObjectManager.getArgument(SetHubiMsgMockForSinkeiyaku.class, "exec", 0, 5), C_TknKbn.KANOU, "特認区分");
        exClassificationEquals((C_MsgKbn)MockObjectManager.getArgument(SetHubiMsgMockForSinkeiyaku.class, "exec", 0, 6), C_MsgKbn.ERROR, "メッセージ区分");
    }

    @Test
    @Transactional
    @TestOrder(250)
    public void testExec_A25() {

        MockObjectManager.initialize();
        HanteiMoschkMockForSinkeiyaku.SYORIPTN = HanteiMoschkMockForSinkeiyaku.TESTPATTERN6;
        SetKisoKoumokuMockForSinkeiyaku.SYORIPTN = SetKisoKoumokuMockForSinkeiyaku.TESTPATTERN1;
        SetNenreiMockForSinkeiyaku.SYORIPTN = SetNenreiMockForSinkeiyaku.TESTPATTERN1;
        SetHubiMsgMockForSinkeiyaku.SYORIPTN = SetHubiMsgMockForSinkeiyaku.TESTPATTERN7;

        CheckHokenRyouYuukouKigen checkHokenRyouYuukouKigen = SWAKInjector.getInstance(CheckHokenRyouYuukouKigen.class);
        MosnaiCheckParam mosnaiCheckParam = SWAKInjector.getInstance(MosnaiCheckParam.class);

        sinkeiyakuDomManager.flush();
        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("791112436");
        List<HT_HubiMsg> hubiMsg = syoriCTL.getHubiMsgs();
        BM_SyouhnZokusei syouhnZokusei = bizDomManager.getSyouhnZokusei("ﾕｶ", 3);
        mosnaiCheckParam.setSyuSyouhnZokusei(syouhnZokusei);
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setSysDate(BizDate.valueOf("20160907"));
        mosnaiCheckParam.setListHubiMsg(hubiMsg);
        checkHokenRyouYuukouKigen.exec(mosnaiCheckParam);

        exNumericEquals(hubiMsg.size(), 1, "不備メッセージ件数");
        exStringEquals(hubiMsg.get(0).getHubimsg(), "予定利率が申込時点から低下しています。申込日　10.00％　契約日　20.00％", "不備メッセージ");
        exStringEquals(hubiMsg.get(0).getMessageId(), "EHC1057", "メッセージＩＤ");
        exStringEquals(hubiMsg.get(0).getMosno(), "791112436", "申込番号");
        exNumericEquals(hubiMsg.get(0).getRenno(), 1, "連番");
        exClassificationEquals(hubiMsg.get(0).getHubisyubetukbn(), C_HubisyubetuKbn.KETHORYU_HUBI, "不備種別区分");
        exClassificationEquals(hubiMsg.get(0).getHubisyubetusyousaikbn(), C_HubisyubetusyousaiKbn.NONE, "不備種別詳細区分");

        exDateEquals((BizDate)MockObjectManager.getArgument(SetKisoKoumokuMockForSinkeiyaku.class, "setkykymdHantei", 0, 2), null, "領収日");
        exDateEquals((BizDate)MockObjectManager.getArgument(SetKisoKoumokuMockForSinkeiyaku.class, "setkykymdHantei", 0, 3), BizDate.valueOf(20160701), "申込日");
        exDateEquals((BizDate)MockObjectManager.getArgument(SetKisoKoumokuMockForSinkeiyaku.class, "setkykymdHantei", 0, 4), BizDate.valueOf(20160701), "責任開始日");
        exDateEquals((BizDate)MockObjectManager.getArgument(SetKisoKoumokuMockForSinkeiyaku.class, "setkykymdHantei", 0, 5), BizDate.valueOf(20160701), "処理日");
        exClassificationEquals((C_SysKbn)MockObjectManager.getArgument(SetKisoKoumokuMockForSinkeiyaku.class, "setkykymdHantei", 0, 6), C_SysKbn.SKEI, "システム区分");
        exClassificationEquals((C_YoteikykymdKbn)MockObjectManager.getArgument(SetKisoKoumokuMockForSinkeiyaku.class, "setkykymdHantei", 0, 7), C_YoteikykymdKbn.AUTO, "予定契約日区分");

        exDateEquals((BizDate)MockObjectManager.getArgument(SetNenreiMockForSinkeiyaku.class, "exec", 0, 0), BizDate.valueOf(20180203), "基準日");
        exDateEquals((BizDate)MockObjectManager.getArgument(SetNenreiMockForSinkeiyaku.class, "exec", 0, 1), BizDate.valueOf(20010505), "生年月日");

        exClassificationEquals((C_KetsrhkosKbn)MockObjectManager.getArgument(SetHubiMsgMockForSinkeiyaku.class, "exec", 0, 0), C_KetsrhkosKbn.KETHORYU_HUBI, "決定・成立保留更新区分");
        exClassificationEquals((C_SpKeisanKahiKbn)MockObjectManager.getArgument(SetHubiMsgMockForSinkeiyaku.class, "exec", 0, 1), C_SpKeisanKahiKbn.SPKEISANKA, "決定保留時ＳＰ計算可否区分");
        exClassificationEquals((C_HubisyubetusyousaiKbn)MockObjectManager.getArgument(SetHubiMsgMockForSinkeiyaku.class, "exec", 0, 2), C_HubisyubetusyousaiKbn.NONE, "不備種別詳細区分");
        exStringEquals((String)MockObjectManager.getArgument(SetHubiMsgMockForSinkeiyaku.class, "exec", 0, 3), "EHC1056 予定利率が申込時点から上昇しています。申込日　10.00％　契約日　20.00％", "メッセージ文言");
        exClassificationEquals((C_TknKbn)MockObjectManager.getArgument(SetHubiMsgMockForSinkeiyaku.class, "exec", 0, 5), C_TknKbn.KANOU, "特認区分");
        exClassificationEquals((C_MsgKbn)MockObjectManager.getArgument(SetHubiMsgMockForSinkeiyaku.class, "exec", 0, 6), C_MsgKbn.ERROR, "メッセージ区分");
    }

    @Test
    @Transactional
    @TestOrder(260)
    public void testExec_A26() {

        MockObjectManager.initialize();
        HanteiMoschkMockForSinkeiyaku.SYORIPTN = HanteiMoschkMockForSinkeiyaku.TESTPATTERN6;
        SetKisoKoumokuMockForSinkeiyaku.SYORIPTN = SetKisoKoumokuMockForSinkeiyaku.TESTPATTERN1;
        SetNenreiMockForSinkeiyaku.SYORIPTN = SetNenreiMockForSinkeiyaku.TESTPATTERN1;
        EditPdfYoteirirtuMockForSinkeiyaku.SYORIPTN = EditPdfYoteirirtuMockForSinkeiyaku.TESTPATTERN1;
        SetHubiMsgMockForSinkeiyaku.SYORIPTN = SetHubiMsgMockForSinkeiyaku.TESTPATTERN8;

        CheckHokenRyouYuukouKigen checkHokenRyouYuukouKigen = SWAKInjector.getInstance(CheckHokenRyouYuukouKigen.class);
        MosnaiCheckParam mosnaiCheckParam = SWAKInjector.getInstance(MosnaiCheckParam.class);

        sinkeiyakuDomManager.flush();
        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("791112444");
        List<HT_HubiMsg> hubiMsg = syoriCTL.getHubiMsgs();
        BM_SyouhnZokusei syouhnZokusei = bizDomManager.getSyouhnZokusei("ﾕｷ", 3);
        mosnaiCheckParam.setSyuSyouhnZokusei(syouhnZokusei);
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setSysDate(BizDate.valueOf("20160907"));
        mosnaiCheckParam.setListHubiMsg(hubiMsg);
        checkHokenRyouYuukouKigen.exec(mosnaiCheckParam);

        exNumericEquals(hubiMsg.size(), 1, "不備メッセージ件数");
        exStringEquals(hubiMsg.get(0).getHubimsg(), "予定利率が申込時点から低下しています。申込日　20.00％　契約日　10.00％", "不備メッセージ");
        exStringEquals(hubiMsg.get(0).getMessageId(), "EHC1057", "メッセージＩＤ");
        exStringEquals(hubiMsg.get(0).getMosno(), "791112444", "申込番号");
        exNumericEquals(hubiMsg.get(0).getRenno(), 1, "連番");
        exClassificationEquals(hubiMsg.get(0).getHubisyubetukbn(), C_HubisyubetuKbn.KETHORYU_HUBI, "不備種別区分");
        exClassificationEquals(hubiMsg.get(0).getHubisyubetusyousaikbn(), C_HubisyubetusyousaiKbn.NONE, "不備種別詳細区分");

        exDateEquals((BizDate)MockObjectManager.getArgument(SetKisoKoumokuMockForSinkeiyaku.class, "setkykymdHantei", 0, 2), null, "領収日");
        exDateEquals((BizDate)MockObjectManager.getArgument(SetKisoKoumokuMockForSinkeiyaku.class, "setkykymdHantei", 0, 3), BizDate.valueOf(20160701), "申込日");
        exDateEquals((BizDate)MockObjectManager.getArgument(SetKisoKoumokuMockForSinkeiyaku.class, "setkykymdHantei", 0, 4), BizDate.valueOf(20160701), "責任開始日");
        exDateEquals((BizDate)MockObjectManager.getArgument(SetKisoKoumokuMockForSinkeiyaku.class, "setkykymdHantei", 0, 5), BizDate.valueOf(20160701), "処理日");
        exClassificationEquals((C_SysKbn)MockObjectManager.getArgument(SetKisoKoumokuMockForSinkeiyaku.class, "setkykymdHantei", 0, 6), C_SysKbn.SKEI, "システム区分");
        exClassificationEquals((C_YoteikykymdKbn)MockObjectManager.getArgument(SetKisoKoumokuMockForSinkeiyaku.class, "setkykymdHantei", 0, 7), C_YoteikykymdKbn.AUTO, "予定契約日区分");

        exDateEquals((BizDate)MockObjectManager.getArgument(SetNenreiMockForSinkeiyaku.class, "exec", 0, 0), BizDate.valueOf(20180203), "基準日");
        exDateEquals((BizDate)MockObjectManager.getArgument(SetNenreiMockForSinkeiyaku.class, "exec", 0, 1), BizDate.valueOf(20010505), "生年月日");

        exBizCalcbleEquals((BizNumber)MockObjectManager.getArgument(EditPdfYoteirirtuMockForSinkeiyaku.class, "exec", 0, 1), BizNumber.valueOf(20), "申込日予定利率");
        exBizCalcbleEquals((BizNumber)MockObjectManager.getArgument(EditPdfYoteirirtuMockForSinkeiyaku.class, "exec", 0, 2), BizNumber.valueOf(10), "契約日予定利率");
        exClassificationEquals((C_UmuKbn)MockObjectManager.getArgument(EditPdfYoteirirtuMockForSinkeiyaku.class, "exec", 0, 3), C_UmuKbn.ARI, "予定利率変動有無");
        exBizCalcbleEquals((BizNumber)MockObjectManager.getArgument(EditPdfYoteirirtuMockForSinkeiyaku.class, "exec", 0, 4), BizNumber.valueOf(0), "申込日積立利率");
        exBizCalcbleEquals((BizNumber)MockObjectManager.getArgument(EditPdfYoteirirtuMockForSinkeiyaku.class, "exec", 0, 5), BizNumber.valueOf(0), "契約日積立利率");
        exBizCalcbleEquals((BizNumber)MockObjectManager.getArgument(EditPdfYoteirirtuMockForSinkeiyaku.class, "exec", 0, 6), BizNumber.valueOf(0), "申込日ローディング変更後積立利率");
        exBizCalcbleEquals((BizNumber)MockObjectManager.getArgument(EditPdfYoteirirtuMockForSinkeiyaku.class, "exec", 0, 7), BizNumber.valueOf(0), "契約日ローディング変更後積立利率");
        exClassificationEquals((C_UmuKbn)MockObjectManager.getArgument(EditPdfYoteirirtuMockForSinkeiyaku.class, "exec", 0, 8), C_UmuKbn.NONE, "積立利率変動有無");
        exBizCalcbleEquals((BizNumber)MockObjectManager.getArgument(EditPdfYoteirirtuMockForSinkeiyaku.class, "exec", 0, 9), BizNumber.valueOf(0), "申込日積立金増加率上限");
        exBizCalcbleEquals((BizNumber)MockObjectManager.getArgument(EditPdfYoteirirtuMockForSinkeiyaku.class, "exec", 0, 10), BizNumber.valueOf(0), "契約日積立金増加率上限");
        exClassificationEquals((C_UmuKbn)MockObjectManager.getArgument(EditPdfYoteirirtuMockForSinkeiyaku.class, "exec", 0, 11), C_UmuKbn.NONE, "積立金増加率上限変動有無");
        exBizCalcbleEquals((BizNumber)MockObjectManager.getArgument(EditPdfYoteirirtuMockForSinkeiyaku.class, "exec", 0, 12), BizNumber.valueOf(0), "申込日設定倍率");
        exBizCalcbleEquals((BizNumber)MockObjectManager.getArgument(EditPdfYoteirirtuMockForSinkeiyaku.class, "exec", 0,13), BizNumber.valueOf(0), "契約日設定倍率");
        exClassificationEquals((C_UmuKbn)MockObjectManager.getArgument(EditPdfYoteirirtuMockForSinkeiyaku.class, "exec", 0, 14), C_UmuKbn.NONE, "設定倍率変動有無");
        exBizCalcbleEquals((BizNumber)MockObjectManager.getArgument(EditPdfYoteirirtuMockForSinkeiyaku.class, "exec", 0, 15), BizNumber.valueOf(0), "申込日連動率");
        exBizCalcbleEquals((BizNumber)MockObjectManager.getArgument(EditPdfYoteirirtuMockForSinkeiyaku.class, "exec", 0,16), BizNumber.valueOf(0), "契約日連動率");
        exClassificationEquals((C_UmuKbn)MockObjectManager.getArgument(EditPdfYoteirirtuMockForSinkeiyaku.class, "exec", 0, 17), C_UmuKbn.NONE, "連動率変動有無");

        exClassificationEquals((C_KetsrhkosKbn)MockObjectManager.getArgument(SetHubiMsgMockForSinkeiyaku.class, "exec", 0, 0), C_KetsrhkosKbn.KETHORYU_HUBI, "決定・成立保留更新区分");
        exClassificationEquals((C_SpKeisanKahiKbn)MockObjectManager.getArgument(SetHubiMsgMockForSinkeiyaku.class, "exec", 0, 1), C_SpKeisanKahiKbn.SPKEISANKA, "決定保留時ＳＰ計算可否区分");
        exClassificationEquals((C_HubisyubetusyousaiKbn)MockObjectManager.getArgument(SetHubiMsgMockForSinkeiyaku.class, "exec", 0, 2), C_HubisyubetusyousaiKbn.NONE, "不備種別詳細区分");
        exStringEquals((String)MockObjectManager.getArgument(SetHubiMsgMockForSinkeiyaku.class, "exec", 0, 3), "EHC1057 予定利率が申込時点から低下しています。申込日　20.00％　契約日　10.00％", "メッセージ文言");
        exClassificationEquals((C_TknKbn)MockObjectManager.getArgument(SetHubiMsgMockForSinkeiyaku.class, "exec", 0, 5), C_TknKbn.SUMI, "特認区分");
        exClassificationEquals((C_MsgKbn)MockObjectManager.getArgument(SetHubiMsgMockForSinkeiyaku.class, "exec", 0, 6), C_MsgKbn.ERROR, "メッセージ区分");

    }

    @Test
    @Transactional
    @TestOrder(270)
    public void testExec_A27() {

        MockObjectManager.initialize();
        HanteiMoschkMockForSinkeiyaku.SYORIPTN = HanteiMoschkMockForSinkeiyaku.TESTPATTERN6;
        SetKisoKoumokuMockForSinkeiyaku.SYORIPTN = SetKisoKoumokuMockForSinkeiyaku.TESTPATTERN1;
        SetNenreiMockForSinkeiyaku.SYORIPTN = SetNenreiMockForSinkeiyaku.TESTPATTERN1;

        CheckHokenRyouYuukouKigen checkHokenRyouYuukouKigen = SWAKInjector.getInstance(CheckHokenRyouYuukouKigen.class);
        MosnaiCheckParam mosnaiCheckParam = SWAKInjector.getInstance(MosnaiCheckParam.class);

        sinkeiyakuDomManager.flush();
        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("791112741");
        List<HT_HubiMsg> hubiMsg = syoriCTL.getHubiMsgs();
        BM_SyouhnZokusei syouhnZokusei = bizDomManager.getSyouhnZokusei("ﾕｸ", 7);
        mosnaiCheckParam.setSyuSyouhnZokusei(syouhnZokusei);
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setSysDate(BizDate.valueOf("20160907"));
        mosnaiCheckParam.setListHubiMsg(hubiMsg);
        checkHokenRyouYuukouKigen.exec(mosnaiCheckParam);

        exNumericEquals(hubiMsg.size(), 0, "不備メッセージ件数");

        exDateEquals((BizDate)MockObjectManager.getArgument(SetKisoKoumokuMockForSinkeiyaku.class, "setkykymdHantei", 0, 2), null, "領収日");
        exDateEquals((BizDate)MockObjectManager.getArgument(SetKisoKoumokuMockForSinkeiyaku.class, "setkykymdHantei", 0, 3), BizDate.valueOf(20160701), "申込日");
        exDateEquals((BizDate)MockObjectManager.getArgument(SetKisoKoumokuMockForSinkeiyaku.class, "setkykymdHantei", 0, 4), BizDate.valueOf(20160701), "責任開始日");
        exDateEquals((BizDate)MockObjectManager.getArgument(SetKisoKoumokuMockForSinkeiyaku.class, "setkykymdHantei", 0, 5), BizDate.valueOf(20160701), "処理日");
        exClassificationEquals((C_SysKbn)MockObjectManager.getArgument(SetKisoKoumokuMockForSinkeiyaku.class, "setkykymdHantei", 0, 6), C_SysKbn.SKEI, "システム区分");
        exClassificationEquals((C_YoteikykymdKbn)MockObjectManager.getArgument(SetKisoKoumokuMockForSinkeiyaku.class, "setkykymdHantei", 0, 7), C_YoteikykymdKbn.AUTO, "予定契約日区分");

        exDateEquals((BizDate)MockObjectManager.getArgument(SetNenreiMockForSinkeiyaku.class, "exec", 0, 0), BizDate.valueOf(20180203), "基準日");
        exDateEquals((BizDate)MockObjectManager.getArgument(SetNenreiMockForSinkeiyaku.class, "exec", 0, 1), BizDate.valueOf(20010505), "生年月日");

    }

    @Test
    @Transactional
    @TestOrder(280)
    public void testExec_A28() {

        MockObjectManager.initialize();
        HanteiMoschkMockForSinkeiyaku.SYORIPTN = HanteiMoschkMockForSinkeiyaku.TESTPATTERN6;
        SetKisoKoumokuMockForSinkeiyaku.SYORIPTN = SetKisoKoumokuMockForSinkeiyaku.TESTPATTERN4;
        SetNenreiMockForSinkeiyaku.SYORIPTN = SetNenreiMockForSinkeiyaku.TESTPATTERN1;

        CheckHokenRyouYuukouKigen checkHokenRyouYuukouKigen = SWAKInjector.getInstance(CheckHokenRyouYuukouKigen.class);
        MosnaiCheckParam mosnaiCheckParam = SWAKInjector.getInstance(MosnaiCheckParam.class);

        sinkeiyakuDomManager.flush();
        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("791112451");
        List<HT_HubiMsg> hubiMsg = syoriCTL.getHubiMsgs();
        BM_SyouhnZokusei syouhnZokusei = bizDomManager.getSyouhnZokusei("ﾕｸ", 3);
        mosnaiCheckParam.setSyuSyouhnZokusei(syouhnZokusei);
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setSysDate(BizDate.valueOf("20160907"));
        mosnaiCheckParam.setListHubiMsg(hubiMsg);
        checkHokenRyouYuukouKigen.exec(mosnaiCheckParam);

        exNumericEquals(hubiMsg.size(), 0, "不備メッセージ件数");

        exDateEquals((BizDate)MockObjectManager.getArgument(SetKisoKoumokuMockForSinkeiyaku.class, "setkykymdHantei", 0, 2), null, "領収日");
        exDateEquals((BizDate)MockObjectManager.getArgument(SetKisoKoumokuMockForSinkeiyaku.class, "setkykymdHantei", 0, 3), BizDate.valueOf(20160701), "申込日");
        exDateEquals((BizDate)MockObjectManager.getArgument(SetKisoKoumokuMockForSinkeiyaku.class, "setkykymdHantei", 0, 4), BizDate.valueOf(20160701), "責任開始日");
        exDateEquals((BizDate)MockObjectManager.getArgument(SetKisoKoumokuMockForSinkeiyaku.class, "setkykymdHantei", 0, 5), BizDate.valueOf(20160701), "処理日");
        exClassificationEquals((C_SysKbn)MockObjectManager.getArgument(SetKisoKoumokuMockForSinkeiyaku.class, "setkykymdHantei", 0, 6), C_SysKbn.SKEI, "システム区分");
        exClassificationEquals((C_YoteikykymdKbn)MockObjectManager.getArgument(SetKisoKoumokuMockForSinkeiyaku.class, "setkykymdHantei", 0, 7), C_YoteikykymdKbn.AUTO, "予定契約日区分");

        exDateEquals((BizDate)MockObjectManager.getArgument(SetNenreiMockForSinkeiyaku.class, "exec", 0, 0), BizDate.valueOf(20180503), "基準日");
        exDateEquals((BizDate)MockObjectManager.getArgument(SetNenreiMockForSinkeiyaku.class, "exec", 0, 1), BizDate.valueOf(20010505), "生年月日");

    }

    @Test
    @Transactional
    @TestOrder(290)
    public void testExec_A29() {

        MockObjectManager.initialize();
        HanteiMoschkMockForSinkeiyaku.SYORIPTN = HanteiMoschkMockForSinkeiyaku.TESTPATTERN7;
        SetKisoKoumokuMockForSinkeiyaku.SYORIPTN = SetKisoKoumokuMockForSinkeiyaku.TESTPATTERN1;
        SetNenreiMockForSinkeiyaku.SYORIPTN = SetNenreiMockForSinkeiyaku.TESTPATTERN1;

        CheckHokenRyouYuukouKigen checkHokenRyouYuukouKigen = SWAKInjector.getInstance(CheckHokenRyouYuukouKigen.class);
        MosnaiCheckParam mosnaiCheckParam = SWAKInjector.getInstance(MosnaiCheckParam.class);

        sinkeiyakuDomManager.flush();
        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("791112485");
        List<HT_HubiMsg> hubiMsg = syoriCTL.getHubiMsgs();
        BM_SyouhnZokusei syouhnZokusei = bizDomManager.getSyouhnZokusei("ﾕｹ", 4);
        mosnaiCheckParam.setSyuSyouhnZokusei(syouhnZokusei);
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setSysDate(BizDate.valueOf("20160907"));
        mosnaiCheckParam.setListHubiMsg(hubiMsg);
        checkHokenRyouYuukouKigen.exec(mosnaiCheckParam);

        exNumericEquals(hubiMsg.size(), 0, "不備メッセージ件数");

        exDateEquals((BizDate)MockObjectManager.getArgument(SetKisoKoumokuMockForSinkeiyaku.class, "setkykymdHantei", 0, 2), null, "領収日");
        exDateEquals((BizDate)MockObjectManager.getArgument(SetKisoKoumokuMockForSinkeiyaku.class, "setkykymdHantei", 0, 3), BizDate.valueOf(20160701), "申込日");
        exDateEquals((BizDate)MockObjectManager.getArgument(SetKisoKoumokuMockForSinkeiyaku.class, "setkykymdHantei", 0, 4), BizDate.valueOf(20160701), "責任開始日");
        exDateEquals((BizDate)MockObjectManager.getArgument(SetKisoKoumokuMockForSinkeiyaku.class, "setkykymdHantei", 0, 5), BizDate.valueOf(20160701), "処理日");
        exClassificationEquals((C_SysKbn)MockObjectManager.getArgument(SetKisoKoumokuMockForSinkeiyaku.class, "setkykymdHantei", 0, 6), C_SysKbn.SKEI, "システム区分");
        exClassificationEquals((C_YoteikykymdKbn)MockObjectManager.getArgument(SetKisoKoumokuMockForSinkeiyaku.class, "setkykymdHantei", 0, 7), C_YoteikykymdKbn.AUTO, "予定契約日区分");

        exDateEquals((BizDate)MockObjectManager.getArgument(SetNenreiMockForSinkeiyaku.class, "exec", 0, 0), BizDate.valueOf(20180203), "基準日");
        exDateEquals((BizDate)MockObjectManager.getArgument(SetNenreiMockForSinkeiyaku.class, "exec", 0, 1), BizDate.valueOf(20010505), "生年月日");

    }

    @Test
    @Transactional
    @TestOrder(300)
    public void testExec_A30() {

        MockObjectManager.initialize();
        HanteiMoschkMockForSinkeiyaku.SYORIPTN = HanteiMoschkMockForSinkeiyaku.TESTPATTERN7;
        SetKisoKoumokuMockForSinkeiyaku.SYORIPTN = SetKisoKoumokuMockForSinkeiyaku.TESTPATTERN1;
        SetNenreiMockForSinkeiyaku.SYORIPTN = SetNenreiMockForSinkeiyaku.TESTPATTERN1;

        CheckHokenRyouYuukouKigen checkHokenRyouYuukouKigen = SWAKInjector.getInstance(CheckHokenRyouYuukouKigen.class);
        MosnaiCheckParam mosnaiCheckParam = SWAKInjector.getInstance(MosnaiCheckParam.class);

        sinkeiyakuDomManager.flush();
        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("791112493");
        List<HT_HubiMsg> hubiMsg = syoriCTL.getHubiMsgs();
        BM_SyouhnZokusei syouhnZokusei = bizDomManager.getSyouhnZokusei("ﾕｺ", 4);
        mosnaiCheckParam.setSyuSyouhnZokusei(syouhnZokusei);
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setSysDate(BizDate.valueOf("20160907"));
        mosnaiCheckParam.setListHubiMsg(hubiMsg);
        checkHokenRyouYuukouKigen.exec(mosnaiCheckParam);

        exNumericEquals(hubiMsg.size(), 0, "不備メッセージ件数");

        exDateEquals((BizDate)MockObjectManager.getArgument(SetKisoKoumokuMockForSinkeiyaku.class, "setkykymdHantei", 0, 2), null, "領収日");
        exDateEquals((BizDate)MockObjectManager.getArgument(SetKisoKoumokuMockForSinkeiyaku.class, "setkykymdHantei", 0, 3), BizDate.valueOf(20160701), "申込日");
        exDateEquals((BizDate)MockObjectManager.getArgument(SetKisoKoumokuMockForSinkeiyaku.class, "setkykymdHantei", 0, 4), BizDate.valueOf(20160701), "責任開始日");
        exDateEquals((BizDate)MockObjectManager.getArgument(SetKisoKoumokuMockForSinkeiyaku.class, "setkykymdHantei", 0, 5), BizDate.valueOf(20160701), "処理日");
        exClassificationEquals((C_SysKbn)MockObjectManager.getArgument(SetKisoKoumokuMockForSinkeiyaku.class, "setkykymdHantei", 0, 6), C_SysKbn.SKEI, "システム区分");
        exClassificationEquals((C_YoteikykymdKbn)MockObjectManager.getArgument(SetKisoKoumokuMockForSinkeiyaku.class, "setkykymdHantei", 0, 7), C_YoteikykymdKbn.AUTO, "予定契約日区分");

        exDateEquals((BizDate)MockObjectManager.getArgument(SetNenreiMockForSinkeiyaku.class, "exec", 0, 0), BizDate.valueOf(20180203), "基準日");
        exDateEquals((BizDate)MockObjectManager.getArgument(SetNenreiMockForSinkeiyaku.class, "exec", 0, 1), BizDate.valueOf(20010505), "生年月日");

    }

    @Test
    @Transactional
    @TestOrder(310)
    public void testExec_A31() {

        MockObjectManager.initialize();
        HanteiMoschkMockForSinkeiyaku.SYORIPTN = HanteiMoschkMockForSinkeiyaku.TESTPATTERN7;
        SetKisoKoumokuMockForSinkeiyaku.SYORIPTN = SetKisoKoumokuMockForSinkeiyaku.TESTPATTERN1;
        SetNenreiMockForSinkeiyaku.SYORIPTN = SetNenreiMockForSinkeiyaku.TESTPATTERN1;
        SetHubiMsgMockForSinkeiyaku.SYORIPTN = SetHubiMsgMockForSinkeiyaku.TESTPATTERN9;

        CheckHokenRyouYuukouKigen checkHokenRyouYuukouKigen = SWAKInjector.getInstance(CheckHokenRyouYuukouKigen.class);
        MosnaiCheckParam mosnaiCheckParam = SWAKInjector.getInstance(MosnaiCheckParam.class);

        sinkeiyakuDomManager.flush();
        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("791112501");
        List<HT_HubiMsg> hubiMsg = syoriCTL.getHubiMsgs();
        BM_SyouhnZokusei syouhnZokusei = bizDomManager.getSyouhnZokusei("ﾕｻ", 4);
        mosnaiCheckParam.setSyuSyouhnZokusei(syouhnZokusei);
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setSysDate(BizDate.valueOf("20160907"));
        mosnaiCheckParam.setListHubiMsg(hubiMsg);
        checkHokenRyouYuukouKigen.exec(mosnaiCheckParam);

        exNumericEquals(hubiMsg.size(), 1, "不備メッセージ件数");
        exStringEquals(hubiMsg.get(0).getHubimsg(), "５年ごと利差配当付指定通貨建終身保険（一時払い）　１０年　最低保証なし（米ドル）の積立利率が取得できません。申込日　20160701", "不備メッセージ");
        exStringEquals(hubiMsg.get(0).getMessageId(), "EHC1067", "メッセージＩＤ");
        exStringEquals(hubiMsg.get(0).getMosno(), "791112501", "申込番号");
        exNumericEquals(hubiMsg.get(0).getRenno(), 1, "連番");
        exClassificationEquals(hubiMsg.get(0).getHubisyubetukbn(), C_HubisyubetuKbn.KETHORYU_HUBI, "不備種別区分");
        exClassificationEquals(hubiMsg.get(0).getHubisyubetusyousaikbn(), C_HubisyubetusyousaiKbn.NONE, "不備種別詳細区分");

        exDateEquals((BizDate)MockObjectManager.getArgument(SetKisoKoumokuMockForSinkeiyaku.class, "setkykymdHantei", 0, 2), null, "領収日");
        exDateEquals((BizDate)MockObjectManager.getArgument(SetKisoKoumokuMockForSinkeiyaku.class, "setkykymdHantei", 0, 3), BizDate.valueOf(20160701), "申込日");
        exDateEquals((BizDate)MockObjectManager.getArgument(SetKisoKoumokuMockForSinkeiyaku.class, "setkykymdHantei", 0, 4), BizDate.valueOf(20160701), "責任開始日");
        exDateEquals((BizDate)MockObjectManager.getArgument(SetKisoKoumokuMockForSinkeiyaku.class, "setkykymdHantei", 0, 5), BizDate.valueOf(20160701), "処理日");
        exClassificationEquals((C_SysKbn)MockObjectManager.getArgument(SetKisoKoumokuMockForSinkeiyaku.class, "setkykymdHantei", 0, 6), C_SysKbn.SKEI, "システム区分");
        exClassificationEquals((C_YoteikykymdKbn)MockObjectManager.getArgument(SetKisoKoumokuMockForSinkeiyaku.class, "setkykymdHantei", 0, 7), C_YoteikykymdKbn.AUTO, "予定契約日区分");

        exDateEquals((BizDate)MockObjectManager.getArgument(SetNenreiMockForSinkeiyaku.class, "exec", 0, 0), BizDate.valueOf(20180203), "基準日");
        exDateEquals((BizDate)MockObjectManager.getArgument(SetNenreiMockForSinkeiyaku.class, "exec", 0, 1), BizDate.valueOf(20010505), "生年月日");

        exClassificationEquals((C_KetsrhkosKbn)MockObjectManager.getArgument(SetHubiMsgMockForSinkeiyaku.class, "exec", 0, 0), C_KetsrhkosKbn.KETHORYU_HUBI, "決定・成立保留更新区分");
        exClassificationEquals((C_SpKeisanKahiKbn)MockObjectManager.getArgument(SetHubiMsgMockForSinkeiyaku.class, "exec", 0, 1), C_SpKeisanKahiKbn.SPKEISANKA, "決定保留時ＳＰ計算可否区分");
        exClassificationEquals((C_HubisyubetusyousaiKbn)MockObjectManager.getArgument(SetHubiMsgMockForSinkeiyaku.class, "exec", 0, 2), C_HubisyubetusyousaiKbn.NONE, "不備種別詳細区分");
        exStringEquals((String)MockObjectManager.getArgument(SetHubiMsgMockForSinkeiyaku.class, "exec", 0, 3), "EHC1067 ５年ごと利差配当付指定通貨建終身保険（一時払い）　１０年　最低保証なし（米ドル）の積立利率が取得できません。申込日　20160701", "メッセージ文言");
        exClassificationEquals((C_TknKbn)MockObjectManager.getArgument(SetHubiMsgMockForSinkeiyaku.class, "exec", 0, 5), C_TknKbn.NONE, "特認区分");
        exClassificationEquals((C_MsgKbn)MockObjectManager.getArgument(SetHubiMsgMockForSinkeiyaku.class, "exec", 0, 6), C_MsgKbn.ERROR, "メッセージ区分");

    }

    @Test
    @Transactional
    @TestOrder(320)
    public void testExec_A32() {

        MockObjectManager.initialize();
        HanteiMoschkMockForSinkeiyaku.SYORIPTN = HanteiMoschkMockForSinkeiyaku.TESTPATTERN7;
        SetKisoKoumokuMockForSinkeiyaku.SYORIPTN = SetKisoKoumokuMockForSinkeiyaku.TESTPATTERN1;
        SetNenreiMockForSinkeiyaku.SYORIPTN = SetNenreiMockForSinkeiyaku.TESTPATTERN1;
        SetHubiMsgMockForSinkeiyaku.SYORIPTN = SetHubiMsgMockForSinkeiyaku.TESTPATTERN10;

        CheckHokenRyouYuukouKigen checkHokenRyouYuukouKigen = SWAKInjector.getInstance(CheckHokenRyouYuukouKigen.class);
        MosnaiCheckParam mosnaiCheckParam = SWAKInjector.getInstance(MosnaiCheckParam.class);

        sinkeiyakuDomManager.flush();
        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("791112519");
        List<HT_HubiMsg> hubiMsg = syoriCTL.getHubiMsgs();
        BM_SyouhnZokusei syouhnZokusei = bizDomManager.getSyouhnZokusei("ﾕｼ", 4);
        mosnaiCheckParam.setSyuSyouhnZokusei(syouhnZokusei);
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setSysDate(BizDate.valueOf("20160907"));
        mosnaiCheckParam.setListHubiMsg(hubiMsg);
        checkHokenRyouYuukouKigen.exec(mosnaiCheckParam);

        exNumericEquals(hubiMsg.size(), 1, "不備メッセージ件数");
        exStringEquals(hubiMsg.get(0).getHubimsg(), "積立利率が申込時点から上昇しています。申込日　20.00％　契約日　30.00％", "不備メッセージ");
        exStringEquals(hubiMsg.get(0).getMessageId(), "EHC1068", "メッセージＩＤ");
        exStringEquals(hubiMsg.get(0).getMosno(), "791112519", "申込番号");
        exNumericEquals(hubiMsg.get(0).getRenno(), 1, "連番");
        exClassificationEquals(hubiMsg.get(0).getHubisyubetukbn(), C_HubisyubetuKbn.KETHORYU_HUBI, "不備種別区分");
        exClassificationEquals(hubiMsg.get(0).getHubisyubetusyousaikbn(), C_HubisyubetusyousaiKbn.NONE, "不備種別詳細区分");

        exDateEquals((BizDate)MockObjectManager.getArgument(SetKisoKoumokuMockForSinkeiyaku.class, "setkykymdHantei", 0, 2), null, "領収日");
        exDateEquals((BizDate)MockObjectManager.getArgument(SetKisoKoumokuMockForSinkeiyaku.class, "setkykymdHantei", 0, 3), BizDate.valueOf(20160701), "申込日");
        exDateEquals((BizDate)MockObjectManager.getArgument(SetKisoKoumokuMockForSinkeiyaku.class, "setkykymdHantei", 0, 4), BizDate.valueOf(20160701), "責任開始日");
        exDateEquals((BizDate)MockObjectManager.getArgument(SetKisoKoumokuMockForSinkeiyaku.class, "setkykymdHantei", 0, 5), BizDate.valueOf(20160701), "処理日");
        exClassificationEquals((C_SysKbn)MockObjectManager.getArgument(SetKisoKoumokuMockForSinkeiyaku.class, "setkykymdHantei", 0, 6), C_SysKbn.SKEI, "システム区分");
        exClassificationEquals((C_YoteikykymdKbn)MockObjectManager.getArgument(SetKisoKoumokuMockForSinkeiyaku.class, "setkykymdHantei", 0, 7), C_YoteikykymdKbn.AUTO, "予定契約日区分");

        exDateEquals((BizDate)MockObjectManager.getArgument(SetNenreiMockForSinkeiyaku.class, "exec", 0, 0), BizDate.valueOf(20180203), "基準日");
        exDateEquals((BizDate)MockObjectManager.getArgument(SetNenreiMockForSinkeiyaku.class, "exec", 0, 1), BizDate.valueOf(20010505), "生年月日");

        exClassificationEquals((C_KetsrhkosKbn)MockObjectManager.getArgument(SetHubiMsgMockForSinkeiyaku.class, "exec", 0, 0), C_KetsrhkosKbn.KETHORYU_HUBI, "決定・成立保留更新区分");
        exClassificationEquals((C_SpKeisanKahiKbn)MockObjectManager.getArgument(SetHubiMsgMockForSinkeiyaku.class, "exec", 0, 1), C_SpKeisanKahiKbn.SPKEISANKA, "決定保留時ＳＰ計算可否区分");
        exClassificationEquals((C_HubisyubetusyousaiKbn)MockObjectManager.getArgument(SetHubiMsgMockForSinkeiyaku.class, "exec", 0, 2), C_HubisyubetusyousaiKbn.NONE, "不備種別詳細区分");
        exStringEquals((String)MockObjectManager.getArgument(SetHubiMsgMockForSinkeiyaku.class, "exec", 0, 3), "EHC1068 積立利率が申込時点から上昇しています。申込日　20.00％　契約日　30.00％", "メッセージ文言");
        exClassificationEquals((C_TknKbn)MockObjectManager.getArgument(SetHubiMsgMockForSinkeiyaku.class, "exec", 0, 5), C_TknKbn.KANOU, "特認区分");
        exClassificationEquals((C_MsgKbn)MockObjectManager.getArgument(SetHubiMsgMockForSinkeiyaku.class, "exec", 0, 6), C_MsgKbn.ERROR, "メッセージ区分");
    }

    @Test
    @Transactional
    @TestOrder(330)
    public void testExec_A33() {

        MockObjectManager.initialize();
        HanteiMoschkMockForSinkeiyaku.SYORIPTN = HanteiMoschkMockForSinkeiyaku.TESTPATTERN7;
        SetKisoKoumokuMockForSinkeiyaku.SYORIPTN = SetKisoKoumokuMockForSinkeiyaku.TESTPATTERN1;
        SetNenreiMockForSinkeiyaku.SYORIPTN = SetNenreiMockForSinkeiyaku.TESTPATTERN1;
        SetHubiMsgMockForSinkeiyaku.SYORIPTN = SetHubiMsgMockForSinkeiyaku.TESTPATTERN11;

        CheckHokenRyouYuukouKigen checkHokenRyouYuukouKigen = SWAKInjector.getInstance(CheckHokenRyouYuukouKigen.class);
        MosnaiCheckParam mosnaiCheckParam = SWAKInjector.getInstance(MosnaiCheckParam.class);

        sinkeiyakuDomManager.flush();
        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("791112527");
        List<HT_HubiMsg> hubiMsg = syoriCTL.getHubiMsgs();
        BM_SyouhnZokusei syouhnZokusei = bizDomManager.getSyouhnZokusei("ﾕｽ", 4);
        mosnaiCheckParam.setSyuSyouhnZokusei(syouhnZokusei);
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setSysDate(BizDate.valueOf("20160907"));
        mosnaiCheckParam.setListHubiMsg(hubiMsg);
        checkHokenRyouYuukouKigen.exec(mosnaiCheckParam);

        exNumericEquals(hubiMsg.size(), 0, "不備メッセージ件数");

        exDateEquals((BizDate)MockObjectManager.getArgument(SetKisoKoumokuMockForSinkeiyaku.class, "setkykymdHantei", 0, 2), null, "領収日");
        exDateEquals((BizDate)MockObjectManager.getArgument(SetKisoKoumokuMockForSinkeiyaku.class, "setkykymdHantei", 0, 3), BizDate.valueOf(20160701), "申込日");
        exDateEquals((BizDate)MockObjectManager.getArgument(SetKisoKoumokuMockForSinkeiyaku.class, "setkykymdHantei", 0, 4), BizDate.valueOf(20160701), "責任開始日");
        exDateEquals((BizDate)MockObjectManager.getArgument(SetKisoKoumokuMockForSinkeiyaku.class, "setkykymdHantei", 0, 5), BizDate.valueOf(20160701), "処理日");
        exClassificationEquals((C_SysKbn)MockObjectManager.getArgument(SetKisoKoumokuMockForSinkeiyaku.class, "setkykymdHantei", 0, 6), C_SysKbn.SKEI, "システム区分");
        exClassificationEquals((C_YoteikykymdKbn)MockObjectManager.getArgument(SetKisoKoumokuMockForSinkeiyaku.class, "setkykymdHantei", 0, 7), C_YoteikykymdKbn.AUTO, "予定契約日区分");

        exDateEquals((BizDate)MockObjectManager.getArgument(SetNenreiMockForSinkeiyaku.class, "exec", 0, 0), BizDate.valueOf(20180203), "基準日");
        exDateEquals((BizDate)MockObjectManager.getArgument(SetNenreiMockForSinkeiyaku.class, "exec", 0, 1), BizDate.valueOf(20010505), "生年月日");

    }

    @Test
    @Transactional
    @TestOrder(340)
    public void testExec_A34() {

        MockObjectManager.initialize();
        HanteiMoschkMockForSinkeiyaku.SYORIPTN = HanteiMoschkMockForSinkeiyaku.TESTPATTERN7;
        SetKisoKoumokuMockForSinkeiyaku.SYORIPTN = SetKisoKoumokuMockForSinkeiyaku.TESTPATTERN1;
        SetNenreiMockForSinkeiyaku.SYORIPTN = SetNenreiMockForSinkeiyaku.TESTPATTERN1;
        SetHubiMsgMockForSinkeiyaku.SYORIPTN = SetHubiMsgMockForSinkeiyaku.TESTPATTERN11;
        EditPdfYoteirirtuMockForSinkeiyaku.SYORIPTN = EditPdfYoteirirtuMockForSinkeiyaku.TESTPATTERN1;

        CheckHokenRyouYuukouKigen checkHokenRyouYuukouKigen = SWAKInjector.getInstance(CheckHokenRyouYuukouKigen.class);
        MosnaiCheckParam mosnaiCheckParam = SWAKInjector.getInstance(MosnaiCheckParam.class);

        sinkeiyakuDomManager.flush();
        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("791112535");
        List<HT_HubiMsg> hubiMsg = syoriCTL.getHubiMsgs();
        BM_SyouhnZokusei syouhnZokusei = bizDomManager.getSyouhnZokusei("ﾕｾ", 4);
        mosnaiCheckParam.setSyuSyouhnZokusei(syouhnZokusei);
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setSysDate(BizDate.valueOf("20160907"));
        mosnaiCheckParam.setListHubiMsg(hubiMsg);
        checkHokenRyouYuukouKigen.exec(mosnaiCheckParam);

        exNumericEquals(hubiMsg.size(), 1, "不備メッセージ件数");
        exStringEquals(hubiMsg.get(0).getHubimsg(), "積立利率が申込時点から低下しています。申込日　40.00％　契約日　30.00％", "不備メッセージ");
        exStringEquals(hubiMsg.get(0).getMessageId(), "EHC1071", "メッセージＩＤ");
        exStringEquals(hubiMsg.get(0).getMosno(), "791112535", "申込番号");
        exNumericEquals(hubiMsg.get(0).getRenno(), 1, "連番");
        exClassificationEquals(hubiMsg.get(0).getHubisyubetukbn(), C_HubisyubetuKbn.KETHORYU_HUBI, "不備種別区分");
        exClassificationEquals(hubiMsg.get(0).getHubisyubetusyousaikbn(), C_HubisyubetusyousaiKbn.NONE, "不備種別詳細区分");

        exDateEquals((BizDate)MockObjectManager.getArgument(SetKisoKoumokuMockForSinkeiyaku.class, "setkykymdHantei", 0, 2), null, "領収日");
        exDateEquals((BizDate)MockObjectManager.getArgument(SetKisoKoumokuMockForSinkeiyaku.class, "setkykymdHantei", 0, 3), BizDate.valueOf(20160701), "申込日");
        exDateEquals((BizDate)MockObjectManager.getArgument(SetKisoKoumokuMockForSinkeiyaku.class, "setkykymdHantei", 0, 4), BizDate.valueOf(20160701), "責任開始日");
        exDateEquals((BizDate)MockObjectManager.getArgument(SetKisoKoumokuMockForSinkeiyaku.class, "setkykymdHantei", 0, 5), BizDate.valueOf(20160701), "処理日");
        exClassificationEquals((C_SysKbn)MockObjectManager.getArgument(SetKisoKoumokuMockForSinkeiyaku.class, "setkykymdHantei", 0, 6), C_SysKbn.SKEI, "システム区分");
        exClassificationEquals((C_YoteikykymdKbn)MockObjectManager.getArgument(SetKisoKoumokuMockForSinkeiyaku.class, "setkykymdHantei", 0, 7), C_YoteikykymdKbn.AUTO, "予定契約日区分");

        exDateEquals((BizDate)MockObjectManager.getArgument(SetNenreiMockForSinkeiyaku.class, "exec", 0, 0), BizDate.valueOf(20180203), "基準日");
        exDateEquals((BizDate)MockObjectManager.getArgument(SetNenreiMockForSinkeiyaku.class, "exec", 0, 1), BizDate.valueOf(20010505), "生年月日");

        exBizCalcbleEquals((BizNumber)MockObjectManager.getArgument(EditPdfYoteirirtuMockForSinkeiyaku.class, "exec", 0, 1), BizNumber.valueOf(0), "申込日予定利率");
        exBizCalcbleEquals((BizNumber)MockObjectManager.getArgument(EditPdfYoteirirtuMockForSinkeiyaku.class, "exec", 0, 2), BizNumber.valueOf(0), "契約日予定利率");
        exClassificationEquals((C_UmuKbn)MockObjectManager.getArgument(EditPdfYoteirirtuMockForSinkeiyaku.class, "exec", 0, 3), C_UmuKbn.NONE, "予定利率変動有無");
        exBizCalcbleEquals((BizNumber)MockObjectManager.getArgument(EditPdfYoteirirtuMockForSinkeiyaku.class, "exec", 0, 4), BizNumber.valueOf(40), "申込日積立利率");
        exBizCalcbleEquals((BizNumber)MockObjectManager.getArgument(EditPdfYoteirirtuMockForSinkeiyaku.class, "exec", 0, 5), BizNumber.valueOf(30), "契約日積立利率");
        exBizCalcbleEquals((BizNumber)MockObjectManager.getArgument(EditPdfYoteirirtuMockForSinkeiyaku.class, "exec", 0, 6), BizNumber.valueOf(23), "申込日ローディング変更後積立利率");
        exBizCalcbleEquals((BizNumber)MockObjectManager.getArgument(EditPdfYoteirirtuMockForSinkeiyaku.class, "exec", 0, 7), BizNumber.valueOf(0), "契約日ローディング変更後積立利率");
        exClassificationEquals((C_UmuKbn)MockObjectManager.getArgument(EditPdfYoteirirtuMockForSinkeiyaku.class, "exec", 0, 8), C_UmuKbn.ARI, "積立利率変動有無");
        exBizCalcbleEquals((BizNumber)MockObjectManager.getArgument(EditPdfYoteirirtuMockForSinkeiyaku.class, "exec", 0, 9), BizNumber.valueOf(0), "申込日積立金増加率上限");
        exBizCalcbleEquals((BizNumber)MockObjectManager.getArgument(EditPdfYoteirirtuMockForSinkeiyaku.class, "exec", 0, 10), BizNumber.valueOf(0), "契約日積立金増加率上限");
        exClassificationEquals((C_UmuKbn)MockObjectManager.getArgument(EditPdfYoteirirtuMockForSinkeiyaku.class, "exec", 0, 11), C_UmuKbn.NONE, "積立金増加率上限変動有無");
        exBizCalcbleEquals((BizNumber)MockObjectManager.getArgument(EditPdfYoteirirtuMockForSinkeiyaku.class, "exec", 0, 12), BizNumber.valueOf(0), "申込日設定倍率");
        exBizCalcbleEquals((BizNumber)MockObjectManager.getArgument(EditPdfYoteirirtuMockForSinkeiyaku.class, "exec", 0,13), BizNumber.valueOf(0), "契約日設定倍率");
        exClassificationEquals((C_UmuKbn)MockObjectManager.getArgument(EditPdfYoteirirtuMockForSinkeiyaku.class, "exec", 0, 14), C_UmuKbn.NONE, "設定倍率変動有無");
        exBizCalcbleEquals((BizNumber)MockObjectManager.getArgument(EditPdfYoteirirtuMockForSinkeiyaku.class, "exec", 0, 15), BizNumber.valueOf(0), "申込日連動率");
        exBizCalcbleEquals((BizNumber)MockObjectManager.getArgument(EditPdfYoteirirtuMockForSinkeiyaku.class, "exec", 0,16), BizNumber.valueOf(0), "契約日連動率");
        exClassificationEquals((C_UmuKbn)MockObjectManager.getArgument(EditPdfYoteirirtuMockForSinkeiyaku.class, "exec", 0, 17), C_UmuKbn.NONE, "連動率変動有無");

        exClassificationEquals((C_KetsrhkosKbn)MockObjectManager.getArgument(SetHubiMsgMockForSinkeiyaku.class, "exec", 0, 0), C_KetsrhkosKbn.KETHORYU_HUBI, "決定・成立保留更新区分");
        exClassificationEquals((C_SpKeisanKahiKbn)MockObjectManager.getArgument(SetHubiMsgMockForSinkeiyaku.class, "exec", 0, 1), C_SpKeisanKahiKbn.SPKEISANKA, "決定保留時ＳＰ計算可否区分");
        exClassificationEquals((C_HubisyubetusyousaiKbn)MockObjectManager.getArgument(SetHubiMsgMockForSinkeiyaku.class, "exec", 0, 2), C_HubisyubetusyousaiKbn.NONE, "不備種別詳細区分");
        exStringEquals((String)MockObjectManager.getArgument(SetHubiMsgMockForSinkeiyaku.class, "exec", 0, 3), "EHC1071 積立利率が申込時点から低下しています。申込日　40.00％　契約日　30.00％", "メッセージ文言");
        exClassificationEquals((C_TknKbn)MockObjectManager.getArgument(SetHubiMsgMockForSinkeiyaku.class, "exec", 0, 5), C_TknKbn.SUMI, "特認区分");
        exClassificationEquals((C_MsgKbn)MockObjectManager.getArgument(SetHubiMsgMockForSinkeiyaku.class, "exec", 0, 6), C_MsgKbn.ERROR, "メッセージ区分");
    }

    @Test
    @Transactional
    @TestOrder(350)
    public void testExec_A35() {

        MockObjectManager.initialize();
        HanteiMoschkMockForSinkeiyaku.SYORIPTN = HanteiMoschkMockForSinkeiyaku.TESTPATTERN7;
        SetKisoKoumokuMockForSinkeiyaku.SYORIPTN = SetKisoKoumokuMockForSinkeiyaku.TESTPATTERN1;
        SetNenreiMockForSinkeiyaku.SYORIPTN = SetNenreiMockForSinkeiyaku.TESTPATTERN1;

        CheckHokenRyouYuukouKigen checkHokenRyouYuukouKigen = SWAKInjector.getInstance(CheckHokenRyouYuukouKigen.class);
        MosnaiCheckParam mosnaiCheckParam = SWAKInjector.getInstance(MosnaiCheckParam.class);

        sinkeiyakuDomManager.flush();
        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("791112543");
        List<HT_HubiMsg> hubiMsg = syoriCTL.getHubiMsgs();
        BM_SyouhnZokusei syouhnZokusei = bizDomManager.getSyouhnZokusei("ﾕｿ", 5);
        mosnaiCheckParam.setSyuSyouhnZokusei(syouhnZokusei);
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setSysDate(BizDate.valueOf("20160907"));
        mosnaiCheckParam.setListHubiMsg(hubiMsg);
        checkHokenRyouYuukouKigen.exec(mosnaiCheckParam);

        exNumericEquals(hubiMsg.size(), 0, "不備メッセージ件数");

        exDateEquals((BizDate)MockObjectManager.getArgument(SetKisoKoumokuMockForSinkeiyaku.class, "setkykymdHantei", 0, 2), null, "領収日");
        exDateEquals((BizDate)MockObjectManager.getArgument(SetKisoKoumokuMockForSinkeiyaku.class, "setkykymdHantei", 0, 3), BizDate.valueOf(20160701), "申込日");
        exDateEquals((BizDate)MockObjectManager.getArgument(SetKisoKoumokuMockForSinkeiyaku.class, "setkykymdHantei", 0, 4), BizDate.valueOf(20160701), "責任開始日");
        exDateEquals((BizDate)MockObjectManager.getArgument(SetKisoKoumokuMockForSinkeiyaku.class, "setkykymdHantei", 0, 5), BizDate.valueOf(20160701), "処理日");
        exClassificationEquals((C_SysKbn)MockObjectManager.getArgument(SetKisoKoumokuMockForSinkeiyaku.class, "setkykymdHantei", 0, 6), C_SysKbn.SKEI, "システム区分");
        exClassificationEquals((C_YoteikykymdKbn)MockObjectManager.getArgument(SetKisoKoumokuMockForSinkeiyaku.class, "setkykymdHantei", 0, 7), C_YoteikykymdKbn.AUTO, "予定契約日区分");

        exDateEquals((BizDate)MockObjectManager.getArgument(SetNenreiMockForSinkeiyaku.class, "exec", 0, 0), BizDate.valueOf(20180203), "基準日");
        exDateEquals((BizDate)MockObjectManager.getArgument(SetNenreiMockForSinkeiyaku.class, "exec", 0, 1), BizDate.valueOf(20010505), "生年月日");

    }

    @Test
    @Transactional
    @TestOrder(360)
    public void testExec_A36() {

        MockObjectManager.initialize();
        HanteiMoschkMockForSinkeiyaku.SYORIPTN = HanteiMoschkMockForSinkeiyaku.TESTPATTERN8;
        SetKisoKoumokuMockForSinkeiyaku.SYORIPTN = SetKisoKoumokuMockForSinkeiyaku.TESTPATTERN1;
        SetNenreiMockForSinkeiyaku.SYORIPTN = SetNenreiMockForSinkeiyaku.TESTPATTERN1;

        CheckHokenRyouYuukouKigen checkHokenRyouYuukouKigen = SWAKInjector.getInstance(CheckHokenRyouYuukouKigen.class);
        MosnaiCheckParam mosnaiCheckParam = SWAKInjector.getInstance(MosnaiCheckParam.class);

        sinkeiyakuDomManager.flush();
        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("791112550");
        List<HT_HubiMsg> hubiMsg = syoriCTL.getHubiMsgs();
        BM_SyouhnZokusei syouhnZokusei = bizDomManager.getSyouhnZokusei("ﾕｲ", 5);
        mosnaiCheckParam.setSyuSyouhnZokusei(syouhnZokusei);
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setSysDate(BizDate.valueOf("20160907"));
        mosnaiCheckParam.setListHubiMsg(hubiMsg);
        checkHokenRyouYuukouKigen.exec(mosnaiCheckParam);

        exNumericEquals(hubiMsg.size(), 0, "不備メッセージ件数");

        exDateEquals((BizDate)MockObjectManager.getArgument(SetKisoKoumokuMockForSinkeiyaku.class, "setkykymdHantei", 0, 2), null, "領収日");
        exDateEquals((BizDate)MockObjectManager.getArgument(SetKisoKoumokuMockForSinkeiyaku.class, "setkykymdHantei", 0, 3), BizDate.valueOf(20160701), "申込日");
        exDateEquals((BizDate)MockObjectManager.getArgument(SetKisoKoumokuMockForSinkeiyaku.class, "setkykymdHantei", 0, 4), BizDate.valueOf(20160701), "責任開始日");
        exDateEquals((BizDate)MockObjectManager.getArgument(SetKisoKoumokuMockForSinkeiyaku.class, "setkykymdHantei", 0, 5), BizDate.valueOf(20160701), "処理日");
        exClassificationEquals((C_SysKbn)MockObjectManager.getArgument(SetKisoKoumokuMockForSinkeiyaku.class, "setkykymdHantei", 0, 6), C_SysKbn.SKEI, "システム区分");
        exClassificationEquals((C_YoteikykymdKbn)MockObjectManager.getArgument(SetKisoKoumokuMockForSinkeiyaku.class, "setkykymdHantei", 0, 7), C_YoteikykymdKbn.AUTO, "予定契約日区分");

        exDateEquals((BizDate)MockObjectManager.getArgument(SetNenreiMockForSinkeiyaku.class, "exec", 0, 0), BizDate.valueOf(20180203), "基準日");
        exDateEquals((BizDate)MockObjectManager.getArgument(SetNenreiMockForSinkeiyaku.class, "exec", 0, 1), BizDate.valueOf(20010505), "生年月日");

    }

    @Test
    @Transactional
    @TestOrder(370)
    public void testExec_A37() {

        MockObjectManager.initialize();
        HanteiMoschkMockForSinkeiyaku.SYORIPTN = HanteiMoschkMockForSinkeiyaku.TESTPATTERN8;
        SetKisoKoumokuMockForSinkeiyaku.SYORIPTN = SetKisoKoumokuMockForSinkeiyaku.TESTPATTERN1;
        SetNenreiMockForSinkeiyaku.SYORIPTN = SetNenreiMockForSinkeiyaku.TESTPATTERN1;

        CheckHokenRyouYuukouKigen checkHokenRyouYuukouKigen = SWAKInjector.getInstance(CheckHokenRyouYuukouKigen.class);
        MosnaiCheckParam mosnaiCheckParam = SWAKInjector.getInstance(MosnaiCheckParam.class);

        sinkeiyakuDomManager.flush();
        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("791112568");
        List<HT_HubiMsg> hubiMsg = syoriCTL.getHubiMsgs();
        BM_SyouhnZokusei syouhnZokusei = bizDomManager.getSyouhnZokusei("ﾕｳ", 5);
        mosnaiCheckParam.setSyuSyouhnZokusei(syouhnZokusei);
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setSysDate(BizDate.valueOf("20160907"));
        mosnaiCheckParam.setListHubiMsg(hubiMsg);
        checkHokenRyouYuukouKigen.exec(mosnaiCheckParam);

        exNumericEquals(hubiMsg.size(), 0, "不備メッセージ件数");

        exDateEquals((BizDate)MockObjectManager.getArgument(SetKisoKoumokuMockForSinkeiyaku.class, "setkykymdHantei", 0, 2), null, "領収日");
        exDateEquals((BizDate)MockObjectManager.getArgument(SetKisoKoumokuMockForSinkeiyaku.class, "setkykymdHantei", 0, 3), BizDate.valueOf(20160701), "申込日");
        exDateEquals((BizDate)MockObjectManager.getArgument(SetKisoKoumokuMockForSinkeiyaku.class, "setkykymdHantei", 0, 4), BizDate.valueOf(20160701), "責任開始日");
        exDateEquals((BizDate)MockObjectManager.getArgument(SetKisoKoumokuMockForSinkeiyaku.class, "setkykymdHantei", 0, 5), BizDate.valueOf(20160701), "処理日");
        exClassificationEquals((C_SysKbn)MockObjectManager.getArgument(SetKisoKoumokuMockForSinkeiyaku.class, "setkykymdHantei", 0, 6), C_SysKbn.SKEI, "システム区分");
        exClassificationEquals((C_YoteikykymdKbn)MockObjectManager.getArgument(SetKisoKoumokuMockForSinkeiyaku.class, "setkykymdHantei", 0, 7), C_YoteikykymdKbn.AUTO, "予定契約日区分");

        exDateEquals((BizDate)MockObjectManager.getArgument(SetNenreiMockForSinkeiyaku.class, "exec", 0, 0), BizDate.valueOf(20180203), "基準日");
        exDateEquals((BizDate)MockObjectManager.getArgument(SetNenreiMockForSinkeiyaku.class, "exec", 0, 1), BizDate.valueOf(20010505), "生年月日");

    }

    @Test
    @Transactional
    @TestOrder(380)
    public void testExec_A38() {

        MockObjectManager.initialize();
        HanteiMoschkMockForSinkeiyaku.SYORIPTN = HanteiMoschkMockForSinkeiyaku.TESTPATTERN8;
        SetKisoKoumokuMockForSinkeiyaku.SYORIPTN = SetKisoKoumokuMockForSinkeiyaku.TESTPATTERN1;
        SetNenreiMockForSinkeiyaku.SYORIPTN = SetNenreiMockForSinkeiyaku.TESTPATTERN1;
        SetHubiMsgMockForSinkeiyaku.SYORIPTN = SetHubiMsgMockForSinkeiyaku.TESTPATTERN12;

        CheckHokenRyouYuukouKigen checkHokenRyouYuukouKigen = SWAKInjector.getInstance(CheckHokenRyouYuukouKigen.class);
        MosnaiCheckParam mosnaiCheckParam = SWAKInjector.getInstance(MosnaiCheckParam.class);

        sinkeiyakuDomManager.flush();
        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("791112576");
        List<HT_HubiMsg> hubiMsg = syoriCTL.getHubiMsgs();
        BM_SyouhnZokusei syouhnZokusei = bizDomManager.getSyouhnZokusei("ﾕA", 5);
        mosnaiCheckParam.setSyuSyouhnZokusei(syouhnZokusei);
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setSysDate(BizDate.valueOf("20160907"));
        mosnaiCheckParam.setListHubiMsg(hubiMsg);
        checkHokenRyouYuukouKigen.exec(mosnaiCheckParam);

        exNumericEquals(hubiMsg.size(), 1, "不備メッセージ件数");
        exStringEquals(hubiMsg.get(0).getHubimsg(), "５年ごと利差配当付指定通貨建終身保険（一時払い）　　５年　最低保証あり（豪ドル）の積立利率が取得できません。申込日　20160701", "不備メッセージ");
        exStringEquals(hubiMsg.get(0).getMessageId(), "EHC1067", "メッセージＩＤ");
        exStringEquals(hubiMsg.get(0).getMosno(), "791112576", "申込番号");
        exNumericEquals(hubiMsg.get(0).getRenno(), 1, "連番");
        exClassificationEquals(hubiMsg.get(0).getHubisyubetukbn(), C_HubisyubetuKbn.KETHORYU_HUBI, "不備種別区分");
        exClassificationEquals(hubiMsg.get(0).getHubisyubetusyousaikbn(), C_HubisyubetusyousaiKbn.NONE, "不備種別詳細区分");

        exDateEquals((BizDate)MockObjectManager.getArgument(SetKisoKoumokuMockForSinkeiyaku.class, "setkykymdHantei", 0, 2), null, "領収日");
        exDateEquals((BizDate)MockObjectManager.getArgument(SetKisoKoumokuMockForSinkeiyaku.class, "setkykymdHantei", 0, 3), BizDate.valueOf(20160701), "申込日");
        exDateEquals((BizDate)MockObjectManager.getArgument(SetKisoKoumokuMockForSinkeiyaku.class, "setkykymdHantei", 0, 4), BizDate.valueOf(20160701), "責任開始日");
        exDateEquals((BizDate)MockObjectManager.getArgument(SetKisoKoumokuMockForSinkeiyaku.class, "setkykymdHantei", 0, 5), BizDate.valueOf(20160701), "処理日");
        exClassificationEquals((C_SysKbn)MockObjectManager.getArgument(SetKisoKoumokuMockForSinkeiyaku.class, "setkykymdHantei", 0, 6), C_SysKbn.SKEI, "システム区分");
        exClassificationEquals((C_YoteikykymdKbn)MockObjectManager.getArgument(SetKisoKoumokuMockForSinkeiyaku.class, "setkykymdHantei", 0, 7), C_YoteikykymdKbn.AUTO, "予定契約日区分");

        exDateEquals((BizDate)MockObjectManager.getArgument(SetNenreiMockForSinkeiyaku.class, "exec", 0, 0), BizDate.valueOf(20180203), "基準日");
        exDateEquals((BizDate)MockObjectManager.getArgument(SetNenreiMockForSinkeiyaku.class, "exec", 0, 1), BizDate.valueOf(20010505), "生年月日");

        exClassificationEquals((C_KetsrhkosKbn)MockObjectManager.getArgument(SetHubiMsgMockForSinkeiyaku.class, "exec", 0, 0), C_KetsrhkosKbn.KETHORYU_HUBI, "決定・成立保留更新区分");
        exClassificationEquals((C_SpKeisanKahiKbn)MockObjectManager.getArgument(SetHubiMsgMockForSinkeiyaku.class, "exec", 0, 1), C_SpKeisanKahiKbn.SPKEISANKA, "決定保留時ＳＰ計算可否区分");
        exClassificationEquals((C_HubisyubetusyousaiKbn)MockObjectManager.getArgument(SetHubiMsgMockForSinkeiyaku.class, "exec", 0, 2), C_HubisyubetusyousaiKbn.NONE, "不備種別詳細区分");
        exStringEquals((String)MockObjectManager.getArgument(SetHubiMsgMockForSinkeiyaku.class, "exec", 0, 3), "EHC1067 ５年ごと利差配当付指定通貨建終身保険（一時払い）　　５年　最低保証あり（豪ドル）の積立利率が取得できません。申込日　20160701", "メッセージ文言");
        exClassificationEquals((C_TknKbn)MockObjectManager.getArgument(SetHubiMsgMockForSinkeiyaku.class, "exec", 0, 5), C_TknKbn.NONE, "特認区分");
        exClassificationEquals((C_MsgKbn)MockObjectManager.getArgument(SetHubiMsgMockForSinkeiyaku.class, "exec", 0, 6), C_MsgKbn.ERROR, "メッセージ区分");

    }

    @Test
    @Transactional
    @TestOrder(390)
    public void testExec_A39() {

        MockObjectManager.initialize();
        HanteiMoschkMockForSinkeiyaku.SYORIPTN = HanteiMoschkMockForSinkeiyaku.TESTPATTERN8;
        SetKisoKoumokuMockForSinkeiyaku.SYORIPTN = SetKisoKoumokuMockForSinkeiyaku.TESTPATTERN1;
        SetNenreiMockForSinkeiyaku.SYORIPTN = SetNenreiMockForSinkeiyaku.TESTPATTERN1;
        SetHubiMsgMockForSinkeiyaku.SYORIPTN = SetHubiMsgMockForSinkeiyaku.TESTPATTERN13;

        CheckHokenRyouYuukouKigen checkHokenRyouYuukouKigen = SWAKInjector.getInstance(CheckHokenRyouYuukouKigen.class);
        MosnaiCheckParam mosnaiCheckParam = SWAKInjector.getInstance(MosnaiCheckParam.class);

        sinkeiyakuDomManager.flush();
        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("791112584");
        List<HT_HubiMsg> hubiMsg = syoriCTL.getHubiMsgs();
        BM_SyouhnZokusei syouhnZokusei = bizDomManager.getSyouhnZokusei("ﾕﾀ", 5);
        mosnaiCheckParam.setSyuSyouhnZokusei(syouhnZokusei);
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setSysDate(BizDate.valueOf("20160907"));
        mosnaiCheckParam.setListHubiMsg(hubiMsg);
        checkHokenRyouYuukouKigen.exec(mosnaiCheckParam);

        exNumericEquals(hubiMsg.size(), 1, "不備メッセージ件数");
        exStringEquals(hubiMsg.get(0).getHubimsg(), "積立金増加率の上限が申込時点から上昇しています。申込日　60.00％　契約日　80.00％", "不備メッセージ");
        exStringEquals(hubiMsg.get(0).getMessageId(), "EHC1069", "メッセージＩＤ");
        exStringEquals(hubiMsg.get(0).getMosno(), "791112584", "申込番号");
        exNumericEquals(hubiMsg.get(0).getRenno(), 1, "連番");
        exClassificationEquals(hubiMsg.get(0).getHubisyubetukbn(), C_HubisyubetuKbn.KETHORYU_HUBI, "不備種別区分");
        exClassificationEquals(hubiMsg.get(0).getHubisyubetusyousaikbn(), C_HubisyubetusyousaiKbn.NONE, "不備種別詳細区分");

        exDateEquals((BizDate)MockObjectManager.getArgument(SetKisoKoumokuMockForSinkeiyaku.class, "setkykymdHantei", 0, 2), null, "領収日");
        exDateEquals((BizDate)MockObjectManager.getArgument(SetKisoKoumokuMockForSinkeiyaku.class, "setkykymdHantei", 0, 3), BizDate.valueOf(20160701), "申込日");
        exDateEquals((BizDate)MockObjectManager.getArgument(SetKisoKoumokuMockForSinkeiyaku.class, "setkykymdHantei", 0, 4), BizDate.valueOf(20160701), "責任開始日");
        exDateEquals((BizDate)MockObjectManager.getArgument(SetKisoKoumokuMockForSinkeiyaku.class, "setkykymdHantei", 0, 5), BizDate.valueOf(20160701), "処理日");
        exClassificationEquals((C_SysKbn)MockObjectManager.getArgument(SetKisoKoumokuMockForSinkeiyaku.class, "setkykymdHantei", 0, 6), C_SysKbn.SKEI, "システム区分");
        exClassificationEquals((C_YoteikykymdKbn)MockObjectManager.getArgument(SetKisoKoumokuMockForSinkeiyaku.class, "setkykymdHantei", 0, 7), C_YoteikykymdKbn.AUTO, "予定契約日区分");

        exDateEquals((BizDate)MockObjectManager.getArgument(SetNenreiMockForSinkeiyaku.class, "exec", 0, 0), BizDate.valueOf(20180203), "基準日");
        exDateEquals((BizDate)MockObjectManager.getArgument(SetNenreiMockForSinkeiyaku.class, "exec", 0, 1), BizDate.valueOf(20010505), "生年月日");

        exClassificationEquals((C_KetsrhkosKbn)MockObjectManager.getArgument(SetHubiMsgMockForSinkeiyaku.class, "exec", 0, 0), C_KetsrhkosKbn.KETHORYU_HUBI, "決定・成立保留更新区分");
        exClassificationEquals((C_SpKeisanKahiKbn)MockObjectManager.getArgument(SetHubiMsgMockForSinkeiyaku.class, "exec", 0, 1), C_SpKeisanKahiKbn.SPKEISANKA, "決定保留時ＳＰ計算可否区分");
        exClassificationEquals((C_HubisyubetusyousaiKbn)MockObjectManager.getArgument(SetHubiMsgMockForSinkeiyaku.class, "exec", 0, 2), C_HubisyubetusyousaiKbn.NONE, "不備種別詳細区分");
        exStringEquals((String)MockObjectManager.getArgument(SetHubiMsgMockForSinkeiyaku.class, "exec", 0, 3), "EHC1069 積立金増加率の上限が申込時点から上昇しています。申込日　60.00％　契約日　80.00％", "メッセージ文言");
        exClassificationEquals((C_TknKbn)MockObjectManager.getArgument(SetHubiMsgMockForSinkeiyaku.class, "exec", 0, 5), C_TknKbn.KANOU, "特認区分");
        exClassificationEquals((C_MsgKbn)MockObjectManager.getArgument(SetHubiMsgMockForSinkeiyaku.class, "exec", 0, 6), C_MsgKbn.ERROR, "メッセージ区分");

    }

    @Test
    @Transactional
    @TestOrder(400)
    public void testExec_A40() {

        MockObjectManager.initialize();
        HanteiMoschkMockForSinkeiyaku.SYORIPTN = HanteiMoschkMockForSinkeiyaku.TESTPATTERN8;
        SetKisoKoumokuMockForSinkeiyaku.SYORIPTN = SetKisoKoumokuMockForSinkeiyaku.TESTPATTERN1;
        SetNenreiMockForSinkeiyaku.SYORIPTN = SetNenreiMockForSinkeiyaku.TESTPATTERN1;

        CheckHokenRyouYuukouKigen checkHokenRyouYuukouKigen = SWAKInjector.getInstance(CheckHokenRyouYuukouKigen.class);
        MosnaiCheckParam mosnaiCheckParam = SWAKInjector.getInstance(MosnaiCheckParam.class);

        sinkeiyakuDomManager.flush();
        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("791112592");
        List<HT_HubiMsg> hubiMsg = syoriCTL.getHubiMsgs();
        BM_SyouhnZokusei syouhnZokusei = bizDomManager.getSyouhnZokusei("ﾕｶ", 5);
        mosnaiCheckParam.setSyuSyouhnZokusei(syouhnZokusei);
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setSysDate(BizDate.valueOf("20160907"));
        mosnaiCheckParam.setListHubiMsg(hubiMsg);
        checkHokenRyouYuukouKigen.exec(mosnaiCheckParam);

        exNumericEquals(hubiMsg.size(), 0, "不備メッセージ件数");

        exDateEquals((BizDate)MockObjectManager.getArgument(SetKisoKoumokuMockForSinkeiyaku.class, "setkykymdHantei", 0, 2), null, "領収日");
        exDateEquals((BizDate)MockObjectManager.getArgument(SetKisoKoumokuMockForSinkeiyaku.class, "setkykymdHantei", 0, 3), BizDate.valueOf(20160701), "申込日");
        exDateEquals((BizDate)MockObjectManager.getArgument(SetKisoKoumokuMockForSinkeiyaku.class, "setkykymdHantei", 0, 4), BizDate.valueOf(20160701), "責任開始日");
        exDateEquals((BizDate)MockObjectManager.getArgument(SetKisoKoumokuMockForSinkeiyaku.class, "setkykymdHantei", 0, 5), BizDate.valueOf(20160701), "処理日");
        exClassificationEquals((C_SysKbn)MockObjectManager.getArgument(SetKisoKoumokuMockForSinkeiyaku.class, "setkykymdHantei", 0, 6), C_SysKbn.SKEI, "システム区分");
        exClassificationEquals((C_YoteikykymdKbn)MockObjectManager.getArgument(SetKisoKoumokuMockForSinkeiyaku.class, "setkykymdHantei", 0, 7), C_YoteikykymdKbn.AUTO, "予定契約日区分");

        exDateEquals((BizDate)MockObjectManager.getArgument(SetNenreiMockForSinkeiyaku.class, "exec", 0, 0), BizDate.valueOf(20180203), "基準日");
        exDateEquals((BizDate)MockObjectManager.getArgument(SetNenreiMockForSinkeiyaku.class, "exec", 0, 1), BizDate.valueOf(20010505), "生年月日");

    }

    @Test
    @Transactional
    @TestOrder(410)
    public void testExec_A41() {

        MockObjectManager.initialize();
        HanteiMoschkMockForSinkeiyaku.SYORIPTN = HanteiMoschkMockForSinkeiyaku.TESTPATTERN8;
        SetKisoKoumokuMockForSinkeiyaku.SYORIPTN = SetKisoKoumokuMockForSinkeiyaku.TESTPATTERN1;
        SetNenreiMockForSinkeiyaku.SYORIPTN = SetNenreiMockForSinkeiyaku.TESTPATTERN1;
        SetHubiMsgMockForSinkeiyaku.SYORIPTN = SetHubiMsgMockForSinkeiyaku.TESTPATTERN14;
        EditPdfYoteirirtuMockForSinkeiyaku.SYORIPTN = EditPdfYoteirirtuMockForSinkeiyaku.TESTPATTERN1;

        CheckHokenRyouYuukouKigen checkHokenRyouYuukouKigen = SWAKInjector.getInstance(CheckHokenRyouYuukouKigen.class);
        MosnaiCheckParam mosnaiCheckParam = SWAKInjector.getInstance(MosnaiCheckParam.class);

        sinkeiyakuDomManager.flush();
        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("791112600");
        List<HT_HubiMsg> hubiMsg = syoriCTL.getHubiMsgs();
        BM_SyouhnZokusei syouhnZokusei = bizDomManager.getSyouhnZokusei("ﾕｷ", 5);
        mosnaiCheckParam.setSyuSyouhnZokusei(syouhnZokusei);
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setSysDate(BizDate.valueOf("20160907"));
        mosnaiCheckParam.setListHubiMsg(hubiMsg);
        checkHokenRyouYuukouKigen.exec(mosnaiCheckParam);

        exNumericEquals(hubiMsg.size(), 1, "不備メッセージ件数");
        exStringEquals(hubiMsg.get(0).getHubimsg(), "積立金増加率の上限が申込時点から低下しています。申込日　90.00％　契約日　80.00％　", "不備メッセージ");
        exStringEquals(hubiMsg.get(0).getMessageId(), "EHC1072", "メッセージＩＤ");
        exStringEquals(hubiMsg.get(0).getMosno(), "791112600", "申込番号");
        exNumericEquals(hubiMsg.get(0).getRenno(), 1, "連番");
        exClassificationEquals(hubiMsg.get(0).getHubisyubetukbn(), C_HubisyubetuKbn.KETHORYU_HUBI, "不備種別区分");
        exClassificationEquals(hubiMsg.get(0).getHubisyubetusyousaikbn(), C_HubisyubetusyousaiKbn.NONE, "不備種別詳細区分");

        exDateEquals((BizDate)MockObjectManager.getArgument(SetKisoKoumokuMockForSinkeiyaku.class, "setkykymdHantei", 0, 2), null, "領収日");
        exDateEquals((BizDate)MockObjectManager.getArgument(SetKisoKoumokuMockForSinkeiyaku.class, "setkykymdHantei", 0, 3), BizDate.valueOf(20160701), "申込日");
        exDateEquals((BizDate)MockObjectManager.getArgument(SetKisoKoumokuMockForSinkeiyaku.class, "setkykymdHantei", 0, 4), BizDate.valueOf(20160701), "責任開始日");
        exDateEquals((BizDate)MockObjectManager.getArgument(SetKisoKoumokuMockForSinkeiyaku.class, "setkykymdHantei", 0, 5), BizDate.valueOf(20160701), "処理日");
        exClassificationEquals((C_SysKbn)MockObjectManager.getArgument(SetKisoKoumokuMockForSinkeiyaku.class, "setkykymdHantei", 0, 6), C_SysKbn.SKEI, "システム区分");
        exClassificationEquals((C_YoteikykymdKbn)MockObjectManager.getArgument(SetKisoKoumokuMockForSinkeiyaku.class, "setkykymdHantei", 0, 7), C_YoteikykymdKbn.AUTO, "予定契約日区分");

        exDateEquals((BizDate)MockObjectManager.getArgument(SetNenreiMockForSinkeiyaku.class, "exec", 0, 0), BizDate.valueOf(20180203), "基準日");
        exDateEquals((BizDate)MockObjectManager.getArgument(SetNenreiMockForSinkeiyaku.class, "exec", 0, 1), BizDate.valueOf(20010505), "生年月日");

        exBizCalcbleEquals((BizNumber)MockObjectManager.getArgument(EditPdfYoteirirtuMockForSinkeiyaku.class, "exec", 0, 1), BizNumber.valueOf(0), "申込日予定利率");
        exBizCalcbleEquals((BizNumber)MockObjectManager.getArgument(EditPdfYoteirirtuMockForSinkeiyaku.class, "exec", 0, 2), BizNumber.valueOf(0), "契約日予定利率");
        exClassificationEquals((C_UmuKbn)MockObjectManager.getArgument(EditPdfYoteirirtuMockForSinkeiyaku.class, "exec", 0, 3), C_UmuKbn.NONE, "予定利率変動有無");
        exBizCalcbleEquals((BizNumber)MockObjectManager.getArgument(EditPdfYoteirirtuMockForSinkeiyaku.class, "exec", 0, 4), BizNumber.valueOf(0), "申込日積立利率");
        exBizCalcbleEquals((BizNumber)MockObjectManager.getArgument(EditPdfYoteirirtuMockForSinkeiyaku.class, "exec", 0, 5), BizNumber.valueOf(0), "契約日積立利率");
        exBizCalcbleEquals((BizNumber)MockObjectManager.getArgument(EditPdfYoteirirtuMockForSinkeiyaku.class, "exec", 0, 6), BizNumber.valueOf(34), "申込日ローディング変更後積立利率");
        exBizCalcbleEquals((BizNumber)MockObjectManager.getArgument(EditPdfYoteirirtuMockForSinkeiyaku.class, "exec", 0, 7), BizNumber.valueOf(0), "契約日ローディング変更後積立利率");
        exClassificationEquals((C_UmuKbn)MockObjectManager.getArgument(EditPdfYoteirirtuMockForSinkeiyaku.class, "exec", 0, 8), C_UmuKbn.NONE, "積立利率変動有無");
        exBizCalcbleEquals((BizNumber)MockObjectManager.getArgument(EditPdfYoteirirtuMockForSinkeiyaku.class, "exec", 0, 9), BizNumber.valueOf(90), "申込日積立金増加率上限");
        exBizCalcbleEquals((BizNumber)MockObjectManager.getArgument(EditPdfYoteirirtuMockForSinkeiyaku.class, "exec", 0, 10), BizNumber.valueOf(80), "契約日積立金増加率上限");
        exClassificationEquals((C_UmuKbn)MockObjectManager.getArgument(EditPdfYoteirirtuMockForSinkeiyaku.class, "exec", 0, 11), C_UmuKbn.ARI, "積立金増加率上限変動有無");
        exBizCalcbleEquals((BizNumber)MockObjectManager.getArgument(EditPdfYoteirirtuMockForSinkeiyaku.class, "exec", 0, 12), BizNumber.valueOf(0), "申込日設定倍率");
        exBizCalcbleEquals((BizNumber)MockObjectManager.getArgument(EditPdfYoteirirtuMockForSinkeiyaku.class, "exec", 0,13), BizNumber.valueOf(0), "契約日設定倍率");
        exClassificationEquals((C_UmuKbn)MockObjectManager.getArgument(EditPdfYoteirirtuMockForSinkeiyaku.class, "exec", 0, 14), C_UmuKbn.NONE, "設定倍率変動有無");
        exBizCalcbleEquals((BizNumber)MockObjectManager.getArgument(EditPdfYoteirirtuMockForSinkeiyaku.class, "exec", 0, 15), BizNumber.valueOf(80), "申込日連動率");
        exBizCalcbleEquals((BizNumber)MockObjectManager.getArgument(EditPdfYoteirirtuMockForSinkeiyaku.class, "exec", 0,16), BizNumber.valueOf(0), "契約日連動率");
        exClassificationEquals((C_UmuKbn)MockObjectManager.getArgument(EditPdfYoteirirtuMockForSinkeiyaku.class, "exec", 0, 17), C_UmuKbn.NONE, "連動率変動有無");

        exClassificationEquals((C_KetsrhkosKbn)MockObjectManager.getArgument(SetHubiMsgMockForSinkeiyaku.class, "exec", 0, 0), C_KetsrhkosKbn.KETHORYU_HUBI, "決定・成立保留更新区分");
        exClassificationEquals((C_SpKeisanKahiKbn)MockObjectManager.getArgument(SetHubiMsgMockForSinkeiyaku.class, "exec", 0, 1), C_SpKeisanKahiKbn.SPKEISANKA, "決定保留時ＳＰ計算可否区分");
        exClassificationEquals((C_HubisyubetusyousaiKbn)MockObjectManager.getArgument(SetHubiMsgMockForSinkeiyaku.class, "exec", 0, 2), C_HubisyubetusyousaiKbn.NONE, "不備種別詳細区分");
        exStringEquals((String)MockObjectManager.getArgument(SetHubiMsgMockForSinkeiyaku.class, "exec", 0, 3), "EHC1072 積立金増加率の上限が申込時点から低下しています。申込日　90.00％　契約日　80.00％", "メッセージ文言");
        exClassificationEquals((C_TknKbn)MockObjectManager.getArgument(SetHubiMsgMockForSinkeiyaku.class, "exec", 0, 5), C_TknKbn.SUMI, "特認区分");
        exClassificationEquals((C_MsgKbn)MockObjectManager.getArgument(SetHubiMsgMockForSinkeiyaku.class, "exec", 0, 6), C_MsgKbn.ERROR, "メッセージ区分");
    }

    @Test
    @Transactional
    @TestOrder(420)
    public void testExec_A42() {

        MockObjectManager.initialize();
        HanteiMoschkMockForSinkeiyaku.SYORIPTN = HanteiMoschkMockForSinkeiyaku.TESTPATTERN8;
        SetKisoKoumokuMockForSinkeiyaku.SYORIPTN = SetKisoKoumokuMockForSinkeiyaku.TESTPATTERN1;
        SetNenreiMockForSinkeiyaku.SYORIPTN = SetNenreiMockForSinkeiyaku.TESTPATTERN1;

        CheckHokenRyouYuukouKigen checkHokenRyouYuukouKigen = SWAKInjector.getInstance(CheckHokenRyouYuukouKigen.class);
        MosnaiCheckParam mosnaiCheckParam = SWAKInjector.getInstance(MosnaiCheckParam.class);

        sinkeiyakuDomManager.flush();
        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("791112618");
        List<HT_HubiMsg> hubiMsg = syoriCTL.getHubiMsgs();
        BM_SyouhnZokusei syouhnZokusei = bizDomManager.getSyouhnZokusei("ﾕｸ", 5);
        mosnaiCheckParam.setSyuSyouhnZokusei(syouhnZokusei);
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setSysDate(BizDate.valueOf("20160907"));
        mosnaiCheckParam.setListHubiMsg(hubiMsg);
        checkHokenRyouYuukouKigen.exec(mosnaiCheckParam);

        exNumericEquals(hubiMsg.size(), 0, "不備メッセージ件数");

        exDateEquals((BizDate)MockObjectManager.getArgument(SetKisoKoumokuMockForSinkeiyaku.class, "setkykymdHantei", 0, 2), null, "領収日");
        exDateEquals((BizDate)MockObjectManager.getArgument(SetKisoKoumokuMockForSinkeiyaku.class, "setkykymdHantei", 0, 3), BizDate.valueOf(20160701), "申込日");
        exDateEquals((BizDate)MockObjectManager.getArgument(SetKisoKoumokuMockForSinkeiyaku.class, "setkykymdHantei", 0, 4), BizDate.valueOf(20160701), "責任開始日");
        exDateEquals((BizDate)MockObjectManager.getArgument(SetKisoKoumokuMockForSinkeiyaku.class, "setkykymdHantei", 0, 5), BizDate.valueOf(20160701), "処理日");
        exClassificationEquals((C_SysKbn)MockObjectManager.getArgument(SetKisoKoumokuMockForSinkeiyaku.class, "setkykymdHantei", 0, 6), C_SysKbn.SKEI, "システム区分");
        exClassificationEquals((C_YoteikykymdKbn)MockObjectManager.getArgument(SetKisoKoumokuMockForSinkeiyaku.class, "setkykymdHantei", 0, 7), C_YoteikykymdKbn.AUTO, "予定契約日区分");

        exDateEquals((BizDate)MockObjectManager.getArgument(SetNenreiMockForSinkeiyaku.class, "exec", 0, 0), BizDate.valueOf(20180203), "基準日");
        exDateEquals((BizDate)MockObjectManager.getArgument(SetNenreiMockForSinkeiyaku.class, "exec", 0, 1), BizDate.valueOf(20010505), "生年月日");

    }

    @Test
    @Transactional
    @TestOrder(430)
    public void testExec_A43() {

        MockObjectManager.initialize();
        HanteiMoschkMockForSinkeiyaku.SYORIPTN = HanteiMoschkMockForSinkeiyaku.TESTPATTERN9;
        SetKisoKoumokuMockForSinkeiyaku.SYORIPTN = SetKisoKoumokuMockForSinkeiyaku.TESTPATTERN1;
        SetNenreiMockForSinkeiyaku.SYORIPTN = SetNenreiMockForSinkeiyaku.TESTPATTERN1;

        CheckHokenRyouYuukouKigen checkHokenRyouYuukouKigen = SWAKInjector.getInstance(CheckHokenRyouYuukouKigen.class);
        MosnaiCheckParam mosnaiCheckParam = SWAKInjector.getInstance(MosnaiCheckParam.class);

        sinkeiyakuDomManager.flush();
        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("791112626");
        List<HT_HubiMsg> hubiMsg = syoriCTL.getHubiMsgs();
        BM_SyouhnZokusei syouhnZokusei = bizDomManager.getSyouhnZokusei("ﾕｱ", 6);
        mosnaiCheckParam.setSyuSyouhnZokusei(syouhnZokusei);
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setSysDate(BizDate.valueOf("20160907"));
        mosnaiCheckParam.setListHubiMsg(hubiMsg);
        checkHokenRyouYuukouKigen.exec(mosnaiCheckParam);

        exNumericEquals(hubiMsg.size(), 0, "不備メッセージ件数");

        exDateEquals((BizDate)MockObjectManager.getArgument(SetKisoKoumokuMockForSinkeiyaku.class, "setkykymdHantei", 0, 2), null, "領収日");
        exDateEquals((BizDate)MockObjectManager.getArgument(SetKisoKoumokuMockForSinkeiyaku.class, "setkykymdHantei", 0, 3), BizDate.valueOf(20160701), "申込日");
        exDateEquals((BizDate)MockObjectManager.getArgument(SetKisoKoumokuMockForSinkeiyaku.class, "setkykymdHantei", 0, 4), BizDate.valueOf(20160701), "責任開始日");
        exDateEquals((BizDate)MockObjectManager.getArgument(SetKisoKoumokuMockForSinkeiyaku.class, "setkykymdHantei", 0, 5), BizDate.valueOf(20160701), "処理日");
        exClassificationEquals((C_SysKbn)MockObjectManager.getArgument(SetKisoKoumokuMockForSinkeiyaku.class, "setkykymdHantei", 0, 6), C_SysKbn.SKEI, "システム区分");
        exClassificationEquals((C_YoteikykymdKbn)MockObjectManager.getArgument(SetKisoKoumokuMockForSinkeiyaku.class, "setkykymdHantei", 0, 7), C_YoteikykymdKbn.AUTO, "予定契約日区分");

        exDateEquals((BizDate)MockObjectManager.getArgument(SetNenreiMockForSinkeiyaku.class, "exec", 0, 0), BizDate.valueOf(20180203), "基準日");
        exDateEquals((BizDate)MockObjectManager.getArgument(SetNenreiMockForSinkeiyaku.class, "exec", 0, 1), BizDate.valueOf(20010505), "生年月日");

    }

    @Test
    @Transactional
    @TestOrder(440)
    public void testExec_A44() {

        MockObjectManager.initialize();
        HanteiMoschkMockForSinkeiyaku.SYORIPTN = HanteiMoschkMockForSinkeiyaku.TESTPATTERN9;
        SetKisoKoumokuMockForSinkeiyaku.SYORIPTN = SetKisoKoumokuMockForSinkeiyaku.TESTPATTERN1;
        SetNenreiMockForSinkeiyaku.SYORIPTN = SetNenreiMockForSinkeiyaku.TESTPATTERN1;

        CheckHokenRyouYuukouKigen checkHokenRyouYuukouKigen = SWAKInjector.getInstance(CheckHokenRyouYuukouKigen.class);
        MosnaiCheckParam mosnaiCheckParam = SWAKInjector.getInstance(MosnaiCheckParam.class);

        sinkeiyakuDomManager.flush();
        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("791112634");
        List<HT_HubiMsg> hubiMsg = syoriCTL.getHubiMsgs();
        BM_SyouhnZokusei syouhnZokusei = bizDomManager.getSyouhnZokusei("ﾕｲ", 6);
        mosnaiCheckParam.setSyuSyouhnZokusei(syouhnZokusei);
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setSysDate(BizDate.valueOf("20160907"));
        mosnaiCheckParam.setListHubiMsg(hubiMsg);
        checkHokenRyouYuukouKigen.exec(mosnaiCheckParam);

        exNumericEquals(hubiMsg.size(), 0, "不備メッセージ件数");

        exDateEquals((BizDate)MockObjectManager.getArgument(SetKisoKoumokuMockForSinkeiyaku.class, "setkykymdHantei", 0, 2), null, "領収日");
        exDateEquals((BizDate)MockObjectManager.getArgument(SetKisoKoumokuMockForSinkeiyaku.class, "setkykymdHantei", 0, 3), BizDate.valueOf(20160701), "申込日");
        exDateEquals((BizDate)MockObjectManager.getArgument(SetKisoKoumokuMockForSinkeiyaku.class, "setkykymdHantei", 0, 4), BizDate.valueOf(20160701), "責任開始日");
        exDateEquals((BizDate)MockObjectManager.getArgument(SetKisoKoumokuMockForSinkeiyaku.class, "setkykymdHantei", 0, 5), BizDate.valueOf(20160701), "処理日");
        exClassificationEquals((C_SysKbn)MockObjectManager.getArgument(SetKisoKoumokuMockForSinkeiyaku.class, "setkykymdHantei", 0, 6), C_SysKbn.SKEI, "システム区分");
        exClassificationEquals((C_YoteikykymdKbn)MockObjectManager.getArgument(SetKisoKoumokuMockForSinkeiyaku.class, "setkykymdHantei", 0, 7), C_YoteikykymdKbn.AUTO, "予定契約日区分");

        exDateEquals((BizDate)MockObjectManager.getArgument(SetNenreiMockForSinkeiyaku.class, "exec", 0, 0), BizDate.valueOf(20180203), "基準日");
        exDateEquals((BizDate)MockObjectManager.getArgument(SetNenreiMockForSinkeiyaku.class, "exec", 0, 1), BizDate.valueOf(20010505), "生年月日");

    }

    @Test
    @Transactional
    @TestOrder(450)
    public void testExec_A45() {

        MockObjectManager.initialize();
        HanteiMoschkMockForSinkeiyaku.SYORIPTN = HanteiMoschkMockForSinkeiyaku.TESTPATTERN9;
        SetKisoKoumokuMockForSinkeiyaku.SYORIPTN = SetKisoKoumokuMockForSinkeiyaku.TESTPATTERN1;
        SetNenreiMockForSinkeiyaku.SYORIPTN = SetNenreiMockForSinkeiyaku.TESTPATTERN1;
        SetHubiMsgMockForSinkeiyaku.SYORIPTN = SetHubiMsgMockForSinkeiyaku.TESTPATTERN15;

        CheckHokenRyouYuukouKigen checkHokenRyouYuukouKigen = SWAKInjector.getInstance(CheckHokenRyouYuukouKigen.class);
        MosnaiCheckParam mosnaiCheckParam = SWAKInjector.getInstance(MosnaiCheckParam.class);

        sinkeiyakuDomManager.flush();
        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("791112642");
        List<HT_HubiMsg> hubiMsg = syoriCTL.getHubiMsgs();
        BM_SyouhnZokusei syouhnZokusei = bizDomManager.getSyouhnZokusei("ﾕA", 6);
        mosnaiCheckParam.setSyuSyouhnZokusei(syouhnZokusei);
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setSysDate(BizDate.valueOf("20160907"));
        mosnaiCheckParam.setListHubiMsg(hubiMsg);
        checkHokenRyouYuukouKigen.exec(mosnaiCheckParam);

        exNumericEquals(hubiMsg.size(), 1, "不備メッセージ件数");
        exStringEquals(hubiMsg.get(0).getHubimsg(), "５年ごと利差配当付指定通貨建終身保険（一時払い）　　５年　最低保証あり（米ドル）の積立利率が取得できません。申込日　20160701", "不備メッセージ");
        exStringEquals(hubiMsg.get(0).getMessageId(), "EHC1067", "メッセージＩＤ");
        exStringEquals(hubiMsg.get(0).getMosno(), "791112642", "申込番号");
        exNumericEquals(hubiMsg.get(0).getRenno(), 1, "連番");
        exClassificationEquals(hubiMsg.get(0).getHubisyubetukbn(), C_HubisyubetuKbn.KETHORYU_HUBI, "不備種別区分");
        exClassificationEquals(hubiMsg.get(0).getHubisyubetusyousaikbn(), C_HubisyubetusyousaiKbn.NONE, "不備種別詳細区分");

        exDateEquals((BizDate)MockObjectManager.getArgument(SetKisoKoumokuMockForSinkeiyaku.class, "setkykymdHantei", 0, 2), null, "領収日");
        exDateEquals((BizDate)MockObjectManager.getArgument(SetKisoKoumokuMockForSinkeiyaku.class, "setkykymdHantei", 0, 3), BizDate.valueOf(20160701), "申込日");
        exDateEquals((BizDate)MockObjectManager.getArgument(SetKisoKoumokuMockForSinkeiyaku.class, "setkykymdHantei", 0, 4), BizDate.valueOf(20160701), "責任開始日");
        exDateEquals((BizDate)MockObjectManager.getArgument(SetKisoKoumokuMockForSinkeiyaku.class, "setkykymdHantei", 0, 5), BizDate.valueOf(20160701), "処理日");
        exClassificationEquals((C_SysKbn)MockObjectManager.getArgument(SetKisoKoumokuMockForSinkeiyaku.class, "setkykymdHantei", 0, 6), C_SysKbn.SKEI, "システム区分");
        exClassificationEquals((C_YoteikykymdKbn)MockObjectManager.getArgument(SetKisoKoumokuMockForSinkeiyaku.class, "setkykymdHantei", 0, 7), C_YoteikykymdKbn.AUTO, "予定契約日区分");

        exDateEquals((BizDate)MockObjectManager.getArgument(SetNenreiMockForSinkeiyaku.class, "exec", 0, 0), BizDate.valueOf(20180203), "基準日");
        exDateEquals((BizDate)MockObjectManager.getArgument(SetNenreiMockForSinkeiyaku.class, "exec", 0, 1), BizDate.valueOf(20010505), "生年月日");

        exClassificationEquals((C_KetsrhkosKbn)MockObjectManager.getArgument(SetHubiMsgMockForSinkeiyaku.class, "exec", 0, 0), C_KetsrhkosKbn.KETHORYU_HUBI, "決定・成立保留更新区分");
        exClassificationEquals((C_SpKeisanKahiKbn)MockObjectManager.getArgument(SetHubiMsgMockForSinkeiyaku.class, "exec", 0, 1), C_SpKeisanKahiKbn.SPKEISANKA, "決定保留時ＳＰ計算可否区分");
        exClassificationEquals((C_HubisyubetusyousaiKbn)MockObjectManager.getArgument(SetHubiMsgMockForSinkeiyaku.class, "exec", 0, 2), C_HubisyubetusyousaiKbn.NONE, "不備種別詳細区分");
        exStringEquals((String)MockObjectManager.getArgument(SetHubiMsgMockForSinkeiyaku.class, "exec", 0, 3), "EHC1067 ５年ごと利差配当付指定通貨建終身保険（一時払い）　　５年　最低保証あり（米ドル）の積立利率が取得できません。申込日　20160701", "メッセージ文言");
        exClassificationEquals((C_TknKbn)MockObjectManager.getArgument(SetHubiMsgMockForSinkeiyaku.class, "exec", 0, 5), C_TknKbn.NONE, "特認区分");
        exClassificationEquals((C_MsgKbn)MockObjectManager.getArgument(SetHubiMsgMockForSinkeiyaku.class, "exec", 0, 6), C_MsgKbn.ERROR, "メッセージ区分");

    }

    @Test
    @Transactional
    @TestOrder(460)
    public void testExec_A46() {

        MockObjectManager.initialize();
        HanteiMoschkMockForSinkeiyaku.SYORIPTN = HanteiMoschkMockForSinkeiyaku.TESTPATTERN9;
        SetKisoKoumokuMockForSinkeiyaku.SYORIPTN = SetKisoKoumokuMockForSinkeiyaku.TESTPATTERN1;
        SetNenreiMockForSinkeiyaku.SYORIPTN = SetNenreiMockForSinkeiyaku.TESTPATTERN1;
        SetHubiMsgMockForSinkeiyaku.SYORIPTN = SetHubiMsgMockForSinkeiyaku.TESTPATTERN16;

        CheckHokenRyouYuukouKigen checkHokenRyouYuukouKigen = SWAKInjector.getInstance(CheckHokenRyouYuukouKigen.class);
        MosnaiCheckParam mosnaiCheckParam = SWAKInjector.getInstance(MosnaiCheckParam.class);

        sinkeiyakuDomManager.flush();
        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("791112659");
        List<HT_HubiMsg> hubiMsg = syoriCTL.getHubiMsgs();
        BM_SyouhnZokusei syouhnZokusei = bizDomManager.getSyouhnZokusei("ﾕｴ", 6);
        mosnaiCheckParam.setSyuSyouhnZokusei(syouhnZokusei);
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setSysDate(BizDate.valueOf("20160907"));
        mosnaiCheckParam.setListHubiMsg(hubiMsg);
        checkHokenRyouYuukouKigen.exec(mosnaiCheckParam);

        exNumericEquals(hubiMsg.size(), 1, "不備メッセージ件数");
        exStringEquals(hubiMsg.get(0).getHubimsg(), "設定倍率が申込時点から上昇しています。申込日　0.70倍　契約日　0.80倍", "不備メッセージ");
        exStringEquals(hubiMsg.get(0).getMessageId(), "EHC1070", "メッセージＩＤ");
        exStringEquals(hubiMsg.get(0).getMosno(), "791112659", "申込番号");
        exNumericEquals(hubiMsg.get(0).getRenno(), 1, "連番");
        exClassificationEquals(hubiMsg.get(0).getHubisyubetukbn(), C_HubisyubetuKbn.KETHORYU_HUBI, "不備種別区分");
        exClassificationEquals(hubiMsg.get(0).getHubisyubetusyousaikbn(), C_HubisyubetusyousaiKbn.NONE, "不備種別詳細区分");

        exDateEquals((BizDate)MockObjectManager.getArgument(SetKisoKoumokuMockForSinkeiyaku.class, "setkykymdHantei", 0, 2), null, "領収日");
        exDateEquals((BizDate)MockObjectManager.getArgument(SetKisoKoumokuMockForSinkeiyaku.class, "setkykymdHantei", 0, 3), BizDate.valueOf(20160701), "申込日");
        exDateEquals((BizDate)MockObjectManager.getArgument(SetKisoKoumokuMockForSinkeiyaku.class, "setkykymdHantei", 0, 4), BizDate.valueOf(20160701), "責任開始日");
        exDateEquals((BizDate)MockObjectManager.getArgument(SetKisoKoumokuMockForSinkeiyaku.class, "setkykymdHantei", 0, 5), BizDate.valueOf(20160701), "処理日");
        exClassificationEquals((C_SysKbn)MockObjectManager.getArgument(SetKisoKoumokuMockForSinkeiyaku.class, "setkykymdHantei", 0, 6), C_SysKbn.SKEI, "システム区分");
        exClassificationEquals((C_YoteikykymdKbn)MockObjectManager.getArgument(SetKisoKoumokuMockForSinkeiyaku.class, "setkykymdHantei", 0, 7), C_YoteikykymdKbn.AUTO, "予定契約日区分");

        exDateEquals((BizDate)MockObjectManager.getArgument(SetNenreiMockForSinkeiyaku.class, "exec", 0, 0), BizDate.valueOf(20180203), "基準日");
        exDateEquals((BizDate)MockObjectManager.getArgument(SetNenreiMockForSinkeiyaku.class, "exec", 0, 1), BizDate.valueOf(20010505), "生年月日");

        exClassificationEquals((C_KetsrhkosKbn)MockObjectManager.getArgument(SetHubiMsgMockForSinkeiyaku.class, "exec", 0, 0), C_KetsrhkosKbn.KETHORYU_HUBI, "決定・成立保留更新区分");
        exClassificationEquals((C_SpKeisanKahiKbn)MockObjectManager.getArgument(SetHubiMsgMockForSinkeiyaku.class, "exec", 0, 1), C_SpKeisanKahiKbn.SPKEISANKA, "決定保留時ＳＰ計算可否区分");
        exClassificationEquals((C_HubisyubetusyousaiKbn)MockObjectManager.getArgument(SetHubiMsgMockForSinkeiyaku.class, "exec", 0, 2), C_HubisyubetusyousaiKbn.NONE, "不備種別詳細区分");
        exStringEquals((String)MockObjectManager.getArgument(SetHubiMsgMockForSinkeiyaku.class, "exec", 0, 3), "EHC1070 設定倍率が申込時点から上昇しています。申込日　0.70倍　契約日　0.80倍", "メッセージ文言");
        exClassificationEquals((C_TknKbn)MockObjectManager.getArgument(SetHubiMsgMockForSinkeiyaku.class, "exec", 0, 5), C_TknKbn.KANOU, "特認区分");
        exClassificationEquals((C_MsgKbn)MockObjectManager.getArgument(SetHubiMsgMockForSinkeiyaku.class, "exec", 0, 6), C_MsgKbn.ERROR, "メッセージ区分");

    }

    @Test
    @Transactional
    @TestOrder(470)
    public void testExec_A47() {

        MockObjectManager.initialize();
        HanteiMoschkMockForSinkeiyaku.SYORIPTN = HanteiMoschkMockForSinkeiyaku.TESTPATTERN9;
        SetKisoKoumokuMockForSinkeiyaku.SYORIPTN = SetKisoKoumokuMockForSinkeiyaku.TESTPATTERN1;
        SetNenreiMockForSinkeiyaku.SYORIPTN = SetNenreiMockForSinkeiyaku.TESTPATTERN1;

        CheckHokenRyouYuukouKigen checkHokenRyouYuukouKigen = SWAKInjector.getInstance(CheckHokenRyouYuukouKigen.class);
        MosnaiCheckParam mosnaiCheckParam = SWAKInjector.getInstance(MosnaiCheckParam.class);

        sinkeiyakuDomManager.flush();
        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("791112667");
        List<HT_HubiMsg> hubiMsg = syoriCTL.getHubiMsgs();
        BM_SyouhnZokusei syouhnZokusei = bizDomManager.getSyouhnZokusei("ﾕｵ", 6);
        mosnaiCheckParam.setSyuSyouhnZokusei(syouhnZokusei);
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setSysDate(BizDate.valueOf("20160907"));
        mosnaiCheckParam.setListHubiMsg(hubiMsg);
        checkHokenRyouYuukouKigen.exec(mosnaiCheckParam);

        exNumericEquals(hubiMsg.size(), 0, "不備メッセージ件数");

        exDateEquals((BizDate)MockObjectManager.getArgument(SetKisoKoumokuMockForSinkeiyaku.class, "setkykymdHantei", 0, 2), null, "領収日");
        exDateEquals((BizDate)MockObjectManager.getArgument(SetKisoKoumokuMockForSinkeiyaku.class, "setkykymdHantei", 0, 3), BizDate.valueOf(20160701), "申込日");
        exDateEquals((BizDate)MockObjectManager.getArgument(SetKisoKoumokuMockForSinkeiyaku.class, "setkykymdHantei", 0, 4), BizDate.valueOf(20160701), "責任開始日");
        exDateEquals((BizDate)MockObjectManager.getArgument(SetKisoKoumokuMockForSinkeiyaku.class, "setkykymdHantei", 0, 5), BizDate.valueOf(20160701), "処理日");
        exClassificationEquals((C_SysKbn)MockObjectManager.getArgument(SetKisoKoumokuMockForSinkeiyaku.class, "setkykymdHantei", 0, 6), C_SysKbn.SKEI, "システム区分");
        exClassificationEquals((C_YoteikykymdKbn)MockObjectManager.getArgument(SetKisoKoumokuMockForSinkeiyaku.class, "setkykymdHantei", 0, 7), C_YoteikykymdKbn.AUTO, "予定契約日区分");

        exDateEquals((BizDate)MockObjectManager.getArgument(SetNenreiMockForSinkeiyaku.class, "exec", 0, 0), BizDate.valueOf(20180203), "基準日");
        exDateEquals((BizDate)MockObjectManager.getArgument(SetNenreiMockForSinkeiyaku.class, "exec", 0, 1), BizDate.valueOf(20010505), "生年月日");

    }

    @Test
    @Transactional
    @TestOrder(480)
    public void testExec_A48() {

        MockObjectManager.initialize();
        HanteiMoschkMockForSinkeiyaku.SYORIPTN = HanteiMoschkMockForSinkeiyaku.TESTPATTERN9;
        SetKisoKoumokuMockForSinkeiyaku.SYORIPTN = SetKisoKoumokuMockForSinkeiyaku.TESTPATTERN1;
        SetNenreiMockForSinkeiyaku.SYORIPTN = SetNenreiMockForSinkeiyaku.TESTPATTERN1;
        EditPdfYoteirirtuMockForSinkeiyaku.SYORIPTN = EditPdfYoteirirtuMockForSinkeiyaku.TESTPATTERN1;
        SetHubiMsgMockForSinkeiyaku.SYORIPTN = SetHubiMsgMockForSinkeiyaku.TESTPATTERN17;

        CheckHokenRyouYuukouKigen checkHokenRyouYuukouKigen = SWAKInjector.getInstance(CheckHokenRyouYuukouKigen.class);
        MosnaiCheckParam mosnaiCheckParam = SWAKInjector.getInstance(MosnaiCheckParam.class);

        sinkeiyakuDomManager.flush();
        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("791112675");
        List<HT_HubiMsg> hubiMsg = syoriCTL.getHubiMsgs();
        BM_SyouhnZokusei syouhnZokusei = bizDomManager.getSyouhnZokusei("ﾕｶ", 6);
        mosnaiCheckParam.setSyuSyouhnZokusei(syouhnZokusei);
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setSysDate(BizDate.valueOf("20160907"));
        mosnaiCheckParam.setListHubiMsg(hubiMsg);
        checkHokenRyouYuukouKigen.exec(mosnaiCheckParam);

        exNumericEquals(hubiMsg.size(), 1, "不備メッセージ件数");
        exStringEquals(hubiMsg.get(0).getHubimsg(), "設定倍率が申込時点から低下しています。申込日　0.90倍　契約日　0.80倍", "不備メッセージ");
        exStringEquals(hubiMsg.get(0).getMessageId(), "EHC1073", "メッセージＩＤ");
        exStringEquals(hubiMsg.get(0).getMosno(), "791112675", "申込番号");
        exNumericEquals(hubiMsg.get(0).getRenno(), 1, "連番");
        exClassificationEquals(hubiMsg.get(0).getHubisyubetukbn(), C_HubisyubetuKbn.KETHORYU_HUBI, "不備種別区分");
        exClassificationEquals(hubiMsg.get(0).getHubisyubetusyousaikbn(), C_HubisyubetusyousaiKbn.NONE, "不備種別詳細区分");

        exDateEquals((BizDate)MockObjectManager.getArgument(SetKisoKoumokuMockForSinkeiyaku.class, "setkykymdHantei", 0, 2), null, "領収日");
        exDateEquals((BizDate)MockObjectManager.getArgument(SetKisoKoumokuMockForSinkeiyaku.class, "setkykymdHantei", 0, 3), BizDate.valueOf(20160701), "申込日");
        exDateEquals((BizDate)MockObjectManager.getArgument(SetKisoKoumokuMockForSinkeiyaku.class, "setkykymdHantei", 0, 4), BizDate.valueOf(20160701), "責任開始日");
        exDateEquals((BizDate)MockObjectManager.getArgument(SetKisoKoumokuMockForSinkeiyaku.class, "setkykymdHantei", 0, 5), BizDate.valueOf(20160701), "処理日");
        exClassificationEquals((C_SysKbn)MockObjectManager.getArgument(SetKisoKoumokuMockForSinkeiyaku.class, "setkykymdHantei", 0, 6), C_SysKbn.SKEI, "システム区分");
        exClassificationEquals((C_YoteikykymdKbn)MockObjectManager.getArgument(SetKisoKoumokuMockForSinkeiyaku.class, "setkykymdHantei", 0, 7), C_YoteikykymdKbn.AUTO, "予定契約日区分");

        exDateEquals((BizDate)MockObjectManager.getArgument(SetNenreiMockForSinkeiyaku.class, "exec", 0, 0), BizDate.valueOf(20180203), "基準日");
        exDateEquals((BizDate)MockObjectManager.getArgument(SetNenreiMockForSinkeiyaku.class, "exec", 0, 1), BizDate.valueOf(20010505), "生年月日");

        exBizCalcbleEquals((BizNumber)MockObjectManager.getArgument(EditPdfYoteirirtuMockForSinkeiyaku.class, "exec", 0, 1), BizNumber.valueOf(0), "申込日予定利率");
        exBizCalcbleEquals((BizNumber)MockObjectManager.getArgument(EditPdfYoteirirtuMockForSinkeiyaku.class, "exec", 0, 2), BizNumber.valueOf(0), "契約日予定利率");
        exClassificationEquals((C_UmuKbn)MockObjectManager.getArgument(EditPdfYoteirirtuMockForSinkeiyaku.class, "exec", 0, 3), C_UmuKbn.NONE, "予定利率変動有無");
        exBizCalcbleEquals((BizNumber)MockObjectManager.getArgument(EditPdfYoteirirtuMockForSinkeiyaku.class, "exec", 0, 4), BizNumber.valueOf(0), "申込日積立利率");
        exBizCalcbleEquals((BizNumber)MockObjectManager.getArgument(EditPdfYoteirirtuMockForSinkeiyaku.class, "exec", 0, 5), BizNumber.valueOf(0), "契約日積立利率");
        exBizCalcbleEquals((BizNumber)MockObjectManager.getArgument(EditPdfYoteirirtuMockForSinkeiyaku.class, "exec", 0, 6), BizNumber.valueOf(45), "申込日ローディング変更後積立利率");
        exBizCalcbleEquals((BizNumber)MockObjectManager.getArgument(EditPdfYoteirirtuMockForSinkeiyaku.class, "exec", 0, 7), BizNumber.valueOf(80), "契約日ローディング変更後積立利率");
        exClassificationEquals((C_UmuKbn)MockObjectManager.getArgument(EditPdfYoteirirtuMockForSinkeiyaku.class, "exec", 0, 8), C_UmuKbn.NONE, "積立利率変動有無");
        exBizCalcbleEquals((BizNumber)MockObjectManager.getArgument(EditPdfYoteirirtuMockForSinkeiyaku.class, "exec", 0, 9), BizNumber.valueOf(0), "申込日積立金増加率上限");
        exBizCalcbleEquals((BizNumber)MockObjectManager.getArgument(EditPdfYoteirirtuMockForSinkeiyaku.class, "exec", 0, 10), BizNumber.valueOf(0), "契約日積立金増加率上限");
        exClassificationEquals((C_UmuKbn)MockObjectManager.getArgument(EditPdfYoteirirtuMockForSinkeiyaku.class, "exec", 0, 11), C_UmuKbn.NONE, "積立金増加率上限変動有無");
        exBizCalcbleEquals((BizNumber)MockObjectManager.getArgument(EditPdfYoteirirtuMockForSinkeiyaku.class, "exec", 0, 12), BizNumber.valueOf(0.9), "申込日設定倍率");
        exBizCalcbleEquals((BizNumber)MockObjectManager.getArgument(EditPdfYoteirirtuMockForSinkeiyaku.class, "exec", 0,13), BizNumber.valueOf(0.8), "契約日設定倍率");
        exClassificationEquals((C_UmuKbn)MockObjectManager.getArgument(EditPdfYoteirirtuMockForSinkeiyaku.class, "exec", 0, 14), C_UmuKbn.ARI, "設定倍率変動有無");
        exBizCalcbleEquals((BizNumber)MockObjectManager.getArgument(EditPdfYoteirirtuMockForSinkeiyaku.class, "exec", 0, 15), BizNumber.valueOf(90), "申込日連動率");
        exBizCalcbleEquals((BizNumber)MockObjectManager.getArgument(EditPdfYoteirirtuMockForSinkeiyaku.class, "exec", 0,16), BizNumber.valueOf(0), "契約日連動率");
        exClassificationEquals((C_UmuKbn)MockObjectManager.getArgument(EditPdfYoteirirtuMockForSinkeiyaku.class, "exec", 0, 17), C_UmuKbn.NONE, "連動率変動有無");

        exClassificationEquals((C_KetsrhkosKbn)MockObjectManager.getArgument(SetHubiMsgMockForSinkeiyaku.class, "exec", 0, 0), C_KetsrhkosKbn.KETHORYU_HUBI, "決定・成立保留更新区分");
        exClassificationEquals((C_SpKeisanKahiKbn)MockObjectManager.getArgument(SetHubiMsgMockForSinkeiyaku.class, "exec", 0, 1), C_SpKeisanKahiKbn.SPKEISANKA, "決定保留時ＳＰ計算可否区分");
        exClassificationEquals((C_HubisyubetusyousaiKbn)MockObjectManager.getArgument(SetHubiMsgMockForSinkeiyaku.class, "exec", 0, 2), C_HubisyubetusyousaiKbn.NONE, "不備種別詳細区分");
        exStringEquals((String)MockObjectManager.getArgument(SetHubiMsgMockForSinkeiyaku.class, "exec", 0, 3), "EHC1073 設定倍率が申込時点から低下しています。申込日　0.90倍　契約日　0.80倍", "メッセージ文言");
        exClassificationEquals((C_TknKbn)MockObjectManager.getArgument(SetHubiMsgMockForSinkeiyaku.class, "exec", 0, 5), C_TknKbn.SUMI, "特認区分");
        exClassificationEquals((C_MsgKbn)MockObjectManager.getArgument(SetHubiMsgMockForSinkeiyaku.class, "exec", 0, 6), C_MsgKbn.ERROR, "メッセージ区分");


    }

    @Test
    @Transactional
    @TestOrder(490)
    public void testExec_A49() {

        MockObjectManager.initialize();
        HanteiMoschkMockForSinkeiyaku.SYORIPTN = HanteiMoschkMockForSinkeiyaku.TESTPATTERN9;
        SetKisoKoumokuMockForSinkeiyaku.SYORIPTN = SetKisoKoumokuMockForSinkeiyaku.TESTPATTERN1;
        SetNenreiMockForSinkeiyaku.SYORIPTN = SetNenreiMockForSinkeiyaku.TESTPATTERN1;

        CheckHokenRyouYuukouKigen checkHokenRyouYuukouKigen = SWAKInjector.getInstance(CheckHokenRyouYuukouKigen.class);
        MosnaiCheckParam mosnaiCheckParam = SWAKInjector.getInstance(MosnaiCheckParam.class);

        sinkeiyakuDomManager.flush();
        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("791112683");
        List<HT_HubiMsg> hubiMsg = syoriCTL.getHubiMsgs();
        BM_SyouhnZokusei syouhnZokusei = bizDomManager.getSyouhnZokusei("ﾕｷ", 6);
        mosnaiCheckParam.setSyuSyouhnZokusei(syouhnZokusei);
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setSysDate(BizDate.valueOf("20160907"));
        mosnaiCheckParam.setListHubiMsg(hubiMsg);
        checkHokenRyouYuukouKigen.exec(mosnaiCheckParam);

        exNumericEquals(hubiMsg.size(), 0, "不備メッセージ件数");

        exDateEquals((BizDate)MockObjectManager.getArgument(SetKisoKoumokuMockForSinkeiyaku.class, "setkykymdHantei", 0, 2), null, "領収日");
        exDateEquals((BizDate)MockObjectManager.getArgument(SetKisoKoumokuMockForSinkeiyaku.class, "setkykymdHantei", 0, 3), BizDate.valueOf(20160701), "申込日");
        exDateEquals((BizDate)MockObjectManager.getArgument(SetKisoKoumokuMockForSinkeiyaku.class, "setkykymdHantei", 0, 4), BizDate.valueOf(20160701), "責任開始日");
        exDateEquals((BizDate)MockObjectManager.getArgument(SetKisoKoumokuMockForSinkeiyaku.class, "setkykymdHantei", 0, 5), BizDate.valueOf(20160701), "処理日");
        exClassificationEquals((C_SysKbn)MockObjectManager.getArgument(SetKisoKoumokuMockForSinkeiyaku.class, "setkykymdHantei", 0, 6), C_SysKbn.SKEI, "システム区分");
        exClassificationEquals((C_YoteikykymdKbn)MockObjectManager.getArgument(SetKisoKoumokuMockForSinkeiyaku.class, "setkykymdHantei", 0, 7), C_YoteikykymdKbn.AUTO, "予定契約日区分");

        exDateEquals((BizDate)MockObjectManager.getArgument(SetNenreiMockForSinkeiyaku.class, "exec", 0, 0), BizDate.valueOf(20180203), "基準日");
        exDateEquals((BizDate)MockObjectManager.getArgument(SetNenreiMockForSinkeiyaku.class, "exec", 0, 1), BizDate.valueOf(20010505), "生年月日");

    }

    @Test
    @Transactional
    @TestOrder(500)
    public void testExec_A50() {

        MockObjectManager.initialize();
        HanteiMoschkMockForSinkeiyaku.SYORIPTN = HanteiMoschkMockForSinkeiyaku.TESTPATTERN5;
        SetKisoKoumokuMockForSinkeiyaku.SYORIPTN = SetKisoKoumokuMockForSinkeiyaku.TESTPATTERN5;

        CheckHokenRyouYuukouKigen checkHokenRyouYuukouKigen = SWAKInjector.getInstance(CheckHokenRyouYuukouKigen.class);
        MosnaiCheckParam mosnaiCheckParam = SWAKInjector.getInstance(MosnaiCheckParam.class);

        sinkeiyakuDomManager.flush();
        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("790111306");
        List<HT_HubiMsg> hubiMsg = syoriCTL.getHubiMsgs();
        BM_SyouhnZokusei syouhnZokusei = bizDomManager.getSyouhnZokusei("ﾕｷ", 7);
        mosnaiCheckParam.setSyuSyouhnZokusei(syouhnZokusei);
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setSysDate(BizDate.valueOf("20160907"));
        mosnaiCheckParam.setListHubiMsg(hubiMsg);
        checkHokenRyouYuukouKigen.exec(mosnaiCheckParam);

        exNumericEquals(hubiMsg.size(), 0, "不備メッセージ件数");

        exDateEquals((BizDate)MockObjectManager.getArgument(SetKisoKoumokuMockForSinkeiyaku.class, "setkykymdHantei", 0, 2), null, "領収日");
        exDateEquals((BizDate)MockObjectManager.getArgument(SetKisoKoumokuMockForSinkeiyaku.class, "setkykymdHantei", 0, 3), BizDate.valueOf(20160701), "申込日");
        exDateEquals((BizDate)MockObjectManager.getArgument(SetKisoKoumokuMockForSinkeiyaku.class, "setkykymdHantei", 0, 4), BizDate.valueOf(20160701), "責任開始日");
        exDateEquals((BizDate)MockObjectManager.getArgument(SetKisoKoumokuMockForSinkeiyaku.class, "setkykymdHantei", 0, 5), BizDate.valueOf(20160701), "処理日");
        exClassificationEquals((C_SysKbn)MockObjectManager.getArgument(SetKisoKoumokuMockForSinkeiyaku.class, "setkykymdHantei", 0, 6), C_SysKbn.SKEI, "システム区分");
        exClassificationEquals((C_YoteikykymdKbn)MockObjectManager.getArgument(SetKisoKoumokuMockForSinkeiyaku.class, "setkykymdHantei", 0, 7), C_YoteikykymdKbn.AUTO, "予定契約日区分");

        exDateEquals((BizDate)MockObjectManager.getArgument(SetKisoKoumokuMockForSinkeiyaku.class, "setkykymdHantei", 1, 2), null, "領収日");
        exDateEquals((BizDate)MockObjectManager.getArgument(SetKisoKoumokuMockForSinkeiyaku.class, "setkykymdHantei", 1, 3), BizDate.valueOf(20160907), "申込日");
        exDateEquals((BizDate)MockObjectManager.getArgument(SetKisoKoumokuMockForSinkeiyaku.class, "setkykymdHantei", 1, 4), BizDate.valueOf(20160907), "責任開始日");
        exDateEquals((BizDate)MockObjectManager.getArgument(SetKisoKoumokuMockForSinkeiyaku.class, "setkykymdHantei", 1, 5), BizDate.valueOf(20160907), "処理日");
        exClassificationEquals((C_SysKbn)MockObjectManager.getArgument(SetKisoKoumokuMockForSinkeiyaku.class, "setkykymdHantei", 0, 6), C_SysKbn.SKEI, "システム区分");
        exClassificationEquals((C_YoteikykymdKbn)MockObjectManager.getArgument(SetKisoKoumokuMockForSinkeiyaku.class, "setkykymdHantei", 0, 7), C_YoteikykymdKbn.AUTO, "予定契約日区分");
    }

    @Test
    @Transactional
    @TestOrder(510)
    public void testExec_A51() {

        MockObjectManager.initialize();
        HanteiMoschkMockForSinkeiyaku.SYORIPTN = HanteiMoschkMockForSinkeiyaku.TESTPATTERN5;
        SetKisoKoumokuMockForSinkeiyaku.SYORIPTN = SetKisoKoumokuMockForSinkeiyaku.TESTPATTERN9;

        CheckHokenRyouYuukouKigen checkHokenRyouYuukouKigen = SWAKInjector.getInstance(CheckHokenRyouYuukouKigen.class);
        MosnaiCheckParam mosnaiCheckParam = SWAKInjector.getInstance(MosnaiCheckParam.class);

        sinkeiyakuDomManager.flush();
        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("790111314");
        List<HT_HubiMsg> hubiMsg = syoriCTL.getHubiMsgs();
        BM_SyouhnZokusei syouhnZokusei = bizDomManager.getSyouhnZokusei("ﾕｷ", 8);
        mosnaiCheckParam.setSyuSyouhnZokusei(syouhnZokusei);
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setSysDate(BizDate.valueOf("20160907"));
        mosnaiCheckParam.setListHubiMsg(hubiMsg);
        checkHokenRyouYuukouKigen.exec(mosnaiCheckParam);

        exNumericEquals(hubiMsg.size(), 0, "不備メッセージ件数");

        exDateEquals((BizDate)MockObjectManager.getArgument(SetKisoKoumokuMockForSinkeiyaku.class, "setkykymdHantei", 0, 2), null, "領収日");
        exDateEquals((BizDate)MockObjectManager.getArgument(SetKisoKoumokuMockForSinkeiyaku.class, "setkykymdHantei", 0, 3), BizDate.valueOf(20160701), "申込日");
        exDateEquals((BizDate)MockObjectManager.getArgument(SetKisoKoumokuMockForSinkeiyaku.class, "setkykymdHantei", 0, 4), BizDate.valueOf(20160701), "責任開始日");
        exDateEquals((BizDate)MockObjectManager.getArgument(SetKisoKoumokuMockForSinkeiyaku.class, "setkykymdHantei", 0, 5), BizDate.valueOf(20160701), "処理日");
        exClassificationEquals((C_SysKbn)MockObjectManager.getArgument(SetKisoKoumokuMockForSinkeiyaku.class, "setkykymdHantei", 0, 6), C_SysKbn.SKEI, "システム区分");
        exClassificationEquals((C_YoteikykymdKbn)MockObjectManager.getArgument(SetKisoKoumokuMockForSinkeiyaku.class, "setkykymdHantei", 0, 7), C_YoteikykymdKbn.AUTO, "予定契約日区分");

        exDateEquals((BizDate)MockObjectManager.getArgument(SetKisoKoumokuMockForSinkeiyaku.class, "setkykymdHantei", 1, 2), null, "領収日");
        exDateEquals((BizDate)MockObjectManager.getArgument(SetKisoKoumokuMockForSinkeiyaku.class, "setkykymdHantei", 1, 3), BizDate.valueOf(20160907), "申込日");
        exDateEquals((BizDate)MockObjectManager.getArgument(SetKisoKoumokuMockForSinkeiyaku.class, "setkykymdHantei", 1, 4), BizDate.valueOf(20160907), "責任開始日");
        exDateEquals((BizDate)MockObjectManager.getArgument(SetKisoKoumokuMockForSinkeiyaku.class, "setkykymdHantei", 1, 5), BizDate.valueOf(20160907), "処理日");
        exClassificationEquals((C_SysKbn)MockObjectManager.getArgument(SetKisoKoumokuMockForSinkeiyaku.class, "setkykymdHantei", 0, 6), C_SysKbn.SKEI, "システム区分");
        exClassificationEquals((C_YoteikykymdKbn)MockObjectManager.getArgument(SetKisoKoumokuMockForSinkeiyaku.class, "setkykymdHantei", 0, 7), C_YoteikykymdKbn.AUTO, "予定契約日区分");
    }


    @Test
    @Transactional
    @TestOrder(520)
    public void testExec_A52() {

        MockObjectManager.initialize();
        HanteiMoschkMockForSinkeiyaku.SYORIPTN = HanteiMoschkMockForSinkeiyaku.TESTPATTERN4;
        SetKisoKoumokuMockForSinkeiyaku.SYORIPTN = SetKisoKoumokuMockForSinkeiyaku.TESTPATTERN10;
        SetNenreiMockForSinkeiyaku.SYORIPTN = SetNenreiMockForSinkeiyaku.TESTPATTERN1;
        SetHubiMsgMockForSinkeiyaku.SYORIPTN = null;

        CheckHokenRyouYuukouKigen checkHokenRyouYuukouKigen = SWAKInjector.getInstance(CheckHokenRyouYuukouKigen.class);
        MosnaiCheckParam mosnaiCheckParam = SWAKInjector.getInstance(MosnaiCheckParam.class);

        sinkeiyakuDomManager.flush();
        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("860000017");
        BM_SyouhnZokusei syouhnZokusei = bizDomManager.getSyouhnZokusei("ﾕｸ", 1);
        mosnaiCheckParam.setSyuSyouhnZokusei(syouhnZokusei);
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setSysDate(BizDate.valueOf("20160907"));
        mosnaiCheckParam.setListHubiMsg(new ArrayList<HT_HubiMsg>());
        checkHokenRyouYuukouKigen.exec(mosnaiCheckParam);

        List<HT_HubiMsg> hubiMsg = mosnaiCheckParam.getListHubiMsg();

        exNumericEquals(hubiMsg.size(), 1, "不備メッセージ件数");
        exStringEquals(hubiMsg.get(0).getMosno(), "860000017", "申込番号");
        exNumericEquals(hubiMsg.get(0).getRenno(), 1, "連番");
        exStringEquals(hubiMsg.get(0).getMessageId(), "WHC1015", "メッセージＩＤ");
        exStringEquals(hubiMsg.get(0).getHubimsg(), "６月４日までに責任開始しない場合、契約年齢範囲外となります。", "不備メッセージ");
        exClassificationEquals(hubiMsg.get(0).getHubisyubetukbn(), C_HubisyubetuKbn.WARNING, "不備種別区分");
        exClassificationEquals(hubiMsg.get(0).getHubisyubetusyousaikbn(), C_HubisyubetusyousaiKbn.NONE, "不備種別詳細区分");
    }

    @Test
    @Transactional
    @TestOrder(530)
    public void testExec_A53() {

        MockObjectManager.initialize();
        HanteiMoschkMockForSinkeiyaku.SYORIPTN = HanteiMoschkMockForSinkeiyaku.TESTPATTERN4;
        SetKisoKoumokuMockForSinkeiyaku.SYORIPTN = SetKisoKoumokuMockForSinkeiyaku.TESTPATTERN11;
        SetNenreiMockForSinkeiyaku.SYORIPTN = SetNenreiMockForSinkeiyaku.TESTPATTERN1;
        SetHubiMsgMockForSinkeiyaku.SYORIPTN = null;

        CheckHokenRyouYuukouKigen checkHokenRyouYuukouKigen = SWAKInjector.getInstance(CheckHokenRyouYuukouKigen.class);
        MosnaiCheckParam mosnaiCheckParam = SWAKInjector.getInstance(MosnaiCheckParam.class);

        sinkeiyakuDomManager.flush();
        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("860000025");
        BM_SyouhnZokusei syouhnZokusei = bizDomManager.getSyouhnZokusei("ﾕｸ", 1);
        mosnaiCheckParam.setSyuSyouhnZokusei(syouhnZokusei);
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setSysDate(BizDate.valueOf("20160907"));
        mosnaiCheckParam.setListHubiMsg(new ArrayList<HT_HubiMsg>());
        checkHokenRyouYuukouKigen.exec(mosnaiCheckParam);

        List<HT_HubiMsg> hubiMsg = mosnaiCheckParam.getListHubiMsg();

        exNumericEquals(hubiMsg.size(), 1, "不備メッセージ件数");
        exStringEquals(hubiMsg.get(0).getMosno(), "860000025", "申込番号");
        exNumericEquals(hubiMsg.get(0).getRenno(), 1, "連番");
        exStringEquals(hubiMsg.get(0).getMessageId(), "WHC1015", "メッセージＩＤ");
        exStringEquals(hubiMsg.get(0).getHubimsg(), "６月４日までに責任開始しない場合、契約年齢範囲外となります。", "不備メッセージ");
        exClassificationEquals(hubiMsg.get(0).getHubisyubetukbn(), C_HubisyubetuKbn.WARNING, "不備種別区分");
        exClassificationEquals(hubiMsg.get(0).getHubisyubetusyousaikbn(), C_HubisyubetusyousaiKbn.NONE, "不備種別詳細区分");
    }

    @Test
    @Transactional
    @TestOrder(540)
    public void testExec_A54() {

        MockObjectManager.initialize();
        HanteiMoschkMockForSinkeiyaku.SYORIPTN = HanteiMoschkMockForSinkeiyaku.TESTPATTERN4;
        SetKisoKoumokuMockForSinkeiyaku.SYORIPTN = SetKisoKoumokuMockForSinkeiyaku.TESTPATTERN12;
        SetNenreiMockForSinkeiyaku.SYORIPTN = SetNenreiMockForSinkeiyaku.TESTPATTERN1;
        SetHubiMsgMockForSinkeiyaku.SYORIPTN = null;

        CheckHokenRyouYuukouKigen checkHokenRyouYuukouKigen = SWAKInjector.getInstance(CheckHokenRyouYuukouKigen.class);
        MosnaiCheckParam mosnaiCheckParam = SWAKInjector.getInstance(MosnaiCheckParam.class);

        sinkeiyakuDomManager.flush();
        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("860000033");
        BM_SyouhnZokusei syouhnZokusei = bizDomManager.getSyouhnZokusei("ﾕｸ", 1);
        mosnaiCheckParam.setSyuSyouhnZokusei(syouhnZokusei);
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setSysDate(BizDate.valueOf("20160907"));
        mosnaiCheckParam.setListHubiMsg(new ArrayList<HT_HubiMsg>());
        checkHokenRyouYuukouKigen.exec(mosnaiCheckParam);

        List<HT_HubiMsg> hubiMsg = mosnaiCheckParam.getListHubiMsg();

        exNumericEquals(hubiMsg.size(), 1, "不備メッセージ件数");
        exStringEquals(hubiMsg.get(0).getMosno(), "860000033", "申込番号");
        exNumericEquals(hubiMsg.get(0).getRenno(), 1, "連番");
        exStringEquals(hubiMsg.get(0).getMessageId(), "WHC1015", "メッセージＩＤ");
        exStringEquals(hubiMsg.get(0).getHubimsg(), "６月４日までに責任開始しない場合、契約年齢範囲外となります。", "不備メッセージ");
        exClassificationEquals(hubiMsg.get(0).getHubisyubetukbn(), C_HubisyubetuKbn.WARNING, "不備種別区分");
        exClassificationEquals(hubiMsg.get(0).getHubisyubetusyousaikbn(), C_HubisyubetusyousaiKbn.NONE, "不備種別詳細区分");

    }

    @Test
    @Transactional
    @TestOrder(550)
    public void testExec_A55() {

        MockObjectManager.initialize();
        HanteiMoschkMockForSinkeiyaku.SYORIPTN = HanteiMoschkMockForSinkeiyaku.TESTPATTERN4;
        SetKisoKoumokuMockForSinkeiyaku.SYORIPTN = SetKisoKoumokuMockForSinkeiyaku.TESTPATTERN12;
        SetNenreiMockForSinkeiyaku.SYORIPTN = SetNenreiMockForSinkeiyaku.TESTPATTERN1;
        SetHubiMsgMockForSinkeiyaku.SYORIPTN = null;

        CheckHokenRyouYuukouKigen checkHokenRyouYuukouKigen = SWAKInjector.getInstance(CheckHokenRyouYuukouKigen.class);
        MosnaiCheckParam mosnaiCheckParam = SWAKInjector.getInstance(MosnaiCheckParam.class);

        sinkeiyakuDomManager.flush();
        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("860000041");
        BM_SyouhnZokusei syouhnZokusei = bizDomManager.getSyouhnZokusei("ﾕｸ", 1);
        mosnaiCheckParam.setSyuSyouhnZokusei(syouhnZokusei);
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setSysDate(BizDate.valueOf("20160907"));
        mosnaiCheckParam.setListHubiMsg(new ArrayList<HT_HubiMsg>());
        checkHokenRyouYuukouKigen.exec(mosnaiCheckParam);

        List<HT_HubiMsg> hubiMsg = mosnaiCheckParam.getListHubiMsg();

        exNumericEquals(hubiMsg.size(), 1, "不備メッセージ件数");
        exStringEquals(hubiMsg.get(0).getMosno(), "860000041", "申込番号");
        exNumericEquals(hubiMsg.get(0).getRenno(), 1, "連番");
        exStringEquals(hubiMsg.get(0).getMessageId(), "WHC1015", "メッセージＩＤ");
        exStringEquals(hubiMsg.get(0).getHubimsg(), "６月４日までに責任開始しない場合、契約年齢範囲外となります。", "不備メッセージ");
        exClassificationEquals(hubiMsg.get(0).getHubisyubetukbn(), C_HubisyubetuKbn.WARNING, "不備種別区分");
        exClassificationEquals(hubiMsg.get(0).getHubisyubetusyousaikbn(), C_HubisyubetusyousaiKbn.NONE, "不備種別詳細区分");

    }

    @Test
    @Transactional
    @TestOrder(560)
    public void testExec_A56() {

        MockObjectManager.initialize();
        HanteiMoschkMockForSinkeiyaku.SYORIPTN = HanteiMoschkMockForSinkeiyaku.TESTPATTERN4;
        SetKisoKoumokuMockForSinkeiyaku.SYORIPTN = SetKisoKoumokuMockForSinkeiyaku.TESTPATTERN12;
        SetNenreiMockForSinkeiyaku.SYORIPTN = SetNenreiMockForSinkeiyaku.TESTPATTERN1;
        SetHubiMsgMockForSinkeiyaku.SYORIPTN = null;

        CheckHokenRyouYuukouKigen checkHokenRyouYuukouKigen = SWAKInjector.getInstance(CheckHokenRyouYuukouKigen.class);
        MosnaiCheckParam mosnaiCheckParam = SWAKInjector.getInstance(MosnaiCheckParam.class);

        sinkeiyakuDomManager.flush();
        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("860000058");
        BM_SyouhnZokusei syouhnZokusei = bizDomManager.getSyouhnZokusei("ﾕｸ", 1);
        mosnaiCheckParam.setSyuSyouhnZokusei(syouhnZokusei);
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setSysDate(BizDate.valueOf("20160907"));
        mosnaiCheckParam.setListHubiMsg(new ArrayList<HT_HubiMsg>());
        checkHokenRyouYuukouKigen.exec(mosnaiCheckParam);

        List<HT_HubiMsg> hubiMsg = mosnaiCheckParam.getListHubiMsg();

        exNumericEquals(hubiMsg.size(), 0, "不備メッセージ件数");
    }

    @Test
    @Transactional
    @TestOrder(570)
    public void testExec_A57() {

        MockObjectManager.initialize();
        HanteiMoschkMockForSinkeiyaku.SYORIPTN = HanteiMoschkMockForSinkeiyaku.TESTPATTERN4;
        SetKisoKoumokuMockForSinkeiyaku.SYORIPTN = SetKisoKoumokuMockForSinkeiyaku.TESTPATTERN12;
        SetNenreiMockForSinkeiyaku.SYORIPTN = SetNenreiMockForSinkeiyaku.TESTPATTERN1;
        SetHubiMsgMockForSinkeiyaku.SYORIPTN = null;

        CheckHokenRyouYuukouKigen checkHokenRyouYuukouKigen = SWAKInjector.getInstance(CheckHokenRyouYuukouKigen.class);
        MosnaiCheckParam mosnaiCheckParam = SWAKInjector.getInstance(MosnaiCheckParam.class);

        sinkeiyakuDomManager.flush();
        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("860000066");
        BM_SyouhnZokusei syouhnZokusei = bizDomManager.getSyouhnZokusei("ﾕｸ", 1);
        mosnaiCheckParam.setSyuSyouhnZokusei(syouhnZokusei);
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setSysDate(BizDate.valueOf("20160907"));
        mosnaiCheckParam.setListHubiMsg(new ArrayList<HT_HubiMsg>());
        checkHokenRyouYuukouKigen.exec(mosnaiCheckParam);

        List<HT_HubiMsg> hubiMsg = mosnaiCheckParam.getListHubiMsg();

        exNumericEquals(hubiMsg.size(), 0, "不備メッセージ件数");
    }

    @Test
    @Transactional
    @TestOrder(580)
    public void testExec_A58() {

        MockObjectManager.initialize();
        HanteiMoschkMockForSinkeiyaku.SYORIPTN = HanteiMoschkMockForSinkeiyaku.TESTPATTERN4;
        SetKisoKoumokuMockForSinkeiyaku.SYORIPTN = SetKisoKoumokuMockForSinkeiyaku.TESTPATTERN12;
        SetNenreiMockForSinkeiyaku.SYORIPTN = SetNenreiMockForSinkeiyaku.TESTPATTERN1;
        SetHubiMsgMockForSinkeiyaku.SYORIPTN = null;

        CheckHokenRyouYuukouKigen checkHokenRyouYuukouKigen = SWAKInjector.getInstance(CheckHokenRyouYuukouKigen.class);
        MosnaiCheckParam mosnaiCheckParam = SWAKInjector.getInstance(MosnaiCheckParam.class);

        sinkeiyakuDomManager.flush();
        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("860000074");
        BM_SyouhnZokusei syouhnZokusei = bizDomManager.getSyouhnZokusei("ﾕｸ", 1);
        mosnaiCheckParam.setSyuSyouhnZokusei(syouhnZokusei);
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setSysDate(BizDate.valueOf("20160907"));
        mosnaiCheckParam.setListHubiMsg(new ArrayList<HT_HubiMsg>());
        checkHokenRyouYuukouKigen.exec(mosnaiCheckParam);

        List<HT_HubiMsg> hubiMsg = mosnaiCheckParam.getListHubiMsg();

        exNumericEquals(hubiMsg.size(), 1, "不備メッセージ件数");
        exStringEquals(hubiMsg.get(0).getMosno(), "860000074", "申込番号");
        exNumericEquals(hubiMsg.get(0).getRenno(), 1, "連番");
        exStringEquals(hubiMsg.get(0).getMessageId(), "WHC1015", "メッセージＩＤ");
        exStringEquals(hubiMsg.get(0).getHubimsg(), "６月４日までに責任開始しない場合、契約年齢範囲外となります。", "不備メッセージ");
        exClassificationEquals(hubiMsg.get(0).getHubisyubetukbn(), C_HubisyubetuKbn.WARNING, "不備種別区分");
        exClassificationEquals(hubiMsg.get(0).getHubisyubetusyousaikbn(), C_HubisyubetusyousaiKbn.NONE, "不備種別詳細区分");

    }

    @Test
    @Transactional
    @TestOrder(590)
    public void testExec_A59() {

        MockObjectManager.initialize();
        HanteiMoschkMockForSinkeiyaku.SYORIPTN = HanteiMoschkMockForSinkeiyaku.TESTPATTERN4;
        SetKisoKoumokuMockForSinkeiyaku.SYORIPTN = SetKisoKoumokuMockForSinkeiyaku.TESTPATTERN12;
        SetNenreiMockForSinkeiyaku.SYORIPTN = SetNenreiMockForSinkeiyaku.TESTPATTERN1;
        SetHubiMsgMockForSinkeiyaku.SYORIPTN = null;

        CheckHokenRyouYuukouKigen checkHokenRyouYuukouKigen = SWAKInjector.getInstance(CheckHokenRyouYuukouKigen.class);
        MosnaiCheckParam mosnaiCheckParam = SWAKInjector.getInstance(MosnaiCheckParam.class);

        sinkeiyakuDomManager.flush();
        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("860000082");
        BM_SyouhnZokusei syouhnZokusei = bizDomManager.getSyouhnZokusei("ﾕｸ", 1);
        mosnaiCheckParam.setSyuSyouhnZokusei(syouhnZokusei);
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setSysDate(BizDate.valueOf("20160907"));
        mosnaiCheckParam.setListHubiMsg(new ArrayList<HT_HubiMsg>());
        checkHokenRyouYuukouKigen.exec(mosnaiCheckParam);

        List<HT_HubiMsg> hubiMsg = mosnaiCheckParam.getListHubiMsg();

        exNumericEquals(hubiMsg.size(), 1, "不備メッセージ件数");
        exStringEquals(hubiMsg.get(0).getMosno(), "860000082", "申込番号");
        exNumericEquals(hubiMsg.get(0).getRenno(), 1, "連番");
        exStringEquals(hubiMsg.get(0).getMessageId(), "WHC1015", "メッセージＩＤ");
        exStringEquals(hubiMsg.get(0).getHubimsg(), "６月４日までに責任開始しない場合、契約年齢範囲外となります。", "不備メッセージ");
        exClassificationEquals(hubiMsg.get(0).getHubisyubetukbn(), C_HubisyubetuKbn.WARNING, "不備種別区分");
        exClassificationEquals(hubiMsg.get(0).getHubisyubetusyousaikbn(), C_HubisyubetusyousaiKbn.NONE, "不備種別詳細区分");

    }

    @Test
    @Transactional
    @TestOrder(600)
    public void testExec_A60() {

        MockObjectManager.initialize();
        HanteiMoschkMockForSinkeiyaku.SYORIPTN = HanteiMoschkMockForSinkeiyaku.TESTPATTERN7;
        SetKisoKoumokuMockForSinkeiyaku.SYORIPTN = SetKisoKoumokuMockForSinkeiyaku.TESTPATTERN1;
        SetNenreiMockForSinkeiyaku.SYORIPTN = SetNenreiMockForSinkeiyaku.TESTPATTERN1;

        CheckHokenRyouYuukouKigen checkHokenRyouYuukouKigen = SWAKInjector.getInstance(CheckHokenRyouYuukouKigen.class);
        MosnaiCheckParam mosnaiCheckParam = SWAKInjector.getInstance(MosnaiCheckParam.class);

        sinkeiyakuDomManager.flush();
        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("860000090");
        List<HT_HubiMsg> hubiMsg = syoriCTL.getHubiMsgs();
        BM_SyouhnZokusei syouhnZokusei = bizDomManager.getSyouhnZokusei("ﾕｿ", 9);
        mosnaiCheckParam.setSyuSyouhnZokusei(syouhnZokusei);
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setSysDate(BizDate.valueOf("20160907"));
        mosnaiCheckParam.setListHubiMsg(hubiMsg);
        checkHokenRyouYuukouKigen.exec(mosnaiCheckParam);

        exNumericEquals(hubiMsg.size(), 0, "不備メッセージ件数");

        exDateEquals((BizDate)MockObjectManager.getArgument(SetKisoKoumokuMockForSinkeiyaku.class, "setkykymdHantei", 0, 2), null, "領収日");
        exDateEquals((BizDate)MockObjectManager.getArgument(SetKisoKoumokuMockForSinkeiyaku.class, "setkykymdHantei", 0, 3), BizDate.valueOf(20160701), "申込日");
        exDateEquals((BizDate)MockObjectManager.getArgument(SetKisoKoumokuMockForSinkeiyaku.class, "setkykymdHantei", 0, 4), BizDate.valueOf(20160701), "責任開始日");
        exDateEquals((BizDate)MockObjectManager.getArgument(SetKisoKoumokuMockForSinkeiyaku.class, "setkykymdHantei", 0, 5), BizDate.valueOf(20160701), "処理日");
        exClassificationEquals((C_SysKbn)MockObjectManager.getArgument(SetKisoKoumokuMockForSinkeiyaku.class, "setkykymdHantei", 0, 6), C_SysKbn.SKEI, "システム区分");
        exClassificationEquals((C_YoteikykymdKbn)MockObjectManager.getArgument(SetKisoKoumokuMockForSinkeiyaku.class, "setkykymdHantei", 0, 7), C_YoteikykymdKbn.AUTO, "予定契約日区分");

        exDateEquals((BizDate)MockObjectManager.getArgument(SetNenreiMockForSinkeiyaku.class, "exec", 0, 0), BizDate.valueOf(20180203), "基準日");
        exDateEquals((BizDate)MockObjectManager.getArgument(SetNenreiMockForSinkeiyaku.class, "exec", 0, 1), BizDate.valueOf(20010505), "生年月日");

    }

    @Test
    @Transactional
    @TestOrder(610)
    public void testExec_A61() {

        MockObjectManager.initialize();
        HanteiMoschkMockForSinkeiyaku.SYORIPTN = HanteiMoschkMockForSinkeiyaku.TESTPATTERN7;
        SetKisoKoumokuMockForSinkeiyaku.SYORIPTN = SetKisoKoumokuMockForSinkeiyaku.TESTPATTERN1;
        SetNenreiMockForSinkeiyaku.SYORIPTN = SetNenreiMockForSinkeiyaku.TESTPATTERN1;

        CheckHokenRyouYuukouKigen checkHokenRyouYuukouKigen = SWAKInjector.getInstance(CheckHokenRyouYuukouKigen.class);
        MosnaiCheckParam mosnaiCheckParam = SWAKInjector.getInstance(MosnaiCheckParam.class);

        sinkeiyakuDomManager.flush();
        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("860000108");
        List<HT_HubiMsg> hubiMsg = syoriCTL.getHubiMsgs();
        BM_SyouhnZokusei syouhnZokusei = bizDomManager.getSyouhnZokusei("ﾕｿ", 10);
        mosnaiCheckParam.setSyuSyouhnZokusei(syouhnZokusei);
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setSysDate(BizDate.valueOf("20160907"));
        mosnaiCheckParam.setListHubiMsg(hubiMsg);
        checkHokenRyouYuukouKigen.exec(mosnaiCheckParam);

        exNumericEquals(hubiMsg.size(), 0, "不備メッセージ件数");

        exDateEquals((BizDate)MockObjectManager.getArgument(SetKisoKoumokuMockForSinkeiyaku.class, "setkykymdHantei", 0, 2), null, "領収日");
        exDateEquals((BizDate)MockObjectManager.getArgument(SetKisoKoumokuMockForSinkeiyaku.class, "setkykymdHantei", 0, 3), BizDate.valueOf(20160701), "申込日");
        exDateEquals((BizDate)MockObjectManager.getArgument(SetKisoKoumokuMockForSinkeiyaku.class, "setkykymdHantei", 0, 4), BizDate.valueOf(20160701), "責任開始日");
        exDateEquals((BizDate)MockObjectManager.getArgument(SetKisoKoumokuMockForSinkeiyaku.class, "setkykymdHantei", 0, 5), BizDate.valueOf(20160701), "処理日");
        exClassificationEquals((C_SysKbn)MockObjectManager.getArgument(SetKisoKoumokuMockForSinkeiyaku.class, "setkykymdHantei", 0, 6), C_SysKbn.SKEI, "システム区分");
        exClassificationEquals((C_YoteikykymdKbn)MockObjectManager.getArgument(SetKisoKoumokuMockForSinkeiyaku.class, "setkykymdHantei", 0, 7), C_YoteikykymdKbn.AUTO, "予定契約日区分");

        exDateEquals((BizDate)MockObjectManager.getArgument(SetNenreiMockForSinkeiyaku.class, "exec", 0, 0), BizDate.valueOf(20180203), "基準日");
        exDateEquals((BizDate)MockObjectManager.getArgument(SetNenreiMockForSinkeiyaku.class, "exec", 0, 1), BizDate.valueOf(20010505), "生年月日");

    }

    @Test
    @Transactional
    @TestOrder(620)
    public void testExec_A62() {

        MockObjectManager.initialize();
        HanteiMoschkMockForSinkeiyaku.SYORIPTN = HanteiMoschkMockForSinkeiyaku.TESTPATTERN7;
        SetKisoKoumokuMockForSinkeiyaku.SYORIPTN = SetKisoKoumokuMockForSinkeiyaku.TESTPATTERN1;
        SetNenreiMockForSinkeiyaku.SYORIPTN = SetNenreiMockForSinkeiyaku.TESTPATTERN1;

        CheckHokenRyouYuukouKigen checkHokenRyouYuukouKigen = SWAKInjector.getInstance(CheckHokenRyouYuukouKigen.class);
        MosnaiCheckParam mosnaiCheckParam = SWAKInjector.getInstance(MosnaiCheckParam.class);

        sinkeiyakuDomManager.flush();
        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("860000116");
        List<HT_HubiMsg> hubiMsg = syoriCTL.getHubiMsgs();
        BM_SyouhnZokusei syouhnZokusei = bizDomManager.getSyouhnZokusei("ﾕｱ", 11);
        mosnaiCheckParam.setSyuSyouhnZokusei(syouhnZokusei);
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setSysDate(BizDate.valueOf("20160907"));
        mosnaiCheckParam.setListHubiMsg(hubiMsg);
        checkHokenRyouYuukouKigen.exec(mosnaiCheckParam);

        exNumericEquals(hubiMsg.size(), 0, "不備メッセージ件数");

        exDateEquals((BizDate)MockObjectManager.getArgument(SetKisoKoumokuMockForSinkeiyaku.class, "setkykymdHantei", 0, 2), null, "領収日");
        exDateEquals((BizDate)MockObjectManager.getArgument(SetKisoKoumokuMockForSinkeiyaku.class, "setkykymdHantei", 0, 3), BizDate.valueOf(20160701), "申込日");
        exDateEquals((BizDate)MockObjectManager.getArgument(SetKisoKoumokuMockForSinkeiyaku.class, "setkykymdHantei", 0, 4), BizDate.valueOf(20160701), "責任開始日");
        exDateEquals((BizDate)MockObjectManager.getArgument(SetKisoKoumokuMockForSinkeiyaku.class, "setkykymdHantei", 0, 5), BizDate.valueOf(20160701), "処理日");
        exClassificationEquals((C_SysKbn)MockObjectManager.getArgument(SetKisoKoumokuMockForSinkeiyaku.class, "setkykymdHantei", 0, 6), C_SysKbn.SKEI, "システム区分");
        exClassificationEquals((C_YoteikykymdKbn)MockObjectManager.getArgument(SetKisoKoumokuMockForSinkeiyaku.class, "setkykymdHantei", 0, 7), C_YoteikykymdKbn.AUTO, "予定契約日区分");

        exDateEquals((BizDate)MockObjectManager.getArgument(SetNenreiMockForSinkeiyaku.class, "exec", 0, 0), BizDate.valueOf(20180203), "基準日");
        exDateEquals((BizDate)MockObjectManager.getArgument(SetNenreiMockForSinkeiyaku.class, "exec", 0, 1), BizDate.valueOf(20010505), "生年月日");

    }

    @Test
    @Transactional
    @TestOrder(630)
    public void testExec_A63() {

        MockObjectManager.initialize();
        HanteiMoschkMockForSinkeiyaku.SYORIPTN = HanteiMoschkMockForSinkeiyaku.TESTPATTERN7;
        SetKisoKoumokuMockForSinkeiyaku.SYORIPTN = SetKisoKoumokuMockForSinkeiyaku.TESTPATTERN1;
        SetNenreiMockForSinkeiyaku.SYORIPTN = SetNenreiMockForSinkeiyaku.TESTPATTERN1;
        SetHubiMsgMockForSinkeiyaku.SYORIPTN = SetHubiMsgMockForSinkeiyaku.TESTPATTERN18;

        CheckHokenRyouYuukouKigen checkHokenRyouYuukouKigen = SWAKInjector.getInstance(CheckHokenRyouYuukouKigen.class);
        MosnaiCheckParam mosnaiCheckParam = SWAKInjector.getInstance(MosnaiCheckParam.class);

        sinkeiyakuDomManager.flush();
        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("860000124");
        List<HT_HubiMsg> hubiMsg = syoriCTL.getHubiMsgs();
        BM_SyouhnZokusei syouhnZokusei = bizDomManager.getSyouhnZokusei("ﾕｱ", 12);
        mosnaiCheckParam.setSyuSyouhnZokusei(syouhnZokusei);
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setSysDate(BizDate.valueOf("20160907"));
        mosnaiCheckParam.setListHubiMsg(hubiMsg);
        checkHokenRyouYuukouKigen.exec(mosnaiCheckParam);

        exNumericEquals(hubiMsg.size(), 1, "不備メッセージ件数");
        exStringEquals(hubiMsg.get(0).getHubimsg(), "積立利率が申込時点から上昇しています。申込日　20.00％　契約日　30.00％", "不備メッセージ");
        exStringEquals(hubiMsg.get(0).getMessageId(), "EHC1068", "メッセージＩＤ");
        exStringEquals(hubiMsg.get(0).getMosno(), "860000124", "申込番号");
        exNumericEquals(hubiMsg.get(0).getRenno(), 1, "連番");
        exClassificationEquals(hubiMsg.get(0).getHubisyubetukbn(), C_HubisyubetuKbn.KETHORYU_HUBI, "不備種別区分");
        exClassificationEquals(hubiMsg.get(0).getHubisyubetusyousaikbn(), C_HubisyubetusyousaiKbn.NONE, "不備種別詳細区分");

        exDateEquals((BizDate)MockObjectManager.getArgument(SetKisoKoumokuMockForSinkeiyaku.class, "setkykymdHantei", 0, 2), null, "領収日");
        exDateEquals((BizDate)MockObjectManager.getArgument(SetKisoKoumokuMockForSinkeiyaku.class, "setkykymdHantei", 0, 3), BizDate.valueOf(20160701), "申込日");
        exDateEquals((BizDate)MockObjectManager.getArgument(SetKisoKoumokuMockForSinkeiyaku.class, "setkykymdHantei", 0, 4), BizDate.valueOf(20160701), "責任開始日");
        exDateEquals((BizDate)MockObjectManager.getArgument(SetKisoKoumokuMockForSinkeiyaku.class, "setkykymdHantei", 0, 5), BizDate.valueOf(20160701), "処理日");
        exClassificationEquals((C_SysKbn)MockObjectManager.getArgument(SetKisoKoumokuMockForSinkeiyaku.class, "setkykymdHantei", 0, 6), C_SysKbn.SKEI, "システム区分");
        exClassificationEquals((C_YoteikykymdKbn)MockObjectManager.getArgument(SetKisoKoumokuMockForSinkeiyaku.class, "setkykymdHantei", 0, 7), C_YoteikykymdKbn.AUTO, "予定契約日区分");

        exDateEquals((BizDate)MockObjectManager.getArgument(SetNenreiMockForSinkeiyaku.class, "exec", 0, 0), BizDate.valueOf(20180203), "基準日");
        exDateEquals((BizDate)MockObjectManager.getArgument(SetNenreiMockForSinkeiyaku.class, "exec", 0, 1), BizDate.valueOf(20010505), "生年月日");

        exClassificationEquals((C_KetsrhkosKbn)MockObjectManager.getArgument(SetHubiMsgMockForSinkeiyaku.class, "exec", 0, 0), C_KetsrhkosKbn.KETHORYU_HUBI, "決定・成立保留更新区分");
        exClassificationEquals((C_SpKeisanKahiKbn)MockObjectManager.getArgument(SetHubiMsgMockForSinkeiyaku.class, "exec", 0, 1), C_SpKeisanKahiKbn.SPKEISANKA, "決定保留時ＳＰ計算可否区分");
        exClassificationEquals((C_HubisyubetusyousaiKbn)MockObjectManager.getArgument(SetHubiMsgMockForSinkeiyaku.class, "exec", 0, 2), C_HubisyubetusyousaiKbn.NONE, "不備種別詳細区分");
        exStringEquals((String)MockObjectManager.getArgument(SetHubiMsgMockForSinkeiyaku.class, "exec", 0, 3), "EHC1068 積立利率が申込時点から上昇しています。申込日　20.00％　契約日　30.00％", "メッセージ文言");
        exClassificationEquals((C_TknKbn)MockObjectManager.getArgument(SetHubiMsgMockForSinkeiyaku.class, "exec", 0, 5), C_TknKbn.KANOU, "特認区分");
        exClassificationEquals((C_MsgKbn)MockObjectManager.getArgument(SetHubiMsgMockForSinkeiyaku.class, "exec", 0, 6), C_MsgKbn.ERROR, "メッセージ区分");
    }

    @Test
    @Transactional
    @TestOrder(640)
    public void testExec_A64() {

        MockObjectManager.initialize();
        HanteiMoschkMockForSinkeiyaku.SYORIPTN = HanteiMoschkMockForSinkeiyaku.TESTPATTERN7;
        SetKisoKoumokuMockForSinkeiyaku.SYORIPTN = SetKisoKoumokuMockForSinkeiyaku.TESTPATTERN1;
        SetNenreiMockForSinkeiyaku.SYORIPTN = SetNenreiMockForSinkeiyaku.TESTPATTERN1;

        CheckHokenRyouYuukouKigen checkHokenRyouYuukouKigen = SWAKInjector.getInstance(CheckHokenRyouYuukouKigen.class);
        MosnaiCheckParam mosnaiCheckParam = SWAKInjector.getInstance(MosnaiCheckParam.class);

        sinkeiyakuDomManager.flush();
        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("860000132");
        List<HT_HubiMsg> hubiMsg = syoriCTL.getHubiMsgs();
        BM_SyouhnZokusei syouhnZokusei = bizDomManager.getSyouhnZokusei("ﾕﾍ", 13);
        mosnaiCheckParam.setSyuSyouhnZokusei(syouhnZokusei);
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setSysDate(BizDate.valueOf("20160907"));
        mosnaiCheckParam.setListHubiMsg(hubiMsg);
        checkHokenRyouYuukouKigen.exec(mosnaiCheckParam);

        exNumericEquals(hubiMsg.size(), 0, "不備メッセージ件数");

    }

    @Test
    @Transactional
    @TestOrder(650)
    public void testExec_A65() {

        MockObjectManager.initialize();
        HanteiMoschkMockForSinkeiyaku.SYORIPTN = HanteiMoschkMockForSinkeiyaku.TESTPATTERN10;
        SetKisoKoumokuMockForSinkeiyaku.SYORIPTN = SetKisoKoumokuMockForSinkeiyaku.TESTPATTERN1;
        SetNenreiMockForSinkeiyaku.SYORIPTN = SetNenreiMockForSinkeiyaku.TESTPATTERN1;

        CheckHokenRyouYuukouKigen checkHokenRyouYuukouKigen = SWAKInjector.getInstance(CheckHokenRyouYuukouKigen.class);
        MosnaiCheckParam mosnaiCheckParam = SWAKInjector.getInstance(MosnaiCheckParam.class);

        sinkeiyakuDomManager.flush();
        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("860000140");
        List<HT_HubiMsg> hubiMsg = syoriCTL.getHubiMsgs();
        BM_SyouhnZokusei syouhnZokusei = bizDomManager.getSyouhnZokusei("ﾕｱ", 14);
        mosnaiCheckParam.setSyuSyouhnZokusei(syouhnZokusei);
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setSysDate(BizDate.valueOf("20160907"));
        mosnaiCheckParam.setListHubiMsg(hubiMsg);
        checkHokenRyouYuukouKigen.exec(mosnaiCheckParam);

        exNumericEquals(hubiMsg.size(), 0, "不備メッセージ件数");

    }

    @Test
    @Transactional
    @TestOrder(660)
    public void testExec_A66() {

        MockObjectManager.initialize();
        HanteiMoschkMockForSinkeiyaku.SYORIPTN = HanteiMoschkMockForSinkeiyaku.TESTPATTERN10;
        SetKisoKoumokuMockForSinkeiyaku.SYORIPTN = SetKisoKoumokuMockForSinkeiyaku.TESTPATTERN1;
        SetNenreiMockForSinkeiyaku.SYORIPTN = SetNenreiMockForSinkeiyaku.TESTPATTERN1;

        CheckHokenRyouYuukouKigen checkHokenRyouYuukouKigen = SWAKInjector.getInstance(CheckHokenRyouYuukouKigen.class);
        MosnaiCheckParam mosnaiCheckParam = SWAKInjector.getInstance(MosnaiCheckParam.class);

        sinkeiyakuDomManager.flush();
        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("860000157");
        List<HT_HubiMsg> hubiMsg = syoriCTL.getHubiMsgs();
        BM_SyouhnZokusei syouhnZokusei = bizDomManager.getSyouhnZokusei("ﾕｲ", 14);
        mosnaiCheckParam.setSyuSyouhnZokusei(syouhnZokusei);
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setSysDate(BizDate.valueOf("20160907"));
        mosnaiCheckParam.setListHubiMsg(hubiMsg);
        checkHokenRyouYuukouKigen.exec(mosnaiCheckParam);

        exNumericEquals(hubiMsg.size(), 0, "不備メッセージ件数");

    }

    @Test
    @Transactional
    @TestOrder(670)
    public void testExec_A67() {

        MockObjectManager.initialize();
        HanteiMoschkMockForSinkeiyaku.SYORIPTN = HanteiMoschkMockForSinkeiyaku.TESTPATTERN10;
        SetKisoKoumokuMockForSinkeiyaku.SYORIPTN = SetKisoKoumokuMockForSinkeiyaku.TESTPATTERN1;
        SetNenreiMockForSinkeiyaku.SYORIPTN = SetNenreiMockForSinkeiyaku.TESTPATTERN1;
        SetHubiMsgMockForSinkeiyaku.SYORIPTN = SetHubiMsgMockForSinkeiyaku.TESTPATTERN19;

        CheckHokenRyouYuukouKigen checkHokenRyouYuukouKigen = SWAKInjector.getInstance(CheckHokenRyouYuukouKigen.class);
        MosnaiCheckParam mosnaiCheckParam = SWAKInjector.getInstance(MosnaiCheckParam.class);

        sinkeiyakuDomManager.flush();
        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("860000165");
        List<HT_HubiMsg> hubiMsg = syoriCTL.getHubiMsgs();
        BM_SyouhnZokusei syouhnZokusei = bizDomManager.getSyouhnZokusei("ﾕA", 14);
        mosnaiCheckParam.setSyuSyouhnZokusei(syouhnZokusei);
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setSysDate(BizDate.valueOf("20160907"));
        mosnaiCheckParam.setListHubiMsg(hubiMsg);
        checkHokenRyouYuukouKigen.exec(mosnaiCheckParam);

        exNumericEquals(hubiMsg.size(), 1, "不備メッセージ件数");
        exStringEquals(hubiMsg.get(0).getHubimsg(), "５年ごと利差配当付指定通貨建終身保険（一時払い）　　５年　最低保証あり（米ドル）の積立利率が取得できません。申込日　20160701", "不備メッセージ");
        exStringEquals(hubiMsg.get(0).getMessageId(), "EHC1067", "メッセージＩＤ");
        exStringEquals(hubiMsg.get(0).getMosno(), "860000165", "申込番号");
        exNumericEquals(hubiMsg.get(0).getRenno(), 1, "連番");
        exClassificationEquals(hubiMsg.get(0).getHubisyubetukbn(), C_HubisyubetuKbn.KETHORYU_HUBI, "不備種別区分");
        exClassificationEquals(hubiMsg.get(0).getHubisyubetusyousaikbn(), C_HubisyubetusyousaiKbn.NONE, "不備種別詳細区分");

        exClassificationEquals((C_KetsrhkosKbn)MockObjectManager.getArgument(SetHubiMsgMockForSinkeiyaku.class, "exec", 0, 0), C_KetsrhkosKbn.KETHORYU_HUBI, "決定・成立保留更新区分");
        exClassificationEquals((C_SpKeisanKahiKbn)MockObjectManager.getArgument(SetHubiMsgMockForSinkeiyaku.class, "exec", 0, 1), C_SpKeisanKahiKbn.SPKEISANKA, "決定保留時ＳＰ計算可否区分");
        exClassificationEquals((C_HubisyubetusyousaiKbn)MockObjectManager.getArgument(SetHubiMsgMockForSinkeiyaku.class, "exec", 0, 2), C_HubisyubetusyousaiKbn.NONE, "不備種別詳細区分");
        exStringEquals((String)MockObjectManager.getArgument(SetHubiMsgMockForSinkeiyaku.class, "exec", 0, 3), "EHC1067 ５年ごと利差配当付指定通貨建終身保険（一時払い）　　５年　最低保証あり（米ドル）の積立利率が取得できません。申込日　20160701", "メッセージ文言");
        exClassificationEquals((C_TknKbn)MockObjectManager.getArgument(SetHubiMsgMockForSinkeiyaku.class, "exec", 0, 5), C_TknKbn.NONE, "特認区分");
        exClassificationEquals((C_MsgKbn)MockObjectManager.getArgument(SetHubiMsgMockForSinkeiyaku.class, "exec", 0, 6), C_MsgKbn.ERROR, "メッセージ区分");
    }

    @Test
    @Transactional
    @TestOrder(680)
    public void testExec_A68() {

        MockObjectManager.initialize();
        HanteiMoschkMockForSinkeiyaku.SYORIPTN = HanteiMoschkMockForSinkeiyaku.TESTPATTERN10;
        SetKisoKoumokuMockForSinkeiyaku.SYORIPTN = SetKisoKoumokuMockForSinkeiyaku.TESTPATTERN1;
        SetNenreiMockForSinkeiyaku.SYORIPTN = SetNenreiMockForSinkeiyaku.TESTPATTERN1;
        SetHubiMsgMockForSinkeiyaku.SYORIPTN = SetHubiMsgMockForSinkeiyaku.TESTPATTERN20;

        CheckHokenRyouYuukouKigen checkHokenRyouYuukouKigen = SWAKInjector.getInstance(CheckHokenRyouYuukouKigen.class);
        MosnaiCheckParam mosnaiCheckParam = SWAKInjector.getInstance(MosnaiCheckParam.class);

        sinkeiyakuDomManager.flush();
        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("860000173");
        List<HT_HubiMsg> hubiMsg = syoriCTL.getHubiMsgs();
        BM_SyouhnZokusei syouhnZokusei = bizDomManager.getSyouhnZokusei("ﾕｴ", 14);
        mosnaiCheckParam.setSyuSyouhnZokusei(syouhnZokusei);
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setSysDate(BizDate.valueOf("20160907"));
        mosnaiCheckParam.setListHubiMsg(hubiMsg);
        checkHokenRyouYuukouKigen.exec(mosnaiCheckParam);

        exNumericEquals(hubiMsg.size(), 1, "不備メッセージ件数");
        exStringEquals(hubiMsg.get(0).getHubimsg(), "連動率が申込時点から上昇しています。申込日　80.00％　契約日　90.00％　", "不備メッセージ");
        exStringEquals(hubiMsg.get(0).getMessageId(), "EHC1140", "メッセージＩＤ");
        exStringEquals(hubiMsg.get(0).getMosno(), "860000173", "申込番号");
        exNumericEquals(hubiMsg.get(0).getRenno(), 1, "連番");
        exClassificationEquals(hubiMsg.get(0).getHubisyubetukbn(), C_HubisyubetuKbn.KETHORYU_HUBI, "不備種別区分");
        exClassificationEquals(hubiMsg.get(0).getHubisyubetusyousaikbn(), C_HubisyubetusyousaiKbn.NONE, "不備種別詳細区分");

        exClassificationEquals((C_KetsrhkosKbn)MockObjectManager.getArgument(SetHubiMsgMockForSinkeiyaku.class, "exec", 0, 0), C_KetsrhkosKbn.KETHORYU_HUBI, "決定・成立保留更新区分");
        exClassificationEquals((C_SpKeisanKahiKbn)MockObjectManager.getArgument(SetHubiMsgMockForSinkeiyaku.class, "exec", 0, 1), C_SpKeisanKahiKbn.SPKEISANKA, "決定保留時ＳＰ計算可否区分");
        exClassificationEquals((C_HubisyubetusyousaiKbn)MockObjectManager.getArgument(SetHubiMsgMockForSinkeiyaku.class, "exec", 0, 2), C_HubisyubetusyousaiKbn.NONE, "不備種別詳細区分");
        exStringEquals((String)MockObjectManager.getArgument(SetHubiMsgMockForSinkeiyaku.class, "exec", 0, 3), "EHC1140 連動率が申込時点から上昇しています。申込日　80.00％　契約日　90.00％", "メッセージ文言");
        exClassificationEquals((C_TknKbn)MockObjectManager.getArgument(SetHubiMsgMockForSinkeiyaku.class, "exec", 0, 5), C_TknKbn.KANOU, "特認区分");
        exClassificationEquals((C_MsgKbn)MockObjectManager.getArgument(SetHubiMsgMockForSinkeiyaku.class, "exec", 0, 6), C_MsgKbn.ERROR, "メッセージ区分");
    }

    @Test
    @Transactional
    @TestOrder(690)
    public void testExec_A69() {

        MockObjectManager.initialize();
        HanteiMoschkMockForSinkeiyaku.SYORIPTN = HanteiMoschkMockForSinkeiyaku.TESTPATTERN10;
        SetKisoKoumokuMockForSinkeiyaku.SYORIPTN = SetKisoKoumokuMockForSinkeiyaku.TESTPATTERN1;
        SetNenreiMockForSinkeiyaku.SYORIPTN = SetNenreiMockForSinkeiyaku.TESTPATTERN1;

        CheckHokenRyouYuukouKigen checkHokenRyouYuukouKigen = SWAKInjector.getInstance(CheckHokenRyouYuukouKigen.class);
        MosnaiCheckParam mosnaiCheckParam = SWAKInjector.getInstance(MosnaiCheckParam.class);

        sinkeiyakuDomManager.flush();
        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("860000181");
        List<HT_HubiMsg> hubiMsg = syoriCTL.getHubiMsgs();
        BM_SyouhnZokusei syouhnZokusei = bizDomManager.getSyouhnZokusei("ﾕｵ", 14);
        mosnaiCheckParam.setSyuSyouhnZokusei(syouhnZokusei);
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setSysDate(BizDate.valueOf("20160907"));
        mosnaiCheckParam.setListHubiMsg(hubiMsg);
        checkHokenRyouYuukouKigen.exec(mosnaiCheckParam);

        exNumericEquals(hubiMsg.size(), 0, "不備メッセージ件数");
    }

    @Test
    @Transactional
    @TestOrder(700)
    public void testExec_A70() {

        MockObjectManager.initialize();
        HanteiMoschkMockForSinkeiyaku.SYORIPTN = HanteiMoschkMockForSinkeiyaku.TESTPATTERN10;
        SetKisoKoumokuMockForSinkeiyaku.SYORIPTN = SetKisoKoumokuMockForSinkeiyaku.TESTPATTERN1;
        SetNenreiMockForSinkeiyaku.SYORIPTN = SetNenreiMockForSinkeiyaku.TESTPATTERN1;
        EditPdfYoteirirtuMockForSinkeiyaku.SYORIPTN = EditPdfYoteirirtuMockForSinkeiyaku.TESTPATTERN1;
        SetHubiMsgMockForSinkeiyaku.SYORIPTN = SetHubiMsgMockForSinkeiyaku.TESTPATTERN21;

        CheckHokenRyouYuukouKigen checkHokenRyouYuukouKigen = SWAKInjector.getInstance(CheckHokenRyouYuukouKigen.class);
        MosnaiCheckParam mosnaiCheckParam = SWAKInjector.getInstance(MosnaiCheckParam.class);

        sinkeiyakuDomManager.flush();
        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("860000199");
        List<HT_HubiMsg> hubiMsg = syoriCTL.getHubiMsgs();
        BM_SyouhnZokusei syouhnZokusei = bizDomManager.getSyouhnZokusei("ﾕｶ", 14);
        mosnaiCheckParam.setSyuSyouhnZokusei(syouhnZokusei);
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setSysDate(BizDate.valueOf("20160907"));
        mosnaiCheckParam.setListHubiMsg(hubiMsg);
        checkHokenRyouYuukouKigen.exec(mosnaiCheckParam);

        exNumericEquals(hubiMsg.size(), 1, "不備メッセージ件数");
        exStringEquals(hubiMsg.get(0).getHubimsg(), "連動率が申込時点から低下しています。申込日　90.00％　契約日　80.00％　", "不備メッセージ");
        exStringEquals(hubiMsg.get(0).getMessageId(), "EHC1141", "メッセージＩＤ");
        exStringEquals(hubiMsg.get(0).getMosno(), "860000199", "申込番号");
        exNumericEquals(hubiMsg.get(0).getRenno(), 1, "連番");
        exClassificationEquals(hubiMsg.get(0).getHubisyubetukbn(), C_HubisyubetuKbn.KETHORYU_HUBI, "不備種別区分");
        exClassificationEquals(hubiMsg.get(0).getHubisyubetusyousaikbn(), C_HubisyubetusyousaiKbn.NONE, "不備種別詳細区分");

        exBizCalcbleEquals((BizNumber)MockObjectManager.getArgument(EditPdfYoteirirtuMockForSinkeiyaku.class, "exec", 0, 1), BizNumber.valueOf(0), "申込日予定利率");
        exBizCalcbleEquals((BizNumber)MockObjectManager.getArgument(EditPdfYoteirirtuMockForSinkeiyaku.class, "exec", 0, 2), BizNumber.valueOf(0), "契約日予定利率");
        exClassificationEquals((C_UmuKbn)MockObjectManager.getArgument(EditPdfYoteirirtuMockForSinkeiyaku.class, "exec", 0, 3), C_UmuKbn.NONE, "予定利率変動有無");
        exBizCalcbleEquals((BizNumber)MockObjectManager.getArgument(EditPdfYoteirirtuMockForSinkeiyaku.class, "exec", 0, 4), BizNumber.valueOf(0), "申込日積立利率");
        exBizCalcbleEquals((BizNumber)MockObjectManager.getArgument(EditPdfYoteirirtuMockForSinkeiyaku.class, "exec", 0, 5), BizNumber.valueOf(0), "契約日積立利率");
        exBizCalcbleEquals((BizNumber)MockObjectManager.getArgument(EditPdfYoteirirtuMockForSinkeiyaku.class, "exec", 0, 6), BizNumber.valueOf(45), "申込日ローディング変更後積立利率");
        exBizCalcbleEquals((BizNumber)MockObjectManager.getArgument(EditPdfYoteirirtuMockForSinkeiyaku.class, "exec", 0, 7), BizNumber.valueOf(80), "契約日ローディング変更後積立利率");
        exClassificationEquals((C_UmuKbn)MockObjectManager.getArgument(EditPdfYoteirirtuMockForSinkeiyaku.class, "exec", 0, 8), C_UmuKbn.NONE, "積立利率変動有無");
        exBizCalcbleEquals((BizNumber)MockObjectManager.getArgument(EditPdfYoteirirtuMockForSinkeiyaku.class, "exec", 0, 9), BizNumber.valueOf(0), "申込日積立金増加率上限");
        exBizCalcbleEquals((BizNumber)MockObjectManager.getArgument(EditPdfYoteirirtuMockForSinkeiyaku.class, "exec", 0, 10), BizNumber.valueOf(0), "契約日積立金増加率上限");
        exClassificationEquals((C_UmuKbn)MockObjectManager.getArgument(EditPdfYoteirirtuMockForSinkeiyaku.class, "exec", 0, 11), C_UmuKbn.NONE, "積立金増加率上限変動有無");
        exBizCalcbleEquals((BizNumber)MockObjectManager.getArgument(EditPdfYoteirirtuMockForSinkeiyaku.class, "exec", 0, 12), BizNumber.valueOf(0.9), "申込日設定倍率");
        exBizCalcbleEquals((BizNumber)MockObjectManager.getArgument(EditPdfYoteirirtuMockForSinkeiyaku.class, "exec", 0,13), BizNumber.valueOf(0), "契約日設定倍率");
        exClassificationEquals((C_UmuKbn)MockObjectManager.getArgument(EditPdfYoteirirtuMockForSinkeiyaku.class, "exec", 0, 14), C_UmuKbn.NONE, "設定倍率変動有無");
        exBizCalcbleEquals((BizNumber)MockObjectManager.getArgument(EditPdfYoteirirtuMockForSinkeiyaku.class, "exec", 0, 15), BizNumber.valueOf(90), "申込日連動率");
        exBizCalcbleEquals((BizNumber)MockObjectManager.getArgument(EditPdfYoteirirtuMockForSinkeiyaku.class, "exec", 0,16), BizNumber.valueOf(80), "契約日連動率");
        exClassificationEquals((C_UmuKbn)MockObjectManager.getArgument(EditPdfYoteirirtuMockForSinkeiyaku.class, "exec", 0, 17), C_UmuKbn.ARI, "連動率変動有無");

        exClassificationEquals((C_KetsrhkosKbn)MockObjectManager.getArgument(SetHubiMsgMockForSinkeiyaku.class, "exec", 0, 0), C_KetsrhkosKbn.KETHORYU_HUBI, "決定・成立保留更新区分");
        exClassificationEquals((C_SpKeisanKahiKbn)MockObjectManager.getArgument(SetHubiMsgMockForSinkeiyaku.class, "exec", 0, 1), C_SpKeisanKahiKbn.SPKEISANKA, "決定保留時ＳＰ計算可否区分");
        exClassificationEquals((C_HubisyubetusyousaiKbn)MockObjectManager.getArgument(SetHubiMsgMockForSinkeiyaku.class, "exec", 0, 2), C_HubisyubetusyousaiKbn.NONE, "不備種別詳細区分");
        exStringEquals((String)MockObjectManager.getArgument(SetHubiMsgMockForSinkeiyaku.class, "exec", 0, 3), "EHC1141 連動率が申込時点から低下しています。申込日　90.00％　契約日　80.00％", "メッセージ文言");
        exClassificationEquals((C_TknKbn)MockObjectManager.getArgument(SetHubiMsgMockForSinkeiyaku.class, "exec", 0, 5), C_TknKbn.SUMI, "特認区分");
        exClassificationEquals((C_MsgKbn)MockObjectManager.getArgument(SetHubiMsgMockForSinkeiyaku.class, "exec", 0, 6), C_MsgKbn.ERROR, "メッセージ区分");

    }

    @Test
    @Transactional
    @TestOrder(710)
    public void testExec_A71() {

        MockObjectManager.initialize();
        HanteiMoschkMockForSinkeiyaku.SYORIPTN = HanteiMoschkMockForSinkeiyaku.TESTPATTERN10;
        SetKisoKoumokuMockForSinkeiyaku.SYORIPTN = SetKisoKoumokuMockForSinkeiyaku.TESTPATTERN1;
        SetNenreiMockForSinkeiyaku.SYORIPTN = SetNenreiMockForSinkeiyaku.TESTPATTERN1;

        CheckHokenRyouYuukouKigen checkHokenRyouYuukouKigen = SWAKInjector.getInstance(CheckHokenRyouYuukouKigen.class);
        MosnaiCheckParam mosnaiCheckParam = SWAKInjector.getInstance(MosnaiCheckParam.class);

        sinkeiyakuDomManager.flush();
        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("860000207");
        List<HT_HubiMsg> hubiMsg = syoriCTL.getHubiMsgs();
        BM_SyouhnZokusei syouhnZokusei = bizDomManager.getSyouhnZokusei("ﾕｷ", 14);
        mosnaiCheckParam.setSyuSyouhnZokusei(syouhnZokusei);
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setSysDate(BizDate.valueOf("20160907"));
        mosnaiCheckParam.setListHubiMsg(hubiMsg);
        checkHokenRyouYuukouKigen.exec(mosnaiCheckParam);

        exNumericEquals(hubiMsg.size(), 0, "不備メッセージ件数");

    }


    @Test
    @Transactional
    @TestOrder(720)
    public void testExec_A72() {

        MockObjectManager.initialize();
        HanteiMoschkMockForSinkeiyaku.SYORIPTN = HanteiMoschkMockForSinkeiyaku.TESTPATTERN10;
        SetKisoKoumokuMockForSinkeiyaku.SYORIPTN = SetKisoKoumokuMockForSinkeiyaku.TESTPATTERN1;
        SetNenreiMockForSinkeiyaku.SYORIPTN = SetNenreiMockForSinkeiyaku.TESTPATTERN1;
        SetHubiMsgMockForSinkeiyaku.SYORIPTN = SetHubiMsgMockForSinkeiyaku.TESTPATTERN22;

        CheckHokenRyouYuukouKigen checkHokenRyouYuukouKigen = SWAKInjector.getInstance(CheckHokenRyouYuukouKigen.class);
        MosnaiCheckParam mosnaiCheckParam = SWAKInjector.getInstance(MosnaiCheckParam.class);

        sinkeiyakuDomManager.flush();
        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("860000215");
        List<HT_HubiMsg> hubiMsg = syoriCTL.getHubiMsgs();
        BM_SyouhnZokusei syouhnZokusei = bizDomManager.getSyouhnZokusei("ﾕｴ", 14);
        mosnaiCheckParam.setSyuSyouhnZokusei(syouhnZokusei);
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setSysDate(BizDate.valueOf("20160907"));
        mosnaiCheckParam.setListHubiMsg(hubiMsg);
        checkHokenRyouYuukouKigen.exec(mosnaiCheckParam);

        exNumericEquals(hubiMsg.size(), 1, "不備メッセージ件数");
        exStringEquals(hubiMsg.get(0).getHubimsg(), "連動率が申込時点から上昇しています。申込日　80.00％　契約日　90.00％　", "不備メッセージ");
        exStringEquals(hubiMsg.get(0).getMessageId(), "EHC1140", "メッセージＩＤ");
        exStringEquals(hubiMsg.get(0).getMosno(), "860000215", "申込番号");
        exNumericEquals(hubiMsg.get(0).getRenno(), 1, "連番");
        exClassificationEquals(hubiMsg.get(0).getHubisyubetukbn(), C_HubisyubetuKbn.KETHORYU_HUBI, "不備種別区分");
        exClassificationEquals(hubiMsg.get(0).getHubisyubetusyousaikbn(), C_HubisyubetusyousaiKbn.NONE, "不備種別詳細区分");

        exClassificationEquals((C_KetsrhkosKbn)MockObjectManager.getArgument(SetHubiMsgMockForSinkeiyaku.class, "exec", 0, 0), C_KetsrhkosKbn.KETHORYU_HUBI, "決定・成立保留更新区分");
        exClassificationEquals((C_SpKeisanKahiKbn)MockObjectManager.getArgument(SetHubiMsgMockForSinkeiyaku.class, "exec", 0, 1), C_SpKeisanKahiKbn.SPKEISANKA, "決定保留時ＳＰ計算可否区分");
        exClassificationEquals((C_HubisyubetusyousaiKbn)MockObjectManager.getArgument(SetHubiMsgMockForSinkeiyaku.class, "exec", 0, 2), C_HubisyubetusyousaiKbn.NONE, "不備種別詳細区分");
        exStringEquals((String)MockObjectManager.getArgument(SetHubiMsgMockForSinkeiyaku.class, "exec", 0, 3), "EHC1140 連動率が申込時点から上昇しています。申込日　80.00％　契約日　90.00％", "メッセージ文言");
        exClassificationEquals((C_TknKbn)MockObjectManager.getArgument(SetHubiMsgMockForSinkeiyaku.class, "exec", 0, 5), C_TknKbn.KANOU, "特認区分");
        exClassificationEquals((C_MsgKbn)MockObjectManager.getArgument(SetHubiMsgMockForSinkeiyaku.class, "exec", 0, 6), C_MsgKbn.ERROR, "メッセージ区分");
    }

    @Test
    @Transactional
    @TestOrder(730)
    public void testExec_A73() {

        MockObjectManager.initialize();
        HanteiMoschkMockForSinkeiyaku.SYORIPTN = HanteiMoschkMockForSinkeiyaku.TESTPATTERN6;
        SetKisoKoumokuMockForSinkeiyaku.SYORIPTN = SetKisoKoumokuMockForSinkeiyaku.TESTPATTERN1;
        SetNenreiMockForSinkeiyaku.SYORIPTN = SetNenreiMockForSinkeiyaku.TESTPATTERN1;
        SetHubiMsgMockForSinkeiyaku.SYORIPTN = SetHubiMsgMockForSinkeiyaku.TESTPATTERN9;

        CheckHokenRyouYuukouKigen checkHokenRyouYuukouKigen = SWAKInjector.getInstance(CheckHokenRyouYuukouKigen.class);
        MosnaiCheckParam mosnaiCheckParam = SWAKInjector.getInstance(MosnaiCheckParam.class);

        sinkeiyakuDomManager.flush();
        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("860000298");
        List<HT_HubiMsg> hubiMsg = syoriCTL.getHubiMsgs();
        BM_SyouhnZokusei syouhnZokusei = bizDomManager.getSyouhnZokusei("ﾕｶ", 8);
        mosnaiCheckParam.setSyuSyouhnZokusei(syouhnZokusei);
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setSysDate(BizDate.valueOf("20160907"));
        mosnaiCheckParam.setListHubiMsg(hubiMsg);
        checkHokenRyouYuukouKigen.exec(mosnaiCheckParam);

        exNumericEquals(hubiMsg.size(), 1, "不備メッセージ件数");
        exStringEquals(hubiMsg.get(0).getHubimsg(), "予定利率が申込時点から上昇しています。申込日　10.00％　契約日　20.00％", "不備メッセージ");
        exStringEquals(hubiMsg.get(0).getMessageId(), "WHC1023", "メッセージＩＤ");
        exStringEquals(hubiMsg.get(0).getMosno(), "860000298", "申込番号");
        exNumericEquals(hubiMsg.get(0).getRenno(), 1, "連番");
        exClassificationEquals(hubiMsg.get(0).getHubisyubetukbn(), C_HubisyubetuKbn.WARNING, "不備種別区分");
        exClassificationEquals(hubiMsg.get(0).getHubisyubetusyousaikbn(), C_HubisyubetusyousaiKbn.NONE, "不備種別詳細区分");

        exClassificationEquals((C_KetsrhkosKbn)MockObjectManager.getArgument(SetHubiMsgMockForSinkeiyaku.class, "exec", 0, 0), C_KetsrhkosKbn.WARNING, "決定・成立保留更新区分");
        exStringEquals((String)MockObjectManager.getArgument(SetHubiMsgMockForSinkeiyaku.class, "exec", 0, 1), "WHC1023 予定利率が申込時点から上昇しています。申込日　10.00％　契約日　20.00％", "メッセージ文言");
        exClassificationEquals((C_TknKbn)MockObjectManager.getArgument(SetHubiMsgMockForSinkeiyaku.class, "exec", 0, 3), C_TknKbn.NONE, "特認区分");
        exClassificationEquals((C_MsgKbn)MockObjectManager.getArgument(SetHubiMsgMockForSinkeiyaku.class, "exec", 0, 4), C_MsgKbn.WARNING, "メッセージ区分");

        BM_SyouhnZokusei zokusei1 = (BM_SyouhnZokusei) MockObjectManager.getArgument(HanteiMoschkMockForSinkeiyaku.class, "hanteiKykNenreiUpSekininkaisiNasiTyuui", 0, 0);
        exStringEquals(zokusei1.getSyouhncd(),"ﾕｶ","商品コード");
        exNumericEquals(zokusei1.getSyouhnsdno(),8,"商品世代番号");

        HT_MosKihon mosKihon1 = (HT_MosKihon) MockObjectManager.getArgument(HanteiMoschkMockForSinkeiyaku.class, "hanteiKykNenreiUpSekininkaisiNasiTyuui", 0, 2);
        exStringEquals(mosKihon1.getMosno(),"860000298","申込番号");

        BM_SyouhnZokusei zokusei2 = (BM_SyouhnZokusei) MockObjectManager.getArgument(HanteiMoschkMockForSinkeiyaku.class, "hanteiKykNenreiUpSekininkaisiNasiKeikoku", 0, 0);
        exStringEquals(zokusei2.getSyouhncd(),"ﾕｶ","商品コード");
        exNumericEquals(zokusei2.getSyouhnsdno(),8,"商品世代番号");
        HT_MosKihon mosKihon2 = (HT_MosKihon) MockObjectManager.getArgument(HanteiMoschkMockForSinkeiyaku.class, "hanteiKykNenreiUpSekininkaisiNasiKeikoku", 0, 2);
        exStringEquals(mosKihon2.getMosno(),"860000298","申込番号");

    }

    @Test
    @Transactional
    @TestOrder(740)
    public void testExec_A74() {

        MockObjectManager.initialize();
        HanteiMoschkMockForSinkeiyaku.SYORIPTN = HanteiMoschkMockForSinkeiyaku.TESTPATTERN6;
        SetKisoKoumokuMockForSinkeiyaku.SYORIPTN = SetKisoKoumokuMockForSinkeiyaku.TESTPATTERN1;
        SetNenreiMockForSinkeiyaku.SYORIPTN = SetNenreiMockForSinkeiyaku.TESTPATTERN1;
        SetHubiMsgMockForSinkeiyaku.SYORIPTN = SetHubiMsgMockForSinkeiyaku.TESTPATTERN10;

        CheckHokenRyouYuukouKigen checkHokenRyouYuukouKigen = SWAKInjector.getInstance(CheckHokenRyouYuukouKigen.class);
        MosnaiCheckParam mosnaiCheckParam = SWAKInjector.getInstance(MosnaiCheckParam.class);

        sinkeiyakuDomManager.flush();
        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("860000306");
        List<HT_HubiMsg> hubiMsg = syoriCTL.getHubiMsgs();
        BM_SyouhnZokusei syouhnZokusei = bizDomManager.getSyouhnZokusei("ﾕｶ", 9);
        mosnaiCheckParam.setSyuSyouhnZokusei(syouhnZokusei);
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setSysDate(BizDate.valueOf("20160907"));
        mosnaiCheckParam.setListHubiMsg(hubiMsg);
        checkHokenRyouYuukouKigen.exec(mosnaiCheckParam);

        exNumericEquals(hubiMsg.size(), 1, "不備メッセージ件数");
        exStringEquals(hubiMsg.get(0).getHubimsg(), "予定利率が申込時点から上昇しています。申込日　10.00％　契約日　20.00％", "不備メッセージ");
        exStringEquals(hubiMsg.get(0).getMessageId(), "WHC1023", "メッセージＩＤ");
        exStringEquals(hubiMsg.get(0).getMosno(), "860000306", "申込番号");
        exNumericEquals(hubiMsg.get(0).getRenno(), 1, "連番");
        exClassificationEquals(hubiMsg.get(0).getHubisyubetukbn(), C_HubisyubetuKbn.WARNING, "不備種別区分");
        exClassificationEquals(hubiMsg.get(0).getHubisyubetusyousaikbn(), C_HubisyubetusyousaiKbn.NONE, "不備種別詳細区分");

        exClassificationEquals((C_KetsrhkosKbn)MockObjectManager.getArgument(SetHubiMsgMockForSinkeiyaku.class, "exec", 0, 0), C_KetsrhkosKbn.WARNING, "決定・成立保留更新区分");
        exStringEquals((String)MockObjectManager.getArgument(SetHubiMsgMockForSinkeiyaku.class, "exec", 0, 1), "WHC1023 予定利率が申込時点から上昇しています。申込日　10.00％　契約日　20.00％", "メッセージ文言");
        exClassificationEquals((C_TknKbn)MockObjectManager.getArgument(SetHubiMsgMockForSinkeiyaku.class, "exec", 0, 3), C_TknKbn.NONE, "特認区分");
        exClassificationEquals((C_MsgKbn)MockObjectManager.getArgument(SetHubiMsgMockForSinkeiyaku.class, "exec", 0, 4), C_MsgKbn.WARNING, "メッセージ区分");

    }

    @Test
    @Transactional
    @TestOrder(750)
    public void testExec_A75() {

        MockObjectManager.initialize();
        HanteiMoschkMockForSinkeiyaku.SYORIPTN = HanteiMoschkMockForSinkeiyaku.TESTPATTERN6;
        SetKisoKoumokuMockForSinkeiyaku.SYORIPTN = SetKisoKoumokuMockForSinkeiyaku.TESTPATTERN1;
        SetNenreiMockForSinkeiyaku.SYORIPTN = SetNenreiMockForSinkeiyaku.TESTPATTERN1;
        EditPdfYoteirirtuMockForSinkeiyaku.SYORIPTN = EditPdfYoteirirtuMockForSinkeiyaku.TESTPATTERN1;
        SetHubiMsgMockForSinkeiyaku.SYORIPTN = SetHubiMsgMockForSinkeiyaku.TESTPATTERN11;

        CheckHokenRyouYuukouKigen checkHokenRyouYuukouKigen = SWAKInjector.getInstance(CheckHokenRyouYuukouKigen.class);
        MosnaiCheckParam mosnaiCheckParam = SWAKInjector.getInstance(MosnaiCheckParam.class);

        sinkeiyakuDomManager.flush();
        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("860000272");
        List<HT_HubiMsg> hubiMsg = syoriCTL.getHubiMsgs();
        BM_SyouhnZokusei syouhnZokusei = bizDomManager.getSyouhnZokusei("ﾕｷ", 9);
        mosnaiCheckParam.setSyuSyouhnZokusei(syouhnZokusei);
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setSysDate(BizDate.valueOf("20160907"));
        mosnaiCheckParam.setListHubiMsg(hubiMsg);
        checkHokenRyouYuukouKigen.exec(mosnaiCheckParam);
        exNumericEquals(hubiMsg.size(), 1, "不備メッセージ件数");
        exStringEquals(hubiMsg.get(0).getHubimsg(), "予定利率が申込時点から低下しています。申込日　20.00％　契約日　10.00％", "不備メッセージ");
        exStringEquals(hubiMsg.get(0).getMessageId(), "WHC1024", "メッセージＩＤ");
        exStringEquals(hubiMsg.get(0).getMosno(), "860000272", "申込番号");
        exNumericEquals(hubiMsg.get(0).getRenno(), 1, "連番");
        exClassificationEquals(hubiMsg.get(0).getHubisyubetukbn(), C_HubisyubetuKbn.WARNING, "不備種別区分");
        exClassificationEquals(hubiMsg.get(0).getHubisyubetusyousaikbn(), C_HubisyubetusyousaiKbn.NONE, "不備種別詳細区分");

        exClassificationEquals((C_KetsrhkosKbn)MockObjectManager.getArgument(SetHubiMsgMockForSinkeiyaku.class, "exec", 0, 0), C_KetsrhkosKbn.WARNING, "決定・成立保留更新区分");
        exStringEquals((String)MockObjectManager.getArgument(SetHubiMsgMockForSinkeiyaku.class, "exec", 0, 1), "WHC1024 予定利率が申込時点から低下しています。申込日　20.00％　契約日　10.00％", "メッセージ文言");
        exClassificationEquals((C_TknKbn)MockObjectManager.getArgument(SetHubiMsgMockForSinkeiyaku.class, "exec", 0, 3), C_TknKbn.NONE, "特認区分");
        exClassificationEquals((C_MsgKbn)MockObjectManager.getArgument(SetHubiMsgMockForSinkeiyaku.class, "exec", 0, 4), C_MsgKbn.WARNING, "メッセージ区分");

    }

    @Test
    @Transactional
    @TestOrder(760)
    public void testExec_A76() {

        MockObjectManager.initialize();
        HanteiMoschkMockForSinkeiyaku.SYORIPTN = HanteiMoschkMockForSinkeiyaku.TESTPATTERN6;
        SetKisoKoumokuMockForSinkeiyaku.SYORIPTN = SetKisoKoumokuMockForSinkeiyaku.TESTPATTERN1;
        SetNenreiMockForSinkeiyaku.SYORIPTN = SetNenreiMockForSinkeiyaku.TESTPATTERN1;
        EditPdfYoteirirtuMockForSinkeiyaku.SYORIPTN = EditPdfYoteirirtuMockForSinkeiyaku.TESTPATTERN1;
        SetHubiMsgMockForSinkeiyaku.SYORIPTN = SetHubiMsgMockForSinkeiyaku.TESTPATTERN12;

        CheckHokenRyouYuukouKigen checkHokenRyouYuukouKigen = SWAKInjector.getInstance(CheckHokenRyouYuukouKigen.class);
        MosnaiCheckParam mosnaiCheckParam = SWAKInjector.getInstance(MosnaiCheckParam.class);

        sinkeiyakuDomManager.flush();
        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("860000280");
        List<HT_HubiMsg> hubiMsg = syoriCTL.getHubiMsgs();
        BM_SyouhnZokusei syouhnZokusei = bizDomManager.getSyouhnZokusei("ﾕｷ", 10);
        mosnaiCheckParam.setSyuSyouhnZokusei(syouhnZokusei);
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setSysDate(BizDate.valueOf("20160907"));
        mosnaiCheckParam.setListHubiMsg(hubiMsg);
        checkHokenRyouYuukouKigen.exec(mosnaiCheckParam);
        exNumericEquals(hubiMsg.size(), 1, "不備メッセージ件数");
        exStringEquals(hubiMsg.get(0).getHubimsg(), "予定利率が申込時点から低下しています。申込日　20.00％　契約日　10.00％", "不備メッセージ");
        exStringEquals(hubiMsg.get(0).getMessageId(), "WHC1024", "メッセージＩＤ");
        exStringEquals(hubiMsg.get(0).getMosno(), "860000280", "申込番号");
        exNumericEquals(hubiMsg.get(0).getRenno(), 1, "連番");
        exClassificationEquals(hubiMsg.get(0).getHubisyubetukbn(), C_HubisyubetuKbn.WARNING, "不備種別区分");
        exClassificationEquals(hubiMsg.get(0).getHubisyubetusyousaikbn(), C_HubisyubetusyousaiKbn.NONE, "不備種別詳細区分");

        exClassificationEquals((C_KetsrhkosKbn)MockObjectManager.getArgument(SetHubiMsgMockForSinkeiyaku.class, "exec", 0, 0), C_KetsrhkosKbn.WARNING, "決定・成立保留更新区分");
        exStringEquals((String)MockObjectManager.getArgument(SetHubiMsgMockForSinkeiyaku.class, "exec", 0, 1), "WHC1024 予定利率が申込時点から低下しています。申込日　20.00％　契約日　10.00％", "メッセージ文言");
        exClassificationEquals((C_TknKbn)MockObjectManager.getArgument(SetHubiMsgMockForSinkeiyaku.class, "exec", 0, 3), C_TknKbn.NONE, "特認区分");
        exClassificationEquals((C_MsgKbn)MockObjectManager.getArgument(SetHubiMsgMockForSinkeiyaku.class, "exec", 0, 4), C_MsgKbn.WARNING, "メッセージ区分");

    }

    @Test
    @Transactional
    @TestOrder(770)
    public void testExec_A77() {

        MockObjectManager.initialize();
        HanteiMoschkMockForSinkeiyaku.SYORIPTN = HanteiMoschkMockForSinkeiyaku.TESTPATTERN11;

        CheckHokenRyouYuukouKigen checkHokenRyouYuukouKigen = SWAKInjector.getInstance(CheckHokenRyouYuukouKigen.class);
        MosnaiCheckParam mosnaiCheckParam = SWAKInjector.getInstance(MosnaiCheckParam.class);

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("791112238");
        List<HT_HubiMsg> hubiMsg = syoriCTL.getHubiMsgs();
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        BM_SyouhnZokusei syouhnZokusei = bizDomManager.getSyouhnZokusei("ﾕｱ", 1);
        mosnaiCheckParam.setSyuSyouhnZokusei(syouhnZokusei);
        mosnaiCheckParam.setSysDate(BizDate.valueOf("20170907"));
        mosnaiCheckParam.setListHubiMsg(hubiMsg);
        checkHokenRyouYuukouKigen.exec(mosnaiCheckParam);
        exNumericEquals(hubiMsg.size(), 0, "不備メッセージ件数");

    }

}