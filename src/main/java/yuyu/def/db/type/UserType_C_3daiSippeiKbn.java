package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_3daiSippeiKbn;

/**
 * {@link C_3daiSippeiKbn ３大疾病区分} の Hibernate ユーザー定義型です。<br />
 * ３大疾病区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_3daiSippeiKbn extends AbstractUserType<C_3daiSippeiKbn> {

    @Override
    protected Class<C_3daiSippeiKbn> returnType() {
        return C_3daiSippeiKbn.class;
    }

    @Override
    protected C_3daiSippeiKbn valueOf(String pValue) {
        return C_3daiSippeiKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_3daiSippeiKbn pValue) {
        return pValue.getValue();
    }
}
