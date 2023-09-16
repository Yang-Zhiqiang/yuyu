package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_KykktaiKbn;

/**
 * {@link C_KykktaiKbn 契約形態区分} の Hibernate ユーザー定義型です。<br />
 * 契約形態区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_KykktaiKbn extends AbstractUserType<C_KykktaiKbn> {

    @Override
    protected Class<C_KykktaiKbn> returnType() {
        return C_KykktaiKbn.class;
    }

    @Override
    protected C_KykktaiKbn valueOf(String pValue) {
        return C_KykktaiKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_KykktaiKbn pValue) {
        return pValue.getValue();
    }
}
