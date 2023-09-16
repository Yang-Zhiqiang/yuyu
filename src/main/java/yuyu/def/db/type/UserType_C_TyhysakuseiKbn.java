package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_TyhysakuseiKbn;

/**
 * {@link C_TyhysakuseiKbn 帳票作成状態区分} の Hibernate ユーザー定義型です。<br />
 * 帳票作成状態区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_TyhysakuseiKbn extends AbstractUserType<C_TyhysakuseiKbn> {

    @Override
    protected Class<C_TyhysakuseiKbn> returnType() {
        return C_TyhysakuseiKbn.class;
    }

    @Override
    protected C_TyhysakuseiKbn valueOf(String pValue) {
        return C_TyhysakuseiKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_TyhysakuseiKbn pValue) {
        return pValue.getValue();
    }
}
