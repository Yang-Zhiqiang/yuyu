package yuyu.infr.validation;

import static org.junit.Assert.*;
import static yuyu.def.YuyuStandardCharsets.*;

import java.math.BigDecimal;
import java.util.Set;

import javax.inject.Inject;
import javax.validation.ConstraintViolation;
import javax.validation.Validator;

import jp.co.slcs.swak.core.test.SWAKTestRunner;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.date.BizDateMD;
import jp.co.slcs.swak.date.BizDateY;
import jp.co.slcs.swak.date.BizDateYM;
import jp.co.slcs.swak.number.BizCurrency;
import jp.co.slcs.swak.number.BizNumber;
import jp.co.slcs.swak.number.BizRate;
import jp.co.slcs.swak.util.message.MessageUtil;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;

/**
 * Validator のテストです。
 */
@RunWith(SWAKTestRunner.class)
public class Tester {

    @Inject
    private Validator validator;

    @Inject
    private Bean bean;

    @SuppressWarnings("unused")
    @Inject
    private static Logger logger;

    @Test
    public void testPattern() {

        bean.setPattern("123-4567");
        Set<ConstraintViolation<Bean>> set = validator.validateProperty(bean, "pattern");
        assertEquals(0, set.size());

        bean.setPattern("1b3-4567");
        set = validator.validateProperty(bean, "pattern");
        assertEquals(1, set.size());
        assertEquals("item-id は正規表現に反しない内容で入力してください。正規表現： regex",
            MessageUtil.getMessage(set.iterator().next().getMessage().substring(1, 8)));

        bean.setPattern("123-4e67");
        set = validator.validateProperty(bean, "pattern");
        assertEquals(1, set.size());

        bean.setPattern("1あ3-4567");
        set = validator.validateProperty(bean, "pattern");
        assertEquals(1, set.size());

        bean.setPattern("1ｱ3-4567");
        set = validator.validateProperty(bean, "pattern");
        assertEquals(1, set.size());

        bean.setPattern("1ア3-4567");
        set = validator.validateProperty(bean, "pattern");
        assertEquals(1, set.size());

        bean.setPattern("1亜3-4567");
        set = validator.validateProperty(bean, "pattern");
        assertEquals(1, set.size());

        bean.setPattern("1=3-4567");
        set = validator.validateProperty(bean, "pattern");
        assertEquals(1, set.size());

        bean.setPattern("123-4い67");
        set = validator.validateProperty(bean, "pattern");
        assertEquals(1, set.size());

        bean.setPattern("123-4ｲ67");
        set = validator.validateProperty(bean, "pattern");
        assertEquals(1, set.size());

        bean.setPattern("123-4イ67");
        set = validator.validateProperty(bean, "pattern");
        assertEquals(1, set.size());

        bean.setPattern("123-4伊67");
        set = validator.validateProperty(bean, "pattern");
        assertEquals(1, set.size());

        bean.setPattern("123-4=67");
        set = validator.validateProperty(bean, "pattern");
        assertEquals(1, set.size());

        bean.setPattern("1234567");
        set = validator.validateProperty(bean, "pattern");
        assertEquals(1, set.size());

        bean.setPattern("1234-5678");
        set = validator.validateProperty(bean, "pattern");
        assertEquals(1, set.size());

        bean.setPattern("12-5678");
        set = validator.validateProperty(bean, "pattern");
        assertEquals(1, set.size());

        bean.setPattern("123-456");
        set = validator.validateProperty(bean, "pattern");
        assertEquals(1, set.size());

        bean.setPattern("123-45678");
        set = validator.validateProperty(bean, "pattern");
        assertEquals(1, set.size());

    }

    @Test
    public void testSingleByteStrings() {

        bean.setSingleByteStrings("abcd");
        Set<ConstraintViolation<Bean>> set = validator.validateProperty(bean, "singleByteStrings");
        assertEquals(0, set.size());

        bean.setSingleByteStrings("1234");
        set = validator.validateProperty(bean, "singleByteStrings");
        assertEquals(0, set.size());

        bean.setSingleByteStrings("12ab");
        set = validator.validateProperty(bean, "singleByteStrings");
        assertEquals(0, set.size());

        bean.setSingleByteStrings("123=");
        set = validator.validateProperty(bean, "singleByteStrings");
        assertEquals(0, set.size());

        bean.setSingleByteStrings("123＝");
        set = validator.validateProperty(bean, "singleByteStrings");
        assertEquals(1, set.size());
        assertEquals("item-id は半角文字のみで入力してください。",
            MessageUtil.getMessage(set.iterator().next().getMessage().substring(1, 8)));

        bean.setSingleByteStrings("123\n");
        set = validator.validateProperty(bean, "singleByteStrings");
        assertEquals(1, set.size());

        bean.setSingleByteStrings("1２ab");
        set = validator.validateProperty(bean, "singleByteStrings");
        assertEquals(1, set.size());

        bean.setSingleByteStrings("12aＢ");
        set = validator.validateProperty(bean, "singleByteStrings");
        assertEquals(1, set.size());

        bean.setSingleByteStrings("123あ");
        set = validator.validateProperty(bean, "singleByteStrings");
        assertEquals(1, set.size());

        bean.setSingleByteStrings("123ア");
        set = validator.validateProperty(bean, "singleByteStrings");
        assertEquals(1, set.size());

        bean.setSingleByteStrings("123ｱ");
        set = validator.validateProperty(bean, "singleByteStrings");
        assertEquals(0, set.size());

        bean.setSingleByteStrings("123亜");
        set = validator.validateProperty(bean, "singleByteStrings");
        assertEquals(1, set.size());

    }

    @Test
    public void testSingleByteStringsReturnable() {

        bean.setSingleByteStringsReturnable("abcd");
        Set<ConstraintViolation<Bean>> set = validator.validateProperty(bean, "singleByteStringsReturnable");
        assertEquals(0, set.size());

        bean.setSingleByteStringsReturnable("1234");
        set = validator.validateProperty(bean, "singleByteStringsReturnable");
        assertEquals(0, set.size());

        bean.setSingleByteStringsReturnable("12ab");
        set = validator.validateProperty(bean, "singleByteStringsReturnable");
        assertEquals(0, set.size());

        bean.setSingleByteStringsReturnable("123=");
        set = validator.validateProperty(bean, "singleByteStringsReturnable");
        assertEquals(0, set.size());

        bean.setSingleByteStringsReturnable("123＝");
        set = validator.validateProperty(bean, "singleByteStringsReturnable");
        assertEquals(1, set.size());
        assertEquals("item-id は半角文字のみで入力してください。",
            MessageUtil.getMessage(set.iterator().next().getMessage().substring(1, 8)));

        bean.setSingleByteStringsReturnable("123\n");
        set = validator.validateProperty(bean, "singleByteStringsReturnable");
        assertEquals(0, set.size());

        bean.setSingleByteStringsReturnable("1２ab");
        set = validator.validateProperty(bean, "singleByteStringsReturnable");
        assertEquals(1, set.size());

        bean.setSingleByteStringsReturnable("12aＢ");
        set = validator.validateProperty(bean, "singleByteStringsReturnable");
        assertEquals(1, set.size());

        bean.setSingleByteStringsReturnable("123あ");
        set = validator.validateProperty(bean, "singleByteStringsReturnable");
        assertEquals(1, set.size());

        bean.setSingleByteStringsReturnable("123ア");
        set = validator.validateProperty(bean, "singleByteStringsReturnable");
        assertEquals(1, set.size());

        bean.setSingleByteStringsReturnable("123ｱ");
        set = validator.validateProperty(bean, "singleByteStringsReturnable");
        assertEquals(0, set.size());

        bean.setSingleByteStringsReturnable("123亜");
        set = validator.validateProperty(bean, "singleByteStringsReturnable");
        assertEquals(1, set.size());

    }

    @Test
    public void testAlphaDigit() {

        bean.setAlphaDigit("1234");
        Set<ConstraintViolation<Bean>> set = validator.validateProperty(bean, "alphaDigit");
        assertEquals(0, set.size());

        bean.setAlphaDigit("abcd");
        set = validator.validateProperty(bean, "alphaDigit");
        assertEquals(0, set.size());

        bean.setAlphaDigit("ABCD");
        set = validator.validateProperty(bean, "alphaDigit");
        assertEquals(0, set.size());

        bean.setAlphaDigit("12abAB");
        set = validator.validateProperty(bean, "alphaDigit");
        assertEquals(0, set.size());

        bean.setAlphaDigit("12abAB=");
        set = validator.validateProperty(bean, "alphaDigit");
        assertEquals(1, set.size());
        assertEquals("item-id は英数字のみで入力してください。",
            MessageUtil.getMessage(set.iterator().next().getMessage().substring(1, 8)));

        bean.setAlphaDigit("12abABあ");
        set = validator.validateProperty(bean, "alphaDigit");
        assertEquals(1, set.size());

        bean.setAlphaDigit("12abABア");
        set = validator.validateProperty(bean, "alphaDigit");
        assertEquals(1, set.size());

        bean.setAlphaDigit("12abABｱ");
        set = validator.validateProperty(bean, "alphaDigit");
        assertEquals(1, set.size());

        bean.setAlphaDigit("12abAB亜");
        set = validator.validateProperty(bean, "alphaDigit");
        assertEquals(1, set.size());

        bean.setAlphaDigit("1２abAB");
        set = validator.validateProperty(bean, "alphaDigit");
        assertEquals(1, set.size());

        bean.setAlphaDigit("12ａbAB");
        set = validator.validateProperty(bean, "alphaDigit");
        assertEquals(1, set.size());

        bean.setAlphaDigit("12abＡB");
        set = validator.validateProperty(bean, "alphaDigit");
        assertEquals(1, set.size());

    }

    @Test
    public void testAlphaDigitOrExceptionCode() {

        bean.setAlphaDigitOrExceptionCode("1234");
        Set<ConstraintViolation<Bean>> set = validator.validateProperty(bean, "alphaDigitOrExceptionCode");
        assertEquals(0, set.size());

        bean.setAlphaDigitOrExceptionCode("abcd");
        set = validator.validateProperty(bean, "alphaDigitOrExceptionCode");
        assertEquals(0, set.size());

        bean.setAlphaDigitOrExceptionCode("ABCD");
        set = validator.validateProperty(bean, "alphaDigitOrExceptionCode");
        assertEquals(0, set.size());

        bean.setAlphaDigitOrExceptionCode("12abAB");
        set = validator.validateProperty(bean, "alphaDigitOrExceptionCode");
        assertEquals(0, set.size());

        bean.setAlphaDigitOrExceptionCode("12abAB=");
        set = validator.validateProperty(bean, "alphaDigitOrExceptionCode");
        assertEquals(0, set.size());

        bean.setAlphaDigitOrExceptionCode("12abAB/");
        set = validator.validateProperty(bean, "alphaDigitOrExceptionCode");
        assertEquals(1, set.size());

        bean.setAlphaDigitOrExceptionCode("12abABあ");
        set = validator.validateProperty(bean, "alphaDigitOrExceptionCode");
        assertEquals(1, set.size());
        assertEquals("item-id は英数字または except 内の文字で入力してください。",
            MessageUtil.getMessage(set.iterator().next().getMessage().substring(1, 8)));

        bean.setAlphaDigitOrExceptionCode("12abABア");
        set = validator.validateProperty(bean, "alphaDigitOrExceptionCode");
        assertEquals(1, set.size());

        bean.setAlphaDigitOrExceptionCode("12abABｱ");
        set = validator.validateProperty(bean, "alphaDigitOrExceptionCode");
        assertEquals(1, set.size());

        bean.setAlphaDigitOrExceptionCode("12abAB亜");
        set = validator.validateProperty(bean, "alphaDigitOrExceptionCode");
        assertEquals(1, set.size());

        bean.setAlphaDigitOrExceptionCode("1２abAB");
        set = validator.validateProperty(bean, "alphaDigitOrExceptionCode");
        assertEquals(1, set.size());

        bean.setAlphaDigitOrExceptionCode("12ａbAB");
        set = validator.validateProperty(bean, "alphaDigitOrExceptionCode");
        assertEquals(1, set.size());

        bean.setAlphaDigitOrExceptionCode("12abＡB");
        set = validator.validateProperty(bean, "alphaDigitOrExceptionCode");
        assertEquals(1, set.size());

    }

    @Test
    public void testMultiByteStrings() {

        bean.setMultiByteStrings("ＡＢＣＤ");
        Set<ConstraintViolation<Bean>> set = validator.validateProperty(bean, "multiByteStrings");
        assertEquals(0, set.size());

        bean.setMultiByteStrings("１２３４");
        set = validator.validateProperty(bean, "multiByteStrings");
        assertEquals(0, set.size());

        bean.setMultiByteStrings("１２ＡＢ");
        set = validator.validateProperty(bean, "multiByteStrings");
        assertEquals(0, set.size());

        bean.setMultiByteStrings("１２３＝");
        set = validator.validateProperty(bean, "multiByteStrings");
        assertEquals(0, set.size());

        bean.setMultiByteStrings("１２３=");
        set = validator.validateProperty(bean, "multiByteStrings");
        assertEquals(1, set.size());
        assertEquals("item-id は全角文字のみで入力してください。",
            MessageUtil.getMessage(set.iterator().next().getMessage().substring(1, 8)));

        bean.setMultiByteStrings("１２３\n");
        set = validator.validateProperty(bean, "multiByteStrings");
        assertEquals(1, set.size());

        bean.setMultiByteStrings("１2Ａｂ");
        set = validator.validateProperty(bean, "multiByteStrings");
        assertEquals(1, set.size());

        bean.setMultiByteStrings("１２Ａb");
        set = validator.validateProperty(bean, "multiByteStrings");
        assertEquals(1, set.size());

        bean.setMultiByteStrings("１２Ａあ");
        set = validator.validateProperty(bean, "multiByteStrings");
        assertEquals(0, set.size());

        bean.setMultiByteStrings("１２Ａア");
        set = validator.validateProperty(bean, "multiByteStrings");
        assertEquals(0, set.size());

        bean.setMultiByteStrings("１２Ａｱ");
        set = validator.validateProperty(bean, "multiByteStrings");
        assertEquals(1, set.size());

        bean.setMultiByteStrings("１２Ａ亜");
        set = validator.validateProperty(bean, "multiByteStrings");
        assertEquals(0, set.size());

    }

    @Test
    public void testMultiByteStringsReturnable() {

        bean.setMultiByteStringsReturnable("ＡＢＣＤ");
        Set<ConstraintViolation<Bean>> set = validator.validateProperty(bean, "multiByteStringsReturnable");
        assertEquals(0, set.size());

        bean.setMultiByteStringsReturnable("１２３４");
        set = validator.validateProperty(bean, "multiByteStringsReturnable");
        assertEquals(0, set.size());

        bean.setMultiByteStringsReturnable("１２ＡＢ");
        set = validator.validateProperty(bean, "multiByteStringsReturnable");
        assertEquals(0, set.size());

        bean.setMultiByteStringsReturnable("１２３＝");
        set = validator.validateProperty(bean, "multiByteStringsReturnable");
        assertEquals(0, set.size());

        bean.setMultiByteStringsReturnable("１２３=");
        set = validator.validateProperty(bean, "multiByteStringsReturnable");
        assertEquals(1, set.size());
        assertEquals("item-id は全角文字のみで入力してください。",
            MessageUtil.getMessage(set.iterator().next().getMessage().substring(1, 8)));

        bean.setMultiByteStringsReturnable("１２３\n");
        set = validator.validateProperty(bean, "multiByteStringsReturnable");
        assertEquals(0, set.size());

        bean.setMultiByteStringsReturnable("１2Ａｂ");
        set = validator.validateProperty(bean, "multiByteStringsReturnable");
        assertEquals(1, set.size());

        bean.setMultiByteStringsReturnable("１２Ａb");
        set = validator.validateProperty(bean, "multiByteStringsReturnable");
        assertEquals(1, set.size());

        bean.setMultiByteStringsReturnable("１２Ａあ");
        set = validator.validateProperty(bean, "multiByteStringsReturnable");
        assertEquals(0, set.size());

        bean.setMultiByteStringsReturnable("１２Ａア");
        set = validator.validateProperty(bean, "multiByteStringsReturnable");
        assertEquals(0, set.size());

        bean.setMultiByteStringsReturnable("１２Ａｱ");
        set = validator.validateProperty(bean, "multiByteStringsReturnable");
        assertEquals(1, set.size());

        bean.setMultiByteStringsReturnable("１２Ａ亜");
        set = validator.validateProperty(bean, "multiByteStringsReturnable");
        assertEquals(0, set.size());

    }

    @Test
    public void testLength() {
        bean.setLength("１２３４５６７８９");
        Set<ConstraintViolation<Bean>> set = validator.validateProperty(bean, "length");
        assertEquals(1, set.size());
        assertEquals("item-id は 桁数 文字で入力してください。",
            MessageUtil.getMessage(set.iterator().next().getMessage().substring(1, 8)));

        bean.setLength("１２３４５６７８９０");
        set = validator.validateProperty(bean, "length");
        assertEquals(0, set.size());

        bean.setLength("１２３４５６７８９０１");
        set = validator.validateProperty(bean, "length");
        assertEquals(1, set.size());

        bean.setLength("123456789");
        set = validator.validateProperty(bean, "length");
        assertEquals(1, set.size());

        bean.setLength("1234567890");
        set = validator.validateProperty(bean, "length");
        assertEquals(0, set.size());

        bean.setLength("12345678901");
        set = validator.validateProperty(bean, "length");
        assertEquals(1, set.size());

        bean.setLength("12345６７８９");
        set = validator.validateProperty(bean, "length");
        assertEquals(1, set.size());

        bean.setLength("12345６７８９０");
        set = validator.validateProperty(bean, "length");
        assertEquals(0, set.size());

        bean.setLength("12345６７８９０１");
        set = validator.validateProperty(bean, "length");
        assertEquals(1, set.size());

    }

    @Test
    public void testLengthRange() {

        bean.setLengthRange("あ");
        Set<ConstraintViolation<Bean>> set = validator.validateProperty(bean, "lengthRange");
        assertEquals(1, set.size());

        bean.setLengthRange("あ1");
        set = validator.validateProperty(bean, "lengthRange");
        assertEquals(0, set.size());

        bean.setLengthRange("あい1");
        set = validator.validateProperty(bean, "lengthRange");
        assertEquals(0, set.size());

        bean.setLengthRange("あい12");
        set = validator.validateProperty(bean, "lengthRange");
        assertEquals(0, set.size());

        bean.setLengthRange("あい123");
        set = validator.validateProperty(bean, "lengthRange");
        assertEquals(1, set.size());

        bean.setLengthRange("１");
        //Set<ConstraintViolation<Bean>> set = validator.validateProperty(bean, "lengthRange");
        set = validator.validateProperty(bean, "lengthRange");
        assertEquals(1, set.size());
        assertEquals("item-id は min 文字以上 max 文字以内で入力してください。",
            MessageUtil.getMessage(set.iterator().next().getMessage().substring(1, 8)));

        bean.setLengthRange("１２");
        set = validator.validateProperty(bean, "lengthRange");
        assertEquals(0, set.size());

        bean.setLengthRange("１２３");
        set = validator.validateProperty(bean, "lengthRange");
        assertEquals(0, set.size());

        bean.setLengthRange("１２３４");
        set = validator.validateProperty(bean, "lengthRange");
        assertEquals(0, set.size());

        bean.setLengthRange("１２３４５");
        set = validator.validateProperty(bean, "lengthRange");
        assertEquals(1, set.size());

        bean.setLengthRange("1");
        set = validator.validateProperty(bean, "lengthRange");
        assertEquals(1, set.size());

        bean.setLengthRange("12");
        set = validator.validateProperty(bean, "lengthRange");
        assertEquals(0, set.size());

        bean.setLengthRange("123");
        set = validator.validateProperty(bean, "lengthRange");
        assertEquals(0, set.size());

        bean.setLengthRange("1234");
        set = validator.validateProperty(bean, "lengthRange");
        assertEquals(0, set.size());

        bean.setLengthRange("12345");
        set = validator.validateProperty(bean, "lengthRange");
        assertEquals(1, set.size());

        bean.setLengthRange("1");
        set = validator.validateProperty(bean, "lengthRange");
        assertEquals(1, set.size());

        bean.setLengthRange("1２");
        set = validator.validateProperty(bean, "lengthRange");
        assertEquals(0, set.size());

        bean.setLengthRange("1２３");
        set = validator.validateProperty(bean, "lengthRange");
        assertEquals(0, set.size());

        bean.setLengthRange("12３４");
        set = validator.validateProperty(bean, "lengthRange");
        assertEquals(0, set.size());

        bean.setLengthRange("12３４５");
        set = validator.validateProperty(bean, "lengthRange");
        assertEquals(1, set.size());

    }

    @Test
    public void testMaxLength() {

        bean.setMaxLength("あいうえお12345");
        Set<ConstraintViolation<Bean>> set = validator.validateProperty(bean, "maxLength");
        assertEquals(0, set.size());

        bean.setMaxLength("あいうえお1234");
        set = validator.validateProperty(bean, "maxLength");
        assertEquals(0, set.size());

        bean.setMaxLength("あいうえお123456");
        set = validator.validateProperty(bean, "maxLength");
        assertEquals(1, set.size());

        bean.setMaxLength("１２３４５６７８９");
        //Set<ConstraintViolation<Bean>> set = validator.validateProperty(bean, "maxLength");
        set = validator.validateProperty(bean, "maxLength");
        assertEquals(0, set.size());

        bean.setMaxLength("１２３４５６７８９０");
        set = validator.validateProperty(bean, "maxLength");
        assertEquals(0, set.size());

        bean.setMaxLength("１２３４５６７８９０１");
        set = validator.validateProperty(bean, "maxLength");
        assertEquals(1, set.size());
        assertEquals("item-id は max 文字以内で入力してください。",
            MessageUtil.getMessage(set.iterator().next().getMessage().substring(1, 8)));

        bean.setMaxLength("123456789");
        set = validator.validateProperty(bean, "maxLength");
        assertEquals(0, set.size());

        bean.setMaxLength("1234567890");
        set = validator.validateProperty(bean, "maxLength");
        assertEquals(0, set.size());

        bean.setMaxLength("12345678901");
        set = validator.validateProperty(bean, "maxLength");
        assertEquals(1, set.size());

        bean.setMaxLength("12345６７８９");
        set = validator.validateProperty(bean, "maxLength");
        assertEquals(0, set.size());

        bean.setMaxLength("12345６７８９０");
        set = validator.validateProperty(bean, "maxLength");
        assertEquals(0, set.size());

        bean.setMaxLength("12345６７８９０１");
        set = validator.validateProperty(bean, "maxLength");
        assertEquals(1, set.size());

    }

    @Test
    public void testMinLength() {

        bean.setMinLength("１２３４");
        Set<ConstraintViolation<Bean>> set = validator.validateProperty(bean, "minLength");
        assertEquals(1, set.size());
        assertEquals("item-id は 桁数 文字以上で入力してください。",
            MessageUtil.getMessage(set.iterator().next().getMessage().substring(1, 8)));

        bean.setMinLength("１２３４５");
        set = validator.validateProperty(bean, "minLength");
        assertEquals(0, set.size());

        bean.setMinLength("１２３４５６");
        set = validator.validateProperty(bean, "minLength");
        assertEquals(0, set.size());

        bean.setMinLength("1234");
        set = validator.validateProperty(bean, "minLength");
        assertEquals(1, set.size());

        bean.setMinLength("12345");
        set = validator.validateProperty(bean, "minLength");
        assertEquals(0, set.size());

        bean.setMinLength("123456");
        set = validator.validateProperty(bean, "minLength");
        assertEquals(0, set.size());

        bean.setMinLength("12３４");
        set = validator.validateProperty(bean, "minLength");
        assertEquals(1, set.size());

        bean.setMinLength("12３４５");
        set = validator.validateProperty(bean, "minLength");
        assertEquals(0, set.size());

        bean.setMinLength("12３４５６");
        set = validator.validateProperty(bean, "minLength");
        assertEquals(0, set.size());

    }

    @Test
    public void testValidTextArea() {
        bean.setValidTextArea(
            "１２３４５\n"
                + "１２３４５\n"
                + "１２３４５");
        Set<ConstraintViolation<Bean>> set = validator.validateProperty(bean, "validTextArea");
        assertEquals(0, set.size());

        bean.setValidTextArea(
            "１２３４５\n"
                + "１２３４\n"
                + "１２３４５");
        set = validator.validateProperty(bean, "validTextArea");
        assertEquals(0, set.size());

        bean.setValidTextArea(
            "１２３４５\n"
                + "１２３４５６\n"
                + "１２３４５");
        set = validator.validateProperty(bean, "validTextArea");
        assertEquals(1, set.size());
        assertEquals("item-idはrows行以内、１行内の文字数を桁数以内で入力してください。",
            MessageUtil.getMessage(set.iterator().next().getMessage().substring(1, 8)));

        bean.setValidTextArea(
            "１２３４５\n"
                + "１２３４５\n"
                + "１２３４５\n"
                + "１２３４５");
        set = validator.validateProperty(bean, "validTextArea");
        assertEquals(1, set.size());

        bean.setValidTextArea(
            "12345\n"
                + "12345\n"
                + "12345");
        set = validator.validateProperty(bean, "validTextArea");
        assertEquals(0, set.size());

        bean.setValidTextArea(
            "12345\n"
                + "1234\n"
                + "12345");
        set = validator.validateProperty(bean, "validTextArea");
        assertEquals(0, set.size());

        bean.setValidTextArea(
            "12345\n"
                + "123456\n"
                + "12345");
        set = validator.validateProperty(bean, "validTextArea");
        assertEquals(1, set.size());

        bean.setValidTextArea(
            "12345\n"
                + "12345\n"
                + "12345\n"
                + "12345");
        set = validator.validateProperty(bean, "validTextArea");
        assertEquals(1, set.size());

    }

    @Test
    public void testDigit() {

        bean.setDigit("0001");
        Set<ConstraintViolation<Bean>> set = validator.validateProperty(bean, "digit");
        assertEquals(0, set.size());

        bean.setDigit("1234");
        set = validator.validateProperty(bean, "digit");
        assertEquals(0, set.size());

        bean.setDigit("123a");
        set = validator.validateProperty(bean, "digit");
        assertEquals(1, set.size());
        assertEquals("item-id は数字のみで入力してください。",
            MessageUtil.getMessage(set.iterator().next().getMessage().substring(1, 8)));

        bean.setDigit("123あ");
        set = validator.validateProperty(bean, "digit");
        assertEquals(1, set.size());

        bean.setDigit("123ｱ");
        set = validator.validateProperty(bean, "digit");
        assertEquals(1, set.size());

        bean.setDigit("123ア");
        set = validator.validateProperty(bean, "digit");
        assertEquals(1, set.size());

        bean.setDigit("123亜");
        set = validator.validateProperty(bean, "digit");
        assertEquals(1, set.size());

        bean.setDigit("123=");
        set = validator.validateProperty(bean, "digit");
        assertEquals(1, set.size());

        bean.setDigit("-1234");
        set = validator.validateProperty(bean, "digit");
        assertEquals(1, set.size());

    }

    @Test
    public void testKinyuukikankanatyekku() {

        bean.setKinyuukikankanatyekku("アイツヤユヨバパヴヲン’（）＋－，．／：？ＡＢＣ１２３");
        Set<ConstraintViolation<Bean>> set = validator.validateProperty(bean, "kinyuukikankanatyekku");
        assertEquals(0, set.size());

        bean.setKinyuukikankanatyekku("A");
        set = validator.validateProperty(bean, "kinyuukikankanatyekku");
        assertEquals(1, set.size());
        assertEquals("item-id は全角カナ文字、英数字、または以下のいずれかの記号　’（）＋－，．／：？　で入力してください。",
            MessageUtil.getMessage(set.iterator().next().getMessage().substring(1, 8)));

        bean.setKinyuukikankanatyekku("ａ");
        set = validator.validateProperty(bean, "kinyuukikankanatyekku");
        assertEquals(1, set.size());

        bean.setKinyuukikankanatyekku("あ");
        set = validator.validateProperty(bean, "kinyuukikankanatyekku");
        assertEquals(1, set.size());

        bean.setKinyuukikankanatyekku("亜");
        set = validator.validateProperty(bean, "kinyuukikankanatyekku");
        assertEquals(1, set.size());

        bean.setKinyuukikankanatyekku("＠");
        set = validator.validateProperty(bean, "kinyuukikankanatyekku");
        assertEquals(1, set.size());

        bean.setKinyuukikankanatyekku("￥");
        set = validator.validateProperty(bean, "kinyuukikankanatyekku");
        assertEquals(1, set.size());

        bean.setKinyuukikankanatyekku("！");
        set = validator.validateProperty(bean, "kinyuukikankanatyekku");
        assertEquals(1, set.size());

        bean.setKinyuukikankanatyekku("”");
        set = validator.validateProperty(bean, "kinyuukikankanatyekku");
        assertEquals(1, set.size());

        bean.setKinyuukikankanatyekku("＃");
        set = validator.validateProperty(bean, "kinyuukikankanatyekku");
        assertEquals(1, set.size());

        bean.setKinyuukikankanatyekku("＄");
        set = validator.validateProperty(bean, "kinyuukikankanatyekku");
        assertEquals(1, set.size());

        bean.setKinyuukikankanatyekku("％");
        set = validator.validateProperty(bean, "kinyuukikankanatyekku");
        assertEquals(1, set.size());

        bean.setKinyuukikankanatyekku("＆");
        set = validator.validateProperty(bean, "kinyuukikankanatyekku");
        assertEquals(1, set.size());

        bean.setKinyuukikankanatyekku("ッ");
        set = validator.validateProperty(bean, "kinyuukikankanatyekku");
        assertEquals(1, set.size());

        bean.setKinyuukikankanatyekku("ァ");
        set = validator.validateProperty(bean, "kinyuukikankanatyekku");
        assertEquals(1, set.size());

        bean.setKinyuukikankanatyekku("ィ");
        set = validator.validateProperty(bean, "kinyuukikankanatyekku");
        assertEquals(1, set.size());

        bean.setKinyuukikankanatyekku("ゥ");
        set = validator.validateProperty(bean, "kinyuukikankanatyekku");
        assertEquals(1, set.size());

        bean.setKinyuukikankanatyekku("ェ");
        set = validator.validateProperty(bean, "kinyuukikankanatyekku");
        assertEquals(1, set.size());

        bean.setKinyuukikankanatyekku("ォ");
        set = validator.validateProperty(bean, "kinyuukikankanatyekku");
        assertEquals(1, set.size());

        bean.setKinyuukikankanatyekku("ャ");
        set = validator.validateProperty(bean, "kinyuukikankanatyekku");
        assertEquals(1, set.size());

        bean.setKinyuukikankanatyekku("ュ");
        set = validator.validateProperty(bean, "kinyuukikankanatyekku");
        assertEquals(1, set.size());

        bean.setKinyuukikankanatyekku("ョ");
        set = validator.validateProperty(bean, "kinyuukikankanatyekku");
        assertEquals(1, set.size());

    }

    @Test
    public void testMailAddress() {

        bean.setMailAddress("abc12AB!#$%&'*+/=?^_{}\\~-@co.jp");
        Set<ConstraintViolation<Bean>> set = validator.validateProperty(bean, "mailAddress");
        assertEquals(0, set.size());

        bean.setMailAddress("a.@co.jp");
        set = validator.validateProperty(bean, "mailAddress");
        assertEquals(0, set.size());

        bean.setMailAddress("a.@slcs.co.jp");
        set = validator.validateProperty(bean, "mailAddress");
        assertEquals(0, set.size());

        bean.setMailAddress("a.b@co.jp");
        set = validator.validateProperty(bean, "mailAddress");
        assertEquals(0, set.size());

        bean.setMailAddress("a.あ@co.jp");
        set = validator.validateProperty(bean, "mailAddress");
        assertEquals(1, set.size());
        assertEquals("item-id はメールアドレスとして適切な値で入力してください。",
            MessageUtil.getMessage(set.iterator().next().getMessage().substring(1, 8)));

        bean.setMailAddress("a.ｱ@co.jp");
        set = validator.validateProperty(bean, "mailAddress");
        assertEquals(1, set.size());

        bean.setMailAddress("a.ア@co.jp");
        set = validator.validateProperty(bean, "mailAddress");
        assertEquals(1, set.size());

        bean.setMailAddress("a.亜@co.jp");
        set = validator.validateProperty(bean, "mailAddress");
        assertEquals(1, set.size());

        bean.setMailAddress("a.「@co.jp");
        set = validator.validateProperty(bean, "mailAddress");
        assertEquals(1, set.size());

        bean.setMailAddress(".a@co.jp");
        set = validator.validateProperty(bean, "mailAddress");
        assertEquals(1, set.size());

        bean.setMailAddress("abc@12ABab-.jp");
        set = validator.validateProperty(bean, "mailAddress");
        assertEquals(0, set.size());

        bean.setMailAddress("abc@1.jp");
        set = validator.validateProperty(bean, "mailAddress");
        assertEquals(0, set.size());

        bean.setMailAddress("abＣ@1.jp");
        set = validator.validateProperty(bean, "mailAddress");
        assertEquals(1, set.size());

        bean.setMailAddress("abc@１.jp");
        set = validator.validateProperty(bean, "mailAddress");
        assertEquals(1, set.size());

        bean.setMailAddress("abc@1.jｐ");
        set = validator.validateProperty(bean, "mailAddress");
        assertEquals(1, set.size());

        bean.setMailAddress("abc@1あ.jp");
        set = validator.validateProperty(bean, "mailAddress");
        assertEquals(1, set.size());

        bean.setMailAddress("abc@1ア.jp");
        set = validator.validateProperty(bean, "mailAddress");
        assertEquals(1, set.size());

        bean.setMailAddress("abc@1ｱ.jp");
        set = validator.validateProperty(bean, "mailAddress");
        assertEquals(1, set.size());

        bean.setMailAddress("abc@1亜.jp");
        set = validator.validateProperty(bean, "mailAddress");
        assertEquals(1, set.size());

        bean.setMailAddress("abc@1=.jp");
        set = validator.validateProperty(bean, "mailAddress");
        assertEquals(1, set.size());

        bean.setMailAddress("abc@1.jp12ABab-");
        set = validator.validateProperty(bean, "mailAddress");
        assertEquals(0, set.size());

        bean.setMailAddress("abc@1.jpあ");
        set = validator.validateProperty(bean, "mailAddress");
        assertEquals(1, set.size());

        bean.setMailAddress("abc@1.jpア");
        set = validator.validateProperty(bean, "mailAddress");
        assertEquals(1, set.size());

        bean.setMailAddress("abc@1.jpｱ");
        set = validator.validateProperty(bean, "mailAddress");
        assertEquals(1, set.size());

        bean.setMailAddress("abc@1.jp亜");
        set = validator.validateProperty(bean, "mailAddress");
        assertEquals(1, set.size());

        bean.setMailAddress("abc@1.jp=");
        set = validator.validateProperty(bean, "mailAddress");
        assertEquals(1, set.size());

        bean.setMailAddress("abc@c-.jp");
        set = validator.validateProperty(bean, "mailAddress");
        assertEquals(0, set.size());

        bean.setMailAddress("abc@-c.jp");
        set = validator.validateProperty(bean, "mailAddress");
        assertEquals(1, set.size());

        bean.setMailAddress("abc@c.-jp");
        set = validator.validateProperty(bean, "mailAddress");
        assertEquals(1, set.size());

        bean.setMailAddress("abc@c-..jp");
        set = validator.validateProperty(bean, "mailAddress");
        assertEquals(1, set.size());

        bean.setMailAddress("abc@c-jp");
        set = validator.validateProperty(bean, "mailAddress");
        assertEquals(1, set.size());

        bean.setMailAddress("abcc-.jp");
        set = validator.validateProperty(bean, "mailAddress");
        assertEquals(1, set.size());

        bean.setMailAddress("abc@@c-.jp");
        set = validator.validateProperty(bean, "mailAddress");
        assertEquals(1, set.size());

        bean.setMailAddress("abc@c-.");
        set = validator.validateProperty(bean, "mailAddress");
        assertEquals(1, set.size());

    }

    @Test
    public void testZipCode() {

        bean.setZipCode("1000001");
        Set<ConstraintViolation<Bean>> set = validator.validateProperty(bean, "zipCode");
        assertEquals(0, set.size());

        bean.setZipCode("10000010");
        set = validator.validateProperty(bean, "zipCode");
        assertEquals(1, set.size());
        assertEquals("item-idは正しい郵便番号を入力してください。",
            MessageUtil.getMessage(set.iterator().next().getMessage().substring(1, 8)));

        bean.setZipCode("100-0001");
        set = validator.validateProperty(bean, "zipCode");
        assertEquals(0, set.size());

        bean.setZipCode("10-0001");
        set = validator.validateProperty(bean, "zipCode");
        assertEquals(1, set.size());

        bean.setZipCode("1000-0001");
        set = validator.validateProperty(bean, "zipCode");
        assertEquals(1, set.size());

        bean.setZipCode("100-000");
        set = validator.validateProperty(bean, "zipCode");
        assertEquals(1, set.size());

        bean.setZipCode("100-00010");
        set = validator.validateProperty(bean, "zipCode");
        assertEquals(1, set.size());

        bean.setZipCode("100000a");
        set = validator.validateProperty(bean, "zipCode");
        assertEquals(1, set.size());

        bean.setZipCode("100000Ａ");
        set = validator.validateProperty(bean, "zipCode");
        assertEquals(1, set.size());

        bean.setZipCode("100000あ");
        set = validator.validateProperty(bean, "zipCode");
        assertEquals(1, set.size());

        bean.setZipCode("100000ｱ");
        set = validator.validateProperty(bean, "zipCode");
        assertEquals(1, set.size());

        bean.setZipCode("100000ア");
        set = validator.validateProperty(bean, "zipCode");
        assertEquals(1, set.size());

        bean.setZipCode("100000亜");
        set = validator.validateProperty(bean, "zipCode");
        assertEquals(1, set.size());

        bean.setZipCode("100000=");
        set = validator.validateProperty(bean, "zipCode");
        assertEquals(1, set.size());

    }

    @Test
    public void testTel() {

        bean.setTel("01-2345-6789");
        Set<ConstraintViolation<Bean>> set = validator.validateProperty(bean, "tel");
        assertEquals(0, set.size());

        bean.setTel("12-3456-7890");
        set = validator.validateProperty(bean, "tel");
        assertEquals(1, set.size());
        assertEquals("item-id は電話番号として適切な値で入力してください。",
            MessageUtil.getMessage(set.iterator().next().getMessage().substring(1, 8)));

        bean.setTel("01-23456-7890");
        set = validator.validateProperty(bean, "tel");
        assertEquals(1, set.size());
        assertEquals("item-id は電話番号として適切な値で入力してください。",
            MessageUtil.getMessage(set.iterator().next().getMessage().substring(1, 8)));

        bean.setTel("01-234-5678");
        set = validator.validateProperty(bean, "tel");
        assertEquals(1, set.size());

        bean.setTel("01-2345-678");
        set = validator.validateProperty(bean, "tel");
        assertEquals(1, set.size());

        bean.setTel("01-2345-67890");
        set = validator.validateProperty(bean, "tel");
        assertEquals(1, set.size());

        bean.setTel("012-345-6789");
        set = validator.validateProperty(bean, "tel");
        assertEquals(0, set.size());

        bean.setTel("012-34-5678");
        set = validator.validateProperty(bean, "tel");
        assertEquals(1, set.size());

        bean.setTel("012-3456-7890");
        set = validator.validateProperty(bean, "tel");
        assertEquals(0, set.size());

        bean.setTel("012-345-678");
        set = validator.validateProperty(bean, "tel");
        assertEquals(1, set.size());

        bean.setTel("012-345-67890");
        set = validator.validateProperty(bean, "tel");
        assertEquals(0, set.size());

        bean.setTel("0123-45-6789");
        set = validator.validateProperty(bean, "tel");
        assertEquals(0, set.size());

        bean.setTel("0123-456-7890");
        set = validator.validateProperty(bean, "tel");
        assertEquals(0, set.size());

        bean.setTel("0123-4-5678");
        set = validator.validateProperty(bean, "tel");
        assertEquals(1, set.size());

        bean.setTel("0123-45-678");
        set = validator.validateProperty(bean, "tel");
        assertEquals(1, set.size());

        bean.setTel("0123-45-67890");
        set = validator.validateProperty(bean, "tel");
        assertEquals(1, set.size());

        bean.setTel("01234-5-6789");
        set = validator.validateProperty(bean, "tel");
        assertEquals(0, set.size());

        bean.setTel("01234-56-7890");
        set = validator.validateProperty(bean, "tel");
        assertEquals(1, set.size());

        bean.setTel("01234-5-678");
        set = validator.validateProperty(bean, "tel");
        assertEquals(1, set.size());

        bean.setTel("01234-5-67890");
        set = validator.validateProperty(bean, "tel");
        assertEquals(1, set.size());

        bean.setTel("020-123-45678");
        set = validator.validateProperty(bean, "tel");
        assertEquals(0, set.size());

        bean.setTel("020-1234-56789");
        set = validator.validateProperty(bean, "tel");
        assertEquals(1, set.size());

        bean.setTel("020-12-34567");
        set = validator.validateProperty(bean, "tel");
        assertEquals(1, set.size());

        bean.setTel("020-123-4567");
        set = validator.validateProperty(bean, "tel");
        assertEquals(0, set.size());

        bean.setTel("020-123-456789");
        set = validator.validateProperty(bean, "tel");
        assertEquals(1, set.size());

        bean.setTel("020-1234-5678");
        set = validator.validateProperty(bean, "tel");
        assertEquals(0, set.size());

        bean.setTel("020-123-4567");
        set = validator.validateProperty(bean, "tel");
        assertEquals(0, set.size());

        bean.setTel("020-12345-6789");
        set = validator.validateProperty(bean, "tel");
        assertEquals(1, set.size());

        bean.setTel("020-1234-567");
        set = validator.validateProperty(bean, "tel");
        assertEquals(1, set.size());

        bean.setTel("020-1234-56789");
        set = validator.validateProperty(bean, "tel");
        assertEquals(1, set.size());

        bean.setTel("050-123-45678");
        set = validator.validateProperty(bean, "tel");
        assertEquals(0, set.size());

        bean.setTel("050-1234-56789");
        set = validator.validateProperty(bean, "tel");
        assertEquals(1, set.size());

        bean.setTel("050-12-34567");
        set = validator.validateProperty(bean, "tel");
        assertEquals(1, set.size());

        bean.setTel("050-123-4567");
        set = validator.validateProperty(bean, "tel");
        assertEquals(0, set.size());

        bean.setTel("050-123-456789");
        set = validator.validateProperty(bean, "tel");
        assertEquals(1, set.size());

        bean.setTel("050-1234-5678");
        set = validator.validateProperty(bean, "tel");
        assertEquals(0, set.size());

        bean.setTel("050-123-4567");
        set = validator.validateProperty(bean, "tel");
        assertEquals(0, set.size());

        bean.setTel("050-12345-6789");
        set = validator.validateProperty(bean, "tel");
        assertEquals(1, set.size());

        bean.setTel("050-1234-567");
        set = validator.validateProperty(bean, "tel");
        assertEquals(1, set.size());

        bean.setTel("050-1234-56789");
        set = validator.validateProperty(bean, "tel");
        assertEquals(1, set.size());

        bean.setTel("060-123-45678");
        set = validator.validateProperty(bean, "tel");
        assertEquals(0, set.size());

        bean.setTel("060-1234-56789");
        set = validator.validateProperty(bean, "tel");
        assertEquals(1, set.size());

        bean.setTel("060-12-34567");
        set = validator.validateProperty(bean, "tel");
        assertEquals(1, set.size());

        bean.setTel("060-123-4567");
        set = validator.validateProperty(bean, "tel");
        assertEquals(0, set.size());

        bean.setTel("060-123-456789");
        set = validator.validateProperty(bean, "tel");
        assertEquals(1, set.size());

        bean.setTel("060-1234-5678");
        set = validator.validateProperty(bean, "tel");
        assertEquals(0, set.size());

        bean.setTel("060-123-4567");
        set = validator.validateProperty(bean, "tel");
        assertEquals(0, set.size());

        bean.setTel("060-12345-6789");
        set = validator.validateProperty(bean, "tel");
        assertEquals(1, set.size());

        bean.setTel("060-1234-567");
        set = validator.validateProperty(bean, "tel");
        assertEquals(1, set.size());

        bean.setTel("060-1234-56789");
        set = validator.validateProperty(bean, "tel");
        assertEquals(1, set.size());

        bean.setTel("070-123-45678");
        set = validator.validateProperty(bean, "tel");
        assertEquals(0, set.size());

        bean.setTel("070-1234-56789");
        set = validator.validateProperty(bean, "tel");
        assertEquals(1, set.size());

        bean.setTel("070-12-34567");
        set = validator.validateProperty(bean, "tel");
        assertEquals(1, set.size());

        bean.setTel("070-123-4567");
        set = validator.validateProperty(bean, "tel");
        assertEquals(0, set.size());

        bean.setTel("070-123-456789");
        set = validator.validateProperty(bean, "tel");
        assertEquals(1, set.size());

        bean.setTel("070-1234-5678");
        set = validator.validateProperty(bean, "tel");
        assertEquals(0, set.size());

        bean.setTel("070-123-4567");
        set = validator.validateProperty(bean, "tel");
        assertEquals(0, set.size());

        bean.setTel("070-12345-6789");
        set = validator.validateProperty(bean, "tel");
        assertEquals(1, set.size());

        bean.setTel("070-1234-567");
        set = validator.validateProperty(bean, "tel");
        assertEquals(1, set.size());

        bean.setTel("070-1234-56789");
        set = validator.validateProperty(bean, "tel");
        assertEquals(1, set.size());

        bean.setTel("080-123-45678");
        set = validator.validateProperty(bean, "tel");
        assertEquals(0, set.size());

        bean.setTel("080-1234-56789");
        set = validator.validateProperty(bean, "tel");
        assertEquals(1, set.size());

        bean.setTel("080-12-34567");
        set = validator.validateProperty(bean, "tel");
        assertEquals(1, set.size());

        bean.setTel("080-123-4567");
        set = validator.validateProperty(bean, "tel");
        assertEquals(0, set.size());

        bean.setTel("080-123-456789");
        set = validator.validateProperty(bean, "tel");
        assertEquals(1, set.size());

        bean.setTel("080-1234-5678");
        set = validator.validateProperty(bean, "tel");
        assertEquals(0, set.size());

        bean.setTel("080-123-4567");
        set = validator.validateProperty(bean, "tel");
        assertEquals(0, set.size());

        bean.setTel("080-12345-6789");
        set = validator.validateProperty(bean, "tel");
        assertEquals(1, set.size());

        bean.setTel("080-1234-567");
        set = validator.validateProperty(bean, "tel");
        assertEquals(1, set.size());

        bean.setTel("080-1234-56789");
        set = validator.validateProperty(bean, "tel");
        assertEquals(1, set.size());

        bean.setTel("090-123-45678");
        set = validator.validateProperty(bean, "tel");
        assertEquals(0, set.size());

        bean.setTel("090-1234-56789");
        set = validator.validateProperty(bean, "tel");
        assertEquals(1, set.size());

        bean.setTel("090-12-34567");
        set = validator.validateProperty(bean, "tel");
        assertEquals(1, set.size());

        bean.setTel("090-123-4567");
        set = validator.validateProperty(bean, "tel");
        assertEquals(0, set.size());

        bean.setTel("090-123-456789");
        set = validator.validateProperty(bean, "tel");
        assertEquals(1, set.size());

        bean.setTel("090-1234-5678");
        set = validator.validateProperty(bean, "tel");
        assertEquals(0, set.size());

        bean.setTel("090-123-4567");
        set = validator.validateProperty(bean, "tel");
        assertEquals(0, set.size());

        bean.setTel("090-12345-6789");
        set = validator.validateProperty(bean, "tel");
        assertEquals(1, set.size());

        bean.setTel("090-1234-567");
        set = validator.validateProperty(bean, "tel");
        assertEquals(1, set.size());

        bean.setTel("090-1234-56789");
        set = validator.validateProperty(bean, "tel");
        assertEquals(1, set.size());

        bean.setTel("0120-123-456");
        set = validator.validateProperty(bean, "tel");
        assertEquals(0, set.size());

        bean.setTel("0120-123-4567");
        set = validator.validateProperty(bean, "tel");
        assertEquals(0, set.size());

        bean.setTel("0120-123-45");
        set = validator.validateProperty(bean, "tel");
        assertEquals(1, set.size());

        bean.setTel("0120-1234-567");
        set = validator.validateProperty(bean, "tel");
        assertEquals(1, set.size());

        bean.setTel("0120-12-345");
        set = validator.validateProperty(bean, "tel");
        assertEquals(1, set.size());

        bean.setTel("0800-123-4567");
        set = validator.validateProperty(bean, "tel");
        assertEquals(0, set.size());

        bean.setTel("0800-123-456");
        set = validator.validateProperty(bean, "tel");
        assertEquals(0, set.size());

        bean.setTel("0800-123-45678");
        set = validator.validateProperty(bean, "tel");
        assertEquals(1, set.size());

        bean.setTel("0800-12-3456");
        set = validator.validateProperty(bean, "tel");
        assertEquals(0, set.size());

        bean.setTel("0800-1234-5678");
        set = validator.validateProperty(bean, "tel");
        assertEquals(1, set.size());

        bean.setTel("0570-123-456");
        set = validator.validateProperty(bean, "tel");
        assertEquals(0, set.size());

        bean.setTel("0570-123-4567");
        set = validator.validateProperty(bean, "tel");
        assertEquals(0, set.size());

        bean.setTel("0570-123-45");
        set = validator.validateProperty(bean, "tel");
        assertEquals(1, set.size());

        bean.setTel("0570-1234-567");
        set = validator.validateProperty(bean, "tel");
        assertEquals(1, set.size());

        bean.setTel("0570-12-345");
        set = validator.validateProperty(bean, "tel");
        assertEquals(1, set.size());

        bean.setTel("0990-123-456");
        set = validator.validateProperty(bean, "tel");
        assertEquals(0, set.size());

        bean.setTel("0990-123-4567");
        set = validator.validateProperty(bean, "tel");
        assertEquals(0, set.size());

        bean.setTel("0990-123-45");
        set = validator.validateProperty(bean, "tel");
        assertEquals(1, set.size());

        bean.setTel("0990-1234-567");
        set = validator.validateProperty(bean, "tel");
        assertEquals(1, set.size());

        bean.setTel("0990-12-345");
        set = validator.validateProperty(bean, "tel");
        assertEquals(1, set.size());

        bean.setTel("01234-56789");
        set = validator.validateProperty(bean, "tel");
        assertEquals(1, set.size());

        bean.setTel("0123456789");
        set = validator.validateProperty(bean, "tel");
        assertEquals(1, set.size());

        bean.setTel("01234-567890");
        set = validator.validateProperty(bean, "tel");
        assertEquals(1, set.size());

        bean.setTel("01234567890");
        set = validator.validateProperty(bean, "tel");
        assertEquals(1, set.size());

        bean.setTel("01-2345-678a");
        set = validator.validateProperty(bean, "tel");
        assertEquals(1, set.size());

        bean.setTel("01-234Ａ-5678");
        set = validator.validateProperty(bean, "tel");
        assertEquals(1, set.size());

        bean.setTel("0=-1234-5678");
        set = validator.validateProperty(bean, "tel");
        assertEquals(1, set.size());

        bean.setTel("01-2345-6あ78");
        set = validator.validateProperty(bean, "tel");
        assertEquals(1, set.size());

        bean.setTel("01-23ｱ4-5678");
        set = validator.validateProperty(bean, "tel");
        assertEquals(1, set.size());

        bean.setTel("01-2345-ア678");
        set = validator.validateProperty(bean, "tel");
        assertEquals(1, set.size());

        bean.setTel("01-亜234-5678");
        set = validator.validateProperty(bean, "tel");
        assertEquals(1, set.size());

        bean.setTel("03-1234-5678");
        set = validator.validateProperty(bean, "tel");
        assertEquals(0, set.size());

        bean.setTel("13-1234-5678");
        set = validator.validateProperty(bean, "tel");
        assertEquals(1, set.size());

        bean.setTel("011-123-4567");
        set = validator.validateProperty(bean, "tel");
        assertEquals(0, set.size());

        bean.setTel("111-123-4567");
        set = validator.validateProperty(bean, "tel");
        assertEquals(1, set.size());

        bean.setTel("0123-12-3456");
        set = validator.validateProperty(bean, "tel");
        assertEquals(0, set.size());

        bean.setTel("1123-12-3456");
        set = validator.validateProperty(bean, "tel");
        assertEquals(1, set.size());

        bean.setTel("01267-1-2345");
        set = validator.validateProperty(bean, "tel");
        assertEquals(0, set.size());

        bean.setTel("11267-1-2345");
        set = validator.validateProperty(bean, "tel");
        assertEquals(1, set.size());

        bean.setTel("090-123-45678");
        set = validator.validateProperty(bean, "tel");
        assertEquals(0, set.size());

        bean.setTel("190-123-45678");
        set = validator.validateProperty(bean, "tel");
        assertEquals(1, set.size());

        bean.setTel("080-1234-5678");
        set = validator.validateProperty(bean, "tel");
        assertEquals(0, set.size());

        bean.setTel("180-1234-5678");
        set = validator.validateProperty(bean, "tel");
        assertEquals(1, set.size());

        bean.setTel("0120-123-456");
        set = validator.validateProperty(bean, "tel");
        assertEquals(0, set.size());

        bean.setTel("1120-123-456");
        set = validator.validateProperty(bean, "tel");
        assertEquals(1, set.size());

        bean.setTel("0120-123-4567");
        set = validator.validateProperty(bean, "tel");
        assertEquals(0, set.size());

        bean.setTel("1120-123-4567");
        set = validator.validateProperty(bean, "tel");
        assertEquals(1, set.size());

    }

    @Test
    public void testNenkinsyousyoBangou() {

        bean.setNenkinsyousyoBangou("a");
        Set<ConstraintViolation<Bean>> set = validator.validateProperty(bean, "nenkinsyousyoBangou");
        assertEquals(0, set.size());

        bean.setNenkinsyousyoBangou("a123456789");
        set = validator.validateProperty(bean, "nenkinsyousyoBangou");
        assertEquals(0, set.size());

        bean.setNenkinsyousyoBangou("a1234567890");
        set = validator.validateProperty(bean, "nenkinsyousyoBangou");
        assertEquals(0, set.size());

        bean.setNenkinsyousyoBangou("a12345678901");
        set = validator.validateProperty(bean, "nenkinsyousyoBangou");
        assertEquals(1, set.size());
        assertEquals("正しい0を入力してください。",
            MessageUtil.getMessage(set.iterator().next().getMessage().substring(1, 8)));

        bean.setNenkinsyousyoBangou("ａ1234567890");
        set = validator.validateProperty(bean, "nenkinsyousyoBangou");
        assertEquals(1, set.size());

        bean.setNenkinsyousyoBangou("a123456789０");
        set = validator.validateProperty(bean, "nenkinsyousyoBangou");
        assertEquals(1, set.size());

        bean.setNenkinsyousyoBangou("a123456789=");
        set = validator.validateProperty(bean, "nenkinsyousyoBangou");
        assertEquals(1, set.size());

        bean.setNenkinsyousyoBangou("a123456789あ");
        set = validator.validateProperty(bean, "nenkinsyousyoBangou");
        assertEquals(1, set.size());

        bean.setNenkinsyousyoBangou("a123456789ｱ");
        set = validator.validateProperty(bean, "nenkinsyousyoBangou");
        assertEquals(1, set.size());

        bean.setNenkinsyousyoBangou("a123456789ア");
        set = validator.validateProperty(bean, "nenkinsyousyoBangou");
        assertEquals(1, set.size());

        bean.setNenkinsyousyoBangou("a123456789亜");
        set = validator.validateProperty(bean, "nenkinsyousyoBangou");
        assertEquals(1, set.size());

    }

    @Test
    public void testSyoukenNo() {

        bean.setSyoukenNo("a");
        Set<ConstraintViolation<Bean>> set = validator.validateProperty(bean, "syoukenNo");
        assertEquals(0, set.size());

        bean.setSyoukenNo("a123456789");
        set = validator.validateProperty(bean, "syoukenNo");
        assertEquals(0, set.size());

        bean.setSyoukenNo("a1234567890");
        set = validator.validateProperty(bean, "syoukenNo");
        assertEquals(0, set.size());

        bean.setSyoukenNo("a12345678901");
        set = validator.validateProperty(bean, "syoukenNo");
        assertEquals(1, set.size());
        assertEquals("正しい0を入力してください。",
            MessageUtil.getMessage(set.iterator().next().getMessage().substring(1, 8)));

        bean.setSyoukenNo("ａ1234567890");
        set = validator.validateProperty(bean, "syoukenNo");
        assertEquals(1, set.size());

        bean.setSyoukenNo("a123456789０");
        set = validator.validateProperty(bean, "syoukenNo");
        assertEquals(1, set.size());

        bean.setSyoukenNo("a123456789=");
        set = validator.validateProperty(bean, "syoukenNo");
        assertEquals(1, set.size());

        bean.setSyoukenNo("a123456789あ");
        set = validator.validateProperty(bean, "syoukenNo");
        assertEquals(1, set.size());

        bean.setSyoukenNo("a123456789ｱ");
        set = validator.validateProperty(bean, "syoukenNo");
        assertEquals(1, set.size());

        bean.setSyoukenNo("a123456789ア");
        set = validator.validateProperty(bean, "syoukenNo");
        assertEquals(1, set.size());

        bean.setSyoukenNo("a123456789亜");
        set = validator.validateProperty(bean, "syoukenNo");
        assertEquals(1, set.size());

    }

    @Test
    public void testSyoukenNo2() {

        bean.setSyoukenNo2("a");
        Set<ConstraintViolation<Bean>> set = validator.validateProperty(bean, "syoukenNo2");
        assertEquals(0, set.size());

        bean.setSyoukenNo2("a123456789");
        set = validator.validateProperty(bean, "syoukenNo2");
        assertEquals(0, set.size());

        bean.setSyoukenNo2("a1234567890");
        set = validator.validateProperty(bean, "syoukenNo2");
        assertEquals(0, set.size());

        bean.setSyoukenNo2("a12345678901");
        set = validator.validateProperty(bean, "syoukenNo2");
        assertEquals(0, set.size());
        //assertEquals("正しい0を入力してください。",
        //        MessageUtil.getMessage(set.iterator().next().getMessage().substring(1, 8)));

        bean.setSyoukenNo2("ａ1234567890");
        set = validator.validateProperty(bean, "syoukenNo2");
        assertEquals(0, set.size());

        bean.setSyoukenNo2("a123456789０");
        set = validator.validateProperty(bean, "syoukenNo2");
        assertEquals(0, set.size());

        bean.setSyoukenNo2("a123456789=");
        set = validator.validateProperty(bean, "syoukenNo2");
        assertEquals(0, set.size());

        bean.setSyoukenNo2("a123456789あ");
        set = validator.validateProperty(bean, "syoukenNo2");
        assertEquals(0, set.size());

        bean.setSyoukenNo2("a123456789ｱ");
        set = validator.validateProperty(bean, "syoukenNo2");
        assertEquals(0, set.size());

        bean.setSyoukenNo2("a123456789ア");
        set = validator.validateProperty(bean, "syoukenNo2");
        assertEquals(0, set.size());

        bean.setSyoukenNo2("a123456789亜");
        set = validator.validateProperty(bean, "syoukenNo2");
        assertEquals(0, set.size());

    }

    @Test
    public void testNonZero() {

        bean.setDoubleNonZero(new Double(0));
        Set<ConstraintViolation<Bean>> set = validator.validateProperty(bean, "doubleNonZero");
        assertEquals(1, set.size());
        assertEquals("item-id はゼロ以外の数値で入力してください。",
            MessageUtil.getMessage(set.iterator().next().getMessage().substring(1, 8)));

        bean.setDoubleNonZero(new Double(1));
        set = validator.validateProperty(bean, "doubleNonZero");
        assertEquals(0, set.size());

        bean.setDoubleNonZero(new Double(0.5));
        set = validator.validateProperty(bean, "doubleNonZero");
        assertEquals(0, set.size());

        bean.setDoubleNonZero(new Double(-0.5));
        set = validator.validateProperty(bean, "doubleNonZero");
        assertEquals(0, set.size());

        bean.setDoubleNonZero(new Double(-1));
        set = validator.validateProperty(bean, "doubleNonZero");
        assertEquals(0, set.size());

        bean.setLongNonZero(new Long(0));
        set = validator.validateProperty(bean, "longNonZero");
        assertEquals(1, set.size());

        bean.setLongNonZero(new Long(1));
        set = validator.validateProperty(bean, "longNonZero");
        assertEquals(0, set.size());

        bean.setLongNonZero(new Long(-1));
        set = validator.validateProperty(bean, "longNonZero");
        assertEquals(0, set.size());

        bean.setIntegerNonZero(new Integer(0));
        set = validator.validateProperty(bean, "integerNonZero");
        assertEquals(1, set.size());

        bean.setIntegerNonZero(new Integer(1));
        set = validator.validateProperty(bean, "integerNonZero");
        assertEquals(0, set.size());

        bean.setIntegerNonZero(new Integer(-1));
        set = validator.validateProperty(bean, "integerNonZero");
        assertEquals(0, set.size());

        bean.setBizCurrencyNonZeroBizCalcable(BizCurrency.valueOf(new BigDecimal("0")));
        set = validator.validateProperty(bean, "bizCurrencyNonZeroBizCalcable");
        assertEquals(1, set.size());

        bean.setBizCurrencyNonZeroBizCalcable(BizCurrency.valueOf(new BigDecimal("1")));
        set = validator.validateProperty(bean, "bizCurrencyNonZeroBizCalcable");
        assertEquals(0, set.size());

        bean.setBizCurrencyNonZeroBizCalcable(BizCurrency.valueOf(new BigDecimal("0.5")));
        set = validator.validateProperty(bean, "bizCurrencyNonZeroBizCalcable");
        assertEquals(0, set.size());

        bean.setBizCurrencyNonZeroBizCalcable(BizCurrency.valueOf(new BigDecimal("-0.5")));
        set = validator.validateProperty(bean, "bizCurrencyNonZeroBizCalcable");
        assertEquals(0, set.size());

        bean.setBizCurrencyNonZeroBizCalcable(BizCurrency.valueOf(new BigDecimal("-1")));
        set = validator.validateProperty(bean, "bizCurrencyNonZeroBizCalcable");
        assertEquals(0, set.size());

        bean.setBizRateNonZeroBizCalcable(BizRate.valueOf(new BigDecimal("0")));
        set = validator.validateProperty(bean, "bizRateNonZeroBizCalcable");
        assertEquals(1, set.size());

        bean.setBizRateNonZeroBizCalcable(BizRate.valueOf(new BigDecimal("1")));
        set = validator.validateProperty(bean, "bizRateNonZeroBizCalcable");
        assertEquals(0, set.size());

        bean.setBizRateNonZeroBizCalcable(BizRate.valueOf(new BigDecimal("0.5")));
        set = validator.validateProperty(bean, "bizRateNonZeroBizCalcable");
        assertEquals(0, set.size());

        bean.setBizRateNonZeroBizCalcable(BizRate.valueOf(new BigDecimal("-0.5")));
        set = validator.validateProperty(bean, "bizRateNonZeroBizCalcable");
        assertEquals(0, set.size());

        bean.setBizRateNonZeroBizCalcable(BizRate.valueOf(new BigDecimal("-1")));
        set = validator.validateProperty(bean, "bizRateNonZeroBizCalcable");
        assertEquals(0, set.size());

        bean.setBizNumberNonZeroBizCalcable(BizNumber.valueOf(new BigDecimal("0")));
        set = validator.validateProperty(bean, "bizNumberNonZeroBizCalcable");
        assertEquals(1, set.size());

        bean.setBizNumberNonZeroBizCalcable(BizNumber.valueOf(new BigDecimal("1")));
        set = validator.validateProperty(bean, "bizNumberNonZeroBizCalcable");
        assertEquals(0, set.size());

        bean.setBizNumberNonZeroBizCalcable(BizNumber.valueOf(new BigDecimal("0.5")));
        set = validator.validateProperty(bean, "bizNumberNonZeroBizCalcable");
        assertEquals(0, set.size());

        bean.setBizNumberNonZeroBizCalcable(BizNumber.valueOf(new BigDecimal("-0.5")));
        set = validator.validateProperty(bean, "bizNumberNonZeroBizCalcable");
        assertEquals(0, set.size());

        bean.setBizNumberNonZeroBizCalcable(BizNumber.valueOf(new BigDecimal("-1")));
        set = validator.validateProperty(bean, "bizNumberNonZeroBizCalcable");
        assertEquals(0, set.size());

    }

    @Test
    public void testRange() {
        bean.setDoubleRange(new Double(-10.00));
        Set<ConstraintViolation<Bean>> set = validator.validateProperty(bean, "doubleRange");
        assertEquals(1, set.size());
        assertEquals("item-id は min ～ max の範囲で入力してください。",
            MessageUtil.getMessage(set.iterator().next().getMessage().substring(1, 8)));

        bean.setDoubleRange(new Double(-9.99));
        set = validator.validateProperty(bean, "doubleRange");
        assertEquals(0, set.size());

        bean.setDoubleRange(new Double(9.99));
        set = validator.validateProperty(bean, "doubleRange");
        assertEquals(0, set.size());

        bean.setDoubleRange(new Double(10.00));
        set = validator.validateProperty(bean, "doubleRange");
        assertEquals(1, set.size());

        bean.setBizRateRangeBizCalcable(BizRate.valueOf(new BigDecimal("-10.00")));
        set = validator.validateProperty(bean, "bizRateRangeBizCalcable");
        assertEquals(1, set.size());

        bean.setBizRateRangeBizCalcable(BizRate.valueOf(new BigDecimal("-9.99")));
        set = validator.validateProperty(bean, "bizRateRangeBizCalcable");
        assertEquals(0, set.size());

        bean.setBizRateRangeBizCalcable(BizRate.valueOf(new BigDecimal("9.99")));
        set = validator.validateProperty(bean, "bizRateRangeBizCalcable");
        assertEquals(0, set.size());

        bean.setBizRateRangeBizCalcable(BizRate.valueOf(new BigDecimal("10.00")));
        set = validator.validateProperty(bean, "bizRateRangeBizCalcable");
        assertEquals(1, set.size());

        bean.setBizNumberRangeBizCalcable(BizNumber.valueOf(new BigDecimal("-10.00")));
        set = validator.validateProperty(bean, "bizNumberRangeBizCalcable");
        assertEquals(1, set.size());

        bean.setBizNumberRangeBizCalcable(BizNumber.valueOf(new BigDecimal("-9.99")));
        set = validator.validateProperty(bean, "bizNumberRangeBizCalcable");
        assertEquals(0, set.size());

        bean.setBizNumberRangeBizCalcable(BizNumber.valueOf(new BigDecimal("9.99")));
        set = validator.validateProperty(bean, "bizNumberRangeBizCalcable");
        assertEquals(0, set.size());

        bean.setBizNumberRangeBizCalcable(BizNumber.valueOf(new BigDecimal("10.00")));
        set = validator.validateProperty(bean, "bizNumberRangeBizCalcable");
        assertEquals(1, set.size());

        bean.setLongRange(new Long(-10));
        set = validator.validateProperty(bean, "longRange");
        assertEquals(1, set.size());

        bean.setLongRange(new Long(-9));
        set = validator.validateProperty(bean, "longRange");
        assertEquals(0, set.size());

        bean.setLongRange(new Long(9));
        set = validator.validateProperty(bean, "longRange");
        assertEquals(0, set.size());

        bean.setLongRange(new Long(10));
        set = validator.validateProperty(bean, "longRange");
        assertEquals(1, set.size());

        bean.setIntegerRange(new Integer(-10));
        set = validator.validateProperty(bean, "integerRange");
        assertEquals(1, set.size());

        bean.setIntegerRange(new Integer(-9));
        set = validator.validateProperty(bean, "integerRange");
        assertEquals(0, set.size());

        bean.setIntegerRange(new Integer(9));
        set = validator.validateProperty(bean, "integerRange");
        assertEquals(0, set.size());

        bean.setIntegerRange(new Integer(10));
        set = validator.validateProperty(bean, "integerRange");
        assertEquals(1, set.size());

    }

    @Test
    public void testMax() {

        bean.setDoubleMax(new Double(-10.00));
        Set<ConstraintViolation<Bean>> set = validator.validateProperty(bean, "doubleMax");
        assertEquals(0, set.size());

        bean.setDoubleMax(new Double(-9.99));
        set = validator.validateProperty(bean, "doubleMax");
        assertEquals(0, set.size());

        bean.setDoubleMax(new Double(9.99));
        set = validator.validateProperty(bean, "doubleMax");
        assertEquals(0, set.size());

        bean.setDoubleMax(new Double(10.00));
        set = validator.validateProperty(bean, "doubleMax");
        assertEquals(1, set.size());
        assertEquals("item-id は max 桁以下で入力してください。",
            MessageUtil.getMessage(set.iterator().next().getMessage().substring(1, 8)));

        bean.setBizRateMaxBizCalcable(BizRate.valueOf(new BigDecimal("-10.00")));
        set = validator.validateProperty(bean, "bizRateMaxBizCalcable");
        assertEquals(0, set.size());

        bean.setBizRateMaxBizCalcable(BizRate.valueOf(new BigDecimal("-9.99")));
        set = validator.validateProperty(bean, "bizRateMaxBizCalcable");
        assertEquals(0, set.size());

        bean.setBizRateMaxBizCalcable(BizRate.valueOf(new BigDecimal("9.99")));
        set = validator.validateProperty(bean, "bizRateMaxBizCalcable");
        assertEquals(0, set.size());

        bean.setBizRateMaxBizCalcable(BizRate.valueOf(new BigDecimal("10.00")));
        set = validator.validateProperty(bean, "bizRateMaxBizCalcable");
        assertEquals(1, set.size());

        bean.setBizNumberMaxBizCalcable(BizNumber.valueOf(new BigDecimal("-10.00")));
        set = validator.validateProperty(bean, "bizNumberMaxBizCalcable");
        assertEquals(0, set.size());

        bean.setBizNumberMaxBizCalcable(BizNumber.valueOf(new BigDecimal("-9.99")));
        set = validator.validateProperty(bean, "bizNumberMaxBizCalcable");
        assertEquals(0, set.size());

        bean.setBizNumberMaxBizCalcable(BizNumber.valueOf(new BigDecimal("9.99")));
        set = validator.validateProperty(bean, "bizNumberMaxBizCalcable");
        assertEquals(0, set.size());

        bean.setBizNumberMaxBizCalcable(BizNumber.valueOf(new BigDecimal("10.00")));
        set = validator.validateProperty(bean, "bizNumberMaxBizCalcable");
        assertEquals(1, set.size());

        bean.setLongMax(new Long(-10));
        set = validator.validateProperty(bean, "longMax");
        assertEquals(0, set.size());

        bean.setLongMax(new Long(-9));
        set = validator.validateProperty(bean, "longMax");
        assertEquals(0, set.size());

        bean.setLongMax(new Long(9));
        set = validator.validateProperty(bean, "longMax");
        assertEquals(0, set.size());

        bean.setLongMax(new Long(10));
        set = validator.validateProperty(bean, "longMax");
        assertEquals(1, set.size());

        bean.setIntegerMax(new Integer(-10));
        set = validator.validateProperty(bean, "integerMax");
        assertEquals(0, set.size());

        bean.setIntegerMax(new Integer(-9));
        set = validator.validateProperty(bean, "integerMax");
        assertEquals(0, set.size());

        bean.setIntegerMax(new Integer(9));
        set = validator.validateProperty(bean, "integerMax");
        assertEquals(0, set.size());

        bean.setIntegerMax(new Integer(10));
        set = validator.validateProperty(bean, "integerMax");
        assertEquals(1, set.size());

    }

    @Test
    public void testMin() {

        bean.setDoubleMin(new Double(-10.00));
        Set<ConstraintViolation<Bean>> set = validator.validateProperty(bean, "doubleMin");
        assertEquals(1, set.size());
        assertEquals("item-id は min 桁以上で入力してください。",
            MessageUtil.getMessage(set.iterator().next().getMessage().substring(1, 8)));

        bean.setDoubleMin(new Double(-9.99));
        set = validator.validateProperty(bean, "doubleMin");
        assertEquals(1, set.size());

        bean.setDoubleMin(new Double(9.99));
        set = validator.validateProperty(bean, "doubleMin");
        assertEquals(0, set.size());

        bean.setDoubleMin(new Double(10.00));
        set = validator.validateProperty(bean, "doubleMin");
        assertEquals(0, set.size());

        bean.setBizRateMinBizCalcable(BizRate.valueOf(new BigDecimal("-10.00")));
        set = validator.validateProperty(bean, "bizRateMinBizCalcable");
        assertEquals(1, set.size());

        bean.setBizRateMinBizCalcable(BizRate.valueOf(new BigDecimal("-9.99")));
        set = validator.validateProperty(bean, "bizRateMinBizCalcable");
        assertEquals(1, set.size());

        bean.setBizRateMinBizCalcable(BizRate.valueOf(new BigDecimal("9.99")));
        set = validator.validateProperty(bean, "bizRateMinBizCalcable");
        assertEquals(0, set.size());

        bean.setBizRateMinBizCalcable(BizRate.valueOf(new BigDecimal("10.00")));
        set = validator.validateProperty(bean, "bizRateMinBizCalcable");
        assertEquals(0, set.size());

        bean.setBizNumberMinBizCalcable(BizNumber.valueOf(new BigDecimal("-10.00")));
        set = validator.validateProperty(bean, "bizNumberMinBizCalcable");
        assertEquals(1, set.size());

        bean.setBizNumberMinBizCalcable(BizNumber.valueOf(new BigDecimal("-9.99")));
        set = validator.validateProperty(bean, "bizNumberMinBizCalcable");
        assertEquals(1, set.size());

        bean.setBizNumberMinBizCalcable(BizNumber.valueOf(new BigDecimal("9.99")));
        set = validator.validateProperty(bean, "bizNumberMinBizCalcable");
        assertEquals(0, set.size());

        bean.setBizNumberMinBizCalcable(BizNumber.valueOf(new BigDecimal("10.00")));
        set = validator.validateProperty(bean, "bizNumberMinBizCalcable");
        assertEquals(0, set.size());

        bean.setLongMin(new Long(-10));
        set = validator.validateProperty(bean, "longMin");
        assertEquals(1, set.size());

        bean.setLongMin(new Long(-9));
        set = validator.validateProperty(bean, "longMin");
        assertEquals(1, set.size());

        bean.setLongMin(new Long(9));
        set = validator.validateProperty(bean, "longMin");
        assertEquals(0, set.size());

        bean.setLongMin(new Long(10));
        set = validator.validateProperty(bean, "longMin");
        assertEquals(0, set.size());

        bean.setIntegerMin(new Integer(-10));
        set = validator.validateProperty(bean, "integerMin");
        assertEquals(1, set.size());

        bean.setIntegerMin(new Integer(-9));
        set = validator.validateProperty(bean, "integerMin");
        assertEquals(1, set.size());

        bean.setIntegerMin(new Integer(9));
        set = validator.validateProperty(bean, "integerMin");
        assertEquals(0, set.size());

        bean.setIntegerMin(new Integer(10));
        set = validator.validateProperty(bean, "integerMin");
        assertEquals(0, set.size());

    }

    @Test
    public void testCurrencyLength() {

        bean.setCurrencyLength(BizCurrency.valueOf(new BigDecimal("1234567890")));
        Set<ConstraintViolation<Bean>> set = validator.validateProperty(bean, "currencyLength");
        assertEquals(0, set.size());

        bean.setCurrencyLength(BizCurrency.valueOf(new BigDecimal("123456789.0")));
        set = validator.validateProperty(bean, "currencyLength");
        assertEquals(0, set.size());

        bean.setCurrencyLength(BizCurrency.valueOf(new BigDecimal("12345678901")));
        set = validator.validateProperty(bean, "currencyLength");
        assertEquals(1, set.size());
        assertEquals("item-idは桁数桁以内で入力してください。",
            MessageUtil.getMessage(set.iterator().next().getMessage().substring(1, 8)));

        bean.setCurrencyLength(BizCurrency.valueOf(new BigDecimal("123456789012")));
        set = validator.validateProperty(bean, "currencyLength");
        assertEquals(1, set.size());

        bean.setCurrencyLength(BizCurrency.valueOf(new BigDecimal("-123456789")));
        set = validator.validateProperty(bean, "currencyLength");
        assertEquals(0, set.size());

        bean.setCurrencyLength(BizCurrency.valueOf(new BigDecimal("-1234567890")));
        set = validator.validateProperty(bean, "currencyLength");
        assertEquals(0, set.size());

        bean.setCurrencyLength(BizCurrency.valueOf(new BigDecimal("-12345678901")));
        set = validator.validateProperty(bean, "currencyLength");
        assertEquals(1, set.size());

    }

    @Test
    public void testCurrencyPrecision() {

        bean.setCurrencyPrecision(BizCurrency.valueOf(new BigDecimal("123.4")));
        Set<ConstraintViolation<Bean>> set = validator.validateProperty(bean, "currencyPrecision");
        assertEquals(0, set.size());

        bean.setCurrencyPrecision(BizCurrency.valueOf(new BigDecimal("123.45")));
        set = validator.validateProperty(bean, "currencyPrecision");
        assertEquals(0, set.size());

        bean.setCurrencyPrecision(BizCurrency.valueOf(new BigDecimal("123.456")));
        set = validator.validateProperty(bean, "currencyPrecision");
        assertEquals(1, set.size());
        assertEquals("item-idの通貨単位未満の桁数はprecision桁以内で入力してください。",
            MessageUtil.getMessage(set.iterator().next().getMessage().substring(1, 8)));

        bean.setCurrencyPrecision(BizCurrency.valueOf(new BigDecimal("-123.4")));
        set = validator.validateProperty(bean, "currencyPrecision");
        assertEquals(0, set.size());

        bean.setCurrencyPrecision(BizCurrency.valueOf(new BigDecimal("-123.45")));
        set = validator.validateProperty(bean, "currencyPrecision");
        assertEquals(0, set.size());

        bean.setCurrencyPrecision(BizCurrency.valueOf(new BigDecimal("-123.456")));
        set = validator.validateProperty(bean, "currencyPrecision");
        assertEquals(1, set.size());

    }

    @Test
    public void testDecimalRangeNumber() {

        bean.setDoubleDecimalRangeNumber(new Double(-10.00));
        Set<ConstraintViolation<Bean>> set = validator.validateProperty(bean, "doubleDecimalRangeNumber");
        assertEquals(1, set.size());
        assertEquals("item-idはmin以上max以内、小数scale桁以内で入力してください。",
            MessageUtil.getMessage(set.iterator().next().getMessage().substring(1, 8)));

        bean.setDoubleDecimalRangeNumber(new Double(-9.999));
        set = validator.validateProperty(bean, "doubleDecimalRangeNumber");
        assertEquals(1, set.size());

        bean.setDoubleDecimalRangeNumber(new Double(-9.99));
        set = validator.validateProperty(bean, "doubleDecimalRangeNumber");
        assertEquals(0, set.size());

        bean.setDoubleDecimalRangeNumber(new Double(-9.9));
        set = validator.validateProperty(bean, "doubleDecimalRangeNumber");
        assertEquals(0, set.size());

        bean.setDoubleDecimalRangeNumber(new Double(9.9));
        set = validator.validateProperty(bean, "doubleDecimalRangeNumber");
        assertEquals(0, set.size());

        bean.setDoubleDecimalRangeNumber(new Double(9.99));
        set = validator.validateProperty(bean, "doubleDecimalRangeNumber");
        assertEquals(0, set.size());

        bean.setDoubleDecimalRangeNumber(new Double(9.999));
        set = validator.validateProperty(bean, "doubleDecimalRangeNumber");
        assertEquals(1, set.size());

        bean.setDoubleDecimalRangeNumber(new Double(10.00));
        set = validator.validateProperty(bean, "doubleDecimalRangeNumber");
        assertEquals(1, set.size());

        bean.setBizCurrencyDecimalRangeBizCalcable(BizCurrency.valueOf(new BigDecimal("-10.00")));
        set = validator.validateProperty(bean, "bizCurrencyDecimalRangeBizCalcable");
        assertEquals(1, set.size());

        bean.setBizCurrencyDecimalRangeBizCalcable(BizCurrency.valueOf(new BigDecimal("-9.999")));
        set = validator.validateProperty(bean, "bizCurrencyDecimalRangeBizCalcable");
        assertEquals(1, set.size());

        bean.setBizCurrencyDecimalRangeBizCalcable(BizCurrency.valueOf(new BigDecimal("-9.99")));
        set = validator.validateProperty(bean, "bizCurrencyDecimalRangeBizCalcable");
        assertEquals(0, set.size());

        bean.setBizCurrencyDecimalRangeBizCalcable(BizCurrency.valueOf(new BigDecimal("-9.9")));
        set = validator.validateProperty(bean, "bizCurrencyDecimalRangeBizCalcable");
        assertEquals(0, set.size());

        bean.setBizCurrencyDecimalRangeBizCalcable(BizCurrency.valueOf(new BigDecimal("9.9")));
        set = validator.validateProperty(bean, "bizCurrencyDecimalRangeBizCalcable");
        assertEquals(0, set.size());

        bean.setBizCurrencyDecimalRangeBizCalcable(BizCurrency.valueOf(new BigDecimal("9.99")));
        set = validator.validateProperty(bean, "bizCurrencyDecimalRangeBizCalcable");
        assertEquals(0, set.size());

        bean.setBizCurrencyDecimalRangeBizCalcable(BizCurrency.valueOf(new BigDecimal("9.999")));
        set = validator.validateProperty(bean, "bizCurrencyDecimalRangeBizCalcable");
        assertEquals(1, set.size());

        bean.setBizCurrencyDecimalRangeBizCalcable(BizCurrency.valueOf(new BigDecimal("10.00")));
        set = validator.validateProperty(bean, "bizCurrencyDecimalRangeBizCalcable");
        assertEquals(1, set.size());

        bean.setBizRateDecimalRangeBizCalcable(BizRate.valueOf(new BigDecimal("-10.00")));
        set = validator.validateProperty(bean, "bizRateDecimalRangeBizCalcable");
        assertEquals(1, set.size());

        bean.setBizRateDecimalRangeBizCalcable(BizRate.valueOf(new BigDecimal("-9.999")));
        set = validator.validateProperty(bean, "bizRateDecimalRangeBizCalcable");
        assertEquals(1, set.size());

        bean.setBizRateDecimalRangeBizCalcable(BizRate.valueOf(new BigDecimal("-9.99")));
        set = validator.validateProperty(bean, "bizRateDecimalRangeBizCalcable");
        assertEquals(0, set.size());

        bean.setBizRateDecimalRangeBizCalcable(BizRate.valueOf(new BigDecimal("-9.9")));
        set = validator.validateProperty(bean, "bizRateDecimalRangeBizCalcable");
        assertEquals(0, set.size());

        bean.setBizRateDecimalRangeBizCalcable(BizRate.valueOf(new BigDecimal("9.9")));
        set = validator.validateProperty(bean, "bizRateDecimalRangeBizCalcable");
        assertEquals(0, set.size());

        bean.setBizRateDecimalRangeBizCalcable(BizRate.valueOf(new BigDecimal("9.99")));
        set = validator.validateProperty(bean, "bizRateDecimalRangeBizCalcable");
        assertEquals(0, set.size());

        bean.setBizRateDecimalRangeBizCalcable(BizRate.valueOf(new BigDecimal("9.999")));
        set = validator.validateProperty(bean, "bizRateDecimalRangeBizCalcable");
        assertEquals(1, set.size());

        bean.setBizRateDecimalRangeBizCalcable(BizRate.valueOf(new BigDecimal("10.00")));
        set = validator.validateProperty(bean, "bizRateDecimalRangeBizCalcable");
        assertEquals(1, set.size());

        bean.setBizNumberDecimalRangeBizCalcable(BizNumber.valueOf(new BigDecimal("-10.00")));
        set = validator.validateProperty(bean, "bizNumberDecimalRangeBizCalcable");
        assertEquals(1, set.size());

        bean.setBizNumberDecimalRangeBizCalcable(BizNumber.valueOf(new BigDecimal("-9.999")));
        set = validator.validateProperty(bean, "bizNumberDecimalRangeBizCalcable");
        assertEquals(1, set.size());

        bean.setBizNumberDecimalRangeBizCalcable(BizNumber.valueOf(new BigDecimal("-9.99")));
        set = validator.validateProperty(bean, "bizNumberDecimalRangeBizCalcable");
        assertEquals(0, set.size());

        bean.setBizNumberDecimalRangeBizCalcable(BizNumber.valueOf(new BigDecimal("-9.9")));
        set = validator.validateProperty(bean, "bizNumberDecimalRangeBizCalcable");
        assertEquals(0, set.size());

        bean.setBizNumberDecimalRangeBizCalcable(BizNumber.valueOf(new BigDecimal("9.9")));
        set = validator.validateProperty(bean, "bizNumberDecimalRangeBizCalcable");
        assertEquals(0, set.size());

        bean.setBizNumberDecimalRangeBizCalcable(BizNumber.valueOf(new BigDecimal("9.99")));
        set = validator.validateProperty(bean, "bizNumberDecimalRangeBizCalcable");
        assertEquals(0, set.size());

        bean.setBizNumberDecimalRangeBizCalcable(BizNumber.valueOf(new BigDecimal("9.999")));
        set = validator.validateProperty(bean, "bizNumberDecimalRangeBizCalcable");
        assertEquals(1, set.size());

        bean.setBizNumberDecimalRangeBizCalcable(BizNumber.valueOf(new BigDecimal("10.00")));
        set = validator.validateProperty(bean, "bizNumberDecimalRangeBizCalcable");
        assertEquals(1, set.size());

    }

    @Test
    public void testPositiveNumber() {

        bean.setDoublePositiveNumber(new Double(-1));
        Set<ConstraintViolation<Bean>> set = validator.validateProperty(bean, "doublePositiveNumber");
        assertEquals(1, set.size());
        assertEquals("item-id は正の数で入力してください。",
            MessageUtil.getMessage(set.iterator().next().getMessage().substring(1, 8)));

        bean.setDoublePositiveNumber(new Double(-0.5));
        set = validator.validateProperty(bean, "doublePositiveNumber");
        assertEquals(1, set.size());

        bean.setDoublePositiveNumber(new Double(0));
        set = validator.validateProperty(bean, "doublePositiveNumber");
        assertEquals(0, set.size());

        bean.setDoublePositiveNumber(new Double(0.5));
        set = validator.validateProperty(bean, "doublePositiveNumber");
        assertEquals(0, set.size());

        bean.setDoublePositiveNumber(new Double(1));
        set = validator.validateProperty(bean, "doublePositiveNumber");
        assertEquals(0, set.size());

        bean.setLongPositiveNumber(new Long(-1));
        set = validator.validateProperty(bean, "longPositiveNumber");
        assertEquals(1, set.size());

        bean.setLongPositiveNumber(new Long(0));
        set = validator.validateProperty(bean, "longPositiveNumber");
        assertEquals(0, set.size());

        bean.setLongPositiveNumber(new Long(1));
        set = validator.validateProperty(bean, "longPositiveNumber");
        assertEquals(0, set.size());

        bean.setIntegerPositiveNumber(new Integer(-1));
        set = validator.validateProperty(bean, "integerPositiveNumber");
        assertEquals(1, set.size());

        bean.setIntegerPositiveNumber(new Integer(0));
        set = validator.validateProperty(bean, "integerPositiveNumber");
        assertEquals(0, set.size());

        bean.setIntegerPositiveNumber(new Integer(1));
        set = validator.validateProperty(bean, "integerPositiveNumber");
        assertEquals(0, set.size());

        bean.setBizCurrencyPositiveNumberBizCalcble(BizCurrency.valueOf(new BigDecimal("-1")));
        set = validator.validateProperty(bean, "bizCurrencyPositiveNumberBizCalcble");
        assertEquals(1, set.size());

        bean.setBizCurrencyPositiveNumberBizCalcble(BizCurrency.valueOf(new BigDecimal("-0.5")));
        set = validator.validateProperty(bean, "bizCurrencyPositiveNumberBizCalcble");
        assertEquals(1, set.size());

        bean.setBizCurrencyPositiveNumberBizCalcble(BizCurrency.valueOf(new BigDecimal("0")));
        set = validator.validateProperty(bean, "bizCurrencyPositiveNumberBizCalcble");
        assertEquals(0, set.size());

        bean.setBizCurrencyPositiveNumberBizCalcble(BizCurrency.valueOf(new BigDecimal("0.5")));
        set = validator.validateProperty(bean, "bizCurrencyPositiveNumberBizCalcble");
        assertEquals(0, set.size());

        bean.setBizCurrencyPositiveNumberBizCalcble(BizCurrency.valueOf(new BigDecimal("1")));
        set = validator.validateProperty(bean, "bizCurrencyPositiveNumberBizCalcble");
        assertEquals(0, set.size());

        bean.setBizRatePositiveNumberBizCalcble(BizRate.valueOf(new BigDecimal("-1")));
        set = validator.validateProperty(bean, "bizRatePositiveNumberBizCalcble");
        assertEquals(1, set.size());

        bean.setBizRatePositiveNumberBizCalcble(BizRate.valueOf(new BigDecimal("-0.5")));
        set = validator.validateProperty(bean, "bizRatePositiveNumberBizCalcble");
        assertEquals(1, set.size());

        bean.setBizRatePositiveNumberBizCalcble(BizRate.valueOf(new BigDecimal("0")));
        set = validator.validateProperty(bean, "bizRatePositiveNumberBizCalcble");
        assertEquals(0, set.size());

        bean.setBizRatePositiveNumberBizCalcble(BizRate.valueOf(new BigDecimal("0.5")));
        set = validator.validateProperty(bean, "bizRatePositiveNumberBizCalcble");
        assertEquals(0, set.size());

        bean.setBizRatePositiveNumberBizCalcble(BizRate.valueOf(new BigDecimal("1")));
        set = validator.validateProperty(bean, "bizRatePositiveNumberBizCalcble");
        assertEquals(0, set.size());

        bean.setBizNumberPositiveNumberBizCalcble(BizNumber.valueOf(new BigDecimal("-1")));
        set = validator.validateProperty(bean, "bizNumberPositiveNumberBizCalcble");
        assertEquals(1, set.size());

        bean.setBizNumberPositiveNumberBizCalcble(BizNumber.valueOf(new BigDecimal("-0.5")));
        set = validator.validateProperty(bean, "bizNumberPositiveNumberBizCalcble");
        assertEquals(1, set.size());

        bean.setBizNumberPositiveNumberBizCalcble(BizNumber.valueOf(new BigDecimal("0")));
        set = validator.validateProperty(bean, "bizNumberPositiveNumberBizCalcble");
        assertEquals(0, set.size());

        bean.setBizNumberPositiveNumberBizCalcble(BizNumber.valueOf(new BigDecimal("0.5")));
        set = validator.validateProperty(bean, "bizNumberPositiveNumberBizCalcble");
        assertEquals(0, set.size());

        bean.setBizNumberPositiveNumberBizCalcble(BizNumber.valueOf(new BigDecimal("1")));
        set = validator.validateProperty(bean, "bizNumberPositiveNumberBizCalcble");
        assertEquals(0, set.size());

    }

    @Test
    public void testNaturalNumber() {

        bean.setLongNaturalNumber(new Long(-1));
        Set<ConstraintViolation<Bean>> set = validator.validateProperty(bean, "longNaturalNumber");
        assertEquals(1, set.size());
        assertEquals("item-id は正の整数で入力してください。",
            MessageUtil.getMessage(set.iterator().next().getMessage().substring(1, 8)));

        bean.setLongNaturalNumber(new Long(0));
        set = validator.validateProperty(bean, "longNaturalNumber");
        assertEquals(0, set.size());

        bean.setLongNaturalNumber(new Long(1));
        set = validator.validateProperty(bean, "longNaturalNumber");
        assertEquals(0, set.size());

        bean.setIntegerNaturalNumber(new Integer(-1));
        set = validator.validateProperty(bean, "integerNaturalNumber");
        assertEquals(1, set.size());

        bean.setIntegerNaturalNumber(new Integer(0));
        set = validator.validateProperty(bean, "integerNaturalNumber");
        assertEquals(0, set.size());

        bean.setIntegerNaturalNumber(new Integer(1));
        set = validator.validateProperty(bean, "integerNaturalNumber");
        assertEquals(0, set.size());

        bean.setBizRateNaturalNumberBizCalcable(BizRate.valueOf(new BigDecimal("-1")));
        set = validator.validateProperty(bean, "bizRateNaturalNumberBizCalcable");
        assertEquals(1, set.size());

        bean.setBizRateNaturalNumberBizCalcable(BizRate.valueOf(new BigDecimal("-0.5")));
        set = validator.validateProperty(bean, "bizRateNaturalNumberBizCalcable");
        assertEquals(1, set.size());

        bean.setBizRateNaturalNumberBizCalcable(BizRate.valueOf(new BigDecimal("0")));
        set = validator.validateProperty(bean, "bizRateNaturalNumberBizCalcable");
        assertEquals(0, set.size());

        bean.setBizRateNaturalNumberBizCalcable(BizRate.valueOf(new BigDecimal("0.5")));
        set = validator.validateProperty(bean, "bizRateNaturalNumberBizCalcable");
        assertEquals(1, set.size());

        bean.setBizRateNaturalNumberBizCalcable(BizRate.valueOf(new BigDecimal("1")));
        set = validator.validateProperty(bean, "bizRateNaturalNumberBizCalcable");
        assertEquals(0, set.size());

        bean.setBizNumberNaturalNumberBizCalcable(BizNumber.valueOf(new BigDecimal("-1")));
        set = validator.validateProperty(bean, "bizNumberNaturalNumberBizCalcable");
        assertEquals(1, set.size());

        bean.setBizNumberNaturalNumberBizCalcable(BizNumber.valueOf(new BigDecimal("-0.5")));
        set = validator.validateProperty(bean, "bizNumberNaturalNumberBizCalcable");
        assertEquals(1, set.size());

        bean.setBizNumberNaturalNumberBizCalcable(BizNumber.valueOf(new BigDecimal("0")));
        set = validator.validateProperty(bean, "bizNumberNaturalNumberBizCalcable");
        assertEquals(0, set.size());

        bean.setBizNumberNaturalNumberBizCalcable(BizNumber.valueOf(new BigDecimal("0.5")));
        set = validator.validateProperty(bean, "bizNumberNaturalNumberBizCalcable");
        assertEquals(1, set.size());

        bean.setBizNumberNaturalNumberBizCalcable(BizNumber.valueOf(new BigDecimal("1")));
        set = validator.validateProperty(bean, "bizNumberNaturalNumberBizCalcable");
        assertEquals(0, set.size());
    }

    @Test
    public void testTimeHM() {

        bean.setTimeHM("0000");
        Set<ConstraintViolation<Bean>> set = validator.validateProperty(bean, "timeHM");
        assertEquals(0, set.size());

        bean.setTimeHM("2359");
        set = validator.validateProperty(bean, "timeHM");
        assertEquals(0, set.size());

        bean.setTimeHM("2400");
        set = validator.validateProperty(bean, "timeHM");
        assertEquals(1, set.size());
        assertEquals("item-id は時間として適切な値で入力してください。",
            MessageUtil.getMessage(set.iterator().next().getMessage().substring(1, 8)));

        bean.setTimeHM("0060");
        set = validator.validateProperty(bean, "timeHM");
        assertEquals(1, set.size());

        bean.setTimeHM("-000");
        set = validator.validateProperty(bean, "timeHM");
        assertEquals(1, set.size());

        bean.setTimeHM("000a");
        set = validator.validateProperty(bean, "timeHM");
        assertEquals(1, set.size());

        bean.setTimeHM("000Ａ");
        set = validator.validateProperty(bean, "timeHM");
        assertEquals(1, set.size());

        bean.setTimeHM("000あ");
        set = validator.validateProperty(bean, "timeHM");
        assertEquals(1, set.size());

        bean.setTimeHM("000ｱ");
        set = validator.validateProperty(bean, "timeHM");
        assertEquals(1, set.size());

        bean.setTimeHM("000ア");
        set = validator.validateProperty(bean, "timeHM");
        assertEquals(1, set.size());

        bean.setTimeHM("000亜");
        set = validator.validateProperty(bean, "timeHM");
        assertEquals(1, set.size());
    }

    @Test
    public void testTime() {

        bean.setTime("000000");
        Set<ConstraintViolation<Bean>> set = validator.validateProperty(bean, "time");
        assertEquals(0, set.size());

        bean.setTime("235959");
        set = validator.validateProperty(bean, "time");
        assertEquals(0, set.size());

        bean.setTime("240000");
        set = validator.validateProperty(bean, "time");
        assertEquals(1, set.size());
        assertEquals("item-id は時間として適切な値で入力してください。",
            MessageUtil.getMessage(set.iterator().next().getMessage().substring(1, 8)));

        bean.setTime("006000");
        set = validator.validateProperty(bean, "time");
        assertEquals(1, set.size());

        bean.setTime("000060");
        set = validator.validateProperty(bean, "time");
        assertEquals(1, set.size());

        bean.setTime("-00000");
        set = validator.validateProperty(bean, "time");
        assertEquals(1, set.size());

        bean.setTime("00000a");
        set = validator.validateProperty(bean, "time");
        assertEquals(1, set.size());

        bean.setTime("00000Ａ");
        set = validator.validateProperty(bean, "time");
        assertEquals(1, set.size());

        bean.setTime("00000あ");
        set = validator.validateProperty(bean, "time");
        assertEquals(1, set.size());

        bean.setTime("00000ｱ");
        set = validator.validateProperty(bean, "time");
        assertEquals(1, set.size());

        bean.setTime("00000ア");
        set = validator.validateProperty(bean, "time");
        assertEquals(1, set.size());

        bean.setTime("00000亜");
        set = validator.validateProperty(bean, "time");
        assertEquals(1, set.size());

    }

    @Test
    public void testValidDateY() {

        bean.setValidDateY(BizDateY.valueOf(0));
        Set<ConstraintViolation<Bean>> set = validator.validateProperty(bean, "validDateY");
        assertEquals(1, set.size());
        assertEquals("item-id は日付（年）として適切な値で入力してください。",
            MessageUtil.getMessage(set.iterator().next().getMessage().substring(1, 8)));

        bean.setValidDateY(BizDateY.valueOf(1));
        set = validator.validateProperty(bean, "validDateY");
        assertEquals(0, set.size());

        bean.setValidDateY(BizDateY.valueOf(2015));
        set = validator.validateProperty(bean, "validDateY");
        assertEquals(0, set.size());

        bean.setValidDateY(BizDateY.valueOf(9999));
        set = validator.validateProperty(bean, "validDateY");
        assertEquals(0, set.size());

    }

    @Test
    public void testValidDateYM() {

        bean.setValidDateYM(BizDateYM.valueOf(000));
        Set<ConstraintViolation<Bean>> set = validator.validateProperty(bean, "validDateYM");
        assertEquals(1, set.size());
        assertEquals("item-id は日付（年月）として適切な値で入力してください。",
            MessageUtil.getMessage(set.iterator().next().getMessage().substring(1, 8)));

        bean.setValidDateYM(BizDateYM.valueOf(001));
        set = validator.validateProperty(bean, "validDateYM");
        assertEquals(1, set.size());

        bean.setValidDateYM(BizDateYM.valueOf(100));
        set = validator.validateProperty(bean, "validDateYM");
        assertEquals(1, set.size());

        bean.setValidDateYM(BizDateYM.valueOf(101));
        set = validator.validateProperty(bean, "validDateYM");
        assertEquals(0, set.size());

        bean.setValidDateYM(BizDateYM.valueOf(112));
        set = validator.validateProperty(bean, "validDateYM");
        assertEquals(0, set.size());

        bean.setValidDateYM(BizDateYM.valueOf(201501));
        set = validator.validateProperty(bean, "validDateYM");
        assertEquals(0, set.size());

        bean.setValidDateYM(BizDateYM.valueOf(201513));
        set = validator.validateProperty(bean, "validDateYM");
        assertEquals(1, set.size());

        bean.setValidDateYM(BizDateYM.valueOf(999912));
        set = validator.validateProperty(bean, "validDateYM");
        assertEquals(0, set.size());

    }

    @Test
    public void testalidDate() {

        bean.setValidDate(BizDate.valueOf(00000));
        Set<ConstraintViolation<Bean>> set = validator.validateProperty(bean, "validDate");
        assertEquals(1, set.size());
        assertEquals("item-id は日付（年月日）として適切な値で入力してください。",
            MessageUtil.getMessage(set.iterator().next().getMessage().substring(1, 8)));

        bean.setValidDate(BizDate.valueOf(00101));
        set = validator.validateProperty(bean, "validDate");
        assertEquals(1, set.size());

        bean.setValidDate(BizDate.valueOf(10101));
        set = validator.validateProperty(bean, "validDate");
        assertEquals(0, set.size());

        bean.setValidDate(BizDate.valueOf(11231));
        set = validator.validateProperty(bean, "validDate");
        assertEquals(0, set.size());

        bean.setValidDate(BizDate.valueOf(20150131));
        set = validator.validateProperty(bean, "validDate");
        assertEquals(0, set.size());

        bean.setValidDate(BizDate.valueOf(21050229));
        set = validator.validateProperty(bean, "validDate");
        assertEquals(1, set.size());

        bean.setValidDate(BizDate.valueOf(20160229));
        set = validator.validateProperty(bean, "validDate");
        assertEquals(0, set.size());

        bean.setValidDate(BizDate.valueOf(19000229));
        set = validator.validateProperty(bean, "validDate");
        assertEquals(1, set.size());

        bean.setValidDate(BizDate.valueOf(20000229));
        set = validator.validateProperty(bean, "validDate");
        assertEquals(0, set.size());

        bean.setValidDate(BizDate.valueOf(99991231));
        set = validator.validateProperty(bean, "validDate");
        assertEquals(0, set.size());

        bean.setValidDate(BizDate.valueOf(99991331));
        set = validator.validateProperty(bean, "validDate");
        assertEquals(1, set.size());

        bean.setValidDate(BizDate.valueOf(99991232));
        set = validator.validateProperty(bean, "validDate");
        assertEquals(1, set.size());

    }

    @Test
    public void testValidDateMD() {

        bean.setValidDateMD(BizDateMD.valueOf("0000"));
        Set<ConstraintViolation<Bean>> set = validator.validateProperty(bean, "validDateMD");
        assertEquals(1, set.size());
        assertEquals("item-id は日付（月日）として適切な値で入力してください。",
            MessageUtil.getMessage(set.iterator().next().getMessage().substring(1, 8)));

        bean.setValidDateMD(BizDateMD.valueOf("0001"));
        set = validator.validateProperty(bean, "validDateMD");
        assertEquals(1, set.size());

        bean.setValidDateMD(BizDateMD.valueOf("0100"));
        set = validator.validateProperty(bean, "validDateMD");
        assertEquals(1, set.size());

        bean.setValidDateMD(BizDateMD.valueOf("0101"));
        set = validator.validateProperty(bean, "validDateMD");
        assertEquals(0, set.size());

        bean.setValidDateMD(BizDateMD.valueOf("0131"));
        set = validator.validateProperty(bean, "validDateMD");
        assertEquals(0, set.size());

        bean.setValidDateMD(BizDateMD.valueOf("0132"));
        set = validator.validateProperty(bean, "validDateMD");
        assertEquals(1, set.size());

        bean.setValidDateMD(BizDateMD.valueOf("0229"));
        set = validator.validateProperty(bean, "validDateMD");
        assertEquals(0, set.size());

        bean.setValidDateMD(BizDateMD.valueOf("0230"));
        set = validator.validateProperty(bean, "validDateMD");
        assertEquals(1, set.size());

        bean.setValidDateMD(BizDateMD.valueOf("0331"));
        set = validator.validateProperty(bean, "validDateMD");
        assertEquals(0, set.size());

        bean.setValidDateMD(BizDateMD.valueOf("0332"));
        set = validator.validateProperty(bean, "validDateMD");
        assertEquals(1, set.size());

        bean.setValidDateMD(BizDateMD.valueOf("0430"));
        set = validator.validateProperty(bean, "validDateMD");
        assertEquals(0, set.size());

        bean.setValidDateMD(BizDateMD.valueOf("0431"));
        set = validator.validateProperty(bean, "validDateMD");
        assertEquals(1, set.size());

        bean.setValidDateMD(BizDateMD.valueOf("0531"));
        set = validator.validateProperty(bean, "validDateMD");
        assertEquals(0, set.size());

        bean.setValidDateMD(BizDateMD.valueOf("0532"));
        set = validator.validateProperty(bean, "validDateMD");
        assertEquals(1, set.size());

        bean.setValidDateMD(BizDateMD.valueOf("0630"));
        set = validator.validateProperty(bean, "validDateMD");
        assertEquals(0, set.size());

        bean.setValidDateMD(BizDateMD.valueOf("0631"));
        set = validator.validateProperty(bean, "validDateMD");
        assertEquals(1, set.size());

        bean.setValidDateMD(BizDateMD.valueOf("0731"));
        set = validator.validateProperty(bean, "validDateMD");
        assertEquals(0, set.size());

        bean.setValidDateMD(BizDateMD.valueOf("0732"));
        set = validator.validateProperty(bean, "validDateMD");
        assertEquals(1, set.size());

        bean.setValidDateMD(BizDateMD.valueOf("0831"));
        set = validator.validateProperty(bean, "validDateMD");
        assertEquals(0, set.size());

        bean.setValidDateMD(BizDateMD.valueOf("0832"));
        set = validator.validateProperty(bean, "validDateMD");
        assertEquals(1, set.size());

        bean.setValidDateMD(BizDateMD.valueOf("0930"));
        set = validator.validateProperty(bean, "validDateMD");
        assertEquals(0, set.size());

        bean.setValidDateMD(BizDateMD.valueOf("0931"));
        set = validator.validateProperty(bean, "validDateMD");
        assertEquals(1, set.size());

        bean.setValidDateMD(BizDateMD.valueOf("1031"));
        set = validator.validateProperty(bean, "validDateMD");
        assertEquals(0, set.size());

        bean.setValidDateMD(BizDateMD.valueOf("1032"));
        set = validator.validateProperty(bean, "validDateMD");
        assertEquals(1, set.size());

        bean.setValidDateMD(BizDateMD.valueOf("1130"));
        set = validator.validateProperty(bean, "validDateMD");
        assertEquals(0, set.size());

        bean.setValidDateMD(BizDateMD.valueOf("1131"));
        set = validator.validateProperty(bean, "validDateMD");
        assertEquals(1, set.size());

        bean.setValidDateMD(BizDateMD.valueOf("1231"));
        set = validator.validateProperty(bean, "validDateMD");
        assertEquals(0, set.size());

        bean.setValidDateMD(BizDateMD.valueOf("1232"));
        set = validator.validateProperty(bean, "validDateMD");
        assertEquals(1, set.size());

    }

    @Test
    public void testInvalidCharacter() {

        bean.setInvalidCharacter(null);
        Set<ConstraintViolation<Bean>> set = validator.validateProperty(bean, "invalidCharacter");
        assertEquals(0, set.size());

        bean.setInvalidCharacter("");
        set = validator.validateProperty(bean, "invalidCharacter");
        assertEquals(0, set.size());

        bean.setInvalidCharacter("、。／");
        set = validator.validateProperty(bean, "invalidCharacter");
        assertEquals(0, set.size());

        bean.setInvalidCharacter("???");
        set = validator.validateProperty(bean, "invalidCharacter");
        assertEquals(1, set.size());
        assertEquals("item-idにシステムで取扱できない文字が含まれています。他の文字に変えて入力してください。",MessageUtil.getMessage(set.iterator().next().getMessage().substring(1, 8)));

        bean.setInvalidCharacter("???あ");
        set = validator.validateProperty(bean, "invalidCharacter");
        assertEquals(1, set.size());

        bean.setInvalidCharacter("あ???あ");
        set = validator.validateProperty(bean, "invalidCharacter");
        assertEquals(1, set.size());

        bean.setInvalidCharacter("あ???");
        set = validator.validateProperty(bean, "invalidCharacter");
        assertEquals(1, set.size());

        bean.setInvalidCharacter("あアァＡａ亜");
        set = validator.validateProperty(bean, "invalidCharacter");
        assertEquals(0, set.size());

        bean.setInvalidCharacter("弌冲勹");
        set = validator.validateProperty(bean, "invalidCharacter");
        assertEquals(0, set.size());

        bean.setInvalidCharacter("丨侊冝");
        set = validator.validateProperty(bean, "invalidCharacter");
        assertEquals(0, set.size());

        bean.setInvalidCharacter("???");
        set = validator.validateProperty(bean, "invalidCharacter");
        assertEquals(1, set.size());

        bean.setInvalidCharacter("???あ");
        set = validator.validateProperty(bean, "invalidCharacter");
        assertEquals(1, set.size());

        bean.setInvalidCharacter("あ???あ");
        set = validator.validateProperty(bean, "invalidCharacter");
        assertEquals(1, set.size());

        bean.setInvalidCharacter("あ???");
        set = validator.validateProperty(bean, "invalidCharacter");
        assertEquals(1, set.size());

        bean.setInvalidCharacter("伀侒侚");
        set = validator.validateProperty(bean, "invalidCharacter");
        assertEquals(0, set.size());

        bean.setInvalidCharacter("???");
        set = validator.validateProperty(bean, "invalidCharacter");
        assertEquals(1, set.size());

        bean.setInvalidCharacter("???あ");
        set = validator.validateProperty(bean, "invalidCharacter");
        assertEquals(1, set.size());

        bean.setInvalidCharacter("あ???あ");
        set = validator.validateProperty(bean, "invalidCharacter");
        assertEquals(1, set.size());

        bean.setInvalidCharacter("あ???");
        set = validator.validateProperty(bean, "invalidCharacter");
        assertEquals(1, set.size());

        bean.setInvalidCharacter("ｱA\\");
        set = validator.validateProperty(bean, "invalidCharacter");
        assertEquals(0, set.size());

        bean.setInvalidCharacter("?AR");
        set = validator.validateProperty(bean, "invalidCharacter");
        assertEquals(1, set.size());

        bean.setInvalidCharacter("?ARあ");
        set = validator.validateProperty(bean, "invalidCharacter");
        assertEquals(1, set.size());

        bean.setInvalidCharacter("あ?ARあ");
        set = validator.validateProperty(bean, "invalidCharacter");
        assertEquals(1, set.size());

        bean.setInvalidCharacter("あ?AR");
        set = validator.validateProperty(bean, "invalidCharacter");
        assertEquals(1, set.size());

        bean.setInvalidCharacter("ｯa{");
        set = validator.validateProperty(bean, "invalidCharacter");
        assertEquals(0, set.size());

        bean.setInvalidCharacter("①㈲Σ");
        set = validator.validateProperty(bean, "invalidCharacter");
        assertEquals(1, set.size());

        bean.setInvalidCharacter("①㈲Σあ");
        set = validator.validateProperty(bean, "invalidCharacter");
        assertEquals(1, set.size());

        bean.setInvalidCharacter("あ①㈲Σあ");
        set = validator.validateProperty(bean, "invalidCharacter");
        assertEquals(1, set.size());

        bean.setInvalidCharacter("あ①㈲Σ");
        set = validator.validateProperty(bean, "invalidCharacter");
        assertEquals(1, set.size());

        bean.setInvalidCharacter(new String(new byte[]{(byte)0xF0,(byte)0x40,(byte)0xF0,(byte)0x73,(byte)0xF0,(byte)0x4B},WINDOWS_31J));
        set = validator.validateProperty(bean, "invalidCharacter");
        assertEquals(0, set.size());

        bean.setInvalidCharacter("①");
        set = validator.validateProperty(bean, "invalidCharacter");
        assertEquals(1, set.size());

        bean.setInvalidCharacter("②");
        set = validator.validateProperty(bean, "invalidCharacter");
        assertEquals(1, set.size());

        bean.setInvalidCharacter("③");
        set = validator.validateProperty(bean, "invalidCharacter");
        assertEquals(1, set.size());

        bean.setInvalidCharacter("④");
        set = validator.validateProperty(bean, "invalidCharacter");
        assertEquals(1, set.size());

        bean.setInvalidCharacter("⑤");
        set = validator.validateProperty(bean, "invalidCharacter");
        assertEquals(1, set.size());

        bean.setInvalidCharacter("⑥");
        set = validator.validateProperty(bean, "invalidCharacter");
        assertEquals(1, set.size());

        bean.setInvalidCharacter("⑦");
        set = validator.validateProperty(bean, "invalidCharacter");
        assertEquals(1, set.size());

        bean.setInvalidCharacter("⑧");
        set = validator.validateProperty(bean, "invalidCharacter");
        assertEquals(1, set.size());

        bean.setInvalidCharacter("⑨");
        set = validator.validateProperty(bean, "invalidCharacter");
        assertEquals(1, set.size());

        bean.setInvalidCharacter("⑩");
        set = validator.validateProperty(bean, "invalidCharacter");
        assertEquals(1, set.size());

        bean.setInvalidCharacter("⑪");
        set = validator.validateProperty(bean, "invalidCharacter");
        assertEquals(1, set.size());

        bean.setInvalidCharacter("⑫");
        set = validator.validateProperty(bean, "invalidCharacter");
        assertEquals(1, set.size());

        bean.setInvalidCharacter("⑬");
        set = validator.validateProperty(bean, "invalidCharacter");
        assertEquals(1, set.size());

        bean.setInvalidCharacter("⑭");
        set = validator.validateProperty(bean, "invalidCharacter");
        assertEquals(1, set.size());

        bean.setInvalidCharacter("⑮");
        set = validator.validateProperty(bean, "invalidCharacter");
        assertEquals(1, set.size());

        bean.setInvalidCharacter("⑯");
        set = validator.validateProperty(bean, "invalidCharacter");
        assertEquals(1, set.size());

        bean.setInvalidCharacter("⑰");
        set = validator.validateProperty(bean, "invalidCharacter");
        assertEquals(1, set.size());

        bean.setInvalidCharacter("⑱");
        set = validator.validateProperty(bean, "invalidCharacter");
        assertEquals(1, set.size());

        bean.setInvalidCharacter("⑲");
        set = validator.validateProperty(bean, "invalidCharacter");
        assertEquals(1, set.size());

        bean.setInvalidCharacter("⑳");
        set = validator.validateProperty(bean, "invalidCharacter");
        assertEquals(1, set.size());

        bean.setInvalidCharacter("㍉");
        set = validator.validateProperty(bean, "invalidCharacter");
        assertEquals(1, set.size());

        bean.setInvalidCharacter("㌔");
        set = validator.validateProperty(bean, "invalidCharacter");
        assertEquals(1, set.size());

        bean.setInvalidCharacter("㌢");
        set = validator.validateProperty(bean, "invalidCharacter");
        assertEquals(1, set.size());

        bean.setInvalidCharacter("㍍");
        set = validator.validateProperty(bean, "invalidCharacter");
        assertEquals(1, set.size());

        bean.setInvalidCharacter("㌘");
        set = validator.validateProperty(bean, "invalidCharacter");
        assertEquals(1, set.size());

        bean.setInvalidCharacter("㌧");
        set = validator.validateProperty(bean, "invalidCharacter");
        assertEquals(1, set.size());

        bean.setInvalidCharacter("㌃");
        set = validator.validateProperty(bean, "invalidCharacter");
        assertEquals(1, set.size());

        bean.setInvalidCharacter("㌶");
        set = validator.validateProperty(bean, "invalidCharacter");
        assertEquals(1, set.size());

        bean.setInvalidCharacter("㍑");
        set = validator.validateProperty(bean, "invalidCharacter");
        assertEquals(1, set.size());

        bean.setInvalidCharacter("㍗");
        set = validator.validateProperty(bean, "invalidCharacter");
        assertEquals(1, set.size());

        bean.setInvalidCharacter("㌍");
        set = validator.validateProperty(bean, "invalidCharacter");
        assertEquals(1, set.size());

        bean.setInvalidCharacter("㌦");
        set = validator.validateProperty(bean, "invalidCharacter");
        assertEquals(1, set.size());

        bean.setInvalidCharacter("㌣");
        set = validator.validateProperty(bean, "invalidCharacter");
        assertEquals(1, set.size());

        bean.setInvalidCharacter("㌫");
        set = validator.validateProperty(bean, "invalidCharacter");
        assertEquals(1, set.size());

        bean.setInvalidCharacter("㍊");
        set = validator.validateProperty(bean, "invalidCharacter");
        assertEquals(1, set.size());

        bean.setInvalidCharacter("㌻");
        set = validator.validateProperty(bean, "invalidCharacter");
        assertEquals(1, set.size());

        bean.setInvalidCharacter("㎜");
        set = validator.validateProperty(bean, "invalidCharacter");
        assertEquals(1, set.size());

        bean.setInvalidCharacter("㎝");
        set = validator.validateProperty(bean, "invalidCharacter");
        assertEquals(1, set.size());

        bean.setInvalidCharacter("㎞");
        set = validator.validateProperty(bean, "invalidCharacter");
        assertEquals(1, set.size());

        bean.setInvalidCharacter("㎎");
        set = validator.validateProperty(bean, "invalidCharacter");
        assertEquals(1, set.size());

        bean.setInvalidCharacter("㎏");
        set = validator.validateProperty(bean, "invalidCharacter");
        assertEquals(1, set.size());

        bean.setInvalidCharacter("㏄");
        set = validator.validateProperty(bean, "invalidCharacter");
        assertEquals(1, set.size());

        bean.setInvalidCharacter("㍻");
        set = validator.validateProperty(bean, "invalidCharacter");
        assertEquals(1, set.size());

        bean.setInvalidCharacter("〝");
        set = validator.validateProperty(bean, "invalidCharacter");
        assertEquals(1, set.size());

        bean.setInvalidCharacter("〟");
        set = validator.validateProperty(bean, "invalidCharacter");
        assertEquals(1, set.size());

        bean.setInvalidCharacter("㏍");
        set = validator.validateProperty(bean, "invalidCharacter");
        assertEquals(1, set.size());

        bean.setInvalidCharacter("㊤");
        set = validator.validateProperty(bean, "invalidCharacter");
        assertEquals(1, set.size());

        bean.setInvalidCharacter("㊥");
        set = validator.validateProperty(bean, "invalidCharacter");
        assertEquals(1, set.size());

        bean.setInvalidCharacter("㊦");
        set = validator.validateProperty(bean, "invalidCharacter");
        assertEquals(1, set.size());

        bean.setInvalidCharacter("㊧");
        set = validator.validateProperty(bean, "invalidCharacter");
        assertEquals(1, set.size());

        bean.setInvalidCharacter("㊨");
        set = validator.validateProperty(bean, "invalidCharacter");
        assertEquals(1, set.size());

        bean.setInvalidCharacter("㈲");
        set = validator.validateProperty(bean, "invalidCharacter");
        assertEquals(1, set.size());

        bean.setInvalidCharacter("㈹");
        set = validator.validateProperty(bean, "invalidCharacter");
        assertEquals(1, set.size());

        bean.setInvalidCharacter("㍾");
        set = validator.validateProperty(bean, "invalidCharacter");
        assertEquals(1, set.size());

        bean.setInvalidCharacter("㍽");
        set = validator.validateProperty(bean, "invalidCharacter");
        assertEquals(1, set.size());

        bean.setInvalidCharacter("㍼");
        set = validator.validateProperty(bean, "invalidCharacter");
        assertEquals(1, set.size());

        bean.setInvalidCharacter("≒");
        set = validator.validateProperty(bean, "invalidCharacter");
        assertEquals(1, set.size());

        bean.setInvalidCharacter("≡");
        set = validator.validateProperty(bean, "invalidCharacter");
        assertEquals(1, set.size());

        bean.setInvalidCharacter("∫");
        set = validator.validateProperty(bean, "invalidCharacter");
        assertEquals(1, set.size());

        bean.setInvalidCharacter("∮");
        set = validator.validateProperty(bean, "invalidCharacter");
        assertEquals(1, set.size());

        bean.setInvalidCharacter("Σ");
        set = validator.validateProperty(bean, "invalidCharacter");
        assertEquals(1, set.size());

        bean.setInvalidCharacter("√");
        set = validator.validateProperty(bean, "invalidCharacter");
        assertEquals(1, set.size());

        bean.setInvalidCharacter("⊥");
        set = validator.validateProperty(bean, "invalidCharacter");
        assertEquals(1, set.size());

        bean.setInvalidCharacter("∠");
        set = validator.validateProperty(bean, "invalidCharacter");
        assertEquals(1, set.size());

        bean.setInvalidCharacter("∟");
        set = validator.validateProperty(bean, "invalidCharacter");
        assertEquals(1, set.size());

        bean.setInvalidCharacter("⊿");
        set = validator.validateProperty(bean, "invalidCharacter");
        assertEquals(1, set.size());

        bean.setInvalidCharacter("∩");
        set = validator.validateProperty(bean, "invalidCharacter");
        assertEquals(1, set.size());

        bean.setInvalidCharacter("∪");
        set = validator.validateProperty(bean, "invalidCharacter");
        assertEquals(1, set.size());

    }

    @Test
    public void testHostInvalidCharacter() {

        bean.setHostInvalidCharacter(null);
        Set<ConstraintViolation<Bean>> set = validator.validateProperty(bean, "hostInvalidCharacter");
        assertEquals(0, set.size());

        bean.setHostInvalidCharacter("");
        set = validator.validateProperty(bean, "hostInvalidCharacter");
        assertEquals(0, set.size());

        bean.setHostInvalidCharacter("ａッ｛");
        set = validator.validateProperty(bean, "hostInvalidCharacter");
        assertEquals(1, set.size());

        bean.setHostInvalidCharacter("ａッ｛あいう");
        set = validator.validateProperty(bean, "hostInvalidCharacter");
        assertEquals(1, set.size());

        bean.setHostInvalidCharacter("あいうａッ｛えおか");
        set = validator.validateProperty(bean, "hostInvalidCharacter");
        assertEquals(1, set.size());

        bean.setHostInvalidCharacter("あいうａッ｛");
        set = validator.validateProperty(bean, "hostInvalidCharacter");
        assertEquals(1, set.size());

        bean.setHostInvalidCharacter("あア亜Ａ？");
        set = validator.validateProperty(bean, "hostInvalidCharacter");
        assertEquals(0, set.size());

        bean.setHostInvalidCharacter("aｯ{");
        set = validator.validateProperty(bean, "hostInvalidCharacter");
        assertEquals(1, set.size());

        bean.setHostInvalidCharacter("aｯ{あいう");
        set = validator.validateProperty(bean, "hostInvalidCharacter");
        assertEquals(1, set.size());

        bean.setHostInvalidCharacter("あいうaｯ{えおか");
        set = validator.validateProperty(bean, "hostInvalidCharacter");
        assertEquals(1, set.size());

        bean.setHostInvalidCharacter("あいうaｯ{");
        set = validator.validateProperty(bean, "hostInvalidCharacter");
        assertEquals(1, set.size());

        bean.setHostInvalidCharacter("ｱA?");
        set = validator.validateProperty(bean, "hostInvalidCharacter");
        assertEquals(0, set.size());

        bean.setHostInvalidCharacter("ａ");
        set = validator.validateProperty(bean, "hostInvalidCharacter");
        assertEquals(1, set.size());

        bean.setHostInvalidCharacter("ｂ");
        set = validator.validateProperty(bean, "hostInvalidCharacter");
        assertEquals(1, set.size());

        bean.setHostInvalidCharacter("ｃ");
        set = validator.validateProperty(bean, "hostInvalidCharacter");
        assertEquals(1, set.size());

        bean.setHostInvalidCharacter("ｄ");
        set = validator.validateProperty(bean, "hostInvalidCharacter");
        assertEquals(1, set.size());

        bean.setHostInvalidCharacter("ｅ");
        set = validator.validateProperty(bean, "hostInvalidCharacter");
        assertEquals(1, set.size());

        bean.setHostInvalidCharacter("ｆ");
        set = validator.validateProperty(bean, "hostInvalidCharacter");
        assertEquals(1, set.size());

        bean.setHostInvalidCharacter("ｇ");
        set = validator.validateProperty(bean, "hostInvalidCharacter");
        assertEquals(1, set.size());

        bean.setHostInvalidCharacter("ｈ");
        set = validator.validateProperty(bean, "hostInvalidCharacter");
        assertEquals(1, set.size());

        bean.setHostInvalidCharacter("ｉ");
        set = validator.validateProperty(bean, "hostInvalidCharacter");
        assertEquals(1, set.size());

        bean.setHostInvalidCharacter("ｊ");
        set = validator.validateProperty(bean, "hostInvalidCharacter");
        assertEquals(1, set.size());

        bean.setHostInvalidCharacter("ｋ");
        set = validator.validateProperty(bean, "hostInvalidCharacter");
        assertEquals(1, set.size());

        bean.setHostInvalidCharacter("ｌ");
        set = validator.validateProperty(bean, "hostInvalidCharacter");
        assertEquals(1, set.size());

        bean.setHostInvalidCharacter("ｍ");
        set = validator.validateProperty(bean, "hostInvalidCharacter");
        assertEquals(1, set.size());

        bean.setHostInvalidCharacter("ｎ");
        set = validator.validateProperty(bean, "hostInvalidCharacter");
        assertEquals(1, set.size());

        bean.setHostInvalidCharacter("ｏ");
        set = validator.validateProperty(bean, "hostInvalidCharacter");
        assertEquals(1, set.size());

        bean.setHostInvalidCharacter("ｐ");
        set = validator.validateProperty(bean, "hostInvalidCharacter");
        assertEquals(1, set.size());

        bean.setHostInvalidCharacter("ｑ");
        set = validator.validateProperty(bean, "hostInvalidCharacter");
        assertEquals(1, set.size());

        bean.setHostInvalidCharacter("ｒ");
        set = validator.validateProperty(bean, "hostInvalidCharacter");
        assertEquals(1, set.size());

        bean.setHostInvalidCharacter("ｓ");
        set = validator.validateProperty(bean, "hostInvalidCharacter");
        assertEquals(1, set.size());

        bean.setHostInvalidCharacter("ｔ");
        set = validator.validateProperty(bean, "hostInvalidCharacter");
        assertEquals(1, set.size());

        bean.setHostInvalidCharacter("ｕ");
        set = validator.validateProperty(bean, "hostInvalidCharacter");
        assertEquals(1, set.size());

        bean.setHostInvalidCharacter("ｖ");
        set = validator.validateProperty(bean, "hostInvalidCharacter");
        assertEquals(1, set.size());

        bean.setHostInvalidCharacter("ｗ");
        set = validator.validateProperty(bean, "hostInvalidCharacter");
        assertEquals(1, set.size());

        bean.setHostInvalidCharacter("ｘ");
        set = validator.validateProperty(bean, "hostInvalidCharacter");
        assertEquals(1, set.size());

        bean.setHostInvalidCharacter("ｙ");
        set = validator.validateProperty(bean, "hostInvalidCharacter");
        assertEquals(1, set.size());

        bean.setHostInvalidCharacter("ｚ");
        set = validator.validateProperty(bean, "hostInvalidCharacter");
        assertEquals(1, set.size());

        bean.setHostInvalidCharacter("ヲ");
        set = validator.validateProperty(bean, "hostInvalidCharacter");
        assertEquals(1, set.size());

        bean.setHostInvalidCharacter("ァ");
        set = validator.validateProperty(bean, "hostInvalidCharacter");
        assertEquals(1, set.size());

        bean.setHostInvalidCharacter("ィ");
        set = validator.validateProperty(bean, "hostInvalidCharacter");
        assertEquals(1, set.size());

        bean.setHostInvalidCharacter("ゥ");
        set = validator.validateProperty(bean, "hostInvalidCharacter");
        assertEquals(1, set.size());

        bean.setHostInvalidCharacter("ェ");
        set = validator.validateProperty(bean, "hostInvalidCharacter");
        assertEquals(1, set.size());

        bean.setHostInvalidCharacter("ォ");
        set = validator.validateProperty(bean, "hostInvalidCharacter");
        assertEquals(1, set.size());

        bean.setHostInvalidCharacter("ャ");
        set = validator.validateProperty(bean, "hostInvalidCharacter");
        assertEquals(1, set.size());

        bean.setHostInvalidCharacter("ュ");
        set = validator.validateProperty(bean, "hostInvalidCharacter");
        assertEquals(1, set.size());

        bean.setHostInvalidCharacter("ョ");
        set = validator.validateProperty(bean, "hostInvalidCharacter");
        assertEquals(1, set.size());

        bean.setHostInvalidCharacter("ッ");
        set = validator.validateProperty(bean, "hostInvalidCharacter");
        assertEquals(1, set.size());

        bean.setHostInvalidCharacter("！");
        set = validator.validateProperty(bean, "hostInvalidCharacter");
        assertEquals(1, set.size());

        bean.setHostInvalidCharacter("［");
        set = validator.validateProperty(bean, "hostInvalidCharacter");
        assertEquals(1, set.size());

        bean.setHostInvalidCharacter("］");
        set = validator.validateProperty(bean, "hostInvalidCharacter");
        assertEquals(1, set.size());

        bean.setHostInvalidCharacter("＾");
        set = validator.validateProperty(bean, "hostInvalidCharacter");
        assertEquals(1, set.size());

        bean.setHostInvalidCharacter("ー");
        set = validator.validateProperty(bean, "hostInvalidCharacter");
        assertEquals(1, set.size());

        bean.setHostInvalidCharacter("｀");
        set = validator.validateProperty(bean, "hostInvalidCharacter");
        assertEquals(1, set.size());

        bean.setHostInvalidCharacter("｛");
        set = validator.validateProperty(bean, "hostInvalidCharacter");
        assertEquals(1, set.size());

        bean.setHostInvalidCharacter("│");
        set = validator.validateProperty(bean, "hostInvalidCharacter");
        assertEquals(1, set.size());

        bean.setHostInvalidCharacter("｝");
        set = validator.validateProperty(bean, "hostInvalidCharacter");
        assertEquals(1, set.size());

        bean.setHostInvalidCharacter("￣");
        set = validator.validateProperty(bean, "hostInvalidCharacter");
        assertEquals(1, set.size());

        bean.setHostInvalidCharacter("a");
        set = validator.validateProperty(bean, "hostInvalidCharacter");
        assertEquals(1, set.size());

        bean.setHostInvalidCharacter("b");
        set = validator.validateProperty(bean, "hostInvalidCharacter");
        assertEquals(1, set.size());

        bean.setHostInvalidCharacter("c");
        set = validator.validateProperty(bean, "hostInvalidCharacter");
        assertEquals(1, set.size());

        bean.setHostInvalidCharacter("d");
        set = validator.validateProperty(bean, "hostInvalidCharacter");
        assertEquals(1, set.size());

        bean.setHostInvalidCharacter("e");
        set = validator.validateProperty(bean, "hostInvalidCharacter");
        assertEquals(1, set.size());

        bean.setHostInvalidCharacter("f");
        set = validator.validateProperty(bean, "hostInvalidCharacter");
        assertEquals(1, set.size());

        bean.setHostInvalidCharacter("g");
        set = validator.validateProperty(bean, "hostInvalidCharacter");
        assertEquals(1, set.size());

        bean.setHostInvalidCharacter("h");
        set = validator.validateProperty(bean, "hostInvalidCharacter");
        assertEquals(1, set.size());

        bean.setHostInvalidCharacter("i");
        set = validator.validateProperty(bean, "hostInvalidCharacter");
        assertEquals(1, set.size());

        bean.setHostInvalidCharacter("j");
        set = validator.validateProperty(bean, "hostInvalidCharacter");
        assertEquals(1, set.size());

        bean.setHostInvalidCharacter("k");
        set = validator.validateProperty(bean, "hostInvalidCharacter");
        assertEquals(1, set.size());

        bean.setHostInvalidCharacter("l");
        set = validator.validateProperty(bean, "hostInvalidCharacter");
        assertEquals(1, set.size());

        bean.setHostInvalidCharacter("m");
        set = validator.validateProperty(bean, "hostInvalidCharacter");
        assertEquals(1, set.size());

        bean.setHostInvalidCharacter("n");
        set = validator.validateProperty(bean, "hostInvalidCharacter");
        assertEquals(1, set.size());

        bean.setHostInvalidCharacter("o");
        set = validator.validateProperty(bean, "hostInvalidCharacter");
        assertEquals(1, set.size());

        bean.setHostInvalidCharacter("p");
        set = validator.validateProperty(bean, "hostInvalidCharacter");
        assertEquals(1, set.size());

        bean.setHostInvalidCharacter("q");
        set = validator.validateProperty(bean, "hostInvalidCharacter");
        assertEquals(1, set.size());

        bean.setHostInvalidCharacter("r");
        set = validator.validateProperty(bean, "hostInvalidCharacter");
        assertEquals(1, set.size());

        bean.setHostInvalidCharacter("s");
        set = validator.validateProperty(bean, "hostInvalidCharacter");
        assertEquals(1, set.size());

        bean.setHostInvalidCharacter("t");
        set = validator.validateProperty(bean, "hostInvalidCharacter");
        assertEquals(1, set.size());

        bean.setHostInvalidCharacter("u");
        set = validator.validateProperty(bean, "hostInvalidCharacter");
        assertEquals(1, set.size());

        bean.setHostInvalidCharacter("v");
        set = validator.validateProperty(bean, "hostInvalidCharacter");
        assertEquals(1, set.size());

        bean.setHostInvalidCharacter("w");
        set = validator.validateProperty(bean, "hostInvalidCharacter");
        assertEquals(1, set.size());

        bean.setHostInvalidCharacter("x");
        set = validator.validateProperty(bean, "hostInvalidCharacter");
        assertEquals(1, set.size());

        bean.setHostInvalidCharacter("y");
        set = validator.validateProperty(bean, "hostInvalidCharacter");
        assertEquals(1, set.size());

        bean.setHostInvalidCharacter("z");
        set = validator.validateProperty(bean, "hostInvalidCharacter");
        assertEquals(1, set.size());

        bean.setHostInvalidCharacter("ｦ");
        set = validator.validateProperty(bean, "hostInvalidCharacter");
        assertEquals(1, set.size());

        bean.setHostInvalidCharacter("ｧ");
        set = validator.validateProperty(bean, "hostInvalidCharacter");
        assertEquals(1, set.size());

        bean.setHostInvalidCharacter("ｨ");
        set = validator.validateProperty(bean, "hostInvalidCharacter");
        assertEquals(1, set.size());

        bean.setHostInvalidCharacter("ｩ");
        set = validator.validateProperty(bean, "hostInvalidCharacter");
        assertEquals(1, set.size());

        bean.setHostInvalidCharacter("ｪ");
        set = validator.validateProperty(bean, "hostInvalidCharacter");
        assertEquals(1, set.size());

        bean.setHostInvalidCharacter("ｫ");
        set = validator.validateProperty(bean, "hostInvalidCharacter");
        assertEquals(1, set.size());

        bean.setHostInvalidCharacter("ｬ");
        set = validator.validateProperty(bean, "hostInvalidCharacter");
        assertEquals(1, set.size());

        bean.setHostInvalidCharacter("ｭ");
        set = validator.validateProperty(bean, "hostInvalidCharacter");
        assertEquals(1, set.size());

        bean.setHostInvalidCharacter("ｮ");
        set = validator.validateProperty(bean, "hostInvalidCharacter");
        assertEquals(1, set.size());

        bean.setHostInvalidCharacter("ｯ");
        set = validator.validateProperty(bean, "hostInvalidCharacter");
        assertEquals(1, set.size());

        bean.setHostInvalidCharacter("!");
        set = validator.validateProperty(bean, "hostInvalidCharacter");
        assertEquals(1, set.size());

        bean.setHostInvalidCharacter("[");
        set = validator.validateProperty(bean, "hostInvalidCharacter");
        assertEquals(1, set.size());

        bean.setHostInvalidCharacter("]");
        set = validator.validateProperty(bean, "hostInvalidCharacter");
        assertEquals(1, set.size());

        bean.setHostInvalidCharacter("^");
        set = validator.validateProperty(bean, "hostInvalidCharacter");
        assertEquals(1, set.size());

        bean.setHostInvalidCharacter("ｰ");
        set = validator.validateProperty(bean, "hostInvalidCharacter");
        assertEquals(1, set.size());

        bean.setHostInvalidCharacter("`");
        set = validator.validateProperty(bean, "hostInvalidCharacter");
        assertEquals(1, set.size());

        bean.setHostInvalidCharacter("{");
        set = validator.validateProperty(bean, "hostInvalidCharacter");
        assertEquals(1, set.size());

        bean.setHostInvalidCharacter("|");
        set = validator.validateProperty(bean, "hostInvalidCharacter");
        assertEquals(1, set.size());

        bean.setHostInvalidCharacter("}");
        set = validator.validateProperty(bean, "hostInvalidCharacter");
        assertEquals(1, set.size());

        bean.setHostInvalidCharacter("~");
        set = validator.validateProperty(bean, "hostInvalidCharacter");
        assertEquals(1, set.size());

    }

    @Test
    public void testModulus10w21(){
        bean.setModulus10w21("201511193");
        Set<ConstraintViolation<Bean>> set = validator.validateProperty(bean, "modulus10w21");
        assertEquals(0, set.size());

        bean.setModulus10w21("２０１５１１１９３");
        set = validator.validateProperty(bean, "modulus10w21");
        assertEquals(1, set.size());
        assertEquals("item-idはチェックディジットが不正です。入力値を確認してください。",
            MessageUtil.getMessage(set.iterator().next().getMessage().substring(1, 8)));

        bean.setModulus10w21("201511190");
        set = validator.validateProperty(bean, "modulus10w21");
        assertEquals(1, set.size());

        bean.setModulus10w21("1");
        set = validator.validateProperty(bean, "modulus10w21");
        assertEquals(0, set.size());

        bean.setModulus10w21("18");
        set = validator.validateProperty(bean, "modulus10w21");
        assertEquals(0, set.size());

        bean.setModulus10w21("59");
        set = validator.validateProperty(bean, "modulus10w21");
        assertEquals(0, set.size());

        bean.setModulus10w21("810");
        set = validator.validateProperty(bean, "modulus10w21");
        assertEquals(0, set.size());

        bean.setModulus10w21("0");
        set = validator.validateProperty(bean, "modulus10w21");
        assertEquals(1, set.size());

        bean.setModulus10w21("00000000000000000");
        set = validator.validateProperty(bean, "modulus10w21");
        assertEquals(1, set.size());

        bean.setModulus10w21("10000000000000009");
        set = validator.validateProperty(bean, "modulus10w21");
        assertEquals(0, set.size());

        bean.setModulus10w21("000000000000000018");
        set = validator.validateProperty(bean, "modulus10w21");
        assertEquals(0, set.size());

        bean.setModulus10w21("");
        set = validator.validateProperty(bean, "modulus10w21");
        assertEquals(0, set.size());

        bean.setModulus10w21("a");
        set = validator.validateProperty(bean, "modulus10w21");
        assertEquals(1, set.size());

        bean.setModulus10w21("1a11");
        set = validator.validateProperty(bean, "modulus10w21");
        assertEquals(1, set.size());

        bean.setModulus10w21("+");
        set = validator.validateProperty(bean, "modulus10w21");
        assertEquals(1, set.size());

        bean.setModulus10w21("あ");
        set = validator.validateProperty(bean, "modulus10w21");
        assertEquals(1, set.size());

        bean.setModulus10w21("ア");
        set = validator.validateProperty(bean, "modulus10w21");
        assertEquals(1, set.size());

        bean.setModulus10w21("亜");
        set = validator.validateProperty(bean, "modulus10w21");
        assertEquals(1, set.size());

        bean.setModulus10w21(null);
        set = validator.validateProperty(bean, "modulus10w21");
        assertEquals(0, set.size());

    }
}
