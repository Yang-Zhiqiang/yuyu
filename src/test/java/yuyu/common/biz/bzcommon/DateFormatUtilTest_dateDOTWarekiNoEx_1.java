package yuyu.common.biz.bzcommon;

import static yuyu.testinfr.YuyuFunctionTestUtil.*;
import jp.co.slcs.swak.core.test.SWAKTestRunner;
import jp.co.slcs.swak.date.BizDate;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.testinfr.TestOrder;

/**
 * 日付フォーマットユーティリティクラスのドット区切り日付編集(和暦、例外なし)処理メソッド（BizDate）{@link DateFormatUtil#dateDOTWarekiNoEx(BizDate)} テスト用クラスです。<br />
 */

@RunWith(SWAKTestRunner.class)
public class DateFormatUtilTest_dateDOTWarekiNoEx_1{
    private BizDate     dateBD;

    private String      result;

    @Before
    public void resetDefaultVal(){
        this.result = null;
    }

    @Test
    @TestOrder(610)
    public void testNormalParam13(){
        dateBD = BizDate.valueOf("20021105");

        result = DateFormatUtil.dateDOTWarekiNoEx(dateBD);
        exStringEquals(result, "H14.11. 5", "ドット和暦編集処理結果");
    }

    @Test
    @TestOrder(620)
    public void testIllegalParam49(){
        dateBD = null;
        result = DateFormatUtil.dateDOTWarekiNoEx(dateBD);
        exStringEquals(result, null, "ドット和暦編集処理結果");
    }

    @Test
    @TestOrder(630)
    public void testIllegalParam50(){
        dateBD = BizDate.valueOf("10001105");
        result = DateFormatUtil.dateDOTWarekiNoEx(dateBD);
        exStringEquals(result, "10001105", "ドット和暦編集処理結果");
    }

}