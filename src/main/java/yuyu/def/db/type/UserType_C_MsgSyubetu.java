package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_MsgSyubetu;

/**
 * {@link C_MsgSyubetu メッセージ種別} の Hibernate ユーザー定義型です。<br />
 * メッセージ種別 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_MsgSyubetu extends AbstractUserType<C_MsgSyubetu> {

    @Override
    protected Class<C_MsgSyubetu> returnType() {
        return C_MsgSyubetu.class;
    }

    @Override
    protected C_MsgSyubetu valueOf(String pValue) {
        return C_MsgSyubetu.valueOf(pValue);
    }

    @Override
    protected String toString(C_MsgSyubetu pValue) {
        return pValue.getValue();
    }
}
