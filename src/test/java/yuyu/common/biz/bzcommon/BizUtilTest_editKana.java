package yuyu.common.biz.bzcommon;

import static yuyu.testinfr.YuyuFunctionTestUtil.*;
import jp.co.slcs.swak.bizinfr.exception.BizAppException;
import jp.co.slcs.swak.core.test.SWAKTestRunner;

import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.testinfr.TestOrder;

/**
 * {@link BizUtil}クラスに含まれる、{@link BizUtil#editKana(String)} メソッドのテストです。
 * <br />
 */

@RunWith(SWAKTestRunner.class)
public class BizUtilTest_editKana {
    @Test
    @TestOrder(1720)
    public void testEditKanaA1(){
        String target = "ヴガギグゲゴザジズゼゾダヂヅデドバビブベボパピプペポ";
        String result = BizUtil.editKana(target);
        String expect ="ウカキクケコサシスセソタシステトハヒフヘホハヒフヘホ";
        exStringEquals(result, expect, "19A(1)文字列（濁音・半濁音）を変換");
    }

    @Test
    @TestOrder(1730)
    public void testEditKanaA2(){
        String target = "ァィゥェォャュョッー・゛゜－";
        String result = BizUtil.editKana(target);
        String expect ="アイウエオヤユヨツ";
        exStringEquals(result, expect, "19A(2)文字列（小文字）を変換");
    }

    @Test(expected=BizAppException.class)
    @TestOrder(1740)
    public void testEditKanaB1(){
        String errmsg = null;
        String expect ="nullチェックエラーです。清音対象文字列";

        String target = null;
        try{
            BizUtil.editKana(target);
        }catch(BizAppException bae){
            errmsg = bae.getMessage();
            exStringEquals(errmsg, expect, "null は例外発生");
            throw bae;
        }
    }

    @Test(expected=BizAppException.class)
    @TestOrder(1750)
    public void testEditKanaC1(){
        String errmsg = null;
        String expect ="桁オーバーチェックエラーです。清音対象文字列";

        String target = "アイウエオカキクケコサシスセソタチツテトナニヌネノハヒフヘホマ";
        try{
            BizUtil.editKana(target);
        }catch(BizAppException bae){
            errmsg = bae.getMessage();
            exStringEquals(errmsg, expect, "文字数３０文字以上 は例外発生");
            throw bae;
        }
    }

    @Test(expected=BizAppException.class)
    @TestOrder(1760)
    public void testEditKanaD1(){
        String errmsg = null;
        String expect ="0byteチェックエラーです。清音対象文字列";

        String target = "";
        try{
            BizUtil.editKana(target);
        }catch(BizAppException bae){
            errmsg = bae.getMessage();
            exStringEquals(errmsg, expect, "ブランクは例外発生");
            throw bae;
        }
    }

    @Test
    @TestOrder(1770)
    public void testEditKanaE1(){
        String target = "かがｶｶﾞKKｋk％%";
        String result = BizUtil.editKana(target);
        String expect ="かがｶｶﾞKKｋk％%";
        exStringEquals(result, expect, "文字列をそのまま返す");
    }

}
