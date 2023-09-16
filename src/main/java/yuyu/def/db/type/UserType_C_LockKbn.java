package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_LockKbn;

/**
 * {@link C_LockKbn ロック区分} の Hibernate ユーザー定義型です。<br />
 * ロック区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_LockKbn extends AbstractUserType<C_LockKbn> {

    @Override
    protected Class<C_LockKbn> returnType() {
        return C_LockKbn.class;
    }

    @Override
    protected C_LockKbn valueOf(String pValue) {
        return C_LockKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_LockKbn pValue) {
        return pValue.getValue();
    }
}
