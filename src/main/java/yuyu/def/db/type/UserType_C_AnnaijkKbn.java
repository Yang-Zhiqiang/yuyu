package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_AnnaijkKbn;

/**
 * {@link C_AnnaijkKbn 案内状況区分} の Hibernate ユーザー定義型です。<br />
 * 案内状況区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_AnnaijkKbn extends AbstractUserType<C_AnnaijkKbn> {

    @Override
    protected Class<C_AnnaijkKbn> returnType() {
        return C_AnnaijkKbn.class;
    }

    @Override
    protected C_AnnaijkKbn valueOf(String pValue) {
        return C_AnnaijkKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_AnnaijkKbn pValue) {
        return pValue.getValue();
    }
}
