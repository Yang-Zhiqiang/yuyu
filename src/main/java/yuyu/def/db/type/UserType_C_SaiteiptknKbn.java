package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_SaiteiptknKbn;

/**
 * {@link C_SaiteiptknKbn 最低P特認区分} の Hibernate ユーザー定義型です。<br />
 * 最低P特認区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_SaiteiptknKbn extends AbstractUserType<C_SaiteiptknKbn> {

    @Override
    protected Class<C_SaiteiptknKbn> returnType() {
        return C_SaiteiptknKbn.class;
    }

    @Override
    protected C_SaiteiptknKbn valueOf(String pValue) {
        return C_SaiteiptknKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_SaiteiptknKbn pValue) {
        return pValue.getValue();
    }
}
