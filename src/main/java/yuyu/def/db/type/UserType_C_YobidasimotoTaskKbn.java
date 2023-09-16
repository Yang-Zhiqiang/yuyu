package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_YobidasimotoTaskKbn;

/**
 * {@link C_YobidasimotoTaskKbn 呼出元タスク区分} の Hibernate ユーザー定義型です。<br />
 * 呼出元タスク区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_YobidasimotoTaskKbn extends AbstractUserType<C_YobidasimotoTaskKbn> {

    @Override
    protected Class<C_YobidasimotoTaskKbn> returnType() {
        return C_YobidasimotoTaskKbn.class;
    }

    @Override
    protected C_YobidasimotoTaskKbn valueOf(String pValue) {
        return C_YobidasimotoTaskKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_YobidasimotoTaskKbn pValue) {
        return pValue.getValue();
    }
}
