package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_CfKbn;

/**
 * {@link C_CfKbn ＣＦ区分} の Hibernate ユーザー定義型です。<br />
 * ＣＦ区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_CfKbn extends AbstractUserType<C_CfKbn> {

    @Override
    protected Class<C_CfKbn> returnType() {
        return C_CfKbn.class;
    }

    @Override
    protected C_CfKbn valueOf(String pValue) {
        return C_CfKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_CfKbn pValue) {
        return pValue.getValue();
    }
}
