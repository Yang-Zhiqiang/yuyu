package yuyu.app.hozen.khhubikanri.khhubikaisyou;

import static yuyu.app.hozen.khhubikanri.khhubikaisyou.GenKhHubiKaisyouConstants.*;
import static yuyu.app.hozen.khhubikanri.khhubikaisyou.KhHubiKaisyouConstants.*;

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
import yuyu.def.classification.C_KhkinouModeIdKbn;
import yuyu.infr.kinoumode.KinouMode;

/**
 * 契約保全不備解消 機能のアクションクラスです。
 */
@Forwards({
    @Forward(name = FORWARDNAME_INIT, page = PAGENO_INIT, path = "/hozen/khhubikanri/khhubikaisyou/KhHubiKaisyou.do", redirect = true),
    @Forward(name = FORWARDNAME_INPUTKEY, page = PAGENO_INPUTKEY, path = "/hozen/khhubikanri/khhubikaisyou/kh_hubi_kaisyou.jsp"),
    @Forward(name = FORWARDNAME_SELECTDATA, page = PAGENO_SELECTDATA, path = "/hozen/khhubikanri/khhubikaisyou/kh_hubi_kaisyou.jsp"),
    @Forward(name = FORWARDNAME_INPUTCONTENTS, page = PAGENO_INPUTCONTENTS, path = "/hozen/khhubikanri/khhubikaisyou/kh_hubi_kaisyou.jsp"),
    @Forward(name = FORWARDNAME_CONFIRM, page = PAGENO_CONFIRM, path = "/hozen/khhubikanri/khhubikaisyou/kh_hubi_kaisyou.jsp"),
    @Forward(name = FORWARDNAME_RESULT, page = PAGENO_RESULT, path = "/hozen/khhubikanri/khhubikaisyou/kh_hubi_kaisyou.jsp"),
    @Forward(name = FORWARDNAME_BACKTOWORKLIST, path = "/workflow/processkanri/hozenworklist/HozenWorkList.do?_eventHandler=fromKhHubiKaisyou", redirect = true),
    @Forward(name = FORWARDNAME_NESTEDEND, path = "/hozen/khhubikanri/khhubikaisyou/KhHubiKaisyou.do?_eventHandler=nestedEnd", redirect = true),
})
@Input("/hozen/khhubikanri/khhubikaisyou/kh_hubi_kaisyou.jsp")
@UIBean(beanClass = KhHubiKaisyouUiBean.class)
public class KhHubiKaisyouAction {

    @Inject
    private KhHubiKaisyouBizLogic bizLogic;

    @Inject
    private KhHubiKaisyouUiBean uiBean;

    @Inject
    private KinouMode kinouMode;

    public String fromHozenWorkList() {
        try {
            bizLogic.iwfOpenBL();
            bizLogic.pushInputBL();
        } catch (BizLogicException bizLogicException) {
            uiBean.getBzWorkflowInfo().setExceptionToRenkeiInfo(bizLogicException);
            bizLogic.pushUnlockProcessBL();
            return FORWARDNAME_BACKTOWORKLIST;
        }
        return FORWARDNAME_INPUTCONTENTS;
    }

    public String nestedEnd() {

        String forward = null;
        forward = bizLogic.pushNestedEndBL();
        return forward;
    }

    @End(nested = true)
    public String functionNameOnClick() {

        String forward = null;
        forward = bizLogic.pushKinouNmLink();
        return forward;
    }

    public String init() {

        bizLogic.init();
        return FORWARDNAME_INPUTKEY;
    }

    @End
    public String tojiruBtnOnClick() {
        if (PAGENO_INPUTCONTENTS == uiBean.getPageNo() || PAGENO_CONFIRM == uiBean.getPageNo()) {
            bizLogic.pushUnlockProcessBL();
        }
        return null;
    }

    public String nyuuryokuLinkOnClick() {
        try {
            bizLogic.pushInputBL();
        } catch (BizLogicException bizLogicException) {
            bizLogic.pushUnlockProcessBL();
            throw bizLogicException;
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

    @Begin
    public String kakuteibtnbyinputkeyOnClick() {
        try {
            return bizLogic.pushKakuteBL();
        } catch (BizLogicException bizLogicException) {
            bizLogic.pushUnlockProcessBL();
            throw bizLogicException;
        }
    }

    @End
    public String modorubtnbyitiransentakuOnClick() {
        return FORWARDNAME_INIT;
    }

    @End(nested = true)
    public String modoruBtnByInputContentsOnClick() {

        bizLogic.pushUnlockProcessBL();
        if (C_KhkinouModeIdKbn.HUBIKAISYOU.getValue().equals(kinouMode.getKinouMode()) ||
            C_KhkinouModeIdKbn.HUBIKAITOUMATI.getValue().equals(kinouMode.getKinouMode())) {
            return FORWARDNAME_BACKTOWORKLIST;
        }
        //        else if (E_SyoriKeiyu.ITIRAN == uiBean.getSyoriKeiyuKbn()) {
        //            return FORWARDNAME_SELECTDATA;
        //        }
        else {
            return FORWARDNAME_INIT;
        }
    }

    public String itiranheBtnByInputContentsOnClick() {

        bizLogic.pushUnlockProcessBL();
        return FORWARDNAME_SELECTDATA;
    }

    public String kakuninBtnOnClick() {

        bizLogic.pushKakuninBL();
        return FORWARDNAME_CONFIRM;
    }

    public String modoruBtnByConfirmOnClick() {

        bizLogic.continueLockProcessBL();
        bizLogic.pushmodoruBtnByConfirmBL();
        return FORWARDNAME_INPUTCONTENTS;
    }

    @MultiPostConstraints
    public String kakuteibtnbyconfirmOnClick() {

        bizLogic.pushKakuteiBL();
        bizLogic.pushUnlockProcessBL();
        return FORWARDNAME_RESULT;
    }

    @End
    public String syokigamenheBtnOnClick() {

        return FORWARDNAME_INIT;
    }

    @End(nested = true)
    public String syokigamenhebtnbyworkflowOnClick() {

        return FORWARDNAME_BACKTOWORKLIST;
    }

    @BizAppExceptionTerminate
    private void bizAppExceptionTerminate(Throwable e) {
        bizLogic.pushUnlockProcessBL();
    }
}
