package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_Syorilv;

/**
 * {@link C_Syorilv 処理レベル} の Hibernate ユーザー定義型です。<br />
 * 処理レベル 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_Syorilv extends AbstractUserType<C_Syorilv> {

    @Override
    protected Class<C_Syorilv> returnType() {
        return C_Syorilv.class;
    }

    @Override
    protected C_Syorilv valueOf(String pValue) {
        return C_Syorilv.valueOf(pValue);
    }

    @Override
    protected String toString(C_Syorilv pValue) {
        return pValue.getValue();
    }
}
