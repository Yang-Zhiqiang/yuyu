package yuyu.common.sinkeiyaku.moschk;

import static yuyu.testinfr.YuyuFunctionTestUtil.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.dgic.testing.common.virtualmock.MockObjectManager;
import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.number.BizCurrency;
import jp.co.slcs.swak.util.message.MessageUtil;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.app.base.ref.TestDataMaker;
import yuyu.common.biz.exception.CommonBizAppException;
import yuyu.def.MessageId;
import yuyu.def.classification.C_ErrorKbn;
import yuyu.def.classification.C_KetsrhkosKbn;
import yuyu.def.classification.C_MsgKbn;
import yuyu.def.classification.C_PWaribikitekiyouKbn;
import yuyu.def.classification.C_SpKeisanKahiKbn;
import yuyu.def.classification.C_SysKbn;
import yuyu.def.classification.C_TknKbn;
import yuyu.def.classification.C_UmuKbn;
import yuyu.def.db.entity.BM_SyouhnZokusei;
import yuyu.def.db.entity.HT_MosKihon;
import yuyu.def.db.entity.HT_MosSyouhn;
import yuyu.def.db.entity.HT_SyoriCTL;
import yuyu.def.sinkeiyaku.manager.SinkeiyakuDomManager;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;
import yuyu.testinfr.inject.MockModuleBinder;

import com.google.inject.AbstractModule;

/**
 * SP設定のメソッド {@link SetSP#exec(MosnaiCheckParam)} テスト用クラスです。<br />
 */
@RunWith(OrderedRunner.class)
public class SetSPTest_exec {

    private final static String mosNo1 = "791112220";

    private final static String mosNo2 = "791112238";

    private final static String mosNo3 = "791112246";

    private final static String mosNo4 = "791112253";

    private final static String mosNo5 = "791112261";

    private final static String mosNo6 = "791112279";

    private final static String mosNo7 = "791112287";

    private final static String mosNo8 = "791112295";

    private final static String mosNo9 = "791112303";

    private final static String mosNo10 = "791112311";

    private final static String mosNo11 = "791112329";

    @Inject
    private MosnaiCheckParam mosnaiCheckParam;

    @Inject
    private SinkeiyakuDomManager sinkeiyakuDomManager;

    private final static String fileName = "UT_SP_単体テスト仕様書_SP設定";

    private final static String sheetName = "テストデータ";

    @Before
    public void before(){
        MockModuleBinder.bind(new AbstractModule(){
            @Override
            protected void configure() {
                bind(KeisanSP.class).to(KeisanSPMockForSinkeiyaku.class);
                bind(SetHubiMsg.class).to(SetHubiMsgMockForSinkeiyaku.class);
            }
        });
    }

    @BeforeClass
    public static void testInit(){
        KeisanSPMockForSinkeiyaku.caller = SetSPTest_exec.class;
        SetHubiMsgMockForSinkeiyaku.caller = SetSPTest_exec.class;
    }

    @AfterClass
    public static void testClear() {

        MockObjectManager.initialize();

        KeisanSPMockForSinkeiyaku.caller = null;
        SetHubiMsgMockForSinkeiyaku.caller = null;
        KeisanSPMockForSinkeiyaku.SYORIPTN = null;
        SetHubiMsgMockForSinkeiyaku.SYORIPTN = null;
    }
    @BeforeClass
    @Transactional
    public static void insertTestData() {
        try {
            TestDataMaker testDataMaker = new TestDataMaker();
            HashMap<String, Map<String, List<Map<String, String>>>> testDataAndTblMap;
            testDataAndTblMap = testDataMaker.getInData(SetSPTest_exec.class, fileName, sheetName);
            testDataMaker.insDataByDataId("データ001", testDataAndTblMap);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @AfterClass
    @Transactional
    public static void deleteTestData() {
        SinkeiyakuDomManager sinkeiyakuDomManager = SWAKInjector.getInstance(SinkeiyakuDomManager.class);
        sinkeiyakuDomManager.delete(sinkeiyakuDomManager.getAllSyoriCTL());

    }

    @Test(expected = CommonBizAppException.class)
    @Transactional
    @TestOrder(10)
    public void testExec_A1() {
        MockObjectManager.initialize();
        KeisanSPMockForSinkeiyaku.SYORIPTN = KeisanSPMockForSinkeiyaku.TESTPATTERN1;
        HT_SyoriCTL syoriCTL =  sinkeiyakuDomManager.getSyoriCTL(mosNo1);

        syoriCTL.setKthhbkbn(C_UmuKbn.NONE);

        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setSysKbn(C_SysKbn.SKEI);

        try{
            SetSP setSP = SWAKInjector.getInstance(SetSP.class);
            setSP.exec(mosnaiCheckParam);
        }
        catch (CommonBizAppException e) {

            exStringEquals(e.getMessage(), "システム整合性エラーです。申込番号=791112220", "エラーメッセージ");
            throw e;
        }
    }

    @Test
    @Transactional
    @TestOrder(20)
    public void testExec_A2() {
        MockObjectManager.initialize();
        KeisanSPMockForSinkeiyaku.SYORIPTN = KeisanSPMockForSinkeiyaku.TESTPATTERN1;
        SetHubiMsgMockForSinkeiyaku.SYORIPTN = null;
        HT_SyoriCTL syoriCTL =  sinkeiyakuDomManager.getSyoriCTL(mosNo2);
        HT_MosKihon mosKihon = syoriCTL.getMosKihon();
        SetSP setSP = SWAKInjector.getInstance(SetSP.class);

        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setSysKbn(C_SysKbn.ESHIEN);
        mosnaiCheckParam.setKosID("user001");
        mosnaiCheckParam.setKosTime("20150603111400000");
        setSP.exec(mosnaiCheckParam);

        exBizCalcbleEquals(mosKihon.getSeitoufstpkei(), BizCurrency.valueOf(100), "正当初回Ｐ合計金額");
        exBizCalcbleEquals(mosKihon.getFstphrkgk(), BizCurrency.valueOf(100), "初回Ｐ払込必要額");
        exBizCalcbleEquals(mosKihon.getHeijyunp(), BizCurrency.valueOf(15000), "平準払Ｐ");
        exBizCalcbleEquals(mosKihon.getHeijyunpryoumasinasi(), BizCurrency.valueOf(100), "平準払Ｐ(料増除)");
        exBizCalcbleEquals(mosKihon.getIkkatup(), BizCurrency.valueOf(100), "一括払Ｐ");
        exBizCalcbleEquals(mosKihon.getZennoup(), BizCurrency.valueOf(100), "前納Ｐ");
        exBizCalcbleEquals(mosKihon.getZennoujyuutoup(), BizCurrency.valueOf(100), "前納年払充当Ｐ");
        exBizCalcbleEquals(mosKihon.getHyouteip(), BizCurrency.valueOf(80), "表定Ｐ");
        exBizCalcbleEquals(mosKihon.getPharaikomisougaku(), BizCurrency.valueOf(100), "保険料払込総額");
        exClassificationEquals(mosKihon.getPwaribikitekiyoukbn(), C_PWaribikitekiyouKbn.NONE, "保険料割引適用区分");

        exClassificationEquals(setSP.getiErrorKbn(), C_ErrorKbn.OK, "エラー区分");

        MosnaiCheckParam mosnaiCheckParamtemp = (MosnaiCheckParam) MockObjectManager.getArgument(KeisanSPMockForSinkeiyaku.class, "exec", 0, 0);
        exStringEquals( mosnaiCheckParamtemp.getDataSyoriControl().getMosno(), mosNo2, "申込番号");
        exClassificationEquals( mosnaiCheckParamtemp.getSysKbn(), C_SysKbn.ESHIEN, "システム区分");
        exStringEquals( mosnaiCheckParamtemp.getKosID(), "user001", "更新者ＩＤ");
        exStringEquals( mosnaiCheckParamtemp.getKosTime(), "20150603111400000", "更新時間");

        MockObjectManager.assertArgumentPassed(SetHubiMsgMockForSinkeiyaku.class, "exec", 0, C_KetsrhkosKbn.KETHORYU_HUBI);
        MockObjectManager.assertArgumentPassed(SetHubiMsgMockForSinkeiyaku.class, "exec", 1, MessageId.EHC0125 + " " + MessageUtil.getMessage(MessageId.EHC0125));
        MosnaiCheckParam mosnaiCheckParamtemp1 = (MosnaiCheckParam) MockObjectManager.getArgument(SetHubiMsgMockForSinkeiyaku.class, "exec", 0, 2);
        exStringEquals( mosnaiCheckParamtemp1.getDataSyoriControl().getMosno(), mosNo2, "申込番号");
        exClassificationEquals( mosnaiCheckParamtemp1.getSysKbn(), C_SysKbn.ESHIEN, "システム区分");
        exStringEquals( mosnaiCheckParamtemp1.getKosID(), "user001", "更新者ＩＤ");
        exStringEquals( mosnaiCheckParamtemp1.getKosTime(), "20150603111400000", "更新時間");
        MockObjectManager.assertArgumentPassed(SetHubiMsgMockForSinkeiyaku.class, "exec", 3, C_TknKbn.NONE);
        MockObjectManager.assertArgumentPassed(SetHubiMsgMockForSinkeiyaku.class, "exec", 4, C_MsgKbn.ERROR);
    }

    @Test
    @Transactional
    @TestOrder(30)
    public void testExec_A3() {
        KeisanSPMockForSinkeiyaku.SYORIPTN = KeisanSPMockForSinkeiyaku.TESTPATTERN6;
        HT_SyoriCTL syoriCTL =  sinkeiyakuDomManager.getSyoriCTL(mosNo3);
        HT_MosKihon mosKihon = syoriCTL.getMosKihon();
        HT_MosSyouhn mosSyouhn = syoriCTL.getMosSyouhnBySyouhncd("ﾕﾁ");
        BM_SyouhnZokusei syouhnZokusei = mosSyouhn.getSyouhnZokusei();
        SetSP setSP = SWAKInjector.getInstance(SetSP.class);

        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setSysKbn(C_SysKbn.ESHIEN);
        mosnaiCheckParam.setSyuSyouhnZokusei(syouhnZokusei);
        setSP.exec(mosnaiCheckParam);

        exBizCalcbleEquals(mosKihon.getSeitoufstpkei(), BizCurrency.valueOf(100), "正当初回Ｐ合計金額");
        exBizCalcbleEquals(mosKihon.getFstphrkgk(), BizCurrency.valueOf(100), "初回Ｐ払込必要額");
        exBizCalcbleEquals(mosKihon.getHeijyunp(), BizCurrency.valueOf(14999.9), "平準払Ｐ");
        exBizCalcbleEquals(mosKihon.getHeijyunpryoumasinasi(), BizCurrency.valueOf(100), "平準払Ｐ(料増除)");
        exBizCalcbleEquals(mosKihon.getIkkatup(), BizCurrency.valueOf(100), "一括払Ｐ");
        exBizCalcbleEquals(mosKihon.getZennoup(), BizCurrency.valueOf(100), "前納Ｐ");
        exBizCalcbleEquals(mosKihon.getZennoujyuutoup(), BizCurrency.valueOf(100), "前納年払充当Ｐ");
        exBizCalcbleEquals(mosKihon.getHyouteip(), BizCurrency.valueOf(80), "表定Ｐ");
        exBizCalcbleEquals(mosKihon.getPharaikomisougaku(), BizCurrency.valueOf(100), "保険料払込総額");
        exClassificationEquals(mosKihon.getPwaribikitekiyoukbn(), C_PWaribikitekiyouKbn.PWARISEIDO_RANK01, "保険料割引適用区分");

        exNumericEquals(mosnaiCheckParam.getListKekkaGmnMsg().size(), 0, "結果画面ＭＳＧの件数");

    }

    @Test
    @Transactional
    @TestOrder(40)
    public void testExec_A4() {
        KeisanSPMockForSinkeiyaku.SYORIPTN = KeisanSPMockForSinkeiyaku.TESTPATTERN3;
        HT_SyoriCTL syoriCTL =  sinkeiyakuDomManager.getSyoriCTL(mosNo4);
        HT_MosKihon mosKihon = syoriCTL.getMosKihon();
        HT_MosSyouhn mosSyouhn = syoriCTL.getMosSyouhnBySyouhncd("ﾕﾁ");
        BM_SyouhnZokusei syouhnZokusei = mosSyouhn.getSyouhnZokusei();
        SetSP setSP = SWAKInjector.getInstance(SetSP.class);

        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setSysKbn(C_SysKbn.ESHIEN);
        mosnaiCheckParam.setSyuSyouhnZokusei(syouhnZokusei);
        setSP.exec(mosnaiCheckParam);

        exBizCalcbleEquals(mosKihon.getSeitoufstpkei(), BizCurrency.valueOf(100), "正当初回Ｐ合計金額");
        exBizCalcbleEquals(mosKihon.getFstphrkgk(), BizCurrency.valueOf(100), "初回Ｐ払込必要額");
        exBizCalcbleEquals(mosKihon.getHeijyunp(), BizCurrency.valueOf(90001), "平準払Ｐ");
        exBizCalcbleEquals(mosKihon.getHeijyunpryoumasinasi(), BizCurrency.valueOf(100), "平準払Ｐ(料増除)");
        exBizCalcbleEquals(mosKihon.getIkkatup(), BizCurrency.valueOf(100), "一括払Ｐ");
        exBizCalcbleEquals(mosKihon.getZennoup(), BizCurrency.valueOf(100), "前納Ｐ");
        exBizCalcbleEquals(mosKihon.getZennoujyuutoup(), BizCurrency.valueOf(100), "前納年払充当Ｐ");
        exBizCalcbleEquals(mosKihon.getHyouteip(), BizCurrency.valueOf(80), "表定Ｐ");
        exBizCalcbleEquals(mosKihon.getPharaikomisougaku(), BizCurrency.valueOf(100), "保険料払込総額");
        exClassificationEquals(mosKihon.getPwaribikitekiyoukbn(), C_PWaribikitekiyouKbn.PWARISEIDO_RANK01, "保険料割引適用区分");

    }

    @Test
    @Transactional
    @TestOrder(50)
    public void testExec_A5() {
        MockObjectManager.initialize();
        KeisanSPMockForSinkeiyaku.SYORIPTN = KeisanSPMockForSinkeiyaku.TESTPATTERN2;
        HT_SyoriCTL syoriCTL =  sinkeiyakuDomManager.getSyoriCTL(mosNo5);
        HT_MosKihon mosKihon = syoriCTL.getMosKihon();
        HT_MosSyouhn mosSyouhn = syoriCTL.getMosSyouhnBySyouhncd("ﾕﾁ");
        BM_SyouhnZokusei syouhnZokusei = mosSyouhn.getSyouhnZokusei();
        SetSP setSP = SWAKInjector.getInstance(SetSP.class);

        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setSysKbn(C_SysKbn.SKEI);
        mosnaiCheckParam.setSyuSyouhnZokusei(syouhnZokusei);
        setSP.exec(mosnaiCheckParam);

        exBizCalcbleEquals(mosKihon.getSeitoufstpkei(), BizCurrency.valueOf(101), "正当初回Ｐ合計金額");
        exBizCalcbleEquals(mosKihon.getFstphrkgk(), BizCurrency.valueOf(102), "初回Ｐ払込必要額");
        exBizCalcbleEquals(mosKihon.getHeijyunp(), BizCurrency.valueOf(30000), "平準払Ｐ");
        exBizCalcbleEquals(mosKihon.getHeijyunpryoumasinasi(), BizCurrency.valueOf(103), "平準払Ｐ(料増除)");
        exBizCalcbleEquals(mosKihon.getIkkatup(), BizCurrency.valueOf(104), "一括払Ｐ");
        exBizCalcbleEquals(mosKihon.getZennoup(), BizCurrency.valueOf(105), "前納Ｐ");
        exBizCalcbleEquals(mosKihon.getZennoujyuutoup(), BizCurrency.valueOf(106), "前納年払充当Ｐ");
        exBizCalcbleEquals(mosKihon.getHyouteip(), BizCurrency.valueOf(87), "表定Ｐ");
        exBizCalcbleEquals(mosKihon.getPharaikomisougaku(), BizCurrency.valueOf(108), "保険料払込総額");
        exClassificationEquals(mosKihon.getPwaribikitekiyoukbn(), C_PWaribikitekiyouKbn.PWARISEIDO_RANK02, "保険料割引適用区分");

        MockObjectManager.assertNotCalled(SetHubiMsgMockForSinkeiyaku.class, "exec");

    }

    @Test
    @Transactional
    @TestOrder(60)
    public void testExec_A6() {
        MockObjectManager.initialize();
        KeisanSPMockForSinkeiyaku.SYORIPTN = KeisanSPMockForSinkeiyaku.TESTPATTERN1;
        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL(mosNo6);
        HT_MosKihon mosKihon = syoriCTL.getMosKihon();
        SetSP setSP = SWAKInjector.getInstance(SetSP.class);

        mosnaiCheckParam.setKthjiSpKeisanKahiKbn(C_SpKeisanKahiKbn.SPKEISANKA);
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setSysKbn(C_SysKbn.SKEI);
        mosnaiCheckParam.setKosID("user001");
        mosnaiCheckParam.setKosTime("20150603111400000");
        setSP.exec(mosnaiCheckParam);

        exBizCalcbleEquals(mosKihon.getSeitoufstpkei(), BizCurrency.valueOf(100), "正当初回Ｐ合計金額");
        exBizCalcbleEquals(mosKihon.getFstphrkgk(), BizCurrency.valueOf(100), "初回Ｐ払込必要額");
        exBizCalcbleEquals(mosKihon.getHeijyunp(), BizCurrency.valueOf(15000), "平準払Ｐ");
        exBizCalcbleEquals(mosKihon.getHeijyunpryoumasinasi(), BizCurrency.valueOf(100), "平準払Ｐ(料増除)");
        exBizCalcbleEquals(mosKihon.getIkkatup(), BizCurrency.valueOf(100), "一括払Ｐ");
        exBizCalcbleEquals(mosKihon.getZennoup(), BizCurrency.valueOf(100), "前納Ｐ");
        exBizCalcbleEquals(mosKihon.getZennoujyuutoup(), BizCurrency.valueOf(100), "前納年払充当Ｐ");
        exBizCalcbleEquals(mosKihon.getHyouteip(), BizCurrency.valueOf(80), "表定Ｐ");
        exBizCalcbleEquals(mosKihon.getPharaikomisougaku(), BizCurrency.valueOf(100), "保険料払込総額");
        exClassificationEquals(mosKihon.getPwaribikitekiyoukbn(), C_PWaribikitekiyouKbn.NONE, "保険料割引適用区分");

        MockObjectManager.assertArgumentPassed(SetHubiMsgMockForSinkeiyaku.class, "exec", 0, C_KetsrhkosKbn.WARNING);
        MockObjectManager.assertArgumentPassed(SetHubiMsgMockForSinkeiyaku.class, "exec", 1, MessageId.WHC1014 + " " + MessageUtil.getMessage(MessageId.WHC1014));
        MosnaiCheckParam mosnaiCheckParamtemp1 = (MosnaiCheckParam) MockObjectManager.getArgument(SetHubiMsgMockForSinkeiyaku.class, "exec", 0, 2);
        exStringEquals( mosnaiCheckParamtemp1.getDataSyoriControl().getMosno(), mosNo6, "申込番号");
        exClassificationEquals( mosnaiCheckParamtemp1.getSysKbn(), C_SysKbn.SKEI, "システム区分");
        exStringEquals( mosnaiCheckParamtemp1.getKosID(), "user001", "更新者ＩＤ");
        exStringEquals( mosnaiCheckParamtemp1.getKosTime(), "20150603111400000", "更新時間");
        MockObjectManager.assertArgumentPassed(SetHubiMsgMockForSinkeiyaku.class, "exec", 3, C_TknKbn.NONE);
        MockObjectManager.assertArgumentPassed(SetHubiMsgMockForSinkeiyaku.class, "exec", 4, C_MsgKbn.WARNING);
        exClassificationEquals(mosnaiCheckParam.getKthjiSpKeisanKahiKbn(), C_SpKeisanKahiKbn.SPKEISANHUKA, "ＳＰ計算可否区分");
    }

    @Test(expected = CommonBizAppException.class)
    @Transactional
    @TestOrder(70)
    public void testExec_A7() {
        MockObjectManager.initialize();
        KeisanSPMockForSinkeiyaku.SYORIPTN = KeisanSPMockForSinkeiyaku.TESTPATTERN1;
        HT_SyoriCTL syoriCTL =  sinkeiyakuDomManager.getSyoriCTL(mosNo7);
        SetSP setSP = SWAKInjector.getInstance(SetSP.class);

        syoriCTL.setKthhbkbn(C_UmuKbn.ARI);
        mosnaiCheckParam.setKthjiSpKeisanKahiKbn(C_SpKeisanKahiKbn.SPKEISANHUKA);
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setSysKbn(C_SysKbn.SKEI);
        try{
            setSP.exec(mosnaiCheckParam);
        }
        catch (CommonBizAppException e) {

            exStringEquals(e.getMessage(), "システム整合性エラーです。申込番号=791112287", "エラーメッセージ");
            throw e;
        }
    }

    @Test
    @Transactional
    @TestOrder(80)
    public void testExec_A8() {
        KeisanSPMockForSinkeiyaku.SYORIPTN = KeisanSPMockForSinkeiyaku.TESTPATTERN4;
        HT_SyoriCTL syoriCTL =  sinkeiyakuDomManager.getSyoriCTL(mosNo8);
        HT_MosKihon mosKihon = syoriCTL.getMosKihon();
        HT_MosSyouhn mosSyouhn = syoriCTL.getMosSyouhnBySyouhncd("ﾕﾁ");
        BM_SyouhnZokusei syouhnZokusei = mosSyouhn.getSyouhnZokusei();
        SetSP setSP = SWAKInjector.getInstance(SetSP.class);

        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setSysKbn(C_SysKbn.SKEI);
        mosnaiCheckParam.setSyuSyouhnZokusei(syouhnZokusei);
        setSP.exec(mosnaiCheckParam);

        exBizCalcbleEquals(mosKihon.getSeitoufstpkei(), BizCurrency.valueOf(100), "正当初回Ｐ合計金額");
        exBizCalcbleEquals(mosKihon.getFstphrkgk(), BizCurrency.valueOf(100), "初回Ｐ払込必要額");
        exBizCalcbleEquals(mosKihon.getHeijyunp(), BizCurrency.valueOf(179986), "平準払Ｐ");
        exBizCalcbleEquals(mosKihon.getHeijyunpryoumasinasi(), BizCurrency.valueOf(100), "平準払Ｐ(料増除)");
        exBizCalcbleEquals(mosKihon.getIkkatup(), BizCurrency.valueOf(100), "一括払Ｐ");
        exBizCalcbleEquals(mosKihon.getZennoup(), BizCurrency.valueOf(100), "前納Ｐ");
        exBizCalcbleEquals(mosKihon.getZennoujyuutoup(), BizCurrency.valueOf(100), "前納年払充当Ｐ");
        exBizCalcbleEquals(mosKihon.getHyouteip(), BizCurrency.valueOf(80), "表定Ｐ");
        exBizCalcbleEquals(mosKihon.getPharaikomisougaku(), BizCurrency.valueOf(100), "保険料払込総額");
        exClassificationEquals(mosKihon.getPwaribikitekiyoukbn(), C_PWaribikitekiyouKbn.PWARISEIDO_NONE, "保険料割引適用区分");

    }

    @Test
    @Transactional
    @TestOrder(90)
    public void testExec_A9() {
        KeisanSPMockForSinkeiyaku.SYORIPTN = KeisanSPMockForSinkeiyaku.TESTPATTERN5;
        HT_SyoriCTL syoriCTL =  sinkeiyakuDomManager.getSyoriCTL(mosNo9);
        HT_MosKihon mosKihon = syoriCTL.getMosKihon();
        HT_MosSyouhn mosSyouhn = syoriCTL.getMosSyouhnBySyouhncd("ﾕﾁ");
        BM_SyouhnZokusei syouhnZokusei = mosSyouhn.getSyouhnZokusei();
        SetSP setSP = SWAKInjector.getInstance(SetSP.class);

        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setSysKbn(C_SysKbn.SKEI);
        mosnaiCheckParam.setSyuSyouhnZokusei(syouhnZokusei);
        setSP.exec(mosnaiCheckParam);

        exBizCalcbleEquals(mosKihon.getSeitoufstpkei(), BizCurrency.valueOf(100), "正当初回Ｐ合計金額");
        exBizCalcbleEquals(mosKihon.getFstphrkgk(), BizCurrency.valueOf(100), "初回Ｐ払込必要額");
        exBizCalcbleEquals(mosKihon.getHeijyunp(), BizCurrency.valueOf(30000.5), "平準払Ｐ");
        exBizCalcbleEquals(mosKihon.getHeijyunpryoumasinasi(), BizCurrency.valueOf(100), "平準払Ｐ(料増除)");
        exBizCalcbleEquals(mosKihon.getIkkatup(), BizCurrency.valueOf(100), "一括払Ｐ");
        exBizCalcbleEquals(mosKihon.getZennoup(), BizCurrency.valueOf(100), "前納Ｐ");
        exBizCalcbleEquals(mosKihon.getZennoujyuutoup(), BizCurrency.valueOf(100), "前納年払充当Ｐ");
        exBizCalcbleEquals(mosKihon.getHyouteip(), BizCurrency.valueOf(80), "表定Ｐ");
        exBizCalcbleEquals(mosKihon.getPharaikomisougaku(), BizCurrency.valueOf(100), "保険料払込総額");
        exClassificationEquals(mosKihon.getPwaribikitekiyoukbn(), C_PWaribikitekiyouKbn.PWARISEIDO_RANK02, "保険料割引適用区分");

    }

    @Test
    @Transactional
    @TestOrder(100)
    public void testExec_A10() {
        KeisanSPMockForSinkeiyaku.SYORIPTN = KeisanSPMockForSinkeiyaku.TESTPATTERN7;
        HT_SyoriCTL syoriCTL =  sinkeiyakuDomManager.getSyoriCTL(mosNo10);
        HT_MosKihon mosKihon = syoriCTL.getMosKihon();
        HT_MosSyouhn mosSyouhn = syoriCTL.getMosSyouhnBySyouhncd("ﾕﾁ");
        BM_SyouhnZokusei syouhnZokusei = mosSyouhn.getSyouhnZokusei();
        SetSP setSP = SWAKInjector.getInstance(SetSP.class);

        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setSysKbn(C_SysKbn.SKEI);
        mosnaiCheckParam.setSyuSyouhnZokusei(syouhnZokusei);
        setSP.exec(mosnaiCheckParam);

        exBizCalcbleEquals(mosKihon.getSeitoufstpkei(), BizCurrency.valueOf(100), "正当初回Ｐ合計金額");
        exBizCalcbleEquals(mosKihon.getFstphrkgk(), BizCurrency.valueOf(100), "初回Ｐ払込必要額");
        exBizCalcbleEquals(mosKihon.getHeijyunp(), BizCurrency.valueOf(29998.6), "平準払Ｐ");
        exBizCalcbleEquals(mosKihon.getHeijyunpryoumasinasi(), BizCurrency.valueOf(100), "平準払Ｐ(料増除)");
        exBizCalcbleEquals(mosKihon.getIkkatup(), BizCurrency.valueOf(100), "一括払Ｐ");
        exBizCalcbleEquals(mosKihon.getZennoup(), BizCurrency.valueOf(100), "前納Ｐ");
        exBizCalcbleEquals(mosKihon.getZennoujyuutoup(), BizCurrency.valueOf(100), "前納年払充当Ｐ");
        exBizCalcbleEquals(mosKihon.getHyouteip(), BizCurrency.valueOf(80), "表定Ｐ");
        exBizCalcbleEquals(mosKihon.getPharaikomisougaku(), BizCurrency.valueOf(100), "保険料払込総額");
        exClassificationEquals(mosKihon.getPwaribikitekiyoukbn(), C_PWaribikitekiyouKbn.PWARISEIDO_RANK01, "保険料割引適用区分");

    }

    @Test
    @Transactional
    @TestOrder(110)
    public void testExec_A11() {
        KeisanSPMockForSinkeiyaku.SYORIPTN = KeisanSPMockForSinkeiyaku.TESTPATTERN5;
        HT_SyoriCTL syoriCTL =  sinkeiyakuDomManager.getSyoriCTL(mosNo11);
        HT_MosKihon mosKihon = syoriCTL.getMosKihon();
        HT_MosSyouhn mosSyouhn = syoriCTL.getMosSyouhnBySyouhncd("ﾕﾁ");
        BM_SyouhnZokusei syouhnZokusei = mosSyouhn.getSyouhnZokusei();
        SetSP setSP = SWAKInjector.getInstance(SetSP.class);

        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setSysKbn(C_SysKbn.SKEI);
        mosnaiCheckParam.setSyuSyouhnZokusei(syouhnZokusei);
        setSP.exec(mosnaiCheckParam);

        exBizCalcbleEquals(mosKihon.getSeitoufstpkei(), BizCurrency.valueOf(100), "正当初回Ｐ合計金額");
        exBizCalcbleEquals(mosKihon.getFstphrkgk(), BizCurrency.valueOf(100), "初回Ｐ払込必要額");
        exBizCalcbleEquals(mosKihon.getHeijyunp(), BizCurrency.valueOf(30000.5), "平準払Ｐ");
        exBizCalcbleEquals(mosKihon.getHeijyunpryoumasinasi(), BizCurrency.valueOf(100), "平準払Ｐ(料増除)");
        exBizCalcbleEquals(mosKihon.getIkkatup(), BizCurrency.valueOf(100), "一括払Ｐ");
        exBizCalcbleEquals(mosKihon.getZennoup(), BizCurrency.valueOf(100), "前納Ｐ");
        exBizCalcbleEquals(mosKihon.getZennoujyuutoup(), BizCurrency.valueOf(100), "前納年払充当Ｐ");
        exBizCalcbleEquals(mosKihon.getHyouteip(), BizCurrency.valueOf(80), "表定Ｐ");
        exBizCalcbleEquals(mosKihon.getPharaikomisougaku(), BizCurrency.valueOf(100), "保険料払込総額");
        exClassificationEquals(mosKihon.getPwaribikitekiyoukbn(), C_PWaribikitekiyouKbn.PWARISEIDO_NONE, "保険料割引適用区分");

    }
}
