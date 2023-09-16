package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_SyohizeikeisikiKbn;

/**
 * {@link C_SyohizeikeisikiKbn 消費税形式区分} の Hibernate ユーザー定義型です。<br />
 * 消費税形式区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_SyohizeikeisikiKbn extends AbstractUserType<C_SyohizeikeisikiKbn> {

    @Override
    protected Class<C_SyohizeikeisikiKbn> returnType() {
        return C_SyohizeikeisikiKbn.class;
    }

    @Override
    protected C_SyohizeikeisikiKbn valueOf(String pValue) {
        return C_SyohizeikeisikiKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_SyohizeikeisikiKbn pValue) {
        return pValue.getValue();
    }
}
