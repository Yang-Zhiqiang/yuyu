package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_HasuusyoriKbn;

/**
 * {@link C_HasuusyoriKbn 端数処理区分} の Hibernate ユーザー定義型です。<br />
 * 端数処理区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_HasuusyoriKbn extends AbstractUserType<C_HasuusyoriKbn> {

    @Override
    protected Class<C_HasuusyoriKbn> returnType() {
        return C_HasuusyoriKbn.class;
    }

    @Override
    protected C_HasuusyoriKbn valueOf(String pValue) {
        return C_HasuusyoriKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_HasuusyoriKbn pValue) {
        return pValue.getValue();
    }
}
