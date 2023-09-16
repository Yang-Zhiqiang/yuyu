package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_ShrtaisyouKbn;

/**
 * {@link C_ShrtaisyouKbn 支払対象区分} の Hibernate ユーザー定義型です。<br />
 * 支払対象区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_ShrtaisyouKbn extends AbstractUserType<C_ShrtaisyouKbn> {

    @Override
    protected Class<C_ShrtaisyouKbn> returnType() {
        return C_ShrtaisyouKbn.class;
    }

    @Override
    protected C_ShrtaisyouKbn valueOf(String pValue) {
        return C_ShrtaisyouKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_ShrtaisyouKbn pValue) {
        return pValue.getValue();
    }
}
