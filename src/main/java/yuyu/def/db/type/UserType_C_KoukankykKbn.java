package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_KoukankykKbn;

/**
 * {@link C_KoukankykKbn 交換契約区分} の Hibernate ユーザー定義型です。<br />
 * 交換契約区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_KoukankykKbn extends AbstractUserType<C_KoukankykKbn> {

    @Override
    protected Class<C_KoukankykKbn> returnType() {
        return C_KoukankykKbn.class;
    }

    @Override
    protected C_KoukankykKbn valueOf(String pValue) {
        return C_KoukankykKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_KoukankykKbn pValue) {
        return pValue.getValue();
    }
}
