package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_SeirituKbn;

/**
 * {@link C_SeirituKbn 成立区分} の Hibernate ユーザー定義型です。<br />
 * 成立区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_SeirituKbn extends AbstractUserType<C_SeirituKbn> {

    @Override
    protected Class<C_SeirituKbn> returnType() {
        return C_SeirituKbn.class;
    }

    @Override
    protected C_SeirituKbn valueOf(String pValue) {
        return C_SeirituKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_SeirituKbn pValue) {
        return pValue.getValue();
    }
}
