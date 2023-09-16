package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_SptkbttratkihouKbn;

/**
 * {@link C_SptkbttratkihouKbn SP特別取扱方法区分} の Hibernate ユーザー定義型です。<br />
 * SP特別取扱方法区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_SptkbttratkihouKbn extends AbstractUserType<C_SptkbttratkihouKbn> {

    @Override
    protected Class<C_SptkbttratkihouKbn> returnType() {
        return C_SptkbttratkihouKbn.class;
    }

    @Override
    protected C_SptkbttratkihouKbn valueOf(String pValue) {
        return C_SptkbttratkihouKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_SptkbttratkihouKbn pValue) {
        return pValue.getValue();
    }
}
