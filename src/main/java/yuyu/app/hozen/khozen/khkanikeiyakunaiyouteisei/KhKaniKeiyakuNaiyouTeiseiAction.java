package yuyu.app.hozen.khozen.khkanikeiyakunaiyouteisei;

import static yuyu.app.hozen.khozen.khkanikeiyakunaiyouteisei.GenKhKaniKeiyakuNaiyouTeiseiConstants.*;

import javax.inject.Inject;

import jp.co.slcs.swak.web.config.annotations.Forward;
import jp.co.slcs.swak.web.config.annotations.Forwards;
import jp.co.slcs.swak.web.config.annotations.Input;
import jp.co.slcs.swak.web.config.annotations.UIBean;
import jp.co.slcs.swak.web.conversation.annotations.Begin;
import jp.co.slcs.swak.web.conversation.annotations.End;

/**
 * 契約保全簡易契約内容訂正 機能のアクションクラスです。
 */
@Forwards
({
    @Forward(name = FORWARDNAME_INIT, page = PAGENO_INIT, path = "/hozen/khozen/khkanikeiyakunaiyouteisei/KhKaniKeiyakuNaiyouTeisei.do", redirect = true),
    @Forward(name = FORWARDNAME_INPUTKEY, page = PAGENO_INPUTKEY, path = "/hozen/khozen/khkanikeiyakunaiyouteisei/kh_kani_keiyaku_naiyou_teisei.jsp"),
    @Forward(name = FORWARDNAME_REFERENCE, page = PAGENO_REFERENCE, path = "/hozen/khozen/khkanikeiyakunaiyouteisei/kh_kani_keiyaku_naiyou_teisei.jsp"),
    @Forward(name = FORWARDNAME_CONFIRM, page = PAGENO_CONFIRM, path = "/hozen/khozen/khkanikeiyakunaiyouteisei/kh_kani_keiyaku_naiyou_teisei.jsp"),
    @Forward(name = FORWARDNAME_RESULT, page = PAGENO_RESULT, path = "/hozen/khozen/khkanikeiyakunaiyouteisei/kh_kani_keiyaku_naiyou_teisei.jsp"),
})
@Input("/hozen/khozen/khkanikeiyakunaiyouteisei/kh_kani_keiyaku_naiyou_teisei.jsp")
@UIBean(beanClass=KhKaniKeiyakuNaiyouTeiseiUiBean.class)
public class KhKaniKeiyakuNaiyouTeiseiAction {

    @Inject
    private KhKaniKeiyakuNaiyouTeiseiBizLogic bizLogic;

    public String init() {

        bizLogic.init();
        return FORWARDNAME_INPUTKEY;
    }

    @End
    public String tojiruBtnOnClick() {
        return null;
    }

    @Begin
    public String ketteiBtnOnClick() {
        bizLogic.pushKetteiBL();
        return FORWARDNAME_REFERENCE;
    }

    @End
    public String modorubtnbysyoukaiOnClick() {
        return FORWARDNAME_INIT;
    }

    public String kakuninBtnOnClick() {
        bizLogic.pushKakuninBL();
        return FORWARDNAME_CONFIRM;
    }

    public String modoruBtnByConfirmOnClick() {
        bizLogic.pushModoruBtnByConfirmBL();
        return FORWARDNAME_REFERENCE;
    }

    @End
    public String kakuteiBtnOnClick() {
        bizLogic.pushKakuteiBL();
        return FORWARDNAME_RESULT;
    }

    public String syokigamenheBtnOnClick() {
        return FORWARDNAME_INIT;
    }

    @End
    public String functionNameOnClick() {
        return FORWARDNAME_INIT;
    }
}
