package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_TyhysakuseiyhKbn;

/**
 * {@link C_TyhysakuseiyhKbn 帳票作成要否区分} の Hibernate ユーザー定義型です。<br />
 * 帳票作成要否区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_TyhysakuseiyhKbn extends AbstractUserType<C_TyhysakuseiyhKbn> {

    @Override
    protected Class<C_TyhysakuseiyhKbn> returnType() {
        return C_TyhysakuseiyhKbn.class;
    }

    @Override
    protected C_TyhysakuseiyhKbn valueOf(String pValue) {
        return C_TyhysakuseiyhKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_TyhysakuseiyhKbn pValue) {
        return pValue.getValue();
    }
}
