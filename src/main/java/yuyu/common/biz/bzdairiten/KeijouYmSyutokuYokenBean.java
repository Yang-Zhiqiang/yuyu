package yuyu.common.biz.bzdairiten;

import java.io.Serializable;

import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.date.BizDateYM;

/**
 * 業務共通 代理店 計上年月取得与件BEAN
 */
public class KeijouYmSyutokuYokenBean implements Serializable {

    private static final long serialVersionUID = 1L;

    private String tratkiagCd;

    private String syouhnCd;

    private BizDate kokutiymd;

    private BizDate syokaiPRyosyuuYmd;

    private BizDate mosYmd;

    private String mosSyoumetuKbn;

    private BizDate mosSyumtKktYmd;

    private BizDateYM bosyuuYm;

    public KeijouYmSyutokuYokenBean() {
        super();

        tratkiagCd = "" ;
        syouhnCd = "" ;
        kokutiymd = null;
        syokaiPRyosyuuYmd = null;
        mosYmd = null;
        mosSyoumetuKbn = "0";
        mosSyumtKktYmd = null;
        bosyuuYm = null;
    }

    public String getTratkiagCd() {
        return tratkiagCd;
    }

    public void setTratkiagCd(String pTratkiagCd) {
        this.tratkiagCd = pTratkiagCd;
    }

    public String getSyouhnCd() {
        return syouhnCd;
    }

    public void setSyouhnCd(String pSyouhnCd) {
        this.syouhnCd = pSyouhnCd;
    }

    public BizDate getKokutiymd() {
        return kokutiymd;
    }

    public void setKokutiymd(BizDate pKokutiymd) {
        this.kokutiymd = pKokutiymd;
    }

    public BizDate getSyokaiPRyosyuuYmd() {
        return syokaiPRyosyuuYmd;
    }

    public void setSyokaiPRyosyuuYmd(BizDate pSyokaiPRyosyuuYmd) {
        this.syokaiPRyosyuuYmd = pSyokaiPRyosyuuYmd;
    }

    public BizDate getMosYmd() {
        return mosYmd;
    }

    public void setMosYmd(BizDate pMosYmd) {
        this.mosYmd = pMosYmd;
    }

    public String getMosSyoumetuKbn() {
        return mosSyoumetuKbn;
    }

    public void setMosSyoumetuKbn(String pMosSyoumetuKbn) {
        this.mosSyoumetuKbn = pMosSyoumetuKbn;
    }

    public BizDate getMosSyumtKktYmd() {
        return mosSyumtKktYmd;
    }

    public void setMosSyumtKktYmd(BizDate pMosSyumtKktYmd) {
        this.mosSyumtKktYmd = pMosSyumtKktYmd;
    }

    public BizDateYM getBosyuuYm() {
        return bosyuuYm;
    }

    public void setBosyuuYm(BizDateYM pBosyuuYm) {
        this.bosyuuYm = pBosyuuYm;
    }
}
