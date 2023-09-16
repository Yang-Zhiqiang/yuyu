package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_Sdpd;

/**
 * {@link C_Sdpd S建P建区分} の Hibernate ユーザー定義型です。<br />
 * S建P建区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_Sdpd extends AbstractUserType<C_Sdpd> {

    @Override
    protected Class<C_Sdpd> returnType() {
        return C_Sdpd.class;
    }

    @Override
    protected C_Sdpd valueOf(String pValue) {
        return C_Sdpd.valueOf(pValue);
    }

    @Override
    protected String toString(C_Sdpd pValue) {
        return pValue.getValue();
    }
}
