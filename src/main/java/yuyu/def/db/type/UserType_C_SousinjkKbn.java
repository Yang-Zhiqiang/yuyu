package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_SousinjkKbn;

/**
 * {@link C_SousinjkKbn 送信状況区分} の Hibernate ユーザー定義型です。<br />
 * 送信状況区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_SousinjkKbn extends AbstractUserType<C_SousinjkKbn> {

    @Override
    protected Class<C_SousinjkKbn> returnType() {
        return C_SousinjkKbn.class;
    }

    @Override
    protected C_SousinjkKbn valueOf(String pValue) {
        return C_SousinjkKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_SousinjkKbn pValue) {
        return pValue.getValue();
    }
}
