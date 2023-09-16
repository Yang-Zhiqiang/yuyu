package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_SuuriIdoKbn;

/**
 * {@link C_SuuriIdoKbn 数理異動区分} の Hibernate ユーザー定義型です。<br />
 * 数理異動区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_SuuriIdoKbn extends AbstractUserType<C_SuuriIdoKbn> {

    @Override
    protected Class<C_SuuriIdoKbn> returnType() {
        return C_SuuriIdoKbn.class;
    }

    @Override
    protected C_SuuriIdoKbn valueOf(String pValue) {
        return C_SuuriIdoKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_SuuriIdoKbn pValue) {
        return pValue.getValue();
    }
}
