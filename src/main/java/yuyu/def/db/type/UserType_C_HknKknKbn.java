package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_HknKknKbn;

/**
 * {@link C_HknKknKbn 保険期間区分} の Hibernate ユーザー定義型です。<br />
 * 保険期間区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_HknKknKbn extends AbstractUserType<C_HknKknKbn> {

    @Override
    protected Class<C_HknKknKbn> returnType() {
        return C_HknKknKbn.class;
    }

    @Override
    protected C_HknKknKbn valueOf(String pValue) {
        return C_HknKknKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_HknKknKbn pValue) {
        return pValue.getValue();
    }
}
