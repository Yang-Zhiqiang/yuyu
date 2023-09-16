package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_DakuhiktbunruiKbn;

/**
 * {@link C_DakuhiktbunruiKbn 諾否決定分類区分} の Hibernate ユーザー定義型です。<br />
 * 諾否決定分類区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_DakuhiktbunruiKbn extends AbstractUserType<C_DakuhiktbunruiKbn> {

    @Override
    protected Class<C_DakuhiktbunruiKbn> returnType() {
        return C_DakuhiktbunruiKbn.class;
    }

    @Override
    protected C_DakuhiktbunruiKbn valueOf(String pValue) {
        return C_DakuhiktbunruiKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_DakuhiktbunruiKbn pValue) {
        return pValue.getValue();
    }
}
