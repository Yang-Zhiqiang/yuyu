package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_SyukeiKbn;

/**
 * {@link C_SyukeiKbn 集計区分} の Hibernate ユーザー定義型です。<br />
 * 集計区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_SyukeiKbn extends AbstractUserType<C_SyukeiKbn> {

    @Override
    protected Class<C_SyukeiKbn> returnType() {
        return C_SyukeiKbn.class;
    }

    @Override
    protected C_SyukeiKbn valueOf(String pValue) {
        return C_SyukeiKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_SyukeiKbn pValue) {
        return pValue.getValue();
    }
}
