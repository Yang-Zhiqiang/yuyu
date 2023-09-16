package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_DsBatchKadouKnkKbn;

/**
 * {@link C_DsBatchKadouKnkKbn ＤＳバッチ稼働環境区分} の Hibernate ユーザー定義型です。<br />
 * ＤＳバッチ稼働環境区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_DsBatchKadouKnkKbn extends AbstractUserType<C_DsBatchKadouKnkKbn> {

    @Override
    protected Class<C_DsBatchKadouKnkKbn> returnType() {
        return C_DsBatchKadouKnkKbn.class;
    }

    @Override
    protected C_DsBatchKadouKnkKbn valueOf(String pValue) {
        return C_DsBatchKadouKnkKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_DsBatchKadouKnkKbn pValue) {
        return pValue.getValue();
    }
}
