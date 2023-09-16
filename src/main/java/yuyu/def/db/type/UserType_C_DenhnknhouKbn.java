package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_DenhnknhouKbn;

/**
 * {@link C_DenhnknhouKbn 伝票用返金方法区分} の Hibernate ユーザー定義型です。<br />
 * 伝票用返金方法区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_DenhnknhouKbn extends AbstractUserType<C_DenhnknhouKbn> {

    @Override
    protected Class<C_DenhnknhouKbn> returnType() {
        return C_DenhnknhouKbn.class;
    }

    @Override
    protected C_DenhnknhouKbn valueOf(String pValue) {
        return C_DenhnknhouKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_DenhnknhouKbn pValue) {
        return pValue.getValue();
    }
}
