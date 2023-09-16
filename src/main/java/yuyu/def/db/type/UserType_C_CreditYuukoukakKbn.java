package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_CreditYuukoukakKbn;

/**
 * {@link C_CreditYuukoukakKbn クレジットカード有効確認区分} の Hibernate ユーザー定義型です。<br />
 * クレジットカード有効確認区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_CreditYuukoukakKbn extends AbstractUserType<C_CreditYuukoukakKbn> {

    @Override
    protected Class<C_CreditYuukoukakKbn> returnType() {
        return C_CreditYuukoukakKbn.class;
    }

    @Override
    protected C_CreditYuukoukakKbn valueOf(String pValue) {
        return C_CreditYuukoukakKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_CreditYuukoukakKbn pValue) {
        return pValue.getValue();
    }
}
