package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_PmengnkksntisyKbn;

/**
 * {@link C_PmengnkksntisyKbn Ｐ免現価計算対象区分} の Hibernate ユーザー定義型です。<br />
 * Ｐ免現価計算対象区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_PmengnkksntisyKbn extends AbstractUserType<C_PmengnkksntisyKbn> {

    @Override
    protected Class<C_PmengnkksntisyKbn> returnType() {
        return C_PmengnkksntisyKbn.class;
    }

    @Override
    protected C_PmengnkksntisyKbn valueOf(String pValue) {
        return C_PmengnkksntisyKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_PmengnkksntisyKbn pValue) {
        return pValue.getValue();
    }
}
