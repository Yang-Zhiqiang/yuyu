package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_NengappiKbn;

/**
 * {@link C_NengappiKbn 年月日区分} の Hibernate ユーザー定義型です。<br />
 * 年月日区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_NengappiKbn extends AbstractUserType<C_NengappiKbn> {

    @Override
    protected Class<C_NengappiKbn> returnType() {
        return C_NengappiKbn.class;
    }

    @Override
    protected C_NengappiKbn valueOf(String pValue) {
        return C_NengappiKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_NengappiKbn pValue) {
        return pValue.getValue();
    }
}
