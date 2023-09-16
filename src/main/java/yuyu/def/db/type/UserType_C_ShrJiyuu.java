package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_ShrJiyuu;

/**
 * {@link C_ShrJiyuu 支払事由} の Hibernate ユーザー定義型です。<br />
 * 支払事由 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_ShrJiyuu extends AbstractUserType<C_ShrJiyuu> {

    @Override
    protected Class<C_ShrJiyuu> returnType() {
        return C_ShrJiyuu.class;
    }

    @Override
    protected C_ShrJiyuu valueOf(String pValue) {
        return C_ShrJiyuu.valueOf(pValue);
    }

    @Override
    protected String toString(C_ShrJiyuu pValue) {
        return pValue.getValue();
    }
}
