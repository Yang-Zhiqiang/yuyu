package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_HrkkknsmnKbn;

/**
 * {@link C_HrkkknsmnKbn 払込期間歳満期区分} の Hibernate ユーザー定義型です。<br />
 * 払込期間歳満期区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_HrkkknsmnKbn extends AbstractUserType<C_HrkkknsmnKbn> {

    @Override
    protected Class<C_HrkkknsmnKbn> returnType() {
        return C_HrkkknsmnKbn.class;
    }

    @Override
    protected C_HrkkknsmnKbn valueOf(String pValue) {
        return C_HrkkknsmnKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_HrkkknsmnKbn pValue) {
        return pValue.getValue();
    }
}
