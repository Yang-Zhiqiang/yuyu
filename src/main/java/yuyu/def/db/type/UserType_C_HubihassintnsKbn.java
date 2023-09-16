package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_HubihassintnsKbn;

/**
 * {@link C_HubihassintnsKbn 不備発信転送区分} の Hibernate ユーザー定義型です。<br />
 * 不備発信転送区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_HubihassintnsKbn extends AbstractUserType<C_HubihassintnsKbn> {

    @Override
    protected Class<C_HubihassintnsKbn> returnType() {
        return C_HubihassintnsKbn.class;
    }

    @Override
    protected C_HubihassintnsKbn valueOf(String pValue) {
        return C_HubihassintnsKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_HubihassintnsKbn pValue) {
        return pValue.getValue();
    }
}
