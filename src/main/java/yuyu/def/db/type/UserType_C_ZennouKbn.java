package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_ZennouKbn;

/**
 * {@link C_ZennouKbn 前納区分} の Hibernate ユーザー定義型です。<br />
 * 前納区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_ZennouKbn extends AbstractUserType<C_ZennouKbn> {

    @Override
    protected Class<C_ZennouKbn> returnType() {
        return C_ZennouKbn.class;
    }

    @Override
    protected C_ZennouKbn valueOf(String pValue) {
        return C_ZennouKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_ZennouKbn pValue) {
        return pValue.getValue();
    }
}
