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
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.app.base.ref.TestDataMaker;
import yuyu.app.base.ref.TestDataMakerException;
import yuyu.def.classification.C_ChkkekkaKbn;
import yuyu.def.classification.C_SysKbn;
import yuyu.def.db.entity.HT_HubiMsg;
import yuyu.def.db.entity.HT_SyoriCTL;
import yuyu.def.sinkeiyaku.manager.SinkeiyakuDomManager;
import yuyu.testinfr.TestOrder;

/**
 * 電話番号チェック呼出しクラスのメソッド {@link CheckTelNoCall#execTuusin(MosnaiCheckParam)} テスト用クラスです。<br />
 */
@RunWith(SWAKTestRunner.class)
public class CheckTelNoCallTest_execTuusin {

    @Inject
    private CheckTelNoCall checkTelNoCall;

    @Inject
    private MosnaiCheckParam mosnaiCheckParam;

    @Inject
    private SinkeiyakuDomManager sinkeiyakuDomManager;

    private final static String fileName = "UT_SP_単体テスト仕様書_電話番号チェック呼出し";

    private final static String sheetName = "テストデータ";

    @BeforeClass
    @Transactional
    public static void insertTestData(){
        try {
            TestDataMaker testDataMaker = new TestDataMaker();
            HashMap<String, Map<String, List<Map<String, String>>>> testDataAndTblMap;
            testDataAndTblMap = testDataMaker.getInData(CheckTelNoCallTest_execTuusin.class, fileName, sheetName);
            testDataMaker.insDataByDataId("データ002", testDataAndTblMap);
        } catch (TestDataMakerException e) {

            e.printStackTrace();
        }
    }

    @AfterClass
    @Transactional
    public static void deleteTestData() {

        MockObjectManager.initialize();

        SinkeiyakuDomManager sinkeiyakuDomManager = SWAKInjector.getInstance(SinkeiyakuDomManager.class);
        sinkeiyakuDomManager.delete(sinkeiyakuDomManager.getAllSyoriCTL());

    }

    @Test
    @Transactional
    @TestOrder(20)
    public void testExecTuusin_A1() {
        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("791112246");

        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setSysKbn(C_SysKbn.SKEI);
        mosnaiCheckParam.setChkKekkaKbn(C_ChkkekkaKbn.WARNING);
        mosnaiCheckParam.setKosID("user001");
        mosnaiCheckParam.setKosTime("20150624142000000");
        checkTelNoCall.execTuusin(mosnaiCheckParam);

        List<HT_HubiMsg> hubiMsg = mosnaiCheckParam.getListHubiMsg();

        exNumericEquals(hubiMsg.size(), 0, "不備メッセージテーブルエンティティリスト件数");

    }

    @Test
    @Transactional
    @TestOrder(30)
    public void testExecTuusin_A2() {
        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("791112253");

        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setSysKbn(C_SysKbn.SKEI);
        mosnaiCheckParam.setChkKekkaKbn(C_ChkkekkaKbn.WARNING);
        mosnaiCheckParam.setKosID("user001");
        mosnaiCheckParam.setKosTime("20150624142000000");
        checkTelNoCall.execTuusin(mosnaiCheckParam);

        List<HT_HubiMsg> hubiMsg = mosnaiCheckParam.getListHubiMsg();

        exNumericEquals(hubiMsg.size(), 0, "不備メッセージテーブルエンティティリスト件数");

    }

}