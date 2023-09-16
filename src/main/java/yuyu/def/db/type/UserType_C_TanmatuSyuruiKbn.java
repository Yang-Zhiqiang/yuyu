package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_TanmatuSyuruiKbn;

/**
 * {@link C_TanmatuSyuruiKbn 端末種類区分} の Hibernate ユーザー定義型です。<br />
 * 端末種類区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_TanmatuSyuruiKbn extends AbstractUserType<C_TanmatuSyuruiKbn> {

    @Override
    protected Class<C_TanmatuSyuruiKbn> returnType() {
        return C_TanmatuSyuruiKbn.class;
    }

    @Override
    protected C_TanmatuSyuruiKbn valueOf(String pValue) {
        return C_TanmatuSyuruiKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_TanmatuSyuruiKbn pValue) {
        return pValue.getValue();
    }
}
