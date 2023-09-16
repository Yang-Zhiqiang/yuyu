package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_DrtensyKbn;

/**
 * {@link C_DrtensyKbn 代理店種別区分} の Hibernate ユーザー定義型です。<br />
 * 代理店種別区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_DrtensyKbn extends AbstractUserType<C_DrtensyKbn> {

    @Override
    protected Class<C_DrtensyKbn> returnType() {
        return C_DrtensyKbn.class;
    }

    @Override
    protected C_DrtensyKbn valueOf(String pValue) {
        return C_DrtensyKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_DrtensyKbn pValue) {
        return pValue.getValue();
    }
}
