package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_CreditCardKeySyuruiKbn;

/**
 * {@link C_CreditCardKeySyuruiKbn クレジットカードキー種類区分} の Hibernate ユーザー定義型です。<br />
 * クレジットカードキー種類区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_CreditCardKeySyuruiKbn extends AbstractUserType<C_CreditCardKeySyuruiKbn> {

    @Override
    protected Class<C_CreditCardKeySyuruiKbn> returnType() {
        return C_CreditCardKeySyuruiKbn.class;
    }

    @Override
    protected C_CreditCardKeySyuruiKbn valueOf(String pValue) {
        return C_CreditCardKeySyuruiKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_CreditCardKeySyuruiKbn pValue) {
        return pValue.getValue();
    }
}
