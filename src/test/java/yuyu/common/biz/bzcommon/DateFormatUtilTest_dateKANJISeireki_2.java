package yuyu.common.biz.bzcommon;

import static yuyu.testinfr.YuyuFunctionTestUtil.*;
import jp.co.slcs.swak.core.test.SWAKTestRunner;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.common.biz.exception.CommonBizAppException;
import yuyu.testinfr.TestOrder;

/**
 * 日付フォーマットユーティリティクラスの漢字年月日区切りの日付編集（西暦）処理メソッド（String） {@link DateFormatUtil#dateKANJISeireki(String))} テスト用クラスです。<br />
 */

@RunWith(SWAKTestRunner.class)
public class DateFormatUtilTest_dateKANJISeireki_2 {
    private String      dateStr;

    private String      result;

    @Before
    public void resetDefaultVal(){
        this.result = null;
    }

    @Test
    @TestOrder(1490)
    public void testNormalParam35(){
        dateStr = "20021105";

        result = DateFormatUtil.dateKANJISeireki(dateStr);
        exStringEquals(result, "2002年11月05日", "漢字西暦編集処理結果");
    }

    @Test(expected = NullPointerException.class)
    @TestOrder(1500)
    public void testIllegalParam107(){
        dateStr = null;
        result = DateFormatUtil.dateKANJISeireki(dateStr);
    }

    @Test(expected = CommonBizAppException.class)
    @TestOrder(1510)
    public void testIllegalParam108(){
        dateStr = "";
        String errMsg = null;
        String expMsg = "システム整合性エラーです。入力桁数が不正です。";
        try{
            result = DateFormatUtil.dateKANJISeireki(dateStr);
        }catch(CommonBizAppException bae){
            errMsg = bae.getMessage();
            exStringEquals(errMsg, expMsg, "漢字西暦編集処理結果");
            throw bae;
        }
    }

    @Test(expected = CommonBizAppException.class)
    @TestOrder(1520)
    public void testIllegalParam109(){
        dateStr = "200211050";
        String errMsg = null;
        String expMsg = "システム整合性エラーです。入力桁数が不正です。";
        try{
            result = DateFormatUtil.dateKANJISeireki(dateStr);
        }catch(CommonBizAppException bae){
            errMsg = bae.getMessage();
            exStringEquals(errMsg, expMsg, "漢字西暦編集処理結果");
            throw bae;
        }
    }

    @Test
    @TestOrder(1530)
    public void testIllegalParam110(){
        dateStr = "99999999";
        result = DateFormatUtil.dateKANJISeireki(dateStr);
        exStringEquals(result, "9999年99月99日", "漢字西暦編集処理結果");
    }

    @Test
    @TestOrder(1540)
    public void testIllegalParam111(){
        dateStr = "aaaaaaaa";
        result = DateFormatUtil.dateKANJISeireki(dateStr);
        exStringEquals(result, "aaaaaaaa", "漢字西暦編集処理結果");
    }

}
