package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_CreditcardHrKskmKbn;

/**
 * {@link C_CreditcardHrKskmKbn クレ払消込区分} の Hibernate ユーザー定義型です。<br />
 * クレ払消込区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_CreditcardHrKskmKbn extends AbstractUserType<C_CreditcardHrKskmKbn> {

    @Override
    protected Class<C_CreditcardHrKskmKbn> returnType() {
        return C_CreditcardHrKskmKbn.class;
    }

    @Override
    protected C_CreditcardHrKskmKbn valueOf(String pValue) {
        return C_CreditcardHrKskmKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_CreditcardHrKskmKbn pValue) {
        return pValue.getValue();
    }
}
