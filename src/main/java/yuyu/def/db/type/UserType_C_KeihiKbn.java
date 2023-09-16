package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_KeihiKbn;

/**
 * {@link C_KeihiKbn 契被区分} の Hibernate ユーザー定義型です。<br />
 * 契被区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_KeihiKbn extends AbstractUserType<C_KeihiKbn> {

    @Override
    protected Class<C_KeihiKbn> returnType() {
        return C_KeihiKbn.class;
    }

    @Override
    protected C_KeihiKbn valueOf(String pValue) {
        return C_KeihiKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_KeihiKbn pValue) {
        return pValue.getValue();
    }
}
