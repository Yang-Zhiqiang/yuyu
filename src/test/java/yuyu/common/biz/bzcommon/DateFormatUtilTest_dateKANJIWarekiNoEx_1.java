package yuyu.common.biz.bzcommon;

import static yuyu.testinfr.YuyuFunctionTestUtil.*;
import jp.co.slcs.swak.core.test.SWAKTestRunner;
import jp.co.slcs.swak.date.BizDate;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.testinfr.TestOrder;

/**
 * 日付フォーマットユーティリティクラスの漢字年月日区切りの日付編集（和暦、例外なし）処理メソッド（BizDate）{@link DateFormatUtil#dateKANJIWarekiNoEx(BizDate)} テスト用クラスです。<br />
 */

@RunWith(SWAKTestRunner.class)
public class DateFormatUtilTest_dateKANJIWarekiNoEx_1{
    private BizDate     dateBD;

    private String      result;

    @Before
    public void resetDefaultVal(){
        this.result = null;
    }

    @Test
    @TestOrder(110)
    public void testNormalParam03(){
        dateBD = BizDate.valueOf("20021105");

        result = DateFormatUtil.dateKANJIWarekiNoEx(dateBD);
        exStringEquals(result, "平成14年11月 5日", "漢字和暦編集処理結果");
    }

    @Test
    @TestOrder(120)
    public void testIllegalParam09(){
        dateBD = null;
        result = DateFormatUtil.dateKANJIWarekiNoEx(dateBD);
        exStringEquals(result, null, "漢字和暦編集処理結果");
    }


    @Test
    @TestOrder(130)
    public void testIllegalParam10(){
        dateBD = BizDate.valueOf("10001105");
        result = DateFormatUtil.dateKANJIWarekiNoEx(dateBD);
        exStringEquals(result, "10001105", "漢字和暦編集処理結果");
    }

}