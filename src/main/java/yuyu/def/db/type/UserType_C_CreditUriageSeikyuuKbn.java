package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_CreditUriageSeikyuuKbn;

/**
 * {@link C_CreditUriageSeikyuuKbn クレジットカード売上請求区分} の Hibernate ユーザー定義型です。<br />
 * クレジットカード売上請求区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_CreditUriageSeikyuuKbn extends AbstractUserType<C_CreditUriageSeikyuuKbn> {

    @Override
    protected Class<C_CreditUriageSeikyuuKbn> returnType() {
        return C_CreditUriageSeikyuuKbn.class;
    }

    @Override
    protected C_CreditUriageSeikyuuKbn valueOf(String pValue) {
        return C_CreditUriageSeikyuuKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_CreditUriageSeikyuuKbn pValue) {
        return pValue.getValue();
    }
}
