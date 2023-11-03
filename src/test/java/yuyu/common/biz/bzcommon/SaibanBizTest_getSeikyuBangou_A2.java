package yuyu.common.biz.bzcommon;

import static yuyu.testinfr.YuyuFunctionTestUtil.*;
import jp.co.slcs.swak.core.test.SWAKTestRunner;

import org.junit.Test;
import org.junit.runner.RunWith;

/**
 * 採番業務共通クラスのメソッド {@link SaibanBiz#getSeikyuBangou()} テスト用クラスです。<br />
 * ※テストケースA2<br />
 */
@RunWith(SWAKTestRunner.class)
public class SaibanBizTest_getSeikyuBangou_A2 {
    @Test
    public void testSeikyuBangou_A2() {
        String result = SaibanBiz.getSeikyuBangou();

        exStringEquals(result, "000000000000000040", "結果");
    }

}
