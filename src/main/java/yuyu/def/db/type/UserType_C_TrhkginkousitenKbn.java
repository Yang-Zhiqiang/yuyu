package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_TrhkginkousitenKbn;

/**
 * {@link C_TrhkginkousitenKbn 取引銀行支店区分} の Hibernate ユーザー定義型です。<br />
 * 取引銀行支店区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_TrhkginkousitenKbn extends AbstractUserType<C_TrhkginkousitenKbn> {

    @Override
    protected Class<C_TrhkginkousitenKbn> returnType() {
        return C_TrhkginkousitenKbn.class;
    }

    @Override
    protected C_TrhkginkousitenKbn valueOf(String pValue) {
        return C_TrhkginkousitenKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_TrhkginkousitenKbn pValue) {
        return pValue.getValue();
    }
}
