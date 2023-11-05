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
 * 個別指定書式用日付編集のメソッド{@link FixedDateFormatter#formatYMZenkakuSeirekiKanji()} テスト用クラスです。<br />
 */
@RunWith(OrderedRunner.class)
public class FixedDateFormatterTest_FormatYMZenkakuSeirekiKanji {

    @AfterClass
    public static void testClear() {
        MockObjectManager.initialize();

    }

    @Test
    @TestOrder(10)
    public void testFormatYMZenkakuSeirekiKanji_A1(){

        BizDate pBizDate = null;
        String pBizDateFormat = FixedDateFormatter.formatYMZenkakuSeirekiKanji(pBizDate);
        exStringEquals(pBizDateFormat, "", "編集後日付データ");
    }

    @Test
    @TestOrder(20)
    public void testFormatYMZenkakuSeirekiKanji_A2(){

        BizDate pBizDate = BizDate.valueOf("20160301");
        String pBizDateFormat = FixedDateFormatter.formatYMZenkakuSeirekiKanji(pBizDate);
        exStringEquals(pBizDateFormat, "２０１６年　３月", "編集後日付データ");
    }
}
