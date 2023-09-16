package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_PjyutojyotaiKbn;

/**
 * {@link C_PjyutojyotaiKbn Ｐ充当状態区分} の Hibernate ユーザー定義型です。<br />
 * Ｐ充当状態区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_PjyutojyotaiKbn extends AbstractUserType<C_PjyutojyotaiKbn> {

    @Override
    protected Class<C_PjyutojyotaiKbn> returnType() {
        return C_PjyutojyotaiKbn.class;
    }

    @Override
    protected C_PjyutojyotaiKbn valueOf(String pValue) {
        return C_PjyutojyotaiKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_PjyutojyotaiKbn pValue) {
        return pValue.getValue();
    }
}
