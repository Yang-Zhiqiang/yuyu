package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_AdrdouKbn;

/**
 * {@link C_AdrdouKbn 住所同一区分} の Hibernate ユーザー定義型です。<br />
 * 住所同一区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_AdrdouKbn extends AbstractUserType<C_AdrdouKbn> {

    @Override
    protected Class<C_AdrdouKbn> returnType() {
        return C_AdrdouKbn.class;
    }

    @Override
    protected C_AdrdouKbn valueOf(String pValue) {
        return C_AdrdouKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_AdrdouKbn pValue) {
        return pValue.getValue();
    }
}
