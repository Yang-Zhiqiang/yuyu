package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_NensyuuKbn;

/**
 * {@link C_NensyuuKbn 年収区分} の Hibernate ユーザー定義型です。<br />
 * 年収区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_NensyuuKbn extends AbstractUserType<C_NensyuuKbn> {

    @Override
    protected Class<C_NensyuuKbn> returnType() {
        return C_NensyuuKbn.class;
    }

    @Override
    protected C_NensyuuKbn valueOf(String pValue) {
        return C_NensyuuKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_NensyuuKbn pValue) {
        return pValue.getValue();
    }
}
