package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_SnzkdsnnrKbn;

/**
 * {@link C_SnzkdsnnrKbn 専属代申乗合区分} の Hibernate ユーザー定義型です。<br />
 * 専属代申乗合区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_SnzkdsnnrKbn extends AbstractUserType<C_SnzkdsnnrKbn> {

    @Override
    protected Class<C_SnzkdsnnrKbn> returnType() {
        return C_SnzkdsnnrKbn.class;
    }

    @Override
    protected C_SnzkdsnnrKbn valueOf(String pValue) {
        return C_SnzkdsnnrKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_SnzkdsnnrKbn pValue) {
        return pValue.getValue();
    }
}
