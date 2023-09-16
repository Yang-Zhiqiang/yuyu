package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_UktKbn;

/**
 * {@link C_UktKbn 受取人区分} の Hibernate ユーザー定義型です。<br />
 * 受取人区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_UktKbn extends AbstractUserType<C_UktKbn> {

    @Override
    protected Class<C_UktKbn> returnType() {
        return C_UktKbn.class;
    }

    @Override
    protected C_UktKbn valueOf(String pValue) {
        return C_UktKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_UktKbn pValue) {
        return pValue.getValue();
    }
}
