package yuyu.common.biz.bzcommon;

import static yuyu.testinfr.YuyuFunctionTestUtil.*;
import jp.co.slcs.swak.core.test.SWAKTestRunner;
import jp.co.slcs.swak.date.BizDateYM;
import jp.co.slcs.swak.date.exception.FormatException;
import jp.co.slcs.swak.date.exception.WarekiOutOfRangeException;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.testinfr.TestOrder;

/**
 * 日付フォーマットユーティリティクラスの漢字年月区切りの日付編集（和暦）処理メソッド（BizDateYM）{@link DateFormatUtil#dateYmKANJIWareki(BizDateYM)} テスト用クラスです。<br />
 */

@RunWith(SWAKTestRunner.class)
public class DateFormatUtilTest_dateYmKANJIWareki_1{
    private BizDateYM   dateBDYM;

    private String      result;

    @Before
    public void resetDefaultVal(){
        this.result = null;
    }

    @Test
    @TestOrder(210)
    public void testNormalParam05(){
        dateBDYM = BizDateYM.valueOf("200211");

        result = DateFormatUtil.dateYmKANJIWareki(dateBDYM);
        exStringEquals(result, "平成14年11月", "漢字和暦編集処理結果");
    }

    @Test(expected = FormatException.class)
    @TestOrder(220)
    public void testIllegalParam17(){
        dateBDYM = null;
        result = DateFormatUtil.dateYmKANJIWareki(dateBDYM);
    }

    @Test(expected = WarekiOutOfRangeException.class)
    @TestOrder(230)
    public void testIllegalParam18(){
        dateBDYM = BizDateYM.valueOf("100011");
        result = DateFormatUtil.dateYmKANJIWareki(dateBDYM);
    }

}