package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_Kinkyuuteisiflag;

/**
 * {@link C_Kinkyuuteisiflag 緊急停止フラグ} の Hibernate ユーザー定義型です。<br />
 * 緊急停止フラグ 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_Kinkyuuteisiflag extends AbstractUserType<C_Kinkyuuteisiflag> {

    @Override
    protected Class<C_Kinkyuuteisiflag> returnType() {
        return C_Kinkyuuteisiflag.class;
    }

    @Override
    protected C_Kinkyuuteisiflag valueOf(String pValue) {
        return C_Kinkyuuteisiflag.valueOf(pValue);
    }

    @Override
    protected String toString(C_Kinkyuuteisiflag pValue) {
        return pValue.getValue();
    }
}
