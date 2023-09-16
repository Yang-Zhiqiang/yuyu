package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_7daiSippeiKbn;

/**
 * {@link C_7daiSippeiKbn ７大疾病区分} の Hibernate ユーザー定義型です。<br />
 * ７大疾病区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_7daiSippeiKbn extends AbstractUserType<C_7daiSippeiKbn> {

    @Override
    protected Class<C_7daiSippeiKbn> returnType() {
        return C_7daiSippeiKbn.class;
    }

    @Override
    protected C_7daiSippeiKbn valueOf(String pValue) {
        return C_7daiSippeiKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_7daiSippeiKbn pValue) {
        return pValue.getValue();
    }
}
