package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_ShrrrktsygaiKbn;

/**
 * {@link C_ShrrrktsygaiKbn 支払履歴対象外区分} の Hibernate ユーザー定義型です。<br />
 * 支払履歴対象外区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_ShrrrktsygaiKbn extends AbstractUserType<C_ShrrrktsygaiKbn> {

    @Override
    protected Class<C_ShrrrktsygaiKbn> returnType() {
        return C_ShrrrktsygaiKbn.class;
    }

    @Override
    protected C_ShrrrktsygaiKbn valueOf(String pValue) {
        return C_ShrrrktsygaiKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_ShrrrktsygaiKbn pValue) {
        return pValue.getValue();
    }
}
