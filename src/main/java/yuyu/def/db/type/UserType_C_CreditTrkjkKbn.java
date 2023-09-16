package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_CreditTrkjkKbn;

/**
 * {@link C_CreditTrkjkKbn クレジットカード登録状況区分} の Hibernate ユーザー定義型です。<br />
 * クレジットカード登録状況区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_CreditTrkjkKbn extends AbstractUserType<C_CreditTrkjkKbn> {

    @Override
    protected Class<C_CreditTrkjkKbn> returnType() {
        return C_CreditTrkjkKbn.class;
    }

    @Override
    protected C_CreditTrkjkKbn valueOf(String pValue) {
        return C_CreditTrkjkKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_CreditTrkjkKbn pValue) {
        return pValue.getValue();
    }
}
