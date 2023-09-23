package yuyu.common.inject;

import jp.co.slcs.swak.core.inject.AbstractSWAKModule;
import yuyu.common.base.BaseUserInfo;
import yuyu.infr.auth.LoginUser;

import com.google.inject.servlet.SessionScoped;

/**
 * Baseパッケージのインジェクトモジュール定義クラスです。
 */
public class YuyuCommonModule extends AbstractSWAKModule {

    @Override
    protected void configure() {
        bind(LoginUser.class).to(getLoginUserClass());

        bind(BaseUserInfo                 .class)
            .toProvider(UserProvider      .class)
            .in(SessionScoped             .class);
    }

    protected Class<? extends LoginUser> getLoginUserClass() {
        return BaseUserInfo.class;
    }
}
