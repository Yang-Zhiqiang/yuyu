package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_Znnhrkkeiro;

/**
 * {@link C_Znnhrkkeiro 前納後払込経路} の Hibernate ユーザー定義型です。<br />
 * 前納後払込経路 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_Znnhrkkeiro extends AbstractUserType<C_Znnhrkkeiro> {

    @Override
    protected Class<C_Znnhrkkeiro> returnType() {
        return C_Znnhrkkeiro.class;
    }

    @Override
    protected C_Znnhrkkeiro valueOf(String pValue) {
        return C_Znnhrkkeiro.valueOf(pValue);
    }

    @Override
    protected String toString(C_Znnhrkkeiro pValue) {
        return pValue.getValue();
    }
}
