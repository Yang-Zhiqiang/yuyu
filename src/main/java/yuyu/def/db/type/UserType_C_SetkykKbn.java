package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_SetkykKbn;

/**
 * {@link C_SetkykKbn セット契約区分} の Hibernate ユーザー定義型です。<br />
 * セット契約区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_SetkykKbn extends AbstractUserType<C_SetkykKbn> {

    @Override
    protected Class<C_SetkykKbn> returnType() {
        return C_SetkykKbn.class;
    }

    @Override
    protected C_SetkykKbn valueOf(String pValue) {
        return C_SetkykKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_SetkykKbn pValue) {
        return pValue.getValue();
    }
}
