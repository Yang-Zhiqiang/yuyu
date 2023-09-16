package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_Tsinhnkjiyuu;

/**
 * {@link C_Tsinhnkjiyuu 通信先変更事由} の Hibernate ユーザー定義型です。<br />
 * 通信先変更事由 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_Tsinhnkjiyuu extends AbstractUserType<C_Tsinhnkjiyuu> {

    @Override
    protected Class<C_Tsinhnkjiyuu> returnType() {
        return C_Tsinhnkjiyuu.class;
    }

    @Override
    protected C_Tsinhnkjiyuu valueOf(String pValue) {
        return C_Tsinhnkjiyuu.valueOf(pValue);
    }

    @Override
    protected String toString(C_Tsinhnkjiyuu pValue) {
        return pValue.getValue();
    }
}
