package yuyu.common.biz.bzcommon;

import static yuyu.testinfr.YuyuFunctionTestUtil.*;
import jp.co.slcs.swak.core.test.SWAKTestRunner;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.testinfr.TestOrder;

/**
 * 日付フォーマットユーティリティクラスのドット区切り日付編集(和暦、例外なし)処理メソッド（String）{@link DateFormatUtil#dateDOTWarekiNoEx} テスト用クラスです。<br />
 */

@RunWith(SWAKTestRunner.class)
public class DateFormatUtilTest_dateDOTWarekiNoEx_2{
    private String      dateStr;

    private String      result;

    @Before
    public void resetDefaultVal(){
        this.result = null;
    }

    @Test
    @TestOrder(640)
    public void testNormalParam14(){
        dateStr = "20021105";

        result = DateFormatUtil.dateDOTWarekiNoEx(dateStr);
        exStringEquals(result, "H14.11. 5", "ドット和暦編集処理結果");
    }

    @Test
    @TestOrder(650)
    public void testIllegalParam51(){
        dateStr = null;
        result = DateFormatUtil.dateDOTWarekiNoEx(dateStr);
        exStringEquals(result, null, "ドット和暦編集処理結果");
    }

    @Test
    @TestOrder(660)
    public void testIllegalParam52(){
        dateStr = "";
        result = DateFormatUtil.dateDOTWarekiNoEx(dateStr);
        exStringEquals(result, "", "ドット和暦編集処理結果");
    }

    @Test
    @TestOrder(670)
    public void testIllegalParam53(){
        dateStr = "200211050";
        result = DateFormatUtil.dateDOTWarekiNoEx(dateStr);
        exStringEquals(result, "200211050", "ドット和暦編集処理結果");
    }

    @Test
    @TestOrder(680)
    public void testIllegalParam54(){
        dateStr = "99999999";
        result = DateFormatUtil.dateDOTWarekiNoEx(dateStr);
        exStringEquals(result, "99999999", "ドット和暦編集処理結果");
    }

    @Test
    @TestOrder(690)
    public void testIllegalParam55(){
        dateStr = "aaaaaaaa";
        result = DateFormatUtil.dateDOTWarekiNoEx(dateStr);
        exStringEquals(result, "aaaaaaaa", "ドット和暦編集処理結果");
    }

    @Test
    @TestOrder(700)
    public void testIllegalParam56(){
        dateStr = "10001105";
        result = DateFormatUtil.dateDOTWarekiNoEx(dateStr);
        exStringEquals(result, "10001105", "ドット和暦編集処理結果");
    }

}