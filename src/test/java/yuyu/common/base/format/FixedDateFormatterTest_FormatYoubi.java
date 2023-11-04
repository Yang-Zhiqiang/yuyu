package yuyu.common.base.format;

import static yuyu.testinfr.YuyuFunctionTestUtil.*;
import jp.co.dgic.testing.common.virtualmock.MockObjectManager;
import jp.co.slcs.swak.date.BizDate;

import org.junit.AfterClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * 個別指定書式用日付編集のメソッド{@link FixedDateFormatter#formatYoubi()} テスト用クラスです。<br />
 */
@RunWith(OrderedRunner.class)
public class FixedDateFormatterTest_FormatYoubi {

    @AfterClass
    public static void testClear() {
        MockObjectManager.initialize();

    }

    @Test
    @TestOrder(10)
    public void testFormatYoubi_A1(){

        BizDate pBizDate = null;
        String pBizDateFormat = FixedDateFormatter.formatYoubi(pBizDate);
        exStringEquals(pBizDateFormat, "", "編集後日付データ");
    }

    @Test
    @TestOrder(20)
    public void testFormatYoubi_A2(){

        BizDate pBizDate = BizDate.valueOf("20160328");
        String pBizDateFormat = FixedDateFormatter.formatYoubi(pBizDate);
        exStringEquals(pBizDateFormat, "月", "編集後日付データ");
    }

    @Test
    @TestOrder(30)
    public void testFormatYoubi_A3(){

        BizDate pBizDate = BizDate.valueOf("20160329");
        String pBizDateFormat = FixedDateFormatter.formatYoubi(pBizDate);
        exStringEquals(pBizDateFormat, "火", "編集後日付データ");
    }
    @Test
    @TestOrder(40)
    public void testFormatYoubi_A4(){

        BizDate pBizDate = BizDate.valueOf("20160330");
        String pBizDateFormat = FixedDateFormatter.formatYoubi(pBizDate);
        exStringEquals(pBizDateFormat, "水", "編集後日付データ");
    }
    @Test
    @TestOrder(50)
    public void testFormatYoubi_A5(){

        BizDate pBizDate = BizDate.valueOf("20160331");
        String pBizDateFormat = FixedDateFormatter.formatYoubi(pBizDate);
        exStringEquals(pBizDateFormat, "木", "編集後日付データ");
    }
    @Test
    @TestOrder(60)
    public void testFormatYoubi_A6(){

        BizDate pBizDate = BizDate.valueOf("20160401");
        String pBizDateFormat = FixedDateFormatter.formatYoubi(pBizDate);
        exStringEquals(pBizDateFormat, "金", "編集後日付データ");
    }
    @Test
    @TestOrder(70)
    public void testFormatYoubi_A7(){

        BizDate pBizDate = BizDate.valueOf("20160402");
        String pBizDateFormat = FixedDateFormatter.formatYoubi(pBizDate);
        exStringEquals(pBizDateFormat, "土", "編集後日付データ");
    }

    @Test
    @TestOrder(80)
    public void testFormatYoubi_A8(){

        BizDate pBizDate = BizDate.valueOf("20160403");
        String pBizDateFormat = FixedDateFormatter.formatYoubi(pBizDate);
        exStringEquals(pBizDateFormat, "日", "編集後日付データ");
    }

    @Test
    @TestOrder(90)
    public void testFormatYoubi_B1(){

        BizDate pBizDate = null;
        String stStartmj = "（";
        String stEndmj = "）";
        String pBizDateFormat = FixedDateFormatter.formatYoubi(pBizDate, stStartmj, stEndmj);
        exStringEquals(pBizDateFormat, "", "編集後日付データ");
    }

    @Test
    @TestOrder(100)
    public void testFormatYoubi_B2(){

        BizDate pBizDate = BizDate.valueOf("20160328");
        String stStartmj = "（";
        String stEndmj = "）";
        String pBizDateFormat = FixedDateFormatter.formatYoubi(pBizDate, stStartmj, stEndmj);
        exStringEquals(pBizDateFormat, "（月）", "編集後日付データ");
    }
}
