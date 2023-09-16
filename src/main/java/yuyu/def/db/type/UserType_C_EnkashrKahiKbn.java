package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_EnkashrKahiKbn;

/**
 * {@link C_EnkashrKahiKbn 円貨支払可否区分} の Hibernate ユーザー定義型です。<br />
 * 円貨支払可否区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_EnkashrKahiKbn extends AbstractUserType<C_EnkashrKahiKbn> {

    @Override
    protected Class<C_EnkashrKahiKbn> returnType() {
        return C_EnkashrKahiKbn.class;
    }

    @Override
    protected C_EnkashrKahiKbn valueOf(String pValue) {
        return C_EnkashrKahiKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_EnkashrKahiKbn pValue) {
        return pValue.getValue();
    }
}
