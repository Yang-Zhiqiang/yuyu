package yuyu.app.sinkeiyaku.skhubikanri.skhubikaisyou;

import static yuyu.app.sinkeiyaku.skhubikanri.skhubikaisyou.GenSkHubiKaisyouConstants.*;
import static yuyu.app.sinkeiyaku.skhubikanri.skhubikaisyou.SkHubiKaisyouConstants.*;

import javax.inject.Inject;

import jp.co.slcs.swak.bizinfr.exception.BizLogicException;
import jp.co.slcs.swak.web.annotation.BizAppExceptionTerminate;
import jp.co.slcs.swak.web.config.annotations.Forward;
import jp.co.slcs.swak.web.config.annotations.Forwards;
import jp.co.slcs.swak.web.config.annotations.Input;
import jp.co.slcs.swak.web.config.annotations.UIBean;
import jp.co.slcs.swak.web.conversation.annotations.Begin;
import jp.co.slcs.swak.web.conversation.annotations.End;
import jp.co.slcs.swak.web.conversation.annotations.MultiPostConstraints;

/**
 * 新契約不備解消 機能のアクションクラスです。
 */
@Forwards
({
    @Forward(name=FORWARDNAME_INIT,           page=PAGENO_INIT,          path="/sinkeiyaku/skhubikanri/skhubikaisyou/SkHubiKaisyou.do", redirect=true),
    @Forward(name=FORWARDNAME_INPUTKEY,       page=PAGENO_INPUTKEY,      path="/sinkeiyaku/skhubikanri/skhubikaisyou/sk_hubi_kaisyou.jsp"),
    @Forward(name=FORWARDNAME_SELECTDATA,     page=PAGENO_SELECTDATA,    path="/sinkeiyaku/skhubikanri/skhubikaisyou/sk_hubi_kaisyou.jsp"),
    @Forward(name=FORWARDNAME_INPUTCONTENTS,  page=PAGENO_INPUTCONTENTS, path="/sinkeiyaku/skhubikanri/skhubikaisyou/sk_hubi_kaisyou.jsp"),
    @Forward(name=FORWARDNAME_CONFIRM,        page=PAGENO_CONFIRM,       path="/sinkeiyaku/skhubikanri/skhubikaisyou/sk_hubi_kaisyou.jsp"),
    @Forward(name=FORWARDNAME_RESULT,         page=PAGENO_RESULT,        path="/sinkeiyaku/skhubikanri/skhubikaisyou/sk_hubi_kaisyou.jsp"),
    @Forward(name=FORWARDNAME_BACKTOWORKLIST,                            path="/workflow/processkanri/sinkeiyakuworklist/SinkeiyakuWorkList.do?_eventHandler=fromSkHubiKaisyou", redirect=true),
    @Forward(name=FORWARDNAME_NESTEDEND,                                 path="/sinkeiyaku/skhubikanri/skhubikaisyou/SkHubiKaisyou.do?_eventHandler=nestedEndOnClick", redirect=true),
})
@Input("/sinkeiyaku/skhubikanri/skhubikaisyou/sk_hubi_kaisyou.jsp")
@UIBean(beanClass=SkHubiKaisyouUiBean.class)
public class SkHubiKaisyouAction {

    @Inject
    private SkHubiKaisyouBizLogic bizLogic;

    @Inject
    private SkHubiKaisyouUiBean uiBean;

    public String init() {
        bizLogic.init();
        return FORWARDNAME_INPUTKEY;
    }

    @End
    public String tojiruBtnOnClick() {
        bizLogic.unlockProcess();
        return null;
    }

    @Begin(nested=true)
    public String nyuuryokuLinkOnClick() {
        try {
            bizLogic.pushInputBL();
            return FORWARDNAME_INPUTCONTENTS;
        }
        catch (BizLogicException bzEx) {
            bizLogic.unlockProcess();
            throw bzEx;
        }
    }

    @Begin
    public String kakuteibtnbyinputkeyOnClick() {
        try {
            String forward = bizLogic.pushKakuteiInputBL();
            return forward;
        }
        catch (BizLogicException bzEx) {
            bizLogic.unlockProcess();
            throw bzEx;
        }
    }

    @End
    public String modorubtnbyitiransentakuOnClick() {
        return FORWARDNAME_INIT;
    }

    @End(nested=true)
    public String modoruBtnByInputContentsOnClick() {
        String forWard = null;
        forWard = bizLogic.pushmodoruBtnByInputContentsBL();
        return forWard;
    }

    public String kakuninBtnOnClick() {
        bizLogic.pushKakuninBL();
        return FORWARDNAME_CONFIRM;
    }

    public String modoruBtnByConfirmOnClick() {
        bizLogic.pushmodoruBtnByConfirmBL();
        return FORWARDNAME_INPUTCONTENTS;
    }

    @MultiPostConstraints
    public String kakuteibtnbyconfirmOnClick() {
        bizLogic.pushOKBL();
        return FORWARDNAME_RESULT;
    }

    @End
    public String syokigamenheBtnOnClick() {
        return FORWARDNAME_INIT;
    }

    @End(nested=true)
    public String syokigamenhebtnbyworkflowOnClick() {
        return FORWARDNAME_BACKTOWORKLIST;
    }

    @End(nested=true)
    public String functionNameOnClick() {
        String forWard = null;
        forWard = bizLogic.pushKinouNmLinkBL();
        return forWard;
    }

    @End(nested=true)
    public String nestedEndOnClick() {
        String forWard = null;
        forWard = bizLogic.pushNestedEndBL();
        return forWard;
    }

    public String fromSinkeiyakuWorkList() {
        try {
            bizLogic.iwfOpenBL();
            return FORWARDNAME_INPUTCONTENTS;
        }
        catch (BizLogicException bzEx) {
            uiBean.getBzWorkflowInfo().setExceptionToRenkeiInfo(bzEx);
            bizLogic.unlockProcess();
            return FORWARDNAME_BACKTOWORKLIST;
        }
    }

    public String hyoujilinkOnClick() {
        bizLogic.printHyoujiOut();
        return null;
    }

    public String allhyoujibtnOnClick() {
        bizLogic.printAllHyoujiOut();
        return null;
    }

    @BizAppExceptionTerminate
    private void bizAppExceptionTerminate(Throwable e) {
        bizLogic.unlockProcess();
    }
}
