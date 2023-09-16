package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_SntkhouKbn;

/**
 * {@link C_SntkhouKbn 選択方法区分} の Hibernate ユーザー定義型です。<br />
 * 選択方法区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_SntkhouKbn extends AbstractUserType<C_SntkhouKbn> {

    @Override
    protected Class<C_SntkhouKbn> returnType() {
        return C_SntkhouKbn.class;
    }

    @Override
    protected C_SntkhouKbn valueOf(String pValue) {
        return C_SntkhouKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_SntkhouKbn pValue) {
        return pValue.getValue();
    }
}
