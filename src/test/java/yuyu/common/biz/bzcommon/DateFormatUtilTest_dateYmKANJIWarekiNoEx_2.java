package yuyu.common.biz.bzcommon;

import static yuyu.testinfr.YuyuFunctionTestUtil.*;
import jp.co.slcs.swak.core.test.SWAKTestRunner;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.testinfr.TestOrder;

/**
 * 日付フォーマットユーティリティクラスの漢字年月区切りの日付編集（和暦、例外なし）処理メソッド（String）{@link DateFormatUtil#dateYmKANJIWarekiNoEx(String)} テスト用クラスです。<br />
 */

@RunWith(SWAKTestRunner.class)
public class DateFormatUtilTest_dateYmKANJIWarekiNoEx_2{
    private String      dateStr;

    private String      result;

    @Before
    public void resetDefaultVal(){
        this.result = null;
    }

    @Test
    @TestOrder(340)
    public void testNormalParam08(){
        dateStr = "200211";

        result = DateFormatUtil.dateYmKANJIWarekiNoEx(dateStr);
        exStringEquals(result, "平成14年11月", "漢字和暦編集処理結果");
    }

    @Test
    @TestOrder(350)
    public void testIllegalParam27(){
        dateStr = null;
        result = DateFormatUtil.dateYmKANJIWarekiNoEx(dateStr);
        exStringEquals(result, null, "漢字和暦編集処理結果");
    }

    @Test
    @TestOrder(360)
    public void testIllegalParam28(){
        dateStr = "";
        result = DateFormatUtil.dateYmKANJIWarekiNoEx(dateStr);
        exStringEquals(result, "", "漢字和暦編集処理結果");
    }

    @Test
    @TestOrder(370)
    public void testIllegalParam29(){
        dateStr = "200211050";
        result = DateFormatUtil.dateYmKANJIWarekiNoEx(dateStr);
        exStringEquals(result, "200211050", "漢字和暦編集処理結果");
    }


    @Test
    @TestOrder(380)
    public void testIllegalParam30(){
        dateStr = "999999";
        result = DateFormatUtil.dateYmKANJIWarekiNoEx(dateStr);
        exStringEquals(result, "999999", "漢字和暦編集処理結果");
    }


    @Test
    @TestOrder(390)
    public void testIllegalParam31(){
        dateStr = "aaaaaa";
        result = DateFormatUtil.dateYmKANJIWarekiNoEx(dateStr);
        exStringEquals(result, "aaaaaa", "漢字和暦編集処理結果");
    }


    @Test
    @TestOrder(400)
    public void testIllegalParam32(){
        dateStr = "100011";
        result = DateFormatUtil.dateYmKANJIWarekiNoEx(dateStr);
        exStringEquals(result, "100011", "漢字和暦編集処理結果");
    }

}