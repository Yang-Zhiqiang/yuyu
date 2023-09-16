package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_Hieigyoubi;

/**
 * {@link C_Hieigyoubi 非営業日区分} の Hibernate ユーザー定義型です。<br />
 * 非営業日区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_Hieigyoubi extends AbstractUserType<C_Hieigyoubi> {

    @Override
    protected Class<C_Hieigyoubi> returnType() {
        return C_Hieigyoubi.class;
    }

    @Override
    protected C_Hieigyoubi valueOf(String pValue) {
        return C_Hieigyoubi.valueOf(pValue);
    }

    @Override
    protected String toString(C_Hieigyoubi pValue) {
        return pValue.getValue();
    }
}
