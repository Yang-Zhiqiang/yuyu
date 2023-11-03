package yuyu.common.sinkeiyaku.skcommon;

import static yuyu.testinfr.YuyuFunctionTestUtil.*;
import jp.co.slcs.swak.core.test.SWAKTestRunner;

import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.testinfr.TestOrder;

/**
 * 文字列編集クラスのメソッド {@link EditString#editYmdhm(String)} テスト用クラスです。<br />
 */
@RunWith(SWAKTestRunner.class)
public class EditStringTest_editYmdhm {

    @Test
    @TestOrder(10)
    public void testEditYmdhm_A1() {
        String resultStr = EditString.editYmdhm(null);

        exStringEquals(resultStr, "", "編集後日付データ");
    }

    @Test
    @TestOrder(20)
    public void testEditYmdhm_A2() {
        String resultStr = EditString.editYmdhm("");

        exStringEquals(resultStr, "", "編集後日付データ");
    }

    @Test
    @TestOrder(30)
    public void testEditYmdhm_B1() {
        String resultStr = EditString.editYmdhm("20140102110");

        exStringEquals(resultStr, "", "編集後日付データ");
    }

    @Test
    @TestOrder(40)
    public void testEditYmdhm_B2() {
        String resultStr = EditString.editYmdhm("201401021105");

        exStringEquals(resultStr, "H26. 1. 2 11:05", "編集後日付データ");
    }

    @Test
    @TestOrder(50)
    public void testEditYmdhm_B3() {
        String resultStr = EditString.editYmdhm("2014010211051");

        exStringEquals(resultStr, "H26. 1. 2 11:05", "編集後日付データ");
    }
}