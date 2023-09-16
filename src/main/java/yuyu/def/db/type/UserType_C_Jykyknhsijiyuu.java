package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_Jykyknhsijiyuu;

/**
 * {@link C_Jykyknhsijiyuu 受給権発生事由} の Hibernate ユーザー定義型です。<br />
 * 受給権発生事由 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_Jykyknhsijiyuu extends AbstractUserType<C_Jykyknhsijiyuu> {

    @Override
    protected Class<C_Jykyknhsijiyuu> returnType() {
        return C_Jykyknhsijiyuu.class;
    }

    @Override
    protected C_Jykyknhsijiyuu valueOf(String pValue) {
        return C_Jykyknhsijiyuu.valueOf(pValue);
    }

    @Override
    protected String toString(C_Jykyknhsijiyuu pValue) {
        return pValue.getValue();
    }
}
