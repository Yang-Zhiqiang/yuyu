package yuyu.common.biz.bzcommon;

import static yuyu.testinfr.YuyuFunctionTestUtil.*;
import jp.co.slcs.swak.bizinfr.exception.BizAppException;
import jp.co.slcs.swak.core.test.SWAKTestRunner;

import org.junit.Test;
import org.junit.runner.RunWith;

/**
 * 採番業務共通クラスのメソッド {@link SaibanBiz#getBunkatuSiKeisanFRenNo()} テスト用クラスです。<br />
 * ※テストケースA1、A2、A3、C1、C2<br />
 */
@RunWith(SWAKTestRunner.class)
public class SaibanBizTest_getBunkatuSiKeisanFRenNo {

    @Test
    public void testBunkatuSiKeisanFRenNo_A1() {

        String SYORI_YMD = "20190109";

        String result = SaibanBiz.getBunkatuSiKeisanFRenNo(SYORI_YMD);

        exStringEquals(result, "1", "結果");
    }

    @Test
    public void testBunkatuSiKeisanFRenNo_A2() {

        String SYORI_YMD = "20190110";

        String result = SaibanBiz.getBunkatuSiKeisanFRenNo(SYORI_YMD);

        exStringEquals(result, "11", "結果");
    }

    @Test
    public void testBunkatuSiKeisanFRenNo_A3() {

        String SYORI_YMD = "20190111";

        String result = SaibanBiz.getBunkatuSiKeisanFRenNo(SYORI_YMD);

        exStringEquals(result, "9999", "結果");
    }

    @Test(expected = BizAppException.class)
    public void testBunkatuSiKeisanFRenNo_C1() {
        try {
            SaibanBiz.getBunkatuSiKeisanFRenNo("");
        } catch (BizAppException e) {
            exStringEquals(e.getMessage(), "引数が不正です。", "処理年月日");
            throw e;
        }
    }

    @Test(expected = BizAppException.class)
    public void testBunkatuSiKeisanFRenNo_C2() {
        try {
            SaibanBiz.getBunkatuSiKeisanFRenNo(null);
        } catch (BizAppException e) {
            exStringEquals(e.getMessage(), "引数が不正です。", "処理年月日");
            throw e;
        }
    }

}
