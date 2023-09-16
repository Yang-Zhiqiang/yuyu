package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_MeihenUktKbn;

/**
 * {@link C_MeihenUktKbn 名義変更受取人区分} の Hibernate ユーザー定義型です。<br />
 * 名義変更受取人区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_MeihenUktKbn extends AbstractUserType<C_MeihenUktKbn> {

    @Override
    protected Class<C_MeihenUktKbn> returnType() {
        return C_MeihenUktKbn.class;
    }

    @Override
    protected C_MeihenUktKbn valueOf(String pValue) {
        return C_MeihenUktKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_MeihenUktKbn pValue) {
        return pValue.getValue();
    }
}
