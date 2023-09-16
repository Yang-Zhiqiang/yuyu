package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_ZennouSeisanSyoriKbn;

/**
 * {@link C_ZennouSeisanSyoriKbn 前納精算処理区分} の Hibernate ユーザー定義型です。<br />
 * 前納精算処理区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_ZennouSeisanSyoriKbn extends AbstractUserType<C_ZennouSeisanSyoriKbn> {

    @Override
    protected Class<C_ZennouSeisanSyoriKbn> returnType() {
        return C_ZennouSeisanSyoriKbn.class;
    }

    @Override
    protected C_ZennouSeisanSyoriKbn valueOf(String pValue) {
        return C_ZennouSeisanSyoriKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_ZennouSeisanSyoriKbn pValue) {
        return pValue.getValue();
    }
}
