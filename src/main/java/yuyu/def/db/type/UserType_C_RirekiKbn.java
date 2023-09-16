package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_RirekiKbn;

/**
 * {@link C_RirekiKbn 履歴区分} の Hibernate ユーザー定義型です。<br />
 * 履歴区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_RirekiKbn extends AbstractUserType<C_RirekiKbn> {

    @Override
    protected Class<C_RirekiKbn> returnType() {
        return C_RirekiKbn.class;
    }

    @Override
    protected C_RirekiKbn valueOf(String pValue) {
        return C_RirekiKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_RirekiKbn pValue) {
        return pValue.getValue();
    }
}
