package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_TknzkKbn;

/**
 * {@link C_TknzkKbn 特約除き区分} の Hibernate ユーザー定義型です。<br />
 * 特約除き区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_TknzkKbn extends AbstractUserType<C_TknzkKbn> {

    @Override
    protected Class<C_TknzkKbn> returnType() {
        return C_TknzkKbn.class;
    }

    @Override
    protected C_TknzkKbn valueOf(String pValue) {
        return C_TknzkKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_TknzkKbn pValue) {
        return pValue.getValue();
    }
}
