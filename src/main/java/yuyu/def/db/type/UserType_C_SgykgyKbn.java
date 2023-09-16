package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_SgykgyKbn;

/**
 * {@link C_SgykgyKbn 専業兼業区分} の Hibernate ユーザー定義型です。<br />
 * 専業兼業区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_SgykgyKbn extends AbstractUserType<C_SgykgyKbn> {

    @Override
    protected Class<C_SgykgyKbn> returnType() {
        return C_SgykgyKbn.class;
    }

    @Override
    protected C_SgykgyKbn valueOf(String pValue) {
        return C_SgykgyKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_SgykgyKbn pValue) {
        return pValue.getValue();
    }
}
