package yuyu.app.sinkeiyaku.skmousikomi.skmousikomitenken;

import static yuyu.app.sinkeiyaku.skmousikomi.skmousikomitenken.GenSkMousikomiTenkenConstants.*;

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
 * 申込点検 機能のアクションクラスです。
 */
@Forwards({
    @Forward(name = FORWARDNAME_INIT, page = PAGENO_INIT, path = "/sinkeiyaku/skmousikomi/skmousikomitenken/SkMousikomiTenken.do", redirect = true),
    @Forward(name = FORWARDNAME_INPUTKEY, page = PAGENO_INPUTKEY, path = "/sinkeiyaku/skmousikomi/skmousikomitenken/sk_mousikomi_tenken.jsp"),
    @Forward(name = FORWARDNAME_INPUTCONTENTS, page = PAGENO_INPUTCONTENTS, path = "/sinkeiyaku/skmousikomi/skmousikomitenken/sk_mousikomi_tenken.jsp"),
    @Forward(name = FORWARDNAME_CONFIRM, page = PAGENO_CONFIRM, path = "/sinkeiyaku/skmousikomi/skmousikomitenken/sk_mousikomi_tenken.jsp"),
    @Forward(name = FORWARDNAME_RESULT, page = PAGENO_RESULT, path = "/sinkeiyaku/skmousikomi/skmousikomitenken/sk_mousikomi_tenken.jsp"),
    @Forward(name = FORWARDNAME_BACKTOWORKLIST, path = "/workflow/processkanri/sinkeiyakuworklist/SinkeiyakuWorkList.do?_eventHandler=fromSkMousikomiTenken", redirect = true),
})
@Input("/sinkeiyaku/skmousikomi/skmousikomitenken/sk_mousikomi_tenken.jsp")
@UIBean(beanClass = SkMousikomiTenkenUiBean.class)
public class SkMousikomiTenkenAction {

    @Inject
    private SkMousikomiTenkenBizLogic bizLogic;

    @Inject
    private SkMousikomiTenkenUiBean uiBean;

    public String init() {

        return FORWARDNAME_INPUTKEY;
    }

    @End
    public String tojiruBtnOnClick() {
        bizLogic.closeBtnBL();
        return null;
    }

    @Begin
    public String tenkenBtnOnClick() {
        try {

            bizLogic.tenkenBtnBL();
        } catch (BizLogicException bizLogicException) {

            bizLogic.unlockProcess();

            throw bizLogicException;
        }

        return FORWARDNAME_INPUTCONTENTS;
    }

    public String fromSinkeiyakuWorkList() {
        try {
            bizLogic.iwfOpenBL();

        } catch (BizLogicException bizLogicException) {

            uiBean.getBzWorkflowInfo().setExceptionToRenkeiInfo(bizLogicException);

            bizLogic.unlockProcess();

            return FORWARDNAME_BACKTOWORKLIST;
        }

        return FORWARDNAME_INPUTCONTENTS;
    }

    public String hyoujilinkOnClick() {

        bizLogic.printHyoujiOut();

        return null;
    }

    public String allhyoujibtnOnClick() {

        bizLogic.printAllHyoujiOut();

        return null;
    }

    @End(nested = true)
    public String modoruBtnByInputContentsOnClick() {

        String rtnUrl = bizLogic.modoruBtnBysyoukaiBL();

        return rtnUrl;
    }

    public String kakuninBtnOnClick() {

        bizLogic.pushKakuninBL();

        return FORWARDNAME_CONFIRM;
    }

    public String modoruBtnByConfirmOnClick() {

        bizLogic.modoruBtnBL();

        return FORWARDNAME_INPUTCONTENTS;
    }

    @MultiPostConstraints
    public String kakuteiBtnOnClick() {

        bizLogic.pushKakuteiBL();

        return FORWARDNAME_RESULT;
    }

    @End(nested = true)
    public String syokigamenheBtnOnClick() {

        String rtnUrl = bizLogic.syokigamenBtnBL();

        return rtnUrl;
    }

    @End(nested = true)
    public String functionNameOnClick() {

        String rtnUrl = bizLogic.functionNameOnClickBL();

        return rtnUrl;
    }

    @MultiPostConstraints
    public void print() {
        bizLogic.printOut();
    }

    @BizAppExceptionTerminate
    private void bizAppExceptionTerminate(Throwable e) {

        bizLogic.unlockProcess();
    }
}
