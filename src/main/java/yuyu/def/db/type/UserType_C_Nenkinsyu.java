package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_Nenkinsyu;

/**
 * {@link C_Nenkinsyu 年金種類区分} の Hibernate ユーザー定義型です。<br />
 * 年金種類区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_Nenkinsyu extends AbstractUserType<C_Nenkinsyu> {

    @Override
    protected Class<C_Nenkinsyu> returnType() {
        return C_Nenkinsyu.class;
    }

    @Override
    protected C_Nenkinsyu valueOf(String pValue) {
        return C_Nenkinsyu.valueOf(pValue);
    }

    @Override
    protected String toString(C_Nenkinsyu pValue) {
        return pValue.getValue();
    }
}
