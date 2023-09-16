package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_YmdkeisikiKbn;

/**
 * {@link C_YmdkeisikiKbn 年月日形式区分} の Hibernate ユーザー定義型です。<br />
 * 年月日形式区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_YmdkeisikiKbn extends AbstractUserType<C_YmdkeisikiKbn> {

    @Override
    protected Class<C_YmdkeisikiKbn> returnType() {
        return C_YmdkeisikiKbn.class;
    }

    @Override
    protected C_YmdkeisikiKbn valueOf(String pValue) {
        return C_YmdkeisikiKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_YmdkeisikiKbn pValue) {
        return pValue.getValue();
    }
}
