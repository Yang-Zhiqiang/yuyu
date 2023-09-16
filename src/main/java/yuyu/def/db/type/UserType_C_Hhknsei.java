package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_Hhknsei;

/**
 * {@link C_Hhknsei 被保険者性別} の Hibernate ユーザー定義型です。<br />
 * 被保険者性別 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_Hhknsei extends AbstractUserType<C_Hhknsei> {

    @Override
    protected Class<C_Hhknsei> returnType() {
        return C_Hhknsei.class;
    }

    @Override
    protected C_Hhknsei valueOf(String pValue) {
        return C_Hhknsei.valueOf(pValue);
    }

    @Override
    protected String toString(C_Hhknsei pValue) {
        return pValue.getValue();
    }
}
