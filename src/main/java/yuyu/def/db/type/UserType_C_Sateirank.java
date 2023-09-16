package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_Sateirank;

/**
 * {@link C_Sateirank 査定ランク} の Hibernate ユーザー定義型です。<br />
 * 査定ランク 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_Sateirank extends AbstractUserType<C_Sateirank> {

    @Override
    protected Class<C_Sateirank> returnType() {
        return C_Sateirank.class;
    }

    @Override
    protected C_Sateirank valueOf(String pValue) {
        return C_Sateirank.valueOf(pValue);
    }

    @Override
    protected String toString(C_Sateirank pValue) {
        return pValue.getValue();
    }
}
