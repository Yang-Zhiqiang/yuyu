package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_UriagetorihikiKbn;

/**
 * {@link C_UriagetorihikiKbn 売上取引区分} の Hibernate ユーザー定義型です。<br />
 * 売上取引区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_UriagetorihikiKbn extends AbstractUserType<C_UriagetorihikiKbn> {

    @Override
    protected Class<C_UriagetorihikiKbn> returnType() {
        return C_UriagetorihikiKbn.class;
    }

    @Override
    protected C_UriagetorihikiKbn valueOf(String pValue) {
        return C_UriagetorihikiKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_UriagetorihikiKbn pValue) {
        return pValue.getValue();
    }
}
