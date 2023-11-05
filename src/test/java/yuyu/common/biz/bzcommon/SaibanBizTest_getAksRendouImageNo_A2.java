package yuyu.common.biz.bzcommon;

import static yuyu.testinfr.YuyuFunctionTestUtil.*;
import jp.co.slcs.swak.core.test.SWAKTestRunner;

import org.junit.Test;
import org.junit.runner.RunWith;

/**
 * 採番業務共通クラスのメソッド {@link SaibanBiz#getAksRendouImageNo()} テスト用クラスです。<br />
 * ※テストケースA2<br />
 */
@RunWith(SWAKTestRunner.class)
public class SaibanBizTest_getAksRendouImageNo_A2 {
    private String SYORI_YMD = "20160506";

    @Test
    public void testAksRendouImageNo_A2() {
        String result = SaibanBiz.getAksRendouImageNo(SYORI_YMD);

        exStringEquals(result, "20160506000000120", "結果");
    }

}
