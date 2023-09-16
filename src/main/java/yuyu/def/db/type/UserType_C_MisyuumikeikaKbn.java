package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_MisyuumikeikaKbn;

/**
 * {@link C_MisyuumikeikaKbn 未収未経過区分} の Hibernate ユーザー定義型です。<br />
 * 未収未経過区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_MisyuumikeikaKbn extends AbstractUserType<C_MisyuumikeikaKbn> {

    @Override
    protected Class<C_MisyuumikeikaKbn> returnType() {
        return C_MisyuumikeikaKbn.class;
    }

    @Override
    protected C_MisyuumikeikaKbn valueOf(String pValue) {
        return C_MisyuumikeikaKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_MisyuumikeikaKbn pValue) {
        return pValue.getValue();
    }
}
