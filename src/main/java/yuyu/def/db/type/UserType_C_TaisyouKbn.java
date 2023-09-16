package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_TaisyouKbn;

/**
 * {@link C_TaisyouKbn 対象区分} の Hibernate ユーザー定義型です。<br />
 * 対象区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_TaisyouKbn extends AbstractUserType<C_TaisyouKbn> {

    @Override
    protected Class<C_TaisyouKbn> returnType() {
        return C_TaisyouKbn.class;
    }

    @Override
    protected C_TaisyouKbn valueOf(String pValue) {
        return C_TaisyouKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_TaisyouKbn pValue) {
        return pValue.getValue();
    }
}
