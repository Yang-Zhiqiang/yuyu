package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_SyuShrgkSyoukeiKbn;

/**
 * {@link C_SyuShrgkSyoukeiKbn 主たる支払額小計種類区分} の Hibernate ユーザー定義型です。<br />
 * 主たる支払額小計種類区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_SyuShrgkSyoukeiKbn extends AbstractUserType<C_SyuShrgkSyoukeiKbn> {

    @Override
    protected Class<C_SyuShrgkSyoukeiKbn> returnType() {
        return C_SyuShrgkSyoukeiKbn.class;
    }

    @Override
    protected C_SyuShrgkSyoukeiKbn valueOf(String pValue) {
        return C_SyuShrgkSyoukeiKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_SyuShrgkSyoukeiKbn pValue) {
        return pValue.getValue();
    }
}
