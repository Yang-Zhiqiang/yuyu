package yuyu.common.hozen.khcommon;

import java.io.Serializable;

import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.number.BizCurrency;
import jp.co.slcs.swak.number.BizNumber;

/**
 * 契約保全 契約保全共通 保険金削減内容Bean
 */
public class SsakugenBean implements Serializable {

    private static final long serialVersionUID = 1L;
    private int hknNendo;

    private BizDate startNendoYmd;

    private BizDate endNendoYmd;

    private BizNumber skgnRitu;

    private BizCurrency hKngk;

    public SsakugenBean() {
        super();
    }

    public void setHknNendo(int pHknNendo) {
        hknNendo = pHknNendo;
    }

    public int getHknNendo() {
        return hknNendo;
    }

    public void setStartNendoYmd(BizDate pStartNendoYmd) {
        startNendoYmd = pStartNendoYmd;
    }

    public BizDate getStartNendoYmd() {
        return startNendoYmd;
    }

    public void setEndNendoYmd(BizDate pEndNendoYmd) {
        endNendoYmd = pEndNendoYmd;
    }

    public BizDate getEndNendoYmd() {
        return endNendoYmd;
    }

    public void setSkgnRitu(BizNumber pSkgnRitu) {
        skgnRitu = pSkgnRitu;
    }

    public BizNumber getSkgnRitu() {
        return skgnRitu;
    }

    public void setS(BizCurrency pHkngk) {
        hKngk = pHkngk;
    }

    public BizCurrency getS() {
        return hKngk;
    }

}
