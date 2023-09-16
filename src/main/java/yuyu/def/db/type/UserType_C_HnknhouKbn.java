package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_HnknhouKbn;

/**
 * {@link C_HnknhouKbn 返金方法区分} の Hibernate ユーザー定義型です。<br />
 * 返金方法区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_HnknhouKbn extends AbstractUserType<C_HnknhouKbn> {

    @Override
    protected Class<C_HnknhouKbn> returnType() {
        return C_HnknhouKbn.class;
    }

    @Override
    protected C_HnknhouKbn valueOf(String pValue) {
        return C_HnknhouKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_HnknhouKbn pValue) {
        return pValue.getValue();
    }
}
