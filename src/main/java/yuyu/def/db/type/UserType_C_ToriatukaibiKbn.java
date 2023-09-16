package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_ToriatukaibiKbn;

/**
 * {@link C_ToriatukaibiKbn 取扱日区分} の Hibernate ユーザー定義型です。<br />
 * 取扱日区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_ToriatukaibiKbn extends AbstractUserType<C_ToriatukaibiKbn> {

    @Override
    protected Class<C_ToriatukaibiKbn> returnType() {
        return C_ToriatukaibiKbn.class;
    }

    @Override
    protected C_ToriatukaibiKbn valueOf(String pValue) {
        return C_ToriatukaibiKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_ToriatukaibiKbn pValue) {
        return pValue.getValue();
    }
}
