package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_GyoutaiKbn;

/**
 * {@link C_GyoutaiKbn 業態区分} の Hibernate ユーザー定義型です。<br />
 * 業態区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_GyoutaiKbn extends AbstractUserType<C_GyoutaiKbn> {

    @Override
    protected Class<C_GyoutaiKbn> returnType() {
        return C_GyoutaiKbn.class;
    }

    @Override
    protected C_GyoutaiKbn valueOf(String pValue) {
        return C_GyoutaiKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_GyoutaiKbn pValue) {
        return pValue.getValue();
    }
}
