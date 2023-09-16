package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_ShrrnyKbn;

/**
 * {@link C_ShrrnyKbn 支払戻入区分} の Hibernate ユーザー定義型です。<br />
 * 支払戻入区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_ShrrnyKbn extends AbstractUserType<C_ShrrnyKbn> {

    @Override
    protected Class<C_ShrrnyKbn> returnType() {
        return C_ShrrnyKbn.class;
    }

    @Override
    protected C_ShrrnyKbn valueOf(String pValue) {
        return C_ShrrnyKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_ShrrnyKbn pValue) {
        return pValue.getValue();
    }
}
