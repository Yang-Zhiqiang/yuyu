package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_GaikashrKahiKbn;

/**
 * {@link C_GaikashrKahiKbn 外貨支払可否区分} の Hibernate ユーザー定義型です。<br />
 * 外貨支払可否区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_GaikashrKahiKbn extends AbstractUserType<C_GaikashrKahiKbn> {

    @Override
    protected Class<C_GaikashrKahiKbn> returnType() {
        return C_GaikashrKahiKbn.class;
    }

    @Override
    protected C_GaikashrKahiKbn valueOf(String pValue) {
        return C_GaikashrKahiKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_GaikashrKahiKbn pValue) {
        return pValue.getValue();
    }
}
