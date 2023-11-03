package yuyu.common.biz.bzcommon;

import static yuyu.testinfr.YuyuFunctionTestUtil.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.dgic.testing.common.virtualmock.MockObjectManager;
import jp.co.slcs.swak.core.inject.SWAKInjector;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.app.base.ref.TestDataMaker;
import yuyu.app.base.ref.TestDataMakerException;
import yuyu.def.biz.manager.BizDomManager;
import yuyu.def.classification.C_ErrorKbn;
import yuyu.testinfr.AbstractTest;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * 住所情報取得クラスのメソッド {@link BzGetAdrData#execAdrKanaBlankAriByPostalcd(String)}テスト用クラスです<br />
 */
@RunWith(OrderedRunner.class)
public class BzGetAdrDataTest_execAdrKanaBlankAriByPostalcd extends AbstractTest {

    @Inject
    private BzGetAdrData bzGetAdrData;

    private final static String fileName = "UT-SP_単体テスト仕様書（共通）_住所情報取得";
    private final static String sheetName = "INデータ";

    @BeforeClass
    @Transactional
    public static void insertTestData() {
        try {

            TestDataMaker testDataMaker = new TestDataMaker();

            HashMap<String, Map<String, List<Map<String, String>>>> testDataAndTblMap;

            testDataAndTblMap = testDataMaker.getInData(BzGetAdrDataTest_execAdrKanaBlankAriByPostalcd.class, fileName,
                sheetName);

            testDataMaker.insDataByDataId("データ001", testDataAndTblMap);

        } catch (TestDataMakerException e) {
            e.printStackTrace();
        }
    }

    @AfterClass
    @Transactional
    public static void deleteTestData() {

        MockObjectManager.initialize();

        BizDomManager bizDomManager = SWAKInjector.getInstance(BizDomManager.class);
        bizDomManager.delete(bizDomManager.getAllAddress());
    }

    @Test
    @TestOrder(10)
    public void testExecAdrKanaBlankAriByPostalcd_A1() {

        String postalCd = null;

        bzGetAdrData.execAdrKanaBlankAriByPostalcd(postalCd);

        exClassificationEquals(bzGetAdrData.getErrorKbn(), C_ErrorKbn.ERROR, "エラー区分");
        exStringEquals(bzGetAdrData.getAdrKanaBlankAri(), "", "住所（カナ）（空白あり）");
    }

    @Test
    @TestOrder(20)
    public void testExecAdrKanaBlankAriByPostalcd_A2() {

        String postalCd = "";

        bzGetAdrData.execAdrKanaBlankAriByPostalcd(postalCd);

        exClassificationEquals(bzGetAdrData.getErrorKbn(), C_ErrorKbn.ERROR, "エラー区分");
        exStringEquals(bzGetAdrData.getAdrKanaBlankAri(), "", "住所（カナ）（空白あり）");
    }

    @Test
    @TestOrder(30)
    public void testExecAdrKanaBlankAriByPostalcd_A3() {

        String postalCd = "116023";

        bzGetAdrData.execAdrKanaBlankAriByPostalcd(postalCd);

        exClassificationEquals(bzGetAdrData.getErrorKbn(), C_ErrorKbn.ERROR, "エラー区分");
        exStringEquals(bzGetAdrData.getAdrKanaBlankAri(), "", "住所（カナ）（空白あり）");
    }

    @Test
    @TestOrder(40)
    public void testExecAdrKanaBlankAriByPostalcd_A4() {

        String postalCd = "11602345";

        bzGetAdrData.execAdrKanaBlankAriByPostalcd(postalCd);

        exClassificationEquals(bzGetAdrData.getErrorKbn(), C_ErrorKbn.ERROR, "エラー区分");
        exStringEquals(bzGetAdrData.getAdrKanaBlankAri(), "", "住所（カナ）（空白あり）");
    }

    @Test
    @TestOrder(50)
    public void testExecAdrKanaBlankAriByPostalcd_A5() {

        String postalCd = "1160235";

        bzGetAdrData.execAdrKanaBlankAriByPostalcd(postalCd);

        exClassificationEquals(bzGetAdrData.getErrorKbn(), C_ErrorKbn.ERROR, "エラー区分");
        exStringEquals(bzGetAdrData.getAdrKanaBlankAri(), "", "住所（カナ）（空白あり）");
    }

    @Test
    @TestOrder(60)
    public void testExecAdrKanaBlankAriByPostalcd_A6() {

        String postalCd = "1160236";

        bzGetAdrData.execAdrKanaBlankAriByPostalcd(postalCd);

        exClassificationEquals(bzGetAdrData.getErrorKbn(), C_ErrorKbn.OK, "エラー区分");
        exStringEquals(bzGetAdrData.getAdrKanaBlankAri(), "住所　空白　神奈川県", "住所（カナ）（空白あり）");
    }

    @Test
    @TestOrder(70)
    public void testExecAdrKanaBlankAriByPostalcd_A7() {

        String postalCd = "1160237";

        bzGetAdrData.execAdrKanaBlankAriByPostalcd(postalCd);

        exClassificationEquals(bzGetAdrData.getErrorKbn(), C_ErrorKbn.OK, "エラー区分");
        exStringEquals(bzGetAdrData.getAdrKanaBlankAri(), "", "住所（カナ）（空白あり）");
    }

    @Test
    @TestOrder(80)
    public void testExecAdrKanaBlankAriByPostalcd_A8() {

        String postalCd = "1160238";

        bzGetAdrData.execAdrKanaBlankAriByPostalcd(postalCd);

        exClassificationEquals(bzGetAdrData.getErrorKbn(), C_ErrorKbn.OK, "エラー区分");
        exStringEquals(bzGetAdrData.getAdrKanaBlankAri(), "住所　空白", "住所（カナ）（空白あり）");
    }

    @Test
    @TestOrder(90)
    public void testExecAdrKanaBlankAriByPostalcd_A9() {

        String postalCd = "1160239";

        bzGetAdrData.execAdrKanaBlankAriByPostalcd(postalCd);

        exClassificationEquals(bzGetAdrData.getErrorKbn(), C_ErrorKbn.OK, "エラー区分");
        exStringEquals(bzGetAdrData.getAdrKanaBlankAri(), "住所", "住所（カナ）（空白あり）");
    }

    @Test
    @TestOrder(100)
    public void testExecAdrKanaBlankAriByPostalcd_A10() {

        String postalCd = "1160240";

        bzGetAdrData.execAdrKanaBlankAriByPostalcd(postalCd);

        exClassificationEquals(bzGetAdrData.getErrorKbn(), C_ErrorKbn.OK, "エラー区分");
        exStringEquals(bzGetAdrData.getAdrKanaBlankAri(), "", "住所（カナ）（空白あり）");
    }

    @Test
    @TestOrder(110)
    public void testExecAdrKanaBlankAriByPostalcd_A11() {

        String postalCd = "1160241";

        bzGetAdrData.execAdrKanaBlankAriByPostalcd(postalCd);

        exClassificationEquals(bzGetAdrData.getErrorKbn(), C_ErrorKbn.OK, "エラー区分");
        exStringEquals(bzGetAdrData.getAdrKanaBlankAri(), "", "住所（カナ）（空白あり）");
    }
}
