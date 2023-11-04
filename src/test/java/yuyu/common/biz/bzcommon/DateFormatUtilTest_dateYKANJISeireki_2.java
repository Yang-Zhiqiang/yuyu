package yuyu.common.biz.bzcommon;

import static yuyu.testinfr.YuyuFunctionTestUtil.*;
import jp.co.slcs.swak.date.exception.DateParseException;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.common.biz.exception.CommonBizAppException;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * 日付フォーマットユーティリティクラスの漢字年月区切り日付編集メソッド（String）{@link DateFormatUtil#dateYKANJISeireki(String)} テスト用クラスです。<br />
 */

@RunWith(OrderedRunner.class)
public class DateFormatUtilTest_dateYKANJISeireki_2{
    private String      dateStr;

    private String      result;

    @Before
    public void resetDefaultVal(){
        this.result = null;
    }

    @Test
    @TestOrder(10)
    public void testDateYKANJISeireki_B1(){
        dateStr = "2002";

        result = DateFormatUtil.dateYKANJISeireki(dateStr);
        exStringEquals(result, "2002年", "漢字西暦編集処理結果");
    }

    @Test(expected = NullPointerException.class)
    @TestOrder(20)
    public void testDateYKANJISeireki_B2(){
        dateStr = null;
        result = DateFormatUtil.dateYKANJISeireki(dateStr);
    }

    @Test(expected = CommonBizAppException.class)
    @TestOrder(30)
    public void testDateYKANJISeireki_B3(){
        dateStr = "";
        String errMsg = null;
        String expMsg = "システム整合性エラーです。入力桁数が不正です。";
        try{
            result = DateFormatUtil.dateYKANJISeireki(dateStr);
        }catch(CommonBizAppException bae){
            errMsg = bae.getMessage();
            exStringEquals(errMsg, expMsg, "漢字西暦編集処理結果");
            throw bae;
        }
    }

    @Test(expected = CommonBizAppException.class)
    @TestOrder(40)
    public void testDateYKANJISeireki_B4(){
        dateStr = "200211050";
        String errMsg = null;
        String expMsg = "システム整合性エラーです。入力桁数が不正です。";
        try{
            result = DateFormatUtil.dateYKANJISeireki(dateStr);
        }catch(CommonBizAppException bae){
            errMsg = bae.getMessage();
            exStringEquals(errMsg, expMsg, "漢字西暦編集処理結果");
            throw bae;
        }
    }

    @Test(expected = DateParseException.class)
    @TestOrder(50)
    public void testDateYKANJISeireki_B5(){
        dateStr = "aaaa";
        result = DateFormatUtil.dateYKANJISeireki(dateStr);
    }

}