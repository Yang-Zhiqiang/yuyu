package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_UmuKbn;

/**
 * {@link C_UmuKbn 有無区分} の Hibernate ユーザー定義型です。<br />
 * 有無区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_UmuKbn extends AbstractUserType<C_UmuKbn> {

    @Override
    protected Class<C_UmuKbn> returnType() {
        return C_UmuKbn.class;
    }

    @Override
    protected C_UmuKbn valueOf(String pValue) {
        return C_UmuKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_UmuKbn pValue) {
        return pValue.getValue();
    }
}
