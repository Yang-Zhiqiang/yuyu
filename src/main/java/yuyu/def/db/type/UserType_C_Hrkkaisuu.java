package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_Hrkkaisuu;

/**
 * {@link C_Hrkkaisuu 払込回数} の Hibernate ユーザー定義型です。<br />
 * 払込回数 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_Hrkkaisuu extends AbstractUserType<C_Hrkkaisuu> {

    @Override
    protected Class<C_Hrkkaisuu> returnType() {
        return C_Hrkkaisuu.class;
    }

    @Override
    protected C_Hrkkaisuu valueOf(String pValue) {
        return C_Hrkkaisuu.valueOf(pValue);
    }

    @Override
    protected String toString(C_Hrkkaisuu pValue) {
        return pValue.getValue();
    }
}
