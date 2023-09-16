package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_TsryshrKbn;

/**
 * {@link C_TsryshrKbn 手数料支払区分} の Hibernate ユーザー定義型です。<br />
 * 手数料支払区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_TsryshrKbn extends AbstractUserType<C_TsryshrKbn> {

    @Override
    protected Class<C_TsryshrKbn> returnType() {
        return C_TsryshrKbn.class;
    }

    @Override
    protected C_TsryshrKbn valueOf(String pValue) {
        return C_TsryshrKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_TsryshrKbn pValue) {
        return pValue.getValue();
    }
}
