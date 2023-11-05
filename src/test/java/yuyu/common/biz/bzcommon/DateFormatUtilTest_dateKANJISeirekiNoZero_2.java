package yuyu.common.biz.bzcommon;

import static yuyu.testinfr.YuyuFunctionTestUtil.*;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.common.biz.exception.CommonBizAppException;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * 日付フォーマットユーティリティクラスの漢字年月日区切りの日付編集（西暦）処理メソッド（String） {@link DateFormatUtil#dateKANJISeirekiNoZero(String))} テスト用クラスです。<br />
 */

@RunWith(OrderedRunner.class)
public class DateFormatUtilTest_dateKANJISeirekiNoZero_2 {
    private String      dateStr;

    private String      result;

    @Before
    public void resetDefaultVal(){
        this.result = null;
    }

    @Test
    @TestOrder(10)
    public void testDateKANJISeirekiNoZero_2_A1(){
        dateStr = "20020505";

        result = DateFormatUtil.dateKANJISeirekiNoZero(dateStr);
        exStringEquals(result, "2002年 5月 5日", "漢字西暦編集処理結果");
    }

    @Test
    @TestOrder(20)
    public void testDateKANJISeirekiNoZero_2_A2(){
        dateStr = "20021115";

        result = DateFormatUtil.dateKANJISeirekiNoZero(dateStr);
        exStringEquals(result, "2002年11月15日", "漢字西暦編集処理結果");
    }

    @Test(expected = NullPointerException.class)
    @TestOrder(30)
    public void testDateKANJISeirekiNoZero_2_A3(){
        dateStr = null;
        result = DateFormatUtil.dateKANJISeirekiNoZero(dateStr);
    }

    @Test(expected = CommonBizAppException.class)
    @TestOrder(40)
    public void testDateKANJISeirekiNoZero_2_A4(){
        dateStr = "";
        String errMsg = null;
        String expMsg = "システム整合性エラーです。入力桁数が不正です。";
        try{
            result = DateFormatUtil.dateKANJISeirekiNoZero(dateStr);
        }catch(CommonBizAppException bae){
            errMsg = bae.getMessage();
            exStringEquals(errMsg, expMsg, "漢字西暦編集処理結果");
            throw bae;
        }
    }

    @Test(expected = CommonBizAppException.class)
    @TestOrder(50)
    public void testDateKANJISeirekiNoZero_2_A5(){
        dateStr = "200211050";
        String errMsg = null;
        String expMsg = "システム整合性エラーです。入力桁数が不正です。";
        try{
            result = DateFormatUtil.dateKANJISeirekiNoZero(dateStr);
        }catch(CommonBizAppException bae){
            errMsg = bae.getMessage();
            exStringEquals(errMsg, expMsg, "漢字西暦編集処理結果");
            throw bae;
        }
    }

    @Test
    @TestOrder(60)
    public void testDateKANJISeirekiNoZero_2_A6(){
        dateStr = "99999999";
        result = DateFormatUtil.dateKANJISeirekiNoZero(dateStr);
        exStringEquals(result, "9999年99月99日", "漢字西暦編集処理結果");
    }

    @Test
    @TestOrder(70)
    public void testDateKANJISeirekiNoZero_2_A7(){
        dateStr = "aaaaaaaa";
        result = DateFormatUtil.dateKANJISeirekiNoZero(dateStr);
        exStringEquals(result, "aaaaaaaa", "漢字西暦編集処理結果");
    }

}
