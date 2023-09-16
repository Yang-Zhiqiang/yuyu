package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_PasswordYuukouKikanKbn;

/**
 * {@link C_PasswordYuukouKikanKbn パスワード有効期間区分} の Hibernate ユーザー定義型です。<br />
 * パスワード有効期間区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_PasswordYuukouKikanKbn extends AbstractUserType<C_PasswordYuukouKikanKbn> {

    @Override
    protected Class<C_PasswordYuukouKikanKbn> returnType() {
        return C_PasswordYuukouKikanKbn.class;
    }

    @Override
    protected C_PasswordYuukouKikanKbn valueOf(String pValue) {
        return C_PasswordYuukouKikanKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_PasswordYuukouKikanKbn pValue) {
        return pValue.getValue();
    }
}
