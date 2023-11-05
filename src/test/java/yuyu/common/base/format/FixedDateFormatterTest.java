package yuyu.common.base.format;

import static yuyu.testinfr.YuyuFunctionTestUtil.*;
import jp.co.dgic.testing.common.virtualmock.MockObjectManager;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.date.exception.InvalidDateException;

import org.junit.AfterClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * 個別指定書式用日付編集のメソッド{@link FixedDateFormatter()} テスト用クラスです。<br />
 */
@RunWith(OrderedRunner.class)

public class FixedDateFormatterTest {
    @AfterClass
    public static void testClear() {
        MockObjectManager.initialize();

    }

    @Test
    @TestOrder(10)
    public void testFormatYMDWarekiKanjiNoneFill_A1(){

        BizDate pBizDate = BizDate.valueOf("00000000");

        try {
            String pBizDateFormat = FixedDateFormatter.formatYMDWarekiKanjiNoneFill(pBizDate);

        } catch(InvalidDateException e){
            exStringEquals(e.getMessage(), "00000000(BizDate) は暦上外の日付です。", "エラーメッセージ");

        }

    }

    @Test
    @TestOrder(20)
    public void testFormatYMZenkakuWarekiKanji_A1(){

        BizDate pBizDate = BizDate.valueOf("99999999");

        try {
            String pBizDateFormat = FixedDateFormatter.formatYMZenkakuWarekiKanji(pBizDate);

        } catch(InvalidDateException e){
            exStringEquals(e.getMessage(), "99999999(BizDate) は暦上外の日付です。", "エラーメッセージ");

        }
    }


    @Test
    @TestOrder(30)
    public void testFormatYoubi_A1(){

        BizDate pBizDate = BizDate.valueOf("00000000");

        try {
            String pBizDateFormat = FixedDateFormatter.formatYoubi(pBizDate);

        } catch(InvalidDateException e){
            exStringEquals(e.getMessage(), "00000000(BizDate) は暦上外の日付です。", "エラーメッセージ");

        }

    }

    @Test
    @TestOrder(40)
    public void testFormatYoubi_A2(){

        BizDate pBizDate = BizDate.valueOf("99999999");

        try {
            String pBizDateFormat = FixedDateFormatter.formatYoubi(pBizDate);

        } catch(InvalidDateException e){
            exStringEquals(e.getMessage(), "99999999(BizDate) は暦上外の日付です。", "エラーメッセージ");

        }

    }


}
