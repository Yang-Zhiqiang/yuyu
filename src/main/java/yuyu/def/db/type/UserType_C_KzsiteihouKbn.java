package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_KzsiteihouKbn;

/**
 * {@link C_KzsiteihouKbn 口座指定方法区分} の Hibernate ユーザー定義型です。<br />
 * 口座指定方法区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_KzsiteihouKbn extends AbstractUserType<C_KzsiteihouKbn> {

    @Override
    protected Class<C_KzsiteihouKbn> returnType() {
        return C_KzsiteihouKbn.class;
    }

    @Override
    protected C_KzsiteihouKbn valueOf(String pValue) {
        return C_KzsiteihouKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_KzsiteihouKbn pValue) {
        return pValue.getValue();
    }
}
