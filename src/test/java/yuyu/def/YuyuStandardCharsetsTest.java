package yuyu.def;

import static org.junit.Assert.*;

import java.io.UnsupportedEncodingException;

import jp.co.slcs.swak.core.test.SWAKTestRunner;

import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(SWAKTestRunner.class)
public class YuyuStandardCharsetsTest {

    @Test
    public void testEucJp() {
        assertEquals(new String("こんにちは".getBytes(YuyuStandardCharsets.EUC_JP),YuyuStandardCharsets.EUC_JP),"こんにちは");
        try{
            assertEquals(new String("こんにちは".getBytes(YuyuStandardCharsets.EUC_JP_STRING),YuyuStandardCharsets.EUC_JP_STRING),"こんにちは");

            assertEquals(new String("こんにちは".getBytes(YuyuStandardCharsets.EUC_JP_STRING),YuyuStandardCharsets.EUC_JP),"こんにちは");
            assertEquals(new String("こんにちは".getBytes(YuyuStandardCharsets.EUC_JP),YuyuStandardCharsets.EUC_JP_STRING),"こんにちは");

            assertEquals(new String("こんにちは".getBytes(YuyuStandardCharsets.EUC_JP_STRING),"EUC_JP"),"こんにちは");
            assertEquals(new String("こんにちは".getBytes("EUC_JP"),YuyuStandardCharsets.EUC_JP_STRING),"こんにちは");

            assertEquals(new String("こんにちは".getBytes(YuyuStandardCharsets.EUC_JP),"EUC_JP"),"こんにちは");
            assertEquals(new String("こんにちは".getBytes("EUC_JP"),YuyuStandardCharsets.EUC_JP),"こんにちは");

        }catch(UnsupportedEncodingException e){
            e.printStackTrace();
        }
    }

    @Test
    public void testIbm500() {
        assertEquals(new String("hello123".getBytes(YuyuStandardCharsets.IBM500),YuyuStandardCharsets.IBM500),"hello123");
        try{
            assertEquals(new String("hello123".getBytes(YuyuStandardCharsets.IBM500_STRING),YuyuStandardCharsets.IBM500_STRING),"hello123");

            assertEquals(new String("hello123".getBytes(YuyuStandardCharsets.IBM500_STRING),YuyuStandardCharsets.IBM500),"hello123");
            assertEquals(new String("hello123".getBytes(YuyuStandardCharsets.IBM500),YuyuStandardCharsets.IBM500_STRING),"hello123");

            assertEquals(new String("hello123".getBytes(YuyuStandardCharsets.IBM500_STRING),"Cp500"),"hello123");
            assertEquals(new String("hello123".getBytes("Cp500"),YuyuStandardCharsets.IBM500_STRING),"hello123");

            assertEquals(new String("hello123".getBytes(YuyuStandardCharsets.IBM500),"Cp500"),"hello123");
            assertEquals(new String("hello123".getBytes("Cp500"),YuyuStandardCharsets.IBM500),"hello123");
        }catch(UnsupportedEncodingException e){
            e.printStackTrace();
        }
    }

    @Test
    public void testIso2022Jp() {
        assertEquals(new String("こんにちは".getBytes(YuyuStandardCharsets.ISO_2022_JP),YuyuStandardCharsets.ISO_2022_JP),"こんにちは");
        try{
            assertEquals(new String("こんにちは".getBytes(YuyuStandardCharsets.ISO_2022_JP_STRING),YuyuStandardCharsets.ISO_2022_JP_STRING),"こんにちは");

            assertEquals(new String("こんにちは".getBytes(YuyuStandardCharsets.ISO_2022_JP_STRING),YuyuStandardCharsets.ISO_2022_JP),"こんにちは");
            assertEquals(new String("こんにちは".getBytes(YuyuStandardCharsets.ISO_2022_JP),YuyuStandardCharsets.ISO_2022_JP_STRING),"こんにちは");

            assertEquals(new String("こんにちは".getBytes(YuyuStandardCharsets.ISO_2022_JP_STRING),"ISO2022JP"),"こんにちは");
            assertEquals(new String("こんにちは".getBytes("ISO2022JP"),YuyuStandardCharsets.ISO_2022_JP_STRING),"こんにちは");

            assertEquals(new String("こんにちは".getBytes(YuyuStandardCharsets.ISO_2022_JP),"ISO2022JP"),"こんにちは");
            assertEquals(new String("こんにちは".getBytes("ISO2022JP"),YuyuStandardCharsets.ISO_2022_JP),"こんにちは");

        }catch(UnsupportedEncodingException e){
            e.printStackTrace();
        }
    }

    @Test
    public void testIso88591() {
        assertEquals(new String("hello123".getBytes(YuyuStandardCharsets.ISO_8859_1),YuyuStandardCharsets.ISO_8859_1),"hello123");
        try{
            assertEquals(new String("hello123".getBytes(YuyuStandardCharsets.ISO_8859_1_STRING),YuyuStandardCharsets.ISO_8859_1_STRING),"hello123");

            assertEquals(new String("hello123".getBytes(YuyuStandardCharsets.ISO_8859_1_STRING),YuyuStandardCharsets.ISO_8859_1),"hello123");
            assertEquals(new String("hello123".getBytes(YuyuStandardCharsets.ISO_8859_1),YuyuStandardCharsets.ISO_8859_1_STRING),"hello123");

            assertEquals(new String("hello123".getBytes(YuyuStandardCharsets.ISO_8859_1_STRING),"ISO8859_1"),"hello123");
            assertEquals(new String("hello123".getBytes("ISO8859_1"),YuyuStandardCharsets.ISO_8859_1_STRING),"hello123");

            assertEquals(new String("hello123".getBytes(YuyuStandardCharsets.ISO_8859_1),"ISO8859_1"),"hello123");
            assertEquals(new String("hello123".getBytes("ISO8859_1"),YuyuStandardCharsets.ISO_8859_1),"hello123");

        }catch(UnsupportedEncodingException e){
            e.printStackTrace();
        }
    }

    @Test
    public void testShiftJis() {
        assertEquals(new String("こんにちは".getBytes(YuyuStandardCharsets.SHIFT_JIS),YuyuStandardCharsets.SHIFT_JIS),"こんにちは");
        try{
            assertEquals(new String("こんにちは".getBytes(YuyuStandardCharsets.SHIFT_JIS_STRING),YuyuStandardCharsets.SHIFT_JIS_STRING),"こんにちは");

            assertEquals(new String("こんにちは".getBytes(YuyuStandardCharsets.SHIFT_JIS_STRING),YuyuStandardCharsets.SHIFT_JIS),"こんにちは");
            assertEquals(new String("こんにちは".getBytes(YuyuStandardCharsets.SHIFT_JIS),YuyuStandardCharsets.SHIFT_JIS_STRING),"こんにちは");

            assertEquals(new String("こんにちは".getBytes(YuyuStandardCharsets.SHIFT_JIS_STRING),"SJIS"),"こんにちは");
            assertEquals(new String("こんにちは".getBytes("SJIS"),YuyuStandardCharsets.SHIFT_JIS_STRING),"こんにちは");

            assertEquals(new String("こんにちは".getBytes(YuyuStandardCharsets.SHIFT_JIS),"SJIS"),"こんにちは");
            assertEquals(new String("こんにちは".getBytes("SJIS"),YuyuStandardCharsets.SHIFT_JIS),"こんにちは");
        }catch(UnsupportedEncodingException e){
            e.printStackTrace();
        }
    }

    @Test
    public void testUsAscii() {
        assertEquals(new String("hello123".getBytes(YuyuStandardCharsets.US_ASCII),YuyuStandardCharsets.US_ASCII),"hello123");
        try{
            assertEquals(new String("hello123".getBytes(YuyuStandardCharsets.US_ASCII_STRING),YuyuStandardCharsets.US_ASCII_STRING),"hello123");

            assertEquals(new String("hello123".getBytes(YuyuStandardCharsets.US_ASCII_STRING),YuyuStandardCharsets.US_ASCII),"hello123");
            assertEquals(new String("hello123".getBytes(YuyuStandardCharsets.US_ASCII),YuyuStandardCharsets.US_ASCII_STRING),"hello123");

            assertEquals(new String("hello123".getBytes(YuyuStandardCharsets.US_ASCII_STRING),"ASCII"),"hello123");
            assertEquals(new String("hello123".getBytes("ASCII"),YuyuStandardCharsets.US_ASCII_STRING),"hello123");

            assertEquals(new String("hello123".getBytes(YuyuStandardCharsets.US_ASCII),"ASCII"),"hello123");
            assertEquals(new String("hello123".getBytes("ASCII"),YuyuStandardCharsets.US_ASCII),"hello123");

        }catch(UnsupportedEncodingException e){
            e.printStackTrace();
        }
    }

    @Test
    public void testUtf16() {
        assertEquals(new String("こんにちは".getBytes(YuyuStandardCharsets.UTF_16),YuyuStandardCharsets.UTF_16),"こんにちは");
        try{
            assertEquals(new String("こんにちは".getBytes(YuyuStandardCharsets.UTF_16_STRING),YuyuStandardCharsets.UTF_16_STRING),"こんにちは");

            assertEquals(new String("こんにちは".getBytes(YuyuStandardCharsets.UTF_16_STRING),YuyuStandardCharsets.UTF_16),"こんにちは");
            assertEquals(new String("こんにちは".getBytes(YuyuStandardCharsets.UTF_16),YuyuStandardCharsets.UTF_16_STRING),"こんにちは");

            assertEquals(new String("こんにちは".getBytes(YuyuStandardCharsets.UTF_16_STRING),"UTF-16"),"こんにちは");
            assertEquals(new String("こんにちは".getBytes("UTF-16"),YuyuStandardCharsets.UTF_16_STRING),"こんにちは");

            assertEquals(new String("こんにちは".getBytes(YuyuStandardCharsets.UTF_16),"UTF-16"),"こんにちは");
            assertEquals(new String("こんにちは".getBytes("UTF-16"),YuyuStandardCharsets.UTF_16),"こんにちは");
        }catch(UnsupportedEncodingException e){
            e.printStackTrace();
        }
    }

    @Test
    public void testUtf16Be() {
        assertEquals(new String("こんにちは".getBytes(YuyuStandardCharsets.UTF_16BE),YuyuStandardCharsets.UTF_16BE),"こんにちは");
        try{
            assertEquals(new String("こんにちは".getBytes(YuyuStandardCharsets.UTF_16BE_STRING),YuyuStandardCharsets.UTF_16BE_STRING),"こんにちは");

            assertEquals(new String("こんにちは".getBytes(YuyuStandardCharsets.UTF_16BE_STRING),YuyuStandardCharsets.UTF_16BE),"こんにちは");
            assertEquals(new String("こんにちは".getBytes(YuyuStandardCharsets.UTF_16BE),YuyuStandardCharsets.UTF_16BE_STRING),"こんにちは");

            assertEquals(new String("こんにちは".getBytes(YuyuStandardCharsets.UTF_16BE_STRING),"UnicodeBigUnmarked"),"こんにちは");
            assertEquals(new String("こんにちは".getBytes("UnicodeBigUnmarked"),YuyuStandardCharsets.UTF_16BE_STRING),"こんにちは");

            assertEquals(new String("こんにちは".getBytes(YuyuStandardCharsets.UTF_16BE),"UnicodeBigUnmarked"),"こんにちは");
            assertEquals(new String("こんにちは".getBytes("UnicodeBigUnmarked"),YuyuStandardCharsets.UTF_16BE),"こんにちは");

        }catch(UnsupportedEncodingException e){
            e.printStackTrace();
        }
    }

    @Test
    public void testUtf16Le() {
        assertEquals(new String("こんにちは".getBytes(YuyuStandardCharsets.UTF_16LE),YuyuStandardCharsets.UTF_16LE),"こんにちは");
        try{
            assertEquals(new String("こんにちは".getBytes(YuyuStandardCharsets.UTF_16LE_STRING),YuyuStandardCharsets.UTF_16LE_STRING),"こんにちは");

            assertEquals(new String("こんにちは".getBytes(YuyuStandardCharsets.UTF_16LE_STRING),YuyuStandardCharsets.UTF_16LE),"こんにちは");
            assertEquals(new String("こんにちは".getBytes(YuyuStandardCharsets.UTF_16LE),YuyuStandardCharsets.UTF_16LE_STRING),"こんにちは");

            assertEquals(new String("こんにちは".getBytes(YuyuStandardCharsets.UTF_16LE_STRING),"UnicodeLittleUnmarked"),"こんにちは");
            assertEquals(new String("こんにちは".getBytes("UnicodeLittleUnmarked"),YuyuStandardCharsets.UTF_16LE_STRING),"こんにちは");

            assertEquals(new String("こんにちは".getBytes(YuyuStandardCharsets.UTF_16LE),"UnicodeLittleUnmarked"),"こんにちは");
            assertEquals(new String("こんにちは".getBytes("UnicodeLittleUnmarked"),YuyuStandardCharsets.UTF_16LE),"こんにちは");

        }catch(UnsupportedEncodingException e){
            e.printStackTrace();
        }
    }

    @Test
    public void testUtf8() {
        assertEquals(new String("こんにちは".getBytes(YuyuStandardCharsets.UTF_8),YuyuStandardCharsets.UTF_8),"こんにちは");
        try{
            assertEquals(new String("こんにちは".getBytes(YuyuStandardCharsets.UTF_8_STRING),YuyuStandardCharsets.UTF_8_STRING),"こんにちは");

            assertEquals(new String("こんにちは".getBytes(YuyuStandardCharsets.UTF_8_STRING),YuyuStandardCharsets.UTF_8),"こんにちは");
            assertEquals(new String("こんにちは".getBytes(YuyuStandardCharsets.UTF_8),YuyuStandardCharsets.UTF_8_STRING),"こんにちは");

            assertEquals(new String("こんにちは".getBytes(YuyuStandardCharsets.UTF_8_STRING),"UTF8"),"こんにちは");
            assertEquals(new String("こんにちは".getBytes("UTF8"),YuyuStandardCharsets.UTF_8_STRING),"こんにちは");

            assertEquals(new String("こんにちは".getBytes(YuyuStandardCharsets.UTF_8),"UTF8"),"こんにちは");
            assertEquals(new String("こんにちは".getBytes("UTF8"),YuyuStandardCharsets.UTF_8),"こんにちは");

        }catch(UnsupportedEncodingException e){
            e.printStackTrace();
        }
    }

    @Test
    public void testWindows31J() {
        assertEquals(new String("こんにちは".getBytes(YuyuStandardCharsets.WINDOWS_31J),YuyuStandardCharsets.WINDOWS_31J),"こんにちは");
        try{
            assertEquals(new String("こんにちは".getBytes(YuyuStandardCharsets.WINDOWS_31J_STRING),YuyuStandardCharsets.WINDOWS_31J_STRING),"こんにちは");

            assertEquals(new String("こんにちは".getBytes(YuyuStandardCharsets.WINDOWS_31J_STRING),YuyuStandardCharsets.WINDOWS_31J),"こんにちは");
            assertEquals(new String("こんにちは".getBytes(YuyuStandardCharsets.WINDOWS_31J),YuyuStandardCharsets.WINDOWS_31J_STRING),"こんにちは");

            assertEquals(new String("こんにちは".getBytes(YuyuStandardCharsets.WINDOWS_31J_STRING),"MS932"),"こんにちは");
            assertEquals(new String("こんにちは".getBytes("MS932"),YuyuStandardCharsets.WINDOWS_31J_STRING),"こんにちは");

            assertEquals(new String("こんにちは".getBytes(YuyuStandardCharsets.WINDOWS_31J),"MS932"),"こんにちは");
            assertEquals(new String("こんにちは".getBytes("MS932"),YuyuStandardCharsets.WINDOWS_31J),"こんにちは");

        }catch(UnsupportedEncodingException e){
            e.printStackTrace();
        }
    }

    @Test
    public void testXIbm930() {
        assertEquals(new String("こんにちは".getBytes(YuyuStandardCharsets.X_IBM930),YuyuStandardCharsets.X_IBM930),"こんにちは");
        try{
            assertEquals(new String("こんにちは".getBytes(YuyuStandardCharsets.X_IBM930_STRING),YuyuStandardCharsets.X_IBM930_STRING),"こんにちは");

            assertEquals(new String("こんにちは".getBytes(YuyuStandardCharsets.X_IBM930_STRING),YuyuStandardCharsets.X_IBM930),"こんにちは");
            assertEquals(new String("こんにちは".getBytes(YuyuStandardCharsets.X_IBM930),YuyuStandardCharsets.X_IBM930_STRING),"こんにちは");

            assertEquals(new String("こんにちは".getBytes(YuyuStandardCharsets.X_IBM930_STRING),"Cp930"),"こんにちは");
            assertEquals(new String("こんにちは".getBytes("Cp930"),YuyuStandardCharsets.X_IBM930_STRING),"こんにちは");

            assertEquals(new String("こんにちは".getBytes(YuyuStandardCharsets.X_IBM930),"Cp930"),"こんにちは");
            assertEquals(new String("こんにちは".getBytes("Cp930"),YuyuStandardCharsets.X_IBM930),"こんにちは");

        }catch(UnsupportedEncodingException e){
            e.printStackTrace();
        }
    }

    @Test
    public void testIsCharset(){
        assertEquals(YuyuStandardCharsets.isCharset("ー、。｛",YuyuStandardCharsets.SHIFT_JIS),true);

        assertEquals(YuyuStandardCharsets.isCharset("ａＡ１２３",YuyuStandardCharsets.SHIFT_JIS),true);

        assertEquals(YuyuStandardCharsets.isCharset("あア亜",YuyuStandardCharsets.SHIFT_JIS),true);

        assertEquals(YuyuStandardCharsets.isCharset("丐丕个",YuyuStandardCharsets.SHIFT_JIS),true);

        assertEquals(YuyuStandardCharsets.isCharset("纊褜鍈",YuyuStandardCharsets.SHIFT_JIS),false);

        assertEquals(YuyuStandardCharsets.isCharset("ⅰ㈱№",YuyuStandardCharsets.SHIFT_JIS),false);

        assertEquals(YuyuStandardCharsets.isCharset("俱𠀋㐂",YuyuStandardCharsets.SHIFT_JIS),false);

        assertEquals(YuyuStandardCharsets.isCharset("𠂉丂丏",YuyuStandardCharsets.SHIFT_JIS),false);

        assertEquals(YuyuStandardCharsets.isCharset("ｱaA1{->",YuyuStandardCharsets.SHIFT_JIS),true);

        assertEquals(YuyuStandardCharsets.isCharset("®¯³¸¹»¼½¿À",YuyuStandardCharsets.SHIFT_JIS),false);


        assertEquals(YuyuStandardCharsets.isCharset("ー、。｛",YuyuStandardCharsets.UTF_8),true);

        assertEquals(YuyuStandardCharsets.isCharset("ａＡ１２３",YuyuStandardCharsets.UTF_8),true);

        assertEquals(YuyuStandardCharsets.isCharset("あア亜",YuyuStandardCharsets.UTF_8),true);

        assertEquals(YuyuStandardCharsets.isCharset("丐丕个",YuyuStandardCharsets.UTF_8),true);

        assertEquals(YuyuStandardCharsets.isCharset("纊褜鍈",YuyuStandardCharsets.UTF_8),true);

        assertEquals(YuyuStandardCharsets.isCharset("ⅰ㈱№",YuyuStandardCharsets.UTF_8),true);

        assertEquals(YuyuStandardCharsets.isCharset("俱𠀋㐂",YuyuStandardCharsets.UTF_8),true);

        assertEquals(YuyuStandardCharsets.isCharset("𠂉丂丏",YuyuStandardCharsets.UTF_8),true);

        assertEquals(YuyuStandardCharsets.isCharset("ｱaA1{->",YuyuStandardCharsets.UTF_8),true);

        assertEquals(YuyuStandardCharsets.isCharset("®¯³¸¹»¼½¿À",YuyuStandardCharsets.UTF_8),true);

    }

}
