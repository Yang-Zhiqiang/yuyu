package yuyu.common.biz.bzcommon;

import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.date.BizDateMD;
import jp.co.slcs.swak.date.BizDateY;
import jp.co.slcs.swak.date.BizDateYM;
import jp.co.slcs.swak.number.BizCurrency;
import jp.co.slcs.swak.number.BizNumber;
import jp.co.slcs.swak.number.BizRate;
import yuyu.def.classification.C_KadouTimeSiteiKbn;

/**
 * BizPropertyInitializerテストクラスのため<br/>
 */
public class BizPropertyInitializerTestBean extends GenBizPropertyInitializerTestBean {
    private static final long serialVersionUID = 1L;

    public BizPropertyInitializerTestBean() {
    }

    private C_KadouTimeSiteiKbn kbnChild;

    private BizDateMD bizDateMDChild;

    private BizDateY bizDateYChild;

    private BizDateYM bizDateYMChild;

    private BizDate bizDateChild;

    private BizCurrency bizCurrencyChild;

    private BizRate bizRateChild;

    private BizNumber bizNumberChild;

    private Boolean boolChild;

    private byte[] byteListChild;

    private Byte bytChild;

    private String stringChild;

    private Long lonChild;

    private Integer inteChild;

    private Double doublChild;

    public C_KadouTimeSiteiKbn getKbnChild() {
        return kbnChild;
    }

    public void setKbnChild(C_KadouTimeSiteiKbn kbnChild) {
        this.kbnChild = kbnChild;
    }

    public BizDateMD getBizDateMDChild() {
        return bizDateMDChild;
    }

    public void setBizDateMDChild(BizDateMD bizDateMDChild) {
        this.bizDateMDChild = bizDateMDChild;
    }

    public BizDateY getBizDateYChild() {
        return bizDateYChild;
    }

    public void setBizDateYChild(BizDateY bizDateYChild) {
        this.bizDateYChild = bizDateYChild;
    }

    public BizDateYM getBizDateYMChild() {
        return bizDateYMChild;
    }

    public void setBizDateYMChild(BizDateYM bizDateYMChild) {
        this.bizDateYMChild = bizDateYMChild;
    }

    public BizDate getBizDateChild() {
        return bizDateChild;
    }

    public void setBizDateChild(BizDate bizDateChild) {
        this.bizDateChild = bizDateChild;
    }

    public BizCurrency getBizCurrencyChild() {
        return bizCurrencyChild;
    }

    public void setBizCurrencyChild(BizCurrency bizCurrencyChild) {
        this.bizCurrencyChild = bizCurrencyChild;
    }

    public BizRate getBizRateChild() {
        return bizRateChild;
    }

    public void setBizRateChild(BizRate bizRateChild) {
        this.bizRateChild = bizRateChild;
    }

    public BizNumber getBizNumberChild() {
        return bizNumberChild;
    }

    public void setBizNumberChild(BizNumber bizNumberChild) {
        this.bizNumberChild = bizNumberChild;
    }

    public Boolean getBoolChild() {
        return boolChild;
    }

    public void setBoolChild(Boolean boolChild) {
        this.boolChild = boolChild;
    }

    public byte[] getByteListChild() {
        return byteListChild;
    }

    public void setByteListChild(byte[] byteListChild) {
        this.byteListChild = byteListChild;
    }

    public Byte getBytChild() {
        return bytChild;
    }

    public void setBytChild(Byte bytChild) {
        this.bytChild = bytChild;
    }

    public String getStringChild() {
        return stringChild;
    }

    public void setStringChild(String stringChild) {
        this.stringChild = stringChild;
    }

    public Long getLonChild() {
        return lonChild;
    }

    public void setLonChild(Long lonChild) {
        this.lonChild = lonChild;
    }

    public Integer getInteChild() {
        return inteChild;
    }

    public void setInteChild(Integer inteChild) {
        this.inteChild = inteChild;
    }

    public Double getDoublChild() {
        return doublChild;
    }

    public void setDoublChild(Double doublChild) {
        this.doublChild = doublChild;
    }

}
