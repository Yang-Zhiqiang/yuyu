package yuyu.common.hozen.ascommon;

import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.date.BizDateYM;
import jp.co.slcs.swak.number.BizCurrency;
import yuyu.def.classification.C_CreditUriageNgJiyuuKbn;
import yuyu.def.classification.C_Dattaikeiro;
import yuyu.def.classification.C_DattairiyuuKbn;
import yuyu.def.classification.C_UmuKbn;
import yuyu.def.classification.C_Yuukoukakkekka;

/**
 * 契約保全 案内収納共通 クレカ催告通知パラメータ
 */
public class CreditSaikokuTuutiParam {

    private C_UmuKbn dattaiUktkUmu;

    private C_DattairiyuuKbn dattaiRiyuuKbn;

    private C_Dattaikeiro dattaikeiro;

    private C_Yuukoukakkekka yuukoukakkekka;

    private C_CreditUriageNgJiyuuKbn creditUriageNgJiyuuKbn;

    private BizDateYM jkiPJytYm;

    private BizDate yykknMnryYmd;

    private BizDate jikaiUrskbi;

    private Integer annaiGetusuu;

    private BizCurrency annaiKingaku;

    public CreditSaikokuTuutiParam() {
        super();
    }

    public C_UmuKbn getDattaiUktkUmu() {
        return dattaiUktkUmu;
    }

    public void setDattaiUktkUmu(C_UmuKbn pDattaiUktkUmu) {
        dattaiUktkUmu = pDattaiUktkUmu;
    }

    public C_DattairiyuuKbn getDattaiRiyuuKbn() {
        return dattaiRiyuuKbn;
    }

    public void setDattaiRiyuuKbn(C_DattairiyuuKbn pDattaiRiyuuKbn) {
        dattaiRiyuuKbn = pDattaiRiyuuKbn;
    }

    public C_Dattaikeiro getDattaikeiro() {
        return dattaikeiro;
    }

    public void setDattaikeiro(C_Dattaikeiro pDattaikeiro) {
        this.dattaikeiro = pDattaikeiro;
    }

    public C_Yuukoukakkekka getYuukoukakkekka() {
        return yuukoukakkekka;
    }

    public void setYuukoukakkekka(C_Yuukoukakkekka pYuukoukakkekka) {
        this.yuukoukakkekka = pYuukoukakkekka;
    }

    public C_CreditUriageNgJiyuuKbn getCreditUriageNgJiyuuKbn() {
        return creditUriageNgJiyuuKbn;
    }

    public void setCreditUriageNgJiyuuKbn(C_CreditUriageNgJiyuuKbn pCreditUriageNgJiyuuKbn) {
        this.creditUriageNgJiyuuKbn = pCreditUriageNgJiyuuKbn;
    }

    public BizDateYM getJkiPJytYm() {
        return jkiPJytYm;
    }

    public void setJkiPJytYm(BizDateYM pJkiPJytYm) {
        this.jkiPJytYm = pJkiPJytYm;
    }

    public BizDate getYykknMnryYmd() {
        return yykknMnryYmd;
    }

    public void setYykknMnryYmd(BizDate pYykknMnryYmd) {
        this.yykknMnryYmd = pYykknMnryYmd;
    }

    public BizDate getJikaiUrskbi() {
        return jikaiUrskbi;
    }

    public void setJikaiUrskbi(BizDate pJikaiUrskbi) {
        this.jikaiUrskbi = pJikaiUrskbi;
    }

    public Integer getAnnaiGetusuu() {
        return annaiGetusuu;
    }

    public void setAnnaiGetusuu(Integer pAnnaiGetusuu) {
        this.annaiGetusuu = pAnnaiGetusuu;
    }

    public BizCurrency getAnnaiKingaku() {
        return annaiKingaku;
    }

    public void setAnnaiKingaku(BizCurrency pAnnaiKingaku) {
        this.annaiKingaku = pAnnaiKingaku;
    }
}
