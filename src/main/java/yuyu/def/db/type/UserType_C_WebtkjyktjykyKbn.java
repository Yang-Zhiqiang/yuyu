package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_WebtkjyktjykyKbn;

/**
 * {@link C_WebtkjyktjykyKbn Ｗｅｂ特条回答状況区分} の Hibernate ユーザー定義型です。<br />
 * Ｗｅｂ特条回答状況区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_WebtkjyktjykyKbn extends AbstractUserType<C_WebtkjyktjykyKbn> {

    @Override
    protected Class<C_WebtkjyktjykyKbn> returnType() {
        return C_WebtkjyktjykyKbn.class;
    }

    @Override
    protected C_WebtkjyktjykyKbn valueOf(String pValue) {
        return C_WebtkjyktjykyKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_WebtkjyktjykyKbn pValue) {
        return pValue.getValue();
    }
}
