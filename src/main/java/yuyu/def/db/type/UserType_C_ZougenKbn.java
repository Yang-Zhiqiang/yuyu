package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_ZougenKbn;

/**
 * {@link C_ZougenKbn 増減区分} の Hibernate ユーザー定義型です。<br />
 * 増減区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_ZougenKbn extends AbstractUserType<C_ZougenKbn> {

    @Override
    protected Class<C_ZougenKbn> returnType() {
        return C_ZougenKbn.class;
    }

    @Override
    protected C_ZougenKbn valueOf(String pValue) {
        return C_ZougenKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_ZougenKbn pValue) {
        return pValue.getValue();
    }
}
