package yuyu.app.base.system.usertouroku;

import yuyu.def.classification.C_SysSiyouKbn;
import yuyu.def.db.entity.AM_Role;

import com.google.common.base.Predicate;

/**
 * 条件に合致するロールエンティティを抽出するためのPredicate クラスです。<br />
 * システムロールが含まれる場合は除外します。<br />
 */
public class RoleEntityPredicate implements Predicate<AM_Role> {

    public RoleEntityPredicate() {
    }

    @Override
    public boolean apply(AM_Role role) {
        if (C_SysSiyouKbn.SYSSIYOU.eq(role.getSysSiyouKbn())) {
            return false;
        }
        return true;
    }
}