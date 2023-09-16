package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_NengetuKbn;

/**
 * {@link C_NengetuKbn 年月区分} の Hibernate ユーザー定義型です。<br />
 * 年月区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_NengetuKbn extends AbstractUserType<C_NengetuKbn> {

    @Override
    protected Class<C_NengetuKbn> returnType() {
        return C_NengetuKbn.class;
    }

    @Override
    protected C_NengetuKbn valueOf(String pValue) {
        return C_NengetuKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_NengetuKbn pValue) {
        return pValue.getValue();
    }
}
