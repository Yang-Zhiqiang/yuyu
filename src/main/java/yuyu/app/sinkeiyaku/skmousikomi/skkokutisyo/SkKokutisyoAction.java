package yuyu.app.sinkeiyaku.skmousikomi.skkokutisyo;

import static yuyu.app.sinkeiyaku.skmousikomi.skkokutisyo.GenSkKokutisyoConstants.*;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.slcs.swak.bizinfr.exception.BizLogicException;
import jp.co.slcs.swak.web.annotation.BizAppExceptionTerminate;
import jp.co.slcs.swak.web.config.annotations.Forward;
import jp.co.slcs.swak.web.config.annotations.Forwards;
import jp.co.slcs.swak.web.config.annotations.Input;
import jp.co.slcs.swak.web.config.annotations.UIBean;
import jp.co.slcs.swak.web.conversation.annotations.Begin;
import jp.co.slcs.swak.web.conversation.annotations.Begin.Mode;
import jp.co.slcs.swak.web.conversation.annotations.End;
import jp.co.slcs.swak.web.conversation.annotations.MultiPostConstraints;

/**
 * 告知書入力 機能のアクションクラスです。
 */
@Forwards
({
    @Forward(name=FORWARDNAME_INIT,          page=PAGENO_INIT,          path="/sinkeiyaku/skmousikomi/skkokutisyo/SkKokutisyo.do", redirect=true),
    @Forward(name=FORWARDNAME_INPUTKEY,      page=PAGENO_INPUTKEY,      path="/sinkeiyaku/skmousikomi/skkokutisyo/sk_kokutisyo.jsp"),
    @Forward(name=FORWARDNAME_INPUTCONTENTS, page=PAGENO_INPUTCONTENTS, path="/sinkeiyaku/skmousikomi/skkokutisyo/sk_kokutisyo.jsp"),
    @Forward(name=FORWARDNAME_CONFIRM,       page=PAGENO_CONFIRM,       path="/sinkeiyaku/skmousikomi/skkokutisyo/sk_kokutisyo.jsp"),
    @Forward(name=FORWARDNAME_RESULT,        page=PAGENO_RESULT,        path="/sinkeiyaku/skmousikomi/skkokutisyo/sk_kokutisyo.jsp"),
    @Forward(name=FORWARDNAME_BACKTOWORKLIST,                           path="/workflow/processkanri/sinkeiyakuworklist/SinkeiyakuWorkList.do?_eventHandler=fromSkKokutisyo", redirect=true),

})
@Input("/sinkeiyaku/skmousikomi/skkokutisyo/sk_kokutisyo.jsp")
@UIBean(beanClass=SkKokutisyoUiBean.class)
public class SkKokutisyoAction {

    @Inject
    private SkKokutisyoBizLogic bizLogic;

    @Inject
    private SkKokutisyoUiBean uiBean;

    public String init() {

        bizLogic.init();
        return FORWARDNAME_INPUTKEY;
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

    @End
    public String tojiruBtnOnClick() {
        bizLogic.unlockProcess();

        return null;
    }

    @End(nested=true)
    public String functionNameOnClick() {
        return bizLogic.pushKinouNmLinkBL();
    }

    public String hyoujilinkOnClick() {
        bizLogic.printHyoujiOut();
        return null;
    }

    public String allhyoujibtnOnClick() {
        bizLogic.printAllHyoujiOut();
        return null;
    }

    @Begin
    public String sinkiitijibtnOnClick() {
        try {
            bizLogic.pushAddFirstBL();
            return FORWARDNAME_INPUTCONTENTS;
        }
        catch (BizLogicException bzEx) {
            bizLogic.unlockProcess();
            throw bzEx;
        }
    }

    @Begin
    public String sinkinijibtnOnClick() {
        try {
            bizLogic.pushAddSecondBL();
            return FORWARDNAME_INPUTCONTENTS;
        }
        catch (BizLogicException bzEx) {
            bizLogic.unlockProcess();
            throw bzEx;
        }
    }

    @Begin
    public String sinkisanjibtnOnClick() {
        try {
            bizLogic.pushAddThirdBL();
            return FORWARDNAME_INPUTCONTENTS;
        }
        catch (BizLogicException bzEx) {
            bizLogic.unlockProcess();
            throw bzEx;
        }
    }

    @Begin
    public String teiseibtnOnClick() {
        try {
            bizLogic.pushUpdBL();
            return FORWARDNAME_INPUTCONTENTS;
        }
        catch (BizLogicException bzEx) {
            bizLogic.unlockProcess();
            throw bzEx;
        }
    }

    @Begin(mode=Mode.DELETE)
    public String sakujyoBtnOnClick() {
        try {
            bizLogic.pushDelBL();
            return FORWARDNAME_CONFIRM;
        }
        catch (BizLogicException bzEx) {
            bizLogic.unlockProcess();
            throw bzEx;
        }
    }

    @End(nested=true)
    public String modoruBtnByInputContentsOnClick() {
        return bizLogic.pushModoruBtnByInputcontentsBL();
    }

    public String kakuninBtnOnClick() {
        bizLogic.pushKakuninBL();
        return FORWARDNAME_CONFIRM;
    }

    @End(mode=Mode.DELETE)
    public String modoruBtnByConfirmOnClick() {
        return bizLogic.pushmodoruBtnByConfirmBL();
    }

    @Transactional
    @MultiPostConstraints
    public String kakuteiBtnOnClick() {
        bizLogic.pushKakuteiBL();
        return FORWARDNAME_RESULT;
    }

    @End(nested=true)
    public String syokigamenheBtnOnClick() {
        return bizLogic.pushSyokiGamenhebtnBL();
    }

    @BizAppExceptionTerminate
    private void bizAppExceptionTerminate(Throwable e) {
        bizLogic.unlockProcess();
    }

}
