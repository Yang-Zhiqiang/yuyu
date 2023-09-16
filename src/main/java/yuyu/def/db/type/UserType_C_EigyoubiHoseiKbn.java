package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_EigyoubiHoseiKbn;

/**
 * {@link C_EigyoubiHoseiKbn 営業日補正区分} の Hibernate ユーザー定義型です。<br />
 * 営業日補正区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_EigyoubiHoseiKbn extends AbstractUserType<C_EigyoubiHoseiKbn> {

    @Override
    protected Class<C_EigyoubiHoseiKbn> returnType() {
        return C_EigyoubiHoseiKbn.class;
    }

    @Override
    protected C_EigyoubiHoseiKbn valueOf(String pValue) {
        return C_EigyoubiHoseiKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_EigyoubiHoseiKbn pValue) {
        return pValue.getValue();
    }
}
