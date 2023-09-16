package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_KinouKbn;

/**
 * {@link C_KinouKbn 機能区分} の Hibernate ユーザー定義型です。<br />
 * 機能区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_KinouKbn extends AbstractUserType<C_KinouKbn> {

    @Override
    protected Class<C_KinouKbn> returnType() {
        return C_KinouKbn.class;
    }

    @Override
    protected C_KinouKbn valueOf(String pValue) {
        return C_KinouKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_KinouKbn pValue) {
        return pValue.getValue();
    }
}
