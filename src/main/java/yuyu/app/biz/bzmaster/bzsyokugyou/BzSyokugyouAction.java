package yuyu.app.biz.bzmaster.bzsyokugyou;

import static yuyu.app.biz.bzmaster.bzsyokugyou.GenBzSyokugyouConstants.*;

import javax.inject.Inject;

import jp.co.slcs.swak.web.auth.permission.Roles;
import jp.co.slcs.swak.web.config.annotations.Forward;
import jp.co.slcs.swak.web.config.annotations.Forwards;
import jp.co.slcs.swak.web.config.annotations.Input;
import jp.co.slcs.swak.web.config.annotations.UIBean;
import jp.co.slcs.swak.web.conversation.annotations.Begin;
import jp.co.slcs.swak.web.conversation.annotations.Begin.Mode;
import jp.co.slcs.swak.web.conversation.annotations.End;
import yuyu.app.biz.bzmaster.bzsyokugyou.BzSyokugyouConstants.E_SyoriKbn;

/**
 * 職業登録 機能のアクションクラスです。
 */
@Forwards
({
    @Forward(name=FORWARDNAME_INIT,          page=PAGENO_INIT,          path="/biz/bzmaster/bzsyokugyou/BzSyokugyou.do", redirect=true),
    @Forward(name=FORWARDNAME_INPUTKEY,      page=PAGENO_INPUTKEY,      path="/biz/bzmaster/bzsyokugyou/bz_syokugyou.jsp"),
    @Forward(name=FORWARDNAME_INPUTCONTENTS, page=PAGENO_INPUTCONTENTS, path="/biz/bzmaster/bzsyokugyou/bz_syokugyou.jsp"),
    @Forward(name=FORWARDNAME_CONFIRM,       page=PAGENO_CONFIRM,       path="/biz/bzmaster/bzsyokugyou/bz_syokugyou.jsp"),
    @Forward(name=FORWARDNAME_RESULT,        page=PAGENO_RESULT,        path="/biz/bzmaster/bzsyokugyou/bz_syokugyou.jsp"),
})
@Input("/biz/bzmaster/bzsyokugyou/bz_syokugyou.jsp")
@UIBean(beanClass=BzSyokugyouUiBean.class)
@Roles("bzsyokugyou")
public class BzSyokugyouAction {

    @Inject
    private BzSyokugyouBizLogic bizLogic;

    @Inject
    private BzSyokugyouUiBean uiBean;

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
        bizLogic.pushAddBL();
        return FORWARDNAME_INPUTCONTENTS;
    }

    @Begin
    public String henkouBtnOnClick() {
        bizLogic.pushUpdBL();
        return FORWARDNAME_INPUTCONTENTS;
    }

    @Begin(mode=Mode.DELETE)
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

    @End(mode=Mode.DELETE)
    public String modoruBtnByConfirmOnClick() {
        String returnValue = null;

        E_SyoriKbn syoriKbn = uiBean.getGmsyorikbn();

        if (syoriKbn == E_SyoriKbn.NEW) {
            returnValue = FORWARDNAME_INPUTCONTENTS;
        }
        else if (syoriKbn == E_SyoriKbn.UPD) {
            returnValue = FORWARDNAME_INPUTCONTENTS;
        }
        else if (syoriKbn == E_SyoriKbn.DEL) {
            return FORWARDNAME_INIT;
        }

        return returnValue;
    }

    @End
    public String kakuteiBtnOnClick() {
        bizLogic.pushkakuteiBL();
        return FORWARDNAME_RESULT;
    }

    public String syokigamenheBtnOnClick() {
        return FORWARDNAME_INIT;
    }
}
