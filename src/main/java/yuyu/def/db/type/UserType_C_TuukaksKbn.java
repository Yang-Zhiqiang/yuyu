package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_TuukaksKbn;

/**
 * {@link C_TuukaksKbn 通貨換算区分} の Hibernate ユーザー定義型です。<br />
 * 通貨換算区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_TuukaksKbn extends AbstractUserType<C_TuukaksKbn> {

    @Override
    protected Class<C_TuukaksKbn> returnType() {
        return C_TuukaksKbn.class;
    }

    @Override
    protected C_TuukaksKbn valueOf(String pValue) {
        return C_TuukaksKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_TuukaksKbn pValue) {
        return pValue.getValue();
    }
}
