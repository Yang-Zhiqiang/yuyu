package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_SosikiYuuksHantKbn;

/**
 * {@link C_SosikiYuuksHantKbn 組織有効性判定区分} の Hibernate ユーザー定義型です。<br />
 * 組織有効性判定区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_SosikiYuuksHantKbn extends AbstractUserType<C_SosikiYuuksHantKbn> {

    @Override
    protected Class<C_SosikiYuuksHantKbn> returnType() {
        return C_SosikiYuuksHantKbn.class;
    }

    @Override
    protected C_SosikiYuuksHantKbn valueOf(String pValue) {
        return C_SosikiYuuksHantKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_SosikiYuuksHantKbn pValue) {
        return pValue.getValue();
    }
}
