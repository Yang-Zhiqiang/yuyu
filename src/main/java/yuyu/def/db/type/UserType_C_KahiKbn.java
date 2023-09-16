package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_KahiKbn;

/**
 * {@link C_KahiKbn 可否区分} の Hibernate ユーザー定義型です。<br />
 * 可否区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_KahiKbn extends AbstractUserType<C_KahiKbn> {

    @Override
    protected Class<C_KahiKbn> returnType() {
        return C_KahiKbn.class;
    }

    @Override
    protected C_KahiKbn valueOf(String pValue) {
        return C_KahiKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_KahiKbn pValue) {
        return pValue.getValue();
    }
}
