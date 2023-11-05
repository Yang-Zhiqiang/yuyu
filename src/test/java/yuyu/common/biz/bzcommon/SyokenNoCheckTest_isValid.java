package yuyu.common.biz.bzcommon;

import static yuyu.testinfr.YuyuFunctionTestUtil.*;
import jp.co.dgic.testing.common.virtualmock.MockObjectManager;
import jp.co.slcs.swak.core.test.SWAKTestRunner;

import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.testinfr.AbstractTest;

/**
 * 証券番号チェックの証券番号チェックメソッド{@link SyokenNoCheck#isValid(String)}テスト用クラスです。<br />
 */
@RunWith(SWAKTestRunner.class)
public class SyokenNoCheckTest_isValid extends AbstractTest {

    @Test
    public void testIsValid_A1() {
        exBooleanEquals(SyokenNoCheck.isValid(null), false, "チェック結果");
    }

    @Test
    public void testIsValid_A2() {
        exBooleanEquals(SyokenNoCheck.isValid(""), false, "チェック結果");
    }

    @Test
    public void testIsValid_A3() {
        exBooleanEquals(SyokenNoCheck.isValid("6681012345"), false, "チェック結果");
    }

    @Test
    public void testIsValid_A4() {
        exBooleanEquals(SyokenNoCheck.isValid("668101234567"), false, "チェック結果");
    }

    @Test
    public void testIsValid_A5() {
        exBooleanEquals(SyokenNoCheck.isValid("abcdefghij6"), false, "チェック結果");
    }

    @Test
    public void testIsValid_A6() {
        exBooleanEquals(SyokenNoCheck.isValid("66999000031"), false, "チェック結果");
    }

    @Test
    public void testIsValid_A7() {
        exBooleanEquals(SyokenNoCheck.isValid("66808000001"), false, "チェック結果");
    }

    @Test
    public void testIsValid_A8() {
        exBooleanEquals(SyokenNoCheck.isValid("66808987658"), false, "チェック結果");
    }

    @Test
    public void testIsValid_A9() {
        exBooleanEquals(SyokenNoCheck.isValid("66808799895"), false, "チェック結果");
    }

    @Test
    public void testIsValid_A10() {
        exBooleanEquals(SyokenNoCheck.isValid("66808799898"), true, "チェック結果");
    }

    @Test
    public void testIsValid_A11() {
        exBooleanEquals(SyokenNoCheck.isValid("66808123454"), false, "チェック結果");
    }

    @Test
    public void testIsValid_A12() {
        exBooleanEquals(SyokenNoCheck.isValid("66808123459"), true, "チェック結果");

        MockObjectManager.initialize();
    }

}