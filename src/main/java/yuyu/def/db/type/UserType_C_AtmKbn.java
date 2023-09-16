package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_AtmKbn;

/**
 * {@link C_AtmKbn ＡＴＭ区分} の Hibernate ユーザー定義型です。<br />
 * ＡＴＭ区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_AtmKbn extends AbstractUserType<C_AtmKbn> {

    @Override
    protected Class<C_AtmKbn> returnType() {
        return C_AtmKbn.class;
    }

    @Override
    protected C_AtmKbn valueOf(String pValue) {
        return C_AtmKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_AtmKbn pValue) {
        return pValue.getValue();
    }
}
