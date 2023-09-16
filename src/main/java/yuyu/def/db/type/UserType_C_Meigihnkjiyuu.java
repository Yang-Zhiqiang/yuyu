package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_Meigihnkjiyuu;

/**
 * {@link C_Meigihnkjiyuu 名義変更事由} の Hibernate ユーザー定義型です。<br />
 * 名義変更事由 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_Meigihnkjiyuu extends AbstractUserType<C_Meigihnkjiyuu> {

    @Override
    protected Class<C_Meigihnkjiyuu> returnType() {
        return C_Meigihnkjiyuu.class;
    }

    @Override
    protected C_Meigihnkjiyuu valueOf(String pValue) {
        return C_Meigihnkjiyuu.valueOf(pValue);
    }

    @Override
    protected String toString(C_Meigihnkjiyuu pValue) {
        return pValue.getValue();
    }
}
