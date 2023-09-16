package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_SippeiKbn;

/**
 * {@link C_SippeiKbn 疾病区分} の Hibernate ユーザー定義型です。<br />
 * 疾病区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_SippeiKbn extends AbstractUserType<C_SippeiKbn> {

    @Override
    protected Class<C_SippeiKbn> returnType() {
        return C_SippeiKbn.class;
    }

    @Override
    protected C_SippeiKbn valueOf(String pValue) {
        return C_SippeiKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_SippeiKbn pValue) {
        return pValue.getValue();
    }
}
