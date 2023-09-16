package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_SuuriZennouKbn;

/**
 * {@link C_SuuriZennouKbn 数理前納区分} の Hibernate ユーザー定義型です。<br />
 * 数理前納区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_SuuriZennouKbn extends AbstractUserType<C_SuuriZennouKbn> {

    @Override
    protected Class<C_SuuriZennouKbn> returnType() {
        return C_SuuriZennouKbn.class;
    }

    @Override
    protected C_SuuriZennouKbn valueOf(String pValue) {
        return C_SuuriZennouKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_SuuriZennouKbn pValue) {
        return pValue.getValue();
    }
}
