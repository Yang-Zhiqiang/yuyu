package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_KknsmnKbn;

/**
 * {@link C_KknsmnKbn 期間歳満期区分} の Hibernate ユーザー定義型です。<br />
 * 期間歳満期区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_KknsmnKbn extends AbstractUserType<C_KknsmnKbn> {

    @Override
    protected Class<C_KknsmnKbn> returnType() {
        return C_KknsmnKbn.class;
    }

    @Override
    protected C_KknsmnKbn valueOf(String pValue) {
        return C_KknsmnKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_KknsmnKbn pValue) {
        return pValue.getValue();
    }
}
