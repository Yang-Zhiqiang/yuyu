package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_Channelcd;

/**
 * {@link C_Channelcd チャネルコード} の Hibernate ユーザー定義型です。<br />
 * チャネルコード 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_Channelcd extends AbstractUserType<C_Channelcd> {

    @Override
    protected Class<C_Channelcd> returnType() {
        return C_Channelcd.class;
    }

    @Override
    protected C_Channelcd valueOf(String pValue) {
        return C_Channelcd.valueOf(pValue);
    }

    @Override
    protected String toString(C_Channelcd pValue) {
        return pValue.getValue();
    }
}
