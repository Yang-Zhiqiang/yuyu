package yuyu.common.sinkeiyaku.moschk;

import static yuyu.testinfr.YuyuFunctionTestUtil.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.dgic.testing.common.virtualmock.MockObjectManager;
import jp.co.slcs.swak.core.inject.SWAKInjector;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import com.google.inject.AbstractModule;

import yuyu.app.base.ref.TestDataMaker;
import yuyu.app.base.ref.TestDataMakerException;
import yuyu.def.biz.manager.BizDomManager;
import yuyu.def.classification.C_KetsrhkosKbn;
import yuyu.def.classification.C_MsgKbn;
import yuyu.def.classification.C_SysKbn;
import yuyu.def.classification.C_TknKbn;
import yuyu.def.db.entity.BM_SyouhnZokusei;
import yuyu.def.db.entity.HT_SyoriCTL;
import yuyu.def.sinkeiyaku.manager.SinkeiyakuDomManager;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;
import yuyu.testinfr.inject.MockModuleBinder;

/**
 * 払込経路チェッククラスのメソッド {@link CheckHrkKeiro#exec(MosnaiCheckParam, BM_SyouhnZokusei)} テスト用クラスです。<br />
 */
@RunWith(OrderedRunner.class)
public class CheckHrkKeiroTest_exec {

    private final static String mosNo1 = "791112220";

    private final static String mosNo2 = "791112238";

    private final static String mosNo3 = "791112246";

    private final static String mosNo4 = "791123235";

    private final static String mosNo5 = "791123243";

    private final static String mosNo6 = "860000017";

    private final static String mosNo7 = "860000025";

    private final static String mosNo8 = "860000033";

    private final static String mosNo9 = "860000041";

    private final static String mosNo10 = "860000058";

    private final static String mosNo11 = "860000066";

    private final static String mosNo12 = "860000074";

    private final static String mosNo13 = "860000082";

    @Inject
    private MosnaiCheckParam mosnaiCheckParam;

    @Inject
    private SinkeiyakuDomManager sinkeiyakuDomManager;

    @Inject
    private BizDomManager bizDomManager;

    private final static String fileName = "UT_SP_単体テスト仕様書_払込経路チェック";
    private final static String sheetName = "テストデータ";

    @Before
    public void before(){
        MockModuleBinder.bind(new AbstractModule(){
            @Override
            protected void configure() {
                bind(SetHubiMsg.class).to(SetHubiMsgMockForSinkeiyaku.class);
            }
        });
    }

    @BeforeClass
    public static void testInit() {

        SetHubiMsgMockForSinkeiyaku.caller = CheckHrkKeiroTest_exec.class;
        SetHubiMsgMockForSinkeiyaku.SYORIPTN = null;
    }

    @AfterClass
    public static void testClear() {

        SetHubiMsgMockForSinkeiyaku.caller = null;
        MockObjectManager.initialize();

    }

    @BeforeClass
    @Transactional
    public static void insertTestData() {
        try {

            TestDataMaker testDataMaker = new TestDataMaker();

            HashMap<String, Map<String, List<Map<String, String>>>> testDataAndTblMap;

            testDataAndTblMap = testDataMaker.getInData(CheckHrkKeiroTest_exec.class, fileName,
                sheetName);

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
    }

    @Test
    @TestOrder(10)
    public void testExec_A1() {
        MockObjectManager.initialize();
        MockObjectManager.initialize();
        SetHubiMsgMockForSinkeiyaku.SYORIPTN = SetHubiMsgMockForSinkeiyaku.TESTPATTERN1;

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL(mosNo1);

        BM_SyouhnZokusei syouhnZokusei = bizDomManager.getSyouhnZokusei("1002", 1);
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setSysKbn(C_SysKbn.ESHIEN);
        CheckHrkKeiro checkHrkKeiro = SWAKInjector.getInstance(CheckHrkKeiro.class);
        checkHrkKeiro.exec(mosnaiCheckParam, syouhnZokusei);

        exClassificationEquals((C_KetsrhkosKbn) MockObjectManager.getArgument(SetHubiMsgMockForSinkeiyaku.class, "exec", 0, 0),
            C_KetsrhkosKbn.KETHORYU_HUBI, "決定・成立保留更新区分");
        exStringEquals((String) MockObjectManager.getArgument(SetHubiMsgMockForSinkeiyaku.class, "exec", 0, 1),
            "EBA0027 払込経路を入力してください。", "メッセージ文言");

    }

    @Test
    @TestOrder(20)
    public void testExec_A2() {
        MockObjectManager.initialize();
        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL(mosNo2);

        BM_SyouhnZokusei syouhnZokusei = bizDomManager.getSyouhnZokusei("1002", 1);
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setSysKbn(C_SysKbn.ESHIEN);
        CheckHrkKeiro checkHrkKeiro = SWAKInjector.getInstance(CheckHrkKeiro.class);
        checkHrkKeiro.exec(mosnaiCheckParam, syouhnZokusei);
        exClassificationEquals((C_KetsrhkosKbn) MockObjectManager.getArgument(SetHubiMsgMockForSinkeiyaku.class, "exec", 0, 0),
            C_KetsrhkosKbn.KETHORYU_HUBI, "決定・成立保留更新区分");
        exStringEquals((String) MockObjectManager.getArgument(SetHubiMsgMockForSinkeiyaku.class, "exec", 0, 1),
            "EHC0019 医療終身保険（無解約返戻金型）の振替は取扱えません。", "メッセージ文言");

    }

    @Test
    @TestOrder(30)
    public void testExec_A3() {
        MockObjectManager.initialize();
        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL(mosNo3);

        BM_SyouhnZokusei syouhnZokusei = bizDomManager.getSyouhnZokusei("1001", 1);
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setSysKbn(C_SysKbn.ESHIEN);
        CheckHrkKeiro checkHrkKeiro = SWAKInjector.getInstance(CheckHrkKeiro.class);
        checkHrkKeiro.exec(mosnaiCheckParam, syouhnZokusei);
        exClassificationEquals((C_KetsrhkosKbn) MockObjectManager.getArgument(SetHubiMsgMockForSinkeiyaku.class, "exec", 0, 0),
            C_KetsrhkosKbn.KETHORYU_HUBI, "決定・成立保留更新区分");
        exStringEquals((String) MockObjectManager.getArgument(SetHubiMsgMockForSinkeiyaku.class, "exec", 0, 1),
            "EHC0111 払込経路と初回保険料払込経路の関係が正しくありません。", "メッセージ文言");
        exClassificationEquals((C_KetsrhkosKbn) MockObjectManager.getArgument(SetHubiMsgMockForSinkeiyaku.class, "exec", 1, 0),
            C_KetsrhkosKbn.KETHORYU_HUBI, "決定・成立保留更新区分");
        exStringEquals((String) MockObjectManager.getArgument(SetHubiMsgMockForSinkeiyaku.class, "exec", 1, 1),
            "EHC0165 初回保険料払込経路が 口座振替扱い の一時払いは取扱えません。", "メッセージ文言");

    }

    @Test
    @TestOrder(40)
    public void testExec_A4() {
        MockObjectManager.initialize();
        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL(mosNo4);

        BM_SyouhnZokusei syouhnZokusei = bizDomManager.getSyouhnZokusei("1002", 1);
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setSysKbn(C_SysKbn.ESHIEN);
        CheckHrkKeiro checkHrkKeiro = SWAKInjector.getInstance(CheckHrkKeiro.class);
        checkHrkKeiro.exec(mosnaiCheckParam, syouhnZokusei);
        exClassificationEquals((C_KetsrhkosKbn) MockObjectManager.getArgument(SetHubiMsgMockForSinkeiyaku.class, "exec", 0, 0),
            C_KetsrhkosKbn.KETHORYU_HUBI, "決定・成立保留更新区分");
        exStringEquals((String) MockObjectManager.getArgument(SetHubiMsgMockForSinkeiyaku.class, "exec", 0, 1),
            "EHC0111 払込経路と初回保険料払込経路の関係が正しくありません。", "メッセージ文言");

    }

    @Test
    @TestOrder(50)
    public void testExec_A5() {
        MockObjectManager.initialize();
        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL(mosNo5);

        BM_SyouhnZokusei syouhnZokusei = bizDomManager.getSyouhnZokusei("1002", 1);
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        CheckHrkKeiro checkHrkKeiro = SWAKInjector.getInstance(CheckHrkKeiro.class);
        checkHrkKeiro.exec(mosnaiCheckParam, syouhnZokusei);
        exClassificationEquals((C_KetsrhkosKbn) MockObjectManager.getArgument(SetHubiMsgMockForSinkeiyaku.class, "exec", 0, 0),
            C_KetsrhkosKbn.KETHORYU_HUBI, "決定・成立保留更新区分");
        exStringEquals((String) MockObjectManager.getArgument(SetHubiMsgMockForSinkeiyaku.class, "exec", 0, 1),
            "EHC0019 医療終身保険（無解約返戻金型）のクレジットカード扱いは取扱えません。", "メッセージ文言");

        exClassificationEquals((C_KetsrhkosKbn) MockObjectManager.getArgument(SetHubiMsgMockForSinkeiyaku.class, "exec", 1, 0),
            C_KetsrhkosKbn.KETHORYU_HUBI, "決定・成立保留更新区分");
        exStringEquals((String) MockObjectManager.getArgument(SetHubiMsgMockForSinkeiyaku.class, "exec", 1, 1),
            "EHC0209 初回保険料払込経路または払込経路がクレジットカード扱いの一時払いは取扱えません。", "メッセージ文言");

        exClassificationEquals((C_TknKbn) MockObjectManager.getArgument(SetHubiMsgMockForSinkeiyaku.class, "exec", 1, 3),
            C_TknKbn.NONE, "特認区分");
        exClassificationEquals((C_MsgKbn) MockObjectManager.getArgument(SetHubiMsgMockForSinkeiyaku.class, "exec", 1, 4),
            C_MsgKbn.ERROR, "メッセージ区分");

    }

    @Test
    @TestOrder(60)
    public void testExec_A6() {
        MockObjectManager.initialize();
        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL(mosNo6);

        BM_SyouhnZokusei syouhnZokusei = bizDomManager.getSyouhnZokusei("1002", 1);
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        CheckHrkKeiro checkHrkKeiro = SWAKInjector.getInstance(CheckHrkKeiro.class);
        checkHrkKeiro.exec(mosnaiCheckParam, syouhnZokusei);
        exClassificationEquals((C_KetsrhkosKbn) MockObjectManager.getArgument(SetHubiMsgMockForSinkeiyaku.class, "exec", 0, 0),
            C_KetsrhkosKbn.KETHORYU_HUBI, "決定・成立保留更新区分");
        exStringEquals((String) MockObjectManager.getArgument(SetHubiMsgMockForSinkeiyaku.class, "exec", 0, 1),
            "EHC0019 医療終身保険（無解約返戻金型）のクレジットカード扱いは取扱えません。", "メッセージ文言");

    }

    @Test
    @TestOrder(70)
    public void testExec_A7() {
        MockObjectManager.initialize();
        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL(mosNo7);

        BM_SyouhnZokusei syouhnZokusei = bizDomManager.getSyouhnZokusei("1001", 1);
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        CheckHrkKeiro checkHrkKeiro = SWAKInjector.getInstance(CheckHrkKeiro.class);
        checkHrkKeiro.exec(mosnaiCheckParam, syouhnZokusei);
        exClassificationEquals((C_KetsrhkosKbn) MockObjectManager.getArgument(SetHubiMsgMockForSinkeiyaku.class, "exec", 0, 0),
            C_KetsrhkosKbn.KETHORYU_HUBI, "決定・成立保留更新区分");
        exStringEquals((String) MockObjectManager.getArgument(SetHubiMsgMockForSinkeiyaku.class, "exec", 0, 1),
            "EHC0111 払込経路と初回保険料払込経路の関係が正しくありません。", "メッセージ文言");

    }

    @Test
    @TestOrder(80)
    public void testExec_A8() {
        MockObjectManager.initialize();
        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL(mosNo8);

        BM_SyouhnZokusei syouhnZokusei = bizDomManager.getSyouhnZokusei("1001", 1);
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        CheckHrkKeiro checkHrkKeiro = SWAKInjector.getInstance(CheckHrkKeiro.class);
        checkHrkKeiro.exec(mosnaiCheckParam, syouhnZokusei);
        exClassificationEquals((C_KetsrhkosKbn) MockObjectManager.getArgument(SetHubiMsgMockForSinkeiyaku.class, "exec", 0, 0),
            C_KetsrhkosKbn.KETHORYU_HUBI, "決定・成立保留更新区分");
        exStringEquals((String) MockObjectManager.getArgument(SetHubiMsgMockForSinkeiyaku.class, "exec", 0, 1),
            "EHC1127 初回保険料払込経路がクレジットカード扱いは取扱えません。", "メッセージ文言");

    }

    @Test
    @TestOrder(90)
    public void testExec_A9() {
        MockObjectManager.initialize();
        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL(mosNo9);

        BM_SyouhnZokusei syouhnZokusei = bizDomManager.getSyouhnZokusei("1002", 1);
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        CheckHrkKeiro checkHrkKeiro = SWAKInjector.getInstance(CheckHrkKeiro.class);
        checkHrkKeiro.exec(mosnaiCheckParam, syouhnZokusei);
        exClassificationEquals((C_KetsrhkosKbn) MockObjectManager.getArgument(SetHubiMsgMockForSinkeiyaku.class, "exec", 0, 0),
            C_KetsrhkosKbn.KETHORYU_HUBI, "決定・成立保留更新区分");
        exStringEquals((String) MockObjectManager.getArgument(SetHubiMsgMockForSinkeiyaku.class, "exec", 0, 1),
            "EHC0111 払込経路と初回保険料払込経路の関係が正しくありません。", "メッセージ文言");

    }

    @Test
    @TestOrder(100)
    public void testExec_A10() {
        MockObjectManager.initialize();
        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL(mosNo10);

        BM_SyouhnZokusei syouhnZokusei = bizDomManager.getSyouhnZokusei("1001", 1);
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        CheckHrkKeiro checkHrkKeiro = SWAKInjector.getInstance(CheckHrkKeiro.class);
        checkHrkKeiro.exec(mosnaiCheckParam, syouhnZokusei);
        exClassificationEquals((C_KetsrhkosKbn) MockObjectManager.getArgument(SetHubiMsgMockForSinkeiyaku.class, "exec", 0, 0),
            C_KetsrhkosKbn.KETHORYU_HUBI, "決定・成立保留更新区分");
        exStringEquals((String) MockObjectManager.getArgument(SetHubiMsgMockForSinkeiyaku.class, "exec", 0, 1),
            "EHC0209 初回保険料払込経路または払込経路がクレジットカード扱いの年１回払は取扱えません。", "メッセージ文言");
        exClassificationEquals((C_TknKbn) MockObjectManager.getArgument(SetHubiMsgMockForSinkeiyaku.class, "exec", 0, 3),
            C_TknKbn.NONE, "特認区分");
        exClassificationEquals((C_MsgKbn) MockObjectManager.getArgument(SetHubiMsgMockForSinkeiyaku.class, "exec", 0, 4),
            C_MsgKbn.ERROR, "メッセージ区分");

    }

    @Test
    @TestOrder(110)
    public void testExec_A11() {
        MockObjectManager.initialize();
        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL(mosNo11);

        BM_SyouhnZokusei syouhnZokusei = bizDomManager.getSyouhnZokusei("1001", 1);
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        CheckHrkKeiro checkHrkKeiro = SWAKInjector.getInstance(CheckHrkKeiro.class);
        checkHrkKeiro.exec(mosnaiCheckParam, syouhnZokusei);
        exClassificationEquals((C_KetsrhkosKbn) MockObjectManager.getArgument(SetHubiMsgMockForSinkeiyaku.class, "exec", 0, 0),
            C_KetsrhkosKbn.KETHORYU_HUBI, "決定・成立保留更新区分");
        exStringEquals((String) MockObjectManager.getArgument(SetHubiMsgMockForSinkeiyaku.class, "exec", 0, 1),
            "EHC0209 初回保険料払込経路または払込経路がクレジットカード扱いの３か月一括払は取扱えません。", "メッセージ文言");
        exClassificationEquals((C_TknKbn) MockObjectManager.getArgument(SetHubiMsgMockForSinkeiyaku.class, "exec", 0, 3),
            C_TknKbn.NONE, "特認区分");
        exClassificationEquals((C_MsgKbn) MockObjectManager.getArgument(SetHubiMsgMockForSinkeiyaku.class, "exec", 0, 4),
            C_MsgKbn.ERROR, "メッセージ区分");

    }

    @Test
    @TestOrder(120)
    public void testExec_A12() {
        MockObjectManager.initialize();
        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL(mosNo12);

        BM_SyouhnZokusei syouhnZokusei = bizDomManager.getSyouhnZokusei("1002", 1);
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        CheckHrkKeiro checkHrkKeiro = SWAKInjector.getInstance(CheckHrkKeiro.class);
        checkHrkKeiro.exec(mosnaiCheckParam, syouhnZokusei);
        exClassificationEquals((C_KetsrhkosKbn) MockObjectManager.getArgument(SetHubiMsgMockForSinkeiyaku.class, "exec", 0, 0),
            C_KetsrhkosKbn.KETHORYU_HUBI, "決定・成立保留更新区分");
        exStringEquals((String) MockObjectManager.getArgument(SetHubiMsgMockForSinkeiyaku.class, "exec", 0, 1),
            "EHC0111 払込経路と初回保険料払込経路の関係が正しくありません。", "メッセージ文言");

        exClassificationEquals((C_KetsrhkosKbn) MockObjectManager.getArgument(SetHubiMsgMockForSinkeiyaku.class, "exec", 1, 0),
            C_KetsrhkosKbn.KETHORYU_HUBI, "決定・成立保留更新区分");
        exStringEquals((String) MockObjectManager.getArgument(SetHubiMsgMockForSinkeiyaku.class, "exec", 1, 1),
            "EHC1127 初回保険料払込経路がクレジットカード扱いは取扱えません。", "メッセージ文言");

        exClassificationEquals((C_KetsrhkosKbn) MockObjectManager.getArgument(SetHubiMsgMockForSinkeiyaku.class, "exec", 2, 0),
            C_KetsrhkosKbn.KETHORYU_HUBI, "決定・成立保留更新区分");
        exStringEquals((String) MockObjectManager.getArgument(SetHubiMsgMockForSinkeiyaku.class, "exec", 2, 1),
            "EHC0209 初回保険料払込経路または払込経路がクレジットカード扱いの年２回払は取扱えません。", "メッセージ文言");
        exClassificationEquals((C_TknKbn) MockObjectManager.getArgument(SetHubiMsgMockForSinkeiyaku.class, "exec", 2, 3),
            C_TknKbn.NONE, "特認区分");
        exClassificationEquals((C_MsgKbn) MockObjectManager.getArgument(SetHubiMsgMockForSinkeiyaku.class, "exec", 2, 4),
            C_MsgKbn.ERROR, "メッセージ区分");

        exClassificationEquals((C_KetsrhkosKbn) MockObjectManager.getArgument(SetHubiMsgMockForSinkeiyaku.class, "exec", 3, 0),
            C_KetsrhkosKbn.KETHORYU_HUBI, "決定・成立保留更新区分");
        exStringEquals((String) MockObjectManager.getArgument(SetHubiMsgMockForSinkeiyaku.class, "exec", 3, 1),
            "EHC0209 初回保険料払込経路または払込経路がクレジットカード扱いの２か月一括払は取扱えません。", "メッセージ文言");
        exClassificationEquals((C_TknKbn) MockObjectManager.getArgument(SetHubiMsgMockForSinkeiyaku.class, "exec", 3, 3),
            C_TknKbn.NONE, "特認区分");
        exClassificationEquals((C_MsgKbn) MockObjectManager.getArgument(SetHubiMsgMockForSinkeiyaku.class, "exec", 3, 4),
            C_MsgKbn.ERROR, "メッセージ区分");

    }

    @Test
    @TestOrder(130)
    public void testExec_A13() {
        MockObjectManager.initialize();
        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL(mosNo13);

        BM_SyouhnZokusei syouhnZokusei = bizDomManager.getSyouhnZokusei("1002", 1);
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        CheckHrkKeiro checkHrkKeiro = SWAKInjector.getInstance(CheckHrkKeiro.class);
        checkHrkKeiro.exec(mosnaiCheckParam, syouhnZokusei);
        exClassificationEquals((C_KetsrhkosKbn) MockObjectManager.getArgument(SetHubiMsgMockForSinkeiyaku.class, "exec", 0, 0),
            C_KetsrhkosKbn.KETHORYU_HUBI, "決定・成立保留更新区分");
        exStringEquals((String) MockObjectManager.getArgument(SetHubiMsgMockForSinkeiyaku.class, "exec", 0, 1),
            "EHC0019 医療終身保険（無解約返戻金型）のクレジットカード扱いは取扱えません。", "メッセージ文言");

        exClassificationEquals((C_KetsrhkosKbn) MockObjectManager.getArgument(SetHubiMsgMockForSinkeiyaku.class, "exec", 1, 0),
            C_KetsrhkosKbn.KETHORYU_HUBI, "決定・成立保留更新区分");
        exStringEquals((String) MockObjectManager.getArgument(SetHubiMsgMockForSinkeiyaku.class, "exec", 1, 1),
            "EHC0111 払込経路と初回保険料払込経路の関係が正しくありません。", "メッセージ文言");

        exClassificationEquals((C_KetsrhkosKbn) MockObjectManager.getArgument(SetHubiMsgMockForSinkeiyaku.class, "exec", 2, 0),
            C_KetsrhkosKbn.KETHORYU_HUBI, "決定・成立保留更新区分");
        exStringEquals((String) MockObjectManager.getArgument(SetHubiMsgMockForSinkeiyaku.class, "exec", 2, 1),
            "EHC0209 初回保険料払込経路または払込経路がクレジットカード扱いの年２回払は取扱えません。", "メッセージ文言");
        exClassificationEquals((C_TknKbn) MockObjectManager.getArgument(SetHubiMsgMockForSinkeiyaku.class, "exec", 2, 3),
            C_TknKbn.NONE, "特認区分");
        exClassificationEquals((C_MsgKbn) MockObjectManager.getArgument(SetHubiMsgMockForSinkeiyaku.class, "exec", 2, 4),
            C_MsgKbn.ERROR, "メッセージ区分");

        exClassificationEquals((C_KetsrhkosKbn) MockObjectManager.getArgument(SetHubiMsgMockForSinkeiyaku.class, "exec", 3, 0),
            C_KetsrhkosKbn.KETHORYU_HUBI, "決定・成立保留更新区分");
        exStringEquals((String) MockObjectManager.getArgument(SetHubiMsgMockForSinkeiyaku.class, "exec", 3, 1),
            "EHC0209 初回保険料払込経路または払込経路がクレジットカード扱いの２か月一括払は取扱えません。", "メッセージ文言");
        exClassificationEquals((C_TknKbn) MockObjectManager.getArgument(SetHubiMsgMockForSinkeiyaku.class, "exec", 3, 3),
            C_TknKbn.NONE, "特認区分");
        exClassificationEquals((C_MsgKbn) MockObjectManager.getArgument(SetHubiMsgMockForSinkeiyaku.class, "exec", 3, 4),
            C_MsgKbn.ERROR, "メッセージ区分");

    }

}