package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_YoyakuKbn;

/**
 * {@link C_YoyakuKbn 予約区分} の Hibernate ユーザー定義型です。<br />
 * 予約区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_YoyakuKbn extends AbstractUserType<C_YoyakuKbn> {

    @Override
    protected Class<C_YoyakuKbn> returnType() {
        return C_YoyakuKbn.class;
    }

    @Override
    protected C_YoyakuKbn valueOf(String pValue) {
        return C_YoyakuKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_YoyakuKbn pValue) {
        return pValue.getValue();
    }
}
