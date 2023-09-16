package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_NenkkntknKbn;

/**
 * {@link C_NenkkntknKbn 年齢期間特認区分} の Hibernate ユーザー定義型です。<br />
 * 年齢期間特認区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_NenkkntknKbn extends AbstractUserType<C_NenkkntknKbn> {

    @Override
    protected Class<C_NenkkntknKbn> returnType() {
        return C_NenkkntknKbn.class;
    }

    @Override
    protected C_NenkkntknKbn valueOf(String pValue) {
        return C_NenkkntknKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_NenkkntknKbn pValue) {
        return pValue.getValue();
    }
}
