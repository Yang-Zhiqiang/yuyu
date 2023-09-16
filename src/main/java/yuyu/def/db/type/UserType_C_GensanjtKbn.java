package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_GensanjtKbn;

/**
 * {@link C_GensanjtKbn 減算状態区分} の Hibernate ユーザー定義型です。<br />
 * 減算状態区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_GensanjtKbn extends AbstractUserType<C_GensanjtKbn> {

    @Override
    protected Class<C_GensanjtKbn> returnType() {
        return C_GensanjtKbn.class;
    }

    @Override
    protected C_GensanjtKbn valueOf(String pValue) {
        return C_GensanjtKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_GensanjtKbn pValue) {
        return pValue.getValue();
    }
}
