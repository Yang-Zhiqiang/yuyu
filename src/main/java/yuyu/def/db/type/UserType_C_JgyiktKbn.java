package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_JgyiktKbn;

/**
 * {@link C_JgyiktKbn 事業一括区分} の Hibernate ユーザー定義型です。<br />
 * 事業一括区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_JgyiktKbn extends AbstractUserType<C_JgyiktKbn> {

    @Override
    protected Class<C_JgyiktKbn> returnType() {
        return C_JgyiktKbn.class;
    }

    @Override
    protected C_JgyiktKbn valueOf(String pValue) {
        return C_JgyiktKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_JgyiktKbn pValue) {
        return pValue.getValue();
    }
}
