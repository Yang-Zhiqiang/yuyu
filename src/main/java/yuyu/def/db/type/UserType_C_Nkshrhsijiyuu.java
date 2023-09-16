package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_Nkshrhsijiyuu;

/**
 * {@link C_Nkshrhsijiyuu 年金支払発生事由} の Hibernate ユーザー定義型です。<br />
 * 年金支払発生事由 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_Nkshrhsijiyuu extends AbstractUserType<C_Nkshrhsijiyuu> {

    @Override
    protected Class<C_Nkshrhsijiyuu> returnType() {
        return C_Nkshrhsijiyuu.class;
    }

    @Override
    protected C_Nkshrhsijiyuu valueOf(String pValue) {
        return C_Nkshrhsijiyuu.valueOf(pValue);
    }

    @Override
    protected String toString(C_Nkshrhsijiyuu pValue) {
        return pValue.getValue();
    }
}
