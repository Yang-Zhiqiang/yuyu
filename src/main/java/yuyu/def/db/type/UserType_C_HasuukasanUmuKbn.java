package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_HasuukasanUmuKbn;

/**
 * {@link C_HasuukasanUmuKbn 端数加算有無区分} の Hibernate ユーザー定義型です。<br />
 * 端数加算有無区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_HasuukasanUmuKbn extends AbstractUserType<C_HasuukasanUmuKbn> {

    @Override
    protected Class<C_HasuukasanUmuKbn> returnType() {
        return C_HasuukasanUmuKbn.class;
    }

    @Override
    protected C_HasuukasanUmuKbn valueOf(String pValue) {
        return C_HasuukasanUmuKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_HasuukasanUmuKbn pValue) {
        return pValue.getValue();
    }
}
