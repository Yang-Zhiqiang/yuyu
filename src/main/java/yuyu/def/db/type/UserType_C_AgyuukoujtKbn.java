package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_AgyuukoujtKbn;

/**
 * {@link C_AgyuukoujtKbn 代理店有効状態区分} の Hibernate ユーザー定義型です。<br />
 * 代理店有効状態区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_AgyuukoujtKbn extends AbstractUserType<C_AgyuukoujtKbn> {

    @Override
    protected Class<C_AgyuukoujtKbn> returnType() {
        return C_AgyuukoujtKbn.class;
    }

    @Override
    protected C_AgyuukoujtKbn valueOf(String pValue) {
        return C_AgyuukoujtKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_AgyuukoujtKbn pValue) {
        return pValue.getValue();
    }
}
