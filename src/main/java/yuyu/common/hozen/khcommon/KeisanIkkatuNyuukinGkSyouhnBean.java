package yuyu.common.hozen.khcommon;

import jp.co.slcs.swak.number.BizCurrency;
import jp.co.slcs.swak.number.BizNumber;

/**
 * 契約保全 契約保全共通 一括入金額計算用商品情報Bean
 */
public class KeisanIkkatuNyuukinGkSyouhnBean {

    private String syouhnCd;

    private int syouhnsdNo;

    private String ryouritusdNo;

    private BizCurrency hokenryou;

    private BizNumber yoteiRiritu;

    public String getSyouhnCd() {
        return syouhnCd;
    }

    public void setSyouhnCd(String pSyouhnCd) {
        this.syouhnCd = pSyouhnCd;
    }

    public int getSyouhnsdNo() {
        return syouhnsdNo;
    }

    public void setSyouhnsdNo(int pSyouhnsdNo) {
        this.syouhnsdNo = pSyouhnsdNo;
    }

    public String getRyouritusdNo() {
        return ryouritusdNo;
    }

    public void setRyouritusdNo(String pRyouritusdNo) {
        this.ryouritusdNo = pRyouritusdNo;
    }

    public BizCurrency getHokenryou() {
        return hokenryou;
    }

    public void setHokenryou(BizCurrency pHokenryou) {
        this.hokenryou = pHokenryou;
    }

    public BizNumber getYoteiRiritu() {
        return yoteiRiritu;
    }

    public void setYoteiRiritu(BizNumber pYoteiRiritu) {
        this.yoteiRiritu = pYoteiRiritu;
    }
}
