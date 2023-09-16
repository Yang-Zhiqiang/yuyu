package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_HnknKbn;

/**
 * {@link C_HnknKbn 返金区分} の Hibernate ユーザー定義型です。<br />
 * 返金区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_HnknKbn extends AbstractUserType<C_HnknKbn> {

    @Override
    protected Class<C_HnknKbn> returnType() {
        return C_HnknKbn.class;
    }

    @Override
    protected C_HnknKbn valueOf(String pValue) {
        return C_HnknKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_HnknKbn pValue) {
        return pValue.getValue();
    }
}
