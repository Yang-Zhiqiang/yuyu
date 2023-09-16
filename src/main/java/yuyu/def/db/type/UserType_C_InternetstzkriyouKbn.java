package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_InternetstzkriyouKbn;

/**
 * {@link C_InternetstzkriyouKbn インターネット接続利用区分} の Hibernate ユーザー定義型です。<br />
 * インターネット接続利用区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_InternetstzkriyouKbn extends AbstractUserType<C_InternetstzkriyouKbn> {

    @Override
    protected Class<C_InternetstzkriyouKbn> returnType() {
        return C_InternetstzkriyouKbn.class;
    }

    @Override
    protected C_InternetstzkriyouKbn valueOf(String pValue) {
        return C_InternetstzkriyouKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_InternetstzkriyouKbn pValue) {
        return pValue.getValue();
    }
}
