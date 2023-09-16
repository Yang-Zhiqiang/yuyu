package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_DaisinHiDaisinKbn;

/**
 * {@link C_DaisinHiDaisinKbn 代申非代申区分} の Hibernate ユーザー定義型です。<br />
 * 代申非代申区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_DaisinHiDaisinKbn extends AbstractUserType<C_DaisinHiDaisinKbn> {

    @Override
    protected Class<C_DaisinHiDaisinKbn> returnType() {
        return C_DaisinHiDaisinKbn.class;
    }

    @Override
    protected C_DaisinHiDaisinKbn valueOf(String pValue) {
        return C_DaisinHiDaisinKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_DaisinHiDaisinKbn pValue) {
        return pValue.getValue();
    }
}
