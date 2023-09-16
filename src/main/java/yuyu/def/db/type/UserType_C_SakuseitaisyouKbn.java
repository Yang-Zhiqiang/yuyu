package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_SakuseitaisyouKbn;

/**
 * {@link C_SakuseitaisyouKbn 作成対象区分} の Hibernate ユーザー定義型です。<br />
 * 作成対象区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_SakuseitaisyouKbn extends AbstractUserType<C_SakuseitaisyouKbn> {

    @Override
    protected Class<C_SakuseitaisyouKbn> returnType() {
        return C_SakuseitaisyouKbn.class;
    }

    @Override
    protected C_SakuseitaisyouKbn valueOf(String pValue) {
        return C_SakuseitaisyouKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_SakuseitaisyouKbn pValue) {
        return pValue.getValue();
    }
}
