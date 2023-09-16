package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_Gyousyucd;

/**
 * {@link C_Gyousyucd 業種コード} の Hibernate ユーザー定義型です。<br />
 * 業種コード 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_Gyousyucd extends AbstractUserType<C_Gyousyucd> {

    @Override
    protected Class<C_Gyousyucd> returnType() {
        return C_Gyousyucd.class;
    }

    @Override
    protected C_Gyousyucd valueOf(String pValue) {
        return C_Gyousyucd.valueOf(pValue);
    }

    @Override
    protected String toString(C_Gyousyucd pValue) {
        return pValue.getValue();
    }
}
