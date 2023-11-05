package yuyu.common.sinkeiyaku.moschk;

import static yuyu.testinfr.YuyuFunctionTestUtil.*;

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
import yuyu.common.biz.bzcommon.GetBunsyoNo;
import yuyu.common.biz.bzcommon.GetBunsyoNoMockForSinkeiyaku;
import yuyu.def.classification.C_AisyoumeiKbn;
import yuyu.def.classification.C_Channelcd;
import yuyu.def.classification.C_HubisyubetuKbn;
import yuyu.def.classification.C_SysKbn;
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
 * 約款受領方法チェックのメソッド {@link CheckYakkanJyuryouHouhou#exec(MosnaiCheckParam)} テスト用クラスです。<br />
 */
@RunWith(OrderedRunner.class)
public class CheckYakkanJyuryouHouhouTest_exec {

    private final static String mosNo1 = "860000017";

    private final static String mosNo2 = "860000025";

    private final static String mosNo3 = "860000033";

    private final static String mosNo4 = "860000041";

    private final static String mosNo5 = "860000058";

    private final static String mosNo6 = "860000066";

    private final static String mosNo7 = "860000074";

    private final static String mosNo8 = "860000082";

    private final static String mosNo9 = "860000090";

    private final static String mosNo10 = "860000108";

    private final static String mosNo11 = "791112253";

    private final static String mosNo12 = "791112261";

    private final static String mosNo13 = "791112279";

    private final static String mosNo14 = "791112287";

    private final static String mosNo15 = "791112295";

    private final static String mosNo16 = "791112303";

    private final static String mosNo17 = "791112220";

    private final static String mosNo18 = "791112238";

    private final static String mosNo19 = "860000488";

    private final static String mosNo20 = "860000496";

    private final static String mosNo21 = "860000504";

    private final static String fileName = "UT-SP_単体テスト仕様書（共通）_約款受領方法チェック";

    private final static String sheetName = "INデータ";

    @Inject
    private CheckYakkanJyuryouHouhou checkYakkanJyuryouHouhou;

    @Inject
    private MosnaiCheckParam mosnaiCheckParam;

    @Inject
    private SinkeiyakuDomManager sinkeiyakuDomManager;

    @Before
    public void Before () {
        MockModuleBinder.bind(new AbstractModule() {
            @Override
            protected void configure() {
                bind(GetBunsyoNo.class).to(GetBunsyoNoMockForSinkeiyaku.class);
            }
        });
    }
    @BeforeClass
    public static void testInit(){
        MockObjectManager.initialize();
        GetBunsyoNoMockForSinkeiyaku.caller = CheckYakkanJyuryouHouhouTest_exec.class;
    }


    @AfterClass
    public static void testClear() {
        MockObjectManager.initialize();
        GetBunsyoNoMockForSinkeiyaku.caller = null;
        GetBunsyoNoMockForSinkeiyaku.SYORIPTN = null;
    }

    @BeforeClass
    @Transactional
    public static void insertTestData() {

        try {
            TestDataMaker testDataMaker = new TestDataMaker();
            HashMap<String, Map<String, List<Map<String, String>>>> testDataAndTblMap;
            testDataAndTblMap = testDataMaker.getInData(CheckNkUktKbnTest_exec.class, fileName, sheetName);
            testDataMaker.insDataByDataId("データ001", testDataAndTblMap);
        } catch (TestDataMakerException e) {

            e.printStackTrace();
        }}

    @AfterClass
    @Transactional
    public static void deleteTestData() {

        SinkeiyakuDomManager sinkeiyakuDomManager = SWAKInjector.getInstance(SinkeiyakuDomManager.class);
        sinkeiyakuDomManager.delete(sinkeiyakuDomManager.getAllSyoriCTL());
    }

    @Test
    @Transactional
    @TestOrder(10)
    public void testExec_A1() {
        mosnaiCheckParam.setSysKbn(C_SysKbn.ESHIEN);

        checkYakkanJyuryouHouhou.exec(mosnaiCheckParam);

        List<HT_HubiMsg> hubiMsg = mosnaiCheckParam.getListHubiMsg();
        exNumericEquals(hubiMsg.size(), 0, "件数");
    }

    @Test
    @Transactional
    @TestOrder(20)
    public void testExec_A2() {
        MockObjectManager.initialize();
        GetBunsyoNoMockForSinkeiyaku.SYORIPTN = GetBunsyoNoMockForSinkeiyaku.TESTPATTERN2;
        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL(mosNo1);
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setSysKbn(C_SysKbn.SKEI);

        checkYakkanJyuryouHouhou.exec(mosnaiCheckParam);

        List<HT_HubiMsg> hubiMsg = mosnaiCheckParam.getListHubiMsg();
        exNumericEquals(hubiMsg.size(), 0, "件数");

        HT_MosKihon mosKihon = mosnaiCheckParam.getDataSyoriControl().getMosKihon();

        exStringEquals(mosKihon.getYakkanbunsyono(), "", "約款文書番号");

        exStringEquals(mosKihon.getSiorino(), "", "しおり番号");

    }

    @Test
    @Transactional
    @TestOrder(30)
    public void testExec_A3() {
        MockObjectManager.initialize();
        GetBunsyoNoMockForSinkeiyaku.SYORIPTN = GetBunsyoNoMockForSinkeiyaku.TESTPATTERN1;
        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL(mosNo2);
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setSysKbn(C_SysKbn.SKEI);

        BM_SyouhnZokusei syouhnZokusei = new BM_SyouhnZokusei();

        syouhnZokusei.setSyouhncd("ﾕｵ");
        mosnaiCheckParam.setSyuSyouhnZokusei(syouhnZokusei);

        checkYakkanJyuryouHouhou.exec(mosnaiCheckParam);

        List<HT_HubiMsg> hubiMsg = mosnaiCheckParam.getListHubiMsg();
        exNumericEquals(hubiMsg.size(), 1, "件数");
        exStringEquals(hubiMsg.get(0).getMosno(), mosNo2, "申込番号");
        exNumericEquals(hubiMsg.get(0).getRenno(), 1, "連番");
        exStringEquals(hubiMsg.get(0).getMessageId(), "EBC0012", "メッセージＩＤ");
        exStringEquals(hubiMsg.get(0).getHubimsg(), "約款受領方法の入力は不要です。", "不備メッセージ");
        exClassificationEquals(hubiMsg.get(0).getHubisyubetukbn(), C_HubisyubetuKbn.SRHORYU_HUBI, "不備種別区分");

        HT_MosKihon mosKihon = mosnaiCheckParam.getDataSyoriControl().getMosKihon();

        exStringEquals(mosKihon.getYakkanbunsyono(), "100000000001", "約款文書番号");

        exStringEquals(mosKihon.getSiorino(), "111", "しおり番号");

    }

    @Test
    @Transactional
    @TestOrder(40)
    public void testExec_A4() {
        MockObjectManager.initialize();
        GetBunsyoNoMockForSinkeiyaku.SYORIPTN = GetBunsyoNoMockForSinkeiyaku.TESTPATTERN1;
        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL(mosNo3);
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setSysKbn(C_SysKbn.SKEI);

        BM_SyouhnZokusei syouhnZokusei = new BM_SyouhnZokusei();
        syouhnZokusei.setSyouhncd("ﾕｵ");
        mosnaiCheckParam.setSyuSyouhnZokusei(syouhnZokusei);

        checkYakkanJyuryouHouhou.exec(mosnaiCheckParam);

        List<HT_HubiMsg> hubiMsg = mosnaiCheckParam.getListHubiMsg();

        exNumericEquals(hubiMsg.size(), 0, "件数");

        HT_MosKihon mosKihon = mosnaiCheckParam.getDataSyoriControl().getMosKihon();

        exStringEquals(mosKihon.getYakkanbunsyono(), "100000000001", "約款文書番号");

        exStringEquals(mosKihon.getSiorino(), "111", "しおり番号");

        exClassificationEquals((C_AisyoumeiKbn)MockObjectManager.getArgument(GetBunsyoNoMockForSinkeiyaku.class, "execGetYakkanBunsyoNo", 0, 0), C_AisyoumeiKbn.GAIKARIRITUHENDOUNK_MDHN, "愛称名区分");
        exClassificationEquals((C_Channelcd)MockObjectManager.getArgument(GetBunsyoNoMockForSinkeiyaku.class, "execGetYakkanBunsyoNo", 0, 1), null, "チャネルコード");
        exStringEquals((String)MockObjectManager.getArgument(GetBunsyoNoMockForSinkeiyaku.class, "execGetYakkanBunsyoNo", 0, 2), "3000898", "親代理店コード");
        exDateEquals((BizDate)MockObjectManager.getArgument(GetBunsyoNoMockForSinkeiyaku.class, "execGetYakkanBunsyoNo", 0, 3), BizDate.valueOf(20190514), "申込日");

    }

    @Test
    @Transactional
    @TestOrder(50)
    public void testExec_A5() {
        MockObjectManager.initialize();
        GetBunsyoNoMockForSinkeiyaku.SYORIPTN = GetBunsyoNoMockForSinkeiyaku.TESTPATTERN1;

        HT_SyoriCTL syoriCTL =  sinkeiyakuDomManager.getSyoriCTL(mosNo4);
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setSysKbn(C_SysKbn.SKEI);

        BM_SyouhnZokusei syouhnZokusei = new BM_SyouhnZokusei();
        syouhnZokusei.setSyouhncd("ﾕｵ");
        mosnaiCheckParam.setSyuSyouhnZokusei(syouhnZokusei);

        checkYakkanJyuryouHouhou.exec(mosnaiCheckParam);

        List<HT_HubiMsg> hubiMsg = mosnaiCheckParam.getListHubiMsg();
        exNumericEquals(hubiMsg.size(), 1, "件数");

        exStringEquals(hubiMsg.get(0).getMosno(), mosNo4, "申込番号");
        exNumericEquals(hubiMsg.get(0).getRenno(), 1, "連番");
        exStringEquals(hubiMsg.get(0).getMessageId(), "EBA0027", "メッセージＩＤ");
        exStringEquals(hubiMsg.get(0).getHubimsg(), "約款受領方法を入力してください。", "不備メッセージ");
        exClassificationEquals(hubiMsg.get(0).getHubisyubetukbn(), C_HubisyubetuKbn.SRHORYU_HUBI, "不備種別区分");

        HT_MosKihon mosKihon = mosnaiCheckParam.getDataSyoriControl().getMosKihon();

        exStringEquals(mosKihon.getYakkanbunsyono(), "100000000001", "約款文書番号");

        exStringEquals(mosKihon.getSiorino(), "111", "しおり番号");
    }

    @Test
    @Transactional
    @TestOrder(60)
    public void testExec_A6() {
        MockObjectManager.initialize();
        GetBunsyoNoMockForSinkeiyaku.SYORIPTN = GetBunsyoNoMockForSinkeiyaku.TESTPATTERN1;

        HT_SyoriCTL syoriCTL =  sinkeiyakuDomManager.getSyoriCTL(mosNo5);
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setSysKbn(C_SysKbn.SKEI);

        BM_SyouhnZokusei syouhnZokusei = new BM_SyouhnZokusei();
        syouhnZokusei.setSyouhncd("ﾕｵ");
        mosnaiCheckParam.setSyuSyouhnZokusei(syouhnZokusei);

        checkYakkanJyuryouHouhou.exec(mosnaiCheckParam);

        List<HT_HubiMsg> hubiMsg = mosnaiCheckParam.getListHubiMsg();
        exNumericEquals(hubiMsg.size(), 0, "件数");

        HT_MosKihon mosKihon = mosnaiCheckParam.getDataSyoriControl().getMosKihon();

        exStringEquals(mosKihon.getYakkanbunsyono(), "100000000001", "約款文書番号");

        exStringEquals(mosKihon.getSiorino(), "111", "しおり番号");
    }

    @Test
    @Transactional
    @TestOrder(70)
    public void testExec_A7() {
        MockObjectManager.initialize();
        GetBunsyoNoMockForSinkeiyaku.SYORIPTN = GetBunsyoNoMockForSinkeiyaku.TESTPATTERN1;

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL(mosNo6);
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setSysKbn(C_SysKbn.SKEI);

        BM_SyouhnZokusei syouhnZokusei = new BM_SyouhnZokusei();
        syouhnZokusei.setSyouhncd("ﾕｵ");
        mosnaiCheckParam.setSyuSyouhnZokusei(syouhnZokusei);

        checkYakkanJyuryouHouhou.exec(mosnaiCheckParam);

        List<HT_HubiMsg> hubiMsg = mosnaiCheckParam.getListHubiMsg();
        exNumericEquals(hubiMsg.size(), 0, "件数");

        HT_MosKihon mosKihon = mosnaiCheckParam.getDataSyoriControl().getMosKihon();

        exStringEquals(mosKihon.getYakkanbunsyono(), "100000000001", "約款文書番号");

        exStringEquals(mosKihon.getSiorino(), "111", "しおり番号");

    }

    @Test
    @Transactional
    @TestOrder(80)
    public void testExec_A8() {
        MockObjectManager.initialize();
        GetBunsyoNoMockForSinkeiyaku.SYORIPTN = GetBunsyoNoMockForSinkeiyaku.TESTPATTERN1;

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL(mosNo7);
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setSysKbn(C_SysKbn.SKEI);

        BM_SyouhnZokusei syouhnZokusei = new BM_SyouhnZokusei();
        syouhnZokusei.setSyouhncd("ﾕｵ");
        mosnaiCheckParam.setSyuSyouhnZokusei(syouhnZokusei);

        checkYakkanJyuryouHouhou.exec(mosnaiCheckParam);

        List<HT_HubiMsg> hubiMsg = mosnaiCheckParam.getListHubiMsg();
        exNumericEquals(hubiMsg.size(), 0, "件数");

        HT_MosKihon mosKihon = mosnaiCheckParam.getDataSyoriControl().getMosKihon();

        exStringEquals(mosKihon.getYakkanbunsyono(), "100000000001", "約款文書番号");

        exStringEquals(mosKihon.getSiorino(), "111", "しおり番号");

    }

    @Test
    @Transactional
    @TestOrder(81)
    public void testExec_A8_1() {
        MockObjectManager.initialize();
        GetBunsyoNoMockForSinkeiyaku.SYORIPTN = GetBunsyoNoMockForSinkeiyaku.TESTPATTERN1;

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL(mosNo19);
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setSysKbn(C_SysKbn.SKEI);

        BM_SyouhnZokusei syouhnZokusei = new BM_SyouhnZokusei();
        syouhnZokusei.setSyouhncd("ﾕｵ");
        mosnaiCheckParam.setSyuSyouhnZokusei(syouhnZokusei);

        checkYakkanJyuryouHouhou.exec(mosnaiCheckParam);

        List<HT_HubiMsg> hubiMsg = mosnaiCheckParam.getListHubiMsg();
        exNumericEquals(hubiMsg.size(), 0, "件数");

        HT_MosKihon mosKihon = mosnaiCheckParam.getDataSyoriControl().getMosKihon();

        exStringEquals(mosKihon.getYakkanbunsyono(), "100000000001", "約款文書番号");

        exStringEquals(mosKihon.getSiorino(), "111", "しおり番号");
    }

    @Test
    @Transactional
    @TestOrder(82)
    public void testExec_A8_2() {
        MockObjectManager.initialize();
        GetBunsyoNoMockForSinkeiyaku.SYORIPTN = GetBunsyoNoMockForSinkeiyaku.TESTPATTERN1;

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL(mosNo20);
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setSysKbn(C_SysKbn.SKEI);

        BM_SyouhnZokusei syouhnZokusei = new BM_SyouhnZokusei();
        syouhnZokusei.setSyouhncd("ﾕｵ");
        mosnaiCheckParam.setSyuSyouhnZokusei(syouhnZokusei);

        checkYakkanJyuryouHouhou.exec(mosnaiCheckParam);

        List<HT_HubiMsg> hubiMsg = mosnaiCheckParam.getListHubiMsg();
        exNumericEquals(hubiMsg.size(), 1, "件数");
        exStringEquals(hubiMsg.get(0).getMosno(), mosNo20, "申込番号");
        exNumericEquals(hubiMsg.get(0).getRenno(), 1, "連番");
        exStringEquals(hubiMsg.get(0).getMessageId(), "EBA0027", "メッセージＩＤ");
        exStringEquals(hubiMsg.get(0).getHubimsg(), "約款受領方法を入力してください。", "不備メッセージ");
        exClassificationEquals(hubiMsg.get(0).getHubisyubetukbn(), C_HubisyubetuKbn.SRHORYU_HUBI, "不備種別区分");

        HT_MosKihon mosKihon = mosnaiCheckParam.getDataSyoriControl().getMosKihon();
        exStringEquals(mosKihon.getYakkanbunsyono(), "100000000001", "約款文書番号");
        exStringEquals(mosKihon.getSiorino(), "111", "しおり番号");
    }

    @Test
    @Transactional
    @TestOrder(83)
    public void testExec_A8_3() {
        MockObjectManager.initialize();
        GetBunsyoNoMockForSinkeiyaku.SYORIPTN = GetBunsyoNoMockForSinkeiyaku.TESTPATTERN1;

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL(mosNo21);
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setSysKbn(C_SysKbn.SKEI);

        BM_SyouhnZokusei syouhnZokusei = new BM_SyouhnZokusei();
        syouhnZokusei.setSyouhncd("ﾕｵ");
        mosnaiCheckParam.setSyuSyouhnZokusei(syouhnZokusei);

        checkYakkanJyuryouHouhou.exec(mosnaiCheckParam);

        List<HT_HubiMsg> hubiMsg = mosnaiCheckParam.getListHubiMsg();
        exNumericEquals(hubiMsg.size(), 1, "件数");
        exStringEquals(hubiMsg.get(0).getMosno(), mosNo21, "申込番号");
        exNumericEquals(hubiMsg.get(0).getRenno(), 1, "連番");
        exStringEquals(hubiMsg.get(0).getMessageId(), "EBA0027", "メッセージＩＤ");
        exStringEquals(hubiMsg.get(0).getHubimsg(), "約款受領方法を入力してください。", "不備メッセージ");
        exClassificationEquals(hubiMsg.get(0).getHubisyubetukbn(), C_HubisyubetuKbn.SRHORYU_HUBI, "不備種別区分");

        HT_MosKihon mosKihon = mosnaiCheckParam.getDataSyoriControl().getMosKihon();
        exStringEquals(mosKihon.getYakkanbunsyono(), "100000000001", "約款文書番号");
        exStringEquals(mosKihon.getSiorino(), "111", "しおり番号");
    }

    @Test
    @Transactional
    @TestOrder(90)
    public void testExec_A9() {
        MockObjectManager.initialize();
        GetBunsyoNoMockForSinkeiyaku.SYORIPTN = GetBunsyoNoMockForSinkeiyaku.TESTPATTERN1;

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL(mosNo8);
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setSysKbn(C_SysKbn.SKEI);

        BM_SyouhnZokusei syouhnZokusei = new BM_SyouhnZokusei();
        syouhnZokusei.setSyouhncd("ﾕｵ");
        mosnaiCheckParam.setSyuSyouhnZokusei(syouhnZokusei);

        checkYakkanJyuryouHouhou.exec(mosnaiCheckParam);

        List<HT_HubiMsg> hubiMsg = mosnaiCheckParam.getListHubiMsg();
        exNumericEquals(hubiMsg.size(), 1, "件数");

        exStringEquals(hubiMsg.get(0).getMosno(), mosNo8, "申込番号");
        exNumericEquals(hubiMsg.get(0).getRenno(), 1, "連番");
        exStringEquals(hubiMsg.get(0).getMessageId(), "EBA0027", "メッセージＩＤ");
        exStringEquals(hubiMsg.get(0).getHubimsg(), "約款受領方法を入力してください。", "不備メッセージ");
        exClassificationEquals(hubiMsg.get(0).getHubisyubetukbn(), C_HubisyubetuKbn.SRHORYU_HUBI, "不備種別区分");

        HT_MosKihon mosKihon = mosnaiCheckParam.getDataSyoriControl().getMosKihon();

        exStringEquals(mosKihon.getYakkanbunsyono(), "100000000001", "約款文書番号");

        exStringEquals(mosKihon.getSiorino(), "111", "しおり番号");

    }

    @Test
    @Transactional
    @TestOrder(100)
    public void testExec_A10() {
        MockObjectManager.initialize();
        GetBunsyoNoMockForSinkeiyaku.SYORIPTN = GetBunsyoNoMockForSinkeiyaku.TESTPATTERN1;

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL(mosNo9);
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setSysKbn(C_SysKbn.SKEI);

        BM_SyouhnZokusei syouhnZokusei = new BM_SyouhnZokusei();
        syouhnZokusei.setSyouhncd("ﾕｵ");
        mosnaiCheckParam.setSyuSyouhnZokusei(syouhnZokusei);

        checkYakkanJyuryouHouhou.exec(mosnaiCheckParam);

        List<HT_HubiMsg> hubiMsg = mosnaiCheckParam.getListHubiMsg();
        exNumericEquals(hubiMsg.size(), 0, "件数");

        HT_MosKihon mosKihon = mosnaiCheckParam.getDataSyoriControl().getMosKihon();

        exStringEquals(mosKihon.getYakkanbunsyono(), "100000000001", "約款文書番号");

        exStringEquals(mosKihon.getSiorino(), "111", "しおり番号");

    }

    @Test
    @Transactional
    @TestOrder(110)
    public void testExec_A11() {
        MockObjectManager.initialize();
        GetBunsyoNoMockForSinkeiyaku.SYORIPTN = GetBunsyoNoMockForSinkeiyaku.TESTPATTERN1;

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL(mosNo10);
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setSysKbn(C_SysKbn.SKEI);

        BM_SyouhnZokusei syouhnZokusei = new BM_SyouhnZokusei();
        syouhnZokusei.setSyouhncd("ﾕｵ");
        mosnaiCheckParam.setSyuSyouhnZokusei(syouhnZokusei);

        checkYakkanJyuryouHouhou.exec(mosnaiCheckParam);

        List<HT_HubiMsg> hubiMsg = mosnaiCheckParam.getListHubiMsg();
        exNumericEquals(hubiMsg.size(), 0, "件数");

        HT_MosKihon mosKihon = mosnaiCheckParam.getDataSyoriControl().getMosKihon();

        exStringEquals(mosKihon.getYakkanbunsyono(), "100000000001", "約款文書番号");

        exStringEquals(mosKihon.getSiorino(), "111", "しおり番号");

    }

    @Test
    @Transactional
    @TestOrder(120)
    public void testExec_A12() {
        MockObjectManager.initialize();
        GetBunsyoNoMockForSinkeiyaku.SYORIPTN = GetBunsyoNoMockForSinkeiyaku.TESTPATTERN1;
        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL(mosNo11);
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setSysKbn(C_SysKbn.SKEI);

        BM_SyouhnZokusei syouhnZokusei = new BM_SyouhnZokusei();
        syouhnZokusei.setSyouhncd("ﾕｵ");
        mosnaiCheckParam.setSyuSyouhnZokusei(syouhnZokusei);

        checkYakkanJyuryouHouhou.exec(mosnaiCheckParam);

        List<HT_HubiMsg> hubiMsg = mosnaiCheckParam.getListHubiMsg();
        exNumericEquals(hubiMsg.size(), 1, "件数");
        exStringEquals(hubiMsg.get(0).getMosno(), mosNo11, "申込番号");
        exNumericEquals(hubiMsg.get(0).getRenno(), 1, "連番");
        exStringEquals(hubiMsg.get(0).getMessageId(), "EBC0012", "メッセージＩＤ");
        exStringEquals(hubiMsg.get(0).getHubimsg(), "約款受領方法の入力は不要です。", "不備メッセージ");
        exClassificationEquals(hubiMsg.get(0).getHubisyubetukbn(), C_HubisyubetuKbn.SRHORYU_HUBI, "不備種別区分");

        HT_MosKihon mosKihon = mosnaiCheckParam.getDataSyoriControl().getMosKihon();
        exStringEquals(mosKihon.getYakkanbunsyono(), "100000000001", "約款文書番号");
        exStringEquals(mosKihon.getSiorino(), "111", "しおり番号");

    }

    @Test
    @Transactional
    @TestOrder(130)
    public void testExec_A13() {
        MockObjectManager.initialize();
        GetBunsyoNoMockForSinkeiyaku.SYORIPTN = GetBunsyoNoMockForSinkeiyaku.TESTPATTERN1;
        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL(mosNo12);
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setSysKbn(C_SysKbn.SKEI);

        BM_SyouhnZokusei syouhnZokusei = new BM_SyouhnZokusei();
        syouhnZokusei.setSyouhncd("ﾕｵ");
        mosnaiCheckParam.setSyuSyouhnZokusei(syouhnZokusei);

        checkYakkanJyuryouHouhou.exec(mosnaiCheckParam);

        List<HT_HubiMsg> hubiMsg = mosnaiCheckParam.getListHubiMsg();
        exNumericEquals(hubiMsg.size(), 1, "件数");
        exStringEquals(hubiMsg.get(0).getMosno(), mosNo12, "申込番号");
        exNumericEquals(hubiMsg.get(0).getRenno(), 1, "連番");
        exStringEquals(hubiMsg.get(0).getMessageId(), "EBA0027", "メッセージＩＤ");
        exStringEquals(hubiMsg.get(0).getHubimsg(), "約款受領方法を入力してください。", "不備メッセージ");
        exClassificationEquals(hubiMsg.get(0).getHubisyubetukbn(), C_HubisyubetuKbn.SRHORYU_HUBI, "不備種別区分");

        HT_MosKihon mosKihon = mosnaiCheckParam.getDataSyoriControl().getMosKihon();
        exStringEquals(mosKihon.getYakkanbunsyono(), "100000000001", "約款文書番号");
        exStringEquals(mosKihon.getSiorino(), "111", "しおり番号");

    }

    @Test
    @Transactional
    @TestOrder(140)
    public void testExec_A14() {
        MockObjectManager.initialize();
        GetBunsyoNoMockForSinkeiyaku.SYORIPTN = GetBunsyoNoMockForSinkeiyaku.TESTPATTERN1;
        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL(mosNo13);
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setSysKbn(C_SysKbn.SKEI);

        BM_SyouhnZokusei syouhnZokusei = new BM_SyouhnZokusei();
        syouhnZokusei.setSyouhncd("ﾕｵ");
        mosnaiCheckParam.setSyuSyouhnZokusei(syouhnZokusei);

        checkYakkanJyuryouHouhou.exec(mosnaiCheckParam);

        List<HT_HubiMsg> hubiMsg = mosnaiCheckParam.getListHubiMsg();
        exNumericEquals(hubiMsg.size(), 1, "件数");
        exStringEquals(hubiMsg.get(0).getMosno(), mosNo13, "申込番号");
        exNumericEquals(hubiMsg.get(0).getRenno(), 1, "連番");
        exStringEquals(hubiMsg.get(0).getMessageId(), "EBA0027", "メッセージＩＤ");
        exStringEquals(hubiMsg.get(0).getHubimsg(), "約款受領方法を入力してください。", "不備メッセージ");
        exClassificationEquals(hubiMsg.get(0).getHubisyubetukbn(), C_HubisyubetuKbn.SRHORYU_HUBI, "不備種別区分");

        HT_MosKihon mosKihon = mosnaiCheckParam.getDataSyoriControl().getMosKihon();
        exStringEquals(mosKihon.getYakkanbunsyono(), "100000000001", "約款文書番号");
        exStringEquals(mosKihon.getSiorino(), "111", "しおり番号");

    }

    @Test
    @Transactional
    @TestOrder(150)
    public void testExec_A15() {
        MockObjectManager.initialize();
        GetBunsyoNoMockForSinkeiyaku.SYORIPTN = GetBunsyoNoMockForSinkeiyaku.TESTPATTERN1;
        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL(mosNo14);
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setSysKbn(C_SysKbn.SKEI);

        BM_SyouhnZokusei syouhnZokusei = new BM_SyouhnZokusei();
        syouhnZokusei.setSyouhncd("ﾕｵ");
        mosnaiCheckParam.setSyuSyouhnZokusei(syouhnZokusei);

        checkYakkanJyuryouHouhou.exec(mosnaiCheckParam);

        List<HT_HubiMsg> hubiMsg = mosnaiCheckParam.getListHubiMsg();
        exNumericEquals(hubiMsg.size(), 1, "件数");
        exStringEquals(hubiMsg.get(0).getMosno(), mosNo14, "申込番号");
        exNumericEquals(hubiMsg.get(0).getRenno(), 1, "連番");
        exStringEquals(hubiMsg.get(0).getMessageId(), "EBA0027", "メッセージＩＤ");
        exStringEquals(hubiMsg.get(0).getHubimsg(), "約款受領方法を入力してください。", "不備メッセージ");
        exClassificationEquals(hubiMsg.get(0).getHubisyubetukbn(), C_HubisyubetuKbn.SRHORYU_HUBI, "不備種別区分");

        HT_MosKihon mosKihon = mosnaiCheckParam.getDataSyoriControl().getMosKihon();
        exStringEquals(mosKihon.getYakkanbunsyono(), "100000000001", "約款文書番号");
        exStringEquals(mosKihon.getSiorino(), "111", "しおり番号");

    }

    @Test
    @Transactional
    @TestOrder(160)
    public void testExec_A16() {
        MockObjectManager.initialize();
        GetBunsyoNoMockForSinkeiyaku.SYORIPTN = GetBunsyoNoMockForSinkeiyaku.TESTPATTERN1;
        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL(mosNo15);
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setSysKbn(C_SysKbn.SKEI);

        BM_SyouhnZokusei syouhnZokusei = new BM_SyouhnZokusei();
        syouhnZokusei.setSyouhncd("ﾕｵ");
        mosnaiCheckParam.setSyuSyouhnZokusei(syouhnZokusei);

        checkYakkanJyuryouHouhou.exec(mosnaiCheckParam);

        List<HT_HubiMsg> hubiMsg = mosnaiCheckParam.getListHubiMsg();
        exNumericEquals(hubiMsg.size(), 1, "件数");
        exStringEquals(hubiMsg.get(0).getMosno(), mosNo15, "申込番号");
        exNumericEquals(hubiMsg.get(0).getRenno(), 1, "連番");
        exStringEquals(hubiMsg.get(0).getMessageId(), "EBA0027", "メッセージＩＤ");
        exStringEquals(hubiMsg.get(0).getHubimsg(), "約款受領方法を入力してください。", "不備メッセージ");
        exClassificationEquals(hubiMsg.get(0).getHubisyubetukbn(), C_HubisyubetuKbn.SRHORYU_HUBI, "不備種別区分");

        HT_MosKihon mosKihon = mosnaiCheckParam.getDataSyoriControl().getMosKihon();
        exStringEquals(mosKihon.getYakkanbunsyono(), "100000000001", "約款文書番号");
        exStringEquals(mosKihon.getSiorino(), "111", "しおり番号");

    }

    @Test
    @Transactional
    @TestOrder(170)
    public void testExec_A17() {
        MockObjectManager.initialize();
        GetBunsyoNoMockForSinkeiyaku.SYORIPTN = GetBunsyoNoMockForSinkeiyaku.TESTPATTERN1;
        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL(mosNo16);
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setSysKbn(C_SysKbn.SKEI);

        BM_SyouhnZokusei syouhnZokusei = new BM_SyouhnZokusei();
        syouhnZokusei.setSyouhncd("ﾕｵ");
        mosnaiCheckParam.setSyuSyouhnZokusei(syouhnZokusei);

        checkYakkanJyuryouHouhou.exec(mosnaiCheckParam);

        List<HT_HubiMsg> hubiMsg = mosnaiCheckParam.getListHubiMsg();
        exNumericEquals(hubiMsg.size(), 1, "件数");
        exStringEquals(hubiMsg.get(0).getMosno(), mosNo16, "申込番号");
        exNumericEquals(hubiMsg.get(0).getRenno(), 1, "連番");
        exStringEquals(hubiMsg.get(0).getMessageId(), "EBA0027", "メッセージＩＤ");
        exStringEquals(hubiMsg.get(0).getHubimsg(), "約款受領方法を入力してください。", "不備メッセージ");
        exClassificationEquals(hubiMsg.get(0).getHubisyubetukbn(), C_HubisyubetuKbn.SRHORYU_HUBI, "不備種別区分");

        HT_MosKihon mosKihon = mosnaiCheckParam.getDataSyoriControl().getMosKihon();
        exStringEquals(mosKihon.getYakkanbunsyono(), "100000000001", "約款文書番号");
        exStringEquals(mosKihon.getSiorino(), "111", "しおり番号");

    }

    @Test
    @Transactional
    @TestOrder(180)
    public void testExec_A18() {
        MockObjectManager.initialize();
        GetBunsyoNoMockForSinkeiyaku.SYORIPTN = GetBunsyoNoMockForSinkeiyaku.TESTPATTERN1;
        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL(mosNo17);
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setSysKbn(C_SysKbn.SKEI);

        BM_SyouhnZokusei syouhnZokusei = new BM_SyouhnZokusei();
        syouhnZokusei.setSyouhncd("ﾕｵ");
        mosnaiCheckParam.setSyuSyouhnZokusei(syouhnZokusei);

        checkYakkanJyuryouHouhou.exec(mosnaiCheckParam);

        List<HT_HubiMsg> hubiMsg = mosnaiCheckParam.getListHubiMsg();
        exNumericEquals(hubiMsg.size(), 1, "件数");
        exStringEquals(hubiMsg.get(0).getMosno(), mosNo17, "申込番号");
        exNumericEquals(hubiMsg.get(0).getRenno(), 1, "連番");
        exStringEquals(hubiMsg.get(0).getMessageId(), "EBA0027", "メッセージＩＤ");
        exStringEquals(hubiMsg.get(0).getHubimsg(), "約款受領方法を入力してください。", "不備メッセージ");
        exClassificationEquals(hubiMsg.get(0).getHubisyubetukbn(), C_HubisyubetuKbn.SRHORYU_HUBI, "不備種別区分");

        HT_MosKihon mosKihon = mosnaiCheckParam.getDataSyoriControl().getMosKihon();
        exStringEquals(mosKihon.getYakkanbunsyono(), "100000000001", "約款文書番号");
        exStringEquals(mosKihon.getSiorino(), "111", "しおり番号");

    }

    @Test
    @Transactional
    @TestOrder(190)
    public void testExec_A19() {
        MockObjectManager.initialize();
        GetBunsyoNoMockForSinkeiyaku.SYORIPTN = GetBunsyoNoMockForSinkeiyaku.TESTPATTERN1;
        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL(mosNo18);
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setSysKbn(C_SysKbn.SKEI);

        BM_SyouhnZokusei syouhnZokusei = new BM_SyouhnZokusei();
        syouhnZokusei.setSyouhncd("ﾕｵ");
        mosnaiCheckParam.setSyuSyouhnZokusei(syouhnZokusei);

        checkYakkanJyuryouHouhou.exec(mosnaiCheckParam);

        List<HT_HubiMsg> hubiMsg = mosnaiCheckParam.getListHubiMsg();
        exNumericEquals(hubiMsg.size(), 1, "件数");
        exStringEquals(hubiMsg.get(0).getMosno(), mosNo18, "申込番号");
        exNumericEquals(hubiMsg.get(0).getRenno(), 1, "連番");
        exStringEquals(hubiMsg.get(0).getMessageId(), "EBC0012", "メッセージＩＤ");
        exStringEquals(hubiMsg.get(0).getHubimsg(), "約款受領方法の入力は不要です。", "不備メッセージ");
        exClassificationEquals(hubiMsg.get(0).getHubisyubetukbn(), C_HubisyubetuKbn.SRHORYU_HUBI, "不備種別区分");

        HT_MosKihon mosKihon = mosnaiCheckParam.getDataSyoriControl().getMosKihon();
        exStringEquals(mosKihon.getYakkanbunsyono(), "100000000001", "約款文書番号");
        exStringEquals(mosKihon.getSiorino(), "111", "しおり番号");

    }
}
