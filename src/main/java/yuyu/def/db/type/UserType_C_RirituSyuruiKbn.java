package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_RirituSyuruiKbn;

/**
 * {@link C_RirituSyuruiKbn 利率種類区分} の Hibernate ユーザー定義型です。<br />
 * 利率種類区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_RirituSyuruiKbn extends AbstractUserType<C_RirituSyuruiKbn> {

    @Override
    protected Class<C_RirituSyuruiKbn> returnType() {
        return C_RirituSyuruiKbn.class;
    }

    @Override
    protected C_RirituSyuruiKbn valueOf(String pValue) {
        return C_RirituSyuruiKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_RirituSyuruiKbn pValue) {
        return pValue.getValue();
    }
}
