package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_BankYuuksHantKbn;

/**
 * {@link C_BankYuuksHantKbn 銀行有効性判定区分} の Hibernate ユーザー定義型です。<br />
 * 銀行有効性判定区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_BankYuuksHantKbn extends AbstractUserType<C_BankYuuksHantKbn> {

    @Override
    protected Class<C_BankYuuksHantKbn> returnType() {
        return C_BankYuuksHantKbn.class;
    }

    @Override
    protected C_BankYuuksHantKbn valueOf(String pValue) {
        return C_BankYuuksHantKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_BankYuuksHantKbn pValue) {
        return pValue.getValue();
    }
}
