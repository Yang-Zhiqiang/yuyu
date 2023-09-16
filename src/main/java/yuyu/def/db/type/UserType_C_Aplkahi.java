package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_Aplkahi;

/**
 * {@link C_Aplkahi APL可否区分} の Hibernate ユーザー定義型です。<br />
 * APL可否区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_Aplkahi extends AbstractUserType<C_Aplkahi> {

    @Override
    protected Class<C_Aplkahi> returnType() {
        return C_Aplkahi.class;
    }

    @Override
    protected C_Aplkahi valueOf(String pValue) {
        return C_Aplkahi.valueOf(pValue);
    }

    @Override
    protected String toString(C_Aplkahi pValue) {
        return pValue.getValue();
    }
}
