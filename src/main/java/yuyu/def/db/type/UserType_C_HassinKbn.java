package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_HassinKbn;

/**
 * {@link C_HassinKbn 発信区分} の Hibernate ユーザー定義型です。<br />
 * 発信区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_HassinKbn extends AbstractUserType<C_HassinKbn> {

    @Override
    protected Class<C_HassinKbn> returnType() {
        return C_HassinKbn.class;
    }

    @Override
    protected C_HassinKbn valueOf(String pValue) {
        return C_HassinKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_HassinKbn pValue) {
        return pValue.getValue();
    }
}
