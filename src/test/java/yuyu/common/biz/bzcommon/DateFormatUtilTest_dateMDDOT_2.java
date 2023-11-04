package yuyu.common.biz.bzcommon;

import static yuyu.testinfr.YuyuFunctionTestUtil.*;
import jp.co.slcs.swak.core.test.SWAKTestRunner;
import jp.co.slcs.swak.date.exception.DateParseException;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.common.biz.exception.CommonBizAppException;
import yuyu.testinfr.TestOrder;

/**
 * 日付フォーマットユーティリティクラスのドット月日区切り日付編集メソッド（String）{@link DateFormatUtil#dateMDDOT(String)} テスト用クラスです。<br />
 */

@RunWith(SWAKTestRunner.class)
public class DateFormatUtilTest_dateMDDOT_2 {
    private String      dateStr;

    private String      result;

    @Before
    public void resetDefaultVal(){
        this.result = null;
    }

    @Test
    @TestOrder(1650)
    public void testNormalParam39(){
        dateStr = "1105";

        result = DateFormatUtil.dateMDDOT(dateStr);
        exStringEquals(result, "11.05", "ドット月日編集処理結果");
    }

    @Test(expected = NullPointerException.class)
    @TestOrder(1660)
    public void testIllegalParam119(){
        dateStr = null;
        result = DateFormatUtil.dateMDDOT(dateStr);
    }

    @Test(expected = CommonBizAppException.class)
    @TestOrder(1670)
    public void testIllegalParam120(){
        dateStr = "";
        String errMsg = null;
        String expMsg = "システム整合性エラーです。入力桁数が不正です。";
        try{
            result = DateFormatUtil.dateMDDOT(dateStr);
        }catch(CommonBizAppException bae){
            errMsg = bae.getMessage();
            exStringEquals(errMsg, expMsg, "ドット月日編集処理結果");
            throw bae;
        }
    }

    @Test(expected = CommonBizAppException.class)
    @TestOrder(1680)
    public void testIllegalParam121(){
        dateStr = "200211050";
        String errMsg = null;
        String expMsg = "システム整合性エラーです。入力桁数が不正です。";
        try{
            result = DateFormatUtil.dateMDDOT(dateStr);
        }catch(CommonBizAppException bae){
            errMsg = bae.getMessage();
            exStringEquals(errMsg, expMsg, "ドット月日編集処理結果");
            throw bae;
        }
    }

    @Test
    @TestOrder(1690)
    public void testIllegalParam122(){
        dateStr = "9999";
        result = DateFormatUtil.dateMDDOT(dateStr);
        exStringEquals(result, "99.99", "ドット月日編集処理結果");
    }

    @Test(expected = DateParseException.class)
    @TestOrder(1700)
    public void testIllegalParam123(){
        dateStr = "aaaa";
        result = DateFormatUtil.dateMDDOT(dateStr);
    }

}
