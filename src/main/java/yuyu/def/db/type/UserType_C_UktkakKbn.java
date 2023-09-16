package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_UktkakKbn;

/**
 * {@link C_UktkakKbn 受取人確認区分} の Hibernate ユーザー定義型です。<br />
 * 受取人確認区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_UktkakKbn extends AbstractUserType<C_UktkakKbn> {

    @Override
    protected Class<C_UktkakKbn> returnType() {
        return C_UktkakKbn.class;
    }

    @Override
    protected C_UktkakKbn valueOf(String pValue) {
        return C_UktkakKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_UktkakKbn pValue) {
        return pValue.getValue();
    }
}
