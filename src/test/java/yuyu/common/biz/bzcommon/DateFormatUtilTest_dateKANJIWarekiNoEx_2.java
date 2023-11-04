package yuyu.common.biz.bzcommon;

import static yuyu.testinfr.YuyuFunctionTestUtil.*;
import jp.co.slcs.swak.core.test.SWAKTestRunner;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.testinfr.TestOrder;

/**
 * 日付フォーマットユーティリティクラスの漢字年月日区切りの日付編集（和暦、例外なし）処理メソッド（String）{@link DateFormatUtil#dateKANJIWarekiNoEx(String)} テスト用クラスです。<br />
 */

@RunWith(SWAKTestRunner.class)
public class DateFormatUtilTest_dateKANJIWarekiNoEx_2{
    private String      dateStr;

    private String      result;

    @Before
    public void resetDefaultVal(){
        this.result = null;
    }

    @Test
    @TestOrder(140)
    public void testNormalParam04(){
        dateStr = "20021105";

        result = DateFormatUtil.dateKANJIWarekiNoEx(dateStr);
        exStringEquals(result, "平成14年11月 5日", "漢字和暦編集処理結果");
    }

    @Test
    @TestOrder(150)
    public void testIllegalParam11(){
        dateStr = null;
        result = DateFormatUtil.dateKANJIWarekiNoEx(dateStr);
        exStringEquals(result, null, "漢字和暦編集処理結果");
    }

    @Test
    @TestOrder(160)
    public void testIllegalParam12(){
        dateStr = "";
        result = DateFormatUtil.dateKANJIWarekiNoEx(dateStr);
        exStringEquals(result, "", "漢字和暦編集処理結果");
    }

    @Test
    @TestOrder(170)
    public void testIllegalParam13(){
        dateStr = "200211050";
        result = DateFormatUtil.dateKANJIWarekiNoEx(dateStr);
        exStringEquals(result, "200211050", "漢字和暦編集処理結果");
    }


    @Test
    @TestOrder(180)
    public void testIllegalParam14(){
        dateStr = "99999999";
        result = DateFormatUtil.dateKANJIWarekiNoEx(dateStr);
        exStringEquals(result, "99999999", "漢字和暦編集処理結果");
    }

    @Test
    @TestOrder(190)
    public void testIllegalParam15(){
        dateStr = "aaaaaaaa";
        result = DateFormatUtil.dateKANJIWarekiNoEx(dateStr);
        exStringEquals(result, "aaaaaaaa", "漢字和暦編集処理結果");
    }

    @Test
    @TestOrder(200)
    public void testIllegalParam16(){
        dateStr = "10001105";
        result = DateFormatUtil.dateKANJIWarekiNoEx(dateStr);
        exStringEquals(result, "10001105", "漢字和暦編集処理結果");
    }

}