package yuyu.app.hozen.khozen.khtoujituonlinetorikesi;

import static yuyu.app.hozen.khozen.khtoujituonlinetorikesi.GenKhToujituOnlineTorikesiConstants.*;

import javax.inject.Inject;

import jp.co.slcs.swak.web.config.annotations.Forward;
import jp.co.slcs.swak.web.config.annotations.Forwards;
import jp.co.slcs.swak.web.config.annotations.Input;
import jp.co.slcs.swak.web.config.annotations.UIBean;
import jp.co.slcs.swak.web.conversation.annotations.Begin;
import jp.co.slcs.swak.web.conversation.annotations.End;

/**
 * 契約保全当日オンライン取消 機能のアクションクラスです。
 */
@Forwards
({
    @Forward(name=FORWARDNAME_INIT,     page=PAGENO_INIT,     path="/hozen/khozen/khtoujituonlinetorikesi/KhToujituOnlineTorikesi.do", redirect=true),
    @Forward(name=FORWARDNAME_INPUTKEY, page=PAGENO_INPUTKEY, path="/hozen/khozen/khtoujituonlinetorikesi/kh_toujitu_online_torikesi.jsp"),
    @Forward(name=FORWARDNAME_CONFIRM,  page=PAGENO_CONFIRM,  path="/hozen/khozen/khtoujituonlinetorikesi/kh_toujitu_online_torikesi.jsp"),
    @Forward(name=FORWARDNAME_RESULT,   page=PAGENO_RESULT,   path="/hozen/khozen/khtoujituonlinetorikesi/kh_toujitu_online_torikesi.jsp"),
})
@Input("/hozen/khozen/khtoujituonlinetorikesi/kh_toujitu_online_torikesi.jsp")
@UIBean(beanClass=KhToujituOnlineTorikesiUiBean.class)
public class KhToujituOnlineTorikesiAction {

    @Inject
    private KhToujituOnlineTorikesiBizLogic bizLogic;

    @Begin
    public String init() {

        bizLogic.init();
        return FORWARDNAME_INPUTKEY;
    }

    @End
    public String tojiruBtnOnClick() {
        return null;
    }

    public String kakuninBtnOnClick() {

        bizLogic.pushKakunin();
        return FORWARDNAME_CONFIRM;
    }

    @End
    public String modorubtnOnClick() {

        return FORWARDNAME_INIT;
    }

    @End
    public String kakuteiBtnOnClick() {

        bizLogic.doTorikesi();
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