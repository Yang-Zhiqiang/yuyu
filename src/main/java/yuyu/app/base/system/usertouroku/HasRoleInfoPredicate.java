package yuyu.app.base.system.usertouroku;

import java.util.List;
import java.util.Set;

import yuyu.def.db.entity.AT_UserRole;

import com.google.common.base.Predicate;
import com.google.common.collect.Sets;

/**
 * 保有済みロールリストを内部に保持し、そのリストに一致するロールコードを持つ<br />
 * ロール情報ビーンを抽出するための Predicate クラスです。<br />
 * チェックフラグにFalseが渡された場合、不一致ビーンの抽出を行います。
 */
public class HasRoleInfoPredicate implements Predicate<RoleInfoDataSourceBean> {

    Set<String> hasRoleCodeSet;

    public HasRoleInfoPredicate(List<AT_UserRole> pAT_UserRoles){

        super();

        hasRoleCodeSet = Sets.newHashSet();

        for(AT_UserRole role:pAT_UserRoles){
            hasRoleCodeSet.add(role.getRoleCd());
        }

    }

    @Override
    public boolean apply(RoleInfoDataSourceBean arg0) {

        return hasRoleCodeSet.contains(arg0.getRoleCd());
    }
}
