package yuyu.common.biz.bzcommon;

import static yuyu.testinfr.YuyuFunctionTestUtil.*;
import jp.co.slcs.swak.date.BizDate;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * 日付フォーマットユーティリティクラスの漢字年月日区切りの日付編集（西暦）処理メソッド（BizDate） {@link DateFormatUtil#dateKANJISeirekiNoZero(BizDate)} テスト用クラスです。<br />
 */

@RunWith(OrderedRunner.class)
public class DateFormatUtilTest_dateKANJISeirekiNoZero_1 {
    private BizDate     dateBD;

    private String      result;

    @Before
    public void resetDefaultVal(){
        this.result = null;
    }

    @Test
    @TestOrder(10)
    public void testDateKANJISeirekiNoZero_1_A1(){
        dateBD = BizDate.valueOf("20020705");

        result = DateFormatUtil.dateKANJISeirekiNoZero(dateBD);
        exStringEquals(result, "2002年 7月 5日", "漢字西暦編集処理結果");
    }

    @Test
    @TestOrder(20)
    public void testDateKANJISeirekiNoZero_1_A2(){
        dateBD = BizDate.valueOf("20021115");

        result = DateFormatUtil.dateKANJISeirekiNoZero(dateBD);
        exStringEquals(result, "2002年11月15日", "漢字西暦編集処理結果");
    }

    @Test
    @TestOrder(30)
    public void testDateKANJISeirekiNoZero_1_A3(){
        dateBD = null;
        result = DateFormatUtil.dateKANJISeirekiNoZero(dateBD);
        exStringEquals(result, null, "漢字西暦編集処理結果");
    }

}
