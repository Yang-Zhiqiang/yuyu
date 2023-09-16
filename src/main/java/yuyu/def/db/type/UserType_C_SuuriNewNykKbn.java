package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_SuuriNewNykKbn;

/**
 * {@link C_SuuriNewNykKbn 数理新入金区分} の Hibernate ユーザー定義型です。<br />
 * 数理新入金区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_SuuriNewNykKbn extends AbstractUserType<C_SuuriNewNykKbn> {

    @Override
    protected Class<C_SuuriNewNykKbn> returnType() {
        return C_SuuriNewNykKbn.class;
    }

    @Override
    protected C_SuuriNewNykKbn valueOf(String pValue) {
        return C_SuuriNewNykKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_SuuriNewNykKbn pValue) {
        return pValue.getValue();
    }
}
