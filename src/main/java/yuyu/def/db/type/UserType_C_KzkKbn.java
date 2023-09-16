package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_KzkKbn;

/**
 * {@link C_KzkKbn 継続区分} の Hibernate ユーザー定義型です。<br />
 * 継続区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_KzkKbn extends AbstractUserType<C_KzkKbn> {

    @Override
    protected Class<C_KzkKbn> returnType() {
        return C_KzkKbn.class;
    }

    @Override
    protected C_KzkKbn valueOf(String pValue) {
        return C_KzkKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_KzkKbn pValue) {
        return pValue.getValue();
    }
}
