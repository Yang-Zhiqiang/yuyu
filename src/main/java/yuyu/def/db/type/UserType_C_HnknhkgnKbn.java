package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_HnknhkgnKbn;

/**
 * {@link C_HnknhkgnKbn 変換復元区分} の Hibernate ユーザー定義型です。<br />
 * 変換復元区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_HnknhkgnKbn extends AbstractUserType<C_HnknhkgnKbn> {

    @Override
    protected Class<C_HnknhkgnKbn> returnType() {
        return C_HnknhkgnKbn.class;
    }

    @Override
    protected C_HnknhkgnKbn valueOf(String pValue) {
        return C_HnknhkgnKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_HnknhkgnKbn pValue) {
        return pValue.getValue();
    }
}
