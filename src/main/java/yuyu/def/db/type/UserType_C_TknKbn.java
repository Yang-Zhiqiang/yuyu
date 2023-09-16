package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_TknKbn;

/**
 * {@link C_TknKbn 特認区分} の Hibernate ユーザー定義型です。<br />
 * 特認区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_TknKbn extends AbstractUserType<C_TknKbn> {

    @Override
    protected Class<C_TknKbn> returnType() {
        return C_TknKbn.class;
    }

    @Override
    protected C_TknKbn valueOf(String pValue) {
        return C_TknKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_TknKbn pValue) {
        return pValue.getValue();
    }
}
