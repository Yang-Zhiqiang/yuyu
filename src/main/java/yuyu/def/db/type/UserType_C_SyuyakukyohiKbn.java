package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_SyuyakukyohiKbn;

/**
 * {@link C_SyuyakukyohiKbn 集約拒否区分} の Hibernate ユーザー定義型です。<br />
 * 集約拒否区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_SyuyakukyohiKbn extends AbstractUserType<C_SyuyakukyohiKbn> {

    @Override
    protected Class<C_SyuyakukyohiKbn> returnType() {
        return C_SyuyakukyohiKbn.class;
    }

    @Override
    protected C_SyuyakukyohiKbn valueOf(String pValue) {
        return C_SyuyakukyohiKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_SyuyakukyohiKbn pValue) {
        return pValue.getValue();
    }
}
