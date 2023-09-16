package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_IjitoukeiZennouKbn;

/**
 * {@link C_IjitoukeiZennouKbn 医事統計用前納区分} の Hibernate ユーザー定義型です。<br />
 * 医事統計用前納区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_IjitoukeiZennouKbn extends AbstractUserType<C_IjitoukeiZennouKbn> {

    @Override
    protected Class<C_IjitoukeiZennouKbn> returnType() {
        return C_IjitoukeiZennouKbn.class;
    }

    @Override
    protected C_IjitoukeiZennouKbn valueOf(String pValue) {
        return C_IjitoukeiZennouKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_IjitoukeiZennouKbn pValue) {
        return pValue.getValue();
    }
}
