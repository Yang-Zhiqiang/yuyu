package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_KjKbn;

/**
 * {@link C_KjKbn K・J区分} の Hibernate ユーザー定義型です。<br />
 * K・J区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_KjKbn extends AbstractUserType<C_KjKbn> {

    @Override
    protected Class<C_KjKbn> returnType() {
        return C_KjKbn.class;
    }

    @Override
    protected C_KjKbn valueOf(String pValue) {
        return C_KjKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_KjKbn pValue) {
        return pValue.getValue();
    }
}
