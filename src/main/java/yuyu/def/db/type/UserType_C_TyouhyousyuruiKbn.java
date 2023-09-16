package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_TyouhyousyuruiKbn;

/**
 * {@link C_TyouhyousyuruiKbn 帳票種類区分} の Hibernate ユーザー定義型です。<br />
 * 帳票種類区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_TyouhyousyuruiKbn extends AbstractUserType<C_TyouhyousyuruiKbn> {

    @Override
    protected Class<C_TyouhyousyuruiKbn> returnType() {
        return C_TyouhyousyuruiKbn.class;
    }

    @Override
    protected C_TyouhyousyuruiKbn valueOf(String pValue) {
        return C_TyouhyousyuruiKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_TyouhyousyuruiKbn pValue) {
        return pValue.getValue();
    }
}
