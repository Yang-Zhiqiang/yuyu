package yuyu.common.biz.bzcommon;

import static yuyu.testinfr.YuyuFunctionTestUtil.*;

import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * {@link CheckKana}クラスに含まれるisKyokaMojiメソッドの、テストケースを実施するクラスです。<br />
 */

@RunWith(OrderedRunner.class)
public class CheckKanaTest_exec {


    @Test
    @TestOrder(10)
    public void testIsKyokaMoji_A1() {
        boolean resultFlag = CheckKana.isKyokaMoji(null);
        exBooleanEquals(resultFlag, true, "チェック結果");
    }

    @Test
    @TestOrder(20)
    public void testIsKyokaMoji_A2() {
        boolean resultFlag = CheckKana.isKyokaMoji("テスト");
        exBooleanEquals(resultFlag, false, "チェック結果");
    }

}
