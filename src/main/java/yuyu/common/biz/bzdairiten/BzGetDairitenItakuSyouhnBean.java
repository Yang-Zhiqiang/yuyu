package yuyu.common.biz.bzdairiten;

import java.io.Serializable;

import yuyu.def.classification.C_DrtSyouhinSikibetuKbn;
import yuyu.def.classification.C_HanbaiJyoukyouKbn;
import jp.co.slcs.swak.date.BizDate;

/**
 * 業務共通 代理店 代理店委託商品情報出力Beanクラス
 */
public class BzGetDairitenItakuSyouhnBean implements Serializable {

    private static final long serialVersionUID = 1L;

    private C_HanbaiJyoukyouKbn hanbaiJyoukyouKbn;

    private String dairitenCd;

    private C_DrtSyouhinSikibetuKbn drtsyouhinsikibetuKbn;

    private String drthrkhouhouKbn;

    private String drtplannmKbn;

    private BizDate itakuhknhnbkaisiYmd;

    private BizDate itakuhknhnbsyuuryouYmd;

    public C_HanbaiJyoukyouKbn getHanbaiJyoukyouKbn() {
        return this.hanbaiJyoukyouKbn;
    }

    public void setHanbaiJyoukyouKbn(C_HanbaiJyoukyouKbn pHanbaiJyoukyouKbn) {
        this.hanbaiJyoukyouKbn = pHanbaiJyoukyouKbn;
    }

    public String getDairitenCd() {
        return this.dairitenCd;
    }

    public void setDairitenCd(String pDairitenCd) {
        this.dairitenCd = pDairitenCd;
    }

    public C_DrtSyouhinSikibetuKbn getDrtsyouhinsikibetuKbn() {
        return this.drtsyouhinsikibetuKbn;
    }

    public void setDrtsyouhinsikibetuKbn(C_DrtSyouhinSikibetuKbn pDrtsyouhinsikibetuKbn) {
        this.drtsyouhinsikibetuKbn = pDrtsyouhinsikibetuKbn;
    }

    public String getDrthrkhouhouKbn() {
        return this.drthrkhouhouKbn;
    }

    public void setDrthrkhouhouKbn(String pDrthrkhouhouKbn) {
        this.drthrkhouhouKbn = pDrthrkhouhouKbn;
    }

    public String getDrtplannmKbn() {
        return this.drtplannmKbn;
    }

    public void setDrtplannmKbn(String pDrtplannmKbn) {
        this.drtplannmKbn = pDrtplannmKbn;
    }

    public BizDate getItakuhknhnbkaisiYmd() {
        return this.itakuhknhnbkaisiYmd;
    }

    public void setItakuhknhnbkaisiYmd(BizDate pItakuhknhnbkaisiYmd) {
        this.itakuhknhnbkaisiYmd = pItakuhknhnbkaisiYmd;
    }

    public BizDate getItakuhknhnbsyuuryouYmd() {
        return this.itakuhknhnbsyuuryouYmd;
    }

    public void setItakuhknhnbsyuuryouYmd(BizDate pItakuhknhnbsyuuryouYmd) {
        this.itakuhknhnbsyuuryouYmd = pItakuhknhnbsyuuryouYmd;
    }

}
