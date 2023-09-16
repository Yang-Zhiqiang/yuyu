package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_ItijiketKbn;

/**
 * {@link C_ItijiketKbn １次決定区分} の Hibernate ユーザー定義型です。<br />
 * １次決定区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_ItijiketKbn extends AbstractUserType<C_ItijiketKbn> {

    @Override
    protected Class<C_ItijiketKbn> returnType() {
        return C_ItijiketKbn.class;
    }

    @Override
    protected C_ItijiketKbn valueOf(String pValue) {
        return C_ItijiketKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_ItijiketKbn pValue) {
        return pValue.getValue();
    }
}
