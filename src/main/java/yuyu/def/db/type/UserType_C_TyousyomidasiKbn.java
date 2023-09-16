package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_TyousyomidasiKbn;

/**
 * {@link C_TyousyomidasiKbn 調書見出し区分} の Hibernate ユーザー定義型です。<br />
 * 調書見出し区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_TyousyomidasiKbn extends AbstractUserType<C_TyousyomidasiKbn> {

    @Override
    protected Class<C_TyousyomidasiKbn> returnType() {
        return C_TyousyomidasiKbn.class;
    }

    @Override
    protected C_TyousyomidasiKbn valueOf(String pValue) {
        return C_TyousyomidasiKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_TyousyomidasiKbn pValue) {
        return pValue.getValue();
    }
}
