package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_SensinKbn;

/**
 * {@link C_SensinKbn 先進医療区分} の Hibernate ユーザー定義型です。<br />
 * 先進医療区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_SensinKbn extends AbstractUserType<C_SensinKbn> {

    @Override
    protected Class<C_SensinKbn> returnType() {
        return C_SensinKbn.class;
    }

    @Override
    protected C_SensinKbn valueOf(String pValue) {
        return C_SensinKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_SensinKbn pValue) {
        return pValue.getValue();
    }
}
