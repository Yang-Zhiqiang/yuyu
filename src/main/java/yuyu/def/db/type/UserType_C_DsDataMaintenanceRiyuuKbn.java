package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_DsDataMaintenanceRiyuuKbn;

/**
 * {@link C_DsDataMaintenanceRiyuuKbn ＤＳデータメンテナンス理由区分} の Hibernate ユーザー定義型です。<br />
 * ＤＳデータメンテナンス理由区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_DsDataMaintenanceRiyuuKbn extends AbstractUserType<C_DsDataMaintenanceRiyuuKbn> {

    @Override
    protected Class<C_DsDataMaintenanceRiyuuKbn> returnType() {
        return C_DsDataMaintenanceRiyuuKbn.class;
    }

    @Override
    protected C_DsDataMaintenanceRiyuuKbn valueOf(String pValue) {
        return C_DsDataMaintenanceRiyuuKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_DsDataMaintenanceRiyuuKbn pValue) {
        return pValue.getValue();
    }
}
