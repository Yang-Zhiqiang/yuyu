package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_Ketriyuucd;

/**
 * {@link C_Ketriyuucd 決定理由コード} の Hibernate ユーザー定義型です。<br />
 * 決定理由コード 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_Ketriyuucd extends AbstractUserType<C_Ketriyuucd> {

    @Override
    protected Class<C_Ketriyuucd> returnType() {
        return C_Ketriyuucd.class;
    }

    @Override
    protected C_Ketriyuucd valueOf(String pValue) {
        return C_Ketriyuucd.valueOf(pValue);
    }

    @Override
    protected String toString(C_Ketriyuucd pValue) {
        return pValue.getValue();
    }
}
