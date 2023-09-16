package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_KrkPayEasyHrkmyousiNkKbn;

/**
 * {@link C_KrkPayEasyHrkmyousiNkKbn 仮受ペイジー振込用紙入金区分} の Hibernate ユーザー定義型です。<br />
 * 仮受ペイジー振込用紙入金区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_KrkPayEasyHrkmyousiNkKbn extends AbstractUserType<C_KrkPayEasyHrkmyousiNkKbn> {

    @Override
    protected Class<C_KrkPayEasyHrkmyousiNkKbn> returnType() {
        return C_KrkPayEasyHrkmyousiNkKbn.class;
    }

    @Override
    protected C_KrkPayEasyHrkmyousiNkKbn valueOf(String pValue) {
        return C_KrkPayEasyHrkmyousiNkKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_KrkPayEasyHrkmyousiNkKbn pValue) {
        return pValue.getValue();
    }
}
