package yuyu.common.biz.bzcommon;

import static yuyu.testinfr.YuyuFunctionTestUtil.*;
import jp.co.slcs.swak.core.test.SWAKTestRunner;

import org.junit.Test;
import org.junit.runner.RunWith;

/**
 * 採番業務共通クラスのメソッド {@link SaibanBiz#getTyousaSikibetukey()} テスト用クラスです。<br />
 * ※テストケースA2<br />
 */
@RunWith(SWAKTestRunner.class)
public class SaibanBizTest_getTyousaSikibetukey_A2 {
    private String SHO_NO = "12345";

    @Test
    public void testTyousaSikibetukey_A2() {
        String result = SaibanBiz.getTyousaSikibetukey(SHO_NO);

        exStringEquals(result, "000000000000000070", "結果");
    }

}
