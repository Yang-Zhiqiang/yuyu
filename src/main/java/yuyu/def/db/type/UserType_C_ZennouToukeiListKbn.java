package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_ZennouToukeiListKbn;

/**
 * {@link C_ZennouToukeiListKbn 前納統計リスト区分} の Hibernate ユーザー定義型です。<br />
 * 前納統計リスト区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_ZennouToukeiListKbn extends AbstractUserType<C_ZennouToukeiListKbn> {

    @Override
    protected Class<C_ZennouToukeiListKbn> returnType() {
        return C_ZennouToukeiListKbn.class;
    }

    @Override
    protected C_ZennouToukeiListKbn valueOf(String pValue) {
        return C_ZennouToukeiListKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_ZennouToukeiListKbn pValue) {
        return pValue.getValue();
    }
}
