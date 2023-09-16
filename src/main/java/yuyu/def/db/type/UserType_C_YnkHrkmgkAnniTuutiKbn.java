package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_YnkHrkmgkAnniTuutiKbn;

/**
 * {@link C_YnkHrkmgkAnniTuutiKbn 円貨払込額案内通知区分} の Hibernate ユーザー定義型です。<br />
 * 円貨払込額案内通知区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_YnkHrkmgkAnniTuutiKbn extends AbstractUserType<C_YnkHrkmgkAnniTuutiKbn> {

    @Override
    protected Class<C_YnkHrkmgkAnniTuutiKbn> returnType() {
        return C_YnkHrkmgkAnniTuutiKbn.class;
    }

    @Override
    protected C_YnkHrkmgkAnniTuutiKbn valueOf(String pValue) {
        return C_YnkHrkmgkAnniTuutiKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_YnkHrkmgkAnniTuutiKbn pValue) {
        return pValue.getValue();
    }
}
