package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_PasswordJtKbn;

/**
 * {@link C_PasswordJtKbn パスワード状態区分} の Hibernate ユーザー定義型です。<br />
 * パスワード状態区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_PasswordJtKbn extends AbstractUserType<C_PasswordJtKbn> {

    @Override
    protected Class<C_PasswordJtKbn> returnType() {
        return C_PasswordJtKbn.class;
    }

    @Override
    protected C_PasswordJtKbn valueOf(String pValue) {
        return C_PasswordJtKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_PasswordJtKbn pValue) {
        return pValue.getValue();
    }
}
