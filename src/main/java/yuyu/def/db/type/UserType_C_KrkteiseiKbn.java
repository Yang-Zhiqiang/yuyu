package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_KrkteiseiKbn;

/**
 * {@link C_KrkteiseiKbn 仮受訂正区分} の Hibernate ユーザー定義型です。<br />
 * 仮受訂正区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_KrkteiseiKbn extends AbstractUserType<C_KrkteiseiKbn> {

    @Override
    protected Class<C_KrkteiseiKbn> returnType() {
        return C_KrkteiseiKbn.class;
    }

    @Override
    protected C_KrkteiseiKbn valueOf(String pValue) {
        return C_KrkteiseiKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_KrkteiseiKbn pValue) {
        return pValue.getValue();
    }
}
