package yuyu.common.biz.bzcommon;

import static yuyu.testinfr.YuyuFunctionTestUtil.*;
import jp.co.slcs.swak.date.BizDate;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * 漢字年月区切りの日付編集処理メソッド（BizDate） {@link DateFormatUtil#dateYKANJIWarekiNendo(BizDate)} テスト用クラスです。<br />
 */

@RunWith(OrderedRunner.class)
public class DateFormatUtilTest_dateYKANJIWarekiNendo {
    private BizDate     dateBD;

    private String      result;

    @Before
    public void resetDefaultVal(){
        this.result = null;
    }

    @Test
    @TestOrder(10)
    public void testDateYKANJIWarekiNendo_A1(){
        dateBD = BizDate.valueOf("20170105");

        result = DateFormatUtil.dateYKANJIWarekiNendo(dateBD);
        exStringEquals(result, "平成28年度", "漢字和暦編集処理結果");
    }

    @Test
    @TestOrder(20)
    public void testDateYKANJIWarekiNendo_A2(){
        dateBD = BizDate.valueOf("20170205");

        result = DateFormatUtil.dateYKANJIWarekiNendo(dateBD);
        exStringEquals(result, "平成28年度", "漢字和暦編集処理結果");
    }

    @Test
    @TestOrder(30)
    public void testDateYKANJIWarekiNendo_A3(){
        dateBD = BizDate.valueOf("20170305");

        result = DateFormatUtil.dateYKANJIWarekiNendo(dateBD);
        exStringEquals(result, "平成28年度", "漢字和暦編集処理結果");
    }

    @Test
    @TestOrder(40)
    public void testDateYKANJIWarekiNendo_A4(){
        dateBD = BizDate.valueOf("19890401");

        result = DateFormatUtil.dateYKANJIWarekiNendo(dateBD);
        exStringEquals(result, "平成 1年度", "漢字和暦編集処理結果");
    }

    @Test
    @TestOrder(50)
    public void testDateYKANJIWarekiNendo_A5(){
        dateBD = null;

        result = DateFormatUtil.dateYKANJIWarekiNendo(dateBD);
        exStringEquals(result, null, "漢字和暦編集処理結果");
    }

    @Test
    @TestOrder(60)
    public void testDateYKANJIWarekiNendo_A6(){
        dateBD = BizDate.valueOf("10120204");

        result = DateFormatUtil.dateYKANJIWarekiNendo(dateBD);
        exStringEquals(result, "10120204", "漢字和暦編集処理結果");
    }

}
