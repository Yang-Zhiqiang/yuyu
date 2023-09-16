package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_SbukkouteijkKbn;

/**
 * {@link C_SbukkouteijkKbn 受付工程状況区分} の Hibernate ユーザー定義型です。<br />
 * 受付工程状況区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_SbukkouteijkKbn extends AbstractUserType<C_SbukkouteijkKbn> {

    @Override
    protected Class<C_SbukkouteijkKbn> returnType() {
        return C_SbukkouteijkKbn.class;
    }

    @Override
    protected C_SbukkouteijkKbn valueOf(String pValue) {
        return C_SbukkouteijkKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_SbukkouteijkKbn pValue) {
        return pValue.getValue();
    }
}
