package yuyu.common.biz.bzcommon;

import static yuyu.testinfr.YuyuFunctionTestUtil.*;
import jp.co.slcs.swak.date.BizDateY;
import jp.co.slcs.swak.date.exception.FormatException;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * 日付フォーマットユーティリティクラスの漢字年月区切り日付編集メソッド（BizDateY）{@link DateFormatUtil#dateYKANJISeireki(BizDateY)} テスト用クラスです。<br />
 */

@RunWith(OrderedRunner.class)
public class DateFormatUtilTest_dateYKANJISeireki_1{

    private BizDateY    dateY;

    private String      result;

    @Before
    public void resetDefaultVal(){
        this.result = null;
    }

    @Test
    @TestOrder(10)
    public void testDateYKANJISeireki_A1(){
        dateY = BizDateY.valueOf("2017");
        result = DateFormatUtil.dateYKANJISeireki(dateY);
        exStringEquals(result, "2017年", "漢字西暦編集処理結果");
    }

    @Test(expected = FormatException.class)
    @TestOrder(20)
    public void testDateYKANJISeireki_A2(){
        dateY = null;
        result = DateFormatUtil.dateYKANJISeireki(dateY);
    }
}