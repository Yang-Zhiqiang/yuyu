package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_Inputtype;

/**
 * {@link C_Inputtype 入力形式区分} の Hibernate ユーザー定義型です。<br />
 * 入力形式区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_Inputtype extends AbstractUserType<C_Inputtype> {

    @Override
    protected Class<C_Inputtype> returnType() {
        return C_Inputtype.class;
    }

    @Override
    protected C_Inputtype valueOf(String pValue) {
        return C_Inputtype.valueOf(pValue);
    }

    @Override
    protected String toString(C_Inputtype pValue) {
        return pValue.getValue();
    }
}
