package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_TkjrenkeijtKbn;

/**
 * {@link C_TkjrenkeijtKbn 特条連携状態区分} の Hibernate ユーザー定義型です。<br />
 * 特条連携状態区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_TkjrenkeijtKbn extends AbstractUserType<C_TkjrenkeijtKbn> {

    @Override
    protected Class<C_TkjrenkeijtKbn> returnType() {
        return C_TkjrenkeijtKbn.class;
    }

    @Override
    protected C_TkjrenkeijtKbn valueOf(String pValue) {
        return C_TkjrenkeijtKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_TkjrenkeijtKbn pValue) {
        return pValue.getValue();
    }
}
