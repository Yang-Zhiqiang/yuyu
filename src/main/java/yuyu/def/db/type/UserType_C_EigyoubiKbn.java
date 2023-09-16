package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_EigyoubiKbn;

/**
 * {@link C_EigyoubiKbn 営業日区分} の Hibernate ユーザー定義型です。<br />
 * 営業日区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_EigyoubiKbn extends AbstractUserType<C_EigyoubiKbn> {

    @Override
    protected Class<C_EigyoubiKbn> returnType() {
        return C_EigyoubiKbn.class;
    }

    @Override
    protected C_EigyoubiKbn valueOf(String pValue) {
        return C_EigyoubiKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_EigyoubiKbn pValue) {
        return pValue.getValue();
    }
}
