package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_ZeitratkiKbn;

/**
 * {@link C_ZeitratkiKbn 税取扱区分} の Hibernate ユーザー定義型です。<br />
 * 税取扱区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_ZeitratkiKbn extends AbstractUserType<C_ZeitratkiKbn> {

    @Override
    protected Class<C_ZeitratkiKbn> returnType() {
        return C_ZeitratkiKbn.class;
    }

    @Override
    protected C_ZeitratkiKbn valueOf(String pValue) {
        return C_ZeitratkiKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_ZeitratkiKbn pValue) {
        return pValue.getValue();
    }
}
