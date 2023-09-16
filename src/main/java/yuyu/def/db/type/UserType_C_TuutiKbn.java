package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_TuutiKbn;

/**
 * {@link C_TuutiKbn 通知区分} の Hibernate ユーザー定義型です。<br />
 * 通知区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_TuutiKbn extends AbstractUserType<C_TuutiKbn> {

    @Override
    protected Class<C_TuutiKbn> returnType() {
        return C_TuutiKbn.class;
    }

    @Override
    protected C_TuutiKbn valueOf(String pValue) {
        return C_TuutiKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_TuutiKbn pValue) {
        return pValue.getValue();
    }
}
