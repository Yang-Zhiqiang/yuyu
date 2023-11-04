package yuyu.common.sinkeiyaku.skcommon;

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
import yuyu.common.biz.exception.CommonBizAppException;
import yuyu.def.sinkeiyaku.manager.SinkeiyakuDomManager;
import yuyu.testinfr.TestOrder;

/**
 * 相手申込番号ワーニングＭＳＧ取得クラスのメソッド {@link GetMsgAitemosno#exec(String)} テスト用クラスです<br />
 */
@RunWith(SWAKTestRunner.class)
public class GetMsgAitemosnoTest_exec_mosno {

    @Inject
    private GetMsgAitemosno getMsgAitemosno;

    private final static String fileName = "UT_SP_単体テスト仕様書_相手申込番号ワーニングＭＳＧ取得";

    private final static String sheetName = "テストデータ";

    @BeforeClass
    @Transactional
    public static void insertDate() {
        try {
            TestDataMaker testDataMaker = new TestDataMaker();
            HashMap<String, Map<String, List<Map<String, String>>>> testDataAndTblMap;
            testDataAndTblMap = testDataMaker.getInData(GetMsgAitemosnoTest_exec_mosno.class, fileName, sheetName);
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

        MockObjectManager.initialize();
    }

    @Test
    @TestOrder(10)
    public void testExec_A1() {

        exNumericEquals(getMsgAitemosno.exec("865566129"), 0, "結果区分");

        exStringEquals(getMsgAitemosno.getS_gmmsg(), "", "画面メッセージ");
        exStringEquals(getMsgAitemosno.getS_gmmsgid(), "", "画面メッセージID");
    }

    @Test(expected = CommonBizAppException.class)
    @TestOrder(20)
    public void testExec_A2() {

        try {

            getMsgAitemosno.exec("865566137");

        } catch (CommonBizAppException e) {

            exStringEquals(e.getMessage(), "システム整合性エラーです。申込番号=865566137", "システム整合性エラー");

            throw e;
        }
    }

    @Test
    @TestOrder(30)
    public void testExec_A3() {

        exNumericEquals(getMsgAitemosno.exec("865566111"), 0, "結果区分");

        exStringEquals(getMsgAitemosno.getS_gmmsg(), "", "画面メッセージ");
        exStringEquals(getMsgAitemosno.getS_gmmsgid(), "", "画面メッセージID");
    }

    @Test
    @TestOrder(40)
    public void testExec_A4() {

        exNumericEquals(getMsgAitemosno.exec("865566145"), 1, "結果区分");

        exStringEquals(getMsgAitemosno.getS_gmmsg(), "セット販売の申込です。（相手申込番号：880000062）", "画面メッセージ");
        exStringEquals(getMsgAitemosno.getS_gmmsgid(), "WHA1004", "画面メッセージID");
    }

    @Test
    @TestOrder(50)
    public void testExec_A5() {

        exNumericEquals(getMsgAitemosno.exec("865566152"), 0, "結果区分");

        exStringEquals(getMsgAitemosno.getS_gmmsg(), "", "画面メッセージ");
        exStringEquals(getMsgAitemosno.getS_gmmsgid(), "", "画面メッセージID");
    }
}
