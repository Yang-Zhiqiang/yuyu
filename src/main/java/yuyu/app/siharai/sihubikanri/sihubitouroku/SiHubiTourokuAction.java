package yuyu.app.siharai.sihubikanri.sihubitouroku;

import static yuyu.app.siharai.sihubikanri.sihubitouroku.GenSiHubiTourokuConstants.*;
import static yuyu.app.siharai.sihubikanri.sihubitouroku.SiHubiTourokuConstants.*;

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
 * 保険金給付金不備登録 機能のアクションクラスです。
 */
@Forwards
({
    @Forward(name=FORWARDNAME_INIT,          page=PAGENO_INIT,          path="/siharai/sihubikanri/sihubitouroku/SiHubiTouroku.do", redirect=true),
    @Forward(name=FORWARDNAME_INPUTKEY,      page=PAGENO_INPUTKEY,      path="/siharai/sihubikanri/sihubitouroku/si_hubi_touroku.jsp"),
    @Forward(name=FORWARDNAME_SELECTDATA,    page=PAGENO_SELECTDATA,    path="/siharai/sihubikanri/sihubitouroku/si_hubi_touroku.jsp"),
    @Forward(name=FORWARDNAME_INPUTCONTENTS, page=PAGENO_INPUTCONTENTS, path="/siharai/sihubikanri/sihubitouroku/si_hubi_touroku.jsp"),
    @Forward(name=FORWARDNAME_CONFIRM,       page=PAGENO_CONFIRM,       path="/siharai/sihubikanri/sihubitouroku/si_hubi_touroku.jsp"),
    @Forward(name=FORWARDNAME_RESULT,        page=PAGENO_RESULT,        path="/siharai/sihubikanri/sihubitouroku/si_hubi_touroku.jsp"),
    @Forward(name=FORWARDNAME_BACKTOWORKLIST,                           path="/workflow/processkanri/siharaiworklist/SiharaiWorkList.do?_eventHandler=fromSiHubiTouroku", redirect=true),
    @Forward(name=FORWARDNAME_NESTEDEND,                                path="/siharai/sihubikanri/sihubitouroku/SiHubiTouroku.do?_eventHandler=nestedEndOnClick", redirect=true),
})
@Input("/siharai/sihubikanri/sihubitouroku/si_hubi_touroku.jsp")
@UIBean(beanClass=SiHubiTourokuUiBean.class)
@Roles("sihubitouroku")
public class SiHubiTourokuAction {

    @Inject
    private SiHubiTourokuBizLogic bizLogic;

    @Inject
    private SiHubiTourokuUiBean uiBean;

    public String init() {

        bizLogic.init();
        return FORWARDNAME_INPUTKEY;
    }

    @End(nested = true)
    public String functionNameOnClick() {

        String forwardName = bizLogic.pushFunctionNameBL();
        return forwardName;
    }

    @End
    public String nestedEndOnClick() {

        String forwardName = bizLogic.pushNestedEndBL();
        return forwardName;
    }

    @Begin(renew=true)
    public String hbtrbtnOnClick() {

        String forwardName = bizLogic.pushHbtrbtnOnClickBL();
        return forwardName;
    }

    public String fromSiharaiWorkList() {

        String forwardName = "";
        try {
            forwardName = bizLogic.pushFromSiharaiWorkListBL();
        } catch (BizLogicException bizLogicException) {
            uiBean.getBzWorkflowInfo().setExceptionToRenkeiInfo(bizLogicException);
            bizLogic.pushUnlockProcessBL();
            return FORWARDNAME_BACKTOWORKLIST;
        }
        return forwardName;
    }

    @End
    public String tojiruBtnOnClick() {

        bizLogic.pushTojiruBL();
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

    @Begin(nested=true)
    public String nyuuryokuLinkOnClick() {

        String forwardName = bizLogic.pushInputBL();
        return forwardName;
    }

    @Roles({ "sihubitouroku.hubitouroku", "sihubitouroku.hubisyounin" })
    public String karisakuseibtnOnClick() {

        String forwardName = bizLogic.pushKarisakuseiBL();
        return forwardName;
    }

    @Begin
    public String tourokuBtnOnClick() {

        String forwardName = bizLogic.pushTourokuBL();
        return forwardName;
    }

    @End
    public String modorubtnbyitiransentakuOnClick() {
        return FORWARDNAME_INIT;
    }

    @End(nested=true)
    @Roles({ "sihubitouroku.hubitouroku", "sihubitouroku.hubisyounin" })
    public String modoruBtnByInputContentsOnClick() {

        String forwardName = bizLogic.pushModoruByInputContentsBL();
        return forwardName;
    }

    @Roles({ "sihubitouroku.hubitouroku", "sihubitouroku.hubisyounin" })
    public String kakuninBtnOnClick() {

        String forwardName = bizLogic.pushKakuninBL();
        return forwardName;
    }

    @Roles({ "sihubitouroku.hubitouroku", "sihubitouroku.hubisyounin" })
    public String modoruBtnByConfirmOnClick() {

        String forwardName = bizLogic.pushModoruBtnByConfirmBL();
        return forwardName;
    }

    @MultiPostConstraints
    @Roles({ "sihubitouroku.hubitouroku", "sihubitouroku.hubisyounin" })
    public String kakuteiBtnOnClick() {

        try {
            String forwardName = bizLogic.pushKakuteiBL();
            return forwardName;
        } catch (BizLogicException bizLogicException) {
            bizLogic.pushUnlockProcessBL();
            throw bizLogicException;
        }
    }

    @End(nested = true)
    @Roles({ "sihubitouroku.hubitouroku", "sihubitouroku.hubisyounin" })
    public String syokigamenheBtnOnClick() {

        String forwardName = bizLogic.pushSyokigamenheBL();
        return forwardName;
    }

    @MultiPostConstraints
    public void print() {

        bizLogic.printOut();
    }

    public void karisakuseiPrint() {

        bizLogic.karisakuseiPrintOut();
    }

    @BizAppExceptionTerminate
    private void bizAppExceptionTerminate(Throwable e) {

        bizLogic.pushUnlockProcessBL();
    }
}
