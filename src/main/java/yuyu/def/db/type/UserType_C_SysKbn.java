package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_SysKbn;

/**
 * {@link C_SysKbn システム区分} の Hibernate ユーザー定義型です。<br />
 * システム区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_SysKbn extends AbstractUserType<C_SysKbn> {

    @Override
    protected Class<C_SysKbn> returnType() {
        return C_SysKbn.class;
    }

    @Override
    protected C_SysKbn valueOf(String pValue) {
        return C_SysKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_SysKbn pValue) {
        return pValue.getValue();
    }
}
