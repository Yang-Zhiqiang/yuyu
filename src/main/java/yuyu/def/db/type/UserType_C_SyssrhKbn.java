package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_SyssrhKbn;

/**
 * {@link C_SyssrhKbn システム成立保留区分} の Hibernate ユーザー定義型です。<br />
 * システム成立保留区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_SyssrhKbn extends AbstractUserType<C_SyssrhKbn> {

    @Override
    protected Class<C_SyssrhKbn> returnType() {
        return C_SyssrhKbn.class;
    }

    @Override
    protected C_SyssrhKbn valueOf(String pValue) {
        return C_SyssrhKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_SyssrhKbn pValue) {
        return pValue.getValue();
    }
}
