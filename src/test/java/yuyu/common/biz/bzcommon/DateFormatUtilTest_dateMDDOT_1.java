package yuyu.common.biz.bzcommon;

import static yuyu.testinfr.YuyuFunctionTestUtil.*;
import jp.co.slcs.swak.core.test.SWAKTestRunner;
import jp.co.slcs.swak.date.BizDateMD;
import jp.co.slcs.swak.date.exception.FormatException;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.testinfr.TestOrder;

/**
 * 日付フォーマットユーティリティクラスのドット月日区切り日付編集メソッド（BizDateMD）{@link DateFormatUtil#dateMDDOT(jp.co.slcs.swak.date.BizDateMD)} テスト用クラスです。<br />
 */

@RunWith(SWAKTestRunner.class)
public class DateFormatUtilTest_dateMDDOT_1 {
    private BizDateMD   dateBDMD;

    private String      result;

    @Before
    public void resetDefaultVal(){
        this.result = null;
    }

    @Test
    @TestOrder(1630)
    public void testNormalParam38(){
        dateBDMD = BizDateMD.valueOf("1105");

        result = DateFormatUtil.dateMDDOT(dateBDMD);
        exStringEquals(result, "11.05", "ドット月日編集処理結果");
    }

    @Test(expected = FormatException.class)
    @TestOrder(1640)
    public void testIllegalParam118(){
        dateBDMD = null;
        result = DateFormatUtil.dateMDDOT(dateBDMD);
    }

}
