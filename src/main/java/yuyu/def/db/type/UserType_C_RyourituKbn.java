package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_RyourituKbn;

/**
 * {@link C_RyourituKbn 料率区分} の Hibernate ユーザー定義型です。<br />
 * 料率区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_RyourituKbn extends AbstractUserType<C_RyourituKbn> {

    @Override
    protected Class<C_RyourituKbn> returnType() {
        return C_RyourituKbn.class;
    }

    @Override
    protected C_RyourituKbn valueOf(String pValue) {
        return C_RyourituKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_RyourituKbn pValue) {
        return pValue.getValue();
    }
}
