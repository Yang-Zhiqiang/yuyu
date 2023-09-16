package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_YouhiKbn;

/**
 * {@link C_YouhiKbn 要否区分} の Hibernate ユーザー定義型です。<br />
 * 要否区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_YouhiKbn extends AbstractUserType<C_YouhiKbn> {

    @Override
    protected Class<C_YouhiKbn> returnType() {
        return C_YouhiKbn.class;
    }

    @Override
    protected C_YouhiKbn valueOf(String pValue) {
        return C_YouhiKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_YouhiKbn pValue) {
        return pValue.getValue();
    }
}
