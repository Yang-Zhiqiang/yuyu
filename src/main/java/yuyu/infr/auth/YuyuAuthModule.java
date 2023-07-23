package yuyu.infr.auth;

import jp.co.slcs.swak.auth.Authenticator;
import jp.co.slcs.swak.web.auth.WebAuthModule;
import yuyu.def.base.configuration.YuyuBaseConfig;

/**
 * Web系の認証モジュール
 */
public class YuyuAuthModule extends WebAuthModule {

    @Override
    protected Class<? extends Authenticator> getAuthenticatorImplClass() {
        return YuyuAuthenticator.class;
    }

    @Override
    protected String getLoginPageURI() {
        return YuyuBaseConfig.getInstance().getLoginPageURI();
    }

    @Override
    protected String getSessionTimeoutPageURI() {
        return YuyuBaseConfig.getInstance().getSessionTimeoutPageURI();
    }

    @Override
    protected String getLoginFailedErrorCd() {
        return YuyuBaseConfig.getInstance().getLoginFailedErrorCd();
    }

    @Override
    protected String getLoggedInErrorCd() {
        return YuyuBaseConfig.getInstance().getLoggedInErrorCd();
    }

}
