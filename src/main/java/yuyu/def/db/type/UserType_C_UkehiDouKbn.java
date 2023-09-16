package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_UkehiDouKbn;

/**
 * {@link C_UkehiDouKbn 受被同一区分} の Hibernate ユーザー定義型です。<br />
 * 受被同一区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_UkehiDouKbn extends AbstractUserType<C_UkehiDouKbn> {

    @Override
    protected Class<C_UkehiDouKbn> returnType() {
        return C_UkehiDouKbn.class;
    }

    @Override
    protected C_UkehiDouKbn valueOf(String pValue) {
        return C_UkehiDouKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_UkehiDouKbn pValue) {
        return pValue.getValue();
    }
}
