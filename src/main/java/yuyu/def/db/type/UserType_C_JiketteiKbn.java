package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_JiketteiKbn;

/**
 * {@link C_JiketteiKbn 事業一括決定状態区分} の Hibernate ユーザー定義型です。<br />
 * 事業一括決定状態区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_JiketteiKbn extends AbstractUserType<C_JiketteiKbn> {

    @Override
    protected Class<C_JiketteiKbn> returnType() {
        return C_JiketteiKbn.class;
    }

    @Override
    protected C_JiketteiKbn valueOf(String pValue) {
        return C_JiketteiKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_JiketteiKbn pValue) {
        return pValue.getValue();
    }
}
