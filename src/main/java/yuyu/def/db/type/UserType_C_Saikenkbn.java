package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_Saikenkbn;

/**
 * {@link C_Saikenkbn 債権区分} の Hibernate ユーザー定義型です。<br />
 * 債権区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_Saikenkbn extends AbstractUserType<C_Saikenkbn> {

    @Override
    protected Class<C_Saikenkbn> returnType() {
        return C_Saikenkbn.class;
    }

    @Override
    protected C_Saikenkbn valueOf(String pValue) {
        return C_Saikenkbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_Saikenkbn pValue) {
        return pValue.getValue();
    }
}
