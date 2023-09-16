package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_RateSyoukaiKbn;

/**
 * {@link C_RateSyoukaiKbn レート照会区分} の Hibernate ユーザー定義型です。<br />
 * レート照会区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_RateSyoukaiKbn extends AbstractUserType<C_RateSyoukaiKbn> {

    @Override
    protected Class<C_RateSyoukaiKbn> returnType() {
        return C_RateSyoukaiKbn.class;
    }

    @Override
    protected C_RateSyoukaiKbn valueOf(String pValue) {
        return C_RateSyoukaiKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_RateSyoukaiKbn pValue) {
        return pValue.getValue();
    }
}
