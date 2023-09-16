package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_KktsinsaKbn;

/**
 * {@link C_KktsinsaKbn 告知診査区分} の Hibernate ユーザー定義型です。<br />
 * 告知診査区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_KktsinsaKbn extends AbstractUserType<C_KktsinsaKbn> {

    @Override
    protected Class<C_KktsinsaKbn> returnType() {
        return C_KktsinsaKbn.class;
    }

    @Override
    protected C_KktsinsaKbn valueOf(String pValue) {
        return C_KktsinsaKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_KktsinsaKbn pValue) {
        return pValue.getValue();
    }
}
