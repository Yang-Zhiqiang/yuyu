package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_NstkhKbn;

/**
 * {@link C_NstkhKbn 年金支払特約変更区分} の Hibernate ユーザー定義型です。<br />
 * 年金支払特約変更区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_NstkhKbn extends AbstractUserType<C_NstkhKbn> {

    @Override
    protected Class<C_NstkhKbn> returnType() {
        return C_NstkhKbn.class;
    }

    @Override
    protected C_NstkhKbn valueOf(String pValue) {
        return C_NstkhKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_NstkhKbn pValue) {
        return pValue.getValue();
    }
}
