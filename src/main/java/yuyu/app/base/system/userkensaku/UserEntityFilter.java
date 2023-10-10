package yuyu.app.base.system.userkensaku;

import yuyu.def.classification.C_SysSiyouKbn;
import yuyu.def.db.entity.AM_User;
import yuyu.def.db.entity.AT_UserRole;

import com.google.common.base.Predicate;

/**
 * 条件に合致するユーザーエンティティを抽出するためのPredicate クラスです。<br />
 * ユーザーに紐づくユーザーロールに、システムロールが含まれる場合は除外します。<br />
 */
public class UserEntityFilter implements Predicate<AM_User> {

    public UserEntityFilter() {
    }

    @Override
    public boolean apply(AM_User user) {

        for (AT_UserRole userRole : user.getUserRoles()) {
            if (C_SysSiyouKbn.SYSSIYOU.eq( userRole.getRole().getSysSiyouKbn())) {
                return false;
            }
        }
        return true;
    }
}
