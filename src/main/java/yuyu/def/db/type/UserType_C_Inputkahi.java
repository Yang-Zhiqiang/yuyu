package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_Inputkahi;

/**
 * {@link C_Inputkahi 入力可否区分} の Hibernate ユーザー定義型です。<br />
 * 入力可否区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_Inputkahi extends AbstractUserType<C_Inputkahi> {

    @Override
    protected Class<C_Inputkahi> returnType() {
        return C_Inputkahi.class;
    }

    @Override
    protected C_Inputkahi valueOf(String pValue) {
        return C_Inputkahi.valueOf(pValue);
    }

    @Override
    protected String toString(C_Inputkahi pValue) {
        return pValue.getValue();
    }
}
