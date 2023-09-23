package yuyu.common.inject;

import javax.inject.Inject;
import javax.inject.Provider;
import javax.servlet.http.HttpSession;

import jp.co.slcs.swak.auth.Credentials;
import jp.co.slcs.swak.core.logger.LoggerFactory;
import jp.co.slcs.swak.util.string.StringUtil;
import jp.co.slcs.swak.web.test.MockHttpSession;

import org.slf4j.Logger;

import yuyu.common.base.BaseUserInfo;
import yuyu.def.base.manager.BaseDomManager;
import yuyu.def.classification.C_SpecialUserKbn;
import yuyu.def.db.entity.AM_User;

/**
 * ログインユーザーの {@link BaseUserInfo} を提供するプロバイダーです。<br />
 * {@link BaseUserInfo} はログインユーザーの {@link Credentials} から生成されます。
 * つまり、ログイン前は {@link BaseUserInfo} を取得することができません。
 */
public class UserProvider implements Provider<BaseUserInfo> {

    private static final Logger  logger = LoggerFactory.getLogger(UserProvider.class);

    private final Credentials    credentials;
    private final BaseDomManager domManager;
    private final HttpSession    session;

    @Deprecated
    @Inject
    protected UserProvider(
        Credentials    pCredentials,
        BaseDomManager pBaseDomManager,
        HttpSession    pSession
    ) {
        logger.trace(
            "◇ UserProvider({}, {}, {})",
            new Object[] {
                pCredentials,
                pBaseDomManager,
                pSession,
            }
        );
        credentials = pCredentials;
        domManager  = pBaseDomManager;
        session     = pSession;
    }

    @Override
    public BaseUserInfo get() {
        final AM_User user;
        if (session instanceof MockHttpSession) {
            user = new AM_User();
            user.setUserId(credentials.getUsername());
            user.setUserNm(credentials.getUsername());
            user.setSpecialUserKbn(C_SpecialUserKbn.TOKKEN);
        } else {
            if (credentials.getUsername() == null) {
                throw new IllegalStateException("No one logged in yet.");
            }
            user = domManager.getUser(credentials.getUsername());
            if (user == null) {
                throw new RuntimeException(
                    "AM_User not found. userId = " + StringUtil.quote(credentials.getUsername())
                );
            }
        }
        logger.trace("◇ UserProvider.get() : user = {}", user);
        return new BaseUserInfo(user);
    }

}
