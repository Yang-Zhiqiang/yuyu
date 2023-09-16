package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_StresstestKbn;

/**
 * {@link C_StresstestKbn ストレステスト区分} の Hibernate ユーザー定義型です。<br />
 * ストレステスト区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_StresstestKbn extends AbstractUserType<C_StresstestKbn> {

    @Override
    protected Class<C_StresstestKbn> returnType() {
        return C_StresstestKbn.class;
    }

    @Override
    protected C_StresstestKbn valueOf(String pValue) {
        return C_StresstestKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_StresstestKbn pValue) {
        return pValue.getValue();
    }
}
