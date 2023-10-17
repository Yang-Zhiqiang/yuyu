package yuyu.app.sinkeiyaku.skkettei.skkyouseihand;

import static yuyu.app.sinkeiyaku.skkettei.skkyouseihand.GenSkKyouseiHandConstants.*;

import javax.inject.Inject;

import jp.co.slcs.swak.web.annotation.BizAppExceptionTerminate;
import jp.co.slcs.swak.web.config.annotations.Forward;
import jp.co.slcs.swak.web.config.annotations.Forwards;
import jp.co.slcs.swak.web.config.annotations.Input;
import jp.co.slcs.swak.web.config.annotations.UIBean;
import jp.co.slcs.swak.web.conversation.annotations.Begin;
import jp.co.slcs.swak.web.conversation.annotations.End;
import jp.co.slcs.swak.web.conversation.annotations.MultiPostConstraints;

/**
 * 強制ハンド決定入力 機能のアクションクラスです。
 */
@Forwards
({
    @Forward(name=FORWARDNAME_INIT,     page=PAGENO_INIT,     path="/sinkeiyaku/skkettei/skkyouseihand/SkKyouseiHand.do", redirect=true),
    @Forward(name=FORWARDNAME_INPUTKEY, page=PAGENO_INPUTKEY, path="/sinkeiyaku/skkettei/skkyouseihand/sk_kyousei_hand.jsp"),
    @Forward(name=FORWARDNAME_CONFIRM,  page=PAGENO_CONFIRM,  path="/sinkeiyaku/skkettei/skkyouseihand/sk_kyousei_hand.jsp"),
    @Forward(name=FORWARDNAME_RESULT,   page=PAGENO_RESULT,   path="/sinkeiyaku/skkettei/skkyouseihand/sk_kyousei_hand.jsp"),
})
@Input("/sinkeiyaku/skkettei/skkyouseihand/sk_kyousei_hand.jsp")
@UIBean(beanClass=SkKyouseiHandUiBean.class)
public class SkKyouseiHandAction {

    @Inject
    private SkKyouseiHandBizLogic bizLogic;

    @Begin
    public String init() {

        bizLogic.init();
        return FORWARDNAME_INPUTKEY;
    }

    @End
    public String tojiruBtnOnClick() {
        bizLogic.removeObj();
        bizLogic.pushUnlockProcessBL();
        return null;
    }

    public String tourokuBtnOnClick() {

        bizLogic.pushUpdBL();
        return FORWARDNAME_CONFIRM;
    }

    public String modorubtnOnClick() {
        bizLogic.pushUnlockProcessBL();
        bizLogic.removeWarningMessage();
        return FORWARDNAME_INPUTKEY;
    }

    @MultiPostConstraints
    public String kakuteiBtnOnClick() {
        bizLogic.continueLockProcessBL();
        bizLogic.pushKakuteiBL();
        bizLogic.pushUnlockProcessBL();

        return FORWARDNAME_RESULT;
    }

    @End
    public String syokigamenheBtnOnClick() {
        bizLogic.removeObj();

        return FORWARDNAME_INIT;
    }

    @End
    public String functionNameOnClick() {

        bizLogic.removeObj();
        bizLogic.pushUnlockProcessBL();

        return FORWARDNAME_INIT;
    }

    @BizAppExceptionTerminate
    private void bizAppExceptionTerminate(Throwable e) {
        bizLogic.pushUnlockProcessBL();
    }
}
