package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_Tdk;

/**
 * {@link C_Tdk 続柄} の Hibernate ユーザー定義型です。<br />
 * 続柄 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_Tdk extends AbstractUserType<C_Tdk> {

    @Override
    protected Class<C_Tdk> returnType() {
        return C_Tdk.class;
    }

    @Override
    protected C_Tdk valueOf(String pValue) {
        return C_Tdk.valueOf(pValue);
    }

    @Override
    protected String toString(C_Tdk pValue) {
        return pValue.getValue();
    }
}
