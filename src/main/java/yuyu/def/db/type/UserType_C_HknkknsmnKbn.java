package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_HknkknsmnKbn;

/**
 * {@link C_HknkknsmnKbn 保険期間歳満期区分} の Hibernate ユーザー定義型です。<br />
 * 保険期間歳満期区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_HknkknsmnKbn extends AbstractUserType<C_HknkknsmnKbn> {

    @Override
    protected Class<C_HknkknsmnKbn> returnType() {
        return C_HknkknsmnKbn.class;
    }

    @Override
    protected C_HknkknsmnKbn valueOf(String pValue) {
        return C_HknkknsmnKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_HknkknsmnKbn pValue) {
        return pValue.getValue();
    }
}
