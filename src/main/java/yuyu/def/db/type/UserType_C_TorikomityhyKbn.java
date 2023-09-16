package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_TorikomityhyKbn;

/**
 * {@link C_TorikomityhyKbn 取込帳票区分} の Hibernate ユーザー定義型です。<br />
 * 取込帳票区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_TorikomityhyKbn extends AbstractUserType<C_TorikomityhyKbn> {

    @Override
    protected Class<C_TorikomityhyKbn> returnType() {
        return C_TorikomityhyKbn.class;
    }

    @Override
    protected C_TorikomityhyKbn valueOf(String pValue) {
        return C_TorikomityhyKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_TorikomityhyKbn pValue) {
        return pValue.getValue();
    }
}
