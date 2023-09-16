package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_StaniKbn;

/**
 * {@link C_StaniKbn Ｓ単位区分} の Hibernate ユーザー定義型です。<br />
 * Ｓ単位区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_StaniKbn extends AbstractUserType<C_StaniKbn> {

    @Override
    protected Class<C_StaniKbn> returnType() {
        return C_StaniKbn.class;
    }

    @Override
    protected C_StaniKbn valueOf(String pValue) {
        return C_StaniKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_StaniKbn pValue) {
        return pValue.getValue();
    }
}
