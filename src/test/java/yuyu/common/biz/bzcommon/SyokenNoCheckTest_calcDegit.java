package yuyu.common.biz.bzcommon;

import static yuyu.testinfr.YuyuFunctionTestUtil.*;
import jp.co.dgic.testing.common.virtualmock.MockObjectManager;
import jp.co.slcs.swak.core.test.SWAKTestRunner;

import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.testinfr.AbstractTest;

/**
 * 証券番号チェックのチェックディジット算出メソッド{@link SyokenNoCheck#calcDegit(String)}テスト用クラスです。<br />
 */
@RunWith(SWAKTestRunner.class)
public class SyokenNoCheckTest_calcDegit extends AbstractTest {

    @Test(expected = NullPointerException.class)
    public void testCalcDegit_A1() {
        SyokenNoCheck.calcDegit(null);
    }

    @Test(expected = StringIndexOutOfBoundsException.class)
    public void testCalcDegit_A2() {
        SyokenNoCheck.calcDegit("");
    }

    @Test
    public void testCalcDegit_A3() {
        exNumericEquals(SyokenNoCheck.calcDegit("abcdefghij"), -999, "チェックディジット");
    }

    @Test
    public void testCalcDegit_A4() {
        exNumericEquals(SyokenNoCheck.calcDegit("6699900003"), -999, "チェックディジット");
    }

    @Test
    public void testCalcDegit_A5() {
        exNumericEquals(SyokenNoCheck.calcDegit("6680800000"), -999, "チェックディジット");
    }

    @Test
    public void testCalcDegit_A6() {
        exNumericEquals(SyokenNoCheck.calcDegit("6680898765"), -999, "チェックディジット");
    }

    @Test
    public void testCalcDegit_A7() {
        exNumericEquals(SyokenNoCheck.calcDegit("6680879989"), 8, "チェックディジット");
    }

    @Test
    public void testCalcDegit_A8() {
        exNumericEquals(SyokenNoCheck.calcDegit("6680812345"), 9, "チェックディジット");
        MockObjectManager.initialize();
    }

}
