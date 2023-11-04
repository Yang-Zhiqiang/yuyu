package yuyu.common.biz.bzcommon;

import static yuyu.testinfr.YuyuFunctionTestUtil.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.transaction.Transactional;

import jp.co.slcs.swak.bizinfr.exception.BizAppException;
import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.core.test.SWAKTestRunner;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.app.base.ref.TestDataMaker;
import yuyu.app.base.ref.TestDataMakerException;
import yuyu.def.base.manager.BaseDomManager;

/**
 * 採番業務共通クラスのメソッド {@link SaibanBiz#getKeirisyoriRenNo()} テスト用クラスです。<br />
 * ※テストケースA1、A2、A3、C1、C2<br />
 */
@RunWith(SWAKTestRunner.class)
public class SaibanBizTest_getKeirisyoriRenNo {

    private final static String fileName = "UT_SP_単体テスト仕様書（共通）_採番業務共通";
    private final static String sheetName = "テストデータ";

    @BeforeClass
    @Transactional
    public static void insertTestData() {
        try {

            TestDataMaker testDataMaker = new TestDataMaker();

            HashMap<String, Map<String, List<Map<String, String>>>> testDataAndTblMap;

            testDataAndTblMap = testDataMaker.getInData(SaibanBizTest_getKeirisyoriRenNo.class, fileName,
                sheetName);

            testDataMaker.insDataByDataId("データ001", testDataAndTblMap);

        } catch (TestDataMakerException e) {
            e.printStackTrace();
        }
    }

    @AfterClass
    @Transactional
    public static void deleteTestData() {

        BaseDomManager baseDomManager = SWAKInjector.getInstance(BaseDomManager.class);
        baseDomManager.delete(baseDomManager.getAllSequences());
    }



    @Test
    public void testKeirisyoriRenNo_A1() {

        String SYORI_YMD = "20200109";

        String result = SaibanBiz.getKeirisyoriRenNo(SYORI_YMD);

        exStringEquals(result, "1", "結果");
    }

    @Test
    public void testKeirisyoriRenNo_A2() {

        String SYORI_YMD = "20200110";

        String result = SaibanBiz.getKeirisyoriRenNo(SYORI_YMD);

        exStringEquals(result, "11", "結果");
    }

    @Test
    public void testKeirisyoriRenNo_A3() {

        String SYORI_YMD = "20200111";

        String result = SaibanBiz.getKeirisyoriRenNo(SYORI_YMD);

        exStringEquals(result, "999999999999999999", "結果");
    }

    @Test(expected = BizAppException.class)
    public void testKeirisyoriRenNo_C1() {
        try {
            SaibanBiz.getKeirisyoriRenNo("");
        } catch (BizAppException e) {
            exStringEquals(e.getMessage(), "引数が不正です。", "処理年月日");
            throw e;
        }
    }

    @Test(expected = BizAppException.class)
    public void testKeirisyoriRenNo_C2() {
        try {
            SaibanBiz.getKeirisyoriRenNo(null);
        } catch (BizAppException e) {
            exStringEquals(e.getMessage(), "引数が不正です。", "処理年月日");
            throw e;
        }
    }

}
