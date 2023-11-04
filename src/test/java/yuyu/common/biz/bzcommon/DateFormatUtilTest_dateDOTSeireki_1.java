package yuyu.common.biz.bzcommon;

import static yuyu.testinfr.YuyuFunctionTestUtil.*;
import jp.co.slcs.swak.core.test.SWAKTestRunner;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.date.exception.FormatException;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.testinfr.TestOrder;

/**
 * 日付フォーマットユーティリティクラスのドット区切り日付編集(西暦)メソッド（BizDate）{@link DateFormatUtil#dateDOTSeireki(BizDate)} テスト用クラスです。<br />
 */

@RunWith(SWAKTestRunner.class)
public class DateFormatUtilTest_dateDOTSeireki_1 {
    private BizDate     dateBD;

    private String      result;

    @Before
    public void resetDefaultVal(){
        this.result = null;
    }

    @Test
    @TestOrder(1550)
    public void testNormalParam36(){
        dateBD = BizDate.valueOf("20021105");

        result = DateFormatUtil.dateDOTSeireki(dateBD);
        exStringEquals(result, "2002.11.05", "ドット西暦編集処理結果");
    }

    @Test(expected = FormatException.class)
    @TestOrder(1560)
    public void testIllegalParam112(){
        dateBD = null;
        result = DateFormatUtil.dateDOTSeireki(dateBD);
    }

}
