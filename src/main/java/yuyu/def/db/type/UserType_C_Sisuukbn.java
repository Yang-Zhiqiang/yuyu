package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_Sisuukbn;

/**
 * {@link C_Sisuukbn 指数区分} の Hibernate ユーザー定義型です。<br />
 * 指数区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_Sisuukbn extends AbstractUserType<C_Sisuukbn> {

    @Override
    protected Class<C_Sisuukbn> returnType() {
        return C_Sisuukbn.class;
    }

    @Override
    protected C_Sisuukbn valueOf(String pValue) {
        return C_Sisuukbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_Sisuukbn pValue) {
        return pValue.getValue();
    }
}
