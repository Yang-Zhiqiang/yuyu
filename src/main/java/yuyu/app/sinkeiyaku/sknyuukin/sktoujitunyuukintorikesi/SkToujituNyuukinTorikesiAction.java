package yuyu.app.sinkeiyaku.sknyuukin.sktoujitunyuukintorikesi;

import static yuyu.app.sinkeiyaku.sknyuukin.sktoujitunyuukintorikesi.GenSkToujituNyuukinTorikesiConstants.*;

import javax.inject.Inject;

import jp.co.slcs.swak.web.annotation.BizAppExceptionTerminate;
import jp.co.slcs.swak.web.config.annotations.Forward;
import jp.co.slcs.swak.web.config.annotations.Forwards;
import jp.co.slcs.swak.web.config.annotations.Input;
import jp.co.slcs.swak.web.config.annotations.UIBean;
import jp.co.slcs.swak.web.conversation.annotations.Begin;
import jp.co.slcs.swak.web.conversation.annotations.End;

/**
 * 当日入金取消 機能のアクションクラスです。
 */
@Forwards
({
    @Forward(name=FORWARDNAME_INIT,          page=PAGENO_INIT,          path="/sinkeiyaku/sknyuukin/sktoujitunyuukintorikesi/SkToujituNyuukinTorikesi.do", redirect=true),
    @Forward(name=FORWARDNAME_INPUTKEY,      page=PAGENO_INPUTKEY,      path="/sinkeiyaku/sknyuukin/sktoujitunyuukintorikesi/sk_toujitu_nyuukin_torikesi.jsp"),
    @Forward(name=FORWARDNAME_INPUTCONTENTS, page=PAGENO_INPUTCONTENTS, path="/sinkeiyaku/sknyuukin/sktoujitunyuukintorikesi/sk_toujitu_nyuukin_torikesi.jsp"),
    @Forward(name=FORWARDNAME_CONFIRM,       page=PAGENO_CONFIRM,       path="/sinkeiyaku/sknyuukin/sktoujitunyuukintorikesi/sk_toujitu_nyuukin_torikesi.jsp"),
    @Forward(name=FORWARDNAME_RESULT,        page=PAGENO_RESULT,        path="/sinkeiyaku/sknyuukin/sktoujitunyuukintorikesi/sk_toujitu_nyuukin_torikesi.jsp"),
})
@Input("/sinkeiyaku/sknyuukin/sktoujitunyuukintorikesi/sk_toujitu_nyuukin_torikesi.jsp")
@UIBean(beanClass=SkToujituNyuukinTorikesiUiBean.class)
public class SkToujituNyuukinTorikesiAction {

    @Inject
    private SkToujituNyuukinTorikesiBizLogic bizLogic;

    public String init() {

        bizLogic.init();
        return FORWARDNAME_INPUTKEY;
    }

    @End
    public String tojiruBtnOnClick() {
        bizLogic.pushUnlockProcess();
        return null;
    }

    public String sentakulinkOnClick() {
        bizLogic.pushContinueLockProcess();
        bizLogic.pushSentakuBL();
        return FORWARDNAME_CONFIRM;
    }

    @Begin
    public String torikesiBtnOnClick() {
        bizLogic.pushTorikesiBL();
        return FORWARDNAME_INPUTCONTENTS;
    }

    @End
    public String modoruBtnByInputContentsOnClick() {
        bizLogic.pushUnlockProcess();
        return FORWARDNAME_INIT;
    }

    public String modoruBtnByConfirmOnClick() {
        bizLogic.pushContinueLockProcess();
        bizLogic.pushModoruBtnByConfirm();

        return FORWARDNAME_INPUTCONTENTS;
    }

    @End
    public String kakuteibtnbyconfirmOnClick() {
        bizLogic.pushContinueLockProcess();
        bizLogic.pushKakuteiByConfirmBL();
        bizLogic.pushUnlockProcess();
        return FORWARDNAME_RESULT;
    }

    public String syokigamenheBtnOnClick() {
        return FORWARDNAME_INIT;
    }

    @End
    public String functionNameOnClick() {
        bizLogic.pushUnlockProcess();
        return FORWARDNAME_INIT;
    }

    @BizAppExceptionTerminate
    private void bizAppExceptionTerminate(Throwable e) {
        bizLogic.pushUnlockProcess();
    }
}
