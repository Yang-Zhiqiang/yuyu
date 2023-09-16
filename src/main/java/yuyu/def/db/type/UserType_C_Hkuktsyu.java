package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_Hkuktsyu;

/**
 * {@link C_Hkuktsyu 給付金受取人種類区分} の Hibernate ユーザー定義型です。<br />
 * 給付金受取人種類区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_Hkuktsyu extends AbstractUserType<C_Hkuktsyu> {

    @Override
    protected Class<C_Hkuktsyu> returnType() {
        return C_Hkuktsyu.class;
    }

    @Override
    protected C_Hkuktsyu valueOf(String pValue) {
        return C_Hkuktsyu.valueOf(pValue);
    }

    @Override
    protected String toString(C_Hkuktsyu pValue) {
        return pValue.getValue();
    }
}
