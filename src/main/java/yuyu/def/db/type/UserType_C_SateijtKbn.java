package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_SateijtKbn;

/**
 * {@link C_SateijtKbn 査定状態区分} の Hibernate ユーザー定義型です。<br />
 * 査定状態区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_SateijtKbn extends AbstractUserType<C_SateijtKbn> {

    @Override
    protected Class<C_SateijtKbn> returnType() {
        return C_SateijtKbn.class;
    }

    @Override
    protected C_SateijtKbn valueOf(String pValue) {
        return C_SateijtKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_SateijtKbn pValue) {
        return pValue.getValue();
    }
}
