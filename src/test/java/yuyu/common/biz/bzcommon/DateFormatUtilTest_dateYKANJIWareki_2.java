package yuyu.common.biz.bzcommon;

import static yuyu.testinfr.YuyuFunctionTestUtil.*;
import jp.co.slcs.swak.core.test.SWAKTestRunner;
import jp.co.slcs.swak.date.exception.DateParseException;
import jp.co.slcs.swak.date.exception.InvalidDateException;
import jp.co.slcs.swak.date.exception.WarekiOutOfRangeException;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.common.biz.exception.CommonBizAppException;
import yuyu.testinfr.TestOrder;

/**
 * 日付フォーマットユーティリティクラスの漢字年月区切り日付編集メソッド（String）{@link DateFormatUtil#dateYKANJIWareki(String)} テスト用クラスです。<br />
 */

@RunWith(SWAKTestRunner.class)
public class DateFormatUtilTest_dateYKANJIWareki_2{
    private String      dateStr;

    private String      result;

    @Before
    public void resetDefaultVal(){
        this.result = null;
    }

    @Test
    @TestOrder(440)
    public void testNormalParam10(){
        dateStr = "2002";

        result = DateFormatUtil.dateYKANJIWareki(dateStr);
        exStringEquals(result, "平成14年", "漢字和暦編集処理結果");
    }

    @Test(expected = NullPointerException.class)
    @TestOrder(450)
    public void testIllegalParam35(){
        dateStr = null;
        result = DateFormatUtil.dateYKANJIWareki(dateStr);
    }

    @Test(expected = CommonBizAppException.class)
    @TestOrder(460)
    public void testIllegalParam36(){
        dateStr = "";
        String errMsg = null;
        String expMsg = "システム整合性エラーです。入力桁数が不正です。";
        try{
            result = DateFormatUtil.dateYKANJIWareki(dateStr);
        }catch(CommonBizAppException bae){
            errMsg = bae.getMessage();
            exStringEquals(errMsg, expMsg, "漢字和暦編集処理結果");
            throw bae;
        }
    }

    @Test(expected = CommonBizAppException.class)
    @TestOrder(470)
    public void testIllegalParam37(){
        dateStr = "200211050";
        String errMsg = null;
        String expMsg = "システム整合性エラーです。入力桁数が不正です。";
        try{
            result = DateFormatUtil.dateYKANJIWareki(dateStr);
        }catch(CommonBizAppException bae){
            errMsg = bae.getMessage();
            exStringEquals(errMsg, expMsg, "漢字和暦編集処理結果");
            throw bae;
        }
    }

    @Test(expected = InvalidDateException.class)
    @TestOrder(480)
    public void testIllegalParam38(){
        dateStr = "0000";
        result = DateFormatUtil.dateYKANJIWareki(dateStr);
    }

    @Test(expected = DateParseException.class)
    @TestOrder(490)
    public void testIllegalParam39(){
        dateStr = "aaaa";
        result = DateFormatUtil.dateYKANJIWareki(dateStr);
    }


    @Test(expected = WarekiOutOfRangeException.class)
    @TestOrder(500)
    public void testIllegalParam40(){
        dateStr = "1000";
        result = DateFormatUtil.dateYKANJIWareki(dateStr);
    }

}