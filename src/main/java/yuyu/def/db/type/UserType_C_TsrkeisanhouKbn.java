package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_TsrkeisanhouKbn;

/**
 * {@link C_TsrkeisanhouKbn 手数料計算方法区分} の Hibernate ユーザー定義型です。<br />
 * 手数料計算方法区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_TsrkeisanhouKbn extends AbstractUserType<C_TsrkeisanhouKbn> {

    @Override
    protected Class<C_TsrkeisanhouKbn> returnType() {
        return C_TsrkeisanhouKbn.class;
    }

    @Override
    protected C_TsrkeisanhouKbn valueOf(String pValue) {
        return C_TsrkeisanhouKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_TsrkeisanhouKbn pValue) {
        return pValue.getValue();
    }
}
