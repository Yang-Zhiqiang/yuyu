package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_Gyoumucd;

/**
 * {@link C_Gyoumucd 業務コード} の Hibernate ユーザー定義型です。<br />
 * 業務コード 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_Gyoumucd extends AbstractUserType<C_Gyoumucd> {

    @Override
    protected Class<C_Gyoumucd> returnType() {
        return C_Gyoumucd.class;
    }

    @Override
    protected C_Gyoumucd valueOf(String pValue) {
        return C_Gyoumucd.valueOf(pValue);
    }

    @Override
    protected String toString(C_Gyoumucd pValue) {
        return pValue.getValue();
    }
}
