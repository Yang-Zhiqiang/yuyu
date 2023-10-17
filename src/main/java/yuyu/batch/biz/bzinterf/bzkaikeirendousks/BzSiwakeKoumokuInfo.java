package yuyu.batch.biz.bzinterf.bzkaikeirendousks;

import jp.co.slcs.swak.number.BizCurrency;
import yuyu.def.classification.C_TaisyakuKbn;

/**
 * 業務共通 インターフェイス 仕訳項目情報クラス
 */
public class BzSiwakeKoumokuInfo {

    private C_TaisyakuKbn taisyakuKbn;

    private String denKanjoKamokuCd;

    private String jigyouHiUtiwakeCd;

    private String suitouBumonCd;

    private String tekiyouCd;

    private BizCurrency denYenKagk;

    public BzSiwakeKoumokuInfo() {
        super();
    }

    public C_TaisyakuKbn getTaisyakukbn() {
        return taisyakuKbn;
    }

    public void setTaisyakukbn(C_TaisyakuKbn pTaisyakukbn) {
        taisyakuKbn = pTaisyakukbn;
    }

    public String getDenkanjokamokucd() {
        return denKanjoKamokuCd;
    }

    public void setDenkanjokamokucd(String pDenkanjokamokucd) {
        denKanjoKamokuCd = pDenkanjokamokucd;
    }

    public String getJigyouhiutiwakecd() {
        return jigyouHiUtiwakeCd;
    }

    public void setJigyouhiutiwakecd(String pJigyouhiutiwakecd) {
        jigyouHiUtiwakeCd = pJigyouhiutiwakecd;
    }

    public String getSuitoubumoncd() {
        return suitouBumonCd;
    }

    public void setSuitoubumoncd(String pSuitoubumoncd) {
        suitouBumonCd = pSuitoubumoncd;
    }

    public String getTekiyoucd() {
        return tekiyouCd;
    }

    public void setTekiyoucd(String pTekiyoucd) {
        tekiyouCd = pTekiyoucd;
    }

    public BizCurrency getDenyenkagk() {
        return denYenKagk;
    }

    public void setDenyenkagk(BizCurrency pDenyenkagk) {
        denYenKagk = pDenyenkagk;
    }
}
