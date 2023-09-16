package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_LogLevelKbn;

/**
 * {@link C_LogLevelKbn ログレベル区分} の Hibernate ユーザー定義型です。<br />
 * ログレベル区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_LogLevelKbn extends AbstractUserType<C_LogLevelKbn> {

    @Override
    protected Class<C_LogLevelKbn> returnType() {
        return C_LogLevelKbn.class;
    }

    @Override
    protected C_LogLevelKbn valueOf(String pValue) {
        return C_LogLevelKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_LogLevelKbn pValue) {
        return pValue.getValue();
    }
}
