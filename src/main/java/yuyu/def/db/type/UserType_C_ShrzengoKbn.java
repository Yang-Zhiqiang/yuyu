package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_ShrzengoKbn;

/**
 * {@link C_ShrzengoKbn 支払前後区分} の Hibernate ユーザー定義型です。<br />
 * 支払前後区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_ShrzengoKbn extends AbstractUserType<C_ShrzengoKbn> {

    @Override
    protected Class<C_ShrzengoKbn> returnType() {
        return C_ShrzengoKbn.class;
    }

    @Override
    protected C_ShrzengoKbn valueOf(String pValue) {
        return C_ShrzengoKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_ShrzengoKbn pValue) {
        return pValue.getValue();
    }
}
