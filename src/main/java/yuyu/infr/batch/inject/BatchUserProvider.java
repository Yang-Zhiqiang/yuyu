package yuyu.infr.batch.inject;

import javax.inject.Inject;
import javax.inject.Provider;

import jp.co.slcs.swak.auth.Credentials;
import yuyu.common.base.BaseUserInfo;
import yuyu.def.base.manager.BaseDomManager;
import yuyu.def.classification.C_KyokaKbn;
import yuyu.def.classification.C_SpecialUserKbn;
import yuyu.def.db.entity.AM_User;

import com.google.common.base.Optional;
import com.google.common.base.Supplier;

/**
 * バッチ機能用の {@link BaseUserInfo} プロバイダです。
 */
public class BatchUserProvider implements Provider<BaseUserInfo> {

            final Credentials    credentials;
    private final BaseDomManager domManager;

    @Deprecated
    @Inject
    public BatchUserProvider(Credentials pCredentials, BaseDomManager pDomManager) {
        credentials = pCredentials;
        domManager  = pDomManager;
    }

    @Override
    public BaseUserInfo get() {
        if (credentials.getUsername() == null) {
            throw new IllegalStateException("No one logged in yet.");
        }
        return new BaseUserInfo(
            Optional
              .fromNullable(domManager.getDetachedUser(credentials.getUsername()))
              .or(new Supplier<AM_User>() {
                @Override
                public AM_User get() {
                    AM_User user = new AM_User(credentials.getUsername());
                    user.setUserNm("※ AM_User に未登録のユーザーです。");
                    user.setSpecialUserKbn(C_SpecialUserKbn.IPPAN);
                    user.setLoginKyokaKbn(C_KyokaKbn.NONE);
                    return user;
                }
              })
        );
    }

}
