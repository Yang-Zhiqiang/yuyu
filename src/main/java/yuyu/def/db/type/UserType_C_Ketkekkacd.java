package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_Ketkekkacd;

/**
 * {@link C_Ketkekkacd 決定結果コード} の Hibernate ユーザー定義型です。<br />
 * 決定結果コード 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_Ketkekkacd extends AbstractUserType<C_Ketkekkacd> {

    @Override
    protected Class<C_Ketkekkacd> returnType() {
        return C_Ketkekkacd.class;
    }

    @Override
    protected C_Ketkekkacd valueOf(String pValue) {
        return C_Ketkekkacd.valueOf(pValue);
    }

    @Override
    protected String toString(C_Ketkekkacd pValue) {
        return pValue.getValue();
    }
}
