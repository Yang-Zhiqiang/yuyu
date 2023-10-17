package yuyu.infr.conversion;

import static org.junit.Assert.*;

import javax.inject.Inject;

import jp.co.slcs.swak.conversion.accessor.BeanAccessException;
import jp.co.slcs.swak.conversion.accessor.BeanAccessor;
import jp.co.slcs.swak.core.test.SWAKTestRunner;
import jp.co.slcs.swak.util.message.MessageUtil;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;

/**
 * Conversion のテストです。
 */
@RunWith(SWAKTestRunner.class)
public class Tester {

    @Inject
    private Bean bean;

    @Inject
    private BeanAccessor beanAccessor;

    @SuppressWarnings("unused")
    @Inject
    private static Logger logger;

    //    @Test
    //    public void testDate() {
    //
    //        try {
    //            beanAccessor.setProperty(bean, "date", "20150101");
    //            assertEquals(1,1);
    //        } catch (BeanAccessException e) {
    //            assertEquals(1,0);
    //        }
    //
    //        try {
    //            beanAccessor.setProperty(bean, "date", "-10101");
    //            assertEquals(1,0);
    //        } catch (BeanAccessException e) {
    //            assertEquals("item-id は日付（年月日）として適切な値で入力してください。",
    //                MessageUtil.getMessage(e.getConversionErrors().iterator().next().getMessages().get(0).getMessage().substring(1,8)));
    //            assertEquals(1,1);
    //        }
    //
    //        try {
    //            beanAccessor.setProperty(bean, "date", "10101");
    //            assertEquals(1,1);
    //        } catch (BeanAccessException e) {
    //            assertEquals(1,0);
    //        }
    //
    //        try {
    //            beanAccessor.setProperty(bean, "date", "10101.1");
    //            assertEquals(1,0);
    //        } catch (BeanAccessException e) {
    //            assertEquals(1,1);
    //        }
    //
    //        try {
    //            beanAccessor.setProperty(bean, "date", "99990101");
    //            assertEquals(1,1);
    //        } catch (BeanAccessException e) {
    //            assertEquals(1,0);
    //        }
    //
    //        try {
    //            beanAccessor.setProperty(bean, "date", "100000101");
    //            assertEquals(1,0);
    //        } catch (BeanAccessException e) {
    //            assertEquals(1,1);
    //        }
    //
    //        try {
    //            beanAccessor.setProperty(bean, "date", "=");
    //            assertEquals(1,0);
    //        } catch (BeanAccessException e) {
    //            assertEquals(1,1);
    //        }
    //
    //        try {
    //            beanAccessor.setProperty(bean, "date", "a");
    //            assertEquals(1,0);
    //        } catch (BeanAccessException e) {
    //            assertEquals(1,1);
    //        }
    //
    //        try {
    //            beanAccessor.setProperty(bean, "date", "ａ");
    //            assertEquals(1,0);
    //        } catch (BeanAccessException e) {
    //            assertEquals(1,1);
    //        }
    //
    //        try {
    //            beanAccessor.setProperty(bean, "date", "あ");
    //            assertEquals(1,0);
    //        } catch (BeanAccessException e) {
    //            assertEquals(1,1);
    //        }
    //
    //        try {
    //            beanAccessor.setProperty(bean, "date", "ｱ");
    //            assertEquals(1,0);
    //        } catch (BeanAccessException e) {
    //            assertEquals(1,1);
    //        }
    //
    //        try {
    //            beanAccessor.setProperty(bean, "date", "ア");
    //            assertEquals(1,0);
    //        } catch (BeanAccessException e) {
    //            assertEquals(1,1);
    //        }
    //
    //        try {
    //            beanAccessor.setProperty(bean, "date", "亜");
    //            assertEquals(1,0);
    //        } catch (BeanAccessException e) {
    //            assertEquals(1,1);
    //        }
    //    }

    @Test
    public void testBizDate() {

        try {
            beanAccessor.setProperty(bean, "bizDate", "20150101");
            assertEquals(1,1);
        } catch (BeanAccessException e) {
            assertEquals(1,0);
        }

        try {
            beanAccessor.setProperty(bean, "bizDate", "-10101");
            assertEquals(1,0);
        } catch (BeanAccessException e) {
            assertEquals("item-id は日付（年月日）として適切な値で入力してください。",
                MessageUtil.getMessage(e.getConversionErrors().iterator().next().getMessages().get(0).getMessage().substring(1,8)));
            assertEquals(1,1);
        }

        try {
            beanAccessor.setProperty(bean, "bizDate", "10101");
            assertEquals(1,1);
        } catch (BeanAccessException e) {
            assertEquals(1,0);
        }

        try {
            beanAccessor.setProperty(bean, "bizDate", "10101.1");
            assertEquals(1,0);
        } catch (BeanAccessException e) {
            assertEquals(1,1);
        }

        try {
            beanAccessor.setProperty(bean, "bizDate", "99990101");
            assertEquals(1,1);
        } catch (BeanAccessException e) {
            assertEquals(1,0);
        }

        try {
            beanAccessor.setProperty(bean, "bizDate", "100000101");
            assertEquals(1,0);
        } catch (BeanAccessException e) {
            assertEquals(1,1);
        }

        try {
            beanAccessor.setProperty(bean, "bizDate", "=");
            assertEquals(1,0);
        } catch (BeanAccessException e) {
            assertEquals(1,1);
        }

        try {
            beanAccessor.setProperty(bean, "bizDate", "a");
            assertEquals(1,0);
        } catch (BeanAccessException e) {
            assertEquals(1,1);
        }

        try {
            beanAccessor.setProperty(bean, "bizDate", "ａ");
            assertEquals(1,0);
        } catch (BeanAccessException e) {
            assertEquals(1,1);
        }

        try {
            beanAccessor.setProperty(bean, "bizDate", "あ");
            assertEquals(1,0);
        } catch (BeanAccessException e) {
            assertEquals(1,1);
        }

        try {
            beanAccessor.setProperty(bean, "bizDate", "ｱ");
            assertEquals(1,0);
        } catch (BeanAccessException e) {
            assertEquals(1,1);
        }

        try {
            beanAccessor.setProperty(bean, "bizDate", "ア");
            assertEquals(1,0);
        } catch (BeanAccessException e) {
            assertEquals(1,1);
        }

        try {
            beanAccessor.setProperty(bean, "bizDate", "亜");
            assertEquals(1,0);
        } catch (BeanAccessException e) {
            assertEquals(1,1);
        }
    }

    @Test
    public void testBizDateY() {

        try {
            beanAccessor.setProperty(bean, "bizDateY", "2015");
            assertEquals(1,1);
        } catch (BeanAccessException e) {
            assertEquals(1,0);
        }

        try {
            beanAccessor.setProperty(bean, "bizDateY", "-1");
            assertEquals(1,0);
        } catch (BeanAccessException e) {
            assertEquals("item-id は日付（年）として適切な値で入力してください。",
                MessageUtil.getMessage(e.getConversionErrors().iterator().next().getMessages().get(0).getMessage().substring(1,8)));
            assertEquals(1,1);
        }

        try {
            beanAccessor.setProperty(bean, "bizDateY", "1");
            assertEquals(1,1);
        } catch (BeanAccessException e) {
            assertEquals(1,0);
        }

        //        try {
        //            beanAccessor.setProperty(bean, "bizDateY", "1.0");
        //            assertEquals(1,0);
        //        } catch (BeanAccessException e) {
        //            assertEquals(1,1);
        //        }

        try {
            beanAccessor.setProperty(bean, "bizDateY", "9999");
            assertEquals(1,1);
        } catch (BeanAccessException e) {
            assertEquals(1,0);
        }

        try {
            beanAccessor.setProperty(bean, "bizDateY", "10000");
            assertEquals(1,0);
        } catch (BeanAccessException e) {
            assertEquals(1,1);
        }

        try {
            beanAccessor.setProperty(bean, "bizDateY", "=");
            assertEquals(1,0);
        } catch (BeanAccessException e) {
            assertEquals(1,1);
        }

        try {
            beanAccessor.setProperty(bean, "bizDateY", "a");
            assertEquals(1,0);
        } catch (BeanAccessException e) {
            assertEquals(1,1);
        }

        try {
            beanAccessor.setProperty(bean, "bizDateY", "ａ");
            assertEquals(1,0);
        } catch (BeanAccessException e) {
            assertEquals(1,1);
        }

        try {
            beanAccessor.setProperty(bean, "bizDateY", "あ");
            assertEquals(1,0);
        } catch (BeanAccessException e) {
            assertEquals(1,1);
        }

        try {
            beanAccessor.setProperty(bean, "bizDateY", "ｱ");
            assertEquals(1,0);
        } catch (BeanAccessException e) {
            assertEquals(1,1);
        }

        try {
            beanAccessor.setProperty(bean, "bizDateY", "ア");
            assertEquals(1,0);
        } catch (BeanAccessException e) {
            assertEquals(1,1);
        }

        try {
            beanAccessor.setProperty(bean, "bizDateY", "亜");
            assertEquals(1,0);
        } catch (BeanAccessException e) {
            assertEquals(1,1);
        }
    }

    @Test
    public void testBizDateYM() {

        try {
            beanAccessor.setProperty(bean, "bizDateYM", "201501");
            assertEquals(1,1);
        } catch (BeanAccessException e) {
            assertEquals(1,0);
        }

        try {
            beanAccessor.setProperty(bean, "bizDateYM", "-101");
            assertEquals(1,0);
        } catch (BeanAccessException e) {
            assertEquals("item-id は日付（年月）として適切な値で入力してください。",
                MessageUtil.getMessage(e.getConversionErrors().iterator().next().getMessages().get(0).getMessage().substring(1,8)));
            assertEquals(1,1);
        }

        try {
            beanAccessor.setProperty(bean, "bizDateYM", "101");
            assertEquals(1,1);
        } catch (BeanAccessException e) {
            assertEquals(1,0);
        }

        try {
            beanAccessor.setProperty(bean, "bizDateYM", "101.0");
            assertEquals(1,0);
        } catch (BeanAccessException e) {
            assertEquals(1,1);
        }

        try {
            beanAccessor.setProperty(bean, "bizDateYM", "999901");
            assertEquals(1,1);
        } catch (BeanAccessException e) {
            assertEquals(1,0);
        }

        try {
            beanAccessor.setProperty(bean, "bizDateYM", "1000001");
            assertEquals(1,0);
        } catch (BeanAccessException e) {
            assertEquals(1,1);
        }

        try {
            beanAccessor.setProperty(bean, "bizDateYM", "=");
            assertEquals(1,0);
        } catch (BeanAccessException e) {
            assertEquals(1,1);
        }

        try {
            beanAccessor.setProperty(bean, "bizDateYM", "a");
            assertEquals(1,0);
        } catch (BeanAccessException e) {
            assertEquals(1,1);
        }

        try {
            beanAccessor.setProperty(bean, "bizDateYM", "ａ");
            assertEquals(1,0);
        } catch (BeanAccessException e) {
            assertEquals(1,1);
        }

        try {
            beanAccessor.setProperty(bean, "bizDateYM", "あ");
            assertEquals(1,0);
        } catch (BeanAccessException e) {
            assertEquals(1,1);
        }

        try {
            beanAccessor.setProperty(bean, "bizDateYM", "ｱ");
            assertEquals(1,0);
        } catch (BeanAccessException e) {
            assertEquals(1,1);
        }

        try {
            beanAccessor.setProperty(bean, "bizDateYM", "ア");
            assertEquals(1,0);
        } catch (BeanAccessException e) {
            assertEquals(1,1);
        }

        try {
            beanAccessor.setProperty(bean, "bizDateYM", "亜");
            assertEquals(1,0);
        } catch (BeanAccessException e) {
            assertEquals(1,1);
        }
    }

    @Test
    public void testBizDateMD() {

        try {
            beanAccessor.setProperty(bean, "bizDateMD", "-0101");
            assertEquals(1,0);
        } catch (BeanAccessException e) {
            assertEquals("item-id は日付（月日）として適切な値で入力してください。",
                MessageUtil.getMessage(e.getConversionErrors().iterator().next().getMessages().get(0).getMessage().substring(1,8)));
            assertEquals(1,1);
        }

        try {
            beanAccessor.setProperty(bean, "bizDateMD", "0101");
            assertEquals(1,1);
        } catch (BeanAccessException e) {
            assertEquals(1,0);
        }

        try {
            beanAccessor.setProperty(bean, "bizDateMD", "0101.0");
            assertEquals(1,0);
        } catch (BeanAccessException e) {
            assertEquals(1,1);
        }

        try {
            beanAccessor.setProperty(bean, "bizDateMD", "1231");
            assertEquals(1,1);
        } catch (BeanAccessException e) {
            assertEquals(1,0);
        }

        try {
            beanAccessor.setProperty(bean, "bizDateMD", "10000");
            assertEquals(1,0);
        } catch (BeanAccessException e) {
            assertEquals(1,1);
        }

        try {
            beanAccessor.setProperty(bean, "bizDateMD", "=");
            assertEquals(1,0);
        } catch (BeanAccessException e) {
            assertEquals(1,1);
        }

        try {
            beanAccessor.setProperty(bean, "bizDateMD", "a");
            assertEquals(1,0);
        } catch (BeanAccessException e) {
            assertEquals(1,1);
        }

        try {
            beanAccessor.setProperty(bean, "bizDateMD", "ａ");
            assertEquals(1,0);
        } catch (BeanAccessException e) {
            assertEquals(1,1);
        }

        try {
            beanAccessor.setProperty(bean, "bizDateMD", "あ");
            assertEquals(1,0);
        } catch (BeanAccessException e) {
            assertEquals(1,1);
        }

        try {
            beanAccessor.setProperty(bean, "bizDateMD", "ｱ");
            assertEquals(1,0);
        } catch (BeanAccessException e) {
            assertEquals(1,1);
        }

        try {
            beanAccessor.setProperty(bean, "bizDateMD", "ア");
            assertEquals(1,0);
        } catch (BeanAccessException e) {
            assertEquals(1,1);
        }

        try {
            beanAccessor.setProperty(bean, "bizDateMD", "亜");
            assertEquals(1,0);
        } catch (BeanAccessException e) {
            assertEquals(1,1);
        }
    }

    @Test
    public void testInteger() {
        try {
            beanAccessor.setProperty(bean, "integer", "100");
            assertEquals(1,1);
        } catch (BeanAccessException e) {
            assertEquals(1,0);
        }

        try {
            beanAccessor.setProperty(bean, "integer", "100.0");
            assertEquals(1,0);
        } catch (BeanAccessException e) {
            assertEquals("item-id は数字のみで入力してください。",
                MessageUtil.getMessage(e.getConversionErrors().iterator().next().getMessages().get(0).getMessage().substring(1,8)));
            assertEquals(1,1);
        }

        try {
            beanAccessor.setProperty(bean, "integer", "-100");
            assertEquals(1,1);
        } catch (BeanAccessException e) {
            assertEquals(1,0);
        }

        try {
            beanAccessor.setProperty(bean, "integer", "-100.0");
            assertEquals(1,0);
        } catch (BeanAccessException e) {
            assertEquals(1,1);
        }

        try {
            beanAccessor.setProperty(bean, "integer", "=");
            assertEquals(1,0);
        } catch (BeanAccessException e) {
            assertEquals(1,1);
        }

        try {
            beanAccessor.setProperty(bean, "integer", "a");
            assertEquals(1,0);
        } catch (BeanAccessException e) {
            assertEquals(1,1);
        }

        try {
            beanAccessor.setProperty(bean, "integer", "ａ");
            assertEquals(1,0);
        } catch (BeanAccessException e) {
            assertEquals(1,1);
        }

        try {
            beanAccessor.setProperty(bean, "integer", "あ");
            assertEquals(1,0);
        } catch (BeanAccessException e) {
            assertEquals(1,1);
        }

        try {
            beanAccessor.setProperty(bean, "integer", "ｱ");
            assertEquals(1,0);
        } catch (BeanAccessException e) {
            assertEquals(1,1);
        }

        try {
            beanAccessor.setProperty(bean, "integer", "ア");
            assertEquals(1,0);
        } catch (BeanAccessException e) {
            assertEquals(1,1);
        }

        try {
            beanAccessor.setProperty(bean, "integer", "亜");
            assertEquals(1,0);
        } catch (BeanAccessException e) {
            assertEquals(1,1);
        }
    }

    @Test
    public void testShort() {
        try {
            beanAccessor.setProperty(bean, "argShort", "100");
            assertEquals(1,1);
        } catch (BeanAccessException e) {
            assertEquals(1,0);
        }

        try {
            beanAccessor.setProperty(bean, "argShort", "100.0");
            assertEquals(1,0);
        } catch (BeanAccessException e) {
            assertEquals("item-id は数字のみで入力してください。",
                MessageUtil.getMessage(e.getConversionErrors().iterator().next().getMessages().get(0).getMessage().substring(1,8)));
            assertEquals(1,1);
        }

        try {
            beanAccessor.setProperty(bean, "argShort", "-100");
            assertEquals(1,1);
        } catch (BeanAccessException e) {
            assertEquals(1,0);
        }

        try {
            beanAccessor.setProperty(bean, "argShort", "-100.0");
            assertEquals(1,0);
        } catch (BeanAccessException e) {
            assertEquals(1,1);
        }

        try {
            beanAccessor.setProperty(bean, "argShort", "=");
            assertEquals(1,0);
        } catch (BeanAccessException e) {
            assertEquals(1,1);
        }

        try {
            beanAccessor.setProperty(bean, "argShort", "a");
            assertEquals(1,0);
        } catch (BeanAccessException e) {
            assertEquals(1,1);
        }

        try {
            beanAccessor.setProperty(bean, "argShort", "ａ");
            assertEquals(1,0);
        } catch (BeanAccessException e) {
            assertEquals(1,1);
        }

        try {
            beanAccessor.setProperty(bean, "argShort", "あ");
            assertEquals(1,0);
        } catch (BeanAccessException e) {
            assertEquals(1,1);
        }

        try {
            beanAccessor.setProperty(bean, "argShort", "ｱ");
            assertEquals(1,0);
        } catch (BeanAccessException e) {
            assertEquals(1,1);
        }

        try {
            beanAccessor.setProperty(bean, "argShort", "ア");
            assertEquals(1,0);
        } catch (BeanAccessException e) {
            assertEquals(1,1);
        }

        try {
            beanAccessor.setProperty(bean, "argShort", "亜");
            assertEquals(1,0);
        } catch (BeanAccessException e) {
            assertEquals(1,1);
        }
    }

    @Test
    public void testLong() {
        try {
            beanAccessor.setProperty(bean, "argLong", "100");
            assertEquals(1,1);
        } catch (BeanAccessException e) {
            assertEquals(1,0);
        }

        try {
            beanAccessor.setProperty(bean, "argLong", "100.0");
            assertEquals(1,0);
        } catch (BeanAccessException e) {
            assertEquals("item-id は数字のみで入力してください。",
                MessageUtil.getMessage(e.getConversionErrors().iterator().next().getMessages().get(0).getMessage().substring(1,8)));
            assertEquals(1,1);
        }

        try {
            beanAccessor.setProperty(bean, "argLong", "-100");
            assertEquals(1,1);
        } catch (BeanAccessException e) {
            assertEquals(1,0);
        }

        try {
            beanAccessor.setProperty(bean, "argLong", "-100.0");
            assertEquals(1,0);
        } catch (BeanAccessException e) {
            assertEquals(1,1);
        }

        try {
            beanAccessor.setProperty(bean, "argLong", "=");
            assertEquals(1,0);
        } catch (BeanAccessException e) {
            assertEquals(1,1);
        }

        try {
            beanAccessor.setProperty(bean, "argLong", "a");
            assertEquals(1,0);
        } catch (BeanAccessException e) {
            assertEquals(1,1);
        }

        try {
            beanAccessor.setProperty(bean, "argLong", "ａ");
            assertEquals(1,0);
        } catch (BeanAccessException e) {
            assertEquals(1,1);
        }

        try {
            beanAccessor.setProperty(bean, "argLong", "あ");
            assertEquals(1,0);
        } catch (BeanAccessException e) {
            assertEquals(1,1);
        }

        try {
            beanAccessor.setProperty(bean, "argLong", "ｱ");
            assertEquals(1,0);
        } catch (BeanAccessException e) {
            assertEquals(1,1);
        }

        try {
            beanAccessor.setProperty(bean, "argLong", "ア");
            assertEquals(1,0);
        } catch (BeanAccessException e) {
            assertEquals(1,1);
        }

        try {
            beanAccessor.setProperty(bean, "argLong", "亜");
            assertEquals(1,0);
        } catch (BeanAccessException e) {
            assertEquals(1,1);
        }
    }

    @Test
    public void testFloat() {
        try {
            beanAccessor.setProperty(bean, "argFloat", "100");
            assertEquals(1,1);
        } catch (BeanAccessException e) {
            assertEquals(1,0);
        }

        try {
            beanAccessor.setProperty(bean, "argFloat", "100.0");
            assertEquals(1,1);
        } catch (BeanAccessException e) {
            assertEquals(1,0);
        }

        try {
            beanAccessor.setProperty(bean, "argFloat", "-100");
            assertEquals(1,1);
        } catch (BeanAccessException e) {
            assertEquals(1,0);
        }

        try {
            beanAccessor.setProperty(bean, "argFloat", "-100.0");
            assertEquals(1,1);
        } catch (BeanAccessException e) {
            assertEquals(1,0);
        }

        try {
            beanAccessor.setProperty(bean, "argFloat", "=");
            assertEquals(1,0);
        } catch (BeanAccessException e) {
            assertEquals("item-id は数字のみで入力してください。",
                MessageUtil.getMessage(e.getConversionErrors().iterator().next().getMessages().get(0).getMessage().substring(1,8)));
            assertEquals(1,1);
        }

        try {
            beanAccessor.setProperty(bean, "argFloat", "a");
            assertEquals(1,0);
        } catch (BeanAccessException e) {
            assertEquals(1,1);
        }

        try {
            beanAccessor.setProperty(bean, "argFloat", "ａ");
            assertEquals(1,0);
        } catch (BeanAccessException e) {
            assertEquals(1,1);
        }

        try {
            beanAccessor.setProperty(bean, "argFloat", "あ");
            assertEquals(1,0);
        } catch (BeanAccessException e) {
            assertEquals(1,1);
        }

        try {
            beanAccessor.setProperty(bean, "argFloat", "ｱ");
            assertEquals(1,0);
        } catch (BeanAccessException e) {
            assertEquals(1,1);
        }

        try {
            beanAccessor.setProperty(bean, "argFloat", "ア");
            assertEquals(1,0);
        } catch (BeanAccessException e) {
            assertEquals(1,1);
        }

        try {
            beanAccessor.setProperty(bean, "argFloat", "亜");
            assertEquals(1,0);
        } catch (BeanAccessException e) {
            assertEquals(1,1);
        }
    }

    @Test
    public void testDouble() {
        try {
            beanAccessor.setProperty(bean, "argDouble", "100");
            assertEquals(1,1);
        } catch (BeanAccessException e) {
            assertEquals(1,0);
        }

        try {
            beanAccessor.setProperty(bean, "argDouble", "100.0");
            assertEquals(1,1);
        } catch (BeanAccessException e) {
            assertEquals(1,0);
        }

        try {
            beanAccessor.setProperty(bean, "argDouble", "-100");
            assertEquals(1,1);
        } catch (BeanAccessException e) {
            assertEquals(1,0);
        }

        try {
            beanAccessor.setProperty(bean, "argDouble", "-100.0");
            assertEquals(1,1);
        } catch (BeanAccessException e) {
            assertEquals(1,0);
        }

        try {
            beanAccessor.setProperty(bean, "argDouble", "=");
            assertEquals(1,0);
        } catch (BeanAccessException e) {
            assertEquals("item-id は数字のみで入力してください。",
                MessageUtil.getMessage(e.getConversionErrors().iterator().next().getMessages().get(0).getMessage().substring(1,8)));
            assertEquals(1,1);
        }

        try {
            beanAccessor.setProperty(bean, "argDouble", "a");
            assertEquals(1,0);
        } catch (BeanAccessException e) {
            assertEquals(1,1);
        }

        try {
            beanAccessor.setProperty(bean, "argDouble", "ａ");
            assertEquals(1,0);
        } catch (BeanAccessException e) {
            assertEquals(1,1);
        }

        try {
            beanAccessor.setProperty(bean, "argDouble", "あ");
            assertEquals(1,0);
        } catch (BeanAccessException e) {
            assertEquals(1,1);
        }

        try {
            beanAccessor.setProperty(bean, "argDouble", "ｱ");
            assertEquals(1,0);
        } catch (BeanAccessException e) {
            assertEquals(1,1);
        }

        try {
            beanAccessor.setProperty(bean, "argDouble", "ア");
            assertEquals(1,0);
        } catch (BeanAccessException e) {
            assertEquals(1,1);
        }

        try {
            beanAccessor.setProperty(bean, "argDouble", "亜");
            assertEquals(1,0);
        } catch (BeanAccessException e) {
            assertEquals(1,1);
        }
    }

    @Test
    public void testByte() {
        try {
            beanAccessor.setProperty(bean, "argByte", "100");
            assertEquals(1,1);
        } catch (BeanAccessException e) {
            assertEquals(1,0);
        }

        try {
            beanAccessor.setProperty(bean, "argByte", "100.0");
            assertEquals(1,0);
        } catch (BeanAccessException e) {
            assertEquals("item-id は数字のみで入力してください。",
                MessageUtil.getMessage(e.getConversionErrors().iterator().next().getMessages().get(0).getMessage().substring(1,8)));
            assertEquals(1,1);
        }

        try {
            beanAccessor.setProperty(bean, "argByte", "-100");
            assertEquals(1,1);
        } catch (BeanAccessException e) {
            assertEquals(1,0);
        }

        try {
            beanAccessor.setProperty(bean, "argByte", "-100.0");
            assertEquals(1,0);
        } catch (BeanAccessException e) {
            assertEquals(1,1);
        }

        try {
            beanAccessor.setProperty(bean, "argByte", "=");
            assertEquals(1,0);
        } catch (BeanAccessException e) {
            assertEquals(1,1);
        }

        try {
            beanAccessor.setProperty(bean, "argByte", "a");
            assertEquals(1,0);
        } catch (BeanAccessException e) {
            assertEquals(1,1);
        }

        try {
            beanAccessor.setProperty(bean, "argByte", "ａ");
            assertEquals(1,0);
        } catch (BeanAccessException e) {
            assertEquals(1,1);
        }

        try {
            beanAccessor.setProperty(bean, "argByte", "あ");
            assertEquals(1,0);
        } catch (BeanAccessException e) {
            assertEquals(1,1);
        }

        try {
            beanAccessor.setProperty(bean, "argByte", "ｱ");
            assertEquals(1,0);
        } catch (BeanAccessException e) {
            assertEquals(1,1);
        }

        try {
            beanAccessor.setProperty(bean, "argByte", "ア");
            assertEquals(1,0);
        } catch (BeanAccessException e) {
            assertEquals(1,1);
        }

        try {
            beanAccessor.setProperty(bean, "argByte", "亜");
            assertEquals(1,0);
        } catch (BeanAccessException e) {
            assertEquals(1,1);
        }
    }


    @Test
    public void testBigDecimal() {
        try {
            beanAccessor.setProperty(bean, "bigDecimal", "100");
            assertEquals(1,1);
        } catch (BeanAccessException e) {
            assertEquals(1,0);
        }

        try {
            beanAccessor.setProperty(bean, "bigDecimal", "100.0");
            assertEquals(1,1);
        } catch (BeanAccessException e) {
            assertEquals(1,0);
        }

        try {
            beanAccessor.setProperty(bean, "bigDecimal", "-100");
            assertEquals(1,1);
        } catch (BeanAccessException e) {
            assertEquals(1,0);
        }

        try {
            beanAccessor.setProperty(bean, "bigDecimal", "-100.0");
            assertEquals(1,1);
        } catch (BeanAccessException e) {
            assertEquals(1,0);
        }

        try {
            beanAccessor.setProperty(bean, "bigDecimal", "=");
            assertEquals(1,0);
        } catch (BeanAccessException e) {
            assertEquals("item-id は数字のみで入力してください。",
                MessageUtil.getMessage(e.getConversionErrors().iterator().next().getMessages().get(0).getMessage().substring(1,8)));
            assertEquals(1,1);
        }

        try {
            beanAccessor.setProperty(bean, "bigDecimal", "a");
            assertEquals(1,0);
        } catch (BeanAccessException e) {
            assertEquals(1,1);
        }

        try {
            beanAccessor.setProperty(bean, "bigDecimal", "ａ");
            assertEquals(1,0);
        } catch (BeanAccessException e) {
            assertEquals(1,1);
        }

        try {
            beanAccessor.setProperty(bean, "bigDecimal", "あ");
            assertEquals(1,0);
        } catch (BeanAccessException e) {
            assertEquals(1,1);
        }

        try {
            beanAccessor.setProperty(bean, "bigDecimal", "ｱ");
            assertEquals(1,0);
        } catch (BeanAccessException e) {
            assertEquals(1,1);
        }

        try {
            beanAccessor.setProperty(bean, "bigDecimal", "ア");
            assertEquals(1,0);
        } catch (BeanAccessException e) {
            assertEquals(1,1);
        }

        try {
            beanAccessor.setProperty(bean, "bigDecimal", "亜");
            assertEquals(1,0);
        } catch (BeanAccessException e) {
            assertEquals(1,1);
        }
    }


    @Test
    public void testBigInteger() {
        try {
            beanAccessor.setProperty(bean, "bigInteger", "100");
            assertEquals(1,1);
        } catch (BeanAccessException e) {
            assertEquals(1,0);
        }

        try {
            beanAccessor.setProperty(bean, "bigInteger", "100.0");
            assertEquals(1,0);
        } catch (BeanAccessException e) {
            assertEquals("item-id は数字のみで入力してください。",
                MessageUtil.getMessage(e.getConversionErrors().iterator().next().getMessages().get(0).getMessage().substring(1,8)));
            assertEquals(1,1);
        }

        try {
            beanAccessor.setProperty(bean, "bigInteger", "-100");
            assertEquals(1,1);
        } catch (BeanAccessException e) {
            assertEquals(1,0);
        }

        try {
            beanAccessor.setProperty(bean, "bigInteger", "-100.0");
            assertEquals(1,0);
        } catch (BeanAccessException e) {
            assertEquals(1,1);
        }

        try {
            beanAccessor.setProperty(bean, "bigInteger", "=");
            assertEquals(1,0);
        } catch (BeanAccessException e) {
            assertEquals(1,1);
        }

        try {
            beanAccessor.setProperty(bean, "bigInteger", "a");
            assertEquals(1,0);
        } catch (BeanAccessException e) {
            assertEquals(1,1);
        }

        try {
            beanAccessor.setProperty(bean, "bigInteger", "ａ");
            assertEquals(1,0);
        } catch (BeanAccessException e) {
            assertEquals(1,1);
        }

        try {
            beanAccessor.setProperty(bean, "bigInteger", "あ");
            assertEquals(1,0);
        } catch (BeanAccessException e) {
            assertEquals(1,1);
        }

        try {
            beanAccessor.setProperty(bean, "bigInteger", "ｱ");
            assertEquals(1,0);
        } catch (BeanAccessException e) {
            assertEquals(1,1);
        }

        try {
            beanAccessor.setProperty(bean, "bigInteger", "ア");
            assertEquals(1,0);
        } catch (BeanAccessException e) {
            assertEquals(1,1);
        }

        try {
            beanAccessor.setProperty(bean, "bigInteger", "亜");
            assertEquals(1,0);
        } catch (BeanAccessException e) {
            assertEquals(1,1);
        }
    }

    @Test
    public void testBoolean() {

        try {
            beanAccessor.setProperty(bean, "argBoolean", "Boolean.TRUE");
            assertEquals(1,1);
        } catch (BeanAccessException e) {
            assertEquals(1,0);
        }

        try {
            beanAccessor.setProperty(bean, "argBoolean", "Boolean.FALSE");
            assertEquals(1,1);
        } catch (BeanAccessException e) {
            assertEquals(1,0);
        }

        //        try {
        //            beanAccessor.setProperty(bean, "argBoolean", "100");
        //            assertEquals(1,0);
        //        } catch (BeanAccessException e) {
        //            assertEquals("item-id は真偽値のみで入力してください。",
        //                MessageUtil.getMessage(e.getConversionErrors().iterator().next().getMessages().get(0).getMessage().substring(1,8)));
        //            assertEquals(1,1);
        //        }
        //
        //        try {
        //            beanAccessor.setProperty(bean, "argBoolean", "100.0");
        //            assertEquals(1,0);
        //        } catch (BeanAccessException e) {
        //            assertEquals(1,1);
        //        }
        //
        //        try {
        //            beanAccessor.setProperty(bean, "argBoolean", "-100");
        //            assertEquals(1,0);
        //        } catch (BeanAccessException e) {
        //            assertEquals(1,1);
        //        }
        //
        //        try {
        //            beanAccessor.setProperty(bean, "argBoolean", "-100.0");
        //            assertEquals(1,0);
        //        } catch (BeanAccessException e) {
        //            assertEquals(1,1);
        //        }
        //
        //        try {
        //            beanAccessor.setProperty(bean, "argBoolean", "=");
        //            assertEquals(1,0);
        //        } catch (BeanAccessException e) {
        //            assertEquals(1,1);
        //        }
        //
        //        try {
        //            beanAccessor.setProperty(bean, "argBoolean", "a");
        //            assertEquals(1,0);
        //        } catch (BeanAccessException e) {
        //            assertEquals(1,1);
        //        }
        //
        //        try {
        //            beanAccessor.setProperty(bean, "argBoolean", "ａ");
        //            assertEquals(1,0);
        //        } catch (BeanAccessException e) {
        //            assertEquals(1,1);
        //        }
        //
        //        try {
        //            beanAccessor.setProperty(bean, "argBoolean", "あ");
        //            assertEquals(1,0);
        //        } catch (BeanAccessException e) {
        //            assertEquals(1,1);
        //        }
        //
        //        try {
        //            beanAccessor.setProperty(bean, "argBoolean", "ｱ");
        //            assertEquals(1,0);
        //        } catch (BeanAccessException e) {
        //            assertEquals(1,1);
        //        }
        //
        //        try {
        //            beanAccessor.setProperty(bean, "argBoolean", "ア");
        //            assertEquals(1,0);
        //        } catch (BeanAccessException e) {
        //            assertEquals(1,1);
        //        }
        //
        //        try {
        //            beanAccessor.setProperty(bean, "argBoolean", "亜");
        //            assertEquals(1,0);
        //        } catch (BeanAccessException e) {
        //            assertEquals(1,1);
        //        }
    }

    @Test
    public void testCharcter() {
        try {
            beanAccessor.setProperty(bean, "character", "a");
            assertEquals(1,1);
        } catch (BeanAccessException e) {
            assertEquals(1,0);
        }

        try {
            beanAccessor.setProperty(bean, "character", "aa");
            assertEquals(1,0);
        } catch (BeanAccessException e) {
            assertEquals("item-id は使用できない文字が含まれています。",
                MessageUtil.getMessage(e.getConversionErrors().iterator().next().getMessages().get(0).getMessage().substring(1,8)));
            assertEquals(1,1);
        }

        try {
            beanAccessor.setProperty(bean, "character", "A");
            assertEquals(1,1);
        } catch (BeanAccessException e) {
            assertEquals(1,0);
        }

        try {
            beanAccessor.setProperty(bean, "character", "1");
            assertEquals(1,1);
        } catch (BeanAccessException e) {
            assertEquals(1,0);
        }

        try {
            beanAccessor.setProperty(bean, "character", "=");
            assertEquals(1,1);
        } catch (BeanAccessException e) {
            assertEquals(1,0);
        }

        try {
            beanAccessor.setProperty(bean, "character", "あ");
            assertEquals(1,1);
        } catch (BeanAccessException e) {
            assertEquals(1,0);
        }

        try {
            beanAccessor.setProperty(bean, "character", "ああ");
            assertEquals(1,0);
        } catch (BeanAccessException e) {
            assertEquals(1,1);
        }

        try {
            beanAccessor.setProperty(bean, "character", "ａ");
            assertEquals(1,1);
        } catch (BeanAccessException e) {
            assertEquals(1,0);
        }

        try {
            beanAccessor.setProperty(bean, "character", "Ａ");
            assertEquals(1,1);
        } catch (BeanAccessException e) {
            assertEquals(1,0);
        }

        try {
            beanAccessor.setProperty(bean, "character", "ＡＡ");
            assertEquals(1,0);
        } catch (BeanAccessException e) {
            assertEquals(1,1);
        }

        try {
            beanAccessor.setProperty(bean, "character", "１");
            assertEquals(1,1);
        } catch (BeanAccessException e) {
            assertEquals(1,0);
        }

        try {
            beanAccessor.setProperty(bean, "character", "ア");
            assertEquals(1,1);
        } catch (BeanAccessException e) {
            assertEquals(1,0);
        }

        try {
            beanAccessor.setProperty(bean, "character", "ｱ");
            assertEquals(1,1);
        } catch (BeanAccessException e) {
            assertEquals(1,0);
        }

        try {
            beanAccessor.setProperty(bean, "character", "ｱｱ");
            assertEquals(1,0);
        } catch (BeanAccessException e) {
            assertEquals(1,1);
        }

        try {
            beanAccessor.setProperty(bean, "character", "亜");
            assertEquals(1,1);
        } catch (BeanAccessException e) {
            assertEquals(1,0);
        }

        try {
            beanAccessor.setProperty(bean, "character", "亜亜");
            assertEquals(1,0);
        } catch (BeanAccessException e) {
            assertEquals(1,1);
        }
    }

    @Test
    public void testBizNumber() {
        try {
            beanAccessor.setProperty(bean, "bizNumber", "100");
            assertEquals(1,1);
        } catch (BeanAccessException e) {
            assertEquals(1,0);
        }

        try {
            beanAccessor.setProperty(bean, "bizNumber", "100.0");
            assertEquals(1,1);
        } catch (BeanAccessException e) {
            assertEquals(1,0);
        }

        try {
            beanAccessor.setProperty(bean, "bizNumber", "-100");
            assertEquals(1,1);
        } catch (BeanAccessException e) {
            assertEquals(1,0);
        }

        try {
            beanAccessor.setProperty(bean, "bizNumber", "-100.0");
            assertEquals(1,1);
        } catch (BeanAccessException e) {
            assertEquals(1,0);
        }

        try {
            beanAccessor.setProperty(bean, "bizNumber", "=");
            assertEquals(1,0);
        } catch (BeanAccessException e) {
            assertEquals("item-id は数字のみで入力してください。",
                MessageUtil.getMessage(e.getConversionErrors().iterator().next().getMessages().get(0).getMessage().substring(1,8)));
            assertEquals(1,1);
        }

        try {
            beanAccessor.setProperty(bean, "bizNumber", "a");
            assertEquals(1,0);
        } catch (BeanAccessException e) {
            assertEquals(1,1);
        }

        try {
            beanAccessor.setProperty(bean, "bizNumber", "ａ");
            assertEquals(1,0);
        } catch (BeanAccessException e) {
            assertEquals(1,1);
        }

        try {
            beanAccessor.setProperty(bean, "bizNumber", "あ");
            assertEquals(1,0);
        } catch (BeanAccessException e) {
            assertEquals(1,1);
        }

        try {
            beanAccessor.setProperty(bean, "bizNumber", "ｱ");
            assertEquals(1,0);
        } catch (BeanAccessException e) {
            assertEquals(1,1);
        }

        try {
            beanAccessor.setProperty(bean, "bizNumber", "ア");
            assertEquals(1,0);
        } catch (BeanAccessException e) {
            assertEquals(1,1);
        }

        try {
            beanAccessor.setProperty(bean, "bizNumber", "亜");
            assertEquals(1,0);
        } catch (BeanAccessException e) {
            assertEquals(1,1);
        }
    }

    @Test
    public void testBizCurrency() {
        try {
            beanAccessor.setProperty(bean, "bizCurrency", "100;YEN");
            assertEquals(1,1);
        } catch (BeanAccessException e) {
            assertEquals(1,0);
        }

        try {
            beanAccessor.setProperty(bean, "bizCurrency", "100.0;YEN");
            assertEquals(1,1);
        } catch (BeanAccessException e) {
            assertEquals(1,0);
        }

        try {
            beanAccessor.setProperty(bean, "bizCurrency", "-100;MANYEN");
            assertEquals(1,1);
        } catch (BeanAccessException e) {
            assertEquals(1,0);
        }

        try {
            beanAccessor.setProperty(bean, "bizCurrency", "-100.0;DOLLAR");
            assertEquals(1,1);
        } catch (BeanAccessException e) {
            assertEquals(1,0);
        }

        try {
            beanAccessor.setProperty(bean, "bizCurrency", "=");
            assertEquals(1,0);
        } catch (BeanAccessException e) {
            assertEquals("item-id は数字のみで入力してください。",
                MessageUtil.getMessage(e.getConversionErrors().iterator().next().getMessages().get(0).getMessage().substring(1,8)));
            assertEquals(1,1);
        }

        try {
            beanAccessor.setProperty(bean, "bizCurrency", "a");
            assertEquals(1,0);
        } catch (BeanAccessException e) {
            assertEquals(1,1);
        }

        try {
            beanAccessor.setProperty(bean, "bizCurrency", "ａ");
            assertEquals(1,0);
        } catch (BeanAccessException e) {
            assertEquals(1,1);
        }

        try {
            beanAccessor.setProperty(bean, "bizCurrency", "あ");
            assertEquals(1,0);
        } catch (BeanAccessException e) {
            assertEquals(1,1);
        }

        try {
            beanAccessor.setProperty(bean, "bizCurrency", "ｱ");
            assertEquals(1,0);
        } catch (BeanAccessException e) {
            assertEquals(1,1);
        }

        try {
            beanAccessor.setProperty(bean, "bizCurrency", "ア");
            assertEquals(1,0);
        } catch (BeanAccessException e) {
            assertEquals(1,1);
        }

        try {
            beanAccessor.setProperty(bean, "bizCurrency", "亜");
            assertEquals(1,0);
        } catch (BeanAccessException e) {
            assertEquals(1,1);
        }
    }

    @Test
    public void testBizRate() {
        try {
            beanAccessor.setProperty(bean, "bizRate", "100");
            assertEquals(1,1);
        } catch (BeanAccessException e) {
            assertEquals(1,0);
        }

        try {
            beanAccessor.setProperty(bean, "bizRate", "100.0");
            assertEquals(1,1);
        } catch (BeanAccessException e) {
            assertEquals(1,0);
        }

        try {
            beanAccessor.setProperty(bean, "bizRate", "-100");
            assertEquals(1,1);
        } catch (BeanAccessException e) {
            assertEquals(1,0);
        }

        try {
            beanAccessor.setProperty(bean, "bizRate", "-100.0");
            assertEquals(1,1);
        } catch (BeanAccessException e) {
            assertEquals(1,0);
        }

        try {
            beanAccessor.setProperty(bean, "bizRate", "=");
            assertEquals(1,0);
        } catch (BeanAccessException e) {
            assertEquals("item-id は数字のみで入力してください。",
                MessageUtil.getMessage(e.getConversionErrors().iterator().next().getMessages().get(0).getMessage().substring(1,8)));
            assertEquals(1,1);
        }

        try {
            beanAccessor.setProperty(bean, "bizRate", "a");
            assertEquals(1,0);
        } catch (BeanAccessException e) {
            assertEquals(1,1);
        }

        try {
            beanAccessor.setProperty(bean, "bizRate", "ａ");
            assertEquals(1,0);
        } catch (BeanAccessException e) {
            assertEquals(1,1);
        }

        try {
            beanAccessor.setProperty(bean, "bizRate", "あ");
            assertEquals(1,0);
        } catch (BeanAccessException e) {
            assertEquals(1,1);
        }

        try {
            beanAccessor.setProperty(bean, "bizRate", "ｱ");
            assertEquals(1,0);
        } catch (BeanAccessException e) {
            assertEquals(1,1);
        }

        try {
            beanAccessor.setProperty(bean, "bizRate", "ア");
            assertEquals(1,0);
        } catch (BeanAccessException e) {
            assertEquals(1,1);
        }

        try {
            beanAccessor.setProperty(bean, "bizRate", "亜");
            assertEquals(1,0);
        } catch (BeanAccessException e) {
            assertEquals(1,1);
        }
    }

    @Test
    public void testKbn() {
        try {
            beanAccessor.setProperty(bean, "youhiKbn", "HUYOU");
            assertEquals(1,1);
        } catch (BeanAccessException e) {
            assertEquals(1,0);
        }

        try {
            beanAccessor.setProperty(bean, "youhiKbn", "YOU");
            assertEquals(1,1);
        } catch (BeanAccessException e) {
            assertEquals(1,0);
        }

        try {
            beanAccessor.setProperty(bean, "youhiKbn", "ARI");
            assertEquals(1,0);
        } catch (BeanAccessException e) {
            assertEquals("item-id は区分として取り得る値で入力してください。",
                MessageUtil.getMessage(e.getConversionErrors().iterator().next().getMessages().get(0).getMessage().substring(1,8)));
            assertEquals(1,1);
        }

        try {
            beanAccessor.setProperty(bean, "youhiKbn", "100");
            assertEquals(1,0);
        } catch (BeanAccessException e) {
            assertEquals(1,1);
        }

        try {
            beanAccessor.setProperty(bean, "youhiKbn", "100.0");
            assertEquals(1,0);
        } catch (BeanAccessException e) {
            assertEquals(1,1);
        }

        try {
            beanAccessor.setProperty(bean, "youhiKbn", "-100");
            assertEquals(1,0);
        } catch (BeanAccessException e) {
            assertEquals(1,1);
        }

        try {
            beanAccessor.setProperty(bean, "youhiKbn", "-100.0");
            assertEquals(1,0);
        } catch (BeanAccessException e) {
            assertEquals(1,1);
        }

        try {
            beanAccessor.setProperty(bean, "youhiKbn", "=");
            assertEquals(1,0);
        } catch (BeanAccessException e) {
            assertEquals(1,1);
        }

        try {
            beanAccessor.setProperty(bean, "youhiKbn", "a");
            assertEquals(1,0);
        } catch (BeanAccessException e) {
            assertEquals(1,1);
        }

        try {
            beanAccessor.setProperty(bean, "youhiKbn", "ａ");
            assertEquals(1,0);
        } catch (BeanAccessException e) {
            assertEquals(1,1);
        }

        try {
            beanAccessor.setProperty(bean, "youhiKbn", "あ");
            assertEquals(1,0);
        } catch (BeanAccessException e) {
            assertEquals(1,1);
        }

        try {
            beanAccessor.setProperty(bean, "youhiKbn", "ｱ");
            assertEquals(1,0);
        } catch (BeanAccessException e) {
            assertEquals(1,1);
        }

        try {
            beanAccessor.setProperty(bean, "youhiKbn", "ア");
            assertEquals(1,0);
        } catch (BeanAccessException e) {
            assertEquals(1,1);
        }

        try {
            beanAccessor.setProperty(bean, "youhiKbn", "亜");
            assertEquals(1,0);
        } catch (BeanAccessException e) {
            assertEquals(1,1);
        }
    }
}
