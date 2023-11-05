package yuyu.common.biz.bzcommon;

import static yuyu.testinfr.YuyuFunctionTestUtil.*;

import java.math.BigDecimal;

import jp.co.slcs.swak.bizinfr.exception.BizAppException;
import jp.co.slcs.swak.core.test.SWAKTestRunner;
import jp.co.slcs.swak.number.BizNumber;

import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.testinfr.TestOrder;

/**
 * {@link BizUtil}クラスに含まれる、{@link BizUtil#blank2zero(BizNumber)} メソッドのテストです。
 * ※ブランク(BizNumber)＞ゼロ(String)変換<br />
 */

@RunWith(SWAKTestRunner.class)
public class BizUtilTest_blank2zero_2 {
    @Test
    @TestOrder(120)
    public void testBlank2ZeroBizNumberBlank1(){
        BizNumber target = new BizNumber();
        String result = BizUtil.blank2zero(target);
        String expect = "0";
        exStringEquals(result, expect, "3A(1)初期状態のBizNumber を変換");
    }

    @Test
    @TestOrder(130)
    public void testBlank2ZeroBizNumberNotBlank1(){
        BizNumber target = BizNumber.valueOf(new BigDecimal("1234"));
        String result = BizUtil.blank2zero(target);
        String expect = "1234";
        exStringEquals(result, expect, "3B(1)ブランク以外は変換しない");
    }

    @Test(expected = BizAppException.class)
    @TestOrder(140)
    public void testBlank2ZeroBizNumberNull1(){
        BizNumber target = null;
        String errmsg = null;
        String expect = "nullチェックエラーです。不明";
        try{
            BizUtil.blank2zero(target);
        }catch(BizAppException bae){
            errmsg = bae.getMessage();
            exStringEquals(errmsg, expect, "3C(1)null は例外発生");
            throw bae;
        }
    }

}
