package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_IkkatubaraiKbn;

/**
 * {@link C_IkkatubaraiKbn 一括払区分} の Hibernate ユーザー定義型です。<br />
 * 一括払区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_IkkatubaraiKbn extends AbstractUserType<C_IkkatubaraiKbn> {

    @Override
    protected Class<C_IkkatubaraiKbn> returnType() {
        return C_IkkatubaraiKbn.class;
    }

    @Override
    protected C_IkkatubaraiKbn valueOf(String pValue) {
        return C_IkkatubaraiKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_IkkatubaraiKbn pValue) {
        return pValue.getValue();
    }
}
