package yuyu.infr.validation;

import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.date.BizDateMD;
import jp.co.slcs.swak.date.BizDateY;
import jp.co.slcs.swak.date.BizDateYM;
import jp.co.slcs.swak.number.BizCurrency;
import jp.co.slcs.swak.number.BizNumber;
import jp.co.slcs.swak.number.BizRate;
import jp.co.slcs.swak.validation.constraints.AlphaDigit;
import jp.co.slcs.swak.validation.constraints.AlphaDigitOrExceptionCode;
import jp.co.slcs.swak.validation.constraints.CurrencyLenght;
import jp.co.slcs.swak.validation.constraints.CurrencyPrecision;
import jp.co.slcs.swak.validation.constraints.DecimalRangeBizCalcable;
import jp.co.slcs.swak.validation.constraints.DecimalRangeNumber;
import jp.co.slcs.swak.validation.constraints.Digit;
import jp.co.slcs.swak.validation.constraints.Length;
import jp.co.slcs.swak.validation.constraints.LengthRange;
import jp.co.slcs.swak.validation.constraints.Max;
import jp.co.slcs.swak.validation.constraints.MaxBizCalcable;
import jp.co.slcs.swak.validation.constraints.MaxLength;
import jp.co.slcs.swak.validation.constraints.Min;
import jp.co.slcs.swak.validation.constraints.MinBizCalcable;
import jp.co.slcs.swak.validation.constraints.MinLength;
import jp.co.slcs.swak.validation.constraints.MultiByteStrings;
import jp.co.slcs.swak.validation.constraints.MultiByteStringsReturnable;
import jp.co.slcs.swak.validation.constraints.NaturalNumber;
import jp.co.slcs.swak.validation.constraints.NaturalNumberBizCalcable;
import jp.co.slcs.swak.validation.constraints.NonZero;
import jp.co.slcs.swak.validation.constraints.NonZeroBizCalcble;
import jp.co.slcs.swak.validation.constraints.Pattern;
import jp.co.slcs.swak.validation.constraints.PositiveNumber;
import jp.co.slcs.swak.validation.constraints.PositiveNumberBizCalcble;
import jp.co.slcs.swak.validation.constraints.Range;
import jp.co.slcs.swak.validation.constraints.RangeBizCalcable;
import jp.co.slcs.swak.validation.constraints.SingleByteStrings;
import jp.co.slcs.swak.validation.constraints.SingleByteStringsReturnable;
import jp.co.slcs.swak.validation.constraints.Time;
import jp.co.slcs.swak.validation.constraints.TimeHM;
import jp.co.slcs.swak.validation.constraints.ValidDate;
import jp.co.slcs.swak.validation.constraints.ValidDateMd;
import jp.co.slcs.swak.validation.constraints.ValidDateY;
import jp.co.slcs.swak.validation.constraints.ValidDateYm;
import jp.co.slcs.swak.validation.constraints.ValidTextArea;
import yuyu.infr.validation.constraints.HostInvalidCharacter;
import yuyu.infr.validation.constraints.InvalidCharacter;
import yuyu.infr.validation.constraints.Modulus10w21;
import yuyu.infr.validation.constraints.SyoukenNo;
import yuyu.infr.validation.constraints.Tel;
import yuyu.infr.validation.constraints.ZipCode;

public class Bean {

    @Pattern(regex = "^\\d{3}-\\d{4}$")
    private String pattern;

    @SingleByteStrings
    private String singleByteStrings;

    @SingleByteStringsReturnable
    private String singleByteStringsReturnable;

    @AlphaDigit
    private String alphaDigit;

    @AlphaDigitOrExceptionCode(except = "=")
    private String alphaDigitOrExceptionCode;

    @MultiByteStrings
    private String multiByteStrings;

    @MultiByteStringsReturnable
    private String multiByteStringsReturnable;

    @Length(length = 10)
    private String length;

    @LengthRange(max = 4, min = 2)
    private String lengthRange;

    @MaxLength(max = 10)
    private String maxLength;

    @MinLength(min = 5)
    private String minLength;

    @ValidTextArea(length = 5, rows = 3)
    private String validTextArea;

    @Digit
    private String digit;

    @Pattern(message = "{pattern.KinyuuKana.message}", regex = "^[アイウエオ-ヂツ-モヤユヨ-ロワヲ-ヴー０-９Ａ-Ｚ’（）＋－，．／：？]+$")
    private String kinyuukikankanatyekku;

    @Pattern(message = "{pattern.MailAddress.message}", regex = "^[\\w!#$%&'*+/=?^_{}\\\\|~-]+([\\w!#$%&'*+/=?^_{}\\\\|~\\.-]+)*@([\\w][\\w-]*\\.)+[\\w][\\w-]*$")
    private String mailAddress;

    @ZipCode
    private String zipCode;

    @Tel
    private String tel;

    @InvalidCharacter
    private String invalidCharacter;

    @SyoukenNo
    private String syoukenNo2;
    
    @HostInvalidCharacter
    private String hostInvalidCharacter;

    @Pattern(message = "{pattern.NenkinSyousyoNo.message}", regex = "^[a-zA-Z0-9]{1,11}$")
    private String nenkinsyousyoBangou;

    @Pattern(message = "{pattern.SyoukenNo.message}", regex = "^[a-zA-Z0-9]{1,11}$")
    private String syoukenNo;

    // @Pattern
    // private String inValidString;

    @NonZero
    private Double doubleNonZero;

    @NonZero
    private Long longNonZero;

    @NonZero
    private Integer integerNonZero;

    @NonZeroBizCalcble
    private BizCurrency bizCurrencyNonZeroBizCalcable;

    @NonZeroBizCalcble
    private BizRate bizRateNonZeroBizCalcable;

    @NonZeroBizCalcble
    private BizNumber bizNumberNonZeroBizCalcable;

    @Range(max = "9.99", min = "-9.99")
    private Double doubleRange;

    @RangeBizCalcable(max = "9.99", min = "-9.99")
    private BizRate bizRateRangeBizCalcable;

    @RangeBizCalcable(max = "9.99", min = "-9.99")
    private BizNumber bizNumberRangeBizCalcable;

    @Range(max = "9", min = "-9")
    private Long longRange;

    @Range(max = "9", min = "-9")
    private Integer integerRange;

    @Max(max = "9.99")
    private Double doubleMax;

    @MaxBizCalcable(max = "9.99")
    private BizRate bizRateMaxBizCalcable;

    @MaxBizCalcable(max = "9.99")
    private BizNumber bizNumberMaxBizCalcable;

    @Max(max = "9")
    private Long longMax;

    @Max(max = "9")
    private Integer integerMax;

    @Min(min = "9.99")
    private Double doubleMin;

    @MinBizCalcable(min = "9.99")
    private BizRate bizRateMinBizCalcable;

    @MinBizCalcable(min = "9.99")
    private BizNumber bizNumberMinBizCalcable;

    @Min(min = "9")
    private Long longMin;

    @Min(min = "9")
    private Integer integerMin;

    @CurrencyLenght(length = 10)
    private BizCurrency currencyLength;

    @CurrencyPrecision(precision = 2)
    private BizCurrency currencyPrecision;

    @DecimalRangeNumber(max = "9.99", min = "-9.99", scale = 2)
    private Double doubleDecimalRangeNumber;

    @DecimalRangeBizCalcable(max = "9.99", min = "-9.99", scale = 2)
    private BizCurrency bizCurrencyDecimalRangeBizCalcable;

    @DecimalRangeBizCalcable(max = "9.99", min = "-9.99", scale = 2)
    private BizRate bizRateDecimalRangeBizCalcable;

    @DecimalRangeBizCalcable(max = "9.99", min = "-9.99", scale = 2)
    private BizNumber bizNumberDecimalRangeBizCalcable;

    @PositiveNumber
    private Double doublePositiveNumber;

    @PositiveNumber
    private Long longPositiveNumber;

    @PositiveNumber
    private Integer integerPositiveNumber;

    @PositiveNumberBizCalcble
    private BizCurrency bizCurrencyPositiveNumberBizCalcble;

    @PositiveNumberBizCalcble
    private BizRate bizRatePositiveNumberBizCalcble;

    @PositiveNumberBizCalcble
    private BizNumber bizNumberPositiveNumberBizCalcble;

    @NaturalNumber
    private Long longNaturalNumber;

    @NaturalNumber
    private Integer integerNaturalNumber;

    @NaturalNumberBizCalcable
    private BizRate bizRateNaturalNumberBizCalcable;

    @NaturalNumberBizCalcable
    private BizNumber bizNumberNaturalNumberBizCalcable;

    @TimeHM
    private String timeHM;

    @Time
    private String time;

    @ValidDateY
    private BizDateY validDateY;

    @ValidDateYm
    private BizDateYM validDateYM;

    @ValidDate
    private BizDate validDate;

    @ValidDateMd
    private BizDateMD validDateMD;

    @Modulus10w21
    private String modulus10w21;

    public String getPattern() {
        return pattern;
    }

    public void setPattern(String pattern) {
        this.pattern = pattern;
    }

    public String getSingleByteStrings() {
        return singleByteStrings;
    }

    public void setSingleByteStrings(String singleByteStrings) {
        this.singleByteStrings = singleByteStrings;
    }

    public String getSingleByteStringsReturnable() {
        return singleByteStringsReturnable;
    }

    public void setSingleByteStringsReturnable(
        String singleByteStringsReturnable) {
        this.singleByteStringsReturnable = singleByteStringsReturnable;
    }

    public String getAlphaDigit() {
        return alphaDigit;
    }

    public void setAlphaDigit(String alphaDigit) {
        this.alphaDigit = alphaDigit;
    }

    public String getAlphaDigitOrExceptionCode() {
        return alphaDigitOrExceptionCode;
    }

    public void setAlphaDigitOrExceptionCode(String alphaDigitOrExceptionCode) {
        this.alphaDigitOrExceptionCode = alphaDigitOrExceptionCode;
    }

    public String getMultiByteStrings() {
        return multiByteStrings;
    }

    public void setMultiByteStrings(String multiByteStrings) {
        this.multiByteStrings = multiByteStrings;
    }

    public String getMultiByteStringsReturnable() {
        return multiByteStringsReturnable;
    }

    public void setMultiByteStringsReturnable(String multiByteStringsReturnable) {
        this.multiByteStringsReturnable = multiByteStringsReturnable;
    }

    public String getLength() {
        return length;
    }

    public void setLength(String length) {
        this.length = length;
    }

    public String getLengthRange() {
        return lengthRange;
    }

    public void setLengthRange(String lengthRange) {
        this.lengthRange = lengthRange;
    }

    public String getMaxLength() {
        return maxLength;
    }

    public void setMaxLength(String maxLength) {
        this.maxLength = maxLength;
    }

    public String getMinLength() {
        return minLength;
    }

    public void setMinLength(String minLength) {
        this.minLength = minLength;
    }

    public String getValidTextArea() {
        return validTextArea;
    }

    public void setValidTextArea(String validTextArea) {
        this.validTextArea = validTextArea;
    }

    public String getDigit() {
        return digit;
    }

    public void setDigit(String digit) {
        this.digit = digit;
    }

    public String getKinyuukikankanatyekku() {
        return kinyuukikankanatyekku;
    }

    public void setKinyuukikankanatyekku(String kinyuukikankanatyekku) {
        this.kinyuukikankanatyekku = kinyuukikankanatyekku;
    }

    public String getMailAddress() {
        return mailAddress;
    }

    public void setMailAddress(String mailAddress) {
        this.mailAddress = mailAddress;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getNenkinsyousyoBangou() {
        return nenkinsyousyoBangou;
    }

    public void setNenkinsyousyoBangou(String nenkinsyousyoBangou) {
        this.nenkinsyousyoBangou = nenkinsyousyoBangou;
    }

    public String getSyoukenNo() {
        return syoukenNo;
    }

    public void setSyoukenNo(String syoukenNo) {
        this.syoukenNo = syoukenNo;
    }

    public Double getDoubleNonZero() {
        return doubleNonZero;
    }

    public void setDoubleNonZero(Double doubleNonZero) {
        this.doubleNonZero = doubleNonZero;
    }

    public Long getLongNonZero() {
        return longNonZero;
    }

    public void setLongNonZero(Long longNonZero) {
        this.longNonZero = longNonZero;
    }

    public Integer getIntegerNonZero() {
        return integerNonZero;
    }

    public void setIntegerNonZero(Integer integerNonZero) {
        this.integerNonZero = integerNonZero;
    }

    public BizCurrency getBizCurrencyNonZeroBizCalcable() {
        return bizCurrencyNonZeroBizCalcable;
    }

    public void setBizCurrencyNonZeroBizCalcable(
        BizCurrency bizCurrencyNonZeroBizCalcable) {
        this.bizCurrencyNonZeroBizCalcable = bizCurrencyNonZeroBizCalcable;
    }

    public BizRate getBizRateNonZeroBizCalcable() {
        return bizRateNonZeroBizCalcable;
    }

    public void setBizRateNonZeroBizCalcable(BizRate bizRateNonZeroBizCalcable) {
        this.bizRateNonZeroBizCalcable = bizRateNonZeroBizCalcable;
    }

    public BizNumber getBizNumberNonZeroBizCalcable() {
        return bizNumberNonZeroBizCalcable;
    }

    public void setBizNumberNonZeroBizCalcable(
        BizNumber bizNumberNonZeroBizCalcable) {
        this.bizNumberNonZeroBizCalcable = bizNumberNonZeroBizCalcable;
    }

    public Double getDoubleRange() {
        return doubleRange;
    }

    public void setDoubleRange(Double doubleRange) {
        this.doubleRange = doubleRange;
    }

    public BizRate getBizRateRangeBizCalcable() {
        return bizRateRangeBizCalcable;
    }

    public void setBizRateRangeBizCalcable(BizRate bizRateRangeBizCalcable) {
        this.bizRateRangeBizCalcable = bizRateRangeBizCalcable;
    }

    public BizNumber getBizNumberRangeBizCalcable() {
        return bizNumberRangeBizCalcable;
    }

    public void setBizNumberRangeBizCalcable(BizNumber bizNumberRangeBizCalcable) {
        this.bizNumberRangeBizCalcable = bizNumberRangeBizCalcable;
    }

    public Long getLongRange() {
        return longRange;
    }

    public void setLongRange(Long longRange) {
        this.longRange = longRange;
    }

    public Integer getIntegerRange() {
        return integerRange;
    }

    public void setIntegerRange(Integer integerRange) {
        this.integerRange = integerRange;
    }

    public Double getDoubleMax() {
        return doubleMax;
    }

    public void setDoubleMax(Double doubleMax) {
        this.doubleMax = doubleMax;
    }

    public BizRate getBizRateMaxBizCalcable() {
        return bizRateMaxBizCalcable;
    }

    public void setBizRateMaxBizCalcable(BizRate bizRateMaxBizCalcable) {
        this.bizRateMaxBizCalcable = bizRateMaxBizCalcable;
    }

    public BizNumber getBizNumberMaxBizCalcable() {
        return bizNumberMaxBizCalcable;
    }

    public void setBizNumberMaxBizCalcable(BizNumber bizNumberMaxBizCalcable) {
        this.bizNumberMaxBizCalcable = bizNumberMaxBizCalcable;
    }

    public Long getLongMax() {
        return longMax;
    }

    public void setLongMax(Long longMax) {
        this.longMax = longMax;
    }

    public Integer getIntegerMax() {
        return integerMax;
    }

    public void setIntegerMax(Integer integerMax) {
        this.integerMax = integerMax;
    }

    public Double getDoubleMin() {
        return doubleMin;
    }

    public void setDoubleMin(Double doubleMin) {
        this.doubleMin = doubleMin;
    }

    public BizRate getBizRateMinBizCalcable() {
        return bizRateMinBizCalcable;
    }

    public void setBizRateMinBizCalcable(BizRate bizRateMinBizCalcable) {
        this.bizRateMinBizCalcable = bizRateMinBizCalcable;
    }

    public BizNumber getBizNumberMinBizCalcable() {
        return bizNumberMinBizCalcable;
    }

    public void setBizNumberMinBizCalcable(BizNumber bizNumberMinBizCalcable) {
        this.bizNumberMinBizCalcable = bizNumberMinBizCalcable;
    }

    public Long getLongMin() {
        return longMin;
    }

    public void setLongMin(Long longMin) {
        this.longMin = longMin;
    }

    public Integer getIntegerMin() {
        return integerMin;
    }

    public void setIntegerMin(Integer integerMin) {
        this.integerMin = integerMin;
    }

    public BizCurrency getCurrencyLength() {
        return currencyLength;
    }

    public void setCurrencyLength(BizCurrency currencyLength) {
        this.currencyLength = currencyLength;
    }

    public BizCurrency getCurrencyPrecision() {
        return currencyPrecision;
    }

    public void setCurrencyPrecision(BizCurrency currencyPrecision) {
        this.currencyPrecision = currencyPrecision;
    }

    public Double getDoubleDecimalRangeNumber() {
        return doubleDecimalRangeNumber;
    }

    public void setDoubleDecimalRangeNumber(Double doubleDecimalRangeNumber) {
        this.doubleDecimalRangeNumber = doubleDecimalRangeNumber;
    }

    public BizCurrency getBizCurrencyDecimalRangeBizCalcable() {
        return bizCurrencyDecimalRangeBizCalcable;
    }

    public void setBizCurrencyDecimalRangeBizCalcable(
        BizCurrency bizCurrencyDecimalRangeBizCalcable) {
        this.bizCurrencyDecimalRangeBizCalcable = bizCurrencyDecimalRangeBizCalcable;
    }

    public BizRate getBizRateDecimalRangeBizCalcable() {
        return bizRateDecimalRangeBizCalcable;
    }

    public void setBizRateDecimalRangeBizCalcable(
        BizRate bizRateDecimalRangeBizCalcable) {
        this.bizRateDecimalRangeBizCalcable = bizRateDecimalRangeBizCalcable;
    }

    public BizNumber getBizNumberDecimalRangeBizCalcable() {
        return bizNumberDecimalRangeBizCalcable;
    }

    public void setBizNumberDecimalRangeBizCalcable(
        BizNumber bizNumberDecimalRangeBizCalcable) {
        this.bizNumberDecimalRangeBizCalcable = bizNumberDecimalRangeBizCalcable;
    }

    public Double getDoublePositiveNumber() {
        return doublePositiveNumber;
    }

    public void setDoublePositiveNumber(Double doublePositiveNumber) {
        this.doublePositiveNumber = doublePositiveNumber;
    }

    public Long getLongPositiveNumber() {
        return longPositiveNumber;
    }

    public void setLongPositiveNumber(Long longPositiveNumber) {
        this.longPositiveNumber = longPositiveNumber;
    }

    public Integer getIntegerPositiveNumber() {
        return integerPositiveNumber;
    }

    public void setIntegerPositiveNumber(Integer integerPositiveNumber) {
        this.integerPositiveNumber = integerPositiveNumber;
    }

    public BizCurrency getBizCurrencyPositiveNumberBizCalcble() {
        return bizCurrencyPositiveNumberBizCalcble;
    }

    public void setBizCurrencyPositiveNumberBizCalcble(
        BizCurrency bizCurrencyPositiveNumberBizCalcble) {
        this.bizCurrencyPositiveNumberBizCalcble = bizCurrencyPositiveNumberBizCalcble;
    }

    public BizRate getBizRatePositiveNumberBizCalcble() {
        return bizRatePositiveNumberBizCalcble;
    }

    public void setBizRatePositiveNumberBizCalcble(
        BizRate bizRatePositiveNumberBizCalcble) {
        this.bizRatePositiveNumberBizCalcble = bizRatePositiveNumberBizCalcble;
    }

    public BizNumber getBizNumberPositiveNumberBizCalcble() {
        return bizNumberPositiveNumberBizCalcble;
    }

    public void setBizNumberPositiveNumberBizCalcble(
        BizNumber bizNumberPositiveNumberBizCalcble) {
        this.bizNumberPositiveNumberBizCalcble = bizNumberPositiveNumberBizCalcble;
    }

    public Long getLongNaturalNumber() {
        return longNaturalNumber;
    }

    public void setLongNaturalNumber(Long longNaturalNumber) {
        this.longNaturalNumber = longNaturalNumber;
    }

    public Integer getIntegerNaturalNumber() {
        return integerNaturalNumber;
    }

    public void setIntegerNaturalNumber(Integer integerNaturalNumber) {
        this.integerNaturalNumber = integerNaturalNumber;
    }

    public BizRate getBizRateNaturalNumberBizCalcable() {
        return bizRateNaturalNumberBizCalcable;
    }

    public void setBizRateNaturalNumberBizCalcable(
        BizRate bizRateNaturalNumberBizCalcable) {
        this.bizRateNaturalNumberBizCalcable = bizRateNaturalNumberBizCalcable;
    }

    public BizNumber getBizNumberNaturalNumberBizCalcable() {
        return bizNumberNaturalNumberBizCalcable;
    }

    public void setBizNumberNaturalNumberBizCalcable(
        BizNumber bizNumberNaturalNumberBizCalcable) {
        this.bizNumberNaturalNumberBizCalcable = bizNumberNaturalNumberBizCalcable;
    }

    public String getTimeHM() {
        return timeHM;
    }

    public void setTimeHM(String timeHM) {
        this.timeHM = timeHM;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public BizDateY getValidDateY() {
        return validDateY;
    }

    public void setValidDateY(BizDateY validDateY) {
        this.validDateY = validDateY;
    }

    public BizDateYM getValidDateYM() {
        return validDateYM;
    }

    public void setValidDateYM(BizDateYM validDateYM) {
        this.validDateYM = validDateYM;
    }

    public BizDate getValidDate() {
        return validDate;
    }

    public void setValidDate(BizDate validDate) {
        this.validDate = validDate;
    }

    public BizDateMD getValidDateMD() {
        return validDateMD;
    }

    public void setValidDateMD(BizDateMD validDateMD) {
        this.validDateMD = validDateMD;
    }

    public String getInvalidCharacter() {
        return invalidCharacter;
    }

    public void setInvalidCharacter(String invalidCharacter) {
        this.invalidCharacter = invalidCharacter;
    }

    public String getSyoukenNo2() {
        return syoukenNo2;
    }

    public void setSyoukenNo2(String syoukenNo2) {
        this.syoukenNo2 = syoukenNo2;
    }
    
    public String getHostInvalidCharacter() {
        return hostInvalidCharacter;
    }

    public void setHostInvalidCharacter(String hostInvalidCharacter) {
        this.hostInvalidCharacter = hostInvalidCharacter;
    }
    
    public String getModulus10w21() {
        return modulus10w21;
    }

    public void setModulus10w21(String modulus10w21) {
        this.modulus10w21 = modulus10w21;
    }

}