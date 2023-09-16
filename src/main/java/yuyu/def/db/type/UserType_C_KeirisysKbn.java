package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_KeirisysKbn;

/**
 * {@link C_KeirisysKbn 経理システム区分} の Hibernate ユーザー定義型です。<br />
 * 経理システム区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_KeirisysKbn extends AbstractUserType<C_KeirisysKbn> {

    @Override
    protected Class<C_KeirisysKbn> returnType() {
        return C_KeirisysKbn.class;
    }

    @Override
    protected C_KeirisysKbn valueOf(String pValue) {
        return C_KeirisysKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_KeirisysKbn pValue) {
        return pValue.getValue();
    }
}
