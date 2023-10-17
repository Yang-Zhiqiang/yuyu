package yuyu.batch.biz.bzinterf.bzsinkeiyakukaikeirendousks;

import jp.co.slcs.swak.number.BizCurrency;
import yuyu.def.classification.C_NaibuKeiyakuKbn;
import yuyu.def.classification.C_TaisyakuKbn;
import yuyu.def.classification.C_TekiyouKbn;

/**
 * 業務共通 インターフェイス 新契約仕訳項目情報クラス
 */
public class BzSinkeiyakuSiwakeKoumokuInfo {

    private C_TaisyakuKbn taisyakuKbn;

    private String denKanjoKamokuCd;

    private C_NaibuKeiyakuKbn naibuKeiyakuKbn;

    private C_TekiyouKbn tekiyouKbn;

    private BizCurrency denYenKagk;

    private String tekiyouCd;

    private String suitoubumonCd;

    public BzSinkeiyakuSiwakeKoumokuInfo() {
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

    public C_NaibuKeiyakuKbn getNaibukeiyakukbn() {
        return naibuKeiyakuKbn;
    }

    public void setNaibukeiyakukbn(C_NaibuKeiyakuKbn pNaibukeiyakukbn) {
        naibuKeiyakuKbn = pNaibukeiyakukbn;
    }

    public C_TekiyouKbn getTekiyoukbn() {
        return tekiyouKbn;
    }

    public void setTekiyoukbn(C_TekiyouKbn pTekiyoukbn) {
        tekiyouKbn = pTekiyoukbn;
    }

    public BizCurrency getDenyenkagk() {
        return denYenKagk;
    }

    public void setDenyenkagk(BizCurrency pDenyenkagk) {
        denYenKagk = pDenyenkagk;
    }

    public String getTekiyoucd() {
        return tekiyouCd;
    }

    public void setTekiyoucd(String pTekiyoucd) {
        tekiyouCd = pTekiyoucd;
    }

    public String getSuitoubumonCd() {
        return suitoubumonCd;
    }

    public void setSuitoubumonCd(String pSuitoubumonCd) {
        suitoubumonCd = pSuitoubumonCd;
    }
}
