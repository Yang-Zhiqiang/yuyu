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
 * 日付フォーマットユーティリティクラスのドット区切り日付編集(西暦)メソッド（String）{@link DateFormatUtil#dateDOTSeireki(String))} テスト用クラスです。<br />
 */

@RunWith(SWAKTestRunner.class)
public class DateFormatUtilTest_dateDOTSeireki_2 {
    private String      dateStr;

    private String      result;

    @Before
    public void resetDefaultVal(){
        this.result = null;
    }

    @Test
    @TestOrder(1570)
    public void testNormalParam37(){
        dateStr = "20021105";

        result = DateFormatUtil.dateDOTSeireki(dateStr);
        exStringEquals(result, "2002.11.05", "ドット西暦編集処理結果");
    }

    @Test(expected = NullPointerException.class)
    @TestOrder(1580)
    public void testIllegalParam113(){
        dateStr = null;
        result = DateFormatUtil.dateDOTSeireki(dateStr);
    }

    @Test(expected = CommonBizAppException.class)
    @TestOrder(1590)
    public void testIllegalParam114(){
        dateStr = "";
        String errMsg = null;
        String expMsg = "システム整合性エラーです。入力桁数が不正です。";
        try{
            result = DateFormatUtil.dateDOTSeireki(dateStr);
        }catch(CommonBizAppException bae){
            errMsg = bae.getMessage();
            exStringEquals(errMsg, expMsg, "ドット西暦編集処理結果");
            throw bae;
        }
    }

    @Test(expected = CommonBizAppException.class)
    @TestOrder(1600)
    public void testIllegalParam115(){
        dateStr = "200211050";
        String errMsg = null;
        String expMsg = "システム整合性エラーです。入力桁数が不正です。";
        try{
            result = DateFormatUtil.dateDOTSeireki(dateStr);
        }catch(CommonBizAppException bae){
            errMsg = bae.getMessage();
            exStringEquals(errMsg, expMsg, "ドット西暦編集処理結果");
            throw bae;
        }
    }

    @Test
    @TestOrder(1610)
    public void testIllegalParam116(){
        dateStr = "99999999";
        result = DateFormatUtil.dateDOTSeireki(dateStr);
        exStringEquals(result, "9999.99.99", "ドット西暦編集処理結果");
    }

    @Test(expected = DateParseException.class)
    @TestOrder(1620)
    public void testIllegalParam117(){
        dateStr = "aaaaaaaa";
        result = DateFormatUtil.dateDOTSeireki(dateStr);
    }

}
