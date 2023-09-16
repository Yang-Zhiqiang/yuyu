package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_NykKbn;

/**
 * {@link C_NykKbn 入金区分} の Hibernate ユーザー定義型です。<br />
 * 入金区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_NykKbn extends AbstractUserType<C_NykKbn> {

    @Override
    protected Class<C_NykKbn> returnType() {
        return C_NykKbn.class;
    }

    @Override
    protected C_NykKbn valueOf(String pValue) {
        return C_NykKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_NykKbn pValue) {
        return pValue.getValue();
    }
}
