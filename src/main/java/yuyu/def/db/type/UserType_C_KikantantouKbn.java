package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_KikantantouKbn;

/**
 * {@link C_KikantantouKbn 機関担当区分} の Hibernate ユーザー定義型です。<br />
 * 機関担当区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_KikantantouKbn extends AbstractUserType<C_KikantantouKbn> {

    @Override
    protected Class<C_KikantantouKbn> returnType() {
        return C_KikantantouKbn.class;
    }

    @Override
    protected C_KikantantouKbn valueOf(String pValue) {
        return C_KikantantouKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_KikantantouKbn pValue) {
        return pValue.getValue();
    }
}
