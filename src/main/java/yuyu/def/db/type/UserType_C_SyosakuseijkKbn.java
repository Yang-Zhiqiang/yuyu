package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_SyosakuseijkKbn;

/**
 * {@link C_SyosakuseijkKbn 証券作成状況区分} の Hibernate ユーザー定義型です。<br />
 * 証券作成状況区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_SyosakuseijkKbn extends AbstractUserType<C_SyosakuseijkKbn> {

    @Override
    protected Class<C_SyosakuseijkKbn> returnType() {
        return C_SyosakuseijkKbn.class;
    }

    @Override
    protected C_SyosakuseijkKbn valueOf(String pValue) {
        return C_SyosakuseijkKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_SyosakuseijkKbn pValue) {
        return pValue.getValue();
    }
}
