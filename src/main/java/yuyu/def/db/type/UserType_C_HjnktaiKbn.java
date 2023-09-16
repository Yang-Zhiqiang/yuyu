package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_HjnktaiKbn;

/**
 * {@link C_HjnktaiKbn 法人形態区分} の Hibernate ユーザー定義型です。<br />
 * 法人形態区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_HjnktaiKbn extends AbstractUserType<C_HjnktaiKbn> {

    @Override
    protected Class<C_HjnktaiKbn> returnType() {
        return C_HjnktaiKbn.class;
    }

    @Override
    protected C_HjnktaiKbn valueOf(String pValue) {
        return C_HjnktaiKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_HjnktaiKbn pValue) {
        return pValue.getValue();
    }
}
