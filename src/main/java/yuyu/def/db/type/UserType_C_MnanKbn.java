package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_MnanKbn;

/**
 * {@link C_MnanKbn 満了案内区分} の Hibernate ユーザー定義型です。<br />
 * 満了案内区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_MnanKbn extends AbstractUserType<C_MnanKbn> {

    @Override
    protected Class<C_MnanKbn> returnType() {
        return C_MnanKbn.class;
    }

    @Override
    protected C_MnanKbn valueOf(String pValue) {
        return C_MnanKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_MnanKbn pValue) {
        return pValue.getValue();
    }
}
