package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_SinsaGendoKknKbn;

/**
 * {@link C_SinsaGendoKknKbn 審査限度期間区分} の Hibernate ユーザー定義型です。<br />
 * 審査限度期間区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_SinsaGendoKknKbn extends AbstractUserType<C_SinsaGendoKknKbn> {

    @Override
    protected Class<C_SinsaGendoKknKbn> returnType() {
        return C_SinsaGendoKknKbn.class;
    }

    @Override
    protected C_SinsaGendoKknKbn valueOf(String pValue) {
        return C_SinsaGendoKknKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_SinsaGendoKknKbn pValue) {
        return pValue.getValue();
    }
}
