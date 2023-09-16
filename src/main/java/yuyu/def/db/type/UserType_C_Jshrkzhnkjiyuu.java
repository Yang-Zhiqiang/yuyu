package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_Jshrkzhnkjiyuu;

/**
 * {@link C_Jshrkzhnkjiyuu 自動支払口座変更事由} の Hibernate ユーザー定義型です。<br />
 * 自動支払口座変更事由 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_Jshrkzhnkjiyuu extends AbstractUserType<C_Jshrkzhnkjiyuu> {

    @Override
    protected Class<C_Jshrkzhnkjiyuu> returnType() {
        return C_Jshrkzhnkjiyuu.class;
    }

    @Override
    protected C_Jshrkzhnkjiyuu valueOf(String pValue) {
        return C_Jshrkzhnkjiyuu.valueOf(pValue);
    }

    @Override
    protected String toString(C_Jshrkzhnkjiyuu pValue) {
        return pValue.getValue();
    }
}
