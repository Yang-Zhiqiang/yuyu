package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_KeiriyendthnkKbn;

/**
 * {@link C_KeiriyendthnkKbn 経理用円建変更区分} の Hibernate ユーザー定義型です。<br />
 * 経理用円建変更区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_KeiriyendthnkKbn extends AbstractUserType<C_KeiriyendthnkKbn> {

    @Override
    protected Class<C_KeiriyendthnkKbn> returnType() {
        return C_KeiriyendthnkKbn.class;
    }

    @Override
    protected C_KeiriyendthnkKbn valueOf(String pValue) {
        return C_KeiriyendthnkKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_KeiriyendthnkKbn pValue) {
        return pValue.getValue();
    }
}
