package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_NykshrKbn;

/**
 * {@link C_NykshrKbn 入金支払区分} の Hibernate ユーザー定義型です。<br />
 * 入金支払区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_NykshrKbn extends AbstractUserType<C_NykshrKbn> {

    @Override
    protected Class<C_NykshrKbn> returnType() {
        return C_NykshrKbn.class;
    }

    @Override
    protected C_NykshrKbn valueOf(String pValue) {
        return C_NykshrKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_NykshrKbn pValue) {
        return pValue.getValue();
    }
}
