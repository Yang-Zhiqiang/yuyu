package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_TuutisakuseitaisyouKbn;

/**
 * {@link C_TuutisakuseitaisyouKbn 通知作成対象者区分} の Hibernate ユーザー定義型です。<br />
 * 通知作成対象者区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_TuutisakuseitaisyouKbn extends AbstractUserType<C_TuutisakuseitaisyouKbn> {

    @Override
    protected Class<C_TuutisakuseitaisyouKbn> returnType() {
        return C_TuutisakuseitaisyouKbn.class;
    }

    @Override
    protected C_TuutisakuseitaisyouKbn valueOf(String pValue) {
        return C_TuutisakuseitaisyouKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_TuutisakuseitaisyouKbn pValue) {
        return pValue.getValue();
    }
}
