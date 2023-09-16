package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_TkjyKbn;

/**
 * {@link C_TkjyKbn 特条区分} の Hibernate ユーザー定義型です。<br />
 * 特条区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_TkjyKbn extends AbstractUserType<C_TkjyKbn> {

    @Override
    protected Class<C_TkjyKbn> returnType() {
        return C_TkjyKbn.class;
    }

    @Override
    protected C_TkjyKbn valueOf(String pValue) {
        return C_TkjyKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_TkjyKbn pValue) {
        return pValue.getValue();
    }
}
