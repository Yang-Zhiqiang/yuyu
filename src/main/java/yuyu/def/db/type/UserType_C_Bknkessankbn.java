package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_Bknkessankbn;

/**
 * {@link C_Bknkessankbn 備金決算区分} の Hibernate ユーザー定義型です。<br />
 * 備金決算区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_Bknkessankbn extends AbstractUserType<C_Bknkessankbn> {

    @Override
    protected Class<C_Bknkessankbn> returnType() {
        return C_Bknkessankbn.class;
    }

    @Override
    protected C_Bknkessankbn valueOf(String pValue) {
        return C_Bknkessankbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_Bknkessankbn pValue) {
        return pValue.getValue();
    }
}
