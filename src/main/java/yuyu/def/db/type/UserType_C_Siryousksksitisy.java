package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_Siryousksksitisy;

/**
 * {@link C_Siryousksksitisy 資料請求作成対象区分} の Hibernate ユーザー定義型です。<br />
 * 資料請求作成対象区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_Siryousksksitisy extends AbstractUserType<C_Siryousksksitisy> {

    @Override
    protected Class<C_Siryousksksitisy> returnType() {
        return C_Siryousksksitisy.class;
    }

    @Override
    protected C_Siryousksksitisy valueOf(String pValue) {
        return C_Siryousksksitisy.valueOf(pValue);
    }

    @Override
    protected String toString(C_Siryousksksitisy pValue) {
        return pValue.getValue();
    }
}
