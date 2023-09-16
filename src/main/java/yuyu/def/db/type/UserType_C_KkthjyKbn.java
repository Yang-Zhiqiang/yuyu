package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_KkthjyKbn;

/**
 * {@link C_KkthjyKbn 告知報状区分} の Hibernate ユーザー定義型です。<br />
 * 告知報状区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_KkthjyKbn extends AbstractUserType<C_KkthjyKbn> {

    @Override
    protected Class<C_KkthjyKbn> returnType() {
        return C_KkthjyKbn.class;
    }

    @Override
    protected C_KkthjyKbn valueOf(String pValue) {
        return C_KkthjyKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_KkthjyKbn pValue) {
        return pValue.getValue();
    }
}
