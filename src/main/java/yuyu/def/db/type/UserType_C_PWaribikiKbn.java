package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_PWaribikiKbn;

/**
 * {@link C_PWaribikiKbn 保険料割引区分} の Hibernate ユーザー定義型です。<br />
 * 保険料割引区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_PWaribikiKbn extends AbstractUserType<C_PWaribikiKbn> {

    @Override
    protected Class<C_PWaribikiKbn> returnType() {
        return C_PWaribikiKbn.class;
    }

    @Override
    protected C_PWaribikiKbn valueOf(String pValue) {
        return C_PWaribikiKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_PWaribikiKbn pValue) {
        return pValue.getValue();
    }
}
