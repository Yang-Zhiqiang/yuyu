package yuyu.app.base.system.rolekensaku;

import yuyu.def.classification.C_SysSiyouKbn;
import yuyu.def.db.entity.AM_Role;

import com.google.common.base.Predicate;

/**
 * 検索条件に合致するロールエンティティを抽出するためのPredicate クラスです。<br />
 */
public class RoleEntityPredicate implements Predicate<AM_Role> {

    private String roleCdCondition;
    private String roleNmCondition;

    public RoleEntityPredicate(String pRoleCd, String pRoleNm) {

        this.roleCdCondition = pRoleCd;
        this.roleNmCondition = pRoleNm;
    }

    @Override
    public boolean apply(AM_Role role) {

        String roleCd = role.getRoleCd();
        String roleNm = role.getRoleNm();

        if (C_SysSiyouKbn.SYSSIYOU.eq(role.getSysSiyouKbn())) {
            return false;
        }

        if (this.roleCdCondition != null && this.roleCdCondition.length() > 0) {

            if (!roleCd.startsWith(this.roleCdCondition)) {
                return false;
            }
        }

        if (this.roleNmCondition != null && this.roleNmCondition.length() > 0) {

            if (roleNm.indexOf(this.roleNmCondition) == -1) {
                return false;
            }
        }
        return true;
    }
}
