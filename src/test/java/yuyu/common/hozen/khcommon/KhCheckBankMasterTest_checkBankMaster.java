package yuyu.common.hozen.khcommon;

import static yuyu.testinfr.YuyuFunctionTestUtil.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.slcs.swak.core.inject.SWAKInjector;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.app.base.ref.TestDataMaker;
import yuyu.app.base.ref.TestDataMakerException;
import yuyu.def.biz.manager.BizDomManager;
import yuyu.def.classification.C_Tuukasyu;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * 銀行マスタチェック{@link KhCheckBankMaster#checkBankMaster(C_Tuukasyu,String,String)} テスト用クラスです。<br />
 */
@RunWith(OrderedRunner.class)
public class KhCheckBankMasterTest_checkBankMaster {

    @Inject
    private KhCheckBankMaster khCheckBankMaster;

    private final static String fileName = "UT-SP_単体テスト仕様書（共通）_銀行マスタチェック";

    private final static String sheetName = "INデータ";

    @BeforeClass
    @Transactional
    public static void insertTestData() {
        try {
            TestDataMaker testDataMaker = new TestDataMaker();
            HashMap<String, Map<String, List<Map<String, String>>>> testDataAndTblMap;
            testDataAndTblMap = testDataMaker.getInData(KhCheckBankMasterTest_checkBankMaster.class, fileName, sheetName);
            testDataMaker.insDataByDataId("データ001", testDataAndTblMap);
        } catch (TestDataMakerException e) {
            e.printStackTrace();
        }
    }

    @AfterClass
    @Transactional
    public static void deleteTestData() {
        BizDomManager bizDomManager = SWAKInjector.getInstance(BizDomManager.class);
        bizDomManager.delete(bizDomManager.getAllGinkou());
    }
    @Test
    @TestOrder(10)
    public void testCheckBankMaster_A1() {

        C_Tuukasyu tuukaSyu = C_Tuukasyu.JPY;

        String bankCd = "9901";

        String sitenCd = "101";

        int errCd = khCheckBankMaster.checkBankMaster(tuukaSyu, bankCd, sitenCd);

        exNumericEquals(errCd, 1, "エラー内容");
    }

    @Test
    @TestOrder(20)
    public void testCheckBankMaster_A2() {

        C_Tuukasyu tuukaSyu = C_Tuukasyu.JPY;

        String bankCd = "9900";

        String sitenCd = "202";

        int errCd = khCheckBankMaster.checkBankMaster(tuukaSyu, bankCd, sitenCd);

        exNumericEquals(errCd, 2, "エラー内容");
    }

    @Test
    @TestOrder(30)
    public void testCheckBankMaster_A3() {

        C_Tuukasyu tuukaSyu = C_Tuukasyu.JPY;

        String bankCd = "9900";

        String sitenCd = "303";

        int errCd = khCheckBankMaster.checkBankMaster(tuukaSyu, bankCd, sitenCd);

        exNumericEquals(errCd, 3, "エラー内容");
    }

    @Test
    @TestOrder(40)
    public void testCheckBankMaster_A4() {

        C_Tuukasyu tuukaSyu = C_Tuukasyu.EUR;

        String bankCd = "9900";

        String sitenCd = "404";

        int errCd = khCheckBankMaster.checkBankMaster(tuukaSyu, bankCd, sitenCd);

        exNumericEquals(errCd, 4, "エラー内容");
    }

    @Test
    @TestOrder(50)
    public void testCheckBankMaster_A5() {

        C_Tuukasyu tuukaSyu = C_Tuukasyu.EUR;

        String bankCd = "1234";

        String sitenCd = "505";

        int errCd = khCheckBankMaster.checkBankMaster(tuukaSyu, bankCd, sitenCd);

        exStringEquals(khCheckBankMaster.getGinkouName(), "銀行名テスト", "メンバ変数．銀行名");
        exStringEquals(khCheckBankMaster.getShitenName(), "支店名テスト", "メンバ変数．支店名");

        exNumericEquals(errCd, 0, "エラー内容");
    }

    @Test
    @TestOrder(60)
    public void testCheckBankMaster_A6() {

        C_Tuukasyu tuukaSyu = C_Tuukasyu.JPY;

        String bankCd = "9900";

        String sitenCd = "106";

        int errCd = khCheckBankMaster.checkBankMaster(tuukaSyu, bankCd, sitenCd);

        exStringEquals(khCheckBankMaster.getGinkouName(), "ゆうちょ銀行", "メンバ変数．銀行名");
        exStringEquals(khCheckBankMaster.getShitenName(), "天理支店", "メンバ変数．支店名");

        exNumericEquals(errCd, 0, "エラー内容");
    }
}
