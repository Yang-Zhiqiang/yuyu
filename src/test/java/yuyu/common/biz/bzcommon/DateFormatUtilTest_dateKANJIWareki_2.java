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
 * 日付フォーマットユーティリティクラスの漢字年月日区切りの日付編集（和暦）処理メソッド（String） {@link DateFormatUtil#dateKANJIWareki(String)} テスト用クラスです。<br />
 */

@RunWith(SWAKTestRunner.class)
public class DateFormatUtilTest_dateKANJIWareki_2{
    private String      dateStr;

    private String      result;

    @Before
    public void resetDefaultVal(){
        this.result = null;
    }

    @Test
    @TestOrder(40)
    public void testNormalParam02(){
        dateStr = "20021105";

        result = DateFormatUtil.dateKANJIWareki(dateStr);
        exStringEquals(result, "平成14年11月 5日", "漢字和暦編集処理結果");
    }

    @Test(expected = NullPointerException.class)
    @TestOrder(50)
    public void testIllegalParam03(){
        dateStr = null;
        result = DateFormatUtil.dateKANJIWareki(dateStr);
    }

    @Test(expected = CommonBizAppException.class)
    @TestOrder(60)
    public void testIllegalParam04(){
        dateStr = "";
        String errMsg = null;
        String expMsg = "システム整合性エラーです。入力桁数が不正です。";
        try{
            result = DateFormatUtil.dateKANJIWareki(dateStr);
        }catch(CommonBizAppException bae){
            errMsg = bae.getMessage();
            exStringEquals(errMsg, expMsg, "漢字和暦編集処理結果");
            throw bae;
        }
    }

    @Test(expected = CommonBizAppException.class)
    @TestOrder(70)
    public void testIllegalParam05(){
        dateStr = "200211050";
        String errMsg = null;
        String expMsg = "システム整合性エラーです。入力桁数が不正です。";
        try{
            result = DateFormatUtil.dateKANJIWareki(dateStr);
        }catch(CommonBizAppException bae){
            errMsg = bae.getMessage();
            exStringEquals(errMsg, expMsg, "漢字和暦編集処理結果");
            throw bae;
        }
    }

    @Test(expected = InvalidDateException.class)
    @TestOrder(80)
    public void testIllegalParam06(){
        dateStr = "99999999";
        result = DateFormatUtil.dateKANJIWareki(dateStr);
    }

    @Test(expected = DateParseException.class)
    @TestOrder(90)
    public void testIllegalParam07(){
        dateStr = "aaaaaaaa";
        result = DateFormatUtil.dateKANJIWareki(dateStr);
    }


    @Test(expected = WarekiOutOfRangeException.class)
    @TestOrder(100)
    public void testIllegalParam08(){
        dateStr = "10001105";
        result = DateFormatUtil.dateKANJIWareki(dateStr);
    }


}