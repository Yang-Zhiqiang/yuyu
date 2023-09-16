package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_Dattaikeiro;

/**
 * {@link C_Dattaikeiro 脱退経路} の Hibernate ユーザー定義型です。<br />
 * 脱退経路 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_Dattaikeiro extends AbstractUserType<C_Dattaikeiro> {

    @Override
    protected Class<C_Dattaikeiro> returnType() {
        return C_Dattaikeiro.class;
    }

    @Override
    protected C_Dattaikeiro valueOf(String pValue) {
        return C_Dattaikeiro.valueOf(pValue);
    }

    @Override
    protected String toString(C_Dattaikeiro pValue) {
        return pValue.getValue();
    }
}
