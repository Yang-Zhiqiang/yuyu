package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_SghshrgeninKbn;

/**
 * {@link C_SghshrgeninKbn 災害割増不支払原因区分} の Hibernate ユーザー定義型です。<br />
 * 災害割増不支払原因区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_SghshrgeninKbn extends AbstractUserType<C_SghshrgeninKbn> {

    @Override
    protected Class<C_SghshrgeninKbn> returnType() {
        return C_SghshrgeninKbn.class;
    }

    @Override
    protected C_SghshrgeninKbn valueOf(String pValue) {
        return C_SghshrgeninKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_SghshrgeninKbn pValue) {
        return pValue.getValue();
    }
}
