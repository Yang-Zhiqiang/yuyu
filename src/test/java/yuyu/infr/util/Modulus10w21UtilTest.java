package yuyu.infr.util;

import static org.junit.Assert.*;
import jp.co.slcs.swak.core.test.SWAKTestRunner;

import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(SWAKTestRunner.class)
public class Modulus10w21UtilTest {

    @Test
    public void testChkDegit1(){
        String chkDigit = Modulus10w21Util.getStringCheckDigitModulus10w21("20151119");
        assertEquals("3",chkDigit);
    }

    @Test
    public void testChkDegit2(){
        String chkDigit = Modulus10w21Util.getStringCheckDigitModulus10w21("1");
        assertEquals("8",chkDigit);
    }

    @Test
    public void testChkDegit3(){
        String chkDigit = Modulus10w21Util.getStringCheckDigitModulus10w21("5");
        assertEquals("9",chkDigit);
    }

    @Test
    public void testChkDegit4(){
        String chkDigit = Modulus10w21Util.getStringCheckDigitModulus10w21("81");
        assertEquals("0",chkDigit);
    }

    @Test
    public void testChkDegit5(){
        String chkDigit = Modulus10w21Util.getStringCheckDigitModulus10w21("0");
        assertEquals("0",chkDigit);
    }

    @Test
    public void testChkDegit6(){
        String chkDigit = Modulus10w21Util.getStringCheckDigitModulus10w21("00000000000000000");
        assertEquals("0",chkDigit);
    }

    @Test
    public void testChkDegit7(){
        String chkDigit = Modulus10w21Util.getStringCheckDigitModulus10w21("1000000000000000");
        assertEquals("9",chkDigit);
    }

    @Test
    public void testChkDegit8(){
        String chkDigit = Modulus10w21Util.getStringCheckDigitModulus10w21("00000000000000001");
        assertEquals("8",chkDigit);
    }

    @Test
    public void testChkDegit9(){
        String chkDigit = Modulus10w21Util.getStringCheckDigitModulus10w21("");
        assertEquals("0",chkDigit);
    }

    @Test(expected = RuntimeException.class)
    public void testChkDegit10(){
        Modulus10w21Util.getStringCheckDigitModulus10w21("a");
    }

    @Test(expected = RuntimeException.class)
    public void testChkDegit11(){
        Modulus10w21Util.getStringCheckDigitModulus10w21("1a11");
    }

    @Test(expected = RuntimeException.class)
    public void testChkDegit12(){
        Modulus10w21Util.getStringCheckDigitModulus10w21("+");
    }

    @Test(expected = RuntimeException.class)
    public void testChkDegit13(){
        Modulus10w21Util.getStringCheckDigitModulus10w21("あ");
    }

    @Test(expected = RuntimeException.class)
    public void testChkDegit14(){
        Modulus10w21Util.getStringCheckDigitModulus10w21("ア");
    }

    @Test(expected = RuntimeException.class)
    public void testChkDegit15(){
        Modulus10w21Util.getStringCheckDigitModulus10w21("亜");
    }

    @Test
    public void testChkDegit16(){
        String chkDigit = Modulus10w21Util.getStringCheckDigitModulus10w21(null);
        assertEquals(null,chkDigit);
    }

    @Test
    public void testChkModulus1_1(){
        boolean chk = Modulus10w21Util.chkModulus10w21("201511193");
        assertTrue(chk);
    }

    @Test
    public void testChkModulus1_2(){
        boolean chk = Modulus10w21Util.chkModulus10w21("201511190");
        assertTrue(!chk);
    }

    @Test
    public void testChkModulus1_3(){
        boolean chk = Modulus10w21Util.chkModulus10w21("２０１５１１１９３");
        assertTrue(!chk);
    }

    @Test
    public void testChkModulus2(){
        boolean chk = Modulus10w21Util.chkModulus10w21("18");
        assertTrue(chk);
    }

    @Test
    public void testChkModulus3(){
        boolean chk = Modulus10w21Util.chkModulus10w21("59");
        assertTrue(chk);
    }

    @Test
    public void testChkModulus4(){
        boolean chk = Modulus10w21Util.chkModulus10w21("810");
        assertTrue(chk);
    }

    @Test
    public void testChkModulus5(){
        boolean chk = Modulus10w21Util.chkModulus10w21("0");
        assertTrue(!chk);
    }

    @Test
    public void testChkModulus6(){
        boolean chk = Modulus10w21Util.chkModulus10w21("00000000000000000");
        assertTrue(!chk);
    }

    @Test
    public void testChkModulus7(){
        boolean chk = Modulus10w21Util.chkModulus10w21("10000000000000009");
        assertTrue(chk);
    }

    @Test
    public void testChkModulus8(){
        boolean chk = Modulus10w21Util.chkModulus10w21("000000000000000018");
        assertTrue(chk);
    }

    @Test
    public void testChkModulus9(){
        boolean chk = Modulus10w21Util.chkModulus10w21("");
        assertTrue(chk);
    }

    @Test
    public void testChkModulus9_2(){
        boolean chk = Modulus10w21Util.chkModulus10w21("1");
        assertTrue(chk);
    }

    @Test
    public void testChkModulus10(){
        boolean chk = Modulus10w21Util.chkModulus10w21("a");
        assertTrue(!chk);
    }

    @Test
    public void testChkModulus11(){
        boolean chk = Modulus10w21Util.chkModulus10w21("1a11");
        assertTrue(!chk);
    }

    @Test
    public void testChkModulus12(){
        boolean chk = Modulus10w21Util.chkModulus10w21("+");
        assertTrue(!chk);
    }

    @Test
    public void testChkModulus13(){
        boolean chk = Modulus10w21Util.chkModulus10w21("あ");
        assertTrue(!chk);
    }

    @Test
    public void testChkModulus14(){
        boolean chk = Modulus10w21Util.chkModulus10w21("ア");
        assertTrue(!chk);
    }

    @Test
    public void testChkModulus15(){
        boolean chk = Modulus10w21Util.chkModulus10w21("亜");
        assertTrue(!chk);
    }

    @Test
    public void testChkModulus16(){
        boolean chk = Modulus10w21Util.chkModulus10w21(null);
        assertTrue(chk);
    }

}
