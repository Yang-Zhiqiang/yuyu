package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_KetrankKbn;

/**
 * {@link C_KetrankKbn 決定ランク区分} の Hibernate ユーザー定義型です。<br />
 * 決定ランク区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_KetrankKbn extends AbstractUserType<C_KetrankKbn> {

    @Override
    protected Class<C_KetrankKbn> returnType() {
        return C_KetrankKbn.class;
    }

    @Override
    protected C_KetrankKbn valueOf(String pValue) {
        return C_KetrankKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_KetrankKbn pValue) {
        return pValue.getValue();
    }
}
