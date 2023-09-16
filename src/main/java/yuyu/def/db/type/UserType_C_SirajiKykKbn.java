package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_SirajiKykKbn;

/**
 * {@link C_SirajiKykKbn 白地契約区分} の Hibernate ユーザー定義型です。<br />
 * 白地契約区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_SirajiKykKbn extends AbstractUserType<C_SirajiKykKbn> {

    @Override
    protected Class<C_SirajiKykKbn> returnType() {
        return C_SirajiKykKbn.class;
    }

    @Override
    protected C_SirajiKykKbn valueOf(String pValue) {
        return C_SirajiKykKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_SirajiKykKbn pValue) {
        return pValue.getValue();
    }
}
