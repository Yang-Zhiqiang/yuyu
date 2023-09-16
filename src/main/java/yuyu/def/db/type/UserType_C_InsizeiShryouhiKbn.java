package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_InsizeiShryouhiKbn;

/**
 * {@link C_InsizeiShryouhiKbn 印紙税支払要否区分} の Hibernate ユーザー定義型です。<br />
 * 印紙税支払要否区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_InsizeiShryouhiKbn extends AbstractUserType<C_InsizeiShryouhiKbn> {

    @Override
    protected Class<C_InsizeiShryouhiKbn> returnType() {
        return C_InsizeiShryouhiKbn.class;
    }

    @Override
    protected C_InsizeiShryouhiKbn valueOf(String pValue) {
        return C_InsizeiShryouhiKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_InsizeiShryouhiKbn pValue) {
        return pValue.getValue();
    }
}
