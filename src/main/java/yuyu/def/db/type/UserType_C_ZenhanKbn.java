package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_ZenhanKbn;

/**
 * {@link C_ZenhanKbn 全半角区分} の Hibernate ユーザー定義型です。<br />
 * 全半角区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_ZenhanKbn extends AbstractUserType<C_ZenhanKbn> {

    @Override
    protected Class<C_ZenhanKbn> returnType() {
        return C_ZenhanKbn.class;
    }

    @Override
    protected C_ZenhanKbn valueOf(String pValue) {
        return C_ZenhanKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_ZenhanKbn pValue) {
        return pValue.getValue();
    }
}
