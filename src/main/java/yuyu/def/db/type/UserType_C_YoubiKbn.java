package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_YoubiKbn;

/**
 * {@link C_YoubiKbn 曜日区分} の Hibernate ユーザー定義型です。<br />
 * 曜日区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_YoubiKbn extends AbstractUserType<C_YoubiKbn> {

    @Override
    protected Class<C_YoubiKbn> returnType() {
        return C_YoubiKbn.class;
    }

    @Override
    protected C_YoubiKbn valueOf(String pValue) {
        return C_YoubiKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_YoubiKbn pValue) {
        return pValue.getValue();
    }
}
