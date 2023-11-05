package yuyu.common.biz.bzcommon;

import static yuyu.testinfr.YuyuFunctionTestUtil.*;
import jp.co.slcs.swak.core.test.SWAKTestRunner;
import jp.co.slcs.swak.date.BizDateY;
import jp.co.slcs.swak.date.exception.FormatException;
import jp.co.slcs.swak.date.exception.WarekiOutOfRangeException;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.testinfr.TestOrder;

/**
 * 日付フォーマットユーティリティクラスの漢字年月区切り日付編集メソッド（BizDateY）{@link DateFormatUtil#dateYKANJIWareki(BizDateY)} テスト用クラスです。<br />
 */

@RunWith(SWAKTestRunner.class)
public class DateFormatUtilTest_dateYKANJIWareki_1{
    private BizDateY    dateBDY;

    private String      result;

    @Before
    public void resetDefaultVal(){
        this.result = null;
    }

    @Test
    @TestOrder(410)
    public void testNormalParam09(){
        dateBDY = BizDateY.valueOf("2002");

        result = DateFormatUtil.dateYKANJIWareki(dateBDY);
        exStringEquals(result, "平成14年", "漢字和暦編集処理結果");
    }

    @Test(expected = FormatException.class)
    @TestOrder(420)
    public void testIllegalParam33(){
        dateBDY = null;
        result = DateFormatUtil.dateYKANJIWareki(dateBDY);
    }

    @Test(expected = WarekiOutOfRangeException.class)
    @TestOrder(430)
    public void testIllegalParam34(){
        dateBDY = BizDateY.valueOf("1000");
        result = DateFormatUtil.dateYKANJIWareki(dateBDY);
    }

}