package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_ShannaiKbn;

/**
 * {@link C_ShannaiKbn 送付案内区分} の Hibernate ユーザー定義型です。<br />
 * 送付案内区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_ShannaiKbn extends AbstractUserType<C_ShannaiKbn> {

    @Override
    protected Class<C_ShannaiKbn> returnType() {
        return C_ShannaiKbn.class;
    }

    @Override
    protected C_ShannaiKbn valueOf(String pValue) {
        return C_ShannaiKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_ShannaiKbn pValue) {
        return pValue.getValue();
    }
}
