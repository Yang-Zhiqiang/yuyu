package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_KktyouhyousyuruiKbn;

/**
 * {@link C_KktyouhyousyuruiKbn 契約管理帳票種類区分} の Hibernate ユーザー定義型です。<br />
 * 契約管理帳票種類区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_KktyouhyousyuruiKbn extends AbstractUserType<C_KktyouhyousyuruiKbn> {

    @Override
    protected Class<C_KktyouhyousyuruiKbn> returnType() {
        return C_KktyouhyousyuruiKbn.class;
    }

    @Override
    protected C_KktyouhyousyuruiKbn valueOf(String pValue) {
        return C_KktyouhyousyuruiKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_KktyouhyousyuruiKbn pValue) {
        return pValue.getValue();
    }
}
