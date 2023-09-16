package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_TtdkKinouKbn;

/**
 * {@link C_TtdkKinouKbn 手続機能区分} の Hibernate ユーザー定義型です。<br />
 * 手続機能区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_TtdkKinouKbn extends AbstractUserType<C_TtdkKinouKbn> {

    @Override
    protected Class<C_TtdkKinouKbn> returnType() {
        return C_TtdkKinouKbn.class;
    }

    @Override
    protected C_TtdkKinouKbn valueOf(String pValue) {
        return C_TtdkKinouKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_TtdkKinouKbn pValue) {
        return pValue.getValue();
    }
}
