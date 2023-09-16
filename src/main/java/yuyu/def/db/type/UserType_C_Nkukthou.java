package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_Nkukthou;

/**
 * {@link C_Nkukthou 年金受取方法} の Hibernate ユーザー定義型です。<br />
 * 年金受取方法 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_Nkukthou extends AbstractUserType<C_Nkukthou> {

    @Override
    protected Class<C_Nkukthou> returnType() {
        return C_Nkukthou.class;
    }

    @Override
    protected C_Nkukthou valueOf(String pValue) {
        return C_Nkukthou.valueOf(pValue);
    }

    @Override
    protected String toString(C_Nkukthou pValue) {
        return pValue.getValue();
    }
}
