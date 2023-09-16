package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_UriagekekkaKbn;

/**
 * {@link C_UriagekekkaKbn 売上結果区分} の Hibernate ユーザー定義型です。<br />
 * 売上結果区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_UriagekekkaKbn extends AbstractUserType<C_UriagekekkaKbn> {

    @Override
    protected Class<C_UriagekekkaKbn> returnType() {
        return C_UriagekekkaKbn.class;
    }

    @Override
    protected C_UriagekekkaKbn valueOf(String pValue) {
        return C_UriagekekkaKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_UriagekekkaKbn pValue) {
        return pValue.getValue();
    }
}
