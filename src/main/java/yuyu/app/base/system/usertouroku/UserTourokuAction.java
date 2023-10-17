package yuyu.app.base.system.usertouroku;

import static yuyu.app.base.system.usertouroku.GenUserTourokuConstants.*;

import javax.inject.Inject;

import jp.co.slcs.swak.web.auth.permission.Roles;
import jp.co.slcs.swak.web.config.annotations.Forward;
import jp.co.slcs.swak.web.config.annotations.Forwards;
import jp.co.slcs.swak.web.config.annotations.Input;
import jp.co.slcs.swak.web.config.annotations.UIBean;
import jp.co.slcs.swak.web.conversation.annotations.Begin;
import jp.co.slcs.swak.web.conversation.annotations.End;
import yuyu.common.base.ConversationStatus;
import yuyu.common.base.UnknownForwardException;
import yuyu.def.enumeration.E_SyoriKbn;

/**
 * ユーザー登録 機能のアクションクラスです。
 */
@Forwards
({
    @Forward(name=FORWARDNAME_INIT,          page=PAGENO_INIT,          path="/base/system/usertouroku/UserTouroku.do", redirect=true),
    @Forward(name=FORWARDNAME_INPUTKEY,      page=PAGENO_INPUTKEY,      path="/base/system/usertouroku/user_touroku.jsp"),
    @Forward(name=FORWARDNAME_INPUTCONTENTS, page=PAGENO_INPUTCONTENTS, path="/base/system/usertouroku/user_touroku.jsp"),
    @Forward(name=FORWARDNAME_CONFIRM,       page=PAGENO_CONFIRM,       path="/base/system/usertouroku/user_touroku.jsp"),
    @Forward(name=FORWARDNAME_RESULT,        page=PAGENO_RESULT,        path="/base/system/usertouroku/user_touroku.jsp"),
})
@Input("/base/system/usertouroku/user_touroku.jsp")
@UIBean(beanClass=UserTourokuUiBean.class)
@Roles("usertouroku")
public class UserTourokuAction {

    @Inject
    private UserTourokuBizLogic bizLogic;

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
    public String henkouBtnOnClick() {

        status.setSyoriKbn(E_SyoriKbn.EDIT);
        bizLogic.setupUiBeanUser();
        return FORWARDNAME_INPUTCONTENTS;
    }

    public String searchBtnOnClick() {
        bizLogic.searchRoleInfo();
        return FORWARDNAME_INPUTCONTENTS;
    }

    @End
    public String modoruBtnByInputContentsOnClick() {
        return FORWARDNAME_INIT;
    }

    public String modoruBtnByConfirmOnClick() {

        return getConfirmBackwardName();
    }

    public String kakuninBtnOnClick() {

        bizLogic.checkMeigininNmKanji();
        bizLogic.setRoleInfoDataSource();
        bizLogic.chkReferenceMaster();
        bizLogic.setConfirmMessage();
        return FORWARDNAME_CONFIRM;
    }

    @End
    public String kakuteiBtnOnClick() {

        bizLogic.chkReferenceMaster();
        bizLogic.commitUser();
        return FORWARDNAME_RESULT;
    }

    public String syokigamenheBtnOnClick() {
        return FORWARDNAME_INIT;
    }

    @End
    public String functionNameOnClick() {

        return FORWARDNAME_INIT;
    }

    private String getConfirmBackwardName(){

        switch (status.getSyoriKbn()) {
            case EDIT  : return FORWARDNAME_INPUTCONTENTS;
            default    : throw new UnknownForwardException();
        }
    }
}
