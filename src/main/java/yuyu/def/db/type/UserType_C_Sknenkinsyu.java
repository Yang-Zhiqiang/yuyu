package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_Sknenkinsyu;

/**
 * {@link C_Sknenkinsyu 新契約年金種類} の Hibernate ユーザー定義型です。<br />
 * 新契約年金種類 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_Sknenkinsyu extends AbstractUserType<C_Sknenkinsyu> {

    @Override
    protected Class<C_Sknenkinsyu> returnType() {
        return C_Sknenkinsyu.class;
    }

    @Override
    protected C_Sknenkinsyu valueOf(String pValue) {
        return C_Sknenkinsyu.valueOf(pValue);
    }

    @Override
    protected String toString(C_Sknenkinsyu pValue) {
        return pValue.getValue();
    }
}
