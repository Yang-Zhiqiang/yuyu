package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_SykDrtenTsryShrKbn;

/**
 * {@link C_SykDrtenTsryShrKbn 紹介代理店手数料支払区分} の Hibernate ユーザー定義型です。<br />
 * 紹介代理店手数料支払区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_SykDrtenTsryShrKbn extends AbstractUserType<C_SykDrtenTsryShrKbn> {

    @Override
    protected Class<C_SykDrtenTsryShrKbn> returnType() {
        return C_SykDrtenTsryShrKbn.class;
    }

    @Override
    protected C_SykDrtenTsryShrKbn valueOf(String pValue) {
        return C_SykDrtenTsryShrKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_SykDrtenTsryShrKbn pValue) {
        return pValue.getValue();
    }
}
