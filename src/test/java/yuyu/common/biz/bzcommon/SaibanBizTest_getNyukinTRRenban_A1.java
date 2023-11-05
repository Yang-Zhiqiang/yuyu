package yuyu.common.biz.bzcommon;

import static yuyu.testinfr.YuyuFunctionTestUtil.*;
import jp.co.slcs.swak.bizinfr.exception.BizAppException;
import jp.co.slcs.swak.core.test.SWAKTestRunner;

import org.junit.Test;
import org.junit.runner.RunWith;

/**
 * 採番業務共通クラスのメソッド {@link SaibanBiz#getNyukinTRRenban()} テスト用クラスです。<br />
 * ※テストケースA1、C1、C2<br />
 */
@RunWith(SWAKTestRunner.class)
public class SaibanBizTest_getNyukinTRRenban_A1 {
    private String SYORI_YMD = "20150514";

    @Test
    public void testNyukinTRRenban_A1() {
        String result = SaibanBiz.getNyukinTRRenban(SYORI_YMD);

        exStringEquals(result, "000000000000000010", "結果");
    }

    @Test(expected = BizAppException.class)
    public void testNyukinTRRenban_C1() {
        try{
            SaibanBiz.getNyukinTRRenban("");
        }catch(BizAppException e){
            exStringEquals(e.getMessage(), "引数が不正です。", "処理年月日");
            throw e;
        }
    }

    @Test(expected = BizAppException.class)
    public void testNyukinTRRenban_C2() {
        try{
            SaibanBiz.getNyukinTRRenban(null);
        }catch(BizAppException e){
            exStringEquals(e.getMessage(), "引数が不正です。", "処理年月日");
            throw e;
        }
    }

}
