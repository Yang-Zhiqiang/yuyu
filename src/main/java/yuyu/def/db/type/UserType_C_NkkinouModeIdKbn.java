package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_NkkinouModeIdKbn;

/**
 * {@link C_NkkinouModeIdKbn 年金支払機能モードＩＤ区分} の Hibernate ユーザー定義型です。<br />
 * 年金支払機能モードＩＤ区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_NkkinouModeIdKbn extends AbstractUserType<C_NkkinouModeIdKbn> {

    @Override
    protected Class<C_NkkinouModeIdKbn> returnType() {
        return C_NkkinouModeIdKbn.class;
    }

    @Override
    protected C_NkkinouModeIdKbn valueOf(String pValue) {
        return C_NkkinouModeIdKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_NkkinouModeIdKbn pValue) {
        return pValue.getValue();
    }
}
