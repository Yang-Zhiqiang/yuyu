package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_TorikomiKbn;

/**
 * {@link C_TorikomiKbn 取込区分} の Hibernate ユーザー定義型です。<br />
 * 取込区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_TorikomiKbn extends AbstractUserType<C_TorikomiKbn> {

    @Override
    protected Class<C_TorikomiKbn> returnType() {
        return C_TorikomiKbn.class;
    }

    @Override
    protected C_TorikomiKbn valueOf(String pValue) {
        return C_TorikomiKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_TorikomiKbn pValue) {
        return pValue.getValue();
    }
}
