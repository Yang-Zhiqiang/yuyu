package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_TyuuKbn;

/**
 * {@link C_TyuuKbn 中区分} の Hibernate ユーザー定義型です。<br />
 * 中区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_TyuuKbn extends AbstractUserType<C_TyuuKbn> {

    @Override
    protected Class<C_TyuuKbn> returnType() {
        return C_TyuuKbn.class;
    }

    @Override
    protected C_TyuuKbn valueOf(String pValue) {
        return C_TyuuKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_TyuuKbn pValue) {
        return pValue.getValue();
    }
}
