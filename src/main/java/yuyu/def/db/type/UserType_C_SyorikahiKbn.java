package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_SyorikahiKbn;

/**
 * {@link C_SyorikahiKbn 処理可否区分} の Hibernate ユーザー定義型です。<br />
 * 処理可否区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_SyorikahiKbn extends AbstractUserType<C_SyorikahiKbn> {

    @Override
    protected Class<C_SyorikahiKbn> returnType() {
        return C_SyorikahiKbn.class;
    }

    @Override
    protected C_SyorikahiKbn valueOf(String pValue) {
        return C_SyorikahiKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_SyorikahiKbn pValue) {
        return pValue.getValue();
    }
}
