package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_JimusrhKbn;

/**
 * {@link C_JimusrhKbn 事務成立保留区分} の Hibernate ユーザー定義型です。<br />
 * 事務成立保留区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_JimusrhKbn extends AbstractUserType<C_JimusrhKbn> {

    @Override
    protected Class<C_JimusrhKbn> returnType() {
        return C_JimusrhKbn.class;
    }

    @Override
    protected C_JimusrhKbn valueOf(String pValue) {
        return C_JimusrhKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_JimusrhKbn pValue) {
        return pValue.getValue();
    }
}
