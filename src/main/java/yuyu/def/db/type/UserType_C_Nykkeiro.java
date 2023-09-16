package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_Nykkeiro;

/**
 * {@link C_Nykkeiro 入金経路} の Hibernate ユーザー定義型です。<br />
 * 入金経路 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_Nykkeiro extends AbstractUserType<C_Nykkeiro> {

    @Override
    protected Class<C_Nykkeiro> returnType() {
        return C_Nykkeiro.class;
    }

    @Override
    protected C_Nykkeiro valueOf(String pValue) {
        return C_Nykkeiro.valueOf(pValue);
    }

    @Override
    protected String toString(C_Nykkeiro pValue) {
        return pValue.getValue();
    }
}
