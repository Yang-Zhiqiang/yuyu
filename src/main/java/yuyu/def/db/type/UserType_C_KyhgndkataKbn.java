package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_KyhgndkataKbn;

/**
 * {@link C_KyhgndkataKbn 給付限度型区分} の Hibernate ユーザー定義型です。<br />
 * 給付限度型区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_KyhgndkataKbn extends AbstractUserType<C_KyhgndkataKbn> {

    @Override
    protected Class<C_KyhgndkataKbn> returnType() {
        return C_KyhgndkataKbn.class;
    }

    @Override
    protected C_KyhgndkataKbn valueOf(String pValue) {
        return C_KyhgndkataKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_KyhgndkataKbn pValue) {
        return pValue.getValue();
    }
}
