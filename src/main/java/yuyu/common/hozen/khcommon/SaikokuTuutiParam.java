package yuyu.common.hozen.khcommon;

import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.date.BizDateYM;
import jp.co.slcs.swak.number.BizCurrency;
import yuyu.def.classification.C_DattairiyuuKbn;
import yuyu.def.classification.C_UmuKbn;

/**
 * 契約保全 契約保全共通 催告通知パラメータ
 */
public class SaikokuTuutiParam {

    private C_UmuKbn dattaiUktkUmu;

    private C_DattairiyuuKbn dattaiRiyuuKbn ;

    private C_UmuKbn syuunoujiDattaiUmuKbn;

    private BizDateYM jkiPJytYm;

    private BizDate yykknMnryYmd;

    private BizDate jkiHurikaeYmd;

    private Integer jkiAnnaiJyuutouTukisuu;

    private BizCurrency jkiAnnaiKg;

    public SaikokuTuutiParam() {
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

    public C_UmuKbn getSyuunoujiDattaiUmuKbn() {
        return syuunoujiDattaiUmuKbn;
    }

    public void setSyuunoujiDattaiUmuKbn(C_UmuKbn pSyuunoujiDattaiUmuKbn) {
        this.syuunoujiDattaiUmuKbn = pSyuunoujiDattaiUmuKbn;
    }

    public BizDateYM getJkiPJytYm() {
        return jkiPJytYm;
    }

    public void setJkiPJytYm(BizDateYM pJkiPJytYm) {
        jkiPJytYm = pJkiPJytYm;
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
}
