package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_HasinkyokaKbn;

/**
 * {@link C_HasinkyokaKbn 発信許可区分} の Hibernate ユーザー定義型です。<br />
 * 発信許可区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_HasinkyokaKbn extends AbstractUserType<C_HasinkyokaKbn> {

    @Override
    protected Class<C_HasinkyokaKbn> returnType() {
        return C_HasinkyokaKbn.class;
    }

    @Override
    protected C_HasinkyokaKbn valueOf(String pValue) {
        return C_HasinkyokaKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_HasinkyokaKbn pValue) {
        return pValue.getValue();
    }
}
