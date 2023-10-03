package yuyu.batch.suuri.srkessan.srskkessankaikeitorihiki;

import jp.co.slcs.swak.number.BizCurrency;
import yuyu.def.classification.C_NaibuKeiyakuKbn;
import yuyu.def.classification.C_TaisyakuKbn;
import yuyu.def.classification.C_TekiyouKbn;

/**
 * 仕訳項目情報クラス
 */
public class SrSkSiwakeKoumokuInfo {

    private String denKanjoKamokuCd;

    private C_TaisyakuKbn taisyaKukbn;

    private C_NaibuKeiyakuKbn naibuKeiyakuKbn;

    private C_TekiyouKbn tekiyouKbn;

    private String tekiyouCd;

    private BizCurrency gaku;

    private String kessanKbn;

    private String suitouBumon;

    public SrSkSiwakeKoumokuInfo() {

    }

    public String getDenKanjoKamokuCd() {
        return denKanjoKamokuCd;
    }

    public void setDenKanjoKamokuCd(String pDenKanjoKamokuCd) {
        denKanjoKamokuCd = pDenKanjoKamokuCd;
    }

    public C_TaisyakuKbn getTaisyaKukbn() {
        return taisyaKukbn;
    }

    public void setTaisyaKukbn(C_TaisyakuKbn pTaisyaKukbn) {
        taisyaKukbn = pTaisyaKukbn;
    }

    public C_NaibuKeiyakuKbn getNaibuKeiyakuKbn() {
        return naibuKeiyakuKbn;
    }

    public void setNaibuKeiyakuKbn(C_NaibuKeiyakuKbn pNaibuKeiyakuKbn) {
        naibuKeiyakuKbn = pNaibuKeiyakuKbn;
    }

    public C_TekiyouKbn getTekiyouKbn() {
        return tekiyouKbn;
    }

    public void setTekiyouKbn(C_TekiyouKbn pTekiyouKbn) {
        tekiyouKbn = pTekiyouKbn;
    }

    public String getTekiyouCd() {
        return tekiyouCd;
    }

    public void setTekiyouCd(String pTekiyouCd) {
        tekiyouCd = pTekiyouCd;
    }

    public BizCurrency getGaku() {
        return gaku;
    }

    public void setGaku(BizCurrency pGaku) {
        gaku = pGaku;
    }

    public String getKessanKbn() {
        return kessanKbn;
    }

    public void setKessanKbn(String pKessanKbn) {
        kessanKbn = pKessanKbn;
    }

    public String getSuitouBumon() {
        return suitouBumon;
    }

    public void setSuitouBumon(String pSuitouBumon) {
        suitouBumon = pSuitouBumon;
    }
}
