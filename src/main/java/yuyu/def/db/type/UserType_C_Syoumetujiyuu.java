package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_Syoumetujiyuu;

/**
 * {@link C_Syoumetujiyuu 消滅事由} の Hibernate ユーザー定義型です。<br />
 * 消滅事由 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_Syoumetujiyuu extends AbstractUserType<C_Syoumetujiyuu> {

    @Override
    protected Class<C_Syoumetujiyuu> returnType() {
        return C_Syoumetujiyuu.class;
    }

    @Override
    protected C_Syoumetujiyuu valueOf(String pValue) {
        return C_Syoumetujiyuu.valueOf(pValue);
    }

    @Override
    protected String toString(C_Syoumetujiyuu pValue) {
        return pValue.getValue();
    }
}
