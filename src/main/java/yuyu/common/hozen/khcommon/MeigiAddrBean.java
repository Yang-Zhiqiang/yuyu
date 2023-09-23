package yuyu.common.hozen.khcommon;

import java.io.Serializable;

import yuyu.def.classification.C_KjkhukaKbn;
import jp.co.slcs.swak.date.BizDate;

/**
 * 契約保全 契約保全共通 名義住所項目Bean
 */
public class MeigiAddrBean implements Serializable {

    private static final long serialVersionUID = 1L;

    private String nmKnFieldNm;

    private String nmKn;

    private String nmKjFieldNm;

    private String nmKj;

    private C_KjkhukaKbn  nmKjhukaKbn;

    private String seiYmdFieldNm;

    private BizDate seiYmd;

    private BizDate syoriYmd;

    private String adrkjFieldNm;

    private String adrkj1;

    private String adrkj2;

    private String adrkj3;

    public MeigiAddrBean() {
        super();
    }

    public String getNmKnFieldNm() {
        return nmKnFieldNm;
    }

    public void setNmKnFieldNm(String pNmKnFieldNm) {
        this.nmKnFieldNm = pNmKnFieldNm;
    }

    public String getNmKn() {
        return nmKn;
    }

    public void setNmKn(String pNmKn) {
        this.nmKn = pNmKn;
    }

    public String getNmKjFieldNm() {
        return nmKjFieldNm;
    }

    public void setNmKjFieldNm(String pNmKjFieldNm) {
        this.nmKjFieldNm = pNmKjFieldNm;
    }

    public String getNmKj() {
        return nmKj;
    }

    public void setNmKj(String pNmKj) {
        this.nmKj = pNmKj;
    }

    public C_KjkhukaKbn getNmKjhukaKbn() {
        return nmKjhukaKbn;
    }

    public void setNmKjhukaKbn(C_KjkhukaKbn pNmKjhukaKbn) {
        this.nmKjhukaKbn = pNmKjhukaKbn;
    }

    public String getSeiYmdFieldNm() {
        return seiYmdFieldNm;
    }

    public void setSeiYmdFieldNm(String pSeiYmdFieldNm) {
        this.seiYmdFieldNm = pSeiYmdFieldNm;
    }

    public BizDate getSeiYmd() {
        return seiYmd;
    }

    public void setSeiYmd(BizDate pSeiYmd) {
        this.seiYmd = pSeiYmd;
    }

    public BizDate getSyoriYmd() {
        return syoriYmd;
    }

    public void setSyoriYmd(BizDate pSyoriYmd) {
        this.syoriYmd = pSyoriYmd;
    }

    public String getAdrkjFieldNm() {
        return adrkjFieldNm;
    }

    public void setAdrkjFieldNm(String pAdrkjFieldNm) {
        this.adrkjFieldNm = pAdrkjFieldNm;
    }

    public String getAdrkj1() {
        return adrkj1;
    }

    public void setAdrkj1(String pAdrkj1) {
        this.adrkj1 = pAdrkj1;
    }

    public String getAdrkj2() {
        return adrkj2;
    }

    public void setAdrkj2(String pAdrkj2) {
        this.adrkj2 = pAdrkj2;
    }

    public String getAdrkj3() {
        return adrkj3;
    }

    public void setAdrkj3(String pAdrkj3) {
        this.adrkj3 = pAdrkj3;
    }

}
