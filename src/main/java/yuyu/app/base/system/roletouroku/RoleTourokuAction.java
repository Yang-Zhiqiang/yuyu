package yuyu.app.base.system.roletouroku;

import static yuyu.app.base.system.roletouroku.GenRoleTourokuConstants.*;

import javax.inject.Inject;

import jp.co.slcs.swak.web.auth.permission.Roles;
import jp.co.slcs.swak.web.config.annotations.Forward;
import jp.co.slcs.swak.web.config.annotations.Forwards;
import jp.co.slcs.swak.web.config.annotations.Input;
import jp.co.slcs.swak.web.config.annotations.UIBean;
import jp.co.slcs.swak.web.conversation.annotations.Begin;
import jp.co.slcs.swak.web.conversation.annotations.Begin.Mode;
import jp.co.slcs.swak.web.conversation.annotations.End;
import yuyu.common.base.ConversationStatus;
import yuyu.common.base.UnknownForwardException;
import yuyu.def.enumeration.E_SyoriKbn;

/**
 * ロール登録 機能のアクションクラスです。
 */

@Forwards
({
    @Forward(name=FORWARDNAME_INIT,          page=PAGENO_INIT,          path="/base/system/roletouroku/RoleTouroku.do", redirect=true),
    @Forward(name=FORWARDNAME_INPUTKEY,      page=PAGENO_INPUTKEY,      path="/base/system/roletouroku/role_touroku.jsp"),
    @Forward(name=FORWARDNAME_INPUTCONTENTS, page=PAGENO_INPUTCONTENTS, path="/base/system/roletouroku/role_touroku.jsp"),
    @Forward(name=FORWARDNAME_CONFIRM,       page=PAGENO_CONFIRM,       path="/base/system/roletouroku/role_touroku.jsp"),
    @Forward(name=FORWARDNAME_RESULT,        page=PAGENO_RESULT,        path="/base/system/roletouroku/role_touroku.jsp"),
})
@Input("/base/system/roletouroku/role_touroku.jsp")
@UIBean(beanClass=RoleTourokuUiBean.class)
@Roles("roletouroku")
public class RoleTourokuAction {

    @Inject
    private RoleTourokuBizLogic bizLogic;

    @Inject
    private ConversationStatus status;

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

        status.setSyoriKbn(E_SyoriKbn.NEW);
        bizLogic.setupUiBeanRole();
        return FORWARDNAME_INPUTCONTENTS;
    }

    @Begin
    public String henkouBtnOnClick() {

        status.setSyoriKbn(E_SyoriKbn.EDIT);
        bizLogic.setupUiBeanRole();
        return FORWARDNAME_INPUTCONTENTS;

    }

    @Begin(mode=Mode.DELETE)
    public String sakujyoBtnOnClick() {

        status.setSyoriKbn(E_SyoriKbn.DELETE);
        bizLogic.setupUiBeanRole();
        return FORWARDNAME_CONFIRM;
    }

    @End
    public String modoruBtnByInputContentsOnClick() {

        return FORWARDNAME_INIT;
    }

    @End(mode=Mode.DELETE)
    public String modoruBtnByConfirmOnClick() {

        return getConfirmBackwardName();
    }

    public String kakuninBtnOnClick() {

        bizLogic.roleTourokuMessageInfo();
        return FORWARDNAME_CONFIRM;
    }

    @End
    public String kakuteiBtnOnClick() {

        bizLogic.commitRole();
        return FORWARDNAME_RESULT;
    }

    public String syokigamenheBtnOnClick() {

        return FORWARDNAME_INIT;
    }

    private String getConfirmBackwardName(){

        switch (status.getSyoriKbn()) {
            case NEW   : return FORWARDNAME_INPUTCONTENTS;
            case EDIT  : return FORWARDNAME_INPUTCONTENTS;
            case DELETE: bizLogic.init(); return FORWARDNAME_INPUTKEY;
            default    : throw new UnknownForwardException();
        }
    }
}
