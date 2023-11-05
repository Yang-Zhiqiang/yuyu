package yuyu.common.biz.bzcommon;

import static yuyu.testinfr.YuyuFunctionTestUtil.*;
import jp.co.slcs.swak.date.BizDate;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * 漢字年月区切り日付編集（西暦年度）処理メソッド（BizDate） {@link DateFormatUtil#dateYKANJISeirekiNendo(BizDate)} テスト用クラスです。<br />
 */

@RunWith(OrderedRunner.class)
public class DateFormatUtilTest_dateYKANJISeirekiNendo {
    private BizDate     dateBD;

    private String      result;

    @Before
    public void resetDefaultVal(){
        this.result = null;
    }

    @Test
    @TestOrder(10)
    public void testDateYKANJISeirekiNendo_A1(){
        dateBD = BizDate.valueOf("20170105");

        result = DateFormatUtil.dateYKANJISeirekiNendo(dateBD);
        exStringEquals(result, "2016年度", "漢字西暦編集処理結果");
    }

    @Test
    @TestOrder(20)
    public void testDateYKANJISeirekiNendo_A2(){
        dateBD = BizDate.valueOf("20170205");

        result = DateFormatUtil.dateYKANJISeirekiNendo(dateBD);
        exStringEquals(result, "2016年度", "漢字西暦編集処理結果");
    }

    @Test
    @TestOrder(30)
    public void testDateYKANJISeirekiNendo_A3(){
        dateBD = BizDate.valueOf("20170305");

        result = DateFormatUtil.dateYKANJISeirekiNendo(dateBD);
        exStringEquals(result, "2016年度", "漢字西暦編集処理結果");
    }

    @Test
    @TestOrder(40)
    public void testDateYKANJISeirekiNendo_A4(){
        dateBD = BizDate.valueOf("20170401");

        result = DateFormatUtil.dateYKANJISeirekiNendo(dateBD);
        exStringEquals(result, "2017年度", "漢字西暦編集処理結果");
    }

    @Test
    @TestOrder(50)
    public void testDateYKANJISeirekiNendo_A5(){
        dateBD = null;

        result = DateFormatUtil.dateYKANJISeirekiNendo(dateBD);
        exStringEquals(result, null, "漢字西暦編集処理結果");
    }

}
