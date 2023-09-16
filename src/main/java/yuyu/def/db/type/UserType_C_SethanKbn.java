package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_SethanKbn;

/**
 * {@link C_SethanKbn セット販売区分} の Hibernate ユーザー定義型です。<br />
 * セット販売区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_SethanKbn extends AbstractUserType<C_SethanKbn> {

    @Override
    protected Class<C_SethanKbn> returnType() {
        return C_SethanKbn.class;
    }

    @Override
    protected C_SethanKbn valueOf(String pValue) {
        return C_SethanKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_SethanKbn pValue) {
        return pValue.getValue();
    }
}
