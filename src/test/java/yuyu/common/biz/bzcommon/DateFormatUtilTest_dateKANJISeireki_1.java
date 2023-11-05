package yuyu.common.biz.bzcommon;

import static yuyu.testinfr.YuyuFunctionTestUtil.*;
import jp.co.slcs.swak.core.test.SWAKTestRunner;
import jp.co.slcs.swak.date.BizDate;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.testinfr.TestOrder;

/**
 * 日付フォーマットユーティリティクラスの漢字年月日区切りの日付編集（西暦）処理メソッド（BizDate） {@link DateFormatUtil#dateKANJISeireki(BizDate)} テスト用クラスです。<br />
 */

@RunWith(SWAKTestRunner.class)
public class DateFormatUtilTest_dateKANJISeireki_1 {
    private BizDate     dateBD;

    private String      result;

    @Before
    public void resetDefaultVal(){
        this.result = null;
    }

    @Test
    @TestOrder(1470)
    public void testNormalParam34(){
        dateBD = BizDate.valueOf("20021105");

        result = DateFormatUtil.dateKANJISeireki(dateBD);
        exStringEquals(result, "2002年11月05日", "漢字西暦編集処理結果");
    }

    @Test
    @TestOrder(1480)
    public void testIllegalParam106(){
        dateBD = null;
        result = DateFormatUtil.dateKANJISeireki(dateBD);
        exStringEquals(result, null, "漢字西暦編集処理結果");
    }

}
