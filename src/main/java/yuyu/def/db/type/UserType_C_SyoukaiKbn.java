package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_SyoukaiKbn;

/**
 * {@link C_SyoukaiKbn 照会区分} の Hibernate ユーザー定義型です。<br />
 * 照会区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_SyoukaiKbn extends AbstractUserType<C_SyoukaiKbn> {

    @Override
    protected Class<C_SyoukaiKbn> returnType() {
        return C_SyoukaiKbn.class;
    }

    @Override
    protected C_SyoukaiKbn valueOf(String pValue) {
        return C_SyoukaiKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_SyoukaiKbn pValue) {
        return pValue.getValue();
    }
}
