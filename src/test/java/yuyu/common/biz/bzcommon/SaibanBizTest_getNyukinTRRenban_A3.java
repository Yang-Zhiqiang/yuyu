package yuyu.common.biz.bzcommon;

import static yuyu.testinfr.YuyuFunctionTestUtil.*;
import jp.co.slcs.swak.core.test.SWAKTestRunner;

import org.junit.Test;
import org.junit.runner.RunWith;

/**
 * 採番業務共通クラスのメソッド {@link SaibanBiz#getNyukinTRRenban()} テスト用クラスです。<br />
 * ※テストケースA3<br />
 */
@RunWith(SWAKTestRunner.class)
public class SaibanBizTest_getNyukinTRRenban_A3 {
    private String SYORI_YMD = "20150514";

    @Test
    public void testNyukinTRRenban_A3() {
        String result = SaibanBiz.getNyukinTRRenban(SYORI_YMD);

        exStringEquals(result, "999999999999999999", "結果");
    }

}
