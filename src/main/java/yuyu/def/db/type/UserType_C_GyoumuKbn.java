package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_GyoumuKbn;

/**
 * {@link C_GyoumuKbn 業務区分} の Hibernate ユーザー定義型です。<br />
 * 業務区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_GyoumuKbn extends AbstractUserType<C_GyoumuKbn> {

    @Override
    protected Class<C_GyoumuKbn> returnType() {
        return C_GyoumuKbn.class;
    }

    @Override
    protected C_GyoumuKbn valueOf(String pValue) {
        return C_GyoumuKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_GyoumuKbn pValue) {
        return pValue.getValue();
    }
}
