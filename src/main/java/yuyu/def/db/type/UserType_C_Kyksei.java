package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_Kyksei;

/**
 * {@link C_Kyksei 契約者性別} の Hibernate ユーザー定義型です。<br />
 * 契約者性別 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_Kyksei extends AbstractUserType<C_Kyksei> {

    @Override
    protected Class<C_Kyksei> returnType() {
        return C_Kyksei.class;
    }

    @Override
    protected C_Kyksei valueOf(String pValue) {
        return C_Kyksei.valueOf(pValue);
    }

    @Override
    protected String toString(C_Kyksei pValue) {
        return pValue.getValue();
    }
}
