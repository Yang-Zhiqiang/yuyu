package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_TyokusouhtkekKbn;

/**
 * {@link C_TyokusouhtkekKbn 直送判定結果区分} の Hibernate ユーザー定義型です。<br />
 * 直送判定結果区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_TyokusouhtkekKbn extends AbstractUserType<C_TyokusouhtkekKbn> {

    @Override
    protected Class<C_TyokusouhtkekKbn> returnType() {
        return C_TyokusouhtkekKbn.class;
    }

    @Override
    protected C_TyokusouhtkekKbn valueOf(String pValue) {
        return C_TyokusouhtkekKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_TyokusouhtkekKbn pValue) {
        return pValue.getValue();
    }
}
