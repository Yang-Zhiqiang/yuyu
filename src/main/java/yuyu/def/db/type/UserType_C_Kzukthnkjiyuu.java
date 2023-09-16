package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_Kzukthnkjiyuu;

/**
 * {@link C_Kzukthnkjiyuu 継続受取人変更事由} の Hibernate ユーザー定義型です。<br />
 * 継続受取人変更事由 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_Kzukthnkjiyuu extends AbstractUserType<C_Kzukthnkjiyuu> {

    @Override
    protected Class<C_Kzukthnkjiyuu> returnType() {
        return C_Kzukthnkjiyuu.class;
    }

    @Override
    protected C_Kzukthnkjiyuu valueOf(String pValue) {
        return C_Kzukthnkjiyuu.valueOf(pValue);
    }

    @Override
    protected String toString(C_Kzukthnkjiyuu pValue) {
        return pValue.getValue();
    }
}
