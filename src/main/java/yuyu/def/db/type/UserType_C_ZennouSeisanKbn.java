package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_ZennouSeisanKbn;

/**
 * {@link C_ZennouSeisanKbn 前納精算区分} の Hibernate ユーザー定義型です。<br />
 * 前納精算区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_ZennouSeisanKbn extends AbstractUserType<C_ZennouSeisanKbn> {

    @Override
    protected Class<C_ZennouSeisanKbn> returnType() {
        return C_ZennouSeisanKbn.class;
    }

    @Override
    protected C_ZennouSeisanKbn valueOf(String pValue) {
        return C_ZennouSeisanKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_ZennouSeisanKbn pValue) {
        return pValue.getValue();
    }
}
