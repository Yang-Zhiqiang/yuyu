package yuyu.common.biz.bzcommon;

import static yuyu.testinfr.YuyuFunctionTestUtil.*;
import jp.co.slcs.swak.core.test.SWAKTestRunner;
import jp.co.slcs.swak.date.BizDate;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

/**
 * 日付フォーマットユーティリティクラスの年月日編集処理(西暦)メソッド（BizDate）{@link DateFormatUtil#smd(BizDate)} テスト用クラスです。<br />
 */

@RunWith(SWAKTestRunner.class)
public class DateFormatUtilTest_smd {
    private BizDate     dateBD;

    private String      result;

    @Before
    public void resetDefaultVal(){
        this.result = null;
    }

    @Test
    public void testNormalParam43(){
        dateBD = BizDate.valueOf("20011006");

        result = DateFormatUtil.smd(dateBD);
        exStringEquals(result, "2001.10.06", "年月日編集処理(西暦)");
    }

    @Test
    public void testIllegalParam135(){
        dateBD = null;
        result = DateFormatUtil.smd(dateBD);
        exStringEquals(result,"","年月日編集処理(西暦)");
    }

}