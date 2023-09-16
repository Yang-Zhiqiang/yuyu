package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_BanktrktaisyouKbn;

/**
 * {@link C_BanktrktaisyouKbn 銀行登録対象区分} の Hibernate ユーザー定義型です。<br />
 * 銀行登録対象区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_BanktrktaisyouKbn extends AbstractUserType<C_BanktrktaisyouKbn> {

    @Override
    protected Class<C_BanktrktaisyouKbn> returnType() {
        return C_BanktrktaisyouKbn.class;
    }

    @Override
    protected C_BanktrktaisyouKbn valueOf(String pValue) {
        return C_BanktrktaisyouKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_BanktrktaisyouKbn pValue) {
        return pValue.getValue();
    }
}
