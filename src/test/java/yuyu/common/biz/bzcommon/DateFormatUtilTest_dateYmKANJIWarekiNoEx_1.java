package yuyu.common.biz.bzcommon;

import static yuyu.testinfr.YuyuFunctionTestUtil.*;
import jp.co.slcs.swak.core.test.SWAKTestRunner;
import jp.co.slcs.swak.date.BizDateYM;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.testinfr.TestOrder;

/**
 * 日付フォーマットユーティリティクラスの漢字年月区切りの日付編集（和暦、例外なし）処理メソッド（BizDateYM）{@link DateFormatUtil#dateYmKANJIWarekiNoEx(BizDateYM)} テスト用クラスです。<br />
 */

@RunWith(SWAKTestRunner.class)
public class DateFormatUtilTest_dateYmKANJIWarekiNoEx_1{
    private BizDateYM   dateBDYM;

    private String      result;

    @Before
    public void resetDefaultVal(){
        this.result = null;
    }

    @Test
    @TestOrder(310)
    public void testNormalParam07(){
        dateBDYM = BizDateYM.valueOf("200211");

        result = DateFormatUtil.dateYmKANJIWarekiNoEx(dateBDYM);
        exStringEquals(result, "平成14年11月", "漢字和暦編集処理結果");
    }

    @Test
    @TestOrder(320)
    public void testIllegalParam25(){
        dateBDYM = null;
        result = DateFormatUtil.dateYmKANJIWarekiNoEx(dateBDYM);
        exStringEquals(result, null, "漢字和暦編集処理結果");
    }


    @Test
    @TestOrder(330)
    public void testIllegalParam26(){
        dateBDYM = BizDateYM.valueOf("100011");
        result = DateFormatUtil.dateYmKANJIWarekiNoEx(dateBDYM);
        exStringEquals(result, "100011", "漢字和暦編集処理結果");
    }


}