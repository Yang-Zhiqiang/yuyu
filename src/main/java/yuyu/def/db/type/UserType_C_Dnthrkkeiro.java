package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_Dnthrkkeiro;

/**
 * {@link C_Dnthrkkeiro 団体払込経路} の Hibernate ユーザー定義型です。<br />
 * 団体払込経路 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_Dnthrkkeiro extends AbstractUserType<C_Dnthrkkeiro> {

    @Override
    protected Class<C_Dnthrkkeiro> returnType() {
        return C_Dnthrkkeiro.class;
    }

    @Override
    protected C_Dnthrkkeiro valueOf(String pValue) {
        return C_Dnthrkkeiro.valueOf(pValue);
    }

    @Override
    protected String toString(C_Dnthrkkeiro pValue) {
        return pValue.getValue();
    }
}
