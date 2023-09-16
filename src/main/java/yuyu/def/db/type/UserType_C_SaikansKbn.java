package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_SaikansKbn;

/**
 * {@link C_SaikansKbn 再勧奨期間区分} の Hibernate ユーザー定義型です。<br />
 * 再勧奨期間区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_SaikansKbn extends AbstractUserType<C_SaikansKbn> {

    @Override
    protected Class<C_SaikansKbn> returnType() {
        return C_SaikansKbn.class;
    }

    @Override
    protected C_SaikansKbn valueOf(String pValue) {
        return C_SaikansKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_SaikansKbn pValue) {
        return pValue.getValue();
    }
}
