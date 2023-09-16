package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_SateiYouhiKbn;

/**
 * {@link C_SateiYouhiKbn 査定要否区分} の Hibernate ユーザー定義型です。<br />
 * 査定要否区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_SateiYouhiKbn extends AbstractUserType<C_SateiYouhiKbn> {

    @Override
    protected Class<C_SateiYouhiKbn> returnType() {
        return C_SateiYouhiKbn.class;
    }

    @Override
    protected C_SateiYouhiKbn valueOf(String pValue) {
        return C_SateiYouhiKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_SateiYouhiKbn pValue) {
        return pValue.getValue();
    }
}
