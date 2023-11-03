package yuyu.common.biz.bzcommon;

import static yuyu.testinfr.YuyuFunctionTestUtil.*;
import jp.co.slcs.swak.core.test.SWAKTestRunner;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.testinfr.TestOrder;

/**
 * {@link BizUtil}クラスに含まれる、{@link BizUtil#editMask(String, int, int, char)} メソッドのテストです。
 * ※引数：String, int, int, char<br />
 */

@RunWith(SWAKTestRunner.class)
public class BizUtilTest_editMask_1 {

    private String _target;
    private int    _start;
    private int    _len;
    private char   _char;
    @Before
    public void initEditMask1(){
        _target = "abcdefg";
        _start  = 2;
        _len    = 3;
        _char   = '*';
    }


    @Test
    @TestOrder(310)
    public void testEditMask1A1(){
        String result = BizUtil.editMask(_target,_start,_len, _char);
        String expect = "ab***fg";
        exStringEquals(result, expect, "8A(1)正常パターン");
    }

    @Test
    @TestOrder(320)
    public void testEditMask1B1(){
        _target = null;
        String result = BizUtil.editMask(_target,_start,_len, _char);
        String expect = null;
        exStringEquals(result, expect, "8B(1)対象文字列がnull");
    }

    @Test
    @TestOrder(330)
    public void testEditMask1B2(){
        _target = "";
        String result = BizUtil.editMask(_target,_start,_len, _char);
        String expect = "";
        exStringEquals(result, expect, "8B(2)対象文字列がブランク");
    }

    @Test(expected=IndexOutOfBoundsException.class)
    @TestOrder(340)
    public void testEditMask1C1(){
        _start = -1;
        try{
            BizUtil.editMask(_target,_start,_len, _char);
        }catch(IndexOutOfBoundsException ioobe){
            throw ioobe;
        }
    }

    @Test
    @TestOrder(350)
    public void testEditMask1C2(){
        _start = 0;
        String result = BizUtil.editMask(_target,_start,_len, _char);
        String expect = "***defg";
        exStringEquals(result, expect, "8C(2)編集開始位置が0");
    }

    @Test
    @TestOrder(360)
    public void testEditMask1C3(){
        _start = 6;
        _len   = 1;
        String result = BizUtil.editMask(_target,_start,_len, _char);
        String expect = "abcdef*";
        exStringEquals(result, expect, "8C(3)編集開始位置が文字列長-1");
    }

    @Test
    @TestOrder(370)
    public void testEditMask1C4(){
        _start = 7;
        _len   = 0;
        String result = BizUtil.editMask(_target,_start,_len, _char);
        String expect = "abcdefg";
        exStringEquals(result, expect, "8C(4)編集開始位置が文字列長");
    }

    @Test
    @TestOrder(380)
    public void testEditMask1C5(){
        _start = 8;
        _len   = 0;
        String result = BizUtil.editMask(_target,_start,_len, _char);
        String expect = "abcdefg";
        exStringEquals(result, expect, "8C(5)編集開始位置が文字列長+1");
    }

    @Test(expected=NegativeArraySizeException.class)
    @TestOrder(390)
    public void testEditMask1D1(){
        _len = -1;
        try{
            BizUtil.editMask(_target,_start,_len, _char);
        }catch(NegativeArraySizeException nase){
            throw nase;
        }
    }

    @Test
    @TestOrder(400)
    public void testEditMask1D2(){
        _len = 0;
        String result = BizUtil.editMask(_target,_start,_len, _char);
        String expect = "abcdefg";
        exStringEquals(result, expect, "8D(2)編集文字数が0");
    }

    @Test
    @TestOrder(410)
    public void testEditMask1D3(){
        _len = 5;
        String result = BizUtil.editMask(_target,_start,_len, _char);
        String expect = "ab*****";
        exStringEquals(result, expect, "8D(3)文字列長-編集開始位置");
    }

    @Test
    @TestOrder(420)
    public void testEditMask1D4(){
        _len = 6;
        String result = BizUtil.editMask(_target,_start,_len, _char);
        String expect = "abcdefg";
        exStringEquals(result, expect, "8D(4)文字列長-編集開始位置+1");
    }

    @Test
    @TestOrder(430)
    public void testEditMask1E1(){
        _start = -1;
        _len   = 10;
        String result = BizUtil.editMask(_target,_start,_len, _char);
        String expect = "abcdefg";
        exStringEquals(result, expect, "8E(1)編集開始位置が負値");
    }

    @Test
    @TestOrder(440)
    public void testEditMask1E2(){
        _start = 10;
        _len   = -1;
        String result = BizUtil.editMask(_target,_start,_len, _char);
        String expect = "abcdefg";
        exStringEquals(result, expect, "8E(2)編集文字数が負値");
    }

}
