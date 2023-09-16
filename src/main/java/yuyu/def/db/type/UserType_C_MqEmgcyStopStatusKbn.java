package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_MqEmgcyStopStatusKbn;

/**
 * {@link C_MqEmgcyStopStatusKbn ＭＱ緊急停止状態区分} の Hibernate ユーザー定義型です。<br />
 * ＭＱ緊急停止状態区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_MqEmgcyStopStatusKbn extends AbstractUserType<C_MqEmgcyStopStatusKbn> {

    @Override
    protected Class<C_MqEmgcyStopStatusKbn> returnType() {
        return C_MqEmgcyStopStatusKbn.class;
    }

    @Override
    protected C_MqEmgcyStopStatusKbn valueOf(String pValue) {
        return C_MqEmgcyStopStatusKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_MqEmgcyStopStatusKbn pValue) {
        return pValue.getValue();
    }
}
