package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_SikinouModeIdKbn;

/**
 * {@link C_SikinouModeIdKbn 保険金給付金支払機能モードＩＤ区分} の Hibernate ユーザー定義型です。<br />
 * 保険金給付金支払機能モードＩＤ区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_SikinouModeIdKbn extends AbstractUserType<C_SikinouModeIdKbn> {

    @Override
    protected Class<C_SikinouModeIdKbn> returnType() {
        return C_SikinouModeIdKbn.class;
    }

    @Override
    protected C_SikinouModeIdKbn valueOf(String pValue) {
        return C_SikinouModeIdKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_SikinouModeIdKbn pValue) {
        return pValue.getValue();
    }
}
