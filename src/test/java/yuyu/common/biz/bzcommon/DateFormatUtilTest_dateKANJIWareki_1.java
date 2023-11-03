package yuyu.common.biz.bzcommon;

import static yuyu.testinfr.YuyuFunctionTestUtil.*;
import jp.co.slcs.swak.core.test.SWAKTestRunner;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.date.exception.FormatException;
import jp.co.slcs.swak.date.exception.WarekiOutOfRangeException;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.testinfr.TestOrder;

/**
 * 日付フォーマットユーティリティクラスの漢字年月日区切りの日付編集（和暦）処理メソッド（BizDate） {@link DateFormatUtil#dateKANJIWareki(BizDate)} テスト用クラスです。<br />
 */

@RunWith(SWAKTestRunner.class)
public class DateFormatUtilTest_dateKANJIWareki_1{
    private BizDate     dateBD;

    private String      result;

    @Before
    public void resetDefaultVal(){
        this.result = null;
    }

    @Test
    @TestOrder(10)
    public void testNormalParam01(){
        dateBD = BizDate.valueOf("20021105");

        result = DateFormatUtil.dateKANJIWareki(dateBD);
        exStringEquals(result, "平成14年11月 5日", "漢字和暦編集処理結果");
    }

    @Test(expected = FormatException.class)
    @TestOrder(20)
    public void testIllegalParam01(){
        dateBD = null;
        result = DateFormatUtil.dateKANJIWareki(dateBD);
    }


    @Test(expected = WarekiOutOfRangeException.class)
    @TestOrder(30)
    public void testIllegalParam02(){
        dateBD = BizDate.valueOf("10001105");

        result = DateFormatUtil.dateKANJIWareki(dateBD);
    }


}