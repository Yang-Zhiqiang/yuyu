package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_OnlineStatusKbn;

/**
 * {@link C_OnlineStatusKbn オンライン状態区分} の Hibernate ユーザー定義型です。<br />
 * オンライン状態区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_OnlineStatusKbn extends AbstractUserType<C_OnlineStatusKbn> {

    @Override
    protected Class<C_OnlineStatusKbn> returnType() {
        return C_OnlineStatusKbn.class;
    }

    @Override
    protected C_OnlineStatusKbn valueOf(String pValue) {
        return C_OnlineStatusKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_OnlineStatusKbn pValue) {
        return pValue.getValue();
    }
}
