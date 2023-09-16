package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_ZaimukaikeikikouKbn;

/**
 * {@link C_ZaimukaikeikikouKbn 財務会計機構区分} の Hibernate ユーザー定義型です。<br />
 * 財務会計機構区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_ZaimukaikeikikouKbn extends AbstractUserType<C_ZaimukaikeikikouKbn> {

    @Override
    protected Class<C_ZaimukaikeikikouKbn> returnType() {
        return C_ZaimukaikeikikouKbn.class;
    }

    @Override
    protected C_ZaimukaikeikikouKbn valueOf(String pValue) {
        return C_ZaimukaikeikikouKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_ZaimukaikeikikouKbn pValue) {
        return pValue.getValue();
    }
}
