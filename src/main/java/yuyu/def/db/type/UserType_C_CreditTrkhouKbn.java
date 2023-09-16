package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_CreditTrkhouKbn;

/**
 * {@link C_CreditTrkhouKbn クレジットカード登録方法区分} の Hibernate ユーザー定義型です。<br />
 * クレジットカード登録方法区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_CreditTrkhouKbn extends AbstractUserType<C_CreditTrkhouKbn> {

    @Override
    protected Class<C_CreditTrkhouKbn> returnType() {
        return C_CreditTrkhouKbn.class;
    }

    @Override
    protected C_CreditTrkhouKbn valueOf(String pValue) {
        return C_CreditTrkhouKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_CreditTrkhouKbn pValue) {
        return pValue.getValue();
    }
}
