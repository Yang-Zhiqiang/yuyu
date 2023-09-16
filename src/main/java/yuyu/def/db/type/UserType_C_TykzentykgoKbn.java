package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_TykzentykgoKbn;

/**
 * {@link C_TykzentykgoKbn 直前直後区分} の Hibernate ユーザー定義型です。<br />
 * 直前直後区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_TykzentykgoKbn extends AbstractUserType<C_TykzentykgoKbn> {

    @Override
    protected Class<C_TykzentykgoKbn> returnType() {
        return C_TykzentykgoKbn.class;
    }

    @Override
    protected C_TykzentykgoKbn valueOf(String pValue) {
        return C_TykzentykgoKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_TykzentykgoKbn pValue) {
        return pValue.getValue();
    }
}
