package yuyu.app.hozen.khhubikanri.khhubitouroku;

import static yuyu.app.hozen.khhubikanri.khhubitouroku.GenKhHubiTourokuConstants.*;

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
 * 契約保全不備登録 機能のアクションクラスです。
 */
@Forwards({
    @Forward(name = FORWARDNAME_INIT, page = PAGENO_INIT, path = "/hozen/khhubikanri/khhubitouroku/KhHubiTouroku.do", redirect = true),
    @Forward(name = FORWARDNAME_INPUTKEY, page = PAGENO_INPUTKEY, path = "/hozen/khhubikanri/khhubitouroku/kh_hubi_touroku.jsp"),
    @Forward(name = FORWARDNAME_SELECTDATA, page = PAGENO_SELECTDATA, path = "/hozen/khhubikanri/khhubitouroku/kh_hubi_touroku.jsp"),
    @Forward(name = FORWARDNAME_INPUTCONTENTS, page = PAGENO_INPUTCONTENTS, path = "/hozen/khhubikanri/khhubitouroku/kh_hubi_touroku.jsp"),
    @Forward(name = FORWARDNAME_CONFIRM, page = PAGENO_CONFIRM, path = "/hozen/khhubikanri/khhubitouroku/kh_hubi_touroku.jsp"),
    @Forward(name = FORWARDNAME_RESULT, page = PAGENO_RESULT, path = "/hozen/khhubikanri/khhubitouroku/kh_hubi_touroku.jsp"),
    @Forward(name = FORWARDNAME_BACKTOWORKLIST, path = "/workflow/processkanri/hozenworklist/HozenWorkList.do?_eventHandler=fromKhHubiTouroku", redirect = true),
})
@Input("/hozen/khhubikanri/khhubitouroku/kh_hubi_touroku.jsp")
@UIBean(beanClass = KhHubiTourokuUiBean.class)
public class KhHubiTourokuAction {

    @Inject
    private KhHubiTourokuBizLogic bizLogic;

    @Inject
    private KhHubiTourokuUiBean uiBean;

    @Inject
    private KinouMode kinouMode;

    public String init() {

        bizLogic.init();
        return FORWARDNAME_INPUTKEY;
    }

    @End(nested = true)
    public String functionNameOnClick() {

        if (PAGENO_INPUTCONTENTS == uiBean.getPageNo() || PAGENO_CONFIRM == uiBean.getPageNo()) {
            bizLogic.unlockProcessBL();
        }

        if (C_KhkinouModeIdKbn.HUBITOUROKU.getValue().equals(kinouMode.getKinouMode()) ||
            C_KhkinouModeIdKbn.HUBISYOUNIN.getValue().equals(kinouMode.getKinouMode())) {

            return FORWARDNAME_BACKTOWORKLIST;
        }

        return FORWARDNAME_INIT;
    }

    @End
    public String tojiruBtnOnClick() {

        if (PAGENO_INPUTCONTENTS == uiBean.getPageNo() || PAGENO_CONFIRM == uiBean.getPageNo()) {
            bizLogic.unlockProcessBL();
        }
        return null;
    }

    public String hyoujilinkOnClick() {

        bizLogic.printHyoujiOut();
        return null;
    }

    public String allhyoujibtnOnClick() {

        bizLogic.printAllHyoujiOut();
        return null;
    }

    public String nyuuryokuLinkOnClick() {

        try {
            bizLogic.pushInputBL();
            bizLogic.createList();
            return FORWARDNAME_INPUTCONTENTS;
        } catch (BizLogicException bizLogicException) {
            bizLogic.unlockProcessBL();

            throw bizLogicException;
        }
    }

    public String karisakuseibtnOnClick() {
        bizLogic.listClean();
        bizLogic.pushKarisakuseiBL();
        bizLogic.createList();
        return FORWARDNAME_INPUTCONTENTS;
    }

    @Begin
    public String tourokuBtnOnClick() {

        try {
            String forwardNm = bizLogic.pushTourokuBL();
            if (FORWARDNAME_INPUTCONTENTS.equals(forwardNm)) {
                bizLogic.createList();
            }
            return forwardNm;
        } catch (BizLogicException bizLogicException) {
            bizLogic.unlockProcessBL();

            throw bizLogicException;
        }
    }

    @End
    public String modorubtnbyitiransentakuOnClick() {

        return FORWARDNAME_INIT;
    }

    @End(nested = true)
    public String modoruBtnByInputContentsOnClick() {

        bizLogic.unlockProcessBL();

        if (C_KhkinouModeIdKbn.HUBITOUROKU.getValue().equals(kinouMode.getKinouMode()) ||
            C_KhkinouModeIdKbn.HUBISYOUNIN.getValue().equals(kinouMode.getKinouMode())) {

            return FORWARDNAME_BACKTOWORKLIST;
        }

        return FORWARDNAME_INIT;
    }

    public String itiranheBtnByInputContentsOnClick() {
        bizLogic.removeConversationMessage();
        bizLogic.unlockProcessBL();
        return FORWARDNAME_SELECTDATA;
    }

    public String kakuninBtnOnClick() {

        bizLogic.listClean();
        bizLogic.pushKakuninBL();
        return FORWARDNAME_CONFIRM;
    }

    public String modoruBtnByConfirmOnClick() {

        bizLogic.continueLockProcessBL();
        bizLogic.pushModoruBtnByConfirmBL();
        bizLogic.createList();
        return FORWARDNAME_INPUTCONTENTS;
    }

    @MultiPostConstraints
    public String kakuteiBtnOnClick() {

        bizLogic.pushKakuteiBL();
        bizLogic.unlockProcessBL();
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

    public String fromHozenWorkList() {

        try {
            bizLogic.iwfOpenBL();
            bizLogic.createList();
            return FORWARDNAME_INPUTCONTENTS;

        } catch (BizLogicException bizLogicException) {

            uiBean.getBzWorkflowInfo().setExceptionToRenkeiInfo(bizLogicException);

            bizLogic.unlockProcessBL();

            return FORWARDNAME_BACKTOWORKLIST;
        }
    }

    @MultiPostConstraints
    public void print() {
        bizLogic.printOut();
    }

    public void printKarisakusei() {
        bizLogic.printOutKarisakusei();
    }

    @BizAppExceptionTerminate
    private void bizAppExceptionTerminate(Throwable e) {
        bizLogic.unlockProcessBL();
    }
}