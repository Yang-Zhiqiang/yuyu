package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_KzkykdouKbn;

/**
 * {@link C_KzkykdouKbn 口座名義契約者同一人区分} の Hibernate ユーザー定義型です。<br />
 * 口座名義契約者同一人区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_KzkykdouKbn extends AbstractUserType<C_KzkykdouKbn> {

    @Override
    protected Class<C_KzkykdouKbn> returnType() {
        return C_KzkykdouKbn.class;
    }

    @Override
    protected C_KzkykdouKbn valueOf(String pValue) {
        return C_KzkykdouKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_KzkykdouKbn pValue) {
        return pValue.getValue();
    }
}
