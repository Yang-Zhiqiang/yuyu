package yuyu.app.sinkeiyaku.skhubikanri.skhubitouroku;

import static yuyu.app.sinkeiyaku.skhubikanri.skhubitouroku.GenSkHubiTourokuConstants.*;
import static yuyu.app.sinkeiyaku.skhubikanri.skhubitouroku.SkHubiTourokuConstants.*;

import java.io.IOException;

import javax.inject.Inject;

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
 * 新契約不備登録 機能のアクションクラスです。
 */
@Forwards
({
    @Forward(name=FORWARDNAME_INIT,           page=PAGENO_INIT,          path="/sinkeiyaku/skhubikanri/skhubitouroku/SkHubiTouroku.do", redirect=true),
    @Forward(name=FORWARDNAME_INPUTKEY,       page=PAGENO_INPUTKEY,      path="/sinkeiyaku/skhubikanri/skhubitouroku/sk_hubi_touroku.jsp"),
    @Forward(name=FORWARDNAME_SELECTDATA,     page=PAGENO_SELECTDATA,    path="/sinkeiyaku/skhubikanri/skhubitouroku/sk_hubi_touroku.jsp"),
    @Forward(name=FORWARDNAME_INPUTCONTENTS,  page=PAGENO_INPUTCONTENTS, path="/sinkeiyaku/skhubikanri/skhubitouroku/sk_hubi_touroku.jsp"),
    @Forward(name=FORWARDNAME_CONFIRM,        page=PAGENO_CONFIRM,       path="/sinkeiyaku/skhubikanri/skhubitouroku/sk_hubi_touroku.jsp"),
    @Forward(name=FORWARDNAME_RESULT,         page=PAGENO_RESULT,        path="/sinkeiyaku/skhubikanri/skhubitouroku/sk_hubi_touroku.jsp"),
    @Forward(name=FORWARDNAME_BACKTOWORKLIST,                            path="/workflow/processkanri/sinkeiyakuworklist/SinkeiyakuWorkList.do?_eventHandler=fromSkHubiTouroku", redirect=true),
    @Forward(name=FORWARDNAME_NESTEDEND,                                 path="/sinkeiyaku/skhubikanri/skhubitouroku/SkHubiTouroku.do?_eventHandler=nestedEndOnClick", redirect=true),
    @Forward(name=FORWARDNAME_TENKEN_INPUTCONTENTS, page=PAGENO_TENKEN_INPUTCONTENTS, path="/sinkeiyaku/skhubikanri/skhubitouroku/sk_hubi_touroku.jsp"),
    @Forward(name=FORWARDNAME_TENKEN_CONFIRM,       page=PAGENO_TENKEN_CONFIRM,       path="/sinkeiyaku/skhubikanri/skhubitouroku/sk_hubi_touroku.jsp"),
})
@Input("/sinkeiyaku/skhubikanri/skhubitouroku/sk_hubi_touroku.jsp")
@UIBean(beanClass=SkHubiTourokuUiBean.class)
public class SkHubiTourokuAction {

    @Inject
    private SkHubiTourokuBizLogic bizLogic;

    @Inject
    private SkHubiTourokuUiBean uiBean;

    public String init() {

        bizLogic.init();
        return FORWARDNAME_INPUTKEY;
    }

    public String fromSinkeiyakuWorkList() {

        try {
            bizLogic.iwfOpenBL();
            return FORWARDNAME_INPUTCONTENTS;
        } catch (BizLogicException bizLogicException) {
            uiBean.getBzWorkflowInfo().setExceptionToRenkeiInfo(bizLogicException);
            bizLogic.unlockProcessBL();
            return FORWARDNAME_BACKTOWORKLIST;
        }
    }

    @End
    public String tojiruBtnOnClick() {

        bizLogic.unlockProcessBL();

        return null;
    }

    @End(nested=true,mode=Mode.A)
    public String tojirubtnbyinputcontentsOnClick() {
        return null;
    }

    @Begin(nested=true)
    public String nyuuryokuLinkOnClick() {
        try {
            bizLogic.pushInputBL();
            return FORWARDNAME_INPUTCONTENTS;
        } catch (BizLogicException bizLogicException) {
            bizLogic.unlockProcessBL();
            throw bizLogicException;
        }
    }

    @End(nested=true)
    public String nestedEndOnClick() {
        String forward = null;
        forward = bizLogic.pushNestedEndBL();
        return forward;
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
    public String tourokuBtnOnClick() {
        try {
            return bizLogic.pushTourokuBL();
        } catch (BizLogicException bizLogicException) {
            bizLogic.unlockProcessBL();
            throw bizLogicException;
        }
    }

    @End
    public String modorubtnbyitiransentakuOnClick() {
        return FORWARDNAME_INIT;
    }

    @End(nested=true)
    public String modoruBtnByInputContentsOnClick() {
        return bizLogic.pushModoruBtnByInputContentsBL();
    }

    public String kakuninBtnOnClick() {
        return bizLogic.pushKakuninBL();
    }

    public String dialogOkOnClick() {
        bizLogic.pushDialogOkOnClickBL();
        return FORWARDNAME_CONFIRM;
    }

    public String karisakuseibtnOnClick() {
        bizLogic.pushKarisakuseiBL();
        return FORWARDNAME_INPUTCONTENTS;
    }

    public String modoruBtnByConfirmOnClick() {

        bizLogic.pushModoruBtnByConfirmBL();
        return FORWARDNAME_INPUTCONTENTS;
    }

    @MultiPostConstraints
    public String kakuteiBtnOnClick() {

        bizLogic.pushKakuteiBL();
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

    @MultiPostConstraints
    public void print() {
        bizLogic.printOut();
    }

    @End(nested=true)
    public String functionNameOnClick() {

        return bizLogic.functionNameOnClickBL();
    }

    public String callAjaxHubiKbn() throws IOException {
        bizLogic.callAjaxHubiKbn();

        return FORWARDNAME_INPUTCONTENTS;
    }

    public String callAjaxHubiReason() throws IOException {
        bizLogic.callAjaxHubiReason();

        return FORWARDNAME_INPUTCONTENTS;
    }

    @Begin(nested = true, mode = Mode.A)
    public String tenkenInputContents() {
        bizLogic.pushTenkenInputContentsBL();
        return FORWARDNAME_TENKEN_INPUTCONTENTS;
    }

    public String tenkenConfirm () {
        bizLogic.pushTenkenConfirmBL();
        return FORWARDNAME_TENKEN_CONFIRM;
    }

    public String tourokubtnbypopupOnClick() {
        bizLogic.pushTourokuBtnByInputTenkenBL();
        return FORWARDNAME_TENKEN_INPUTCONTENTS;
    }

    public String dialogOkByTenkenOnClick() {
        bizLogic.pushDialogOkByTenkenOnClick();
        return FORWARDNAME_TENKEN_INPUTCONTENTS;
    }

    public String karisakuseibtnbypopupOnClick() {
        bizLogic.pushKarisakuseiBL();
        return FORWARDNAME_TENKEN_INPUTCONTENTS;
    }

    public void karisakuseiPrint() {
        bizLogic.karisakuseiPrintOut();
    }

    @BizAppExceptionTerminate
    private void bizAppExceptionTerminate(Throwable e) {
        bizLogic.unlockProcessBL();
    }
}
