package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_AuthoriKbn;

/**
 * {@link C_AuthoriKbn オーソリ区分} の Hibernate ユーザー定義型です。<br />
 * オーソリ区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_AuthoriKbn extends AbstractUserType<C_AuthoriKbn> {

    @Override
    protected Class<C_AuthoriKbn> returnType() {
        return C_AuthoriKbn.class;
    }

    @Override
    protected C_AuthoriKbn valueOf(String pValue) {
        return C_AuthoriKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_AuthoriKbn pValue) {
        return pValue.getValue();
    }
}
