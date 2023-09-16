package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_Moskeiro;

/**
 * {@link C_Moskeiro 申込経路} の Hibernate ユーザー定義型です。<br />
 * 申込経路 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_Moskeiro extends AbstractUserType<C_Moskeiro> {

    @Override
    protected Class<C_Moskeiro> returnType() {
        return C_Moskeiro.class;
    }

    @Override
    protected C_Moskeiro valueOf(String pValue) {
        return C_Moskeiro.valueOf(pValue);
    }

    @Override
    protected String toString(C_Moskeiro pValue) {
        return pValue.getValue();
    }
}
