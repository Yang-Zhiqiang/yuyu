package yuyu.common.biz.bzcommon;

import static yuyu.testinfr.YuyuFunctionTestUtil.*;
import jp.co.dgic.testing.common.virtualmock.MockObjectManager;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.date.exception.DateOutOfRangeException;
import jp.co.slcs.swak.date.exception.DateParseException;

import org.junit.AfterClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * {@link BizDateUtil}クラスに含まれる、{@link BizUtil#ifNotBlankValueOf(String)} メソッドのテストです。
 */

@RunWith(OrderedRunner.class)
public class BizDateUtilTest_ifNotBlankValueOf {
    @AfterClass
    public static void testClear() {
        MockObjectManager.initialize();

    }

    @Test
    @TestOrder(10)
    public void testNormalParam01(){
        String target = "20110206";
        BizDate result = BizDateUtil.ifNotBlankValueOf(target);
        BizDate expect = BizDate.valueOf("20110206");
        exDateEquals(result, expect, "日付データ型インスタンス作成処理結果");
    }

    @Test
    @TestOrder(20)
    public void testNormalParam02(){
        String target = "00000000";
        BizDate result = BizDateUtil.ifNotBlankValueOf(target);
        BizDate expect = BizDate.valueOf("00000000");
        exDateEquals(result, expect, "日付データ型インスタンス作成処理結果");
    }

    @Test
    @TestOrder(30)
    public void testNormalParam03(){
        String target = "99999999";
        BizDate result = BizDateUtil.ifNotBlankValueOf(target);
        BizDate expect = BizDate.valueOf("99999999");
        exDateEquals(result, expect, "日付データ型インスタンス作成処理結果");
    }

    @Test
    @TestOrder(40)
    public void testNormalParam04(){
        String target = "";
        BizDate result = BizDateUtil.ifNotBlankValueOf(target);
        BizDate expect = null;
        exDateEquals(result, expect, "日付データ型インスタンス作成処理結果");
    }

    @Test
    @TestOrder(50)
    public void testNormalParam05(){
        String target = null;
        BizDate result = BizDateUtil.ifNotBlankValueOf(target);
        BizDate expect = null;
        exDateEquals(result, expect, "日付データ型インスタンス作成処理結果");
    }

    @Test(expected = DateParseException.class)
    @TestOrder(60)
    public void testIllegalParam01(){
        String target = "a1B２c3Ｄ4";
        BizDateUtil.ifNotBlankValueOf(target);
    }

    @Test(expected = DateOutOfRangeException.class)
    @TestOrder(70)
    public void testIllegalParam02(){
        String target = "201110206";
        BizDateUtil.ifNotBlankValueOf(target);
    }

    @Test(expected = DateParseException.class)
    @TestOrder(80)
    public void testIllegalParam03(){
        String target = "-2011206";
        BizDateUtil.ifNotBlankValueOf(target);
    }

    @Test(expected = DateParseException.class)
    @TestOrder(90)
    public void testIllegalParam04(){
        String target = "-20110206";
        BizDateUtil.ifNotBlankValueOf(target);
    }
}
