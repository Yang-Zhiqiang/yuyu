package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_HtsiryosyuKbn;

/**
 * {@link C_HtsiryosyuKbn 法定資料種類区分} の Hibernate ユーザー定義型です。<br />
 * 法定資料種類区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_HtsiryosyuKbn extends AbstractUserType<C_HtsiryosyuKbn> {

    @Override
    protected Class<C_HtsiryosyuKbn> returnType() {
        return C_HtsiryosyuKbn.class;
    }

    @Override
    protected C_HtsiryosyuKbn valueOf(String pValue) {
        return C_HtsiryosyuKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_HtsiryosyuKbn pValue) {
        return pValue.getValue();
    }
}
