package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_ZenhnknKbn;

/**
 * {@link C_ZenhnknKbn 全額返金区分} の Hibernate ユーザー定義型です。<br />
 * 全額返金区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_ZenhnknKbn extends AbstractUserType<C_ZenhnknKbn> {

    @Override
    protected Class<C_ZenhnknKbn> returnType() {
        return C_ZenhnknKbn.class;
    }

    @Override
    protected C_ZenhnknKbn valueOf(String pValue) {
        return C_ZenhnknKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_ZenhnknKbn pValue) {
        return pValue.getValue();
    }
}
