package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_ShrhurikaeKbn;

/**
 * {@link C_ShrhurikaeKbn 支払振替区分} の Hibernate ユーザー定義型です。<br />
 * 支払振替区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_ShrhurikaeKbn extends AbstractUserType<C_ShrhurikaeKbn> {

    @Override
    protected Class<C_ShrhurikaeKbn> returnType() {
        return C_ShrhurikaeKbn.class;
    }

    @Override
    protected C_ShrhurikaeKbn valueOf(String pValue) {
        return C_ShrhurikaeKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_ShrhurikaeKbn pValue) {
        return pValue.getValue();
    }
}
