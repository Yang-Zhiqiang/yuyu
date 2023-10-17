package yuyu.app.base.menu.passwordhenkou;

import static yuyu.app.base.menu.passwordhenkou.GenPasswordHenkouConstants.*;

import javax.inject.Inject;

import jp.co.slcs.swak.web.auth.permission.Roles;
import jp.co.slcs.swak.web.config.annotations.Forward;
import jp.co.slcs.swak.web.config.annotations.Forwards;
import jp.co.slcs.swak.web.config.annotations.Input;
import jp.co.slcs.swak.web.config.annotations.UIBean;
import jp.co.slcs.swak.web.conversation.annotations.Begin;
import jp.co.slcs.swak.web.conversation.annotations.End;

/**
 * パスワード変更 機能のアクションクラスです。
 */
@Forwards
({
    @Forward(name=FORWARDNAME_INIT,          page=PAGENO_INIT,          path="/base/menu/passwordhenkou/PasswordHenkou.do", redirect=true),
    @Forward(name=FORWARDNAME_INPUTCONTENTS, page=PAGENO_INPUTCONTENTS, path="/base/menu/passwordhenkou/password_henkou.jsp"),
    @Forward(name=FORWARDNAME_RESULT,        page=PAGENO_RESULT,        path="/base/menu/passwordhenkou/password_henkou.jsp"),
})
@Input("/base/menu/passwordhenkou/password_henkou.jsp")
@UIBean(beanClass=PasswordHenkouUiBean.class)
@Roles("passwordhenkou")
public class PasswordHenkouAction {

    @Inject
    private PasswordHenkouBizLogic bizLogic;

    @Begin
    public String init() {

        bizLogic.init();
        return FORWARDNAME_INPUTCONTENTS;
    }

    @End
    public String tojiruBtnOnClick() {
        return null;
    }

    public String henkouBtnOnClick() {
        bizLogic.passwordHenkou();
        return FORWARDNAME_RESULT;
    }
}
