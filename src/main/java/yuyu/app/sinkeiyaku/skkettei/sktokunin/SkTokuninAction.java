package yuyu.app.sinkeiyaku.skkettei.sktokunin;

import static yuyu.app.sinkeiyaku.skkettei.sktokunin.SkTokuninConstants.*;

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
 * 特認処理 機能のアクションクラスです。
 */
@Forwards
({
    @Forward(name=FORWARDNAME_INIT,          page=PAGENO_INIT,          path="/sinkeiyaku/skkettei/sktokunin/SkTokunin.do", redirect=true),
    @Forward(name=FORWARDNAME_INPUTKEY,      page=PAGENO_INPUTKEY,      path="/sinkeiyaku/skkettei/sktokunin/sk_tokunin.jsp"),
    @Forward(name=FORWARDNAME_INPUTCONTENTS, page=PAGENO_INPUTCONTENTS, path="/sinkeiyaku/skkettei/sktokunin/sk_tokunin.jsp"),
    @Forward(name=FORWARDNAME_CONFIRM,       page=PAGENO_CONFIRM,       path="/sinkeiyaku/skkettei/sktokunin/sk_tokunin.jsp"),
    @Forward(name=FORWARDNAME_RESULT,        page=PAGENO_RESULT,        path="/sinkeiyaku/skkettei/sktokunin/sk_tokunin.jsp"),
})
@Input("/sinkeiyaku/skkettei/sktokunin/sk_tokunin.jsp")
@UIBean(beanClass=SkTokuninUiBean.class)
public class SkTokuninAction {

    @Inject
    private SkTokuninBizLogic bizLogic;

    public String init() {

        bizLogic.init();
        return FORWARDNAME_INPUTKEY;
    }

    @End
    public String tojiruBtnOnClick() {
        bizLogic.doUnlockProcess();

        return null;
    }

    @Begin
    public String tourokuBtnOnClick() {
        bizLogic.pushUpdBL();
        return FORWARDNAME_INPUTCONTENTS;
    }

    @End
    public String modoruBtnByInputContentsOnClick() {

        bizLogic.doUnlockProcess();

        return FORWARDNAME_INIT;
    }

    public String kakuninBtnOnClick() {

        bizLogic.doContinueLockProcess();
        bizLogic.pushKakuninBL();
        return FORWARDNAME_CONFIRM;
    }

    public String modoruBtnByConfirmOnClick() {

        bizLogic.doContinueLockProcess();
        bizLogic.pushmodoruBtnByConfirmBL();
        return FORWARDNAME_INPUTCONTENTS;
    }

    @MultiPostConstraints
    public String kakuteiBtnOnClick() {

        bizLogic.doContinueLockProcess();
        bizLogic.pushKakuteiBL();

        bizLogic.doUnlockProcess();

        return FORWARDNAME_RESULT;
    }

    @End
    public String syokigamenheBtnOnClick() {
        return FORWARDNAME_INIT;
    }

    @End
    public String functionNameOnClick() {

        bizLogic.doUnlockProcess();

        return FORWARDNAME_INIT;
    }

    @BizAppExceptionTerminate
    private void bizAppExceptionTerminate(Throwable e) {
        bizLogic.doUnlockProcess();
    }
}
