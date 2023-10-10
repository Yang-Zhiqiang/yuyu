package yuyu.app.base.system.kinouteigitouroku;

import yuyu.def.classification.C_SysSiyouKbn;
import yuyu.def.db.entity.AM_Role;

import com.google.common.base.Predicate;

/**
 * 条件に合致するロールエンティティを抽出するためのPredicate クラスです。<br />
 * システムロールでない場合は除外します。<br />
 */
public class SystemRoleFilter implements Predicate<AM_Role> {

    public SystemRoleFilter() {
    }

    @Override
    public boolean apply(AM_Role role) {
        if (!C_SysSiyouKbn.SYSSIYOU.eq(role.getSysSiyouKbn())) {
            return false;
        }
        return true;
    }
}