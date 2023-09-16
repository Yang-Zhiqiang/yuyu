package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_HandketsijiKbn;

/**
 * {@link C_HandketsijiKbn ハンド決定指示区分} の Hibernate ユーザー定義型です。<br />
 * ハンド決定指示区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_HandketsijiKbn extends AbstractUserType<C_HandketsijiKbn> {

    @Override
    protected Class<C_HandketsijiKbn> returnType() {
        return C_HandketsijiKbn.class;
    }

    @Override
    protected C_HandketsijiKbn valueOf(String pValue) {
        return C_HandketsijiKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_HandketsijiKbn pValue) {
        return pValue.getValue();
    }
}
