package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_TapekoukanKbn;

/**
 * {@link C_TapekoukanKbn テープ交換区分} の Hibernate ユーザー定義型です。<br />
 * テープ交換区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_TapekoukanKbn extends AbstractUserType<C_TapekoukanKbn> {

    @Override
    protected Class<C_TapekoukanKbn> returnType() {
        return C_TapekoukanKbn.class;
    }

    @Override
    protected C_TapekoukanKbn valueOf(String pValue) {
        return C_TapekoukanKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_TapekoukanKbn pValue) {
        return pValue.getValue();
    }
}
