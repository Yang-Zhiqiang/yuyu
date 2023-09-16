package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_IdCdKbn;

/**
 * {@link C_IdCdKbn ＩＤ区分} の Hibernate ユーザー定義型です。<br />
 * ＩＤ区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_IdCdKbn extends AbstractUserType<C_IdCdKbn> {

    @Override
    protected Class<C_IdCdKbn> returnType() {
        return C_IdCdKbn.class;
    }

    @Override
    protected C_IdCdKbn valueOf(String pValue) {
        return C_IdCdKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_IdCdKbn pValue) {
        return pValue.getValue();
    }
}
