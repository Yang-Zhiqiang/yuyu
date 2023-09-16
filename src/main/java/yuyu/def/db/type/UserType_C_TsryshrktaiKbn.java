package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_TsryshrktaiKbn;

/**
 * {@link C_TsryshrktaiKbn 手数料支払形態区分} の Hibernate ユーザー定義型です。<br />
 * 手数料支払形態区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_TsryshrktaiKbn extends AbstractUserType<C_TsryshrktaiKbn> {

    @Override
    protected Class<C_TsryshrktaiKbn> returnType() {
        return C_TsryshrktaiKbn.class;
    }

    @Override
    protected C_TsryshrktaiKbn valueOf(String pValue) {
        return C_TsryshrktaiKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_TsryshrktaiKbn pValue) {
        return pValue.getValue();
    }
}
