package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_Nstkumu;

/**
 * {@link C_Nstkumu 年金支払特約有無} の Hibernate ユーザー定義型です。<br />
 * 年金支払特約有無 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_Nstkumu extends AbstractUserType<C_Nstkumu> {

    @Override
    protected Class<C_Nstkumu> returnType() {
        return C_Nstkumu.class;
    }

    @Override
    protected C_Nstkumu valueOf(String pValue) {
        return C_Nstkumu.valueOf(pValue);
    }

    @Override
    protected String toString(C_Nstkumu pValue) {
        return pValue.getValue();
    }
}
