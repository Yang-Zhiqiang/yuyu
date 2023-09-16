package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_Creditbrerrorcd;

/**
 * {@link C_Creditbrerrorcd クレジット払エラーコード} の Hibernate ユーザー定義型です。<br />
 * クレジット払エラーコード 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_Creditbrerrorcd extends AbstractUserType<C_Creditbrerrorcd> {

    @Override
    protected Class<C_Creditbrerrorcd> returnType() {
        return C_Creditbrerrorcd.class;
    }

    @Override
    protected C_Creditbrerrorcd valueOf(String pValue) {
        return C_Creditbrerrorcd.valueOf(pValue);
    }

    @Override
    protected String toString(C_Creditbrerrorcd pValue) {
        return pValue.getValue();
    }
}
