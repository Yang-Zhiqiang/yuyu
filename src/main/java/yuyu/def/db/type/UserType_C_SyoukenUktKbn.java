package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_SyoukenUktKbn;

/**
 * {@link C_SyoukenUktKbn 証券受取人区分} の Hibernate ユーザー定義型です。<br />
 * 証券受取人区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_SyoukenUktKbn extends AbstractUserType<C_SyoukenUktKbn> {

    @Override
    protected Class<C_SyoukenUktKbn> returnType() {
        return C_SyoukenUktKbn.class;
    }

    @Override
    protected C_SyoukenUktKbn valueOf(String pValue) {
        return C_SyoukenUktKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_SyoukenUktKbn pValue) {
        return pValue.getValue();
    }
}
