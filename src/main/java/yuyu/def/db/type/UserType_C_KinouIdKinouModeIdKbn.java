package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_KinouIdKinouModeIdKbn;

/**
 * {@link C_KinouIdKinouModeIdKbn 機能ＩＤ機能モードＩＤ区分} の Hibernate ユーザー定義型です。<br />
 * 機能ＩＤ機能モードＩＤ区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_KinouIdKinouModeIdKbn extends AbstractUserType<C_KinouIdKinouModeIdKbn> {

    @Override
    protected Class<C_KinouIdKinouModeIdKbn> returnType() {
        return C_KinouIdKinouModeIdKbn.class;
    }

    @Override
    protected C_KinouIdKinouModeIdKbn valueOf(String pValue) {
        return C_KinouIdKinouModeIdKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_KinouIdKinouModeIdKbn pValue) {
        return pValue.getValue();
    }
}
