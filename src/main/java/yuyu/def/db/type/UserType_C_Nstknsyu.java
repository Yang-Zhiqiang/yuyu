package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_Nstknsyu;

/**
 * {@link C_Nstknsyu 年金支払特約年金種類} の Hibernate ユーザー定義型です。<br />
 * 年金支払特約年金種類 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_Nstknsyu extends AbstractUserType<C_Nstknsyu> {

    @Override
    protected Class<C_Nstknsyu> returnType() {
        return C_Nstknsyu.class;
    }

    @Override
    protected C_Nstknsyu valueOf(String pValue) {
        return C_Nstknsyu.valueOf(pValue);
    }

    @Override
    protected String toString(C_Nstknsyu pValue) {
        return pValue.getValue();
    }
}
