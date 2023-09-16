package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_LincjkKbn;

/**
 * {@link C_LincjkKbn ＬＩＮＣ状況区分} の Hibernate ユーザー定義型です。<br />
 * ＬＩＮＣ状況区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_LincjkKbn extends AbstractUserType<C_LincjkKbn> {

    @Override
    protected Class<C_LincjkKbn> returnType() {
        return C_LincjkKbn.class;
    }

    @Override
    protected C_LincjkKbn valueOf(String pValue) {
        return C_LincjkKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_LincjkKbn pValue) {
        return pValue.getValue();
    }
}
