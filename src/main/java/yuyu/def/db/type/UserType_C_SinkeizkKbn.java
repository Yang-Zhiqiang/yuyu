package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_SinkeizkKbn;

/**
 * {@link C_SinkeizkKbn 新規継続区分} の Hibernate ユーザー定義型です。<br />
 * 新規継続区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_SinkeizkKbn extends AbstractUserType<C_SinkeizkKbn> {

    @Override
    protected Class<C_SinkeizkKbn> returnType() {
        return C_SinkeizkKbn.class;
    }

    @Override
    protected C_SinkeizkKbn valueOf(String pValue) {
        return C_SinkeizkKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_SinkeizkKbn pValue) {
        return pValue.getValue();
    }
}
