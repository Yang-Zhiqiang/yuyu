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
 * 日付フォーマットユーティリティクラスの漢字年月区切りの日付編集（和暦）処理メソッド（String）{@link DateFormatUtil#dateYmKANJIWareki(String)} テスト用クラスです。<br />
 */

@RunWith(SWAKTestRunner.class)
public class DateFormatUtilTest_dateYmKANJIWareki_2{
    private String      dateStr;

    private String      result;

    @Before
    public void resetDefaultVal(){
        this.result = null;
    }

    @Test
    @TestOrder(240)
    public void testNormalParam06(){
        dateStr = "200211";

        result = DateFormatUtil.dateYmKANJIWareki(dateStr);
        exStringEquals(result, "平成14年11月", "漢字和暦編集処理結果");
    }

    @Test(expected = NullPointerException.class)
    @TestOrder(250)
    public void testIllegalParam19(){
        dateStr = null;
        result = DateFormatUtil.dateYmKANJIWareki(dateStr);
    }

    @Test(expected = CommonBizAppException.class)
    @TestOrder(260)
    public void testIllegalParam20(){
        dateStr = "";
        String errMsg = null;
        String expMsg = "システム整合性エラーです。入力桁数が不正です。";
        try{
            result = DateFormatUtil.dateYmKANJIWareki(dateStr);
        }catch(CommonBizAppException bae){
            errMsg = bae.getMessage();
            exStringEquals(errMsg, expMsg, "漢字和暦編集処理結果");
            throw bae;
        }
    }

    @Test(expected = CommonBizAppException.class)
    @TestOrder(270)
    public void testIllegalParam21(){
        dateStr = "200211050";
        String errMsg = null;
        String expMsg = "システム整合性エラーです。入力桁数が不正です。";
        try{
            result = DateFormatUtil.dateYmKANJIWareki(dateStr);
        }catch(CommonBizAppException bae){
            errMsg = bae.getMessage();
            exStringEquals(errMsg, expMsg, "漢字和暦編集処理結果");
            throw bae;
        }
    }

    @Test(expected = InvalidDateException.class)
    @TestOrder(280)
    public void testIllegalParam22(){
        dateStr = "999999";
        result = DateFormatUtil.dateYmKANJIWareki(dateStr);
    }

    @Test(expected = DateParseException.class)
    @TestOrder(290)
    public void testIllegalParam23(){
        dateStr = "aaaaaa";
        result = DateFormatUtil.dateYmKANJIWareki(dateStr);
    }


    @Test(expected = WarekiOutOfRangeException.class)
    @TestOrder(300)
    public void testIllegalParam24(){
        dateStr = "100011";
        result = DateFormatUtil.dateYmKANJIWareki(dateStr);
    }


}
