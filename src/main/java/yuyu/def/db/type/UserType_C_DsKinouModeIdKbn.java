package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_DsKinouModeIdKbn;

/**
 * {@link C_DsKinouModeIdKbn ＤＳ機能モードＩＤ区分} の Hibernate ユーザー定義型です。<br />
 * ＤＳ機能モードＩＤ区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_DsKinouModeIdKbn extends AbstractUserType<C_DsKinouModeIdKbn> {

    @Override
    protected Class<C_DsKinouModeIdKbn> returnType() {
        return C_DsKinouModeIdKbn.class;
    }

    @Override
    protected C_DsKinouModeIdKbn valueOf(String pValue) {
        return C_DsKinouModeIdKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_DsKinouModeIdKbn pValue) {
        return pValue.getValue();
    }
}
