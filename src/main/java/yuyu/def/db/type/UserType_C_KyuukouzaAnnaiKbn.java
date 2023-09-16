package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_KyuukouzaAnnaiKbn;

/**
 * {@link C_KyuukouzaAnnaiKbn 旧口座案内区分} の Hibernate ユーザー定義型です。<br />
 * 旧口座案内区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_KyuukouzaAnnaiKbn extends AbstractUserType<C_KyuukouzaAnnaiKbn> {

    @Override
    protected Class<C_KyuukouzaAnnaiKbn> returnType() {
        return C_KyuukouzaAnnaiKbn.class;
    }

    @Override
    protected C_KyuukouzaAnnaiKbn valueOf(String pValue) {
        return C_KyuukouzaAnnaiKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_KyuukouzaAnnaiKbn pValue) {
        return pValue.getValue();
    }
}
