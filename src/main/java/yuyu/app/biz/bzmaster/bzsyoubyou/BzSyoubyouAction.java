package yuyu.app.biz.bzmaster.bzsyoubyou;

import static yuyu.app.biz.bzmaster.bzsyoubyou.GenBzSyoubyouConstants.*;

import javax.inject.Inject;

import jp.co.slcs.swak.web.auth.permission.Roles;
import jp.co.slcs.swak.web.config.annotations.Forward;
import jp.co.slcs.swak.web.config.annotations.Forwards;
import jp.co.slcs.swak.web.config.annotations.Input;
import jp.co.slcs.swak.web.config.annotations.UIBean;
import jp.co.slcs.swak.web.conversation.annotations.Begin;
import jp.co.slcs.swak.web.conversation.annotations.Begin.Mode;
import jp.co.slcs.swak.web.conversation.annotations.End;
import yuyu.app.biz.bzmaster.bzsyoubyou.BzSyoubyouConstants.E_SyoriKbn;

/**
 * 傷病登録 機能のアクションクラスです。
 */
@Forwards
({
    @Forward(name=FORWARDNAME_INIT,          page=PAGENO_INIT,          path="/biz/bzmaster/bzsyoubyou/BzSyoubyou.do", redirect=true),
    @Forward(name=FORWARDNAME_INPUTKEY,      page=PAGENO_INPUTKEY,      path="/biz/bzmaster/bzsyoubyou/bz_syoubyou.jsp"),
    @Forward(name=FORWARDNAME_INPUTCONTENTS, page=PAGENO_INPUTCONTENTS, path="/biz/bzmaster/bzsyoubyou/bz_syoubyou.jsp"),
    @Forward(name=FORWARDNAME_CONFIRM,       page=PAGENO_CONFIRM,       path="/biz/bzmaster/bzsyoubyou/bz_syoubyou.jsp"),
    @Forward(name=FORWARDNAME_RESULT,        page=PAGENO_RESULT,        path="/biz/bzmaster/bzsyoubyou/bz_syoubyou.jsp"),
})
@Input("/biz/bzmaster/bzsyoubyou/bz_syoubyou.jsp")
@UIBean(beanClass=BzSyoubyouUiBean.class)
@Roles("bzsyoubyou")
public class BzSyoubyouAction {

    @Inject
    private BzSyoubyouBizLogic bizLogic;

    @Inject
    private BzSyoubyouUiBean uiBean;

    public String init() {

        bizLogic.init();
        return FORWARDNAME_INPUTKEY;
    }

    @End
    public String tojiruBtnOnClick() {
        return null;
    }

    @Begin
    public String tourokuBtnOnClick() {
        bizLogic.pushNewBL();
        return FORWARDNAME_INPUTCONTENTS;
    }

    @Begin
    public String henkouBtnOnClick() {
        bizLogic.pushUpdBL();
        return FORWARDNAME_INPUTCONTENTS;
    }

    @Begin(mode = Mode.DELETE)
    public String sakujyoBtnOnClick() {
        bizLogic.pushDelBL();
        return FORWARDNAME_CONFIRM;
    }

    @End
    public String modoruBtnByInputContentsOnClick() {
        return FORWARDNAME_INIT;
    }

    public String kakuninBtnOnClick() {
        bizLogic.pushKakuninBL();
        return FORWARDNAME_CONFIRM;
    }

    @End(mode = Mode.DELETE)
    public String modoruBtnByConfirmOnClick() {

        E_SyoriKbn syoriKbn = uiBean.getGmsyorikbn();

        if (syoriKbn == E_SyoriKbn.NEW){
            return FORWARDNAME_INPUTCONTENTS;
        }
        else if (syoriKbn == E_SyoriKbn.UPD) {
            return FORWARDNAME_INPUTCONTENTS;
        }
        else {
            return FORWARDNAME_INIT;
        }
    }

    @End
    public String kakuteiBtnOnClick() {
        bizLogic.pushKakuteiBL();
        return FORWARDNAME_RESULT;
    }

    public String syokigamenheBtnOnClick() {
        return FORWARDNAME_INIT;
    }

    @End
    public String functionNameOnClick() {
        return FORWARDNAME_INIT;
    }
}
