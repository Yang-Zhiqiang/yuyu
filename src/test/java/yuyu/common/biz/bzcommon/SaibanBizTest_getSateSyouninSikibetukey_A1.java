package yuyu.common.biz.bzcommon;

import static yuyu.testinfr.YuyuFunctionTestUtil.*;
import jp.co.slcs.swak.bizinfr.exception.BizAppException;
import jp.co.slcs.swak.core.test.SWAKTestRunner;

import org.junit.Test;
import org.junit.runner.RunWith;

/**
 * 採番業務共通クラスのメソッド {@link SaibanBiz#getSateSyouninSikibetukey()} テスト用クラスです。<br />
 * ※テストケースA1、C1、C2<br />
 */
@RunWith(SWAKTestRunner.class)
public class SaibanBizTest_getSateSyouninSikibetukey_A1 {
    private String SHO_NO = "12345";

    @Test
    public void testSateSyouninSikibetukey_A1() {
        String result = SaibanBiz.getSateSyouninSikibetukey(SHO_NO);

        exStringEquals(result, "000000000000000010", "結果");
    }

    @Test(expected = BizAppException.class)
    public void testSateSyouninSikibetukey_C1() {
        try{
            SaibanBiz.getSateSyouninSikibetukey("");
        }catch(BizAppException e){
            exStringEquals(e.getMessage(), "引数が不正です。", "証券番号");
            throw e;
        }
    }

    @Test(expected = BizAppException.class)
    public void testSateSyouninSikibetukey_C2() {
        try{
            SaibanBiz.getSateSyouninSikibetukey(null);
        }catch(BizAppException e){
            exStringEquals(e.getMessage(), "引数が不正です。", "証券番号");
            throw e;
        }
    }

}
