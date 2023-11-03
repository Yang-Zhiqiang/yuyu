package yuyu.common.biz.bzcommon;

import static yuyu.testinfr.YuyuFunctionTestUtil.*;
import jp.co.slcs.swak.bizinfr.exception.BizAppException;
import jp.co.slcs.swak.core.test.SWAKTestRunner;

import org.junit.Test;
import org.junit.runner.RunWith;

/**
 * 採番業務共通クラスのメソッド {@link SaibanBiz#getAksRendouImageNo()} テスト用クラスです。<br />
 * ※テストケースA1、C1、C2<br />
 */
@RunWith(SWAKTestRunner.class)
public class SaibanBizTest_getAksRendouImageNo_A1 {
    private String SYORI_YMD = "20160506";

    @Test
    public void testAksRendouImageNo_A1() {
        String result = SaibanBiz.getAksRendouImageNo(SYORI_YMD);

        exStringEquals(result, "20160506000000010", "結果");
    }

    @Test(expected = BizAppException.class)
    public void testAksRendouImageNo_C1() {
        try{
            SaibanBiz.getAksRendouImageNo("");
        }catch(BizAppException e){
            exStringEquals(e.getMessage(), "引数が不正です。", "処理年月日");
            throw e;
        }
    }

    @Test(expected = BizAppException.class)
    public void testAksRendouImageNo_C2() {
        try{
            SaibanBiz.getAksRendouImageNo(null);
        }catch(BizAppException e){
            exStringEquals(e.getMessage(), "引数が不正です。", "処理年月日");
            throw e;
        }
    }

}
