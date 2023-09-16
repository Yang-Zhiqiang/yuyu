package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_Hhktdk;

/**
 * {@link C_Hhktdk 被保険者続柄} の Hibernate ユーザー定義型です。<br />
 * 被保険者続柄 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_Hhktdk extends AbstractUserType<C_Hhktdk> {

    @Override
    protected Class<C_Hhktdk> returnType() {
        return C_Hhktdk.class;
    }

    @Override
    protected C_Hhktdk valueOf(String pValue) {
        return C_Hhktdk.valueOf(pValue);
    }

    @Override
    protected String toString(C_Hhktdk pValue) {
        return pValue.getValue();
    }
}
