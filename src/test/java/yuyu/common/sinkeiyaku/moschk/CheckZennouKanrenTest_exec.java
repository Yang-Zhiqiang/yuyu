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
import yuyu.def.biz.manager.BizDomManager;
import yuyu.def.classification.C_KetsrhkosKbn;
import yuyu.def.classification.C_SysKbn;
import yuyu.def.db.entity.BM_SyouhnZokusei;
import yuyu.def.db.entity.HT_SyoriCTL;
import yuyu.def.sinkeiyaku.configuration.YuyuSinkeiyakuConfig;
import yuyu.def.sinkeiyaku.manager.SinkeiyakuDomManager;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;
import yuyu.testinfr.inject.MockModuleBinder;

import com.google.inject.AbstractModule;

/**
 * 前納関連チェックのメソッド {@link CheckZennouKanren#exec(MosnaiCheckParam)} テスト用クラスです。<br />
 */
@RunWith(OrderedRunner.class)
public class CheckZennouKanrenTest_exec {

    private final static String mosNo1 = "861110005";

    private final static String mosNo2 = "861110013";

    private final static String mosNo3 = "861110021";

    private final static String mosNo4 = "861110039";

    private final static String mosNo5 = "861110047";

    private final static String mosNo6 = "861110054";

    private final static String mosNo7 = "861110062";

    private final static String mosNo8 = "861110070";

    private final static String mosNo9 = "861110088";

    private final static String mosNo10 = "861110096";

    private final static String mosNo11 = "861110104";

    private final static String mosNo12 = "861110112";

    private final static String mosNo13 = "971112321";

    private final static String mosNo14 = "861110138";

    private final static String mosNo15 = "971112339";

    private final static String mosNo16 = "971112370";

    private final static String mosNo17 = "981112220";

    private final static String mosNo18 = "981112238";

    private final static String mosNo19 = "981112246";

    private final static String mosNo20 = "981112253";

    private final static String mosNo21 = "981112261";

    private final static String syouhnCd1 = "MD11";

    private final static int syouhnsdNo1 = 1;

    private final static String syouhnCd2 = "M110";

    private final static int syouhnsdNo2 = 1;

    private final static String syouhnCd3 = "M120";

    private final static int syouhnsdNo3 = 1;

    private final static String syouhnCd4 = "M210";

    private final static int syouhnsdNo4 = 1;

    private final static String syouhnCd5 = "M210";

    private final static int syouhnsdNo5 = 2;

    private final static String syouhnCd6 = "M210";

    private final static int syouhnsdNo6 = 3;

    private final static String syouhnCd7 = "M320";

    private final static int syouhnsdNo7 = 1;

    private final static String syouhnCd8 = "M320";

    private final static int syouhnsdNo8 = 2;

    private final static String syouhnCd9 = "M320";

    private final static int syouhnsdNo9 = 3;

    private final static String syouhnCd10 = "M310";

    private final static int syouhnsdNo10 = 1;

    private final static String syouhnCd11 = "M310";

    private final static int syouhnsdNo11 = 2;

    private final static String syouhnCd12 = "M310";

    private final static int syouhnsdNo12 = 3;

    private final static String syouhnCd13 = "M110";

    private final static int syouhnsdNo13 = 2;

    private final static String syouhnCd14 = "M110";

    private final static int syouhnsdNo14 = 3;

    private final static String syouhnCd15 = "MD11";

    private final static int syouhnsdNo15 = 11;

    private final static String syouhnCd16 = "MD11";

    private final static int syouhnsdNo16 = 9;

    private final static String fileName = "UT_SP_単体テスト仕様書_前納関連チェック";

    private final static String sheetName = "テストデータ";

    @Inject
    private MosnaiCheckParam mosnaiCheckParam;

    @Inject
    private SinkeiyakuDomManager sinkeiyakuDomManager;

    private static Integer znnKaiMin;

    @Inject
    private BizDomManager bizDomManager;

    @BeforeClass
    @Transactional
    public static void insertTestData() {

        try {
            TestDataMaker testDataMaker = new TestDataMaker();
            HashMap<String, Map<String, List<Map<String, String>>>> testDataAndTblMap;
            testDataAndTblMap = testDataMaker.getInData(CheckZennouKanrenTest_exec.class, fileName, sheetName);
            testDataMaker.insDataByDataId("データ001", testDataAndTblMap);
        } catch (TestDataMakerException e) {

            e.printStackTrace();
        }}

    @AfterClass
    @Transactional
    public static void deleteTestData() {

        MockObjectManager.initialize();

        SinkeiyakuDomManager sinkeiyakuDomManager = SWAKInjector
            .getInstance(SinkeiyakuDomManager.class);
        BizDomManager bizDomManager = SWAKInjector.getInstance(BizDomManager.class);
        sinkeiyakuDomManager.delete(sinkeiyakuDomManager.getAllSyoriCTL());
        bizDomManager.delete(bizDomManager.getAllSyouhnZokusei());

        YuyuSinkeiyakuConfig.getInstance().setZnnKaiMin(znnKaiMin);

    }

    @Before
    public void before(){
        MockModuleBinder.bind(new AbstractModule(){
            @Override
            protected void configure() {
                bind(HanteiZennouKaisuu.class).to(HanteiZennouKaisuuMockForSinkeiyaku.class);
                bind(SetHubiMsg.class).to(SetHubiMsgMockForSinkeiyaku.class);
            }
        });
    }

    @BeforeClass
    public static void testInit(){

        HanteiZennouKaisuuMockForSinkeiyaku.caller = CheckZennouKanrenTest_exec.class;
        SetHubiMsgMockForSinkeiyaku.caller = CheckZennouKanrenTest_exec.class;

        znnKaiMin = YuyuSinkeiyakuConfig.getInstance().getZnnKaiMin();
    }

    @Test
    @Transactional
    @TestOrder(10)
    public void testExec_A1() {

        MockObjectManager.initialize();
        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL(mosNo1);
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setKosID("user001");
        mosnaiCheckParam.setKosTime("20150603111400000");
        BM_SyouhnZokusei syuSyouhnZokusei = bizDomManager.getSyouhnZokusei(syouhnCd1, syouhnsdNo1);
        mosnaiCheckParam.setSyuSyouhnZokusei(syuSyouhnZokusei);

        CheckZennouKanren checkZennouKanren = SWAKInjector.getInstance(CheckZennouKanren.class);
        checkZennouKanren.exec(mosnaiCheckParam);

        exClassificationEquals((C_KetsrhkosKbn) MockObjectManager.getArgument(SetHubiMsgMockForSinkeiyaku.class, "exec", 0, 0),
            C_KetsrhkosKbn.KETHORYU_HUBI, "決定・成立保留更新区分");
        exStringEquals((String) MockObjectManager.getArgument(SetHubiMsgMockForSinkeiyaku.class, "exec", 0, 1),
            "EBC0045 全期前納の入力が必要です。", "メッセージ文言");

    }

    @Test
    @Transactional
    @TestOrder(20)
    public void testExec_A2() {

        MockObjectManager.initialize();
        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL(mosNo2);
        YuyuSinkeiyakuConfig.getInstance().setZnnKaiMin(2);

        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setKosID("user001");
        mosnaiCheckParam.setKosTime("20150603111400000");
        BM_SyouhnZokusei syuSyouhnZokusei = bizDomManager.getSyouhnZokusei(syouhnCd2, syouhnsdNo2);
        mosnaiCheckParam.setSyuSyouhnZokusei(syuSyouhnZokusei);

        CheckZennouKanren checkZennouKanren = SWAKInjector.getInstance(CheckZennouKanren.class);
        checkZennouKanren.exec(mosnaiCheckParam);

        exClassificationEquals((C_KetsrhkosKbn) MockObjectManager.getArgument(SetHubiMsgMockForSinkeiyaku.class, "exec", 0, 0),
            C_KetsrhkosKbn.KETHORYU_HUBI, "決定・成立保留更新区分");
        exStringEquals((String) MockObjectManager.getArgument(SetHubiMsgMockForSinkeiyaku.class, "exec", 0, 1),
            "EHC1085 払込経路が「団体」の場合、前納は取扱えません。", "メッセージ文言");

    }

    @Test
    @Transactional
    @TestOrder(30)
    public void testExec_A3() {

        MockObjectManager.initialize();
        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL(mosNo3);

        YuyuSinkeiyakuConfig.getInstance().setZnnKaiMin(2);

        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setKosID("user001");
        mosnaiCheckParam.setKosTime("20150603111400000");
        BM_SyouhnZokusei syuSyouhnZokusei = bizDomManager.getSyouhnZokusei(syouhnCd3, syouhnsdNo3);
        mosnaiCheckParam.setSyuSyouhnZokusei(syuSyouhnZokusei);

        CheckZennouKanren checkZennouKanren = SWAKInjector.getInstance(CheckZennouKanren.class);
        checkZennouKanren.exec(mosnaiCheckParam);

        exClassificationEquals((C_KetsrhkosKbn) MockObjectManager.getArgument(SetHubiMsgMockForSinkeiyaku.class, "exec", 0, 0),
            C_KetsrhkosKbn.KETHORYU_HUBI, "決定・成立保留更新区分");
        exStringEquals((String) MockObjectManager.getArgument(SetHubiMsgMockForSinkeiyaku.class, "exec", 0, 1),
            "EHC1085 払込経路が「団体」の場合、前納は取扱えません。", "メッセージ文言");

    }

    @Test
    @Transactional
    @TestOrder(40)
    public void testExec_A4() {

        MockObjectManager.initialize();
        HanteiZennouKaisuuMockForSinkeiyaku.SYORIPTN = HanteiZennouKaisuuMockForSinkeiyaku.TESTPATTERN1;
        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL(mosNo4);
        BM_SyouhnZokusei syuSyouhnZokusei = bizDomManager.getSyouhnZokusei(syouhnCd4, syouhnsdNo4);
        mosnaiCheckParam.setSyuSyouhnZokusei(syuSyouhnZokusei);

        YuyuSinkeiyakuConfig.getInstance().setZnnKaiMin(2);

        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setKosID("user001");
        mosnaiCheckParam.setKosTime("20150603111400000");

        CheckZennouKanren checkZennouKanren = SWAKInjector.getInstance(CheckZennouKanren.class);
        checkZennouKanren.exec(mosnaiCheckParam);

        exClassificationEquals((C_KetsrhkosKbn) MockObjectManager.getArgument(SetHubiMsgMockForSinkeiyaku.class, "exec", 0, 0),
            C_KetsrhkosKbn.KETHORYU_HUBI, "決定・成立保留更新区分");
        exStringEquals((String) MockObjectManager.getArgument(SetHubiMsgMockForSinkeiyaku.class, "exec", 0, 1),
            "EHC0102 前納期間が全払込期間を超過しています。", "メッセージ文言");
    }

    @Test
    @Transactional
    @TestOrder(50)
    public void testExec_A5() {

        MockObjectManager.initialize();
        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL(mosNo5);

        YuyuSinkeiyakuConfig.getInstance().setZnnKaiMin(2);

        mosnaiCheckParam.setSysDate(BizDate.valueOf("20130403"));
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setKosID("user001");
        mosnaiCheckParam.setKosTime("20150603111400000");
        BM_SyouhnZokusei syuSyouhnZokusei = bizDomManager.getSyouhnZokusei(syouhnCd5, syouhnsdNo5);
        mosnaiCheckParam.setSyuSyouhnZokusei(syuSyouhnZokusei);

        CheckZennouKanren checkZennouKanren = SWAKInjector.getInstance(CheckZennouKanren.class);
        checkZennouKanren.exec(mosnaiCheckParam);

        exClassificationEquals((C_KetsrhkosKbn) MockObjectManager.getArgument(SetHubiMsgMockForSinkeiyaku.class, "exec", 0, 0),
            C_KetsrhkosKbn.KETHORYU_HUBI, "決定・成立保留更新区分");
        exStringEquals((String) MockObjectManager.getArgument(SetHubiMsgMockForSinkeiyaku.class, "exec", 0, 1),
            "EHC0019 一時払がん医療終身保険の一部前納は取扱えません。", "メッセージ文言");
    }

    @Test
    @Transactional
    @TestOrder(60)
    public void testExec_A6() {

        MockObjectManager.initialize();
        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL(mosNo6);

        mosnaiCheckParam.setSysDate(BizDate.valueOf("20100106"));
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setKosID("user001");
        mosnaiCheckParam.setKosTime("20150603111400000");
        BM_SyouhnZokusei syuSyouhnZokusei = bizDomManager.getSyouhnZokusei(syouhnCd6, syouhnsdNo6);
        mosnaiCheckParam.setSyuSyouhnZokusei(syuSyouhnZokusei);

        CheckZennouKanren checkZennouKanren = SWAKInjector.getInstance(CheckZennouKanren.class);
        checkZennouKanren.exec(mosnaiCheckParam);

        exClassificationEquals((C_KetsrhkosKbn) MockObjectManager.getArgument(SetHubiMsgMockForSinkeiyaku.class, "exec", 0, 0),
            C_KetsrhkosKbn.KETHORYU_HUBI, "決定・成立保留更新区分");
        exStringEquals((String) MockObjectManager.getArgument(SetHubiMsgMockForSinkeiyaku.class, "exec", 0, 1),
            "EHC0019 入院保険の全期前納は取扱えません。", "メッセージ文言");
    }

    @Test
    @Transactional
    @TestOrder(70)
    public void testExec_A7() {

        MockObjectManager.initialize();
        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL(mosNo7);

        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setKosID("user001");
        mosnaiCheckParam.setKosTime("20150603111400000");
        BM_SyouhnZokusei syuSyouhnZokusei = bizDomManager.getSyouhnZokusei(syouhnCd7, syouhnsdNo7);
        mosnaiCheckParam.setSyuSyouhnZokusei(syuSyouhnZokusei);
        CheckZennouKanren checkZennouKanren = SWAKInjector.getInstance(CheckZennouKanren.class);
        checkZennouKanren.exec(mosnaiCheckParam);

        exClassificationEquals((C_KetsrhkosKbn) MockObjectManager.getArgument(SetHubiMsgMockForSinkeiyaku.class, "exec", 0, 0),
            C_KetsrhkosKbn.KETHORYU_HUBI, "決定・成立保留更新区分");
        exStringEquals((String) MockObjectManager.getArgument(SetHubiMsgMockForSinkeiyaku.class, "exec", 0, 1),
            "EBC0045 前納期間の入力が必要です。", "メッセージ文言");
    }

    @Test
    @Transactional
    @TestOrder(80)
    public void testExec_A8() {

        MockObjectManager.initialize();
        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL(mosNo8);

        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setKosID("user001");
        mosnaiCheckParam.setKosTime("20150603111400000");
        BM_SyouhnZokusei syuSyouhnZokusei = bizDomManager.getSyouhnZokusei(syouhnCd8, syouhnsdNo8);
        mosnaiCheckParam.setSyuSyouhnZokusei(syuSyouhnZokusei);

        CheckZennouKanren checkZennouKanren = SWAKInjector.getInstance(CheckZennouKanren.class);
        checkZennouKanren.exec(mosnaiCheckParam);

        exClassificationEquals((C_KetsrhkosKbn) MockObjectManager.getArgument(SetHubiMsgMockForSinkeiyaku.class, "exec", 0, 0),
            C_KetsrhkosKbn.KETHORYU_HUBI, "決定・成立保留更新区分");
        exStringEquals((String) MockObjectManager.getArgument(SetHubiMsgMockForSinkeiyaku.class, "exec", 0, 1),
            "EHC1084 全期前納の前納期間が正しくありません。", "メッセージ文言");
    }

    @Test
    @Transactional
    @TestOrder(90)
    public void testExec_A9() {

        MockObjectManager.initialize();
        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL(mosNo9);

        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setKosID("user001");
        mosnaiCheckParam.setKosTime("20150603111400000");
        BM_SyouhnZokusei syuSyouhnZokusei = bizDomManager.getSyouhnZokusei(syouhnCd9, syouhnsdNo9);
        mosnaiCheckParam.setSyuSyouhnZokusei(syuSyouhnZokusei);

        CheckZennouKanren checkZennouKanren = SWAKInjector.getInstance(CheckZennouKanren.class);
        checkZennouKanren.exec(mosnaiCheckParam);

        exClassificationEquals((C_KetsrhkosKbn) MockObjectManager.getArgument(SetHubiMsgMockForSinkeiyaku.class, "exec", 0, 0),
            C_KetsrhkosKbn.KETHORYU_HUBI, "決定・成立保留更新区分");
        exStringEquals((String) MockObjectManager.getArgument(SetHubiMsgMockForSinkeiyaku.class, "exec", 0, 1),
            "EHC0105 前納期間は2年以上を指定してください。", "メッセージ文言");
    }

    @Test
    @Transactional
    @TestOrder(100)
    public void testExec_A10() {

        MockObjectManager.initialize();
        HanteiZennouKaisuuMockForSinkeiyaku.SYORIPTN = HanteiZennouKaisuuMockForSinkeiyaku.TESTPATTERN2;
        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL(mosNo10);

        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setKosID("user001");
        mosnaiCheckParam.setKosTime("20150603111400000");
        BM_SyouhnZokusei syuSyouhnZokusei = bizDomManager.getSyouhnZokusei(syouhnCd10, syouhnsdNo10);
        mosnaiCheckParam.setSyuSyouhnZokusei(syuSyouhnZokusei);

        CheckZennouKanren checkZennouKanren = SWAKInjector.getInstance(CheckZennouKanren.class);
        checkZennouKanren.exec(mosnaiCheckParam);

        exClassificationEquals((C_KetsrhkosKbn) MockObjectManager.getArgument(SetHubiMsgMockForSinkeiyaku.class, "exec", 0, 0),
            C_KetsrhkosKbn.KETHORYU_HUBI, "決定・成立保留更新区分");
        exStringEquals((String) MockObjectManager.getArgument(SetHubiMsgMockForSinkeiyaku.class, "exec", 0, 1),
            "EHC0103 前納期間が特約払込期間を超えています。", "メッセージ文言");
    }

    @Test
    @Transactional
    @TestOrder(110)
    public void testExec_A11() {

        MockObjectManager.initialize();
        HanteiZennouKaisuuMockForSinkeiyaku.SYORIPTN = HanteiZennouKaisuuMockForSinkeiyaku.TESTPATTERN5;
        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL(mosNo11);

        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setKosID("user001");
        mosnaiCheckParam.setKosTime("20150603111400000");
        BM_SyouhnZokusei syuSyouhnZokusei = bizDomManager.getSyouhnZokusei(syouhnCd11, syouhnsdNo11);
        mosnaiCheckParam.setSyuSyouhnZokusei(syuSyouhnZokusei);

        CheckZennouKanren checkZennouKanren = SWAKInjector.getInstance(CheckZennouKanren.class);
        checkZennouKanren.exec(mosnaiCheckParam);

        exClassificationEquals((C_KetsrhkosKbn) MockObjectManager.getArgument(SetHubiMsgMockForSinkeiyaku.class, "exec", 0, 0),
            C_KetsrhkosKbn.KETHORYU_HUBI, "決定・成立保留更新区分");
        exStringEquals((String) MockObjectManager.getArgument(SetHubiMsgMockForSinkeiyaku.class, "exec", 0, 1),
            "EHC1076 全期前納の前納期間が全払込期間と相違しています。", "メッセージ文言");
    }

    @Test
    @Transactional
    @TestOrder(120)
    public void testExec_A12() {

        MockObjectManager.initialize();
        HanteiZennouKaisuuMockForSinkeiyaku.SYORIPTN = HanteiZennouKaisuuMockForSinkeiyaku.TESTPATTERN6;
        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL(mosNo12);

        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setKosID("user001");
        mosnaiCheckParam.setKosTime("20150603111400000");
        BM_SyouhnZokusei syuSyouhnZokusei = bizDomManager.getSyouhnZokusei(syouhnCd12, syouhnsdNo12);
        mosnaiCheckParam.setSyuSyouhnZokusei(syuSyouhnZokusei);
        CheckZennouKanren checkZennouKanren = SWAKInjector.getInstance(CheckZennouKanren.class);
        checkZennouKanren.exec(mosnaiCheckParam);

        exClassificationEquals((C_KetsrhkosKbn) MockObjectManager.getArgument(SetHubiMsgMockForSinkeiyaku.class, "exec", 0, 0),
            C_KetsrhkosKbn.KETHORYU_HUBI, "決定・成立保留更新区分");
        exStringEquals((String) MockObjectManager.getArgument(SetHubiMsgMockForSinkeiyaku.class, "exec", 0, 1),
            "EHC1088 全期前納の前納期間が特約払込期間と相違しています。", "メッセージ文言");
    }

    @Test
    @Transactional
    @TestOrder(130)
    public void testExec_A13() {

        MockObjectManager.initialize();
        HanteiZennouKaisuuMockForSinkeiyaku.SYORIPTN = HanteiZennouKaisuuMockForSinkeiyaku.TESTPATTERN7;
        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL(mosNo13);

        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setKosID("user001");
        mosnaiCheckParam.setKosTime("20150603111400000");
        BM_SyouhnZokusei syuSyouhnZokusei = bizDomManager.getSyouhnZokusei(syouhnCd13, syouhnsdNo13);
        mosnaiCheckParam.setSyuSyouhnZokusei(syuSyouhnZokusei);

        CheckZennouKanren checkZennouKanren = SWAKInjector.getInstance(CheckZennouKanren.class);
        checkZennouKanren.exec(mosnaiCheckParam);

        exClassificationEquals((C_KetsrhkosKbn) MockObjectManager.getArgument(SetHubiMsgMockForSinkeiyaku.class, "exec", 0, 0),
            C_KetsrhkosKbn.KETHORYU_HUBI, "決定・成立保留更新区分");
        exStringEquals((String) MockObjectManager.getArgument(SetHubiMsgMockForSinkeiyaku.class, "exec", 0, 1),
            "EHC1086 前納期間が全払込期間と同一です。全期前納に「あり」を指定してください。", "メッセージ文言");
    }

    @Test
    @Transactional
    @TestOrder(140)
    public void testExec_A14() {

        MockObjectManager.initialize();
        HanteiZennouKaisuuMockForSinkeiyaku.SYORIPTN = HanteiZennouKaisuuMockForSinkeiyaku.TESTPATTERN8;
        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL(mosNo14);

        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setKosID("user001");
        mosnaiCheckParam.setKosTime("20150603111400000");
        BM_SyouhnZokusei syuSyouhnZokusei = bizDomManager.getSyouhnZokusei(syouhnCd14, syouhnsdNo14);
        mosnaiCheckParam.setSyuSyouhnZokusei(syuSyouhnZokusei);
        CheckZennouKanren checkZennouKanren = SWAKInjector.getInstance(CheckZennouKanren.class);
        checkZennouKanren.exec(mosnaiCheckParam);

        exClassificationEquals((C_KetsrhkosKbn) MockObjectManager.getArgument(SetHubiMsgMockForSinkeiyaku.class, "exec", 0, 0),
            C_KetsrhkosKbn.KETHORYU_HUBI, "決定・成立保留更新区分");
        exStringEquals((String) MockObjectManager.getArgument(SetHubiMsgMockForSinkeiyaku.class, "exec", 0, 1),
            "EHC1087 前納期間が特約払込期間と同一です。全期前納に「あり」を指定してください。", "メッセージ文言");
    }

    @Test
    @Transactional
    @TestOrder(150)
    public void testExec_A15() {

        MockObjectManager.initialize();
        HanteiZennouKaisuuMockForSinkeiyaku.SYORIPTN = HanteiZennouKaisuuMockForSinkeiyaku.TESTPATTERN3;
        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL(mosNo15);

        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setKosID("user001");
        mosnaiCheckParam.setKosTime("20150603111400000");
        BM_SyouhnZokusei syuSyouhnZokusei = bizDomManager.getSyouhnZokusei(syouhnCd15, syouhnsdNo15);
        mosnaiCheckParam.setSyuSyouhnZokusei(syuSyouhnZokusei);

        CheckZennouKanren checkZennouKanren = SWAKInjector.getInstance(CheckZennouKanren.class);
        checkZennouKanren.exec(mosnaiCheckParam);
        MockObjectManager.assertNotCalled(SetHubiMsgMockForSinkeiyaku.class, "exec");
    }

    @Test
    @Transactional
    @TestOrder(160)
    public void testExec_A16() {

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL(mosNo16);

        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setKosID("user001");
        mosnaiCheckParam.setKosTime("20150603111400000");
        BM_SyouhnZokusei syuSyouhnZokusei = bizDomManager.getSyouhnZokusei(syouhnCd16, syouhnsdNo16);
        mosnaiCheckParam.setSyuSyouhnZokusei(syuSyouhnZokusei);

        CheckZennouKanren checkZennouKanren = SWAKInjector.getInstance(CheckZennouKanren.class);
        checkZennouKanren.exec(mosnaiCheckParam);
        MockObjectManager.assertNotCalled(SetHubiMsgMockForSinkeiyaku.class, "exec");
    }

    @Test
    @Transactional
    @TestOrder(170)
    public void testExec_A17() {

        MockObjectManager.initialize();
        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL(mosNo17);
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setKosID("user001");
        mosnaiCheckParam.setKosTime("20150603111400000");
        BM_SyouhnZokusei syuSyouhnZokusei = bizDomManager.getSyouhnZokusei(syouhnCd1, syouhnsdNo1);
        mosnaiCheckParam.setSyuSyouhnZokusei(syuSyouhnZokusei);

        CheckZennouKanren checkZennouKanren = SWAKInjector.getInstance(CheckZennouKanren.class);
        checkZennouKanren.exec(mosnaiCheckParam);

        exClassificationEquals((C_KetsrhkosKbn) MockObjectManager.getArgument(SetHubiMsgMockForSinkeiyaku.class, "exec", 0, 0),
            C_KetsrhkosKbn.KETHORYU_HUBI, "決定・成立保留更新区分");
        exStringEquals((String) MockObjectManager.getArgument(SetHubiMsgMockForSinkeiyaku.class, "exec", 0, 1),
            "EHC1109 払込経路が「振替」の場合、払込回数に「年１回払」を指定してください。", "メッセージ文言");
    }

    @Test
    @Transactional
    @TestOrder(180)
    public void testExec_A18() {

        MockObjectManager.initialize();
        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL(mosNo18);
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setKosID("user001");
        mosnaiCheckParam.setKosTime("20150603111400000");
        BM_SyouhnZokusei syuSyouhnZokusei = bizDomManager.getSyouhnZokusei(syouhnCd8, syouhnsdNo8);
        mosnaiCheckParam.setSyuSyouhnZokusei(syuSyouhnZokusei);

        CheckZennouKanren checkZennouKanren = SWAKInjector.getInstance(CheckZennouKanren.class);
        checkZennouKanren.exec(mosnaiCheckParam);

        exClassificationEquals((C_KetsrhkosKbn) MockObjectManager.getArgument(SetHubiMsgMockForSinkeiyaku.class, "exec", 0, 0),
            C_KetsrhkosKbn.KETHORYU_HUBI, "決定・成立保留更新区分");
        exStringEquals((String) MockObjectManager.getArgument(SetHubiMsgMockForSinkeiyaku.class, "exec", 0, 1),
            "EHC1109 払込経路が「振替」の場合、定期一括払回数に「１２か月定期一括払」を指定してください。", "メッセージ文言");
    }

    @Test
    @Transactional
    @TestOrder(190)
    public void testExec_A19() {

        MockObjectManager.initialize();
        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL(mosNo19);
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setKosID("user001");
        mosnaiCheckParam.setKosTime("20150603111400000");
        BM_SyouhnZokusei syuSyouhnZokusei = bizDomManager.getSyouhnZokusei(syouhnCd12, syouhnsdNo12);
        mosnaiCheckParam.setSyuSyouhnZokusei(syuSyouhnZokusei);

        CheckZennouKanren checkZennouKanren = SWAKInjector.getInstance(CheckZennouKanren.class);
        checkZennouKanren.exec(mosnaiCheckParam);

        exClassificationEquals((C_KetsrhkosKbn) MockObjectManager.getArgument(SetHubiMsgMockForSinkeiyaku.class, "exec", 0, 0),
            C_KetsrhkosKbn.KETHORYU_HUBI, "決定・成立保留更新区分");
        exStringEquals((String) MockObjectManager.getArgument(SetHubiMsgMockForSinkeiyaku.class, "exec", 0, 1),
            "EBC0045 前納保険料の入力が必要です。", "メッセージ文言");
    }

    @Test
    @Transactional
    @TestOrder(200)
    public void testExec_A20() {

        MockObjectManager.initialize();
        HanteiZennouKaisuuMockForSinkeiyaku.SYORIPTN = HanteiZennouKaisuuMockForSinkeiyaku.TESTPATTERN3;
        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL(mosNo20);
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setKosID("user001");
        mosnaiCheckParam.setKosTime("20150603111400000");
        BM_SyouhnZokusei syuSyouhnZokusei = bizDomManager.getSyouhnZokusei(syouhnCd12, syouhnsdNo12);
        mosnaiCheckParam.setSyuSyouhnZokusei(syuSyouhnZokusei);

        CheckZennouKanren checkZennouKanren = SWAKInjector.getInstance(CheckZennouKanren.class);
        checkZennouKanren.exec(mosnaiCheckParam);
        MockObjectManager.assertNotCalled(SetHubiMsgMockForSinkeiyaku.class, "exec");
    }

    @Test
    @Transactional
    @TestOrder(210)
    public void testExec_A21() {

        MockObjectManager.initialize();
        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL(mosNo21);
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setKosID("user001");
        mosnaiCheckParam.setKosTime("20150603111400000");
        BM_SyouhnZokusei syuSyouhnZokusei = bizDomManager.getSyouhnZokusei(syouhnCd1, syouhnsdNo1);
        mosnaiCheckParam.setSyuSyouhnZokusei(syuSyouhnZokusei);

        CheckZennouKanren checkZennouKanren = SWAKInjector.getInstance(CheckZennouKanren.class);
        checkZennouKanren.exec(mosnaiCheckParam);

        exClassificationEquals((C_KetsrhkosKbn) MockObjectManager.getArgument(SetHubiMsgMockForSinkeiyaku.class, "exec", 0, 0),
            C_KetsrhkosKbn.KETHORYU_HUBI, "決定・成立保留更新区分");
        exStringEquals((String) MockObjectManager.getArgument(SetHubiMsgMockForSinkeiyaku.class, "exec", 0, 1),
            "EBC0007 前納保険料は不要です。", "メッセージ文言");
    }

    @Test
    @Transactional
    @TestOrder(220)
    public void testExec_A22() {

        MockObjectManager.initialize();
        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL(mosNo19);
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setKosID("user001");
        mosnaiCheckParam.setKosTime("20150603111400000");
        mosnaiCheckParam.setSysKbn(C_SysKbn.ESHIEN);
        BM_SyouhnZokusei syuSyouhnZokusei = bizDomManager.getSyouhnZokusei(syouhnCd12, syouhnsdNo12);
        mosnaiCheckParam.setSyuSyouhnZokusei(syuSyouhnZokusei);

        CheckZennouKanren checkZennouKanren = SWAKInjector.getInstance(CheckZennouKanren.class);
        checkZennouKanren.exec(mosnaiCheckParam);
        MockObjectManager.assertNotCalled(SetHubiMsgMockForSinkeiyaku.class, "exec");
    }

    @Test
    @Transactional
    @TestOrder(230)
    public void testExec_A23() {

        MockObjectManager.initialize();
        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL(mosNo21);
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setKosID("user001");
        mosnaiCheckParam.setKosTime("20150603111400000");
        mosnaiCheckParam.setSysKbn(C_SysKbn.ESHIEN);
        BM_SyouhnZokusei syuSyouhnZokusei = bizDomManager.getSyouhnZokusei(syouhnCd1, syouhnsdNo1);
        mosnaiCheckParam.setSyuSyouhnZokusei(syuSyouhnZokusei);

        CheckZennouKanren checkZennouKanren = SWAKInjector.getInstance(CheckZennouKanren.class);
        checkZennouKanren.exec(mosnaiCheckParam);

        exClassificationEquals((C_KetsrhkosKbn) MockObjectManager.getArgument(SetHubiMsgMockForSinkeiyaku.class, "exec", 0, 0),
            C_KetsrhkosKbn.KETHORYU_HUBI, "決定・成立保留更新区分");
        exStringEquals((String) MockObjectManager.getArgument(SetHubiMsgMockForSinkeiyaku.class, "exec", 0, 1),
            "EHC1085 払込経路が「団体」の場合、前納は取扱えません。", "メッセージ文言");
    }
}
