package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_KyokaKbn;

/**
 * {@link C_KyokaKbn 許可区分} の Hibernate ユーザー定義型です。<br />
 * 許可区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_KyokaKbn extends AbstractUserType<C_KyokaKbn> {

    @Override
    protected Class<C_KyokaKbn> returnType() {
        return C_KyokaKbn.class;
    }

    @Override
    protected C_KyokaKbn valueOf(String pValue) {
        return C_KyokaKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_KyokaKbn pValue) {
        return pValue.getValue();
    }
}
