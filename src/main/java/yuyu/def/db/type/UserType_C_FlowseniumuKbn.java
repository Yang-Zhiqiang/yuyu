package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_FlowseniumuKbn;

/**
 * {@link C_FlowseniumuKbn フロー遷移有無区分} の Hibernate ユーザー定義型です。<br />
 * フロー遷移有無区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_FlowseniumuKbn extends AbstractUserType<C_FlowseniumuKbn> {

    @Override
    protected Class<C_FlowseniumuKbn> returnType() {
        return C_FlowseniumuKbn.class;
    }

    @Override
    protected C_FlowseniumuKbn valueOf(String pValue) {
        return C_FlowseniumuKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_FlowseniumuKbn pValue) {
        return pValue.getValue();
    }
}
