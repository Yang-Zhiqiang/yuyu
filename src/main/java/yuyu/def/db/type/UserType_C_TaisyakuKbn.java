package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_TaisyakuKbn;

/**
 * {@link C_TaisyakuKbn 貸借区分} の Hibernate ユーザー定義型です。<br />
 * 貸借区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_TaisyakuKbn extends AbstractUserType<C_TaisyakuKbn> {

    @Override
    protected Class<C_TaisyakuKbn> returnType() {
        return C_TaisyakuKbn.class;
    }

    @Override
    protected C_TaisyakuKbn valueOf(String pValue) {
        return C_TaisyakuKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_TaisyakuKbn pValue) {
        return pValue.getValue();
    }
}
