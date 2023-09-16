package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_YoukyuuKbn;

/**
 * {@link C_YoukyuuKbn 要求区分} の Hibernate ユーザー定義型です。<br />
 * 要求区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_YoukyuuKbn extends AbstractUserType<C_YoukyuuKbn> {

    @Override
    protected Class<C_YoukyuuKbn> returnType() {
        return C_YoukyuuKbn.class;
    }

    @Override
    protected C_YoukyuuKbn valueOf(String pValue) {
        return C_YoukyuuKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_YoukyuuKbn pValue) {
        return pValue.getValue();
    }
}
