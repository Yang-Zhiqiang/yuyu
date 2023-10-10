package yuyu.app.siharai.sisatei.sisindansyoryousiharai;

import static yuyu.app.siharai.sisatei.sisindansyoryousiharai.GenSiSindansyoryouSiharaiConstants.*;

import javax.inject.Inject;

import jp.co.slcs.swak.bizinfr.exception.BizLogicException;
import jp.co.slcs.swak.web.annotation.BizAppExceptionTerminate;
import jp.co.slcs.swak.web.auth.permission.Roles;
import jp.co.slcs.swak.web.config.annotations.Forward;
import jp.co.slcs.swak.web.config.annotations.Forwards;
import jp.co.slcs.swak.web.config.annotations.Input;
import jp.co.slcs.swak.web.config.annotations.UIBean;
import jp.co.slcs.swak.web.conversation.annotations.Begin;
import jp.co.slcs.swak.web.conversation.annotations.End;
import jp.co.slcs.swak.web.conversation.annotations.MultiPostConstraints;

/**
 * 診断書料支払 機能のアクションクラスです。
 */
@Forwards
({
    @Forward(name=FORWARDNAME_INIT,                page=PAGENO_INIT,                path="/siharai/sisatei/sisindansyoryousiharai/SiSindansyoryouSiharai.do", redirect=true),
    @Forward(name=FORWARDNAME_INPUTKEY,            page=PAGENO_INPUTKEY,            path="/siharai/sisatei/sisindansyoryousiharai/si_sindansyoryou_siharai.jsp"),
    @Forward(name=FORWARDNAME_INPUTCONTENTSINPUT,  page=PAGENO_INPUTCONTENTSINPUT,  path="/siharai/sisatei/sisindansyoryousiharai/si_sindansyoryou_siharai.jsp"),
    @Forward(name=FORWARDNAME_INPUTCONTENTSTENKEN, page=PAGENO_INPUTCONTENTSTENKEN, path="/siharai/sisatei/sisindansyoryousiharai/si_sindansyoryou_siharai.jsp"),
    @Forward(name=FORWARDNAME_CONFIRM,             page=PAGENO_CONFIRM,             path="/siharai/sisatei/sisindansyoryousiharai/si_sindansyoryou_siharai.jsp"),
    @Forward(name=FORWARDNAME_RESULT,              page=PAGENO_RESULT,              path="/siharai/sisatei/sisindansyoryousiharai/si_sindansyoryou_siharai.jsp"),
    @Forward(name=FORWARDNAME_BACKTOWORKLIST,                                       path="/workflow/processkanri/siharaiworklist/SiharaiWorkList.do?_eventHandler=fromSiSindansyoryouSiharai", redirect=true),
})
@Input("/siharai/sisatei/sisindansyoryousiharai/si_sindansyoryou_siharai.jsp")
@UIBean(beanClass=SiSindansyoryouSiharaiUiBean.class)
@Roles("sisindansyoryousiharai")
public class SiSindansyoryouSiharaiAction {

    @Inject
    private SiSindansyoryouSiharaiBizLogic bizLogic;

    @Inject
    private SiSindansyoryouSiharaiUiBean uiBean;

    public String init() {

        bizLogic.init();
        return FORWARDNAME_INPUTKEY;
    }

    public String fromSiharaiWorkList() {

        String sForwardName;

        try {

            sForwardName = bizLogic.pushFromSiharaiWorkListBL();
        } catch (BizLogicException bizLogicException) {

            bizLogic.pushUnlockProcessBL();

            uiBean.getBzWorkflowInfo().setExceptionToRenkeiInfo(bizLogicException);

            return FORWARDNAME_BACKTOWORKLIST;
        }

        return sForwardName;
    }

    @Roles("sittzkrirekisyoukai")
    public String fromSiTtzkRirekiSyoukai() {

        String sForwardName = bizLogic.pushFromSiSindansyoryouSiharaiBL();

        return sForwardName;
    }

    @End(nested=true)
    public String functionNameOnClick() {

        String sForwardName = bizLogic.pushFunctionNameBL();

        return sForwardName;
    }

    @End
    public String tojiruBtnOnClick() {

        bizLogic.pushTojiruBL();

        return null;
    }

    @Begin
    public String ketteiBtnOnClick() {

        String sForwardName = bizLogic.pushKetteiBL();

        return sForwardName;
    }

    @End(nested=true)
    @Roles({"sisindansyoryousiharai.input","sisindansyoryousiharai.tenken"})
    public String modoruBtnByInputContentsOnClick() {

        String sForwardName = bizLogic.pushModoruBtnByInputContentsBL();

        return sForwardName;
    }

    @Roles({"sisindansyoryousiharai.input","sisindansyoryousiharai.tenken"})
    public String kakuninBtnOnClick() {

        String sForwardName = bizLogic.pushKakuninBL();

        return sForwardName;
    }

    @Roles({"sisindansyoryousiharai.input","sisindansyoryousiharai.tenken"})
    public String modoruBtnByConfirmOnClick() {

        String sForwardName = bizLogic.pushModoruBtnByConfirmBL();

        return sForwardName;
    }

    @MultiPostConstraints
    @Roles({"sisindansyoryousiharai.input","sisindansyoryousiharai.tenken"})
    public String kakuteiBtnOnClick() {

        String sForwardName;

        try {

            sForwardName = bizLogic.pushKakuteiBL();
        } catch (BizLogicException bizLogicException) {

            bizLogic.pushUnlockProcessBL();

            throw bizLogicException;
        }

        return sForwardName;
    }

    @End(nested=true)
    @Roles({"sisindansyoryousiharai.input","sisindansyoryousiharai.tenken"})
    public String syokigamenheBtnOnClick() {

        String sForwardName = bizLogic.pushSyokigamenheBL();

        return sForwardName;
    }

    @MultiPostConstraints
    public void print() {

        bizLogic.printOut();
    }

    @BizAppExceptionTerminate
    private void bizAppExceptionTerminate(Throwable e) {

        bizLogic.pushUnlockProcessBL();
    }
}
