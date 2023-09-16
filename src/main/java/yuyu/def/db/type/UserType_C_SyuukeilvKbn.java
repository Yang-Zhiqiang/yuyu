package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_SyuukeilvKbn;

/**
 * {@link C_SyuukeilvKbn 集計レベル区分} の Hibernate ユーザー定義型です。<br />
 * 集計レベル区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_SyuukeilvKbn extends AbstractUserType<C_SyuukeilvKbn> {

    @Override
    protected Class<C_SyuukeilvKbn> returnType() {
        return C_SyuukeilvKbn.class;
    }

    @Override
    protected C_SyuukeilvKbn valueOf(String pValue) {
        return C_SyuukeilvKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_SyuukeilvKbn pValue) {
        return pValue.getValue();
    }
}
