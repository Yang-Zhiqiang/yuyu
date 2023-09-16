package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_RenkeiyouhiKbn;

/**
 * {@link C_RenkeiyouhiKbn 連携要否区分} の Hibernate ユーザー定義型です。<br />
 * 連携要否区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_RenkeiyouhiKbn extends AbstractUserType<C_RenkeiyouhiKbn> {

    @Override
    protected Class<C_RenkeiyouhiKbn> returnType() {
        return C_RenkeiyouhiKbn.class;
    }

    @Override
    protected C_RenkeiyouhiKbn valueOf(String pValue) {
        return C_RenkeiyouhiKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_RenkeiyouhiKbn pValue) {
        return pValue.getValue();
    }
}
