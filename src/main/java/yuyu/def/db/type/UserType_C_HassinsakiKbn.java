package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_HassinsakiKbn;

/**
 * {@link C_HassinsakiKbn 発信先区分} の Hibernate ユーザー定義型です。<br />
 * 発信先区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_HassinsakiKbn extends AbstractUserType<C_HassinsakiKbn> {

    @Override
    protected Class<C_HassinsakiKbn> returnType() {
        return C_HassinsakiKbn.class;
    }

    @Override
    protected C_HassinsakiKbn valueOf(String pValue) {
        return C_HassinsakiKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_HassinsakiKbn pValue) {
        return pValue.getValue();
    }
}
