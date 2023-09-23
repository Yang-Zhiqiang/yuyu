package yuyu.common.hozen.khcommon;

import jp.co.slcs.swak.date.BizDateYM;
import jp.co.slcs.swak.number.BizCurrency;
import yuyu.def.classification.C_CardBrandKbn;
import yuyu.def.classification.C_HassouKbn;
import yuyu.def.classification.C_Hrkkeiro;
import yuyu.def.classification.C_UmuKbn;

/**
 * 契約保全 契約保全共通 払変完了通知編集用パラメータクラス
 */
public class EditHrhnKanryoTuutiParam {

    private BizDateYM hennyuym;

    private BizDateYM jkipJytym;

    private C_UmuKbn kaisuuhnkYoyakuUmu = C_UmuKbn.NONE;

    private C_UmuKbn hrkkeiroHnkumu;

    private C_UmuKbn hrkkaisuuHnkumu;

    private C_UmuKbn tikiktbrisyuruihnkumu;

    private C_HassouKbn hassouKbn;

    private BizCurrency hrkp;

    private C_CardBrandKbn cardBrandKbn;

    private String creditKaiinnoSimo4    ;

    private C_Hrkkeiro hrkkeiro;

    public EditHrhnKanryoTuutiParam() {
        super();
    }

    public BizDateYM getHennyuym() {
        return hennyuym;
    }

    public void setHennyuym(BizDateYM pHennyuym) {
        hennyuym = pHennyuym;
    }

    public BizDateYM getJkipJytym() {
        return jkipJytym;
    }

    public void setJkipJytym(BizDateYM pJkipJytym) {
        jkipJytym = pJkipJytym;
    }

    public C_UmuKbn getKaisuuhnkYoyakuUmu() {
        return kaisuuhnkYoyakuUmu;
    }

    public void setKaisuuhnkYoyakuUmu(C_UmuKbn pKaisuuhnkYoyakuUmu) {
        kaisuuhnkYoyakuUmu = pKaisuuhnkYoyakuUmu;
    }

    public C_UmuKbn getHrkkeiroHnkumu() {
        return hrkkeiroHnkumu;
    }

    public void setHrkkeiroHnkumu(C_UmuKbn pHrkkeiroHnkumu) {
        hrkkeiroHnkumu = pHrkkeiroHnkumu;
    }

    public C_UmuKbn getHrkkaisuuHnkumu() {
        return hrkkaisuuHnkumu;
    }

    public void setHrkkaisuuHnkumu(C_UmuKbn pHrkkaisuuHnkumu) {
        hrkkaisuuHnkumu = pHrkkaisuuHnkumu;
    }

    public C_UmuKbn getTikiktbrisyuruihnkumu() {
        return tikiktbrisyuruihnkumu;
    }

    public void setTikiktbrisyuruihnkumu(C_UmuKbn pTikiktbrisyuruihnkumu) {
        tikiktbrisyuruihnkumu = pTikiktbrisyuruihnkumu;
    }

    public C_HassouKbn getHassouKbn() {
        return hassouKbn;
    }

    public void setHassouKbn(C_HassouKbn pHassouKbn) {
        hassouKbn = pHassouKbn;
    }

    public BizCurrency getHrkp() {
        return hrkp;
    }

    public void setHrkp(BizCurrency pHrkp) {
        hrkp = pHrkp;
    }

    public C_CardBrandKbn getCardBrandKbn() {
        return cardBrandKbn;
    }

    public void setCardBrandKbn(C_CardBrandKbn pCardBrandKbn) {
        cardBrandKbn = pCardBrandKbn;
    }

    public String getCreditKaiinnoSimo4() {
        return creditKaiinnoSimo4;
    }

    public void setCreditKaiinnoSimo4(String pCreditKaiinnoSimo4) {
        creditKaiinnoSimo4 = pCreditKaiinnoSimo4;
    }

    public C_Hrkkeiro getHrkkeiro() {
        return hrkkeiro;
    }

    public void setHrkkeiro(C_Hrkkeiro pHrkkeiro) {
        hrkkeiro = pHrkkeiro;
    }
}
