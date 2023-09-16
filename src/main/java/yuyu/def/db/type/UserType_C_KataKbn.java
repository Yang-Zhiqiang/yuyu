package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_KataKbn;

/**
 * {@link C_KataKbn 型区分} の Hibernate ユーザー定義型です。<br />
 * 型区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_KataKbn extends AbstractUserType<C_KataKbn> {

    @Override
    protected Class<C_KataKbn> returnType() {
        return C_KataKbn.class;
    }

    @Override
    protected C_KataKbn valueOf(String pValue) {
        return C_KataKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_KataKbn pValue) {
        return pValue.getValue();
    }
}
