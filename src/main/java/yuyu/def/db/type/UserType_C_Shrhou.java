package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_Shrhou;

/**
 * {@link C_Shrhou 支払方法} の Hibernate ユーザー定義型です。<br />
 * 支払方法 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_Shrhou extends AbstractUserType<C_Shrhou> {

    @Override
    protected Class<C_Shrhou> returnType() {
        return C_Shrhou.class;
    }

    @Override
    protected C_Shrhou valueOf(String pValue) {
        return C_Shrhou.valueOf(pValue);
    }

    @Override
    protected String toString(C_Shrhou pValue) {
        return pValue.getValue();
    }
}
