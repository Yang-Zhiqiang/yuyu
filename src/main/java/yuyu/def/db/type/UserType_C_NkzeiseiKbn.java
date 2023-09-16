package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_NkzeiseiKbn;

/**
 * {@link C_NkzeiseiKbn 年金税制区分} の Hibernate ユーザー定義型です。<br />
 * 年金税制区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_NkzeiseiKbn extends AbstractUserType<C_NkzeiseiKbn> {

    @Override
    protected Class<C_NkzeiseiKbn> returnType() {
        return C_NkzeiseiKbn.class;
    }

    @Override
    protected C_NkzeiseiKbn valueOf(String pValue) {
        return C_NkzeiseiKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_NkzeiseiKbn pValue) {
        return pValue.getValue();
    }
}
