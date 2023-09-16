package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_MassitknKbn;

/**
 * {@link C_MassitknKbn 末子特認区分} の Hibernate ユーザー定義型です。<br />
 * 末子特認区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_MassitknKbn extends AbstractUserType<C_MassitknKbn> {

    @Override
    protected Class<C_MassitknKbn> returnType() {
        return C_MassitknKbn.class;
    }

    @Override
    protected C_MassitknKbn valueOf(String pValue) {
        return C_MassitknKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_MassitknKbn pValue) {
        return pValue.getValue();
    }
}
