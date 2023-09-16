package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_TyksenhokanhouKbn;

/**
 * {@link C_TyksenhokanhouKbn 直線補間方法区分} の Hibernate ユーザー定義型です。<br />
 * 直線補間方法区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_TyksenhokanhouKbn extends AbstractUserType<C_TyksenhokanhouKbn> {

    @Override
    protected Class<C_TyksenhokanhouKbn> returnType() {
        return C_TyksenhokanhouKbn.class;
    }

    @Override
    protected C_TyksenhokanhouKbn valueOf(String pValue) {
        return C_TyksenhokanhouKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_TyksenhokanhouKbn pValue) {
        return pValue.getValue();
    }
}
