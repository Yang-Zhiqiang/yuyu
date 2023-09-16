package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_Hrkkeiro;

/**
 * {@link C_Hrkkeiro 払込経路} の Hibernate ユーザー定義型です。<br />
 * 払込経路 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_Hrkkeiro extends AbstractUserType<C_Hrkkeiro> {

    @Override
    protected Class<C_Hrkkeiro> returnType() {
        return C_Hrkkeiro.class;
    }

    @Override
    protected C_Hrkkeiro valueOf(String pValue) {
        return C_Hrkkeiro.valueOf(pValue);
    }

    @Override
    protected String toString(C_Hrkkeiro pValue) {
        return pValue.getValue();
    }
}
