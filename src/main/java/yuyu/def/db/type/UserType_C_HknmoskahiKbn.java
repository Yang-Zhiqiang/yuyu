package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_HknmoskahiKbn;

/**
 * {@link C_HknmoskahiKbn 保険申込可否区分} の Hibernate ユーザー定義型です。<br />
 * 保険申込可否区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_HknmoskahiKbn extends AbstractUserType<C_HknmoskahiKbn> {

    @Override
    protected Class<C_HknmoskahiKbn> returnType() {
        return C_HknmoskahiKbn.class;
    }

    @Override
    protected C_HknmoskahiKbn valueOf(String pValue) {
        return C_HknmoskahiKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_HknmoskahiKbn pValue) {
        return pValue.getValue();
    }
}
