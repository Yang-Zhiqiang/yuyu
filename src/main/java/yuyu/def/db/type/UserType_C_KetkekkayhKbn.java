package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_KetkekkayhKbn;

/**
 * {@link C_KetkekkayhKbn 決定結果入力要否区分} の Hibernate ユーザー定義型です。<br />
 * 決定結果入力要否区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_KetkekkayhKbn extends AbstractUserType<C_KetkekkayhKbn> {

    @Override
    protected Class<C_KetkekkayhKbn> returnType() {
        return C_KetkekkayhKbn.class;
    }

    @Override
    protected C_KetkekkayhKbn valueOf(String pValue) {
        return C_KetkekkayhKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_KetkekkayhKbn pValue) {
        return pValue.getValue();
    }
}
