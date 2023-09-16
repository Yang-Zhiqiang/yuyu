package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_RateTuukasyuKbn;

/**
 * {@link C_RateTuukasyuKbn レート用通貨種類区分} の Hibernate ユーザー定義型です。<br />
 * レート用通貨種類区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_RateTuukasyuKbn extends AbstractUserType<C_RateTuukasyuKbn> {

    @Override
    protected Class<C_RateTuukasyuKbn> returnType() {
        return C_RateTuukasyuKbn.class;
    }

    @Override
    protected C_RateTuukasyuKbn valueOf(String pValue) {
        return C_RateTuukasyuKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_RateTuukasyuKbn pValue) {
        return pValue.getValue();
    }
}
