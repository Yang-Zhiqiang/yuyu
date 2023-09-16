package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_TaskKbn;

/**
 * {@link C_TaskKbn タスク区分} の Hibernate ユーザー定義型です。<br />
 * タスク区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_TaskKbn extends AbstractUserType<C_TaskKbn> {

    @Override
    protected Class<C_TaskKbn> returnType() {
        return C_TaskKbn.class;
    }

    @Override
    protected C_TaskKbn valueOf(String pValue) {
        return C_TaskKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_TaskKbn pValue) {
        return pValue.getValue();
    }
}
