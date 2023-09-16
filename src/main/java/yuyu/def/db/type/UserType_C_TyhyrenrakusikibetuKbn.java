package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_TyhyrenrakusikibetuKbn;

/**
 * {@link C_TyhyrenrakusikibetuKbn 帳票連絡先識別区分} の Hibernate ユーザー定義型です。<br />
 * 帳票連絡先識別区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_TyhyrenrakusikibetuKbn extends AbstractUserType<C_TyhyrenrakusikibetuKbn> {

    @Override
    protected Class<C_TyhyrenrakusikibetuKbn> returnType() {
        return C_TyhyrenrakusikibetuKbn.class;
    }

    @Override
    protected C_TyhyrenrakusikibetuKbn valueOf(String pValue) {
        return C_TyhyrenrakusikibetuKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_TyhyrenrakusikibetuKbn pValue) {
        return pValue.getValue();
    }
}
