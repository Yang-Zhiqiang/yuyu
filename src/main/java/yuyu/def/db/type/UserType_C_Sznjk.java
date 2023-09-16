package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_Sznjk;

/**
 * {@link C_Sznjk 生存状況} の Hibernate ユーザー定義型です。<br />
 * 生存状況 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_Sznjk extends AbstractUserType<C_Sznjk> {

    @Override
    protected Class<C_Sznjk> returnType() {
        return C_Sznjk.class;
    }

    @Override
    protected C_Sznjk valueOf(String pValue) {
        return C_Sznjk.valueOf(pValue);
    }

    @Override
    protected String toString(C_Sznjk pValue) {
        return pValue.getValue();
    }
}
