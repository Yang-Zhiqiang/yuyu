package yuyu.app.sinkeiyaku.sknyuukin.sktoujitufbhenkintorikesi;

import static yuyu.app.sinkeiyaku.sknyuukin.sktoujitufbhenkintorikesi.GenSkToujituFbHenkinTorikesiConstants.*;

import javax.inject.Inject;

import jp.co.slcs.swak.web.annotation.BizAppExceptionTerminate;
import jp.co.slcs.swak.web.config.annotations.Forward;
import jp.co.slcs.swak.web.config.annotations.Forwards;
import jp.co.slcs.swak.web.config.annotations.Input;
import jp.co.slcs.swak.web.config.annotations.UIBean;
import jp.co.slcs.swak.web.conversation.annotations.Begin;
import jp.co.slcs.swak.web.conversation.annotations.End;

/**
 * 当日ＦＢ返金取消 機能のアクションクラスです。
 */
@Forwards
({
    @Forward(name=FORWARDNAME_INIT,          page=PAGENO_INIT,          path="/sinkeiyaku/sknyuukin/sktoujitufbhenkintorikesi/SkToujituFbHenkinTorikesi.do", redirect=true),
    @Forward(name=FORWARDNAME_INPUTKEY,      page=PAGENO_INPUTKEY,      path="/sinkeiyaku/sknyuukin/sktoujitufbhenkintorikesi/sk_toujitu_fb_henkin_torikesi.jsp"),
    @Forward(name=FORWARDNAME_INPUTCONTENTS, page=PAGENO_INPUTCONTENTS, path="/sinkeiyaku/sknyuukin/sktoujitufbhenkintorikesi/sk_toujitu_fb_henkin_torikesi.jsp"),
    @Forward(name=FORWARDNAME_CONFIRM,       page=PAGENO_CONFIRM,       path="/sinkeiyaku/sknyuukin/sktoujitufbhenkintorikesi/sk_toujitu_fb_henkin_torikesi.jsp"),
    @Forward(name=FORWARDNAME_RESULT,        page=PAGENO_RESULT,        path="/sinkeiyaku/sknyuukin/sktoujitufbhenkintorikesi/sk_toujitu_fb_henkin_torikesi.jsp"),
})
@Input("/sinkeiyaku/sknyuukin/sktoujitufbhenkintorikesi/sk_toujitu_fb_henkin_torikesi.jsp")
@UIBean(beanClass=SkToujituFbHenkinTorikesiUiBean.class)
public class SkToujituFbHenkinTorikesiAction {

    @Inject
    private SkToujituFbHenkinTorikesiBizLogic bizLogic;

    public String init() {
        bizLogic.init();
        return FORWARDNAME_INPUTKEY;
    }

    @End
    public String tojiruBtnOnClick() {
        bizLogic.unlockProcess();

        return null;
    }

    public String sentakulinkOnClick() {
        bizLogic.continueLockProcess();
        bizLogic.pushSentakuBL();
        return FORWARDNAME_CONFIRM;
    }

    @Begin
    public String kakuteibtnbyinputkeyOnClick() {
        bizLogic.pushKakuteByInputkeyBL();
        return FORWARDNAME_INPUTCONTENTS;
    }

    @End
    public String modoruBtnByInputContentsOnClick() {
        bizLogic.unlockProcess();
        return FORWARDNAME_INIT;
    }

    public String modoruBtnByConfirmOnClick() {
        bizLogic.continueLockProcess();
        bizLogic.pushModoruByConfirmBL();
        return FORWARDNAME_INPUTCONTENTS;
    }

    @End
    public String kakuteibtnbyconfirmOnClick() {
        bizLogic.continueLockProcess();
        bizLogic.pushKakuteiByConfirmBL();
        bizLogic.unlockProcess();
        return FORWARDNAME_RESULT;
    }

    public String syokigamenheBtnOnClick() {
        return FORWARDNAME_INIT;
    }

    @End
    public String functionNameOnClick() {
        bizLogic.unlockProcess();
        return FORWARDNAME_INIT;
    }

    @BizAppExceptionTerminate
    private void bizAppExceptionTerminate(Throwable e) {

        bizLogic.unlockProcess();
    }
}
