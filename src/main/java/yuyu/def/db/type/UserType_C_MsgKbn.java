package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_MsgKbn;

/**
 * {@link C_MsgKbn メッセージ区分} の Hibernate ユーザー定義型です。<br />
 * メッセージ区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_MsgKbn extends AbstractUserType<C_MsgKbn> {

    @Override
    protected Class<C_MsgKbn> returnType() {
        return C_MsgKbn.class;
    }

    @Override
    protected C_MsgKbn valueOf(String pValue) {
        return C_MsgKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_MsgKbn pValue) {
        return pValue.getValue();
    }
}
