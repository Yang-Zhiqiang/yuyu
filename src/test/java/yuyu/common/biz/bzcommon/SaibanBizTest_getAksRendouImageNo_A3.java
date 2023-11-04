package yuyu.common.biz.bzcommon;

import static yuyu.testinfr.YuyuFunctionTestUtil.*;
import jp.co.slcs.swak.core.test.SWAKTestRunner;

import org.junit.Test;
import org.junit.runner.RunWith;

/**
 * 採番業務共通クラスのメソッド {@link SaibanBiz#getAksRendouImageNo()} テスト用クラスです。<br />
 * ※テストケースA3<br />
 */
@RunWith(SWAKTestRunner.class)
public class SaibanBizTest_getAksRendouImageNo_A3 {
    private String SYORI_YMD = "99999999";

    @Test
    public void testAksRendouImageNo_A3() {
        String result = SaibanBiz.getAksRendouImageNo(SYORI_YMD);

        exStringEquals(result, "99999999999999999", "結果");
    }

}
