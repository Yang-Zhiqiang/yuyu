package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_NyktyhyoutKbn;

/**
 * {@link C_NyktyhyoutKbn 入金帳票出力先区分} の Hibernate ユーザー定義型です。<br />
 * 入金帳票出力先区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_NyktyhyoutKbn extends AbstractUserType<C_NyktyhyoutKbn> {

    @Override
    protected Class<C_NyktyhyoutKbn> returnType() {
        return C_NyktyhyoutKbn.class;
    }

    @Override
    protected C_NyktyhyoutKbn valueOf(String pValue) {
        return C_NyktyhyoutKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_NyktyhyoutKbn pValue) {
        return pValue.getValue();
    }
}
