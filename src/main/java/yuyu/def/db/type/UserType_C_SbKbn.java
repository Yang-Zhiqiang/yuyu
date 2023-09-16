package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_SbKbn;

/**
 * {@link C_SbKbn 死亡区分} の Hibernate ユーザー定義型です。<br />
 * 死亡区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_SbKbn extends AbstractUserType<C_SbKbn> {

    @Override
    protected Class<C_SbKbn> returnType() {
        return C_SbKbn.class;
    }

    @Override
    protected C_SbKbn valueOf(String pValue) {
        return C_SbKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_SbKbn pValue) {
        return pValue.getValue();
    }
}
