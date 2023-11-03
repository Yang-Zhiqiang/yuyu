package yuyu.common.biz.bzcommon;

import static org.junit.Assert.*;
import static yuyu.def.YuyuStandardCharsets.*;
import jp.co.dgic.testing.common.virtualmock.MockObjectManager;
import jp.co.slcs.swak.core.test.SWAKTestRunner;

import org.junit.AfterClass;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(SWAKTestRunner.class)
public class SkjStringUtilTest {

	@AfterClass
    public static void testClear() {
        MockObjectManager.initialize();

    }

    @Test
    public void testNull(){
        ReplaceSkjResultBean result = SkjStringUtil.replaceSjk(null, '・');
        assertEquals(null,result.getReplacedString());
        assertTrue(!result.isReplaced());
    }

    @Test
    public void testBlank(){
        ReplaceSkjResultBean result = SkjStringUtil.replaceSjk("", '・');
        assertEquals("",result.getReplacedString());
        assertTrue(!result.isReplaced());
    }

    @Test
    public void testJis90Mark(){
        ReplaceSkjResultBean result = SkjStringUtil.replaceSjk("、。／", '・');
        assertEquals("、。／",result.getReplacedString());
        assertTrue(!result.isReplaced());
    }

    @Test
    public void testNotJis90Mark(){
        ReplaceSkjResultBean result = SkjStringUtil.replaceSjk("㋀Ⓐ⏅", '・');
        assertEquals("・・・",result.getReplacedString());
        assertTrue(result.isReplaced());
    }

    @Test
    public void testNotJis90Mark2(){
        ReplaceSkjResultBean result = SkjStringUtil.replaceSjk("㋀Ⓐ⏅");
        assertEquals("■■■",result.getReplacedString());
        assertTrue(result.isReplaced());
    }

    @Test
    public void testNotJis90MarkZenpou(){
        ReplaceSkjResultBean result = SkjStringUtil.replaceSjk("㋀Ⓐ⏅あ", '・');
        assertEquals("・・・あ",result.getReplacedString());
        assertTrue(result.isReplaced());
    }

    @Test
    public void testNotJis90MarkBubun(){
        ReplaceSkjResultBean result = SkjStringUtil.replaceSjk("あ㋀Ⓐ⏅あ", '・');
        assertEquals("あ・・・あ",result.getReplacedString());
        assertTrue(result.isReplaced());
    }

    @Test
    public void testNotJis90MarkKouhou(){
        ReplaceSkjResultBean result = SkjStringUtil.replaceSjk("あ㋀Ⓐ⏅", '・');
        assertEquals("あ・・・",result.getReplacedString());
        assertTrue(result.isReplaced());
    }

    @Test
    public void test1Suijun(){
        ReplaceSkjResultBean result = SkjStringUtil.replaceSjk("あアァＡａ亜", '・');
        assertEquals("あアァＡａ亜",result.getReplacedString());
        assertTrue(!result.isReplaced());
    }

    @Test
    public void test2Suijun(){
        ReplaceSkjResultBean result = SkjStringUtil.replaceSjk("弌冲勹", '・');
        assertEquals("弌冲勹",result.getReplacedString());
        assertTrue(!result.isReplaced());
    }

    @Test
    public void testSkj3Suijun(){
        ReplaceSkjResultBean result = SkjStringUtil.replaceSjk("丨侊冝", '・');
        assertEquals("丨侊冝",result.getReplacedString());
        assertTrue(!result.isReplaced());
    }

    @Test
    public void testNotSkj3Suijun(){
        ReplaceSkjResultBean result = SkjStringUtil.replaceSjk("俱俠㒵", '・');
        assertEquals("・・・",result.getReplacedString());
        assertTrue(result.isReplaced());
    }

    @Test
    public void testNotSkj3SuijunZenpou(){
        ReplaceSkjResultBean result = SkjStringUtil.replaceSjk("俱俠㒵あ", '・');
        assertEquals("・・・あ",result.getReplacedString());
        assertTrue(result.isReplaced());
    }

    @Test
    public void testNotSkj3SuijunBubun(){
        ReplaceSkjResultBean result = SkjStringUtil.replaceSjk("あ俱俠㒵あ", '・');
        assertEquals("あ・・・あ",result.getReplacedString());
        assertTrue(result.isReplaced());
    }

    @Test
    public void testNotSkj3SuijunKouhou(){
        ReplaceSkjResultBean result = SkjStringUtil.replaceSjk("あ俱俠㒵", '・');
        assertEquals("あ・・・",result.getReplacedString());
        assertTrue(result.isReplaced());
    }

    @Test
    public void testSkj4Suijun(){
        ReplaceSkjResultBean result = SkjStringUtil.replaceSjk("伀侒侚", '・');
        assertEquals("伀侒侚",result.getReplacedString());
        assertTrue(!result.isReplaced());
    }

    @Test
    public void testNotSkj4Suijun(){
        ReplaceSkjResultBean result = SkjStringUtil.replaceSjk("丂乩亻", '・');
        assertEquals("・・・",result.getReplacedString());
        assertTrue(result.isReplaced());
    }

    @Test
    public void testNotSkj4SuijunZenpou(){
        ReplaceSkjResultBean result = SkjStringUtil.replaceSjk("丂乩亻あ", '・');
        assertEquals("・・・あ",result.getReplacedString());
        assertTrue(result.isReplaced());
    }

    @Test
    public void testNotSkj4SuijunBubun(){
        ReplaceSkjResultBean result = SkjStringUtil.replaceSjk("あ丂乩亻あ", '・');
        assertEquals("あ・・・あ",result.getReplacedString());
        assertTrue(result.isReplaced());
    }

    @Test
    public void testNotSkj4SuijunKouhou(){
        ReplaceSkjResultBean result = SkjStringUtil.replaceSjk("あ丂乩亻", '・');
        assertEquals("あ・・・",result.getReplacedString());
        assertTrue(result.isReplaced());
    }

    @Test
    public void testSingleSkj(){
        ReplaceSkjResultBean result = SkjStringUtil.replaceSjk("ｱA\\", '・');
        assertEquals("ｱA\\",result.getReplacedString());
        assertTrue(!result.isReplaced());
    }

    @Test
    public void testSingleUtf8(){
        ReplaceSkjResultBean result = SkjStringUtil.replaceSjk("€Á®", '・');
        assertEquals("・・・",result.getReplacedString());
        assertTrue(result.isReplaced());
    }

    @Test
    public void testSingleUtf8Zenpou(){
        ReplaceSkjResultBean result = SkjStringUtil.replaceSjk("€Á®あ", '・');
        assertEquals("・・・あ",result.getReplacedString());
        assertTrue(result.isReplaced());
    }

    @Test
    public void testSingleUtf8Bubun(){
        ReplaceSkjResultBean result = SkjStringUtil.replaceSjk("あ€Á®あ", '・');
        assertEquals("あ・・・あ",result.getReplacedString());
        assertTrue(result.isReplaced());
    }

    @Test
    public void testSingleUtf8Kouhou(){
        ReplaceSkjResultBean result = SkjStringUtil.replaceSjk("あ€Á®", '・');
        assertEquals("あ・・・",result.getReplacedString());
        assertTrue(result.isReplaced());
    }

    @Test
    public void testSingleWin31J(){
        ReplaceSkjResultBean result = SkjStringUtil.replaceSjk("ｯa{", '・');
        assertEquals("ｯa{",result.getReplacedString());
        assertTrue(!result.isReplaced());
    }

    @Test
    public void testNotSkj(){
        ReplaceSkjResultBean result = SkjStringUtil.replaceSjk("①㈲Σ", '・');
        assertEquals("・・・",result.getReplacedString());
        assertTrue(result.isReplaced());
    }

    @Test
    public void testNotSkjZenpou(){
        ReplaceSkjResultBean result = SkjStringUtil.replaceSjk("①㈲Σあ", '・');
        assertEquals("・・・あ",result.getReplacedString());
        assertTrue(result.isReplaced());
    }

    @Test
    public void testNotSkjBubun(){
        ReplaceSkjResultBean result = SkjStringUtil.replaceSjk("あ①㈲Σあ", '・');
        assertEquals("あ・・・あ",result.getReplacedString());
        assertTrue(result.isReplaced());
    }


    @Test
    public void testNotSkjzKouhou(){
        ReplaceSkjResultBean result = SkjStringUtil.replaceSjk("あ①㈲Σ", '・');
        assertEquals("あ・・・",result.getReplacedString());
        assertTrue(result.isReplaced());
    }

    @Test
    public void testGaiji(){

        String test =new String(new byte[]{(byte)0xF0,(byte)0x40,(byte)0xF0,(byte)0x41,(byte)0xF0,(byte)0x42},WINDOWS_31J);
        ReplaceSkjResultBean result = SkjStringUtil.replaceSjk(test, '■');
        assertEquals(test,result.getReplacedString());
        assertTrue(!result.isReplaced());
    }

    @Test
    public void testNotSkjMoura(){
        ReplaceSkjResultBean result = SkjStringUtil.replaceSjk("①②③④⑤⑥⑦⑧⑨⑩⑪⑫⑬⑭⑮⑯⑰⑱⑲⑳㍉㌔㌢㍍㌘㌧㌃㌶㍑㍗㌍㌦㌣㌫㍊㌻㎜㎝㎞㎎㎏㏄㍻〝〟㏍㊤㊥㊦㊧㊨㈲㈹㍾㍽㍼≒≡∫∮Σ√⊥∠∟⊿∩∪", '・');
        assertEquals("・・・・・・・・・・・・・・・・・・・・・・・・・・・・・・・・・・・・・・・・・・・・・・・・・・・・・・・・・・・・・・・・・・・・",result.getReplacedString());
        assertTrue(result.isReplaced());
    }

    @Test
    public void testConvInvalidChar(){
        String beforeStrings[] = {"\u2212" ,"\u301c","\u2016","\u2014","\u00a6" };

        for(String before : beforeStrings){
            assertTrue(!SkjStringUtil.skjChk(before));
            String after  = SkjStringUtil.convInvalidChar(before);
            assertTrue(SkjStringUtil.skjChk(after));

        }
    }
}
