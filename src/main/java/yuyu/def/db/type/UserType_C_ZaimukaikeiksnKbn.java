package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_ZaimukaikeiksnKbn;

/**
 * {@link C_ZaimukaikeiksnKbn 財務会計決算区分} の Hibernate ユーザー定義型です。<br />
 * 財務会計決算区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_ZaimukaikeiksnKbn extends AbstractUserType<C_ZaimukaikeiksnKbn> {

    @Override
    protected Class<C_ZaimukaikeiksnKbn> returnType() {
        return C_ZaimukaikeiksnKbn.class;
    }

    @Override
    protected C_ZaimukaikeiksnKbn valueOf(String pValue) {
        return C_ZaimukaikeiksnKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_ZaimukaikeiksnKbn pValue) {
        return pValue.getValue();
    }
}
