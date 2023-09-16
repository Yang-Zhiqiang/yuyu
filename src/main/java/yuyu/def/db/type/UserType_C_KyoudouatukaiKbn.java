package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_KyoudouatukaiKbn;

/**
 * {@link C_KyoudouatukaiKbn 共同扱区分} の Hibernate ユーザー定義型です。<br />
 * 共同扱区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_KyoudouatukaiKbn extends AbstractUserType<C_KyoudouatukaiKbn> {

    @Override
    protected Class<C_KyoudouatukaiKbn> returnType() {
        return C_KyoudouatukaiKbn.class;
    }

    @Override
    protected C_KyoudouatukaiKbn valueOf(String pValue) {
        return C_KyoudouatukaiKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_KyoudouatukaiKbn pValue) {
        return pValue.getValue();
    }
}
