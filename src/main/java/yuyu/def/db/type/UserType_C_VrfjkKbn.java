package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_VrfjkKbn;

/**
 * {@link C_VrfjkKbn ベリファイ状況区分} の Hibernate ユーザー定義型です。<br />
 * ベリファイ状況区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_VrfjkKbn extends AbstractUserType<C_VrfjkKbn> {

    @Override
    protected Class<C_VrfjkKbn> returnType() {
        return C_VrfjkKbn.class;
    }

    @Override
    protected C_VrfjkKbn valueOf(String pValue) {
        return C_VrfjkKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_VrfjkKbn pValue) {
        return pValue.getValue();
    }
}
