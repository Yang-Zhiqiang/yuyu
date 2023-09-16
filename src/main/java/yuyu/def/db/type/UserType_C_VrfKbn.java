package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_VrfKbn;

/**
 * {@link C_VrfKbn ベリファイ区分} の Hibernate ユーザー定義型です。<br />
 * ベリファイ区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_VrfKbn extends AbstractUserType<C_VrfKbn> {

    @Override
    protected Class<C_VrfKbn> returnType() {
        return C_VrfKbn.class;
    }

    @Override
    protected C_VrfKbn valueOf(String pValue) {
        return C_VrfKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_VrfKbn pValue) {
        return pValue.getValue();
    }
}
