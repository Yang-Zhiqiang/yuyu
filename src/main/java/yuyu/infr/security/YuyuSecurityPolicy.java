package yuyu.infr.security;

import java.util.Collections;
import java.util.List;

import javax.inject.Inject;

import jp.co.slcs.swak.util.security.SecurityPolicy;
import yuyu.def.base.manager.BaseDomManager;
import yuyu.def.db.entity.AM_User;
import yuyu.def.db.entity.AT_PasswordRireki;

import com.google.common.base.Function;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Iterables;
import com.google.common.collect.Ordering;

/**
 * パスワードポリシーチェック基盤の実装クラスです。
 * アプリケーションに応じたパスワード履歴の取得メソッドの実装を行います。
 *
 */
public class YuyuSecurityPolicy extends SecurityPolicy {

    private final BaseDomManager manager;

    @Inject
    YuyuSecurityPolicy(BaseDomManager baseDomManager) {
        manager = baseDomManager;
    }

    protected static final Ordering<AT_PasswordRireki> passwordRirekiOrder =
        new Ordering<AT_PasswordRireki>() {
            @Override
            public int compare(AT_PasswordRireki left, AT_PasswordRireki right) {
                return left.getKousinTime().compareTo(right.getKousinTime());
            }
        };

    @Override
    protected List<String> getPasswordRireki(String userId) {

        final AM_User user = manager.getUser(userId);
        if (user == null) return Collections.emptyList();
        return ImmutableList.<String>builder()
            .add(user.getPassword())
            .addAll(
                Iterables.transform(
                    passwordRirekiOrder.reverse().immutableSortedCopy(user.getPasswordRirekis()),
                    new Function<AT_PasswordRireki, String>() {
                        @Override
                        public String apply(AT_PasswordRireki passwordRireki) {
                            return passwordRireki.getPassword();
                        }
                    }
                )
            ).build();

    }
}
