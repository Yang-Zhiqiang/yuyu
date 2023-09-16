package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_Hurikaejiyuu;

/**
 * {@link C_Hurikaejiyuu 振替事由} の Hibernate ユーザー定義型です。<br />
 * 振替事由 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_Hurikaejiyuu extends AbstractUserType<C_Hurikaejiyuu> {

    @Override
    protected Class<C_Hurikaejiyuu> returnType() {
        return C_Hurikaejiyuu.class;
    }

    @Override
    protected C_Hurikaejiyuu valueOf(String pValue) {
        return C_Hurikaejiyuu.valueOf(pValue);
    }

    @Override
    protected String toString(C_Hurikaejiyuu pValue) {
        return pValue.getValue();
    }
}
