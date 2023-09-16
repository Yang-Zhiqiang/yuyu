package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_Kknenkinsyu;

/**
 * {@link C_Kknenkinsyu 契約管理年金種類} の Hibernate ユーザー定義型です。<br />
 * 契約管理年金種類 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_Kknenkinsyu extends AbstractUserType<C_Kknenkinsyu> {

    @Override
    protected Class<C_Kknenkinsyu> returnType() {
        return C_Kknenkinsyu.class;
    }

    @Override
    protected C_Kknenkinsyu valueOf(String pValue) {
        return C_Kknenkinsyu.valueOf(pValue);
    }

    @Override
    protected String toString(C_Kknenkinsyu pValue) {
        return pValue.getValue();
    }
}
