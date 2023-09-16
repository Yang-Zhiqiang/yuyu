package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_MqOnlineStatusKbn;

/**
 * {@link C_MqOnlineStatusKbn ＭＱオンライン状態区分} の Hibernate ユーザー定義型です。<br />
 * ＭＱオンライン状態区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_MqOnlineStatusKbn extends AbstractUserType<C_MqOnlineStatusKbn> {

    @Override
    protected Class<C_MqOnlineStatusKbn> returnType() {
        return C_MqOnlineStatusKbn.class;
    }

    @Override
    protected C_MqOnlineStatusKbn valueOf(String pValue) {
        return C_MqOnlineStatusKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_MqOnlineStatusKbn pValue) {
        return pValue.getValue();
    }
}
