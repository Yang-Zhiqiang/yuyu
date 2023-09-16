package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_NykntratkiKbn;

/**
 * {@link C_NykntratkiKbn 入金取扱区分} の Hibernate ユーザー定義型です。<br />
 * 入金取扱区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_NykntratkiKbn extends AbstractUserType<C_NykntratkiKbn> {

    @Override
    protected Class<C_NykntratkiKbn> returnType() {
        return C_NykntratkiKbn.class;
    }

    @Override
    protected C_NykntratkiKbn valueOf(String pValue) {
        return C_NykntratkiKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_NykntratkiKbn pValue) {
        return pValue.getValue();
    }
}
