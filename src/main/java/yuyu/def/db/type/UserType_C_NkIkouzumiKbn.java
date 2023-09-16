package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_NkIkouzumiKbn;

/**
 * {@link C_NkIkouzumiKbn 年金移行済区分} の Hibernate ユーザー定義型です。<br />
 * 年金移行済区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_NkIkouzumiKbn extends AbstractUserType<C_NkIkouzumiKbn> {

    @Override
    protected Class<C_NkIkouzumiKbn> returnType() {
        return C_NkIkouzumiKbn.class;
    }

    @Override
    protected C_NkIkouzumiKbn valueOf(String pValue) {
        return C_NkIkouzumiKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_NkIkouzumiKbn pValue) {
        return pValue.getValue();
    }
}
