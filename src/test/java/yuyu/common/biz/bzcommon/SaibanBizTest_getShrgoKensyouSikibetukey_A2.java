package yuyu.common.biz.bzcommon;

import static yuyu.testinfr.YuyuFunctionTestUtil.*;
import jp.co.slcs.swak.core.test.SWAKTestRunner;

import org.junit.Test;
import org.junit.runner.RunWith;

/**
 * 採番業務共通クラスのメソッド {@link SaibanBiz#getShrgoKensyouSikibetukey()} テスト用クラスです。<br />
 * ※テストケースA2<br />
 */
@RunWith(SWAKTestRunner.class)
public class SaibanBizTest_getShrgoKensyouSikibetukey_A2 {
    private String SHO_NO = "12345";

    @Test
    public void testShrgoKensyouSikibetukey_A2() {
        String result = SaibanBiz.getShrgoKensyouSikibetukey(SHO_NO);

        exStringEquals(result, "000000000000000090", "結果");
    }

}
