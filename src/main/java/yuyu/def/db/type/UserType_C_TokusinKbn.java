package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_TokusinKbn;

/**
 * {@link C_TokusinKbn 特伸区分} の Hibernate ユーザー定義型です。<br />
 * 特伸区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_TokusinKbn extends AbstractUserType<C_TokusinKbn> {

    @Override
    protected Class<C_TokusinKbn> returnType() {
        return C_TokusinKbn.class;
    }

    @Override
    protected C_TokusinKbn valueOf(String pValue) {
        return C_TokusinKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_TokusinKbn pValue) {
        return pValue.getValue();
    }
}
