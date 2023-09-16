package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_SaihkHyjKbn;

/**
 * {@link C_SaihkHyjKbn 再発行表示区分} の Hibernate ユーザー定義型です。<br />
 * 再発行表示区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_SaihkHyjKbn extends AbstractUserType<C_SaihkHyjKbn> {

    @Override
    protected Class<C_SaihkHyjKbn> returnType() {
        return C_SaihkHyjKbn.class;
    }

    @Override
    protected C_SaihkHyjKbn valueOf(String pValue) {
        return C_SaihkHyjKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_SaihkHyjKbn pValue) {
        return pValue.getValue();
    }
}
