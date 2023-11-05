package yuyu.common.sinkeiyaku.moschk;

import static yuyu.testinfr.YuyuFunctionTestUtil.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.dgic.testing.common.virtualmock.MockObjectManager;
import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.core.test.SWAKTestRunner;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.app.base.ref.TestDataMaker;
import yuyu.app.base.ref.TestDataMakerException;
import yuyu.def.classification.C_ChkkekkaKbn;
import yuyu.def.classification.C_KetsrhkosKbn;
import yuyu.def.classification.C_SysKbn;
import yuyu.def.db.entity.HT_HubiMsg;
import yuyu.def.db.entity.HT_SyoriCTL;
import yuyu.def.sinkeiyaku.manager.SinkeiyakuDomManager;
import yuyu.testinfr.TestOrder;
import yuyu.testinfr.inject.MockModuleBinder;

import com.google.inject.AbstractModule;

/**
 * 電話番号チェック呼出しクラスのメソッド {@link CheckTelNoCall#execTelNo(MosnaiCheckParam, pTelNo, pMessage)} テスト用クラスです。<br />
 */
@RunWith(SWAKTestRunner.class)
public class CheckTelNoCallTest_execTelNo {

    @Inject
    private MosnaiCheckParam mosnaiCheckParam;

    @Inject
    private SinkeiyakuDomManager sinkeiyakuDomManager;

    private final static String fileName = "UT_SP_単体テスト仕様書_電話番号チェック呼出し";

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
    public static void testInit(){

        SetHubiMsgMockForSinkeiyaku.caller = CheckTelNoCallTest_execTelNo.class;
    }

    @AfterClass
    public static void testClear() {

        MockObjectManager.initialize();

        SetHubiMsgMockForSinkeiyaku.caller = null;

    }

    @BeforeClass
    @Transactional
    public static void insertTestData(){
        try {
            TestDataMaker testDataMaker = new TestDataMaker();
            HashMap<String, Map<String, List<Map<String, String>>>> testDataAndTblMap;
            testDataAndTblMap = testDataMaker.getInData(CheckTelNoCallTest_execTelNo.class, fileName, sheetName);
            testDataMaker.insDataByDataId("データ005", testDataAndTblMap);
        } catch (TestDataMakerException e) {

            e.printStackTrace();
        }
    }

    @AfterClass
    @Transactional
    public static void deleteTestData() {
        SinkeiyakuDomManager sinkeiyakuDomManager = SWAKInjector.getInstance(SinkeiyakuDomManager.class);
        sinkeiyakuDomManager.delete(sinkeiyakuDomManager.getAllSyoriCTL());

    }

    @Test
    @Transactional
    @TestOrder(10)
    public void testExecTelNo_A1() {
        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("791112287");

        String telNo = "tel12345678";
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setSysKbn(C_SysKbn.SKEI);
        mosnaiCheckParam.setChkKekkaKbn(C_ChkkekkaKbn.WARNING);
        mosnaiCheckParam.setKosID("user001");
        mosnaiCheckParam.setKosTime("20150624142000000");
        CheckTelNoCall checkTelNoCall = SWAKInjector.getInstance(CheckTelNoCall.class);
        checkTelNoCall.execTelNo(mosnaiCheckParam, telNo, "電話番号");

        C_KetsrhkosKbn ketsrhkosKbn1 = (C_KetsrhkosKbn) MockObjectManager.getArgument(SetHubiMsgMockForSinkeiyaku.class, "exec", 0, 0);
        exClassificationEquals(ketsrhkosKbn1, C_KetsrhkosKbn.SRHORYU_HUBI, "決定・成立保留更新区分");
        String hubiMsg1 = (String) MockObjectManager.getArgument(SetHubiMsgMockForSinkeiyaku.class, "exec", 0, 1);
        exStringEquals(hubiMsg1, "EHC0148 電話番号の形式が正しくありません。ハイフン（-）付きで入力してください。", "メッセージ文言");
        MosnaiCheckParam mosnaiCheckParamtemp1 = (MosnaiCheckParam) MockObjectManager.getArgument(SetHubiMsgMockForSinkeiyaku.class, "exec", 0, 2);
        exStringEquals( mosnaiCheckParamtemp1.getDataSyoriControl().getMosno(), "791112287", "申込番号");
        exClassificationEquals(mosnaiCheckParamtemp1.getSysKbn(), C_SysKbn.SKEI, "システム区分");
        exClassificationEquals(mosnaiCheckParamtemp1.getChkKekkaKbn(), C_ChkkekkaKbn.WARNING, "チェック結果区分");
        exStringEquals(mosnaiCheckParamtemp1.getKosID(), "user001", "更新者ＩＤ");
        exStringEquals(mosnaiCheckParamtemp1.getKosTime(), "20150624142000000", "更新時間");

    }

    @Test
    @Transactional
    @TestOrder(20)
    public void testExecTelNo_B1() {
        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("791112295");

        String telNo = "";

        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setSysKbn(C_SysKbn.SKEI);
        mosnaiCheckParam.setChkKekkaKbn(C_ChkkekkaKbn.WARNING);
        mosnaiCheckParam.setKosID("user001");
        mosnaiCheckParam.setKosTime("20150624142000000");
        CheckTelNoCall checkTelNoCall = SWAKInjector.getInstance(CheckTelNoCall.class);
        checkTelNoCall.execTelNo(mosnaiCheckParam, telNo, "電話番号");

        List<HT_HubiMsg> hubiMsg = mosnaiCheckParam.getListHubiMsg();

        exNumericEquals(hubiMsg.size(), 0, "不備メッセージテーブルエンティティリスト件数");

    }

    @Test
    @Transactional
    @TestOrder(30)
    public void testExecTelNo_B2() {
        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("791112303");

        String telNo = "0411-876-543";

        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setSysKbn(C_SysKbn.SKEI);
        mosnaiCheckParam.setChkKekkaKbn(C_ChkkekkaKbn.WARNING);
        mosnaiCheckParam.setKosID("user001");
        mosnaiCheckParam.setKosTime("20150624142000000");
        CheckTelNoCall checkTelNoCall = SWAKInjector.getInstance(CheckTelNoCall.class);
        checkTelNoCall.execTelNo(mosnaiCheckParam, telNo, "電話番号");

        List<HT_HubiMsg> hubiMsg = mosnaiCheckParam.getListHubiMsg();

        exNumericEquals(hubiMsg.size(), 0, "不備メッセージテーブルエンティティリスト件数");

    }

}
