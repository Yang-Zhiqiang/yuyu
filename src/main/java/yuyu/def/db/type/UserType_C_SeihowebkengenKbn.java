package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_SeihowebkengenKbn;

/**
 * {@link C_SeihowebkengenKbn 生保Ｗｅｂ権限区分} の Hibernate ユーザー定義型です。<br />
 * 生保Ｗｅｂ権限区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_SeihowebkengenKbn extends AbstractUserType<C_SeihowebkengenKbn> {

    @Override
    protected Class<C_SeihowebkengenKbn> returnType() {
        return C_SeihowebkengenKbn.class;
    }

    @Override
    protected C_SeihowebkengenKbn valueOf(String pValue) {
        return C_SeihowebkengenKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_SeihowebkengenKbn pValue) {
        return pValue.getValue();
    }
}
