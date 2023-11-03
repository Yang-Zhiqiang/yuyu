package yuyu.common.biz.bzcommon;

import static yuyu.testinfr.YuyuFunctionTestUtil.*;
import jp.co.slcs.swak.core.test.SWAKTestRunner;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.testinfr.TestOrder;

/**
 * {@link BizUtil}クラスに含まれる、{@link BizUtil#editMask(String, int, char)} メソッドのテストです。
 * ※引数：String, int, char<br />
 */

@RunWith(SWAKTestRunner.class)
public class BizUtilTest_editMask_2 {
    private String _target;
    private int    _len;
    private char   _char;
    @Before
    public void initEditMask2(){
        _target = "abcdefg";
        _len    = 3;
        _char   = '*';
    }

    @Test
    @TestOrder(450)
    public void testEditMask2A1(){
        String result = BizUtil.editMask(_target, _len, _char);
        String expect = "abcd***";
        exStringEquals(result, expect, "9A(1)正常パターン");
    }

    @Test
    @TestOrder(460)
    public void testEditMask2B1(){
        _target = null;
        String result = BizUtil.editMask(_target, _len, _char);
        String expect = null;
        exStringEquals(result, expect, "9B(1)対象文字列がnull");
    }

    @Test
    @TestOrder(470)
    public void testEditMask2B2(){
        _target = "";
        String result = BizUtil.editMask(_target, _len, _char);
        String expect = "";
        exStringEquals(result, expect, "9B(2)対象文字列がブランク");
    }

    @Test
    @TestOrder(480)
    public void testEditMask2C1(){
        _len = -1;
        String result = BizUtil.editMask(_target, _len, _char);
        String expect = "abcdefg";
        exStringEquals(result, expect, "9C(1)編集文字数が負値");
    }

    @Test
    @TestOrder(490)
    public void testEditMask2C2(){
        _len = 0;
        String result = BizUtil.editMask(_target, _len, _char);
        String expect = "abcdefg";
        exStringEquals(result, expect, "9C(2)編集文字数が0");
    }

    @Test
    @TestOrder(500)
    public void testEditMask2D1(){
        _len = 20;
        String result = BizUtil.editMask(_target, _len, _char);
        String expect = "*******";
        exStringEquals(result, expect, "9D(1)編集文字数が文字列長を超える");
    }

}
