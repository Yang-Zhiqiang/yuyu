package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_AccessKbn;

/**
 * {@link C_AccessKbn アクセス区分} の Hibernate ユーザー定義型です。<br />
 * アクセス区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_AccessKbn extends AbstractUserType<C_AccessKbn> {

    @Override
    protected Class<C_AccessKbn> returnType() {
        return C_AccessKbn.class;
    }

    @Override
    protected C_AccessKbn valueOf(String pValue) {
        return C_AccessKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_AccessKbn pValue) {
        return pValue.getValue();
    }
}
