package yuyu.common.hozen.ascommon;

import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.date.BizDateYM;
import jp.co.slcs.swak.number.BizCurrency;
import yuyu.def.classification.C_DattairiyuuKbn;
import yuyu.def.classification.C_Hrkkaisuu;
import yuyu.def.classification.C_HurihunoKbn;
import yuyu.def.classification.C_UmuKbn;

/**
 * 契約保全 案内収納共通 未入通知編集パラメータ
 */
public class EditMinyuuTuutiParam {

    private C_UmuKbn dattaiUktkUmu;

    private C_DattairiyuuKbn dattaiRiyuuKbn ;

    private C_HurihunoKbn hurihunoKbn;

    private C_HurihunoKbn zenHurihunoKbn;

    private BizDateYM jkiPJytYm;

    private BizDateYM hurikaeYm;

    private BizDate yykknMnryYmd;

    private BizDate jkiHurikaeYmd;

    private Integer jkiAnnaiJyuutouNensuu;

    private Integer jkiAnnaiJyuutouTukisuu;

    private BizCurrency jkiAnnaiKg;

    private BizDate zenHurikaeYmd;

    private BizDateYM zenAnnaiJyutouYm;

    private Integer zenAnnaiJyuutouNensuu;

    private Integer zenAnnaiJyuutouTukisuu;

    private BizCurrency zenAnnaiKg;

    private C_Hrkkaisuu annaijiHrkkaisuu;

    private C_UmuKbn kouzaHenkouUmuKbn;

    public EditMinyuuTuutiParam() {
        super();
    }

    public C_UmuKbn getDattaiUktkUmu() {
        return dattaiUktkUmu;
    }

    public void setDattaiUktkUmu(C_UmuKbn pDattaiUktkUmu) {
        dattaiUktkUmu = pDattaiUktkUmu;
    }

    public C_DattairiyuuKbn getDattaiRiyuuKbn () {
        return dattaiRiyuuKbn ;
    }

    public void setDattaiRiyuuKbn (C_DattairiyuuKbn pDattaiRiyuuKbn ) {
        dattaiRiyuuKbn  = pDattaiRiyuuKbn ;
    }

    public C_HurihunoKbn getHurihunoKbn() {
        return hurihunoKbn;
    }

    public void setHurihunoKbn(C_HurihunoKbn pHurihunoKbn) {
        hurihunoKbn = pHurihunoKbn;
    }

    public C_HurihunoKbn getZenHurihunoKbn() {
        return zenHurihunoKbn;
    }

    public void setZenHurihunoKbn(C_HurihunoKbn pZenHurihunoKbn) {
        zenHurihunoKbn = pZenHurihunoKbn;
    }

    public BizDateYM getJkiPJytYm() {
        return jkiPJytYm;
    }

    public void setJkiPJytYm(BizDateYM pJkiPJytYm) {
        jkiPJytYm = pJkiPJytYm;
    }

    public BizDateYM getHurikaeYm() {
        return hurikaeYm;
    }

    public void setHurikaeYm(BizDateYM pHurikaeYm) {
        hurikaeYm = pHurikaeYm;
    }

    public BizDate getYykknMnryYmd() {
        return yykknMnryYmd;
    }

    public void setYykknMnryYmd(BizDate pYykknMnryYmd) {
        yykknMnryYmd = pYykknMnryYmd;
    }

    public BizDate getJkiHurikaeYmd() {
        return jkiHurikaeYmd;
    }

    public void setJkiHurikaeYmd(BizDate pJkiHurikaeYmd) {
        jkiHurikaeYmd = pJkiHurikaeYmd;
    }

    public Integer getJkiAnnaiJyuutouNensuu() {
        return jkiAnnaiJyuutouNensuu;
    }

    public void setJkiAnnaiJyuutouNensuu(Integer pJkiAnnaiJyuutouNensuu) {
        jkiAnnaiJyuutouNensuu = pJkiAnnaiJyuutouNensuu;
    }

    public Integer getJkiAnnaiJyuutouTukisuu() {
        return jkiAnnaiJyuutouTukisuu;
    }

    public void setJkiAnnaiJyuutouTukisuu(Integer pJkiAnnaiJyuutouTukisuu) {
        jkiAnnaiJyuutouTukisuu = pJkiAnnaiJyuutouTukisuu;
    }

    public BizCurrency getJkiAnnaiKg() {
        return jkiAnnaiKg;
    }

    public void setJkiAnnaiKg(BizCurrency pJkiAnnaiKg) {
        jkiAnnaiKg = pJkiAnnaiKg;
    }

    public BizDate getZenHurikaeYmd() {
        return zenHurikaeYmd;
    }

    public void setZenHurikaeYmd(BizDate pZenHurikaeYmd) {
        zenHurikaeYmd = pZenHurikaeYmd;
    }

    public BizDateYM getZenAnnaiJyutouYm() {
        return zenAnnaiJyutouYm;
    }

    public void setZenAnnaiJyutouYm(BizDateYM pZenAnnaiJyutouYm) {
        zenAnnaiJyutouYm = pZenAnnaiJyutouYm;
    }

    public Integer getZenAnnaiJyuutouNensuu() {
        return zenAnnaiJyuutouNensuu;
    }

    public void setZenAnnaiJyuutouNensuu(Integer pZenAnnaiJyuutouNensuu) {
        zenAnnaiJyuutouNensuu = pZenAnnaiJyuutouNensuu;
    }

    public Integer getZenAnnaiJyuutouTukisuu() {
        return zenAnnaiJyuutouTukisuu;
    }

    public void setZenAnnaiJyuutouTukisuu(Integer pZenAnnaiJyuutouTukisuu) {
        zenAnnaiJyuutouTukisuu = pZenAnnaiJyuutouTukisuu;
    }

    public BizCurrency getZenAnnaiKg() {
        return zenAnnaiKg;
    }

    public void setZenAnnaiKg(BizCurrency pZenAnnaiKg) {
        zenAnnaiKg = pZenAnnaiKg;
    }

    public C_Hrkkaisuu getAnnaijiHrkkaisuu() {
        return annaijiHrkkaisuu;
    }

    public void setAnnaijiHrkkaisuu(C_Hrkkaisuu pAnnaijiHrkkaisuu) {
        annaijiHrkkaisuu = pAnnaijiHrkkaisuu;
    }

    public C_UmuKbn getKouzaHenkouUmuKbn() {
        return kouzaHenkouUmuKbn;
    }

    public void setKouzaHenkouUmuKbn(C_UmuKbn pKouzaHenkouUmuKbn) {
        kouzaHenkouUmuKbn = pKouzaHenkouUmuKbn;
    }
}
