package yuyu.infr.conversion;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Date;

import yuyu.def.classification.C_YouhiKbn;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.date.BizDateMD;
import jp.co.slcs.swak.date.BizDateY;
import jp.co.slcs.swak.date.BizDateYM;
import jp.co.slcs.swak.number.BizCurrency;
import jp.co.slcs.swak.number.BizNumber;
import jp.co.slcs.swak.number.BizRate;

public class Bean {

    private Date date;

    private BizDate bizDate;

    private BizDateY bizDateY;

    private BizDateYM bizDateYM;

    private BizDateMD bizDateMD;

    private Integer integer;

    private Short argShort;

    private Long argLong;

    private Float argFloat;

    private Double argDouble;

    private Byte argByte;

    private BigDecimal bigDecimal;

    private BigInteger bigInteger;

    private Boolean argBoolean;

    private Character character;

    private BizNumber bizNumber;

    private BizCurrency bizCurrency;

    private BizRate bizRate;

    private C_YouhiKbn youhiKbn;

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public BizDate getBizDate() {
        return bizDate;
    }

    public void setBizDate(BizDate bizDate) {
        this.bizDate = bizDate;
    }

    public BizDateY getBizDateY() {
        return bizDateY;
    }

    public void setBizDateY(BizDateY bizDateY) {
        this.bizDateY = bizDateY;
    }

    public BizDateYM getBizDateYM() {
        return bizDateYM;
    }

    public void setBizDateYM(BizDateYM bizDateYM) {
        this.bizDateYM = bizDateYM;
    }

    public BizDateMD getBizDateMD() {
        return bizDateMD;
    }

    public void setBizDateMD(BizDateMD bizDateMD) {
        this.bizDateMD = bizDateMD;
    }

    public Integer getInteger() {
        return integer;
    }

    public void setInteger(Integer integer) {
        this.integer = integer;
    }

    public Short getArgShort() {
        return argShort;
    }

    public void setArgShort(Short argShort) {
        this.argShort = argShort;
    }

    public Long getArgLong() {
        return argLong;
    }

    public void setArgLong(Long argLong) {
        this.argLong = argLong;
    }

    public Float getArgFloat() {
        return argFloat;
    }

    public void setArgFloat(Float argFloat) {
        this.argFloat = argFloat;
    }

    public Double getArgDouble() {
        return argDouble;
    }

    public void setArgDouble(Double argDouble) {
        this.argDouble = argDouble;
    }

    public Byte getArgByte() {
        return argByte;
    }

    public void setArgByte(Byte argByte) {
        this.argByte = argByte;
    }

    public BigDecimal getBigDecimal() {
        return bigDecimal;
    }

    public void setBigDecimal(BigDecimal bigDecimal) {
        this.bigDecimal = bigDecimal;
    }

    public BigInteger getBigInteger() {
        return bigInteger;
    }

    public void setBigInteger(BigInteger bigInteger) {
        this.bigInteger = bigInteger;
    }

    public Boolean getArgBoolean() {
        return argBoolean;
    }

    public void setArgBoolean(Boolean argBoolean) {
        this.argBoolean = argBoolean;
    }

    public Character getCharacter() {
        return character;
    }

    public void setCharacter(Character character) {
        this.character = character;
    }

    public BizNumber getBizNumber() {
        return bizNumber;
    }

    public void setBizNumber(BizNumber bizNumber) {
        this.bizNumber = bizNumber;
    }

    public BizCurrency getBizCurrency() {
        return bizCurrency;
    }

    public void setBizCurrency(BizCurrency bizCurrency) {
        this.bizCurrency = bizCurrency;
    }

    public BizRate getBizRate() {
        return bizRate;
    }

    public void setBizRate(BizRate bizRate) {
        this.bizRate = bizRate;
    }

    public C_YouhiKbn getYouhiKbn() {
        return youhiKbn;
    }

    public void setYouhiKbn(C_YouhiKbn youhiKbn) {
        this.youhiKbn = youhiKbn;
    }

}