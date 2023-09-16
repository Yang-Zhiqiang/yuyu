package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_SyouhizeiusKbn;

/**
 * {@link C_SyouhizeiusKbn 消費税内税外税区分} の Hibernate ユーザー定義型です。<br />
 * 消費税内税外税区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_SyouhizeiusKbn extends AbstractUserType<C_SyouhizeiusKbn> {

    @Override
    protected Class<C_SyouhizeiusKbn> returnType() {
        return C_SyouhizeiusKbn.class;
    }

    @Override
    protected C_SyouhizeiusKbn valueOf(String pValue) {
        return C_SyouhizeiusKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_SyouhizeiusKbn pValue) {
        return pValue.getValue();
    }
}
