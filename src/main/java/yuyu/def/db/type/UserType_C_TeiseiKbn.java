package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_TeiseiKbn;

/**
 * {@link C_TeiseiKbn 訂正区分} の Hibernate ユーザー定義型です。<br />
 * 訂正区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_TeiseiKbn extends AbstractUserType<C_TeiseiKbn> {

    @Override
    protected Class<C_TeiseiKbn> returnType() {
        return C_TeiseiKbn.class;
    }

    @Override
    protected C_TeiseiKbn valueOf(String pValue) {
        return C_TeiseiKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_TeiseiKbn pValue) {
        return pValue.getValue();
    }
}
