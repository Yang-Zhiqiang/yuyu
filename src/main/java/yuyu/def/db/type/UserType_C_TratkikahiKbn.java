package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_TratkikahiKbn;

/**
 * {@link C_TratkikahiKbn 取扱可否区分} の Hibernate ユーザー定義型です。<br />
 * 取扱可否区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_TratkikahiKbn extends AbstractUserType<C_TratkikahiKbn> {

    @Override
    protected Class<C_TratkikahiKbn> returnType() {
        return C_TratkikahiKbn.class;
    }

    @Override
    protected C_TratkikahiKbn valueOf(String pValue) {
        return C_TratkikahiKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_TratkikahiKbn pValue) {
        return pValue.getValue();
    }
}
