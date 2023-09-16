package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_YuukoujtKbn;

/**
 * {@link C_YuukoujtKbn 有効状態区分} の Hibernate ユーザー定義型です。<br />
 * 有効状態区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_YuukoujtKbn extends AbstractUserType<C_YuukoujtKbn> {

    @Override
    protected Class<C_YuukoujtKbn> returnType() {
        return C_YuukoujtKbn.class;
    }

    @Override
    protected C_YuukoujtKbn valueOf(String pValue) {
        return C_YuukoujtKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_YuukoujtKbn pValue) {
        return pValue.getValue();
    }
}
