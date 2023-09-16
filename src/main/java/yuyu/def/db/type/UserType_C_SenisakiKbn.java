package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_SenisakiKbn;

/**
 * {@link C_SenisakiKbn 遷移先区分} の Hibernate ユーザー定義型です。<br />
 * 遷移先区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_SenisakiKbn extends AbstractUserType<C_SenisakiKbn> {

    @Override
    protected Class<C_SenisakiKbn> returnType() {
        return C_SenisakiKbn.class;
    }

    @Override
    protected C_SenisakiKbn valueOf(String pValue) {
        return C_SenisakiKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_SenisakiKbn pValue) {
        return pValue.getValue();
    }
}
