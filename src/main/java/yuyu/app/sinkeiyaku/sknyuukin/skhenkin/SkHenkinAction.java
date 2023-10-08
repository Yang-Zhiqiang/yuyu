package yuyu.app.sinkeiyaku.sknyuukin.skhenkin;

import static yuyu.app.sinkeiyaku.sknyuukin.skhenkin.GenSkHenkinConstants.*;
import static yuyu.app.sinkeiyaku.sknyuukin.skhenkin.SkHenkinConstants.*;

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
import yuyu.def.classification.C_SkkinouModeIdKbn;

/**
 * 返金入力 機能のアクションクラスです。
 */
@Forwards
({
    @Forward(name=FORWARDNAME_INIT,           page=PAGENO_INIT,          path="/sinkeiyaku/sknyuukin/skhenkin/SkHenkin.do", redirect=true),
    @Forward(name=FORWARDNAME_INIT_KIBOU,     page=PAGENO_INIT_KIBOU,    path="/sinkeiyaku/sknyuukin/skhenkin/SkHenkin.do?_eventHandler=initHenkinkibou", redirect=true),
    @Forward(name=FORWARDNAME_INPUTKEY,       page=PAGENO_INPUTKEY,      path="/sinkeiyaku/sknyuukin/skhenkin/sk_henkin.jsp"),
    @Forward(name=FORWARDNAME_INPUTCONTENTS,  page=PAGENO_INPUTCONTENTS, path="/sinkeiyaku/sknyuukin/skhenkin/sk_henkin.jsp"),
    @Forward(name=FORWARDNAME_CONFIRM,        page=PAGENO_CONFIRM,       path="/sinkeiyaku/sknyuukin/skhenkin/sk_henkin.jsp"),
    @Forward(name=FORWARDNAME_RESULT,         page=PAGENO_RESULT,        path="/sinkeiyaku/sknyuukin/skhenkin/sk_henkin.jsp"),
    @Forward(name=FORWARDNAME_BACKTOWORKLIST,                            path="/workflow/processkanri/sinkeiyakuworklist/SinkeiyakuWorkList.do?_eventHandler=fromSkHenkin", redirect=true),
})
@Input("/sinkeiyaku/sknyuukin/skhenkin/sk_henkin.jsp")
@UIBean(beanClass=SkHenkinUiBean.class)
public class SkHenkinAction {

    @Inject
    private SkHenkinBizLogic bizLogic;

    @Inject
    private SkHenkinUiBean uiBean;

    @Begin
    public String init() {

        bizLogic.init();
        return FORWARDNAME_INPUTKEY;
    }

    @Begin
    public String initHenkinkibou(){

        bizLogic.initHenkinkibou();
        return FORWARDNAME_INPUTKEY;
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

    @End
    public String tojiruBtnOnClick() {

        bizLogic.unlockProcess();
        return null;
    }

    public String tourokuBtnOnClick() {
        try {
            bizLogic.openInputBL(C_SkkinouModeIdKbn.HENKINNYUURYOKU, true);
        } catch (BizLogicException bizLogicException) {
            bizLogic.unlockProcess();
            throw bizLogicException;
        }
        return FORWARDNAME_INPUTCONTENTS;
    }

    public String henkinkiboubtnOnClick() {

        bizLogic.openInputBL(C_SkkinouModeIdKbn.HENKINKIBOU, true);
        return FORWARDNAME_INPUTCONTENTS;
    }

    @End(nested=true)
    public String modoruBtnByInputContentsOnClick() {

        bizLogic.unlockProcess();
        String seniSaki = bizLogic.pushModoruBtnByInputContentsBL();
        return seniSaki;
    }

    public String kakuninBtnOnClick() {

        bizLogic.continueLockProcess();
        bizLogic.pushKakuninBL();
        return FORWARDNAME_CONFIRM;
    }

    public String modoruBtnByConfirmOnClick() {

        bizLogic.continueLockProcess();
        bizLogic.pushModoruBtnByConfirmBL();
        return FORWARDNAME_INPUTCONTENTS;
    }

    @MultiPostConstraints
    public String kakuteiBtnOnClick() {

        bizLogic.continueLockProcess();
        bizLogic.pushKakuteiBL();
        bizLogic.unlockProcess();
        return FORWARDNAME_RESULT;
    }

    @End(nested=true)
    public String syokigamenheBtnOnClick() {

        String seniSaki = bizLogic.getSenisaki();
        return seniSaki;
    }

    @End(nested=true)
    public String functionNameOnClick() {

        bizLogic.unlockProcess();
        String seniSaki = bizLogic.getSenisaki();
        return seniSaki;
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
