package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_SbjiShrKbn;

/**
 * {@link C_SbjiShrKbn 死亡時支払区分} の Hibernate ユーザー定義型です。<br />
 * 死亡時支払区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_SbjiShrKbn extends AbstractUserType<C_SbjiShrKbn> {

    @Override
    protected Class<C_SbjiShrKbn> returnType() {
        return C_SbjiShrKbn.class;
    }

    @Override
    protected C_SbjiShrKbn valueOf(String pValue) {
        return C_SbjiShrKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_SbjiShrKbn pValue) {
        return pValue.getValue();
    }
}
