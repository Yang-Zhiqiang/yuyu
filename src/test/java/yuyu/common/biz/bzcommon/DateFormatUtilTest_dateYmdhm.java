package yuyu.common.biz.bzcommon;

import static yuyu.testinfr.YuyuFunctionTestUtil.*;
import jp.co.slcs.swak.core.test.SWAKTestRunner;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

/**
 * 日付フォーマットユーティリティクラスの年月日時分編集メソッド（String）{@link DateFormatUtil#dateYmdhm(String)} テスト用クラスです。<br />
 */

@RunWith(SWAKTestRunner.class)
public class DateFormatUtilTest_dateYmdhm {
    private String      dateStr;

    private String      result;

    @Before
    public void resetDefaultVal(){
        this.result = null;
    }

    @Test
    public void testNormalParam42(){
        dateStr = "20021105110511050";

        result = DateFormatUtil.dateYmdhm(dateStr);
        exStringEquals(result, "H14.11.05 11:05", "年月日時分編集処理結果");
    }

    @Test
    public void testIllegalParam132(){
        dateStr = "20021105110";
        result = DateFormatUtil.dateYmdhm(dateStr);
        exStringEquals(result, "", "年月日時分編集処理結果");
    }

    @Test
    public void testIllegalParam133(){
        dateStr = null;
        result = DateFormatUtil.dateYmdhm(dateStr);
        exStringEquals(result ,"", "年月日時分編集処理結果");
    }

    @Test
    public void testIllegalParam134(){
        dateStr = "";
        result = DateFormatUtil.dateYmdhm(dateStr);
        exStringEquals(result ,"", "年月日時分編集処理結果");
    }
}