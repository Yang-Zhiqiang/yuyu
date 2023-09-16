package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_Daikzktdk;

/**
 * {@link C_Daikzktdk 代表家族続柄} の Hibernate ユーザー定義型です。<br />
 * 代表家族続柄 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_Daikzktdk extends AbstractUserType<C_Daikzktdk> {

    @Override
    protected Class<C_Daikzktdk> returnType() {
        return C_Daikzktdk.class;
    }

    @Override
    protected C_Daikzktdk valueOf(String pValue) {
        return C_Daikzktdk.valueOf(pValue);
    }

    @Override
    protected String toString(C_Daikzktdk pValue) {
        return pValue.getValue();
    }
}
