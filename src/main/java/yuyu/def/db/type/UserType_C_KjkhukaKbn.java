package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_KjkhukaKbn;

/**
 * {@link C_KjkhukaKbn 漢字化不可区分} の Hibernate ユーザー定義型です。<br />
 * 漢字化不可区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_KjkhukaKbn extends AbstractUserType<C_KjkhukaKbn> {

    @Override
    protected Class<C_KjkhukaKbn> returnType() {
        return C_KjkhukaKbn.class;
    }

    @Override
    protected C_KjkhukaKbn valueOf(String pValue) {
        return C_KjkhukaKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_KjkhukaKbn pValue) {
        return pValue.getValue();
    }
}
