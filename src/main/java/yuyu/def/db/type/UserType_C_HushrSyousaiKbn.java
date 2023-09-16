package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_HushrSyousaiKbn;

/**
 * {@link C_HushrSyousaiKbn 不支払詳細区分} の Hibernate ユーザー定義型です。<br />
 * 不支払詳細区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_HushrSyousaiKbn extends AbstractUserType<C_HushrSyousaiKbn> {

    @Override
    protected Class<C_HushrSyousaiKbn> returnType() {
        return C_HushrSyousaiKbn.class;
    }

    @Override
    protected C_HushrSyousaiKbn valueOf(String pValue) {
        return C_HushrSyousaiKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_HushrSyousaiKbn pValue) {
        return pValue.getValue();
    }
}
