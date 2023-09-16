package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_SateihhKbn;

/**
 * {@link C_SateihhKbn 査定方法区分} の Hibernate ユーザー定義型です。<br />
 * 査定方法区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_SateihhKbn extends AbstractUserType<C_SateihhKbn> {

    @Override
    protected Class<C_SateihhKbn> returnType() {
        return C_SateihhKbn.class;
    }

    @Override
    protected C_SateihhKbn valueOf(String pValue) {
        return C_SateihhKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_SateihhKbn pValue) {
        return pValue.getValue();
    }
}
