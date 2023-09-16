package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_DispKbn;

/**
 * {@link C_DispKbn 表示区分} の Hibernate ユーザー定義型です。<br />
 * 表示区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_DispKbn extends AbstractUserType<C_DispKbn> {

    @Override
    protected Class<C_DispKbn> returnType() {
        return C_DispKbn.class;
    }

    @Override
    protected C_DispKbn valueOf(String pValue) {
        return C_DispKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_DispKbn pValue) {
        return pValue.getValue();
    }
}
