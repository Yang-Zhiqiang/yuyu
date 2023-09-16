package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_UkeKeiro;

/**
 * {@link C_UkeKeiro 受付経路} の Hibernate ユーザー定義型です。<br />
 * 受付経路 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_UkeKeiro extends AbstractUserType<C_UkeKeiro> {

    @Override
    protected Class<C_UkeKeiro> returnType() {
        return C_UkeKeiro.class;
    }

    @Override
    protected C_UkeKeiro valueOf(String pValue) {
        return C_UkeKeiro.valueOf(pValue);
    }

    @Override
    protected String toString(C_UkeKeiro pValue) {
        return pValue.getValue();
    }
}
