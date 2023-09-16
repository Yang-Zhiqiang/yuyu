package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_Khhrshrjiyuu;

/**
 * {@link C_Khhrshrjiyuu 契約保全返戻金支払事由} の Hibernate ユーザー定義型です。<br />
 * 契約保全返戻金支払事由 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_Khhrshrjiyuu extends AbstractUserType<C_Khhrshrjiyuu> {

    @Override
    protected Class<C_Khhrshrjiyuu> returnType() {
        return C_Khhrshrjiyuu.class;
    }

    @Override
    protected C_Khhrshrjiyuu valueOf(String pValue) {
        return C_Khhrshrjiyuu.valueOf(pValue);
    }

    @Override
    protected String toString(C_Khhrshrjiyuu pValue) {
        return pValue.getValue();
    }
}
