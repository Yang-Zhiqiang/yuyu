package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_DecKbn;

/**
 * {@link C_DecKbn ＤＥＣ区分} の Hibernate ユーザー定義型です。<br />
 * ＤＥＣ区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_DecKbn extends AbstractUserType<C_DecKbn> {

    @Override
    protected Class<C_DecKbn> returnType() {
        return C_DecKbn.class;
    }

    @Override
    protected C_DecKbn valueOf(String pValue) {
        return C_DecKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_DecKbn pValue) {
        return pValue.getValue();
    }
}
