package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_ShrkssyoriKbn;

/**
 * {@link C_ShrkssyoriKbn 支払後検証処理区分} の Hibernate ユーザー定義型です。<br />
 * 支払後検証処理区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_ShrkssyoriKbn extends AbstractUserType<C_ShrkssyoriKbn> {

    @Override
    protected Class<C_ShrkssyoriKbn> returnType() {
        return C_ShrkssyoriKbn.class;
    }

    @Override
    protected C_ShrkssyoriKbn valueOf(String pValue) {
        return C_ShrkssyoriKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_ShrkssyoriKbn pValue) {
        return pValue.getValue();
    }
}
