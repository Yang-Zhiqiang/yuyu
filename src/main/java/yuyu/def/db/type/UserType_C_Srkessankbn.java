package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_Srkessankbn;

/**
 * {@link C_Srkessankbn 数理決算区分} の Hibernate ユーザー定義型です。<br />
 * 数理決算区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_Srkessankbn extends AbstractUserType<C_Srkessankbn> {

    @Override
    protected Class<C_Srkessankbn> returnType() {
        return C_Srkessankbn.class;
    }

    @Override
    protected C_Srkessankbn valueOf(String pValue) {
        return C_Srkessankbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_Srkessankbn pValue) {
        return pValue.getValue();
    }
}
