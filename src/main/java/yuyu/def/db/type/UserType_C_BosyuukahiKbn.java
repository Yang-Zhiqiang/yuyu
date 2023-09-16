package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_BosyuukahiKbn;

/**
 * {@link C_BosyuukahiKbn 募集可否判定区分} の Hibernate ユーザー定義型です。<br />
 * 募集可否判定区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_BosyuukahiKbn extends AbstractUserType<C_BosyuukahiKbn> {

    @Override
    protected Class<C_BosyuukahiKbn> returnType() {
        return C_BosyuukahiKbn.class;
    }

    @Override
    protected C_BosyuukahiKbn valueOf(String pValue) {
        return C_BosyuukahiKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_BosyuukahiKbn pValue) {
        return pValue.getValue();
    }
}
