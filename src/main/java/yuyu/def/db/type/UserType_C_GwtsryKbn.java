package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_GwtsryKbn;

/**
 * {@link C_GwtsryKbn ＧＷ手数料区分} の Hibernate ユーザー定義型です。<br />
 * ＧＷ手数料区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_GwtsryKbn extends AbstractUserType<C_GwtsryKbn> {

    @Override
    protected Class<C_GwtsryKbn> returnType() {
        return C_GwtsryKbn.class;
    }

    @Override
    protected C_GwtsryKbn valueOf(String pValue) {
        return C_GwtsryKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_GwtsryKbn pValue) {
        return pValue.getValue();
    }
}
