package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_HnkzengoKbn;

/**
 * {@link C_HnkzengoKbn 変更前後区分} の Hibernate ユーザー定義型です。<br />
 * 変更前後区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_HnkzengoKbn extends AbstractUserType<C_HnkzengoKbn> {

    @Override
    protected Class<C_HnkzengoKbn> returnType() {
        return C_HnkzengoKbn.class;
    }

    @Override
    protected C_HnkzengoKbn valueOf(String pValue) {
        return C_HnkzengoKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_HnkzengoKbn pValue) {
        return pValue.getValue();
    }
}
