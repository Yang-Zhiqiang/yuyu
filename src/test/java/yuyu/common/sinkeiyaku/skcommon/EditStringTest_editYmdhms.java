package yuyu.common.sinkeiyaku.skcommon;

import static yuyu.testinfr.YuyuFunctionTestUtil.*;
import jp.co.slcs.swak.core.test.SWAKTestRunner;

import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.testinfr.TestOrder;

/**
 * 文字列編集クラスのメソッド {@link EditString#editYmdhms(String)} テスト用クラスです。<br />
 */
@RunWith(SWAKTestRunner.class)
public class EditStringTest_editYmdhms {

    @Test
    @TestOrder(10)
    public void testEditYmdhms_A1() {
        String resultStr = EditString.editYmdhms(null);

        exStringEquals(resultStr, "", "編集後日付データ");
    }

    @Test
    @TestOrder(20)
    public void testEditYmdhms_A2() {
        String resultStr = EditString.editYmdhms("");

        exStringEquals(resultStr, "", "編集後日付データ");
    }

    @Test
    @TestOrder(30)
    public void testEditYmdhms_B1() {
        String resultStr = EditString.editYmdhms("2014010211051");

        exStringEquals(resultStr, "", "編集後日付データ");
    }

    @Test
    @TestOrder(40)
    public void testEditYmdhms_B2() {
        String resultStr = EditString.editYmdhms("20140102110512");

        exStringEquals(resultStr, "H26. 1. 2 11:05:12", "編集後日付データ");
    }

    @Test
    @TestOrder(50)
    public void testEditYmdhms_B3() {
        String resultStr = EditString.editYmdhms("201401021105121");

        exStringEquals(resultStr, "H26. 1. 2 11:05:12", "編集後日付データ");
    }
}