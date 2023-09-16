package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_TsryshrsakiKbn;

/**
 * {@link C_TsryshrsakiKbn 手数料支払先区分} の Hibernate ユーザー定義型です。<br />
 * 手数料支払先区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_TsryshrsakiKbn extends AbstractUserType<C_TsryshrsakiKbn> {

    @Override
    protected Class<C_TsryshrsakiKbn> returnType() {
        return C_TsryshrsakiKbn.class;
    }

    @Override
    protected C_TsryshrsakiKbn valueOf(String pValue) {
        return C_TsryshrsakiKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_TsryshrsakiKbn pValue) {
        return pValue.getValue();
    }
}
