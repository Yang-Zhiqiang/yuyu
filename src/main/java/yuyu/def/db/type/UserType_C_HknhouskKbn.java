package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_HknhouskKbn;

/**
 * {@link C_HknhouskKbn 保険法施行区分} の Hibernate ユーザー定義型です。<br />
 * 保険法施行区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_HknhouskKbn extends AbstractUserType<C_HknhouskKbn> {

    @Override
    protected Class<C_HknhouskKbn> returnType() {
        return C_HknhouskKbn.class;
    }

    @Override
    protected C_HknhouskKbn valueOf(String pValue) {
        return C_HknhouskKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_HknhouskKbn pValue) {
        return pValue.getValue();
    }
}
