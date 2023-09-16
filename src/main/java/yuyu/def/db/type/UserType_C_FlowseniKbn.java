package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_FlowseniKbn;

/**
 * {@link C_FlowseniKbn フロー遷移区分} の Hibernate ユーザー定義型です。<br />
 * フロー遷移区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_FlowseniKbn extends AbstractUserType<C_FlowseniKbn> {

    @Override
    protected Class<C_FlowseniKbn> returnType() {
        return C_FlowseniKbn.class;
    }

    @Override
    protected C_FlowseniKbn valueOf(String pValue) {
        return C_FlowseniKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_FlowseniKbn pValue) {
        return pValue.getValue();
    }
}
