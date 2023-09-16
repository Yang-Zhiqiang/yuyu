package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_CreditkaisyaKbn;

/**
 * {@link C_CreditkaisyaKbn クレジット会社区分} の Hibernate ユーザー定義型です。<br />
 * クレジット会社区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_CreditkaisyaKbn extends AbstractUserType<C_CreditkaisyaKbn> {

    @Override
    protected Class<C_CreditkaisyaKbn> returnType() {
        return C_CreditkaisyaKbn.class;
    }

    @Override
    protected C_CreditkaisyaKbn valueOf(String pValue) {
        return C_CreditkaisyaKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_CreditkaisyaKbn pValue) {
        return pValue.getValue();
    }
}
