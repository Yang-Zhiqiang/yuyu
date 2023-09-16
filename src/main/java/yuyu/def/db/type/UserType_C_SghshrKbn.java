package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_SghshrKbn;

/**
 * {@link C_SghshrKbn 災害割増不支払区分} の Hibernate ユーザー定義型です。<br />
 * 災害割増不支払区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_SghshrKbn extends AbstractUserType<C_SghshrKbn> {

    @Override
    protected Class<C_SghshrKbn> returnType() {
        return C_SghshrKbn.class;
    }

    @Override
    protected C_SghshrKbn valueOf(String pValue) {
        return C_SghshrKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_SghshrKbn pValue) {
        return pValue.getValue();
    }
}
