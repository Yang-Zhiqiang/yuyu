package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_NkgnsHosyourituKbn;

/**
 * {@link C_NkgnsHosyourituKbn 年金原資最低保証率区分} の Hibernate ユーザー定義型です。<br />
 * 年金原資最低保証率区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_NkgnsHosyourituKbn extends AbstractUserType<C_NkgnsHosyourituKbn> {

    @Override
    protected Class<C_NkgnsHosyourituKbn> returnType() {
        return C_NkgnsHosyourituKbn.class;
    }

    @Override
    protected C_NkgnsHosyourituKbn valueOf(String pValue) {
        return C_NkgnsHosyourituKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_NkgnsHosyourituKbn pValue) {
        return pValue.getValue();
    }
}
