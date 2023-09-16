package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_BzkinouModeIdKbn;

/**
 * {@link C_BzkinouModeIdKbn 業務共通機能モードＩＤ区分} の Hibernate ユーザー定義型です。<br />
 * 業務共通機能モードＩＤ区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_BzkinouModeIdKbn extends AbstractUserType<C_BzkinouModeIdKbn> {

    @Override
    protected Class<C_BzkinouModeIdKbn> returnType() {
        return C_BzkinouModeIdKbn.class;
    }

    @Override
    protected C_BzkinouModeIdKbn valueOf(String pValue) {
        return C_BzkinouModeIdKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_BzkinouModeIdKbn pValue) {
        return pValue.getValue();
    }
}
