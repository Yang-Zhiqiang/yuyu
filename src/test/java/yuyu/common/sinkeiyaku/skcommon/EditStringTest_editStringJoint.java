package yuyu.common.sinkeiyaku.skcommon;

import static yuyu.testinfr.YuyuFunctionTestUtil.*;
import jp.co.slcs.swak.core.test.SWAKTestRunner;

import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.testinfr.TestOrder;

/**
 * 文字列編集クラスのメソッド {@link EditString#editStringJoint(String[])} テスト用クラスです。<br />
 */
@RunWith(SWAKTestRunner.class)
public class EditStringTest_editStringJoint {

    @Test
    @TestOrder(10)
    public void testEditStringJoint_A1() {
        String resultStr = EditString.editStringJoint(new String[]{});

        exStringEquals(resultStr, "", "結合文字列");
    }

    @Test
    @TestOrder(20)
    public void testEditStringJoint_B2() {
        String resultStr = EditString.editStringJoint(new String[]{"Test"});

        exStringEquals(resultStr, "Test", "結合文字列");
    }

    @Test
    @TestOrder(30)
    public void testEditStringJoint_B3() {
        String resultStr = EditString.editStringJoint(new String[]{"Tesuto", "You", "Mojiretu"});

        exStringEquals(resultStr, "Tesuto+You+Mojiretu", "結合文字列");
    }
}