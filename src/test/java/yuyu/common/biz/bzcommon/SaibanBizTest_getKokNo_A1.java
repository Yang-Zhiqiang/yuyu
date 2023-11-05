package yuyu.common.biz.bzcommon;

import static yuyu.testinfr.YuyuFunctionTestUtil.*;
import jp.co.slcs.swak.core.test.SWAKTestRunner;

import org.junit.Test;
import org.junit.runner.RunWith;

/**
 * 採番業務共通クラスのメソッド {@link SaibanBiz#getKokNo()} テスト用クラスです。<br />
 * ※テストケースA1<br />
 */
@RunWith(SWAKTestRunner.class)
public class SaibanBizTest_getKokNo_A1 {
    @Test
    public void testKokNo_A1() {
        String result = SaibanBiz.getKokNo();

        exStringEquals(result, "1", "結果");
    }

}
