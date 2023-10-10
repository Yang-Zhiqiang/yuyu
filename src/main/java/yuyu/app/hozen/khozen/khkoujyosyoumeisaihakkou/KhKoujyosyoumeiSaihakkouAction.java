package yuyu.app.hozen.khozen.khkoujyosyoumeisaihakkou;

import static yuyu.app.hozen.khozen.khkoujyosyoumeisaihakkou.GenKhKoujyosyoumeiSaihakkouConstants.*;

import javax.inject.Inject;

import jp.co.slcs.swak.web.auth.permission.Roles;
import jp.co.slcs.swak.web.config.annotations.Forward;
import jp.co.slcs.swak.web.config.annotations.Forwards;
import jp.co.slcs.swak.web.config.annotations.Input;
import jp.co.slcs.swak.web.config.annotations.UIBean;
import jp.co.slcs.swak.web.conversation.annotations.Begin;
import jp.co.slcs.swak.web.conversation.annotations.End;
import jp.co.slcs.swak.web.conversation.annotations.MultiPostConstraints;

/**
 * 控除証明書再発行 機能のアクションクラスです。
 */
@Forwards
({
    @Forward(name=FORWARDNAME_INIT,          page=PAGENO_INIT,          path="/hozen/khozen/khkoujyosyoumeisaihakkou/KhKoujyosyoumeiSaihakkou.do", redirect=true),
    @Forward(name=FORWARDNAME_INPUTKEY,      page=PAGENO_INPUTKEY,      path="/hozen/khozen/khkoujyosyoumeisaihakkou/kh_koujyosyoumei_saihakkou.jsp"),
    @Forward(name=FORWARDNAME_INPUTCONTENTS, page=PAGENO_INPUTCONTENTS, path="/hozen/khozen/khkoujyosyoumeisaihakkou/kh_koujyosyoumei_saihakkou.jsp"),
    @Forward(name=FORWARDNAME_CONFIRM,       page=PAGENO_CONFIRM,       path="/hozen/khozen/khkoujyosyoumeisaihakkou/kh_koujyosyoumei_saihakkou.jsp"),
    @Forward(name=FORWARDNAME_RESULT,        page=PAGENO_RESULT,        path="/hozen/khozen/khkoujyosyoumeisaihakkou/kh_koujyosyoumei_saihakkou.jsp"),
})
@Input("/hozen/khozen/khkoujyosyoumeisaihakkou/kh_koujyosyoumei_saihakkou.jsp")
@UIBean(beanClass=KhKoujyosyoumeiSaihakkouUiBean.class)
@Roles("khkoujyosyoumeisaihakkou")
public class KhKoujyosyoumeiSaihakkouAction {

    @Inject
    private KhKoujyosyoumeiSaihakkouBizLogic bizLogic;

    @Begin
    public String init() {
        bizLogic.init();
        return FORWARDNAME_INPUTKEY;
    }

    @End
    public String tojiruBtnOnClick() {
        return null;
    }

    public String nyuuryokubtnOnClick() {
        bizLogic.pushNyuryoku();
        return FORWARDNAME_INPUTCONTENTS;
    }

    @End
    public String modoruBtnByInputContentsOnClick() {
        return FORWARDNAME_INIT;
    }

    public String kakuninBtnOnClick() {
        bizLogic.pushKakunin();
        return FORWARDNAME_CONFIRM;
    }

    public String modoruBtnByConfirmOnClick() {
        bizLogic.pushModoruBtnByConfirm();
        return FORWARDNAME_INPUTCONTENTS;
    }

    @MultiPostConstraints
    public String kakuteiBtnOnClick() {
        bizLogic.pushKakutei();
        return FORWARDNAME_RESULT;
    }

    @End
    public String syokigamenheBtnOnClick() {
        return FORWARDNAME_INIT;
    }

    @MultiPostConstraints
    public String print() {

        bizLogic.printOut();

        return null;
    }
}
