package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_TuutiJkKbn;

/**
 * {@link C_TuutiJkKbn 通知状況区分} の Hibernate ユーザー定義型です。<br />
 * 通知状況区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_TuutiJkKbn extends AbstractUserType<C_TuutiJkKbn> {

    @Override
    protected Class<C_TuutiJkKbn> returnType() {
        return C_TuutiJkKbn.class;
    }

    @Override
    protected C_TuutiJkKbn valueOf(String pValue) {
        return C_TuutiJkKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_TuutiJkKbn pValue) {
        return pValue.getValue();
    }
}
