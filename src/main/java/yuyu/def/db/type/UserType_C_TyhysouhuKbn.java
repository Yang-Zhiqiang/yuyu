package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_TyhysouhuKbn;

/**
 * {@link C_TyhysouhuKbn 帳票送付区分} の Hibernate ユーザー定義型です。<br />
 * 帳票送付区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_TyhysouhuKbn extends AbstractUserType<C_TyhysouhuKbn> {

    @Override
    protected Class<C_TyhysouhuKbn> returnType() {
        return C_TyhysouhuKbn.class;
    }

    @Override
    protected C_TyhysouhuKbn valueOf(String pValue) {
        return C_TyhysouhuKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_TyhysouhuKbn pValue) {
        return pValue.getValue();
    }
}
