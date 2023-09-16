package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_SyosaiKbn;

/**
 * {@link C_SyosaiKbn 初診再診区分} の Hibernate ユーザー定義型です。<br />
 * 初診再診区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_SyosaiKbn extends AbstractUserType<C_SyosaiKbn> {

    @Override
    protected Class<C_SyosaiKbn> returnType() {
        return C_SyosaiKbn.class;
    }

    @Override
    protected C_SyosaiKbn valueOf(String pValue) {
        return C_SyosaiKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_SyosaiKbn pValue) {
        return pValue.getValue();
    }
}
