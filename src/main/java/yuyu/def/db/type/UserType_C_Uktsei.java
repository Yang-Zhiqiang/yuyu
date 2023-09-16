package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_Uktsei;

/**
 * {@link C_Uktsei 受取人性別} の Hibernate ユーザー定義型です。<br />
 * 受取人性別 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_Uktsei extends AbstractUserType<C_Uktsei> {

    @Override
    protected Class<C_Uktsei> returnType() {
        return C_Uktsei.class;
    }

    @Override
    protected C_Uktsei valueOf(String pValue) {
        return C_Uktsei.valueOf(pValue);
    }

    @Override
    protected String toString(C_Uktsei pValue) {
        return pValue.getValue();
    }
}
