package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_NsyknKbn;

/**
 * {@link C_NsyknKbn 入出金区分} の Hibernate ユーザー定義型です。<br />
 * 入出金区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_NsyknKbn extends AbstractUserType<C_NsyknKbn> {

    @Override
    protected Class<C_NsyknKbn> returnType() {
        return C_NsyknKbn.class;
    }

    @Override
    protected C_NsyknKbn valueOf(String pValue) {
        return C_NsyknKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_NsyknKbn pValue) {
        return pValue.getValue();
    }
}
