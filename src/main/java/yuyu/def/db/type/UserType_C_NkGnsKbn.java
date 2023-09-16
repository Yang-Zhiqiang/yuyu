package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_NkGnsKbn;

/**
 * {@link C_NkGnsKbn 年金原資区分} の Hibernate ユーザー定義型です。<br />
 * 年金原資区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_NkGnsKbn extends AbstractUserType<C_NkGnsKbn> {

    @Override
    protected Class<C_NkGnsKbn> returnType() {
        return C_NkGnsKbn.class;
    }

    @Override
    protected C_NkGnsKbn valueOf(String pValue) {
        return C_NkGnsKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_NkGnsKbn pValue) {
        return pValue.getValue();
    }
}
