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

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.app.base.ref.TestDataMaker;
import yuyu.app.base.ref.TestDataMakerException;
import yuyu.common.biz.exception.CommonBizAppException;
import yuyu.def.biz.manager.BizDomManager;
import yuyu.def.classification.C_SysKbn;
import yuyu.def.db.entity.HT_HubiMsg;
import yuyu.def.db.entity.HT_SyoriCTL;
import yuyu.def.sinkeiyaku.manager.SinkeiyakuDomManager;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;
import yuyu.testinfr.inject.MockModuleBinder;

import com.google.inject.AbstractModule;

/**
 * 年金支払特約チェックのメソッド {@link CheckNnknTokuyaku#exec(MosnaiCheckParam)} テスト用クラスです。<br />
 */
@RunWith(OrderedRunner.class)
public class CheckNnknTokuyakuTest_exec {

    private final static String syoNo1 = "791212129";

    private final static String syoNo2 = "791212137";

    private final static String syoNo3 = "791212145";

    private final static String syoNo4 = "791212152";

    private final static String syoNo5 = "791212160";

    private final static String syoNo6 = "791212178";

    private final static String syoNo7 = "791212186";

    private final static String syoNo8 = "791212194";

    private final static String syoNo9 = "791212202";

    private final static String syoNo10 = "791212210";

    private final static String syoNo11 = "791212228";

    private final static String syoNo12 = "791212236";

    private final static String syoNo13 = "791212244";

    private final static String syoNo14 = "791212251";

    private final static String syoNo15 = "889800009";

    private final static String fileName = "UT_SP_単体テスト仕様書_年金支払特約チェック";

    private final static String sheetName = "テストデータ";

    @Inject
    private MosnaiCheckParam mosnaiCheckParam;

    @Inject
    private SinkeiyakuDomManager sinkeiyakuDomManager;

    @BeforeClass
    @Transactional
    public static void insertTestData() {

        try {
            TestDataMaker testDataMaker = new TestDataMaker();
            HashMap<String, Map<String, List<Map<String, String>>>> testDataAndTblMap;
            testDataAndTblMap = testDataMaker.getInData(CheckNnknTokuyakuTest_exec.class, fileName, sheetName);
            testDataMaker.insDataByDataId("共通データ", testDataAndTblMap);
        } catch (TestDataMakerException e) {

            e.printStackTrace();
        }}

    @Before
    public void before(){
        MockModuleBinder.bind(new AbstractModule(){
            @Override
            protected void configure() {

                bind(SetHutuuSibouS.class).to(SetHutuuSibouSMockForSinkeiyaku.class);

            }
        });
    }

    @BeforeClass
    public static void testInit(){
        SetHutuuSibouSMockForSinkeiyaku.caller = CheckNnknTokuyakuTest_exec.class;
    }

    @AfterClass
    @Transactional
    public static void deleteTestData() {

        MockObjectManager.initialize();

        SinkeiyakuDomManager sinkeiyakuDomManager = SWAKInjector.getInstance(SinkeiyakuDomManager.class);
        sinkeiyakuDomManager.delete(sinkeiyakuDomManager.getAllSyoriCTL());
        BizDomManager bizDomManager = SWAKInjector.getInstance(BizDomManager.class);
        bizDomManager.delete(bizDomManager.getAllSyouhnZokusei());
        bizDomManager.delete(bizDomManager.getAllChkNenkinSaiteiS());
    }

    @AfterClass
    public static void clearCallerClass() {

        SetHutuuSibouSMockForSinkeiyaku.caller = null;
    }

    @Test
    @Transactional
    @TestOrder(10)
    public void testExec_A1() {

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL(syoNo1);
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setSysKbn(C_SysKbn.SKEI);
        mosnaiCheckParam.setKosID("user001");
        mosnaiCheckParam.setKosTime("20150603111400000");
        CheckNnknTokuyaku checkNnknTokuyaku = SWAKInjector.getInstance(CheckNnknTokuyaku.class);
        checkNnknTokuyaku.exec(mosnaiCheckParam);

        List<HT_HubiMsg> hubMsgLst = mosnaiCheckParam.getListHubiMsg();
        exNumericEquals(hubMsgLst.size(), 1, "不備メッセージ件数");
        exStringEquals(hubMsgLst.get(0).getMessageId(), "EHC0001", "不備メッセージID");
        exStringEquals(hubMsgLst.get(0).getHubimsg(), "年金支払特約死亡年金種類関係項目に入力漏れがあります。", "不備メッセージ");
    }

    @Test
    @Transactional
    @TestOrder(20)
    public void testExec_A2() {
        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL(syoNo2);
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setKosID("user001");
        mosnaiCheckParam.setKosTime("20150603111400000");
        CheckNnknTokuyaku checkNnknTokuyaku = SWAKInjector.getInstance(CheckNnknTokuyaku.class);
        checkNnknTokuyaku.exec(mosnaiCheckParam);

        List<HT_HubiMsg> hubMsgLst = mosnaiCheckParam.getListHubiMsg();
        exNumericEquals(hubMsgLst.size(), 1, "不備メッセージ件数");
        exStringEquals(hubMsgLst.get(0).getMessageId(), "EHC0001", "不備メッセージID");
        exStringEquals(hubMsgLst.get(0).getHubimsg(), "年金支払特約死亡年金種類関係項目に入力漏れがあります。", "不備メッセージ");
    }

    @Test
    @TestOrder(30)
    public void testExec_A3() {
        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL(syoNo3);
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setKosID("user001");
        mosnaiCheckParam.setKosTime("20150603111400000");
        CheckNnknTokuyaku checkNnknTokuyaku = SWAKInjector.getInstance(CheckNnknTokuyaku.class);
        checkNnknTokuyaku.exec(mosnaiCheckParam);

        List<HT_HubiMsg> hubMsgLst = mosnaiCheckParam.getListHubiMsg();
        exNumericEquals(hubMsgLst.size(), 1, "不備メッセージ件数");
        exStringEquals(hubMsgLst.get(0).getMessageId(), "EHC0038", "不備メッセージID");
        exStringEquals(hubMsgLst.get(0).getHubimsg(), "確定年金の年金支払特約死亡年金期間が取扱範囲外です。", "不備メッセージ");
    }

    @Test
    @Transactional
    @TestOrder(40)
    public void testExec_A4() {
        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL(syoNo4);
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setKosID("user001");
        mosnaiCheckParam.setKosTime("20150603111400000");
        CheckNnknTokuyaku checkNnknTokuyaku = SWAKInjector.getInstance(CheckNnknTokuyaku.class);
        checkNnknTokuyaku.exec(mosnaiCheckParam);

        List<HT_HubiMsg> hubMsgLst = mosnaiCheckParam.getListHubiMsg();
        exNumericEquals(hubMsgLst.size(), 1, "不備メッセージ件数");
        exStringEquals(hubMsgLst.get(0).getMessageId(), "EHC0001", "不備メッセージID");
        exStringEquals(hubMsgLst.get(0).getHubimsg(), "年金支払特約死亡年金種類関係項目に入力漏れがあります。", "不備メッセージ");
    }

    @Test
    @Transactional
    @TestOrder(50)
    public void testExec_A5() {
        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL(syoNo5);
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setKosID("user001");
        mosnaiCheckParam.setKosTime("20150603111400000");
        CheckNnknTokuyaku checkNnknTokuyaku = SWAKInjector.getInstance(CheckNnknTokuyaku.class);
        checkNnknTokuyaku.exec(mosnaiCheckParam);

        List<HT_HubiMsg> hubMsgLst = mosnaiCheckParam.getListHubiMsg();
        exNumericEquals(hubMsgLst.size(), 1, "不備メッセージ件数");
        exStringEquals(hubMsgLst.get(0).getMessageId(), "EHC0001", "不備メッセージID");
        exStringEquals(hubMsgLst.get(0).getHubimsg(), "年金支払特約死亡年金種類関係項目に入力漏れがあります。", "不備メッセージ");
    }

    @Test
    @Transactional
    @TestOrder(60)
    public void testExec_A6() {
        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL(syoNo6);
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setKosID("user001");
        mosnaiCheckParam.setKosTime("20150603111400000");
        CheckNnknTokuyaku checkNnknTokuyaku = SWAKInjector.getInstance(CheckNnknTokuyaku.class);
        checkNnknTokuyaku.exec(mosnaiCheckParam);

        List<HT_HubiMsg> hubMsgLst = mosnaiCheckParam.getListHubiMsg();
        exNumericEquals(hubMsgLst.size(), 1, "不備メッセージ件数");
        exStringEquals(hubMsgLst.get(0).getMessageId(), "EHC0001", "不備メッセージID");
        exStringEquals(hubMsgLst.get(0).getHubimsg(), "年金支払特約死亡年金種類関係項目に入力漏れがあります。", "不備メッセージ");
    }

    @Test
    @Transactional
    @TestOrder(70)
    public void testExec_A7() {
        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL(syoNo7);
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setKosID("user001");
        mosnaiCheckParam.setKosTime("20150603111400000");
        CheckNnknTokuyaku checkNnknTokuyaku = SWAKInjector.getInstance(CheckNnknTokuyaku.class);
        checkNnknTokuyaku.exec(mosnaiCheckParam);

        List<HT_HubiMsg> hubMsgLst = mosnaiCheckParam.getListHubiMsg();
        exNumericEquals(hubMsgLst.size(), 0, "不備メッセージ件数");

    }

    @Test
    @Transactional
    @TestOrder(80)
    public void testExec_A8() {
        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL(syoNo8);
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setKosID("user001");
        mosnaiCheckParam.setKosTime("20150603111400000");
        CheckNnknTokuyaku checkNnknTokuyaku = SWAKInjector.getInstance(CheckNnknTokuyaku.class);
        checkNnknTokuyaku.exec(mosnaiCheckParam);

        List<HT_HubiMsg> hubMsgLst = mosnaiCheckParam.getListHubiMsg();
        exNumericEquals(hubMsgLst.size(), 1, "不備メッセージ件数");
        exStringEquals(hubMsgLst.get(0).getMessageId(), "EHC0001", "不備メッセージID");
        exStringEquals(hubMsgLst.get(0).getHubimsg(), "年金支払特約死亡年金種類関係項目に入力漏れがあります。", "不備メッセージ");
    }

    @Test(expected = CommonBizAppException.class)
    @TestOrder(90)
    public void testExec_A9() {
        try {
            HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL(syoNo9);
            mosnaiCheckParam.setDataSyoriControl(syoriCTL);
            mosnaiCheckParam.setKosID("user001");
            mosnaiCheckParam.setKosTime("20150603111400000");
            CheckNnknTokuyaku checkNnknTokuyaku = SWAKInjector.getInstance(CheckNnknTokuyaku.class);
            checkNnknTokuyaku.exec(mosnaiCheckParam);

        } catch (CommonBizAppException e) {
            exStringEquals(e.getMessage(), "システム整合性エラーです。主契約申込商品件数異常 申込番号：791212202", "エラーメッセージ");
            throw e;
        }
    }

    @Test
    @Transactional
    @TestOrder(100)
    public void testExec_A10() {

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL(syoNo10);
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setKosID("user001");
        mosnaiCheckParam.setKosTime("20150603111400000");
        CheckNnknTokuyaku checkNnknTokuyaku = SWAKInjector.getInstance(CheckNnknTokuyaku.class);
        checkNnknTokuyaku.exec(mosnaiCheckParam);

        List<HT_HubiMsg> hubMsgLst = mosnaiCheckParam.getListHubiMsg();

        exNumericEquals(hubMsgLst.size(), 1, "不備メッセージ件数");

        exStringEquals(hubMsgLst.get(0).getMessageId(), "EHC0038", "不備メッセージID");
        exStringEquals(hubMsgLst.get(0).getHubimsg(), "確定年金の年金支払特約死亡年金期間が取扱範囲外です。", "不備メッセージ");

    }

    @Test
    @Transactional
    @TestOrder(110)
    public void testExec_A11() {

        SetHutuuSibouSMockForSinkeiyaku.SYORIPTN = SetHutuuSibouSMockForSinkeiyaku.TESTPATTERN1;
        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL(syoNo11);
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setKosID("user001");
        mosnaiCheckParam.setKosTime("20150603111400000");
        CheckNnknTokuyaku checkNnknTokuyaku = SWAKInjector.getInstance(CheckNnknTokuyaku.class);
        checkNnknTokuyaku.exec(mosnaiCheckParam);

        List<HT_HubiMsg> hubMsgLst = mosnaiCheckParam.getListHubiMsg();
        exNumericEquals(hubMsgLst.size(), 2, "不備メッセージ件数");
        exStringEquals(hubMsgLst.get(0).getMessageId(), "EHC0019", "不備メッセージID");
        exStringEquals(hubMsgLst.get(0).getHubimsg(), "商品名２の確定年金は取扱えません。", "不備メッセージ");

        exStringEquals(hubMsgLst.get(1).getMessageId(), "EHC0015", "不備メッセージID");
        exStringEquals(hubMsgLst.get(1).getHubimsg(), "保険金額が確定年金の年金最低Ｓ２円に未達です。", "不備メッセージ");
    }

    @Test
    @TestOrder(120)
    public void testExec_A12() {

        SetHutuuSibouSMockForSinkeiyaku.SYORIPTN = SetHutuuSibouSMockForSinkeiyaku.TESTPATTERN1;
        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL(syoNo12);
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setKosID("user001");
        mosnaiCheckParam.setKosTime("20150603111400000");
        CheckNnknTokuyaku checkNnknTokuyaku = SWAKInjector.getInstance(CheckNnknTokuyaku.class);
        checkNnknTokuyaku.exec(mosnaiCheckParam);

        List<HT_HubiMsg> hubMsgLst = mosnaiCheckParam.getListHubiMsg();
        exNumericEquals(hubMsgLst.size(), 1, "不備メッセージ件数");
        exStringEquals(hubMsgLst.get(0).getMessageId(), "EHC0019", "不備メッセージID");
        exStringEquals(hubMsgLst.get(0).getHubimsg(), "商品名２の確定年金は取扱えません。", "不備メッセージ");

    }

    @Test
    @TestOrder(130)
    public void testExec_A13() {

        SetHutuuSibouSMockForSinkeiyaku.SYORIPTN = SetHutuuSibouSMockForSinkeiyaku.TESTPATTERN1;
        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL(syoNo13);
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setKosID("user001");
        mosnaiCheckParam.setKosTime("20150603111400000");
        CheckNnknTokuyaku checkNnknTokuyaku = SWAKInjector.getInstance(CheckNnknTokuyaku.class);
        checkNnknTokuyaku.exec(mosnaiCheckParam);

        List<HT_HubiMsg> hubMsgLst = mosnaiCheckParam.getListHubiMsg();
        exNumericEquals(hubMsgLst.size(), 1, "不備メッセージ件数");
        exStringEquals(hubMsgLst.get(0).getMessageId(), "EHC0019", "不備メッセージID");
        exStringEquals(hubMsgLst.get(0).getHubimsg(), "商品名２の確定年金は取扱えません。", "不備メッセージ");

    }

    @Test
    @TestOrder(140)
    public void testExec_A14() {

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL(syoNo14);
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setKosID("user001");
        mosnaiCheckParam.setKosTime("20150603111400000");
        CheckNnknTokuyaku checkNnknTokuyaku = SWAKInjector.getInstance(CheckNnknTokuyaku.class);
        checkNnknTokuyaku.exec(mosnaiCheckParam);

        List<HT_HubiMsg> hubMsgLst = mosnaiCheckParam.getListHubiMsg();

        exNumericEquals(hubMsgLst.size(), 0, "不備メッセージ件数");

    }

    @Test
    @TestOrder(150)
    public void testExec_A15() {

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL(syoNo15);
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setListHubiMsg(new ArrayList<HT_HubiMsg>());
        mosnaiCheckParam.setKosID("user001");
        mosnaiCheckParam.setKosTime("20150603111400000");
        CheckNnknTokuyaku checkNnknTokuyaku = SWAKInjector.getInstance(CheckNnknTokuyaku.class);
        checkNnknTokuyaku.exec(mosnaiCheckParam);

        List<HT_HubiMsg> hubMsgLst = mosnaiCheckParam.getListHubiMsg();

        exNumericEquals(hubMsgLst.size(), 0, "不備メッセージ件数");

    }
}
