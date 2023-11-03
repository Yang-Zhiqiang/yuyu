package yuyu.common.biz.bzcommon;

import static yuyu.testinfr.YuyuFunctionTestUtil.*;
import jp.co.slcs.swak.core.test.SWAKTestRunner;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.date.exception.FormatException;
import jp.co.slcs.swak.date.exception.WarekiOutOfRangeException;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.testinfr.TestOrder;

/**
 * 日付フォーマットユーティリティクラスのドット区切り日付編集(和暦)メソッド（BizDate）{@link DateFormatUtil#dateDOTWareki(BizDate)} テスト用クラスです。<br />
 */

@RunWith(SWAKTestRunner.class)
public class DateFormatUtilTest_dateDOTWareki_1{
    private BizDate     dateBD;

    private String      result;

    @Before
    public void resetDefaultVal(){
        this.result = null;
    }

    @Test
    @TestOrder(510)
    public void testNormalParam11(){
        dateBD = BizDate.valueOf("20021105");

        result = DateFormatUtil.dateDOTWareki(dateBD);
        exStringEquals(result, "H14.11. 5", "ドット和暦編集処理結果");
    }

    @Test(expected = FormatException.class)
    @TestOrder(520)
    public void testIllegalParam41(){
        dateBD = null;
        result = DateFormatUtil.dateDOTWareki(dateBD);
    }
    @Test(expected = WarekiOutOfRangeException.class)
    @TestOrder(530)
    public void testIllegalParam42(){
        dateBD = BizDate.valueOf("10001105");

        result = DateFormatUtil.dateDOTWareki(dateBD);
    }

}