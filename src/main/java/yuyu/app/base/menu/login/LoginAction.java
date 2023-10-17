package yuyu.app.base.menu.login;
import static yuyu.app.base.menu.login.GenLoginConstants.*;
import static yuyu.app.base.menu.login.LoginConstants.*;

import javax.inject.Inject;

import jp.co.slcs.swak.auth.Credentials;
import jp.co.slcs.swak.web.config.annotations.Forward;
import jp.co.slcs.swak.web.config.annotations.Forwards;
import jp.co.slcs.swak.web.config.annotations.Input;
import jp.co.slcs.swak.web.config.annotations.UIBean;
import yuyu.common.base.CTIParamBean;

import com.google.common.base.Strings;

/**
 * ログイン 機能のアクションクラスです。
 */
@Forwards
({
    @Forward(name=FORWARDNAME_INIT,           page=PAGENO_INIT,           path="/base/menu/login/Login.do", redirect=true),
    @Forward(name=FORWARDNAME_LOGIN,          page=PAGENO_LOGIN,          path="/base/menu/login/login.jsp"),
    @Forward(name=FORWARDNAME_CTIMENU,        page=PAGENO_CTIMENU,        path="/base/menu/login/login.jsp"),
    @Forward(name=FORWARDNAME_LOGIN_ERR,      page=PAGENO_LOGIN_ERR,      path="/base/menu/login/loginerr.jsp"),
    @Forward(name=FORWARDNAME_GOTOMENU,                                   path="/base/menu/menu/Menu.do", redirect=true),
})
@Input("/base/menu/login/login.jsp")
@UIBean(beanClass=LoginUiBean.class, name="loginUiBean")
public class LoginAction {

    @Inject
    private LoginBizLogic bizLogic;

    @Inject
    private Credentials c;

    @Inject
    private LoginUiBean uiBean;

    @Inject
    private CTIParamBean ctiParamBean;

    public String init() {

        if (bizLogic.init()) {
            return FORWARDNAME_LOGIN;
        }

        return FORWARDNAME_LOGIN_ERR;
    }

    public String toBCP() {
        return FORWARDNAME_LOGIN;
    }

    public String loginBtnOnClick() {
        // TODO 単体テストのユーザ変換可のため、ソースを前回に戻る。
        //        if (Strings.isNullOrEmpty(c.getUsername())) {
        //            if (!bizLogic.login()) {
        //                return FORWARDNAME_LOGIN_ERR;
        //            }
        //        }

        return bizLogic.login() ? FORWARDNAME_GOTOMENU : FORWARDNAME_LOGIN_ERR;
    }

    public String kakuteiBtnOnClick() {
        return bizLogic.loginForBCP() ? FORWARDNAME_GOTOMENU : FORWARDNAME_LOGIN_ERR;
    }

    public String fromCTI() {
        if (Strings.isNullOrEmpty(c.getUsername())) {
            if (!bizLogic.login()) {
                return FORWARDNAME_LOGIN_ERR;
            }
        }

        ctiParamBean.setSyono(uiBean.getSyono());

        return FORWARDNAME_CTIMENU;
    }

}
