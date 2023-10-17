package yuyu.app.siharai.sisatei.sisyounintorikesi;

import static yuyu.app.siharai.sisatei.sisyounintorikesi.GenSiSyouninTorikesiConstants.*;

import javax.inject.Inject;

import jp.co.slcs.swak.web.auth.permission.Roles;
import jp.co.slcs.swak.web.config.annotations.Forward;
import jp.co.slcs.swak.web.config.annotations.Forwards;
import jp.co.slcs.swak.web.config.annotations.Input;
import jp.co.slcs.swak.web.config.annotations.UIBean;
import jp.co.slcs.swak.web.conversation.annotations.Begin;
import jp.co.slcs.swak.web.conversation.annotations.End;

/**
 * 承認取消 機能のアクションクラスです。
 */
@Forwards
({
    @Forward(name=FORWARDNAME_INIT,          page=PAGENO_INIT,          path="/siharai/sisatei/sisyounintorikesi/SiSyouninTorikesi.do", redirect=true),
    @Forward(name=FORWARDNAME_INPUTKEY,      page=PAGENO_INPUTKEY,      path="/siharai/sisatei/sisyounintorikesi/si_syounin_torikesi.jsp"),
    @Forward(name=FORWARDNAME_INPUTCONTENTS, page=PAGENO_INPUTCONTENTS, path="/siharai/sisatei/sisyounintorikesi/si_syounin_torikesi.jsp"),
    @Forward(name=FORWARDNAME_CONFIRM,       page=PAGENO_CONFIRM,       path="/siharai/sisatei/sisyounintorikesi/si_syounin_torikesi.jsp"),
    @Forward(name=FORWARDNAME_RESULT,        page=PAGENO_RESULT,        path="/siharai/sisatei/sisyounintorikesi/si_syounin_torikesi.jsp"),
})
@Input("/siharai/sisatei/sisyounintorikesi/si_syounin_torikesi.jsp")
@UIBean(beanClass=SiSyouninTorikesiUiBean.class)
@Roles("sisyounintorikesi")
public class SiSyouninTorikesiAction {

    @Inject
    private SiSyouninTorikesiBizLogic bizLogic;

    public String init() {
        bizLogic.init();
        return FORWARDNAME_INPUTKEY;
    }

    @End
    public String functionNameOnClick() {
        bizLogic.doUnlockProcess();
        return FORWARDNAME_INIT;
    }

    @Roles("sittzkrirekisyoukai")
    public String fromSiTtzkRirekiSyoukai() {
        bizLogic.pushFromSiTtzkRirekiSyoukai();
        return FORWARDNAME_CONFIRM;
    }

    @End
    public String tojiruBtnOnClick() {
        bizLogic.doUnlockProcess();
        return null;
    }

    @Begin
    public String ketteiBtnOnClick() {
        bizLogic.pushKetteiBL();
        return FORWARDNAME_INPUTCONTENTS;
    }

    @End
    public String modoruBtnByInputContentsOnClick() {
        bizLogic.doUnlockProcess();
        return FORWARDNAME_INIT;
    }

    public String kakuninBtnOnClick() {
        bizLogic.pushKakuninBL();
        return FORWARDNAME_CONFIRM;
    }

    public String modoruBtnByConfirmOnClick() {
        bizLogic.doContinueLockProcess();
        return FORWARDNAME_INPUTCONTENTS;
    }

    @End
    public String kakuteiBtnOnClick() {
        bizLogic.pushKakuteiBL();
        return FORWARDNAME_RESULT;
    }

    public String syokigamenheBtnOnClick() {
        return FORWARDNAME_INIT;
    }
}
