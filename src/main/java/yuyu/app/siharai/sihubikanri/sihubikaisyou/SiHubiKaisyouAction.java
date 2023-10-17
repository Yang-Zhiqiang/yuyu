package yuyu.app.siharai.sihubikanri.sihubikaisyou;

import static yuyu.app.siharai.sihubikanri.sihubikaisyou.SiHubiKaisyouConstants.*;

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
 * 保険金給付金不備解消 機能のアクションクラスです。
 */
@Forwards
({
    @Forward(name=FORWARDNAME_INIT,           page=PAGENO_INIT,          path="/siharai/sihubikanri/sihubikaisyou/SiHubiKaisyou.do", redirect=true),
    @Forward(name=FORWARDNAME_INPUTKEY,       page=PAGENO_INPUTKEY,      path="/siharai/sihubikanri/sihubikaisyou/si_hubi_kaisyou.jsp"),
    @Forward(name=FORWARDNAME_SELECTDATA,     page=PAGENO_SELECTDATA,    path="/siharai/sihubikanri/sihubikaisyou/si_hubi_kaisyou.jsp"),
    @Forward(name=FORWARDNAME_INPUTCONTENTS,  page=PAGENO_INPUTCONTENTS, path="/siharai/sihubikanri/sihubikaisyou/si_hubi_kaisyou.jsp"),
    @Forward(name=FORWARDNAME_CONFIRM,        page=PAGENO_CONFIRM,       path="/siharai/sihubikanri/sihubikaisyou/si_hubi_kaisyou.jsp"),
    @Forward(name=FORWARDNAME_RESULT,         page=PAGENO_RESULT,        path="/siharai/sihubikanri/sihubikaisyou/si_hubi_kaisyou.jsp"),
    @Forward(name=FORWARDNAME_BACKTOWORKLIST,                            path="/workflow/processkanri/siharaiworklist/SiharaiWorkList.do?_eventHandler=fromSiHubiKaisyou", redirect=true),
    @Forward(name=FORWARDNAME_NESTEDEND,                                 path="/siharai/sihubikanri/sihubikaisyou/SiHubiKaisyou.do?_eventHandler=nestedEndOnClick", redirect=true),
})
@Input("/siharai/sihubikanri/sihubikaisyou/si_hubi_kaisyou.jsp")
@UIBean(beanClass=SiHubiKaisyouUiBean.class)
@Roles("sihubikaisyou")
public class SiHubiKaisyouAction {

    @Inject
    private SiHubiKaisyouBizLogic bizLogic;

    @Inject
    private SiHubiKaisyouUiBean uiBean;

    public String init() {

        bizLogic.init();
        return FORWARDNAME_INPUTKEY;
    }

    @End(nested=true)
    public String functionNameOnClick() {

        String forwardName = bizLogic.pushFunctionNameBL();
        return forwardName;
    }

    @End(nested=true)
    public String nestedEndOnClick() {

        String forwardName = bizLogic.pushNestedEndBL();
        return forwardName;
    }

    public String fromSiharaiWorkList() {

        try {
            String forwardName = bizLogic.pushFromSiharaiWorkListBL();
            return forwardName;
        } catch (BizLogicException bizLogicException) {
            uiBean.getBzWorkflowInfo().setExceptionToRenkeiInfo(bizLogicException);
            bizLogic.pushUnlockProcessBL();
            return FORWARDNAME_BACKTOWORKLIST;
        }
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

    @Begin
    public String ketteiBtnOnClick() {

        try {
            String forwardName = bizLogic.pushKetteiBL();
            return forwardName;
        } catch (BizLogicException bizLogicException) {
            bizLogic.pushUnlockProcessBL();
            throw bizLogicException;
        }
    }

    @End
    public String modorubtnbyitiransentakuOnClick() {
        return FORWARDNAME_INIT;
    }

    @End(nested=true)
    public String modoruBtnByInputContentsOnClick() {

        String forwardName = bizLogic.pushModoruByInputContentsBL();
        return forwardName;
    }

    public String kakuninBtnOnClick() {

        String forwardName = bizLogic.pushKakuninBL();
        return forwardName;
    }

    public String modoruBtnByConfirmOnClick() {

        String forwardName = bizLogic.pushModoruBtnByConfirmBL();
        return forwardName;
    }

    @MultiPostConstraints
    public String kakuteiBtnOnClick() {

        try {
            String forwardName = bizLogic.pushKakuteiBL();
            return forwardName;
        } catch (BizLogicException bizLogicException) {
            bizLogic.pushUnlockProcessBL();
            throw bizLogicException;
        }
    }

    @End(nested=true)
    public String syokigamenheBtnOnClick() {

        String forwardName = bizLogic.pushSyokigamenheBL();
        return forwardName;
    }

    @BizAppExceptionTerminate
    private void bizAppExceptionTerminate(Throwable e) {

        bizLogic.pushUnlockProcessBL();
    }
}
