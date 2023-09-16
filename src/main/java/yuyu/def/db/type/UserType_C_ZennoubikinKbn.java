package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_ZennoubikinKbn;

/**
 * {@link C_ZennoubikinKbn 前納備金区分} の Hibernate ユーザー定義型です。<br />
 * 前納備金区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_ZennoubikinKbn extends AbstractUserType<C_ZennoubikinKbn> {

    @Override
    protected Class<C_ZennoubikinKbn> returnType() {
        return C_ZennoubikinKbn.class;
    }

    @Override
    protected C_ZennoubikinKbn valueOf(String pValue) {
        return C_ZennoubikinKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_ZennoubikinKbn pValue) {
        return pValue.getValue();
    }
}
