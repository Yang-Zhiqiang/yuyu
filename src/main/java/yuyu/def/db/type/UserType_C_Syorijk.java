package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_Syorijk;

/**
 * {@link C_Syorijk 処理状況} の Hibernate ユーザー定義型です。<br />
 * 処理状況 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_Syorijk extends AbstractUserType<C_Syorijk> {

    @Override
    protected Class<C_Syorijk> returnType() {
        return C_Syorijk.class;
    }

    @Override
    protected C_Syorijk valueOf(String pValue) {
        return C_Syorijk.valueOf(pValue);
    }

    @Override
    protected String toString(C_Syorijk pValue) {
        return pValue.getValue();
    }
}
