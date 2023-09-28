package yuyu.common.biz.bzcommon;

import java.io.Serializable;

import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.number.BizCurrency;

/**
 * 遅延利息計算Beanクラスです。<br />
 */
public class KeisanTienrisokuBean implements Serializable {

    private static final long serialVersionUID = 1L;

    private BizCurrency shrtienrsk;

    private BizDate shrtienrskStartYmd;

    private BizDate shrtienrskEndYmd;

    private Integer shrtienNissuu;

    public KeisanTienrisokuBean() {
        shrtienrsk = BizCurrency.valueOf(0);
        shrtienrskStartYmd = null;
        shrtienrskEndYmd = null;
        shrtienNissuu = 0;
    }

    public BizCurrency getShrtienrsk() {
        return shrtienrsk;
    }

    public void setShrtienrsk(BizCurrency pShrtienrsk) {
        shrtienrsk = pShrtienrsk;
    }

    public BizDate getShrtienrskStartYmd() {
        return shrtienrskStartYmd;
    }

    public void setShrtienrskStartYmd(BizDate pShrtienrskStartYmd) {
        shrtienrskStartYmd = pShrtienrskStartYmd;
    }

    public BizDate getShrtienrskEndYmd() {
        return shrtienrskEndYmd;
    }

    public void setShrtienrskEndYmd(BizDate pShrtienrskEndYmd) {
        shrtienrskEndYmd = pShrtienrskEndYmd;
    }

    public Integer getShrtienNissuu() {
        return shrtienNissuu;
    }

    public void setShrtienNissuu(Integer pShrtienNissuu) {
        shrtienNissuu = pShrtienNissuu;
    }

}
