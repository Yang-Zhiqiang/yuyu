package yuyu.app.base.system.usertouroku;

import com.google.common.base.Function;

/**
 * ロール情報単純ソート処理用クラス
 */
public class RoleEntitySortFunction implements Function<RoleInfoDataSourceBean, String>{

    @Override
    public String apply(RoleInfoDataSourceBean  pRoleInfoDataSourceBean) {
        return pRoleInfoDataSourceBean.getRoleCd();
    }

}
