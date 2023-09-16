package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_ShryjianKbn;

/**
 * {@link C_ShryjianKbn 支払要事案区分} の Hibernate ユーザー定義型です。<br />
 * 支払要事案区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_ShryjianKbn extends AbstractUserType<C_ShryjianKbn> {

    @Override
    protected Class<C_ShryjianKbn> returnType() {
        return C_ShryjianKbn.class;
    }

    @Override
    protected C_ShryjianKbn valueOf(String pValue) {
        return C_ShryjianKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_ShryjianKbn pValue) {
        return pValue.getValue();
    }
}
