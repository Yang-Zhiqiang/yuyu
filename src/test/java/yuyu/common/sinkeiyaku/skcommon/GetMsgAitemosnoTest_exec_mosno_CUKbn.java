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
import yuyu.def.classification.C_UmuKbn;
import yuyu.def.sinkeiyaku.manager.SinkeiyakuDomManager;
import yuyu.testinfr.TestOrder;

/**
 * 相手申込番号ワーニングＭＳＧ取得クラスのメソッド {@link GetMsgAitemosno#exec(String ,C_UmuKbn)} テスト用クラスです<br />
 */
@RunWith(SWAKTestRunner.class)
public class GetMsgAitemosnoTest_exec_mosno_CUKbn {

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
            testDataAndTblMap = testDataMaker.getInData(GetMsgAitemosnoTest_exec_mosno_CUKbn.class, fileName, sheetName);
            testDataMaker.insDataByDataId("データ002", testDataAndTblMap);
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

    @Test(expected = CommonBizAppException.class)
    @TestOrder(10)
    public void testExec_A1() {

        try {

            getMsgAitemosno.exec("875566234", C_UmuKbn.ARI);

        } catch (CommonBizAppException e) {

            exStringEquals(e.getMessage(), "システム整合性エラーです。申込番号=875566234", "エラーメッセージ");

            throw e;
        }
    }

    @Test
    @TestOrder(20)
    public void testExec_A2() {

        exNumericEquals(getMsgAitemosno.exec("875566218", C_UmuKbn.ARI), 0, "結果区分");

        exStringEquals(getMsgAitemosno.getS_gmmsg(), "", "画面メッセージ");
        exStringEquals(getMsgAitemosno.getS_gmmsgid(), "", "画面メッセージID");
    }

    @Test
    @TestOrder(30)
    public void testExec_A3() {

        exNumericEquals(getMsgAitemosno.exec("875566226", C_UmuKbn.NONE), 0, "結果区分");

        exStringEquals(getMsgAitemosno.getS_gmmsg(), "", "画面メッセージ");
        exStringEquals(getMsgAitemosno.getS_gmmsgid(), "", "画面メッセージID");
    }

    @Test
    @TestOrder(40)
    public void testExec_A4() {

        exNumericEquals(getMsgAitemosno.exec("875566242", C_UmuKbn.ARI), 1, "結果区分");

        exStringEquals(getMsgAitemosno.getS_gmmsg(), "セット販売の申込です。（相手申込番号：880000013）", "画面メッセージ");
        exStringEquals(getMsgAitemosno.getS_gmmsgid(), "WHA1004", "画面メッセージID");
    }
}
