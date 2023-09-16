package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_TtdktyuuiKbn;

/**
 * {@link C_TtdktyuuiKbn 手続注意区分} の Hibernate ユーザー定義型です。<br />
 * 手続注意区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_TtdktyuuiKbn extends AbstractUserType<C_TtdktyuuiKbn> {

    @Override
    protected Class<C_TtdktyuuiKbn> returnType() {
        return C_TtdktyuuiKbn.class;
    }

    @Override
    protected C_TtdktyuuiKbn valueOf(String pValue) {
        return C_TtdktyuuiKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_TtdktyuuiKbn pValue) {
        return pValue.getValue();
    }
}
