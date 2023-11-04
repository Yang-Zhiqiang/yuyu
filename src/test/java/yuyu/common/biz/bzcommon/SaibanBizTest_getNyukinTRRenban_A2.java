package yuyu.common.biz.bzcommon;

import static yuyu.testinfr.YuyuFunctionTestUtil.*;
import jp.co.slcs.swak.core.test.SWAKTestRunner;

import org.junit.Test;
import org.junit.runner.RunWith;

/**
 * 採番業務共通クラスのメソッド {@link SaibanBiz#getNyukinTRRenban()} テスト用クラスです。<br />
 * ※テストケースA2<br />
 */
@RunWith(SWAKTestRunner.class)
public class SaibanBizTest_getNyukinTRRenban_A2 {
    private String SYORI_YMD = "20150514";

    @Test
    public void testNyukinTRRenban_A2() {
        String result = SaibanBiz.getNyukinTRRenban(SYORI_YMD);

        exStringEquals(result, "000000000000000100", "結果");
    }

}
