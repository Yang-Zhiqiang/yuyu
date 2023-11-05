package yuyu.common.biz.bzcommon;

import static yuyu.testinfr.YuyuFunctionTestUtil.*;
import jp.co.slcs.swak.core.test.SWAKTestRunner;

import org.junit.Test;
import org.junit.runner.RunWith;

/**
 * 採番業務共通クラスのメソッド {@link SaibanBiz#getTetudukirirekiSikibetukey()} テスト用クラスです。<br />
 * ※テストケースA3<br />
 */
@RunWith(SWAKTestRunner.class)
public class SaibanBizTest_getTetudukirirekiSikibetukey_A3 {
    private String SHO_NO = "12345";

    @Test
    public void testTetudukirirekiSikibetukey_A3() {
        String result = SaibanBiz.getTetudukirirekiSikibetukey(SHO_NO);

        exStringEquals(result, "999999999999999999", "結果");
    }

}
