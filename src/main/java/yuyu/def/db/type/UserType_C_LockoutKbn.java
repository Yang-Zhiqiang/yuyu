package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_LockoutKbn;

/**
 * {@link C_LockoutKbn ロックアウト区分} の Hibernate ユーザー定義型です。<br />
 * ロックアウト区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_LockoutKbn extends AbstractUserType<C_LockoutKbn> {

    @Override
    protected Class<C_LockoutKbn> returnType() {
        return C_LockoutKbn.class;
    }

    @Override
    protected C_LockoutKbn valueOf(String pValue) {
        return C_LockoutKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_LockoutKbn pValue) {
        return pValue.getValue();
    }
}
