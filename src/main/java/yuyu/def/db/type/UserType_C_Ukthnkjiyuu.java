package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_Ukthnkjiyuu;

/**
 * {@link C_Ukthnkjiyuu 受取人変更事由} の Hibernate ユーザー定義型です。<br />
 * 受取人変更事由 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_Ukthnkjiyuu extends AbstractUserType<C_Ukthnkjiyuu> {

    @Override
    protected Class<C_Ukthnkjiyuu> returnType() {
        return C_Ukthnkjiyuu.class;
    }

    @Override
    protected C_Ukthnkjiyuu valueOf(String pValue) {
        return C_Ukthnkjiyuu.valueOf(pValue);
    }

    @Override
    protected String toString(C_Ukthnkjiyuu pValue) {
        return pValue.getValue();
    }
}
