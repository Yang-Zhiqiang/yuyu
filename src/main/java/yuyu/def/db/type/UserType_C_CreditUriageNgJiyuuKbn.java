package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_CreditUriageNgJiyuuKbn;

/**
 * {@link C_CreditUriageNgJiyuuKbn クレジットカード売上請求ＮＧ事由区分} の Hibernate ユーザー定義型です。<br />
 * クレジットカード売上請求ＮＧ事由区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_CreditUriageNgJiyuuKbn extends AbstractUserType<C_CreditUriageNgJiyuuKbn> {

    @Override
    protected Class<C_CreditUriageNgJiyuuKbn> returnType() {
        return C_CreditUriageNgJiyuuKbn.class;
    }

    @Override
    protected C_CreditUriageNgJiyuuKbn valueOf(String pValue) {
        return C_CreditUriageNgJiyuuKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_CreditUriageNgJiyuuKbn pValue) {
        return pValue.getValue();
    }
}
