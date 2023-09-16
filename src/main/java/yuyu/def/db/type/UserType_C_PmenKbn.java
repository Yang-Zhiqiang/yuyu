package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_PmenKbn;

/**
 * {@link C_PmenKbn Ｐ免区分} の Hibernate ユーザー定義型です。<br />
 * Ｐ免区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_PmenKbn extends AbstractUserType<C_PmenKbn> {

    @Override
    protected Class<C_PmenKbn> returnType() {
        return C_PmenKbn.class;
    }

    @Override
    protected C_PmenKbn valueOf(String pValue) {
        return C_PmenKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_PmenKbn pValue) {
        return pValue.getValue();
    }
}
