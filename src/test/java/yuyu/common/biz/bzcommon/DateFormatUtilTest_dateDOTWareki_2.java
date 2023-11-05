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
 * 日付フォーマットユーティリティクラスのドット区切り日付編集(和暦)メソッド（String）{@link DateFormatUtil#dateDOTWareki(String)} テスト用クラスです。<br />
 */

@RunWith(SWAKTestRunner.class)
public class DateFormatUtilTest_dateDOTWareki_2{
    private String      dateStr;

    private String      result;

    @Before
    public void resetDefaultVal(){
        this.result = null;
    }

    @Test
    @TestOrder(540)
    public void testNormalParam12(){
        dateStr = "20021105";

        result = DateFormatUtil.dateDOTWareki(dateStr);
        exStringEquals(result, "H14.11. 5", "ドット和暦編集処理結果");
    }

    @Test(expected = NullPointerException.class)
    @TestOrder(550)
    public void testIllegalParam43(){
        dateStr = null;
        result = DateFormatUtil.dateDOTWareki(dateStr);
    }

    @Test(expected = CommonBizAppException.class)
    @TestOrder(560)
    public void testIllegalParam44(){
        dateStr = "";
        String errMsg = null;
        String expMsg = "システム整合性エラーです。入力桁数が不正です。";
        try{
            result = DateFormatUtil.dateDOTWareki(dateStr);
        }catch(CommonBizAppException bae){
            errMsg = bae.getMessage();
            exStringEquals(errMsg, expMsg, "ドット和暦編集処理結果");
            throw bae;
        }
    }

    @Test(expected = CommonBizAppException.class)
    @TestOrder(570)
    public void testIllegalParam45(){
        dateStr = "200211050";
        String errMsg = null;
        String expMsg = "システム整合性エラーです。入力桁数が不正です。";
        try{
            result = DateFormatUtil.dateDOTWareki(dateStr);
        }catch(CommonBizAppException bae){
            errMsg = bae.getMessage();
            exStringEquals(errMsg, expMsg, "ドット和暦編集処理結果");
            throw bae;
        }
    }

    @Test(expected = InvalidDateException.class)
    @TestOrder(580)
    public void testIllegalParam46(){
        dateStr = "99999999";
        result = DateFormatUtil.dateDOTWareki(dateStr);
    }

    @Test(expected = DateParseException.class)
    @TestOrder(590)
    public void testIllegalParam47(){
        dateStr = "aaaaaaaa";
        result = DateFormatUtil.dateDOTWareki(dateStr);
    }

    @Test(expected = WarekiOutOfRangeException.class)
    @TestOrder(600)
    public void testIllegalParam48(){
        dateStr = "10001105";
        result = DateFormatUtil.dateDOTWareki(dateStr);
    }


}